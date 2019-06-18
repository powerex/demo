package laba.web.controller;

import laba.data.Test;
import laba.service.TestService;
import laba.web.ValidationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    private final TestService service;

    public TestController(TestService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public ModelAndView findAllTests(HttpServletRequest request, ModelAndView modelAndView) {
        request.setAttribute("tests", service.findAll());
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @PostMapping("/test")
    public ModelAndView createTest(
            HttpServletRequest request,
            ModelAndView modelAndView,
            @RequestParam(name = "user_id") String userID,
            @RequestParam(name = "student_id") String studentID,
            @RequestParam(name = "subject_id") String subjectID,
            @RequestParam(name = "mark") String mark
    ) {
        validateInputs(userID, studentID, subjectID, mark);
        service.createTest(Long.parseLong(userID), Long.parseLong(studentID), Long.parseLong(subjectID), Long.parseLong(mark));
        request.setAttribute("tests", service.findAll());
        modelAndView.setViewName("test");
        return modelAndView;
    }

    private void validateInputs(String userID, String studentID, String subjectID, String mark) {
        if (!ValidationUtils.validateInt(userID)) {
            throw new IllegalArgumentException("User id should contain only digits!");
        } else if (!ValidationUtils.validateInt(userID)) {
            throw new IllegalArgumentException("Student id should contain only digits!");
        } else if (!ValidationUtils.validateInt(subjectID)) {
            throw new IllegalArgumentException("Subject id should contain only digits!");
        } else if (!ValidationUtils.validateInt(mark)) {
            throw new IllegalArgumentException("Mark should contain only digits!");
        }
    }
}