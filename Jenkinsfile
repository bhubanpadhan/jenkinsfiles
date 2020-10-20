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
                sh 'curl https://raw.githubusercontent.com/bhubanpadhan/jenkinsfiles/main/prefs.xml >  $JENKINS_HOME/prefs.xml'
                sh 'cat  $JENKINS_HOME/prefs.xml'
                withCredentials([string(credentialsId: 'SENDER_SHARED_SECRET',
                            variable: 'SENDER_SHARED_SECRET_TEXT')]) {
                              apiKey = "${SENDER_SHARED_SECRET_TEXT}"
                             }
                          println apiKey
                      
                      
                          def file = new File(' $JENKINS_HOME/prefs.xml')
    def newConfig = file.text.replace('8080', 'REPLACE_SENDER_SHARED_SECRET')
    file.text = newConfig
                      
                      
                    //  sh 'sed s/REPLACE_SENDER_SHARED_SECRET/${apiKey}/g prefs.xml > prefs1.xml'
                 sh 'cat prefs.xml'
                 sh 'echo $apiKey'
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
