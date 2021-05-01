# Dev Superior - Domain Model

## Diagram UML

### CLASS

<a href="https://imgbox.com/MDqmkboA" target="_blank"><img src="https://images2.imgbox.com/ce/3b/MDqmkboA_o.png" alt="image host"/></a>


### Analyze

<p>The 'Client' entity will be used to create the client object
according to their attributes and methods. The entity is associated
'Order', your relationship is 1, that is, 1 customer has an order.</p>


<p>The 'Order' class receives specific orders
of the entity 'OrdemItem' the relationship of entities is
composition, in which case it is too many items for one
order, 1 order from many items. The entity
'Order' only has sense, it will only have order events, if the entity
'OrderItem' exists.</p>

<p>Each item of 'OrdemItem' is a product, has the association 1
'Product' to 'OrderItem'. The 'Product' entity will serve to
create products according to their attributes and methods.</p>


<p>The entity 'OrderStatus' has no relation, but it serves to
indicate the status an order is in.</p>





### OBJECT

<a href="https://imgbox.com/ZExJerpP" target="_blank"><img src="https://images2.imgbox.com/51/1e/ZExJerpP_o.png" alt="image host"/></a>

### Analyze

<p>In this diagram, an object was created with the name Alex, it has the
id: 1, and from this object 2 distinct associations were made to
the class 'Order' one with the id: 1, the date 2021-04-18 with the status of 'PAID'
and another with the id: 2 on the date 2021-04-20 with the status of 'WAITING'.</p>


<p>The first 'Order' order has 2 separate 'OrderItem' items,
one with id: 1, quantity: 1 and price: 1000.0
other with id: 2, quantity: 1 and price: 40.0.</p>


<p>The second order 'Order' has 2 distinct items 'OrderItem',
one with id: 3, quantity: 1 and price: 40 .0
other with id: 4, quantity: 1 and price: 1200.0.</p>


<p>Each item in the 'OrderItem' has its corresponding product in the
class 'Product'. So if we take the 'Order' from id: 1
we will have 1 product of 1,000 plus the sum of 2 products of
40.0 which makes a total of 1080 for the 'OrderItem' of the day
2021-04-18.</p>


## Technical prerequisites
<ul>
  <li><a href="https://en.wikipedia.org/wiki/Object-oriented_programming">Object-oriented programming<a/></li>
  <li>Relationship between classes</li>
</ul>

## Utilities
<ul>
  <li>Workspace-Spring-Tool-Suite-4-4.9.0</li>
  <li><a href="https://insomnia.rest/download">Insomnia<a/> or <a href="https://www.postman.com/">Postman<a/></li>
</ul>


## Configuration

<ul>
  <li>Spring Boot Version: 2.4.5</li>
  <li>Type: Maven</li>
  <li>Packaging: Jar</li>
  <li>Java Version: 11</li>
  <li>Languagem: Java</li>
 </ul>


## Available

<ul>
  <li><a href="https://spring.io/projects/spring-ws">Spring Web (starter and dependencies)<a/> </li>
  <li><a href="https://spring.io/projects/spring-data-jpa">JPA<a/></li> 
  <li><a href="https://spring.io/guides/gs/accessing-data-mysql/">H2 Database<a/></li>
</ul>


## Source
<ul>
  <li><a href="https://www.youtube.com/watch?v=OX5MmJrFTdw">DevSuperior -Modelo de domínio : como implementar no Spring</a> </li>
</ul>
