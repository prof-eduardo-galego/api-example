#!groovy
pipeline {

//    agent {
//        label 'slave1'
//    }

    tools {
        maven 'Maven'
        jdk 'JDK 8u152'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Executando construção do projeto'
                sh 'mvn clean install'
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

        stage("Result of analysis"){
//            timeout(time: 10, unit: 'MINUTES') {
//                def qg = waitForQualityGate()
//                if (qg.status != 'OK') {
//                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
//                }
//            }
        }

        stage('Deploy to Develop') {
            when {
                branch 'developer'
            }
            steps {
                echo 'Preparing workspace to dev'
//                sh """
//            rm -rf ../calendar_deploy-dev
//            mkdir ../calendar_deploy-dev
//            mkdir ../calendar_deploy-dev/target
//            cp -r Dockerfile ../calendar_deploy-dev/Dockerfile
//            cp -r target/*.war ../calendar_deploy-dev/target/lm-schedule.war
//            cp -r .ebextensions ../calendar_deploy-dev/.ebextensions
//            cp -r .configuration/context.xml ../calendar_deploy-dev/target/context.xml
//            cp -r .elasticbeanstalk ../calendar_deploy-dev/.elasticbeanstalk
//            cp -r .configuration/newrelic/ ../calendar_deploy-dev/newrelic
//            cp -r .configuration/certs/ ../calendar_deploy-dev/certs
//          """
//                echo '##################################'
//                echo 'Deploying to dev environment'
//                echo '##################################'
//                withAWS(credentials: 'svc_elasticbeanstalk_app') {
//                    sh """
//              cd ../calendar_deploy-dev
//              eb deploy lmbr-calendar-dev
//            """
            }
        }

        stage('Deploy to Prod') {
            when {
                branch 'master'
            }
            steps {
                echo 'Preparing workspace to prod'
//                sh """
//                rm -rf ../calendar_deploy-prd
//                mkdir ../calendar_deploy-prd
//                mkdir ../calendar_deploy-prd/target
//                cp -r Dockerfile ../calendar_deploy-prd/Dockerfile
//                cp -r target/*.war ../calendar_deploy-prd/target/lm-schedule.war
//                cp -r .ebextensions ../calendar_deploy-prd/.ebextensions
//                cp -r .configuration/context.xml ../calendar_deploy-prd/target/context.xml
//                cp -r .elasticbeanstalk ../calendar_deploy-prd/.elasticbeanstalk
//                cp -r .configuration/newrelic/ ../calendar_deploy-prd/newrelic
//                cp -r .configuration/certs/ ../calendar_deploy-prd/certs
//              """
//                echo '##################################'
//                echo 'Deploying to dev environment'
//                echo '##################################'
//                withAWS(credentials: 'svc_elasticbeanstalk_app') {
//                    sh """
//                  cd ../calendar_deploy-prd
//                  eb deploy lmbr-calendar-prd
//                """
//                }
            }
        }
    }

    post {
        success {
        }

        failure {
        }
    }
    
}