import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;

public class mwt
  implements View.OnClickListener
{
  public mwt(TroopRequestActivity paramTroopRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a.u;
    TroopNoticeJsHandler.a(this.a, paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */