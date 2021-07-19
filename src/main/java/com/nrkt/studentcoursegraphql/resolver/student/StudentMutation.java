package com.nrkt.studentcoursegraphql.resolver.student;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.nrkt.studentcoursegraphql.payload.StudentCourseOutputDTO;
import com.nrkt.studentcoursegraphql.payload.StudentInputDTO;
import com.nrkt.studentcoursegraphql.service.StudentService;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class StudentMutation {

    final StudentService studentservice;

    @DgsData(parentType = "Mutation", field = "addStudent")
    public StudentCourseOutputDTO addStudent(@InputArgument("student") StudentInputDTO newStudent) {
        return studentservice.addStudent(newStudent);
    }

    @DgsData(parentType = "Mutation", field = "deleteStudent")
    public String deleteStudent(@InputArgument("studentId") String studentId) {
        var student = studentservice.getStudent(studentId);
        studentservice.deleteStudent(studentId);
        return "removed:" + student.toString();
    }
}
