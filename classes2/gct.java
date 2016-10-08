import android.content.Intent;
import com.tencent.arrange.ui.AVMeetingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class gct
  implements Runnable
{
  public gct(AVMeetingActivity paramAVMeetingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
    Object localObject;
    switch (this.a.j)
    {
    default: 
      localObject = String.format("%s:%d", new Object[] { this.a.getString(2131365102), Integer.valueOf(this.a.j) });
    }
    for (;;)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
      localQQCustomDialog.setTitle(this.a.getString(2131365097));
      localQQCustomDialog.setMessage((CharSequence)localObject);
      localQQCustomDialog.setPositiveButton(2131365090, new gcu(this));
      localQQCustomDialog.show();
      return;
      localObject = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
      ((Intent)localObject).putExtra("uin", this.a.b);
      ((Intent)localObject).putExtra("uintype", 3000);
      this.a.startActivity((Intent)localObject);
      return;
      localObject = this.a.getString(2131365098);
      continue;
      localObject = this.a.getString(2131365099);
      continue;
      localObject = this.a.getString(2131365100);
      continue;
      localObject = this.a.getString(2131365101);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */