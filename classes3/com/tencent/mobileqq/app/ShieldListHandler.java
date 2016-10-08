package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.BlockListNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.BlockUinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.MsgBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.BlockUinInfo;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyAddBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyDelBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyGetBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.RspBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.RspBodyGetBlockList;
import tencent.im.sso2sns.sso2sns_comm_info.Sso2SnsCommInfo;

public class ShieldListHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList";
  public static final int b = 2;
  public static final String b = "SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList";
  public static final int c = 3;
  public static final String c = "SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList";
  public static final int d = 0;
  private static final String d = "ShieldListHandler";
  public static final int e = 1;
  public static final int f = 1000;
  public static final int g = 55;
  private static final int jdField_h_of_type_Int = 60000;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private volatile boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap b;
  private String e;
  private String f;
  private String g;
  private String jdField_h_of_type_JavaLangString;
  private volatile int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString;
  private String j;
  
  ShieldListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_i_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.e = paramQQAppInterface.getApplication().getString(2131370582);
    this.f = paramQQAppInterface.getApplication().getString(2131370583);
    this.g = paramQQAppInterface.getApplication().getString(2131370586);
    this.h = paramQQAppInterface.getApplication().getString(2131370584);
    this.jdField_i_of_type_JavaLangString = paramQQAppInterface.getApplication().getString(2131370585);
    this.j = paramQQAppInterface.getApplication().getString(2131370587);
  }
  
  private int a()
  {
    if (this.jdField_i_of_type_Int == -1) {
      this.jdField_i_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("lastGetShieldListTime", 0);
    }
    return this.jdField_i_of_type_Int;
  }
  
  private void a(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      SharedPreferences.Editor localEditor = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
      localEditor.putInt("lastGetShieldListTime", paramInt);
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ShieldListHandler", 2, "setLastGetShieldListTime lastTime = " + paramInt);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><S> : sendGetShieldListReqInternal : queue size:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    }
    Object localObject2 = Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    int k = a();
    ToServiceMsg localToServiceMsg = a("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList");
    Object localObject1 = new sso2sns_comm_info.Sso2SnsCommInfo();
    ((sso2sns_comm_info.Sso2SnsCommInfo)localObject1).uint32_seq.set(1234);
    sso2sns_0x3_blocklist.ReqBodyGetBlockList localReqBodyGetBlockList = new sso2sns_0x3_blocklist.ReqBodyGetBlockList();
    localReqBodyGetBlockList.uint64_uin.set(((Long)localObject2).longValue());
    localReqBodyGetBlockList.uint32_get_type.set(paramInt1);
    localReqBodyGetBlockList.uint32_start_pos.set(paramInt2);
    localReqBodyGetBlockList.uint32_want_num.set(1000);
    localReqBodyGetBlockList.fixed32_last_get_time.set(k);
    localObject2 = new sso2sns_0x3_blocklist.ReqBody();
    ((sso2sns_0x3_blocklist.ReqBody)localObject2).msg_body_get_blocklist.set(localReqBodyGetBlockList);
    localObject1 = a((sso2sns_comm_info.Sso2SnsCommInfo)localObject1, (sso2sns_0x3_blocklist.ReqBody)localObject2);
    localToServiceMsg.setTimeout(60000L);
    localToServiceMsg.putWupBuffer((byte[])localObject1);
    b(localToServiceMsg);
  }
  
  private void a(ShieldOperationItem paramShieldOperationItem)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramShieldOperationItem);
      b();
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield><TO><---handleOperatingShieldList time out.");
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    do
    {
      return;
      if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str));
    e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, sso2sns_0x3_blocklist.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><R><---handleAddShieldListResp.");
    }
    paramFromServiceMsg = new ArrayList();
    paramRspBody = paramToServiceMsg.extraData.getLongArray("uinList");
    int m = paramToServiceMsg.extraData.getInt("source_id");
    int n = paramToServiceMsg.extraData.getInt("source_sub_id");
    int i1 = paramToServiceMsg.extraData.getInt("fromType");
    int i2 = paramRspBody.length;
    int k = 0;
    while (k < i2)
    {
      long l = paramRspBody[k];
      paramToServiceMsg = new ShieldListInfo();
      paramToServiceMsg.uin = String.valueOf(Long.valueOf(l));
      paramToServiceMsg.source_id = m;
      paramToServiceMsg.source_sub_id = n;
      paramToServiceMsg.flags = 1;
      paramFromServiceMsg.add(paramToServiceMsg);
      k += 1;
    }
    ((ShieldMsgManger)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(paramFromServiceMsg);
    a(true, m, paramRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><R> : " + Arrays.toString(paramRspBody));
    }
    a(2, true, new Object[] { paramRspBody, Integer.valueOf(i1) });
  }
  
  private void a(boolean paramBoolean, int paramInt, long[] paramArrayOfLong)
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ArrayList localArrayList = new ArrayList();
    int n = paramArrayOfLong.length;
    int k = 0;
    long l1;
    long l2;
    int m;
    Object localObject1;
    Object localObject3;
    if (k < n)
    {
      l1 = paramArrayOfLong[k];
      l2 = MessageCache.a();
      m = ShieldListInfo.SOURCE_ID_2_AIO_TYPE(paramInt);
      localObject1 = String.valueOf(l1);
      if (m != 1006) {
        if (paramBoolean)
        {
          localObject3 = this.e;
          localObject2 = localObject3;
          if (m != 1024) {
            break label467;
          }
          localObject2 = (QidianManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
          if ((localObject2 != null) && (((QidianManager)localObject2).a((String)localObject1))) {
            break label482;
          }
        }
      }
    }
    label252:
    label301:
    label460:
    label467:
    label482:
    for (Object localObject2 = this.g;; localObject2 = localObject3)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      for (;;)
      {
        localObject3 = MessageRecordFactory.a(63524);
        ((MessageRecord)localObject3).init(str, (String)localObject2, str, (String)localObject1, l2, 0, m, 0L);
        ((MessageRecord)localObject3).msgtype = 63524;
        ((MessageRecord)localObject3).isread = true;
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject2, m);
        if ((localObject1 != null) && (((List)localObject1).size() > 0) && (MsgProxyUtils.a((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1), (MessageRecord)localObject3, false)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ShieldListHandler", 2, "insertShieldMsgIntoMsgPool filtered!");
          }
          m = 1;
          if (m == 0) {
            localArrayList.add(localObject3);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<---insertShieldMsgIntoMsgPool : insert:" + ((MessageRecord)localObject3).toString());
          }
          k += 1;
          break;
          localObject3 = this.h;
          localObject2 = localObject3;
          if (m != 1024) {
            break label467;
          }
          localObject2 = (QidianManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
          if ((localObject2 != null) && (((QidianManager)localObject2).a((String)localObject1))) {
            break label460;
          }
        }
        for (localObject2 = this.j;; localObject2 = localObject3)
        {
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<---insertShieldMsgIntoMsgPool : isContactMsgType!");
          }
          localObject2 = ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1));
          if (localObject2 == null) {
            break label301;
          }
          if (paramBoolean)
          {
            localObject1 = this.f;
            break;
          }
          localObject1 = this.jdField_i_of_type_JavaLangString;
          break;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, String.valueOf(str), false);
          return;
          m = 0;
          break label252;
        }
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte1 = (byte[])paramObject;
    String str = paramFromServiceMsg.getServiceCmd();
    paramObject = new sso2sns_comm_info.Sso2SnsCommInfo();
    sso2sns_0x3_blocklist.RspBody localRspBody = new sso2sns_0x3_blocklist.RspBody();
    if (arrayOfByte1.length < 8)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return false;
    }
    long l1 = PkgTools.a(arrayOfByte1, 0);
    long l2 = PkgTools.a(arrayOfByte1, 4);
    byte[] arrayOfByte3 = new byte[(int)l1];
    byte[] arrayOfByte2 = new byte[(int)l2];
    System.arraycopy(arrayOfByte1, 8, arrayOfByte3, 0, (int)l1);
    try
    {
      paramObject = (sso2sns_comm_info.Sso2SnsCommInfo)((sso2sns_comm_info.Sso2SnsCommInfo)paramObject).mergeFrom(arrayOfByte3);
      if (paramObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: error: commInfo is null.");
        }
        b(paramToServiceMsg, paramFromServiceMsg);
        return false;
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception : parse Sso2SnsCommInfo failed.", (Throwable)paramObject);
        }
        paramObject = null;
      }
      if ((!((sso2sns_comm_info.Sso2SnsCommInfo)paramObject).uint32_result.has()) || (((sso2sns_comm_info.Sso2SnsCommInfo)paramObject).uint32_result.get() != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: error resultCode :" + ((sso2sns_comm_info.Sso2SnsCommInfo)paramObject).uint32_result.get());
        }
        b(paramToServiceMsg, paramFromServiceMsg);
        return false;
      }
      System.arraycopy(arrayOfByte1, (int)(l1 + 8L), arrayOfByte2, 0, (int)l2);
      try
      {
        paramObject = (sso2sns_0x3_blocklist.RspBody)localRspBody.mergeFrom(arrayOfByte2);
        if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str)) {
          return a(paramToServiceMsg, paramFromServiceMsg, (sso2sns_0x3_blocklist.RspBody)paramObject);
        }
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception : parse RspBody failed.", (Throwable)paramObject);
        }
        b(paramToServiceMsg, paramFromServiceMsg);
        return false;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (sso2sns_0x3_blocklist.RspBody)paramObject);
        return false;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str)) {
        b(paramToServiceMsg, paramFromServiceMsg, (sso2sns_0x3_blocklist.RspBody)paramObject);
      }
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, sso2sns_0x3_blocklist.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><R><---handleGetShieldListResp.");
    }
    if ((paramRspBody == null) || (!paramRspBody.msg_body_get_blocklist.has())) {
      return false;
    }
    paramToServiceMsg = (sso2sns_0x3_blocklist.RspBodyGetBlockList)paramRspBody.msg_body_get_blocklist.get();
    int m = paramToServiceMsg.fixed32_get_time.get();
    int n = paramToServiceMsg.uint32_completed.get();
    int i1 = paramToServiceMsg.uint32_now_pos.get();
    int i2 = paramToServiceMsg.uint32_get_type.get();
    paramRspBody = paramToServiceMsg.rpt_msg_block_uin_info.get();
    paramToServiceMsg = (ShieldMsgManger)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    int k = 0;
    if (paramRspBody != null) {
      k = paramRspBody.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<---handleGetShieldListResp : lastGetTime:" + m + ",isComplete:" + n + ",nowPos:" + i1 + ",getType:" + i2 + ",respSize:" + k);
    }
    Object localObject;
    boolean bool;
    if (i2 == 2)
    {
      if ((paramRspBody != null) && (paramRspBody.size() > 0))
      {
        paramFromServiceMsg = paramRspBody.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramRspBody = (sso2sns_0x3_blocklist.BlockUinInfo)paramFromServiceMsg.next();
          localObject = new ShieldListInfo();
          ((ShieldListInfo)localObject).uin = String.valueOf(paramRspBody.uint64_block_uin.get());
          ((ShieldListInfo)localObject).flags = 1;
          ((ShieldListInfo)localObject).source_id = paramRspBody.uint32_source_id.get();
          ((ShieldListInfo)localObject).source_sub_id = paramRspBody.uint32_source_sub_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<---handleGetShieldListResp : total data : shieldUin:" + ((ShieldListInfo)localObject).uin + ",source_id:" + ((ShieldListInfo)localObject).source_id + ",sub_ource_id:" + ((ShieldListInfo)localObject).source_sub_id);
          }
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ShieldListInfo)localObject).uin, localObject);
        }
      }
      if (n != 1) {
        break label596;
      }
      bool = paramToServiceMsg.a(this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    for (;;)
    {
      if (n == 0)
      {
        a(i2, i1);
        return true;
        if (i2 == 1)
        {
          paramFromServiceMsg = new ArrayList();
          if ((paramRspBody != null) && (paramRspBody.size() > 0))
          {
            paramRspBody = paramRspBody.iterator();
            while (paramRspBody.hasNext())
            {
              localObject = (sso2sns_0x3_blocklist.BlockUinInfo)paramRspBody.next();
              ShieldListInfo localShieldListInfo = new ShieldListInfo();
              localShieldListInfo.uin = String.valueOf(((sso2sns_0x3_blocklist.BlockUinInfo)localObject).uint64_block_uin.get());
              localShieldListInfo.flags = 1;
              localShieldListInfo.source_id = ((sso2sns_0x3_blocklist.BlockUinInfo)localObject).uint32_source_id.get();
              localShieldListInfo.source_sub_id = ((sso2sns_0x3_blocklist.BlockUinInfo)localObject).uint32_source_sub_id.get();
              if (QLog.isColorLevel()) {
                QLog.d("ShieldListHandler", 2, "<---handleGetShieldListResp : add data :" + localShieldListInfo.toString());
              }
              paramFromServiceMsg.add(localShieldListInfo);
            }
          }
          bool = paramToServiceMsg.a(paramFromServiceMsg);
        }
      }
      else
      {
        if ((n == 1) && (bool)) {
          a(m);
        }
        return false;
      }
      label596:
      bool = false;
    }
  }
  
  private byte[] a(sso2sns_comm_info.Sso2SnsCommInfo paramSso2SnsCommInfo, sso2sns_0x3_blocklist.ReqBody paramReqBody)
  {
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[4];
    paramSso2SnsCommInfo = paramSso2SnsCommInfo.toByteArray();
    paramReqBody = paramReqBody.toByteArray();
    long l1 = paramSso2SnsCommInfo.length;
    long l2 = paramReqBody.length;
    PkgTools.a(arrayOfByte1, 0, l1);
    PkgTools.a(arrayOfByte2, 0, l2);
    ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer((int)(8L + l1 + l2));
    localByteArrayBuffer.append(arrayOfByte1, 0, 4);
    localByteArrayBuffer.append(arrayOfByte2, 0, 4);
    localByteArrayBuffer.append(paramSso2SnsCommInfo, 0, (int)l1);
    localByteArrayBuffer.append(paramReqBody, 0, (int)l2);
    return localByteArrayBuffer.toByteArray();
  }
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty();
      if (QLog.isColorLevel()) {
        QLog.d("ShieldListHandler", 2, "--->execNextShieldOperation : isShieldOperating:" + this.jdField_a_of_type_Boolean + ",isEmpty:" + bool);
      }
      if ((this.jdField_a_of_type_Boolean) || (bool)) {
        return;
      }
      ShieldOperationItem localShieldOperationItem1 = (ShieldOperationItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localShieldOperationItem1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "--->execNextShieldOperation : queque is empty.");
        }
        return;
      }
    }
    int k = localShieldOperationItem2.jdField_a_of_type_Int;
    this.jdField_a_of_type_Boolean = true;
    switch (k)
    {
    }
    for (;;)
    {
      return;
      a(0, 0);
      continue;
      b(localShieldOperationItem2);
      continue;
      c(localShieldOperationItem2);
    }
  }
  
  private void b(ShieldOperationItem paramShieldOperationItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><S> : sendGetShieldListReqInternal : queue size:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    }
    long l = Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
    ToServiceMsg localToServiceMsg = a("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList");
    Object localObject1 = new sso2sns_comm_info.Sso2SnsCommInfo();
    ((sso2sns_comm_info.Sso2SnsCommInfo)localObject1).uint32_seq.set(1234);
    sso2sns_0x3_blocklist.ReqBodyAddBlockList localReqBodyAddBlockList = new sso2sns_0x3_blocklist.ReqBodyAddBlockList();
    localReqBodyAddBlockList.uint64_uin.set(l);
    Object localObject2 = paramShieldOperationItem.jdField_a_of_type_ArrayOfLong;
    int m = localObject2.length;
    int k = 0;
    while (k < m)
    {
      l = localObject2[k];
      sso2sns_0x3_blocklist.BlockUinInfo localBlockUinInfo = new sso2sns_0x3_blocklist.BlockUinInfo();
      localBlockUinInfo.uint64_block_uin.set(Long.valueOf(l).longValue());
      localBlockUinInfo.uint32_source_id.set(paramShieldOperationItem.b);
      localBlockUinInfo.uint32_source_sub_id.set(0);
      localReqBodyAddBlockList.rpt_msg_block_uin_info.add(localBlockUinInfo);
      k += 1;
    }
    localObject2 = new sso2sns_0x3_blocklist.ReqBody();
    ((sso2sns_0x3_blocklist.ReqBody)localObject2).msg_body_add_blocklist.set(localReqBodyAddBlockList);
    localObject1 = a((sso2sns_comm_info.Sso2SnsCommInfo)localObject1, (sso2sns_0x3_blocklist.ReqBody)localObject2);
    localToServiceMsg.setTimeout(60000L);
    localToServiceMsg.extraData.putInt("opType", paramShieldOperationItem.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putInt("source_id", paramShieldOperationItem.b);
    localToServiceMsg.extraData.putInt("source_sub_id", paramShieldOperationItem.c);
    localToServiceMsg.extraData.putLongArray("uinList", paramShieldOperationItem.jdField_a_of_type_ArrayOfLong);
    localToServiceMsg.extraData.putInt("fromType", paramShieldOperationItem.d);
    localToServiceMsg.putWupBuffer((byte[])localObject1);
    b(localToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    do
    {
      return;
      if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str));
    e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, sso2sns_0x3_blocklist.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><R><---handleDeleteShieldListResp.");
    }
    paramFromServiceMsg = new ArrayList();
    paramRspBody = paramToServiceMsg.extraData.getLongArray("uinList");
    int m = paramToServiceMsg.extraData.getInt("source_id");
    int n = paramToServiceMsg.extraData.getInt("source_sub_id");
    int i1 = paramToServiceMsg.extraData.getInt("fromType");
    int i2 = paramRspBody.length;
    int k = 0;
    while (k < i2)
    {
      long l = paramRspBody[k];
      paramToServiceMsg = new ShieldListInfo();
      paramToServiceMsg.uin = String.valueOf(Long.valueOf(l));
      paramToServiceMsg.source_id = m;
      paramToServiceMsg.source_sub_id = n;
      paramToServiceMsg.flags = 0;
      paramFromServiceMsg.add(paramToServiceMsg);
      k += 1;
    }
    ((ShieldMsgManger)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(paramFromServiceMsg);
    a(false, m, paramRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><R> : " + Arrays.toString(paramRspBody));
    }
    a(3, true, new Object[] { paramRspBody, Integer.valueOf(i1) });
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    d();
    b();
  }
  
  private void c(ShieldOperationItem paramShieldOperationItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><S> : sendDeleteShieldListReqInternal : queue size:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    }
    long l = Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
    ToServiceMsg localToServiceMsg = a("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList");
    Object localObject1 = new sso2sns_comm_info.Sso2SnsCommInfo();
    ((sso2sns_comm_info.Sso2SnsCommInfo)localObject1).uint32_seq.set(1234);
    sso2sns_0x3_blocklist.ReqBodyDelBlockList localReqBodyDelBlockList = new sso2sns_0x3_blocklist.ReqBodyDelBlockList();
    localReqBodyDelBlockList.uint64_uin.set(l);
    Object localObject2 = paramShieldOperationItem.jdField_a_of_type_ArrayOfLong;
    int m = localObject2.length;
    int k = 0;
    while (k < m)
    {
      l = localObject2[k];
      localReqBodyDelBlockList.rpt_uint64_del_uin.add(Long.valueOf(l));
      k += 1;
    }
    localObject2 = new sso2sns_0x3_blocklist.ReqBody();
    ((sso2sns_0x3_blocklist.ReqBody)localObject2).msg_body_del_blocklist.set(localReqBodyDelBlockList);
    localObject1 = a((sso2sns_comm_info.Sso2SnsCommInfo)localObject1, (sso2sns_0x3_blocklist.ReqBody)localObject2);
    localToServiceMsg.extraData.putInt("opType", paramShieldOperationItem.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putInt("source_id", paramShieldOperationItem.b);
    localToServiceMsg.extraData.putInt("source_sub_id", paramShieldOperationItem.c);
    localToServiceMsg.extraData.putLongArray("uinList", paramShieldOperationItem.jdField_a_of_type_ArrayOfLong);
    localToServiceMsg.extraData.putInt("fromType", paramShieldOperationItem.d);
    localToServiceMsg.setTimeout(60000L);
    localToServiceMsg.putWupBuffer((byte[])localObject1);
    b(localToServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><E><---handleGetShieldListError.");
    }
    a(1, false, null);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "flushPushCacheIntoDB : pushCache size" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add((ShieldListInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
    ((ShieldMsgManger)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(localArrayList);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a(4, true, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
    int k = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><E> : handleAddShieldListError :" + Arrays.toString(paramFromServiceMsg));
    }
    a(2, false, new Object[] { paramFromServiceMsg, Integer.valueOf(k) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
    int k = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><E> : handleDeleteShieldListError : " + Arrays.toString(paramFromServiceMsg));
    }
    a(3, false, new Object[] { paramFromServiceMsg, Integer.valueOf(k) });
  }
  
  protected Class a()
  {
    return ShieldListObserver.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><S> : sendGetShieldListReq");
    }
    ShieldOperationItem localShieldOperationItem = new ShieldOperationItem();
    localShieldOperationItem.jdField_a_of_type_Int = 1;
    localShieldOperationItem.jdField_a_of_type_ArrayOfLong = null;
    a(localShieldOperationItem);
  }
  
  public void a(int paramInt, long[] paramArrayOfLong)
  {
    b(paramInt, paramArrayOfLong, 0);
  }
  
  public void a(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><S> : msgType " + paramInt1 + ",uinList:" + Arrays.toString(paramArrayOfLong));
    }
    int k = paramArrayOfLong.length;
    if ((paramArrayOfLong == null) || (k <= 0)) {}
    ShieldOperationItem localShieldOperationItem;
    do
    {
      return;
      localShieldOperationItem = new ShieldOperationItem();
      localShieldOperationItem.jdField_a_of_type_Int = 2;
      localShieldOperationItem.b = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(paramInt1);
      localShieldOperationItem.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
      localShieldOperationItem.d = paramInt2;
    } while (localShieldOperationItem.b == -1);
    a(localShieldOperationItem);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    while ((!"SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str)) && (!"SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str)) && (!"SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str))) {
      return;
    }
    boolean bool2 = false;
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      boolean bool1;
      try
      {
        bool1 = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        if (bool1) {
          break;
        }
        c();
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception.", paramToServiceMsg);
        bool1 = bool2;
        continue;
      }
      if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        bool1 = bool2;
      }
      else
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        bool1 = bool2;
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    long l = -1L;
    long[] arrayOfLong = new long[1];
    boolean bool;
    if (paramInt == 1006)
    {
      paramString = ContactUtils.f(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      if ((paramString == null) || (paramString.length() <= 0)) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShieldListHandler", 2, "<---handleSendMsgErrorWhileShield : msgType:" + paramInt + Arrays.toString(arrayOfLong) + ",hasUin:" + bool);
      }
      if (bool)
      {
        arrayOfLong[0] = l;
        paramString = new ShieldListInfo();
        paramString.uin = String.valueOf(l);
        paramString.source_id = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(paramInt);
        paramString.source_sub_id = 0;
        paramString.flags = 1;
        localArrayList.add(paramString);
        ((ShieldMsgManger)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(localArrayList);
        a(true, paramString.source_id, arrayOfLong);
      }
      return;
      l = Long.valueOf(paramString).longValue();
      bool = true;
      continue;
      l = Long.valueOf(paramString).longValue();
      bool = true;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_push><R><---handleShieldListOnlinePush.");
    }
    Object localObject1 = new SubMsgType0x30.MsgBody();
    try
    {
      paramArrayOfByte = (SubMsgType0x30.MsgBody)((SubMsgType0x30.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.uint32_sub_cmd.has()) || (paramArrayOfByte.uint32_sub_cmd.get() != 1)) {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("<---handleShieldListOnlinePush : msgBody is null or NotSupportSubCMd :");
          if (paramArrayOfByte == null)
          {
            paramArrayOfByte = "null";
            QLog.e("ShieldListHandler", 2, paramArrayOfByte);
          }
        }
        else
        {
          return;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShieldListHandler", 2, "<---handleShieldListOnlinePush : fail to parse SubMsgType0x30.");
          }
          paramArrayOfByte = null;
          continue;
          paramArrayOfByte = Integer.valueOf(paramArrayOfByte.uint32_sub_cmd.get());
        }
        if (paramArrayOfByte.msg_s2c_blocklist_notify.has())
        {
          paramArrayOfByte = (SubMsgType0x30.BlockListNotify)paramArrayOfByte.msg_s2c_blocklist_notify.get();
          localObject1 = paramArrayOfByte.rpt_msg_block_uin_info.get();
          paramArrayOfByte = paramArrayOfByte.rpt_uint64_del_uin.get();
          Object localObject2;
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (SubMsgType0x30.BlockUinInfo)((Iterator)localObject1).next();
              ShieldListInfo localShieldListInfo = new ShieldListInfo();
              localShieldListInfo.uin = String.valueOf(((SubMsgType0x30.BlockUinInfo)localObject2).uint64_block_uin.get());
              localShieldListInfo.source_id = ((SubMsgType0x30.BlockUinInfo)localObject2).uint32_source_id.get();
              localShieldListInfo.source_sub_id = ((SubMsgType0x30.BlockUinInfo)localObject2).uint32_source_sub_id.get();
              localShieldListInfo.flags = 1;
              if (QLog.isColorLevel()) {
                QLog.d("ShieldListHandler", 2, "<---handleShieldListOnlinePush : add: uin:" + localShieldListInfo.uin + ",source_id:" + localShieldListInfo.source_id);
              }
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localShieldListInfo.uin, localShieldListInfo);
            }
          }
          if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
          {
            localObject1 = paramArrayOfByte.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              long l = ((Long)((Iterator)localObject1).next()).longValue();
              localObject2 = new ShieldListInfo();
              ((ShieldListInfo)localObject2).uin = String.valueOf(l);
              ((ShieldListInfo)localObject2).flags = 0;
              if (QLog.isColorLevel()) {
                QLog.d("ShieldListHandler", 2, "<---handleShieldListOnlinePush : del: uin:" + ((ShieldListInfo)localObject2).uin + ",source_id:" + ((ShieldListInfo)localObject2).source_id);
              }
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ShieldListInfo)localObject2).uin, localObject2);
            }
          }
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localObject1 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ShieldListHandler", 2, "handleShieldListOnlinePush, removeFriendFromBlackList");
            }
            ((MessageHandler)localObject1).a(paramArrayOfByte);
          }
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          d();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShieldListHandler", 2, "<---handleShieldListOnlinePush : is shield operating, put into cache.");
    }
  }
  
  public void b(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><S> : msgType:" + paramInt1 + ",uinList:" + Arrays.toString(paramArrayOfLong));
    }
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {}
    ShieldOperationItem localShieldOperationItem;
    do
    {
      return;
      localShieldOperationItem = new ShieldOperationItem();
      localShieldOperationItem.jdField_a_of_type_Int = 3;
      localShieldOperationItem.b = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(paramInt1);
      localShieldOperationItem.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
      localShieldOperationItem.d = paramInt2;
    } while (localShieldOperationItem.b == -1);
    a(localShieldOperationItem);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ShieldListHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */