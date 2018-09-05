class WordClass {
	private String word; // �ܾ�
	private int number; // �ݺ�Ƚ��

	// �ܾ�� �ݺ�Ƚ���� �Ű������� �޾� �ʱ�ȭ�ϴ� ������
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

	// �ܾ �ݺ�Ƚ����ŭ �� �ٿ� ����ϴ� �޼ҵ�
	public void print() {
		for(int i = 0; i < number; i++) {
			System.out.print(word + " ");
		}
	}
}

class WordRunnable extends WordClass implements Runnable {//Ŭ���� WordRunnable ���� - WordClass�� ��ӹް�, Runnable�� ������
	
	public WordRunnable(String word,int number) {//�ܾ�� �ݺ�Ƚ���� �Ű������� �޾� �ʱ�ȭ�ϴ� ������
		super(word,number);
	}

	@Override
	public void run() {//run�޼ҵ� ������
		for(int i=0;i<getNumber();i++) {
			System.out.print(getWord()+" ");
		}
	}
	
}

public class WordRunnableTest {

	public static void main(String[] args) {
		//aaa�� 5�� ����ϴ� ������ t1�� BB�� 10�� ����ϴ� ������ t2 ����
		Thread t1=new Thread(new WordRunnable("aaa",5));
		Thread t2=new Thread(new WordRunnable("BB",10));
		//������ t1�� t2�� ���۽�Ŵ
		t1.start();
		t2.start();
	}
}
