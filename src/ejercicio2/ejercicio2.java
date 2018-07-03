package ejercicio2;
import javax.swing.JOptionPane;
public class ejercicio2 {    
    public static void main(String[] args) {
       
    int cantAl, edAl, sumEd,edMax, edMin, sumPar, cantPar, cont;
        double promEdPar, promEd;
        
        sumEd = 0;
        edMax = 0;
        edMin = 999;
        sumPar = 0;
        cantPar = 0;
        cont = 0;
        
        cantAl = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de alumnos(numero mayor de cero)"));
        
        while (cont < cantAl) {
            
            edAl = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad de alumno"));
            
            if (edAl>0) {
                
                sumEd += edAl;

                if (edAl > edMax) {
                    edMax = edAl;
                }

                if (edAl < edMin) {
                    edMin = edAl;
                }

                if (0 == (edAl % 2)) {
                    sumPar += edAl;
                    cantPar++;
                }
                
                cont++;
                
            } else {
                JOptionPane.showMessageDialog(null,"Ingrese una edad válida");
            }
 
        }
        
        promEd = (sumEd/cantAl);
        promEdPar = (sumPar/cantPar);
        
        JOptionPane.showMessageDialog(null, "Suma de todas las edades: "+sumEd+"\n"+"Promedio de todas las edaddes: "+promEd+"\n"+"Promedio de edaddes pares: "+promEdPar+"\n"+"Edad Maxima: "+edMax+"\n"+"Edad minima: "+edMin);
        
        
        
        
        
        
       }
    
    }