pipeline {
agent any
     environment { 

        registry = "rachid135/jenkins" 

        registryCredential = 'dockerhub' 

      dockerImage = ''
   
   } 
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
       
        
        
           stage ("Nexus") {
            steps {
                sh ' echo "nexus" '
            }}
     
             stage("Build images") {
          steps {

             
              sh 'docker build -t rachid135/jenkins:$BUILD_NUMBER .'
             
          }
             }
        stage('Deploy our image') { 

            steps { 
               script{

                  withDockerRegistry([credentialsId:"dockerhub", url:""]){
                                      sh ' docker push rachid135/jenkins:$BUILD_NUMBER '
                   
                } 

               }}}
   
       
        
        
       stage("Docker-Compose") {
          steps {

             
              sh 'docker-compose up'
             
             
             }
       
       
       }

}
           }

