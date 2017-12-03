package by.nc.school.dev.service.implication;

import by.nc.school.dev.service.AppStringsService;
import by.nc.school.dev.util.Constants;
import java.util.ResourceBundle;

public class AppStringServiceImpl implements AppStringsService {
    protected ResourceBundle bundle;

    private AppStringServiceImpl()
    {
        // TODO add multilingual support based on user profile
        bundle = ResourceBundle.getBundle(Constants.STRINGS_BUNDLE);
    }

    public String getString(String key) {
        return bundle.getString(key);
    }

    public String getString(String key, Object... substitution) {
        return String.format(bundle.getString(key), substitution);
    }
}
