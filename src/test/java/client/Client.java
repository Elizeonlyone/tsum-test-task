package client;

import tools.Generator;

public class Client {

    //Все параметры пользователя
    private String email;
    private String password;
    private String isMale;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String birthDate;
    private String address;

    public Client(){   }

    //Создание нового клиента со случайно сгенерированным именем. Email пользователя равняется паролю с припиской "_test@test.ru"
    public Client createNewCLient(){
        password = Generator.generateRandomString8();
        email = password + "_test@test.ru";
        return this;
    }

    //Представление пользователя как объект
    public Client (String email, String password){
        this.email = email;
        this.password = password;
    }



    @Override
    public String toString(){
        return
            "email: " + email +
                " pass: " + password;
    }




    //Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsMale() {
        return isMale;
    }

    public void setIsMale(String isMale) {
        this.isMale = isMale;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
