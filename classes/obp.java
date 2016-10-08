import android.widget.ImageView;
import com.tencent.biz.pubaccount.ecshopassit.EcShopObserver;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class obp
  extends EcShopObserver
{
  public obp(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (PublicAccountChatPie.a(this.a).getVisibility() == 8))
    {
      PublicAccountChatPie.b(this.a).setVisibility(0);
      PublicAccountChatPie.c(this.a).setOnClickListener(this.a);
      PublicAccountChatPie.d(this.a).setImageResource(2130841672);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\obp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */