package by.nc.school.dev.persistence;

import by.nc.school.dev.model.user.User;
import by.nc.school.dev.model.user.UserBuilder;
import by.nc.school.dev.service.AppConfigService;
import by.nc.school.dev.service.AppStringsService;
import org.springframework.beans.factory.annotation.Required;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InmemoryStorage implements Serializable {

    transient protected AppConfigService appConfigService;
    transient protected AppStringsService appStringsService;

    private List<User> users = new ArrayList<>();

    private InmemoryStorage() {}

    private static InmemoryStorage loadStorage(AppConfigService appConfigService) {
        try (InputStream fileInputStream = new FileInputStream(
                System.getProperty("catalina.base") + "/"
                        + appConfigService.getPropertyValue(AppConfigService.KEY_INMEMORY_STORAGE_FILE)
        )) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (InmemoryStorage) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            InmemoryStorage inmemoryStorage = new InmemoryStorage();
            inmemoryStorage.getUsers().add(
                    new UserBuilder().setLogin("admin").setPassword("admin").build()
            );
            return inmemoryStorage;
        }
    }

    public void save() {
        try (OutputStream fileOutputStream = new FileOutputStream(
                System.getProperty("catalina.base") + "/"
                        + appConfigService.getPropertyValue(AppConfigService.KEY_INMEMORY_STORAGE_FILE)
        )) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(appStringsService.getString(AppStringsService.KEY_ERROR_ON_SAVE_STORAGE), e);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    @Required
    public void setAppConfigService(AppConfigService appConfigService) {
        this.appConfigService = appConfigService;
    }

    @Required
    public void setAppStringsService(AppStringsService appStringsService) {
        this.appStringsService = appStringsService;
    }
}
