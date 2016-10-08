import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class icw
  implements Runnable
{
  public icw(ServiceAccountFolderManager paramServiceAccountFolderManager, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_display_time", ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager));
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_time", ServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager));
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_operation_time", ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager));
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_brief", ServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager).toString());
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d(ServiceAccountFolderManager.b(), 2, "saveFolderLocalData->mFolderDisplayTime:" + ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager) + ", mFolderShowTime:" + ServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager) + ", mFolderOperationTime:" + ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager) + ", mFolderMsgBrief:" + ServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\icw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */