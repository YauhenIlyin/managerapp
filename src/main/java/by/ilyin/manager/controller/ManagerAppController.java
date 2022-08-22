package by.ilyin.manager.controller;

import by.ilyin.manager.controller.command.SessionRequestContent;
import by.ilyin.manager.controller.command.project.ProjectCreateCommand;
import by.ilyin.manager.controller.command.project.ProjectFindAllCommand;
import by.ilyin.manager.entity.Project;
import by.ilyin.manager.evidence.KeyWordsRequest;
import by.ilyin.manager.util.AppBaseDataCore;
import by.ilyin.manager.util.validator.impl.ProjectRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ProjectCreateCommand projectCreateCommand;

    @Autowired
    public ManagerAppController(SessionRequestContent sessionRequestContent,
                                ProjectFindAllCommand projectFindAllCommand,
                                ProjectRequestValidator projectRequestValidator,
                                AppBaseDataCore appBaseDataCore,
                                ProjectCreateCommand projectCreateCommand) {
        this.sessionRequestContent = sessionRequestContent;
        this.projectFindAllCommand = projectFindAllCommand;
        this.projectRequestValidator = projectRequestValidator;
        this.appBaseDataCore = appBaseDataCore;
        this.projectCreateCommand = projectCreateCommand;
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

    @PostMapping("")
    public ModelAndView createProject(Model model,
                                      @ModelAttribute("project") @Valid Project project,
                                      BindingResult bindingResult) {
        basicInitializeProjectModel(model);
        ModelAndView mav;
        System.out.println(bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            mav = new ModelAndView("projects/new");
//            basicInitializeProjectModel(mav);
            mav.addObject("project", project);
            mav.setViewName("project_creation");
        } else {
            System.out.println(2);
            HashMap<String, Object> attributes = new HashMap<>();
            attributes.put(KeyWordsRequest.PROJECT, project);
            sessionRequestContent.setRequestAttributes(attributes);
            projectCreateCommand.execute(sessionRequestContent);
            mav = new ModelAndView("redirect:/projects");
        }
        basicInitializeProjectModel(mav);
        return mav;
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
