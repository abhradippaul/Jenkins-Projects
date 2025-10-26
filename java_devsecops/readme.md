# Maven DevSecOps CI/CD Pipeline with Jenkins

This project demonstrates a complete DevSecOps pipeline built using Jenkins, integrating code compilation, testing, static analysis, image scanning, and automated deployment through Kubernetes and ArgoCD.

<img width="1793" height="671" alt="Screenshot 2025-10-26 210948" src="https://github.com/user-attachments/assets/d5bb666a-0447-45da-87e7-8ddef204af81" />

## Jenkins Plugins Required

Before running the pipeline, make sure these plugins are installed in Jenkins:

- Eclipse Temurin installer
- Config File Provider
- Pipeline Maven Integration
- Pipeline Maven Plugin API
- SonarQube Scanner
- Docker
- Docker Pipeline
- Kubernetes
- Kubernetes Client API
- Kubernetes Credentials
- Kubernetes CLI

## Pipeline Stages

The Jenkins pipeline consists of the following stages:

Git Checkout – Clones the source code from GitHub
Compilation Code – Compiles Java code using Maven
Test Compilation – Runs unit tests
File System Scan – Scans filesystem using Trivy
SonarQube Analysis – Performs static code analysis
Quality Gate – Ensures code quality threshold is met
Build – Packages the Java application using Maven
Publish to Nexus – Uploads artifact to Nexus Repository
Login to DockerHub and Build Image – Builds and logs in to DockerHub
Scan Docker Image – Scans the Docker image for vulnerabilities
Publish to DockerHub – Pushes the image to DockerHub
Git Checkout for Kubernetes Files – Clones deployment repo
Push Changed YAML – Updates image tag in Helm values.yaml and pushes change to GitHub

## Prerequisites

Before running the pipeline, ensure the following setups are complete:

✅ Jenkins installed and running

✅ Docker installed and configured

✅ Kubernetes cluster setup and running

✅ Helm installed and configured

✅ Ngrok need for local setup

### Create Ngrok container to expose local environment

```bash
# Run the docker container
docker run -it --rm -e NGROK_AUTHTOKEN=<token> http 8080 --url <url>
```

Ngrok container will be used to expose local jenkins to use for webhook.

### Setup SonarQube and Nexus using Docker Compose

```bash
# Go to the java_devsecops folder
cd Jenkins-Projects/java_devsecops

# Run docker compose to start SonarQube and Nexus
docker compose up --detach
```

You can access sonarqube on 9000 port and nexus on 8081 port.

### ArgoCD Setup in Kubernetes

```bash
# Create ArgoCD namespace
kubectl create ns argocd

# Add ArgoCD Helm repository
helm repo add argo https://argoproj.github.io/argo-helm
helm repo update

# Install ArgoCD using Helm
helm install -n argocd argocd argo/argo-cd \
--set server.service.type=NodePort \
--set server.service.nodePort=30080 \
--set server.service.port=80

# Get ArgoCD admin password
kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
```

Default username: admin

Verify ArgoCD on port 30080. We need to setup argocd and create new app which will be triggered when in github a repo changes.
