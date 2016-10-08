import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.FileInfo;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetFileInfoCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class sjo
  implements Runnable
{
  public sjo(String paramString, UniformDownloadUtil.GetFileInfoCallBack paramGetFileInfoCallBack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    UniformDownloadUtil.FileInfo localFileInfo = UniformDownloadUtil.a(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadUtil$GetFileInfoCallBack != null) && (localFileInfo != null)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadUtil$GetFileInfoCallBack.a(localFileInfo.jdField_a_of_type_JavaLangString, localFileInfo.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */