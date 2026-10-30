package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Source path to funcionarios.csv: ");
        String sourcePathFuncionariosCsv = sc.nextLine();
        //Crie dinamicamente uma subpasta chamada out a partir da pasta original do arquivo.
        File funcionariosCsv = new File(sourcePathFuncionariosCsv);
        
        if(funcionariosCsv.exists()){
            boolean sucessOutDirectory = new File(funcionariosCsv.getParent()+"\\out").mkdir();
            File directoryOut = new File(funcionariosCsv.getParent()+"\\out");
            if(sucessOutDirectory){
                try (BufferedReader br = new BufferedReader(new FileReader(funcionariosCsv));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(directoryOut+"\\pagamento.csv"));
                    ) 
                {
                    String line = br.readLine();
                    while(line!=null){
                        String[] employeeInfo = line.split(",");
                        String name = employeeInfo[0];
                        double valuePerHour = Double.parseDouble(employeeInfo[1]);
                        int hours = Integer.parseInt(employeeInfo[2]);
                        Employee employee = new Employee(name, valuePerHour, hours);
                        bw.write(String.format("%.2f",employee.totalSalary()));
                        bw.newLine();
                        line = br.readLine();
                    } 
                } catch (Exception e) {
                    System.out.println("error:"+e.getMessage());
                }
            }
        }
        sc.close();

    }
}
