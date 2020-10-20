pipeline {
     agent any
  //    environment { 
   //     TEST_SECRET1 = 'TEST_SECRET1_VALUE'
    //}

    stages {
        stage('Build') {
            steps {
                 script {
                echo 'Building..prefs.xml'
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                echo "Pull prefs.xml template"
                sh 'curl https://raw.githubusercontent.com/bhubanpadhan/jenkinsfiles/main/prefs.xml > prefs.xml'
                withCredentials([string(credentialsId: 'SENDER_SHARED_SECRET',
                            variable: 'SENDER_SHARED_SECRET_TEXT')]) {
                              apiKey = "${SENDER_SHARED_SECRET_TEXT}"
                             }
                          println apiKey
                 sh 'sed s/REPLACE_SENDER_SHARED_SECRET/$apiKey/g prefs.xml > prefs1.xml'
                 sh 'cat prefs1.xml'
                 } 
                 
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying.... this is a test'
                // sh 'printenv'
            }
        }
    }
}
