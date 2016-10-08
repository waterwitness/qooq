import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.PubAccBindTroopListActivity;
import com.tencent.widget.XListView;

public class vff
  extends RecentAdapter
{
  public vff(PubAccBindTroopListActivity paramPubAccBindTroopListActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramOnRecentUserOpsListener, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */