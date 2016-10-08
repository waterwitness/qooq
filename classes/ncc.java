import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ncc
  implements Runnable
{
  public ncc(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    AIOInputTypeHelper.a(this.a).edit().putBoolean("ptt_guide_have_show", false).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */