package com.znaji.dto;

import com.znaji.entity.Enrollment;
import com.znaji.entity.Student;

public record StudentEnrollment (Student s, Enrollment e)
{
}
