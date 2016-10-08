import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgItemBuilder;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.biz.pubaccount.util.PAReportUtil.AdverInfo;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class hdl
  implements PopupMenuDialog.OnClickActionListener
{
  public hdl(BitAppMsgItemBuilder paramBitAppMsgItemBuilder, Activity paramActivity, MessageForBitApp paramMessageForBitApp, String paramString, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    Object localObject = new Dialog(this.jdField_a_of_type_AndroidAppActivity);
    ((Dialog)localObject).requestWindowFeature(1);
    ((Dialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((Dialog)localObject).setContentView(2130903496);
    ((Dialog)localObject).show();
    new Handler(this.jdField_a_of_type_AndroidAppActivity.getMainLooper()).postDelayed(new hdm(this, (Dialog)localObject), 1500L);
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.a, this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
    if ((((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity))) && (((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment() != null) && (((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment().a() != null))
    {
      ((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity).getChatFragment().a().a(this.jdField_a_of_type_ComTencentBitappMessageForBitApp);
      if ((this.jdField_a_of_type_ComTencentBitappMessageForBitApp == null) || (this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg == null)) {
        break label480;
      }
    }
    label480:
    for (long l = this.jdField_a_of_type_ComTencentBitappMessageForBitApp.bitAppMsg.getMsgId();; l = 0L)
    {
      String str2;
      if (this.jdField_a_of_type_ComTencentBitappMessageForBitApp != null)
      {
        str2 = this.jdField_a_of_type_ComTencentBitappMessageForBitApp.getExtInfoFromExtStr("gdt_msgClick");
        localObject = this.jdField_a_of_type_ComTencentBitappMessageForBitApp.getExtInfoFromExtStr("gdt_view_id");
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.a, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8006378", "0X8006378", 0, 0, "" + l, "", "" + (paramMenuItem.jdField_a_of_type_Int + 1), paramMenuItem.jdField_a_of_type_JavaLangString);
        PAReportUtil.AdverInfo localAdverInfo = (PAReportUtil.AdverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramMenuItem.jdField_a_of_type_Int);
        paramMenuItem = new JSONObject();
        try
        {
          paramMenuItem.put("puin", localAdverInfo.jdField_a_of_type_JavaLangString);
          paramMenuItem.put("type", localAdverInfo.b);
          paramMenuItem.put("index", localAdverInfo.c);
          paramMenuItem.put("name", localAdverInfo.d);
          paramMenuItem.put("net", localAdverInfo.e);
          paramMenuItem.put("mobile_imei", DeviceInfoUtil.a());
          paramMenuItem.put("obj", "react_negative_feedback");
          paramMenuItem.put("gdt_cli_data", str2);
          paramMenuItem.put("view_id", localObject);
          PAReportUtil.a(this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.a, this.jdField_a_of_type_JavaLangString, paramMenuItem.toString(), "" + l);
          return;
          this.jdField_a_of_type_ComTencentBitappBitAppMsgItemBuilder.a.a().a(this.jdField_a_of_type_ComTencentBitappMessageForBitApp, false);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        String str1 = "";
        str2 = "";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */