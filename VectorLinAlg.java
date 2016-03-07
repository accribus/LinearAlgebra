
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
			this.vectorDouble[i] = (int)Math.floor(Math.random()*range); 
			System.out.println(this.vectorDouble[i]);
		}
	}
	
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
	
	public String toString(){
		return this.showVector();
	}
	
	public String showVector(){
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
	
	public int getIndexAtVectorInt(int i){
		return this.vectorInt[i];
	}
	
	public double getIndexAtVectorDouble(int i){
		return this.vectorDouble[i];
	}
	
	public void setIndexAtVectorInt(int i, int val){
		this.vectorInt[i] = val;
	}
	
	public void setIndexAtVectorDouble(int i, double val){
		this.vectorDouble[i] = val;
	}
	
	public VectorLinAlg scalar(VectorLinAlg vector, int scalar){
		
		if(vector.getType().equals("int")){
			for(int i = 0; i < vector.getDimension(); i++){
				vector.setIndexAtVectorInt(i, scalar * vector.getIndexAtVectorInt(i));
			}
		}
		
		return vector;
	}
	

}
