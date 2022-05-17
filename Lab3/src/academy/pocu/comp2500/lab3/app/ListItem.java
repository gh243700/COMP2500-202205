package academy.pocu.comp2500.lab3.app;

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

    public ArrayList<ListItem> getSublistItems() {
        return sublistItems;
    }

    public void addSublistItem(ListItem sublistItem) {
        sublistItems.add(sublistItem);
    }

    public void removeSublistItem(int index) {
        sublistItems.remove(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%c %s\n"));



        return null;
    }


    private StringBuilder getSublistRecursive(ListItem listItem, StringBuilder builder) {


    }




}
