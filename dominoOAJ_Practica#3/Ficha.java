
/**
 * Esta clase crea una ficha con los valores ingresados
 *
 * @JTM 
 * @31/08/23
 */
public class Ficha
{
    // instance variables - replace the example below with your own
        
    private int valorSuperior,valorInferior,girado,original,pasado=0,posX=211,posY=30;
    private Square[] cuadros = new Square[16];
    
    /**
     * Constructor for objects of class Ficha
     */
    public Ficha(int valorSuperior,int valorInferior)
    {
        // initialise instance variables 
       this.valorSuperior=valorSuperior;
       this.valorInferior=valorInferior;
       this.original=1;
       this.girado=0;
       
       //Creamos la base de la ficha con dos cuadros grandes
       for (int i = 0; i < 2; i++) {
           if(i == 0){
               cuadros[i] = new Square(200,102);
           }else{
           cuadros[i] = new Square(200,20);
              }
           cuadros[i].changeColor("black");
           cuadros[i].changeSize(80);
           cuadros[i].makeVisible();  
        }
        
        //hacemos  visible todos los cuadros y cambiamos su size
        for(int i = 2 ; i < 16 ; i++){
            if(i == 2){
            //Creamo el punto central
                cuadros[i] = new Square(233,52);     
                //Cambiamos el valor de y regresamos la posicion x
                }else if(i < 6){
                    cuadros[i] = new Square(posX,posY);
                    posY+=22;
                        if(i == 5){
                            posX = 255;
                            posY = 30;
                        }
                    }else if(i < 9){
                        cuadros[i] = new Square(posX,posY);
                        posY+=22;
                        }else if(i == 9){
                            cuadros[i] = new Square(233,132);
                            posX = 211;
                            posY = 110;
                                }else if( i < 13){
                                    cuadros[i] = new Square(posX,posY);
                                    posY+=22;
                                        if(i==12){
                                            posX=255;
                                            posY=110;
                                        }
                                    }else{
                                        cuadros[i] = new Square(posX,posY);
                                        posY+=22;
                                    }
        }   
        
        //cambiamos el size de todas los cuadros
        for(int i=2 ; i<16 ; i++){
             cuadros[i].changeSize(16);
        }
       
        //dibujamos la parte superior del domino
        mostrarPuntos(valorSuperior,2,8);
        mostrarPuntos(valorInferior,9,15);
        

    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void voltearFicha()
    {
       if(original==0){
           fichaOriginal();
           original=1;
           return;
       }else{
         for(int i=2; i<16;i++){
         cuadros[i].makeInvisible();
            } 
        } 
        original=0;
    }
    
    public void girarFicha(){
        if(girado==1){
        for(int i=0;i < 16;i++){
             if(i==0){
                cuadros[i].moveHorizontal(-84);
                }
                else if(i>8){
                    cuadros[i].moveHorizontal(-84); 
                }
                else{
                    cuadros[i].moveVertical(-82);    
                }
             girado=0;
            }    
        }else{
        for(int i=0;i < 16;i++){
             if(i==0){
                cuadros[i].moveHorizontal(84);
                }
                else if(i>8){
                    cuadros[i].moveHorizontal(84); 
                }
                else{
                    cuadros[i].moveVertical(82);    
                }
                girado = 1;
              }
           }
        }
    
        public void moveLeftFicha(int valor){
      for(int i=0;i < 16;i++){
             if(i==0){
                cuadros[i].moveHorizontal(-valor);
                }
                else if(i>8){
                    cuadros[i].moveHorizontal(-valor); 
                }
                else{
                    cuadros[i].moveHorizontal(-valor);    
                }
            }      
    }
        
    public void moveRightFicha(int valor){
      for(int i=0;i < 16;i++){
             if(i==0){
                cuadros[i].moveHorizontal(valor);
                }
                else if(i>8){
                    cuadros[i].moveHorizontal(valor); 
                }
                else{
                    cuadros[i].moveHorizontal(valor);    
                }
            }      
    }
    
    public void moveDownFicha(int valor){
      for(int i=0;i < 16;i++){
             if(i==0){
                cuadros[i].moveVertical(valor);
                }
                else if(i>8){
                    cuadros[i].moveVertical(valor); 
                }
                else{
                    cuadros[i].moveVertical(valor);    
                }
            }      
    }
    
    public void moveUpFicha(int valor){
      for(int i=0;i < 16;i++){
             if(i==0){
                cuadros[i].moveVertical(-valor);
                }
                else if(i>8){
                    cuadros[i].moveVertical(-valor); 
                }
                else{
                    cuadros[i].moveVertical(-valor);    
                }
            }      
    }
    
    private void fichaOriginal(){
        for(int i=2; i<16;i++){
            cuadros[i].makeInvisible();
        }
        mostrarPuntos(valorSuperior,2,8);
        mostrarPuntos(valorInferior,9,15);
    }
    
    public void fichaEnConsola() {
        System.out.println(" ------- ");
        System.out.println("|       |");
        System.out.println("|   " + valorSuperior + "   |");
        System.out.println("|       |");
        System.out.println(" ------- ");
        System.out.println("|       |");
        System.out.println("|   " + valorInferior + "   |");
        System.out.println("|       |");
        System.out.println(" ------- ");
    }
    
    private void mostrarPuntos(int valor, int inicio, int fin) {
    switch(valor) {
        case 0:
            break;
            
        case 1:
            cuadros[inicio].makeVisible();
            cuadros[inicio].changeColor("white");
            break;
            
        case 2:
            cuadros[inicio+1].makeVisible();
            cuadros[inicio+1].changeColor("azul electrico destroza vistas");
            cuadros[fin].makeVisible();
            cuadros[fin].changeColor("azul electrico destroza vistas");
            break;
            
        case 3:
            cuadros[inicio].makeVisible();
            cuadros[inicio].changeColor("red");
            cuadros[inicio + 1].makeVisible();
            cuadros[inicio + 1].changeColor("red");
            cuadros[fin].makeVisible();
            cuadros[fin].changeColor("red");
            break;
            
        case 4:
            for (int i = inicio; i <= fin; i++) {
                if (i != inicio && i != fin - 1 && i != (inicio+2)) {
                    cuadros[i].makeVisible();
                    cuadros[i].changeColor("cafe chocolate Abuelita");
                }
            }
            break;
            
        case 5:
            for (int i = inicio; i <= fin; i++) {
                if (i != inicio + 2 && i != fin - 1) {
                    cuadros[i].makeVisible();
                    cuadros[i].changeColor("verde bebe recien nacido");
                }
            }
            break;
            
        case 6:
            for (int i = inicio + 1; i <= fin; i++) {
                cuadros[i].makeVisible();
                cuadros[i].changeColor("magenta");
            }
            break;
            
        case 7:
            for (int i = inicio; i <= fin; i++) {
                    cuadros[i].makeVisible();
                    cuadros[i].changeColor("orange");
                }
            break;
    }
}

}
