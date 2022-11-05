package com.example.its.web.issue;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data //generates a constructor and setters and getters for all non-final arguments
public class  IssueForm {
    //throw exception if data doesn't fill the constraints,
    // making create method in IssueService roll back
    @NotBlank
    @Size(max=256)
    private String summary;

    //same with above
    @NotBlank
    @Size(max=256)
    private String description;
}
