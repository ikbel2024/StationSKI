pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'          // Assurez-vous que le JDK 17 est configuré dans Jenkins
        maven 'M2_HOME'         // Assurez-vous que Maven est configuré dans Jenkins
    }

    environment {
        GIT_REPO = 'https://github.com/ikbel2024/StationSKI.git'  // Lien vers votre dépôt Git
        GIT_BRANCH = 'Rzouga'  // Branche cible
        GIT_CREDENTIALS_ID = 'github-token'  // ID des credentials GitHub
        MAVEN_HOME = 'M2_HOME'  // Nom de l'installation Maven configurée dans Jenkins
        PATH = "${env.MAVEN_HOME}/bin:${env.PATH}"  // Ajout de Maven au PATH
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: "**/${env.GIT_BRANCH}"]],
                    userRemoteConfigs: [[
                        url: "${env.GIT_REPO}",
                        credentialsId: "${env.GIT_CREDENTIALS_ID}"
                    ]]
                ])
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Code Analysis with SonarQube') {
            environment {
                scannerHome = tool 'sonarqube'  // Nom du scanner SonarQube configuré dans Jenkins
            }
            steps {
                script {
                    withSonarQubeEnv('sonarqube-server') {
                        sh "${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=stationSki \
                            -Dsonar.sources=. \
                            -Dsonar.host.url=http://localhost:9000 \
                            -Dsonar.login=${credentials('sonarqube-token')}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker build -t station-ski:latest .'
                sh 'docker run -d -p 8080:8080 station-ski:latest'
                sh 'echo "Déploiement en cours..."'
            }
        }
    }
}
