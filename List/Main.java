package List;

public class Main {

    public Main(){
        List<String> list = new List<>();
        List<String> listClone = new List<>();
        List<Object> list2 = new List<>();
        Object[] list3 = new Object[10];
        String teste1 = "Vai dormir Igor!";
        String teste2 = "Você tem que acordar cedo amanhã!";

        list.add(teste1);
        list.add(teste2);
        list.add(2, "Bom Dia!");

        list3 = list2.copyForArray();
        
        System.out.println(list);
        System.out.println(list.get(2).getElement());

        list.remove(teste2);
        list.remove(0);
        System.out.println(list);

        listClone = list.clone(list);

        list2.copyToArray(list3);
        System.out.println(list2);

        if(list.equals(listClone)){
            System.out.println("São iguais!");
        }else{
            System.out.println("São diferentes!");
        }
        


    }
    public static void main(String[] args) {
        new Main();
    }
}
