package academy.pocu.comp2500.lab4.app;

import academy.pocu.comp2500.lab4.EvictionPolicy;
import academy.pocu.comp2500.lab4.MemoryCache;

import java.io.Console;
import java.sql.Time;
import java.time.OffsetDateTime;
import java.util.LinkedHashMap;

public class Program {

    public static void main(String[] args) {
	    // write your code here

        for(int i = 0; i < 2; i++)
        {
            System.out.println(i);
        }
        {
            MemoryCache memCacheA = MemoryCache.getInstance("A");

            MemoryCache memCacheB = MemoryCache.getInstance("B");
            MemoryCache memCacheC = MemoryCache.getInstance("C");

            assert memCacheA == MemoryCache.getInstance("A");
            assert memCacheB == MemoryCache.getInstance("B");
            assert memCacheC == MemoryCache.getInstance("C");

            MemoryCache.setMaxInstanceCount(3);

            MemoryCache memCacheD = MemoryCache.getInstance("D");

            assert memCacheA != MemoryCache.getInstance("A");
            assert memCacheC == MemoryCache.getInstance("C");
            assert memCacheB != MemoryCache.getInstance("B");
            assert memCacheD != MemoryCache.getInstance("D");
        }



        {
            MemoryCache memCache = MemoryCache.getInstance("A");
            memCache.addEntry("key1", "value1");
            memCache.addEntry("key2", "value2");
            memCache.addEntry("key3", "value3");
            memCache.addEntry("key4", "value4");
            memCache.addEntry("key5", "value5");

            memCache.setMaxEntryCount(3);

            assert memCache.getEntryOrNull("key1") == null;
            assert memCache.getEntryOrNull("key2") == null;
            assert memCache.getEntryOrNull("key3") != null;
            assert memCache.getEntryOrNull("key4") != null;
            assert memCache.getEntryOrNull("key5") != null;

            memCache.addEntry("key6", "value6");

            assert memCache.getEntryOrNull("key3") == null;

            memCache.getEntryOrNull("key4");
            memCache.getEntryOrNull("key5");
            memCache.getEntryOrNull("key4");

            memCache.addEntry("key7", "value7");

            assert memCache.getEntryOrNull("key6") == null;

            memCache.addEntry("key5", "value5_updated");
            memCache.addEntry("key8", "value8");

            assert memCache.getEntryOrNull("key4") == null;

            assert memCache.getEntryOrNull("key5").equals("value5_updated");

            memCache.setEvictionPolicy(EvictionPolicy.FIRST_IN_FIRST_OUT);

            memCache.addEntry("key9", "value9");
            assert memCache.getEntryOrNull("key5") == null;

            memCache.addEntry("key10", "value10");
            assert memCache.getEntryOrNull("key7") == null;

            memCache.setMaxEntryCount(1);

            assert memCache.getEntryOrNull("key8") == null;
            assert memCache.getEntryOrNull("key9") == null;
            assert memCache.getEntryOrNull("key10").equals("value10");

            memCache.setMaxEntryCount(5);
            memCache.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);

            memCache.addEntry("key11", "value11");
            memCache.addEntry("key12", "value12");
            memCache.addEntry("key13", "value13");
            memCache.addEntry("key14", "value14");

            assert memCache.getEntryOrNull("key10") != null;
            assert memCache.getEntryOrNull("key11") != null;
            assert memCache.getEntryOrNull("key12") != null;
            assert memCache.getEntryOrNull("key13") != null;
            assert memCache.getEntryOrNull("key14") != null;

            memCache.addEntry("key15", "value15");

            assert memCache.getEntryOrNull("key14") == null;

            assert memCache.getEntryOrNull("key13") != null;
            assert memCache.getEntryOrNull("key11") != null;
            assert memCache.getEntryOrNull("key12") != null;
            assert memCache.getEntryOrNull("key10") != null;
            assert memCache.getEntryOrNull("key15") != null;

            memCache.setEvictionPolicy(EvictionPolicy.LEAST_RECENTLY_USED);

            memCache.addEntry("key16", "value16");

            assert memCache.getEntryOrNull("key13") == null;
            assert memCache.getEntryOrNull("key10") != null;
            assert memCache.getEntryOrNull("key11") != null;
            assert memCache.getEntryOrNull("key12") != null;
            assert memCache.getEntryOrNull("key15") != null;
            assert memCache.getEntryOrNull("key16") != null;
        }

        {
            MemoryCache.clear();
            MemoryCache memCache = MemoryCache.getInstance("A");
            memCache.addEntry("key1", "value1");
            memCache.addEntry("key2", "value2");
            memCache.addEntry("key3", "value3");
            memCache.addEntry("key4", "value4");
            memCache.addEntry("key5", "value5");

            memCache.setMaxEntryCount(3);

            assert memCache.getEntryOrNull("key1") == null;
            assert memCache.getEntryOrNull("key2") == null;
            assert memCache.getEntryOrNull("key3") != null;
            assert memCache.getEntryOrNull("key4") != null;
            assert memCache.getEntryOrNull("key5") != null;

            memCache.addEntry("key3", "key3_updated");
            memCache.getEntryOrNull("key4");
            memCache.addEntry("key6", "value6");

            assert memCache.getEntryOrNull("key5") == null;
            assert memCache.getEntryOrNull("key3").equals("key3_updated");
            assert memCache.getEntryOrNull("key4") != null;
            assert memCache.getEntryOrNull("key6") != null;

            memCache.getEntryOrNull("key3");
            memCache.getEntryOrNull("key5");
            memCache.getEntryOrNull("key4");

            memCache.addEntry("key7", "value7");

            assert memCache.getEntryOrNull("key6") == null;
            assert memCache.getEntryOrNull("key3") != null;
            assert memCache.getEntryOrNull("key4") != null;
            assert memCache.getEntryOrNull("key7") != null;

            memCache.addEntry("key3", "value3_updated_updated");
            memCache.getEntryOrNull("key4");
            memCache.addEntry("key8", "value8");

            memCache.setMaxEntryCount(4);

            memCache.getEntryOrNull("key3");
            memCache.addEntry("key9", "value9");
            memCache.addEntry("key10", "value10");

            assert memCache.getEntryOrNull("key7") == null;
            assert memCache.getEntryOrNull("key3").equals("value3_updated_updated");
            assert memCache.getEntryOrNull("key4") == null;
            assert memCache.getEntryOrNull("key8") != null;
            assert memCache.getEntryOrNull("key9") != null;
            assert memCache.getEntryOrNull("key10") != null;

            memCache.setMaxEntryCount(1);

            assert memCache.getEntryOrNull("key3") == null;
            assert memCache.getEntryOrNull("key8") == null;
            assert memCache.getEntryOrNull("key9") == null;
            assert memCache.getEntryOrNull("key10") != null;

            memCache.setEvictionPolicy(EvictionPolicy.FIRST_IN_FIRST_OUT);

            memCache.setMaxEntryCount(4);
            memCache.addEntry("key11", "value11");
            memCache.addEntry("key12", "value12");
            memCache.addEntry("key13", "value13");
            memCache.addEntry("key14", "value14");
            memCache.setMaxEntryCount(2);

            assert memCache.getEntryOrNull("key10") == null;
            assert memCache.getEntryOrNull("key11") == null;
            assert memCache.getEntryOrNull("key12") == null;
            assert memCache.getEntryOrNull("key13") != null;
            assert memCache.getEntryOrNull("key14") != null;

            memCache.getEntryOrNull("key13");
            memCache.addEntry("key15", "value15");

            assert memCache.getEntryOrNull("key13") == null;
            assert memCache.getEntryOrNull("key14") != null;
            assert memCache.getEntryOrNull("key15") != null;

            memCache.addEntry("key14", "value14_updated");
            assert memCache.getEntryOrNull("key14").equals("value14_updated");
            memCache.setMaxEntryCount(1);

            assert memCache.getEntryOrNull("key14") == null;
            assert memCache.getEntryOrNull("key15") != null;

            memCache.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);
            memCache.setMaxEntryCount(4);

            memCache.addEntry("key16", "value16");
            memCache.addEntry("key17", "value17");
            memCache.addEntry("key18", "value18");
            memCache.addEntry("key19", "value19");


            assert memCache.getEntryOrNull("key18") == null;
            assert memCache.getEntryOrNull("key19") != null;
            assert memCache.getEntryOrNull("key15") != null;
            assert memCache.getEntryOrNull("key16") != null;
            assert memCache.getEntryOrNull("key17") != null;

            memCache.setMaxEntryCount(2);

            assert memCache.getEntryOrNull("key19") == null;
            assert memCache.getEntryOrNull("key15") != null;
            assert memCache.getEntryOrNull("key16") != null;
            assert memCache.getEntryOrNull("key17") == null;

            memCache.addEntry("key15", "value15_updated");
            memCache.getEntryOrNull("key16");
            memCache.addEntry("key20", "value20");
            assert memCache.getEntryOrNull("key15").equals("value15_updated");
            assert memCache.getEntryOrNull("key16") == null;
            assert memCache.getEntryOrNull("key20") != null;

            memCache.setEvictionPolicy(EvictionPolicy.LEAST_RECENTLY_USED);
            memCache.setMaxEntryCount(3);
            memCache.addEntry("key21", "value21");
            memCache.addEntry("key15", "value15_updated_updated");
            memCache.getEntryOrNull("key20");
            memCache.addEntry("key22", "value22");

            assert memCache.getEntryOrNull("key21") == null;
            assert memCache.getEntryOrNull("key15").equals("value15_updated_updated");
            assert memCache.getEntryOrNull("key20") != null;
            assert memCache.getEntryOrNull("key22") != null;

            memCache.addEntry("key15", "value15_updated_updated_updated");

            memCache.setMaxEntryCount(1);
            assert memCache.getEntryOrNull("key21") == null;
            assert memCache.getEntryOrNull("key20") == null;
            assert memCache.getEntryOrNull("key22") == null;
            assert memCache.getEntryOrNull("key15").equals("value15_updated_updated_updated");
        }


    }
}
