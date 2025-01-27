pipeline {
    agent any

    triggers {
        // Déclenche le pipeline dès qu'un push est détecté dans le référentiel Git
        pollSCM('H/5 * * * *') // Vérifie les changements toutes les 5 minutes
    }

    environment {
        GIT_REPO = 'https://github.com/ikbel2024/StationSKI.git' // Référentiel Git utilisé
        GIT_BRANCH = 'akrem' // Branche par défaut
        GIT_CREDENTIALS_ID = 'GITHUB_CREDENTIALS_ID' // ID des credentials Jenkins
    }

    stages {
        stage('Checkout Source Code') {
            steps {
                echo 'Récupération du code source depuis le référentiel Git...'
                git branch: "${GIT_BRANCH}", 
                    credentialsId: "${GIT_CREDENTIALS_ID}", 
                    url: "${GIT_REPO}"
            }
        }

        stage('Display System Date') {
            steps {
                echo 'Affichage de la date système...'
                script {
                    // Affiche la date et l'heure actuelles du système
                    sh 'date'
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
