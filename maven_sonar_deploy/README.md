# 🚀 CI/CD Pipeline with Jenkins, ArgoCD & Kubernetes

This project demonstrates a complete CI/CD workflow using Jenkins, Maven, SonarQube, Docker, GitHub, ArgoCD, and Kubernetes (kubeadm setup). The pipeline automates code integration, testing, image building, deployment, and production rollout.

---

## 🛠 Tech Stack

- **Jenkins** – Automation server for CI/CD
- **Maven** – Build automation tool
- **SonarQube** – Code quality and security analysis
- **Docker** – Containerization platform
- **GitHub** – Source code version control
- **ArgoCD** – GitOps deployment tool
- **Kubernetes (kubeadm)** – Container orchestration platform

---

## 📌 Workflow Overview

GitHub → Jenkins → Maven → SonarQube → Docker Hub → GitHub (YAML) → ArgoCD → Kubernetes


This pipeline implements continuous integration and GitOps-based continuous deployment.

---

## 🔁 Step-by-Step Process

### 1. 🧑‍💻 Code Commit
- Developers push application code to GitHub.

### 2. 🔄 Jenkins Trigger
- Jenkins is triggered either via webhook or polling.
- It uses a **Docker agent** to create an isolated build environment.

![Screenshot 2025-04-09 214314](https://github.com/user-attachments/assets/91ef1308-76e9-48ce-9afd-828a5c906284)


### 3. 🧱 Build with Maven
- Jenkins compiles the Java source code.
- Generates a `.jar` file using Maven.

### 4. 🧪 Code Quality Check
- Jenkins sends the code to **SonarQube** for analysis.
- SonarQube evaluates:
  - Bugs
  - Vulnerabilities
  - Code smells
  - Test coverage
- If the **quality gate fails**, the pipeline stops.

![Screenshot 2025-04-09 214635](https://github.com/user-attachments/assets/5ae9557c-79ff-4ac2-bdc7-53ed5367bb4b)


### 5. 🐳 Build Docker Image
- Jenkins builds a Docker image of the application.
- Tags the image with the build number or Git commit SHA.
- Pushes it to **Docker Hub**.

![Screenshot 2025-04-09 214555](https://github.com/user-attachments/assets/61876d4d-e347-40d4-b11e-7e149217c57b)


### 6. 📝 Update Deployment YAML
- Jenkins updates the Kubernetes deployment YAML file with the **new Docker image tag**.
- Commits and pushes the updated YAML back to **GitHub**.

![Screenshot 2025-04-09 214709](https://github.com/user-attachments/assets/06e6fafb-4c11-49a7-8355-d8c8643882ff)

### 7. 🔄 ArgoCD Sync
- ArgoCD monitors the GitHub repository.
- Detects changes to the deployment manifest.
- Applies the updated YAML to the **Kubernetes cluster** automatically.

![Screenshot 2025-04-09 220934](https://github.com/user-attachments/assets/aa05dd66-e3f5-4c57-8137-7bcceb66407b)

---

## 📂 Project Structure (Example)

├── maven_sonar_deploy
     └── manifests/
           └── deployment.yaml
           └── service.yaml
     └── Jenkinsfile
     └── template.yaml
     └── deployment.yaml
└── README.md



🎯 Result
🚀 End-to-end CI/CD from source code to production

✅ Quality gated builds with SonarQube

📦 Containerized application deployment

🤖 Automated GitOps delivery using ArgoCD

![Screenshot 2025-04-09 215033](https://github.com/user-attachments/assets/67145658-9831-4433-8bd7-65df88f2d4c6)
![Screenshot 2025-04-09 215050](https://github.com/user-attachments/assets/b5f91899-17d6-4af9-9a39-b9a3bc8f4180)


📺 ArgoCD Dashboard
You can monitor your application’s state in real-time using the ArgoCD web interface. It provides features such as:

Application status
Sync status
Rollback options
Deployment history


## 🧠 Conclusion – What I Learned

Through this project, I gained hands-on experience and a deep understanding of how modern DevOps practices come together to create a reliable, automated CI/CD pipeline. Key learnings include:

- 🔄 Setting up a complete CI/CD pipeline using Jenkins with Docker agents.
- ⚙️ Automating builds and tests using Maven.
- 🧪 Integrating SonarQube for code quality checks and enforcing quality gates.
- 🐳 Building and managing Docker images, and pushing them securely to Docker Hub.
- 📝 Dynamically modifying Kubernetes deployment manifests within a pipeline.
- 🤖 Implementing GitOps using ArgoCD to auto-deploy applications to a Kubernetes cluster.
- 📦 Deploying containerized applications on a Kubernetes cluster built with kubeadm.

This project gave me end-to-end visibility of a DevOps workflow, improved my understanding of GitOps, and taught me how to manage microservice deployments effectively with modern tools and automation.
