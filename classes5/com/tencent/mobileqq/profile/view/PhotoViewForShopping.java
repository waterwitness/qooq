package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.ShoppingPhotoItemInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import twe;
import twf;

public class PhotoViewForShopping
  extends LinearLayout
  implements Handler.Callback
{
  public static final int a = 100;
  public static final String a = "ProfileCard.ProfileShoppingView";
  public static final int b = 200;
  public static final int c = 1;
  public static final int d = 16;
  public static float e = 0.0F;
  public static final int j = 15;
  public static final int k = 15;
  public float a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  public HorizontalScrollView a;
  public QQAppInterface a;
  private ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
  ProfileShoppingView jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView;
  public VipScaledViewPager a;
  public GridView a;
  private Reference jdField_a_of_type_JavaLangRefReference;
  public List a;
  private boolean jdField_a_of_type_Boolean;
  public float b;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  List jdField_b_of_type_JavaUtilList;
  public float c = 2.0F;
  public float d = 1.35F;
  public int e;
  private float f;
  public int f;
  private float g;
  public int g;
  private float h;
  public int h;
  public int i = -1;
  private int l;
  private int m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_e_of_type_Float = 1.6F;
  }
  
  public PhotoViewForShopping(Context paramContext)
  {
    super(paramContext);
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_Float = 1.6666666F;
    this.jdField_b_of_type_Float = 1.775F;
    this.jdField_f_of_type_Float = 1.0F;
  }
  
  public PhotoViewForShopping(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_Float = 1.6666666F;
    this.jdField_b_of_type_Float = 1.775F;
    this.jdField_f_of_type_Float = 1.0F;
  }
  
  private List a(List paramList)
  {
    new ArrayList();
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.ProfileShoppingView", 2, "updateCoverData photoInfo size=" + paramList.size());
    }
    return paramList;
  }
  
  public List a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, int paramInt, ProfileShoppingView paramProfileShoppingView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.ProfileShoppingView", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_JavaLangRefReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_b_of_type_JavaLangString = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView = paramProfileShoppingView;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2130904607, this, true);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager = ((VipScaledViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131296880));
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_e_of_type_Int = paramBaseActivity.widthPixels;
    this.jdField_f_of_type_Int = paramBaseActivity.heightPixels;
    this.jdField_g_of_type_Float = paramBaseActivity.density;
    this.jdField_g_of_type_Int = ((int)(this.jdField_e_of_type_Int / this.d));
    this.jdField_h_of_type_Int = ((int)(this.jdField_g_of_type_Int / jdField_e_of_type_Float));
    this.i = getResources().getDimensionPixelSize(2131493218);
    boolean bool;
    if (paramProfileCardInfo.a.jdField_a_of_type_Int == 0)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_f_of_type_Float = (this.jdField_g_of_type_Float / this.c);
      if (this.jdField_f_of_type_Int / this.jdField_e_of_type_Int <= (this.jdField_a_of_type_Float + this.jdField_b_of_type_Float) / 2.0F) {
        break label374;
      }
      this.m = Math.round(this.jdField_f_of_type_Int / (1136.0F * this.jdField_f_of_type_Float) * ProfileCardUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 15));
    }
    for (this.jdField_h_of_type_Float = 0.8245033F;; this.jdField_h_of_type_Float = 0.8192771F)
    {
      paramBaseActivity = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getLayoutParams();
      paramBaseActivity.height = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayoutParams(paramBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setScale(this.jdField_h_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setGap(this.m);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setParentView((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getParent());
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setOnPageChangeListener(new twe(this));
      ThreadManager.c(new twf(this, paramProfileCardInfo));
      return;
      bool = false;
      break;
      label374:
      this.m = Math.round(this.jdField_f_of_type_Int / (800.0F * this.jdField_f_of_type_Float) * ProfileCardUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 15));
    }
  }
  
  public void a(List paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.i("ProfileCard.ProfileShoppingView", 2, "updatePhotoView photoInfo size=" + paramList.size());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager != null))
    {
      paramList = new PhotoViewForShopping.StylePagerAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setAdapter(paramList);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, List paramList)
  {
    if (!Utils.a(paramString, this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    List localList;
    int n;
    if ((paramBoolean) && (paramList != null))
    {
      localList = a(paramList);
      n = 0;
      paramList = null;
      paramString = null;
      label34:
      if (n >= 16) {
        break label227;
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > n))
      {
        paramString = (ShoppingPhotoItemInfo)this.jdField_a_of_type_JavaUtilList.get(n);
        label77:
        if ((localList == null) || (localList.size() <= n)) {
          break label176;
        }
        paramList = (ShoppingPhotoItemInfo)localList.get(n);
        label107:
        if (Utils.a(paramString, paramList)) {
          break label181;
        }
      }
    }
    label176:
    label181:
    label227:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.ProfileShoppingView", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
      }
      if ((!paramBoolean) && ((paramString != null) || (paramList != null))) {
        break;
      }
      a(localList);
      return;
      paramString = null;
      break label77;
      paramList = null;
      break label107;
      n += 1;
      break label34;
      if ((!NetworkUtil.b(BaseApplication.getContext())) || (this.l >= 3)) {
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
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCard.ProfileShoppingView", 2, "handleMessage() MSG_REQ_ALBUM");
        }
        paramMessage = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
        if (paramMessage != null)
        {
          paramMessage.a(this.jdField_b_of_type_JavaLangString, 2);
          this.l += 1;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        return false;
        paramMessage = (ProfileShoppingPhotoInfo)paramMessage.obj;
        new ArrayList();
      } while ((paramMessage == null) || (this.jdField_a_of_type_JavaLangRefReference.get() == null));
      String str = paramMessage.shopName;
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).i = paramMessage.accountFlag;
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).j = paramMessage.followType;
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).d = paramMessage.shopName;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView.b(str, paramMessage.certifiedGrade);
      }
      paramMessage = paramMessage.getPhotoFromRawData();
    } while (paramMessage == null);
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList = paramMessage;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView != null) && (paramMessage.size() > 0) && ((this.jdField_a_of_type_JavaLangRefReference.get() instanceof FriendProfileCardActivity))) {
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).p();
    }
    if ((paramMessage.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label366;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "PhotoView", "", "Shop_Mtemplatewindow", "0X8005B95", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      a(paramMessage);
      return false;
      label366:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "PhotoView", "", "Shop_Ftemplatewindow", "0X8005B99", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\PhotoViewForShopping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */