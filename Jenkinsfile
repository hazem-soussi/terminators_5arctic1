pipeline {
agent any
    stages {
        

        stage ("Git checkout "){
            steps{
        git branch: 'rachidtest', 
            url: 'https://github.com/WassimBA/test.git'
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
        
        
        nexusPublisher nexusInstanceId: 'nexus', 
            nexusRepositoryId: 'maventest', 
            packages: [[$class: 'MavenPackage',
                        mavenAssetList: [[classifier: '', extension: '', filePath: '/var/lib/jenkins/workspace/test/target/tpAchatProject-1.0.jar']], 
                        mavenCoordinate: [artifactId: 'spring-boot-starter-parent', 
                                          groupId: 'org.springframework.boot',
                                          packaging: 'jar', 
                                          version: '2.5.3']]]
    }
    
    }

}
    }
