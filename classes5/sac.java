import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sac
  implements Runnable
{
  public sac(UniformDownloadMgr paramUniformDownloadMgr, Bundle paramBundle, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = UniformDownloadUtil.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((UniformDownloadUtil.FileInfo)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((UniformDownloadUtil.FileInfo)localObject).jdField_a_of_type_JavaLangString)) {
        ((UniformDownloadUtil.FileInfo)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((UniformDownloadUtil.FileInfo)localObject).jdField_a_of_type_JavaLangString);
    }
    UniformDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    UniformDownloadMgr.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */