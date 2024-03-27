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
    static int savings = 0; 

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
                        registerClient();
                        break;
                    case 2: 
                        insertMoney();
                        break;
                    case 3: 
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
      
        System.out.println("--------------------------------------------");
        System.out.println("     Haz seleccionado Registrar Cliente");
        System.out.println("--------------------------------------------");
        System.out.println("Ingrese sus datos por favor...\n");
        c.setNombre();
        c.setCedula();
        c.setNivelIngresos();
        c.setFechaCreacion();
        clientes.add(c);
    }


    static void insertMoney() {
        int money;
        System.out.println("--------------------------------------------");    
        System.out.println("      Haz seleccionado insertar dinero");
        System.out.println("--------------------------------------------");    
        System.out.print("Cuanto desea ingresar?: ");
        money = scanner.nextInt();
        savings += money;
        System.out.println("\nEl dinero se ingreso correctamente");
        System.out.println("El saldo de su cuenta de ahorros es $" + savings);
        System.out.println("------------------------------------------\n"); 
    }

    static void updateMoney() {

        System.out.println("--------------------------------------------");    
        System.out.println("   Haz seleccionado actualizar dinero");
        System.out.println("--------------------------------------------");
        System.out.println("El saldo de su cuenta de ahorros es $" + savings);
        System.out.print("Ingrese el valor a actualizar: ");
        savings = scanner.nextInt();
        System.out.println("\nEl dinero se actualizo correctamente");
        System.out.println("El saldo de su cuenta ahora es $" + savings);
        System.out.println("------------------------------------------\n"); 

    }
    
    static void deleteMoney() {
        int delete = 0;
        System.out.println("--------------------------------------------");    
        System.out.println("      Haz seleccionado eliminar dinero");
        System.out.println("--------------------------------------------");
        System.out.println("El saldo de su cuenta de ahorros es $" + savings);
        System.out.print("Ingrese el valor a eliminar de la cuenta: ");
        delete = scanner.nextInt();
        savings -= delete;
        System.out.println("\nEl dinero se actualizo correctamente");
        System.out.println("El saldo de su cuenta ahora es $" + savings);
        System.out.println("------------------------------------------\n"); 
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
