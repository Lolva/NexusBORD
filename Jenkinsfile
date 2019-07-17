pipeline {
  agent any
  stages {
    stage('JUnit Test Suite') {
      steps {
        junit 'reports/*.xml'
      }
    }
  }
}