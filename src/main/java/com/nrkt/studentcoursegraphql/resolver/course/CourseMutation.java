package com.nrkt.studentcoursegraphql.resolver.course;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.nrkt.studentcoursegraphql.model.Course;
import com.nrkt.studentcoursegraphql.payload.CourseInputDTO;
import com.nrkt.studentcoursegraphql.service.CourseService;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class CourseMutation {

    final CourseService courseService;

    @DgsData(parentType = "Mutation", field = "addCourse")
    public Course addCourse(@InputArgument("course") CourseInputDTO newCourse) {
        return courseService.addCourse(newCourse);
    }
}
