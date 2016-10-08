import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;

class ofj
  implements Runnable
{
  ofj(ofi paramofi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.a.a), 2, "videoview bring to top");
    }
    if (BlessActivity.a(this.a.a) != null) {
      BlessActivity.a(this.a.a).setVisibility(8);
    }
    if (BlessActivity.a(this.a.a) != null) {
      BlessActivity.a(this.a.a).bringToFront();
    }
    this.a.a.findViewById(2131297139).bringToFront();
    this.a.a.findViewById(2131297123).bringToFront();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */