import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;

public class win
  implements TroopMemberApiClient.Callback
{
  public win(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("fontSize", 1);
    if (i != this.a.j)
    {
      this.a.j = i;
      this.a.b(this.a.j);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\win.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */