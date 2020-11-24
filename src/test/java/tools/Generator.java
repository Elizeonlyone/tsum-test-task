package tools;

import org.apache.commons.lang3.RandomStringUtils;

//Класс с методами для генерации тестовых данных
public class Generator {

    //Генерация случайно строки с длиной 8 символов
    public static String generateRandomString8(){
        return
            RandomStringUtils.randomAlphabetic(8);
    }

}
