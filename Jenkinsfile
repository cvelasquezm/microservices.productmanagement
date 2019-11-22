pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
            steps {
                sh 'mvn --version 2'
            }
        }
        stage('build 2') {
                    steps {
                        sh 'mvn --version'
                    }
                    steps {
                        sh 'mvn --version 2'
                    }
                }
    }
}