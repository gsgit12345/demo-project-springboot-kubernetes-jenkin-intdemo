pipeline {
    agent any
    environment
            {
                DOCKER_TAG=getDockerTag()
            }
    stages {
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
     }
}

def  getDockerTag()
{
def tag= sh script:'git rev-parse HEAD',returnStdout:true
return tag;
}
