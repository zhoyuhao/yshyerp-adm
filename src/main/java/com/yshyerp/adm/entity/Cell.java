package com.yshyerp.adm.entity;

import java.util.Date;

/**
 * @author ：tao
 * @date ：Created in 2020/10/26 21:29
 * @description：${description}
 * @modified By：
 * @version: version
 */

public class Cell {
    private int Id;
    private String CellNumber;
    private String Description;
    private Date   EditDateTime;
    private Date CreationDateTime;
    private Integer CreatorId;
    private Integer EditorId;
    private Integer FactoryId;
    private Integer AreaId;
    private Integer State;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCellNumber() {
        return CellNumber;
    }

    public void setCellNumber(String cellNumber) {
        CellNumber = cellNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getEditDateTime() {
        return EditDateTime;
    }

    public void setEditDateTime(Date editDateTime) {
        EditDateTime = editDateTime;
    }

    public Date getCreationDateTime() {
        return CreationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        CreationDateTime = creationDateTime;
    }

    public Integer getCreatorId() {
        return CreatorId;
    }

    public void setCreatorId(Integer creatorId) {
        CreatorId = creatorId;
    }

    public Integer getEditorId() {
        return EditorId;
    }

    public void setEditorId(Integer editorId) {
        EditorId = editorId;
    }

    public Integer getFactoryId() {
        return FactoryId;
    }

    public void setFactoryId(Integer factoryId) {
        FactoryId = factoryId;
    }

    public Integer getAreaId() {
        return AreaId;
    }

    public void setAreaId(Integer areaId) {
        AreaId = areaId;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "Id=" + Id +
                ", CellNumber='" + CellNumber + '\'' +
                ", Description='" + Description + '\'' +
                ", EditDateTime=" + EditDateTime +
                ", CreationDateTime=" + CreationDateTime +
                ", CreatorId=" + CreatorId +
                ", EditorId=" + EditorId +
                ", FactoryId=" + FactoryId +
                ", AreaId=" + AreaId +
                ", State=" + State +
                '}';
    }
}
