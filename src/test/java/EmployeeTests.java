import com.example.pattern.DataManager.api.Dto.EmployeeDto;
import com.example.pattern.DataManager.persistence.entity.Employee;
import com.example.pattern.DataManager.service.ServiceImp.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeTests {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    public void doNothing(){
        assertEquals(true, "true");
    }

        
    @Test
    public void createEmployeeOk(){
        final var employee1 = new Employee();
        employee1.setEmployeeName("coco");
        employee1.setEmployeeSalary(100000L);
        employee1.setEmployeeLastName("Barbara");
        employee1.setMatricule(12345L);
        employee1.setFonction("Software engineer");
        employee1.setCompanyName("Tefba");
        
        assertEquals("coco", employee1.getEmployeeName());
        assertEquals(100000L, employee1.getEmployeeSalary());
        assertEquals(12345L, employee1.getMatricule());
        assertNotNull(employee1);
    }

    @Test
    public void transfertEmployeeToOtherCompany(){
        final var employee = new EmployeeDto();
        employee.setCompany("companyA");
        employee.setFonction("CTO");
        employee.setLastname("MRC");
        employee.setName("user");
        employee.setSalary(100000L);
        employee.setMatricule(007L);

        assertEquals("companyB",employeeService.transfertEmployeeToOtherCompany(employee));
    }
}
