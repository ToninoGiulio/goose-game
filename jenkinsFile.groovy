node {
    def mvnHome = tool "Maven"
    stage('Clone') {
        checkout scm
    }
    stage('Unit tests') {
        sh "mvn clean test"
        sh "ls -l target"
    }
    stage('Integration test') {
        echo "qui dovre lanciare i test di integrazione"
        //sh "mvn test-compile failsafe:integration-test"

    }
}