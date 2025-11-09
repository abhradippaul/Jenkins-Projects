# Node DevSecOps CI/CD Pipeline with Jenkins

This project demonstrates a complete DevSecOps pipeline built using Jenkins, integrating code compilation, testing, static analysis, dependency check, image scanning, and automated deployment through Kubernetes and ArgoCD.

<img width="1811" height="701" alt="Screenshot 2025-11-09 003347" src="https://github.com/user-attachments/assets/403622e8-2f3b-423d-863f-7bc3fe997db8" />

## Jenkins Plugins Required

Before running the pipeline, make sure these plugins are installed in Jenkins:

- Docker
- Prometheus
- SonarQube Scanner
- NodeJS
- OWASP

## Prerequisites

Before running the pipeline, ensure the following setups are complete:

- Jenkins is installed and running
- Docker installed and configured
- Kubernetes cluster setup and running
- SonarQube server configured
- Helm installed and configured
- Monitoring Jenkins and node with Grafana and Prometheus

### Jenkins, SonarQube, Node Exporter, Grafana, and Prometheus

Set up Jenkins, SonarQube, Node Exporter, Grafana, and Prometheus using Docker Compose

```bash
# Go to the java_devsecops folder
cd Jenkins-Projects/npm_devsecops

# Run Docker Compose to start Jenkins, SonarQube, Grafana, Node Exporter, Prometheus, SonarQube
docker compose up --detach
```

## ArgoCd Deployment

### Namespace argo

```bash
# Create namespace argo
kubectl create ns argo
```

### Helm Repository

```bash
# Add the helm repo for argo and update the helm repo
helm repo add argo https://argoproj.github.io/argo-helm
helm repo update
```

### Install ArgoCD

```bash
helm upgrade --install argocd argo/argo-cd \
-n argo -f argocd-values.yaml
```

### ArgoCD admin password

```bash
# Run this command to get the secret
kubectl get secret -n argo argocd-initial-admin-secret -ojsonpath={.data.password} | base64 -d
```

Default username: admin

Verify ArgoCD on port **32001**. We need to set up ArgoCD and create a new app that will be triggered when in github a repo change.
