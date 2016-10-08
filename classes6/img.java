import com.tencent.biz.qqstory.pgc.view.FullScreenVideoHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Method;

public class img
  implements Runnable
{
  public img(FullScreenVideoHelper paramFullScreenVideoHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Method[] arrayOfMethod = this.a.jdField_a_of_type_AndroidWidgetFrameLayout.getClass().getDeclaredMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        String str = localMethod.getName();
        if ((str.contains("remove")) && (str.contains("Control")))
        {
          localMethod.setAccessible(true);
          localMethod.invoke(this.a.jdField_a_of_type_AndroidWidgetFrameLayout, new Object[0]);
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\img.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */