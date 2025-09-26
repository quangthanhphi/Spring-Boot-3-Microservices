#kind viết tắt của Kubernetes IN Docker — là công cụ dùng để tạo một cụm Kubernetes
# (cluster) chạy bên trong Docker containers trên máy local.
#thay vì cần cài đặt Kubernetes phức tạp (như trên cloud hay dùng kubeadm),
# kind cho phép dựng cụm Kubernetes ngay trên máy dev
#!/bin/bash
export PATH=$(go env GOPATH)/bin:$PATH

kind create cluster --name microservices --config kind-config.yaml