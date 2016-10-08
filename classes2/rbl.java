import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.FilePicMesProgressTextView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rbl
  extends FMObserver
{
  public rbl(FilePicMesProgressTextView paramFilePicMesProgressTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    while (paramLong2 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
      return;
    }
    this.a.setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    FilePicMesProgressTextView.a(this.a, false);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    do
    {
      do
      {
        return;
      } while (paramLong2 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.a.setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null);
    FilePicMesProgressTextView.a(this.a).a().deleteObserver(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\rbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */