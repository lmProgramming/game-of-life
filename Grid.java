import java.util.Random;

public class Grid {
    boolean[][] siatka;
    int n;
    int m;

    public Grid(int n,int m){
        siatka = new boolean[n][m];

        this.n = n;
        this.m = m;
    }

    public void WypelnijLosowo(double probability){
        Random rand = new Random();

        for (int x = 0; x < n; x++)
        {
            for (int y = 0; y < m; y++)
            {
                siatka[x][y] = rand.nextDouble(1) <= probability;
            }
        }
    }

    public void Krok(){
        boolean[][] nowaSiatka = new boolean[n][m];

        for (int x = 0; x < n; x++)
        {
            for (int y = 0; y < m; y++)
            {
                int[][] sasiedzi = Sasiedzi(x, y);
                int liczbaSasiadow = 0;
                for (int[] sasiadVector : sasiedzi) {
                    liczbaSasiadow += siatka[sasiadVector[0]][sasiadVector[1]] ? 1 : 0;
                    //2/3
                    //3
                }
                if (liczbaSasiadow == 2 && siatka[x][y]){
                    nowaSiatka[x][y] = true;
                }
                else{
                    nowaSiatka[x][y] = liczbaSasiadow == 3;
                }

                //siatka[x][y] = rand.nextDouble(1) <= probability;
            }
        }

        siatka = nowaSiatka;
    }

    public int[][] Sasiedzi(int x, int y)
    {
        int[][] sasiedzi = new int[8][2];

        int index = 0;
        for (int xb = -1; xb <= 1; xb++){
            for (int yb = -1; yb <= 1; yb++){
                if (xb != 0 || yb != 0)
                {
                    int xInd = (x + xb) % n;
                    if (xInd < 0){
                        xInd += n;
                    }
                    int yInd = (y + yb) % m;
                    if (yInd < 0){
                        yInd += m;
                    }
                    sasiedzi[index] = new int[] { xInd, yInd };
                    index++;
                }
            }
        }

        return sasiedzi;
    }

    public void DisplayInConsole(String alive, String dead, String separator)
    {
        for (int x = 0; x < n; x++)
        {
            StringBuilder s = new StringBuilder();
            for (int y = 0; y < m; y++)
            {
                s.append(siatka[x][y] ? alive : dead).append(separator);
            }

            System.out.println(s);
        }
    }
}
