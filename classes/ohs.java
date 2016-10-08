import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class ohs
  extends FacePreloadBaseAdapter
{
  public ohs(PublicView paramPublicView, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    paramXListView.setAdapter(this);
  }
  
  public PublicRecommendAccountInfo a(int paramInt)
  {
    if ((PublicView.a(this.a) != null) && (paramInt >= 0) && (paramInt < PublicView.a(this.a).size())) {
      return (PublicRecommendAccountInfo)PublicView.a(this.a).get(paramInt);
    }
    return null;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    PublicRecommendAccountInfo localPublicRecommendAccountInfo = a(paramInt);
    if (localPublicRecommendAccountInfo == null) {
      return localFaceInfo;
    }
    if (localPublicRecommendAccountInfo.mSource == 1)
    {
      localFaceInfo.a = localPublicRecommendAccountInfo.mEqqNameAccount;
      return localFaceInfo;
    }
    localFaceInfo.a = String.valueOf(localPublicRecommendAccountInfo.mPublicuin);
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if ((PublicView.a(this.a) != null) && (PublicView.a(this.a).size() > 0)) {
      return PublicView.a(this.a).size();
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.a).inflate(2130903765, paramViewGroup, false);
      paramViewGroup = new ohu();
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296907));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296908));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131299988));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299990));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299989));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.a);
    }
    Object localObject;
    for (;;)
    {
      localObject = a(paramInt);
      if (localObject != null) {
        break;
      }
      return paramView;
      paramViewGroup = (ohu)paramView.getTag();
    }
    if (((PublicRecommendAccountInfo)localObject).mSource == 1)
    {
      paramViewGroup.jdField_b_of_type_JavaLangString = ((PublicRecommendAccountInfo)localObject).mEqqNameAccount;
      label151:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataPublicRecommendAccountInfo = ((PublicRecommendAccountInfo)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramViewGroup.c.setCompoundDrawablePadding(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(1, paramViewGroup.jdField_b_of_type_JavaLangString));
      if ((((PublicRecommendAccountInfo)localObject).mIsVerified == null) || (!((PublicRecommendAccountInfo)localObject).mIsVerified.equalsIgnoreCase("1"))) {
        break label425;
      }
      Drawable localDrawable = this.a.getResources().getDrawable(2130838906);
      paramInt = (int)DisplayUtils.a(this.a.a, 15.0F);
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.a.a, 6.0F));
      label306:
      if (((PublicRecommendAccountInfo)localObject).mSource != 1) {
        break label439;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mEqqCs);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mEqqSi);
    }
    for (;;)
    {
      paramViewGroup.c.setVisibility(8);
      if (!AppSetting.j) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
      ((StringBuilder)localObject).append(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
      paramView.setContentDescription(((StringBuilder)localObject).toString());
      return paramView;
      paramViewGroup.jdField_b_of_type_JavaLangString = String.valueOf(((PublicRecommendAccountInfo)localObject).mPublicuin);
      break label151;
      label425:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label306;
      label439:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mPublicname);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mPublicdesc);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */