import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadApi;

public final class wuw
  implements DialogInterface.OnClickListener
{
  public wuw(Bundle paramBundle, int paramInt, ApkUpdateDetail paramApkUpdateDetail)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DownloadApi.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wuw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */