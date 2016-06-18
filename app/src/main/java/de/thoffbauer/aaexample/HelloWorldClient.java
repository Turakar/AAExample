package de.thoffbauer.aaexample;

import org.androidannotations.rest.spring.annotations.Field;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Rest(rootUrl = "http://192.168.1.13:8080", converters = { FormHttpMessageConverter.class,
        MappingJackson2HttpMessageConverter.class})
public interface HelloWorldClient {

    @Get("/hello-world?name={name}")
    Saying get(@Path String name);

    @Post("/hello-world")
    Saying post(@Field String name, @Field String address);
}
