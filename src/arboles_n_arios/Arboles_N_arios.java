package arboles_n_arios;

import javax.swing.JOptionPane;

public class Arboles_N_arios {

    private static Arbol N = new Arbol();

    public static void main(String[] args) {
        Arbol A = new Arbol();
        int datopadre, dato;
        Nodo r;
        String menu = "***MENÚ ÁRBOLES***"
                + "\n\n 1- Mostrar árbol\n 2- Insertar\n 3- Eliminar\n 4- Raiz\n 5- Buscar dato"
                + "\n 6- Mostrar raices\n 7- Contar hojas\n 8- Mostrar hojas\n(Ingrese una opción)";
        int opcion = -1;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1: //Mostrar
                        if (A.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            A.mostrar(A.getRaiz());
                        }
                        break;

                    case 2: //Insertar
                        dato = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el dato a ingresar en el árbol:"));
                        datopadre = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el padre del dato a ingresar:"));

                         //A.insertar(A.getRaiz(), dato, datopadre);
                        break;

                    case 3:  //Eliminar
                        //eliminar();
                        JOptionPane.showMessageDialog(null, "Dato eliminado");
                        break;

                    case 4: //Mostrar raíz
                        if (A.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            JOptionPane.showMessageDialog(null, "La raiz del árbol es: " + A.getRaiz().getDato());
                        }
                        break;
                    case 5: //Buscar dato
                        if (A.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            // buscarDato();
                        }
                        break;

                    case 6: //Mostrar raices
                        if (A.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            String answer = "";
                            //JOptionPane.showMessageDialog(null, "Las raices del árbol son: " + A.mostrarRaiz(A.getRaiz(), answer));
                        }
                        break;

                    case 7: //Contar hojas
                        if (A.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            int leafs = 0;
                            // JOptionPane.showMessageDialog(null, "Las hojas del árbol son: " + A.contarHojas(A.getRaiz(), leafs));
                        }
                        break;

                    case 8: //Mostrar hojas
                        if (A.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            String answer = "";
                            // JOptionPane.showMessageDialog(null, "Las hojas del árbol son: " + A.mostrarHojas(A.getRaiz(), answer));
                        }
                        break;
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 0);
    }

    public static void insertMenu() {
        String mData = "***Ingreso***"
                + "\nPor favor ingrese el dato a ingresar en el árbol:";
        String mFather = "***Ingreso***"
                + "\nPor favor ingrese el padre del dato a ingresar:";
        int option = -1;

        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(mData));
            if (!N.buscarDato(N.getRaiz(), option, false)) {
                Nodo newNode = new Nodo(option);
                if (N.getRaiz() == null) {
                    N.insertar(N.getRaiz(), newNode, 0);
                } else {
                    int father = Integer.parseInt(JOptionPane.showInputDialog(mFather));
                    if (N.buscarDato(N.getRaiz(), father, false)) {
                        N.insertar(N.getRaiz(), newNode, father);
                    } else {
                        JOptionPane.showMessageDialog(null, "El padre ingresado no existe");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El dato ya está ingresado en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    public static void eraseMenu() {
        String mData = "***Eliminar***"
                + "\nPor favor ingrese el dato a eliminar en el árbol:";
        int option = -1;
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(mData));
            if (N.buscarDato(N.getRaiz(), option, false)) {
                if (N.getRaiz().getDato() == option && N.getRaiz().getLiga() == null) {
                    N.Limpiar();
                } else {
                    N.eliminar(N.getRaiz(), option);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El dato no está en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    public static void searchDataMenu() {
        String mSearchData = "***Buscar***"
                + "\nPor favor ingrese el dato a buscar en el árbol:";
        int option = -1;

        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(mSearchData));
            boolean answer = false;
            if (N.buscarDato(N.getRaiz(), option, answer)) {
                JOptionPane.showMessageDialog(null, "El dato se encuentra en el árbol");
            } else {
                JOptionPane.showMessageDialog(null, "El dato no se encuentra en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void gradeDataMenu() {
        String mSearchData = "***Grado de dato***"
                + "\nPor favor ingrese el dato a buscar en el árbol:";
        int option = -1;

        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(mSearchData));
            if (N.buscarDato(N.getRaiz(), option, false)) {
                JOptionPane.showMessageDialog(null, "El grado del nodo " + option + " es: " + N.mostrarGradoDato(N.getRaiz(), option, 0));
            } else {
                JOptionPane.showMessageDialog(null, "El dato no se encuentra en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void dataSonsMenu() {
        String mSearchData = "***Hijos de dato***"
                + "\nPor favor ingrese el dato a buscar en el árbol:";
        int option = -1;

        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(mSearchData));
            if (N.buscarDato(N.getRaiz(), option, false)) {
                String answer = "";
                JOptionPane.showMessageDialog(null, "Los hijos de " + option + " son: " + N.hijosDato(N.getRaiz(), option, answer));
            } else {
                JOptionPane.showMessageDialog(null, "El dato no se encuentra en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void showLevelMenu() {
        String mSearchData = "***Nivel de dato***"
                + "\nPor favor ingrese el dato a buscar en el árbol:";
        int option = -1;

        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(mSearchData));
            if (N.buscarDato(N.getRaiz(), option, false)) {
                JOptionPane.showMessageDialog(null, "El nivel de " + option + " es: " + N.mostrarNivel(N.getRaiz(), option, 2, 0));
            } else {
                JOptionPane.showMessageDialog(null, "El dato no se encuentra en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void fatherDataMenu() { //N.fatherData(N.getRoot());
        String mData = "***Padre de dato***"
                + "\nPor favor ingrese el dato a consultar:";
        int option = -1;
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(mData));
            if (N.buscarDato(N.getRaiz(), option, false)) {
                if (N.getRaiz().getDato() == option) {
                    JOptionPane.showMessageDialog(null, "El dato se encuentra en la raíz del árbol");
                } else {
                    N.mostrarDatoPadre(N.getRaiz(), option);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El dato no está en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

}
