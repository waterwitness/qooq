package com.tencent.mobileqq.filemanager.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FMConstants.revertMsgCallback;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileCSCProtocal.ApplyUploadHitReqV2;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileCSCProtocal.ApplyUploadReqV2;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileCSCProtocal.ApplyUploadReqV3;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileCSCProtocal.Cmd0x346CSBody;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.OffLineFileInfo;
import com.tencent.mobileqq.service.message.MessageFactorySender;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor.A9Message;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import org.json.JSONException;
import org.json.JSONObject;
import rvt;
import rvu;
import rvv;
import rvw;
import rvx;
import rvy;
import rvz;
import rwa;
import rwb;
import rwc;
import rwd;
import rwe;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x1ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x2ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x3ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x5ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x7ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0xaReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x1RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x2RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x3RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x5RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x7RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0xaRspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RecallFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.RecallFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;
import tencent.im.cs.face2face_file.face2face_file.msg;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x5.SubMsgType0x5.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

public class FileTransferHandler
{
  public static final int a = -100000;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  public static final String a = "FileTransferHandler<FileAssistant>";
  public static final short a = 1;
  public static final byte[] a;
  public static final int b = -100001;
  private static final String b = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500";
  public static final short b = 2;
  public static final int c = -100002;
  private static final String c = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800";
  public static final short c = 4;
  public static final int d = -100003;
  private static final String d = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200";
  public static final short d = 0;
  public static final int e = 5002;
  private static final String e = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000";
  public static final short e = 57;
  public static final int f = 5003;
  private static final String f = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100";
  public static final short f = 70;
  public static final int g = 5004;
  private static final String g = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700";
  public static final short g = 71;
  public static final int h = 5005;
  private static final String h = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900";
  public static final short h = 5;
  public static final int i = 5006;
  private static final String i = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100";
  public static final short i = 1;
  public static final int j = 5007;
  private static final String j = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
  public static final short j = 2;
  public static final int k = 5013;
  private static final String k = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
  public static final short k = 3;
  public static final int l = 5014;
  private static final String l = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
  public static final short l = 112;
  public static final int m = 5015;
  private static final String m = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400";
  public static final int n = 5016;
  private static final String n = "GTalkFileAppSvr.CMD_DISCUSS_FILE";
  public static final int o = 5020;
  private static final String o = "SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ";
  private static final int jdField_p_of_type_Int = 3;
  private static final String jdField_p_of_type_JavaLangString;
  private static int jdField_q_of_type_Int = 0;
  private static final String jdField_q_of_type_JavaLangString = "sendtimekey";
  private static final String r = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
  private static final String s = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
  private static final String t = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
  private long jdField_a_of_type_Long;
  public final QQAppInterface a;
  private MessageFactoryReceiver jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver = new MessageFactoryReceiver();
  private MessageFactorySender jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactorySender = new MessageFactorySender();
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    p = FileTransferObserver.class.getName();
    jdField_a_of_type_AndroidOsHandler = new rvt(Looper.getMainLooper());
    jdField_a_of_type_ArrayOfByte = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101 };
  }
  
  public FileTransferHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private FileManagerEntity a(MessageHandler paramMessageHandler, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    long l1 = paramInt2;
    boolean bool1 = false;
    boolean bool2 = false;
    paramLong3 = 0L;
    if (0L != l1)
    {
      paramMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, l1);
      if (paramMessageHandler != null)
      {
        paramLong3 = paramMessageHandler.nSessionId;
        bool1 = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, l1))
        {
          paramMessageHandler.Uuid = paramString3;
          String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          paramInt2 = FileManagerUtil.a(paramString4);
          if (paramInt2 == 0)
          {
            paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageHandler.Uuid, 5, str.equals(paramString2), paramMessageHandler);
            if (paramString2 != null) {
              paramMessageHandler.strMiddleThumPath = paramString2;
            }
            if ((!paramBoolean2) || (!paramBoolean1)) {
              break label270;
            }
            QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString4 + ". is  roma and readed, think okt!!");
            a(paramString1, l1, paramInt1, paramString3, paramLong1);
          }
          for (;;)
          {
            paramMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, 0, paramMessageHandler.uniseq);
            if (paramMessageHandler != null)
            {
              paramMessageHandler.shmsgseq = paramShort;
              paramMessageHandler.time = paramLong1;
              paramMessageHandler.msgUid = paramLong4;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).a(paramString1, paramInt1, paramMessageHandler, 3);
            }
            return null;
            if (2 != paramInt2) {
              break;
            }
            paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageHandler, 2);
            if (paramString2 == null) {
              break;
            }
            paramMessageHandler.strThumbPath = paramString2;
            break;
            label270:
            a(paramString1, l1, paramInt1, paramString3, paramLong1);
          }
        }
        bool2 = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramLong3);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString4 + ". user had delete about onlinefile record!!! ");
      }
      paramLong1 = paramLong3;
    }
    for (paramBoolean1 = bool1;; paramBoolean1 = false)
    {
      TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString4, 0, null), paramLong2, 0, false, null);
      paramLong2 = MessageRecordFactory.a(63531).uniseq;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (0L == l1) {
        break label588;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramLong1);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a offline file name: " + paramString4 + ". and it is : online changto offline. OLfilesession=" + l1 + "isPullRoam =" + paramBoolean2);
      }
      if (!paramBoolean2) {
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString4 + ". isPullRoam hadHasOlSessionRecord=" + paramBoolean1 + " isDelOlSessionRecord=" + bool2);
      if ((!paramBoolean1) || (bool2)) {
        break;
      }
      return null;
      paramLong1 = 0L;
      bool2 = true;
    }
    if ((0L != paramLong1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1))) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, paramLong2, paramString1, 0);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong2, paramString1, 0);
    label588:
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong2, paramString1, 0);
  }
  
  private Cmd0x346CSBody a(OfflineFileUploadPara paramOfflineFileUploadPara)
  {
    Cmd0x346CSBody localCmd0x346CSBody = new Cmd0x346CSBody();
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (paramOfflineFileUploadPara.jdField_a_of_type_Int == 1700)
    {
      localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3 = new ApplyUploadReqV3();
      paramOfflineFileUploadPara.jdField_a_of_type_JavaLangString = paramOfflineFileUploadPara.jdField_a_of_type_JavaLangString.replace("+", "");
      localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3.jdField_a_of_type_Long = l1;
      localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3.jdField_b_of_type_Long = Long.parseLong(paramOfflineFileUploadPara.jdField_a_of_type_JavaLangString);
      localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3.jdField_c_of_type_Long = paramOfflineFileUploadPara.jdField_a_of_type_Long;
      localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3.jdField_a_of_type_JavaLangString = new String(paramOfflineFileUploadPara.jdField_b_of_type_ArrayOfByte);
      localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3.jdField_b_of_type_JavaLangString = new String(paramOfflineFileUploadPara.jdField_a_of_type_ArrayOfByte);
      localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3.jdField_a_of_type_ArrayOfByte = paramOfflineFileUploadPara.jdField_c_of_type_ArrayOfByte;
      localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3.jdField_b_of_type_ArrayOfByte = paramOfflineFileUploadPara.jdField_d_of_type_ArrayOfByte;
    }
    while (paramOfflineFileUploadPara.jdField_a_of_type_Int != 1600) {
      return localCmd0x346CSBody;
    }
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2 = new ApplyUploadReqV2();
    paramOfflineFileUploadPara.jdField_a_of_type_JavaLangString = paramOfflineFileUploadPara.jdField_a_of_type_JavaLangString.replace("+", "");
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2.jdField_a_of_type_Long = l1;
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2.jdField_b_of_type_Long = Long.parseLong(paramOfflineFileUploadPara.jdField_a_of_type_JavaLangString);
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2.jdField_c_of_type_Long = paramOfflineFileUploadPara.jdField_a_of_type_Long;
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2.jdField_a_of_type_JavaLangString = new String(paramOfflineFileUploadPara.jdField_b_of_type_ArrayOfByte);
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2.jdField_b_of_type_JavaLangString = new String(paramOfflineFileUploadPara.jdField_a_of_type_ArrayOfByte);
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2.jdField_a_of_type_ArrayOfByte = paramOfflineFileUploadPara.jdField_c_of_type_ArrayOfByte;
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2.jdField_b_of_type_ArrayOfByte = paramOfflineFileUploadPara.e;
    return localCmd0x346CSBody;
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver.a(paramToServiceMsg, paramFromServiceMsg);
      return localObject1;
    }
    catch (Exception paramToServiceMsg)
    {
      do
      {
        paramToServiceMsg.printStackTrace();
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("FileTransferHandler<FileAssistant>", 2, this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver.getClass().getSimpleName() + " decode error," + paramToServiceMsg.toString());
    }
    return null;
  }
  
  private rwd a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    int i1 = paramArrayOfByte.length;
    rwd localrwd = new rwd(null);
    int i2;
    byte[] arrayOfByte;
    if (i1 >= 16)
    {
      i2 = PkgTools.a(paramArrayOfByte, 0);
      arrayOfByte = new byte[i2];
      if (i1 < i2 + 2) {
        break label196;
      }
      PkgTools.b(paramArrayOfByte, 2, arrayOfByte, i2);
      i2 += 2;
    }
    try
    {
      localrwd.jdField_a_of_type_JavaLangString = new String(arrayOfByte, "UTF-16LE");
      if (i1 >= i2 + 4)
      {
        long l1 = PkgTools.a(paramArrayOfByte, i2);
        int i3 = i2 + 4;
        if (i1 < i3 + 2) {
          break label255;
        }
        i2 = PkgTools.a(paramArrayOfByte, i3);
        i3 += 2;
        arrayOfByte = new byte[i2];
        if (i1 < i3 + i2) {
          break label266;
        }
        PkgTools.b(paramArrayOfByte, i3, arrayOfByte, i2);
        i2 = i3 + i2;
        if (i1 < i2 + 4) {
          break label277;
        }
        localrwd.jdField_a_of_type_Long = ((PkgTools.a(paramArrayOfByte, i2) << 32) + l1);
        return localrwd;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamelen");
        return null;
        label196:
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamebuf");
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo: Exception is " + localUnsupportedEncodingException.toString());
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenlo");
      return null;
    }
    label255:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- otherlen");
    return null;
    label266:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- bufotherinfo");
    return null;
    label277:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenhi");
    return null;
  }
  
  private void a(long paramLong, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramLong != -5L) && (paramLong != -6L)) {}
    MessageHandler localMessageHandler;
    do
    {
      return;
      localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    } while (localMessageHandler == null);
    localMessageHandler.b(3008, false, new Object[] { paramFileManagerEntity.peerUin, Integer.valueOf(3000), Integer.valueOf(103) });
  }
  
  private void a(MessageHandler paramMessageHandler, List paramList, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, long paramLong2, int paramInt2, long paramLong3, long paramLong4, String paramString5, TempSessionInfo paramTempSessionInfo, int paramInt3, hummer_resv_21.FileImgInfo paramFileImgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "internalHandleOffLineFileMsg friendUin[" + String.valueOf(paramString1) + "],senderuin[" + String.valueOf(paramString2) + "],time[" + String.valueOf(paramLong1) + "],seq[" + String.valueOf(paramShort) + "],isRead[" + String.valueOf(paramBoolean1) + "],isPullRoam[" + String.valueOf(paramBoolean2) + "],type[" + String.valueOf(paramInt1) + "],uuid[" + String.valueOf(paramString3) + "],type[" + String.valueOf(paramInt1) + "],strFileName[" + String.valueOf(paramString4) + "],dwFileSize[" + String.valueOf(paramLong2) + "],reserve[" + String.valueOf(paramInt2) + "],vipBubbleID[" + String.valueOf(paramLong3) + "],vipBubbleDiyTextID[" + String.valueOf(paramInt3) + "]");
    }
    FileManagerEntity localFileManagerEntity = a(paramMessageHandler, paramString1, paramString2, paramLong1, paramShort, paramBoolean1, paramBoolean2, paramInt1, paramString3, paramString4, paramLong2, paramInt2, paramLong3, paramLong4);
    if (localFileManagerEntity == null) {
      QLog.w("FileTransferHandler<FileAssistant>", 1, "entry is null,may be is onlinefile!");
    }
    do
    {
      return;
      if ((paramString4 == null) || (paramString4.length() == 0))
      {
        QLog.w("FileTransferHandler<FileAssistant>", 1, "internalHandleOffLineFileMsg.  no file name . return!!!!");
        return;
      }
      if ((!paramBoolean2) && (!paramBoolean1)) {
        break;
      }
      paramMessageHandler = new ArrayList();
      if (!a(paramString1, paramString3, paramInt2, paramShort, paramLong4, paramMessageHandler, paramString2)) {
        break;
      }
    } while (paramMessageHandler.size() <= 0);
    paramString3 = (MessageRecord)paramMessageHandler.get(0);
    paramList.add(paramMessageHandler.get(0));
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, paramString3.istroop);
    return;
    String str = TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString4, 0, null), paramLong2, 0, false, null);
    MessageRecordFactory.a(63531);
    paramMessageHandler = paramString2;
    int i2;
    int i1;
    if (paramTempSessionInfo != null)
    {
      i2 = 1;
      if (paramTempSessionInfo.jdField_b_of_type_Int == -1)
      {
        i1 = 0;
        paramMessageHandler = paramString2;
        if (i1 == 0) {
          break label1316;
        }
        i1 = paramTempSessionInfo.jdField_b_of_type_Int;
        paramMessageHandler = paramString2;
      }
    }
    for (;;)
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.fileName = paramString4;
      localFileManagerEntity.fileSize = paramLong2;
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, null, 0);
      localFileManagerEntity.peerType = i1;
      localFileManagerEntity.peerUin = paramString1;
      localFileManagerEntity.srvTime = (1000L * paramLong1);
      localFileManagerEntity.status = -1;
      localFileManagerEntity.Uuid = new String(paramString3);
      localFileManagerEntity.isReaded = paramBoolean1;
      localFileManagerEntity.bSend = false;
      localFileManagerEntity.msgSeq = paramShort;
      localFileManagerEntity.msgUid = paramLong4;
      localFileManagerEntity.strFileMd5 = paramString5;
      i2 = FileManagerUtil.a(paramString4);
      if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0))
      {
        localFileManagerEntity.nWeiYunSrcType = -2;
        paramString5 = "friendUin:" + String.valueOf(paramString1) + "senderuin:" + String.valueOf(paramMessageHandler) + "time:" + String.valueOf(paramLong1) + "seq:" + String.valueOf(paramShort) + "isRead:" + String.valueOf(paramBoolean1) + "isPullRoam:" + String.valueOf(paramBoolean2) + "type:" + String.valueOf(paramInt1) + "uuid:" + String.valueOf(paramString3) + "strFileName:" + String.valueOf(paramString4) + "dwFileSize:" + String.valueOf(paramLong2) + "reserve:" + String.valueOf(paramInt2) + "vipBubbleID:" + String.valueOf(paramLong3) + "vipBubbleDiyTextID:" + String.valueOf(paramInt3);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, localFileManagerEntity.strFileMd5, 9081L, paramString5, 0L, 0L, paramLong2, "", "", 0, "uuid null", null);
        label863:
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageHandler, "", localFileManagerEntity);
        if (paramString2.equals(paramMessageHandler))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, localFileManagerEntity.uniseq);
          localFileManagerEntity.nOpType = 0;
          localFileManagerEntity.status = 1;
          localFileManagerEntity.bSend = true;
          localFileManagerEntity.isReaded = true;
          localFileManagerEntity.bDelInFM = false;
        }
        if ((!paramBoolean2) || (!paramBoolean1)) {
          break label1298;
        }
        QLog.w("FileTransferHandler<FileAssistant>", 1, "internalHandleOffLineFileMsg.  roam and readed ");
      }
      for (localFileManagerEntity.bDelInFM = false;; localFileManagerEntity.bDelInFM = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
        if (QLog.isDevelopLevel()) {
          QLog.w("FileTransferHandler<FileAssistant>", 2, "offline file come:fileName[" + paramString4 + "],uuid[" + paramString3 + "] insert To AIO");
        }
        a(paramList, paramString1, paramMessageHandler, paramString4, paramLong2, paramBoolean1, i1, str, paramShort, paramShort, paramString3, paramInt1, localFileManagerEntity.uniseq, paramLong4, paramLong3, paramLong1, 63531, paramInt3, paramFileImgInfo);
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + FileManagerUtil.a(localFileManagerEntity));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, paramString1, i1, 17, null, 0, null);
        return;
        if ((paramTempSessionInfo.jdField_b_of_type_Int != 1000) && (paramTempSessionInfo.jdField_b_of_type_Int != 1020))
        {
          i1 = i2;
          if (paramTempSessionInfo.jdField_b_of_type_Int != 1004) {
            break;
          }
        }
        paramString2 = String.valueOf(paramTempSessionInfo.jdField_c_of_type_Long);
        i1 = i2;
        break;
        if (i2 == 0)
        {
          if (paramFileImgInfo != null)
          {
            localFileManagerEntity.imgWidth = paramFileImgInfo.uint32_file_width.get();
            localFileManagerEntity.imgHeight = paramFileImgInfo.uint32_file_height.get();
          }
          if (NetworkUtil.b(BaseApplicationImpl.getContext()) != 1) {
            break label863;
          }
          paramString5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
          if (paramString5 == null) {
            break label863;
          }
          localFileManagerEntity.strLargeThumPath = paramString5;
          break label863;
        }
        if (2 != i2) {
          break label863;
        }
        paramString5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity, 2);
        if (paramString5 == null) {
          break label863;
        }
        localFileManagerEntity.strThumbPath = paramString5;
        break label863;
        label1298:
        QLog.w("FileTransferHandler<FileAssistant>", 1, "internalHandleOffLineFileMsg.  sync and readed ");
      }
      label1316:
      i1 = 0;
    }
  }
  
  private void a(ProtoReqManager.ProtoReq paramProtoReq)
  {
    paramProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new rvv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProtoReq);
  }
  
  private void a(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    FileTransferHandler.FileUploadInfo localFileUploadInfo = new FileTransferHandler.FileUploadInfo(this);
    Object localObject1 = null;
    boolean bool1;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      localFileUploadInfo.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      bool1 = false;
    }
    int i1;
    label116:
    int i2;
    label138:
    int i3;
    label163:
    int i4;
    for (;;)
    {
      if ((localFileUploadInfo.jdField_a_of_type_Int == 0) && ((localFileUploadInfo.jdField_b_of_type_JavaLangString == null) || (localFileUploadInfo.jdField_b_of_type_JavaLangString.length() == 0)))
      {
        i1 = 1;
        if ((localFileUploadInfo.jdField_b_of_type_JavaLangString == null) || (localFileUploadInfo.jdField_b_of_type_JavaLangString.length() <= 0)) {
          break label731;
        }
        i2 = 1;
        if ((localFileUploadInfo.jdField_a_of_type_Int != -91245) && (localFileUploadInfo.jdField_a_of_type_Int != 58526)) {
          break label737;
        }
        i3 = 1;
        if ((localFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (localFileUploadInfo.jdField_a_of_type_ArrayOfByte.length != 0)) {
          break label743;
        }
        i4 = 1;
        label183:
        Object localObject2 = (rwe)paramProtoReq.jdField_a_of_type_JavaLangObject;
        int i5 = ((rwe)localObject2).b();
        if (((i4 == 0) || (i2 == 0)) && (((i3 == 0) && (i1 == 0)) || (i5 >= 3))) {
          break label749;
        }
        ((rwe)localObject2).a();
        a(paramProtoReq.jdField_a_of_type_JavaLangString, paramProtoReq.jdField_a_of_type_ArrayOfByte, (rwe)localObject2);
        return;
        if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
        {
          localFileUploadInfo.jdField_a_of_type_Int = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
          bool1 = false;
        }
        else
        {
          localObject2 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
          cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
          try
          {
            localRspBody.mergeFrom((byte[])localObject2);
            if (localRspBody.msg_apply_upload_rsp.has()) {
              break label388;
            }
            localFileUploadInfo.jdField_a_of_type_Int = -100003;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
            bool1 = false;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
            localFileUploadInfo.jdField_a_of_type_Int = -100003;
            bool1 = false;
          }
          continue;
          label388:
          localObject1 = (cmd0x346.ApplyUploadRsp)localRspBody.msg_apply_upload_rsp.get();
          if (((cmd0x346.ApplyUploadRsp)localObject1).int32_ret_code.has()) {
            localFileUploadInfo.jdField_a_of_type_Int = ((cmd0x346.ApplyUploadRsp)localObject1).int32_ret_code.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).str_ret_msg.has()) {
            localFileUploadInfo.jdField_a_of_type_JavaLangString = ((cmd0x346.ApplyUploadRsp)localObject1).str_ret_msg.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).uint64_total_space.has()) {
            localFileUploadInfo.jdField_a_of_type_Long = ((cmd0x346.ApplyUploadRsp)localObject1).uint64_total_space.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).uint64_used_space.has()) {
            localFileUploadInfo.jdField_b_of_type_Long = ((cmd0x346.ApplyUploadRsp)localObject1).uint64_used_space.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).uint64_uploaded_size.has()) {
            localFileUploadInfo.jdField_c_of_type_Long = ((cmd0x346.ApplyUploadRsp)localObject1).uint64_uploaded_size.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).str_upload_ip.has())
          {
            localFileUploadInfo.jdField_b_of_type_JavaLangString = ((cmd0x346.ApplyUploadRsp)localObject1).str_upload_ip.get();
            label532:
            if (((cmd0x346.ApplyUploadRsp)localObject1).uint32_upload_port.has()) {
              localFileUploadInfo.jdField_a_of_type_Short = ((short)((cmd0x346.ApplyUploadRsp)localObject1).uint32_upload_port.get());
            }
            if (((cmd0x346.ApplyUploadRsp)localObject1).bytes_uuid.has()) {
              localFileUploadInfo.jdField_a_of_type_ArrayOfByte = ((cmd0x346.ApplyUploadRsp)localObject1).bytes_uuid.get().toByteArray();
            }
            if (((cmd0x346.ApplyUploadRsp)localObject1).bytes_upload_key.has()) {
              localFileUploadInfo.jdField_b_of_type_ArrayOfByte = ((cmd0x346.ApplyUploadRsp)localObject1).bytes_upload_key.get().toByteArray();
            }
            if (((cmd0x346.ApplyUploadRsp)localObject1).bool_file_exist.has()) {
              localFileUploadInfo.jdField_a_of_type_Boolean = ((cmd0x346.ApplyUploadRsp)localObject1).bool_file_exist.get();
            }
            if (((cmd0x346.ApplyUploadRsp)localObject1).uint32_upload_port.has()) {
              localFileUploadInfo.jdField_b_of_type_Int = ((cmd0x346.ApplyUploadRsp)localObject1).uint32_pack_size.get();
            }
            if ((!((cmd0x346.ApplyUploadRsp)localObject1).rpt_str_uploadip_list.has()) || (((cmd0x346.ApplyUploadRsp)localObject1).rpt_str_uploadip_list.get().size() <= 0)) {
              break label979;
            }
          }
        }
      }
    }
    label731:
    label737:
    label743:
    label749:
    label979:
    for (localObject1 = ((cmd0x346.ApplyUploadRsp)localObject1).rpt_str_uploadip_list.get();; localObject1 = null)
    {
      bool1 = true;
      break;
      if (((cmd0x346.ApplyUploadRsp)localObject1).str_upload_domain.has())
      {
        localFileUploadInfo.jdField_b_of_type_JavaLangString = ((cmd0x346.ApplyUploadRsp)localObject1).str_upload_domain.get();
        break label532;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
      break label532;
      i1 = 0;
      break label116;
      i2 = 0;
      break label138;
      i3 = 0;
      break label163;
      i4 = 0;
      break label183;
      paramProtoReq = new MessageObserver.StatictisInfo();
      paramProtoReq.jdField_c_of_type_Int = localFileUploadInfo.jdField_a_of_type_Int;
      paramProtoReq.jdField_d_of_type_Int = paramProtoResp.jdField_a_of_type_Int;
      boolean bool2 = bool1;
      if (i4 != 0)
      {
        bool2 = bool1;
        if (i2 != 0)
        {
          localFileUploadInfo.jdField_a_of_type_JavaLangString = ("uuid_null[" + localFileUploadInfo.toString() + "]");
          bool2 = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool2 + ", retCode=" + localFileUploadInfo.jdField_a_of_type_Int + ", retMsg=" + localFileUploadInfo.jdField_a_of_type_JavaLangString + ", totalSpace=" + localFileUploadInfo.jdField_a_of_type_Long + ", usedSpace=" + localFileUploadInfo.jdField_b_of_type_Long + ", ip=" + localFileUploadInfo.jdField_b_of_type_JavaLangString + ", port=" + localFileUploadInfo.jdField_a_of_type_Short);
      }
      a(localInvalidProtocolBufferMicroException.a(), 5004, bool2, new Object[] { localFileUploadInfo, paramProtoReq, localObject1 });
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    int i1 = q;
    q = i1 + 1;
    localUniPacket.setRequestId(i1);
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactorySender.a(paramToServiceMsg, localUniPacket);
    paramToServiceMsg.putWupBuffer(localUniPacket.encode());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    long l3 = paramOffLineFileInfo.jdField_c_of_type_Long;
    long l1 = paramOffLineFileInfo.jdField_d_of_type_Long;
    long l2 = paramOffLineFileInfo.e;
    long l4 = paramOffLineFileInfo.jdField_b_of_type_Long;
    String str2 = paramOffLineFileInfo.jdField_b_of_type_JavaLangString;
    paramFromServiceMsg = paramOffLineFileInfo.jdField_c_of_type_JavaLangString;
    String str1 = paramToServiceMsg.extraData.getString("friendUin");
    paramToServiceMsg.extraData.getBoolean("isRead");
    String str5 = "http://" + PkgTools.b(l3) + "/?ver=" + "2" + "&rkey=" + str2;
    str2 = TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramFromServiceMsg, 0, null), l2, 0, false, str5);
    String str3;
    String str4;
    FileManagerEntity localFileManagerEntity;
    if (str2 != null)
    {
      str3 = String.valueOf(l4);
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("filepath");
      l3 = MessageRecordFactory.a(64536).uniseq;
      str4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l3, str1, 0);
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.fileName = paramFromServiceMsg;
      localFileManagerEntity.fileSize = l2;
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, null, 0);
      localFileManagerEntity.peerType = 0;
      localFileManagerEntity.peerUin = str1;
      localFileManagerEntity.srvTime = (1000L * l1);
      localFileManagerEntity.status = -1;
      localFileManagerEntity.Uuid = new String(paramToServiceMsg);
      localFileManagerEntity.isReaded = false;
      localFileManagerEntity.strServerPath = str5;
      localFileManagerEntity.bSend = false;
      if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        break label568;
      }
      localFileManagerEntity.nWeiYunSrcType = -2;
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, localFileManagerEntity.strFileMd5, 9081L, paramOffLineFileInfo.toString(), 0L, 0L, l2, "", "", 0, "uuid null", null);
    }
    for (;;)
    {
      if (str4.equals(str3))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 0, l3);
        localFileManagerEntity.nOpType = 7;
        localFileManagerEntity.status = 1;
        localFileManagerEntity.bSend = true;
        localFileManagerEntity.isReaded = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, str3, localFileManagerEntity.bSend, paramFromServiceMsg, 0L, false, 0, str2, paramOffLineFileInfo.jdField_a_of_type_Short, paramOffLineFileInfo.jdField_a_of_type_Short, new String(paramToServiceMsg), 1, l3, localFileManagerEntity.msgUid, -1L, l1);
      if (QLog.isColorLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + FileManagerUtil.a(localFileManagerEntity));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localFileManagerEntity.nSessionId, str1, 0, 17, null, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      return;
      label568:
      if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0) || (l2 == 0L))
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, localFileManagerEntity.strFileMd5, 90451L, paramOffLineFileInfo.toString(), 0L, 0L, l2, "", "", 0, "A9 Name Null", null);
      }
      else if (FileManagerUtil.a(paramFromServiceMsg) == 0)
      {
        str5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.Uuid, 5, false, localFileManagerEntity);
        if (str5 != null) {
          localFileManagerEntity.strThumbPath = str5;
        }
      }
      else if (FileManagerUtil.a(paramFromServiceMsg) == 2)
      {
        str5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity, 2);
        if (str5 != null) {
          localFileManagerEntity.strThumbPath = str5;
        }
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, List paramList, String paramString3)
  {
    if (paramLong1 != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramString1), paramLong1);
      if (localObject != null)
      {
        if (!((FileManagerEntity)localObject).bDelInAio)
        {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramString1), ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
          if (paramString1 != null) {
            paramList.add(paramString1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "ol2offline duplicate msg, entity info" + FileManagerUtil.a((FileManagerEntity)localObject));
        }
        return true;
      }
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "msgFilterByFMDB,friendUin[" + FileManagerUtil.e(paramString1) + "],uuid[" + paramString2 + "],olSessionId[" + paramLong1 + "],msgSeq[" + paramLong2 + "],msgUid[" + paramLong3 + "],senderuin[" + FileManagerUtil.e(paramString3) + "]");
    Object localObject = paramString2.replace("/offline", "");
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    int i1 = 0;
    if (i1 < localList.size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localList.get(i1);
      paramString2 = "";
      String str = ((String)localObject).replace("/offline", "");
      if (localFileManagerEntity.Uuid != null) {
        paramString2 = localFileManagerEntity.Uuid.replace("/offline", "");
      }
      switch (localFileManagerEntity.nOpType)
      {
      }
      label628:
      do
      {
        do
        {
          do
          {
            if (QLog.isColorLevel()) {
              QLog.w("FileTransferHandler<FileAssistant>", 1, "Entity [" + FileManagerUtil.a(localFileManagerEntity) + "]");
            }
            i1 += 1;
            break;
            if ((paramLong2 != localFileManagerEntity.msgSeq) || (paramLong3 != localFileManagerEntity.msgUid)) {
              break label628;
            }
            paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
            if (paramString2 != null)
            {
              paramList.add(paramString2);
              if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + FileManagerUtil.a(localFileManagerEntity));
              }
              return true;
            }
            paramString2 = new ArrayList();
            a(paramString2, paramString1, paramString3, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.isReaded, 0, null, paramLong2, paramLong2, (String)localObject, 0, localFileManagerEntity.uniseq, paramLong3, -1L, localFileManagerEntity.srvTime / 1000L, 63531, 0, null);
          } while (paramString2.size() <= 0);
          paramList.add((MessageRecord)paramString2.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + FileManagerUtil.a(localFileManagerEntity));
          }
          return true;
        } while (!paramString2.equalsIgnoreCase(str));
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
        if (paramString2 != null)
        {
          paramList.add(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "duplicate msg, entity info" + FileManagerUtil.a(localFileManagerEntity));
          }
          return true;
        }
        paramString2 = new ArrayList();
        a(paramString2, paramString1, paramString3, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.isReaded, 0, null, paramLong2, paramLong2, (String)localObject, 0, localFileManagerEntity.uniseq, paramLong3, -1L, localFileManagerEntity.srvTime / 1000L, 63531, 0, null);
      } while (paramString2.size() <= 0);
      paramList.add((MessageRecord)paramString2.get(0));
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Uuid are all equal, duplicate msg, entity info" + FileManagerUtil.a(localFileManagerEntity));
      }
      return true;
    }
    return false;
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile, int paramInt1, int paramInt2)
  {
    if (paramGroupFile == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "disc file is coming but file info is null!");
      return -1L;
    }
    String str3 = String.valueOf(paramLong2);
    String str4 = String.valueOf(paramLong3);
    if (paramGroupFile.bytes_filename.has()) {}
    for (;;)
    {
      try
      {
        String str1 = new String(paramGroupFile.bytes_filename.get().toByteArray(), "UTF-8");
        if (!paramGroupFile.uint64_file_size.has()) {
          break label714;
        }
        l1 = paramGroupFile.uint64_file_size.get();
        if (!paramGroupFile.bytes_file_id.has()) {
          break label708;
        }
        arrayOfByte = paramGroupFile.bytes_file_id.get().toByteArray();
        if (paramGroupFile.bytes_batch_id.has()) {
          paramGroupFile.bytes_batch_id.get().toByteArray();
        }
        if (paramGroupFile.bytes_mark.has()) {
          paramGroupFile.bytes_mark.get().toByteArray();
        }
        paramLong5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3000, paramLong4, paramLong6, paramLong2, paramLong5);
        if (paramLong5 <= 0L) {
          break label269;
        }
        paramGroupFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong5, String.valueOf(paramLong2), 3000);
        if (paramGroupFile != null)
        {
          paramGroupFile.status = 1;
          paramGroupFile.fProgress = 1.0F;
        }
        return paramLong5;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "internalDiscOfflineFile: Exception is " + localUnsupportedEncodingException.toString());
      }
      String str2 = null;
      continue;
      label269:
      paramGroupFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong1, str3, 3000);
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.fileName = str2;
      localFileManagerEntity.fileSize = l1;
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str4, 3000);
      localFileManagerEntity.peerType = 3000;
      localFileManagerEntity.peerUin = str3;
      localFileManagerEntity.selfUin = str4;
      localFileManagerEntity.srvTime = (1000L * paramLong6);
      localFileManagerEntity.status = -1;
      localFileManagerEntity.Uuid = new String(arrayOfByte);
      localFileManagerEntity.isReaded = false;
      localFileManagerEntity.bSend = false;
      localFileManagerEntity.msgSeq = paramLong4;
      localFileManagerEntity.msgUid = 0L;
      int i1 = FileManagerUtil.a(str2);
      if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
        localFileManagerEntity.nWeiYunSrcType = -2;
      }
      for (;;)
      {
        if (paramGroupFile.equals(String.valueOf(paramLong3)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str4, 3000, paramLong1);
          localFileManagerEntity.nOpType = 7;
          localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131362863);
          localFileManagerEntity.bSend = true;
          localFileManagerEntity.isReaded = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + FileManagerUtil.a(localFileManagerEntity));
        }
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), str3, 3000);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, localFileManagerEntity.nSessionId, str3, 3000, 17, null, 0, null);
        return paramLong1;
        if (i1 == 0)
        {
          localFileManagerEntity.imgWidth = paramInt1;
          localFileManagerEntity.imgHeight = paramInt2;
          if (NetworkUtil.b(BaseApplicationImpl.getContext()) == 1)
          {
            str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
            if (str2 != null) {
              localFileManagerEntity.strLargeThumPath = str2;
            }
          }
        }
        else if (i1 == 2)
        {
          str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity, 2);
          if (str2 != null) {
            localFileManagerEntity.strThumbPath = str2;
          }
        }
      }
      label708:
      byte[] arrayOfByte = null;
      continue;
      label714:
      long l1 = 0L;
    }
  }
  
  private Cmd0x346CSBody b(OfflineFileUploadPara paramOfflineFileUploadPara)
  {
    Cmd0x346CSBody localCmd0x346CSBody = new Cmd0x346CSBody();
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2 = new ApplyUploadHitReqV2();
    paramOfflineFileUploadPara.jdField_a_of_type_JavaLangString = paramOfflineFileUploadPara.jdField_a_of_type_JavaLangString.replace("+", "");
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_a_of_type_Long = l1;
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_b_of_type_Long = Long.parseLong(paramOfflineFileUploadPara.jdField_a_of_type_JavaLangString);
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_c_of_type_Long = paramOfflineFileUploadPara.jdField_a_of_type_Long;
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_a_of_type_JavaLangString = new String(paramOfflineFileUploadPara.jdField_b_of_type_ArrayOfByte);
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_b_of_type_JavaLangString = new String(paramOfflineFileUploadPara.jdField_a_of_type_ArrayOfByte);
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_a_of_type_ArrayOfByte = paramOfflineFileUploadPara.jdField_c_of_type_ArrayOfByte;
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_c_of_type_ArrayOfByte = paramOfflineFileUploadPara.jdField_d_of_type_ArrayOfByte;
    localCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_b_of_type_ArrayOfByte = paramOfflineFileUploadPara.e;
    return localCmd0x346CSBody;
  }
  
  private void b(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    FileTransferHandler.FileUploadInfo localFileUploadInfo = new FileTransferHandler.FileUploadInfo(this);
    boolean bool;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      localFileUploadInfo.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      bool = false;
    }
    for (;;)
    {
      Object localObject = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject).jdField_c_of_type_Int = localFileUploadInfo.jdField_a_of_type_Int;
      ((MessageObserver.StatictisInfo)localObject).jdField_d_of_type_Int = paramProtoResp.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleUploadSuccResponse: return " + bool + ", retCode=" + localFileUploadInfo.jdField_a_of_type_Int + ", retMsg=" + localFileUploadInfo.jdField_a_of_type_JavaLangString);
      }
      a(((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a(), 5005, bool, new Object[] { localFileUploadInfo, localObject });
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
      {
        localFileUploadInfo.jdField_a_of_type_Int = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
        bool = false;
      }
      else
      {
        localObject = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_upload_succ_rsp.has()) {
            break label341;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        continue;
        label341:
        cmd0x346.UploadSuccRsp localUploadSuccRsp = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
        if (localUploadSuccRsp.int32_ret_code.has()) {
          localFileUploadInfo.jdField_a_of_type_Int = localUploadSuccRsp.int32_ret_code.get();
        }
        if (localUploadSuccRsp.str_ret_msg.has()) {
          localFileUploadInfo.jdField_a_of_type_JavaLangString = localUploadSuccRsp.str_ret_msg.get();
        }
        bool = true;
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg);
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), FileTransferServlet.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    long l1 = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("sendtimekey", l1);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleReqOffFilePackError, count: " + i1);
    }
    if (i1 < 3)
    {
      paramToServiceMsg.extraData.putInt("retryIndex", i1 + 1);
      b(paramToServiceMsg);
      return;
    }
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.jdField_c_of_type_Int = paramFromServiceMsg.getResultCode();
    localStatictisInfo.jdField_d_of_type_Int = i1;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      localStatictisInfo.jdField_c_of_type_Int = 2900;
      localStatictisInfo.jdField_d_of_type_Long = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
    }
    localStatictisInfo.jdField_a_of_type_JavaLangString = MessageHandler.a(paramFromServiceMsg);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
    switch (paramToServiceMsg.extraData.getInt("offfile_type"))
    {
    case 0: 
    default: 
      return;
    case 1: 
      a(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
      return;
    case 2: 
      a(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
      return;
    }
    a(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.jdField_c_of_type_Int = paramFromServiceMsg.getResultCode();
    localStatictisInfo.jdField_d_of_type_Int = i1;
    a(paramToServiceMsg, 5003, true, new Object[] { paramOffLineFileInfo.jdField_a_of_type_ArrayOfByte, localStatictisInfo });
  }
  
  private void c(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    long l1 = 0L;
    paramProtoReq = new face2face_file.msg();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    long l2;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResistTerrorist: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      if (l1 != 0L) {}
      paramProtoResp = localSharedPreferences.edit();
      if ((paramProtoReq.has()) && (paramProtoReq.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleResistTerrorist: return resMessage.result:" + paramProtoReq.result.get());
        }
        paramProtoResp.putInt("QlinkResistTerrorist_res", paramProtoReq.result.get());
        paramProtoResp.putLong("SettingQlinkResistTerroristLastTime", MessageCache.a());
        paramProtoResp.putString("SettingQlinkResistTerroristLastAccount", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      paramProtoResp.commit();
      if (l1 != -100001L) {
        break label368;
      }
      l2 = 9043L;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleResistTerrorist: return " + paramProtoReq.result + " ,retCode:" + l2);
      }
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
      {
        l1 = -100002L;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResistTerrorist: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
        break;
      }
      paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
      try
      {
        paramProtoReq.mergeFrom(paramProtoResp);
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        l1 = -100003L;
      }
      break;
      label368:
      l2 = l1;
      if (l1 == -100003L) {
        l2 = 9045L;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo == null) || (paramOffLineFileInfo.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->handleError");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.jdField_c_of_type_Int = paramFromServiceMsg.getResultCode();
    localStatictisInfo.jdField_d_of_type_Int = i1;
    localStatictisInfo.jdField_b_of_type_Int = paramFromServiceMsg.getAppSeq();
    a(paramToServiceMsg, 5004, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
  }
  
  private void d(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    Object localObject13 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject12 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    Object localObject11 = null;
    Object localObject9 = null;
    short s1 = 0;
    short s3 = 0;
    short s2 = 0;
    Object localObject4 = null;
    Object localObject10 = null;
    cmd0x346.ApplyDownloadRsp localApplyDownloadRsp = null;
    Object localObject7 = null;
    Object localObject6 = null;
    boolean bool;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      l1 = -100001L;
      bool = false;
      localObject4 = localApplyDownloadRsp;
      s1 = s2;
      localObject1 = localObject9;
      localObject3 = localObject8;
    }
    int i1;
    label154:
    int i2;
    label175:
    Object localObject2;
    while ((l1 == 0L) && (localObject4 == null) && (localObject1 == null))
    {
      i1 = 1;
      if ((l1 != -91245L) && (l1 != -7010L)) {
        break label761;
      }
      i2 = 1;
      localObject8 = (rwe)paramProtoReq.jdField_a_of_type_JavaLangObject;
      int i3 = ((rwe)localObject8).b();
      if (((i2 == 0) && (i1 == 0)) || (i3 >= 3)) {
        break label767;
      }
      ((rwe)localObject8).a();
      a(paramProtoReq.jdField_a_of_type_JavaLangString, paramProtoReq.jdField_a_of_type_ArrayOfByte, (rwe)localObject8);
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
        l1 = -100002L;
        bool = false;
        localObject3 = localObject8;
        localObject1 = localObject9;
        s1 = s2;
        localObject4 = localApplyDownloadRsp;
      }
      else
      {
        byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(arrayOfByte);
          if (localRspBody.msg_apply_download_rsp.has()) {
            break label409;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: rspBody has not hasMsgApplyDownloadRsp");
          l1 = -100003L;
          bool = false;
          localObject3 = localObject8;
          localObject1 = localObject9;
          s1 = s2;
          localObject4 = localApplyDownloadRsp;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          l1 = -100003L;
          bool = false;
          localObject3 = localObject8;
          localObject2 = localObject9;
          s1 = s2;
          localObject4 = localApplyDownloadRsp;
        }
        continue;
        label409:
        localApplyDownloadRsp = (cmd0x346.ApplyDownloadRsp)localRspBody.msg_apply_download_rsp.get();
        if (!localApplyDownloadRsp.int32_ret_code.has()) {
          break label1006;
        }
      }
    }
    label551:
    label761:
    label767:
    label972:
    label985:
    label1006:
    for (long l1 = localApplyDownloadRsp.int32_ret_code.get();; l1 = 0L)
    {
      localObject5 = localObject13;
      if (localApplyDownloadRsp.str_ret_msg.has()) {
        localObject5 = localApplyDownloadRsp.str_ret_msg.get();
      }
      localObject6 = localObject12;
      localObject7 = localObject11;
      s2 = s3;
      localObject8 = localObject10;
      if (localApplyDownloadRsp.msg_download_info.has())
      {
        localObject9 = (cmd0x346.DownloadInfo)localApplyDownloadRsp.msg_download_info.get();
        if (((cmd0x346.DownloadInfo)localObject9).bytes_download_key.has()) {
          localObject3 = ((cmd0x346.DownloadInfo)localObject9).bytes_download_key.get();
        }
        if (((cmd0x346.DownloadInfo)localObject9).str_download_ip.has())
        {
          localObject2 = ((cmd0x346.DownloadInfo)localObject9).str_download_ip.get();
          if (((cmd0x346.DownloadInfo)localObject9).uint32_port.has()) {
            s1 = (short)((cmd0x346.DownloadInfo)localObject9).uint32_port.get();
          }
          if (((cmd0x346.DownloadInfo)localObject9).str_download_url.has()) {
            localObject4 = ((cmd0x346.DownloadInfo)localObject9).str_download_url.get();
          }
          localObject6 = localObject3;
          localObject7 = localObject2;
          s2 = s1;
          localObject8 = localObject4;
          if (!((cmd0x346.DownloadInfo)localObject9).rpt_str_downloadip_list.has()) {
            break label985;
          }
          localObject6 = localObject3;
          localObject7 = localObject2;
          s2 = s1;
          localObject8 = localObject4;
          if (((cmd0x346.DownloadInfo)localObject9).rpt_str_downloadip_list.get().size() <= 0) {
            break label985;
          }
          localObject9 = ((cmd0x346.DownloadInfo)localObject9).rpt_str_downloadip_list.get();
        }
      }
      for (;;)
      {
        if (localApplyDownloadRsp.msg_file_info.has())
        {
          localObject6 = (cmd0x346.FileInfo)localApplyDownloadRsp.msg_file_info.get();
          if (!((cmd0x346.FileInfo)localObject6).str_file_name.has()) {}
        }
        for (localObject6 = ((cmd0x346.FileInfo)localObject6).str_file_name.get();; localObject6 = null)
        {
          localObject7 = localObject6;
          bool = true;
          localObject6 = localObject9;
          break;
          if (((cmd0x346.DownloadInfo)localObject9).str_download_domain.has())
          {
            localObject2 = ((cmd0x346.DownloadInfo)localObject9).str_download_domain.get();
            break label551;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: has neither ip nor domain");
          break label551;
          i1 = 0;
          break label154;
          i2 = 0;
          break label175;
          if (QLog.isColorLevel())
          {
            localObject9 = new StringBuilder().append("handleDownloadResp: return ").append(bool).append(", retCode=").append(l1).append(", retMsg=").append((String)localObject5).append(", key=");
            if (localObject3 == null) {
              break label972;
            }
          }
          for (paramProtoReq = ((ByteStringMicro)localObject3).toStringUtf8();; paramProtoReq = "")
          {
            QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoReq + ", strIP=" + (String)localObject2 + ", port=" + s1 + ", strUrl=" + (String)localObject4);
            a(((rwe)localObject8).a(), 5006, bool, new Object[] { Long.valueOf(l1), localObject5, localObject3, localObject2, Short.valueOf(s1), localObject4, localObject6, Integer.valueOf(paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getAppSeq()), localObject7, Long.valueOf(((rwe)localObject8).a()) });
            return;
          }
        }
        localObject9 = null;
        localObject3 = localObject6;
        localObject2 = localObject7;
        s1 = s2;
        localObject4 = localObject8;
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo == null) || (paramOffLineFileInfo.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->handleError");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.jdField_c_of_type_Int = paramFromServiceMsg.getResultCode();
    localStatictisInfo.jdField_d_of_type_Int = i1;
    a(paramToServiceMsg, 5005, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
  }
  
  private void e(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    FileTransferHandler.FileUploadInfo localFileUploadInfo = new FileTransferHandler.FileUploadInfo(this);
    boolean bool;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      localFileUploadInfo.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      bool = false;
    }
    for (;;)
    {
      Object localObject = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject).jdField_c_of_type_Int = localFileUploadInfo.jdField_a_of_type_Int;
      ((MessageObserver.StatictisInfo)localObject).jdField_d_of_type_Int = paramProtoResp.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleDownloadSuccResponse: return " + bool + ", retCode=" + localFileUploadInfo.jdField_a_of_type_Int + ", retMsg=" + localFileUploadInfo.jdField_a_of_type_JavaLangString + ", retStat" + localFileUploadInfo.jdField_c_of_type_Int);
      }
      a(((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a(), 5007, bool, new Object[] { localFileUploadInfo, localObject });
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
      {
        localFileUploadInfo.jdField_a_of_type_Int = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
        bool = false;
      }
      else
      {
        localObject = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_download_succ_rsp.has()) {
            break label354;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        continue;
        label354:
        cmd0x346.DownloadSuccRsp localDownloadSuccRsp = (cmd0x346.DownloadSuccRsp)localRspBody.msg_download_succ_rsp.get();
        if (localDownloadSuccRsp.int32_ret_code.has()) {
          localFileUploadInfo.jdField_a_of_type_Int = localDownloadSuccRsp.int32_ret_code.get();
        }
        if (localDownloadSuccRsp.str_ret_msg.has()) {
          localFileUploadInfo.jdField_a_of_type_JavaLangString = localDownloadSuccRsp.str_ret_msg.get();
        }
        if (localDownloadSuccRsp.int32_down_stat.has()) {
          localFileUploadInfo.jdField_c_of_type_Int = localDownloadSuccRsp.int32_down_stat.get();
        }
        bool = true;
      }
    }
  }
  
  private void f(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i1 = 0;
    String str1 = null;
    int i2;
    Object localObject2;
    boolean bool;
    Object localObject1;
    Object localObject3;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      i1 = -100001;
      i2 = 0;
      str1 = null;
      localObject2 = null;
      bool = false;
      paramProtoResp = null;
      localObject1 = null;
      localObject3 = null;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handlePreviewResponse: return " + bool + ", retCode=" + i1 + ", retMsg=" + (String)localObject3 + ", Key=" + (String)localObject2 + ", IP=" + (String)localObject1 + ", Domain=" + str1 + ", port=" + i2);
      }
      if (i1 != -100001) {
        break label661;
      }
      i1 = 9043;
    }
    label475:
    label661:
    label731:
    for (;;)
    {
      if (i1 != 0) {
        bool = false;
      }
      paramProtoReq = (rwe)paramProtoReq.jdField_a_of_type_JavaLangObject;
      if (paramProtoReq.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 191, new Object[] { Integer.valueOf(i1), localObject3, localObject2, localObject1, str1, Integer.valueOf(i2), paramProtoResp, Long.valueOf(paramProtoReq.a()) });
        return;
        if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
          i1 = -100002;
          i2 = 0;
          str1 = null;
          localObject2 = null;
          bool = false;
          paramProtoResp = null;
          localObject1 = null;
          localObject3 = null;
          break;
        }
        paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
        localObject1 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject1).mergeFrom(paramProtoResp);
          if (((cmd0x346.RspBody)localObject1).msg_apply_download_abs_rsp.has()) {
            break label475;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not hasMsgApplyDownloadAbsRsp");
          i1 = -100003;
          i2 = 0;
          str1 = null;
          localObject2 = null;
          bool = false;
          paramProtoResp = null;
          localObject1 = null;
          localObject3 = null;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          i1 = -100003;
          i2 = 0;
          str1 = null;
          localObject2 = null;
          bool = false;
          paramProtoResp = null;
          localObject1 = null;
          localObject3 = null;
        }
        break;
        localObject1 = (cmd0x346.ApplyDownloadAbsRsp)((cmd0x346.RspBody)localObject1).msg_apply_download_abs_rsp.get();
        if (((cmd0x346.ApplyDownloadAbsRsp)localObject1).int32_ret_code.has()) {
          i1 = ((cmd0x346.ApplyDownloadAbsRsp)localObject1).int32_ret_code.get();
        }
        paramProtoResp = str1;
        if (((cmd0x346.ApplyDownloadAbsRsp)localObject1).str_ret_msg.has()) {
          paramProtoResp = ((cmd0x346.ApplyDownloadAbsRsp)localObject1).str_ret_msg.get();
        }
        if (!((cmd0x346.ApplyDownloadAbsRsp)localObject1).msg_download_info.has())
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not MsgDownloadSuccRsp");
          i1 = -100003;
          i2 = 0;
          str1 = null;
          localObject2 = null;
          bool = false;
          str2 = null;
          localObject1 = null;
          localObject3 = paramProtoResp;
          paramProtoResp = str2;
          break;
        }
        localObject2 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadAbsRsp)localObject1).msg_download_info.get();
        localObject1 = ((cmd0x346.DownloadInfo)localObject2).str_download_ip.get();
        str1 = ((cmd0x346.DownloadInfo)localObject2).str_download_domain.get();
        i2 = ((cmd0x346.DownloadInfo)localObject2).uint32_port.get();
        String str2 = ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
        localObject2 = HexUtil.a(((cmd0x346.DownloadInfo)localObject2).bytes_download_key.get().toByteArray());
        bool = true;
        localObject3 = paramProtoResp;
        paramProtoResp = str2;
        break;
        if (i1 != -100003) {
          break label731;
        }
        i1 = 9045;
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 18, new Object[] { Integer.valueOf(i1), localObject3, localObject2, localObject1, str1, Integer.valueOf(i2) });
      return;
    }
  }
  
  private void g(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i1 = 0;
    Object localObject1 = null;
    String str = null;
    long l1 = 0L;
    long l2 = 0L;
    boolean bool;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      l2 = 0L;
      str = null;
      paramProtoResp = null;
      i1 = -100001;
      bool = false;
      l1 = 0L;
    }
    for (;;)
    {
      if (i1 != 0) {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardResponse: return " + bool + ", retCode=" + i1 + ", retMsg=" + paramProtoResp + ", totalSpace=" + l2 + ", usedSpace=" + l1);
      }
      long l3 = ((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a();
      paramProtoReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3);
      if (FileManagerUtil.a(paramProtoReq.fileName) == 0)
      {
        if ((paramProtoReq.strThumbPath == null) || (paramProtoReq.strThumbPath.length() < 1))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 5, true, paramProtoReq);
          if (localObject1 != null) {
            paramProtoReq.strThumbPath = ((String)localObject1);
          }
        }
        label259:
        if (bool)
        {
          localObject1 = new FileManagerReporter.fileAssistantReportData();
          ((FileManagerReporter.fileAssistantReportData)localObject1).jdField_b_of_type_JavaLangString = "send_file_suc";
          ((FileManagerReporter.fileAssistantReportData)localObject1).jdField_a_of_type_Int = 1;
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject1);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, i1, paramProtoResp, str, l3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(i1), paramProtoResp, Long.valueOf(l2), Long.valueOf(l1), str, Long.valueOf(l3) });
        if ((paramProtoReq.nOpType != 26) && (paramProtoReq.nOpType != 27)) {}
      }
      try
      {
        ((IForwardCallBack)paramProtoReq.mContext).a(bool, paramProtoReq.strTroopFileUuid, paramProtoReq.nSessionId, i1, paramProtoResp, String.valueOf(paramProtoReq.peerUin), str);
        if ((i1 == 59435) || (i1 == 58533))
        {
          paramProtoReq.status = 16;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramProtoReq);
        }
        return;
        if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
          l2 = 0L;
          str = null;
          paramProtoResp = null;
          i1 = -100002;
          bool = false;
          l1 = 0L;
          continue;
        }
        paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
        Object localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(paramProtoResp);
          if (((cmd0x346.RspBody)localObject2).msg_apply_forward_file_rsp.has()) {
            break label621;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse rspBody has not hasMsgApplyForwardFileRsp");
          l2 = 0L;
          str = null;
          paramProtoResp = null;
          i1 = -100003;
          bool = false;
          l1 = 0L;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          l2 = 0L;
          str = null;
          paramProtoResp = null;
          i1 = -100003;
          bool = false;
          l1 = 0L;
        }
        continue;
        label621:
        localObject2 = (cmd0x346.ApplyForwardFileRsp)((cmd0x346.RspBody)localObject2).msg_apply_forward_file_rsp.get();
        if (((cmd0x346.ApplyForwardFileRsp)localObject2).int32_ret_code.has()) {
          i1 = ((cmd0x346.ApplyForwardFileRsp)localObject2).int32_ret_code.get();
        }
        paramProtoResp = (ProtoReqManager.ProtoResp)localObject1;
        if (((cmd0x346.ApplyForwardFileRsp)localObject2).str_ret_msg.has()) {
          paramProtoResp = ((cmd0x346.ApplyForwardFileRsp)localObject2).str_ret_msg.get();
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject2).bytes_uuid.has()) {
          str = new String(((cmd0x346.ApplyForwardFileRsp)localObject2).bytes_uuid.get().toByteArray());
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject2).uint64_total_space.has()) {
          l1 = ((cmd0x346.ApplyForwardFileRsp)localObject2).uint64_total_space.get();
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject2).uint64_used_space.has()) {
          l2 = ((cmd0x346.ApplyForwardFileRsp)localObject2).uint64_used_space.get();
        }
        l3 = l1;
        bool = true;
        l1 = l2;
        l2 = l3;
        continue;
        if ((FileManagerUtil.a(paramProtoReq.fileName) != 2) || ((paramProtoReq.strThumbPath != null) && (paramProtoReq.strThumbPath.length() >= 1))) {
          break label259;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramProtoReq, 2);
        if (localObject1 == null) {
          break label259;
        }
        paramProtoReq.strThumbPath = ((String)localObject1);
      }
      catch (Exception paramProtoResp)
      {
        for (;;)
        {
          paramProtoResp.printStackTrace();
          QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: Exception is " + paramProtoResp.toString());
        }
      }
    }
  }
  
  private void h(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    boolean bool = false;
    int i1 = 0;
    Object localObject1 = null;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      paramProtoResp = null;
      localObject1 = null;
      i1 = -100001;
    }
    label88:
    long l1;
    label180:
    Object localObject2;
    for (;;)
    {
      if (i1 != 0)
      {
        bool = false;
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardFromOfflineResponse: return " + bool + ", retCode=" + i1 + ", retMsg=" + (String)localObject1);
        }
        l1 = ((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a();
        paramProtoReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
        if (paramProtoReq == null)
        {
          QLog.e("FileTransferHandler<FileAssistant>", 1, "forward offline file, but entity is null!!!");
          return;
          if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
            paramProtoResp = null;
            localObject1 = null;
            i1 = -100002;
            continue;
          }
          paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
          localObject2 = new cmd0x346.RspBody();
          try
          {
            ((cmd0x346.RspBody)localObject2).mergeFrom(paramProtoResp);
            if (((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.has()) {
              break label314;
            }
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse rspBody has not hasMsgApplyDownloadAbsRsp");
            paramProtoResp = null;
            localObject1 = null;
            i1 = -100003;
          }
          catch (InvalidProtocolBufferMicroException paramProtoResp)
          {
            paramProtoResp.printStackTrace();
            paramProtoResp = null;
            localObject1 = null;
            i1 = -100003;
          }
          continue;
          label314:
          localObject2 = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.get();
          if (((cmd0x346.ApplyCopyToRsp)localObject2).int32_ret_code.has()) {
            i1 = ((cmd0x346.ApplyCopyToRsp)localObject2).int32_ret_code.get();
          }
          paramProtoResp = (ProtoReqManager.ProtoResp)localObject1;
          if (((cmd0x346.ApplyCopyToRsp)localObject2).str_ret_msg.has()) {
            paramProtoResp = ((cmd0x346.ApplyCopyToRsp)localObject2).str_ret_msg.get();
          }
          if (!((cmd0x346.ApplyCopyToRsp)localObject2).str_file_key.has()) {
            break label1045;
          }
        }
      }
    }
    label1045:
    for (localObject1 = ((cmd0x346.ApplyCopyToRsp)localObject2).str_file_key.get();; localObject1 = null)
    {
      localObject2 = paramProtoResp;
      bool = true;
      paramProtoResp = (ProtoReqManager.ProtoResp)localObject1;
      localObject1 = localObject2;
      break;
      if (bool)
      {
        localObject2 = new FileManagerReporter.fileAssistantReportData();
        ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_b_of_type_JavaLangString = "send_file_suc";
        ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject2);
      }
      switch (paramProtoReq.nOpType)
      {
      }
      while ((i1 == 59435) || (i1 == 58533))
      {
        paramProtoReq.status = 16;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramProtoReq);
        return;
        if (((paramProtoResp == null) || (paramProtoResp.length() < 1)) && (QLog.isColorLevel())) {
          QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(i1) + "retMsg[" + String.valueOf(localObject1) + "]");
        }
        if (bool) {}
        for (paramProtoReq.status = 1;; paramProtoReq.status = 0)
        {
          if (bool)
          {
            paramProtoReq.Uuid = paramProtoResp;
            paramProtoReq.setCloudType(1);
            paramProtoReq.peerType = 3000;
            a(paramProtoReq.nSessionId, paramProtoReq.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramProtoReq.fileName, paramProtoReq.fileSize, paramProtoResp, paramProtoReq.uniseq, paramProtoReq.msgUid, null);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(i1), localObject1, Long.valueOf(0L), Long.valueOf(0L), paramProtoResp, Long.valueOf(l1) });
          break;
        }
        if (((paramProtoResp == null) || (paramProtoResp.length() < 1)) && (QLog.isColorLevel())) {
          QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(i1) + "retMsg[" + String.valueOf(localObject1) + "]");
        }
        if (bool)
        {
          paramProtoReq.status = 1;
          paramProtoReq.setCloudType(2);
        }
        for (;;)
        {
          paramProtoReq.WeiYunFileId = paramProtoResp;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramProtoReq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 34, new Object[] { Integer.valueOf(i1), localObject1, paramProtoResp, Long.valueOf(l1) });
          break;
          paramProtoReq.status = 0;
        }
        try
        {
          ((IForwardCallBack)paramProtoReq.mContext).a(bool, paramProtoReq.strTroopFileUuid, paramProtoReq.nSessionId, i1, (String)localObject1, String.valueOf(paramProtoReq.peerUin), paramProtoResp);
        }
        catch (Exception paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + paramProtoResp.toString());
        }
        continue;
        try
        {
          ((IForwardCallBack)paramProtoReq.mContext).a(bool, paramProtoReq.datalineEntitySessionId, i1, (String)localObject1, null, null, paramProtoResp);
        }
        catch (Exception paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + paramProtoResp.toString());
        }
      }
      break label180;
      break label88;
    }
  }
  
  private void i(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    WeiYunFileInfo localWeiYunFileInfo = null;
    boolean bool;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      i1 = -100001;
      bool = false;
      paramProtoResp = localWeiYunFileInfo;
    }
    while (i1 != 0)
    {
      bool = false;
      label83:
      paramProtoReq = ((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a();
      localWeiYunFileInfo = FMDataCache.a(paramProtoReq);
      if ((QLog.isColorLevel()) && (localWeiYunFileInfo != null)) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRemoveResponse, bSucess[" + String.valueOf(bool) + "],fileName[" + localWeiYunFileInfo.jdField_b_of_type_JavaLangString + "],uuid[" + paramProtoReq + "]");
      }
      if (localWeiYunFileInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 20, new Object[] { Integer.valueOf(i1), paramProtoResp, paramProtoReq, localWeiYunFileInfo.jdField_b_of_type_JavaLangString, Boolean.valueOf(true) });
      }
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
        i1 = -100002;
        bool = false;
        paramProtoResp = localWeiYunFileInfo;
      }
      else
      {
        paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramProtoResp);
          if (localRspBody.msg_delete_file_rsp.has()) {
            break label357;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
          i1 = -100003;
          bool = false;
          paramProtoResp = localWeiYunFileInfo;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          i1 = -100003;
          bool = false;
          paramProtoResp = localWeiYunFileInfo;
        }
        continue;
        label357:
        paramProtoResp = (cmd0x346.DeleteFileRsp)localRspBody.msg_delete_file_rsp.get();
        if (!paramProtoResp.int32_ret_code.has()) {
          break label420;
        }
      }
    }
    label420:
    for (int i1 = paramProtoResp.int32_ret_code.get();; i1 = 0)
    {
      if (paramProtoResp.str_ret_msg.has()) {}
      for (paramProtoResp = paramProtoResp.str_ret_msg.get();; paramProtoResp = null)
      {
        bool = true;
        break;
        break label83;
      }
    }
  }
  
  private void j(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    rwe localrwe = (rwe)paramProtoReq.jdField_a_of_type_JavaLangObject;
    switch (localrwe.a())
    {
    case 9: 
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 1, "handleDiscGetFileInfo: subcmd[" + localrwe.a() + "] is not implemented");
    case 4: 
    case 5: 
      return;
    case 1: 
      o(paramProtoReq, paramProtoResp);
      return;
    case 2: 
      p(paramProtoReq, paramProtoResp);
      return;
    case 3: 
      n(paramProtoReq, paramProtoResp);
      return;
    case 6: 
      k(paramProtoReq, paramProtoResp);
      return;
    case 7: 
      m(paramProtoReq, paramProtoResp);
      return;
    case 8: 
      l(paramProtoReq, paramProtoResp);
      return;
    }
    u(paramProtoReq, paramProtoResp);
  }
  
  private void k(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    String str = "";
    int i1;
    boolean bool;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      str = null;
      i1 = -100001;
      bool = false;
    }
    label96:
    long l1;
    for (paramProtoResp = "";; paramProtoResp = "")
    {
      if (i1 != 0) {
        bool = false;
      }
      if (str != null) {
        break label617;
      }
      bool = false;
      l1 = ((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a();
      paramProtoReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
      if (paramProtoReq != null) {
        break label365;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1000) {
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      str = null;
      i1 = -100002;
      bool = false;
    }
    paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    Object localObject = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject).mergeFrom(paramProtoResp);
        if (!((cmd0x345.RspBody)localObject).uint32_return_code.has()) {
          break label625;
        }
        i1 = ((cmd0x345.RspBody)localObject).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x5_rsp_body.has()) {
          break label304;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
        str = null;
        i1 = -100003;
        bool = false;
        paramProtoResp = "";
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        str = null;
        i1 = -100003;
        bool = false;
        paramProtoResp = "";
      }
      break;
      label304:
      localObject = (cmd0x345.RspBody.SubCmd0x5RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x5_rsp_body.get();
      paramProtoResp = str;
      if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_ret_msg.has()) {
        paramProtoResp = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_ret_msg.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_file_id.has()) {}
      for (str = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_file_id.get();; str = null)
      {
        bool = true;
        break;
        label365:
        if (bool)
        {
          paramProtoReq.Uuid = str;
          paramProtoReq.setCloudType(1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(i1), paramProtoResp, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l1) });
          a(l1, paramProtoReq.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramProtoReq.fileName, paramProtoReq.fileSize, str, paramProtoReq.uniseq, paramProtoReq.msgUid, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProtoReq, 6, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramProtoReq);
          return;
          paramProtoReq.status = 0;
          QLog.e("FileTransferHandler<FileAssistant>", 1, "nId[" + l1 + "],forward disc2disc faild, retCode[" + i1 + "], retMsg[" + paramProtoResp + "]");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(i1), paramProtoResp, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l1) });
        }
        label617:
        break label96;
      }
      label625:
      i1 = 0;
    }
  }
  
  private void l(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    Object localObject = "";
    String str2 = "";
    String str1 = "";
    String str3 = "";
    int i2 = 0;
    boolean bool;
    int i1;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      bool = false;
      i1 = -100001;
      paramProtoResp = str3;
    }
    label104:
    cmd0x345.RspBody localRspBody;
    for (;;)
    {
      if (i1 != 0)
      {
        bool = false;
        paramProtoReq = (rwe)paramProtoReq.jdField_a_of_type_JavaLangObject;
        if (paramProtoReq.a())
        {
          long l1 = paramProtoReq.a();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 192, new Object[] { Integer.valueOf(i1), localObject, str2, str1, paramProtoResp, Integer.valueOf(i2), null, Long.valueOf(l1) });
          return;
          if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
            bool = false;
            i1 = -100002;
            paramProtoResp = str3;
            continue;
          }
          paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
          localRspBody = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramProtoResp);
        if (!localRspBody.uint32_return_code.has()) {
          break label478;
        }
        i1 = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0x7_rsp_body.has()) {
          break label354;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        bool = false;
        i1 = -100003;
        paramProtoResp = str3;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        bool = false;
        i1 = -100003;
        paramProtoResp = str3;
      }
      break;
      label354:
      localObject = (cmd0x345.RspBody.SubCmd0x7RspBody)localRspBody.msg_subcmd_0x7_rsp_body.get();
      str1 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject).str_server_ip.get();
      paramProtoResp = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject).str_dns.get();
      i2 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject).uint32_server_port.get();
      str2 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject).str_url.get();
      localObject = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject).str_ret_msg.get();
      bool = true;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 21, new Object[] { Integer.valueOf(i1), localObject, str2, str1, paramProtoResp, Integer.valueOf(i2) });
      return;
      break label104;
      label478:
      i1 = 0;
    }
  }
  
  private void m(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    String str = "";
    int i1;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      i1 = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      str = null;
      paramProtoResp = "";
    }
    long l1;
    for (boolean bool = false;; bool = false)
    {
      if (i1 != 0) {
        bool = false;
      }
      if (str == null) {
        bool = false;
      }
      l1 = ((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a();
      paramProtoReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
      if (paramProtoReq != null) {
        break label365;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1000) {
        break;
      }
      i1 = -100002;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      str = null;
      paramProtoResp = "";
    }
    paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    Object localObject = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject).mergeFrom(paramProtoResp);
        if (!((cmd0x345.RspBody)localObject).uint32_return_code.has()) {
          break label857;
        }
        i1 = ((cmd0x345.RspBody)localObject).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x6_rsp_body.has()) {
          break label304;
        }
        i1 = -100003;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        str = null;
        paramProtoResp = "";
        bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        i1 = -100003;
        str = null;
        paramProtoResp = "";
        bool = false;
      }
      break;
      label304:
      localObject = (cmd0x345.RspBody.SubCmd0x6RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x6_rsp_body.get();
      paramProtoResp = str;
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_ret_msg.has()) {
        paramProtoResp = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_ret_msg.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_file_id.has()) {}
      for (str = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_file_id.get();; str = null)
      {
        bool = true;
        break;
        label365:
        paramProtoReq.status = 0;
        if (bool)
        {
          paramProtoReq.status = 1;
          switch (paramProtoReq.nOpType)
          {
          default: 
            if (QLog.isDevelopLevel()) {
              throw new NullPointerException("类型错误！");
            }
            break;
          case 21: 
            paramProtoReq.Uuid = str;
            paramProtoReq.peerType = 0;
            paramProtoReq.setCloudType(1);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(i1), paramProtoResp, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l1) });
            a(paramProtoReq.peerUin, paramProtoReq, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProtoReq, 6, null);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramProtoReq);
          return;
          paramProtoReq.WeiYunFileId = str;
          paramProtoReq.setCloudType(2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 34, new Object[] { Integer.valueOf(i1), paramProtoResp, str, Long.valueOf(l1) });
          continue;
          if ((paramProtoReq.mContext instanceof IForwardCallBack))
          {
            ((IForwardCallBack)paramProtoReq.mContext).a(bool, paramProtoReq.strTroopFileUuid, paramProtoReq.nSessionId, i1, paramProtoResp, String.valueOf(paramProtoReq.peerUin), str);
            continue;
            switch (paramProtoReq.nOpType)
            {
            default: 
              if (QLog.isDevelopLevel()) {
                throw new NullPointerException("类型错误！");
              }
              break;
            case 21: 
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(i1), paramProtoResp, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l1) });
              break;
            case 20: 
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 34, new Object[] { Integer.valueOf(i1), paramProtoResp, str, Long.valueOf(l1) });
              break;
            case 27: 
              if ((paramProtoReq.mContext instanceof IForwardCallBack)) {
                ((IForwardCallBack)paramProtoReq.mContext).a(bool, paramProtoReq.strTroopFileUuid, paramProtoReq.nSessionId, i1, paramProtoResp, String.valueOf(paramProtoReq.peerUin), str);
              }
              break;
            }
          }
        }
      }
      label857:
      i1 = 0;
    }
  }
  
  private void n(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    String str1 = "";
    int i1 = 80;
    Object localObject2 = "";
    String str2 = "";
    String str3 = "";
    Object localObject3 = "";
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      i1 = 80;
      localObject2 = "";
      str1 = "";
    }
    long l2;
    label140:
    boolean bool;
    for (long l1 = -100001L;; l1 = -100002L)
    {
      if (l1 != 0L) {}
      localObject4 = (rwe)paramProtoReq.jdField_a_of_type_JavaLangObject;
      if (l1 != -100001L) {
        break label700;
      }
      l2 = 9043L;
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label784;
      }
      bool = true;
      label156:
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder().append("internalDownloadDiscFile: return ").append(bool).append(", retCode=").append(l2).append(", strHost=").append((String)localObject2).append(", strCheckSum=");
        if (str1 == null) {
          break label790;
        }
        paramProtoReq = str1;
        label216:
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoReq + ", strCookie=" + str2 + ", port=" + i1);
      }
      a(((rwe)localObject4).a(), 5013, bool, new Object[] { Long.valueOf(l2), str3, localObject3, localObject2, Integer.valueOf(i1), str1, str2, Integer.valueOf(paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getAppSeq()), Long.valueOf(((rwe)localObject4).a()) });
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1000) {
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      i1 = 80;
      localObject2 = "";
      str1 = "";
    }
    Object localObject4 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    Object localObject5 = new cmd0x345.RspBody();
    for (;;)
    {
      Object localObject1;
      try
      {
        ((cmd0x345.RspBody)localObject5).mergeFrom((byte[])localObject4);
        if (!((cmd0x345.RspBody)localObject5).uint32_return_code.has()) {
          break label805;
        }
        l1 = ((cmd0x345.RspBody)localObject5).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject5).msg_subcmd_0x3_rsp_body.has()) {
          break label527;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        i1 = 80;
        localObject2 = "";
        str1 = "";
        l1 = -100003L;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        i1 = 80;
        localObject2 = "";
        localObject1 = "";
        l1 = -100003L;
      }
      break;
      label527:
      localObject3 = (cmd0x345.RspBody.SubCmd0x3RspBody)((cmd0x345.RspBody)localObject5).msg_subcmd_0x3_rsp_body.get();
      if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_host.has()) {
        localObject1 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_host.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).uint32_port.has()) {
        i1 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).uint32_port.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_check_sum.has()) {
        localObject2 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_check_sum.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_cookie.has()) {
        str2 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_cookie.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).int32_ret_code.has()) {
        l1 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).int32_ret_code.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_ret_msg.has()) {
        str3 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_ret_msg.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_suggest_file_name.has()) {}
      for (localObject3 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_suggest_file_name.get();; localObject3 = "")
      {
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
        label700:
        if (l1 == -100003L)
        {
          l2 = 9045L;
          break label140;
        }
        if ((l1 == 0L) && (localObject2 == null)) {}
        for (int i2 = 1;; i2 = 0)
        {
          int i3 = ((rwe)localObject4).b();
          l2 = l1;
          if (i2 == 0) {
            break;
          }
          l2 = l1;
          if (i3 >= 3) {
            break;
          }
          ((rwe)localObject4).a();
          a(paramProtoReq.jdField_a_of_type_JavaLangString, paramProtoReq.jdField_a_of_type_ArrayOfByte, (rwe)localObject4);
          return;
        }
        label784:
        bool = false;
        break label156;
        label790:
        paramProtoReq = "";
        break label216;
      }
      label805:
      l1 = 0L;
    }
  }
  
  private void o(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    Object localObject4 = "";
    Object localObject1 = "";
    Object localObject3 = "";
    String str1 = "";
    int i2 = 0;
    int i1 = 0;
    String str2 = "";
    Object localObject2 = "";
    boolean bool;
    long l1;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      localObject1 = "";
      bool = false;
      paramProtoResp = "";
      l1 = -100001L;
    }
    label125:
    label148:
    Object localObject5;
    for (;;)
    {
      if (l1 != 0L)
      {
        bool = false;
        localObject4 = (rwe)paramProtoReq.jdField_a_of_type_JavaLangObject;
        if (l1 == -100001L)
        {
          l1 = 9043L;
          a(((rwe)localObject4).a(), 5015, bool, new Object[] { Long.valueOf(l1), localObject1, paramProtoResp, localObject3, str1, Integer.valueOf(i1), str2, localObject2 });
          return;
          if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
            localObject1 = "";
            bool = false;
            paramProtoResp = "";
            l1 = -100002L;
            continue;
          }
          paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
          localObject5 = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject5).mergeFrom(paramProtoResp);
        if (!((cmd0x345.RspBody)localObject5).uint32_return_code.has()) {
          break label681;
        }
        l1 = ((cmd0x345.RspBody)localObject5).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject5).msg_subcmd_0x1_rsp_body.has()) {
          break label393;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
        localObject1 = "";
        bool = false;
        paramProtoResp = "";
        l1 = -100003L;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        localObject1 = "";
        bool = false;
        paramProtoResp = "";
        l1 = -100003L;
      }
      break;
      label393:
      localObject5 = (cmd0x345.RspBody.SubCmd0x1RspBody)((cmd0x345.RspBody)localObject5).msg_subcmd_0x1_rsp_body.get();
      paramProtoResp = (ProtoReqManager.ProtoResp)localObject4;
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_file_id.has()) {
        paramProtoResp = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_file_id.get();
      }
      localObject2 = localObject1;
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_file_key.has()) {
        localObject2 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_file_key.get();
      }
      localObject1 = localObject3;
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_check_sum.has()) {
        localObject1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_check_sum.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_host.has()) {
        str1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_host.get();
      }
      i1 = i2;
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).uint32_port.has()) {
        i1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).uint32_port.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_file_name.has()) {
        str2 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_file_name.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_warn.has()) {}
      for (localObject3 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject5).str_warn.get();; localObject3 = "")
      {
        localObject4 = localObject2;
        localObject5 = paramProtoResp;
        bool = true;
        localObject2 = localObject3;
        localObject3 = localObject1;
        paramProtoResp = (ProtoReqManager.ProtoResp)localObject4;
        localObject1 = localObject5;
        break;
        if (l1 == -100003L)
        {
          l1 = 9045L;
          break label148;
        }
        if ((str1 == null) || (str1.length() == 0)) {}
        for (i2 = 1;; i2 = 0)
        {
          int i3 = ((rwe)localObject4).b();
          if ((i2 == 0) || (i3 >= 3)) {
            break;
          }
          ((rwe)localObject4).a();
          a(paramProtoReq.jdField_a_of_type_JavaLangString, paramProtoReq.jdField_a_of_type_ArrayOfByte, (rwe)localObject4);
          return;
        }
        break label148;
        break label125;
      }
      label681:
      l1 = 0L;
    }
  }
  
  private void p(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    long l2 = -100003L;
    long l1;
    boolean bool;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      l1 = -100001L;
      bool = false;
    }
    label87:
    label117:
    cmd0x345.RspBody localRspBody;
    for (;;)
    {
      if (l1 != 0L)
      {
        bool = false;
        paramProtoReq = (rwe)paramProtoReq.jdField_a_of_type_JavaLangObject;
        l2 = paramProtoReq.a();
        if (l2 == 0L)
        {
          QLog.e("FileTransferHandler<FileAssistant>", 1, "why there is 0?!");
          a(paramProtoReq.a(), 5016, bool, new Object[] { Long.valueOf(l1) });
          return;
          if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
            l1 = -100002L;
            bool = false;
            continue;
          }
          paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
          localRspBody = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramProtoResp);
        if (!localRspBody.uint32_return_code.has()) {
          break label416;
        }
        l1 = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0x2_rsp_body.has()) {
          break label291;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
        bool = false;
        l1 = l2;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        bool = false;
        l1 = l2;
      }
      break;
      label291:
      bool = true;
      break;
      paramProtoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l2);
      if (paramProtoResp == null) {
        break label117;
      }
      if (bool)
      {
        paramProtoResp.status = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProtoResp, 6, "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramProtoResp);
        break;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "nSessionId[" + l2 + "] sendDiscFeed faild,retCode[" + l1 + "]");
        paramProtoResp.status = 0;
        a(l1, paramProtoResp);
      }
      break label87;
      label416:
      l1 = 0L;
    }
  }
  
  private void q(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    FileTransferHandler.FileUploadInfo localFileUploadInfo = new FileTransferHandler.FileUploadInfo(this);
    Object localObject1 = null;
    boolean bool;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      localFileUploadInfo.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      bool = false;
    }
    int i1;
    label114:
    int i2;
    label134:
    label210:
    cmd0x346.RspBody localRspBody;
    for (;;)
    {
      localFileUploadInfo.jdField_d_of_type_Int = 2;
      if ((localFileUploadInfo.jdField_b_of_type_JavaLangString == null) || (localFileUploadInfo.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label845;
      }
      i1 = 1;
      if ((localFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (localFileUploadInfo.jdField_a_of_type_ArrayOfByte.length != 0)) {
        break label851;
      }
      i2 = 1;
      Object localObject2 = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject2).jdField_c_of_type_Int = localFileUploadInfo.jdField_a_of_type_Int;
      ((MessageObserver.StatictisInfo)localObject2).jdField_d_of_type_Int = paramProtoResp.jdField_a_of_type_Int;
      if ((i2 == 0) || (i1 == 0)) {
        break label857;
      }
      localFileUploadInfo.jdField_a_of_type_JavaLangString = ("uuid_null[" + localFileUploadInfo.toString() + "]");
      bool = false;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localFileUploadInfo.jdField_a_of_type_Int + ", retMsg=" + localFileUploadInfo.jdField_a_of_type_JavaLangString + ", totalSpace=" + localFileUploadInfo.jdField_a_of_type_Long + ", usedSpace=" + localFileUploadInfo.jdField_b_of_type_Long + ", ip=" + localFileUploadInfo.jdField_b_of_type_JavaLangString + ", port=" + localFileUploadInfo.jdField_a_of_type_Short);
      }
      a(((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a(), 5004, bool, new Object[] { localFileUploadInfo, localObject2, localObject1 });
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
      {
        localFileUploadInfo.jdField_a_of_type_Int = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
        bool = false;
      }
      else
      {
        localObject2 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject2);
          if (localRspBody.msg_apply_upload_rsp_v3.has()) {
            break;
          }
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          bool = false;
        }
      }
    }
    localObject1 = (cmd0x346.ApplyUploadRspV3)localRspBody.msg_apply_upload_rsp_v3.get();
    if (((cmd0x346.ApplyUploadRspV3)localObject1).int32_ret_code.has()) {
      localFileUploadInfo.jdField_a_of_type_Int = ((cmd0x346.ApplyUploadRspV3)localObject1).int32_ret_code.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).str_ret_msg.has()) {
      localFileUploadInfo.jdField_a_of_type_JavaLangString = ((cmd0x346.ApplyUploadRspV3)localObject1).str_ret_msg.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).uint64_total_space.has()) {
      localFileUploadInfo.jdField_a_of_type_Long = ((cmd0x346.ApplyUploadRspV3)localObject1).uint64_total_space.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).uint64_used_space.has()) {
      localFileUploadInfo.jdField_b_of_type_Long = ((cmd0x346.ApplyUploadRspV3)localObject1).uint64_used_space.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).uint64_uploaded_size.has()) {
      localFileUploadInfo.jdField_c_of_type_Long = ((cmd0x346.ApplyUploadRspV3)localObject1).uint64_uploaded_size.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).str_upload_ip.has())
    {
      localFileUploadInfo.jdField_b_of_type_JavaLangString = ((cmd0x346.ApplyUploadRspV3)localObject1).str_upload_ip.get();
      label652:
      if (((cmd0x346.ApplyUploadRspV3)localObject1).uint32_upload_port.has()) {
        localFileUploadInfo.jdField_a_of_type_Short = ((short)((cmd0x346.ApplyUploadRspV3)localObject1).uint32_upload_port.get());
      }
      if (((cmd0x346.ApplyUploadRspV3)localObject1).bytes_uuid.has()) {
        localFileUploadInfo.jdField_a_of_type_ArrayOfByte = ((cmd0x346.ApplyUploadRspV3)localObject1).bytes_uuid.get().toByteArray();
      }
      if (((cmd0x346.ApplyUploadRspV3)localObject1).bytes_upload_key.has()) {
        localFileUploadInfo.jdField_b_of_type_ArrayOfByte = ((cmd0x346.ApplyUploadRspV3)localObject1).bytes_upload_key.get().toByteArray();
      }
      if (((cmd0x346.ApplyUploadRspV3)localObject1).bool_file_exist.has()) {
        localFileUploadInfo.jdField_a_of_type_Boolean = ((cmd0x346.ApplyUploadRspV3)localObject1).bool_file_exist.get();
      }
      if (((cmd0x346.ApplyUploadRspV3)localObject1).uint32_upload_port.has()) {
        localFileUploadInfo.jdField_b_of_type_Int = ((cmd0x346.ApplyUploadRspV3)localObject1).uint32_pack_size.get();
      }
      if ((!((cmd0x346.ApplyUploadRspV3)localObject1).rpt_str_uploadip_list.has()) || (((cmd0x346.ApplyUploadRspV3)localObject1).rpt_str_uploadip_list.get().size() <= 0)) {
        break label860;
      }
    }
    label845:
    label851:
    label857:
    label860:
    for (localObject1 = ((cmd0x346.ApplyUploadRspV3)localObject1).rpt_str_uploadip_list.get();; localObject1 = null)
    {
      bool = true;
      break;
      if (((cmd0x346.ApplyUploadRspV3)localObject1).str_upload_domain.has())
      {
        localFileUploadInfo.jdField_b_of_type_JavaLangString = ((cmd0x346.ApplyUploadRspV3)localObject1).str_upload_domain.get();
        break label652;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
      break label652;
      i1 = 0;
      break label114;
      i2 = 0;
      break label134;
      break label210;
    }
  }
  
  private void r(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    FileTransferHandler.FileUploadInfo localFileUploadInfo = new FileTransferHandler.FileUploadInfo(this);
    Object localObject1 = null;
    boolean bool;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      localFileUploadInfo.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      bool = false;
    }
    int i1;
    label108:
    int i2;
    for (;;)
    {
      if ((localFileUploadInfo.jdField_b_of_type_JavaLangString != null) && (localFileUploadInfo.jdField_b_of_type_JavaLangString.length() > 0))
      {
        i1 = 1;
        if ((localFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (localFileUploadInfo.jdField_a_of_type_ArrayOfByte.length != 0)) {
          break label892;
        }
        i2 = 1;
        label128:
        Object localObject2 = new MessageObserver.StatictisInfo();
        ((MessageObserver.StatictisInfo)localObject2).jdField_c_of_type_Int = localFileUploadInfo.jdField_a_of_type_Int;
        ((MessageObserver.StatictisInfo)localObject2).jdField_d_of_type_Int = paramProtoResp.jdField_a_of_type_Int;
        if ((i2 == 0) || (i1 == 0)) {
          break label898;
        }
        localFileUploadInfo.jdField_a_of_type_JavaLangString = ("uuid_null[" + localFileUploadInfo.toString() + "]");
        bool = false;
        label204:
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localFileUploadInfo.jdField_a_of_type_Int + ", retMsg=" + localFileUploadInfo.jdField_a_of_type_JavaLangString + ", totalSpace=" + localFileUploadInfo.jdField_a_of_type_Long + ", usedSpace=" + localFileUploadInfo.jdField_b_of_type_Long + ", ip=" + localFileUploadInfo.jdField_b_of_type_JavaLangString + ", port=" + localFileUploadInfo.jdField_a_of_type_Short);
        }
        a(((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a(), 5004, bool, new Object[] { localFileUploadInfo, localObject2, localObject1 });
        return;
        if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
        {
          localFileUploadInfo.jdField_a_of_type_Int = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
          bool = false;
        }
        else
        {
          localObject2 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
          cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
          try
          {
            localRspBody.mergeFrom((byte[])localObject2);
            if (localRspBody.msg_apply_upload_rsp_v2.has()) {
              break label502;
            }
            localFileUploadInfo.jdField_a_of_type_Int = -100003;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
            bool = false;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
            localFileUploadInfo.jdField_a_of_type_Int = -100003;
            bool = false;
          }
          continue;
          label502:
          localObject1 = (cmd0x346.ApplyUploadRspV2)localRspBody.msg_apply_upload_rsp_v2.get();
          if (((cmd0x346.ApplyUploadRspV2)localObject1).int32_ret_code.has()) {
            localFileUploadInfo.jdField_a_of_type_Int = ((cmd0x346.ApplyUploadRspV2)localObject1).int32_ret_code.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).str_ret_msg.has()) {
            localFileUploadInfo.jdField_a_of_type_JavaLangString = ((cmd0x346.ApplyUploadRspV2)localObject1).str_ret_msg.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).uint64_total_space.has()) {
            localFileUploadInfo.jdField_a_of_type_Long = ((cmd0x346.ApplyUploadRspV2)localObject1).uint64_total_space.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).uint64_used_space.has()) {
            localFileUploadInfo.jdField_b_of_type_Long = ((cmd0x346.ApplyUploadRspV2)localObject1).uint64_used_space.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).uint64_uploaded_size.has()) {
            localFileUploadInfo.jdField_c_of_type_Long = ((cmd0x346.ApplyUploadRspV2)localObject1).uint64_uploaded_size.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).str_upload_ip.has())
          {
            localFileUploadInfo.jdField_b_of_type_JavaLangString = ((cmd0x346.ApplyUploadRspV2)localObject1).str_upload_ip.get();
            label646:
            if (((cmd0x346.ApplyUploadRspV2)localObject1).uint32_upload_port.has()) {
              localFileUploadInfo.jdField_a_of_type_Short = ((short)((cmd0x346.ApplyUploadRspV2)localObject1).uint32_upload_port.get());
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).bytes_uuid.has()) {
              localFileUploadInfo.jdField_a_of_type_ArrayOfByte = ((cmd0x346.ApplyUploadRspV2)localObject1).bytes_uuid.get().toByteArray();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).bytes_upload_key.has()) {
              localFileUploadInfo.jdField_b_of_type_ArrayOfByte = ((cmd0x346.ApplyUploadRspV2)localObject1).bytes_upload_key.get().toByteArray();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).bool_file_exist.has()) {
              localFileUploadInfo.jdField_a_of_type_Boolean = ((cmd0x346.ApplyUploadRspV2)localObject1).bool_file_exist.get();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).uint32_upload_port.has()) {
              localFileUploadInfo.jdField_b_of_type_Int = ((cmd0x346.ApplyUploadRspV2)localObject1).uint32_pack_size.get();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).uint32_httpsvr_api_ver.has()) {
              localFileUploadInfo.jdField_d_of_type_Int = ((cmd0x346.ApplyUploadRspV2)localObject1).uint32_httpsvr_api_ver.get();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).bytes_sha.has()) {
              localFileUploadInfo.jdField_d_of_type_ArrayOfByte = ((cmd0x346.ApplyUploadRspV2)localObject1).bytes_sha.get().toByteArray();
            }
            if ((!((cmd0x346.ApplyUploadRspV2)localObject1).rpt_str_uploadip_list.has()) || (((cmd0x346.ApplyUploadRspV2)localObject1).rpt_str_uploadip_list.get().size() <= 0)) {
              break label901;
            }
          }
        }
      }
    }
    label892:
    label898:
    label901:
    for (localObject1 = ((cmd0x346.ApplyUploadRspV2)localObject1).rpt_str_uploadip_list.get();; localObject1 = null)
    {
      bool = true;
      break;
      if (((cmd0x346.ApplyUploadRspV2)localObject1).str_upload_domain.has())
      {
        localFileUploadInfo.jdField_b_of_type_JavaLangString = ((cmd0x346.ApplyUploadRspV2)localObject1).str_upload_domain.get();
        break label646;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
      break label646;
      i1 = 0;
      break label108;
      i2 = 0;
      break label128;
      break label204;
    }
  }
  
  private void s(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    FileTransferHandler.FileUploadInfo localFileUploadInfo = new FileTransferHandler.FileUploadInfo(this);
    boolean bool;
    int i1;
    label102:
    int i2;
    label120:
    Object localObject;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      localFileUploadInfo.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      bool = false;
      if ((localFileUploadInfo.jdField_b_of_type_JavaLangString == null) || (localFileUploadInfo.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label729;
      }
      i1 = 1;
      if ((localFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (localFileUploadInfo.jdField_a_of_type_ArrayOfByte.length != 0)) {
        break label735;
      }
      i2 = 1;
      localObject = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject).jdField_c_of_type_Int = localFileUploadInfo.jdField_a_of_type_Int;
      ((MessageObserver.StatictisInfo)localObject).jdField_d_of_type_Int = paramProtoResp.jdField_a_of_type_Int;
      if ((i2 == 0) || (i1 == 0)) {
        break label741;
      }
      localFileUploadInfo.jdField_a_of_type_JavaLangString = ("uuid_null[" + localFileUploadInfo.toString() + "]");
      bool = false;
    }
    label481:
    label729:
    label735:
    label741:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localFileUploadInfo.jdField_a_of_type_Int + ", retMsg=" + localFileUploadInfo.jdField_a_of_type_JavaLangString + ", totalSpace=" + localFileUploadInfo.jdField_a_of_type_Long + ", usedSpace=" + localFileUploadInfo.jdField_b_of_type_Long + ", ip=" + localFileUploadInfo.jdField_b_of_type_JavaLangString + ", port=" + localFileUploadInfo.jdField_a_of_type_Short);
      }
      a(((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a(), 5020, bool, new Object[] { localFileUploadInfo, localObject, null });
      return;
      if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
      {
        localFileUploadInfo.jdField_a_of_type_Int = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
        bool = false;
        break;
      }
      localObject = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
      cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
      try
      {
        localRspBody.mergeFrom((byte[])localObject);
        if (localRspBody.msg_apply_upload_hit_rsp_v2.has()) {
          break label481;
        }
        localFileUploadInfo.jdField_a_of_type_Int = -100003;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
        bool = false;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localFileUploadInfo.jdField_a_of_type_Int = -100003;
        bool = false;
      }
      break;
      cmd0x346.ApplyUploadHitRspV2 localApplyUploadHitRspV2 = (cmd0x346.ApplyUploadHitRspV2)localRspBody.msg_apply_upload_hit_rsp_v2.get();
      if (localApplyUploadHitRspV2.int32_ret_code.has()) {
        localFileUploadInfo.jdField_a_of_type_Int = localApplyUploadHitRspV2.int32_ret_code.get();
      }
      if (localApplyUploadHitRspV2.str_ret_msg.has()) {
        localFileUploadInfo.jdField_a_of_type_JavaLangString = localApplyUploadHitRspV2.str_ret_msg.get();
      }
      if (localApplyUploadHitRspV2.uint64_total_space.has()) {
        localFileUploadInfo.jdField_a_of_type_Long = localApplyUploadHitRspV2.uint64_total_space.get();
      }
      if (localApplyUploadHitRspV2.uint64_used_space.has()) {
        localFileUploadInfo.jdField_b_of_type_Long = localApplyUploadHitRspV2.uint64_used_space.get();
      }
      if (localApplyUploadHitRspV2.str_upload_ip.has()) {
        localFileUploadInfo.jdField_b_of_type_JavaLangString = localApplyUploadHitRspV2.str_upload_ip.get();
      }
      for (;;)
      {
        if (localApplyUploadHitRspV2.uint32_upload_port.has()) {
          localFileUploadInfo.jdField_a_of_type_Short = ((short)localApplyUploadHitRspV2.uint32_upload_port.get());
        }
        if (localApplyUploadHitRspV2.bytes_uuid.has()) {
          localFileUploadInfo.jdField_a_of_type_ArrayOfByte = localApplyUploadHitRspV2.bytes_uuid.get().toByteArray();
        }
        if (localApplyUploadHitRspV2.bytes_upload_key.has()) {
          localFileUploadInfo.jdField_b_of_type_ArrayOfByte = localApplyUploadHitRspV2.bytes_upload_key.get().toByteArray();
        }
        bool = true;
        break;
        if (localApplyUploadHitRspV2.str_upload_domain.has()) {
          localFileUploadInfo.jdField_b_of_type_JavaLangString = localApplyUploadHitRspV2.str_upload_domain.get();
        } else {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
        }
      }
      i1 = 0;
      break label102;
      i2 = 0;
      break label120;
    }
  }
  
  private void t(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i1 = -100003;
    boolean bool2 = false;
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRecallResponse ");
    }
    boolean bool1;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      i1 = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      bool1 = false;
      paramProtoResp = (ProtoReqManager.ProtoResp)localObject;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        bool1 = bool2;
        label106:
        paramProtoReq = (FMConstants.revertMsgCallback)((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a();
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRecallResponse [" + bool1 + "],retCode[" + i1 + "], retMsg[" + paramProtoResp + "]");
        }
        if (bool1)
        {
          paramProtoReq.a();
          return;
          if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
          {
            i1 = -100002;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
            bool1 = false;
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject;
            continue;
          }
          paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
          cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
          try
          {
            localRspBody.mergeFrom(paramProtoResp);
            if (localRspBody.msg_recall_file_rsp.has()) {
              break label320;
            }
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
            bool1 = false;
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject;
          }
          catch (InvalidProtocolBufferMicroException paramProtoResp)
          {
            paramProtoResp.printStackTrace();
            bool1 = false;
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject;
          }
          continue;
          label320:
          paramProtoResp = (cmd0x346.RecallFileRsp)localRspBody.msg_recall_file_rsp.get();
          if (!paramProtoResp.int32_ret_code.has()) {
            break label393;
          }
        }
      }
    }
    label393:
    for (i1 = paramProtoResp.int32_ret_code.get();; i1 = 0)
    {
      if (paramProtoResp.str_ret_msg.has()) {}
      for (paramProtoResp = paramProtoResp.str_ret_msg.get();; paramProtoResp = null)
      {
        bool1 = true;
        break;
        paramProtoReq.a(i1, paramProtoResp);
        return;
        break label106;
      }
    }
  }
  
  private void u(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    boolean bool2 = false;
    String str = "";
    int i1;
    boolean bool1;
    if ((paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1002) || (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() == 1013))
    {
      i1 = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
      bool1 = false;
      paramProtoResp = str;
    }
    label89:
    cmd0x345.RspBody localRspBody;
    for (;;)
    {
      if (i1 != 0)
      {
        bool1 = bool2;
        paramProtoReq = (FMConstants.revertMsgCallback)((rwe)paramProtoReq.jdField_a_of_type_JavaLangObject).a();
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "internalDeleteDiscFile [" + bool1 + "],retCode[" + i1 + "], retMsg[" + paramProtoResp + "]");
        }
        if (paramProtoReq == null)
        {
          QLog.e("FileTransferHandler<FileAssistant>", 1, "del disc file, but callback is null!!!,check here!!!");
          return;
          if (paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() != 1000)
          {
            i1 = -100002;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is failed[" + paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode() + "]");
            bool1 = false;
            paramProtoResp = str;
            continue;
          }
          paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
          localRspBody = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramProtoResp);
        if (!localRspBody.uint32_return_code.has()) {
          break label402;
        }
        i1 = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0xa_rsp_body.has()) {
          break label334;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
        i1 = -100003;
        bool1 = false;
        paramProtoResp = str;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        i1 = -100003;
        bool1 = false;
        paramProtoResp = str;
      }
      break;
      label334:
      paramProtoResp = (cmd0x345.RspBody.SubCmd0xaRspBody)localRspBody.msg_subcmd_0xa_rsp_body.get();
      if (paramProtoResp.str_ret_msg.has()) {}
      for (paramProtoResp = paramProtoResp.str_ret_msg.get();; paramProtoResp = "")
      {
        bool1 = true;
        break;
        if (bool1)
        {
          paramProtoReq.a();
          return;
        }
        paramProtoReq.a(i1, paramProtoResp);
        return;
        break label89;
      }
      label402:
      i1 = 0;
    }
  }
  
  public long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "handleDiscFileCome,uinseq[" + String.valueOf(paramLong1) + "],discUin[" + String.valueOf(paramLong2) + "],sendUin[" + String.valueOf(paramLong3) + "],seq[" + String.valueOf(paramLong4) + "],msgTime[" + String.valueOf(paramLong6) + "],fileInfo[" + String.valueOf(paramGroupFile) + "]");
    }
    return b(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramGroupFile, paramInt1, paramInt2);
  }
  
  public long a(List paramList, String paramString1, String paramString2, String paramString3, long paramLong1, boolean paramBoolean, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt3, int paramInt4, hummer_resv_21.FileImgInfo paramFileImgInfo)
  {
    paramString5 = MessageRecordFactory.a(paramInt3);
    paramString5.uniseq = paramLong4;
    paramString5.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramString5.frienduin = paramString1;
    paramString5.senderuin = paramString2;
    if ((paramString4 == null) || (paramString4.length() < 1)) {
      paramString4 = TransfileUtile.a(paramString3, paramLong1, 0, paramBoolean);
    }
    for (;;)
    {
      if (paramInt3 == 62528)
      {
        paramString5.msg = paramString3;
        paramString5.msgtype = paramInt3;
        paramString5.isread = paramBoolean;
        if (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
          break label484;
        }
        paramInt2 = 1;
        label110:
        paramString5.issend = paramInt2;
        paramString5.istroop = paramInt1;
        paramString5.msgseq = paramLong2;
        paramString5.shmsgseq = MessageUtils.a(paramLong2, paramInt1);
        paramString5.msgUid = paramLong5;
        paramString5.time = paramLong7;
        if (!paramString5.isSend()) {
          break label490;
        }
        ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramString5);
      }
      for (;;)
      {
        paramString5.vipBubbleDiyTextId = paramInt4;
        if (paramFileImgInfo != null)
        {
          paramString5.saveExtInfoToExtStr("file_pic_width", String.valueOf(paramFileImgInfo.uint32_file_width.get()));
          paramString5.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(paramFileImgInfo.uint32_file_height.get()));
        }
        if (paramInt3 == 63531) {
          ((MessageForFile)paramString5).parse();
        }
        paramList.add(paramString5);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, paramInt1);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(paramString5.uniseq) + "], selfuin[" + FileManagerUtil.e(paramString5.selfuin) + "], frienduin[" + FileManagerUtil.e(paramString5.frienduin) + "], senderuin[" + FileManagerUtil.e(paramString5.senderuin) + "], issend[" + String.valueOf(paramString5.issend) + "], istroop[" + String.valueOf(paramString5.istroop) + "], shmsgseq[" + String.valueOf(paramString5.shmsgseq) + "], msgUid[" + String.valueOf(paramString5.msgUid) + "], time[" + String.valueOf(paramString5.time) + "], vipBubbleID[" + String.valueOf(paramLong6) + "], bubbleDiyTextId[" + String.valueOf(paramInt4) + "]");
        return paramString5.uniseq;
        paramString3 = paramString4;
        break;
        label484:
        paramInt2 = 0;
        break label110;
        label490:
        if (paramLong6 != -1L) {
          paramString5.vipBubbleID = paramLong6;
        } else {
          paramString5.vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
        }
      }
    }
  }
  
  public MessageRecord a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("------->msgFilter :msgIsTroop:").append(paramInt).append(",peerUin:").append(paramString1).append(",list size:");
      if (localObject == null)
      {
        paramInt = 0;
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramInt);
      }
    }
    else
    {
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label257;
      }
      paramString1 = ((List)localObject).iterator();
      label98:
      do
      {
        if (!paramString1.hasNext()) {
          break label257;
        }
        localObject = (MessageRecord)paramString1.next();
        if ((((MessageRecord)localObject).msgUid == 0L) || (paramLong3 == 0L)) {
          break;
        }
      } while ((((MessageRecord)localObject).msgUid != paramLong3) || (((MessageRecord)localObject).shmsgseq != paramLong2) || (!((MessageRecord)localObject).senderuin.equals(paramString2)));
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
      }
    }
    do
    {
      return (MessageRecord)localObject;
      paramInt = ((List)localObject).size();
      break;
      if ((Math.abs(((MessageRecord)localObject).time - paramLong1) >= 30L) || (((MessageRecord)localObject).shmsgseq != paramLong2) || (!((MessageRecord)localObject).senderuin.equals(paramString2))) {
        break label98;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
    return (MessageRecord)localObject;
    label257:
    return null;
  }
  
  public OnlineFileSessionInfo a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed context=null");
      return null;
    }
    int i1 = paramArrayOfByte.length;
    OnlineFileSessionInfo localOnlineFileSessionInfo = new OnlineFileSessionInfo();
    int i2;
    if (i1 >= 16)
    {
      PkgTools.b(paramArrayOfByte, 0, localOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte, 16);
      if (i1 >= 28)
      {
        localOnlineFileSessionInfo.jdField_b_of_type_Long = PkgTools.a(paramArrayOfByte, 24);
        if (i1 < 51) {
          break label117;
        }
        i2 = PkgTools.a(paramArrayOfByte, 49);
        if (i2 >= 4) {
          break label128;
        }
        localOnlineFileSessionInfo.jdField_b_of_type_Boolean = false;
        return localOnlineFileSessionInfo;
      }
    }
    else
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufAppGuid");
      return null;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - dwSessionId");
    return null;
    label117:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufOther");
    return null;
    label128:
    byte[] arrayOfByte = new byte[i2];
    label155:
    int i3;
    int i4;
    if (i1 >= i2 + 51)
    {
      PkgTools.b(paramArrayOfByte, 51, arrayOfByte, i2);
      i1 = 0;
      if (i1 < i2)
      {
        i3 = arrayOfByte[i1];
        i4 = i1 + 1;
        if (i2 < i4 + 2) {
          break label224;
        }
        i1 = PkgTools.a(arrayOfByte, i4);
        i4 += 2;
        if (i3 != 1) {
          break label236;
        }
      }
    }
    label224:
    label236:
    label428:
    do
    {
      for (;;)
      {
        i1 = i4 + i1;
        break label155;
        break;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - ismulitendpoint");
        return null;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - L");
        break;
        if ((i3 != 2) && (i3 != 3))
        {
          if (i3 == 4)
          {
            paramArrayOfByte = new byte[i1];
            if (i2 >= i4 + i1)
            {
              PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
              paramArrayOfByte = a(paramArrayOfByte);
              if (paramArrayOfByte != null)
              {
                localOnlineFileSessionInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte.jdField_a_of_type_JavaLangString;
                localOnlineFileSessionInfo.jdField_a_of_type_Long = paramArrayOfByte.jdField_a_of_type_Long;
              }
            }
            else
            {
              QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
              break;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "decode file info error for request or accept");
            return null;
          }
          if (i3 != 12) {
            if (i3 == 15)
            {
              if (i1 < 1)
              {
                localOnlineFileSessionInfo.jdField_b_of_type_Boolean = false;
              }
              else if (i2 >= i4 + i1)
              {
                paramArrayOfByte = new byte[i1];
                PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
                if (paramArrayOfByte[0] == 1) {}
                for (bool = true;; bool = false)
                {
                  localOnlineFileSessionInfo.jdField_b_of_type_Boolean = bool;
                  break;
                }
              }
            }
            else if (i3 == 17)
            {
              if (i1 >= 1) {
                break label428;
              }
              localOnlineFileSessionInfo.c = false;
            }
          }
        }
      }
    } while (i2 < i4 + i1);
    paramArrayOfByte = new byte[i1];
    PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
    if (paramArrayOfByte[0] == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localOnlineFileSessionInfo.c = bool;
      break;
    }
  }
  
  /* Error */
  public List a(MessageHandler paramMessageHandler, List paramList, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 541	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 542	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: new 541	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 542	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload 7
    //   20: aload_2
    //   21: invokeinterface 2032 2 0
    //   26: pop
    //   27: iconst_0
    //   28: istore 11
    //   30: iload 11
    //   32: aload 7
    //   34: invokeinterface 550 1 0
    //   39: if_icmpge +784 -> 823
    //   42: aload 7
    //   44: iload 11
    //   46: invokeinterface 554 2 0
    //   51: checkcast 2034	msf/msgcomm/msg_comm$Msg
    //   54: astore 8
    //   56: aload 8
    //   58: getfield 2038	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   61: invokevirtual 2041	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   64: checkcast 2040	msf/msgcomm/msg_comm$MsgHead
    //   67: astore_1
    //   68: aload 8
    //   70: getfield 2038	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   73: invokevirtual 2042	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   76: ifne +68 -> 144
    //   79: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +744 -> 826
    //   85: ldc 11
    //   87: iconst_2
    //   88: new 205	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 2044
    //   98: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: iload 11
    //   103: invokevirtual 768	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc_w 2046
    //   109: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: iconst_1
    //   119: istore 10
    //   121: iload 10
    //   123: ifeq +12 -> 135
    //   126: aload_2
    //   127: aload 8
    //   129: invokeinterface 2049 2 0
    //   134: pop
    //   135: iload 11
    //   137: iconst_1
    //   138: iadd
    //   139: istore 11
    //   141: goto -111 -> 30
    //   144: aload_1
    //   145: getfield 2052	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   148: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   151: i2s
    //   152: istore 13
    //   154: aload_1
    //   155: getfield 2055	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   158: invokevirtual 841	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   161: lstore 14
    //   163: aload_1
    //   164: getfield 2058	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   167: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   170: i2l
    //   171: lstore 16
    //   173: aload_1
    //   174: getfield 2061	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   177: invokevirtual 841	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   180: lstore 18
    //   182: aload_1
    //   183: getfield 2064	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   186: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   189: istore 10
    //   191: aload 8
    //   193: getfield 2038	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   196: invokevirtual 2041	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   199: checkcast 2040	msf/msgcomm/msg_comm$MsgHead
    //   202: getfield 2067	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   205: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   208: istore 12
    //   210: iload 10
    //   212: invokestatic 2070	com/tencent/mobileqq/service/message/MessageUtils:c	(I)Z
    //   215: ifeq +21 -> 236
    //   218: aload_1
    //   219: getfield 2067	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   222: invokevirtual 857	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   225: ifeq +11 -> 236
    //   228: iload 12
    //   230: sipush 169
    //   233: if_icmpeq +23 -> 256
    //   236: iload 10
    //   238: sipush 529
    //   241: if_icmpne +9 -> 250
    //   244: iload 12
    //   246: iconst_4
    //   247: if_icmpeq +9 -> 256
    //   250: iconst_0
    //   251: istore 10
    //   253: goto -132 -> 121
    //   256: iload 10
    //   258: invokestatic 2070	com/tencent/mobileqq/service/message/MessageUtils:c	(I)Z
    //   261: ifeq +199 -> 460
    //   264: aload_1
    //   265: getfield 2067	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   268: invokevirtual 857	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   271: ifeq +189 -> 460
    //   274: iload 12
    //   276: sipush 169
    //   279: if_icmpne +181 -> 460
    //   282: aload 8
    //   284: getfield 2074	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   287: invokevirtual 2077	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   290: ifeq +23 -> 313
    //   293: aload 8
    //   295: getfield 2074	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   298: invokevirtual 2078	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   301: checkcast 2076	tencent/im/msg/im_msg_body$MsgBody
    //   304: getfield 2082	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   307: invokevirtual 2085	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   310: ifne +74 -> 384
    //   313: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +510 -> 826
    //   319: ldc 11
    //   321: iconst_2
    //   322: new 205	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 2087
    //   332: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 8
    //   337: getfield 2074	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   340: invokevirtual 2077	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   343: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   346: ldc_w 2089
    //   349: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload 8
    //   354: getfield 2074	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   357: invokevirtual 2078	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   360: checkcast 2076	tencent/im/msg/im_msg_body$MsgBody
    //   363: getfield 2082	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   366: invokevirtual 2085	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   369: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   372: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: iconst_1
    //   379: istore 10
    //   381: goto -260 -> 121
    //   384: aload 8
    //   386: getfield 2074	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   389: invokevirtual 2078	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   392: checkcast 2076	tencent/im/msg/im_msg_body$MsgBody
    //   395: getfield 2082	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   398: invokevirtual 2090	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   401: checkcast 2084	tencent/im/msg/im_msg_body$RichText
    //   404: astore 9
    //   406: aload 9
    //   408: getfield 2094	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   411: invokevirtual 2097	tencent/im/msg/im_msg_body$NotOnlineFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   414: checkcast 2096	tencent/im/msg/im_msg_body$NotOnlineFile
    //   417: astore_1
    //   418: aload 9
    //   420: getfield 2094	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   423: invokevirtual 2098	tencent/im/msg/im_msg_body$NotOnlineFile:has	()Z
    //   426: ifne +24 -> 450
    //   429: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   432: ifeq +394 -> 826
    //   435: ldc 11
    //   437: iconst_2
    //   438: ldc_w 2100
    //   441: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: iconst_1
    //   445: istore 10
    //   447: goto -326 -> 121
    //   450: aload_1
    //   451: ifnonnull +154 -> 605
    //   454: iconst_1
    //   455: istore 10
    //   457: goto -336 -> 121
    //   460: iload 10
    //   462: sipush 529
    //   465: if_icmpne +361 -> 826
    //   468: iload 12
    //   470: iconst_4
    //   471: if_icmpne +355 -> 826
    //   474: aload 8
    //   476: getfield 2074	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   479: invokevirtual 2078	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   482: checkcast 2076	tencent/im/msg/im_msg_body$MsgBody
    //   485: getfield 2103	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   488: invokevirtual 869	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   491: invokevirtual 874	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   494: astore_1
    //   495: new 2105	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody
    //   498: dup
    //   499: invokespecial 2106	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:<init>	()V
    //   502: astore 9
    //   504: aload 9
    //   506: aload_1
    //   507: invokevirtual 2107	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   510: checkcast 2105	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody
    //   513: astore_1
    //   514: aload_1
    //   515: getfield 2110	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:msg_not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   518: invokevirtual 2098	tencent/im/msg/im_msg_body$NotOnlineFile:has	()Z
    //   521: ifne +70 -> 591
    //   524: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +299 -> 826
    //   530: ldc 11
    //   532: iconst_2
    //   533: ldc_w 2112
    //   536: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: iconst_1
    //   540: istore 10
    //   542: goto -421 -> 121
    //   545: astore_1
    //   546: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq +13 -> 562
    //   552: ldc 11
    //   554: iconst_2
    //   555: ldc_w 2114
    //   558: aload_1
    //   559: invokestatic 2117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   562: iconst_1
    //   563: istore 10
    //   565: goto -444 -> 121
    //   568: astore_1
    //   569: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +13 -> 585
    //   575: ldc 11
    //   577: iconst_2
    //   578: ldc_w 2119
    //   581: aload_1
    //   582: invokestatic 2117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   585: iconst_1
    //   586: istore 10
    //   588: goto -467 -> 121
    //   591: aload_1
    //   592: getfield 2110	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:msg_not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   595: invokevirtual 2097	tencent/im/msg/im_msg_body$NotOnlineFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   598: checkcast 2096	tencent/im/msg/im_msg_body$NotOnlineFile
    //   601: astore_1
    //   602: goto -152 -> 450
    //   605: aload_1
    //   606: getfield 2122	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   609: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   612: ifne +24 -> 636
    //   615: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +208 -> 826
    //   621: ldc 11
    //   623: iconst_2
    //   624: ldc_w 2124
    //   627: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: iconst_1
    //   631: istore 10
    //   633: goto -512 -> 121
    //   636: aload_1
    //   637: getfield 2127	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   640: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   643: istore 10
    //   645: aload_1
    //   646: getfield 2128	tencent/im/msg/im_msg_body$NotOnlineFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   649: invokevirtual 841	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   652: pop2
    //   653: aload_1
    //   654: getfield 2131	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_subcmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   657: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   660: pop
    //   661: iload 5
    //   663: ifeq +15 -> 678
    //   666: iload 10
    //   668: iconst_1
    //   669: if_icmpne +9 -> 678
    //   672: iconst_1
    //   673: istore 10
    //   675: goto -554 -> 121
    //   678: aload_0
    //   679: iconst_0
    //   680: lload_3
    //   681: invokestatic 498	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   684: lload 14
    //   686: invokestatic 498	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   689: lload 16
    //   691: iload 13
    //   693: i2l
    //   694: lload 18
    //   696: invokevirtual 2133	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(ILjava/lang/String;Ljava/lang/String;JJJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   699: astore 9
    //   701: aload 9
    //   703: ifnull +34 -> 737
    //   706: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq +12 -> 721
    //   712: ldc 11
    //   714: iconst_2
    //   715: ldc_w 1989
    //   718: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: aload 6
    //   723: aload 9
    //   725: invokeinterface 557 2 0
    //   730: pop
    //   731: iconst_1
    //   732: istore 10
    //   734: goto -613 -> 121
    //   737: iconst_0
    //   738: istore 10
    //   740: aload_1
    //   741: getfield 2136	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_reserved	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   744: invokevirtual 857	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   747: ifeq +28 -> 775
    //   750: aload_1
    //   751: getfield 2136	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_reserved	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   754: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   757: istore 12
    //   759: iload 12
    //   761: istore 10
    //   763: iload 12
    //   765: i2l
    //   766: lload 14
    //   768: lcmp
    //   769: ifne +6 -> 775
    //   772: iconst_0
    //   773: istore 10
    //   775: aload_0
    //   776: lload_3
    //   777: invokestatic 498	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   780: aload_1
    //   781: getfield 2139	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   784: invokevirtual 869	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   787: invokevirtual 1351	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   790: iload 10
    //   792: i2l
    //   793: iload 13
    //   795: i2l
    //   796: lload 18
    //   798: aload 6
    //   800: lload 14
    //   802: invokestatic 498	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   805: invokespecial 545	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Ljava/lang/String;Ljava/lang/String;JJJLjava/util/List;Ljava/lang/String;)Z
    //   808: ifeq +9 -> 817
    //   811: iconst_1
    //   812: istore 10
    //   814: goto -693 -> 121
    //   817: iconst_0
    //   818: istore 10
    //   820: goto -699 -> 121
    //   823: aload 6
    //   825: areturn
    //   826: iconst_1
    //   827: istore 10
    //   829: goto -708 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	FileTransferHandler
    //   0	832	1	paramMessageHandler	MessageHandler
    //   0	832	2	paramList	List
    //   0	832	3	paramLong	long
    //   0	832	5	paramBoolean	boolean
    //   7	817	6	localArrayList1	ArrayList
    //   16	27	7	localArrayList2	ArrayList
    //   54	421	8	localMsg	msg_comm.Msg
    //   404	320	9	localObject	Object
    //   119	709	10	i1	int
    //   28	112	11	i2	int
    //   208	556	12	i3	int
    //   152	642	13	i4	int
    //   161	640	14	l1	long
    //   171	519	16	l2	long
    //   180	617	18	l3	long
    // Exception table:
    //   from	to	target	type
    //   474	495	545	java/lang/Exception
    //   504	514	568	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public cmd0x346.ApplyUploadHitReqV2 a(Cmd0x346CSBody paramCmd0x346CSBody)
  {
    cmd0x346.ApplyUploadHitReqV2 localApplyUploadHitReqV2 = new cmd0x346.ApplyUploadHitReqV2();
    paramCmd0x346CSBody = paramCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2;
    localApplyUploadHitReqV2.uint64_sender_uin.set(paramCmd0x346CSBody.jdField_a_of_type_Long);
    localApplyUploadHitReqV2.uint64_recver_uin.set(paramCmd0x346CSBody.jdField_b_of_type_Long);
    localApplyUploadHitReqV2.uint64_file_size.set(paramCmd0x346CSBody.jdField_c_of_type_Long);
    localApplyUploadHitReqV2.str_file_name.set(paramCmd0x346CSBody.jdField_a_of_type_JavaLangString);
    localApplyUploadHitReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.jdField_a_of_type_ArrayOfByte));
    localApplyUploadHitReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.jdField_b_of_type_ArrayOfByte));
    localApplyUploadHitReqV2.bytes_sha.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.jdField_c_of_type_ArrayOfByte));
    localApplyUploadHitReqV2.str_local_filepath.set(paramCmd0x346CSBody.jdField_b_of_type_JavaLangString);
    localApplyUploadHitReqV2.uint32_danger_level.set(paramCmd0x346CSBody.jdField_a_of_type_Int);
    localApplyUploadHitReqV2.uint64_total_space.set(paramCmd0x346CSBody.jdField_d_of_type_Long);
    return localApplyUploadHitReqV2;
  }
  
  public cmd0x346.ApplyUploadReqV2 a(Cmd0x346CSBody paramCmd0x346CSBody)
  {
    cmd0x346.ApplyUploadReqV2 localApplyUploadReqV2 = new cmd0x346.ApplyUploadReqV2();
    paramCmd0x346CSBody = paramCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2;
    localApplyUploadReqV2.uint64_sender_uin.set(paramCmd0x346CSBody.jdField_a_of_type_Long);
    localApplyUploadReqV2.uint64_recver_uin.set(paramCmd0x346CSBody.jdField_b_of_type_Long);
    localApplyUploadReqV2.uint64_file_size.set(paramCmd0x346CSBody.jdField_c_of_type_Long);
    localApplyUploadReqV2.str_file_name.set(paramCmd0x346CSBody.jdField_a_of_type_JavaLangString);
    localApplyUploadReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.jdField_a_of_type_ArrayOfByte));
    localApplyUploadReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.jdField_b_of_type_ArrayOfByte));
    localApplyUploadReqV2.str_local_filepath.set(paramCmd0x346CSBody.jdField_b_of_type_JavaLangString);
    localApplyUploadReqV2.uint32_danger_level.set(paramCmd0x346CSBody.jdField_a_of_type_Int);
    localApplyUploadReqV2.uint64_total_space.set(paramCmd0x346CSBody.jdField_d_of_type_Long);
    return localApplyUploadReqV2;
  }
  
  public cmd0x346.ApplyUploadReqV3 a(Cmd0x346CSBody paramCmd0x346CSBody)
  {
    cmd0x346.ApplyUploadReqV3 localApplyUploadReqV3 = new cmd0x346.ApplyUploadReqV3();
    paramCmd0x346CSBody = paramCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3;
    localApplyUploadReqV3.uint64_sender_uin.set(paramCmd0x346CSBody.jdField_a_of_type_Long);
    localApplyUploadReqV3.uint64_recver_uin.set(paramCmd0x346CSBody.jdField_b_of_type_Long);
    localApplyUploadReqV3.uint64_file_size.set(paramCmd0x346CSBody.jdField_c_of_type_Long);
    localApplyUploadReqV3.str_file_name.set(paramCmd0x346CSBody.jdField_a_of_type_JavaLangString);
    localApplyUploadReqV3.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.jdField_a_of_type_ArrayOfByte));
    localApplyUploadReqV3.bytes_sha.set(ByteStringMicro.copyFrom(paramCmd0x346CSBody.jdField_b_of_type_ArrayOfByte));
    localApplyUploadReqV3.str_local_filepath.set(paramCmd0x346CSBody.jdField_b_of_type_JavaLangString);
    localApplyUploadReqV3.uint32_danger_level.set(paramCmd0x346CSBody.jdField_a_of_type_Int);
    localApplyUploadReqV3.uint64_total_space.set(paramCmd0x346CSBody.jdField_d_of_type_Long);
    return localApplyUploadReqV3;
  }
  
  public void a()
  {
    face2face_file.msg localmsg = new face2face_file.msg();
    localmsg.version.set(1);
    localmsg.result.set(0);
    a("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ", localmsg.toByteArray(), null);
  }
  
  public void a(int paramInt1, int paramInt2, FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardIntrlnal : uDstId[" + String.valueOf(paramFileManagerEntity.peerUin) + "]," + " uDstUin[" + String.valueOf(paramFileManagerEntity.selfUin) + " nDstSvcId[" + String.valueOf(paramInt1) + " uFileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + " strFileName[" + String.valueOf(paramFileManagerEntity.fileName) + " strUuid[" + String.valueOf(paramFileManagerEntity.Uuid) + "]");
    }
    if ((paramFileManagerEntity.Uuid == null) || (paramFileManagerEntity.Uuid.length() < 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "uuid or selfUin is null!!!");
      }
      return;
    }
    Object localObject1 = new cmd0x346.ApplyCopyToReq();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().replace("+", "");
    ((cmd0x346.ApplyCopyToReq)localObject1).uint64_dst_id.set(Long.parseLong((String)localObject2));
    if ((paramInt1 == 106) || (paramInt1 == 102) || (paramInt1 == 104)) {
      ((cmd0x346.ApplyCopyToReq)localObject1).uint64_dst_id.set(Long.parseLong(paramFileManagerEntity.peerUin));
    }
    if (paramInt1 == 38) {
      ((cmd0x346.ApplyCopyToReq)localObject1).uint64_dst_uin.set(Long.parseLong((String)localObject2));
    }
    for (;;)
    {
      ((cmd0x346.ApplyCopyToReq)localObject1).uint32_dst_svcid.set(paramInt1);
      ((cmd0x346.ApplyCopyToReq)localObject1).uint64_src_uin.set(Long.parseLong((String)localObject2));
      ((cmd0x346.ApplyCopyToReq)localObject1).uint64_file_size.set(paramFileManagerEntity.fileSize);
      ((cmd0x346.ApplyCopyToReq)localObject1).str_file_name.set(paramFileManagerEntity.fileName);
      ((cmd0x346.ApplyCopyToReq)localObject1).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
      localObject2 = new cmd0x346.ReqBody();
      ((cmd0x346.ReqBody)localObject2).msg_apply_copy_to_req.set((MessageMicro)localObject1);
      ((cmd0x346.ReqBody)localObject2).uint32_cmd.set(60100);
      localObject1 = ((cmd0x346.ReqBody)localObject2).uint32_seq;
      paramInt1 = q;
      q = paramInt1 + 1;
      ((PBUInt32Field)localObject1).set(paramInt1);
      ((cmd0x346.ReqBody)localObject2).uint32_business_id.set(paramInt2);
      ((cmd0x346.ReqBody)localObject2).uint32_client_type.set(104);
      paramFileManagerEntity = new rwe(this, false, paramFileManagerEntity.nSessionId);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", ((cmd0x346.ReqBody)localObject2).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
      return;
      if ((paramInt1 != 106) && (paramInt1 != 102) && (paramInt1 != 104) && (paramFileManagerEntity.selfUin != null) && (paramFileManagerEntity.selfUin.length() > 0))
      {
        String str = paramFileManagerEntity.selfUin.replace("+", "");
        ((cmd0x346.ApplyCopyToReq)localObject1).uint64_dst_uin.set(Long.parseLong(str));
      }
      else
      {
        ((cmd0x346.ApplyCopyToReq)localObject1).uint64_dst_uin.set(Long.parseLong(paramFileManagerEntity.peerUin));
      }
    }
  }
  
  public void a(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    a(paramInt, 3, paramFileManagerEntity);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, OnlineFileSessionInfo paramOnlineFileSessionInfo, long paramLong2, int paramInt3)
  {
    if (!a(paramOnlineFileSessionInfo)) {
      return;
    }
    switch (paramInt1)
    {
    case 130: 
    case 132: 
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] handleOnLineFilePushMsg. error cmd:" + paramInt1);
      return;
    case 129: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] handle cmd 0x81. request");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramOnlineFileSessionInfo, paramLong2, paramInt3);
      return;
    case 131: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] handle cmd 0x83. accept");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 1);
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] handle cmd 0x85. cancel.type:" + paramOnlineFileSessionInfo.jdField_a_of_type_Short + " reason:" + paramOnlineFileSessionInfo.jdField_b_of_type_Short);
    if (2 == paramOnlineFileSessionInfo.jdField_a_of_type_Short)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 2);
      return;
    }
    if (1 == paramOnlineFileSessionInfo.jdField_a_of_type_Short)
    {
      if (57 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 5);
        return;
      }
      if (70 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long);
        return;
      }
      if (71 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 4);
        return;
      }
      if (5 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 2);
        return;
      }
      if (paramOnlineFileSessionInfo.jdField_b_of_type_Short == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 3);
        return;
      }
      if (58 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long);
        return;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] canceltype:1.unkonw reason:" + paramOnlineFileSessionInfo.jdField_b_of_type_Short);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] unknow canceltype:" + paramOnlineFileSessionInfo.jdField_a_of_type_Short);
  }
  
  public void a(long paramLong, int paramInt, Cmd0x346CSBody paramCmd0x346CSBody, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramInt);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    Object localObject = localReqBody.uint32_seq;
    int i1 = q;
    q = i1 + 1;
    ((PBUInt32Field)localObject).set(i1);
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "send0x346Req, unknwon nCmdType:" + paramInt);
      }
      return;
    case 1600: 
      localObject = a(paramCmd0x346CSBody);
      localReqBody.msg_apply_upload_req_v2.set((MessageMicro)localObject);
      paramFileTransferObserver = new rwe(this, paramCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2.jdField_a_of_type_ArrayOfByte, null, paramCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV2.jdField_b_of_type_ArrayOfByte, paramFileTransferObserver);
      paramCmd0x346CSBody = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
    }
    for (;;)
    {
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
        ((cmd0x346.ExtensionReq)localObject).uint64_type.set(paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
          ((cmd0x346.ExtensionReq)localObject).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
        }
        if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
          ((cmd0x346.ExtensionReq)localObject).str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
        }
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
      }
      a(paramCmd0x346CSBody, localReqBody.toByteArray(), paramFileTransferObserver);
      return;
      localObject = a(paramCmd0x346CSBody);
      localReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
      paramFileTransferObserver = new rwe(this, paramCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3.jdField_a_of_type_ArrayOfByte, paramCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadReqV3.jdField_b_of_type_ArrayOfByte, null, paramFileTransferObserver);
      paramCmd0x346CSBody = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
      continue;
      localObject = a(paramCmd0x346CSBody);
      localReqBody.msg_apply_upload_hit_req_v2.set((MessageMicro)localObject);
      paramFileTransferObserver = new rwe(this, paramCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_a_of_type_ArrayOfByte, paramCmd0x346CSBody.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileCSCProtocalApplyUploadHitReqV2.jdField_c_of_type_ArrayOfByte, null, paramFileTransferObserver);
      paramCmd0x346CSBody = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
    }
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, FileTransferObserver paramFileTransferObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getDiscFile : String[" + paramString2 + "], nDiscId[" + paramLong2 + "]");
    }
    paramString1 = new cmd0x345.ReqBody.SubCmd0x3ReqBody();
    paramString1.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    paramString1.str_file_id.set(paramString2);
    paramString1.uint64_disscus_uin.set(paramLong2);
    paramString1.uint32_costom_id.set(0);
    paramString2 = new cmd0x345.ReqBody();
    paramString2.msg_subcmd_0x3_req_body.set(paramString1);
    paramString2.uint32_sub_cmd.set(3);
    paramString1 = new rwe(this, false, paramLong1, paramFileTransferObserver, 3);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString2.toByteArray(), paramString1);
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    cmd0x345.ReqBody.SubCmd0x5ReqBody localSubCmd0x5ReqBody = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
    localSubCmd0x5ReqBody.uint32_src_bus_id.set(106);
    localSubCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
    localSubCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(paramString4.getBytes()));
    localSubCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(paramString1));
    localSubCmd0x5ReqBody.uint64_file_size.set(paramLong2);
    localSubCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(paramString2));
    localSubCmd0x5ReqBody.str_file_name.set(paramString3);
    if ((paramString5 != null) && (paramString5.length() > 0)) {
      localSubCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramString5.getBytes()));
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x5_req_body.set(localSubCmd0x5ReqBody);
    paramString1.uint32_sub_cmd.set(6);
    paramString2 = new rwe(this, false, paramLong1, null, 6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, long paramLong3, long paramLong4, FileTransferObserver paramFileTransferObserver)
  {
    cmd0x345.ReqBody.SubCmd0x2ReqBody localSubCmd0x2ReqBody = new cmd0x345.ReqBody.SubCmd0x2ReqBody();
    int i1 = (int)Long.parseLong(paramString1);
    localSubCmd0x2ReqBody.uint32_disscus_uin.set(i1);
    i1 = (int)Long.parseLong(paramString2);
    localSubCmd0x2ReqBody.uint32_sender_uin.set(i1);
    localSubCmd0x2ReqBody.str_file_name.set(paramString3);
    localSubCmd0x2ReqBody.uint64_file_size.set(paramLong2);
    localSubCmd0x2ReqBody.str_file_id.set(paramString4);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_id.set(paramString1);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_item_id.set(paramString1);
    localSubCmd0x2ReqBody.uint64_time.set(MessageCache.a());
    localSubCmd0x2ReqBody.uint32_busid.set(106);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    if ((paramString1 != null) && (paramString1.nFileType == 0))
    {
      if (!FileUtil.b(paramString1.getFilePath())) {
        break label337;
      }
      paramString2 = new BitmapFactory.Options();
      paramString2.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString1.getFilePath(), paramString2);
      int i2 = paramString2.outWidth;
      i1 = paramString2.outHeight;
      int i3 = URLDrawableHelper.a(paramString1.getFilePath());
      if ((i3 == 90) || (i3 == 270))
      {
        i2 = paramString2.outHeight;
        i1 = paramString2.outWidth;
      }
      paramString1 = new hummer_resv_21.ResvAttr();
      paramString2 = new hummer_resv_21.FileImgInfo();
      paramString2.uint32_file_height.set(i1);
      paramString2.uint32_file_width.set(i2);
      paramString1.file_image_info.set(paramString2);
      localSubCmd0x2ReqBody.bytes_pb_bytes_reserve.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
    }
    while ((paramLong4 == 0L) && (QLog.isDevelopLevel()))
    {
      throw new NullPointerException();
      label337:
      paramString2 = new hummer_resv_21.ResvAttr();
      paramString3 = new hummer_resv_21.FileImgInfo();
      paramString3.uint32_file_height.set(paramString1.imgHeight);
      paramString3.uint32_file_width.set(paramString1.imgWidth);
      paramString2.file_image_info = paramString3;
      localSubCmd0x2ReqBody.bytes_pb_bytes_reserve.set(ByteStringMicro.copyFrom(paramString2.toByteArray()));
    }
    i1 = MessageUtils.a(paramLong4);
    localSubCmd0x2ReqBody.uint32_random.set(i1);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x2_req_body.set(localSubCmd0x2ReqBody);
    paramString1.uint32_sub_cmd.set(2);
    paramString2 = new rwe(this, false, paramLong1, paramFileTransferObserver, 2);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean, FileTransferObserver paramFileTransferObserver)
  {
    Object localObject = new cmd0x346.ApplyDownloadReq();
    ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 2)
    {
      ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type.set(i1);
      paramString = new cmd0x346.ReqBody();
      paramString.msg_apply_download_req.set((MessageMicro)localObject);
      paramString.uint32_cmd.set(1200);
      localObject = paramString.uint32_seq;
      i1 = q;
      q = i1 + 1;
      ((PBUInt32Field)localObject).set(i1);
      paramString.uint32_business_id.set(3);
      paramString.uint32_client_type.set(104);
      localObject = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject).uint32_download_url_type.set(1);
      paramString.msg_extension_req.set((MessageMicro)localObject);
      paramFileTransferObserver = new rwe(this, paramLong, paramFileTransferObserver);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString.toByteArray(), paramFileTransferObserver);
      return;
    }
  }
  
  public void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, im_msg_body.NotOnlineFile paramNotOnlineFile, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt, hummer_resv_21.FileImgInfo paramFileImgInfo)
  {
    TempSessionInfo localTempSessionInfo = null;
    if (paramMsg.msg_head.c2c_tmp_msg_head.has()) {
      localTempSessionInfo = MessageProtoCodec.a(paramMsg);
    }
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    short s1 = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if (!paramNotOnlineFile.bytes_file_name.has()) {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not fileName");
      }
    }
    int i3;
    long l3;
    String str1;
    String str2;
    Object localObject;
    label405:
    do
    {
      do
      {
        do
        {
          return;
          paramMsg = paramNotOnlineFile.bytes_file_name.get().toStringUtf8();
          i3 = paramNotOnlineFile.uint32_file_type.get();
          l3 = paramNotOnlineFile.uint64_file_size.get();
          i1 = paramNotOnlineFile.uint32_subcmd.get();
          str1 = HexUtil.a(paramNotOnlineFile.bytes_file_md5.get().toByteArray());
          str2 = String.valueOf(l4);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (i3 != 1) {
            break label405;
          }
          if ((!paramBoolean1) && (!str2.equalsIgnoreCase((String)localObject))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a file receipt file name: " + paramMsg + "don't need to handle because isPullRoam[" + paramBoolean2 + "],senderuin[" + str2 + "]");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a file receipt file name: " + paramMsg + "type[" + i3 + "]. insert tips into aio");
        }
        paramMessageHandler = TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramMsg, 0, null), l3, 0, false, null);
        l4 = MessageRecordFactory.a(63531).uniseq;
        a(paramList, paramString, str2, paramMsg, l3, paramBoolean1, 0, paramMessageHandler, s1, s1, "", i3, l4, l1, paramLong, l2, 62528, paramInt, paramFileImgInfo);
        return;
        if (paramNotOnlineFile.bytes_file_uuid.has()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not uuid");
      return;
      str2 = paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8();
      localObject = new String(paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8() + l2);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "offline file come, msgTime[" + l2 + "] msgSeq[" + s1 + "] msgUid[" + l1 + "]  fileName[" + paramMsg + "] uuid[" + str2 + "] fileType[" + i3 + "] subCmd[" + i1 + "]");
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "offline file come:fileName[" + paramMsg + "]");
      }
      if ((!paramMessageHandler.a().a((String)localObject)) || (paramBoolean2)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "isPullRoam[false] and local already recv.  fileName[" + paramMsg + "] uuid[" + str2 + "] fileType[" + i3 + "] subCmd[" + i1 + "]");
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("FileTransferHandler<FileAssistant>", 2, "offline file come:fileName[" + paramMsg + "] Filtered");
    return;
    int i1 = 0;
    if (paramNotOnlineFile.uint32_reserved.has())
    {
      int i2 = paramNotOnlineFile.uint32_reserved.get();
      i1 = i2;
      if (i2 == l4) {
        i1 = 0;
      }
    }
    if (i1 != 0) {
      ThreadManager.b(new rvw(this, paramString, i1, s1, l1, l2));
    }
    if ((paramBoolean2) && (paramBoolean1))
    {
      paramNotOnlineFile = a(0, paramString, String.valueOf(l4), l2, s1, l1);
      if (paramNotOnlineFile != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
        }
        if (i3 == 1)
        {
          paramMessageHandler = MessageRecordFactory.a(62528);
          paramMessageHandler.msgtype = 62528;
          paramMessageHandler.msg = paramNotOnlineFile.msg;
        }
        for (;;)
        {
          paramMessageHandler.uniseq = paramNotOnlineFile.uniseq;
          paramList.add(paramMessageHandler);
          return;
          paramMessageHandler = MessageRecordFactory.a(63531);
          paramMessageHandler.msgtype = 63531;
          paramMessageHandler.msg = paramNotOnlineFile.msg;
          ((MessageForFile)paramMessageHandler).parse();
        }
      }
    }
    paramNotOnlineFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b().iterator();
    while (paramNotOnlineFile.hasNext())
    {
      localObject = (FileManagerEntity)paramNotOnlineFile.next();
      if ((((FileManagerEntity)localObject).Uuid != null) && (((FileManagerEntity)localObject).Uuid.replace("/offline", "").equalsIgnoreCase(str2.replace("/offline", ""))))
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "uuid is compare memory!");
        return;
      }
    }
    if (l3 == 0L) {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "<---decodeC2CMsgPkg_MsgType0x211:fileType[" + i3 + "], UUID[" + str2 + "], filename[" + paramMsg + "], fileSize[" + l3 + "]");
    }
    a(paramMessageHandler, paramList, paramString, String.valueOf(l4), l2, s1, paramBoolean1, paramBoolean2, i3, str2, paramMsg, l3, i1, paramLong, l1, str1, localTempSessionInfo, paramInt, paramFileImgInfo);
  }
  
  public final void a(FileTransferObserver paramFileTransferObserver, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramFileTransferObserver != null)
    {
      Message localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = paramInt;
      localMessage.obj = new Object[] { paramFileTransferObserver, Boolean.valueOf(paramBoolean), paramObject };
      localMessage.sendToTarget();
      QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget .type=" + paramInt);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer .type=" + paramInt);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : PeerUin[" + FileManagerUtil.e(paramFileManagerEntity.peerUin) + "], FileUUID[" + paramFileManagerEntity.Uuid + "]");
    }
    Object localObject2 = new cmd0x346.ApplyForwardFileReq();
    ((cmd0x346.ApplyForwardFileReq)localObject2).uint64_sender_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    Object localObject1 = paramFileManagerEntity.peerUin.replace("+", "");
    ((cmd0x346.ApplyForwardFileReq)localObject2).uint64_recver_uin.set(Long.parseLong((String)localObject1));
    ((cmd0x346.ApplyForwardFileReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).msg_apply_forward_file_req.set((MessageMicro)localObject2);
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(700);
    localObject2 = ((cmd0x346.ReqBody)localObject1).uint32_seq;
    int i1 = q;
    q = i1 + 1;
    ((PBUInt32Field)localObject2).set(i1);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(3);
    ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      localObject2 = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject2).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject2).uint64_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        ((cmd0x346.ExtensionReq)localObject2).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        ((cmd0x346.ExtensionReq)localObject2).str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      ((cmd0x346.ReqBody)localObject1).msg_extension_req.set((MessageMicro)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
      }
    }
    paramFileManagerEntity = new rwe(this, false, paramFileManagerEntity.nSessionId);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", ((cmd0x346.ReqBody)localObject1).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramFileManagerEntity.fileSize);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    if ((paramFileManagerEntity.strFileMd5 != null) && (paramFileManagerEntity.strFileMd5.length() > 0)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramFileManagerEntity.strFileMd5.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.selfUin));
    Object localObject = paramFileManagerEntity.peerUin.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong((String)localObject));
    localSubCmd0x6ReqBody.str_file_name.set(paramFileManagerEntity.fileName);
    localSubCmd0x6ReqBody.str_src_file_path.set(paramFileManagerEntity.Uuid);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      if ((paramFileManagerEntity.tmpSessionRelatedUin != null) && (paramFileManagerEntity.tmpSessionRelatedUin.length() > 0)) {
        localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.tmpSessionRelatedUin));
      }
      localSubCmd0x6ReqBody.uint64_app_id.set(3L);
      localSubCmd0x6ReqBody.uint64_talk_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        localSubCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        localSubCmd0x6ReqBody.str_dst_phone_number.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardDiscFile : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
      }
    }
    for (;;)
    {
      localObject = new cmd0x345.ReqBody();
      ((cmd0x345.ReqBody)localObject).msg_subcmd_0x6_req_body.set(localSubCmd0x6ReqBody);
      ((cmd0x345.ReqBody)localObject).uint32_sub_cmd.set(7);
      paramFileManagerEntity = new rwe(this, false, paramFileManagerEntity.nSessionId, null, 7);
      a("GTalkFileAppSvr.CMD_DISCUSS_FILE", ((cmd0x345.ReqBody)localObject).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
      return;
      localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.selfUin));
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, FMConstants.revertMsgCallback paramrevertMsgCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileTransferHandler<FileAssistant>", 2, "revertC2CFile ");
    }
    Object localObject = new cmd0x346.RecallFileReq();
    ((cmd0x346.RecallFileReq)localObject).uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    ((cmd0x346.RecallFileReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    paramFileManagerEntity = new cmd0x346.ReqBody();
    paramFileManagerEntity.msg_recall_file_req.set((MessageMicro)localObject);
    paramFileManagerEntity.uint32_cmd.set(400);
    localObject = paramFileManagerEntity.uint32_seq;
    int i1 = q;
    q = i1 + 1;
    ((PBUInt32Field)localObject).set(i1);
    paramFileManagerEntity.uint32_business_id.set(3);
    paramFileManagerEntity.uint32_client_type.set(104);
    localObject = new rwe(this);
    rwe.a((rwe)localObject, paramrevertMsgCallback);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400", paramFileManagerEntity.toByteArray(), (rwe)localObject, 10000, 3, 1);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, String paramString3, FileTransferObserver paramFileTransferObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setUploadSuccState : selfUin[" + FileManagerUtil.e(paramString1) + "], toUin[" + FileManagerUtil.e(paramString2) + "], filePath[" + paramString3 + "]");
    }
    cmd0x346.UploadSuccReq localUploadSuccReq = new cmd0x346.UploadSuccReq();
    localUploadSuccReq.uint64_sender_uin.set(Long.parseLong(paramString1));
    paramString1 = paramString2.replace("+", "");
    localUploadSuccReq.uint64_recver_uin.set(Long.parseLong(paramString1));
    localUploadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_upload_succ_req.set(localUploadSuccReq);
    paramString1.uint32_cmd.set(800);
    paramString2 = paramString1.uint32_seq;
    int i1 = q;
    q = i1 + 1;
    paramString2.set(i1);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      paramString2 = new cmd0x346.ExtensionReq();
      paramString2.uint64_id.set(3L);
      paramString2.uint64_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        paramString2.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        paramString2.str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      paramString1.msg_extension_req.set(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
      }
    }
    paramFileManagerEntity = new rwe(this, paramFileTransferObserver);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramString1.toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void a(OfflineFileUploadPara paramOfflineFileUploadPara, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    Cmd0x346CSBody localCmd0x346CSBody = a(paramOfflineFileUploadPara);
    a(1L, paramOfflineFileUploadPara.jdField_a_of_type_Int, localCmd0x346CSBody, paramFileTransferObserver, paramFileManagerEntity);
  }
  
  public final void a(ToServiceMsg arg1, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (???.extraData.containsKey(p))
    {
      long l1 = ???.extraData.getLong(p);
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        FileTransferObserver localFileTransferObserver = (FileTransferObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l1));
        if (localFileTransferObserver != null)
        {
          ??? = jdField_a_of_type_AndroidOsHandler.obtainMessage();
          ???.what = paramInt;
          ???.obj = new Object[] { localFileTransferObserver, Boolean.valueOf(paramBoolean), paramObject };
          ???.sendToTarget();
          QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget. seq=" + l1 + ".type=" + paramInt);
          return;
        }
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer. seq=" + l1 + ".type=" + paramInt);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find seq_key. type=" + paramInt);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "handleResponse : req is null");
      }
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      float f1 = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f1) + "sec.");
      }
    }
    if (paramToServiceMsg.getServiceCmd().equals("TransService.ReqOffFilePack"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, (MessageFactoryReceiver.OffLineFileInfo)a(paramToServiceMsg, paramFromServiceMsg));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResponse : cmd " + paramToServiceMsg.getServiceCmd().hashCode() + "unknow");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    boolean bool = true;
    long l2 = paramFromServiceMsg.getResultCode();
    if (l2 != 1002L)
    {
      l1 = l2;
      if (l2 != 1013L) {}
    }
    else
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is timeout[" + paramFromServiceMsg + "]");
    }
    l2 = l1;
    if (l1 != 1000L)
    {
      l2 = -100002L;
      bool = false;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is failed[" + paramFromServiceMsg + "]");
    }
    if (l2 == -100001L) {}
    for (int i1 = 1;; i1 = 0)
    {
      int i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((i1 == 0) || (i2 >= 3)) {
        break;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i2 + 1);
      return;
    }
    long l1 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    if ((l1 != 0L) && (l1 != 241L)) {
      bool = false;
    }
    for (;;)
    {
      a(paramToServiceMsg, 5014, bool, new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Integer.valueOf(paramFromServiceMsg.getAppSeq()), Long.valueOf(paramLong) });
      return;
      l1 = l2;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = (MessageFactoryReceiver.OffLineFileInfo)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + ((MessageFactoryReceiver.OffLineFileInfo)paramObject).jdField_b_of_type_Byte);
    }
    switch (((MessageFactoryReceiver.OffLineFileInfo)paramObject).jdField_b_of_type_Byte)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 1: 
      c(paramToServiceMsg, paramFromServiceMsg, (MessageFactoryReceiver.OffLineFileInfo)paramObject);
      return;
    case 2: 
      d(paramToServiceMsg, paramFromServiceMsg, (MessageFactoryReceiver.OffLineFileInfo)paramObject);
      return;
    case 3: 
      a(paramToServiceMsg, paramFromServiceMsg, (MessageFactoryReceiver.OffLineFileInfo)paramObject);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, (MessageFactoryReceiver.OffLineFileInfo)paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + paramString + "]");
    }
    Object localObject = new cmd0x346.ApplyDownloadAbsReq();
    ((cmd0x346.ApplyDownloadAbsReq)localObject).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((cmd0x346.ApplyDownloadAbsReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    paramString = new cmd0x346.ReqBody();
    paramString.msg_apply_download_abs_req.set((MessageMicro)localObject);
    paramString.uint32_cmd.set(1100);
    localObject = paramString.uint32_seq;
    int i1 = q;
    q = i1 + 1;
    ((PBUInt32Field)localObject).set(i1);
    paramString.uint32_business_id.set(3);
    paramString.uint32_client_type.set(104);
    localObject = new rwe(this);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", paramString.toByteArray(), (rwe)localObject, 30000, 3, 1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      long l1 = paramInt1;
      new Handler(localLooper).post(new rwc(this, l1, paramInt3, paramInt2, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramInt1 + "] Handle upload progress notify. speed=" + paramInt3 + " progress =" + paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramInt3, paramInt2);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      long l1 = paramInt1;
      new Handler(localLooper).post(new rwb(this, l1, paramInt2, paramString2, paramString1));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramInt1 + "] Handle upload failed notify. retCode =" + paramInt2 + "(1:cancel upload) reason=" + paramString2);
    if (1 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1);
      return;
    }
    if (2 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1);
      return;
    }
    if (3 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString1, paramInt1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getOfflineVideoThumbInfo : FileUUID[" + paramString + "]");
    }
    Object localObject = new cmd0x346.ApplyDownloadAbsReq();
    ((cmd0x346.ApplyDownloadAbsReq)localObject).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((cmd0x346.ApplyDownloadAbsReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    paramString = new cmd0x346.ReqBody();
    paramString.msg_apply_download_abs_req.set((MessageMicro)localObject);
    paramString.uint32_cmd.set(1100);
    localObject = paramString.uint32_seq;
    int i1 = q;
    q = i1 + 1;
    ((PBUInt32Field)localObject).set(i1);
    paramString.uint32_business_id.set(3);
    paramString.uint32_client_type.set(104);
    localObject = new rwe(this, true, paramLong);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", paramString.toByteArray(), (rwe)localObject, 30000, 3, 1);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new rvu(this, paramLong1, paramString1, paramInt, paramString2, paramLong2));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "] upload competed:");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramLong1, paramInt, paramString2, paramLong2);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new rvz(this, paramLong, paramBoolean, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle recv onlinefile resp. sucess =" + paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + paramString2 + "]");
    }
    cmd0x345.ReqBody.SubCmd0x7ReqBody localSubCmd0x7ReqBody = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
    localSubCmd0x7ReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
    localSubCmd0x7ReqBody.str_file_path.set(paramString2);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x7_req_body.set(localSubCmd0x7ReqBody);
    paramString1.uint32_sub_cmd.set(8);
    paramString2 = new rwe(this, false, 0L, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getDiscVideoThumbInfo : FileUUID[" + paramString2 + "]");
    }
    cmd0x345.ReqBody.SubCmd0x7ReqBody localSubCmd0x7ReqBody = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
    localSubCmd0x7ReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
    localSubCmd0x7ReqBody.str_file_path.set(paramString2);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x7_req_body.set(localSubCmd0x7ReqBody);
    paramString1.uint32_sub_cmd.set(8);
    paramString2 = new rwe(this, true, paramLong, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, FileTransferObserver paramFileTransferObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setDownloadSuccState : selfUin[" + FileManagerUtil.e(paramString1) + "], filePath[" + paramString2 + "]");
    }
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(paramString1));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_download_succ_req.set(localDownloadSuccReq);
    paramString1.uint32_cmd.set(1000);
    paramString2 = paramString1.uint32_seq;
    int i1 = q;
    q = i1 + 1;
    paramString2.set(i1);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    paramString2 = new rwe(this, paramFileTransferObserver);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, BuddyTransfileProcessor.A9Message paramA9Message, long paramLong1, short paramShort, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "--->>getOffLineFile--toUin: " + paramString2 + " filePath: " + paramA9Message.jdField_a_of_type_JavaLangString + " delUin: " + paramLong2);
    }
    ToServiceMsg localToServiceMsg = a("TransService.ReqOffFilePack");
    localToServiceMsg.extraData.putString("selfuin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("uin", paramString2);
    localToServiceMsg.extraData.putByteArray("filepath", paramA9Message.jdField_a_of_type_JavaLangString.getBytes());
    localToServiceMsg.extraData.putInt("offfile_type", 0);
    localToServiceMsg.extraData.putLong("msgTime", paramLong1);
    localToServiceMsg.extraData.putShort("msgSeq", paramShort);
    localToServiceMsg.extraData.putLong("delUin", paramLong2);
    localToServiceMsg.extraData.putByte("type", paramA9Message.jdField_a_of_type_Byte);
    localToServiceMsg.extraData.putInt("retryIndex", 0);
    localToServiceMsg.extraData.putString("friendUin", paramString1);
    localToServiceMsg.extraData.putBoolean("isRead", paramBoolean);
    b(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, FileTransferObserver paramFileTransferObserver)
  {
    cmd0x345.ReqBody.SubCmd0x1ReqBody localSubCmd0x1ReqBody = new cmd0x345.ReqBody.SubCmd0x1ReqBody();
    localSubCmd0x1ReqBody.str_md5.set(paramString1);
    localSubCmd0x1ReqBody.str_sha.set(paramString2);
    localSubCmd0x1ReqBody.str_file_name.set(paramString3);
    localSubCmd0x1ReqBody.uint64_file_size.set(paramLong);
    localSubCmd0x1ReqBody.uint32_upload_type.set(1);
    paramLong = Long.parseLong(paramString4);
    localSubCmd0x1ReqBody.uint32_disscus_uin.set((int)paramLong);
    paramLong = Long.parseLong(paramString5);
    localSubCmd0x1ReqBody.uint32_sender_uin.set((int)paramLong);
    localSubCmd0x1ReqBody.uint32_costom_id.set(0);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x1_req_body.set(localSubCmd0x1ReqBody);
    paramString1.uint32_sub_cmd.set(1);
    paramString2 = new rwe(this, false, 0L, paramFileTransferObserver, 1);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, FMConstants.revertMsgCallback paramrevertMsgCallback)
  {
    cmd0x345.ReqBody.SubCmd0xaReqBody localSubCmd0xaReqBody = new cmd0x345.ReqBody.SubCmd0xaReqBody();
    try
    {
      localSubCmd0xaReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
      localSubCmd0xaReqBody.uint64_uin.set(Long.parseLong(paramString2));
      localSubCmd0xaReqBody.str_file_id.set(paramString3);
      paramString1 = new cmd0x345.ReqBody();
      paramString1.msg_subcmd_0xa_req_body.set(localSubCmd0xaReqBody);
      paramString1.uint32_sub_cmd.set(10);
      paramString2 = new rwe(this);
      rwe.a(paramString2, 10);
      rwe.a(paramString2, paramrevertMsgCallback);
      a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramrevertMsgCallback.a(-1, paramString1.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "RemoveOfflineFile : PeerUin[" + FileManagerUtil.e(paramString1) + "], FileUUID[" + paramString2 + "], bSend[" + paramBoolean + "]");
    }
    if (paramBoolean) {
      i1 = 1;
    }
    paramString3 = new cmd0x346.DeleteFileReq();
    paramString3.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    paramString3.uint64_peer_uin.set(Long.parseLong(paramString1));
    paramString3.uint32_delete_type.set(i1);
    paramString3.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_delete_file_req.set(paramString3);
    paramString1.uint32_cmd.set(900);
    paramString3 = paramString1.uint32_seq;
    i1 = q;
    q = i1 + 1;
    paramString3.set(i1);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    paramString2 = new rwe(this, paramString2);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString, boolean paramBoolean, FileTransferObserver paramFileTransferObserver)
  {
    Object localObject = new cmd0x346.ApplyDownloadReq();
    ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 2)
    {
      ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type.set(i1);
      paramString = new cmd0x346.ReqBody();
      paramString.msg_apply_download_req.set((MessageMicro)localObject);
      paramString.uint32_cmd.set(1200);
      localObject = paramString.uint32_seq;
      i1 = q;
      q = i1 + 1;
      ((PBUInt32Field)localObject).set(i1);
      paramString.uint32_business_id.set(3);
      paramString.uint32_client_type.set(104);
      localObject = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject).uint32_download_url_type.set(1);
      paramString.msg_extension_req.set((MessageMicro)localObject);
      paramFileTransferObserver = new rwe(this, paramFileTransferObserver);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString.toByteArray(), paramFileTransferObserver);
      return;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, rwe paramrwe)
  {
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = paramString;
    localProtoReq.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localProtoReq.jdField_a_of_type_JavaLangObject = paramrwe;
    a(localProtoReq);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, rwe paramrwe, int paramInt1, int paramInt2, int paramInt3)
  {
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = paramString;
    localProtoReq.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localProtoReq.jdField_a_of_type_JavaLangObject = paramrwe;
    localProtoReq.jdField_a_of_type_Int = paramInt1;
    localProtoReq.jdField_b_of_type_Int = paramInt2;
    localProtoReq.jdField_c_of_type_Int = paramInt3;
    a(localProtoReq);
  }
  
  public boolean a(OnlineFileSessionInfo paramOnlineFileSessionInfo)
  {
    if (paramOnlineFileSessionInfo != null)
    {
      if ((jdField_a_of_type_ArrayOfByte.equals(paramOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte)) || (!paramOnlineFileSessionInfo.jdField_b_of_type_Boolean)) {
        QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "]  is not surpport mulitendpoint");
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    paramFMTransC2CMsgInfo.subCmd = paramInt2;
    if (paramFMTransC2CMsgInfo.fileTransferObserver != null) {}
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramFMTransC2CMsgInfo.observerSeq = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_a_of_type_Long), paramFMTransC2CMsgInfo.fileTransferObserver);
      this.jdField_a_of_type_Long += 1L;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "send0x211c2cMsg transC2CMsgInfo:" + paramFMTransC2CMsgInfo.toString());
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, paramInt1, paramArrayOfByte, paramFMTransC2CMsgInfo);
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    OnlineFileSessionInfo localOnlineFileSessionInfo = new OnlineFileSessionInfo();
    localOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte = ((byte[])jdField_a_of_type_ArrayOfByte.clone());
    localOnlineFileSessionInfo.jdField_a_of_type_Short = 4;
    localOnlineFileSessionInfo.jdField_b_of_type_Long = paramLong;
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localOnlineFileSessionInfo);
    if (arrayOfByte == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + localOnlineFileSessionInfo.jdField_b_of_type_Long + "]. recvOnLineFile failed:");
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, paramLong, 133, arrayOfByte);
  }
  
  public boolean a(String paramString, FileManagerEntity paramFileManagerEntity, FileTransferObserver paramFileTransferObserver)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, 0, paramFileManagerEntity.uniseq);
    if (localObject1 != null)
    {
      paramFileManagerEntity.msgSeq = ((MessageRecord)localObject1).msgseq;
      paramFileManagerEntity.msgUid = ((MessageRecord)localObject1).msgUid;
    }
    localObject1 = new SubMsgType0x4.MsgBody();
    Object localObject2 = new im_msg_body.NotOnlineFile();
    ((im_msg_body.NotOnlineFile)localObject2).uint32_file_type.set(0);
    ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.set(paramFileManagerEntity.fileSize);
    ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.set(ByteStringMicro.copyFrom(paramFileManagerEntity.fileName.getBytes()));
    ((im_msg_body.NotOnlineFile)localObject2).uint32_subcmd.set(1);
    ((SubMsgType0x4.MsgBody)localObject1).msg_not_online_file.set((MessageMicro)localObject2);
    if (paramFileManagerEntity.nFileType == 0)
    {
      if (!FileUtil.b(paramFileManagerEntity.getFilePath())) {
        break label363;
      }
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramFileManagerEntity.getFilePath(), (BitmapFactory.Options)localObject2);
      int i2 = ((BitmapFactory.Options)localObject2).outWidth;
      int i1 = ((BitmapFactory.Options)localObject2).outHeight;
      int i3 = URLDrawableHelper.a(paramFileManagerEntity.getFilePath());
      if ((i3 == 90) || (i3 == 270))
      {
        i2 = ((BitmapFactory.Options)localObject2).outHeight;
        i1 = ((BitmapFactory.Options)localObject2).outWidth;
      }
      localObject2 = new hummer_resv_21.FileImgInfo();
      ((hummer_resv_21.FileImgInfo)localObject2).uint32_file_height.set(i1);
      ((hummer_resv_21.FileImgInfo)localObject2).uint32_file_width.set(i2);
      ((SubMsgType0x4.MsgBody)localObject1).file_image_info.set((MessageMicro)localObject2);
    }
    for (;;)
    {
      localObject1 = ((SubMsgType0x4.MsgBody)localObject1).toByteArray();
      localObject2 = new FMTransC2CMsgInfo();
      ((FMTransC2CMsgInfo)localObject2).busiType = 1028;
      ((FMTransC2CMsgInfo)localObject2).uuid = paramFileManagerEntity.Uuid;
      ((FMTransC2CMsgInfo)localObject2).uniseq = paramFileManagerEntity.uniseq;
      ((FMTransC2CMsgInfo)localObject2).fileTransferObserver = paramFileTransferObserver;
      ((FMTransC2CMsgInfo)localObject2).msgSeq = paramFileManagerEntity.msgSeq;
      ((FMTransC2CMsgInfo)localObject2).msgUid = paramFileManagerEntity.msgUid;
      ((FMTransC2CMsgInfo)localObject2).sessionId = paramFileManagerEntity.nSessionId;
      ((FMTransC2CMsgInfo)localObject2).entity = paramFileManagerEntity;
      return a(paramString, 529, 4, (byte[])localObject1, (FMTransC2CMsgInfo)localObject2);
      label363:
      localObject2 = new hummer_resv_21.FileImgInfo();
      ((hummer_resv_21.FileImgInfo)localObject2).uint32_file_height.set(paramFileManagerEntity.imgHeight);
      ((hummer_resv_21.FileImgInfo)localObject2).uint32_file_width.set(paramFileManagerEntity.imgWidth);
      ((SubMsgType0x4.MsgBody)localObject1).file_image_info.set((MessageMicro)localObject2);
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    Object localObject = new SubMsgType0x4.MsgBody();
    im_msg_body.NotOnlineFile localNotOnlineFile = new im_msg_body.NotOnlineFile();
    localNotOnlineFile.uint32_file_type.set(1);
    localNotOnlineFile.bytes_file_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    localNotOnlineFile.uint64_file_size.set(paramLong1);
    localNotOnlineFile.bytes_file_name.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localNotOnlineFile.uint32_subcmd.set(2);
    ((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.set(localNotOnlineFile);
    paramString2 = ((SubMsgType0x4.MsgBody)localObject).toByteArray();
    localObject = new FMTransC2CMsgInfo();
    ((FMTransC2CMsgInfo)localObject).busiType = 1029;
    ((FMTransC2CMsgInfo)localObject).uuid = paramString3;
    ((FMTransC2CMsgInfo)localObject).msgSeq = FileManagerUtil.a();
    ((FMTransC2CMsgInfo)localObject).msgUid = FileManagerUtil.b();
    return a(paramString1, 529, 4, paramString2, (FMTransC2CMsgInfo)localObject);
  }
  
  public byte[] a(OnlineFileSessionInfo paramOnlineFileSessionInfo)
  {
    if (paramOnlineFileSessionInfo == null) {
      return null;
    }
    byte[] arrayOfByte = new byte['Ѐ'];
    PkgTools.a(arrayOfByte, 0, paramOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte, 16);
    PkgTools.a(arrayOfByte, 22, paramOnlineFileSessionInfo.jdField_b_of_type_Long);
    PkgTools.a(arrayOfByte, 28, paramOnlineFileSessionInfo.jdField_a_of_type_Short);
    PkgTools.a(arrayOfByte, 30, (short)1);
    arrayOfByte[32] = 1;
    PkgTools.a(arrayOfByte, 35, (short)11);
    arrayOfByte[37] = 15;
    PkgTools.a(arrayOfByte, 38, (short)1);
    arrayOfByte[40] = 1;
    arrayOfByte[41] = 16;
    PkgTools.a(arrayOfByte, 42, (short)4);
    PkgTools.a(arrayOfByte, 44, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramOnlineFileSessionInfo = new byte[48];
    PkgTools.a(paramOnlineFileSessionInfo, 0, arrayOfByte, 48);
    return paramOnlineFileSessionInfo;
  }
  
  public OnlineFileSessionInfo b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed context=null");
      return null;
    }
    int i1 = paramArrayOfByte.length;
    OnlineFileSessionInfo localOnlineFileSessionInfo = new OnlineFileSessionInfo();
    int i2;
    int i3;
    if (i1 >= 16)
    {
      PkgTools.b(paramArrayOfByte, 0, localOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte, 16);
      if (i1 < 26) {
        break label172;
      }
      localOnlineFileSessionInfo.jdField_b_of_type_Long = PkgTools.a(paramArrayOfByte, 22);
      if (i1 < 30) {
        break label183;
      }
      localOnlineFileSessionInfo.jdField_a_of_type_Short = PkgTools.a(paramArrayOfByte, 28);
      if (i1 < 32) {
        break label194;
      }
      i2 = PkgTools.a(paramArrayOfByte, 30);
      if (i2 >= 2)
      {
        if (i1 < 34) {
          break label205;
        }
        localOnlineFileSessionInfo.jdField_b_of_type_Short = PkgTools.a(paramArrayOfByte, 32);
      }
      i3 = i2 + 32 + 2;
      if (i1 < i3 + 2) {
        break label216;
      }
      i2 = PkgTools.a(paramArrayOfByte, i3);
      if (i2 >= 4) {
        break label227;
      }
      localOnlineFileSessionInfo.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      return localOnlineFileSessionInfo;
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufAppGUID");
      return null;
      label172:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - dwSessionId");
      return null;
      label183:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wCancelType");
      return null;
      label194:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wReasonLen");
      return null;
      label205:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufReason");
      return null;
      label216:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wContextDataLen");
      return null;
      label227:
      byte[] arrayOfByte = new byte[i2];
      PkgTools.b(paramArrayOfByte, i3 + 2, arrayOfByte, i2);
      i1 = 0;
      label246:
      int i4;
      if (i1 < i2)
      {
        i3 = arrayOfByte[i1];
        i4 = i1 + 1;
        if (i2 <= i4 + 2) {
          break label316;
        }
        i1 = PkgTools.a(arrayOfByte, i4);
        i4 += 2;
        if (i3 != 15) {
          break label377;
        }
        if (i1 == 1) {
          break label328;
        }
        localOnlineFileSessionInfo.jdField_b_of_type_Boolean = false;
      }
      for (;;)
      {
        i1 = i4 + i1;
        break label246;
        break;
        label316:
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode Cancel or accept tlv error - L");
        break;
        label328:
        if (i2 >= i4 + i1)
        {
          paramArrayOfByte = new byte[i1];
          PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
          if (paramArrayOfByte[0] == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localOnlineFileSessionInfo.jdField_b_of_type_Boolean = bool;
            break;
          }
          label377:
          if (i3 == 4)
          {
            paramArrayOfByte = new byte[i1];
            if (i2 < i4 + i1) {
              break label436;
            }
            PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
            paramArrayOfByte = a(paramArrayOfByte);
            if (paramArrayOfByte == null) {
              break label448;
            }
            localOnlineFileSessionInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte.jdField_a_of_type_JavaLangString;
            localOnlineFileSessionInfo.jdField_a_of_type_Long = paramArrayOfByte.jdField_a_of_type_Long;
          }
        }
      }
      label436:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
    }
    label448:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode fileinfo error for request or accept");
    return null;
  }
  
  public void b()
  {
    Object localObject1;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("wifiphoto_smart_reminder", 0);
      l1 = ((SharedPreferences)localObject1).getLong("wifiphoto_smart_reminder_last_time", 0L);
      l2 = MessageCache.a();
      if (l2 - l1 > 86400L)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putLong("wifiphoto_smart_reminder_last_time", l2);
        ((SharedPreferences.Editor)localObject1).commit();
        boolean bool = SystemUtil.a();
        l1 = SystemUtil.a();
        l2 = SystemUtil.b();
        if ((!bool) || (l1 == 0L)) {
          break label674;
        }
        l1 = Math.min(l1, l2) * 1024L;
      }
    }
    for (;;)
    {
      l2 = FileCategoryUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      if ((l1 <= 1073741824L) && (l2 >= 50L)) {
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("freeSize", l1);
        ((JSONObject)localObject1).put("deviceType", 2);
        ((JSONObject)localObject1).put("subtype", "8");
        ((JSONObject)localObject1).put("photoCount", l2);
        Object localObject2 = new SubMsgType0x7.MsgBody.GenericSubCmd();
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint64_sessionid.set(1L);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_size.set(1);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_index.set(0);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_type.set(5);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).bytes_buf.set(ByteStringMicro.copyFrom(((JSONObject)localObject1).toString().getBytes()));
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).setHasFlag(true);
        localObject1 = new SubMsgType0x7.MsgBody();
        ((SubMsgType0x7.MsgBody)localObject1).uint32_sub_cmd.set(4);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_src_app_id.set(1001);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_src_inst_id.set(AppSetting.jdField_a_of_type_Int);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_dst_app_id.set(1);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_dst_inst_id.set(1);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint64_dst_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint64_src_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.setHasFlag(true);
        ((SubMsgType0x7.MsgBody)localObject1).msg_subcmd_0x4_generic.set((MessageMicro)localObject2);
        ((SubMsgType0x7.MsgBody)localObject1).setHasFlag(true);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        Object localObject3 = ((SubMsgType0x7.MsgBody)localObject1).toByteArray();
        localObject1 = a("MessageSvc.PbSendMsg");
        ((ToServiceMsg)localObject1).extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
        ((ToServiceMsg)localObject1).extraData.putInt("ROUNTING_TYPE", 13);
        ((ToServiceMsg)localObject1).extraData.putBoolean("ISFROM_DATALINE", true);
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_CMD", 1002);
        ((ToServiceMsg)localObject1).addAttribute("cookie", Integer.valueOf(1));
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
        l1 = FileManagerUtil.b();
        l2 = FileManagerUtil.a();
        TransMsgContext localTransMsgContext = new TransMsgContext();
        localTransMsgContext.jdField_a_of_type_Int = 7;
        localTransMsgContext.jdField_a_of_type_ArrayOfByte = ((byte[])localObject3);
        localObject2 = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 13, (String)localObject2, localTransMsgContext, l2, MessageUtils.b(l1));
        localObject3 = new im_msg_head.InstInfo();
        ((im_msg_head.InstInfo)localObject3).uint32_apppid.set(1);
        ((im_msg_head.InstInfo)localObject3).uint32_instid.set(1);
        ((im_msg_head.InstInfo)localObject3).setHasFlag(true);
        ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add((MessageMicro)localObject3);
        localObject3 = new im_msg_head.InstInfo();
        ((im_msg_head.InstInfo)localObject3).uint32_apppid.set(1001);
        ((im_msg_head.InstInfo)localObject3).uint32_instid.set(AppSetting.jdField_a_of_type_Int);
        ((im_msg_head.InstInfo)localObject3).setHasFlag(true);
        ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.msg_from_inst = ((im_msg_head.InstInfo)localObject3);
        ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
        ((ToServiceMsg)localObject1).putWupBuffer(((msg_svc.PbSendMsgReq)localObject2).toByteArray());
        if (localObject1 != null)
        {
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((ToServiceMsg)localObject1);
        }
        return;
        label674:
        l1 = 1024L * l2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void b(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, OnlineFileSessionInfo paramOnlineFileSessionInfo, long paramLong2, int paramInt3)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new rvx(this, paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramOnlineFileSessionInfo, paramLong2, paramInt3));
      return;
    }
    a(paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramOnlineFileSessionInfo, paramLong2, paramInt3);
  }
  
  public void b(OfflineFileUploadPara paramOfflineFileUploadPara, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    a(1L, 1800, b(paramOfflineFileUploadPara), paramFileTransferObserver, paramFileManagerEntity);
  }
  
  public void b(String paramString, long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new rvy(this, paramLong, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle cmd 0x211-0x1.save to weiyun");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong, 4);
  }
  
  public void b(String paramString, long paramLong, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new rwa(this, paramLong, paramBoolean, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle query onlinefile upload progress resp. sucess =" + paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramLong, paramBoolean);
  }
  
  public boolean b(String paramString, long paramLong)
  {
    Object localObject = new SubMsgType0x5.MsgBody();
    ((SubMsgType0x5.MsgBody)localObject).uint32_sessionid.set((int)paramLong);
    localObject = ((SubMsgType0x5.MsgBody)localObject).toByteArray();
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.sessionId = paramLong;
    localFMTransC2CMsgInfo.busiType = 1025;
    localFMTransC2CMsgInfo.msgSeq = FileManagerUtil.a();
    localFMTransC2CMsgInfo.msgUid = FileManagerUtil.b();
    localFMTransC2CMsgInfo.entity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    return a(paramString, 529, 5, (byte[])localObject, localFMTransC2CMsgInfo);
  }
  
  public byte[] b(OnlineFileSessionInfo paramOnlineFileSessionInfo)
  {
    if (paramOnlineFileSessionInfo == null) {
      return null;
    }
    byte[] arrayOfByte = new byte['Ѐ'];
    PkgTools.a(arrayOfByte, 0, paramOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte, 16);
    PkgTools.a(arrayOfByte, 22, paramOnlineFileSessionInfo.jdField_b_of_type_Long);
    PkgTools.a(arrayOfByte, 26, (short)112);
    PkgTools.a(arrayOfByte, 28, (short)0);
    paramOnlineFileSessionInfo = new byte[30];
    PkgTools.a(paramOnlineFileSessionInfo, 0, arrayOfByte, 30);
    return paramOnlineFileSessionInfo;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\filemanager\app\FileTransferHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */