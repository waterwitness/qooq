import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

class sca
  implements DialogInterface.OnClickListener
{
  sca(sbx paramsbx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.a.a.fileSize == 0L)
    {
      BaseActionBarDataLineFile.b(this.a.a, System.currentTimeMillis());
      FMToastUtil.a("'" + this.a.a.a.fileName + "'" + BaseApplication.getContext().getResources().getString(2131362193));
      return;
    }
    BaseActionBarDataLineFile.e(this.a.a);
    this.a.a.k();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */