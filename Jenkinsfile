pipeline {

   agent {
       label 'Slave_Induccion'
   }

   options {

       buildDiscarder(logRotator(numToKeepStr: '3'))
       disableConcurrentBuilds()
   }

   tools {
       jdk 'JDK8_Centos'
       gradle 'Gradle4.5_Centos'
   }

   stages {
   	stage('Checkout') {
       	steps {
               echo "------------>Checkout<------------"
               checkout([$class                           : 'GitSCM',
                         branches                         : [[name: '*/master']],
                         doGenerateSubmoduleConfigurations: false,
                         extensions                       : [],
                         gitTool                          : 'Git_Centos',
                         submoduleCfg                     : [],
                         userRemoteConfigs                : [[credentialsId: 'GitHub_juanFlorezCeiba',
                                                              url          : 'https://github.com/juanFlorezCeiba/Ceiba-Estacionamiento']]])
           }
       }

stage('Compile') {
steps{
echo "------------>Compile<------------"
sh 'gradle --b ./build.gradle compileJava'
}
}

stage('Unit Tests') {
           steps {
               echo "------------>Unit Tests<------------"
               sh 'gradle --b ./build.gradle test'
           }
       }

stage('Integration Tests') {
steps {
echo "------------>Integration Tests<------------"
}
}

stage('Static Code Analysis') {
steps{
echo '------------>Análisis de código estático<------------'
withSonarQubeEnv('Sonar') {
sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
}
}
}

stage('Build') {
steps {
echo "------------>Build<------------"
sh 'gradle build -x test'
}
}
}

post {
always {
echo 'This will always run'

}
success {
echo 'This will run only if successful'

}
failure {
echo 'This will run only if failed'
mail (to: 'juan.florez@ceiba.com.co',
     subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
     body: "Something is wrong with ${env.BUILD_URL}")

}
unstable {
echo 'This will run only if the run was marked as unstable'

}
changed {
echo 'This will run only if the state of the Pipeline has changed'
echo 'For example, if the Pipeline was previously failing but is now successful'
}
}
}
