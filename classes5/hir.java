import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.lebasearch.LebaPlugin;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class hir
  implements BusinessObserver
{
  public hir(LebaPlugin paramLebaPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      paramObject = (Bundle)paramObject;
      if (paramObject == null) {
        continue;
      }
      paramInt = ((Bundle)paramObject).getInt("reqCode");
      if (paramInt == 10000)
      {
        str1 = ((Bundle)paramObject).getString("name");
        String str2 = ((Bundle)paramObject).getString("callback");
        String str3 = ((Bundle)paramObject).getString("msg");
        long l = ((Bundle)paramObject).getLong("uiResId");
        this.a.b = str2;
        LebaPlugin.a(this.a, 1, l, str1, str3);
        return;
      }
      if (paramInt != 10002) {
        continue;
      }
      paramBoolean = ((Bundle)paramObject).getBoolean("isOpen");
      String str1 = ((Bundle)paramObject).getString("callback");
      boolean bool = ((Bundle)paramObject).getBoolean("has");
      paramObject = new JSONObject();
      if (bool) {
        if (paramBoolean) {
          paramInt = 1;
        }
      }
      try
      {
        label153:
        ((JSONObject)paramObject).put("isOpen", paramInt);
        while (!TextUtils.isEmpty(str1))
        {
          this.a.callJs(str1, new String[] { ((JSONObject)paramObject).toString() });
          return;
          paramInt = 0;
          break label153;
          ((JSONObject)paramObject).put("isOpen", 1);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
      paramObject = new JSONObject();
      if (paramBoolean) {}
      try
      {
        ((JSONObject)paramObject).put("userOption", 1);
        while (!TextUtils.isEmpty(this.a.b))
        {
          this.a.callJs(this.a.b, new String[] { ((JSONObject)paramObject).toString() });
          this.a.b = null;
          return;
          ((JSONObject)paramObject).put("userOption", 0);
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */