package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.BounceScrollView.MotionEventInterceptor;
import com.tencent.mobileqq.widget.MusicPendantView;
import com.tencent.mobileqq.widget.Rotate3dAnimation;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.model.CoverCacheData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import twh;
import twi;
import twj;
import twk;
import twl;
import twm;
import two;
import twp;
import twq;
import twr;

public abstract class ProfileHeaderView
  extends RelativeLayout
  implements ProfileViewUpdate, BounceScrollView.MotionEventInterceptor
{
  public static int a = 0;
  public static String a;
  public static int b = 0;
  public static int d = 1000;
  public static int e = 1001;
  public static int f = 1002;
  public static int g = 1003;
  protected static final int i = 1;
  protected static final int j = 2;
  protected float a;
  public long a;
  public ValueAnimator a;
  private Handler.Callback a;
  public Handler a;
  public BaseActivity a;
  public QQAppInterface a;
  public NewVoteAnimHelper a;
  public ProfileCardInfo a;
  public HashMap a;
  public AtomicBoolean a;
  public boolean a;
  protected float b;
  public String b;
  public AtomicBoolean b;
  private boolean b;
  protected float c;
  public int c;
  public int h;
  public int k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "Q.profilecard.FrdProfileCard.ProfileHeaderView";
    jdField_a_of_type_Int = 500;
    jdField_b_of_type_Int = jdField_a_of_type_Int * 2 + 3000;
  }
  
  public ProfileHeaderView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new twh(this);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramBaseActivity.density;
    this.jdField_b_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_c_of_type_Float = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
  }
  
  private void a(View paramView)
  {
    paramView = (ImageView)paramView.findViewById(2131302138);
    paramView.setVisibility(4);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 700 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(700L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new twp(this, paramView));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new twq(this, paramView));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(100L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void b()
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_AndroidOsHandler != null) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(d);
      if (localMessage != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
    }
  }
  
  public CoverCacheData a()
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
      }
      return ((QzonePhotoView)localObject).a();
    }
    if ((localObject instanceof VipPhotoViewForSimple))
    {
      localObject = (VipPhotoViewForSimple)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateVipPhotoViewForSimple");
      }
      return ((VipPhotoViewForSimple)localObject).a();
    }
    return null;
  }
  
  protected String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370028);
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370029);
    case 4: 
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370031), new Object[] { "4G" });
    case 3: 
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370031), new Object[] { "3G" });
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370032);
  }
  
  public void a() {}
  
  public void a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.jdField_a_of_type_Int == 33)
    {
      a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
    }
    String str;
    if (paramAllInOne.jdField_a_of_type_Int == 80)
    {
      str = ProfileCardUtil.a(paramAllInOne);
      if ((str != null) && (str.length() > 0))
      {
        localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (localObject == null) {
          break label218;
        }
      }
    }
    label218:
    for (Object localObject = ((PhoneContactManager)localObject).c(str);; localObject = null)
    {
      if (localObject != null)
      {
        a(paramAllInOne, 1, str, false);
        return;
      }
      a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
      a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
      if (ProfileActivity.AllInOne.f(paramAllInOne))
      {
        if ((paramAllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) && (paramAllInOne.jdField_a_of_type_JavaLangString.equals("0")) && (!TextUtils.isEmpty(paramAllInOne.p)))
        {
          a(paramAllInOne, 0, paramAllInOne.p, false);
          return;
        }
        a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, true);
        return;
      }
      localObject = ProfileCardUtil.a(paramAllInOne);
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        a(paramAllInOne, 1, (String)localObject, false);
        return;
      }
      a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
    }
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateAvatar() type = " + paramInt + "key = " + paramString + ",isDynamicMode:" + paramBoolean);
    }
    if ((!paramBoolean) || (paramInt != 0))
    {
      ThreadManager.a(new twm(this, paramInt, paramAllInOne, paramString), 8, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new two(this, paramAllInOne, paramInt, paramString));
  }
  
  public abstract void a(ProfileCardInfo paramProfileCardInfo);
  
  public void a(ProfileCardInfo paramProfileCardInfo, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLiked");
      }
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteView)localObject).jdField_a_of_type_Int;
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362018), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, HashMap paramHashMap)
  {
    paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.b;
    String str1 = getClass().getName();
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.size() <= 0)) {
      throw new ProfileTemplateException(str1 + " template templateAttr is null");
    }
    paramHashMap.put("commonBottomBtnBackground", "drawable");
    paramHashMap.put("commonBottomBtnTextColor", "color");
    paramHashMap.put("commonItemTitleColor", "color");
    paramHashMap.put("commonItemContentColor", "color");
    paramHashMap.put("commonItemContentLinkColor", "color");
    paramHashMap.put("commonItemTopBorderBackground", "drawable");
    paramHashMap.put("commonItemBottomBorderBackground", "drawable");
    paramHashMap.put("commonItemBorderBackground", "drawable");
    paramHashMap.put("commonItemMoreSrc", "drawable");
    paramHashMap.put("commonQrCodeSrc", "drawable");
    paramHashMap.put("commonMaskBackground", "color");
    paramHashMap = paramHashMap.entrySet().iterator();
    label441:
    label445:
    for (;;)
    {
      Object localObject1;
      String str2;
      Object localObject2;
      int m;
      String str3;
      if (paramHashMap.hasNext())
      {
        localObject1 = (Map.Entry)paramHashMap.next();
        str2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = paramProfileCardInfo.get(str2);
        String[] arrayOfString = ((String)localObject1).split(",");
        int n = arrayOfString.length;
        m = 0;
        if (m >= n) {
          break label441;
        }
        str3 = arrayOfString[m];
        if ((localObject2 != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
          if ((str3.equalsIgnoreCase("color")) && (((localObject2 instanceof ColorStateList)) || ((localObject2 instanceof String)))) {
            m = 1;
          }
        }
      }
      for (;;)
      {
        if (m != 0) {
          break label445;
        }
        throw new ProfileTemplateException(str1 + " template attr " + str2 + " type is not " + (String)localObject1);
        if ((str3.equalsIgnoreCase("drawable")) && ((localObject2 instanceof Drawable)))
        {
          m = 1;
        }
        else if ((str3.equalsIgnoreCase("string")) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2)))
        {
          m = 1;
        }
        else
        {
          m += 1;
          break;
          return;
          m = 0;
        }
      }
    }
  }
  
  public abstract void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean);
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
      }
      ((QzonePhotoView)localObject).a(paramCoverCacheData);
    }
    while (!(localObject instanceof VipPhotoViewForSimple)) {
      return;
    }
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateVipPhotoViewForSimple");
    }
    ((VipPhotoViewForSimple)localObject).a(paramCoverCacheData);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    if ((localObject2 != null) && (localObject1 != null)) {
      if (!paramBoolean) {
        break label152;
      }
    }
    for (;;)
    {
      Object localObject3 = new Rotate3dAnimation(0.0F, -90.0F, 1, 0.5F, 0.5F, 0.0F, false);
      Rotate3dAnimation localRotate3dAnimation = new Rotate3dAnimation(-90.0F, 0.0F, 1, 0.5F, 0.5F, 0.0F, false);
      ((Rotate3dAnimation)localObject3).setDuration(jdField_a_of_type_Int);
      ((Rotate3dAnimation)localObject3).setFillAfter(false);
      localRotate3dAnimation.setDuration(jdField_a_of_type_Int);
      localRotate3dAnimation.setFillAfter(false);
      ((Rotate3dAnimation)localObject3).setAnimationListener(new twk(this, (View)localObject2, (View)localObject1, localRotate3dAnimation));
      localRotate3dAnimation.setAnimationListener(new twl(this, paramBoolean));
      ((View)localObject2).startAnimation((Animation)localObject3);
      return;
      label152:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QzonePhotoView onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
      }
      ((QzonePhotoView)localObject).a(paramBoolean, paramString, parammobile_sub_get_cover_rsp);
    }
    while (!(localObject instanceof VipPhotoViewForSimple)) {
      return;
    }
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VipPhotoViewForSimple onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
    }
    ((VipPhotoViewForSimple)localObject).a(paramBoolean, paramString, parammobile_sub_get_cover_rsp);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
    e(paramProfileCardInfo);
    n(paramProfileCardInfo);
    r(paramProfileCardInfo);
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    e();
  }
  
  public void d(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + com.tencent.mobileqq.util.Utils.b(str));
      }
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label126;
      }
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370698);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramProfileCardInfo);
      ((TextView)localObject).setContentDescription(paramProfileCardInfo);
    }
    label126:
    do
    {
      return;
      if ((str != null) && (str.length() > 0))
      {
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361999) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    try
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void e(ProfileCardInfo paramProfileCardInfo)
  {
    this.h &= 0xFFFFFFFE;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904616, null);
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (ProfileActivity.AllInOne.c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        if (!ProfileActivity.AllInOne.h(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label605;
        }
        localObject1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (localObject1 != null)
        {
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break label1056;
          }
          localObject2 = (ProfileActivity.CardContactInfo)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localObject2 == null) {
            break label277;
          }
          paramProfileCardInfo = ((ProfileActivity.CardContactInfo)localObject2).b + ((ProfileActivity.CardContactInfo)localObject2).c;
          if (TextUtils.isEmpty(paramProfileCardInfo)) {
            break label1056;
          }
        }
      }
      label277:
      label288:
      label605:
      label714:
      label950:
      label1056:
      for (paramProfileCardInfo = ((PhoneContactManager)localObject1).c(paramProfileCardInfo);; paramProfileCardInfo = null)
      {
        int m;
        if (paramProfileCardInfo != null)
        {
          m = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          if ((2 != m) && (m != 0)) {
            break label288;
          }
          this.h &= 0xFFFFFFFE;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip local network: " + m);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          b();
          this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_net_voice", localView);
          return;
          paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          break;
          if ((paramProfileCardInfo.iTermType == 68104) || (paramProfileCardInfo.iTermType == 65805))
          {
            this.h &= 0xFFFFFFFE;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip friend iTermType=" + paramProfileCardInfo.iTermType);
            }
          }
          else if ((paramProfileCardInfo.abilityBits & 1L) != 0L)
          {
            m = paramProfileCardInfo.eNetworkType;
            paramProfileCardInfo = (TextView)localView.findViewById(2131303358);
            localObject1 = a(m);
            if (m == 2)
            {
              paramProfileCardInfo.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130841082), null, null, null);
              paramProfileCardInfo.setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
            }
            if ((paramProfileCardInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
              paramProfileCardInfo.setText((CharSequence)localObject1);
            }
            this.h |= 0x1;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip has ability --> show tip , net " + m + " from contact card");
            }
          }
          else if ((paramProfileCardInfo.ability & 0x2) != 0)
          {
            localObject1 = (TextView)localView.findViewById(2131303358);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370030);
            if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((TextView)localObject1).setText((CharSequence)localObject2);
            }
            this.h |= 0x1;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip-->show PC has camera,state=" + paramProfileCardInfo.eNetworkType + "from contact card");
            }
          }
        }
        localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if (localObject1 != null)
        {
          paramProfileCardInfo = ((FriendsManager)localObject1).c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          m = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          if ((2 != m) && (m != 0)) {
            break label714;
          }
          this.h &= 0xFFFFFFFE;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip local network: " + m);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          b();
          break;
          if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.iTermType == 68104) || (paramProfileCardInfo.iTermType == 65805)))
          {
            this.h &= 0xFFFFFFFE;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip friend iTermType=" + paramProfileCardInfo.iTermType);
            }
          }
          else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.abilityBits & 1L) != 0L))
          {
            localObject1 = (TextView)localView.findViewById(2131303358);
            m = paramProfileCardInfo.getNetWorkType();
            localObject2 = a(m);
            if ((m == 2) && (localObject1 != null))
            {
              ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130841082), null, null, null);
              ((TextView)localObject1).setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
            }
            if (ContactUtils.a(paramProfileCardInfo)) {}
            for (this.h = 0;; this.h |= 0x1)
            {
              if (!QLog.isColorLevel()) {
                break label950;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip has ability,show tip.net=" + paramProfileCardInfo.getNetWorkType());
              break;
              if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                ((TextView)localObject1).setText((CharSequence)localObject2);
              }
            }
          }
          else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.abilityBits & 0x2) != 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip-->show PC has camera,state=" + paramProfileCardInfo.status);
            }
            paramProfileCardInfo = (TextView)localView.findViewById(2131303358);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370030);
            if ((paramProfileCardInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
              paramProfileCardInfo.setText((CharSequence)localObject1);
            }
            this.h |= 0x1;
          }
        }
      }
    }
  }
  
  public void g(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan()) && (ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray())))
    {
      paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_music_pendant");
      if (paramProfileCardInfo != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramProfileCardInfo.getLayoutParams();
        localLayoutParams.addRule(0, 2131303322);
        localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 2.0F));
        paramProfileCardInfo.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void h(ProfileCardInfo paramProfileCardInfo)
  {
    View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if (((localView1 instanceof TextView)) && (localView2 != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan()) && (ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray()))) {
      localView2.getViewTreeObserver().addOnGlobalLayoutListener(new twj(this, localView2, localView1, paramProfileCardInfo));
    }
  }
  
  public void i(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    TextView localTextView;
    ProfileActivity.AllInOne localAllInOne;
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName;
      localAllInOne = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      localObject = ((MQQProfileName)localObject).a.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + com.tencent.mobileqq.util.Utils.b((String)localObject));
      }
      if (localObject != null)
      {
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label169;
        }
      }
    }
    label169:
    for (paramProfileCardInfo = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramProfileCardInfo = " ")
    {
      localTextView.setText(paramProfileCardInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361994) + ":";
      localTextView.setContentDescription((String)localObject + paramProfileCardInfo);
      return;
    }
  }
  
  public void j(ProfileCardInfo paramProfileCardInfo)
  {
    int i1 = 0;
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_olympic_torch");
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    if ((!(localView instanceof FrameLayout)) || (!(localObject1 instanceof TextView)) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
      return;
    }
    Object localObject2 = (OlympicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166);
    if (((OlympicManager)localObject2).b("MCard")) {}
    for (boolean bool = true;; bool = false)
    {
      label95:
      label150:
      label195:
      int n;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.olympicTorch > 0)
      {
        int m = 1;
        m = bool & m;
        bool = m;
        if (com.tencent.av.opengl.utils.Utils.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          bool = ((OlympicManager)localObject2).a("olympic_flag_setting", true) & m;
        }
        if (localView.getVisibility() != 0) {
          break label352;
        }
        m = 1;
        if (bool == m) {
          break;
        }
        if (bool)
        {
          localView.setTag(new DataTag(56, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
          localView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        if (!bool) {
          break label358;
        }
        m = 0;
        localView.setVisibility(m);
        if (!bool) {
          break label365;
        }
        n = AIOUtils.a(38.0F, getResources());
        ((View)localObject1).setPadding(getPaddingTop(), getPaddingTop(), n, getPaddingBottom());
        if (((this instanceof ProfileGameView)) || ((this instanceof ProfilePhotoView)))
        {
          n = i1;
          if (bool) {
            n = -AIOUtils.a(14.0F, getResources());
          }
        }
      }
      try
      {
        localObject1 = (RelativeLayout)((View)localObject1).getParent();
        localObject2 = (ViewGroup.MarginLayoutParams)((RelativeLayout)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = n;
        ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (bool) {
          OlympicUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800688F", 1, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
        e();
        if ((!bool) || (!VersionUtils.e())) {
          break;
        }
        a(localView);
        return;
        n = 0;
        break label95;
        label352:
        n = 0;
        break label150;
        label358:
        n = 8;
        break label195;
        label365:
        n = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, localException.getMessage(), localException);
          }
        }
      }
    }
  }
  
  public void k(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_level");
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_level_accelerate");
    int m;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        break label293;
      }
      m = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel;
    }
    for (long l = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uAccelerateMultiple;; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQQLevel level=" + m);
      }
      if ((m == 0) || (!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        if (((TextView)localObject).getVisibility() != 8) {
          ((TextView)localObject).setVisibility(8);
        }
        if (localView.getVisibility() != 8) {
          localView.setVisibility(8);
        }
        return;
      }
      paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_login_day_icon");
      if ((paramProfileCardInfo != null) && (paramProfileCardInfo.getVisibility() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        ((TextView)localObject).setText(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 6, m, bool));
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362040);
        if (l > 10L)
        {
          localView.setVisibility(0);
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362041);
        }
        for (;;)
        {
          ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362000) + ":" + Integer.toString(m) + paramProfileCardInfo);
          return;
        }
      }
      label293:
      m = 0;
    }
  }
  
  public void l(ProfileCardInfo paramProfileCardInfo)
  {
    try
    {
      Object localObject4 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_login_day_icon");
      View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_login_day_text");
      View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_login_day_layout");
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject1 = localObject2;
      if (localView2 != null)
      {
        localObject1 = localObject2;
        if ((localView2 instanceof RelativeLayout)) {
          localObject1 = (RelativeLayout)localView2;
        }
      }
      localObject2 = localObject3;
      if (localView1 != null)
      {
        localObject2 = localObject3;
        if ((localView1 instanceof TextView)) {
          localObject2 = (TextView)localView1;
        }
      }
      long l;
      boolean bool;
      if ((localObject4 instanceof ImageView))
      {
        localObject3 = (ImageView)localObject4;
        l = 30L;
        localObject4 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
        bool = AppSetting.j;
        if ((localObject4 != null) && (((Card)localObject4).isShowXMan()))
        {
          if (((Card)localObject4).lQQMasterLogindays > 0L) {
            l = ((Card)localObject4).lQQMasterLogindays;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQQLoginDays lQQMasterLogindays=" + l + ",lLoginDays=" + ((Card)localObject4).lLoginDays + ",AllinOne Pa=" + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
          }
          ((ImageView)localObject3).setVisibility(0);
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
            if (((Card)localObject4).lLoginDays >= l)
            {
              if ((bool) && (localObject1 != null)) {
                ((RelativeLayout)localObject1).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362042), new Object[] { Long.valueOf(((Card)localObject4).lLoginDays) }));
              }
              if (((Card)localObject4).allowClick)
              {
                ((ImageView)localObject3).setBackgroundResource(2130840978);
                if (localObject2 != null) {
                  ((TextView)localObject2).setTextColor(-155129);
                }
              }
              while (localObject1 != null)
              {
                ((RelativeLayout)localObject1).setVisibility(0);
                if (localObject2 == null) {
                  break;
                }
                ((TextView)localObject2).setText(((Card)localObject4).lLoginDays + "天");
                return;
                ((ImageView)localObject3).setBackgroundResource(2130843494);
              }
            }
          }
        }
      }
      label656:
      label821:
      return;
    }
    catch (Exception paramProfileCardInfo)
    {
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "updateQQLoginDays exception ", paramProfileCardInfo);
        return;
        if ((bool) && (localObject1 != null)) {
          ((RelativeLayout)localObject1).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362043), new Object[] { Long.valueOf(((Card)localObject4).lLoginDays) }));
        }
        if (((Card)localObject4).allowClick)
        {
          ((ImageView)localObject3).setBackgroundResource(2130840977);
          if (localObject2 != null) {
            ((TextView)localObject2).setTextColor(-5855578);
          }
        }
        while (localObject1 != null)
        {
          ((RelativeLayout)localObject1).setVisibility(0);
          if (localObject2 == null) {
            break;
          }
          ((TextView)localObject2).setText(((Card)localObject4).lLoginDays + "天");
          return;
          ((ImageView)localObject3).setBackgroundResource(2130843495);
        }
        if (((Card)localObject4).lLoginDays >= l)
        {
          if (((Card)localObject4).allowClick)
          {
            ((ImageView)localObject3).setBackgroundResource(2130840978);
            if (localObject2 != null) {
              ((TextView)localObject2).setTextColor(-155129);
            }
            if (localObject1 == null) {
              return;
            }
            ((RelativeLayout)localObject1).setVisibility(0);
            if (!((Card)localObject4).allowPeopleSee) {
              break label656;
            }
            localObject3 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362044), new Object[] { Long.valueOf(((Card)localObject4).lLoginDays) });
            paramProfileCardInfo = (ProfileCardInfo)localObject3;
            if (localObject2 != null)
            {
              ((TextView)localObject2).setText(((Card)localObject4).lLoginDays + "天");
              paramProfileCardInfo = (ProfileCardInfo)localObject3;
            }
          }
          for (;;)
          {
            if (!bool) {
              return;
            }
            ((RelativeLayout)localObject1).setContentDescription(paramProfileCardInfo);
            return;
            ((ImageView)localObject3).setBackgroundResource(2130843494);
            break;
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362046);
            paramProfileCardInfo = (ProfileCardInfo)localObject3;
            if (localObject2 != null)
            {
              ((TextView)localObject2).setVisibility(8);
              paramProfileCardInfo = (ProfileCardInfo)localObject3;
            }
          }
        }
        else
        {
          if (((Card)localObject4).allowClick)
          {
            ((ImageView)localObject3).setBackgroundResource(2130840977);
            if (localObject2 != null) {
              ((TextView)localObject2).setTextColor(-5855578);
            }
            if (localObject1 == null) {
              return;
            }
            ((RelativeLayout)localObject1).setVisibility(0);
            if (!((Card)localObject4).allowPeopleSee) {
              break label821;
            }
            localObject3 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362045), new Object[] { Long.valueOf(((Card)localObject4).lLoginDays) });
            paramProfileCardInfo = (ProfileCardInfo)localObject3;
            if (localObject2 != null)
            {
              ((TextView)localObject2).setText(((Card)localObject4).lLoginDays + "天");
              paramProfileCardInfo = (ProfileCardInfo)localObject3;
            }
          }
          for (;;)
          {
            if (!bool) {
              return;
            }
            ((RelativeLayout)localObject1).setContentDescription(paramProfileCardInfo);
            return;
            ((ImageView)localObject3).setBackgroundResource(2130843495);
            break;
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362047);
            paramProfileCardInfo = (ProfileCardInfo)localObject3;
            if (localObject2 != null)
            {
              ((TextView)localObject2).setVisibility(8);
              paramProfileCardInfo = (ProfileCardInfo)localObject3;
            }
          }
          ((ImageView)localObject3).setVisibility(8);
        }
      }
    }
  }
  
  public void m(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    VoteView localVoteView;
    if ((localObject1 instanceof VoteView))
    {
      localVoteView = (VoteView)localObject1;
      if ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
        break label422;
      }
    }
    label173:
    label223:
    label350:
    label405:
    label422:
    for (boolean bool1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan();; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLike type isShowVote = " + String.valueOf(bool1));
      }
      if (bool1)
      {
        if ((localVoteView.getVisibility() != 0) && (!this.jdField_a_of_type_Boolean)) {
          localVoteView.setVisibility(0);
        }
        boolean bool2;
        Object localObject2;
        int n;
        int m;
        if ((paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
        {
          bool2 = com.tencent.av.opengl.utils.Utils.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
            break label223;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362021);
          localObject2 = null;
          n = 0;
          m = 0;
          bool1 = false;
          localVoteView.a(bool2, bool1, m, n, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper, false);
          localVoteView.setTag(localObject2);
          if (paramProfileCardInfo == null) {
            break label405;
          }
          localVoteView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        for (;;)
        {
          localVoteView.setContentDescription((CharSequence)localObject1);
          return;
          bool2 = false;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper == null) {
            this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
          }
          n = (int)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          m = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            if (!bool2) {
              break label350;
            }
            localObject2 = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
            localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362020), new Object[] { String.valueOf(n) });
            i1 = m;
            m = n;
            n = i1;
            break;
          }
          localObject2 = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362019), new Object[] { String.valueOf(n) });
          int i1 = m;
          m = n;
          n = i1;
          break label173;
          localVoteView.setOnClickListener(null);
        }
      }
      localVoteView.setVisibility(8);
      return;
    }
  }
  
  public void n(ProfileCardInfo paramProfileCardInfo)
  {
    this.h &= 0xFFFFFFFD;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904603, null);
    }
    for (;;)
    {
      if ((localView == null) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        b();
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_set_card", localView);
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        long l1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int m = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        Object localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar bgtype = " + localObject1);
        }
        localObject1 = getResources();
        TextView localTextView = (TextView)localView.findViewById(2131296913);
        ImageView localImageView = (ImageView)localView.findViewById(2131303324);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        boolean bool = false;
        if (localObject2 != null) {
          bool = ((SharedPreferences)localObject2).getBoolean("svip_profile_use_guide_shown_flag", false);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isShowTips" + bool + ",templateRet=" + m + ",myTemplateId=" + l1);
        }
        if (((101107 == m) || (101108 == m)) && (!bool) && (localObject2 != null))
        {
          ((SharedPreferences)localObject2).edit().putBoolean("svip_profile_use_guide_shown_flag", true).commit();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          if (101107 != m) {
            break label450;
          }
        }
        label450:
        for (localObject1 = ((Resources)localObject1).getString(2131371096);; localObject1 = ((Resources)localObject1).getString(2131371097))
        {
          localObject1 = ((BaseActivity)localObject2).getString(2131371095, new Object[] { localObject1 });
          localTextView.setText((CharSequence)localObject1);
          localImageView.setContentDescription((CharSequence)localObject1);
          localView.setTag(new DataTag(24, Integer.valueOf(m)));
          localView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.h |= 0x2;
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          b();
          return;
        }
      }
      ThreadManager.a(new ProfileHeaderView.UpdateProfileSetCardTask(this), 5, null, true);
      return;
    }
  }
  
  public void o(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips");
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips");
    LinearLayout localLinearLayout;
    if ((localObject instanceof LinearLayout))
    {
      localLinearLayout = (LinearLayout)localObject;
      if (((this.h & 0x1) == 0) || ((this.h & 0x2) == 0)) {
        break label241;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice and setcard");
      }
      paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
      if ((paramProfileCardInfo != null) && (localObject != null))
      {
        if (localLinearLayout.getChildCount() != 0) {
          break label171;
        }
        localLinearLayout.addView(paramProfileCardInfo);
        localLinearLayout.setVisibility(0);
        if (this.jdField_c_of_type_Int < 4)
        {
          this.jdField_c_of_type_Int += 1;
          paramProfileCardInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(d);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramProfileCardInfo, 4000L);
        }
      }
    }
    label171:
    label241:
    do
    {
      do
      {
        do
        {
          do
          {
            View localView;
            do
            {
              return;
              localView = localLinearLayout.getChildAt(0);
            } while (localView == null);
            if (localView.getId() == 2131303357) {
              paramProfileCardInfo = (ProfileCardInfo)localObject;
            }
            for (;;)
            {
              localObject = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130968773);
              ((Animation)localObject).setFillAfter(true);
              ((Animation)localObject).setAnimationListener(new twr(this, localLinearLayout, paramProfileCardInfo));
              localLinearLayout.setVisibility(0);
              localView.startAnimation((Animation)localObject);
              return;
            }
            if ((this.h & 0x1) == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice");
            }
            paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
          } while (paramProfileCardInfo == null);
          localLinearLayout.removeAllViews();
          localLinearLayout.addView(paramProfileCardInfo);
          localLinearLayout.setVisibility(0);
          return;
          if ((this.h & 0x2) == 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips setcard");
          }
          paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
        } while (paramProfileCardInfo == null);
        localLinearLayout.removeAllViews();
        localLinearLayout.addView(paramProfileCardInfo);
        localLinearLayout.setVisibility(0);
        return;
      } while ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.h));
      localLinearLayout.setVisibility(8);
      paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_space_view");
    } while (paramProfileCardInfo == null);
    localObject = (RelativeLayout.LayoutParams)paramProfileCardInfo.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height += ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18);
    paramProfileCardInfo.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramProfileCardInfo.setFocusable(true);
    paramProfileCardInfo.setFocusableInTouchMode(true);
  }
  
  public void p(ProfileCardInfo paramProfileCardInfo) {}
  
  public void q(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.a(new twi(this, paramProfileCardInfo), 8, null, true);
  }
  
  public void r(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_music_pendant");
    if ((localObject != null) && ((localObject instanceof MusicPendantView)))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "ProfileHeaderView updateMusicPendantView try to update view!");
      localObject = (MusicPendantView)localObject;
      ((MusicPendantView)localObject).setActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((MusicPendantView)localObject).a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "ProfileHeaderView updateMusicPendantView can not find view!");
  }
  
  public void setShoppingBgBlur(boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\ProfileHeaderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */