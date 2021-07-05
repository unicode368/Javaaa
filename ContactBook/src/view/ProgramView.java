package view;

public class ProgramView {

    public final String SURNAME_INPUT = "Введіть прізвище:";
    public final String NAME_INPUT = "Введіть ім'я:";
    public final String PATRONIMIC_INPUT = "Введіть по-батькові:";
    public final String NICKNAME_INPUT = "Введіть нікнейм:";
    public final String COMMENT_INPUT = "Залиште коментар щодо контакту:";
    public final String GROUP_INPUT = "Оберіть групу, до якої відноситься контакт:\n" +
                                        "1. Сім'я.\n" +
                                        "2. Робота.\n" +
                                        "3. Друзі.\n";
    public final String HOMEPHONE_INPUT = "Введіть домашній телефон:";
    public final String MOBILE_PHONE_INPUT = "Введіть мобільний телефон:";
    public final String MOBILE_PHONE2_INPUT = "Введіть додатковий мобільний телефон (не обов'язково):";
    public final String EMAIL_INPUT = "Введіть електронну пошту:";
    public final String SKYPE_INPUT = "Введіть логін Skype (не обов'язково):";
    public final String INDEX_INPUT = "Введіть поштовий індекс:";
    public final String CITY_INPUT = "Введіть назву міста:";
    public final String STREET_INPUT = "Введіть назву вулиці:";
    public final String HOUSE_INPUT = "Введіть номер будинку:";
    public final String FLAT_INPUT = "Введіть номер квартири:";

    public final String WRONG_INPUT = "Некорректне введення %s. Будь ласка, спробуйте ще.\n";
    public final String WRONG_GROUP = "Будь ласка, оберіть групу зі списку наявних.";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String message, String option) {
        System.out.format(message, option);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
