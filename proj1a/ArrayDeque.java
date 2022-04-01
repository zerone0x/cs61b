public class ArrayDeque<T>{
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private final int INITIAL_CAPACITY = 8;

    public ArrayDeque(){
        items = (T[]) new Object[INITIAL_CAPACITY];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }
    public boolean isEmpty(){
        return (size == 0 ? true : false);
    }

    public int minusOne(int index){
        return Math.floorMod(index - 1, items.length);
    }

    public int plusOne(int index){
        return Math.floorMod(index + 1, items.length);
    }

    public int plusOne(int index, int length){
        return Math.floorMod(index + 1, length);
    }

    private void expand(){
        resizeHelper(items.length * 2);

    }
    private void reduce(){
        resizeHelper(items.length / 2);
    }
    private void resize(){
        if(size == items.length){
            expand();
        }
        if(size < items.length / 4 && items.length > 8){
            reduce();
        }
    }
    private void resizeHelper(int capacity){
        T[] temp = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i = begin; i != end; i = plusOne(i, temp.length)){
            items[nextLast] = temp[i];
            nextLast = plusOne(nextLast);
        }
        items[nextLast] = temp[end];
        nextLast = plusOne(nextLast);
    }
    public T getFirst(){
        return items[plusOne(nextFirst)];
    }
    public void addFirst(T item){
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }
    
    public T getLast(){
        return items[minusOne(nextLast)];
    }
    public T removeFirst(){
        resize();
        T x = getFirst();
        nextFirst = plusOne(nextFirst);
        items[nextFirst] = null;
        size--;
        return x;
    }
    public T removeLast(){
        resize();
        T x = getLast();
        nextLast = minusOne(nextLast);
        items[nextLast] = null;
        size -= 1;
        return x;
    }

    public void printDeque(){
        for(int x = plusOne(nextFirst); x != nextLast; x = plusOne(x)){
            System.out.print(items[x]);
            System.out.print(" ");
        }
        System.out.println();
    }
    public T get(int x){
        if(x < 0 || x >= size){
            return null;
        }
        x = Math.floorMod(plusOne(nextFirst) + x, items.length);
        return items[x];
    }
    public int size() {
        return size;
    }
}