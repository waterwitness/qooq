package mqq.app;

import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public abstract class AppContentProvider
  extends ContentProvider
{
  public String getModuleId()
  {
    return null;
  }
  
  public AppRuntime getRuntime(String paramString)
  {
    try
    {
      paramString = ((MobileQQ)getContext().getApplicationContext()).getAppRuntime(paramString).getAppRuntime(getModuleId());
      return paramString;
    }
    catch (AccountNotMatchException paramString)
    {
      paramString.printStackTrace();
      QLog.e("mqq", 2, Log.getStackTraceString(paramString));
    }
    return null;
  }
  
  public boolean onCreate()
  {
    ((MobileQQ)getContext().getApplicationContext()).onCreate();
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\app\AppContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */