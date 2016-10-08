import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rvx
  implements Runnable
{
  public rvx(FileTransferHandler paramFileTransferHandler, int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, OnlineFileSessionInfo paramOnlineFileSessionInfo, long paramLong2, int paramInt3)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Short, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataOnlineFileSessionInfo, this.jdField_b_of_type_Long, this.jdField_c_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rvx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */