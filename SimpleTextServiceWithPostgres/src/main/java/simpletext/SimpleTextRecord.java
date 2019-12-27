package simpletext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "textrecords")
public class SimpleTextRecord {
  private long id;
  private String title;
  private String text;

  public SimpleTextRecord() {
  }

  public SimpleTextRecord(String title, String text) {
    this.title = title;
    this.text = text;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "title")
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(name = "text")
  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
