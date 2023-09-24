package com.mks.dynamodb.entity.RS;

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
public class SchoolManagementResponse {

    private SchoolResponse data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SchoolResponse{
        private String id;
        private String schoolName;
        private String schoolAddress;
        private List<StudentResponse> studentList;
        private TeacherResponse teacher;
        private List<SubjectResponse> subjectList;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentResponse{
        private Date registrationDate;
        private String studentName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SubjectResponse{
        private String subjectName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TeacherResponse{
        private String teacherName;
    }

    public static SchoolManagementResponse entityToResponse(School school){

        List<Student> studentList = school.getStudentList();
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (Student student: studentList
             ) {
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setRegistrationDate(student.getRegistrationDate());
            studentResponse.setStudentName(student.getStudentName());
            studentResponseList.add(studentResponse);
        }

        Teacher teacher = school.getTeacher();
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setTeacherName(teacher.getTeacherName());

        List<Subject> subjectList = school.getSubjectList();
        List<SubjectResponse> subjectResponses = new ArrayList<>();
        for (Subject subject: subjectList
             ) {
            SubjectResponse subjectResponse = new SubjectResponse();
            subjectResponse.setSubjectName(subject.getSubjectName());
            subjectResponses.add(subjectResponse);
        }

        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setId(school.getId());
        schoolResponse.setSchoolName(school.getSchoolName());
        schoolResponse.setSchoolAddress(school.getSchoolAddress());
        schoolResponse.setStudentList(studentResponseList);
        schoolResponse.setTeacher(teacherResponse);
        schoolResponse.setSubjectList(subjectResponses);

        SchoolManagementResponse schoolManagementResponse = new SchoolManagementResponse();
        schoolManagementResponse.setData(schoolResponse);
        return schoolManagementResponse;
    }
}
