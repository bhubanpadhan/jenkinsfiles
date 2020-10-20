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
                withCredentials([string(credentialsId: 'SENDER_SHARED_SECRET',
                            variable: 'SENDER_SHARED_SECRET_TEXT')]) {
                              SENDER_SHARED_SECRET_VAL = "${SENDER_SHARED_SECRET_TEXT}"
                             }
                          println SENDER_SHARED_SECRET_VAL 
			 
                withCredentials([string(credentialsId: 'REPLACE_SA_PWD',
                            variable: 'REPLACE_SA_PWD_TEXT')]) {
                              REPLACE_SA_PWD_VAL = "${REPLACE_SA_PWD_TEXT}"
                             }
                          println REPLACE_SA_PWD_VAL 
			 
			 
                withCredentials([string(credentialsId: 'SENDER_SHARED_SECRET',
                            variable: 'SENDER_SHARED_SECRET_TEXT')]) {
                              SENDER_SHARED_SECRET_VAL = "${SENDER_SHARED_SECRET_TEXT}"
                             }
                          println SENDER_SHARED_SECRET_VAL 
			 
                withCredentials([string(credentialsId: 'SENDER_SHARED_SECRET',
                            variable: 'SENDER_SHARED_SECRET_TEXT')]) {
                              SENDER_SHARED_SECRET_VAL = "${SENDER_SHARED_SECRET_TEXT}"
                             }
                          println SENDER_SHARED_SECRET_VAL
			 
                withCredentials([string(credentialsId: 'SENDER_SHARED_SECRET',
                            variable: 'SENDER_SHARED_SECRET_TEXT')]) {
                              SENDER_SHARED_SECRET_VAL = "${SENDER_SHARED_SECRET_TEXT}"
                             }
                          println SENDER_SHARED_SECRET_VAL 
			                  
                    // replace string
			 def xmlFile = new File("/home/bhuban/.jenkins/prefs.xml") 
                         def xmlFileText =xmlFile.text
	                xmlFileText = xmlFileText.replace("REPLACE_SENDER_SHARED_SECRET", SENDER_SHARED_SECRET_VAL) 
			 xmlFileText = xmlFileText.replace("REPLACE_SA_PWD", REPLACE_SA_PWD_VAL) 
                        myFile.write(xmlFileText)
                      
                      
                      
                   //   sh 'sed s/REPLACE_SENDER_SHARED_SECRET/apiKey/g prefs.xml > prefs1.xml'
                 sh 'cat prefs.xml'
			// sh 'cat test.txt'
			 sh 'echo ${apiKey}'
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
