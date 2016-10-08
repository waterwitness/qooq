package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterViewPagerAdapter;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.XListView.MotionEventInterceptor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.PhotoInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import txi;
import txj;
import txk;

public class QzonePhotoView
  extends LinearLayout
  implements Handler.Callback, XListView.MotionEventInterceptor
{
  public static final int a = 100;
  public static final String a = "ProfileCard.QzonePhotoView";
  public static final int b = 200;
  public static final int c = 2;
  public static final int d = 8;
  public static final int e = 4;
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public QQAppInterface a;
  private ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
  CoverCacheData jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public QzonePhotoView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new txk(this);
  }
  
  public QzonePhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new txk(this);
  }
  
  private List a(String paramString, Map paramMap, List paramList)
  {
    int n = 0;
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update").append("|type = ").append(paramString).append("|MulRelsotionUrl = ").append(paramMap).append("|vecUrls = ").append(paramList);
      QLog.i("ProfileCard.QzonePhotoView", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData == null) {
      this.jdField_a_of_type_CooperationQzoneModelCoverCacheData = new CoverCacheData();
    }
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramMap);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramList);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    int m;
    if (paramList != null) {
      m = paramList.size();
    }
    while ((n < m) && (n < 16))
    {
      paramString = (Map)paramList.get(n);
      if (paramString != null)
      {
        paramString = new QzonePhotoView.PhotoInfo(n, 100, paramString);
        paramString.i = localLinkedList.size();
        localLinkedList.add(paramString);
      }
      n += 1;
      continue;
      m = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "updateCoverData photoInfo size=" + localLinkedList.size());
    }
    return localLinkedList;
  }
  
  public CoverCacheData a()
  {
    return this.jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      QzonePhotoView.PhotoInfo localPhotoInfo = (QzonePhotoView.PhotoInfo)((Iterator)localObject2).next();
      if (localPhotoInfo.j != 101)
      {
        PhotoInfo localPhotoInfo1 = new PhotoInfo();
        localPhotoInfo1.d = localPhotoInfo.a();
        ((ArrayList)localObject1).add(localPhotoInfo1);
      }
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("mode", 6);
    ((Bundle)localObject2).putInt("curindex", paramInt);
    ((Bundle)localObject2).putParcelableArrayList("picturelist", (ArrayList)localObject1);
    localObject1 = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((QZoneHelper.UserInfo)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    QZoneHelper.b(this.jdField_a_of_type_AndroidAppActivity, (QZoneHelper.UserInfo)localObject1, (Bundle)localObject2, 1014);
  }
  
  public void a(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.i = 0;
    this.jdField_b_of_type_JavaLangString = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2130904609, this, true);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = localDisplayMetrics.density;
    this.f = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int m = getResources().getDimensionPixelSize(2131493216);
    this.h = getResources().getDimensionPixelSize(2131493217);
    this.g = ((this.f - m * 2 - this.h * 3) / 4);
    if (paramProfileCardInfo.a.jdField_a_of_type_Int == 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    ThreadManager.a(new txi(this), 8, null, true);
    paramProfileCardInfo = Message.obtain();
    paramProfileCardInfo.what = 100;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramProfileCardInfo);
    this.j = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramBaseActivity));
  }
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "updateCoverCacheData data = " + paramCoverCacheData);
    }
    if (paramCoverCacheData != null) {
      a(a(paramCoverCacheData.jdField_b_of_type_JavaLangString, paramCoverCacheData.jdField_a_of_type_JavaUtilHashMap, paramCoverCacheData.jdField_a_of_type_JavaUtilArrayList));
    }
    if ((this.jdField_a_of_type_CooperationQzoneModelCoverCacheData != null) && (Utils.a("PhotoWallCover", this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "need get req cover info");
      }
      paramCoverCacheData = Message.obtain();
      paramCoverCacheData.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCoverCacheData);
    }
  }
  
  public void a(String paramString)
  {
    CoverCacheData localCoverCacheData = a();
    if (localCoverCacheData != null)
    {
      localCoverCacheData.jdField_b_of_type_JavaLangString = "PhotoWallCover";
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localUserInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
      QZoneHelper.a(this.jdField_a_of_type_AndroidAppActivity, localUserInfo, localCoverCacheData, paramString, 1008);
    }
  }
  
  public void a(List paramList)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      try
      {
        if ((QLog.isColorLevel()) && (paramList != null)) {
          QLog.i("ProfileCard.QzonePhotoView", 2, "updatePhotoView photoInfo size=" + paramList.size());
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        if (paramList == null) {
          break label554;
        }
        m = paramList.size();
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298667));
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298666);
        this.jdField_b_of_type_AndroidViewView.setTag(new DataTag(25, null));
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject2 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1L);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ProfileCardUtil.a(getContext(), 188);
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ((int)Math.ceil(((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight * 1.0D / 376.0D * 640.0D));
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(getResources().getColor(2131427368));
          localObject2 = URLDrawable.getDrawable(new File((String)localObject2, "qvip_profile_photo_black_addimage_tips.png"), (URLDrawable.URLDrawableOptions)localObject1);
          ((Drawable)localObject2).setBounds(0, 0, ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(new DataTag(25, null));
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = (ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131303335);
        localObject2 = (CirclePageIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131302898);
        if (m > 0)
        {
          QzonePhotoView.PhotoGridAdapter localPhotoGridAdapter = new QzonePhotoView.PhotoGridAdapter(this);
          localPhotoGridAdapter.a(paramList);
          localPhotoGridAdapter.a(this.g, this.g);
          paramList = new AdapterViewPagerAdapter(getContext(), localPhotoGridAdapter, 8);
          paramList.a(new txj(this));
          ViewGroup.LayoutParams localLayoutParams = ((ViewPager)localObject1).getLayoutParams();
          localLayoutParams.width = this.f;
          if (localPhotoGridAdapter.getCount() > 4)
          {
            m = this.g * 2 + this.h;
            localLayoutParams.height = m;
            ((ViewPager)localObject1).setLayoutParams(localLayoutParams);
            ((ViewPager)localObject1).setAdapter(paramList);
            m = paramList.getCount();
            ((CirclePageIndicator)localObject2).setViewPager((ViewPager)localObject1);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            ((ViewPager)localObject1).setVisibility(0);
            if (m > 1)
            {
              ((CirclePageIndicator)localObject2).setVisibility(0);
              setVisibility(0);
            }
          }
          else
          {
            m = this.g + this.h;
            continue;
          }
          ((CirclePageIndicator)localObject2).setVisibility(8);
          continue;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label529;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      ((ViewPager)localObject1).setVisibility(8);
      ((CirclePageIndicator)localObject2).setVisibility(8);
      setVisibility(0);
      return;
      label529:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      setVisibility(8);
      return;
      label554:
      int m = 0;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover|isSuc = " + paramBoolean + ",uin=" + paramString + ",mUin=" + this.jdField_b_of_type_JavaLangString);
    }
    if (!Utils.a(paramString, this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    List localList;
    int m;
    if ((paramBoolean) && (parammobile_sub_get_cover_rsp != null))
    {
      localList = a(parammobile_sub_get_cover_rsp.type, parammobile_sub_get_cover_rsp.MulRelsotionUrl, parammobile_sub_get_cover_rsp.vecUrls);
      m = 0;
      parammobile_sub_get_cover_rsp = null;
      paramString = null;
      label100:
      if (m >= 16) {
        break label293;
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > m))
      {
        paramString = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(m);
        label143:
        if ((localList == null) || (localList.size() <= m)) {
          break label242;
        }
        parammobile_sub_get_cover_rsp = (QzonePhotoView.PhotoInfo)localList.get(m);
        label173:
        if (Utils.a(paramString, parammobile_sub_get_cover_rsp)) {
          break label247;
        }
      }
    }
    label242:
    label247:
    label293:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
      }
      if ((!paramBoolean) && ((paramString != null) || (parammobile_sub_get_cover_rsp != null))) {
        break;
      }
      a(localList);
      return;
      paramString = null;
      break label143;
      parammobile_sub_get_cover_rsp = null;
      break label173;
      m += 1;
      break label100;
      if ((!NetworkUtil.b(BaseApplication.getContext())) || (this.i >= 3)) {
        break;
      }
      paramString = Message.obtain();
      paramString.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    ViewPager localViewPager = (ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131303335);
    paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    localViewPager.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    float f1 = paramMotionEvent.getRawY();
    int m;
    if ((localViewPager.getVisibility() == 0) && (f1 >= this.jdField_b_of_type_ArrayOfInt[1]) && (f1 < this.jdField_b_of_type_ArrayOfInt[1] + localViewPager.getHeight())) {
      m = 1;
    }
    for (;;)
    {
      paramMotionEvent.offsetLocation(0.0F, this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1]);
      label136:
      boolean bool1;
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool1 = false;
        label139:
        if (!bool1) {
          break;
        }
      }
      try
      {
        bool1 = localViewPager.dispatchTouchEvent(paramMotionEvent);
        if (paramMotionEvent.getAction() != 0)
        {
          bool2 = this.jdField_c_of_type_Boolean;
          if ((!bool2) || (!bool1)) {}
        }
        for (bool1 = bool3;; bool1 = false)
        {
          bool2 = bool1;
          return bool2;
          m = 0;
          break;
          if (m == 0) {
            break label136;
          }
          this.jdField_c_of_type_Boolean = true;
          this.k = 0;
          this.jdField_b_of_type_Float = paramMotionEvent.getX();
          this.jdField_c_of_type_Float = paramMotionEvent.getY();
          bool1 = true;
          break label139;
          if (m != 0)
          {
            if ((this.jdField_c_of_type_Boolean) && (this.k == 0))
            {
              f1 = Math.abs(paramMotionEvent.getX() - this.jdField_b_of_type_Float);
              f2 = Math.abs(paramMotionEvent.getY() - this.jdField_c_of_type_Float);
              if ((f1 > this.j) && (f1 * 0.5F > f2)) {
                this.k = 1;
              }
            }
            while (-1 != this.k) {
              for (;;)
              {
                float f2;
                bool1 = this.jdField_c_of_type_Boolean;
                break;
                if (f2 > this.j) {
                  this.jdField_c_of_type_Boolean = false;
                }
              }
            }
            return false;
          }
          if (1 != this.k) {
            break label136;
          }
          this.k = -1;
          bool1 = false;
          break label139;
          bool1 = this.jdField_c_of_type_Boolean;
          if (this.jdField_c_of_type_Boolean)
          {
            if (m == 0) {
              this.jdField_c_of_type_Boolean = false;
            }
            this.k = 0;
          }
          break label139;
        }
        return false;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (paramMessage != null)
      {
        paramMessage.a(this.jdField_b_of_type_JavaLangString, 2);
        this.i += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      continue;
      if ((paramMessage.obj instanceof LinkedList)) {
        a((List)paramMessage.obj);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\QzonePhotoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */