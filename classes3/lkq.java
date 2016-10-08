import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfileShoppingView;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class lkq
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 1000L;
  private long b;
  
  public lkq(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if (!(paramView.getTag() instanceof DataTag)) {
        continue;
      }
      Object localObject1 = (DataTag)paramView.getTag();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "onClickListener and DataTag type=" + ((DataTag)localObject1).ah);
      }
      long l = System.currentTimeMillis();
      if ((((DataTag)localObject1).ah != 10) && (Math.abs(l - this.jdField_b_of_type_Long) < 1000L)) {
        break;
      }
      this.jdField_b_of_type_Long = l;
      if ((!this.a.jdField_b_of_type_Boolean) && (FriendProfileCardActivity.a(this.a, ((DataTag)localObject1).ah))) {
        break;
      }
      int i;
      switch (((DataTag)localObject1).ah)
      {
      case 11: 
      case 12: 
      case 15: 
      case 25: 
      case 36: 
      case 37: 
      case 38: 
      case 40: 
      case 43: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      default: 
        
      case 1: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          paramView = new Intent(this.a, AvatarPendantActivity.class);
          paramView.putExtra("AllInOne", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          paramView.putExtra("DynamicAvatarTips", this.a.jdField_d_of_type_Boolean);
          this.a.startActivity(paramView);
          ReportController.b(this.a.app, "CliOper", "", "", "0X8006A77", "0X8006A77", 0, 0, "", "", "", "");
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
          {
            paramView = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
            l = this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
            if ((ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramView != null) && (paramView.getVisibility() == 0) && (l != 0L)) {
              ReportController.b(this.a.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoHeadClick", 0, 0, "", "", "", "");
            }
          }
        }
      case 17: 
        for (;;)
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004173", "0X8004173", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          if ((!ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null)) {
            break;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
          {
            this.a.c();
            return;
          }
          paramView = new Intent(this.a, CardPicGalleryActivity.class);
          localObject1 = new ArrayList();
          if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b)) {
            paramView.putExtra("extra_default", 2130841028);
          }
          ((ArrayList)localObject1).add(this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b);
          paramView.putExtra("extra_mode", 2);
          paramView.putStringArrayListExtra("business_card_pics", (ArrayList)localObject1);
          this.a.startActivity(paramView);
          this.a.overridePendingTransition(2130968800, 0);
          ReportController.b(this.a.app, "CliOper", "", "", "0X8006A97", "0X8006A97", 0, 0, "", "", "", "");
          return;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)) {
            break;
          }
          if (!ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            paramView = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if ((paramView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
            {
              localObject1 = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
              if (localObject1 != null) {
                ProfileCardUtil.a(this.a, (View)localObject1, paramView);
              }
            }
          }
          else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
          {
            paramView = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
            localObject1 = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
            l = this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
            if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (localObject1 != null) && (paramView != null) && (((View)localObject1).getVisibility() == 0) && (l != 0L))
            {
              i = 0;
              if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1)
              {
                i = 1;
                ReportController.b(this.a.app, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i, 0, "", "", "", "");
                if ((paramView instanceof DynamicAvatarView))
                {
                  localObject1 = (DynamicAvatarView)paramView;
                  if (((DynamicAvatarView)localObject1).a != null)
                  {
                    localObject1 = ((DynamicAvatarView)localObject1).a;
                    if ((!((DynamicFaceDrawable)localObject1).jdField_a_of_type_Boolean) || (((DynamicFaceDrawable)localObject1).jdField_a_of_type_ComTencentImageURLDrawable == null) || (TextUtils.isEmpty(((DynamicFaceDrawable)localObject1).jdField_d_of_type_JavaLangString))) {
                      break label1365;
                    }
                    ProfileCardUtil.b(this.a, paramView, ((DynamicFaceDrawable)localObject1).jdField_d_of_type_JavaLangString);
                  }
                }
              }
              while ((this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))
              {
                ReportController.b(this.a.app, "CliOper", "", "", "0X8006A8B", "0X8006A8B", 0, 0, "", "", "", "");
                break;
                if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
                {
                  i = 2;
                  break label1080;
                }
                if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21)
                {
                  i = 3;
                  break label1080;
                }
                if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45)
                {
                  i = 4;
                  break label1080;
                }
                if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
                {
                  i = 5;
                  break label1080;
                }
                if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41)
                {
                  i = 6;
                  break label1080;
                }
                if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 42) {
                  break label1080;
                }
                i = 7;
                break label1080;
                ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, l, i);
              }
            }
            if ((paramView != null) && ((paramView instanceof DynamicAvatarView)))
            {
              localObject1 = (DynamicAvatarView)paramView;
              if (((DynamicAvatarView)localObject1).a != null)
              {
                localObject1 = ((DynamicAvatarView)localObject1).a;
                if ((((DynamicFaceDrawable)localObject1).jdField_a_of_type_Boolean) && (((DynamicFaceDrawable)localObject1).jdField_a_of_type_ComTencentImageURLDrawable != null) && (!TextUtils.isEmpty(((DynamicFaceDrawable)localObject1).jdField_d_of_type_JavaLangString))) {
                  ProfileCardUtil.b(this.a, paramView, ((DynamicFaceDrawable)localObject1).jdField_d_of_type_JavaLangString);
                } else if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0"))) {
                  ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.p);
                } else {
                  ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                }
              }
            }
          }
        }
      case 31: 
        this.a.h();
        return;
      case 4: 
        this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((DataTag)localObject1).a);
        if (this.a.jdField_a_of_type_ArrayOfInt == null) {
          this.a.jdField_a_of_type_ArrayOfInt = new int[5];
        }
        this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
        this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.a.app, this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
        if ((this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b != null) && (this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a().d == 1))
        {
          this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          this.a.jdField_a_of_type_ArrayOfInt[0] = 19;
          this.a.jdField_a_of_type_ArrayOfInt[1] = 8;
          if (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            break label1853;
          }
          this.a.jdField_a_of_type_ArrayOfInt[2] = 9;
          this.a.jdField_a_of_type_ArrayOfInt[3] = 16;
        }
        for (;;)
        {
          i = 4;
          while (i < 5)
          {
            this.a.jdField_a_of_type_ArrayOfInt[i] = -1;
            i += 1;
          }
          this.a.jdField_a_of_type_ArrayOfInt[0] = 7;
          break;
          this.a.jdField_a_of_type_ArrayOfInt[2] = 16;
          this.a.jdField_a_of_type_ArrayOfInt[3] = -1;
        }
        this.a.a(this.a.jdField_a_of_type_ArrayOfInt);
        ReportController.b(this.a.app, "CliOper", "", "", "0X8005AFD", "0X8005AFD", 0, 0, "", "", "", "");
        return;
      case 35: 
        this.a.i();
        return;
      case 6: 
        this.a.m();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Prof_new_photo", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      case 5: 
        this.a.n();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8006A7C", "0X8006A7C", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006A90", "0X8006A90", 0, 0, "", "", "", "");
        return;
      case 7: 
        this.a.k();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_add_frd", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j), "", "");
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (87 != this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)) {
          continue;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006F0D", "0X8006F0D", 0, 0, "", "", "", "");
        return;
      case 8: 
        this.a.l();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j), "", "");
        return;
      case 9: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          continue;
        }
        paramView = new Intent(this.a.getActivity(), DetailProfileActivity.class);
        this.a.startActivityForResult(paramView, 1007);
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 8)
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004178", "0X8004178", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004178", "0X8004178", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      case 23: 
        paramView = paramView.findViewById(2131302369);
        i = 1;
        if (paramView != null) {
          if (paramView.getVisibility() != 0) {
            break label2646;
          }
        }
        for (i = 0;; i = 1)
        {
          paramView.setVisibility(8);
          FriendProfileCardActivity.f(this.a);
          ProfileCardUtil.a(this.a, this.a.app.a(), "inside.myCardButton", i, 3, 1, "", true);
          ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X8006681", 0, 0, "", "", "", "");
          return;
        }
      case 24: 
        int j = ((Integer)((DataTag)localObject1).a).intValue();
        if ((j == 101107) || (j == 101108))
        {
          if (j != 101108) {
            break label2776;
          }
          i = 5;
          if (j != 101108) {
            break label2782;
          }
          VipUtils.b(this.a, 3, ProfileCardUtil.a(i));
        }
        for (;;)
        {
          ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          i = 2;
          break;
          VipUtils.a(this.a, 3, ProfileCardUtil.a(i));
        }
      case 10: 
        if ((((DataTag)localObject1).a instanceof Card))
        {
          this.a.a((Card)((DataTag)localObject1).a);
          return;
        }
        this.a.a(null);
        return;
      case 13: 
        this.a.j();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_clk_myQR", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      case 14: 
        FriendProfileCardActivity.g(this.a);
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8006A7A", "0X8006A7A", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8006A8E", "0X8006A8E", 0, 0, "", "", "", "");
        return;
      case 16: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.app, this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, this.a.jdField_d_of_type_Boolean);
          ReportController.b(this.a.app, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
          return;
        }
        paramView = new Intent(this.a, ProfileCardMoreActivity.class);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.size() > 0)) {
          paramView.putExtra("SHARE_NICK_NAME", ((MQQName)this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
          paramView.putExtra("cur_add_source", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
          paramView.putExtra("key_nick_name", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
        }
        paramView.putExtra("AllInOne", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        paramView.addFlags(536870912);
        this.a.startActivityForResult(paramView, 1012);
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006A8A", "0X8006A8A", 0, 0, "", "", "", "");
        return;
      case 18: 
        this.a.g();
        ReportController.b(this.a.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      case 2: 
        l = System.currentTimeMillis();
        if (!ProfileActivity.a(this.a.jdField_b_of_type_Long, l)) {
          continue;
        }
        this.a.jdField_b_of_type_Long = l;
        ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.app, this.a);
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pro_account_info", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA3", "0X8004FA3", 0, 0, Long.toString(this.a.jdField_c_of_type_Long), "", "", "");
          return;
        }
        ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA5", "0X8004FA5", 0, 0, Long.toString(this.a.jdField_c_of_type_Long), "", "", "");
        return;
      case 21: 
        if ((((DataTag)localObject1).a instanceof ProfileBusiEntry))
        {
          paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
          localObject1 = new Intent(this.a, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("portraitOnly", true);
          ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
        }
      case 19: 
      case 3: 
      case 20: 
      case 26: 
      case 22: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 47: 
      case 32: 
      case 33: 
      case 34: 
      case 39: 
      case 42: 
      case 58: 
      case 41: 
      case 44: 
      case 46: 
      case 45: 
      case 56: 
      case 57: 
        try
        {
          label1080:
          label1365:
          label1853:
          label2646:
          label2776:
          label2782:
          this.a.startActivity((Intent)localObject1);
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004184", "0X8004184", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          boolean bool;
          if ((((DataTag)localObject1).a instanceof Object[]))
          {
            paramView = (Object[])((DataTag)localObject1).a;
            bool = ((Boolean)paramView[0]).booleanValue();
            paramView = (String)paramView[1];
            this.a.a(bool, paramView);
          }
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004183", "0X8004183 ", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          paramView = null;
          if ((((DataTag)localObject1).a instanceof String)) {
            paramView = (String)((DataTag)localObject1).a;
          }
          if ((TextUtils.isEmpty(paramView)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
          {
            paramView = new Intent(this.a, EditActivity.class);
            paramView.putExtra("k_source", 4);
            paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
            this.a.startActivity(paramView);
            ReportController.b(this.a.app, "CliOper", "", "", "0X8006A79", "0X8006A79", 0, 0, "", "", "", "");
            return;
          }
          StatusHistoryActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString, 1, "");
          ReportController.b(this.a.app, "CliOper", "", "", "0X8006A8D", "0X8006A8D", 0, 0, "", "", "", "");
          return;
          this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
          this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.a.app, this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          if ((this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b != null) && (this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a().d == 1))
          {
            this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            paramView = VideoActionSheet.a(this.a);
            paramView.a(2131372446);
            paramView.c(2131368096);
            if ((this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time > 0))
            {
              this.a.l = 1;
              paramView.a(this.a.getResources().getString(2131372444), this.a.getResources().getDrawable(2130839269), 0);
              ReportController.b(this.a.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
            }
            for (;;)
            {
              paramView.d(2131367262);
              paramView.a(new lkr(this));
              paramView.a(new lks(this, paramView));
              paramView.show();
              return;
              if ((this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0))
              {
                this.a.l = 2;
                paramView.a(this.a.getResources().getString(2131372444), this.a.getResources().getDrawable(2130839268), 0);
                ReportController.b(this.a.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
              }
              else
              {
                this.a.l = 5;
                paramView.a(this.a.getResources().getString(2131372444), this.a.getResources().getDrawable(2130839267), 0);
                ReportController.b(this.a.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
              }
            }
          }
          FriendProfileCardActivity.a(this.a.app, this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          return;
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.privilegeJumpUrl;
          paramView = (View)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break label4765;
            }
          }
          label4765:
          for (paramView = "http://mc.vip.qq.com/privilegelist/index";; paramView = "http://mc.vip.qq.com/privilegelist/other?friend=" + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
          {
            localObject1 = new Intent(this.a, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.a.startActivity((Intent)localObject1);
            ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break;
            }
            ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8006A7B", "0X8006A7B", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8006A8F", "0X8006A8F", 0, 0, "", "", "", "");
          return;
          if (!(((DataTag)localObject1).a instanceof ProfileBusiEntry)) {
            continue;
          }
          paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
          this.a.a(paramView.jdField_d_of_type_JavaLangString);
          return;
          Object localObject2;
          if ((((DataTag)localObject1).a instanceof ProfileBusiEntry))
          {
            paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
            localObject2 = new Intent(this.a, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("hide_operation_bar", true);
            ((Intent)localObject2).putExtra("hide_more_button", true);
            this.a.startActivity((Intent)localObject2);
          }
          if (28 != ((DataTag)localObject1).ah) {
            continue;
          }
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004181", "0X8004181", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
            continue;
          }
          paramView = this.a.app.a();
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramView))
          {
            ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X8004435", 0, 0, Long.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", "", VipUtils.a(this.a.app, this.a.app.a()));
            ProfileCardUtil.a(this.a, this.a.app.a(), "inside.myCardBackground", 1, 0, 1, "", true);
            return;
          }
          if ((((DataTag)localObject1).a instanceof String))
          {
            paramView = (String)((DataTag)localObject1).a;
            if ("CLICK_HEADER_BG".equals(paramView)) {
              ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "1", "", "", VipUtils.a(this.a.app, this.a.app.a()));
            }
            for (;;)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80047F0", 0, 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Long.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", VipUtils.a(this.a.app, this.a.app.a()));
              if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
                break;
              }
              localObject2 = this.a.app.getPreferences().getString("profile_card_other_head_click_text", this.a.getString(2131371640));
              localObject1 = ActionSheet.a(this.a);
              ((ActionSheet)localObject1).a(2131371639, 1);
              ((ActionSheet)localObject1).a((CharSequence)localObject2, 1);
              ((ActionSheet)localObject1).a(2131367262, 1);
              ((ActionSheet)localObject1).a(new lkt(this, paramView, (ActionSheet)localObject1));
              try
              {
                ((ActionSheet)localObject1).show();
                this.a.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject1);
                return;
                if ("CLICK_BANNER".equals(paramView)) {
                  ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "2", "", "", VipUtils.a(this.a.app, this.a.app.a()));
                }
              }
              catch (Exception paramView)
              {
                for (;;)
                {
                  paramView.printStackTrace();
                }
              }
            }
            if (!(((DataTag)localObject1).a instanceof ProfileBusiEntry)) {
              continue;
            }
            paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
            paramView = new Intent(this.a, ShowExternalTroopListActivity.class);
            if ((this.a.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.a.jdField_d_of_type_AndroidWidgetTextView.getText()))) {
              paramView.putExtra("leftViewText", this.a.jdField_d_of_type_AndroidWidgetTextView.getText().toString().trim());
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
            for (bool = true;; bool = false)
            {
              paramView.putExtra("isHost", bool);
              paramView.putExtra("dest_uin_str", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              paramView.putExtra("from", 0);
              this.a.startActivityForResult(paramView, 1015);
              if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                break;
              }
              ReportController.b(this.a.app, "P_CliOper", "Grp_join", "", "person_data", "Clk", 0, 0, this.a.g, "1", "", "");
              return;
            }
            ReportController.b(this.a.app, "P_CliOper", "Grp_join", "", "person_data", "Clk", 0, 0, this.a.g, "0", "", "");
            return;
            ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "2", "", "", "");
            paramView = new Intent(this.a, ProfileLabelEditorActivity.class);
            paramView.putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            try
            {
              this.a.startActivityForResult(paramView, 1004);
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              return;
            }
            ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "1", "", "", "");
            paramView = new Intent(this.a, ProfileLabelEditorActivity.class);
            paramView.putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            try
            {
              this.a.startActivityForResult(paramView, 1004);
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              return;
            }
            if (!(((DataTag)localObject1).a instanceof ProfileBusiEntry)) {
              continue;
            }
            paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
            localObject1 = new Intent(this.a, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString + "&_webviewtype=1");
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.a.startActivity((Intent)localObject1);
            return;
            if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
              continue;
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
              ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA7", "0X8004FA7", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              ProfileCardUtil.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId);
              return;
              ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA8", "0X8004FA8", 0, 0, "", "", "", "");
            }
            if (!(((DataTag)localObject1).a instanceof ProfileBusiEntry)) {
              continue;
            }
            ReportController.b(this.a.app, "CliOper", "", "", "0X80055C9", "0X80055C9", 0, 0, "", "", "", "");
            paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
            localObject1 = new Intent(this.a, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.a.startActivity((Intent)localObject1);
            return;
            if (!(((DataTag)localObject1).a instanceof ProfileBusiEntry)) {
              continue;
            }
            ReportController.b(this.a.app, "CliOper", "", "", "0X8005D14", "0X8005D14", 0, 0, "", "", "", "");
            paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
            localObject1 = new Intent(this.a, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            this.a.startActivity((Intent)localObject1);
            return;
            if (!(((DataTag)localObject1).a instanceof ProfileBusiEntry)) {
              continue;
            }
            VipUtils.a(this.a.app, "CliOper", "0X8006E05", "0X8006E05", 0, 0, new String[0]);
            paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
            localObject1 = new Intent(this.a, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.a.startActivity((Intent)localObject1);
            return;
            if (this.a.jdField_c_of_type_JavaLangString == null) {
              continue;
            }
            ReportController.b(this.a.app, "P_CliOper", "Shop_lifeservice", "", "Shop_Ftemplateinto", "0X8005B97", 0, 0, "", "", "", "");
            if (this.a.j == 1)
            {
              paramView = new Intent(this.a, ChatActivity.class);
              if (TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.w("FriendProfileCardActivity", 2, "onItemClick - uin = null");
                return;
              }
              paramView.putExtra("uin", this.a.jdField_c_of_type_JavaLangString);
              paramView.putExtra("uintype", 1008);
              paramView.putExtra("uinname", this.a.jdField_d_of_type_JavaLangString);
              paramView.putExtra("selfSet_leftViewText", this.a.getString(2131371914));
              this.a.startActivity(paramView);
              return;
            }
            paramView = null;
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
            {
              paramView = new Intent();
              paramView.putExtra("report_src_param_type", "gouwu_follow");
              if (!(this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView)) {
                break label6694;
              }
              paramView.putExtra("report_src_param_name", "0X8005D5A");
            }
            for (;;)
            {
              PublicAccountUtil.a(paramView, this.a.app, this.a, this.a.jdField_c_of_type_JavaLangString, this.a.i);
              return;
              label6694:
              paramView.putExtra("report_src_param_name", "0X8005D59");
            }
            if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34)) {
              continue;
            }
            this.a.d();
            return;
            if (!(((DataTag)localObject1).a instanceof BusinessCard)) {
              continue;
            }
            localObject1 = (BusinessCard)((DataTag)localObject1).a;
            paramView = new Intent(this.a, BusinessCardEditActivity.class);
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
              paramView.putExtra("mode_type", 3);
            }
            for (;;)
            {
              paramView.putExtra("cur_card_body", (Parcelable)localObject1);
              paramView.putExtra("is_edit_mode", true);
              paramView.putExtra("finish_immedia", true);
              localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList;
              localObject1 = new ArrayList();
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((ArrayList)localObject1).add(((ProfileActivity.CardContactInfo)((Iterator)localObject2).next()).jdField_c_of_type_JavaLangString);
              }
              paramView.putExtra("mode_type", 2);
              paramView.putExtra("source_activity", 1);
              ((BusinessCard)localObject1).bindUin = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            }
            paramView.putExtra("bind_phone_num", (Serializable)localObject1);
            this.a.startActivity(paramView);
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "0X8006A7F", "0X8006A7F", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(this.a.app, "CliOper", "", "", "0X8006A93", "0X8006A93", 0, 0, "", "", "", "");
            return;
            this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((DataTag)localObject1).a);
            if (this.a.jdField_a_of_type_ArrayOfInt == null) {
              this.a.jdField_a_of_type_ArrayOfInt = new int[5];
            }
            this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
            this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.a.app, this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
            if ((this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b != null) && (this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a().d == 1))
            {
              this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
              this.a.jdField_a_of_type_ArrayOfInt[0] = 19;
              this.a.jdField_a_of_type_ArrayOfInt[1] = 8;
              if ((!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.jdField_a_of_type_JavaLangString))) {
                break label7378;
              }
              this.a.jdField_a_of_type_ArrayOfInt[2] = 9;
              this.a.jdField_a_of_type_ArrayOfInt[3] = 16;
            }
            for (;;)
            {
              i = 4;
              while (i < 5)
              {
                this.a.jdField_a_of_type_ArrayOfInt[i] = -1;
                i += 1;
              }
              this.a.jdField_a_of_type_ArrayOfInt[0] = 7;
              break;
              label7378:
              this.a.jdField_a_of_type_ArrayOfInt[2] = 16;
              this.a.jdField_a_of_type_ArrayOfInt[3] = -1;
            }
            this.a.a(this.a.jdField_a_of_type_ArrayOfInt);
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "0X8006A7E", "0X8006A7E", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(this.a.app, "CliOper", "", "", "0X8006A92", "0X8006A92", 0, 0, "", "", "", "");
            return;
            OlympicUtil.a(this.a.app, "0X8006890", 1, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            localObject1 = (OlympicManager)this.a.app.getManager(166);
            if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.a())))
            {
              if (!((OlympicManager)localObject1).c("HomePage")) {
                continue;
              }
              localObject1 = String.format("http://sqimg.qq.com/qq_product_operations/olympic/detail.html?_wv=16777216&uin=%s&adtag=%s", new Object[] { NearbyURLSafeUtil.a(this.a.app.a()), "profileCard" });
              localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("url", URLUtil.guessUrl((String)localObject1));
              paramView.getContext().startActivity((Intent)localObject2);
              return;
            }
            localObject1 = String.format("http://sqimg.qq.com/qq_product_operations/olympic/detail.html?_wv=16777216&uin=%s&adtag=%s", new Object[] { NearbyURLSafeUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), "profileCard" });
            localObject2 = JumpParser.a((QQAppInterface)BaseApplicationImpl.a().a(), paramView.getContext(), (String)localObject1);
            if (localObject2 != null)
            {
              ((JumpAction)localObject2).b();
              return;
            }
            localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", URLUtil.guessUrl((String)localObject1));
            paramView.getContext().startActivity((Intent)localObject2);
            return;
            if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
            {
              this.a.app.a().getSharedPreferences(this.a.app.a(), 0).edit().putBoolean("svip_profile_show_newer_guide_flag", true).commit();
              this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((DataTag)localObject1).a);
            if (this.a.jdField_a_of_type_ArrayOfInt == null) {
              this.a.jdField_a_of_type_ArrayOfInt = new int[5];
            }
            this.a.jdField_a_of_type_ArrayOfInt[0] = 20;
            this.a.jdField_a_of_type_ArrayOfInt[1] = 21;
            this.a.jdField_a_of_type_ArrayOfInt[2] = 16;
            i = 3;
            while (i < 5)
            {
              this.a.jdField_a_of_type_ArrayOfInt[i] = -1;
              i += 1;
            }
            this.a.a(this.a.jdField_a_of_type_ArrayOfInt);
            ReportController.b(this.a.app, "CliOper", "", "", "0X8006A84", "0X8006A84", 0, 0, "", "", "", "");
            return;
          }
        }
        catch (SecurityException paramView)
        {
          for (;;)
          {
            continue;
            paramView = "CLICK_HEADER_BG";
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */