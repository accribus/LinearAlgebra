

/**
 * This class implements vectors as used in linear algebra.  Vector operations are defined here.
 * @author Accribus
 * 
 */
public class VectorLinAlg {
	
	
	private int[] vectorInt;
	private double[] vectorDouble;
	private String type = "";
        	
	/**
         * creates a vector with random int values ranging from 0 to 10 and dimension = dim
         * if an int is used for dim, then the vector values will be double
         * @param dim 
         */
	public VectorLinAlg(int dim){
		type = "int";
		this.vectorInt = new int[dim];
		for(int i = 0; i < this.vectorInt.length; i++){
			this.vectorInt[i] = (int)Math.floor(Math.random()*10);
		}
	}
	
        /**
         * creates a vector with random int values ranging from 0 to 10 and dimension = dim
         * if a double is used for dim, then the vector values will be double
         * @param dim 
         */
	public VectorLinAlg(double dim){
		type = "double";
		this.vectorDouble = new double[(int)dim];
		for(int i = 0; i < this.vectorDouble.length; i++){
			this.vectorDouble[i] = Math.random()*10; 
		}
	}
        
        /**
         * takes in an int[] an wraps it in a VectorLinAlg object
         * @param arr 
         */
	public VectorLinAlg(int[] arr){
		type = "int";
		this.vectorInt = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
                    this.vectorInt[i] = arr[i];
		}
	}
	
        /**
         * takes in a double[] an wraps it in a VectorLinAlg object
         * @param arr 
         */
	public VectorLinAlg(double[] arr){
		type = "double";
		this.vectorDouble = new double[arr.length];
		for(int i = 0; i < arr.length; i++){
			this.vectorDouble[i] = arr[i];
		}
	}
	
	
        /**
         * creates a vector with random int values ranging from 0 to range and dimension = dim
         * @param dim
         * @param range 
         */
	public VectorLinAlg(int dim, int range){
		type = "int";
		this.vectorInt = new int[dim];
		for(int i = 0; i < this.vectorInt.length; i++){
			this.vectorInt[i] = (int)Math.floor(Math.random()*range);
		}
	}
	
	
        /**
         * creates a vector with random double values ranging from 0 to range and dimension = dim
         * @param dim
         * @param range 
         */
	public VectorLinAlg(int dim, double range){
		type = "double";
		this.vectorDouble = new double[dim];
		for(int i = 0; i < this.vectorDouble.length; i++){
			this.vectorDouble[i] = Math.random()*range; 
		}
	}
	
        /**
         * 
         * @return type of vector (int or double)
         */
	public String getType(){
		return type;
	}
	
        /**
         * 
         * @return the dimension of the vector (count of elements, example: [3, 4, 5] returns 3 
         */
	public int getDimension(){
		int dimension = 0;
		
		if(getType().equals("int")){
			dimension = vectorInt.length;
		}else{
			dimension = vectorDouble.length;
		}
		
		return dimension;
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
		String res = "[";
		if(this.getType().equals("int")){
			for(int i = 0; i < this.getDimension(); i++){
				if(i == 0){
					res += this.getIndexAtVectorInt(i);
				}else{
					res += "," + this.getIndexAtVectorInt(i);
				}
			}
		}else{
			for(int i = 0; i < this.getDimension(); i++){
				if(i == 0){
					res += this.getIndexAtVectorDouble(i);
				}else{
					res += "," + this.getIndexAtVectorDouble(i);
				}
			}
		}
		
		return res + "]";
	}
	
        /**
         * @see return value at index i
         * @param i
         * @return value at index i 
         */
	public int getIndexAtVectorInt(int i){
		return this.vectorInt[i];
	}
	 /**
         * @see return value at index i
         * @param i
         * @return value at index i 
         */
	public double getIndexAtVectorDouble(int i){
		return this.vectorDouble[i];
	}
	 /**
         * @see set value at index i
         * @param i
         * @return void 
         */
	public void setIndexAtVectorInt(int i, int val){
		this.vectorInt[i] = val;
	}
	
        /**
         * @see set value at index i
         * @param i
         * @return void 
         */
	public void setIndexAtVectorDouble(int i, double val){
		this.vectorDouble[i] = val;
	}
	
        /**
         * 
         * @param vector
         * @param scalar
         * @return new vector after scalar multiple is applied
         */
	public static VectorLinAlg scalar(VectorLinAlg vector, double scalar){
		
		if(vector.getType().equals("int")){
			for(int i = 0; i < vector.getDimension(); i++){
				vector.setIndexAtVectorInt(i, (int)scalar * vector.getIndexAtVectorInt(i));
			}
		} else{
                    for(int i = 0; i < vector.getDimension(); i++){
				vector.setIndexAtVectorDouble(i, scalar * vector.getIndexAtVectorDouble(i));
			}                    
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
            String type = v1.getType();
            VectorLinAlg result;
            
            if(type.equals("int")){
                int[] tmp = new int[dim];
                for(int i = 0; i < dim; i++){
                    tmp[i] = v1.getIndexAtVectorInt(i) + v2.getIndexAtVectorInt(i);
                }
                result = new VectorLinAlg(tmp);
            } else{
                double[] tmp = new double[dim];
                for(int i = 0; i < dim; i++){
                    tmp[i] = v1.getIndexAtVectorDouble(i) + v2.getIndexAtVectorDouble(i);
                }
                result = new VectorLinAlg(tmp);
            }
            
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
            String type = v1.getType();
            
            System.out.print(v1.toString() + " - " + v2.toString());
            
            VectorLinAlg result;
            
            if(type.equals("int")){
                int[] tmp = new int[dim];
                for(int i = 0; i < dim; i++){
                    tmp[i] = v1.getIndexAtVectorInt(i) - v2.getIndexAtVectorInt(i);
                }
                result = new VectorLinAlg(tmp);
            } else{
                double[] tmp = new double[dim];
                for(int i = 0; i < dim; i++){
                    tmp[i] = v1.getIndexAtVectorDouble(i) - v2.getIndexAtVectorDouble(i);
                }
                result = new VectorLinAlg(tmp);
            }
            
            return result;
        }
        
        /**
         * 
         * @param v1
         * @param v2
         * @return scalar product of the 2 vectors 
         */
        public static double dotProduct(VectorLinAlg v1, VectorLinAlg v2){
            
            String type = v1.getType();
            int dim = v1.getDimension();
            double scalar = 0;
            if(type.equals("int")){
                for(int i = 0; i < dim; i++){
                    scalar += v1.getIndexAtVectorInt(i) * v2.getIndexAtVectorInt(i);
                }
            } else{
                for(int i = 0; i < dim; i++){
                    scalar += v1.getIndexAtVectorDouble(i) * v2.getIndexAtVectorDouble(i);
                }
            }
            
            return scalar;
        }
        
        /**
         * 
         * @param v
         * @return vector magnitude
         */
        public static double getMagnitude(VectorLinAlg v){
            
            String type = v.getType();
            int dim = v.getDimension();
            double squares = 0;
            double result = 0;
                    
            if(type.equals("int")){
                for(int i = 0; i < dim; i++){
                    squares += Math.pow(v.getIndexAtVectorInt(i),2);
                }
            } else{
                for(int i = 0; i < dim; i++){
                    squares += Math.pow(v.getIndexAtVectorDouble(i),2);
                }
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
            
            String type = v1.getType();
            int dim = v1.getDimension();
            int dim2 = v2.getDimension();
            if(dim != 3 | dim2 != 3){
                return null;
            }
            
            VectorLinAlg resultVector;
            
            if(type.equals("int")){
                
                int a, b, c;                
                a = v1.getIndexAtVectorInt(1) * v2.getIndexAtVectorInt(2) - v1.getIndexAtVectorInt(2) * v2.getIndexAtVectorInt(1); //a2b3 - a3b2
                b = v1.getIndexAtVectorInt(2) * v2.getIndexAtVectorInt(0) - v1.getIndexAtVectorInt(0) * v2.getIndexAtVectorInt(2); //a3b1 - a1b3
                c = v1.getIndexAtVectorInt(0) * v2.getIndexAtVectorInt(1) - v1.getIndexAtVectorInt(1) * v2.getIndexAtVectorInt(0); //a1b2 = a2b1
                int[] vecValsInt = new int[]{a, b, c};
                resultVector = new VectorLinAlg(vecValsInt);
                
            } else {
                
                double a, b, c;                
                a = v1.getIndexAtVectorDouble(1) * v2.getIndexAtVectorDouble(2) - v1.getIndexAtVectorDouble(2) * v2.getIndexAtVectorDouble(1); //a2b3 - a3b2
                b = v1.getIndexAtVectorDouble(2) * v2.getIndexAtVectorDouble(0) - v1.getIndexAtVectorDouble(0) * v2.getIndexAtVectorDouble(2); //a3b1 - a1b3
                c = v1.getIndexAtVectorDouble(0) * v2.getIndexAtVectorDouble(1) - v1.getIndexAtVectorDouble(1) * v2.getIndexAtVectorDouble(0); //a1b2 = a2b1
                double[] vecValsDbl = new double[]{a, b, c};
                resultVector = new VectorLinAlg(vecValsDbl);
                
            }
            
            return resultVector;
        }
        
        /**
         * clears out a vector, keeping original dimension
         * @param v 
         */
        public static void zeroVector(VectorLinAlg v){
            
            String type = v.getType();
            int dim = v.getDimension();
            
            if(type.equals("int")){
                for(int i = 0; i < dim; i++){
                    v.setIndexAtVectorInt(i, 0);
                }
            }else{
                for(int i = 0; i < dim; i++){
                    v.setIndexAtVectorDouble(i, 0.0);
                }
            }
        }

}
