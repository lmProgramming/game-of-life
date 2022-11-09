import java.util.Objects;
import java.util.Scanner;

// Mikołaj Kubś, Jan Maciuk, Michał Maksanty
public class Main
{
    public static void main(String[] args){
        int m = 10;
        int n = 20;

        double prawdopodobienstwo = 0.3;

        Siatka grid = new Siatka(m, n);
        grid.WypelnijLosowo(prawdopodobienstwo);

        String zywy = "A";
        String martwy = " ";

        String rozlacznik = ",";

        Scanner s = new Scanner(System.in);

        String x = "";
        while (!Objects.equals(x, "n")){
            System.out.println("\n");

            grid.Krok();

            grid.DrukujWKonsoli(zywy, martwy, rozlacznik);

            x = s.nextLine();
        }
    }
}
