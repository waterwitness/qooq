import com.tencent.image.URLDrawable.DebuggableCallback;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class utv
  implements URLDrawable.DebuggableCallback
{
  private Set a = new HashSet();
  
  public boolean isNeedSample()
  {
    return UnifiedMonitor.a().whetherReportThisTime(2);
  }
  
  public void onDebug(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 5);
    String str2 = (String)paramObject[0];
    String str3 = (String)paramObject[1];
    String str4 = (String)paramObject[2];
    String str1 = (String)paramObject[3];
    paramObject = (Exception)paramObject[4];
    for (;;)
    {
      try
      {
        Object localObject = str2.split("\\(|,|\\)");
        paramInt = Integer.parseInt(localObject[1]);
        int i = Integer.parseInt(localObject[2]);
        localObject = str3.split("\\(|,|\\)");
        int j = Integer.parseInt(localObject[1]);
        int k = Integer.parseInt(localObject[2]);
        if ((j <= 0) || (k <= 0)) {
          break;
        }
        if ((paramInt > 0) && (i > 0))
        {
          j = Math.max(Math.round(j / paramInt), Math.round(k / i));
          if (j >= 2)
          {
            paramInt = i * paramInt * (j * j - 1);
            if (paramInt <= 0) {
              break;
            }
            paramInt = paramInt * 4 / 1024;
            localObject = new HashMap(8);
            paramObject = InitUrlDrawable.a((Exception)paramObject);
            if (paramObject == null) {
              break label316;
            }
            ((Map)localObject).put("stack", paramObject);
            ((Map)localObject).put("viewsize", str2);
            ((Map)localObject).put("picsize", str3);
            if (str4 != null)
            {
              paramObject = str4.replace('&', ' ');
              ((Map)localObject).put("img_url", paramObject);
              UnifiedMonitor.a().addEvent(2, str1, paramInt, 0, (Map)localObject);
              return;
            }
            paramObject = "";
            continue;
          }
          paramInt = 0;
          continue;
        }
        paramInt = j * k;
      }
      catch (Throwable paramObject)
      {
        return;
      }
      continue;
      label316:
      paramObject = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\utv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */