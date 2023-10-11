import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution{
	static class Person implements Comparable<Person> {
		int idx, arriveTime, waitTime, infoNum, fixNum;

		public Person(int idx, int arriveTime) {
			super();
			this.idx = idx;
			this.arriveTime = arriveTime;
			this.waitTime = 0;
			this.infoNum = 0;
			this.fixNum = 0;
		}

		@Override
		public int compareTo(Person o) {
			int num = this.waitTime - o.waitTime;
			if (num == 0)
				num = this.infoNum - o.infoNum;
			return num;
		}
	}

	static int N, M, K, A, B, infoTime[], fixTime[];
	static Person[] infoList, fixList;
	static Deque<Person> infoWait, tempWait, endPerson;
	static PriorityQueue<Person> fixWait;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			infoWait = new ArrayDeque<>();
			tempWait = new ArrayDeque<>();
			endPerson = new ArrayDeque<>();
			fixWait = new PriorityQueue<>();

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			infoTime = new int[N];
			infoList = new Person[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				infoTime[i] = Integer.parseInt(st.nextToken());
			}

			fixTime = new int[M];
			fixList = new Person[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				fixTime[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				infoWait.add(new Person(i, Integer.parseInt(st.nextToken())));
			}

			int time = 0;
			while (true) {
				boolean endCondition = true;// 접수창구, 정비창구 모두 비었고, 대기줄까지 빌경우 true

				// 접수 창구
				for (int i = 0; i < N; i++) {
					if (infoList[i] == null) {// 창구가 비었음
						if (infoWait.isEmpty())
							continue;
						Person now = infoWait.peek();

						if (time >= now.arriveTime) {
							now = infoWait.poll();
							now.waitTime = 1;
							now.infoNum = i;
							infoList[i] = now;
						}
						endCondition = false;
					} else {// 창구가 비지 않았음
						infoList[i].waitTime++;
						endCondition = false;
					}
					if (infoList[i] != null && infoList[i].waitTime == infoTime[i]) {
						infoList[i].waitTime = time;
						tempWait.add(infoList[i]);
						infoList[i] = null;
					}
				}

				// 정비창구
				for (int j = 0; j < M; j++) {
					if (fixList[j] == null) {
						if (fixWait.isEmpty())
							continue;
						Person now = fixWait.poll();
						now.waitTime = 1;
						now.fixNum = j;
						fixList[j] = now;
						endCondition=false;
					} else {
						fixList[j].waitTime++;
						endCondition=false;
					}
					if(fixList[j]!=null && fixList[j].waitTime==fixTime[j]) {
						endPerson.add(fixList[j]);
						fixList[j]=null;
					}
				}
				
				if(infoWait.isEmpty() && fixWait.isEmpty() && endCondition)break;
				
				while(!tempWait.isEmpty())
					fixWait.add(tempWait.poll());
				time++;
			}
			int personNumSum=0;
			while(!endPerson.isEmpty()) {
				Person temp=endPerson.poll();
				if(temp.infoNum==A-1 && temp.fixNum==B-1) {
					personNumSum+=temp.idx;
				}
			}
			if(personNumSum==0)personNumSum=-1;
			
			sb.append("#").append(test).append(" ").append(personNumSum).append("\n");
		}
		System.out.println(sb);
	}

}
