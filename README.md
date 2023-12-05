# StudyBud
Software Engineering project
1. Executive Summary
Study Bud is an online platform where students can connect with others from the same educational institution with similar goals. 

2. Problem Statement
Students entering college from high-school or re-entering an educational environment struggle with adjusting to demanding course curricula, managing their time and connecting with others.
Other study collaboration websites require student to pay for their services, which can be hard on a student’s limited budget. Many such websites are open to everyone, so can give rise to concerns with security and safety. It can take a lot of time for a student to find a suitable study collaboration platform and even when they find a platform that works for them, they then have to spend time searching for someone with similar learning goals to match with.

3. Benefits of Study Bud
3.1 Benefits to Students
3.1.1 Creates a sense of Community: the platform allows students to interact with peers and develop a supportive community.
3.1.2 Knowledge Expansion: Provides students with the opportunity to collaborate, share ideas and expand their knowledge.
3.1.3 Improves Confidence: As students grow their knowledge, their confidence will improve. 
3.1.4 Builds Discipline: Studying with a partner at an agreed time is a commitment which helps students improve their study discipline. 
3.1.5 Secure: by using college credentials to authenticate users, Study Bud provides students with the comfort of knowing that they are pairing with other students from their school.

3.2 Benefits to Colleges

3.2.1 Enhances Student Experience: Colleges can benefit from using Study bud because it is an additional service that empowers students to take control of their learning, builds their confidence and develops a sense of community, thus improving the student experience.
3.2.2 Improves Reputation: A positive student experience can improve the reputation of the college.
3.2.3 Attracts Potential Students: Potential students consider the types of services, facilities, support and community available at a college. The Study Bud service can attract potential students to colleges that use it.

5. Costs
The expenses for building and Implementing the Study Bud platform include:
•	Personnel costs	 
•	Hardware costs	
•	Software-license, domain name and other costs 		
•	Maintenance costs
The estimated cost of building and implementation is between CAD$50,000.00-$60,000.00

6. Study Bud vs. Alternatives
5.1 Study Bud vs. Tutoring
Many colleges offer tutoring and students can also engage private tutors when they struggle with a subject. Study Bud provides a better experience than tutoring for the following reasons
5.1.1 Greater Pool of Collaborators: Tutoring offerings can be limited by the unavailability of tutors for a subject. 
With Study Bud there is a larger pool of available collaborators to choose from and a greater likelihood that a student will be able to connect with someone who is interested in the same subject. 
5.1.2 Knowledge Exchange: Tutoring involves a unidirectional flow of knowledge from tutors to students. 
Study Bud facilitates exchange of knowledge among peers and builds the confidence of students as they help each other.
5.2 Study Bud vs. Artificial Intelligence (AI)
Artificial intelligence platforms are becoming more popular. Study Bud provides the following advantages over AI:
5.2.1 Personal Interaction and Knowledge Exchange: AI is impersonal and does not provide a complete understanding of concepts. Additionally, AI may not always provide the correct solution.
Study Bud enables face-to-face interaction among users allowing them to discuss subjects and questions among themselves, helping to reach a good understanding of the problems they are trying to solve and allowing them to arrive at their own solutions, fostering innovation and personal growth.
5.3 Study Bud vs. Other Platforms/Websites
5.3.1 Cost: While there are similar sites to study bud available, these sites often request a fee from users. 
The expense of Study Bud is paid by the educational institution the student attends, so it is free of cost for students. 
5.3.2 Security: Alternative sites to Study Bud are open to all, which one can raise concerns about safety or exposure to potential risk. Study Bud authenticates users using college credentials eliminating/reducing such risks.

7. Revenue Model
Study Bud uses a transaction-based revenue model where clients would be required to pay an annual or monthly subscription fee. The fee will depend on the number of users.
Customization of the tool can also be provided at an additional cost, which would include the cost of the build, and depending on the nature of the customization may also result in an increase in the subscription cost.

