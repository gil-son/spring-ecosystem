

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
