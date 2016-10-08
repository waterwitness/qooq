package com.tencent.mobileqq.service.friendlist;

import BumpSvc.ReqConfirmContactFriend;
import NeighborComm.ReqHeader;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.troop.TroopService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import friendlist.AddFriendReq;
import friendlist.AddFriendResp;
import friendlist.CheckFriendReq;
import friendlist.DelFriendReq;
import friendlist.DelFriendResp;
import friendlist.EAddFriendSourceID;
import friendlist.GetAutoInfoReq;
import friendlist.GetAutoInfoResp;
import friendlist.GetFriendListReq;
import friendlist.GetFriendListResp;
import friendlist.GetFriendsVideoAbiResp;
import friendlist.GetLastLoginInfoReq;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoReq;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoReq;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.GetUserAddFriendSettingReq;
import friendlist.GetUserAddFriendSettingResp;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMem;
import friendlist.MovGroupMemReq;
import friendlist.MovGroupMemResp;
import friendlist.SetGroupResp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.GroupInfo;

public class FriendListService
  extends BaseProtocolCoder
{
  private static final int jdField_a_of_type_Int = 200;
  private static final String jdField_a_of_type_JavaLangString = "FriendListService";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "friendlist", "BumpSvc" };
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopService jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FriendListService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService = new TroopService(paramQQAppInterface);
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = paramLong + 4294967296L;
    }
    return String.valueOf(l);
  }
  
  private void a(int paramInt, byte paramByte1, long paramLong, short paramShort1, short paramShort2, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetFriendListReq");
    if (paramShort2 == 0) {
      paramShort2 = 200;
    }
    for (;;)
    {
      if (paramByte5 == 0) {
        paramByte5 = -56;
      }
      for (;;)
      {
        paramUniPacket.put("FL", new GetFriendListReq(paramInt, paramByte1, paramLong, paramShort1, paramShort2, paramByte2, paramByte3, paramByte4, paramByte5, (byte)0, (byte)1, 8L, null));
        return;
      }
    }
  }
  
  private void a(String paramString, UniPacket paramUniPacket)
  {
    a(3, (byte)1, Long.valueOf(paramString).longValue(), (short)0, (short)20, (byte)0, (byte)1, (byte)0, (byte)0, paramUniPacket);
  }
  
  private void a(String paramString, short paramShort1, short paramShort2, UniPacket paramUniPacket)
  {
    a(3, (byte)1, Long.valueOf(paramString).longValue(), paramShort1, paramShort2, (byte)0, (byte)0, (byte)0, (byte)0, paramUniPacket);
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return paramFromServiceMsg;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    int i = paramToServiceMsg.extraData.getInt("bType");
    long l2 = paramToServiceMsg.extraData.getLong("lToMID");
    long l3 = paramToServiceMsg.extraData.getLong("lFromMobile");
    long l4 = paramToServiceMsg.extraData.getLong("lToMobile");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vSig");
    byte b = paramToServiceMsg.extraData.getByte("bGroupId");
    String str = paramToServiceMsg.extraData.getString("strNickName");
    paramToServiceMsg = new ReqHeader();
    paramToServiceMsg.shVersion = 1;
    paramToServiceMsg.lMID = l1;
    paramToServiceMsg.iAppID = AppSetting.a;
    paramToServiceMsg.eBusiType = 1;
    paramToServiceMsg.eMqqSysType = 2;
    localObject = new ReqConfirmContactFriend((byte)i, l2, l3, l4, (byte[])localObject, b, null, str);
    paramUniPacket.setServantName("BumpSvc");
    paramUniPacket.setFuncName("CMD_CONFIRM_CONTACT_FRIEND");
    paramUniPacket.put("ReqHeader", paramToServiceMsg);
    paramUniPacket.put("ReqConfirmContactFriend", localObject);
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new UniPacket(true);
    paramFromServiceMsg.setEncodeName("utf-8");
    paramFromServiceMsg.decode(paramToServiceMsg);
    if ("GetOnlineInfoReq".equals(paramFromServiceMsg.getFuncName()))
    {
      paramToServiceMsg = (GetOnlineInfoResp)a(paramToServiceMsg, "GetOnlineInfoResp", new GetOnlineInfoResp());
      if (paramToServiceMsg == null) {
        return null;
      }
      paramToServiceMsg.dwStatus = ((byte)(int)paramToServiceMsg.dwStatus);
      return paramToServiceMsg;
    }
    return null;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    paramToServiceMsg = new GetSimpleOnlineFriendInfoReq(l, (byte)0, (byte)0, null, paramToServiceMsg.extraData.getByte("ifShowTermType"), 7L, paramToServiceMsg.extraData.getByte("srcType"));
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetSimpleOnlineFriendInfoReq");
    paramUniPacket.put("FSOLREQ", paramToServiceMsg);
    return true;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new UniPacket(true);
    paramFromServiceMsg.setEncodeName("utf-8");
    paramFromServiceMsg.decode(paramToServiceMsg);
    paramFromServiceMsg = paramFromServiceMsg.getFuncName();
    if ("GetSimpleOnlineFriendInfoReq".equals(paramFromServiceMsg))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)a(paramToServiceMsg, "FSOLRESP", new GetSimpleOnlineFriendInfoResp());
      if (paramFromServiceMsg == null) {
        paramToServiceMsg = null;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramToServiceMsg;
            paramToServiceMsg = paramFromServiceMsg;
          } while (paramFromServiceMsg == null);
          paramToServiceMsg = paramFromServiceMsg;
        } while (paramFromServiceMsg.result != 1);
        return null;
        if (!"GetFriendsVideoAbiResp".equals(paramFromServiceMsg)) {
          break;
        }
        paramFromServiceMsg = (GetFriendsVideoAbiResp)a(paramToServiceMsg, "VABRESP", new GetFriendsVideoAbiResp());
        paramToServiceMsg = paramFromServiceMsg;
      } while (paramFromServiceMsg == null);
      paramToServiceMsg = paramFromServiceMsg;
    } while (paramFromServiceMsg.result != 1);
    return null;
    return null;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("dwReqType");
    if (l == 0L) {}
    for (paramToServiceMsg = new GetOnlineInfoReq(l, paramToServiceMsg.extraData.getLong("dwUin"), null, 7L);; paramToServiceMsg = new GetOnlineInfoReq(l, 0L, paramToServiceMsg.extraData.getString("strMobile"), 7L))
    {
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetOnlineInfoReq");
      paramUniPacket.put("GetOnlineInfoReq", paramToServiceMsg);
      return true;
    }
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (DelFriendResp)a(paramFromServiceMsg.getWupBuffer(), "DFRESP", new DelFriendResp());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {}
    long l2;
    do
    {
      return false;
      l2 = a(paramToServiceMsg.extraData.getString("uin"));
    } while (l2 == 0L);
    paramToServiceMsg = new CheckFriendReq();
    paramToServiceMsg.uin = l1;
    paramToServiceMsg.fuin = l2;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("CheckFriendReq");
    paramUniPacket.put("CF", paramToServiceMsg);
    return true;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (AddFriendResp)a(paramFromServiceMsg.getWupBuffer(), "AFRESP", new AddFriendResp());
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    long l2 = a(paramToServiceMsg.getString("uin"));
    if (l2 == 0L) {
      return false;
    }
    if (l1 == l2) {
      return false;
    }
    byte b2 = paramToServiceMsg.getByte("del_type");
    byte b1;
    if (b2 == 1)
    {
      b1 = b2;
      if (b2 == 2) {}
    }
    else
    {
      b1 = 1;
    }
    paramToServiceMsg = new DelFriendReq();
    paramToServiceMsg.uin = l1;
    paramToServiceMsg.deluin = l2;
    paramToServiceMsg.delType = b1;
    paramToServiceMsg.version = 1;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("DelFriendReq");
    paramUniPacket.put("DF", paramToServiceMsg);
    return true;
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (MovGroupMemResp)a(paramFromServiceMsg.getWupBuffer(), "MovGroupMemResp", new MovGroupMemResp());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    Bundle localBundle = paramToServiceMsg.extraData;
    paramToServiceMsg = localBundle.getString("uin");
    i = localBundle.getInt("source_id", 10004);
    int j = localBundle.getInt("sub_source_id", 0);
    AddFriendReq localAddFriendReq = new AddFriendReq();
    localAddFriendReq.uin = l1;
    localAddFriendReq.sourceID = i;
    localAddFriendReq.sourceSubID = j;
    if ((i == 2007) || (i == 3007) || (i == 4007) || (i == 2017) || (i == 3017)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(paramToServiceMsg).longValue(), true, i);
    }
    Object localObject;
    byte b2;
    boolean bool;
    byte[] arrayOfByte;
    byte b1;
    if (i == 3016)
    {
      localObject = localBundle.getString("extra");
      if ((TextUtils.isEmpty(paramToServiceMsg)) || (TextUtils.isEmpty((CharSequence)localObject))) {
        return false;
      }
      localAddFriendReq.name = paramToServiceMsg.getBytes();
      localAddFriendReq.name1 = ((String)localObject).getBytes();
      i = localBundle.getInt("friend_setting");
      b2 = localBundle.getByte("group_id");
      localObject = localBundle.getString("msg");
      bool = localBundle.getBoolean("auto_send");
      arrayOfByte = localBundle.getByteArray("sig");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label613;
      }
      b1 = 0;
    }
    for (;;)
    {
      localAddFriendReq.adduinsetting = i;
      localAddFriendReq.myAllowFlag = 1;
      localAddFriendReq.msgLen = b1;
      if (localObject != null) {
        localAddFriendReq.msg = ((String)localObject);
      }
      localAddFriendReq.myfriendgroupid = b2;
      localAddFriendReq.contact_bothway_friend = localBundle.getBoolean("contact_bothway", false);
      localAddFriendReq.showMyCard = localBundle.getByte("show_my_card");
      localObject = localBundle.getString("remark");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramToServiceMsg = null;
      }
      try
      {
        localObject = ((String)localObject).getBytes("utf-8");
        paramToServiceMsg = (ToServiceMsg)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          long l2;
          localUnsupportedEncodingException.printStackTrace();
          continue;
          i = 0;
        }
      }
      localAddFriendReq.remark = paramToServiceMsg;
      if (!bool) {
        break label658;
      }
      i = 1;
      localAddFriendReq.autoSend = ((byte)i);
      if (arrayOfByte != null) {
        localAddFriendReq.sig = arrayOfByte;
      }
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("AddFriendReq");
      paramUniPacket.put("AF", localAddFriendReq);
      return true;
      if (EAddFriendSourceID.a(i))
      {
        if (!TextUtils.isEmpty(paramToServiceMsg))
        {
          localAddFriendReq.name = paramToServiceMsg.getBytes();
          break;
        }
        return false;
      }
      if (i == 3026)
      {
        if (j == 0)
        {
          if (!TextUtils.isEmpty(paramToServiceMsg))
          {
            localAddFriendReq.name = paramToServiceMsg.getBytes();
            break;
          }
          return false;
        }
        l2 = a(paramToServiceMsg);
        if ((l2 == 0L) || (l1 == l2)) {
          return false;
        }
        localAddFriendReq.adduin = l2;
        break;
      }
      l2 = a(paramToServiceMsg);
      if ((l2 == 0L) || (l1 == l2)) {
        return false;
      }
      localAddFriendReq.adduin = l2;
      if (3004 != i) {
        break;
      }
      paramToServiceMsg = localBundle.getString("extra");
      if ((paramToServiceMsg == null) || (paramToServiceMsg.length() <= 0)) {
        break;
      }
      localObject = new FrdSysMsg.GroupInfo();
      ((FrdSysMsg.GroupInfo)localObject).uint64_group_uin.set(a(paramToServiceMsg));
      localAddFriendReq.friend_src_desc = ((FrdSysMsg.GroupInfo)localObject).toByteArray();
      break;
      label613:
      paramToServiceMsg = (ToServiceMsg)localObject;
      if (((String)localObject).length() >= 127) {
        paramToServiceMsg = ((String)localObject).substring(0, 126);
      }
      b1 = (byte)paramToServiceMsg.getBytes().length;
      localObject = paramToServiceMsg;
    }
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetUserAddFriendSettingResp)a(paramFromServiceMsg.getWupBuffer(), "FSRESP", new GetUserAddFriendSettingResp());
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Byte localByte = Byte.valueOf(paramToServiceMsg.extraData.getByte("move_fri_type"));
    if (localByte.byteValue() == 0) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    if (localByte.byteValue() == 1) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetFriendListResp)a(paramFromServiceMsg.getWupBuffer(), "FLRESP", new GetFriendListResp());
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {}
    long l2;
    byte b;
    do
    {
      do
      {
        return false;
        paramToServiceMsg = paramToServiceMsg.extraData;
        l2 = a(paramToServiceMsg.getString("uin"));
      } while ((l2 == 0L) || (l1 == l2));
      b = paramToServiceMsg.getByte("group_id");
    } while (b < 0);
    paramToServiceMsg = new MovGroupMem();
    paramToServiceMsg.Ver = 1;
    paramToServiceMsg.wReqLen = 5;
    paramToServiceMsg.dwUin = l2;
    paramToServiceMsg.cGroupid = b;
    paramToServiceMsg.wReserveLen = 0;
    MovGroupMemReq localMovGroupMemReq = new MovGroupMemReq();
    localMovGroupMemReq.uin = l1;
    localMovGroupMemReq.reqtype = 0;
    paramToServiceMsg = null;
    try
    {
      Object localObject = new ByteArrayOutputStream(10);
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeByte(1);
      localDataOutputStream.writeShort(5);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.writeByte(b);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramToServiceMsg = (ToServiceMsg)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    localMovGroupMemReq.vecBody = paramToServiceMsg;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("MovGroupMemReq");
    paramUniPacket.put("MovGroupMemReq", localMovGroupMemReq);
    return true;
  }
  
  private Object j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetLastLoginInfoResp)a(paramFromServiceMsg.getWupBuffer(), "GetLastLoginInfoResp", new GetLastLoginInfoResp());
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    Object localObject = paramToServiceMsg.extraData;
    String[] arrayOfString = ((Bundle)localObject).getStringArray("uins");
    MovGroupMemReq localMovGroupMemReq = new MovGroupMemReq();
    localMovGroupMemReq.uin = l1;
    localMovGroupMemReq.reqtype = 1;
    paramToServiceMsg = null;
    for (;;)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeByte(1);
        localDataOutputStream.writeShort(arrayOfString.length * 5);
        i = 0;
        if ((arrayOfString != null) && (i < arrayOfString.length))
        {
          l2 = a(arrayOfString[i]);
          if (l2 != 0L) {
            continue;
          }
        }
        localDataOutputStream.writeShort(0);
        localDataOutputStream.close();
        localObject = localByteArrayOutputStream.toByteArray();
        paramToServiceMsg = (ToServiceMsg)localObject;
      }
      catch (IOException localIOException)
      {
        DataOutputStream localDataOutputStream;
        int i;
        long l2;
        int j;
        continue;
      }
      localMovGroupMemReq.vecBody = paramToServiceMsg;
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("MovGroupMemReq");
      paramUniPacket.put("MovGroupMemReq", localMovGroupMemReq);
      return true;
      if (l1 != l2)
      {
        j = ((Bundle)localObject).getByte("group_id");
        if (j >= 0)
        {
          localDataOutputStream.writeInt((int)l2);
          localDataOutputStream.writeByte(j);
          i += 1;
        }
      }
    }
  }
  
  private Object k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SetGroupResp)a(paramFromServiceMsg.getWupBuffer(), "SetGroupResp", new SetGroupResp());
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    Object localObject = paramToServiceMsg.extraData;
    int i = ((Bundle)localObject).getInt("source_id");
    int j = ((Bundle)localObject).getInt("sub_source_id");
    paramToServiceMsg = ((Bundle)localObject).getString("uin");
    localObject = ((Bundle)localObject).getString("extra");
    GetUserAddFriendSettingReq localGetUserAddFriendSettingReq = new GetUserAddFriendSettingReq();
    localGetUserAddFriendSettingReq.version = 1L;
    localGetUserAddFriendSettingReq.uin = l;
    localGetUserAddFriendSettingReq.sourceID = i;
    if (EAddFriendSourceID.a(i)) {
      localGetUserAddFriendSettingReq.name = paramToServiceMsg.getBytes();
    }
    for (;;)
    {
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetUserAddFriendSettingReq");
      paramUniPacket.put("FS", localGetUserAddFriendSettingReq);
      return true;
      if (i == 3016)
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localGetUserAddFriendSettingReq.name = paramToServiceMsg.getBytes();
        localGetUserAddFriendSettingReq.name1 = ((String)localObject).getBytes();
        continue;
      }
      if (i == 3026)
      {
        localGetUserAddFriendSettingReq.sourceSubID = j;
        if (j == 0)
        {
          localGetUserAddFriendSettingReq.name = paramToServiceMsg.getBytes();
          continue;
        }
        l = a(paramToServiceMsg);
        if (l == 0L) {
          break;
        }
        localGetUserAddFriendSettingReq.queryuin = l;
        continue;
      }
      l = a(paramToServiceMsg);
      if (l == 0L) {
        break;
      }
      localGetUserAddFriendSettingReq.queryuin = l;
    }
  }
  
  private Object l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetAutoInfoResp)a(paramFromServiceMsg.getWupBuffer(), "GAIRESP", new GetAutoInfoResp());
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.extraData.getBoolean("getSingleFriend")) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    return n(paramToServiceMsg, paramUniPacket);
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("targetUin");
    if (TextUtils.isEmpty(paramToServiceMsg)) {
      return false;
    }
    GetFriendListReq localGetFriendListReq = new GetFriendListReq();
    localGetFriendListReq.reqtype = 3;
    localGetFriendListReq.ifReflush = 1;
    localGetFriendListReq.ifShowTermType = 1;
    localGetFriendListReq.version = 10L;
    ArrayList localArrayList = new ArrayList(1);
    try
    {
      localGetFriendListReq.uin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localArrayList.add(Long.valueOf(Long.parseLong(paramToServiceMsg)));
      localGetFriendListReq.uinList = localArrayList;
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetFriendListReq");
      paramUniPacket.put("FL", localGetFriendListReq);
      return true;
    }
    catch (NumberFormatException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return false;
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    short s1 = paramToServiceMsg.extraData.getShort("friendStartIndex");
    short s2 = paramToServiceMsg.extraData.getShort("friendCount");
    byte b1 = paramToServiceMsg.extraData.getByte("groupStartIndex");
    byte b2 = paramToServiceMsg.extraData.getByte("groupCount");
    byte b3 = paramToServiceMsg.extraData.getByte("ifShowTermType");
    if (s1 > 0) {}
    for (int i = 0;; i = 1)
    {
      paramToServiceMsg = new GetFriendListReq(3, (byte)i, Long.valueOf(paramToServiceMsg.getUin()).longValue(), s1, s2, (byte)0, (byte)i, b1, b2, (byte)0, b3, 16L, null);
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetFriendListReq");
      paramUniPacket.put("FL", paramToServiceMsg);
      return true;
    }
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("uin");
    long l2 = paramToServiceMsg.extraData.getLong("current_req_uin");
    long l3 = paramToServiceMsg.extraData.getLong("current_req_index");
    paramToServiceMsg = new GetLastLoginInfoReq(l1, new LastLoginPageInfo(paramToServiceMsg.extraData.getLong("total_req_times"), l3, l2));
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetLastLoginInfoReq");
    paramUniPacket.put("GetLastLoginInfoReq", paramToServiceMsg);
    return true;
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetAutoInfoReq localGetAutoInfoReq = new GetAutoInfoReq();
    localGetAutoInfoReq.uin = a(paramToServiceMsg.getUin());
    localGetAutoInfoReq.dwFriendUin = a(paramToServiceMsg.extraData.getString("uin"));
    localGetAutoInfoReq.cType = paramToServiceMsg.extraData.getByte("cType");
    localGetAutoInfoReq.sourceID = paramToServiceMsg.extraData.getInt("source_id", 10004);
    localGetAutoInfoReq.sourceSubID = paramToServiceMsg.extraData.getInt("sub_source_id", 0);
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetAutoInfoReq");
    paramUniPacket.put("GAIREQ", localGetAutoInfoReq);
    return true;
  }
  
  /* Error */
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 67
    //   3: invokevirtual 73	com/qq/jce/wup/UniPacket:setServantName	(Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc_w 672
    //   10: invokevirtual 78	com/qq/jce/wup/UniPacket:setFuncName	(Ljava/lang/String;)V
    //   13: new 674	friendlist/SetGroupReq
    //   16: dup
    //   17: invokespecial 675	friendlist/SetGroupReq:<init>	()V
    //   20: astore_3
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual 111	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   26: invokestatic 56	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   29: putfield 676	friendlist/SetGroupReq:uin	J
    //   32: aload_3
    //   33: aload_1
    //   34: getfield 117	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   37: ldc_w 678
    //   40: invokevirtual 125	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   43: putfield 679	friendlist/SetGroupReq:reqtype	I
    //   46: new 513	java/io/ByteArrayOutputStream
    //   49: dup
    //   50: bipush 10
    //   52: invokespecial 516	java/io/ByteArrayOutputStream:<init>	(I)V
    //   55: astore 4
    //   57: new 518	java/io/DataOutputStream
    //   60: dup
    //   61: aload 4
    //   63: invokespecial 521	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore 5
    //   68: aload_3
    //   69: getfield 679	friendlist/SetGroupReq:reqtype	I
    //   72: tableswitch	default:+375->447, 0:+32->104, 1:+138->210, 2:+223->295, 3:+260->332
    //   104: new 681	friendlist/AddGroup
    //   107: dup
    //   108: invokespecial 682	friendlist/AddGroup:<init>	()V
    //   111: astore 6
    //   113: aload 6
    //   115: aload_1
    //   116: getfield 117	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   119: ldc_w 684
    //   122: invokevirtual 146	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   125: putfield 687	friendlist/AddGroup:cSortId	B
    //   128: aload 6
    //   130: aload_1
    //   131: getfield 117	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   134: ldc_w 689
    //   137: invokevirtual 152	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: putfield 692	friendlist/AddGroup:sGroupName	Ljava/lang/String;
    //   143: aload 6
    //   145: getfield 692	friendlist/AddGroup:sGroupName	Ljava/lang/String;
    //   148: invokevirtual 360	java/lang/String:getBytes	()[B
    //   151: astore_1
    //   152: aload 6
    //   154: aload_1
    //   155: arraylength
    //   156: i2b
    //   157: putfield 695	friendlist/AddGroup:cLen	B
    //   160: aload 5
    //   162: aload 6
    //   164: getfield 687	friendlist/AddGroup:cSortId	B
    //   167: invokevirtual 524	java/io/DataOutputStream:writeByte	(I)V
    //   170: aload 5
    //   172: aload 6
    //   174: getfield 695	friendlist/AddGroup:cLen	B
    //   177: invokevirtual 524	java/io/DataOutputStream:writeByte	(I)V
    //   180: aload 5
    //   182: aload_1
    //   183: invokevirtual 698	java/io/DataOutputStream:write	([B)V
    //   186: aload 5
    //   188: invokevirtual 533	java/io/DataOutputStream:close	()V
    //   191: aload_3
    //   192: aload 4
    //   194: invokevirtual 534	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   197: putfield 699	friendlist/SetGroupReq:vecBody	[B
    //   200: aload_2
    //   201: ldc_w 672
    //   204: aload_3
    //   205: invokevirtual 91	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   208: iconst_1
    //   209: ireturn
    //   210: new 701	friendlist/RenameGroup
    //   213: dup
    //   214: invokespecial 702	friendlist/RenameGroup:<init>	()V
    //   217: astore 6
    //   219: aload 6
    //   221: aload_1
    //   222: getfield 117	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   225: ldc_w 371
    //   228: invokevirtual 146	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   231: putfield 705	friendlist/RenameGroup:cGroupId	B
    //   234: aload 6
    //   236: aload_1
    //   237: getfield 117	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   240: ldc_w 689
    //   243: invokevirtual 152	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: putfield 706	friendlist/RenameGroup:sGroupName	Ljava/lang/String;
    //   249: aload 6
    //   251: getfield 706	friendlist/RenameGroup:sGroupName	Ljava/lang/String;
    //   254: invokevirtual 360	java/lang/String:getBytes	()[B
    //   257: astore_1
    //   258: aload 6
    //   260: aload_1
    //   261: arraylength
    //   262: i2b
    //   263: putfield 707	friendlist/RenameGroup:cLen	B
    //   266: aload 5
    //   268: aload 6
    //   270: getfield 705	friendlist/RenameGroup:cGroupId	B
    //   273: invokevirtual 709	java/io/DataOutputStream:write	(I)V
    //   276: aload 5
    //   278: aload 6
    //   280: getfield 707	friendlist/RenameGroup:cLen	B
    //   283: invokevirtual 524	java/io/DataOutputStream:writeByte	(I)V
    //   286: aload 5
    //   288: aload_1
    //   289: invokevirtual 698	java/io/DataOutputStream:write	([B)V
    //   292: goto -106 -> 186
    //   295: new 711	friendlist/DelGroup
    //   298: dup
    //   299: invokespecial 712	friendlist/DelGroup:<init>	()V
    //   302: astore 6
    //   304: aload 6
    //   306: aload_1
    //   307: getfield 117	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   310: ldc_w 371
    //   313: invokevirtual 146	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   316: putfield 713	friendlist/DelGroup:cGroupId	B
    //   319: aload 5
    //   321: aload 6
    //   323: getfield 713	friendlist/DelGroup:cGroupId	B
    //   326: invokevirtual 524	java/io/DataOutputStream:writeByte	(I)V
    //   329: goto -143 -> 186
    //   332: new 715	friendlist/ReSortGroup
    //   335: dup
    //   336: invokespecial 716	friendlist/ReSortGroup:<init>	()V
    //   339: astore 6
    //   341: aload 6
    //   343: aload_1
    //   344: getfield 117	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   347: ldc_w 718
    //   350: invokevirtual 140	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   353: putfield 720	friendlist/ReSortGroup:cGroupId	[B
    //   356: aload 6
    //   358: aload_1
    //   359: getfield 117	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   362: ldc_w 722
    //   365: invokevirtual 140	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   368: putfield 724	friendlist/ReSortGroup:cSortId	[B
    //   371: aload 6
    //   373: aload 6
    //   375: getfield 720	friendlist/ReSortGroup:cGroupId	[B
    //   378: arraylength
    //   379: i2b
    //   380: putfield 727	friendlist/ReSortGroup:cNum	B
    //   383: aload 5
    //   385: aload 6
    //   387: getfield 727	friendlist/ReSortGroup:cNum	B
    //   390: invokevirtual 524	java/io/DataOutputStream:writeByte	(I)V
    //   393: aload 6
    //   395: getfield 720	friendlist/ReSortGroup:cGroupId	[B
    //   398: astore_1
    //   399: aload 6
    //   401: getfield 724	friendlist/ReSortGroup:cSortId	[B
    //   404: astore 6
    //   406: iconst_0
    //   407: istore 7
    //   409: iload 7
    //   411: aload_1
    //   412: arraylength
    //   413: if_icmpge -227 -> 186
    //   416: aload 5
    //   418: aload_1
    //   419: iload 7
    //   421: baload
    //   422: invokevirtual 524	java/io/DataOutputStream:writeByte	(I)V
    //   425: aload 5
    //   427: aload 6
    //   429: iload 7
    //   431: baload
    //   432: invokevirtual 524	java/io/DataOutputStream:writeByte	(I)V
    //   435: iload 7
    //   437: iconst_1
    //   438: iadd
    //   439: istore 7
    //   441: goto -32 -> 409
    //   444: astore_1
    //   445: iconst_0
    //   446: ireturn
    //   447: iconst_0
    //   448: ireturn
    //   449: astore_1
    //   450: iconst_0
    //   451: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	FriendListService
    //   0	452	1	paramToServiceMsg	ToServiceMsg
    //   0	452	2	paramUniPacket	UniPacket
    //   20	185	3	localSetGroupReq	friendlist.SetGroupReq
    //   55	138	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   66	360	5	localDataOutputStream	DataOutputStream
    //   111	317	6	localObject	Object
    //   407	33	7	i	int
    // Exception table:
    //   from	to	target	type
    //   21	32	444	java/lang/NumberFormatException
    //   68	104	449	java/io/IOException
    //   104	186	449	java/io/IOException
    //   186	191	449	java/io/IOException
    //   210	292	449	java/io/IOException
    //   295	329	449	java/io/IOException
    //   332	406	449	java/io/IOException
    //   409	435	449	java/io/IOException
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("friendlist.getFriendGroupList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return i(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetLastLoginInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return j(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.MovGroupMemReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("BumpSvc.ReqComfirmContactFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.addFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.getUserAddFriendSetting".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return h(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetSimpleOnlineFriendInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetOnlineInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.delFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return e(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.SetGroupReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return k(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetAutoInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return l(paramToServiceMsg, paramFromServiceMsg);
    }
    if (("friendlist.GetTroopListReqV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.GetMultiTroopInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.getTroopRemark".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.getTroopMemberList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.ModifyGroupInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.GetTroopAppointRemarkReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
      return this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService.a(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getFriendGroupList")) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetLastLoginInfoReq")) {
      return o(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.delFriend")) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.addFriend")) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.checkFriend")) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getUserAddFriendSetting")) {
      return k(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetSimpleOnlineFriendInfoReq")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetOnlineInfoReq")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("BumpSvc.ReqComfirmContactFriend")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.MovGroupMemReq")) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.SetGroupReq")) {
      return q(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetAutoInfoReq")) {
      return p(paramToServiceMsg, paramUniPacket);
    }
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetTroopListReqV2")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getTroopMemberList")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getTroopRemark")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetMultiTroopInfoReq")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.ModifyGroupCardReq")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetTroopAppointRemarkReq")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.ModifyGroupInfoReq"))) {
      return this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService.a(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\friendlist\FriendListService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */