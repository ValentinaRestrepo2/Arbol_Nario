package arboles_n_arios;

import javax.swing.JOptionPane;

/**
 *
 * @author valen
 */
public class Arbol {

    Nodo raiz = null;

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Muestra el árbol
    public int mostrarArbol(Nodo r, int dato) {
        Nodo p = r;
        while (p != null) {
            if (p.getSw() == 0) {
                dato = p.getDato();
                if (r == p) {
                    dato = dato;
                }
            } else {
                dato = mostrarArbol(p.getLigalista(), dato);
            }
            p = p.getLiga();
            if (p == null) {
                dato = dato;
            }
        }
        return dato;
    }

    //Muestra un nodo dado
    public void mostrarNodo(Nodo r) {
        Nodo p = r;
        while (p != null) {
            if (p.getSw() == 0) {
                JOptionPane.showMessageDialog(null, "El elemento " + " se encontró");
            } else {
                mostrarNodo(p.getLigalista());
            }
            p = p.getLiga();
        }
    }

    //Ingresa un dato dado
    public void insertar(Nodo nodopadre, Nodo dato, int datopadre) {
        if (this.getRaiz() != null) {
            Nodo q = nodopadre;
            Nodo test = nodopadre;
            while (q != null) {
                if (q.getLiga() == null && test.getDato() == datopadre) {
                    q.setLiga(dato);
                    q = q.getLiga();
                    JOptionPane.showMessageDialog(null, "Dato ingresado");
                }
                if (q.getSw() == 0) {
                    if (q.getDato() == datopadre && test != q) {
                        q.setSw(1);
                        Nodo newFather = new Nodo(datopadre);
                        q.setLigalista(newFather);
                        newFather.setLiga(dato);
                        JOptionPane.showMessageDialog(null, "Dato ingresado");
                    }
                } else {
                    insertar(q.getLigalista(), dato, datopadre);
                }
                q = q.getLiga();
            }
        } else {
            this.setRaiz(dato);
            JOptionPane.showMessageDialog(null, "Dato ingresado");
        }
    }

    //Borra un dato en el árbol
    public void eliminar(Nodo r, int dato) {
        Nodo p = r;
        Nodo ant = p;
        if (p.getDato() == dato && p.getLiga() != null) { // dato en un padre
            int newFather = hijoMayor(p); //Busca el hijo mayor
            eliminar(p, newFather);//eliminar el hijo mayor
            p.setDato(newFather);
        }

        if (p.getLiga() != null) {
            p = p.getLiga();
        }

        while (p != null) {
            if (p.getSw() == 0) {
                if (p.getDato() == dato) { //dato es una hoja
                    ant.setLiga(p.getLiga());
                }
            } else {
                eliminar(p.getLigalista(), dato);
                if (p.getLigalista().getLiga() == null) {
                    p.setDato(p.getLigalista().getDato());
                    p.setSw(0);
                    p.setLigalista(null);
                }
            }
            ant = p;
            p = p.getLiga();
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

    public boolean buscarDato(Nodo r, int dato, boolean resp) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (q.getDato() == dato) {
                    resp = true;
                }
            } else {
                resp = buscarDato(q.getLigalista(), dato, resp);
            }
            q = q.getLiga();
        }
        return resp;
    }

    public String mostrarRaiz(Nodo r, String raizs) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (r == q) {
                    raizs = raizs + q.getDato() + " ";
                }
            } else {
                raizs = mostrarRaiz(q.getLigalista(), raizs);
            }
            q = q.getLiga();
        }
        return raizs;
    }

    public int contarHojas(Nodo r, int hoja) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (r != q) {
                    hoja = hoja + 1;
                }
            } else {
                hoja = contarHojas(q.getLigalista(), hoja);
            }
            q = q.getLiga();
        }
        return hoja;
    }

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

    public int mostrarGradoArbol(Nodo r, int grado) {
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
                grado = mostrarGradoArbol(q.getLigalista(), grado);
            }
            q = q.getLiga();
        }
        return grado;
    }

    public int mostrarGradoDato(Nodo r, int dato, int grado) {
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
                grado = mostrarGradoDato(q.getLigalista(), dato, grado);
            }
            q = q.getLiga();
        }
        return grado;
    }

    public String hijosDato(Nodo r, int dato, String resp) {
        Nodo q = r;
        while (q != null) {
            if (q.getSw() == 0) {
                if (q.getDato() == dato && q == r) {
                    q = q.getLiga();
                    while (q != null) {
                        if (q.getSw() == 0) {
                            resp = resp + " " + q.getDato();
                        } else {
                            resp = resp + " " + q.getLigalista().getDato();
                        }
                        q = q.getLiga();
                    }
                    q = r;
                }
            } else {
                resp = hijosDato(q.getLigalista(), dato, resp);
            }
            q = q.getLiga();
        }
        return resp;
    }

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
                System.out.print(nivel);
                nivel = mostrarAltura(q.getLigalista(), altura, nivel);
                System.out.println(nivel);
            }
            q = q.getLiga();
        }
        return altura;
    }

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

    public void Limpiar() {
        this.setRaiz(null);
    }

}
