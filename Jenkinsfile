pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'Maven_3.9.6'
    }

    stages {
        stage('SCM Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Guendouz-Moulkhere/DEVOPS-PROJECT']])
            }
        }
        stage('Build Maven Project') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t  gmoulkhere/app .'
            }
        }
        stage('Push Docker Image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'DockerHubSecret', variable: 'DockerHubSecret')]) {
                        bat 'docker login -u gmoulkhere -p ${DockerHubSecret}'
                    }
                    bat 'docker push gmoulkhere/app'
                }
            }
        }
    }
}
