package ttps.spring.controller;

import ttps.spring.model.*;
import ttps.spring.repository.CategoriaGastoRepository;
import ttps.spring.repository.GastoRepository;
import ttps.spring.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType; // Asegúrate de importar MediaType
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
//@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping(value = "/gastos", produces = MediaType.APPLICATION_JSON_VALUE)
public class GastoController {

	@Autowired
	private GastoRepository gastoRepository;
	@Autowired
	private CategoriaGastoRepository categoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	/*@PostMapping("")
	@Transactional
	public ResponseEntity<String> crearGasto(@RequestBody Gasto gasto) {
	
		try {
			CategoriaGasto cat = categoriaRepository.findById(gasto.getCategoria().getId());
			if (cat == null) {
				String message = "No existe esa categoria";
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			}
			gasto.setCategoria(cat);
			
			// Buscar usuario 
			Usuario usu = usuarioRepository.findById(gasto.getUsuarioOrigen().getId());
			if (usu == null) {
				String message = "No existe esa Usuario";
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			}
			gasto.setUsuarioOrigen(usu);
			
			gastoRepository.save(gasto);
			String message = "Gasto guardado correctamente";
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	@PostMapping("")
	@Transactional
	public ResponseEntity<Gasto> crearGasto(@RequestBody Gasto gasto) {
	
		try {
			CategoriaGasto cat = categoriaRepository.findById(gasto.getCategoria().getId());
			if (cat == null) {

				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			gasto.setCategoria(cat);
			
			// Buscar usuario 
			Usuario usu = usuarioRepository.findById(gasto.getUsuarioOrigen().getId());
			if (usu == null) {
				String message = "No existe esa Usuario";
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			gasto.setUsuarioOrigen(usu);
			
			Gasto gastoOk = gastoRepository.save(gasto);
			 
			return new ResponseEntity<Gasto>(gastoOk, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Gasto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 public ResponseEntity<Usuario> login(@RequestHeader("usuario") String usuario, @RequestHeader("clave") String clave) {
		    System.out.println("usuario por header: "+ usuario );
		    System.out.println("clave por header: "+ clave );
		  
		    //busco en la bd un usuario con esa clave y ese nombre de usuario
		    Usuario usuarioOk=usuarioRepository.findByNombreUsuarioAndContrasena(usuario, clave);
		    if (usuarioOk != null) {
		    	 //creo el token que hay qye mandar a la salida
		        String token = usuarioOk.getId() + "123456";
			    HttpHeaders headers = new HttpHeaders();
		        headers.add("token", token);
		     
		        
		        // Devolver respuesta exitosa (código 200) con el token en el header
		        return new ResponseEntity<Usuario>(usuarioOk, HttpStatus.OK);
		    }else {
		    	return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		    }
		  }
	
	@GetMapping("/listarTodos")
	public List<Gasto> gasto() {
		System.out.println("listar todos los gastos");
		return gastoRepository.findAll();
	}
	
	@GetMapping("/listarCategorias")
	public List<CategoriaGasto> categoriaGasto() {
		System.out.println("listar");
		return categoriaRepository.findAll();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> actualizarGasto(@PathVariable Long id, @RequestBody Gasto nuevoGasto) {
		
				
		        Gasto gastoExistente = gastoRepository.findById(id); //busco el grupo a modificar
				System.out.print("nuevi"+nuevoGasto.getFecha());
				System.out.print("ecistente"+gastoExistente.getFecha());
				if(gastoExistente != null) { //Si lo encontre:
					//--------Modifica Nombre
					if(nuevoGasto.getNombre() != null) { // ingreso nombre?
						System.out.println("Intenta modificar el nombre");
				
				        gastoExistente.setNombre(nuevoGasto.getNombre());
					}
					
					//--------Modifica imagen 
					if(nuevoGasto.getImagen() != 0) {
				        System.out.println(" modifica imagen");
				        gastoExistente.setImagen(nuevoGasto.getImagen());
					}else {
				        System.out.println("IMAGEN vino null");
						}
					//--------Modifica fecha 
					if(nuevoGasto.getFecha() != null) {
				        System.out.println(" modifica fecha");
				        gastoExistente.setFecha(nuevoGasto.getFecha());
					}else {
				        System.out.println("fecha vino null");
						}
					
					//--------Modifica monto

					if(nuevoGasto.getMonto() != 0) {
				        System.out.println(" modifica monto");
				        gastoExistente.setMonto(nuevoGasto.getMonto());
					}else {
				        System.out.println("monto vino null");
						}

					
					
					//--------Modifica categoria
					System.out.println(nuevoGasto.getCategoria().getNombre());
					if(nuevoGasto.getCategoria() != null ) { //vino categoria para modificar
				        System.out.println("Intenta modificar categoria");
				        CategoriaGasto cat = categoriaRepository.findByNombre(nuevoGasto.getCategoria().getNombre());
						if (cat == null) { 
							return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
						}else {
					    gastoExistente.setCategoria(cat);
						}
						
					}else {
				        System.out.println("categoria vino null");
					}
					//--------Modifica usuario
					System.out.println(nuevoGasto.getUsuarioOrigen());
					if(nuevoGasto.getUsuarioOrigen() != null ) { //vino categoria para modificar
				        System.out.println("Intenta modificar usuario");
				        Usuario usu = usuarioRepository.findByNombre(nuevoGasto.getUsuarioOrigen().getNombre());
						if (usu == null) { 
			
							return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
						}else {
					    gastoExistente.setUsuarioOrigen(usu);
						}
						
					}else {
				        System.out.println("usuario vino null");
						}
					return (ResponseEntity<Object>) new ResponseEntity<>(HttpStatus.OK);

				}else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				} 
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Gasto> obtenerGastoPorId(@PathVariable Long id) {
        System.out.println("------- Mostrar un gasto con id: --------");
        System.out.println(id);

	    try {
	    	
	        Gasto gasto = gastoRepository.findById(id);
	        System.out.println(gasto);

	        
	        if (gasto != null) {
	            return new ResponseEntity<>(gasto, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


}
				





