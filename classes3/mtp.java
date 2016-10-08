import android.text.TextUtils;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mtp
  implements Runnable
{
  public mtp(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.a.a();
    if (localObject != null) {}
    for (localObject = TroopNewGuidePopWindow.a(((MessageRecord)localObject).time, true, false, true).toString();; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.a.a.mRecentSaied = ((String)localObject);
      }
      this.a.runOnUiThread(new mtq(this, (String)localObject));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */