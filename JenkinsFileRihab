pipeline {
    agent any
    environment {

        NEXUS_VERSION = "nexus3"

        NEXUS_PROTOCOL = "http"

        NEXUS_URL = "192.168.1.2:8081"

        NEXUS_REPOSITORY = "nexus-repo"

        NEXUS_CREDENTIAL_ID = "adminNexus"
        
        
        registry = "rihab96/spring"
        registryCredentials='dockerHub'
        dockerImage= ' '

      }
    stages{
    
    
        stage('stage1 : Checkout GIT'){
            steps {
                echo 'Pulling..';
                  git branch: 'riBranch',
                  url : 'https://github.com/hazem-soussi/terminators_5arctic1.git';
            }
        }
        
        
        stage('stage2 : Maven Build Project') {
            steps {
                echo "Build project"
                sh 'mvn clean install '
            }
        }
        
        
        stage('stage3 : UNIT TEST') {
            steps {
                echo "TESTING project"
                sh 'mvn test '
            }
        }
        
        
         stage('stage4 : INT TEST') {
            steps {
                sh 'mvn verify'
            }
        }
        
        
        
        stage('stage5 : SonarQube Analysis') {
            steps {
                echo "Executing Sonar Analysis"
                sh 'mvn package sonar:sonar -Dsonar.host.url=http://192.168.1.2:9000 -Dmaven.test.failure.ignore=true -Dsonar.login=efe54466f7a977ede48b2a861e333b592e0daa96'
            }
        }
        
       
        stage('stage6 : Create Package') {
            steps {
                echo "Creating Package"
                sh 'mvn package'
            }
        }
        
  
  
        stage("stage7: Publish to Nexus Repository Manager") {
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
            }
        }
    
    
       stage("stage7: Build images") {
          steps {
              sh 'docker build -t rihab96/springapp:$BUILD_NUMBER .'
              
             }
    
     }
     
   stage ("Push image to dockerHUb") {
        
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerID', variable: 'dockerhubpwd')]) {
                        sh "docker login -u rihab96 -p ${dockerhubpwd}"
                    sh 'docker push rihab96/springapp:$BUILD_NUMBER'
                    }
                    
                
                    
          
                }
            
            }
        
        
        }
        
        
           stage("Docker-Compose") {
          steps {

             
              sh 'docker-compose up'
             
             
             }
       
       
       }
        
    
       
    
    
    }
}