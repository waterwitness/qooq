import android.os.Bundle;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeUnzipListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class qgr
  implements ThemeDownloader.ThemeUnzipListener
{
  public qgr(ThemeHandler paramThemeHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle, int paramInt, ThemeDownloader paramThemeDownloader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeHandler", 2, "mThemeDownloadListener onUnzipCallback stateCode:" + paramInt);
    }
    if ((paramInt == 1) || (paramInt == 3))
    {
      if (1 == paramBundle.getInt("themeType", 0))
      {
        paramBundle.putString("themeStatus", "5");
        paramThemeDownloader = paramBundle.getString("themeId");
        String str = paramBundle.getString("version");
        ThemeUtil.setSkinTheme(this.a.a, paramThemeDownloader, str, paramBundle);
      }
      return;
    }
    QLog.d("Theme.ThemeHandler", 2, "mThemeDownloadListener onUnzipCallback Error stateCode:" + paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */