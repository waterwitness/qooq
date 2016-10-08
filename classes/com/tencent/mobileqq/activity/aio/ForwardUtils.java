package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import ndc;
import ndd;
import nde;

public class ForwardUtils
{
  public static final String a = "ForwardUtils";
  
  public ForwardUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return AIORichMediaInfo.a(paramMessageForPic);
  }
  
  public static SessionInfo a(Intent paramIntent)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    localSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    if (localSessionInfo.jdField_a_of_type_Int == 1026)
    {
      localSessionInfo.jdField_a_of_type_Int = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    localSessionInfo.e = paramIntent.getStringExtra("phonenum");
    localSessionInfo.c = paramIntent.getIntExtra("entrance", 0);
    localSessionInfo.b = paramIntent.getStringExtra("troop_uin");
    localSessionInfo.d = paramIntent.getIntExtra("add_friend_source_id", 10004);
    return localSessionInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return "";
    }
    int i = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString2);
    int j = paramString1.length();
    int k = paramQQAppInterface.getApplication().getResources().getInteger(2131623941);
    paramQQAppInterface = paramString1;
    if (j > k)
    {
      paramQQAppInterface = paramString1.substring(0, k);
      paramQQAppInterface = paramQQAppInterface + "...";
    }
    return paramQQAppInterface + "(" + i + ")";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleAppShareAction() type" + paramSessionInfo.jdField_a_of_type_Int + "uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      try
      {
        localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
        if (localAbsStructMsg == null) {
          return;
        }
        localAbsStructMsg.sourceAccoutType = paramIntent.getIntExtra("accostType", 0);
        if (!(localAbsStructMsg instanceof StructMsgForImageShare)) {
          continue;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        AbsStructMsg localAbsStructMsg;
        int i;
        Object localObject;
        String str;
        long l;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardUtils", 2, "handleAppShareAction Exception", paramQQAppInterface);
        paramQQAppInterface.printStackTrace();
        return;
        ShareMsgHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramSessionInfo.jdField_a_of_type_Int, localAbsStructMsg, null);
        continue;
      }
      finally
      {
        paramIntent.removeExtra("forward_type");
        paramIntent.removeExtra("res_share_id");
      }
      if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (CGILoader.a((AbsShareMsg)localAbsStructMsg)))
      {
        i = localAbsStructMsg.uinType;
        localObject = CGILoader.a(localAbsStructMsg.mMsgUrl);
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          ReportController.b(null, "CliOper", "", "", "0X8005F54", "0X8005F54", 0, 0, CGILoader.a(i) + "", "", (String)localObject, "");
        }
      }
      str = paramIntent.getStringExtra("share_comment_message");
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = localAbsStructMsg.mCommentText;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        AnonymousChatHelper.a().a = true;
        ChatActivityFacade.b(paramQQAppInterface, paramContext, paramSessionInfo, (String)localObject);
      }
      paramIntent.removeExtra("forward_type");
      paramIntent.removeExtra("res_share_id");
      return;
      if (35 != localAbsStructMsg.mMsgServiceID) {
        continue;
      }
      l = paramIntent.getLongExtra("structmsg_uniseq", 0L);
      MultiMsgManager.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b, localAbsStructMsg, l, false);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleForwardData");
    }
    SessionInfo localSessionInfo = a(paramIntent);
    if ((localSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(47)).a(localSessionInfo.jdField_a_of_type_JavaLangString, true).a))
    {
      QQToast.a(paramQQAppInterface.a(), 2131364717, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      return false;
    }
    int i = paramIntent.getIntExtra("forward_type", Integer.MAX_VALUE);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleForwardData() forwardType" + i);
    }
    if (i == Integer.MAX_VALUE) {
      return false;
    }
    paramIntent.removeExtra("forward_type");
    Object localObject1 = paramIntent.getStringExtra("forward_filepath");
    boolean bool1;
    boolean bool2;
    label488:
    label531:
    label706:
    label721:
    long l1;
    switch (i)
    {
    case -4: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 22: 
    case 25: 
    case 26: 
    case 27: 
    default: 
    case -1: 
    case 0: 
      for (;;)
      {
        return true;
        if (localSessionInfo.jdField_a_of_type_Int == 9501)
        {
          paramContext = paramIntent.getStringExtra("forward_text");
          paramMqqHandler = (DeviceMsgHandle)paramQQAppInterface.a(49);
          localObject1 = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
          if (!TextUtils.isEmpty(paramContext))
          {
            localSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
            localSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
            bool1 = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(localSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
            paramIntent = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(localSessionInfo.jdField_a_of_type_JavaLangString));
            bool2 = SettingCloneUtil.readValue(paramActivity, localSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", false);
            if ((!bool2) && ((paramIntent.SSOBid_Platform == 1027) || ((!StringUtil.b(paramIntent.SSOBid_Version)) && (Double.valueOf(paramIntent.SSOBid_Version).doubleValue() >= 1.1D))))
            {
              i = 1;
              SettingCloneUtil.writeValue(paramActivity, localSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", true);
              if ((!bool1) || (i == 0)) {
                break label531;
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              paramMqqHandler.a(paramQQAppInterface, localSessionInfo, paramContext, bool1);
              break;
              if ((!bool2) && (!bool1)) {
                break label2039;
              }
              i = 1;
              break label488;
            }
          }
        }
        else
        {
          paramActivity = paramIntent.getStringExtra("forward_text");
          if (!TextUtils.isEmpty(paramActivity)) {
            AnonymousChatHelper.a().a = true;
          }
          ChatActivityFacade.b(paramQQAppInterface, paramContext, localSessionInfo, paramActivity);
          paramQQAppInterface = new Message();
          paramQQAppInterface.what = 55;
          paramQQAppInterface.obj = paramActivity;
          if (paramMqqHandler != null)
          {
            paramMqqHandler.sendMessage(paramQQAppInterface);
            continue;
            try
            {
              paramActivity = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
              if (paramIntent.getBooleanExtra("foward_editbar", false)) {
                break;
              }
              if ((paramActivity == null) || (paramActivity.d() != 3)) {
                break label721;
              }
              if (!FileManagerUtil.a()) {
                break label706;
              }
              FMDialogUtil.a(paramContext, 2131362855, 2131362851, new ndc(paramQQAppInterface, paramContext, localSessionInfo, paramIntent, (String)localObject1, paramActivity));
            }
            catch (Exception paramQQAppInterface) {}
            if (QLog.isColorLevel())
            {
              QLog.d("", 2, "FORWARD_TYPE.FILE failed. " + paramQQAppInterface, paramQQAppInterface);
              continue;
              ChatActivityFacade.a(paramQQAppInterface, paramContext, localSessionInfo, paramIntent, (String)localObject1, paramActivity, false);
              continue;
              ChatActivityFacade.a(paramQQAppInterface, paramContext, localSessionInfo, paramIntent, (String)localObject1, paramActivity, false);
            }
          }
        }
      }
      paramActivity = paramIntent.getParcelableArrayListExtra("fileinfo_array");
      l1 = 0L;
      if ((paramActivity != null) && (paramActivity.size() > 0)) {
        paramMqqHandler = paramActivity.iterator();
      }
      break;
    }
    label2039:
    label2045:
    for (;;)
    {
      if (paramMqqHandler.hasNext())
      {
        localObject1 = (ForwardFileInfo)paramMqqHandler.next();
        if (((ForwardFileInfo)localObject1).d() == 3)
        {
          l1 += ((ForwardFileInfo)localObject1).d();
          break label2045;
        }
      }
      else
      {
        if (FileManagerUtil.a())
        {
          FMDialogUtil.a(paramContext, 2131362855, 2131362851, new ndd(paramActivity, paramQQAppInterface, paramContext, localSessionInfo, paramIntent));
          break;
        }
        if ((paramActivity == null) || (paramActivity.size() <= 0)) {
          break;
        }
        paramActivity = paramActivity.iterator();
        while (paramActivity.hasNext())
        {
          paramMqqHandler = (ForwardFileInfo)paramActivity.next();
          ChatActivityFacade.a(paramQQAppInterface, paramContext, localSessionInfo, paramIntent, paramMqqHandler.a(), paramMqqHandler, true);
        }
        bool1 = paramIntent.getBooleanExtra("isFromShare", false);
        bool2 = paramIntent.getBooleanExtra("sendMultiple", false);
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "handleForwardData() photograph isFromShare" + bool1);
        }
        Object localObject2;
        String str1;
        if (bool1)
        {
          if (bool2) {
            break;
          }
          bool1 = paramIntent.getBooleanExtra("FORWARD_IS_EDITED", false);
          if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "handleForwardData() photograph isEdited" + bool1);
          }
          if (bool1) {
            break;
          }
          paramContext = paramIntent.getStringExtra("forward_download_image_task_key");
          localObject2 = paramIntent.getStringExtra("forward_download_image_org_uin");
          i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
          str1 = paramIntent.getStringExtra("forward_download_image_server_path");
          l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
          paramIntent = new Message();
          paramIntent.what = 56;
          if (paramMqqHandler != null) {
            paramMqqHandler.sendMessage(paramIntent);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ForwardUtils", 2, "[@]call sendPic start!");
          }
          ThreadManager.a(new nde(paramQQAppInterface, paramActivity, localSessionInfo, (String)localObject1, str1, (String)localObject2, l1, i, paramContext, paramMqqHandler), 8, null, false);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ForwardUtils", 2, "[@]call sendPic end!");
          break;
        }
        if (paramIntent.getBooleanExtra("FORWARD_IS_EDITED", false)) {
          break;
        }
        paramIntent.putExtra("FORWARD_UIN_TYPE", localSessionInfo.jdField_a_of_type_Int);
        paramIntent.putExtra("SENDER_TROOP_UIN", localSessionInfo.b);
        paramIntent.putExtra("FORWARD_PEER_UIN", localSessionInfo.jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("FORWARD_SELF_UIN", paramQQAppInterface.a());
        i = paramIntent.getIntExtra("BUSI_TYPE", 1009);
        int j = paramIntent.getIntExtra("forward_source_uin_type", -1);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardUtils", 2, "report forward! forwardFilePath = " + (String)localObject1 + ",forwardSourceUinType = " + j);
        }
        if (localObject1 != null)
        {
          l1 = paramIntent.getLongExtra("forward_image_width", 0L);
          long l2 = paramIntent.getLongExtra("forward_image_height", 0L);
          int k = paramIntent.getIntExtra("forward_image_type", 0);
          paramActivity = AppConstants.br + "#" + l1 + "#" + l2 + "#" + k;
          k = localSessionInfo.jdField_a_of_type_Int;
          StatisticConstants.a(new String[] { paramActivity }, k, false, true, j, paramQQAppInterface);
        }
        paramActivity = PicBusiManager.a(i, paramIntent);
        paramContext = PicBusiManager.a(3, i);
        paramContext.a(paramActivity);
        PicBusiManager.a(paramContext, paramQQAppInterface);
        break;
        if (localSessionInfo.jdField_a_of_type_Int == 9501) {
          return true;
        }
        if (paramIntent.getBooleanExtra("isFromFavorite", false)) {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ForwardUtils", 2, "handleForwardData(): ShortVideo => " + paramIntent.getExtras());
        }
        i = paramIntent.getIntExtra("from_busi_type", 0);
        if (i == 1) {
          i = 2;
        }
        for (;;)
        {
          paramActivity = ShortVideoBusiManager.a(3, i);
          paramActivity.a(ShortVideoBusiManager.a(i, paramIntent, paramActivity));
          ShortVideoBusiManager.a(paramActivity, paramQQAppInterface);
          break;
          if (i == 2) {
            i = 3;
          } else {
            i = 0;
          }
        }
        if (ChatActivityFacade.a(paramQQAppInterface, localSessionInfo, (String)localObject1) == -1L) {
          break;
        }
        paramQQAppInterface = new Message();
        paramQQAppInterface.what = 57;
        if (paramMqqHandler == null) {
          break;
        }
        paramMqqHandler.sendMessage(paramQQAppInterface);
        break;
        if (paramIntent.getBooleanExtra("isFromFavorites", false))
        {
          paramActivity = paramIntent.getExtras();
          if (paramActivity == null) {
            break;
          }
          ChatActivityFacade.a(paramContext, paramQQAppInterface, localSessionInfo, paramActivity.getString("forward_latitude"), paramActivity.getString("forward_longitude"), paramActivity.getString("forward_location"), paramActivity.getString("title"), paramActivity.getString("summary"), "");
          break;
        }
        ChatActivityFacade.a(paramQQAppInterface, localSessionInfo, paramIntent.getStringExtra("forward_latitude"), paramIntent.getStringExtra("forward_longitude"), paramIntent.getStringExtra("forward_location"));
        break;
        l1 = paramIntent.getLongExtra("FORWARD_MSG_UNISEQ", 0L);
        ((MixedMsgManager)paramQQAppInterface.getManager(173)).a(localSessionInfo, l1);
        break;
        a(paramQQAppInterface, paramContext, localSessionInfo, paramIntent);
        break;
        localObject1 = paramIntent.getExtras().getParcelableArrayList("forward_composite").iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          switch (((ForwardUtils.SectionBase)localObject2).jdField_a_of_type_Int)
          {
          case 0: 
          default: 
            break;
          case -1: 
            if (!TextUtils.isEmpty(((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString)) {
              AnonymousChatHelper.a().a = true;
            }
            ChatActivityFacade.b(paramQQAppInterface, paramContext, localSessionInfo, ((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString);
            break;
          case 1: 
            str1 = paramIntent.getStringExtra("forward_download_image_task_key");
            String str2 = paramIntent.getStringExtra("forward_download_image_org_uin");
            i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
            String str3 = paramIntent.getStringExtra("forward_download_image_server_path");
            l1 = paramIntent.getLongExtra("forward_download_image_item_id", -1L);
            ChatActivityFacade.a(paramQQAppInterface, paramActivity, localSessionInfo, ((ForwardUtils.Section_Pic)localObject2).b, str3, str2, l1, i, str1);
            localObject2 = new Message();
            ((Message)localObject2).what = 57;
            if (paramMqqHandler != null) {
              paramMqqHandler.sendMessage((Message)localObject2);
            }
            break;
          }
        }
        if (2 == MarketFaceItemBuilder.j) {
          ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          paramContext = MarketFaceItemBuilder.a;
          AnonymousChatHelper.a().a = true;
          if (paramContext == null) {
            break;
          }
          paramContext.a(paramQQAppInterface, paramActivity, null, localSessionInfo, true);
          break;
          ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send_aio", 0, 0, "", "", "", "");
        }
      }
      break label2045;
      i = 0;
      break label488;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\ForwardUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */