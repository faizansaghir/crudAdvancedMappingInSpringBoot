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
3. <strong>Setting foreign_key to Null for Parent Entity</strong> <br>
    If we do not wish to delete the parent entity but set the foreign key id column to null on deletion of sub entity, <br>
    we can follow the following steps:
    <ol>
        <li>Set cascade to all other type except <code>CascadeType.REMOVE</code> in sub entity class
            <pre>Example:
        @Entity
        @Table(name = "instructor_detail")
        public class InstructorDetail {
            ...
            @OneToOne(mappedBy = "instructorDetail", cascade = {
                CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
            private Instructor instructor;
            ...
        }</pre>
        </li>
        <li>Before deleting the sub entity object, break the bidirectional mapping if present
            <ul>
                <li>Get the parent entity class object</li>
                <li>Set the sub entity field attribute to null</li>
            </ul>
            If only unidirectional mapping present
            <ul>
                <li>Get the parent entity class object using entity manager</li>
                <li>Set the sub entity field attribute to null</li>
            </ul>
        </li>
        <li>Use the entity manager to delete the sub entity class object</li>
    </ol> <br>
4. <strong>@OneToMany and @ManyToOne</strong> <br>
   <strong>@OneToMany</strong>: Annotated on field which is <code>List</code> representing a one-to-many relation in database. <br>
   &emsp;This is used in combination with its attribute <code>mappedBy</code> which refers to field in entity that has many-to-one mapping. <br>
   <pre>Example:
      @Entity
      public class Instructor {
         ...
         @OneToMany(mappedBy = "instructor", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
         })
         private List&lt;Course&gt; courses;
         ...
      }</pre>
   <strong>@ManyToOne</strong>: Annotated on field which has many-to-one relationship with another entity class. <br>
   Used in combination with <code>@JoinColumn</code> with attribute <code>name</code> which refers to the column which acts as foreign key. <br>
   <pre>Example:
      @Entity
      public class Course {
         ...
         @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
         })
         @JoinColumn(name = "instructor_id")
         private Instructor instructor;
         ...
      }</pre>
   To establish a bidirectional relation between the entities, we can define an add method as follows: <br>
   <pre>Example:
      @Entity
      public class Instructor {
         ...
         public void add(Course course){
            if(courses==null){
               courses = new ArrayList<>();
            }
            courses.add(course);
            course.setInstructor(this);
         }
         ...
      }</pre> <br>