8. Functional and Non-Functional Requirements
7.1 Functional Requirements
7.1.1 User Login associated with the school’s authentication 
7.1.2 User Profile to manage the user’s interests
7.1.3 A Timetable showing when the student is available to study, which is visible to other users
7.1.4 Algorithm for searching/filtering posts
7.1.5 Posting to find study buddies, applying to connect with a posting user and accepting another user’s request to connect
7.1.6 Reviewing study buddies
7.1.7 Login for the System Administrator
7.1.8 Monitoring and management by System Administrator

7.2 Non-functional Requirements
7.2.1 Usability-they system should allow each user to have up to 10 active posts 
7.2.2 Security – Client data of different institutions can be separated
7.2.3 Reliability – Website traffic can be monitored to maintain website stability.
7.2.4 Supportability-design to allow for customization
7.2.5 Robustness- system will continue to be available even if there are changes to the client’s website.

8. The Use-Case Diagram 
In the use case diagram, one actor is a student, who can interact with the following use cases:
1.	Login 	
2.	Creating a profile – User creates a profile which lists their areas of interest and free time during the week.
3.	Post Display – A display board will present the posts that are filtered according to their profile.
4.	Post creation- Users can create, amend or delete posts.
5.	Review- Users can share their experiences and interactions.

The other actor is a System Administrator actor for whom the use cases are:
     1. 	Login
     2. 	Monitoring and management of the website.


9. Conclusion:

Study Bud transforms learning by allowing students to take charge of their learning, build their community and develop better time management skills and will benefit both colleges and their students. 



