pipeline {
agent any
    stages {
        

        stage ("Git checkout "){
            steps{
        git branch: 'rachid_branch', 
            url: 'https://github.com/hazem-soussi/terminators_5arctic1.git'
            }
        
        }
    
        
                stage("Build & test Project") {
            steps {
                echo "Build & test Project"
                sh 'mvn install'
                sh 'mvn clean package -DskipTests=true'
            }
        }
        

                
               

            
        
           stage ('Scan and Build Jar File') {
            steps {
               withSonarQubeEnv(installationName: 'Sonar', credentialsId: 'sonartest') {
                sh 'mvn clean package sonar:sonar'
                }
            }
        }
       
        
        
           stage ('Nexus') {
            steps {
        
        
     
             stage("Build images") {
          steps {

             
              sh 'docker build -t $BUILD_TAG:$BUILD_NUMBER .'
             
          }
             }
       
        
        
       stage("Docker-Compose") {
          steps {

             
              sh 'docker-compose up'
             
             
             }
       
       
       }

}
    }
