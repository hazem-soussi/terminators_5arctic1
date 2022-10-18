
pipeline {
    agent any
    
     environment {

        NEXUS_VERSION = "nexus3"

        NEXUS_PROTOCOL = "http"

        NEXUS_URL = "172.10.0.140:8081"

        NEXUS_REPOSITORY = "maven-nexus-repo"

        NEXUS_CREDENTIAL_ID = "jenkins-user"
      }
      
    stages {
        stage ("Git Checkout"){
            steps{
            git branch: 'amine_branch', 
            url: 'https://github.com/hazem-soussi/terminators_5arctic1.git'
            }
        
        }
        
        stage('Maven Clean') {
            steps {
                echo "Cleaning Project"
                sh 'mvn clean'
            }
        }
        
        stage('Maven Build') {
            steps {
                echo "Building Project"
                sh 'mvn clean install'
            }
        }
        
        stage('Unit Test') {
            steps {
                echo "Testing Project"
                sh 'mvn compile validate test'
            }
        }
        
        stage('Sonarqube Test') {
            steps {
                echo "Sonarqube Testing "
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
            }
        }
        
        stage('Create Package') {
            steps {
                echo "Creating Package"
                sh 'mvn package'
            }
        }
        
         stage("Publish to Nexus") {
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
    }
}
