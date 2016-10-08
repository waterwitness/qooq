import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.InetAddress;
import java.net.URL;

public final class jdo
  implements Runnable
{
  public jdo(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      URL localURL = new URL(this.a);
      String str = InetAddress.getByName(localURL.getHost()).getHostAddress();
      if (!TextUtils.isEmpty(str)) {
        BaseApplicationImpl.getContext().getSharedPreferences("qbiz_host_ip_map", 0).edit().putString(localURL.getHost(), str).commit();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */