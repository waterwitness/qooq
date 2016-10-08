import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class wfa
  implements Runnable
{
  public wfa(HealthBusinessPlugin paramHealthBusinessPlugin, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (HealthBusinessPlugin.a)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if ((TextUtils.isEmpty(str1)) || (HealthBusinessPlugin.a.containsKey(str1))) {
            continue;
          }
          str2 = MediaApiPlugin.a(str1, 0);
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("imageID", str1);
        localJSONObject.put("data", str2);
        HealthBusinessPlugin.a.put(str1, localJSONObject);
        continue;
        localObject = finally;
        throw ((Throwable)localObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */