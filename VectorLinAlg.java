

/**
 * This class implements vectors as used in linear algebra.  Vector operations are defined here.
 * @author Accribus
 * 
 */
public class VectorLinAlg {
	
	
	private int[] vectorInt;
	private double[] vectorDouble;
	private String type = "";
        	
	//creates a vector with random int values ranging from 0 to 10 and dimension = dim
	public VectorLinAlg(int dim){
		type = "int";
		this.vectorInt = new int[dim];
		for(int i = 0; i < this.vectorInt.length; i++){
			this.vectorInt[i] = (int)Math.floor(Math.random()*10);
			System.out.println(this.vectorInt[i]);
		}
	}
	
	//creates a vector with random int values ranging from 0 to 10 and dimension = dim
	//if a double is used for dim, then the vector values will be double
	public VectorLinAlg(double dim){
		type = "double";
		this.vectorDouble = new double[(int)dim];
		for(int i = 0; i < this.vectorDouble.length; i++){
			this.vectorDouble[i] = Math.random()*10; 
			System.out.println(this.vectorDouble[i]);
		}
	}
//        
//        public VectorLinAlg(int dim, int defaultVal){
//            type = "int";
//            this.vectorInt = new int[dim];
//            for(int i = 0; i < dim; i++){
//                this.vectorInt[i] = defaultVal;
//            }
//        }
//        
//        public VectorLinAlg(double dim, double defaultVal){
//            type = "int";
//            this.vectorDouble = new double[(int)dim];
//            for(int i = 0; i < dim; i++){
//                this.vectorDouble[i] = defaultVal;
//            }
//        }
	
	//takes in an int[] an wraps it in a VectorLinAlg object
	public VectorLinAlg(int[] arr){
		type = "int";
		this.vectorInt = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			this.vectorInt[i] = arr[i];
		}
	}
	
	//takes in a double[] an wraps it in a VectorLinAlg object
	public VectorLinAlg(double[] arr){
		type = "double";
		this.vectorDouble = new double[arr.length];
		for(int i = 0; i < arr.length; i++){
			this.vectorDouble[i] = arr[i];
		}
	}
	
	//creates a vector with random values ranging from 0 to range and dimension = dim
	public VectorLinAlg(int dim, int range){
		type = "int";
		this.vectorInt = new int[dim];
		for(int i = 0; i < this.vectorInt.length; i++){
			this.vectorInt[i] = (int)Math.floor(Math.random()*range); 
			System.out.println(this.vectorInt[i]);
		}
	}
	
	//creates a vector with random values ranging from 0 to range and dimension = dim
	public VectorLinAlg(int dim, double range){
		type = "double";
		this.vectorDouble = new double[dim];
		for(int i = 0; i < this.vectorDouble.length; i++){
			this.vectorDouble[i] = Math.random()*range; 
			System.out.println(this.vectorDouble[i]);
		}
	}
	//return type of vector (int or double)
	public String getType(){
		return type;
	}
	
	public int getDimension(){
		int dimension = 0;
		
		if(getType().equals("int")){
			dimension = vectorInt.length;
		}else{
			dimension = vectorDouble.length;
		}
		
		return dimension;
	}
	//overridden for intuitive use
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
	public static VectorLinAlg scalar(VectorLinAlg vector, int scalar){
		
		if(vector.getType().equals("int")){
			for(int i = 0; i < vector.getDimension(); i++){
				vector.setIndexAtVectorInt(i, scalar * vector.getIndexAtVectorInt(i));
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
