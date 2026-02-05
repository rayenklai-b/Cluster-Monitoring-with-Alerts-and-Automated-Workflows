# Cluster Monitoring with Alerts and Automated Workflows

> Cloud-native DevOps monitoring and automation platform for Kubernetes applications

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
---

## About

Monitoring Dashboard is a DevOps monitoring and automation platform designed for Kubernetes environments. It combines metrics collection, visualization, and automated remediation workflows.

### Project Goal

This project integrates three main components:

- **Prometheus**: Collects cluster metrics (CPU, memory, pod status, latency, errors)
- **Grafana**: Provides dashboards and alert configuration
- **n8n**: Executes automated workflows triggered by alerts
- **Angular Dashboard**: Central portal for monitoring, incident management, and workflow control
  
The platform monitors Kubernetes clusters and automatically responds to incidents through configurable workflows (notifications, pod restarts, scaling, log analysis).

---

## Technologies

| Component | Technology | Version |
|-----------|-------------|---------|
| **Backend** | Spring Boot | 3.4.3 |
| **Frontend** | Angular | 18 |
| **Database** | PostgreSQL | 15 |
| **Security** | Spring Security + JWT | 6.x |
| **API Documentation** | Swagger/OpenAPI | 2.3.0 |
| **Metrics Collection** | Prometheus | .. |
| **Visualization** | Grafana | .. |
| **Workflow Automation** | n8n | .. |
| **Build Tool** | Maven | 3.x |

---

## Monitoring Architecture

### Automation Flow

1. **Collection**: Prometheus scrapes Kubernetes cluster metrics
2. **Visualization**: Grafana displays dashboards and evaluates alert rules
3. **Detection**: Alerts trigger on defined thresholds (pod down, CPU > 80%, 5xx errors)
4. **Notification**: Alertmanager sends webhooks to n8n
5. **Automation**: n8n executes predefined workflows:
   - Sends Slack/Email notifications
   - Analyzes logs and metrics
   - Executes remediation actions (restart, scale, escalate)
   - Logs events to backend
6. **Verification**: n8n confirms issue resolution
7. **Reporting**: Event history accessible via backend API and Angular dashboard
---

## 🚀 Getting Started

Follow these steps to run the project locally using Docker Compose:

1. **Clone the repository**

```bash
git clone https://github.com/rayenklai-b/Cluster-Monitoring-with-Alerts-and-Automated-Workflows.git
cd Cluster-Monitoring-with-Alerts-and-Automated-Workflows
```

2. **Create or update the environment file**
   Make sure your `.env` or `.env.docker` contains the correct database credentials and other variables. You can use `.env.example` as a template:

```bash
cp .env.example .env.docker
```

3. **Build and start all services**

```bash
docker-compose up --build
```

This will start:

* PostgreSQL database (`postgres`)
* Spring Boot backend (`app`)

4. **Access the backend API documentation**
   Once the backend is running, you can test the API using Swagger:
   [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

---

