import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.HYConfigLoader.GetConfigListener;
import cooperation.huangye.HYEntranceManager;
import org.json.JSONException;
import org.json.JSONObject;

public class ycn
  implements HYConfigLoader.GetConfigListener
{
  public ycn(HYEntranceManager paramHYEntranceManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return;
    }
    try
    {
      i = new JSONObject(paramString).getInt("entrance");
      paramString = this.a;
      if (i != 0)
      {
        HYEntranceManager.a(paramString, paramQQAppInterface, bool);
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int i = 1;
        continue;
        bool = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ycn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */