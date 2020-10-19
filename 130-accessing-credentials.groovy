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
            echo joke
            echo "username is $joke"
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
            
            //new File('/home/bhuban/.jenkins/','Example.txt').withWriter('utf-8') { 
         //writer -> writer.writeLine 'Hello World' 
          //  }
            
        //    new File('/home/bhuban/.jenkins/','Example.txt').withWriter('utf-8') { writer ->
  //  writer.writeLine 'Into the ancient pond'
   // writer.writeLine 'A frog jumps'
  //  writer.writeLine 'Water’s sound!'
//}
            echo "================================================="
            sh 'echo $joke'
            sh 'echo $joke > Example.txt'
            echo "==========================================="
           // sh 'cat $JENKINS_HOME/Example.txt'
             //sh 'ls /home/bhuban/.jenkins'
            sh 'printenv'
            echo "==========================================="
            
            withCredentials([usernamePassword(credentialsId: 'amazon', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
  // available as an env variable, but will be masked if you try to print it out any which way
  // note: single quotes prevent Groovy interpolation; expansion is by Bourne Shell, which is what you want
  sh 'echo $PASSWORD'
  // also available as a Groovy variable
  echo USERNAME
  // or inside double quotes for string interpolation
  echo "username is $USERNAME"
}
            
          }
          
          withCredentials([string(credentialsId: 'joke-of-the-day', variable: 'joke')]) {
    // some block
            echo "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" 
            print 'joke=' + joke
            sh 'echo $joke'
            
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
