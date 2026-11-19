class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 2;

        // Find pivot
        while(i >= 0 && arr[i] >= arr[i + 1]){
            i--;
        }

        if(i < 0){
            return -1;
        }

        //Find next greater element from right
        int j = arr.length - 1;
        while(arr[j] <= arr[i]){
            j--;
        }

        // Swap
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Reverse the suffix
        reverse(arr, i + 1, arr.length - 1);

        // Convert back to number
        long ans = Long.parseLong(new String(arr));

        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private void reverse(char[] arr, int i, int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}