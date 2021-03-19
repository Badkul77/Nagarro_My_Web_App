pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "Maven 3"
   }

   stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository 
            git 'https://github.com/Badkul77/Nagarro_My_Web_App.git'
            sh "mvn clean compile"
         }
         }
      stage("Test") {
          steps {
            git 'https://github.com/Badkul77/Nagarro_My_Web_App.git'  
            sh "mvn  clean test"
            
          }

      }
      stage("Deploy") {
          steps {
            git 'https://github.com/Badkul77/Nagarro_My_Web_App.git'  
            sh "mvn  clean install"
            
          }
          post {
              success {
                  archiveArtifacts 'target/*.jar'
              }

          }


      }

      }
   }