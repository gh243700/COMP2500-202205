package academy.pocu.comp2500.lab4;

import java.util.ArrayList;

public class MemoryCache {
    private static ArrayList<String> keys = new ArrayList<>();
    private static ArrayList<MemoryCache> vales = new ArrayList<>();
    private static int instanceCount;
    private static boolean bInstanceCountSet;
    private static long lastUsedCounter;
    private EvictionPolicy evictionPolicy;
    private long lastUsed;
    private int maxEntryCount;
    private boolean bMaxEntryCountSet;
    private ArrayList<Entry> entries;


    private static class Entry {
        private static long eLastUsedCounter;

        private String key;
        private String value;
        private long eLastUsed;


        private String getKey() {
            return key;
        }

        private String getValue() {
            return value;
        }

        private Entry(String key, String value) {
            this.key = key;
            this.value = value;
            this.eLastUsed = ++eLastUsedCounter;
        }

    }
    private MemoryCache() {
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
        this.entries = new ArrayList<>();
    }

    public static MemoryCache getInstance(String key) {
        if (!bInstanceCountSet) {
            instanceCount++;
        }

        if (getIndexOfKey(key) == -1) {
            if (keys.size() >= instanceCount) {
                int index = -1;
                long temp = Long.MAX_VALUE;
                for (int i = 0; i < keys.size(); i++) {
                    if (temp > vales.get(i).lastUsed) {
                        temp = vales.get(i).lastUsed;
                        index = i;
                    }
                }
                keys.remove(index);
                vales.remove(index);
            }
            keys.add(key);
            vales.add(new MemoryCache());
        }
        MemoryCache memoryCache = vales.get(getIndexOfKey(key));
        memoryCache.lastUsed = ++lastUsedCounter;
        return memoryCache;
    }

    public String getEntryOrNull(String key) {

        this.lastUsed = ++lastUsedCounter;
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.getKey().equals(key)) {
                entry.eLastUsed = ++Entry.eLastUsedCounter;
                return entry.getValue();
            }
        }
        return null;
    }
    public void addEntry(String key, String value) {

        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.key.equals(key)) {
                entry.value = value;
                entry.eLastUsed = ++Entry.eLastUsedCounter;
                return;
            }
        }

        if (!bMaxEntryCountSet) {
            maxEntryCount++;
        }

        if (entries.size() >= maxEntryCount) {
            int index = -1;
            switch (evictionPolicy) {
                case LEAST_RECENTLY_USED:
                    long temp = Long.MAX_VALUE;
                    for (int i = 0; i < entries.size(); i++) {
                        Entry entry = entries.get(i);
                        if (temp > entry.eLastUsed) {
                            temp = entry.eLastUsed;
                            index = i;
                        }
                    }
                    break;
                case LAST_IN_FIRST_OUT:
                    index = entries.size() - 1;
                    break;
                case FIRST_IN_FIRST_OUT:
                    index = 0;
                    break;
            }

            entries.remove(index);
        }
        this.lastUsed = ++lastUsedCounter;
        entries.add(new Entry(key, value));
    }
    public void setMaxEntryCount(int count) {
        maxEntryCount = count;
        bMaxEntryCountSet = true;

        if (count >= entries.size()) {
            return;
        }

        if (entries.size() >= maxEntryCount) {
            int n = entries.size() - count;
            switch (evictionPolicy) {
                case LEAST_RECENTLY_USED:
                    for (int i = 0; i < n; i++) {
                        int index = -1;
                        long temp = Long.MAX_VALUE;
                        for (int k = 0; k < entries.size(); k++) {
                            if (temp > entries.get(k).eLastUsed) {
                                temp = entries.get(k).eLastUsed;
                                index = k;
                            }
                        }
                        entries.remove(index);
                    }
                    break;
                case LAST_IN_FIRST_OUT:
                    for (int i = 0; i < n; i++) {
                        entries.remove(entries.size() - 1);
                    }

                    break;
                case FIRST_IN_FIRST_OUT:
                    for (int i = 0; i < n; i++) {
                        entries.remove(0);
                    }
                    break;
            }
        }


    }

    private static int getIndexOfKey(String key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                return i;
            }
        }
        return -1;
    }
    public static void clear() {
        keys = new ArrayList<>();
        vales = new ArrayList<>();


        instanceCount = 0;
        bInstanceCountSet = false;
        lastUsedCounter = 0;
        Entry.eLastUsedCounter = 0;
    }
    public static void setMaxInstanceCount(int count) {
        instanceCount = count;
        bInstanceCountSet = true;
        if (count >= keys.size()) {
            return;
        }

        for (int i = 0; i < keys.size() - count + 1; i++) {
            int index = -1;
            long temp = Long.MAX_VALUE;
            for (int k = 0; k < keys.size(); k++) {
                if (temp > vales.get(k).lastUsed) {
                    temp = vales.get(k).lastUsed;
                    index = k;
                }
            }
            keys.remove(index);
            vales.remove(index);
        }

    }
    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

}
