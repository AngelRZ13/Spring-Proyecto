package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.RequerimientoBienRepository;
import com.example.demo.repository.RequerimientoRepository;
import com.example.demo.entity.Requerimiento;
import com.example.demo.entity.RequerimientoBien;
import com.example.demo.entity.RequerimientoBienPK;

@Service
public class RequerimientoServices {

	@Autowired
	private RequerimientoRepository repoReque;
	
	@Autowired
	private RequerimientoBienRepository repoDet;
	
	@Transactional
	public void saveRequerimiento(Requerimiento bean) {
		try {
			//grabar requerimiento
			repoReque.save(bean);	
			//bucle para realizar recorrido sobre el atributo listaDetalle
			for(RequerimientoBien rb:bean.getListaDetalle()) {
				//Crear llave
				RequerimientoBienPK llave = new RequerimientoBienPK();
				//Setear Objeto llave
				llave.setCod_reque(bean.getCodigo());
				llave.setCod_bien(rb.getProducto().getCodigo());
				//Enviar llave al objeto rb
				rb.setPk(llave);
				//grabar detalle requerimiento
				repoDet.save(rb);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public List<Requerimiento> listarTodos(){
		return repoReque.findAll();
	}
}
