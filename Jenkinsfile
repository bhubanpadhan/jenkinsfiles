pipeline {
     agent {
        // Define agent details here
    }

     environment {
        MY_KUBECONFIG = credentials('my-kubeconfig')
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
                echo " Reading ${MY_KUBECONFIG}"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying.... this is a test'
            }
        }
    }
}
