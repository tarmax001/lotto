package by.tarmax.lotto.model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractBaseEntity {
    public static AtomicInteger counter = new AtomicInteger(10002);

    Integer id;

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return id != null;
    }
}
