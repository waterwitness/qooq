import android.view.View;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;

public class stc
  implements PinnedDividerListView.OnLayoutListener
{
  public stc(HotChatMemberListActivity paramHotChatMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.s() > 0) || ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.s() == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.a.jdField_a_of_type_Sty.getCount() + this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\stc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */