import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin;

public class yrt
  implements DialogInterface.OnClickListener
{
  public yrt(QzoneQunFeedJsPlugin paramQzoneQunFeedJsPlugin, String[] paramArrayOfString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QzoneQunFeedJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneQunFeedJsPlugin, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */