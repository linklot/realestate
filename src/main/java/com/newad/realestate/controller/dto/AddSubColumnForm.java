package com.newad.realestate.controller.dto;

public class AddSubColumnForm {
    
    private long parentColumnId;
    private String columnName;

    public long getParentColumnId() {
        return parentColumnId;
    }

    public void setParentColumnId(long parentColumnId) {
        this.parentColumnId = parentColumnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

}
