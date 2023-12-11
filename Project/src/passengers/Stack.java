package passengers;

public class Stack {
    private Transaction[] transactions;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.transactions = new Transaction[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(Transaction transaction) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push more transactions.");
            return;
        }
        transactions[++top] = transaction;
    }

    public Transaction pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop transaction.");
            return null;
        }
        return transactions[top--];
    }

    public Transaction peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
        return transactions[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Transactions in the stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println(
                    "Amount: " + transactions[i].getAmount() );
               
        }
    }
}
