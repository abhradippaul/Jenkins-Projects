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
helm upgrade --install argocd argo/argocd-apps \
-n argo -f argocd-values.yaml
```
