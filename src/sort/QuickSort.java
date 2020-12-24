package sort;

public class QuickSort {
    void quick_sort_base(int s[],int l, int r){
        int i = l,j = r, x = s[l];
        while(i < j){
            while(i < j && s[j] > x) {
                j--;
            }
            if(i < j) {
                s[i++] = s[j];
            }
            while(i < j && s[i] < x) {
                i++;
            }
            if(i < j) {
                s[j--] = s[i];
            }
        }
        //此时i==j,下面s[i]或者s[j]都可以，j-1,j+1也ok
        s[j] = x;
        if (l<i) {
            quick_sort_base(s,l, i - 1);
        }
        if (r>i) {
            quick_sort_base(s,i + 1, r);
        }
    }
    void quickSort_double(int a[],int beg,int end){
        if(beg >= end) {
            return;
        }
        int i = beg+1, j = end, x = a[beg],tmp =0;
        while(i <= j){
            //取等号，确保分成两个不相交区间
            while (i <= j&&a[i] < x) {

                i++;
            }
            while(  i <= j&&a[j] > x)  {
                j--;
            }
            if(i <= j ){
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }
        swap(a, beg, j);
        quickSort_double(a,beg,j-1);
        quickSort_double(a,j+1,end);
    }

    void quickSort_single(int a[], int left, int right) {
        if (left < right) {

            int x = a[right];
            int i = left - 1;
            for (int j = left; j < right; ++j) {
                if (a[j] <= x) {
                    swap(a, ++i, j);
                }
            }
            //i指向小于x的区间的最后一个元素，++后指向轴
            swap(a, ++i , right);
            if (i>left) {
                quickSort_single(a, left, i-1 );
            }
            if (i < right) {
                quickSort_single(a, i + 1, right);
            }

        }

    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
