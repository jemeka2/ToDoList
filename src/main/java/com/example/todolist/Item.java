package com.example.todolist;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Item {
    @NotNull
    @Min(1)
    private long id;

    @NotNull
    @Size(min=5, max=15)
    private String item;

    @NotEmpty
    private String pic;

    @NotNull
    @Size(min=10, max=100)
    private String description;

    @NotNull
    private String dueDate;

    private boolean priority, status;


    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPriority() {
        return priority;
    }
    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
