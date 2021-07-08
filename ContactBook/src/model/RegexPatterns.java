package model;

public interface RegexPatterns {

    String NAME_REGEX_UA = "^[А-ЩЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String NAME_REGEX = "^[A-Z][a-z]{2,20}$";
    String NICKNAME_REGEX = "^[\\p{L}0-9]*\\p{L}[\\p{L}0-9]{2,20}$";

}
