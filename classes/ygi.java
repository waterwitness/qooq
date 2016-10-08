import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;

public final class ygi
  extends Thread
{
  public ygi(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PluginManagerHelper.getPluginInterface(this.jdField_a_of_type_AndroidContentContext, new ygj(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ygi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */