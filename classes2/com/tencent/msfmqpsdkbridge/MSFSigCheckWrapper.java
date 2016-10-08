package com.tencent.msfmqpsdkbridge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mqpsdk.INetTransportProvider;
import com.tencent.mqpsdk.MQPSecServiceManager;
import com.tencent.mqpsdk.secsrv.MQPSigCheckService;
import com.tencent.mqpsdk.secsrv.MQPSigCheckService.ISigCheckResultListener;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import wpn;

public class MSFSigCheckWrapper
  implements MQPSigCheckService.ISigCheckResultListener
{
  public static final byte a = 18;
  private static final long jdField_a_of_type_Long = 604800000L;
  public static final String a = "MobileQQ";
  private static boolean jdField_a_of_type_Boolean = true;
  public static final String b = "SecResEntry";
  public static final String c = "SecStampEntry";
  public static final String d = "SecMd5Entry";
  public static final String e = "SecSig";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean b;
  private boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MSFSigCheckWrapper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    Object localObject1;
    int i;
    label224:
    do
    {
      long l1;
      long l2;
      do
      {
        do
        {
          do
          {
            return;
            localObject2 = null;
            localObject1 = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
            localObject3 = ((SharedPreferences)localObject1).edit();
            str = ((SharedPreferences)localObject1).getString("SecMd5Entry", null);
            i = ((SharedPreferences)localObject1).getInt("SecResEntry", -1);
            l1 = ((SharedPreferences)localObject1).getLong("SecStampEntry", -1L);
            l2 = System.currentTimeMillis();
            if (this.c) {
              break label461;
            }
            if (jdField_a_of_type_Boolean) {
              break;
            }
          } while (l2 <= (0x12 ^ l1) + 604800000L);
          jdField_a_of_type_Boolean = true;
          localObject1 = SecUtil.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationInfo().sourceDir);
        } while ((localObject1 == null) || (((String)localObject1).length() == 0));
        jdField_a_of_type_Boolean = false;
      } while ((str != null) && (str.equalsIgnoreCase((String)localObject1)) && (l1 != -1L) && (l2 <= (0x12 ^ l1) + 604800000L) && (i != -1) && ((i ^ 0x12) == 1));
      localObject2 = localObject1;
      if (l2 > (0x12 ^ l1) + 604800000L)
      {
        ((SharedPreferences.Editor)localObject3).remove("SecResEntry");
        ((SharedPreferences.Editor)localObject3).remove("SecStampEntry");
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = SecUtil.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationInfo().sourceDir);
    } while ((localObject1 == null) || (((String)localObject1).length() == 0));
    ((SharedPreferences.Editor)localObject3).putString("SecMd5Entry", (String)localObject1);
    ((SharedPreferences.Editor)localObject3).commit();
    Object localObject3 = SecUtil.getSignatureHash(SecUtil.getSign(BaseApplication.getContext()));
    String str = SecUtil.getPackageVersion(BaseApplication.getContext());
    if (!SecUtil.check0DayRepack(BaseApplication.getContext()))
    {
      i = 0;
      label305:
      localObject2 = localObject1;
      if (Build.VERSION.RELEASE.startsWith("4.4")) {
        localObject2 = "art";
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
      }
      catch (Exception localException1)
      {
        label461:
        localObject1 = null;
      }
      try
      {
        ((JSONObject)localObject1).put("uin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        ((JSONObject)localObject1).put("client_type", 0);
        ((JSONObject)localObject1).put("is_repack", i);
        ((JSONObject)localObject1).put("package_name", "MobileQQ");
        ((JSONObject)localObject1).put("package_version", str);
        ((JSONObject)localObject1).put("package_md5", localObject2);
        ((JSONObject)localObject1).put("package_signature", localObject3);
        localObject2 = (MSFNetTransportProvider)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(63);
        localObject2 = new MQPSecServiceManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), (INetTransportProvider)localObject2);
        if (localObject2 == null) {
          break;
        }
        localObject2 = (MQPSigCheckService)((MQPSecServiceManager)localObject2).a("sig_check");
        if (localObject2 == null) {
          break;
        }
        ((MQPSigCheckService)localObject2).a(this);
        ((MQPSigCheckService)localObject2).a(((JSONObject)localObject1).toString());
        return;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      ((SharedPreferences.Editor)localObject3).remove("SecResEntry");
      ((SharedPreferences.Editor)localObject3).remove("SecStampEntry");
      break label224;
      i = 1;
      break label305;
      localException1.printStackTrace();
    }
  }
  
  private void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("SecResEntry", -1);
    if ((i == -1) || ((i ^ 0x12) != paramInt))
    {
      localEditor.putInt("SecResEntry", paramInt ^ 0x12);
      localEditor.putLong("SecStampEntry", System.currentTimeMillis() ^ 0x12);
      localEditor.commit();
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Object localObject5 = null;
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = paramJSONObject.getString("dialog_title");
      }
      catch (Exception localException1)
      {
        try
        {
          str2 = paramJSONObject.getString("dialog_content");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject1;
            Object localObject4;
            Bundle localBundle;
            str1 = null;
            String str2 = null;
            paramJSONObject = null;
            localObject3 = localObject2;
            localObject2 = localException2;
          }
        }
        try
        {
          str1 = paramJSONObject.getString("dialog_left_button");
        }
        catch (Exception localException3)
        {
          str1 = null;
          paramJSONObject = null;
          localObject3 = localObject2;
          localObject2 = localException3;
          break label197;
        }
        try
        {
          localObject3 = paramJSONObject.getString("dialog_right_button");
        }
        catch (Exception localException4)
        {
          paramJSONObject = null;
          localObject3 = localObject2;
          localObject2 = localException4;
          break label197;
        }
        try
        {
          paramJSONObject = paramJSONObject.getString("url");
          localObject5 = paramJSONObject;
          localObject4 = localObject1;
          paramJSONObject = (JSONObject)localObject3;
          localObject1 = localObject5;
          if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty(str2))) {
            break;
          }
          localObject3 = BaseActivity.sTopActivity;
          localObject5 = new Intent((Context)localObject3, NotificationActivity.class);
          ((Intent)localObject5).putExtra("type", 9);
          localBundle = new Bundle();
          localBundle.putString("dlg_title", (String)localObject4);
          localBundle.putString("dlg_content", str2);
          localBundle.putString("dlg_lbutton", str1);
          localBundle.putString("dlg_rbutton", paramJSONObject);
          localBundle.putString("dlg_url", (String)localObject1);
          ((Intent)localObject5).putExtras(localBundle);
          ((Intent)localObject5).setFlags(872415232);
          ((Context)localObject3).startActivity((Intent)localObject5);
          return;
        }
        catch (Exception localException5)
        {
          paramJSONObject = (JSONObject)localObject3;
          localObject3 = localObject2;
          localObject2 = localException5;
          break label197;
        }
        localException1 = localException1;
        str1 = null;
        str2 = null;
        localObject3 = null;
        paramJSONObject = null;
      }
      label197:
      localException1.printStackTrace();
      localObject2 = localObject5;
      localObject4 = localObject3;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int j = -1;
    i = j;
    try
    {
      paramString = new JSONObject(paramString);
      i = j;
      j = paramString.getInt("sig_check_result");
      i = j;
      paramString = paramString.getJSONObject("dialog_config");
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
        continue;
        a(paramString);
        continue;
        i = 0;
      }
    }
    switch (i)
    {
    default: 
      
    case 0: 
    case 1: 
    case 3: 
      if (i == 0)
      {
        i = 1;
        a(i);
        return;
      }
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.c = paramBoolean;
    if (this.c) {
      new wpn(this).start();
    }
    for (;;)
    {
      this.b = false;
      return;
      a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\msfmqpsdkbridge\MSFSigCheckWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */