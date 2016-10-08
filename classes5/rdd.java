import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class rdd
  implements AbsListView.OnScrollListener
{
  public rdd(DatingDestinationActivity paramDatingDestinationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.t() == paramAbsListView.d_() - 1))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("DatingDestinationActivity", 4, "onScrollStateChanged");
      }
      if (!this.a.d) {
        this.a.a(this.a.e, this.a.a);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */