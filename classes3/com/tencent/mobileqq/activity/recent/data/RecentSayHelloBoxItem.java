package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentSayHelloBoxItem
  extends RecentMsgBoxItem
{
  private static final int P = 6;
  public List a;
  public boolean d;
  
  public RecentSayHelloBoxItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList(6);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject2 = paramQQAppInterface.a(a()).a(a(), a());
    Object localObject1 = paramQQAppInterface.a();
    int i;
    Object localObject3;
    int k;
    int j;
    if (localObject2 == null)
    {
      i = 0;
      this.a.clear();
      this.H = ((ConversationFacade)localObject1).a(a(), a());
      if (i > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if ((((ConversationFacade)localObject1).a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop) > 0) && (this.a.size() < 6)) {
            this.a.add(localObject3);
          }
        } while (this.a.size() < 6);
      }
      if ((this.H == 0) && (!this.a.isEmpty())) {
        this.a.clear();
      }
      this.G = 3;
      this.jdField_b_of_type_JavaLangCharSequence = "";
      this.J = 0;
      this.jdField_c_of_type_JavaLangCharSequence = "";
      localObject2 = null;
      localObject3 = paramQQAppInterface.a();
      if (localObject3 != null) {
        localObject2 = ((QQMessageFacade)localObject3).a(a(), a());
      }
      if (localObject2 == null) {
        break label983;
      }
      if (((QQMessageFacade.Message)localObject2).isSend()) {
        break label571;
      }
      k = ((ConversationFacade)localObject1).e(a(), 1001);
      if (k != 0) {
        break label974;
      }
      j = ((ConversationFacade)localObject1).d(a(), 1001);
      if (j > 0) {
        break label968;
      }
      i = ((ConversationFacade)localObject1).a((MessageRecord)localObject2);
    }
    for (;;)
    {
      label297:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "boxUin" + a() + ",boxType" + a() + ",unreadNum:" + this.H + ",unReadGiftCount:" + j + ",lastMsgReadedGiftCount:" + i + ",unReadRedPacketCount:" + k);
      }
      if (k > 0)
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131372040);
        this.J = paramContext.getResources().getColor(2131428324);
        localObject2 = a();
        ((MsgSummary)localObject2).jdField_b_of_type_JavaLangCharSequence = ((ConversationFacade)localObject1).a(a(), 1001, paramContext.getResources().getString(2131372041), 0);
        a(paramQQAppInterface, (MsgSummary)localObject2);
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      }
      for (;;)
      {
        label463:
        if (AppSetting.j)
        {
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
          if (this.H != 0) {
            break label896;
          }
          label495:
          if (this.jdField_c_of_type_JavaLangCharSequence != null) {
            paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
          }
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
          this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
          return;
          i = ((List)localObject2).size();
          break;
          label571:
          i = ((ConversationFacade)localObject1).a((MessageRecord)localObject2);
          j = 0;
          k = 0;
          break label297;
          if ((j > 0) || (i > 0))
          {
            if (j > 0)
            {
              this.jdField_d_of_type_Boolean = true;
              this.G = 1;
              this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372099, new Object[] { Integer.valueOf(j) });
              this.J = paramContext.getResources().getColor(2131428324);
            }
            else if (i > 0)
            {
              this.jdField_d_of_type_Boolean = true;
              localObject1 = "";
              if (localObject2 != null)
              {
                localObject3 = ContactUtils.o(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin);
                localObject1 = localObject3;
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  localObject1 = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin, false);
                }
              }
              paramQQAppInterface = (QQAppInterface)localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                paramQQAppInterface = "";
              }
              if (!((QQMessageFacade.Message)localObject2).isSend()) {}
              for (this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372101, new Object[] { paramQQAppInterface, Integer.valueOf(i) });; this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372102, new Object[] { Integer.valueOf(i) }))
              {
                this.J = paramContext.getResources().getColor(2131428302);
                break;
              }
            }
          }
          else if (this.H > 0)
          {
            this.jdField_b_of_type_JavaLangCharSequence = "";
          }
          else
          {
            localObject1 = null;
            if (localObject2 != null)
            {
              localObject3 = ContactUtils.o(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin);
              localObject1 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject1 = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin, false);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                break label965;
              }
              localObject1 = "";
            }
          }
        }
      }
      label896:
      label965:
      for (;;)
      {
        localObject3 = a();
        MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, a(), (MsgSummary)localObject3, (String)localObject1, false, false);
        a(paramQQAppInterface, (MsgSummary)localObject3);
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        break label463;
        break;
        if (this.H == 1)
        {
          paramQQAppInterface.append("有一条未读");
          break label495;
        }
        if (this.H == 2)
        {
          paramQQAppInterface.append("有两条未读");
          break label495;
        }
        if (this.H <= 0) {
          break label495;
        }
        paramQQAppInterface.append("有").append(this.H).append("条未读");
        break label495;
      }
      label968:
      i = 0;
      continue;
      label974:
      i = 0;
      j = 0;
      continue;
      label983:
      k = 0;
      i = 0;
      j = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentSayHelloBoxItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */