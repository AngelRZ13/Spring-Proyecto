package com.example.demo.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Producto;
import com.example.demo.entity.Proveedor;
import com.example.demo.service.ProductoServices;
import com.example.demo.service.ProveedorServices;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	
	@Autowired 
	ProductoServices servicioProducto;
	
	@Autowired
	ProveedorServices servicioProveedor;
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("productos",servicioProducto.listarTodos());
		model.addAttribute("proveedor",servicioProveedor.listarTodos());
		return "reporte";
	}
	
	@RequestMapping("/reporteProducto")
	public void producto(HttpServletResponse response) {
		try {
			List<Producto> lista=servicioProducto.listarTodos();
			File file=ResourceUtils.getFile("classpath:producto.jrxml");
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper, null,origen);
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, salida);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/reporteProveedor")
	public void proveedor(HttpServletResponse response) {
		try {
			List<Proveedor> lista=servicioProveedor.listarTodos();
			File file=ResourceUtils.getFile("classpath:proveedor.jrxml");
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper, null,origen);
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, salida);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
