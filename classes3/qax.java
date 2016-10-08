import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class qax
  implements Runnable
{
  public qax(MessageRoamManager paramMessageRoamManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new File(MessageRoamManager.a(this.a).a().getFilesDir(), "http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json");
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkBlueBanner local file exists: " + ((File)localObject).exists());
    }
    SharedPreferences localSharedPreferences;
    String str1;
    if (((File)localObject).exists())
    {
      localSharedPreferences = MessageRoamManager.a(this.a).getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      str1 = MessageRoamManager.a(this.a).a();
      int i = localSharedPreferences.getInt("message_roam_is_first_show" + str1, 0);
      bool = this.a.g();
      long l1 = localSharedPreferences.getLong("banner_last_show_timestamp" + str1, 0L);
      long l2 = localSharedPreferences.getInt("blue_banner_show_internal", 24);
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      long l4 = localSharedPreferences.getInt("blue_banner_show_time", 0) * 1000L;
      if (((!bool) && ((l3 - l1 > l2 * 3600000L) || (l3 < l1))) || ((i == 0) && (l4 != 0L)))
      {
        if (!VipUtils.a(MessageRoamManager.a(this.a))) {
          break label468;
        }
        localObject = localSharedPreferences.getString("blue_banner_svip_text", null);
        if (i == 0) {
          localObject = MessageRoamManager.a(this.a).a().getResources().getString(2131368137);
        }
        String str2 = localSharedPreferences.getString("blue_banner_go_url", null);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("showText", (String)localObject);
          localBundle.putString("goUrl", str2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkBlueBanner showText: " + (String)localObject + ", goUrl: " + str2);
          }
          localObject = MessageRoamManager.a(this.a).a(ChatHistoryForC2C.class);
          ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(13, localBundle), 100L);
          if (i != 0) {
            break label507;
          }
          localSharedPreferences.edit().putInt("message_roam_is_first_show" + str1, 1).commit();
          label442:
          ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(14), l4);
        }
      }
    }
    for (boolean bool = false;; bool = true)
    {
      this.a.d(bool);
      return;
      label468:
      if (VipUtils.b(MessageRoamManager.a(this.a)))
      {
        localObject = localSharedPreferences.getString("blue_banner_vip_text", null);
        break;
      }
      localObject = localSharedPreferences.getString("blue_banner_notvip_text", null);
      break;
      label507:
      localSharedPreferences.edit().putLong("banner_last_show_timestamp" + str1, NetConnInfoCenter.getServerTimeMillis()).commit();
      break label442;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */