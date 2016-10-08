import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.MsgPack;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceGroupChatMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class kau
  extends BroadcastReceiver
{
  public kau(DeviceMsgHandle paramDeviceMsgHandle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l1;
    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst"))
    {
      paramContext = paramIntent.getExtras();
      l1 = paramContext.getLong("deviceopdin", 0L);
      if (paramContext.getInt("deviceoprstcode", 0) == 0) {
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(l1).toString(), 9501);
      }
    }
    label2398:
    label2485:
    label2764:
    label2933:
    label4431:
    label4435:
    label4441:
    for (;;)
    {
      return;
      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceAdminUnbind"))
      {
        l1 = paramIntent.getExtras().getLong("deviceopdin", 0L);
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(l1).toString(), 9501);
        return;
      }
      Object localObject1;
      int i;
      boolean bool;
      Object localObject3;
      Object localObject2;
      int j;
      long l2;
      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_receiveDPMsg"))
      {
        paramIntent = (DataPoint)paramIntent.getExtras().getParcelable("dataPoint");
        if (paramIntent == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "dp is null in DeviceMsgHandler::onreceive");
          return;
        }
        localObject1 = ((SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(paramIntent.mDin);
        i = 0;
        if (localObject1 != null) {
          i = ((DeviceInfo)localObject1).productId;
        }
        if ((10004 == paramIntent.mProperityId) || (10012 == paramIntent.mProperityId))
        {
          this.a.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor.a(paramIntent);
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
          return;
        }
        if ((10003 == paramIntent.mProperityId) || (10013 == paramIntent.mProperityId))
        {
          this.a.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver.a(paramIntent);
          SmartDeviceReport.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.mDin, "Usr_AIO_ReceiveMsg", 2, 0, i);
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
          return;
        }
        if (10007 == paramIntent.mProperityId)
        {
          try
          {
            paramContext = new JSONObject(paramIntent.mValue).optString("ext_cmd", " ");
            if (("OPT_DEV_AUTH_CONFIRM".equals(paramContext)) || ("OPT_DEV_AUTH_REQ".equals(paramContext))) {
              continue;
            }
            bool = "TEXT_OF_11012".equals(paramContext);
            if (bool) {
              continue;
            }
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              paramContext.printStackTrace();
            }
          }
          this.a.a(paramIntent);
          SmartDeviceReport.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.mDin, "Usr_AIO_ReceiveMsg", 1, 0, i);
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
          return;
        }
        if ((10011 == paramIntent.mProperityId) || (10010 == paramIntent.mProperityId))
        {
          this.a.jdField_a_of_type_ComTencentDeviceMsgDataDeviceGroupChatMsgProcessor.a(paramIntent);
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
          return;
        }
        if (10009 == paramIntent.mProperityId)
        {
          try
          {
            localObject3 = new JSONObject(paramIntent.mValue);
            l1 = ((JSONObject)localObject3).getLong("from_uin");
            if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (String.valueOf(l1).equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
              continue;
            }
            paramContext = ((JSONObject)localObject3).optString("media_key", "");
            paramIntent = ((JSONObject)localObject3).optString("cover_key", "");
            localObject1 = ((JSONObject)localObject3).optString("fkey2", "");
            localObject2 = ((JSONObject)localObject3).optString("ckey2", "");
            i = ((JSONObject)localObject3).optInt("duration", 0);
            j = ((JSONObject)localObject3).optInt("csz_file_size", 0);
            l2 = ((JSONObject)localObject3).getLong("to_din");
            localObject3 = (MessageForDevLittleVideo)MessageRecordFactory.a(61027);
            ((MessageForDevLittleVideo)localObject3).msgtype = 61027;
            ((MessageForDevLittleVideo)localObject3).istroop = 9501;
            ((MessageForDevLittleVideo)localObject3).issend = 0;
            ((MessageForDevLittleVideo)localObject3).isread = false;
            ((MessageForDevLittleVideo)localObject3).selfuin = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
            ((MessageForDevLittleVideo)localObject3).senderuin = Long.toString(l1);
            ((MessageForDevLittleVideo)localObject3).frienduin = Long.toString(l2);
            ((MessageForDevLittleVideo)localObject3).videoFileStatus = 2001;
            ((MessageForDevLittleVideo)localObject3).time = MessageCache.a();
            ((MessageForDevLittleVideo)localObject3).msg = (ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForDevLittleVideo)localObject3).senderuin, true) + ": [视频]");
            ((MessageForDevLittleVideo)localObject3).extStr = "device_groupchat";
            ((MessageForDevLittleVideo)localObject3).thumbFileKey = paramIntent;
            ((MessageForDevLittleVideo)localObject3).videoFileKey = paramContext;
            ((MessageForDevLittleVideo)localObject3).fileKey2 = ((String)localObject1);
            ((MessageForDevLittleVideo)localObject3).coverkey2 = ((String)localObject2);
            ((MessageForDevLittleVideo)localObject3).videoFileTime = i;
            ((MessageForDevLittleVideo)localObject3).videoFileSize = j;
            ((MessageForDevLittleVideo)localObject3).videoFileFormat = 2;
            ((MessageForDevLittleVideo)localObject3).videoFileProgress = 0;
            ((MessageForDevLittleVideo)localObject3).serial();
            this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject3, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
            this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
            return;
          }
          catch (JSONException paramContext) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "getString from json error:" + paramContext.getMessage());
          return;
        }
        if (paramIntent.mProperityId == 10008)
        {
          try
          {
            if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (String.valueOf(paramIntent.mDin).equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
              continue;
            }
            localObject1 = new JSONObject(paramIntent.mValue);
            paramContext = ((JSONObject)localObject1).optString("senderDin", " ");
            l1 = ((JSONObject)localObject1).optLong("msg_time", MessageCache.a());
            localObject1 = ((JSONObject)localObject1).optString("text", " ");
            l2 = paramIntent.mDin;
            DeviceMsgHandle.a(this.a, l2, paramContext, (String)localObject1, l1, true);
            this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
            return;
          }
          catch (Exception paramContext) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramContext.getMessage());
          return;
        }
        if (paramIntent.mProperityId != 10014) {}
      }
      try
      {
        if (DeviceTipActivity.a) {
          continue;
        }
        localObject1 = new JSONObject(paramIntent.mValue);
        paramContext = String.valueOf(paramIntent.mDin);
        paramIntent = ((JSONObject)localObject1).optString("digest", "");
        l2 = ((JSONObject)localObject1).optLong("appear_time", MessageCache.a());
        localObject1 = SettingCloneUtil.readValue(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "account_login_success_time", "");
        l1 = 0L;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          l1 = Long.valueOf((String)localObject1).longValue();
        }
        if (QLog.isColorLevel())
        {
          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "ReceiveDoorTip appear_time= " + l2 + " : serverTime = " + MessageCache.a() + " loginTimeStr= " + (String)localObject1);
          i = (int)(MessageCache.a() - l2);
          QQToast.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "该消息时间距当前时间已超过" + i + "秒", 1).a();
        }
        if (l1 - l2 > 1L)
        {
          if (QLog.isColorLevel()) {
            QQToast.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "该消息是手Q登录前" + (l1 - l2) + "秒下发的", 1).a();
          }
          this.a.a(paramContext, "你有一条未接响铃消息", l2, "");
          return;
        }
        if (MessageCache.a() - l2 > 30L) {
          continue;
        }
        localObject1 = new Intent(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), DeviceTipActivity.class);
        ((Intent)localObject1).setFlags(268435456);
        ((Intent)localObject1).putExtra("uin", paramContext);
        ((Intent)localObject1).putExtra("digest", paramIntent);
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().startActivity((Intent)localObject1);
        return;
      }
      catch (Exception paramContext) {}
      if (paramIntent.mProperityId == 1600006)
      {
        try
        {
          paramContext = new JSONObject(paramIntent.mValue);
          localObject1 = paramContext.optString("digest", "");
          l1 = paramContext.optLong("msg_time", MessageCache.a());
          if ((localObject1 == null) || (TextUtils.isEmpty(((String)localObject1).trim()))) {
            continue;
          }
          this.a.a(Long.toString(paramIntent.mDin), (String)localObject1, l1, null);
          return;
        }
        catch (Exception paramContext) {}
        if (QLog.isColorLevel()) {
          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramContext.getMessage());
        }
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (paramIntent.mProperityId == 10004)
        {
          try
          {
            localObject1 = new JSONObject(paramIntent.mValue);
            ((JSONObject)localObject1).optLong("msgSeq", 0L);
            localObject2 = ((JSONObject)localObject1).optString("latitude");
            localObject3 = ((JSONObject)localObject1).optString("longitude");
            str1 = ((JSONObject)localObject1).optString("title");
            str2 = ((JSONObject)localObject1).optString("summary");
            str3 = ((JSONObject)localObject1).optString("dianpingId");
            l1 = ((JSONObject)localObject1).optLong("msg_time", MessageCache.a());
            DeviceMsgHandle.a(this.a, paramContext, Long.toString(paramIntent.mDin), (String)localObject2, (String)localObject3, str1, str2, str3, l1);
            return;
          }
          catch (Exception paramContext) {}
          if (QLog.isColorLevel()) {
            QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramContext.getMessage());
          }
        }
        else
        {
          if (paramIntent.mProperityId == 11010) {
            try
            {
              Object localObject4 = new JSONObject(paramIntent.mValue);
              paramContext = ((JSONObject)localObject4).optString("prompt", "");
              localObject1 = ((JSONObject)localObject4).getString("app");
              localObject2 = ((JSONObject)localObject4).getString("view");
              localObject3 = ((JSONObject)localObject4).optString("desc", "");
              str1 = ((JSONObject)localObject4).optString("ver", "");
              str2 = ((JSONObject)localObject4).optString("meta", "");
              str3 = ((JSONObject)localObject4).optString("config", "");
              String str4 = ((JSONObject)localObject4).optString("compatibleText", "");
              localObject4 = new SessionInfo();
              ((SessionInfo)localObject4).jdField_a_of_type_JavaLangString = Long.toString(paramIntent.mDin);
              ((SessionInfo)localObject4).b = "";
              ((SessionInfo)localObject4).jdField_a_of_type_Int = 9501;
              paramContext = new ArkAppMessage(paramContext, (String)localObject1, (String)localObject3, (String)localObject2, str1, str2, str3, str4);
              paramContext = MessageRecordFactory.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((SessionInfo)localObject4).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject4).b, ((SessionInfo)localObject4).jdField_a_of_type_Int, paramContext);
              paramContext.istroop = 9501;
              paramContext.issend = 0;
              paramContext.isread = false;
              paramContext.selfuin = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
              paramContext.senderuin = Long.toString(paramIntent.mDin);
              paramContext.frienduin = Long.toString(paramIntent.mDin);
              this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
              this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
              return;
            }
            catch (Exception paramContext)
            {
              return;
            }
          }
          if ((paramIntent.mProperityId == 11008) || (paramIntent.mProperityId == 11012))
          {
            try
            {
              paramContext = new JSONObject(paramIntent.mValue);
              SmartDeviceUtil.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, String.valueOf(paramIntent.mDin));
              this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
              return;
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
            }
            if (QLog.isColorLevel())
            {
              QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "auth_request_structmsg:" + paramContext.getMessage());
              return;
              if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_sendCCDataPointMsgResult"))
              {
                paramContext = (MsgPack)paramIntent.getExtras().get("msgpack");
                l1 = paramContext.uRecvUin;
                bool = paramContext.bSendResult;
                i = paramContext.dwMsgSequence;
                if (bool)
                {
                  DeviceMsgHandle.a(this.a, String.valueOf(l1), i);
                  return;
                }
                DeviceMsgHandle.b(this.a, String.valueOf(l1), i);
                return;
              }
              if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnMiniFileTransferProgress"))
              {
                paramContext = paramIntent.getExtras();
                l1 = paramContext.getLong("cookie", 0L);
                l2 = paramContext.getLong("progress", 0L);
                long l3 = paramContext.getLong("total", 0L);
                i = 0;
                if ((l1 != 0L) && (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1)))) {
                  paramContext = (MessageRecord)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                }
                for (;;)
                {
                  if ((!(paramContext instanceof MessageForDevLittleVideo)) || (i == 0)) {
                    break label2398;
                  }
                  paramContext = (MessageForDevLittleVideo)paramContext;
                  paramContext.videoFileStatus = 2002;
                  paramContext.videoFileProgress = ((int)((float)l2 * 1.0D / (float)l3) * 100);
                  paramContext.serial();
                  this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                  this.a.a().b(paramContext, (float)((float)l2 * 1.0D / (float)l3));
                  return;
                  if ((l1 == 0L) || (!this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1)))) {
                    break;
                  }
                  paramContext = (MessageRecord)this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                  i = 1;
                }
              }
              else
              {
                if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnMiniFileTransferComplete"))
                {
                  paramIntent = paramIntent.getExtras();
                  j = paramIntent.getInt("err_code", -1);
                  l1 = paramIntent.getLong("cookie", 0L);
                  i = 0;
                  if ((l1 != 0L) && (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1))))
                  {
                    paramContext = (MessageRecord)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                    if (j != 0) {
                      break label2933;
                    }
                    localObject1 = paramIntent.getString("filepath");
                    paramIntent = new File((String)localObject1);
                    paramIntent = AppConstants.bj + "/smart_device/" + paramIntent.getName();
                    FileUtils.b((String)localObject1, paramIntent);
                    if (!(paramContext instanceof MessageForDeviceFile)) {
                      break label2764;
                    }
                    paramContext = (MessageForDeviceFile)paramContext;
                    paramContext.filePath = paramIntent;
                    paramContext.srcFileName = FileManagerUtil.a(paramIntent);
                    paramContext.fileSize = FileManagerUtil.a(paramIntent);
                    paramContext.msg = (ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.senderuin, true) + ": " + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371973));
                    paramContext.serial();
                    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                    this.a.a().a(paramContext, Boolean.valueOf(true));
                  }
                  for (;;)
                  {
                    this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l1));
                    this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l1));
                    return;
                    if ((l1 == 0L) || (!this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1)))) {
                      break;
                    }
                    paramContext = (MessageRecord)this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                    i = 1;
                    break label2485;
                    if ((paramContext instanceof MessageForDevLittleVideo))
                    {
                      paramContext = (MessageForDevLittleVideo)paramContext;
                      if (i != 0)
                      {
                        paramContext.videoFileName = paramIntent;
                        paramContext.videoFileStatus = 2003;
                        paramContext.serial();
                        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                        this.a.a().b(paramContext, Boolean.valueOf(true));
                      }
                      else
                      {
                        paramContext.mThumbFilePath = paramIntent;
                        try
                        {
                          localObject1 = new BitmapFactory.Options();
                          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
                          BitmapFactory.decodeFile(paramIntent, (BitmapFactory.Options)localObject1);
                          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
                          paramContext.thumbWidth = ((BitmapFactory.Options)localObject1).outWidth;
                          paramContext.thumbHeight = ((BitmapFactory.Options)localObject1).outHeight;
                          paramContext.serial();
                          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                        }
                        catch (OutOfMemoryError paramIntent)
                        {
                          for (;;)
                          {
                            paramIntent.printStackTrace();
                          }
                        }
                        if ((paramContext instanceof MessageForDeviceFile))
                        {
                          paramContext = (MessageForDeviceFile)paramContext;
                          this.a.a().a(paramContext, Boolean.valueOf(false));
                        }
                        else if (((paramContext instanceof MessageForDevLittleVideo)) && (i != 0))
                        {
                          paramContext = (MessageForDevLittleVideo)paramContext;
                          paramContext.videoFileProgress = 0;
                          paramContext.videoFileStatus = 2005;
                          paramContext.serial();
                          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                          this.a.a().b(paramContext, Boolean.valueOf(false));
                        }
                      }
                    }
                  }
                }
                if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceVasFlagChange"))
                {
                  paramIntent = paramIntent.getExtras();
                  if (paramIntent != null)
                  {
                    i = paramIntent.getInt("Flag", 0);
                    l1 = paramIntent.getLong("Din", 0L);
                    localObject1 = (SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                    localObject2 = ((SmartDeviceProxyMgr)localObject1).a(l1);
                    paramIntent = "";
                    if (localObject2 != null) {
                      paramIntent = ((DeviceInfo)localObject2).serialNum;
                    }
                    paramIntent = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramIntent, "");
                    if (!StringUtil.b(paramIntent))
                    {
                      paramContext = paramIntent;
                      if (!paramIntent.equals("0")) {}
                    }
                    else
                    {
                      paramIntent = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369846).split(":")[0];
                      paramContext = paramIntent;
                      if (((DeviceInfo)localObject2).isAdmin != 1)
                      {
                        ((SmartDeviceProxyMgr)localObject1).a(((DeviceInfo)localObject2).productId, ((DeviceInfo)localObject2).serialNum);
                        paramContext = paramIntent;
                      }
                    }
                    if ((i == 1) && (((DeviceInfo)localObject2).isAdmin != 1))
                    {
                      com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.N = true;
                      paramContext = paramContext + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371989);
                      this.a.a(l1 + "", paramContext, MessageCache.a(), true, false, 1);
                      return;
                    }
                    if ((i == 0) && (((DeviceInfo)localObject2).isAdmin != 1))
                    {
                      com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.N = false;
                      paramContext = paramContext + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371990);
                      this.a.a(l1 + "", paramContext, MessageCache.a(), true, false, true);
                    }
                  }
                }
                else if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_QueryIsDeviceBinded"))
                {
                  paramIntent = paramIntent.getExtras();
                  if (paramIntent != null)
                  {
                    l1 = paramIntent.getLong("AdminBinderUin", 0L);
                    paramIntent = paramIntent.getString("DeviceSerialNum");
                    localObject1 = ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l1 + "", true);
                    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString(paramIntent, (String)localObject1).commit();
                  }
                }
                else
                {
                  if (paramIntent.getAction().equalsIgnoreCase("DeviceSomebodyJoin"))
                  {
                    paramContext = paramIntent.getExtras();
                    localObject2 = Long.valueOf(paramContext.getLong("deviceopdin", 0L));
                    localObject3 = Long.valueOf(paramContext.getLong("deviceopuin", 0L));
                    paramContext = (SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                    paramIntent = paramContext.a(((Long)localObject2).longValue());
                    if (paramIntent == null) {
                      continue;
                    }
                    localObject1 = paramContext.a(paramIntent.productId);
                    if (localObject1 == null) {
                      continue;
                    }
                    if (paramContext.a(((Long)localObject2).longValue()).booleanValue()) {
                      paramContext = "已加入群聊";
                    }
                  }
                  for (;;)
                  {
                    if (TextUtils.isEmpty(paramContext)) {
                      break label4441;
                    }
                    localObject1 = ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(((Long)localObject3).longValue()), true);
                    paramIntent = (Intent)localObject1;
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      paramIntent = String.valueOf(localObject3);
                    }
                    paramContext = paramIntent + paramContext;
                    this.a.a(localObject2 + "", paramContext, MessageCache.a(), true, false, true);
                    return;
                    if (paramIntent.isAdmin == 1)
                    {
                      paramContext = " 已接受设备授权，开始使用" + ((ProductInfo)localObject1).deviceName;
                      continue;
                      if ((paramIntent.getAction().equalsIgnoreCase("DeviceSomebodyQuit")) || (paramIntent.getAction().equalsIgnoreCase("DeviceSomebodyReject")))
                      {
                        paramContext = paramIntent.getExtras();
                        localObject2 = Long.valueOf(paramContext.getLong("deviceopdin", 0L));
                        localObject3 = Long.valueOf(paramContext.getLong("deviceopuin", 0L));
                        paramContext = (SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                        paramIntent = paramContext.a(((Long)localObject2).longValue());
                        if ((paramIntent == null) || (paramContext.a(paramIntent.productId) == null)) {
                          break;
                        }
                        if (!paramContext.a(((Long)localObject2).longValue()).booleanValue()) {
                          break label4431;
                        }
                      }
                      for (paramContext = "已退出群聊";; paramContext = "")
                      {
                        if (TextUtils.isEmpty(paramContext)) {
                          break label4435;
                        }
                        localObject1 = ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(((Long)localObject3).longValue()), true);
                        paramIntent = (Intent)localObject1;
                        if (TextUtils.isEmpty((CharSequence)localObject1)) {
                          paramIntent = String.valueOf(localObject3);
                        }
                        paramContext = paramIntent + paramContext;
                        this.a.a(localObject2 + "", paramContext, MessageCache.a(), true, false, true);
                        return;
                        if ("SmartDevice_DeviceBindRst".equals(paramIntent.getAction()))
                        {
                          if (paramIntent.getExtras().getInt("deviceoprstcode") != 0) {
                            break;
                          }
                          localObject1 = (SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                          l1 = paramIntent.getExtras().getLong("deviceopdin", 0L);
                          if ((localObject1 != null) && (((SmartDeviceProxyMgr)localObject1).a(l1, 13))) {
                            break;
                          }
                          if (EquipmentLockImpl.a().a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext) != 0) {
                            this.a.a(l1 + "", "【重要！设备安全提醒】\n\n为防止QQ号被盗/丢失手机，导致设备被人恶意控制\n请点这里开启QQ设备锁\n\n\n查看QQ设备锁介绍", MessageCache.a(), "device_lock_msg");
                          }
                          localObject2 = ((SmartDeviceProxyMgr)localObject1).a(l1);
                          paramIntent = "";
                          if (localObject2 != null) {
                            paramIntent = ((DeviceInfo)localObject2).serialNum;
                          }
                          paramIntent = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramIntent, "");
                          if (!StringUtil.b(paramIntent))
                          {
                            paramContext = paramIntent;
                            if (!paramIntent.equals("0")) {}
                          }
                          else
                          {
                            paramIntent = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369846).split(":")[0];
                            paramContext = paramIntent;
                            if (localObject2 != null)
                            {
                              paramContext = paramIntent;
                              if (((DeviceInfo)localObject2).isAdmin != 1)
                              {
                                ((SmartDeviceProxyMgr)localObject1).a(((DeviceInfo)localObject2).productId, ((DeviceInfo)localObject2).serialNum);
                                paramContext = paramIntent;
                              }
                            }
                          }
                          if ((localObject2 == null) || (((DeviceInfo)localObject2).isAdmin == 1) || (!((SmartDeviceProxyMgr)localObject1).a(l1).booleanValue())) {
                            break;
                          }
                          paramContext = paramContext + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371989);
                          this.a.a(l1 + "", paramContext, MessageCache.a(), true, false, 1);
                          return;
                        }
                        if (!"On_OccupyMicrophoneNotify_Push".equals(paramIntent.getAction())) {
                          break;
                        }
                        if (QLog.isColorLevel()) {
                          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "DeviceMsghandle intent.getExtras() : " + paramIntent.getExtras());
                        }
                        paramContext = paramIntent.getExtras();
                        paramIntent = Long.valueOf(paramContext.getLong("din", 0L));
                        paramContext = paramContext.getString("uin");
                        if ((paramIntent.longValue() == 0L) || (TextUtils.isEmpty(paramContext))) {
                          break;
                        }
                        localObject1 = ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, true);
                        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (paramContext.equals(localObject1))) {}
                        for (paramContext = "其他人已经处理了响铃通知";; paramContext = (String)localObject1 + "已经处理了响铃通知")
                        {
                          this.a.a(String.valueOf(paramIntent), paramContext, MessageCache.a(), "");
                          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
                          return;
                        }
                      }
                      break;
                    }
                    paramContext = "";
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */