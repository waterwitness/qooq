import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.RenMaiQuanMemberListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class pgp
  extends FacePreloadBaseAdapter
{
  public pgp(RenMaiQuanMemberListInnerFrame paramRenMaiQuanMemberListInnerFrame, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object a(int paramInt)
  {
    CircleBuddy localCircleBuddy = (CircleBuddy)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localCircleBuddy != null) {
      localFaceInfo.jdField_a_of_type_JavaLangString = localCircleBuddy.uin;
    }
    localFaceInfo.jdField_a_of_type_Int = 1;
    return localFaceInfo;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (CircleBuddy)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CircleBuddy localCircleBuddy = (CircleBuddy)getItem(paramInt);
    if (localCircleBuddy == null) {
      return paramView;
    }
    View localView;
    if (paramView == null)
    {
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904975, paramViewGroup, false);
      paramView = new pgq(null);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131297781));
      paramView.d = ((ImageView)localView.findViewById(2131296790));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296829));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.b = localCircleBuddy.uin;
      paramViewGroup.d.setImageBitmap(a(localCircleBuddy.uin, 1, (byte)1));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy));
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localCircleBuddy.uin)) {
        break label303;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label168:
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g.contains(localCircleBuddy.uin))) {
        break label314;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      label210:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy = localCircleBuddy;
      if (AppSetting.j)
      {
        if ((!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
          break label325;
        }
        localView.setContentDescription(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy) + "已选中,双击取消");
      }
    }
    for (;;)
    {
      localView.setOnClickListener(this.a);
      return localView;
      paramViewGroup = (pgq)paramView.getTag();
      localView = paramView;
      break;
      label303:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label168;
      label314:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      break label210;
      label325:
      localView.setContentDescription(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy) + "未选中,双击选中");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */