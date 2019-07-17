pipeline {
  agent any
  stages {
    stage('JUnit Test Suite') {
      steps {
        junit 'NexusBord/target/surefire-reports/TEST-*.xml.'
      }
    }
  }
}