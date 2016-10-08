import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import mqq.app.AppRuntime;

public final class hgy
  implements Runnable
{
  public hgy(int paramInt, String paramString, AppRuntime paramAppRuntime, HashMap paramHashMap, AsyncBack paramAsyncBack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (HtmlOffline.a.a()) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "start checkUpThread. delay:" + this.jdField_a_of_type_Int + ", businessId:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int > 0) {}
    try
    {
      Thread.sleep(this.jdField_a_of_type_Int * 1000);
      HtmlOffline.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack, true, true);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */