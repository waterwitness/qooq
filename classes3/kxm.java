import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class kxm
  extends AccountObserver
{
  public kxm(ChatHistoryForC2C paramChatHistoryForC2C, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onRefrshDA2 result: ").append(paramBoolean).append(", da2 length: ");
      if (paramString2 != null) {
        break label93;
      }
    }
    label93:
    for (int i = 0;; i = paramString2.length())
    {
      QLog.d("ChatHistoryForC2C", 2, i);
      boolean bool1 = bool2;
      if (paramBoolean)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString2)) {
          bool1 = true;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.runOnUiThread(new kxn(this, bool1));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */