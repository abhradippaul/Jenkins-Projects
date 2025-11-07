FROM jenkins/jenkins:lts

USER root

RUN apt update && apt upgrade -y

RUN apt install wget gnupg docker.io -y
RUN wget https://deb.nodesource.com/setup_24.x 
RUN chmod +x setup_24.x && ./setup_24.x
RUN wget -qO - https://aquasecurity.github.io/trivy-repo/deb/public.key | gpg --dearmor | tee /usr/share/keyrings/trivy.gpg > /dev/null
RUN echo "deb [signed-by=/usr/share/keyrings/trivy.gpg] https://aquasecurity.github.io/trivy-repo/deb generic main" | tee -a /etc/apt/sources.list.d/trivy.list
RUN apt update && apt install trivy nodejs -y