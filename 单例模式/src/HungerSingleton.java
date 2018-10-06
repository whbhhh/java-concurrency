/**
 * @author 海想着你
 * @create 2018-09-30 19:50
 */

/**
 * 饿汉式
 */
public class HungerSingleton {
    private static HungerSingleton instance = new HungerSingleton();
    private HungerSingleton(){}
    public static HungerSingleton getInstance(){
        return instance;
    }
}
