package provider.course;

import model.course.Course;

public interface CourseProvider {
    Course getCourse(String id);
}
