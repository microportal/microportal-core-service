package br.org.microportal.core.model;

import lombok.Getter;
import lombok.Setter;
import org.microportal.api.model.ApplicationBase;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class ApplicationDocument extends ApplicationBase {

    private static final long serialVersionUID = 7281689913939874081L;

    @Id
    private String id;
}
