package ruleta;

import java.util.Scanner;
import java.lang.Math;
import ruleta.src.consoleColors;

public class Ruleta {

    public static void main(String[] arguments) {
        String apuesta = "";
        int payout = 0;
        int bolita = 0;
        int casilla = -1;
        String retry = "si";
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("¿Cual es tu apuesta?");
            System.out.println(
                    "Inserte " + consoleColors.RED + "rojo" + consoleColors.RESET + "," + consoleColors.BLACK + "negro"
                            + consoleColors.RESET + " o " + consoleColors.GREEN + "numero" + consoleColors.RESET + ".");
            do {
                apuesta = System.console().readLine();
                if (!apuesta.equals("rojo") && !apuesta.equals("negro") && !apuesta.equals("numero")) {
                    System.out.println("Que digas " + consoleColors.RED + "rojo" + consoleColors.RESET + ", "
                            + consoleColors.BLACK + "negro" + consoleColors.RESET + " o " + consoleColors.GREEN
                            + "numero" + consoleColors.RESET);
                }

            } while (!apuesta.equals("rojo") && !apuesta.equals("negro") && !apuesta.equals("numero"));

            if (apuesta.equals("numero")) {
                do {
                    System.out.println("¿Cual es tu " + consoleColors.GREEN + "numero" + consoleColors.RESET + ", "
                            + consoleColors.PURPLE + "master" + consoleColors.RESET + "?(0-36)");
                    casilla = Integer.parseInt(System.console().readLine());
                } while (casilla > 36 || casilla < 0);
            }
            System.out.println("¿Cuánto dinero apuestas?");
            Float dinerin = Float.parseFloat(System.console().readLine());
            do {
                bolita = (int) (Math.random() * 100);
            } while (bolita > 36);
            System.out.println("La bolita ha caido en el " + bolita + ".");

            switch (apuesta) {
                case "rojo":
                    payout = 2;
                    if (bolita % 2 == 0 && bolita != 0) {
                        System.out.println("Ha tocado " + consoleColors.RED + "rojo" + consoleColors.RESET
                                + ", enhorabuena tu " + consoleColors.YELLOW_BACKGROUND_BRIGHT + "premio"
                                + consoleColors.RESET + " es de " + payout * dinerin + "$.");
                    } else
                        System.out.println("jajaja perdiste");
                    break;

                case "negro":
                    payout = 2;
                    if (bolita % 2 == 1) {
                        System.out.println("Ha tocado " + consoleColors.BLACK + "negro" + consoleColors.RESET
                                + ", enhorabuena tu premio es de " + payout * dinerin + " $.");
                    } else
                        System.out.println("jajaja perdiste");
                    break;

                case "numero":
                    payout = 36;
                    if (bolita == casilla) {
                        System.out.println("Enhorabuena, ha tocado su " + consoleColors.GREEN + "numero"
                                + consoleColors.RESET + " suertudo, su premio es de "
                                + payout * dinerin + " $.");
                    } else
                        System.out.println("Jajaja perdiste " + ".");
                    break;

                default:
                    System.out.println(consoleColors.PURPLE_BACKGROUND_BRIGHT
                            + "Hubo un error con la apuesta. No se que ha pasao máquina" + consoleColors.RESET);
                    break;
            }
            System.out.println("\n---------------------------------------------------");
            System.out.println("!Quieres reintentar? si/no");
            retry = System.console().readLine();
        } while (retry.equals("si"));
        s.close();
    }
}
