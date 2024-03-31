/**
 * @file App.java
 * @brief Este archivo contiene la implementación de la clase principal App.
 * @author
 *         - Sebastian castro - 2359435
 *         - Karol burbano - 2359305
 *         - Manuel rocero - 2176007s
 */

import java.util.ArrayList;
import java.util.Scanner;
import cliente.Cliente; // Importar la clase Cliente desde el paquete cliente

/**
 * @brief La clase principal que contiene el método `main` y los métodos para
 *        manejar el menú y las operaciones del programa.
 */
public class App {

    /**
     * @brief El método principal que inicia el programa.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este
     *             caso).
     */
    public static void main(String[] args) {
        showMainMenu(); // Llamar al método que muestra el menú principal
    }

    // Lista de clientes
    static ArrayList<Cliente> clients = new ArrayList<Cliente>();
    // Scanner para entrada del usuario
    static Scanner scanner = new Scanner(System.in);
    // Instancia de Cliente
    static Cliente c = new Cliente();

    /**
     * @brief Método para mostrar el menú principal y manejar las operaciones del programa.
     */
    static void showMainMenu() {
        Byte optionByte;

        do {
            System.out.println("\n--------------------------------------------");
            System.out.println("---------------- Bienvenido ----------------");
            System.out.println("Que desea hacer?\n");
            System.out.println("1. Registrar Cliente\r\n" + //
                    "2. Insertar dinero ahorrado\r\n" + //
                    "3. Actualizar dinero ahorrado\r\n" + //
                    "4. Eliminar dinero ahorrado\r\n" + //
                    "5. Buscar cliente por nombre y ver su ahorro\r\n" + //
                    "6. Listar todos los clientes\r\n" + //
                    "7. Solicitar préstamos\r\n" + //
                    "8. Solicitar CDT\r\n" + //
                    "9. Salir\r");
            System.out.println("--------------------------------------------");
            System.out.print("Seleccione una option: ");
            optionByte = scanner.nextByte();
            System.out.println("--------------------------------------------\n");

            switch (optionByte) {
                case 1:
                    addClient();
                    break;
                case 2:
                    insertMoney();
                    break;
                case 3:
                    updateMoney();
                    break;
                case 4:
                    deleteMoney();
                    break;
                case 5:
                    searchClients();
                    break;
                case 6:
                    listClients(clients);
                    break;
                case 7:
                    System.out.println("\nHaz seleccionado solicitar préstamo.");
                    requestLoan();
                    break;
                case 8:
                    System.out.println("\nHaz seleccionado solicitar CDT.");
                    requestCDT();
                    break;
                case 9:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("Option incorrecta, intente de nuevo...\n");
                    break;
            }
        } while (optionByte != 9);
    }

     /**
     * @brief Agrega un nuevo cliente a la lista de clientes.
     * 
     * Este método solicita al usuario ingresar los datos del cliente, crea un nuevo objeto Cliente con esos datos
     * y lo agrega a la lista de clientes.
     */
    static void addClient() {
        System.out.println("--------------------------------------------");
        System.out.println("     Haz seleccionado Registrar Cliente");
        System.out.println("--------------------------------------------");
        System.out.println("Ingrese sus datos por favor...\n");

        c.setName();
        c.setIdNumber();
        c.setIncomeLevel();
        c.setCreationDate();
        clients.add(c);

        System.out.println("--------------------------------------------");
        System.out.println("El cliente ha sido creado exitosamente...\n");

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine(); 
        scanner.nextLine(); 
    }

