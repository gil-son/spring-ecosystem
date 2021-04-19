# Concepts



### What happened to Jakarta EE (Java EE)?

<p>As Oracle was not giving so much support to Java EE, they preferred to pass the specification code to the Eclipse Fundantion. In this transition process, the EE platform was renamed Jakarta EE, as the word 'Java' is a registered trademark of Oracle. So, today, when someone talks about Java EE, they will be talking about Jakarta EE.</p>

<p>Jakarta EE, is based on specifications, it is not the final product. The idea of a specification is to standardize a technology. Therefore, it is not always innovated, as it is focused on standardizing what already exists. Different from Spring, which always seeks to innovate.</p>

<p>Example:</p>

<p>JPA is a specification that is within the JEE. And, JPA is a standardization of something that already existed which is hibernate. When hibernate started to implement specifications, it became a JPA product.</p>

<p>However, there are other competitions, that is, JPA implementations. However, the most used is hibernate.</p>

<p>Strong points:</p>

<ul>
<li>Portability</li>
<li>Standardization</li>
<li>Stability</li>
</ul>

<p>It is always important to check the compatibility of the versions.</p>

<p>Jakarta EE and Spring have their applications, they work distinctly, but there may be situations where they are integrated into a project.</p>

<p>For example:
<ul>
<li>Spring MVC has a Servlet which is a specification of Jakarta EE;</li>
<li>Spring Data JPA has JPA which is a specification of Jakarta EE;</li>
<li>Jakarta EE and combine with Spring Security.</li>
</ul>

<p>So, regardless of which platform to choose, there is a way to implement things from the other platform.</p>

<p>As spoken, they work in different ways. For example:
<ul>
<li>Dependency injection in Jakarta EE is the CDI and in Spring the Spring Framework itself;</li>
<li>REST API, in Jakarta EE Jaxrs and with Spring, we use Spring MVC.</li>
</ul>
<p>So it is possible for both to blend into one project.</p>
