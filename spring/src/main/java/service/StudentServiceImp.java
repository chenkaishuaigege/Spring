package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import pojo.Student;


@Component("studentService")
public class StudentServiceImp implements StudentService {

    @Autowired
    private Student student = null;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void printStudentInfo() {
        System.out.println("学生的 id 为：" + student.getName());
        System.out.println("学生的 name 为：" + student.getName());
    }
}
