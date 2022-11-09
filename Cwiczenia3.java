import java.util.Objects;
import java.util.Scanner;

public class Cwiczenia3
{
    public static void main(String[] args){
        Grid grid = new Grid(10, 10);
        grid.WypelnijLosowo(0.3);

        String alive = "A";
        String dead = " ";

        Scanner s = new Scanner(System.in);

        String x = "";
        while (!Objects.equals(x, "n")){
            System.out.println("\n");

            grid.Krok();

            grid.DisplayInConsole(alive, dead, ",");

            x = s.nextLine();
        }
    }
}
