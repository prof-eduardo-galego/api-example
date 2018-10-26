#!groovy
pipeline {

    agent any

    tools {
        maven 'Maven'
        jdk 'JDK 8u152'
    }

    stages {
        stage('Cleanup') {
            steps {
                echo 'Efetuando limpeza'
                sh 'mvn clean'
            }
        }

        stage('Analyse') {
            steps {
                echo 'Submetendo código-fonte para análise estática'
//                withSonarQubeEnv('sonar.leroymerlin.com.br') {
//                    sh 'mvn sonar:sonar'
//                }
            }
        }

//        stage("Result of analysis"){
//            timeout(time: 10, unit: 'MINUTES') {
//                def qg = waitForQualityGate()
//                if (qg.status != 'OK') {
//                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
//                }
//            }
//        }

        stage('Unit Test') {
            steps {
                echo 'Executando testes unitários'
//                sh 'mvn test'
            }
        }

        stage('Build') {
            steps {
                echo 'Executando construção do projeto'
                sh 'mvn install'
            }
        }

        stage('Deploy to Develop') {
            when {
                branch 'developer'
            }
            steps {
                echo 'Preparing workspace to dev'
                sh """
                    rm -rf ~/target
                    mkdir ~/target
                    cp -r target/api-example-0.0.1-SNAPSHOT.jar ~/target/api-example.jar
                """
                echo 'Deploying to dev environment'
                withAWS(credentials: 'elasticbeanstalk_app') {
                    sh """
                        cd ~/
                        eb deploy api-example-dev
                    """
                }
            }
        }

        stage('Deploy to Prod') {
            when {
                branch 'master'
            }
            steps {
                echo 'Preparing workspace to prod'
                sh """
                    rm -rf ~/target
                    mkdir ~/target
                    cp -r target/api-example-0.0.1-SNAPSHOT.jar ~/target/api-example.jar
                """
                echo 'Deploying to prod environment'
                withAWS(credentials: 'elasticbeanstalk_app') {
                    sh """
                        cd ~/
                        eb deploy api-example-prod
                    """
                }
            }
        }
    }
}