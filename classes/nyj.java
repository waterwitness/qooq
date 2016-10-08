import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;

public class nyj
  implements View.OnClickListener
{
  public nyj(HotChatPie paramHotChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (Long)paramView.getTag();
    long l = Math.abs(System.nanoTime() - paramView.longValue()) / 1000000L;
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "pop click", new Object[] { Long.valueOf(l) });
    }
    if (l < 500L) {
      return;
    }
    this.a.y();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */