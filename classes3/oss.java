import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qqcard.QQCardActivity;
import com.tencent.mobileqq.activity.qqcard.QQCardFooter;
import com.tencent.mobileqq.activity.qqcard.QQCardManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class oss
  implements Runnable
{
  public oss(QQCardActivity paramQQCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQCardActivity.a(this.a, QQCardActivity.a(this.a).a());
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("initData, cache size = ");
      if (QQCardActivity.a(this.a) != null) {
        break label122;
      }
    }
    label122:
    for (int i = 0;; i = QQCardActivity.a(this.a).size())
    {
      QLog.d("QQCard.QQCardActivity", 2, i);
      QQCardActivity.a(this.a).sendEmptyMessage(5);
      if ((QQCardActivity.a(this.a) != null) && (QQCardActivity.a(this.a).size() > 0)) {
        break;
      }
      QQCardActivity.a(this.a).a(0, TextUtils.isEmpty(QQCardActivity.a(this.a)));
      return;
    }
    QQCardActivity.a(this.a).a(8, TextUtils.isEmpty(QQCardActivity.a(this.a)));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */