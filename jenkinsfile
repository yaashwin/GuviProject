pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1'  // Ensure Maven is installed in Jenkins
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/yourusername/your-repo.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh './mvnw clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("guvi-project:${env.BUILD_ID}")
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    docker.run("-d -p 8081:8080 guvi-project:${env.BUILD_ID}")
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment Successful!'
        }
        failure {
            echo 'Deployment Failed!'
        }
    }
}
