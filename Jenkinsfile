pipeline {
agent any
     environment { 
          
        NEXUS_VERSION = "nexus3"

        NEXUS_PROTOCOL = "http"

        NEXUS_URL = "192.168.1.50:8081"

        NEXUS_REPOSITORY = "nexus-repo"

        NEXUS_CREDENTIAL_ID = "nexus"
          
          

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
                 echo 'sonar';
            }
        }
       
        
        
           stage ("Nexus") {
            steps {
              
                                 script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
                 
                 
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

