package academy.pocu.comp2500.lab3;

import java.util.ArrayList;
public class ListItem {
    private String text;
    private ArrayList<ListItem> sublistItems;
    private char bulletStyle = '*';

    public ListItem(String text) {
        this.text = text;
        sublistItems = new ArrayList<>();
    }

    public ListItem(String text, char bulletStyle) {
        this(text);
        this.bulletStyle = bulletStyle;
    }

    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return bulletStyle;
    }

    public ListItem getSublistItem(int index) {
        return sublistItems.get(index);
    }

    public void addSublistItem(ListItem sublistItem) {
        sublistItems.add(sublistItem);
    }

    public void removeSublistItem(int index) {
        sublistItems.remove(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%c %s\r\n", bulletStyle, text));
        getSublistRecursive(sublistItems, sb, 1);
        return sb.toString();
    }

    private void getSublistRecursive(ArrayList<ListItem> sublistItems, StringBuilder builder, int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("    ");
        }
        String tab = sb.toString();
        for (int i = 0; i < sublistItems.size(); i++) {
            ListItem listItem = sublistItems.get(i);
            builder.append(String.format("%s%c %s\r\n", tab, listItem.getBulletStyle(), listItem.getText()));
            getSublistRecursive(listItem.getSublistItems(), builder, depth + 1);
        }
    }

    private ArrayList<ListItem> getSublistItems() {
        return sublistItems;
    }

}
