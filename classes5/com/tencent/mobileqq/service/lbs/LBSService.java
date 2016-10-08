package com.tencent.mobileqq.service.lbs;

import EncounterSvc.ReqGetEntrance;
import EncounterSvc.ReqGetRecommender;
import EncounterSvc.ReqUserInfo;
import EncounterSvc.RespGetEntrance;
import EncounterSvc.RespGetRecommender;
import GameCenter.ReqLastGameInfo;
import LBSAddrProtocol.ReqGetPositionApi;
import LBSAddrProtocol.RspGetPositionApi;
import LBSAddrProtocol.RspHeader;
import NearbyGroup.LBSInfo;
import NearbyGroup.ReqGetAreaList;
import NearbyGroup.ReqGetGroupInArea;
import NearbyGroup.ReqGetNearbyGroup;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NearbyPubAcct.RspGetNearbyPubAcctInfo;
import NeighborComm.LocalInfoType;
import NeighborComm.RespHeader;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import NeighborSvc.ReqGetSwitches;
import NeighborSvc.ReqSetStateSwitch;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import NeighborSvc.RespSetUserState;
import QQService.FaceInfo;
import QQService.Intro;
import QQService.ReqAddFace;
import QQService.ReqDelFace;
import QQService.ReqFaceInfo;
import QQService.ReqGetCardSwitch;
import QQService.ReqGetFace;
import QQService.ReqGetFavoriteList;
import QQService.ReqGetVoterList;
import QQService.ReqHYMakeFriendsCard;
import QQService.ReqPicSafetyCheck;
import QQService.ReqSetCard;
import QQService.ReqSetCardSwitch;
import QQService.ReqUpdateIntro;
import QQService.ReqVote;
import QQService.RespAddFace;
import QQService.RespDelFace;
import QQService.RespFaceInfo;
import QQService.RespGetCardSwitch;
import QQService.RespGetFace;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespHYMakeFriendsCard;
import QQService.RespHead;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.RespUpdateIntro;
import QQService.RespVote;
import QQService.UserCntlData;
import SummaryCard.CondFitUser;
import SummaryCard.ReqCondSearch;
import SummaryCard.ReqSearch;
import SummaryCard.ReqSummaryCard;
import SummaryCard.ReqVoiceManage;
import SummaryCard.RespCondSearch;
import SummaryCard.RespSearch;
import SummaryCard.RespSummaryCard;
import SummaryCard.RespVoiceManage;
import SummaryCard.VoiceInfo;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardLikeIt;
import SummaryCardTaf.SSummaryCardQueryReq;
import SummaryCardTaf.SSummaryCardSetLabel;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.addcontacts.AccountSearchPb.Location;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.pb.addcontacts.AccountSearchPb.search;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LBSService
  extends BaseProtocolCoder
{
  public static final int a = 3000;
  private static final String jdField_a_of_type_JavaLangString = "LBSService";
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "NeighborSvc", "KQQFS", "MCardSvc", "MobileQQ", "EncounterSvc", "VisitorSvc", "LBS", "SummaryCard", "NearbyGroup", "NeighborRecommender" };
  private static final int b = 30;
  private NeighborSvc.UserData jdField_a_of_type_NeighborSvcUserData;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public EncounterSvc.UserData[] a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LBSService(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ArrayOfEncounterSvcUserData = new EncounterSvc.UserData[2];
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private boolean A(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("param_keyword");
    String str = paramToServiceMsg.extraData.getString("param_country_code");
    double d1 = paramToServiceMsg.extraData.getDouble("search_longtitude");
    double d2 = paramToServiceMsg.extraData.getDouble("search_latitude");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("search_list");
    int n = paramToServiceMsg.extraData.getInt("search_page");
    int i1 = paramToServiceMsg.extraData.getInt("search_version");
    int i2 = paramToServiceMsg.extraData.getInt("filter_type", 0);
    Object localObject1 = null;
    if (i1 == 2) {}
    label610:
    for (;;)
    {
      localObject1 = new ReqSearch((String)localObject2, str, i1, (ArrayList)localObject1);
      localObject2 = new SummaryCard.ReqHead();
      ((SummaryCard.ReqHead)localObject2).iVersion = 2;
      paramUniPacket.setServantName("SummaryCardServantObj");
      paramUniPacket.setFuncName("ReqSearch");
      paramUniPacket.put("ReqHead", localObject2);
      paramUniPacket.put("ReqSearch", localObject1);
      paramToServiceMsg.setTimeout(30000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.ReqSearch");
      return true;
      if (i1 == 3)
      {
        localObject1 = new ArrayList();
        int j = 0;
        try
        {
          i = Integer.parseInt("2880");
          int i3 = arrayOfInt.length;
          j = 0;
          for (;;)
          {
            if (j >= i3) {
              break label610;
            }
            Object localObject3 = new SummaryCardBusiEntry.comm();
            ((SummaryCardBusiEntry.comm)localObject3).ver.set(1);
            ((SummaryCardBusiEntry.comm)localObject3).seq.set(paramToServiceMsg.getAppSeq());
            ((SummaryCardBusiEntry.comm)localObject3).service.set(arrayOfInt[j]);
            ((SummaryCardBusiEntry.comm)localObject3).platform.set(2);
            ((SummaryCardBusiEntry.comm)localObject3).qqver.set("6.5.5.2880");
            ((SummaryCardBusiEntry.comm)localObject3).build.set(i);
            localObject3 = ((SummaryCardBusiEntry.comm)localObject3).toByteArray();
            int k = localObject3.length;
            localObject4 = new AccountSearchPb.search();
            ((AccountSearchPb.search)localObject4).start.set(n);
            if (arrayOfInt[j] != 80000001) {
              break;
            }
            ((AccountSearchPb.search)localObject4).count.set(4);
            ((AccountSearchPb.search)localObject4).keyword.set((String)localObject2);
            ((AccountSearchPb.search)localObject4).highlight.add(localObject2);
            Object localObject5 = new AccountSearchPb.Location();
            ((AccountSearchPb.Location)localObject5).double_longitude.set(d1);
            ((AccountSearchPb.Location)localObject5).double_latitude.set(d2);
            ((AccountSearchPb.search)localObject4).msg_user_location.set((MessageMicro)localObject5);
            ((AccountSearchPb.search)localObject4).filtertype.set(i2);
            if (QLog.isDevelopLevel()) {
              QLog.d("LBSService", 4, "request has set filtertype " + i2);
            }
            localObject4 = ((AccountSearchPb.search)localObject4).toByteArray();
            int i4 = localObject4.length;
            localObject5 = new byte[k + 9 + i4 + 1];
            localObject5[0] = 40;
            PkgTools.a((byte[])localObject5, 1, k);
            PkgTools.a((byte[])localObject5, 5, i4);
            PkgTools.a((byte[])localObject5, 9, (byte[])localObject3, k);
            int m = localObject3.length + 9;
            k = m;
            if (localObject4 != null)
            {
              PkgTools.a((byte[])localObject5, m, (byte[])localObject4, i4);
              k = m + i4;
            }
            localObject5[k] = 41;
            ((ArrayList)localObject1).add(localObject5);
            j += 1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            Object localObject4;
            int i = j;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.profilecard.SummaryCard", 2, localNumberFormatException.toString());
              i = j;
              continue;
              if (arrayOfInt[j] == 80000003) {
                ((AccountSearchPb.search)localObject4).count.set(8);
              }
            }
          }
        }
      }
    }
  }
  
  private boolean B(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("param_page");
    long l = paramToServiceMsg.extraData.getLong("param_session_id");
    Object localObject1 = paramToServiceMsg.extraData.getString("param_keyword");
    int j = paramToServiceMsg.extraData.getInt("param_sex_index");
    int k = paramToServiceMsg.extraData.getInt("param_age_index1");
    int m = paramToServiceMsg.extraData.getInt("param_age_index2");
    int n = paramToServiceMsg.extraData.getInt("param_job_index");
    int i1 = paramToServiceMsg.extraData.getInt("param_xingzuo_index");
    Object localObject3 = paramToServiceMsg.extraData.getStringArray("param_loc_code");
    Object localObject2 = paramToServiceMsg.extraData.getStringArray("param_home_code");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(16);
    if ((localObject3 != null) && (localObject3.length == 4))
    {
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[0]));
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[1]));
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[2]));
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[3]));
      localObject3 = ByteBuffer.allocate(16);
      if ((localObject2 == null) || (localObject2.length != 4)) {
        break label383;
      }
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[0]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[1]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[2]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[3]));
    }
    for (;;)
    {
      localObject1 = new ReqCondSearch(i, l, 1L, (String)localObject1, (byte)j, localByteBuffer.array(), (short)255, ((ByteBuffer)localObject3).array(), (byte)i1, n, (short)k, (short)m);
      localObject2 = new SummaryCard.ReqHead();
      ((SummaryCard.ReqHead)localObject2).iVersion = 2;
      paramUniPacket.setServantName("SummaryCardServantObj");
      paramUniPacket.setFuncName("ReqCondSearch");
      paramUniPacket.put("ReqHead", localObject2);
      paramUniPacket.put("ReqCondSearch", localObject1);
      paramToServiceMsg.setTimeout(15000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.ReqCondSearch");
      return true;
      localByteBuffer.putInt(0).putInt(0).putInt(0).putInt(0);
      break;
      label383:
      ((ByteBuffer)localObject3).putInt(0).putInt(0).putInt(0).putInt(0);
    }
  }
  
  private ReqGetNearbyGroup a(int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject1;
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      Object localObject2 = new LBSInfo();
      ((LBSInfo)localObject2).stGps = new NearbyGroup.GPS(paramInt1, paramInt2, 0, 1);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyTroopsActivity.data", 2, "getGroupListRequest: lat!=0 && lon!=0");
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        localObject2 = new ReqGetNearbyGroup();
        ((ReqGetNearbyGroup)localObject2).stLBSInfo = ((LBSInfo)localObject1);
        return (ReqGetNearbyGroup)localObject2;
      }
    }
    else
    {
      localObject1 = SosoInterface.a();
      if ((localObject1 == null) || (((LBSInfo)localObject1).stGps == null)) {
        break label159;
      }
      paramInt2 = ((LBSInfo)localObject1).stGps.iLat;
    }
    for (paramInt1 = ((LBSInfo)localObject1).stGps.iLon;; paramInt1 = i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity.data", 2, "getGroupListRequest: getRawLbsInfo," + paramInt2 + "," + paramInt1);
      }
      break;
      return null;
      label159:
      paramInt2 = 0;
    }
  }
  
  public static RspGetAreaList a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetAreaList)localUniPacket.getByClass("RspGetAreaList", new RspGetAreaList());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static RspGetGroupInArea a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetGroupInArea)localUniPacket.getByClass("RspGetGroupInArea", new RspGetGroupInArea());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static RspGetNearbyGroup a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetNearbyGroup)localUniPacket.getByClass("RspGetNearbyGroup", new RspGetNearbyGroup());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static RspGetNearbyPubAcctInfo a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetNearbyPubAcctInfo)localUniPacket.getByClass("nearby_pubacct", new RspGetNearbyPubAcctInfo());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  public static ArrayList a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(6);
    int k = paramArrayList.size();
    int i = 0;
    label56:
    label79:
    int n;
    Object localObject2;
    SummaryCardBusiEntry.comm localcomm;
    if (i < k)
    {
      Object localObject1 = (byte[])paramArrayList.get(i);
      if (localObject1 == null)
      {
        j = 0;
        if (j > 10) {
          break label79;
        }
      }
      label410:
      label416:
      do
      {
        int m;
        do
        {
          i += 1;
          break;
          j = localObject1.length;
          break label56;
          n = (int)PkgTools.a((byte[])localObject1, 1);
          m = (int)PkgTools.a((byte[])localObject1, 5);
        } while ((n <= 0) || (n + 9 >= j));
        localObject2 = new byte[n];
        PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, 9, n);
        j = n + 9;
        localcomm = new SummaryCardBusiEntry.comm();
        for (;;)
        {
          try
          {
            localcomm.mergeFrom((byte[])localObject2);
            n = localcomm.result.get();
            if (n != 0) {
              break label455;
            }
            n = localcomm.service.get();
            localObject2 = new byte[m];
            PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, j, m);
            localObject1 = new AccountSearchPb.search();
            ((AccountSearchPb.search)localObject1).mergeFrom((byte[])localObject2);
            localObject2 = new SearchResult();
            ((SearchResult)localObject2).jdField_a_of_type_Int = n;
            ((SearchResult)localObject2).jdField_b_of_type_Int = ((AccountSearchPb.search)localObject1).start.get();
            if (((AccountSearchPb.search)localObject1).end.get() != 1) {
              break label410;
            }
            bool = true;
            ((SearchResult)localObject2).jdField_a_of_type_Boolean = bool;
            ((SearchResult)localObject2).jdField_b_of_type_JavaUtilList = ((AccountSearchPb.search)localObject1).list.get();
            ((SearchResult)localObject2).jdField_a_of_type_JavaUtilList = ((AccountSearchPb.search)localObject1).highlight.get();
            ((SearchResult)localObject2).jdField_a_of_type_JavaLangString = ((AccountSearchPb.search)localObject1).article_more_url.get();
            ((SearchResult)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = ((AccountSearchPb.hotwordrecord)((AccountSearchPb.search)localObject1).hotword_record.get());
            if ((((SearchResult)localObject2).jdField_b_of_type_JavaUtilList == null) || (((SearchResult)localObject2).jdField_b_of_type_JavaUtilList.size() <= 0)) {
              break;
            }
            localArrayList.add(localObject2);
            if (n != 80000000) {
              break label416;
            }
            localObject1 = ((AccountSearchPb.search)localObject1).list.get().iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (AccountSearchPb.record)((Iterator)localObject1).next();
            if (((AccountSearchPb.record)localObject2).sign.get() == null) {
              continue;
            }
            ((AccountSearchPb.record)localObject2).richStatus = RichStatus.parseStatus(((AccountSearchPb.record)localObject2).sign.get().toByteArray());
            continue;
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (Exception localException) {}
          QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
          break;
          boolean bool = false;
        }
      } while ((n != 80000001) || (!localException.bool_location_group.has()));
      if (!localException.bool_location_group.get()) {
        break label528;
      }
    }
    label455:
    label528:
    for (int j = 1;; j = 2)
    {
      ((SearchResult)localObject2).c = j;
      break;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.profilecard.SummaryCard", 4, "busi entry, [" + localcomm.service.get() + "," + n + "," + localcomm.err_msg.get());
      break;
      return localArrayList;
    }
  }
  
  private Object b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = (RspHeader)a(paramFromServiceMsg.getWupBuffer(), "RspHeader", new RspHeader());
      if ((paramToServiceMsg != null) && (paramToServiceMsg.eResult == 0))
      {
        paramFromServiceMsg = (RspGetPositionApi)a(paramFromServiceMsg.getWupBuffer(), "RspGetPositionApi", new RspGetPositionApi());
        if (paramFromServiceMsg != null) {}
        return paramFromServiceMsg;
      }
    }
    return null;
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetVoterList)a(paramFromServiceMsg.getWupBuffer(), "RespGetVoterList", new RespGetVoterList());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("selfuin");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("filekey");
    int i = paramToServiceMsg.extraData.getInt("timestamp", 0);
    Object localObject1 = new QQService.ReqHead(l, (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    localObject2 = new FaceInfo((byte[])localObject2, 0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    localObject1 = new ReqAddFace((QQService.ReqHead)localObject1, i, localArrayList);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqAddFace");
    paramUniPacket.put("ReqAddFace", localObject1);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqAddFace");
    return true;
  }
  
  private Object c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespSetUserState)a(paramFromServiceMsg.getWupBuffer(), "RespSetUserState", new RespSetUserState());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetFavoriteList)a(paramFromServiceMsg.getWupBuffer(), "RespGetFavoriteList", new RespGetFavoriteList());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfuin");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("filekey");
    long l2 = paramToServiceMsg.extraData.getLong("timestamp");
    Object localObject1 = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    localObject2 = new FaceInfo((byte[])localObject2, 0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    localObject1 = new ReqDelFace((QQService.ReqHead)localObject1, (int)l2, localArrayList);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqDelFace");
    paramUniPacket.put("ReqDelFace", localObject1);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqDelFace");
    return true;
  }
  
  private Object d(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespSetStateSwitch)a(paramFromServiceMsg.getWupBuffer(), "RespSetStateSwitch", new RespSetStateSwitch());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    int i = paramToServiceMsg.extraData.getInt("timestamp", 0);
    Object localObject = new QQService.ReqHead(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()), (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    boolean bool = ((FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(50)).b(String.valueOf(l));
    if ((l == Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a())) || (bool)) {}
    for (byte b1 = 0;; b1 = 1)
    {
      localObject = new ReqFaceInfo((QQService.ReqHead)localObject, l, i, b1);
      paramUniPacket.setServantName("MCardSvc");
      paramUniPacket.setFuncName("ReqFaceInfo");
      paramUniPacket.put("ReqFaceInfo", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("MCardSvc.ReqFaceInfo");
      return true;
    }
  }
  
  private Object e(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespGetSwitches)a(paramFromServiceMsg.getWupBuffer(), "RespGetSwitches", new RespGetSwitches());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject1 = paramToServiceMsg.extraData.getString("lUin");
    long l = paramToServiceMsg.extraData.getLong("lNextMid");
    int i = paramToServiceMsg.extraData.getInt("iPageSize");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("strCookie");
    QQService.ReqHead localReqHead = new QQService.ReqHead(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()), (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    localObject2 = new UserCntlData(l, (byte[])localObject2);
    localObject1 = new ReqGetFace(localReqHead, Long.parseLong((String)localObject1), (UserCntlData)localObject2, i);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqGetFace");
    paramUniPacket.put("ReqGetFace", localObject1);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqGetFace");
    return true;
  }
  
  private Object f(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.eReplyCode == 0)) {
      this.jdField_a_of_type_ArrayOfByte = paramFromServiceMsg.vContext;
    }
    return paramFromServiceMsg;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    int k = paramToServiceMsg.extraData.getInt("radius");
    paramToServiceMsg = new ReqGetAreaList();
    paramToServiceMsg.iLat = i;
    paramToServiceMsg.iLon = j;
    paramToServiceMsg.iRadius = k;
    paramToServiceMsg.vClientVersion = "6.5.5".getBytes();
    paramToServiceMsg.uiClientType = 2L;
    paramUniPacket.setServantName("NearbyGroup");
    paramUniPacket.setFuncName("ReqGetAreaList");
    paramUniPacket.put("ReqGetAreaList", paramToServiceMsg);
    return true;
  }
  
  private Object g(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.extraData.getString("areaName");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    int k = paramToServiceMsg.extraData.getInt("startIndex");
    int m = paramToServiceMsg.extraData.getInt("count");
    int n = paramToServiceMsg.extraData.getInt("iFilterId");
    paramToServiceMsg = new ReqGetGroupInArea();
    paramToServiceMsg.strAreaName = str;
    paramToServiceMsg.iLat = i;
    paramToServiceMsg.iLon = j;
    paramToServiceMsg.dwGroupStartIdx = k;
    paramToServiceMsg.iCount = m;
    paramToServiceMsg.uiLabelStyle = 2L;
    paramToServiceMsg.iFilterId = n;
    paramToServiceMsg.vClientVersion = "6.5.5".getBytes();
    paramToServiceMsg.uiClientType = 2L;
    paramUniPacket.setServantName("NearbyGroup");
    paramUniPacket.setFuncName("ReqGetGroupInArea");
    paramUniPacket.put("ReqGetGroupInArea", paramToServiceMsg);
    return true;
  }
  
  private Object h(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    String str = paramToServiceMsg.extraData.getString("strGroupArea");
    boolean bool = paramToServiceMsg.extraData.getBoolean("first");
    short s = paramToServiceMsg.extraData.getShort("shSortType");
    int k = paramToServiceMsg.extraData.getInt("iFilterId");
    if ((i == 0) && (j == 0))
    {
      SosoInterface.a(60000L, getClass().getSimpleName() + ".Groups");
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity.data", 2, "handleGetGroups: lat==0&&lon==0, reqRawLbsData");
      }
    }
    paramToServiceMsg = a(i, j);
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.shVersion = 2;
      paramToServiceMsg.vClientVersion = "6.5.5".getBytes();
      paramToServiceMsg.uiClientType = 2L;
      paramToServiceMsg.iCount = 30;
      paramToServiceMsg.bShowOpen = true;
      paramToServiceMsg.bShowXiaoQu = true;
      paramToServiceMsg.bShowActivity = true;
      paramToServiceMsg.shSortType = s;
      paramToServiceMsg.iFilterId = k;
      paramToServiceMsg.uiLabelStyle = 2L;
      if ((!bool) && (this.jdField_a_of_type_ArrayOfByte != null)) {
        paramToServiceMsg.vContext = this.jdField_a_of_type_ArrayOfByte;
      }
      if (!TextUtils.isEmpty(str)) {
        paramToServiceMsg.strGroupArea = str;
      }
      paramUniPacket.setServantName("NearbyGroup");
      paramUniPacket.setFuncName("GetList");
      paramUniPacket.put("ReqGetNearbyGroup", paramToServiceMsg);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyTroopsActivity.data", 2, "handleGetGroups: req==null");
    }
    return false;
  }
  
  private Object i(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    if ((paramToServiceMsg != null) && (paramToServiceMsg.eReplyCode == 0))
    {
      paramFromServiceMsg = (RespGetEntrance)a(paramFromServiceMsg.getWupBuffer(), "RespGetEntrance", new RespGetEntrance());
      return new Object[] { paramToServiceMsg, paramFromServiceMsg };
    }
    if (QLog.isColorLevel()) {
      if (paramToServiceMsg != null) {
        break label94;
      }
    }
    label94:
    for (paramFromServiceMsg = "respHeader is null";; paramFromServiceMsg = String.valueOf(paramToServiceMsg.eReplyCode))
    {
      QLog.i("LBS", 2, paramFromServiceMsg);
      paramFromServiceMsg = null;
      break;
    }
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "handleGetEntrance");
    }
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c == 0.0D) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d == 0.0D))
    {
      SosoInterface.a(60000L, getClass().getSimpleName());
      localObject1 = SosoInterface.a();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        NeighborComm.ReqHeader localReqHeader = new NeighborComm.ReqHeader();
        localReqHeader.shVersion = 2;
        localReqHeader.lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
        localReqHeader.iAppID = AppSetting.jdField_a_of_type_Int;
        localReqHeader.eBusiType = 0;
        localReqHeader.eMqqSysType = 2;
        ReqUserInfo localReqUserInfo = new ReqUserInfo();
        localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
        localReqUserInfo.strAuthPassword = "NzVK_qGE";
        localReqUserInfo.eListType = 0;
        localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
        localReqUserInfo.stGps = new EncounterSvc.GPS((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D), (int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D), -1, 0);
        localReqUserInfo.vSOSOCells = new ArrayList();
        Object localObject2;
        if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SosoInterface.SosoCell localSosoCell = (SosoInterface.SosoCell)((Iterator)localObject2).next();
            localReqUserInfo.vSOSOCells.add(new SOSO_Cell((short)localSosoCell.jdField_a_of_type_Int, (short)localSosoCell.jdField_b_of_type_Int, localSosoCell.c, localSosoCell.d, (short)localSosoCell.e));
          }
        }
        localReqUserInfo.vSOSOMac = new ArrayList();
        if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
        {
          localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
            localReqUserInfo.vSOSOMac.add(new SOSO_Wifi(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long, (short)((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int));
          }
        }
        localObject1 = new ReqUserInfo();
        int i = paramToServiceMsg.extraData.getInt("localLat");
        int j = paramToServiceMsg.extraData.getInt("localLon");
        if ((i != 0) && (j != 0))
        {
          ((ReqUserInfo)localObject1).vCells = new ArrayList(1);
          ((ReqUserInfo)localObject1).vMacs = new ArrayList(1);
          ((ReqUserInfo)localObject1).eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
          ((ReqUserInfo)localObject1).stGps = new EncounterSvc.GPS(i, j, 0, 1);
        }
        paramToServiceMsg = new ReqGetEntrance(localReqUserInfo, 15);
        paramUniPacket.setEncodeName("utf-8");
        paramUniPacket.setServantName("EncounterObj");
        paramUniPacket.setFuncName("CMD_GET_ENTRANCE");
        paramUniPacket.put("ReqHeader", localReqHeader);
        paramUniPacket.put("ReqGetEntrance", paramToServiceMsg);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSService", 2, "handleGetEntrance lbsinfo is null");
      }
      paramToServiceMsg.extraData.putBoolean("isLbsInfoNull", true);
      return false;
    }
  }
  
  private Object j(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespFaceInfo)a(paramFromServiceMsg.getWupBuffer(), "RespFaceInfo", new RespFaceInfo());
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "handleGetNearbyRecommender");
    }
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c == 0.0D) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d == 0.0D))
    {
      SosoInterface.a(60000L, getClass().getSimpleName());
      localObject1 = SosoInterface.a();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        NeighborComm.ReqHeader localReqHeader = new NeighborComm.ReqHeader();
        localReqHeader.shVersion = 2;
        localReqHeader.lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
        localReqHeader.iAppID = AppSetting.jdField_a_of_type_Int;
        localReqHeader.eBusiType = 0;
        localReqHeader.eMqqSysType = 2;
        ReqUserInfo localReqUserInfo = new ReqUserInfo();
        localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
        localReqUserInfo.strAuthPassword = "NzVK_qGE";
        localReqUserInfo.eListType = 0;
        localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
        localReqUserInfo.stGps = new EncounterSvc.GPS((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D), (int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D), -1, 0);
        localReqUserInfo.vSOSOCells = new ArrayList();
        Object localObject2;
        if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SosoInterface.SosoCell localSosoCell = (SosoInterface.SosoCell)((Iterator)localObject2).next();
            localReqUserInfo.vSOSOCells.add(new SOSO_Cell((short)localSosoCell.jdField_a_of_type_Int, (short)localSosoCell.jdField_b_of_type_Int, localSosoCell.c, localSosoCell.d, (short)localSosoCell.e));
          }
        }
        localReqUserInfo.vSOSOMac = new ArrayList();
        if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
        {
          localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
            localReqUserInfo.vSOSOMac.add(new SOSO_Wifi(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long, (short)((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int));
          }
        }
        localObject1 = new ReqGetRecommender();
        ((ReqGetRecommender)localObject1).stUserInfo = localReqUserInfo;
        ((ReqGetRecommender)localObject1).eTimingType = paramToServiceMsg.extraData.getInt("timingType");
        paramUniPacket.setEncodeName("utf-8");
        paramUniPacket.setServantName("EncounterObj");
        paramUniPacket.setFuncName("CMD_GET_RECOMMENDER");
        paramUniPacket.put("ReqHeader", localReqHeader);
        paramUniPacket.put("ReqGetRecommender", localObject1);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSService", 2, "handleGetNearbyRecommender lbsinfo is null");
      }
      paramToServiceMsg.extraData.putBoolean("isLbsInfoNull", true);
      return false;
    }
  }
  
  private Object k(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    if ((paramToServiceMsg != null) && (paramToServiceMsg.eReplyCode == 0))
    {
      paramFromServiceMsg = (RespGetRecommender)a(paramFromServiceMsg.getWupBuffer(), "RespGetRecommender", new RespGetRecommender());
      return new Object[] { paramToServiceMsg, paramFromServiceMsg };
    }
    if (QLog.isColorLevel()) {
      if (paramToServiceMsg != null) {
        break label94;
      }
    }
    label94:
    for (paramFromServiceMsg = "decodeNearbyRecommender respHeader is null";; paramFromServiceMsg = String.valueOf(paramToServiceMsg.eReplyCode))
    {
      QLog.i("LBS", 2, paramFromServiceMsg);
      paramFromServiceMsg = null;
      break;
    }
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = 0;
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.jdField_a_of_type_Int;
    if (paramToServiceMsg.extraData.getBoolean("k_be_share", false)) {
      i = 1;
    }
    localObject = new ReqSetStateSwitch((NeighborSvc.ReqHeader)localObject, (byte)i);
    paramUniPacket.setServantName("NeighborObj");
    paramUniPacket.setFuncName("CMD_SET_STATE_SWITCH");
    paramUniPacket.put("ReqSetStateSwitch", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("NeighborSvc.ReqSetStateSwitch");
    return true;
  }
  
  private Object l(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespHYMakeFriendsCard)a(paramFromServiceMsg.getWupBuffer(), "RespHYMakeFriendsCard", new RespHYMakeFriendsCard());
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.jdField_a_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(64));
    localObject = new ReqGetSwitches((NeighborSvc.ReqHeader)localObject, localArrayList);
    paramUniPacket.setServantName("NeighborObj");
    paramUniPacket.setFuncName("CMD_GET_SWITCHES");
    paramUniPacket.put("ReqGetSwitches", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("NeighborSvc.ReqGetSwitches");
    return true;
  }
  
  private Object m(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespUpdateIntro)a(paramFromServiceMsg.getWupBuffer(), "RespUpdateIntro", new RespUpdateIntro());
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    long l = Long.parseLong(paramToServiceMsg.extraData.getString("friendUin"));
    byte b1 = paramToServiceMsg.extraData.getByte("bReqType");
    ((QQService.ReqHead)localObject).bReqType = b1;
    localObject = new ReqHYMakeFriendsCard((QQService.ReqHead)localObject, l, b1, paramToServiceMsg.extraData.getInt("uFaceTimeStamp"));
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqHYMakeFriendsCard");
    paramUniPacket.put("ReqHYMakeFriendsCard", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqHYMakeFriendsCard");
    return true;
  }
  
  private Object n(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSummaryCard)a(paramFromServiceMsg.getWupBuffer(), "RespSummaryCard", new RespSummaryCard());
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    String str = paramToServiceMsg.extraData.getString("vContent");
    localObject = new ReqUpdateIntro((QQService.ReqHead)localObject, new Intro(paramToServiceMsg.extraData.getShort("shType"), str.getBytes()));
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqUpdateIntro");
    paramUniPacket.put("ReqUpdateIntro", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqUpdateIntro");
    return true;
  }
  
  private Object o(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespVoiceManage)a(paramFromServiceMsg.getWupBuffer(), "RespVoiceManage", new RespVoiceManage());
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin", 0L);
    int k = paramToServiceMsg.extraData.getInt("comeFromType", 0);
    long l3 = paramToServiceMsg.extraData.getLong("qzoneFeedTimeStamp", 0L);
    byte b1 = paramToServiceMsg.extraData.getByte("isFriend");
    long l4 = paramToServiceMsg.extraData.getLong("troopCode", 0L);
    long l5 = paramToServiceMsg.extraData.getLong("troopUin", 0L);
    String str = paramToServiceMsg.extraData.getString("strSearchName");
    long l6 = paramToServiceMsg.extraData.getLong("lGetControl");
    int m = paramToServiceMsg.extraData.getInt("EAddFriendSource");
    long l7 = paramToServiceMsg.extraData.getLong("tinyId");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isNearbyPeopleCard");
    long l8 = paramToServiceMsg.extraData.getLong("likeSource");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("vSeed");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new byte[1];
      localObject1[0] = 0;
    }
    Object localObject3 = paramToServiceMsg.extraData.getByteArray("vSecureSig");
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new byte[1];
      localObject2[0] = 0;
    }
    localObject3 = new ReqLastGameInfo((byte)1, l2);
    Object localObject4 = new UniPacket(true);
    ((UniPacket)localObject4).setEncodeName("utf-8");
    ((UniPacket)localObject4).setFuncName("ReqLastGameInfo");
    ((UniPacket)localObject4).setServantName("QQService.GameSvc");
    ((UniPacket)localObject4).put("ReqLastGameInfo", localObject3);
    localObject4 = ((UniPacket)localObject4).encode();
    localObject3 = null;
    Object localObject5;
    if (!bool)
    {
      localObject3 = new SSummaryCardQueryReq(1, Long.parseLong(paramToServiceMsg.getUin()), l2, "6.5.5", k, 109L);
      localObject5 = new UniPacket(true);
      ((UniPacket)localObject5).setEncodeName("utf-8");
      ((UniPacket)localObject5).setFuncName("query");
      ((UniPacket)localObject5).setServantName("MCardSvc");
      ((UniPacket)localObject5).put("req", localObject3);
      localObject3 = ((UniPacket)localObject5).encode();
    }
    int j = 0;
    try
    {
      i = Integer.parseInt("2880");
      localObject5 = new ArrayList();
      if ((l2 > 0L) || (bool))
      {
        int[] arrayOfInt = new int[8];
        int[] tmp409_407 = arrayOfInt;
        tmp409_407[0] = 1;
        int[] tmp413_409 = tmp409_407;
        tmp413_409[1] = 2;
        int[] tmp417_413 = tmp413_409;
        tmp417_413[2] = 3;
        int[] tmp421_417 = tmp417_413;
        tmp421_417[3] = 4;
        int[] tmp425_421 = tmp421_417;
        tmp425_421[4] = 6;
        int[] tmp430_425 = tmp425_421;
        tmp430_425[5] = 8;
        int[] tmp435_430 = tmp430_425;
        tmp435_430[6] = 9;
        int[] tmp441_435 = tmp435_430;
        tmp441_435[7] = 11;
        tmp441_435;
        j = 0;
        while (j < arrayOfInt.length)
        {
          Object localObject6 = new SummaryCardBusiEntry.comm();
          ((SummaryCardBusiEntry.comm)localObject6).ver.set(1);
          ((SummaryCardBusiEntry.comm)localObject6).seq.set(paramToServiceMsg.getAppSeq());
          ((SummaryCardBusiEntry.comm)localObject6).fromuin.set(l1);
          ((SummaryCardBusiEntry.comm)localObject6).touin.set(l2);
          ((SummaryCardBusiEntry.comm)localObject6).service.set(arrayOfInt[j]);
          ((SummaryCardBusiEntry.comm)localObject6).platform.set(2);
          ((SummaryCardBusiEntry.comm)localObject6).qqver.set("6.5.5.2880");
          ((SummaryCardBusiEntry.comm)localObject6).build.set(i);
          localObject6 = ((SummaryCardBusiEntry.comm)localObject6).toByteArray();
          int n = localObject6.length;
          byte[] arrayOfByte = new byte[n + 9 + 0 + 1];
          arrayOfByte[0] = 40;
          PkgTools.a(arrayOfByte, 1, n);
          PkgTools.a(arrayOfByte, 5, 0);
          PkgTools.a(arrayOfByte, 9, (byte[])localObject6, n);
          n = localObject6.length + 9;
          arrayOfByte[n] = 41;
          ((ArrayList)localObject5).add(arrayOfByte);
          j += 1;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.SummaryCard", 2, localNumberFormatException.toString());
          i = j;
        }
      }
      localObject1 = new ReqSummaryCard(l2, k, l3, b1, l4, l5, (byte[])localObject1, str, tmp409_407, m, (byte[])localObject2, (byte[])localObject4, (byte[])localObject3, null, localNumberFormatException, tmp417_413, tmp425_421);
      localObject2 = new SummaryCard.ReqHead();
      ((SummaryCard.ReqHead)localObject2).iVersion = 2;
      paramUniPacket.setServantName("SummaryCardServantObj");
      paramUniPacket.setFuncName("ReqSummaryCard");
      paramUniPacket.put("ReqHead", localObject2);
      paramUniPacket.put("ReqSummaryCard", localObject1);
      paramToServiceMsg.setTimeout(30000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.ReqSummaryCard");
    }
    return true;
  }
  
  private Object p(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespSearch)a(paramFromServiceMsg.getWupBuffer(), "RespSearch", new RespSearch());
    int i = paramToServiceMsg.extraData.getInt("search_version");
    if (i == 2) {}
    while (i != 3) {
      return paramFromServiceMsg;
    }
    boolean bool = paramToServiceMsg.extraData.getBoolean("search_decode");
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "decodeSearchFriend | needDecode = " + bool);
    }
    if (bool) {
      return a(paramFromServiceMsg.vvRespServices);
    }
    return paramFromServiceMsg.vvRespServices;
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("pttcenter_targetuin", 0L);
    int i = paramToServiceMsg.extraData.getInt("pttcenter_voice_optype");
    short s = paramToServiceMsg.extraData.getShort("pttcenter_shDuration");
    Object localObject = paramToServiceMsg.extraData.getString("pttcenter_filekey");
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "handleVoiceManager() destUin = " + l + ", eOpType = " + i + ", shDuration = " + s + ", filekey = " + (String)localObject);
    }
    localObject = new ReqVoiceManage(i, new VoiceInfo(ProfileCardUtil.a((String)localObject), s, (byte)0, null), l);
    SummaryCard.ReqHead localReqHead = new SummaryCard.ReqHead();
    localReqHead.iVersion = 2;
    paramUniPacket.setServantName("SummaryCardServantObj");
    paramUniPacket.setFuncName("ReqVoiceManage");
    paramUniPacket.put("ReqHead", localReqHead);
    paramUniPacket.put("ReqVoiceManage", localObject);
    paramToServiceMsg.setTimeout(30000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.ReqVoiceManage");
    return true;
  }
  
  private Object q(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespCondSearch)a(paramFromServiceMsg.getWupBuffer(), "RespCondSearch", new RespCondSearch());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.vUserList != null) && (!paramFromServiceMsg.vUserList.isEmpty()))
    {
      int i = 0;
      while (i < paramFromServiceMsg.vUserList.size())
      {
        paramToServiceMsg = (CondFitUser)paramFromServiceMsg.vUserList.get(i);
        if (paramToServiceMsg.vRichSign != null) {
          paramToServiceMsg.richStatus = RichStatus.parseStatus(paramToServiceMsg.vRichSign);
        }
        String str1 = ConditionSearchManager.a(paramToServiceMsg.dwCountry);
        String str2 = ConditionSearchManager.a(paramToServiceMsg.dwProvince);
        String str3 = ConditionSearchManager.a(paramToServiceMsg.dwCity);
        paramToServiceMsg.locDesc = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(58)).b(new String[] { str1, str2, str3, "0" });
        i += 1;
      }
    }
    return paramFromServiceMsg;
  }
  
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = paramToServiceMsg.extraData.getByteArray("devicedata");
    paramToServiceMsg = new LBSAddrProtocol.ReqHeader((short)2, 0, paramToServiceMsg.extraData.getString("account"), 0, 0, "B1_QQ_Neighbor_android", "NzVK_qGE", "");
    localObject = new ReqGetPositionApi((byte[])localObject, 0);
    paramUniPacket.setServantName("LBS.AddressServer.AddressServantObj");
    paramUniPacket.setFuncName("ReqGetPositionApi");
    paramUniPacket.put("ReqHeader", paramToServiceMsg);
    paramUniPacket.put("ReqGetPositionApi", localObject);
    return true;
  }
  
  private Object r(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSetCard)a(paramFromServiceMsg.getWupBuffer(), "RespSetCard", new RespSetCard());
  }
  
  private boolean r(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject3 = null;
    QQService.ReqHead localReqHead = new QQService.ReqHead();
    localReqHead.shVersion = 2;
    localReqHead.iSeq = paramUniPacket.getRequestId();
    localReqHead.lUIN = Long.parseLong(paramToServiceMsg.getUin());
    int i = paramToServiceMsg.extraData.getInt("eSubCmd");
    byte b1 = paramToServiceMsg.extraData.getByte("bIsSingle");
    byte[] arrayOfByte1 = paramToServiceMsg.extraData.getByteArray("vBackground");
    byte[] arrayOfByte2 = paramToServiceMsg.extraData.getByteArray("vReqSetTemplate");
    for (;;)
    {
      try
      {
        Object localObject1 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vTagsID"))).readObject();
        ArrayList localArrayList2;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localArrayList1 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vDelTags"))).readObject();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            ArrayList localArrayList1 = null;
          }
        }
        try
        {
          localArrayList2 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vAddTags"))).readObject();
          localObject1 = new ReqSetCard(localReqHead, i, b1, (ArrayList)localObject1, arrayOfByte1, localArrayList1, localArrayList2, arrayOfByte2);
          paramUniPacket.setServantName("MCardSvc");
          paramUniPacket.setFuncName("ReqSetCard");
          paramUniPacket.put("ReqSetCard", localObject1);
          paramToServiceMsg.setTimeout(10000L);
          paramToServiceMsg.setServiceCmd("MCardSvc.ReqSetCard");
          return true;
        }
        catch (Exception localException3)
        {
          break label252;
        }
        localException1 = localException1;
        localArrayList1 = null;
        localObject1 = null;
      }
      label252:
      localObject2 = localObject3;
    }
  }
  
  private Object s(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (SSummaryCardLableRsp)a(paramFromServiceMsg.getWupBuffer(), "SSummaryCardLableRsp", new SSummaryCardLableRsp());
  }
  
  private boolean s(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SSummaryCardSetLabel localSSummaryCardSetLabel;
    try
    {
      Object localObject = (List)paramToServiceMsg.extraData.getSerializable("labels");
      if (localObject != null)
      {
        localSSummaryCardSetLabel = new SSummaryCardSetLabel();
        localSSummaryCardSetLabel.cmd = 4;
        localSSummaryCardSetLabel.uin = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
        localSSummaryCardSetLabel.version = "6.5.5";
        localSSummaryCardSetLabel.platform = 109L;
        localSSummaryCardSetLabel.labels = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localSSummaryCardSetLabel.labels.add(((Iterator)localObject).next());
        }
      }
      return false;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    paramUniPacket.setServantName("SummaryCard");
    paramUniPacket.setFuncName("SetLabel");
    paramUniPacket.put("SSummaryCardSetLabel", localSSummaryCardSetLabel);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.SetLabel");
    return true;
  }
  
  private Object t(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (SSummaryCardLableRsp)a(paramFromServiceMsg.getWupBuffer(), "SSummaryCardLableRsp", new SSummaryCardLableRsp());
  }
  
  private boolean t(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    try
    {
      SSummaryCardLikeIt localSSummaryCardLikeIt = new SSummaryCardLikeIt();
      localSSummaryCardLikeIt.cmd = 3;
      localSSummaryCardLikeIt.uin = paramToServiceMsg.extraData.getLong("selfUin");
      localSSummaryCardLikeIt.likeuin = paramToServiceMsg.extraData.getLong("destUin");
      localSSummaryCardLikeIt.label = paramToServiceMsg.extraData.getLong("labelId");
      localSSummaryCardLikeIt.platform = 109L;
      localSSummaryCardLikeIt.version = "6.5.5";
      paramUniPacket.setServantName("SummaryCard");
      paramUniPacket.setFuncName("LikeIt");
      paramUniPacket.put("SSummaryCardLikeIt", localSSummaryCardLikeIt);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.LikeIt");
      return true;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return false;
  }
  
  private Object u(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSetCardSwitch)a(paramFromServiceMsg.getWupBuffer(), "RespSetCardSwitch", new RespSetCardSwitch());
  }
  
  private boolean u(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    localObject = new ReqGetCardSwitch((QQService.ReqHead)localObject);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqGetCardSwitch");
    paramUniPacket.put("ReqGetCardSwitch", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqGetCardSwitch");
    return true;
  }
  
  private Object v(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespGetCardSwitch)a(paramFromServiceMsg.getWupBuffer(), "RespGetCardSwitch", new RespGetCardSwitch());
  }
  
  private boolean v(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    boolean bool = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    long l = paramToServiceMsg.extraData.getLong("target_value");
    if (bool) {}
    for (localObject = new ReqSetCardSwitch((QQService.ReqHead)localObject, l, 2L);; localObject = new ReqSetCardSwitch((QQService.ReqHead)localObject, 2L, l))
    {
      paramUniPacket.setServantName("MCardSvc");
      paramUniPacket.setFuncName("ReqSetCardSwitch");
      paramUniPacket.put("ReqSetCardSwitch", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("MCardSvc.ReqSetCardSwitch");
      return true;
    }
  }
  
  private boolean w(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    ReqVote localReqVote = new ReqVote(new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null), l2);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqVote");
    paramUniPacket.put("ReqVote", localReqVote);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqVote");
    return true;
  }
  
  private boolean x(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg.extraData.getLong("selfUin");
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("nextMid");
    int i = paramToServiceMsg.extraData.getInt("pageSize");
    Object localObject = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null);
    UserCntlData localUserCntlData = new UserCntlData(l2, new byte[0]);
    if (i < 54) {}
    for (;;)
    {
      localObject = new ReqGetVoterList((QQService.ReqHead)localObject, localUserCntlData, i);
      paramUniPacket.setServantName("VisitorSvc");
      paramUniPacket.setFuncName("ReqGetVoterList");
      paramUniPacket.put("ReqGetVoterList", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("VisitorSvc.ReqGetVoterList");
      return true;
      i = 30;
    }
  }
  
  private boolean y(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("nextMid");
    int i = paramToServiceMsg.extraData.getInt("pageSize");
    Object localObject = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null);
    UserCntlData localUserCntlData = new UserCntlData(l2, new byte[0]);
    if (i < 54) {}
    for (;;)
    {
      localObject = new ReqGetFavoriteList((QQService.ReqHead)localObject, localUserCntlData, i);
      paramUniPacket.setServantName("VisitorSvc");
      paramUniPacket.setFuncName("ReqGetFavoriteList");
      paramUniPacket.put("ReqGetFavoriteList", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("VisitorSvc.ReqGetFavoriteList");
      return true;
      i = 30;
    }
  }
  
  private boolean z(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("lToUIN");
    int i = paramToServiceMsg.extraData.getInt("iScene");
    ReqPicSafetyCheck localReqPicSafetyCheck = new ReqPicSafetyCheck(new QQService.ReqHead(l, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null), l, i);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqPicSafetyCheck");
    paramUniPacket.put("ReqPicSafetyCheck", localReqPicSafetyCheck);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqPicSafetyCheck");
    return true;
  }
  
  public Object a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespGetFace)a(paramFromServiceMsg.getWupBuffer(), "RespGetFace", new RespGetFace());
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("LBS.AddressService".equals(paramFromServiceMsg.getServiceCmd())) {
      return b(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqSetUserState".equals(paramFromServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.b(this, paramFromServiceMsg, paramToServiceMsg);
    }
    if ("EncounterSvc.ReqGetEntrance".equals(paramFromServiceMsg.getServiceCmd())) {
      return i(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqFaceInfo".equals(paramFromServiceMsg.getServiceCmd())) {
      return j(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqHYMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return l(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqAddFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return (RespAddFace)a(paramFromServiceMsg.getWupBuffer(), "RespAddFace", new RespAddFace());
    }
    if ("MCardSvc.ReqDelFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return (RespDelFace)a(paramFromServiceMsg.getWupBuffer(), "RespDelFace", new RespDelFace());
    }
    if ("MCardSvc.ReqUpdateIntro".equals(paramFromServiceMsg.getServiceCmd())) {
      return m(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return r(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.SetLabel".equals(paramFromServiceMsg.getServiceCmd())) {
      return s(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.LikeIt".equals(paramFromServiceMsg.getServiceCmd())) {
      return t(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqGetCardSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return v(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqSetCardSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return u(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqGetFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return a(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return n(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqVoiceManage".equals(paramFromServiceMsg.getServiceCmd())) {
      return o(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.GetGroupList".equals(paramFromServiceMsg.getServiceCmd())) {
      return f(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.ReqGetAreaList".equals(paramFromServiceMsg.getServiceCmd())) {
      return g(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.ReqGetGroupInArea".equals(paramFromServiceMsg.getServiceCmd())) {
      return h(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqSetStateSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return d(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqGetSwitches".equals(paramFromServiceMsg.getServiceCmd())) {
      return e(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this, paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return p(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return q(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd())) {
      return k(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramFromServiceMsg, paramToServiceMsg, this);
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespVote)a(paramFromServiceMsg.getWupBuffer(), "RespVote", new RespVote());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("VisitorSvc.ReqVote".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramFromServiceMsg, paramToServiceMsg);
    }
    do
    {
      do
      {
        return;
        if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
        {
          b(paramFromServiceMsg, paramToServiceMsg);
          return;
        }
        if ("VisitorSvc.ReqGetFavoriteList".equals(paramFromServiceMsg.getServiceCmd()))
        {
          c(paramFromServiceMsg, paramToServiceMsg);
          return;
        }
      } while ("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd()));
      if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
      {
        NearbyCmdHelper.a(paramFromServiceMsg, paramToServiceMsg);
        return;
      }
    } while (!"NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd()));
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equals("EncounterSvc.ReqGetEntrance")) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("NeighborSvc.ReqSetUserState")) {
      return NearbyCmdHelper.b(this, paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqHYMakeFriendsCard")) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqAddFace")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqDelFace")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqFaceInfo")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqUpdateIntro")) {
      return n(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCard")) {
      return r(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("SummaryCard.SetLabel")) {
      return s(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("SummaryCard.LikeIt")) {
      return t(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqGetCardSwitch")) {
      return u(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCardSwitch")) {
      return v(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqVote")) {
      return w(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetVoterList")) {
      return x(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetFavoriteList")) {
      return y(paramToServiceMsg, paramUniPacket);
    }
    if ("LBS.AddressService".equals(paramToServiceMsg.getServiceCmd())) {
      return q(paramToServiceMsg, paramUniPacket);
    }
    if ("MCardSvc.ReqPicSafetyCheck".equals(paramToServiceMsg.getServiceCmd())) {
      return z(paramToServiceMsg, paramUniPacket);
    }
    if ("MCardSvc.ReqGetFace".equals(paramToServiceMsg.getServiceCmd())) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqSummaryCard".equals(paramToServiceMsg.getServiceCmd())) {
      return o(paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqVoiceManage".equals(paramToServiceMsg.getServiceCmd())) {
      return p(paramToServiceMsg, paramUniPacket);
    }
    if ("VisitorSvc.ReqFavorite".equals(paramToServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(paramToServiceMsg, paramUniPacket);
    }
    if ("NearbyGroup.GetGroupList".equals(paramToServiceMsg.getServiceCmd())) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if ("NearbyGroup.ReqGetAreaList".equals(paramToServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if ("NearbyGroup.ReqGetGroupInArea".equals(paramToServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborSvc.ReqSetStateSwitch".equals(paramToServiceMsg.getServiceCmd())) {
      return k(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborSvc.ReqGetSwitches".equals(paramToServiceMsg.getServiceCmd())) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramToServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this, paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqSearch".equals(paramToServiceMsg.getServiceCmd())) {
      return A(paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqCondSearch".equals(paramToServiceMsg.getServiceCmd())) {
      return B(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborRecommender.ReqGetRecommender".equals(paramToServiceMsg.getServiceCmd())) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    if ("EncounterSvc.ReqGetEncounter".equals(paramToServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramToServiceMsg, paramUniPacket, this);
    }
    return false;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\lbs\LBSService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */