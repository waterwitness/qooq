import android.view.VelocityTracker;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.OverScroller;

class xrv
  implements Runnable
{
  xrv(xru paramxru)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = AbsListView.c(this.a.a);
    VelocityTracker localVelocityTracker = AbsListView.a(this.a.a);
    OverScroller localOverScroller = xru.a(this.a);
    if ((localVelocityTracker == null) || (i == -1)) {
      return;
    }
    localVelocityTracker.computeCurrentVelocity(1000, AbsListView.d(this.a.a));
    if (VersionUtils.b()) {}
    for (float f = -localVelocityTracker.getYVelocity(i); (Math.abs(f) >= AbsListView.e(this.a.a)) && (localOverScroller.a(0.0F, f)); f = -localVelocityTracker.getYVelocity())
    {
      this.a.a.postDelayed(this, 40L);
      return;
    }
    this.a.a();
    this.a.a.ag = 3;
    this.a.a.b(1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xrv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */