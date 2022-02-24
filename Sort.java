public class Sort {
   public static int[] mergeSort(int[] arr){
       if(arr.length <=1){
           return(arr);
       }
       int half = arr.length/2;
       int[] left = new int [half];
       int[] right = new int [arr.length-half];
       for(int i=0;i<half;i++){
        left[i] = arr[i];
       }
       for(int i=0;i+half<arr.length;i++){
        right[i] = arr[i+(half)];
       }
       left = mergeSort(left);
       right = mergeSort(right);
       return(Sort.merge(left,right, arr.length));
   }
   public static int[] merge(int[] left, int[] right, int len){
       int[] merged = new int[len];
       int mergedIndex = 0;
       int leftIndex = 0;
       int rightIndex = 0;
       while(leftIndex<left.length && rightIndex<right.length){
           if(left[leftIndex]<right[rightIndex]){
               merged[mergedIndex] = left[leftIndex];
               leftIndex++;
               mergedIndex++;
           }
           else{
            merged[mergedIndex] = right[rightIndex];
            rightIndex++;
            mergedIndex++;
           }
       }
       for(int i = 0;i+leftIndex<left.length;i++){
        merged[mergedIndex] = left[i+leftIndex];
        mergedIndex++;
       }
       for(int i = 0;i+rightIndex<right.length;i++){
        merged[mergedIndex] = right[i+rightIndex];
        mergedIndex++;
       }
       return(merged);
   }




}
