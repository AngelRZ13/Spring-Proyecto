package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.CategoriaServices;
import com.example.demo.service.ProductoServices;
import com.example.demo.service.RequerimientoServices;
import com.example.demo.entity.Producto;
import com.example.demo.entity.Requerimiento;
import com.example.demo.entity.RequerimientoBien;
import com.example.demo.entity.Usuario;
import com.example.demo.dto.Detalle;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/requerimiento")
public class RequerimientoController {
	
	@Autowired
	private CategoriaServices servicioCat;
	
	@Autowired
	private ProductoServices servicioProd;
	
	@Autowired
	private RequerimientoServices servicioReque;
	
	@RequestMapping("/lista")
	public String lista(Model model){
		model.addAttribute("categorias",servicioCat.listarTodos());		
		model.addAttribute("requerimientos",servicioReque.listarTodos());
		return "requerimiento";
	}
	
	@RequestMapping("/consultaProductos")
	@ResponseBody
	public List<Producto> consultaProductos(@RequestParam("codigo") int cod){
		return servicioProd.productoPorCategoria(cod);
	}	
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,
							@RequestParam("nombre") String nom,
							@RequestParam("cantidad") int can,
							HttpServletRequest request){
		//declarar
		List<Detalle> data=null;
		//validar si existe el atributo de tipo sesión "lista"
		if(request.getSession().getAttribute("lista")==null)//no existe atributo "lista"
			//crear data
			data=new ArrayList<Detalle>();
		else//existe atributo "lista"
			//recuperar el atributo "lista"
			data=(List<Detalle>) request.getSession().getAttribute("lista");
		
		//crear objeto de la clase Detalle
		Detalle det=new Detalle();
		//setear
		det.setCodigo(cod);
		det.setNombre(nom);
		det.setCantidad(can);
		//adcionar "det" dentro de data
		data.add(det);
		//crear atributo "lista"
		request.getSession().setAttribute("lista",data);
		return data;
	}
	@RequestMapping("/detalles")
	@ResponseBody
	public List<Detalle> detalles(HttpServletRequest request){
		List<Detalle> data=(List<Detalle>) request.getSession().getAttribute("lista");
		return data;
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("numero") String num,
						 @RequestParam("descripcion") String des,
						 @RequestParam("fecha") String fec,
						 @RequestParam("estado") String est,
						 HttpServletRequest request,
						 RedirectAttributes redirect) {
		try {
			//Crear objeto de la entidad requerimiento
			Requerimiento data = new Requerimiento();
			data.setNumero(num);//RE-000001
			data.setNombre(des);
			data.setFecha(LocalDate.parse(fec));
			data.setEstado(est);
			//Recuperar atributo de tipo sesion que se llama codigo usuario
			int cod = (int) request.getSession().getAttribute("CODIGOUSUARIO");
			//Crear objeto de usuario
			Usuario u = new Usuario();
			//setear "u"
			u.setCodigo(cod);
			//enviar "u" dentro de data
			data.setUsuario(u);
			
			//Crear arreglo de objetos
			List<RequerimientoBien> detalle = new ArrayList<RequerimientoBien>();
			//Recuperar atributo de tipo Sesion "lista"
			List<Detalle> info=(List<Detalle>) request.getSession().getAttribute("lista");
			//Bucle 
			for(Detalle det:info) {
				//Crear objeto de requerimiento bien
				RequerimientoBien rb = new RequerimientoBien();
				//Crear objeto de bien
				Producto p = new Producto();
				//setear b
				p.setCodigo(det.getCodigo());
				//enviar "b" dentro de "rb"
				rb.setProducto(p);
				rb.setCantidad(det.getCantidad());
				//Enviar rb dentro de "detalle"
				detalle.add(rb);
			}
			
			//enviar detalle dentro de listaDetalle
			data.setListaDetalle(detalle);
			//grabar
			servicioReque.saveRequerimiento(data);
			//Limpiar Info
			info.clear();
			request.getSession().setAttribute("lista",info);
			//Mensaje
			redirect.addFlashAttribute("MENSAJE","Requerimiento Registrado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el Registro");
			
		}
		return "redirect:/requerimiento/lista";
	}
	
	@RequestMapping("/eliminar")
	@ResponseBody
	public List<Detalle> eliminar(@RequestParam("codigo") int cod,
							HttpServletRequest request){
		//declarar
		List<Detalle> data=(List<Detalle>) request.getSession().getAttribute("lista");;
		for(Detalle d:data) {
			if(d.getCodigo()==cod) {
				data.remove(d);
				break;
			}
		}
		request.getSession().setAttribute("lista", data);
		return data;
	}
}
