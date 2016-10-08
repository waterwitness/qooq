import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class lww
  implements Runnable
{
  public lww(NotificationActivity paramNotificationActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("SecResEntry", -1);
    if ((i == -1) || ((i ^ 0x12) != this.jdField_a_of_type_Int))
    {
      localEditor.putInt("SecResEntry", this.jdField_a_of_type_Int ^ 0x12);
      localEditor.putLong("SecStampEntry", System.currentTimeMillis() ^ 0x12);
      localEditor.commit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */