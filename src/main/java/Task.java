import java.time.LocalDate;

public class Task {
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Task(int id, String description){
        this.id = id;
        this.description = description;
        this.status = "todo";
        this.createdAt = LocalDate.now().toString();
        this.updatedAt = LocalDate.now().toString();
    }
    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    @Override
    public String toString() {
        return "{" +
                "id=" + this.id +
                ", description='" + this.description + '\'' +
                ", status='" + this.status + '\'' +
                ", createdAt=" + this.createdAt +
                ", updatedAt=" + this.updatedAt +
                '}';
    }
}
