import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

public class pfc
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  pfd jdField_a_of_type_Pfd;
  
  public pfc(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramCreateFaceToFaceDiscussionActivity.jdField_a_of_type_AndroidContentContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size() < 50) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (nearfield_discuss.UserProfile)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904183, null);
      this.jdField_a_of_type_Pfd = new pfd(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity);
      this.jdField_a_of_type_Pfd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296790));
      this.jdField_a_of_type_Pfd.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296829));
      paramView.setTag(this.jdField_a_of_type_Pfd);
      if ((paramInt != getCount() - 1) || (getCount() >= 50)) {
        break label237;
      }
      CreateFaceToFaceDiscussionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, paramView);
    }
    for (;;)
    {
      if (paramInt == getCount() - 1)
      {
        if (paramInt <= 11) {
          break label264;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.b.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.c.setVisibility(0);
        }
      }
      return paramView;
      this.jdField_a_of_type_Pfd = ((pfd)paramView.getTag());
      if (!this.jdField_a_of_type_Pfd.jdField_a_of_type_Boolean) {
        break;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904183, null);
      this.jdField_a_of_type_Pfd = new pfd(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity);
      this.jdField_a_of_type_Pfd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296790));
      this.jdField_a_of_type_Pfd.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296829));
      paramView.setTag(this.jdField_a_of_type_Pfd);
      this.jdField_a_of_type_Pfd.jdField_a_of_type_Boolean = false;
      break;
      label237:
      CreateFaceToFaceDiscussionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, paramView, (nearfield_discuss.UserProfile)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    label264:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.c.setVisibility(4);
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */