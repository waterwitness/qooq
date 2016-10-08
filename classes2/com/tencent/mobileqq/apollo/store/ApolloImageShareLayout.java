package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRender.ISnapShotCallback;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloActionTask;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetAdapter;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import prv;

public class ApolloImageShareLayout
  extends RelativeLayout
  implements DialogInterface.OnDismissListener, Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, ApolloRender.ISnapShotCallback, IRenderCallback, OnApolloViewListener, ActionSheet.OnButtonClickListener
{
  static final String jdField_a_of_type_JavaLangString = "ApolloImageShareLayout";
  private static final int g = 15;
  private static final int h = 16;
  private static final int i = 17;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  public WeakReferenceHandler a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private ActionSheetAdapter jdField_a_of_type_ComTencentWidgetActionSheetAdapter;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  
  public ApolloImageShareLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaLangString = "apollo_fakeurl";
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if ((paramContext instanceof Activity)) {
      this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    }
  }
  
  public ApolloImageShareLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "apollo_fakeurl";
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if ((paramContext instanceof Activity)) {
      this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null))
    {
      if (!paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().g();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_c_of_type_Int, this.jdField_a_of_type_Float, this.jdField_a_of_type_Int / DeviceInfoUtil.a() / 2.0F * 1.05F, 0.0F);
        if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_a_of_type_ArrayOfInt, null);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b();
      String[] arrayOfString = ApolloActionTask.a(5, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, 5, ApolloActionManager.a().b() + 1000000, arrayOfString[0], arrayOfString[1]);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ActionSheetAdapter.a(1));
      localArrayList.add(ActionSheetAdapter.a(0));
      if (this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = new ActionSheetAdapter(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter.a(localArrayList);
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter, this, this, this, false);
      }
    } while ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_c_of_type_Int > 0) {
      b(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a(0L);
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, int[] paramArrayOfInt, float paramFloat, String paramString1, String paramString2)
  {
    super.setVisibility(0);
    this.jdField_c_of_type_JavaLangString = paramString2;
    if ((paramInt != this.jdField_c_of_type_Int) || (paramArrayOfInt != this.jdField_a_of_type_ArrayOfInt) || (paramFloat != this.jdField_a_of_type_Float))
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
      this.jdField_a_of_type_Float = paramFloat;
      b(false);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
      }
      if ((paramString1 != null) && (!paramString1.equals(this.jdField_b_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_JavaLangString = paramString1;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = "http://cmshow.gtimg.cn/client/img/apollo_share_float_bg.png";
        }
        paramArrayOfInt = URLDrawable.URLDrawableOptions.obtain();
        paramArrayOfInt.mRequestHeight = this.f;
        paramArrayOfInt.mRequestWidth = this.e;
        paramString1 = new RoundRectColorDrawable(-8305182, 20.0F, this.e, this.f);
        paramArrayOfInt.mLoadingDrawable = paramString1;
        paramArrayOfInt.mFailedDrawable = paramString1;
        paramArrayOfInt = ApolloImageDownloader.a(Utils.Crc64String(this.jdField_b_of_type_JavaLangString), paramArrayOfInt, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramArrayOfInt);
      }
      VipUtils.a(null, "cmshow", "Apollo", "PageView", 2, 0, new String[0]);
      return;
      b(true);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, int[] paramArrayOfInt, float paramFloat)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Float = paramFloat;
    super.setBackgroundColor(-1778384896);
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      super.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      this.e = ((int)(DeviceInfoUtil.h() - AIOUtils.a(45.0F, getResources()) * 2));
      this.f = (this.e * 750 / 570);
      paramAppInterface = new RelativeLayout.LayoutParams(this.e, this.f);
      paramAppInterface.addRule(9);
      paramAppInterface.addRule(11);
      paramAppInterface.addRule(10);
      paramInt = AIOUtils.a(45.0F, getResources());
      paramAppInterface.leftMargin = paramInt;
      paramAppInterface.rightMargin = paramInt;
      paramAppInterface.topMargin = AIOUtils.a(74.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setDrawingCacheEnabled(true);
      super.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramAppInterface);
      paramInt = this.f * 162 / 750;
      this.jdField_a_of_type_Int = ((int)(368.0F * paramFloat * 0.8F));
      this.jdField_b_of_type_Int = ((int)(368.0F * paramFloat * 1.3F));
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(getContext(), null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a(this);
      paramAppInterface = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.d = (this.f - this.jdField_b_of_type_Int - paramInt);
      paramAppInterface.topMargin = (AIOUtils.a(74.0F, getResources()) + this.d);
      super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(this);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843457);
      paramAppInterface = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, getResources()), AIOUtils.a(52.0F, getResources()));
      paramAppInterface.addRule(10, -1);
      paramAppInterface.addRule(11, -1);
      paramAppInterface.rightMargin = AIOUtils.a(5.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(17.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131428258));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369134);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      super.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("看书的懒猫");
      paramAppInterface = new RelativeLayout.LayoutParams(-2, -2);
      paramAppInterface.topMargin = AIOUtils.a(30.0F, getResources());
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramAppInterface);
      paramInt = (int)(AIOUtils.a(55.0F, getResources()) * 0.96F);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt, paramInt);
      paramAppInterface.topMargin = (AIOUtils.a(113.0F, getResources()) + this.f);
      paramAppInterface.rightMargin = ((int)(AIOUtils.a(135.0F, getResources()) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(-16776961);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837755);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt, paramInt);
      paramAppInterface.topMargin = (AIOUtils.a(113.0F, getResources()) + this.f);
      paramAppInterface.leftMargin = ((int)(AIOUtils.a(60.0F, getResources()) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130837756);
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt, paramInt);
      paramAppInterface.topMargin = (AIOUtils.a(113.0F, getResources()) + this.f);
      paramAppInterface.rightMargin = ((int)(AIOUtils.a(60.0F, getResources()) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.jdField_c_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130837757);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.setVisibility(8);
    if (paramBoolean)
    {
      super.removeAllViews();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().c();
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloImageShareLayout", 2, "onSnapShot Request:" + paramLong);
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= paramInt1 * paramInt2)) {
      ThreadManager.b(new prv(this, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramLong));
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
        do
        {
          do
          {
            AppInterface localAppInterface;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return false;
                    } while (super.getVisibility() != 0);
                    paramMessage = (String)paramMessage.obj;
                  } while (TextUtils.isEmpty(paramMessage));
                  QQToast.a(getContext(), "图片已保存到" + paramMessage, 1).a();
                  return false;
                  if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
                    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
                  }
                } while ((super.getVisibility() != 0) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
                localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
              } while (localAppInterface == null);
              paramMessage = (String)paramMessage.obj;
              if (!TextUtils.isEmpty(paramMessage)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("ApolloImageShareLayout", 1, "onItemClick share QZone apolloImage no file");
            return false;
            Bundle localBundle = new Bundle();
            ArrayList localArrayList = new ArrayList();
            try
            {
              localArrayList.add(URLDecoder.decode(paramMessage));
              localBundle.putStringArrayList("images", localArrayList);
              localBundle.putString("summary", "厘米秀");
              localBundle.putInt("req_type", 7);
              localBundle.putBoolean("key_need_save_draft", false);
              QZoneShareManager.a(localAppInterface, this.jdField_a_of_type_AndroidAppActivity, localBundle, this, 15);
              return false;
            }
            catch (Exception paramMessage)
            {
              QLog.d("ApolloImageShareLayout", 2, "publishToQzone:" + paramMessage.getMessage());
              return false;
            }
            if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
              this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
            }
          } while (super.getVisibility() != 0);
          paramMessage = (String)paramMessage.obj;
          if (!TextUtils.isEmpty(paramMessage)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
        return false;
        if (new File(paramMessage).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
      return false;
    } while (this.jdField_a_of_type_AndroidAppActivity == null);
    ApolloUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramMessage, null, 1);
    return false;
  }
  
  public void onClick(View paramView)
  {
    long l;
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 800L) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Boolean)
      {
        QQToast.a(getContext(), "正在保存", 0).a();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloImageShareLayout", 2, "download Request:" + l);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(this, 15, l);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.c();
      }
      VipUtils.a(null, "cmshow", "Apollo", "SaveClick", 0, 0, new String[0]);
      return;
      if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
      {
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null))
        {
          paramView = ApolloActionTask.a(5, this.jdField_c_of_type_Int, true);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, 5, ApolloActionManager.a().b() + 1000000, paramView[0], paramView[1]);
        }
        VipUtils.a(null, "cmshow", "Apollo", "PoseClick", 0, 0, new String[0]);
        return;
      }
      if (paramView == this.jdField_c_of_type_AndroidWidgetImageView)
      {
        a();
        VipUtils.a(null, "cmshow", "Apollo", "ShareClick", 0, 0, new String[0]);
        return;
      }
    } while (paramView != this.jdField_b_of_type_AndroidWidgetTextView);
    VipUtils.a(null, "cmshow", "Apollo", "CloseClick", 0, 0, new String[0]);
    a(false);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long < 1000L) {
      return;
    }
    this.jdField_b_of_type_Long = l;
    if (paramLong == 1L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(this, 16, System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.c();
      }
      VipUtils.a(null, "cmshow", "Apollo", "Share2Qzone", 0, 0, new String[0]);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(this, 17, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.c();
    }
    VipUtils.a(null, "cmshow", "Apollo", "Share2QQ", 0, 0, new String[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloImageShareLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */