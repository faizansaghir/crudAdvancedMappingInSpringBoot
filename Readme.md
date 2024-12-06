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
2. <strong>@OneToOne with mappedBy</strong> <br>
    When the annotation <code>@OneToOne</code> is used with <code>mappedBy</code> attribute, it can be used to set up bidirectional mapping. <br>
    The <code>mappedBy</code> attribute takes the name of the field in parent entity class which is referencing the current entity. <br>
    <em>Note: The parent entity class is the one mapped to table containing the foreign key column.</em> <br>
    <pre>Example:
        @Entity
        @Table(name = "instructor_detail")
        public class InstructorDetail {
            ...
            @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
            private Instructor instructor;
            ...
        }
    <em>The above code maps the instructor field using the instructorDetail field in the Instructor entity</em></pre> <br>