/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clase10;

import bancoarg.Cuenta;
import bancoarg.CuentaInversion;
import bancoarg.Filtrable;

/**
 *
 * @author philip
 */
public class Cliente implements Comparable, Filtrable
{
    private int mNro;
    private String mNombre;
    private Cuenta mCta;

    public int getNro()
    {
        return mNro;
    }

    public String getNombre()
    {
        return mNombre;
    }

    public void setNombre(String mNombre)
    {
        this.mNombre = mNombre;
    }
    
    public Cuenta getCuenta()
    {
        return mCta;
    }
    
    public Cliente(int pNro, String pNombre, Cuenta pCta)
    {
        this.mNro = pNro;
        this.mNombre = pNombre;
        this.mCta = pCta;
           
    }
    
    public Cliente(int pNro, String pNombre, int pNroCta, double pSaldo)
    {
        this.mNro = pNro;
        this.mNombre = pNombre;
        this.mCta = new CuentaInversion(pNroCta, pSaldo);
    }
    
    public Cliente(int pNro, String pNombre, int pNroCta, double pSaldo, boolean pDesc)
    {
        this.mNro = pNro;
        this.mNombre = pNombre;
        this.mCta = new CuentaCorriente(pNroCta, pSaldo, pDesc);
    }
    
    public String toString()
    {
       StringBuffer wRes = new StringBuffer();
       wRes.append("****************************");
       wRes.append("\nNro:\t" + mNro);
       wRes.append("\nNombre:\t" + mNombre );
       wRes.append("\nCuenta:\n" + mCta.toString());
       
       return wRes.toString();
       
    }

    public int compareTo(Object o) 
    {
        int wRes = 0;
        if (o instanceof Cliente)
        {
            Cliente aux = (Cliente) o;
            if (mNro != aux.getNro())
            {
                if (mNro < aux.getNro())
                    wRes = -1;
                else
                    wRes = 1;
            }
            
            //wRes = mNro - aux.getNro();
        }
        else
            throw new RuntimeException("El tipo del objeto debe ser cliente");
        
        return wRes;

    }

    public boolean pertenece(String pToken)
    {
        boolean wRes = false;
        if (mNombre.contains(pToken))
            wRes = true;
        if (mCta.pertenece(pToken))
            wRes = true;
        return wRes;
    }
    
    
}
