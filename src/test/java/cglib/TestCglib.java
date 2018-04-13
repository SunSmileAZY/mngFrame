package cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by anzy on 2018/4/12.
 */
public class TestCglib {
    public static void main(String args[]) {
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject2=(TargetObject)enhancer.create();
        System.out.println("========================");
        targetObject2.method1("mmm1");
        System.out.println("========================");
        targetObject2.method2(100);
        System.out.println("========================");
        targetObject2.method3(200);
    }
}
