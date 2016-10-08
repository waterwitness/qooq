import android.view.View;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener;

public class pfk
  implements PinnedFooterExpandableListView.FooterExpandListViewListener
{
  public pfk(FriendTabView paramFriendTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.a = true;
    FriendTabView.a(this.a).setFooterEnable(false);
  }
  
  public void a(PinnedFooterExpandableListView paramPinnedFooterExpandableListView, View paramView, int paramInt)
  {
    if (!this.a.a)
    {
      if (paramInt - 1 >= 0) {
        paramPinnedFooterExpandableListView.d(paramInt - 1);
      }
      for (;;)
      {
        this.a.a = true;
        FriendTabView.a(this.a).setFooterEnable(false);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FriendTabView", 2, "header group unusal: " + paramInt);
        }
      }
    }
    if (paramPinnedFooterExpandableListView.e(paramInt))
    {
      paramPinnedFooterExpandableListView.d(paramInt);
      return;
    }
    paramPinnedFooterExpandableListView.a(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */