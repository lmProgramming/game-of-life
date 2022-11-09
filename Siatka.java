import java.util.Random;

public class Siatka {
    boolean[][] siatka;
    int m;
    int n;

    public Siatka(int m, int n){
        siatka = new boolean[m][n];

        this.m = m;
        this.n = n;
    }

    public void WypelnijLosowo(double prawdopodobienstwo){
        Random rand = new Random();

        for (int x = 0; x < m; x++)
        {
            for (int y = 0; y < n; y++)
            {
                siatka[x][y] = rand.nextDouble(1) <= prawdopodobienstwo;
            }
        }
    }

    public void Krok(){
        boolean[][] nowaSiatka = new boolean[m][n];

        for (int x = 0; x < m; x++)
        {
            for (int y = 0; y < n; y++)
            {
                int[][] sasiedzi = Sasiedzi(x, y);
                int liczbaSasiadow = 0;
                for (int[] sasiadVector : sasiedzi) {
                    liczbaSasiadow += siatka[sasiadVector[0]][sasiadVector[1]] ? 1 : 0;
                }
                if (liczbaSasiadow == 2 && siatka[x][y]){
                    nowaSiatka[x][y] = true;
                }
                else{
                    nowaSiatka[x][y] = liczbaSasiadow == 3;
                }
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
                    int xInd = (x + xb) % m;
                    if (xInd < 0){
                        xInd += m;
                    }
                    int yInd = (y + yb) % n;
                    if (yInd < 0){
                        yInd += n;
                    }
                    sasiedzi[index] = new int[] { xInd, yInd };
                    index++;
                }
            }
        }

        return sasiedzi;
    }

    public void DrukujWKonsoli(String zywy, String zmarly, String rozlacznik)
    {
        for (int x = 0; x < m; x++)
        {
            StringBuilder s = new StringBuilder();
            for (int y = 0; y < n; y++)
            {
                s.append(siatka[x][y] ? zywy : zmarly).append(rozlacznik);
            }

            System.out.println(s);
        }
    }
}
