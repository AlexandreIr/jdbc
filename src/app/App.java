package app;

import java.sql.Connection;

import db.DB;

public class App {
	public static void main(String[] args) {
		Connection connection = DB.getConnection();
		DB.closeConnection();
	}
}
