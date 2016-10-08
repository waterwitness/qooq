package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import kjj;
import kjm;
import kjn;
import kjo;
import kjp;
import kjq;
import kjr;
import kjs;
import kjt;
import kju;
import kjv;
import kjw;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class AddRequestActivity
  extends DialogBaseActivity
  implements View.OnClickListener, AppConstants
{
  public static final int a = 1;
  public static final String a = "infoid";
  public static final int b = 2;
  public static final String b = "infouin";
  static final int jdField_c_of_type_Int = 2;
  public static final String c = "infonick";
  public static final String d = "infotime";
  public static final String e = "verify_msg";
  public static final String f = "verify_type";
  private static final int jdField_g_of_type_Int = 0;
  public static final String g = "msg_source";
  private static final int jdField_h_of_type_Int = 1;
  public static final String h = "msg_source_id";
  private static final int jdField_i_of_type_Int = 1;
  public static final String i = "msg_type";
  public static final String j = "sig";
  public static final String k = "lToMobile";
  public static final String l = "strNickName";
  public static final String m = "info_dealwith_msg";
  public static final String n = "msg_troopuin";
  public static final String o = "info_troopnickname";
  public static final String p = "msg_title";
  private static final String r = "Q.systemmsg.AddRequestActivity";
  protected float a;
  public long a;
  public Dialog a;
  final Handler jdField_a_of_type_AndroidOsHandler;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public CardHandler a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  public QQCustomDialog a;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  protected float b;
  private long jdField_b_of_type_Long;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private long jdField_c_of_type_Long;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public int d;
  private long jdField_d_of_type_Long;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private final int jdField_j_of_type_Int;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  public String q;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  
  public AddRequestActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.t = "";
    this.u = "";
    this.jdField_f_of_type_Int = 10004;
    this.v = "";
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new kjj(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new kjs(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new kjt(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new kju(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new kjv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new kjn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new kjo(this);
  }
  
  private void c(boolean paramBoolean)
  {
    int i2 = 0;
    b();
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302539));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302540));
    this.g = ((TextView)findViewById(2131302541));
    TextView localTextView = (TextView)findViewById(2131302550);
    Object localObject2 = (LinearLayout)findViewById(2131302543);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131302549);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296814));
    this.h = ((TextView)findViewById(2131296932));
    Object localObject3 = (TextView)findViewById(2131302544);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302552));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131300708));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131302545));
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))) {
      this.t = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    }
    TextPaint localTextPaint = ((TextView)localObject3).getPaint();
    Object localObject1 = localTextPaint;
    if (localTextPaint == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.mDensity;
    }
    float f1 = ((TextPaint)localObject1).measureText(this.t);
    label374:
    int i1;
    if (this.jdField_b_of_type_Float - f1 > 30.0F)
    {
      ((TextView)localObject3).setText(this.t);
      localObject1 = localObject3;
      ((LinearLayout)localObject2).setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((this.t == null) || (this.t.equals(""))) {
        break label590;
      }
      if ((this.u == null) || (this.u.equals(""))) {
        break label566;
      }
      ((LinearLayout)localObject2).setBackgroundResource(2130838355);
      if (((LinearLayout)localObject2).getVisibility() != 0) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      localTextView.setText(this.u);
      if (localLinearLayout.getVisibility() != 0) {
        localLinearLayout.setVisibility(0);
      }
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null)) {
        break label1435;
      }
      new ArrayList();
      localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label746;
      }
      i1 = 0;
      label448:
      if (i1 >= ((List)localObject2).size()) {
        break label764;
      }
      ((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get();
      if (i1 != 0) {
        break label704;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get());
    }
    for (;;)
    {
      i1 += 1;
      break label448;
      localObject2 = (LinearLayout)findViewById(2131302546);
      localObject1 = (TextView)findViewById(2131302547);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131302548));
      break;
      label566:
      ((LinearLayout)localObject2).setBackgroundResource(2130838352);
      ((LinearLayout)localObject2).setVisibility(0);
      localLinearLayout.setVisibility(8);
      break label374;
      label590:
      if ((this.t != null) && (!this.t.equals(""))) {
        break label374;
      }
      if ((this.u != null) && (!this.u.equals("")))
      {
        ((LinearLayout)localObject2).setVisibility(8);
        localTextView.setText(this.u);
        if (localLinearLayout.getVisibility() == 0) {
          break label374;
        }
        localLinearLayout.setVisibility(0);
        break label374;
      }
      localObject3 = (ViewGroup)findViewById(2131302537);
      ((View)localObject3).setBackgroundResource(2130838349);
      ((View)localObject3).setVisibility(0);
      ((LinearLayout)localObject2).setVisibility(8);
      localLinearLayout.setVisibility(8);
      break label374;
      label704:
      if (i1 == 1)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get());
      }
    }
    label746:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    label764:
    localObject2 = (TextView)findViewById(2131301810);
    if ((this.jdField_f_of_type_Int == 3014) || (this.jdField_f_of_type_Int == 2014))
    {
      ((TextView)localObject2).setVisibility(0);
      label802:
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300714));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300713));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300712));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null))
      {
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.has()) && (!"".equals(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get()))) {
          break label1466;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label960:
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has())) {}
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
      {
      case 4: 
      case 5: 
      default: 
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        label1057:
        this.i = ((TextView)findViewById(2131302538));
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
        {
          this.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
          this.i.setVisibility(0);
          label1155:
          localObject2 = ((FriendsManager)this.app.getManager(50)).c(this.s);
          if ((localObject2 == null) || (((Friends)localObject2).alias == null) || (((Friends)localObject2).alias.length() == 0))
          {
            localObject2 = this.app;
            localObject3 = this.app;
            ((FriendListHandler)((QQAppInterface)localObject2).a(1)).b(this.s);
          }
          if (TextUtils.isEmpty(this.q)) {
            break label1564;
          }
          this.h.setText(this.q);
          label1249:
          if ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007))
          {
            i1 = i2;
            if (this.jdField_f_of_type_Int != 2019) {}
          }
          else
          {
            localObject2 = (FriendsManager)this.app.getManager(50);
            if ((localObject2 == null) || (!((FriendsManager)localObject2).b(this.s))) {
              break label1578;
            }
            i1 = i2;
          }
          label1338:
          if (i1 == 0) {
            break label1584;
          }
          localObject2 = FaceDrawable.a(this.app, 200, this.s, true);
          label1360:
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject2);
          ((ViewGroup)findViewById(2131302537)).setOnClickListener(new kjp(this));
          ((TextView)localObject1).setText(StringUtil.b(this.t));
          if (this.jdField_e_of_type_Int != 2) {
            break label1601;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      label1435:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      ((TextView)localObject2).setVisibility(8);
      break label802;
      label1466:
      if ((!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() != 1)) {
        break label960;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label960;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      break label1057;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      break label1057;
      this.i.setVisibility(8);
      a();
      break label1155;
      label1564:
      this.h.setText(this.s);
      break label1249;
      label1578:
      i1 = 1;
      break label1338;
      label1584:
      localObject2 = FaceDrawable.a(this.app, 1, this.s);
      break label1360;
      label1601:
      if ((this.t == null) || ("".equals(this.t))) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc_w 444
    //   5: invokevirtual 193	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   8: putfield 446	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   11: aload_0
    //   12: aload_0
    //   13: ldc_w 447
    //   16: invokevirtual 193	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   19: checkcast 449	com/tencent/image/URLImageView
    //   22: putfield 451	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   25: aconst_null
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 171	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   33: ifnull +100 -> 133
    //   36: aload_2
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 171	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   42: getfield 234	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   45: getfield 455	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   48: invokevirtual 458	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   51: ifeq +82 -> 133
    //   54: aload_2
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 171	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   60: getfield 234	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   63: getfield 461	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   66: invokevirtual 462	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   69: ifeq +64 -> 133
    //   72: aload_2
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 171	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   78: getfield 234	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   81: getfield 461	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   84: invokevirtual 375	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   87: iconst_1
    //   88: if_icmpne +45 -> 133
    //   91: new 464	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo
    //   94: dup
    //   95: invokespecial 465	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:<init>	()V
    //   98: astore_2
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 171	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   104: getfield 234	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   107: getfield 455	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 468	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   113: invokevirtual 474	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   116: invokevirtual 478	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   119: pop
    //   120: new 480	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   123: dup
    //   124: invokespecial 481	com/tencent/mobileqq/businessCard/data/BusinessCard:<init>	()V
    //   127: astore_1
    //   128: aload_1
    //   129: aload_2
    //   130: invokestatic 486	com/tencent/mobileqq/businessCard/BusinessCardServlet:a	(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;Ltencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo;)V
    //   133: aload_1
    //   134: ifnull +108 -> 242
    //   137: aload_1
    //   138: getfield 489	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   141: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +98 -> 242
    //   147: aload_0
    //   148: getfield 446	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   151: iconst_0
    //   152: invokevirtual 341	android/view/View:setVisibility	(I)V
    //   155: aload_0
    //   156: getfield 451	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   159: iconst_0
    //   160: invokevirtual 490	com/tencent/image/URLImageView:setVisibility	(I)V
    //   163: aload_0
    //   164: invokevirtual 494	com/tencent/mobileqq/activity/AddRequestActivity:getResources	()Landroid/content/res/Resources;
    //   167: invokevirtual 500	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   170: getfield 505	android/util/DisplayMetrics:widthPixels	I
    //   173: aload_0
    //   174: ldc_w 506
    //   177: invokestatic 511	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   180: iconst_2
    //   181: imul
    //   182: isub
    //   183: istore_3
    //   184: iload_3
    //   185: sipush 600
    //   188: imul
    //   189: sipush 1000
    //   192: idiv
    //   193: istore 4
    //   195: aload_0
    //   196: getfield 451	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   199: invokevirtual 515	com/tencent/image/URLImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   202: checkcast 517	android/widget/LinearLayout$LayoutParams
    //   205: astore_2
    //   206: aload_2
    //   207: iload_3
    //   208: putfield 520	android/widget/LinearLayout$LayoutParams:width	I
    //   211: aload_2
    //   212: iload 4
    //   214: putfield 523	android/widget/LinearLayout$LayoutParams:height	I
    //   217: aload_0
    //   218: getfield 451	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   221: aload_2
    //   222: invokevirtual 527	com/tencent/image/URLImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   225: aload_1
    //   226: getfield 489	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   229: aload_0
    //   230: getfield 451	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   233: sipush 1000
    //   236: sipush 600
    //   239: invokestatic 532	com/tencent/mobileqq/businessCard/utilities/BusinessCardUtils:a	(Ljava/lang/String;Lcom/tencent/image/URLImageView;II)V
    //   242: return
    //   243: astore_1
    //   244: aconst_null
    //   245: astore_1
    //   246: invokestatic 537	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +12 -> 261
    //   252: ldc 64
    //   254: iconst_2
    //   255: ldc_w 539
    //   258: invokestatic 542	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: goto -128 -> 133
    //   264: astore_2
    //   265: goto -19 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	AddRequestActivity
    //   28	198	1	localObject1	Object
    //   243	1	1	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   245	1	1	localObject2	Object
    //   26	196	2	localObject3	Object
    //   264	1	2	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   183	25	3	i1	int
    //   193	20	4	i2	int
    // Exception table:
    //   from	to	target	type
    //   99	128	243	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   128	133	264	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    int i2 = -1;
    Card localCard = ((FriendsManager)this.app.getManager(50)).a(this.s);
    Object localObject1;
    if (localCard != null)
    {
      localObject1 = "";
      if ((localCard == null) || ((localCard.shGender != 0) && (localCard.shGender != 1))) {
        break label375;
      }
    }
    label337:
    label375:
    for (int i1 = localCard.shGender;; i1 = -1)
    {
      if (i1 == 0)
      {
        localObject1 = getString(2131368209);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject1 = "";
        i1 = i2;
        if (localCard != null) {
          i1 = localCard.age;
        }
        if (i1 <= 0) {
          break label337;
        }
        localObject1 = i1 + getString(2131368211);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject2 = "";
        localObject1 = localObject2;
        if (localCard.strProvince != null)
        {
          localObject1 = localObject2;
          if (localCard.strProvince.length() > 0) {
            localObject1 = "" + localCard.strProvince;
          }
        }
        localObject2 = localObject1;
        if (localCard.strCity != null)
        {
          localObject2 = localObject1;
          if (localCard.strCity.length() > 0) {
            localObject2 = (String)localObject1 + "" + localCard.strCity;
          }
        }
        this.g.setText((CharSequence)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.AddRequestActivity", 2, "age:" + localCard.age + "gender:" + localCard.shGender);
        }
        return;
        if (i1 == 1)
        {
          localObject1 = getString(2131368210);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject1 = this.app;
      Object localObject2 = this.app;
      ((FriendListHandler)((QQAppInterface)localObject1).a(1)).b(this.s);
      return;
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
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public void b()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mDensity = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i1 = getResources().getDimensionPixelSize(2131493014);
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i1 * 1 - 175.0F * this.mDensity);
  }
  
  public void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131367698), 3);
    localActionSheet.a(new kjq(this, localActionSheet));
    localActionSheet.d(2131367262);
    localActionSheet.show();
  }
  
  public void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131368911));
    localActionSheet.a(getString(2131368910), 3);
    localActionSheet.a(new kjr(this, localActionSheet));
    localActionSheet.d(2131367262);
    localActionSheet.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    long l1 = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
    this.jdField_b_of_type_Long = getIntent().getLongExtra("infoid", 0L);
    this.s = getIntent().getStringExtra("infouin");
    this.jdField_c_of_type_Long = getIntent().getLongExtra("infotime", 0L);
    this.t = getIntent().getStringExtra("verify_msg");
    this.jdField_e_of_type_Int = getIntent().getIntExtra("verify_type", 1);
    this.u = getIntent().getStringExtra("msg_source");
    this.jdField_f_of_type_Int = getIntent().getIntExtra("msg_source_id", 3041);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("msg_type", 64530);
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("sig");
    this.jdField_a_of_type_Long = getIntent().getLongExtra("lToMobile", 0L);
    this.q = getIntent().getStringExtra("strNickName");
    this.w = getIntent().getStringExtra("info_dealwith_msg");
    this.jdField_d_of_type_Long = getIntent().getLongExtra("msg_troopuin", 0L);
    this.v = getIntent().getStringExtra("msg_title");
    super.setContentView(2130904367);
    setContentBackgroundResource(2130837958);
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302553));
    if ((this.w != null) && (!this.w.equals("")))
    {
      this.jdField_j_of_type_AndroidWidgetTextView.setText(this.w);
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    setTitle(this.v);
    c(true);
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131367481), 0).b(getTitleBarHeight());
    }
    label761:
    for (;;)
    {
      return;
      int i2 = 0;
      int i1;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        if (this.jdField_d_of_type_Int == 64525)
        {
          ((FriendListHandler)this.app.a(1)).a(0, Long.parseLong(this.s), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, (byte)0, this.q, this.jdField_c_of_type_Long, this.jdField_b_of_type_Long);
          i1 = 1;
          ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          break label761;
        }
        a(2131368647, 1000L, false);
        return;
        long l1 = FriendSystemMsgController.a().b();
        paramView = FriendSystemMsgController.a().a(Long.valueOf(l1));
        long l2;
        int i3;
        int i4;
        int i5;
        Object localObject;
        if (paramView != null)
        {
          i1 = paramView.msg_type.get();
          l1 = paramView.msg_seq.get();
          l2 = paramView.req_uin.get();
          i2 = paramView.msg.sub_type.get();
          i3 = paramView.msg.src_id.get();
          i4 = paramView.msg.sub_src_id.get();
          i5 = paramView.msg.group_msg_type.get();
          localObject = paramView.msg.actions.get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
            ((structmsg.SystemMsgActionInfo)localObject).remark.set("");
            ((structmsg.SystemMsgActionInfo)localObject).group_id.set(0);
            structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
            localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
            localAddFrdSNInfo.uint32_set_sn.set(0);
            ((structmsg.SystemMsgActionInfo)localObject).addFrdSNInfo.set(localAddFrdSNInfo);
            this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)localObject, 0, paramView, false);
            i1 = 1;
            break;
          }
          paramView = new StringBuilder().append("agree, ");
          if (localObject != null) {}
          for (i1 = ((List)localObject).size();; i1 = -1)
          {
            QLog.d("Q.systemmsg.AddRequestActivity", 1, i1);
            i1 = 0;
            break;
          }
        }
        QLog.d("Q.systemmsg.AddRequestActivity", 1, "agree");
        i1 = 0;
        break;
        if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
        {
          l1 = FriendSystemMsgController.a().b();
          this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
          {
            i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
            l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
            l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
            i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
            i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
            i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
            int i6 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
            paramView = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
            if ((paramView != null) && (1 < paramView.size()))
            {
              this.app.a().a().a(i1, l1, l2, i3, i4, i5, i6, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get(), 1, null, false);
              i1 = 1;
            }
          }
          for (;;)
          {
            ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "0", "", "", "");
            break;
            localObject = new StringBuilder().append("refuse, ");
            if (paramView != null) {}
            for (i1 = paramView.size();; i1 = -1)
            {
              QLog.d("Q.systemmsg.AddRequestActivity", 1, i1);
              i1 = i2;
              break;
            }
            QLog.d("Q.systemmsg.AddRequestActivity", 1, "refuse");
            i1 = 0;
          }
        }
        i1 = 0;
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131367700)).setMessage(2131367701).setPositiveButton(2131367702, new kjm(this)).setNegativeButton(2131367976, new kjw(this));
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903052);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852)).setText(2131367717);
    return this.jdField_a_of_type_AndroidAppDialog;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AddRequestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */