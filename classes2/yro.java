import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.font.FontInterface.TrueTypeResult;
import cooperation.qzone.webviewplugin.QzonePersonalizeJsPlugin;

public class yro
  implements FontInterface.TrueTypeResult
{
  public yro(QzonePersonalizeJsPlugin paramQzonePersonalizeJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(QzonePersonalizeJsPlugin.a(), 4, "FontInterface.TrueTypeResult font:" + paramInt + ", fontPath:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      QzonePersonalizeJsPlugin.a(this.a, paramString2, -2, "font download failed.");
      return;
    }
    QzonePersonalizeJsPlugin.a(this.a, paramString2, 0, "success");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */