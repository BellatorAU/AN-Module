package by.nc.school.dev.persistence;

import by.nc.school.dev.model.Journal;
import java.util.List;

public interface JournalDAO {
    Journal get(int id);

    Journal getByGroupID(int groupID);

    void create(Journal journal);

    void update(Journal journal);

    void delete(int groupId);

    List<Journal> getAll();
}
