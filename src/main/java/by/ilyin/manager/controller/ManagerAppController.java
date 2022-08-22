package by.ilyin.manager.controller;

import by.ilyin.manager.controller.command.SessionRequestContent;
import by.ilyin.manager.controller.command.project.ProjectFindAllCommand;
import by.ilyin.manager.entity.Project;
import by.ilyin.manager.evidence.KeyWordsRequest;
import by.ilyin.manager.util.AppBaseDataCore;
import by.ilyin.manager.util.validator.impl.ProjectRequestValidator;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ManagerAppController {

    private SessionRequestContent sessionRequestContent;
    private ProjectFindAllCommand projectFindAllCommand;
    private ProjectRequestValidator projectRequestValidator;

    @GetMapping("")
    public String projectsPage(Model model, HttpServletRequest request) {
        sessionRequestContent.initialize(request);
        sessionRequestContent.initializePage(request, projectRequestValidator);
        projectFindAllCommand.execute(sessionRequestContent);
        List<Project> projects;
        projects = (List) sessionRequestContent.getRequestAttributes().get(KeyWordsRequest.PROJECTS);
        Page page = (Page) sessionRequestContent.getRequestAttributes().get(KeyWordsRequest.PAGE_PAGE);
        basicInitializeProjectModel(model);
        model.addAttribute(KeyWordsRequest.PROJECTS, projects);
        model.addAttribute(KeyWordsRequest.PAGE_PAGE, page);
        return "projects";
    }


}
