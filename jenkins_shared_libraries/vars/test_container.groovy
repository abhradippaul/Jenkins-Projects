def call(String containerName, String image) {
    echo "Testing container started"
    sh "docker run -d --name ${containerName} -p 80:80 ${image}"
    sh "curl localhost > output.txt; date >> output.txt"
    echo "Testing container finished"
}