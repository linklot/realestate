package com.newad.realestate.model;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "SITETOPIC")
@NamedQueries({
////@NamedQuery(name="Role.findRolesByUserId",
////            query="select r from Role r join r.users rusers where rusers.id = :id")
    @NamedQuery(name="SiteTopic.findAll",
                query="from SiteTopic t order by t.id desc"),
    @NamedQuery(name="SiteTopic.findSomeByColumnId",
                query="from SiteTopic t where t.column.id=:columnId order by t.id desc")
})
public class SiteTopic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SITETOPIC_ID")
    private long id;
    
    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "TIME")
    private Calendar time;
    
    @Column(name = "CONTENT")
    private String content;
    
    @Column(name = "SOURCE")
    private String source;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_SITECOLUMN_ID")
    private SiteColumn column;
    
    public SiteTopic() {}
    
    public SiteTopic(SiteColumn column, String title, Calendar time, String source,
            String content) {
        this.column = column;
        this.time = time;
        this.source = source;
        this.content = content;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public SiteColumn getColumn() {
        return column;
    }

    public void setColumn(SiteColumn column) {
        this.column = column;
    }

}
