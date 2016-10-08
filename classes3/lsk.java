import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lsk
  implements Runnable
{
  public lsk(LikeSettingActivity paramLikeSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = this.a.app.o();
    this.a.runOnUiThread(new lsl(this, bool));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */