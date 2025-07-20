package bdr.tabpaneapp.model;

public class TabItem {
    private final String title;
    private final String content;

    public TabItem(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
