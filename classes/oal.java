import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class oal
  implements Runnable
{
  oal(oak paramoak)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.a.a.setResult(-1, localIntent);
    this.a.a.x();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */