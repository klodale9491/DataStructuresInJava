package com.unipa.ads.singlelinkedlists;

public class LinkedList {

    private Node Head; // Testa della lista
    private int Size;  // Numero di elementi della lista


    // Inizializzazione delle lista vuota
    public LinkedList(){
        this.Head = null;
        this.Size = 0;
    }


    /*
     * Metodi della lista
     * */


    /*
     * Inserisce un elemento in testa
     * alla lista.
     *
     * Torna un riferimento al nuovo nodo inserito.
     * */
    public Node insertHeadNode(Node node){
        // STEP 1 : Impostiamo che il prossimo elemento del nuovo nodo punti all'attauale testa
        node.setNext(this.Head);

        // STEP 2 : Impostimo che la vecchia testa punti al nodo attuale
        this.Head = node;

        // Aggiorno il numero di elmenti della lista
        this.Size++;

        // Torniamo la nuova testa della lista aggiornata col nuovo elemento
        return this.Head;
    }


    /*
     * Elimina il primo nodo in testa
     * alla lista.
     *
     * Torna un puntatore alla testa della
     * lista aggiornato.
     * */
    public Node deleteHeadNode(){
        // STEP 1 : Se la lista è vuota non posso eliminare nulla
        if(this.Head == null){
            return null;
        }
        else{
            // STEP 2 : Aggiorniamo il riferimento alla testa al successivo elemento
            this.Head = this.Head.getNext();

            /*
             * STEP 3 : Il vecchio nodo di testa non essendo più referenziato verrà
             * marcato dal Garbage Collector e sarà rimosso automaticamente dallo Heap.
             * */
            return this.Head;
        }
    }

    /*
     * Inserisce un elemento in coda
     * alla lista.
     *
     * Torna un riferimento al nuovo nodo inserito.
     * */
    public Node insertTailNode(Node node){
        // STEP 1 : Se la lista è vuota inserisco immediatamente
        if(this.Head == null){
            this.Head = node;
        }
        else{
            // STEP 2 : scorriamo la lista (partendo dalla testa) fino a trovare un nodo il cui "next" referenzi null
            Node tmp = this.Head;
            while(tmp.getNext() != null){
                tmp = tmp.getNext();
            }

            // STEP 3 : A questo punto sappiamo che tmp->next = null, possiamo agganciare il nuovo nodo
            tmp.setNext(node);

            // Aggiorno il numero di elementi della lista
            this.Size++;
        }

        // Torniamo il puntatore alla lista aggiornata
        return this.Head;
    }

    /*
     * Elimina l'ultimo nodo in testa
     * alla lista.
     *
     * Torna un puntatore alla testa della
     * lista aggiornato.
     * */
    public Node deleteTailNode(){
        /*
         * STEP 1 : Se la lista è vuota o ha solo un nodo allora torna la lista vuota.
         * */
        if (this.Head == null || this.Head.getNext() == null)
            return null;

        /*
         * STEP 2 : Se la lista contiene almeno 2 elementi allora la scorro fino a trovare il penultimo nodo
         * */
        Node node = this.Head;
        while(node.getNext().getNext() != null) {
            node = node.getNext();
        }

        /*
         * STEP 3 : Una volta trovato il penultimo nodo, imposto che il suo "next" punti a null,
         * in modo tale da non referenziare più l'ultimo nodo facendo sì che il Garbage Collector
         * pensi ad eliminarlo successivamente.
         * */
        node.setNext(null);

        // Torniamo il puntatore alla testa aggiornata.
        return this.Head;
    }


    /*
     * Metodi di stack, wrapper dei metodi classici di lista.
     * */


    /*
     * Metodo per l'inserimento in testa di uno stack.
     * */
    public Node push(Node node){
        return insertHeadNode(node);
    }


    /*
     * Metodo per la rimozione in testa da uno stack.
     * */
    public Node pop(){
        return this.deleteHeadNode();
    }


    /*
     * Metodo Iterativo per stampare gli elementi di
     * una lista dalla testa alla coda.
     * */
    public void printListIterative(){
        for(Node node = this.Head; node != null; node = node.getNext()){
            System.out.printf("Node Value = %d\n", node.getValue());
        }
    }

    /*
     * Metodo Ricorsivo per stampare gli elementi di
     * una lista dalla testa alla coda.
     * */
    public void printListRecursive(Node node){
        // STEP 1: Se sono arrivato all'ultimo nodo, ne stampo solo il valore.
        if(node.getNext() == null){
            System.out.printf("Node Value = %d\n",node.getValue());
        }
        else{
            // STEP 2 : Stampo il valore del nodo
            System.out.printf("Node Value = %d\n",node.getValue());

            // STEP 3 : Chiamata ricorsiva al prossimo elemento della lista.
            printListRecursive(node.getNext());
        }
    }


    /*
     * Metodo Ricorsivo per stampare gli elementi di
     * una lista dalla coda alla testa.
     * */
    public void printListRecursiveReverse(Node node){
        // STEP 1: Se sono arrivato all'ultimo nodo, ne stampo solo il valore.
        if(node.getNext() == null){
            System.out.printf("Node Value = %d\n",node.getValue());
        }
        else{
            // STEP 2 : Chiamata ricorsiva al prossimo elemento della lista.
            printListRecursive(node.getNext());

            // STEP 3 : Stampo il valore del nodo
            System.out.printf("Node Value = %d\n",node.getValue());
        }
    }


    /*
     * Getter and Setter
     * */

    public Node getHead() {
        return Head;
    }

    public void setHead(Node head) {
        Head = head;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }
}
