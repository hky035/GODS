import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int numberOfCity;
	private int[] timeCountList;
	private int[][] cityList;
	
	public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
		
		// 1. timeList 저장
		numberOfCity = g.length;
		timeCountList = new int[numberOfCity];
		cityList = new int[numberOfCity][2]; // c0: orgIdx, c1:time
		
		for(int i = 0 ; i < numberOfCity ; i++) {
			cityList[i][0] = i;1
			cityList[i][1] = t[i];
		}
		
		
		
		// 2. timeList sorting
		Arrays.sort(cityList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		// 3. 그 순서대로 calc 수행 gold, silver
		calc(a, g, t, w);
		calc(b, s, t, w);
		
		// 4. max Time 체크
		return findMax(timeCountList);
    }
	
	private void calc(int resource, int[] material, int[] t, int[] w) {
		Queue<Integer> enableCity = new LinkedList<Integer>();
		
		for(int i = 0 ; i < numberOfCity ; i++) {
			if(material[cityList[i][0]] != 0)
				enableCity.add(cityList[i][0]);
		}
		
		while(resource > 0) {
			int cityIdx = enableCity.poll();
			resource -= Math.min(w[cityIdx], material[cityIdx]);
			material[cityIdx] -= Math.min(w[cityIdx], material[cityIdx]);
			timeCountList[cityIdx] += ((timeCountList[cityIdx]==0) ? t[cityIdx] : 2 * t[cityIdx]);
			
			if(material[cityIdx] > 0)
				enableCity.add(cityIdx); 
		}
	}
	
	private int findMax(int[] arr) {
		int max = arr[0];
		
		for(int i = 1 ; i < arr.length ; i++) {
			if(max < arr[i])
				max = arr[i];
		}
		return max;
	}
}
