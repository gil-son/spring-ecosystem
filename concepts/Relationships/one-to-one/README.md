# concepts - Relationships - one-to-one

## Diagram

<div align="center"><img src="https://www.baeldung.com/wp-content/uploads/2018/12/1-1-SK.png"/></div>

<hr/>

## Exemple

```
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    //... 

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // ... getters and setters
}


```

```
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    //...

    @OneToOne(mappedBy = "address")
    private User user;

    //... getters and setters
}
```

## Resource

<a href="https://www.baeldung.com/jpa-one-to-one">Baeldung - One-to-One Relationship in JPA </a>


<hr/>


