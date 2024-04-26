package ttps.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ttps.spring.model.CategoriaGasto;
import ttps.spring.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByNombre(String nombre);
    Usuario findByNombreUsuarioAndContrasena(String nombreUsu, String contrasena);

	
	Usuario findById (long id);
	
	List<Usuario> findAll(); 
	
	Usuario save(Usuario usuario);
	   
	@Query("SELECT u FROM Usuario u WHERE u.email = ?1")
	Usuario findByEmail(String email);
	
    /*@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Usuario u WHERE u.email = ?1")
    boolean existsByEmail(String email);*/

}