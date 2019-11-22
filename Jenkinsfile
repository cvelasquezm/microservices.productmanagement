pipeline {
    agent any
    environment{
        URL_REPOSITORY = 'https://github.com/cvelasquezm/microservices.productmanagement.git'
    }
    stages {
        stage('Git Pull'){
            checkout(${URL_REPOSITORY})
        }
        stage('Stage parallel'){
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
        }
    }
}
