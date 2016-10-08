import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.RequestPublicAccountObserver;

public class mxg
  extends TroopBindPubAccountProtocol.RequestPublicAccountObserver
{
  public mxg(TroopRequestActivity paramTroopRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if ((paramBoolean) && (paramAccountDetail != null))
    {
      this.a.n.setText(paramAccountDetail.name);
      this.a.b.setVisibility(0);
      this.a.e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */