import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

class wvs
  implements DialogInterface.OnClickListener
{
  wvs(wvq paramwvq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.a);
      String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.i);
      String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.e);
      String str3 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.h);
      String str4 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.k);
      boolean bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean(DownloadConstants.x, true);
      paramDialogInterface = new DownloadInfo(paramDialogInterface, str1.trim(), str2, str4, str3, null, this.a.jdField_a_of_type_Int, bool);
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(10, paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */