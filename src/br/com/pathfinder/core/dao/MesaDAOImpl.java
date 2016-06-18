package br.com.pathfinder.core.dao;
import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.entity.Mesa;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class MesaDAOImpl implements MesaDAO {

	@Override
	public Long save(Mesa mesa) {
		
		Connection con = null;
		PreparedStatement insert = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),Mesa.getColunas());

				String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
						Mesa.getColunas().size() - 1, "SEQ_PATHFINDER_MESA");

				String sql = "INSERT INTO " + Mesa.TABLE + colunas + " VALUES " + values;
				insert = DAOUtils.criarStatment(sql, con, getDefaultConnectionType(),
						Mesa.getColunasArray());

				insert.setString(1, mesa.getNome());
				insert.setLong(2, mesa.getMestre());
				
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
	public void update(Mesa mesa) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Mesa.TABLE + " SET "
					+ Mesa.COL_NOME + " = ?, "  +Mesa.COL_MESTRE + " = ?  WHERE " + Mesa.COL_ID + " = ?");
			update.setString(1, mesa.getNome());
			update.setLong(2, mesa.getMestre());
			update.setLong(3, mesa.getId());
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
			String sql = "DELETE FROM " + Mesa.TABLE + " WHERE ID = ?;";
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
	public Mesa findById(Long id) {
		Connection con = null;
		PreparedStatement find = null;
		Mesa user = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Mesa.TABLE + " WHERE " + Mesa.COL_ID
					+ " = ?;";
			find = con.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				user = this.buildMesa(rs);
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
	public List<Mesa> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Mesa.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildMesas(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}
	private Mesa buildMesa(ResultSet rs) throws SQLException {
		Mesa mesa= new Mesa();
		mesa.setId(rs.getLong(Mesa.COL_ID));
		mesa.setNome(rs.getString(Mesa.COL_NOME));
		mesa.setMestre(rs.getLong(Mesa.COL_MESTRE));
		return mesa;
	}
	private List<Mesa> buildMesas(ResultSet rs) throws SQLException {
		List<Mesa> mesas = Lists.newArrayList();
		while (rs.next()) {
			mesas.add(this.buildMesa(rs));
		}
		return mesas;
	}

	@Override
	public List<Mesa> findByMestre(Long mest) {
		
		Connection con = null;
		PreparedStatement find = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Mesa.TABLE + " WHERE " + Mesa.COL_MESTRE
					+ " = ?;";
			find = con.prepareStatement(sql);
			
			find.setLong(1, mest);
			ResultSet rs = find.executeQuery();
			return this.buildMesas(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(con);
			DbUtils.closeQuietly(find);
		}
	}
}
