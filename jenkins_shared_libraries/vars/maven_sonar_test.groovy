def call(String credentialsId, String location, String SONAR_URL) {
    withCredentials([string(credentialsId: "${credentialsId}", variable: "token")]) {
        sh "cd ${location} && \
        mvn sonar:sonar \
        -Dsonar.login=${token} \
        -Dsonar.host.url=${SONAR_URL}"
    }
}