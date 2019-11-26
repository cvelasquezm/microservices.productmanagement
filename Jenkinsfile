pipeline {
    agent any
    environment{
        URL_REPOSITORY = 'https://github.com/cvelasquezm/microservices.productmanagement.git'
    }
    stages {
        stage('Git Pull'){
            steps {
                git url: 'https://github.com/cvelasquezm/microservices.productmanagement.git'
            }
        }
        stage('Build'){
            steps{                
                bat 'mvn clean compile install'
            }
        }        
        stage('Test'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Build Image'){
            steps{
                bat 'mvn dockerfile:build'
            }
        }

        stage('Push Image'){
            steps{
                bat 'mvn dockerfile:push'
            }
        }
        stage('Deploy Docker'){
            steps{
               bat 'docker run --name productManagement_API cvelasquezm/productmanagement:0.0.1-SNAPSHOT'//'mvn antrun:run@docker-run'
            }
        }

        /*stage('Stage parallel'){
            parallel{
                stage('stage parallel 1') {
                    steps {
                        echo 'Step 1'
                    }
                }
                stage('stage parallel 2') {
                    steps {
                        echo 'Step 2'
                    }
                }
            }
        }
        stage('build 2') {
            steps {
                echo 'Step 1'
            }{
                echo 'Step 2'
            }
        }*/
    }
}
