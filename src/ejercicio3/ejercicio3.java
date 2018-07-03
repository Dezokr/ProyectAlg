package ejercicio3;
import javax.swing.JOptionPane;
public class ejercicio3 {    
    public static void main(String[] args) {
      int num, cantDig, sumDig, cantDigPar, cantDigImp, newNum, dig;
        
        cantDig = 0;
        sumDig = 0;
        cantDigPar = 0;
        cantDigImp = 0;
        
        num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entero"));
        
        if (num<0) {
            num = -(num);
        }
        
        newNum = num;
        
        while(newNum>0){
            dig = newNum%10;
            cantDig++;
            sumDig+=dig;
            newNum = newNum/10;
   
            if (0==dig%2) {
                cantDigPar++;
            } else {
                cantDigImp++;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Cantidad de digitos: "+cantDig+"\n"+"Suma de Digitos: "+sumDig+"\n"+"Cantidads de Digitos Par: "+cantDigPar+"\n"+"Cantidad de digitos Impar: "+cantDigImp);  
    
    
        
      }
    
    }