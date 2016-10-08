import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;

public class qau
  implements Runnable
{
  public qau(MessageRoamManager paramMessageRoamManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (MessageRoamManager.a(this.a) != null)
    {
      SharedPreferences localSharedPreferences = MessageRoamManager.a(this.a).getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
      String str = Base64.encodeToString(MessageRoamManager.a(this.a), 0);
      localSharedPreferences.edit().putString("vip_message_roam_passwordmd5" + MessageRoamManager.a(this.a).a(), str).commit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */