import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.HashMap;
import java.util.List;

public class gdq
  extends BaseAdapter
{
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  
  public gdq(CreateArrageActivity paramCreateArrageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramCreateArrageActivity.app.getManager(50));
  }
  
  public int getCount()
  {
    return CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).size()) {
      return null;
    }
    return CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.getLayoutInflater().inflate(2130903537, null);
    }
    paramViewGroup.setVisibility(0);
    paramViewGroup.setFocusable(false);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131296829);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131296790);
    if (paramInt == getCount() - 1)
    {
      paramView = this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.getString(2131369432);
      localTextView.setText(paramView);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.getResources().getColor(2131428268));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130838182);
      localImageView.setTag(paramView);
      if (!CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity)) {
        paramViewGroup.setVisibility(8);
      }
    }
    for (;;)
    {
      if (AppSetting.j) {
        localImageView.setContentDescription(localTextView.getText());
      }
      localImageView.setOnClickListener(new gdr(this));
      return paramViewGroup;
      if (paramInt > getCount() - 1)
      {
        localTextView.setText("");
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageDrawable(null);
      }
      else
      {
        localImageView.setImageResource(2130840577);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.getResources().getColor(2131428262));
        HashMap localHashMap = (HashMap)CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).get(paramInt);
        String str = (String)localHashMap.get("memberUin");
        Object localObject = (String)localHashMap.get("memberName");
        if (TextUtils.isEmpty(str))
        {
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          localTextView.setText(paramView);
          localImageView.setImageDrawable(ImageUtil.b());
        }
        else
        {
          paramView = (View)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramView = (View)localObject;
            if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null)
            {
              Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(str);
              paramView = (View)localObject;
              if (localFriends != null)
              {
                paramView = (View)localObject;
                if (localFriends.isFriend()) {
                  paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.app, str);
                }
              }
            }
          }
          localObject = paramView;
          if (TextUtils.isEmpty(paramView)) {
            localObject = str;
          }
          localTextView.setText((CharSequence)localObject);
          if (localHashMap.containsKey("faceId")) {
            ((Short)localHashMap.get("faceId")).shortValue();
          }
          localImageView.setBackgroundDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.app, str, (byte)3));
          localImageView.setTag(str);
          localImageView.setTag(2131296768, localObject);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */