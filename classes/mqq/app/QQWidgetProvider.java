package mqq.app;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class QQWidgetProvider
  extends AppWidgetProvider
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    ((MobileQQ)paramContext.getApplicationContext()).onActivityCreate(this, paramIntent);
    onReceive(((MobileQQ)paramContext.getApplicationContext()).waitAppRuntime(null), paramContext, paramIntent);
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\app\QQWidgetProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */