package com.tencent.mobileqq.olympic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.olympic.OlympicTorchSvc.ReqExitDeliverTorch;
import tencent.im.oidb.olympic.OlympicTorchSvc.ReqGetTorchAward;
import tencent.im.oidb.olympic.OlympicTorchSvc.RspDeliverTorch;
import tencent.im.oidb.olympic.OlympicTorchSvc.RspExitDeliverTorch;
import tencent.im.oidb.olympic.OlympicTorchSvc.RspGetTorchAward;
import tencent.im.oidb.olympic.OlympicTorchSvc.RspHead;
import tencent.im.oidb.olympic.cmd0x6f0.ReqBody;
import tencent.im.oidb.olympic.cmd0x6f0.RspBody;
import tencent.im.oidb.olympic.torch_transfer.TorchbearerInfo;
import tqw;

public class OlympicHandler
  extends BusinessHandler
{
  public static final String a = "OlympicTorchSvc.ReqGetTorchAward";
  public static final String b = "OidbSvc.0x6f0";
  public static final String c = "OidbSvc.0x5eb_22";
  public static final String d = "OidbSvc.0x4ff_40525";
  public static final String e = "OidbSvc.0x5eb_40525";
  private static final String f = "OlympicHandler";
  
  public OlympicHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    int i;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder().append("handle_oidb_0x5eb_40525 ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte != null)
      {
        i = paramArrayOfByte.length;
        QLog.d("OlympicHandler", 2, i);
      }
    }
    else
    {
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null)) {
        break label361;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom(paramArrayOfByte);
        if ((!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramFromServiceMsg.rpt_msg_uin_data.size() <= 0) {
          continue;
        }
        paramToServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0);
        bool4 = bool5;
      }
      catch (Throwable paramToServiceMsg)
      {
        bool3 = false;
        bool1 = bool3;
        bool2 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("OlympicHandler", 2, "", paramToServiceMsg);
        bool1 = bool3;
        bool2 = bool4;
        continue;
        bool1 = false;
        continue;
      }
      try
      {
        if (paramToServiceMsg.uint32_torch_disable_flag.get() == 0) {
          bool1 = true;
        }
        bool4 = bool1;
        ((OlympicManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a("olympic_flag_setting", bool1);
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          bool4 = bool1;
          QLog.d("OlympicHandler", 2, "handle_oidb_0x5eb_40525.torchbearer_switch=" + bool1);
        }
        bool4 = bool1;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("olympic_setting_ever_fetch_flag_switch_here", bool1).commit();
        bool2 = true;
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
        a(8, bool1, Boolean.valueOf(bool2));
        return;
      }
      catch (Throwable paramToServiceMsg)
      {
        bool3 = true;
        continue;
      }
      i = -1;
      break;
      label361:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int i;
    Object localObject1;
    Object localObject5;
    int j;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      i = -1;
      paramFromServiceMsg = null;
      paramToServiceMsg = null;
      localObject1 = null;
      localObject5 = null;
      if (!bool) {
        break label466;
      }
      j = i;
    }
    for (;;)
    {
      try
      {
        localRspGetTorchAward = new OlympicTorchSvc.RspGetTorchAward();
        j = i;
        localRspGetTorchAward.mergeFrom((byte[])paramObject);
        j = i;
        paramToServiceMsg = (OlympicTorchSvc.RspHead)localRspGetTorchAward.msg_rsp_head.get();
        j = i;
        i = paramToServiceMsg.uint32_result.get();
        j = i;
        paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        OlympicTorchSvc.RspGetTorchAward localRspGetTorchAward;
        paramToServiceMsg = null;
        paramFromServiceMsg = null;
        paramObject = null;
        i = j;
        localThrowable1.printStackTrace();
        Object localObject3 = paramToServiceMsg;
        localObject5 = localObject1;
        localFromServiceMsg = paramFromServiceMsg;
        localObject6 = paramObject;
        j = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("OlympicHandler", 2, "handleCollectTorch.exception happen e=" + localThrowable1);
        localObject3 = paramToServiceMsg;
        localObject5 = localObject1;
        localFromServiceMsg = paramFromServiceMsg;
        localObject6 = paramObject;
        j = i;
        continue;
        Object localObject2;
        localObject4 = null;
        localFromServiceMsg = null;
        continue;
      }
      try
      {
        paramObject = (torch_transfer.TorchbearerInfo)localRspGetTorchAward.msg_torchbearer_info.get();
      }
      catch (Throwable localThrowable2)
      {
        localObject3 = null;
        paramFromServiceMsg = null;
        paramObject = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject3;
        continue;
      }
      try
      {
        if (localRspGetTorchAward.bytes_sig.has()) {
          paramFromServiceMsg = localRspGetTorchAward.bytes_sig.get().toByteArray();
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject1 = paramObject;
        localObject3 = null;
        paramFromServiceMsg = null;
        paramObject = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject3;
        continue;
      }
      try
      {
        localObject1 = new TorchInfo((torch_transfer.TorchbearerInfo)paramObject);
      }
      catch (Throwable localThrowable4)
      {
        localObject1 = null;
        localObject2 = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = localThrowable4;
        continue;
      }
      try
      {
        ((TorchInfo)localObject1).delay_time = localRspGetTorchAward.uint32_delay_time.get();
        localFromServiceMsg = paramFromServiceMsg;
        localObject5 = paramObject;
        localObject3 = localObject1;
        j = i;
        localObject6 = paramToServiceMsg;
        if (QLog.isColorLevel()) {
          QLog.i("OlympicHandler", 2, "handleCollectTorch.errCode=" + j + ",errStr=" + (String)localObject6 + ",sig=" + localFromServiceMsg + ",torchbearerInfo=" + localObject5 + ",isSuccess=" + bool);
        }
        a(3, bool, new Object[] { Integer.valueOf(j), localObject6, localFromServiceMsg, localObject3 });
        return;
      }
      catch (Throwable localThrowable5)
      {
        localObject2 = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = localThrowable5;
        continue;
      }
      bool = paramFromServiceMsg.isSuccess();
      break;
      label466:
      Object localObject4 = null;
      FromServiceMsg localFromServiceMsg = null;
      Object localObject6 = null;
      j = -1;
      localObject5 = paramToServiceMsg;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = -1;
    boolean bool;
    int k;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      k = paramToServiceMsg.extraData.getInt("reqSource", -1);
      if (!bool) {
        break label243;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new cmd0x6f0.RspBody();
        i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        paramToServiceMsg = null;
        i = j;
        paramFromServiceMsg.printStackTrace();
        continue;
        paramToServiceMsg = null;
        continue;
      }
      try
      {
        paramToServiceMsg = paramToServiceMsg.rpt_torchbearer_list.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
          continue;
        }
        paramToServiceMsg = new TorchInfo((torch_transfer.TorchbearerInfo)paramToServiceMsg.get(0));
        if (paramToServiceMsg == null) {}
      }
      catch (Throwable paramFromServiceMsg)
      {
        paramToServiceMsg = null;
        continue;
      }
      try
      {
        ((OlympicManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.i("OlympicHandler", 2, "handleGetMyTorchInfo.isSuccess=" + bool + ",result=" + i + ",torchbearerInfo=" + paramToServiceMsg + ",reqSource:" + k);
        }
        a(4, bool, new Object[] { Integer.valueOf(i), paramToServiceMsg, Integer.valueOf(k) });
        return;
      }
      catch (Throwable paramFromServiceMsg)
      {
        continue;
      }
      bool = paramFromServiceMsg.isSuccess();
      break;
      label243:
      paramToServiceMsg = null;
      int i = j;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    OlympicTorchManager localOlympicTorchManager;
    int n;
    int k;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i;
    label105:
    label194:
    label243:
    boolean bool1;
    if (paramObject != null)
    {
      paramObject = (byte[])paramObject;
      localOlympicTorchManager = ((OlympicManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a();
      n = paramToServiceMsg.extraData.getInt("groupId", -1);
      k = 0;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handleGetUinTorch ").append(paramFromServiceMsg.isSuccess()).append(", ");
        if (paramObject == null) {
          break label857;
        }
        i = paramObject.length;
        QLog.d("OlympicHandler", 2, i);
      }
      if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
        try
        {
          paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
          {
            paramObject = new oidb_0x5eb.RspBody();
            ((oidb_0x5eb.RspBody)paramObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            paramToServiceMsg = null;
            i = 0;
            if (i < ((oidb_0x5eb.RspBody)paramObject).rpt_msg_uin_data.size())
            {
              localObject = (oidb_0x5eb.UdcUinData)((oidb_0x5eb.RspBody)paramObject).rpt_msg_uin_data.get(i);
              if (!((oidb_0x5eb.UdcUinData)localObject).uint64_uin.has()) {
                break label838;
              }
              paramFromServiceMsg = Long.toString(((oidb_0x5eb.UdcUinData)localObject).uint64_uin.get());
              if (TextUtils.isEmpty(paramFromServiceMsg)) {
                break label848;
              }
              int m = -1;
              int j = m;
              if (((oidb_0x5eb.UdcUinData)localObject).uint32_torchbearer_flag.has())
              {
                j = m;
                if (((oidb_0x5eb.UdcUinData)localObject).uint32_torch_disable_flag.has())
                {
                  j = ((oidb_0x5eb.UdcUinData)localObject).uint32_torchbearer_flag.get();
                  if ((((oidb_0x5eb.UdcUinData)localObject).uint32_torch_disable_flag.get() != 0) || (j != 1)) {
                    break label599;
                  }
                  bool1 = true;
                  localArrayList2.add(new Pair(paramFromServiceMsg, Boolean.valueOf(bool1)));
                }
              }
              if (!QLog.isColorLevel()) {
                break label835;
              }
              if (paramToServiceMsg != null) {
                break label832;
              }
              paramToServiceMsg = new StringBuilder("handleGetUinTorch start----");
              label358:
              paramToServiceMsg.append("\n").append("uin").append(":").append(paramFromServiceMsg).append("|").append("flag").append(":").append(j).append("|").append("index").append(":").append(i);
            }
          }
        }
        catch (Throwable paramToServiceMsg)
        {
          i = k;
          if (QLog.isColorLevel())
          {
            QLog.d("OlympicHandler", 2, "", paramToServiceMsg);
            i = k;
          }
        }
      }
    }
    label455:
    label599:
    label832:
    label835:
    label838:
    label848:
    label857:
    label863:
    label866:
    for (;;)
    {
      paramToServiceMsg = (FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      if (i != 0)
      {
        bool1 = true;
        if (n >= 0)
        {
          boolean bool2 = localOlympicTorchManager.a(localArrayList1, n);
          if (QLog.isColorLevel()) {
            QLog.i("OlympicHandler", 2, "handleGetUinTorch, hasFinished " + bool2 + " unfinishUins:" + localArrayList1.size());
          }
          bool1 = bool2;
          if (!bool2)
          {
            localOlympicTorchManager.a(n);
            bool1 = bool2;
          }
        }
        localOlympicTorchManager.a(localArrayList2, bool1, n);
        if ((localArrayList2.size() > 0) || (bool1)) {
          paramToServiceMsg.a(106, true, Boolean.valueOf(bool1));
        }
      }
      do
      {
        return;
        bool1 = false;
        break;
        if ((QLog.isColorLevel()) && (paramToServiceMsg != null)) {
          QLog.i("OlympicHandler", 2, paramToServiceMsg.toString());
        }
        if ((!((oidb_0x5eb.RspBody)paramObject).rpt_uint64_unfinished_uins.has()) || (((oidb_0x5eb.RspBody)paramObject).rpt_uint64_unfinished_uins.size() <= 0)) {
          break label863;
        }
        i = 0;
        while (i < ((oidb_0x5eb.RspBody)paramObject).rpt_uint64_unfinished_uins.size())
        {
          localArrayList1.add(Long.toString(((Long)((oidb_0x5eb.RspBody)paramObject).rpt_uint64_unfinished_uins.get(i)).longValue()));
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break label863;
        }
        QLog.i("OlympicHandler", 2, "handleGetUinTorch, unfinish " + localArrayList1.size());
        break label863;
        if (QLog.isColorLevel()) {
          QLog.i("OlympicHandler", 2, "handleGetUinTorch, error");
        }
        i = 0;
        break label866;
        paramToServiceMsg.extraData.getStringArrayList("uins");
        i = k;
        break label455;
        if (QLog.isColorLevel()) {
          QLog.i("OlympicHandler", 2, "handleGetUinTorch error, finish group " + n);
        }
        localOlympicTorchManager.b(n);
      } while (n < 0);
      paramToServiceMsg.a(106, false, Boolean.valueOf(true));
      return;
      break label358;
      break label848;
      paramFromServiceMsg = null;
      break label243;
      paramObject = null;
      break;
      i += 1;
      break label194;
      i = -1;
      break label105;
      i = 1;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool1 = false;
    boolean bool3 = false;
    boolean bool4 = paramToServiceMsg.extraData.getBoolean("switch", true);
    boolean bool2 = bool1;
    if (paramFromServiceMsg != null)
    {
      bool2 = bool1;
      if (paramFromServiceMsg.getResultCode() == 1000) {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
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
        int i;
        paramFromServiceMsg.printStackTrace();
        continue;
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramToServiceMsg != null)
    {
      bool2 = bool1;
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("OlympicHandler", 2, "handleSendSetOlympicShowSwitch ret=" + i);
        }
        bool2 = bool1;
        if (i == 0)
        {
          bool2 = bool1;
          if (paramToServiceMsg.bytes_bodybuffer.has())
          {
            bool2 = bool1;
            if (paramToServiceMsg.bytes_bodybuffer.get() != null)
            {
              paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
              if (4 > paramToServiceMsg.length) {
                break label286;
              }
              paramToServiceMsg = String.valueOf(PkgTools.a(paramToServiceMsg, 0));
              if ((paramToServiceMsg != null) && (paramToServiceMsg.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {
                break label286;
              }
              bool1 = bool3;
              if (QLog.isColorLevel())
              {
                QLog.w("OlympicHandler", 2, "handleSendSetOlympicShowSwitch uin error");
                bool1 = bool3;
              }
              bool2 = bool1;
              if (bool1)
              {
                ((OlympicManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a("olympic_flag_setting", bool4);
                bool2 = bool1;
              }
            }
          }
        }
      }
    }
    a(7, bool2, Boolean.valueOf(bool4));
  }
  
  protected Class a()
  {
    return OlympicObserver.class;
  }
  
  public void a()
  {
    OlympicUtil.b("OlympicHandler", new Object[] { "onExitDeliverTorch" });
    OlympicTorchSvc.ReqExitDeliverTorch localReqExitDeliverTorch = new OlympicTorchSvc.ReqExitDeliverTorch();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "OlympicTorchSvc.ReqExitDeliverTorch");
    localToServiceMsg.putWupBuffer(localReqExitDeliverTorch.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(int paramInt)
  {
    Object localObject2 = b();
    Object localObject1 = new ArrayList(1);
    ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong((String)localObject2)));
    localObject2 = new cmd0x6f0.ReqBody();
    ((cmd0x6f0.ReqBody)localObject2).rpt_uin_list.set((List)localObject1);
    ((cmd0x6f0.ReqBody)localObject2).enum_req_source.set(paramInt);
    ((cmd0x6f0.ReqBody)localObject2).uint64_req_torch_info.set(15L);
    localObject1 = a("OidbSvc.0x6f0", 1776, 0, ((cmd0x6f0.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("reqSource", paramInt);
    b((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.i("OlympicHandler", 2, "getMyTorchInfo.flag= " + 15L + ",reqSource:" + paramInt);
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, List paramList)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "OlympicTorchSvc.ReqGetTorchAward");
    OlympicTorchSvc.ReqGetTorchAward localReqGetTorchAward = new OlympicTorchSvc.ReqGetTorchAward();
    localReqGetTorchAward.bytes_pack_id.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    localReqGetTorchAward.uint32_business.set(paramInt);
    if (paramArrayOfByte2 != null) {
      localReqGetTorchAward.bytes_sig.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    }
    localReqGetTorchAward.rpt_city_pic_id_list.set(paramList);
    localToServiceMsg.putWupBuffer(localReqGetTorchAward.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d("OlympicHandler", 2, "collectTorch pack_id=" + paramArrayOfByte1 + ",business=" + paramInt + ",sig=" + paramArrayOfByte2 + ",pic_id_list=" + paramList);
    }
    b(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (Object localObject = "null";; localObject = paramArrayOfByte)
    {
      OlympicUtil.b("OlympicHandler", new Object[] { "onDeliverTorch, torchId=", Long.valueOf(paramLong), ", usershare=", Integer.valueOf(paramInt), ", sig=", localObject });
      if (paramLong >= 0L) {
        break;
      }
      OlympicUtil.b("OlympicHandler", new Object[] { "onDeliverTorch, torchId < 0, return" });
      return;
    }
    OlympicUtil.b("OlympicHandler", new Object[] { "onDeliverTorch, start to get lbs info" });
    SosoInterface.a(new tqw(this, 0, false, true, 30000L, false, false, "olympic", paramLong, paramInt, paramArrayOfByte));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!a(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("OlympicHandler", 2, "cmdfilter error = " + str);
      return;
      if ("OlympicTorchSvc.ReqGetTorchAward".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6f0".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OlympicTorchSvc.ReqDeliverTorch".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OlympicTorchSvc.ReqExitDeliverTorch".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_22".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OlympicTorchSvc.ReqClearTorchFlag".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_40525".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x5eb_40525".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicHandler", 2, "getUinTorch:" + paramList);
    }
    Object localObject = new oidb_0x5eb.ReqBody();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        long l = Long.parseLong(str);
        ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_torchbearer_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_torch_disable_flag.set(1);
    localObject = a("OidbSvc.0x5eb_22", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putStringArrayList("uins", (ArrayList)paramList);
    b((ToServiceMsg)localObject);
  }
  
  public void a(List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicHandler", 2, "getUinTorch:" + paramList);
    }
    Object localObject = new oidb_0x5eb.ReqBody();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        long l = Long.parseLong(str);
        ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_torchbearer_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_torch_disable_flag.set(1);
    localObject = a("OidbSvc.0x5eb_22", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putStringArrayList("uins", (ArrayList)paramList);
    ((ToServiceMsg)localObject).extraData.putInt("groupId", paramInt);
    b((ToServiceMsg)localObject);
  }
  
  public void a(torch_transfer.TorchbearerInfo paramTorchbearerInfo)
  {
    if (paramTorchbearerInfo == null)
    {
      OlympicUtil.b("OlympicHandler", new Object[] { "handlePush0xb4, torchInfo == null, return" });
      return;
    }
    OlympicUtil.b("OlympicHandler", new Object[] { "handlePush0xb4, torchInfo=", paramTorchbearerInfo });
    OlympicManager localOlympicManager = (OlympicManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166);
    if (localOlympicManager != null) {}
    for (paramTorchbearerInfo = localOlympicManager.a(paramTorchbearerInfo);; paramTorchbearerInfo = null)
    {
      a(5, true, new Object[] { paramTorchbearerInfo });
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(13);
    long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (paramBoolean) {}
    for (short s = 0;; s = 1)
    {
      ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)40525).putShort((short)2).putShort(s);
      localObject = a("OidbSvc.0x4ff_40525", 1279, 9, ((ByteBuffer)localObject).array());
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      b((ToServiceMsg)localObject);
      return;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OlympicTorchSvc.ReqDeliverTorch");
      this.jdField_b_of_type_JavaUtilSet.add("OlympicTorchSvc.ReqExitDeliverTorch");
      this.jdField_b_of_type_JavaUtilSet.add("OlympicTorchSvc.ReqClearTorchFlag");
      this.jdField_b_of_type_JavaUtilSet.add("OlympicTorchSvc.ReqGetTorchAward");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x6f0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_22");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_40525");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_40525");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    OlympicUtil.b("OlympicHandler", new Object[] { "clearTorchFlag" });
    OlympicTorchSvc.ReqExitDeliverTorch localReqExitDeliverTorch = new OlympicTorchSvc.ReqExitDeliverTorch();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "OlympicTorchSvc.ReqClearTorchFlag");
    localToServiceMsg.putWupBuffer(localReqExitDeliverTorch.toByteArray());
    b(localToServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      OlympicUtil.b("OlympicHandler", new Object[] { "handleDeliverTorch, req or res or data == null, return" });
      return;
    }
    OlympicUtil.b("OlympicHandler", new Object[] { "handleDeliverTorch, req=", paramToServiceMsg, ", res=", paramFromServiceMsg, ", data=", paramObject });
    paramToServiceMsg = new OlympicTorchSvc.RspDeliverTorch();
    int i;
    int j;
    for (;;)
    {
      try
      {
        paramToServiceMsg = (OlympicTorchSvc.RspDeliverTorch)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_rsp_head.has())
        {
          paramFromServiceMsg = (OlympicTorchSvc.RspHead)paramToServiceMsg.msg_rsp_head.get();
          if (!paramToServiceMsg.uint32_min_update_time.has()) {
            break label328;
          }
          i = paramToServiceMsg.uint32_min_update_time.get();
          if (!paramToServiceMsg.uint32_expire_time.has()) {
            break label334;
          }
          j = paramToServiceMsg.uint32_expire_time.get();
          if (!paramToServiceMsg.bytes_sig.has()) {
            break label340;
          }
          paramToServiceMsg = paramToServiceMsg.bytes_sig.get().toByteArray();
          if (paramFromServiceMsg != null) {
            break;
          }
          OlympicUtil.b("OlympicHandler", new Object[] { "handleDeliverTorch, rspHead or torchInfo == null, result set to -100" });
          a(1, false, new Object[] { Boolean.valueOf(true), Integer.valueOf(-100), "", Integer.valueOf(0), Integer.valueOf(0), null });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        OlympicUtil.b("OlympicHandler", new Object[] { "handleDeliverTorch, InvalidProtocolBufferMicroException, result set to -101, msg=", paramToServiceMsg.getMessage() });
        if (QLog.isColorLevel()) {
          paramToServiceMsg.printStackTrace();
        }
        a(0, false, new Object[] { Boolean.valueOf(true), Integer.valueOf(-101), "", Integer.valueOf(0), Integer.valueOf(0), null });
        return;
      }
      paramFromServiceMsg = null;
      continue;
      label328:
      i = 0;
      continue;
      label334:
      j = 0;
      continue;
      label340:
      paramToServiceMsg = null;
    }
    int k = paramFromServiceMsg.uint32_result.get();
    paramObject = paramFromServiceMsg.str_error_msg.get();
    if (k == 0) {
      a(1, true, new Object[] { Boolean.valueOf(true), Integer.valueOf(k), paramObject, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
    }
    for (;;)
    {
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      if (paramObject == null) {
        paramFromServiceMsg = "";
      }
      paramObject = paramToServiceMsg;
      if (paramToServiceMsg == null) {
        paramObject = "null";
      }
      OlympicUtil.b("OlympicHandler", new Object[] { "handleDeliverTorch, result=", Integer.valueOf(k), ", errMsg=", paramFromServiceMsg, ", minUpdateTime=", Integer.valueOf(i), ", expireTime=", Integer.valueOf(j), ", sig=", paramObject });
      return;
      a(1, false, new Object[] { Boolean.valueOf(true), Integer.valueOf(k), paramObject, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicHandler", 2, "send_oidb_0x5eb_40525");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_torch_disable_flag.set(1);
      b(a("OidbSvc.0x5eb_40525", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("OlympicHandler", 2, "send_oidb_0x5eb_40525 error", localException);
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      OlympicUtil.b("OlympicHandler", new Object[] { "handleExitDeliverTorch, req or res or data == null, return" });
      return;
    }
    OlympicUtil.b("OlympicHandler", new Object[] { "handleDeliverTorch, req=", paramToServiceMsg.toString(), ", res=", paramFromServiceMsg.toString(), ", data=", paramObject.toString() });
    paramToServiceMsg = new OlympicTorchSvc.RspExitDeliverTorch();
    for (;;)
    {
      try
      {
        paramToServiceMsg = (OlympicTorchSvc.RspExitDeliverTorch)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramToServiceMsg.msg_rsp_head.has()) {
          break label242;
        }
        paramToServiceMsg = (OlympicTorchSvc.RspHead)paramToServiceMsg.msg_rsp_head.get();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        label151:
        OlympicUtil.b("OlympicHandler", new Object[] { "handleExitDeliverTorch, InvalidProtocolBufferMicroException, result set to -101, msg=", paramToServiceMsg.getMessage() });
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramToServiceMsg.printStackTrace();
        a(2, false, new Object[] { Integer.valueOf(-101), "" });
        return;
      }
      if (i == 0)
      {
        a(2, true, new Object[] { Integer.valueOf(i), paramToServiceMsg });
        OlympicUtil.b("OlympicHandler", new Object[] { "handleExitDeliverTorch, result=", Integer.valueOf(i), ", errMsg=", paramToServiceMsg });
        return;
        label242:
        paramToServiceMsg = null;
      }
      label247:
      for (int i = paramToServiceMsg.uint32_result.get(); paramToServiceMsg != null; i = -1)
      {
        paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
        break;
        a(2, false, new Object[] { Integer.valueOf(i), paramToServiceMsg });
        break label151;
        if (paramToServiceMsg != null) {
          break label247;
        }
      }
      paramToServiceMsg = "";
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      OlympicUtil.b("OlympicHandler", new Object[] { "handleClearTorchFlag, req or res or data == null, return" });
      return;
    }
    OlympicUtil.b("OlympicHandler", new Object[] { "handleClearTorchFlag, req=", paramToServiceMsg.toString(), ", res=", paramFromServiceMsg.toString(), ", data=", paramObject.toString() });
    paramToServiceMsg = new OlympicTorchSvc.RspExitDeliverTorch();
    for (;;)
    {
      try
      {
        paramToServiceMsg = (OlympicTorchSvc.RspExitDeliverTorch)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramToServiceMsg.msg_rsp_head.has()) {
          break label244;
        }
        paramToServiceMsg = (OlympicTorchSvc.RspHead)paramToServiceMsg.msg_rsp_head.get();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        label152:
        OlympicUtil.b("OlympicHandler", new Object[] { "handleClearTorchFlag, InvalidProtocolBufferMicroException, result set to -101, msg=", paramToServiceMsg.getMessage() });
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramToServiceMsg.printStackTrace();
        a(6, false, new Object[] { Integer.valueOf(-101), "" });
        return;
      }
      if (i == 0)
      {
        a(6, true, new Object[] { Integer.valueOf(i), paramToServiceMsg });
        OlympicUtil.b("OlympicHandler", new Object[] { "handleClearTorchFlag, result=", Integer.valueOf(i), ", errMsg=", paramToServiceMsg });
        return;
        label244:
        paramToServiceMsg = null;
      }
      label249:
      for (int i = paramToServiceMsg.uint32_result.get(); paramToServiceMsg != null; i = -1)
      {
        paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
        break;
        a(6, false, new Object[] { Integer.valueOf(i), paramToServiceMsg });
        break label152;
        if (paramToServiceMsg != null) {
          break label249;
        }
      }
      paramToServiceMsg = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\OlympicHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */