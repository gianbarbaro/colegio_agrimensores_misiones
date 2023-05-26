
package com.agrimensuramisiones.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Articles")
public class Article implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = true)
    private String title;
    
    @Column(nullable = true)
    private String content;
    
    @Column(nullable = true)
    private String short_content;
    
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    
    @Column(nullable = true)
    private Boolean visible;

    public Article() {
    }

    public Article(String id, String title, String content, String short_content, Date created_at, Date updated_at, Boolean visible) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.short_content = short_content;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.visible = visible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", title=" + title + ", content=" + content + ", short_content=" + short_content + ", created_at=" + created_at + ", updated_at=" + updated_at + ", visible=" + visible + '}';
    }
    
}
