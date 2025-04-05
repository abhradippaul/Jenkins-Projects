def call () {
    echo "Removing all docker container started"
    sh 'for id in $(docker ps -aq); do docker rm --force $id; done'
    echo "Removing all docker container completed"
}