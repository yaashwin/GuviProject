pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1'  // Ensure Maven is installed in Jenkins
    }

    environment {
        DOCKER_IMAGE = "guvi-project:${env.BUILD_ID}"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/yaashwin/GuviProject.git'
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
                    docker.build(DOCKER_IMAGE)
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    docker.run("-d -p 8081:8080 ${DOCKER_IMAGE}")
                }
            }
        }
    }

    post {
        success {
            echo 'Build and deployment completed successfully!'
        }
        failure {
            echo 'Build or deployment failed!'
        }
    }
}

