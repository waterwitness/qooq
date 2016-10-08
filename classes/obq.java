import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView.DrawFinishedListener;

public class obq
  implements XListView.DrawFinishedListener
{
  public obq(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((this.a.P) && (!this.a.ad) && (this.a.ae))
    {
      this.a.ad = true;
      PublicTracker.a("SUBSCRIPT_AIO_COST", null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\obq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */