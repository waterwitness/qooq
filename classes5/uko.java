import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.util.MqqWeakReferenceHandler;

public class uko
  implements Runnable
{
  public uko(GroupSearchActivity paramGroupSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    GroupSearchActivity.a(this.a, GroupSearchActivity.a(this.a));
    Message localMessage = GroupSearchActivity.a(this.a).obtainMessage();
    localMessage.what = 1;
    GroupSearchActivity.a(this.a).sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */