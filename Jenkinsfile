pipeline {
    agent any
    environment
            {
                DOCKER_TAG=getDockerTag()
            }
    stages {
            stage('MANEN-BUILD') {
                steps {
                    sh '''
                   export MAVEN_HOME=/usr/local/apache-maven
                    export PATH=$PATH:$MAVEN_HOME/bin
                   mvn --version
                   mvn clean package
                   '''
                }
            }
        stage('build-dockerimage') {
            steps {
                echo 'Hello World building the dockerimage'
                //sh 'sudo usermod -a -G docker jenkins'
                sh 'cd ..'
                sh 'docker build . -t gshukla123/jenkindemoapp:${DOCKER_TAG}'
            }
        }
          stage('Push-docker-image') {
                steps {
                withCredentials([string(credentialsId: 'dockercred', variable: 'dockerpwd')]) {
                sh 'docker login -u gshukla123 -p ${dockerpwd}'
                 sh 'docker push gshukla123/jenkindemoapp:${DOCKER_TAG}'

                }
            }
        }
        stage('Deploy Kubernetes') {
              steps {
              sh 'pwd'
              sh 'ls -a'
               sh 'cd kube/'
               sh 'ls -a'
               sh 'ssh scp -o StrictHostKeyChecking=no appdeployment.yaml  iid@127.0.0.1:/home/iid/kubeapp/'

               script{
               try
               {
               sh 'pwd'
               sh 'kubectl apply -f appdeployment.yaml'
               sh 'kubectl apply -f service.yaml'
               }catch(error)
               {
               sh 'kubectl create -f appdeployment.yaml'
               sh 'kubectl apply -f service.yaml'
               }
               }
              }
          }
     }
}

def  getDockerTag()
{
def tag= sh script:'git rev-parse HEAD',returnStdout:true
return tag;
}
