import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class ruo
  implements View.OnLongClickListener
{
  public ruo(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131296815, paramView.getContext().getString(2131368306));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.l(this.a), localQQCustomMenu);
    this.a.a = BubbleContextMenu.a(paramView, localQQCustomMenu, new rup(this, paramView), new rur(this, paramView));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ruo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */