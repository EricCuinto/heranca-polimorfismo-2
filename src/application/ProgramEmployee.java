package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class ProgramEmployee {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("Entre com o número de funcionários: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Funcionário #" + i + " dados:");
			System.out.print("Temporário ? (s/n): ");
			char outsourced = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Horas: ");
			int hours = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();

			if (outsourced == 'n') {
				Employee employee = new Employee(name, hours, valuePerHour);
				list.add(employee);
			} else {
				System.out.print("Despesas adicionais: ");
				double additionalCharge = sc.nextDouble();

				Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(employee);
			}
		}
		System.out.println();
		System.out.println("******PAGAMENTOS:********");
		for (Employee employee : list) {
			System.out.println(employee.getName() + " - R$ " + String.format("%.2f", employee.payment()));
		}

		sc.close();
	}
}
