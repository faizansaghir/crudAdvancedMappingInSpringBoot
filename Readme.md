<h1>Overview</h1>

Repository to track development and learning for different mappings in SpringBoot using JPA and Hibernate. 

<h2>Notes</h2>

1. <strong>@OneToOne and @JoinColumn</strong> <br>
    Annotation to set up relationship from one class to another. <br>
    &emsp;a. @OneToOne: Used to describe the cardinality mapping between the classes <br>
    &emsp;b. @JoinColumn: Used to specify on which column value the join should be performed to get the dependency class. <br>
    <pre>Example:
        @Entity
        public class Instructor {
            ...
            @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "instructor_detail_id")
            private InstructorDetail instructorDetail;
            ...
       }
    <em>The above code creates a one-to-one mapping between Instructor and InstructorDetail class 
    It uses "instructor_detail_id" column for performing the join to get InstructorDetail</em> </pre> <br>
