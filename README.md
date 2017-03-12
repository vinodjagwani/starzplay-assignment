# Instruction for starzplay assignment

1. This project is based on microservice architecture using springboot which can be deploy on docker container to
make it highly scale able. The purpose of this application to create api which filter the metadata coming from external
source


# Project's structure:

1. There are 2 projects in whole assignment which will run separately, one is assignment microservice and other is
spring cloud eureka server microservice which is primarily used in the AWS cloud for locating services for the purpose
of load balancing and failover of middle-tier servers, while we run  both application together, eurka server
application will registered the instance of assignment service, and you can register as many services.

2. The assignment service also has FeignClient the purpose of this is to  makes writing web service clients easier.
To use Feign create an interface and annotate it. However Making REST API calls from one service to another is a
very common pattern in microservice applications so this functionality will prove particularly useful.
Feign also offers a solution to dynamically generate clients from the interface. Additional benefit is that we can keep
the signature of the service and client identical.

3. The assignment service also has Swagger2 capability, all APIs are documented with nice interface where user
can test the API as well as see the whole documentation of API

4. This project also contains docker file which is optional, a person can directly create a docker image
and can push into docker registry.


# How to run application
1. eurka
First we need to run eurka server application which will register the
assignment service. For running eurka server application we must have
gradle and once you setup it then just type on the root of project
"gradle bootRun" and eureka service will be up. You can check by hitting
following url.

URL: http://localhost:8761/

2.starzplay-assignment
Once eureka server application starts then you have to go to root of assignment
service application where you have to type command "gradle bootRun".
Once application successfully up without any errors then you can hit the url in your browser based on your
filter and level values.

http://localhost:8082/api/v1/media?filter=censoring&level=censored

Note: While both application up then you can check the status of assignment service on
eureka server by hitting http://localhost:8761/


# Framworks and Libraries are used for both project
java8, springboot, springmvc, springcloud, springcloud-netflix springfox swagger,
springcloud-feign, springcloud-eureka-server, gradle,






