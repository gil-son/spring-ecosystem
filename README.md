# spring-boot-compilation


## Introduction
<p>This repository seeks to study Spring Boot, concepts, methodologies, libraries, mini-projects, etc ... It is important to understand the behind the scenes and not just code. Thus there will be a greater understanding which increase the possibilities of resolution, creation, prevention, etc.</p>



## What is Spring?</p>

<p>Spring is a backend tecnology and not only a framework, but a conjuct of projects thats resolve many problems. By have many projects inside Spring, call it ecosystem Spring.</p>

<p>The Spring help the developers in business rules, don't require spend time in organize architechure. Based on design patterns of inversion of control (IoC) and dependency injection.</p>

<p>Spring has an architecture based on interfaces and POJOs (Plain Old Java Objects).</p>

### Some reasons:

<ul>
  <li>Mult-tasks</li>
  <li>Simples: preconfigured projects to production</li>
  <li>Maturity: works with responsible and secure architectures</li>
  <li>Modular: adapted to any systems and you can build with dependencies to specific project</li>
  <li>Adaptation: It is possible to combine with other technologies outside the Spring ecosystem</li>
  <li>Constante Evolution</li>
  <li>Open Source by Pivotal</li>
  <li>Big and Strong Community: foruns, documentations, events, etc...</li>
  <li>Popularity: many companies and developers are using</li>
</ul>


### Some applications:

<ul>
  <li>Web</li>
  <li>Databases</li>
  <li>Security</li>
  <li>Validations</li>
  <li>API REST</li>
</ul>


### Who use? Somes:

<ul>
  <li>Netflix</li>
  <li>iFood</li>
  <li>99 (99 Taxi)</li>
  <li>TripAdvisor</li>
  <li>PagSeguro</li>
  <li>PayPal</li>
  <li>Cielo</li>
  <li>TransferWise</li>
  <li>Santander</li>
  <li>Itau</li>
  <li>JS Morgan</li>
  <li>MasterCard</li>
  <li>Visa</li>
  <li>Bank of America</li>
  <li>Amazon</li>
  <li>Renner</li>
  <li>Riachuelo</li>
  <li>Magazine Luiza</li>
  <li>Lojas Americanas</li>
  <li>American Express</li>
  <li>Netshoes</li>
  <li>Walmart</li>
</ul>


 ### Spring Boot vs. Spring

<p>Spring is a framework with distinct tools can be combined and Spring Boot is a enviroment prepared to production and can integrations Spring tool in modules.</p>

<p>Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".</p>

<p>Most Spring Boot applications need minimal Spring configuration.</p>


### Features

<ul>
  <li>Create stand-alone Spring applications</li>
  <li>Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)</li>
  <li>Provide opinionated 'starter' dependencies to simplify your build configuration</li>
  <li>Automatically configure Spring and 3rd party libraries whenever possible</li>
  <li>Provide production-ready features such as metrics, health checks, and externalized configuration</li>
  <li>Absolutely no code generation and no requirement for XML configuration</li>
</ul>


### Getting to know Spring Boot

<p>In the past, this was how I set up Springs projects, manually in XML. The components can be simple, but the configurations were not always. A simple typo could not be noticed and would only be noticed after running the application:</p>


<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1c45056e-55b3-42d9-a57e-42b554212378/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210420%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210420T021352Z&X-Amz-Expires=86400&X-Amz-Signature=7d089f63ab228e75c41fc6d6817555027f6eb4d1f3ba4a519fdc571d4639d92c&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22"/>


<p>For this reason, as of version 3, the configuration can be done programmatically in Java codes. This brought benefits, such as avoiding typos, since the configuration class needs to be compiled:</p>

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c6b419e1-b7bb-4a8d-91dd-25ec5a1a5949/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210420%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210420T021823Z&X-Amz-Expires=86400&X-Amz-Signature=ecf660c02055a50ffe5aec21bf7f91fae5439ed5e2efe7a66451239ad1b2a896&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22"/>

<p>Yes, we still write a lot of code and that's a good thing! However, with so much overconfiguration, the developer may lose focus on developing business rules of the application.</p>

<p>The solution is Spring Boot! For bringing a previously configured environment for production, with the possibility of integrating Springs modules, being self-configured and many other optimizations ... it makes everything more practical and accessible! It is possible to customize these settings, but many times it is not necessary, because the goal is to make the developer not worry about that part.</p>

<p>It works directly with Maven which is the dependency manager and works with pom.xml:</p>


<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6b86e700-26eb-45ab-9a50-81716f3a13fb/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210420%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210420T022504Z&X-Amz-Expires=86400&X-Amz-Signature=e5598bd7405cfef603cb82d35497dda4d669a76b928c7323e2908e725dca08c2&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22"/>

<p>Spring Boot facilitates this, as it uses Starters which are dependencies that group other dependencies:</p>


<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/22fb5ff5-6a3f-4cf9-bc25-9dac793cf4cc/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210420%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210420T022041Z&X-Amz-Expires=86400&X-Amz-Signature=3d22abaceef70f3af32289cca2da9f6f1d3ace075215551324986b6f6077d5be&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22"/>


<p>So when adding a dependency to pom.xml using Maven, it will be added to the project's Classpath. Spring Boot will always add compatible versions with Maven.</p>

### Spring Boot or Spring MVC?

<p>Spring Boot does not replace the Spring MVC!</p>

<p>Spring Boot is an abstraction layer on top of Spring, it can work as a Web and / or other applications. So he has Spring MVC. And, for Spring Boot to have a Web application, it will use Spring MVC.</p>



