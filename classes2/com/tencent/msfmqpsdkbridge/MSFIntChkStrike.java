package com.tencent.msfmqpsdkbridge;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mqpsdk.secsrv.IIntChkStrikeResultListener;
import com.tencent.mqpsdk.secsrv.MQPIntChkService.IIntChkStrike;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import wpi;
import wpj;
import wpk;
import wpl;
import wpm;

public class MSFIntChkStrike
  implements MQPIntChkService.IIntChkStrike
{
  private static final int jdField_a_of_type_Int = 1;
  private static final int jdField_b_of_type_Int = 2;
  private static final int c = 3;
  private static final int d = 3;
  private static final int e = 5;
  private static final int f = 6;
  private static final int g = 7;
  private static final int h = 8;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IIntChkStrikeResultListener jdField_a_of_type_ComTencentMqpsdkSecsrvIIntChkStrikeResultListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private int i;
  private int j;
  private int k;
  
  public MSFIntChkStrike(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "MQPINTCHK";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.i = paramInt;
  }
  
  private void a()
  {
    Object localObject = BaseApplication.getContext();
    DownloadManager localDownloadManager = (DownloadManager)((Context)localObject).getSystemService("download");
    if (localDownloadManager == null)
    {
      this.j = 30;
      return;
    }
    this.j = 31;
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    ((Context)localObject).registerReceiver(new wpm(this, localDownloadManager), localIntentFilter);
    try
    {
      localObject = new DownloadManager.Request(Uri.parse(this.jdField_a_of_type_JavaLangString));
      ((DownloadManager.Request)localObject).setTitle(this.b);
      if (this.k != 0) {
        ((DownloadManager.Request)localObject).setAllowedNetworkTypes(this.k);
      }
      this.jdField_a_of_type_Long = localDownloadManager.enqueue((DownloadManager.Request)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void a(DialogInterface paramDialogInterface, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      this.j = 1;
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_ComTencentMqpsdkSecsrvIIntChkStrikeResultListener == null) {}
    }
    for (;;)
    {
      try
      {
        paramDialogInterface = new JSONObject();
      }
      catch (Exception localException1)
      {
        Object localObject;
        Intent localIntent;
        BaseApplication localBaseApplication;
        paramDialogInterface = null;
      }
      try
      {
        paramDialogInterface.put("strike_result", this.j);
        if (paramDialogInterface != null) {
          this.jdField_a_of_type_ComTencentMqpsdkSecsrvIIntChkStrikeResultListener.a(paramDialogInterface.toString());
        }
        if ((paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 6) || (paramInt2 == 8))
        {
          paramDialogInterface = BaseActivity.sTopActivity;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
            SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
          }
          localObject = new Intent(paramDialogInterface, LoginActivity.class);
          ((Intent)localObject).addFlags(335544320);
          paramDialogInterface.startActivity((Intent)localObject);
        }
        return;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      if (paramInt2 == 2)
      {
        this.j = 2;
        break;
      }
      if ((paramInt2 == 3) || (paramInt2 == 3))
      {
        try
        {
          localObject = BaseApplication.getContext();
          localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tmast://appdetails?pname=" + ((Context)localObject).getPackageName()));
          localIntent.setFlags(268435456);
          ((Context)localObject).startActivity(localIntent);
          this.j = 4;
        }
        catch (ActivityNotFoundException localActivityNotFoundException1)
        {
          this.j = 3;
        }
        break;
      }
      if ((paramInt2 == 5) || (paramInt2 == 6))
      {
        try
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          this.j = 20;
        }
        catch (ActivityNotFoundException localActivityNotFoundException2)
        {
          this.j = 23;
        }
        break;
        localBaseApplication = BaseApplication.getContext();
        localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_JavaLangString));
        localIntent.setFlags(268435456);
        localBaseApplication.startActivity(localIntent);
        this.j = 22;
        break;
      }
      if ((paramInt2 == 7) || (paramInt2 == 8))
      {
        a();
        break;
      }
      this.j = 65535;
      break;
      localException1.printStackTrace();
    }
  }
  
  public void a(String paramString, IIntChkStrikeResultListener paramIIntChkStrikeResultListener)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if (this.i != 1) {
        break;
      }
    } while ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Boolean));
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("toast_config"))
        {
          paramString = paramString.getString("toast_config");
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          if (paramIIntChkStrikeResultListener != null) {
            this.jdField_a_of_type_ComTencentMqpsdkSecsrvIIntChkStrikeResultListener = paramIIntChkStrikeResultListener;
          }
          paramIIntChkStrikeResultListener = DocumentBuilderFactory.newInstance();
          try
          {
            localObject1 = paramIIntChkStrikeResultListener.newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes())).getDocumentElement();
            paramString = ((Element)localObject1).getElementsByTagName("title");
            if (paramString.getLength() == 0) {
              break;
            }
            String str1 = ((Element)paramString.item(0)).getAttribute("val");
            paramString = ((Element)localObject1).getElementsByTagName("wording");
            if (paramString.getLength() == 0) {
              break;
            }
            String str2 = ((Element)paramString.item(0)).getAttribute("val");
            paramString = ((Element)localObject1).getElementsByTagName("package_url");
            if (paramString.getLength() != 0) {
              this.jdField_a_of_type_JavaLangString = ((Element)paramString.item(0)).getAttribute("val");
            }
            paramString = ((Element)localObject1).getElementsByTagName("package_name");
            if (paramString.getLength() != 0) {
              this.b = ((Element)paramString.item(0)).getAttribute("val");
            }
            paramString = ((Element)localObject1).getElementsByTagName("network_types");
            if (paramString.getLength() != 0)
            {
              this.k = Integer.parseInt(((Element)paramString.item(0)).getAttribute("val"));
              if (this.k >= 3) {
                this.k = 0;
              }
            }
            paramIIntChkStrikeResultListener = "";
            paramString = ((Element)localObject1).getElementsByTagName("btn_confirm");
            if (paramString.getLength() <= 0) {
              break label738;
            }
            paramString = (Element)paramString.item(0);
            paramIIntChkStrikeResultListener = paramString.getAttribute("text");
            paramString = new wpi(this, Integer.parseInt(paramString.getAttribute("action")));
            localObject3 = "";
            localObject1 = ((Element)localObject1).getElementsByTagName("btn_cancel");
            if (((NodeList)localObject1).getLength() <= 0) {
              break label733;
            }
            localObject1 = (Element)((NodeList)localObject1).item(0);
            localObject3 = ((Element)localObject1).getAttribute("text");
            localObject1 = new wpj(this, Integer.parseInt(((Element)localObject1).getAttribute("action")));
            wpk localwpk = new wpk(this);
            new Handler(Looper.getMainLooper()).post(new wpl(this, str1, str2, paramString, (DialogInterface.OnClickListener)localObject1, (String)localObject3, paramIIntChkStrikeResultListener, localwpk));
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = null;
        continue;
      }
      if (this.i == 2)
      {
        if (paramIIntChkStrikeResultListener != null) {}
        for (;;)
        {
          try
          {
            paramString = new JSONObject();
            localException1.printStackTrace();
          }
          catch (Exception localException1)
          {
            try
            {
              paramString.put("strike_result", 5);
              if (paramString != null) {
                paramIIntChkStrikeResultListener.a(paramString.toString());
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
              return;
            }
            catch (Exception localException3)
            {
              Context localContext;
              int m;
              for (;;) {}
            }
            localException1 = localException1;
            paramString = (String)localObject3;
          }
        }
      }
      if ((this.i != 3) || (TextUtils.isEmpty(paramString))) {
        break;
      }
      try
      {
        localObject3 = new JSONObject(paramString);
        paramString = localException1;
        if (((JSONObject)localObject3).has("launch_package_name")) {
          paramString = ((JSONObject)localObject3).getString("launch_package_name");
        }
      }
      catch (Exception paramString)
      {
        try
        {
          for (;;)
          {
            paramString.put("strike_result", m);
            paramIIntChkStrikeResultListener.a(paramString.toString());
            return;
            paramString = paramString;
            paramString.printStackTrace();
            paramString = localContext;
            continue;
            if (!PackageUtil.a(localContext, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
              break;
            }
            m = 13;
          }
          m = 12;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext();
      if (!PackageUtil.a(localContext, paramString))
      {
        m = 11;
        if (paramIIntChkStrikeResultListener == null) {
          break;
        }
        paramString = new JSONObject();
      }
      label733:
      Object localObject2 = null;
      continue;
      label738:
      paramString = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\msfmqpsdkbridge\MSFIntChkStrike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */