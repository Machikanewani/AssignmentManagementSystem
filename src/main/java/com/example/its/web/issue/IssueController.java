package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/issues") //every address prefixed by "/issues" will be directed to here
@RequiredArgsConstructor // every final argument will be constructed (included in constructor)
public class IssueController {

    private final IssueService issueService;

    //handle GET /issues
    @GetMapping //@GetMapping("/issues")
    public String showList(Model model){
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }
    //handle GET /issues/creationForm
    @GetMapping("/creationForm") //@GetMapping("/issues/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form) {
        //@ModelAttribute equals: model.addAttribute(form)
        return "issues/creationForm";
    }

    //handle POST /issues
    @PostMapping
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return showCreationForm(form);
        }
        issueService.create(form.getSummary(), form.getDescription());
        return "redirect:/issues";
    }

    @GetMapping("/{issueID}")
    public String showDetail(@PathVariable("issueID") long issueId, Model model){
        model.addAttribute("issue", issueService.findById(issueId));
        return "issues/detail";
    }
}
