pipeline {
    agent any
    stages {
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
        stage('build 2') {
            steps {
                echo 'Step 1'
            }{
                echo 'Step 2'
            }
        }
    }
}