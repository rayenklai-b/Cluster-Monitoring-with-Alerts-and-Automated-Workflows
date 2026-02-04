# Monitoring Dashboard

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

The platform monitors Kubernetes clusters and automatically responds to incidents through configurable workflows (notifications, pod restarts, scaling, log analysis).

---

## Technologies

| Component | Technology | Version |
|-----------|-------------|---------|
| **Backend** | Spring Boot | 3.4.3 |
| **Language** | Java | 21 |
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
7. **Reporting**: Event history accessible via backend API
