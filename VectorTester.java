
public class VectorTester {

	public static void main(String[] args) {
		
            /**
             * declare local variables
            */
            int[] seedInt1 = new int[]{1,22,3};
            int[] seedInt2 = new int[]{4,5,6};
            double[] seedDbl1 = new double[]{1.0,2.0,3.0};
            double[] seedDbl2 = new double[]{4.0,5.0,6.0};

            VectorLinAlg dblV1 = new VectorLinAlg(seedDbl1);
            VectorLinAlg dblV2 = new VectorLinAlg(seedDbl2);

            /**
             * test the toString() method
             */
            System.out.println("dblV1" + dblV1.toString());
            System.out.println("dblV2" + dblV2.toString());

            /**
             * test getMagnitude() method
             */
            System.out.println("dblV1 vector magnitude: " + VectorLinAlg.getMagnitude(dblV1));
            System.out.println("dblV2 vector magnitude: " + VectorLinAlg.getMagnitude(dblV2));

            /**
             * test dotProduct()
             */
            double dblDot = VectorLinAlg.dotProduct(dblV1, dblV2);
            System.out.println("dbl vector dot product: " + dblDot);
            /**
             * test crossProduct
             */
            VectorLinAlg vecCrossPrdDbl = VectorLinAlg.crossProduct(dblV1, dblV2);
            System.out.println("vecCrossPrdDbl: " + vecCrossPrdDbl.toString());
            
            /**
             * test unitVector() method
             */
            VectorLinAlg unitVector = VectorLinAlg.unitVector(dblV1);
            System.out.println("vector dblV1:" + dblV1.toString() + " ... resulting unit vector: " + unitVector.toString());
            
            
            /**
             * testing scalarProjection() method
             */          
            double scalarProjection = VectorLinAlg.scalarProjection(dblV1, dblV2);
            System.out.println("Scalar projection of v1: " + dblV1.toString() + " onto v2 " + dblV2.toString() + ": " + scalarProjection);
            
            /**
             * testing vectorProjection() method
             */
            VectorLinAlg vectorProjection = VectorLinAlg.vectorProjection(dblV1, dblV2);
            System.out.println("Vector projection of v1: " + dblV1.toString() + " onto v2 " + dblV2.toString() + ": " + vectorProjection.toString());
            

	}

}
