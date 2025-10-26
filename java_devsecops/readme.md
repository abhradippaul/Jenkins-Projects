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

```
helm install maven-app ./maven-app-chart --set image.repository=abhradippaul/maven-devsecops --set image.tag=v1
```

### ArgoCD setup in Kubernetes

```bash
# Create argocd namespace
kubectl create ns argocd

# Add argocd repository using helm
helm repo add argo https://argoproj.github.io/argo-helm
helm repo update

# Install argocd with helm
helm install -n argocd argocd argo/argo-cd \
--set server.service.type=NodePort \
--set server.service.nodePort=30080 \
--set server.service.port=80

# Get ArgoCD password
kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
# Username will be admin by default
```
