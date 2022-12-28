# Ports Standardization

<div align="center"><img src="https://thumbs2.imgbox.com/42/29/6qovsXzK_t.png"/></div>


# Communication between projects

## diagram

<div align="center"><img src="https://thumbs2.imgbox.com/da/57/Fv0Y91PJ_t.png" /></div>

## project spring-cloud-config-server

That microservice contain the configuration to cloud. Use the git-localconfig the choose the configs. The limits-service can be combined with spring-cloud-config-server.

### need for centralized configuration

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


## project currency-exchange-service

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

## project currency-conversion-service


That project access the currency-exchange-service to get one or more microservices.


### endpoints

- ```http://localhost:8100/currency-conversion-rest-template/from/USD/to/INR/quantity/10```
- ```http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10 ```

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

### naming server

That project can be manager one or more endpoints/microservices from currency-exchange-service and send to currency-conversion-service. Work with Load Balancing.

### diagram

<div align="center"><img src="https://thumbs2.imgbox.com/d7/55/4wCHWfKX_t.png" /></div>


<div align="center"><img src="https://thumbs2.imgbox.com/23/6b/i71KSqCs_t.png" /></div>


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
