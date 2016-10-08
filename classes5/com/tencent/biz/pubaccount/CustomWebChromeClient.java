package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import hnq;
import hnr;
import hns;
import hnt;
import hnu;
import hnv;
import hnw;
import hnx;
import hny;
import hnz;
import hoa;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomWebChromeClient
  extends WebChromeClient
{
  public static final String a = "WEBVIEWCHECK";
  QQCustomDialog a;
  
  public CustomWebChromeClient()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("data:")) {
      return paramContext.getString(2131369909);
    }
    try
    {
      paramContext = new URL(paramString).getHost();
      return paramContext;
    }
    catch (MalformedURLException paramContext) {}
    return paramString;
  }
  
  public void a()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.cancel();
    }
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    super.onConsoleMessage(paramConsoleMessage);
    VipWebViewReportLog.a(paramConsoleMessage);
    Object localObject2;
    if (QLog.isColorLevel()) {
      localObject2 = "";
    }
    try
    {
      if (paramConsoleMessage.messageLevel() != null) {
        localObject2 = "" + "messageLevel =" + paramConsoleMessage.messageLevel().toString();
      }
      Object localObject1 = localObject2;
      if (paramConsoleMessage.sourceId() != null) {
        localObject1 = (String)localObject2 + ", sourceId=" + paramConsoleMessage.sourceId();
      }
      localObject2 = localObject1;
      if (paramConsoleMessage.lineNumber() != 0) {
        localObject2 = (String)localObject1 + ", lineNumber=" + paramConsoleMessage.lineNumber();
      }
      localObject1 = localObject2;
      if (paramConsoleMessage.message() != null) {
        localObject1 = (String)localObject2 + ", message=" + paramConsoleMessage.message();
      }
      QLog.d("WEBVIEWCHECK", 2, "CustomWebChromeClient onConsoleMessage:" + (String)localObject1);
    }
    catch (Exception paramConsoleMessage)
    {
      for (;;)
      {
        paramConsoleMessage.printStackTrace();
      }
    }
    return !QLog.isColorLevel();
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).a)))
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(localContext, 0);
      this.a.setTitle(a(localContext, paramString1));
      this.a.setMessage(paramString2);
      this.a.setPositiveButton(2131367263, new hnq(this, paramJsResult));
      this.a.setOnCancelListener(new hnt(this, paramJsResult));
      this.a.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramString1 = paramWebView.getContext();
    if (((paramString1 instanceof Activity)) && (!((Activity)paramString1).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).a)))
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(paramString1, 0);
      this.a.setTitle(2131369910);
      this.a.setMessage(paramString2);
      this.a.setPositiveButton(2131369911, new hoa(this, paramJsResult));
      this.a.setNegativeButton(2131369912, new hnr(this, paramJsResult));
      this.a.setOnCancelListener(new hns(this, paramJsResult));
      this.a.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).a)))
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(localContext, 0);
      this.a.setTitle(a(localContext, paramString1));
      this.a.setMessage(paramString2);
      this.a.setPositiveButton(2131367263, new hnu(this, paramJsResult));
      this.a.setNegativeButton(2131367262, new hnv(this, paramJsResult));
      this.a.setOnCancelListener(new hnw(this, paramJsResult));
      this.a.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).a)))
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(localContext, 0);
      this.a.setTitle(a(localContext, paramString1));
      paramWebView = LayoutInflater.from(localContext).inflate(2130903382, null);
      paramString1 = (EditText)paramWebView.findViewById(2131298374);
      paramString1.setText(paramString3);
      ((TextView)paramWebView.findViewById(2131298373)).setText(paramString2);
      this.a.setView(paramWebView);
      this.a.setPositiveButton(2131367263, new hnx(this, paramJsPromptResult, paramString1));
      this.a.setNegativeButton(2131367262, new hny(this, paramJsPromptResult));
      this.a.setOnCancelListener(new hnz(this, paramJsPromptResult));
      this.a.show();
      return true;
    }
    paramJsPromptResult.cancel();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\CustomWebChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */