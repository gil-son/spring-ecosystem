
### Redis

Why is Redis important?

Imagine you have an application, and a user needs to access information. The application accesses the database – that's fine. However, moments later, the same user needs the same information again. If your application didn't save the information, it would be necessary to access the database once more. This process consumes time and resources. Now, multiply that action by millions of user actions. It can become a problem!

On the other hand, when a user needs to retrieve information from the database, your application retrieves the information and delivers it to them. Moments later, if the user needs the same information again and your application has that information in the cache (Redis), your application doesn't need to access the database again! The consequences of this action are time and resource savings.

<div align="center"> 
    <img src="https://thumbs2.imgbox.com/ca/f7/2Qc36hnT_t.png">  
</div>



### Docker

In this project, in application.properties file contains configurations to access Redis in localhost

<ol>
<li>So, if you don't have a docker installed, install it!</li>
<li>Download the latest version of redis:
  
```
docker pull redis:latest
```

</li>
<li>Execute the following command:
  
```
docker run -d --name my-redis-container -p 6379:6379 redis:latest
```

</li>
</ol>


### Project

To execute the project, follow these steps:

<ol>
<li>Open your preferred IDE</li>
<li>Import the project into the IDE</li>
<li>Update Maven dependencies</li>
<li>Run the project</li>
</ol>

### Source

<a href="https://www.youtube.com/watch?v=YcI9b-lgi7w)https://www.youtube.com/watch?v=YcI9b-lgi7w">Giuliana Bezerra - Aprenda a usar cache nos seus projetos Spring Boot!</a>

