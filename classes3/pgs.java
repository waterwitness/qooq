import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.RenMaiQuanTeamListInnerFrame;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.data.CircleGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class pgs
  extends BaseAdapter
{
  private pgs(RenMaiQuanTeamListInnerFrame paramRenMaiQuanTeamListInnerFrame)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (CircleGroup)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (CircleGroup)getItem(paramInt);
    if (paramViewGroup == null) {
      return paramView;
    }
    paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904984, RenMaiQuanTeamListInnerFrame.a(this.a), false);
    ((ImageView)paramView.findViewById(2131296814)).setImageResource(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramViewGroup.groupId));
    ((TextView)paramView.findViewById(2131298260)).setText(paramViewGroup.groupName);
    paramView.setOnClickListener(new pgt(this, paramViewGroup));
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */