package com.kodilla.extraTasks;

class Element{

    public String value;
    public Element next;
    public Element prev;

    public Element(String value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public String getValue(){
        return this.value;
    }

    public void setNext(Element next){
        this.next = next;
    }
    public void setPrev(Element prev){
        this.prev = prev;
    }
    public Element getPrev(){
        return this.prev;
    }
    public Element getNext(){
        return this.next;
    }
}

class StringCollection{

    public Element collectionHead;
    public Element begOfList;

    public StringCollection(){
        this.collectionHead = null;
        this.begOfList = null;
    }

    void addElement(String s){
        System.out.println("...... Adding element into list - value: "+s+" ......");
        Element element = new Element(s);
        if (collectionHead == null){

            collectionHead = element;
            //ustaw poczatek
            begOfList = collectionHead;
            element.setNext(element);
            //System.out.println("value: "+element.getValue()+" cHead: "+collectionHead+"\n##################");
        } else {
            //ustaw next w poprzednim elemencie
            collectionHead.setNext(element);
            //ustaw atrybuty biezacego elementu
            element.setPrev(collectionHead);
            element.setNext(null);
            //przesun wskaznik na biezacy element
            collectionHead = element;

            //System.out.println("value: "+element.getValue()+" cHead: "+collectionHead+"\n##################");
        }
    }

    public void printList() {
        //wyswietlanie od pierwszego elementu
        Element loop = begOfList;
        if (loop == null){
            System.out.println("No elements in the list");
        }
        else{
            System.out.println("List of the elements: ");
        }

        while(loop != null){
            //System.out.println(loop.getValue()+" prev: "+loop.getPrev()+" next: "+loop.getNext());
            System.out.println("   "+loop.getValue());
            loop = loop.getNext();
        }

    }

    boolean removeElement(String s){
        System.out.println("...... Removing element from the list - value: "+s+" ......");
        Element loop = collectionHead;
        Element prev = null;
        Element next = null;
        boolean remove = false;

        do{
            if(loop.getValue() == s){

                //jesli usuwasz ostatni
                if(loop.getNext() == null){

                    //jesli nie jest to jedyny element w liscie
                    if (loop.getPrev() != null){
                        prev = loop.getPrev();
                        prev.setNext(null);
                        remove = true;
                        break;
                    } else {
                        loop = null;
                        begOfList = null;
                        remove = true;
                        break;
                    }

                    //jesli usuwasz pierwszy
                } else if (loop.getPrev() == null){

                    begOfList = loop.getNext();
                    begOfList.setPrev(null);
                    remove = true;
                    break;

                } else {
                    prev = loop.getPrev();
                    prev.setNext(loop.getNext());

                    next = loop.getNext();
                    next.setPrev(loop.getPrev());
                    remove = true;
                }

            }
            if(loop != null){
                loop = loop.getPrev();
            }
        } while(loop != null);

        if(!remove){
            System.out.println("Can't find element value: "+s);
        }
        return remove;
    }

    String getElement(int n){
        System.out.println("...... Searching element number "+n+" from the list ......");
        Element loop = begOfList;
        String value = null;
        int i = 1;

        do{
            if(i == n){
                value = loop.getValue();
                System.out.println("Value of element number: "+n+" in the list: "+value);
            }
            i++;
            loop = loop.getNext();

        } while(loop != null);

        if(value == null){
            System.out.println("Can't find element with the number: "+n+". In the list are only: "+(i-1)+" elements");
        }
        return value;
    }
}

class ownLinkedList {
    public static void main (String[] args) {
        StringCollection s = new StringCollection();
        s.addElement("txt1");
        s.addElement("txt2");
        s.addElement("txt3");
        s.addElement("txt4");
        s.printList();
        s.addElement("txt5");
        s.addElement("txt6");
        s.printList();
        s.getElement(5);
        s.removeElement("txt7");
        s.removeElement("txt4");
        s.printList();
        s.removeElement("txt2");
        s.printList();
        s.getElement(5);
        s.removeElement("txt3");
        s.printList();
        s.removeElement("txt1");
        s.removeElement("txt5");
        s.removeElement("txt6");
        s.printList();

    }
}