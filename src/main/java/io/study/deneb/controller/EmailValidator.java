package io.study.deneb.controller;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements Predicate<String> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(\\S+)$");


    @Override
    public boolean test(String s) {
        return EMAIL_PATTERN.matcher(s).matches();
    }
}
