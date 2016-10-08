import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopCommentBrowser;
import com.tencent.mobileqq.widget.QQToast;

public class vpg
  implements TroopMemberApiClient.Callback
{
  public vpg(TroopCommentBrowser paramTroopCommentBrowser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("errorCode");
    int j = this.a.getResources().getDimensionPixelSize(2131492908);
    if (i == 0)
    {
      QQToast.a(this.a.getApplicationContext(), 0, this.a.getString(2131365204), 1).b(j);
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131365205), 1).b(j);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */