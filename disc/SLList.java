import javax.swing.text.Position;

public class SLList{
    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }
    private IntNode first;

    public void addFirst(int x){
        first = new IntNode(x, first);
    }
    public void insert(int item, int position) {
        if (first == null || position == 0){
            addFirst(item);
            return;
        }
        IntNode currentNode = first;
        while(position > 1 && currentNode.next != null){
            position--;
            currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(item, currentNode.next);
        // 将item赋给新结点的value，位置设置为当前节点的下一个
        currentNode.next = newNode;
    }

    // public void reverse(){
    //     IntNode prev = null;
    //     IntNode curr = first;

    //     while(curr != null){
    //         IntNode nxt = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = nxt;
    //     }
    //     first = prev;
    // }

    public void reverse(){
        first = recursive(first);
    }
    private IntNode recursive(IntNode x){
        if (x == null || x.next == null){
            return x;
        }else{
            IntNode recursenode = recursive(x.next);
            x.next.next = x;
            x.next = null;
            return recursenode;
        }
        
        
    }

    
}


public static int[] insert(int[] arr, int item, int position){
    int[] result = new int[arr.length + 1];
    position = Math.min(position, arr.length);
    for(int i = 0; i< position; i++){
        result[i] = arr[i];
    }
    result[position] = item;
    for (int i = position+1; i< result.length; i++){
        result[i] = arr[i];
    }
    return result;
}

public static void reverse(int[] arr){
    for (int i = 0; i < arr.length/2; i++){
        int j = arr.length -i -1;
        // 对称性
        // 分两半，交换
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

public static int[] replicate(int[] arr){
    int total = 0;
    for(int item: arr){
        total += item;
    }
    int[] result = new int[total];
    int i = 0;
    for(int item: arr){
        for(int counter = 0; counter < item; counter++){
            result[i] = item;
            i++;
        }
    }
    return result;
}