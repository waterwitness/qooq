package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.BitmapTools;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mwt;
import mwu;
import mwv;
import mww;
import mwx;
import mwy;
import mwz;
import mxa;
import mxb;
import mxc;
import mxf;
import mxg;
import mxh;
import mxi;
import mxj;
import mxk;
import mxl;
import mxm;
import mxn;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopRequestActivity
  extends IphoneTitleBarActivity
  implements AppConstants, FaceDecoder.DecodeTaskCompletionListener
{
  protected static final String O = ".";
  protected static final String P = " ";
  public static final int a = 1005;
  protected static final String a = "Q.systemmsg.TroopRequestActivity";
  public static int b = 0;
  public static final String b = "troopMsgId";
  public static final boolean b;
  protected static long c = 0L;
  public static final String c = "mTroopMsgType";
  public static long d = 0L;
  public static final String d = "mTroopCode";
  public static final int e = 0;
  public static final String e = "troopmanagerUin";
  public static final int f = 1;
  public static final String f = "troopsMsg";
  protected static final int g = 2;
  public static final String g = "troopRequestUin";
  public static int h = 0;
  public static final String h = "troopAuth";
  public static final int i;
  public static final String i = "troopOp";
  public static final int j;
  public static final String j = "troopsummary";
  public static final int k;
  public static final String k = "is_unread";
  public static final int l;
  public static final String l = "infotime";
  protected static final int m = 0;
  public static final String m = "troopMsgDealInfo";
  public static final String n = "troopMsgDealType";
  public static final String o = "troopinvatememUin";
  public static final String p = "troop_describe_uintype";
  protected String A;
  protected String B;
  protected String C;
  protected String D;
  protected String E;
  protected String F;
  public String G;
  protected String H;
  protected String I;
  public String J;
  public String K;
  public String L;
  public String M = "";
  public String N = "";
  protected long a;
  public Handler a;
  protected SpannableStringBuilder a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new mxi(this);
  protected View a;
  public Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected URLImageView a;
  public TroopNotificationUtils.TroopPrivilegeCallback a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new mwv(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mww(this);
  protected MessageObserver a;
  public TroopHandler a;
  protected TroopObserver a;
  protected FaceDecoder a;
  protected QQProgressDialog a;
  public structmsg.StructMsg a;
  public short a;
  public boolean a;
  public byte[] a;
  private LinearLayout[] jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout = new LinearLayout[jdField_h_of_type_Int];
  private RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[jdField_h_of_type_Int - 1];
  protected long b;
  View.OnClickListener b;
  protected View b;
  public Button b;
  public LinearLayout b;
  protected TextView b;
  public int c;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new mwx(this);
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  protected TextView c;
  protected int d;
  View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new mwy(this);
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  protected TextView d;
  View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new mwz(this);
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  protected TextView e;
  private String eC;
  View.OnClickListener f;
  protected TextView f;
  protected TextView g;
  public TextView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  protected TextView l;
  protected TextView m;
  protected int n;
  public TextView n;
  protected TextView o;
  protected TextView p;
  protected TextView q;
  protected String q;
  public TextView r;
  public String r;
  TextView s;
  public String s;
  TextView t;
  protected String t;
  private TextView u;
  public String u;
  private TextView v;
  protected String v;
  protected String w;
  protected String x;
  protected String y;
  protected String z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = 10;
    int i1 = jdField_h_of_type_Int;
    jdField_h_of_type_Int = i1 + 1;
    jdField_i_of_type_Int = i1;
    i1 = jdField_h_of_type_Int;
    jdField_h_of_type_Int = i1 + 1;
    jdField_j_of_type_Int = i1;
    i1 = jdField_h_of_type_Int;
    jdField_h_of_type_Int = i1 + 1;
    jdField_k_of_type_Int = i1;
    i1 = jdField_h_of_type_Int;
    jdField_h_of_type_Int = i1 + 1;
    jdField_l_of_type_Int = i1;
    jdField_b_of_type_Boolean = AppSetting.j;
  }
  
  public TroopRequestActivity()
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new mxj(this);
    this.jdField_a_of_type_AndroidOsHandler = new mxm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new mxn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new mwu(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new mxa(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback = new mxf(this);
  }
  
  public static String a(long paramLong)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l1 = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l1);
    if (localTime1.year == localTime2.year) {
      return TimeFormatterUtils.a(paramLong, true, "MM-dd");
    }
    return TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd");
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    TroopBindPubAccountProtocol.a(this.app, paramLong, new mxb(this), localBundle);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, structmsg.StructMsg paramStructMsg, TroopNotificationUtils.TroopPrivilegeCallback paramTroopPrivilegeCallback)
  {
    if ((paramQQAppInterface == null) || (paramTroopPrivilegeCallback == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    TroopNotificationUtils.a(paramString, paramStructMsg);
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(paramQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(14);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    ProtoUtils.a(paramQQAppInterface, new mxc(paramString, paramContext, paramTroopPrivilegeCallback, paramStructMsg), ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray(), "OidbSvc.0x88d_0");
  }
  
  private void a(Card paramCard)
  {
    if (this.jdField_c_of_type_Int == 82) {}
    do
    {
      do
      {
        return;
        if (paramCard != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateSimpleInfo card is null!");
      return;
    } while ((this.jdField_r_of_type_AndroidWidgetTextView == null) || (this.jdField_s_of_type_AndroidWidgetTextView == null));
    this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject1 = "";
    label145:
    Object localObject2;
    boolean bool1;
    if (paramCard.shGender == 0)
    {
      localObject1 = getString(2131368209);
      this.jdField_r_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (paramCard.age <= 0) {
        break label545;
      }
      localObject1 = paramCard.age + getString(2131368211);
      this.jdField_s_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_s_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = "";
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCountry))
      {
        localObject1 = localObject2;
        if (!paramCard.strCountry.equals(getString(2131368573))) {
          localObject1 = paramCard.strCountry;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramCard.strProvince)) {
        localObject2 = (String)localObject1 + " " + paramCard.strProvince;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCity)) {
        localObject1 = (String)localObject2 + " " + paramCard.strCity;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_t_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_t_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
        this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      localObject1 = new SpannableStringBuilder();
      if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 22) && (this.jdField_c_of_type_Int != 60)) {
        break label587;
      }
      localObject2 = getResources();
      if (paramCard.bSuperVipOpen != 1) {
        break label575;
      }
      bool1 = true;
      label343:
      if (paramCard.bQQVipOpen != 1) {
        break label581;
      }
    }
    label545:
    label575:
    label581:
    for (boolean bool2 = true;; bool2 = false)
    {
      int i1 = paramCard.iQQVipLevel;
      TextView localTextView = (TextView)this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131300700);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i1 + ",QQLevel=" + paramCard.iQQLevel);
      }
      if ((bool1) || (bool2)) {
        ((SpannableStringBuilder)localObject1).append(QQSettingUtil.a(localTextView, (Resources)localObject2, bool1, bool2, Math.max(i1, 1)));
      }
      if (paramCard.iQQLevel >= 0) {
        ((SpannableStringBuilder)localObject1).append(ProfileCardUtil.a(this, 15, paramCard.iQQLevel, false));
      }
      this.jdField_k_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
      if (paramCard.shGender == 1)
      {
        localObject1 = getString(2131368210);
        break;
      }
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_s_of_type_AndroidWidgetTextView.setText("");
      this.jdField_s_of_type_AndroidWidgetTextView.setContentDescription("");
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
      break label145;
      bool1 = false;
      break label343;
    }
    label587:
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    long l1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (localList.size() < 0)
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get()).blacklist.set(true);
          this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get(), 0);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (paramInt < localList.size())
        {
          this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void j()
  {
    long l1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l1));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null)
    {
      finish();
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131300707);
    localLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    this.jdField_r_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    this.eC = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    this.G = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    this.H = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    label204:
    Object localObject1;
    Object localObject2;
    label458:
    int i2;
    int i1;
    if (this.H.startsWith(getString(2131367426)))
    {
      this.H = this.H.replace(getString(2131367426), "");
      setLeftViewName(2131367545);
      setTitle(a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131300682);
      this.jdField_b_of_type_AndroidViewView = ((LinearLayout)findViewById(2131300683));
      this.g = ((TextView)findViewById(2131300694));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300684));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300685));
      this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300687));
      this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300688));
      this.jdField_t_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300689));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300710));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131300691));
      this.jdField_u_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300692));
      this.v = ((TextView)findViewById(2131300693));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300709));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131300708));
      localObject1 = (ImageView)findViewById(2131300690);
      localObject2 = BitmapTools.b(BaseApplication.getContext(), 2130838201);
      if (localObject2 == null) {
        break label720;
      }
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300695));
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300696));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300699));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300701));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300703));
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131300704);
      if (localObject1 != null) {
        ((TextView)localObject1).setText(PublicAccountConfigUtil.a(this.app, getApplicationContext()));
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_i_of_type_Int] = this.jdField_d_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_j_of_type_Int] = this.jdField_e_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_k_of_type_Int] = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_l_of_type_Int] = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      int i3 = this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount();
      i2 = 0;
      i1 = 0;
      label624:
      if (i2 >= i3) {
        break label730;
      }
      if (!(this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i2) instanceof RelativeLayout)) {
        break label1823;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i2));
      i1 += 1;
    }
    label720:
    label730:
    label1161:
    label1424:
    label1496:
    label1736:
    label1748:
    label1781:
    label1817:
    label1821:
    label1823:
    for (;;)
    {
      i2 += 1;
      break label624;
      if (!this.H.startsWith(getString(2131367427))) {
        break label204;
      }
      this.H = this.H.replace(getString(2131367427), "");
      break label204;
      ((ImageView)localObject1).setImageResource(2130838201);
      break label458;
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300697));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300698));
      this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300705));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300700));
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300702));
      this.m = ((TextView)findViewById(2131300711));
      this.I = getIntent().getExtras().getString("troopMsgDealInfo");
      a();
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject1 != null) && (((List)localObject1).size() >= 2)) {
        if (this.jdField_c_of_type_Int == 82)
        {
          this.rightViewText.setVisibility(0);
          this.rightViewText.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
          this.rightViewText.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
          this.rightViewText.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(1)).detail_name.get());
          localObject2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
          this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(1)).detail_name.get());
          localLinearLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300706));
          if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get())) {
            break label1748;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131558891);
          this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838221);
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) || ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 22))) {
            break label1736;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          if ((localObject1 != null) && (((List)localObject1).size() == 1)) {
            this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          }
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.rightViewText.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.q = ((TextView)findViewById(2131300714));
          this.p = ((TextView)findViewById(2131300713));
          this.o = ((TextView)findViewById(2131300712));
          this.q.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          this.o.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          super.getString(2131368907);
          super.getString(2131368906);
          this.q.setVisibility(8);
          this.p.setVisibility(8);
          this.o.setVisibility(8);
          this.M = "";
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
            break label1817;
          }
          if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 22)) {
            break label1781;
          }
          this.M = this.G;
          this.N = "1";
          this.jdField_n_of_type_Int = 2131368911;
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          break label1821;
        }
        this.q.setVisibility(0);
        this.p.setVisibility(0);
        this.o.setVisibility(0);
        return;
        i1 = 0;
        if (i1 < ((List)localObject1).size())
        {
          localObject2 = ((structmsg.SystemMsgAction)((List)localObject1).get(i1)).detail_name.get();
          if (i1 != 0) {
            break label1496;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
          this.jdField_b_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject2);
        }
        for (;;)
        {
          localLinearLayout.setVisibility(0);
          i1 += 1;
          break label1424;
          break;
          if (i1 == 1)
          {
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
            this.jdField_a_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject2);
          }
          else if (i1 == 2)
          {
            this.rightViewText.setVisibility(0);
            this.rightViewText.setText((CharSequence)localObject2);
            this.rightViewText.setContentDescription((CharSequence)localObject2);
            this.rightViewText.setEnabled(true);
          }
        }
        if ((localObject1 != null) && (((List)localObject1).size() == 1))
        {
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_h_of_type_AndroidWidgetTextView.setTextAppearance(this, 2131558885);
          this.jdField_h_of_type_AndroidWidgetTextView.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
          this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
          this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundResource(2130838208);
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
        }
        if ((this.jdField_h_of_type_AndroidWidgetTextView == null) || (this.I.equals(""))) {
          break;
        }
        this.jdField_h_of_type_AndroidWidgetTextView.setTextAppearance(getApplicationContext(), 2131558585);
        this.jdField_h_of_type_AndroidWidgetTextView.setText(this.I);
        this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(this.I);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        break label1161;
        this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131558885);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838208);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        break label1161;
        if (this.jdField_c_of_type_Int == 2)
        {
          this.M = this.eC;
          this.N = "0";
          this.jdField_n_of_type_Int = 2131368912;
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
      }
      break;
    }
  }
  
  private void k()
  {
    startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_r_of_type_JavaLangString, this.B, this.jdField_a_of_type_Short, 0, this.J, this.K, null, null), 0);
  }
  
  public SpannableStringBuilder a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    String str;
    if (paramBoolean2)
    {
      i1 = paramString1.indexOf(paramString3);
      if (i1 > 0)
      {
        str = paramString1.substring(paramString3.length() + i1, paramString1.length());
        paramString1 = paramString1.substring(0, i1 + paramString3.length());
      }
    }
    for (;;)
    {
      Matcher localMatcher = Pattern.compile(paramString3).matcher(paramString1);
      if (!localMatcher.find()) {
        return null;
      }
      paramBoolean2 = paramString3.equals(getString(2131367429));
      paramString3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramString3);
      i1 = (int)(paramString3.density * 17.0F);
      paramString3 = new StringBuilder(paramString1);
      paramString3.insert(localMatcher.end(), " " + paramString2);
      paramString3 = new SpannableStringBuilder(paramString3.toString());
      int i2 = localMatcher.end() + " ".length();
      boolean bool = paramString1.contains("处理人");
      if (paramBoolean1)
      {
        paramString1 = new TroopRequestActivity.NumberSpan(this, bool, paramString2, paramString4, paramBoolean2);
        if (paramString2.length() + i2 > paramString3.length())
        {
          i1 = paramString3.length();
          paramString3.setSpan(paramString1, i2, i1, 33);
        }
      }
      else
      {
        if (localMatcher.end() <= paramString3.length()) {
          break label287;
        }
      }
      label287:
      for (i1 = paramString3.length();; i1 = localMatcher.end())
      {
        paramString3.delete(localMatcher.start(), i1);
        paramString3.append(str);
        return paramString3;
        i1 = paramString2.length() + i2;
        break;
      }
      str = "";
    }
  }
  
  public SpannableStringBuilder a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            if (!paramString.contains(getString(2131367426))) {
              break;
            }
            str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
          } while (TextUtils.isEmpty(str));
          return a(paramString, str, getString(2131367426), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", paramBoolean1, paramBoolean2);
          if (!paramString.contains(getString(2131367427))) {
            break;
          }
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        } while (TextUtils.isEmpty(str));
        return a(paramString, str, getString(2131367427), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get() + "", paramBoolean1, paramBoolean2);
        if (!paramString.contains(getString(2131367428))) {
          break;
        }
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
      } while (TextUtils.isEmpty(str));
      return a(paramString, str, getString(2131367428), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get() + "", paramBoolean1, paramBoolean2);
      if (!paramString.contains(getString(2131367429))) {
        break;
      }
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
    } while (TextUtils.isEmpty(str));
    return a(paramString, str, getString(2131367429), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", paramBoolean1, paramBoolean2);
    return new SpannableStringBuilder(paramString);
  }
  
  public String a(int paramInt)
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    switch (paramInt)
    {
    default: 
      return getString(2131364836);
    case 1: 
    case 22: 
      return getString(2131364827);
    case 2: 
      return getString(2131364828);
    case 11: 
      return getString(2131364831);
    case 12: 
      return getString(2131364830);
    case 10: 
      return getString(2131364829);
    case 3: 
      return getString(2131364832);
    case 15: 
    case 16: 
      return getString(2131364833);
    case 6: 
    case 7: 
      return getString(2131364834);
    case 13: 
      return getString(2131364835);
    case 82: 
      return getString(2131364842);
    }
    return getString(2131364837);
  }
  
  public void a()
  {
    b();
    switch (this.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      e();
      return;
      c();
      continue;
      d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    paramBitmap = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    if (paramString != null)
    {
      this.jdField_u_of_type_AndroidWidgetTextView.setVisibility(0);
      if (a(paramBitmap))
      {
        paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true, true);
        this.jdField_u_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_u_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
        break label136;
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int == 11) {}
      return;
      this.jdField_u_of_type_AndroidWidgetTextView.setText("");
      break;
      label136:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get())) {
        new StringBuilder().append(getResources().getString(2131367425)).append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get()).toString();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
    finish();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    }
  }
  
  boolean a(String paramString)
  {
    return (paramString.contains(getString(2131367426))) || (paramString.contains(getString(2131367428))) || (paramString.contains(getString(2131367429))) || (paramString.contains(getString(2131367427)));
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Int == 10) || (this.jdField_c_of_type_Int == 12)) {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.has())
      {
        this.jdField_s_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
        this.G = this.jdField_s_of_type_JavaLangString;
      }
    }
    label109:
    String str;
    label523:
    label580:
    label595:
    do
    {
      break label523;
      if ((this.jdField_c_of_type_Int == 12) || (this.jdField_c_of_type_Int == 35) || (this.jdField_c_of_type_Int == 10))
      {
        this.jdField_t_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8()))) {
          this.jdField_u_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8();
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.has())
        {
          this.jdField_u_of_type_AndroidWidgetTextView.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
          if (!a(str)) {
            break label580;
          }
          this.jdField_a_of_type_AndroidTextSpannableStringBuilder = a(str, true, true);
          this.jdField_u_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.has()) {
          this.E = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.has()) {
          this.jdField_b_of_type_Long = Long.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get()).longValue();
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.has()) {
          this.A = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.has()) {
          this.B = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get());
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) && (this.jdField_c_of_type_Int != 10)) {
          this.z = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.has()) {
          this.jdField_d_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.has())
        {
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get();
          if ((!str.contains("%action_uin%")) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.has())) {
            break label595;
          }
          this.x = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        }
        return;
        if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.has()) {
          break;
        }
        this.jdField_s_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        break;
        this.jdField_t_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        break label109;
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(str);
      }
    } while ((!str.contains("%actor_uin%")) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.has()));
    this.x = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
  }
  
  public void c()
  {
    Object localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_s_of_type_JavaLangString, 1);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    if ((this.jdField_c_of_type_Int == 10) || (this.jdField_c_of_type_Int == 12)) {
      this.D = (this.jdField_t_of_type_JavaLangString + getString(2131364587));
    }
    for (;;)
    {
      localObject = this.jdField_d_of_type_AndroidViewView$OnClickListener;
      this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.D);
      if (!TextUtils.isEmpty(this.jdField_t_of_type_JavaLangString)) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_t_of_type_JavaLangString);
      }
      try
      {
        if (this.app != null)
        {
          localObject = (FriendsManager)this.app.getManager(50);
          if (localObject != null)
          {
            localObject = ((FriendsManager)localObject).a(this.jdField_s_of_type_JavaLangString);
            if (localObject != null) {
              a((Card)localObject);
            }
            if ((localObject == null) || (((Card)localObject).iQQLevel <= 0))
            {
              localObject = (CardHandler)this.app.a(2);
              if (localObject != null) {
                ((CardHandler)localObject).a(this.app.a(), this.jdField_s_of_type_JavaLangString, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", 1L, 10004, new byte[] { 0 });
              }
            }
          }
        }
        if (!TextUtils.isEmpty(this.jdField_u_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
      catch (Exception localException)
      {
        try
        {
          do
          {
            for (;;)
            {
              localObject = URLDrawable.getDrawable(this.jdField_u_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
              this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new mwt(this));
              this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription("进入大图预览页面");
              if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
                break label613;
              }
              this.jdField_u_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
              if (this.jdField_c_of_type_Int == 80)
              {
                this.jdField_u_of_type_AndroidWidgetTextView.setMaxLines(3);
                this.jdField_u_of_type_AndroidWidgetTextView.setSingleLine(false);
              }
              if (!TextUtils.isEmpty(this.E)) {
                break label625;
              }
              this.v.setVisibility(8);
              if (this.jdField_b_of_type_Long != 0L)
              {
                localObject = a(this.jdField_b_of_type_Long * 1000L);
                this.g.setText((CharSequence)localObject);
              }
              if (TextUtils.isEmpty(this.x)) {
                break label647;
              }
              localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get().split("：");
              if (localObject.length > 0) {
                this.jdField_i_of_type_AndroidWidgetTextView.setText(localObject[0]);
              }
              this.jdField_j_of_type_AndroidWidgetTextView.setText(this.x);
              this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
              this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 22) && (this.jdField_c_of_type_Int != 60)) {
                break label659;
              }
              this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              if (TextUtils.isEmpty(this.z)) {
                break label671;
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              this.jdField_l_of_type_AndroidWidgetTextView.setText(this.z);
              return;
              this.D = (this.jdField_t_of_type_JavaLangString + getString(2131364586));
              break;
              this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_s_of_type_JavaLangString);
            }
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.w("TroopRequestActivity", 2, "getCard Exception! ");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, localIllegalArgumentException.toString());
            }
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            continue;
            label613:
            this.jdField_u_of_type_AndroidWidgetTextView.setText("");
            continue;
            label625:
            this.v.setText(this.E);
            this.v.setVisibility(0);
            continue;
            label647:
            this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            label659:
            this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          label671:
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
    }
  }
  
  public void d()
  {
    Object localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.A, 4);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.D = (this.B + getString(2131364585));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.D);
    if (TextUtils.isEmpty(this.B))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_r_of_type_JavaLangString);
      localObject = (TroopManager)this.app.getManager(51);
      if (localObject == null) {
        break label700;
      }
    }
    label197:
    label218:
    label262:
    label366:
    label419:
    label456:
    label568:
    label580:
    label602:
    label614:
    label626:
    label679:
    label700:
    for (localObject = ((TroopManager)localObject).a(String.valueOf(this.jdField_r_of_type_JavaLangString));; localObject = null)
    {
      if ((localObject != null) && (((TroopInfo)localObject).dwGroupClassExt != 0L))
      {
        localObject = GroupCatalogTool.a(BaseApplication.getContext()).a(this, Long.toString(((TroopInfo)localObject).dwGroupClassExt));
        if (localObject != null)
        {
          this.C = ((GroupCatalogBean)localObject).a();
          this.jdField_r_of_type_AndroidWidgetTextView.setText(this.C);
          this.jdField_r_of_type_AndroidWidgetTextView.setContentDescription(this.C);
          this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
          break label568;
        }
        this.jdField_u_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
        if (this.jdField_c_of_type_Int == 80)
        {
          this.jdField_u_of_type_AndroidWidgetTextView.setMaxLines(3);
          this.jdField_u_of_type_AndroidWidgetTextView.setSingleLine(false);
        }
        if (!TextUtils.isEmpty(this.E)) {
          break label580;
        }
        this.v.setVisibility(8);
        if (this.jdField_b_of_type_Long != 0L)
        {
          localObject = a(this.jdField_b_of_type_Long * 1000L);
          this.g.setText((CharSequence)localObject);
        }
        if (TextUtils.isEmpty(this.x)) {
          break label602;
        }
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get().split("：");
        if (localObject.length > 0) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(localObject[0]);
        }
        this.jdField_j_of_type_AndroidWidgetTextView.setText(this.x);
        this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 82) {
          break label679;
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.size() == 0) {
          break label614;
        }
        this.m.setVisibility(0);
        this.m.setText(this.I);
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label626;
        }
        this.jdField_n_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_n_of_type_AndroidWidgetTextView.setOnClickListener(new mxh(this));
        ReportController.b(this.app, "P_CliOper", "Grp_public", "", "oper", "exp_invite", 0, 0, "", "", "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      }
      for (;;)
      {
        e();
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.B);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null) {
          break label197;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.c(this.jdField_r_of_type_JavaLangString);
        break label197;
        this.jdField_u_of_type_AndroidWidgetTextView.setText("");
        break label218;
        this.v.setText(this.E);
        this.v.setVisibility(0);
        break label262;
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label366;
        this.m.setVisibility(8);
        break label419;
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_pubaccount", 2, "mStructMsg.msg.req_uin_nick is empty from StructMsg_IM.proto");
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        TroopBindPubAccountProtocol.a(this.app, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), new mxg(this));
        break label456;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.m.setVisibility(8);
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (-1 == paramInt2)
    {
      if (paramInt1 != 0) {
        break label21;
      }
      i();
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label21:
      if (paramInt1 != 1005) {}
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903928);
    setContentBackgroundResource(2130837958);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(20));
    j();
    if (getIntent().getExtras().getBoolean("groupman_refuse", false))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_c_of_type_Int == 82) {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_c_of_type_Int != 82) {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    super.doOnStop();
  }
  
  public void e()
  {
    int i1 = 0;
    int i2 = 0;
    if (i1 < jdField_h_of_type_Int)
    {
      int i3 = i2;
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[i1] != null)
      {
        i3 = i2;
        if (this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[i1].getVisibility() != 8)
        {
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          i3 = 1;
        }
      }
      if (i1 > 0)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[(i1 - 1)].getVisibility() != 8) {
          break label90;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[(i1 - 1)].setVisibility(8);
      }
      for (;;)
      {
        i1 += 1;
        i2 = i3;
        break;
        label90:
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[(i1 - 1)].setVisibility(0);
      }
    }
    if (i2 != 0)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    String str = "";
    if (this.jdField_n_of_type_Int != 0) {
      str = getString(this.jdField_n_of_type_Int);
    }
    localActionSheet.a(str);
    localActionSheet.a(getString(2131368910), 3);
    localActionSheet.a(new mxk(this, localActionSheet));
    localActionSheet.d(2131367262);
    localActionSheet.show();
  }
  
  public void g()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131367698), 3);
    localActionSheet.a(new mxl(this, localActionSheet));
    localActionSheet.d(2131367262);
    localActionSheet.show();
  }
  
  public void h()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369268);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
  
  public void i()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopRequestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */