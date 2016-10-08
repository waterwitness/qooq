import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.io.FileInputStream;

class qqd
  extends DownloadListener
{
  qqd(qqc paramqqc, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (paramDownloadTask.z == 0)
    {
      int i;
      try
      {
        i = (int)this.jdField_a_of_type_JavaIoFile.length();
        if (i == 0) {
          throw new Exception("File Length is 0");
        }
      }
      catch (Exception paramDownloadTask)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("post download fail, url=%s, msg=%s", new Object[] { this.jdField_a_of_type_Qqc.jdField_a_of_type_Qqh.jdField_a_of_type_JavaLangString, paramDownloadTask.getMessage() }));
        ArkAppCGI.a(this.jdField_a_of_type_Qqc.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI, this.jdField_a_of_type_Qqc.jdField_a_of_type_Qqh, false, null);
        return;
      }
      paramDownloadTask = new FileInputStream(this.jdField_a_of_type_JavaIoFile);
      byte[] arrayOfByte = new byte[i];
      paramDownloadTask.read(arrayOfByte);
      paramDownloadTask.close();
      this.jdField_a_of_type_JavaIoFile.delete();
      ArkAppCGI.a(this.jdField_a_of_type_Qqc.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI, this.jdField_a_of_type_Qqc.jdField_a_of_type_Qqh, true, arrayOfByte);
      return;
    }
    ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("download fail, url=%s, err=%d", new Object[] { this.jdField_a_of_type_Qqc.jdField_a_of_type_Qqh.jdField_a_of_type_JavaLangString, Integer.valueOf(paramDownloadTask.z) }));
    ArkAppCGI.a(this.jdField_a_of_type_Qqc.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI, this.jdField_a_of_type_Qqc.jdField_a_of_type_Qqh, this.jdField_a_of_type_Qqc.jdField_a_of_type_Qqh.jdField_a_of_type_Qqf, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */