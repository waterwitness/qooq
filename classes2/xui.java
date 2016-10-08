import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.PinnedHeadAndFootExpandableListView;
import com.tencent.widget.PinnedHeadAndFootExpandableListView.FooterExpandListViewListener;

public class xui
  implements View.OnClickListener
{
  public xui(PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView1, PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.b.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$FooterExpandListViewListener != null) {
      this.b.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$FooterExpandListViewListener.a(this.a, this.b.jdField_a_of_type_AndroidViewView, this.b.m);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */