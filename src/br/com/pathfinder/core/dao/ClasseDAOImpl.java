package br.com.pathfinder.core.dao;
import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.pathfinder.api.dao.ClasseDAO;
import br.com.pathfinder.api.entity.Classe;

import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class ClasseDAOImpl implements ClasseDAO {

	@Override
	public Long save(Classe classe) {
		
		Connection con = null;
		PreparedStatement insert = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),Classe.getColunas());
			
				String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
						Classe.getColunas().size() - 1, "SEQ_PATHFINDER_CLASSE");
				
				String sql = "INSERT INTO " + Classe.TABLE + colunas + " VALUES " + values;
				insert = DAOUtils.criarStatment(sql, con, getDefaultConnectionType(),
						Classe.getColunasArray());
				
				insert.setString(1, classe.getNome());
				insert.setLong(2, classe.getBba());
				insert.setLong(3, classe.getFort());
				insert.setLong(4, classe.getRefl());
				insert.setLong(5, classe.getVont());
				insert.setLong(6, classe.getDado_vida());
				
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
	public void update(Classe classe) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Classe.TABLE + " SET "
					+ Classe.COL_NOME + " = ?, "  +Classe.COL_BBA +  " = ?, " 
					+ Classe.COL_FORT + " = ?, "+ Classe.COL_REFL + " = ?, "+ Classe.COL_VONT + " = ?, "
					+ Classe.COL_DADO_VIDA +" = ?  WHERE " + Classe.COL_ID + " = ?");
			update.setString(1, classe.getNome());
			update.setLong(2, classe.getBba());
			update.setLong(3, classe.getFort());
			update.setLong(4, classe.getRefl());
			update.setLong(5, classe.getVont());
			update.setLong(6, classe.getDado_vida());
			update.setLong(7, classe.getId());
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
			String sql = "DELETE FROM " + Classe.TABLE + " WHERE ID = ?;";
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
	public Classe findById(Long id) {
		Connection con = null;
		PreparedStatement find = null;
		Classe user = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Classe.TABLE + " WHERE " + Classe.COL_ID
					+ " = ?;";
			find = con.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				user = this.buildClasse(rs);
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
	public List<Classe> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Classe.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildClasses(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}
	private Classe buildClasse(ResultSet rs) throws SQLException {
		Classe classe= new Classe();
		classe.setId(rs.getLong(Classe.COL_ID));
		classe.setNome(rs.getString(Classe.COL_NOME));
		classe.setBba(rs.getLong(Classe.COL_BBA));
		classe.setFort(rs.getLong(Classe.COL_FORT));
		classe.setRefl(rs.getLong(Classe.COL_REFL));
		classe.setVont(rs.getLong(Classe.COL_VONT));
		classe.setDado_vida(rs.getLong(Classe.COL_DADO_VIDA));
		return classe;
	}
	private List<Classe> buildClasses(ResultSet rs) throws SQLException {
		List<Classe> Classes = Lists.newArrayList();
		while (rs.next()) {
			Classes.add(this.buildClasse(rs));
		}
		return Classes;
	}




}
