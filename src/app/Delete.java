package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;
import db.DBException;

public class Delete {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			connection = DB.getConnection();
			ps = connection.prepareStatement(
					""
					);
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		
		sc.close();
	}
}
