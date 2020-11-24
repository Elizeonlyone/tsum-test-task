package tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Вспомогательный класс, для работы с конфигом
public class ConfigAssistant {

    private static Properties property;
    private static InputStream inputStream;

    //Метод, импортирующий конфиг из файла resources\cfg\%%.properties. На вход принимает имя файла и подставляет на место %%
    public static void importConfig(String environment) throws IOException {
        try {
            property = new Properties();
            String propFileName = "cfg/" + environment + ".properties";

            inputStream = ConfigAssistant.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                property.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            property.forEach((k, v) -> {
                LoggerAssistant.logger.info("Set system property: {} -> {}.", k, v);
                System.setProperty(k.toString(), v.toString());
            });

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }

    public static Object getProperty(String propertyName){
        return property.getProperty(propertyName);
    }

}
