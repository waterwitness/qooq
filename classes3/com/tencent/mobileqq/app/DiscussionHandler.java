package com.tencent.mobileqq.app;

import KQQ.ProfSmpInfoRes;
import QQService.AddDiscussMemberInfo;
import QQService.DiscussInfo;
import QQService.DiscussMemberInfo;
import QQService.DiscussRespHeader;
import QQService.InteRemarkInfo;
import QQService.RespAddDiscussMember;
import QQService.RespChangeDiscussName;
import QQService.RespCreateDiscuss;
import QQService.RespGetDiscuss;
import QQService.RespGetDiscussInfo;
import QQService.RespGetDiscussInteRemark;
import QQService.RespJoinDiscuss;
import QQService.RespQuitDiscuss;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.service.discussion.DiscussionReceiver.RespPackage;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlRequest;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlResponse;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeRequest;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeResponse;
import com.tencent.protofile.discuss.FlyTicket.RetInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import pxa;
import tencent.im.oidb.cmd0x58b.cmd0x58b.ConfBaseInfo;
import tencent.im.oidb.cmd0x58b.cmd0x58b.ConfMemberInfo;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetConfInfoReq;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetConfInfoRsp;
import tencent.im.oidb.cmd0x58b.cmd0x58b.ReqBody;
import tencent.im.oidb.cmd0x58b.cmd0x58b.RspBody;
import tencent.im.oidb.cmd0x751.oidb_0x751.CheckIsConfMemberResult;
import tencent.im.oidb.cmd0x751.oidb_0x751.ReqBody;
import tencent.im.oidb.cmd0x751.oidb_0x751.ReqCheckIsConfMember;
import tencent.im.oidb.cmd0x751.oidb_0x751.RspBody;
import tencent.im.oidb.cmd0x751.oidb_0x751.RspCheckIsConfMember;
import tencent.im.oidb.cmd0x921.cmd0x921.GetAtAllRemain;
import tencent.im.oidb.cmd0x921.cmd0x921.GetAtAllRemainRsp;
import tencent.im.oidb.cmd0x921.cmd0x921.ReqBody;
import tencent.im.oidb.cmd0x921.cmd0x921.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DiscussionHandler
  extends BusinessHandler
{
  private static final int A = -1;
  private static final int B = 0;
  private static final int C = 1;
  private static final int D = 0;
  private static final int H = 500;
  private static final int I = 10;
  public static final int a = 1000;
  private static final long jdField_a_of_type_Long = 120000L;
  public static final String a = "key_cmd";
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 1001;
  private static final String jdField_b_of_type_JavaLangString = "DiscussionHandler";
  public static final int c = 1002;
  private static final String jdField_c_of_type_JavaLangString = "DiscusstionIconVersion";
  public static final int d = 1003;
  public static final int e = 1004;
  public static final int f = 1005;
  public static final int g = 1006;
  public static final int h = 1007;
  public static final int i = 1008;
  public static final int j = 1009;
  public static final int k = 1010;
  public static final int l = 1011;
  public static final int m = 1012;
  public static final int n = 1013;
  public static final int o = 1014;
  public static final int p = 1015;
  public static final int q = 1016;
  public static final int r = 1017;
  public static final int s = 1018;
  public static final int t = 2000;
  public static final int u = 0;
  public static final int v = 10001;
  public static final int w = 10002;
  public static final int x = 1000;
  public static final int y = 0;
  private static final int z = 1;
  private DiscussionIconHelper jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private long jdField_b_of_type_Long;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private long jdField_c_of_type_Long;
  
  DiscussionHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper = new DiscussionIconHelper(paramQQAppInterface.a(), this);
  }
  
  private void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getString("signature") != null) {
      return;
    }
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    this.jdField_a_of_type_JavaUtilList.remove(paramToServiceMsg);
    if (a()) {
      e();
    }
    a(1001, false, new Object[] { String.valueOf(paramToServiceMsg), Boolean.valueOf(false) });
  }
  
  private void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    A(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private ArrayList a(long paramLong)
  {
    Object localObject = ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(String.valueOf(paramLong));
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf((String)((Map.Entry)((Iterator)localObject).next()).getKey()));
      }
    }
    return localArrayList;
  }
  
  private HashMap a(long paramLong)
  {
    Object localObject = ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(String.valueOf(paramLong));
    HashMap localHashMap = new HashMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Map.Entry)((Iterator)localObject).next()).getValue();
        localHashMap.put(Long.valueOf(localDiscussionMemberInfo.memberUin), Integer.valueOf((int)localDiscussionMemberInfo.inteRemarkSource));
      }
    }
    return localHashMap;
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(64532);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, NetConnInfoCenter.getServerTime(), 64532, 3000, NetConnInfoCenter.getServerTime());
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "----------addMsgToDB after analysis friendUin: " + paramLong2 + " msgType: " + 64532 + " friendType: " + 3000 + " msgContent: " + Utils.a(paramString));
    }
    paramString = (MessageHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    if (!MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleError serviceCmd:" + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      j(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscuss".equalsIgnoreCase(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("ProfileService.GetSimpleInfo".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x921_0".equals(str))
      {
        a(1018, false, new Object[] { paramToServiceMsg.extraData.getString("discUid"), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) });
        return;
      }
      if ("OidbSvc.0x58b_0".equals(str))
      {
        A(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"OidbSvc.0x751".equalsIgnoreCase(str));
    s(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  private boolean a(String paramString, ArrayList paramArrayList, Map paramMap)
  {
    boolean bool2 = false;
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    ArrayList localArrayList = new ArrayList();
    long l1;
    Object localObject;
    DiscussionMemberInfo localDiscussionMemberInfo;
    boolean bool1;
    if ((paramArrayList != null) && (paramMap != null))
    {
      l1 = System.currentTimeMillis();
      paramString = paramArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (DiscussMemberInfo)paramString.next();
        if ((paramArrayList.StInteRemark != null) && (!TextUtils.isEmpty(paramArrayList.StInteRemark.StrValue)))
        {
          localObject = String.valueOf(paramArrayList.Uin);
          localDiscussionMemberInfo = (DiscussionMemberInfo)paramMap.get(localObject);
          if (localDiscussionMemberInfo == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DiscussionHandler", 2, "warning dbMemberInfo is null uin=" + (String)localObject);
            }
          }
          else if ((!TextUtils.isEmpty(localDiscussionMemberInfo.memberUin)) && (localDiscussionMemberInfo.memberUin.equals(localObject)) && (!TextUtils.isEmpty(localDiscussionMemberInfo.inteRemark)) && (!localDiscussionMemberInfo.inteRemark.equals(paramArrayList.StInteRemark.StrValue)))
          {
            localDiscussionMemberInfo.dataTime = l1;
            localDiscussionMemberInfo.inteRemark = paramArrayList.StInteRemark.StrValue;
            localDiscussionMemberInfo.inteRemarkSource = paramArrayList.StInteRemark.Source;
            localArrayList.add(localDiscussionMemberInfo);
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        localDiscussionManager.b(localArrayList);
      }
      return bool1;
      bool1 = bool2;
      if (paramArrayList != null)
      {
        bool1 = bool2;
        if (paramMap == null)
        {
          l1 = System.currentTimeMillis();
          paramMap = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          localObject = paramArrayList.iterator();
          bool1 = bool2;
          if (((Iterator)localObject).hasNext())
          {
            paramArrayList = (DiscussMemberInfo)((Iterator)localObject).next();
            localDiscussionMemberInfo = new DiscussionMemberInfo();
            localDiscussionMemberInfo.discussionUin = paramString;
            localDiscussionMemberInfo.memberUin = String.valueOf(paramArrayList.Uin);
            localDiscussionMemberInfo.flag = paramArrayList.Flag;
            localDiscussionMemberInfo.dataTime = l1;
            if ((paramArrayList.StInteRemark != null) && (!TextUtils.isEmpty(paramArrayList.StInteRemark.StrValue)))
            {
              localDiscussionMemberInfo.inteRemark = paramArrayList.StInteRemark.StrValue;
              localDiscussionMemberInfo.inteRemarkSource = paramArrayList.StInteRemark.Source;
            }
            for (;;)
            {
              localArrayList.add(localDiscussionMemberInfo);
              break;
              paramArrayList = paramMap.a(localDiscussionMemberInfo.memberUin);
              if ((paramArrayList != null) && (paramArrayList.isFriend()))
              {
                localDiscussionMemberInfo.memberName = paramArrayList.name;
                if (TextUtils.isEmpty(paramArrayList.remark)) {}
                for (paramArrayList = paramArrayList.name;; paramArrayList = paramArrayList.remark)
                {
                  localDiscussionMemberInfo.inteRemark = paramArrayList;
                  localDiscussionMemberInfo.inteRemarkSource = 129L;
                  break;
                }
              }
              localDiscussionMemberInfo.inteRemarkSource = 0L;
            }
            bool1 = false;
          }
        }
      }
    }
  }
  
  private boolean a(String paramString, List paramList, Map paramMap)
  {
    boolean bool2 = false;
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    ArrayList localArrayList = new ArrayList();
    long l1;
    Object localObject;
    DiscussionMemberInfo localDiscussionMemberInfo;
    boolean bool1;
    if ((paramList != null) && (paramMap != null))
    {
      l1 = System.currentTimeMillis();
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (cmd0x58b.ConfMemberInfo)paramString.next();
        if ((paramList.bytes_member_interemark.has()) && (!TextUtils.isEmpty(paramList.bytes_member_interemark.get().toStringUtf8())))
        {
          localObject = String.valueOf(paramList.uint64_uin.get());
          localDiscussionMemberInfo = (DiscussionMemberInfo)paramMap.get(localObject);
          if (localDiscussionMemberInfo == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DiscussionHandler", 2, "warning dbMemberInfo is null uin=" + (String)localObject);
            }
          }
          else if ((!TextUtils.isEmpty(localDiscussionMemberInfo.memberUin)) && (localDiscussionMemberInfo.memberUin.equals(localObject)) && (!TextUtils.isEmpty(localDiscussionMemberInfo.inteRemark)) && (!localDiscussionMemberInfo.inteRemark.equals(paramList.bytes_member_interemark.get().toStringUtf8())))
          {
            localDiscussionMemberInfo.dataTime = l1;
            localDiscussionMemberInfo.inteRemark = paramList.bytes_member_interemark.get().toStringUtf8();
            localDiscussionMemberInfo.inteRemarkSource = paramList.uint32_interemark_source.get();
            localArrayList.add(localDiscussionMemberInfo);
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        localDiscussionManager.b(localArrayList);
      }
      return bool1;
      bool1 = bool2;
      if (paramList != null)
      {
        bool1 = bool2;
        if (paramMap == null)
        {
          l1 = System.currentTimeMillis();
          paramMap = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          localObject = paramList.iterator();
          bool1 = bool2;
          if (((Iterator)localObject).hasNext())
          {
            paramList = (cmd0x58b.ConfMemberInfo)((Iterator)localObject).next();
            localDiscussionMemberInfo = new DiscussionMemberInfo();
            localDiscussionMemberInfo.discussionUin = paramString;
            localDiscussionMemberInfo.memberUin = String.valueOf(paramList.uint64_uin.get());
            localDiscussionMemberInfo.flag = ((byte)paramList.uint32_flag.get());
            localDiscussionMemberInfo.dataTime = l1;
            if ((paramList.bytes_member_interemark.has()) && (!TextUtils.isEmpty(paramList.bytes_member_interemark.get().toStringUtf8())))
            {
              localDiscussionMemberInfo.inteRemark = paramList.bytes_member_interemark.get().toStringUtf8();
              localDiscussionMemberInfo.inteRemarkSource = paramList.uint32_interemark_source.get();
            }
            for (;;)
            {
              localArrayList.add(localDiscussionMemberInfo);
              break;
              paramList = paramMap.a(localDiscussionMemberInfo.memberUin);
              if ((paramList != null) && (paramList.isFriend()))
              {
                localDiscussionMemberInfo.memberName = paramList.name;
                if (TextUtils.isEmpty(paramList.remark)) {}
                for (paramList = paramList.name;; paramList = paramList.remark)
                {
                  localDiscussionMemberInfo.inteRemark = paramList;
                  localDiscussionMemberInfo.inteRemarkSource = 129L;
                  break;
                }
              }
              localDiscussionMemberInfo.inteRemarkSource = 0L;
            }
            bool1 = false;
          }
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("discussionUin");
    if ((paramToServiceMsg.extraData.getInt("type") != 3000) || (paramFromServiceMsg == null)) {
      return;
    }
    a(1006, false, paramFromServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1004, false, String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getString("signature") != null) {
      return;
    }
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    this.jdField_a_of_type_JavaUtilList.remove(paramToServiceMsg);
    if (a()) {
      a();
    }
    a(1001, false, new Object[] { String.valueOf(paramToServiceMsg), Boolean.valueOf(false) });
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1000, false, null);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[2] = Integer.valueOf(-1);
    a(1002, false, paramToServiceMsg);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1005, false, String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1003, false, new Object[] { String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")), Integer.valueOf(-1), null });
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      z(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
      {
        y(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
      {
        x(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscuss".equalsIgnoreCase(str))
      {
        w(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str))
      {
        v(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        u(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        t(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        s(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("ProfileService.GetSimpleInfo".equals(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x865_3".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x870_4".equals(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x870_5".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x921_0".equals(str))
      {
        a(1018, false, new Object[] { paramToServiceMsg.extraData.getString("discUid"), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) });
        return;
      }
      if ("OidbSvc.0x58b_0".equalsIgnoreCase(str))
      {
        B(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"OidbSvc.0x751".equalsIgnoreCase(str));
    s(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("dwDelMemberUin");
    a(1015, false, new long[] { Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")).longValue(), Long.valueOf(l1).longValue() });
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1017, false, Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")));
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1016, false, Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")));
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    l(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    m(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    n(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("discUid");
    paramToServiceMsg = new Object[4];
    paramToServiceMsg[0] = paramFromServiceMsg;
    paramToServiceMsg[1] = Boolean.valueOf(false);
    paramToServiceMsg[2] = Integer.valueOf(0);
    paramToServiceMsg[3] = Integer.valueOf(0);
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.has()) || (((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get() != 0) || (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null))
      {
        a(1018, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(1018, false, paramToServiceMsg);
      return;
    }
    localObject = new cmd0x921.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x921.RspBody)localObject).mergeFrom(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray());
        boolean bool = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.bool_priviledge.get();
        if (!((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.has()) {
          break label290;
        }
        i1 = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.get();
        if (((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.has())
        {
          i2 = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.get();
          a(1018, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(i2) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(1018, false, paramToServiceMsg);
        return;
      }
      int i2 = 0;
      continue;
      label290:
      int i1 = 0;
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (DiscussionReceiver.RespPackage)paramObject;
    paramObject = (RespGetDiscussInteRemark)paramToServiceMsg.b;
    long l1 = ((RespGetDiscussInteRemark)paramObject).DiscussUin;
    Object localObject1 = (DiscussRespHeader)paramToServiceMsg.jdField_a_of_type_JavaLangObject;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleGetDiscussInteRemarkResp header.Result" + ((DiscussRespHeader)localObject1).Result);
    }
    if (((DiscussRespHeader)localObject1).Result != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("DiscussionHandler", 2, "header failed code: " + ((DiscussRespHeader)localObject1).Result);
      }
      a(1010, false, Long.valueOf(l1));
    }
    do
    {
      return;
      if ((!paramFromServiceMsg.isSuccess()) || (!paramToServiceMsg.jdField_a_of_type_Boolean))
      {
        a(1010, false, Long.valueOf(l1));
        return;
      }
      paramToServiceMsg = ((RespGetDiscussInteRemark)paramObject).InteRemarks;
      paramFromServiceMsg = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      paramObject = paramFromServiceMsg.a(String.valueOf(l1));
    } while ((paramToServiceMsg == null) || (paramObject == null));
    paramToServiceMsg.keySet();
    localObject1 = paramToServiceMsg.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Long)((Iterator)localObject1).next();
      DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Map)paramObject).get(String.valueOf(localObject2));
      if (localDiscussionMemberInfo != null)
      {
        localObject2 = (InteRemarkInfo)paramToServiceMsg.get(localObject2);
        localDiscussionMemberInfo.inteRemark = ((InteRemarkInfo)localObject2).StrValue;
        localDiscussionMemberInfo.inteRemarkSource = ((InteRemarkInfo)localObject2).Source;
        paramFromServiceMsg.a(localDiscussionMemberInfo);
      }
    }
    a(1010, true, Long.valueOf(l1));
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    f(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    g(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    h(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    i(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    j(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public Bitmap a(String paramString)
  {
    int i2 = 5;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    float f1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density;
    int i4 = (int)(117.0F * f1);
    paramString = paramString.split(";");
    int i1;
    if (paramString.length <= 1)
    {
      i1 = (int)(f1 * 117.0F);
      if (paramString.length <= 5) {
        break label147;
      }
    }
    Bitmap[] arrayOfBitmap;
    for (;;)
    {
      arrayOfBitmap = new Bitmap[i2];
      int i3 = 0;
      while (i3 < i2)
      {
        arrayOfBitmap[i3] = ((Bitmap)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString[i3], i1, i1).second);
        i3 += 1;
      }
      if (paramString.length <= 4)
      {
        i1 = (int)(f1 * 53.0F);
        break;
      }
      i1 = (int)(f1 * 34.0F);
      break;
      label147:
      i2 = paramString.length;
    }
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.a(i4, arrayOfBitmap);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    Bitmap localBitmap;
    if ((paramString != null) || (paramBoolean))
    {
      try
      {
        return ImageUtil.g();
      }
      catch (Throwable paramString)
      {
        if (!QLog.isColorLevel()) {
          break label107;
        }
        QLog.e("DiscussionHandler", 2, "getDiscussionFaceIcon error", paramString);
        return null;
        label102:
        localBitmap = null;
      }
      if (DiscussionIconHelper.a(paramString)) {}
      for (localBitmap = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1001, paramString, (byte)1, false, (byte)1, 0); localBitmap == null; localBitmap = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(101, paramString, (byte)1, false, (byte)1, 0))
      {
        a(paramString, true);
        if (!paramBoolean) {
          break label102;
        }
        return ImageUtil.g();
      }
      a(paramString, false);
    }
    else
    {
      label107:
      return null;
    }
    return localBitmap;
  }
  
  public Drawable a(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    Bitmap localBitmap = a(paramString, paramBoolean);
    paramString = (String)localObject;
    if (localBitmap != null) {
      paramString = new BitmapDrawable(localBitmap);
    }
    return paramString;
  }
  
  public DiscussionIconHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper;
  }
  
  public FriendListHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  }
  
  public Friends a(String paramString, long paramLong)
  {
    Friends localFriends = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(paramString);
    if (localFriends == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(paramString, 3000, paramLong);
    }
    return localFriends;
  }
  
  protected Class a()
  {
    return DiscussionObserver.class;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWork discussionUinListofGetinfo size=" + this.jdField_a_of_type_JavaUtilArrayList.size() + ";mGettingDiscussUins size=" + this.jdField_a_of_type_JavaUtilList.size());
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() >= 10) {
        return;
      }
    }
    long l1 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.remove(0)).longValue();
    this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l1));
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWork" + l1);
    }
    ??? = a("QQServiceDiscussSvc.ReqGetDiscussInfo");
    ((ToServiceMsg)???).extraData.putLong("discussUin", l1);
    DiscussionInfo localDiscussionInfo = ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(l1 + "");
    if (localDiscussionInfo != null)
    {
      ((ToServiceMsg)???).extraData.putLong("InteRemarkTimeStamp", localDiscussionInfo.timeSec);
      ((ToServiceMsg)???).extraData.putLong("infoSeq", localDiscussionInfo.infoSeq);
    }
    ((ToServiceMsg)???).addAttribute("inteRemarkUinMap", a(l1));
    a((ToServiceMsg)???);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo" + paramLong);
    }
    if (a(paramLong)) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) && (!this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramLong)))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
        }
        e();
        return;
      }
    }
    a(1001, false, new Object[] { String.valueOf(paramLong), Boolean.valueOf(false) });
  }
  
  public void a(long paramLong, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqSetDiscussFlag");
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    localToServiceMsg.extraData.putByte("flag", paramByte);
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>set discuss flag uin: " + paramLong + " req: " + localToServiceMsg);
    }
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt)
  {
    a(paramLong, new int[] { 0 }, new int[] { paramInt });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2149);
    localOIDBSSOPkg.uint32_service_type.set(3);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(Utils.a(paramLong1)).putShort((short)1).putInt(Utils.a(paramLong2));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x865_3");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong1);
    ((ToServiceMsg)localObject).extraData.putShort("wUinNum", (short)1);
    ((ToServiceMsg)localObject).extraData.putLong("dwDelMemberUin", paramLong2);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (paramString != null)
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqChangeDiscussName");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      localToServiceMsg.extraData.putString("newName", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>change discuss name uin: " + paramLong + " req: " + localToServiceMsg);
      }
      a(localToServiceMsg);
    }
  }
  
  public void a(long paramLong, String paramString, List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "notifyMemberChange disUin=" + paramLong + " cmdUin=" + paramString + " opType=" + paramInt + " uinsize=" + paramList.size());
    }
    MqqHandler localMqqHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(AVNotifyCenter.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(paramInt);
      localMessage.obj = new Object[] { Long.valueOf(paramLong), paramString, (String[])paramList.toArray(new String[paramList.size()]) };
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void a(long paramLong, ArrayList paramArrayList)
  {
    if (a(paramLong))
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqAddDiscussMember");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      int i2 = paramArrayList.size();
      long[] arrayOfLong1 = new long[i2];
      int[] arrayOfInt = new int[i2];
      long[] arrayOfLong2 = new long[i2];
      String[] arrayOfString = new String[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfLong1[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).Uin;
        arrayOfInt[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).Type;
        arrayOfLong2[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).RefUin;
        arrayOfString[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).RefStr;
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("uin", arrayOfLong1);
      localToServiceMsg.extraData.putIntArray("type", arrayOfInt);
      localToServiceMsg.extraData.putLongArray("refUin", arrayOfLong2);
      localToServiceMsg.extraData.putStringArray("refStr", arrayOfString);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>add discuss member uin: " + paramLong + " req: " + localToServiceMsg);
      }
      a(localToServiceMsg);
      return;
    }
    a(1003, false, new Object[] { String.valueOf(paramLong), Integer.valueOf(-1) });
  }
  
  public void a(long paramLong, List paramList)
  {
    if (a(paramLong))
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqGetDiscussInteRemark");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      localToServiceMsg.addAttribute("inteRemarkUinList", paramList);
      a(localToServiceMsg);
      return;
    }
    a(1010, false, Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = a("QRCodeSvc.discuss_geturl");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    FlyTicket.DiscussGetUrlRequest localDiscussGetUrlRequest = new FlyTicket.DiscussGetUrlRequest();
    localDiscussGetUrlRequest.conf_uin.set((int)paramLong);
    localDiscussGetUrlRequest.is_need_long_link.set(paramBoolean);
    localToServiceMsg.putWupBuffer(localDiscussGetUrlRequest.toByteArray());
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqSetDiscussAttr");
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    localToServiceMsg.extraData.putIntArray("infoType", paramArrayOfInt1);
    localToServiceMsg.extraData.putIntArray("attrType", paramArrayOfInt2);
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>set discuss attr uin: " + paramLong + " req: " + localToServiceMsg);
    }
    a(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (a(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      return;
      if (paramFromServiceMsg.getResultCode() == 1002)
      {
        k(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscuss".equalsIgnoreCase(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str))
      {
        if (paramToServiceMsg.extraData.getString("signature") != null)
        {
          g(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd()))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(str))
      {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equalsIgnoreCase(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equalsIgnoreCase(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x865_3".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x870_4".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x870_5".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x921_0".equalsIgnoreCase(str))
      {
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x58b_0".equalsIgnoreCase(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x751".equalsIgnoreCase(str));
    s(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.e(paramString);
    ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 3000);
    a(1004, true, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.c > 0L) && (System.currentTimeMillis() - this.c < 120000L)) {
      return;
    }
    this.c = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqJoinDiscuss");
    localToServiceMsg.extraData.putString("signature", paramString);
    localToServiceMsg.extraData.putInt(ScannerActivity.n, paramInt);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString1);
    if (localDiscussionInfo != null)
    {
      localDiscussionInfo.discussionName = paramString2;
      localDiscussionInfo.DiscussionFlag &= 0xFFFFFFFFFFFFFFBF;
      localDiscussionManager.a(localDiscussionInfo);
      a(1005, true, paramString1);
    }
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    a(paramString, paramArrayList, paramInt, 0L);
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt, long paramLong)
  {
    if ((paramString != null) && (paramArrayList != null))
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqCreateDiscuss");
      int i2 = paramArrayList.size();
      long[] arrayOfLong1 = new long[i2];
      int[] arrayOfInt = new int[i2];
      long[] arrayOfLong2 = new long[i2];
      String[] arrayOfString = new String[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfLong1[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).Uin;
        arrayOfInt[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).Type;
        arrayOfLong2[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).RefUin;
        arrayOfString[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).RefStr;
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("uin", arrayOfLong1);
      localToServiceMsg.extraData.putIntArray("type", arrayOfInt);
      localToServiceMsg.extraData.putLongArray("refUin", arrayOfLong2);
      localToServiceMsg.extraData.putStringArray("refStr", arrayOfString);
      localToServiceMsg.extraData.putString("name", paramString);
      localToServiceMsg.extraData.putInt("from", paramInt);
      localToServiceMsg.extraData.putLong("uiControlFlag", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>create discuss name: " + paramString + " req: " + localToServiceMsg);
      }
      a(localToServiceMsg);
    }
  }
  
  public void a(String paramString, HashSet paramHashSet)
  {
    if ((paramString == null) || (paramHashSet == null) || (paramHashSet.size() == 0)) {
      return;
    }
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString);
    if (localDiscussionInfo != null) {
      localDiscussionInfo.DiscussionFlag |= 0x20000000;
    }
    localDiscussionManager.a(paramString, paramHashSet);
    a(1001, true, new Object[] { paramString, Boolean.valueOf(true) });
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.c())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.b(paramString);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.c(paramString);
      return;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramString = new Pair(Boolean.valueOf(paramBoolean), paramString);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "GetCheckIsDiscussionMember discUins size:" + paramList.size());
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    Object localObject2;
    for (;;)
    {
      int i1;
      try
      {
        if (paramList.size() > 500)
        {
          i1 = paramList.size();
          ArrayList localArrayList = new ArrayList(paramList.subList(0, paramList.size() - 500));
          localObject2 = localArrayList.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label234;
          }
          a((String)((Iterator)localObject2).next());
          continue;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionHandler", 2, "GetCheckIsDiscussionMember handle discusses exception!", localException);
        }
        localObject1 = new oidb_0x751.ReqBody();
        ((oidb_0x751.ReqBody)localObject1).uint32_sub_cmd.set(1);
        try
        {
          localObject2 = new oidb_0x751.ReqCheckIsConfMember();
          Iterator localIterator = paramList.iterator();
          if (!localIterator.hasNext()) {
            break label316;
          }
          String str = (String)localIterator.next();
          ((oidb_0x751.ReqCheckIsConfMember)localObject2).rpt_uint64_conf_uin.add(Long.valueOf(Long.parseLong(str)));
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception paramList) {}
      }
      QLog.d("DiscussionHandler", 2, "GetCheckIsDiscussionMember handle reqbody exception!");
      return;
      label234:
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "deleteExceedDiscusses : " + localObject1);
      }
      paramList.removeAll((Collection)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("pm_totalDiscSize", String.valueOf(i1));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "checkIsDiscussionMemberExceeded", true, 0L, 0L, (HashMap)localObject1, null);
    }
    label316:
    ((oidb_0x751.ReqBody)localObject1).msg_req_check_is_conf_member.set((MessageMicro)localObject2);
    Object localObject1 = a("OidbSvc.0x751", 1873, 0, ((oidb_0x751.ReqBody)localObject1).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("checkDiscCount", paramList.size());
    b((ToServiceMsg)localObject1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(1007, paramBoolean1, Pair.create(Boolean.valueOf(paramBoolean2), paramString));
  }
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), DiscussionServlet.class);
    localNewIntent.putExtra("key_cmd", 0);
    localNewIntent.putExtra("field_id", paramArrayOfString1);
    localNewIntent.putExtra("uin_list", paramArrayOfString2);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong > 1000000L;
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqAddDiscussMember");
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqChangeDiscussName");
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqCreateDiscuss");
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqGetDiscuss");
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqGetDiscussInfo");
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqQuitDiscuss");
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqSetDiscussAttr");
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqSetDiscussFlag");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.GetSimpleInfo");
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqGetDiscussInteRemark");
      this.jdField_b_of_type_JavaUtilSet.add("QRCodeSvc.discuss_geturl");
      this.jdField_b_of_type_JavaUtilSet.add("QRCodeSvc.discuss_decode");
      this.jdField_b_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqJoinDiscuss");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x865_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x870_4");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x870_5");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x921_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x58b_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x751");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("addOrUpdateDiscussion ");
      if (paramArrayList == null) {
        break label57;
      }
    }
    long l1;
    label57:
    for (int i1 = paramArrayList.size();; i1 = -1)
    {
      QLog.d("Q.contacttab.dscs", 2, i1);
      l1 = System.currentTimeMillis();
      if (paramArrayList != null) {
        break;
      }
      return true;
    }
    Object localObject2;
    DiscussionManager localDiscussionManager;
    DiscussionInfo localDiscussionInfo;
    try
    {
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      localObject1 = "DiscusstionIconVersion" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      i1 = ((SharedPreferences)localObject2).getInt((String)localObject1, -1);
      DiscussInfo localDiscussInfo;
      if (i1 != 1)
      {
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1);
        ((SharedPreferences.Editor)localObject2).commit();
        if (i1 != -1) {
          try
          {
            localObject1 = new String[2];
            localObject1[0] = AppConstants.bG;
            localObject1[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
            int i3 = localObject1.length;
            i1 = 0;
            while (i1 < i3)
            {
              localObject2 = new File(localObject1[i1]);
              if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
              {
                localObject2 = ((File)localObject2).listFiles();
                int i4 = localObject2.length;
                int i2 = 0;
                while (i2 < i4)
                {
                  localDiscussInfo = localObject2[i2];
                  if (localDiscussInfo.getName().startsWith("discussion_"))
                  {
                    localDiscussInfo.delete();
                    if (QLog.isColorLevel()) {
                      QLog.d("DiscussionHandler", 2, "del discussion icon. name=" + localDiscussInfo.getName() + "," + localDiscussInfo.lastModified());
                    }
                  }
                  i2 += 1;
                }
              }
              i1 += 1;
            }
            localDiscussionManager = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      localObject2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label494;
        }
        localDiscussInfo = (DiscussInfo)paramArrayList.next();
        localDiscussionInfo = localDiscussionManager.a(String.valueOf(localDiscussInfo.DiscussUin));
        if (localDiscussionInfo != null) {
          break;
        }
        localDiscussionInfo = new DiscussionInfo();
        localDiscussionInfo.uin = String.valueOf(localDiscussInfo.DiscussUin);
        localDiscussionInfo.infoSeq = -1L;
        localDiscussionInfo.timeSec = l1;
        a(Long.parseLong(localDiscussionInfo.uin));
        ((ArrayList)localObject2).add(localDiscussionInfo);
      }
      if (localDiscussionInfo.infoSeq == localDiscussInfo.InfoSeq) {
        break label484;
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      return false;
    }
    a(Long.parseLong(localDiscussionInfo.uin));
    for (;;)
    {
      localDiscussionInfo.timeSec = l1;
      break;
      label484:
      ((ArrayList)localObject2).add(localDiscussionInfo);
    }
    label494:
    boolean bool = localDiscussionManager.a((ArrayList)localObject2, l1, true);
    return bool;
  }
  
  public boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("addOrUpdateDiscussionWithCollectData");
      if (paramArrayList1 == null) {
        break label80;
      }
      i1 = paramArrayList1.size();
      localObject1 = ((StringBuilder)localObject1).append(i1).append(", ");
      if (paramArrayList2 == null) {
        break label86;
      }
    }
    long l1;
    label80:
    label86:
    for (int i1 = paramArrayList2.size();; i1 = -1)
    {
      QLog.d("Q.contacttab.dscs", 2, i1);
      l1 = System.currentTimeMillis();
      if (paramArrayList1 != null) {
        break label92;
      }
      return true;
      i1 = -1;
      break;
    }
    label92:
    Object localObject2;
    DiscussInfo localDiscussInfo;
    DiscussionManager localDiscussionManager;
    DiscussionInfo localDiscussionInfo;
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        localObject1 = "DiscusstionIconVersion" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        i1 = ((SharedPreferences)localObject2).getInt((String)localObject1, -1);
        if (i1 != 1)
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1);
          ((SharedPreferences.Editor)localObject2).commit();
          if (i1 != -1) {
            try
            {
              localObject1 = new String[2];
              localObject1[0] = AppConstants.bG;
              localObject1[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
              int i3 = localObject1.length;
              i1 = 0;
              if (i1 < i3)
              {
                localObject2 = new File(localObject1[i1]);
                if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
                {
                  localObject2 = ((File)localObject2).listFiles();
                  int i4 = localObject2.length;
                  int i2 = 0;
                  if (i2 < i4)
                  {
                    localDiscussInfo = localObject2[i2];
                    if (localDiscussInfo.getName().startsWith("discussion_"))
                    {
                      localDiscussInfo.delete();
                      if (QLog.isColorLevel()) {
                        QLog.d("DiscussionHandler", 2, "del discussion icon. name=" + localDiscussInfo.getName() + "," + localDiscussInfo.lastModified());
                      }
                    }
                    i2 += 1;
                    continue;
                  }
                }
                i1 += 1;
                continue;
              }
              localDiscussionManager = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
        localObject2 = new ArrayList();
        paramArrayList1 = paramArrayList1.iterator();
        if (!paramArrayList1.hasNext()) {
          break label599;
        }
        localDiscussInfo = (DiscussInfo)paramArrayList1.next();
        localDiscussionInfo = localDiscussionManager.a(String.valueOf(localDiscussInfo.DiscussUin));
        if (localDiscussionInfo != null) {
          break;
        }
        localDiscussionInfo = new DiscussionInfo();
        localDiscussionInfo.uin = String.valueOf(localDiscussInfo.DiscussUin);
        localDiscussionInfo.infoSeq = -1L;
        localDiscussionInfo.timeSec = l1;
        if (paramArrayList2.contains(Long.valueOf(localDiscussInfo.DiscussUin)))
        {
          localDiscussionInfo.hasCollect = true;
          a(Long.parseLong(localDiscussionInfo.uin));
          ((ArrayList)localObject2).add(localDiscussionInfo);
        }
        else
        {
          localDiscussionInfo.hasCollect = false;
        }
      }
      catch (Exception paramArrayList1)
      {
        paramArrayList1.printStackTrace();
        return false;
      }
    }
    if (paramArrayList2.contains(Long.valueOf(localDiscussInfo.DiscussUin)))
    {
      localDiscussionInfo.hasCollect = true;
      label543:
      if (localDiscussionInfo.infoSeq == localDiscussInfo.InfoSeq) {
        break label588;
      }
      a(Long.parseLong(localDiscussionInfo.uin));
    }
    for (;;)
    {
      localDiscussionInfo.timeSec = l1;
      break;
      localDiscussionInfo.hasCollect = false;
      break label543;
      label588:
      ((ArrayList)localObject2).add(localDiscussionInfo);
    }
    label599:
    boolean bool = localDiscussionManager.a((ArrayList)localObject2, l1, false);
    return bool;
  }
  
  public void b()
  {
    a(1000, true, null);
  }
  
  public void b(long paramLong)
  {
    if (((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramLong + "") == null) {
      a(paramLong);
    }
  }
  
  /* Error */
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 28
    //   8: iconst_2
    //   9: ldc_w 1292
    //   12: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_2
    //   16: invokevirtual 653	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +403 -> 422
    //   22: aload_3
    //   23: ifnull +399 -> 422
    //   26: iconst_1
    //   27: istore 13
    //   29: aload_1
    //   30: getfield 126	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   33: ldc_w 570
    //   36: invokevirtual 140	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   39: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: astore_2
    //   43: aload_1
    //   44: getfield 126	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   47: ldc_w 572
    //   50: invokevirtual 140	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   53: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   56: astore_1
    //   57: iload 13
    //   59: istore 12
    //   61: iload 13
    //   63: ifeq +400 -> 463
    //   66: new 585	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   69: dup
    //   70: invokespecial 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   73: astore 4
    //   75: aload 4
    //   77: aload_3
    //   78: checkcast 588	[B
    //   81: checkcast 588	[B
    //   84: invokevirtual 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   87: pop
    //   88: aload 4
    //   90: getfield 595	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 523	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   96: istore 6
    //   98: iload 6
    //   100: ifne +328 -> 428
    //   103: iconst_1
    //   104: istore 12
    //   106: aload_1
    //   107: invokevirtual 575	java/lang/Long:longValue	()J
    //   110: lstore 8
    //   112: aload_2
    //   113: invokevirtual 575	java/lang/Long:longValue	()J
    //   116: lstore 10
    //   118: aload_0
    //   119: getfield 191	com/tencent/mobileqq/app/DiscussionHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: aload_1
    //   123: invokestatic 164	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   126: aload_2
    //   127: invokestatic 164	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   130: invokestatic 1297	com/tencent/mobileqq/utils/ContactUtils:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: new 287	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 1299
    //   144: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_0
    //   148: getfield 191	com/tencent/mobileqq/app/DiscussionHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   151: invokevirtual 674	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   154: ldc_w 1300
    //   157: iconst_1
    //   158: anewarray 159	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_3
    //   164: aastore
    //   165: invokevirtual 1303	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   168: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore_3
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 191	com/tencent/mobileqq/app/DiscussionHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: invokevirtual 113	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   183: invokestatic 1120	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   186: aload_1
    //   187: invokevirtual 575	java/lang/Long:longValue	()J
    //   190: aload_1
    //   191: invokevirtual 575	java/lang/Long:longValue	()J
    //   194: aload_3
    //   195: invokespecial 1305	com/tencent/mobileqq/app/DiscussionHandler:a	(JJJLjava/lang/String;)V
    //   198: aload_0
    //   199: getfield 191	com/tencent/mobileqq/app/DiscussionHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   202: bipush 52
    //   204: invokevirtual 195	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   207: checkcast 197	com/tencent/mobileqq/app/DiscussionManager
    //   210: aload_1
    //   211: invokestatic 164	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   214: invokevirtual 775	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   217: astore_3
    //   218: aload_3
    //   219: ifnull +276 -> 495
    //   222: aload_3
    //   223: getfield 1308	com/tencent/mobileqq/data/DiscussionInfo:faceUinSet	Ljava/lang/String;
    //   226: astore 4
    //   228: aload 4
    //   230: ifnull +265 -> 495
    //   233: aload 4
    //   235: invokevirtual 1311	java/lang/String:trim	()Ljava/lang/String;
    //   238: ldc_w 772
    //   241: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifne +251 -> 495
    //   247: aload 4
    //   249: ldc_w 695
    //   252: invokevirtual 699	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   255: astore 4
    //   257: aload 4
    //   259: ifnull +236 -> 495
    //   262: aload 4
    //   264: arraylength
    //   265: istore 7
    //   267: iconst_0
    //   268: istore 6
    //   270: iload 6
    //   272: iload 7
    //   274: if_icmpge +221 -> 495
    //   277: aload 4
    //   279: iload 6
    //   281: aaload
    //   282: aload_2
    //   283: invokestatic 164	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   289: ifeq +197 -> 486
    //   292: iconst_1
    //   293: istore 6
    //   295: aload_1
    //   296: invokestatic 164	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   299: astore 4
    //   301: new 1063	java/util/HashSet
    //   304: dup
    //   305: invokespecial 1198	java/util/HashSet:<init>	()V
    //   308: astore 5
    //   310: aload 5
    //   312: new 287	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   319: aload_2
    //   320: invokevirtual 817	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   323: ldc_w 772
    //   326: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokevirtual 1312	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   335: pop
    //   336: aload_0
    //   337: aload 4
    //   339: aload 5
    //   341: invokevirtual 1314	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   344: new 89	java/util/ArrayList
    //   347: dup
    //   348: invokespecial 92	java/util/ArrayList:<init>	()V
    //   351: astore 4
    //   353: aload 4
    //   355: aload_2
    //   356: invokestatic 164	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   359: invokeinterface 451 2 0
    //   364: pop
    //   365: aload_0
    //   366: aload_1
    //   367: invokevirtual 575	java/lang/Long:longValue	()J
    //   370: aload_0
    //   371: getfield 191	com/tencent/mobileqq/app/DiscussionHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   374: invokevirtual 113	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   377: aload 4
    //   379: iconst_2
    //   380: invokevirtual 1316	com/tencent/mobileqq/app/DiscussionHandler:a	(JLjava/lang/String;Ljava/util/List;I)V
    //   383: iload 6
    //   385: ifeq +14 -> 399
    //   388: aload_0
    //   389: getfield 118	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper	Lcom/tencent/mobileqq/app/DiscussionIconHelper;
    //   392: aload_3
    //   393: getfield 1270	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   396: invokevirtual 1318	com/tencent/mobileqq/app/DiscussionIconHelper:d	(Ljava/lang/String;)V
    //   399: aload_0
    //   400: sipush 1015
    //   403: iload 12
    //   405: iconst_2
    //   406: newarray <illegal type>
    //   408: dup
    //   409: iconst_0
    //   410: lload 8
    //   412: lastore
    //   413: dup
    //   414: iconst_1
    //   415: lload 10
    //   417: lastore
    //   418: invokevirtual 172	com/tencent/mobileqq/app/DiscussionHandler:a	(IZLjava/lang/Object;)V
    //   421: return
    //   422: iconst_0
    //   423: istore 13
    //   425: goto -396 -> 29
    //   428: iconst_0
    //   429: istore 12
    //   431: goto -325 -> 106
    //   434: astore_3
    //   435: iconst_0
    //   436: istore 13
    //   438: iload 13
    //   440: istore 12
    //   442: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +18 -> 463
    //   448: ldc_w 1320
    //   451: iconst_2
    //   452: aload_3
    //   453: invokevirtual 1323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   456: invokestatic 650	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: iload 13
    //   461: istore 12
    //   463: goto -357 -> 106
    //   466: astore_3
    //   467: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   470: ifeq -272 -> 198
    //   473: ldc 28
    //   475: iconst_2
    //   476: ldc_w 1325
    //   479: aload_3
    //   480: invokestatic 1104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   483: goto -285 -> 198
    //   486: iload 6
    //   488: iconst_1
    //   489: iadd
    //   490: istore 6
    //   492: goto -222 -> 270
    //   495: iconst_0
    //   496: istore 6
    //   498: goto -203 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	DiscussionHandler
    //   0	501	1	paramToServiceMsg	ToServiceMsg
    //   0	501	2	paramFromServiceMsg	FromServiceMsg
    //   0	501	3	paramObject	Object
    //   73	305	4	localObject	Object
    //   308	32	5	localHashSet	HashSet
    //   96	401	6	i1	int
    //   265	10	7	i2	int
    //   110	301	8	l1	long
    //   116	300	10	l2	long
    //   59	403	12	bool1	boolean
    //   27	433	13	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   66	98	434	java/lang/Exception
    //   175	198	466	java/lang/NumberFormatException
  }
  
  public void b(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("QRCodeSvc.discuss_decode");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putString("signature", paramString);
    FlyTicket.DiscussSigDecodeRequest localDiscussSigDecodeRequest = new FlyTicket.DiscussSigDecodeRequest();
    localDiscussSigDecodeRequest.sig.set(paramString);
    localToServiceMsg.putWupBuffer(localDiscussSigDecodeRequest.toByteArray());
    a(localToServiceMsg);
  }
  
  public void b(String paramString1, String paramString2)
  {
    cmd0x921.ReqBody localReqBody = new cmd0x921.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    try
    {
      cmd0x921.GetAtAllRemain localGetAtAllRemain = new cmd0x921.GetAtAllRemain();
      localGetAtAllRemain.uint64_uin.set(Long.parseLong(paramString1));
      localGetAtAllRemain.uint64_discuss_uin.set(Long.parseLong(paramString2));
      localReqBody.msg_get_at_all_remain.set(localGetAtAllRemain);
      paramString1 = a("OidbSvc.0x921_0", 2337, 0, localReqBody.toByteArray());
      paramString1.extraData.putString("discUid", paramString2);
      b(paramString1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DiscussionHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", discUin : " + paramString2);
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      long l1 = Long.parseLong(paramString);
      boolean bool = this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(l1));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void c()
  {
    a(1008, true, null);
  }
  
  public void c(long paramLong)
  {
    if (a(paramLong)) {
      a(paramLong, a(paramLong));
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleCollectDisucssionResp");
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
      if (!bool1) {
        break label193;
      }
    }
    label193:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool3;
        if (bool1)
        {
          paramFromServiceMsg = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          paramObject = paramFromServiceMsg.a(String.valueOf(paramToServiceMsg));
          if (paramObject != null)
          {
            long l1 = System.currentTimeMillis();
            ((DiscussionInfo)paramObject).hasCollect = true;
            ((DiscussionInfo)paramObject).timeSec = l1;
            paramFromServiceMsg.a((Entity)paramObject);
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("handleCollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      a(1016, bool1, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public void c(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqGetDiscussInfo");
    localToServiceMsg.extraData.putString("signature", paramString);
    a(localToServiceMsg);
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.c()) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i1 = 0;
      if (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        Pair localPair = (Pair)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
        if ((localPair.first == null) || (localPair.second == null)) {}
        for (;;)
        {
          i1 += 1;
          break;
          if (((Boolean)localPair.first).booleanValue()) {
            a((String)localPair.second, false);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.c((String)localPair.second);
          }
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void d(long paramLong)
  {
    if (a(paramLong))
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqQuitDiscuss");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>quit discuss uin: " + paramLong);
      }
      a(localToServiceMsg);
      return;
    }
    a(1004, false, String.valueOf(paramLong));
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleUncollectDisucssionResp");
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
      if (!bool1) {
        break label193;
      }
    }
    label193:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool3;
        if (bool1)
        {
          paramFromServiceMsg = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          paramObject = paramFromServiceMsg.a(String.valueOf(paramToServiceMsg));
          if (paramObject != null)
          {
            long l1 = System.currentTimeMillis();
            ((DiscussionInfo)paramObject).hasCollect = false;
            ((DiscussionInfo)paramObject).timeSec = l1;
            paramFromServiceMsg.a((Entity)paramObject);
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("handleUncollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      a(1017, bool1, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWorkV2 discussionUinListofGetinfo size=" + this.jdField_a_of_type_JavaUtilArrayList.size() + ";mGettingDiscussUins size=" + this.jdField_a_of_type_JavaUtilList.size());
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() >= 10) {
        return;
      }
    }
    l1 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.remove(0)).longValue();
    this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l1));
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWorkV2 disUin:" + l1);
    }
    ??? = new cmd0x58b.ReqBody();
    ((cmd0x58b.ReqBody)???).uint32_subcmd.set(1);
    for (;;)
    {
      try
      {
        localGetConfInfoReq = new cmd0x58b.GetConfInfoReq();
        localGetConfInfoReq.uint64_conf_uin.set(l1);
        localObject3 = ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(l1 + "");
        if (localObject3 == null) {
          continue;
        }
        localGetConfInfoReq.uint32_interemark_timestamp.set((int)((DiscussionInfo)localObject3).timeSec);
        localConfBaseInfo = new cmd0x58b.ConfBaseInfo();
        localConfBaseInfo.bytes_conf_name.set(ByteStringMicro.copyFromUtf8(""));
        localConfBaseInfo.uint32_create_time.set(0);
        localConfBaseInfo.uint64_owner_uin.set(0L);
        if (localObject3 == null) {
          continue;
        }
        localConfBaseInfo.uint32_info_seq.set((int)((DiscussionInfo)localObject3).infoSeq);
      }
      catch (Exception localException)
      {
        cmd0x58b.GetConfInfoReq localGetConfInfoReq;
        Object localObject3;
        cmd0x58b.ConfBaseInfo localConfBaseInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("DiscussionHandler", 2, "startGetDiscussionInfoWorkV2 disUin:" + l1 + " error:" + localException.toString());
        continue;
        localConfBaseInfo.uint32_info_seq.set(0);
        continue;
      }
      localConfBaseInfo.uint32_last_info_time.set(0);
      localConfBaseInfo.uint32_msg_seq.set(0);
      localConfBaseInfo.uint32_last_msg_time.set(0);
      localConfBaseInfo.uint32_member_num.set(0);
      localConfBaseInfo.uint32_flag.set(0);
      localConfBaseInfo.uint64_inherit_owner_uin.set(0L);
      localConfBaseInfo.uint64_group_code.set(0L);
      localConfBaseInfo.uint64_group_uin.set(0L);
      localGetConfInfoReq.msg_conf_base_info.set(localConfBaseInfo);
      localObject3 = new cmd0x58b.ConfMemberInfo();
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_join_time.set(0);
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_flag.set(0);
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_read_msg_seq.set(0);
      ((cmd0x58b.ConfMemberInfo)localObject3).bytes_member_interemark.set(ByteStringMicro.copyFromUtf8(""));
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_interemark_source.set(0);
      localGetConfInfoReq.msg_conf_mem_info.set((MessageMicro)localObject3);
      ((cmd0x58b.ReqBody)???).msg_get_conf_info.set(localGetConfInfoReq);
      ??? = a("OidbSvc.0x58b_0", 1419, 0, ((cmd0x58b.ReqBody)???).toByteArray());
      ((ToServiceMsg)???).extraData.putLong("discussUin", l1);
      b((ToServiceMsg)???);
      return;
      localGetConfInfoReq.uint32_interemark_timestamp.set(0);
    }
  }
  
  public void e(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2160);
    localOIDBSSOPkg.uint32_service_type.set(4);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(Utils.a(paramLong)).putInt(0).putShort((short)4).putInt(Utils.a(paramLong));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x870_4");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  protected void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleGetFlyTicket");
    }
    this.jdField_b_of_type_Long = 0L;
    paramObject = new FlyTicket.DiscussGetUrlResponse();
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (FlyTicket.DiscussGetUrlResponse)((FlyTicket.DiscussGetUrlResponse)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.ret_info.get() != null))
        {
          l1 = ((FlyTicket.RetInfo)paramFromServiceMsg.ret_info.get()).ret_code.get();
          long l2 = paramToServiceMsg.extraData.getLong("discussUin");
          if (l1 == 0L)
          {
            bool = true;
            a(1011, bool, new Object[] { String.valueOf(l1), paramFromServiceMsg, Long.valueOf(l2) });
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        continue;
        boolean bool = false;
        continue;
        l1 = -1L;
        continue;
      }
      long l1 = -1L;
      paramFromServiceMsg = (FromServiceMsg)paramObject;
    }
  }
  
  public void f(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2160);
    localOIDBSSOPkg.uint32_service_type.set(5);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(Utils.a(paramLong)).putInt(0).putShort((short)4).putInt(Utils.a(paramLong));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x870_5");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  protected void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = null;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleDecodeFlyTicket");
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramObject = new FlyTicket.DiscussSigDecodeResponse();
      try
      {
        paramFromServiceMsg = (FlyTicket.DiscussSigDecodeResponse)((FlyTicket.DiscussSigDecodeResponse)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          continue;
          boolean bool1 = false;
        }
      }
      bool1 = bool2;
      if (paramToServiceMsg != null)
      {
        bool1 = bool2;
        if (paramToServiceMsg.ret_info.get() != null)
        {
          if (((FlyTicket.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get() != 0) {
            break label116;
          }
          bool1 = true;
        }
      }
      a(1012, bool1, paramToServiceMsg);
      return;
    }
    label116:
    a(1012, false, null);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.d();
    }
    super.g();
  }
  
  public void g(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscuss" + paramLong);
    }
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqGetDiscuss");
    localToServiceMsg.extraData.putLong("uin", paramLong);
    localToServiceMsg.setEnableFastResend(true);
    a(localToServiceMsg);
  }
  
  protected void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = -1L;
    DiscussRespHeader localDiscussRespHeader = null;
    paramToServiceMsg = localDiscussRespHeader;
    long l1 = l2;
    if (paramFromServiceMsg != null)
    {
      paramToServiceMsg = localDiscussRespHeader;
      l1 = l2;
      if (paramFromServiceMsg.isSuccess())
      {
        paramToServiceMsg = localDiscussRespHeader;
        l1 = l2;
        if (paramObject != null)
        {
          paramToServiceMsg = (DiscussionReceiver.RespPackage)paramObject;
          localDiscussRespHeader = (DiscussRespHeader)paramToServiceMsg.jdField_a_of_type_JavaLangObject;
          paramObject = (RespGetDiscussInfo)paramToServiceMsg.b;
          paramToServiceMsg = (ToServiceMsg)paramObject;
          l1 = l2;
          if (localDiscussRespHeader != null)
          {
            l1 = localDiscussRespHeader.Result;
            paramToServiceMsg = (ToServiceMsg)paramObject;
          }
        }
      }
    }
    paramObject = new Object[2];
    paramObject[0] = String.valueOf(l1);
    paramObject[1] = paramToServiceMsg;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l1 == 0L))
    {
      a(1013, true, paramObject);
      return;
    }
    a(1013, false, paramObject);
  }
  
  protected void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = -1L;
    this.c = 0L;
    long l1;
    long l3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (DiscussionReceiver.RespPackage)paramObject;
      paramToServiceMsg = (DiscussRespHeader)((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_JavaLangObject;
      paramObject = (RespJoinDiscuss)((DiscussionReceiver.RespPackage)paramObject).b;
      if (paramToServiceMsg != null)
      {
        l1 = paramToServiceMsg.Result;
        if (paramObject != null)
        {
          l3 = ((RespJoinDiscuss)paramObject).DiscussUin;
          l2 = l1;
          l1 = l3;
        }
      }
    }
    for (;;)
    {
      paramToServiceMsg = new Long[2];
      paramToServiceMsg[0] = Long.valueOf(l2);
      paramToServiceMsg[1] = Long.valueOf(l1);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l2 == 0L) && (l1 > 0L))
      {
        a(1014, true, paramToServiceMsg);
        return;
      }
      a(1014, false, paramToServiceMsg);
      return;
      l3 = -1L;
      l2 = l1;
      l1 = l3;
      continue;
      l1 = -1L;
      break;
      l1 = -1L;
    }
  }
  
  protected void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleSetSimpleInfo");
    }
    String str = paramToServiceMsg.extraData.getString("discussionUin");
    if ((paramToServiceMsg.extraData.getInt("type") != 3000) || (str == null)) {
      return;
    }
    paramToServiceMsg = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramObject = (ArrayList)paramObject;
      paramFromServiceMsg = new ArrayList(((ArrayList)paramObject).size());
      paramObject = ((ArrayList)paramObject).iterator();
      while (((Iterator)paramObject).hasNext())
      {
        ProfSmpInfoRes localProfSmpInfoRes = (ProfSmpInfoRes)((Iterator)paramObject).next();
        if (localProfSmpInfoRes != null)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = paramToServiceMsg.a(str, String.valueOf(localProfSmpInfoRes.dwUin));
          if (localDiscussionMemberInfo != null)
          {
            localDiscussionMemberInfo.memberName = localProfSmpInfoRes.strNick;
            paramFromServiceMsg.add(localDiscussionMemberInfo);
          }
        }
      }
      paramToServiceMsg.b(paramFromServiceMsg);
      a(1006, true, str);
      return;
    }
    a(1006, false, str);
  }
  
  protected void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handle set discuss flag req: " + paramToServiceMsg + " ~~resp: " + paramFromServiceMsg + " ~~ data: " + paramObject);
    }
  }
  
  protected void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handle set discuss attr req: " + paramToServiceMsg + " ~~resp: " + paramFromServiceMsg + " ~~ data: " + paramObject);
    }
  }
  
  protected void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleQuitDiscussResp");
    }
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    Object localObject = (RespQuitDiscuss)((DiscussionReceiver.RespPackage)paramObject).b;
    localObject = (DiscussRespHeader)((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_JavaLangObject;
    String str1 = String.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    int i1 = ((DiscussRespHeader)localObject).Result;
    String str2 = ((DiscussRespHeader)localObject).ResultDesc;
    if (((DiscussRespHeader)localObject).Result != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("DiscussionHandler", 2, "header failed! failed code: " + ((DiscussRespHeader)localObject).Result);
      }
      a(2000, true, new Object[] { str1, Integer.valueOf(i1), str2 });
      a(1004, false, str1);
      return;
    }
    if ((!paramFromServiceMsg.isSuccess()) || (!((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_Boolean))
    {
      a(1004, false, str1);
      return;
    }
    a(str1);
    paramFromServiceMsg = new ArrayList();
    paramFromServiceMsg.add(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a(paramToServiceMsg.extraData.getLong("discussUin"), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFromServiceMsg, 10009);
  }
  
  protected void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoResp " + paramFromServiceMsg.isSuccess());
    }
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    String str1 = String.valueOf(paramToServiceMsg);
    this.jdField_a_of_type_JavaUtilList.remove(paramToServiceMsg);
    RespGetDiscussInfo localRespGetDiscussInfo;
    Object[] arrayOfObject;
    long l1;
    label525:
    HashMap localHashMap;
    try
    {
      paramToServiceMsg = (DiscussionReceiver.RespPackage)paramObject;
      localRespGetDiscussInfo = (RespGetDiscussInfo)paramToServiceMsg.b;
      paramObject = (DiscussRespHeader)paramToServiceMsg.jdField_a_of_type_JavaLangObject;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = str1;
      if ((((DiscussRespHeader)paramObject).Result != 0) || (!paramFromServiceMsg.isSuccess()) || (!paramToServiceMsg.jdField_a_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.w("DiscussionHandler", 2, "get discussin info failed,Header code:" + ((DiscussRespHeader)paramObject).Result);
        }
        arrayOfObject[1] = Boolean.valueOf(false);
        a(1001, false, arrayOfObject);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        Map localMap;
        Iterator localIterator;
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp excep", paramToServiceMsg);
        }
        return;
        if (paramFromServiceMsg.infoSeq == localRespGetDiscussInfo.InfoSeq)
        {
          paramToServiceMsg = localDiscussionManager.a(str1);
          arrayOfObject[1] = Boolean.valueOf(a(str1, localRespGetDiscussInfo.Members, paramToServiceMsg));
          a(1001, true, arrayOfObject);
          if ((localRespGetDiscussInfo.DiscussFlag & 0x40) == 0L)
          {
            if (paramFromServiceMsg.discussionName.equals(localRespGetDiscussInfo.Name)) {
              break label1487;
            }
            paramFromServiceMsg.DiscussionFlag = (localRespGetDiscussInfo.DiscussFlag | 0x20000000);
            paramFromServiceMsg.discussionName = localRespGetDiscussInfo.Name;
            if (!QLog.isColorLevel()) {
              break label1481;
            }
            QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " name need server name| local name=" + Utils.a(paramFromServiceMsg.discussionName));
          }
          for (i1 = 1;; i1 = 1)
          {
            if (i1 != 0) {
              localDiscussionManager.a(paramFromServiceMsg);
            }
            return;
            if (QLog.isColorLevel()) {
              QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " old flag=" + paramFromServiceMsg.DiscussionFlag);
            }
            paramFromServiceMsg.DiscussionFlag = localRespGetDiscussInfo.DiscussFlag;
            paramFromServiceMsg.DiscussionFlag |= 0x20000000;
            ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str1, paramFromServiceMsg, paramToServiceMsg, false);
          }
        }
        if ((paramFromServiceMsg.discussionName != null) && (!paramFromServiceMsg.discussionName.equals(localRespGetDiscussInfo.Name))) {}
        paramFromServiceMsg.createTime = localRespGetDiscussInfo.CreateTime;
        paramFromServiceMsg.ownerUin = String.valueOf(localRespGetDiscussInfo.OwnerUin);
        paramFromServiceMsg.timeSec = localRespGetDiscussInfo.InteRemarkTimeStamp;
        paramFromServiceMsg.groupUin = localRespGetDiscussInfo.GroupUin;
        paramFromServiceMsg.groupCode = localRespGetDiscussInfo.GroupCode;
        if ((localRespGetDiscussInfo.DiscussFlag & 0x40) != 0L) {
          break;
        }
        paramFromServiceMsg.discussionName = localRespGetDiscussInfo.Name;
        paramFromServiceMsg.DiscussionFlag = (localRespGetDiscussInfo.DiscussFlag | 0x20000000);
      }
    }
    finally
    {
      if (!a()) {
        break label1240;
      }
      a();
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    paramFromServiceMsg = localDiscussionManager.a(str1);
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " owner=" + localRespGetDiscussInfo.OwnerUin + " flag=" + localRespGetDiscussInfo.DiscussFlag + " gcode=" + localRespGetDiscussInfo.GroupCode + " guin=" + localRespGetDiscussInfo.GroupUin + " createTime=" + localRespGetDiscussInfo.CreateTime + " disName=" + Utils.a(localRespGetDiscussInfo.Name) + " infoseq=" + localRespGetDiscussInfo.InfoSeq + " timesec=" + localRespGetDiscussInfo.InteRemarkTimeStamp);
    }
    StringBuffer localStringBuffer;
    if (paramFromServiceMsg == null)
    {
      paramToServiceMsg = new DiscussionInfo();
      paramToServiceMsg.uin = str1;
      paramToServiceMsg.createTime = localRespGetDiscussInfo.CreateTime;
      paramToServiceMsg.discussionName = localRespGetDiscussInfo.Name;
      paramToServiceMsg.ownerUin = String.valueOf(localRespGetDiscussInfo.OwnerUin);
      paramToServiceMsg.timeSec = localRespGetDiscussInfo.InteRemarkTimeStamp;
      paramToServiceMsg.groupCode = localRespGetDiscussInfo.GroupCode;
      paramToServiceMsg.groupUin = localRespGetDiscussInfo.GroupUin;
      l1 = paramToServiceMsg.DiscussionFlag;
      paramToServiceMsg.DiscussionFlag = localRespGetDiscussInfo.DiscussFlag;
      paramToServiceMsg.DiscussionFlag = (l1 & 0x20000000 | paramToServiceMsg.DiscussionFlag);
      paramFromServiceMsg = paramToServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " no found disInfo new flag=" + paramToServiceMsg.DiscussionFlag);
        paramFromServiceMsg = paramToServiceMsg;
      }
      paramToServiceMsg = localRespGetDiscussInfo.Members;
      localHashMap = new HashMap();
      l1 = System.currentTimeMillis();
      localMap = localDiscussionManager.a(str1);
      localStringBuffer = new StringBuffer();
      localIterator = paramToServiceMsg.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1406;
        }
        DiscussMemberInfo localDiscussMemberInfo = (DiscussMemberInfo)localIterator.next();
        String str2 = String.valueOf(localDiscussMemberInfo.Uin);
        if (QLog.isColorLevel())
        {
          localStringBuffer.append("memberUin=");
          localStringBuffer.append(str2.toString());
          localStringBuffer.append("flag=");
          localStringBuffer.append(localDiscussMemberInfo.Flag);
          localStringBuffer.append("inteRemark=");
          localStringBuffer.append(Utils.a(localDiscussMemberInfo.StInteRemark.StrValue));
          localStringBuffer.append("Source=");
          localStringBuffer.append(localDiscussMemberInfo.StInteRemark.Source);
          localStringBuffer.append("\r\n");
        }
        paramToServiceMsg = null;
        if (localMap != null) {
          paramToServiceMsg = (DiscussionMemberInfo)localMap.get(str2);
        }
        paramObject = paramToServiceMsg;
        if (paramToServiceMsg == null)
        {
          paramObject = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)paramObject).discussionUin = str1;
          ((DiscussionMemberInfo)paramObject).memberUin = str2;
        }
        ((DiscussionMemberInfo)paramObject).flag = localDiscussMemberInfo.Flag;
        ((DiscussionMemberInfo)paramObject).dataTime = l1;
        if ((localDiscussMemberInfo.StInteRemark == null) || (TextUtils.isEmpty(localDiscussMemberInfo.StInteRemark.StrValue))) {
          break;
        }
        ((DiscussionMemberInfo)paramObject).inteRemark = localDiscussMemberInfo.StInteRemark.StrValue;
        ((DiscussionMemberInfo)paramObject).inteRemarkSource = localDiscussMemberInfo.StInteRemark.Source;
        label812:
        localHashMap.put(((DiscussionMemberInfo)paramObject).memberUin, paramObject);
      }
    }
    for (;;)
    {
      label1240:
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " old flag=" + paramFromServiceMsg.DiscussionFlag);
      }
      paramFromServiceMsg.DiscussionFlag = localRespGetDiscussInfo.DiscussFlag;
      paramFromServiceMsg.DiscussionFlag |= 0x20000000;
      paramFromServiceMsg.discussionName = localRespGetDiscussInfo.Name;
      break label525;
      if (!TextUtils.isEmpty(((DiscussionMemberInfo)paramObject).inteRemark)) {
        break label812;
      }
      paramToServiceMsg = localFriendsManager.a(((DiscussionMemberInfo)paramObject).memberUin);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.isFriend()))
      {
        ((DiscussionMemberInfo)paramObject).memberName = paramToServiceMsg.name;
        if (TextUtils.isEmpty(paramToServiceMsg.remark)) {}
        for (paramToServiceMsg = paramToServiceMsg.name;; paramToServiceMsg = paramToServiceMsg.remark)
        {
          ((DiscussionMemberInfo)paramObject).inteRemark = paramToServiceMsg;
          ((DiscussionMemberInfo)paramObject).inteRemarkSource = 129L;
          break;
        }
      }
      ((DiscussionMemberInfo)paramObject).inteRemarkSource = 0L;
      break label812;
      label1406:
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, localStringBuffer.toString());
      }
      localDiscussionManager.a(str1, paramFromServiceMsg, localRespGetDiscussInfo.InfoSeq, localHashMap, l1);
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.d(paramFromServiceMsg.uin);
      arrayOfObject[1] = Boolean.valueOf(true);
      a(1001, true, arrayOfObject);
      if (!a()) {
        break;
      }
      a();
      return;
      label1481:
      int i1 = 1;
      continue;
      label1487:
      i1 = 0;
    }
  }
  
  protected void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleGetDiscussResp").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramObject == null) {
        break label152;
      }
    }
    label152:
    for (boolean bool = ((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_Boolean;; bool = false)
    {
      QLog.d("Q.contacttab.dscs", 2, bool);
      if ((paramFromServiceMsg.getResultCode() != 2901) || (paramToServiceMsg == null)) {
        break;
      }
      int i1 = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleGetDiscussRespk_resend_cnt" + i1);
      }
      if (i1 >= 2) {
        break;
      }
      paramToServiceMsg.extraData.putInt("k_resend_cnt", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null) || (!((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_Boolean))
    {
      a(1000, false, null);
      return;
    }
    paramFromServiceMsg = (RespGetDiscuss)((DiscussionReceiver.RespPackage)paramObject).b;
    paramToServiceMsg = paramFromServiceMsg.DiscussList;
    paramObject = paramFromServiceMsg.FavoriteDiscussList;
    paramFromServiceMsg = new ArrayList();
    if (paramObject != null)
    {
      paramObject = ((ArrayList)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        paramFromServiceMsg.add(Long.valueOf(((DiscussInfo)((Iterator)paramObject).next()).DiscussUin));
      }
    }
    a(1000, a(paramToServiceMsg, paramFromServiceMsg), null);
  }
  
  protected void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleChangeDiscussNameResp");
    }
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    paramFromServiceMsg = (RespChangeDiscussName)((DiscussionReceiver.RespPackage)paramObject).b;
    Object localObject = (DiscussRespHeader)((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_JavaLangObject;
    paramFromServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    int i1 = ((DiscussRespHeader)localObject).Result;
    String str = ((DiscussRespHeader)localObject).ResultDesc;
    if (((DiscussRespHeader)localObject).Result != 0)
    {
      a(2000, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i1), str });
      a(1005, false, paramFromServiceMsg);
      return;
    }
    if (((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_Boolean)
    {
      paramObject = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject = ((DiscussionManager)paramObject).a(paramFromServiceMsg);
      if (localObject != null)
      {
        ((DiscussionInfo)localObject).discussionName = paramToServiceMsg.extraData.getString("newName");
        ((DiscussionInfo)localObject).DiscussionFlag &= 0xFFFFFFFFFFFFFFBF;
        ((DiscussionManager)paramObject).a((DiscussionInfo)localObject);
      }
      a(1005, true, paramFromServiceMsg);
      return;
    }
    a(1005, false, paramFromServiceMsg);
  }
  
  protected void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleCreateDiscussResp ");
    }
    Object[] arrayOfObject = new Object[3];
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    arrayOfObject[2] = Integer.valueOf(((DiscussRespHeader)((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_JavaLangObject).Result);
    if ((!paramFromServiceMsg.isSuccess()) || (!((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "create discussion fail, result code: " + paramFromServiceMsg.getResultCode() + " errMsg: " + paramFromServiceMsg.getBusinessFailMsg() + " respPackage.bSuccess: " + ((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_Boolean);
      }
      a(1002, false, arrayOfObject);
      return;
    }
    paramFromServiceMsg = (RespCreateDiscuss)((DiscussionReceiver.RespPackage)paramObject).b;
    if (!a(paramFromServiceMsg.DiscussUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "create discussion fail: invalid discussion uin");
      }
      a(1002, false, arrayOfObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "create discussion succeeded " + paramFromServiceMsg.DiscussUin);
    }
    paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject1 = new DiscussionInfo();
    ((DiscussionInfo)localObject1).uin = String.valueOf(paramFromServiceMsg.DiscussUin);
    ((DiscussionInfo)localObject1).discussionName = paramToServiceMsg.extraData.getString("name");
    ((DiscussionInfo)localObject1).infoSeq = -1L;
    ((DiscussionInfo)localObject1).createFrom = paramToServiceMsg.extraData.getInt("from", 0);
    ((DiscussionInfo)localObject1).uiControlFlag = paramToServiceMsg.extraData.getLong("uiControlFlag", 0L);
    ArrayList localArrayList;
    int i1;
    Object localObject2;
    if (((DiscussionInfo)localObject1).isUIControlFlag_Hidden_RecentUser())
    {
      localArrayList = localDiscussionManager.a(((DiscussionInfo)localObject1).uin);
      if (localArrayList != null)
      {
        int i2 = localArrayList.size();
        i1 = 0;
        if (i1 < i2)
        {
          localObject2 = (DiscussionMemberInfo)localArrayList.get(i1);
          if (localObject2 == null) {
            break label607;
          }
          localObject2 = ((DiscussionMemberInfo)localObject2).memberUin;
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
            break label607;
          }
          ((DiscussionInfo)localObject1).removeUIControlFlag_Hidden_RecentUser();
          if (QLog.isDevelopLevel()) {
            QLog.d("DiscussionHandler", 4, "不是单人多人聊天");
          }
        }
      }
    }
    localDiscussionManager.a((DiscussionInfo)localObject1);
    a(paramFromServiceMsg.DiscussUin);
    localObject1 = paramFromServiceMsg.AddResult;
    label477:
    DiscussionMemberInfo localDiscussionMemberInfo;
    if (localObject1 != null)
    {
      localObject2 = ((Map)localObject1).keySet();
      localArrayList = new ArrayList();
      localObject2 = ((Set)localObject2).iterator();
      i1 = 0;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Long)((Iterator)localObject2).next();
        if (((Integer)((Map)localObject1).get(localObject3)).intValue() != 0) {
          break label682;
        }
        localDiscussionMemberInfo = new DiscussionMemberInfo();
        localDiscussionMemberInfo.discussionUin = String.valueOf(paramFromServiceMsg.DiscussUin);
        localDiscussionMemberInfo.memberUin = String.valueOf(localObject3);
        localDiscussionMemberInfo.flag = 0;
        localObject3 = ((FriendsManager)paramObject).a(localDiscussionMemberInfo.memberUin);
        if ((localObject3 != null) && (((Friends)localObject3).isFriend()))
        {
          localDiscussionMemberInfo.memberName = ((Friends)localObject3).name;
          label588:
          localArrayList.add(localDiscussionMemberInfo);
          i1 += 1;
        }
      }
    }
    label607:
    label682:
    for (;;)
    {
      break label477;
      i1 += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(localDiscussionMemberInfo.memberUin);
      break label588;
      localDiscussionManager.b(localArrayList);
      arrayOfObject[0] = Long.valueOf(paramFromServiceMsg.DiscussUin);
      arrayOfObject[1] = paramToServiceMsg.extraData.getString("name");
      arrayOfObject[2] = Integer.valueOf(0);
      a(1002, true, arrayOfObject);
      return;
    }
  }
  
  protected void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleAddDiscussMemberResp");
    }
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    RespAddDiscussMember localRespAddDiscussMember = (RespAddDiscussMember)((DiscussionReceiver.RespPackage)paramObject).b;
    Object localObject2 = (DiscussRespHeader)((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_JavaLangObject;
    paramToServiceMsg = String.valueOf(Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
    int i1 = ((DiscussRespHeader)localObject2).Result;
    Object localObject1 = ((DiscussRespHeader)localObject2).ResultDesc;
    if (((DiscussRespHeader)localObject2).Result != 0)
    {
      a(2000, true, new Object[] { paramToServiceMsg, Integer.valueOf(i1), localObject1 });
      return;
    }
    localObject1 = new Object[3];
    localObject1[0] = paramToServiceMsg;
    localObject1[1] = Integer.valueOf(((DiscussRespHeader)localObject2).Result);
    if ((!paramFromServiceMsg.isSuccess()) || (!((DiscussionReceiver.RespPackage)paramObject).jdField_a_of_type_Boolean))
    {
      localObject1[2] = null;
      a(1003, false, localObject1);
      return;
    }
    paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    localObject2 = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    DiscussionInfo localDiscussionInfo = ((DiscussionManager)localObject2).a(paramToServiceMsg);
    if (localDiscussionInfo == null)
    {
      localObject1[0] = String.valueOf(localRespAddDiscussMember.DiscussUin);
      a(1003, false, localObject1);
      return;
    }
    paramToServiceMsg = localDiscussionInfo.faceUinSet;
    int i2 = 0;
    i1 = i2;
    if (paramToServiceMsg != null)
    {
      i1 = i2;
      if (!paramToServiceMsg.trim().equals("")) {
        i1 = paramToServiceMsg.split(";").length;
      }
    }
    Map localMap;
    Set localSet;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    StringBuffer localStringBuffer;
    Iterator localIterator;
    if (5 - i1 > 0)
    {
      i1 = 1;
      localMap = localRespAddDiscussMember.AddResult;
      localSet = localMap.keySet();
      localArrayList1 = new ArrayList(localSet.size());
      localArrayList2 = new ArrayList();
      localStringBuffer = new StringBuffer();
      localIterator = localSet.iterator();
    }
    for (;;)
    {
      label335:
      if (!localIterator.hasNext()) {
        break label729;
      }
      paramToServiceMsg = (Long)localIterator.next();
      i2 = ((Integer)localMap.get(paramToServiceMsg)).intValue();
      if (QLog.isColorLevel())
      {
        localStringBuffer.append("discussUin: " + localRespAddDiscussMember.DiscussUin + " memberUin: " + paramToServiceMsg.longValue() + " value: " + i2);
        localStringBuffer.append("\n");
      }
      if (i2 != 0)
      {
        if (localSet.size() == 1)
        {
          switch (i2)
          {
          case 106: 
          case 107: 
          case 108: 
          case 109: 
          default: 
            paramToServiceMsg = BaseApplicationImpl.a().getResources().getString(2131372556);
          }
          for (;;)
          {
            ThreadManager.c().post(new pxa(this, paramToServiceMsg));
            break label335;
            i1 = 0;
            break;
            paramToServiceMsg = BaseApplicationImpl.a().getResources().getString(2131372550);
            continue;
            paramToServiceMsg = BaseApplicationImpl.a().getResources().getString(2131372551);
            continue;
            paramToServiceMsg = BaseApplicationImpl.a().getResources().getString(2131372552);
            continue;
            paramToServiceMsg = BaseApplicationImpl.a().getResources().getString(2131372557);
          }
        }
      }
      else
      {
        DiscussionMemberInfo localDiscussionMemberInfo = new DiscussionMemberInfo();
        localDiscussionMemberInfo.discussionUin = String.valueOf(localRespAddDiscussMember.DiscussUin);
        localDiscussionMemberInfo.memberUin = String.valueOf(paramToServiceMsg);
        localDiscussionMemberInfo.flag = 0;
        Friends localFriends = paramFromServiceMsg.c(paramToServiceMsg + "");
        if ((localFriends != null) && (localFriends.name != null)) {
          localDiscussionMemberInfo.memberName = localFriends.name;
        }
        localArrayList1.add(String.valueOf(paramToServiceMsg));
        localArrayList2.add(localDiscussionMemberInfo);
      }
    }
    label729:
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, localStringBuffer.toString());
    }
    a(localRespAddDiscussMember.DiscussUin, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), localArrayList1, 1);
    localDiscussionInfo.DiscussionFlag |= 0x20000000;
    ((DiscussionManager)localObject2).b(localArrayList2);
    if (i1 != 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.d(localDiscussionInfo.uin);
    }
    localObject1[2] = ((DiscussionReceiver.RespPackage)paramObject).b;
    a(1003, true, localObject1);
  }
  
  protected void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 " + paramFromServiceMsg.isSuccess());
    }
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    String str1 = String.valueOf(paramToServiceMsg);
    this.jdField_a_of_type_JavaUtilList.remove(paramToServiceMsg);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str1;
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (Exception paramToServiceMsg)
      {
        Map localMap;
        Iterator localIterator;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 excep", paramToServiceMsg);
        return;
        if (((DiscussionInfo)paramObject).infoSeq != paramFromServiceMsg.uint32_info_seq.get()) {
          continue;
        }
        paramToServiceMsg = localDiscussionManager.a(str1);
        arrayOfObject[1] = Boolean.valueOf(a(str1, (List)localObject1, paramToServiceMsg));
        a(1001, true, arrayOfObject);
        int i1 = 0;
        if ((i2 & 0x40) != 0L) {
          continue;
        }
        if (((DiscussionInfo)paramObject).discussionName.equals(localObject2)) {
          break label1841;
        }
        ((DiscussionInfo)paramObject).DiscussionFlag = (i2 | 0x20000000);
        ((DiscussionInfo)paramObject).discussionName = ((String)localObject2);
        i1 = 1;
        if (!QLog.isColorLevel()) {
          break label1841;
        }
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 disUin=" + str1 + " name need server name| local name=" + Utils.a(((DiscussionInfo)paramObject).discussionName));
        i1 = 1;
        if (i1 == 0) {
          continue;
        }
        localDiscussionManager.a((DiscussionInfo)paramObject);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 disUin=" + str1 + " old flag=" + ((DiscussionInfo)paramObject).DiscussionFlag);
        ((DiscussionInfo)paramObject).DiscussionFlag = i2;
        ((DiscussionInfo)paramObject).DiscussionFlag |= 0x20000000;
        ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str1, (DiscussionInfo)paramObject, paramToServiceMsg, false);
        i1 = 1;
        continue;
        if ((((DiscussionInfo)paramObject).discussionName == null) || (((DiscussionInfo)paramObject).discussionName.equals(localObject2))) {
          continue;
        }
        ((DiscussionInfo)paramObject).createTime = paramFromServiceMsg.uint32_create_time.get();
        ((DiscussionInfo)paramObject).ownerUin = String.valueOf(paramFromServiceMsg.uint64_owner_uin.get());
        ((DiscussionInfo)paramObject).inheritOwnerUin = String.valueOf(paramFromServiceMsg.uint64_inherit_owner_uin.get());
        ((DiscussionInfo)paramObject).timeSec = i1;
        ((DiscussionInfo)paramObject).groupUin = paramFromServiceMsg.uint64_group_uin.get();
        ((DiscussionInfo)paramObject).groupCode = paramFromServiceMsg.uint64_group_code.get();
        if ((i2 & 0x40) != 0L) {
          break label1597;
        }
        ((DiscussionInfo)paramObject).discussionName = ((String)localObject2);
        ((DiscussionInfo)paramObject).DiscussionFlag = (i2 | 0x20000000);
        continue;
      }
      finally
      {
        if (!a()) {
          continue;
        }
        e();
      }
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
        {
          arrayOfObject[1] = Boolean.valueOf(false);
          if (QLog.isColorLevel()) {
            QLog.e("Q.contacttab.dscs", 2, "sso check fail " + paramToServiceMsg.uint32_result.get());
          }
          a(1001, false, arrayOfObject);
          if (a()) {
            e();
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        arrayOfObject[1] = Boolean.valueOf(false);
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "merge fail " + paramToServiceMsg.toString());
        }
        a(1001, false, arrayOfObject);
        if (a())
        {
          e();
          return;
        }
      }
    }
    paramFromServiceMsg = new cmd0x58b.RspBody();
    Object localObject1;
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (!paramFromServiceMsg.msg_get_conf_info.has()) {
          break label486;
        }
        paramToServiceMsg = (cmd0x58b.GetConfInfoRsp)paramFromServiceMsg.msg_get_conf_info.get();
        if (!paramToServiceMsg.msg_conf_base_info.has()) {
          break label491;
        }
        paramFromServiceMsg = (cmd0x58b.ConfBaseInfo)paramToServiceMsg.msg_conf_base_info.get();
        localObject1 = paramToServiceMsg.rpt_msg_member_info.get();
        i1 = paramToServiceMsg.uint32_server_remark_timestamp.get();
        if ((paramFromServiceMsg != null) && (localObject1 != null)) {
          break label496;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "baseInfo or membInfoList is null");
        }
        arrayOfObject[1] = Boolean.valueOf(false);
        a(1001, false, arrayOfObject);
        if (!a()) {
          break;
        }
        e();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        arrayOfObject[1] = Boolean.valueOf(false);
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "rspBody merge fail " + paramToServiceMsg.toString());
        }
        a(1001, false, arrayOfObject);
      }
      if (!a()) {
        break;
      }
      e();
      return;
      label486:
      paramToServiceMsg = null;
      continue;
      label491:
      paramFromServiceMsg = null;
    }
    label496:
    int i2 = paramFromServiceMsg.uint32_flag.get();
    Object localObject2 = paramFromServiceMsg.bytes_conf_name.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoResp disUin=" + str1 + " owner=" + paramFromServiceMsg.uint64_owner_uin.get() + " flag=" + paramFromServiceMsg.uint32_flag.get() + " createTime=" + paramFromServiceMsg.uint32_create_time.get() + " disName=" + Utils.a(paramFromServiceMsg.bytes_conf_name.get().toStringUtf8()) + " infoseq=" + paramFromServiceMsg.uint32_info_seq.get() + " timesec=" + i1);
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    paramObject = localDiscussionManager.a(str1);
    long l1;
    label856:
    StringBuffer localStringBuffer;
    if (paramObject == null)
    {
      paramToServiceMsg = new DiscussionInfo();
      paramToServiceMsg.uin = str1;
      paramToServiceMsg.createTime = paramFromServiceMsg.uint32_create_time.get();
      paramToServiceMsg.discussionName = ((String)localObject2);
      paramToServiceMsg.ownerUin = String.valueOf(paramFromServiceMsg.uint64_owner_uin.get());
      paramToServiceMsg.inheritOwnerUin = String.valueOf(paramFromServiceMsg.uint64_inherit_owner_uin.get());
      paramToServiceMsg.timeSec = i1;
      paramToServiceMsg.groupCode = paramFromServiceMsg.uint64_group_code.get();
      paramToServiceMsg.groupUin = paramFromServiceMsg.uint64_group_uin.get();
      l1 = paramToServiceMsg.DiscussionFlag;
      paramToServiceMsg.DiscussionFlag = i2;
      paramToServiceMsg.DiscussionFlag |= l1 & 0x20000000;
      paramObject = paramToServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 disUin=" + str1 + " no found disInfo new flag=" + paramToServiceMsg.DiscussionFlag);
        paramObject = paramToServiceMsg;
      }
      localObject2 = new HashMap();
      l1 = System.currentTimeMillis();
      localMap = localDiscussionManager.a(str1);
      localStringBuffer = new StringBuffer();
      localIterator = ((List)localObject1).iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1762;
        }
        cmd0x58b.ConfMemberInfo localConfMemberInfo = (cmd0x58b.ConfMemberInfo)localIterator.next();
        String str2 = String.valueOf(localConfMemberInfo.uint64_uin.get());
        if (QLog.isColorLevel())
        {
          localStringBuffer.append("memberUin=");
          localStringBuffer.append(str2.toString());
          localStringBuffer.append("flag=");
          localStringBuffer.append(localConfMemberInfo.uint32_flag.get());
          localStringBuffer.append("inteRemark=");
          localStringBuffer.append(Utils.a(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8()));
          localStringBuffer.append("Source=");
          localStringBuffer.append(localConfMemberInfo.uint32_interemark_source.get());
          localStringBuffer.append("\r\n");
        }
        paramToServiceMsg = null;
        if (localMap != null) {
          paramToServiceMsg = (DiscussionMemberInfo)localMap.get(str2);
        }
        localObject1 = paramToServiceMsg;
        if (paramToServiceMsg == null)
        {
          localObject1 = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)localObject1).discussionUin = str1;
          ((DiscussionMemberInfo)localObject1).memberUin = str2;
        }
        ((DiscussionMemberInfo)localObject1).flag = ((byte)localConfMemberInfo.uint32_flag.get());
        ((DiscussionMemberInfo)localObject1).dataTime = l1;
        if ((!localConfMemberInfo.bytes_member_interemark.has()) || (TextUtils.isEmpty(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8()))) {
          break;
        }
        ((DiscussionMemberInfo)localObject1).inteRemark = localConfMemberInfo.bytes_member_interemark.get().toStringUtf8();
        label1157:
        ((Map)localObject2).put(((DiscussionMemberInfo)localObject1).memberUin, localObject1);
      }
    }
    label1597:
    label1762:
    label1841:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoRespV2 disUin=" + str1 + " old flag=" + ((DiscussionInfo)paramObject).DiscussionFlag);
      }
      ((DiscussionInfo)paramObject).DiscussionFlag = i2;
      ((DiscussionInfo)paramObject).DiscussionFlag |= 0x20000000;
      ((DiscussionInfo)paramObject).discussionName = ((String)localObject2);
      break label856;
      if (!TextUtils.isEmpty(((DiscussionMemberInfo)localObject1).inteRemark)) {
        break label1157;
      }
      paramToServiceMsg = localFriendsManager.a(((DiscussionMemberInfo)localObject1).memberUin);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.isFriend()))
      {
        ((DiscussionMemberInfo)localObject1).memberName = paramToServiceMsg.name;
        if (TextUtils.isEmpty(paramToServiceMsg.remark)) {}
        for (paramToServiceMsg = paramToServiceMsg.name;; paramToServiceMsg = paramToServiceMsg.remark)
        {
          ((DiscussionMemberInfo)localObject1).inteRemark = paramToServiceMsg;
          ((DiscussionMemberInfo)localObject1).inteRemarkSource = 129L;
          break;
        }
      }
      ((DiscussionMemberInfo)localObject1).inteRemarkSource = 0L;
      break label1157;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, localStringBuffer.toString());
      }
      localDiscussionManager.a(str1, (DiscussionInfo)paramObject, paramFromServiceMsg.uint32_info_seq.get(), (Map)localObject2, l1);
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.d(((DiscussionInfo)paramObject).uin);
      arrayOfObject[1] = Boolean.valueOf(true);
      a(1001, true, arrayOfObject);
      if (!a()) {
        break;
      }
      e();
      return;
    }
  }
  
  public void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = System.currentTimeMillis();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember req or res is null!");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramFromServiceMsg.getResultCode() == 1002)
        {
          i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
          if (i1 < 1)
          {
            paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
            a(paramToServiceMsg);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember retry timeout!");
          }
        }
        else if (paramFromServiceMsg.getResultCode() != 1000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember failCode:" + paramFromServiceMsg.getResultCode());
          }
        }
        else
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          try
          {
            paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
              break label238;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember ssoPkg invalid!");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember merge ssopkg exception!");
    return;
    label238:
    i3 = 0;
    int i10 = 0;
    int i11 = 0;
    i1 = 0;
    int i2 = 0;
    int i12 = 0;
    int i9 = 0;
    paramObject = new oidb_0x751.RspBody();
    int i4 = i12;
    i6 = i11;
    int i8 = i3;
    for (;;)
    {
      try
      {
        ((oidb_0x751.RspBody)paramObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        i4 = i12;
        i6 = i11;
        i8 = i3;
        i3 = ((oidb_0x751.RspBody)paramObject).uint32_err_code.get();
        if (i3 != 0)
        {
          i5 = i9;
          i7 = i1;
          i4 = i12;
          i6 = i11;
          i8 = i3;
          if (QLog.isColorLevel())
          {
            i4 = i12;
            i6 = i11;
            i8 = i3;
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember handle rspBody error! resultCode:" + i3 + " ,errMsg:" + ((oidb_0x751.RspBody)paramObject).bytes_err_msg.get().toString());
            i7 = i1;
            i5 = i9;
          }
          i2 = 0;
          i1 = i3;
          i6 = i7;
          i4 = i5;
          l1 = System.currentTimeMillis() - l1;
          i3 = paramToServiceMsg.extraData.getInt("checkDiscCount");
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember end! resultCode:" + i1 + " ,totalCount:" + i3 + " ,validCount:" + i6 + " ,invalidCount:" + i4 + " ,cost:" + l1);
          }
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("pm_totalCount", String.valueOf(i3));
          paramToServiceMsg.put("pm_validCount", String.valueOf(i6));
          paramToServiceMsg.put("pm_inValidCount", String.valueOf(i4));
          paramToServiceMsg.put("pm_resultCode", String.valueOf(i1));
          if (i2 != 0) {
            paramToServiceMsg.put("pm_exceptionHappen", "true");
          }
          StatisticCollector.a(BaseApplication.getContext()).a(null, "checkIsDiscussionMember", true, l1, 0L, paramToServiceMsg, null);
          return;
        }
        int i5 = i9;
        int i7 = i1;
        i4 = i12;
        i6 = i11;
        i8 = i3;
        if (!((oidb_0x751.RspBody)paramObject).msg_rsp_check_is_conf_member.has()) {
          continue;
        }
        i4 = i12;
        i6 = i11;
        i8 = i3;
        paramFromServiceMsg = (oidb_0x751.RspCheckIsConfMember)((oidb_0x751.RspBody)paramObject).msg_rsp_check_is_conf_member.get();
        i5 = i9;
        i7 = i1;
        i4 = i12;
        i6 = i11;
        i8 = i3;
        if (!paramFromServiceMsg.msg_check_is_conf_member_result.has()) {
          continue;
        }
        i4 = i12;
        i6 = i11;
        i8 = i3;
        paramFromServiceMsg = paramFromServiceMsg.msg_check_is_conf_member_result.get().iterator();
        i1 = i10;
        i5 = i2;
        i7 = i1;
        i4 = i2;
        i6 = i1;
        i8 = i3;
        if (!paramFromServiceMsg.hasNext()) {
          continue;
        }
        i4 = i2;
        i6 = i1;
        i8 = i3;
        paramObject = (oidb_0x751.CheckIsConfMemberResult)paramFromServiceMsg.next();
        i4 = i2;
        i6 = i1;
        i8 = i3;
        str = String.valueOf(((oidb_0x751.CheckIsConfMemberResult)paramObject).uint64_conf_uin.get());
        i4 = i2;
        i6 = i1;
        i8 = i3;
        i5 = ((oidb_0x751.CheckIsConfMemberResult)paramObject).uint32_is_conf_member.get();
        if (i5 == 0) {
          i4 = i2 + 1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        String str;
        i1 = i8;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember. Need to deleteDiscuss:" + str);
        }
        a(str);
        i2 = i1;
        i1 = i4;
        i4 = i2;
        i2 = i1;
        i1 = i4;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          i6 = i1;
          i1 = i3;
        }
      }
      i4 = i1 + 1;
      i1 = i2;
      i2 = i4;
      continue;
      QLog.i("DiscussionHandler", 1, "handleCheckIsDiscussionMember handle rspBody exception!", paramFromServiceMsg);
      i2 = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\DiscussionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */