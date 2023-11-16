package b2Stacks;

public class Main {
   public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.toString());
        q.push("Ich");
        q.push("esse");
        q.push("gerne");
        q.push("Pommes");
        q.push("mit");
        q.push("Schnitzel");
        q.push(".");
        System.out.println("Erstellte Queue: " + q.toString());
        q.pop();
        q.pop();    
        System.out.println("Queue dannach: " + q.toString());
       }     
}