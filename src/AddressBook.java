import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    public HashMap<String, String> contactos;
    private String fileName;

    public AddressBook(String fileName) {

        contactos = new HashMap<>();
        this.fileName = fileName;
        load();

    }

    public void load() {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String row = myReader.nextLine();			//  0                1
                String[] rowSplited = row.split(","); // ["5583774949", "Aaron"]
                String phone = rowSplited[0];
                String name = rowSplited[1];

                // put (key, value)
                contactos.put(phone, name);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void save() {
        try {
            FileWriter myWriter = new FileWriter(fileName);

            for (Map.Entry<String,String> contacto : contactos.entrySet()) {
                myWriter.write(contacto.getKey() + "," + contacto.getValue() + "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public void list() {
        for (Map.Entry<String,String> contacto : contactos.entrySet() ) {
            System.out.println(
                    "Telefono = " + contacto.getKey() +
                            ", Nombre = " + contacto.getValue());
        }
    }

    public void create(String telefono, String nombre) {
        contactos.put(telefono, nombre);
    }

    public void delete(String telefono) {
        contactos.remove(telefono);
    }

}
