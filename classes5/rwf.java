import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.app.UniformDownload;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetFileInfoCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rwf
  implements UniformDownloadUtil.GetFileInfoCallBack
{
  public rwf(UniformDownload paramUniformDownload, Bundle paramBundle, String paramString, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, long paramLong)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "nofilename.x";
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppUniformDownload.a.runOnUiThread(new rwg(this, str, paramLong));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rwf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */