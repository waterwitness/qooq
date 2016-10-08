import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kme
  implements Runnable
{
  public kme(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.a.getPreferences().edit();
    localEditor.putInt("LT_tip_show_times" + this.a.a.a(), 1);
    localEditor.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */