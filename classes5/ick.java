import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class ick
  implements Runnable
{
  public ick(ServiceAccountFolderActivity paramServiceAccountFolderActivity, ServiceAccountFolderManager paramServiceAccountFolderManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.app);
    ServiceAccountFolderActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).sendEmptyMessage(100);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */