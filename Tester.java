
public class Tester {

	public static void main(String[] args) {
		
            int[] seedInt1 = new int[]{1,22,3};
            int[] seedInt2 = new int[]{4,5,6};
            double[] seedDbl1 = new double[]{1.0,2.0,3.0};
            double[] seedDbl2 = new double[]{4.0,5.0,6.0};

            VectorLinAlg dblV1 = new VectorLinAlg(seedDbl1);
            VectorLinAlg dblV2 = new VectorLinAlg(seedDbl2);

            System.out.println("dblV1" + dblV1.toString());
            System.out.println("dblV2" + dblV2.toString());

            System.out.println("dblV1 vector magnitude: " + VectorLinAlg.getMagnitude(dblV1));
            System.out.println("dblV2 vector magnitude: " + VectorLinAlg.getMagnitude(dblV2));

            double dblDot = VectorLinAlg.dotProduct(dblV1, dblV2);

            System.out.println("dbl vector dot product: " + dblDot);
            
            VectorLinAlg vecCrossPrdDbl = VectorLinAlg.crossProduct(dblV1, dblV2);
            System.out.println("vecCrossPrdDbl: " + vecCrossPrdDbl.toString());
            

	}

}
