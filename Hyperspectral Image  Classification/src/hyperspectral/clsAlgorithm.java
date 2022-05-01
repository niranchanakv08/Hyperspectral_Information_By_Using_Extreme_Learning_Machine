/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hyperspectral;
import java.util.HashMap;
/**
 *
 * @author admin
 */
public abstract class clsAlgorithm extends Thread 
{
    public abstract void process(FeatureMatrix image, ImgObserver observer, HashMap<String, String> params);
}
