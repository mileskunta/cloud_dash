package com.ezhupai.persistence.model;

import com.ezhupai.persistence.model.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/6.
 */
@Entity
@Table(name="feedback")
public class FeedbackItemEntity extends BaseEntity{
    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="email")
    private String email;

    @Column(name="cell_phone")
    private String cellPhone;

    @Column(name="create_time")
    private Date createTime;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
