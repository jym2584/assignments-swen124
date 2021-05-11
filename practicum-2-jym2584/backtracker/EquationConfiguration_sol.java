package backtracker;

import java.util.*;

public class EquationConfiguration_sol implements Configuration{
    private static int N; //number of variables
    private int[] variables ; // {x0, x1, ..., xN-1}
    private static int[] A; // {A0, A1, ..., AN-1}
    private static int B;   
    private static int[] VALUES; 
    private int cursor; 
    
    public EquationConfiguration_sol(int[] a, int b, int[] values){
        N = a.length;
        this.variables = new int[N]; 
        A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = a[i];
        }
        VALUES = new int[values.length];
        for(int i = 0; i<values.length; i++){
            VALUES[i] = values[i];
        }
        B = b;
        this.cursor = -1;
    }

    public EquationConfiguration_sol(int[] newVariables, int cursor){
        this.variables = newVariables;
        this.cursor = cursor;
    }

    @Override
    public Collection<Configuration> getSuccessors(){
        Collection<Configuration> successors = new ArrayList<>();
        for(int i=0; i<VALUES.length; i++){
            int[] newVariables = Arrays.copyOf(this.variables, N);
            newVariables[cursor+1] = VALUES[i];
            EquationConfiguration_sol successor = new EquationConfiguration_sol(newVariables, cursor+1);
            successors.add(successor);
        }
        return successors;
    }

    @Override
    public boolean isValid(){
        int computedSum = 0;
        if(cursor == N-1){
            for(int i=0; i<N; i++){
                computedSum += A[i]*variables[i];
            }
            return B == computedSum;
        }
        return true;
    }
    @Override
    public boolean isGoal(){
        return cursor == N-1;
    }
    @Override
    public String toString(){
        String string = "";
        for(int i=0; i<variables.length; i++){
            string += A[i] + "*" + variables[i] + " + ";
        }
        string = string.substring(0, string.length()-2);
        string += " = " + B + " ? ";
        return string;
    } 
    public static void main(String[] args) {

        // Solve 1*x0 + 4*x1 - 3*x2 = 8 using values = {3, 5}

        Backtracker backtracker = new Backtracker(false);
        int[] a = {1, 4, -3}; 
        int b = 8;
        int[] values = {3, 5};
        Configuration initconfig = new EquationConfiguration_sol(a, b, values); 
        Configuration goal = backtracker.solve(initconfig);
        if(goal == null){
            System.out.println("no sol");
        }
        else{
            System.out.println(goal);
        }    

        // Solve  -5*x0 + 3*x1 - 1*x2 - 2*x3 + 4*x4 = 20 using values = {1, 2, 3, 5}    
        /* 
        Backtracker backtracker = new Backtracker(false);  
        int[] a = {-5, 3, -1, -2, 4}; 
        int b = 20;
        int[] values = {1, 2, 3, 5};
        Configuration initconfig = new EquationConfiguration_sol(a, b, values); 
        Configuration goal = backtracker.solve(initconfig);
        if(goal == null){
            System.out.println("no sol");
        }
        else{
            System.out.println(goal);
        }    
        */
          
    }    
}
