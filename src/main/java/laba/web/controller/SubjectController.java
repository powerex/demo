package laba.web.controller;

import laba.service.SubjectService;
import laba.web.ValidationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SubjectController {
    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping("/subject")
    public ModelAndView findAllSubjects(HttpServletRequest request, ModelAndView modelAndView) {
        request.setAttribute("subjects", service.findAll());
        modelAndView.setViewName("subject");
        return modelAndView;
    }

    @PostMapping("/subject")
    public ModelAndView createSubject(
            HttpServletRequest request,
            ModelAndView modelAndView,
            @RequestParam(name = "subject_description") String description,
            @RequestParam(name = "subject_name") String subjectName,
            @RequestParam(name = "subject_group") String groupID
    ) {
        if (!ValidationUtils.validateInt(groupID)) {
            throw new IllegalArgumentException("Group id should contain only digits!");
        }
        service.createSubject(description, subjectName, Long.parseLong(groupID));
        request.setAttribute("subjects", service.findAll());
        return modelAndView;
    }
}