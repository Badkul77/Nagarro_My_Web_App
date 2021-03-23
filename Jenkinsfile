pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "Maven 3"
      jdk "Java"
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

      }
   }