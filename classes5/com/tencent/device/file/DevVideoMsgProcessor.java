package com.tencent.device.file;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jxe;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class DevVideoMsgProcessor
  implements DeviceAVFileMsgObserver.DevMsgProcessor
{
  public static final String a = "device_video_path";
  private static final String b = "DeviceShortVideo";
  
  public DevVideoMsgProcessor()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null) {}
    while (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    if (!Utils.b())
    {
      ToastUtil.a().a(2131368967);
      return;
    }
    Object localObject = AppConstants.bj + "shortvideo/" + System.currentTimeMillis() + ".mp4";
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    localIntent.putExtra("android.intent.extra.videoQuality", 1);
    PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).edit().putString("device_video_path", (String)localObject).commit();
    if (Build.VERSION.SDK_INT > 10)
    {
      localObject = new File((String)localObject);
      ((File)localObject).getParentFile().mkdirs();
      localIntent.putExtra("output", Uri.fromFile((File)localObject));
      localIntent.putExtra("android.intent.extra.durationLimit", 60);
      localIntent.putExtra("android.intent.extra.sizeLimit", 1073741824);
    }
    paramActivity.startActivityForResult(localIntent, 83);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    ThreadManager.a().post(new jxe(paramString1, paramString2, paramQQAppInterface));
  }
  
  public long a(String paramString, long paramLong)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramString = ((DeviceFileHandler)((QQAppInterface)localAppRuntime).a(50)).a(paramString, DeviceMsgHandle.e, null, paramLong);
      if (paramString != null) {
        return paramString.uSessionID;
      }
    }
    return 0L;
  }
  
  public void a(Session paramSession)
  {
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      DevShortVideoOperator localDevShortVideoOperator = new DevShortVideoOperator();
      localDevShortVideoOperator.a = paramSession.strFilePathSrc;
      localDevShortVideoOperator.a();
      MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)MessageRecordFactory.a(61033);
      localMessageForDevShortVideo.videoFileName = paramSession.strFilePathSrc;
      localMessageForDevShortVideo.msgtype = 61033;
      localMessageForDevShortVideo.istroop = 9501;
      localMessageForDevShortVideo.issend = 0;
      localMessageForDevShortVideo.isread = false;
      localMessageForDevShortVideo.selfuin = ((QQAppInterface)localObject).a();
      localMessageForDevShortVideo.senderuin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevShortVideo.frienduin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevShortVideo.uuid = "";
      localMessageForDevShortVideo.md5 = localDevShortVideoOperator.jdField_c_of_type_JavaLangString;
      localMessageForDevShortVideo.videoFileFormat = 2;
      localMessageForDevShortVideo.videoFileSize = ((int)paramSession.uFileSizeSrc);
      localMessageForDevShortVideo.videoFileTime = ((int)(localDevShortVideoOperator.jdField_b_of_type_Long / 1000L));
      localMessageForDevShortVideo.thumbWidth = localDevShortVideoOperator.jdField_b_of_type_Int;
      localMessageForDevShortVideo.thumbHeight = localDevShortVideoOperator.jdField_c_of_type_Int;
      localMessageForDevShortVideo.videoFileStatus = 2003;
      localMessageForDevShortVideo.videoFileProgress = 0;
      localMessageForDevShortVideo.fileType = 19;
      localMessageForDevShortVideo.thumbMD5 = localDevShortVideoOperator.e;
      localMessageForDevShortVideo.lastModified = 0L;
      localMessageForDevShortVideo.fileSessionId = paramSession.uSessionID;
      localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
      localMessageForDevShortVideo.serial();
      ((QQAppInterface)localObject).a().a(localMessageForDevShortVideo, ((QQAppInterface)localObject).a());
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "recievemsg msg.uniseq:" + localMessageForDevShortVideo.uniseq + " ===> filesize:" + localMessageForDevShortVideo.videoFileSize + " fileStatus:" + ShortVideoUtils.b(localMessageForDevShortVideo.videoFileStatus));
      }
      localObject = ShortVideoUtils.a(localMessageForDevShortVideo, "mp4");
      FileUtils.b(paramSession.strFilePathSrc, (String)localObject);
    }
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, float paramFloat)
  {
    Object localObject = BaseApplicationImpl.a().a();
    MessageRecord localMessageRecord;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localMessageRecord = ((QQAppInterface)localObject).a().a(paramString, paramInt, paramLong);
      if (localMessageRecord != null) {
        break label43;
      }
    }
    label43:
    do
    {
      MessageForDevShortVideo localMessageForDevShortVideo;
      do
      {
        return;
        if (!(localMessageRecord instanceof MessageForDevShortVideo)) {
          break;
        }
        localMessageForDevShortVideo = (MessageForDevShortVideo)localMessageRecord;
        localMessageForDevShortVideo.videoFileSize = ((int)paramSession.uFileSizeSrc);
        localMessageForDevShortVideo.fileSessionId = paramSession.uSessionID;
        localMessageForDevShortVideo.videoFileProgress = ((int)(100.0F * paramFloat));
        localMessageForDevShortVideo.serial();
        ((QQAppInterface)localObject).a().a(paramString, paramInt, localMessageRecord.uniseq, localMessageForDevShortVideo.msgData);
      } while (!QLog.isColorLevel());
      QLog.d("DeviceShortVideo", 2, "updatemsg msg.uniseq:" + localMessageRecord.uniseq + " ===> filesize:" + localMessageForDevShortVideo.videoFileSize);
      return;
    } while (!(localMessageRecord instanceof MessageForDevLittleVideo));
    paramSession = (MessageForDevLittleVideo)localMessageRecord;
    paramSession.videoFileStatus = 1002;
    paramSession.videoFileProgress = ((int)(100.0F * paramFloat));
    paramSession.serial();
    ((QQAppInterface)localObject).a().a(paramString, paramInt, localMessageRecord.uniseq, paramSession.msgData);
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = BaseApplicationImpl.a().a();
    MessageRecord localMessageRecord;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)localObject1;
      localMessageRecord = ((QQAppInterface)localObject1).a().a(paramString, paramInt, paramLong);
      if (localMessageRecord != null) {
        break label43;
      }
    }
    label43:
    Object localObject2;
    label173:
    label283:
    do
    {
      do
      {
        return;
        if ((localMessageRecord instanceof MessageForDevShortVideo))
        {
          localObject2 = (MessageForDevShortVideo)localMessageRecord;
          if (!paramSession.bSend) {
            if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.e))
            {
              Object localObject3 = new DevShortVideoOperator();
              ((DevShortVideoOperator)localObject3).a = paramSession.strFilePathSrc;
              ((DevShortVideoOperator)localObject3).a();
              ((MessageForDevShortVideo)localObject2).md5 = ((DevShortVideoOperator)localObject3).jdField_c_of_type_JavaLangString;
              ((MessageForDevShortVideo)localObject2).videoFileTime = ((int)(((DevShortVideoOperator)localObject3).jdField_b_of_type_Long / 1000L));
              ((MessageForDevShortVideo)localObject2).thumbWidth = ((DevShortVideoOperator)localObject3).jdField_b_of_type_Int;
              ((MessageForDevShortVideo)localObject2).thumbHeight = ((DevShortVideoOperator)localObject3).jdField_c_of_type_Int;
              ((MessageForDevShortVideo)localObject2).thumbMD5 = ((DevShortVideoOperator)localObject3).e;
              if (!paramBoolean) {
                break label283;
              }
              ((MessageForDevShortVideo)localObject2).videoFileStatus = 2003;
              localObject3 = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
              FileUtils.b(paramSession.strFilePathSrc, (String)localObject3);
            }
          }
          for (;;)
          {
            ((MessageForDevShortVideo)localObject2).msg = ((MessageForDevShortVideo)localObject2).getSummary();
            ((MessageForDevShortVideo)localObject2).serial();
            ((QQAppInterface)localObject1).a().a(paramString, paramInt, localMessageRecord.uniseq, ((MessageForDevShortVideo)localObject2).msgData);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("DeviceShortVideo", 2, "updatemsg msg.uniseq:" + localMessageRecord.uniseq + " ===> fileStatus:" + ShortVideoUtils.b(((MessageForDevShortVideo)localObject2).videoFileStatus));
            return;
            ((MessageForDevShortVideo)localObject2).videoFileStatus = 2005;
            break label173;
            ((MessageForDevShortVideo)localObject2).videoFileSize = ((int)paramSession.uFileSizeSrc);
            localMessageRecord.issend = 1;
            if (paramBoolean) {
              ((MessageForDevShortVideo)localObject2).videoFileStatus = 1003;
            } else {
              ((MessageForDevShortVideo)localObject2).videoFileStatus = 1005;
            }
          }
        }
      } while (!(localMessageRecord instanceof MessageForDevLittleVideo));
      localObject2 = (MessageForDevLittleVideo)localMessageRecord;
    } while (!paramSession.bSend);
    if (paramBoolean) {
      ((MessageForDevLittleVideo)localObject2).videoFileStatus = 1003;
    }
    for (((MessageForDevLittleVideo)localObject2).videoFileProgress = 100;; ((MessageForDevLittleVideo)localObject2).videoFileProgress = 0)
    {
      ((MessageForDevLittleVideo)localObject2).serial();
      ((QQAppInterface)localObject1).a().a(paramString, paramInt, localMessageRecord.uniseq, localMessageRecord.msgData);
      return;
      ((MessageForDevLittleVideo)localObject2).videoFileStatus = 1005;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\file\DevVideoMsgProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */