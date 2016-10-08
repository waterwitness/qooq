import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class pqb
  extends DownloadListener
{
  public pqb(ApolloManager paramApolloManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    try
    {
      super.onDone(paramDownloadTask);
      if (paramDownloadTask.a() != 3) {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(Boolean.valueOf(false));
      }
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      this.a.a();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", localException);
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "download panel json done httpCode: " + paramDownloadTask.D + ", status: " + paramDownloadTask.a());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */