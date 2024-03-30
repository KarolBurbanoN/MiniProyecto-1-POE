import java.util.ArrayList;
import java.util.Scanner;
import cliente.Cliente;

public class App {
    public static void main(String[] args) {
        showMainMenu();
    }


    static ArrayList <Cliente>  clientes = new ArrayList<Cliente>();
    static Scanner scanner = new Scanner(System.in);
    static Cliente c = new Cliente();

    
    static void showMainMenu() { 
        Byte opcionByte;  

        do{
            System.out.println("\n--------------------------------------------");
            System.out.println("---------------- Bienvenido ----------------");
            System.out.println("Que desea hacer?\n");
            System.out.println("1. Registrar Cliente\r\n" + //
                            "2. Insertar dinero ahorrado\r\n" + //
                            "3. Actualizar dinero ahorrado\r\n" + //
                            "4. Eliminar dinero ahorrado\r\n" + //
                            "5. Buscar cliente por nombre y ver su ahorro\r\n" + //
                            "6. Listar todos los clientes\r\n" + //
                            "7. Solicitar prestamos\r\n" + //
                            "8. Solicitar CDT\r\n" + //   
                            "9. Salir\r");        
            System.out.println("--------------------------------------------");               
            System.out.print("Seleccione una opcion: ");
            opcionByte = scanner.nextByte();
            System.out.println("--------------------------------------------\n"); 
            
                switch(opcionByte){
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
                        listClients(clientes);
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
                        System.out.println("Opcion incorrecta, intente de nuevo...\n"); 
                        break;
                }
        }while(opcionByte!=9);     
    }


    static void addClient() {
        System.out.println("--------------------------------------------");
        System.out.println("     Haz seleccionado Registrar Cliente");
        System.out.println("--------------------------------------------");
        System.out.println("Ingrese sus datos por favor...\n");

        Cliente c = new Cliente();
        c.setName();
        c.setIdNumber();
        c.setIncomeLevel();
        c.setCreationDate();
        clientes.add(c);

        System.out.println("--------------------------------------------");
        System.out.println("El cliente ha sido creado exitosamente...\n");

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine(); // Espera a que el usuario presione Enter
        scanner.nextLine(); // Consumir la nueva línea después de presionar Enter
    }


