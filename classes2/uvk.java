import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class uvk
  implements View.OnClickListener
{
  long a;
  
  public uvk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 4, "geneal struct msg onclick start ........");
    }
    if (SystemClock.uptimeMillis() - this.a < 1000L) {}
    for (;;)
    {
      return;
      this.a = SystemClock.uptimeMillis();
      Object localObject1 = paramView.findViewById(2131296312);
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getTag(2131296312);
        if ((localObject1 != null) && (StructMsgForGeneralShare.class.isInstance(localObject1)))
        {
          StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject1;
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)))
          {
            StructingMsgItemBuilder.StructingMsgViewHolder localStructingMsgViewHolder = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
            Context localContext = paramView.getContext();
            if ((SplashActivity.class.isInstance(localContext)) || (ChatActivity.class.isInstance(localContext)) || (ChatHistoryForC2C.class.isInstance(localContext)))
            {
              localObject1 = ((FragmentActivity)localContext).getChatFragment();
              if (localObject1 != null) {
                localObject1 = ((ChatFragment)localObject1).a();
              }
              while (localObject1 != null)
              {
                AbsShareMsg.doReport((QQAppInterface)localObject1, localStructMsgForGeneralShare);
                if ((localStructMsgForGeneralShare != null) && (localStructMsgForGeneralShare.message != null) && ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
                try
                {
                  Object localObject2 = new JSONObject();
                  ((JSONObject)localObject2).put("puin", localStructMsgForGeneralShare.message.frienduin);
                  ((JSONObject)localObject2).put("type", localStructMsgForGeneralShare.index_type);
                  ((JSONObject)localObject2).put("index", localStructMsgForGeneralShare.index);
                  ((JSONObject)localObject2).put("name", localStructMsgForGeneralShare.index_name);
                  ((JSONObject)localObject2).put("net", String.valueOf(HttpUtil.a()));
                  ((JSONObject)localObject2).put("mobile_imei", DeviceInfoUtil.a());
                  ((JSONObject)localObject2).put("obj", "");
                  ((JSONObject)localObject2).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                  ((JSONObject)localObject2).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                  PAReportUtil.a((AppInterface)localObject1, localStructMsgForGeneralShare.message.selfuin, ((JSONObject)localObject2).toString(), "" + localStructMsgForGeneralShare.msgId);
                  Object localObject3 = (EcShopAssistantManager)((QQAppInterface)localObject1).getManager(87);
                  localObject2 = (EcshopReportHandler)((QQAppInterface)localObject1).a(88);
                  if ((localStructMsgForGeneralShare.message != null) && (localObject3 != null) && (localObject2 != null) && (((EcShopAssistantManager)localObject3).a(localStructMsgForGeneralShare.message.senderuin)))
                  {
                    localObject3 = localStructMsgForGeneralShare.message;
                    if (TextUtils.isEmpty(localStructMsgForGeneralShare.index))
                    {
                      i = 0;
                      ((EcshopReportHandler)localObject2).a(false, (MessageRecord)localObject3, i, localStructMsgForGeneralShare.mMsgUrl);
                    }
                  }
                  else
                  {
                    if (localStructMsgForGeneralShare.msgId > 0L)
                    {
                      ReportController.b((QQAppInterface)localObject1, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForGeneralShare.msgId), "");
                      ThreadManager.b().postDelayed(new uvl(this, localStructMsgForGeneralShare, (QQAppInterface)localObject1), 0L);
                    }
                    if (QLog.isDevelopLevel()) {
                      QLog.d(StructMsgForGeneralShare.access$000(), 4, "geneal struct msg onclick middle ........");
                    }
                    if (localStructingMsgViewHolder.a != null) {
                      Util.a((QQAppInterface)localObject1, "", "click", localStructMsgForGeneralShare.mSourceAppid, localStructMsgForGeneralShare.mMsgServiceID, Util.a(localStructingMsgViewHolder.a.jdField_a_of_type_Int));
                    }
                    if (localStructMsgForGeneralShare.uinType != 0) {
                      break label963;
                    }
                    i = 0;
                    localObject2 = localStructMsgForGeneralShare.mMsgUrl;
                    if (TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgUrl)) {
                      break label1007;
                    }
                    j = localStructMsgForGeneralShare.mMsgUrl.indexOf("article_id=");
                    if (j <= 0) {
                      break label1007;
                    }
                    localObject3 = localStructMsgForGeneralShare.mMsgUrl.substring("article_id=".length() + j);
                    j = ((String)localObject3).indexOf("&");
                    if (j < 0) {
                      break label1007;
                    }
                    localObject2 = ((String)localObject3).substring(0, j);
                    ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, localStructMsgForGeneralShare.mMsgServiceID + "", "", "", "");
                    if (localStructMsgForGeneralShare.uinType != 1008) {
                      break label1001;
                    }
                    j = 2;
                    ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8004B5C", "0X8004B5C", j, 0, "", String.valueOf(i), (String)localObject2, localStructMsgForGeneralShare.source_puin);
                    if ((localStructingMsgViewHolder != null) && (localStructMsgForGeneralShare.hasFlag(16)))
                    {
                      if (QLog.isDevelopLevel()) {
                        QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg click report.........");
                      }
                      ThreadManager.a(new uvm(this, localStructingMsgViewHolder, (QQAppInterface)localObject1), 2, null, false);
                    }
                    if ((localStructMsgForGeneralShare != null) && (localStructingMsgViewHolder != null) && (localStructingMsgViewHolder.a != null) && ((localStructingMsgViewHolder.a.jdField_a_of_type_Int == 1025) || (localStructingMsgViewHolder.a.jdField_a_of_type_Int == 0)) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgAction)) && (BmqqSegmentUtil.c(localStructingMsgViewHolder.a.jdField_a_of_type_JavaLangString))) {
                      ((QidianManager)((QQAppInterface)localObject1).getManager(164)).a(localStructMsgForGeneralShare.mMsgAction, localStructMsgForGeneralShare.mMsg_A_ActionData, localStructMsgForGeneralShare.mMsgActionData, localStructMsgForGeneralShare.mMsgUrl);
                    }
                    StructMsgForGeneralShare.onClickEvent((QQAppInterface)localObject1, localContext, localStructMsgForGeneralShare, paramView, new StructMsgForGeneralShare.GeneralClickHandler((QQAppInterface)localObject1, paramView, localStructMsgForGeneralShare));
                    return;
                    localObject1 = BaseApplicationImpl.a().a();
                    if ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface))) {
                      break label1010;
                    }
                    localObject1 = (QQAppInterface)localObject1;
                  }
                }
                catch (JSONException localJSONException)
                {
                  label963:
                  label1001:
                  label1007:
                  for (;;)
                  {
                    int j;
                    localJSONException.printStackTrace();
                    continue;
                    int i = Integer.parseInt(localStructMsgForGeneralShare.index);
                    continue;
                    if (localStructMsgForGeneralShare.uinType == 1)
                    {
                      i = 1;
                    }
                    else if (localStructMsgForGeneralShare.uinType == 3000)
                    {
                      i = 2;
                    }
                    else
                    {
                      i = 3;
                      continue;
                      j = 1;
                    }
                  }
                  label1010:
                  localObject1 = null;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */