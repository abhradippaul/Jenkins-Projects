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
        git checkout maven_sonar_deploy
        sed -i "s/replaceImageTag/${BUILD_NUMBER}/g" maven_sonar_deploy/manifests/deployment.yaml
        git add maven_sonar_deploy
        git commit -m "Update deployment image to version ${BUILD_NUMBER}"
        git remote -v
        git branch
        git log --oneline
        # git push origin maven_sonar_deploy
        '''
    }
}