package com.mks.dynamodb.entity.RQ;

import com.mks.dynamodb.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolManagementRequest {
    private SchoolRequest data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SchoolRequest{
        private String schoolName;
        private String schoolAddress;
        private List<StudentRequest> studentList;
        private TeacherRequest teacher;
        private List<SubjectRequest> subjectList;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentRequest{
        private Date registrationDate;
        private String studentName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SubjectRequest{
        private String subjectName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TeacherRequest{
        private String teacherName;
    }

    public School requestToEntity(SchoolManagementRequest schoolManagementRequest){
        SchoolRequest requestData = schoolManagementRequest.getData();

        List<Student> studentList = new ArrayList<>();
        List<StudentRequest> students = requestData.getStudentList();
        students.forEach(studentRequest -> {
            Student student= new Student();
            student.setStudentName(studentRequest.getStudentName());
            student.setRegistrationDate(studentRequest.getRegistrationDate());

            studentList.add(student);
        });

        TeacherRequest teacherRequest = requestData.getTeacher();
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherRequest.getTeacherName());

        List<SubjectRequest> subjectRequestList = requestData.getSubjectList();
        List<Subject> subjectList = new ArrayList<>();
        subjectRequestList.forEach(subjectRequest -> {
            Subject subject= new Subject();
            subject.setSubjectName(subjectRequest.getSubjectName());
            subjectList.add(subject);
        });

        School school = new School();
        school.setSchoolName(requestData.getSchoolName());
        school.setSchoolAddress(requestData.getSchoolAddress());
        school.setStudentList(studentList);
        school.setTeacher(teacher);
        school.setSubjectList(subjectList);

        return school;
    }
}
