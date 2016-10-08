package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.BaseMessageManager.AddMessageContext;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class HWTroopUtils
{
  public static final String a = "hw_troop";
  public static final String b = "http://qun.qq.com/homework/features/guide.html?ishw=1&_wv=1027&_bid=2146&gid=";
  
  public HWTroopUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    try
    {
      int i = paramString.lastIndexOf(".");
      str1 = str2;
      if (i != -1) {
        str1 = paramString.substring(i, paramString.length());
      }
    }
    catch (Exception paramString)
    {
      do
      {
        String str1 = str2;
      } while (!QLog.isColorLevel());
      QLog.e("hw_troop", 2, "getFileSuffix:", paramString);
    }
    return str1;
    return "";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://qun.qq.com/homework/features/guide.html?ishw=1&_wv=1027&_bid=2146&gid=" + paramString);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    TroopTipsEntity localTroopTipsEntity = new TroopTipsEntity();
    localTroopTipsEntity.actiontType = 0;
    localTroopTipsEntity.currentUin = paramQQAppInterface.a();
    localTroopTipsEntity.optContent = "ssssssssssstestC";
    localTroopTipsEntity.highlightItems = "[{\"data\":\"http://qun.qq.com/homework/features/model/result.html?_wv=1027&_bid=2146#gid=140290661&hw_id=1601209066131000&src=9\",\"cmd\":1,\"text\":\"testC\",\"endIndex\":16,\"startIndex\":11}]";
    localTroopTipsEntity.highlightNum = 1;
    localTroopTipsEntity.msgSeq = -9262L;
    localTroopTipsEntity.time = NetConnInfoCenter.getServerTime();
    localTroopTipsEntity.tipsPromptType = 1;
    localTroopTipsEntity.troopUin = "183876887";
    a(paramQQAppInterface, localTroopTipsEntity);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopTipsEntity paramTroopTipsEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, "insertTroopHomeworkPriseGrayTips:" + paramTroopTipsEntity.troopUin + ", optContent:" + paramTroopTipsEntity.optContent + ", " + ", remindFlag:" + paramTroopTipsEntity.grayTipsRemindFlag + ", serviceType:3" + ", msgSeq:" + paramTroopTipsEntity.msgSeq + ", time:" + paramTroopTipsEntity.time + ", expireTime:" + paramTroopTipsEntity.expireTime + ", isOfflineMsg:" + paramTroopTipsEntity.isOfflineMsg + ", optShowLatest:" + paramTroopTipsEntity.optShowLatest + ", highLightItems:" + paramTroopTipsEntity.highlightItems + ", highLightNum:" + paramTroopTipsEntity.highlightNum);
    }
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(63493);
    localMessageForGrayTips.frienduin = paramTroopTipsEntity.troopUin;
    localMessageForGrayTips.init(paramQQAppInterface.a(), paramTroopTipsEntity.troopUin, paramTroopTipsEntity.troopUin, paramTroopTipsEntity.optContent, paramTroopTipsEntity.time, 63493, 1, paramTroopTipsEntity.msgSeq);
    if (paramTroopTipsEntity.highlightNum != 0) {
      TroopTipsMsgMgr.a(localMessageForGrayTips, paramTroopTipsEntity.highlightItems);
    }
    if (paramTroopTipsEntity.optShowLatest == 1) {
      localMessageForGrayTips.shmsgseq = 0L;
    }
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForGrayTips, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("hw_troop", 2, "insertTroopHomeworkPriseGrayTips, after msgFilter:" + paramTroopTipsEntity.troopUin);
      }
      paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.a());
      if (!((TroopBindPublicAccountMgr)paramQQAppInterface.getManager(131)).b(paramTroopTipsEntity.troopUin))
      {
        MessageInfo localMessageInfo = new MessageInfo();
        Object localObject1 = new MessageInfo();
        ((MessageInfo)localObject1).m.a(localMessageForGrayTips.shmsgseq, localMessageForGrayTips.uniseq);
        localMessageInfo.a((MessageInfo)localObject1);
        localMessageForGrayTips.mMessageInfo = ((MessageInfo)localObject1);
        ((TroopInfoManager)paramQQAppInterface.getManager(36)).a(paramTroopTipsEntity.troopUin, localMessageInfo);
        Object localObject2 = new BaseMessageManager.AddMessageContext(paramQQAppInterface);
        localObject1 = ((BaseMessageManager.AddMessageContext)localObject2).jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
        localObject2 = ((BaseMessageManager.AddMessageContext)localObject2).jdField_a_of_type_JavaUtilMap;
        localObject1 = ((RecentUserProxy)localObject1).a(paramTroopTipsEntity.troopUin, 1);
        int i = localMessageInfo.a(paramQQAppInterface, true, paramTroopTipsEntity.troopUin);
        if (i >= ((RecentUser)localObject1).msgType)
        {
          ((RecentUser)localObject1).msgType = i;
          ((RecentUser)localObject1).msg = MessageInfo.a(paramQQAppInterface, paramTroopTipsEntity.troopUin, localMessageInfo, ((RecentUser)localObject1).msg, localMessageForGrayTips, true);
          ((Map)localObject2).put(MsgProxyUtils.a(paramTroopTipsEntity.troopUin, 1), localObject1);
        }
        ((TroopHandler)paramQQAppInterface.a(20)).a(80, true, null);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, "insertAddHWTroopGrayTips:" + paramString);
    }
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(64523);
    localMessageForGrayTips.frienduin = paramString;
    Object localObject = BaseApplicationImpl.a().getResources();
    String str = ((Resources)localObject).getString(2131365188);
    localObject = ((Resources)localObject).getString(2131365189);
    localMessageForGrayTips.init(paramQQAppInterface.a(), paramString, paramString, str, NetConnInfoCenter.getServerTime(), 64523, 1, 0L);
    paramString = new Bundle();
    paramString.putInt("key_action", 10);
    int i = str.indexOf((String)localObject);
    localMessageForGrayTips.addHightlightItem(i, ((String)localObject).length() + i, paramString);
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForGrayTips, false)) {
      paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.a());
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Object localObject1 = new File(paramString1);
      if (!((File)localObject1).exists()) {
        break label405;
      }
      if (((File)localObject1).isDirectory()) {
        return false;
      }
      FileInfo localFileInfo = new FileInfo();
      localFileInfo.d(paramString2);
      localFileInfo.a(false);
      localFileInfo.e(((File)localObject1).getPath());
      localFileInfo.a(((File)localObject1).length());
      localFileInfo.b(((File)localObject1).lastModified());
      Object localObject2 = FileManagerUtil.a(localFileInfo);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(((FileManagerEntity)localObject2).nSessionId);
      localForwardFileInfo.d(3);
      localForwardFileInfo.b(10000);
      localForwardFileInfo.a(localFileInfo.d());
      localForwardFileInfo.d(localFileInfo.e());
      localForwardFileInfo.d(localFileInfo.a());
      localObject1 = new Intent(paramContext, FileBrowserActivity.class);
      ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
      if ((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 1))
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localFileInfo);
        FMDataCache.a((ArrayList)localObject2);
        ((Intent)localObject1).putExtra("clicked_file_hashcode", localFileInfo.hashCode());
      }
      ((Intent)localObject1).putExtra("selectMode", false);
      ((Intent)localObject1).putExtra("enableDelete", false);
      ((Intent)localObject1).putExtra("peerType", 0);
      ((Intent)localObject1).putExtra("busiType", 0);
      ((Intent)localObject1).putExtra("enterfrom", 0);
      ((Intent)localObject1).putExtra("sendprepare", -100);
      ((Intent)localObject1).putExtra("apautocreate", false);
      ((Intent)localObject1).putExtra("qlinkselect", false);
      ((Intent)localObject1).putExtra("max_select_size", 0);
      ((Intent)localObject1).putExtra("max_select_count", 20);
      ((Intent)localObject1).putExtra("rootEntrace", false);
      ((Intent)localObject1).setFlags(268435456);
      paramContext.startActivity((Intent)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("hw_troop", 2, "openLocalFilePreview:" + paramString1 + "," + paramString2);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("hw_troop", 2, "openLocalFilePreview:", paramContext);
        }
      }
    }
    return true;
    label405:
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, "insertCreateHWTroopGrayTips:" + paramString);
    }
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(64523);
    localMessageForGrayTips.frienduin = paramString;
    Object localObject = BaseApplicationImpl.a().getResources();
    String str = ((Resources)localObject).getString(2131365188);
    localObject = ((Resources)localObject).getString(2131365189);
    localMessageForGrayTips.init(paramQQAppInterface.a(), paramString, paramString, str, NetConnInfoCenter.getServerTime(), 64523, 1, 0L);
    paramString = new Bundle();
    paramString.putInt("key_action", 10);
    int i = str.indexOf((String)localObject);
    localMessageForGrayTips.addHightlightItem(i, ((String)localObject).length() + i, paramString);
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForGrayTips, false)) {
      paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.a());
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, "insertHWInfoUpdateGrayTips:" + paramString);
    }
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(64523);
    localMessageForGrayTips.init(paramQQAppInterface.a(), paramString, paramString, paramQQAppInterface.a().getString(2131365187), NetConnInfoCenter.getServerTime(), 64523, 1, 0L);
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForGrayTips, false)) {
      paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.a());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\HWTroopUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */