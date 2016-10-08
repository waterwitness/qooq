package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.widget.MusicPendantView;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomListView;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfileBaseView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private MusicPendantView jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView;
  RandomCoverView jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
  private VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  private PullToZoomListView jdField_a_of_type_ComTencentWidgetPullToZoomListView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  
  public ProfileBaseView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, PullToZoomListView paramPullToZoomListView, TextView paramTextView)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView = paramPullToZoomListView;
    this.e = paramTextView;
    b(paramProfileCardInfo);
  }
  
  private void b(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView == null) {}
    for (;;)
    {
      return;
      if (!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Long = 0L;
        return;
      }
      paramProfileCardInfo = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramProfileCardInfo == null) || (!paramProfileCardInfo.isPendantValid())) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Long = paramProfileCardInfo.pendantId;
      paramProfileCardInfo = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
      if (AvatarPendantUtil.a(this.jdField_a_of_type_Long)) {
        paramProfileCardInfo.a(this.jdField_a_of_type_Long).a(this.jdField_c_of_type_AndroidWidgetImageView, 2, PendantInfo.i);
      }
      while (paramBoolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
        return;
        paramProfileCardInfo.a(this.jdField_a_of_type_Long).a(this.jdField_c_of_type_AndroidWidgetImageView, 1, PendantInfo.i);
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false);
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo) {}
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.i(paramProfileCardInfo);
    super.j(paramProfileCardInfo);
    d(paramProfileCardInfo);
    c(paramProfileCardInfo);
    super.l(paramProfileCardInfo);
    super.k(paramProfileCardInfo);
    super.m(paramProfileCardInfo);
    b(paramProfileCardInfo, false);
    f(paramProfileCardInfo);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    View localView;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break;
        }
        localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131303306);
      } while (localView == null);
      localView.setBackgroundResource(0);
      return;
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131303306);
    } while (localView == null);
    localView.setBackgroundResource(2130841049);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Context localContext = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(localContext).inflate(2130904599, this, true);
    Object localObject1 = new DisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    int i = (int)(((DisplayMetrics)localObject1).widthPixels / 16.0F * 9.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302625));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setHeaderImage(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView);
    localObject1 = new DataTag(17, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(localObject1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setVisibility(0);
    Object localObject2;
    boolean bool;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject1 = localContext.getString(2131362039);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription((CharSequence)localObject1);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.k);
        localObject2 = (String)localObject1[0];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_b_of_type_JavaLangString = ((String)localObject2);
          this.k = ((Integer)localObject1[1]).intValue();
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      String str2 = this.jdField_b_of_type_JavaLangString;
      if (this.k != 0) {
        break label790;
      }
      bool = true;
      label238:
      ((RandomCoverView)localObject1).a((QQAppInterface)localObject2, str1, str2, bool);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302629));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject2 = new DataTag(1, null);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label796;
      }
    }
    label790:
    label796:
    for (localObject1 = localContext.getString(2131362036);; localObject1 = localContext.getString(2131362035))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_b_of_type_AndroidWidgetImageView);
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.d = ((TextView)findViewById(2131303053));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_dynamic_avatar_tips", this.d);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298362));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_c_of_type_AndroidWidgetImageView);
      b(paramProfileCardInfo, true);
      b();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302630));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_AndroidWidgetTextView);
      super.i(paramProfileCardInfo);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131303311);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_olympic_torch", this.jdField_b_of_type_AndroidViewView);
      super.j(paramProfileCardInfo);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303314));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_b_of_type_AndroidWidgetTextView);
      d(paramProfileCardInfo);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303312));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", this.jdField_c_of_type_AndroidWidgetTextView);
      c(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303315));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_login_day_icon", this.jdField_a_of_type_AndroidWidgetImageView);
      super.l(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301942));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301977));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.m(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView = ((MusicPendantView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303308));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_music_pendant", this.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView);
      super.b(paramProfileCardInfo);
      return;
      localObject1 = localContext.getString(2131362038);
      break;
      bool = false;
      break label238;
    }
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign");
    TextView localTextView;
    if (((localObject1 instanceof TextView)) && (paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      localTextView = (TextView)localObject1;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
    if ((!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localObject1 == null))
    {
      localTextView.setVisibility(8);
      return;
    }
    SpannableString localSpannableString = ((RichStatus)localObject1).toSpannableString("");
    if (!TextUtils.isEmpty(((RichStatus)localObject1).actionText))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
      localSpannableStringBuilder.insert(0, "[S] ");
      StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localStatusManager != null)
      {
        localObject1 = localStatusManager.a(((RichStatus)localObject1).actionId, 200);
        localObject1 = new StatableBitmapDrawable(getResources(), (Bitmap)localObject1, false, false);
        int i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
        localObject1 = new OffsetableImageSpan((Drawable)localObject1, 0);
        ((OffsetableImageSpan)localObject1).a(-0.1F);
        localSpannableStringBuilder.setSpan(localObject1, 0, "[S]".length(), 17);
        localTextView.setText(localSpannableStringBuilder);
        localTextView.setVisibility(0);
        label235:
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
          localTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label420;
        }
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841099, 0);
        label283:
        if (TextUtils.isEmpty(localSpannableString)) {
          break label443;
        }
        localObject1 = localSpannableString.toString();
        label297:
        localTextView.setTag(new DataTag(3, localObject1));
        localTextView.setOnLongClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362006)).append(":");
        if (TextUtils.isEmpty(localSpannableString)) {
          break label449;
        }
      }
    }
    label420:
    label443:
    label449:
    for (paramProfileCardInfo = localSpannableString.toString();; paramProfileCardInfo = "")
    {
      localTextView.setContentDescription(paramProfileCardInfo);
      return;
      try
      {
        localObject1 = BitmapFactory.decodeResource(getResources(), 2130842868);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        Object localObject2 = null;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        str = null;
      }
      break;
      localTextView.setText(localSpannableString);
      localTextView.setVisibility(0);
      break label235;
      if (!ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label283;
      }
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841100, 0);
      break label283;
      String str = "";
      break label297;
    }
  }
  
  public void d(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    Object localObject2;
    if ((localObject1 instanceof TextView))
    {
      localObject1 = (TextView)localObject1;
      localObject2 = ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + Utils.b((String)localObject2));
      }
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label126;
      }
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370698);
      if (((TextView)localObject1).getVisibility() != 0) {
        ((TextView)localObject1).setVisibility(0);
      }
      ((TextView)localObject1).setPadding(0, 10, 0, 0);
      ((TextView)localObject1).setText(paramProfileCardInfo);
      ((TextView)localObject1).setContentDescription(paramProfileCardInfo);
    }
    label126:
    label350:
    do
    {
      return;
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        int j = -1;
        localObject2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
        ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
        int i;
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1))
        {
          i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
          if (i != 0) {
            break label350;
          }
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130841104, 0, 0, 0);
          ((TextView)localObject1).setBackgroundResource(2130841105);
        }
        for (;;)
        {
          paramProfileCardInfo = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
          if (((TextView)localObject1).getVisibility() != 0) {
            ((TextView)localObject1).setVisibility(0);
          }
          ((TextView)localObject1).setPadding(8, 4, 8, 4);
          ((TextView)localObject1).setText(paramProfileCardInfo);
          ((TextView)localObject1).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361999) + ":" + paramProfileCardInfo);
          ((TextView)localObject1).setClickable(true);
          return;
          if ((localObject2 != null) && ((((Card)localObject2).shGender == 0) || (((Card)localObject2).shGender == 1)))
          {
            i = ((Card)localObject2).shGender;
            break;
          }
          i = j;
          if (localContactCard == null) {
            break;
          }
          if (localContactCard.bSex != 0)
          {
            i = j;
            if (localContactCard.bSex != 1) {
              break;
            }
          }
          i = localContactCard.bSex;
          break;
          if (i == 1)
          {
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130841102, 0, 0, 0);
            ((TextView)localObject1).setBackgroundResource(2130841103);
          }
        }
      }
    } while (((TextView)localObject1).getVisibility() == 4);
    ((TextView)localObject1).setVisibility(4);
  }
  
  public void e(ProfileCardInfo paramProfileCardInfo)
  {
    this.h &= 0xFFFFFFFE;
    Object localObject;
    if ((this.e != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)) {
      if (ProfileActivity.AllInOne.c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (!ProfileActivity.AllInOne.h(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label400;
        }
        localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (localObject != null)
        {
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break label703;
          }
          ProfileActivity.CardContactInfo localCardContactInfo = (ProfileActivity.CardContactInfo)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localCardContactInfo == null) {
            break label197;
          }
          paramProfileCardInfo = localCardContactInfo.jdField_b_of_type_JavaLangString + localCardContactInfo.c;
          if (TextUtils.isEmpty(paramProfileCardInfo)) {
            break label703;
          }
        }
      }
    }
    label197:
    label208:
    label400:
    label693:
    label703:
    for (paramProfileCardInfo = ((PhoneContactManager)localObject).c(paramProfileCardInfo);; paramProfileCardInfo = null)
    {
      int i;
      if (paramProfileCardInfo != null)
      {
        i = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        if ((2 != i) && (i != 0)) {
          break label208;
        }
        this.h &= 0xFFFFFFFE;
      }
      for (;;)
      {
        if ((this.h & 0x1) == 0) {
          break label693;
        }
        this.e.setVisibility(0);
        return;
        paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        break;
        if ((paramProfileCardInfo.iTermType == 68104) || (paramProfileCardInfo.iTermType == 65805))
        {
          this.h &= 0xFFFFFFFE;
        }
        else if ((paramProfileCardInfo.abilityBits & 1L) != 0L)
        {
          i = paramProfileCardInfo.eNetworkType;
          paramProfileCardInfo = a(i);
          if (i == 2)
          {
            this.e.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130841082), null, null, null);
            this.e.setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
          }
          if ((this.e != null) && (!TextUtils.isEmpty(paramProfileCardInfo))) {
            this.e.setText(paramProfileCardInfo);
          }
          this.h |= 0x1;
        }
        else if ((paramProfileCardInfo.ability & 0x2) != 0)
        {
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370030);
          if ((this.e != null) && (!TextUtils.isEmpty(paramProfileCardInfo))) {
            this.e.setText(paramProfileCardInfo);
          }
          this.h |= 0x1;
          continue;
          localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          if (localObject != null)
          {
            paramProfileCardInfo = ((FriendsManager)localObject).c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            i = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            if ((2 == i) || (i == 0))
            {
              this.h &= 0xFFFFFFFE;
            }
            else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.iTermType == 68104) || (paramProfileCardInfo.iTermType == 65805)))
            {
              this.h &= 0xFFFFFFFE;
            }
            else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.abilityBits & 1L) != 0L))
            {
              i = paramProfileCardInfo.getNetWorkType();
              localObject = a(i);
              if ((i == 2) && (this.e != null))
              {
                this.e.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130841082), null, null, null);
                this.e.setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
              }
              if (ContactUtils.a(paramProfileCardInfo))
              {
                this.h = 0;
              }
              else
              {
                if ((this.e != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                  this.e.setText((CharSequence)localObject);
                }
                this.h |= 0x1;
              }
            }
            else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.abilityBits & 0x2) != 0L))
            {
              paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370030);
              if ((this.e != null) && (!TextUtils.isEmpty(paramProfileCardInfo))) {
                this.e.setText(paramProfileCardInfo);
              }
              this.h |= 0x1;
            }
          }
        }
      }
      this.e.setVisibility(8);
      return;
    }
  }
  
  protected void f(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.k);
      paramProfileCardInfo = (String)localObject[0];
      Integer localInteger = (Integer)localObject[1];
      if ((TextUtils.isEmpty(paramProfileCardInfo)) || (paramProfileCardInfo.equals(this.jdField_b_of_type_JavaLangString))) {
        break label123;
      }
      if ((localInteger.intValue() != 0) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.k != 0)) {
        break label76;
      }
    }
    label76:
    label123:
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_b_of_type_JavaLangString = paramProfileCardInfo;
      this.k = ((Integer)localObject[1]).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
      if (this.k == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((RandomCoverView)localObject).a(paramProfileCardInfo, bool);
        return;
      }
    }
    QLog.i("Q.profilecard.", 2, "same cover " + paramProfileCardInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\ProfileBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */