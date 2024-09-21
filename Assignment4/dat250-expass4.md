# DAT250 Experiment Assignment 4 Report

## Technical Issues and Resolutions

During the installation and use of Java Persistence API (JPA) with Hibernate, I encountered several technical issues, primarily related to configuring the persistence unit, managing entity relationships, and ensuring that the JPA mappings were correct. One persistent error involved configuring the `@ManyToMany` and `@OneToMany` relationships correctly between entities. After reviewing the documentation and debugging the mapping configurations, I resolved the issue by ensuring the `mappedBy` attributes were correctly set and that the relationships matched on both sides.

Another issue arose with the NullPointerException in the Hibernate boot process. This was caused by improperly configured relationships in the entity classes. After checking and refactoring the entity annotations to ensure proper bidirectional mapping, the issue was resolved.

## Link to Previous Experiment Code

Here is the link to the code for Experiment 2, which includes the necessary test cases that now pass:

[Experiment 2 Code](#) *(Note: Replace with actual link to your repository)*

## Database Table Inspection

To inspect the database tables created by Hibernate, I utilized the H2 in-memory database and configured the persistence unit to log SQL commands to the console. The following line in the `persistence.xml` file:
<property name="hibernate.show_sql" value="true"/>

When this property is set to true, it allows us to see the SQL commands that are executed by Hibernate during the creation, alteration, and deletion of database tables. This is extremely useful for understanding how Hibernate generates and manages the underlying schema.

Here are two example screenshots that demonstrate the inspection of the tables:


![screenshot2](https://github.com/user-attachments/assets/140899af-54b5-48da-84e4-aac176a81262)
![screenshot1](https://github.com/user-attachments/assets/c2cb6cc9-7e06-43ba-9513-1bedc6cb9366)


This approach provides clear visibility into how entities are mapped to tables and allows us to track the evolution of the database schema as new entities or changes are added.

Remaining Issues
At this point, there are no unresolved issues. All test cases pass successfully, and the database tables are created as expected based on the entity mappings.
