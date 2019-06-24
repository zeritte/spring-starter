package payroll;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Boolean enabled;
    private Date createDate;

    Employee() {
    }

    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = true;
        this.createDate = new Date();
    }
}
