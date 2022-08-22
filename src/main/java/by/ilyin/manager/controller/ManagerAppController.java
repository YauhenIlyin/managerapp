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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ManagerAppController {

    private SessionRequestContent sessionRequestContent;
    private ProjectFindAllCommand projectFindAllCommand;
    private ProjectRequestValidator projectRequestValidator;
    private AppBaseDataCore appBaseDataCore;

    public ManagerAppController(SessionRequestContent sessionRequestContent, ProjectFindAllCommand projectFindAllCommand, ProjectRequestValidator projectRequestValidator, AppBaseDataCore appBaseDataCore) {
        this.sessionRequestContent = sessionRequestContent;
        this.projectFindAllCommand = projectFindAllCommand;
        this.projectRequestValidator = projectRequestValidator;
        this.appBaseDataCore = appBaseDataCore;
    }

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

    @GetMapping("/new")
    public String projectCreationPage(@ModelAttribute("project") Project project,
                                      Model model) {
        basicInitializeProjectModel(model);
        return "project_creation";
    }

    
    private void basicInitializeProjectModel(ModelAndView model) {
        model.getModel().put("progLangs", appBaseDataCore.getProgrammingLanguageList());
        model.getModel().put("appServers", appBaseDataCore.getProgrammingLanguageList());
        model.getModel().put("databases", appBaseDataCore.getProgrammingLanguageList());
    }

    private void basicInitializeProjectModel(Model model) {
        model.addAttribute("progLangs", appBaseDataCore.getProgrammingLanguageList());
        model.addAttribute("appServers", appBaseDataCore.getApplicationServerList());
        model.addAttribute("databases", appBaseDataCore.getDatabaseList());
    }

}
