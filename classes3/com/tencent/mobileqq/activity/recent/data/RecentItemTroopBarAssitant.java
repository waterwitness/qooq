package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.MsgUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentItemTroopBarAssitant
  extends RecentUserBaseData
{
  public RecentItemTroopBarAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.G = 2;
  }
  
  public void a(Context paramContext)
  {
    if ((this.H > 0) && (!SubscriptRecommendController.e((QQAppInterface)((BaseApplicationImpl)paramContext.getApplicationContext()).a()))) {
      if (this.H <= 99)
      {
        this.jdField_c_of_type_JavaLangCharSequence = String.format(paramContext.getString(2131364521), new Object[] { Integer.valueOf(this.H) });
        this.J = paramContext.getResources().getColor(2131428324);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_c_of_type_JavaLangString = "";
      }
      return;
      this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131364526);
      break;
      this.jdField_c_of_type_JavaLangCharSequence = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.F = 0;
    TroopBarData localTroopBarData = TroopBarAssistantManager.a().a(paramQQAppInterface);
    if ((localTroopBarData == null) || (TextUtils.isEmpty(localTroopBarData.mUin))) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(localTroopBarData.mUin, 1008);
    } while ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.F = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.jdField_b_of_type_JavaLangString = PublicAccountConfigUtil.a(paramQQAppInterface, paramContext);
    Object localObject3 = TroopBarAssistantManager.a();
    MsgSummary localMsgSummary = a();
    Object localObject1;
    label89:
    Object localObject2;
    if (SubscriptRecommendController.e(paramQQAppInterface))
    {
      this.H = 1;
      ((TroopBarAssistantManager)localObject3).b = this.H;
      localObject1 = SubscriptRecommendController.b(paramQQAppInterface);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131364534);; localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1))
      {
        this.jdField_b_of_type_Long = ((TroopBarAssistantManager)localObject3).a(paramQQAppInterface);
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.j)
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
          if (this.H != 0) {
            break label971;
          }
          localObject2 = paramContext.getString(2131364519);
          if (this.jdField_b_of_type_JavaLangCharSequence != null) {
            break;
          }
          paramQQAppInterface = "";
          label145:
          this.d = String.format((String)localObject2, new Object[] { localObject1, paramQQAppInterface, this.jdField_c_of_type_JavaLangString });
        }
        label173:
        a(paramContext);
        return;
      }
    }
    label202:
    QQMessageFacade localQQMessageFacade;
    TroopBarData localTroopBarData;
    label337:
    int i;
    if (((TroopBarAssistantManager)localObject3).a(paramQQAppInterface) == 0)
    {
      this.H = 0;
      ((TroopBarAssistantManager)localObject3).b = 0;
      localObject2 = null;
      localQQMessageFacade = paramQQAppInterface.a();
      localTroopBarData = ((TroopBarAssistantManager)localObject3).a(paramQQAppInterface);
      localObject1 = localObject2;
      if (localQQMessageFacade != null)
      {
        localObject1 = localObject2;
        if (localTroopBarData != null) {
          localObject1 = localQQMessageFacade.a(localTroopBarData.mUin, 1008);
        }
      }
      if (localObject1 == null) {
        break label950;
      }
      this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      if (TextUtils.isEmpty(((TroopBarAssistantManager)localObject3).a(((QQMessageFacade.Message)localObject1).frienduin)))
      {
        localObject2 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
        if (localObject2 != null)
        {
          localObject3 = ((PublicAccountDataManager)localObject2).b(((QQMessageFacade.Message)localObject1).frienduin);
          if (localObject3 != null) {
            break label648;
          }
          localObject2 = ((PublicAccountDataManager)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin);
          if (localObject2 == null) {
            break label639;
          }
          localObject2 = ((AccountDetail)localObject2).name;
        }
      }
      if (localObject1 != null)
      {
        MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.a.type, localMsgSummary, "", true, false);
        i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == 62530) || (i == 60532))
        {
          localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
          localObject3 = XMLMessageUtils.a((MessageRecord)localObject1);
          if ((localObject3 != null) && (((PAMessage)localObject3).items != null) && (((PAMessage)localObject3).items.size() != 0)) {
            break label658;
          }
          a((QQMessageFacade.Message)localObject1, this.a.type, paramQQAppInterface, paramContext, localMsgSummary);
        }
        if (((!TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence)) || (!TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence))) && (!TextUtils.equals(localMsgSummary.a(paramContext), "你有新消息"))) {
          break label774;
        }
        i = 1;
        label481:
        if (i != 0)
        {
          localObject2 = localQQMessageFacade.a(localTroopBarData.mUin, 1008);
          if ((localObject2 != null) && ((localObject2 instanceof MessageForStructing))) {
            break label780;
          }
        }
      }
    }
    label514:
    label555:
    label639:
    label648:
    label658:
    label774:
    label780:
    label846:
    label950:
    label971:
    label1112:
    label1113:
    for (;;)
    {
      if (PublicAccountUtil.a((MessageRecord)localObject1))
      {
        localObject2 = localQQMessageFacade.b(localTroopBarData.mUin, 1008);
        if (localObject2 != null) {
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = localQQMessageFacade.a(paramContext, (MessageRecord)localObject2, false);
        }
      }
      if ((localObject1 == null) && (TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)))
      {
        localMsgSummary.jdField_a_of_type_JavaLangCharSequence = null;
        localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ("暂无" + PublicAccountConfigUtil.a(paramQQAppInterface, paramContext) + "消息");
        break label89;
        this.H = ((TroopBarAssistantManager)localObject3).a(paramQQAppInterface, false);
        break label202;
        localObject2 = ((QQMessageFacade.Message)localObject1).frienduin;
        break label337;
        localObject2 = ((PublicAccountInfo)localObject3).name;
        break label337;
        localObject2 = ((PAMessage.Item)((PAMessage)localObject3).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject3).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList != null)) {
          localObject2 = (String)localObject2 + "：" + (String)((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList.get(0);
        }
        for (;;)
        {
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject2);
          break;
        }
        i = 0;
        break label481;
        ((MessageForStructing)localObject2).parse();
        if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg))) {
          break;
        }
        localObject2 = ((AbsShareMsg)((MessageForStructing)localObject2).structingMsg).getStructMsgItemLists();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((List)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
          if (!(localObject3 instanceof AbsStructMsgItem)) {
            break label1112;
          }
          localObject3 = ((AbsStructMsgItem)localObject3).a.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject3).next();
            if ((localAbsStructMsgElement instanceof StructMsgItemTitle))
            {
              localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((StructMsgItemTitle)localAbsStructMsgElement).b();
              localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label1113;
        }
        break label846;
        break label514;
        this.jdField_b_of_type_Long = ((TroopBarAssistantManager)localObject3).a(paramQQAppInterface);
        break label555;
        break;
        paramQQAppInterface = this.jdField_b_of_type_JavaLangCharSequence;
        break label145;
        if (this.H == 1)
        {
          this.d = String.format(paramContext.getString(2131364518), new Object[] { localObject1, "一", this.jdField_c_of_type_JavaLangString });
          break label173;
        }
        if (this.H == 2)
        {
          this.d = String.format(paramContext.getString(2131364518), new Object[] { localObject1, "两", this.jdField_c_of_type_JavaLangString });
          break label173;
        }
        if (this.H <= 0) {
          break label173;
        }
        this.d = String.format(paramContext.getString(2131364518), new Object[] { localObject1, Integer.toString(this.H), this.jdField_c_of_type_JavaLangString });
        break label173;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.jdField_a_of_type_Boolean = false;
          paramMsgSummary.d = null;
          paramMsgSummary = paramQQAppInterface.a();
        } while (paramMsgSummary == null);
        paramQQAppInterface = TroopBarAssistantManager.a().a(paramQQAppInterface);
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.mUin)) || (this.jdField_b_of_type_Long >= paramQQAppInterface.mLastDraftTime));
      paramQQAppInterface = paramMsgSummary.a(paramQQAppInterface.mUin, 1008);
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.jdField_b_of_type_Long = paramQQAppInterface.getTime();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemTroopBarAssitant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */