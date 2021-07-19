package com.nrkt.studentcoursegraphql.resolver.student;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.nrkt.studentcoursegraphql.payload.StudentCourseOutputDTO;
import com.nrkt.studentcoursegraphql.service.StudentService;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class StudentQuery {

    final StudentService studentservice;

    @DgsData(parentType = "Query", field = "studentCourses")
    public StudentCourseOutputDTO getStudentCourses(@InputArgument("id") String id) {
        return studentservice.getStudentCourses(id);
    }
}