    static void insertMoney() {
        System.out.println("--------------------------------------------");    
        System.out.println("      Haz seleccionado insertar dinero");
        System.out.println("--------------------------------------------");

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
    
        System.out.println("Clientes registrados:");
        
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getName());
        }

        System.out.println("--------------------------------------------\n"); 
        System.out.print("Seleccione un cliente: ");

        int clienteIndex = scanner.nextInt();

        if (clienteIndex < 1 || clienteIndex > clientes.size()) {
            System.out.println("Selección inválida.");
            return;
        }
        
        System.out.print("\nCuanto desea ingresar?: ");
        int money = scanner.nextInt();

        Cliente clienteSeleccionado = clientes.get(clienteIndex - 1);
        clienteSeleccionado.addSavings(money);

        System.out.println("\nEl dinero se ingreso correctamente " + clienteSeleccionado.getName());
        System.out.println("El saldo de su cuenta de ahorros es $" + clienteSeleccionado.getSavings());
        System.out.println("--------------------------------------------"); 

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine(); // Espera a que el usuario presione Enter
        scanner.nextLine(); // Consumir la nueva línea después de presionar Enter
    }


    static void updateMoney() {
        System.out.println("--------------------------------------------");    
        System.out.println("   Haz seleccionado actualizar dinero");
        System.out.println("--------------------------------------------");

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
    
        System.out.println("Clientes registrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getName());
        }

        System.out.println("--------------------------------------------\n"); 
        System.out.print("Seleccione un cliente: ");
        int clienteIndex = scanner.nextInt();

        if (clienteIndex < 1 || clienteIndex > clientes.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Cliente clienteSeleccionado = clientes.get(clienteIndex - 1);

        System.out.println("\nEl saldo de su cuenta de ahorros es $" + clienteSeleccionado.getSavings());
        System.out.print("Ingrese el valor a actualizar: ");
        int newMoney = scanner.nextInt();

        clienteSeleccionado.setSavings(newMoney);

        System.out.println("\nEl dinero se actualizo correctamente " + clienteSeleccionado.getName());
        System.out.println("El saldo de su cuenta de ahorros es $" + clienteSeleccionado.getSavings());
        System.out.println("------------------------------------------\n"); 

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }
    

    static void deleteMoney() {
        System.out.println("--------------------------------------------");    
        System.out.println("      Haz seleccionado eliminar dinero");
        System.out.println("--------------------------------------------");

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
    
        System.out.println("Clientes registrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getName());
        }

        System.out.println("--------------------------------------------\n"); 
        System.out.print("Seleccione el número del cliente: ");
        int clienteIndex = scanner.nextInt();

        if (clienteIndex < 1 || clienteIndex > clientes.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Cliente clienteSeleccionado = clientes.get(clienteIndex - 1);

        System.out.println("\nEl saldo de su cuenta de ahorros es $" + clienteSeleccionado.getSavings());
        System.out.print("Ingrese el valor a eliminar de la cuenta: ");
        int delete = scanner.nextInt();

        clienteSeleccionado.removeSavings(delete);

        System.out.println("\nEl dinero se elimino correctamente de " + clienteSeleccionado.getName());
        System.out.println("El saldo de su cuenta ahora es $" + clienteSeleccionado.getSavings());
        System.out.println("--------------------------------------------\n");

        System.out.println("\nPresiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }
    

    static void searchClients() {
        System.out.println("--------------------------------------------");    
        System.out.println("      Haz seleccionado Buscar cliente");
        System.out.println("--------------------------------------------");
        System.out.print("Ingrese la cedula del cliente: ");
        int busqueda = scanner.nextInt();
        ArrayList<Cliente> clienteEncontrado = searchInClass(clientes, busqueda);
        if(!clienteEncontrado.isEmpty()){
        System.out.println("\nCliente con la cedula "+ busqueda + " encontrada :");
            for(Cliente cliente : clienteEncontrado){
                System.out.println("Nombre: " + cliente.getName());
                System.out.println("Cedula: " + cliente.getIdNumber());
                System.out.println("Fecha de Creación: " + cliente.getCreationDate());
                System.out.println("Nivel de Ingresos: " + cliente.getIncomeLevel());
                System.out.println("Ahorros hasta ahora: " + cliente.getSavings());

            }}
        else {System.out.println("No se ha encontrado cliente: " + busqueda);}

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
            
    }

    static ArrayList<Cliente> searchInClass(ArrayList<Cliente> clientes, int ceduCli){
        ArrayList<Cliente> ClientesDB = new ArrayList<>();
        for(Cliente cliente : clientes) {
            if(cliente.getIdNumber() == (ceduCli)){
                ClientesDB.add(cliente);

            }
        }
        return ClientesDB;

    }


    static void listClients(ArrayList<Cliente> clientes){
        int counter = 1;
        System.out.println("--------------------------------------------");    
        System.out.println("      Haz seleccionado listar clientes");
        System.out.println("--------------------------------------------");
        System.out.println("Los clientes son:");
        for(Cliente cliente : clientes){
            System.out.println("Cliente #" + counter);
            System.out.println("Nombre: " + cliente.getName()); 
            counter += 1;           
        }

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();

    }


    static void requestLoan() {
        int deuda = 0;

        System.out.println("--------------------------------------------");    
        System.out.println("      Haz seleccionado pedir un prestamo");
        System.out.println("--------------------------------------------");

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
    
        System.out.println("Clientes registrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getName());
        }

        System.out.println("--------------------------------------------\n"); 
        System.out.print("Seleccione el número del cliente: ");
        int clienteIndex = scanner.nextInt();

        if (clienteIndex < 1 || clienteIndex > clientes.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Cliente clienteSeleccionado = clientes.get(clienteIndex - 1);

        System.out.print("\nEl nombre del cliente es: " + clienteSeleccionado.getName());
        System.out.println("\nEl saldo de su cuenta de ahorros es $" + clienteSeleccionado.getSavings());
        System.out.print("Ingrese el valor del prestamo: ");
        int amount = scanner.nextInt();

        if(amount <= clienteSeleccionado.getSavings()){
            clienteSeleccionado.removeSavings(amount);
            System.out.println("\nEl saldo restante de su cuenta de ahorros es $" + clienteSeleccionado.getSavings());
        }
        else if(amount <= (2 * clienteSeleccionado.getSavings()) && amount > 0){
            deuda = amount - clienteSeleccionado.getSavings();
            double monto=(Math.pow(1.0 + 0.2/100,0.5)*deuda)/6;
            amount = clienteSeleccionado.getSavings();
            System.out.println("\nEl valor en cuotas es: $" + monto);
            clienteSeleccionado.removeSavings(amount);
        }else{
            System.out.print("Valor invalido o salió del menú");
        } 
        
        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
            
    }
    

    static void requestCDT() {
        double monto = 0;
        int amount = 0;

        System.out.println("--------------------------------------------");    
        System.out.println("      Haz seleccionado hacer un CDT");
        System.out.println("--------------------------------------------");

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
    
        System.out.println("Clientes registrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getName());
        }

        System.out.println("--------------------------------------------\n"); 
        System.out.print("Seleccione el número del cliente: ");
        int clienteIndex = scanner.nextInt();

        if (clienteIndex < 1 || clienteIndex > clientes.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Cliente clienteSeleccionado = clientes.get(clienteIndex - 1);

        System.out.print("\nEl nombre del cliente es: " + clienteSeleccionado.getName());
        System.out.println("\nEl saldo de su cuenta de ahorros es $" + clienteSeleccionado.getSavings());
        System.out.println("Digite 3 o 6 dependiendo del plazo: ");
        int optionSelect = scanner.nextInt();

        if(optionSelect == 6){
            amount = clienteSeleccionado.getSavings();
            monto =  amount * 0.05 * 0.4931506849;
            System.out.println("\nEl total de dinero ganado pasados 6 meses es de $" + monto);
        }
        else if(optionSelect == 3){
            monto = clienteSeleccionado.getSavings() * 0.03 * 0.2465753425;
            System.out.println("\nEl total de dinero ganado pasados 3 meses es de $" + monto);
        }else{
            System.out.print("Valor invalido o salió del menú");
        } 

        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
        
    }

}

