// docs: https://jenkins.io/doc/pipeline/steps/credentials-binding/

pipeline {
  agent any
  stages {

    stage('usernamePassword') {
      steps {
        script {
          withCredentials([
            usernamePassword(credentialsId: 'gitlab',
              usernameVariable: 'username',
              passwordVariable: 'password')
          ]) {
            print 'username=' + username + 'password=' + password

            print 'username.collect { it }=' + username.collect { it }
            print 'password.collect { it }=' + password.collect { it }
          }
        }
      }
    }

    stage('usernameColonPassword') {
      steps {
        script {
          withCredentials([
            usernameColonPassword(
              credentialsId: 'gitlab',
              variable: 'userpass')
          ]) {
            print 'userpass=' + userpass
            print 'userpass.collect { it }=' + userpass.collect { it }
          }
        }
      }
    }

    stage('string (secret text)') {
      steps {
        script {
          withCredentials([
            string(
              credentialsId: 'joke-of-the-day',
              variable: 'joke')
          ]) {
            print 'joke=' + joke
          //  print joke >test.txt
           // sh 'cat test.txt'
            print 'joke.collect { it }=' + joke.collect { it }
            
            def newstring =  joke.collect { it }
            print 'sum value = '+ newstring.sum();
            
           def injectstring =  newstring.inject('counting: ') {
             str, item -> str + item  
               
               }
            print 'inject = ' + injectstring
            
            def lines = joke.collect{ it.split('\\s+') }
            print 'joke.collect { it } new =' + joke.collect{ it.split('\\s+') }
            
            echo "Collect toString():" + lines
            def result = ''
            lines.each{ result += it }
            echo "Collect each: " + result
            
            
          }
        }
      }
    }
    
    
    stage('list credentials ids') {
      steps {
        script {
          sh 'cat $JENKINS_HOME/credentials.xml | grep "<id>"'
        }
      }
    }

  }
}
