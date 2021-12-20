# springboot-rabbitmq-example

Before starting the application you have to start two docker containers

### PostgreSQL container
``docker run --name my-postgres -p 5432:5432 -e POSTGRES_PASSWORD=password -d postgres:13.1-alpine``
### RabbitMQ container
``sudo docker run --rm -it --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management``
