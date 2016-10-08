package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class RecentPubAccountAssistantItem
  extends RecentBaseData
{
  private PubAccountAssistantData a;
  
  public RecentPubAccountAssistantItem(PubAccountAssistantData paramPubAccountAssistantData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramPubAccountAssistantData == null) {
      throw new NullPointerException("PubAccountAssistantData is null");
    }
    this.a = paramPubAccountAssistantData;
    this.G = 3;
  }
  
  public int a()
  {
    return this.a.mType;
  }
  
  public long a()
  {
    return this.a.mLastMsgTime;
  }
  
  public String a()
  {
    return this.a.mUin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject3 = a();
    int i = a();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a((String)localObject3, i);; localMessage = null)
    {
      Object localObject2;
      if (localMessage != null)
      {
        this.jdField_b_of_type_Long = localMessage.time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.H = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
          localObject1 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
          if (localObject1 == null) {
            break label605;
          }
          localObject2 = ((PublicAccountDataManager)localObject1).b((String)localObject3);
          if (localObject2 == null) {
            break label605;
          }
          localObject1 = ((PublicAccountInfo)localObject2).name;
          str = ((PublicAccountInfo)localObject2).summary;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localObject3;
        }
        this.jdField_b_of_type_JavaLangString = ((String)localObject2);
        localObject2 = a();
        if (localMessage != null)
        {
          int j = localMessage.msgtype;
          if ((j != 62530) && (j != 60532)) {
            a(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          }
        }
        else
        {
          label197:
          if ((TextUtils.isEmpty(((MsgSummary)localObject2).jdField_b_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(((MsgSummary)localObject2).jdField_c_of_type_JavaLangCharSequence)))
          {
            if (str != null) {
              break label537;
            }
            str = "";
            label226:
            ((MsgSummary)localObject2).jdField_b_of_type_JavaLangCharSequence = str;
          }
          a(paramQQAppInterface);
          a(paramQQAppInterface, (MsgSummary)localObject2);
          a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          if (!AppSetting.j) {
            break;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
          if (this.H != 0) {
            break label540;
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
          this.jdField_b_of_type_Long = 0L;
          this.H = 0;
          break;
          ((MsgSummary)localObject2).jdField_b_of_type_JavaLangCharSequence = "";
          localObject3 = XMLMessageUtils.a(localMessage);
          if ((localObject3 == null) || (((PAMessage)localObject3).items == null) || (((PAMessage)localObject3).items.size() == 0))
          {
            a(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
            break label197;
          }
          localObject1 = ((PAMessage.Item)((PAMessage)localObject3).items.get(0)).title;
          if ((((PAMessage.Item)((PAMessage)localObject3).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList != null)) {
            localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList.get(0);
          }
          for (;;)
          {
            ((MsgSummary)localObject2).jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
            break;
          }
          label537:
          break label226;
          label540:
          if (this.H == 1) {
            paramQQAppInterface.append("有一条未读");
          } else if (this.H == 2) {
            paramQQAppInterface.append("有两条未读");
          } else if (this.H > 0) {
            paramQQAppInterface.append("有").append(this.H).append("条未读");
          }
        }
        label605:
        localObject1 = null;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public long b()
  {
    return this.a.mLastDraftTime;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    QQMessageFacade.Message localMessage;
    do
    {
      String str;
      do
      {
        return;
        localMessage = null;
        str = a();
        int i = a();
        QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
        if (localQQMessageFacade != null) {
          localMessage = localQQMessageFacade.a(str, i);
        }
      } while (localMessage == null);
      RecentUtil.b(paramQQAppInterface, str, PublicAccountUtil.a(paramQQAppInterface, str));
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(localMessage.frienduin, localMessage.istroop, true);
  }
  
  public int c()
  {
    return this.a.mDistance;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentPubAccountAssistantItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */