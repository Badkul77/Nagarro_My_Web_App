pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "Maven 3"
      jdk "Java"
   }
   environment {
        //once you sign up for Docker hub, use that user_id here
        registry = "badkulnaman/mywebapp:Tomcat"
        //- update your credentials ID after creating credentials for connecting to Docker Hub
        registryCredential = '05801a91-f5d9-442b-9cfc-eaeaac804563'
        dockerImage = ''
    }
   stages {
    stage('Checkout') {
         steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Badkul77/Nagarro_My_Web_App.git']]])
         }
         }
      stage('Build') {
         steps {
         
            bat"mvn clean compile"
         }
         }
    stage('Sonar Analysis') {
         steps {
           withSonarQubeEnv("SonarQube Scanner")
           { 
             bat "mvn sonar:sonar"
           }
         }
         }
      stage("Test") {
          steps {
       
            bat "mvn  clean test"
            
          }

      }
      stage("Artifactory") 
          {
           steps
           {   
              rtMavenDeployer (
                 id: 'deployer',
                 serverId: 'My_Artifactory',
                 releaseRepo: 'example-repo-local',
                 snapshotRepo: 'example-repo-local')
             rtMavenRun (
                pom: 'pom.xml',
                goals: 'clean install',
                deployerId: 'deployer')
             rtPublishBuildInfo(
              serverId: 'My_Artifactory')

           }
          }
      stage('Building image') {
       steps{
        script {
          dockerImage = docker.build registry
        }
      }
    }
	 stage('Upload Image') {
     steps{    
         script {
            docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
            }
        }
      }
    }
    stage('Docker Run') {
     steps{
         script {
            dockerImage.run("-p 8090:8080 --rm --name mywebapp")
         }
      }
    }
      }
   }