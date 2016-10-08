import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.widget.HongBaoListView;

public class ttp
  implements Runnable
{
  public ttp(ConversationHongBao paramConversationHongBao)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.getScrollY() == 0) {}
    do
    {
      do
      {
        return;
        if (this.a.k != 4) {
          break;
        }
        this.a.a.setSpringbackOffset(-this.a.h);
      } while (Math.abs(this.a.a.getScrollY() + this.a.h) <= this.a.h * 1.0F / 13.0F);
      this.a.a.d(-this.a.h);
      return;
      this.a.a.setSpringbackOffset(0);
    } while (this.a.a.getScrollY() == 0);
    this.a.a.d(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ttp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */