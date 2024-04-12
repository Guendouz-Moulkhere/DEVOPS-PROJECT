pipeline {
    agent any

    tools {
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
         stage('Run Unit Tests') {
    steps {
        bat 'mvn clean test'
        junit 'target/surefire-reports/*.xml'
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
                    withCredentials([string(credentialsId: 'DockerHubSecret', variable: 'DockerHubPwd')]) {
                        bat 'docker login -u gmoulkhere -p projetdevops'
                    }
                    bat 'docker push gmoulkhere/app'
                }
            }
        }
    }
}
