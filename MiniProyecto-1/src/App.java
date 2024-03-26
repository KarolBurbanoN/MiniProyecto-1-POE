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
            System.out.println("Bienvenido");
            System.out.println("Que desea hacer?");
            System.out.println("1. Registrar Cliente\r\n" + //
                            "2. Insertar dinero ahorrado\r\n" + //
                            "3. Actualizar dinero ahorrado\r\n" + //
                            "4. Eliminar dinero ahorrado\r\n" + //
                            "5. Buscar cliente por nombre y ver su ahorro\r\n" + //
                            "6. Listar todos los clientes\r\n" + //
                            "7.- Solicitar préstamo\r\n" + //
                            "8.- Solicitar CDT\r\n" + //   
                            "9. Salir\r");        
            System.out.print("Seleccione una opcion: ");
            opcionByte = scanner.nextByte();
            
                switch(opcionByte){
                    case 1:
                        System.out.println("\nHaz seleccionado Registrar Cliente ahorrado.\n");
                        registerClient();
                        break;
                    case 2: 
                        System.out.println("\nHaz seleccionado insertar dinero ahorrado.\n");
                        insertMoney();
                        break;
                    case 3: 
                        System.out.println("\nHaz seleccionado actualizar dinero ahorrado.");
                        updateMoney();
                        break;
                    case 4: 
                        System.out.println("\nHaz seleccionado eliminar dinero ahorrado.");  
                        deleteMoney();
                        break;
                    case 5: 
                        System.out.println("\nHaz seleccionado buscar cliente por nombre y ver su ahorro.");  
                        searchClients();
                        break;
                    case 6:
                        System.out.println("\nHaz seleccionado listar todos los clientes.");  
                        listClients();
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
        }while(opcionByte!=6);     
    }

    static void registerClient() {
        System.out.println("------BIENVENIDO-------");
        System.out.println("Ingrese sus datos por favor...");
        c.setNombre();
        c.setCedula();
        c.setNivelIngresos();
        c.setFechaCreacion();
        clientes.add(c);
    }


    static void insertMoney() {
        
    }

    static void updateMoney() {
        
    }
    
    static void deleteMoney() {
            
    }
    
    static void searchClients() {
            
    }
    
    static void listClients() {
            
    }

    static void requestLoan() {
            
    }
    
    static void requestCDT() {
            
    }

}
