package com.luv2code.component;

import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(classes = MvcTestingExampleApplication.class) // if package names are different
@SpringBootTest
public class ApplicationExampleTest {

    private static int count = 0;

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades grades;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    void beforeEach() {
        count++;
        System.out.println("Testing: " + appName +
                " which is: " + appDescription +
                " version "  + appVersion +
                " execution of test method: " + count);

        student.setFirstname("Eric");
        student.setLastname("Roby");
        student.setEmailAddress("eric.roby@luv2code_school.com");
        grades.setMathGradeResults(List.of(100d, 85d, 76.5d, 91.75d));
        student.setStudentGrades(grades);
    }

    @Test
    @DisplayName("Add student grades for a students equals")
    public void addGradeResultsForStudentGradesEquals() {
        assertEquals(353.25, grades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults())
        );
    }

    @Test
    @DisplayName("Add student grades for student not equals")
    public void addGradeResultsForStudentGradesNotEquals() {
        assertNotEquals(0, grades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults())
        );
    }

    @Test
    @DisplayName("Is grade grater")
    public void isGradeGrater() {
        assertTrue(grades.isGradeGreater(90, 75),
                "failure - should be true");
    }


    @Test
    @DisplayName("Is grade grater false")
    public void isGradeGraterFalse() {
        assertFalse(grades.isGradeGreater(90, 91),
                "failure - should be false");
    }

    @Test
    @DisplayName("check null")
    public void checkNull() {
        assertNotNull(grades.checkNull(student.getStudentGrades().getMathGradeResults()),
                "Should not be true");
    }

    @Test
    @DisplayName("Create student without grade init")
    public void createStudentWithoutGradeInit() {
        CollegeStudent collegeStudent = context.getBean("collegeStudent", CollegeStudent.class);
        collegeStudent.setFirstname("Eric");
        collegeStudent.setLastname("Roby");
        collegeStudent.setEmailAddress("eric.roby@luv2code_school.com");

        assertNotNull(collegeStudent.getFirstname());
        assertNotNull(collegeStudent.getLastname());
        assertNotNull(collegeStudent.getEmailAddress());
        assertNull(collegeStudent.getStudentGrades());
    }

    @Test
    @DisplayName("Verify students are prototypes")
    public void verifyStudentsArePrototypes() {
        CollegeStudent collegeStudent = context.getBean("collegeStudent", CollegeStudent.class);

        assertNotSame(student, collegeStudent, "Students should not be the same");
    }

    @Test
    @DisplayName("Find grade point average")
    void findGradePointAverage() {
        assertAll("Testing all assert equals",
            () -> assertEquals(353.25, grades.addGradeResultsForSingleClass(
                    student.getStudentGrades().getMathGradeResults())),
            () -> assertEquals(88.31, grades.findGradePointAverage(
                    student.getStudentGrades().getMathGradeResults()))
        );
    }
}
