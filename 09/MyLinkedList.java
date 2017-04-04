public class MyLinkedList{
    LNode start, end; 
    int size;
    public MyLinkedList(){
	size = 0;
    }
    public boolean add(int value) {
	add(size,value);
    }
    public int size(){
	return size;
    }
    private LNode getNthNode(int n){
	if(x < 0 || x >= size){
	    throw new IndexOutOfBoundsException();
	} 
	else{
	    LNode temp = start;
	    int y = 0;
	    while(y < x){
		temp = temp.next;
		y++;
	    }
	    return temp;
    }
    public int get(int x){
	return getNthNode(x).value;
    }
    public int set(int index, int newVal){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	} 
	else{
	    LNode temp = start;
	    int y = 0;
	    while(y < index){
		temp = temp.next;
		y++;
	    }
	    int oldval = temp.value;
	    temp.value = newVal;
	    return oldval;
	}
    }
    public String toString(){
	String s = "[";
	LNode temp = start;
	if(size > 0){
	    s+= temp.value;
	    temp = temp.next;
	    for (int x = 1; x < size;x ++){
		s += ", ";
		s += temp.value;
		temp = temp.next;
	    }
	}
	s+= "]";
	return s;
    }
    public void add(int index, int value) {
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	} 
	LNode a = new LNode(value);
	if(index == 0){
	    a.next = start;
	    start.previous = a;
	    start = a;
	}
	if(index == size){
	    end.next = a;
	    a.previous = end;
	    end = a;
	}
	else{
	    LNode temp = start;
	    for(int x = 0;x < index; x++){
		temp = temp.next;
	    }
	    LNode holder = temp.next;
	    temp.setNext(a);
	    a.setPrevious(temp);
	    a.setNext(holder);
	    holder.setPrevious(a);
	    size ++;
	}
    }
    public int indexOf(int val) {
	LNode temp  =  start;
	for(int x = 0;x < size;x ++){
	    if(temp.value == val){
		return x;
	    }
	    temp = temp.next;
	}
	return -1;
    }
    private class LNode{
	int value;
	LNode next, previous;
	public LNode(int x){
	    value = x;
	}
	public void setNext(LNode x){
	    next = x;
	}
	public void setPrevious(LNode x){
	    previous = x;
	}
    }
    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	a.add(3);
	a.add(3);
	a.add(4);
	a.add(6);
	System.out.println(a.size());
	System.out.println(a.get(2));
	System.out.println(a.set(2,10));
	a.add(2,6);
	System.out.println(a.indexOf(10));
	System.out.println(a.indexOf(0));
	System.out.println(a);
    }
}
