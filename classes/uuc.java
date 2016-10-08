import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.Rdm;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class uuc
  implements Runnable
{
  public uuc(Rdm paramRdm, String paramString) {}
  
  public void run()
  {
    int j = 1;
    for (;;)
    {
      int i;
      Object localObject3;
      String str;
      try
      {
        Object localObject1 = BaseApplicationImpl.a().getSharedPreferences("sp_dex_patch", 4);
        if (!((SharedPreferences)localObject1).getBoolean("enable", false)) {
          return;
        }
        Object localObject2 = ((SharedPreferences)localObject1).getString("process", "");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = ((String)localObject2).split(";");
          int k = localObject2.length;
          i = 0;
          if (i >= k) {
            break label420;
          }
          localObject3 = localObject2[i];
          if (this.jdField_a_of_type_JavaLangString.equals(localObject3))
          {
            i = j;
            break label427;
          }
        }
        else
        {
          localObject2 = "startFailCount" + this.jdField_a_of_type_JavaLangString;
          i = ((SharedPreferences)localObject1).getInt((String)localObject2, 1);
          str = "startFailRetryRound" + this.jdField_a_of_type_JavaLangString;
          j = ((SharedPreferences)localObject1).getInt(str, 0);
          QLog.d("Rdm", 1, "doStep startFailCount=" + i + ", startFailRetryRound=" + j + ", patchInstall result=" + BaseApplicationImpl.j);
          localObject3 = ((SharedPreferences)localObject1).edit();
          localObject1 = ((SharedPreferences)localObject1).getString("name", "");
          if (BaseApplicationImpl.j == 0) {
            break label294;
          }
          StatisticCollector.a(BaseApplicationImpl.a).a("", "actNvwaInstall", BaseApplicationImpl.j, (String)localObject1);
          if (j != 0) {
            ((SharedPreferences.Editor)localObject3).remove(str).commit();
          }
          if (i == 0) {
            break label426;
          }
          ((SharedPreferences.Editor)localObject3).remove((String)localObject2).commit();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      i += 1;
      continue;
      label294:
      if (j >= 3)
      {
        StatisticCollector.a(BaseApplicationImpl.a).a("", "actNvwaInstall", 504, localThrowable);
      }
      else if (i > 5)
      {
        StatisticCollector.a(BaseApplicationImpl.a).a("", "actNvwaInstall", 503, localThrowable);
        if (j < 3) {
          ((SharedPreferences.Editor)localObject3).putInt(str, j + 1).commit();
        }
        if (!TextUtils.isEmpty(localThrowable))
        {
          File localFile = new File("/data/data/com.tencent.mobileqq/files/hotpatch/" + localThrowable);
          if ((localFile != null) && (localFile.exists()))
          {
            localFile.delete();
            continue;
            label420:
            i = 0;
            label426:
            label427:
            while (i == 0) {
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */