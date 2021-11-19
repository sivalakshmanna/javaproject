pipeline{
    agent any
    environment {
    BRANCH = "${env.BRANCH_NAME}"
    }
    stages{
        stage("checkout code"){
            steps{
                println "clone our code to our repository"
              // println $BRANCH
               // println "${BRANCH}"
                sh "ls -l"
                sh "ls -lart ./*"
                git branch: "${BRANCH_NAME}",
                url: 'https://github.com/sivalakshmanna/boxfuse-sample-java-war-hello.git'
            }
        }
        stage("build code"){
            steps{
                println "mvn clean package"
                sh "mvn clean package"
                sh "ls -l target/"
            }
        }
        stage("upload artifacts to s3"){
            steps{
                println "uploading artifacts to s3 bucket"
                sh "aws s3 cp target/*.war s3://sivabandela/$JOB_NAME/${BRANCH_NAME}/$BUILD_NUMBER/"

            }
        }
    }
}