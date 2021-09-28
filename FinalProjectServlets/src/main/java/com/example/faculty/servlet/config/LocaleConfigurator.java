package com.example.faculty.servlet.config;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class LocaleConfigurator {
    public static Locale getLocale(HttpServletRequest request) {
        Object localeObj = request.getSession().getAttribute("language");
        return localeObj.toString().equals("en")
                ? Locale.ENGLISH : new Locale("ua");
    }
}
