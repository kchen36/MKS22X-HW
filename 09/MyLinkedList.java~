public class MyLinkedList{
    LNode start, end, current;
    
    int size;
    public MyLinkedList(){
	
    }
    public boolean add(int value) {
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
	    current = start;
	    return true;
	}
    }
    public int size(){
	return size;
    }
    public int get(int x){
	if(x < 0 || x >= size){
	    throw new IndexOutOfBoundsException();
	} 
	else{
	    LNode temp = start;
	    int y = 0;
	    while(y < x){
		temp = temp.next();
	    }
	    return temp.value;
	}
    }
    public int set(int index, int newVal){
	if(x < 0 || x >= size){
	    throw new IndexOutOfBoundsException();
	} 
	else{
	    LNode temp = start;
	    int y = 0;
	    while(y < x){
		temp. = temp.next();
	    }
	    int val = temp.value;
	    temp.value = newVal
		return temp.value;
	}
    }
    public String toString(){
	String s = "[";
	LNode temp = start;
	for (int x = 0; x < size;x ++){
	    s += temp.value;
	    s += ", ";
	    temp = temp.next();
	}
	s+= "]";
	return s;
    }
    public int indexOf(int value) {
	LNode temp = start;
	for (int x = 0; x < size;x ++){
	    if(temp.value == value){
		return x;
	    }
	    temp = temp.next();
	}
	return -1;
    }
    public void add(int index, int value) {
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
}
