import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class voa
  implements TroopMemberApiClient.Callback
{
  public voa(VideoPlayLogic paramVideoPlayLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ret"))
    {
      VideoPlayLogic.b(this.a);
      return;
    }
    if ((this.a.a != null) && (this.a.a.isShowing() == true)) {
      this.a.a.dismiss();
    }
    this.a.a(this.a.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\voa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */