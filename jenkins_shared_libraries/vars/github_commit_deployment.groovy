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
                    cd maven_sonar_deploy
                    git checkout maven_sonar_deploy
                    cp template.yaml manifests/deployment.yaml
                    sed -i "s/replaceImageTag/${BUILD_NUMBER}/g" manifests/deployment.yaml
                    git add manifests/deployment.yaml
                    git commit -m "Update deployment image to version ${BUILD_NUMBER}"
                    git push https://{username}:${password}@github.com/${username}/Jenkins-Projects.git
                    '''                  
    }
}