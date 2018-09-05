class WordClass {
	private String word; // 단어
	private int number; // 반복횟수

	// 단어와 반복횟수를 매개변수로 받아 초기화하는 생성자
	public WordClass(String word, int number) {
		this.word = word;
		this.number = number;
	}

	public String getWord() {
		return word;
	}

	public int getNumber() {
		return number;
	}

	// 단어를 반복횟수만큼 한 줄에 출력하는 메소드
	public void print() {
		for(int i = 0; i < number; i++) {
			System.out.print(word + " ");
		}
	}
}

class WordRunnable extends WordClass implements Runnable {//클래스 WordRunnable 정의 - WordClass를 상속받고, Runnable을 구현함
	
	public WordRunnable(String word,int number) {//단어와 반복횟수를 매개변수로 받아 초기화하는 생성자
		super(word,number);
	}

	@Override
	public void run() {//run메소드 재정의
		for(int i=0;i<getNumber();i++) {
			System.out.print(getWord()+" ");
		}
	}
	
}

public class WordRunnableTest {

	public static void main(String[] args) {
		//aaa를 5번 출력하는 스레드 t1과 BB를 10번 출력하는 스레드 t2 생성
		Thread t1=new Thread(new WordRunnable("aaa",5));
		Thread t2=new Thread(new WordRunnable("BB",10));
		//스레드 t1과 t2를 시작시킴
		t1.start();
		t2.start();
	}
}
