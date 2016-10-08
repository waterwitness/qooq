package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemMsgBox
  extends RecentUserBaseData
{
  private QQMessageFacade.Message a;
  
  public RecentItemMsgBox(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null) {
      localObject1 = localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
    }
    ConversationFacade localConversationFacade = paramQQAppInterface.a();
    if ((localConversationFacade != null) && (localObject1 != null))
    {
      this.H = localConversationFacade.a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      if (localObject1 != null) {
        break label1981;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = new QQMessageFacade.Message();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
      localObject3 = localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "msg is null: " + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + "," + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      }
    }
    label269:
    label294:
    label432:
    label499:
    label541:
    label674:
    label837:
    label899:
    label1023:
    label1273:
    label1276:
    label1352:
    label1369:
    label1528:
    label1530:
    label1897:
    label1903:
    String str;
    label1909:
    label1921:
    label1965:
    label1971:
    label1981:
    for (Object localObject3 = localObject1;; localObject3 = str)
    {
      MsgSummary localMsgSummary = a();
      localObject1 = null;
      Object localObject2;
      if (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject3).senderuin))
      {
        localObject2 = ((QQMessageFacade.Message)localObject3).senderuin;
        if ((!AppConstants.ar.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (!AppConstants.aH.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
        {
          localObject1 = localObject2;
          if (!AppConstants.ag.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {}
        }
        else
        {
          if (!AppConstants.ag.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            break label899;
          }
          localObject1 = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject3).senderuin, true);
        }
      }
      int k;
      int m;
      int i1;
      int n;
      int j;
      int i;
      if ((((QQMessageFacade.Message)localObject3).getMessageText() != null) || (((QQMessageFacade.Message)localObject3).msgData != null))
      {
        this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject3).time;
        k = 0;
        m = 0;
        i1 = 0;
        n = 0;
        j = m;
        i = k;
        if (!AppConstants.ar.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
          break label1971;
        }
        j = m;
        i = k;
        if (localConversationFacade == null) {
          break label1971;
        }
        if (((QQMessageFacade.Message)localObject3).isSend()) {
          break label1023;
        }
        m = localConversationFacade.e(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 1001);
        j = m;
        i = k;
        if (m != 0) {
          break label1971;
        }
        k = localConversationFacade.d(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 1001);
        j = m;
        i = k;
        if (k > 0) {
          break label1971;
        }
        i = localConversationFacade.a((MessageRecord)localObject3);
        j = m;
        m = k;
        k = i;
      }
      for (;;)
      {
        if (j > 0)
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131372040);
          this.J = paramContext.getResources().getColor(2131428324);
          localMsgSummary.b = localConversationFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 1001, paramContext.getResources().getString(2131372041), 0);
          i = 0;
          localObject1 = "";
          if ((((QQMessageFacade.Message)localObject3).msgtype != 64512) && (((QQMessageFacade.Message)localObject3).msgtype != 61525) && (i <= 0) && (j <= 0) && (m <= 0) && (k <= 0)) {
            break label1276;
          }
          if (!AppConstants.ar.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            break label1530;
          }
          if (((QQMessageFacade.Message)localObject3).msgtype != 61525) {
            break label1369;
          }
          this.jdField_b_of_type_JavaLangString = paramContext.getString(2131368291);
        }
        try
        {
          localObject1 = new MessageForNearbyRecommenderTips();
          ((MessageForNearbyRecommenderTips)localObject1).msgData = ((QQMessageFacade.Message)localObject3).msgData;
          ((MessageForNearbyRecommenderTips)localObject1).parse();
          localMsgSummary.b = paramContext.getResources().getString(2131371572);
          if ((((MessageForNearbyRecommenderTips)localObject1).strBrief != null) && (!"".equals(((MessageForNearbyRecommenderTips)localObject1).strBrief))) {
            localMsgSummary.b = ((MessageForNearbyRecommenderTips)localObject1).strBrief;
          }
          if (((MessageForNearbyRecommenderTips)localObject1).readFlag) {
            break label1352;
          }
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131371573);
          this.J = paramContext.getResources().getColor(2131428324);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + ",type:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type + ",sayHelloNum:" + i + ",unreadNum:" + this.H + ",unReadRedPacketCount:" + j + "]");
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.j)
        {
          paramContext = localMsgSummary.b;
          paramQQAppInterface = paramContext;
          if (TextUtils.isEmpty(paramContext)) {
            paramQQAppInterface = this.jdField_c_of_type_JavaLangCharSequence;
          }
          paramContext = paramQQAppInterface;
          if (paramQQAppInterface == null) {
            paramContext = "";
          }
          if (this.H <= 0) {
            break label1909;
          }
          if (this.jdField_b_of_type_JavaLangString == null) {
            break label1897;
          }
          paramQQAppInterface = this.jdField_b_of_type_JavaLangString;
          if (this.jdField_c_of_type_JavaLangString == null) {
            break label1903;
          }
        }
        for (localObject1 = this.jdField_c_of_type_JavaLangString;; str = "")
        {
          paramQQAppInterface = String.format("%s,%s,%d条未读,%s", new Object[] { paramQQAppInterface, localObject1, Integer.valueOf(this.H), paramContext });
          this.d = paramQQAppInterface;
          d();
          return;
          this.H = 0;
          break;
          if (MsgProxyUtils.c(((QQMessageFacade.Message)localObject3).senderuin))
          {
            localObject1 = localObject2;
            if (localQQMessageFacade == null) {
              break label269;
            }
            QQMessageFacade.Message localMessage = localQQMessageFacade.a(((QQMessageFacade.Message)localObject3).senderuin, ((QQMessageFacade.Message)localObject3).istroop);
            localObject1 = localObject2;
            if (localMessage == null) {
              break label269;
            }
            localObject2 = ContactUtils.o(paramQQAppInterface, localMessage.senderuin);
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label269;
            }
            localObject1 = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, false);
            break label269;
          }
          localObject2 = ContactUtils.o(paramQQAppInterface, ((QQMessageFacade.Message)localObject3).senderuin);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label269;
          }
          localObject1 = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject3).senderuin, false);
          break label269;
          this.jdField_b_of_type_Long = 0L;
          break label294;
          k = localConversationFacade.a((MessageRecord)localObject3);
          j = 0;
          m = 0;
          break label432;
          if ((m > 0) || (k > 0))
          {
            if (m > 0)
            {
              this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372099, new Object[] { Integer.valueOf(m) });
              this.J = paramContext.getResources().getColor(2131428324);
              i = 0;
              localObject1 = "";
              break label499;
            }
            i = i1;
            if (k <= 0) {
              break label1273;
            }
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = "";
            }
            if ((localObject3 != null) && (!((QQMessageFacade.Message)localObject3).isSend())) {}
            for (this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372101, new Object[] { localObject2, Integer.valueOf(k) });; this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372102, new Object[] { Integer.valueOf(k) }))
            {
              this.J = paramContext.getResources().getColor(2131428302);
              i = 0;
              localObject1 = "";
              break;
            }
          }
          i = n;
          if (localConversationFacade != null) {
            i = localConversationFacade.b(((QQMessageFacade.Message)localObject3).istroop);
          }
          if (i > 0)
          {
            this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372113);
            this.J = paramContext.getResources().getColor(2131428324);
            break label499;
          }
          this.jdField_c_of_type_JavaLangCharSequence = "";
          break label499;
          boolean bool = false;
          if (AppConstants.ar.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            bool = true;
          }
          if (((QQMessageFacade.Message)localObject3).isSend())
          {
            MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject3, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, null, bool, false);
            break label541;
          }
          MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject3, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, (String)localObject1, bool, false);
          break label541;
          this.jdField_c_of_type_JavaLangCharSequence = "";
          break label674;
          this.jdField_b_of_type_JavaLangString = paramContext.getString(2131368291);
          if (localQQMessageFacade != null)
          {
            this.G = 1;
            this.H = localConversationFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
            if ((this.H <= 0) && (localConversationFacade != null))
            {
              this.H = localConversationFacade.a(AppConstants.aO, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
              this.G = 3;
            }
          }
          if ((!TextUtils.isEmpty(localException)) || (j > 0)) {
            if (!((QQMessageFacade.Message)localObject3).isSendFromLocal()) {}
          }
          for (;;)
          {
            if ((m <= 0) && (k <= 0)) {
              break label1528;
            }
            localMsgSummary.b = "";
            break;
            if ((localException != null) && (localException.equals(((QQMessageFacade.Message)localObject3).senderuin)))
            {
              paramContext.getString(2131368853);
              continue;
              localMsgSummary.b = paramContext.getString(2131368292);
            }
          }
          break label674;
          if (AppConstants.aH.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_b_of_type_JavaLangString = paramContext.getString(2131371738);
            if (localQQMessageFacade != null)
            {
              this.G = 1;
              this.H = localConversationFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
              if ((this.H <= 0) && (localConversationFacade != null))
              {
                this.H = localConversationFacade.a(AppConstants.aP, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
                this.G = 3;
              }
            }
            if ((((QQMessageFacade.Message)localObject3).msg == null) || (64537 == ((QQMessageFacade.Message)localObject3).msgtype))
            {
              localMsgSummary.b = paramContext.getString(2131371739);
              localObject2 = localException;
            }
            for (;;)
            {
              DatingUtil.a("data_recent_msg", new Object[] { localObject2, localMsgSummary.b });
              break;
              localObject2 = localException;
              if (((QQMessageFacade.Message)localObject3).msgtype == 64512)
              {
                localObject2 = localException;
                if (localException != null)
                {
                  localObject2 = localException;
                  if (localException.length() > 12) {
                    localObject2 = localException.substring(0, 11) + "...";
                  }
                }
                if (((QQMessageFacade.Message)localObject3).isSendFromLocal()) {
                  localMsgSummary.b = paramContext.getString(2131371809, new Object[] { localObject2 });
                } else {
                  localMsgSummary.b = paramContext.getString(2131371810, new Object[] { localObject2 });
                }
              }
            }
          }
          if (AppConstants.ag.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_b_of_type_JavaLangString = paramContext.getString(2131368299);
            if (localQQMessageFacade != null) {
              this.H = localQQMessageFacade.g();
            }
            if ((64537 != ((QQMessageFacade.Message)localObject3).msgtype) && (((QQMessageFacade.Message)localObject3).msg != null)) {
              break label674;
            }
            localMsgSummary.b = paramContext.getString(2131368300);
            break label674;
          }
          this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
          break label674;
          paramQQAppInterface = "";
          break label837;
        }
        if (this.jdField_b_of_type_JavaLangString != null)
        {
          paramQQAppInterface = this.jdField_b_of_type_JavaLangString;
          if (this.jdField_c_of_type_JavaLangString == null) {
            break label1965;
          }
        }
        for (str = this.jdField_c_of_type_JavaLangString;; str = "")
        {
          paramQQAppInterface = String.format("%s,%s,%s", new Object[] { paramQQAppInterface, str, paramContext });
          break;
          paramQQAppInterface = "";
          break label1921;
        }
        k = 0;
        m = i;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemMsgBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */