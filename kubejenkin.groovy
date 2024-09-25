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
                sh 'docker build -t gshukla123/jenkindemoapp:${DOCKER_TAG}'
            }
        }

    }
}
