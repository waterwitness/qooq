package com.tencent.mobileqq.qcall;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.PstnNumberManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phone.PhoneNumberInfo;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.manager.TicketManager;
import tencent.im.cs.longconn.hd_video.CmdPSTNCallbackNotifyAccept;
import tencent.im.cs.longconn.hd_video.CmdPSTNCallbackNotifyLogout;
import tencent.im.cs.longconn.hd_video.MsgBody;
import tencent.im.cs.longconn.hd_video.VideoHead;
import tencent.im.cs.longconn.voip.hd_video_voip_2.BalanceAccount;
import tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneBindReqBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneBindRspBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneCancelCallBackReqBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.ReqBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.RspBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.TelInfo;
import tencent.im.cs.longconn.voip.hd_video_voip_2.VoipHead;
import tencent.im.oidb.cmd0x4f1.oidb_0x4f1.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class PstnHandler
  extends BusinessHandler
{
  private static final int A = 42008;
  private static final int B = 26015;
  private static final int C = 26013;
  private static int D = 1;
  private static int H = 2;
  private static int I = 3;
  private static int J = 6;
  public static final int a = 1;
  public static final String a = "OidbSvc.0x4ff_75";
  public static final int b = 2;
  public static final String b = "OidbSvc.0x5eb_47";
  public static final int c = 3;
  public static final String c = "OidbSvc.0x4f1_0";
  public static final int d = 4;
  public static final String d = "selfPhoneNum";
  public static final int e = 5;
  public static final String e = "phoneNum";
  public static final int f = 6;
  public static final String f = "uinType";
  public static final int g = 7;
  public static final String g = "peerUin";
  public static final int h = 8;
  public static final String h = "isCallTypeReq";
  public static final int i = 9;
  private static final String i = "PstnHandler";
  public static final int j = 10;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public static final int n = 4;
  public static final int o = 5;
  public static final int p = 6;
  public static final int q = 7;
  public static final int r = 8;
  public static final int s = 30000;
  private static final int t = 42005;
  private static final int u = 42006;
  private static final int v = 26014;
  private static final int w = 26012;
  private static final int x = 42012;
  private static final int y = 42011;
  private static final int z = 42007;
  private SparseIntArray a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PstnHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(1, 42005);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(2, 42006);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(3, 26014);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(4, 26012);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(5, 42012);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(6, 42011);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(7, 42007);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(8, 42008);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(9, 26015);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(10, 26013);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 2, "PSTNHandler sendSharpPstnCallbackAck");
    }
    ToServiceMsg localToServiceMsg = super.a("SharpSvr.s2cackpstncallback");
    localToServiceMsg.putWupBuffer(paramArrayOfByte);
    localToServiceMsg.setNeedCallback(false);
    super.b(localToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        int i1;
        boolean bool2;
        boolean bool1;
        paramFromServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PstnHandler", 2, "sso merge error");
        }
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
    {
      i1 = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("PstnHandler", 2, "handle_oidb_0x4ff_75 ret=" + i1);
      }
      if ((i1 == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        i1 = paramToServiceMsg.length;
        bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.i("PstnHandler", 2, " ==== handleSetPstnInfo  success === ");
        }
        bool1 = bool2;
        if (4 > i1) {
          break label206;
        }
        paramToServiceMsg = String.valueOf(PkgTools.a(paramToServiceMsg, 0));
        if (paramToServiceMsg != null)
        {
          bool1 = bool2;
          if (paramToServiceMsg.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
            break label206;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.w("PstnHandler", 2, "handleSetPstnInfo uin error");
        }
      }
    }
    bool1 = false;
    label206:
    if (bool1) {
      a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    super.a(2, bool1, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    bool3 = false;
    bool2 = false;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder().append(" === handleGetPstnCardInfo isSuccess:　").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label81;
      }
    }
    label81:
    for (int i1 = paramArrayOfByte.length;; i1 = -1)
    {
      QLog.d("PstnHandler", 2, i1);
      if (paramArrayOfByte != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PstnHandler", 2, " === handleGetPstnCardInfo === data is null ====");
      }
      return;
    }
    Object localObject3 = null;
    localObject2 = null;
    paramToServiceMsg = null;
    localObject1 = localObject3;
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramArrayOfByte = new oidb_0x5eb.RspBody();
          paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramArrayOfByte.rpt_msg_uin_data.size() <= 0) {
            continue;
          }
          paramToServiceMsg = new PstnCardInfo();
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = bool3;
        paramToServiceMsg = (ToServiceMsg)localObject2;
        localObject1 = paramToServiceMsg;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PstnHandler", 2, "OidbSvc.0x5eb_47 merge error " + paramFromServiceMsg.toString());
        localObject1 = paramToServiceMsg;
        bool1 = bool2;
        continue;
        bool1 = false;
        localObject1 = paramToServiceMsg;
        continue;
      }
      try
      {
        paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(0);
        paramToServiceMsg.uin = String.valueOf(paramFromServiceMsg.uint64_uin.get());
        paramToServiceMsg.pstn_c2c_vip = paramFromServiceMsg.uint32_pstn_c2c_vip.get();
        paramToServiceMsg.pstn_multi_vip = paramFromServiceMsg.uint32_pstn_multi_vip.get();
        paramToServiceMsg.pstn_c2c_try_status = paramFromServiceMsg.uint32_pstn_c2c_try_flag.get();
        paramToServiceMsg.pstn_multi_try_status = paramFromServiceMsg.uint32_pstn_multi_try_flag.get();
        paramToServiceMsg.pstn_ever_c2c_vip = paramFromServiceMsg.uint32_pstn_ever_c2c_vip.get();
        paramToServiceMsg.pstn_ever_multi_vip = paramFromServiceMsg.uint32_pstn_ever_multi_vip.get();
        paramToServiceMsg.pstn_c2c_call_time = paramFromServiceMsg.uint32_pstn_c2c_call_time.get();
        paramToServiceMsg.pstn_multi_call_time = paramFromServiceMsg.uint32_pstn_multi_call_time.get();
        paramToServiceMsg.pstn_c2c_last_guide_recharge_time = paramFromServiceMsg.uint32_pstn_c2c_last_guide_recharge_time.get();
        paramToServiceMsg.pstn_multi_last_guide_recharge_time = paramFromServiceMsg.uint32_pstn_multi_last_guide_recharge_time.get();
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = bool3;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PstnHandler", 2, "OidbSvc.0x5eb_47,handleGetPstnCardInfo, " + paramToServiceMsg.toString());
        }
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          paramFromServiceMsg = (PstnManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.a(paramToServiceMsg);
          }
        }
        bool1 = true;
        localObject1 = paramToServiceMsg;
        super.a(1, bool1, localObject1);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = true;
        continue;
      }
      localObject1 = localObject3;
      bool1 = bool2;
      if (paramFromServiceMsg.uint32_result.has())
      {
        QLog.i("PstnHandler", 1, " === handleGetPstnCardInfo : result | " + paramFromServiceMsg.uint32_result.get());
        localObject1 = localObject3;
        bool1 = bool2;
      }
    }
  }
  
  protected Class a()
  {
    return PstnObserver.class;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (PstnManager localPstnManager = (PstnManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);; localPstnManager = null)
    {
      long l1;
      if (localPstnManager != null)
      {
        l1 = System.currentTimeMillis();
        if ((localPstnManager.jdField_a_of_type_Long == 0L) || (l1 / 1000L - localPstnManager.jdField_a_of_type_Long > localPstnManager.jdField_a_of_type_Int))
        {
          localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
          if (localObject == null) {
            break label201;
          }
        }
      }
      label201:
      for (Object localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());; localObject = null)
      {
        if (localObject == null)
        {
          QLog.d("PstnHandler", 1, " get skey failed");
          return;
        }
        QLog.i("PstnHandler", 1, " === sendGetPstnSwitch === ");
        localPstnManager.jdField_a_of_type_Long = (l1 / 1000L);
        oidb_0x4f1.ReqBody localReqBody = new oidb_0x4f1.ReqBody();
        if (localPstnManager.a() != null) {
          localReqBody.bytes_cookies.set(localPstnManager.a());
        }
        localReqBody.bytes_skey.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
        super.b(super.a("OidbSvc.0x4f1_0", 1265, 0, localReqBody.toByteArray()));
        return;
        QLog.d("PstnHandler", 1, " req pstn gray flag time is too short");
        return;
        QLog.d("PstnHandler", 1, " req pstn gray flag pstnManager is null ");
        return;
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a();
    super.a(3, true, new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(SparseIntArray paramSparseIntArray, List paramList1, List paramList2)
  {
    int i5 = 0;
    if (((paramSparseIntArray == null) || (paramSparseIntArray.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      QLog.i("PstnHandler", 1, " set pstn info is null || size is 0");
      return;
    }
    for (;;)
    {
      int i4;
      ByteBuffer localByteBuffer;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QLog.i("PstnHandler", 1, "===== sendSetPstnInfo ====");
        if ((paramSparseIntArray == null) || (paramSparseIntArray.size() <= 0)) {
          break label480;
        }
        i1 = (short)(paramSparseIntArray.size() + 0);
        i3 = i1 * 6 + 0;
        i4 = i3;
        int i2 = i1;
        if (paramList1 != null)
        {
          i4 = i3;
          i2 = i1;
          if (paramList2.size() > 0)
          {
            i4 = paramList2.size();
            i2 = (short)(i1 + i4);
            i4 = i3 + i4 * 8;
          }
        }
        localByteBuffer = ByteBuffer.allocate(i4 + 7);
        localByteBuffer.putInt(Utils.a(l1)).put((byte)0).putShort(i2);
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        if (paramSparseIntArray == null) {
          break label316;
        }
        i3 = 0;
        if (i3 >= paramSparseIntArray.size()) {
          break label316;
        }
        i4 = paramSparseIntArray.keyAt(i3);
        int i6 = paramSparseIntArray.valueAt(i3);
        localArrayList1.add(Integer.valueOf(i4));
        localArrayList2.add(Integer.valueOf(i6));
        localByteBuffer.putShort((short)this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i4));
        localByteBuffer.putShort((short)2);
        localByteBuffer.putShort((short)i6);
        i3 += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramSparseIntArray) {}
      QLog.w("PstnHandler", 2, "OidbSvc.0x4ff_75 error", paramSparseIntArray);
      return;
      label316:
      if ((paramList1 != null) && (paramList2 != null))
      {
        i3 = i5;
        while (i3 < paramList1.size())
        {
          i4 = ((Integer)paramList1.get(i3)).intValue();
          i5 = ((Integer)paramList2.get(i3)).intValue();
          localArrayList1.add(Integer.valueOf(i4));
          localArrayList2.add(Integer.valueOf(i5));
          localByteBuffer.putShort((short)this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i4));
          localByteBuffer.putShort((short)4);
          localByteBuffer.putInt(i5);
          i3 += 1;
        }
      }
      paramSparseIntArray = super.a("OidbSvc.0x4ff_75", 1279, 75, localByteBuffer.array());
      paramSparseIntArray.extraData.putIntegerArrayList("type_pstn", localArrayList1);
      paramSparseIntArray.extraData.putIntegerArrayList("value_pstn", localArrayList2);
      super.b(paramSparseIntArray);
      return;
      label480:
      int i3 = 0;
      int i1 = 0;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("PstnHandler", 2, " req is null || res is null");
      }
    }
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if (QLog.isColorLevel()) {
        QLog.i("PstnHandler", 2, "onReceive: cmd=" + str);
      }
      if ("OidbSvc.0x5eb_47".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_75".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f1_0".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
      if ("im_sso_sharp.sharp_cs_voip".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
    } while (!"SharpSvr.s2cpstncallback".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 1, "im_sso_sharp.sharp_cs_voip " + paramFromServiceMsg.isSuccess());
    }
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isCallTypeReq", false);
    String str1 = paramToServiceMsg.extraData.getString("phoneNum");
    String str2 = paramToServiceMsg.extraData.getString("selfPhoneNum");
    int i5 = paramToServiceMsg.extraData.getInt("uinType");
    String str3 = paramToServiceMsg.extraData.getString("peerUin");
    boolean bool2 = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.e("PstnHandler", 2, "handleCallTypeRsp, isCalltypeReq=" + bool1 + ", isSuccess=" + bool2);
    }
    if (!bool1) {
      return;
    }
    Object localObject;
    if (bool2)
    {
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (QLog.isColorLevel()) {
        QLog.e("PstnHandler", 2, "handleCallTypeRsp, wupBuffer.length=" + paramFromServiceMsg.length);
      }
      if (paramFromServiceMsg.length >= 4)
      {
        paramToServiceMsg = new byte[paramFromServiceMsg.length - 4];
        PkgTools.a(paramToServiceMsg, 0, paramFromServiceMsg, 4, paramFromServiceMsg.length - 4);
        localObject = new hd_video_voip_2.RspBody();
      }
    }
    for (;;)
    {
      int i6;
      try
      {
        ((hd_video_voip_2.RspBody)localObject).mergeFrom(paramToServiceMsg);
        if (!((hd_video_voip_2.RspBody)localObject).msg_voip_head.has()) {
          break label979;
        }
        l1 = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint64_uin.get();
        l2 = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint64_seq.get();
        i1 = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint32_cmd.get();
        i6 = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint32_error_no.get();
        l3 = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint32_term_type.get();
        paramToServiceMsg = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.bytes_build_ver.get().toByteArray();
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          long l2;
          long l3;
          paramToServiceMsg = new String(paramToServiceMsg, "utf-8");
          if (QLog.isColorLevel()) {
            QLog.d("PstnHandler", 2, "handleCallTypeRsp, uin:" + l1 + ", msgSeq:" + l2 + ", cmdType:" + i1 + ", sharpErrorCode:" + i6 + ", terminalType:" + l3 + ", version:" + paramToServiceMsg);
          }
          if (i6 == 0)
          {
            i4 = 1;
            if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.has()) {
              break label1023;
            }
            i2 = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_call_type.get();
            l1 = 0L;
            if (((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint64_call_id.has()) {
              l1 = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint64_call_id.get();
            }
            if (((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_id.has())
            {
              paramToServiceMsg = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_id.get().toByteArray();
              try
              {
                paramToServiceMsg = new String(paramToServiceMsg, "utf-8");
                if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_prompt.has()) {
                  continue;
                }
                paramFromServiceMsg = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_prompt.get().toByteArray();
              }
              catch (Exception paramToServiceMsg)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("PstnHandler", 2, "handleCallTypeRsp, callbackId parse failed");
                }
              }
            }
            else
            {
              try
              {
                paramFromServiceMsg = new String(paramFromServiceMsg, "utf-8");
                if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_phone.has()) {
                  continue;
                }
                paramArrayOfByte = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_phone.get().toByteArray();
              }
              catch (Exception paramFromServiceMsg)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("PstnHandler", 2, "handleCallTypeRsp, callbackPrompt parse failed");
                }
              }
            }
            try
            {
              paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
              if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_ability.has()) {
                break label1017;
              }
              i1 = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_ability.get();
              if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_call_phone_type.has()) {
                break label1002;
              }
              i4 = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_call_phone_type.get();
              i3 = i2;
              i2 = i1;
              i1 = i3;
              localObject = UinUtils.a(l1);
              if (QLog.isColorLevel()) {
                QLog.d("PstnHandler", 2, "handleCallTypeRsp, callType:" + i1 + ", peerCallIdString:" + (String)localObject + ", peerCallId:" + l1 + ", callbackId:" + paramToServiceMsg + ", callbackPrompt:" + paramFromServiceMsg + ", callbackPhone:" + paramArrayOfByte + ", ability:" + i2 + ", phoneNumType:" + i4);
              }
              if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b != -1) {
                continue;
              }
              a(str2, str1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), i5, str3, paramToServiceMsg);
              return;
            }
            catch (Exception paramArrayOfByte)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("PstnHandler", 2, "handleCallTypeRsp, callbackPhone parse failed");
            }
            paramToServiceMsg = paramToServiceMsg;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PstnHandler", 2, "im_sso_sharp.sharp_cs_voip merge error ", paramToServiceMsg);
          }
        }
        catch (Exception paramToServiceMsg)
        {
          int i4;
          if (QLog.isColorLevel()) {
            QLog.e("PstnHandler", 2, "handleCallTypeRsp, version parse failed");
          }
          paramToServiceMsg = "";
          continue;
          paramToServiceMsg = null;
          continue;
          paramFromServiceMsg = null;
          continue;
          paramArrayOfByte = null;
          continue;
          paramToServiceMsg = new PstnHandler.CallTypeRspParam(i6, i1, l1, paramToServiceMsg, paramFromServiceMsg, paramArrayOfByte, i2, str1, i4);
          PstnNumberManager.a(paramArrayOfByte, i4);
          super.a(5, true, paramToServiceMsg);
          return;
        }
      }
      super.a(5, false, Integer.valueOf(i6));
      return;
      label979:
      if (QLog.isColorLevel()) {
        QLog.e("PstnHandler", 2, "handleCallTypeRsp, no handle return false");
      }
      super.a(5, false, null);
      return;
      label1002:
      int i3 = i1;
      int i1 = i2;
      int i2 = i3;
      continue;
      label1017:
      i1 = 0;
      continue;
      label1023:
      i2 = 0;
      paramArrayOfByte = null;
      paramFromServiceMsg = null;
      i1 = 0;
      long l1 = 0L;
      paramToServiceMsg = null;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.d("PstnHandler", 1, " sendGetPstnInfo uin is null ");
    }
    do
    {
      return;
      oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
      try
      {
        long l1 = Long.parseLong(paramString);
        if (QLog.isColorLevel()) {
          QLog.w("PstnHandler", 2, " === sendGetPstnCardInfor === uin:  " + paramString + " ====");
        }
        localReqBody.rpt_uint64_uins.add(Long.valueOf(l1));
        localReqBody.uint32_req_pstn_c2c_vip.set(1);
        localReqBody.uint32_req_pstn_multi_vip.set(1);
        localReqBody.uint32_req_pstn_c2c_call_time.set(1);
        localReqBody.uint32_req_pstn_multi_call_time.set(1);
        localReqBody.uint32_req_pstn_c2c_try_flag.set(1);
        localReqBody.uint32_req_pstn_multi_try_flag.set(1);
        localReqBody.uint32_req_pstn_ever_c2c_vip.set(1);
        localReqBody.uint32_req_pstn_ever_multi_vip.set(1);
        localReqBody.uint32_req_pstn_c2c_last_guide_recharge_time.set(1);
        localReqBody.uint32_req_pstn_multi_last_guide_recharge_time.set(1);
        super.b(super.a("OidbSvc.0x5eb_47", 1515, 47, localReqBody.toByteArray()));
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.w("PstnHandler", 2, "send_query_pstn error", paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    long l1 = PstnUtils.a(paramString3);
    long l2 = PstnUtils.a(paramString4);
    Object localObject1 = new hd_video_voip_2.VoipHead();
    ((hd_video_voip_2.VoipHead)localObject1).uint64_uin.set(l1);
    Object localObject2 = ((hd_video_voip_2.VoipHead)localObject1).uint64_seq;
    int i1 = MobileQQService.c;
    MobileQQService.c = i1 + 1;
    ((PBUInt64Field)localObject2).set(i1);
    ((hd_video_voip_2.VoipHead)localObject1).uint32_cmd.set(1);
    ((hd_video_voip_2.VoipHead)localObject1).bytes_build_ver.set(ByteStringMicro.copyFromUtf8("6.5.5"));
    ((hd_video_voip_2.VoipHead)localObject1).uint32_term_type.set(4);
    ((hd_video_voip_2.VoipHead)localObject1).int32_sub_service_type.set(7000);
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 2, "REQ_TYPE_PSTN_DOUBLE: toPhone=" + paramString2 + ", toUin=" + paramString4 + ", fromPhone=" + paramString1 + ", fromUin=" + paramString3 + ", uinType=" + paramInt + ", seq=" + MobileQQService.c);
    }
    paramString3 = new hd_video_voip_2.TelInfo();
    Object localObject3 = PhoneNumberUtil.a(paramString1);
    paramString3.bytes_nation.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject3).a));
    paramString3.bytes_prefix.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject3).b));
    paramString3.bytes_mobile.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject3).c));
    paramString3.uint64_uin.set(l1);
    paramString3.uint64_uin_type.set(D);
    localObject2 = new hd_video_voip_2.TelInfo();
    if (!TextUtils.isEmpty(paramString2))
    {
      PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(paramString2);
      if (!TextUtils.isEmpty(localPhoneNumberInfo.a))
      {
        ((hd_video_voip_2.TelInfo)localObject2).bytes_nation.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.a));
        if (!TextUtils.isEmpty(localPhoneNumberInfo.b)) {
          ((hd_video_voip_2.TelInfo)localObject2).bytes_prefix.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.b));
        }
        ((hd_video_voip_2.TelInfo)localObject2).bytes_mobile.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.c));
      }
    }
    else
    {
      ((hd_video_voip_2.TelInfo)localObject2).uint64_uin.set(l2);
      if (paramInt != 0) {
        break label674;
      }
      ((hd_video_voip_2.TelInfo)localObject2).uint64_uin_type.set(D);
    }
    for (;;)
    {
      localObject3 = new hd_video_voip_2.CmdPhoneBindReqBody();
      ((hd_video_voip_2.CmdPhoneBindReqBody)localObject3).uint32_from_flag.set(1);
      ((hd_video_voip_2.CmdPhoneBindReqBody)localObject3).msg_from_tel.set(paramString3);
      ((hd_video_voip_2.CmdPhoneBindReqBody)localObject3).msg_to_tel.set((MessageMicro)localObject2);
      ((hd_video_voip_2.CmdPhoneBindReqBody)localObject3).uint32_call_policy.set(0);
      paramString3 = new hd_video_voip_2.BalanceAccount();
      paramString3.uint32_from_app.set(2);
      paramString3.uint32_account_type.set(1);
      localObject2 = new hd_video_voip_2.ReqBody();
      ((hd_video_voip_2.ReqBody)localObject2).msg_voip_head.set((MessageMicro)localObject1);
      ((hd_video_voip_2.ReqBody)localObject2).msg_phone_bind_req_body.set((MessageMicro)localObject3);
      ((hd_video_voip_2.ReqBody)localObject2).msg_bm.set(paramString3);
      localObject1 = ((hd_video_voip_2.ReqBody)localObject2).toByteArray();
      paramString3 = new byte[localObject1.length + 4];
      PkgTools.a(paramString3, 0, localObject1.length);
      PkgTools.a(paramString3, 4, (byte[])localObject1, localObject1.length);
      if (QLog.isDevelopLevel()) {
        QLog.d("PstnHandler", 4, "buff : " + StringUtil.c(new String(paramString3)));
      }
      localObject1 = super.a("im_sso_sharp.sharp_cs_voip");
      ((ToServiceMsg)localObject1).extraData.putBoolean("isCallTypeReq", true);
      ((ToServiceMsg)localObject1).extraData.putString("phoneNum", paramString2);
      ((ToServiceMsg)localObject1).extraData.putInt("uinType", paramInt);
      ((ToServiceMsg)localObject1).extraData.putString("peerUin", paramString4);
      ((ToServiceMsg)localObject1).extraData.putString("selfPhoneNum", paramString1);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      ((ToServiceMsg)localObject1).putWupBuffer(paramString3);
      super.b((ToServiceMsg)localObject1);
      return;
      ((hd_video_voip_2.TelInfo)localObject2).bytes_nation.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject3).a));
      break;
      label674:
      ((hd_video_voip_2.TelInfo)localObject2).uint64_uin_type.set(J);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 2, "CANCEL_CALLBACK_PSTN_DOUBLE: toPhone=" + paramString2 + ", toUin=" + paramString4 + ", fromPhone=" + paramString1 + ", fromUin=" + paramString3 + ", uinType=" + paramInt + ", callbackId=" + paramString5);
    }
    long l1 = PstnUtils.a(paramString3);
    long l2 = PstnUtils.a(paramString4);
    paramString3 = new hd_video_voip_2.VoipHead();
    paramString3.uint64_uin.set(l1);
    paramString4 = paramString3.uint64_seq;
    int i1 = MobileQQService.c;
    MobileQQService.c = i1 + 1;
    paramString4.set(i1);
    paramString3.uint32_cmd.set(5);
    paramString3.bytes_build_ver.set(ByteStringMicro.copyFromUtf8("6.5.5"));
    paramString3.uint32_term_type.set(4);
    paramString4 = new hd_video_voip_2.TelInfo();
    Object localObject = PhoneNumberUtil.a(paramString1);
    paramString4.bytes_nation.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject).a));
    paramString4.bytes_prefix.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject).b));
    paramString4.bytes_mobile.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject).c));
    paramString3.uint64_uin.set(l1);
    paramString4.uint64_uin_type.set(D);
    paramString1 = new hd_video_voip_2.TelInfo();
    if (!TextUtils.isEmpty(paramString2))
    {
      PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(paramString2);
      if (!TextUtils.isEmpty(localPhoneNumberInfo.a))
      {
        paramString1.bytes_nation.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.a));
        if (!TextUtils.isEmpty(localPhoneNumberInfo.b)) {
          paramString1.bytes_prefix.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.b));
        }
        paramString1.bytes_mobile.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.c));
      }
    }
    else
    {
      paramString1.uint64_uin.set(l2);
      if (paramInt != 0) {
        break label593;
      }
      paramString1.uint64_uin_type.set(D);
    }
    for (;;)
    {
      localObject = new hd_video_voip_2.CmdPhoneCancelCallBackReqBody();
      ((hd_video_voip_2.CmdPhoneCancelCallBackReqBody)localObject).msg_from_tel.set(paramString4);
      ((hd_video_voip_2.CmdPhoneCancelCallBackReqBody)localObject).msg_to_tel.set(paramString1);
      if (!TextUtils.isEmpty(paramString5)) {
        ((hd_video_voip_2.CmdPhoneCancelCallBackReqBody)localObject).bytes_call_id.set(ByteStringMicro.copyFromUtf8(paramString5));
      }
      paramString1 = new hd_video_voip_2.BalanceAccount();
      paramString1.uint32_from_app.set(2);
      paramString1.uint32_account_type.set(1);
      paramString4 = new hd_video_voip_2.ReqBody();
      paramString4.msg_voip_head.set(paramString3);
      paramString4.msg_phone_cancel_callback_req_body.set((MessageMicro)localObject);
      paramString4.msg_bm.set(paramString1);
      paramString3 = paramString4.toByteArray();
      paramString1 = new byte[paramString3.length + 4];
      PkgTools.a(paramString1, 0, paramString3.length);
      PkgTools.a(paramString1, 4, paramString3, paramString3.length);
      if (QLog.isDevelopLevel()) {
        QLog.d("PstnHandler", 4, "buff : " + StringUtil.c(new String(paramString1)));
      }
      paramString3 = super.a("im_sso_sharp.sharp_cs_voip");
      paramString3.extraData.putString("phoneNum", paramString2);
      paramString3.putWupBuffer(paramString1);
      super.b(paramString3);
      return;
      paramString1.bytes_nation.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject).a));
      break;
      label593:
      paramString1.uint64_uin_type.set(J);
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_47");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_75");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4f1_0");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 8
    //   6: ldc 52
    //   8: iconst_1
    //   9: new 173	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   16: ldc 28
    //   18: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 255	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   25: invokevirtual 258	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_2
    //   35: invokevirtual 255	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   38: ifeq +297 -> 335
    //   41: new 150	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   44: dup
    //   45: invokespecial 151	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   48: astore_1
    //   49: aload_1
    //   50: aload_3
    //   51: invokevirtual 159	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   54: pop
    //   55: aload_1
    //   56: getfield 163	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   59: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   62: ifeq +231 -> 293
    //   65: aload_1
    //   66: getfield 163	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   69: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   72: ifne +221 -> 293
    //   75: new 946	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody
    //   78: dup
    //   79: invokespecial 947	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:<init>	()V
    //   82: astore_3
    //   83: aload_3
    //   84: aload_1
    //   85: getfield 192	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   88: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   91: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   94: invokevirtual 948	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   97: pop
    //   98: aload_3
    //   99: getfield 951	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:uint32_pstn_gray_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   102: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   105: istore 4
    //   107: aload_3
    //   108: getfield 954	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:uint32_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: istore 5
    //   116: aload_3
    //   117: getfield 955	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:bytes_cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   120: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: astore_2
    //   124: aload_3
    //   125: getfield 958	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:uint32_c2c_trial_authority	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   128: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   131: istore 6
    //   133: aload_3
    //   134: getfield 961	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:uint32_multi_trial_authority	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   137: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   140: istore 7
    //   142: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +83 -> 228
    //   148: new 173	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 963
    //   158: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload 4
    //   163: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: ldc_w 965
    //   169: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload 5
    //   174: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: ldc_w 967
    //   180: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: astore_3
    //   184: aload_2
    //   185: ifnonnull +97 -> 282
    //   188: ldc_w 969
    //   191: astore_1
    //   192: ldc 52
    //   194: iconst_2
    //   195: aload_3
    //   196: aload_1
    //   197: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 971
    //   203: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload 6
    //   208: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc_w 973
    //   214: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: iload 7
    //   219: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: getfield 219	com/tencent/mobileqq/qcall/PstnHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   232: ifnull +34 -> 266
    //   235: aload_0
    //   236: getfield 219	com/tencent/mobileqq/qcall/PstnHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   239: sipush 142
    //   242: invokevirtual 362	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   245: checkcast 364	com/tencent/mobileqq/qcall/PstnManager
    //   248: astore_1
    //   249: aload_1
    //   250: ifnull +16 -> 266
    //   253: aload_1
    //   254: iload 4
    //   256: iload 5
    //   258: aload_2
    //   259: iload 6
    //   261: iload 7
    //   263: invokevirtual 976	com/tencent/mobileqq/qcall/PstnManager:a	(IILcom/tencent/mobileqq/pb/ByteStringMicro;II)V
    //   266: iconst_1
    //   267: istore 8
    //   269: aload_0
    //   270: iconst_4
    //   271: iload 8
    //   273: iload 4
    //   275: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: invokespecial 240	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   281: return
    //   282: aload_2
    //   283: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   286: invokestatic 981	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   289: astore_1
    //   290: goto -98 -> 192
    //   293: aload_1
    //   294: getfield 163	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   297: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   300: ifeq +35 -> 335
    //   303: ldc 52
    //   305: iconst_1
    //   306: new 173	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 983
    //   316: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_1
    //   320: getfield 163	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   323: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   326: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: iconst_0
    //   336: istore 4
    //   338: goto -69 -> 269
    //   341: astore_1
    //   342: iconst_0
    //   343: istore 5
    //   345: iload 9
    //   347: istore 8
    //   349: iload 5
    //   351: istore 4
    //   353: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -87 -> 269
    //   359: ldc 52
    //   361: iconst_2
    //   362: new 173	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 985
    //   372: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_1
    //   376: invokevirtual 372	java/lang/Exception:toString	()Ljava/lang/String;
    //   379: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: iload 9
    //   390: istore 8
    //   392: iload 5
    //   394: istore 4
    //   396: goto -127 -> 269
    //   399: astore_1
    //   400: iload 4
    //   402: istore 5
    //   404: goto -59 -> 345
    //   407: astore_1
    //   408: iconst_1
    //   409: istore 9
    //   411: iload 4
    //   413: istore 5
    //   415: goto -70 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	PstnHandler
    //   0	418	1	paramToServiceMsg	ToServiceMsg
    //   0	418	2	paramFromServiceMsg	FromServiceMsg
    //   0	418	3	paramArrayOfByte	byte[]
    //   105	307	4	i1	int
    //   114	300	5	i2	int
    //   131	129	6	i3	int
    //   140	122	7	i4	int
    //   4	387	8	bool1	boolean
    //   1	409	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   41	107	341	java/lang/Exception
    //   293	335	341	java/lang/Exception
    //   107	142	399	java/lang/Exception
    //   142	184	407	java/lang/Exception
    //   192	228	407	java/lang/Exception
    //   228	249	407	java/lang/Exception
    //   253	266	407	java/lang/Exception
    //   282	290	407	java/lang/Exception
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 2, "PSTNHandler receive pstn callback message ");
    }
    a(paramArrayOfByte);
    paramToServiceMsg = new hd_video.MsgBody();
    int i1 = paramArrayOfByte[0];
    try
    {
      i2 = paramArrayOfByte[(paramArrayOfByte.length - 1)];
      if ((i1 != 40) || (i2 != 41))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PstnHandler", 2, "PSTNHandler handleSharpPstnCallback invalid format");
        }
      }
      else
      {
        i1 = paramArrayOfByte[1] << 24 | paramArrayOfByte[2] << 16 | paramArrayOfByte[3] << 8 | paramArrayOfByte[4];
        i2 = paramArrayOfByte.length - i1 - 10;
        paramFromServiceMsg = new byte[i2];
        System.arraycopy(paramArrayOfByte, i1 + 9, paramFromServiceMsg, 0, i2);
        paramToServiceMsg = (hd_video.MsgBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        if ((paramToServiceMsg.msg_video_head.has()) && (((hd_video.VideoHead)paramToServiceMsg.msg_video_head.get()).enum_body_type.has()))
        {
          i1 = ((hd_video.VideoHead)paramToServiceMsg.msg_video_head.get()).enum_body_type.get();
          if (i1 == 22)
          {
            if (!paramToServiceMsg.msg_pstn_callback_notify_accept.has()) {
              return;
            }
            paramFromServiceMsg = paramToServiceMsg.msg_pstn_callback_notify_accept.bytes_call_id.get().toStringUtf8();
            i1 = paramToServiceMsg.msg_pstn_callback_notify_accept.uint32_accept_time.get();
            if (QLog.isColorLevel()) {
              QLog.d("PstnHandler", 2, "PSTNHandler handleSharpPstnCallback notify accept");
            }
            super.a(7, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i1) });
          }
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      int i2;
      if (QLog.isColorLevel())
      {
        QLog.d("PstnHandler", 2, "PSTNHandler receive pstn callback exception", paramToServiceMsg);
        return;
        if ((i1 == 23) && (paramToServiceMsg.msg_pstn_callback_notify_logout.has()))
        {
          paramFromServiceMsg = paramToServiceMsg.msg_pstn_callback_notify_logout.bytes_call_id.get().toStringUtf8();
          i1 = paramToServiceMsg.msg_pstn_callback_notify_logout.uint32_call_time.get();
          i2 = paramToServiceMsg.msg_pstn_callback_notify_logout.uint32_call_status.get();
          if (QLog.isColorLevel()) {
            QLog.d("PstnHandler", 2, "PSTNHandler handleSharpPstnCallback notify logout, callId:" + paramFromServiceMsg + ", duration:" + i1 + ", status:" + i2);
          }
          paramArrayOfByte = ((PstnManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142)).a(paramFromServiceMsg);
          BaseApplication localBaseApplication;
          int i3;
          boolean bool;
          if (paramArrayOfByte != null)
          {
            localBaseApplication = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
            i3 = paramArrayOfByte.istroop;
            bool = paramArrayOfByte.isSend();
            if (i1 <= 0) {
              break label509;
            }
          }
          label509:
          for (paramToServiceMsg = UITools.a(i1);; paramToServiceMsg = "0")
          {
            paramArrayOfByte.msg = TransfileUtile.a(VideoMsgTools.a(localBaseApplication, 59, i3, bool, paramToServiceMsg), 59L, 3, false);
            VideoMsgTools.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
            super.a(8, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i1), Integer.valueOf(i2) });
            return;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\PstnHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */