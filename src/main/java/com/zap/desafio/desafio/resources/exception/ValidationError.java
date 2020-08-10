package com.zap.desafio.desafio.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> messages = new ArrayList<>();

    public ValidationError(Integer status, String msg) {
        super(status, msg);
    }

    public List<FieldMessage> getMessages() {
        return messages;
    }

    public void addErro(String mensagem, String campo){messages.add(new FieldMessage(mensagem, campo));}
}
