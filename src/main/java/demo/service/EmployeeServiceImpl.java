package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.crudexception.EmployeeNotFoundException;
import demo.entity.Employee;
import demo.repository.EmployeeRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAllByEnabledIsTrue();
    }

    @Override
    public Employee getOneEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employee.getFirstName().equals("") || employee.getLastName().equals("")) {
            return null;
        }
        employee.setCreateDate(new Date());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()){
            Employee employeeUpdate = optionalEmployee.get();
            employeeUpdate.setLastName(employee.getLastName());
            employeeUpdate.setFirstName(employee.getFirstName());

            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        }

        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
