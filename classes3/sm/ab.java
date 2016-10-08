package sm;

import android.content.Intent;
import com.tencent.securemodule.impl.AppInfo;
import com.tencent.securemodule.impl.SecureService;
import java.util.ArrayList;

public class ab
  extends y
{
  private int b = 0;
  
  public ab(SecureService paramSecureService) {}
  
  public void a()
  {
    SecureService.a(this.a, "1000020", null);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(ArrayList<AppInfo> paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      SecureService.a(this.a, "1000022", paramArrayList);
      Intent localIntent = new Intent();
      localIntent.setAction("1000030");
      localIntent.putExtra("key_rise", paramArrayList);
      this.a.sendBroadcast(localIntent);
      return;
    }
    if (this.b != 0) {
      SecureService.a(this.a, "1000023", null);
    }
    for (;;)
    {
      paramArrayList = new Intent();
      paramArrayList.setAction("1000031");
      paramArrayList.putExtra("key_errcode", this.b);
      this.a.sendBroadcast(paramArrayList);
      return;
      SecureService.a(this.a, "1000021", null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */