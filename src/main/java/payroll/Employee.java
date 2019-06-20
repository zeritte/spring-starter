package payroll;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
class Employee {

    private @Id @GeneratedValue Long id;
    private String firstname;
    private String lastname;
    private Boolean enabled;
    private Date created_at;

    Employee() {}

    Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.enabled = true;
        this.created_at = new Date();
    }
}
