import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class rsz
  implements View.OnLongClickListener
{
  public rsz(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131296815, paramView.getContext().getString(2131368306));
    this.a.a = BubbleContextMenu.a(paramView, localQQCustomMenu, new rta(this, paramView), new rtc(this, paramView));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rsz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */