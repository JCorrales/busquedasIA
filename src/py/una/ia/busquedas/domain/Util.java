
package py.una.ia.busquedas.domain;

/**
 *
 * @author juan
 */
public class Util {
    /**
     * 
     * @param min minimo inclusive
     * @param max maximo inclusive
     * @return 
     */
    public static int randInt(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
    
}
