package com.ezhupai.persistence.model.common;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/6/6.
 */

@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
