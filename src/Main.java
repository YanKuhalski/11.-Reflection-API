import it.academy.basic.classes.FillObj;
import it.academy.basic.classes.Patient;
import it.academy.basic.classes.Product;
import it.academy.basic.classes.Reflector;
import it.academy.basic.exeptions.ObjExeption;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            Class<Patient> clazzPatient = Patient.class;
            Reflector<Patient> patientReflector = new Reflector<>();
            Patient patient = patientReflector.make(clazzPatient);
            FillObj<Patient> patientFill = new FillObj<>(patient, clazzPatient);
            patientFill.fillObj();
            System.out.println(patient);

            Class<Product> clazzProduct = Product.class;
            Reflector<Product> productReflector = new Reflector<>();
            Product product = productReflector.make(clazzProduct);
            FillObj<Product> productFill = new FillObj<>(product, clazzProduct);
            productFill.fillObj();
            System.out.println(product);
        } catch (ObjExeption | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            System.out.println(ex.toString());
        }
    }
}
