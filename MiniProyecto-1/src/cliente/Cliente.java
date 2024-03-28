package cliente;

import java.util.Scanner;

public class Cliente {
    Scanner scanner = new Scanner(System.in);
    private String nombre;
    private int cedula;
    private Byte nivelIngresos;
    private String fechaCreacion;
    private int savings;
    
    public Cliente() {
        this.nombre = "";
        this.cedula = 0;
        this.nivelIngresos = 0;
        this.fechaCreacion = "";
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre() {
        System.out.print("Ingrese su nombre: ");
        nombre = scanner.nextLine();
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula() {
        System.out.print("Ingrese su cédula: ");
        cedula = scanner.nextInt();
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Byte getNivelIngresos() {
        return nivelIngresos;
    }
    public void setNivelIngresos() {
        do{
            System.out.print("Ingrese su nivel de ingresos (1 a 5): ");
            nivelIngresos = scanner.nextByte();
            if (nivelIngresos < 1 || nivelIngresos > 5){
                System.out.println("Opcion incorrecta, intente de nuevo...\n");
                continue;
            }
            else{
                break;
            }
        }while(nivelIngresos < 1|| nivelIngresos > 5);
    }

    public void setNivelIngresos(Byte nivelIngresos) {
        this.nivelIngresos = nivelIngresos;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion() {
        System.out.print("Ingrese su fecha creacion (dd-mm-aaaa): ");
        scanner.nextLine();
        fechaCreacion = scanner.nextLine();
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    public void addSavings(int amount) {
        savings += amount;
    }

    public void removeSavings(int amount) {
        if (amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("No puede eliminar más dinero del que tiene en su cuenta.");
        }
    }

}
