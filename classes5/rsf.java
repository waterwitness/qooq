import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rsf
  implements DialogInterface.OnClickListener
{
  public rsf(String paramString, long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new FileManagerReporter.fileAssistantReportData();
    paramDialogInterface.b = "file_local_qqbrowse_download";
    paramDialogInterface.c = this.jdField_a_of_type_JavaLangString;
    paramDialogInterface.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramDialogInterface);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("_filename_from_dlg", this.jdField_a_of_type_AndroidAppActivity.getString(2131369305));
    UniformDownloadMgr.a().a("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10386", paramDialogInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rsf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */