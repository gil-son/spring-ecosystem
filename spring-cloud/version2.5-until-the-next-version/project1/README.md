# Ports Standardization

<div align="center"><img src="https://thumbs2.imgbox.com/42/29/6qovsXzK_t.png"/></div>


# Communication between projects

## diagram

<div align="center"><img src="https://thumbs2.imgbox.com/da/57/Fv0Y91PJ_t.png" /></div>

## limits-service

The limits-service is the local to create the variables to different scenarios

## Project spring-cloud-config-server

That microservice contain the configuration to cloud. Use the git-localconfig the choose the configs. The limits-service is combined with spring-cloud-config-server.

### Need for centralized configuration

<div align="center"><img src="https://thumbs2.imgbox.com/6d/fe/JDgTdTcV_t.png" alt="image host"/></div>

<div align="center"></div>

### environment

<div align="center"><img src="https://thumbs2.imgbox.com/7f/b7/pZ9wmgcy_t.png" /></div>


<div align="center"><img src="https://thumbs2.imgbox.com/96/86/kncvkFn0_t.png" /></div>

### endpoint

- ```http://localhost:8080/limits```
- ```http://localhost:8888/microservice-x/default```
- ```http://localhost:8888/microservice-x/dev```
- ```http://localhost:8888/limits-service/dev```
- ```http://localhost:8888/limits-service/qa```


## Project currency-exchange-service

That project access the spring-cloud-config-server to get configs.

### endpoint
-```http://localhost:8000/currency-exchange/from/USD/to/INR``` or 8001

response by GET method:
```
{
"id":10001,
"from":"USD",
"to":"INR",
"conversionMultiple":65.00,
"environment":"8000 instance-id"
}
```


## Project currency-conversion-service


That project access the currency-exchange-service to get one or more microservices.


### endpoints

- ```http://localhost:8100/currency-conversion-rest-template/from/USD/to/INR/quantity/10```
- ```http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10 ```
- ```http://localhost:8000/sample-api```

response by GET method:

```
{
"id": 10001,
"from": "USD",
"to": "INR",
"conversionMultiple": 65.00,
"quantity": 10,
"totalCalculatedAmount": 650.00,
"environment": "8000 instance-id"
}
```

### naming-server

That project can be manager one or more endpoints/microservices from currency-exchange-service and send to currency-conversion-service. Work with Load Balancing.

### diagram

<div align="center"><img src="https://thumbs2.imgbox.com/d7/55/4wCHWfKX_t.png" /></div>


<div align="center"><img src="https://thumbs2.imgbox.com/23/6b/i71KSqCs_t.png" /></div>


### Project api-gateway

In the previous few steps, we implemented currency-conversion-service, currency-exchange-service, limits-service (all microservices) and typical microservices
architectures. There would be hundreads of microservices like these and these microservice have a lot of common features: authentication, authorization, logging,
rate limiting... Where do you implement all these common features? Well, the solution is an API gateway. In this case Spring Cloud Gateway

<div align="center"><img src="https://thumbs2.imgbox.com/99/e8/8WRfTZZJ_t.png" /></div>



### Circuit Breaker

<div align="center"><img src="https://thumbs2.imgbox.com/f4/6c/HQqSIgiF_t.png" /></div>



### Usage

1. start the limits-service, spring-cloud-config-server, currency-conversion-service, currency-exchange-service and naming-server

2. In currency-conversion-service, create more microservices:

<div align="center"><img src="https://thumbs2.imgbox.com/83/e2/STTyN52X_t.png" /></div>
<div align="center"><img src="https://thumbs2.imgbox.com/09/33/MfmDLEvy_t.png" /></div>

3. Look in the naming server

<div align="center"><img src="https://thumbs2.imgbox.com/4a/3f/88w6NpNK_t.png" /></div>

4. Test call the endpoint and see Eureka with Load Balance in action

<div align="center"><img src="https://thumbs2.imgbox.com/13/97/Q6Z8yAs4_t.png" /></div>
<div align="center"><img src="https://thumbs2.imgbox.com/b6/e9/F1BUagQZ_t.png" /></div>

5. Test the routes with Load Blancing:

```
http://localhost:8765/get
http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10
http://localhost:8765/currency-conversion-rest-template/from/USD/to/INR/quantity/10
http://localhost:8765/currency-exchange/currency-exchange/from/EUR/to/INR
http://localhost:8765/currency-conversion/currency-conversion-feign/from/USD/to/INR/quantity/10
http://localhost:8765/currency-conversion/currency-conversion-rest-template/from/USD/to/INR/quantity/10
```

6. Testing a lot of requests to localhost:8000/sample-api. 

(If you are on windows, you can try firing in 100-200 quick requests from the browser by quicklyrefreshing)

curl:

```
curl http://localhost:8000/sample-api
```

in unix SO, you cam watch + curl:

```
watch curl http://localhost:8000/sample-api
```

number of request by second(s):

```
watch -n 0.1 http://localhost:8000/sample-api
```

7. Testing rate limiter

```
curl http://localhost:8000/sample-api
```

# Source

<ul>
  <li>
     <a href="https://github.com/in28minutes/spring-microservices-v2"> in28minutes</a>
  </li>
</ul>

# Steps and Support

<li>
     <a href="https://github.com/in28minutes/spring-microservices-v2/tree/main/02.restful-web-services">Steps with examples</a>
</li>

<li>
     <a href="https://github.com/in28minutes/spring-microservices-v2/blob/main/03.microservices/01-step-by-step-changes/microservices-v2-1.md">01-step-by-step-changes</a>
</li>


# Resources

<li>
     <a href="https://www.in28minutes.com/microservices-course-resources">Resources</a>
</li>
