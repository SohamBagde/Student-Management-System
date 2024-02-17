package sms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sms.project.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
