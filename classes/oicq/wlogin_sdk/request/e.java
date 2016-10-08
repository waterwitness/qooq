package oicq.wlogin_sdk.request;

import android.text.TextPaint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class e
  implements Runnable
{
  e(d paramd) {}
  
  private void a(Toast paramToast, int paramInt)
  {
    if (paramInt > 5) {
      return;
    }
    paramToast.show();
    b(paramToast, paramInt);
  }
  
  private void b(Toast paramToast, int paramInt)
  {
    new Timer().schedule(new f(this, paramToast, paramInt), 30L);
  }
  
  public void run()
  {
    if ((d.a(this.a) != null) && (d.b(this.a) != null)) {}
    try
    {
      LinearLayout localLinearLayout = new LinearLayout(d.a(this.a));
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(-7829368);
      localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      Object localObject = new TextView(d.a(this.a));
      ((TextView)localObject).getPaint().setFakeBoldText(true);
      ((TextView)localObject).setText(d.b(this.a).getTitle());
      localLinearLayout.addView((View)localObject, 0, new LinearLayout.LayoutParams(-1, -2));
      localObject = new TextView(d.a(this.a));
      ((TextView)localObject).setText(d.b(this.a).getMessage());
      localLinearLayout.addView((View)localObject, 1, new LinearLayout.LayoutParams(-1, -2));
      localObject = new Toast(d.a(this.a));
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).setDuration(1);
      ((Toast)localObject).setView(localLinearLayout);
      a((Toast)localObject, 0);
      return;
    }
    catch (Exception localException)
    {
      util.printException(localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */