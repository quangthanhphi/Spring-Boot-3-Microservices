# Spring-Boot-3-Microservices

Stack:
Testing with Wiremock
API Gateway using Spring Cloud Gateway MVC
Secure with Keycloak
Document REST API with OpenAPI
Circuit Breaker
Angular App
Event Driven Architecture using Kafka
Observability using Grafana Stack (Prometheus, Loki,Tempo)
Deploy to Kubernetes
Kind sign k8s
Image:
[Architecture.jpg]
[Screenshot.jpg]

1. Grafana:http://localhost:3000
2. Prometheus:http://localhost:9090
3. Tempo:http://localhost:3110
4. Loki:http://localhost:3100
5. Frontend: http://localhost:4200
6. Product Service: http://localhost:8080
7. Order Service: http://localhost:8081
8. Inventory Service: http://localhost:8082
9. Notification Service: http://localhost:8083
10. API Gateway: http://localhost:9000

mvn clean compile package
mvn spring-boot:build-image -DskipTests -Dspring-boot.build-image.publish=true -DdockerPassword=...

kubectl create deployment mysql --image=mysql:8.3.0 --port=3306 --replicas=1 --dry-run=client -o yaml
kubectl create service clusterip mysql --tcp=3306:3306 --dry-run=client -o yaml
kubectl create secret generic mysql-secrets --from-literal=mysql_root_password=mysql --dry-run=client -o yaml
kubectl apply -f mysql.yaml
kubectl get all
kubectl get pods
kubectl logs -f mysql-58db7c4b47-s7rrw
kubectl port-forward svc/mysql 3306:3306       
mysql -h 127.0.0.1 -P 3306 -u root -p

Cmd + Shift + R: find and replace
