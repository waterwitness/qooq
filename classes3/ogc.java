import com.tencent.mobileqq.activity.bless.BlessTypeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoDownload;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ogc
  implements VideoEnvironment.ShortVideoDownload
{
  public ogc(BlessTypeActivity paramBlessTypeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) || (!BlessTypeActivity.b())) {}
    do
    {
      for (;;)
      {
        return;
        BlessTypeActivity.a(true);
        try
        {
          QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230).setMessage("短视频插件下载完成，需要重启QQ生效").setNegativeButton(2131367262, new DialogUtil.DialogOnClickAdapter()).setPositiveButton(2131367263, new ogd(this));
          if (!this.a.isFinishing())
          {
            localQQCustomDialog.show();
            return;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("BlessTyeActivity", 2, "", localException);
  }
  
  public void b(int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ogc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */