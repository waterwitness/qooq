import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin;

public class yrv
  implements DialogInterface.OnClickListener
{
  public yrv(QzoneQunFeedJsPlugin paramQzoneQunFeedJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */