import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class wfp
  implements Runnable
{
  public wfp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = BaseApplicationImpl.a().getSharedPreferences("WebView_X5_Report", 4);
        long l = ((SharedPreferences)localObject1).getLong("read_vas_asyncCookie", 0L);
        if (System.currentTimeMillis() - l < 600000L) {
          return;
        }
        ((SharedPreferences)localObject1).edit().putLong("read_vas_asyncCookie", System.currentTimeMillis()).commit();
        localObject1 = FileUtils.a(new File(BaseApplicationImpl.getContext().getFilesDir(), ClubContentJsonTask.i.b));
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          break;
        }
        localObject1 = new JSONObject((String)localObject1);
        if ((localObject1 != null) && (((JSONObject)localObject1).has("cookies")))
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("cookies");
          if (localObject1 == null) {
            break;
          }
          VasWebviewUtil.mAsyncCookiesForVas.clear();
          Iterator localIterator = ((JSONObject)localObject1).keys();
          if (!localIterator.hasNext()) {
            break;
          }
          String str1 = (String)localIterator.next();
          String str2 = ((JSONObject)localObject1).getString(str1);
          VasWebviewUtil.mAsyncCookiesForVas.put(str1, str2);
          QLog.i("VasWebviewUtil", 1, "use async cookies, vas business id: " + str1 + ", value:" + str2);
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasWebviewUtil", 2, "preparePareAsyncCookie UnKnownHost Exception!", localException);
        }
        VasWebviewUtil.mAsyncCookiesForVas.clear();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */