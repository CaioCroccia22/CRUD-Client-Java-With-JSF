package br.com.ccroccia.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import br.com.ccroccia.dao.generics.GenericDAO;
import br.com.ccroccia.domain.Client;


public class ClientDAO extends GenericDAO<Client, Long> implements IClientDao {

	public ClientDAO() {
		super();
	}

	/// ============= insert =========================
	@Override
	protected String getQueryInsert() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO CLIENT ");
		sb.append("(cd_client, nm_client, cd_cpf, nr_phone, ds_address, nr_adress_number, ds_city, ds_state, nr_age) ");
		sb.append("VALUES (nextval('sq_client'), ?, ?, ?, ?, ?, ?, ?, ?)");
		return sb.toString();
	}

	@Override
	protected void setParametersInsert(PreparedStatement stm, Client c) throws SQLException {
		stm.setString(1, c.getName());
		stm.setLong(2, c.getCpf());
		stm.setLong(3, c.getPhone());
		stm.setString(4, c.getAddress());
		stm.setInt(5, c.getNumber());
		stm.setString(6, c.getCity());
		stm.setString(7, c.getState());
		stm.setObject(8, c.getAge(), Types.INTEGER);   
	}

	///=============== delete =============================
	@Override
	protected String getQueryDelete() {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM CLIENT ");
		return sb.toString();
	}

	@Override
	protected void setParametersDelete(PreparedStatement stm, Long value) throws SQLException {
		stm.setLong(1, value);
	}


	/// ========================= UPDATE ==================================
	@Override
	protected String getQueryUpdate() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE CLIENT"
				+ "	SET nm_client = ?, cd_cpf = ?,  nr_phone = ?, ds_address = ?, "
				+ "nr_adress_number = ?, ds_city = ? , ds_state = ?, nr_age = ?");
		return sb.toString();
	}

	@Override
	protected void setParametersUpdate(PreparedStatement stm, Client c) throws SQLException {
		stm.setString(1, c.getName());
		stm.setLong(2, c.getCpf());
		stm.setLong(3, c.getPhone());
		stm.setString(4, c.getAddress());
		stm.setInt(5, c.getNumber());
		stm.setString(6, c.getCity());
		stm.setString(7, c.getState());
		stm.setObject(8, c.getAge(), Types.INTEGER);
		stm.setLong(9, c.getId());
	}


	// ============================== SELECT ===========================================
	@Override
	protected void setParametersSelect(PreparedStatement stm, Long value) throws SQLException {
		stm.setLong(1, value);
	}




	// ==========================================================================

	@Override
	public Class<Client> getTypeClass() {
		return Client.class;
	}


}
