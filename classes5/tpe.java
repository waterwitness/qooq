import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.ProfileQiqiLiveController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class tpe
  extends AsyncTask
{
  public tpe(ProfileQiqiLiveController paramProfileQiqiLiveController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Bundle a(Integer... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("downloadcode", paramVarArgs[0].intValue());
    try
    {
      paramVarArgs = (HttpURLConnection)new URL("http://tiantian.qq.com/qiqimanage/qunpack/android/58.json").openConnection();
      paramVarArgs.setConnectTimeout(5000);
      paramVarArgs.setReadTimeout(30000);
      paramVarArgs.setRequestMethod("GET");
      paramVarArgs.setRequestProperty("Connection", "Keep-Alive");
      paramVarArgs.connect();
      paramVarArgs = new BufferedReader(new InputStreamReader(paramVarArgs.getInputStream()));
      Object localObject = new StringBuffer();
      for (;;)
      {
        String str = paramVarArgs.readLine();
        if (str == null) {
          break;
        }
        ((StringBuffer)localObject).append(str).append("\n");
      }
      localObject = ((StringBuffer)localObject).toString();
      paramVarArgs.close();
      paramVarArgs = new JSONObject((String)localObject);
      if (paramVarArgs.optInt("errCode", -1) == 0)
      {
        paramVarArgs = paramVarArgs.optJSONObject("data");
        if (paramVarArgs != null)
        {
          paramVarArgs = paramVarArgs.optJSONObject("package");
          if (paramVarArgs != null)
          {
            localBundle.putString("DownPackage", paramVarArgs.optString("package"));
            localBundle.putString("DownUrl", paramVarArgs.optString("url"));
            localBundle.putString("DownAppId", paramVarArgs.optString("appid"));
          }
        }
      }
      return localBundle;
    }
    catch (Exception paramVarArgs) {}
    return null;
  }
  
  protected void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.a.d = paramBundle.getString("DownPackage");
      this.a.f = paramBundle.getString("DownUrl");
      this.a.e = paramBundle.getString("DownAppId");
      if ((!TextUtils.isEmpty(this.a.d)) && (!TextUtils.isEmpty(this.a.e)) && (!TextUtils.isEmpty(this.a.f))) {
        this.a.a(paramBundle.getInt("downloadcode"));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */