package arboles_n_arios;

import javax.swing.JOptionPane;

/**
 *
 * @author Valentina Restrepo Arboleda
 */
public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    //Mostrar árbol
    public String Mostrar(Nodo p, String arbol) {
        Nodo q = p;
        while (q != null) {
            if (q.getSw() == 0) {
                arbol = arbol + q.getDato() + " ";
                if (p == q) {
                    arbol = arbol + "( ";
                }
            } else {
                arbol = Mostrar(q.getLigalista(), arbol);
            }
            q = q.getLiga();
            if (q == null) {
                arbol = arbol + ") ";
            }
        }
        return arbol;
    }

    //Insertar
    public void insertar(Nodo NodoPadre, Nodo r, int datopadre) {
        if (this.getRaiz() != null) {
            Nodo q = NodoPadre;
            Nodo test = NodoPadre;
            while (q != null) {
                if (q.getLiga() == null && test.getDato() == datopadre) {
                    q.setLiga(r);
                    q = q.getLiga();
                    JOptionPane.showMessageDialog(null, "Dato insertado correctamente");
                }
                if (q.getSw() == 0) {
                    if (q.getDato() == datopadre && test != q) {
                        q.setSw(1);
                        Nodo newFather = new Nodo(datopadre);
                        q.setLigalista(newFather);
                        newFather.setLiga(r);
                        JOptionPane.showMessageDialog(null, "Dato insertado correctamente");
                    }
                } else {
                    insertar(q.getLigalista(), r, datopadre);
                }
                q = q.getLiga();
            }
        } else {
            this.setRaiz(r);
            JOptionPane.showMessageDialog(null, "Dato ingresado correctamente");
        }
    }

    //Eliminar
    public void eliminar(Nodo r, int dato) {
        Nodo q = r;
        Nodo ant = q;
        if (q.getDato() == dato && q.getLiga() != null) { // dato en un padre
            int datoNuevopadre = hijoMayor(q); //Busca el hijo mayor
            eliminar(q, datoNuevopadre);//eliminar el hijo mayor
            q.setDato(datoNuevopadre);
        }
        if (q.getLiga() != null) {
            q = q.getLiga();
        }
        while (q != null) {
            if (q.getSw() == 0) {
                if (q.getDato() == dato) { //dato es una hoja
                    ant.setLiga(q.getLiga());
                }
            } else {
                eliminar(q.getLigalista(), dato);
                if (q.getLigalista().getLiga() == null) {
                    q.setDato(q.getLigalista().getDato());
                    q.setSw(0);
                    q.setLigalista(null);
                }
            }
            ant = q;
            q = q.getLiga();
        }
    }

    public int hijoMayor(Nodo p) { //Busca el mayor de los hijos de una Nodo padre
        int mayor;
        if (p.getLiga().getSw() == 0) {
            mayor = p.getLiga().getDato();
        } else {
            mayor = p.getLiga().getLigalista().getDato();
        }
        p = p.getLiga();
        while (p != null) {
            if (p.getSw() == 0 && p.getDato() > mayor) {
                mayor = p.getDato();
            } else if (p.getSw() == 1 && p.getLigalista().getDato() > mayor) {
                mayor = p.getDato();
            }
            p = p.getLiga();
        }
        return mayor;
    }

    //Buscar dato
    public boolean buscarDato(Nodo r, int dato, boolean respuesta) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (q.getDato() == dato) {
                    respuesta = true;
                }
            } else {
                respuesta = buscarDato(q.getLigalista(), dato, respuesta);
            }
            q = q.getLiga();
        }
        return respuesta;
    }

    //Mostrar raices
    public String mostrarRaices(Nodo r, String raices) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (r == q) {
                    raices = raices + q.getDato() + " ";
                }
            } else {
                raices = mostrarRaices(q.getLigalista(), raices);
            }
            q = q.getLiga();
        }
        return raices;
    }

    //Contar hojas
    public int contarHojas(Nodo r, int hojas) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (r != q) {
                    hojas = hojas + 1;
                }
            } else {
                hojas = contarHojas(q.getLigalista(), hojas);
            }
            q = q.getLiga();
        }
        return hojas;
    }

    // Mostrar hojas
    public String mostrarHojas(Nodo r, String hojas) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (r != q) {
                    hojas = hojas + q.getDato() + " ";
                }
            } else {
                hojas = mostrarHojas(q.getLigalista(), hojas);
            }
            q = q.getLiga();
        }
        return hojas;
    }

    //Mostrar grado del arbol
    public int gradoArbol(Nodo r, int grado) {
        Nodo q = r;
        int aux = 0;
        q = q.getLiga();
        while (q != null) {
            aux++;
            q = q.getLiga();
        }
        if (aux > grado) {
            grado = aux;
        }
        q = r;
        while (q != null) {
            if (q.getSw() != 0) {
                grado = gradoArbol(q.getLigalista(), grado);
            }
            q = q.getLiga();
        }
        return grado;
    }

    //Mostrar grado de un dato
    public int gradoDato(Nodo r, int dato, int grado) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (q.getDato() == dato && q == r) {
                    q = q.getLiga();
                    while (q != null) {
                        grado++;
                        q = q.getLiga();
                    }
                    q = r;
                }
            } else {
                grado = gradoDato(q.getLigalista(), dato, grado);
            }
            q = q.getLiga();
        }
        return grado;
    }

    //Mostrar hijos
    public String mostrarHijos(Nodo r, int dato, String respuesta) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (q.getDato() == dato && q == r) {
                    q = q.getLiga();
                    while (q != null) {
                        if (q.getSw() == 0) {
                            respuesta = respuesta + " " + q.getDato();
                        } else {
                            respuesta = respuesta + " " + q.getLigalista().getDato();
                        }
                        q = q.getLiga();
                    }
                    q = r;
                }
            } else {
                respuesta = mostrarHijos(q.getLigalista(), dato, respuesta);
            }
            q = q.getLiga();
        }
        return respuesta;
    }

    //Mostrar hermanos
    public String mostrarHermanos(Nodo r, int dato, String respuesta) {

        return null;

    }

    //Mostrar nivel
    public int mostrarNivel(Nodo r, int dato, int altura, int nivel) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (q.getDato() == dato && r == q) {
                    nivel = altura - 1;
                } else if (q.getDato() == dato) {
                    nivel = altura;
                }
            } else {
                altura++;
                nivel = mostrarNivel(q.getLigalista(), dato, altura, nivel);
                altura--;
            }
            q = q.getLiga();
        }
        return nivel;
    }

    //Mostrar altura
    public int mostrarAltura(Nodo r, int altura, int nivel) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (r == q && q.getLiga() != null) {
                    nivel++;
                }
                if (nivel > altura) {
                    altura = nivel;
                }
            } else {
                altura = mostrarAltura(q.getLigalista(), altura, nivel);
            }
            q = q.getLiga();
        }
        return altura;
    }

    //Mostrar dato padre
    public void mostrarDatoPadre(Nodo r, int dato) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (q.getDato() == dato && r != q) {
                    JOptionPane.showMessageDialog(null, "El padre de " + dato + " es: " + r.getDato());
                }
            } else {
                if (q.getLigalista().getDato() == dato) {
                    JOptionPane.showMessageDialog(null, "El padre de " + dato + " es: " + r.getDato());
                }
                mostrarDatoPadre(q.getLigalista(), dato);
            }
            q = q.getLiga();
        }
    }

    //Mostrar nivel
    public String mostrarDatoNivel(Nodo r, String respuesta, int nivel) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (nivel < 1) {
                    return "Los niveles son a partir de 1";
                } else if (nivel == 1) {
                    respuesta = respuesta + " " + raiz.getDato();
                } else {

                }

            }
        }

        return respuesta;

    }
//    public void showNodo(Nodo p) {
//        Nodo q = p;
//        boolean found = false;
//        while (q != null) {
//            if (q.getSw() == 0) {
//                JOptionPane.showMessageDialog(null, "El elemento " + " se encontró");
//            } else {
//                showNodo(q.getLigalista());
//            }
//            q = q.getLiga();
//        }
//    }
}
