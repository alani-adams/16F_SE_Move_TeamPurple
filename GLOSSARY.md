
**Course**  
    The code that specifies the exact section of a course, of which a student can be enrolled. It combines Semester Code, Course Code and Course Section, such as "201310 IT101.01".
    
**Course Code**  
    The code that can be used to describe a course, such as "IT101".
    
**Course Domain**  
    The word prefix portion of the course code (the "IT" in "IT101").
    
**Course Number**  
    The three digit number unique to each course within each domain (the "101" in "IT101").

**Course Section**  
    The two digit number unique to each section of a course (the ".01" in "IT101.01").
    
**Professor**  
    An entity that can teach multiple courses.

**Professor Schedule**  
    A semester specific set containing all of the courses a professor is teaching. 
    
**Semester Code**  
    A two-digit numeric string that is equal to "10", "20", or "30" exclusively. These translate to Fall, Spring, and Summer semesters respectively.
    
**Student**  
    An entity that can be enrolled in multiple courses.

**Student Schedule**  
    A semester specific set containing all of the courses a student is enrolled in. 

**Term Code**  
    A six-digit numeric string, comprised of a four-digit year and a two-digit semester code. For example, 201610 would be the Fall semester of 2016.

**Time Code**  
    An integer  0 &le; _t_ < 2359 where (_t_ div 100) is the hour of the day and (_t_ mod 100) is the minute of the day.  
    For example: 830 is 8:30 AM and 1530 is 3:30 PM.
    
**Time Range**  
    Two time codes where the lesser one represents a start time and the greater one represents an end time.
    
**Day**
    One letter representaion of what day a course meets.
