import android.os.Handler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class sgc
  implements sgs
{
  public sgc(OfflineVideoFileView paramOfflineVideoFileView, TroopInfo paramTroopInfo, TroopManager paramTroopManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "OfflineVideoFileView initVarView() is_white = " + paramInt1 + ", req_interval = " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileView.f = paramInt1;
    if (paramInt1 != 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileView.a.sendMessage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileView.a.obtainMessage(3));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopFileVideoIsWhite = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopFileVideoReqInterval = (System.currentTimeMillis() + paramInt2 * 1000);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileView.a.sendMessage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileView.a.obtainMessage(4));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */