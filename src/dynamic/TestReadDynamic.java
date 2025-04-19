package dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestReadDynamic {

	public static void main(String[] args) throws Exception {

		// testRead1();
		// testRead2();
		//testRead3(10, 0, null, 0, 0, 0);
		
		MarksheetBean bean = new MarksheetBean();
		// bean.setId(1);
		bean.setRollNo(101);
		// bean.setName("a");
		// bean.setPhysics(30);
		// bean.setChemistry(56);
		// bean.setMaths(89);
		//testRead4(bean);
		
		//testRead5(bean);
		testRead6(bean, 1, 5);

	}

	public static void testRead1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");// loading the driver

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");// establishing
																													// the
																													// connection

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");// creates a PreparedStatement object
																					// to execute an SQL READ query

		ResultSet rs = pstmt.executeQuery();// This line executes the query and returns a ResultSet.

		while (rs.next()) {// The while (rs.next()) loop processes each row of the result set. The while
							// (rs.next()) loop processes each row of the result set.
							// rs.next() moves the cursor to the next row and returns true if there's a row
							// available.

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}

	public static void testRead2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		// String sql = "select * from marksheet";
		// String sql = "select * from marksheet where id = 1";
		String sql = "select * from marksheet where roll_no = 101";
		// String sql = "select * from marksheet where name like 'a%'";
		// String sql = "select * from marksheet where physics = 12";
		// String sql = "select * from marksheet where chemistry = 34";
		// String sql = "select * from marksheet where maths = 55";

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}

	public static void testRead3(int id, int rollNo, String name, int physics, int chemistry, int maths)
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "select * from marksheet";

		if (id > 0) {
			sql += " where id = " + id;
		}
		if (rollNo > 0) {
			sql += " where roll_no = " + rollNo;
		}
		if (name != null) {
			sql += " where name = " + name;
		}
		if (physics > 0) {
			sql += " where physics = " + physics;
		}
		if (chemistry > 0) {
			sql += " where chemistry = " + chemistry;
		}
		if (maths > 0) {
			sql += " where maths = " + maths;
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}

	public static void testRead4(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "select * from marksheet";

		if (bean != null) {
			if (bean.getId() > 0) {
				sql += " where id = " + bean.getId();
			}
			if (bean.getRollNo() > 0) {
				sql += " where roll_no = " + bean.getRollNo();
			}
			if (bean.getName() != null) {
				sql += " where name = " + bean.getName();
			}
			if (bean.getPhysics() > 0) {
				sql += " where physics = " + bean.getPhysics();
			}
			if (bean.getChemistry() > 0) {
				sql += " where chemistry = " + bean.getChemistry();
			}
			if (bean.getMaths() > 0) {
				sql += " where maths = " + bean.getMaths();
			}
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}
	
	public static void testRead5(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getRollNo() > 0) {
				sql.append(" and roll_no = " + bean.getRollNo());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getPhysics() > 0) {
				sql.append(" and physics = " + bean.getPhysics());
			}
			if (bean.getChemistry() > 0) {
				sql.append(" and chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append(" and maths = " + bean.getMaths());
			}
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}

	public static void testRead6(MarksheetBean bean, int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getRollNo() > 0) {
				sql.append(" and roll_no = " + bean.getRollNo());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getPhysics() > 0) {
				sql.append(" and physics = " + bean.getPhysics());
			}
			if (bean.getChemistry() > 0) {
				sql.append(" and chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append(" and maths = " + bean.getMaths());
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}
}