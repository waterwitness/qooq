package com.tencent.mobileqq.vashealth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class StepCounterServlert
  extends MSFServlet
{
  static int jdField_a_of_type_Int = 0;
  static final String jdField_a_of_type_JavaLangString = "health_manager";
  public static final String b = "msf_cmd_type";
  public static final String c = "cmd_refresh_steps";
  public static final String d = "cmd_health_switch";
  public static final String e = "cmd_update_lastreport_time";
  public static final String f = "json_string";
  public static final String g = "last_report_time";
  public static final String h = "StepInfoJSON";
  public static final String i = "has_report_yes";
  
  public StepCounterServlert()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("health_manager", 2, "MyServlet onReceive." + paramFromServiceMsg.getServiceCmd());
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getServiceCmd().equals("cmd_refresh_steps")))
    {
      String str = paramIntent.getStringExtra("json_string");
      paramFromServiceMsg = (String)paramFromServiceMsg.getAttribute("StepInfoJSON");
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(str)) {
        localBundle.putString("json_string", str);
      }
      if (!TextUtils.isEmpty(paramFromServiceMsg)) {
        localBundle.putString("StepInfoJSON", paramFromServiceMsg);
      }
      notifyObserver(paramIntent, 0, true, localBundle, null);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket = paramIntent.getStringExtra("msf_cmd_type");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, "0", paramPacket);
    localToServiceMsg.setMsfCommand(MsfCommand.msf_step_counter);
    localToServiceMsg.setNeedCallback(true);
    localToServiceMsg.setTimeout(30000L);
    if (paramPacket.equals("cmd_health_switch")) {
      localToServiceMsg.addAttribute("isOpen", Boolean.valueOf(paramIntent.getBooleanExtra("isOpen", false)));
    }
    for (;;)
    {
      sendToMSF(paramIntent, localToServiceMsg);
      return;
      if (paramPacket.equals("cmd_update_lastreport_time"))
      {
        long l = paramIntent.getLongExtra("last_report_time", 0L);
        boolean bool = paramIntent.getBooleanExtra("has_report_yes", false);
        localToServiceMsg.addAttribute("last_report_time", Long.valueOf(l));
        localToServiceMsg.addAttribute("has_report_yes", Boolean.valueOf(bool));
        localToServiceMsg.setNeedCallback(false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vashealth\StepCounterServlert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */