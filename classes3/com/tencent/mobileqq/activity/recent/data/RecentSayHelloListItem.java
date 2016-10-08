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
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentSayHelloListItem
  extends RecentBaseData
{
  public int P;
  public int Q;
  public int R;
  public int S;
  public int T;
  public int U;
  public int V;
  MessageRecord a;
  public String a;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public RecentSayHelloListItem(MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.P = -1;
    this.Q = -1;
    this.R = -1;
    this.S = -1;
    this.T = -1;
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = null;
    Object localObject3 = paramQQAppInterface.a();
    Object localObject2 = paramQQAppInterface.a();
    if (localObject3 != null) {
      localObject1 = ((QQMessageFacade)localObject3).a(a(), a());
    }
    label83:
    int k;
    int j;
    int i;
    if (localObject1 != null)
    {
      this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      if ((localObject2 != null) && (localObject1 != null))
      {
        this.H = ((ConversationFacade)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        if (MsgProxyUtils.c((MessageRecord)localObject1)) {
          this.G = 3;
        }
        localObject3 = super.a();
        this.jdField_c_of_type_Boolean = false;
        this.J = 0;
        this.jdField_c_of_type_JavaLangCharSequence = null;
        if ((localObject2 == null) || (localObject1 == null)) {
          break label699;
        }
        if (((QQMessageFacade.Message)localObject1).isSend()) {
          break label430;
        }
        k = ((ConversationFacade)localObject2).e(a(), 1001);
        if (k != 0) {
          break label690;
        }
        j = ((ConversationFacade)localObject2).d(a(), 1001);
        if (j > 0) {
          break label684;
        }
        i = ((ConversationFacade)localObject2).a((MessageRecord)localObject1);
      }
    }
    for (;;)
    {
      label166:
      if (k > 0)
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131372040);
        this.J = paramContext.getResources().getColor(2131428324);
        ((MsgSummary)localObject3).jdField_b_of_type_JavaLangCharSequence = ((ConversationFacade)localObject2).a(a(), 1001, paramContext.getResources().getString(2131372041), 0);
        label224:
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
          break label611;
        }
        this.I = 2130838906;
        label293:
        super.a(paramQQAppInterface);
        a(paramQQAppInterface, (MsgSummary)localObject3);
        super.a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        if (AppSetting.j)
        {
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
          if (this.H != 0) {
            break label619;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_c_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
        this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
        return;
        this.H = 0;
        break;
        this.H = 0;
        this.jdField_b_of_type_Long = 0L;
        break label83;
        label430:
        i = ((ConversationFacade)localObject2).a((MessageRecord)localObject1);
        j = 0;
        k = 0;
        break label166;
        if ((j > 0) || (i > 0))
        {
          if (j > 0)
          {
            this.jdField_c_of_type_Boolean = true;
            this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372100, new Object[] { "", Integer.valueOf(j) });
            this.J = paramContext.getResources().getColor(2131428324);
            break label224;
          }
          if (i <= 0) {
            break label224;
          }
          this.jdField_c_of_type_Boolean = true;
          this.J = paramContext.getResources().getColor(2131428302);
          if (!((QQMessageFacade.Message)localObject1).isSend())
          {
            this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372100, new Object[] { "", Integer.valueOf(i) });
            break label224;
          }
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131372102, new Object[] { Integer.valueOf(i) });
          break label224;
        }
        super.a((QQMessageFacade.Message)localObject1, a(), paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        break label224;
        label611:
        this.I = 0;
        break label293;
        label619:
        if (this.H == 1) {
          paramQQAppInterface.append("有一条未读");
        } else if (this.H == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (this.H > 0) {
          paramQQAppInterface.append("有").append(this.H).append("条未读");
        }
      }
      label684:
      i = 0;
      continue;
      label690:
      i = 0;
      j = 0;
      continue;
      label699:
      k = 0;
      i = 0;
      j = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.a = false;
      paramMsgSummary.d = null;
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a(a(), a());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.jdField_b_of_type_Long > l);
    this.jdField_b_of_type_Long = l;
    paramMsgSummary.a = true;
    paramMsgSummary.d = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public boolean a(FansEntity paramFansEntity)
  {
    boolean bool = false;
    if ((this.Q != paramFansEntity.age) || (this.R != paramFansEntity.gender) || (this.S != paramFansEntity.career) || (this.T != paramFansEntity.constellation) || (this.P != paramFansEntity.vip) || (this.jdField_d_of_type_Boolean != paramFansEntity.charmIcon) || (this.U != paramFansEntity.charmLevel) || (this.V != paramFansEntity.commonId) || (!Utils.a(this.jdField_a_of_type_JavaLangString, paramFansEntity.common)))
    {
      this.Q = paramFansEntity.age;
      this.R = paramFansEntity.gender;
      this.S = paramFansEntity.career;
      this.T = paramFansEntity.constellation;
      this.P = paramFansEntity.vip;
      this.jdField_d_of_type_Boolean = paramFansEntity.charmIcon;
      this.e = true;
      this.U = paramFansEntity.charmLevel;
      this.V = paramFansEntity.commonId;
      this.jdField_a_of_type_JavaLangString = paramFansEntity.common;
      bool = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.msg_box", 4, "haveChange:" + bool + ",FansEntity:" + paramFansEntity.toString());
    }
    return bool;
  }
  
  public long b()
  {
    return 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentSayHelloListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */