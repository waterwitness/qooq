import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class oxi
  implements Handler.Callback
{
  public oxi(RecentCallHelper paramRecentCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Boolean)))
      {
        RecentCallHelper.a(this.a).a(((Boolean)paramMessage.obj).booleanValue());
        continue;
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Integer)))
        {
          this.a.a(BaseApplication.getContext());
          SharedPreUtils.a(this.a.a.a()).edit().putInt("show_tab_lightalk_tips", ((Integer)paramMessage.obj).intValue() + 1).commit();
          continue;
          this.a.h();
          if (QLog.isColorLevel())
          {
            QLog.d("RecentCallHelper", 2, "dismiss lightalk tips");
            continue;
            this.a.n();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */