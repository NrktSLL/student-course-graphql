package com.nrkt.studentcoursegraphql.resolver.course;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.nrkt.studentcoursegraphql.model.Course;
import com.nrkt.studentcoursegraphql.service.CourseService;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class CourseQuery {

    final CourseService courseService;

    @DgsData(parentType = "Query", field = "getCourse")
    public Course getCourse(@InputArgument("id") String id) {
        return courseService.getCourse(id);
    }
}
