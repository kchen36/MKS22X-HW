public class MyLinkedList{
    LNode start, end;
    int size;
    public MyLinkedList{

    }
    boolean add(int value) {
	try{
	    if(size > 0){
		LNode n = new LNode(value);
		end.setNext(n);
		end = end.next();
		size ++;
		return true;
	    }
	    else{
		LNode n = new LNode(value);
		start = n;
		end = start;
		return true;
	    }
	}
	catch (){
	}
    }
    int size(){
	return size;
    }
    String toString(){
	String s = "["
    }
    public class LNode{
	int value;
	LNode next, previous;
	public LNode(int x){
	    value = x;
	}
	public LNode next(){
	    return next;
	}
	public LNode previous(){
	    return previous;
	}
	public void setNext(LNode x){
	    next = x;
	}
	public void setPrevious(LNode x){
	    previous = x;
	}
    }
]
