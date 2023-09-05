package arboles_n_arios;

public class Nodo {
        
    int dato, sw;
    Nodo liga, ligalista;

    public Nodo(int dato) {
        this.dato = dato;
        sw=0;
        liga=null;
        ligalista=null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public Nodo getLigalista() {
        return ligalista;
    }

    public void setLigalista(Nodo ligaista) {
        this.ligalista = ligaista;
    }
   
}

  