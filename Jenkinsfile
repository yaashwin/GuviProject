pipeline {
    agent any

    tools {
        maven 'Maven'  // Use Maven installed in Jenkins
    }

    environment {
        DOCKER_IMAGE = "guvi-project:${env.BUILD_ID}"  // Tag image with build ID
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/yaashwin/GuviProject.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                docker build -t ${DOCKER_IMAGE} .
                '''
            }
        }

        stage('Run New Docker Container') {
            steps {
                sh '''
                docker stop guvi-container || true
                docker rm guvi-container || true
                docker run -d -p 8081:8080 --name guvi-container ${DOCKER_IMAGE}
                '''
            }
        }
    }

    post {
        success {
            echo 'Build and deployment completed successfully!'
        }
        failure {
            echo 'Build or deployment failed! Check logs for details.'
        }
    }
}

// pipeline {
//     agent any

//     tools {
//         maven 'Maven'  // Ensure Maven is installed in Jenkins
//     }

//     environment {
//         DOCKER_IMAGE = "guvi-project:${env.BUILD_ID}"  // Tag image with build ID
//     }

//     stages {
//         stage('Clone Repository') {
//             steps {
//                 git branch: 'main', url: 'https://github.com/yaashwin/GuviProject.git'
//             }
//         }

//         stage('Build with Maven') {
//             steps {
//                 sh 'mvn clean package'
//             }
//         }

//         stage('Build Docker Image') {
//             steps {
//                 script {
//                     docker.build("${DOCKER_IMAGE}")
//                 }
//             }
//         }

//         // stage('Stop and Remove Existing Container') {
//         //     steps {
//         //         sh '''
//         //         docker stop guvi-container || true
//         //         docker rm guvi-container || true
//         //         '''
//         //     }
//         // }

//         stage('Run New Docker Container') {
//             steps {
//                 script {
//                     docker.run("-d -p 8081:8080 --name guvi-container ${DOCKER_IMAGE}")
//                 }
//             }
//         }
//     }

//     post {
//         success {
//             echo 'Build and deployment completed successfully!'
//         }
//         failure {
//             echo 'Build or deployment failed!'
//         }
//     }
// }

