import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mgg
  implements Runnable
{
  public mgg(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.app.getPreferences().edit().putBoolean("chatHistoryEventEntryFirstShow", false).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */