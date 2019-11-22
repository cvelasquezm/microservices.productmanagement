pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'mvn --version'
            }
        }
        stage('build 2') {
            steps {
                echo 'mvn --version 2'
            }{
                echo 'step 3'
            }
        }
    }
}