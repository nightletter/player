
### keyCloak in Docker
docker run --name keycloak -d -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev

### zipkin
docker run -d -p 9411:9411 openzipkin/zipkin