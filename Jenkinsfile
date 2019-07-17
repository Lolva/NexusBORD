pipeline {
  agent any
  stages {
    stage('Compile Stage') {
      steps {
        withMaven() {
          sh 'mvn clean compile'
        }

      }
    }
    stage('Deployment Stage') {
      steps {
        withMaven() {
          sh 'mvn spring-boot:run'
        }

      }
    }
  }
}