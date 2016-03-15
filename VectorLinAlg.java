


/**
 * This class implements vectors as used in linear algebra.  Vector operations are defined here.
 * @author Accribus
 * @author MJay1982
 */
public class VectorLinAlg {
	
	private double[] vectorDouble;
        	
	/**
         * 
         */
        public VectorLinAlg(){
            
        }
        
	
        /**
         * creates a vector with random int values ranging from 0 to 10 and dimension = dim
         * if a double is used for dim, then the vector values will be double
         * @param dim 
         */
	public VectorLinAlg(int dim){
            
		this.vectorDouble = new double[(int)dim];
		for(int i = 0; i < this.vectorDouble.length; i++){
			this.vectorDouble[i] = Math.random()*10; 
		}
	}
        
        	
        /**
         * takes in a double[] an wraps it in a VectorLinAlg object
         * @param arr 
         */
	public VectorLinAlg(double[] arr){
		
		this.vectorDouble = new double[arr.length];
		for(int i = 0; i < arr.length; i++){
			this.vectorDouble[i] = arr[i];
		}
	}
	
		
	
        /**
         * creates a vector with random double values ranging from 0 to range and dimension = dim
         * @param dim
         * @param range 
         */
	public VectorLinAlg(int dim, double range){
		
		this.vectorDouble = new double[dim];
		for(int i = 0; i < this.vectorDouble.length; i++){
			this.vectorDouble[i] = Math.random()*range; 
		}
	}
		
        /**
         * 
         * @return the dimension of the vector (count of elements, example: [3, 4, 5] returns 3 
         */
	public int getDimension(){
			
		return vectorDouble.length;
	}
	
        /**
         * 
         * @return an intuitively readable vector as a string, example [3, 4, 5]
         */
	public String toString(){
		return this.showVector();
	}
	//used by overridden toString()
	private String showVector(){
		
            String res = "<";
                
            for(int i = 0; i < this.getDimension(); i++){
                if(i == 0){
                        res += this.getIndexAtVector(i);
                }else{
                        res += "," + this.getIndexAtVector(i);
                }
            }

            return res + ">";
	}
	
	 /**
         * @see return value at index i
         * @param i
         * @return value at index i 
         */
	public double getIndexAtVector(int i){
		return this.vectorDouble[i];
	}
	 
	
        /**
         * @see set value at index i
         * @param i
         * @return void 
         */
	public void setIndexAtVector(int i, double val){
		this.vectorDouble[i] = val;
	}
	
        /**
         * 
         * @param vector
         * @param scalar
         * @return new vector after scalar multiple is applied
         */
	public static VectorLinAlg scalar(VectorLinAlg vector, double scalar){
		
		for(int i = 0; i < vector.getDimension(); i++){
                    vector.setIndexAtVector(i, scalar * vector.getIndexAtVector(i));
                }
		
		return vector;
	}
	
        /**
         * Adds both vectors and returns the resulting vector.
         * @param v1
         * @param v2
         * @return new vector that is the sum of v1 and v2
         */
        public static VectorLinAlg addVectors(VectorLinAlg v1, VectorLinAlg v2){
            int dim = v1.getDimension();
            
            VectorLinAlg result;
            
            double[] tmp = new double[dim];
            for(int i = 0; i < dim; i++){
                tmp[i] = v1.getIndexAtVector(i) + v2.getIndexAtVector(i);
            }
                        
            result = new VectorLinAlg(tmp);
            return result;
        }
        
        /**
         * Subtracts v2 from v1. Note that with vectors subtraction is NOT commutative.
         * @param v1
         * @param v2
         * @return new vector that is the result of v1 MINUS v2.  
         * 
         */
        public static VectorLinAlg subtractVectors(VectorLinAlg v1, VectorLinAlg v2){
            int dim = v1.getDimension();
            
            System.out.print(v1.toString() + " - " + v2.toString());
            
            VectorLinAlg result;
            
            double[] tmp = new double[dim];
            for(int i = 0; i < dim; i++){
                tmp[i] = v1.getIndexAtVector(i) - v2.getIndexAtVector(i);
            }
            
            result = new VectorLinAlg(tmp);
            return result;
        }
        
        /**
         * 
         * @param v1
         * @param v2
         * @return scalar product of the 2 vectors 
         */
        public static double dotProduct(VectorLinAlg v1, VectorLinAlg v2){
            
            int dim = v1.getDimension();
            double scalar = 0;
            for(int i = 0; i < dim; i++){
                scalar += v1.getIndexAtVector(i) * v2.getIndexAtVector(i);
            }
            
            return scalar;
        }
        
