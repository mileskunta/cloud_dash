package com.ezhupai.persistence.model;

import com.ezhupai.persistence.model.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "dashboard_layout")
public class EbayConfigEntity extends BaseEntity {
    @Column(name = "is_default")
    private Boolean defaultConfig;

    @Column(name = "name")
    private String name;

    @Column(name = "config_str")
    private String layoutConfigStr;

    public Boolean getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(Boolean defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public String getLayoutConfigStr() {
        return layoutConfigStr;
    }

    public void setLayoutConfigStr(String layoutConfigStr) {
        this.layoutConfigStr = layoutConfigStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
