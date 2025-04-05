def call(String image, String dockerfile) {
    echo "Docker building image started"
    sh "docker build -t ${image} -f ${dockerfile} ."
    echo "Docker builing image completed"
}