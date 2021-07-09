package model;

public interface RegexPatterns {

    String NAME_REGEX_UA = "^[А-ЩЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String NAME_REGEX = "^[A-Z][a-z]{1,20}$";
    String GROUP_REGEX = "^1|2|3$";
    String LANG_REGEX = "^1|2$";
    String HOME_PHONE_REGEX = "^[0-9]{6}|[0-9]{2}-[0-9]{2}-[0-9]{2}$";
    String MOBILE_PHONE_REGEX = "^[0-9]{10}$";
    String EMAIL_REGEX = "^[a-zA-Z0-9_.-]{2,20}@[a-z]{1,5}.[a-z]{1,3}$";
    String INDEX_REGEX = "^[0-9]{5}$";
    String HOUSE_NUMBER_REGEX_UA = "^[0-9]{0,3}|[0-9]{0,3}[А-ЩЮЯҐІЇЄ]{1}$";
    String HOUSE_NUMBER_REGEX = "^[0-9]{0,3}|[0-9]{0,3}[A-Z]{1}$";
    String FLAT_NUMBER_REGEX = "^[0-9]{0,3}$";
    String NICKNAME_REGEX = "^[\\p{L}0-9_.-]*\\p{L}[\\p{L}0-9_.-]{2,20}$";

}