10. Design Goals

 ![image](https://github.com/anujha362/StudyBud/assets/145023273/58f6ac53-49a0-4cdd-90a2-d51da2aa2efe)



11. Achieving Non-functional Requirements
11.1Requirement: Completeness
The system was designed based on the use cases identified during the requirements stage and includes functionality for the identified use cases. 

11.2Requirement: Practicality
When assessing the memory requirements for the system, we have considered the number of users, the number of active posts per user and archiving of posts, to ensure that our planned memory will be sufficient to meet our performance goals.
We have assumed that each field will use 10 bytes. Assuming that each table has 10 fields, and 1000 records are created a day, the total daily requirement will be 100kB, which over a 1-year period (365 days) would be 36.5MB, which is below the amount of memory we have included. Additional memory can be added as the number of Clients and users grows.

11.3Requirement: Security
The authentication information will be provided by the school. Log files will be used to capture who has attempted to login, whether the login was successful and when and how many times they have attempted to log in. Their IP addresses will also be captured in the log files. 
The system design provides for the separation of data from different institutions.
Log information will be monitored for traffic.

11.4Requirement: Maintainability 
An object-oriented approach to design has been adopted in the design of our system. The design of the database and classes will accommodate requests for customization.

11.5Requirement: Technology Stack
The technology identified for use in the system is functionally suitable for the system.

11.6Requirements: Positive User Experience
The website interfaces are easy to use and intuitive. Most of the fields in the user profile will be pre-populated based on information provided by the college, so the student only needs to enter their time schedule, and if they want to study an area outside of their course of study, they can indicate this in the “Interests” field of their profile. The pre-population of information will reduce the risk of error when users are entering information in their profile and will reduce the amount of information that they need to enter.


12. System Architecture
The system architecture for StudyBud consists of three layers: the presentation tier, middle layer and the data layer.
The presentation layer uses HTML, cascading style sheets and JavaScript and will be deployed to user devices through Web Browsers. 
The application tier contains the business logic that supports the system’s core functions and will be written in Java, using the SpringBoot framework. The application will communicate with the data layer using JPA.
The data tier consists of the database and the program for read/write access to the database. MySQL will be used for the data tier.

![image](https://github.com/anujha362/StudyBud/assets/145023273/82f6fecd-2171-416c-b2db-444815a3da63)

13.Hardware and Software configuration
 13.1The hardware configuration for StudyBud is as follows:
We will set up a server to host our StudyBud website to be able to handle the traffic and provide reliability.
![image](https://github.com/anujha362/StudyBud/assets/145023273/bfeea9d9-861c-4169-93f3-7156f7117d0f)

13.2The software configuration for StudyBud is as follows:
![image](https://github.com/anujha362/StudyBud/assets/145023273/e45f8329-02ac-4c13-b7ad-c1b069d868d9)








5. ERD Diagram
 

![image](https://github.com/anujha362/StudyBud/assets/145023273/070af8be-4c4a-49b4-b838-fb3c86423c8f)







6.Class Diagram
 
![image](https://github.com/anujha362/StudyBud/assets/145023273/a06e94f9-18f4-4726-9c1d-33aaefb4fd0f)






14. Interfaces

We will implement following interfaces for our web application
1)LOGIN: A user will login enter her/his username and password which will be authenticated using the school’s database.
 
![image](https://github.com/anujha362/StudyBud/assets/145023273/1d6fa34a-0464-459e-bcb4-1f6c28fd122c)

2) PROFILE: The student will be directed to the profile page where one’s information such as name, ID, program she/he is studying and courses she/he is undertaking for the semester will be obtained from the school’s database. One will have to fill in the details regarding his interests and free time during the week in the time schedule. The details in the timetable will be the same for the following weeks until the user modifies the table.
![image](https://github.com/anujha362/StudyBud/assets/145023273/69e8f403-45fa-4f14-aa8e-dc3992d52e89)


![image](https://github.com/anujha362/StudyBud/assets/145023273/a4e1e1c9-dec0-42db-bdc6-0b06dcbbccc7)

Each page will contain a menu bar on top from where she/he can navigate to other pages.

3)POST BOARD: The page will display all the posts that have been created showing the details like name, Student ID of post creator and the subject she/he wants to study. One can hover over the name to get the timetable of the student. The option of filtering according to subjects, course or program is provided. 

 ![image](https://github.com/anujha362/StudyBud/assets/145023273/7fde259a-2a7d-4c52-81af-89d2aa1d32ac)

4)POST CREATION: A student will create post for her/his own interest or subject in this page. They will input title and details of subjects or interests they want to study. They will also put in details of the time and day, whether the post should be open to the public or only to those who are in the same course or program and where do they want to meet for studying.
![image](https://github.com/anujha362/StudyBud/assets/145023273/1f4d7def-241a-4e27-908e-fc574902d93d)




5)DISPLAY POST: Once a student clicks on any interesting post, they will be directed to Display post page where all the details regarding the post are displayed. A space is provided for them to leave their comments on the post which then the post creator can reply to or accept the post accordingly.  
 ![image](https://github.com/anujha362/StudyBud/assets/145023273/8f9b39ad-4b3a-4361-8433-29a7c4d84739)
![image](https://github.com/anujha362/StudyBud/assets/145023273/6d2e9d43-62c3-4741-b5b5-6135f8728291)


6)HISTORY: All the post a student had created or commented on can be seen in the history page for future reference which can be filtered too according to the posts they have commented on or the posts they have created


![image](https://github.com/anujha362/StudyBud/assets/145023273/24940cc7-9161-4139-8de8-fcbb509bd1d9)

6)DASHBOARD: The administrator has the power to monitor the posts on the post board and hide them if the post doesn’t follow appropriate guidelines. They can view the reports generated for the website.
 
15. Sequence Diagrams

1)LOGIN
![image](https://github.com/anujha362/StudyBud/assets/145023273/c1ed8a4b-5d96-4692-8c42-5e66d3357916)


2)PROFILE
![image](https://github.com/anujha362/StudyBud/assets/145023273/e2d2c32b-6b64-4aef-bfb6-a657b99020a5)

3)POST Creation
![image](https://github.com/anujha362/StudyBud/assets/145023273/0d5d6b8c-02e4-4223-b512-8bbac34aecdc)


4)COMMENT
![image](https://github.com/anujha362/StudyBud/assets/145023273/60d54285-2bd6-4e4f-8a9a-0df715573878)


5)HISTORY
![image](https://github.com/anujha362/StudyBud/assets/145023273/0cbc8d5e-dac9-4ee7-8e12-bbe87990fec5)


6)DASHBOARD




