pipeline {
  agent any
  stages {
    stage('Compile Stage') {
      steps {
        withMaven(maven: 'maven-3.6.1') {
          sh 'mvn clean compile'
        }

        junit(testResults: 'reports/*.xml', allowEmptyResults: true)
      }
    }
    stage('Deployment Stage') {
      steps {
        withMaven(maven: 'maven-3.6.1') {
          sh 'mvn spring-boot:run'
        }

      }
    }
  }
}