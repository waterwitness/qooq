package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class RecentItemTroopMsgData
  extends RecentUserBaseData
{
  public static final String a = "[topic]";
  private static final String j = RecentItemTroopMsgData.class.getSimpleName();
  protected int P;
  public long a;
  public boolean c;
  private boolean d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecentItemTroopMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_a_of_type_Long = 5L;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    try
    {
      l = Long.parseLong(a());
      this.jdField_a_of_type_Boolean = paramQQAppInterface.a().c(l);
      boolean bool = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = paramQQAppInterface.a().b(l);
      Object localObject;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = (TroopVideoManager)paramQQAppInterface.getManager(163);
        if ((localObject != null) && (((TroopVideoManager)localObject).a(a()) == 2)) {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      if ((this.jdField_b_of_type_Boolean) && (!bool))
      {
        localObject = String.valueOf(l);
        ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, "" + TroopUtils.a(paramQQAppInterface, (String)localObject), "", "");
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject3 = paramQQAppInterface.a();
    Object localObject1 = null;
    if (localObject3 != null)
    {
      localObject2 = ((QQMessageFacade)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      localObject1 = localObject2;
      if (HotChatUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, false))
      {
        localObject3 = ((QQMessageFacade)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 1026);
        if (localObject3 == null) {
          break label1011;
        }
        if (QLog.isColorLevel())
        {
          long l1 = ((QQMessageFacade.Message)localObject3).shmsgseq;
          long l2 = ((QQMessageFacade.Message)localObject3).time;
          if (localObject2 != null) {
            break label999;
          }
          localObject1 = "msg is null";
          NearbyUtils.a("PttShow", new Object[] { "RecentItemTroopMsgData_update", "hcLastMsg", Long.valueOf(l1), Long.valueOf(l2), localObject1 });
        }
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((QQMessageFacade.Message)localObject3).time <= ((QQMessageFacade.Message)localObject2).time) {}
        }
        else
        {
          if ((((QQMessageFacade.Message)localObject3).nickName == null) || (((QQMessageFacade.Message)localObject3).nickName.equals(((QQMessageFacade.Message)localObject3).senderuin)))
          {
            localObject1 = paramQQAppInterface.a(true).a(true);
            ((PttShowRoomMng)localObject1).a((MessageRecord)localObject3);
            ((QQMessageFacade.Message)localObject3).nickName = ((PttShowRoomMng)localObject1).a(((QQMessageFacade.Message)localObject3).senderuin);
          }
          localObject1 = localObject3;
        }
      }
    }
    label235:
    if (localObject1 != null)
    {
      this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = paramQQAppInterface.a();
      if (localObject2 != null)
      {
        this.H = ((ConversationFacade)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
        if (HotChatUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, false))
        {
          i = ((ConversationFacade)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, 1026);
          if (QLog.isColorLevel()) {
            NearbyUtils.a("PttShow", new Object[] { "RecentItemTroopMsgData_update", "unread", Integer.valueOf(i), Integer.valueOf(this.H) });
          }
          this.H = (i + this.H);
        }
      }
    }
    TroopManager localTroopManager;
    label892:
    boolean bool;
    for (;;)
    {
      localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
      HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(59);
      HotChatInfo localHotChatInfo = localHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if (localHotChatInfo == null) {
        break label1067;
      }
      this.G = 3;
      this.jdField_b_of_type_JavaLangString = localHotChatInfo.name;
      localObject2 = null;
      MsgSummary localMsgSummary = a();
      a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
      if ((localHotChatInfo == null) && (paramQQAppInterface.a != null) && (paramQQAppInterface.a.a() == 1) && (android.text.TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence)) && (android.text.TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)))
      {
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = "";
        }
        localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject3);
      }
      a(paramQQAppInterface);
      a(paramQQAppInterface, localMsgSummary);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      if ((localMsgSummary.jdField_a_of_type_Boolean) && (a().msg == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(j + ".troop.special_msg.special_attention", 2, "msgSummary.bShowDraft && (null == getRecentUser().msg)");
        }
        this.jdField_c_of_type_JavaLangCharSequence = "";
      }
      if (!localMsgSummary.jdField_a_of_type_Boolean) {
        b(paramQQAppInterface, paramContext);
      }
      if (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
      {
        paramQQAppInterface = localHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if ((paramQQAppInterface != null) && (!android.text.TextUtils.isEmpty(paramQQAppInterface.memo)) && (!paramQQAppInterface.memoShowed))
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131367761);
          this.J = paramContext.getResources().getColor(2131428324);
        }
      }
      if ((android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) && (localObject1 != null) && (localMsgSummary != null) && (AnonymousChatHelper.a((MessageRecord)localObject1))) {
        this.jdField_b_of_type_JavaLangCharSequence = localMsgSummary.a(paramContext, paramContext.getResources().getString(2131364731), -1);
      }
      paramQQAppInterface = a();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
        paramQQAppInterface.reParse();
      }
      TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_b_of_type_Long);
      if (localTroopManager != null)
      {
        paramQQAppInterface = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (paramQQAppInterface != null)
        {
          this.jdField_a_of_type_Long = paramQQAppInterface.troopCreditLevel;
          if (this.jdField_a_of_type_Long == 0L) {
            this.jdField_a_of_type_Long = 5L;
          }
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.act", 2, "RecentItemTroopMsgData->update," + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + "," + this.jdField_a_of_type_Long);
          }
        }
      }
      if (AppSetting.j)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
        if (this.H != 0) {
          break label1247;
        }
        if (this.jdField_c_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(com.tencent.mobileqq.text.TextUtils.c(this.jdField_b_of_type_JavaLangCharSequence.toString())).append(",").append(this.jdField_c_of_type_JavaLangString);
        this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      }
      paramQQAppInterface = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if ((paramQQAppInterface == null) || (!paramQQAppInterface.hasOrgs())) {
        break label1316;
      }
      bool = true;
      label992:
      this.jdField_d_of_type_Boolean = bool;
      return;
      label999:
      localObject1 = Long.valueOf(((QQMessageFacade.Message)localObject2).time);
      break;
      label1011:
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label235;
      }
      NearbyUtils.a("PttShow", new Object[] { "RecentItemTroopMsgData_update", "no hc topic msg" });
      localObject1 = localObject2;
      break label235;
      this.H = 0;
      continue;
      this.jdField_b_of_type_Long = 0L;
      this.H = 0;
    }
    label1067:
    int i = this.K;
    Object localObject2 = null;
    if (localTroopManager != null) {
      localObject2 = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
    }
    if (localObject2 != null)
    {
      localObject3 = ((TroopInfo)localObject2).troopname;
      localObject2 = ((TroopInfo)localObject2).troopmemo;
    }
    for (;;)
    {
      this.K = (i & 0xF0FF | 0x100);
      i = paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if ((i == 1) || (this.jdField_c_of_type_Boolean))
      {
        this.G = 1;
        label1159:
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject3)) {
          break label1238;
        }
      }
      label1238:
      for (this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);; this.jdField_b_of_type_JavaLangString = ((String)localObject3))
      {
        if ((localObject1 != null) && (android.text.TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName))) {
          ((QQMessageFacade.Message)localObject1).nickName = ((QQMessageFacade.Message)localObject1).senderuin;
        }
        d();
        break;
        if ((i != 2) && (i != 3) && (i != 4)) {
          break label1159;
        }
        this.G = 3;
        break label1159;
      }
      label1247:
      if (this.H == 1)
      {
        paramQQAppInterface.append("有一条未读");
        break label892;
      }
      if (this.H == 2)
      {
        paramQQAppInterface.append("有两条未读");
        break label892;
      }
      if (this.H <= 0) {
        break label892;
      }
      paramQQAppInterface.append("有").append(this.H).append("条未读,");
      break label892;
      label1316:
      bool = false;
      break label992;
      localObject2 = null;
      localObject3 = null;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser == null) {}
    label552:
    label556:
    for (;;)
    {
      return;
      Object localObject1 = (TroopInfoManager)paramQQAppInterface.getManager(36);
      Object localObject2 = a().msg;
      AbstructRecentUserMsg localAbstructRecentUserMsg;
      int i;
      if (localObject2 != null)
      {
        if (!(localObject2 instanceof AbstructRecentUserMsg)) {
          break label552;
        }
        if ((this.H == 0) && (!(localObject2 instanceof TroopNotificationMsg)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(j, 2, "dealMsgAttention, mUnreadNum:" + this.H);
          }
          this.jdField_c_of_type_JavaLangCharSequence = "";
          this.jdField_d_of_type_JavaLangString = "";
          return;
        }
        localAbstructRecentUserMsg = (AbstructRecentUserMsg)localObject2;
        this.jdField_c_of_type_JavaLangCharSequence = localAbstructRecentUserMsg.a;
        this.jdField_d_of_type_JavaLangString = localAbstructRecentUserMsg.jdField_b_of_type_JavaLangString;
        long l = ((TroopInfoManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        localObject1 = null;
        if (l != 0L) {
          localObject1 = paramQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, l);
        }
        if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject1))
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372047);
          this.jdField_d_of_type_JavaLangString = paramContext.getString(2131372047);
          i = 2131428324;
        }
      }
      for (;;)
      {
        if ((android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) || (i <= 0)) {
          break label556;
        }
        this.J = paramContext.getResources().getColor(i);
        return;
        if ((localObject2 instanceof TroopAtAllMsg))
        {
          this.jdField_d_of_type_JavaLangString = String.format("与%s群的会话，有全体消息", new Object[] { this.jdField_b_of_type_JavaLangString });
          break;
        }
        if (!(a().msg instanceof TroopNotificationMsg)) {
          break;
        }
        if (((TroopNotificationMsg)a().msg).c == 1)
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131367764);
          break;
        }
        if ((TroopNotificationHelper.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) || (TroopNotificationHelper.c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
        {
          this.jdField_c_of_type_JavaLangCharSequence = localAbstructRecentUserMsg.a;
          break;
        }
        this.jdField_c_of_type_JavaLangCharSequence = "";
        break;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131365310);
        }
        for (int k = 2131428324;; k = 0)
        {
          int m = ((TroopInfoManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if (QLog.isColorLevel()) {
            QLog.d(j, 2, "dealMsgAttention, navigateMsgType:" + m + ", mUnreadNum:" + this.H);
          }
          i = k;
          if (m != 10) {
            break;
          }
          i = k;
          if (this.H == 0) {
            break;
          }
          paramQQAppInterface = ((TroopInfoManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 10);
          i = k;
          if (paramQQAppInterface == null) {
            break;
          }
          i = k;
          if (paramQQAppInterface.size() == 0) {
            break;
          }
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131367404);
          this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangCharSequence.toString();
          i = 2131428324;
          break;
          this.jdField_c_of_type_JavaLangCharSequence = "";
          this.jdField_d_of_type_JavaLangString = "";
        }
        i = 0;
      }
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    MsgSummary localMsgSummary = new MsgSummary();
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    if (localRecentUserProxy != null) {
      localRecentUserProxy.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
    }
    localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "正在加载热聊信息。。。";
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
    a(paramQQAppInterface, paramContext, localMsgSummary);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemTroopMsgData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */