package com.tencent.mobileqq.structmsg.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.structmsg.StructMsgVideoController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlSerializer;
import uwv;
import uwy;
import uwz;
import uxa;
import uxd;
import uxe;

public class StructMsgItemVideo
  extends AbsStructMsgElement
{
  public static final String cK = "no_bg";
  public static final String cL = "TYPE";
  public static final String cM = "VINFO";
  public static final String cN = "TINFO";
  public static final String cO = "SUMMARY";
  public static final String cP = "PREVIEW_VIDEO_TIME";
  public static final String cQ = "PREVIEW_VIDEO_FILE_SIZE";
  public static final String cR = "PREVIEW_VIDEO_THIRD_UIN";
  public static final String cS = "PREVIEW_VIDEO_WIDTH";
  public static final String cT = "PREVIEW_VIDEO_HEIGHT";
  public static final String cU = "FULL_VIDEO_TIME";
  public static final String cV = "ACCOUNT_UIN";
  public static final String cW = "ACCOUNT_NAME";
  public static final String cX = "ARTICLE_ID";
  public static final String o = "structmsg.StructMsgItemVideo";
  public static final String p = "has_cnr";
  public static final String q = "v_height";
  public static final String r = "v_crap_ctn";
  public static final String u = "is_public_account_video_msg";
  public static final String v = "public_account_video_title";
  protected View.OnClickListener a;
  private URLDrawableDownListener.Adapter a;
  public uxe a;
  public boolean a;
  private View.OnClickListener b;
  public boolean b;
  public String cY;
  public String cZ;
  public String da;
  public String db;
  public String dc;
  public String dd;
  public String de;
  String df;
  String dg;
  String dh;
  String di;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public String s;
  public String t;
  
  public StructMsgItemVideo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.df = "";
    this.dg = "";
    this.dh = "";
    this.di = "";
    this.b = new uwv(this);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new uwy(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uxa(this);
    this.jdField_a_of_type_JavaLangString = "video";
  }
  
  public StructMsgItemVideo(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, String paramString7)
  {
    this.df = "";
    this.dg = "";
    this.dh = "";
    this.di = "";
    this.b = new uwv(this);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new uwy(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uxa(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.s = paramString1;
    this.n = paramInt1;
    this.cY = paramString2;
    this.cZ = paramString3;
    this.da = paramString4;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramInt4;
    this.m = paramInt5;
    this.db = paramString5;
    this.dc = paramString6;
    this.dd = paramString7;
  }
  
  public StructMsgItemVideo(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.df = "";
    this.dg = "";
    this.dh = "";
    this.di = "";
    this.b = new uwv(this);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new uwy(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uxa(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.s = paramString1;
    this.t = paramString2;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.i = i1;
      return;
    }
  }
  
  private void a(Context paramContext)
  {
    if ((TextUtils.isEmpty(b())) || ((!b().startsWith("http://")) && (!b().startsWith("https://")))) {}
    do
    {
      do
      {
        return;
        Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", b());
        PublicAccountUtil.a(localIntent, b());
        paramContext.startActivity(localIntent);
      } while (TextUtils.isEmpty(b()));
      paramContext = CGILoader.a(b());
    } while (TextUtils.isEmpty(paramContext));
    ReportController.b(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.i == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130838319);
      }
      if (this.jdField_a_of_type_Uxe == null) {
        this.jdField_a_of_type_Uxe = new uxe(this);
      }
      ThreadManager.a(new uwz(this, paramContext, paramView), 8, null, true);
      return;
    }
    a(paramContext, this.t);
  }
  
  private void a(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("file_send_path", paramString);
    localBundle.putInt("video_play_caller", 1);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    paramString = new Intent(paramContext, ShortVideoPlayActivity.class);
    paramString.putExtras(localBundle);
    paramContext.startActivity(paramString);
    if (!TextUtils.isEmpty(b()))
    {
      paramContext = CGILoader.a(b());
      if (!TextUtils.isEmpty(paramContext)) {
        ReportController.b(null, "CliOper", "", "", "0X8005F57", "0X8005F57", 0, 0, "", "", paramContext, "");
      }
    }
  }
  
  private String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (a())
    {
      localBundle.putBoolean("is_public_account_video_msg", true);
      this.jdField_a_of_type_Boolean = true;
      this.de = localBundle.getString("public_account_video_title");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasFlag(4)) {}
    for (boolean bool1 = true; !this.jdField_a_of_type_Boolean; bool1 = false) {
      return b(paramContext, paramView, localBundle);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_UIN") == null) {
        break label259;
      }
      this.db = localBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_NAME") == null) {
        break label279;
      }
    }
    Object localObject2;
    label259:
    label279:
    for (this.dc = localBundle.getString("VIDEO_PUB_ACCOUNT_NAME");; this.dc = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName))
    {
      this.df = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceIcon;
      this.dg = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName;
      this.dh = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceUrl;
      this.di = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceThirdName;
      localObject2 = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label299;
      }
      if (paramView.getTag(2131296577) != null)
      {
        paramContext = paramView.getTag(2131296577);
        if ((paramContext instanceof StructMsgItemVideo.Holder))
        {
          paramContext = (StructMsgItemVideo.Holder)paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): 复用Holder!!");
          }
        }
      }
      return null;
      this.db = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).source_puin);
      break;
    }
    label299:
    paramView = new RelativeLayout(paramContext);
    paramBundle = new PAVideoView(paramContext);
    paramBundle.setId(2131296577);
    label397:
    Object localObject1;
    int i1;
    Object localObject3;
    label558:
    Object localObject4;
    label633:
    int i2;
    int i3;
    if (bool1)
    {
      paramBundle.d = true;
      paramBundle.setRadius(15.0F);
      paramBundle.a(true);
      paramBundle.c(true);
      paramBundle.b = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
      if ((this.k == 0) || (this.l == 0) || (this.k > this.l)) {
        break label1264;
      }
      paramBundle.h = PAVideoView.g;
      paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramBundle.setContentDescription(((Resources)localObject2).getText(2131371169));
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      if (bool1)
      {
        ((RelativeLayout.LayoutParams)localObject1).width = -2;
        ((RelativeLayout.LayoutParams)localObject1).height = -2;
      }
      paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new ImageView(paramContext);
      ((ImageView)localObject1).setImageResource(2130839556);
      ((ImageView)localObject1).setVisibility(8);
      i1 = AIOUtils.a(62.0F, (Resources)localObject2);
      if (bool1) {
        i1 = AIOUtils.a(50.0F, (Resources)localObject2);
      }
      localObject3 = new RelativeLayout.LayoutParams(i1, i1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      if (bool1)
      {
        i1 = AIOUtils.a(10.0F, (Resources)localObject2) / 2;
        if (!paramBundle.b) {
          break label1274;
        }
        ((ImageView)localObject1).setPadding(0, 0, i1, 0);
      }
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new RelativeLayout(paramContext);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131296577);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131296577);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131296577);
      if (!bool1) {
        break label1287;
      }
      i1 = AIOUtils.a(7.0F, (Resources)localObject2);
      if (!bool1) {
        break label1407;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend()) {
        break label1300;
      }
      i2 = AIOUtils.a(10.0F, (Resources)localObject2) + i1;
      i3 = i1;
    }
    for (;;)
    {
      label668:
      ((RelativeLayout)localObject3).setPadding(i3, i1, i2, i1);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(paramContext);
      ((TextView)localObject4).setId(2131296581);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setSingleLine(true);
      label741:
      label769:
      Object localObject5;
      label849:
      boolean bool2;
      if (bool1)
      {
        ((TextView)localObject4).setTextSize(1, 14.0F);
        i1 = 0;
        if (!bool1) {
          break label1355;
        }
        if (paramBundle.h != PAVideoView.f) {
          break label1332;
        }
        i1 = AIOUtils.a(180.0F, (Resources)localObject2);
        ((TextView)localObject4).setMaxWidth(i1);
        localObject5 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject5).addRule(9);
        ((RelativeLayout.LayoutParams)localObject5).addRule(12);
        ((RelativeLayout.LayoutParams)localObject5).rightMargin = AIOUtils.a(7.0F, (Resources)localObject2);
        ((RelativeLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        localObject2 = new TextView(paramContext);
        if (!bool1) {
          break label1368;
        }
        ((TextView)localObject2).setTextSize(1, 12.0F);
        ((TextView)localObject2).setTextColor(-1);
        localObject5 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject5).addRule(12);
        ((RelativeLayout.LayoutParams)localObject5).addRule(11);
        ((RelativeLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject5);
        localObject5 = new StructMsgItemVideo.Holder();
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView = paramBundle;
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
        ((StructMsgItemVideo.Holder)localObject5).b = ((TextView)localObject2);
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidViewView = ((View)localObject3);
        paramView.setTag(2131296577, localObject5);
        paramView.setTag(this);
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(this);
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidViewView, ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_AndroidWidgetImageView);
        paramBundle = StructMsgVideoController.a();
        bool2 = paramBundle.e;
        boolean bool3 = paramBundle.a();
        boolean bool4 = paramBundle.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.uniseq);
        boolean bool5 = paramBundle.d;
        if (QLog.isColorLevel()) {
          QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): convertView=" + paramView + ", args = " + localBundle.toString() + "\n, hasHeadIcon = " + bool1 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq + "\n, scrollIdle = " + bool2 + "\n, dpcAllow = " + bool3 + "\n, autoPlay = " + bool4 + "\n, aioShowed = " + bool5 + ", vid = " + this.cY);
        }
        if ((bool5) && (bool3) && (bool4)) {
          break label1380;
        }
        ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a();
      }
      for (;;)
      {
        if (this.j > 0) {
          ((StructMsgItemVideo.Holder)localObject5).b.setText(ShortVideoUtils.a(this.j * 1000));
        }
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        }
        return paramView;
        paramBundle.setRadius(5.0F);
        paramBundle.d = false;
        paramBundle.a(true);
        paramBundle.c(false);
        break;
        label1264:
        paramBundle.h = PAVideoView.f;
        break label397;
        label1274:
        ((ImageView)localObject1).setPadding(i1, 0, 0, 0);
        break label558;
        label1287:
        i1 = AIOUtils.a(12.0F, (Resources)localObject2);
        break label633;
        label1300:
        i3 = AIOUtils.a(10.0F, (Resources)localObject2) + i1;
        i2 = i1;
        break label668;
        ((TextView)localObject4).setTextSize(1, 19.0F);
        break label741;
        label1332:
        if (paramBundle.h != PAVideoView.g) {
          break label769;
        }
        i1 = AIOUtils.a(140.0F, (Resources)localObject2);
        break label769;
        label1355:
        i1 = AIOUtils.a(260.0F, (Resources)localObject2);
        break label769;
        label1368:
        ((TextView)localObject2).setTextSize(1, 14.0F);
        break label849;
        label1380:
        if (bool2) {
          ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.c();
        } else {
          ((StructMsgItemVideo.Holder)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.b();
        }
      }
      label1407:
      i2 = i1;
      i3 = i1;
    }
  }
  
  public String a()
  {
    return "video";
  }
  
  public void a(Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, long paramLong)
  {
    if ((paramContext == null) || (paramStructMsgForGeneralShare == null)) {
      return;
    }
    String str;
    Bundle localBundle;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)((BaseApplicationImpl)paramContext.getApplicationContext()).getAppRuntime(paramStructMsgForGeneralShare.currentAccountUin);
      if ((localQQAppInterface != null) && (localQQAppInterface.d()))
      {
        QQToast.a(paramContext, 2131363475, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("structmsg.StructMsgItemVideo", 2, "enterFullScreenActivity():", localException);
        }
        str = null;
      }
      localBundle = new Bundle();
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.db);
      if (this.n <= 1) {
        break label650;
      }
    }
    localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.di);
    label130:
    localBundle.putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl);
    if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime)) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1))
    {
      str = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));
      label189:
      localBundle.putString("VIDEO_CREATE_TIME", str);
      localBundle.putString("VIDEO_TIME", String.valueOf(this.m));
      localBundle.putString("VIDEO_WIDTH", String.valueOf(this.k));
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.l));
      localBundle.putString("VIDEO_VID", this.cZ);
      localBundle.putString("VIDEO_COVER", this.s);
      localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
      localBundle.putString("VIDEO_ARTICLE_ID", this.dd);
      localBundle.putString("VIDEO_TITLE", this.de);
      if ((this.n != 2) && (this.n != 3)) {
        break label674;
      }
    }
    label650:
    label674:
    for (boolean bool = false;; bool = true)
    {
      localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", this.n);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "0X8006830", "0X8006830", 0, 0, this.cY, "" + this.n, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "");
      if (!bool)
      {
        localBundle.putString("VIDEO_THIRD_ICON", this.df);
        localBundle.putString("VIDEO_THIRD_NAME", this.dg);
        localBundle.putString("VIDEO_THIRD_ACTION", this.dh);
        if (this.n == 2)
        {
          ThirdVidoeManager.a();
          localBundle.putString("VIDEO_THIRD_URL", ThirdVidoeManager.a(this.cZ));
        }
      }
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "0X8006830", "0X8006830", 0, 0, this.cY, "" + this.n, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "");
      localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
      localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
      paramStructMsgForGeneralShare = new Intent(paramContext, MultiVideoPlayActivity.class);
      paramStructMsgForGeneralShare.putExtras(localBundle);
      if (!(paramContext instanceof Activity)) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(paramStructMsgForGeneralShare, 13005);
      ((Activity)paramContext).overridePendingTransition(2130968620, 2130968621);
      return;
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.dc);
      break label130;
      str = paramStructMsgForGeneralShare.mCreateTime;
      break label189;
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.s = paramObjectInput.readUTF();
    this.t = paramObjectInput.readUTF();
    String str = paramObjectInput.readUTF();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.i = Integer.parseInt(str);
      if (this.e >= 7)
      {
        this.cY = paramObjectInput.readUTF();
        this.cZ = paramObjectInput.readUTF();
        this.j = paramObjectInput.readInt();
        this.k = paramObjectInput.readInt();
        this.l = paramObjectInput.readInt();
        this.m = paramObjectInput.readInt();
        this.da = paramObjectInput.readUTF();
        this.n = paramObjectInput.readInt();
      }
      if (this.e >= 8) {
        this.dd = paramObjectInput.readUTF();
      }
      if (QLog.isColorLevel())
      {
        paramObjectInput = new StringBuilder();
        paramObjectInput.append("readExternal[:").append("\n");
        paramObjectInput.append("mVersion:").append(this.e).append("\n");
        paramObjectInput.append("imgUrl:").append(this.s).append("\n");
        paramObjectInput.append("videoUrl:").append(this.t).append("\n");
        paramObjectInput.append("vInfo:").append(this.cY).append("\n");
        paramObjectInput.append("tInfo:").append(this.cZ).append("\n");
        paramObjectInput.append("previewVideoTime:").append(this.j).append("\n");
        paramObjectInput.append("previewVideoWidth:").append(this.k).append("\n");
        paramObjectInput.append("previewVideoHeight:").append(this.l).append("\n");
        paramObjectInput.append("type:").append(this.n).append("\n");
        paramObjectInput.append("articleID").append(this.dd).append("\n");
        paramObjectInput.append("]:").append("\n");
        QLog.d("structmsg.StructMsgItemVideo", 2, paramObjectInput.toString());
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        this.i = 0;
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.s != null)
    {
      str = this.s;
      paramObjectOutput.writeUTF(str);
      if (this.t == null) {
        break label204;
      }
      str = this.t;
      label36:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeUTF(this.i + "");
      if (this.cY == null) {
        break label210;
      }
      str = this.cY;
      label83:
      paramObjectOutput.writeUTF(str);
      if (this.cZ == null) {
        break label216;
      }
      str = this.cZ;
      label102:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.j);
      paramObjectOutput.writeInt(this.k);
      paramObjectOutput.writeInt(this.l);
      paramObjectOutput.writeInt(this.m);
      if (this.da == null) {
        break label222;
      }
      str = this.da;
      label161:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.n);
      if (this.dd == null) {
        break label228;
      }
    }
    label204:
    label210:
    label216:
    label222:
    label228:
    for (String str = this.dd;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label83;
      str = "";
      break label102;
      str = "";
      break label161;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "video");
    if (!TextUtils.isEmpty(this.s)) {
      paramXmlSerializer.attribute(null, "cover", this.s);
    }
    if (!TextUtils.isEmpty(this.t)) {
      paramXmlSerializer.attribute(null, "src", this.t);
    }
    if (!TextUtils.isEmpty(this.cY)) {
      paramXmlSerializer.attribute(null, "vInfo", this.cY);
    }
    if (!TextUtils.isEmpty(this.cZ)) {
      paramXmlSerializer.attribute(null, "tInfo", this.cZ);
    }
    paramXmlSerializer.attribute(null, "preTime", String.valueOf(this.j));
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.k));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.l));
    paramXmlSerializer.attribute(null, "fullTime", String.valueOf(this.m));
    if (!TextUtils.isEmpty(this.da)) {
      paramXmlSerializer.attribute(null, "summary", this.da);
    }
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.n));
    if (!TextUtils.isEmpty(this.dd)) {
      paramXmlSerializer.attribute(null, "aID", this.dd);
    }
    if (this.i == 1) {
      paramXmlSerializer.attribute(null, "load", this.i + "");
    }
    paramXmlSerializer.endTag(null, "video");
  }
  
  public boolean a()
  {
    return (this.n >= 1) && (this.n <= 100);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.s = paramStructMsgNode.a("cover");
    this.t = paramStructMsgNode.a("src");
    String str1 = paramStructMsgNode.a("load");
    this.cY = paramStructMsgNode.a("vInfo");
    this.cZ = paramStructMsgNode.a("tInfo");
    String str2 = paramStructMsgNode.a("preTime");
    if (str2 != null) {}
    try
    {
      this.j = Integer.valueOf(str2).intValue();
      str2 = paramStructMsgNode.a("preWidth");
      if (str2 == null) {}
    }
    catch (Exception localRuntimeException)
    {
      try
      {
        for (;;)
        {
          this.k = Integer.valueOf(str2).intValue();
          str2 = paramStructMsgNode.a("preHeight");
          if (str2 != null) {}
          try
          {
            this.l = Integer.valueOf(str2).intValue();
            str2 = paramStructMsgNode.a("fullTime");
            if (str2 != null) {}
            try
            {
              this.m = Integer.valueOf(str2).intValue();
              this.da = paramStructMsgNode.a("summary");
              if (!TextUtils.isEmpty(str1)) {}
              try
              {
                this.i = Integer.parseInt(str1);
                str1 = paramStructMsgNode.a("busiType");
                if (TextUtils.isEmpty(str1)) {}
              }
              catch (RuntimeException localRuntimeException)
              {
                try
                {
                  this.n = Integer.parseInt(str1);
                  this.dd = paramStructMsgNode.a("aID");
                  return true;
                  localException6 = localException6;
                  try
                  {
                    this.j = ((int)Float.valueOf(str2).floatValue());
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewVideoTimeStr: previewVideoTime = " + this.j);
                  }
                  catch (Exception localException2) {}
                  continue;
                  localRuntimeException = localRuntimeException;
                  this.i = 0;
                }
                catch (Exception localException1)
                {
                  for (;;) {}
                }
              }
            }
            catch (Exception localException3)
            {
              for (;;) {}
            }
          }
          catch (Exception localException4)
          {
            for (;;) {}
          }
        }
      }
      catch (Exception localException5)
      {
        for (;;) {}
      }
    }
  }
  
  protected View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject1 = paramContext.getResources();
    if (paramBundle.getBoolean("has_cnr")) {}
    for (int i1 = AIOUtils.a(12.0F, (Resources)localObject1);; i1 = 0)
    {
      ((Resources)localObject1).getDisplayMetrics();
      int i2 = paramBundle.getInt("v_height");
      Object localObject2;
      if ((paramView != null) && ((paramView instanceof TitledImageView)))
      {
        localObject2 = (TitledImageView)paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      for (;;)
      {
        paramView.setImageResource(2130840871);
        paramView.setTag(this);
        try
        {
          localObject2 = new RoundedColorDrawable(-16777216, i2, i2, i1);
          if (TextUtils.isEmpty(this.s))
          {
            paramView.setBackgroundDrawable((Drawable)localObject2);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            paramView.setOnClickListener(this.b);
            paramView.setOnClickListener(this.b);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            return (View)localObject1;
            paramView = new TitledImageView(paramContext);
            paramView.setId(2131296359);
            paramView.setContentDescription(((Resources)localObject1).getString(2131367318));
            paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramView.setContentDescription(((Resources)localObject1).getText(2131371169));
            localObject1 = paramView;
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            Object localObject3 = null;
            continue;
            localObject3 = URLDrawable.getDrawable(this.s, i2, i2, (Drawable)localObject3, (Drawable)localObject3);
            if (paramBundle.getBoolean("has_cnr")) {
              ((URLDrawable)localObject3).setDecodeHandler(new uxd(this, i1, i2, i2));
            }
            if ((AbsDownloader.a(this.s)) || (!URLDrawableHelper.a(paramContext))) {
              bool = true;
            }
            ((URLDrawable)localObject3).setAutoDownload(bool);
            if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1))
            {
              paramView.setBackgroundDrawable((Drawable)localObject3);
            }
            else
            {
              paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
              paramView.setBackgroundDrawable((Drawable)localObject3);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */