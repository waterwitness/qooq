import android.view.View;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class lqo
  implements AdapterView.OnItemClickListener
{
  public lqo(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.b()) {
      ThreadManager.a(new lqp(this, paramView, paramInt), 8, null, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */