package laba.web.controller;

import laba.service.StudentService;
import laba.web.ValidationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/student")
    public ModelAndView findAllStudents(HttpServletRequest request, ModelAndView modelAndView) {
        request.setAttribute("students", service.findAllStudents());
        modelAndView.setViewName("student");
        return modelAndView;
    }

    @PostMapping("/student")
    public ModelAndView createGroup(
            HttpServletRequest request,
            ModelAndView modelAndView,
            @RequestParam(name = "student_name") String studentName,
            @RequestParam(name = "group_id") String groupID
    ) throws IllegalArgumentException {
        if (!ValidationUtils.validateInt(groupID)) {
            throw new IllegalArgumentException("Group id should contain only digits!");
        }
        service.createStudent(studentName, Long.parseLong(groupID));
        request.setAttribute("students", service.findAllStudents());
        return modelAndView;
    }
}
