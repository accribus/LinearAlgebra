
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d = 5;
		int scal = 2;
		VectorLinAlg vector = new VectorLinAlg(d);
		System.out.println(vector.showVector());
		vector.scalar(vector, scal);
		System.out.println(vector.showVector());
		
		
		double dd = 5.0;
		
		VectorLinAlg vectorDouble = new VectorLinAlg(dd);
		System.out.println(vectorDouble.showVector());
		vector.scalar(vectorDouble, scal);
		System.out.println(vectorDouble.showVector());

	}

}
