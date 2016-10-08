package com.tencent.device.file;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.FTNNotify;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x211;
import com.tencent.litetransfersdk.MsgCSBody0x211_0x7;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import jxi;

public class DeviceFileHandler
  extends RouterHandler
  implements INetEngine.INetEngineListener
{
  public static final int A = 2;
  public static final int B = 3;
  public static final int C = -5103058;
  protected static final int D = 10;
  public static final int a = -1;
  protected static final String a = "Device.file";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  public static final int o = 14;
  public static final int p = 15;
  public static final int q = 16;
  public static final int r = 17;
  public static final int s = 18;
  public static final int t = 19;
  public static final int u = 20;
  public static final int v = 21;
  public static final int w = 22;
  public static final int x = 23;
  public static final int y = 0;
  public static final int z = 1;
  Handler jdField_a_of_type_AndroidOsHandler;
  private DeviceFileHandler.DeviceNotifyReceiver jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected HashMap a;
  protected HashSet a;
  protected HashMap b;
  protected HashSet b;
  protected HashMap c;
  
  public DeviceFileHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidOsHandler = new jxi(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = "Device";
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.c = new HashMap();
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("SmartDevice_OnMiniFileTransferComplete");
    paramQQAppInterface.addAction("SmartDevice_OnMiniFileTransferProgress");
    paramQQAppInterface.addAction("SmartDevice_OnDataPointFileMsgProgress");
    paramQQAppInterface.addAction("SmartDevice_OnDataPointFileMsgSendRet");
    paramQQAppInterface.addAction("CloudPrintJobNotifyEvent");
    this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver = new DeviceFileHandler.DeviceNotifyReceiver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().registerReceiver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver, paramQQAppInterface);
  }
  
  private long a(byte[] paramArrayOfByte, MsgCSBody paramMsgCSBody, Long paramLong)
  {
    try
    {
      paramArrayOfByte = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
        }
        return 0L;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      paramMsgCSBody.uMsgType = 529;
      paramMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
      paramMsgCSBody.msgBody0x211.uMsgSubType = 7;
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 1;
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramArrayOfByte.uint32_appid.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramArrayOfByte.uint32_instid.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramArrayOfByte.uint64_src_uin.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_uin_type = paramArrayOfByte.uint32_uin_type.get();
      paramLong = new ArrayList();
      FTNNotify localFTNNotify = new FTNNotify();
      localFTNNotify.uint64_sessionid = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
      localFTNNotify.str_file_name = paramArrayOfByte.str_file_name.get();
      localFTNNotify.str_file_index = new String(paramArrayOfByte.bytes_file_index.get().toByteArray());
      localFTNNotify.bytes_file_md5 = paramArrayOfByte.bytes_file_md5.get().toByteArray();
      localFTNNotify.uint64_file_len = paramArrayOfByte.uint64_file_length.get();
      localFTNNotify.bytes_originfile_md5 = paramArrayOfByte.bytes_file_md5.get().toByteArray();
      localFTNNotify.uint32_originfiletype = 0;
      localFTNNotify.uint32_group_id = 0;
      localFTNNotify.uint32_group_size = 0;
      localFTNNotify.uint32_group_curindex = 0;
      localFTNNotify.msg_ActionInfo = new ActionInfo();
      localFTNNotify.msg_ActionInfo.strServiceName = this.jdField_b_of_type_JavaLangString;
      localFTNNotify.msg_ActionInfo.vServiceInfo = null;
      localFTNNotify.uint32_batchID = 0;
      localFTNNotify.uint32_groupflag = 0;
      long l1 = localFTNNotify.uint64_sessionid;
      paramLong.add(localFTNNotify);
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])paramLong.toArray(new FTNNotify[paramLong.size()]));
      return localFTNNotify.uint64_sessionid;
    }
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    QLog.d("Device.file", 1, "OnSessionComplete uSessionID=" + paramLong + " retCode=" + paramInt2 + " TaskStatus=" + paramInt1);
    Session localSession = (Session)this.e.get(Long.valueOf(paramLong));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionComplete no session for uSessionID=" + paramLong);
      }
      return;
    }
    if (paramInt1 == 2) {}
    for (;;)
    {
      super.a(103, bool, localSession);
      return;
      bool = false;
    }
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))
    {
      if (paramSession.actionInfo.vServiceInfo != null) {}
      do
      {
        try
        {
          DeviceProto.MsgActionInfo localMsgActionInfo = (DeviceProto.MsgActionInfo)new DeviceProto.MsgActionInfo().mergeFrom(paramSession.actionInfo.vServiceInfo);
          if (localMsgActionInfo == null)
          {
            QLog.w("Device.file", 1, "OnSessionNew decode bussiness name error");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          Object localObject;
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
            localObject = null;
          }
          paramSession.actionInfo.strServiceName = ((DeviceProto.MsgActionInfo)localObject).str_bussiness_name.get();
          paramSession.actionInfo.vServiceInfo = ((DeviceProto.MsgActionInfo)localObject).bytes_buff_with_file.get().toByteArray();
        }
        this.e.put(Long.valueOf(paramSession.uSessionID), paramSession);
      } while (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramSession.uSessionID)));
      if ((!paramSession.bSend) && ((DeviceMsgHandle.d.equalsIgnoreCase(paramSession.actionInfo.strServiceName)) || (DeviceMsgHandle.l.equalsIgnoreCase(paramSession.actionInfo.strServiceName)) || (DeviceMsgHandle.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramSession.actionInfo.strServiceName))))
      {
        super.a(paramSession, paramNFCInfo, paramFTNInfo, false);
        super.b(paramSession);
      }
      super.a(100, true, paramSession);
    }
    QLog.d("Device.file", 1, "OnSessionNew uSessionID=" + paramSession.uSessionID + " bussiness=" + paramSession.actionInfo.strServiceName);
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "OnSessionProgress uSessionID=" + paramLong1 + "=====" + (float)((float)paramLong2 * 1.0D / paramLong3));
    }
    Session localSession = (Session)this.e.get(Long.valueOf(paramLong1));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionProgress no session for uSessionID=" + paramLong1);
      }
      return;
    }
    super.a(102, true, new Object[] { localSession, Float.valueOf((float)((float)paramLong2 * 1.0D / (float)paramLong3)) });
  }
  
  public void OnSessionStart(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "OnSessionStart uSessionID=" + paramLong);
    }
    Session localSession = (Session)this.e.get(Long.valueOf(paramLong));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionStart no session for uSessionID=" + paramLong);
      }
      return;
    }
    super.a(101, true, localSession);
  }
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString) {}
  
  public int a(long paramLong)
  {
    int i1 = 0;
    if (this.c.containsKey(Long.valueOf(paramLong)))
    {
      i1 = ((Integer)this.c.get(Long.valueOf(paramLong))).intValue();
      this.c.remove(Long.valueOf(paramLong));
    }
    return i1;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    if (paramInt1 == 3) {
      l1 = ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(paramString, paramInt2);
    }
    return l1;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    if (paramInt1 == 1)
    {
      paramQQAppInterface = new MsgCSBody();
      l1 = a(Base64.decode(paramString1, 2), paramQQAppInterface, Long.valueOf(0L));
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l1));
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramQQAppInterface);
    }
    do
    {
      return l1;
      if (paramInt1 == 2)
      {
        l1 = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
        paramString2 = MD5Utils.d(paramString1) + paramString1.substring(paramString1.lastIndexOf("."));
        paramString2 = AppConstants.bj + "smartdevice/" + paramString2;
        if (FileUtils.b(paramString2))
        {
          paramQQAppInterface = new Message();
          paramQQAppInterface.what = 0;
          paramString1 = new Session();
          paramString1.uSessionID = l1;
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(paramString1, DeviceMsgHandle.g, null);
          paramString1.strFilePathSrc = paramString2;
          paramString1.uFileSizeSrc = FileUtils.a(paramString2);
          paramQQAppInterface.obj = paramString1;
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramQQAppInterface, 100L);
          return l1;
        }
        Object localObject = new Session();
        ((Session)localObject).uSessionID = l1;
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, DeviceMsgHandle.g, null);
        this.e.put(Long.valueOf(l1), localObject);
        a(101, true, localObject);
        localObject = new HttpNetReq();
        ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
        ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((HttpNetReq)localObject).c = 0;
        ((HttpNetReq)localObject).jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), localObject);
        paramQQAppInterface.a(0).a((NetReq)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        return l1;
      }
    } while (paramInt1 != 3);
    l1 = ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(paramString1, paramString2, paramInt2);
    paramQQAppInterface = new Session();
    paramQQAppInterface.uSessionID = l1;
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(paramQQAppInterface, DeviceMsgHandle.g, null);
    this.e.put(Long.valueOf(l1), paramQQAppInterface);
    a(101, true, paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(l1));
    return l1;
  }
  
  public DeviceProto.MsgFileKey a(String paramString)
  {
    try
    {
      paramString = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(Base64.decode(paramString, 2));
      if ((paramString == null) && (QLog.isColorLevel())) {
        QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
      }
      return paramString;
    }
    catch (InvalidProtocolBufferMicroException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public Session a(Session paramSession)
  {
    Session localSession = new Session();
    localSession.uSessionID = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
    localSession.emFileType = paramSession.emFileType;
    localSession.strFileNameSrc = paramSession.strFileNameSrc;
    localSession.uFileSizeSrc = paramSession.uFileSizeSrc;
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, DeviceMsgHandle.c, null);
    this.e.put(Long.valueOf(localSession.uSessionID), localSession);
    return localSession;
  }
  
  public Session a(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "send file path=" + paramString1 + " servicename=" + paramString2 + " to " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    Session localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, paramString1, null, 0, 0, 0L, 0, 0, 0);
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "session create failed");
      }
      return null;
    }
    int i1;
    if (paramString2.equalsIgnoreCase(DeviceMsgHandle.c))
    {
      i1 = 2251;
      switch (FileManagerUtil.a(paramString1))
      {
      default: 
        localSession.uSessionID = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 3, i1);
        localSession.emFileType = i1;
        localSession.strFileNameSrc = FileManagerUtil.a(paramString1);
        localSession.uFileSizeSrc = FileUtils.a(paramString1);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, DeviceMsgHandle.c, null);
        this.e.put(Long.valueOf(localSession.uSessionID), localSession);
        a(101, true, localSession);
      }
    }
    for (;;)
    {
      return localSession;
      i1 = 2154;
      break;
      i1 = 2201;
      break;
      i1 = 2108;
      break;
      localArrayList.add(localSession);
      localSession.uSessionID = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
      localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong);
      paramString1 = new DeviceProto.MsgActionInfo();
      paramString1.str_bussiness_name.set(paramString2);
      if (paramArrayOfByte != null) {
        paramString1.bytes_buff_with_file.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      paramString1 = paramString1.toByteArray();
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, this.jdField_b_of_type_JavaLangString, paramString1);
      if (localArrayList.size() > 0) {
        super.a(localArrayList, false);
      }
    }
  }
  
  protected Class a()
  {
    return DeviceFileObserver.class;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          if ((((Long)((Map.Entry)localObject).getKey()).longValue() != paramLong) && (((HttpNetReq)((Map.Entry)localObject).getValue()).jdField_a_of_type_JavaLangString.equals(((HttpNetReq)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b((NetReq)((Map.Entry)localObject).getValue());
            localObject = (Session)this.e.get(((Map.Entry)localObject).getKey());
            if (localObject != null) {
              break;
            }
          }
        }
      }
    }
    while (this.jdField_b_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong)))
    {
      for (;;)
      {
        Iterator localIterator;
        Object localObject;
        return;
        super.a(103, false, localObject);
        localIterator.remove();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b((NetReq)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)));
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
      return;
    }
    super.a(paramInt, paramLong, paramBoolean);
  }
  
  public void a(Session paramSession)
  {
    if (paramSession != null) {
      this.e.put(Long.valueOf(paramSession.uSessionID), paramSession);
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((HttpNetReq)localEntry.getValue()).jdField_a_of_type_JavaLangString.equals(((HttpNetReq)paramNetReq).jdField_a_of_type_JavaLangString)) {
        if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramNetReq)) {
          break label230;
        }
      }
    }
    label230:
    for (int i1 = ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramNetReq)).intValue();; i1 = 0)
    {
      if (i1 < 10)
      {
        this.jdField_b_of_type_JavaUtilHashMap.put((HttpNetReq)paramNetReq, Integer.valueOf(i1 + 1));
        break;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put((HttpNetReq)paramNetReq, Integer.valueOf(0));
      Session localSession = (Session)this.e.get(localEntry.getKey());
      if (localSession == null) {
        return;
      }
      localSession.uSessionID = ((Long)localEntry.getKey()).longValue();
      if (localSession.uFileSizeSrc == 0L) {
        localSession.uFileSizeSrc = paramLong2;
      }
      super.a(102, true, new Object[] { localSession, Float.valueOf((float)((float)paramLong1 * 1.0D / (float)paramLong2)) });
      break;
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.e == 3) {}
    Iterator localIterator;
    label22:
    Object localObject;
    do
    {
      return;
      localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (!((HttpNetReq)((Map.Entry)localObject).getValue()).jdField_a_of_type_JavaLangString.equals(((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString));
      localObject = (Session)this.e.get(((Map.Entry)localObject).getKey());
    } while (localObject == null);
    ((Session)localObject).strFilePathSrc = paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString;
    ((Session)localObject).uFileSizeSrc = paramNetResp.jdField_a_of_type_Long;
    if (paramNetResp.e == 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.a(103, bool, localObject);
      localIterator.remove();
      break label22;
      break;
    }
  }
  
  public void g()
  {
    super.g();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver);
      this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver = null;
    }
  }
  
  public boolean getAutoDownload()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\file\DeviceFileHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */