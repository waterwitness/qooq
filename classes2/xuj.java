import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;

public class xuj
  implements View.OnTouchListener
{
  public xuj(PinnedHeaderExpandableListView paramPinnedHeaderExpandableListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      long l = this.a.b(this.a.s());
      if ((ExpandableListView.b(l) == 0) || (ExpandableListView.b(l) == 1))
      {
        int i = ExpandableListView.c(l);
        if ((PinnedHeaderExpandableListView.a(this.a) == null) || (!PinnedHeaderExpandableListView.a(this.a).a(this.a, paramView, i, PinnedHeaderExpandableListView.a(this.a).getGroupId(i)))) {
          this.a.d(i);
        }
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xuj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */