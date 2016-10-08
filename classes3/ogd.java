import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessTypeActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ogd
  implements DialogInterface.OnClickListener
{
  ogd(ogc paramogc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FontSettingManager.a();
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ogd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */