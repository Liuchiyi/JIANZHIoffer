import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class HeapBig2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        ArrayList<Integer> maxHeap = new ArrayList<Integer>();
        // 初始的数据
        int value = 0;
        maxHeap.add(0);     // 下标为0的位置不存放数字,从1开始存放
        for(int i=1;i<=len;i++){
            value = in.nextInt();
            maxHeap.add(value);
        }
        // 过程1(调整法)：调整使其成为一个大顶堆，从最后一个非叶节点开始调整
        for(int i=(maxHeap.size()-1)/2;i>=1;i--){   // 注意边界
            adjustHeap(maxHeap,i,maxHeap.size());
        }
        // 输出大顶堆
        System.out.print("大顶堆为：");
        for(int i=1;i<maxHeap.size();i++){          // 注意边界
            System.out.print(maxHeap.get(i)+" ");
        }

        // 过程2：在大顶堆中插入数字
        insert(maxHeap,10);
        System.out.print("插入数字后大顶堆为：");
        for(int i=1;i<maxHeap.size();i++){          // 注意边界
            System.out.print(maxHeap.get(i)+" ");
        }
        // 过程3：从大顶堆中删除数字
        delete(maxHeap,1);
        System.out.print("删除数字后大顶堆为：");
        for(int i=1;i<maxHeap.size();i++){          // 注意边界
            System.out.print(maxHeap.get(i)+" ");
        }
        // 过程4：对大顶堆进行排序
        sort(maxHeap);
        System.out.print("排序后数组：");
        for(int i=1;i<maxHeap.size();i++){          // 注意边界
            System.out.print(maxHeap.get(i)+" ");
        }


    }
    public static int left(int index){               // 注意边界
        return 2*index;
    }
    public static int right(int index){
        return 2*index+1;
    }

    //过程1： 调整堆,对堆中某个元素进行调整
    public static void adjustHeap(ArrayList<Integer> maxHeap,int i,int size){
        // 注意，从数组下标为1的开始
        int index = i;
        int lchild = left(i);
        int rchild = right(i);
        if(index<=(size-1)/2){ // 确保不是叶子节点
            if(lchild<=size&&maxHeap.get(index)<maxHeap.get(lchild))
                index = lchild;
            if(rchild<size&&maxHeap.get(index)<maxHeap.get(rchild))
                index = rchild;    // index此时为两个子节点中较大的值
            if(i!=index){
                Collections.swap(maxHeap,i,index);
                adjustHeap(maxHeap,index,size);   // 以index为根的子树往下继续调整
            }
        }
    }

    //过程2： 向最大堆中插入数据
    public static void insert(ArrayList<Integer> maxHeap,int value){
        // 在数组尾部添加,且注意下标为0的位置不放元素
        if(maxHeap.size()==0)
            maxHeap.add(0);
        maxHeap.add(value);
        heapUp(maxHeap,maxHeap.size()-1);
    }
    //过程2：把"插入"的元素上浮
    public static void heapUp(ArrayList<Integer> maxHeap,int index){
        if(index>1){
            // 求出其父亲节点
            int parent = index/2;
            int parentValue = maxHeap.get(parent);
            int indexValue = maxHeap.get(index);
            // 如果父亲节点的值小于index节点的值，交换两者的位置
            if(parentValue<indexValue){
                Collections.swap(maxHeap, parent, index);
                heapUp(maxHeap,parent);
            }
        }
    }

    //过程3：把最大堆中的某个元素删除
    public static void delete(ArrayList<Integer> maxHeap,int index){
        // 把最后的一个叶子的数值赋值给index位置
        maxHeap.set(index,maxHeap.get(maxHeap.size()-1));
        // 下沉操作
        heapDown(maxHeap,index);
        maxHeap.remove(maxHeap.size()-1);   // 移除
    }
    //过程3："下沉"操作
    public static void heapDown(ArrayList<Integer> maxHeap,int index){
        // 因为第一个位置存储的是控制，不考虑在内，最后一个也要删除，不考虑在内
        int n = maxHeap.size()-2;
        // 记录较大的儿子的位置
        int child = -1;
        if(2*index>n){       // 2*index>n 说明该节点没有左右儿子节点了，则返回
            return;
        }else if(2*index<n){ // 两个儿子都在
            child = 2*index;
            if(maxHeap.get(child)<maxHeap.get(child+1)){
                child++;
            }
        }else if(2*index==n){  // 只有左儿子
            child=2*index;
        }
        // 交换和递归
        if(maxHeap.get(child)>maxHeap.get(index)){
            Collections.swap(maxHeap, child, index);
            heapDown(maxHeap,child);
        }

    }
    //程序4：对大顶堆进行排序
    public static void sort(ArrayList<Integer> maxHeap){
        for(int i=maxHeap.size()-1;i>0;i--){
            Collections.swap(maxHeap, 1, i);
            adjustHeap(maxHeap,1,i);
        }
    }

}
