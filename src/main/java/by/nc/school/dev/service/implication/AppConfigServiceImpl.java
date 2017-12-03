package by.nc.school.dev.service.implication;

import by.nc.school.dev.service.AppConfigService;
import by.nc.school.dev.util.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfigServiceImpl implements AppConfigService {
    protected Properties properties;

    private AppConfigServiceImpl() throws IOException {
        properties = new Properties();
        InputStream input = AppConfigServiceImpl.class.getClassLoader().getResourceAsStream(Constants.PROPERTY_FILE);
        try {
            properties.load(input);
        } finally{
            input.close();
        }
    }

    public String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}
