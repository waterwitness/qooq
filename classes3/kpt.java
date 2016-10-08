import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class kpt
  implements Runnable
{
  kpt(kpq paramkpq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      FragmentActivity localFragmentActivity = this.a.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      Object localObject;
      String str;
      if (BaseChatPie.j(this.a.a) > 0)
      {
        localObject = "发送到 " + this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        if (BaseChatPie.j(this.a.a) <= 0) {
          break label186;
        }
        str = "Crash count: " + BaseChatPie.j(this.a.a) + "\n" + "CrashInfoSummary.txt";
        label108:
        if (BaseChatPie.j(this.a.a) <= 0) {
          break label191;
        }
      }
      label186:
      label191:
      for (int i = 2131367885;; i = 2131367263)
      {
        localObject = DialogUtil.a(localFragmentActivity, 230, (String)localObject, str, 2131367262, i, new kpu(this), new kpv(this));
        ((QQCustomDialog)localObject).adjustTitle();
        if (this.a.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
          return;
        }
        ((QQCustomDialog)localObject).show();
        return;
        localObject = "0 Crash";
        break;
        str = null;
        break label108;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */