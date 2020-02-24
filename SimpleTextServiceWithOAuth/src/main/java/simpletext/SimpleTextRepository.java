package simpletext;

import java.util.concurrent.atomic.AtomicLong;
import java.util.HashMap;
import java.util.Collection;

public class SimpleTextRepository {
    private final AtomicLong counter = new AtomicLong();
    private final HashMap<Long, SimpleTextRecord> recordMap = new HashMap<Long, SimpleTextRecord>();

    public SimpleTextRepository() {
        this.init();
    }

    public SimpleTextRecord getRecord(final long id) {
        return this.recordMap.get(id);
    }

    public Collection<SimpleTextRecord> getAllRecords() {
        return this.recordMap.values();
    }

    public SimpleTextRecord addRecord(final String title, final String text) {
        final long id = counter.incrementAndGet();
        final SimpleTextRecord record = new SimpleTextRecord(id, title, text);

        return this.recordMap.putIfAbsent(id, record);
    }

    public SimpleTextRecord replaceRecord(final long id, final String title, final String text) {
        final SimpleTextRecord record = new SimpleTextRecord(id, title, text);

        return this.recordMap.replace(id, record);
    }

    public SimpleTextRecord deleteRecord(final long id) {
        return this.recordMap.remove(id);
    }

    private void init() {
        this.addRecord("Titel 1", "Text Record 1");
        this.addRecord("Titel 2", "Text Record 2");
    }
}