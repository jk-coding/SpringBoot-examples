package simpletext;

public class SimpleTextRecord {
  private long id;
  private String title;
  private String text;

  public SimpleTextRecord() {
  }

  public SimpleTextRecord(long id, String title, String text) {
    this.id = id;
    this.title = title;
    this.text = text;
  }

  public long getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
