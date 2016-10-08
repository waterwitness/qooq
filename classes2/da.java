import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.DLRouterSessionInfoRequestTask;
import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.litetransfersdk.ProgressInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class da
  implements View.OnClickListener
{
  public da(DLRouterSessionListAdapter paramDLRouterSessionListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (ProgressInfo)paramView.getTag();
    if (paramView != null)
    {
      paramView.SetStatus(1);
      this.a.a.a(paramView.uint64_sessionid, 12);
      DLRouterSessionListAdapter.a(this.a, 32);
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */