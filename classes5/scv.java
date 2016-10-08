import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class scv
  extends BizTroopObserver
{
  public scv(ActionBarTroopFile paramActionBarTroopFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin != ((TroopFileStatusInfo)paramObject).jdField_a_of_type_Long) {
      if (QLog.isDevelopLevel()) {
        QLog.d("troopFileActionbar", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(this.a.b))
      {
        TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
          this.a.b = localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString();
        }
      }
    } while ((((TroopFileStatusInfo)paramObject).jdField_a_of_type_JavaUtilUUID == null) || (this.a.b == null) || (!this.a.b.equals(((TroopFileStatusInfo)paramObject).jdField_a_of_type_JavaUtilUUID.toString())));
    this.a.a((TroopFileStatusInfo)paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\scv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */