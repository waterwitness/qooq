package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.GridView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import txl;
import txm;

public class VipPhotoViewForSimple
  extends LinearLayout
  implements Handler.Callback
{
  public static final int a = 100;
  public static final String a = "ProfileCard.VipPhotoViewForSimple";
  public static float b = 0.0F;
  public static final int b = 200;
  public static final int c = 1;
  public static final int d = 16;
  public float a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new txm(this);
  View jdField_a_of_type_AndroidViewView;
  public HorizontalScrollView a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public QQAppInterface a;
  private ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
  public GridView a;
  CoverCacheData jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  public List a;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  public int e;
  public int f;
  public int g = -1;
  public int h = -1;
  public int i = -1;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  private int n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Float = 1.43F;
  }
  
  public VipPhotoViewForSimple(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = 1.5F;
  }
  
  public VipPhotoViewForSimple(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 1.5F;
  }
  
  private List a(String paramString, Map paramMap, List paramList)
  {
    int i2 = 0;
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update").append("|type = ").append(paramString).append("|MulRelsotionUrl = ").append(paramMap).append("|vecUrls = ").append(paramList);
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData == null) {
      this.jdField_a_of_type_CooperationQzoneModelCoverCacheData = new CoverCacheData();
    }
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramMap);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramList);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    int i1;
    if (paramList != null) {
      i1 = paramList.size();
    }
    while ((i2 < i1) && (i2 < 16))
    {
      paramString = (Map)paramList.get(i2);
      if (paramString != null)
      {
        paramString = new QzonePhotoView.PhotoInfo(i2, 100, paramString);
        paramString.i = localLinkedList.size();
        paramString.h = i2;
        localLinkedList.add(paramString);
      }
      i2 += 1;
      continue;
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updateCoverData photoInfo size=" + localLinkedList.size());
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
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_b_of_type_JavaLangString = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2130904608, this, true);
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298669));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298668));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298667));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298666);
    paramBaseActivity = getResources().getDisplayMetrics();
    this.e = paramBaseActivity.widthPixels;
    this.f = paramBaseActivity.heightPixels;
    int i1 = (int)(this.e / this.jdField_a_of_type_Float);
    this.g = i1;
    this.j = i1;
    this.h = ((int)(this.j / jdField_b_of_type_Float));
    this.l = getResources().getDimensionPixelSize(2131493222);
    this.m = getResources().getDimensionPixelSize(2131493223);
    this.k = (this.h + this.l + this.m);
    this.i = getResources().getDimensionPixelSize(2131493218);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (VersionUtils.c()) {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
      }
      ThreadManager.a(new txl(this, this.jdField_b_of_type_JavaLangString), 8, null, true);
      paramBaseActivity = Message.obtain();
      paramBaseActivity.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBaseActivity);
      return;
    }
  }
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updateCoverCacheData data = " + paramCoverCacheData);
    }
    if (paramCoverCacheData != null) {
      a(a(paramCoverCacheData.jdField_b_of_type_JavaLangString, paramCoverCacheData.jdField_a_of_type_JavaUtilHashMap, paramCoverCacheData.jdField_a_of_type_JavaUtilArrayList));
    }
    if ((this.jdField_a_of_type_CooperationQzoneModelCoverCacheData != null) && (Utils.a("PhotoWallCover", this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "need get req cover info");
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
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updatePhotoView photoInfo size=" + paramList.size());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramList != null) {}
    for (int i1 = paramList.size(); i1 > 0; i1 = 0)
    {
      this.jdField_a_of_type_ComTencentWidgetGridView.setPadding(0, this.l, 0, this.m);
      this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
      this.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
      VipPhotoViewForSimple.PhotoAdapter localPhotoAdapter = new VipPhotoViewForSimple.PhotoAdapter(this, this.jdField_a_of_type_AndroidAppActivity);
      localPhotoAdapter.a(paramList);
      i1 = paramList.size();
      paramList = new LinearLayout.LayoutParams((this.g + this.i) * i1, this.k);
      this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(paramList);
      this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(i1);
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(localPhotoAdapter);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
      setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ProfileCardTemplate.a(this.jdField_a_of_type_AndroidWidgetImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddSrc");
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(new DataTag(25, null));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(8);
      setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    setVisibility(8);
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover|isSuc = " + paramBoolean + ",uin=" + paramString + ",mUin=" + this.jdField_b_of_type_JavaLangString);
    }
    if (!Utils.a(paramString, this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    List localList;
    int i1;
    if ((paramBoolean) && (parammobile_sub_get_cover_rsp != null))
    {
      localList = a(parammobile_sub_get_cover_rsp.type, parammobile_sub_get_cover_rsp.MulRelsotionUrl, parammobile_sub_get_cover_rsp.vecUrls);
      i1 = 0;
      parammobile_sub_get_cover_rsp = null;
      paramString = null;
      label100:
      if (i1 >= 16) {
        break label293;
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > i1))
      {
        paramString = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
        label143:
        if ((localList == null) || (localList.size() <= i1)) {
          break label242;
        }
        parammobile_sub_get_cover_rsp = (QzonePhotoView.PhotoInfo)localList.get(i1);
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
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
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
      i1 += 1;
      break label100;
      if ((!NetworkUtil.b(BaseApplication.getContext())) || (this.n >= 3)) {
        break;
      }
      paramString = Message.obtain();
      paramString.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
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
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (paramMessage != null)
      {
        paramMessage.a(this.jdField_b_of_type_JavaLangString, 2);
        this.n += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_UPDATE_PHOTO_VIEW");
      }
      if ((paramMessage.obj instanceof LinkedList)) {
        a((List)paramMessage.obj);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\VipPhotoViewForSimple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */