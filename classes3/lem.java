import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lem
  implements Runnable
{
  public lem(DetailProfileActivity paramDetailProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.a());
    this.a.app.runOnUiThread(new len(this, localCard));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */