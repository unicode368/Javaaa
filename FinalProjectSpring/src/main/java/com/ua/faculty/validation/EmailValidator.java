package com.ua.faculty.validation;

public class EmailValidator {
    String NAME_REGEX_UA = "^[А-ЩЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String NAME_REGEX = "^[A-Z][a-z]{1,20}$";
    String MOBILE_PHONE_REGEX = "^[0-9]{10}$";
    String EMAIL_REGEX = "^[a-zA-Z0-9_.-]{2,20}@[a-z]{1,5}.[a-z]{1,3}$";
    String LOGIN_REGEX = "^[\\p{L}0-9_.-]*\\p{L}[\\p{L}0-9_.-]{2,20}$";
}
