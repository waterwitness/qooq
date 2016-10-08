import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.TouchProxyRelativeLayout;

public class mcy
  implements Runnable
{
  public mcy(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QQLSActivity.c(this.a) != null) {
      QQLSActivity.a(this.a).removeView(QQLSActivity.c(this.a));
    }
    QQLSActivity.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */