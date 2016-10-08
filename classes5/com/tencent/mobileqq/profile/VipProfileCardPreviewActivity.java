package com.tencent.mobileqq.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.mobileqq.profile.upload.task.VipImageUploadManager;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.widget.CirclePageIndicator;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tvi;
import tvj;
import tvk;
import tvl;
import tvn;
import tvo;
import tvp;
import tvq;
import tvr;

public class VipProfileCardPreviewActivity
  extends VipProfileCardBaseActivity
  implements View.OnClickListener
{
  public static final int K = 0;
  public static final int L = 1;
  public static final int M = 2;
  public static final int N = 3000;
  public static final int O = 1500;
  public static final int Q = -1;
  public static final int R = 0;
  public static final int S = 1;
  public static final int T = 2;
  public static final int U = 640;
  public static final int V = 1136;
  public static final int W = 2;
  public static final int X = 45;
  public static final int Y = 15;
  public static final int Z = 15;
  public static final int aa = 15;
  public static final int ab = 3;
  public static final int ac = 7;
  public static final int ad = 20;
  public static final int ae = 15;
  public static final int af = 18;
  public static final int ag = 40;
  public static final int ah = 10;
  public static final int ai = 11;
  public static final int aj = 11;
  public static final int ak = 3;
  public static final int al = 7;
  public static final int am = 20;
  public static final int an = 15;
  public static final int ao = 16;
  public static final float b = 1.78F;
  public static final float c = 14.5F;
  public static final float d = 16.5F;
  public static final String i = "ProfileCard.VipProfileCardPreviewActivity";
  public static final String k = "com.tencent.mobileqq.action.closeWeb";
  public int P;
  public Drawable a;
  public SparseArray a;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public ProfileCardBackground a;
  public ProfileCardTemplate a;
  public VipProfileCardPreviewActivity.StylePagerAdapter a;
  public VipScaledViewPager a;
  public CirclePageIndicator a;
  private HashMap a;
  public List a;
  public int aA;
  public int aB;
  public int aC;
  public int aD;
  private int aE;
  public int ap;
  public int aq;
  public int ar;
  public int as;
  public int at;
  public int au;
  public int av;
  public int aw;
  public int ax;
  public int ay;
  public int az;
  public long b;
  public View b;
  public Button b;
  public TextView b;
  private CardObserver jdField_b_of_type_ComTencentMobileqqAppCardObserver;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  public ArrayList b;
  public List b;
  public Button c;
  public TextView c;
  public boolean c;
  public boolean d;
  public float e;
  public boolean e;
  public float f;
  public boolean f;
  public float g;
  private volatile boolean g;
  public float h;
  public String j;
  public String l;
  private String m;
  
  public VipProfileCardPreviewActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.P = -1;
    this.jdField_f_of_type_Float = 1.0F;
    this.az = -1;
    this.jdField_g_of_type_Float = 1.6666666F;
    this.h = 1.775F;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.j = "0";
    this.aE = 0;
    this.aD = -1;
    this.l = "is_binding_shop";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqAppCardObserver = new tvr(this);
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int n = 1;
    int i1 = 1;
    int i3 = i1;
    if (paramInt1 != 0)
    {
      i3 = i1;
      if (paramInt2 != 0)
      {
        i3 = i1;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i3 = i1;
        }
      }
    }
    label43:
    int i2;
    label55:
    do
    {
      do
      {
        return i3;
        i1 = paramOptions.outHeight;
        i2 = paramOptions.outWidth;
        i3 = n;
      } while (i1 <= paramInt2);
      i3 = n;
    } while (i2 <= paramInt1);
    int i4 = Math.round(i1 / paramInt2);
    i3 = Math.round(i2 / paramInt1);
    if (i4 > i3) {}
    for (;;)
    {
      i3 = n;
      if (i4 < 2) {
        break;
      }
      i2 /= 2;
      i1 /= 2;
      n *= 2;
      break label55;
      i4 = i3;
    }
  }
  
  private long a()
  {
    int n = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
    return ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(n)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_i_of_type_Long;
  }
  
  private Bitmap a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Bitmap.Config localConfig1 = Bitmap.Config.ARGB_8888;
    int n = 1;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (n <= 2) {}
      try
      {
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inPreferredConfig = localConfig1;
        ((BitmapFactory.Options)localObject1).inDensity = this.J;
        ((BitmapFactory.Options)localObject1).inTargetDensity = this.J;
        ((BitmapFactory.Options)localObject1).inScreenDensity = this.J;
        if (paramBoolean)
        {
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
          ((BitmapFactory.Options)localObject1).inSampleSize = a((BitmapFactory.Options)localObject1, this.aB, this.aA);
        }
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        localObject1 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
        return (Bitmap)localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "getFrameBitmap oom path = " + paramString + ", try count : " + n);
        }
        Bitmap.Config localConfig2 = Bitmap.Config.ARGB_4444;
        n += 1;
      }
      catch (Exception localException)
      {
        do
        {
          localObject1 = localObject2;
        } while (!QLog.isColorLevel());
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "getFrameBitmap oom path = " + paramString + ", msg = " + localException.getMessage() + ", try count : " + n);
      }
    }
    return null;
  }
  
  private void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "url from UPS:" + paramUpsImageUploadResult.url);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramUpsImageUploadResult.url);
    b(paramString, paramUpsImageUploadResult.url);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadManager.a(new tvp(this, paramString1, paramString2), 8, null, true);
  }
  
  private void a(long[] paramArrayOfLong)
  {
    label148:
    int i3;
    if (paramArrayOfLong != null)
    {
      int n = 0;
      long l1;
      if (n < paramArrayOfLong.length)
      {
        l1 = paramArrayOfLong[n];
        if (l1 == ProfileCardTemplate.h)
        {
          i2 = 0;
          Object localObject = this.jdField_a_of_type_AndroidContentContext;
          Context localContext = this.jdField_a_of_type_AndroidContentContext;
          localObject = ((Context)localObject).getSharedPreferences("is_binding_shop", 1);
          i1 = i2;
          if (localObject != null)
          {
            boolean bool = ((SharedPreferences)localObject).getBoolean(this.l, false);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "isBinding=" + bool);
            }
            i1 = i2;
            if (bool)
            {
              this.jdField_b_of_type_JavaUtilArrayList.add(0, Long.valueOf(l1));
              i1 = 1;
            }
          }
          this.jdField_f_of_type_Boolean = true;
          if (this.az == n)
          {
            this.az = 0;
            if (this.jdField_a_of_type_Long == ProfileCardTemplate.jdField_a_of_type_Long) {
              this.az = 0;
            }
            if ((i1 != 0) && (this.az == 0)) {
              ReportController.b(this.app, "CliOper", "", "", "Shop_Malltemplate", "0X8005B93", 0, 0, "", "", "", "");
            }
          }
        }
        for (;;)
        {
          n += 1;
          break;
          if (i1 == 0) {
            break label148;
          }
          this.az += 1;
          break label148;
          this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(l1));
        }
      }
      int i1 = 0;
      n = 0;
      int i2 = 0;
      i3 = n;
      if (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        l1 = ((Long)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).longValue();
        if (l1 == this.jdField_a_of_type_Long)
        {
          n = 1;
          i3 = 1;
          this.az = i1;
        }
        for (;;)
        {
          i1 += 1;
          i2 = i3;
          break;
          i3 = i2;
          if (l1 == this.jdField_b_of_type_Long)
          {
            int i4 = 1;
            n = i4;
            i3 = i2;
            if (i2 == 0)
            {
              this.az = i1;
              n = i4;
              i3 = i2;
            }
          }
        }
      }
    }
    else
    {
      i3 = 0;
    }
    if ((i3 == 0) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(this.jdField_b_of_type_Long));
      if (this.az == -1) {
        this.az = (this.jdField_b_of_type_JavaUtilArrayList.size() - 1);
      }
    }
    if (this.az == -1)
    {
      this.az = 0;
      this.jdField_c_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg mWebStyleList = " + this.jdField_b_of_type_JavaUtilArrayList.toString() + ", mCurrentStyleId = " + this.jdField_a_of_type_Long + ", mWebStyleId = " + this.jdField_b_of_type_Long + ", mCurrentViewPos = " + this.az + ", mStyleListNull = " + this.jdField_c_of_type_Boolean);
    }
  }
  
  private void b(String paramString)
  {
    tvq localtvq = new tvq(this, Long.parseLong(this.app.a()), paramString, VipUploadUtils.a(this.app), "qqprofile", paramString);
    localtvq.b = VipUploadUtils.a(this.app);
    localtvq.n = VipUploadUtils.a(this.app, paramString);
    n();
    localtvq.a();
    ((VipImageUploadManager)this.app.getManager(89)).a(this.app, localtvq, null);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    ProfileCardBackground localProfileCardBackground;
    ProfileCardTemplate localProfileCardTemplate;
    do
    {
      return;
      localProfileCardBackground = new ProfileCardBackground();
      localProfileCardBackground.jdField_a_of_type_Int = 160;
      localProfileCardTemplate = ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem())).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
    } while ((localProfileCardTemplate == null) || (this.jdField_g_of_type_Boolean) || (isFinishing()) || (!a(localProfileCardTemplate, localProfileCardBackground, true)));
    a(a(), 0L, paramString2, ProfileCardUtil.a(paramString1));
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    Object localObject;
    do
    {
      do
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo;
        do
        {
          do
          {
            do
            {
              return;
              localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
            } while ((localObject == null) || (((View)localObject).getTag() == null));
            localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
          } while (localObject == null);
          localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).a;
          localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        } while (localProfileCardTemplateInfo == null);
        switch (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_NONE");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_SCROLL");
      }
      ((ProfileCardScrollImageView)localObject).a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_FADE_IN_OUT");
      }
      if (this.jdField_b_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
    } while ((localObject == null) || (!(localObject instanceof TransitionDrawable)));
    ((TransitionDrawable)localObject).resetTransition();
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localView.getTag(), (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131370929);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(25, 30000L);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void o()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(25);
  }
  
  private void p()
  {
    if (!TextUtils.isEmpty(this.m))
    {
      File localFile = new File(this.m);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int n = 0;
      while (n < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(n)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_i_of_type_Long == paramLong) {
          return n;
        }
        n += 1;
      }
    }
    return -1;
  }
  
  public ProfileCardTemplateInfo a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int n = 0;
      while (n < this.jdField_a_of_type_JavaUtilList.size())
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(n);
        if (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_i_of_type_Long == paramLong) {
          return localProfileCardTemplateInfo;
        }
        n += 1;
      }
    }
    return null;
  }
  
  public List a(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramProfileCardTemplateInfo == null) || (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null)) {}
    for (;;)
    {
      return localArrayList;
      if (this.D == 1) {
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.o);
      }
      while (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d == 2)
      {
        if (this.D != 1) {
          break label95;
        }
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.s);
        return localArrayList;
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.k);
      }
    }
    label95:
    localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.w);
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) {
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem());
  }
  
  public void a(int paramInt)
  {
    if (this.aD != -1)
    {
      c(this.aD);
      this.aD = -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    do
    {
      do
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo;
        do
        {
          do
          {
            do
            {
              return;
              localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
            } while ((localObject == null) || (((View)localObject).getTag() == null));
            localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
          } while (localObject == null);
          localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).a;
          localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        } while ((localProfileCardTemplateInfo == null) || (((ProfileCardScrollImageView)localObject).getTag() == null));
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startAnimation pos = " + paramInt);
        }
        switch (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "no animation to start !");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_SCROLL");
      }
      ((ProfileCardScrollImageView)localObject).setScrollDuration(1500);
      ((ProfileCardScrollImageView)localObject).a(this.aC);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_FADE_IN_OUT");
      }
      localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
    } while (!(localObject instanceof TransitionDrawable));
    Object localObject = (TransitionDrawable)localObject;
    ((TransitionDrawable)localObject).setCrossFadeEnabled(true);
    ((TransitionDrawable)localObject).startTransition(1500);
    this.jdField_b_of_type_JavaLangRunnable = new tvk(this, (TransitionDrawable)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
  }
  
  public void a(int paramInt, ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    if (paramProfileCardTemplateInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startDownload pos = " + paramInt + ", status = " + paramProfileCardTemplateInfo.jdField_a_of_type_Int);
      }
    } while ((paramProfileCardTemplateInfo.jdField_a_of_type_Int == 2) || (paramProfileCardTemplateInfo.jdField_a_of_type_Int == 1));
    paramProfileCardTemplateInfo.jdField_a_of_type_Int = 1;
    paramProfileCardTemplateInfo = a(paramProfileCardTemplateInfo);
    this.jdField_b_of_type_JavaUtilList.addAll(paramProfileCardTemplateInfo);
    a(paramInt, paramProfileCardTemplateInfo);
  }
  
  public void a(int paramInt, String paramString)
  {
    ThreadManager.a(new tvl(this, paramInt, paramString), 5, null, true);
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramInt, (String)paramList.next());
      }
    }
  }
  
  public void a(VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder paramViewHolder, ProfileCardTemplateInfo paramProfileCardTemplateInfo, int paramInt)
  {
    Object localObject;
    if (a(paramProfileCardTemplateInfo))
    {
      paramProfileCardTemplateInfo.jdField_a_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "loadImageDrawable pos = " + paramInt + " info exist");
      }
      localObject = a(paramProfileCardTemplateInfo);
      if ((localObject != null) && (((List)localObject).size() != 0)) {
        break label113;
      }
    }
    label113:
    label453:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "loadImageDrawable pos = " + paramInt + " info not exist");
          return;
          switch (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d)
          {
          default: 
            return;
          case 0: 
            paramViewHolder.a.setIsScroll(false);
            paramProfileCardTemplateInfo = URLDrawable.getDrawable("file://" + ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)((List)localObject).get(0)), this.aB, this.aA, paramViewHolder.a.getDrawable(), paramViewHolder.a.getDrawable(), false);
            paramViewHolder.a.setImageDrawable(paramProfileCardTemplateInfo);
            paramViewHolder.a.setTag(Integer.valueOf(paramInt));
            return;
          case 1: 
            paramViewHolder.a.setIsScroll(true);
            paramProfileCardTemplateInfo = ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)((List)localObject).get(0));
            localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
            ((BitmapFactory.Options)localObject).inDensity = this.J;
            ((BitmapFactory.Options)localObject).inTargetDensity = this.J;
            ((BitmapFactory.Options)localObject).inScreenDensity = this.J;
            BitmapFactory.decodeFile(paramProfileCardTemplateInfo, (BitmapFactory.Options)localObject);
            int n = ((BitmapFactory.Options)localObject).outWidth;
            int i1 = ((BitmapFactory.Options)localObject).outHeight * this.aB / n;
            this.aC = (this.aA - i1);
            paramViewHolder.a.setScaleType(ImageView.ScaleType.MATRIX);
            localObject = new Matrix();
            ((Matrix)localObject).postScale(this.aB / n, this.aB / n);
            paramViewHolder.a.setImageMatrix((Matrix)localObject);
            localObject = (Drawable)BaseApplicationImpl.a.get(paramProfileCardTemplateInfo);
            if (localObject == null) {
              break label453;
            }
            paramViewHolder.a.setImageDrawable((Drawable)localObject);
            paramViewHolder.a.setTag(Integer.valueOf(paramInt));
          }
        } while (this.az != paramInt);
        a(paramInt);
        return;
        ThreadManager.a(new tvn(this, paramProfileCardTemplateInfo, paramInt), 8, null, true);
        return;
        paramViewHolder.a.setIsScroll(false);
      } while ((((List)localObject).size() <= 1) || (TextUtils.isEmpty((CharSequence)((List)localObject).get(0))) || (TextUtils.isEmpty((CharSequence)((List)localObject).get(1))));
      paramProfileCardTemplateInfo = (String)((List)localObject).get(0) + (String)((List)localObject).get(1);
      Drawable localDrawable = (Drawable)BaseApplicationImpl.a.get(paramProfileCardTemplateInfo);
      if (localDrawable == null) {
        break;
      }
      paramViewHolder.a.setImageDrawable(localDrawable);
      paramViewHolder.a.setTag(Integer.valueOf(paramInt));
    } while (this.az != paramInt);
    a(paramInt);
    return;
    ThreadManager.a(new tvo(this, (List)localObject, paramProfileCardTemplateInfo, paramInt), 8, null, true);
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, paramString);
      localObject = new File(paramString);
      if ((((File)localObject).isFile()) && (((File)localObject).exists()))
      {
        localObject = "profilecard_preview:" + paramString;
        Pair localPair = (Pair)BaseApplicationImpl.a.get(localObject);
        if ((localPair == null) || (localPair.first == null)) {
          break label129;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "get image form sImageCache filePath=" + paramString);
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable.ConstantState)localPair.first).newDrawable();
      }
    }
    return;
    label129:
    a(paramString, (String)localObject);
  }
  
  protected boolean a(Message paramMessage)
  {
    int n = 0;
    switch (paramMessage.what)
    {
    default: 
      if (paramMessage.what != 2) {
        break label344;
      }
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      break;
    }
    for (;;)
    {
      return true;
      paramMessage = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getLayoutParams();
      paramMessage.height = this.P;
      paramMessage.topMargin = this.aw;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayoutParams(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setScale(this.jdField_e_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setGap(this.ax);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setVisibility(0);
      l();
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setCurrentItem(this.az);
      b(this.az);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initiate now mCurrentViewPos = " + this.az);
      }
      if (this.jdField_f_of_type_Boolean) {
        ((CardHandler)this.app.a(2)).a(this.app.a());
      }
      return true;
      int i1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildCount();
      while (n < i1)
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildAt(n);
        if ((paramMessage.getTag() instanceof VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)) {
          ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)paramMessage.getTag()).a.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        n += 1;
      }
      return true;
      d(paramMessage.arg1);
      return true;
      d(paramMessage.arg1);
      return true;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label344:
    if (paramMessage.what == 3)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131370911, 0).show();
      return true;
    }
    if (paramMessage.what == 20)
    {
      d(paramMessage.arg1);
      return true;
    }
    if (paramMessage.what == 5)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131370909, 0).show();
      if ((this.B == 1) || (this.B == 2)) {
        if (this.aE == 1) {
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.closeWeb"), "com.tencent.msg.permission.pushnotify");
        }
      }
      for (;;)
      {
        p();
        finish();
        return true;
        paramMessage = new Intent();
        paramMessage.putExtra("uin", this.app.a());
        paramMessage.putExtra("entryId", this.B);
        setResult(-1, paramMessage);
        continue;
        paramMessage = new Intent(this, FriendProfileCardActivity.class);
        paramMessage.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.a(), 0));
        paramMessage.setFlags(67108864);
        startActivity(paramMessage);
      }
    }
    if (paramMessage.what == 21)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramMessage.arg1)).jdField_a_of_type_Int = -1;
      }
      return true;
    }
    if ((paramMessage.what == 24) || (paramMessage.what == 25))
    {
      if (paramMessage.what == 25) {
        b();
      }
      Toast.makeText(getApplicationContext(), getResources().getString(2131370928), 1).show();
      return true;
    }
    return false;
  }
  
  public boolean a(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    if ((paramProfileCardTemplateInfo == null) || (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null)) {
      return false;
    }
    paramProfileCardTemplateInfo = a(paramProfileCardTemplateInfo);
    if ((paramProfileCardTemplateInfo == null) || (paramProfileCardTemplateInfo.size() == 0)) {
      return false;
    }
    paramProfileCardTemplateInfo = paramProfileCardTemplateInfo.iterator();
    while (paramProfileCardTemplateInfo.hasNext())
    {
      String str = (String)paramProfileCardTemplateInfo.next();
      if (!ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, str)) {
        return false;
      }
    }
    return true;
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.a(paramBusinessObserver);
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilList.get(paramInt) == null)) {
      return;
    }
    a(((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground, false);
    if (this.jdField_b_of_type_Int == 4)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131370921);
      this.j = "2";
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131370920);
      this.j = "1";
      return;
    }
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131370916);
    this.j = "0";
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_g_of_type_Boolean = false;
    setContentView(2130904615);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_b_of_type_AndroidViewView = findViewById(2131302291);
    float f1;
    label419:
    QQAppInterface localQQAppInterface;
    if ((this.app != null) && (ThemeUtil.isInNightMode(this.app)))
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.app != null) {
        this.l += this.app.a();
      }
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131302898));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131303356));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager = ((VipScaledViewPager)findViewById(2131296880));
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter = new VipProfileCardPreviewActivity.StylePagerAdapter(this, this.jdField_a_of_type_AndroidContentContext);
      if (Build.MODEL.equals("HUAWEI C8812E")) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayerType(1, null);
      }
      this.jdField_f_of_type_Float = (this.jdField_a_of_type_Float / 2.0F);
      if (this.H / this.I <= (this.jdField_g_of_type_Float + this.h) / 2.0F) {
        break label793;
      }
      f1 = this.H / (1136.0F * this.jdField_f_of_type_Float);
      this.ap = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.aq = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.ar = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.as = ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 45);
      this.at = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 3) * f1);
      this.av = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 7) * f1);
      this.au = Math.round(ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.5F) * f1);
      this.aw = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 20) * f1);
      this.ax = Math.round(f1 * ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15));
      this.jdField_e_of_type_Float = 0.8245033F;
      this.ay = 18;
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetButton.getLayoutParams();
      paramBundle.height = this.as;
      int n = this.ar;
      paramBundle.leftMargin = n;
      paramBundle.rightMargin = n;
      paramBundle.bottomMargin = this.aq;
      this.jdField_c_of_type_AndroidWidgetButton.setTextSize(1, this.ay);
      this.jdField_c_of_type_AndroidWidgetButton.setLayoutParams(paramBundle);
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.getLayoutParams();
      paramBundle.topMargin = this.au;
      paramBundle.bottomMargin = this.au;
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setLayoutParams(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding(this.av);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setRadius(this.at);
      n = getResources().getDimensionPixelSize(2131492908);
      int i1 = ProfileCardUtil.a(getResources());
      this.P = (this.H - this.aw - this.aq - this.as - this.at * 2 - this.au * 2 - n - i1);
      this.aA = this.P;
      this.aB = Math.round(this.aA / 1.78F);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setStrokeWidth(0.0F);
      addObserver(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
      ThreadManager.a(new tvi(this), 8, null, true);
      j();
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.app != null) {
        this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      }
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setOnPageChangeListener(new tvj(this));
      if (this.app != null)
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground != null) {
          break label988;
        }
      }
    }
    label793:
    label988:
    for (paramBundle = "";; paramBundle = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int))
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "card_mall", "0X8004D59", 0, 0, paramBundle, "", "", VipUtils.a(this.app, this.app.a()));
      return true;
      if (this.jdField_b_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
      f1 = this.H / (800.0F * this.jdField_f_of_type_Float);
      this.ap = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 11) * f1);
      this.aq = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 10) * f1);
      this.ar = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 11) * f1);
      this.as = ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 40);
      this.at = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 3) * f1);
      this.av = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 7) * f1);
      this.au = Math.round(ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.5F) * f1);
      this.aw = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 20) * f1);
      this.ax = Math.round(f1 * ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15));
      this.ay = 16;
      this.jdField_e_of_type_Float = 0.8192771F;
      break label419;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_b_of_type_ComTencentMobileqqAppCardObserver != null)
    {
      this.app.b(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_b_of_type_ComTencentMobileqqAppCardObserver = null;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    setLeftViewName(2131367975);
    setTitle(2131370917);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData start.");
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilArrayList == null)) {
      return;
    }
    Object localObject2 = null;
    ArrayList localArrayList = a();
    if (this.jdField_b_of_type_Long == 0L)
    {
      localObject1 = new ProfileCardTemplate();
      ((ProfileCardTemplate)localObject1).jdField_i_of_type_Long = 0L;
      ((ProfileCardTemplate)localObject1).m = "http://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).jdField_i_of_type_JavaLangString = "http://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).o = "http://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).k = "http://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).g = "0";
      ((ProfileCardTemplate)localObject1).e = getString(2131370874);
      localArrayList.add(localObject1);
    }
    Object localObject1 = localObject2;
    int n;
    Object localObject3;
    label333:
    int i1;
    int i2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = new ArrayList();
        if (this.jdField_c_of_type_Boolean)
        {
          n = 0;
          if (n < localArrayList.size())
          {
            localObject2 = (ProfileCardTemplate)localArrayList.get(n);
            if (this.jdField_a_of_type_Long == ((ProfileCardTemplate)localObject2).jdField_i_of_type_Long) {
              this.az = n;
            }
            if (((ProfileCardTemplate)localObject2).jdField_i_of_type_Long == ProfileCardTemplate.h)
            {
              this.jdField_f_of_type_Boolean = true;
              localObject3 = this.jdField_a_of_type_AndroidContentContext;
              Context localContext = this.jdField_a_of_type_AndroidContentContext;
              localObject3 = ((Context)localObject3).getSharedPreferences("is_binding_shop", 1);
              if ((localObject3 != null) && (((SharedPreferences)localObject3).getBoolean(this.l, false))) {
                this.jdField_b_of_type_JavaUtilArrayList.add(0, Long.valueOf(((ProfileCardTemplate)localObject2).jdField_i_of_type_Long));
              }
              if (this.az == n)
              {
                this.az = 0;
                ReportController.b(this.app, "CliOper", "", "", "Shop_Malltemplate", "0X8005B93", 0, 0, "", "", "", "");
              }
            }
            for (;;)
            {
              n += 1;
              break;
              this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(((ProfileCardTemplate)localObject2).jdField_i_of_type_Long));
            }
          }
        }
        n = 0;
        if (n < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          i1 = 0;
          i2 = 0;
          label351:
          if (i2 < localArrayList.size())
          {
            localObject2 = (ProfileCardTemplate)localArrayList.get(i2);
            if (((Long)this.jdField_b_of_type_JavaUtilArrayList.get(n)).longValue() != ((ProfileCardTemplate)localObject2).jdField_i_of_type_Long) {
              break label851;
            }
            localObject3 = new ProfileCardTemplateInfo();
            ((ProfileCardTemplateInfo)localObject3).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)localObject2);
            if (a((ProfileCardTemplateInfo)localObject3))
            {
              ((ProfileCardTemplateInfo)localObject3).jdField_a_of_type_Int = 2;
              label423:
              a(((ProfileCardTemplateInfo)localObject3).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
              ((ArrayList)localObject1).add(localObject3);
              i1 = 1;
            }
          }
        }
      }
    }
    label758:
    label797:
    label838:
    label851:
    for (;;)
    {
      i2 += 1;
      break label351;
      ((ProfileCardTemplateInfo)localObject3).jdField_a_of_type_Int = 0;
      break label423;
      if (i1 == 0)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(n);
        if ((this.az > 0) && (n <= this.az)) {
          this.az -= 1;
        }
        n -= 1;
      }
      for (;;)
      {
        n += 1;
        break label333;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList != null)) {
              this.jdField_a_of_type_JavaUtilList.clear();
            }
            if (this.jdField_a_of_type_JavaUtilList == null) {
              break;
            }
            this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
            this.d = true;
            if (!QLog.isColorLevel()) {
              break label838;
            }
            n = 0;
          }
          for (;;)
          {
            if (n < this.jdField_a_of_type_JavaUtilList.size())
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData, style : " + ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(n)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_i_of_type_Long + ", status : " + ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(n)).jdField_a_of_type_Int + ", position : " + n);
              }
              n += 1;
              continue;
              localObject1 = new ArrayList();
              n = 0;
              if (n < localArrayList.size())
              {
                localObject2 = new ProfileCardTemplateInfo();
                ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)localArrayList.get(n));
                if (a((ProfileCardTemplateInfo)localObject2))
                {
                  ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_Int = 2;
                  a(((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
                  if (((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_i_of_type_Long != ProfileCardTemplate.h) {
                    break label797;
                  }
                }
                for (;;)
                {
                  n += 1;
                  break;
                  ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_Int = 0;
                  break label758;
                  ((ArrayList)localObject1).add(localObject2);
                }
              }
              if (this.jdField_a_of_type_JavaUtilList == null) {
                break;
              }
              this.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
              this.d = true;
            }
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.az != -1)
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(this.az);
        a(this.az, localProfileCardTemplateInfo);
      }
      int n = 0;
      if (n < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.az != -1) && (n == this.az)) {}
        for (;;)
        {
          n += 1;
          break;
          a(n, (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(n));
        }
      }
    }
  }
  
  public void m()
  {
    int n = 0;
    i();
    Object localObject = getIntent();
    if (localObject != null)
    {
      if (((Intent)localObject).hasExtra("preview"))
      {
        this.aE = 0;
        String str = ((Intent)localObject).getStringExtra("preview");
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg preview = " + str);
        }
        try
        {
          localObject = new JSONObject(str);
          if (((JSONObject)localObject).has("entryId")) {
            this.B = ((JSONObject)localObject).getInt("entryId");
          }
          localObject = ((JSONObject)localObject).getJSONObject("item");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground = new ProfileCardBackground();
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("id");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("name");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("image_url");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("thumb_url");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("auth");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.d = ((JSONObject)localObject).optInt("limitefree_type");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.e = ((JSONObject)localObject).optInt("limitefree_btime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.f = ((JSONObject)localObject).optInt("limitefree_etime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.m = ((JSONObject)localObject).optInt("color");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.g = ((JSONObject)localObject).optInt("tag");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.h = ((JSONObject)localObject).optInt("tag_btime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.i = ((JSONObject)localObject).optInt("tag_etime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.j = ((JSONObject)localObject).optInt("background_btime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.k = ((JSONObject)localObject).optInt("background_etime");
          this.D = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.m;
          a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground);
          this.jdField_b_of_type_Long = ((JSONObject)localObject).optInt("style");
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int == 160)
          {
            this.jdField_b_of_type_Long = 1L;
            localObject = a();
            a((long[])localObject);
            a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString);
            return;
          }
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("style_list");
          long[] arrayOfLong = new long[localJSONArray.length()];
          for (;;)
          {
            localObject = arrayOfLong;
            if (n >= localJSONArray.length()) {
              break;
            }
            arrayOfLong[n] = localJSONArray.getLong(n);
            n += 1;
          }
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg JSONException json = " + str);
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        return;
      }
      if (localJSONException.hasExtra("custom_card_background"))
      {
        this.aE = 1;
        this.m = localJSONException.getStringExtra("custom_card_background");
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground = new ProfileCardBackground();
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int = 160;
        this.jdField_b_of_type_Long = 1L;
        a(a());
        a(this.m, null);
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C28", 0, 0, "", "", "", VipUtils.a(this.app, this.app.a()));
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0));
        if (this.aE != 0) {
          break;
        }
        int n = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
        paramView = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(n);
        ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.j, Long.toString(paramView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_i_of_type_Long), "", VipUtils.a(this.app, this.app.a()));
        if (paramView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_i_of_type_Long == ProfileCardTemplate.h) {
          ReportController.b(this.app, "CliOper", "", "", "Shop_Malltemplateclk", "0X8005B92", 0, 0, "", "", "", "");
        }
      } while (!a(paramView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground, true));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int != 160)
      {
        a(paramView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_i_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int);
        return;
      }
      a(a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.m);
      return;
    } while (this.aE != 1);
    ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.j, "-1", "", VipUtils.a(this.app, this.app.a()));
    ProfileCardUtil.a(this.m, 100, 0.5633803F);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get(this.m)))
    {
      b(this.m, (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.m));
      return;
    }
    b(this.m);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\VipProfileCardPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */