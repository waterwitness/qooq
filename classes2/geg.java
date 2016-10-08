import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.arrange.ui.EditMemberActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import java.util.List;

public class geg
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public geg(EditMemberActivity paramEditMemberActivity, List paramList)
  {
    super(paramEditMemberActivity, paramEditMemberActivity.app, paramEditMemberActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected Object a(int paramInt)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localATroopMember != null) {
      localFaceInfo.a = localATroopMember.a;
    }
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130905078, paramViewGroup, false);
      paramViewGroup = new TroopMemberListActivity.TmViewHolder(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.h.setTag(localATroopMember.a);
      paramViewGroup.b.setTag(localATroopMember.a);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(localATroopMember.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.a(paramViewGroup, localATroopMember, a(1, localATroopMember.a), true);
      return paramView;
      paramViewGroup = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\geg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */