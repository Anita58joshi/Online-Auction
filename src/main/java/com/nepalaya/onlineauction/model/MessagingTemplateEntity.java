package com.nepalaya.onlineauction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messaging_template")
public class MessagingTemplateEntity {
    @Id
    @Column(name = "code")
    private String templateType;
    @Column(name = "subject")
    private String subject;
    @Column(name = "body", columnDefinition = "text")
    private String body;

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
