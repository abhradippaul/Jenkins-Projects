def call(String url, String branch, String credentialsId) {
    echo "GitHub code pulling started"
    git url: "${url}", 
    credentialsId: "${credentialsId}", 
    branch: "${branch}"
    echo "GitHub code pulling completed"
}