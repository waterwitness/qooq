package com.tencent.mobileqq.troopgift;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.ImageButton.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.SpriteSurfaceView;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import vuy;
import vvb;
import vvc;
import vvd;
import vvf;
import vvm;

public class TroopGiftAnimationController
  implements View.OnClickListener, TopGestureLayout.OnGestureListener
{
  public static final String a = "/avatar/avatar_anim_res.png";
  public static final String b = TroopGiftAnimationController.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Handler a;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public TopGestureLayout a;
  private MessageForDeliverGiftTips jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
  private ActionGlobalData jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
  private FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener;
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton$OnClickListener = new vvc(this);
  public SpriteSurfaceView a;
  private TroopGiftCallback jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback = new vvb(this);
  public GiftBitmapAnimaionCache a;
  public TroopGiftAnimationController.OnCleanAnimationListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new vuy(this);
  private vvm jdField_a_of_type_Vvm;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopGiftAnimationController(BaseChatPie paramBaseChatPie, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return (Bitmap)localObject;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "initMagicfaceView begins");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      if (!paramBoolean) {
        break label101;
      }
    }
    label101:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2130903936, null));; this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2130903935, null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView = ((SpriteSurfaceView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131300739));
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView instanceof SendFlowerSurfaceView))
      {
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131300740));
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      return;
    }
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener = null;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll())) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        str = "0";
        ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_close", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + TroopMemberUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips == null) {
      for (;;)
      {
        b();
        return;
        str = "1";
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (String str = "0";; str = "1")
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "video_mall", "Clk_comctn_close", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + TroopMemberUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
      break;
    }
  }
  
  public void a(int paramInt, ActionGlobalData paramActionGlobalData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "startSendGiftHeadAnimation");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView == null);
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "创建头像时间 = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "sendFlowerSurfaceView show");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView instanceof SendFlowerSurfaceView))
    {
      ((SendFlowerSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView).a(new vvd(this));
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll()) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationBrief, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.giftCount, paramInt, paramActionGlobalData);
      }
    }
    label145:
    while (QLog.isColorLevel())
    {
      QLog.d(b, 2, "endstartSendGiftHeadAnimation");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView instanceof TroopGiftToAllSurfaceView))
      {
        this.jdField_a_of_type_Vvm = new vvm(this);
        ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView).a(this.jdField_a_of_type_Vvm);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
        for (String str = "0";; str = "1")
        {
          ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "exp_anime", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + TroopMemberUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
          if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton) {
            break label456;
          }
          ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton$OnClickListener);
          ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "exp_grab", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + TroopMemberUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
          break;
        }
        label456:
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultType != 0) {
          break label502;
        }
      }
    }
    label502:
    for (paramInt = paramActionGlobalData.l;; paramInt = paramActionGlobalData.m)
    {
      ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultText, paramInt, DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F));
      break label145;
      break;
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "play TroopGiftAnimation Start,packageId:" + TroopGiftUtil.a(paramMessageForDeliverGiftTips));
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips = paramMessageForDeliverGiftTips;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "find troopAnimationLayout");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = new Emoticon();
        ((Emoticon)localObject).epId = TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = MagicfaceActionManager.a((Emoticon)localObject, 1, 2);
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "find actionGlobaData");
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener == null);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener.a();
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = null;
      return;
      if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
        this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache = new GiftBitmapAnimaionCache();
      }
      localObject = TroopGiftUtil.a(TroopGiftUtil.a(paramMessageForDeliverGiftTips));
      if (!TroopGiftUtil.a((List)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(b, 2, "filePaths null");
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.a((List)localObject, this.jdField_a_of_type_AndroidOsHandler, TroopGiftUtil.a(paramMessageForDeliverGiftTips));
    a(paramMessageForDeliverGiftTips.isToAll());
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView.setVisibility(0);
    ThreadManager.a(new vvf(this, paramMessageForDeliverGiftTips), 8, null, true);
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = paramOnFrameEndListener;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ActionGlobalData paramActionGlobalData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "startSendFlowerTip");
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 <= 0)) {}
    for (;;)
    {
      return;
      String str = "×" + paramInt1;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      if ((paramActionGlobalData == null) || (paramActionGlobalData.e))
      {
        localSpannableStringBuilder.append(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length() + str.length(), 18);
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(DisplayUtil.c(this.jdField_a_of_type_AndroidAppActivity, 17.0F)), paramString.length(), paramString.length() + 1, 18);
        AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(DisplayUtil.c(this.jdField_a_of_type_AndroidAppActivity, 19.0F));
        paramInt1 = paramString.length();
        int i = paramString.length();
        localSpannableStringBuilder.setSpan(localAbsoluteSizeSpan, paramInt1 + 1, str.length() + i, 18);
        label204:
        if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
        }
        paramString = new RelativeLayout.LayoutParams(-2, (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493587));
        paramString.addRule(14);
        paramString.setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), paramInt2, DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), 0);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          break label554;
        }
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 15.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840201);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131427407));
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaddingTop(), DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaddingBottom());
        label420:
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramString);
        if (paramActionGlobalData == null) {
          break label565;
        }
      }
      try
      {
        if (paramActionGlobalData.o != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.getBackground().setColorFilter(new LightingColorFilter(-16777216, Color.parseColor(paramActionGlobalData.o)));
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(b, 2, "startSendFlowerTip Success");
          return;
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length(), 18);
          break label204;
          label554:
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
          break label420;
          label565:
          this.jdField_a_of_type_AndroidWidgetTextView.getBackground().setColorFilter(null);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(".troop.send_gift", 2, "parse detail strip bg clor failed. Color value is " + paramActionGlobalData.o, paramString);
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView = null;
      this.jdField_a_of_type_Vvm = null;
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = false;
        ReportController.b(null, "P_CliOper", "BizTechReport", "troop_gift_animation", "", "play_success", 0, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), "", "");
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
          QLog.e(".troop.send_gift", 2, "closeGiftAnimation exception ", localException);
        }
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "dimissSendFlowerTip");
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView.a();
    }
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {
      ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).aG();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopgift\TroopGiftAnimationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */