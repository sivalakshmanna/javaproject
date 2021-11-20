//declarative pipeline
pipeline{
    agent any 
    stages{
        stage("download artifacts"){
            steps{
                println "Here I'm downloding artifacts from s3"
            }
        }
        stage("copy artifacts"){
            steps{
                println "I'mcopying artifacts from from jenkins to tomcat server"
            }
        }
    }
}