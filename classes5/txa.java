import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

class txa
  implements Runnable
{
  txa(twz paramtwz, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int k = ProfileTagView.a().length - 1;
      int i;
      if (this.jdField_a_of_type_JavaUtilList.size() >= k)
      {
        i = k;
        if ((!ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)) || (ProfileTagView.c(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)) || (ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)[k] == null) || (i != 0)) {
          break label338;
        }
        ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).setVisibility(0);
      }
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        if ((this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && (ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)[k] == null))
        {
          localObject2 = ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView);
          localObject1 = View.inflate(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getContext(), 2130904633, null);
          localObject2[k] = localObject1;
          localObject2 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).setVisibility(4);
          ((View)localObject1).setTag(new DataTag(32, null));
          ((View)localObject1).setOnClickListener(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject1).setId(2131296457);
          ((View)localObject1).setTag(2131296457, Integer.valueOf(-1));
          ((View)localObject1).setTag(2131296456, Integer.valueOf(ProfileTagView.a().length - 1));
        }
        j = 0;
        while (j < k)
        {
          localObject1 = ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)[j];
          if (((localObject1 instanceof VipTagView)) && (((View)localObject1).getVisibility() != 8))
          {
            ((VipTagView)localObject1).setShakingState(false);
            ((View)localObject1).setVisibility(8);
          }
          j += 1;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        break;
        label338:
        ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).setVisibility(4);
      }
      int j = 0;
      if (j < i)
      {
        localObject2 = (ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(j);
        if (ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)[j] == null)
        {
          localObject1 = new VipTagView(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getContext());
          ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)[j] = localObject1;
          ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).addView((View)localObject1);
          ((VipTagView)localObject1).setGravity(17);
          ((VipTagView)localObject1).setTag(2131296457, Integer.valueOf(j));
          ((VipTagView)localObject1).setTag(2131296456, Integer.valueOf(ProfileTagView.a()[j]));
          ((VipTagView)localObject1).setTextColor(-1);
        }
        VipTagView localVipTagView = (VipTagView)ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)[j];
        if ((ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)) && (!ProfileTagView.c(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)))
        {
          localObject1 = ProfileTagView.a()[ProfileTagView.a()[j]];
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, ((PointF)localObject1).x, ((PointF)localObject1).y);
          localVipTagView.setVisibility(0);
          localVipTagView.setShakingState(true);
          label567:
          localVipTagView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localVipTagView.setLabelAndPraise(((ProfileLabelInfo)localObject2).labelName, ((ProfileLabelInfo)localObject2).likeNum.intValue());
          localVipTagView.setTag(2131296459, ((ProfileLabelInfo)localObject2).labelId);
          if ((!ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView, localVipTagView)) || (this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)) {
            break label698;
          }
          localVipTagView.setTagColor(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131427557), this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131427556));
        }
        for (;;)
        {
          j += 1;
          break;
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          localVipTagView.setVisibility(4);
          break label567;
          label698:
          localVipTagView.setTagColor(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131427555), this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131427554));
        }
      }
    }
    ProfileTagView.a(this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView, (int)this.jdField_a_of_type_Twz.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */