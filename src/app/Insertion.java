package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.Date;

import db.DB;

public class Insertion {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Quantos vendedores deseja contratar? ");
		int qtd = sc.nextInt();
		sc.nextLine();
		try {
			connection = DB.getConnection();
			for(int i=0;i<qtd;i++) {
				System.out.print("Digite o nome do funcionário "+(i+1)+": ");
				String name = sc.nextLine();
				System.out.print("Digite o email do funcionário "+": ");
				String email = sc.nextLine();
				System.out.print("Digite a data de nascimento do funcionário "+": ");
				LocalDate birthday = LocalDate.parse(sc.nextLine(), dtf);
				System.out.print("Digite o salário do funcionário "+": ");
				double salary = sc.nextDouble();
				System.out.print("Digite o departamento do funcionário "+": ");
				int departmentId = sc.nextInt();
				sc.nextLine();
				
				ps = connection.prepareStatement(
						"INSERT INTO seller"
						+"(Name, Email, BirthDate, BaseSalary, DepartmentId)"
						+"VALUES"
						+"(?, ?, ?, ?, ?)");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setDate(3, new Date(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth()));
				ps.setDouble(4, salary);
				ps.setInt(5, departmentId);
				
				int rowsAffected = ps.executeUpdate();
				System.out.println("Feito!! funcionário "+name+" cadastrado com sucesso!");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
			
		
		sc.close();
	}
}