    /**
     * @brief Permite al usuario insertar dinero en la cuenta de ahorros de un cliente.
     * 
     * Este método muestra la opción de insertar dinero en la cuenta de ahorros de un cliente.
     */
    static void insertMoney() {
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado insertar dinero");
        System.out.println("--------------------------------------------");

        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Clientes registrados:");

        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ". " + clients.get(i).getName());
        }

        System.out.println("--------------------------------------------\n");
        System.out.print("Seleccione un cliente: ");

        int clientIndex = scanner.nextInt();

        if (clientIndex < 1 || clientIndex > clients.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        System.out.print("\nCuanto desea ingresar?: ");
        int money = scanner.nextInt();

        Cliente selectedClient = clients.get(clientIndex - 1);
        selectedClient.addSavings(money);

        System.out.println("\nEl dinero se ingreso correctamente " + selectedClient.getName());
        System.out.println("El saldo de su cuenta de ahorros es $" + selectedClient.getSavings());
        System.out.println("--------------------------------------------\n");

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine(); 
        scanner.nextLine(); 
    }

    /**
     * @brief Permite al usuario actualizar el saldo de la cuenta de ahorros de un cliente.
     * 
     * Este método muestra la opción de actualizar el saldo de la cuenta de ahorros de un cliente.
     */
    static void updateMoney() {
        System.out.println("--------------------------------------------");
        System.out.println("   Haz seleccionado actualizar dinero");
        System.out.println("--------------------------------------------");

        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Clientes registrados:");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ". " + clients.get(i).getName());
        }

        System.out.println("--------------------------------------------\n");
        System.out.print("Seleccione un cliente: ");
        int clientIndex = scanner.nextInt();

        if (clientIndex < 1 || clientIndex > clients.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Cliente selectedClient = clients.get(clientIndex - 1);

        System.out.println("\nEl saldo de su cuenta de ahorros es $" + selectedClient.getSavings());
        System.out.print("Ingrese el valor a actualizar: ");
        int newMoney = scanner.nextInt();

        selectedClient.setSavings(newMoney);

        System.out.println("\nEl dinero se actualizo correctamente " + selectedClient.getName());
        System.out.println("El saldo de su cuenta de ahorros es $" + selectedClient.getSavings());
        System.out.println("------------------------------------------\n");

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }

     /**
     * @brief Permite al usuario eliminar una cantidad de dinero de la cuenta de ahorros de un cliente.
     * 
     * Este método muestra la opción de eliminar una cantidad de dinero de la cuenta de ahorros de un cliente.
     */
    static void deleteMoney() {
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado eliminar dinero");
        System.out.println("--------------------------------------------");

        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Clientes registrados:");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ". " + clients.get(i).getName());
        }

        System.out.println("--------------------------------------------\n");
        System.out.print("Seleccione el número del cliente: ");
        int clientIndex = scanner.nextInt();

        if (clientIndex < 1 || clientIndex > clients.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Cliente selectedClient = clients.get(clientIndex - 1);

        System.out.println("\nEl saldo de su cuenta de ahorros es $" + selectedClient.getSavings());
        System.out.print("Ingrese el valor a eliminar de la cuenta: ");
        int delete = scanner.nextInt();

        selectedClient.removeSavings(delete);

        System.out.println("\nEl dinero se elimino correctamente de " + selectedClient.getName());
        System.out.println("El saldo de su cuenta ahora es $" + selectedClient.getSavings());
        System.out.println("--------------------------------------------\n");

        System.out.println("\nPresiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }

    /**
     * @brief Permite al usuario buscar un cliente por su número de cédula y ver su información.
     * 
     * Este método muestra la opción de buscar un cliente por su nombre, ya sea nombre completo o primer nombre.
     * si encuentra a dos o más clientes con el mismo nombre, Los muestra. 
     */
    static void searchClients() {
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado ver cliente");
        System.out.println("--------------------------------------------");

        System.out.println("¿Desea buscar por nombre completo o solo por el primer nombre?");
        System.out.println("1. Nombre completo");
        System.out.println("2. Primer nombre");
        System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        String nameSearch;
        if (option == 1) {
            System.out.print("Ingrese el nombre completo del cliente: ");
            nameSearch = scanner.nextLine();
        } else if (option == 2) {
            System.out.print("Ingrese el primer nombre del cliente: ");
            nameSearch = scanner.next();
        } else {
            System.out.println("Opción no válida. Volviendo al menú principal...");
            return;
        }

        ArrayList<Cliente> foundClients = new ArrayList<>();

        for (Cliente client : clients) {
            if (option == 1 && client.getName().equalsIgnoreCase(nameSearch)) {
                foundClients.add(client);
            } else if (option == 2) {
                String firstName = client.getName().split("\\s+")[0];
                if (firstName.equalsIgnoreCase(nameSearch)) {
                    foundClients.add(client);
                }
            }
        }

        if (!foundClients.isEmpty()) {

            if (foundClients.size() > 1) {
                System.out.println("\nSe han encontrado varios clientes con el nombre proporcionado:");
                displayClientes(foundClients);
            } else {

                System.out.println("\nCliente encontrado:");
                displayClientes(foundClients);
            }
        } else {
            System.out.println("No se ha encontrado ningún cliente con el nombre proporcionado.");
        }

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }

    /**
     * Método para mostrar la información de los clientes encontrados.
     *
     * @param foundClients Lista de clientes encontrados.
     */
    static void displayClientes(ArrayList<Cliente> foundClients) {
        System.out.println("\nCliente(s) encontrado(s):");
        for (Cliente client : foundClients) {
            System.out.println("Nombre: " + client.getName());
            System.out.println("Cédula: " + client.getIdNumber());
            System.out.println("Fecha de Creación: " + client.getCreationDate());
            System.out.println("Nivel de Ingresos: " + client.getIncomeLevel());
            System.out.println("Ahorros hasta ahora: " + client.getSavings());
        }
    }

    /**
     * @brief Permite al usuario ver la lista de clientes registrados.
     * 
     * Este método muestra la lista de clientes registrados en el sistema.
     * 
     * @param clientes La lista de clientes registrados en el sistema.
     */
    static void listClients(ArrayList<Cliente> clients) {
        int counter = 1;
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado ver cliente");
        System.out.println("--------------------------------------------");
        System.out.println("Los clientes son:");
        for (Cliente client : clients) {
            System.out.println("Cliente " + counter);
            System.out.println("Nombre: " + client.getName());
            counter += 1;
        }

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();

    }

    /**
 * @brief Permite a un cliente solicitar un préstamo.
 *
 * Este método permite que un cliente solicite un préstamo. Se muestra la lista de clientes registrados
 * y se le pide al usuario que seleccione el cliente que solicita el préstamo. 
 *
 * @param clients Lista de clientes registrados.
 */
    static void requestLoan() {
        int debt = 0;

        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado pedir un prestamo");
        System.out.println("--------------------------------------------");

        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Clientes registrados:");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ". " + clients.get(i).getName());
        }

        System.out.println("--------------------------------------------\n");
        System.out.print("Seleccione el número del cliente: ");
        int clientIndex = scanner.nextInt();

        if (clientIndex < 1 || clientIndex > clients.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Cliente selectedClient = clients.get(clientIndex - 1);

        System.out.print("\nEl nombre del cliente es: " + selectedClient.getName());
        System.out.println("\nEl saldo de su cuenta de ahorros es $" + selectedClient.getSavings());
        System.out.print("Ingrese el valor del prestamo: ");
        int loanAmount = scanner.nextInt();

        // Verificar si el monto solicitado está dentro de los límites
        if (loanAmount <= 0) {
            System.out.print("Valor inválido.");
            return;
        }

        // Verificar si el monto solicitado es mayor al doble del saldo de la cuenta de
        // ahorros
        if (loanAmount > 2 * selectedClient.getSavings()) {
            System.out.println("No puedes pedir prestado más del doble de lo que tienes ahorrado.");
            return;
        }

        if (loanAmount <= selectedClient.getSavings()) {
            selectedClient.removeSavings(loanAmount);
            System.out.println("\nEl saldo restante de su cuenta de ahorros es $" + selectedClient.getSavings());
        }

        else if (loanAmount <= (2 * selectedClient.getSavings()) && loanAmount > 0) {
            // Calcular el valor de las cuotas mensuales
            debt = loanAmount - selectedClient.getSavings();
            double annualInterest = 2; // Tasa de interés mensual
            double loanTerm = 0.5; // Plazo del préstamo en años
            double compoundInterest = debt * (Math.pow(1 + annualInterest / 100, loanTerm));
            double monthlyInstallment = compoundInterest / 6;
            // Imprimir el valor de la cuota mensual
            System.out.println("\nEl valor de la cuota mensual es: $" + String.format("%.2f", monthlyInstallment));
            // Descontar el monto solicitado de la cuenta de ahorros del cliente
            selectedClient.removeSavings(selectedClient.getSavings());

            System.out.println("\nEl saldo restante de su cuenta de ahorros es $" + selectedClient.getSavings());
        } else {
            System.out.print("Valor invalido o salió del menú");
        }

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();

    }

    /**
     * @brief Permite al cliente realizar un Certificado de Depósito a Término (CDT).
     * 
     * Este método guía al cliente a través del proceso de crear un CDT.
     * Muestra la lista de clientes registrados y solicita al usuario que seleccione el cliente
     * para quien se creará el CDT. Luego, solicita al usuario que elija el plazo del CDT (3 o 6 meses).
     * Calcula los intereses ganados en función del plazo y el saldo de la cuenta de ahorros del cliente.
     * 
     */
    static void requestCDT() {
        double amount = 0;
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado hacer un CDT");
        System.out.println("--------------------------------------------");
        
        //Verifica que la lista de clientes no este vacia.
        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        //Muestra a los clientes registrados
        System.out.println("Clientes registrados:");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ". " + clients.get(i).getName());
        }

        System.out.println("--------------------------------------------\n");
        System.out.print("Seleccione el número del cliente: ");
        int clientIndex = scanner.nextInt();

        //Verifica que la opcion sea valida.
        if (clientIndex < 1 || clientIndex > clients.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        //Muestra los datos del cliente seleccionado.
        Cliente selectedClient = clients.get(clientIndex - 1);

        System.out.print("\nEl nombre del cliente es: " + selectedClient.getName());
        System.out.println("\nEl saldo de su cuenta de ahorros es $" + selectedClient.getSavings());
        System.out.println("Digite 3 o 6 dependiendo del plazo: ");
        int optionSelect = scanner.nextInt();

        //Muestra las ganancias después de 6 meses o después de 3 meses.
        if (optionSelect == 6) {
            amount = selectedClient.getSavings() * ((0.05 / 12) * 6);
            System.out.println("\nEl total de dinero ganado pasados 6 meses es de $" + String.format("%.2f", amount));
        } else if (optionSelect == 3) {
            amount = selectedClient.getSavings() * ((0.03 / 12) * 3);
            System.out.println("\nEl total de dinero ganado pasados 3 meses es de $" + String.format("%.2f", amount));
        } else {
            System.out.print("Valor invalido o salió del menú");
        }

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();

    }

}
