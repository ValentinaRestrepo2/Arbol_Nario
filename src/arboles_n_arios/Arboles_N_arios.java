package arboles_n_arios;

import javax.swing.JOptionPane;

/**
 *
 * @author Valentina Restrepo Arboleda
 */
public class Arboles_N_arios {

    private static Arbol arbol = new Arbol();

    public static void main(String[] args) {

        String menu = "***MENÚ ÁRBOLES N-ario***"
                + "\n\n 1- Mostrar árbol\n 2- Mostrar la raiz\n 3- Insertar dato"
                + "\n 4- Eliminar dato\n 5- Buscar dato\n 6- Mostrar raices"
                + "\n 7- Contar hojas\n 8- Mostrar hojas\n 9- Mostrar grado del árbol"
                + "\n10- Mostrar grado de un dato\n11- Mostrar hijos de un dato"
                + "\n12- Mostrar hermanos de un dato\n13- Mostrar nivel de un dato"
                + "\n14- Mostrar altura\n15- Mostrar padre de un dato"
                + "\n16- Mostrar datos del nivel"
                + "\n 0- Salir\n\n(Ingrese una opción)";
        int opcion = -1;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1://Mostrar árbol
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            String Sarbol = "";
                            JOptionPane.showMessageDialog(null, arbol.Mostrar(arbol.getRaiz(), Sarbol));
                        }
                        break;
                    case 2://Mostrar raiz
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            JOptionPane.showMessageDialog(null, "La raiz del árbol es: " + arbol.getRaiz().getDato());
                        }
                        break;
                    case 3://Insertar dato
                        menuInsertar();
                        break;
                    case 4://Eliminar dato
                        menuEliminar();
                        JOptionPane.showMessageDialog(null, "Dato eliminado");
                        break;
                    case 5://Buscar dato
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            menuBuscarDato();
                        }
                        break;
                    case 6://Mostrar raices
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            String respuesta = "";
                            JOptionPane.showMessageDialog(null, "Las raices del árbol son: " + arbol.mostrarRaices(arbol.getRaiz(), respuesta));
                        }
                        break;
                    case 7://Contar hojas
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            int leafs = 0;
                            JOptionPane.showMessageDialog(null, "La cantidad de hojas del árbol es: " + arbol.contarHojas(arbol.getRaiz(), leafs));
                        }
                        break;
                    case 8://Mostrar hojas
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            String respuesta = "";
                            JOptionPane.showMessageDialog(null, "Las hojas del árbol son: " + arbol.mostrarHojas(arbol.getRaiz(), respuesta));
                        }
                        break;
                    case 9://Mostrar grado del arbol
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            int grade = 0;
                            JOptionPane.showMessageDialog(null, "El árbol es de grado : " + arbol.gradoArbol(arbol.getRaiz(), grade));
                        }
                        break;
                    case 10://Mostrar grado de un dato
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            menuGradoDato();
                        }
                        break;
                    case 11://Mostrar hijos de un dato
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            menuDatoHijos();
                        }
                        break;
                    case 12://Mostrar hermanos
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            menuMostrarNivel();
                        }
                        break;
                    case 13://Mostrar nivel de un dato
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            menuMostrarNivel();
                        }
                        break;
                    case 14: //Mostrar la altura del árbol
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            if (arbol.getRaiz() != null) {
                                JOptionPane.showMessageDialog(null, "La altura del árbol es : " + arbol.mostrarAltura(arbol.getRaiz(), 1, 1));
                            }
                        }
                        break;
                    case 15: //Mostrar el padre de un dato
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            menuDatoPadre();
                        }
                        break;
                    case 16://Mostrar datos del nivel
                        if (arbol.getRaiz() == null) {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío");
                        } else {
                            menuMostrarDatoNivel();
                        }
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 0);
    }

    public static void menuInsertar() {
        String dato = "Ingrese el dato que desea insertar en el árbol:";
        String datopadre = "Ingrese el padre del dato a insertar:";
        int opcion = -1;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(dato));
            if (!arbol.buscarDato(arbol.getRaiz(), opcion, false)) {
                Nodo newNodo = new Nodo(opcion);
                if (arbol.getRaiz() == null) {
                    arbol.insertar(arbol.getRaiz(), newNodo, 0);
                } else {
                    int father = Integer.parseInt(JOptionPane.showInputDialog(datopadre));
                    if (arbol.buscarDato(arbol.getRaiz(), father, false)) {
                        arbol.insertar(arbol.getRaiz(), newNodo, father);
                    } else {
                        JOptionPane.showMessageDialog(null, "El padre que ha ingresado no existe en el árbol");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El dato se insertó correctamente al árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    public static void menuEliminar() {
        String dato = "Ingrese el dato que desea eliminar del árbol:";
        int opcion = -1;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(dato));
            if (arbol.buscarDato(arbol.getRaiz(), opcion, false)) {
                arbol.eliminar(arbol.getRaiz(), opcion);
            } else {
                JOptionPane.showMessageDialog(null, "El dato que ha ingresado no existe en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    public static void menuBuscarDato() {
        String dato = "Ingrese el dato a buscar en el árbol:";
        int opcion = -1;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(dato));
            boolean respuesta = false;
            if (arbol.buscarDato(arbol.getRaiz(), opcion, respuesta)) {
                JOptionPane.showMessageDialog(null, "El dato SI está en el árbol");
            } else {
                JOptionPane.showMessageDialog(null, "El dato NO está en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void menuGradoDato() {
        String dato = "Ingrese el dato a buscar en el árbol:";
        int opcion = -1;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(dato));
            if (arbol.buscarDato(arbol.getRaiz(), opcion, false)) {
                JOptionPane.showMessageDialog(null, "El grado del nodo " + opcion + " es: " + arbol.gradoDato(arbol.getRaiz(), opcion, 0));
            } else {
                JOptionPane.showMessageDialog(null, "El dato que ha ingresado no existe en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void menuDatoHijos() {
        String dato = "Ingrese el dato a buscar en el árbol:";
        int opcion = -1;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(dato));
            if (arbol.buscarDato(arbol.getRaiz(), opcion, false)) {
                String respuesta = "";
                JOptionPane.showMessageDialog(null, "Los hijos de " + opcion + " son: " + arbol.mostrarHijos(arbol.getRaiz(), opcion, respuesta));
            } else {
                JOptionPane.showMessageDialog(null, "El dato que ha ingresado no existe en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void menuMostrarNivel() {
        String dato = "Ingrese el dato a buscar en el árbol:";
        int opcion = -1;

        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(dato));
            if (arbol.buscarDato(arbol.getRaiz(), opcion, false)) {
                JOptionPane.showMessageDialog(null, "El nivel de " + opcion + " es: " + arbol.mostrarNivel(arbol.getRaiz(), opcion, 2, 0));
            } else {
                JOptionPane.showMessageDialog(null, "El dato que ha ingresado no existe en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void menuDatoPadre() {
        String dato = "Ingrese el dato a consultar:";
        int opcion = -1;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(dato));
            if (arbol.buscarDato(arbol.getRaiz(), opcion, false)) {
                if (arbol.getRaiz().getDato() == opcion) {
                    JOptionPane.showMessageDialog(null, "El dato se encuentra en la raíz del árbol");
                } else {
                    arbol.mostrarDatoPadre(arbol.getRaiz(), opcion);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El dato que ha ingresado no existe en el árbol");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void menuMostrarDatoNivel() {
        String dato = "Ingrese nivel a consultar:";
        int opcion = -1;

        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(dato));
            if (opcion < 0 ) {
                JOptionPane.showMessageDialog(null, "El nivel que ha ingresado no existe en el árbol");
            } else {
                String respuesta = "";
                JOptionPane.showMessageDialog(null, "Los datos del nivel " + dato + " son: " + arbol.mostrarDatoNivel(arbol.getRaiz(), respuesta, opcion));

            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }
}
