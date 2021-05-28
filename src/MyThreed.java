// Прога отработки темы потоки, главный поток

public class MyThreed {
    public static void main(String[] args) {
        
        Thread t = Thread.currentThread();
        System.out.println("Текущий поток " + t);

        t.setName("Мой поток.");
        t.setPriority(3);
        System.out.println("Теперь поток называется " + t);
        new Runn();
        try{
            for (int x = 10; x>0; x--){
                System.out.print(x + " ");
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван.");
        }

    }
}
//создание потока реализацией интерфейса Runnable
class Runn implements Runnable{
    Thread t;

    Runn (){
        t = new Thread(this, "Demonstration");
        System.out.println("Дочерний поток создан.");
        t.start();
    }
    public void run(){
        try {
            for (int x = 10; x > 0; x--) {
                System.out.println("Дочерний поток класса Ранн " + x);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Поток класса Ранн прерван с ошибкой");
        }
    }
}
