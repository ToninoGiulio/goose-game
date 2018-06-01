node {
    try {
        def mvnHome = tool "Maven"
        stage('Clone') {
            checkout scm
        }
        stage('Unit tests') {
            sh "mvn clean test"
            sh "ls -l target"

            def antonio = "giuliani"
            echo "ciao $antonio"
            echo 'ciao $antonio'
        }
        stage('Integration test') {
            echo "qui dovre lanciare i test di integrazione"
            //sh "mvn test-compile failsafe:integration-test"

        }
        stage('Build artifact'){
            sh "mvn -DskipTests package"
            archiveArtifacts artifacts: 'target/goose-1.0-SNAPSHOT-jar-with-dependencies.jar', fingerprint: true
        }
    }
     finally{
        junit'target/surefire-report//**/*.xml'
    }
}