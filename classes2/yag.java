import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.util.WeakReferenceHandler;
import cooperation.comic.VipComicJumpActivity;
import cooperation.plugin.IPluginManager;

public class yag
  extends OnPluginInstallListener.Stub
{
  public yag(VipComicJumpActivity paramVipComicJumpActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      paramInt1 = (int)(paramInt1 / paramInt2 * 95.0F);
      this.a.a.obtainMessage(1000, paramInt1, 0).sendToTarget();
      this.a.c = System.currentTimeMillis();
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    IPluginManager.a(String.valueOf(paramInt), "动漫");
    VipComicJumpActivity.a(this.a, paramInt);
    this.a.finish();
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.a.obtainMessage(1002, 99, 0).sendToTarget();
    this.a.d = System.currentTimeMillis();
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */