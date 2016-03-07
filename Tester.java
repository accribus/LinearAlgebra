
public class Tester {

	public static void main(String[] args) {
		
                double dot = 0;
		
		double dd = 3.0;
		
		VectorLinAlg vectorDouble = new VectorLinAlg(dd);
		System.out.println("vectorDouble" + vectorDouble.toString());                
                
                VectorLinAlg vecDblTmp = new VectorLinAlg(vectorDouble.getDimension(),2.0);

                System.out.println("vecDblTmp" + vecDblTmp.toString());
                
                System.out.println(vectorDouble.toString() + " dot product " + vecDblTmp.toString());
                dot = VectorLinAlg.dotProduct(vectorDouble,vecDblTmp);
                System.out.println("vectorDouble dot product vecDblTmp: " + dot);
                
                double mag1 = VectorLinAlg.getMagnitude(vectorDouble);
                double mag2 = VectorLinAlg.getMagnitude(vecDblTmp);
                double prodSum = mag1 * mag2;
                
                double cosTheta = dot / prodSum;
                System.out.println("cosTheta: " + cosTheta);
                double theta = Math.acos(cosTheta);
                
                System.out.println("theta manually calculated: " + theta);
                System.out.println("getTheta result: " + VectorLinAlg.getTheta(vectorDouble,vecDblTmp));
                
                VectorLinAlg vInt1 = new VectorLinAlg(3);
                VectorLinAlg vInt2 = new VectorLinAlg(3);
                System.out.println(vInt1.toString() + " cross product " + vInt2.toString());
                VectorLinAlg vIntCP = VectorLinAlg.crossProduct(vInt1, vInt2);
                System.out.println("cross prod vInt1 x vInt2: " + vIntCP.toString());
                
                VectorLinAlg vDblCP = VectorLinAlg.crossProduct(vectorDouble,vecDblTmp);
                System.out.println(vectorDouble.toString() + " cross product " + vecDblTmp.toString());
                System.out.println("cross prod vectorDouble x vecDblTmp: " + vDblCP.toString());
                

	}

}
