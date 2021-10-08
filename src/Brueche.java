public class Brueche {
    //code von https://www.java-forum.org/thema/bruch-kuerzen.114985/d
    private double zaehler, nenner;

    public Brueche(double z, double n)
    {
        zaehler = z;
        nenner = n;
    }

    public void kuerzen()
    {
        double zA = zaehler, zB = nenner;

        do
        {
            while (zB < zA)
            {
                zA = zA - zB;
            }
            while (zB > zA)
            {
                zB = zB - zA;
            }
        }

        while (zB == zA);

        zaehler = zaehler / zA;
        nenner = nenner / zB;
        System.out.println(zA);
        System.out.println(zB);
    }

    public double getZaehler()
    {
        return zaehler;
    }

    public double getNenner()
    {
        return nenner;
    }

    public void ggt(double za, double zb)
    {
        double zA = zaehler;
        double zB = nenner;
        zA = za;
        zB = zb;



        while (zA != zB)
        {
            while (zA > zB)
            {
                zA = zA - zB;
            }
            while (zB > zA)
            {
                zB = zB - zA;
            }
        }
    }
}
