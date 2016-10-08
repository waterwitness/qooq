import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class uvx
  implements View.OnClickListener
{
  public uvx(StructMsgItemButton paramStructMsgItemButton)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.a.jdField_c_of_type_Long < 1000L) {}
    for (;;)
    {
      return;
      this.a.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      Object localObject2 = paramView.getTag();
      if ((localObject2 == null) || (!StructMsgItemButton.class.isInstance(localObject2))) {
        continue;
      }
      Object localObject1 = ((ViewGroup)paramView.getParent().getParent()).getTag(2131296312);
      if ((localObject1 == null) || (!StructMsgForGeneralShare.class.isInstance(localObject1))) {
        continue;
      }
      localObject1 = (StructMsgForGeneralShare)localObject1;
      localObject2 = (StructMsgItemButton)localObject2;
      Context localContext = paramView.getContext();
      if ((!SplashActivity.class.isInstance(localContext)) && (!ChatActivity.class.isInstance(localContext))) {
        continue;
      }
      QQAppInterface localQQAppInterface = ((FragmentActivity)localContext).getChatFragment().a();
      if ("1".equals(((StructMsgForGeneralShare)localObject1).message.getExtInfoFromExtStr("is_AdArrive_Msg"))) {}
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("puin", ((StructMsgForGeneralShare)localObject1).message.frienduin);
        ((JSONObject)localObject3).put("type", ((StructMsgItemButton)localObject2).k);
        ((JSONObject)localObject3).put("index", ((StructMsgItemButton)localObject2).i);
        ((JSONObject)localObject3).put("name", ((StructMsgItemButton)localObject2).j);
        ((JSONObject)localObject3).put("net", String.valueOf(HttpUtil.a()));
        ((JSONObject)localObject3).put("mobile_imei", DeviceInfoUtil.a());
        ((JSONObject)localObject3).put("obj", "");
        ((JSONObject)localObject3).put("gdt_cli_data", ((StructMsgForGeneralShare)localObject1).message.getExtInfoFromExtStr("gdt_msgClick"));
        ((JSONObject)localObject3).put("view_id", ((StructMsgForGeneralShare)localObject1).message.getExtInfoFromExtStr("gdt_view_id"));
        PAReportUtil.a(localQQAppInterface, ((StructMsgForGeneralShare)localObject1).message.selfuin, ((JSONObject)localObject3).toString(), "" + ((StructMsgForGeneralShare)localObject1).msgId);
        paramView = new StructMsgClickHandler(localQQAppInterface, paramView, ((StructMsgForGeneralShare)localObject1).message);
        if (((StructMsgItemButton)localObject2).a())
        {
          if (!((StructMsgItemButton)localObject2).jdField_d_of_type_Boolean) {
            break label649;
          }
          ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", ((StructMsgForGeneralShare)localObject1).uin, "0X80061FE", "0X80061FE", 0, 1, 0, "", "", "", "");
          ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", localQQAppInterface.getAccount(), "wallet", "publicpaymsg.btn.click", 1, 0, ((StructMsgForGeneralShare)localObject1).uin, "", String.valueOf(((StructMsgForGeneralShare)localObject1).msgId), "");
          if (TextUtils.isEmpty(this.a.e)) {
            paramView = this.a.jdField_d_of_type_JavaLangString;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          try
          {
            paramView = new JSONObject(paramView);
            Object localObject3 = (PublicQuickPayManager)localQQAppInterface.getManager(134);
            ((PublicQuickPayManager)localObject3).a = localContext;
            ((PublicQuickPayManager)localObject3).a(paramView, new uvy(this, (StructMsgForGeneralShare)localObject1, localContext, (StructMsgItemButton)localObject2, localQQAppInterface));
            bool = false;
            if ((bool) && (((StructMsgForGeneralShare)localObject1).message.istroop == 1008)) {
              PublicAccountManager.b(localQQAppInterface, ((StructMsgForGeneralShare)localObject1).uin);
            }
            if (((StructMsgForGeneralShare)localObject1).msgId <= 0L) {
              break;
            }
            ThreadManager.b().postDelayed(new uvz(this, (StructMsgItemButton)localObject2, (StructMsgForGeneralShare)localObject1, localQQAppInterface, bool), 0L);
            return;
            localJSONException = localJSONException;
            localJSONException.printStackTrace();
            continue;
            paramView = this.a.e;
            continue;
          }
          catch (Exception paramView)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("StructMsgItemButton", 2, "pay error:" + paramView.getMessage());
            continue;
          }
          ((StructMsgItemButton)localObject2).b = EcShopAssistantManager.a(((StructMsgForGeneralShare)localObject1).message.frienduin, ((StructMsgItemButton)localObject2).b, localQQAppInterface);
          boolean bool = paramView.a(((StructMsgItemButton)localObject2).jdField_c_of_type_JavaLangString, ((StructMsgItemButton)localObject2).b, ((StructMsgItemButton)localObject2).jdField_d_of_type_JavaLangString, ((StructMsgItemButton)localObject2).e, ((StructMsgForGeneralShare)localObject1).msgId);
          continue;
          label649:
          bool = false;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */