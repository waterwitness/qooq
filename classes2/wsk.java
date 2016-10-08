import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

public final class wsk
  implements Runnable
{
  public wsk(String paramString1, Bundle paramBundle1, String paramString2, Activity paramActivity, Intent paramIntent, Bundle paramBundle2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (MyAppApi.a().c())
    {
      DownloadInfo localDownloadInfo = DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
      if (localDownloadInfo != null)
      {
        if (localDownloadInfo.h == 1)
        {
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, localDownloadInfo.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, localDownloadInfo.i);
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.c, localDownloadInfo.j);
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.h, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.e, localDownloadInfo.d);
          this.jdField_a_of_type_AndroidOsBundle.putInt(DownloadConstants.d, localDownloadInfo.g);
          MyAppApi.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, false, false);
          return;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
        return;
      }
      if ((this.jdField_b_of_type_AndroidOsBundle != null) && (this.jdField_b_of_type_AndroidOsBundle.containsKey(DownloadConstants.e)))
      {
        this.jdField_a_of_type_AndroidOsBundle.putAll(this.jdField_b_of_type_AndroidOsBundle);
        MyAppApi.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, false, false);
        return;
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */