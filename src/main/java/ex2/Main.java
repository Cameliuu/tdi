package ex2;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
   private static ObjectMapper objectMapper = new ObjectMapper();
    private static File jsonFile = new File("perechenumere.json");
    static void scriere(List< PerecheNumere > lista)
    {


            try {
                objectMapper.writeValue(jsonFile, lista);
            }
            catch(Exception e)
            {
                System.out.println("asea");
            }

    }
    static List<PerecheNumere> citire()
    {
        List<PerecheNumere> lista = new ArrayList<PerecheNumere>();

        try
        {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<PerecheNumere> p = Arrays.asList(objectMapper.readValue(jsonFile,PerecheNumere[].class));
            return p;
        }
        catch(Exception e )
        {
            System.out.println(e);
        }
        return lista;
    }
    public static void main(String[] args) {
        List<PerecheNumere> lista = Arrays.asList(new PerecheNumere(1,2),new PerecheNumere(3,4), new PerecheNumere(40,2));
        scriere(lista);
      for(PerecheNumere p : citire())
        {
            System.out.println("**********************************************");
            System.out.println(p.toString());
            System.out.println("Numerele sunt vecine fibonacci: "+p.Fibonacci());
            System.out.println("Suma cifrelor este egala: "+p.DigitsSumEqual());
            System.out.println("Numarul de cifre pare este egal: "+p.Fibonacci());
            System.out.println("Cel mai mic numitor comun este: " + p.cmmc()    );
        }
    }
}
