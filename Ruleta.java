package ruleta;
import java.util.Scanner;
import java.lang.Math;
public class Ruleta
{
    
    public static void main(String[] arguments)
    {
        String apuesta = "";
        int payout = 0;
        int bolita = 0;
        int casilla = -1;
        String retry = "si";
        Scanner s = new Scanner(System.in);
        
        do
        {
            System.out.println("¿Cual es tu apuesta?");
            System.out.println("Inserte rojo, negro, numero");    
            do
            {
                apuesta = System.console().readLine();
                if(!apuesta.equals("rojo") && !apuesta.equals("negro") && !apuesta.equals("numero"))
                {    
                    System.out.println("Que digas rojo, negro o numero tontito");
                }

            }while(!apuesta.equals("rojo") && !apuesta.equals("negro") && !apuesta.equals("numero"));
            
            if(apuesta.equals("numero"))
            {
                do
                {
                    System.out.println("¿Cual es tu numero master?(0-36)");
                    casilla = s.nextInt();
                }while(casilla >36 || casilla < 0);
            }
            System.out.println("¿Cuánto dinero apuestas?");
            Float dinerin = s.nextFloat();
            do
            {
                bolita = (int) (Math.random() * 100) ;
            }while(bolita > 36);
            System.out.println("La bolita de los cojones ha caido en el " + bolita + ".");

            switch (apuesta) 
            {
                case "rojo":
                    payout = 2;
                    if(bolita % 2 == 0 && bolita != 0)
                        {
                            System.out.println("Ha tocado rojo, enhorabuena tu premio es de " + payout*dinerin + "$.");
                        }
                        else
                            System.out.println("jajaja perdiste");
                        break;

                case "negro":
                    payout = 2;
                        if (bolita %2 == 1)
                        {
                            System.out.println("Ha tocado negro, enhorabuena tu premio es de " + payout*dinerin + " $.");   
                        }
                        else
                            System.out.println("jajaja perdiste");
                    break;
            
                case "numero":
                    payout = 36;
                    if(bolita == casilla)
                    {  
                        System.out.println("Enhorabuena, ha tocado su numero suertudo cabron, su premio es de " + payout*dinerin + " $.");
                    }
                    else
                        System.out.println("Jajaja perdiste gordo mamon");
                        break;
                    
                default:
                    System.out.println("Hubo un error con la apuesta. No se que ha pasao máquina");
                    break;
            }
            System.out.println("\n---------------------------------------------------");
            System.out.println("!Quieres reintentar? si/no");
            retry = System.console().readLine();
        }while(retry.equals("si"));
        s.close();
    }
}
