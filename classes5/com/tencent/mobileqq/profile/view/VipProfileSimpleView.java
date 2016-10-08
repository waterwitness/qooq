package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.MusicPendantView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import txo;
import txp;

public class VipProfileSimpleView
  extends ProfileHeaderView
{
  public static final int l = 129;
  public static final int m = 18;
  View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public HeartLayout a;
  public VipPhotoViewForSimple a;
  public VoteView a;
  public View b;
  public ImageView b;
  public TextView b;
  public boolean b;
  private View c;
  public ImageView c;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public int n;
  public int o;
  
  public VipProfileSimpleView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.n = -1;
    this.o = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    a(paramProfileCardInfo);
    b(paramProfileCardInfo);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) {
      super.q(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("simpleQQNumColor", "color");
    localHashMap.put("simpleNickNameColor", "color");
    localHashMap.put("simpleAddressColor", "color");
    localHashMap.put("simpleGridAddBackground", "color");
    localHashMap.put("simpleAddressBackground", "drawable");
    localHashMap.put("simpleAddSrc", "drawable");
    localHashMap.put("simpleGridAddSrc", "drawable");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.m(paramProfileCardInfo);
    super.i(paramProfileCardInfo);
    super.j(paramProfileCardInfo);
    c(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.q(paramProfileCardInfo);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return true;
    }
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2130904612, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302629));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303319));
    ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetImageView, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
    Object localObject2 = new DataTag(1, null);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131362036);; localObject1 = ((Context)localObject1).getString(2131362035))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_AndroidWidgetImageView);
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131303053));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_dynamic_avatar_tips", this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298362));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_c_of_type_AndroidWidgetImageView);
      super.q(paramProfileCardInfo);
      this.n = getResources().getDimensionPixelSize(2131493102);
      this.o = ProfileCardUtil.a(getResources());
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131303337);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)this.jdField_c_of_type_Float - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.n - this.o);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        ((RelativeLayout.LayoutParams)localObject1).height += ImmersiveUtils.a(getContext());
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject1).height);
      }
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidViewView.setFocusable(true);
      this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302630));
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleNickNameColor");
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_c_of_type_AndroidWidgetTextView);
      super.i(paramProfileCardInfo);
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303348));
      this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303346));
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303350));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131303311);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_olympic_torch", this.jdField_c_of_type_AndroidViewView);
      super.j(paramProfileCardInfo);
      ProfileCardTemplate.a(this.d, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
      ProfileCardTemplate.a(this.f, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
      ProfileCardTemplate.a(this.e, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
      ProfileCardTemplate.a(this.d, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
      ProfileCardTemplate.a(this.f, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
      ProfileCardTemplate.a(this.e, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
      c(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301942));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301977));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.m(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303322));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_jueban", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple = ((VipPhotoViewForSimple)this.jdField_a_of_type_AndroidViewView.findViewById(2131303333));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple);
      ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303318));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      localObject1 = (MusicPendantView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303308);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_music_pendant", localObject1);
      super.b(paramProfileCardInfo);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, -100.0F);
      ((Animation)localObject1).setDuration(500L);
      ((Animation)localObject1).setFillAfter(true);
      localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -100.0F, 0, 0.0F);
      ((Animation)localObject2).setDuration(500L);
      ((Animation)localObject2).setAnimationListener(new txo(this, paramProfileCardInfo));
      ((Animation)localObject1).setAnimationListener(new txp(this, (Animation)localObject2));
      startAnimation((Animation)localObject1);
      return;
    }
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo)
  {
    int j = -1;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370698);
      this.f.setVisibility(0);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setPadding(0, 10, 0, 0);
      this.f.setText(paramProfileCardInfo);
      this.f.setContentDescription(paramProfileCardInfo);
      return;
    }
    Object localObject = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368209);
        label142:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label649;
        }
        this.d.setVisibility(0);
        this.d.setText(paramProfileCardInfo);
        this.d.setContentDescription(paramProfileCardInfo);
        label205:
        paramProfileCardInfo = "";
        if (localCard == null) {
          break label661;
        }
        i = localCard.age;
        label219:
        if (i > 0) {
          paramProfileCardInfo = i + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368211);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label680;
        }
        this.f.setVisibility(0);
        this.f.setText(paramProfileCardInfo);
        this.f.setContentDescription(paramProfileCardInfo);
        label316:
        localObject = "";
        if (localCard == null) {
          break label692;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!"中国".equals(localCard.strCountry)) {
            paramProfileCardInfo = "" + localCard.strCountry;
          }
        }
        localObject = paramProfileCardInfo;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramProfileCardInfo;
          if (!TextUtils.isEmpty(paramProfileCardInfo)) {
            localObject = paramProfileCardInfo + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramProfileCardInfo = (String)localObject + "，";
          }
          paramProfileCardInfo = paramProfileCardInfo + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label888;
        }
        this.e.setVisibility(0);
        this.e.setText(paramProfileCardInfo);
        this.e.setContentDescription(paramProfileCardInfo);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label898;
        }
        i = localContactCard.bSex;
        break;
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (i != 1) {
          break label142;
        }
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368210);
        break label142;
        label649:
        this.d.setVisibility(8);
        break label205;
        label661:
        i = j;
        if (localContactCard == null) {
          break label219;
        }
        i = localContactCard.bAge;
        break label219;
        label680:
        this.f.setVisibility(8);
        break label316;
        label692:
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (localContactCard != null)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramProfileCardInfo = (ProfileCardInfo)localObject;
            if (!"中国".equals(localContactCard.strCountry)) {
              paramProfileCardInfo = "" + localContactCard.strCountry;
            }
          }
          localObject = paramProfileCardInfo;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramProfileCardInfo;
            if (!TextUtils.isEmpty(paramProfileCardInfo)) {
              localObject = paramProfileCardInfo + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramProfileCardInfo = (ProfileCardInfo)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramProfileCardInfo = (String)localObject + "，";
            }
            paramProfileCardInfo = paramProfileCardInfo + localContactCard.strCity;
          }
        }
      }
      label888:
      this.e.setVisibility(8);
      return;
      label898:
      i = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\VipProfileSimpleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */