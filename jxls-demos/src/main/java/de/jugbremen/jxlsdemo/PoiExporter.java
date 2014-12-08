package de.jugbremen.jxlsdemo;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import de.jugbremen.jxlsdemo.exceptions.ExcelGenerationException;
import de.jugbremen.jxlsdemo.model.Article;
import de.jugbremen.jxlsdemo.model.ArticleGroup;
import de.jugbremen.jxlsdemo.model.ShoppingCart;

public class PoiExporter {

    public void exportPoi(ShoppingCart shoppingCart, String destFile) throws ExcelGenerationException {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();

        int rownumber = 0;
        Row row = sheet.createRow(rownumber);
        Cell cell = row.createCell(0);
        cell.setCellValue(shoppingCart.getName());

        rownumber = 2;
        for(ArticleGroup group : shoppingCart.getArticleGroups()) {
            row = sheet.createRow(rownumber);
            cell = row.createCell(0);
            cell.setCellValue(group.getName());

            rownumber += 2;
            for(Article article : group.getArticles()) {
                row = sheet.createRow(rownumber++);
                cell = row.createCell(0);
                cell.setCellValue(article.getName());

                cell = row.createCell(2);
                cell.setCellValue(article.getPrice());
            }

            rownumber += 3;
        }

        try{
        	FileOutputStream out = new FileOutputStream(destFile);
            wb.write(out);
        } catch(IOException e) {
            throw new ExcelGenerationException(e);
        }
        
//        try(FileOutputStream out = new FileOutputStream(destFile)) {
//            wb.write(out);
//        } catch(IOException e) {
//            throw new ExcelGenerationException(e);
//        }
    }
}
