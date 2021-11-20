pipeline{
    agent any 
    parameters {
        string(name: 'BRANCH_NAME', "defaultvalue":'master', description: 'From which branch artifacts want to deploy?')
        string(name: 'BUILD_NUM', "defaultvalue": '', description: 'From which build number artifacts want to deploy?')
    }
    stages{
        stage("download artifacts"){
            steps{
                println "Here I'm downloding artifacts from s3"
                sh """
                       aws s3 ls
                       aws s3 ls s3://sivabandela
                       aws s3 ls s3://sivabandela/${BRANCH_NAME}/${BUILD_NUM}/
                   """
                       
            }
        }
        stage("copy artifacts"){
            steps{
                println "I'mcopying artifacts from from jenkins to tomcat server"
            }
        }
    }
}