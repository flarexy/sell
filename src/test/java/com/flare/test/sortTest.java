package com.flare.test;

/**
 * @ClassName sortTest
 * @Description 排序
 * @Author xieyi
 * @Data 2019/1/3
 */
public class sortTest {

    /**
     * 冒泡
     *
     * @param array
     * @param n
     */
    public static void bubbleSort(int[] array, int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入
     *
     * @param array
     * @param n
     */
    public static void insertSort(int[] array, int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = array[i];
            int j = i - 1;
            // 循环有序数据
            // 往有序中插入
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    // 数据往后移动
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j + 1] = value;
        }
    }


    /**
     * 归并
     * @param array
     * @param n
     */
    public static void mergeSort(int[] array, int n) {
        if (n <= 0) {
            return;
        }
        mergeSortCore(array, 0, n - 1);
    }
    private static void mergeSortCore(int[] array, int low, int high) {
        // 终止条件
        if (low >= high) {
            return;
        }
        // 取p到r中间值
        int mid = (low + high) / 2;
        // 分治递归
        mergeSortCore(array, low, mid);
        mergeSortCore(array, mid + 1, high);

        // 将 A[p...q] 和 A[q+1...r] 合并为 A[p...r]
        merge(array, low, mid, high);
    }
    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        // 把对比中较小的数先移到数组中
        // 直到一边为空
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // 移动左边数据到数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 移动右边数据到数组
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 将排好序数组放入原数组中
        for (int x = 0; x < temp.length; x++) {
            array[x + low] = temp[x];
        }
    }

    /**
     * 快速排序
     * @param array
     * @param n
     */
    public static void quickSort(int[] array, int n) {
        if (n <= 0) {
            return;
        }
        quickSortCore(array, 0, n - 1);
    }

    private static void quickSortCore(int[] array, int low, int high) {
        int start = low, end = high, key = array[low];
        while (end>start){
            // 从后往前比较
            while (end>start&&array[end]>=key) {
                // 比key大不交换，往前移动
                end--;
            }
            if (array[end] <= key) {
                int temp = array[end];
                array[end] = array[start];
                array[start] = temp;
            }

            // 从前往后比较
            while (end>start&&array[start]<=key){
                //比key小不交换，往后移动
                start++;
            }
            if (array[start]>=key){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            // 第一次循环结束确认key位置
            // 左边比key小，右边比key大
            // 递归两边分别排序
        }
        if (start > low) {
            quickSortCore(array, low, start - 1);
        }
        if (end < high) {
            quickSortCore(array, end + 1, high);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 54, 7, 9, 3, 6, 4, 1, 236, 744, 1, 5, 9, 8, 6};
        if (array.length <= 0) {
            return;
        }
//        bubbleSort(array,array.length);
//        insertSort(array,array.length);
//        bubbleTest(array,array.length);
//        insertTest(array, array.length);
//        mergeSort(array, array.length);
//        quickSort(array, array.length);


//        test1(array, array.length);
//        test2(array, array.length);
//        test3(array, array.length);
        test4(array, array.length);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        int index = bSearch(array, array.length,236);
        System.out.println(index);


//        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//        System.out.println("sum is:" + nums.stream().filter(num -> num != null).
//                distinct().mapToInt(num -> num * 2).
//                peek(System.out::println).skip(2).limit(4).sum());

    }

    private static void test4(int[] a, int n) {
//        test4Core(a,0,n-1);
        test4Core1(a,0,n-1);
    }

    private static void test4Core(int[] a, int low, int high) {
        if (low>=high) {
            return;
        }
        int start=low,end=high,key=a[low];
        while (end>start){
            while (end>start&&a[end]>=key){
                end--;
            }
            if (a[end]<key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            while (end>start&&a[start]<=key){
                start++;
            }
            if (a[start]>key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        if (start>low){
            test4Core(a,low,start-1);
        }
        if (end<high){
            test4Core(a,end+1,high);
        }
    }

    private static void test4Core1(int[] a, int low, int high) {
        if (low>=high) {
            return;
        }
        int start=low,end=high,key=a[high];
        while (end>start){
            while (end>start&&a[start]<=key){
                start++;
            }
            if (a[start]>key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }

            while (end>start&&a[end]>=key){
                end--;
            }
            if (a[end]<key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }

        }
        if (start>low){
            test4Core(a,low,start-1);
        }
        if (end<high){
            test4Core(a,end+1,high);
        }
    }

    /**
     * 二分查找
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bSearch(int[] a,int n, int value){
        int low = 0,high=n-1;
        while (low<=high){
//            int mid = (low+high)/2;
            // 避免low+high太大报错
//            int mid = low + (high-low)/2;
            // 除以2修改为位运算,右移="/2"
            int mid = low + ((high-low)>>1);
            if (a[mid] == value){
                return mid;
            }else if (a[mid]<value){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        return -1;
    }

}
