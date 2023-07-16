package com.example.testapplication;

import com.example.testapplication.model.Counter;
import com.example.testapplication.service.CounterService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("main")
public class MainView extends VerticalLayout {

    private final CounterService counterService;
    private final Binder<Counter> binder;
    //private final NativeLabel nativeLabel;

    public MainView(CounterService counterService) {
        this.counterService = counterService;
        this.binder = new Binder<>(Counter.class);
        //this.nativeLabel = new NativeLabel();

        TextField counterField = new TextField("Counter");
        NativeLabel valueLabel = new NativeLabel();

        valueLabel.getElement().setProperty("innerHTML", "0");

        Button incrementButton = new Button("Increment", event -> {
            int newValue = counterService.incrementValue();
            valueLabel.getElement().setProperty("innerHTML", String.valueOf(newValue));
        });


//        FormLayout formLayout = new FormLayout(nativeLabel, incrementButton);
//        add(formLayout);

        binder.forField(counterField)
                .withConverter(new StringToIntegerConverter("Invalid number"))
                .bind(Counter::getValue, Counter::setValue);

        add(counterField, valueLabel, incrementButton);

    }

}
