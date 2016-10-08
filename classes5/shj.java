import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopPhotoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class shj
  extends BizTroopObserver
{
  shj(shi paramshi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    if (QLog.isDevelopLevel()) {
      QLog.d(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewTroopPhotoFileView.a, 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(((TroopFileStatusInfo)paramObject).b), ((TroopFileStatusInfo)paramObject).g, Integer.valueOf(((TroopFileStatusInfo)paramObject).jdField_c_of_type_Int) }));
    }
    if ((((TroopFileStatusInfo)paramObject).jdField_c_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewTroopPhotoFileView.a(((TroopFileStatusInfo)paramObject).e, ((TroopFileStatusInfo)paramObject).jdField_c_of_type_JavaLangString);
    }
    if ((((TroopFileStatusInfo)paramObject).a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewTroopPhotoFileView.b != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewTroopPhotoFileView.b.equals(((TroopFileStatusInfo)paramObject).a.toString()))) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */