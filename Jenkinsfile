pipeline {
     agent any
      environment { 
        TEST_SECRET1 = 'TEST_SECRET1_VALUE'
    }

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
