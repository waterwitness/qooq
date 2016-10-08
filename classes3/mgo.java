import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public class mgo
  implements Runnable
{
  public mgo(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    if (this.a.a == null) {
      return;
    }
    Message localMessage = this.a.a.obtainMessage();
    localMessage.what = 2;
    localMessage.obj = null;
    Object localObject = new File(QQSettingMsgHistoryActivity.d);
    if ((((File)localObject).isFile()) && (((File)localObject).exists()))
    {
      localObject = FileUtils.a((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject).getJSONObject("data").getJSONArray("chatHistoryEventConfig");
      if (((JSONArray)localObject).length() <= 0) {
        break label271;
      }
      localJSONObject = ((JSONArray)localObject).getJSONObject(0);
      if (!localJSONObject.has("EndTime")) {
        break label284;
      }
      localObject = localJSONObject.getString("EndTime");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label271;
      }
      localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject);
      long l = NetConnInfoCenter.getServerTimeMillis();
      if (localJSONObject.has("isShow")) {
        i = localJSONObject.getInt("isShow");
      }
      if ((Long.valueOf(l).longValue() >= ((Date)localObject).getTime()) || (i != 1)) {
        break label271;
      }
      localmgv = new mgv(this.a, null);
      if (!localJSONObject.has("EventName")) {
        break label334;
      }
      localObject = localJSONObject.getString("EventName");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        mgv localmgv;
        label271:
        label284:
        if (QLog.isColorLevel())
        {
          QLog.d("IphoneTitleBarActivity", 2, "parse EventConfig failed: " + localException.getMessage());
          continue;
          String str = "";
          continue;
          str = "";
        }
      }
    }
    localmgv.a = ((String)localObject);
    if (localJSONObject.has("URL"))
    {
      localObject = localJSONObject.getString("URL");
      localmgv.b = ((String)localObject);
      if (localJSONObject.has("new_guide")) {}
      for (localObject = localJSONObject.getString("new_guide");; localObject = "")
      {
        localmgv.c = ((String)localObject);
        localMessage.obj = localmgv;
        this.a.a.sendMessage(localMessage);
        return;
        localObject = "";
        break;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */