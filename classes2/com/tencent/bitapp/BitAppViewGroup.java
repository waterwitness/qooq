package com.tencent.bitapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.cache.BitAppFileCache;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hdp;
import hds;
import hdt;
import hdu;
import hdw;
import java.io.File;
import java.net.URL;

public class BitAppViewGroup
  extends RelativeLayout
{
  public static final Drawable a;
  protected static final String a = "BitAppViewGroup";
  private static int b;
  public static Drawable b;
  public static Drawable c;
  protected int a;
  protected View a;
  protected ImageView a;
  public BitAppMsgItemBuilder a;
  public MessageForBitApp a;
  public URLImageView a;
  protected OnLongClickAndTouchListener a;
  protected boolean a;
  protected View b;
  private int c;
  private final int d = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
    jdField_b_of_type_Int = 12;
  }
  
  public BitAppViewGroup(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BitAppViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BitAppViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static void a()
  {
    if ((jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) && (jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)) {
      return;
    }
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_b_of_type_Int = AIOUtils.a(jdField_b_of_type_Int, localResources);
    float f = AIOUtils.a(4.0F, localResources);
    jdField_c_of_type_AndroidGraphicsDrawableDrawable = StructMsgUtils.a(localResources, -1, new float[] { f, f, f, f, f, f, f, f });
    jdField_b_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(2130838831);
  }
  
  private void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mThumbNailURl)) {
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mThumbNailURl);
    }
    for (;;)
    {
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      if (!(paramContext instanceof BaseActivity)) {
        break;
      }
      ReportController.b(((BaseActivity)paramContext).app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBitappMessageForBitApp.selfuin, "0X8006330", "0X8006330", 0, 1, 0, String.valueOf(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.getMsgId()), this.jdField_a_of_type_ComTencentBitappMessageForBitApp.senderuin, "", "");
      return;
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mLolaUrl);
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBitappMessageForBitApp.selfuin, "0X8006330", "0X8006330", 0, 1, 0, String.valueOf(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.getMsgId()), this.jdField_a_of_type_ComTencentBitappMessageForBitApp.senderuin, "", "");
  }
  
  public File a(String paramString)
  {
    return BitAppFileCache.a(getContext()).a(paramString);
  }
  
  public URL a(String paramString)
  {
    return BitAppFileCache.a(getContext()).a(paramString);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == -1)
    {
      paramInt = BitAppMsgItemBuilder.a(getResources(), this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mHeight, 240);
      if (paramInt != getHeight())
      {
        localLayoutParams = getLayoutParams();
        if (localLayoutParams != null) {
          break label59;
        }
        localLayoutParams = new ViewGroup.LayoutParams(-1, paramInt);
      }
      for (;;)
      {
        setLayoutParams(localLayoutParams);
        return;
        label59:
        localLayoutParams.width = -1;
        localLayoutParams.height = paramInt;
      }
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
    }
  }
  
  public void a(BitAppMsgItemBuilder paramBitAppMsgItemBuilder, MessageForBitApp paramMessageForBitApp, boolean paramBoolean, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, View.OnClickListener paramOnClickListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "startShow ... " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    if (paramBitAppMsgItemBuilder != this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder) {
      this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder = paramBitAppMsgItemBuilder;
    }
    if ((paramMessageForBitApp.bitAppMsg.adverSign == 1) && (!TextUtils.isEmpty(paramMessageForBitApp.bitAppMsg.adverKey)) && (paramOnClickListener != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    int i;
    while ((this.jdField_a_of_type_ComTencentBitappMessageForBitApp == null) || (paramMessageForBitApp.uniseq != this.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq))
    {
      this.jdField_a_of_type_ComTencentBitappMessageForBitApp = paramMessageForBitApp;
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mState;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
      d();
      i = paramMessageForBitApp.bitAppMsg.getModuleId();
      paramBitAppMsgItemBuilder = BundleStructCache.INSTANCE.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("BitAppViewGroup", 2, "forceShow: " + paramBoolean + " | mState: " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mState + " | module_state: " + paramBitAppMsgItemBuilder.module_state);
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mState > -1) && (paramBitAppMsgItemBuilder.module_state == 1))
      {
        c();
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      else
      {
        b();
      }
    }
    for (;;)
    {
      k();
      return;
      if (paramMessageForBitApp.bitAppMsg.mState != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mState;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
        i = paramMessageForBitApp.bitAppMsg.getModuleId();
        paramBitAppMsgItemBuilder = BundleStructCache.INSTANCE.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("BitAppViewGroup", 2, "msg exist, forceShow: " + paramBoolean + " | mState: " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mState + " | module_state: " + paramBitAppMsgItemBuilder.module_state);
        }
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mState > -1) && (paramBitAppMsgItemBuilder.module_state == 1))
        {
          c();
          return;
        }
        b();
      }
      else if (((this.jdField_a_of_type_Boolean) && (!paramBoolean)) || ((!this.jdField_a_of_type_Boolean) && (paramBoolean) && (this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mState > -1)))
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mState;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
        i = paramMessageForBitApp.bitAppMsg.getModuleId();
        paramBitAppMsgItemBuilder = BundleStructCache.INSTANCE.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("BitAppViewGroup", 2, "Exist mForceShow: " + this.jdField_a_of_type_Boolean + " | module_state: " + paramBitAppMsgItemBuilder.module_state);
        }
        if ((this.jdField_a_of_type_Boolean) && (paramBitAppMsgItemBuilder.module_state == 1))
        {
          c();
          return;
        }
        b();
      }
    }
  }
  
  protected void a(BitAppBaseView paramBitAppBaseView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "addBitAppView ... msg: " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    addView(paramBitAppBaseView, 0);
    this.jdField_b_of_type_AndroidViewView = paramBitAppBaseView;
    a(-1);
  }
  
  public void b()
  {
    URLDrawable localURLDrawable = null;
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "loadThumbnails ... " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (a(String.valueOf(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq)).exists())
    {
      localLayoutParams.setMargins(0, 0, 0, 0);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    for (;;)
    {
      try
      {
        URL localURL = a(String.valueOf(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq));
        if (localURL != null) {
          localURLDrawable = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        }
        if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 2)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BitAppViewGroup", 4, "loadThumbnails load disk FAILED");
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new hdw(this, this.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq));
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BitAppViewGroup", 4, "loadThumbnails load disk error, " + localException1.getMessage());
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        setBackgroundDrawable(jdField_c_of_type_AndroidGraphicsDrawableDrawable);
        f();
        continue;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      g();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BitAppViewGroup", 4, "loadThumbnails load disk success");
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
      f();
      j();
      continue;
      localLayoutParams.setMargins(jdField_b_of_type_Int, jdField_b_of_type_Int, jdField_b_of_type_Int, jdField_b_of_type_Int);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mLolaThumbnail))
      {
        try
        {
          localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mLolaThumbnail, (URLDrawable.URLDrawableOptions)localObject);
          if ((localObject == null) || (((URLDrawable)localObject).getStatus() == 2))
          {
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(jdField_b_of_type_AndroidGraphicsDrawableDrawable);
            setBackgroundDrawable(jdField_c_of_type_AndroidGraphicsDrawableDrawable);
            f();
          }
        }
        catch (Exception localException2)
        {
          Drawable localDrawable;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BitAppViewGroup", 4, "loadThumbnails load net error, " + localException2.getMessage());
            }
            localDrawable = null;
          }
          this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new hdw(this, this.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq));
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
          j();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        setBackgroundDrawable(jdField_c_of_type_AndroidGraphicsDrawableDrawable);
        f();
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "loadBitAppView ... " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder != null)
    {
      localObject1 = localObject2;
      if (getContext() != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentBitappMessageForBitApp != null)
        {
          if (!RNPreDownloadFacade.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("BitAppViewGroup", 4, "not ready checkReadyTimes: " + this.jdField_c_of_type_Int);
            }
            this.jdField_c_of_type_Int += 1;
            if (this.jdField_c_of_type_Int > 1)
            {
              b();
              k();
              return;
            }
            RNPreDownloadFacade.a(this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.a, getContext(), true, new hdp(this));
            return;
          }
          localObject1 = this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.a(getContext(), this.jdField_a_of_type_ComTencentBitappMessageForBitApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener, new hds(this));
        }
      }
    }
    String str = "";
    localObject2 = str;
    if (localObject1 != null)
    {
      Bundle localBundle = ((BitAppBaseView)localObject1).getExtra();
      localObject2 = str;
      if (localBundle != null) {
        localObject2 = localBundle.getString("msgid");
      }
    }
    if ((localObject1 != null) && (TextUtils.equals(String.valueOf(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq), (CharSequence)localObject2)))
    {
      a((BitAppBaseView)localObject1);
      return;
    }
    b();
    k();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "resetViews ... " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      removeView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "showLoadingView ... " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "hideLoadingView ... " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "showThumbnail ... " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    a(-2);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "hideThumbnail ... " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "showBitAppView ... msg: " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    f();
    postDelayed(new hdt(this), 300L);
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppViewGroup", 4, "releaseBitAppView ... msg: " + this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      removeView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
  }
  
  public void k()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mThumbNailURl)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.mLolaUrl))) {
      setOnClickListener(new hdu(this));
    }
    setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131304693);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131304694));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131304695));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */