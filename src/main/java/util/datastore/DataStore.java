package util.datastore;

import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * parent class for all thread local models.
 *
 * @param <T> type of thread local variable.
 */
@Getter
public abstract class DataStore<T> {
    private final ThreadLocal<T> dataDump;

    public DataStore(ThreadLocal<T> dataDump) {
        this.dataDump = dataDump;
    }

    @SneakyThrows
    protected void writeToThread() {
        if (!(Objects.equals(dataDump.get(), null))) {
            Class<?> clazz = this.getClass();
            Field[] fields = clazz.getDeclaredFields();
            T returnValue = (T) this;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value1 = field.get(this);
                Object value2 = field.get(dataDump.get());
                Object value = (value1 != null) ? value1 : value2;
                field.set(returnValue, value);
            }
            dataDump.set(returnValue);
        } else {
            dataDump.set((T) this);
        }
    }
}
