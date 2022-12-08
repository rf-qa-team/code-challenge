package util.datastore;

/**
 * Contains thread local variables list.
 */
public final class DataThreadLocals {
    public static final ThreadLocal<ComDataDump> DATA_DUMP_COM = ThreadLocal.withInitial(ComDataDump::new);

    private DataThreadLocals() {
    }
}
