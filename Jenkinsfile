pipeline {
agent any
    stages {
        
        stage('MVN CLEAN'){
            steps {
                echo'clean...'
            }
        }
        
         stage('MVN COMPILE'){
            steps {
                echo'compile...'
                
            }
        }
        
        stage ("Git checkout PLEAASE"){
            steps{
        git branch: 'main', 
            url: 'https://github.com/hazem-soussi/terminators_5arctic1.git'
            }
        
        }
    
    
    
    }

}
