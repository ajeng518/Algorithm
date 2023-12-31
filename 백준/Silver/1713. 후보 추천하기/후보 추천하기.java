import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student> {
    int num;
    int choice = 0;
    int day;

    public Student() {
        super();
        choice = 0;
    }

    public Student(int num, int choice, int day) {
        super();
        this.num = num;
        this.choice = choice;
        this.day = day;
    }

    @Override
    public int compareTo(Student o) {
        if (this.choice == o.choice) return Integer.compare(this.day, o.day);
        return Integer.compare(this.choice, o.choice);
    }
}

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Student> pic = new ArrayList<>();//액자 리스트

        int N = Integer.parseInt(br.readLine());//빈 액자 수
        int C = Integer.parseInt(br.readLine());//추천 횟수
        int[] result = new int[N];//출력위한 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            Student can = new Student();//값 담아둘 can 객체 할당
            boolean use = false;//기존에 있는 학생인지 확인용

            can.num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < pic.size(); j++) {
                if (can.num == pic.get(j).num) {
                    pic.get(j).choice++;
                    use = true;
                    break;
                }
            }
            if (use == false) {//같은 것이 없는 경우
                if (pic.size() == N) {//빈 액자가 없는 경우
                    pic.remove(0);
                }
                can.choice = 1;
                can.day = i + 1;
                pic.add(can);
            }
            Collections.sort(pic);
        }

        pic.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.num-o2.num;
            }
        });
        for (int i = 0; i < pic.size(); i++) {
            sb.append(pic.get(i).num+" ");
        }
        System.out.println(sb.toString());
    }
}
