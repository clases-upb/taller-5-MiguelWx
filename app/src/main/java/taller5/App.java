/*
 * This source file was generated by the Gradle 'init' task
 */
package taller5;

public class App {
    
   public static void main(String[] args) {
    try {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un número entre 1000 y 9999 para adivinar: ");
        int numeroUsuario = scanner.nextInt();
        System.out.println(adivinarNumero(numeroUsuario));
        
        System.out.println(Simular_ventas());
        
        System.out.println(Calcular_empaque(3464));

        System.out.println(Jugar_21(4));


    } catch (Exception e) {
        // TODO: handle exception
    }
}
   /*
    
        1.	Desarrolle un algoritmo e impleméntelo en Java que: le pida al usuario un número entero positivo 
        entre 1000 y 9999. En un ciclo genere números de manera aleatoria y cuente los intentos que hizo antes 
        de hallar el número exactamente.
        
    
    */ 
    public static String adivinarNumero(int numeroUsuario) {
        int numeroAleatorio;
        int intentos = 0;

        do {
            numeroAleatorio = (int)(Math.random() * 9000) + 1000;
            intentos++;
        } while (numeroAleatorio != numeroUsuario);

        return "Numero encontrado, el numero era: " + numeroUsuario + "\nNúmero de intentos: " + intentos;
    }



    /* 
     
        2.	Se requiere una función en java que simule las ventas de tres años para un almacén. Para cada año, deberá generar 
        un aleatorio para cada mes hasta completar los 12 meses. La función se llamará Simular_ventas, y debe retornar un String 
        al final que muestre las ventas de cada año, así:
        
            Año 1
            Ventas Mes 1: $##.###.###
            :
            Ventas Mes 12: $##.###.###
            Total ventas Año 1:  $##.###.###
            
            Año 2
            Ventas Mes 1: $##.###.###
            :
            Ventas Mes 12: $##.###.###
            Total ventas Año 2: $##.###.###
            
            Año 3
            Ventas Mes 1: $##.###.###
            :
            Ventas Mes 12: $##.###.###

            Total ventas Año 3: $##.###.###
            
            Investigue sobre la clase DecimalFormat para mostrar bien la salida. 
            import java.text.DecimalFormat;
            DecimalFormat form_pesos = new DecimalFormat("$#,###.00");

        
      
    */
    public static String Simular_ventas() {
        DecimalFormat form_pesos = new DecimalFormat("$#,###.00");
        String resultado = "";

        for (int año = 1; año <= 3; año++) {
            int totalAño = 0;
            resultado += "Año " + año + "\n";

            for (int mes = 1; mes <= 12; mes++) {
                int ventasMes = (int)(Math.random() * 1000000) + 50000;
                totalAño += ventasMes;
                resultado += "Ventas Mes " + mes + ": " + form_pesos.format(ventasMes) + "\n";
            }

            resultado += "Total ventas Año " + año + ": " + form_pesos.format(totalAño) + "\n\n";
        }

        return resultado;
    }
    



    /*  
     
        3.	En una fábrica se tiene el siguiente patrón de empaque: En una estiba(o pallet) caben 16  cajas y en cada caja, 
        caben 30 bombillas. Desarrolle una función que se llame: Calcular_empaque que: reciba como argumento la cantidad de 
        bombillas que se deben empacar y a partir de allí: calcule cuántas cajas necesita, cuántas estibas o pallets necesita. 
        Luego escriba lo siguiente: 

        Para ### bombillas, se necesitan ## cajas y ## pallets. Se quedan ### bombillas sin empacar. Se empacará así:

        Pallet 1 --> Caja1, Caja2……,Caja16
        Pallet2 -->  Caja17, Caja18…..Caja 32
        .
        Pallet n -- > Caja m, caja m+1…..
        
        La función retornará un texto, con la información anterior. Pruebe la función llamándola desde el programa principal: solicite al usuario el número de bombillas e invoque la función para imprimir en el main, los resultados.



    */

    public static String Calcular_empaque(int bombillas) {
        int bombillasPorCaja = 30;
        int cajasPorPallet = 16;

        int cajasNecesarias = bombillas / bombillasPorCaja;
        int bombillasRestantes = bombillas % bombillasPorCaja;
        int palletsNecesarios = cajasNecesarias / cajasPorPallet;
        int cajasRestantes = cajasNecesarias % cajasPorPallet;

        String resultado = "Para " + bombillas + " bombillas, se necesitan " + cajasNecesarias + " cajas y " + palletsNecesarios + " pallets.\n";
        resultado += "Se quedan " + bombillasRestantes + " bombillas sin empacar. Se empacará así:\n\n";

        int cajaActual = 1;
        for (int pallet = 1; pallet <= palletsNecesarios; pallet++) {
            resultado += "Pallet " + pallet + " --> ";
            for (int i = 0; i < cajasPorPallet; i++) {
                resultado += "Caja" + cajaActual + (i < cajasPorPallet - 1 ? ", " : "");
                cajaActual++;
            }
            resultado += "\n";
        }

        if (cajasRestantes > 0) {
            resultado += "Pallet " + (palletsNecesarios + 1) + " --> ";
            for (int i = 0; i < cajasRestantes; i++) {
                resultado += "Caja" + cajaActual + (i < cajasRestantes - 1 ? ", " : "");
                cajaActual++;
            }
            resultado += "\n";
        }

        return resultado;
    }

    

    /* 
    

        4.	En un juego, cada jugador tiene 3 intentos para sacar cartas de una baraja. Las cartas van numeradas entre 1 y 10. 
        Una función Jugar_21, deberá simular el juego para una cantidad de usuarios que enviará el usuario desde el main entre 1 y 6.

        Para cada uno de los jugadores, el programa le calculará 3 cartas al azar y al final imprimirá el juego para cada jugador basado en las siguientes reglas: 
        
        Si saca 21 exactos: juego perfecto
        Si saca más de 21: se pasó
        Si saca menos de 21: faltaron puntos

        La función deberá imprimir los puntos de cada jugador junto con la regla anterior, como muestra el ejemplo:

        Jugador X, puntos 21 -- > juego perfecto
        Jugador Y, puntos 26 -- > se pasó
        .
        .


    */
      public static String Jugar_21(int Jugadores){
 
        try {
            String TxTReturn = "";
            int CartaAle = 0;
            short MaxCartas = 3;
            short Num21 = 21;
           
            if(Jugadores < 1 || Jugadores > 6){
            TxTReturn += "Numero de jugadores no valido \n";        
        }
            else{
 
                for(short i=1;  i<= Jugadores; i++){
                   int cantcartas = 0;
                    for(short w=1; MaxCartas >= w; w++){
                        CartaAle = (int)(1+(10*Math.random()));
                        cantcartas += CartaAle;
 
                    }
                    if(cantcartas < Num21)
                        TxTReturn += "El jugador #" + i + " le fantan puntos: "+ cantcartas + "\n";
                    else if(cantcartas == Num21)
                        TxTReturn += "El jugador #" + i + " tuvo juego perfecto: "+ cantcartas + "\n";
                    else if(cantcartas > Num21)
                        TxTReturn += "El jugador #" + i + " se paso: "+ cantcartas + "\n";
 
                   
                }
               
            }
                return TxTReturn;
        } catch (Exception e) {
            return "Hubo un error"+ e.toString();
           
        } 
    }



}