        /**
         * 
         * @param v
         * @return vector magnitude
         */
        public static double getMagnitude(VectorLinAlg v){
            
            int dim = v.getDimension();
            double squares = 0;
            double result = 0;
                    
            for(int i = 0; i < dim; i++){
                squares += Math.pow(v.getIndexAtVector(i),2);
            }
            
            result = Math.sqrt(squares);
            return result;
        }
        
        /**
         * 
         * @param v1
         * @param v2
         * @return the angle between the two vectors as theta
         */
        public static double getTheta(VectorLinAlg v1, VectorLinAlg v2){
            
            //based on: a * b = ||a|| x ||b|| x cos(theta)
            double productMagnitudes = getMagnitude(v1) * getMagnitude(v2); //||a|| * ||b||
            double cosTheta = dotProduct(v1, v2) / productMagnitudes;
            double theta = Math.acos(cosTheta);
            return theta;
        }
        
        /**
         * calculates the cross product of v1 and v2, which 
         * is applicable to 3 dimensional vectors only, and is NOT commutative
         * if a vector of other that 3 dimensions is passed, null is returned
         * calculation algorithm: a x b = {a2b3 - a3b2, a3b1 - a1b3, a1b2 = a2b1}
         * @param v1
         * @param v2
         * @return a new vector that is the cross product of v1 and v2 
         */
        public static VectorLinAlg crossProduct(VectorLinAlg v1, VectorLinAlg v2){
            
            int dim = v1.getDimension();
            int dim2 = v2.getDimension();
            if(dim != 3 | dim2 != 3){
                return null;
            }
            
            VectorLinAlg resultVector;
            
            double a, b, c;                
            a = v1.getIndexAtVector(1) * v2.getIndexAtVector(2) - v1.getIndexAtVector(2) * v2.getIndexAtVector(1); //a2b3 - a3b2
            b = v1.getIndexAtVector(2) * v2.getIndexAtVector(0) - v1.getIndexAtVector(0) * v2.getIndexAtVector(2); //a3b1 - a1b3
            c = v1.getIndexAtVector(0) * v2.getIndexAtVector(1) - v1.getIndexAtVector(1) * v2.getIndexAtVector(0); //a1b2 = a2b1
            double[] vecValsDbl = new double[]{a, b, c};
            resultVector = new VectorLinAlg(vecValsDbl);
            
            return resultVector;
        }
        
        /**
         * clears out a vector, keeping original dimension
         * @param v 
         */
        public static void zeroVector(VectorLinAlg v){
            
            int dim = v.getDimension();
            
            for(int i = 0; i < dim; i++){
                v.setIndexAtVector(i, 0);
            }
        }
        /**
         * Creates a unit vector.
         * @param v1
         * @return a normalized vector
         * 
         */
        public static VectorLinAlg unitVector(VectorLinAlg v){
             int dim = v.getDimension(); //Pass dimension of v into method
             VectorLinAlg result;
             
             
             double[] tmp = new double[dim]; //Create an empty container called array, of size dim.
             
             for(int i = 0; i < dim; i++){ //for loop divides every element in v by mag.
                tmp[i] = v.getIndexAtVector(i) / v.getIndexAtVector(i);
             }
             
             result = new VectorLinAlg(tmp);
             return result;
        }
        
        /**
         *  Scalar projection of v1 along v2
         *  @param v1
         *  @param v2
         *  @return the scalar component of v1 which lies along the direction of v2
         */       
        public static double scalarProjection(VectorLinAlg v1, VectorLinAlg v2){
          
             //based on: Scalar component of v1 on v2 = ||v1|| x cos(theta)
             double v1CompOnv2 = getMagnitude(v1) * Math.cos(getTheta(v1, v2));
             return v1CompOnv2;
        }
        
        /*
        currently fails test- but no worries
        the vector projection of v1 onto v2
        should be the unit vector * the scalar projection
        of v1 along v2
        */
        public static VectorLinAlg vectorProjection(VectorLinAlg v1, VectorLinAlg v2){
             //based on: v1 on v2 = Scalar component of v1 on v2 * v2 unit vector
             int dim = v2.getDimension(); //Need the dimension of v2 for the iteration.
             double mag = getMagnitude(v2);
             VectorLinAlg result;
             
             double[] tmp = new double[dim]; //Create an empty array of size dim.
             for(int i = 0; i < dim; i++){
                //tmp[i] = v2.unitVector()v2.getIndexAtVector(i) * v1.scalarProjection();
             } //the above statement should take the v2 unit vector and then do the indexing - not sure...
             
             result = new VectorLinAlg(tmp);
             return result;
        }
        
        
        

}
