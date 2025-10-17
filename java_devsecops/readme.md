Jenkins Plugins -> Eclipse Temurin installer, Config File Provider , Pipeline Maven Integration , Pipeline Maven Plugin API, SonarQube Scanner, Docker, Docker Pipeline, Kubernetes, Kubernetes Client API, Kubernetes Credentials, Kubernetes CLI

docker run -d --name sonarqube -p 9000:9000 sonarqube
docker run -d --name nexus -p 8081:8081 sonatype/nexus

Kubernetes Commands

```
cd manifests
kubectl create ns jenkins-ns
kubectl apply -f .
kubectl get roles -n jenkins-ns
kubectl get sa -n jenkins-ns
kubectl get rolebinding -n jenkins-ns
kubectl describe secret -n jenkins-ns jenkins-token
```
