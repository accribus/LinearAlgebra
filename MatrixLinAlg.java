

/**
 * 
 * THIS CLASS IS NOT YET COMPLETE
 * 
 * This class defines matrices in the linear algebra sense.  Matrices are treated
 * as a collection (a Java List) of vectors.  A matrix is 
 * a mathematical object of M rows and N columns.  So matrix can be thought of
 * as collection of m vectors of dimension n.
 * @author Accribus
 */

import java.util.ArrayList;


public class MatrixLinAlg extends VectorLinAlg {
    
    
    private ArrayList<VectorLinAlg> vectors = new ArrayList<VectorLinAlg>();
    private int columns = 0;
    private int rows = 0;

    /**
     * A basic constructor that creates a vector of M rows
     * @param mRows 
     */
    public MatrixLinAlg(int mRows) {
        this.rows = mRows;
        vectors.ensureCapacity(this.rows);
    }
    /**
     * A basic constructor that creates an M x N matrix
     * @param mRows
     * @param nCols 
     */
    public MatrixLinAlg(int mRows, int nCols){
        
        this.rows = mRows;
        this.columns = nCols;
        vectors.ensureCapacity(mRows);
    }
    
    /**
     * This method affects only the first row of the matrix
     * @param i
     * @return value at i
     */
    @Override
    public double getIndexAtVector(int i){
        return 0;
    }
    
    /**
     * This method affects only the first row of the matrix
     * @param i
     * @param val 
     */
    @Override
    public void setIndexAtVector(int i, double val){
		
    }
    
    /**
     * The N in an MxN matrix is the dimension of any 
     * component vector.
     * 
     * @return the dimension of the component vectors 
     */
    @Override
    public int getDimension(){
			
        return 0;
    }
    
}
