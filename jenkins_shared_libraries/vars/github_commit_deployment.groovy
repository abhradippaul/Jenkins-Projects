def call(String branch, String credentialsId, String BUILD_NUMBER, String repo) {
    withCredentials([
        usernamePassword(
        credentialsId: "${credentialsId}", 
        usernameVariable: "username", 
        passwordVariable: "password"
        )]){
        sh '''
        git config user.email "abhradipserampore@gmail.com"
        git config user.name "${username}"
        git config user.password "${password}"
        // git checkout ${branch}
        // git add maven_sonar_deploy
        // git commit -m "Update deployment image to version ${BUILD_NUMBER}"
        // git push origin ${branch} https://${password}@github.com/${username}/${repo}
        '''
    }
}