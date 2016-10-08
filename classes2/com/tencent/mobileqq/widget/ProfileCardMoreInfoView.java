package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileGameView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import wnl;
import wnn;
import wno;
import wnp;
import wnr;

public class ProfileCardMoreInfoView
  extends LinearLayout
  implements PhotoWallView.PhotoWallUpdaterListener
{
  private static final int jdField_a_of_type_Int = 15;
  private static final String jdField_a_of_type_JavaLangString = "map_key_account_info";
  private static final int jdField_b_of_type_Int = 15;
  private static final String jdField_b_of_type_JavaLangString = "map_key_sig";
  private static final String jdField_c_of_type_JavaLangString = "map_key_phone_";
  private static final String jdField_d_of_type_JavaLangString = "map_key_qzone_feed";
  private static final String jdField_e_of_type_JavaLangString = "map_key_diamond";
  private static final String jdField_f_of_type_JavaLangString = "map_key_qzone_photo";
  private static final String jdField_g_of_type_JavaLangString = "map_key_nick";
  private static final String jdField_h_of_type_JavaLangString = "map_key_recommendname";
  private static final String jdField_i_of_type_JavaLangString = "map_key_circlenick";
  private static final String jdField_j_of_type_JavaLangString = "map_key_troopnick";
  private static final String k = "map_key_remark";
  private static final String l = "map_key_tag";
  private static final String m = "map_key_qqloginday";
  private static final String n = "map_key_lightalk";
  private static final String o = "map_key_third_part_app_entrance";
  private static final String p = "map_key_shopping_photo";
  private static final String q = "map_key_business_card_num";
  private static final String r = "map_key_business_card";
  private static final String s = "map_key_photo_wall";
  private static final String t = "map_key_drawer";
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  public ProfileCardInfo a;
  public ProfileCardTemplate a;
  public ProfileHeaderView a;
  public RichStatus a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public boolean a;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private float jdField_b_of_type_Float;
  private ColorDrawable jdField_b_of_type_AndroidGraphicsDrawableColorDrawable;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  protected boolean b;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private boolean jdField_h_of_type_Boolean;
  private boolean jdField_i_of_type_Boolean;
  private boolean jdField_j_of_type_Boolean;
  
  public ProfileCardMoreInfoView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "map_key_tag", "map_key_account_info", "map_key_nick", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_sig", "map_key_lightalk", "map_key_diamond", "map_key_qzone_feed", "map_key_qzone_photo", "map_key_shopping_photo", "map_key_qqloginday", "map_key_drawer", "map_key_phone_", "map_key_business_card_num", "map_key_business_card", "map_key_third_part_app_entrance", "map_key_photo_wall" };
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "map_key_nick", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_phone_" };
    a(paramContext);
  }
  
  public ProfileCardMoreInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "map_key_tag", "map_key_account_info", "map_key_nick", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_sig", "map_key_lightalk", "map_key_diamond", "map_key_qzone_feed", "map_key_qzone_photo", "map_key_shopping_photo", "map_key_qqloginday", "map_key_drawer", "map_key_phone_", "map_key_business_card_num", "map_key_business_card", "map_key_third_part_app_entrance", "map_key_photo_wall" };
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "map_key_nick", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_phone_" };
    a(paramContext);
  }
  
  private int a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, String paramString, Card paramCard)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Object localObject2 = paramTextView.getPaint();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.jdField_c_of_type_Float;
    }
    float f1 = 0.0F;
    int i1 = 0;
    if ((paramString.endsWith("BP")) || (paramString.endsWith("BG")))
    {
      f1 = ((TextPaint)localObject1).measureText("BP");
      i1 = 25;
    }
    localObject2 = new StringBuffer(paramString);
    int i2;
    label199:
    label226:
    int i4;
    int i3;
    if ((paramBoolean1) || (paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      f1 = ((TextPaint)localObject1).measureText(paramString) - f1 + i1 * this.jdField_c_of_type_Float;
      i2 = (int)(f1 % this.jdField_b_of_type_Float);
      if (paramBoolean1) {
        if (paramCard.iQQVipType == 1)
        {
          i1 = 42;
          f1 = 10 + i1;
          f1 = this.jdField_c_of_type_Float;
          f1 = i2;
          i1 = (int)((i1 + 10) * this.jdField_c_of_type_Float + f1);
          if (this.jdField_b_of_type_Float - i1 >= 0.0F) {
            break label680;
          }
          i1 = 2;
          ((StringBuffer)localObject2).append("\n");
          i2 = 1;
          if (!paramBoolean1) {
            break label775;
          }
          i4 = paramCard.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
          i3 = i4;
          if (i4 < 1) {
            i3 = 1;
          }
          if (paramCard.iQQVipType != 1) {
            break label697;
          }
          if (i2 == 0) {
            break label689;
          }
          paramCard = "S";
          label271:
          ((StringBuffer)localObject2).append(paramCard);
          paramCard = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/year_svip_" + i3 + ".png";
          this.jdField_a_of_type_JavaLangStringBuilder.append("年费超级会员").append(i3).append("级");
        }
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append(" ");
      localObject1 = ((StringBuffer)localObject2).toString();
      localObject2 = getResources();
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject1);
      i2 = paramString.length() - 2;
      label367:
      if (i2 < ((String)localObject1).length())
      {
        paramString = null;
        String str = ((String)localObject1).substring(i2, i2 + 1);
        label431:
        Drawable localDrawable;
        double d1;
        if (("S".equalsIgnoreCase(str)) && (!TextUtils.isEmpty(paramCard)))
        {
          paramString = getResources();
          if (str.equals("S"))
          {
            i3 = 2130841111;
            localDrawable = paramString.getDrawable(i3);
            paramString = URLDrawable.getDrawable(paramCard, localDrawable, localDrawable);
            i3 = localDrawable.getIntrinsicHeight();
            if (!str.equals("S")) {
              break label1020;
            }
            d1 = 85.0D * (i3 / 27.0D);
            label481:
            paramString.setBounds(0, 0, (int)d1, i3);
          }
        }
        for (;;)
        {
          if ((!TextUtils.isEmpty(str)) && (paramString != null)) {
            localSpannableString.setSpan(new ImageSpan(paramString, 1), i2, i2 + 1, 33);
          }
          if ((paramString != null) && ((paramString instanceof URLDrawable))) {
            ((URLDrawable)paramString).setURLDrawableListener(new wno(this, paramTextView));
          }
          i2 += 1;
          break label367;
          i1 = 34;
          break;
          if (paramBoolean2)
          {
            if (paramCard.iQQVipType == 1) {}
            for (i1 = 38;; i1 = 29)
            {
              f1 = 10 + i1;
              f1 = this.jdField_c_of_type_Float;
              f1 = i2;
              i1 = (int)((i1 + 10) * this.jdField_c_of_type_Float + f1);
              break;
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label1356;
          }
          f1 = 33;
          f1 = this.jdField_c_of_type_Float;
          i1 = (int)(i2 + 33 * this.jdField_c_of_type_Float);
          break label199;
          label680:
          i1 = 1;
          i2 = 0;
          break label226;
          label689:
          paramCard = "BS";
          break label271;
          label697:
          if (i2 != 0) {}
          for (paramCard = "s";; paramCard = "Bs")
          {
            ((StringBuffer)localObject2).append(paramCard);
            paramCard = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/svip_" + i3 + ".png";
            this.jdField_a_of_type_JavaLangStringBuilder.append("超级会员").append(i3).append("级");
            break;
          }
          label775:
          if (paramBoolean2)
          {
            i4 = paramCard.getVipLevel(EVIPSPEC.E_SP_QQVIP);
            i3 = i4;
            if (i4 < 1) {
              i3 = 1;
            }
            if (paramCard.iQQVipType == 1)
            {
              if (i2 != 0) {}
              for (paramCard = "V";; paramCard = "BV")
              {
                ((StringBuffer)localObject2).append(paramCard);
                paramCard = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/year_vip_" + i3 + ".png";
                this.jdField_a_of_type_JavaLangStringBuilder.append("年费QQ会员").append(i3).append("级");
                break;
              }
            }
            if (i2 != 0) {}
            for (paramCard = "v";; paramCard = "Bv")
            {
              ((StringBuffer)localObject2).append(paramCard);
              paramCard = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/vip_" + i3 + ".png";
              this.jdField_a_of_type_JavaLangStringBuilder.append("QQ会员").append(i3).append("级");
              break;
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
            if (i2 == 0) {
              break label1004;
            }
          }
          label1004:
          for (paramCard = "N";; paramCard = "BN")
          {
            ((StringBuffer)localObject2).append(paramCard);
            paramCard = null;
            break;
          }
          i3 = 2130841101;
          break label431;
          label1020:
          d1 = 67.0D * (i3 / 27.0D);
          break label481;
          if (("V".equalsIgnoreCase(str)) && (!TextUtils.isEmpty(paramCard)))
          {
            paramString = getResources();
            if (str.equals("V"))
            {
              i3 = 2130841112;
              label1077:
              localDrawable = paramString.getDrawable(i3);
              paramString = URLDrawable.getDrawable(paramCard, localDrawable, localDrawable);
              i3 = localDrawable.getIntrinsicHeight();
              if (!str.equals("V")) {
                break label1151;
              }
            }
            label1151:
            for (d1 = 76.0D * (i3 / 26.0D);; d1 = 58.0D * (i3 / 26.0D))
            {
              paramString.setBounds(0, 0, (int)d1, i3);
              break;
              i3 = 2130841107;
              break label1077;
            }
          }
          if ("N".equals(str))
          {
            paramString = ((Resources)localObject2).getDrawable(2130841084);
            paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          }
          else if ("B".equals(str))
          {
            paramString = ((Resources)localObject2).getDrawable(2130841108);
            paramString.setBounds(0, 0, (int)(10.0F * this.jdField_c_of_type_Float), paramString.getIntrinsicHeight());
          }
          else if ("P".equalsIgnoreCase(str))
          {
            paramString = getResources().getDrawable(2130841089);
            i3 = paramString.getIntrinsicHeight();
            paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), i3);
          }
          else if ("G".equalsIgnoreCase(str))
          {
            paramString = getResources().getDrawable(2130841088);
            i3 = paramString.getIntrinsicHeight();
            paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), i3);
          }
        }
      }
      paramTextView.setText(localSpannableString);
      return i1;
      label1356:
      i1 = i2;
      break label199;
      paramCard = null;
      i1 = 0;
    }
  }
  
  private View a(LayoutInflater paramLayoutInflater, View paramView, ProfileActivity.CardContactInfo paramCardContactInfo, String paramString)
  {
    if (paramCardContactInfo == null) {
      return paramView;
    }
    Object localObject = paramView;
    if (paramView == null) {
      localObject = (LinearLayout)paramLayoutInflater.inflate(2130904299, null);
    }
    paramLayoutInflater = (TextView)((View)localObject).findViewById(2131297123);
    paramView = (TextView)((View)localObject).findViewById(2131297124);
    ImageView localImageView = (ImageView)((View)localObject).findViewById(2131296790);
    ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
    localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18.0F);
    localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18.0F);
    localImageView.setLayoutParams(localLayoutParams);
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130840617);
    localImageView = (ImageView)((View)localObject).findViewById(2131297122);
    if (localImageView.getVisibility() != 0) {
      localImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramLayoutInflater.setText(paramCardContactInfo.jdField_a_of_type_JavaLangString);
      paramView.setText(paramCardContactInfo.c);
      ((View)localObject).setTag(new DataTag(4, paramCardContactInfo));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      paramCardContactInfo = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label446;
      }
      paramCardContactInfo.append(a(2131362016));
    }
    for (;;)
    {
      paramCardContactInfo.append(":").append(paramView.getText());
      ((View)localObject).setContentDescription(paramCardContactInfo.toString());
      a(paramString, paramLayoutInflater, paramView, localImageView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005AFB", "0X8005AFB", 0, 0, "", "", "", "");
      return (View)localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80))
      {
        paramLayoutInflater.setText(2131369954);
        paramView.setText(paramCardContactInfo.c);
        break;
      }
      paramLayoutInflater.setText(2131369954);
      paramView.setText(paramCardContactInfo.jdField_a_of_type_JavaLangString + " " + paramCardContactInfo.c);
      break;
      label446:
      paramCardContactInfo.append(a(2131362015));
    }
  }
  
  private String a(TextView paramTextView, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = localTextPaint;
    if (localTextPaint == null)
    {
      paramTextView = new TextPaint(1);
      paramTextView.density = this.jdField_c_of_type_Float;
    }
    int i1 = (int)((int)(paramTextView.measureText(paramString) % this.jdField_b_of_type_Float) + 25 * this.jdField_c_of_type_Float);
    if (this.jdField_b_of_type_Float - i1 < 0.0F) {
      localStringBuffer.append("\n");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      if (paramBoolean) {
        localStringBuffer.append("BP");
      }
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("BG");
      continue;
      if (paramBoolean) {
        localStringBuffer.append("BP");
      }
    }
  }
  
  private String a(String paramString)
  {
    if ("map_key_nick".equals(paramString)) {
      return a(2131369968);
    }
    if ("map_key_circlenick".equals(paramString)) {
      return a(2131369970);
    }
    if ("map_key_remark".equals(paramString)) {
      return a(2131369969);
    }
    if ("map_key_recommendname".equals(paramString)) {
      return a(2131369972);
    }
    if ("map_key_troopnick".equals(paramString)) {
      return a(2131369973);
    }
    return null;
  }
  
  private List a(HashMap paramHashMap, String[] paramArrayOfString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i1;
    int i2;
    label23:
    Object localObject;
    if ((paramHashMap == null) || (paramArrayOfString == null))
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1) {
        break label221;
      }
      localObject = paramArrayOfString[i2];
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap == null)) {
        break label121;
      }
      if ((!"map_key_sig".equals(localObject)) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_sign"))) {
        break label95;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label23;
      i1 = paramArrayOfString.length;
      break;
      label95:
      if ((!"map_key_qqloginday".equals(localObject)) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_login_day_icon"))) {
        label121:
        if ("map_key_phone_".equals(localObject))
        {
          int i3 = 0;
          while (i3 < paramInt)
          {
            localObject = (View)paramHashMap.get("map_key_phone_" + String.valueOf(i3));
            if (localObject != null) {
              localArrayList.add(localObject);
            }
            i3 += 1;
          }
        }
        else
        {
          localObject = (View)paramHashMap.get(localObject);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    label221:
    return localArrayList;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initCommonWidth");
    }
    paramContext = getResources();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Float = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i1 = paramContext.getDimensionPixelSize(2131493014);
    int i2 = paramContext.getDimensionPixelSize(2131493002);
    int i3 = paramContext.getDimensionPixelSize(2131492999);
    float f1 = this.jdField_c_of_type_Float;
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i2 - 12.0F * f1 - i3 * 2 - i1 * 2);
    this.jdField_c_of_type_Int = 4;
    for (i1 = (int)((this.jdField_c_of_type_Int * 44 + (this.jdField_c_of_type_Int - 1) * 10) * this.jdField_c_of_type_Float); (i1 > this.jdField_b_of_type_Float) && (this.jdField_c_of_type_Int >= 1); i1 = (int)((this.jdField_c_of_type_Int * 44 + (this.jdField_c_of_type_Int - 1) * 10) * this.jdField_c_of_type_Float)) {
      this.jdField_c_of_type_Int -= 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout|mMaxGameLogoNum = " + this.jdField_c_of_type_Int);
    }
  }
  
  private void a(ViewGroup paramViewGroup, Card paramCard, List paramList)
  {
    paramViewGroup.removeAllViews();
    int i3 = paramList.size();
    int i1 = (int)DeviceInfoUtil.h();
    Object localObject1;
    int i4;
    int i2;
    label75:
    ProfileBusiEntry localProfileBusiEntry;
    if (i3 <= 4)
    {
      i1 /= 4;
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = null;
      i4 = getResources().getDimensionPixelSize(2131493549);
      i2 = 0;
      if (i2 >= i3) {
        break label1100;
      }
      localProfileBusiEntry = (ProfileBusiEntry)paramList.get(i2);
      if (localProfileBusiEntry != null) {
        break label124;
      }
    }
    label124:
    while (((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileGameView)) && (localProfileBusiEntry != null) && (localProfileBusiEntry.jdField_a_of_type_Int == 1))
    {
      i2 += 1;
      break label75;
      i1 = i1 * 146 / 640;
      break;
    }
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904291, null);
    Object localObject4 = (ImageView)localView.findViewById(2131300666);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130841057);
      label194:
      Object localObject3 = localProfileBusiEntry.jdField_a_of_type_JavaLangString;
      String str = localProfileBusiEntry.b;
      localObject1 = localProfileBusiEntry.c;
      if ((localObject1 != null) && (5 < ((String)localObject1).length()))
      {
        localObject1 = ((String)localObject1).substring(0, 5) + "...";
        label257:
        if ((localProfileBusiEntry.jdField_a_of_type_Int == 1024) && (TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject3 = "http://s.url.cn/pub/img/qb_group_normal.png";
          try
          {
            label281:
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mRequestHeight = i4;
            localURLDrawableOptions.mRequestWidth = i4;
            localObject3 = URLDrawable.getDrawable((String)localObject3, localURLDrawableOptions);
            ((URLDrawable)localObject3).setTag(URLDrawableDecodeHandler.a(i4, i4, (int)(10.0F * DeviceInfoUtil.a())));
            ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.b);
            if (localObject3 != null)
            {
              if (localProfileBusiEntry.jdField_a_of_type_Int == 6) {
                ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
              }
              ((ImageView)localObject4).setImageDrawable((Drawable)localObject3);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            localObject1 = new DataTag(19, new Object[] { Boolean.valueOf(paramCard.isOpenRecentPlayingGamesByNative()), paramCard.strProfileUrl, localProfileBusiEntry });
            if (this.e) {
              break label1132;
            }
          }
          localObject3 = (TextView)localView.findViewById(2131300667);
          ((TextView)localObject3).setText(str);
          localObject4 = (TextView)localView.findViewById(2131299988);
          ((TextView)localObject4).setText((CharSequence)localObject1);
          localView.setContentDescription(str + (String)localObject1);
          a("map_key_third_part_app_entrance", (TextView)localObject4, (TextView)localObject3, null);
          switch (localProfileBusiEntry.jdField_a_of_type_Int)
          {
          default: 
            localObject1 = new DataTag(27, localProfileBusiEntry);
          }
        }
      }
    }
    label1100:
    label1132:
    for (;;)
    {
      localView.setTag(localObject1);
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.addView(localView, new LinearLayout.LayoutParams(i1, -2));
      localObject1 = localObject2;
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004315 ", "0X8004315 ", 0, 0, "", "", "", "");
      this.e = true;
      continue;
      localObject1 = new DataTag(22, localProfileBusiEntry);
      if (!this.f)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004314", "0X8004314", 0, 0, "", "", "", "");
        this.f = true;
        continue;
        localObject1 = new DataTag(21, localProfileBusiEntry);
        if (!this.jdField_d_of_type_Boolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004316", "0X8004316", 0, 0, "", "", "", "");
          this.jdField_d_of_type_Boolean = true;
          continue;
          localObject1 = new DataTag(28, localProfileBusiEntry);
          if (!this.jdField_c_of_type_Boolean)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004300", "0X8004300", 0, 0, "", "", "", "");
            this.jdField_c_of_type_Boolean = true;
            continue;
            localObject1 = new DataTag(33, localProfileBusiEntry);
            continue;
            localObject1 = new DataTag(30, localProfileBusiEntry);
            continue;
            localObject1 = new DataTag(39, localProfileBusiEntry);
            if (!this.h)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055CB", "0X80055CB", 0, 0, "", "", "", "");
              this.h = true;
              continue;
              localObject1 = new DataTag(42, localProfileBusiEntry);
              if (!this.i)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D15", "0X8005D15", 0, 0, "", "", "", "");
                this.i = true;
                continue;
                localObject1 = new DataTag(58, localProfileBusiEntry);
                if (!this.j)
                {
                  VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "0X8006E04", "0X8006E04", 0, 0, new String[0]);
                  this.j = true;
                  continue;
                  return;
                  break label281;
                  break label257;
                  localObject2 = localObject1;
                  break label194;
                }
                continue;
              }
              continue;
            }
            continue;
          }
          continue;
        }
        continue;
      }
    }
  }
  
  private void a(TextView paramTextView, View paramView, int paramInt)
  {
    paramView.setVisibility(0);
    paramTextView.setVisibility(8);
    paramView.setBackgroundResource(paramInt);
  }
  
  private void a(String paramString, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap.size() > 0))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.i));
        ProfileCardTemplate.a(paramTextView1, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTitleColor");
        ProfileCardTemplate.a(paramTextView2, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemContentColor");
        ProfileCardTemplate.a(paramImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemMoreSrc");
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(0));
      if (paramTextView1 != null) {
        paramTextView1.setTextColor(getResources().getColorStateList(2131428302));
      }
      if (paramTextView2 != null) {
        paramTextView2.setTextColor(getResources().getColorStateList(2131428262));
      }
      if (paramImageView != null)
      {
        paramImageView.setImageResource(2130838201);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateItemTheme exception msg=" + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  private void a(StringBuilder paramStringBuilder, List paramList)
  {
    if ((paramStringBuilder == null) || (paramList == null)) {}
    int i1;
    do
    {
      return;
      i1 = 0;
    } while (i1 >= paramList.size());
    switch (((PrivilegeInfo)paramList.get(i1)).iType)
    {
    }
    for (;;)
    {
      i1 += 1;
      break;
      paramStringBuilder.append("会员");
      continue;
      paramStringBuilder.append("超级QQ");
      continue;
      paramStringBuilder.append("好莱坞会员");
      continue;
      paramStringBuilder.append("超级会员");
      continue;
      paramStringBuilder.append("腾讯图书VIP");
      continue;
      paramStringBuilder.append("情侣黄钻");
      continue;
      paramStringBuilder.append("绿钻");
      continue;
      paramStringBuilder.append("红钻");
      continue;
      paramStringBuilder.append("超级星钻");
      continue;
      paramStringBuilder.append("黄钻");
    }
  }
  
  private void a(List paramList, LinearLayout paramLinearLayout)
  {
    float f1 = 24.0F * this.jdField_c_of_type_Float;
    float f2 = this.jdField_c_of_type_Float;
    float f3 = 5.0F * this.jdField_c_of_type_Float;
    if ((paramLinearLayout == null) || (paramList == null) || (paramList.size() < 1)) {}
    ArrayList localArrayList;
    int i1;
    Object localObject1;
    do
    {
      return;
      localArrayList = new ArrayList();
      i1 = 0;
      while (i1 < paramList.size())
      {
        localObject1 = ((PrivilegeInfo)paramList.get(i1)).strDeluxeIconUrl;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        localObject1 = ((PrivilegeInfo)paramList.get(i1)).strIconUrl;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        i1 += 1;
      }
    } while (localArrayList.size() < 1);
    int i4 = (int)((this.jdField_b_of_type_Float + f3) / (f1 + f3));
    int i5 = localArrayList.size();
    if (i5 > i4)
    {
      i1 = i5 / i4;
      if (i5 % i4 > 0) {
        i1 += 1;
      }
    }
    for (;;)
    {
      paramList = new ColorDrawable(16777215);
      int i2 = 0;
      label221:
      if (i2 < i1)
      {
        localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        if (i2 != 0) {
          break label351;
        }
      }
      int i3;
      int i6;
      label351:
      for (((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(7.0F * this.jdField_c_of_type_Float));; ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(5.0F * this.jdField_c_of_type_Float)))
      {
        if (i2 == i1 - 1) {
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = ((int)(7.0F * this.jdField_c_of_type_Float));
        }
        ((LinearLayout)localObject1).setOrientation(0);
        ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i3 = 0;
        if (i3 < i4)
        {
          i6 = i2 * i4 + i3;
          if (i6 != i5) {
            break label368;
          }
        }
        paramLinearLayout.addView((View)localObject1);
        i2 += 1;
        break label221;
        break;
      }
      label368:
      Object localObject2 = (String)localArrayList.get(i6);
      URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject3 = new LinearLayout.LayoutParams((int)f1, (int)(24.0F * f2));
      if (i3 == 0) {}
      for (((LinearLayout.LayoutParams)localObject3).leftMargin = 0;; ((LinearLayout.LayoutParams)localObject3).leftMargin = ((int)f3))
      {
        localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = URLDrawable.getDrawable((String)localObject2, paramList, paramList);
        if (((URLDrawable)localObject3).getStatus() == 2) {
          localURLImageView.setVisibility(8);
        }
        localURLImageView.setBackgroundDrawable((Drawable)localObject3);
        localURLImageView.setURLDrawableDownListener(new wnn(this, (String)localObject2, localURLImageView));
        ((LinearLayout)localObject1).addView(localURLImageView);
        i3 += 1;
        break;
      }
      continue;
      i1 = 1;
    }
  }
  
  private boolean a()
  {
    HashMap localHashMap;
    int i2;
    label40:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a != null)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.size();
      localHashMap = new HashMap();
      i2 = 0;
      if (i2 >= i1) {
        break label215;
      }
      localObject = (MQQName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.get(i2);
      if (localObject != null) {
        break label85;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label40;
      i1 = 0;
      break;
      label85:
      switch (((MQQName)localObject).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
        localHashMap.put("map_key_nick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 2: 
        localHashMap.put("map_key_circlenick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 1: 
        localHashMap.put("map_key_troopnick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 5: 
        localHashMap.put("map_key_recommendname", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 4: 
        localHashMap.put("map_key_remark", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 3: 
        localHashMap.put("map_key_phone_", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
      }
    }
    label215:
    int i1 = 0;
    boolean bool = false;
    if (i1 < this.jdField_b_of_type_ArrayOfJavaLangString.length)
    {
      localObject = (String)localHashMap.get(this.jdField_b_of_type_ArrayOfJavaLangString[i1]);
      if ((a(this.jdField_b_of_type_ArrayOfJavaLangString[i1], (String)localObject)) || (bool)) {}
      for (bool = true;; bool = false)
      {
        i1 += 1;
        break;
      }
    }
    return bool;
  }
  
  private boolean a(Card paramCard)
  {
    boolean bool2;
    if ((paramCard == null) || (!paramCard.showLightalk) || (StringUtil.b(paramCard.lightalkNick)))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_lightalk");
      bool2 = false;
      return bool2;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_lightalk");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904299, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_lightalk", localView);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131297123);
      TextView localTextView2 = (TextView)localView.findViewById(2131297124);
      ImageView localImageView = (ImageView)localView.findViewById(2131297122);
      localTextView1.setText(2131371950);
      Drawable localDrawable = getContext().getResources().getDrawable(2130841036);
      localView.setClickable(true);
      localView.setContentDescription("来电帐号" + paramCard.lightalkNick + "点击进入");
      localView.setTag(new DataTag(35, null));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      localImageView.setVisibility(0);
      localTextView2.setVisibility(0);
      localTextView2.setText(paramCard.lightalkNick);
      localTextView2.setSingleLine(true);
      localTextView2.setEllipsize(TextUtils.TruncateAt.END);
      localTextView2.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      localTextView2.setCompoundDrawablePadding(ProfileCardUtil.a(getContext(), 6));
      a("map_key_lightalk", localTextView1, localTextView2, localImageView);
      bool2 = bool1;
      if (this.g) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005109", "0X8005109", 0, 0, "", "", "", "");
      return bool1;
    }
  }
  
  private boolean a(Card paramCard, BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    paramCard = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_business_card");
    Object localObject = paramCard;
    if (paramCard == null)
    {
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904296, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_business_card", localObject);
    }
    int i1;
    TextView localTextView;
    URLImageView localURLImageView;
    ImageView localImageView;
    if (paramBusinessCard.cardType == 1)
    {
      i1 = 1;
      ((View)localObject).findViewById(2131296790);
      localTextView = (TextView)((View)localObject).findViewById(2131297124);
      localURLImageView = (URLImageView)((View)localObject).findViewById(2131297125);
      localImageView = (ImageView)((View)localObject).findViewById(2131297122);
      paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
      if (i1 != 0) {
        paramCard = paramBusinessCard.cardName;
      }
      if (TextUtils.isEmpty(paramBusinessCard.company)) {
        break label251;
      }
      paramCard = paramBusinessCard.company;
    }
    for (;;)
    {
      label139:
      BusinessCardUtils.a(paramBusinessCard.picUrl, localURLImageView, localTextView, paramCard);
      ((View)localObject).setTag(new DataTag(46, paramBusinessCard));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.j) {
        if (paramBusinessCard.picUrl != null) {
          break label333;
        }
      }
      for (;;)
      {
        ((View)localObject).setContentDescription(getResources().getString(2131371247, new Object[] { paramCard, "", "", "" }));
        a("map_key_business_card", null, localTextView, localImageView);
        return true;
        i1 = 0;
        break;
        label251:
        if ((paramBusinessCard.descs != null) && (paramBusinessCard.descs.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.descs.get(0))))
        {
          paramCard = (String)paramBusinessCard.descs.get(0);
          break label139;
        }
        if (!TextUtils.isEmpty(paramCard)) {
          break label139;
        }
        if (!TextUtils.isEmpty(paramBusinessCard.cardId)) {
          break label341;
        }
        paramCard = "未添加";
        break label139;
        label333:
        paramCard = paramBusinessCard.cardName;
      }
      label341:
      paramCard = "";
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool = b(paramCard, paramBoolean);
    return (c(paramCard, paramBoolean)) || (bool);
  }
  
  private boolean a(RichStatus paramRichStatus)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramRichStatus == null) || (Arrays.equals(paramRichStatus.encode(), RichStatus.getEmptyStatus().encode())))) {
      return (View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_sig") != null;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sig");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904309, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sig", localView);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      TextView localTextView = (TextView)localView.findViewById(2131297124);
      ImageView localImageView = (ImageView)localView.findViewById(2131297122);
      StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      Resources localResources = getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        ProfileCardUtil.a(localResources, localView, localStatusManager, paramRichStatus, bool2);
        if ((paramRichStatus == null) || (TextUtils.isEmpty(paramRichStatus.actionText))) {
          break label280;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
        label197:
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
          break label288;
        }
        localImageView.setVisibility(0);
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        a("map_key_sig", null, localTextView, localImageView);
        return bool1;
        bool2 = false;
        break;
        label280:
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
        break label197;
        label288:
        localImageView.setVisibility(8);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if ("map_key_nick".equals(paramString)) {}
    while (("map_key_circlenick".equals(paramString)) || ("map_key_remark".equals(paramString)) || ("map_key_recommendname".equals(paramString)) || ("map_key_troopnick".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!a(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1) != null) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904299, null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localView);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131297123);
      localTextView1.setText(a(paramString1));
      TextView localTextView2 = (TextView)localView.findViewById(2131297124);
      localTextView2.setText(paramString2);
      localView.setTag(new DataTag(11, paramString2));
      localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      ImageView localImageView = (ImageView)localView.findViewById(2131297122);
      if (localImageView.getVisibility() != 4) {
        localImageView.setVisibility(4);
      }
      localView.setContentDescription(a(paramString1) + ":" + paramString2);
      a(paramString1, localTextView1, localTextView2, localImageView);
      return bool;
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    if ((ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80))
    {
      label44:
      Object localObject;
      View localView;
      ProfileActivity.CardContactInfo localCardContactInfo;
      if (paramArrayList != null)
      {
        i1 = paramArrayList.size();
        i2 = 0;
        bool = false;
        if (i2 >= i1) {
          break label177;
        }
        localObject = "map_key_phone_" + String.valueOf(i2);
        localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        localCardContactInfo = (ProfileActivity.CardContactInfo)paramArrayList.get(i2);
        if (localCardContactInfo != null) {
          break label148;
        }
        localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        if ((!bool) && (localObject == null)) {
          break label142;
        }
        bool = true;
      }
      for (;;)
      {
        i2 += 1;
        break label44;
        i1 = 0;
        break;
        label142:
        bool = false;
        continue;
        label148:
        localView = a(this.jdField_a_of_type_AndroidViewLayoutInflater, localView, localCardContactInfo, (String)localObject);
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject, localView);
        bool = true;
      }
      label177:
      int i2 = i1;
      if (i2 < this.jdField_d_of_type_Int)
      {
        paramArrayList = "map_key_phone_" + String.valueOf(i2);
        paramArrayList = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramArrayList);
        if ((bool) || (paramArrayList != null)) {}
        for (bool = true;; bool = false)
        {
          i2 += 1;
          break;
        }
      }
      this.jdField_d_of_type_Int = i1;
      return bool;
    }
    int i1 = 0;
    boolean bool = false;
    if (i1 < this.jdField_d_of_type_Int)
    {
      paramArrayList = "map_key_phone_" + String.valueOf(i1);
      paramArrayList = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramArrayList);
      if ((bool) || (paramArrayList != null)) {}
      for (bool = true;; bool = false)
      {
        i1 += 1;
        break;
      }
    }
    this.jdField_d_of_type_Int = 0;
    return bool;
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {}
    for (int i1 = 1; (!this.jdField_a_of_type_Boolean) || (i1 == 0); i1 = 0)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_drawer");
      return false;
    }
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_third_part_app_entrance")) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_business_card_num")) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_business_card")))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_drawer");
      return false;
    }
    if ((this.jdField_a_of_type_Boolean) && (i1 != 0))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_third_part_app_entrance");
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_business_card_num");
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_business_card");
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_drawer");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904301, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_drawer", localObject1);
    }
    localObject2 = (TextView)((View)localObject1).findViewById(2131302240);
    ((View)localObject1).setOnClickListener(new wnr(this));
    return true;
  }
  
  private boolean b(Card paramCard)
  {
    if (paramCard == null) {
      return false;
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_diamond");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904300, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_diamond", localObject1);
    }
    localObject2 = (ImageView)((View)localObject1).findViewById(2131297122);
    ((ImageView)localObject2).setVisibility(0);
    ((View)localObject1).setTag(new DataTag(26, null));
    ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    a("map_key_diamond", null, null, (ImageView)localObject2);
    ThreadManager.a(new wnl(this, paramCard, (View)localObject1), 8, null, true);
    return true;
  }
  
  private boolean b(Card paramCard, BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    if ((!paramBoolean) && (!paramCard.hasCardInfo()))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_business_card_num");
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList = new ArrayList();
    paramCard = ((ArrayList)localObject1).iterator();
    while (paramCard.hasNext()) {
      localArrayList.add((ProfileActivity.CardContactInfo)paramCard.next());
    }
    Object localObject2 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.profilecard.FrdProfileCard", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
    }
    int i1;
    int i2;
    label125:
    Object localObject3;
    if (paramBusinessCard.mobilesNum == null)
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1) {
        break label309;
      }
      paramCard = (String)paramBusinessCard.mobilesNum.get(i2);
      if (!TextUtils.isEmpty(paramCard))
      {
        localObject3 = paramBusinessCard.getMobileInfoByMobile(paramCard);
        if ((localObject3 == null) || (TextUtils.isEmpty(((CardMobileInfo)localObject3).d))) {
          break label644;
        }
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        ProfileActivity.CardContactInfo localCardContactInfo;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localCardContactInfo = (ProfileActivity.CardContactInfo)localIterator.next();
        } while (!((CardMobileInfo)localObject3).d.equals(localCardContactInfo.c));
      }
    }
    label301:
    label309:
    label390:
    label612:
    label623:
    label636:
    label644:
    for (int i3 = 0;; i3 = 1)
    {
      if (i3 != 0)
      {
        localObject3 = new ProfileActivity.CardContactInfo(null, paramCard, null);
        if (localObject2 != null)
        {
          paramCard = ((PhoneContactManager)localObject2).b(paramCard);
          if (paramCard != null) {
            break label301;
          }
        }
      }
      for (paramCard = "";; paramCard = paramCard.name)
      {
        ((ProfileActivity.CardContactInfo)localObject3).jdField_a_of_type_JavaLangString = paramCard;
        localArrayList.add(localObject3);
        i2 += 1;
        break label125;
        i1 = paramBusinessCard.mobilesNum.size();
        break;
      }
      i3 = localArrayList.size();
      if (i3 > 0)
      {
        paramCard = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_business_card_num");
        if (paramCard == null) {
          paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904297, null);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
          {
            i1 = 1;
            localObject1 = (LinearLayout)paramCard.findViewById(2131302236);
            ((LinearLayout)localObject1).removeAllViews();
            i2 = 0;
            if (i2 >= i3) {
              break label623;
            }
            localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904298, null);
            localObject3 = (TextView)((View)localObject2).findViewById(2131297124);
            paramBusinessCard = ((ProfileActivity.CardContactInfo)localArrayList.get(i2)).c;
            if (TextUtils.isEmpty(((ProfileActivity.CardContactInfo)localArrayList.get(i2)).jdField_a_of_type_JavaLangString)) {
              break label636;
            }
            paramBusinessCard = ((ProfileActivity.CardContactInfo)localArrayList.get(i2)).jdField_a_of_type_JavaLangString + " " + ((ProfileActivity.CardContactInfo)localArrayList.get(i2)).c;
          }
          for (;;)
          {
            ((TextView)localObject3).setText(paramBusinessCard);
            if (i2 != 0)
            {
              if (i1 == 0) {
                break label612;
              }
              ProfileCardTemplate.a((View)localObject2, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
            }
            for (;;)
            {
              a("map_key_business_card_num", null, (TextView)localObject3, null);
              ((View)localObject2).setTag(new DataTag(45, localArrayList.get(i2)));
              ((View)localObject2).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((View)localObject2).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
              ((LinearLayout)localObject1).addView((View)localObject2);
              i2 += 1;
              break label390;
              i1 = 0;
              break;
              ((View)localObject2).setBackgroundResource(2130838357);
            }
            this.jdField_a_of_type_JavaUtilHashMap.put("map_key_business_card_num", paramCard);
            return true;
          }
        }
      }
      return false;
    }
  }
  
  private boolean b(Card paramCard, boolean paramBoolean)
  {
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (!paramCard.isShowFeeds()))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qzone_feed") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_feed");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904305, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone_feed", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      TextView localTextView = (TextView)localView.findViewById(2131297124);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131302248);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131297122);
      if (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc))
      {
        localTextView.setText(QzoneContactsFeedUtils.a(paramCard.strQzoneFeedsDesc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if ((paramCard.ulShowControl & 0x80) != 0) {
          localImageView1.setVisibility(0);
        }
        if ((ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramCard != null) && (paramCard.isShowPhoto()) && (paramCard.hasGotPhotoUrl())) {
          break label382;
        }
        localTextView.setMaxLines(2);
      }
      for (;;)
      {
        localView.setTag(new DataTag(5, null));
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setContentDescription(a(2131362011));
        a("map_key_qzone_feed", null, localTextView, localImageView2);
        return paramBoolean;
        if (!TextUtils.isEmpty(paramCard.strSpaceName))
        {
          localTextView.setText(paramCard.strSpaceName);
          break;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
        Object localObject1;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() != 0) {}
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        }
        localTextView.setText((String)localObject2 + a(2131370017));
        break;
        label382:
        localTextView.setMaxLines(1);
      }
    }
  }
  
  private boolean c(Card paramCard)
  {
    boolean bool4 = false;
    boolean bool2;
    boolean bool3;
    boolean bool1;
    label57:
    String str;
    boolean bool5;
    if (paramCard != null)
    {
      bool2 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
      bool3 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      if ((paramCard.lUserFlag & 1L) == 1L)
      {
        bool4 = true;
        if ((paramCard.lUserFlag & 0x400) != 1024L) {
          break label232;
        }
        bool1 = true;
        if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label238;
        }
        str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if ((!bool4) || (TextUtils.isEmpty(paramCard.strShowName))) {
          break label1301;
        }
        str = paramCard.strShowName;
        bool5 = bool3;
        bool3 = bool1;
        bool1 = bool5;
      }
    }
    for (;;)
    {
      label115:
      Object localObject2;
      long l1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = ((StringBuilder)localObject1).append("makeOrFrefreshAccountInfoView").append(", strShowName = ").append(str).append(", bEnterprise = ").append(bool4).append(", lUserFlag = ");
        if (paramCard == null)
        {
          l1 = 0L;
          label175:
          ((StringBuilder)localObject2).append(l1);
          QLog.i("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        if (!TextUtils.isEmpty(str)) {
          break label290;
        }
        if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_account_info") == null) {
          break label284;
        }
      }
      label232:
      label238:
      label284:
      for (int i1 = 1;; i1 = 0)
      {
        return 0x0 | i1;
        bool4 = false;
        break;
        bool1 = false;
        break label57;
        if ((!bool3) && (!bool2) && (paramCard.iQQLevel < 0)) {
          break label1283;
        }
        str = "********";
        bool5 = bool1;
        bool1 = bool3;
        bool3 = bool5;
        break label115;
        l1 = paramCard.lUserFlag;
        break label175;
      }
      label290:
      Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_info");
      if (localObject1 == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904310, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_info", localObject1);
        ((View)localObject1).setClickable(false);
      }
      for (bool4 = true;; bool4 = false)
      {
        Object localObject3 = ((View)localObject1).findViewById(2131302274);
        ((View)localObject1).findViewById(2131296790);
        localObject2 = (ImageView)((View)localObject1).findViewById(2131297122);
        ((ImageView)localObject2).setVisibility(0);
        TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131297124);
        TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131302272);
        TextView localTextView3 = (TextView)((View)localObject1).findViewById(2131302273);
        View localView = ((View)localObject1).findViewById(2131302271);
        TextView localTextView4;
        TextView localTextView5;
        double d1;
        if (this.jdField_a_of_type_JavaLangStringBuilder == null)
        {
          this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(24);
          this.jdField_a_of_type_JavaLangStringBuilder.append("帐号:").append(str);
          a(localTextView1, bool1, bool2, a(localTextView1, str, bool3), paramCard);
          localTextView4 = (TextView)((View)localObject3).findViewById(2131302275);
          localTextView5 = (TextView)((View)localObject3).findViewById(2131302276);
          if (paramCard.iQQLevel < 0) {
            break label1246;
          }
          localObject3 = ProfileCardUtil.a(getContext(), 8, paramCard.iQQLevel, true);
          localTextView4.setText((CharSequence)localObject3);
          localTextView2.setText((CharSequence)localObject3);
          this.jdField_a_of_type_JavaLangStringBuilder.append(" 等级 " + paramCard.iQQLevel + "级 ");
          d1 = paramCard.uAccelerateMultiple / 10.0D;
          if (d1 >= 0.0D) {
            break label929;
          }
          if ("".equals(localTextView5.getText()))
          {
            localTextView5.setText("");
            localTextView5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          }
          label635:
          localTextView3.setText(localTextView5.getText());
          paramCard = localTextView5.getText().toString();
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "layout: " + localView.getWidth() + " info:" + localTextView1.getWidth() + " level:" + localTextView4.getWidth() + " acc:" + localTextView5.getWidth());
          }
          if (localView.getWidth() - 20 <= localTextView1.getWidth() + localTextView4.getWidth() + localTextView5.getWidth()) {
            break label1217;
          }
          localTextView3.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView4.setVisibility(8);
          localTextView5.setVisibility(8);
          label789:
          if (AppSetting.j)
          {
            this.jdField_a_of_type_JavaLangStringBuilder.append(paramCard);
            ((View)localObject1).setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder);
          }
          ((View)localObject1).setTag(new DataTag(14, str));
          ((View)localObject1).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          a("map_key_account_info", null, localTextView1, (ImageView)localObject2);
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
            break label1260;
          }
        }
        label929:
        label1217:
        label1246:
        label1260:
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0) {
            break label1266;
          }
          ProfileCardTemplate.a((View)localObject1, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          return bool4;
          this.jdField_a_of_type_JavaLangStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
          break;
          if ((!bool2) && (!bool1))
          {
            localTextView5.setText("慢速中");
            localTextView5.setTextColor(-5855578);
            if (!AppSetting.j) {
              break label635;
            }
            localTextView5.setContentDescription("慢速中");
            break label635;
          }
          if ((bool2) && (!bool1))
          {
            localTextView5.setText(d1 + "倍加速中");
            localTextView5.setTextColor(36864);
            if (!AppSetting.j) {
              break label635;
            }
            localTextView5.setContentDescription("加速" + d1 + "倍");
            break label635;
          }
          if (!bool1) {
            break label635;
          }
          if (paramCard.getVipType(EVIPSPEC.E_SP_SUPERVIP) == 1)
          {
            localTextView5.setText(d1 + "倍极速中");
            if (AppSetting.j) {
              localTextView5.setContentDescription("极速" + d1 + "倍");
            }
          }
          for (;;)
          {
            localTextView5.setTextColor(36864);
            localTextView3.setTextColor(36864);
            break;
            localTextView5.setText(d1 + "倍高速中");
            if (AppSetting.j) {
              localTextView5.setContentDescription("高速" + d1 + "倍");
            }
          }
          localTextView3.setVisibility(8);
          localTextView2.setVisibility(8);
          localTextView4.setVisibility(0);
          localTextView5.setVisibility(0);
          break label789;
          ((View)localObject3).setVisibility(8);
          paramCard = "";
          break label789;
        }
        label1266:
        ((View)localObject1).setBackgroundResource(2130838357);
        return bool4;
      }
      label1283:
      str = null;
      bool5 = bool1;
      bool1 = bool3;
      bool3 = bool5;
      continue;
      label1301:
      bool5 = bool1;
      bool1 = bool3;
      bool3 = bool5;
      continue;
      str = null;
      bool1 = false;
      bool2 = false;
      bool3 = false;
    }
  }
  
  private boolean c(Card paramCard, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_feed");
    if (localObject == null) {
      return false;
    }
    localObject = (LinearLayout)((View)localObject).findViewById(2131302247);
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (!paramCard.isShowPhoto()) || (!paramCard.hasGotPhotoUrl()))
    {
      ((LinearLayout)localObject).setVisibility(8);
      return false;
    }
    List localList = paramCard.getQZonePhotoList();
    if ((localList == null) || (localList.size() == 0)) {
      return false;
    }
    int i4 = getResources().getDimensionPixelSize(2131493548);
    int i5 = getResources().getDimensionPixelSize(2131493316);
    int i6 = ((LinearLayout)localObject).getWidth();
    int i1 = 0;
    int i3 = 0;
    String str;
    label185:
    ImageView localImageView;
    View localView1;
    View localView2;
    TextView localTextView;
    if (i3 < localList.size())
    {
      str = (String)localList.get(i3);
      if (TextUtils.isEmpty(str)) {
        break label499;
      }
      paramCard = ((LinearLayout)localObject).getChildAt(i3);
      if (paramCard != null) {
        break label496;
      }
      paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904306, null);
      localImageView = (ImageView)paramCard.findViewById(2131302249);
      localView1 = paramCard.findViewById(2131302251);
      localView2 = paramCard.findViewById(2131302250);
      localTextView = (TextView)paramCard.findViewById(2131302252);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131427454));
      }
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mRequestHeight = i4;
        localURLDrawableOptions.mRequestWidth = i4;
        localImageView.setImageDrawable(URLDrawable.getDrawable(str, localURLDrawableOptions));
        if (i3 >= ((LinearLayout)localObject).getChildCount()) {
          ((LinearLayout)localObject).addView(paramCard);
        }
        if (str.contains("video=1"))
        {
          localView1.setVisibility(0);
          i1 += i5;
          if (i1 + i5 + 20 <= i6) {
            break label471;
          }
        }
      }
      catch (Exception paramCard)
      {
        i2 = i1;
      }
      try
      {
        localView2.setVisibility(0);
        if ((localView1.getVisibility() != 0) && (i3 + 1 < localList.size()))
        {
          localTextView.setText(localList.size() + "张");
          localTextView.setVisibility(0);
        }
        return false;
      }
      catch (Exception paramCard)
      {
        for (;;)
        {
          i2 = i1;
        }
      }
      localView1.setVisibility(8);
    }
    int i2;
    i1 = i2;
    if (QLog.isColorLevel())
    {
      QLog.e("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
      i1 = i2;
    }
    label471:
    label496:
    label499:
    for (;;)
    {
      i3 += 1;
      break;
      localView2.setVisibility(8);
      localTextView.setVisibility(8);
      continue;
      break label185;
    }
  }
  
  private boolean d(Card paramCard)
  {
    boolean bool = true;
    List localList;
    if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      if (paramCard == null) {
        localList = null;
      }
    }
    for (;;)
    {
      if ((localList == null) || (localList.size() == 0))
      {
        if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_third_part_app_entrance") != null) {}
        for (bool = true;; bool = false)
        {
          return bool;
          localList = paramCard.getBusiEntrys();
          break;
        }
      }
      View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_third_part_app_entrance");
      if (localView == null)
      {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904302, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_third_part_app_entrance", localView);
      }
      for (;;)
      {
        a((HorizontalScrollLayout)localView.findViewById(2131302241), paramCard, localList);
        return bool;
        bool = false;
      }
      localList = null;
    }
  }
  
  private boolean d(Card paramCard, boolean paramBoolean)
  {
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (paramCard.lCurrentStyleId == ProfileCardTemplate.h))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_shopping_photo") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    ThreadManager.c(new wnp(this, paramCard));
    return false;
  }
  
  private boolean e(Card paramCard)
  {
    if ((paramCard == null) || (paramCard.lCurrentStyleId != ProfileCardTemplate.f))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_tag");
      return false;
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904311, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag", localObject1);
    }
    localObject2 = (AdaptiveLayout)((View)localObject1).findViewById(2131302277);
    int i2 = getResources().getDimensionPixelSize(2131493385);
    int i1 = 7;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      i1 = 8;
    }
    int i3;
    if (this.jdField_a_of_type_ArrayOfAndroidWidgetTextView == null)
    {
      ((AdaptiveLayout)localObject2).setGap(i2, i2);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[i1];
      i3 = getResources().getDimensionPixelSize(2131493380);
      int i4 = getResources().getDimensionPixelSize(2131493387);
      int i5 = getResources().getDimensionPixelSize(2131493388);
      i2 = 0;
      if (i2 < i1)
      {
        localObject1 = new TextView(getContext());
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i2] = localObject1;
        ((TextView)localObject1).setBackgroundResource(2130841645);
        ((TextView)localObject1).setPadding(i4, i4, i4, i4);
        ((TextView)localObject1).setTextSize(0, i3);
        ((TextView)localObject1).setTextColor(-16777216);
        ((TextView)localObject1).setGravity(17);
        if (7 == i2)
        {
          i3 = getResources().getDimensionPixelSize(2131493382);
          ((TextView)localObject1).setTextSize(0, i3);
          ((TextView)localObject1).setTag(new DataTag(47, null));
          ((TextView)localObject1).setText("+");
          ((TextView)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((TextView)localObject1).setPadding(i5, 0, i5, 0);
        }
        for (;;)
        {
          ((AdaptiveLayout)localObject2).addView((View)localObject1);
          i2 += 1;
          break;
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
    localObject1 = paramCard.getLabelList();
    if ((localObject2 != null) && (localObject1 != null))
    {
      label366:
      label411:
      Object localObject3;
      if (((List)localObject1).size() > 7)
      {
        i2 = 7;
        i3 = 0;
        if (i3 >= i1) {
          break label533;
        }
        localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i3];
        if (i3 >= i2) {
          break label492;
        }
        ((TextView)localObject2).setText(((ProfileLabelInfo)((List)localObject1).get(i3)).labelName);
        ((TextView)localObject2).setVisibility(0);
        if (((TextView)localObject2).getVisibility() == 0)
        {
          localObject3 = ((TextView)localObject2).getBackground();
          if ((localObject3 instanceof GradientDrawable))
          {
            localObject3 = (GradientDrawable)localObject3;
            if (paramCard.backgroundColor != 1L) {
              break label508;
            }
            ((GradientDrawable)localObject3).setColor(-2130706433);
            ((GradientDrawable)localObject3).setStroke(1, 855638016);
            ((TextView)localObject2).setTextColor(-16777216);
          }
        }
      }
      for (;;)
      {
        i3 += 1;
        break label366;
        i2 = ((List)localObject1).size();
        break;
        label492:
        if (i3 >= 7) {
          break label411;
        }
        ((TextView)localObject2).setVisibility(8);
        break label411;
        label508:
        ((GradientDrawable)localObject3).setColor(Integer.MIN_VALUE);
        ((GradientDrawable)localObject3).setStroke(1, 872415231);
        ((TextView)localObject2).setTextColor(-1);
      }
      label533:
      return true;
    }
    return false;
  }
  
  private boolean e(Card paramCard, boolean paramBoolean)
  {
    if ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) {
      return false;
    }
    Object localObject = (BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111);
    BusinessCard localBusinessCard;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localBusinessCard = ((BusinessCardManager)localObject).a();
      localObject = localBusinessCard;
      if (localBusinessCard == null) {
        localObject = new BusinessCard();
      }
      boolean bool = b(paramCard, (BusinessCard)localObject, paramBoolean);
      if ((!a(paramCard, (BusinessCard)localObject, paramBoolean)) && (!bool)) {
        break label167;
      }
    }
    label167:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      localBusinessCard = paramCard.getCardInfo();
      if ((paramCard.hasCardInfo()) && (!TextUtils.isEmpty(localBusinessCard.cardId)))
      {
        ((BusinessCardManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localBusinessCard);
        break;
      }
      localBusinessCard = ((BusinessCardManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
    }
  }
  
  private boolean f(Card paramCard)
  {
    if ((paramCard == null) || (paramCard.lCurrentStyleId == ProfileCardTemplate.a) || (paramCard.lCurrentStyleId == -1L) || (!paramCard.isShowXMan()) || (!paramCard.allowClick))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qqloginday");
      return false;
    }
    View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qqloginday");
    if (localView1 == null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904299, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qqloginday", localView1);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)localView1.findViewById(2131297123);
      View localView2 = localView1.findViewById(2131296821);
      TextView localTextView2 = (TextView)localView1.findViewById(2131297124);
      ImageView localImageView = (ImageView)localView1.findViewById(2131297122);
      localTextView1.setText(2131369957);
      long l1 = 30L;
      if (paramCard.lQQMasterLogindays > 0L) {
        l1 = paramCard.lQQMasterLogindays;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQQLoginDays lQQMasterLogindays=" + l1 + ",lLoginDays=" + paramCard.lLoginDays + ",AllinOne Pa=" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int + ",card.allowClick=" + paramCard.allowClick);
      }
      Drawable localDrawable;
      if (paramCard.lLoginDays >= l1)
      {
        localDrawable = getContext().getResources().getDrawable(2130840978);
        localView1.setClickable(true);
        localView1.setTag(new DataTag(31, null));
        localView1.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        localImageView.setVisibility(0);
        localTextView2.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label449;
        }
        localTextView2.setText(paramCard.lLoginDays + "天");
        if (paramCard.lLoginDays < l1) {
          break label438;
        }
        localTextView2.setTextColor(-155129);
      }
      for (;;)
      {
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
        localTextView2.setCompoundDrawablePadding(ProfileCardUtil.a(getContext(), 10));
        a("map_key_qqloginday", localTextView1, localTextView2, localImageView);
        a(localTextView1, localView2, 2130841052);
        return bool;
        localDrawable = getContext().getResources().getDrawable(2130840977);
        break;
        label438:
        localTextView2.setTextColor(-5855578);
        continue;
        label449:
        if (paramCard.allowPeopleSee)
        {
          localTextView2.setText(paramCard.lLoginDays + "天");
          if (paramCard.lLoginDays >= l1) {
            localTextView2.setTextColor(-155129);
          } else {
            localTextView2.setTextColor(-5855578);
          }
        }
        else
        {
          localTextView2.setText("");
        }
      }
    }
  }
  
  private boolean f(Card paramCard, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {}
    for (int i1 = 1; (i1 == 0) || (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (!this.jdField_b_of_type_Boolean); i1 = 0)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_photo_wall");
      return false;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
    paramCard = localView;
    if (localView == null)
    {
      paramCard = new PhotoWallView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_photo_wall", paramCard);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))
    {
      paramCard = (PhotoWallView)paramCard;
      ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(paramCard);
    }
    return true;
  }
  
  public String a(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update more info");
    }
    removeAllViews();
    List localList = a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_d_of_type_Int);
    int i1;
    int i2;
    label69:
    View localView1;
    View localView2;
    int i3;
    label98:
    View localView3;
    if (localList != null)
    {
      i1 = localList.size();
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
        break label173;
      }
      i2 = 1;
      localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_info");
      localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
      i3 = 0;
      if (i3 >= i1) {
        return;
      }
      localView3 = (View)localList.get(i3);
      if (i2 == 0) {
        break label179;
      }
      ProfileCardTemplate.a(localView3, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
    }
    for (;;)
    {
      if (localView3.getVisibility() != 0) {
        localView3.setVisibility(0);
      }
      addView(localView3);
      i3 += 1;
      break label98;
      i1 = 0;
      break;
      label173:
      i2 = 0;
      break label69;
      label179:
      if (localView3 != localView1) {
        if (localView3 == localView2) {
          localView3.setBackgroundResource(2130838355);
        } else if ((i3 == 0) && (i1 == 1)) {
          localView3.setBackgroundResource(2130838349);
        } else if (i3 == 0) {
          localView3.setBackgroundResource(2130838357);
        } else if ((i3 > 0) && (i3 < i1 - 1)) {
          localView3.setBackgroundResource(2130838355);
        } else if ((i3 > 0) && (i3 == i1 - 1)) {
          localView3.setBackgroundResource(2130838352);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdatePhotoWall size:" + paramInt);
    }
    if (paramInt > 0)
    {
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if (paramInt <= 0) {
        break label75;
      }
    }
    label75:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(Card paramCard)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_feed");
    if ((paramCard == null) || (localObject == null) || (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)) || (!TextUtils.isEmpty(paramCard.strSpaceName))) {
      return;
    }
    TextView localTextView = (TextView)((View)localObject).findViewById(2131297124);
    localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
    if (localObject != null)
    {
      paramCard = (Card)localObject;
      if (((String)localObject).length() != 0) {}
    }
    else
    {
      paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    if (paramCard != null)
    {
      localObject = paramCard;
      if (paramCard.length() != 0) {}
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    }
    localTextView.setText((String)localObject + a(2131370017));
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    if (a(paramCard, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList)) {
      a();
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a(RichStatus paramRichStatus)
  {
    if (a(paramRichStatus)) {
      a();
    }
  }
  
  public void a(MQQProfileName paramMQQProfileName)
  {
    if (a()) {
      a();
    }
  }
  
  public boolean a(Card paramCard, boolean paramBoolean, ArrayList paramArrayList)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "build more info map");
    }
    boolean bool2;
    try
    {
      bool2 = e(paramCard);
      if (!bool2) {
        break label537;
      }
      bool2 = true;
      bool1 = bool2;
    }
    catch (Exception paramCard)
    {
      label61:
      label84:
      label108:
      label133:
      label155:
      label180:
      label204:
      label228:
      label253:
      label277:
      label301:
      label324:
      label369:
      label375:
      label381:
      label387:
      label393:
      label399:
      label405:
      label411:
      label417:
      paramBoolean = bool1;
      label426:
      paramCard.printStackTrace();
      return paramBoolean;
    }
    try
    {
      bool4 = c(paramCard);
      if (bool2) {
        break label439;
      }
      if (!bool4) {
        break label543;
      }
    }
    catch (Exception paramCard)
    {
      paramBoolean = bool1;
      break label426;
      bool2 = true;
      break label61;
      bool2 = true;
      break label84;
      bool2 = true;
      break label108;
      bool2 = true;
      break label133;
      if ((!bool2) && (!bool1)) {
        break label369;
      }
      bool2 = true;
      break label155;
      bool2 = true;
      break label180;
      bool2 = true;
      break label204;
      i1 = 1;
      if ((i1 == 0) && (!bool4)) {
        break label393;
      }
      bool2 = true;
      break label228;
      bool2 = true;
      break label253;
      bool2 = true;
      break label277;
      bool2 = true;
      break label301;
      paramBoolean = true;
      break label324;
      paramBoolean = true;
    }
    bool1 = bool2;
    boolean bool4 = a();
    if (!bool2)
    {
      if (!bool4) {
        break label549;
      }
      break label445;
      bool1 = bool2;
      bool4 = a(paramArrayList);
      if (bool2) {
        break label451;
      }
      if (!bool4) {
        break label555;
      }
      break label451;
      bool1 = bool2;
      bool4 = e(paramCard, paramBoolean);
      if (bool2) {
        break label457;
      }
      if (!bool4) {
        break label561;
      }
      break label457;
    }
    for (;;)
    {
      if (paramCard == null)
      {
        bool1 = bool2;
        bool4 = a(null);
        bool1 = bool4;
        break label463;
        bool1 = bool2;
        bool4 = a(paramCard, paramBoolean);
        if (bool2) {
          break label479;
        }
        if (!bool4) {
          break label375;
        }
        break label479;
        bool1 = bool2;
        bool4 = a(paramCard);
        if (bool2) {
          break label485;
        }
        if (!bool4) {
          break label381;
        }
        break label485;
        bool1 = bool2;
        bool4 = b(paramCard);
        if (bool2) {
          break label491;
        }
        if (!bool4) {
          break label387;
        }
        break label491;
        bool1 = bool2;
        bool4 = d(paramCard, paramBoolean);
        if (bool2) {
          break label510;
        }
        if (!bool4) {
          break label399;
        }
        break label510;
        bool1 = bool2;
        bool4 = f(paramCard);
        if (bool2) {
          break label516;
        }
        if (!bool4) {
          break label405;
        }
        break label516;
        bool1 = bool2;
        bool4 = d(paramCard);
        if (bool2) {
          break label522;
        }
        if (!bool4) {
          break label411;
        }
        break label522;
        bool1 = bool2;
        paramBoolean = f(paramCard, paramBoolean);
        if (bool2) {
          break label528;
        }
        if (!paramBoolean) {
          break label417;
        }
        break label528;
      }
      int i1;
      for (;;)
      {
        bool1 = paramBoolean;
        bool2 = b();
        if (paramBoolean) {
          break label533;
        }
        paramBoolean = bool3;
        if (!bool2) {
          break label535;
        }
        break label533;
        bool1 = bool2;
        bool4 = a(paramCard.getRichStatus());
        bool1 = bool4;
        break label463;
        bool2 = false;
        break;
        bool2 = false;
        break label180;
        bool2 = false;
        break label204;
        i1 = 0;
        break label494;
        bool2 = false;
        break label228;
        bool2 = false;
        break label253;
        bool2 = false;
        break label277;
        bool2 = false;
        break label301;
        paramBoolean = false;
      }
      label439:
      label445:
      label451:
      label457:
      label463:
      label479:
      label485:
      label491:
      label494:
      label510:
      label516:
      label522:
      label528:
      label533:
      label535:
      return paramBoolean;
      label537:
      bool2 = false;
      break;
      label543:
      bool2 = false;
      break label61;
      label549:
      bool2 = false;
      break label84;
      label555:
      bool2 = false;
      break label108;
      label561:
      bool2 = false;
    }
  }
  
  public boolean a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {}
    for (paramProfileCardTemplate = "0"; this.jdField_b_of_type_JavaUtilHashMap.size() > 0; paramProfileCardTemplate = String.valueOf(paramProfileCardTemplate.i))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((String)this.jdField_b_of_type_JavaUtilHashMap.get(str)).equals(paramProfileCardTemplate));
      return false;
    }
    return true;
  }
  
  public void b(Card paramCard)
  {
    e(paramCard);
  }
  
  public void setNewSignature(byte[] paramArrayOfByte, long paramLong)
  {
    EntityManager localEntityManager;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject != null) {
        break label105;
      }
      localObject = null;
      if (localObject != null) {
        break label125;
      }
      localObject = new Card();
      ((Card)localObject).uin = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.a((Entity)localObject);
    }
    for (;;)
    {
      a(((Card)localObject).getRichStatus());
      return;
      label105:
      localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label125:
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.a((Entity)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ProfileCardMoreInfoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */