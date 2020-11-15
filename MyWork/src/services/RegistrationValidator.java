package services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidator {
    public List<String> errors;
    private Pattern pattern;
    private Matcher matcher;
    private UserService userService;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PASSWORD_PATTERN =
            "^[A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public RegistrationValidator() {
        userService = new UserService();
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public synchronized List<String> validate(String email, String password, String age, String firstName, String lastName, String role) {
        this.cleanErrors();
        this.validateMail(email);
//        this.validatePassword(password);
        this.validateEmailName(email);
        this.validateAge(age);
        this.validateFirstName(firstName);
        this.validateLastName(lastName);
        this.validateRole(role);
        return this.errors;
    }

    private void validateFirstName(String name){
        if(name.isEmpty()){
            errors.add("Error: Вы не указали имя");
        }
    }

    private void validateLastName(String name){
        if(name.isEmpty()){
            errors.add("Error: Вы не указали фамилию");
        }
    }

    private void validateRole(String role){
        if(role == null){
            errors.add("Error: Вы не указали, кем вы являетесь");
        }
    }

    private void validateAge(String age) {
        if(age.isEmpty()){
            errors.add("Error : Вы не указали возраст");
        }
    }

    private void validateEmailName(String email) {
        if(userService.findUserByEmail(email).isPresent()){
            errors.add("Error : invalid email. User with that email already exists. Please sign in");
        }
    }

    private void validatePassword(String password) {
        if(password.length()<5){
            errors.add("Error : invalid Password. Should have >=5 length");
        }
    }

    private void validateMail(String mail) {
        matcher = pattern.matcher(mail);
        if(!matcher.matches()){
            errors.add("Error : invalid Email. Should contains @ and .xxx ");
        }
    }

    public void cleanErrors() {
        this.errors = new ArrayList<>();
    }
}
