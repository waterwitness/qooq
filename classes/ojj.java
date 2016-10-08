import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter.ViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

public class ojj
  implements View.OnClickListener
{
  public ojj(NotificationAdapter paramNotificationAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
    if ((localViewHolder == null) || (!(localViewHolder instanceof NotificationAdapter.ViewHolder))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.c();
    paramView = (View)paramView.getParent();
    if ((paramView instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)paramView).c();
    }
    NotificationAdapter.a(this.a, localViewHolder.a);
    this.a.jdField_a_of_type_JavaUtilList.add(NotificationAdapter.a(this.a).remove(this.a.getCount() - localViewHolder.b - 1));
    this.a.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */