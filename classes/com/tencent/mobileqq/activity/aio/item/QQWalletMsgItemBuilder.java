package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.widget.EllipseTextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import nnp;
import nnq;
import nnr;
import nns;
import nnt;
import nnu;
import nnv;
import org.json.JSONObject;

public class QQWalletMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static int R;
  private static int S;
  private static int T;
  protected int A;
  protected int B;
  protected int C;
  public int D;
  protected int E;
  protected int F;
  protected int G;
  protected int H;
  protected int I;
  protected int J;
  protected int K;
  protected int L;
  protected int M;
  protected int N;
  protected int O;
  protected int P;
  protected int Q;
  public long a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public RelativeLayout a;
  public BaseChatPie a;
  private IndividualRedPacketManager jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
  private View.OnClickListener b;
  protected final String b;
  private View.OnClickListener c;
  protected final String c;
  protected final String d;
  protected String e;
  protected final int h;
  protected final int i;
  protected final int j;
  protected final int k;
  protected final int l;
  protected final int m;
  protected final int n;
  protected final int o;
  protected final int p;
  protected final int q;
  protected final int r;
  protected final int s;
  protected final int t;
  protected final int u;
  protected final int v;
  protected final int w;
  protected final int x;
  protected final int y;
  protected int z;
  
  public QQWalletMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = 2131303299;
    this.i = 2131303301;
    this.j = 2131303280;
    this.k = 2131303285;
    this.l = 2131303286;
    this.m = 2131303282;
    this.n = 2131303279;
    this.o = 2131303185;
    this.p = 2131303184;
    this.q = 2131303189;
    this.r = 2131303186;
    this.s = 2131303191;
    this.t = 2131303188;
    this.u = 2131303190;
    this.v = 2131303277;
    this.w = 2131303182;
    this.x = 2131303181;
    this.y = 2131303180;
    this.jdField_b_of_type_JavaLangString = "TRANSFER";
    this.jdField_c_of_type_JavaLangString = "REDPACKET";
    this.d = "PASSWORD";
    this.e = "";
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nnq(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new nnt(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new nnu(this);
    this.e = paramContext.getString(2131366514);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.A = ((int)(42.0F * f + 0.5F));
    this.B = ((int)(21.0F * f + 0.5F));
    this.C = ((int)(15.0F * f + 0.5F));
    this.D = ((int)(10.0F * f + 0.5F));
    this.E = ((int)(9.0F * f + 0.5F));
    this.F = ((int)(6.0F * f + 0.5F));
    this.G = ((int)(4.0F * f + 0.5F));
    this.H = ((int)(1.0F * f + 0.5F));
    this.z = (this.D * 23);
    this.I = ((int)(157.0F * f + 0.5F));
    this.J = ((int)(65.0F * f + 0.5F));
    this.K = ((int)(7.0F * f + 0.5F));
    this.L = ((int)(152.0F * f + 0.5F));
    this.M = ((int)(5.0F * f + 0.5F));
    this.N = ((int)(61.0F * f + 0.5F));
    this.O = ((int)(19.0F * f + 0.5F));
    this.P = ((int)(8.0F * f + 0.5F));
    this.Q = ((int)(f * 3.0F + 0.5F));
    R = this.H * 2;
    S = this.H * 2;
    T = this.K;
    paramBaseAdapter = (FragmentActivity)paramContext;
    if (paramBaseAdapter.getChatFragment() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseAdapter.getChatFragment().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = ((IndividualRedPacketManager)paramQQAppInterface.getManager(130));
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i1 = -1;
    Object localObject = "";
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      paramSessionInfo = (SessionInfo)localObject;
    }
    for (;;)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("groupType", i1);
      paramQQAppInterface.putString("name", paramSessionInfo);
      return paramQQAppInterface;
      i1 = 0;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      i1 = 2;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      localObject = (HotChatManager)paramQQAppInterface.getManager(59);
      int i2;
      if ((localObject != null) && (((HotChatManager)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        i2 = 5;
        localObject = ContactUtils.o(paramQQAppInterface, paramQQAppInterface.a());
        paramSessionInfo = (SessionInfo)localObject;
        i1 = i2;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i1 = i2;
        }
      }
      else
      {
        i1 = 1;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i1 = 3;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i1 = 4;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i2 = 6;
        localObject = ContactUtils.o(paramQQAppInterface, paramQQAppInterface.a());
        paramSessionInfo = (SessionInfo)localObject;
        i1 = i2;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i1 = i2;
        }
      }
    }
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    int i1 = -1;
    String str = "";
    switch (paramMessageForQQWalletMsg.istroop)
    {
    default: 
      paramSessionInfo = str;
    }
    for (;;)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("groupType", i1);
      paramQQAppInterface.putString("name", paramSessionInfo);
      return paramQQAppInterface;
      i1 = 0;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      i1 = 2;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      paramMessageForQQWalletMsg = (HotChatManager)paramQQAppInterface.getManager(59);
      int i2;
      if ((paramMessageForQQWalletMsg != null) && (paramMessageForQQWalletMsg.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        i2 = 5;
        paramMessageForQQWalletMsg = ContactUtils.o(paramQQAppInterface, paramQQAppInterface.a());
        paramSessionInfo = paramMessageForQQWalletMsg;
        i1 = i2;
        if (TextUtils.isEmpty(paramMessageForQQWalletMsg))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i1 = i2;
        }
      }
      else
      {
        i1 = 1;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i1 = 3;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i1 = 4;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i2 = 6;
        paramMessageForQQWalletMsg = ContactUtils.o(paramQQAppInterface, paramQQAppInterface.a());
        paramSessionInfo = paramMessageForQQWalletMsg;
        i1 = i2;
        if (TextUtils.isEmpty(paramMessageForQQWalletMsg))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i1 = i2;
        }
      }
    }
  }
  
  private RelativeLayout.LayoutParams a()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.K;
    localLayoutParams.bottomMargin = this.C;
    localLayoutParams.rightMargin = this.K;
    localLayoutParams.addRule(3, 2131303191);
    localLayoutParams.addRule(7, 2131303191);
    return localLayoutParams;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.z, this.C * 5));
    localQQWalletTransferBubbleView.setId(2131303299);
    Object localObject1 = new ImageView(paramContext);
    Object localObject2 = new RelativeLayout.LayoutParams(this.A, this.A);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.B;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject1).setId(2131303301);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localObject1 = new LinearLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131303301);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.B;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.F;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setOrientation(1);
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(24.0F);
    ((TextView)localObject2).setId(2131303280);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.H;
    ((TextView)localObject2).setLayoutParams(localLayoutParams);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(13.0F);
    ((TextView)localObject2).setId(2131303285);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(this.z, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131303299);
    localQQWalletTransferBubbleView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localQQWalletTransferBubbleView.setBackgroundResource(2130841770);
    localQQWalletTransferBubbleView.setId(2131303286);
    paramContext = new TextView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.B;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.B;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.C;
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.C;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131303282);
    localQQWalletTransferBubbleView.addView(paramContext);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    return localRelativeLayout;
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.D;
    localLayoutParams.bottomMargin = this.F;
    localLayoutParams.leftMargin = (this.A + this.G);
    localLayoutParams.rightMargin = (this.A + this.G);
    localLayoutParams.addRule(3, 2131296328);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130840531);
    paramContext.setPadding(this.E, this.G, this.E, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.G, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131303279);
    return paramContext;
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.a();
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).c(str);
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface.name != null) && (paramQQAppInterface.name.length() > 0)) {
        return paramQQAppInterface.name;
      }
      return paramQQAppInterface.uin;
    }
    return str;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString1 = a(paramString2, paramString1, paramInt, paramString3, paramString4, paramString7, paramSessionInfo.jdField_b_of_type_JavaLangString);
    if (paramSessionInfo.jdField_a_of_type_Int == 1008) {
      paramSessionInfo = new JSONObject();
    }
    try
    {
      paramSessionInfo.put("channel", 2);
      paramString1.put("detailinfo", paramSessionInfo);
      paramSessionInfo = new JSONObject();
    }
    catch (Exception paramSessionInfo)
    {
      try
      {
        do
        {
          paramSessionInfo.put("userId", paramQQAppInterface.a());
          paramSessionInfo.put("viewTag", paramString6);
          paramSessionInfo.put("app_info", paramString5);
          paramSessionInfo.put("come_from", 2);
          paramSessionInfo.put("extra_data", paramString1);
          return paramSessionInfo;
          paramSessionInfo = paramSessionInfo;
        } while (!QLog.isDevelopLevel());
        paramSessionInfo.printStackTrace();
      }
      catch (Exception paramQQAppInterface)
      {
        while (!QLog.isDevelopLevel()) {}
        paramQQAppInterface.printStackTrace();
      }
    }
    return paramSessionInfo;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramMessageForQQWalletMsg = a(paramString2, paramString1, paramInt, paramString3, paramString4, paramString7, paramMessageForQQWalletMsg.senderuin);
    if (paramSessionInfo.jdField_a_of_type_Int == 1008) {
      paramSessionInfo = new JSONObject();
    }
    try
    {
      paramSessionInfo.put("channel", 2);
      paramMessageForQQWalletMsg.put("detailinfo", paramSessionInfo);
      paramSessionInfo = new JSONObject();
    }
    catch (Exception paramSessionInfo)
    {
      try
      {
        do
        {
          paramSessionInfo.put("userId", paramQQAppInterface.a());
          paramSessionInfo.put("viewTag", paramString6);
          paramSessionInfo.put("app_info", paramString5);
          paramSessionInfo.put("come_from", 2);
          paramSessionInfo.put("extra_data", paramMessageForQQWalletMsg);
          return paramSessionInfo;
          paramSessionInfo = paramSessionInfo;
        } while (!QLog.isDevelopLevel());
        paramSessionInfo.printStackTrace();
      }
      catch (Exception paramQQAppInterface)
      {
        while (!QLog.isDevelopLevel()) {}
        paramQQAppInterface.printStackTrace();
      }
    }
    return paramSessionInfo;
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("listid", paramString1);
      localJSONObject.put("name", paramString2);
      localJSONObject.put("grouptype", paramInt + "");
      localJSONObject.put("groupid", paramString4);
      if (paramString6 != null) {
        localJSONObject.put("groupuin", paramString6);
      }
      if (paramString3 != null) {
        localJSONObject.put("authkey", paramString3);
      }
      if (paramString5 != null) {
        localJSONObject.put("cftImageUrl", paramString5);
      }
    }
    catch (Exception paramString1)
    {
      while (!QLog.isDevelopLevel()) {}
      paramString1.printStackTrace();
    }
    return localJSONObject;
    return localJSONObject;
  }
  
  private void a(nnv paramnnv, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = (ImageView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303181);
    TextView localTextView1 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303184);
    TextView localTextView2 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303189);
    TextView localTextView3 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303186);
    Object localObject2 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303188);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303191);
    ImageView localImageView = (ImageView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303190);
    Object localObject3 = (RelativeLayout)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303182);
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    boolean bool2 = paramMessageForQQWalletMsg.isSend();
    int i2;
    int i1;
    label144:
    label173:
    label238:
    label247:
    int i3;
    label305:
    label315:
    int i4;
    boolean bool1;
    if (paramMessageForQQWalletMsg.messageType == 6)
    {
      i2 = 1;
      if (i2 == 0) {
        break label779;
      }
      i1 = 0;
      ((ImageView)localObject1).setVisibility(i1);
      float f = localTextView1.getPaint().measureText("测");
      if (i2 == 0) {
        break label786;
      }
      i1 = 6;
      localTextView1.setMaxWidth((int)(i1 * f + 0.5F));
      localTextView1.setText(localQQWalletRedPacketMsg.elem.title);
      localTextView1.setTextColor(Color.parseColor("#f2b668"));
      if ((paramMessageForQQWalletMsg.background == null) || ((paramMessageForQQWalletMsg.messageType != 4) && (paramMessageForQQWalletMsg.messageType != 5))) {
        break label793;
      }
      i1 = 1;
      if (i1 == 0) {
        break label799;
      }
      i1 = 8;
      localTextView1.setVisibility(i1);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      if (paramMessageForQQWalletMsg.customizeBg == null) {
        break label811;
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      i3 = this.D;
      if (localTextView1.getText().length() <= 7) {
        break label805;
      }
      i1 = 2;
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (i1 * i3);
      ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i4 = 1;
      i1 = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.c())) {
        break label821;
      }
      bool1 = true;
      label348:
      if ((!bool1) || (paramMessageForQQWalletMsg.messageType != 2001)) {
        break label827;
      }
      i3 = 1;
      label366:
      if (i3 == 0) {
        paramMessageForQQWalletMsg.customizeBg = null;
      }
      if (bool2) {
        break label858;
      }
      if (paramMessageForQQWalletMsg.customizeBg == null) {
        break label833;
      }
      localObject1 = new SpannableStringBuilder("QQ红包个性版");
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, 4, 34);
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#D13D4B")), 4, ((SpannableStringBuilder)localObject1).length(), 34);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
      label463:
      ((TextView)localObject2).setLayoutParams(b());
      ((TextView)localObject2).setVisibility(0);
      label478:
      ((TextView)localObject2).setTag(paramMessageForQQWalletMsg);
      if (i1 == 0) {
        break label934;
      }
      ((TextView)localObject2).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      label498:
      if (i2 == 0) {
        break label967;
      }
      localObject3 = (PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
      localObject2 = ((PasswdRedBagManager)localObject3).a(localQQWalletRedPacketMsg.redPacketId);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, paramMessageForQQWalletMsg.senderuin, paramMessageForQQWalletMsg.time + 90000L, localQQWalletRedPacketMsg.elem.title, false, false, false);
        ((PasswdRedBagManager)localObject3).a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, paramMessageForQQWalletMsg.senderuin, paramMessageForQQWalletMsg.time + 90000L, String.valueOf(((PasswdRedBagManager)localObject3).a(paramMessageForQQWalletMsg.istroop)), paramMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false);
      }
      if (((PasswdRedBagInfo)localObject1).jdField_a_of_type_Boolean) {
        break label943;
      }
      localTextView3.setVisibility(8);
      localTextView2.setText("口令红包");
      localTextView2.setVisibility(0);
      label657:
      localImageView.setVisibility(8);
    }
    for (;;)
    {
      if (paramMessageForQQWalletMsg.background != null)
      {
        localRelativeLayout.setBackgroundDrawable(new BitmapDrawable(localRelativeLayout.getResources(), paramMessageForQQWalletMsg.background));
        paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramMessageForQQWalletMsg);
        if (i2 == 0) {
          break label1590;
        }
        paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("口令:" + localQQWalletRedPacketMsg.elem.title + ",点击领取口令");
        paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        return;
        i2 = 0;
        break;
        label779:
        i1 = 8;
        break label144;
        label786:
        i1 = 7;
        break label173;
        label793:
        i1 = 0;
        break label238;
        label799:
        i1 = 0;
        break label247;
        label805:
        i1 = 3;
        break label305;
        label811:
        ((RelativeLayout.LayoutParams)localObject1).addRule(13);
        break label315;
        label821:
        bool1 = false;
        break label348;
        label827:
        i3 = 0;
        break label366;
        label833:
        i1 = 0;
        ((TextView)localObject2).setTextColor(Color.parseColor("#FFFFFF"));
        ((TextView)localObject2).setText("QQ红包");
        break label463;
        label858:
        if ((localQQWalletRedPacketMsg.redtype == 1) || (i2 != 0) || (paramMessageForQQWalletMsg.customizeBg != null))
        {
          ((TextView)localObject2).setTextColor(Color.parseColor("#00A5E0"));
          ((TextView)localObject2).setText("查看领取详情");
          ((TextView)localObject2).setLayoutParams(a());
          ((TextView)localObject2).setVisibility(0);
          i1 = i4;
          break label478;
        }
        ((TextView)localObject2).setVisibility(8);
        i1 = i4;
        break label478;
        label934:
        ((TextView)localObject2).setOnClickListener(null);
        break label498;
        label943:
        localTextView2.setVisibility(8);
        localTextView3.setText("口令红包已拆开");
        localTextView3.setVisibility(0);
        break label657;
        label967:
        if (paramMessageForQQWalletMsg.customizeBg != null)
        {
          localTextView2.setVisibility(8);
          localTextView3.setVisibility(8);
          localImageView.setBackgroundDrawable(new BitmapDrawable(localImageView.getResources(), paramMessageForQQWalletMsg.customizeBg));
          localImageView.setVisibility(0);
        }
        else
        {
          localImageView.setVisibility(8);
          paramMessageForQQWalletMsg.customizeBg = null;
          label1065:
          QQAppInterface localQQAppInterface;
          if ((bool2) && (localQQWalletRedPacketMsg.redtype == 2))
          {
            localTextView3.setVisibility(8);
            localTextView2.setText("查看详情");
            localTextView2.setVisibility(0);
            if (i3 == 0) {
              break label1346;
            }
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!bool1) {
              break label1348;
            }
          }
          label1346:
          label1348:
          for (localObject1 = "1";; localObject1 = "0")
          {
            ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006133", "0X8006133", 0, 0, (String)localObject1, "0", "", "");
            localObject1 = new CustomizeStrategyFactory.RedPacketInfo();
            ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_a_of_type_Boolean = bool2;
            ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_a_of_type_Int = 2;
            ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_a_of_type_JavaLangString = (localQQWalletRedPacketMsg.envelopeid + "");
            ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_b_of_type_JavaLangString = localQQWalletRedPacketMsg.envelopeName;
            ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_b_of_type_Int = localQQWalletRedPacketMsg.conftype;
            if (QLog.isColorLevel()) {
              QLog.d("CustomizeStrategyFactory", 2, "info =" + ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_a_of_type_Int + "|" + ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_a_of_type_JavaLangString + "|" + ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_b_of_type_JavaLangString + "|" + System.currentTimeMillis());
            }
            CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (CustomizeStrategyFactory.RedPacketInfo)localObject1, new nnr(this, localTextView2, localTextView3, localImageView, paramMessageForQQWalletMsg, localTextView1, (RelativeLayout)localObject3, (TextView)localObject2, bool1));
            break;
            if (!localQQWalletRedPacketMsg.isOpened)
            {
              localTextView3.setVisibility(8);
              localTextView2.setText("点击拆开");
              localTextView2.setVisibility(0);
              break label1065;
            }
            localTextView2.setVisibility(8);
            localTextView3.setVisibility(0);
            break label1065;
            break;
          }
        }
      }
    }
    if (i2 != 0) {
      if (bool2)
      {
        i1 = 2130841763;
        label1371:
        localRelativeLayout.setBackgroundResource(i1);
        if (localQQWalletRedPacketMsg.elem == null) {
          break label1571;
        }
        if (!bool2) {
          break label1558;
        }
        localObject1 = localQQWalletRedPacketMsg.elem.aioImageRight;
        label1401:
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1571;
        }
        i1 = 1;
        label1412:
        if (i1 == 0) {
          break label1575;
        }
        localObject2 = new CustomizeStrategyFactory.RedPacketInfo();
        ((CustomizeStrategyFactory.RedPacketInfo)localObject2).jdField_a_of_type_Boolean = bool2;
        ((CustomizeStrategyFactory.RedPacketInfo)localObject2).jdField_a_of_type_Int = 1;
        if (!bool2) {
          break label1577;
        }
      }
    }
    label1558:
    label1571:
    label1575:
    label1577:
    for (localObject1 = localQQWalletRedPacketMsg.elem.aioImageRight;; localObject1 = localQQWalletRedPacketMsg.elem.aioImageLeft)
    {
      ((CustomizeStrategyFactory.RedPacketInfo)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (CustomizeStrategyFactory.RedPacketInfo)localObject2, new nns(this, localRelativeLayout, paramMessageForQQWalletMsg, localTextView1));
      break;
      i1 = 2130841761;
      break label1371;
      if (i3 != 0)
      {
        if (bool2) {}
        for (i1 = 2130841760;; i1 = 2130841759)
        {
          localRelativeLayout.setBackgroundResource(i1);
          break;
        }
      }
      if (bool2) {}
      for (i1 = 2130841767;; i1 = 2130841766)
      {
        localRelativeLayout.setBackgroundResource(i1);
        break;
      }
      localObject1 = localQQWalletRedPacketMsg.elem.aioImageLeft;
      break label1401;
      i1 = 0;
      break label1412;
      break;
    }
    label1590:
    paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(localQQWalletRedPacketMsg.elem.title + this.e);
    paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void a(nnv paramnnv, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ImageView localImageView1 = (ImageView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303181);
    TextView localTextView1 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303184);
    TextView localTextView2 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303189);
    TextView localTextView3 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303186);
    TextView localTextView4 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303188);
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303191);
    ImageView localImageView2 = (ImageView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303190);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303182);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localRelativeLayout2.setLayoutParams(localLayoutParams);
    paramMessageForQQWalletMsg.background = null;
    paramMessageForQQWalletMsg.customizeBg = null;
    localImageView2.setVisibility(8);
    localImageView1.setVisibility(8);
    localTextView1.setMaxWidth((int)(localTextView1.getPaint().measureText("测") * 7.0F + 0.5F));
    localTextView1.setText(paramQQWalletTransferMsgElem.title);
    localTextView1.setTextColor(Color.parseColor("#f2b668"));
    localTextView1.setVisibility(0);
    localTextView4.setVisibility(8);
    localTextView4.setOnClickListener(null);
    localTextView2.setVisibility(0);
    localTextView2.setText("点击拆开");
    localTextView3.setVisibility(8);
    if (paramMessageForQQWalletMsg.isSend()) {
      localRelativeLayout1.setBackgroundResource(2130841767);
    }
    for (;;)
    {
      paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramMessageForQQWalletMsg);
      paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramQQWalletTransferMsgElem.title + this.e);
      paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
      return;
      localRelativeLayout1.setBackgroundResource(2130841766);
    }
  }
  
  private void a(nnv paramnnv, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, boolean paramBoolean, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303280);
    TextView localTextView2 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303285);
    ImageView localImageView = (ImageView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303301);
    TextView localTextView1 = (TextView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303282);
    QQWalletTransferBubbleView localQQWalletTransferBubbleView1 = (QQWalletTransferBubbleView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303286);
    QQWalletTransferBubbleView localQQWalletTransferBubbleView2 = (QQWalletTransferBubbleView)paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303299);
    float f;
    if (paramQQWalletTransferMsgElem.title != null)
    {
      ((TextView)localObject).setTextSize(24.0F);
      TextPaint localTextPaint = ((TextView)localObject).getPaint();
      if (localTextPaint != null)
      {
        f = localTextPaint.measureText(paramQQWalletTransferMsgElem.title);
        if (this.z <= BaseChatItemLayout.h) {
          break label394;
        }
        if (f > BaseChatItemLayout.h - this.D * 9) {
          ((TextView)localObject).setTextSize(14.0F);
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject).setText(paramQQWalletTransferMsgElem.title);
      ((TextView)localObject).setTextColor(paramQQWalletTransferMsgElem.titleColor);
      localTextView2.setText(paramQQWalletTransferMsgElem.subTitle);
      localTextView2.setTextColor(paramQQWalletTransferMsgElem.subtitleColor);
      localTextView1.setText(paramQQWalletTransferMsgElem.content);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(a(paramQQWalletTransferMsgElem.icon));
      if (!TextUtils.isEmpty(paramQQWalletTransferMsgElem.iconUrl)) {
        localObject = URLDrawableHelper.a(paramQQWalletTransferMsgElem.iconUrl, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, this.A), (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, this.A), null, null);
      }
      localImageView.setImageDrawable((Drawable)localObject);
      if (paramQQWalletTransferMsgElem.contentBgColor != 0) {
        localQQWalletTransferBubbleView1.setBubbleBackground(2130841770, paramQQWalletTransferMsgElem.contentBgColor, paramBoolean);
      }
      if (paramQQWalletTransferMsgElem.contentColor != 0) {
        localTextView1.setTextColor(paramQQWalletTransferMsgElem.contentColor);
      }
      localQQWalletTransferBubbleView2.setBubbleBackground(2130841769, paramQQWalletTransferMsgElem.background, paramBoolean);
      paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramQQWalletTransferMsgElem.title + paramQQWalletTransferMsgElem.subTitle + this.e);
      paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramnnv.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
      return;
      label394:
      if (f > this.D * 14) {
        ((TextView)localObject).setTextSize(14.0F);
      }
    }
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, JumpActivity.class);
    localIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(localIntent);
    return true;
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    String[] arrayOfString = paramString1.split("\\?");
    if (TextUtils.isEmpty(arrayOfString[0])) {
      return false;
    }
    Object localObject1 = new HashMap();
    int i1;
    Object localObject2;
    if ((arrayOfString.length > 1) && (!TextUtils.isEmpty(arrayOfString[1])))
    {
      paramString1 = arrayOfString[1].split("&");
      i1 = 0;
      if (i1 < paramString1.length)
      {
        if (TextUtils.isEmpty(paramString1[i1])) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = paramString1[i1].split("=");
          if (localObject2.length == 2)
          {
            try
            {
              localObject2[1] = URLDecoder.decode(localObject2[1], "UTF-8");
              ((HashMap)localObject1).put(localObject2[0], localObject2[1]);
            }
            catch (Exception localException)
            {
              if (QLog.isDevelopLevel()) {
                localException.printStackTrace();
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to URLDecoder.decode WalletAction value,tmps[1] is:" + localObject2[0] + ",tmps[1] is:" + localObject2[1], localException);
            }
          }
        }
      }
    }
    if (arrayOfString[0].equals("pay"))
    {
      paramString1 = (String)((HashMap)localObject1).get("payData");
      paramString2 = (String)((HashMap)localObject1).get("reqCode");
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
        return false;
      }
      paramString3 = new Bundle();
      paramString3.putString("json", paramString1);
      paramString3.putString("callbackSn", "0");
      paramString1 = new Intent(paramContext, PayBridgeActivity.class);
      paramString1.putExtras(paramString3);
      paramString1.putExtra("pay_requestcode", Integer.valueOf(paramString2).intValue());
    }
    label949:
    for (;;)
    {
      try
      {
        paramContext.startActivity(paramString1);
        return true;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramContext.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to startActivity : " + arrayOfString[0], paramContext);
        return false;
      }
      if (arrayOfString[0].equals("red"))
      {
        localObject1 = (String)((HashMap)localObject1).get("id");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return false;
        }
        paramString1 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.cftImage;
        localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, paramMessageForQQWalletMsg);
        i1 = ((Bundle)localObject2).getInt("groupType");
        localObject2 = ((Bundle)localObject2).getString("name");
        paramString2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForQQWalletMsg, paramSessionInfo, i1, (String)localObject2, (String)localObject1, paramString2, paramString3, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", paramString1);
        paramSessionInfo = (IndividualRedPacketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(130);
        if ((paramSessionInfo == null) || (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid <= 0)) {}
      }
      try
      {
        paramString3 = paramString2.getJSONObject("extra_data");
        paramString3.put("channel", "8");
        paramSessionInfo = paramSessionInfo.a(String.valueOf(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid), paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeName, 7);
        if (QLog.isColorLevel()) {
          QLog.d("vipBgImage", 2, paramSessionInfo);
        }
        paramString3.put("vipBgImage", paramSessionInfo);
      }
      catch (Exception paramString3)
      {
        continue;
      }
      paramString3 = new Bundle();
      paramString3.putString("json", paramString2.toString());
      paramString3.putString("callbackSn", "0");
      if (paramString1 != null) {
        paramString3.putString("cftImageUrl", paramString1);
      }
      paramString1 = (String)localObject1;
      if (localObject1 != null)
      {
        paramString1 = (String)localObject1;
        if (((String)localObject1).length() > 4) {
          paramString1 = "****" + ((String)localObject1).substring(4);
        }
      }
      paramString3.putLong("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "graphb", "open", "groupType=" + i1 + "&msgType=" + paramMessageForQQWalletMsg.messageType + "&redId=" + paramString1, 0, null));
      paramString1 = new Intent(paramContext, PayBridgeActivity.class);
      paramString1.putExtras(paramString3);
      paramString1.putExtra("pay_requestcode", 5);
      continue;
      try
      {
        paramString1 = QQWalletMsgItemBuilder.class.getClassLoader();
        if (paramString1 == null) {
          return false;
        }
        paramString1 = paramString1.loadClass(arrayOfString[0]);
      }
      catch (Exception paramString1)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramString1.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to find Class : " + arrayOfString[0], paramString1);
        paramString1 = null;
        continue;
        paramString1 = new Intent(paramContext, paramString1);
        paramString2 = ((HashMap)localObject1).entrySet().iterator();
        if (!paramString2.hasNext()) {
          break label949;
        }
      }
      if (paramString1 == null) {
        return false;
      }
      paramString3 = (Map.Entry)paramString2.next();
      paramString1.putExtra((String)paramString3.getKey(), (String)paramString3.getValue());
    }
  }
  
  private boolean a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    boolean bool = true;
    QQWalletTransferMsgElem localQQWalletTransferMsgElem = null;
    if (paramMessageForQQWalletMsg == null) {
      break label25;
    }
    label25:
    do
    {
      do
      {
        return false;
        if (paramMessageForQQWalletMsg.mQQWalletTransferMsg == null) {
          break;
        }
        localQQWalletTransferMsgElem = paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
      } while (localQQWalletTransferMsgElem == null);
      paramMessageForQQWalletMsg = localQQWalletTransferMsgElem.nativeAndroid;
    } while (TextUtils.isEmpty(paramMessageForQQWalletMsg));
    paramMessageForQQWalletMsg = paramMessageForQQWalletMsg.split("\\?");
    if ((!TextUtils.isEmpty(paramMessageForQQWalletMsg[0])) && (paramMessageForQQWalletMsg[0].equals("red"))) {}
    for (;;)
    {
      return bool;
      if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
        break;
      }
      return true;
      bool = false;
    }
  }
  
  private RelativeLayout.LayoutParams b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.K;
    localLayoutParams.bottomMargin = this.C;
    localLayoutParams.leftMargin = this.K;
    localLayoutParams.addRule(3, 2131303191);
    localLayoutParams.addRule(5, 2131303191);
    return localLayoutParams;
  }
  
  private RelativeLayout b(Context paramContext)
  {
    RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
    localRelativeLayout1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    Object localObject1 = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(this.L, this.I);
    ((RelativeLayout)localObject1).setId(2131303191);
    RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
    localRelativeLayout2.setId(2131303182);
    localRelativeLayout2.setPadding(0, DisplayUtil.a(paramContext, 10.0F), 0, 0);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    localRelativeLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(this.M * 2, this.F * 3);
    localLayoutParams2.rightMargin = this.M;
    localLayoutParams2.topMargin = this.G;
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setBackgroundResource(2130841762);
    ((ImageView)localObject2).setId(2131303181);
    Object localObject3 = new EllipseTextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams3.addRule(1, 2131303181);
    ((TextView)localObject3).setTextSize(16.0F);
    ((TextView)localObject3).setTextColor(Color.parseColor("#f2b668"));
    ((TextView)localObject3).setId(2131303184);
    localRelativeLayout2.addView((View)localObject2, localLayoutParams2);
    localRelativeLayout2.addView((View)localObject3, localLayoutParams3);
    localObject2 = new TextView(paramContext);
    localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(14);
    localLayoutParams2.addRule(12);
    localLayoutParams2.bottomMargin = (this.E * 2);
    ((TextView)localObject2).setTextSize(13.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#edc1c4"));
    ((TextView)localObject2).setId(2131303189);
    ((TextView)localObject2).setVisibility(8);
    localObject3 = new TextView(paramContext);
    localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams3.addRule(14);
    localLayoutParams3.addRule(12);
    localLayoutParams3.bottomMargin = (this.E * 2);
    ((TextView)localObject3).setText("已拆开");
    ((TextView)localObject3).setTextSize(13.0F);
    ((TextView)localObject3).setTextColor(Color.parseColor("#e8866b"));
    ((TextView)localObject3).setId(2131303186);
    ((TextView)localObject3).setVisibility(8);
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setId(2131303190);
    localImageView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 138.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 115.0F));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams4.leftMargin = this.K;
    localLayoutParams4.addRule(5, 2131303191);
    localLayoutParams4.addRule(8, 2131303191);
    ((RelativeLayout)localObject1).addView(localRelativeLayout2);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams2);
    ((RelativeLayout)localObject1).addView((View)localObject3, localLayoutParams3);
    localRelativeLayout1.addView((View)localObject1, localLayoutParams1);
    localRelativeLayout1.addView(localImageView, localLayoutParams4);
    paramContext = new TextView(paramContext);
    localObject1 = a();
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setTextColor(-16734752);
    paramContext.setBackgroundResource(2130840531);
    paramContext.setPadding(this.E, 0, this.E, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setSingleLine();
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131303188);
    localRelativeLayout1.addView(paramContext, (ViewGroup.LayoutParams)localObject1);
    return localRelativeLayout1;
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
    return true;
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2130841768;
    case 1: 
      return 2130841771;
    case 3: 
      return 2130841772;
    }
    return 2130841765;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    nnv localnnv = (nnv)paramViewHolder;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;; paramViewHolder = null)
    {
      if (paramViewHolder == null) {
        return null;
      }
      if ((paramViewHolder.mQQWalletTransferMsg == null) && (paramViewHolder.mQQWalletRedPacketMsg == null)) {
        return null;
      }
      boolean bool = a(paramViewHolder);
      if ((bool) && (QWalletHelper.jdField_a_of_type_Boolean)) {
        a(paramViewHolder.istroop);
      }
      if ((localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (localnnv.jdField_a_of_type_Long != paramChatMessage.uniseq))
      {
        if (!bool) {
          break label223;
        }
        if (localnnv.jdField_a_of_type_JavaLangString.equals("TRANSFER"))
        {
          localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout = b(this.jdField_a_of_type_AndroidContentContext);
          localnnv.jdField_a_of_type_JavaLangString = "REDPACKET";
          paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
        }
      }
      if (localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        if (!bool) {
          break label279;
        }
        localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout = b(this.jdField_a_of_type_AndroidContentContext);
        localnnv.jdField_a_of_type_JavaLangString = "REDPACKET";
        paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
      }
      for (;;)
      {
        localnnv.jdField_a_of_type_Long = paramChatMessage.uniseq;
        if ((bool) || (paramViewHolder.mQQWalletTransferMsg == null)) {
          break label453;
        }
        paramView = paramViewHolder.mQQWalletTransferMsg.elem;
        if (paramView != null) {
          break label322;
        }
        return localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout;
        label223:
        if ((paramViewHolder.mQQWalletTransferMsg == null) || (!localnnv.jdField_a_of_type_JavaLangString.equals("REDPACKET"))) {
          break;
        }
        localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout = a(this.jdField_a_of_type_AndroidContentContext);
        localnnv.jdField_a_of_type_JavaLangString = "TRANSFER";
        paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
        break;
        label279:
        if (paramViewHolder.mQQWalletTransferMsg != null)
        {
          localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout = a(this.jdField_a_of_type_AndroidContentContext);
          paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
          localnnv.jdField_a_of_type_JavaLangString = "TRANSFER";
        }
      }
      label322:
      if (!paramChatMessage.isSend())
      {
        bool = true;
        a(localnnv, paramView, bool, paramOnLongClickAndTouchListener);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + paramViewHolder.mQQWalletTransferMsg.templateId, "", "", "");
        paramChatMessage = paramView;
      }
      for (;;)
      {
        label399:
        paramViewHolder = (TextView)paramBaseChatItemLayout.findViewById(2131303279);
        if (paramViewHolder != null)
        {
          if ((paramChatMessage == null) || (TextUtils.isEmpty(paramChatMessage.blackStripe))) {
            break label538;
          }
          paramViewHolder.setText(paramChatMessage.blackStripe);
          paramViewHolder.setVisibility(0);
        }
        for (;;)
        {
          return localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout;
          bool = false;
          break;
          label453:
          if ((bool) && (paramViewHolder.mQQWalletRedPacketMsg != null))
          {
            paramChatMessage = paramViewHolder.mQQWalletRedPacketMsg.elem;
            if (paramChatMessage == null) {
              return localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout;
            }
            a(localnnv, paramViewHolder, paramOnLongClickAndTouchListener);
            break label399;
          }
          if ((!bool) || (paramViewHolder.mQQWalletTransferMsg == null)) {
            break label547;
          }
          paramChatMessage = paramViewHolder.mQQWalletTransferMsg.elem;
          if (paramChatMessage == null) {
            return localnnv.jdField_a_of_type_AndroidWidgetRelativeLayout;
          }
          a(localnnv, paramChatMessage, paramViewHolder, paramOnLongClickAndTouchListener);
          break label399;
          label538:
          paramViewHolder.setVisibility(8);
        }
        label547:
        paramChatMessage = null;
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new nnv(this, null);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    Object localObject = null;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      localObject = (MessageForQQWalletMsg)paramChatMessage;
    }
    if ((localObject == null) || (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null)) {
      return paramChatMessage.msg;
    }
    localObject = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (MsgUtils.a(paramChatMessage.issend))
      {
        localStringBuilder.append("发出");
        if ((((QQWalletTransferMsgElem)localObject).subTitle == null) || (!((QQWalletTransferMsgElem)localObject).subTitle.contains("已转入你的"))) {
          break label176;
        }
        if ((((QQWalletTransferMsgElem)localObject).content == null) || (!((QQWalletTransferMsgElem)localObject).content.contains("QQ转账"))) {
          break label145;
        }
        localStringBuilder.append("QQ转账").append(((QQWalletTransferMsgElem)localObject).title).append("按钮");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append("发来");
        break;
        label145:
        localStringBuilder.append("QQ转账").append(((QQWalletTransferMsgElem)localObject).title).append(((QQWalletTransferMsgElem)localObject).content).append("按钮");
        continue;
        label176:
        localStringBuilder.append(((QQWalletTransferMsgElem)localObject).content).append(((QQWalletTransferMsgElem)localObject).title).append("按钮");
      }
    }
    return paramChatMessage.msg;
  }
  
  protected void a(int paramInt)
  {
    ThreadManager.b().post(new nnp(this, paramInt));
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131305401: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(S, T, R, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(R, T, S, paramView.getResources().getDimensionPixelSize(2131493039));
      return;
    }
    paramView.setPadding(R, T, S, 0);
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    a(AIOUtils.a(paramView), localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\QQWalletMsgItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */