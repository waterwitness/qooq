import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.UpdateManager;

public class wvp
  implements Runnable
{
  public wvp(DownloadManager paramDownloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = null;
    if (UpdateManager.a()) {
      UpdateManager.a().a();
    }
    if (MyAppApi.d()) {
      MyAppApi.a().h();
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */