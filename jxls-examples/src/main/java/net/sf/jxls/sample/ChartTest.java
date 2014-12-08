package net.sf.jxls.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.sample.model.Staff;
import net.sf.jxls.transformer.XLSTransformer;

public class ChartTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		List<Staff> staffs = new ArrayList<Staff>();
		
		Staff s1 = new Staff("张三", 6000D, 3000D);
		staffs.add(s1);
		
		Staff s2 = new Staff("李四", 5000D, 2000D);
		staffs.add(s2);
		
		Staff s3 = new Staff("王五", 4000D, 1000D);
		staffs.add(s3);
		
		String srcFilePath = "./src/main/resources/templates/chartTest.xlsx";
		String destFilePath = "./src/main/resources/build/chartTest_output.xlsx";
		Map<String, List<Staff>> beanParams = new HashMap<String, List<Staff>>();
		beanParams.put("staffs", staffs);
		
		//   //staffs in template means per staff
		
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(srcFilePath, beanParams, destFilePath);
	}

}

