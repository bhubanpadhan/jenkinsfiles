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
                 TEST_SECRET1 = ['abcd'] 
                echo 'Testing..from github jenkins file'
                echo " Reading ${TEST_SECRET1}"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying.... this is a test'
            }
        }
    }
}
