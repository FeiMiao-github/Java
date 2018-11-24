/*捕获异常 */
package exceptionDemo.try_catch_finally;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CatchException {
    public static void main(String[] args) {

    }
    
    public void read(String filename) {
        try {
            InputStream in = new FileInputStream(filename);
            int b;
            while((b = in.read()) != -1){
                // todo
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 
            System.out.println("可能会抛出异常");
        }
        // 不允许在子类中的异常超过超类中的异常
    }
}