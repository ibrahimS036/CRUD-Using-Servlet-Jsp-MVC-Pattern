package MvcPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class DaoImpl implements UserDao {

	@Override
	public void create(Bean ref) {
		try {

			Connection con = ConnectionProvider.CreateC();
			String Query = ("insert into data(name,phone,email,password)values(?,?,?,?)");
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setString(1, ref.getName());
			ps.setString(2, ref.getPhone());
			ps.setString(3, ref.getEmail());
			ps.setString(4, ref.getPassword());
			int result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public List<Bean> read() {
		Connection con = ConnectionProvider.CreateC();
		String Query = ("select * from data");
		List<Bean> list = new ArrayList<Bean>();
		try {
			PreparedStatement ps = con.prepareStatement(Query);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Bean user = new Bean();
				user.setName(result.getString("name"));
				user.setPhone(result.getString("phone"));
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close(); // Close connection in finally block
			} catch (SQLDataException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	public void update(Bean ref) {
		Connection con = ConnectionProvider.CreateC();
		String Query = ("update data set password=? where email=?");
		try {
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setString(1, ref.getPassword());
			ps.setString(2, ref.getEmail());
			int result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Bean ref) {
		Connection con = ConnectionProvider.CreateC();
		String Query = ("delete from data where email=?");
		try {
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setString(1, ref.getEmail());
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
