package model;

import util.TaskMark;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {

    private String title;
    private String description;
    private LocalDateTime dateTime;
    private TaskMark taskMark;
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TaskMark getTaskMark() {
        return taskMark;
    }

    public void setTaskMark(TaskMark taskMark) {
        this.taskMark = taskMark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task(User user, String title, String description, LocalDateTime dateTime, TaskMark taskMark) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.taskMark = taskMark;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", taskMark=" + taskMark +
                ", user=" + user.getName() +
                '}';
    }
}
