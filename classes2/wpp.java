import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.base.LogUtility;
import java.util.HashMap;

public final class wpp
  implements Runnable
{
  public wpp(Context paramContext, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      OpenAppClient.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
    catch (Exception localException)
    {
      String str = "onPushMsg exception: " + this.jdField_a_of_type_JavaUtilHashMap;
      LogUtility.c(OpenAppClient.a, str, localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */