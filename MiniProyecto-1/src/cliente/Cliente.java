package cliente;

import java.util.Scanner;

/**
 * La clase Cliente representa a un cliente con atributos como name, ID number, income level, creation date, y savings.
 */
public class Cliente {
    Scanner scanner = new Scanner(System.in);
    private String name; // Nombre del cliente
    private int idNumber; // Número de cédula del cliente
    private Byte incomeLevel; // Nivel de ingresos del cliente (del 1 al 5)
    private String creationDate; // Fecha de creación de la cuenta del cliente
    private int dia, mes, año; 
    private int savings; // Ahorros del cliente
    
    /**
     * Constructor de la clase Cliente.
     * Inicializa los atributos con valores predeterminados.
     */
    public Cliente() {
        this.name = "";
        this.idNumber = 0;
        this.incomeLevel = 0;
        this.creationDate = "";
        this.dia = this.mes = this.año = 0;
    }
    
    /**
     * Obtiene el nombre del cliente.
     * @return Nombre del cliente.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Establece el nombre del cliente.
     * @param name Nombre del cliente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Permite al usuario ingresar su nombre.
     */
    public void setName() {
        System.out.print("Ingrese su nombre: ");
        name = scanner.nextLine();
    }

    /**
     * Obtiene el número de cédula del cliente.
     * @return Número de cédula del cliente.
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Permite al usuario ingresar su número de cédula.
     */
    public void setIdNumber() {
        System.out.print("Ingrese su cédula: ");
        idNumber = scanner.nextInt();
    }

    /**
     * Establece el número de cédula del cliente.
     * @param idNumber Número de cédula del cliente.
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Obtiene el nivel de ingresos del cliente.
     * @return Nivel de ingresos del cliente.
     */
    public Byte getIncomeLevel() {
        return incomeLevel;
    }
    
    /**
     * Permite al usuario ingresar su nivel de ingresos (del 1 al 5).
     * Muestra un mensaje de error si el valor ingresado está fuera del rango.
     */
    public void setIncomeLevel() {
        do{
            System.out.print("Ingrese su nivel de ingresos (1 a 5): ");
            incomeLevel = scanner.nextByte();
            if (incomeLevel < 1 || incomeLevel > 5){
                System.out.println("Opción incorrecta, intente de nuevo...\n");
                continue;
            }
            else{
                break;
            }
        }while(incomeLevel < 1|| incomeLevel > 5);
    }

    /**
     * Establece el nivel de ingresos del cliente.
     * @param incomeLevel Nivel de ingresos del cliente.
     */
    public void setIncomeLevel(Byte incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    /**
     * Obtiene la fecha de creación de la cuenta del cliente.
     * @return Fecha de creación de la cuenta del cliente.
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Permite al usuario ingresar la fecha de creación de la cuenta (dd-mm-aaaa).
     */
    public void setCreationDate() {
        System.out.println("Ingrese su fecha creacion (dd-mm-aaaa)");
        System.out.print("Ingrese el dia: ");
        dia = scanner.nextShort();
        System.out.print("Ingrese el mes: ");
        mes = scanner.nextShort();
        System.out.print("Ingrese el año: ");
        año = scanner.nextShort();
    
        fechaCreacion = String.format("%02d-%02d-%04d", dia, mes, año);
    }

    /**
     * Establece la fecha de creación de la cuenta del cliente.
     * @param creationDate Fecha de creación de la cuenta del cliente.
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Obtiene los ahorros del cliente.
     * @return Ahorros del cliente.
     */
    public int getSavings() {
        return savings;
    }

    /**
     * Establece los ahorros del cliente.
     * @param savings Ahorros del cliente.
     */
    public void setSavings(int savings) {
        this.savings = savings;
    }

    /**
     * Agrega una cantidad específica a los ahorros del cliente.
     * @param amount Cantidad a agregar a los ahorros.
     */
    public void addSavings(int amount) {
        savings += amount;
    }

    /**
     * Remueve una cantidad específica de los ahorros del cliente.
     * Muestra un mensaje de error si la cantidad a remover es mayor que los ahorros actuales.
     * @param amount Cantidad a remover de los ahorros.
     */
    public void removeSavings(int amount) {
        if (amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("No puede eliminar más dinero del que tiene en su cuenta.");
        }
    }
}
