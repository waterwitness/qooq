package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import oyv;

public class RecentItemKandianMergeData
  extends RecentUserBaseData
{
  private static String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "RecentItemKandianMergeData";
  }
  
  public RecentItemKandianMergeData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.G = 2;
    this.J = BaseApplicationImpl.a().getResources().getColor(2131428324);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject1;
    QQMessageFacade.Message localMessage;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        do
        {
          return;
          super.a(paramQQAppInterface, paramContext);
          localObject1 = paramQQAppInterface.a();
        } while (localObject1 == null);
        localMessage = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      } while (localMessage == null);
      localMessageRecord = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
    } while (localMessageRecord == null);
    if ((localMessageRecord instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localMessageRecord;
      if (((MessageForStructing)localObject1).structingMsg == null) {
        ((MessageForStructing)localObject1).parse();
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = PublicAccountConfigUtil.c(paramQQAppInterface, paramContext);
      MsgSummary localMsgSummary = a();
      localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
      label178:
      label205:
      label306:
      long l2;
      long l1;
      Object localObject3;
      if ((localMessageRecord.extInt == 1) || (localMessageRecord.extInt == 3)) {
        if ((!TextUtils.isEmpty(localMessage.emoRecentMsg)) || (!TextUtils.isEmpty(localMessage.msg)))
        {
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          this.H = 0;
          if ((localMessageRecord.extInt != 1) || (localMessageRecord.isread)) {
            break label1495;
          }
          this.H = 1;
          this.jdField_c_of_type_JavaLangCharSequence = "";
          if (this.H <= 0) {
            break label1627;
          }
          if (localMessageRecord.extInt != 1) {
            break label1573;
          }
          if (localObject1 == null) {
            break label1564;
          }
          if ((((MessageForStructing)localObject1).structingMsg == null) || (TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mOrangeWord))) {
            break label1555;
          }
          if (((MessageForStructing)localObject1).structingMsg.mOrangeWord.length() < 8) {
            break label1518;
          }
          this.jdField_c_of_type_JavaLangCharSequence = ("[" + ((MessageForStructing)localObject1).structingMsg.mOrangeWord.substring(0, 8) + "] ");
          if (localMessage.getMessageText() == null) {
            break label1636;
          }
          this.jdField_b_of_type_Long = localMessage.time;
          if (((localMessageRecord.extInt == 1) || (localMessageRecord.extInt == 2)) && (localMessageRecord.extLong == 1))
          {
            if ((localMessageRecord.extInt != 1) || (localObject1 == null)) {
              break label1678;
            }
            l2 = -1L;
            l1 = l2;
            if (((MessageForStructing)localObject1).structingMsg != null)
            {
              l1 = l2;
              if (!TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mMsgActionData))
              {
                localObject3 = PublicAccountUtil.a(((MessageForStructing)localObject1).structingMsg.mMsgActionData);
                l1 = l2;
                if (localObject3 == null) {}
              }
            }
          }
        }
      }
      label1495:
      label1518:
      label1555:
      label1564:
      label1573:
      label1627:
      label1636:
      label1678:
      label1810:
      label1814:
      label1816:
      label1822:
      for (;;)
      {
        int i;
        try
        {
          l1 = Long.parseLong(((JSONObject)localObject3).getString("id"));
          String str;
          Object localObject5;
          Object localObject4;
          if (l1 != -1L)
          {
            if (this.H <= 0) {
              break label1816;
            }
            localObject3 = (KandianMergeManager)paramQQAppInterface.getManager(161);
            if ((localObject3 == null) || (((KandianMergeManager)localObject3).a(localMessageRecord) != 1)) {
              continue;
            }
            i = 5;
            if (i != 1)
            {
              localObject3 = "";
              str = "";
              localObject5 = str;
              localObject4 = localObject3;
            }
          }
          try
          {
            if (((MessageForStructing)localObject1).structingMsg != null)
            {
              if (((MessageForStructing)localObject1).structingMsg.mStrategyIds != null) {
                localObject3 = localObject1.structingMsg.mStrategyIds.split("\\|")[0];
              }
              localObject5 = str;
              localObject4 = localObject3;
              if (((MessageForStructing)localObject1).structingMsg.mAlgorithmIds != null)
              {
                localObject5 = localObject1.structingMsg.mAlgorithmIds.split("\\|")[0];
                localObject4 = localObject3;
              }
            }
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("folder_status", i);
            ((JSONObject)localObject1).put("algorithm_id", localObject5);
            ((JSONObject)localObject1).put("time", System.currentTimeMillis());
            ReportController.b(null, "CliOper", "", "", "0X80066F3", "0X80066F3", 0, 0, String.valueOf(this.O + 1), "", (String)localObject4, ((JSONObject)localObject1).toString());
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            continue;
          }
          localMessageRecord.extLong = 0;
          ThreadManager.a(new oyv(this, paramQQAppInterface, localMessageRecord), 8, null, false);
          if ((TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(localMsgSummary.a)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)))
          {
            if (QLog.isColorLevel())
            {
              QLog.i(jdField_a_of_type_JavaLangString, 2, localMessage.getBaseInfoString() + ",isread:" + localMessage.isread + ",issend:" + localMessage.issend + ",extInt:" + localMessage.extInt + ",extLong:" + localMessage.extLong);
              QLog.i(jdField_a_of_type_JavaLangString, 2, localMessageRecord.getBaseInfoString() + ",isread:" + localMessageRecord.isread + ",issend:" + localMessageRecord.issend + ",extInt:" + localMessageRecord.extInt + ",extLong:" + localMessageRecord.extLong);
            }
            localMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramQQAppInterface.a().getResources().getString(2131362982);
          }
          a(paramQQAppInterface, paramContext, localMsgSummary);
          if (!AppSetting.j) {
            break;
          }
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) {
            paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(",");
          }
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
            paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(",");
          }
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
            paramQQAppInterface.append(this.jdField_c_of_type_JavaLangString);
          }
          this.d = paramQQAppInterface.toString();
          return;
          if (localObject1 != null)
          {
            if (((MessageForStructing)localObject1).structingMsg != null)
            {
              localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((MessageForStructing)localObject1).structingMsg.mMsgBrief;
              break label178;
            }
            QLog.w(jdField_a_of_type_JavaLangString, 2, "KANDIAN_REAL_MSG or KANDIAN_FAKE_MSG, structing.structingMsg null");
            break label178;
          }
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = localMessageRecord.msg;
          break label178;
          if (PublicAccountUtil.a(paramQQAppInterface, localMessageRecord.senderuin, localMessage.msgtype))
          {
            localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
            localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
            break label178;
          }
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          i = localMessage.msgtype;
          if ((i == 62530) || (i == 60532))
          {
            localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
            localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
            localObject4 = XMLMessageUtils.a(localMessage);
            if ((localObject4 != null) && (((PAMessage)localObject4).items != null) && (((PAMessage)localObject4).items.size() != 0))
            {
              localObject3 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
              if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover != null) || (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList == null)) {
                continue;
              }
              localObject3 = (String)localObject3 + "：" + (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
              localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject3);
            }
          }
          if (((TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence))) || (TextUtils.equals(localMsgSummary.a(paramContext), "你有新消息")))
          {
            i = 1;
            if ((i == 0) || (localObject1 == null) || (((MessageForStructing)localObject1).structingMsg == null) || (!(((MessageForStructing)localObject1).structingMsg instanceof AbsStructMsg))) {
              break label178;
            }
            localObject3 = ((AbsShareMsg)((MessageForStructing)localObject1).structingMsg).getStructMsgItemLists();
            if (localObject3 == null) {
              break label178;
            }
            localObject3 = ((List)localObject3).iterator();
            i = 0;
            if (!((Iterator)localObject3).hasNext()) {
              break label178;
            }
            localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
            if (!(localObject4 instanceof AbsStructMsgItem)) {
              break label1822;
            }
            localObject4 = ((AbsStructMsgItem)localObject4).a.iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break label1822;
            }
            localObject5 = (AbsStructMsgElement)((Iterator)localObject4).next();
            if (!(localObject5 instanceof StructMsgItemTitle)) {
              continue;
            }
            localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((StructMsgItemTitle)localObject5).b();
            localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
            i = 1;
            if (i != 0) {
              break label178;
            }
            continue;
            continue;
          }
          i = 0;
          continue;
          if (localMessageRecord.extInt != 2) {
            break label205;
          }
          this.H = TroopBarAssistantManager.a().b(paramQQAppInterface);
          break label205;
          this.jdField_c_of_type_JavaLangCharSequence = ("[" + ((MessageForStructing)localObject1).structingMsg.mOrangeWord + "] ");
          break label306;
          this.jdField_c_of_type_JavaLangCharSequence = "";
          break label306;
          this.jdField_c_of_type_JavaLangCharSequence = "";
          break label306;
          if (localMessageRecord.extInt != 2) {
            break label306;
          }
          if (!PublicAccountUtil.a(paramQQAppInterface, localMessage.senderuin, localMessage.msgtype))
          {
            this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131364524);
            break label306;
          }
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131364525);
          break label306;
          this.jdField_c_of_type_JavaLangCharSequence = "";
          break label306;
          this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          l1 = l2;
          continue;
          i = 3;
          continue;
        }
        if (localMessageRecord.extInt == 2)
        {
          i = 1;
          if (this.H > 0) {
            if ((TextUtils.isEmpty(localMessageRecord.senderuin)) || (!PublicAccountUtil.d(paramQQAppInterface, localMessageRecord.senderuin))) {
              break label1810;
            }
          }
          for (i = 4;; i = 2)
          {
            if (i == 1) {
              break label1814;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("folder_status", i);
              localJSONObject.put("algorithm_id", "");
              localJSONObject.put("time", System.currentTimeMillis());
              ReportController.b(null, "CliOper", "", "", "0X80066F3", "0X80066F3", 0, 0, String.valueOf(this.O + 1), "", "0", localJSONObject.toString());
            }
            catch (JSONException localJSONException2)
            {
              localJSONException2.printStackTrace();
            }
            break;
          }
          continue;
          i = 1;
        }
      }
      continue;
      Object localObject2 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemKandianMergeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */