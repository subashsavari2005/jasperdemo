package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.model.Family;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class TestService {

	public String generateJasper(String format) throws FileNotFoundException, JRException {
		
		String location ="/home/sys-user/Downloads/";
		List<Family> list= new ArrayList<>();
		Family f=  new Family(1,"pernandas","jesu","rc north street","k.m.kottai"); 
		Family f1=  new Family(1,"savariyammal","innacimuthu","rc north street","k.m.kottai"); 
		Family f2=  new Family(1,"subash","pernandas","rc north street","k.m.kottai");
		Family f3=  new Family(1,"monish","mano","rc north street","k.m.kottai"); 
		Family f4=  new Family(1,"ajith","mariya anthoni","rc north street","k.m.kottai"); 
		list.add(f1);
		list.add(f2);
		list.add(f3);
		list.add(f4);
		System.out.println("Hello Hai");

		File file  = ResourceUtils.getFile("classpath:family.jrxml");
		JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
		Map<String,Object> parameter = new HashMap<>();
		parameter.put("created by", "subash ps");
		JasperPrint print =JasperFillManager.fillReport(report, parameter,ds);
		if(format.equals("html")) {
			JasperExportManager.exportReportToHtmlFile(print,location+"\\family.html");
			
		}
		if(format.equals("pdf")) {
			JasperExportManager.exportReportToPdfFile(print,location+"\\family.pdf");
			
		}
		return "file created with "+ location;
	}

}
