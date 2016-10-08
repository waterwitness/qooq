package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.TestStructMsg;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hca;
import hcb;
import hcc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONObject;

public class VideoMsgTools
{
  static final String jdField_a_of_type_JavaLangString = "VideoMsgTools";
  static Map jdField_a_of_type_JavaUtilMap;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new HashMap();
  }
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString.contains(paramContext.getString(2131363321))) {
      return 2131428329;
    }
    if (paramBoolean) {
      return 2131428275;
    }
    return 2131428272;
  }
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2130839160;
    if (paramInt == 13) {
      if (paramBoolean1)
      {
        paramInt = i;
        if (paramBoolean2) {
          paramInt = 2130839161;
        }
      }
    }
    do
    {
      return paramInt;
      if (paramBoolean2) {
        return 2130838990;
      }
      return 2130838989;
      if (paramString.contains(paramContext.getString(2131363323)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130839260;
          }
          return 2130839259;
        }
        if (paramBoolean2) {
          return 2130838990;
        }
        return 2130838989;
      }
      if (paramString.contains(paramContext.getString(2131363324)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130839260;
          }
          return 2130839259;
        }
        if (paramBoolean2) {
          return 2130838990;
        }
        return 2130838989;
      }
      if (paramString.contains(paramContext.getString(2131363321)))
      {
        if (paramBoolean1) {
          return 2130839258;
        }
        return 2130838988;
      }
      if (paramString.contains(paramContext.getString(2131363327)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130839260;
          }
          return 2130839259;
        }
        if (paramBoolean2) {
          return 2130838990;
        }
        return 2130838989;
      }
      if (paramString.contains(paramContext.getString(2131363320)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130839260;
          }
          return 2130839259;
        }
        if (paramBoolean2) {
          return 2130838990;
        }
        return 2130838989;
      }
      if (paramString.contains(paramContext.getString(2131363326)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130839260;
          }
          return 2130839259;
        }
        if (paramBoolean2) {
          return 2130838990;
        }
        return 2130838989;
      }
      if (paramString.contains(paramContext.getString(2131363669)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130839260;
          }
          return 2130839259;
        }
        if (paramBoolean2) {
          return 2130838990;
        }
        return 2130838989;
      }
      if (!paramBoolean1) {
        break;
      }
      paramInt = i;
    } while (!paramBoolean2);
    return 2130839161;
    if (paramBoolean2) {
      return 2130838990;
    }
    return 2130838989;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramInt);
    localMessageRecord.selfuin = paramQQAppInterface.a();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramQQAppInterface.a();
    localMessageRecord.msg = paramString2;
    localMessageRecord.msgtype = paramInt;
    localMessageRecord.isread = true;
    localMessageRecord.issend = 0;
    localMessageRecord.istroop = 0;
    paramInt = MobileQQService.c;
    MobileQQService.c = paramInt + 1;
    localMessageRecord.msgseq = paramInt;
    localMessageRecord.shmsgseq = Math.abs(new Random().nextInt());
    localMessageRecord.msgUid = FileManagerUtil.b();
    localMessageRecord.time = MessageCache.a();
    paramQQAppInterface.a().a(localMessageRecord, paramQQAppInterface.a());
    QLog.i("VideoMsgTools", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + FileManagerUtil.e(localMessageRecord.selfuin) + "], frienduin[" + FileManagerUtil.e(localMessageRecord.frienduin) + "], senderuin[" + FileManagerUtil.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "]");
    return localMessageRecord.uniseq;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
    case 9: 
    case 15: 
    case 48: 
    case 59: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131363323);
        return paramContext + " " + paramString;
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363325);
      }
      return paramContext.getString(2131363324);
    case 2: 
    case 24: 
    case 47: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131363323);
        return paramContext + " " + paramString;
      }
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131363325);
        }
        return paramContext.getString(2131363324);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363322);
      }
      return paramContext.getString(2131363321);
    case 1: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363322);
      }
      return paramContext.getString(2131363321);
    case 3: 
      return paramContext.getString(2131363327);
    case 10: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363322);
      }
      return paramContext.getString(2131363321);
    case 7: 
      return paramContext.getString(2131363320);
    case 12: 
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131363325);
        }
        return paramContext.getString(2131363324);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363322);
      }
      return paramContext.getString(2131363321);
    case 42: 
    case 43: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363325);
      }
      return paramContext.getString(2131363324);
    case 49: 
      return paramContext.getString(2131363669);
    case 53: 
      return paramContext.getString(2131363671);
    }
    if (paramInt2 == 9500) {
      return paramContext.getString(2131363322);
    }
    return paramContext.getString(2131363321);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject5 = null;
    localJSONObject1 = null;
    if (paramQQAppInterface == null) {
      return;
    }
    String str = paramQQAppInterface.a();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)paramQQAppInterface.getManager(35)).a("101300.101301");
    Object localObject1 = localAppInfo.buffer.get();
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject7 = new JSONObject();
          if (((JSONObject)localObject7).optBoolean("isRead")) {
            continue;
          }
          localObject1 = ((JSONObject)localObject7).optString("_show_mission");
          JSONObject localJSONObject2 = ((JSONObject)localObject7).optJSONObject("param");
          if (localJSONObject2 == null) {
            continue;
          }
          localJSONObject1 = localJSONObject2.optJSONObject((String)localObject1);
          j = localJSONObject1.getInt("_red_ext_value");
        }
      }
      catch (Exception localException1)
      {
        Object localObject7;
        Object localObject2 = null;
        int i = 0;
        int j = 0;
        continue;
        i = 0;
        continue;
        i = 1004;
        continue;
        i = 1000;
        continue;
        i = 3;
        continue;
        i = 1;
        continue;
        i = 3000;
        continue;
        Object localObject3;
        Object localObject4 = null;
        i = 0;
        j = 0;
        Object localObject6 = localJSONObject1;
        continue;
      }
      try
      {
        i = localJSONObject1.getInt("_red_ext_call_type");
      }
      catch (Exception localException2)
      {
        localObject3 = null;
        i = 0;
        continue;
      }
      try
      {
        localObject1 = localJSONObject1.getString("_red_ext_uin");
      }
      catch (Exception localException3)
      {
        localObject4 = null;
        continue;
      }
      try
      {
        localObject5 = localJSONObject1.getString("_red_ext_id");
      }
      catch (Exception localException4)
      {
        localObject7 = null;
        localObject6 = localObject4;
        localObject4 = localObject7;
        continue;
      }
      try
      {
        ((JSONObject)localObject7).put("isRead", true);
        localAppInfo.buffer.set(((JSONObject)localObject7).toString());
        localObject7 = localObject1;
        localObject1 = localObject5;
        localObject5 = localObject7;
        if (QLog.isColorLevel()) {
          QLog.d("VideoMsgTools", 2, "WL_DEBUG addPstnRedTouchMsg _red_ext_call_type = " + i + ", friendUin = " + (String)localObject5 + ", senderUin = " + str);
        }
        if ((j == 0) || (localObject5 == null)) {
          break;
        }
        switch (i)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          i = 0;
          localObject7 = String.format(paramQQAppInterface.a().getString(2131364032), new Object[] { Integer.valueOf(j) });
          localObject5 = new UniteGrayTipParam((String)localObject5, str, (String)localObject7, i, 60496, 131073, MessageCache.a());
          ((UniteGrayTipParam)localObject5).d = ((String)localObject1);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_action", 1);
          ((Bundle)localObject1).putString("key_action_DATA", "http://pubacc.mobile.qq.com/yunying/lightalk_pay/qq/index.html?_wv=1025&type=");
          ((UniteGrayTipParam)localObject5).a(0, ((String)localObject7).length(), (Bundle)localObject1);
          localObject1 = new MessageForUniteGrayTip();
          ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject5);
          UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject1);
          return;
        }
      }
      catch (Exception localException5)
      {
        Object localObject8 = localObject4;
        localObject4 = localObject6;
        localObject6 = localObject8;
        continue;
      }
      localObject7 = new JSONObject((String)localObject1);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "showGuideBar uinType: " + paramInt1 + ", msgType: " + paramInt2 + ", isVideoMsg: " + paramBoolean + ", friendUin: " + paramString1 + ", selfUin: " + paramString2 + ", videoTime: " + paramString3 + ", msgStr: " + paramString4);
    }
    if (1008 == paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "public account should not show guide bar.");
      }
      return;
    }
    ThreadManager.b(new hcc(paramInt2, paramQQAppInterface, paramBoolean, paramString3, paramString2, paramString1));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addLightalkMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", isVideoMsg = " + paramBoolean1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", extra = " + paramString3 + ", isRead = " + paramBoolean3);
    }
    paramQQAppInterface.a();
    paramString3 = TransfileUtile.a(a(paramQQAppInterface.a(), paramInt2, paramInt1, paramBoolean2, paramString3), paramInt2, 3, paramBoolean1);
    String str = paramQQAppInterface.a();
    paramString2 = MessageRecordFactory.a(63510);
    paramString2.selfuin = str;
    paramString2.frienduin = paramString1;
    paramString2.senderuin = str;
    paramString2.msg = paramString3;
    paramString2.msgtype = 63510;
    paramString2.isread = false;
    paramString2.issend = 0;
    paramString2.extraflag = 3;
    paramString2.time = MessageCache.a();
    if (paramInt1 == 26)
    {
      paramString2.istroop = paramInt1;
      if (!paramBoolean2) {
        break label309;
      }
      paramString2.issend = 1;
      label233:
      if ((paramQQAppInterface.a(paramQQAppInterface.a())) && (!QQUtils.a(paramQQAppInterface.a()))) {
        break label318;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "background");
      }
    }
    for (;;)
    {
      paramQQAppInterface = (QCallFacade)paramQQAppInterface.getManager(37);
      paramQQAppInterface.a((MessageForVideo)paramString2, false);
      paramQQAppInterface.a((MessageForVideo)paramString2);
      return;
      paramString2.istroop = 8;
      break;
      label309:
      paramString2.issend = 0;
      break label233;
      label318:
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "foreground");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, int paramInt3, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addVideoMsgWithAvtype uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", isVideoMsg = " + paramBoolean1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", extra = " + paramString3 + ", isRead = " + paramBoolean3 + ", avtype = " + paramInt3);
    }
    if (paramInt1 == 2) {
      a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
    }
    do
    {
      do
      {
        return;
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!paramString1.equals(paramQQAppInterface.a()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
      return;
    } while ((paramInt1 == 1011) || (paramInt1 == 2800) || (paramInt1 == -1));
    if (paramInt1 == 1000)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
      if ((localTroopManager != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString2 = localTroopManager.a(paramString2);
        if (paramString2 != null) {
          paramString2 = paramString2.troopcode;
        }
      }
    }
    for (;;)
    {
      if (((paramQQAppInterface.a().g() == 1) || (paramQQAppInterface.a().g() == 2)) && ((paramInt2 == 15) || (paramInt2 == 9))) {
        if ((paramQQAppInterface.a().g() != 2) || (paramInt2 != 15)) {
          break label488;
        }
      }
      label488:
      for (boolean bool = true;; bool = paramBoolean1)
      {
        b(paramQQAppInterface, paramInt1, paramInt2, bool, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
        new Handler().postDelayed(new hca(paramInt2, paramQQAppInterface, paramInt1, paramBoolean1, paramString1, paramString3, paramString2, paramInt3, paramVarArgs), 500L);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("VideoMsgTools", 2, "can't find troop info!");
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("VideoMsgTools", 2, "can't get friend manager!");
        return;
        if (a(paramInt2))
        {
          if (b(paramInt2))
          {
            a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramBoolean2, paramBoolean3, paramInt3, paramVarArgs);
            return;
          }
          b(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
          return;
        }
        if (b(paramInt2))
        {
          b(paramQQAppInterface, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramVarArgs);
          return;
        }
        b(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString3);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", isVideoMsg = " + paramBoolean1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", extra = " + paramString3 + ", isRead = " + paramBoolean3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramString1.equals(paramQQAppInterface.a()))) {
      if (QLog.isColorLevel())
      {
        QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
        break label150;
      }
    }
    label150:
    while ((paramInt1 == 1011) || (paramInt1 == 2800) || (paramInt1 == -1)) {
      return;
    }
    if (paramInt1 == 1000)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
      if ((localTroopManager != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString2 = localTroopManager.a(paramString2);
        if (paramString2 != null) {
          paramString2 = paramString2.troopcode;
        }
      }
    }
    for (;;)
    {
      if (a(paramInt2))
      {
        if (b(paramInt2))
        {
          a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramBoolean2, paramBoolean3, 0, paramVarArgs);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoMsgTools", 2, "can't find troop info!");
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoMsgTools", 2, "can't get friend manager!");
          return;
        }
        b(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
        return;
      }
      if (b(paramInt2))
      {
        b(paramQQAppInterface, paramInt1, paramInt2, paramString1, paramString2, paramString3, 0, paramVarArgs);
        return;
      }
      b(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString3);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    int i = VipFunCallManager.a(paramQQAppInterface, paramString1, 6, true, null);
    if (i == 0) {}
    QQMessageFacade localQQMessageFacade;
    MessageRecord localMessageRecord;
    do
    {
      String str1;
      String str2;
      do
      {
        return;
        str1 = VipFunCallManager.b(paramQQAppInterface, i, -1, "name");
        str2 = VipFunCallManager.b(paramQQAppInterface, i, 8, null);
      } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
      localQQMessageFacade = paramQQAppInterface.a();
      paramQQAppInterface = paramQQAppInterface.a();
      localMessageRecord = MessageRecordFactory.a(62524);
      localMessageRecord.selfuin = paramQQAppInterface;
      localMessageRecord.frienduin = paramString1;
      localMessageRecord.senderuin = paramQQAppInterface;
      localMessageRecord.msg = paramString2;
      localMessageRecord.msgtype = 62524;
      localMessageRecord.isread = true;
      localMessageRecord.issend = 0;
      localMessageRecord.istroop = paramInt1;
      localMessageRecord.saveExtInfoToExtStr("callId", i + "");
      localMessageRecord.saveExtInfoToExtStr("name", str1);
      localMessageRecord.saveExtInfoToExtStr("url_call_thum", str2);
      localMessageRecord.saveExtInfoToExtStr("tipsType", paramInt2 + "");
      localMessageRecord.extraflag = 3;
      localMessageRecord.time = MessageCache.a();
    } while ((paramInt1 == 1000) || (paramInt1 == 1020) || (paramInt1 == 1004));
    localQQMessageFacade.a(localMessageRecord, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addPstnMsg uinType:" + paramInt + ", friendUin:" + paramString1 + ", senderUin:" + paramString2 + ", isPstn:" + paramBoolean + ", callId:" + paramString3);
    }
    paramQQAppInterface.a();
    String str1 = TransfileUtile.a(a(paramQQAppInterface.a(), 59, paramInt, true, "0"), 59, 3, false);
    String str2 = paramQQAppInterface.a();
    paramString2 = MessageRecordFactory.a(63490);
    paramString2.selfuin = str2;
    paramString2.frienduin = paramString1;
    paramString2.senderuin = str2;
    paramString2.msg = str1;
    paramString2.msgtype = 63490;
    paramString2.isread = true;
    paramString2.issend = 1;
    paramString2.istroop = paramInt;
    paramString2.extraflag = 3;
    paramString2.time = MessageCache.a();
    paramString1 = (QCallFacade)paramQQAppInterface.getManager(37);
    paramQQAppInterface = (PstnManager)paramQQAppInterface.getManager(142);
    try
    {
      paramString1.a((MessageForVideo)paramString2, false);
      paramQQAppInterface.a(paramString3, paramString2);
      paramString1.a((MessageForVideo)paramString2);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("VideoMsgTools", 2, "insert pstn record exception:" + paramQQAppInterface);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMultiVideoMsg uinType = " + paramInt1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2);
    }
    String str = paramQQAppInterface.a();
    AVNotifyCenter localAVNotifyCenter = paramQQAppInterface.a();
    int i = localAVNotifyCenter.b(Long.valueOf(paramString1).longValue());
    if (paramInt2 != 0) {
      i = paramInt2;
    }
    if (paramInt1 == 3000) {}
    for (paramInt2 = 1;; paramInt2 = i)
    {
      if (!a.containsKey(paramString1 + String.valueOf(paramInt2))) {
        a.put(paramString1 + String.valueOf(paramInt2), "add");
      }
      i = UITools.a(paramInt1);
      if (paramQQAppInterface.a().a(i, paramString1)) {}
      while ((TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 2)) {
        return;
      }
      Object localObject1;
      if (paramInt1 == 3000) {
        localObject1 = paramQQAppInterface.a().getString(2131363478);
      }
      for (;;)
      {
        Object localObject3 = null;
        Object localObject2 = localObject3;
        if (paramVarArgs != null)
        {
          localObject2 = localObject3;
          if (paramVarArgs.length > 0)
          {
            localObject2 = localObject3;
            if (paramVarArgs[0] != null)
            {
              localObject2 = localObject3;
              if ((paramVarArgs[0] instanceof msg_comm.Msg)) {
                localObject2 = (msg_comm.Msg)paramVarArgs[0];
              }
            }
          }
        }
        long l = 0L;
        if (localObject2 != null) {
          l = ((msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get()).msg_time.get();
        }
        paramVarArgs = TransfileUtile.a((String)localObject1, 13L, 3, true);
        localObject1 = MessageRecordFactory.a(63520);
        ((MessageRecord)localObject1).selfuin = str;
        ((MessageRecord)localObject1).frienduin = paramString1;
        ((MessageRecord)localObject1).senderuin = paramString2;
        ((MessageRecord)localObject1).msg = (paramVarArgs + "|" + paramInt2);
        ((MessageRecord)localObject1).msgtype = 63520;
        ((MessageRecord)localObject1).isread = paramBoolean2;
        if (paramInt1 == 3000) {
          ((MessageRecord)localObject1).isread = true;
        }
        if (paramBoolean1)
        {
          ((MessageRecord)localObject1).issend = 1;
          label411:
          ((MessageRecord)localObject1).istroop = paramInt1;
          ((MessageRecord)localObject1).extraflag = 3;
          if (localAVNotifyCenter != null) {
            ((MessageRecord)localObject1).extInt = paramInt2;
          }
          if (l <= 0L) {
            break label512;
          }
        }
        label512:
        for (((MessageRecord)localObject1).time = l;; ((MessageRecord)localObject1).time = MessageCache.a())
        {
          paramQQAppInterface.a().a((MessageRecord)localObject1, paramBoolean2);
          return;
          if (paramInt1 != 1) {
            break label523;
          }
          if (paramInt2 == 10)
          {
            localObject1 = paramQQAppInterface.a().getString(2131363480);
            break;
          }
          localObject1 = paramQQAppInterface.a().getString(2131363479);
          break;
          ((MessageRecord)localObject1).issend = 0;
          break label411;
        }
        label523:
        localObject1 = null;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    switch (paramInt)
    {
    case 1006: 
    default: 
      return;
    }
    paramQQAppInterface.m(paramString1, paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = (QCallFacade)paramQQAppInterface.getManager(37);
    try
    {
      paramQQAppInterface.b((MessageForVideo)paramMessageRecord);
      paramQQAppInterface.a((MessageForVideo)paramMessageRecord);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("VideoMsgTools", 2, "update pstn record exception = " + paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addDiscussMember discussUin = " + paramString);
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), GAudioMembersCtrlActivity.class);
    localIntent.putExtra("discussUin", paramString);
    localIntent.addFlags(268435456);
    paramQQAppInterface.getApplication().startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "send_struct_massage_upgrade.peerUin = " + paramString + ", type = " + paramInt);
    }
    Object localObject = SharedPreUtils.d(paramQQAppInterface.a());
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoMsgTools", 2, "configXML : " + (String)localObject);
      }
      if (localObject == null) {
        break label178;
      }
      localObject = TestStructMsg.a((String)localObject);
      if (localObject == null) {
        break;
      }
      ShareMsgHelper.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject, null);
      return;
      localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_video", null);
      continue;
      localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_multi", null);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoMsgTools", 2, "absMsg is null! use default");
    }
    b(paramQQAppInterface, paramString, paramInt);
    return;
    label178:
    if (QLog.isColorLevel()) {
      QLog.i("VideoMsgTools", 2, "configXML is null! use default");
    }
    b(paramQQAppInterface, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addDiscussMember discussUin = " + paramString);
    }
    ArrayList localArrayList2 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    if (localArrayList2 != null)
    {
      int j = localArrayList2.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (DiscussionMemberInfo)localArrayList2.get(i);
        if (localObject1 != null) {
          localArrayList1.add(((DiscussionMemberInfo)localObject1).memberUin);
        }
        i += 1;
      }
    }
    if (((PstnManager)paramQQAppInterface.getManager(142)).a() == 1)
    {
      localArrayList2 = new ArrayList();
      if (paramArrayList1 != null)
      {
        localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
        if (localObject1 != null)
        {
          paramArrayList1 = paramArrayList1.iterator();
          while (paramArrayList1.hasNext())
          {
            Object localObject2 = (Long)paramArrayList1.next();
            localObject2 = ((PhoneContactManager)localObject1).a(localObject2 + "");
            if (localObject2 != null) {
              localArrayList2.add(((PhoneContact)localObject2).mobileNo);
            }
          }
        }
      }
      if (paramArrayList2 != null) {
        localArrayList2.addAll(paramArrayList2);
      }
      paramArrayList1 = new Intent(paramQQAppInterface.getApplication(), PhoneContactSelectActivity.class);
      paramArrayList1.putStringArrayListExtra("param_uin_selected_default_friends", localArrayList1);
      if (paramArrayList3 != null) {
        paramArrayList1.putStringArrayListExtra("param_uin_selected_default_contact", paramArrayList3);
      }
      paramArrayList1.putExtra("param_groupcode", paramString);
      paramArrayList1.putExtra("param_type", 3000);
      paramArrayList1.putExtra("param_subtype", 1);
      paramArrayList1.putExtra("param_entrance", 19);
      paramArrayList1.putExtra("param_max", 100 - localArrayList1.size());
      paramArrayList1.putExtra("param_ui_flag", paramInt);
      paramArrayList1.putExtra("param_uin_divider_list", localArrayList2);
      paramArrayList1.putExtra("param_divider_title", paramQQAppInterface.a().getString(2131372484));
      paramArrayList1.putExtra("param_no_answer_list_default_selected", paramBoolean);
      paramArrayList1.addFlags(268435456);
      paramArrayList1.putExtra("sendToVideo", true);
      paramArrayList1.putExtra("ShowJoinDiscTips", true);
      paramArrayList1.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131372488));
      paramArrayList1.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131369290));
      paramArrayList1.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131370215));
      paramQQAppInterface.getApplication().startActivity(paramArrayList1);
      return;
    }
    paramArrayList1 = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    paramArrayList1.putStringArrayListExtra("param_uins_selected_default", localArrayList1);
    paramArrayList1.putExtra("param_groupcode", paramString);
    paramArrayList1.putExtra("param_type", 3000);
    paramArrayList1.putExtra("param_subtype", 1);
    paramArrayList1.putExtra("param_entrance", 11);
    paramArrayList1.putExtra("param_max", 100 - localArrayList1.size());
    paramArrayList1.addFlags(268435456);
    paramArrayList1.putExtra("sendToVideo", true);
    paramArrayList1.putExtra("ShowJoinDiscTips", true);
    paramArrayList1.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131363438));
    paramArrayList1.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131369290));
    paramArrayList1.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131370215));
    paramQQAppInterface.getApplication().startActivity(paramArrayList1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMembersToNewDiscuAndStartMulAudioChat groupUin: " + paramString1 + ", gruopName: " + paramString2);
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    ArrayList localArrayList = new ArrayList();
    Resources localResources = paramQQAppInterface.getApplication().getResources();
    localArrayList.add(paramQQAppInterface.a());
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
    localIntent.putExtra("group_uin", paramString1);
    localIntent.putExtra("group_name", paramString2);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_entrance", 13);
    localIntent.addFlags(268435456);
    localIntent.putExtra("param_title", localResources.getString(2131363952));
    localIntent.putExtra("param_done_button_wording", localResources.getString(2131363950));
    localIntent.putExtra("param_done_button_highlight_wording", localResources.getString(2131363951));
    localIntent.putExtra("param_only_troop_member", true);
    paramQQAppInterface.getApplication().startActivity(localIntent);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 24) || (paramInt == 3) || (paramInt == 7) || (paramInt == 10) || (paramInt == 12) || (paramInt == 42) || (paramInt == 43) || (paramInt == 13) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 53) || (paramInt == 6) || (paramInt == 9);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    return (paramQQAppInterface.a().g() == 4) || (paramQQAppInterface.a().b());
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (((DiscussionHandler)paramQQAppInterface.a(6)).b(paramString1)) {
      return true;
    }
    paramQQAppInterface = (DiscussionManager)paramQQAppInterface.getManager(52);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a(paramString1, paramString2) != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Object localObject = paramQQAppInterface.a();
    switch (paramInt)
    {
    default: 
      paramQQAppInterface = null;
    }
    label396:
    for (;;)
    {
      if (paramQQAppInterface != null)
      {
        paramInt = 0;
        for (;;)
        {
          if (paramInt < paramQQAppInterface.length)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoMsgTools", 2, "sig[" + paramInt + "]:" + (paramQQAppInterface[paramInt] & 0xFF));
            }
            paramInt += 1;
            continue;
            byte[] arrayOfByte = new byte[3];
            tmp138_137 = arrayOfByte;
            tmp138_137[0] = 1;
            tmp144_138 = tmp138_137;
            tmp144_138[1] = 1;
            tmp150_144 = tmp144_138;
            tmp150_144[2] = 124;
            tmp150_144;
            localObject = ((MessageCache)localObject).k(paramString);
            int i = arrayOfByte.length;
            paramInt = i;
            if (localObject != null) {
              paramInt = i + localObject.length;
            }
            paramString = new byte[paramInt];
            System.arraycopy(arrayOfByte, 0, paramString, 0, arrayOfByte.length);
            paramQQAppInterface = paramString;
            if (localObject == null) {
              break label396;
            }
            System.arraycopy(localObject, 0, paramString, arrayOfByte.length, localObject.length);
            paramQQAppInterface = paramString;
            break;
            paramQQAppInterface = null;
            break;
            paramQQAppInterface = ((MessageCache)localObject).h(paramString);
            break;
            arrayOfByte = new byte[3];
            tmp241_240 = arrayOfByte;
            tmp241_240[0] = 1;
            tmp247_241 = tmp241_240;
            tmp247_241[1] = 1;
            tmp253_247 = tmp247_241;
            tmp253_247[2] = 58;
            tmp253_247;
            localObject = paramQQAppInterface.a().d(paramString);
            i = arrayOfByte.length;
            paramInt = i;
            if (localObject != null) {
              paramInt = i + localObject.length;
            }
            paramString = new byte[paramInt];
            System.arraycopy(arrayOfByte, 0, paramString, 0, arrayOfByte.length);
            paramQQAppInterface = paramString;
            if (localObject == null) {
              break label396;
            }
            System.arraycopy(localObject, 0, paramString, arrayOfByte.length, localObject.length);
            paramQQAppInterface = paramString;
            break;
            paramString = ((MessageCache)localObject).n(paramString);
            if (paramString != null)
            {
              paramQQAppInterface = new byte[paramString.length + 3];
              paramQQAppInterface[0] = 1;
              paramQQAppInterface[1] = 1;
              paramQQAppInterface[2] = -119;
              System.arraycopy(paramString, 0, paramQQAppInterface, 3, paramString.length);
              break;
            }
            paramQQAppInterface = new byte[] { 1, 1, -119 };
            break;
          }
        }
      }
      return paramQQAppInterface;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, Object... paramVarArgs)
  {
    if (paramString1 != null) {}
    for (long l = Long.valueOf(paramString1).longValue();; l = 0L)
    {
      int j = paramQQAppInterface.a().b(l);
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "addTipsMultiVideoMsg msgType = " + paramInt2 + ", discussionUin = " + paramString1 + ", memberUin = " + paramString2 + ", uinType = " + paramInt1 + ", extra = " + paramString3 + ", avtype = " + j);
      }
      int i = j;
      if (paramVarArgs != null)
      {
        i = j;
        if (paramVarArgs.length > 0)
        {
          i = j;
          if (paramVarArgs[0] != null)
          {
            i = j;
            if ((paramVarArgs[0] instanceof Integer)) {
              i = ((Integer)paramVarArgs[0]).intValue();
            }
          }
        }
      }
      if (paramInt3 != 0) {
        i = paramInt3;
      }
      if (paramInt1 == 3000) {
        i = 1;
      }
      paramInt3 = UITools.a(paramInt1);
      if (paramQQAppInterface.a().a(paramInt3, paramString1)) {}
      QQMessageFacade localQQMessageFacade;
      do
      {
        return;
        paramVarArgs = paramQQAppInterface.a();
        localQQMessageFacade = paramQQAppInterface.a();
      } while (localQQMessageFacade == null);
      switch (paramInt2)
      {
      default: 
        if (paramInt1 == 3000) {
          paramString2 = paramQQAppInterface.a().getString(2131363482);
        }
        break;
      }
      for (;;)
      {
        label339:
        if ((59 != paramInt2) && (paramInt2 != 60)) {
          if (i == 2) {
            if (paramString2 == null) {
              break label1167;
            }
          }
        }
        label1167:
        for (paramQQAppInterface = paramString2.replace(paramQQAppInterface.a().getString(2131368098), paramQQAppInterface.a().getString(2131368099));; paramQQAppInterface = paramString2)
        {
          paramString2 = MessageRecordFactory.a(61528);
          paramString2.selfuin = paramVarArgs;
          paramString2.frienduin = paramString1;
          paramString2.senderuin = paramVarArgs;
          paramString2.msg = paramQQAppInterface;
          paramString2.msgtype = 61528;
          paramString2.isread = true;
          paramString2.issend = 1;
          paramString2.istroop = paramInt1;
          paramString2.extraflag = 3;
          paramString2.time = MessageCache.a();
          paramQQAppInterface = new ArrayList();
          paramQQAppInterface.add(paramString2);
          localQQMessageFacade.c(paramQQAppInterface, paramVarArgs);
          return;
          if (paramVarArgs.equals(paramString2))
          {
            if (paramInt1 == 3000)
            {
              paramString2 = paramQQAppInterface.a().getString(2131363476);
              break label339;
            }
            if (paramInt1 != 1) {
              break label1173;
            }
            paramString2 = paramQQAppInterface.a().getString(2131363477);
            break label339;
          }
          paramString2 = ContactUtils.c(paramQQAppInterface, paramString1, paramString2);
          if (paramInt1 == 3000)
          {
            paramString2 = paramString2 + paramQQAppInterface.a().getString(2131363478);
            break label339;
          }
          if (paramInt1 != 1) {
            break label1173;
          }
          paramString2 = paramString2 + paramQQAppInterface.a().getString(2131363479);
          break label339;
          paramQQAppInterface.a().a(l, 0);
          if (!a.containsKey(paramString1 + String.valueOf(i))) {
            break;
          }
          a.remove(paramString1 + String.valueOf(i));
          if (paramInt1 == 3000)
          {
            paramString2 = paramQQAppInterface.a().getString(2131363482);
            break label339;
          }
          if (paramInt1 != 1) {
            break label1173;
          }
          paramString2 = paramQQAppInterface.a().getString(2131363483);
          break label339;
          paramQQAppInterface.a().a(l, 0);
          paramString2 = paramQQAppInterface.a().getString(2131363484);
          break label339;
          paramQQAppInterface.a().a(l, 0);
          if (paramInt1 == 3000)
          {
            paramString2 = paramQQAppInterface.a().getString(2131363485);
            break label339;
          }
          if (paramInt1 == 1)
          {
            paramString2 = paramQQAppInterface.a().getString(2131363486);
            break label339;
          }
          paramString2 = paramQQAppInterface.a().getString(2131363487);
          break label339;
          paramQQAppInterface.a().a(l, 0);
          if (paramInt1 == 3000)
          {
            paramString2 = paramQQAppInterface.a().getString(2131363488);
            break label339;
          }
          if (paramInt1 != 1) {
            break label1173;
          }
          paramString2 = paramQQAppInterface.a().getString(2131363489);
          break label339;
          paramQQAppInterface.a().a(l, 0);
          if (paramInt1 == 3000)
          {
            paramString2 = paramQQAppInterface.a().getString(2131363490);
            break label339;
          }
          if (paramInt1 != 1) {
            break label1173;
          }
          paramInt3 = 0;
          if (paramString3 != null) {
            paramInt3 = Integer.parseInt(paramString3);
          }
          if (paramInt3 == 19)
          {
            paramString2 = paramQQAppInterface.a().getString(2131363492);
            break label339;
          }
          paramString2 = paramQQAppInterface.a().getString(2131363491);
          break label339;
          paramQQAppInterface.a().a(l, 0);
          if (paramInt1 == 3000)
          {
            paramString2 = paramQQAppInterface.a().getString(2131363495);
            break label339;
          }
          if (paramInt1 != 1) {
            break label1173;
          }
          paramString2 = paramQQAppInterface.a().getString(2131363496);
          break label339;
          if (paramInt1 == 3000)
          {
            paramString2 = paramQQAppInterface.a().getString(2131363493);
            break label339;
          }
          if (paramInt1 != 1) {
            break label1173;
          }
          paramString2 = paramQQAppInterface.a().getString(2131363493);
          break label339;
          paramString2 = paramQQAppInterface.a().getString(2131363328) + paramString3;
          break label339;
          paramString2 = paramQQAppInterface.a().getString(2131363602);
          break label339;
          paramString2 = paramQQAppInterface.a().getString(2131363603);
          break label339;
          if (paramInt1 != 1) {
            break label1173;
          }
          paramString2 = paramQQAppInterface.a().getString(2131363483);
          break label339;
          if ((i != 10) || (!a(paramQQAppInterface))) {}
        }
        label1173:
        paramString2 = null;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addTipsVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1);
    }
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    String str1;
    String str2;
    if (localQQMessageFacade != null) {
      switch (paramInt2)
      {
      case 6: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 26: 
      case 27: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 36: 
      case 37: 
      case 38: 
      case 42: 
      case 43: 
      case 44: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 53: 
      case 54: 
      default: 
        paramString2 = paramQQAppInterface.a().getString(2131363581);
        str1 = paramQQAppInterface.a();
        str2 = TransfileUtile.a(paramString2, 0L, 3, paramBoolean);
        if (paramInt1 == 9500) {
          ((DeviceMsgHandle)paramQQAppInterface.a(49)).a(paramString1, paramString2, MessageCache.a(), false, false, true);
        }
        break;
      }
    }
    do
    {
      return;
      paramString2 = paramQQAppInterface.a().getString(2131363164);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363167);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363165);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363166);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363168);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363169);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363171);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363286);
      break;
      if (paramBoolean)
      {
        paramString2 = paramQQAppInterface.a().getString(2131363172);
        break;
      }
      paramString2 = paramQQAppInterface.a().getString(2131363173);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363176);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363177);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363224);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363225);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363226);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363228);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363227);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363557);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363328) + paramString2;
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363581);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363670);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363672);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363673);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363674);
      break;
      paramString2 = paramQQAppInterface.a().getString(2131363528);
      break;
      paramString2 = MessageRecordFactory.a(64535);
      paramString2.selfuin = str1;
      paramString2.frienduin = paramString1;
      paramString2.senderuin = str1;
      paramString2.msg = str2;
      paramString2.msgtype = 64535;
      paramString2.isread = true;
      paramString2.issend = 0;
      paramString2.istroop = paramInt1;
      paramString2.extraflag = 3;
      paramString2.time = MessageCache.a();
      localQQMessageFacade.a(paramString2, str1);
      if ((paramInt2 == 2) || (paramInt2 == 24))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "0", "", "", "");
        return;
      }
    } while (paramInt2 != 0);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "0", "", "", "");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addBubbleVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", time = " + paramString3 + ", isRead = " + paramBoolean3);
    }
    String str1 = paramQQAppInterface.a();
    String str2 = a(paramQQAppInterface.a(), paramInt2, paramInt1, paramBoolean2, paramString3);
    String str3 = TransfileUtile.a(str2, paramInt2, 3, paramBoolean1);
    if (paramInt1 == 9500)
    {
      ((DeviceMsgHandle)paramQQAppInterface.a(49)).a(paramString1, str2, MessageCache.a(), false, false, true);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof msg_comm.Msg))) {}
    for (paramVarArgs = (msg_comm.Msg)paramVarArgs[0];; paramVarArgs = null)
    {
      if (paramVarArgs != null) {}
      for (long l1 = ((msg_comm.MsgHead)paramVarArgs.msg_head.get()).msg_time.get();; l1 = 0L)
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label595;
        }
        paramVarArgs = MessageRecordFactory.a(63527);
        paramVarArgs.selfuin = str1;
        paramVarArgs.frienduin = paramString1;
        paramVarArgs.senderuin = paramString2;
        paramVarArgs.msg = str3;
        paramVarArgs.msgtype = 63527;
        if (paramString2.equals(paramString1)) {
          paramBoolean2 = false;
        }
        paramVarArgs.isread = paramBoolean3;
        if ((paramInt1 == 0) || (paramInt1 == 1000) || (paramInt1 == 1004) || (paramInt1 == 1006) || (paramInt1 == 1021) || (paramInt1 == 1010) || (paramInt1 == 1001)) {
          paramVarArgs.isread = true;
        }
        label356:
        long l3;
        if (paramBoolean2)
        {
          paramVarArgs.issend = 1;
          paramVarArgs.istroop = paramInt1;
          paramVarArgs.extraflag = 3;
          paramString2 = (QCallFacade)paramQQAppInterface.getManager(37);
          if (paramString2 == null) {
            break label585;
          }
          paramString2 = paramString2.a().a(paramString1, paramInt1);
          if (paramString2 == null) {
            break label585;
          }
          l3 = paramString2.lastCallTime;
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "VideoMsgTools updateDoubleCallStatus lastCallTime = " + paramString2.lastCallTime);
          }
        }
        label585:
        for (long l2 = l3;; l2 = 0L)
        {
          if (l1 > 0L) {
            paramVarArgs.time = l1;
          }
          for (;;)
          {
            ThreadManager.b(new hcb(paramQQAppInterface, paramVarArgs, paramBoolean3, str1));
            a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, str1, paramString3, str3);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VideoMsgTools", 2, "addBubbleVideoMsg end");
            return;
            paramVarArgs.issend = 0;
            break label356;
            if (str2.equals(paramQQAppInterface.a().getString(2131363321)))
            {
              paramVarArgs.time = MessageCache.a();
            }
            else if (l2 > 0L)
            {
              paramVarArgs.time = l2;
            }
            else
            {
              MessageCache.a();
              paramQQAppInterface.a().c();
            }
          }
        }
      }
      label595:
      break;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addDiscussMemberFromC2C uin = " + paramString);
    }
    if (((PstnManager)paramQQAppInterface.getManager(142)).a() == 1)
    {
      localIntent = new Intent(paramQQAppInterface.getApplication(), PhoneContactSelectActivity.class);
      localIntent.putExtra("param_type", 3000);
      localIntent.putExtra("param_subtype", 0);
      localIntent.putExtra("param_from", 1001);
      localIntent.putExtra("param_entrance", 20);
      localIntent.putExtra("param_ui_flag", 0);
      localArrayList = new ArrayList();
      localArrayList.add(paramString);
      localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
      localIntent.putExtra("param_add_passed_members_to_result_set", true);
      localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
      localIntent.addFlags(268435456);
      localIntent.putExtra("sendToVideo", true);
      localIntent.putExtra("ShowJoinDiscTips", true);
      localIntent.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131363438));
      localIntent.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131369290));
      localIntent.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131370215));
      paramQQAppInterface.getApplication().startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sendToVideo", true);
    localIntent.putExtra("ShowJoinDiscTips", true);
    localIntent.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131363438));
    localIntent.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131369290));
    localIntent.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131370215));
    paramQQAppInterface.getApplication().startActivity(localIntent);
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str1 = paramQQAppInterface.a().getApplicationContext().getString(2131363913);
    Object localObject = paramQQAppInterface.a().getApplicationContext().getString(2131363912);
    localObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(62).a((String)localObject).e("http://im.qq.com/mobileqq/touch").a(str1, null).a();
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    str1 = paramQQAppInterface.a().getApplicationContext().getString(2131363910);
    String str2 = paramQQAppInterface.a().getApplicationContext().getString(2131363907);
    if (paramInt == 1) {
      str1 = paramQQAppInterface.a().getApplicationContext().getString(2131363911);
    }
    localAbsStructMsgItem.a("http://url.cn/hw298C", str2, str1);
    ((AbsShareMsg)localObject).addItem(localAbsStructMsgItem);
    ShareMsgHelper.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject, null);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 20) || (paramInt == 19) || (paramInt == 44) || (paramInt == 59) || (paramInt == 60) || (paramInt == 22);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\VideoMsgTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */