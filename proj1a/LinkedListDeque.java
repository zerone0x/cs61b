public class LinkedListDeque<T>{
    public class Node{
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque(int x){
        sentinel = new Node((T)"null", null, null);
        // 没明白T后面的“null”
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        sentinel.next = new Node(item, sentinel,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size +=1;
    }
    public void addLast(T item){
        sentinel.prev= new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size +=1;

    }
    public boolean isEmpty(){
        if(0==size){
            return true;
        }else{
            return false;
        }
    }
    public void printDeque(){
        Node ptr = sentinel;
        while (ptr.next != sentinel){
            ptr = ptr.next;
            System.out.print(ptr.item);
            System.out.print(" ");
        }
        System.out.println();
    }
    public T removeFirst(){
        T res = sentinel.next.item;
        if (0==size){
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -=1;
        return res;
    }
    public T removeLast(){
        if (0==size){
            return null;
        }
        size -= 1;
        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        return res;
    }
    public T get(int index){
        int i = 0;
        Node p = sentinel;
        while(p.next != sentinel){
            p = p.next;
            if(i == index){
                return p.item;
            }
            i++;
        }
        return null;
        
    }
    public T getRecursiveHelper(int index, int count, Node ptr){
        if(index == count){
            return ptr.item;
        }
        return getRecursiveHelper(index, count+1, ptr.next);
    }
    public T getRecurseive(int index){
        if(index >= size || index < 0){
            return null;
        }
        int count = 0;
        Node ptr =sentinel.next;
        return getRecursiveHelper(index,count,ptr);
    }
    public int size(){
        return size;
    }
}