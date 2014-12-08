package net.sf.jxls.sample;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.sample.model.Department;
import net.sf.jxls.sample.model.Employee;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * @author Leonid Vysochyn
 */
public class BasicTagSample {
    private static String templateFileName = "./src/main/resources/templates/basictags.xls";
    private static String destFileName = "./src/main/resources/build/basictags_output.xls";

    public static void main(String[] args) throws IOException, ParsePropertyException, InvalidFormatException {
        if (args.length >= 2) {
            templateFileName = args[0];
            destFileName = args[1];
        }
        
        List departments = new ArrayList();
        
        Department department = new Department("IT");
        Employee chief = new Employee("Derek", 35, 3000, 0.30);
        department.setChief(chief);
        department.addStaff(new Employee("Elsa", 28, 1500, 0.15));
        department.addStaff(new Employee("Oleg", 32, 2300, 0.25));
        department.addStaff(new Employee("Neil", 34, 2500, 0.00));
        department.addStaff(new Employee("Maria", 34, 1700, 0.15));
        department.addStaff(new Employee("John", 35, 2800, 0.20));
        
        departments.add(department);
        
        
        department = new Department("HR");
        chief = new Employee("Betsy", 37, 2200, 0.30);
        department.setChief(chief);
        department.addStaff(new Employee("Olga", 26, 1400, 0.20));
        department.addStaff(new Employee("Helen", 30, 2100, 0.10));
        department.addStaff(new Employee("Keith", 24, 1800, 0.15));
        department.addStaff(new Employee("Cat", 34, 1900, 0.15));
        
        departments.add(department);
        
        
        department = new Department("BA");
        chief = new Employee("Wendy", 35, 2900, 0.35);
        department.setChief(chief);
        department.addStaff(new Employee("Denise", 30, 2400, 0.20));
        department.addStaff(new Employee("LeAnn", 32, 2200, 0.15));
        department.addStaff(new Employee("Natali", 28, 2600, 0.10));
        department.addStaff(new Employee("Martha", 33, 2150, 0.25));
        
        departments.add(department);
        
        
        Map beans = new HashMap();
        beans.put("departments", departments);
        XLSTransformer transformer = new XLSTransformer();
        transformer.transformXLS(templateFileName, beans, destFileName);
    }

}
