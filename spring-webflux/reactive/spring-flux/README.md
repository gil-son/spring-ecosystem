# Reactive - Spring-Flux

![image](https://media-exp3.licdn.com/dms/image/C4D12AQFh2-OuSjBb3g/article-cover_image-shrink_600_2000/0/1576708691092?e=1632355200&v=beta&t=cXtszFPQ08AMd1_r-Sc6dqp4C3emEX0LHCL6ZdUIakg)

## Introduction

<p> Spring-WebFlux is a new module that was introduced in Spring Framework 5.0</p>

<p> Spring-WebFlux was created to allow you to reactively program within Spring. So if you have a Java web application and use Spring MVC, you’re programming synchronously and blocking. But what does it mean?</p>

<p>
  Imagine that your application receives several requests at once:
</p>
  <ul>
    <li>Request 1</li>
    <li>Request 2</li>
    <li>Request 3</li>
  </ul>

<p>
    Spring, will execute the first request completely and only then execute the next request, according to the order of arrival:
</p>

</p>
  <ul>
    <li>Request 1 (70%)</li>
    <li>Request 2 (0%)</li>
    <li>Request 3 (0%)</li>
  </ul>

<p>
    This is synchronous programming. Your entire process needs to wait for one step to be able to perform the next step (synchronous).
</p>

<p>
  Imagine a user requesting a large amount of data from the database ... this will take a little longer. This request will then block all subsequent requests until it is fully answered. Making the system have a bottleneck. This is working in a synchronous and blocking way.
</p>

<p>
  When you use Spring Webflux, while a request occurs, the next request can process and proceed in parallel:
</p>

</p>
  <ul>
    <li>Request 1 (70%)</li>
    <li>Request 2 (60%)</li>
    <li>Request 3 (85%)</li>
  </ul>
 
 <p>
    That's because you're working reactively, that is, asynchronously and not blocking.
 </p>
  
  



## Sources

<ul>
  <li><a href="https://www.youtube.com/watch?v=jW1YdAb3GZo&list=PL8iIphQOyG-CyD9uuRTMiqxEut5QAKHga&index=1">Spring Webflux by Michelli Brito</li>
    <li><a href="https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html">docs.spring.io - Spring Webflux </li>
      <li><a href="https://atitudereflexiva.wordpress.com/2020/12/08/spring-boot-introducao-a-programacao-reativa-com-webflux/">Spring Boot: Introdução à Programação Reativa com Webflux</li>
</ul>
