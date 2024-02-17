package sms.project.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sms.project.dto.StudentDto;
import sms.project.service.StudentService;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students",students);
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student",studentDto);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student,
                              BindingResult result, Model model) {

        if(result.hasErrors()) {
            model.addAttribute("student",student);
            return "create_student";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model) {
        StudentDto student = studentService.getStudentById(studentId);
        model.addAttribute("student",student);
        return "edit_student";
    }

    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,@Valid @ModelAttribute("student") StudentDto studentDto,
                              BindingResult result, Model model) {

        if(result.hasErrors()) {
            model.addAttribute("student",studentDto);
            return "edit_student";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId, Model model) {
        StudentDto studentDto = studentService.getStudentById(studentId);
        model.addAttribute("student",studentDto);
        return "view_student";
    }
}
