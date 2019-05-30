package testtask.courierservice.domain;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Task {

    private Long id;

    @Size(min=1, max=64, message="Order number must be between 1 and 64 characters")
    private String orderNumber;

    private LocalDateTime creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
