package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;
import db.DBException;

public class Update {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o nome do funcionário que receberá um aumento: ");
		String employerName = sc.nextLine();
		System.out.print("Valor do aumento: ");
		double raise = sc.nextDouble();
		try {
			connection = DB.getConnection();
			ps = connection.prepareStatement(
					"UPDATE seller "
					+"SET BaseSalary = BaseSalary + ? "
					+"WHERE Name= ? "
					);
			ps.setDouble(1, raise);
			ps.setString(2, employerName);
			
			ps.executeUpdate();
			
			System.out.println("Aumento concedido com sucesso!!");
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			sc.close();
			DB.closeStatement(ps);
			DB.closeConnection();
		}
	}

}
