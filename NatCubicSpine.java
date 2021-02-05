/*
 * Create a program that uses the Natural Cubic Spline Algorithm to calculate the coefficients of the natural cubic spline. 
 *
 * CSC 2262 Natural Cubic Spline Algorithm
 *
 * @author Luke Higginbotham 899568628
 * @since 10/5/2020 
 */
package natcubicspine;


public class NatCubicSpine 
{

    public static void main(String[] args) 
    {
        System.out.println("_______________________________________________________");
        System.out.printf("j\txj\taj=f(xj)\tbj\tcj\tdj\n");
        System.out.println("_______________________________________________________");
        double x[] = {17.0, 20.0, 23.0, 24.0, 25.0, 27.0, 27.7};
        int n = 6;
        double h[] = new double[8];
        double a[] = {4.5,7.0,6.1,5.6,5.8,5.2,4.1};
        double alpha[]= new double[8];
        for (int i = 0; i < n; i++)
        {
            h[i] = x[i+1] - x[i];
        }
        for (int i = 1; i < n; i++)
        {
            alpha[i] = (3 * (a[i+1] * h[i-1] - (a[i] * (x[i+1] - x[i-1])) + a[i-1] * h[i])) / (h[i-1] * h[i]);
        }
        double l[] = new double[8];
        double mi[] = new double[8];
        double z[] = new double[8];
        double c[] = new double[8];
        double b[] = new double[8];
        double d[] = new double[8];
        
        l[0] = 1;
        mi[0] = 0;
        z[0] = 0;
        
        for (int i = 1; i < n; i++)
        {
            l[i] = 2 * (x[i+1] - x[i-1]) - h[i-1] * mi[i-1];
            mi[i] = h[i] / l[i];
            z[i] = (alpha[i] - h[i-1] * z[i-1]) / l[i];
        }
        l[n] = 1;
        z[n] = 0;
        c[n] = 0;
        
        for (int j = n-1; j >= 0; j--)
        {
            double aj[] = {4.5,7.0,6.1,5.6,5.8,5.2,4.1};
            c[j] = z[j] - mi[j] * c[j+1];
            b[j] = ((a[j+1] - a[j]) / h[j]) - (h[j] * (c[j+1] + 2 * c[j]) / 3);
            d[j] = (c[j+1] - c[j]) / (3 * h[j]);
            System.out.printf("%d\t%2.1f\t%2.1f\t\t%1.3f\t%1.3f\t%1.3f\n", j, x[j],aj[j],b[j], c[j], d[j]);
        }
        System.out.println("_______________________________________________________");
    }
    
}
