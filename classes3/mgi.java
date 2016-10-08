import android.os.Handler;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mgi
  implements Runnable
{
  mgi(mgh parammgh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQSettingMsgHistoryActivity.a(this.a.a, this.a.a.app);
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */