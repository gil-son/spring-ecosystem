# concepts - Relationships - many-to-one OR one-to-many



<b>One</b> Course has <b>Many</b> offers:

```
@Entity
@Table(name = "tb_course")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imgUri;
    private String imgGrayUri;

    @OneToMany(mappedBy = "course") // 'course' is the oposito of the 'offer'
    private List<Offer> offers = new ArrayList<>();

    public Course() {}

    public Course(Long id, String name, String imgUri, String imgGrayUri) {
        this.id = id;
        this.name = name;
        this.imgUri = imgUri;
        this.imgGrayUri = imgGrayUri;
    }

    /* Getters and Setters */
    
```

See more: <a href="https://github.com/gil-son/bds-dslearn/blob/main/backend/src/main/java/com/devsuperior/dslearnbds/entities/Course.java">link</a>



<b>Many</b> Offer(s) has <b>one</b> course:

```

@Entity
@Table(name = "tb_offer")
public class Offer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String edition;
    private Instant startMoment;
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "offer") // 'offer' is the oposito of the 'resource'
    private List<Resource> resources = new ArrayList<>();

    public void Offer(){}

    public Offer(Long id, String edition, Instant startMoment, Instant endMoment) {
        this.id = id;
        this.edition = edition;
        this.startMoment = startMoment;
        this.endMoment = endMoment;
    }
    
    /* Getters and Setters */

```

See more: <a href="https://github.com/gil-son/bds-dslearn/blob/main/backend/src/main/java/com/devsuperior/dslearnbds/entities/Offer.java">link</a>


In your data.sql:

```

INSERT INTO tb_course (name, img_uri, img_Gray_Uri) VALUES ('Bootcamp HTML','https://cdn.pixabay.com/photo/2020/05/31/09/30/online-course-5241968_1280.jpg','https://cdn.iconscout.com/icon/free/png-256/certificate-3155213-2630879.png');

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-11-20T03:00:00Z', 1);

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2020-12-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-12-20T03:00:00Z', 1);

```

See more: <a href="https://github.com/gil-son/bds-dslearn/blob/main/backend/src/main/resources/data.sql">link</a>



## Resource

<ul>
  <li><a href="https://github.com/gil-son/bds-dslearn">bds-dslearn</a></li>
</ul>


## Source

<ul>
  <li><a href="https://devsuperior.com.br/">DevSuperior</a></li>
</ul>


