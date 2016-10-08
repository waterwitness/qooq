package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.Pair;
import com.dataline.core.DirectForwarder;
import com.dataline.core.MoloHandler;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.QualityReportUtil;
import com.dataline.util.file.FileUtil;
import com.dataline.util.file.MediaStoreUtil;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.FTNNotify;
import com.tencent.litetransfersdk.FileControl;
import com.tencent.litetransfersdk.LiteTransferListenerCallback;
import com.tencent.litetransfersdk.LiteTransferOperatorCallback;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x211;
import com.tencent.litetransfersdk.MsgCSBody0x211_0x7;
import com.tencent.litetransfersdk.MsgCSBody0x345;
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.litetransfersdk.MsgSCBody0x211;
import com.tencent.litetransfersdk.MsgSCBody0x211_0x7;
import com.tencent.litetransfersdk.MsgSCBody0x345;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.NFCNotify;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.RFCInfoNotify;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.litetransfersdk.Session;
import com.tencent.litetransfersdk.SubCmd0x6ReqBody;
import com.tencent.litetransfersdk.SubCmd0x6RspBody;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.TextMsgPush;
import com.tencent.mobileqq.service.TextMsgTask;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import pwg;
import pwh;
import pwi;
import pwj;
import pwk;
import pwl;
import pwm;
import pwn;
import pwo;
import pwp;
import pwq;
import pwr;
import pws;
import pwt;
import pwu;
import pwv;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MoloNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class DataLineHandler
  extends BusinessHandler
  implements LiteTransferListenerCallback, LiteTransferOperatorCallback
{
  public static final int A = 16;
  public static final int B = 17;
  public static final int C = 18;
  public static final int D = 2;
  public static final int H = 10;
  public static final int I = 14;
  public static final int J = 19;
  public static final int K = 1001;
  public static final int L = 1003;
  public static final int M = 1004;
  public static final int N = 1005;
  public static final int O = 1006;
  public static final int P = 1007;
  public static final int Q = 1008;
  public static final int R = 0;
  public static final int S = 1;
  public static final int U = 2;
  public static final int V = 3;
  public static final int W = 1021;
  public static final int X = 1022;
  public static final int Y = 1023;
  public static final int Z = 0;
  public static final int a = 0;
  public static final String a = "DataLineHandler";
  public static final int aa = 1;
  public static final int ab = 2;
  public static final int ac = 3;
  public static final int ae = 38;
  public static final int af = 3;
  public static final int ag = 106;
  private static int ah = 0;
  private static final int ai = 38;
  private static final int aj = 104;
  private static int ak = 0;
  private static final int al = 1400;
  public static final int b = 1;
  public static final int c = 2;
  private static final String jdField_c_of_type_JavaLangString = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
  public static final int d = 3;
  private static final String jdField_d_of_type_JavaLangString = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
  public static final int e = 4;
  private static final String e = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
  public static final int f = 5;
  private static final String f = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200";
  public static final int g = 255;
  private static final String g = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400";
  public static final int h = 0;
  private static final String h = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100";
  public static final int i = 1;
  private static final String i = "GTalkFileAppSvr.CMD_DISCUSS_FILE";
  public static final int j = 2;
  private static final String j = "datalineSendTimekey";
  public static final int k = 3;
  public static final int l = 50;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 4;
  public static final int q = 5;
  public static final int r = 6;
  public static final int s = 7;
  public static final int t = 8;
  public static final int u = 9;
  public static final int v = 10;
  public static final int w = 11;
  public static final int x = 12;
  public static final int y = 14;
  public static final int z = 15;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private DirectForwarder jdField_a_of_type_ComDatalineCoreDirectForwarder;
  private MoloHandler jdField_a_of_type_ComDatalineCoreMoloHandler;
  public LiteTransferWrapper a;
  public ProtocolHelper a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  public PrinterHandler a;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private DatalineRemoteManager jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  protected HashMap a;
  private List jdField_a_of_type_JavaUtilList;
  private Timer jdField_a_of_type_JavaUtilTimer;
  public boolean a;
  public int ad;
  private int am;
  private int an;
  private long jdField_b_of_type_Long;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  public String b;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private List jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  
  DataLineHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaLangString = AppConstants.aj;
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper = new LiteTransferWrapper(this, this);
    this.jdField_a_of_type_ComDatalineCoreMoloHandler = new MoloHandler(this);
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Long = -1L;
    this.d = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new pwv(this);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler = new PrinterHandler(paramQQAppInterface);
    this.jdField_a_of_type_ComDatalineCoreDirectForwarder = new DirectForwarder(paramQQAppInterface);
    this.am = BaseApplication.getContext().getResources().getDimensionPixelSize(2131492890);
    this.an = BaseApplication.getContext().getResources().getDimensionPixelSize(2131492891);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new pwg(this);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new pwo(this, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new pwp(this);
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper = new ProtocolHelper(paramQQAppInterface, 0);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + paramQQAppInterface.a().getPackageName());
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    paramQQAppInterface.a().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addDataScheme("file");
    paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager = new DatalineRemoteManager(paramQQAppInterface);
    i();
    j();
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int i2 = 255;
    if (paramFileManagerEntity == null)
    {
      QLog.i("DataLineHandler", 2, "转发文件, FileManagerEntity为空");
      return i2;
    }
    int i1;
    if ((!TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) && (new File(paramFileManagerEntity.getFilePath()).exists())) {
      i1 = 0;
    }
    for (;;)
    {
      i2 = i1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("DataLineHandler", 4, "是否可以转发到数据线, [" + paramFileManagerEntity.peerType + "]， name[" + paramFileManagerEntity.fileName + "], LocalPath[" + paramFileManagerEntity.getFilePath() + "], FileSize[" + paramFileManagerEntity.fileSize + "], fileFrom[" + i1 + "], peerType[" + paramFileManagerEntity.peerType + "], peerUin[" + paramFileManagerEntity.peerUin + "], cloudType[" + paramFileManagerEntity.getCloudType());
      return i1;
      i1 = i2;
      switch (paramFileManagerEntity.getCloudType())
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.e("dataline", 2, "FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[" + paramFileManagerEntity.getCloudType());
          i1 = i2;
        }
        break;
      case 1: 
        switch (paramFileManagerEntity.peerType)
        {
        default: 
          if (QLog.isColorLevel())
          {
            QLog.i("DataLineHandler", 2, "转发文件, 未知的文件来源默认为C2C, peerType[" + paramFileManagerEntity.peerType + "]， name[" + paramFileManagerEntity.fileName + "], LocalPath[" + paramFileManagerEntity.getFilePath() + "], FileSize[" + paramFileManagerEntity.fileSize + "], fileFrom[" + 1 + "], peerUin[" + paramFileManagerEntity.peerUin + "], cloudType[" + paramFileManagerEntity.getCloudType());
            i1 = 1;
          }
          break;
        case 0: 
          i1 = 1;
          break;
        case 3000: 
          i1 = 3;
          break;
        case 1: 
          i1 = 2;
          break;
        case 6000: 
          i1 = 5;
        }
        break;
      case 2: 
        i1 = 4;
        break;
      case 4: 
        i1 = 2;
        continue;
        i1 = 1;
      }
    }
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    switch (FileManagerUtil.a(paramString))
    {
    default: 
      if (!paramBoolean) {
        break;
      }
    case 0: 
      return 1;
    case 1: 
      return 3;
    case 2: 
      return 2;
    }
    return 0;
  }
  
  private ToServiceMsg a(boolean paramBoolean, long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2, int paramInt4)
  {
    ToServiceMsg localToServiceMsg = a("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
    localToServiceMsg.extraData.putInt("DATALINE_CMD", paramInt3);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong1));
    localToServiceMsg.addAttribute("sendFromNative", Boolean.valueOf(paramBoolean));
    localToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
    paramLong1 = FileManagerUtil.b();
    long l1 = FileManagerUtil.a();
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.jdField_a_of_type_Int = paramInt2;
    localTransMsgContext.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    paramString = a(13, paramString, localTransMsgContext, l1, MessageUtils.b(paramLong1), paramLong2);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramInt1 = 1;
    if (paramInt4 == 3) {
      paramInt1 = 1001;
    }
    paramArrayOfByte.uint32_apppid.set(paramInt1);
    paramArrayOfByte.uint32_instid.set(0);
    paramArrayOfByte.enum_device_type.set(paramInt4);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1001);
    paramArrayOfByte.uint32_instid.set(AppSetting.jdField_a_of_type_Int);
    paramArrayOfByte.enum_device_type.set(2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = paramArrayOfByte;
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    b(localToServiceMsg);
    return localToServiceMsg;
  }
  
  private msg_svc.PbSendMsgReq a(int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong1, int paramInt2, long paramLong2)
  {
    return MessageProtoCodec.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramString, paramTransMsgContext, paramLong1, paramInt2);
  }
  
  private void a(int paramInt, long paramLong, String paramString)
  {
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).b(paramLong);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        return;
        if (paramInt != 0) {
          break;
        }
        localDataLineMsgRecord.thumbPath = paramString;
      } while (localDataLineMsgRecord.isSend());
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "uSessionID[" + paramLong + "]" + "OnSessionThumbUpdate: update");
      }
      b(10, true, new Object[] { Long.valueOf(paramLong) });
      return;
      if (paramInt == 1)
      {
        localDataLineMsgRecord.serverPath = paramString;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
        return;
      }
    } while (paramInt != 2);
    localDataLineMsgRecord.md5 = HexUtil.a(paramString);
    if ((QLog.isDevelopLevel()) && (localDataLineMsgRecord.md5 != null)) {
      QLog.d("DataLineHandler", 4, "SessionUpdateType_FileMD5, uSessionID[" + paramLong + "], strValuebuf[" + paramString + "], strMD5MR[" + HexUtil.a(localDataLineMsgRecord.md5) + "], strMD5Notify" + paramString);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
  }
  
  private void a(int paramInt1, FTNNotify paramFTNNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFTNNotify(paramFTNNotify, paramLong, this.jdField_b_of_type_JavaLangString, paramInt2);
    a(paramInt1, 1004, localMsgBody, paramFTNNotify.uint64_sessionid);
  }
  
  private void a(int paramInt1, FileControl paramFileControl, long paramLong, int paramInt2)
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      return;
    }
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFileControl(paramFileControl, paramLong, this.jdField_b_of_type_JavaLangString, paramInt2);
    a(paramInt1, 1005, localMsgBody, paramFileControl.uint64_sessionid);
  }
  
  private void a(int paramInt, MsgCSBody0x211 paramMsgCSBody0x211)
  {
    switch (paramMsgCSBody0x211.uMsgSubType)
    {
    default: 
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form 0X211");
      return;
    }
    a(paramInt, paramMsgCSBody0x211.msgBody0x211_0x7);
  }
  
  private void a(int paramInt, MsgCSBody0x211_0x7 paramMsgCSBody0x211_0x7)
  {
    long l1 = paramMsgCSBody0x211_0x7.msgHeader.uint64_dst_uin;
    switch (paramMsgCSBody0x211_0x7.uMsgSubCmd)
    {
    }
    for (;;)
    {
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
      for (;;)
      {
        return;
        i1 = 0;
        while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          i1 += 1;
        }
        continue;
        i1 = 0;
        while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          i1 += 1;
        }
        continue;
        i1 = 0;
        while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          i1 += 1;
        }
        continue;
        i1 = 0;
        while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb.length)
        {
          paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[i1].bytes_originfile_md5 = null;
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          i1 += 1;
        }
        continue;
        i1 = 0;
        while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb.length)
        {
          paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[i1].bytes_originfile_md5 = null;
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          i1 += 1;
        }
      }
      int i1 = 0;
      while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
        i1 += 1;
      }
    }
  }
  
  private void a(int paramInt1, NFCNotify paramNFCNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromNFCNotify(paramNFCNotify, paramLong, this.jdField_b_of_type_JavaLangString, paramInt2);
    a(paramInt1, 1003, localMsgBody, paramNFCNotify.uint64_sessionid);
  }
  
  private void a(int paramInt1, RFCInfoNotify paramRFCInfoNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgBodyFromRFCInfoNotify(paramRFCInfoNotify, paramLong, this.jdField_b_of_type_JavaLangString, paramInt2);
    a(paramInt1, 1008, localMsgBody, paramRFCInfoNotify.uSessionId);
  }
  
  private void a(int paramInt1, DataLineMsgRecord paramDataLineMsgRecord, int paramInt2)
  {
    if (paramDataLineMsgRecord.isSend())
    {
      if (paramInt2 == 2)
      {
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        if ((TextUtils.isEmpty(paramDataLineMsgRecord.path)) || (!new File(paramDataLineMsgRecord.path).exists()))
        {
          paramDataLineMsgRecord.nOpType = 1;
          paramDataLineMsgRecord.progress = 0.0F;
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).c(paramDataLineMsgRecord.msgId);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).c();
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).a(paramDataLineMsgRecord.msgId);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006223", "0X8006223", 0, 0, "", "", "", "");
        return;
      }
      if ((paramInt2 == 32) || (paramInt2 == 11) || (paramInt2 == 8))
      {
        paramDataLineMsgRecord.fileMsgStatus = 2L;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).c(paramDataLineMsgRecord.msgId);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).b(paramDataLineMsgRecord.msgId);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
        return;
      }
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).c(paramDataLineMsgRecord.msgId);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).b(paramDataLineMsgRecord.msgId);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt2 == 2)
    {
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).c(paramDataLineMsgRecord.msgId);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).a(paramDataLineMsgRecord.msgId);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).c();
      a(BaseApplication.getContext(), paramDataLineMsgRecord.path);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006226", "0X8006226", 0, 0, "", "", "", "");
      return;
    }
    if ((paramInt2 == 32) || (paramInt2 == 11) || (paramInt2 == 8))
    {
      paramDataLineMsgRecord.fileMsgStatus = 2L;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).c(paramDataLineMsgRecord.msgId);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).b(paramDataLineMsgRecord.msgId);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
      return;
    }
    paramDataLineMsgRecord.fileMsgStatus = 0L;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).c(paramDataLineMsgRecord.msgId);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1).b(paramDataLineMsgRecord.msgId);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
  }
  
  private void a(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList)
  {
    paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromRFCInfoNotify(paramInt, paramMsgHeader, paramList);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
  }
  
  private void a(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = (SubMsgType0x7.MsgBody.FTNNotify)paramList.next();
      if ((localFTNNotify.uint64_sessionid.has()) && (localFTNNotify.uint32_originfiletype.has()) && (localFTNNotify.str_file_name.has()) && (localFTNNotify.uint64_file_len.has()) && (localFTNNotify.bytes_file_md5.has()) && (localFTNNotify.str_file_index.has())) {
        localArrayList.add(localFTNNotify);
      }
    }
    if (localArrayList.size() > 0)
    {
      paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFTNNotify(paramInt, paramMsgHeader, localArrayList, paramBoolean);
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).b(paramLong);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.isSend())
    {
      if (paramInt == 2)
      {
        b(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
        b(2, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
        return;
      }
      if ((paramInt == 32) || (paramInt == 11) || (paramInt == 8))
      {
        b(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
        return;
      }
      b(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    if (paramInt == 2)
    {
      b(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
      b(3, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    if ((paramInt == 32) || (paramInt == 11) || (paramInt == 8))
    {
      b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == 0L) {}
    for (float f1 = 0.0F;; f1 = (float)paramLong2 / (float)paramLong3)
    {
      int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
      DataLineMsgRecord localDataLineMsgRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).b(paramLong1);
      if (localDataLineMsgRecord != null) {
        localDataLineMsgRecord.progress = f1;
      }
      b(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong1), Float.valueOf(f1) });
      return;
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    if (FileManagerUtil.a(paramString) != 0) {}
    do
    {
      for (;;)
      {
        return;
        File localFile = new File(paramString);
        if (localFile.exists()) {
          try
          {
            String str = FileManagerUtil.a(paramString);
            Object localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            localObject = MimeTypesTools.a(paramContext, str);
            Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            int i1 = MediaStoreUtil.a(paramString);
            ContentValues localContentValues = new ContentValues(7);
            localContentValues.put("title", str);
            localContentValues.put("_display_name", localFile.getName());
            localContentValues.put("date_modified", Long.valueOf(localFile.lastModified() / 1000L));
            localContentValues.put("mime_type", (String)localObject);
            localContentValues.put("orientation", Integer.valueOf(i1));
            localContentValues.put("_data", paramString);
            localContentValues.put("_size", Long.valueOf(localFile.length()));
            paramContext.getContentResolver().insert(localUri, localContentValues);
            return;
          }
          catch (Exception paramContext)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("DataLineHandler", 2, "filepath " + paramString + "]" + "save exception");
              return;
            }
          }
          catch (OutOfMemoryError paramContext) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("DataLineHandler", 2, "filepath " + paramString + "]" + "save oom");
  }
  
  private void a(Session paramSession)
  {
    String str = paramSession.strFilePathSrc;
    if ((paramSession.dwGroupID == 0) && (paramSession.bSend) && (paramSession.emFileType == 1) && (str != null) && (new File(str).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(str, this.am, this.an, true), null, null, false).downloadImediatly();
    }
  }
  
  private void a(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo, boolean paramBoolean)
  {
    if (paramSession == null) {}
    int i2;
    DataLineMsgRecord localDataLineMsgRecord;
    int i1;
    label105:
    label122:
    do
    {
      return;
      i2 = DataLineMsgRecord.getDevTypeBySeId(paramSession.uSessionID);
      localDataLineMsgRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i2).b(paramSession.uSessionID);
      if (localDataLineMsgRecord != null) {
        break label565;
      }
      localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.msg = "";
      localDataLineMsgRecord.msgtype = c(paramSession.emFileType);
      localDataLineMsgRecord.sessionid = paramSession.uSessionID;
      if (!paramSession.bSend) {
        break;
      }
      i1 = 1;
      localDataLineMsgRecord.issend = i1;
      if (!paramSession.bSend) {
        break label492;
      }
      bool = true;
      localDataLineMsgRecord.isread = bool;
      if (!paramSession.bSend) {
        break label498;
      }
      i1 = 0;
      localDataLineMsgRecord.nOpType = i1;
      localDataLineMsgRecord.path = paramSession.strFilePathSrc;
      localDataLineMsgRecord.fileFrom = paramSession.emFileFrom;
      if (paramSession.vOfflineFileUUID != null) {
        localDataLineMsgRecord.fileUuid = new String(paramSession.vOfflineFileUUID);
      }
      localDataLineMsgRecord.uOwnerUin = paramSession.uOwnerUin;
      localDataLineMsgRecord.thumbPath = paramSession.strFilePathThumb;
      localDataLineMsgRecord.md5 = paramSession.vFileMD5Src;
      if (paramNFCInfo != null)
      {
        localDataLineMsgRecord.nServerIp = paramNFCInfo.dwServerIP;
        localDataLineMsgRecord.nServerPort = paramNFCInfo.wServerPort;
        localDataLineMsgRecord.vUrlNotify = paramNFCInfo.vUrlNotify;
        localDataLineMsgRecord.vTokenKey = paramNFCInfo.vTokenKey;
      }
      if (paramFTNInfo != null) {
        localDataLineMsgRecord.serverPath = paramFTNInfo.strFileIndex;
      }
    } while (localDataLineMsgRecord.path == null);
    if ((paramSession.strFileNameSrc != null) && (paramSession.strFileNameSrc.length() > 0))
    {
      localDataLineMsgRecord.filename = paramSession.strFileNameSrc;
      label286:
      localDataLineMsgRecord.filesize = paramSession.uFileSizeSrc;
      localDataLineMsgRecord.issuc = false;
      localDataLineMsgRecord.vipBubbleID = f();
      localDataLineMsgRecord.time = paramSession.uMsgTime;
      localDataLineMsgRecord.groupId = paramSession.dwGroupID;
      localDataLineMsgRecord.groupSize = paramSession.dwGroupSize;
      localDataLineMsgRecord.groupIndex = paramSession.dwGroupIndex;
      localDataLineMsgRecord.progress = 0.0F;
      if (!paramBoolean) {
        break label535;
      }
      localDataLineMsgRecord.fileMsgStatus = 0L;
      label365:
      paramNFCInfo = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i2);
      if (paramSession.bSend) {
        break label559;
      }
    }
    label492:
    label498:
    label535:
    label559:
    for (boolean bool = true;; bool = false)
    {
      paramNFCInfo.a(localDataLineMsgRecord, bool);
      paramNFCInfo = localDataLineMsgRecord;
      paramNFCInfo.issuc = true;
      if (!paramSession.bSend) {
        break label633;
      }
      b(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramSession.uSessionID), paramSession.strFilePathSrc, Byte.valueOf((byte)paramSession.emFileType), Boolean.valueOf(false), Boolean.valueOf(paramBoolean), Long.valueOf(paramNFCInfo.filesize) });
      return;
      i1 = 0;
      break;
      bool = false;
      break label105;
      i1 = 1;
      break label122;
      try
      {
        localDataLineMsgRecord.filename = new File(localDataLineMsgRecord.path).getName();
      }
      catch (Exception paramNFCInfo)
      {
        paramNFCInfo.printStackTrace();
      }
      break label286;
      localDataLineMsgRecord.fileMsgStatus = 2L;
      if (paramSession.bSend) {
        break label365;
      }
      localDataLineMsgRecord.fileMsgStatus = 1L;
      break label365;
    }
    label565:
    if (paramBoolean) {}
    for (localDataLineMsgRecord.fileMsgStatus = 0L;; localDataLineMsgRecord.fileMsgStatus = 2L)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i2).c(localDataLineMsgRecord.msgId);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i2).b(localDataLineMsgRecord.msgId);
      paramNFCInfo = localDataLineMsgRecord;
      break;
    }
    label633:
    if (!paramBoolean)
    {
      paramFTNInfo = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(i2).b(paramSession.uSessionID);
      if ((paramFTNInfo == null) || (!DataLineMsgSet.isSingle(paramFTNInfo))) {
        break label744;
      }
      k();
    }
    for (;;)
    {
      b(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramSession.uSessionID), paramSession.strFilePathSrc, Byte.valueOf((byte)paramSession.emFileType), Boolean.valueOf(false), Boolean.valueOf(paramBoolean), Long.valueOf(paramNFCInfo.filesize) });
      return;
      label744:
      paramFTNInfo = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(i2).a(paramSession.dwGroupID);
      if ((paramFTNInfo == null) || (paramFTNInfo.getComeCount() == 1)) {
        k();
      }
    }
  }
  
  private void a(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList)
  {
    paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFileControl(paramMsgHeader, paramList);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
  }
  
  static boolean a(Session paramSession, String paramString)
  {
    if (paramSession != null) {
      if ((paramString == null) || (paramString.length() == 0))
      {
        if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.length() != 0)) {}
      }
      else {
        while ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.equals(paramString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return c(a(paramFileManagerEntity));
  }
  
  private boolean a(TextMsgTask paramTextMsgTask)
  {
    int i2 = 0;
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int i4 = paramTextMsgTask.a(localStringBuffer);
    if (i4 == -1) {
      return false;
    }
    int i3;
    if (this.ad == 0) {
      while (i1 < localStringBuffer.length())
      {
        i2 = i1;
        if (localStringBuffer.charAt(i1) == '\024')
        {
          i2 = i1;
          if (i1 < localStringBuffer.length() - 1)
          {
            i3 = localStringBuffer.charAt(i1 + 1);
            i2 = i1;
            if (i3 >= 0)
            {
              i2 = i1;
              if (i3 < MessageUtils.a.length)
              {
                localStringBuffer.setCharAt(i1 + 1, (char)MessageUtils.a[i3]);
                i2 = i1 + 1;
              }
            }
          }
        }
        i1 = i2 + 1;
      }
    }
    if (this.ad == 1)
    {
      i1 = i2;
      for (;;)
      {
        if (i1 < localStringBuffer.length())
        {
          i3 = i1;
          String str;
          if (localStringBuffer.charAt(i1) == '\024')
          {
            i3 = i1;
            if (i1 < localStringBuffer.length() - 1)
            {
              i3 = localStringBuffer.charAt(i1 + 1);
              i2 = i3;
              if (i3 == 250) {
                i2 = 10;
              }
              i3 = i1;
              if (i2 >= 0)
              {
                i3 = i1;
                if (i2 < EmotcationConstants.a.length) {
                  str = EmotcationConstants.a[i2];
                }
              }
            }
          }
          try
          {
            localStringBuffer.replace(i1 + 1, i1 + 2, str);
            i3 = i1 + str.length();
            i1 = i3 + 1;
          }
          catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
          {
            for (;;)
            {
              localStringIndexOutOfBoundsException.printStackTrace();
              QLog.d("DataLineHandler", 2, "SendSubText ipad emoj fail", localStringIndexOutOfBoundsException);
            }
          }
        }
      }
    }
    paramTextMsgTask.a(a(paramTextMsgTask.a().longValue(), 1001, paramTextMsgTask.a(), i4, localStringBuffer.toString().getBytes()));
    return true;
  }
  
  private void b(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.NFCNotify localNFCNotify = (SubMsgType0x7.MsgBody.NFCNotify)paramList.next();
      if ((localNFCNotify.uint64_sessionid.has()) && (localNFCNotify.uint32_originfiletype.has()) && (localNFCNotify.str_file_name.has()) && (localNFCNotify.uint64_file_len.has()) && (localNFCNotify.bytes_file_md5.has()) && (localNFCNotify.fixed32_ip.has()) && (localNFCNotify.uint32_port.has()) && (localNFCNotify.bytes_url_notify.has()) && (localNFCNotify.bytes_tokenkey.has())) {
        localArrayList.add(localNFCNotify);
      }
    }
    if (localArrayList.size() > 0)
    {
      paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromNFCNotify(paramInt, paramMsgHeader, localArrayList, paramBoolean);
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
    }
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord.fileMsgStatus = 0L;
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).c(paramDataLineMsgRecord.msgId);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).b(paramDataLineMsgRecord.msgId);
    b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramDataLineMsgRecord.sessionid), paramDataLineMsgRecord.path });
  }
  
  private void b(ArrayList paramArrayList, boolean paramBoolean)
  {
    boolean bool = true;
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showNoNetworkDialog();
    }
    while (paramArrayList.size() == 0) {
      return;
    }
    LiteTransferWrapper localLiteTransferWrapper = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    if (paramArrayList.size() == 1) {
      bool = false;
    }
    localLiteTransferWrapper.SendGroup(paramArrayList, paramBoolean, bool);
  }
  
  private void b(List paramList)
  {
    paramList = paramList.iterator();
    Object localObject;
    DataLineMsgRecord localDataLineMsgRecord;
    int i1;
    while (paramList.hasNext())
    {
      localObject = (SubMsgType0x7.MsgBody.MoloNotify)paramList.next();
      if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).bytes_buf.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "应用宝消息  moloHandler SubCmd0x5 do not has bytes_buf");
        }
      }
      else
      {
        localDataLineMsgRecord = this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(((SubMsgType0x7.MsgBody.MoloNotify)localObject).bytes_buf.get().toByteArray());
        if (localDataLineMsgRecord == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息 moloHandler dealWith return null");
          }
        }
        else
        {
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.has()) {
            break label333;
          }
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.get();
          localDataLineMsgRecord.groupId = i1;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.has()) {
            break label339;
          }
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.get();
          label138:
          localDataLineMsgRecord.groupSize = i1;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.has()) {
            break label345;
          }
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.get();
          label163:
          localDataLineMsgRecord.groupIndex = i1;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息 groupId[" + localDataLineMsgRecord.groupId + "],size[" + localDataLineMsgRecord.groupSize + "],index[" + localDataLineMsgRecord.groupIndex + "], sessionid[" + localDataLineMsgRecord.sessionid + "], key[" + localDataLineMsgRecord.strMoloKey);
          }
          if (localDataLineMsgRecord.groupSize == 1)
          {
            localDataLineMsgRecord.groupId = 0;
            localDataLineMsgRecord.groupSize = 0;
            localDataLineMsgRecord.groupIndex = 0;
          }
          if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!b(localDataLineMsgRecord.groupId))) {
            break label351;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息msg record in deleted group, sessionid[" + localDataLineMsgRecord.sessionid);
          }
        }
      }
    }
    label333:
    label339:
    label345:
    label351:
    int i2;
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label138;
      i1 = 0;
      break label163;
      i2 = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
      a().a().a(i2).a(localDataLineMsgRecord, true);
      if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!b(localDataLineMsgRecord.groupId))) {
        break label459;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "应用宝消息 msg record in deleted group 2, sessionid[" + localDataLineMsgRecord.sessionid);
      }
      paramList = a().a(i2).a(localDataLineMsgRecord.sessionid);
    } while (paramList == null);
    a(paramList);
    return;
    label459:
    label477:
    boolean bool;
    if (DataLineMsgSet.isSingle(localDataLineMsgRecord))
    {
      DataLineReportUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      k();
      bool = false;
      if (!a(localDataLineMsgRecord.sessionid, localDataLineMsgRecord.groupId)) {
        break label610;
      }
    }
    for (;;)
    {
      b(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool), Long.valueOf(localDataLineMsgRecord.filesize) });
      break;
      localObject = a().a(i2).a(localDataLineMsgRecord.groupId);
      if ((localObject != null) && (((DataLineMsgSet)localObject).getComeCount() != 1)) {
        break label477;
      }
      DataLineReportUtil.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      k();
      break label477;
      label610:
      localDataLineMsgRecord.issuc = true;
      localDataLineMsgRecord.fileMsgStatus = 1L;
      bool = NetworkUtil.i(BaseApplication.getContext());
      if (localDataLineMsgRecord.filesize <= 3145728L)
      {
        i1 = 1;
        label642:
        if ((!bool) && ((!getAutoDownload()) || (i1 == 0))) {
          break label725;
        }
        bool = true;
        if (bool) {
          localDataLineMsgRecord.fileMsgStatus = 0L;
        }
      }
      try
      {
        b(111);
        this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(localDataLineMsgRecord.strMoloKey);
        DataLineReportUtil.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i2).c(localDataLineMsgRecord.msgId);
        continue;
        i1 = 0;
        break label642;
        label725:
        bool = false;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 63531;
    case 1: 
      return 63536;
    }
    return 63527;
  }
  
  private void c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null) {
      return;
    }
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    if (paramDataLineMsgRecord.strMoloKey != null)
    {
      b(111);
      if (paramDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(paramDataLineMsgRecord)) {
          break label115;
        }
        DataLineReportUtil.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramDataLineMsgRecord);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramDataLineMsgRecord.sessionid));
      if (!a(localArrayList)) {
        break;
      }
      localFileManagerEntity.status = 2;
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).c(paramDataLineMsgRecord.msgId);
      return;
      label115:
      DataLineReportUtil.e(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    FMToastUtil.a(2131362191);
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), DataLineServlet.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    long l1 = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("datalineSendTimekey", l1);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
    int i2 = DataLineMsgRecord.getDevTypeBySeId(l1);
    paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i2).b(l1);
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.fileUuid = null;
    paramToServiceMsg.uOwnerUin = 0L;
    paramToServiceMsg.busId = 38;
    paramToServiceMsg.forwardTroopFileEntrance = 0;
    paramToServiceMsg.nOpType = 0;
    paramToServiceMsg.fileFrom = 5;
    paramToServiceMsg.path = (AppConstants.bv + paramToServiceMsg.filename);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (int i1 = 2;; i1 = 36)
    {
      a(i2, paramToServiceMsg, i1);
      new Handler(Looper.getMainLooper()).post(new pwu(this, l1, i1));
      return;
    }
  }
  
  public static boolean c(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return false;
    }
    return true;
  }
  
  public static int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case -2000: 
      return 1;
    }
    return 2;
  }
  
  private void d(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if ((paramDataLineMsgRecord != null) && (!paramDataLineMsgRecord.isSendFromLocal()) && (DataLineMsgSet.isSingle(paramDataLineMsgRecord)) && (paramDataLineMsgRecord.msgtype == 63536) && (paramDataLineMsgRecord.path != null) && (new File(paramDataLineMsgRecord.path).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(paramDataLineMsgRecord.path, this.am, this.an, true), null, null, false).downloadImediatly();
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 0;
    paramObject = new MsgSCBody();
    ((MsgSCBody)paramObject).uMsgType = 529;
    ((MsgSCBody)paramObject).msgBody0x211 = new MsgSCBody0x211();
    ((MsgSCBody)paramObject).msgBody0x211.uMsgSubType = 7;
    ((MsgSCBody)paramObject).msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
    Long localLong = (Long)paramToServiceMsg.getAttribute("cookie");
    MsgSCBody0x211_0x7 localMsgSCBody0x211_0x7;
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "handleFTNNotify " + localLong.intValue() + " 发送信令，发送失败");
      }
      ((MsgSCBody)paramObject).bTimeOut = true;
      if (paramFromServiceMsg != null)
      {
        localMsgSCBody0x211_0x7 = ((MsgSCBody)paramObject).msgBody0x211.msgBody0x211_0x7;
        if (!paramFromServiceMsg.isSuccess()) {
          break label233;
        }
      }
    }
    for (;;)
    {
      localMsgSCBody0x211_0x7.uResult = i1;
      if (!((Boolean)paramToServiceMsg.getAttribute("sendFromNative", Boolean.valueOf(true))).booleanValue()) {
        break label239;
      }
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(localLong.intValue(), (MsgSCBody)paramObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "handleFTNNotify " + localLong.intValue() + " 发送信令，发送成功");
      }
      ((MsgSCBody)paramObject).bTimeOut = false;
      break;
      label233:
      i1 = 1;
    }
    label239:
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public static int e()
  {
    int i1 = Long.valueOf(System.currentTimeMillis()).intValue();
    int i2 = ah;
    ah = i2 + 1;
    return i1 << 16 | i2;
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((TextMsgTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).a().equals(paramToServiceMsg)) {}
    }
    for (paramToServiceMsg = (TextMsgTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);; paramToServiceMsg = null)
    {
      if (paramToServiceMsg == null) {}
      do
      {
        return;
        i1 += 1;
        break;
        paramToServiceMsg.a().progress = 1.0F;
        i1 = DataLineMsgRecord.getDevTypeBySeId(paramToServiceMsg.a().longValue());
        if (!paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg.a().issuc = false;
          b(1, false, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
          return;
        }
        if (paramToServiceMsg.a())
        {
          paramToServiceMsg.a().issuc = true;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).a(paramToServiceMsg.a().msgId);
          this.jdField_a_of_type_JavaUtilArrayList.remove(paramToServiceMsg);
          b(1, true, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
          return;
        }
      } while (a(paramToServiceMsg));
      paramToServiceMsg.a().issuc = false;
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramToServiceMsg);
      b(1, false, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
      return;
    }
  }
  
  private void f()
  {
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_PC_STATE";
    if (this.jdField_b_of_type_Boolean)
    {
      localSharedPreferences.edit().putLong(str, this.jdField_a_of_type_Long).commit();
      return;
    }
    localSharedPreferences.edit().remove(str).commit();
  }
  
  private void h()
  {
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_IPAD_STATE";
    if (this.jdField_c_of_type_Boolean)
    {
      localSharedPreferences.edit().putLong(str, this.jdField_b_of_type_Long).commit();
      return;
    }
    localSharedPreferences.edit().remove(str).commit();
  }
  
  private void i()
  {
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_PC_STATE";
    if (localSharedPreferences.contains(str))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Long = localSharedPreferences.getLong(str, 0L);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void j()
  {
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_IPAD_STATE";
    if (localSharedPreferences.contains(str))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Long = localSharedPreferences.getLong(str, 0L);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Boolean == true) {}
    for (boolean bool = false;; bool = true)
    {
      a().a(1, bool, false);
      return;
    }
  }
  
  public void GetThumbFilePath(int paramInt, Session paramSession)
  {
    QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePath ");
    Object localObject = (RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
    if ((localObject != null) && (((RegisterProxySvcPackHandler)localObject).a() == 0))
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePath pc not line ");
      return;
    }
    if (paramSession.uFileSizeSrc < 51200L)
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 333 MinSize_for_CreateThumb e ");
      return;
    }
    localObject = FileUtil.b(BaseApplication.getContext(), paramSession.strFilePathSrc);
    if (localObject == null)
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 444 MinSize_for_CreateThumb e ");
      return;
    }
    File localFile = new File((String)localObject);
    if ((localFile == null) || (!localFile.exists()))
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 555 MinSize_for_CreateThumb e ");
      return;
    }
    if (localFile.length() + 51200L < paramSession.uFileSizeSrc)
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 666 MinSize_for_CreateThumb e ");
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnGetThumbFilePathReply(paramInt, (String)localObject);
      return;
    }
    QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 777 MinSize_for_CreateThumb e ");
    localFile.delete();
  }
  
  public void HandleSession(int paramInt1, long paramLong, int paramInt2, MsgHeader paramMsgHeader) {}
  
  public void InvokeReport(ReportItem paramReportItem)
  {
    QualityReportUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramReportItem, QualityReportUtil.b);
  }
  
  public void OnGroupComplete(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "uGroupID[" + paramInt1 + "]" + "OnGroupComplete 分组结束" + " emGroupStatus[" + paramInt2 + "]");
    }
    if (paramInt1 == 0) {}
    DataLineMsgSet localDataLineMsgSet1;
    do
    {
      return;
      DataLineMsgSet localDataLineMsgSet2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramInt1);
      localDataLineMsgSet1 = localDataLineMsgSet2;
      if (localDataLineMsgSet2 == null) {
        localDataLineMsgSet1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(paramInt1);
      }
    } while (localDataLineMsgSet1 == null);
    localDataLineMsgSet1.setTimeOut();
    b(11, true, null);
  }
  
  public void OnGroupStart(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "uGroupID[" + paramInt + "]" + "OnGroupStart 分组开始");
    }
    b(11, true, null);
  }
  
  public boolean OnQueryAutoDownload(long paramLong, byte paramByte)
  {
    boolean bool2 = false;
    if (paramByte == 2)
    {
      boolean bool1 = NetworkUtil.i(BaseApplication.getContext());
      if (paramLong <= 3145728L) {}
      for (paramByte = 1;; paramByte = 0)
      {
        if (!bool1)
        {
          bool1 = bool2;
          if (getAutoDownload())
          {
            bool1 = bool2;
            if (paramByte == 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
    return true;
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = (Session)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((paramInt1 == 2) && (localObject != null)) {
      this.jdField_b_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    }
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (localObject == null)
    {
      localObject = Looper.getMainLooper();
      DataLineMsgRecord localDataLineMsgRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).b(paramLong);
      if (localDataLineMsgRecord == null)
      {
        if (Thread.currentThread() != ((Looper)localObject).getThread()) {
          new Handler((Looper)localObject).post(new pwl(this, paramLong, paramInt1, paramInt2));
        }
        return;
      }
      if (paramInt1 == 2) {
        d(localDataLineMsgRecord);
      }
      a(i1, localDataLineMsgRecord, paramInt1);
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new pwm(this, paramLong, paramInt1));
        return;
      }
      a(paramLong, paramInt1);
      return;
    }
    if (paramInt1 == 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(16, bool, localObject);
      return;
    }
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    if (paramSession.bSend)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006222", "0X8006222", 0, 0, "", "", "", "");
      if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.length() != 0)) {
        break label216;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "uSessionID[" + paramSession.uSessionID + "]" + "OnSessionNew Session创建");
      }
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() == localLooper.getThread()) {
        break label205;
      }
      new Handler(localLooper).post(new pwi(this, paramSession, paramNFCInfo, paramFTNInfo));
    }
    for (;;)
    {
      a(paramSession);
      return;
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006225", "0X8006225", 0, 0, "", "", "", "");
      break;
      label205:
      a(paramSession, paramNFCInfo, paramFTNInfo, false);
    }
    label216:
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramSession.uSessionID), paramSession);
    b(17, true, paramSession);
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = (Session)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localObject == null)
    {
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new pwk(this, paramLong1, paramLong2, paramLong3));
        return;
      }
      a(paramLong1, paramLong2, paramLong3);
      return;
    }
    b(15, true, new Object[] { localObject, Float.valueOf((float)((float)paramLong2 * 1.0D / (float)paramLong3)) });
  }
  
  public void OnSessionStart(long paramLong)
  {
    Object localObject = (Session)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "uSessionID[" + paramLong + "], OnSessionStart, Session开始");
      }
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new pwj(this, paramLong));
        return;
      }
      a(a(paramLong), null, null, true);
      return;
    }
    b(14, true, localObject);
  }
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new pwn(this, paramInt, paramLong, paramString));
      return;
    }
    a(paramInt, paramLong, paramString);
  }
  
  public void SendPbMsg(int paramInt, MsgCSBody paramMsgCSBody)
  {
    QLog.d("DataLineHandler", 1, "SendPbMsg: msgBody.uMsgType " + paramMsgCSBody.uMsgType);
    switch (paramMsgCSBody.uMsgType)
    {
    default: 
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form JNI, cmd[" + paramMsgCSBody.uMsgType);
      return;
    case 529: 
      a(paramInt, paramMsgCSBody.msgBody0x211);
      return;
    case 838: 
      a(paramInt, paramMsgCSBody.msgBody0x346);
      return;
    }
    a(paramInt, paramMsgCSBody.msgBody0x345);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateGroupID();
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(paramString);
  }
  
  public long a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_Long;
    }
    return this.jdField_b_of_type_Long;
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  public long a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, paramString1, paramString2, paramString3, paramInt1, 0, paramLong, paramInt2, paramInt3, paramInt4);
    if (paramString1 == null) {
      return 0L;
    }
    localArrayList.add(paramString1);
    if (0L == paramLong) {
      paramString1.uSessionID = a(0, this.ad).longValue();
    }
    paramString1.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), this.ad);
    b(localArrayList, paramBoolean);
    return paramString1.uSessionID;
  }
  
  public DirectForwarder a()
  {
    return this.jdField_a_of_type_ComDatalineCoreDirectForwarder;
  }
  
  public Session a(long paramLong)
  {
    boolean bool = true;
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = a().a().a(i1).b(paramLong);
    if (localDataLineMsgRecord == null) {
      return null;
    }
    Session localSession = new Session();
    localSession.uSessionID = localDataLineMsgRecord.sessionid;
    if (localDataLineMsgRecord.issend == 1) {}
    for (;;)
    {
      localSession.bSend = bool;
      i1 = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
      localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), i1);
      localSession.dwGroupID = localDataLineMsgRecord.groupId;
      localSession.dwGroupSize = localDataLineMsgRecord.groupSize;
      localSession.dwGroupIndex = localDataLineMsgRecord.groupIndex;
      localSession.emFileType = d(localDataLineMsgRecord.msgtype);
      localSession.strFilePathSrc = localDataLineMsgRecord.path;
      localSession.strFilePathThumb = localDataLineMsgRecord.thumbPath;
      localSession.uFileSizeSrc = localDataLineMsgRecord.filesize;
      localSession.vFileMD5Src = localDataLineMsgRecord.md5;
      if ((QLog.isDevelopLevel()) && (localDataLineMsgRecord.md5 != null)) {
        QLog.d("DataLineHandler", 4, "getSessionFromMsgRecord, uSessionID[" + localDataLineMsgRecord.sessionid + "], strMR[" + HexUtil.a(localDataLineMsgRecord.md5) + "], filesize[" + localDataLineMsgRecord.filesize);
      }
      localSession.actionInfo = null;
      return localSession;
      bool = false;
    }
  }
  
  public final QQAppInterface a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public ToServiceMsg a(int paramInt, SubMsgType0x7.MsgBody paramMsgBody, long paramLong)
  {
    int i1 = paramMsgBody.msg_header.uint32_dst_ter_type.get();
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramMsgBody = paramMsgBody.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "send0x211C2CDatalineMsg DataLineMsgRecord:" + paramLong);
    }
    return a(false, paramLong, str, 529, 7, paramInt, paramMsgBody, paramLong, i1);
  }
  
  public ToServiceMsg a(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(4);
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillMsgHeader(localMsgBody.msg_header, Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), i1);
    localMsgBody.msg_subcmd_0x4_generic.uint64_sessionid.set(paramLong);
    localMsgBody.msg_subcmd_0x4_generic.uint32_size.set(paramInt2);
    localMsgBody.msg_subcmd_0x4_generic.uint32_index.set(paramInt3);
    localMsgBody.msg_subcmd_0x4_generic.uint32_type.set(1);
    SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg localQQDataTextMsg = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
    SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem localMsgItem = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem();
    localMsgItem.uint32_type.set(1);
    localMsgItem.bytes_text.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localMsgItem.setHasFlag(true);
    localQQDataTextMsg.rpt_msg_item.add(localMsgItem);
    localQQDataTextMsg.setHasFlag(true);
    localMsgBody.msg_subcmd_0x4_generic.bytes_buf.set(ByteStringMicro.copyFrom(localQQDataTextMsg.toByteArray()));
    localMsgBody.msg_subcmd_0x4_generic.setHasFlag(true);
    localMsgBody.setHasFlag(true);
    return a(paramLong, paramInt1, localMsgBody, paramLong);
  }
  
  public ToServiceMsg a(long paramLong1, int paramInt, SubMsgType0x7.MsgBody paramMsgBody, long paramLong2)
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i1 = paramMsgBody.msg_header.uint32_dst_ter_type.get();
    paramMsgBody = paramMsgBody.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "send0x211C2CDatalineMsg DataLineMsgRecord:" + paramLong2);
    }
    return a(paramLong1, str, 529, 7, paramInt, paramMsgBody, paramLong2, i1);
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x345 paramMsgCSBody0x345)
  {
    Object localObject = null;
    byte[] arrayOfByte = null;
    cmd0x345.ReqBody localReqBody = new cmd0x345.ReqBody();
    localReqBody.uint32_sub_cmd.set(paramMsgCSBody0x345.uMsgSubType);
    switch (paramMsgCSBody0x345.uMsgSubType)
    {
    default: 
      localObject = arrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "send0x345Req, unknwon nCmdType:" + paramMsgCSBody0x345.uMsgSubType);
      }
      break;
    }
    for (localObject = arrayOfByte;; localObject = a("GTalkFileAppSvr.CMD_DISCUSS_FILE", null))
    {
      paramMsgCSBody0x345 = (MsgCSBody0x345)localObject;
      if (localObject != null)
      {
        paramMsgCSBody0x345 = localReqBody.toByteArray();
        arrayOfByte = new byte[paramMsgCSBody0x345.length + 4];
        PkgTools.a(arrayOfByte, 0, paramMsgCSBody0x345.length + 4);
        PkgTools.a(arrayOfByte, 4, paramMsgCSBody0x345, paramMsgCSBody0x345.length);
        ((ToServiceMsg)localObject).putWupBuffer(arrayOfByte);
        ((ToServiceMsg)localObject).addAttribute("cookie", Long.valueOf(paramLong));
        ((ToServiceMsg)localObject).extraData.putInt("DATALINE_TRYINDEX", 0);
        c((ToServiceMsg)localObject);
        paramMsgCSBody0x345 = (MsgCSBody0x345)localObject;
      }
      do
      {
        return paramMsgCSBody0x345;
        if (paramMsgCSBody0x345.subCmd0x6ReqBody != null) {
          break;
        }
        paramMsgCSBody0x345 = (MsgCSBody0x345)localObject;
      } while (!QLog.isColorLevel());
      QLog.d("DataLineHandler", 2, "send0x345Req, subCmd0x6ReqBody is empty");
      return null;
      localObject = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint32_dst_bus_id.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint32_dst_bus_id);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint64_src_uin.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint64_src_uin);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x345.subCmd0x6ReqBody.bytes_uuid));
      if (paramMsgCSBody0x345.subCmd0x6ReqBody.bytes_file_md5 != null) {
        ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(paramMsgCSBody0x345.subCmd0x6ReqBody.bytes_file_md5));
      }
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint64_dst_uin.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint64_dst_uin);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint64_file_size.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint64_file_size);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).str_file_name.set(paramMsgCSBody0x345.subCmd0x6ReqBody.str_file_name);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).str_src_file_path.set(paramMsgCSBody0x345.subCmd0x6ReqBody.str_src_file_path);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).str_src_parent_folder.set(paramMsgCSBody0x345.subCmd0x6ReqBody.str_src_parent_folder);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint32_client_type.set(104);
      localReqBody.msg_subcmd_0x6_req_body.set((MessageMicro)localObject);
    }
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x346 paramMsgCSBody0x346)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramMsgCSBody0x346.uMsgSubType);
    localReqBody.uint32_business_id.set(paramMsgCSBody0x346.uint32_business_id);
    if (paramMsgCSBody0x346.uint32_business_id == 0) {
      localReqBody.uint32_business_id.set(38);
    }
    localReqBody.uint32_client_type.set(104);
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_seq;
    int i1 = ak;
    ak = i1 + 1;
    localPBUInt32Field.set(i1);
    if (!this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.FillReqBody(paramMsgCSBody0x346, localReqBody))
    {
      paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
      return paramMsgCSBody0x346;
    }
    switch (paramMsgCSBody0x346.uMsgSubType)
    {
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("DataLineHandler", 2, "send0x346Req, unknwon nCmdType:" + paramMsgCSBody0x346.uMsgSubType);
        localObject1 = localObject2;
      }
      for (;;)
      {
        paramMsgCSBody0x346 = localReqBody.toByteArray();
        localObject2 = new byte[paramMsgCSBody0x346.length + 4];
        PkgTools.a((byte[])localObject2, 0, paramMsgCSBody0x346.length + 4);
        PkgTools.a((byte[])localObject2, 4, paramMsgCSBody0x346, paramMsgCSBody0x346.length);
        paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
        if (localObject1 == null) {
          break;
        }
        ((ToServiceMsg)localObject1).putWupBuffer((byte[])localObject2);
        ((ToServiceMsg)localObject1).addAttribute("cookie", Long.valueOf(paramLong));
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
        c((ToServiceMsg)localObject1);
        return (ToServiceMsg)localObject1;
        localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600", null);
        continue;
        localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", null);
        continue;
        localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800", null);
        continue;
        localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", null);
        continue;
        localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
      }
      localObject2 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", null);
    }
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    return a(true, paramLong1, paramString, paramInt1, paramInt2, paramInt3, paramArrayOfByte, paramLong2, 1);
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2, int paramInt4)
  {
    return a(true, paramLong1, paramString, paramInt1, paramInt2, paramInt3, paramArrayOfByte, paramLong2, paramInt4);
  }
  
  public DatalineRemoteManager a()
  {
    return this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager;
  }
  
  protected Class a()
  {
    return DataLineObserver.class;
  }
  
  public Long a(int paramInt)
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(paramInt));
  }
  
  public Long a(int paramInt1, int paramInt2)
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionIDByDev(paramInt1, paramInt2));
  }
  
  public Long a(String paramString, int paramInt)
  {
    if (paramString.length() == 0) {
      return Long.valueOf(0L);
    }
    Long localLong = a(0, paramInt);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgId = localLong.longValue();
    localDataLineMsgRecord.sessionid = localLong.longValue();
    localDataLineMsgRecord.msg = paramString;
    localDataLineMsgRecord.msgtype = 64536;
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    localDataLineMsgRecord.vipBubbleID = f();
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.sessionid = localLong.longValue();
    localDataLineMsgRecord.progress = 0.0F;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt).a(localDataLineMsgRecord, false);
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      return Long.valueOf(0L);
    }
    localDataLineMsgRecord.issuc = true;
    paramString = new TextMsgTask(paramString, localLong, localDataLineMsgRecord);
    if (!a(paramString)) {
      return Long.valueOf(0L);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    return localLong;
  }
  
  public SubMsgType0x7.MsgBody a(DataLineMsgRecord paramDataLineMsgRecord, long paramLong)
  {
    String str = paramDataLineMsgRecord.filename;
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(1);
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    ProtocolHelper.fillMsgHeader(localMsgBody.msg_header, paramLong, Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), i1);
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = new SubMsgType0x7.MsgBody.FTNNotify();
    localFTNNotify.uint64_sessionid.set(paramDataLineMsgRecord.sessionid);
    localFTNNotify.str_file_name.set(str);
    localFTNNotify.str_file_index.set(paramDataLineMsgRecord.serverPath);
    localFTNNotify.bytes_file_md5.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.md5));
    localFTNNotify.uint64_file_len.set(paramDataLineMsgRecord.filesize);
    localFTNNotify.bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.md5));
    localFTNNotify.uint32_originfiletype.set(d(paramDataLineMsgRecord.msgtype));
    localFTNNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x1_ftn_notify.add(localFTNNotify);
    localMsgBody.setHasFlag(true);
    return localMsgBody;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>logout cancel all task");
    }
    d(32);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.b(paramInt);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "manually cancel a file . session =" + paramLong);
    }
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = a().a().a(i1).b(paramLong);
    if (localDataLineMsgRecord == null)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    localDataLineMsgRecord.fileMsgStatus = 2L;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).c(localDataLineMsgRecord.msgId);
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      this.jdField_a_of_type_ComDatalineCoreMoloHandler.c(localDataLineMsgRecord.strMoloKey);
      return;
    }
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(localDataLineMsgRecord.groupId, paramLong, 32, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelAll(paramInt, paramBoolean);
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a();
  }
  
  protected void a(long paramLong1, long paramLong2, SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader)
  {
    for (;;)
    {
      TextMsgPush localTextMsgPush;
      Object localObject1;
      try
      {
        if (!paramGenericSubCmd.uint32_type.has()) {
          return;
        }
        switch (paramGenericSubCmd.uint32_type.get())
        {
        case 1: 
          if (!paramGenericSubCmd.uint64_sessionid.has()) {
            break label680;
          }
          switch (paramMsgHeader.uint32_src_ter_type.get())
          {
          default: 
            long l1 = paramGenericSubCmd.uint64_sessionid.get();
            if (i1 != 1) {
              break label677;
            }
            l1 |= 0x1000000000000000;
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(l1)))
            {
              localTextMsgPush = new TextMsgPush(Long.valueOf(paramGenericSubCmd.uint32_size.get()), Long.valueOf(l1));
              this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), localTextMsgPush);
              if (!paramGenericSubCmd.bytes_buf.has()) {
                break label680;
              }
              paramMsgHeader = new String();
              localObject1 = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
              ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject1).mergeFrom(paramGenericSubCmd.bytes_buf.get().toByteArray());
              localObject1 = ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject1).rpt_msg_item.get().iterator();
              if (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)((Iterator)localObject1).next();
                if ((!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.has()) || (((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.get() != 1) || (!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.has())) {
                  break label674;
                }
                localObject2 = new String(((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.get().toByteArray());
                paramMsgHeader = paramMsgHeader + (String)localObject2;
                break label688;
              }
            }
            else
            {
              localTextMsgPush = (TextMsgPush)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l1));
              continue;
            }
            if (!paramGenericSubCmd.uint32_index.has()) {
              break label680;
            }
            localTextMsgPush.a(paramGenericSubCmd.uint32_index.get(), paramMsgHeader);
            if (!localTextMsgPush.a()) {
              break label680;
            }
            this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l1));
            localObject1 = new DataLineMsgRecord();
            ((DataLineMsgRecord)localObject1).msgId = l1;
            ((DataLineMsgRecord)localObject1).sessionid = l1;
            if (i1 == 1)
            {
              paramGenericSubCmd = localTextMsgPush.a();
              i1 = 0;
              if (i1 < EmotcationConstants.a.length)
              {
                paramMsgHeader = paramGenericSubCmd;
                if (paramGenericSubCmd.indexOf('\024' + EmotcationConstants.a[i1]) == -1) {
                  break label697;
                }
                paramMsgHeader = paramGenericSubCmd.replace('\024' + EmotcationConstants.a[i1], "\024" + (char)i1);
                break label697;
              }
              ((DataLineMsgRecord)localObject1).msg = paramGenericSubCmd;
              ((DataLineMsgRecord)localObject1).msgtype = 64536;
              ((DataLineMsgRecord)localObject1).issend = 0;
              ((DataLineMsgRecord)localObject1).isread = false;
              ((DataLineMsgRecord)localObject1).time = paramLong1;
              ((DataLineMsgRecord)localObject1).issuc = true;
              ((DataLineMsgRecord)localObject1).sessionid = ((DataLineMsgRecord)localObject1).msgId;
              ((DataLineMsgRecord)localObject1).shmsgseq = paramLong2;
              i1 = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject1).sessionid);
              this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).a((DataLineMsgRecord)localObject1, true);
              k();
              b(8, true, new Object[] { Integer.valueOf((int)paramLong1), localTextMsgPush.a(), Long.valueOf(((DataLineMsgRecord)localObject1).sessionid) });
              return;
            }
            break;
          }
          break;
        }
      }
      catch (Exception paramGenericSubCmd)
      {
        paramGenericSubCmd.printStackTrace();
        return;
      }
      ((DataLineMsgRecord)localObject1).msg = localTextMsgPush.a();
      continue;
      label674:
      break label688;
      label677:
      continue;
      label680:
      return;
      return;
      int i1 = 0;
      continue;
      label688:
      continue;
      i1 = 1;
      continue;
      label697:
      i1 += 1;
      paramGenericSubCmd = paramMsgHeader;
    }
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    a(1004, a(paramDataLineMsgRecord, Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue()), paramDataLineMsgRecord.sessionid);
    OnSessionProgress(paramDataLineMsgRecord.sessionid, (paramDataLineMsgRecord.filesize * 0.8D), paramDataLineMsgRecord.filesize);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord == null) {}
    ArrayList localArrayList;
    Session localSession;
    do
    {
      return;
      localArrayList = new ArrayList();
      localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(paramDataLineMsgRecord);
    } while (localSession == null);
    if (0L == paramDataLineMsgRecord.sessionid) {
      localSession.uSessionID = a(0, this.ad).longValue();
    }
    localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), this.ad);
    localArrayList.add(localSession);
    b(localArrayList, paramBoolean);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      i1 = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX", -1);
      if (i1 >= 0) {}
    }
    do
    {
      return;
      if (i1 < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i1 + 1);
        c(paramToServiceMsg);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1610);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1710);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1810);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1210);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400"))
      {
        if (((Boolean)paramToServiceMsg.getAttribute("sendFromNative", Boolean.valueOf(true))).booleanValue())
        {
          a(paramToServiceMsg, paramFromServiceMsg, 1410);
          return;
        }
        b(paramToServiceMsg, paramFromServiceMsg, 1410);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 60110);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("GTalkFileAppSvr.CMD_DISCUSS_FILE"))
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x346Rsp, unknown cmd:" + paramFromServiceMsg.getServiceCmd());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new pws(this, paramToServiceMsg, paramFromServiceMsg, paramInt));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
    if (a(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new pwr(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ArrayList paramArrayList)
  {
    a(paramArrayList, null, null, Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
  }
  
  public void a(ArrayList paramArrayList, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayList == null) {}
    int i2;
    int i1;
    ArrayList localArrayList;
    Object localObject;
    String str;
    for (;;)
    {
      return;
      i2 = paramArrayList.size();
      if (i2 > 3) {
        break;
      }
      i1 = 0;
      while (i1 < i2)
      {
        localArrayList = new ArrayList();
        localObject = ((FileInfo)paramArrayList.get(i1)).d();
        str = ((FileInfo)paramArrayList.get(i1)).c();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, str, 0, 0, 0L, 0, 0, 0);
        if (localObject != null)
        {
          localArrayList.add(localObject);
          ((Session)localObject).uSessionID = a(0, this.ad).longValue();
          ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.ad);
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        }
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        i1 += 1;
      }
    }
    if ((i2 > 3) && (i2 < 50))
    {
      localArrayList = new ArrayList();
      int i3 = a();
      i1 = 0;
      label199:
      if (i1 < i2)
      {
        localObject = ((FileInfo)paramArrayList.get(i1)).d();
        str = ((FileInfo)paramArrayList.get(i1)).c();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, str, 0, 0, 0L, i3, i2, i1);
        if (localObject == null) {
          break label634;
        }
        localArrayList.add(localObject);
        ((Session)localObject).uSessionID = a(i3, this.ad).longValue();
        ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.ad);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        if (!DataLineMsgSet.isSingle(0, i3)) {
          break label634;
        }
        ((Session)localObject).dwGroupID = 0;
        ((Session)localObject).dwGroupIndex = 0;
        ((Session)localObject).dwGroupSize = 0;
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        localArrayList = new ArrayList();
      }
    }
    label412:
    label631:
    label634:
    for (;;)
    {
      i1 += 1;
      break label199;
      if (localArrayList.size() <= 0) {
        break;
      }
      b(localArrayList, false);
      return;
      i2 = a();
      localArrayList = new ArrayList();
      i1 = 0;
      if (i1 < 50)
      {
        localObject = ((FileInfo)paramArrayList.get(i1)).d();
        str = ((FileInfo)paramArrayList.get(i1)).c();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, str, 0, 0, 0L, i2, 50, i1);
        if (localObject == null) {
          break label631;
        }
        localArrayList.add(localObject);
        ((Session)localObject).uSessionID = a(i2, this.ad).longValue();
        ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.ad);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        if (!DataLineMsgSet.isSingle(0, i2)) {
          break label631;
        }
        ((Session)localObject).dwGroupID = 0;
        ((Session)localObject).dwGroupIndex = 0;
        ((Session)localObject).dwGroupSize = 0;
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        i1 += 1;
        break label412;
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        i1 = 0;
        while (i1 < 50)
        {
          paramArrayList.remove(0);
          i1 += 1;
        }
        break;
      }
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    a(paramArrayList, paramBoolean, null, null, Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramArrayList.next();
      Session localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(localDataLineMsgRecord);
      if (localSession != null)
      {
        if (0L == localSession.uSessionID) {
          localSession.uSessionID = a(localDataLineMsgRecord.groupId, this.ad).longValue();
        }
        localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.ad);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, paramString, paramArrayOfByte);
        localArrayList.add(localSession);
      }
    }
    if (localArrayList.size() > 0) {
      b(localArrayList, paramBoolean);
    }
  }
  
  protected void a(List paramList) {}
  
  public void a(msg_comm.Msg paramMsg)
  {
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a(paramMsg);
  }
  
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a(paramMsg, paramMsgBody);
    DataLineMsgRecord localDataLineMsgRecord;
    try
    {
      localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.shmsgseq = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
      localDataLineMsgRecord.time = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      localDataLineMsgRecord.msgId = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
      if (!paramMsgBody.msg_header.has()) {
        throw new Exception("msgBody do not has msg_header");
      }
    }
    catch (Exception paramMsg)
    {
      paramMsg = paramMsg;
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<<<<<<<<<<handleDataLinePushMsg_PB_0x211 Exception:" + paramMsg.toString() + ">>>>>>>>>>");
      }
      return;
      if (!paramMsgBody.msg_header.uint32_src_app_id.has()) {
        throw new Exception("msgBody do not has uint32_src_app_id");
      }
    }
    finally {}
    if (!paramMsgBody.msg_header.uint32_src_inst_id.has()) {
      throw new Exception("msgBody do not has uint32_src_inst_id");
    }
    if (!paramMsgBody.msg_header.uint32_dst_app_id.has()) {
      throw new Exception("msgBody do not has uint32_dst_app_id");
    }
    if (!paramMsgBody.msg_header.uint32_dst_inst_id.has()) {
      throw new Exception("msgBody do not has uint32_dst_inst_id");
    }
    if (a(paramMsgBody.msg_header.uint32_src_app_id.get(), paramMsgBody.msg_header.uint32_src_inst_id.get())) {
      throw new Exception("msgBody command from android");
    }
    if ((paramMsgBody.uint32_sub_cmd.get() != 5) && (!b(paramMsgBody.msg_header.uint32_dst_app_id.get(), paramMsgBody.msg_header.uint32_dst_inst_id.get()))) {
      throw new Exception("msgBody command not for android");
    }
    Object localObject = (im_msg_head.InstInfo)((im_msg_head.InstCtrl)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_inst_ctrl.get()).msg_from_inst.get();
    paramMsgBody.msg_header.uint32_src_ter_type.set(((im_msg_head.InstInfo)localObject).enum_device_type.get());
    QLog.d("DataLineHandler", 2, "DoCCPush msg time[" + localDataLineMsgRecord.time + "] mr.shmsgseq[" + localDataLineMsgRecord.shmsgseq + "] uint32_sub_cmd[" + paramMsgBody.uint32_sub_cmd.get() + "]");
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMsgBody.msg_header.uint32_src_ter_type.get()).d(localDataLineMsgRecord.time);
    if (a(localDataLineMsgRecord, paramMsgBody.msg_header.uint32_src_ter_type.get()))
    {
      QLog.d("DataLineHandler", 2, "DoCCPush msg time[" + localDataLineMsgRecord.time + "] is repeated mr.shmsgseq[" + localDataLineMsgRecord.shmsgseq + "] uint32_sub_cmd[" + paramMsgBody.uint32_sub_cmd.get() + "]");
      return;
    }
    localObject = (RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
    if (localObject != null)
    {
      int i1 = ((RegisterProxySvcPackHandler)localObject).a();
      int i2 = ((RegisterProxySvcPackHandler)localObject).g();
      if ((i1 != 1) || (i1 != 2)) {
        ((RegisterProxySvcPackHandler)localObject).a(1);
      }
      if (i2 != 1) {
        ((RegisterProxySvcPackHandler)localObject).d(1);
      }
    }
    if (!paramMsgBody.uint32_sub_cmd.has()) {
      throw new Exception("msgBody do not has uint32_sub_cmd");
    }
    QLog.d("DataLineHandler", 2, "DoCCPush msg time[" + localDataLineMsgRecord.time + "]  mr.shmsgseq[" + localDataLineMsgRecord.shmsgseq + "] uint32_sub_cmd[" + paramMsgBody.uint32_sub_cmd.get() + "]");
    switch (paramMsgBody.uint32_sub_cmd.get())
    {
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x1 文件原图中转通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
    case 4: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x4 通用协议");
      }
      if (!paramMsgBody.msg_subcmd_0x4_generic.has()) {
        throw new Exception("msgBody do not has msg_subcmd_0x4_generic");
      }
      a(localDataLineMsgRecord.time, localDataLineMsgRecord.shmsgseq, paramMsgBody.msg_subcmd_0x4_generic, paramMsgBody.msg_header);
      return;
      a(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x1_ftn_notify.get(), false);
      return;
    case 2: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x2 文件原图近场通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      b(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x2_nfc_notify.get(), false);
      return;
    case 3: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x3 文件控制命令");
      }
      a(paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x3_filecontrol.get());
      return;
    case 5: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x5 应用宝通知");
      }
      b(paramMsgBody.rpt_msg_subcmd_0x5_molo_notify.get());
      return;
    case 11: 
      a(paramMsgBody.rpt_msg_subcmd_0xb_mpfile_notify.get());
      return;
    case 9: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x9 文件缩略图中转通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      a(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x9_ftn_thumb_notify.get(), true);
      return;
    case 10: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0xa 文件缩略图近场通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      b(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0xa_nfc_thumb_notify.get(), true);
      return;
    case 8: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x8 rfc信令");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      a(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x8_rnfc_notify.get());
      return;
    }
  }
  
  public void a(msg_comm.Msg paramMsg, C2CType0x211_SubC2CType0x9.MsgBody paramMsgBody)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new MqqHandler(localLooper).post(new pwh(this, this, paramMsg, paramMsgBody));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(this, paramMsg, paramMsgBody);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_PC_STATE";
    if (this.jdField_b_of_type_Boolean)
    {
      localSharedPreferences.edit().putLong(str, this.jdField_a_of_type_Long).commit();
      return;
    }
    localSharedPreferences.edit().remove(str).commit();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("dl_pc_online_notify", true);
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_b_of_type_Boolean;
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    int i1 = AppSetting.jdField_a_of_type_Int;
    if ((paramInt1 == 1001) && (paramInt2 == i1) && (QLog.isColorLevel())) {
      QLog.d("DataLineHandler", 2, "msgBody command from android" + paramInt2 + " " + i1);
    }
    return false;
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(i1).b(paramLong);
    DataLineMsgSet localDataLineMsgSet = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(i1).a(paramInt);
    if ((localDataLineMsgSet != null) && (localDataLineMsgSet.isPaused()))
    {
      if (localDataLineMsgRecord != null)
      {
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 2L;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).c(localDataLineMsgRecord.msgId);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    OnSessionProgress(paramDataLineMsgRecord.sessionid, (paramDataLineMsgRecord.filesize * 0.4D), paramDataLineMsgRecord.filesize);
    if ((0L != paramDataLineMsgRecord.filesize) && (paramDataLineMsgRecord.path != null) && (paramDataLineMsgRecord.path.length() != 0) && (paramDataLineMsgRecord.md5 != null) && (paramDataLineMsgRecord.md5.length != 0)) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return true;
    }
    Object localObject2 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject2).uint32_cmd.set(1400);
    ((cmd0x346.ReqBody)localObject2).uint32_client_type.set(104);
    Object localObject1 = ((cmd0x346.ReqBody)localObject2).uint32_seq;
    i1 = ak;
    ak = i1 + 1;
    ((PBUInt32Field)localObject1).set(i1);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.setHasFlag(true);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    if (2 == paramDataLineMsgRecord.fileFrom)
    {
      ((cmd0x346.ReqBody)localObject2).msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.serverPath.getBytes()));
      ((cmd0x346.ReqBody)localObject2).uint32_business_id.set(38);
    }
    for (;;)
    {
      localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
      ((ToServiceMsg)localObject1).addAttribute("sendFromNative", Boolean.valueOf(false));
      localObject2 = ((cmd0x346.ReqBody)localObject2).toByteArray();
      byte[] arrayOfByte = new byte[localObject2.length + 4];
      PkgTools.a(arrayOfByte, 0, localObject2.length + 4);
      PkgTools.a(arrayOfByte, 4, (byte[])localObject2, localObject2.length);
      if (localObject1 != null)
      {
        ((ToServiceMsg)localObject1).putWupBuffer(arrayOfByte);
        ((ToServiceMsg)localObject1).addAttribute("cookie", Long.valueOf(paramDataLineMsgRecord.sessionid));
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
        c((ToServiceMsg)localObject1);
      }
      return false;
      ((cmd0x346.ReqBody)localObject2).msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.fileUuid.getBytes()));
      ((cmd0x346.ReqBody)localObject2).uint32_business_id.set(3);
    }
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    Object localObject;
    Iterator localIterator;
    MessageRecord localMessageRecord;
    if (paramInt == 3)
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a();
        if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
        {
          localObject = ((DataLineMsgSetList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localIterator = ((DataLineMsgSet)((Iterator)localObject).next()).values().iterator();
            while (localIterator.hasNext())
            {
              localMessageRecord = (MessageRecord)localIterator.next();
              this.jdField_b_of_type_JavaUtilList.add(Long.valueOf(localMessageRecord.shmsgseq));
            }
          }
        }
      }
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Long)((Iterator)localObject).next()).longValue() != paramDataLineMsgRecord.shmsgseq);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_b_of_type_JavaUtilList.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
        bool2 = bool1;
        if (this.jdField_b_of_type_JavaUtilList.size() > 120)
        {
          this.jdField_b_of_type_JavaUtilList.remove(0);
          bool2 = bool1;
        }
      }
      return bool2;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a();
        if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
        {
          localObject = ((DataLineMsgSetList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localIterator = ((DataLineMsgSet)((Iterator)localObject).next()).values().iterator();
            while (localIterator.hasNext())
            {
              localMessageRecord = (MessageRecord)localIterator.next();
              this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localMessageRecord.shmsgseq));
            }
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Long)((Iterator)localObject).next()).longValue() != paramDataLineMsgRecord.shmsgseq);
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
        bool2 = bool1;
        if (this.jdField_a_of_type_JavaUtilList.size() <= 120) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList.remove(0);
        return bool1;
      }
    }
  }
  
  public boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    if (!paramDataLineMsgSet.isSingle()) {
      c(paramDataLineMsgSet.getGroupId());
    }
    int i1 = DataLineMsgRecord.getDevTypeBySet(paramDataLineMsgSet);
    Iterator localIterator = paramDataLineMsgSet.values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if (localDataLineMsgRecord.strMoloKey != null)
      {
        List localList = a().a(i1).a(localDataLineMsgRecord.strMoloKey);
        if ((localList == null) || (localList.size() == 1))
        {
          this.jdField_a_of_type_ComDatalineCoreMoloHandler.d(localDataLineMsgRecord.strMoloKey);
          if (QLog.isDevelopLevel()) {
            QLog.d("DataLineHandler", 4, "删除应用宝消息 sessionid[" + localDataLineMsgRecord.sessionid);
          }
        }
      }
    }
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).a(paramDataLineMsgSet) >= 0;
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("MessageSvc.PbSendMsg");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "manually receives a file . sessionlist");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramList.iterator();
    boolean bool1 = false;
    int i1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      i1 = DataLineMsgRecord.getDevTypeBySeId(((Long)localObject2).longValue());
      localObject3 = a().a().a(i1).b(((Long)localObject2).longValue());
      if (localObject3 != null)
      {
        ((DataLineMsgRecord)localObject3).fileMsgStatus = 0L;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).c(((DataLineMsgRecord)localObject3).msgId);
      }
      if ((localObject3 != null) && (((DataLineMsgRecord)localObject3).strMoloKey != null))
      {
        this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(((DataLineMsgRecord)localObject3).strMoloKey);
        bool1 = true;
      }
      for (;;)
      {
        break;
        localArrayList.add(localObject2);
      }
    }
    boolean bool2 = bool1;
    DataLineMsgRecord localDataLineMsgRecord;
    if (localArrayList.size() > 0)
    {
      localObject2 = null;
      Iterator localIterator = paramList.iterator();
      localObject3 = null;
      localObject1 = null;
      paramList = (List)localObject2;
      if (!localIterator.hasNext()) {
        break label474;
      }
      localObject2 = (Long)localIterator.next();
      i1 = DataLineMsgRecord.getDevTypeBySeId(((Long)localObject2).longValue());
      localDataLineMsgRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1).b(((Long)localObject2).longValue());
      if (localDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "uSessionID[" + localObject2 + "], prepareMsg: session not found");
        }
        bool2 = false;
      }
    }
    else
    {
      label286:
      return bool2;
    }
    if ((localDataLineMsgRecord.filename == null) || (localDataLineMsgRecord.filesize == 0L) || (localDataLineMsgRecord.md5 == null)) {
      return false;
    }
    Object localObject4 = a(localDataLineMsgRecord.sessionid);
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new ArrayList();
    }
    ((List)localObject2).add(localObject4);
    localObject4 = new FTNInfo();
    ((FTNInfo)localObject4).strFileIndex = localDataLineMsgRecord.serverPath;
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = new ArrayList();
    }
    ((List)localObject3).add(localObject4);
    localObject1 = new NFCInfo();
    ((NFCInfo)localObject1).dwServerIP = ((int)localDataLineMsgRecord.nServerIp);
    ((NFCInfo)localObject1).wServerPort = ((short)(int)localDataLineMsgRecord.nServerPort);
    ((NFCInfo)localObject1).vTokenKey = localDataLineMsgRecord.vTokenKey;
    ((NFCInfo)localObject1).vUrlNotify = localDataLineMsgRecord.vUrlNotify;
    if (paramList == null) {
      paramList = new ArrayList();
    }
    for (;;)
    {
      paramList.add(localObject1);
      localObject1 = localObject3;
      localObject3 = localObject2;
      break;
      label474:
      bool2 = bool1;
      if (localObject3 == null) {
        break label286;
      }
      localObject2 = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
      localObject3 = (Session[])((List)localObject3).toArray(new Session[((List)localObject3).size()]);
      paramList = (NFCInfo[])paramList.toArray(new NFCInfo[paramList.size()]);
      localObject1 = (FTNInfo[])((List)localObject1).toArray(new FTNInfo[((List)localObject1).size()]);
      if (localArrayList.size() == 1) {}
      for (bool1 = false;; bool1 = true)
      {
        ((LiteTransferWrapper)localObject2).RecvGroup((Session[])localObject3, paramList, (FTNInfo[])localObject1, bool1);
        return true;
      }
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(paramInt);
  }
  
  public void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 1) || (paramInt == 8))
    {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new pwq(this), 20000L);
    }
    a(paramInt, paramBoolean, paramObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = 0;
    MsgSCBody localMsgSCBody = new MsgSCBody();
    cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
    localMsgSCBody.uMsgType = 837;
    localMsgSCBody.bTimeOut = false;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      localMsgSCBody.bTimeOut = true;
    }
    if (paramFromServiceMsg == null) {}
    label125:
    label195:
    long l1;
    label202:
    int i2;
    do
    {
      localMsgSCBody.msgBody0x345 = new MsgSCBody0x345();
      paramFromServiceMsg = localMsgSCBody.msgBody0x345;
      if (localRspBody.uint32_sub_cmd.has()) {
        i1 = localRspBody.uint32_sub_cmd.get();
      }
      paramFromServiceMsg.uMsgSubType = i1;
      paramFromServiceMsg = localMsgSCBody.msgBody0x345;
      if (!localRspBody.uint32_return_code.has()) {
        break;
      }
      i1 = localRspBody.uint32_return_code.get();
      paramFromServiceMsg.uint32_return_code = i1;
      switch (localMsgSCBody.msgBody0x345.uMsgSubType)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "PBToMsgSCBody : msgtype is not cmd0x345[" + localMsgSCBody.msgBody0x345.uMsgSubType);
        }
        if (paramToServiceMsg != null) {
          break label374;
        }
        l1 = 0L;
        this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(Long.valueOf(l1).intValue(), localMsgSCBody);
        return;
        if (paramFromServiceMsg.getWupBuffer() == null) {
          break label392;
        }
        i2 = paramFromServiceMsg.getWupBuffer().length - 4;
      }
    } while (i2 < 0);
    byte[] arrayOfByte = new byte[i2];
    PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i2);
    label372:
    label374:
    label392:
    for (paramFromServiceMsg = arrayOfByte; paramFromServiceMsg != null; paramFromServiceMsg = null)
    {
      try
      {
        localRspBody.mergeFrom(paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      break;
      i1 = -1;
      break label125;
      if (localRspBody.msg_subcmd_0x6_rsp_body.has()) {}
      for (paramFromServiceMsg = (cmd0x345.RspBody.SubCmd0x6RspBody)localRspBody.msg_subcmd_0x6_rsp_body.get();; paramFromServiceMsg = null)
      {
        if (paramFromServiceMsg == null) {
          break label372;
        }
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody = new SubCmd0x6RspBody();
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody.str_file_id = paramFromServiceMsg.str_file_id.get();
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody.str_ret_msg = paramFromServiceMsg.str_ret_msg.get();
        break;
      }
      break label195;
      l1 = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
      break label202;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {}
    long l1;
    do
    {
      return;
      l1 = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
      paramInt = DataLineMsgRecord.getDevTypeBySeId(l1);
    } while (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt).b(l1) == null);
    new Handler(Looper.getMainLooper()).post(new pwt(this, paramFromServiceMsg, paramInt, l1));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "received a cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if ((!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PbSendMsg")) || (paramToServiceMsg.extraData.getInt("ROUNTING_TYPE") != 13) || (!paramToServiceMsg.extraData.getBoolean("ISFROM_DATALINE"))) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      int i1 = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x211C2CMessageError, retry = " + i1);
      }
      if (i1 < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i1 + 1);
        b(paramToServiceMsg);
        return;
      }
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_IPAD_STATE";
    if (this.jdField_c_of_type_Boolean)
    {
      localSharedPreferences.edit().putLong(str, this.jdField_b_of_type_Long).commit();
      return;
    }
    localSharedPreferences.edit().remove(str).commit();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("dl_ipad_online_notify", true);
  }
  
  public boolean b(int paramInt)
  {
    return this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt));
  }
  
  protected boolean b(int paramInt1, int paramInt2)
  {
    int i1 = AppSetting.jdField_a_of_type_Int;
    if ((paramInt1 == 1001) && ((paramInt2 == i1) || (paramInt2 == 0))) {}
    while (!QLog.isColorLevel()) {
      return true;
    }
    QLog.d("DataLineHandler", 2, "msgBody command not for android" + paramInt2 + " " + i1);
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.e(paramString);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>wifi lost cancel all task");
    }
    d(8);
  }
  
  public void c(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      if (!this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt)))
      {
        this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
        if (this.jdField_c_of_type_JavaUtilList.size() > 256) {
          this.jdField_c_of_type_JavaUtilList.remove(0);
        }
      }
      return;
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      if ((localPbSendMsgResp == null) || (!localPbSendMsgResp.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "handle0x211C2CMessageResp::server did not return a valid result code, use 4 instead.");
        }
        i1 = 4;
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x211C2CMessageResp: ---ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "----replyCode:" + i1);
        }
        switch (paramToServiceMsg.extraData.getInt("DATALINE_CMD"))
        {
        case 1002: 
        case 1006: 
        default: 
          
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "<---handle0x211C2CMessageResp::invalid.", localException);
        }
        Object localObject = null;
        continue;
        if (((msg_svc.PbSendMsgResp)localObject).result.get() != 0)
        {
          i1 = ((msg_svc.PbSendMsgResp)localObject).result.get();
          continue;
          e(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("cookie");
          if ((a(paramToServiceMsg.longValue()) == null) && (QLog.isColorLevel())) {
            QLog.d("DataLineHandler", 2, "uSessionID[" + paramToServiceMsg + "]" + "handleFileOperate: session not found");
          }
        }
        else
        {
          i1 = 0;
        }
      }
    }
  }
  
  public boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.b(paramString);
  }
  
  public void d()
  {
    long l1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(AppConstants.aj), 6000).time;
    QLog.d("DataLineHandler", 2, "sendDatalineReadConfirm last time[" + l1 + "]");
    ArrayList localArrayList;
    if ((l1 != 0L) && (l1 != this.jdField_c_of_type_Long))
    {
      localArrayList = new ArrayList();
      localArrayList.add(new Pair(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()), Long.valueOf(l1)));
      ((C2CMessageProcessor)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a("c2c_processor")).b(localArrayList);
      this.jdField_c_of_type_Long = l1;
    }
    l1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(AppConstants.ak), 6003).time;
    if ((l1 != 0L) && (l1 != this.d))
    {
      localArrayList = new ArrayList();
      localArrayList.add(new Pair(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()), Long.valueOf(l1)));
      ((C2CMessageProcessor)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a("c2c_processor")).b(localArrayList);
      this.d = l1;
    }
  }
  
  public void d(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void e()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a();
    DataLineMsgSet localDataLineMsgSet;
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          c(localDataLineMsgSet.getGroupId());
        }
      }
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(false);
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          c(localDataLineMsgSet.getGroupId());
        }
      }
    }
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.b();
  }
  
  public int f()
  {
    return ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).e();
  }
  
  public void g()
  {
    boolean bool2 = false;
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
      if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) || (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null))
        {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
        {
          AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "--->>close cancel all task");
        }
        if (this.jdField_a_of_type_JavaUtilTimer != null)
        {
          this.jdField_a_of_type_JavaUtilTimer.cancel();
          this.jdField_a_of_type_JavaUtilTimer = null;
        }
        d(32);
        boolean bool1 = bool2;
        Object localObject;
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          bool1 = bool2;
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0) != null)
          {
            localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a();
            bool1 = bool2;
            if (localObject != null)
            {
              bool1 = bool2;
              if (((DataLineMsgSetList)localObject).size() > 0)
              {
                localObject = ((DataLineMsgSetList)localObject).iterator();
                do
                {
                  bool1 = bool2;
                  if (!((Iterator)localObject).hasNext()) {
                    break;
                  }
                } while (!((DataLineMsgSet)((Iterator)localObject).next()).hasSendingOrRecving());
                bool1 = true;
              }
            }
          }
        }
        bool2 = bool1;
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          bool2 = bool1;
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1) != null)
          {
            localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a();
            bool2 = bool1;
            if (localObject != null)
            {
              bool2 = bool1;
              if (((DataLineMsgSetList)localObject).size() > 0)
              {
                localObject = ((DataLineMsgSetList)localObject).iterator();
                do
                {
                  bool2 = bool1;
                  if (!((Iterator)localObject).hasNext()) {
                    break;
                  }
                } while (!((DataLineMsgSet)((Iterator)localObject).next()).hasSendingOrRecving());
                bool2 = true;
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.endLiteTransfer(bool2);
        this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a();
        this.jdField_a_of_type_ComDatalineCoreMoloHandler.a();
        this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a();
        this.jdField_a_of_type_ComDatalineCoreDirectForwarder.a();
        return;
        localException1 = localException1;
        QLog.e("DataLineHandler", 1, "onDestroy fail unregisterReceiver exitReceiver:" + localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("DataLineHandler", 1, "onDestroy fail unregisterReceiver sdCardReceiver:" + localException2);
        }
      }
    }
  }
  
  public boolean getAutoDownload()
  {
    return a().getPreferences().getBoolean("auto_receive_files", false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\DataLineHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */