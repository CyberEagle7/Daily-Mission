public class quicksort {

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++){

            if(arr[j] < pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[ei] = temp;
        return i;
    }



      public static void sort(int arr[], int si, int ei){

        if(si <= ei){
        
        int mid = partition(arr, si, ei);

        sort(arr, si, mid-1);
        sort(arr, mid+1, ei);}
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 8, 2};
        int n = arr.length;
        sort(arr, 0, n-1);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
