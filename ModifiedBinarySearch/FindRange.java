public class FindRange {
	static int[] findRange(int arr[], int key){
		int[] result = new int[]{-1,-1};
		result[0] = search(arr,key,false);
		if(result[0] != -1){
			result[1] = search(arr,key,true);
		}
		return result;
	}

	static int search(int[] arr, int key, boolean findMaxIndex){
		int N = arr.length;
		int keyIndex = -1;

		int start = 0, end = N-1;
		while(start <= end){
			int mid = start + (end-start)/2;
			if(arr[mid] < key){
				start = mid+1;
			}
			else if(arr[mid] > key){
				end = mid-1;
			}
			else{
				keyIndex = mid;
				if(findMaxIndex){	//find last index of that key
					start = mid+1;
				}
				else{
					end = mid-1;
				}
			}
		}
		return keyIndex; 
	}

	public static void main(String[] args) {
		int[] result = findRange(new int[]{4,6,6,6,9},6);
		System.out.println("[" + result[0] + "," + result[1] + "]");

		result = findRange(new int[]{1,3,8,10,15},10);
		System.out.println("[" + result[0] + "," + result[1] + "]");

		result = findRange(new int[]{1,3,8,10,15},6);
		System.out.println("[" + result[0] + "," + result[1] + "]");
	}

}
