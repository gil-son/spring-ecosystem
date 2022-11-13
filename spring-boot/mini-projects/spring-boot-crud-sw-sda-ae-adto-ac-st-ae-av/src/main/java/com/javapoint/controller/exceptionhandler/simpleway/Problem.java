package com.javapoint.controller.exceptionhandler.simpleway;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {
    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<Field> fields;

    Problem (){}

    public Problem(Integer status, OffsetDateTime dateTime, String title, List<Field> fields) {
        this.status = status;
        this.dateTime = dateTime;
        this.title = title;
        this.fields = fields;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Field> getFields() {
        return fields;
    }

    public static class Field {

        private String nome;
        private String mensagem;

        public Field(){}

        public Field(String nome, String mensagem) {
            this.nome = nome;
            this.mensagem = mensagem;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }
    }
}
