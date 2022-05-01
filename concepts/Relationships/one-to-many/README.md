# concepts - Relationships - one-to-many



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







