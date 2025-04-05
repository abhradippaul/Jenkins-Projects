def call(String credentialsId) {
    withCredentials([
        usernamePassword(credentialsId: "${credentialsId}",
        usernameVariable: "username", 
        passwordVariable: "password")]) {
            echo "Docker login started"
            sh "docker login -u $username -p $password"
            sh "docker tag frontend $username/frontend"
            sh "docker push $username/frontend"
            echo "Docker login completed"
        }
}