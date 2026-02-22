##  Overview

The **Secure Distributed Banking System** is designed to simulate a modern financial backend
capable of handling concurrent requests, preventing fraud vectors (like IDOR and duplicate
transactions), and scaling horizontally under load.

The system follows **clean architecture principles** and incorporates **security-first
development practices**.

---

##  Architecture Highlights

- RESTful Microservice Design
- JWT-Based Authentication & RBAC Authorization
- IDOR Prevention via Ownership Validation
- Idempotent Transaction Handling
- Redis Caching & Rate Limiting
- Event-Driven Processing with Kafka
- MySQL Relational Database with Indexing
- Asynchronous Processing
- Load Balancing Ready
- Sharding & Replication Compatible Design

---

##  Tech Stack

| Layer          | Technology                              |
|----------------|-----------------------------------------|
| Backend        | Java, Spring Boot                       |
| Security       | Spring Security, JWT, bcrypt, AES       |
| Database       | MySQL (Indexed Relational Schema)       |
| Caching        | Redis                                   |
| Messaging      | Apache Kafka                            |
| Infrastructure | Docker, Nginx (Load Balancing Ready)    |

---

## Architecture
```
+-------------------+
|   Client Apps     |
| (Web / Mobile)    |
+---------+---------+
          |
          v
+-------------------+
|   Load Balancer   |
+---------+---------+
          |
          v
+-------------------+
|    API Gateway    |
| Auth | Rate Limit |
+---------+---------+
          |
          v
+-------------------+
|  Banking Service  |
| (Spring Boot)     |
+----+------+-------+
     |      |
     v      v
+---------+  +--------------+
|  Redis  |  |    MySQL     |
| Cache & |  | Indexed Tbls |
| Throttle|  | + Replication|
+---------+  +--------------+
     |
     v
+-------------------+
|  Kafka Cluster    |
| Async Processing  |
+---------+---------+
          |
          v
+-------------------+
| Audit / Ledger DB |
+-------------------+
```

##  Security Features

- JWT-based stateless authentication
- Role-Based Access Control (RBAC)
- IDOR mitigation using resource ownership validation
- Password hashing with bcrypt (collision-resistant)
- AES-based sensitive data encryption
- Idempotency keys to prevent duplicate transactions
- API rate limiting to mitigate brute-force and abuse

---

##  Performance & Scalability

- Redis-backed caching layer reducing database hits
- Optimized SQL queries with indexing
- Asynchronous Kafka consumers for non-blocking processing
- Horizontal scaling ready architecture
- Designed to handle:
  - ~20K+ API requests/day
  - ~25K+ financial events/day
  - Sub-300ms average response latency under moderate load

---

##  Core Modules

| Module                  | Responsibility                          |
|-------------------------|-----------------------------------------|
| Authentication Service  | JWT issuance & validation               |
| Account Service         | Balance management & ownership checks   |
| Transaction Service     | Idempotent fund transfers               |
| Event Processor         | Kafka-based transaction logging         |
| Audit Layer             | Immutable transaction tracking          |

---

##  System Design Concepts Demonstrated

- Distributed Systems Fundamentals
- Event Sourcing Basics
- Read/Write Separation
- Database Indexing & Query Optimization
- Concurrency Handling
- Failure Recovery & Retry Logic

---

##  Testing & Validation

- Input validation using Spring Validation
- Integration testing for transaction flows
- Security validation for unauthorized access attempts
- Load testing with concurrent request simulation

---

##  Future Enhancements

- Circuit breaker implementation (Resilience4j)
- Observability stack (Prometheus + Grafana)
- Kubernetes deployment
- Multi-region replication
- Full event sourcing with snapshotting

---

##  Purpose of This Project

This repository demonstrates backend engineering skills relevant to:

- FinTech systems
- Distributed microservices
- Secure API development
- High-performance backend design
- Production-ready architecture patterns
