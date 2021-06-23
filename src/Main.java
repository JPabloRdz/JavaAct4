import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Escribe el nombre del archivo");

        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        AddressBook agenda = new AddressBook(fileName);

        String telefono, nombre;
        String seleccionDelUsuario = "";
        while (!seleccionDelUsuario.equals("5")) {
            System.out.println("Selecciona una opcion");
            System.out.println("1 - listar");
            System.out.println("2 - crear");
            System.out.println("3 - borrar");
            System.out.println("4 - salvar al archivo");
            System.out.println("5 - Terminar el programa");

            seleccionDelUsuario = sc.nextLine();

            switch(seleccionDelUsuario){
                case "1":
                    agenda.list();
                    break;
                case "2":
                    System.out.println("Dame el telefono");
                    telefono = sc.nextLine();
                    System.out.println("Dame el nombre");
                    nombre = sc.nextLine();

                    agenda.create(telefono, nombre);
                    break;
                case "3":
                    System.out.println("Dame el telefono");
                    telefono = sc.nextLine();

                    agenda.delete(telefono);
                    break;
                case "4":
                    agenda.save();
                    System.out.println("El archivo fue salvado");
                    break;
                case "5":
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Valor incorrecto");
            }
        }
    }
}
