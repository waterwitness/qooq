package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentMsgBoxItem
  extends RecentBaseData
{
  MessageRecord a;
  public boolean c;
  
  public RecentMsgBoxItem(MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    this.a = paramMessageRecord;
    if (a() == 7100) {
      this.K |= 0x200000;
    }
  }
  
  public int a()
  {
    return this.a.istroop;
  }
  
  public long a()
  {
    return this.a.time;
  }
  
  public String a()
  {
    return this.a.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject1 = null;
    Object localObject3 = paramQQAppInterface.a();
    Object localObject2 = paramQQAppInterface.a();
    if (localObject3 != null) {
      localObject1 = ((QQMessageFacade)localObject3).a(a(), a());
    }
    int k;
    int m;
    int j;
    int i;
    if (localObject1 != null)
    {
      this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      if (localObject2 != null)
      {
        this.H = ((ConversationFacade)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        if ((localObject1 != null) && (MsgProxyUtils.c((MessageRecord)localObject1))) {
          this.G = 3;
        }
        localObject3 = a();
        this.jdField_c_of_type_Boolean = false;
        k = 0;
        m = 0;
        j = m;
        i = k;
        if (localObject2 == null) {
          break label820;
        }
        j = m;
        i = k;
        if (localObject1 == null) {
          break label820;
        }
        if (((QQMessageFacade.Message)localObject1).isSend()) {
          break label559;
        }
        m = ((ConversationFacade)localObject2).e(a(), 1001);
        j = m;
        i = k;
        if (m != 0) {
          break label820;
        }
        k = ((ConversationFacade)localObject2).d(a(), 1001);
        j = m;
        i = k;
        if (k > 0) {
          break label820;
        }
        j = ((ConversationFacade)localObject2).a((MessageRecord)localObject1);
        i = m;
      }
    }
    for (;;)
    {
      label207:
      if (i > 0)
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131372040);
        this.J = paramContext.getResources().getColor(2131428324);
        ((MsgSummary)localObject3).jdField_b_of_type_JavaLangCharSequence = ((ConversationFacade)localObject2).a(a(), 1001, paramContext.getResources().getString(2131372041), 0);
        label265:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_boxitem", 2, "boxUin" + a() + ",boxType" + a() + ",unreadNum:" + this.H + ",unReadGiftCount:" + k + ",lastMsgReadedGiftCount:" + j + ",unReadRedPacketCount:" + i);
        }
        localObject2 = ContactUtils.o(paramQQAppInterface, a());
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = ContactUtils.b(paramQQAppInterface, a(), false);
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = a();
        }
        this.jdField_b_of_type_JavaLangString = ((String)localObject2);
        if (a() != 7100) {
          break label746;
        }
        this.I = 2130838906;
        label422:
        a(paramQQAppInterface);
        a(paramQQAppInterface, (MsgSummary)localObject3);
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        if (!AppSetting.j) {
          break;
        }
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
        if (this.H != 0) {
          break label754;
        }
      }
      for (;;)
      {
        if (this.jdField_c_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
        this.d = paramQQAppInterface.toString();
        return;
        this.H = 0;
        break;
        this.H = 0;
        this.jdField_b_of_type_Long = 0L;
        break;
        label559:
        j = ((ConversationFacade)localObject2).a((MessageRecord)localObject1);
        i = 0;
        k = 0;
        break label207;
        if ((k > 0) || (j > 0))
        {
          if (k > 0)
          {
            this.jdField_c_of_type_Boolean = true;
            this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372100, new Object[] { "", Integer.valueOf(k) });
            this.J = paramContext.getResources().getColor(2131428324);
            break label265;
          }
          if (j <= 0) {
            break label265;
          }
          this.jdField_c_of_type_Boolean = true;
          if (!((QQMessageFacade.Message)localObject1).isSend()) {}
          for (this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372100, new Object[] { "", Integer.valueOf(j) });; this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372102, new Object[] { Integer.valueOf(j) }))
          {
            this.J = paramContext.getResources().getColor(2131428302);
            break;
          }
        }
        this.jdField_c_of_type_JavaLangCharSequence = "";
        a((QQMessageFacade.Message)localObject1, a(), paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        break label265;
        label746:
        this.I = 0;
        break label422;
        label754:
        if (this.H == 1) {
          paramQQAppInterface.append("有一条未读");
        } else if (this.H == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (this.H > 0) {
          paramQQAppInterface.append("有").append(this.H).append("条未读");
        }
      }
      label820:
      m = 0;
      k = i;
      i = j;
      j = m;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.a = false;
          paramMsgSummary.d = null;
          paramQQAppInterface = paramQQAppInterface.a();
        } while (paramQQAppInterface == null);
        paramQQAppInterface = paramQQAppInterface.a(a(), a());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.jdField_b_of_type_Long > l);
    this.jdField_b_of_type_Long = l;
    paramMsgSummary.a = true;
    paramMsgSummary.d = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public long b()
  {
    return 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentMsgBoxItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */