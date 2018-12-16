package com.unipa.ads.singlelinkedlists;

public class Main {


    public static void main(String[] args){
        System.out.printf("Caricamento in testa ...\n");
        test01();
        System.out.printf("Caricamento in coda ...\n");
        test02();
    }


    private static void test01(){
        // Creazione ed Inizializzazione di una SingleLinkedList
        LinkedList myList = new LinkedList();
        Node myListHead = myList.getHead();

        // Inserimento dei nodi in testa
        for(int i = 0; i < 10; i++){
            myList.insertHeadNode(new Node(i));
        }

        // Stampo la lista
        myList.printListIterative();
    }


    private static void test02(){
        // Creazione ed Inizializzazione di una SingleLinkedList
        LinkedList myList = new LinkedList();
        Node myListHead = myList.getHead();

        // Inserimento dei nodi di prova
        for(int i = 0; i < 10; i++){
            myList.insertTailNode(new Node(i));
        }

        // Stampo la lista
        myList.printListIterative();
    }
}
