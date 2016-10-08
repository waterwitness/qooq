import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

class rpw
  implements Runnable
{
  rpw(rpv paramrpv)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DownloadManager.a().a(UniformDownloadActivity.a(this.a.a));
    MyAppApi.a().a(this.a.a, "http://a.app.qq.com/o/myapp-down?g_f=1001647", "ANDROIDQQ.WIFIDLYYB.GAME", 2, true);
    OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3004", false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */