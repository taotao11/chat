package com.chat.email.entity;

/**
 * 邮件实体对象
 */
public class EmailEntity {
    private String toFrom;
    private String subject;
    private String text;

    public EmailEntity() {

    }

    public String getToFrom() {
        return toFrom;
    }

    public void setToFrom(String toFrom) {
        this.toFrom = toFrom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "EmailEntity{" +
                "toFrom='" + toFrom + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
