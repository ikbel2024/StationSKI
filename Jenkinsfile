pipeline {
    agent any
    
    tools {
        jdk 'jdk-17'         // Nom du JDK configuré dans Jenkins
        maven 'maven'        // Nom de Maven configuré dans Jenkins (par exemple : Maven 3.9.8)
    }

    environment {
        GITHUB_REPO = 'https://github.com/ikbel2024/StationSKI.git' // URL du dépôt
        GITHUB_CREDENTIALS_ID = 'first-token'                      // ID des credentials GitHub
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning the repository...'
                git credentialsId: "${GITHUB_CREDENTIALS_ID}", url: "${GITHUB_REPO}", branch: 'main'
            }
        }

        stage('Build with Maven') {
            steps {
                echo 'Building the project with Maven...'
                script {
                    // Utilise Maven déclaré dans la section tools pour exécuter le build
                    sh 'mvn clean install'  // Exécute "mvn clean install"
                }
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo 'Running unit tests...'
                script {
                    // Commande pour exécuter les tests Maven
                    sh 'mvn test'
                }
            }
        }

        stage('Code Analysis') {
            environment {
                scannerHome = tool 'sonarqube' // Nom du scanner SonarQube configuré dans Jenkins
            }
            steps {
                echo 'Starting code analysis with SonarQube...'
                script {
                    withSonarQubeEnv('sonarqube') { // SonarQube ID configuré dans Jenkins
                        sh "${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=stationSki \
                            -Dsonar.projectName=stationSki \
                            -Dsonar.sources=. \
                            -Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        stage('Package Artifact') {
            steps {
                echo 'Packaging the artifact...'
                script {
                    // Exécute la phase de packaging Maven
                    sh 'mvn package'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                script {
                    // Ajoutez votre commande ou script de déploiement ici
                    sh 'echo "Deployment steps go here!"'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed! Check the logs for more details.'
        }
    }
}

