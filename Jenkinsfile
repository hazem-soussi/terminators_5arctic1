pipeline {
agent any
     environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.48.0:8081"
        NEXUS_REPOSITORY = "nexus-repo"
        NEXUS_CREDENTIAL_ID = "nexus"
    }
    stages {
        

        stage ("Git checkout "){
            steps{
        git branch: 'main', 
            url: 'https://github.com/WassimBA/test.git'
            }
        
        }
    
        
                stage("Build & test Project") {
            steps {
                echo "Build & test Project"
                sh 'mvn clean package -DskipTests=true'
            }
        }
       

            stage("Sonar Test") {
            steps {
           
             sh 'mvn sonar:sonar -Dsonar.projectKey=a -Dsonar.host.url=http://192.168.48.0:9000 -Dsonar.login=d6a5b4ab1830302b9a63e1e90cca5809d993af8b'         
                 
               

            }
        }
           stage("Publish to Nexus Repository Manager") {
            steps {
                nexusPublisher nexusInstanceId: 'nexus',
                     nexusRepositoryId: 'nexus-repo', 
                     packages: [[$class: 'MavenPackage',
                                 mavenAssetList: [[classifier: '', 
                                                   extension: '', 
                                                   filePath: '/var/lib/jenkins/workspace/first_pipeline/target/tpAchatProject-1.0.jar']], 
                                 mavenCoordinate: [artifactId: 'spring-boot-starter-parent', 
                                                   groupId: 'org.springframework.boot', 
                                                   packaging: 'jar', 
                                                   version: '2.5.3']]]

}
           }}}
