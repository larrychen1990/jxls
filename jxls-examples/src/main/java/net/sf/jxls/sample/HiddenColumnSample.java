package net.sf.jxls.sample;


import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.sample.model.Department;
import net.sf.jxls.sample.model.Employee;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * @author Leonid Vysochyn
 */
public class HiddenColumnSample {
    private static String templateFileName = "./src/main/resources/templates/department.xls";
    private static String destFileName = "./src/main/resources/build/hiddencolumn_output.xls";

    public static void main(String[] args) throws IOException, ParsePropertyException, InvalidFormatException {
        if (args.length >= 2) {
            templateFileName = args[0];
            destFileName = args[1];
        }
        Department department = new Department("IT");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 12, 2);
        Date d1 = calendar.getTime();
        calendar.set(1980, 2, 15);
        Date d2 = calendar.getTime();
        calendar.set(1976, 7, 20);
        Date d3 = calendar.getTime();
        calendar.set(1968, 5, 6);
        Date d4 = calendar.getTime();
        calendar.set(1978, 8, 17);
        Date d5 = calendar.getTime();
        Employee chief = new Employee("Derek", 35, 3000, 0.30, d1);
        department.setChief(chief);
        department.addStaff(new Employee("Elsa", 28, 1500, 0.15, d2));
        department.addStaff(new Employee("Oleg", 32, 2300, 0.25, d3));
        department.addStaff(new Employee("Neil", 34, 2500, 0.00, d4));
        department.addStaff(new Employee("Maria", 34, 1700, 0.15, d5));
        department.addStaff(new Employee("John", 35, 2800, 0.20, d2));
        
        department.addEmployeeByNo(1, new Employee("Terry", 28, 1600, 0.15, d2));
        department.addEmployeeByNo(2, new Employee("Larry", 23, 1500, 0.20, d3));
        department.addEmployeeByNo(3, new Employee("Marry", 24, 1800, 0.34, d4));
        
        
        Map<String,Object> beans = new HashMap<String,Object>();
        beans.put("department", department);
        XLSTransformer transformer = new XLSTransformer();
        
        //department.staff   per staff of one department
        //used in special loop cases of collection & map
        transformer.groupCollection("department.staff");
        transformer.transformXLS(templateFileName, beans, destFileName);
    }
}
