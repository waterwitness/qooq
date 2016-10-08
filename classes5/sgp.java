import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingTroopFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.PreviewInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class sgp
  extends BizTroopObserver
{
  sgp(sgo paramsgo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void c(Object paramObject)
  {
    TroopFileTransferManager.PreviewInfo localPreviewInfo = (TroopFileTransferManager.PreviewInfo)paramObject;
    if ((localPreviewInfo.a) && (TextUtils.isEmpty(localPreviewInfo.d)))
    {
      localPreviewInfo.a = false;
      paramObject = BaseApplicationImpl.getContext().getString(2131362775);
      if (QLog.isColorLevel()) {
        QLog.i("PreviewStep_1", 2, "FAILED onFetchPreviewInfo harcode[" + FMConfig.a + "],server return true,but downloadKey is null, rcmsg[" + (String)paramObject + "]");
      }
      return;
    }
    if (localPreviewInfo.a) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$PreviewInfo = localPreviewInfo;
    }
    for (;;)
    {
      super.c(paramObject);
      return;
      Activity localActivity = PreviewingTroopFileView.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingTroopFileView);
      localActivity.runOnUiThread(new sgq(this, localPreviewInfo, localActivity));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */