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
                sh 'sudo usermod -a -G docker jenkins'
                sh 'docker build . -t gshukla123/jenkindemoapp:${DOCKER_TAG}'
            }
        }

    }
}

def  getDockerTag()
{
def tag= sh script:'git rev-parse HEAD',returnStdout:true
return tag;
}