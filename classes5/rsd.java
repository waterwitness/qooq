import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public final class rsd
  implements DialogInterface.OnClickListener
{
  public rsd(String paramString, long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new FileManagerReporter.fileAssistantReportData();
    paramDialogInterface.b = "file_local_qqmusic_download";
    paramDialogInterface.c = this.jdField_a_of_type_JavaLangString;
    paramDialogInterface.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramDialogInterface);
    long l = 0L;
    for (;;)
    {
      try
      {
        paramDialogInterface = new URL("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435");
      }
      catch (MalformedURLException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        continue;
      }
      try
      {
        paramInt = paramDialogInterface.openConnection().getContentLength();
        l = paramInt;
      }
      catch (IOException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
      }
    }
    paramDialogInterface = new Bundle();
    paramDialogInterface.putLong("_filesize_from_dlg", l);
    paramDialogInterface.putString("_filename_from_dlg", this.jdField_a_of_type_AndroidAppActivity.getString(2131369304));
    UniformDownloadMgr.a().b("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435", paramDialogInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rsd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */