package com.tencent.mobileqq.activity.aio.item;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.ark.ArgumentsWrapper;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;

public class ArkAppModuleReg$ModuleQQ
  implements ArkAppModuleReg.TypeCheckModuleCallbackWrapper
{
  private long a;
  
  public ArkAppModuleReg$ModuleQQ()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 0L;
  }
  
  public void Destruct() {}
  
  public String GetTypeName()
  {
    return "QQ";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("OpenUrl")) {}
    do
    {
      do
      {
        return true;
      } while (paramString.equals("GetVersion"));
      if (this.a != 0L) {
        break;
      }
    } while ((paramString.equals("GetSkey")) || (paramString.equals("GetPskey")) || (paramString.equals("GetUIN")) || (paramString.equals("GetNickName")) || (paramString.equals("Report")) || (paramString.equals("Log")) || (paramString.equals("GetContainerInfo")) || (paramString.equals("DataRequest")));
    return !paramString.equals("TestGetJson");
  }
  
  public boolean Invoke(String paramString, ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (paramString.equals("GetSkey"))
    {
      paramString = "";
      paramArgumentsWrapper = ArkAppModuleReg.a();
      if (paramArgumentsWrapper != null) {
        paramString = ((TicketManager)paramArgumentsWrapper.getManager(2)).getSkey(paramArgumentsWrapper.a());
      }
      paramVariantWrapper.SetString(paramString);
      if (paramString != null) {
        Log.d("ark.GetSkey ", paramString);
      }
      return true;
    }
    Object localObject;
    if (paramString.equals("GetPskey"))
    {
      if (paramArgumentsWrapper.GetCount() == 1L)
      {
        paramArgumentsWrapper = paramArgumentsWrapper.GetArgument(0L).GetString();
        paramString = "";
        localObject = ArkAppModuleReg.a();
        if (localObject != null) {
          paramString = ((TicketManager)((QQAppInterface)localObject).getManager(2)).getPskey(((QQAppInterface)localObject).a(), paramArgumentsWrapper);
        }
        paramVariantWrapper.SetString(paramString);
        Log.d("ark.GetPskey ", paramArgumentsWrapper);
      }
      return true;
    }
    if (paramString.equals("OpenUrl"))
    {
      paramString = BaseActivity.sTopActivity;
      if (((paramString instanceof FragmentActivity)) && (paramArgumentsWrapper.GetCount() >= 1L))
      {
        paramArgumentsWrapper = paramArgumentsWrapper.GetArgument(0L).GetString();
        if (!TextUtils.isEmpty(paramArgumentsWrapper))
        {
          if ((!paramArgumentsWrapper.startsWith("http://")) && (!paramArgumentsWrapper.startsWith("https://"))) {
            break label213;
          }
          ArkAppModuleReg.a(paramString, paramArgumentsWrapper, true, 0L);
        }
      }
      for (;;)
      {
        Log.d("ark.OpenUrl ", paramArgumentsWrapper);
        return true;
        label213:
        paramString = JumpParser.a(ArkAppModuleReg.a(), paramString, paramArgumentsWrapper);
        if (paramString != null) {
          paramString.b();
        }
      }
    }
    if (paramString.equals("GetUIN"))
    {
      paramString = "";
      paramArgumentsWrapper = ArkAppModuleReg.a();
      if (paramArgumentsWrapper != null) {
        paramString = paramArgumentsWrapper.a();
      }
      paramVariantWrapper.SetString(paramString);
      if (paramString != null) {
        Log.d("ark.GetUIN ", paramString);
      }
      return true;
    }
    int i;
    if (paramString.equals("Report"))
    {
      paramVariantWrapper = ArkAppModuleReg.a();
      if (paramVariantWrapper == null) {
        return false;
      }
      if (paramArgumentsWrapper.GetCount() == 3L)
      {
        localObject = paramArgumentsWrapper.GetArgument(0L).GetString();
        i = (int)Math.round(paramArgumentsWrapper.GetArgument(1L).GetDouble());
        paramArgumentsWrapper = paramArgumentsWrapper.GetArgument(2L).GetString();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramArgumentsWrapper))) {}
      }
      for (;;)
      {
        try
        {
          Long.parseLong((String)localObject);
          paramString = "";
          if (paramVariantWrapper != null) {
            paramString = paramVariantWrapper.a();
          }
          QLog.d("ArkApp", 4, String.format("ark ReportClickEvent  viewID: %s", new Object[] { localObject }));
          ReportController.b(paramVariantWrapper, "CliOper", "", paramString, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(NetConnInfoCenter.getServerTime()), (String)localObject, paramArgumentsWrapper, "");
        }
        catch (Exception paramString)
        {
          QLog.d("ArkApp", 4, String.format("ark ReportClickEvent  viewID is not numeric string", new Object[0]));
          continue;
        }
        return true;
        if (paramArgumentsWrapper.GetCount() == 2L)
        {
          localObject = paramArgumentsWrapper.GetArgument(0L).GetString();
          paramString = paramArgumentsWrapper.GetArgument(1L).GetString();
          paramArgumentsWrapper = ArkContainerWrapper.a((String)localObject);
          if (paramArgumentsWrapper == null) {
            return false;
          }
          localObject = (EcShopAssistantManager)paramVariantWrapper.getManager(87);
          paramVariantWrapper = (EcshopReportHandler)paramVariantWrapper.a(88);
          if ((paramArgumentsWrapper != null) && (localObject != null) && (paramVariantWrapper != null) && (((EcShopAssistantManager)localObject).a(paramArgumentsWrapper.senderuin))) {
            paramVariantWrapper.a(true, paramArgumentsWrapper, 0, paramString);
          }
        }
      }
    }
    if (paramString.equals("GetVersion"))
    {
      paramVariantWrapper.SetString("6.5.5");
      return true;
    }
    QQAppInterface localQQAppInterface;
    long l;
    if (paramString.equals("Log"))
    {
      if (paramArgumentsWrapper.GetCount() == 1L)
      {
        paramString = paramArgumentsWrapper.GetArgument(0L);
        i = paramString.GetType();
        if (i == 1) {
          QLog.i("ArkApp", 1, "nil");
        }
        for (;;)
        {
          return true;
          if (i == 2)
          {
            if (paramString.GetBool()) {}
            for (paramString = "true";; paramString = "false")
            {
              QLog.i("ArkApp", 1, paramString);
              break;
            }
          }
          if (i == 3) {
            QLog.i("ArkApp", 1, Integer.toString(paramString.GetInt()));
          } else if (i == 4) {
            QLog.i("ArkApp", 1, Double.toString(paramString.GetDouble()));
          } else if (i == 5) {
            QLog.i("ArkApp", 1, paramString.GetString());
          } else if (paramString.IsArray()) {
            QLog.i("ArkApp", 1, paramString.GetTableAsJsonString());
          } else if (paramString.IsFunction()) {
            QLog.i("ArkApp", 1, "Function Object");
          } else if (paramString.IsUserObject()) {
            QLog.i("ArkApp", 1, "User Object");
          } else {
            QLog.i("ArkApp", 1, "Unknown Object");
          }
        }
      }
    }
    else if (paramString.equals("GetNickName"))
    {
      paramString = null;
      localQQAppInterface = ArkAppModuleReg.a();
      if (localQQAppInterface == null) {
        return false;
      }
      l = paramArgumentsWrapper.GetCount();
      if (l == 1L)
      {
        paramString = paramArgumentsWrapper.GetArgument(0L).GetString();
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = null;
          if (!TextUtils.isEmpty(ArkContainerWrapper.jdField_a_of_type_JavaLangString)) {
            localObject = ContactUtils.f(localQQAppInterface, ArkContainerWrapper.jdField_a_of_type_JavaLangString, paramString);
          }
          if (localObject != null)
          {
            paramArgumentsWrapper = (ark.ArgumentsWrapper)localObject;
            if (!TextUtils.equals((CharSequence)localObject, paramString)) {
              break label1314;
            }
          }
          localObject = ContactUtils.o(localQQAppInterface, paramString);
          paramArgumentsWrapper = (ark.ArgumentsWrapper)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label1314;
          }
        }
      }
    }
    label1314:
    for (paramString = ContactUtils.a(localQQAppInterface, paramString, 0);; paramString = paramArgumentsWrapper)
    {
      paramVariantWrapper.SetString(paramString);
      if (paramString != null) {
        Log.d("ark.GetNickName ", paramString);
      }
      return true;
      if (l != 0L) {
        break;
      }
      paramString = localQQAppInterface.a();
      break;
      if (paramString.equals("GetContainerInfo"))
      {
        paramArgumentsWrapper = new HashMap();
        if ((BaseActivity.sTopActivity instanceof FragmentActivity))
        {
          paramString = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
          if (paramString != null)
          {
            paramString = paramString.a();
            if (paramString != null)
            {
              localObject = paramString.a();
              if (localObject != null)
              {
                paramArgumentsWrapper.put("ChatUIN", ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
                paramString = String.format("%d", new Object[] { Integer.valueOf(-1) });
                switch (((SessionInfo)localObject).jdField_a_of_type_Int)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          paramArgumentsWrapper.put("ChatType", paramString);
          paramVariantWrapper.SetMap(paramArgumentsWrapper);
          return true;
          paramString = String.format("%d", new Object[] { Integer.valueOf(1) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(2) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(3) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(4) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(5) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(6) });
        }
      }
      if (paramString.equals("DataRequest"))
      {
        paramString = ArkAppModuleReg.a();
        if (paramString == null)
        {
          paramVariantWrapper.SetNull();
          return true;
        }
        paramVariantWrapper.CreateObject("DataRequest", new ArkDataRequestObj(paramString));
        return true;
      }
      if (paramString.equals("TestGetJson"))
      {
        boolean bool = paramVariantWrapper.SetTableAsJsonString("{ \"ret\":0, \"msg\":\"ok\", \"data\":{ \"param_array\": [ 3.1400000000000001, true, \"hello\", { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, { }, 1 ], \"param_bool_false\": false, \"param_bool_true\": true, \"param_double\": 3.1400000000000001, \"param_int\": 0, \"param_int2\": -1, \"param_int3\": 1001, \"param_str_empty\": \"\", \"param_str_hello\": \"hello\", \"param_table\": { \"param1\": 0, \"param2\": 3.1400000000000001, \"param3\": true, \"param4\": \"hello\", \"param5\": { }, \"param6\": { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, \"param7\": \"\" } }}");
        paramVariantWrapper.GetType();
        paramVariantWrapper.GetTableAsJsonString();
        return bool;
      }
      return false;
    }
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ArkAppModuleReg$ModuleQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */