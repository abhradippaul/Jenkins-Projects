def call(String branch, String credentialsId, String BUILD_NUMBER, String repo) {
    withCredentials([
        usernamePassword(
        credentialsId: "${credentialsId}", 
        usernameVariable: "username", 
        passwordVariable: "password"
        )]){
        git url: "https://github.com/abhradippaul/Jenkins-Projects.git", branch: "maven_sonar_deploy"
        sh '''
        git config user.email "abhradipserampore@gmail.com"
        git config user.name "${username}"
        git config user.password "${password}"
        cd maven_sonar_deploy
        git log --oneline 
        git status
        git remote -v
        # git checkout maven_sonar_deploy
        # sed -i "s/replaceImageTag/${BUILD_NUMBER}/g" maven_sonar_deploy/manifests/deployment.yaml
        # cat maven_sonar_deploy/manifests/deployment.yaml
        # git add maven_sonar_deploy
        # git commit -m "Update deployment image to version ${BUILD_NUMBER}"
        # git remote -v
        # git branch
        # git log --oneline
        # git push origin maven_sonar_deploy
        '''
    }
}