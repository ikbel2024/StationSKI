pipeline {
    agent any

    environment {
        GIT_REPO = 'https://github.com/ikbel2024/StationSKI.git' // Référentiel Git
        GIT_BRANCH = 'akrem' // Branche cible
        GIT_CREDENTIALS_ID = 'GITHUB_CREDENTIALS_ID' // ID des credentials Jenkins
        MAVEN_HOME = 'M2_HOME' // Nom de l'installation Maven configurée dans Jenkins
        PATH = "${env.MAVEN_HOME}/bin:${env.PATH}" // Met à jour le PATH pour inclure Maven
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Clone du dépôt Git
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: "*/${env.GIT_BRANCH}"]],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        url: "${env.GIT_REPO}",
                        credentialsId: "${env.GIT_CREDENTIALS_ID}"
                    ]]
                ])
            }
        }

        stage('Build') {
            steps {
                // Compilation avec Maven
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Exécution des tests avec Maven
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // Archiver les artefacts de construction et les rapports de tests
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }
        failure {
            // Notifier un échec
            echo 'Le build ou les tests ont échoué !'
        }
    }
}

