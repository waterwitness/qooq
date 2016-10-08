package cooperation.qqfav;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import ygk;

public abstract class QfavHelper$AsyncFavoritesProvider
  extends OnPluginInstallListener.Stub
{
  public static final long a = 1L;
  public static final String a = "req_opt_type";
  public static final long b = 2L;
  public static final String b = "req_biz_type";
  public static final long c = 3L;
  public static final String c = "req_biz_key";
  public static final long d = 2L;
  public static final String d = "req_fav_uin";
  public static final String e = "req_fav_id";
  public static final String f = "rsp_fav_id";
  public Bundle a;
  
  public QfavHelper$AsyncFavoritesProvider(Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBundle;
  }
  
  public void a()
  {
    QfavHelper.a(BaseApplication.getContext(), this);
  }
  
  public abstract void a(boolean paramBoolean, Bundle paramBundle);
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    a(false, this.a);
  }
  
  public void onInstallFinish(String paramString)
  {
    ThreadManager.b().post(new ygk(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qqfav\QfavHelper$AsyncFavoritesProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */