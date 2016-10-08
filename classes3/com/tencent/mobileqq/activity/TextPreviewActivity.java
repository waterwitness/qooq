package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.WordMatcher;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.NoSelLinkMovementMethod;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import moq;
import mor;
import mos;
import mot;

public class TextPreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 16;
  public static final String a = "uin_type";
  public static final boolean a = true;
  static final int jdField_b_of_type_Int = 17;
  public static long b = 0L;
  public static final String b = "content";
  public static final String c = "uniseq";
  public static final String d = "peeruin";
  public static final String e = "senderuin";
  public static final String f = "bubbleId";
  public static final String g = "pendantId";
  public static final String h = "fontId";
  public static final String i = "scrollToBubble";
  public static final String j = "fromAIO";
  public static final String k = "real_msg_sender_uin";
  private static final String p = "我正在使用的装扮";
  private static final String q = "TA正在使用的装扮";
  protected long a;
  Context jdField_a_of_type_AndroidContentContext;
  protected Rect a;
  public Handler a;
  protected MotionEvent a;
  protected View a;
  public ImageView a;
  protected TextView a;
  public FontManager a;
  protected URLImageView a;
  public WordMatchManager.MatchCallback a;
  WordMatchManager.MatcherCallback jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback;
  public WordMatchManager.WordMatcher a;
  ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  public QQText a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  protected DownloaderFactory a;
  public ContainerView a;
  protected ScrollView a;
  protected View b;
  protected TextView b;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  protected long c;
  protected View c;
  protected int d;
  protected View d;
  public int e;
  protected View e;
  public int f;
  protected View f;
  public String l;
  protected String m;
  protected String n;
  public String o;
  
  public TextPreviewActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTextQQText = null;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback = new mor(this);
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback = new mos(this);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new mot(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  }
  
  private void a()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    BubbleManager localBubbleManager = (BubbleManager)this.app.getManager(43);
    Object localObject2 = localBubbleManager.a(this.jdField_d_of_type_Int, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = BubbleUtils.a;
    }
    boolean bool;
    int i1;
    if (!this.m.equals(this.app.getAccount()))
    {
      bool = false;
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, false);
      localObject2 = localBubbleManager.a(this.jdField_d_of_type_Int, true);
      i1 = Color.parseColor("#808080");
      localObject1 = new File(((BubbleInfo)localObject1).a);
      if ((localObject2 == null) || (!((File)localObject1).exists())) {
        break label467;
      }
      localObject1 = ((BubbleConfig)localObject2).n;
      i1 = ((BubbleConfig)localObject2).b;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i1);
      ((ImageView)super.findViewById(2131297019)).setImageDrawable(FaceDrawable.a(this.app, 1, this.n));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
      {
        localObject1 = ((AvatarPendantManager)this.app.getManager(45)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
        if (AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId))
        {
          ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.m);
          label238:
          this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = ((FontManager)this.app.getManager(41));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297029));
          if (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager == null) {
            break label461;
          }
        }
      }
      label461:
      for (bool = this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a;; bool = false)
      {
        if (!bool)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          localObject1 = AnimationUtils.loadAnimation(this, 2130968813);
          this.jdField_d_of_type_AndroidViewView.startAnimation((Animation)localObject1);
          return;
          bool = true;
          break;
          ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.m);
          break label238;
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
          break label238;
        }
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) {
          this.jdField_e_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uVipFont);
        }
        if (this.jdField_e_of_type_Int == 0) {}
        for (localObject1 = getResources().getDrawable(2130841661);; localObject1 = this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.jdField_e_of_type_Int))
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            a(this.jdField_e_of_type_Int);
            localObject2 = getResources().getDrawable(2130841661);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          break;
        }
      }
      label467:
      localObject1 = "默认气泡";
    }
  }
  
  public static void a(String paramString1, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString2 = paramQQAppInterface.a().a(paramString2, paramInt, paramLong);
    } while (paramString2 == null);
    if ((paramBoolean) && (((paramString2 instanceof MessageForMixedMsg)) || ((paramString2 instanceof MessageForLongMsg))))
    {
      QfavBuilder.b(paramString2).b(paramQQAppInterface, paramString2).a(paramActivity, paramQQAppInterface.getAccount());
      QfavReport.a(paramQQAppInterface, 66, 8);
      return;
    }
    QfavBuilder.a(null, paramString1).b(paramQQAppInterface, paramString2).a(paramActivity, paramQQAppInterface.getAccount());
    QfavReport.a(paramQQAppInterface, 66, 1);
  }
  
  void a(int paramInt)
  {
    File localFile = new File(FontManager.b + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    Object localObject2 = IndividuationUrlHelper.a("fontAioImg");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("[id]", Integer.toString(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "getFontInfo fontId=" + paramInt + " will down " + ",file path=" + localFile.getAbsolutePath());
    }
    localObject2 = new Bundle();
    localObject1 = new DownloadTask((String)localObject1, localFile);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
  }
  
  protected boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.jdField_a_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
    this.jdField_a_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView.right += arrayOfInt[0];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    int i1 = paramView.bottom;
    paramView.bottom = (arrayOfInt[1] + i1);
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (a(this.jdField_d_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label90;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a()) {
        break label82;
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label82:
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
      continue;
      label90:
      if ((this.jdField_a_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 1)) {
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
        {
          int i1 = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getX() - (int)paramMotionEvent.getX();
          int i2 = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getY() - (int)paramMotionEvent.getY();
          if ((i1 * i1 + i2 * i2 < 10000) && (paramMotionEvent.getEventTime() - this.jdField_a_of_type_AndroidViewMotionEvent.getEventTime() < 200L))
          {
            this.jdField_a_of_type_AndroidViewMotionEvent = null;
            finish();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setLayerType(0, null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetScrollView != null) {
        this.jdField_a_of_type_ComTencentWidgetScrollView.setLayerType(0, null);
      }
    }
    WordMatchManager localWordMatchManager = (WordMatchManager)this.app.getManager(81);
    if (localWordMatchManager != null) {
      localWordMatchManager.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher != null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(this.jdField_f_of_type_Int);
    }
  }
  
  public void finish()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (this.o != null) {}
    for (int i1 = this.o.length();; i1 = 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(i1), "", "");
      super.finish();
      overridePendingTransition(0, 2130968595);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    boolean bool;
    if (l1 - this.jdField_c_of_type_Long > 500L)
    {
      this.jdField_c_of_type_Long = l1;
      i1 = paramView.getId();
      if (i1 != 2131297023) {
        break label478;
      }
      paramView = (GameCenterManagerImp)this.app.getManager(11);
      if (paramView == null) {
        break label1222;
      }
      if (paramView.a("100005.100003") == -1) {
        break label426;
      }
      bool = true;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("scrollToBubble", true);
      localIntent.putExtra("individuation_url_type", 40301);
      VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "bubbleDetail", String.valueOf(this.jdField_d_of_type_Int), "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, localIntent, false, -1);
      int i2;
      label155:
      int i3;
      label169:
      int i4;
      label183:
      int i5;
      label197:
      int i6;
      label211:
      int i7;
      if (bool)
      {
        if (paramView.a("100005.100001") == -1) {
          break label432;
        }
        i2 = 1;
        if (paramView.a("100005.100002") == -1) {
          break label438;
        }
        i3 = 1;
        if (paramView.a("100005.100006") == -1) {
          break label444;
        }
        i4 = 1;
        if (paramView.a("100005.100018") == -1) {
          break label450;
        }
        i5 = 1;
        if (paramView.a("100005.100020") == -1) {
          break label456;
        }
        i6 = 1;
        if (paramView.a("100005.100021") == -1) {
          break label462;
        }
        i7 = 1;
        label225:
        bool = ((FontManager)this.app.getManager(41)).a;
        i1 = 0;
        if (bool)
        {
          if (paramView.a("100005.100011") == -1) {
            break label468;
          }
          i1 = 1;
        }
        label262:
        if (((bool) && (i2 == 0) && (i3 == 0) && (i4 == 0) && (i1 == 0) && (i5 == 0) && (i6 == 0) && (i7 == 0)) || ((!bool) && (i2 == 0) && (i3 == 0) && (i4 == 0) && (i5 == 0) && (i6 == 0) && (i7 == 0))) {
          if (paramView.a("100005") == -1) {
            break label473;
          }
        }
      }
      label426:
      label432:
      label438:
      label444:
      label450:
      label456:
      label462:
      label468:
      label473:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          ((RedTouchManager)this.app.getManager(35)).b("100005");
        }
        ((RedTouchManager)this.app.getManager(35)).b("100005.100003");
        ReportController.b(this.app, "CliOper", "", "", "BigTextPage", "bubble_enter", 0, 0, "", "", "", "");
        return;
        bool = false;
        break;
        i2 = 0;
        break label155;
        i3 = 0;
        break label169;
        i4 = 0;
        break label183;
        i5 = 0;
        break label197;
        i6 = 0;
        break label211;
        i7 = 0;
        break label225;
        i1 = 0;
        break label262;
      }
      label478:
      if (i1 == 2131297028)
      {
        paramView = (GameCenterManagerImp)this.app.getManager(11);
        if (paramView == null) {
          break label1216;
        }
        if (paramView.a("100005.100011") != -1) {
          bool = true;
        }
      }
      for (;;)
      {
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("updateFlag", bool);
        localIntent.putExtra("fontId", this.jdField_e_of_type_Int);
        localIntent.putExtra("fromAIO", true);
        localIntent.putExtra("individuation_url_type", 40301);
        VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "fontDetail", String.valueOf(this.jdField_e_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, localIntent, false, -1);
        if (bool)
        {
          if (paramView.a("100005.100001") == -1) {
            break label770;
          }
          i1 = 1;
          label613:
          if (paramView.a("100005.100002") == -1) {
            break label775;
          }
          i2 = 1;
          label627:
          if (paramView.a("100005.100006") == -1) {
            break label781;
          }
          i3 = 1;
          label641:
          if (paramView.a("100005.100003") == -1) {
            break label787;
          }
          i4 = 1;
          label655:
          if ((i1 == 0) && (i2 == 0) && (i3 == 0) && (i4 == 0)) {
            if (paramView.a("100005") == -1) {
              break label793;
            }
          }
        }
        label770:
        label775:
        label781:
        label787:
        label793:
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            ((RedTouchManager)this.app.getManager(35)).b("100005");
          }
          ((RedTouchManager)this.app.getManager(35)).b("100005.100011");
          ReportController.b(this.app, "CliOper", "", "", "BigTextPage", "font_enter", 0, 0, "", "", "", "");
          return;
          bool = false;
          break;
          i1 = 0;
          break label613;
          i2 = 0;
          break label627;
          i3 = 0;
          break label641;
          i4 = 0;
          break label655;
        }
        if (i1 != 2131297018) {
          break;
        }
        paramView = (GameCenterManagerImp)this.app.getManager(11);
        if (paramView != null) {
          if (paramView.a("100005.100006") != -1) {
            i1 = 1;
          }
        }
        for (;;)
        {
          localIntent = new Intent(this, AvatarPendantMarketActivity.class);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
          {
            l1 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
            label892:
            localIntent.putExtra("url", IndividuationUrlHelper.a(this, "pendantDetail", String.valueOf(l1), "mvip.gexinghua.mobile.faceaddon.client_tab_store"));
            localIntent.putExtra("business", 512L);
            localIntent.putExtra("individuation_url_type", 40301);
            localIntent.putExtra("isShowAd", false);
            VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "pendantDetail", String.valueOf(l1), "mvip.gexinghua.mobile.faceaddon.client_tab_store"), 512L, localIntent, false, -1);
            ReportController.b(null, "CliOper", "", "", "PendantMarket", "AIOPreviewEntrance", 0, 0, "", "", "", "");
            if (i1 != 0)
            {
              if (paramView.a("100005.100001") == -1) {
                break label1183;
              }
              i1 = 1;
              label1021:
              if (paramView.a("100005.100002") == -1) {
                break label1188;
              }
              i2 = 1;
              label1035:
              if (paramView.a("100005.100006") == -1) {
                break label1194;
              }
              i3 = 1;
              label1049:
              if (paramView.a("100005.100003") == -1) {
                break label1200;
              }
              i4 = 1;
              label1063:
              if ((i1 == 0) && (i2 == 0) && (i3 == 0) && (i4 == 0)) {
                if (paramView.a("100005") == -1) {
                  break label1206;
                }
              }
            }
          }
          label1183:
          label1188:
          label1194:
          label1200:
          label1206:
          for (i1 = 1;; i1 = 0)
          {
            if (i1 != 0) {
              ((RedTouchManager)this.app.getManager(35)).b("100005");
            }
            ((RedTouchManager)this.app.getManager(35)).b("100005.100011");
            ReportController.b(this.app, "CliOper", "", "", "BigTextPage", "pendant_enter", 0, 0, "", "", "", "");
            return;
            i1 = 0;
            break;
            l1 = 0L;
            break label892;
            i1 = 0;
            break label1021;
            i2 = 0;
            break label1035;
            i3 = 0;
            break label1049;
            i4 = 0;
            break label1063;
          }
          i1 = 0;
        }
        label1216:
        bool = false;
      }
      label1222:
      bool = false;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    if ((this.app == null) && ((getAppRuntime() instanceof QQAppInterface))) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "TextPreviewActivity onCreate,  the app is null");
      }
      finish();
    }
    do
    {
      return;
      super.setContentView(2130903087);
      paramBundle = super.getIntent();
      this.l = paramBundle.getStringExtra("peeruin");
      this.m = paramBundle.getStringExtra("senderuin");
      this.n = paramBundle.getStringExtra("real_msg_sender_uin");
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("uin_type", 0);
      this.jdField_d_of_type_Int = ((int)paramBundle.getLongExtra("bubbleId", 0L));
      this.o = paramBundle.getStringExtra("content");
      this.jdField_e_of_type_AndroidViewView = super.findViewById(2131297022);
      this.jdField_f_of_type_AndroidViewView = super.findViewById(2131297027);
      long l1 = paramBundle.getLongExtra("uniseq", 0L);
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = ((FriendsManager)this.app.getManager(50)).a(this.n);
      this.jdField_a_of_type_AndroidOsHandler = new moq(this, Looper.getMainLooper());
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)this.app.getManager(46));
      if (jdField_b_of_type_Long != l1)
      {
        ContainerView.jdField_a_of_type_Float = 0.0F;
        jdField_b_of_type_Long = l1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)super.findViewById(2131297013));
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMsgHandler(this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)super.findViewById(2131297012));
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setOutScrollView(this.jdField_a_of_type_ComTencentWidgetScrollView);
      this.jdField_d_of_type_AndroidViewView = super.findViewById(2131297016);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297018);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297028);
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131297023);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297024));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297026));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131297020));
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      paramBundle = (TextView)super.findViewById(2131297017);
    } while (TextUtils.isEmpty(this.m));
    if (!this.m.equals(this.app.getAccount())) {
      paramBundle.setText("TA正在使用的装扮");
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setLayerType(1, null);
        this.jdField_a_of_type_ComTencentWidgetScrollView.setLayerType(1, null);
      }
      paramBundle = new QQText(this.o, 13, 32, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.setMovementMethod(ContainerView.NoSelLinkMovementMethod.a());
      paramBundle = (WordMatchManager)this.app.getManager(81);
      if (paramBundle == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher == null) {
        break;
      }
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(1, this.o, 3, this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
      return;
      paramBundle.setText("我正在使用的装扮");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
    if (this.app != null)
    {
      WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(12);
      if (localWebProcessManager != null) {
        localWebProcessManager.e();
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TextPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */