package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import uva;

public class StructMsgClickHandler
  implements StructMsgOnClickListener
{
  private static ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  protected Context a;
  protected QQAppInterface a;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  
  public StructMsgClickHandler(View paramView)
  {
    this(null, paramView);
  }
  
  public StructMsgClickHandler(QQAppInterface paramQQAppInterface, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    if ((paramQQAppInterface == null) && (FragmentActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();
    }
  }
  
  public StructMsgClickHandler(QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord)
  {
    this(paramQQAppInterface, paramView);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  private static void a(Context paramContext, String paramString)
  {
    if ((jdField_a_of_type_ComTencentWidgetActionSheet == null) || (!jdField_a_of_type_ComTencentWidgetActionSheet.getContext().equals(paramContext)))
    {
      jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(paramContext);
      jdField_a_of_type_ComTencentWidgetActionSheet.a(2131369290, 1);
      jdField_a_of_type_ComTencentWidgetActionSheet.a(2131369291, 1);
      jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      jdField_a_of_type_ComTencentWidgetActionSheet.a(String.format(paramContext.getString(2131369308), new Object[] { paramString }));
      jdField_a_of_type_ComTencentWidgetActionSheet.a(new uva(paramString, paramContext));
    }
    if (!jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
    localIntent.putExtra("articalChannelId", 1);
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      int i = localFragmentActivity.getChatFragment().a().b();
      if (i == 1008)
      {
        localIntent.putExtra("puin", localFragmentActivity.getChatFragment().a().a());
        localIntent.putExtra("uin_type", i);
        localIntent.putExtra("msg_id", String.valueOf(paramLong));
        localIntent.putExtra("switch_msg_btn", PublicAccountUtil.a());
        localIntent.putExtra("articalChannelId", 1);
        localIntent.putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
      }
    }
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      Object localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      int i = ((FragmentActivity)localObject).getChatFragment().a().b();
      paramString2 = ((FragmentActivity)localObject).getChatFragment().a().b();
      localObject = ((FragmentActivity)localObject).getChatFragment().a().a();
      Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
      localIntent.putExtra("uin", (String)localObject);
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("forward_type", -1);
      localIntent.putExtra("forward_text", paramString1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      paramString1 = paramString2;
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString2 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();
      PublicAccountManager.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, null, paramInt, paramLong, 2);
      return true;
      paramString1 = paramString2;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      int i = paramString2.indexOf("://");
      Object localObject = "";
      if (i == -1)
      {
        paramString3 = paramString2;
        paramString2 = (String)localObject;
        label30:
        localObject = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
      }
      try
      {
        if (((PackageManager)localObject).getPackageInfo(paramString3, 1) != null)
        {
          paramString3 = ((PackageManager)localObject).getLaunchIntentForPackage(paramString3);
          if (paramString3 != null)
          {
            if (!TextUtils.isEmpty(paramString2)) {
              paramString3.setData(Uri.parse(paramString2));
            }
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramString3);
            return true;
            paramString2 = paramString3;
            continue;
            paramString3 = paramString2.substring(0, i);
            paramString2 = paramString2.substring(i + 3);
            break label30;
          }
          return false;
        }
      }
      catch (PackageManager.NameNotFoundException paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramString2.getMessage());
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          paramString2.putExtra("key_isReadModeEnabled", true);
          paramString2.putExtra("url", paramString1);
          paramString2.putExtra("fromAio", true);
          PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramString2, paramString1);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramString4, 0L);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructMsgClickHandler doAction action = " + paramString1 + ", url = " + paramString2 + ", actionData = " + paramString3 + ", actionDataA = " + paramString4);
    }
    FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
    String str = localFragmentActivity.getChatFragment().a().a();
    int i = localFragmentActivity.getChatFragment().a().b();
    if ((!paramString1.equals("")) && (i == 1008)) {
      PublicAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
    }
    if ("web".equals(paramString1))
    {
      if (paramLong > 0L) {}
      for (boolean bool1 = a(paramString2, paramLong);; bool1 = a(paramString2))
      {
        boolean bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramLong > 0L) {
            bool2 = a(paramString2, null, 2, paramLong);
          }
        }
        return bool2;
      }
    }
    if ("app".equals(paramString1)) {
      return a(paramString2, paramString3, paramString4);
    }
    if ("plugin".equals(paramString1)) {
      return c(paramString3, paramString4);
    }
    if ("auto".equals(paramString1)) {
      return b(paramString2);
    }
    if ("replyMsg".equals(paramString1)) {
      return a(paramString3, paramString4);
    }
    if ("replyCmd".equals(paramString1))
    {
      if (paramLong == 0L) {
        return b(paramString3, paramString4);
      }
      return a(paramString3, null, 1, paramLong);
    }
    if ("playVideo".equals(paramString1)) {
      return b(paramString2, paramString3, paramString4);
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (paramString.startsWith("tel:"))
    {
      paramString = paramString.substring("tel:".length());
      a(this.jdField_a_of_type_AndroidContentContext, paramString);
    }
    for (;;)
    {
      return true;
      try
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("com.android.browser.application_id", this.jdField_a_of_type_AndroidContentContext.getPackageName());
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      }
      catch (Exception paramString) {}
      if (QLog.isColorLevel()) {
        QLog.d("HyperTextMsg", 2, paramString.getMessage());
      }
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString2 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();
      PublicAccountManager.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, null, 1, 0L, 2);
      return true;
      paramString1 = paramString2;
    }
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3)
  {
    return true;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructMsgClickHandler clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.equals(paramString1, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent")) {
        break label67;
      }
    }
    label67:
    do
    {
      for (;;)
      {
        return true;
        paramString1 = paramString2;
        break;
        try
        {
          paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
          if (paramString1 != null)
          {
            paramString1.b();
            return true;
          }
        }
        catch (Exception paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, paramString1.getMessage(), paramString1);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgClickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */