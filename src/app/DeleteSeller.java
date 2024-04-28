package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;
import db.DBIntegrityException;

public class DeleteSeller {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Digite o nome do vendedor a ser deletado: ");
			String name = sc.nextLine();
			connection = DB.getConnection();
			ps = connection.prepareStatement("DELETE FROM seller WHERE Name = ?");
			ps.setString(1, name);
			ps.executeUpdate();
			System.out.println("Sucesso! O(a) vendedor(a) " + name + " não faz mais parte da empresa");

		} catch (SQLException e) {
			throw new DBIntegrityException(e.getMessage());
		} finally {
			sc.close();
			DB.closeStatement(ps);
			DB.closeConnection();
		}

	}
}
