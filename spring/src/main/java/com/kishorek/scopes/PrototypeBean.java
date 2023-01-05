package com.kishorek.scopes;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PrototypeBean {
    private int value = -1;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
