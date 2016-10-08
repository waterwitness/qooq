import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.qphone.base.util.QLog;

public class unc
  implements AsyncBack
{
  public unc(PAOfflineSearchManager paramPAOfflineSearchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      paramString = HtmlOffline.d("1011");
      if ((paramString != null) && (!TextUtils.equals(paramString, ""))) {
        break label24;
      }
    }
    label24:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PAOfflineSearchManager", 2, "callback get current ver:" + paramString + ", local ver:" + this.a.b);
      }
    } while ((paramString.equals(this.a.b)) && (!paramString.equals("0")));
    this.a.c = true;
    this.a.b = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\unc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */