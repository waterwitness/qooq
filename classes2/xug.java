import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener;

public class xug
  implements View.OnClickListener
{
  public xug(PinnedFooterExpandableListView paramPinnedFooterExpandableListView1, PinnedFooterExpandableListView paramPinnedFooterExpandableListView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (PinnedFooterExpandableListView.a(this.b) != null) {
      PinnedFooterExpandableListView.a(this.b).a(this.a, this.b.a, this.b.g);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */