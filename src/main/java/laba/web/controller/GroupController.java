package laba.web.controller;

import laba.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GroupController {
    private final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping("/group")
    public ModelAndView findAllGroups(HttpServletRequest request, ModelAndView modelAndView) {
        request.setAttribute("groups", service.findAllGroups());
        modelAndView.setViewName("group");
        return modelAndView;
    }

    @PostMapping("/group")
    public ModelAndView createGroup(HttpServletRequest request, ModelAndView modelAndView, @RequestParam(name = "group_name") String groupName) {
        service.createGroup(groupName);
        request.setAttribute("groups", service.findAllGroups());
        modelAndView.setViewName("group");
        return modelAndView;
    }
}
