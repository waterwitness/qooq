import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class icj
  implements Runnable
{
  public icj(ServiceAccountFolderActivity paramServiceAccountFolderActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ServiceAccountFolderManager localServiceAccountFolderManager = ServiceAccountFolderManager.a();
    ServiceAccountFolderActivity.a(this.a, localServiceAccountFolderManager.a());
    ServiceAccountFolderActivity.a(this.a).sendEmptyMessage(101);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\icj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */