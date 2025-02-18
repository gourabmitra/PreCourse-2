class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
    {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    } 

    int partition(int arr[], int l, int h) 
    {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);

            }
        }
        swap(arr, i + 1, h);

        return i + 1;
    } 
  

    void QuickSort(int arr[], int l, int h) 
    { 
        int  [] sortStack = new int[h-l+1];
        int top = -1;

        sortStack[++top] =l;
        sortStack[++top] =h;

        while(top >=0)
        {
             h= sortStack[top--];
             l= sortStack[top--];

             int pivot =partition(arr, l,h);

             if(pivot-1>l){
                 sortStack[++top] =l;
                 sortStack[++top] = pivot-1;

             }
             if(pivot +1<h)
             {
                 sortStack[++top] =pivot+1;
                 sortStack[++top] = h;
             }
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 