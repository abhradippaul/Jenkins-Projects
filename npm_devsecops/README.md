### Ngrok

Create Ngrok container to expose local environment

```bash
# Run the docker container
docker run -it --rm -e NGROK_AUTHTOKEN=<token> ngrok/ngrok http <server-url>:8080 --url <url>
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

### ArgoCD secret

```bash
# Run this command to get the secret
kubectl get secret -n argo argocd-initial-admin-secret -ojsonpath={.data.password} | base64 -d
```

Access the service on port **32001**
