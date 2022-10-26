pipeline {
agent any
   environment { 

        registry = "wassimba/wassimrepo" 

        registryCredential = 'dockerhub' 

      dockerImage = ''
   
   } 
    stages {
        

        stage ("Git checkout "){
            steps{
        git branch: 'wassim_branch', 
            url: 'https://github.com/hazem-soussi/terminators_5arctic1.git'
            }
        
        }
    
        
                stage("Compile Project") {
            steps {
                echo "Compile Project"
                sh 'mvn compile -DskipTests=true'
            }
        }
       
        stage('Unit test') {
            steps {
                sh 'mvn test '
            }
        }
         
        
        stage("Build Project") {
            steps {
                echo "Build & test Project"
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage('Integration test') {
            steps {
                sh 'mvn verify -DskipUnitTests=true'
            }
        }

            stage("Quality code Test") {
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
           }
       
       stage("Build images") {
          steps {

             
              sh 'docker build -t $BUILD_TAG:$BUILD_NUMBER .'
             
             
             }
       
       
       }
      stage('Deploy our image') { 

            steps { 


               docker.withRegistry( '', registryCredential ) { 

                        dockerImage.push() 

                   
                } 

            }}
    
       stage("Docker-Compose") {
          steps {

             
              sh 'docker-compose up'
             
             
             }
       
       
       }
    
    }}
}

