package arboles_n_arios;

import javax.swing.JOptionPane;

public class Arboles_N_arios {
 
    private static Arbol N = new Arbol();

    public static void main(String[] args) {
        mainMenu();
    }
    
    //Método para el menú principal
    public static void mainMenu(){      
        String menu = "***MENÚ ÁRBOLES N***"
                + "\n\n 1- Mostrar árbol\n 2- Insertar\n 3- Eliminar\n 4- Raiz\n 5- Buscar dato"
                + "\n 6- Mostrar raices\n 7- Contar hojas\n 8- Mostrar hojas\n 9- Grado del árbol\n10- Grado de dato"
                + "\n11- Hijos de dato\n12- Mostrar nivel\n13- Mostrar altura\n14- Padre de dato\n15- Borrar árbol"
                + "\n 0- Salir\n\n(Ingrese una opción)";
        int option = -1;
        do
        {
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(option)
                {
                    case 1: //Mostrar árbol
                        if(N.getRaiz()== null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            int tree = 0;
                            JOptionPane.showMessageDialog(null, N.mostrarArbol(N.getRaiz(), tree));
                        }
                        break;

                    case 2: //Insertar
                        insertMenu();
                        break;

                    case 3:  //Eliminar
                        eraseMenu();
                        JOptionPane.showMessageDialog(null,"Dato eliminado");
                        break;

                    case 4: //Mostrar raíz
                        if(N.getRaiz() == null){
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        }else{
                            JOptionPane.showMessageDialog(null, "La raiz del árbol es: " + N.getRaiz().getDato());
                        }
                        break;
                    
                    case 5: //Buscar dato
                        if(N.getRaiz() == null){
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        }else{
                            searchDataMenu();
                        }
                        break;

                    case 6: //Mostrar raices
                        if(N.getRaiz() == null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            String answer = ""; 
                            JOptionPane.showMessageDialog(null, "Las raices del árbol son: " + N.mostrarRaiz(N.getRaiz(), answer));
                        }
                        break;

                    case 7: //Contar hojas
                        if(N.getRaiz() == null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            int leafs = 0;
                            JOptionPane.showMessageDialog(null, "Las hojas del árbol son: " + N.contarHojas(N.getRaiz(), leafs));
                        }
                        break;

                    case 8: //Mostrar hojas
                        if(N.getRaiz() == null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            String answer = "";
                            JOptionPane.showMessageDialog(null, "Las hojas del árbol son: " + N.mostrarHojas(N.getRaiz(), answer));
                        }
                        break;
                    
                    case 9: //Grado del árbol
                        if(N.getRaiz() == null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            int grade = 0;
                            JOptionPane.showMessageDialog(null, "El árbol es de grado : " + N.mostrarGradoArbol(N.getRaiz(), grade));
                        }
                        break;

                    case 10: //Grado de un dato
                        if(N.getRaiz() == null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            gradeDataMenu();
                        }
                        break;

                    case 11: //Muestra los hijos de un dato dado
                        if(N.getRaiz() == null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            dataSonsMenu();
                        }
                        break;

                    case 12: //Muestra el nivel de un dato
                        if(N.getRaiz() == null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            showLevelMenu();
                        }
                        break;
                    
                    case 13: //Muestra la altura del árbol
                        if(N.getRaiz() == null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            if(N.getRaiz() != null){
                                JOptionPane.showMessageDialog(null, "El árbol es de altura : " + N.mostrarAltura(N.getRaiz(), 1, 1));
                            }                         
                        }
                        break;

                    case 14: //Muestra el padre de un dato dado
                        if(N.getRaiz() == null)
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        else{
                            fatherDataMenu();
                        }
                        break;
                        
                    case 15: N.Limpiar();
                        break;

                    case 0: System.exit(0);
                        break;
                }
            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null,"Opción no válida");
            }
        }while(option != 0);       
    }

    public static void insertMenu() {
        String mData = "***Ingreso***"
                + "\nPor favor ingrese el dato a ingresar en el árbol:";
        String mFather = "***Ingreso***"
                + "\nPor favor ingrese el padre del dato a ingresar:";
        int option = -1;
        
        try{
            option = Integer.parseInt(JOptionPane.showInputDialog(mData));
            if(!N.buscarDato(N.getRaiz(), option, false)){
                Nodo newNode = new Nodo(option);
                if(N.getRaiz() == null){
                    N.insertar(N.getRaiz(), newNode, 0);
                }
                else{
                    int father = Integer.parseInt(JOptionPane.showInputDialog(mFather));
                    if(N.buscarDato(N.getRaiz(), father, false)){
                        N.insertar(N.getRaiz(), newNode, father);
                    }else{
                        JOptionPane.showMessageDialog(null, "El padre ingresado no existe");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "El dato ya está ingresado en el árbol");
            }
        }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }
    
    public static void eraseMenu() {
        String mData = "***Eliminar***"
                + "\nPor favor ingrese el dato a eliminar en el árbol:";
        int option = -1;
        try{
            option = Integer.parseInt(JOptionPane.showInputDialog(mData));
            if(N.buscarDato(N.getRaiz(), option, false)){
                if(N.getRaiz().getDato()== option && N.getRaiz().getLiga()== null)
                    N.Limpiar();
                else
                    N.eliminar(N.getRaiz(), option);
            }else{
                JOptionPane.showMessageDialog(null, "El dato no está en el árbol");
            }
        }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    public static void searchDataMenu() {
        String mSearchData = "***Buscar***"
                + "\nPor favor ingrese el dato a buscar en el árbol:";
        int option = -1;
        
        try{
            option = Integer.parseInt(JOptionPane.showInputDialog(mSearchData));
            boolean answer = false;
            if(N.buscarDato(N.getRaiz(), option, answer))
                JOptionPane.showMessageDialog(null, "El dato se encuentra en el árbol");
            else
                JOptionPane.showMessageDialog(null, "El dato no se encuentra en el árbol");     
        }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void gradeDataMenu() { 
        String mSearchData = "***Grado de dato***"
                + "\nPor favor ingrese el dato a buscar en el árbol:";
        int option = -1;
        
        try{
            option = Integer.parseInt(JOptionPane.showInputDialog(mSearchData));
            if(N.buscarDato(N.getRaiz(), option, false))
                JOptionPane.showMessageDialog(null, "El grado del nodo " + option + " es: " + N.mostrarGradoDato(N.getRaiz(), option, 0));
            else
                JOptionPane.showMessageDialog(null, "El dato no se encuentra en el árbol");     
        }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void dataSonsMenu() {
        String mSearchData = "***Hijos de dato***"
                + "\nPor favor ingrese el dato a buscar en el árbol:";
        int option = -1;
        
        try{
            option = Integer.parseInt(JOptionPane.showInputDialog(mSearchData));
            if(N.buscarDato(N.getRaiz(), option, false)){
                String answer = "";
                JOptionPane.showMessageDialog(null, "Los hijos de " + option + " son: " + N.hijosDato(N.getRaiz(), option, answer));
            }else
                JOptionPane.showMessageDialog(null, "El dato no se encuentra en el árbol");     
        }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void showLevelMenu() {
        String mSearchData = "***Nivel de dato***"
                + "\nPor favor ingrese el dato a buscar en el árbol:";
        int option = -1;
        
        try{
            option = Integer.parseInt(JOptionPane.showInputDialog(mSearchData));
            if(N.buscarDato(N.getRaiz(), option, false)){
                JOptionPane.showMessageDialog(null, "El nivel de " + option + " es: " + N.mostrarNivel(N.getRaiz(), option, 2, 0));
            }else
                JOptionPane.showMessageDialog(null, "El dato no se encuentra en el árbol");     
        }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void fatherDataMenu() { //N.fatherData(N.getRoot());
        String mData = "***Padre de dato***"
                + "\nPor favor ingrese el dato a consultar:";
        int option = -1;
        try{
            option = Integer.parseInt(JOptionPane.showInputDialog(mData));
            if(N.buscarDato(N.getRaiz(), option, false)){
                if(N.getRaiz().getDato()== option)
                    JOptionPane.showMessageDialog(null, "El dato se encuentra en la raíz del árbol");
                else
                    N.mostrarDatoPadre(N.getRaiz(), option);
            }else{
                JOptionPane.showMessageDialog(null, "El dato no está en el árbol");
            }
        }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    
}