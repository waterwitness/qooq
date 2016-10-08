package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TroopGiftUtil
{
  public static final String a = "TroopUtils";
  public static final String b = "GiftAnimationId";
  public static final String c = "TroopUin";
  public static final String d = "https://qun.qq.com/qunpay/gifts/index.html";
  public static final String e = "http://pub.idqqimg.com/pc/misc/groupgift/";
  public static final String f = "troopUin";
  public static final String g = "uin";
  public static final String h = "name";
  public static final String i = "from";
  public static final String j = "big";
  public static final String k = "xbig";
  public static final String l = "xxbig";
  public static final String m = "check.ini";
  public static String n;
  
  public TroopGiftUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Intent a(Activity paramActivity, String paramString1, String paramString2)
  {
    paramString1 = TroopMemberListActivity.a(paramActivity, paramString1, 8);
    paramString1.putExtra("custom_title_name", paramActivity.getString(2131365212));
    paramString1.putExtra("troop_gift_from", paramString2);
    return paramString1;
  }
  
  public static String a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (paramMessageForDeliverGiftTips == null) {
      return null;
    }
    if (paramMessageForDeliverGiftTips.isToAll()) {
      return String.valueOf(paramMessageForDeliverGiftTips.exflag);
    }
    return String.valueOf(paramMessageForDeliverGiftTips.animationPackageId);
  }
  
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.cW).append(paramString).append(File.separator);
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    long l1;
    StringBuffer localStringBuffer;
    if (n == null)
    {
      l1 = DeviceInfoUtil.h();
      if (l1 >= 1080L) {
        n = "xxbig";
      }
    }
    else
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("http://pub.idqqimg.com/pc/misc/groupgift/");
      if (!paramBoolean) {
        break label82;
      }
      localStringBuffer.append(paramString).append(".zip");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (l1 >= 720L)
      {
        n = "xbig";
        break;
      }
      n = "big";
      break;
      label82:
      localStringBuffer.append("animation_android_").append(paramString).append("_").append(n).append(".zip");
    }
  }
  
  public static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = new File(a(paramString));
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      int i1 = 0;
      while (i1 < paramString.length)
      {
        if (paramString[i1].getAbsolutePath().endsWith(".png")) {
          localArrayList.add(paramString[i1].getAbsolutePath());
        }
        i1 += 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if (paramIntent == null) {
      return;
    }
    a(paramActivity, paramIntent.getStringExtra("troop_uin"), paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"), paramIntent.getStringExtra("troop_gift_from"), paramQQAppInterface);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    TroopInfo localTroopInfo;
    int i1;
    if (paramQQAppInterface != null)
    {
      localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString1);
      if (localTroopInfo != null)
      {
        if (!localTroopInfo.isTroopOwner(paramQQAppInterface.a())) {
          break label133;
        }
        i1 = 0;
      }
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "exp", 0, 0, paramString1, i1 + "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "startSendGiftActivity from:" + paramString2);
      }
      paramActivity.startActivityForResult(a(paramActivity, paramString1, paramString2), 12005);
      paramActivity.overridePendingTransition(2130968592, 2130968589);
      return;
      label133:
      if (localTroopInfo.isAdmin()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      try
      {
        localObject = Base64.encodeToString(paramString3.getBytes("UTF-8"), 0);
        paramString3 = (String)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject;
          int i1;
          localUnsupportedEncodingException.printStackTrace();
          continue;
          if (paramActivity.isAdmin()) {
            i1 = 1;
          } else {
            i1 = 2;
          }
        }
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("troopUin", paramString1);
      ((Bundle)localObject).putString("uin", paramString2);
      ((Bundle)localObject).putString("name", paramString3);
      ((Bundle)localObject).putString("from", paramString4);
      ((Bundle)localObject).putString("_wv", "1031");
      ((Bundle)localObject).putString("_bid", "2204");
      paramString2 = "https://qun.qq.com/qunpay/gifts/index.html?" + HttpUtil.a((Bundle)localObject);
      paramString3 = new Intent(paramActivity, QQBrowserActivity.class);
      paramString3.putExtra("url", paramString2);
      paramActivity.startActivityForResult(paramString3, 13001);
      if (paramQQAppInterface != null)
      {
        paramActivity = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString1);
        if (paramActivity != null)
        {
          if (!paramActivity.isTroopOwner(paramQQAppInterface.a())) {
            break;
          }
          i1 = 0;
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "send_page", 0, 0, paramString1, i1 + "", "", "");
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopUtils", 2, "openSendTroopGiftUrl url:" + paramString2);
  }
  
  public static boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    return (paramMessageForDeliverGiftTips != null) && ((paramMessageForDeliverGiftTips.animationPackageId > 0) || (paramMessageForDeliverGiftTips.isToAll()));
  }
  
  public static boolean a(File paramFile)
  {
    StringBuffer localStringBuffer;
    Object localObject;
    if (paramFile.exists())
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append("check.ini");
      localObject = new File(localStringBuffer.toString());
      if (((File)localObject).exists()) {}
    }
    else
    {
      return false;
    }
    for (;;)
    {
      int i1;
      try
      {
        localObject = FileUtils.b((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split("&");
        if (localObject == null) {
          break;
        }
        i1 = 0;
        if (i1 >= localObject.length) {
          break label204;
        }
        localStringBuffer.setLength(0);
        localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append(localObject[i1].toString());
        File localFile = new File(localStringBuffer.toString());
        if (localFile.exists()) {
          break label195;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(".troop.send_giftTroopUtils", 2, "isAnimationPackageValid File not exist:" + localFile.getName());
        return false;
      }
      catch (IOException paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("TroopUtils", 2, "isAnimationPackageValid IOException");
      return false;
      label195:
      i1 += 1;
    }
    label204:
    return true;
  }
  
  public static boolean a(Object paramObject)
  {
    return ((paramObject instanceof TroopAioAgent.Message)) && (((TroopAioAgent.Message)paramObject).b);
  }
  
  public static boolean a(String paramString)
  {
    return a(new File(a(paramString)));
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  public static String b(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.cW).append(File.separator).append(paramString).append(".zip");
    return localStringBuffer.toString();
  }
  
  public static String c(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(paramString)).append("video").append(File.separator);
    return localStringBuffer.toString();
  }
  
  public static String d(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(paramString)).append("avatar").append(File.separator);
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopGiftUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */