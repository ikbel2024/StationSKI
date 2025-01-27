pipeline {
    agent any

    environment {
        GIT_REPO = 'https://github.com/ikbel2024/StationSKI.git' // Référentiel Git
        GIT_BRANCH = 'akrem' // Branche cible
        GIT_CREDENTIALS_ID = 'GITHUB_CREDENTIALS_ID' // ID des credentials Jenkins
        MAVEN_HOME = 'M2_HOME' // Nom de l'installation Maven configurée dans Jenkins
    }

    tools {
        maven "${MAVEN_HOME}" // Outil Maven configuré dans Jenkins
    }

    stages {
        stage('Récupération du Code Source') {
            steps {
                echo 'Clonage du référentiel Git...'
                git branch: "${GIT_BRANCH}", 
                    credentialsId: "${GIT_CREDENTIALS_ID}", 
                    url: "${GIT_REPO}"
            }
        }

        stage('Compilation Maven') {
            steps {
                echo 'Compilation du projet avec Maven...'
                script {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Exécution des Tests Maven') {
            steps {
                echo 'Exécution des tests unitaires avec Maven...'
                script {
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline exécuté avec succès !'
        }
        failure {
            echo 'Le pipeline a échoué. Consultez les journaux pour plus de détails.'
        }
    }
}
