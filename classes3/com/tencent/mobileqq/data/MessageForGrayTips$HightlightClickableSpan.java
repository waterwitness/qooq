package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;

public class MessageForGrayTips$HightlightClickableSpan
  extends ClickableSpan
  implements MessageForGrayTips.HightlightClickInterface
{
  protected static final int PACKAGE_NAME_INDEX = 0;
  protected static final int URL_DATA_INDEX = 1;
  int color = -1;
  private Context context;
  String frienduin;
  private MessageForGrayTips.HightlightItem item;
  private QQAppInterface mApp;
  MessageRecord message;
  
  public MessageForGrayTips$HightlightClickableSpan(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, MessageForGrayTips.HightlightItem paramHightlightItem, MessageRecord paramMessageRecord)
  {
    this.mApp = paramQQAppInterface;
    this.context = paramContext;
    this.color = paramInt;
    this.item = paramHightlightItem;
    this.message = paramMessageRecord;
    this.frienduin = paramMessageRecord.frienduin;
  }
  
  public MessageForGrayTips$HightlightClickableSpan(QQAppInterface paramQQAppInterface, Context paramContext, MessageForGrayTips.HightlightItem paramHightlightItem)
  {
    this(paramQQAppInterface, -1, paramContext, paramHightlightItem, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean clickAppMsg(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("HightlightClickableSpan", 2, " clickAppMsg actionData = " + paramString1 + "actionDataA" + paramString2);
    }
    paramString2 = parsePackageNameAndData(paramString1, paramString2);
    Object localObject = this.context.getPackageManager();
    try
    {
      if (((PackageManager)localObject).getPackageInfo(paramString2[0], 1) != null)
      {
        localObject = ((PackageManager)localObject).getLaunchIntentForPackage(paramString2[0]);
        if (!TextUtils.isEmpty(paramString2[1])) {
          ((Intent)localObject).setData(Uri.parse(paramString2[1]));
        }
      }
      try
      {
        ((StartAppCheckHandler)this.mApp.a(23)).b(paramString2[0].trim(), this.context, (Intent)localObject);
        bool = true;
        return bool;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
          }
          this.context.startActivity((Intent)localObject);
        }
      }
      return clickWebMsg(paramString1);
    }
    catch (PackageManager.NameNotFoundException paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(MessageForGrayTips.access$000(), 2, paramString2.getMessage());
      }
    }
  }
  
  public boolean clickPluginMsg(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HightlightClickableSpan", 2, "HightlightClickableSpan clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {}
    try
    {
      for (;;)
      {
        JumpParser.a(this.mApp, this.context, paramString1).b();
        return true;
        paramString1 = paramString2;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HightlightClickableSpan", 2, paramString1.getMessage(), paramString1);
        }
      }
    }
  }
  
  public boolean clickWebMsg(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("key_isReadModeEnabled", true);
    PublicAccountUtil.a(this.message, localIntent, paramString);
    this.context.startActivity(localIntent);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (this.item == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(MessageForGrayTips.access$000(), 2, "onClick==>item actionType:" + this.item.actionType);
    }
    switch (this.item.actionType)
    {
    case 8: 
    case 9: 
    default: 
      return;
    case 1: 
      if ((this.message != null) && (this.message.msgtype == 63487)) {
        ReportCenter.a().a(this.mApp.a(), "", "", "2000", "2012", "0", false);
      }
      if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)))
      {
        paramView = ((MessageForUniteGrayTip)this.message).tipParam;
        if (paramView != null)
        {
          if (paramView.i != 1310722) {
            break label235;
          }
          ReportController.b(null, "dc00898", "", "", "0X8006F09", "0X8006F09", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        clickWebMsg(this.item.mMsgActionData);
        return;
        if (paramView.i == 1310721) {
          ReportController.b(null, "dc00898", "", "", "0X8006F07", "0X8006F07", 0, 0, "", "", "", "");
        }
      }
    case 3: 
      clickPluginMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
      return;
    case 2: 
      clickAppMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
      return;
    case 4: 
      label235:
      if (((TroopManager)this.mApp.getManager(51)).a(this.frienduin) != null) {
        break;
      }
    }
    for (int i = 2;; i = 1)
    {
      paramView = TroopInfoActivity.a(this.frienduin, 4);
      paramView.putInt("t_s_f", 1001);
      ChatSettingForTroop.a(this.context, paramView, i);
      return;
      if (this.context == null) {
        break;
      }
      paramView = new Intent(this.context, TroopMemberCardActivity.class);
      paramView.putExtra("troopUin", this.frienduin);
      paramView.putExtra("memberUin", "" + this.item.uin);
      paramView.putExtra("fromFlag", 4);
      this.context.startActivity(paramView);
      return;
      paramView = new TroopInfoData();
      paramView.troopUin = this.frienduin;
      Object localObject = (TroopManager)this.mApp.getManager(51);
      if (localObject == null) {
        break;
      }
      localObject = ((TroopManager)localObject).a(this.frienduin);
      if (localObject != null)
      {
        paramView.updateForTroopChatSetting((TroopInfo)localObject, this.context.getResources(), this.mApp.a());
        paramView.isMember = true;
      }
      new TroopShareUtility((SplashActivity)this.context, paramView).a(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("reactive", 2, "onclick graytip");
      }
      paramView = new Intent(this.context, ShowReactiveActivity.class);
      if (!(this.context instanceof BaseActivity)) {
        break;
      }
      ((BaseActivity)this.context).startActivityForResult(paramView, 13006);
      return;
      paramView = new Intent(this.context, SelectMemberActivity.class);
      paramView.putExtra("param_groupcode", this.frienduin);
      paramView.putExtra("param_type", 1);
      paramView.putExtra("param_subtype", 1);
      paramView.putExtra("param_done_button_wording", this.context.getString(2131365111));
      paramView.putExtra("param_only_friends", true);
      paramView.putExtra("param_is_troop_admin", true);
      paramView.putExtra("param_title", this.context.getString(2131364641));
      this.context.startActivity(paramView);
      return;
      HWTroopUtils.a(this.context, this.frienduin);
      return;
    }
  }
  
  protected final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label49;
      }
    }
    label49:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label61;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label61:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.color == -1) {
      paramTextPaint.setColor(paramTextPaint.linkColor);
    }
    for (;;)
    {
      paramTextPaint.setUnderlineText(false);
      return;
      paramTextPaint.setColor(this.color);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForGrayTips$HightlightClickableSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */