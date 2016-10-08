import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.TbsReaderView;

class sfe
  implements DialogInterface.OnClickListener
{
  sfe(sfc paramsfc, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LocalTbsViewManager.a(this.jdField_a_of_type_Sfc.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager).userStatistics(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("_filename_from_dlg", this.jdField_a_of_type_Sfc.jdField_a_of_type_AndroidAppActivity.getString(2131369305));
    Intent localIntent = new Intent("com.tencent.qfile_unifromdownload");
    localIntent.putExtra("param", paramDialogInterface);
    localIntent.putExtra("url", this.b);
    this.jdField_a_of_type_Sfc.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */