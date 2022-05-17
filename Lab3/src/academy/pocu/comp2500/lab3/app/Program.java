package academy.pocu.comp2500.lab3.app;

import academy.pocu.comp2500.lab3.ListItem;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        {
            ListItem item1 = new ListItem("This is item1");
        }

        {
            ListItem item1 = new ListItem("This is item1");

            String s = item1.getText(); // s: This is item1
        }

        {
            ListItem item1 = new ListItem("This is item1");
            String s = item1.getText(); // s: This is item1

            item1.setText("This is updated item1");

            s = item1.getText(); // s: This is updated item1
        }

        {
            ListItem item1 = new ListItem("This is item1");

            char c = item1.getBulletStyle(); // c: *
        }

        {
            ListItem item1 = new ListItem("This is item1");

            item1.addSublistItem(new ListItem("This is sublist item1"));
        }

        {
            ListItem item1 = new ListItem("This is item1");

            item1.addSublistItem(new ListItem("This is sublist item1"));

            ListItem sublistItem1 = item1.getSublistItem(0);
            String s = sublistItem1.getText(); // s: This is sublist item1
        }
        {
            ListItem item1 = new ListItem("This is item1");
            ListItem sublistItem1 = new ListItem("This is sublist item1");
            ListItem subSublistItem1 = new ListItem("This is sub-sublist item1");
            ListItem subSublistItem2 = new ListItem("This is sub-sublist item2");

            sublistItem1.addSublistItem(subSublistItem1);
            sublistItem1.addSublistItem(subSublistItem2);
            item1.addSublistItem(sublistItem1);

            String s = item1.toString();
// s:
            /*
             * This is item1
             * This is sublist item1
             * This is sub-sublist item1
             * This is sub-sublist item2

             */
        }

        {
            ListItem item1 = new ListItem("This is item1", '1');
            ListItem item2 = new ListItem("This is item2", '2');

            item1.toString();
/*
1 This is item1

*/

            item2.toString();
/*
2 This is item2

*/
        }

        {

            ListItem item = new ListItem("This is item");

            item.addSublistItem(new ListItem("This is sublist item1"));
            item.addSublistItem(new ListItem("This is sublist item2"));

            item.toString();
            /*
             * This is item
             * This is sublist item1
             * This is sublist item2

             */

            item.removeSublistItem(0);

            item.toString();
            /*
             * This is item
             * This is sublist item2

             */
        }


        ArrayList<ListItem> list = new ArrayList<>();

        ListItem listItem1 = new ListItem("My first item");

        ListItem sublistItem1 = new ListItem("This is sublist item1", '>');
        ListItem sublistItem2 = new ListItem("This is sublist item2", '>');

        listItem1.addSublistItem(sublistItem1);
        listItem1.addSublistItem(sublistItem2);

        ListItem listItem2 = new ListItem("My second item");

        ListItem listItem3 = new ListItem("My third item");

        ListItem sublistItem3 = new ListItem("This is sublist item3", '>');
        ListItem subSublistItem1 = new ListItem("This is sub-sublist item1", '-');

        sublistItem3.addSublistItem(subSublistItem1);
        listItem3.addSublistItem(sublistItem3);

        list.add(listItem1);
        list.add(listItem2);
        list.add(listItem3);

        String actual = toString(list);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* My first item%s", System.lineSeparator()));
        sb.append(String.format("    > This is sublist item1%s", System.lineSeparator()));
        sb.append(String.format("    > This is sublist item2%s", System.lineSeparator()));
        sb.append(String.format("* My second item%s", System.lineSeparator()));
        sb.append(String.format("* My third item%s", System.lineSeparator()));
        sb.append(String.format("    > This is sublist item3%s", System.lineSeparator()));
        sb.append(String.format("        - This is sub-sublist item1%s",
                System.lineSeparator()));

        String expected = sb.toString();


        System.out.printf("%s", actual);
        assert expected.equals(actual);

        System.out.print(actual);
    }

    private static String toString(ArrayList<ListItem> list) {
        StringBuilder sb = new StringBuilder();
        for (ListItem item : list) {
            sb.append(item);
        }

        return sb.toString();
    }
}