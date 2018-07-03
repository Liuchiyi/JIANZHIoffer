public class HeapBig {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int[] a = {10, 8, 11, 8, 14, 9, 4, 1, 17};
        HeapBig hb = new HeapBig();
        hb.heapSort(a);
        for(int x : a)
            System.out.print(x + " ");
    }

    // 对于下标i，它的父节点下标为(i + 1) / 2 - 1，左孩子节点下标为i * 2 + 1，右孩子节点下标为i * 2 + 2

    // 维护最大堆
    public void maxHeapify(int[] a, int i, int length) {
        int l = left(i);
        int r = right(i);
        int max;
        if (l < length && a[l] > a[i]) {
            max = l;
        } else {
            max = i;
        }
        if (r < length && a[r] > a[max]) {
            max = r;
        }
        if (max != i) {
            swap(a, i, max);
            // 节点max的值变成了较小的原来节点i的值，因此，以节点max为根节点的子树可能违背最大堆的性质
            // 节点i变成了节点max，因此递归调用maxHeapify(a, max, length)
            maxHeapify(a, max, length);
        }
    }

    // 找到节点i的子左节点序号
    public int left(int i) {
        return i * 2 + 1;
    }

    // 找到节点i的子右节点序号
    public int right(int i) {
        return i * 2 + 2;
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 建立最大堆
    public void buildMaxHeap(int[] a) {
        for (int i = a.length / 2 + 1; i >= 0; --i) {
            maxHeapify(a, i, a.length);
        }
    }

    // 堆排序
    // 整个数组的 最大元素 总是在最大堆的第一个，即a[0]。这时，如果我们拿走第一个元素，放到数组的最后一个位置
    // ，然后对第一个元素进行维护最大堆maxHeapify，如此循环进行，便可完成整个数组的排序
    public void heapSort(int[] a) {
        // 建立最大堆//首先建立最大堆，完成后第一个元素为最大值
        buildMaxHeap(a);
        int length = a.length;
        for (int i = a.length - 1; i >= 1; --i) {
            swap(a, i, 0);// 将第一个最大的元素移到后面，并且在maxHeapify的过程中通过减小length忽略它
            --length;
            maxHeapify(a, 0, length);
        }
    }
}
