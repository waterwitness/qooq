package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.newfriend.BaseSystemMsgInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import ojk;
import ojl;
import ojm;
import ojn;
import ojo;
import ojp;
import ojq;
import ojr;
import ojs;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class NotificationView
  extends BaseTroopView
  implements View.OnClickListener, BaseSystemMsgInterface, FaceDecoder.DecodeTaskCompletionListener, SlideDetectListView.OnScrollToTopListener, SlideDetectListView.OnSlideListener
{
  protected static final String a = "NotificationView";
  protected static int b = 0;
  protected static int c = 0;
  protected static long c = 0L;
  protected static final int d = 15;
  static final int e = 60;
  public static final int f = 1012;
  public static final int g = 1013;
  public static final int h = 1014;
  public static final int i = 998;
  public static final int j = 999;
  public static final int k = 1000;
  public static final int l = 1100;
  public static final int m = 1001;
  public static final int n = 1002;
  public static final int o = 1003;
  public static final int p = 1012;
  public static int s;
  public final long a;
  public Context a;
  protected Bitmap a;
  protected View.OnClickListener a;
  protected View.OnTouchListener a;
  public NotificationAdapter a;
  public TroopNotificationUtils.TroopPrivilegeCallback a;
  MessageObserver a;
  public FaceDecoder a;
  public QQProgressDialog a;
  protected SlideDetectListView.OnScrollToTopListener a;
  protected SlideDetectListView a;
  public List a;
  public MqqHandler a;
  public final long b;
  protected View.OnClickListener b;
  protected boolean c;
  public boolean d;
  public View e;
  protected View f;
  public int q = 0;
  public int r;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_Int = 1;
  }
  
  public NotificationView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_a_of_type_MqqOsMqqHandler = new ojk(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ojl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ojm(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ojn(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollToTopListener = new ojo(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ojq(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback = new ojs(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    TroopBindPubAccountProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new ojr(this), localBundle);
  }
  
  private void a(NotificationAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg)
  {
    if ((paramViewHolder == null) || (paramStructMsg == null)) {
      return;
    }
    switch (TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int))
    {
    default: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
  }
  
  private void a(XListView paramXListView, String paramString, Bitmap paramBitmap)
  {
    NotificationAdapter.ViewHolder localViewHolder;
    String str;
    if (this.q == 0)
    {
      int i2 = paramXListView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localViewHolder = (NotificationAdapter.ViewHolder)paramXListView.getChildAt(i1).getTag();
        if (localViewHolder == null) {
          i1 += 1;
        } else {
          switch (TroopNotificationUtils.a(localViewHolder.jdField_a_of_type_Int))
          {
          default: 
            str = String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localViewHolder != null) && (paramString.equals(str)))
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      str = localViewHolder.jdField_a_of_type_JavaLangString;
      continue;
      str = String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      GroupSystemMsgController.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      GroupSystemMsgController.a().b(l1);
      GroupSystemMsgController.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(0, paramBoolean);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 35) || (paramInt == 3) || (paramInt == 15) || (paramInt == 16) || (paramInt == 7);
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int i3;
    int i4;
    if (paramStructMsg != null)
    {
      int i1 = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int i2 = paramStructMsg.msg.sub_type.get();
      i3 = paramStructMsg.msg.src_id.get();
      i4 = paramStructMsg.msg.sub_src_id.get();
      int i5 = paramStructMsg.msg.group_msg_type.get();
      List localList = paramStructMsg.msg.actions.get();
      if ((localList == null) || (paramInt >= localList.size())) {
        break label218;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
    }
    label218:
    for (bool = true;; bool = false)
    {
      if ((i3 == 116) && (i4 == 0)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private void b(NotificationAdapter.ViewHolder paramViewHolder)
  {
    int i1 = 1;
    if (paramViewHolder == null) {
      return;
    }
    Object localObject;
    String str;
    switch (TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i1 = 4;
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131364585);
    }
    for (;;)
    {
      localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, (String)localObject, i1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramViewHolder.jdField_a_of_type_JavaLangString;
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131364586);
      continue;
      localObject = String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131364587);
    }
  }
  
  private void b(NotificationAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "jumpToTroopRequestActivity!" + paramViewHolder.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramViewHolder.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramViewHolder.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramViewHolder.jdField_b_of_type_Long);
      localIntent.putExtra("troopMsgDealInfo", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      a((structmsg.StructMsg)paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void m()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  private void n()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  private void o()
  {
    a(2130903691);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131299731));
    this.e = findViewById(2131299732);
    q();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
  }
  
  private void p()
  {
    int i1 = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter = new NotificationAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, i1, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.aw, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDividerHeight(1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "initListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a(this.jdField_a_of_type_JavaUtilList);
    k();
  }
  
  private void q()
  {
    if (this.f == null) {
      this.f = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904370, null);
    }
    if (this.f.getParent() == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(this.f);
    }
    this.f.setVisibility(8);
  }
  
  private void r()
  {
    if (this.d) {}
    do
    {
      do
      {
        return;
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367256), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_JavaUtilList.size() < 10) || (GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.d = true;
      this.f.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().g();
    } while (!QLog.isColorLevel());
    QLog.i("NotificationView", 2, "loadNextPage.get next page.");
  }
  
  private void s()
  {
    if (this.f != null) {
      this.f.setVisibility(8);
    }
    this.d = false;
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "stopLoadMore().");
    }
  }
  
  private void t()
  {
    ThreadManager.a(new ojp(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "sendReadConfirm is end!");
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131492908);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, paramString, paramBitmap);
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    m();
    o();
    p();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollToTopListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (TroopNotificationUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
    }
    TroopNotificationUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(NotificationAdapter.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "handleGroupSystemMsg! start " + paramViewHolder.jdField_a_of_type_Long);
    }
    b(paramViewHolder, 998);
    String str6 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = "";
    String str5 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str3 = "";
    String str2 = "";
    String str1;
    int i1;
    label159:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int)
    {
      str1 = "1";
      i1 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i1 != 2) && (i1 != 3)) {
        break label324;
      }
      i1 = 0;
      localObject1 = str4;
      localObject2 = str3;
      localObject3 = str2;
      switch (paramViewHolder.jdField_a_of_type_Int)
      {
      default: 
        localObject3 = str2;
        localObject2 = str3;
        localObject1 = str4;
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", (String)localObject1, 0, 0, str5, str1, (String)localObject2, (String)localObject3);
      return;
      str1 = "0";
      break;
      label324:
      i1 = 1;
      break label159;
      localObject3 = "enter_askjoin";
      if ((str6 == null) || ("".equals(str6))) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label394;
        }
        paramViewHolder = "0";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = paramViewHolder;
        break;
      }
      label394:
      long l1 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l1 != 0L) && (!(l1 + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {}
      for (paramViewHolder = "2";; paramViewHolder = "1")
      {
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = paramViewHolder;
        break;
      }
      localObject1 = "refuseask_page";
      localObject2 = str3;
      localObject3 = str2;
      continue;
      if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "enter_invite";
        localObject2 = str3;
        localObject3 = paramViewHolder;
        break;
      }
      if (i1 != 0) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "refuseinvite_page";
        localObject2 = paramViewHolder;
        localObject3 = str2;
        break;
      }
      if (i1 != 0) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "refuseagree_page";
        localObject2 = paramViewHolder;
        localObject3 = str2;
        break;
      }
      localObject1 = "quit_page";
      localObject2 = str3;
      localObject3 = str2;
      continue;
      localObject1 = "byquit_page";
      localObject2 = "0";
      localObject3 = str2;
      continue;
      localObject1 = "byquit_page";
      localObject2 = "1";
      localObject3 = str2;
      continue;
      if ((paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "set_admin_page";
        localObject2 = paramViewHolder;
        localObject3 = str2;
        break;
      }
      localObject1 = "un_admin_page";
      localObject2 = "0";
      localObject3 = str2;
      continue;
      localObject1 = "un_admin_page";
      localObject2 = "1";
      localObject3 = str2;
    }
  }
  
  public void a(NotificationAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "bindTroopSystemMsgView! start " + paramViewHolder.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramViewHolder.jdField_a_of_type_Long = paramInt;
    paramViewHolder.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramViewHolder.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    int i1 = localStructMsg.msg.sub_type.get();
    paramViewHolder.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramViewHolder.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    label218:
    label276:
    String str;
    Object localObject1;
    label348:
    Object localObject2;
    if ((paramViewHolder.jdField_b_of_type_JavaLangString != null) && (!paramViewHolder.jdField_b_of_type_JavaLangString.equals("")))
    {
      a(paramViewHolder, localStructMsg);
      switch (paramViewHolder.jdField_a_of_type_Int)
      {
      default: 
        paramInt = 0;
        if ((paramInt != 0) && ((localStructMsg.msg.group_ext_flag.get() & 0x800) != 0)) {
          if (localStructMsg.msg.group_info.group_auth_type.get() == 2)
          {
            paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838906);
            str = localStructMsg.msg.group_info.msg_alert.get();
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131558582);
            if ((TextUtils.isEmpty(str)) || ((paramViewHolder.jdField_a_of_type_Int != 1) && (paramViewHolder.jdField_a_of_type_Int != 22))) {
              break label859;
            }
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131558583);
            localObject1 = str;
            if (paramViewHolder.jdField_a_of_type_Int == 11)
            {
              localObject2 = localStructMsg.msg.msg_additional.get();
              localObject1 = localObject2;
              if (((String)localObject2).length() > 15) {
                localObject1 = ((String)localObject2).subSequence(0, 15) + "...";
              }
            }
            localObject2 = localObject1;
            if (localStructMsg.msg.pic_url.has())
            {
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label999;
              }
              localObject2 = "[图片]" + (String)localObject1;
            }
            label457:
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1007;
            }
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            label490:
            localObject1 = TroopUtils.a(localStructMsg, localStructMsg.msg.msg_describe.get());
            if (localObject1 == null) {
              break label1019;
            }
            paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            label519:
            if (paramViewHolder.jdField_a_of_type_Int != 80) {
              break label1076;
            }
            localObject1 = localStructMsg.msg.actions.get();
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).name.get());
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131558881);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838232);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            label647:
            if (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText())) {
              break label1389;
            }
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
        }
        break;
      }
    }
    for (;;)
    {
      if ((i1 == 2) && (paramViewHolder.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        TroopRemindSettingManager.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      b(paramViewHolder);
      return;
      paramViewHolder.jdField_b_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
      break;
      paramInt = 1;
      break label218;
      if (localStructMsg.msg.group_info.group_auth_type.get() == 1)
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839365);
        break label276;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label276;
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label276;
      label859:
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_qna.get()))
      {
        localObject1 = localStructMsg.msg.msg_qna.get();
        break label348;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_actor_describe.get()))
      {
        localObject1 = TroopUtils.a(localStructMsg, localStructMsg.msg.msg_actor_describe.get());
        break label348;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional_list.get()))
      {
        localObject1 = localStructMsg.msg.msg_additional_list.get();
        break label348;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional.get()))
      {
        localObject1 = localStructMsg.msg.msg_additional.get();
        break label348;
      }
      localObject1 = "";
      break label348;
      label999:
      localObject2 = "[图片]";
      break label457;
      label1007:
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label490;
      label1019:
      localObject1 = localStructMsg.msg.msg_additional.get();
      if ((localObject1 == null) || ("".equals(localObject1)))
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131364249));
        break label519;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      break label519;
      label1076:
      if (i1 == 1)
      {
        localObject1 = localStructMsg.msg.actions.get();
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (((List)localObject1).size() > 1)
            {
              paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(1)).name.get());
              paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131558881);
              paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838232);
            }
          }
          for (;;)
          {
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).name.get());
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131558895);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838231);
          }
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label647;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131558584);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      localObject1 = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      break label647;
      label1389:
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
    if ((localViewHolder != null) && ((localViewHolder instanceof NotificationAdapter.ViewHolder)))
    {
      paramView = (ShaderAnimLayout)paramView.findViewById(2131299729);
      if (paramView != null) {
        break label38;
      }
    }
    label38:
    Button localButton;
    do
    {
      return;
      localButton = (Button)paramView.findViewById(2131299730);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramView.a();
    localButton.setTag(localViewHolder);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.m() > 0)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - 1);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      int i1 = arrayOfInt[1];
      if (paramFloat > localView.getMeasuredHeight() + i1) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.aC, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0))
    {
      k();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.notifyDataSetChanged();
      t();
    }
    a(false);
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131299729);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.d();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131299730);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  protected void d()
  {
    super.d();
    a(false);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.notifyDataSetChanged();
    }
  }
  
  protected void f()
  {
    super.f();
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
  }
  
  protected void h()
  {
    super.h();
    n();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter = null;
    }
    TroopNotificationUtils.b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0)) {
      t();
    }
    if (this.jdField_c_of_type_Boolean) {
      GroupSystemMsgController.a().b();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0)) {
      t();
    }
    this.jdField_c_of_type_Boolean = true;
    super.i();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
  }
  
  public void l()
  {
    t();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if ((l1 - jdField_c_of_type_Long > 0L) && (l1 - jdField_c_of_type_Long < 800L)) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        jdField_c_of_type_Long = l1;
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (!(paramView.getTag() instanceof NotificationAdapter.ViewHolder));
      localObject1 = (NotificationAdapter.ViewHolder)paramView.getTag();
    } while (localObject1 == null);
    Object localObject2 = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    int i1 = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_Int;
    if (TroopNotificationUtils.a(i1) == 0)
    {
      paramView = TroopInfoActivity.a(String.valueOf(((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
      paramView.putInt("t_s_f", 1001);
      ChatSettingForTroop.a(a(), paramView, 2);
      if ((i1 == 2) || (i1 == 10) || (i1 == 12))
      {
        i1 = 1;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
        if (i1 == 0) {
          break label244;
        }
      }
      label244:
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject1, paramView, "", "");
        return;
        i1 = 0;
        break;
      }
    }
    if (((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_Int == 82)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
      paramView.putExtra("uin", ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      paramView.putExtra("source", 112);
      a(paramView);
      return;
    }
    l1 = ((structmsg.StructMsg)localObject2).req_uin.get();
    switch (TroopNotificationUtils.a(i1))
    {
    default: 
      paramView = String.valueOf(l1);
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramView)) {
        paramView = new ProfileActivity.AllInOne(paramView, 1);
      }
      break;
    }
    for (;;)
    {
      ProfileActivity.b(a(), paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", "3", "", "");
      return;
      paramView = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangString;
      break;
      paramView = String.valueOf(((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break;
      if ((((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject2).msg.sub_type.get() == 3))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 26);
        paramView.d = 1;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(paramView, 24);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\troop\NotificationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */