
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d = 5;
		int scal = 5;
		VectorLinAlg vector = new VectorLinAlg(d);
		System.out.println("vector" + vector.toString());
		vector = vector.scalar(vector, scal);
		System.out.println("vector" + vector.toString());
		
		
		double dd = 5.0;
		
		VectorLinAlg vectorDouble = new VectorLinAlg(dd);
		System.out.println("vectorDouble" + vectorDouble.toString());
		vectorDouble = VectorLinAlg.scalar(vectorDouble, scal);
		System.out.println("vectorDouble" + vectorDouble.toString());
                
                
                VectorLinAlg vecDblTmp = new VectorLinAlg(vectorDouble.getDimension(),2.0);
                VectorLinAlg.scalar(vecDblTmp, 5);
                System.out.println("vecDblTmp" + vecDblTmp.toString());
                vectorDouble = VectorLinAlg.subtractVectors(vecDblTmp, vectorDouble);
                System.out.println("subtracting vectors " + vectorDouble.toString());
                
                VectorLinAlg.zeroVector(vectorDouble);
                System.out.println(vectorDouble.toString());

	}

}
