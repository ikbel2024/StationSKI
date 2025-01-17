pipeline {
    agent any
    
    tools {
        // Déclarez les outils que vous avez configurés dans Jenkins
        jdk 'jdk-17'         // Nom du JDK configuré dans Jenkins
        maven 'maven'  // Nom de Maven configuré dans Jenkins 3.9.8
    }

    environment {
        GITHUB_REPO = 'https://github.com/ikbel2024/StationSKI.git'
        GITHUB_CREDENTIALS_ID = 'first-token'
        
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: "${GITHUB_CREDENTIALS_ID}", url: "${GITHUB_REPO}", branch: 'main'
            }
        }
        
        stage('Build with Maven') {
            steps {
                script {
                    // Utilisez Maven déclaré dans la section tools pour exécuter le build
                    sh 'mvn clean install'  // Exécute "mvn clean install"
                }
            }
        }
        
        stage('Test') {
            steps {
                echo 'Run tests here'
            }
        }
        
        stage('Code Analysis') {
            environment {
                scannerHome = tool 'sonarqube'
            }
            steps {
                script {
                    withSonarQubeEnv('sonarqube') {
                        sh "${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=stationSki \
                            -Dsonar.projectName=stationSki \
                            -Dsonar.sources=. \
                            -Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        
        stage('Deploy') {
            steps {
                echo 'Deploy your project here'
            }
        }
    }
}
