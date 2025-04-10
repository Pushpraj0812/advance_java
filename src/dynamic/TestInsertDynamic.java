package dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsertDynamic {

	public static void main(String[] args) throws Exception {

		// testInsert1();
		// testInsert2();
		//testInsert3(23, 123, "ansh", 87, 78, 56);
		
		MarksheetBean bean = new MarksheetBean();
		bean.setId(24);
		bean.setRollNo(113);
		bean.setName("khush");
		bean.setPhysics(10);
		bean.setChemistry(20);
		bean.setMaths(30);

		testInsert4(bean);
	}

	public static void testInsert1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn
				.prepareStatement("insert into marksheet values(21, 121, 'pushpraj', 99, 99, 99)");

		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);

	}

	public static void testInsert2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, 22);
		pstmt.setInt(2, 122);
		pstmt.setString(3, "shyam");
		pstmt.setInt(4, 18);
		pstmt.setInt(5, 25);
		pstmt.setInt(6, 98);

		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);

	}

	public static void testInsert3(int id, int rollNo, String name, int physics, int chemistry, int maths)
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, id);
		pstmt.setInt(2, rollNo);
		pstmt.setString(3, name);
		pstmt.setInt(4, physics);
		pstmt.setInt(5, chemistry);
		pstmt.setInt(6, maths);

		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);

	}

	public static void testInsert4(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);

	}
}