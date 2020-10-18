pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..from github test'
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..from github jenkins file'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying.... this is a test'
            }
        }
    }
}
