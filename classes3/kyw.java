import android.content.Intent;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

class kyw
  implements Runnable
{
  kyw(kyt paramkyt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.a != null) && (this.a.a.a.isShowing()) && (!this.a.a.isFinishing())) {
      this.a.a.a.dismiss();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.a.setResult(-1, localIntent);
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */