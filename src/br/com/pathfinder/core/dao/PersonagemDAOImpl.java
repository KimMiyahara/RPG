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
import br.com.pathfinder.api.dao.PersonagemDAO;
import br.com.pathfinder.api.dao.UsuarioDAO;
import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.entity.Personagem;


import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;



public class PersonagemDAOImpl implements PersonagemDAO {

	private ClasseDAO classeDao  = ImplFinder.getImpl(ClasseDAO.class);;
	private UsuarioDAO usuarioDao  = ImplFinder.getImpl(UsuarioDAO.class);
	private MesaDAO mesaDao = ImplFinder.getImpl(MesaDAO.class);
	


	
	@Override
	public Long save(Personagem personagem) {
		 classeDao  = ImplFinder.getImpl(ClasseDAO.class);;
		 usuarioDao  = ImplFinder.getImpl(UsuarioDAO.class);
		 mesaDao = ImplFinder.getImpl(MesaDAO.class);

		
		Connection con = null;
		PreparedStatement insert = null;
		try {
				con = ConfigDBMapper.getDefaultConnection();
			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),Personagem.getColunas());
			
				String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
						Personagem.getColunas().size() - 1, "SEQ_PATHFINDER_PERSONAGEM");

				String sql = "INSERT INTO " + Personagem.TABLE + colunas + " VALUES " + values;
				insert = DAOUtils.criarStatment(sql, con, getDefaultConnectionType(),
						Personagem.getColunasArray());
				

				insert.setString(1, personagem.getNome());
				insert.setLong(2, personagem.getUsuario().getId());
				insert.setLong(3, personagem.getClasse().getId());

				insert.setLong(4, personagem.getLvl());
				insert.setLong(5, personagem.getMesa().getId());
				
				insert.setLong(6, personagem.getForc());
				insert.setLong(7, personagem.getDest());
				insert.setLong(8, personagem.getCons());
				insert.setLong(9, personagem.getInte());
				insert.setLong(10, personagem.getSabe());
				insert.setLong(11, personagem.getCari());
				
				insert.setLong(12, personagem.getFort());
				insert.setLong(13, personagem.getRefl());
				insert.setLong(14, personagem.getVont());
				
				insert.setLong(15, personagem.getHP());
				insert.setLong(16, personagem.getCa());
				insert.setLong(17, personagem.getBba());
				
								
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
	public void update(Personagem personagem) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE "+ Personagem.TABLE + " SET "
					+ Personagem.COL_NOME + " = ?, "+ Personagem.COL_USUARIO +  " = ?, "
					+ Personagem.COL_CLASSE + " = ?, "+ Personagem.COL_LVL +  " = ?, "
					+ Personagem.COL_MESA +  " = ?, " 
					+ Personagem.COL_FORC + " = ?, "+ Personagem.COL_DEST + " = ?, "
					+ Personagem.COL_CONS + " = ?, "+ Personagem.COL_INTE + " = ?, "
					+ Personagem.COL_SABE + " = ?, "+ Personagem.COL_CARI + " = ?, "
					+ Personagem.COL_FORT + " = ?, "+ Personagem.COL_REFL + " = ?, "
					+ Personagem.COL_VONT + " = ?, "
					+ Personagem.COL_HP + " = ?, "+ Personagem.COL_CA + " = ?, "
					+Personagem.COL_BBA +  " = ?  WHERE " + 
					Personagem.COL_ID + " = ?");
			update.setString(1, personagem.getNome());
			update.setLong(2, personagem.getUsuario().getId());
			update.setLong(3, personagem.getClasse().getId());

			update.setLong(4, personagem.getLvl());
			update.setLong(5, personagem.getMesa().getId());
			
			update.setLong(6, personagem.getForc());
			update.setLong(7, personagem.getDest());
			update.setLong(8, personagem.getCons());
			update.setLong(9, personagem.getInte());
			update.setLong(10, personagem.getSabe());
			update.setLong(11, personagem.getCari());
			
			update.setLong(12, personagem.getFort());
			update.setLong(13, personagem.getRefl());
			update.setLong(14, personagem.getVont());
			
			update.setLong(15, personagem.getHP());
			update.setLong(16, personagem.getCa());
			update.setLong(17, personagem.getBba());
			update.setLong(18, personagem.getId());
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
			String sql = "DELETE FROM " + Personagem.TABLE + " WHERE ID = ?;";
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
	public Personagem findById(Long id) {
		Connection con = null;
		PreparedStatement find = null;
		Personagem per = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Personagem.TABLE + " WHERE " + Personagem.COL_ID
					+ " = ?;";
			find = con.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				per = this.buildPersonagem(rs);
			}
			return per;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(con);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Personagem> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Personagem.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildPersonagens(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
		
	}
	
	
	
	
	private Personagem buildPersonagem(ResultSet rs) throws SQLException {
		
		Personagem personagem= new Personagem();
		personagem.setId(rs.getLong(Personagem.COL_ID));
		personagem.setNome(rs.getString(Personagem.COL_NOME));
		personagem.setUsuario(this.usuarioDao.findById
				(rs.getLong(Personagem.COL_USUARIO))
		);
		personagem.setClasse(this.classeDao.findById
				(rs.getLong(Personagem.COL_CLASSE))
		);
		personagem.setMesa(this.mesaDao.findById
				(rs.getLong(Personagem.COL_MESA))
		);
		personagem.setLvl(rs.getLong(Personagem.COL_LVL));
		
		personagem.setForc(rs.getLong(Personagem.COL_FORC));
		personagem.setDest(rs.getLong(Personagem.COL_DEST));
		personagem.setCons(rs.getLong(Personagem.COL_CONS));
		personagem.setInte(rs.getLong(Personagem.COL_INTE));
		personagem.setSabe(rs.getLong(Personagem.COL_SABE));
		personagem.setCari(rs.getLong(Personagem.COL_CARI));
		
		personagem.setFort(rs.getLong(Personagem.COL_FORT));
		personagem.setRefl(rs.getLong(Personagem.COL_REFL));
		personagem.setVont(rs.getLong(Personagem.COL_VONT));
		
		personagem.setHP(rs.getLong(Personagem.COL_HP));
		personagem.setCa(rs.getLong(Personagem.COL_CA));
		personagem.setBBA(rs.getLong(Personagem.COL_BBA));
		
		return personagem;
		
	}
	private List<Personagem> buildPersonagens(ResultSet rs) throws SQLException {
		List<Personagem> personagens = Lists.newArrayList();
		while (rs.next()) {
			personagens.add(this.buildPersonagem(rs));
		}
		return personagens;
	}

	@Override
	public List<Personagem> findByUsuario(Long usu) {
		Connection con = null;
		PreparedStatement find = null;
		//Personagem per = null;
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Personagem.TABLE + " WHERE " + Personagem.COL_USUARIO
					+ " = ?;";
			find = con.prepareStatement(sql);
			find.setLong(1, usu);
			ResultSet rs = find.executeQuery();
			return this.buildPersonagens(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(con);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Personagem> findPersonagens(Long id) {
		Connection con = null;
		PreparedStatement find = null;
		
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Personagem.TABLE + " WHERE " + Personagem.COL_USUARIO
					+ " = ?;";
			find = con.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			return this.buildPersonagens(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(con);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Personagem> findByMesa(Long id) {
		Connection con = null;
		PreparedStatement find = null;
		
		try {
			con = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Personagem.TABLE + " WHERE " + Personagem.COL_MESA
					+ " = ?;";
			find = con.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			return this.buildPersonagens(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(con);
			DbUtils.closeQuietly(find);
		}
	}
}