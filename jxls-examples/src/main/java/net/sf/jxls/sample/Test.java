package net.sf.jxls.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.sample.model.Department;
import net.sf.jxls.sample.model.Employee;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Test {

	private static final String templateFilePath = "./src/main/resources/templates/test.xlsx";
	private static final String outputFilePath = "./src/main/resources/build/test_output.xlsx";
	private static final Log log = LogFactory.getLog(Test.class);

	public static void main(String[] args) {
		try {

			Collection<Department> departments = new ArrayList<Department>();

			Department department = new Department("IT");

			// set birthday
			Calendar calendar = Calendar.getInstance();
			calendar.set(1990, 12, 2);
			Date d1 = calendar.getTime();
			calendar.set(1989, 2, 15);
			Date d2 = calendar.getTime();
			calendar.set(1988, 7, 20);
			Date d3 = calendar.getTime();
			calendar.set(1987, 5, 6);
			Date d4 = calendar.getTime();
			calendar.set(1986, 8, 17);
			Date d5 = calendar.getTime();

			department.addEmployeeByNo(1, new Employee("Larry", 24, 5500, 0.2, d1));
			department.addEmployeeByNo(2, new Employee("Terry", 25, 6500, 0.3, d2));
			department.addEmployeeByNo(3, new Employee("Henry", 26, 7500, 0.15, d3));
			department.addEmployeeByNo(4, new Employee("Marry", 27, 8500, 0.25, d4));
			department.addEmployeeByNo(5, new Employee("Dairy", 28, 9500, 0.3, d5));
			
			
			Employee chief = new Employee("Derek", 35, 3000, 0.30, d1);
	        department.setChief(chief);
			
			department.addStaff(new Employee("Elsa", 28, 1500, 0.15, d2));
	        department.addStaff(new Employee("Oleg", 32, 2300, 0.25, d3));
	        department.addStaff(new Employee("Neil", 34, 2500, 0.00, d4));
	        department.addStaff(new Employee("Maria", 34, 1700, 0.15, d5));
	        department.addStaff(new Employee("John", 35, 2800, 0.20, d2));
	        
	        departments.add(department);

			Map<String, Object> bean = new HashMap<String, Object>();
			bean.put("department", department);
			bean.put("departments", departments);
			
			String emptyObj="";
			
			bean.put("emptyObj", emptyObj);

			XLSTransformer transfomer = new XLSTransformer();
			transfomer.setSpreadsheetToRename("Sheet2", "NewName");
			transfomer.setSpreadsheetsToRemove(new String[]{"Sheet3"});

			transfomer.transformXLS(templateFilePath, bean, outputFilePath);
			log.info("done");

		} catch (ParsePropertyException e) {
			log.error(e, e.getCause());
		} catch (InvalidFormatException e) {
			log.error(e, e.getCause());
		} catch (IOException e) {
			log.error(e, e.getCause());
		}
	}
}
