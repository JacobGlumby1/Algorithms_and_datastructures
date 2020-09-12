package com.company;

public class Main {




    public static void main(String[] args) {
	    BalPar bp = new BalPar();

	    if(bp.isBalanced("(())")){
			System.out.println("Balanced");
		} else{
			System.out.println("Not balanced");
		}

	    Queue qu = new Queue(5);

		qu.enqueue(1);

		qu.dequeue();
		qu.dequeue();

		qu.enqueue(1);

		qu.enqueue(2);

		qu.enqueue(3);

		qu.enqueue(4);

		qu.enqueue(5);

		qu.enqueue(6);
		qu.dequeue();
		qu.enqueue(6);








    }
}
