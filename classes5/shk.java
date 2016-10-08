import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.GetFilePreviewObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class shk
  extends TroopFileProtocol.GetFilePreviewObserver
{
  public shk(ZipPreviewFileView paramZipPreviewFileView, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_JavaLangString = ZipPreviewFileView.a(paramByteStringMicro1);
    if ((paramBoolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("TroopFileZipPreviewActivity", 2, "downURL:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_b_of_type_JavaLangString = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_c_of_type_JavaLangString = ("" + paramInt3);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.d = ZipPreviewFileView.a(paramByteStringMicro1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.e = paramString4;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.d = ZipPreviewFileView.a(paramByteStringMicro1);
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, "" + paramInt3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.d, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_Int, "/", paramString4, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, new shl(this, paramString4, paramString3));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_b_of_type_AndroidViewView.setVisibility(0);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, "" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.jdField_b_of_type_Int, ZipPreviewFileView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName), "1");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */