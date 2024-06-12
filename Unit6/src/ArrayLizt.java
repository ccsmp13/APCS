public class ArrayLizt<E> implements Lizt<E>{
    //add other variables needed
    E[] arr;
    int firstAvail;



    
    @SuppressWarnings("unchecked")
    public ArrayLizt(){
        this.arr = (E[])(new Object[10]);
        this.firstAvail = 0;
    }
    

    @Override
    public int size() {
        return this.firstAvail;
    }

    @Override
    public boolean add(E e) {
        if(this.size() + 1 == arr.length){
            resize();
        }
        arr[firstAvail] = e;
        firstAvail++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= this.size()){
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds for size: " + this.size() );
        }
        if(firstAvail == arr.length){
            resize();
        }
        for (int i = firstAvail; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        firstAvail++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size()){
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds for size: " + this.size() );
        }
        if(firstAvail == arr.length){
            resize();
        }
        E ans = arr[index];
        for (int i = index; i < firstAvail; i++) {
            arr[i] = arr[i+1];
        }
        this.firstAvail--;
        return ans;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size()){
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds for size: " + this.size() );
        }
        return arr[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= this.size()){
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds for size: " + this.size() );
        }
        E res = this.arr[index];
        this.arr[index] = element;
        return res;
    }
    @SuppressWarnings("unchecked")
    private void resize(){
        E[] nArr = (E[])(new Object[arr.length * 2]);
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = arr[i];
        }
        this.arr = nArr;
    }

}