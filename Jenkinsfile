#!/usr/bin/env groovy

def CURRENT_TIME = new Date().format('HH:mm:ss dd-MM-yyyy')

pipeline {
     agent { node { label "aws" } }
       options {
                 timestamps()
                 timeout(time: 180, unit: 'MINUTES')
             }
    environment {
    //store here varieables that you need for run
        DOCKER_TESTS_IMAGE_TAG = "${AWS_REGISTRY}/mc-ll-automation:latest"
        SELENOSIS_URL = "http://aeec39e805e954c30997fa54a06db4c8-356867997.us-east-1.elb.amazonaws.com:4444/wd/hub/"
        JENKINGS_USER_ID = '$(id -u)'
        JENKINGS_USER_GROUP_ID = '$(id -g)'

        SLACK_WEBHOOK_DOMAIN = 'liberty-lending'
        SLACK_CHANNEL = 'automation-ll-ms-reachlife'
         registry = "${AWS_REGISTRY}"
    }
    // triggers {
    // Daily trigger
    // cron('H 19 * * *')
    //}

    stages {

        stage('Run Tests') {
            steps {
                script {
                    timeout(time: 20, unit: 'MINUTES') {
                    echo "Pull docker conteiner"
                    sh "aws ecr get-login-password --region 'us-east-1' | docker login --username AWS --password-stdin ${env.registry}"
                        sh """docker pull ${DOCKER_TESTS_IMAGE_TAG}"""
                    echo 'Run test'
                        sh """
                        docker run --rm -i\\
                        --network="host" \\
                         --user ${JENKINGS_USER_ID}:${JENKINGS_USER_GROUP_ID}\\
                        ${DOCKER_TESTS_IMAGE_TAG}\\
                         ls -la && chmod +x gradlew && sudo ./gradlew test \\
                         -DargLine= -DSELENOSIS_URL=${SELENOSIS_URL} \\
                         """
                    }
                }
            }
        }
    }
    post {
        always {
            script{
             echo 'Stop compose and remove volumes'
                sh '(cd ci  && docker-compose down --rmi all && (yes |docker volume prune))'
                sh 'docker volume ls -qf dangling=true | xargs -r docker volume rm;'
                sh 'sudo chmod -R o+xw build/allure-results'
                        def data = "Environment=local, Branch=${GIT_BRANCH}"
                        writeFile(file: 'build/allure-results/environment.properties', text: data)
            }
            allure([
                    includeProperties: false,
                    jdk              : '',
                    properties       : [],
                    reportBuildPolicy: 'ALWAYS',
                    results          : [[path: 'build/allure-results']]
            ])
        }
        success {
            echo 'success'
            script {
                echo 'Notify slack only for master'
                slackSend channel: "${SLACK_CHANNEL}", color: 'good',
                        message: "PASSED :thumbsup: :beers: :heavy_check_mark: :rainbow:",
                        attachments: """[{
                                    "fallback": "${env.JOB_BASE_NAME} All tests passed",
                                    "text": "${env.JOB_BASE_NAME} All tests passed. Time:${CURRENT_TIME}",
                                    "color": "good",
                                     "actions": [
                                     {
                                        "type": "button",
                                        "name": "Show report",
                                        "text": "Show report",
                                        "url": "${env.BUILD_URL}allure/",
                                        "style": "primary"
                                    }]
                                    }]""",
                        teamDomain: "${SLACK_WEBHOOK_DOMAIN}",
                        tokenCredentialId: 'SLACK_WEBHOOK_KEY'
            }
        }
        failure {
            echo 'failure'
            script {
                echo 'Notify slack only for master'
                slackSend channel: "${SLACK_CHANNEL}", color: 'danger',
                        message: "FAILED :boom: :sob: :sos:",
                        attachments: """[{
                                    "fallback": "${env.JOB_BASE_NAME} Tests failed",
                                    "text": "${env.JOB_BASE_NAME} Tests failed. Time:${CURRENT_TIME}",
                                    "color": "danger",
                                    "actions": [
                                    {
                                        "type": "button",
                                        "name": "Show report",
                                        "text": "Show report",
                                        "url": "${env.BUILD_URL}allure/",
                                        "style": "primary"
                                    }]
                                    }]""",
                        teamDomain: "${SLACK_WEBHOOK_DOMAIN}",
                        tokenCredentialId: 'SLACK_WEBHOOK_KEY'
            }
        }
        aborted {
            echo 'Aborted'
            script {
                echo 'Notify slack only for master'
                slackSend channel: "${SLACK_CHANNEL}", color: 'warning',
                        message: "ABORTED. Something went wrong :warning: :see_no_evil: :bomb: :warning:",
                        attachments: """[{
                                    "fallback": "${env.JOB_BASE_NAME} Something went wrong. pipline is aborted ",
                                    "text": "${env.JOB_BASE_NAME} Something went wrong. Pipline is aborted. Time:${CURRENT_TIME}",
                                    "color": "warning",
                                    "actions": [
                                    {
                                        "type": "button",
                                        "name": "Show ",
                                        "text": "Show pipeline",
                                        "url": "${env.BUILD_URL}",
                                        "style": "primary"
                                    }]
                                    }]""",
                        teamDomain: "${SLACK_WEBHOOK_DOMAIN}",
                        tokenCredentialId: 'SLACK_WEBHOOK_KEY'
            }
        }
    }
}
