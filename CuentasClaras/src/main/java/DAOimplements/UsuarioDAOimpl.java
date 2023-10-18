package DAOimplements;

import DAO.UsuarioDAO;
import entidades.Usuario;

public class UsuarioDAOimpl extends GenericDAOimpl<Usuario> implements UsuarioDAO{
		
		public UsuarioDAOimpl() {
			super(Usuario.class);
		}
}
