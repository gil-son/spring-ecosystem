# concepts - Relationships - many-to-many



<b>Many</b> User(s) has <b>Many</b> offer(s) and  <b>Many</b> Offer(s) has <b>Many</b> user(s) :

[Diagram - in soon]


When there are many to many, this representation is made by a third table:

[Table - in soon]


Because it is the relationship of two tables, it is necessary to create each one:

```
 In soon

```

Notice that this table contains two FKs that represent the IDs of each table. To represent this third table using JPA, it is
necessary to create a class (entity) that has the attributes that contain the FKs:


```

In soon
    
```


In your data.sql:

```

In soon

```


