# microservices-quiz-application

Simple backend of quiz application following microservices arhitecture

## To establish connection between 2 microservices

-> Add `Open Fiegn` dependency in the service which is calling other service
-> like Quiz ---(calling)---> Question, so we will add dependecy in `Quiz` service
-> Add `@EnableFeignClient` in main application, otherwise it will not able to access the bean
-> Create an interface, annotate it with `@FeignClient()` so it can be Autowired
-> Use that interface wherever you want to use it

## To register in Registry Service

-> First create `Registry Service`
-> Add `Eureka Client` dependency in service, which you want to register or make server @Registry Service
-> Disable server from becoming client using below code
->

```
    #Disable as client
      eureka.client.register-with-eureka=false
      eureka.client.fetch-registry=false
```

-> And make other service add client using below code :

```
eureka.instance.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
```

-> here, 8761 is the `server.port` for Registry service's Server

## To create API gateway

-> Add `gateway` dependency

-> Configure routes like below for various services
->

```
    # routes configuration
    spring.cloud.gateway.routes[0].id=QUESTION-SERVICE
    spring.cloud.gateway.routes[0].uri=lb://QUESTION-SERVICE
    spring.cloud.gateway.routes[0].predicates[0]=Path= /question/**, /weCanAddMore/also/**
```
