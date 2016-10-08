package com.tencent.mobileqq.nearby;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troopgift.GiftBitmapAnimaionCache;
import com.tencent.mobileqq.troopgift.SendFlowerSurfaceView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import thr;
import tht;
import thv;

public class NearbyFlowerAnimationController
  implements View.OnClickListener
{
  public static final String a;
  public static final String b = "/avatar/avatar_anim_res.png";
  private long jdField_a_of_type_Long;
  public Handler a;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  public ImageView a;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ActionGlobalData jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
  public NearbyFlowerAnimationController.OnCleanAnimationListener a;
  private FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener;
  public GiftBitmapAnimaionCache a;
  public SendFlowerSurfaceView a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyFlowerAnimationController.class.getSimpleName();
  }
  
  public NearbyFlowerAnimationController(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject = null;
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.equals(paramString, "null"))) {}
    do
    {
      try
      {
        paramString = BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130839235);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        do
        {
          paramString = (String)localObject;
        } while (!QLog.isColorLevel());
        QLog.e(jdField_a_of_type_JavaLangString, 2, "decode headBitmap failed");
        return null;
      }
      String str = ImageResUtil.a() + MD5.toMD5(paramString) + paramString.substring(paramString.lastIndexOf("."));
      if (!FileUtil.a(str))
      {
        File localFile = new File(str);
        boolean bool = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localFile);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "download head url=" + paramString + ", path=" + str + ", ret=" + bool);
        }
      }
      for (;;)
      {
        paramString = (String)localObject;
        if (!FileUtil.a(str)) {
          break;
        }
        try
        {
          paramString = BitmapFactory.decodeFile(str);
          return paramString;
        }
        catch (OutOfMemoryError paramString)
        {
          paramString = (String)localObject;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "head file exist: " + str);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "decode headBitmap failed");
    return null;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(BaseApplicationImpl.getContext(), 2130904229, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView = ((SendFlowerSurfaceView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301911));
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.setZOrderOnTop(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.getHolder().setFormat(-2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296906));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
  }
  
  private void b(NearbyFlowerMessage paramNearbyFlowerMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showPinkBand y: " + paramInt);
    }
    Object localObject = "×" + paramNearbyFlowerMessage.fCount;
    String str = paramNearbyFlowerMessage.brief;
    paramNearbyFlowerMessage = new SpannableStringBuilder(str + (String)localObject);
    paramNearbyFlowerMessage.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), str.length(), str.length() + ((String)localObject).length(), 18);
    paramNearbyFlowerMessage.setSpan(new AbsoluteSizeSpan(DisplayUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 17.0F)), str.length(), str.length() + 1, 18);
    AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(DisplayUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 19.0F));
    int i = str.length();
    int j = str.length();
    paramNearbyFlowerMessage.setSpan(localAbsoluteSizeSpan, i + 1, ((String)localObject).length() + j, 18);
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
    }
    localObject = new RelativeLayout.LayoutParams(-2, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDimension(2131493587));
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).setMargins(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 10.0F), paramInt, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 10.0F), 0);
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 15.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840201);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getColorStateList(2131427407));
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramInt = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 30.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(paramInt, this.jdField_a_of_type_AndroidWidgetTextView.getPaddingTop(), paramInt, this.jdField_a_of_type_AndroidWidgetTextView.getPaddingBottom());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 0, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramNearbyFlowerMessage);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "stopFlowerAnimation");
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      d();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener.a();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "stopFlowerAnimation", localException);
        }
      }
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "dismissPinkBand");
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "stop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.a();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new thv(this));
  }
  
  public void a(NearbyFlowerMessage paramNearbyFlowerMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showFlowerAnimation Start, packageId: " + paramNearbyFlowerMessage.pID);
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "find mAnimationRelativeLayout");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = NearbyFlowerUtil.a(paramNearbyFlowerMessage.pID);
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "can't find actionGlobalData");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener == null);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener.a();
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = null;
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showFlowerAnimation actionGlobalData windowWidth:" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.d + ", windowHeight:" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.e + ", windowCenter: " + this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.g + ", avatarCenter: " + this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.f);
    }
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSystemService("window"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache = new GiftBitmapAnimaionCache();
    }
    List localList = NearbyFlowerUtil.a(paramNearbyFlowerMessage.pID);
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.a(localList, this.jdField_a_of_type_AndroidOsHandler, paramNearbyFlowerMessage.pID);
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.setVisibility(0);
    ThreadManager.a(new tht(this, paramNearbyFlowerMessage), 8, null, true);
  }
  
  public void a(NearbyFlowerMessage paramNearbyFlowerMessage, int paramInt)
  {
    if (paramNearbyFlowerMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "showFlowerAnimationAndPinkBand message is null");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showFlowerAnimationAndPinkBand tipY: " + paramInt);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView == null);
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "创建头像时间 = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendFlowerSurfaceView show");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.a(new thr(this));
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BaseChatPie))));
    b(paramNearbyFlowerMessage, paramInt);
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = paramOnFrameEndListener;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController$OnCleanAnimationListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController$OnCleanAnimationListener.a();
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController$OnCleanAnimationListener = null;
      }
      c();
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyFlowerAnimationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */