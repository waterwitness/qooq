import android.app.Activity;
import android.app.Instrumentation;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kfz
  extends Instrumentation
{
  private kfz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void callActivityOnDestroy(Activity paramActivity)
  {
    LeakInspector.a().callActivityOnDestroy(paramActivity);
    LeakInspector.a(paramActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */