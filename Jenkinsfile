pipeline {
    agent { docker { image 'maven:3.8.6-openjdk-11-slim' } }
    
    stages{
        
        stage('hello'){
            
            steps{
                echo 'hello world' 
                
            }
        }   
        stage('clone'){
            steps{
                echo 'pulling...';
                git branch :'main',
                url :'https://github.com/hazem-soussi/terminators_5arctic1',
                credentialsId :'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';
            }
        }
    }
}


