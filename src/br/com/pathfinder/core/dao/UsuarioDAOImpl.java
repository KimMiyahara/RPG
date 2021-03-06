package br.com.pathfinder.core.dao;
import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.pathfinder.api.dao.UsuarioDAO;
import br.com.pathfinder.api.entity.Usuario;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public Long save(Usuario usuario) {
		Connection con = null;
		PreparedStatement insert = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Usuario.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					Usuario.getColunas().size() - 1, "SEQ_PATHFINDER_USUARIO");

			String sql = "INSERT INTO " + Usuario.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, con, getDefaultConnectionType(),
					Usuario.getColunasArray());

			insert.setString(1, usuario.getNome());
			insert.setString(2, usuario.getLogin());
			insert.setString(3, usuario.getSenha());
			
			insert.execute();

			ResultSet generatedKeys = insert.getGeneratedKeys();
			if (generatedKeys.next()) {
				return generatedKeys.getLong(1);
			}

			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(insert);
			DbUtils.closeQuietly(con);
		}
	}

	@Override
	public void update(Usuario usuario) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Usuario.TABLE + " SET "
					+ Usuario.COL_NOME + " = ?, " + Usuario.COL_LOGIN + " = ?, " + Usuario.COL_SENHA + " = ? "
					+ " WHERE " + Usuario.COL_ID + " = ?");
			update.setString(1, usuario.getNome());
			update.setString(2, usuario.getLogin());
			update.setString(3, usuario.getSenha());
			update.setLong(4, usuario.getId());
			update.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(update);
		}
	}

	@Override
	public void delete(Long id) {
		Connection con = null;
		PreparedStatement delete = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "DELETE FROM " + Usuario.TABLE + " WHERE ID = ?;";
			delete = con.prepareStatement(sql);
			delete.setLong(1, id);
			delete.execute();;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(delete);
			DbUtils.closeQuietly(con);
		}
	}

	@Override
	public Usuario findById(Long id) {
		Connection con = null;
		PreparedStatement find = null;
		Usuario user = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Usuario.TABLE + " WHERE " + Usuario.COL_ID
					+ " = ?;";
			find = con.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				user = this.buildUsuario(rs);
			}
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(con);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Usuario> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Usuario.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildUsuarios(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Usuario> buildUsuarios(ResultSet rs) throws SQLException {
		List<Usuario> usuarios = Lists.newArrayList();
		while (rs.next()) {
			usuarios.add(this.buildUsuario(rs));
		}
		return usuarios;
	}

	private Usuario buildUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getLong(Usuario.COL_ID));
		usuario.setNome(rs.getString(Usuario.COL_NOME));
		usuario.setLogin(rs.getString(Usuario.COL_LOGIN));
		usuario.setSenha(rs.getString(Usuario.COL_SENHA));
		
		return usuario;
	}

	@Override
	public Usuario Login(String login, String senha) {
		Connection con = null;
		PreparedStatement find = null;
		Usuario user = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Usuario.TABLE + " WHERE " + Usuario.COL_LOGIN
					+ " = ? AND ;"+ Usuario.COL_SENHA + " = ?;";
			find = con.prepareStatement(sql);
			find.setString(1, login);
			find.setString(1, senha);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				user = this.buildUsuario(rs);
			}
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(con);
			DbUtils.closeQuietly(find);
		}
	}

}
