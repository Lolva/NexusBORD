pipeline {
  agent any
  stages {
    stage('JUnit Test Suite') {
      steps {
        junit '**/build/test-results/TEST-*.xml'
      }
    }
  }
}