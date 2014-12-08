package net.sf.jxls.sample.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sample Department bean to demostrate main excel export features
 * author: Leonid Vysochyn
 */
public class Department {
    private String name;
    private Employee chief;
    private List<Employee> staff = new ArrayList<Employee>();
    
    //test loop map in tempalte
    //${department.employee.name}
    private Map<Integer,Employee> employees=new HashMap<Integer,Employee>();

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Employee chief, List<Employee> staff) {
        this.name = name;
        this.chief = chief;
        this.staff = staff;
    }

    public static List<Department> generate(int depCount, int employeeCount){
        List<Department> departments = new ArrayList<Department>();
        for(int index = 0; index < depCount; index++){
            Department dep = new Department("Dep " + index);
            dep.setChief( Employee.generateOne("ch" + index));
            dep.setStaff( Employee.generate(employeeCount) );
            departments.add( dep );
        }
        return departments;
    }

    public void addEmployeeByNo(Integer i,Employee employee){
    	this.employees.put(i, employee);
    }
    
    public void addStaff(Employee employee) {
        this.staff.add(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getChief() {
        return chief;
    }

    public void setChief(Employee chief) {
        this.chief = chief;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public void setStaff(List<Employee> staff) {
        this.staff = staff;
    }


	public Map<Integer, Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Map<Integer, Employee> employees) {
		this.employees = employees;
	}

	 //${department.employee.name}
	public Collection<Employee> getEmployee() {
		return this.employees.values();
	}
    
    
}
