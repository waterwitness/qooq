package com.tencent.mobileqq.app;

import KQQ.GroupMemberFlag;
import KQQ.GroupMngRes;
import KQQ.ProfGroupInfoRes;
import KQQ.RespBatchProcess;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvGVideoLevelInfo.Medal;
import com.tencent.biz.common.util.SubString;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.DealInviteReqBody;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.DealInviteRspBody;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.ReqBody;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.compatible.PbServlet;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.CustomEntry;
import com.tencent.mobileqq.data.TroopMemberCard.GBarInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.org.pb.TroopOrgProtocolManager;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.GroupMsgConfig;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RspBody;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.mobileqq.troopreward.TroopRewardInfo;
import com.tencent.mobileqq.troopshare.TroopShareResp;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.protofile.join_group_link.join_group_link.ReqBody;
import com.tencent.protofile.join_group_link.join_group_link.RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import friendlist.GetMultiTroopInfoResp;
import friendlist.GetTroopAppointRemarkResp;
import friendlist.GetTroopListRespV2;
import friendlist.GetTroopMemberListReq;
import friendlist.GetTroopMemberListResp;
import friendlist.GetTroopRemarkReq;
import friendlist.GetTroopRemarkResp;
import friendlist.ModifyGroupCardResp;
import friendlist.ModifyGroupInfoResp;
import friendlist.stTroopInfoV2;
import friendlist.stTroopMemberInfo;
import friendlist.stTroopNum;
import friendlist.stTroopRemarkInfo;
import friendlist.stUinInfo;
import hw.sso.hw_sso.HwSSOReq;
import hw.sso.hw_sso.HwSSORsp;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import qhk;
import qhl;
import qhq;
import qhr;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.AnonyMsg;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.AnonyStatus;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.ReqBody;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.RspBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.LevelInfo;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.LevelMsg;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.Medal;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.ReqBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.RspBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.UserInfo;
import tencent.im.group.group_member_info.CustomEntry;
import tencent.im.group.group_member_info.GBarInfo;
import tencent.im.group.group_member_info.MemberInfo;
import tencent.im.group.group_member_info.ReqBody;
import tencent.im.group.group_member_info.RspBody;
import tencent.im.group.group_member_info.TeamEntry;
import tencent.im.hw.group_mgr.CardInfo;
import tencent.im.hw.group_mgr.HwModifyCardReq;
import tencent.im.hw.group_mgr.HwQueryCardReq;
import tencent.im.hw.group_mgr.HwQueryCardRsp;
import tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationReq;
import tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationRes;
import tencent.im.kqq.searchgroup.SearchGroup.GroupClusterInfo;
import tencent.im.kqq.searchgroup.SearchGroup.SearchGroupReq;
import tencent.im.kqq.searchgroup.SearchGroup.SearchGroupRes;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMemberListQuery;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMemberListResult;
import tencent.im.oidb.cmd0x406.cmd0x406.ReqBody;
import tencent.im.oidb.cmd0x406.cmd0x406.RspBody;
import tencent.im.oidb.cmd0x5ba.oidb_0x5ba.ReqBody;
import tencent.im.oidb.cmd0x5ba.oidb_0x5ba.RewardItem;
import tencent.im.oidb.cmd0x5ba.oidb_0x5ba.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.LoginSig;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.ReqBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ExtParam;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.LoginSig;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ReqBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.SendFlowerReq;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ThrowFlowerReq;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.LoginSig;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.ReqBody;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ExtParam;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetExtraDataReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetStockReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.LoginSig;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x899.oidb_0x899.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0x89e.oidb_0x89e.ReqBody;
import tencent.im.oidb.cmd0x89e.oidb_0x89e.RspBody;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.KickMemberInfo;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.KickResult;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.ReqBody;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.RspBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.ReqBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.RspBody;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.DelPicReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ModifyOrderReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ReqBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.RspBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.SetDefaultReq;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb.ForbidUin;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb.GroupConcernedInfo;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb.ReqBody;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb.UinInfo;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb.WriteReq;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca.ReqBody;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca.RspBody;
import tencent.im.oidb.cmd0x9ab.oidb_0x9ab.ReqBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.GetSimilarGroupWebInfo;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.ReqBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.RspBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.SimilarGroupWebInfo;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.MemberInfo;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.ReqBody;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.ReqGroupInfo;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.RspBody;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.RspGroupInfo;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.ReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.RspBody;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.AppInfo;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.ReqBody;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.Result;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.RspBody;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04.AppInfo;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04.ReqBody;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04.RspBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.AppInfo;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.ReqBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.RspBody;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.opengroup.jstoken.ReqBody;
import tencent.im.opengroup.jstoken.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppNotifyContent;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppNotifyUser;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x4UpdateApp;
import tencent.im.s2c.msgtype0x210.submsgtype0xab.SubMsgType0xab.MsgBody;

public class TroopHandler
  extends BusinessHandler
{
  public static final int A = 6;
  public static final int B = 7;
  public static final int C = 8;
  public static final int D = 9;
  public static final int H = 10;
  public static final int I = 11;
  public static final int J = 12;
  public static final int K = 13;
  public static final int L = 14;
  public static final int M = 15;
  public static final int N = 16;
  public static final int O = 17;
  public static final int P = 18;
  public static final int Q = 19;
  public static final int R = 20;
  public static final int S = 21;
  public static final int U = 22;
  public static final int V = 23;
  public static final int W = 24;
  public static final int X = 25;
  public static final int Y = 26;
  public static final int Z = 27;
  public static final int a = 0;
  public static final long a = 1L;
  public static final String a = "TroopHandler";
  public static final short a = 500;
  public static final int aA = 54;
  public static final int aB = 55;
  public static final int aC = 56;
  public static final int aD = 57;
  public static final int aE = 58;
  public static final int aF = 59;
  public static final int aG = 60;
  public static final int aH = 61;
  public static final int aI = 62;
  public static final int aJ = 63;
  public static final int aK = 64;
  public static final int aL = 65;
  public static final int aM = 66;
  public static final int aN = 67;
  public static final int aO = 68;
  public static final int aP = 69;
  public static final int aQ = 70;
  public static final int aR = 71;
  public static final int aS = 72;
  public static final int aT = 73;
  public static final int aU = 74;
  public static final int aV = 75;
  public static final int aW = 76;
  public static final int aX = 77;
  public static final int aY = 78;
  public static final int aZ = 79;
  public static final int aa = 28;
  public static final int ab = 29;
  public static final int ac = 30;
  public static final int ad = 31;
  public static final int ae = 32;
  public static final int af = 33;
  public static final int ag = 34;
  public static final int ah = 35;
  public static final int ai = 36;
  public static final int aj = 37;
  public static final int ak = 38;
  public static final int al = 39;
  public static final int am = 40;
  public static final int an = 41;
  public static final int ao = 42;
  public static final int ap = 43;
  public static final int aq = 44;
  public static final int ar = 45;
  public static final int as = 46;
  public static final int at = 47;
  public static final int au = 48;
  public static final int av = 49;
  public static final int aw = 50;
  public static final int ax = 51;
  public static final int ay = 52;
  public static final int az = 53;
  public static final int b = 0;
  public static final long b = 2L;
  public static final String b = "get_troop_member";
  public static final int bA = 2;
  public static final int bB = 3;
  public static final int bC = 4;
  public static final int bD = 5;
  public static final int bE = 6;
  public static final int bF = 7;
  public static final int bG = 8;
  public static final int bH = 9;
  public static final int bI = 1;
  public static final int bJ = 2;
  public static final int bK = 4;
  public static final int bL = 8;
  public static final int bM = 16;
  public static final int bN = 32;
  public static final int bO = 64;
  public static final int bP = 127;
  protected static int bQ = 1;
  protected static int bR = 2;
  public static final int ba = 80;
  public static final int bb = 81;
  public static final int bc = 82;
  public static final int bd = 83;
  public static final int be = 84;
  public static int bf = 0;
  public static int bg = 0;
  public static int bh = 0;
  public static final int bi = 1;
  public static final int bj = 0;
  public static final int bk = 1;
  public static final int bl = 0;
  public static final int bm = -1;
  public static final int bn = 0;
  public static final int bo = 1000;
  public static final int bp = 1001;
  public static final int bq = 1002;
  public static final int br = 1003;
  public static final int bs = 1004;
  public static final int bt = 1005;
  public static final int bu = 1006;
  public static final int bv = 1100;
  public static final int bw = -1001;
  protected static final int bx = 30000;
  public static final int by = 0;
  public static final int bz = 1;
  protected static final int c = 1;
  public static final long c = 21L;
  public static final String c = "command";
  protected static final int d = 2;
  public static final long d = 1104651886L;
  public static final String d = "operation";
  protected static final int e = 3;
  public static final long e = 1101236949L;
  public static final String e = "troop_code";
  protected static final int f = 4;
  public static final long f = 1101484419L;
  public static final String f = "troop_member_uin";
  protected static final int g = 5;
  public static final long g = 1102858908L;
  public static final String g = "new_Member_Msg";
  protected static final int h = 6;
  public static final String h = "pic_url";
  protected static final int i = 7;
  public static final String i = "GroupSvc.JoinGroupLink";
  protected static final int j = 8;
  public static String j;
  public static final int k = 6;
  protected static final String k = "_role";
  public static final int l = 14;
  public static final String l = "has_to_qzone_troop_permission";
  public static final int m = 0;
  public static final String m = "needUpdatePreferences";
  public static final int n = 1;
  public static final String n = "appids";
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 0;
  public static final int r = 0;
  public static final int s = 1;
  public static final int t = -1;
  public static final int u = 0;
  public static final int v = 1;
  public static final int w = 2;
  public static final int x = 3;
  public static final int y = 4;
  public static final int z = 5;
  protected ArrayList a;
  HashMap a;
  protected Set a;
  protected ConcurrentHashMap a;
  protected boolean a;
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  protected ConcurrentHashMap b;
  private HashMap c;
  public ConcurrentHashMap c;
  protected long h = -1L;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    bf = 9101;
    bg = 9102;
    bh = 9103;
    j = "GroupCodeZero";
  }
  
  TroopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private void I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleTroopOpenApiVerifyRsp");
    }
    int i1;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (paramToServiceMsg == null)
      {
        i1 = -1;
        a(71, false, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(i1), Integer.valueOf(64535) });
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler", 2, "handleTroopOpenApiVerifyRsp: req == null || resp == null");
        }
      }
    }
    int i3;
    label400:
    label635:
    do
    {
      String str1;
      String str2;
      String str3;
      int i2;
      do
      {
        for (;;)
        {
          return;
          i1 = paramToServiceMsg.extraData.getInt("seq");
          break;
          i1 = paramToServiceMsg.extraData.getInt("appid");
          str1 = paramToServiceMsg.extraData.getString("openGroupId");
          str2 = paramToServiceMsg.extraData.getString("token");
          str3 = paramToServiceMsg.extraData.getString("url");
          i2 = paramToServiceMsg.extraData.getInt("seq");
          i3 = paramFromServiceMsg.getResultCode();
          if (i3 != 1000) {
            break label635;
          }
          paramFromServiceMsg = new jstoken.RspBody();
          try
          {
            paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if (paramFromServiceMsg.uint32_result.get() == 0) {
              break label400;
            }
            a(71, false, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(paramToServiceMsg.extraData.getInt("seq")), Integer.valueOf(paramFromServiceMsg.uint32_result.get()) });
            if (QLog.isColorLevel())
            {
              QLog.d("TroopHandler", 2, "handleTroopOpenApiVerifyRsp: rspBody.uint32_result.get():" + paramFromServiceMsg.uint32_result.get());
              return;
            }
          }
          catch (Exception paramToServiceMsg)
          {
            a(71, false, null);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("TroopHandler.troop.openapi", 2, "handleTroopOpenApiVerifyRsp, onReceive" + paramToServiceMsg.toString());
      return;
      i3 = paramFromServiceMsg.uint32_frequency.get();
      paramToServiceMsg = paramFromServiceMsg.bytes_err_info.get().toStringUtf8();
      int i4 = paramFromServiceMsg.uint32_token_time_out.get();
      Object localObject = paramFromServiceMsg.rpt_bytes_apilist.get();
      paramObject = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ArrayList)paramObject).add(((ByteStringMicro)((Iterator)localObject).next()).toStringUtf8());
      }
      a(71, true, new Object[] { Integer.valueOf(i1), str1, str2, str3, Integer.valueOf(i3), Integer.valueOf(i4), paramObject, Integer.valueOf(i2), Integer.valueOf(paramFromServiceMsg.uint32_result.get()) });
      QLog.d("TroopHandler", 2, "uint32_frequency:" + i3 + "|erroInfo:" + paramToServiceMsg + "|rpt_bytes_apilist:" + paramFromServiceMsg.rpt_bytes_apilist.get().toString() + "|uint32_result:" + paramFromServiceMsg.uint32_result);
      return;
      a(71, false, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(i2), Integer.valueOf(64535) });
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler", 2, "handleTroopOpenApiVerifyRsp: resp.getResultCode():" + i3);
  }
  
  private void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = -1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleTroopShareLink: start");
    }
    TroopShareResp localTroopShareResp = new TroopShareResp();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(0, false, localTroopShareResp);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handlerBindSubAccount: req == null || resp == null");
      }
      return;
    }
    localTroopShareResp.jdField_a_of_type_Boolean = paramToServiceMsg.extraData.getBoolean("isVerify");
    localTroopShareResp.jdField_a_of_type_JavaLangString = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() == 1000) {
      paramToServiceMsg = new join_group_link.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.error_code.has()) {
          i1 = paramToServiceMsg.error_code.get();
        }
        if (i1 == 0) {
          bool1 = true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        bool1 = false;
      }
      try
      {
        if (paramToServiceMsg.group_code.has()) {
          localTroopShareResp.jdField_a_of_type_JavaLangString = String.valueOf(paramToServiceMsg.group_code.get());
        }
        bool2 = bool1;
        if (paramToServiceMsg.url.has())
        {
          localTroopShareResp.b = paramToServiceMsg.url.get();
          bool2 = bool1;
        }
        a(0, bool2, localTroopShareResp);
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler", 2, "handleTroopShareLink.errCode:" + localTroopShareResp.jdField_a_of_type_Int + "　troopUin:" + localTroopShareResp.jdField_a_of_type_JavaLangString + " isVerify:" + localTroopShareResp.jdField_a_of_type_Boolean + " shareUrl:" + localTroopShareResp.b);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopHandler", 2, "handleTroopShareLink: end");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;) {}
      }
      localTroopShareResp.jdField_a_of_type_Int = i1;
      boolean bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handleTroopShareLink: RspBody parseFrom byte InvalidProtocolBufferMicroException");
      }
      paramToServiceMsg.printStackTrace();
      boolean bool2 = bool1;
      continue;
      localTroopShareResp.jdField_a_of_type_Int = -1;
      bool2 = false;
    }
  }
  
  private void K(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troop_code");
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramToServiceMsg = null;
      }
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
        if (paramToServiceMsg != null) {
          paramToServiceMsg.uint32_result.get();
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;) {}
      }
      try
      {
        paramFromServiceMsg = new oidb_0x88d.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        paramToServiceMsg = paramFromServiceMsg.stzrspgroupinfo.get();
        if (paramToServiceMsg != null) {
          break label309;
        }
        i1 = 0;
        if (i1 > 0)
        {
          paramToServiceMsg = (oidb_0x88d.RspGroupInfo)paramToServiceMsg.get(0);
          if ((paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.uint64_group_code.has()) && (paramToServiceMsg.uint64_group_code.get() == Long.parseLong(str)) && (paramToServiceMsg.stgroupinfo.has()))
          {
            paramObject = (oidb_0x88d.GroupInfo)paramToServiceMsg.stgroupinfo.get();
            if (((oidb_0x88d.GroupInfo)paramObject).uint32_group_admin_max_num.has())
            {
              TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              paramFromServiceMsg = localTroopManager.a(str);
              paramToServiceMsg = paramFromServiceMsg;
              if (paramFromServiceMsg == null)
              {
                paramToServiceMsg = new TroopInfo();
                paramToServiceMsg.troopuin = str;
              }
              paramToServiceMsg.maxAdminNum = ((oidb_0x88d.GroupInfo)paramObject).uint32_group_admin_max_num.get();
              localTroopManager.b(paramToServiceMsg);
              a(26, true, new Object[] { str, Integer.valueOf(((oidb_0x88d.GroupInfo)paramObject).uint32_group_admin_max_num.get()) });
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("TroopHandler", 2, paramToServiceMsg.toString());
        continue;
      }
      a(26, false, null);
      return;
      paramFromServiceMsg.printStackTrace();
      continue;
      label309:
      int i1 = paramToServiceMsg.size();
    }
  }
  
  /* Error */
  private void L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 17
    //   3: iconst_0
    //   4: istore 18
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_1
    //   16: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   19: ldc_w 669
    //   22: invokevirtual 672	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   25: lstore 13
    //   27: aload_1
    //   28: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 674
    //   34: invokevirtual 384	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   37: istore 12
    //   39: iconst_m1
    //   40: istore 7
    //   42: iload 7
    //   44: istore 8
    //   46: aload_2
    //   47: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   50: sipush 1000
    //   53: if_icmpne +782 -> 835
    //   56: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   59: dup
    //   60: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: aload_3
    //   66: checkcast 407	[B
    //   69: checkcast 407	[B
    //   72: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   75: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: astore_2
    //   79: aload_2
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +53 -> 135
    //   85: aload_1
    //   86: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   92: istore 8
    //   94: iload 8
    //   96: istore 7
    //   98: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +34 -> 135
    //   104: ldc 55
    //   106: iconst_2
    //   107: new 422	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 676
    //   117: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload 8
    //   122: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iload 8
    //   133: istore 7
    //   135: iload 7
    //   137: istore 8
    //   139: aload_1
    //   140: ifnull +695 -> 835
    //   143: iload 7
    //   145: istore 8
    //   147: aload_1
    //   148: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   151: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   154: ifeq +681 -> 835
    //   157: iload 7
    //   159: istore 8
    //   161: aload_1
    //   162: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   165: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: ifnull +667 -> 835
    //   171: aload_1
    //   172: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   175: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   178: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   181: astore_1
    //   182: new 599	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   185: dup
    //   186: invokespecial 600	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   189: astore_3
    //   190: aload_3
    //   191: aload_1
    //   192: invokevirtual 601	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   195: pop
    //   196: iload 7
    //   198: ifeq +632 -> 830
    //   201: aload_3
    //   202: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   205: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   208: ifeq +622 -> 830
    //   211: aload_3
    //   212: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   218: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   221: invokestatic 682	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   224: astore_1
    //   225: aconst_null
    //   226: astore_2
    //   227: iload 7
    //   229: istore 8
    //   231: aload_3
    //   232: getfield 605	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   235: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   238: astore_3
    //   239: aload_3
    //   240: ifnonnull +123 -> 363
    //   243: iconst_0
    //   244: istore 10
    //   246: goto +599 -> 845
    //   249: aload_2
    //   250: ifnonnull +189 -> 439
    //   253: iload 11
    //   255: iload 10
    //   257: if_icmpge +182 -> 439
    //   260: iload 7
    //   262: istore 8
    //   264: aload_3
    //   265: iload 11
    //   267: invokeinterface 611 2 0
    //   272: checkcast 613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   275: astore 6
    //   277: iload 7
    //   279: istore 9
    //   281: aload 6
    //   283: ifnull +540 -> 823
    //   286: iload 7
    //   288: istore 8
    //   290: aload 6
    //   292: getfield 617	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   295: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   298: lstore 15
    //   300: lload 15
    //   302: lload 13
    //   304: lcmp
    //   305: ifeq +73 -> 378
    //   308: iload 11
    //   310: iconst_1
    //   311: iadd
    //   312: istore 11
    //   314: goto -65 -> 249
    //   317: astore_2
    //   318: aconst_null
    //   319: astore_1
    //   320: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +33 -> 356
    //   326: ldc_w 684
    //   329: iconst_2
    //   330: new 422	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 686
    //   340: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_2
    //   344: invokevirtual 687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   347: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload_2
    //   357: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   360: goto -279 -> 81
    //   363: iload 7
    //   365: istore 8
    //   367: aload_3
    //   368: invokeinterface 665 1 0
    //   373: istore 10
    //   375: goto +470 -> 845
    //   378: iload 7
    //   380: istore 8
    //   382: aload 6
    //   384: getfield 614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   387: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   390: istore 7
    //   392: iload 7
    //   394: istore 9
    //   396: iload 7
    //   398: ifne +425 -> 823
    //   401: iload 7
    //   403: istore 8
    //   405: iload 7
    //   407: istore 9
    //   409: aload 6
    //   411: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   414: invokevirtual 630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   417: ifeq +406 -> 823
    //   420: iload 7
    //   422: istore 8
    //   424: aload 6
    //   426: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   429: invokevirtual 633	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   432: checkcast 629	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   435: astore_2
    //   436: goto -128 -> 308
    //   439: aload_2
    //   440: ifnull +374 -> 814
    //   443: iconst_1
    //   444: istore 18
    //   446: aload 5
    //   448: astore_3
    //   449: aload_0
    //   450: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   453: bipush 51
    //   455: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   458: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   461: lload 13
    //   463: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   466: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   469: astore 4
    //   471: aload 4
    //   473: ifnonnull +335 -> 808
    //   476: new 652	com/tencent/mobileqq/data/TroopInfo
    //   479: dup
    //   480: invokespecial 653	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   483: astore 5
    //   485: aload 5
    //   487: astore_3
    //   488: aload 5
    //   490: lload 13
    //   492: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   495: putfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   498: aload 5
    //   500: astore_3
    //   501: aload_2
    //   502: getfield 690	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   505: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   508: ifeq +50 -> 558
    //   511: aload_3
    //   512: aload_2
    //   513: getfield 690	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   516: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   519: i2l
    //   520: putfield 693	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   523: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +32 -> 558
    //   529: ldc 55
    //   531: iconst_2
    //   532: new 422	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   539: ldc_w 695
    //   542: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload_3
    //   546: getfield 698	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   549: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   552: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: aload_3
    //   559: astore 4
    //   561: iload 18
    //   563: istore 17
    //   565: aload_2
    //   566: getfield 704	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   569: invokevirtual 543	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   572: ifeq +82 -> 654
    //   575: aload_3
    //   576: new 422	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 706
    //   586: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_2
    //   590: getfield 704	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   593: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   596: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: putfield 709	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   605: aload_3
    //   606: astore 4
    //   608: iload 18
    //   610: istore 17
    //   612: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +39 -> 654
    //   618: ldc 55
    //   620: iconst_2
    //   621: new 422	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 711
    //   631: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload_3
    //   635: getfield 709	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   638: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: iload 18
    //   649: istore 17
    //   651: aload_3
    //   652: astore 4
    //   654: iload 17
    //   656: istore 18
    //   658: aload 4
    //   660: astore 5
    //   662: iload 7
    //   664: istore 8
    //   666: aload_1
    //   667: astore 4
    //   669: aload_0
    //   670: bipush 51
    //   672: iload 18
    //   674: iconst_5
    //   675: anewarray 359	java/lang/Object
    //   678: dup
    //   679: iconst_0
    //   680: lload 13
    //   682: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   685: aastore
    //   686: dup
    //   687: iconst_1
    //   688: iload 12
    //   690: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   693: aastore
    //   694: dup
    //   695: iconst_2
    //   696: aload 5
    //   698: aastore
    //   699: dup
    //   700: iconst_3
    //   701: iload 8
    //   703: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   706: aastore
    //   707: dup
    //   708: iconst_4
    //   709: aload 4
    //   711: aastore
    //   712: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   715: return
    //   716: astore_2
    //   717: aconst_null
    //   718: astore_1
    //   719: aload 4
    //   721: astore_3
    //   722: aload_1
    //   723: astore 4
    //   725: iload 7
    //   727: istore 8
    //   729: aload_3
    //   730: astore 5
    //   732: iload 17
    //   734: istore 18
    //   736: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq -70 -> 669
    //   742: ldc 55
    //   744: iconst_2
    //   745: aload_2
    //   746: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   749: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: aload_1
    //   753: astore 4
    //   755: iload 7
    //   757: istore 8
    //   759: aload_3
    //   760: astore 5
    //   762: iload 17
    //   764: istore 18
    //   766: goto -97 -> 669
    //   769: astore_2
    //   770: iload 8
    //   772: istore 7
    //   774: aload 4
    //   776: astore_3
    //   777: goto -55 -> 722
    //   780: astore_2
    //   781: iconst_1
    //   782: istore 17
    //   784: goto -62 -> 722
    //   787: astore_2
    //   788: aload 4
    //   790: astore_3
    //   791: iconst_1
    //   792: istore 17
    //   794: goto -72 -> 722
    //   797: astore_2
    //   798: iconst_1
    //   799: istore 17
    //   801: goto -79 -> 722
    //   804: astore_2
    //   805: goto -485 -> 320
    //   808: aload 4
    //   810: astore_3
    //   811: goto -310 -> 501
    //   814: aconst_null
    //   815: astore 4
    //   817: iconst_0
    //   818: istore 17
    //   820: goto -166 -> 654
    //   823: iload 9
    //   825: istore 7
    //   827: goto -519 -> 308
    //   830: aconst_null
    //   831: astore_1
    //   832: goto -607 -> 225
    //   835: aconst_null
    //   836: astore 4
    //   838: aload 6
    //   840: astore 5
    //   842: goto -173 -> 669
    //   845: iconst_0
    //   846: istore 11
    //   848: goto -599 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	851	0	this	TroopHandler
    //   0	851	1	paramToServiceMsg	ToServiceMsg
    //   0	851	2	paramFromServiceMsg	FromServiceMsg
    //   0	851	3	paramObject	Object
    //   7	830	4	localObject1	Object
    //   10	831	5	localObject2	Object
    //   13	826	6	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    //   40	786	7	i1	int
    //   44	727	8	i2	int
    //   279	545	9	i3	int
    //   244	130	10	i4	int
    //   253	594	11	i5	int
    //   37	652	12	i6	int
    //   25	656	13	l1	long
    //   298	3	15	l2	long
    //   1	818	17	bool1	boolean
    //   4	761	18	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   56	64	317	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   182	196	716	java/lang/Exception
    //   201	225	716	java/lang/Exception
    //   231	239	769	java/lang/Exception
    //   264	277	769	java/lang/Exception
    //   290	300	769	java/lang/Exception
    //   367	375	769	java/lang/Exception
    //   382	392	769	java/lang/Exception
    //   409	420	769	java/lang/Exception
    //   424	436	769	java/lang/Exception
    //   449	471	780	java/lang/Exception
    //   488	498	780	java/lang/Exception
    //   476	485	787	java/lang/Exception
    //   501	558	797	java/lang/Exception
    //   565	605	797	java/lang/Exception
    //   612	647	797	java/lang/Exception
    //   64	79	804	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.extraData.getString("troop_uin");
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
    paramObject = (ProfGroupInfoRes)paramObject;
    if (paramFromServiceMsg.isSuccess()) {
      if (((ProfGroupInfoRes)paramObject).cResult == 0)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg.getUin()) == null) {
          return;
        }
        paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        paramToServiceMsg = paramFromServiceMsg.a(String.valueOf(((ProfGroupInfoRes)paramObject).uGroupCode));
        if (paramToServiceMsg != null) {
          break label505;
        }
        paramToServiceMsg = new TroopInfo();
        paramToServiceMsg.troopuin = String.valueOf(((ProfGroupInfoRes)paramObject).uGroupCode);
      }
    }
    label437:
    label505:
    for (;;)
    {
      paramToServiceMsg.troopcode = String.valueOf(((ProfGroupInfoRes)paramObject).uGroupUin);
      if ((paramToServiceMsg.troopcode == null) || (paramToServiceMsg.troopcode.equals("0"))) {
        a(bh);
      }
      paramToServiceMsg.troopowneruin = String.valueOf(((ProfGroupInfoRes)paramObject).uGroupOwnerUin);
      paramToServiceMsg.troopname = ((ProfGroupInfoRes)paramObject).sGroupName;
      paramToServiceMsg.troopface = ((ProfGroupInfoRes)paramObject).wGroupFace;
      paramToServiceMsg.troopmemo = ((ProfGroupInfoRes)paramObject).sGroupMemo;
      if (((ProfGroupInfoRes)paramObject).vAdministrator != null)
      {
        paramToServiceMsg.fingertroopmemo = ((ProfGroupInfoRes)paramObject).sFingerGroupMemo;
        localObject = new StringBuffer();
        Iterator localIterator = ((ProfGroupInfoRes)paramObject).vAdministrator.iterator();
        while (localIterator.hasNext())
        {
          GroupMemberFlag localGroupMemberFlag = (GroupMemberFlag)localIterator.next();
          if (localGroupMemberFlag.dwUin != 0L) {
            ((StringBuffer)localObject).append(String.valueOf(localGroupMemberFlag.dwUin) + "|");
          }
        }
        paramToServiceMsg.Administrator = ((StringBuffer)localObject).toString();
      }
      if (((ProfGroupInfoRes)paramObject).cAlbumResult == 33)
      {
        paramToServiceMsg.cAlbumResult = ((ProfGroupInfoRes)paramObject).cAlbumResult;
        paramToServiceMsg.dwTimeStamp = 0L;
        paramToServiceMsg.updateQZonePhotoUrls(null);
        paramToServiceMsg.strLocation = ((ProfGroupInfoRes)paramObject).sGroupLocation;
        if (1 != ((ProfGroupInfoRes)paramObject).cInviteSwitchOpen) {
          break label437;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramToServiceMsg.mMemberInvitingFlag = bool;
        paramToServiceMsg.dwGroupFlagExt = ((ProfGroupInfoRes)paramObject).dwFlagExt;
        paramToServiceMsg.troopAuthenticateInfo = ((ProfGroupInfoRes)paramObject).sAuthGrpInfo;
        paramFromServiceMsg.b(paramToServiceMsg);
        a(8, true, ((ProfGroupInfoRes)paramObject).uGroupCode + "");
        return;
        if (((ProfGroupInfoRes)paramObject).cAlbumResult != 0) {
          break;
        }
        paramToServiceMsg.cAlbumResult = ((ProfGroupInfoRes)paramObject).cAlbumResult;
        if (paramToServiceMsg.dwTimeStamp == ((ProfGroupInfoRes)paramObject).dwTimeStamp) {
          break;
        }
        paramToServiceMsg.dwTimeStamp = ((ProfGroupInfoRes)paramObject).dwTimeStamp;
        paramToServiceMsg.updateQZonePhotoUrls(((ProfGroupInfoRes)paramObject).vsUrl);
        break;
      }
      if (((ProfGroupInfoRes)paramObject).cResult != 5) {
        break;
      }
      paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      paramFromServiceMsg = String.valueOf(((ProfGroupInfoRes)paramObject).uGroupCode);
      if (paramToServiceMsg.a(paramFromServiceMsg) != null) {
        paramToServiceMsg.a(paramFromServiceMsg);
      }
      a(8, false, localObject);
      return;
      a(8, false, localObject);
      return;
    }
  }
  
  /* Error */
  private void N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 584	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +599 -> 603
    //   7: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   10: dup
    //   11: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_3
    //   17: checkcast 407	[B
    //   20: checkcast 407	[B
    //   23: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   26: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: iconst_m1
    //   33: istore 7
    //   35: aload_1
    //   36: ifnull +54 -> 90
    //   39: aload_1
    //   40: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   43: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   46: istore 8
    //   48: iload 8
    //   50: istore 7
    //   52: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +35 -> 90
    //   58: ldc_w 838
    //   61: iconst_2
    //   62: new 422	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 840
    //   72: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 8
    //   77: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: iload 8
    //   88: istore 7
    //   90: iload 7
    //   92: ifne +427 -> 519
    //   95: aload_1
    //   96: ifnull +423 -> 519
    //   99: aload_1
    //   100: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   106: ifeq +413 -> 519
    //   109: aload_1
    //   110: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: ifnull +403 -> 519
    //   119: aload_1
    //   120: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   129: astore_3
    //   130: aload_0
    //   131: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: bipush 51
    //   136: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   139: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   142: astore_2
    //   143: aload_2
    //   144: invokevirtual 843	com/tencent/mobileqq/app/TroopManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   147: astore_1
    //   148: new 845	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody
    //   151: dup
    //   152: invokespecial 846	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody:<init>	()V
    //   155: astore 4
    //   157: aload 4
    //   159: aload_3
    //   160: invokevirtual 847	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   163: pop
    //   164: aload 4
    //   166: getfield 850	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody:rpt_msg_grp_member_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   169: invokevirtual 853	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   172: ifne +419 -> 591
    //   175: aload 4
    //   177: getfield 850	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$RspBody:rpt_msg_grp_member_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   180: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   183: astore_3
    //   184: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +42 -> 229
    //   190: new 422	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   197: ldc_w 855
    //   200: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: astore 4
    //   205: aload_3
    //   206: ifnonnull +358 -> 564
    //   209: iconst_0
    //   210: istore 7
    //   212: ldc_w 838
    //   215: iconst_2
    //   216: aload 4
    //   218: iload 7
    //   220: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_3
    //   230: ifnull +361 -> 591
    //   233: aload_1
    //   234: invokevirtual 859	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   237: aload_3
    //   238: invokeinterface 478 1 0
    //   243: astore_3
    //   244: aload_3
    //   245: invokeinterface 483 1 0
    //   250: ifeq +337 -> 587
    //   253: aload_3
    //   254: invokeinterface 487 1 0
    //   259: checkcast 861	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo
    //   262: astore 4
    //   264: aload 4
    //   266: ifnull -22 -> 244
    //   269: aload 4
    //   271: getfield 862	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   274: invokevirtual 543	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   277: ifeq -33 -> 244
    //   280: aload 4
    //   282: getfield 865	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   285: invokevirtual 853	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   288: ifne -44 -> 244
    //   291: aload 4
    //   293: getfield 865	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   296: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   299: astore 5
    //   301: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +43 -> 347
    //   307: new 422	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   314: ldc_w 867
    //   317: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: astore 6
    //   322: aload 5
    //   324: ifnonnull +251 -> 575
    //   327: iconst_0
    //   328: istore 7
    //   330: ldc_w 838
    //   333: iconst_2
    //   334: aload 6
    //   336: iload 7
    //   338: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload 5
    //   349: ifnull -105 -> 244
    //   352: aload 4
    //   354: getfield 862	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   357: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   360: lstore 9
    //   362: aload_2
    //   363: lload 9
    //   365: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   368: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   371: astore 6
    //   373: aload 6
    //   375: ifnull -131 -> 244
    //   378: aload 6
    //   380: aload 5
    //   382: invokevirtual 871	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap2	(Ljava/util/List;)V
    //   385: aload 6
    //   387: aload 4
    //   389: getfield 874	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   392: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   395: i2b
    //   396: putfield 877	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   399: aload 6
    //   401: aload 4
    //   403: getfield 880	tencent/im/oidb/cmd0x8fd/Oidb_0x8fd$GroupMemberInfo:uint32_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   406: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   409: i2b
    //   410: putfield 883	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   413: aload_2
    //   414: aload 6
    //   416: invokevirtual 662	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   419: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq -178 -> 244
    //   425: ldc_w 838
    //   428: iconst_2
    //   429: new 422	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   436: lload 9
    //   438: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: ldc_w 885
    //   444: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 6
    //   449: getfield 877	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   452: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   455: ldc_w 887
    //   458: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 6
    //   463: getfield 883	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   466: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   469: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: goto -231 -> 244
    //   478: astore_2
    //   479: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +33 -> 515
    //   485: ldc_w 838
    //   488: iconst_2
    //   489: new 422	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 889
    //   499: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_2
    //   503: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   506: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: aload_1
    //   516: invokevirtual 891	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   519: return
    //   520: astore_2
    //   521: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +33 -> 557
    //   527: ldc_w 838
    //   530: iconst_2
    //   531: new 422	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 893
    //   541: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload_2
    //   545: invokevirtual 687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   548: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: aload_2
    //   558: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   561: goto -529 -> 32
    //   564: aload_3
    //   565: invokeinterface 665 1 0
    //   570: istore 7
    //   572: goto -360 -> 212
    //   575: aload 5
    //   577: invokeinterface 665 1 0
    //   582: istore 7
    //   584: goto -254 -> 330
    //   587: aload_1
    //   588: invokevirtual 895	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   591: aload_1
    //   592: invokevirtual 891	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   595: return
    //   596: astore_2
    //   597: aload_1
    //   598: invokevirtual 891	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   601: aload_2
    //   602: athrow
    //   603: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq -87 -> 519
    //   609: ldc_w 838
    //   612: iconst_2
    //   613: new 422	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   620: ldc_w 897
    //   623: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload_2
    //   627: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   630: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	640	0	this	TroopHandler
    //   0	640	1	paramToServiceMsg	ToServiceMsg
    //   0	640	2	paramFromServiceMsg	FromServiceMsg
    //   0	640	3	paramObject	Object
    //   155	247	4	localObject1	Object
    //   299	277	5	localList	List
    //   320	142	6	localObject2	Object
    //   33	550	7	i1	int
    //   46	41	8	i2	int
    //   360	77	9	l1	long
    // Exception table:
    //   from	to	target	type
    //   148	205	478	java/lang/Exception
    //   212	229	478	java/lang/Exception
    //   233	244	478	java/lang/Exception
    //   244	264	478	java/lang/Exception
    //   269	322	478	java/lang/Exception
    //   330	347	478	java/lang/Exception
    //   352	373	478	java/lang/Exception
    //   378	475	478	java/lang/Exception
    //   564	572	478	java/lang/Exception
    //   575	584	478	java/lang/Exception
    //   587	591	478	java/lang/Exception
    //   15	30	520	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   148	205	596	finally
    //   212	229	596	finally
    //   233	244	596	finally
    //   244	264	596	finally
    //   269	322	596	finally
    //   330	347	596	finally
    //   352	373	596	finally
    //   378	475	596	finally
    //   479	515	596	finally
    //   564	572	596	finally
    //   575	584	596	finally
    //   587	591	596	finally
  }
  
  private void O(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handle0x8b4Rsp");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        localObject = localOIDBSSOPkg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopHandler", 2, "handle0x8b4Rsp InvalidProtocolBufferMicroException");
          }
          bool = false;
        }
        b(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
        return;
      }
      if (localObject == null) {
        break;
      }
      if ((!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null)) {
        bool = false;
      }
      switch (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get())
      {
      case 1: 
      case 3: 
      default: 
        return;
      case 0: 
        a(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
        return;
      }
      c(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
      return;
    }
  }
  
  private void P(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    int i2;
    long l1;
    Object[] arrayOfObject;
    do
    {
      return;
      str = paramToServiceMsg.extraData.getString("troop_uin");
      i2 = paramToServiceMsg.extraData.getInt("reqType");
      l1 = paramToServiceMsg.extraData.getLong("timestamp");
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.set_show_external_status", 2, "handleSwitchTroopShowExStatusAfterJoinedTroopRsp, handle response begin==>" + "isSuccess:" + paramFromServiceMsg.isSuccess() + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|troopUin:" + str + "|reqType:" + i2 + "|timestamp:" + l1);
      }
      arrayOfObject = new Object[4];
      arrayOfObject[0] = str;
      arrayOfObject[1] = Integer.valueOf(i2);
      arrayOfObject[2] = Integer.valueOf(paramFromServiceMsg.getResultCode());
      if (i2 == 1) {}
      for (int i1 = 0;; i1 = 1)
      {
        arrayOfObject[3] = Integer.valueOf(i1);
        if (paramFromServiceMsg.getResultCode() == 1000) {
          break;
        }
        a(54, false, arrayOfObject);
        return;
      }
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])paramObject);
        if ((paramObject == null) || (!((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null))
        {
          a(54, false, arrayOfObject);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(54, false, arrayOfObject);
        return;
      }
    } while (!"setShowExternalStatus0x5d6".equals(paramToServiceMsg.extraData.getString("0x5d6_cmd_key")));
    paramToServiceMsg = new oidb_0x5d6.RspBody();
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (i2 == 1)
        {
          paramToServiceMsg.b(str, l1);
          a(54, true, new Object[] { str, Integer.valueOf(i2), Integer.valueOf(paramFromServiceMsg.getResultCode()), Integer.valueOf(i2) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(54, false, arrayOfObject);
        return;
      }
      if (i2 == 0) {
        paramToServiceMsg.d(str);
      }
    }
  }
  
  private void Q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(48, false, null);
      return;
    }
    paramFromServiceMsg = new cmd0x3bb.AnonyMsg();
    cmd0x3bb.RspBody localRspBody;
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localRspBody = (cmd0x3bb.RspBody)paramFromServiceMsg.msg_anony_rsp.get();
      if (localRspBody == null)
      {
        a(48, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(48, false, null);
      return;
    }
    if (localRspBody.int32_ret.get() != 0)
    {
      a(48, false, null);
      return;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    paramObject = new String(localRspBody.str_anony_name.get().toByteArray());
    int i2 = localRspBody.uint32_portrait_index.get();
    int i3 = localRspBody.uint32_bubble_index.get();
    int i4 = localRspBody.uint32_expired_time.get();
    paramToServiceMsg = (cmd0x3bb.AnonyStatus)localRspBody.msg_anony_status.get();
    int i1;
    if (paramToServiceMsg != null)
    {
      i1 = paramToServiceMsg.uint32_forbid_talking.get();
      paramToServiceMsg = new String(paramToServiceMsg.str_err_msg.get().toByteArray());
    }
    for (;;)
    {
      a(48, true, new Object[] { paramFromServiceMsg, paramObject, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i1), paramToServiceMsg });
      return;
      paramToServiceMsg = "";
      i1 = 0;
    }
  }
  
  private void R(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    paramToServiceMsg = new Object[2];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(53, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(53, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(53, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x88d.RspBody();
    int i1;
    try
    {
      ((oidb_0x88d.RspBody)paramObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = ((oidb_0x88d.RspBody)paramObject).stzrspgroupinfo.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label294;
      }
      paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
      i1 = paramFromServiceMsg.uint32_result.get();
      if (i1 == 0)
      {
        a(53, true, new Object[] { str, Integer.valueOf(i1), Integer.valueOf(((oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get()).uint32_group_member_max_num.get()) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(53, false, paramToServiceMsg);
      return;
    }
    a(53, false, new Object[] { str, Integer.valueOf(i1) });
    return;
    label294:
    a(53, false, paramToServiceMsg);
  }
  
  /* Error */
  private void S(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 7
    //   3: aload_2
    //   4: invokevirtual 584	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +635 -> 642
    //   10: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   13: dup
    //   14: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: aload_3
    //   20: checkcast 407	[B
    //   23: checkcast 407	[B
    //   26: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   29: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +659 -> 695
    //   39: aload_1
    //   40: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   43: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   46: istore 8
    //   48: iload 8
    //   50: istore 6
    //   52: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +35 -> 90
    //   58: ldc_w 838
    //   61: iconst_2
    //   62: new 422	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 1003
    //   72: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 8
    //   77: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: iload 8
    //   88: istore 6
    //   90: iload 6
    //   92: ifne +425 -> 517
    //   95: aload_1
    //   96: ifnull +421 -> 517
    //   99: aload_1
    //   100: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   106: ifeq +411 -> 517
    //   109: aload_1
    //   110: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: ifnull +401 -> 517
    //   119: aload_1
    //   120: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   129: astore 4
    //   131: aload_0
    //   132: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   135: bipush 51
    //   137: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   140: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   143: astore_2
    //   144: aload_2
    //   145: invokevirtual 843	com/tencent/mobileqq/app/TroopManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   148: astore_1
    //   149: new 1005	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   152: dup
    //   153: invokespecial 1006	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   156: astore_3
    //   157: aload_3
    //   158: aload 4
    //   160: invokevirtual 1007	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   163: pop
    //   164: aload_1
    //   165: invokevirtual 859	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   168: aload_3
    //   169: getfield 1008	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   172: invokevirtual 543	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   175: ifeq +338 -> 513
    //   178: aload_3
    //   179: getfield 1009	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   182: invokevirtual 853	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   185: ifne +328 -> 513
    //   188: aload_3
    //   189: getfield 1009	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   192: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   195: astore 5
    //   197: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +43 -> 243
    //   203: new 422	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 867
    //   213: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: astore 4
    //   218: aload 5
    //   220: ifnonnull +342 -> 562
    //   223: iconst_0
    //   224: istore 6
    //   226: ldc_w 838
    //   229: iconst_2
    //   230: aload 4
    //   232: iload 6
    //   234: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload 5
    //   245: ifnull +264 -> 509
    //   248: aload_3
    //   249: getfield 1008	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   252: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   255: lstore 9
    //   257: aload_2
    //   258: lload 9
    //   260: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   263: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   266: astore 4
    //   268: aload 4
    //   270: ifnull +239 -> 509
    //   273: aload 4
    //   275: aload 5
    //   277: invokevirtual 1012	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;)V
    //   280: aload_3
    //   281: getfield 1015	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   284: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   287: ifeq +287 -> 574
    //   290: aload_3
    //   291: getfield 1015	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   294: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   297: istore 6
    //   299: aload 4
    //   301: iload 6
    //   303: i2l
    //   304: putfield 1018	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   307: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +31 -> 341
    //   313: ldc_w 838
    //   316: iconst_2
    //   317: new 422	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 1020
    //   327: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 6
    //   332: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_3
    //   342: getfield 1023	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   345: astore 5
    //   347: aload 5
    //   349: ifnull +18 -> 367
    //   352: aload 4
    //   354: aload_3
    //   355: getfield 1023	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   358: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   361: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   364: putfield 1026	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   367: aload_3
    //   368: getfield 1029	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   371: astore 5
    //   373: aload 5
    //   375: ifnull +18 -> 393
    //   378: aload 4
    //   380: aload_3
    //   381: getfield 1029	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   384: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   387: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   390: putfield 1032	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   393: aload_3
    //   394: getfield 1033	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   397: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   400: ifeq +289 -> 689
    //   403: aload 4
    //   405: aload_3
    //   406: getfield 1033	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   409: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   412: i2b
    //   413: putfield 877	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   416: aload 4
    //   418: getfield 877	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   421: istore 6
    //   423: aload_3
    //   424: getfield 1036	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   427: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   430: ifeq +23 -> 453
    //   433: aload 4
    //   435: aload_3
    //   436: getfield 1036	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   439: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   442: i2b
    //   443: putfield 883	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   446: aload 4
    //   448: getfield 883	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   451: istore 7
    //   453: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +47 -> 503
    //   459: ldc_w 838
    //   462: iconst_2
    //   463: new 422	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   470: lload 9
    //   472: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   475: ldc_w 1038
    //   478: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: iload 6
    //   483: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   486: ldc_w 1040
    //   489: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: iload 7
    //   494: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload_2
    //   504: aload 4
    //   506: invokevirtual 662	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   509: aload_1
    //   510: invokevirtual 895	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   513: aload_1
    //   514: invokevirtual 891	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   517: return
    //   518: astore_2
    //   519: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +33 -> 555
    //   525: ldc_w 838
    //   528: iconst_2
    //   529: new 422	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 1042
    //   539: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_2
    //   543: invokevirtual 687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   546: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   555: aload_2
    //   556: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   559: goto -524 -> 35
    //   562: aload 5
    //   564: invokeinterface 665 1 0
    //   569: istore 6
    //   571: goto -345 -> 226
    //   574: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq -236 -> 341
    //   580: ldc_w 838
    //   583: iconst_2
    //   584: ldc_w 1044
    //   587: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: goto -249 -> 341
    //   593: astore_2
    //   594: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +33 -> 630
    //   600: ldc_w 838
    //   603: iconst_2
    //   604: new 422	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 1046
    //   614: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_2
    //   618: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   621: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload_1
    //   631: invokevirtual 891	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   634: return
    //   635: astore_2
    //   636: aload_1
    //   637: invokevirtual 891	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   640: aload_2
    //   641: athrow
    //   642: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq -128 -> 517
    //   648: ldc_w 838
    //   651: iconst_2
    //   652: new 422	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 1048
    //   662: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload_2
    //   666: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   669: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   672: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: return
    //   679: astore 5
    //   681: goto -288 -> 393
    //   684: astore 5
    //   686: goto -319 -> 367
    //   689: iconst_m1
    //   690: istore 6
    //   692: goto -269 -> 423
    //   695: iconst_m1
    //   696: istore 6
    //   698: goto -608 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	this	TroopHandler
    //   0	701	1	paramToServiceMsg	ToServiceMsg
    //   0	701	2	paramFromServiceMsg	FromServiceMsg
    //   0	701	3	paramObject	Object
    //   129	376	4	localObject1	Object
    //   195	368	5	localObject2	Object
    //   679	1	5	localException1	Exception
    //   684	1	5	localException2	Exception
    //   50	647	6	i1	int
    //   1	492	7	i2	int
    //   46	41	8	i3	int
    //   255	216	9	l1	long
    // Exception table:
    //   from	to	target	type
    //   18	33	518	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   149	218	593	java/lang/Exception
    //   226	243	593	java/lang/Exception
    //   248	268	593	java/lang/Exception
    //   273	341	593	java/lang/Exception
    //   341	347	593	java/lang/Exception
    //   367	373	593	java/lang/Exception
    //   393	423	593	java/lang/Exception
    //   423	453	593	java/lang/Exception
    //   453	503	593	java/lang/Exception
    //   503	509	593	java/lang/Exception
    //   509	513	593	java/lang/Exception
    //   562	571	593	java/lang/Exception
    //   574	590	593	java/lang/Exception
    //   149	218	635	finally
    //   226	243	635	finally
    //   248	268	635	finally
    //   273	341	635	finally
    //   341	347	635	finally
    //   352	367	635	finally
    //   367	373	635	finally
    //   378	393	635	finally
    //   393	423	635	finally
    //   423	453	635	finally
    //   453	503	635	finally
    //   503	509	635	finally
    //   509	513	635	finally
    //   562	571	635	finally
    //   574	590	635	finally
    //   594	630	635	finally
    //   378	393	679	java/lang/Exception
    //   352	367	684	java/lang/Exception
  }
  
  private void T(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Boolean.valueOf(false);
    arrayOfObject[2] = "";
    arrayOfObject[3] = "";
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(57, false, arrayOfObject);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(57, false, arrayOfObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(57, false, arrayOfObject);
      return;
    }
    paramObject = new cmd0x8a7.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x8a7.RspBody)paramObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        boolean bool = ((cmd0x8a7.RspBody)paramObject).bool_can_at_all.get();
        if (!((cmd0x8a7.RspBody)paramObject).bytes_prompt_msg_1.has()) {
          break label422;
        }
        paramToServiceMsg = ((cmd0x8a7.RspBody)paramObject).bytes_prompt_msg_1.get().toStringUtf8();
        if (!((cmd0x8a7.RspBody)paramObject).bytes_prompt_msg_2.has()) {
          break label415;
        }
        paramFromServiceMsg = ((cmd0x8a7.RspBody)paramObject).bytes_prompt_msg_2.get().toStringUtf8();
        if (((cmd0x8a7.RspBody)paramObject).uint32_remain_at_all_count_for_group.has())
        {
          i1 = ((cmd0x8a7.RspBody)paramObject).uint32_remain_at_all_count_for_group.get();
          int i2 = 0;
          if (((cmd0x8a7.RspBody)paramObject).uint32_remain_at_all_count_for_uin.has()) {
            i2 = ((cmd0x8a7.RspBody)paramObject).uint32_remain_at_all_count_for_uin.get();
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler.atAll", 2, "handleGetAtAllRemainCountInfo:" + str + ", groupRemainCnt=" + i1 + ", memberRemainCnt=" + i2 + ", beCanAtAll=" + bool + ", tips1=" + paramToServiceMsg + ", tips2=" + paramFromServiceMsg);
          }
          a(57, true, new Object[] { str, Boolean.valueOf(bool), paramToServiceMsg, paramFromServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(57, false, arrayOfObject);
        return;
      }
      int i1 = 0;
      continue;
      label415:
      paramFromServiceMsg = "";
      continue;
      label422:
      paramToServiceMsg = "";
    }
  }
  
  /* Error */
  private void U(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 584	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +723 -> 727
    //   7: aload_3
    //   8: ifnull +719 -> 727
    //   11: iconst_1
    //   12: istore 18
    //   14: iconst_1
    //   15: istore 10
    //   17: iconst_1
    //   18: istore 12
    //   20: iconst_1
    //   21: istore 13
    //   23: iload 18
    //   25: istore 19
    //   27: iload 18
    //   29: ifeq +776 -> 805
    //   32: iload 12
    //   34: istore 11
    //   36: aload_1
    //   37: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   40: ldc_w 524
    //   43: invokevirtual 392	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 1097	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   49: invokevirtual 1100	java/lang/Long:longValue	()J
    //   52: lstore 14
    //   54: iload 12
    //   56: istore 11
    //   58: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +45 -> 106
    //   64: iload 12
    //   66: istore 11
    //   68: ldc 55
    //   70: iconst_2
    //   71: new 422	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 1102
    //   81: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload 18
    //   86: invokevirtual 572	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   89: ldc_w 1104
    //   92: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: lload 14
    //   97: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: iload 12
    //   108: istore 11
    //   110: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   113: dup
    //   114: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   117: astore_2
    //   118: iload 12
    //   120: istore 11
    //   122: aload_2
    //   123: aload_3
    //   124: checkcast 407	[B
    //   127: checkcast 407	[B
    //   130: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   133: pop
    //   134: iload 13
    //   136: istore 10
    //   138: aload_2
    //   139: ifnull +16 -> 155
    //   142: iload 12
    //   144: istore 11
    //   146: aload_2
    //   147: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   150: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   153: istore 10
    //   155: iload 10
    //   157: istore 11
    //   159: aload_2
    //   160: ifnull +638 -> 798
    //   163: iload 10
    //   165: istore 11
    //   167: aload_2
    //   168: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   171: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   174: istore 19
    //   176: iload 10
    //   178: istore 11
    //   180: iload 19
    //   182: ifeq +616 -> 798
    //   185: aload_2
    //   186: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   192: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   195: astore_3
    //   196: new 1005	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   199: dup
    //   200: invokespecial 1006	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   203: astore_2
    //   204: aload_2
    //   205: aload_3
    //   206: invokevirtual 1007	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   209: pop
    //   210: lload 14
    //   212: aload_2
    //   213: getfield 1008	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   216: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   219: lcmp
    //   220: ifne +575 -> 795
    //   223: new 778	java/lang/StringBuffer
    //   226: dup
    //   227: invokespecial 779	java/lang/StringBuffer:<init>	()V
    //   230: astore 4
    //   232: aload_2
    //   233: getfield 1107	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_member_level_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   236: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   239: astore_2
    //   240: new 329	java/util/HashMap
    //   243: dup
    //   244: aload_2
    //   245: invokeinterface 665 1 0
    //   250: invokespecial 1109	java/util/HashMap:<init>	(I)V
    //   253: astore 5
    //   255: aload_2
    //   256: invokeinterface 478 1 0
    //   261: astore 6
    //   263: aload 6
    //   265: invokeinterface 483 1 0
    //   270: ifeq +463 -> 733
    //   273: aload 6
    //   275: invokeinterface 487 1 0
    //   280: checkcast 1111	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo
    //   283: astore 8
    //   285: ldc_w 706
    //   288: astore_3
    //   289: aload 8
    //   291: getfield 1114	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   294: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   297: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   300: astore 7
    //   302: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +25 -> 330
    //   308: aload 4
    //   310: ldc_w 1116
    //   313: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   316: pop
    //   317: aload 4
    //   319: aload 7
    //   321: iconst_0
    //   322: iconst_4
    //   323: invokevirtual 1120	java/lang/String:substring	(II)Ljava/lang/String;
    //   326: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   329: pop
    //   330: aload 8
    //   332: getfield 1123	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   335: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   338: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   341: astore 9
    //   343: aload_3
    //   344: astore_2
    //   345: aload 9
    //   347: ifnull +186 -> 533
    //   350: aload_3
    //   351: astore_2
    //   352: aload 9
    //   354: arraylength
    //   355: ifle +178 -> 533
    //   358: new 548	java/lang/String
    //   361: dup
    //   362: aload 9
    //   364: invokespecial 976	java/lang/String:<init>	([B)V
    //   367: astore_2
    //   368: aload_1
    //   369: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   372: getstatic 1126	com/tencent/mobileqq/utils/ContactUtils:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   375: getstatic 1128	com/tencent/mobileqq/utils/ContactUtils:x	I
    //   378: invokevirtual 1131	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   381: istore 10
    //   383: aload_1
    //   384: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   387: getstatic 1132	com/tencent/mobileqq/utils/ContactUtils:b	Ljava/lang/String;
    //   390: lconst_0
    //   391: invokevirtual 1135	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   394: lstore 16
    //   396: iload 10
    //   398: getstatic 1137	com/tencent/mobileqq/utils/ContactUtils:y	I
    //   401: if_icmpne +73 -> 474
    //   404: aload_0
    //   405: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 1140	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   411: new 422	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   418: lload 14
    //   420: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   423: ldc_w 706
    //   426: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: iconst_1
    //   433: lload 16
    //   435: invokevirtual 1145	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   438: astore_3
    //   439: aload_3
    //   440: ifnull +34 -> 474
    //   443: aload_3
    //   444: instanceof 1147
    //   447: ifeq +27 -> 474
    //   450: aload_3
    //   451: checkcast 1147	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   454: aload_0
    //   455: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   458: aload_2
    //   459: invokestatic 1152	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   462: ldc_w 1153
    //   465: invokevirtual 1156	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   468: invokevirtual 1159	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   471: invokevirtual 1163	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:updateUniteGrayTipMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   474: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +425 -> 902
    //   480: aload 4
    //   482: ldc_w 1165
    //   485: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   488: pop
    //   489: aload 4
    //   491: aload_2
    //   492: invokestatic 1169	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   495: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   498: pop
    //   499: aload 4
    //   501: ldc_w 1171
    //   504: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   507: ldc_w 1173
    //   510: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   513: iload 10
    //   515: invokevirtual 1176	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   518: ldc_w 1178
    //   521: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   524: lload 16
    //   526: invokevirtual 1181	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   529: pop
    //   530: goto +372 -> 902
    //   533: aload 8
    //   535: getfield 1184	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:bytes_nick_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   538: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   541: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   544: astore_3
    //   545: aload_3
    //   546: ifnull +353 -> 899
    //   549: aload_3
    //   550: arraylength
    //   551: ifle +348 -> 899
    //   554: aload_2
    //   555: invokestatic 1189	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   558: ifeq +341 -> 899
    //   561: new 548	java/lang/String
    //   564: dup
    //   565: aload_3
    //   566: invokespecial 976	java/lang/String:<init>	([B)V
    //   569: astore_3
    //   570: aload_3
    //   571: astore_2
    //   572: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +24 -> 599
    //   578: aload 4
    //   580: ldc_w 1191
    //   583: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   586: pop
    //   587: aload 4
    //   589: aload_3
    //   590: invokestatic 1169	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   593: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   596: pop
    //   597: aload_3
    //   598: astore_2
    //   599: aload_2
    //   600: astore_3
    //   601: aload_2
    //   602: invokestatic 1189	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   605: ifeq +21 -> 626
    //   608: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   611: ifeq +294 -> 905
    //   614: aload 4
    //   616: ldc_w 1193
    //   619: invokevirtual 790	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   622: pop
    //   623: goto +282 -> 905
    //   626: aload 5
    //   628: aload 7
    //   630: aload_3
    //   631: invokeinterface 1199 3 0
    //   636: pop
    //   637: goto -374 -> 263
    //   640: astore_1
    //   641: iconst_0
    //   642: istore 11
    //   644: iconst_0
    //   645: istore 19
    //   647: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +13 -> 663
    //   653: ldc 55
    //   655: iconst_2
    //   656: ldc_w 1201
    //   659: aload_1
    //   660: invokestatic 1204	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   663: iload 11
    //   665: istore 12
    //   667: iload 19
    //   669: istore 18
    //   671: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   674: ifeq +39 -> 713
    //   677: ldc 55
    //   679: iconst_2
    //   680: new 422	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   687: ldc_w 1206
    //   690: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokestatic 1211	java/lang/System:currentTimeMillis	()J
    //   696: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   699: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: iload 19
    //   707: istore 18
    //   709: iload 11
    //   711: istore 12
    //   713: aload_0
    //   714: bipush 58
    //   716: iload 18
    //   718: iload 12
    //   720: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   723: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   726: return
    //   727: iconst_0
    //   728: istore 18
    //   730: goto -716 -> 14
    //   733: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   736: ifeq +14 -> 750
    //   739: ldc 55
    //   741: iconst_2
    //   742: aload 4
    //   744: invokevirtual 791	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   747: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   750: aload_0
    //   751: bipush 58
    //   753: iload 18
    //   755: aload 5
    //   757: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   760: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   763: ifeq -37 -> 726
    //   766: ldc 55
    //   768: iconst_2
    //   769: new 422	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   776: ldc_w 1206
    //   779: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: invokestatic 1211	java/lang/System:currentTimeMillis	()J
    //   785: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   788: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   794: return
    //   795: iconst_0
    //   796: istore 11
    //   798: iconst_0
    //   799: istore 19
    //   801: iload 11
    //   803: istore 10
    //   805: iload 10
    //   807: istore 12
    //   809: iload 19
    //   811: istore 18
    //   813: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   816: ifeq -103 -> 713
    //   819: ldc 55
    //   821: iconst_2
    //   822: new 422	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   829: ldc_w 1206
    //   832: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: invokestatic 1211	java/lang/System:currentTimeMillis	()J
    //   838: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   841: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: iload 10
    //   849: istore 12
    //   851: iload 19
    //   853: istore 18
    //   855: goto -142 -> 713
    //   858: astore_1
    //   859: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   862: ifeq +31 -> 893
    //   865: ldc 55
    //   867: iconst_2
    //   868: new 422	java/lang/StringBuilder
    //   871: dup
    //   872: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   875: ldc_w 1206
    //   878: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: invokestatic 1211	java/lang/System:currentTimeMillis	()J
    //   884: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   887: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: aload_1
    //   894: athrow
    //   895: astore_1
    //   896: goto -252 -> 644
    //   899: goto -300 -> 599
    //   902: goto -369 -> 533
    //   905: ldc_w 1213
    //   908: astore_3
    //   909: goto -283 -> 626
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	912	0	this	TroopHandler
    //   0	912	1	paramToServiceMsg	ToServiceMsg
    //   0	912	2	paramFromServiceMsg	FromServiceMsg
    //   0	912	3	paramObject	Object
    //   230	513	4	localStringBuffer	StringBuffer
    //   253	503	5	localHashMap	HashMap
    //   261	13	6	localIterator	Iterator
    //   300	329	7	str	String
    //   283	251	8	localMemberLevelInfo	tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo
    //   341	22	9	arrayOfByte	byte[]
    //   15	833	10	i1	int
    //   34	768	11	i2	int
    //   18	832	12	i3	int
    //   21	114	13	i4	int
    //   52	367	14	l1	long
    //   394	131	16	l2	long
    //   12	842	18	bool1	boolean
    //   25	827	19	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   185	263	640	java/lang/Exception
    //   263	285	640	java/lang/Exception
    //   289	330	640	java/lang/Exception
    //   330	343	640	java/lang/Exception
    //   352	439	640	java/lang/Exception
    //   443	474	640	java/lang/Exception
    //   474	530	640	java/lang/Exception
    //   533	545	640	java/lang/Exception
    //   549	570	640	java/lang/Exception
    //   572	597	640	java/lang/Exception
    //   601	623	640	java/lang/Exception
    //   626	637	640	java/lang/Exception
    //   733	750	640	java/lang/Exception
    //   750	760	640	java/lang/Exception
    //   36	54	858	finally
    //   58	64	858	finally
    //   68	106	858	finally
    //   110	118	858	finally
    //   122	134	858	finally
    //   146	155	858	finally
    //   167	176	858	finally
    //   185	263	858	finally
    //   263	285	858	finally
    //   289	330	858	finally
    //   330	343	858	finally
    //   352	439	858	finally
    //   443	474	858	finally
    //   474	530	858	finally
    //   533	545	858	finally
    //   549	570	858	finally
    //   572	597	858	finally
    //   601	623	858	finally
    //   626	637	858	finally
    //   647	663	858	finally
    //   733	750	858	finally
    //   750	760	858	finally
    //   36	54	895	java/lang/Exception
    //   58	64	895	java/lang/Exception
    //   68	106	895	java/lang/Exception
    //   110	118	895	java/lang/Exception
    //   122	134	895	java/lang/Exception
    //   146	155	895	java/lang/Exception
    //   167	176	895	java/lang/Exception
  }
  
  private void V(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(61, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(61, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(61, false, paramToServiceMsg);
      return;
    }
    paramObject = new cmd0x8ca.RspBody();
    try
    {
      ((cmd0x8ca.RspBody)paramObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      long l1 = ((cmd0x8ca.RspBody)paramObject).opt_uint64_group_code.get();
      ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "" + l1, Integer.valueOf(0));
      a(61, true, paramToServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(61, false, paramToServiceMsg);
    }
  }
  
  private void W(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler.troopgroup_vedio.invite", 2, "receive cmd=OidbSvc.0x6d1, DealInviteRspBody, isSuccess:" + paramFromServiceMsg.isSuccess());
    }
    try
    {
      if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        new cmd0x6d1.DealInviteRspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopHandler", 2, "receive cmd=OidbSvc.0x6d1.DealInviteReqBody, InvalidProtocolBufferMicroException");
    }
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l1 = Long.parseLong(paramString);
        if (l1 >= 10000L) {
          return l1;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private String a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = paramLong + 4294967296L;
    }
    return String.valueOf(l1);
  }
  
  public static String a(String paramString)
  {
    return paramString + "_role";
  }
  
  private List a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return null;
    }
    long l3 = System.currentTimeMillis();
    Object localObject1 = paramString + "_" + paramLong;
    try
    {
      if ((this.jdField_b_of_type_JavaUtilHashMap == null) || (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject1))) {
        return null;
      }
    }
    finally {}
    localObject1 = (ArrayList)this.jdField_b_of_type_JavaUtilHashMap.remove(localObject1);
    if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    localEntityTransaction.a();
    stTroopMemberInfo localstTroopMemberInfo;
    for (;;)
    {
      try
      {
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label1611;
        }
        localstTroopMemberInfo = (stTroopMemberInfo)localIterator.next();
        long l2 = localstTroopMemberInfo.MemberUin;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = localstTroopMemberInfo.MemberUin + 4294967296L;
        }
        String str = String.valueOf(l1);
        localObject1 = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, str }, null, null, null, null);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label1725;
        }
        localObject1 = (TroopMemberInfo)((List)localObject1).get(0);
        if (localObject1 != null) {
          break;
        }
        localObject1 = new TroopMemberInfo();
        ((TroopMemberInfo)localObject1).troopuin = paramString;
        ((TroopMemberInfo)localObject1).memberuin = str;
        ((TroopMemberInfo)localObject1).friendnick = localstTroopMemberInfo.Nick;
        ((TroopMemberInfo)localObject1).pyFirst_friendnick = ChnToSpell.a(((TroopMemberInfo)localObject1).friendnick, 2);
        ((TroopMemberInfo)localObject1).pyAll_friendnick = ChnToSpell.a(((TroopMemberInfo)localObject1).friendnick, 1);
        ((TroopMemberInfo)localObject1).troopnick = localstTroopMemberInfo.sName;
        ((TroopMemberInfo)localObject1).pyFirst_troopnick = ChnToSpell.a(((TroopMemberInfo)localObject1).troopnick, 2);
        ((TroopMemberInfo)localObject1).pyAll_troopnick = ChnToSpell.a(((TroopMemberInfo)localObject1).troopnick, 1);
        ((TroopMemberInfo)localObject1).autoremark = localstTroopMemberInfo.strAutoRemark;
        ((TroopMemberInfo)localObject1).faceid = localstTroopMemberInfo.FaceId;
        ((TroopMemberInfo)localObject1).sex = localstTroopMemberInfo.Gender;
        ((TroopMemberInfo)localObject1).status = localstTroopMemberInfo.Status;
        ((TroopMemberInfo)localObject1).age = localstTroopMemberInfo.Age;
        ((TroopMemberInfo)localObject1).alias = localstTroopMemberInfo.sShowName;
        ((TroopMemberInfo)localObject1).datetime = paramLong;
        ((TroopMemberInfo)localObject1).qqVipInfo = 0;
        ((TroopMemberInfo)localObject1).superQqInfo = 0;
        ((TroopMemberInfo)localObject1).superVipInfo = 0;
        ((TroopMemberInfo)localObject1).level = ((int)localstTroopMemberInfo.dwMemberLevel);
        ((TroopMemberInfo)localObject1).join_time = localstTroopMemberInfo.dwJoinTime;
        ((TroopMemberInfo)localObject1).last_active_time = localstTroopMemberInfo.dwLastSpeakTime;
        ((TroopMemberInfo)localObject1).active_point = localstTroopMemberInfo.dwPoint;
        ((TroopMemberInfo)localObject1).credit_level = localstTroopMemberInfo.dwCreditLevel;
        if (localstTroopMemberInfo.cConcerned == 1)
        {
          bool = true;
          ((TroopMemberInfo)localObject1).isTroopFollowed = bool;
          if (localstTroopMemberInfo.cShielded != 1) {
            break label919;
          }
          bool = true;
          ((TroopMemberInfo)localObject1).mIsShielded = bool;
          if ((localstTroopMemberInfo.dwSpecialTitleExpireTime == -1L) || (localstTroopMemberInfo.dwSpecialTitleExpireTime - NetConnInfoCenter.getServerTime() > 0L))
          {
            ((TroopMemberInfo)localObject1).mUniqueTitle = localstTroopMemberInfo.sSpecialTitle;
            ((TroopMemberInfo)localObject1).mUniqueTitleExpire = ((int)localstTroopMemberInfo.dwSpecialTitleExpireTime);
          }
          localEntityManager.a((Entity)localObject1);
          label596:
          TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString, str);
          Object localObject2 = localTroopMemberCardInfo;
          if (localTroopMemberCardInfo == null)
          {
            localObject2 = new TroopMemberCardInfo();
            ((TroopMemberCardInfo)localObject2).troopuin = paramString;
            ((TroopMemberCardInfo)localObject2).memberuin = str;
          }
          ((TroopMemberCardInfo)localObject2).nick = localstTroopMemberInfo.Nick;
          ((TroopMemberCardInfo)localObject2).name = localstTroopMemberInfo.sName;
          ((TroopMemberCardInfo)localObject2).sex = localstTroopMemberInfo.cGender;
          ((TroopMemberCardInfo)localObject2).tel = localstTroopMemberInfo.sPhone;
          ((TroopMemberCardInfo)localObject2).email = localstTroopMemberInfo.sEmail;
          ((TroopMemberCardInfo)localObject2).memo = localstTroopMemberInfo.sMemo;
          ((TroopMemberCardInfo)localObject2).job = localstTroopMemberInfo.bytes_job;
          DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (TroopMemberCardInfo)localObject2);
          localArrayList.add(localObject1);
          localObject2 = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
          if (localObject2 == null) {
            continue;
          }
          localObject1 = ((ApolloManager)localObject2).b(((TroopMemberInfo)localObject1).memberuin);
          if ((localObject1 == null) || ((((ApolloBaseInfo)localObject1).apolloStatus == localstTroopMemberInfo.cApolloFlag) && (((ApolloBaseInfo)localObject1).apolloServerTS == localstTroopMemberInfo.dwApolloTimestamp))) {
            continue;
          }
          ((ApolloBaseInfo)localObject1).apolloStatus = localstTroopMemberInfo.cApolloFlag;
          ((ApolloBaseInfo)localObject1).apolloServerTS = localstTroopMemberInfo.dwApolloTimestamp;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
          if ((!QLog.isColorLevel()) || (!((ApolloBaseInfo)localObject1).uin.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
            continue;
          }
          QLog.d("TroopHandler", 2, "troop handler apollo status: " + ((ApolloBaseInfo)localObject1).apolloStatus + ", apollo svr ts: " + ((ApolloBaseInfo)localObject1).apolloServerTS);
          continue;
        }
        bool = false;
      }
      finally
      {
        localEntityManager.a();
        localEntityTransaction.b();
      }
      continue;
      label919:
      bool = false;
    }
    if ((localstTroopMemberInfo.Nick == null) || (localstTroopMemberInfo.Nick.length() == 0))
    {
      ((TroopMemberInfo)localObject1).pyFirst_friendnick = "";
      ((TroopMemberInfo)localObject1).pyAll_friendnick = "";
      label960:
      ((TroopMemberInfo)localObject1).friendnick = localstTroopMemberInfo.Nick;
      if ((localstTroopMemberInfo.sName != null) && (localstTroopMemberInfo.sName.length() != 0)) {
        break label1379;
      }
      ((TroopMemberInfo)localObject1).pyFirst_troopnick = "";
      ((TroopMemberInfo)localObject1).pyAll_troopnick = "";
      label1005:
      ((TroopMemberInfo)localObject1).troopnick = localstTroopMemberInfo.sName;
      if ((localstTroopMemberInfo.strAutoRemark != null) && (localstTroopMemberInfo.strAutoRemark.length() != 0)) {
        break label1495;
      }
      ((TroopMemberInfo)localObject1).pyFirst_autoremark = "";
      ((TroopMemberInfo)localObject1).pyAll_autoremark = "";
      label1050:
      ((TroopMemberInfo)localObject1).autoremark = localstTroopMemberInfo.strAutoRemark;
      ((TroopMemberInfo)localObject1).faceid = localstTroopMemberInfo.FaceId;
      ((TroopMemberInfo)localObject1).sex = localstTroopMemberInfo.Gender;
      ((TroopMemberInfo)localObject1).status = localstTroopMemberInfo.Status;
      ((TroopMemberInfo)localObject1).age = localstTroopMemberInfo.Age;
      ((TroopMemberInfo)localObject1).alias = localstTroopMemberInfo.sShowName;
      ((TroopMemberInfo)localObject1).datetime = paramLong;
      ((TroopMemberInfo)localObject1).level = ((int)localstTroopMemberInfo.dwMemberLevel);
      ((TroopMemberInfo)localObject1).join_time = localstTroopMemberInfo.dwJoinTime;
      ((TroopMemberInfo)localObject1).last_active_time = localstTroopMemberInfo.dwLastSpeakTime;
      ((TroopMemberInfo)localObject1).active_point = localstTroopMemberInfo.dwPoint;
      ((TroopMemberInfo)localObject1).credit_level = localstTroopMemberInfo.dwCreditLevel;
      if (localstTroopMemberInfo.cConcerned != 1) {
        break label1731;
      }
      bool = true;
      label1179:
      ((TroopMemberInfo)localObject1).isTroopFollowed = bool;
      if (localstTroopMemberInfo.cShielded != 1) {
        break label1737;
      }
    }
    label1379:
    label1495:
    label1611:
    label1725:
    label1731:
    label1737:
    for (boolean bool = true;; bool = false)
    {
      ((TroopMemberInfo)localObject1).mIsShielded = bool;
      if ((localstTroopMemberInfo.dwSpecialTitleExpireTime == -1L) || (localstTroopMemberInfo.dwSpecialTitleExpireTime - NetConnInfoCenter.getServerTime() > 0L))
      {
        ((TroopMemberInfo)localObject1).mUniqueTitle = localstTroopMemberInfo.sSpecialTitle;
        ((TroopMemberInfo)localObject1).mUniqueTitleExpire = ((int)localstTroopMemberInfo.dwSpecialTitleExpireTime);
      }
      localEntityManager.a((Entity)localObject1);
      break label596;
      if (!localstTroopMemberInfo.Nick.equals(((TroopMemberInfo)localObject1).friendnick))
      {
        ((TroopMemberInfo)localObject1).pyFirst_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 2);
        ((TroopMemberInfo)localObject1).pyAll_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 1);
        break label960;
      }
      if ((((TroopMemberInfo)localObject1).pyFirst_friendnick == null) || (((TroopMemberInfo)localObject1).pyFirst_friendnick.length() == 0)) {
        ((TroopMemberInfo)localObject1).pyFirst_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 2);
      }
      if ((((TroopMemberInfo)localObject1).pyAll_friendnick != null) && (((TroopMemberInfo)localObject1).pyAll_friendnick.length() != 0)) {
        break label960;
      }
      ((TroopMemberInfo)localObject1).pyAll_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 1);
      break label960;
      if (!localstTroopMemberInfo.sName.equals(((TroopMemberInfo)localObject1).troopnick))
      {
        ((TroopMemberInfo)localObject1).pyFirst_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 2);
        ((TroopMemberInfo)localObject1).pyAll_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 1);
        break label1005;
      }
      if ((((TroopMemberInfo)localObject1).pyFirst_troopnick == null) || (((TroopMemberInfo)localObject1).pyFirst_troopnick.length() == 0)) {
        ((TroopMemberInfo)localObject1).pyFirst_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 2);
      }
      if ((((TroopMemberInfo)localObject1).pyAll_troopnick != null) && (((TroopMemberInfo)localObject1).pyAll_troopnick.length() != 0)) {
        break label1005;
      }
      ((TroopMemberInfo)localObject1).pyAll_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 1);
      break label1005;
      if (!localstTroopMemberInfo.strAutoRemark.equals(((TroopMemberInfo)localObject1).autoremark))
      {
        ((TroopMemberInfo)localObject1).pyFirst_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 2);
        ((TroopMemberInfo)localObject1).pyAll_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 1);
        break label1050;
      }
      if ((((TroopMemberInfo)localObject1).pyFirst_autoremark == null) || (((TroopMemberInfo)localObject1).pyFirst_autoremark.length() == 0)) {
        ((TroopMemberInfo)localObject1).pyFirst_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 2);
      }
      if ((((TroopMemberInfo)localObject1).pyAll_autoremark != null) && (((TroopMemberInfo)localObject1).pyAll_autoremark.length() != 0)) {
        break label1050;
      }
      ((TroopMemberInfo)localObject1).pyAll_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 1);
      break label1050;
      ((ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).c(this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      localEntityTransaction.c();
      localEntityManager.a();
      localEntityTransaction.b();
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "processDataInRsp2TroopMemberList, Thread id:" + Thread.currentThread().getId() + ",threadName:" + Thread.currentThread().getName() + ", cost:" + (paramLong - l3));
      }
      return localArrayList;
      localObject1 = null;
      break;
      bool = false;
      break label1179;
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    qhq localqhq = new qhq();
    localqhq.jdField_a_of_type_Long = paramIntent.getLongExtra("TroopUin", 0L);
    localqhq.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isClear", false);
    localqhq.b = paramIntent.getIntExtra("lat", 0);
    localqhq.c = paramIntent.getIntExtra("lon", 0);
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramIntent = new GroupLocation.SetGroupLocationRes();
        paramIntent.mergeFrom(paramArrayOfByte);
        localqhq.jdField_a_of_type_Int = paramIntent.result.get();
        if (localqhq.jdField_a_of_type_Int != 0) {
          break label213;
        }
        localqhq.jdField_a_of_type_JavaLangString = paramIntent.grouplocation.get();
        paramIntent = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (paramIntent != null)
        {
          paramFromServiceMsg = paramIntent.a("" + localqhq.jdField_a_of_type_Long);
          paramFromServiceMsg.strLocation = localqhq.jdField_a_of_type_JavaLangString;
          paramIntent.b(paramFromServiceMsg);
        }
        bool = true;
      }
      catch (Exception paramIntent)
      {
        localqhq.jdField_a_of_type_Int = -1;
        continue;
      }
      a(15, bool, localqhq);
      return;
      localqhq.jdField_a_of_type_Int = paramFromServiceMsg.getResultCode();
      continue;
      label213:
      bool = false;
    }
  }
  
  private void a(oidb_0x496.RspBody paramRspBody)
  {
    paramRspBody = paramRspBody.msg_group_msg_config;
    if ((paramRspBody.has()) && (paramRspBody.bool_uin_enable.has()) && (paramRspBody.uint32_max_aio_msg.has()) && (paramRspBody.uint32_enable_helper.has()) && (paramRspBody.uint32_group_max_number.has()))
    {
      TroopMessageManager localTroopMessageManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localTroopMessageManager.jdField_a_of_type_Boolean = paramRspBody.bool_uin_enable.get();
      localTroopMessageManager.jdField_a_of_type_Int = paramRspBody.uint32_max_aio_msg.get();
      localTroopMessageManager.c = paramRspBody.uint32_group_max_number.get();
      localTroopMessageManager.d = paramRspBody.uint32_enable_helper.get();
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetMultiTroopInfoResp paramGetMultiTroopInfoResp)
  {
    int i2 = 0;
    if (paramGetMultiTroopInfoResp == null)
    {
      a(2, false, null);
      return;
    }
    if (paramFromServiceMsg == null)
    {
      a(2, false, null);
      return;
    }
    if (paramGetMultiTroopInfoResp.result != 0)
    {
      a(2, false, null);
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    int i1 = i2;
    if (paramGetMultiTroopInfoResp.vecTroopInfo != null)
    {
      i1 = i2;
      if (paramGetMultiTroopInfoResp.vecTroopInfo.size() > 0)
      {
        Iterator localIterator = paramGetMultiTroopInfoResp.vecTroopInfo.iterator();
        i1 = 0;
        while (localIterator.hasNext())
        {
          stTroopInfoV2 localstTroopInfoV2 = (stTroopInfoV2)localIterator.next();
          paramGetMultiTroopInfoResp = localTroopManager.a(String.valueOf(localstTroopInfoV2.dwGroupCode));
          paramFromServiceMsg = paramGetMultiTroopInfoResp;
          if (paramGetMultiTroopInfoResp == null)
          {
            paramFromServiceMsg = new TroopInfo();
            paramFromServiceMsg.troopuin = String.valueOf(localstTroopInfoV2.dwGroupCode);
          }
          paramFromServiceMsg.troopcode = String.valueOf(localstTroopInfoV2.dwGroupUin);
          if (paramFromServiceMsg.troopcode != null)
          {
            i2 = i1;
            if (!paramFromServiceMsg.troopcode.equals("0")) {}
          }
          else
          {
            i2 = 1;
          }
          paramFromServiceMsg.troopname = localstTroopInfoV2.strGroupName;
          paramFromServiceMsg.troopmemo = localstTroopInfoV2.strGroupMemo;
          paramFromServiceMsg.fingertroopmemo = localstTroopInfoV2.strFingerMemo;
          paramFromServiceMsg.troopowneruin = Long.toString(localstTroopInfoV2.dwGroupOwnerUin);
          paramFromServiceMsg.dwGroupClassExt = localstTroopInfoV2.dwGroupClassExt;
          paramFromServiceMsg.troopface = ((short)localstTroopInfoV2.wGroupFace);
          paramFromServiceMsg.cGroupOption = ((short)localstTroopInfoV2.cGroupOption);
          paramFromServiceMsg.wMemberNum = localstTroopInfoV2.memberNum;
          paramFromServiceMsg.timeSec = l1;
          paramFromServiceMsg.dwGroupFlagExt = localstTroopInfoV2.dwGroupFlagExt;
          paramFromServiceMsg.dwAuthGroupType = localstTroopInfoV2.dwCertificationType;
          localArrayList.add(paramFromServiceMsg);
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("refreshTroopList", 2, "handleMultiTroopInfo save troop " + paramFromServiceMsg.troopuin + " troopcode:" + paramFromServiceMsg.troopcode);
            i1 = i2;
          }
        }
        localTroopManager.b(localArrayList, l1);
      }
    }
    if (i1 != 0) {
      a(bg);
    }
    a(2, true, localArrayList);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetTroopAppointRemarkResp paramGetTroopAppointRemarkResp)
  {
    if (paramFromServiceMsg == null) {
      a(10, false, null);
    }
    do
    {
      do
      {
        return;
      } while (paramGetTroopAppointRemarkResp == null);
      try
      {
        if (paramGetTroopAppointRemarkResp.result != 0)
        {
          a(10, false, null);
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        a(10, false, null);
        return;
      }
      paramFromServiceMsg = paramGetTroopAppointRemarkResp.vecTroopRemark;
    } while (paramFromServiceMsg == null);
    paramFromServiceMsg = DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramGetTroopAppointRemarkResp.GroupCode), paramFromServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("handlerGetTroopMemberCardInfoList", 2, "bRet = " + paramFromServiceMsg[1]);
    }
    a(10, true, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GroupMngRes paramGroupMngRes)
  {
    Object localObject1 = paramGroupMngRes.vecBody;
    paramToServiceMsg = new TroopInfo();
    try
    {
      localObject1 = ByteBuffer.wrap((byte[])localObject1);
      paramToServiceMsg.troopcode = String.valueOf(((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
      paramToServiceMsg.troopuin = String.valueOf(((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
      paramToServiceMsg.strLocation = paramGroupMngRes.sGroupLocation;
      paramToServiceMsg.troopAuthenticateInfo = paramGroupMngRes.sAuthGrpInfo;
      paramToServiceMsg.joinTroopQuestion = paramGroupMngRes.sJoinQuestion;
      paramToServiceMsg.joinTroopAnswer = paramGroupMngRes.sJoinAnswer;
      while (((ByteBuffer)localObject1).remaining() > 0)
      {
        i1 = ((ByteBuffer)localObject1).get();
        ((ByteBuffer)localObject1).remaining();
        switch (i1 & 0xFF)
        {
        case 6: 
        case 10: 
        case 15: 
        case 17: 
          i1 = ((ByteBuffer)localObject1).get() & 0xFF;
          ((ByteBuffer)localObject1).get(new byte[i1], 0, i1);
        }
      }
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      for (;;)
      {
        int i1;
        localBufferUnderflowException.printStackTrace();
        TroopInfo localTroopInfo = ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramToServiceMsg.troopuin);
        Object localObject2;
        if (localTroopInfo != null)
        {
          localTroopInfo.trooptype = paramToServiceMsg.trooptype;
          localTroopInfo.troopCreateTime = paramToServiceMsg.troopCreateTime;
          localTroopInfo.dwGroupFlag = paramToServiceMsg.dwGroupFlag;
          localTroopInfo.troopowneruin = paramToServiceMsg.troopowneruin;
          localTroopInfo.cGroupOption = paramToServiceMsg.cGroupOption;
          localTroopInfo.dwGroupClassExt = paramToServiceMsg.dwGroupClassExt;
          localTroopInfo.wMemberMax = paramToServiceMsg.wMemberMax;
          localTroopInfo.wSpecialClass = paramToServiceMsg.wSpecialClass;
          localTroopInfo.cGroupLevel = paramToServiceMsg.cGroupLevel;
          localTroopInfo.troopname = paramToServiceMsg.troopname;
          localTroopInfo.troopface = paramToServiceMsg.troopface;
          localTroopInfo.fingertroopmemo = paramToServiceMsg.fingertroopmemo;
          localTroopInfo.wMemberNum = paramToServiceMsg.wMemberNum;
          localTroopInfo.strLocation = paramToServiceMsg.strLocation;
          localTroopInfo.dwGroupFlagExt = paramToServiceMsg.dwGroupFlagExt;
          localTroopInfo.troopAuthenticateInfo = paramToServiceMsg.troopAuthenticateInfo;
          localTroopInfo.joinTroopQuestion = paramToServiceMsg.joinTroopQuestion;
          localTroopInfo.joinTroopAnswer = paramToServiceMsg.joinTroopAnswer;
          localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          ((EntityManager)localObject2).a(localTroopInfo);
          ((EntityManager)localObject2).a();
        }
        for (boolean bool = true;; bool = false)
        {
          a(6, true, new Object[] { Byte.valueOf(paramGroupMngRes.result), paramToServiceMsg, Boolean.valueOf(bool) });
          return;
          localTroopInfo.get();
          paramToServiceMsg.trooptype = (localTroopInfo.get() & 0xFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.troopCreateTime = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.dwGroupFlag = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.troopowneruin = String.valueOf(localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.cGroupOption = ((short)(localTroopInfo.get() & 0xFF));
          break;
          localTroopInfo.get();
          paramToServiceMsg.dwGroupClassExt = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.wMemberMax = (localTroopInfo.getShort() & 0xFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.wSpecialClass = (localTroopInfo.getShort() & 0xFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.cGroupLevel = ((short)(localTroopInfo.get() & 0xFF));
          break;
          localTroopInfo.get();
          paramToServiceMsg.dwGroupFlagExt = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          i1 = localTroopInfo.get() & 0xFF;
          localObject2 = new byte[i1];
          localTroopInfo.get((byte[])localObject2, 0, i1);
          paramToServiceMsg.troopname = PkgTools.c((byte[])localObject2, 0, i1);
          break;
          localTroopInfo.get();
          paramToServiceMsg.troopface = ((short)(localTroopInfo.getShort() & 0xFFFF));
          break;
          i1 = localTroopInfo.get() & 0xFF;
          localObject2 = new byte[i1];
          localTroopInfo.get((byte[])localObject2, 0, i1);
          paramToServiceMsg.fingertroopmemo = PkgTools.c((byte[])localObject2, 0, i1);
          break;
          localTroopInfo.get();
          paramToServiceMsg.wMemberNum = (localTroopInfo.getShort() & 0xFFFF);
          break;
          TroopSystemMsgUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.troopuin, paramToServiceMsg.troopname);
          TroopSystemMsgUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.troopuin, paramToServiceMsg.dwGroupFlagExt);
          TroopSystemMsgUtil.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.troopuin, paramToServiceMsg.joinTroopQuestion);
          TroopSystemMsgUtil.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.troopuin, paramToServiceMsg.joinTroopAnswer);
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i2 = paramToServiceMsg.extraData.getInt("groupreqtype");
    String str1 = paramToServiceMsg.extraData.getString("troop_uin");
    GroupMngRes localGroupMngRes;
    if (paramFromServiceMsg.isSuccess())
    {
      localGroupMngRes = (GroupMngRes)a(paramFromServiceMsg.getWupBuffer(), "GroupMngRes", new GroupMngRes());
      if (i2 == 8)
      {
        localObject1 = new StringBuilder().append("handleInviteMember:").append(str1).append(", res.isSucc=").append(paramFromServiceMsg.isSuccess()).append(", resp.ret=");
        if (localGroupMngRes != null) {
          break label232;
        }
      }
    }
    label232:
    for (int i1 = -1;; i1 = localGroupMngRes.result)
    {
      QLog.d("Q.troopInviteMember", 2, i1);
      switch (i2)
      {
      default: 
        a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(-1) });
        return;
        a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(-1) });
        return;
      }
    }
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      a(paramToServiceMsg, localGroupMngRes);
      return;
    }
    a(6, false, null);
    return;
    Object localObject1 = paramToServiceMsg.extraData.getString("troop_uin");
    Object localObject2 = paramToServiceMsg.extraData.getStringArrayList("frie_uins");
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0) && (str1 != null) && (localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject1 = paramFromServiceMsg.a((String)localObject1);
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str2 = (String)((Iterator)localObject2).next();
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramToServiceMsg.a(TroopMemberInfo.class, "troopuin=? and memberuin=?", new String[] { str1, str2 });
        if (localTroopMemberInfo != null)
        {
          paramToServiceMsg.b(localTroopMemberInfo);
          if (((TroopInfo)localObject1).wMemberNum > 0) {
            ((TroopInfo)localObject1).wMemberNum -= 1;
          }
          if ((((TroopInfo)localObject1).Administrator != null) && (((TroopInfo)localObject1).Administrator.contains(str2))) {
            ((TroopInfo)localObject1).Administrator.replace(str2, "");
          }
        }
      }
      paramFromServiceMsg.b((TroopInfo)localObject1);
      paramToServiceMsg.a();
      a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 1);
      paramToServiceMsg.a(str1);
      DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
      return;
    }
    if ((i2 == 4) || (i2 == 5)) {
      if (paramFromServiceMsg.isSuccess()) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(String.valueOf(AppConstants.aq), 0).edit().putInt(paramToServiceMsg.extraData.getString("Request_uin") + "_answer_joined_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L), i2).commit();
      }
    }
    while ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
      if (((i2 == 6) || (i2 == 7)) && (paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
      {
        i1 = 0;
        if (i2 == 6)
        {
          if (1 != localGroupMngRes.cIsMemInvite) {
            break label1282;
          }
          i1 = 1;
          label1051:
          if (i1 == 0)
          {
            localObject1 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            if (((TroopManager)localObject1).a(paramToServiceMsg.extraData.getString("troop_uin")) == null)
            {
              localObject2 = new TroopInfo();
              ((TroopInfo)localObject2).troopuin = String.valueOf(paramToServiceMsg.extraData.getString("troop_uin"));
              ((TroopManager)localObject1).a((TroopInfo)localObject2);
              ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(((TroopInfo)localObject2).troopuin, (byte)1, ((TroopInfo)localObject2).dwTimeStamp, 0);
            }
          }
        }
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(String.valueOf(AppConstants.aq), 0).edit();
        paramToServiceMsg = paramToServiceMsg.extraData.getString("Request_uin") + "_member_answer_joined_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
        ((SharedPreferences.Editor)localObject1).putInt(paramToServiceMsg, i2);
        if (i2 == 6) {
          if (i1 == 0) {
            break label1288;
          }
        }
        label1282:
        label1288:
        for (i1 = 1;; i1 = 0)
        {
          ((SharedPreferences.Editor)localObject1).putInt(a(paramToServiceMsg), i1);
          ((SharedPreferences.Editor)localObject1).commit();
          break;
          i1 = 0;
          break label1051;
        }
      }
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 1);
      paramToServiceMsg.a(str1);
      DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      a(5, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(5, false, new Object[] { Integer.valueOf(i2), Byte.valueOf(b1) });
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, ModifyGroupCardResp paramModifyGroupCardResp)
  {
    if (paramFromServiceMsg == null)
    {
      a(9, false, null);
      return;
    }
    if (paramModifyGroupCardResp == null)
    {
      a(9, false, null);
      return;
    }
    if (paramToServiceMsg == null)
    {
      a(9, false, null);
      return;
    }
    if (paramModifyGroupCardResp.result != 0)
    {
      a(9, false, null);
      return;
    }
    paramFromServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecUinInfo");
    long l1 = paramToServiceMsg.extraData.getLong("dwGroupCode");
    paramToServiceMsg.extraData.getLong("dwZero");
    paramToServiceMsg.extraData.getLong("dwNewSeq");
    a(9, true, DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), paramFromServiceMsg));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, ModifyGroupInfoResp paramModifyGroupInfoResp)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(11, false, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null });
      return;
    }
    long l1 = paramToServiceMsg.extraData.getLong("dwGroupCode");
    int i1 = paramToServiceMsg.extraData.getInt("modify_troopinfo_flag");
    TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localTroopManager == null) {}
    for (paramFromServiceMsg = null; (paramModifyGroupInfoResp == null) || (l1 != paramModifyGroupInfoResp.dwGroupCode) || (paramModifyGroupInfoResp.result != 0); paramFromServiceMsg = localTroopManager.a(Long.toString(l1)))
    {
      a(11, false, new Object[] { Long.valueOf(l1), Integer.valueOf(i1), paramFromServiceMsg });
      return;
    }
    paramModifyGroupInfoResp = paramFromServiceMsg;
    if (paramFromServiceMsg == null)
    {
      paramModifyGroupInfoResp = new TroopInfo();
      paramModifyGroupInfoResp.troopuin = Long.toString(l1);
    }
    paramModifyGroupInfoResp.troopname = paramToServiceMsg.extraData.getString("strGroupName");
    paramModifyGroupInfoResp.dwGroupClassExt = paramToServiceMsg.extraData.getLong("dwGroupClass");
    paramModifyGroupInfoResp.cGroupOption = ((short)(int)paramToServiceMsg.extraData.getLong("cGroupOption"));
    paramModifyGroupInfoResp.troopmemo = paramToServiceMsg.extraData.getString("strGroupMemo");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("strFingerMemo");
    try
    {
      paramFromServiceMsg = paramToServiceMsg.getBytes("utf-8");
      if (paramFromServiceMsg.length > 120) {}
      for (paramModifyGroupInfoResp.fingertroopmemo = SubString.a(paramFromServiceMsg, 120);; paramModifyGroupInfoResp.fingertroopmemo = paramToServiceMsg)
      {
        paramModifyGroupInfoResp.mRichFingerMemo = paramToServiceMsg;
        localTroopManager.b(paramModifyGroupInfoResp);
        a(11, true, new Object[] { Long.valueOf(l1), Integer.valueOf(i1), paramModifyGroupInfoResp });
        return;
      }
    }
    catch (IOException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramModifyGroupInfoResp.fingertroopmemo = "";
      }
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, GetTroopListRespV2 paramGetTroopListRespV2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +27 -> 28
    //   4: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +13 -> 20
    //   10: ldc_w 1934
    //   13: iconst_2
    //   14: ldc_w 1936
    //   17: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: aload_0
    //   21: iconst_1
    //   22: iconst_0
    //   23: aconst_null
    //   24: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   27: return
    //   28: aload_2
    //   29: getfield 1941	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   32: ifnonnull +65 -> 97
    //   35: aload_2
    //   36: getfield 1944	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   39: ifnonnull +58 -> 97
    //   42: aload_2
    //   43: getfield 1947	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   46: ifnonnull +51 -> 97
    //   49: aload_2
    //   50: getfield 1950	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   53: ifnonnull +44 -> 97
    //   56: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +13 -> 72
    //   62: ldc_w 1934
    //   65: iconst_2
    //   66: ldc_w 1952
    //   69: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_2
    //   73: getfield 1955	friendlist/GetTroopListRespV2:errorCode	S
    //   76: ifne +15 -> 91
    //   79: iconst_1
    //   80: istore 16
    //   82: aload_0
    //   83: iconst_1
    //   84: iload 16
    //   86: aconst_null
    //   87: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   90: return
    //   91: iconst_0
    //   92: istore 16
    //   94: goto -12 -> 82
    //   97: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +136 -> 236
    //   103: new 422	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 1957
    //   113: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: astore_3
    //   117: aload_2
    //   118: getfield 1941	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   121: ifnull +130 -> 251
    //   124: aload_2
    //   125: getfield 1941	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   128: invokevirtual 1626	java/util/ArrayList:size	()I
    //   131: istore 11
    //   133: aload_3
    //   134: iload 11
    //   136: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: ldc_w 1959
    //   142: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: astore_3
    //   146: aload_2
    //   147: getfield 1944	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   150: ifnull +107 -> 257
    //   153: aload_2
    //   154: getfield 1944	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   157: invokevirtual 1626	java/util/ArrayList:size	()I
    //   160: istore 11
    //   162: aload_3
    //   163: iload 11
    //   165: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc_w 1961
    //   171: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: astore_3
    //   175: aload_2
    //   176: getfield 1947	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   179: ifnull +84 -> 263
    //   182: aload_2
    //   183: getfield 1947	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   186: invokevirtual 1626	java/util/ArrayList:size	()I
    //   189: istore 11
    //   191: aload_3
    //   192: iload 11
    //   194: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc_w 1963
    //   200: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: astore_3
    //   204: aload_2
    //   205: getfield 1950	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   208: ifnull +61 -> 269
    //   211: aload_2
    //   212: getfield 1950	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   215: invokevirtual 1626	java/util/ArrayList:size	()I
    //   218: istore 11
    //   220: ldc_w 1934
    //   223: iconst_2
    //   224: aload_3
    //   225: iload 11
    //   227: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_2
    //   237: getfield 1955	friendlist/GetTroopListRespV2:errorCode	S
    //   240: sipush 2001
    //   243: if_icmpne +32 -> 275
    //   246: aload_0
    //   247: invokevirtual 1964	com/tencent/mobileqq/app/TroopHandler:a	()V
    //   250: return
    //   251: iconst_m1
    //   252: istore 11
    //   254: goto -121 -> 133
    //   257: iconst_m1
    //   258: istore 11
    //   260: goto -98 -> 162
    //   263: iconst_m1
    //   264: istore 11
    //   266: goto -75 -> 191
    //   269: iconst_m1
    //   270: istore 11
    //   272: goto -52 -> 220
    //   275: new 334	java/util/ArrayList
    //   278: dup
    //   279: invokespecial 335	java/util/ArrayList:<init>	()V
    //   282: astore 5
    //   284: invokestatic 1211	java/lang/System:currentTimeMillis	()J
    //   287: lstore 14
    //   289: aconst_null
    //   290: astore 4
    //   292: new 334	java/util/ArrayList
    //   295: dup
    //   296: invokespecial 335	java/util/ArrayList:<init>	()V
    //   299: astore 6
    //   301: aload_0
    //   302: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   305: bipush 51
    //   307: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   310: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   313: astore 7
    //   315: aload 7
    //   317: invokevirtual 843	com/tencent/mobileqq/app/TroopManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   320: astore_3
    //   321: aload_3
    //   322: invokevirtual 859	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   325: aload_2
    //   326: getfield 1944	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   329: ifnull +340 -> 669
    //   332: new 422	java/lang/StringBuilder
    //   335: dup
    //   336: ldc_w 1966
    //   339: invokespecial 921	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: astore 4
    //   344: iconst_0
    //   345: istore 11
    //   347: iload 11
    //   349: aload_2
    //   350: getfield 1944	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   353: invokevirtual 1626	java/util/ArrayList:size	()I
    //   356: if_icmpge +276 -> 632
    //   359: aload_2
    //   360: getfield 1944	friendlist/GetTroopListRespV2:vecTroopListDel	Ljava/util/ArrayList;
    //   363: iload 11
    //   365: invokevirtual 1967	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   368: checkcast 1969	friendlist/stTroopNum
    //   371: astore 9
    //   373: aload 9
    //   375: getfield 1970	friendlist/stTroopNum:GroupCode	J
    //   378: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   381: astore 8
    //   383: aload 8
    //   385: invokestatic 1189	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: ifne +14 -> 402
    //   391: ldc_w 740
    //   394: aload 8
    //   396: invokevirtual 743	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   399: ifeq +74 -> 473
    //   402: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +31 -> 436
    //   408: ldc_w 1972
    //   411: iconst_2
    //   412: new 422	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 1974
    //   422: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 8
    //   427: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aconst_null
    //   437: ldc_w 1976
    //   440: ldc_w 1978
    //   443: ldc_w 706
    //   446: ldc_w 1980
    //   449: ldc_w 1982
    //   452: iconst_0
    //   453: iconst_1
    //   454: iconst_0
    //   455: ldc_w 706
    //   458: ldc_w 706
    //   461: ldc_w 706
    //   464: ldc_w 706
    //   467: invokestatic 1987	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   470: goto +1757 -> 2227
    //   473: aload 7
    //   475: aload 8
    //   477: invokevirtual 836	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)V
    //   480: aload 4
    //   482: ldc_w 1989
    //   485: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 9
    //   490: getfield 1992	friendlist/stTroopNum:GroupUin	J
    //   493: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   496: ldc_w 1994
    //   499: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 9
    //   504: getfield 1970	friendlist/stTroopNum:GroupCode	J
    //   507: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload_0
    //   512: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   515: invokevirtual 1997	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   518: astore 9
    //   520: aload 9
    //   522: invokevirtual 2002	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   525: aload 8
    //   527: iconst_1
    //   528: invokevirtual 2007	com/tencent/mobileqq/app/proxy/RecentUserProxy:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/RecentUser;
    //   531: astore 8
    //   533: aload 8
    //   535: ifnull +1692 -> 2227
    //   538: aload 9
    //   540: invokevirtual 2002	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   543: aload 8
    //   545: invokevirtual 2010	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	(Lcom/tencent/mobileqq/data/RecentUser;)V
    //   548: goto +1679 -> 2227
    //   551: astore 4
    //   553: aload_3
    //   554: astore_1
    //   555: aload 4
    //   557: astore_3
    //   558: aload_3
    //   559: invokevirtual 1686	java/lang/Exception:printStackTrace	()V
    //   562: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +14 -> 579
    //   568: ldc_w 2012
    //   571: iconst_2
    //   572: aload_3
    //   573: invokestatic 2016	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   576: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload_1
    //   580: ifnull +7 -> 587
    //   583: aload_1
    //   584: invokevirtual 891	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   587: aload_2
    //   588: getfield 2019	friendlist/GetTroopListRespV2:vecCookies	[B
    //   591: ifnull +1502 -> 2093
    //   594: aload_2
    //   595: getfield 2019	friendlist/GetTroopListRespV2:vecCookies	[B
    //   598: arraylength
    //   599: ifle +1494 -> 2093
    //   602: aload_0
    //   603: aload_2
    //   604: getfield 2019	friendlist/GetTroopListRespV2:vecCookies	[B
    //   607: invokevirtual 2021	com/tencent/mobileqq/app/TroopHandler:b	([B)V
    //   610: aload_0
    //   611: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   614: bipush 65
    //   616: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   619: checkcast 2023	com/tencent/mobileqq/app/lbs/LbsInfoMgr
    //   622: astore_1
    //   623: aload_1
    //   624: ifnull -597 -> 27
    //   627: aload_1
    //   628: invokevirtual 2024	com/tencent/mobileqq/app/lbs/LbsInfoMgr:a	()V
    //   631: return
    //   632: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +34 -> 669
    //   638: ldc_w 1972
    //   641: iconst_2
    //   642: new 422	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 2026
    //   652: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload 4
    //   657: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: aload_2
    //   670: getfield 1941	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   673: ifnull +1548 -> 2221
    //   676: new 334	java/util/ArrayList
    //   679: dup
    //   680: invokespecial 335	java/util/ArrayList:<init>	()V
    //   683: astore 8
    //   685: iconst_0
    //   686: istore 12
    //   688: iconst_0
    //   689: istore 11
    //   691: iload 12
    //   693: aload_2
    //   694: getfield 1941	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   697: invokevirtual 1626	java/util/ArrayList:size	()I
    //   700: if_icmpge +841 -> 1541
    //   703: aload_2
    //   704: getfield 1941	friendlist/GetTroopListRespV2:vecTroopList	Ljava/util/ArrayList;
    //   707: iload 12
    //   709: invokevirtual 1967	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   712: checkcast 1969	friendlist/stTroopNum
    //   715: astore 9
    //   717: aload 7
    //   719: aload 9
    //   721: getfield 1970	friendlist/stTroopNum:GroupCode	J
    //   724: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   727: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   730: astore 4
    //   732: aload 4
    //   734: ifnonnull +1517 -> 2251
    //   737: iconst_1
    //   738: istore 13
    //   740: iload 13
    //   742: ifeq +25 -> 767
    //   745: new 652	com/tencent/mobileqq/data/TroopInfo
    //   748: dup
    //   749: invokespecial 653	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   752: astore 4
    //   754: aload 4
    //   756: aload 9
    //   758: getfield 1970	friendlist/stTroopNum:GroupCode	J
    //   761: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   764: putfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   767: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   770: ifeq +62 -> 832
    //   773: aload 9
    //   775: getfield 2029	friendlist/stTroopNum:dwAppPrivilegeFlag	J
    //   778: ldc2_w 2030
    //   781: land
    //   782: lconst_0
    //   783: lcmp
    //   784: ifeq +48 -> 832
    //   787: ldc_w 2033
    //   790: iconst_2
    //   791: new 422	java/lang/StringBuilder
    //   794: dup
    //   795: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   798: ldc_w 2035
    //   801: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload 9
    //   806: getfield 2036	friendlist/stTroopNum:strGroupName	Ljava/lang/String;
    //   809: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: ldc_w 2038
    //   815: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload 9
    //   820: getfield 1970	friendlist/stTroopNum:GroupCode	J
    //   823: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   826: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   832: aload 4
    //   834: aload_1
    //   835: invokevirtual 726	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   838: putfield 2039	com/tencent/mobileqq/data/TroopInfo:uin	Ljava/lang/String;
    //   841: aload 4
    //   843: aload 9
    //   845: getfield 1992	friendlist/stTroopNum:GroupUin	J
    //   848: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   851: putfield 738	com/tencent/mobileqq/data/TroopInfo:troopcode	Ljava/lang/String;
    //   854: aload 4
    //   856: aload 9
    //   858: getfield 2042	friendlist/stTroopNum:dwGroupInfoSeq	J
    //   861: putfield 2043	com/tencent/mobileqq/data/TroopInfo:dwGroupInfoSeq	J
    //   864: aload 4
    //   866: aload 9
    //   868: getfield 2036	friendlist/stTroopNum:strGroupName	Ljava/lang/String;
    //   871: putfield 755	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   874: aload 4
    //   876: aload 9
    //   878: getfield 2044	friendlist/stTroopNum:strGroupMemo	Ljava/lang/String;
    //   881: putfield 767	com/tencent/mobileqq/data/TroopInfo:troopmemo	Ljava/lang/String;
    //   884: aload 4
    //   886: aload 9
    //   888: getfield 2045	friendlist/stTroopNum:dwGroupFlagExt	J
    //   891: putfield 823	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt	J
    //   894: aload 4
    //   896: aload 9
    //   898: getfield 2046	friendlist/stTroopNum:dwCertificationType	J
    //   901: putfield 1672	com/tencent/mobileqq/data/TroopInfo:dwAuthGroupType	J
    //   904: aload 4
    //   906: lload 14
    //   908: putfield 1665	com/tencent/mobileqq/data/TroopInfo:timeSec	J
    //   911: aload 4
    //   913: aload 9
    //   915: getfield 2049	friendlist/stTroopNum:dwGroupRankSeq	J
    //   918: putfield 1018	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   921: aload 4
    //   923: aload 9
    //   925: getfield 2052	friendlist/stTroopNum:dwShutupTimestamp	J
    //   928: putfield 2055	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp	J
    //   931: aload 4
    //   933: aload 9
    //   935: getfield 2058	friendlist/stTroopNum:dwMyShutupTimestamp	J
    //   938: putfield 2061	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp_me	J
    //   941: aload 4
    //   943: aload 9
    //   945: getfield 2064	friendlist/stTroopNum:dwCmdUinUinFlag	J
    //   948: putfield 2065	com/tencent/mobileqq/data/TroopInfo:dwCmdUinUinFlag	J
    //   951: aload 4
    //   953: aload 9
    //   955: getfield 2068	friendlist/stTroopNum:dwAdditionalFlag	J
    //   958: putfield 2069	com/tencent/mobileqq/data/TroopInfo:dwAdditionalFlag	J
    //   961: aload 4
    //   963: aload 9
    //   965: getfield 2072	friendlist/stTroopNum:dwGroupTypeFlag	J
    //   968: l2i
    //   969: putfield 2075	com/tencent/mobileqq/data/TroopInfo:troopTypeExt	I
    //   972: aload 4
    //   974: aload 9
    //   976: getfield 2076	friendlist/stTroopNum:dwGroupClassExt	J
    //   979: putfield 693	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   982: aload 4
    //   984: getfield 2069	com/tencent/mobileqq/data/TroopInfo:dwAdditionalFlag	J
    //   987: lconst_1
    //   988: land
    //   989: lconst_1
    //   990: lcmp
    //   991: ifne +26 -> 1017
    //   994: aload 4
    //   996: getfield 709	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   999: invokestatic 1189	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1002: ifeq +15 -> 1017
    //   1005: aload 4
    //   1007: aload_0
    //   1008: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1011: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1014: putfield 709	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   1017: aload 4
    //   1019: aload 9
    //   1021: getfield 2029	friendlist/stTroopNum:dwAppPrivilegeFlag	J
    //   1024: putfield 2077	com/tencent/mobileqq/data/TroopInfo:dwAppPrivilegeFlag	J
    //   1027: aload 4
    //   1029: aload 9
    //   1031: getfield 2029	friendlist/stTroopNum:dwAppPrivilegeFlag	J
    //   1034: putfield 2080	com/tencent/mobileqq/data/TroopInfo:troopPrivilegeFlag	J
    //   1037: aload 4
    //   1039: aload 9
    //   1041: getfield 2083	friendlist/stTroopNum:dwSubscriptionUin	J
    //   1044: putfield 2086	com/tencent/mobileqq/data/TroopInfo:associatePubAccount	J
    //   1047: aload 4
    //   1049: getfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1052: ifnull +360 -> 1412
    //   1055: aload 4
    //   1057: getfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1060: ldc_w 787
    //   1063: invokevirtual 2089	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1066: ifeq +17 -> 1083
    //   1069: aload 4
    //   1071: aload 4
    //   1073: getfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1076: iconst_1
    //   1077: invokevirtual 2091	java/lang/String:substring	(I)Ljava/lang/String;
    //   1080: putfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1083: aload 4
    //   1085: getfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1088: ldc_w 787
    //   1091: invokevirtual 2094	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1094: ifeq +27 -> 1121
    //   1097: aload 4
    //   1099: aload 4
    //   1101: getfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1104: iconst_0
    //   1105: aload 4
    //   1107: getfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1110: invokevirtual 1240	java/lang/String:length	()I
    //   1113: iconst_1
    //   1114: isub
    //   1115: invokevirtual 1120	java/lang/String:substring	(II)Ljava/lang/String;
    //   1118: putfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1121: aload 4
    //   1123: getfield 2065	com/tencent/mobileqq/data/TroopInfo:dwCmdUinUinFlag	J
    //   1126: lconst_1
    //   1127: land
    //   1128: lconst_1
    //   1129: lcmp
    //   1130: ifne +304 -> 1434
    //   1133: aload 4
    //   1135: getfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1138: aload_0
    //   1139: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1142: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1145: invokevirtual 1824	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1148: ifne +42 -> 1190
    //   1151: aload 4
    //   1153: new 422	java/lang/StringBuilder
    //   1156: dup
    //   1157: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   1160: aload 4
    //   1162: getfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1165: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: ldc_w 787
    //   1171: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: aload_0
    //   1175: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1178: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1181: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1187: putfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1190: aload 4
    //   1192: aload 9
    //   1194: getfield 2097	friendlist/stTroopNum:dwMemberNum	J
    //   1197: l2i
    //   1198: putfield 1662	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   1201: aload 4
    //   1203: aload 9
    //   1205: getfield 2100	friendlist/stTroopNum:dwMemberNumSeq	J
    //   1208: putfield 2103	com/tencent/mobileqq/data/TroopInfo:mMemberNumSeq	J
    //   1211: aload 4
    //   1213: aload 9
    //   1215: getfield 2106	friendlist/stTroopNum:dwMemberCardSeq	J
    //   1218: putfield 2109	com/tencent/mobileqq/data/TroopInfo:mMemberCardSeq	J
    //   1221: aload 4
    //   1223: aload 9
    //   1225: getfield 2112	friendlist/stTroopNum:dwGroupSecType	J
    //   1228: putfield 2115	com/tencent/mobileqq/data/TroopInfo:troopCreditLevel	J
    //   1231: aload 4
    //   1233: aload 9
    //   1235: getfield 2118	friendlist/stTroopNum:dwGroupSecTypeInfo	J
    //   1238: putfield 2121	com/tencent/mobileqq/data/TroopInfo:troopCreditLevelInfo	J
    //   1241: aload 8
    //   1243: aload 4
    //   1245: invokeinterface 1473 2 0
    //   1250: pop
    //   1251: aload_0
    //   1252: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1255: aload 4
    //   1257: getfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1260: invokevirtual 2123	com/tencent/mobileqq/app/QQAppInterface:c	(Ljava/lang/String;)V
    //   1263: aload 4
    //   1265: getfield 738	com/tencent/mobileqq/data/TroopInfo:troopcode	Ljava/lang/String;
    //   1268: ifnull +968 -> 2236
    //   1271: aload 4
    //   1273: getfield 738	com/tencent/mobileqq/data/TroopInfo:troopcode	Ljava/lang/String;
    //   1276: ldc_w 740
    //   1279: invokevirtual 743	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1282: ifeq +242 -> 1524
    //   1285: goto +951 -> 2236
    //   1288: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1291: ifeq +951 -> 2242
    //   1294: ldc_w 1934
    //   1297: iconst_2
    //   1298: new 422	java/lang/StringBuilder
    //   1301: dup
    //   1302: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   1305: ldc_w 2125
    //   1308: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: aload 9
    //   1313: getfield 1992	friendlist/stTroopNum:GroupUin	J
    //   1316: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1319: ldc_w 2127
    //   1322: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: aload 9
    //   1327: getfield 1970	friendlist/stTroopNum:GroupCode	J
    //   1330: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1333: ldc_w 2129
    //   1336: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: aload 4
    //   1341: getfield 2115	com/tencent/mobileqq/data/TroopInfo:troopCreditLevel	J
    //   1344: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1347: ldc_w 2131
    //   1350: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: aload 4
    //   1355: getfield 2121	com/tencent/mobileqq/data/TroopInfo:troopCreditLevelInfo	J
    //   1358: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1361: ldc_w 2133
    //   1364: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: aload 4
    //   1369: getfield 1662	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   1372: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1375: ldc_w 2135
    //   1378: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: aload 4
    //   1383: getfield 2103	com/tencent/mobileqq/data/TroopInfo:mMemberNumSeq	J
    //   1386: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1389: ldc_w 2137
    //   1392: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: aload 4
    //   1397: getfield 2109	com/tencent/mobileqq/data/TroopInfo:mMemberCardSeq	J
    //   1400: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1403: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1409: goto +833 -> 2242
    //   1412: aload 4
    //   1414: ldc_w 706
    //   1417: putfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1420: goto -299 -> 1121
    //   1423: astore_1
    //   1424: aload_3
    //   1425: ifnull +7 -> 1432
    //   1428: aload_3
    //   1429: invokevirtual 891	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1432: aload_1
    //   1433: athrow
    //   1434: aload 4
    //   1436: aload 4
    //   1438: getfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1441: new 422	java/lang/StringBuilder
    //   1444: dup
    //   1445: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   1448: aload_0
    //   1449: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1452: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1455: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: ldc_w 787
    //   1461: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: ldc_w 706
    //   1470: invokevirtual 1828	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1473: new 422	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   1480: ldc_w 787
    //   1483: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: aload_0
    //   1487: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1490: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1493: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: ldc_w 706
    //   1502: invokevirtual 1828	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1505: aload_0
    //   1506: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1509: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1512: ldc_w 706
    //   1515: invokevirtual 1828	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1518: putfield 794	com/tencent/mobileqq/data/TroopInfo:Administrator	Ljava/lang/String;
    //   1521: goto -331 -> 1190
    //   1524: aload 5
    //   1526: aload 9
    //   1528: getfield 1970	friendlist/stTroopNum:GroupCode	J
    //   1531: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1534: invokevirtual 491	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1537: pop
    //   1538: goto -250 -> 1288
    //   1541: aload 7
    //   1543: aload 8
    //   1545: invokevirtual 2139	com/tencent/mobileqq/app/TroopManager:a	(Ljava/util/List;)V
    //   1548: aload_2
    //   1549: getfield 1947	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   1552: ifnull +300 -> 1852
    //   1555: new 334	java/util/ArrayList
    //   1558: dup
    //   1559: invokespecial 335	java/util/ArrayList:<init>	()V
    //   1562: astore 8
    //   1564: aload_2
    //   1565: getfield 1947	friendlist/GetTroopListRespV2:vecTroopRank	Ljava/util/ArrayList;
    //   1568: invokevirtual 780	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1571: astore 9
    //   1573: aload 9
    //   1575: invokeinterface 483 1 0
    //   1580: ifeq +265 -> 1845
    //   1583: aload 9
    //   1585: invokeinterface 487 1 0
    //   1590: checkcast 2141	friendlist/stGroupRankInfo
    //   1593: astore 10
    //   1595: aload 7
    //   1597: aload 10
    //   1599: getfield 2142	friendlist/stGroupRankInfo:dwGroupCode	J
    //   1602: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1605: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1608: astore 5
    //   1610: aload 5
    //   1612: astore 4
    //   1614: aload 5
    //   1616: ifnonnull +25 -> 1641
    //   1619: new 652	com/tencent/mobileqq/data/TroopInfo
    //   1622: dup
    //   1623: invokespecial 653	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   1626: astore 4
    //   1628: aload 4
    //   1630: aload 10
    //   1632: getfield 2142	friendlist/stGroupRankInfo:dwGroupCode	J
    //   1635: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1638: putfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1641: aload 4
    //   1643: aload_1
    //   1644: invokevirtual 726	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1647: putfield 2039	com/tencent/mobileqq/data/TroopInfo:uin	Ljava/lang/String;
    //   1650: aload 4
    //   1652: aload 10
    //   1654: getfield 2143	friendlist/stGroupRankInfo:cGroupRankSysFlag	B
    //   1657: putfield 877	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1660: aload 4
    //   1662: aload 10
    //   1664: getfield 2144	friendlist/stGroupRankInfo:cGroupRankUserFlag	B
    //   1667: putfield 883	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1670: aload 4
    //   1672: aload 10
    //   1674: getfield 2145	friendlist/stGroupRankInfo:dwGroupRankSeq	J
    //   1677: putfield 1018	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   1680: aload 4
    //   1682: aload 10
    //   1684: getfield 2148	friendlist/stGroupRankInfo:vecRankMap	Ljava/util/ArrayList;
    //   1687: invokevirtual 2151	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap	(Ljava/util/List;)V
    //   1690: aload 4
    //   1692: aload 10
    //   1694: getfield 2154	friendlist/stGroupRankInfo:strOwnerName	Ljava/lang/String;
    //   1697: putfield 1026	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   1700: aload 4
    //   1702: aload 10
    //   1704: getfield 2157	friendlist/stGroupRankInfo:strAdminName	Ljava/lang/String;
    //   1707: putfield 1032	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   1710: aload 4
    //   1712: aload 10
    //   1714: getfield 2160	friendlist/stGroupRankInfo:dwOfficeMode	J
    //   1717: putfield 2161	com/tencent/mobileqq/data/TroopInfo:dwOfficeMode	J
    //   1720: aload 8
    //   1722: aload 4
    //   1724: invokeinterface 1473 2 0
    //   1729: pop
    //   1730: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1733: ifeq -160 -> 1573
    //   1736: new 422	java/lang/StringBuilder
    //   1739: dup
    //   1740: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   1743: ldc_w 2163
    //   1746: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: aload 10
    //   1751: getfield 2142	friendlist/stGroupRankInfo:dwGroupCode	J
    //   1754: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1757: ldc_w 2165
    //   1760: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: aload 10
    //   1765: getfield 2143	friendlist/stGroupRankInfo:cGroupRankSysFlag	B
    //   1768: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1771: ldc_w 2167
    //   1774: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: aload 10
    //   1779: getfield 2144	friendlist/stGroupRankInfo:cGroupRankUserFlag	B
    //   1782: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1785: ldc_w 2169
    //   1788: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1791: aload 10
    //   1793: getfield 2145	friendlist/stGroupRankInfo:dwGroupRankSeq	J
    //   1796: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1799: ldc_w 2171
    //   1802: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: astore 4
    //   1807: aload 10
    //   1809: getfield 2148	friendlist/stGroupRankInfo:vecRankMap	Ljava/util/ArrayList;
    //   1812: ifnull +445 -> 2257
    //   1815: aload 10
    //   1817: getfield 2148	friendlist/stGroupRankInfo:vecRankMap	Ljava/util/ArrayList;
    //   1820: invokevirtual 1626	java/util/ArrayList:size	()I
    //   1823: istore 12
    //   1825: ldc_w 838
    //   1828: iconst_2
    //   1829: aload 4
    //   1831: iload 12
    //   1833: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1836: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1839: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1842: goto -269 -> 1573
    //   1845: aload 7
    //   1847: aload 8
    //   1849: invokevirtual 2139	com/tencent/mobileqq/app/TroopManager:a	(Ljava/util/List;)V
    //   1852: aload_2
    //   1853: getfield 1950	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   1856: ifnull +210 -> 2066
    //   1859: aload_0
    //   1860: getfield 2172	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_Boolean	Z
    //   1863: ifeq +203 -> 2066
    //   1866: new 329	java/util/HashMap
    //   1869: dup
    //   1870: invokespecial 330	java/util/HashMap:<init>	()V
    //   1873: astore_1
    //   1874: new 329	java/util/HashMap
    //   1877: dup
    //   1878: invokespecial 330	java/util/HashMap:<init>	()V
    //   1881: astore 4
    //   1883: aload_2
    //   1884: getfield 1950	friendlist/GetTroopListRespV2:vecFavGroup	Ljava/util/ArrayList;
    //   1887: invokevirtual 780	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1890: astore 5
    //   1892: aload 5
    //   1894: invokeinterface 483 1 0
    //   1899: ifeq +137 -> 2036
    //   1902: aload 5
    //   1904: invokeinterface 487 1 0
    //   1909: checkcast 2174	friendlist/stFavoriteGroup
    //   1912: astore 8
    //   1914: aload 8
    //   1916: getfield 2177	friendlist/stFavoriteGroup:dwSnsFlag	J
    //   1919: lstore 14
    //   1921: lconst_1
    //   1922: lload 14
    //   1924: land
    //   1925: lconst_1
    //   1926: lcmp
    //   1927: ifne +33 -> 1960
    //   1930: aload_1
    //   1931: new 619	java/lang/Long
    //   1934: dup
    //   1935: aload 8
    //   1937: getfield 2178	friendlist/stFavoriteGroup:dwGroupCode	J
    //   1940: invokespecial 2181	java/lang/Long:<init>	(J)V
    //   1943: invokevirtual 2182	java/lang/Long:toString	()Ljava/lang/String;
    //   1946: aload 8
    //   1948: getfield 2185	friendlist/stFavoriteGroup:dwTimestamp	J
    //   1951: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1954: invokeinterface 1199 3 0
    //   1959: pop
    //   1960: ldc2_w 162
    //   1963: lload 14
    //   1965: land
    //   1966: ldc2_w 162
    //   1969: lcmp
    //   1970: ifne +34 -> 2004
    //   1973: aload 4
    //   1975: new 619	java/lang/Long
    //   1978: dup
    //   1979: aload 8
    //   1981: getfield 2178	friendlist/stFavoriteGroup:dwGroupCode	J
    //   1984: invokespecial 2181	java/lang/Long:<init>	(J)V
    //   1987: invokevirtual 2182	java/lang/Long:toString	()Ljava/lang/String;
    //   1990: aload 8
    //   1992: getfield 2188	friendlist/stFavoriteGroup:dwOpenTimestamp	J
    //   1995: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1998: invokeinterface 1199 3 0
    //   2003: pop
    //   2004: lload 14
    //   2006: ldc2_w 2189
    //   2009: land
    //   2010: ldc2_w 2189
    //   2013: lcmp
    //   2014: ifne -122 -> 1892
    //   2017: aload 6
    //   2019: aload 8
    //   2021: getfield 2178	friendlist/stFavoriteGroup:dwGroupCode	J
    //   2024: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2027: invokeinterface 1473 2 0
    //   2032: pop
    //   2033: goto -141 -> 1892
    //   2036: aload 7
    //   2038: aload_1
    //   2039: invokevirtual 2193	com/tencent/mobileqq/app/TroopManager:a	(Ljava/util/Map;)V
    //   2042: aload 7
    //   2044: aload 4
    //   2046: invokevirtual 2195	com/tencent/mobileqq/app/TroopManager:b	(Ljava/util/Map;)V
    //   2049: aload_0
    //   2050: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2053: bipush 36
    //   2055: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2058: checkcast 2197	com/tencent/mobileqq/model/TroopInfoManager
    //   2061: aload 6
    //   2063: invokevirtual 2198	com/tencent/mobileqq/model/TroopInfoManager:a	(Ljava/util/List;)V
    //   2066: aload_3
    //   2067: invokevirtual 895	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   2070: iload 11
    //   2072: ifeq +10 -> 2082
    //   2075: aload_0
    //   2076: getstatic 300	com/tencent/mobileqq/app/TroopHandler:bf	I
    //   2079: invokevirtual 746	com/tencent/mobileqq/app/TroopHandler:a	(I)V
    //   2082: aload_3
    //   2083: ifnull -1496 -> 587
    //   2086: aload_3
    //   2087: invokevirtual 891	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   2090: goto -1503 -> 587
    //   2093: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2096: ifeq +12 -> 2108
    //   2099: ldc 55
    //   2101: iconst_2
    //   2102: ldc_w 2200
    //   2105: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2108: aload_0
    //   2109: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2112: bipush 51
    //   2114: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2117: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   2120: astore_1
    //   2121: aload_1
    //   2122: invokevirtual 2201	com/tencent/mobileqq/app/TroopManager:b	()V
    //   2125: aload_1
    //   2126: invokevirtual 2202	com/tencent/mobileqq/app/TroopManager:c	()V
    //   2129: aload_0
    //   2130: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2133: invokevirtual 1776	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2136: new 422	java/lang/StringBuilder
    //   2139: dup
    //   2140: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   2143: aload_0
    //   2144: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2147: invokevirtual 2205	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2150: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2153: ldc_w 2207
    //   2156: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2159: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2162: iconst_0
    //   2163: invokevirtual 1846	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2166: invokeinterface 1852 1 0
    //   2171: ldc_w 2209
    //   2174: iconst_0
    //   2175: invokeinterface 2213 3 0
    //   2180: invokeinterface 1869 1 0
    //   2185: pop
    //   2186: aload_0
    //   2187: iconst_1
    //   2188: iconst_1
    //   2189: aconst_null
    //   2190: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   2193: aload_0
    //   2194: invokevirtual 2214	com/tencent/mobileqq/app/TroopHandler:b	()V
    //   2197: goto -1587 -> 610
    //   2200: astore_1
    //   2201: aconst_null
    //   2202: astore_3
    //   2203: goto -779 -> 1424
    //   2206: astore_2
    //   2207: aload_1
    //   2208: astore_3
    //   2209: aload_2
    //   2210: astore_1
    //   2211: goto -787 -> 1424
    //   2214: astore_3
    //   2215: aload 4
    //   2217: astore_1
    //   2218: goto -1660 -> 558
    //   2221: iconst_0
    //   2222: istore 11
    //   2224: goto -676 -> 1548
    //   2227: iload 11
    //   2229: iconst_1
    //   2230: iadd
    //   2231: istore 11
    //   2233: goto -1886 -> 347
    //   2236: iconst_1
    //   2237: istore 11
    //   2239: goto -951 -> 1288
    //   2242: iload 12
    //   2244: iconst_1
    //   2245: iadd
    //   2246: istore 12
    //   2248: goto -1557 -> 691
    //   2251: iconst_0
    //   2252: istore 13
    //   2254: goto -1514 -> 740
    //   2257: iconst_m1
    //   2258: istore 12
    //   2260: goto -435 -> 1825
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2263	0	this	TroopHandler
    //   0	2263	1	paramToServiceMsg	ToServiceMsg
    //   0	2263	2	paramGetTroopListRespV2	GetTroopListRespV2
    //   116	2093	3	localObject1	Object
    //   2214	1	3	localException1	Exception
    //   290	191	4	localStringBuilder	StringBuilder
    //   551	105	4	localException2	Exception
    //   730	1486	4	localObject2	Object
    //   282	1621	5	localObject3	Object
    //   299	1763	6	localArrayList	ArrayList
    //   313	1730	7	localTroopManager	TroopManager
    //   381	1639	8	localObject4	Object
    //   371	1213	9	localObject5	Object
    //   1593	223	10	localstGroupRankInfo	friendlist.stGroupRankInfo
    //   131	2107	11	i1	int
    //   686	1573	12	i2	int
    //   738	1515	13	i3	int
    //   287	1718	14	l1	long
    //   80	13	16	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   321	344	551	java/lang/Exception
    //   347	402	551	java/lang/Exception
    //   402	436	551	java/lang/Exception
    //   436	470	551	java/lang/Exception
    //   473	533	551	java/lang/Exception
    //   538	548	551	java/lang/Exception
    //   632	669	551	java/lang/Exception
    //   669	685	551	java/lang/Exception
    //   691	732	551	java/lang/Exception
    //   745	767	551	java/lang/Exception
    //   767	832	551	java/lang/Exception
    //   832	1017	551	java/lang/Exception
    //   1017	1083	551	java/lang/Exception
    //   1083	1121	551	java/lang/Exception
    //   1121	1190	551	java/lang/Exception
    //   1190	1285	551	java/lang/Exception
    //   1288	1409	551	java/lang/Exception
    //   1412	1420	551	java/lang/Exception
    //   1434	1521	551	java/lang/Exception
    //   1524	1538	551	java/lang/Exception
    //   1541	1548	551	java/lang/Exception
    //   1548	1573	551	java/lang/Exception
    //   1573	1610	551	java/lang/Exception
    //   1619	1641	551	java/lang/Exception
    //   1641	1825	551	java/lang/Exception
    //   1825	1842	551	java/lang/Exception
    //   1845	1852	551	java/lang/Exception
    //   1852	1892	551	java/lang/Exception
    //   1892	1921	551	java/lang/Exception
    //   1930	1960	551	java/lang/Exception
    //   1973	2004	551	java/lang/Exception
    //   2017	2033	551	java/lang/Exception
    //   2036	2066	551	java/lang/Exception
    //   2066	2070	551	java/lang/Exception
    //   2075	2082	551	java/lang/Exception
    //   321	344	1423	finally
    //   347	402	1423	finally
    //   402	436	1423	finally
    //   436	470	1423	finally
    //   473	533	1423	finally
    //   538	548	1423	finally
    //   632	669	1423	finally
    //   669	685	1423	finally
    //   691	732	1423	finally
    //   745	767	1423	finally
    //   767	832	1423	finally
    //   832	1017	1423	finally
    //   1017	1083	1423	finally
    //   1083	1121	1423	finally
    //   1121	1190	1423	finally
    //   1190	1285	1423	finally
    //   1288	1409	1423	finally
    //   1412	1420	1423	finally
    //   1434	1521	1423	finally
    //   1524	1538	1423	finally
    //   1541	1548	1423	finally
    //   1548	1573	1423	finally
    //   1573	1610	1423	finally
    //   1619	1641	1423	finally
    //   1641	1825	1423	finally
    //   1825	1842	1423	finally
    //   1845	1852	1423	finally
    //   1852	1892	1423	finally
    //   1892	1921	1423	finally
    //   1930	1960	1423	finally
    //   1973	2004	1423	finally
    //   2017	2033	1423	finally
    //   2036	2066	1423	finally
    //   2066	2070	1423	finally
    //   2075	2082	1423	finally
    //   301	321	2200	finally
    //   558	579	2206	finally
    //   301	321	2214	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopMemberListResp paramGetTroopMemberListResp)
  {
    String str1 = a(paramToServiceMsg.extraData.getLong("troop_uin"));
    long l1 = paramToServiceMsg.extraData.getLong("troop_time");
    boolean bool = paramToServiceMsg.extraData.getBoolean("needCallBackCache");
    int i1 = paramToServiceMsg.extraData.getInt("reqType", 0);
    String str2 = str1 + "_" + i1;
    long l2;
    Object localObject2;
    Object localObject1;
    if (paramGetTroopMemberListResp != null)
    {
      if (paramGetTroopMemberListResp.NextGetTime != 0L) {
        this.jdField_c_of_type_JavaUtilHashMap.put(str2, Long.valueOf(paramGetTroopMemberListResp.NextGetTime));
      }
      l2 = paramGetTroopMemberListResp.GroupUin;
      paramGetTroopMemberListResp.GroupUin = paramGetTroopMemberListResp.GroupCode;
      paramGetTroopMemberListResp.GroupCode = l2;
      TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject2 = localTroopManager.a(str1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopuin = str1;
      }
      ((TroopInfo)localObject1).dwOfficeMode = paramGetTroopMemberListResp.office_mode;
      localTroopManager.b((TroopInfo)localObject1);
      if (paramGetTroopMemberListResp.result != 0) {
        break label741;
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaUtilHashMap == null) {
          this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
        }
        localObject2 = str1 + "_" + l1;
        if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject2))
        {
          ((ArrayList)this.jdField_b_of_type_JavaUtilHashMap.get(localObject2)).addAll(paramGetTroopMemberListResp.vecTroopMember);
          paramGetTroopMemberListResp.vecTroopMember.size();
          if (paramGetTroopMemberListResp.NextUin == 0L) {
            break label611;
          }
          paramToServiceMsg.extraData.putBoolean("force_refresh", true);
          paramToServiceMsg.extraData.putLong("nextuin", paramGetTroopMemberListResp.NextUin);
          paramToServiceMsg.extraData.putLong("troop_time", l1);
          paramToServiceMsg.extraData.putLong("reqType", i1);
          localObject1 = new UniPacket(true);
          ((UniPacket)localObject1).setEncodeName("utf-8");
          if (a(paramToServiceMsg, (UniPacket)localObject1))
          {
            paramToServiceMsg.setServiceName("mobileqq.service");
            paramToServiceMsg.setRequestSsoSeq(((UniPacket)localObject1).getRequestId());
            paramToServiceMsg.putWupBuffer(((UniPacket)localObject1).encode());
            a(paramToServiceMsg);
            if (QLog.isColorLevel()) {
              QLog.d("get_troop_member", 2, "FriendListHandler.handleGetTroopMemberList, request the next page data");
            }
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder().append("FriendListHandler.handleGetTroopMemberList, resp.result: ").append(paramGetTroopMemberListResp.result).append(" member count: ").append(paramGetTroopMemberListResp.vecTroopMember.size()).append("|reqType:").append(i1).append("|nextReqTime:");
              if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(str2)) {
                break label767;
              }
              l1 = ((Long)this.jdField_c_of_type_JavaUtilHashMap.get(str2)).longValue();
              QLog.d("get_troop_member.troop.req_troop_mem_list_optimize", 2, l1 + "|troopUin:" + str1);
            }
          }
        }
        else
        {
          this.jdField_b_of_type_JavaUtilHashMap.put(localObject2, paramGetTroopMemberListResp.vecTroopMember);
          continue;
        }
        if (!bool) {
          break label589;
        }
      }
      finally {}
      paramToServiceMsg = new Object[2];
      paramToServiceMsg[0] = str1;
      paramToServiceMsg[1] = a(str1, l1);
      for (;;)
      {
        a(4, false, paramToServiceMsg);
        break;
        label589:
        a(str1, l1);
        paramToServiceMsg = new Object[1];
        paramToServiceMsg[0] = str1;
      }
      label611:
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "netWorkCost:" + (l2 - l1));
      }
      if (bool)
      {
        a(4, true, new Object[] { str1, a(str1, l1) });
        ThreadManager.a(new qhk(this, str1, l1, (TroopInfo)localObject1), 5, null, false);
      }
      else
      {
        a(str1, l1);
        a(str1, l1, (TroopInfo)localObject1);
        a(4, true, new Object[] { str1 });
        continue;
        label741:
        if (paramGetTroopMemberListResp.result == 2)
        {
          a(4, true, new Object[] { str1 });
          continue;
          label767:
          l1 = 0L;
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopRemarkResp paramGetTroopRemarkResp)
  {
    long l1 = paramGetTroopRemarkResp.GroupUin;
    paramGetTroopRemarkResp.GroupUin = paramGetTroopRemarkResp.GroupCode;
    paramGetTroopRemarkResp.GroupCode = l1;
    String str1 = a(paramGetTroopRemarkResp.GroupUin);
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg.getUin()).createEntityManager();
    Object localObject = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { str1, "0" }, null, null, null, null);
    if (localObject != null) {}
    for (localObject = (TroopMemberInfo)((List)localObject).get(0);; localObject = null)
    {
      EntityTransaction localEntityTransaction;
      if (localObject == null)
      {
        localObject = new TroopMemberInfo();
        ((TroopMemberInfo)localObject).troopuin = str1;
        ((TroopMemberInfo)localObject).memberuin = "0";
        ((TroopMemberInfo)localObject).datetime = System.currentTimeMillis();
        localEntityManager.a((Entity)localObject);
        localEntityTransaction = localEntityManager.a();
        localEntityTransaction.a();
      }
      for (;;)
      {
        stTroopRemarkInfo localstTroopRemarkInfo;
        try
        {
          Iterator localIterator = paramGetTroopRemarkResp.vecTroopRemark.iterator();
          if (!localIterator.hasNext()) {
            break label384;
          }
          localstTroopRemarkInfo = (stTroopRemarkInfo)localIterator.next();
          long l2 = localstTroopRemarkInfo.MemberUin;
          l1 = l2;
          if (l2 < 0L) {
            l1 = localstTroopRemarkInfo.MemberUin + 4294967296L;
          }
          String str2 = String.valueOf(l1);
          localObject = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { str1, str2 }, null, null, null, null);
          if (localObject == null) {
            break label503;
          }
          localObject = (TroopMemberInfo)((List)localObject).get(0);
          if (localObject != null) {
            break label349;
          }
          localObject = new TroopMemberInfo();
          ((TroopMemberInfo)localObject).troopuin = str1;
          ((TroopMemberInfo)localObject).memberuin = str2;
          ((TroopMemberInfo)localObject).troopnick = localstTroopRemarkInfo.strNick;
          ((TroopMemberInfo)localObject).troopremark = localstTroopRemarkInfo.strRemark;
          ((TroopMemberInfo)localObject).mGlamourLevel = ((int)localstTroopRemarkInfo.GlamourLevel);
          ((TroopMemberInfo)localObject).datetime = System.currentTimeMillis();
          localEntityManager.a((Entity)localObject);
          continue;
          ((TroopMemberInfo)localObject).datetime = System.currentTimeMillis();
        }
        finally
        {
          localEntityTransaction.b();
        }
        localEntityManager.a((Entity)localObject);
        break;
        label349:
        ((TroopMemberInfo)localObject).troopnick = localstTroopRemarkInfo.strNick;
        ((TroopMemberInfo)localObject).troopremark = localstTroopRemarkInfo.strRemark;
        ((TroopMemberInfo)localObject).datetime = System.currentTimeMillis();
        localEntityManager.a((Entity)localObject);
        continue;
        label384:
        localEntityTransaction.c();
        localEntityTransaction.b();
        localEntityManager.a();
        if (paramGetTroopRemarkResp.NextUin != 0L)
        {
          paramToServiceMsg.extraData.putBoolean("force_refresh", true);
          paramToServiceMsg.extraData.putLong("nextuin", paramGetTroopRemarkResp.NextUin);
          paramGetTroopRemarkResp = new UniPacket(true);
          paramGetTroopRemarkResp.setEncodeName("utf-8");
          if (b(paramToServiceMsg, paramGetTroopRemarkResp))
          {
            paramToServiceMsg.setServiceName("mobileqq.service");
            paramToServiceMsg.setRequestSsoSeq(paramGetTroopRemarkResp.getRequestId());
            paramToServiceMsg.putWupBuffer(paramGetTroopRemarkResp.encode());
            a(paramToServiceMsg);
            return;
          }
          a(3, false, null);
          return;
        }
        a(3, true, null);
        return;
        label503:
        localObject = null;
      }
    }
  }
  
  private void a(String paramString, long paramLong, TroopInfo paramTroopInfo)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new TroopMemberInfo().getTableName(), "troopuin=? and memberuin<>? and memberuin<>? and datetime<?", new String[] { paramString, "1000000", "10000", String.valueOf(paramLong) });
    }
    if (paramTroopInfo == null) {
      return;
    }
    if ((paramTroopInfo.mOldMemberNumSeq != paramTroopInfo.mMemberNumSeq) || (paramTroopInfo.mMemberCardSeq != paramTroopInfo.mOldMemberCardSeq))
    {
      paramTroopInfo.mOldMemberNumSeq = paramTroopInfo.mMemberNumSeq;
      paramTroopInfo.mOldMemberCardSeq = paramTroopInfo.mMemberCardSeq;
      ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramTroopInfo);
    }
    ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramString);
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(45, false, new Object[] { paramString, Integer.valueOf(2), null });
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(45, false, new Object[] { paramString, Integer.valueOf(2), null });
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()))
      {
        a(45, false, new Object[] { paramString, Integer.valueOf(2), null });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(45, false, new Object[] { paramString, Integer.valueOf(2), null });
      return;
    }
    int i1 = paramFromServiceMsg.uint32_result.get();
    byte b1;
    if (i1 == 0)
    {
      long l1 = paramToServiceMsg.extraData.getLong("troopUin");
      paramToServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
      paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      paramObject = Long.toString(l1);
      if (paramString.equals("OidbSvc.0x8bb_2")) {
        b1 = 1;
      }
    }
    for (;;)
    {
      if (paramFromServiceMsg != null)
      {
        i1 = 0;
        for (;;)
        {
          if (i1 < paramToServiceMsg.length)
          {
            String str = Long.toString(paramToServiceMsg[i1]);
            if ((!TextUtils.isEmpty((CharSequence)paramObject)) && (!TextUtils.isEmpty(str))) {
              paramFromServiceMsg.a((String)paramObject, str, b1);
            }
            i1 += 1;
            continue;
            if (paramString.equals("OidbSvc.0x8bb_9"))
            {
              b1 = 0;
              break;
            }
            if (!paramString.equals("OidbSvc.0x8bb_7")) {
              break label421;
            }
            b1 = 2;
            break;
          }
        }
      }
      a(45, true, new Object[] { paramString, Integer.valueOf(1), paramToServiceMsg });
      return;
      if (i1 == 65)
      {
        a(45, false, new Object[] { paramString, Integer.valueOf(3), null });
        return;
      }
      if (i1 != 66) {
        break;
      }
      a(45, false, new Object[] { paramString, Integer.valueOf(4), null });
      return;
      label421:
      b1 = -100;
    }
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleSwitchTroopShowExStatusRsp");
    }
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    paramObject = new Object[3];
    paramObject[0] = str;
    paramObject[1] = Integer.valueOf(paramFromServiceMsg.getResultCode());
    paramObject[2] = Integer.valueOf(-1);
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      a(55, false, paramObject);
    }
    if (!"getShowEternalStatus".equals(paramToServiceMsg.extraData.getString("0x8d4_cmd_key"))) {
      return;
    }
    paramToServiceMsg = new cmd0x8b4.RspBody();
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        if ((!paramFromServiceMsg.isSuccess()) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break;
        }
        a(55, true, new Object[] { str, Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(paramToServiceMsg.uint32_flag.get()) });
        if (paramToServiceMsg.uint32_flag.get() == 1)
        {
          paramBoolean = true;
          a(null, str, paramBoolean, true);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(55, false, paramObject);
        return;
      }
      paramBoolean = false;
    }
    a(55, false, paramObject);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = 0L;
    long l2 = a(paramToServiceMsg.getUin());
    if (l2 == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    GetTroopMemberListReq localGetTroopMemberListReq = new GetTroopMemberListReq();
    localGetTroopMemberListReq.uin = l2;
    localGetTroopMemberListReq.GroupCode = paramToServiceMsg.getLong("troop_uin");
    localGetTroopMemberListReq.GroupUin = paramToServiceMsg.getLong("troop_code");
    localGetTroopMemberListReq.NextUin = paramToServiceMsg.getLong("nextuin");
    localGetTroopMemberListReq.ReqType = paramToServiceMsg.getInt("reqType");
    String str = localGetTroopMemberListReq.GroupCode + "_" + localGetTroopMemberListReq.ReqType;
    if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(str)) {
      l1 = ((Long)this.jdField_c_of_type_JavaUtilHashMap.get(str)).longValue();
    }
    localGetTroopMemberListReq.GetListAppointTime = l1;
    paramToServiceMsg.getBoolean("force_refresh");
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopMemberListReq");
    paramUniPacket.put("GTML", localGetTroopMemberListReq);
    return true;
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF000000 & paramInt) >> 24) };
  }
  
  public static byte[] a(short paramShort)
  {
    byte[] arrayOfByte = new byte[2];
    short s1 = 0;
    int i1 = paramShort;
    paramShort = s1;
    while (paramShort < arrayOfByte.length)
    {
      arrayOfByte[paramShort] = new Integer(i1 & 0xFF).byteValue();
      i1 >>= 8;
      paramShort += 1;
    }
    return arrayOfByte;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    qhr localqhr = new qhr();
    Object localObject = null;
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      boolean bool;
      try
      {
        paramFromServiceMsg = new SearchGroup.SearchGroupRes();
      }
      catch (Exception paramFromServiceMsg)
      {
        label137:
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      try
      {
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        localqhr.jdField_a_of_type_Int = paramFromServiceMsg.dwResult.get();
        localqhr.jdField_a_of_type_JavaLangString = paramFromServiceMsg.sErrInfo.get();
        if (localqhr.jdField_a_of_type_Int != 0) {
          break label353;
        }
        paramArrayOfByte = (SearchGroup.GroupClusterInfo)paramFromServiceMsg.stGroupClusterInfo.get();
        if (paramArrayOfByte.dwIsEnd.get() != 1) {
          continue;
        }
        bool = true;
        localqhr.jdField_a_of_type_Boolean = bool;
        localqhr.b = paramArrayOfByte.dwTotalSearchNum.get();
        localqhr.jdField_a_of_type_Long = paramFromServiceMsg.dwNextRecTime.get();
        localqhr.jdField_a_of_type_JavaUtilList = paramArrayOfByte.vGroupInfo.get();
        bool = true;
      }
      catch (Exception paramArrayOfByte)
      {
        label312:
        for (;;) {}
        bool = false;
      }
    }
    if (paramIntent.getIntExtra("searchType", 0) == 8)
    {
      if (bool)
      {
        paramIntent = (RecommendTroopManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
        if (paramIntent != null) {
          paramIntent.a(localqhr.jdField_a_of_type_Long, localqhr.jdField_a_of_type_JavaUtilList);
        }
      }
      a(28, bool, localqhr);
      if (paramFromServiceMsg != null)
      {
        if (NetworkUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()) != 1) {
          break label312;
        }
        paramIntent = new String[3];
        paramIntent[0] = "param_WIFIRecommendTroopDownload";
        paramIntent[1] = "param_WIFIFlow";
        paramIntent[2] = "param_Flow";
      }
      for (;;)
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramIntent, paramFromServiceMsg.getSerializedSize());
        return;
        bool = false;
        break;
        localqhr.jdField_a_of_type_Int = -1;
        localqhr.jdField_a_of_type_Boolean = true;
        bool = false;
        break label137;
        localqhr.jdField_a_of_type_Int = paramFromServiceMsg.getResultCode();
        localqhr.jdField_a_of_type_Boolean = true;
        paramFromServiceMsg = null;
        bool = false;
        break label137;
        paramIntent = new String[3];
        paramIntent[0] = "param_XGRecommendTroopDownload";
        paramIntent[1] = "param_XGFlow";
        paramIntent[2] = "param_Flow";
      }
    }
    a(13, bool, localqhr);
  }
  
  private void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      a(44, false, new Object[] { Integer.valueOf(3), null });
    }
    for (;;)
    {
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(44, false, new Object[] { Integer.valueOf(3), null });
        return;
      }
      paramString = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramString = (oidb_sso.OIDBSSOPkg)paramString.mergeFrom((byte[])paramObject);
        if ((paramString == null) || (!paramString.uint32_result.has()) || (paramString.uint32_result.get() != 0) || (!paramString.bytes_bodybuffer.has()) || (paramString.bytes_bodybuffer.get() == null))
        {
          a(44, false, new Object[] { Integer.valueOf(3), null });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        a(44, false, new Object[] { Integer.valueOf(3), null });
        return;
      }
      paramToServiceMsg = new oidb_0x8a0.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom(paramString.bytes_bodybuffer.get().toByteArray());
        paramString = Long.toString(paramToServiceMsg.opt_uint64_group_code.get());
        paramFromServiceMsg = paramToServiceMsg.rpt_msg_kick_result.get();
        paramToServiceMsg = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (oidb_0x8a0.KickResult)paramFromServiceMsg.next();
          if (((oidb_0x8a0.KickResult)paramObject).opt_uint32_result.get() == 0) {
            paramToServiceMsg.add(Long.toString(((oidb_0x8a0.KickResult)paramObject).opt_uint64_member_uin.get()));
          }
        }
        if (paramToServiceMsg.size() <= 0) {}
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        a(44, false, new Object[] { Integer.valueOf(3), null });
        return;
      }
    }
    paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    paramObject = paramToServiceMsg.iterator();
    while (((Iterator)paramObject).hasNext()) {
      paramFromServiceMsg.b(paramString, (String)((Iterator)paramObject).next());
    }
    a(44, true, new Object[] { Integer.valueOf(1), paramToServiceMsg });
  }
  
  private void b(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    int i2 = paramToServiceMsg.extraData.getInt("reqType");
    long l1 = paramToServiceMsg.extraData.getLong("timestamp");
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.set_show_external_status", 2, "handleSwitchTroopShowExStatusBeforeJoinedTroopRsp, handle response begin==>" + "isSuccess:" + paramBoolean + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|troopUin:" + str + "|reqType:" + i2 + "|timestamp:" + l1);
    }
    paramObject = new Object[4];
    paramObject[0] = str;
    paramObject[1] = Integer.valueOf(i2);
    paramObject[2] = Integer.valueOf(paramFromServiceMsg.getResultCode());
    if (i2 == 1) {}
    for (int i1 = 0;; i1 = 1)
    {
      paramObject[3] = Integer.valueOf(i1);
      if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
        a(54, false, paramObject);
      }
      if ("setShowExternalStatus0x8d4".equals(paramToServiceMsg.extraData.getString("0x8d4_cmd_key"))) {
        break;
      }
      return;
    }
    paramToServiceMsg = new cmd0x8b4.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      if ((paramFromServiceMsg.isSuccess()) && (paramToServiceMsg.uint32_result.get() == 0))
      {
        a(54, true, new Object[] { str, Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(paramToServiceMsg.uint32_flag.get()) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(54, false, paramObject);
      return;
    }
    a(54, false, paramObject);
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {}
    GetTroopRemarkReq localGetTroopRemarkReq;
    do
    {
      return false;
      paramToServiceMsg = paramToServiceMsg.extraData;
      localGetTroopRemarkReq = new GetTroopRemarkReq();
      localGetTroopRemarkReq.uin = l1;
      localGetTroopRemarkReq.GroupCode = paramToServiceMsg.getLong("troop_code");
      localGetTroopRemarkReq.GroupUin = paramToServiceMsg.getLong("troop_uin");
    } while ((localGetTroopRemarkReq.GroupCode == 0L) || (localGetTroopRemarkReq.GroupUin == 0L));
    localGetTroopRemarkReq.NextUin = paramToServiceMsg.getLong("nextuin");
    localGetTroopRemarkReq.Seq = 0L;
    paramToServiceMsg.getBoolean("force_refresh");
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopRemarkReq");
    paramUniPacket.put("GTR", localGetTroopRemarkReq);
    return true;
  }
  
  private void c(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleGetShowExtTroopListRsp");
    }
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      a(56, paramBoolean, null);
    }
    for (;;)
    {
      return;
      paramObject = paramToServiceMsg.extraData.getString("target_uin");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = new cmd0x8b4.RspBody();
      try
      {
        ((cmd0x8b4.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        paramOIDBSSOPkg = new Object[2];
        paramOIDBSSOPkg[0] = Integer.valueOf(((cmd0x8b4.RspBody)localObject1).uint32_result.get());
        paramOIDBSSOPkg[1] = null;
        if ((paramFromServiceMsg.isSuccess()) && (((cmd0x8b4.RspBody)localObject1).uint32_result.get() == 0)) {
          if (!((cmd0x8b4.RspBody)localObject1).rpt_group_info.has())
          {
            a(56, paramBoolean, paramOIDBSSOPkg);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
      {
        a(56, paramBoolean, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopHandler.troop.get_show_external_troop_list", 2, "handleGetShowExtTroopListRsp, handle rsp begin==>" + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|destUin:" + (String)paramObject + "|seTroopArray:" + localStringBuilder.toString());
        return;
        paramOIDBSSOPkg = new ArrayList();
        localObject2 = ((cmd0x8b4.RspBody)localObject1).rpt_group_info.get();
        localStringBuilder.append("groupInfoList size:").append(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cmd0x8b4.GroupInfo localGroupInfo = (cmd0x8b4.GroupInfo)((Iterator)localObject2).next();
          paramOIDBSSOPkg.add(new ShowExternalTroop(localGroupInfo));
          localStringBuilder.append("[uint64_gc:").append(localGroupInfo.uint64_gc.get()).append(",addedTimestamp:").append(localGroupInfo.uint32_set_display_time.get()).append("], ");
        }
      }
      catch (NullPointerException paramOIDBSSOPkg)
      {
        for (;;)
        {
          a(56, paramBoolean, null);
          continue;
          localObject1 = ((cmd0x8b4.RspBody)localObject1).bytes_text_label.get();
          Object localObject2 = new ArrayList();
          int i1 = 0;
          while (i1 < ((List)localObject1).size())
          {
            ((List)localObject2).add(((ByteStringMicro)((List)localObject1).get(i1)).toStringUtf8());
            i1 += 1;
          }
          a(56, paramBoolean, new Object[] { Integer.valueOf(0), paramOIDBSSOPkg, localObject2 });
          continue;
          a(56, paramBoolean, paramOIDBSSOPkg);
        }
      }
    }
  }
  
  private void o(String paramString)
  {
    MqqHandler localMqqHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(AVNotifyCenter.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(10011);
      localMessage.obj = Long.valueOf(paramString);
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  protected void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getIntegerArrayList("appids");
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
      a(74, false, new Object[] { paramToServiceMsg, null });
    }
    do
    {
      for (;;)
      {
        return;
        paramFromServiceMsg = new cmd0xca05.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          int i1 = paramFromServiceMsg.uint32_res.get();
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler.troop.troop_app", 2, "handleClearTroopAppRedPoint, retCode:" + i1);
          }
          if (i1 != 0) {
            break label244;
          }
          paramObject = paramFromServiceMsg.rpt_result.get();
          TroopAppMgr localTroopAppMgr = (TroopAppMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
          if (localTroopAppMgr != null)
          {
            localTroopAppMgr.b(paramFromServiceMsg.uint32_timestamp.get());
            i1 = 0;
            while (i1 < paramToServiceMsg.size())
            {
              localTroopAppMgr.d(((Integer)paramToServiceMsg.get(i1)).intValue());
              i1 += 1;
            }
            a(74, true, new Object[] { paramToServiceMsg, paramObject });
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          a(74, false, new Object[] { paramToServiceMsg, null });
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler.troop.troop_app", 2, "Exception, handleClearTroopAppRedPoint");
    return;
    label244:
    a(74, false, null);
  }
  
  public void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    int i2 = paramToServiceMsg.extraData.getInt("cmd");
    if (QLog.isColorLevel()) {
      QLog.d(".troop.closeRcvMsgTmp", 2, "handle_oidb_0xa80_0:" + str1 + "," + str2 + "," + i2 + "," + paramFromServiceMsg.isSuccess());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      a(77, false, new Object[] { str1, str2, Integer.valueOf(i2) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    int i1;
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      i1 = -1;
      if (paramToServiceMsg.uint32_result.has()) {
        i1 = paramToServiceMsg.uint32_result.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "sso result:" + i1);
      }
      if (i1 != 0)
      {
        a(77, false, new Object[] { str1, str2, Integer.valueOf(i2) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.closeRcvMsgTmp", 2, "handle_oidb_0xa80_0, pkg.mergeFrom:" + paramToServiceMsg.toString());
      }
      a(77, false, new Object[] { str1, str2, Integer.valueOf(i2) });
      return;
    }
    paramFromServiceMsg = new oidb_cmd0xa80.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = (oidb_cmd0xa80.RspGroupInfo)paramFromServiceMsg.rpt_msg_rsp_group_info.get().get(0);
      i1 = paramToServiceMsg.uint32_result.get();
      long l1 = paramToServiceMsg.uint64_group_code.get();
      paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "ret=" + i1 + "," + l1 + "," + paramToServiceMsg);
      }
      if (i1 == 0)
      {
        a(77, true, new Object[] { str1, str2, Integer.valueOf(i2) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "handle_oidb_0xa80_0:" + paramToServiceMsg.toString());
      }
      a(77, false, new Object[] { str1, str2, Integer.valueOf(i2) });
    }
  }
  
  public void C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = paramToServiceMsg.extraData.getInt("subCmd", -1);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.send_gift", 2, "handle_oidb_0x6b6. subCmd=" + i1);
    }
    switch (i1)
    {
    }
  }
  
  public void D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = paramToServiceMsg.extraData.getInt("subCmd", -1);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.send_gift", 2, "handle_oidb_0x6c3. subCmd=" + i1);
    }
    switch (i1)
    {
    }
  }
  
  public void E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = paramToServiceMsg.extraData.getInt("subCmd", -1);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.send_gift", 2, "handle_oidb_0x6b5. subCmd=" + i1);
    }
    switch (i1)
    {
    }
  }
  
  public void F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = paramToServiceMsg.extraData.getInt("subCmd", -1);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.send_gift", 2, "handle_oidb_0x6c2. subCmd=" + i1);
    }
    switch (i1)
    {
    }
  }
  
  public void G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    String str3 = paramToServiceMsg.extraData.getString("rewardId");
    int i2 = paramToServiceMsg.extraData.getInt("serviceType");
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "handle_oidb_0x5ba:" + str1 + "," + str2 + "," + str3 + "," + i2 + "," + paramFromServiceMsg.isSuccess());
    }
    if (!paramFromServiceMsg.isSuccess()) {
      a(81, false, new Object[] { Integer.valueOf(i2), str1, str2, str3, null });
    }
    for (;;)
    {
      return;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      int i1;
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        i1 = -1;
        if (paramFromServiceMsg.uint32_result.has()) {
          i1 = paramFromServiceMsg.uint32_result.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_reward", 2, "handle_oidb_0x5ba sso_ret:" + i1);
        }
        if (i1 != 0)
        {
          a(81, false, new Object[] { Integer.valueOf(i2), str1, str2, str3, null });
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.troop_reward", 2, "handle_oidb_0x5ba, pkg.mergeFrom:" + paramToServiceMsg.toString());
        }
        a(81, false, new Object[] { Integer.valueOf(i2), str1, str2, str3, null });
        return;
      }
      paramToServiceMsg = new oidb_0x5ba.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        i1 = paramToServiceMsg.uint32_result.get();
        paramFromServiceMsg = paramToServiceMsg.bytes_errmsg.get().toStringUtf8();
        int i3 = paramToServiceMsg.uint32_reward_privilege.get();
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_reward", 2, "handle_oidb_0x5ba oidb_ret=" + i1 + "," + paramFromServiceMsg);
        }
        paramToServiceMsg = (oidb_0x5ba.RewardItem)paramToServiceMsg.msg_resource.get();
        if ((i1 == 0) && (paramToServiceMsg != null))
        {
          ((TroopRewardMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151)).a(paramToServiceMsg.uint32_pay_count.get(), paramToServiceMsg.uint32_reward_status.get(), str1, str3);
          paramFromServiceMsg = new TroopRewardInfo();
          paramFromServiceMsg.troopUin = str1;
          paramFromServiceMsg.rewardId = str3;
          paramFromServiceMsg.privilege = i3;
          paramFromServiceMsg.ownerUin = (paramToServiceMsg.uint64_request_uin.get() + "");
          paramFromServiceMsg.status = paramToServiceMsg.uint32_reward_status.get();
          paramFromServiceMsg.msg = paramToServiceMsg.string_reward_text.get();
          paramFromServiceMsg.payMemberNum = paramToServiceMsg.uint32_pay_count.get();
          paramFromServiceMsg.type = paramToServiceMsg.uint32_reward_type.get();
          paramFromServiceMsg.rewardFee = paramToServiceMsg.uint32_reward_fee.get();
          paramFromServiceMsg.punishLeftTime = paramToServiceMsg.uint32_punish_left_time.get();
          paramFromServiceMsg.punishWarningInfo = paramToServiceMsg.string_punish_warning_info.get();
          if (!TextUtils.isEmpty(paramFromServiceMsg.punishWarningInfo)) {
            paramFromServiceMsg.punishWarningInfo = paramFromServiceMsg.punishWarningInfo.replace("&#10;", "\r\n");
          }
          paramFromServiceMsg.shootscreenPunishTime = paramToServiceMsg.uint32_shootscreen_punish_time.get();
          paramFromServiceMsg.blurPicUrl = paramToServiceMsg.string_blur_pic_url.get();
          paramFromServiceMsg.clearPicUrl = paramToServiceMsg.string_clear_pic_url.get();
          paramFromServiceMsg.vid = paramToServiceMsg.string_vid.get();
          paramFromServiceMsg.cookie = paramToServiceMsg.string_cookie.get();
          paramFromServiceMsg.videoDuration = paramToServiceMsg.uint32_video_duration.get();
          a(81, true, new Object[] { Integer.valueOf(i2), str1, str2, str3, paramFromServiceMsg });
          a(82, true, new Object[] { str1, str3 });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(".troop.troop_reward", 2, "handle_oidb_0x5ba success, type:" + i2);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.w(".troop.troop_reward", 2, "handle_oidb_0x5ba:" + paramToServiceMsg.toString());
        }
        a(81, false, new Object[] { Integer.valueOf(i2), str1, str2, str3, null });
      }
    }
  }
  
  public void H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.extraData.getString("troopUin");
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isJoin");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleJoinOrExitOpenTroop:").append((String)localObject).append(",");
      if (!bool1) {
        break label135;
      }
    }
    label135:
    for (paramToServiceMsg = "join";; paramToServiceMsg = "exit")
    {
      QLog.d(".troop.inOrOutOpenTroop", 2, paramToServiceMsg + "," + paramFromServiceMsg.isSuccess());
      if (paramFromServiceMsg.isSuccess()) {
        break;
      }
      a(83, false, new Object[] { localObject, Integer.valueOf(2131364056), Boolean.valueOf(bool1) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    int i1;
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      i1 = -1;
      if (paramToServiceMsg.uint32_result.has()) {
        i1 = paramToServiceMsg.uint32_result.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.inOrOutOpenTroop", 2, "sso result:" + i1);
      }
      if (i1 == 0) {
        break label387;
      }
      switch (i1)
      {
      default: 
        a(83, false, new Object[] { localObject, Integer.valueOf(2131364056), Boolean.valueOf(bool1) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.inOrOutOpenTroop", 2, "pkg.mergeFrom:" + paramToServiceMsg.toString());
      }
      a(83, false, new Object[] { localObject, Integer.valueOf(2131364056), Boolean.valueOf(bool1) });
      return;
    }
    a(83, false, new Object[] { localObject, Integer.valueOf(2131364055), Boolean.valueOf(bool1) });
    return;
    label387:
    paramObject = new oidb_0xa8d.RspBody();
    paramFromServiceMsg = (FromServiceMsg)localObject;
    try
    {
      ((oidb_0xa8d.RspBody)paramObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = (ToServiceMsg)localObject;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      if (((oidb_0xa8d.RspBody)paramObject).uint64_group_code.has())
      {
        paramFromServiceMsg = (FromServiceMsg)localObject;
        paramToServiceMsg = String.valueOf(((oidb_0xa8d.RspBody)paramObject).uint64_group_code.get());
      }
      paramFromServiceMsg = paramToServiceMsg;
      if (!((oidb_0xa8d.RspBody)paramObject).uint32_req_type.has()) {
        break label1073;
      }
      paramFromServiceMsg = paramToServiceMsg;
      i1 = ((oidb_0xa8d.RspBody)paramObject).uint32_req_type.get();
      paramFromServiceMsg = paramToServiceMsg;
      i2 = bQ;
      if (i1 != i2) {
        break label1023;
      }
      bool1 = true;
    }
    catch (Exception paramToServiceMsg)
    {
      label483:
      for (;;)
      {
        int i2;
      }
    }
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody)((oidb_0xa8d.RspBody)paramObject).msg_join_group.get();
        paramObject = new TroopInfo();
        i1 = 0;
        i2 = 0;
        boolean bool2 = false;
        localObject = new StringBuilder();
        if (paramFromServiceMsg.uint32_GroupFlagEx.has())
        {
          ((TroopInfo)paramObject).dwGroupFlagExt = paramFromServiceMsg.uint32_GroupFlagEx.get();
          bool2 = TroopInfo.isVisitorSpeakEnabled(paramFromServiceMsg.uint32_GroupFlagEx.get());
          ((StringBuilder)localObject).append(" dwGroupFlagExt: ").append(((TroopInfo)paramObject).dwGroupFlagExt);
          ((StringBuilder)localObject).append(" visitorSpeakEnabled: ").append(bool2);
        }
        if (paramFromServiceMsg.uint32_SpeakInterval.has())
        {
          i1 = paramFromServiceMsg.uint32_SpeakInterval.get();
          ((StringBuilder)localObject).append(" speakInterval: ").append(i1);
        }
        if (paramFromServiceMsg.uint32_StartSpeakInterval.has())
        {
          i2 = paramFromServiceMsg.uint32_StartSpeakInterval.get();
          ((StringBuilder)localObject).append(" startSpeakInterval: ").append(i2);
        }
        if (paramFromServiceMsg.uint32_GroupClassEx.has())
        {
          ((TroopInfo)paramObject).dwGroupClassExt = paramFromServiceMsg.uint32_GroupClassEx.get();
          ((StringBuilder)localObject).append(" dwGroupClassExt: ").append(((TroopInfo)paramObject).dwGroupClassExt);
        }
        if (paramFromServiceMsg.uint32_GroupClass.has())
        {
          ((TroopInfo)paramObject).trooptype = paramFromServiceMsg.uint32_GroupClass.get();
          ((StringBuilder)localObject).append(" trooptype: ").append(((TroopInfo)paramObject).trooptype);
        }
        if (paramFromServiceMsg.uint32_MaxMember.has())
        {
          ((TroopInfo)paramObject).wMemberMax = paramFromServiceMsg.uint32_MaxMember.get();
          ((StringBuilder)localObject).append(" wMemberMax: ").append(((TroopInfo)paramObject).wMemberMax);
        }
        if (paramFromServiceMsg.uint32_SpecialClass.has())
        {
          ((TroopInfo)paramObject).wSpecialClass = paramFromServiceMsg.uint32_SpecialClass.get();
          ((StringBuilder)localObject).append(" wSpecialClass: ").append(((TroopInfo)paramObject).wSpecialClass);
        }
        if (paramFromServiceMsg.bytes_GroupName.has())
        {
          ((TroopInfo)paramObject).troopname = paramFromServiceMsg.bytes_GroupName.get().toStringUtf8();
          ((StringBuilder)localObject).append(" troopname: ").append(((TroopInfo)paramObject).troopname);
        }
        if (QLog.isColorLevel()) {
          QLog.d(".troop.inOrOutOpenTroop", 2, ((StringBuilder)localObject).toString());
        }
        a(83, true, new Object[] { paramToServiceMsg, Integer.valueOf(2131364053), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i1), Integer.valueOf(i2) });
        paramObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (paramObject == null) {
          break;
        }
        if (!bool1) {
          break label1064;
        }
        paramFromServiceMsg = paramToServiceMsg;
        ((TroopManager)paramObject).d(paramFromServiceMsg);
        return;
      }
      catch (Exception paramObject)
      {
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)paramObject;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.inOrOutOpenTroop", 2, "handleJoinOrExitOpenTroop:" + paramToServiceMsg.toString());
      }
      a(83, false, new Object[] { paramFromServiceMsg, Integer.valueOf(2131364056), Boolean.valueOf(bool1) });
      return;
      label1023:
      bool1 = false;
      break label483;
      a(83, true, new Object[] { paramToServiceMsg, Integer.valueOf(2131364054), Boolean.valueOf(bool1) });
      continue;
      label1064:
      paramFromServiceMsg = null;
    }
  }
  
  protected Class a()
  {
    return TroopObserver.class;
  }
  
  public ArrayList a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(String.valueOf(this.h)))) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  public void a()
  {
    b(null);
  }
  
  public void a(byte paramByte, String paramString1, String paramString2)
  {
    if ((paramByte == 0) || (paramByte == 1))
    {
      NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), TroopServlet.class);
      localNewIntent.putExtra("command", 0);
      localNewIntent.putExtra("operation", paramByte);
      localNewIntent.putExtra("troop_code", paramString1);
      localNewIntent.putExtra("troop_member_uin", paramString2);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.a(BaseApplication.getContext()).a(null, j, false, 0L, 0L, localHashMap, "");
  }
  
  public void a(int paramInt, long paramLong, List paramList)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2235);
    localOIDBSSOPkg.uint32_result.set(0);
    oidb_0x8bb.ReqBody localReqBody = new oidb_0x8bb.ReqBody();
    oidb_0x8bb.GroupConcernedInfo localGroupConcernedInfo = new oidb_0x8bb.GroupConcernedInfo();
    long[] arrayOfLong = new long[paramList.size()];
    int i1;
    ArrayList localArrayList;
    if (paramInt == 0)
    {
      i1 = 0;
      while (i1 < paramList.size())
      {
        localGroupConcernedInfo.rpt_uint64_default_uins.add(paramList.get(i1));
        arrayOfLong[i1] = ((Long)paramList.get(i1)).longValue();
        i1 += 1;
      }
      localOIDBSSOPkg.uint32_service_type.set(9);
      localGroupConcernedInfo.uint64_group_code.set(paramLong);
      paramList = new oidb_0x8bb.WriteReq();
      localArrayList = new ArrayList();
      localArrayList.add(localGroupConcernedInfo);
      paramList.rpt_msg_group_concerned.set(localArrayList);
      localReqBody.msg_write_req.set(paramList);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramList = "OidbSvc.0x8bb_9";
      if (paramInt != 1) {
        break label529;
      }
      paramList = "OidbSvc.0x8bb_2";
    }
    for (;;)
    {
      paramList = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramList);
      paramList.extraData.putLong("troopUin", paramLong);
      paramList.extraData.putLongArray("uinList", arrayOfLong);
      paramList.putWupBuffer(localOIDBSSOPkg.toByteArray());
      b(paramList);
      Object localObject;
      do
      {
        return;
        if (paramInt == 1)
        {
          localArrayList = new ArrayList();
          i1 = 0;
          while (i1 < paramList.size())
          {
            localObject = new oidb_0x8bb.UinInfo();
            ((oidb_0x8bb.UinInfo)localObject).uint64_uin.set(((Long)paramList.get(i1)).longValue());
            localArrayList.add(localObject);
            arrayOfLong[i1] = ((Long)paramList.get(i1)).longValue();
            i1 += 1;
          }
          localGroupConcernedInfo.rpt_msg_concerned.set(localArrayList);
          localOIDBSSOPkg.uint32_service_type.set(2);
          break;
        }
      } while (paramInt != 2);
      localArrayList = new ArrayList();
      i1 = 0;
      while (i1 < paramList.size())
      {
        localObject = new oidb_0x8bb.ForbidUin();
        ((oidb_0x8bb.ForbidUin)localObject).uint64_uin.set(((Long)paramList.get(i1)).longValue());
        localArrayList.add(localObject);
        arrayOfLong[i1] = ((Long)paramList.get(i1)).longValue();
        i1 += 1;
      }
      localGroupConcernedInfo.rpt_msg_forbid_uins.set(localArrayList);
      localOIDBSSOPkg.uint32_service_type.set(7);
      break;
      label529:
      if (paramInt == 2) {
        paramList = "OidbSvc.0x8bb_7";
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new cmd0x3bb.ReqBody();
    try
    {
      ((cmd0x3bb.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((cmd0x3bb.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString2));
      cmd0x3bb.AnonyMsg localAnonyMsg = new cmd0x3bb.AnonyMsg();
      localAnonyMsg.uint32_cmd.set(paramInt);
      localAnonyMsg.msg_anony_req.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "anony_msg.group");
      ((ToServiceMsg)localObject).putWupBuffer(localAnonyMsg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString2);
      b((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "TroopHandler.getAnonymousChatNick, memberUin: " + paramString1 + " troopUin: " + paramString2);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", troopUin : " + paramString2);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramInt1 == 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1809);
    localOIDBSSOPkg.uint32_service_type.set(127);
    Object localObject = ByteBuffer.allocate(paramString1.getBytes().length + 6);
    ((ByteBuffer)localObject).putInt(paramInt1);
    ((ByteBuffer)localObject).putShort((short)paramString1.getBytes().length);
    ((ByteBuffer)localObject).put(paramString1.getBytes());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x711_127");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).extraData.putString("openId", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("token", paramString2);
    ((ToServiceMsg)localObject).extraData.putInt("appid", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("seq", paramInt2);
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    jstoken.ReqBody localReqBody = new jstoken.ReqBody();
    localReqBody.uint32_appid.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1)) {
      localReqBody.bytes_group_openid.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.bytes_jstoken.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    ToServiceMsg localToServiceMsg = a("GroupOpen.CheckJsApiToken");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.extraData.putInt("appid", paramInt1);
    localToServiceMsg.extraData.putString("url", paramString3);
    localToServiceMsg.extraData.putString("openGroupId", paramString1);
    localToServiceMsg.extraData.putString("token", paramString2);
    localToServiceMsg.extraData.putInt("seq", paramInt2);
    b(localToServiceMsg);
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    a(paramInt, paramArrayList, null);
  }
  
  public void a(int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.troop_app", 2, "modifyTroopAppList, start==>appListTimestamp:" + paramInt);
    }
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty())) {
      return;
    }
    cmd0xca04.ReqBody localReqBody = new cmd0xca04.ReqBody();
    localReqBody.uint32_timestamp.set(paramInt);
    Object localObject = new cmd0xca04.AppInfo();
    ((cmd0xca04.AppInfo)localObject).plat_type.set(2);
    ((cmd0xca04.AppInfo)localObject).str_app_version.set("6.5.5");
    localReqBody.msg_app_info.set((MessageMicro)localObject);
    localObject = paramArrayList1.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      if (localInteger.intValue() > 0) {
        localReqBody.rpt_uint32_appids.add(localInteger);
      }
    }
    localObject = a("GroupOpen.SortAppList");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putIntegerArrayList("appidList2sort", paramArrayList1);
    if ((paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {
      ((ToServiceMsg)localObject).extraData.putIntegerArrayList("appidToAdd", paramArrayList2);
    }
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, List paramList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.troop_app", 2, "getTroopAppList: start");
    }
    cmd0xca02.ReqBody localReqBody = new cmd0xca02.ReqBody();
    localReqBody.uint32_type.set(paramInt);
    Object localObject = new cmd0xca02.AppInfo();
    ((cmd0xca02.AppInfo)localObject).plat_type.set(2);
    ((cmd0xca02.AppInfo)localObject).str_app_version.set("6.5.5");
    localReqBody.msg_app_info.set((MessageMicro)localObject);
    if (paramInt == 2)
    {
      if ((paramList == null) || (paramList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler.troop.troop_app", 2, "invaliedAppids.isEmpty");
        }
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (Integer)paramList.next();
        localReqBody.rpt_app_ids.add(localObject);
      }
    }
    paramList = a("GroupOpen.ReadAppList");
    paramList.putWupBuffer(localReqBody.toByteArray());
    paramList.extraData.putInt("readType", paramInt);
    paramList.extraData.putBoolean("appListChangedFromWebOperate", paramBoolean);
    b(paramList);
  }
  
  public void a(long paramLong)
  {
    this.h = paramLong;
    a(paramLong, 0L, 5, null, 6, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x88d_1").append("|troopuin = ").append(paramLong).append("|flag = ").append(paramInt);
      QLog.i("Q.troopquestionverify.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    if ((paramInt & 0x80) == 128) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_option.set(0);
    }
    if ((paramInt & 0x800000) == 8388608) {
      ((oidb_0x88d.GroupInfo)localObject2).string_group_question.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt & 0x800) == 2048) {
      ((oidb_0x88d.GroupInfo)localObject2).string_group_answer.set(ByteStringMicro.EMPTY);
    }
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(paramLong);
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_1");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong);
    ((ToServiceMsg)localObject2).extraData.putInt("nFlag", paramInt);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, -1, "");
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x88d_0").append("|troopuin = ").append(paramLong).append("|flag = ").append(paramInt1);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    if ((paramInt1 & 0x2) == 2) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_create_time.set(0);
    }
    if ((paramInt1 & 0x4) == 4) {
      ((oidb_0x88d.GroupInfo)localObject2).string_group_question.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt1 & 0x8) == 8) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag_ext.set(0);
    }
    if ((paramInt1 & 0x10) == 16) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_type_flag.set(0);
    }
    if ((paramInt1 & 0x20) == 32) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_member_num.set(0);
    }
    if ((paramInt1 & 0x1) == 32) {
      ((oidb_0x88d.GroupInfo)localObject2).string_group_answer.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt1 & 0x40) == 64) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
    }
    if ((paramInt1 & 0x80) == 128) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_option.set(0);
    }
    if ((paramInt1 & 0x100) == 256) {
      ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(0L);
    }
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(paramLong);
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    if (paramInt2 > 0) {
      ((oidb_0x88d.ReqGroupInfo)localObject1).uint32_last_get_group_name_time.set(paramInt2);
    }
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong);
    ((ToServiceMsg)localObject2).extraData.putInt("nFlag", paramInt1);
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 1);
    ((ToServiceMsg)localObject2).extraData.putInt("seq", paramInt3);
    ((ToServiceMsg)localObject2).extraData.putString("processName", paramString);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, long paramLong2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), PbServlet.class);
    localNewIntent.putExtra("cmd", "ProfileService.SearchGroup");
    localNewIntent.putExtra("searchType", paramInt3);
    SearchGroup.SearchGroupReq localSearchGroupReq = new SearchGroup.SearchGroupReq();
    localSearchGroupReq.qwUin.set(paramLong1);
    localSearchGroupReq.dwReqUinNum.set(paramInt1);
    localSearchGroupReq.dwPageNo.set(paramInt2);
    localSearchGroupReq.eSubCmd.set(paramInt3);
    localSearchGroupReq.sReqContent.set(paramString);
    localSearchGroupReq.eGroupSortType.set(paramInt4);
    localSearchGroupReq.dwNextRecTime.set((int)paramLong2);
    localNewIntent.putExtra("data", localSearchGroupReq.toByteArray());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "group_member_card.get_group_member_card_info");
    group_member_info.ReqBody localReqBody = new group_member_info.ReqBody();
    localReqBody.uint64_group_code.set(paramLong1);
    localReqBody.uint64_uin.set(paramLong2);
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "FriendListHandler.getTroopMemberCard, memberUin: " + paramLong2 + " troopCode: " + paramLong1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    cmd0x3fe.LevelMsg localLevelMsg = new cmd0x3fe.LevelMsg();
    localLevelMsg.uint32_subcmd.set(1);
    Object localObject = new cmd0x3fe.ReqBody();
    cmd0x3fe.UserInfo localUserInfo = new cmd0x3fe.UserInfo();
    localUserInfo.uint64_uin.set(paramLong1);
    localUserInfo.uint32_online_time.set(paramInt);
    ((cmd0x3fe.ReqBody)localObject).rpt_msg_user_info.add(localUserInfo);
    ((cmd0x3fe.ReqBody)localObject).uint64_group_code.set(paramLong2);
    localLevelMsg.msg_level_req.set((MessageMicro)localObject);
    localObject = a("qunVideoOnlineLevel.0x3fe_0");
    ((ToServiceMsg)localObject).putWupBuffer(localLevelMsg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, List paramList, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder(150);
      paramList.append("send_oidb_0x899_0").append("|troopuin = ").append(paramLong1).append("|flag = ").append(paramInt1).append("|nStartUin = ").append(paramLong2).append("|memberNum = ").append(paramInt2).append("|filterMethod = ").append(paramInt3);
      QLog.i("Q.troopdisband.", 2, paramList.toString());
    }
    Object localObject = new oidb_0x899.memberlist();
    ((oidb_0x899.memberlist)localObject).uint64_member_uin.set(0L);
    paramList = new oidb_0x899.ReqBody();
    paramList.uint64_group_code.set(paramLong1);
    paramList.uint64_start_uin.set(paramLong2);
    if (paramInt1 == 4) {
      ((oidb_0x899.memberlist)localObject).uint32_uin_flag.set(0);
    }
    for (;;)
    {
      paramList.uint32_identify_flag.set(paramInt1);
      paramList.memberlist_opt.set((MessageMicro)localObject);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2201);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramList.toByteArray()));
      paramList = a("OidbSvc.0x899_0");
      paramList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      paramList.extraData.putLong("troop_uin", paramLong1);
      paramList.extraData.putInt("nFlag", paramInt1);
      paramList.extraData.putLong("nStartUin", paramLong2);
      paramList.setTimeout(30000L);
      b(paramList);
      return;
      if (paramInt1 == 5)
      {
        paramList.uint32_member_num.set(paramInt2);
        paramList.uint32_filter_method.set(paramInt3);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x89e").append("|troopuin = ").append(paramLong1).append("|oldOwner = ").append(paramLong2).append("|newOwner = ").append(paramLong3);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x89e.ReqBody();
    ((oidb_0x89e.ReqBody)localObject2).uint64_group_code.set(paramLong1);
    ((oidb_0x89e.ReqBody)localObject2).uint64_old_owner.set(paramLong2);
    ((oidb_0x89e.ReqBody)localObject2).uint64_new_owner.set(paramLong3);
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2206);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89e.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x89e_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong1);
    ((ToServiceMsg)localObject2).extraData.putLong("OldOwner", paramLong2);
    ((ToServiceMsg)localObject2).extraData.putLong("NewOwner", paramLong3);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.ModifyGroupInfoReq");
    localToServiceMsg.extraData.putLong("dwGroupCode", paramLong1);
    localToServiceMsg.extraData.putLong("cGroupOption", paramLong2);
    localToServiceMsg.extraData.putLong("dwGroupClass", paramLong3);
    Bundle localBundle = localToServiceMsg.extraData;
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    localBundle.putString("strGroupName", (String)localObject);
    localToServiceMsg.extraData.putInt("wGroupFace", paramInt1);
    localObject = localToServiceMsg.extraData;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((Bundle)localObject).putString("strGroupMemo", paramString1);
    paramString2 = localToServiceMsg.extraData;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    paramString2.putString("strFingerMemo", paramString1);
    localToServiceMsg.extraData.putInt("modify_troopinfo_flag", paramInt2);
    if ((paramInt2 & 0x2) == 2) {
      localToServiceMsg.extraData.putLong("dwValidMask", 2L);
    }
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, group_mgr.CardInfo paramCardInfo)
  {
    hw_sso.HwSSOReq localHwSSOReq = new hw_sso.HwSSOReq();
    group_mgr.HwModifyCardReq localHwModifyCardReq = new group_mgr.HwModifyCardReq();
    localHwModifyCardReq.gid.set(paramLong1);
    localHwModifyCardReq.target_uin.set(paramLong2);
    localHwModifyCardReq.card_info.set(paramCardInfo);
    localHwSSOReq.cmd.set("modifycard");
    localHwSSOReq.body.set(ByteStringMicro.copyFrom(localHwModifyCardReq.toByteArray()));
    paramCardInfo = a("SHomeworkSvc.modifycard");
    paramCardInfo.putWupBuffer(localHwSSOReq.toByteArray());
    b(paramCardInfo);
  }
  
  public void a(long paramLong, List paramList, boolean paramBoolean)
  {
    Object localObject = new oidb_0x8a0.ReqBody();
    ((oidb_0x8a0.ReqBody)localObject).opt_uint64_group_code.set(paramLong);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramList.size())
    {
      oidb_0x8a0.KickMemberInfo localKickMemberInfo = new oidb_0x8a0.KickMemberInfo();
      localKickMemberInfo.opt_uint32_opearte.set(5);
      localKickMemberInfo.opt_uint64_member_uin.set(((Long)paramList.get(i1)).longValue());
      PBUInt32Field localPBUInt32Field = localKickMemberInfo.opt_uint32_flag;
      if (paramBoolean) {}
      for (int i2 = 1;; i2 = 0)
      {
        localPBUInt32Field.set(i2);
        localArrayList.add(localKickMemberInfo);
        i1 += 1;
        break;
      }
    }
    ((oidb_0x8a0.ReqBody)localObject).rpt_msg_kick_list.set(localArrayList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2208);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8a0.ReqBody)localObject).toByteArray()));
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x8a0_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.ReqBatchProcess");
    localToServiceMsg.extraData.putLong("troop_code", paramLong);
    localToServiceMsg.extraData.putBoolean("is_admin", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean, String paramString)
  {
    int i1 = 0;
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), PbServlet.class);
    localNewIntent.putExtra("cmd", "ProfileService.Pb.SetGroupLocation");
    GroupLocation.SetGroupLocationReq localSetGroupLocationReq = new GroupLocation.SetGroupLocationReq();
    localSetGroupLocationReq.groupcode.set(Utils.a(paramLong));
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localSetGroupLocationReq.grouplocation.set(str);
    localNewIntent.putExtra("data", localSetGroupLocationReq.toByteArray());
    localNewIntent.putExtra("TroopUin", paramLong);
    localNewIntent.putExtra("isClear", paramBoolean);
    paramString = str.split("\\|");
    int i2;
    if (paramString.length == 4)
    {
      i2 = (int)(Float.valueOf(paramString[1]).floatValue() * 1000000.0F);
      i1 = (int)(Float.valueOf(paramString[2]).floatValue() * 1000000.0F);
    }
    for (;;)
    {
      localNewIntent.putExtra("lat", i2);
      localNewIntent.putExtra("lon", i1);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
      i2 = 0;
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    paramObject = (byte[])paramObject;
    if (str.equalsIgnoreCase("ProfileService.SearchGroup")) {
      b(paramIntent, paramFromServiceMsg, (byte[])paramObject);
    }
    while (!str.equalsIgnoreCase("ProfileService.Pb.SetGroupLocation")) {
      return;
    }
    a(paramIntent, paramFromServiceMsg, (byte[])paramObject);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    cmd0x8ca.ReqBody localReqBody = new cmd0x8ca.ReqBody();
    localReqBody.opt_uint32_sub_cmd.set(3L);
    try
    {
      localReqBody.opt_uint64_from_uin.set(Long.parseLong(paramQQAppInterface.a()));
      localReqBody.opt_uint64_group_code.set(Long.parseLong(paramString));
      localReqBody.opt_bytes_group_sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      localReqBody.opt_uint64_appid.set(1102858908L);
      paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
      paramArrayOfByte.uint32_command.set(2250);
      paramArrayOfByte.uint32_result.set(0);
      paramArrayOfByte.uint32_service_type.set(2);
      paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramQQAppInterface = new ToServiceMsg("mobileqq.service", paramQQAppInterface.a(), "OidbSvc.0x8ca_2");
      paramQQAppInterface.extraData.putString("troopUin", paramString);
      paramQQAppInterface.putWupBuffer(paramArrayOfByte.toByteArray());
      b(paramQQAppInterface);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, "clearAioFCRedDot error, NumberFormatException, troopUin : " + paramString);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "onReceive,resp == null");
      }
    }
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if (!a(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler", 2, "cmdfilter error=" + str);
    return;
    if ("GroupSvc.JoinGroupLink".equalsIgnoreCase(str))
    {
      J(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("GroupOpen.CheckJsApiToken".equals(str))
    {
      I(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("friendlist.GetTroopListReqV2".equals(str))
    {
      if ((paramFromServiceMsg.getResultCode() == 2901) && (paramToServiceMsg != null))
      {
        int i1 = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler", 2, "k_resend_cnt" + i1);
        }
        if (i1 < 2)
        {
          paramToServiceMsg.extraData.putInt("k_resend_cnt", i1 + 1);
          a(paramToServiceMsg);
          return;
        }
      }
      if (paramObject == null)
      {
        a(1, false, null);
        return;
      }
      paramFromServiceMsg = (GetTroopListRespV2)paramObject;
      if ((paramFromServiceMsg.result == 1) || ((paramFromServiceMsg.vecTroopList == null) && (paramFromServiceMsg.vecTroopListDel == null)))
      {
        a(1, false, null);
        return;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("friendlist.GetMultiTroopInfoReq".equals(str))
    {
      if (paramFromServiceMsg.isSuccess())
      {
        if (paramObject != null)
        {
          a(paramFromServiceMsg, (GetMultiTroopInfoResp)paramObject);
          return;
        }
        a(2, true, null);
        return;
      }
      a(2, false, null);
      return;
    }
    if ("friendlist.ModifyGroupCardReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject != null)
      {
        a(paramToServiceMsg, paramFromServiceMsg, (ModifyGroupCardResp)paramObject);
        return;
      }
      a(9, false, null);
      return;
    }
    if ("friendlist.ModifyGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd())) {
      if (!(paramObject instanceof ModifyGroupInfoResp)) {
        break label1539;
      }
    }
    label1539:
    for (paramObject = (ModifyGroupInfoResp)paramObject;; paramObject = null)
    {
      a(paramToServiceMsg, paramFromServiceMsg, (ModifyGroupInfoResp)paramObject);
      return;
      if ("friendlist.GetTroopAppointRemarkReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(paramFromServiceMsg, (GetTroopAppointRemarkResp)paramObject);
          return;
        }
        a(10, false, null);
        return;
      }
      if ("friendlist.getTroopRemark".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(paramToServiceMsg, (GetTroopRemarkResp)paramObject);
          return;
        }
        a(3, false, null);
        return;
      }
      if ("friendlist.getTroopMemberList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(paramToServiceMsg, (GetTroopMemberListResp)paramObject);
          return;
        }
        a(4, false, new Object[] { a(paramToServiceMsg.extraData.getLong("troop_uin")) });
        return;
      }
      if ("group_member_card.get_group_member_card_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x406_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.getGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        M(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        switch (paramToServiceMsg.extraData.getInt("subCmd", -1))
        {
        case 3: 
        case 5: 
        default: 
          return;
        case 1: 
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 4: 
          m(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 2: 
          K(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 6: 
          t(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 7: 
          r(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_7".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x899_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x89e_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8c9_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8fd_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        N(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8b8_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        switch (paramToServiceMsg.extraData.getInt("subCmd", -1))
        {
        case 4: 
        default: 
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 3: 
          l(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        R(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_10".equals(paramFromServiceMsg.getServiceCmd()))
      {
        L(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.ReqBatchProcess".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x8bb_2".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x8bb_9".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x8bb_7".equals(paramFromServiceMsg.getServiceCmd())))
      {
        a(paramFromServiceMsg.getServiceCmd(), paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8a0_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramFromServiceMsg.getServiceCmd(), paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("anony_msg.group".equals(paramFromServiceMsg.getServiceCmd()))
      {
        Q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.GroupMngReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        O(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d6_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        P(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x787_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        S(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8a7_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        T(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x787_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        U(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8ca_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        V(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9fa".equals(paramFromServiceMsg.getServiceCmd()))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9ab_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SHomeworkSvc.querycard".equals(paramFromServiceMsg.getServiceCmd()))
      {
        v(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SHomeworkSvc.modifycard".equals(paramFromServiceMsg.getServiceCmd()))
      {
        w(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupOpen.ReadAppList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        y(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupOpen.SortAppList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        z(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupOpen.ClearRedPoint".equals(paramFromServiceMsg.getServiceCmd()))
      {
        A(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qunVideoOnlineLevel.0x3fe_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa80_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        B(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6b6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        C(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6b5".equals(paramFromServiceMsg.getServiceCmd()))
      {
        E(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6c2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        F(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6c3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        D(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x5ba_4".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x5ba_7".equals(paramFromServiceMsg.getServiceCmd())))
      {
        G(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa8d".equals(paramFromServiceMsg.getServiceCmd()))
      {
        H(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6d1_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        W(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (!"OidbSvc.0x711_127".equals(paramFromServiceMsg.getServiceCmd())) {
        break;
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      try
      {
        paramString = paramString.trim();
        long l1 = Long.parseLong(paramString);
        Object localObject = new cmd0x8b4.ReqBody();
        ((cmd0x8b4.ReqBody)localObject).uint64_gc.set(l1);
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(2228);
        localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject).toByteArray()));
        localOIDBSSOPkg.uint32_service_type.set(0);
        localObject = a("OidbSvc.0x8b4");
        ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
        ((ToServiceMsg)localObject).extraData.putString("0x8d4_cmd_key", "getShowEternalStatus");
        ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
        b((ToServiceMsg)localObject);
        return;
      }
      catch (NumberFormatException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TroopHandler", 2, "NumberFormatException");
  }
  
  public void a(String paramString, byte paramByte, long paramLong, int paramInt)
  {
    Object localObject = Long.valueOf(SystemClock.uptimeMillis());
    Long localLong = (Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localLong != null) && (Math.abs(((Long)localObject).longValue() - localLong.longValue()) < 60000L)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
    localObject = a("ProfileService.getGroupInfoReq");
    ((ToServiceMsg)localObject).extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putByte("get_groupablm", paramByte);
    ((ToServiceMsg)localObject).extraData.putLong("groupablm_timestamp", paramLong);
    ((ToServiceMsg)localObject).extraData.putInt("cStatOption", paramInt);
    ((ToServiceMsg)localObject).extraData.putByte("cIfGetAuthInfo", (byte)1);
    a((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 0);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putInt("stat_option", paramInt);
    localToServiceMsg.extraData.putByte("cIfGetAuthInfo", (byte)1);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopHandler", 2, "getShowExternalTroopList destUin is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = paramString.trim();
          long l1 = Long.parseLong(paramString);
          if (l1 != 0L)
          {
            Object localObject1 = new cmd0x8b4.ReqBody();
            ((cmd0x8b4.ReqBody)localObject1).uint64_dst_uin.set(l1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_start.set(paramInt1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_cnt.set(paramInt2);
            Object localObject2 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            localObject2 = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2228);
            ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject1).toByteArray()));
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
            localObject1 = a("OidbSvc.0x8b4");
            ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
            ((ToServiceMsg)localObject1).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
            ((ToServiceMsg)localObject1).extraData.putString("target_uin", paramString);
            b((ToServiceMsg)localObject1);
            if (QLog.isColorLevel())
            {
              QLog.d("TroopHandler.troop.get_show_external_troop_list", 2, "getShowExternalTroopList, request begin==>" + "|ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + "|ServiceCmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + "|destUin:" + paramString);
              return;
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopHandler", 2, "NumberFormatException");
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    Object localObject1 = new oidb_0x8b8.ReqBody();
    if ((paramArrayList == null) || (paramInt > 2)) {
      return;
    }
    try
    {
      ((oidb_0x8b8.ReqBody)localObject1).uint64_group_uin.set(Long.parseLong(paramString));
      ((oidb_0x8b8.ReqBody)localObject1).uint32_subcmd.set(paramInt + 1);
      ((oidb_0x8b8.ReqBody)localObject1).uint32_sequence.set(23);
      Object localObject2;
      if (paramInt == 0)
      {
        localObject2 = new oidb_0x8b8.ModifyOrderReq();
        ((oidb_0x8b8.ModifyOrderReq)localObject2).rpt_uint32_pic_list.set(paramArrayList);
        ((oidb_0x8b8.ModifyOrderReq)localObject2).uint32_pic_cnt.set(paramArrayList.size());
        ((oidb_0x8b8.ReqBody)localObject1).msg_modify_order.set((MessageMicro)localObject2);
      }
      for (;;)
      {
        paramArrayList = new oidb_sso.OIDBSSOPkg();
        paramArrayList.uint32_command.set(2232);
        paramArrayList.uint32_service_type.set(1);
        paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8b8.ReqBody)localObject1).toByteArray()));
        localObject1 = a("OidbSvc.0x8b8_1");
        ((ToServiceMsg)localObject1).putWupBuffer(paramArrayList.toByteArray());
        ((ToServiceMsg)localObject1).extraData.putInt("subCmd", paramInt);
        ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
        ((ToServiceMsg)localObject1).setTimeout(30000L);
        b((ToServiceMsg)localObject1);
        return;
        int i1;
        if (paramInt == 1)
        {
          localObject2 = new oidb_0x8b8.SetDefaultReq();
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            i1 = ((Integer)paramArrayList.next()).intValue();
            ((oidb_0x8b8.SetDefaultReq)localObject2).uint32_default_id.set(i1);
          }
          ((oidb_0x8b8.ReqBody)localObject1).msg_set_default.set((MessageMicro)localObject2);
        }
        else if (paramInt == 2)
        {
          localObject2 = new oidb_0x8b8.DelPicReq();
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            i1 = ((Integer)localIterator.next()).intValue();
            ((oidb_0x8b8.DelPicReq)localObject2).rpt_uint32_del_list.add(Integer.valueOf(i1));
          }
          ((oidb_0x8b8.DelPicReq)localObject2).uint32_del_cnt.set(paramArrayList.size());
          ((oidb_0x8b8.ReqBody)localObject1).msg_del_pic.set((MessageMicro)localObject2);
        }
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void a(String paramString, int paramInt, oidb_0x6b6.SendFlowerReq paramSendFlowerReq, oidb_0x6b6.ThrowFlowerReq paramThrowFlowerReq)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. troopUin is null");
      }
      return;
    }
    oidb_0x6b6.ReqBody localReqBody = new oidb_0x6b6.ReqBody();
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf(paramString).longValue();
        localReqBody.uint64_group.set(l1, true);
        localReqBody.uint32_portal.set(paramInt, true);
        if (paramSendFlowerReq == null) {
          break label149;
        }
        localReqBody.msg_send_flower = paramSendFlowerReq;
        paramInt = 0;
        if (paramInt != -1) {
          break label166;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. serviceType=" + paramInt);
        return;
      }
      catch (NumberFormatException paramSendFlowerReq) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. NumberFormatException troopUin=" + paramString);
      return;
      label149:
      if (paramThrowFlowerReq != null)
      {
        localReqBody.msg_throw_flower = paramThrowFlowerReq;
        paramInt = 1;
        continue;
        label166:
        localReqBody.bytes_user_ip.set(ByteStringMicro.copyFrom("".getBytes()), true);
        localReqBody.bytes_version.set(ByteStringMicro.copyFrom("".getBytes()), true);
        localReqBody.uint32_client.set(1, true);
        localReqBody.uint32_instance_id.set(-1, true);
        paramSendFlowerReq = new oidb_0x6b6.ExtParam();
        paramString = (TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
        if (paramString != null) {}
        for (paramString = paramString.getSkey(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());; paramString = "")
        {
          paramThrowFlowerReq = new oidb_0x6b6.LoginSig();
          paramThrowFlowerReq.uint32_type.set(1);
          paramThrowFlowerReq.uint32_appid.set(0);
          if (!TextUtils.isEmpty(paramString)) {
            paramThrowFlowerReq.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramString));
          }
          paramSendFlowerReq.msg_login_sig.set(paramThrowFlowerReq);
          localReqBody.msg_ext_param.set(paramSendFlowerReq);
          paramString = new oidb_sso.OIDBSSOPkg();
          paramString.uint32_command.set(1718);
          paramString.uint32_service_type.set(paramInt);
          paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
          paramSendFlowerReq = a("OidbSvc.0x6b6");
          paramSendFlowerReq.putWupBuffer(paramString.toByteArray());
          paramSendFlowerReq.extraData.putInt("subCmd", paramInt);
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. serviceType=" + paramInt);
          }
          b(paramSendFlowerReq);
          return;
        }
      }
      else
      {
        paramInt = -1;
      }
    }
  }
  
  public void a(String paramString, int paramInt, oidb_0x6c3.GetStockReq paramGetStockReq, oidb_0x6c3.GetExtraDataReq paramGetExtraDataReq)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6c3. troopUin is null");
      }
      return;
    }
    oidb_0x6c3.ReqBody localReqBody = new oidb_0x6c3.ReqBody();
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf(paramString).longValue();
        localReqBody.uint64_group.set(l1, true);
        localReqBody.uint32_portal.set(paramInt, true);
        if (paramGetStockReq == null) {
          break label149;
        }
        localReqBody.msg_get_stock = paramGetStockReq;
        paramInt = 0;
        if (paramInt != -1) {
          break label166;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6c3. serviceType=" + paramInt);
        return;
      }
      catch (NumberFormatException paramGetStockReq) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6c3. NumberFormatException troopUin=" + paramString);
      return;
      label149:
      if (paramGetExtraDataReq != null)
      {
        localReqBody.msg_extra_data = paramGetExtraDataReq;
        paramInt = 1;
        continue;
        label166:
        localReqBody.bytes_user_ip.set(ByteStringMicro.copyFrom("".getBytes()), true);
        localReqBody.bytes_version.set(ByteStringMicro.copyFrom("".getBytes()), true);
        localReqBody.uint32_client.set(1, true);
        localReqBody.uint32_instance_id.set(-1, true);
        paramGetStockReq = new oidb_0x6c3.ExtParam();
        paramString = (TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
        if (paramString != null) {}
        for (paramString = paramString.getSkey(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());; paramString = "")
        {
          paramGetExtraDataReq = new oidb_0x6c3.LoginSig();
          paramGetExtraDataReq.uint32_type.set(1);
          paramGetExtraDataReq.uint32_appid.set(0);
          if (!TextUtils.isEmpty(paramString)) {
            paramGetExtraDataReq.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramString));
          }
          paramGetStockReq.msg_login_sig.set(paramGetExtraDataReq);
          localReqBody.msg_ext_param.set(paramGetStockReq);
          paramString = new oidb_sso.OIDBSSOPkg();
          paramString.uint32_command.set(1731);
          paramString.uint32_service_type.set(paramInt);
          paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
          paramGetStockReq = a("OidbSvc.0x6c3");
          paramGetStockReq.putWupBuffer(paramString.toByteArray());
          paramGetStockReq.extraData.putInt("subCmd", paramInt);
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0x6c3. serviceType=" + paramInt);
          }
          b(paramGetStockReq);
          return;
        }
      }
      else
      {
        paramInt = -1;
      }
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troopgroup_vedio.invite", 2, " troopUin:" + paramString1 + ",inviterUin:" + paramLong + ", inviteId:" + paramString2);
    }
    cmd0x6d1.ReqBody localReqBody = new cmd0x6d1.ReqBody();
    cmd0x6d1.DealInviteReqBody localDealInviteReqBody = new cmd0x6d1.DealInviteReqBody();
    try
    {
      localDealInviteReqBody.uint64_group_code.set(Long.parseLong(paramString1));
      localDealInviteReqBody.str_id.set(paramString2);
      localDealInviteReqBody.uint64_uin.set(paramLong);
      localDealInviteReqBody.uint32_deal_result.set(paramInt);
      localReqBody.deal_invite_req_body.set(localDealInviteReqBody);
      localReqBody.uint32_app_type.set(2);
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(1745);
      paramString1.uint32_service_type.set(3);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramString2 = a("OidbSvc.0x6d1_3");
      paramString2.putWupBuffer(paramString1.toByteArray());
      b(paramString2);
      return;
    }
    catch (NumberFormatException paramString2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, " NumberFormatException, troopUin:" + paramString1);
    }
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("hw_troop", 2, "getTroopClassType, troopCode = " + paramString);
      }
      long l1 = Long.parseLong(paramString);
      paramString = a("ProfileService.ReqBatchProcess");
      paramString.extraData.putLong("troop_code", l1);
      paramString.extraData.putBoolean("param_get_troop_class_type", true);
      paramString.extraData.putBoolean("is_admin", true);
      paramString.extraData.putBoolean("isFromMsg0x26", paramBoolean.booleanValue());
      a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("hw_troop", 2, "getTroopClassType:" + paramString.toString());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = new cmd0x8a7.ReqBody();
    ((cmd0x8a7.ReqBody)localObject).uint32_sub_cmd.set(1);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_uin.set(2);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_group.set(1);
    try
    {
      ((cmd0x8a7.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((cmd0x8a7.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString2));
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2215);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(0);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8a7.ReqBody)localObject).toByteArray()));
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x8a7_0");
      ((ToServiceMsg)localObject).extraData.putString("troopCode", paramString2);
      ((ToServiceMsg)localObject).putWupBuffer(paramString1.toByteArray());
      b((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", troopUin : " + paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x406_3");
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1030);
    localOIDBSSOPkg.uint32_service_type.set(3);
    cmd0x406.ReqBody localReqBody = new cmd0x406.ReqBody();
    cmd0x406.GroupFeeMemberListQuery localGroupFeeMemberListQuery = new cmd0x406.GroupFeeMemberListQuery();
    localGroupFeeMemberListQuery.string_project_id.set(paramString2);
    localGroupFeeMemberListQuery.uint32_member_type.set(paramInt);
    localGroupFeeMemberListQuery.uint32_page_index.set(0);
    localGroupFeeMemberListQuery.uint32_page_size.set(-1);
    try
    {
      localReqBody.uint64_group_id.set(Long.valueOf(paramString1).longValue());
      localReqBody.msg_member_list.set(localGroupFeeMemberListQuery);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
      b(localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.troop_fee", 2, "getTroopFeeMembers, troopUin: " + paramString1 + " troopFeeId: " + paramString2);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler.troop.troop_fee", 2, "NumberFormatException!getTroopFeeMembers, troopUin: " + paramString1 + " troopFeeId: " + paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.closeRcvMsgTmp", 2, "send_oidb_0xa80_0:" + paramString1 + "," + paramString2 + "," + paramInt1);
    }
    if (paramInt1 == 1) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramString2);
        long l2 = Long.parseLong(paramString1);
        localObject2 = new oidb_cmd0xa80.MemberInfo();
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint64_member_uin.set(l1);
        if (paramInt2 != 0) {
          continue;
        }
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint32_heartbeat_time.set((int)(System.currentTimeMillis() / 1000L));
        Object localObject1 = new oidb_cmd0xa80.ReqGroupInfo();
        ((oidb_cmd0xa80.ReqGroupInfo)localObject1).rpt_msg_member_info.add((MessageMicro)localObject2);
        ((oidb_cmd0xa80.ReqGroupInfo)localObject1).uint64_group_code.set(l2);
        ((oidb_cmd0xa80.ReqGroupInfo)localObject1).uint32_op.set(paramInt1);
        localObject2 = new oidb_cmd0xa80.ReqBody();
        ((oidb_cmd0xa80.ReqBody)localObject2).rpt_msg_req_group_info.add((MessageMicro)localObject1);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2688);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xa80.ReqBody)localObject2).toByteArray()));
        localObject2 = a("OidbSvc.0xa80_0");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString1);
        ((ToServiceMsg)localObject2).extraData.putString("memberUin", paramString2);
        ((ToServiceMsg)localObject2).extraData.putInt("cmd", paramInt1);
        b((ToServiceMsg)localObject2);
        return;
      }
      catch (Exception paramString1)
      {
        long l1;
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(".troop.closeRcvMsgTmp", 2, "send_oidb_0xa80_0:" + paramString1.toString());
      }
      if (paramInt1 == 0)
      {
        l1 = System.currentTimeMillis();
        if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)) && (l1 - ((Long)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).longValue() < 15000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.closeRcvMsgTmp", 2, "send 0xa80cmd==0 less 15s");
          }
        }
        else
        {
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, Long.valueOf(l1));
          continue;
          ((oidb_cmd0xa80.MemberInfo)localObject2).uint64_group_msg_mask.set(paramInt2);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6c2. troopUin=" + paramString1 + " giftBagID=" + paramString2);
      }
      label57:
      return;
    }
    oidb_0x6c2.ReqBody localReqBody = new oidb_0x6c2.ReqBody();
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf(paramString1).longValue();
        localReqBody.uint64_group_id.set(l1, true);
        localReqBody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
        localReqBody.uint32_channel.set(1, true);
        paramString1 = (TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
        if (paramString1 == null) {
          break label357;
        }
        paramString1 = paramString1.getSkey(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        paramString2 = new oidb_0x6c2.LoginSig();
        paramString2.uint32_type.set(1);
        paramString2.uint32_appid.set(0);
        if (!TextUtils.isEmpty(paramString1)) {
          paramString2.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramString1));
        }
        localReqBody.msg_login_sig.set(paramString2);
        switch (paramInt3)
        {
        default: 
          paramString1 = new oidb_sso.OIDBSSOPkg();
          paramString1.uint32_command.set(1730);
          paramString1.uint32_service_type.set(paramInt3);
          paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
          paramString2 = a("OidbSvc.0x6c2");
          paramString2.putWupBuffer(paramString1.toByteArray());
          paramString2.extraData.putInt("subCmd", paramInt3);
          b(paramString2);
          if (!QLog.isColorLevel()) {
            break label57;
          }
          QLog.i(".troop.send_gift", 2, "send_oidb_0x6c2. serviceType=" + paramInt3);
          return;
        }
      }
      catch (NumberFormatException paramString2) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6c2. NumberFormatException troopUin=" + paramString1);
      return;
      label357:
      paramString1 = "";
      continue;
      localReqBody.int32_page_index.set(paramInt1, true);
      localReqBody.int32_page_size.set(paramInt2, true);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("joinGroup", 2, "sourceID:" + paramInt);
    }
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 1);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("back_msg", paramString2);
    localToServiceMsg.extraData.putInt("stat_option", paramInt);
    localToServiceMsg.extraData.putString("join_group_key", paramString3);
    if (paramArrayOfByte != null) {
      localToServiceMsg.extraData.putByteArray("new_Member_Msg", paramArrayOfByte);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localToServiceMsg.extraData.putString("pic_url", paramString4);
    }
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, ArrayList paramArrayList)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = a("friendlist.GetTroopAppointRemarkReq");
    localToServiceMsg.extraData.putString("GroupUin", paramString1);
    localToServiceMsg.extraData.putString("GroupCode", paramString2);
    localToServiceMsg.extraData.putByte("cRichInfo", (byte)2);
    localToServiceMsg.extraData.putSerializable("vecUinList", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1;
    long l1;
    int i1;
    if (paramBoolean2)
    {
      if (paramString2 == null) {}
      label88:
      label242:
      do
      {
        return;
        paramString1 = (String)localObject2;
        localObject1 = paramString2;
        try
        {
          paramString2 = paramString2.trim();
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          l1 = Long.parseLong(paramString2);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          Object localObject3 = new cmd0x8b4.ReqBody();
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((cmd0x8b4.ReqBody)localObject3).uint64_gc.set(l1);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          Object localObject4 = ((cmd0x8b4.ReqBody)localObject3).uint32_flag;
          if (paramBoolean1 != true) {
            break;
          }
          i1 = 1;
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((PBUInt32Field)localObject4).set(i1);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          localObject4 = new oidb_sso.OIDBSSOPkg();
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((oidb_sso.OIDBSSOPkg)localObject4).uint32_command.set(2228);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((oidb_sso.OIDBSSOPkg)localObject4).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject3).toByteArray()));
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((oidb_sso.OIDBSSOPkg)localObject4).uint32_service_type.set(2);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          localObject2 = a("OidbSvc.0x8b4");
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject4).toByteArray());
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((ToServiceMsg)localObject2).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          localObject3 = ((ToServiceMsg)localObject2).extraData;
          if (paramBoolean1 != true) {
            break label410;
          }
          i1 = 1;
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((Bundle)localObject3).putInt("reqType", i1);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((ToServiceMsg)localObject2).extraData.putString("troop_uin", paramString2);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          b((ToServiceMsg)localObject2);
        }
        catch (NumberFormatException paramString2)
        {
          for (;;)
          {
            localObject2 = paramString1;
            paramString2 = (String)localObject1;
            if (QLog.isColorLevel())
            {
              QLog.e("TroopHandler", 2, "NumberFormatException");
              localObject2 = paramString1;
              paramString2 = (String)localObject1;
            }
          }
        }
      } while (!QLog.isColorLevel());
      localObject1 = new StringBuilder("switchTroopShowExternalStatus, requset begin==>").append("ssoSeq:");
      if (localObject2 != null) {
        break label827;
      }
      paramString1 = "null";
      label321:
      localObject1 = ((StringBuilder)localObject1).append(paramString1).append("|ServiceCmd:");
      if (localObject2 != null) {
        break label839;
      }
    }
    label410:
    label490:
    label821:
    label827:
    label839:
    for (paramString1 = "null";; paramString1 = ((ToServiceMsg)localObject2).getServiceCmd())
    {
      QLog.d("TroopHandler.troop.set_show_external_status", 2, paramString1 + "|beforeJoinedTroop:" + paramBoolean2 + "|troopUin:" + paramString2 + "|reqType:" + paramBoolean1 + "|timestamp:" + NetConnInfoCenter.getServerTime());
      return;
      i1 = 0;
      break label88;
      i1 = 0;
      break label242;
      if (paramString1 == null) {
        break;
      }
      localObject1 = new oidb_0x5d6.SnsUpdateItem();
      ((oidb_0x5d6.SnsUpdateItem)localObject1).uint32_update_sns_type.set(13571);
      l1 = NetConnInfoCenter.getServerTime();
      localObject2 = new byte[5];
      if (paramBoolean1)
      {
        localObject2[0] = 1;
        localObject2[1] = ((byte)(int)(l1 >> 24 & 0xFF));
        localObject2[2] = ((byte)(int)(l1 >> 16 & 0xFF));
        localObject2[3] = ((byte)(int)(l1 >> 8 & 0xFF));
        localObject2[4] = ((byte)(int)(0xFF & l1));
        ((oidb_0x5d6.SnsUpdateItem)localObject1).uint32_value_offset.set(1);
        ((oidb_0x5d6.SnsUpdateItem)localObject1).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject2));
        localObject2 = new ArrayList();
        ((List)localObject2).add(localObject1);
        localObject1 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject1).uint64_uin.set(BizTroopHandler.a(paramString1));
        ((oidb_0x5d6.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.set((List)localObject2);
        paramString1 = new ArrayList();
        paramString1.add(localObject1);
        localObject1 = new oidb_0x5d6.ReqBody();
        ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(11);
        ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
        ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set(paramString1);
        paramString1 = new oidb_sso.OIDBSSOPkg();
        paramString1.uint32_command.set(1494);
        paramString1.uint32_result.set(0);
        paramString1.uint32_service_type.set(3);
        paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
        localObject2 = a("OidbSvc.0x5d6_3");
        ((ToServiceMsg)localObject2).extraData.putString("0x5d6_cmd_key", "setShowExternalStatus0x5d6");
        ((ToServiceMsg)localObject2).extraData.putString("troop_uin", paramString2);
        localObject1 = ((ToServiceMsg)localObject2).extraData;
        if (paramBoolean1 != true) {
          break label821;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        ((Bundle)localObject1).putInt("reqType", i1);
        ((ToServiceMsg)localObject2).extraData.putLong("timestamp", l1);
        ((ToServiceMsg)localObject2).putWupBuffer(paramString1.toByteArray());
        b((ToServiceMsg)localObject2);
        break;
        localObject2[0] = 0;
        break label490;
      }
      paramString1 = Integer.valueOf(((ToServiceMsg)localObject2).getRequestSsoSeq());
      break label321;
    }
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 4);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("Request_uin", paramString2);
    localToServiceMsg.extraData.putByteArray("Auth", paramArrayOfByte);
    localToServiceMsg.extraData.putString("back_msg", paramString3);
    localToServiceMsg.extraData.putLong("infotime", paramLong1);
    localToServiceMsg.extraData.putLong("dbid", paramLong2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 3);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putStringArrayList("frie_uins", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, ArrayList paramArrayList, String paramString2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 8);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putStringArrayList("Invite_uins", paramArrayList);
    localToServiceMsg.extraData.putString("back_msg", paramString2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramString == null) || (paramArrayList1 == null) || (paramArrayList2 == null)) {}
    while (paramArrayList1.size() != paramArrayList2.size()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList1.size())
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList1.get(i1);
      int i2 = ((Integer)paramArrayList2.get(i1)).intValue();
      stUinInfo localstUinInfo = new stUinInfo();
      localstUinInfo.cGender = localTroopMemberCardInfo.sex;
      localstUinInfo.dwuin = Long.parseLong(localTroopMemberCardInfo.memberuin);
      localstUinInfo.sEmail = localTroopMemberCardInfo.email;
      localstUinInfo.sName = localTroopMemberCardInfo.name;
      localstUinInfo.sPhone = localTroopMemberCardInfo.tel;
      localstUinInfo.sRemark = localTroopMemberCardInfo.memo;
      localstUinInfo.dwFlag = i2;
      localArrayList.add(localstUinInfo);
      i1 += 1;
    }
    paramArrayList1 = a("friendlist.ModifyGroupCardReq");
    paramArrayList1.extraData.putLong("dwZero", 0L);
    paramArrayList1.extraData.putLong("dwGroupCode", Long.parseLong(paramString));
    paramArrayList1.extraData.putSerializable("vecUinInfo", localArrayList);
    paramArrayList1.extraData.putLong("dwNewSeq", 0L);
    a(paramArrayList1);
  }
  
  public void a(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList3 == null)) {}
    while ((paramArrayList1.size() != paramArrayList2.size()) || (paramArrayList1.size() != paramArrayList3.size())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramArrayList1.size())
    {
      String str = (String)paramArrayList1.get(i1);
      Object localObject = paramArrayList2.get(i1);
      int i2 = ((Integer)paramArrayList3.get(i1)).intValue();
      stUinInfo localstUinInfo = new stUinInfo();
      localstUinInfo.dwuin = Long.parseLong(str);
      switch (i2)
      {
      }
      for (;;)
      {
        localArrayList.add(localstUinInfo);
        i1 += 1;
        break;
        localstUinInfo.dwFlag = 1L;
        localstUinInfo.sName = ((String)localObject);
        continue;
        localstUinInfo.dwFlag = 2L;
        localstUinInfo.cGender = ((Byte)localObject).byteValue();
        continue;
        localstUinInfo.dwFlag = 4L;
        localstUinInfo.sName = ((String)localObject);
        continue;
        localstUinInfo.dwFlag = 8L;
        localstUinInfo.sName = ((String)localObject);
        continue;
        localstUinInfo.dwFlag = 16L;
        localstUinInfo.sName = ((String)localObject);
      }
    }
    paramArrayList1 = a("friendlist.ModifyGroupCardReq");
    paramArrayList1.extraData.putLong("dwZero", 0L);
    paramArrayList1.extraData.putLong("dwGroupCode", Long.parseLong(paramString));
    paramArrayList1.extraData.putSerializable("vecUinInfo", localArrayList);
    paramArrayList1.extraData.putLong("dwNewSeq", 0L);
    a(paramArrayList1);
  }
  
  public void a(String paramString, List paramList)
  {
    long l2 = -1L;
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopgetnews.", 2, "send_oidb_0x8c9_2, troopUin = " + paramString + ", appIds : " + paramList);
    }
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (str != null) {}
    for (;;)
    {
      try
      {
        l1 = Long.valueOf(str).longValue();
        if (paramString != null) {
          l2 = Long.valueOf(paramString).longValue();
        }
        paramString = new oidb_0x8c9.ReqBody();
        paramString.opt_uint64_from_uin.set(l1);
        paramString.opt_uint64_group_code.set(l2);
        paramString.rpt_uint64_appid.set(paramList);
        paramList = new oidb_sso.OIDBSSOPkg();
        paramList.uint32_command.set(2249);
        paramList.uint32_service_type.set(2);
        paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
        paramString = a("OidbSvc.0x8c9_2");
        paramString.putWupBuffer(paramList.toByteArray());
        b(paramString);
        return;
      }
      catch (Exception paramList)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.troopgetnews.", 2, "myUin error: myUin = " + str + ", strTroopUin = " + paramString);
        return;
      }
      long l1 = -1L;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "getTroopShareLink: start");
    }
    join_group_link.ReqBody localReqBody = new join_group_link.ReqBody();
    if (paramBoolean) {
      localReqBody.type.set(1);
    }
    for (;;)
    {
      localReqBody.group_code.set(Long.valueOf(paramString).longValue());
      ToServiceMsg localToServiceMsg = a("GroupSvc.JoinGroupLink");
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      localToServiceMsg.extraData.putBoolean("isVerify", paramBoolean);
      localToServiceMsg.extraData.putString("troopUin", paramString);
      b(localToServiceMsg);
      return;
      localReqBody.type.set(2);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.GetMultiTroopInfoReq");
    localToServiceMsg.extraData.putSerializable("vecGroupCode", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(SubMsgType0xab.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null) {}
    String str1;
    Object localObject;
    String str2;
    int i1;
    do
    {
      return;
      str1 = paramMsgBody.uint64_gc.get() + "";
      localObject = paramMsgBody.uint64_uin.get() + "";
      str2 = paramMsgBody.string_reward_id.get();
      i1 = paramMsgBody.uint32_reward_status.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward.push", 2, "onLinePush receive 0x210_0xab: gc=" + str1 + ", ownerUin=" + (String)localObject + ", id=" + str2 + ", status=" + i1);
      }
      paramMsgBody = (TroopRewardMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151);
      localObject = paramMsgBody.a(str1, str2);
    } while (localObject == null);
    ((MessageForTroopReward)localObject).rewardStatus = i1;
    paramMsgBody.a((MessageForTroopReward)localObject);
    a(82, true, new Object[] { str1, str2 });
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.getTroopRemark");
    localToServiceMsg.extraData.putBoolean("force_refresh", paramBoolean);
    localToServiceMsg.extraData.putLong("uin", Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localToServiceMsg.extraData.putLong("troop_uin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("troop_code", Long.parseLong(paramString2));
    a(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    a(paramBoolean, paramString1, paramString2, false, paramInt);
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || ("0".equals(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("get_troop_member", 2, "error troopuin: " + paramString1);
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troopuinerror", "gettroopmemberlist", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.getTroopMemberList");
      localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
      localToServiceMsg.extraData.putBoolean("force_refresh", paramBoolean1);
      localToServiceMsg.extraData.putBoolean("needCallBackCache", paramBoolean2);
      localToServiceMsg.extraData.putInt("reqType", paramInt);
      String str = paramString1 + "_" + paramInt;
      Bundle localBundle = localToServiceMsg.extraData;
      long l1;
      if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(str))
      {
        l1 = ((Long)this.jdField_c_of_type_JavaUtilHashMap.get(str)).longValue();
        localBundle.putLong("get_list_appoint_time", l1);
      }
      try
      {
        localToServiceMsg.extraData.putLong("uin", Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        localToServiceMsg.extraData.putLong("troop_uin", Long.parseLong(paramString1));
        localToServiceMsg.extraData.putLong("troop_code", Long.parseLong(paramString2));
        l1 = System.currentTimeMillis();
        localToServiceMsg.extraData.putLong("troop_time", l1);
        localToServiceMsg.extraData.putLong("version", 2L);
        a(localToServiceMsg);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("get_troop_member", 2, "TroopHandler.getTroopMemberList, Thread id:" + Thread.currentThread().getId() + ",threadName:" + Thread.currentThread().getName() + ", troopUin: " + paramString1 + " troopCode: " + paramString2);
        return;
        l1 = 0L;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("get_troop_member", 2, "FriendListHandler.getTroopMemberList error, NumberFormatException, troopUin: " + paramString1 + " troopCode: " + paramString2);
          }
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.troopgetnews..troop.notification_center", 4, "handleTroopNewsOnlinePush.");
    }
    Object localObject1 = new submsgtype0x26.MsgBody();
    long l1;
    label347:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            ((submsgtype0x26.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
            if (((submsgtype0x26.MsgBody)localObject1).uint32_sub_cmd.get() == 4)
            {
              if ((!((submsgtype0x26.MsgBody)localObject1).msg_subcmd_0x4_push_body.has()) && (QLog.isColorLevel())) {
                QLog.e("TroopHandler", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
              }
              paramArrayOfByte = (submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)((submsgtype0x26.MsgBody)localObject1).msg_subcmd_0x4_push_body.get();
              if ((paramArrayOfByte.msg_app_id.has()) && (paramArrayOfByte.msg_app_id.uint64_app_id.has()) && (paramArrayOfByte.uint64_group_code.has()) && (paramArrayOfByte.sint32_unread_num.has()))
              {
                l1 = paramArrayOfByte.msg_app_id.uint64_app_id.get();
                long l2 = paramArrayOfByte.uint64_group_code.get();
                if ((paramArrayOfByte.sint32_unread_num.get() == 0) && (l1 == 1102858908L)) {
                  a(62, true, new Object[] { "" + l2, Boolean.valueOf(true) }, false);
                }
              }
            }
            if ((!((submsgtype0x26.MsgBody)localObject1).uint32_sub_cmd.has()) || (((submsgtype0x26.MsgBody)localObject1).uint32_sub_cmd.get() != 1))
            {
              if (QLog.isDevelopLevel()) {
                QLog.e("Q.troopgetnews..troop.notification_center", 4, "handleTroopNewsOnlinePush : msgBody is null or NotSupportSubCMd :" + ((submsgtype0x26.MsgBody)localObject1).uint32_sub_cmd.get());
              }
              return;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.e("Q.troopgetnews..troop.notification_center", 4, "handleTroopNewsOnlinePush : fail to parse submsgtype0x26.");
            return;
          }
          try
          {
            if (((submsgtype0x26.MsgBody)localObject1).rpt_msg_subcmd_0x1_push_body.has()) {
              break label347;
            }
            if (QLog.isDevelopLevel())
            {
              QLog.i("Q.troopgetnews..troop.notification_center", 4, "rpt_msg_subcmd_0x1_push_body.has() = false");
              return;
            }
          }
          catch (Exception paramArrayOfByte) {}
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.troopgetnews..troop.notification_center", 4, "handleTroopNewsOnlinePush|exception = " + paramArrayOfByte.toString());
      return;
      paramArrayOfByte = ((submsgtype0x26.MsgBody)localObject1).rpt_msg_subcmd_0x1_push_body.get();
      if (paramArrayOfByte != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.e("Q.troopgetnews..troop.notification_center", 4, "rpt_msg_subcmd_0x1_push_body is null");
    return;
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayOfByte.iterator();
    int i1 = 0;
    paramArrayOfByte = null;
    int i2 = 0;
    label410:
    int i4;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject2 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.e("Q.troopgetnews..troop.notification_center", 4, "unreadNum is null");
          }
        }
        else
        {
          l1 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).msg_app_id.uint64_app_id.get();
          localObject1 = new TroopUnreadMsgInfo();
          ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long = l1;
          ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).uint64_group_code.get());
          ((TroopUnreadMsgInfo)localObject1).b = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).sint32_unread_num.get();
          i4 = ((TroopUnreadMsgInfo)localObject1).b;
          ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Int = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).sint32_album_cnt.get();
          long[] arrayOfLong = null;
          paramArrayOfByte = arrayOfLong;
          if (((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).msg_app_tip_notify.has())
          {
            localObject2 = (submsgtype0x26.AppTipNotify)((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).msg_app_tip_notify.get();
            paramArrayOfByte = arrayOfLong;
            if (((submsgtype0x26.AppTipNotify)localObject2).opt_msg_app_notify_content.has())
            {
              localObject2 = ((submsgtype0x26.AppNotifyContent)((submsgtype0x26.AppTipNotify)localObject2).opt_msg_app_notify_content.get()).opt_msg_app_notify_user.get();
              arrayOfLong = new long[((List)localObject2).size()];
              int i3 = 0;
              for (;;)
              {
                paramArrayOfByte = arrayOfLong;
                if (i3 >= ((List)localObject2).size()) {
                  break;
                }
                arrayOfLong[i3] = ((submsgtype0x26.AppNotifyUser)((List)localObject2).get(i3)).opt_uint64_uin.get();
                i3 += 1;
              }
            }
          }
          if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 2L)
          {
            DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_photo_new", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).b);
            DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_photo_message", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Int);
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        localStringBuilder.append("add photoinfo, groupCode = ").append(((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString).append(", appid = ").append(((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long).append(", messageNum = ").append(((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Int).append(", newPhotoes = ").append(((TroopUnreadMsgInfo)localObject1).b);
      }
      localArrayList.add(localObject1);
      i2 += i4;
      paramArrayOfByte = (byte[])localObject1;
      break label410;
      if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1L)
      {
        DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_file_new", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).b);
      }
      else if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1101236949L)
      {
        DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_notification_new", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).b);
      }
      else if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 21L)
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).b, paramArrayOfByte, 2);
      }
      else if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1104651886L)
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).b, paramArrayOfByte, 10);
      }
      else if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1101484419L)
      {
        DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "group_activity_new_message", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).b);
      }
      else if ((((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1102858908L) && (((TroopUnreadMsgInfo)localObject1).b == -1))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, Integer.valueOf(-1));
        i1 = 1;
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.troopgetnews..troop.notification_center", 4, localStringBuilder.toString());
        }
        if (i2 != 0) {
          a(30, true, new Object[] { Boolean.valueOf(true), localArrayList, Integer.valueOf(-1) });
        }
        while (i1 != 0)
        {
          a(62, true, new Object[] { paramArrayOfByte.jdField_a_of_type_JavaLangString, Boolean.valueOf(false), Boolean.valueOf(false) });
          return;
          a(30, true, new Object[] { Boolean.valueOf(true), localArrayList, Integer.valueOf(0) });
        }
        break;
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, long paramLong)
  {
    cmd0x3fe.LevelMsg localLevelMsg = new cmd0x3fe.LevelMsg();
    localLevelMsg.uint32_subcmd.set(6);
    cmd0x3fe.ReqBody localReqBody = new cmd0x3fe.ReqBody();
    int i2 = paramArrayOfLong.length;
    int i1 = 0;
    while (i1 < i2)
    {
      long l1 = paramArrayOfLong[i1];
      cmd0x3fe.UserInfo localUserInfo = new cmd0x3fe.UserInfo();
      localUserInfo.uint64_uin.set(l1);
      localReqBody.rpt_msg_user_info.add(localUserInfo);
      i1 += 1;
    }
    localReqBody.uint64_group_code.set(paramLong);
    localLevelMsg.msg_level_req.set(localReqBody);
    paramArrayOfLong = a("qunVideoOnlineLevel.0x3fe_0");
    paramArrayOfLong.putWupBuffer(localLevelMsg.toByteArray());
    b(paramArrayOfLong);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetTroopListReqV2");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.getGroupInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetMultiTroopInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.ModifyGroupCardReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.ModifyGroupInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetTroopAppointRemarkReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.getTroopMemberList");
      this.jdField_a_of_type_JavaUtilSet.add("group_member_card.get_group_member_card_info");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8a0_0");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.getTroopRemark");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88d_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x899_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88d_7");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x89e_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8b8_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8c9_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8fd_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88d_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88d_10");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.ReqBatchProcess");
      this.jdField_a_of_type_JavaUtilSet.add("GroupSvc.JoinGroupLink");
      this.jdField_a_of_type_JavaUtilSet.add("GroupOpen.CheckJsApiToken");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.GroupMngReq");
      this.jdField_a_of_type_JavaUtilSet.add("anony_msg.group");
      this.jdField_a_of_type_JavaUtilSet.add("qunVideoOnlineLevel.0x3fe_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8bb_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8bb_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8bb_7");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8b4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5d6_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x787_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8a7_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8ca_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x787_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9fa");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9ab_1");
      this.jdField_a_of_type_JavaUtilSet.add("SHomeworkSvc.querycard");
      this.jdField_a_of_type_JavaUtilSet.add("SHomeworkSvc.modifycard");
      this.jdField_a_of_type_JavaUtilSet.add("GroupOpen.ReadAppList");
      this.jdField_a_of_type_JavaUtilSet.add("GroupOpen.SortAppList");
      this.jdField_a_of_type_JavaUtilSet.add("GroupOpen.ClearRedPoint");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x406_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xa80_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ba_4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ba_7");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6b6");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6b5");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6c2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6c3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xa8d");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x711_127");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6d1_3");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "send_oidb_0x5ba:" + paramString1 + "," + paramString2 + "," + paramString3);
    }
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      Object localObject = new oidb_0x5ba.ReqBody();
      ((oidb_0x5ba.ReqBody)localObject).string_reward_id.set(paramString3);
      ((oidb_0x5ba.ReqBody)localObject).uint64_gc.set(l1);
      ((oidb_0x5ba.ReqBody)localObject).uint32_channel.set(1);
      ((oidb_0x5ba.ReqBody)localObject).uint64_request_uin.set(l2);
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1466);
      localOIDBSSOPkg.uint32_service_type.set(paramInt);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5ba.ReqBody)localObject).toByteArray()));
      localObject = a("OidbSvc.0x5ba_" + paramInt);
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("memberUin", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("rewardId", paramString3);
      ((ToServiceMsg)localObject).extraData.putInt("serviceType", paramInt);
      ((ToServiceMsg)localObject).setTimeout(30000L);
      b((ToServiceMsg)localObject);
      return true;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.troop_reward", 2, "send_oidb_0x5ba:" + paramString1.toString());
      }
    }
    return false;
  }
  
  public boolean a(String paramString, ArrayList paramArrayList, Bundle paramBundle)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "getTroopCardDefaultNickBatch uin=" + paramString + " size=" + paramArrayList.size() + " time=" + System.currentTimeMillis());
    }
    short s1 = (short)paramArrayList.size();
    if (s1 > 500) {
      return false;
    }
    long l1;
    try
    {
      l1 = Long.parseLong(paramString);
      localObject1 = new oidb_0x787.ReqBody();
      ((oidb_0x787.ReqBody)localObject1).uint64_group_code.set(l1);
      ((oidb_0x787.ReqBody)localObject1).uint64_begin_uin.set(0L);
      ((oidb_0x787.ReqBody)localObject1).uint64_data_time.set(0L);
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        try
        {
          l1 = Long.parseLong(str);
          ((oidb_0x787.ReqBody)localObject1).rpt_uin_list.add(Long.valueOf(l1));
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler", 2, "getTroopCardDefaultNickBatch parseLong err uin=" + str, localException);
        }
      }
      localObject2 = new oidb_0x787.Filter();
    }
    catch (Exception paramString)
    {
      return false;
    }
    ((oidb_0x787.Filter)localObject2).uint32_member_level_info_uin.set(1);
    ((oidb_0x787.Filter)localObject2).uint32_member_level_info_name.set(1);
    ((oidb_0x787.Filter)localObject2).uint32_nick_name.set(1);
    ((oidb_0x787.ReqBody)localObject1).opt_filter.set((MessageMicro)localObject2);
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1927);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject1).toByteArray()));
    Object localObject1 = a("OidbSvc.0x787_1");
    if (paramBundle != null)
    {
      int i1 = paramBundle.getInt(ContactUtils.jdField_a_of_type_JavaLangString, ContactUtils.x);
      l1 = paramBundle.getLong(ContactUtils.b, 0L);
      ((ToServiceMsg)localObject1).extraData.putInt(ContactUtils.jdField_a_of_type_JavaLangString, i1);
      ((ToServiceMsg)localObject1).extraData.putLong(ContactUtils.b, l1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.revoked_msg_get_troop_mem_card", 2, "extraNotifyTarget:" + i1 + "|uniseq:" + l1);
      }
    }
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject1).extraData.putStringArrayList("batchuin", paramArrayList);
    ((ToServiceMsg)localObject1).extraData.putShort("uincount", s1);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
    return true;
  }
  
  protected void b()
  {
    TroopOrgProtocolManager localTroopOrgProtocolManager = (TroopOrgProtocolManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(136);
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.trooptag_troop_org", 2, "hasOrgTroopInTroopList: false");
    }
    localTroopOrgProtocolManager.a(null, 0L, 1, false, new qhl(this, localTroopOrgProtocolManager));
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopgetnews.", 2, "send_oidb_0xf110_1 troopCode = " + paramLong);
    }
    Object localObject1 = (TroopAppMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
    if ((localObject1 != null) && (((TroopAppMgr)localObject1).a(1104445552) != null)) {
      return;
    }
    Object localObject2 = new oidb_0x9ab.ReqBody();
    ((oidb_0x9ab.ReqBody)localObject2).uint64_group_code.set(paramLong);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2475);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9ab.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x9ab_1");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    b((ToServiceMsg)localObject2);
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    Object localObject1 = new oidb_0x9fa.ReqBody();
    ((oidb_0x9fa.ReqBody)localObject1).uint32_appid.set(1);
    ((oidb_0x9fa.ReqBody)localObject1).uint32_cmdid.set(6);
    ((oidb_0x9fa.ReqBody)localObject1).int32_channel.set(3);
    Object localObject2 = new oidb_0x9fa.GetSimilarGroupWebInfo();
    ((oidb_0x9fa.GetSimilarGroupWebInfo)localObject2).uint64_group_code.set(paramLong1);
    ((oidb_0x9fa.GetSimilarGroupWebInfo)localObject2).uint64_uin.set(paramLong2);
    ((oidb_0x9fa.ReqBody)localObject1).msg_get_web_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2554);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9fa.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x9fa");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(3000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt1, List paramList, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("send_oidb_0x899_0").append("|troopuin = ").append(paramLong1).append("|flag = ").append(paramInt1).append("|nStartUin = ").append(paramLong2).append("|memberNum = ").append(paramInt2).append("|filterMethod = ").append(paramInt3);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject).toString());
    }
    oidb_0x899.memberlist localmemberlist = new oidb_0x899.memberlist();
    localmemberlist.uint64_member_uin.set(0L);
    localmemberlist.uint32_shutup_timestap.set(0);
    Object localObject = new oidb_0x899.ReqBody();
    ((oidb_0x899.ReqBody)localObject).uint64_group_code.set(paramLong1);
    ((oidb_0x899.ReqBody)localObject).uint64_start_uin.set(paramLong2);
    if (paramInt1 == 3)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Long localLong = (Long)paramList.next();
        ((oidb_0x899.ReqBody)localObject).rpt_uint64_uin_list.add(localLong);
      }
    }
    ((oidb_0x899.ReqBody)localObject).uint32_identify_flag.set(paramInt1);
    ((oidb_0x899.ReqBody)localObject).memberlist_opt.set(localmemberlist);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2201);
    paramList.uint32_result.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x899.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x899_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("troop_uin", paramLong1);
    ((ToServiceMsg)localObject).extraData.putInt("nFlag", paramInt1);
    ((ToServiceMsg)localObject).extraData.putLong("nStartUin", paramLong2);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp:");
    }
    int i1 = paramToServiceMsg.extraData.getInt("appid");
    String str1 = paramToServiceMsg.extraData.getString("openId");
    String str2 = paramToServiceMsg.extraData.getString("token");
    int i2 = paramToServiceMsg.extraData.getInt("seq");
    if (!paramFromServiceMsg.isSuccess())
    {
      a(84, false, new Object[] { Integer.valueOf(i1), str1, str2, "", Integer.valueOf(i2), Integer.valueOf(paramFromServiceMsg.getResultCode()), null });
      return;
    }
    for (paramToServiceMsg = new oidb_sso.OIDBSSOPkg();; paramToServiceMsg = new ProfileActivity.AllInOne((String)paramObject, 78)) {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        int i3 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp, resultCode:" + i3);
        }
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        if (i3 != 0) {
          break;
        }
        paramObject = new byte[4];
        System.arraycopy(paramToServiceMsg, 0, paramObject, 0, 4);
        paramObject = ByteBuffer.wrap((byte[])paramObject).getInt() + "";
        Friends localFriends = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c((String)paramObject);
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          paramToServiceMsg = new ProfileActivity.AllInOne((String)paramObject, 1);
          paramToServiceMsg.h = localFriends.name;
          paramToServiceMsg.i = localFriends.remark;
          a(84, true, new Object[] { Integer.valueOf(i1), str1, str2, paramObject, Integer.valueOf(i2), Integer.valueOf(paramFromServiceMsg.getResultCode()), paramToServiceMsg });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp, uin:" + (String)paramObject);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troopTAG_GET_UIN_BY_OPEN_ID", 2, "pkg.mergeFrom:" + paramToServiceMsg.toString());
        }
        a(84, false, new Object[] { Integer.valueOf(i1), str1, str2, "", Integer.valueOf(i2), Integer.valueOf(paramFromServiceMsg.getResultCode()), null });
        return;
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_admin_max_num.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putString("troop_code", paramString);
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 2);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void b(String paramString, int paramInt)
  {
    a(52, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).uint32_app_privilege_flag.set(0);
    Object localObject2 = new oidb_0x88d.GroupExInfoOnly();
    ((oidb_0x88d.GroupExInfoOnly)localObject2).uint32_money_for_add_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).st_group_ex_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString1));
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
    localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString1));
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 7);
    ((ToServiceMsg)localObject1).extraData.putString("processName", paramString2);
    ((ToServiceMsg)localObject1).extraData.putBoolean("needUpdatePreferences", false);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void b(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 6);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("Request_uin", paramString2);
    localToServiceMsg.extraData.putByteArray("Auth", paramArrayOfByte);
    localToServiceMsg.extraData.putString("back_msg", paramString3);
    localToServiceMsg.extraData.putLong("infotime", paramLong1);
    localToServiceMsg.extraData.putLong("dbid", paramLong2);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).string_group_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_face.set(0);
    Object localObject2 = new oidb_0x88d.GroupGeoInfo();
    ((oidb_0x88d.GroupGeoInfo)localObject2).bytes_geocontent.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupGeoInfo)localObject2).int64_latitude.set(0L);
    ((oidb_0x88d.GroupGeoInfo)localObject2).int64_longitude.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).group_geo_info.set((MessageMicro)localObject2);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flag_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).string_certification_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint64_group_owner.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_class_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_type_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_shutup_timestamp.set(1);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
    localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(200000020);
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    if (paramBoolean) {
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(19);
    }
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 4);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.troop_app", 2, "getTroopAppList: start");
    }
    cmd0xca05.ReqBody localReqBody = new cmd0xca05.ReqBody();
    localReqBody.uint32_type.set(0);
    Object localObject = new cmd0xca05.AppInfo();
    ((cmd0xca05.AppInfo)localObject).plat_type.set(2);
    ((cmd0xca05.AppInfo)localObject).str_app_version.set("6.5.5");
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localObject = (Integer)paramArrayList.get(i1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.troop_app", 2, "redPoint appid:" + localObject);
      }
      localReqBody.rpt_app_ids.add(Long.valueOf(((Integer)localObject).intValue() + 0L));
      i1 += 1;
    }
    localObject = a("GroupOpen.ClearRedPoint");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putIntegerArrayList("appids", paramArrayList);
    b((ToServiceMsg)localObject);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.GetTroopListReqV2");
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.extraData.putByte("bGetMSFMsgFlag", (byte)0);
    localToServiceMsg.extraData.putByte("bGroupFlagExt", (byte)1);
    if (paramArrayOfByte != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localToServiceMsg.extraData.putByteArray("vecCookies", paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("Q.getTroopList", 2, "get troop list, cookie != null");
      }
    }
    for (;;)
    {
      a(localToServiceMsg);
      return;
      this.jdField_a_of_type_Boolean = true;
      paramArrayOfByte = new ArrayList();
      Object localObject1 = ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a();
      Object localObject2;
      if (localObject1 != null)
      {
        boolean bool = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "load_trooplist", 0).getBoolean("load_all_3", true);
        int i1 = 0;
        if (i1 < ((List)localObject1).size())
        {
          localObject2 = (TroopInfo)((List)localObject1).get(i1);
          if (localObject2 == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(((TroopInfo)localObject2).troopuin))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.getTroopList", 2, "getTroopList.hotchat troopuin=" + ((TroopInfo)localObject2).troopuin);
              }
            }
            else
            {
              stTroopNum localstTroopNum = new stTroopNum();
              try
              {
                localstTroopNum.GroupCode = Long.parseLong(((TroopInfo)localObject2).troopuin);
                if (!bool)
                {
                  localstTroopNum.dwGroupInfoSeq = ((TroopInfo)localObject2).dwGroupInfoSeq;
                  localstTroopNum.dwGroupRankSeq = ((TroopInfo)localObject2).dwGroupLevelSeq;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.getTroopList", 2, "dwGroupInfoSeq = " + localstTroopNum.dwGroupInfoSeq + ",dwGroupRankSeq = " + localstTroopNum.dwGroupRankSeq);
                }
                localstTroopNum.dwGroupFlagExt = ((TroopInfo)localObject2).dwGroupFlagExt;
                paramArrayOfByte.add(localstTroopNum);
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.getTroopList", 2, "dwGroupRankSeq: " + ((TroopInfo)localObject2).dwGroupLevelSeq);
              }
              catch (NumberFormatException localNumberFormatException) {}
              if (QLog.isColorLevel()) {
                QLog.d("Q.getTroopList", 2, "NumberFormatException,info.troopuin=" + ((TroopInfo)localObject2).troopuin);
              }
            }
          }
        }
      }
      if (!paramArrayOfByte.isEmpty()) {
        localToServiceMsg.extraData.putSerializable("vecGroupInfo", paramArrayOfByte);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayOfByte.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((StringBuilder)localObject1).append(((stTroopNum)((Iterator)localObject2).next()).GroupCode).append(";");
        }
        QLog.d("Q.getTroopList", 2, "get troop list, cookie == null, request size: " + paramArrayOfByte.size() + " request troop uins: " + ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    hw_sso.HwSSOReq localHwSSOReq = new hw_sso.HwSSOReq();
    Object localObject = new group_mgr.HwQueryCardReq();
    ((group_mgr.HwQueryCardReq)localObject).gid.set(paramLong1);
    ((group_mgr.HwQueryCardReq)localObject).target_uin.set(paramLong2);
    localHwSSOReq.cmd.set("querycard");
    localHwSSOReq.body.set(ByteStringMicro.copyFrom(((group_mgr.HwQueryCardReq)localObject).toByteArray()));
    localObject = a("SHomeworkSvc.querycard");
    ((ToServiceMsg)localObject).putWupBuffer(localHwSSOReq.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : data==null");
      }
      a(76, false, null);
    }
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : resp.isSuccess=" + paramFromServiceMsg.isSuccess());
        }
        if (!paramFromServiceMsg.isSuccess())
        {
          a(76, false, null);
          return;
        }
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = paramFromServiceMsg;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          for (;;)
          {
            int i1;
            int i2;
            if (QLog.isColorLevel()) {
              QLog.d("Q.troopdisband.", 2, "handleTroopFeeMemberListQuery|oidb_sso parseFrom byte " + paramFromServiceMsg.toString());
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            a(76, false, null);
          }
          a(76, false, null);
        }
        i1 = -1;
        if (paramToServiceMsg != null)
        {
          i2 = paramToServiceMsg.uint32_result.get();
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.troopdisband.", 2, "handleTroopFeeMemberListQuery|oidb_sso.OIDBSSOPkg.result " + i2);
            i1 = i2;
          }
        }
        if (i1 != 0) {
          break label364;
        }
        paramFromServiceMsg = new cmd0x406.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          i1 = paramFromServiceMsg.uint32_ret.get();
          if (i1 != 0) {
            break label353;
          }
          a(76, true, ((cmd0x406.GroupFeeMemberListResult)paramFromServiceMsg.msg_member_list.get()).msg_member_list.get());
          if (QLog.isColorLevel())
          {
            QLog.d("TroopHandler.troop.troop_fee", 2, "ret :" + i1 + ",msg:" + paramFromServiceMsg.string_msg.get().toString());
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          a(76, false, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : InvalidProtocolBufferMicroException");
    return;
    label353:
    label364:
    return;
  }
  
  public void c(String paramString)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).string_group_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_face.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_type_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).string_certification_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(0L);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_class_ext.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(10);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_10");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
    b((ToServiceMsg)localObject2);
  }
  
  public void c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6b5. troopUin=" + paramString1 + " giftBagID=" + paramString2);
      }
      return;
    }
    oidb_0x6b5.ReqBody localReqBody = new oidb_0x6b5.ReqBody();
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf(paramString1).longValue();
        localReqBody.uint64_group_id.set(l1, true);
        localReqBody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
        localReqBody.uint32_channel.set(1, true);
        paramString1 = (TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
        if (paramString1 == null) {
          break label312;
        }
        paramString1 = paramString1.getSkey(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        paramString2 = new oidb_0x6b5.LoginSig();
        paramString2.uint32_type.set(1);
        paramString2.uint32_appid.set(0);
        if (!TextUtils.isEmpty(paramString1)) {
          paramString2.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramString1));
        }
        localReqBody.msg_login_sig.set(paramString2);
        paramString1 = new oidb_sso.OIDBSSOPkg();
        paramString1.uint32_command.set(1717);
        paramString1.uint32_service_type.set(0);
        paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
        paramString2 = a("OidbSvc.0x6b5");
        paramString2.putWupBuffer(paramString1.toByteArray());
        paramString2.extraData.putInt("subCmd", 0);
        b(paramString2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b5.");
        return;
      }
      catch (NumberFormatException paramString2) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6b5. NumberFormatException troopUin=" + paramString1);
      return;
      label312:
      paramString1 = "";
    }
  }
  
  public void c(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 5);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("Request_uin", paramString2);
    localToServiceMsg.extraData.putByteArray("Auth", paramArrayOfByte);
    localToServiceMsg.extraData.putString("back_msg", paramString3);
    localToServiceMsg.extraData.putLong("infotime", paramLong1);
    localToServiceMsg.extraData.putLong("dbid", paramLong2);
    a(localToServiceMsg);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "getTroopLevelSwitchAndMap net disabble, return:" + paramString);
        }
        return;
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break label395;
      }
    }
    label395:
    for (long l1 = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();; l1 = 0L)
    {
      if (System.currentTimeMillis() - l1 < 30000L)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.getTroopMemberLevelInfo", 2, "getTroopLevelSwitchAndMap: lastReq < 30s, return:" + paramString);
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      Object localObject2 = new oidb_0x787.Filter();
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_uin.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_point.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_active_day.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_level.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_level_name.set(1);
      ((oidb_0x787.Filter)localObject2).uint32_data_time.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_sys_show_flag.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_user_show_flag.set(0);
      Object localObject1 = new oidb_0x787.ReqBody();
      ((oidb_0x787.ReqBody)localObject1).uint64_group_code.set(Long.parseLong(paramString));
      ((oidb_0x787.ReqBody)localObject1).uint64_begin_uin.set(0L);
      ((oidb_0x787.ReqBody)localObject1).uint64_data_time.set(0L);
      ((oidb_0x787.ReqBody)localObject1).rpt_uin_list.add(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
      ((oidb_0x787.ReqBody)localObject1).opt_filter.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1927);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x787_0");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.getTroopMemberLevelInfo", 2, "getTroopLevelSwitchAndMap: troopCode=" + paramString + ", isForceReq=" + paramBoolean);
      return;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "handleGetTroopMemberCard : data==null");
      }
      a(50, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "handleGetTroopMemberCard : resp.isSuccess=" + paramFromServiceMsg.isSuccess());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      a(50, false, null);
      return;
    }
    paramFromServiceMsg = new group_member_info.RspBody();
    long l1;
    int i3;
    int i1;
    int i2;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        l1 = paramFromServiceMsg.uint64_group_code.get();
        i3 = paramFromServiceMsg.uint32_self_role.get();
        paramToServiceMsg = new TroopMemberCard();
        paramToServiceMsg.result = -1;
        if (paramFromServiceMsg.uint32_group_type.has()) {
          paramToServiceMsg.mGroupType = paramFromServiceMsg.uint32_group_type.get();
        }
        if (!paramFromServiceMsg.msg_meminfo.has()) {
          break label1460;
        }
        paramFromServiceMsg = (group_member_info.MemberInfo)paramFromServiceMsg.msg_meminfo.get();
        paramToServiceMsg.result = paramFromServiceMsg.uint32_result.get();
        paramToServiceMsg.isAllowModCard = paramFromServiceMsg.bool_is_allow_mod_card.get();
        paramToServiceMsg.memberUin = paramFromServiceMsg.uint64_uin.get();
        paramToServiceMsg.isFriend = paramFromServiceMsg.bool_is_friend.get();
        paramToServiceMsg.credit = paramFromServiceMsg.uint32_credit.get();
        if (!paramFromServiceMsg.uint32_concern_type.has()) {
          break label876;
        }
        i1 = paramFromServiceMsg.uint32_concern_type.get();
        if (i1 == 0)
        {
          paramToServiceMsg.isConcerned = false;
          paramToServiceMsg.mIsShield = false;
          paramToServiceMsg.sex = -1;
          if (paramFromServiceMsg.uint32_sex.has()) {
            paramToServiceMsg.sex = paramFromServiceMsg.uint32_sex.get();
          }
          paramToServiceMsg.location = "";
          if (paramFromServiceMsg.str_location.has()) {
            paramToServiceMsg.location = paramFromServiceMsg.str_location.get().toStringUtf8();
          }
          paramToServiceMsg.age = paramFromServiceMsg.uint32_age.get();
          paramToServiceMsg.nick = "";
          paramToServiceMsg.remark = "";
          paramToServiceMsg.card = "";
          if (paramFromServiceMsg.str_nick.has()) {
            paramToServiceMsg.nick = paramFromServiceMsg.str_nick.get().toStringUtf8();
          }
          if (paramFromServiceMsg.str_remark.has()) {
            paramToServiceMsg.remark = paramFromServiceMsg.str_remark.get().toStringUtf8();
          }
          if (paramFromServiceMsg.str_card.has()) {
            paramToServiceMsg.card = paramFromServiceMsg.str_card.get().toStringUtf8();
          }
          paramToServiceMsg.levelName = paramFromServiceMsg.str_lev.get().toStringUtf8();
          paramToServiceMsg.memberRole = -1;
          if (paramFromServiceMsg.uint32_role.has()) {
            paramToServiceMsg.memberRole = paramFromServiceMsg.uint32_role.get();
          }
          paramToServiceMsg.joinTime = paramFromServiceMsg.uint64_join.get();
          paramToServiceMsg.lastSpeak = paramFromServiceMsg.uint64_last_speak.get();
          paramToServiceMsg.isVip = paramFromServiceMsg.bool_is_vip.get();
          paramToServiceMsg.isYearVip = paramFromServiceMsg.bool_is_year_vip.get();
          paramToServiceMsg.isSuperVip = paramFromServiceMsg.bool_is_super_vip.get();
          paramToServiceMsg.isSuperQQ = paramFromServiceMsg.bool_is_super_qq.get();
          paramToServiceMsg.vipLevel = paramFromServiceMsg.uint32_vip_lev.get();
          paramToServiceMsg.gbarTitle = paramFromServiceMsg.str_gbar_title.get().toStringUtf8();
          paramToServiceMsg.gbarLinkUrl = paramFromServiceMsg.str_gbar_url.get().toStringUtf8();
          paramToServiceMsg.gbarCount = paramFromServiceMsg.uint32_gbar_cnt.get();
          paramToServiceMsg.gbarList = new ArrayList();
          if ((paramFromServiceMsg.uint32_special_title_expire_time.has()) && ((paramFromServiceMsg.uint32_special_title_expire_time.get() == -1) || (paramFromServiceMsg.uint32_special_title_expire_time.get() - NetConnInfoCenter.getServerTime() > 0L)))
          {
            if (paramFromServiceMsg.bytes_special_title.has()) {
              paramToServiceMsg.mUniqueTitle = paramFromServiceMsg.bytes_special_title.get().toStringUtf8();
            }
            paramToServiceMsg.mUniqueTitleExpire = paramFromServiceMsg.uint32_special_title_expire_time.get();
          }
          paramObject = paramFromServiceMsg.rpt_msg_gbar_concerned.get();
          if (paramObject == null) {
            break label1498;
          }
          i1 = ((List)paramObject).size();
          break label1492;
          if (i2 >= i1) {
            break;
          }
          localObject1 = (group_member_info.GBarInfo)((List)paramObject).get(i2);
          localObject2 = new TroopMemberCard.GBarInfo();
          ((TroopMemberCard.GBarInfo)localObject2).gbarId = ((group_member_info.GBarInfo)localObject1).uint32_gbar_id.get();
          ((TroopMemberCard.GBarInfo)localObject2).level = ((group_member_info.GBarInfo)localObject1).uint32_uin_lev.get();
          ((TroopMemberCard.GBarInfo)localObject2).headUrl = ((group_member_info.GBarInfo)localObject1).str_head_portrait.get().toStringUtf8();
          ((TroopMemberCard.GBarInfo)localObject2).name = ((group_member_info.GBarInfo)localObject1).bytes_gbar_name.get().toStringUtf8();
          paramToServiceMsg.gbarList.add(localObject2);
          i2 += 1;
          continue;
        }
        if (i1 == 1)
        {
          paramToServiceMsg.isConcerned = true;
          paramToServiceMsg.mIsShield = false;
          continue;
        }
        if (i1 != 2) {
          continue;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_troop_member", 2, "onReceive: handleGetTroopMemberCard mergeFrom:" + paramToServiceMsg.toString());
        }
        a(50, false, null);
        return;
      }
      paramToServiceMsg.isConcerned = false;
      paramToServiceMsg.mIsShield = true;
      continue;
      label876:
      paramToServiceMsg.isConcerned = paramFromServiceMsg.bool_is_concerned.get();
    }
    paramToServiceMsg.customEntryList = new ArrayList();
    paramObject = paramFromServiceMsg.rpt_msg_custom_enties.get();
    if (paramObject != null)
    {
      i1 = ((List)paramObject).size();
      break label1504;
      while (i2 < i1)
      {
        localObject1 = (group_member_info.CustomEntry)((List)paramObject).get(i2);
        localObject2 = new TroopMemberCard.CustomEntry();
        ((TroopMemberCard.CustomEntry)localObject2).label = ((group_member_info.CustomEntry)localObject1).str_name.get().toStringUtf8();
        ((TroopMemberCard.CustomEntry)localObject2).info = ((group_member_info.CustomEntry)localObject1).str_value.get().toStringUtf8();
        ((TroopMemberCard.CustomEntry)localObject2).linkUrl = ((group_member_info.CustomEntry)localObject1).str_url.get().toStringUtf8();
        ((TroopMemberCard.CustomEntry)localObject2).isClickable = ((group_member_info.CustomEntry)localObject1).bool_clicked.get();
        ((TroopMemberCard.CustomEntry)localObject2).reportId = ((group_member_info.CustomEntry)localObject1).uint64_report_id.get();
        paramToServiceMsg.customEntryList.add(localObject2);
        i2 += 1;
      }
      if ((paramFromServiceMsg.bool_location_shared.has()) && (paramFromServiceMsg.bool_location_shared.get() == true) && (paramFromServiceMsg.uint64_distance.has())) {
        paramToServiceMsg.distance = paramFromServiceMsg.uint64_distance.get();
      }
      long l2;
      for (;;)
      {
        if (paramFromServiceMsg.bytes_phone_num.has()) {
          paramToServiceMsg.phoneNumber = paramFromServiceMsg.bytes_phone_num.get().toStringUtf8();
        }
        if (!paramFromServiceMsg.msg_team_entry.has()) {
          break label1374;
        }
        paramToServiceMsg.mOrgIds.clear();
        paramObject = ((group_member_info.TeamEntry)paramFromServiceMsg.msg_team_entry.get()).rpt_uint64_depid.get().iterator();
        while (((Iterator)paramObject).hasNext())
        {
          l2 = ((Long)((Iterator)paramObject).next()).longValue();
          localObject1 = "" + l1 + l2;
          if (!paramToServiceMsg.mOrgIds.contains(localObject1)) {
            paramToServiceMsg.mOrgIds.add(localObject1);
          }
        }
        if ((paramFromServiceMsg.bool_location_shared.has()) && (!paramFromServiceMsg.bool_location_shared.get())) {
          paramToServiceMsg.distance = -1001L;
        } else {
          paramToServiceMsg.distance = -100L;
        }
      }
      paramToServiceMsg.mCurrAccountOrgIds.clear();
      paramObject = ((group_member_info.TeamEntry)paramFromServiceMsg.msg_team_entry.get()).rpt_uint64_self_depid.get().iterator();
      while (((Iterator)paramObject).hasNext())
      {
        l2 = ((Long)((Iterator)paramObject).next()).longValue();
        localObject1 = "" + l1 + l2;
        if (!paramToServiceMsg.mCurrAccountOrgIds.contains(localObject1)) {
          paramToServiceMsg.mCurrAccountOrgIds.add(localObject1);
        }
      }
      label1374:
      if (paramFromServiceMsg.bytes_job.has()) {
        paramToServiceMsg.mPosition = paramFromServiceMsg.bytes_job.get().toStringUtf8();
      }
      paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(String.valueOf(l1), String.valueOf(paramToServiceMsg.memberUin), paramToServiceMsg.card, -100, paramToServiceMsg.nick, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
      }
      label1460:
      a(50, true, new Object[] { Long.valueOf(l1), Integer.valueOf(i3), paramToServiceMsg });
      return;
      for (;;)
      {
        label1492:
        i2 = 0;
        break;
        label1498:
        i1 = 0;
      }
    }
    for (;;)
    {
      label1504:
      i2 = 0;
      break;
      i1 = 0;
    }
  }
  
  public void d(String paramString)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.set(0);
    Object localObject2 = new oidb_0x88d.GroupHeadPortrait();
    ((oidb_0x88d.GroupInfo)localObject1).msg_head_portrait.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    try
    {
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString));
      ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
      localObject1 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(7);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x88d_7");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void d(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 7);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("Request_uin", paramString2);
    localToServiceMsg.extraData.putByteArray("Auth", paramArrayOfByte);
    localToServiceMsg.extraData.putString("back_msg", paramString3);
    localToServiceMsg.extraData.putLong("infotime", paramLong1);
    localToServiceMsg.extraData.putLong("dbid", paramLong2);
    a(localToServiceMsg);
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.data", 2, "th->getTroopCreditLevel:" + paramString + ", " + paramBoolean);
    }
    try
    {
      long l1 = Long.parseLong(paramString);
      ToServiceMsg localToServiceMsg = a("ProfileService.ReqBatchProcess");
      localToServiceMsg.extraData.putLong("troop_code", l1);
      localToServiceMsg.extraData.putBoolean("param_get_credit_info", true);
      localToServiceMsg.extraData.putBoolean("is_admin", paramBoolean);
      a(localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.data", 2, "th->getTroopCreditLevel->sendReq:" + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.data", 2, "th->getTroopCreditLevel:" + paramString.toString());
      }
      a(33, false, null);
    }
  }
  
  /* Error */
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc -10
    //   6: invokevirtual 672	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   9: lstore 12
    //   11: aload_2
    //   12: invokevirtual 584	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   15: istore 14
    //   17: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +42 -> 62
    //   23: ldc_w 5089
    //   26: iconst_2
    //   27: new 422	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 5097
    //   37: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload 12
    //   42: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   45: ldc_w 887
    //   48: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload 14
    //   53: invokevirtual 572	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   56: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: lload 12
    //   64: lconst_0
    //   65: lcmp
    //   66: ifne +16 -> 82
    //   69: aload_0
    //   70: bipush 66
    //   72: iconst_0
    //   73: lload 12
    //   75: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   78: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   81: return
    //   82: iload 14
    //   84: ifne +16 -> 100
    //   87: aload_0
    //   88: bipush 66
    //   90: iconst_0
    //   91: lload 12
    //   93: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   99: return
    //   100: aload_3
    //   101: checkcast 5099	KQQ/RespBatchProcess
    //   104: astore 4
    //   106: aload 4
    //   108: getfield 5102	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   111: ifnull +14 -> 125
    //   114: aload 4
    //   116: getfield 5102	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   119: invokevirtual 1626	java/util/ArrayList:size	()I
    //   122: ifne +32 -> 154
    //   125: aload_0
    //   126: bipush 66
    //   128: iconst_0
    //   129: lload 12
    //   131: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   137: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq -59 -> 81
    //   143: ldc_w 5089
    //   146: iconst_2
    //   147: ldc_w 5104
    //   150: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: return
    //   154: aload_0
    //   155: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   158: bipush 51
    //   160: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   163: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   166: astore 5
    //   168: aload 5
    //   170: ifnull +641 -> 811
    //   173: aload 5
    //   175: new 422	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   182: lload 12
    //   184: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: ldc_w 706
    //   190: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   199: astore_2
    //   200: aload_2
    //   201: ifnonnull +32 -> 233
    //   204: aload_0
    //   205: bipush 66
    //   207: iconst_0
    //   208: lload 12
    //   210: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   213: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   216: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq -138 -> 81
    //   222: ldc_w 5089
    //   225: iconst_2
    //   226: ldc_w 5106
    //   229: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: return
    //   233: aload 4
    //   235: getfield 5102	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   238: invokevirtual 1626	java/util/ArrayList:size	()I
    //   241: istore 10
    //   243: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +31 -> 277
    //   249: ldc_w 5089
    //   252: iconst_2
    //   253: new 422	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 5108
    //   263: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: iload 10
    //   268: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: iconst_0
    //   278: istore 7
    //   280: iload 7
    //   282: iload 10
    //   284: if_icmpge +480 -> 764
    //   287: aload 4
    //   289: getfield 5102	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   292: iload 7
    //   294: invokevirtual 1967	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   297: checkcast 5110	KQQ/BatchResponse
    //   300: astore_1
    //   301: aload_1
    //   302: ifnull +10 -> 312
    //   305: aload_1
    //   306: getfield 5111	KQQ/BatchResponse:result	I
    //   309: ifeq +12 -> 321
    //   312: iload 7
    //   314: iconst_1
    //   315: iadd
    //   316: istore 7
    //   318: goto -38 -> 280
    //   321: aload_1
    //   322: getfield 5112	KQQ/BatchResponse:type	I
    //   325: iconst_1
    //   326: if_icmpne -14 -> 312
    //   329: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   332: dup
    //   333: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   336: astore_3
    //   337: aload_3
    //   338: aload_1
    //   339: getfield 5115	KQQ/BatchResponse:buffer	[B
    //   342: checkcast 407	[B
    //   345: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   348: pop
    //   349: aload_1
    //   350: getfield 5117	KQQ/BatchResponse:seq	I
    //   353: ifne -41 -> 312
    //   356: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +13 -> 372
    //   362: ldc_w 5089
    //   365: iconst_2
    //   366: ldc_w 5119
    //   369: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload_3
    //   373: ifnull -61 -> 312
    //   376: aload_3
    //   377: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   380: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   383: ifeq -71 -> 312
    //   386: aload_3
    //   387: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   390: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   393: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   396: astore_1
    //   397: new 599	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   400: dup
    //   401: invokespecial 600	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   404: astore_3
    //   405: aload_3
    //   406: aload_1
    //   407: invokevirtual 601	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   410: pop
    //   411: aconst_null
    //   412: astore_1
    //   413: aload_3
    //   414: getfield 605	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   417: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   420: astore 6
    //   422: aload 6
    //   424: ifnonnull +84 -> 508
    //   427: iconst_0
    //   428: istore 8
    //   430: goto +386 -> 816
    //   433: aload_1
    //   434: ifnonnull -122 -> 312
    //   437: iload 9
    //   439: iload 8
    //   441: if_icmpge -129 -> 312
    //   444: aload 6
    //   446: iload 9
    //   448: invokeinterface 611 2 0
    //   453: checkcast 613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   456: astore_3
    //   457: aload_3
    //   458: ifnonnull +62 -> 520
    //   461: iload 9
    //   463: iconst_1
    //   464: iadd
    //   465: istore 9
    //   467: goto -34 -> 433
    //   470: astore_1
    //   471: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq -393 -> 81
    //   477: ldc_w 5089
    //   480: iconst_2
    //   481: new 422	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 5097
    //   491: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_1
    //   495: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   498: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: return
    //   508: aload 6
    //   510: invokeinterface 665 1 0
    //   515: istore 8
    //   517: goto +299 -> 816
    //   520: aload_3
    //   521: getfield 614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   524: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   527: istore 11
    //   529: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq +290 -> 822
    //   535: ldc_w 5089
    //   538: iconst_2
    //   539: new 422	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 5121
    //   549: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: iload 11
    //   554: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: goto +259 -> 822
    //   566: iload 11
    //   568: ifne +240 -> 808
    //   571: aload_3
    //   572: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   575: invokevirtual 630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   578: ifeq +230 -> 808
    //   581: aload_3
    //   582: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   585: invokevirtual 633	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   588: checkcast 629	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   591: astore_3
    //   592: aload_3
    //   593: astore_1
    //   594: aload_3
    //   595: ifnull -134 -> 461
    //   598: aload_3
    //   599: getfield 5124	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_sec_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   602: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   605: ifeq +15 -> 620
    //   608: aload_2
    //   609: aload_3
    //   610: getfield 5124	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_sec_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   613: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   616: i2l
    //   617: putfield 2115	com/tencent/mobileqq/data/TroopInfo:troopCreditLevel	J
    //   620: aload_3
    //   621: getfield 5127	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_sec_level_info	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   624: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   627: ifeq +15 -> 642
    //   630: aload_2
    //   631: aload_3
    //   632: getfield 5127	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_sec_level_info	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   635: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   638: i2l
    //   639: putfield 2121	com/tencent/mobileqq/data/TroopInfo:troopCreditLevelInfo	J
    //   642: aload_3
    //   643: astore_1
    //   644: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   647: ifeq -186 -> 461
    //   650: ldc_w 5089
    //   653: iconst_2
    //   654: new 422	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   661: ldc_w 5129
    //   664: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload_2
    //   668: getfield 755	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   671: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: ldc_w 887
    //   677: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload_2
    //   681: getfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   684: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: ldc_w 887
    //   690: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_2
    //   694: getfield 2115	com/tencent/mobileqq/data/TroopInfo:troopCreditLevel	J
    //   697: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   700: ldc_w 887
    //   703: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload_2
    //   707: getfield 2121	com/tencent/mobileqq/data/TroopInfo:troopCreditLevelInfo	J
    //   710: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   713: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   719: aload_3
    //   720: astore_1
    //   721: goto -260 -> 461
    //   724: astore_1
    //   725: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   728: ifeq -416 -> 312
    //   731: ldc_w 5089
    //   734: iconst_2
    //   735: new 422	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   742: ldc_w 5131
    //   745: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload_1
    //   749: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   752: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   761: goto -449 -> 312
    //   764: aload 5
    //   766: ifnull +29 -> 795
    //   769: aload_2
    //   770: ifnull +25 -> 795
    //   773: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   776: ifeq +13 -> 789
    //   779: ldc_w 5089
    //   782: iconst_2
    //   783: ldc_w 5133
    //   786: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: aload 5
    //   791: aload_2
    //   792: invokevirtual 662	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   795: aload_0
    //   796: bipush 66
    //   798: iconst_1
    //   799: lload 12
    //   801: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   804: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   807: return
    //   808: goto -347 -> 461
    //   811: aconst_null
    //   812: astore_2
    //   813: goto -613 -> 200
    //   816: iconst_0
    //   817: istore 9
    //   819: goto -386 -> 433
    //   822: iload 11
    //   824: bipush 72
    //   826: if_icmpne -260 -> 566
    //   829: iload 9
    //   831: ifne -265 -> 566
    //   834: goto -373 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	this	TroopHandler
    //   0	837	1	paramToServiceMsg	ToServiceMsg
    //   0	837	2	paramFromServiceMsg	FromServiceMsg
    //   0	837	3	paramObject	Object
    //   104	184	4	localRespBatchProcess	RespBatchProcess
    //   166	624	5	localTroopManager	TroopManager
    //   420	89	6	localList	List
    //   278	39	7	i1	int
    //   428	88	8	i2	int
    //   437	393	9	i3	int
    //   241	44	10	i4	int
    //   527	300	11	i5	int
    //   9	791	12	l1	long
    //   15	68	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   337	349	470	java/lang/Exception
    //   397	411	724	java/lang/Exception
    //   413	422	724	java/lang/Exception
    //   444	457	724	java/lang/Exception
    //   508	517	724	java/lang/Exception
    //   520	563	724	java/lang/Exception
    //   571	592	724	java/lang/Exception
    //   598	620	724	java/lang/Exception
    //   620	642	724	java/lang/Exception
    //   644	719	724	java/lang/Exception
  }
  
  public void e(String paramString)
  {
    long l2 = -1L;
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopgetnews.", 2, "send_oidb_0x8c9_2, troopUin = " + paramString);
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        l1 = Long.valueOf((String)localObject).longValue();
        if (paramString != null) {
          l2 = Long.valueOf(paramString).longValue();
        }
        paramString = new oidb_0x8c9.ReqBody();
        localObject = new ArrayList();
        ((ArrayList)localObject).add(Long.valueOf(2L));
        ((ArrayList)localObject).add(Long.valueOf(1L));
        ((ArrayList)localObject).add(Long.valueOf(1101236949L));
        ((ArrayList)localObject).add(Long.valueOf(1101484419L));
        paramString.opt_uint64_from_uin.set(l1);
        paramString.opt_uint64_group_code.set(l2);
        paramString.rpt_uint64_appid.set((List)localObject);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2249);
        ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
        ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
        paramString = a("OidbSvc.0x8c9_2");
        paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
        b(paramString);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.troopgetnews.", 2, "myUin error: myUin = " + (String)localObject + ", strTroopUin = " + paramString);
        return;
      }
      long l1 = -1L;
    }
  }
  
  public void e(String paramString, boolean paramBoolean)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 6);
    ((ToServiceMsg)localObject2).extraData.putBoolean("needUpdatePreferences", paramBoolean);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("param_get_credit_info", false);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("param_get_troop_class_type", false);
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "handleBatchGetTroopInfo, isTroopCreditLevelReq:" + bool1);
    }
    if (bool1) {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (bool2)
      {
        x(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      bool1 = paramFromServiceMsg.isSuccess();
      if (!bool1) {
        break;
      }
      paramToServiceMsg = (RespBatchProcess)paramObject;
    } while ((paramToServiceMsg.batch_response_list == null) || (paramToServiceMsg.batch_response_list.size() == 0));
    a(33, bool1, paramToServiceMsg);
    return;
    a(33, bool1, null);
  }
  
  public void f(String paramString)
  {
    c(paramString, true);
  }
  
  public void f(String paramString, boolean paramBoolean)
  {
    Object localObject1 = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject1 != null) {
        paramString = ((TroopManager)localObject1).e;
      }
      localObject1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("joinOrExitOpenTroop:").append((String)localObject1).append(", ");
      if (!paramBoolean) {
        break label334;
      }
      paramString = "join";
      label80:
      QLog.d(".troop.inOrOutOpenTroop", 2, paramString);
    }
    for (;;)
    {
      long l2;
      try
      {
        long l1 = Long.parseLong((String)localObject1);
        l2 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f());
        paramString = new oidb_0xa8d.ReqBody();
        paramString.uint64_group_code.set(l1);
        localObject2 = paramString.uint32_req_type;
        if (!paramBoolean) {
          break label341;
        }
        i1 = bQ;
        ((PBUInt32Field)localObject2).set(i1);
        paramString.uint32_req_client_type.set(1);
        if (!paramBoolean) {
          break label349;
        }
        localObject2 = new oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody();
        ((oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody)localObject2).uint64_visitor_uin.set(l2);
        paramString.msg_join_group.set((MessageMicro)localObject2);
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2701);
        PBUInt32Field localPBUInt32Field = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type;
        if (!paramBoolean) {
          break label380;
        }
        i1 = bQ;
        localPBUInt32Field.set(i1);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
        paramString = a("OidbSvc.0xa8d");
        paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
        paramString.extraData.putString("troopUin", (String)localObject1);
        paramString.extraData.putBoolean("isJoin", paramBoolean);
        b(paramString);
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.inOrOutOpenTroop", 2, "joinOrExitOpenTroop:" + paramString.toString());
      return;
      label334:
      paramString = "exit";
      break label80;
      label341:
      int i1 = bR;
      continue;
      label349:
      localObject2 = new oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody();
      ((oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody)localObject2).uint64_visitor_uin.set(l2);
      paramString.msg_exit_group.set((MessageMicro)localObject2);
      continue;
      label380:
      i1 = bR;
    }
  }
  
  /* Error */
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: sipush 1000
    //   7: if_icmpne +420 -> 427
    //   10: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   13: dup
    //   14: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   17: aload_3
    //   18: checkcast 407	[B
    //   21: checkcast 407	[B
    //   24: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +46 -> 78
    //   35: aload_1
    //   36: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   39: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   42: istore 7
    //   44: invokestatic 4288	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +31 -> 78
    //   50: ldc_w 4290
    //   53: iconst_4
    //   54: new 422	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 5178
    //   64: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload 7
    //   69: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_1
    //   79: ifnull +348 -> 427
    //   82: aload_1
    //   83: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   86: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   89: ifeq +338 -> 427
    //   92: aload_1
    //   93: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   96: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   99: ifnull +328 -> 427
    //   102: aload_1
    //   103: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   106: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   109: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   112: astore_1
    //   113: new 5180	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody
    //   116: dup
    //   117: invokespecial 5181	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:<init>	()V
    //   120: astore_3
    //   121: aload_3
    //   122: aload_1
    //   123: invokevirtual 5182	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   126: pop
    //   127: aload_3
    //   128: getfield 5183	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:opt_uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   131: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   134: lstore 8
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_3
    //   139: getfield 5186	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:rpt_group_app_unread_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   142: invokevirtual 2560	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   145: ifeq +540 -> 685
    //   148: aload_3
    //   149: getfield 5186	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:rpt_group_app_unread_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   152: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   155: astore_1
    //   156: new 334	java/util/ArrayList
    //   159: dup
    //   160: invokespecial 335	java/util/ArrayList:<init>	()V
    //   163: astore_2
    //   164: new 422	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   171: astore 4
    //   173: aload_1
    //   174: invokeinterface 478 1 0
    //   179: astore 5
    //   181: aconst_null
    //   182: astore_1
    //   183: iconst_0
    //   184: istore 7
    //   186: aload 5
    //   188: invokeinterface 483 1 0
    //   193: ifeq +434 -> 627
    //   196: aload 5
    //   198: invokeinterface 487 1 0
    //   203: checkcast 5188	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo
    //   206: astore 6
    //   208: aload 6
    //   210: getfield 5189	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo:opt_uint64_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   213: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   216: lstore 10
    //   218: new 4349	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo
    //   221: dup
    //   222: invokespecial 4350	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:<init>	()V
    //   225: astore_1
    //   226: aload_1
    //   227: lload 10
    //   229: putfield 4351	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   232: aload_1
    //   233: lload 8
    //   235: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   238: putfield 4353	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   241: aload_1
    //   242: aload 6
    //   244: getfield 5192	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo:opt_int32_group_unread_num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   247: invokevirtual 970	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   250: putfield 4355	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   253: aload_1
    //   254: aload 6
    //   256: getfield 5195	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo:opt_int32_group_album_passive_cnt	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   259: invokevirtual 970	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   262: putfield 4359	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   265: aload_1
    //   266: getfield 4351	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   269: ldc2_w 162
    //   272: lcmp
    //   273: ifne +155 -> 428
    //   276: aload_0
    //   277: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   280: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   283: ldc_w 4385
    //   286: lload 8
    //   288: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   291: aload_1
    //   292: getfield 4355	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   295: invokestatic 4388	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   298: aload_0
    //   299: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   305: ldc_w 4390
    //   308: lload 8
    //   310: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   313: aload_1
    //   314: getfield 4359	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   317: invokestatic 4388	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   320: invokestatic 4288	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   323: ifeq +56 -> 379
    //   326: aload 4
    //   328: ldc_w 4392
    //   331: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: lload 8
    //   336: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   339: ldc_w 4394
    //   342: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_1
    //   346: getfield 4351	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   349: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: ldc_w 4396
    //   355: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_1
    //   359: getfield 4359	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   362: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: ldc_w 4398
    //   368: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_1
    //   372: getfield 4355	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   375: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_2
    //   380: aload_1
    //   381: invokeinterface 1473 2 0
    //   386: pop
    //   387: goto -201 -> 186
    //   390: astore_1
    //   391: invokestatic 4288	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   394: ifeq +33 -> 427
    //   397: ldc_w 4290
    //   400: iconst_4
    //   401: new 422	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 5197
    //   411: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_1
    //   415: invokevirtual 687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   418: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: return
    //   428: aload_1
    //   429: getfield 4351	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   432: lconst_1
    //   433: lcmp
    //   434: ifne +28 -> 462
    //   437: aload_0
    //   438: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   444: ldc_w 4400
    //   447: lload 8
    //   449: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   452: aload_1
    //   453: getfield 4355	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   456: invokestatic 4388	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   459: goto -139 -> 320
    //   462: aload_1
    //   463: getfield 4351	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   466: ldc2_w 243
    //   469: lcmp
    //   470: ifne +28 -> 498
    //   473: aload_0
    //   474: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   477: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   480: ldc_w 4402
    //   483: lload 8
    //   485: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   488: aload_1
    //   489: getfield 4355	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   492: invokestatic 4388	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   495: goto -175 -> 320
    //   498: aload_1
    //   499: getfield 4351	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   502: ldc2_w 248
    //   505: lcmp
    //   506: ifne +28 -> 534
    //   509: aload_0
    //   510: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   513: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   516: ldc_w 4412
    //   519: lload 8
    //   521: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   524: aload_1
    //   525: getfield 4355	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   528: invokestatic 4388	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   531: goto -211 -> 320
    //   534: aload_1
    //   535: getfield 4351	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   538: ldc2_w 253
    //   541: lcmp
    //   542: ifne +179 -> 721
    //   545: aload_1
    //   546: getfield 4355	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   549: iconst_m1
    //   550: if_icmpne +21 -> 571
    //   553: aload_0
    //   554: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   557: aload_1
    //   558: getfield 4353	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   561: iconst_m1
    //   562: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: invokestatic 1225	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Integer;)V
    //   568: goto +156 -> 724
    //   571: aload_0
    //   572: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: aload_1
    //   576: getfield 4353	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   579: iconst_0
    //   580: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   583: invokestatic 1225	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Integer;)V
    //   586: goto +138 -> 724
    //   589: astore_1
    //   590: invokestatic 4288	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   593: ifeq -166 -> 427
    //   596: ldc_w 4290
    //   599: iconst_4
    //   600: new 422	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   607: ldc_w 5199
    //   610: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload_1
    //   614: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   617: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   626: return
    //   627: invokestatic 4288	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   630: ifeq +15 -> 645
    //   633: ldc_w 4290
    //   636: iconst_4
    //   637: aload 4
    //   639: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: iload 7
    //   647: ifeq +83 -> 730
    //   650: aload_0
    //   651: bipush 62
    //   653: iconst_1
    //   654: iconst_3
    //   655: anewarray 359	java/lang/Object
    //   658: dup
    //   659: iconst_0
    //   660: aload_1
    //   661: getfield 4353	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   664: aastore
    //   665: dup
    //   666: iconst_1
    //   667: iconst_0
    //   668: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   671: aastore
    //   672: dup
    //   673: iconst_2
    //   674: iconst_1
    //   675: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   678: aastore
    //   679: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   682: goto +48 -> 730
    //   685: aload_0
    //   686: bipush 30
    //   688: iconst_1
    //   689: iconst_3
    //   690: anewarray 359	java/lang/Object
    //   693: dup
    //   694: iconst_0
    //   695: iconst_0
    //   696: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   699: aastore
    //   700: dup
    //   701: iconst_1
    //   702: aload_1
    //   703: aastore
    //   704: dup
    //   705: iconst_2
    //   706: aload_3
    //   707: getfield 5202	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:opt_int32_show_red_point_mobile	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   710: invokevirtual 970	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   713: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   716: aastore
    //   717: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   720: return
    //   721: goto -401 -> 320
    //   724: iconst_1
    //   725: istore 7
    //   727: goto -407 -> 320
    //   730: aload_2
    //   731: astore_1
    //   732: goto -47 -> 685
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	735	0	this	TroopHandler
    //   0	735	1	paramToServiceMsg	ToServiceMsg
    //   0	735	2	paramFromServiceMsg	FromServiceMsg
    //   0	735	3	paramObject	Object
    //   171	467	4	localStringBuilder	StringBuilder
    //   179	18	5	localIterator	Iterator
    //   206	49	6	localGroupAppUnreadInfo	tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.GroupAppUnreadInfo
    //   42	684	7	i1	int
    //   134	386	8	l1	long
    //   216	12	10	l2	long
    // Exception table:
    //   from	to	target	type
    //   10	31	390	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	136	589	java/lang/Exception
    //   138	181	589	java/lang/Exception
    //   186	320	589	java/lang/Exception
    //   320	379	589	java/lang/Exception
    //   379	387	589	java/lang/Exception
    //   428	459	589	java/lang/Exception
    //   462	495	589	java/lang/Exception
    //   498	531	589	java/lang/Exception
    //   534	568	589	java/lang/Exception
    //   571	586	589	java/lang/Exception
    //   627	645	589	java/lang/Exception
    //   650	682	589	java/lang/Exception
    //   685	720	589	java/lang/Exception
  }
  
  public void g(String paramString)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    Object localObject2 = new oidb_0x88d.TagRecord();
    ((oidb_0x88d.TagRecord)localObject2).uint32_bad_num.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).rpt_tag_record.add((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
    localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x88d_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 3);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
  }
  
  /* Error */
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 22
    //   3: iconst_0
    //   4: istore 23
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 6
    //   18: aload_1
    //   19: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 669
    //   25: invokevirtual 672	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   28: lstore 20
    //   30: aload_1
    //   31: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   34: ldc_w 674
    //   37: invokevirtual 384	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   40: istore 10
    //   42: aload_1
    //   43: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   46: ldc_w 3363
    //   49: invokevirtual 672	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   52: lstore 14
    //   54: iconst_m1
    //   55: istore 9
    //   57: iload 9
    //   59: istore 11
    //   61: aload_2
    //   62: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   65: sipush 1000
    //   68: if_icmpne +1744 -> 1812
    //   71: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   74: dup
    //   75: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload_3
    //   81: checkcast 407	[B
    //   84: checkcast 407	[B
    //   87: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   90: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: astore_3
    //   94: aload_3
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull +54 -> 151
    //   100: aload_1
    //   101: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   104: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   107: istore 11
    //   109: iload 11
    //   111: istore 9
    //   113: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +35 -> 151
    //   119: ldc_w 684
    //   122: iconst_2
    //   123: new 422	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 5213
    //   133: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload 11
    //   138: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: iload 11
    //   149: istore 9
    //   151: iload 9
    //   153: istore 11
    //   155: aload_1
    //   156: ifnull +1656 -> 1812
    //   159: iload 9
    //   161: istore 11
    //   163: aload_1
    //   164: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   167: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   170: ifeq +1642 -> 1812
    //   173: iload 9
    //   175: istore 11
    //   177: aload_1
    //   178: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   181: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   184: ifnull +1628 -> 1812
    //   187: aload_1
    //   188: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   191: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   194: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   197: astore_1
    //   198: new 5215	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   201: dup
    //   202: invokespecial 5216	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   205: astore 7
    //   207: aload 7
    //   209: aload_1
    //   210: invokevirtual 5217	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   213: pop
    //   214: aload 5
    //   216: astore_1
    //   217: iload 9
    //   219: ifeq +111 -> 330
    //   222: aload 5
    //   224: astore_1
    //   225: aload 7
    //   227: getfield 5218	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   230: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   233: ifeq +97 -> 330
    //   236: aload 7
    //   238: getfield 5218	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   241: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   244: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   247: invokestatic 682	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   250: astore 5
    //   252: aload 5
    //   254: astore_1
    //   255: lload 14
    //   257: lstore 18
    //   259: iload 10
    //   261: istore 12
    //   263: aload 6
    //   265: astore_3
    //   266: iload 23
    //   268: istore 22
    //   270: aload 5
    //   272: astore 4
    //   274: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +53 -> 330
    //   280: lload 14
    //   282: lstore 18
    //   284: iload 10
    //   286: istore 12
    //   288: aload 6
    //   290: astore_3
    //   291: iload 23
    //   293: istore 22
    //   295: aload 5
    //   297: astore 4
    //   299: ldc_w 684
    //   302: iconst_2
    //   303: new 422	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 5220
    //   313: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 5
    //   318: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload 5
    //   329: astore_1
    //   330: iload 9
    //   332: ifne +1472 -> 1804
    //   335: lload 14
    //   337: lstore 18
    //   339: iload 10
    //   341: istore 12
    //   343: aload 6
    //   345: astore_3
    //   346: iload 23
    //   348: istore 22
    //   350: aload_1
    //   351: astore 4
    //   353: aload 7
    //   355: getfield 5221	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   358: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   361: lload 20
    //   363: lcmp
    //   364: ifne +1440 -> 1804
    //   367: iconst_1
    //   368: istore 23
    //   370: lload 14
    //   372: lstore 18
    //   374: iload 10
    //   376: istore 12
    //   378: aload 6
    //   380: astore_3
    //   381: iload 23
    //   383: istore 22
    //   385: aload_1
    //   386: astore 4
    //   388: aload 7
    //   390: getfield 5224	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   393: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   396: astore 5
    //   398: lload 14
    //   400: lstore 16
    //   402: lload 14
    //   404: lstore 18
    //   406: iload 10
    //   408: istore 12
    //   410: aload 5
    //   412: astore_3
    //   413: iload 23
    //   415: istore 22
    //   417: aload_1
    //   418: astore 4
    //   420: aload 7
    //   422: getfield 5225	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint64_start_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   425: invokevirtual 543	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   428: ifeq +109 -> 537
    //   431: lload 14
    //   433: lstore 18
    //   435: iload 10
    //   437: istore 12
    //   439: aload 5
    //   441: astore_3
    //   442: iload 23
    //   444: istore 22
    //   446: aload_1
    //   447: astore 4
    //   449: aload 7
    //   451: getfield 5225	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint64_start_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   454: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   457: lstore 14
    //   459: lload 14
    //   461: lstore 16
    //   463: lload 14
    //   465: lstore 18
    //   467: iload 10
    //   469: istore 12
    //   471: aload 5
    //   473: astore_3
    //   474: iload 23
    //   476: istore 22
    //   478: aload_1
    //   479: astore 4
    //   481: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +53 -> 537
    //   487: lload 14
    //   489: lstore 18
    //   491: iload 10
    //   493: istore 12
    //   495: aload 5
    //   497: astore_3
    //   498: iload 23
    //   500: istore 22
    //   502: aload_1
    //   503: astore 4
    //   505: ldc_w 684
    //   508: iconst_2
    //   509: new 422	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   516: ldc_w 5227
    //   519: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: lload 14
    //   524: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   527: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: lload 14
    //   535: lstore 16
    //   537: iload 10
    //   539: istore 11
    //   541: lload 16
    //   543: lstore 18
    //   545: iload 10
    //   547: istore 12
    //   549: aload 5
    //   551: astore_3
    //   552: iload 23
    //   554: istore 22
    //   556: aload_1
    //   557: astore 4
    //   559: aload 7
    //   561: getfield 5228	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint32_identify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   564: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   567: ifeq +109 -> 676
    //   570: lload 16
    //   572: lstore 18
    //   574: iload 10
    //   576: istore 12
    //   578: aload 5
    //   580: astore_3
    //   581: iload 23
    //   583: istore 22
    //   585: aload_1
    //   586: astore 4
    //   588: aload 7
    //   590: getfield 5228	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint32_identify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   593: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   596: istore 10
    //   598: iload 10
    //   600: istore 11
    //   602: lload 16
    //   604: lstore 18
    //   606: iload 10
    //   608: istore 12
    //   610: aload 5
    //   612: astore_3
    //   613: iload 23
    //   615: istore 22
    //   617: aload_1
    //   618: astore 4
    //   620: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +53 -> 676
    //   626: lload 16
    //   628: lstore 18
    //   630: iload 10
    //   632: istore 12
    //   634: aload 5
    //   636: astore_3
    //   637: iload 23
    //   639: istore 22
    //   641: aload_1
    //   642: astore 4
    //   644: ldc_w 684
    //   647: iconst_2
    //   648: new 422	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 5230
    //   658: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: iload 10
    //   663: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   666: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: iload 10
    //   674: istore 11
    //   676: iload 11
    //   678: iconst_5
    //   679: if_icmpne +702 -> 1381
    //   682: lload 16
    //   684: lstore 18
    //   686: iload 11
    //   688: istore 12
    //   690: aload 5
    //   692: astore_3
    //   693: iload 23
    //   695: istore 22
    //   697: aload_1
    //   698: astore 4
    //   700: aload_0
    //   701: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   704: bipush 51
    //   706: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   709: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   712: astore 8
    //   714: lload 16
    //   716: lstore 18
    //   718: iload 11
    //   720: istore 12
    //   722: aload 5
    //   724: astore_3
    //   725: iload 23
    //   727: istore 22
    //   729: aload_1
    //   730: astore 4
    //   732: aload 8
    //   734: lload 20
    //   736: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   739: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   742: astore 7
    //   744: aload 7
    //   746: astore 6
    //   748: aload 7
    //   750: ifnonnull +58 -> 808
    //   753: lload 16
    //   755: lstore 18
    //   757: iload 11
    //   759: istore 12
    //   761: aload 5
    //   763: astore_3
    //   764: iload 23
    //   766: istore 22
    //   768: aload_1
    //   769: astore 4
    //   771: new 652	com/tencent/mobileqq/data/TroopInfo
    //   774: dup
    //   775: invokespecial 653	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   778: astore 6
    //   780: lload 16
    //   782: lstore 18
    //   784: iload 11
    //   786: istore 12
    //   788: aload 5
    //   790: astore_3
    //   791: iload 23
    //   793: istore 22
    //   795: aload_1
    //   796: astore 4
    //   798: aload 6
    //   800: lload 20
    //   802: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   805: putfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   808: lload 16
    //   810: lstore 18
    //   812: iload 11
    //   814: istore 12
    //   816: aload 5
    //   818: astore_3
    //   819: iload 23
    //   821: istore 22
    //   823: aload_1
    //   824: astore 4
    //   826: aload 6
    //   828: aload 5
    //   830: invokevirtual 5233	com/tencent/mobileqq/data/TroopInfo:updateSomeMemberUins	(Ljava/util/List;)V
    //   833: lload 16
    //   835: lstore 18
    //   837: iload 11
    //   839: istore 12
    //   841: aload 5
    //   843: astore_3
    //   844: iload 23
    //   846: istore 22
    //   848: aload_1
    //   849: astore 4
    //   851: aload 8
    //   853: aload 6
    //   855: invokevirtual 662	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   858: lload 16
    //   860: lstore 18
    //   862: iload 11
    //   864: istore 12
    //   866: aload 5
    //   868: astore_3
    //   869: iload 23
    //   871: istore 22
    //   873: aload_1
    //   874: astore 4
    //   876: aload_0
    //   877: getfield 321	com/tencent/mobileqq/app/TroopHandler:h	J
    //   880: lload 20
    //   882: lcmp
    //   883: ifne +498 -> 1381
    //   886: lload 16
    //   888: lstore 18
    //   890: iload 11
    //   892: istore 12
    //   894: aload 5
    //   896: astore_3
    //   897: iload 23
    //   899: istore 22
    //   901: aload_1
    //   902: astore 4
    //   904: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   907: ifeq +30 -> 937
    //   910: lload 16
    //   912: lstore 18
    //   914: iload 11
    //   916: istore 12
    //   918: aload 5
    //   920: astore_3
    //   921: iload 23
    //   923: istore 22
    //   925: aload_1
    //   926: astore 4
    //   928: ldc 55
    //   930: iconst_2
    //   931: ldc_w 5235
    //   934: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   937: lload 16
    //   939: lstore 18
    //   941: iload 11
    //   943: istore 12
    //   945: aload 5
    //   947: astore_3
    //   948: iload 23
    //   950: istore 22
    //   952: aload_1
    //   953: astore 4
    //   955: aload_0
    //   956: getfield 2909	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   959: ifnonnull +217 -> 1176
    //   962: lload 16
    //   964: lstore 18
    //   966: iload 11
    //   968: istore 12
    //   970: aload 5
    //   972: astore_3
    //   973: iload 23
    //   975: istore 22
    //   977: aload_1
    //   978: astore 4
    //   980: aload_0
    //   981: new 334	java/util/ArrayList
    //   984: dup
    //   985: invokespecial 335	java/util/ArrayList:<init>	()V
    //   988: putfield 2909	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   991: goto +836 -> 1827
    //   994: lload 16
    //   996: lstore 18
    //   998: iload 11
    //   1000: istore 12
    //   1002: aload 5
    //   1004: astore_3
    //   1005: iload 23
    //   1007: istore 22
    //   1009: aload_1
    //   1010: astore 4
    //   1012: iload 10
    //   1014: aload 5
    //   1016: invokeinterface 665 1 0
    //   1021: if_icmpge +360 -> 1381
    //   1024: lload 16
    //   1026: lstore 18
    //   1028: iload 11
    //   1030: istore 12
    //   1032: aload 5
    //   1034: astore_3
    //   1035: iload 23
    //   1037: istore 22
    //   1039: aload_1
    //   1040: astore 4
    //   1042: aload 5
    //   1044: iload 10
    //   1046: invokeinterface 611 2 0
    //   1051: checkcast 3336	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist
    //   1054: astore 6
    //   1056: lload 16
    //   1058: lstore 18
    //   1060: iload 11
    //   1062: istore 12
    //   1064: aload 5
    //   1066: astore_3
    //   1067: iload 23
    //   1069: istore 22
    //   1071: aload_1
    //   1072: astore 4
    //   1074: aload 6
    //   1076: getfield 3340	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1079: invokevirtual 543	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1082: ifeq +40 -> 1122
    //   1085: lload 16
    //   1087: lstore 18
    //   1089: iload 11
    //   1091: istore 12
    //   1093: aload 5
    //   1095: astore_3
    //   1096: iload 23
    //   1098: istore 22
    //   1100: aload_1
    //   1101: astore 4
    //   1103: aload_0
    //   1104: getfield 2909	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1107: aload 6
    //   1109: getfield 3340	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1112: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1115: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1118: invokevirtual 491	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1121: pop
    //   1122: iload 10
    //   1124: iconst_1
    //   1125: iadd
    //   1126: istore 10
    //   1128: goto -134 -> 994
    //   1131: astore_3
    //   1132: aconst_null
    //   1133: astore_1
    //   1134: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1137: ifeq +32 -> 1169
    //   1140: ldc 55
    //   1142: iconst_2
    //   1143: new 422	java/lang/StringBuilder
    //   1146: dup
    //   1147: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   1150: ldc_w 5237
    //   1153: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: aload_3
    //   1157: invokevirtual 687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   1160: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1169: aload_3
    //   1170: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1173: goto -1077 -> 96
    //   1176: lload 16
    //   1178: lstore 18
    //   1180: iload 11
    //   1182: istore 12
    //   1184: aload 5
    //   1186: astore_3
    //   1187: iload 23
    //   1189: istore 22
    //   1191: aload_1
    //   1192: astore 4
    //   1194: aload_0
    //   1195: getfield 2909	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1198: invokevirtual 1516	java/util/ArrayList:clear	()V
    //   1201: goto +626 -> 1827
    //   1204: astore_1
    //   1205: aload 4
    //   1207: astore_1
    //   1208: iload 12
    //   1210: istore 10
    //   1212: lload 18
    //   1214: lstore 14
    //   1216: aload_0
    //   1217: bipush 19
    //   1219: iload 22
    //   1221: bipush 6
    //   1223: anewarray 359	java/lang/Object
    //   1226: dup
    //   1227: iconst_0
    //   1228: lload 20
    //   1230: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1233: aastore
    //   1234: dup
    //   1235: iconst_1
    //   1236: iload 10
    //   1238: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1241: aastore
    //   1242: dup
    //   1243: iconst_2
    //   1244: aload_3
    //   1245: aastore
    //   1246: dup
    //   1247: iconst_3
    //   1248: lload 14
    //   1250: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1253: aastore
    //   1254: dup
    //   1255: iconst_4
    //   1256: iload 9
    //   1258: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1261: aastore
    //   1262: dup
    //   1263: iconst_5
    //   1264: aload_1
    //   1265: aastore
    //   1266: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1269: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1272: ifeq +108 -> 1380
    //   1275: new 422	java/lang/StringBuilder
    //   1278: dup
    //   1279: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   1282: astore_3
    //   1283: aload_3
    //   1284: ldc_w 5239
    //   1287: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: ldc_w 5241
    //   1293: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: iload 22
    //   1298: invokevirtual 572	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1301: ldc_w 5243
    //   1304: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload_2
    //   1308: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1311: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1314: ldc_w 3186
    //   1317: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: lload 20
    //   1322: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1325: ldc_w 3188
    //   1328: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: iload 10
    //   1333: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1336: ldc_w 5245
    //   1339: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: lload 14
    //   1344: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1347: ldc_w 5247
    //   1350: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: iload 9
    //   1355: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1358: ldc_w 5249
    //   1361: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: aload_1
    //   1365: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: ldc_w 684
    //   1372: iconst_2
    //   1373: aload_3
    //   1374: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1377: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1380: return
    //   1381: lload 16
    //   1383: lstore 18
    //   1385: iload 11
    //   1387: istore 12
    //   1389: aload 5
    //   1391: astore_3
    //   1392: iload 23
    //   1394: istore 22
    //   1396: aload_1
    //   1397: astore 4
    //   1399: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1402: ifeq +372 -> 1774
    //   1405: lload 16
    //   1407: lstore 18
    //   1409: iload 11
    //   1411: istore 12
    //   1413: aload 5
    //   1415: astore_3
    //   1416: iload 23
    //   1418: istore 22
    //   1420: aload_1
    //   1421: astore 4
    //   1423: new 422	java/lang/StringBuilder
    //   1426: dup
    //   1427: sipush 200
    //   1430: invokespecial 3182	java/lang/StringBuilder:<init>	(I)V
    //   1433: astore 6
    //   1435: lload 16
    //   1437: lstore 18
    //   1439: iload 11
    //   1441: istore 12
    //   1443: aload 5
    //   1445: astore_3
    //   1446: iload 23
    //   1448: istore 22
    //   1450: aload_1
    //   1451: astore 4
    //   1453: aload 6
    //   1455: ldc_w 5239
    //   1458: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: ldc_w 5251
    //   1464: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: lload 16
    //   1469: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1472: ldc_w 5253
    //   1475: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: iload 11
    //   1480: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: aload 5
    //   1486: ifnull +356 -> 1842
    //   1489: lload 16
    //   1491: lstore 18
    //   1493: iload 11
    //   1495: istore 12
    //   1497: aload 5
    //   1499: astore_3
    //   1500: iload 23
    //   1502: istore 22
    //   1504: aload_1
    //   1505: astore 4
    //   1507: aload 5
    //   1509: invokeinterface 665 1 0
    //   1514: istore 10
    //   1516: lload 16
    //   1518: lstore 18
    //   1520: iload 11
    //   1522: istore 12
    //   1524: aload 5
    //   1526: astore_3
    //   1527: iload 23
    //   1529: istore 22
    //   1531: aload_1
    //   1532: astore 4
    //   1534: aload 6
    //   1536: ldc_w 5255
    //   1539: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: iload 10
    //   1544: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1547: ldc_w 5257
    //   1550: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: pop
    //   1554: iconst_0
    //   1555: istore 13
    //   1557: iload 13
    //   1559: iload 10
    //   1561: if_icmpge +156 -> 1717
    //   1564: lload 16
    //   1566: lstore 18
    //   1568: iload 11
    //   1570: istore 12
    //   1572: aload 5
    //   1574: astore_3
    //   1575: iload 23
    //   1577: istore 22
    //   1579: aload_1
    //   1580: astore 4
    //   1582: aload 5
    //   1584: iload 13
    //   1586: invokeinterface 611 2 0
    //   1591: checkcast 3336	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist
    //   1594: astore 7
    //   1596: aload 7
    //   1598: ifnull +72 -> 1670
    //   1601: lload 16
    //   1603: lstore 18
    //   1605: iload 11
    //   1607: istore 12
    //   1609: aload 5
    //   1611: astore_3
    //   1612: iload 23
    //   1614: istore 22
    //   1616: aload_1
    //   1617: astore 4
    //   1619: aload 6
    //   1621: ldc_w 5259
    //   1624: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: iload 13
    //   1629: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1632: ldc_w 887
    //   1635: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: aload 7
    //   1640: getfield 3340	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1643: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1646: ldc_w 887
    //   1649: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: aload 7
    //   1654: getfield 3350	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint32_uin_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1657: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1660: ldc_w 5261
    //   1663: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: pop
    //   1667: goto +166 -> 1833
    //   1670: lload 16
    //   1672: lstore 18
    //   1674: iload 11
    //   1676: istore 12
    //   1678: aload 5
    //   1680: astore_3
    //   1681: iload 23
    //   1683: istore 22
    //   1685: aload_1
    //   1686: astore 4
    //   1688: aload 6
    //   1690: ldc_w 5259
    //   1693: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1696: iload 13
    //   1698: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1701: ldc_w 5263
    //   1704: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: ldc_w 5261
    //   1710: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: pop
    //   1714: goto +119 -> 1833
    //   1717: lload 16
    //   1719: lstore 18
    //   1721: iload 11
    //   1723: istore 12
    //   1725: aload 5
    //   1727: astore_3
    //   1728: iload 23
    //   1730: istore 22
    //   1732: aload_1
    //   1733: astore 4
    //   1735: aload 6
    //   1737: ldc_w 5265
    //   1740: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: pop
    //   1744: lload 16
    //   1746: lstore 18
    //   1748: iload 11
    //   1750: istore 12
    //   1752: aload 5
    //   1754: astore_3
    //   1755: iload 23
    //   1757: istore 22
    //   1759: aload_1
    //   1760: astore 4
    //   1762: ldc_w 684
    //   1765: iconst_2
    //   1766: aload 6
    //   1768: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1771: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1774: lload 16
    //   1776: lstore 14
    //   1778: iload 11
    //   1780: istore 10
    //   1782: aload 5
    //   1784: astore_3
    //   1785: iconst_1
    //   1786: istore 22
    //   1788: goto -572 -> 1216
    //   1791: astore_1
    //   1792: aconst_null
    //   1793: astore_1
    //   1794: aload 4
    //   1796: astore_3
    //   1797: goto -581 -> 1216
    //   1800: astore_3
    //   1801: goto -667 -> 1134
    //   1804: aconst_null
    //   1805: astore_3
    //   1806: iconst_0
    //   1807: istore 22
    //   1809: goto -21 -> 1788
    //   1812: iload 11
    //   1814: istore 9
    //   1816: iconst_0
    //   1817: istore 22
    //   1819: aconst_null
    //   1820: astore_1
    //   1821: aload 7
    //   1823: astore_3
    //   1824: goto -608 -> 1216
    //   1827: iconst_0
    //   1828: istore 10
    //   1830: goto -836 -> 994
    //   1833: iload 13
    //   1835: iconst_1
    //   1836: iadd
    //   1837: istore 13
    //   1839: goto -282 -> 1557
    //   1842: iconst_0
    //   1843: istore 10
    //   1845: goto -329 -> 1516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1848	0	this	TroopHandler
    //   0	1848	1	paramToServiceMsg	ToServiceMsg
    //   0	1848	2	paramFromServiceMsg	FromServiceMsg
    //   0	1848	3	paramObject	Object
    //   10	1785	4	localObject1	Object
    //   7	1776	5	localObject2	Object
    //   16	1751	6	localObject3	Object
    //   13	1809	7	localObject4	Object
    //   712	140	8	localTroopManager	TroopManager
    //   55	1760	9	i1	int
    //   40	1804	10	i2	int
    //   59	1754	11	i3	int
    //   261	1490	12	i4	int
    //   1555	283	13	i5	int
    //   52	1725	14	l1	long
    //   400	1375	16	l2	long
    //   257	1490	18	l3	long
    //   28	1293	20	l4	long
    //   1	1817	22	bool1	boolean
    //   4	1752	23	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   71	79	1131	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   274	280	1204	java/lang/Exception
    //   299	327	1204	java/lang/Exception
    //   353	367	1204	java/lang/Exception
    //   388	398	1204	java/lang/Exception
    //   420	431	1204	java/lang/Exception
    //   449	459	1204	java/lang/Exception
    //   481	487	1204	java/lang/Exception
    //   505	533	1204	java/lang/Exception
    //   559	570	1204	java/lang/Exception
    //   588	598	1204	java/lang/Exception
    //   620	626	1204	java/lang/Exception
    //   644	672	1204	java/lang/Exception
    //   700	714	1204	java/lang/Exception
    //   732	744	1204	java/lang/Exception
    //   771	780	1204	java/lang/Exception
    //   798	808	1204	java/lang/Exception
    //   826	833	1204	java/lang/Exception
    //   851	858	1204	java/lang/Exception
    //   876	886	1204	java/lang/Exception
    //   904	910	1204	java/lang/Exception
    //   928	937	1204	java/lang/Exception
    //   955	962	1204	java/lang/Exception
    //   980	991	1204	java/lang/Exception
    //   1012	1024	1204	java/lang/Exception
    //   1042	1056	1204	java/lang/Exception
    //   1074	1085	1204	java/lang/Exception
    //   1103	1122	1204	java/lang/Exception
    //   1194	1201	1204	java/lang/Exception
    //   1399	1405	1204	java/lang/Exception
    //   1423	1435	1204	java/lang/Exception
    //   1453	1484	1204	java/lang/Exception
    //   1507	1516	1204	java/lang/Exception
    //   1534	1554	1204	java/lang/Exception
    //   1582	1596	1204	java/lang/Exception
    //   1619	1667	1204	java/lang/Exception
    //   1688	1714	1204	java/lang/Exception
    //   1735	1744	1204	java/lang/Exception
    //   1762	1774	1204	java/lang/Exception
    //   198	214	1791	java/lang/Exception
    //   225	252	1791	java/lang/Exception
    //   79	94	1800	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void h(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null) {}
    for (long l1 = 0L; (l1 != 0L) && (System.currentTimeMillis() - l1 < 1800000L); l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_shutup_timestamp.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_shutup_timestamp_me.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 8);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  /* Error */
  public void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 22
    //   3: iconst_0
    //   4: istore 21
    //   6: iconst_0
    //   7: istore 20
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 6
    //   18: aload_1
    //   19: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 669
    //   25: invokevirtual 672	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   28: lstore 16
    //   30: aload_1
    //   31: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   34: ldc_w 674
    //   37: invokevirtual 384	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   40: istore 14
    //   42: aload_1
    //   43: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   46: ldc_w 378
    //   49: invokevirtual 384	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   52: istore 15
    //   54: aload_1
    //   55: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   58: ldc_w 3253
    //   61: invokevirtual 392	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 7
    //   66: iconst_m1
    //   67: istore 9
    //   69: iload 9
    //   71: istore 10
    //   73: aload_2
    //   74: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   77: sipush 1000
    //   80: if_icmpne +1186 -> 1266
    //   83: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   86: dup
    //   87: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   90: astore_1
    //   91: aload_1
    //   92: aload_3
    //   93: checkcast 407	[B
    //   96: checkcast 407	[B
    //   99: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: astore_3
    //   106: aload_3
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +54 -> 163
    //   112: aload_1
    //   113: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   116: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   119: istore 10
    //   121: iload 10
    //   123: istore 9
    //   125: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +35 -> 163
    //   131: ldc_w 684
    //   134: iconst_2
    //   135: new 422	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 5272
    //   145: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 10
    //   150: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: iload 10
    //   161: istore 9
    //   163: iload 9
    //   165: istore 10
    //   167: aload_1
    //   168: ifnull +1098 -> 1266
    //   171: iload 9
    //   173: istore 10
    //   175: aload_1
    //   176: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   179: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   182: ifeq +1084 -> 1266
    //   185: iload 9
    //   187: istore 10
    //   189: aload_1
    //   190: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   193: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   196: ifnull +1070 -> 1266
    //   199: aload_1
    //   200: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   203: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   206: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   209: astore_1
    //   210: new 599	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   213: dup
    //   214: invokespecial 600	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   217: astore 6
    //   219: aload 6
    //   221: aload_1
    //   222: invokevirtual 601	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   225: pop
    //   226: iload 9
    //   228: ifeq +1033 -> 1261
    //   231: aload 6
    //   233: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   239: ifeq +1022 -> 1261
    //   242: aload 6
    //   244: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   247: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   250: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   253: invokestatic 682	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   256: astore_1
    //   257: aconst_null
    //   258: astore_3
    //   259: iload 9
    //   261: istore 10
    //   263: aload 4
    //   265: astore 5
    //   267: iload 21
    //   269: istore 20
    //   271: aload 6
    //   273: getfield 605	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   276: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   279: astore 6
    //   281: aload 6
    //   283: ifnonnull +140 -> 423
    //   286: iconst_0
    //   287: istore 12
    //   289: goto +987 -> 1276
    //   292: aload_3
    //   293: ifnonnull +239 -> 532
    //   296: iload 13
    //   298: iload 12
    //   300: if_icmpge +232 -> 532
    //   303: iload 9
    //   305: istore 10
    //   307: aload 4
    //   309: astore 5
    //   311: iload 21
    //   313: istore 20
    //   315: aload 6
    //   317: iload 13
    //   319: invokeinterface 611 2 0
    //   324: checkcast 613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   327: astore 8
    //   329: iload 9
    //   331: istore 11
    //   333: aload 8
    //   335: ifnull +919 -> 1254
    //   338: iload 9
    //   340: istore 10
    //   342: aload 4
    //   344: astore 5
    //   346: iload 21
    //   348: istore 20
    //   350: aload 8
    //   352: getfield 617	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   355: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   358: lstore 18
    //   360: lload 18
    //   362: lload 16
    //   364: lcmp
    //   365: ifeq +82 -> 447
    //   368: iload 13
    //   370: iconst_1
    //   371: iadd
    //   372: istore 13
    //   374: goto -82 -> 292
    //   377: astore_3
    //   378: aconst_null
    //   379: astore_1
    //   380: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +33 -> 416
    //   386: ldc_w 684
    //   389: iconst_2
    //   390: new 422	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 5274
    //   400: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_3
    //   404: invokevirtual 687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   407: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload_3
    //   417: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   420: goto -312 -> 108
    //   423: iload 9
    //   425: istore 10
    //   427: aload 4
    //   429: astore 5
    //   431: iload 21
    //   433: istore 20
    //   435: aload 6
    //   437: invokeinterface 665 1 0
    //   442: istore 12
    //   444: goto +832 -> 1276
    //   447: iload 9
    //   449: istore 10
    //   451: aload 4
    //   453: astore 5
    //   455: iload 21
    //   457: istore 20
    //   459: aload 8
    //   461: getfield 614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   464: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   467: istore 9
    //   469: iload 9
    //   471: istore 11
    //   473: iload 9
    //   475: ifne +779 -> 1254
    //   478: iload 9
    //   480: istore 10
    //   482: aload 4
    //   484: astore 5
    //   486: iload 21
    //   488: istore 20
    //   490: iload 9
    //   492: istore 11
    //   494: aload 8
    //   496: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   499: invokevirtual 630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   502: ifeq +752 -> 1254
    //   505: iload 9
    //   507: istore 10
    //   509: aload 4
    //   511: astore 5
    //   513: iload 21
    //   515: istore 20
    //   517: aload 8
    //   519: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   522: invokevirtual 633	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   525: checkcast 629	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   528: astore_3
    //   529: goto -161 -> 368
    //   532: aload_3
    //   533: ifnull +713 -> 1246
    //   536: iconst_1
    //   537: istore 22
    //   539: iconst_1
    //   540: istore 21
    //   542: iload 9
    //   544: istore 10
    //   546: aload 4
    //   548: astore 5
    //   550: iload 22
    //   552: istore 20
    //   554: aload_0
    //   555: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   558: bipush 51
    //   560: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   563: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   566: astore 6
    //   568: iload 9
    //   570: istore 10
    //   572: aload 4
    //   574: astore 5
    //   576: iload 22
    //   578: istore 20
    //   580: aload 6
    //   582: lload 16
    //   584: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   587: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   590: astore 4
    //   592: aload 4
    //   594: ifnonnull +649 -> 1243
    //   597: iload 9
    //   599: istore 10
    //   601: aload 4
    //   603: astore 5
    //   605: iload 22
    //   607: istore 20
    //   609: new 652	com/tencent/mobileqq/data/TroopInfo
    //   612: dup
    //   613: invokespecial 653	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   616: astore 4
    //   618: aload 4
    //   620: lload 16
    //   622: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   625: putfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   628: aload_3
    //   629: getfield 3234	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   632: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   635: ifeq +53 -> 688
    //   638: aload 4
    //   640: aload_3
    //   641: getfield 3234	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   644: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   647: i2l
    //   648: putfield 698	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   651: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq +34 -> 688
    //   657: ldc_w 684
    //   660: iconst_2
    //   661: new 422	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   668: ldc_w 5276
    //   671: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 4
    //   676: getfield 698	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   679: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   682: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   688: aload_3
    //   689: getfield 3243	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   692: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   695: ifeq +52 -> 747
    //   698: aload 4
    //   700: aload_3
    //   701: getfield 3243	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   704: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   707: putfield 1662	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   710: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +34 -> 747
    //   716: ldc_w 684
    //   719: iconst_2
    //   720: new 422	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 5278
    //   730: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 4
    //   735: getfield 1662	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   738: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   741: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   747: aload_3
    //   748: getfield 3198	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   751: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   754: ifeq +18 -> 772
    //   757: aload 4
    //   759: aload_3
    //   760: getfield 3198	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   763: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   766: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   769: putfield 1725	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   772: aload_3
    //   773: getfield 3205	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_answer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   776: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   779: ifeq +18 -> 797
    //   782: aload 4
    //   784: aload_3
    //   785: getfield 3205	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_answer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   788: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   791: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   794: putfield 1731	com/tencent/mobileqq/data/TroopInfo:joinTroopAnswer	Ljava/lang/String;
    //   797: aload_3
    //   798: getfield 3237	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   801: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   804: ifeq +16 -> 820
    //   807: aload 4
    //   809: aload_3
    //   810: getfield 3237	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   813: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   816: i2l
    //   817: putfield 823	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt	J
    //   820: aload_3
    //   821: getfield 3240	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   824: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   827: ifeq +15 -> 842
    //   830: aload 4
    //   832: aload_3
    //   833: getfield 3240	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   836: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   839: putfield 2075	com/tencent/mobileqq/data/TroopInfo:troopTypeExt	I
    //   842: aload_3
    //   843: getfield 3246	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   846: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   849: ifeq +29 -> 878
    //   852: aload 4
    //   854: aload_3
    //   855: getfield 3246	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   858: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   861: i2l
    //   862: putfield 2077	com/tencent/mobileqq/data/TroopInfo:dwAppPrivilegeFlag	J
    //   865: aload 4
    //   867: aload_3
    //   868: getfield 3246	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   871: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   874: i2l
    //   875: putfield 2080	com/tencent/mobileqq/data/TroopInfo:troopPrivilegeFlag	J
    //   878: aload_3
    //   879: getfield 3194	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   882: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   885: ifeq +16 -> 901
    //   888: aload 4
    //   890: aload_3
    //   891: getfield 3194	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   894: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   897: i2s
    //   898: putfield 1656	com/tencent/mobileqq/data/TroopInfo:cGroupOption	S
    //   901: aload_3
    //   902: getfield 704	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   905: invokevirtual 543	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   908: ifeq +34 -> 942
    //   911: aload 4
    //   913: new 422	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   920: ldc_w 706
    //   923: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: aload_3
    //   927: getfield 704	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   930: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   933: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   936: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: putfield 709	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   942: aload 6
    //   944: aload 4
    //   946: invokevirtual 662	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   949: aload 4
    //   951: astore_3
    //   952: iconst_1
    //   953: istore 20
    //   955: iload 20
    //   957: istore 21
    //   959: aload_3
    //   960: astore 6
    //   962: iload 9
    //   964: istore 10
    //   966: aload_1
    //   967: astore 5
    //   969: aload_0
    //   970: bipush 18
    //   972: iload 21
    //   974: bipush 7
    //   976: anewarray 359	java/lang/Object
    //   979: dup
    //   980: iconst_0
    //   981: lload 16
    //   983: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   986: aastore
    //   987: dup
    //   988: iconst_1
    //   989: iload 14
    //   991: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   994: aastore
    //   995: dup
    //   996: iconst_2
    //   997: aload 6
    //   999: aastore
    //   1000: dup
    //   1001: iconst_3
    //   1002: iload 10
    //   1004: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1007: aastore
    //   1008: dup
    //   1009: iconst_4
    //   1010: aload 5
    //   1012: aastore
    //   1013: dup
    //   1014: iconst_5
    //   1015: iload 15
    //   1017: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1020: aastore
    //   1021: dup
    //   1022: bipush 6
    //   1024: aload 7
    //   1026: aastore
    //   1027: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1030: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1033: ifeq +101 -> 1134
    //   1036: new 422	java/lang/StringBuilder
    //   1039: dup
    //   1040: sipush 150
    //   1043: invokespecial 3182	java/lang/StringBuilder:<init>	(I)V
    //   1046: astore_1
    //   1047: aload_1
    //   1048: ldc_w 5280
    //   1051: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: ldc_w 5241
    //   1057: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: iload 21
    //   1062: invokevirtual 572	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1065: ldc_w 5243
    //   1068: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: aload_2
    //   1072: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1075: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1078: ldc_w 3186
    //   1081: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: lload 16
    //   1086: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1089: ldc_w 3188
    //   1092: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: iload 14
    //   1097: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1100: ldc_w 5247
    //   1103: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: iload 10
    //   1108: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1111: ldc_w 5249
    //   1114: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: aload 5
    //   1119: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: pop
    //   1123: ldc_w 684
    //   1126: iconst_2
    //   1127: aload_1
    //   1128: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1131: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1134: return
    //   1135: astore 4
    //   1137: aconst_null
    //   1138: astore_1
    //   1139: iload 22
    //   1141: istore 20
    //   1143: aload 5
    //   1145: astore_3
    //   1146: aload_1
    //   1147: astore 5
    //   1149: iload 9
    //   1151: istore 10
    //   1153: aload_3
    //   1154: astore 6
    //   1156: iload 20
    //   1158: istore 21
    //   1160: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1163: ifeq -194 -> 969
    //   1166: ldc_w 684
    //   1169: iconst_2
    //   1170: aload 4
    //   1172: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   1175: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1178: aload_1
    //   1179: astore 5
    //   1181: iload 9
    //   1183: istore 10
    //   1185: aload_3
    //   1186: astore 6
    //   1188: iload 20
    //   1190: istore 21
    //   1192: goto -223 -> 969
    //   1195: astore 4
    //   1197: iload 10
    //   1199: istore 9
    //   1201: aload 5
    //   1203: astore_3
    //   1204: goto -58 -> 1146
    //   1207: astore 5
    //   1209: aload 4
    //   1211: astore_3
    //   1212: aload 5
    //   1214: astore 4
    //   1216: iload 21
    //   1218: istore 20
    //   1220: goto -74 -> 1146
    //   1223: astore 5
    //   1225: aload 4
    //   1227: astore_3
    //   1228: aload 5
    //   1230: astore 4
    //   1232: iload 21
    //   1234: istore 20
    //   1236: goto -90 -> 1146
    //   1239: astore_3
    //   1240: goto -860 -> 380
    //   1243: goto -615 -> 628
    //   1246: aconst_null
    //   1247: astore_3
    //   1248: iconst_0
    //   1249: istore 20
    //   1251: goto -296 -> 955
    //   1254: iload 11
    //   1256: istore 9
    //   1258: goto -890 -> 368
    //   1261: aconst_null
    //   1262: astore_1
    //   1263: goto -1006 -> 257
    //   1266: aconst_null
    //   1267: astore 5
    //   1269: iload 20
    //   1271: istore 21
    //   1273: goto -304 -> 969
    //   1276: iconst_0
    //   1277: istore 13
    //   1279: goto -987 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1282	0	this	TroopHandler
    //   0	1282	1	paramToServiceMsg	ToServiceMsg
    //   0	1282	2	paramFromServiceMsg	FromServiceMsg
    //   0	1282	3	paramObject	Object
    //   13	937	4	localTroopInfo	TroopInfo
    //   1135	36	4	localException1	Exception
    //   1195	15	4	localException2	Exception
    //   1214	17	4	localException3	Exception
    //   10	1192	5	localObject1	Object
    //   1207	6	5	localException4	Exception
    //   1223	6	5	localException5	Exception
    //   1267	1	5	localObject2	Object
    //   16	1171	6	localObject3	Object
    //   64	961	7	str	String
    //   327	191	8	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    //   67	1190	9	i1	int
    //   71	1127	10	i2	int
    //   331	924	11	i3	int
    //   287	156	12	i4	int
    //   296	982	13	i5	int
    //   40	1056	14	i6	int
    //   52	964	15	i7	int
    //   28	1057	16	l1	long
    //   358	3	18	l2	long
    //   7	1263	20	bool1	boolean
    //   4	1268	21	bool2	boolean
    //   1	1139	22	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   83	91	377	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   210	226	1135	java/lang/Exception
    //   231	257	1135	java/lang/Exception
    //   271	281	1195	java/lang/Exception
    //   315	329	1195	java/lang/Exception
    //   350	360	1195	java/lang/Exception
    //   435	444	1195	java/lang/Exception
    //   459	469	1195	java/lang/Exception
    //   494	505	1195	java/lang/Exception
    //   517	529	1195	java/lang/Exception
    //   554	568	1195	java/lang/Exception
    //   580	592	1195	java/lang/Exception
    //   609	618	1195	java/lang/Exception
    //   618	628	1207	java/lang/Exception
    //   628	688	1223	java/lang/Exception
    //   688	747	1223	java/lang/Exception
    //   747	772	1223	java/lang/Exception
    //   772	797	1223	java/lang/Exception
    //   797	820	1223	java/lang/Exception
    //   820	842	1223	java/lang/Exception
    //   842	878	1223	java/lang/Exception
    //   878	901	1223	java/lang/Exception
    //   901	942	1223	java/lang/Exception
    //   942	949	1223	java/lang/Exception
    //   91	106	1239	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void i(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 2);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a(localToServiceMsg);
    o(paramString);
  }
  
  public void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i1 = paramToServiceMsg.extraData.getInt("subCmd");
    if (paramFromServiceMsg.getResultCode() == 1000) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    int i2;
    ArrayList localArrayList;
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = (ToServiceMsg)paramObject;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      TroopInfo localTroopInfo;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x8b8_1|oidb_sso parseFrom byte " + ((InvalidProtocolBufferMicroException)paramObject).toString());
        }
        ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
      }
      if (localTroopInfo == null) {
        break label374;
      }
      localTroopInfo.mTroopAvatarId = paramToServiceMsg.uint32_default_id.get();
      localTroopInfo.mTroopPicList = localArrayList;
      ((TroopManager)paramObject).b(localTroopInfo);
      if (localTroopInfo == null) {
        break label514;
      }
    }
    if (paramToServiceMsg != null)
    {
      i2 = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopdisband.", 2, "handle_oidb_0x8b8_1|oidb_sso.OIDBSSOPkg.result " + i2);
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      paramObject = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      try
      {
        paramToServiceMsg = new oidb_0x8b8.RspBody();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i2 = paramToServiceMsg.uint32_result.get();
        paramToServiceMsg.uint32_sequence.get();
        paramToServiceMsg.uint32_subcmd.get();
        paramToServiceMsg.uint64_group_uin.get();
        paramObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localTroopInfo = ((TroopManager)paramObject).a(String.valueOf(l1));
        localArrayList = new ArrayList();
        Iterator localIterator = paramToServiceMsg.rpt_uint32_pic_list.get().iterator();
        while (localIterator.hasNext())
        {
          int i3 = ((Integer)localIterator.next()).intValue();
          if (i3 >= 0)
          {
            localArrayList.add(String.valueOf(i3));
            continue;
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        }
      }
    }
    for (;;)
    {
      label374:
      a(47, false, new Object[] { String.valueOf(l1), Integer.valueOf(i2), null, Integer.valueOf(i1), null });
      while (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder(150);
        paramToServiceMsg.append("handle_oidb_0x8b8_1").append("|isSuccess = ").append(false).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|result = ").append(i2).append("|strErrorMsg = ").append(null);
        QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        return;
        label514:
        a(47, false, new Object[] { String.valueOf(l1), Integer.valueOf(i2), null, Integer.valueOf(i1), localArrayList });
      }
    }
  }
  
  public void j(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 9);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a(localToServiceMsg);
    o(paramString);
  }
  
  public void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool4 = false;
    boolean bool3 = false;
    bool1 = false;
    localObject1 = null;
    Object localObject10 = null;
    localObject9 = null;
    Object localObject8 = null;
    Object localObject11 = null;
    i5 = -1;
    l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i7 = paramToServiceMsg.extraData.getInt("nFlag");
    localException5 = null;
    Object localObject12 = null;
    i1 = -1;
    localObject6 = localObject10;
    i2 = i1;
    localObject7 = localObject12;
    i4 = i5;
    Object localObject3 = localObject11;
    bool2 = bool1;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (ToServiceMsg)paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_7|oidb_sso parseFrom byte " + ((InvalidProtocolBufferMicroException)paramObject).toString());
          }
          ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
        }
        i2 = i1;
        localObject3 = localObject8;
        bool1 = bool3;
        i4 = ((List)localObject6).size();
      }
      if (paramToServiceMsg != null)
      {
        i2 = paramToServiceMsg.uint32_result.get();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_7|oidb_sso.OIDBSSOPkg.result " + i2);
          i1 = i2;
        }
      }
      localObject6 = localObject10;
      i2 = i1;
      localObject7 = localObject12;
      i4 = i5;
      localObject3 = localObject11;
      bool2 = bool1;
      if (paramToServiceMsg != null)
      {
        localObject6 = localObject10;
        i2 = i1;
        localObject7 = localObject12;
        i4 = i5;
        localObject3 = localObject11;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.has())
        {
          localObject6 = localObject10;
          i2 = i1;
          localObject7 = localObject12;
          i4 = i5;
          localObject3 = localObject11;
          bool2 = bool1;
          if (paramToServiceMsg.bytes_bodybuffer.get() != null) {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          }
        }
      }
    }
    try
    {
      paramObject = new oidb_0x88d.RspBody();
      ((oidb_0x88d.RspBody)paramObject).mergeFrom(paramToServiceMsg);
      if ((i1 == 0) || (!((oidb_0x88d.RspBody)paramObject).str_errorinfo.has())) {
        break label1247;
      }
      paramToServiceMsg = String.valueOf(((oidb_0x88d.RspBody)paramObject).str_errorinfo.get().toByteArray());
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        int i6;
        bool1 = bool4;
        paramObject = localObject9;
        i3 = i5;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        localObject1 = localException3;
        localObject6 = paramToServiceMsg;
        i2 = i1;
        localObject7 = localException5;
        i4 = i3;
        localObject4 = paramObject;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.troopdisband.", 2, ((Exception)localObject1).toString());
          localObject6 = paramToServiceMsg;
          i2 = i1;
          localObject7 = localException5;
          i4 = i3;
          localObject4 = paramObject;
          bool2 = bool1;
          continue;
          a(46, bool2, new Object[] { String.valueOf(l1), Integer.valueOf(i2), localObject6, Integer.valueOf(i4), localObject7 });
          continue;
          paramToServiceMsg = null;
          continue;
          i6 = 0;
        }
      }
    }
    localObject1 = null;
    i2 = i1;
    localObject3 = localObject8;
    bool1 = bool3;
    try
    {
      localObject6 = ((oidb_0x88d.RspBody)paramObject).stzrspgroupinfo.get();
      if (localObject6 != null) {
        break label492;
      }
      i4 = 0;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        long l2;
        label492:
        i1 = i2;
        int i3 = i5;
        paramObject = localObject4;
        continue;
        paramObject = null;
        i2 = -1;
        Object localObject2 = null;
        bool1 = false;
        continue;
        paramObject = localObject2;
        i1 = i3;
      }
    }
    if ((localObject1 == null) && (i6 < i4))
    {
      i2 = i1;
      localObject3 = localObject8;
      bool1 = bool3;
      paramObject = (oidb_0x88d.RspGroupInfo)((List)localObject6).get(i6);
      i3 = i1;
      if (paramObject != null)
      {
        i2 = i1;
        localObject3 = localObject8;
        bool1 = bool3;
        l2 = ((oidb_0x88d.RspGroupInfo)paramObject).uint64_group_code.get();
        if (l2 != l1) {}
        for (paramObject = localObject1;; paramObject = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)paramObject).stgroupinfo.get())
        {
          i6 += 1;
          localObject1 = paramObject;
          break;
          i2 = i1;
          localObject3 = localObject8;
          bool1 = bool3;
          i1 = ((oidb_0x88d.RspGroupInfo)paramObject).uint32_result.get();
          i3 = i1;
          if (i1 != 0) {
            break label1237;
          }
          i2 = i1;
          localObject3 = localObject8;
          bool1 = bool3;
          i3 = i1;
          if (!((oidb_0x88d.RspGroupInfo)paramObject).stgroupinfo.has()) {
            break label1237;
          }
          i2 = i1;
          localObject3 = localObject8;
          bool1 = bool3;
        }
      }
    }
    else if (localObject1 != null)
    {
      bool3 = true;
      bool2 = true;
      i2 = i1;
      localObject3 = localObject8;
      bool1 = bool3;
      localObject6 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      i2 = i1;
      localObject3 = localObject8;
      bool1 = bool3;
      paramObject = ((TroopManager)localObject6).a(String.valueOf(l1));
      i2 = i1;
      localObject3 = paramObject;
      bool1 = bool3;
      if (((oidb_0x88d.GroupInfo)localObject1).msg_head_portrait.has())
      {
        i2 = i1;
        localObject3 = paramObject;
        bool1 = bool3;
        if (((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.has())
        {
          i2 = i1;
          localObject3 = paramObject;
          bool1 = bool3;
          localObject7 = ((oidb_0x88d.GroupInfo)localObject1).msg_head_portrait;
          i2 = i1;
          localObject3 = paramObject;
          bool1 = bool3;
          i3 = ((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.get();
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = TroopInfo.setAvatarPicId((oidb_0x88d.GroupHeadPortrait)localObject7);
        }
        catch (Exception localException2)
        {
          Object localObject4;
          bool1 = bool2;
          continue;
        }
        try
        {
          localObject3 = TroopInfo.setVerifyingAvatarPicId((oidb_0x88d.GroupHeadPortrait)localObject7);
          if (paramObject != null)
          {
            ((TroopInfo)paramObject).mTroopPicList = ((List)localObject1);
            ((TroopInfo)paramObject).mTroopVerifyingPics = ((Set)localObject3);
            ((TroopManager)localObject6).b((TroopInfo)paramObject);
          }
          localObject3 = localObject1;
          bool1 = true;
          i2 = i3;
          localObject1 = paramObject;
          paramObject = localObject3;
        }
        catch (Exception localException4)
        {
          localException5 = localException2;
          localObject2 = localException4;
          bool1 = bool2;
          continue;
          Object localObject5 = null;
          i2 = -1;
          localObject2 = paramObject;
          bool1 = true;
          paramObject = localObject5;
          continue;
        }
        bool2 = bool1;
        localObject3 = localObject1;
        i4 = i2;
        localObject7 = paramObject;
        i2 = i1;
        localObject6 = paramToServiceMsg;
        if (localObject3 == null) {
          continue;
        }
        a(46, bool2, new Object[] { String.valueOf(l1), Integer.valueOf(i2), localObject6, Integer.valueOf(i4), null });
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder(150);
          paramToServiceMsg.append("handle_oidb_0x88d_0").append("|isSuccess = ").append(bool2).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|seq = ").append(i7).append("|result = ").append(i2).append("|strErrorMsg = ").append((String)localObject6);
          QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        }
        return;
        i2 = i1;
        localObject3 = paramObject;
        bool1 = bool3;
        if (!((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.has()) {
          break label1205;
        }
        i2 = i1;
        localObject3 = paramObject;
        bool1 = bool3;
        i3 = ((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.get();
        i2 = i3;
        localObject1 = paramObject;
        paramObject = null;
        bool1 = true;
      }
    }
  }
  
  public void k(String paramString)
  {
    a(paramString, 0);
  }
  
  public void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i6 = paramToServiceMsg.extraData.getInt("nFlag");
    int i1 = -1;
    int i2;
    Object localObject3;
    Object localObject4;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (ToServiceMsg)paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + ((InvalidProtocolBufferMicroException)paramObject).toString());
          }
          ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
        }
        i2 = i1;
        bool1 = bool2;
        i4 = ((List)localObject1).size();
      }
      if (paramToServiceMsg != null)
      {
        i2 = paramToServiceMsg.uint32_result.get();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + i2);
          i1 = i2;
        }
      }
      localObject3 = null;
      localObject4 = null;
      if ((i1 == 0) && (paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    else
    {
      try
      {
        localObject1 = new oidb_0x88d.RspBody();
        ((oidb_0x88d.RspBody)localObject1).mergeFrom(paramToServiceMsg);
        if ((i1 == 0) || (!((oidb_0x88d.RspBody)localObject1).str_errorinfo.has())) {
          break label864;
        }
        paramToServiceMsg = String.valueOf(((oidb_0x88d.RspBody)localObject1).str_errorinfo.get().toByteArray());
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)paramObject))
            {
              ((TroopInfo)localObject4).mTags = ((String)paramObject);
              ((TroopManager)localObject1).b((TroopInfo)localObject4);
            }
            bool1 = true;
            bool2 = bool1;
            localObject4 = paramObject;
            i2 = i1;
            localObject1 = paramToServiceMsg;
            a(32, bool2, new Object[] { Long.valueOf(l1), Integer.valueOf(i6), localObject4, Integer.valueOf(i2), localObject1 });
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder(150);
              paramToServiceMsg.append("handle_oidb_0x88d_0").append("|isSuccess = ").append(bool2).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|flag = ").append(i6).append("|result = ").append(i2).append("|strErrorMsg = ").append((String)localObject1);
              QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
            }
            return;
          }
          catch (Exception localException)
          {
            Object localObject1;
            localObject3 = paramObject;
            paramObject = localException;
            bool1 = bool2;
            continue;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          bool1 = bool3;
          localObject1 = paramToServiceMsg;
          i2 = i1;
          localObject4 = localObject3;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.troopdisband.", 2, ((Exception)paramObject).toString());
            localObject1 = paramToServiceMsg;
            i2 = i1;
            localObject4 = localObject3;
            bool2 = bool1;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
      paramObject = null;
      i2 = i1;
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((oidb_0x88d.RspBody)localObject1).stzrspgroupinfo.get();
        if (localObject1 != null) {
          continue;
        }
        i4 = 0;
      }
      catch (Exception paramObject)
      {
        int i4;
        int i3;
        long l2;
        i1 = i2;
        continue;
        paramObject = null;
        continue;
        paramObject = null;
        bool1 = false;
        continue;
        i1 = i3;
        continue;
      }
      if ((paramObject == null) && (i5 < i4))
      {
        i2 = i1;
        bool1 = bool2;
        localObject4 = (oidb_0x88d.RspGroupInfo)((List)localObject1).get(i5);
        i3 = i1;
        if (localObject4 != null)
        {
          i2 = i1;
          bool1 = bool2;
          l2 = ((oidb_0x88d.RspGroupInfo)localObject4).uint64_group_code.get();
          if (l2 != l1)
          {
            i5 += 1;
            continue;
          }
          i2 = i1;
          bool1 = bool2;
          i1 = ((oidb_0x88d.RspGroupInfo)localObject4).uint32_result.get();
          i3 = i1;
          if (i1 == 0)
          {
            i2 = i1;
            bool1 = bool2;
            i3 = i1;
            if (((oidb_0x88d.RspGroupInfo)localObject4).stgroupinfo.has())
            {
              i2 = i1;
              bool1 = bool2;
              paramObject = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject4).stgroupinfo.get();
              continue;
            }
          }
        }
      }
      else if (paramObject != null)
      {
        bool3 = true;
        bool2 = true;
        i2 = i1;
        bool1 = bool3;
        localObject1 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        i2 = i1;
        bool1 = bool3;
        localObject4 = ((TroopManager)localObject1).a(String.valueOf(l1));
        i2 = i1;
        bool1 = bool3;
        if (((oidb_0x88d.GroupInfo)paramObject).rpt_tag_record.has())
        {
          i2 = i1;
          bool1 = bool3;
          if (((oidb_0x88d.GroupInfo)paramObject).rpt_tag_record.size() > 0)
          {
            i2 = i1;
            bool1 = bool3;
            paramObject = TroopInfo.setTags(((oidb_0x88d.GroupInfo)paramObject).rpt_tag_record.get());
            if (localObject4 == null) {}
          }
        }
      }
      label864:
      Object localObject2 = null;
      i2 = i1;
      bool2 = bool1;
      continue;
      int i5 = 0;
    }
  }
  
  public void l(String paramString)
  {
    Object localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(0);
    Object localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(BizTroopHandler.a(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint32_last_get_group_name_time.set(0);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.uint32_group_member_max_num.set(0);
    localGroupInfo.uint32_active_member_num.set(0);
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set(localGroupInfo);
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x88d_1");
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 5);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  public void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1 = null;
    Object localObject3 = null;
    oidb_0x88d.RspGroupInfo localRspGroupInfo = null;
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    String str = String.valueOf(l1);
    int i6 = paramToServiceMsg.extraData.getInt("nFlag");
    int i1 = -1;
    int i2;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + paramFromServiceMsg.toString());
          }
          paramFromServiceMsg.printStackTrace();
        }
        i2 = i1;
        localObject1 = localObject3;
        bool1 = bool2;
        i4 = ((List)paramObject).size();
      }
      if (paramToServiceMsg != null)
      {
        i2 = paramToServiceMsg.uint32_result.get();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + i2);
          i1 = i2;
        }
      }
      if ((i1 == 0) && (paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    else
    {
      try
      {
        paramObject = new oidb_0x88d.RspBody();
        ((oidb_0x88d.RspBody)paramObject).mergeFrom(paramToServiceMsg);
        if ((i1 == 0) || (!((oidb_0x88d.RspBody)paramObject).str_errorinfo.has())) {
          break label990;
        }
        paramToServiceMsg = String.valueOf(((oidb_0x88d.RspBody)paramObject).str_errorinfo.get().toByteArray());
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          try
          {
            ((TroopInfo)paramObject).troopuin = str;
          }
          catch (Exception localException1)
          {
            paramFromServiceMsg = (FromServiceMsg)paramObject;
            paramObject = localException1;
            bool1 = bool2;
            continue;
          }
          try
          {
            ((TroopInfo)paramObject).troopowneruin = String.valueOf(paramFromServiceMsg.uint64_group_owner.get());
            ((TroopInfo)paramObject).troopname = paramFromServiceMsg.string_group_name.get().toStringUtf8();
            ((TroopInfo)paramObject).troopface = ((short)paramFromServiceMsg.uint32_group_face.get());
            ((TroopInfo)paramObject).troopmemo = paramFromServiceMsg.string_group_memo.get().toStringUtf8();
            ((TroopInfo)paramObject).fingertroopmemo = paramFromServiceMsg.string_group_finger_memo.get().toStringUtf8();
            ((TroopInfo)paramObject).mRichFingerMemo = paramFromServiceMsg.string_group_rich_finger_memo.get().toStringUtf8();
            localObject1 = (oidb_0x88d.GroupGeoInfo)paramFromServiceMsg.group_geo_info.get();
            ((TroopInfo)paramObject).strLocation = ((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.get().toStringUtf8();
            ((TroopInfo)paramObject).troopLat = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.get());
            ((TroopInfo)paramObject).troopLon = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.get());
            ((TroopInfo)paramObject).troopTypeExt = paramFromServiceMsg.uint32_group_type_flag.get();
            ((TroopInfo)paramObject).dwGroupClassExt = paramFromServiceMsg.uint32_group_class_ext.get();
            ((TroopInfo)paramObject).dwGroupFlagExt = paramFromServiceMsg.uint32_group_flag_ext.get();
            ((TroopInfo)paramObject).dwGroupFlag = paramFromServiceMsg.uint32_group_flag.get();
            ((TroopInfo)paramObject).troopAuthenticateInfo = paramFromServiceMsg.string_certification_text.get().toStringUtf8();
            ((TroopInfo)paramObject).dwGagTimeStamp = paramFromServiceMsg.uint32_shutup_timestamp.get();
            if (QLog.isColorLevel()) {
              QLog.d("TroopHandler", 2, "dwGagTimeStamp:" + ((TroopInfo)paramObject).dwGagTimeStamp);
            }
            paramFromServiceMsg = (FromServiceMsg)paramObject;
            bool1 = true;
            bool2 = bool1;
            localObject3 = paramFromServiceMsg;
            i2 = i1;
            localObject1 = paramToServiceMsg;
            a(34, bool2, new Object[] { Long.valueOf(l1), Integer.valueOf(i6), localObject3, Integer.valueOf(i2), localObject1 });
            return;
          }
          catch (Exception localException2)
          {
            paramFromServiceMsg = (FromServiceMsg)paramObject;
            paramObject = localException2;
            bool1 = bool2;
            continue;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          bool1 = bool3;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          localObject1 = paramToServiceMsg;
          i2 = i1;
          localObject3 = paramFromServiceMsg;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.troopdisband.", 2, ((Exception)paramObject).toString());
            localObject1 = paramToServiceMsg;
            i2 = i1;
            localObject3 = paramFromServiceMsg;
            bool2 = bool1;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
      paramFromServiceMsg = null;
      i2 = i1;
      localObject1 = localObject3;
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        paramObject = ((oidb_0x88d.RspBody)paramObject).stzrspgroupinfo.get();
        if (paramObject != null) {
          continue;
        }
        i4 = 0;
      }
      catch (Exception paramObject)
      {
        int i4;
        int i3;
        long l2;
        i1 = i2;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        continue;
        continue;
        paramFromServiceMsg = null;
        bool1 = false;
        continue;
        i1 = i3;
        continue;
      }
      if ((paramFromServiceMsg == null) && (i5 < i4))
      {
        i2 = i1;
        localObject1 = localObject3;
        bool1 = bool2;
        localRspGroupInfo = (oidb_0x88d.RspGroupInfo)((List)paramObject).get(i5);
        i3 = i1;
        if (localRspGroupInfo != null)
        {
          i2 = i1;
          localObject1 = localObject3;
          bool1 = bool2;
          l2 = localRspGroupInfo.uint64_group_code.get();
          if (l2 != l1)
          {
            i5 += 1;
            continue;
          }
          i2 = i1;
          localObject1 = localObject3;
          bool1 = bool2;
          i1 = localRspGroupInfo.uint32_result.get();
          i3 = i1;
          if (i1 == 0)
          {
            i2 = i1;
            localObject1 = localObject3;
            bool1 = bool2;
            i3 = i1;
            if (localRspGroupInfo.stgroupinfo.has())
            {
              i2 = i1;
              localObject1 = localObject3;
              bool1 = bool2;
              paramFromServiceMsg = (oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get();
              continue;
            }
          }
        }
      }
      else if (paramFromServiceMsg != null)
      {
        bool3 = true;
        bool2 = true;
        i2 = i1;
        localObject1 = localObject3;
        bool1 = bool3;
        paramObject = ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(str);
        if ((paramObject == null) || (paramObject == null))
        {
          i2 = i1;
          localObject1 = paramObject;
          bool1 = bool3;
          paramObject = new TroopInfo();
        }
      }
      label990:
      Object localObject2 = null;
      i2 = i1;
      localObject3 = localRspGroupInfo;
      bool2 = bool1;
      continue;
      int i5 = 0;
    }
  }
  
  public void m(String paramString)
  {
    e(paramString, false);
  }
  
  public void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject1 = null;
    long l1 = paramToServiceMsg.extraData.getLong("OldOwner");
    long l2 = paramToServiceMsg.extraData.getLong("NewOwner");
    long l3 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i1;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      for (;;)
      {
        int i2;
        try
        {
          paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          try
          {
            localObject2 = new oidb_0x89e.RspBody();
            ((oidb_0x89e.RspBody)localObject2).mergeFrom(paramToServiceMsg);
            if (!((oidb_0x89e.RspBody)localObject2).uint32_result.has()) {
              break label821;
            }
            i2 = ((oidb_0x89e.RspBody)localObject2).uint32_result.get();
            i1 = i2;
            i3 = i2;
          }
          catch (Exception localException1)
          {
            bool2 = false;
            paramToServiceMsg = null;
            i2 = i1;
            i1 = i2;
            paramObject = paramToServiceMsg;
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|exception = " + localException1.toString());
            i1 = i2;
            paramObject = paramToServiceMsg;
            bool1 = bool2;
            continue;
          }
          try
          {
            if (QLog.isColorLevel())
            {
              i3 = i2;
              QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|oidb_0x89e.RspBody.result = " + i2);
              i1 = i2;
            }
            paramToServiceMsg = (ToServiceMsg)localObject1;
            if (i1 > 0)
            {
              paramToServiceMsg = (ToServiceMsg)localObject1;
              i3 = i1;
              if (((oidb_0x89e.RspBody)localObject2).str_errorinfo.has())
              {
                i3 = i1;
                localObject1 = String.valueOf(((oidb_0x89e.RspBody)localObject2).str_errorinfo.get().toByteArray());
                paramToServiceMsg = (ToServiceMsg)localObject1;
                bool1 = bool4;
                paramObject = localObject1;
              }
            }
          }
          catch (Exception localException2)
          {
            i2 = i3;
            bool2 = false;
            paramToServiceMsg = null;
            break label728;
          }
          try
          {
            if (QLog.isColorLevel())
            {
              bool1 = bool4;
              paramObject = localObject1;
              QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|strErrorMsg = " + (String)localObject1);
              paramToServiceMsg = (ToServiceMsg)localObject1;
            }
            bool2 = bool3;
            if (i1 == 0)
            {
              bool2 = bool3;
              bool1 = bool4;
              paramObject = paramToServiceMsg;
              if (((oidb_0x89e.RspBody)localObject2).uint64_group_code.get() == l3)
              {
                bool3 = true;
                bool2 = true;
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                localObject2 = localTroopManager.a(String.valueOf(l3));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  bool1 = bool3;
                  paramObject = paramToServiceMsg;
                  localObject1 = new TroopInfo();
                  bool1 = bool3;
                  paramObject = paramToServiceMsg;
                  ((TroopInfo)localObject1).troopuin = String.valueOf(l3);
                }
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                ((TroopInfo)localObject1).troopowneruin = String.valueOf(l2);
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                localTroopManager.b((TroopInfo)localObject1);
              }
            }
            bool1 = bool2;
            paramObject = paramToServiceMsg;
            a(20, bool1, new Object[] { Long.valueOf(l3), String.valueOf(l1), String.valueOf(l2), Integer.valueOf(i1), paramObject });
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder(150);
              paramToServiceMsg.append("handle_oidb_0x89e_0").append("|isSuccess = ").append(bool1).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l3).append("|oldOwner = ").append(l1).append("|newOwner = ").append(l2).append("|result = ").append(i1).append("|strErrorMsg = ").append((String)paramObject);
              QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
            }
            return;
          }
          catch (Exception localException3)
          {
            paramToServiceMsg = (ToServiceMsg)paramObject;
            i2 = i1;
            bool2 = bool1;
            break label728;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler", 2, "handle_oidb_0x89e_0| oidb_sso parseFrom byte " + ((InvalidProtocolBufferMicroException)paramObject).toString());
          }
          ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
          continue;
        }
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = (ToServiceMsg)paramObject;
          if (paramToServiceMsg == null) {
            break label832;
          }
          i2 = paramToServiceMsg.uint32_result.get();
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|oidb_sso.OIDBSSOPkg.result = " + i2);
            i1 = i2;
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          continue;
          continue;
          bool1 = false;
          paramObject = null;
          continue;
          i1 = -1;
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    for (;;)
    {
      Object localObject2;
      int i3;
      boolean bool2;
      TroopManager localTroopManager;
      label728:
      label821:
      label832:
      i1 = -1;
      boolean bool1 = false;
      paramObject = null;
    }
  }
  
  public void n(String paramString)
  {
    TroopInfo localTroopInfo = (TroopInfo)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(TroopInfo.class, paramString);
    if ((QLog.isColorLevel()) && (localTroopInfo != null))
    {
      QLog.d("TroopHandler", 2, "PrivilegeFlag:" + localTroopInfo.troopPrivilegeFlag);
      QLog.d("TroopHandler", 2, "troop.isAdmin:" + localTroopInfo.isAdmin());
    }
    if ((localTroopInfo != null) && ((localTroopInfo.troopPrivilegeFlag & 1L) == 1L) && (!localTroopInfo.isAdmin())) {}
    for (int i1 = 0;; i1 = 1)
    {
      long l1 = Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
      if (i1 != LocalMultiProcConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() + "__qzone_pic_permission__" + paramString, -1, l1)) {
        LocalMultiProcConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() + "__qzone_pic_permission__" + paramString, i1, l1);
      }
      return;
    }
  }
  
  /* Error */
  public void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 18
    //   3: iconst_0
    //   4: istore 19
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_1
    //   16: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   19: ldc_w 669
    //   22: invokevirtual 672	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   25: lstore 14
    //   27: aload_1
    //   28: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 674
    //   34: invokevirtual 384	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   37: istore 13
    //   39: iconst_m1
    //   40: istore 8
    //   42: iload 8
    //   44: istore 9
    //   46: aload_2
    //   47: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   50: sipush 1000
    //   53: if_icmpne +935 -> 988
    //   56: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   59: dup
    //   60: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: aload_3
    //   66: checkcast 407	[B
    //   69: checkcast 407	[B
    //   72: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   75: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: astore_3
    //   79: aload_3
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +54 -> 136
    //   85: aload_1
    //   86: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   92: istore 9
    //   94: iload 9
    //   96: istore 8
    //   98: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +35 -> 136
    //   104: ldc_w 684
    //   107: iconst_2
    //   108: new 422	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 5390
    //   118: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload 9
    //   123: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: iload 9
    //   134: istore 8
    //   136: iload 8
    //   138: istore 9
    //   140: aload_1
    //   141: ifnull +847 -> 988
    //   144: iload 8
    //   146: istore 9
    //   148: aload_1
    //   149: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   152: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   155: ifeq +833 -> 988
    //   158: iload 8
    //   160: istore 9
    //   162: aload_1
    //   163: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   166: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   169: ifnull +819 -> 988
    //   172: aload_1
    //   173: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   176: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   179: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   182: astore_1
    //   183: new 599	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   186: dup
    //   187: invokespecial 600	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   190: astore 6
    //   192: aload 6
    //   194: aload_1
    //   195: invokevirtual 601	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   198: pop
    //   199: iload 8
    //   201: ifeq +782 -> 983
    //   204: aload 6
    //   206: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   212: ifeq +771 -> 983
    //   215: aload 6
    //   217: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   223: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   226: invokestatic 682	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_3
    //   232: iload 8
    //   234: istore 9
    //   236: aload 6
    //   238: getfield 605	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   241: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   244: astore 6
    //   246: aload 6
    //   248: ifnonnull +124 -> 372
    //   251: iconst_0
    //   252: istore 11
    //   254: goto +740 -> 994
    //   257: aload_3
    //   258: ifnonnull +191 -> 449
    //   261: iload 12
    //   263: iload 11
    //   265: if_icmpge +184 -> 449
    //   268: iload 8
    //   270: istore 9
    //   272: aload 6
    //   274: iload 12
    //   276: invokeinterface 611 2 0
    //   281: checkcast 613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   284: astore 7
    //   286: iload 8
    //   288: istore 10
    //   290: aload 7
    //   292: ifnull +684 -> 976
    //   295: iload 8
    //   297: istore 9
    //   299: aload 7
    //   301: getfield 617	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   304: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   307: lstore 16
    //   309: lload 16
    //   311: lload 14
    //   313: lcmp
    //   314: ifeq +74 -> 388
    //   317: iload 12
    //   319: iconst_1
    //   320: iadd
    //   321: istore 12
    //   323: goto -66 -> 257
    //   326: astore_3
    //   327: aconst_null
    //   328: astore_1
    //   329: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +33 -> 365
    //   335: ldc_w 684
    //   338: iconst_2
    //   339: new 422	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 5392
    //   349: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_3
    //   353: invokevirtual 687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   356: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload_3
    //   366: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   369: goto -288 -> 81
    //   372: iload 8
    //   374: istore 9
    //   376: aload 6
    //   378: invokeinterface 665 1 0
    //   383: istore 11
    //   385: goto +609 -> 994
    //   388: iload 8
    //   390: istore 9
    //   392: aload 7
    //   394: getfield 614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   397: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   400: istore 8
    //   402: iload 8
    //   404: istore 10
    //   406: iload 8
    //   408: ifne +568 -> 976
    //   411: iload 8
    //   413: istore 9
    //   415: iload 8
    //   417: istore 10
    //   419: aload 7
    //   421: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   424: invokevirtual 630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   427: ifeq +549 -> 976
    //   430: iload 8
    //   432: istore 9
    //   434: aload 7
    //   436: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   439: invokevirtual 633	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   442: checkcast 629	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   445: astore_3
    //   446: goto -129 -> 317
    //   449: aload_3
    //   450: ifnull +517 -> 967
    //   453: iconst_1
    //   454: istore 18
    //   456: aload 5
    //   458: astore 4
    //   460: aload_0
    //   461: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: bipush 51
    //   466: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   469: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   472: lload 14
    //   474: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   477: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   480: astore 5
    //   482: aload 5
    //   484: ifnonnull +476 -> 960
    //   487: new 652	com/tencent/mobileqq/data/TroopInfo
    //   490: dup
    //   491: invokespecial 653	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   494: astore 6
    //   496: aload 6
    //   498: astore 4
    //   500: aload 6
    //   502: lload 14
    //   504: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   507: putfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   510: aload 6
    //   512: astore 4
    //   514: aload_3
    //   515: getfield 3194	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   518: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   521: ifeq +16 -> 537
    //   524: aload 4
    //   526: aload_3
    //   527: getfield 3194	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   530: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   533: i2s
    //   534: putfield 1656	com/tencent/mobileqq/data/TroopInfo:cGroupOption	S
    //   537: aload_3
    //   538: getfield 3198	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   541: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   544: ifeq +55 -> 599
    //   547: aload 4
    //   549: aload_3
    //   550: getfield 3198	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   553: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   556: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   559: putfield 1725	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   562: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +34 -> 599
    //   568: ldc_w 3190
    //   571: iconst_2
    //   572: new 422	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 5394
    //   582: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 4
    //   587: getfield 1725	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   590: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload_3
    //   600: getfield 3205	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_answer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   603: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   606: ifeq +18 -> 624
    //   609: aload 4
    //   611: aload_3
    //   612: getfield 3205	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_answer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   615: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   618: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   621: putfield 1731	com/tencent/mobileqq/data/TroopInfo:joinTroopAnswer	Ljava/lang/String;
    //   624: aload_0
    //   625: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   628: invokevirtual 1776	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   631: aload 4
    //   633: getfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   636: aload 4
    //   638: getfield 755	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   641: invokestatic 1781	com/tencent/mobileqq/util/TroopSystemMsgUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload_0
    //   645: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   648: invokevirtual 1776	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   651: aload 4
    //   653: getfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   656: aload 4
    //   658: getfield 1656	com/tencent/mobileqq/data/TroopInfo:cGroupOption	S
    //   661: invokestatic 5397	com/tencent/mobileqq/util/TroopSystemMsgUtil:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   664: aload_0
    //   665: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   668: invokevirtual 1776	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   671: aload 4
    //   673: getfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   676: aload 4
    //   678: getfield 1725	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   681: invokestatic 1786	com/tencent/mobileqq/util/TroopSystemMsgUtil:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   684: aload_0
    //   685: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   688: invokevirtual 1776	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   691: aload 4
    //   693: getfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   696: aload 4
    //   698: getfield 1731	com/tencent/mobileqq/data/TroopInfo:joinTroopAnswer	Ljava/lang/String;
    //   701: invokestatic 1788	com/tencent/mobileqq/util/TroopSystemMsgUtil:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   704: iload 18
    //   706: istore 19
    //   708: aload 4
    //   710: astore 6
    //   712: iload 8
    //   714: istore 9
    //   716: aload_1
    //   717: astore 5
    //   719: aload_0
    //   720: bipush 25
    //   722: iload 19
    //   724: iconst_5
    //   725: anewarray 359	java/lang/Object
    //   728: dup
    //   729: iconst_0
    //   730: lload 14
    //   732: invokestatic 714	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   735: aastore
    //   736: dup
    //   737: iconst_1
    //   738: iload 13
    //   740: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   743: aastore
    //   744: dup
    //   745: iconst_2
    //   746: aload 6
    //   748: aastore
    //   749: dup
    //   750: iconst_3
    //   751: iload 9
    //   753: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   756: aastore
    //   757: dup
    //   758: iconst_4
    //   759: aload 5
    //   761: aastore
    //   762: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   765: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq +101 -> 869
    //   771: new 422	java/lang/StringBuilder
    //   774: dup
    //   775: sipush 150
    //   778: invokespecial 3182	java/lang/StringBuilder:<init>	(I)V
    //   781: astore_1
    //   782: aload_1
    //   783: ldc_w 5399
    //   786: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: ldc_w 5241
    //   792: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: iload 19
    //   797: invokevirtual 572	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   800: ldc_w 5243
    //   803: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_2
    //   807: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   810: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   813: ldc_w 3186
    //   816: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: lload 14
    //   821: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   824: ldc_w 3188
    //   827: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: iload 13
    //   832: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   835: ldc_w 5247
    //   838: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: iload 9
    //   843: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   846: ldc_w 5249
    //   849: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload 5
    //   854: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: ldc_w 3190
    //   861: iconst_2
    //   862: aload_1
    //   863: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   866: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   869: return
    //   870: astore_3
    //   871: aconst_null
    //   872: astore_1
    //   873: aload_1
    //   874: astore 5
    //   876: iload 8
    //   878: istore 9
    //   880: aload 4
    //   882: astore 6
    //   884: iload 18
    //   886: istore 19
    //   888: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   891: ifeq -172 -> 719
    //   894: ldc_w 3190
    //   897: iconst_2
    //   898: aload_3
    //   899: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   902: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: aload_1
    //   906: astore 5
    //   908: iload 8
    //   910: istore 9
    //   912: aload 4
    //   914: astore 6
    //   916: iload 18
    //   918: istore 19
    //   920: goto -201 -> 719
    //   923: astore_3
    //   924: iload 9
    //   926: istore 8
    //   928: goto -55 -> 873
    //   931: astore_3
    //   932: iconst_1
    //   933: istore 18
    //   935: goto -62 -> 873
    //   938: astore_3
    //   939: aload 5
    //   941: astore 4
    //   943: iconst_1
    //   944: istore 18
    //   946: goto -73 -> 873
    //   949: astore_3
    //   950: iconst_1
    //   951: istore 18
    //   953: goto -80 -> 873
    //   956: astore_3
    //   957: goto -628 -> 329
    //   960: aload 5
    //   962: astore 4
    //   964: goto -450 -> 514
    //   967: aconst_null
    //   968: astore 4
    //   970: iconst_0
    //   971: istore 18
    //   973: goto -269 -> 704
    //   976: iload 10
    //   978: istore 8
    //   980: goto -663 -> 317
    //   983: aconst_null
    //   984: astore_1
    //   985: goto -755 -> 230
    //   988: aconst_null
    //   989: astore 5
    //   991: goto -272 -> 719
    //   994: iconst_0
    //   995: istore 12
    //   997: goto -740 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1000	0	this	TroopHandler
    //   0	1000	1	paramToServiceMsg	ToServiceMsg
    //   0	1000	2	paramFromServiceMsg	FromServiceMsg
    //   0	1000	3	paramObject	Object
    //   7	962	4	localObject1	Object
    //   10	980	5	localObject2	Object
    //   13	902	6	localObject3	Object
    //   284	151	7	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    //   40	939	8	i1	int
    //   44	881	9	i2	int
    //   288	689	10	i3	int
    //   252	132	11	i4	int
    //   261	735	12	i5	int
    //   37	794	13	i6	int
    //   25	795	14	l1	long
    //   307	3	16	l2	long
    //   1	971	18	bool1	boolean
    //   4	915	19	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   56	64	326	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   183	199	870	java/lang/Exception
    //   204	230	870	java/lang/Exception
    //   236	246	923	java/lang/Exception
    //   272	286	923	java/lang/Exception
    //   299	309	923	java/lang/Exception
    //   376	385	923	java/lang/Exception
    //   392	402	923	java/lang/Exception
    //   419	430	923	java/lang/Exception
    //   434	446	923	java/lang/Exception
    //   460	482	931	java/lang/Exception
    //   500	510	931	java/lang/Exception
    //   487	496	938	java/lang/Exception
    //   514	537	949	java/lang/Exception
    //   537	599	949	java/lang/Exception
    //   599	624	949	java/lang/Exception
    //   624	704	949	java/lang/Exception
    //   64	79	956	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      return;
      paramToServiceMsg = new cmd0x3fe.RspBody();
    } while (paramObject == null);
    for (;;)
    {
      int i2;
      int i1;
      long l1;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int i8;
      int i9;
      ArrayList localArrayList;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((!paramToServiceMsg.int32_ret.has()) || (paramToServiceMsg.int32_ret.get() != 0) || (!paramToServiceMsg.uint32_subcmd.has())) {
          break;
        }
        i2 = paramToServiceMsg.uint32_subcmd.get();
        paramToServiceMsg = paramToServiceMsg.rpt_msg_level_info;
        paramFromServiceMsg = new Object[paramToServiceMsg.size()];
        i1 = 0;
        if (i1 >= paramToServiceMsg.size()) {
          break label377;
        }
        Object localObject = (cmd0x3fe.LevelInfo)paramToServiceMsg.get(i1);
        l1 = ((cmd0x3fe.LevelInfo)localObject).uint64_uin.get();
        i3 = ((cmd0x3fe.LevelInfo)localObject).uint32_online_level.get();
        i4 = ((cmd0x3fe.LevelInfo)localObject).uint32_show_level.get();
        i5 = ((cmd0x3fe.LevelInfo)localObject).uint32_level_color.get();
        i6 = ((cmd0x3fe.LevelInfo)localObject).uint32_score.get();
        i7 = ((cmd0x3fe.LevelInfo)localObject).uint32_req_flag.get();
        i8 = ((cmd0x3fe.LevelInfo)localObject).uint32_req_timer.get();
        i9 = ((cmd0x3fe.LevelInfo)localObject).uint32_user_identity.get();
        paramObject = ((cmd0x3fe.LevelInfo)localObject).nickname.get();
        localArrayList = new ArrayList();
        localObject = ((cmd0x3fe.LevelInfo)localObject).rpt_medal_list.get();
        if (localObject == null) {
          break label336;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label336;
        }
        cmd0x3fe.Medal localMedal = (cmd0x3fe.Medal)((Iterator)localObject).next();
        localArrayList.add(new RecvGVideoLevelInfo.Medal(localMedal.uint32_id.get(), localMedal.uint32_level.get(), localMedal.uint32_type.get(), localMedal.str_icon_url.get(), localMedal.str_head_icon_url.get(), localMedal.str_name.get()));
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramToServiceMsg) {}
      QLog.e("TroopHandler", 2, "handleGetGVideoLevelInfo error", paramToServiceMsg);
      return;
      label336:
      paramFromServiceMsg[i1] = new RecvGVideoLevelInfo(l1, i3, i4, i5, i6, i7, i8, i2, i9, (String)paramObject, localArrayList);
      i1 += 1;
    }
    label377:
    a(75, true, paramFromServiceMsg);
  }
  
  public void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject = null;
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      bool2 = bool1;
      paramToServiceMsg = (ToServiceMsg)localObject;
      if (!bool1) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        paramFromServiceMsg = new oidb_0x9fa.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if ((!paramFromServiceMsg.web_info.has()) || (!((oidb_0x9fa.SimilarGroupWebInfo)paramFromServiceMsg.web_info.get()).bytes_url.has())) {
          continue;
        }
        paramToServiceMsg = ((oidb_0x9fa.SimilarGroupWebInfo)paramFromServiceMsg.web_info.get()).bytes_url.get().toStringUtf8();
        bool1 = true;
      }
      catch (Exception paramToServiceMsg)
      {
        bool2 = false;
        paramToServiceMsg = (ToServiceMsg)localObject;
        continue;
        paramToServiceMsg = null;
        continue;
      }
      bool2 = bool1;
      a(65, bool2, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      paramToServiceMsg = null;
    }
  }
  
  /* Error */
  public void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 20
    //   3: iconst_0
    //   4: istore 19
    //   6: aload_1
    //   7: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   10: ldc_w 669
    //   13: invokevirtual 672	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   16: lstore 15
    //   18: aload_1
    //   19: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 674
    //   25: invokevirtual 384	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   28: istore 14
    //   30: aload_1
    //   31: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   34: ldc_w 3253
    //   37: invokevirtual 392	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 6
    //   42: iconst_m1
    //   43: istore 9
    //   45: aload_2
    //   46: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   49: sipush 1000
    //   52: if_icmpne +591 -> 643
    //   55: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   58: dup
    //   59: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: checkcast 407	[B
    //   68: checkcast 407	[B
    //   71: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   74: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: astore_3
    //   78: aload_3
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +54 -> 135
    //   84: aload_1
    //   85: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   88: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   91: istore 10
    //   93: iload 10
    //   95: istore 9
    //   97: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +35 -> 135
    //   103: ldc_w 684
    //   106: iconst_2
    //   107: new 422	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 5272
    //   117: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload 10
    //   122: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iload 10
    //   133: istore 9
    //   135: iload 9
    //   137: ifne +769 -> 906
    //   140: aload_1
    //   141: ifnull +765 -> 906
    //   144: aload_1
    //   145: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   148: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   151: ifeq +755 -> 906
    //   154: aload_1
    //   155: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   158: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   161: ifnull +745 -> 906
    //   164: aload_1
    //   165: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   168: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   171: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   174: astore_1
    //   175: new 599	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   178: dup
    //   179: invokespecial 600	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   182: astore 5
    //   184: aload 5
    //   186: aload_1
    //   187: invokevirtual 601	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   190: pop
    //   191: iload 9
    //   193: ifeq +708 -> 901
    //   196: aload 5
    //   198: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   204: ifeq +697 -> 901
    //   207: aload 5
    //   209: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   212: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   215: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   218: invokestatic 682	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_3
    //   224: iload 9
    //   226: istore 10
    //   228: aload 5
    //   230: getfield 605	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   233: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   236: astore 5
    //   238: aload 5
    //   240: ifnonnull +122 -> 362
    //   243: iconst_0
    //   244: istore 12
    //   246: goto +669 -> 915
    //   249: aload_3
    //   250: ifnonnull +189 -> 439
    //   253: iload 13
    //   255: iload 12
    //   257: if_icmpge +182 -> 439
    //   260: iload 9
    //   262: istore 10
    //   264: aload 5
    //   266: iload 13
    //   268: invokeinterface 611 2 0
    //   273: checkcast 613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   276: astore 7
    //   278: iload 9
    //   280: istore 11
    //   282: aload 7
    //   284: ifnull +610 -> 894
    //   287: iload 9
    //   289: istore 10
    //   291: aload 7
    //   293: getfield 617	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   296: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   299: lstore 17
    //   301: lload 17
    //   303: lload 15
    //   305: lcmp
    //   306: ifeq +72 -> 378
    //   309: iload 13
    //   311: iconst_1
    //   312: iadd
    //   313: istore 13
    //   315: goto -66 -> 249
    //   318: astore_3
    //   319: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +33 -> 355
    //   325: ldc_w 684
    //   328: iconst_2
    //   329: new 422	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 5274
    //   339: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_3
    //   343: invokevirtual 687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   346: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload_3
    //   356: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   359: goto -279 -> 80
    //   362: iload 9
    //   364: istore 10
    //   366: aload 5
    //   368: invokeinterface 665 1 0
    //   373: istore 12
    //   375: goto +540 -> 915
    //   378: iload 9
    //   380: istore 10
    //   382: aload 7
    //   384: getfield 614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   387: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   390: istore 9
    //   392: iload 9
    //   394: istore 11
    //   396: iload 9
    //   398: ifne +496 -> 894
    //   401: iload 9
    //   403: istore 10
    //   405: iload 9
    //   407: istore 11
    //   409: aload 7
    //   411: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   414: invokevirtual 630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   417: ifeq +477 -> 894
    //   420: iload 9
    //   422: istore 10
    //   424: aload 7
    //   426: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   429: invokevirtual 633	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   432: checkcast 629	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   435: astore_3
    //   436: goto -127 -> 309
    //   439: aload_3
    //   440: ifnull +448 -> 888
    //   443: aload_3
    //   444: getfield 3246	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   447: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   450: ifeq +206 -> 656
    //   453: aload_3
    //   454: getfield 3246	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   457: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   460: istore 10
    //   462: aload_3
    //   463: getfield 4588	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   466: invokevirtual 5487	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:has	()Z
    //   469: ifeq +413 -> 882
    //   472: aload_3
    //   473: getfield 4588	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   476: getfield 4584	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:uint32_money_for_add_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   479: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   482: ifeq +400 -> 882
    //   485: aload_3
    //   486: getfield 4588	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   489: getfield 4584	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:uint32_money_for_add_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   492: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   495: i2f
    //   496: ldc_w 5488
    //   499: fmul
    //   500: fstore 4
    //   502: goto +419 -> 921
    //   505: lload 15
    //   507: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   510: astore 7
    //   512: aload_0
    //   513: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   516: bipush 51
    //   518: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   521: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   524: astore 8
    //   526: aload 8
    //   528: ifnull +349 -> 877
    //   531: aload 8
    //   533: aload 7
    //   535: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   538: astore_3
    //   539: aload_3
    //   540: astore 5
    //   542: aload_3
    //   543: ifnonnull +19 -> 562
    //   546: new 652	com/tencent/mobileqq/data/TroopInfo
    //   549: dup
    //   550: invokespecial 653	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   553: astore 5
    //   555: aload 5
    //   557: aload 7
    //   559: putfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   562: aload 5
    //   564: iload 10
    //   566: i2l
    //   567: putfield 2080	com/tencent/mobileqq/data/TroopInfo:troopPrivilegeFlag	J
    //   570: aload 5
    //   572: iload 10
    //   574: i2l
    //   575: putfield 2077	com/tencent/mobileqq/data/TroopInfo:dwAppPrivilegeFlag	J
    //   578: aload 5
    //   580: fload 4
    //   582: putfield 5491	com/tencent/mobileqq/data/TroopInfo:mTroopNeedPayNumber	F
    //   585: aload 8
    //   587: aload 5
    //   589: invokevirtual 662	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   592: aload_0
    //   593: bipush 60
    //   595: iconst_1
    //   596: iconst_5
    //   597: anewarray 359	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: aload 5
    //   604: getfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   607: aastore
    //   608: dup
    //   609: iconst_1
    //   610: aload 5
    //   612: invokevirtual 5378	com/tencent/mobileqq/data/TroopInfo:isAdmin	()Z
    //   615: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   618: aastore
    //   619: dup
    //   620: iconst_2
    //   621: iload 19
    //   623: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   626: aastore
    //   627: dup
    //   628: iconst_3
    //   629: iload 20
    //   631: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   634: aastore
    //   635: dup
    //   636: iconst_4
    //   637: aload 6
    //   639: aastore
    //   640: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   643: return
    //   644: iconst_0
    //   645: istore 19
    //   647: goto +286 -> 933
    //   650: iconst_0
    //   651: istore 20
    //   653: goto -148 -> 505
    //   656: iconst_1
    //   657: istore 19
    //   659: iload 9
    //   661: istore 10
    //   663: aload_1
    //   664: astore_3
    //   665: aload_0
    //   666: bipush 60
    //   668: iload 19
    //   670: iconst_5
    //   671: anewarray 359	java/lang/Object
    //   674: dup
    //   675: iconst_0
    //   676: lload 15
    //   678: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   681: aastore
    //   682: dup
    //   683: iconst_1
    //   684: iconst_1
    //   685: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   688: aastore
    //   689: dup
    //   690: iconst_2
    //   691: iconst_1
    //   692: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   695: aastore
    //   696: dup
    //   697: iconst_3
    //   698: iconst_1
    //   699: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   702: aastore
    //   703: dup
    //   704: iconst_4
    //   705: aload 6
    //   707: aastore
    //   708: invokevirtual 368	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   711: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq -71 -> 643
    //   717: new 422	java/lang/StringBuilder
    //   720: dup
    //   721: sipush 150
    //   724: invokespecial 3182	java/lang/StringBuilder:<init>	(I)V
    //   727: astore_1
    //   728: aload_1
    //   729: ldc_w 5280
    //   732: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: ldc_w 5241
    //   738: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: iload 19
    //   743: invokevirtual 572	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   746: ldc_w 5243
    //   749: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_2
    //   753: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   756: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: ldc_w 3186
    //   762: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: lload 15
    //   767: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   770: ldc_w 3188
    //   773: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: iload 14
    //   778: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   781: ldc_w 5247
    //   784: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: iload 10
    //   789: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   792: ldc_w 5249
    //   795: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_3
    //   799: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: ldc_w 5493
    //   806: iconst_2
    //   807: aload_1
    //   808: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: return
    //   815: astore 5
    //   817: aconst_null
    //   818: astore_1
    //   819: aload_1
    //   820: astore_3
    //   821: iload 9
    //   823: istore 10
    //   825: iload 20
    //   827: istore 19
    //   829: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq -167 -> 665
    //   835: ldc_w 5493
    //   838: iconst_2
    //   839: aload 5
    //   841: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   844: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aload_1
    //   848: astore_3
    //   849: iload 9
    //   851: istore 10
    //   853: iload 20
    //   855: istore 19
    //   857: goto -192 -> 665
    //   860: astore 5
    //   862: iload 10
    //   864: istore 9
    //   866: goto -47 -> 819
    //   869: astore 5
    //   871: iconst_1
    //   872: istore 20
    //   874: goto -55 -> 819
    //   877: aconst_null
    //   878: astore_3
    //   879: goto -340 -> 539
    //   882: fconst_0
    //   883: fstore 4
    //   885: goto +36 -> 921
    //   888: iconst_0
    //   889: istore 19
    //   891: goto -232 -> 659
    //   894: iload 11
    //   896: istore 9
    //   898: goto -589 -> 309
    //   901: aconst_null
    //   902: astore_1
    //   903: goto -681 -> 222
    //   906: aconst_null
    //   907: astore_3
    //   908: iload 9
    //   910: istore 10
    //   912: goto -247 -> 665
    //   915: iconst_0
    //   916: istore 13
    //   918: goto -669 -> 249
    //   921: iload 10
    //   923: sipush 128
    //   926: iand
    //   927: ifeq -283 -> 644
    //   930: iconst_1
    //   931: istore 19
    //   933: iload 10
    //   935: sipush 512
    //   938: iand
    //   939: ifeq -289 -> 650
    //   942: iconst_1
    //   943: istore 20
    //   945: goto -440 -> 505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	948	0	this	TroopHandler
    //   0	948	1	paramToServiceMsg	ToServiceMsg
    //   0	948	2	paramFromServiceMsg	FromServiceMsg
    //   0	948	3	paramObject	Object
    //   500	384	4	f1	float
    //   182	429	5	localObject1	Object
    //   815	25	5	localException1	Exception
    //   860	1	5	localException2	Exception
    //   869	1	5	localException3	Exception
    //   40	666	6	str	String
    //   276	282	7	localObject2	Object
    //   524	62	8	localTroopManager	TroopManager
    //   43	866	9	i1	int
    //   91	848	10	i2	int
    //   280	615	11	i3	int
    //   244	130	12	i4	int
    //   253	664	13	i5	int
    //   28	749	14	i6	int
    //   16	750	15	l1	long
    //   299	3	17	l2	long
    //   4	928	19	bool1	boolean
    //   1	943	20	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   63	78	318	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   175	191	815	java/lang/Exception
    //   196	222	815	java/lang/Exception
    //   228	238	860	java/lang/Exception
    //   264	278	860	java/lang/Exception
    //   291	301	860	java/lang/Exception
    //   366	375	860	java/lang/Exception
    //   382	392	860	java/lang/Exception
    //   409	420	860	java/lang/Exception
    //   424	436	860	java/lang/Exception
    //   443	502	869	java/lang/Exception
    //   505	526	869	java/lang/Exception
    //   531	539	869	java/lang/Exception
    //   546	562	869	java/lang/Exception
    //   562	643	869	java/lang/Exception
  }
  
  /* Error */
  public void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 669
    //   7: invokevirtual 672	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   10: lstore 11
    //   12: aload_2
    //   13: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   16: sipush 1000
    //   19: if_icmpne +430 -> 449
    //   22: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   25: dup
    //   26: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   29: astore_1
    //   30: aload_1
    //   31: aload_3
    //   32: checkcast 407	[B
    //   35: checkcast 407	[B
    //   38: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +402 -> 450
    //   51: aload_1
    //   52: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   55: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   58: istore 7
    //   60: iload 7
    //   62: ifne +387 -> 449
    //   65: aload_1
    //   66: ifnull +383 -> 449
    //   69: aload_1
    //   70: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   73: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   76: ifeq +373 -> 449
    //   79: aload_1
    //   80: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   83: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   86: ifnull +363 -> 449
    //   89: aload_1
    //   90: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   93: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   96: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   99: astore_1
    //   100: new 599	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   103: dup
    //   104: invokespecial 600	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: aload_1
    //   110: invokevirtual 601	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   113: pop
    //   114: iload 7
    //   116: ifeq +27 -> 143
    //   119: aload_2
    //   120: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   126: ifeq +17 -> 143
    //   129: aload_2
    //   130: getfield 679	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: invokestatic 682	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: pop
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_2
    //   146: getfield 605	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   149: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   152: astore 4
    //   154: aload 4
    //   156: ifnonnull +77 -> 233
    //   159: iconst_0
    //   160: istore 7
    //   162: goto +294 -> 456
    //   165: aload_1
    //   166: ifnonnull +283 -> 449
    //   169: iload 8
    //   171: iload 7
    //   173: if_icmpge +276 -> 449
    //   176: aload 4
    //   178: iload 8
    //   180: invokeinterface 611 2 0
    //   185: checkcast 613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   188: astore_3
    //   189: aload_1
    //   190: astore_2
    //   191: aload_3
    //   192: ifnull +22 -> 214
    //   195: aload_3
    //   196: getfield 617	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   199: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   202: lstore 13
    //   204: lload 13
    //   206: lload 11
    //   208: lcmp
    //   209: ifeq +36 -> 245
    //   212: aload_1
    //   213: astore_2
    //   214: iload 8
    //   216: iconst_1
    //   217: iadd
    //   218: istore 8
    //   220: aload_2
    //   221: astore_1
    //   222: goto -57 -> 165
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   230: goto -183 -> 47
    //   233: aload 4
    //   235: invokeinterface 665 1 0
    //   240: istore 7
    //   242: goto +214 -> 456
    //   245: aload_1
    //   246: astore_2
    //   247: aload_3
    //   248: getfield 614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   251: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   254: ifne -40 -> 214
    //   257: aload_1
    //   258: astore_2
    //   259: aload_3
    //   260: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   263: invokevirtual 630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   266: ifeq -52 -> 214
    //   269: aload_3
    //   270: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   273: invokevirtual 633	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   276: checkcast 629	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   279: astore_2
    //   280: aload_2
    //   281: getfield 4634	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_shutup_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   284: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   287: istore 9
    //   289: aload_2
    //   290: getfield 5270	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_shutup_timestamp_me	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   293: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   296: istore 10
    //   298: lload 11
    //   300: invokestatic 551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   303: astore 5
    //   305: aload_0
    //   306: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   309: bipush 51
    //   311: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   314: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   317: astore 6
    //   319: aload 6
    //   321: aload 5
    //   323: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   326: astore_3
    //   327: aload_3
    //   328: astore_1
    //   329: aload_3
    //   330: ifnonnull +17 -> 347
    //   333: new 652	com/tencent/mobileqq/data/TroopInfo
    //   336: dup
    //   337: invokespecial 653	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   340: astore_1
    //   341: aload_1
    //   342: aload 5
    //   344: putfield 656	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   347: aload_1
    //   348: iload 9
    //   350: i2l
    //   351: putfield 2055	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp	J
    //   354: aload_1
    //   355: iload 10
    //   357: i2l
    //   358: putfield 2061	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp_me	J
    //   361: aload_1
    //   362: getfield 2055	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp	J
    //   365: lconst_0
    //   366: lcmp
    //   367: ifne +22 -> 389
    //   370: aload_1
    //   371: getfield 2061	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp_me	J
    //   374: lconst_0
    //   375: lcmp
    //   376: ifne +13 -> 389
    //   379: aload_0
    //   380: getfield 332	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   383: aload 5
    //   385: invokevirtual 1253	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   388: pop
    //   389: aload 6
    //   391: aload_1
    //   392: invokevirtual 662	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   395: aload 6
    //   397: aload 5
    //   399: aload_0
    //   400: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   403: invokevirtual 1497	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   406: aconst_null
    //   407: bipush -100
    //   409: aconst_null
    //   410: aconst_null
    //   411: bipush -100
    //   413: bipush -100
    //   415: bipush -100
    //   417: ldc2_w 5059
    //   420: iload 10
    //   422: i2l
    //   423: invokevirtual 5496	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   426: pop
    //   427: aload_0
    //   428: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   431: bipush 47
    //   433: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   436: checkcast 5498	com/tencent/mobileqq/troop/utils/TroopGagMgr
    //   439: aload 5
    //   441: iconst_1
    //   442: invokevirtual 5500	com/tencent/mobileqq/troop/utils/TroopGagMgr:a	(Ljava/lang/String;Z)V
    //   445: goto -231 -> 214
    //   448: astore_1
    //   449: return
    //   450: iconst_m1
    //   451: istore 7
    //   453: goto -393 -> 60
    //   456: iconst_0
    //   457: istore 8
    //   459: goto -294 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	TroopHandler
    //   0	462	1	paramToServiceMsg	ToServiceMsg
    //   0	462	2	paramFromServiceMsg	FromServiceMsg
    //   0	462	3	paramObject	Object
    //   152	82	4	localList	List
    //   303	137	5	str	String
    //   317	79	6	localTroopManager	TroopManager
    //   58	394	7	i1	int
    //   169	289	8	i2	int
    //   287	62	9	i3	int
    //   296	125	10	i4	int
    //   10	289	11	l1	long
    //   202	3	13	l2	long
    // Exception table:
    //   from	to	target	type
    //   30	45	225	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   100	114	448	java/lang/Exception
    //   119	143	448	java/lang/Exception
    //   145	154	448	java/lang/Exception
    //   176	189	448	java/lang/Exception
    //   195	204	448	java/lang/Exception
    //   233	242	448	java/lang/Exception
    //   247	257	448	java/lang/Exception
    //   259	327	448	java/lang/Exception
    //   333	347	448	java/lang/Exception
    //   347	389	448	java/lang/Exception
    //   389	445	448	java/lang/Exception
  }
  
  public void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i6 = paramToServiceMsg.extraData.getInt("nFlag");
    int i1 = -1;
    Object localObject1;
    int i2;
    int i5;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      for (localObject1 = new oidb_sso.OIDBSSOPkg();; localObject1 = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject3).stgroupinfo.get())
      {
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])paramObject);
          if (paramObject != null)
          {
            i2 = ((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get();
            i1 = i2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + i2);
              i1 = i2;
            }
          }
          if ((i1 != 0) || (paramObject == null) || (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null)) {
            break label855;
          }
          paramObject = ((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray();
          try
          {
            localObject2 = new oidb_0x88d.RspBody();
            ((oidb_0x88d.RspBody)localObject2).mergeFrom((byte[])paramObject);
            if ((i1 == 0) || (!((oidb_0x88d.RspBody)localObject2).str_errorinfo.has())) {
              break label850;
            }
            paramObject = String.valueOf(((oidb_0x88d.RspBody)localObject2).str_errorinfo.get().toByteArray());
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              try
              {
                Object localObject2;
                if (((oidb_0x88d.GroupInfo)localObject1).uint32_app_privilege_flag.has())
                {
                  i2 = ((oidb_0x88d.GroupInfo)localObject1).uint32_app_privilege_flag.get();
                  if ((i2 & 0x1) != 1)
                  {
                    bool1 = true;
                    break;
                    localObject3 = String.valueOf(l1);
                    localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                    localObject2 = localTroopManager.a((String)localObject3);
                    localObject1 = localObject2;
                    if (localObject2 == null)
                    {
                      localObject1 = new TroopInfo();
                      ((TroopInfo)localObject1).troopuin = ((String)localObject3);
                    }
                    ((TroopInfo)localObject1).troopPrivilegeFlag = i2;
                    localTroopManager.b((TroopInfo)localObject1);
                    if (paramToServiceMsg.extraData.getBoolean("needUpdatePreferences", false)) {
                      n((String)localObject3);
                    }
                    a(59, true, new Object[] { Boolean.valueOf(((TroopInfo)localObject1).isAdmin()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject3 });
                    return;
                  }
                  bool1 = false;
                  break;
                  bool2 = false;
                  continue;
                }
                bool1 = true;
                i2 = i1;
                a(59, bool1, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), String.valueOf(l1) });
                if (!QLog.isColorLevel()) {
                  continue;
                }
                paramToServiceMsg = new StringBuilder(150);
                paramToServiceMsg.append("handle_oidb_0x88d_0").append("|isSuccess = ").append(bool1).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|flag = ").append(i6).append("|result = ").append(i2).append("|strErrorMsg = ").append((String)paramObject);
                QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
                return;
              }
              catch (Exception localException3)
              {
                bool2 = true;
                paramToServiceMsg = (ToServiceMsg)paramObject;
                continue;
              }
              localException1 = localException1;
              paramToServiceMsg = null;
              paramObject = paramToServiceMsg;
              i2 = i1;
              bool1 = bool2;
              if (QLog.isColorLevel())
              {
                QLog.i("Q.troopdisband.", 2, localException1.toString());
                paramObject = paramToServiceMsg;
                i2 = i1;
                bool1 = bool2;
                continue;
                paramObject = null;
              }
            }
          }
          localObject1 = null;
          i2 = i1;
          for (;;)
          {
            try
            {
              localObject2 = ((oidb_0x88d.RspBody)localObject2).stzrspgroupinfo.get();
              if (localObject2 != null) {
                continue;
              }
              i4 = 0;
            }
            catch (Exception localException2)
            {
              int i4;
              Object localObject3;
              int i3;
              long l2;
              paramToServiceMsg = (ToServiceMsg)paramObject;
              i1 = i2;
              continue;
              bool1 = false;
              continue;
              i1 = i3;
              continue;
            }
            if ((localObject1 != null) || (i5 >= i4)) {
              continue;
            }
            i2 = i1;
            localObject3 = (oidb_0x88d.RspGroupInfo)((List)localObject2).get(i5);
            i3 = i1;
            if (localObject3 == null) {
              continue;
            }
            i2 = i1;
            l2 = ((oidb_0x88d.RspGroupInfo)localObject3).uint64_group_code.get();
            if (l2 == l1) {
              continue;
            }
            i5 += 1;
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + ((InvalidProtocolBufferMicroException)paramObject).toString());
            }
            ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
            paramObject = localObject1;
          }
          i2 = i1;
          i4 = ((List)localObject2).size();
        }
        i2 = i1;
        i1 = ((oidb_0x88d.RspGroupInfo)localObject3).uint32_result.get();
        i3 = i1;
        if (i1 != 0) {
          break label843;
        }
        i2 = i1;
        i3 = i1;
        if (!((oidb_0x88d.RspGroupInfo)localObject3).stgroupinfo.has()) {
          break label843;
        }
        i2 = i1;
      }
      if (localObject1 == null) {
        break label837;
      }
    }
    for (;;)
    {
      TroopManager localTroopManager;
      label837:
      label843:
      label850:
      label855:
      paramObject = null;
      i2 = i1;
      continue;
      i5 = 0;
      break;
      if ((i2 & 0x2) != 2) {
        bool2 = true;
      }
    }
  }
  
  /* Error */
  public void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 402	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: sipush 1000
    //   7: if_icmpne +204 -> 211
    //   10: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   13: dup
    //   14: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   17: aload_3
    //   18: checkcast 407	[B
    //   21: checkcast 407	[B
    //   24: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +46 -> 78
    //   35: aload_1
    //   36: getfield 589	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   39: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   42: istore 4
    //   44: invokestatic 4288	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +31 -> 78
    //   50: ldc_w 4290
    //   53: iconst_4
    //   54: new 422	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 5504
    //   64: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload 4
    //   69: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 667	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_1
    //   79: ifnull +132 -> 211
    //   82: aload_1
    //   83: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   86: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   89: ifeq +122 -> 211
    //   92: aload_1
    //   93: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   96: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   99: ifnull +112 -> 211
    //   102: aload_1
    //   103: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   106: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   109: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   112: astore_1
    //   113: new 5506	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody
    //   116: dup
    //   117: invokespecial 5507	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody:<init>	()V
    //   120: astore_2
    //   121: aload_2
    //   122: aload_1
    //   123: invokevirtual 5508	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   126: pop
    //   127: aload_2
    //   128: getfield 5512	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody:list	Ltencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList;
    //   131: invokevirtual 5515	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   134: checkcast 5514	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList
    //   137: astore_1
    //   138: aload_1
    //   139: getfield 5518	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList:rpt_tab_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   142: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   145: astore_2
    //   146: aload_1
    //   147: getfield 5521	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList:uint32_curr_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   150: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   153: i2l
    //   154: lstore 5
    //   156: lload 5
    //   158: ldc2_w 2189
    //   161: lcmp
    //   162: ifne +49 -> 211
    //   165: new 548	java/lang/String
    //   168: dup
    //   169: aload_2
    //   170: lload 5
    //   172: l2i
    //   173: invokeinterface 611 2 0
    //   178: checkcast 5523	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$TabItem
    //   181: getfield 5526	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$TabItem:byt_tab_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   184: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   187: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   190: invokespecial 976	java/lang/String:<init>	([B)V
    //   193: pop
    //   194: aload_0
    //   195: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   198: bipush 108
    //   200: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   203: checkcast 2632	com/tencent/mobileqq/troop/utils/TroopAppMgr
    //   206: iconst_1
    //   207: invokevirtual 5529	com/tencent/mobileqq/troop/utils/TroopAppMgr:a	(Z)Ljava/util/List;
    //   210: pop
    //   211: return
    //   212: astore_1
    //   213: invokestatic 4288	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   216: ifeq -5 -> 211
    //   219: ldc_w 4290
    //   222: iconst_4
    //   223: new 422	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 5531
    //   233: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_1
    //   237: invokevirtual 687	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   240: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: return
    //   250: astore_1
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	TroopHandler
    //   0	255	1	paramToServiceMsg	ToServiceMsg
    //   0	255	2	paramFromServiceMsg	FromServiceMsg
    //   0	255	3	paramObject	Object
    //   42	26	4	i1	int
    //   154	17	5	l1	long
    // Exception table:
    //   from	to	target	type
    //   10	31	212	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	156	250	finally
    //   165	211	250	finally
    //   113	156	253	java/lang/Exception
    //   165	211	253	java/lang/Exception
  }
  
  public void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(69, false, new Object[] { Integer.valueOf(-1), "" });
      return;
    }
    paramToServiceMsg = new hw_sso.HwSSORsp();
    int i1;
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      i1 = paramToServiceMsg.err_code.get();
      paramFromServiceMsg = paramToServiceMsg.err_msg.get();
      if (i1 == 0)
      {
        paramFromServiceMsg = new group_mgr.HwQueryCardRsp();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.body.get().toByteArray());
        a(69, true, (group_mgr.CardInfo)paramFromServiceMsg.card_info.get());
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      a(69, false, new Object[] { Integer.valueOf(-1), "" });
      return;
    }
    a(69, false, new Object[] { Integer.valueOf(i1), paramFromServiceMsg });
  }
  
  public void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(70, false, new Object[] { Integer.valueOf(-1), "" });
      return;
    }
    paramToServiceMsg = new hw_sso.HwSSORsp();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      a(70, true, new Object[] { Integer.valueOf(paramToServiceMsg.err_code.get()), paramToServiceMsg.err_msg.get() });
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      a(70, false, new Object[] { Integer.valueOf(-1), "" });
    }
  }
  
  /* Error */
  public void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc -10
    //   6: invokevirtual 672	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   9: lstore 12
    //   11: aload_2
    //   12: invokevirtual 584	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   15: istore 14
    //   17: aload_1
    //   18: getfield 376	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   21: ldc_w 3973
    //   24: invokevirtual 520	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   27: istore 15
    //   29: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq +42 -> 74
    //   35: ldc_w 3967
    //   38: iconst_2
    //   39: new 422	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 5550
    //   49: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: lload 12
    //   54: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   57: ldc_w 887
    //   60: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload 14
    //   65: invokevirtual 572	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   68: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: lload 12
    //   76: lconst_0
    //   77: lcmp
    //   78: ifeq +8 -> 86
    //   81: iload 14
    //   83: ifne +4 -> 87
    //   86: return
    //   87: aload_0
    //   88: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   91: bipush 51
    //   93: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   96: checkcast 647	com/tencent/mobileqq/app/TroopManager
    //   99: astore 4
    //   101: aload 4
    //   103: ifnull +800 -> 903
    //   106: aload 4
    //   108: new 422	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   115: lload 12
    //   117: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   120: ldc_w 706
    //   123: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokevirtual 650	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull -48 -> 86
    //   137: aload_3
    //   138: checkcast 5099	KQQ/RespBatchProcess
    //   141: astore 5
    //   143: aload 5
    //   145: getfield 5102	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   148: ifnull -62 -> 86
    //   151: aload 5
    //   153: getfield 5102	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   156: invokevirtual 1626	java/util/ArrayList:size	()I
    //   159: ifeq -73 -> 86
    //   162: aload 5
    //   164: getfield 5102	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   167: invokevirtual 1626	java/util/ArrayList:size	()I
    //   170: istore 11
    //   172: iconst_0
    //   173: istore 8
    //   175: iload 8
    //   177: iload 11
    //   179: if_icmpge +637 -> 816
    //   182: aload 5
    //   184: getfield 5102	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   187: iload 8
    //   189: invokevirtual 1967	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   192: checkcast 5110	KQQ/BatchResponse
    //   195: astore_2
    //   196: aload_2
    //   197: ifnull +10 -> 207
    //   200: aload_2
    //   201: getfield 5111	KQQ/BatchResponse:result	I
    //   204: ifeq +12 -> 216
    //   207: iload 8
    //   209: iconst_1
    //   210: iadd
    //   211: istore 8
    //   213: goto -38 -> 175
    //   216: aload_2
    //   217: getfield 5112	KQQ/BatchResponse:type	I
    //   220: iconst_1
    //   221: if_icmpne -14 -> 207
    //   224: new 586	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   227: dup
    //   228: invokespecial 587	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   231: astore_3
    //   232: aload_3
    //   233: aload_2
    //   234: getfield 5115	KQQ/BatchResponse:buffer	[B
    //   237: checkcast 407	[B
    //   240: invokevirtual 588	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   243: pop
    //   244: aload_2
    //   245: getfield 5117	KQQ/BatchResponse:seq	I
    //   248: ifne -41 -> 207
    //   251: aload_3
    //   252: ifnull -45 -> 207
    //   255: aload_3
    //   256: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   259: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   262: ifeq -55 -> 207
    //   265: aload_3
    //   266: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   269: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   272: invokevirtual 597	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   275: astore_3
    //   276: new 599	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   279: dup
    //   280: invokespecial 600	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   283: astore_2
    //   284: aload_2
    //   285: aload_3
    //   286: invokevirtual 601	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   289: pop
    //   290: aconst_null
    //   291: astore_3
    //   292: aload_2
    //   293: getfield 605	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   296: invokevirtual 608	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   299: astore 6
    //   301: aload 6
    //   303: ifnonnull +58 -> 361
    //   306: iconst_0
    //   307: istore 9
    //   309: goto +599 -> 908
    //   312: aload_3
    //   313: ifnonnull -106 -> 207
    //   316: iload 10
    //   318: iload 9
    //   320: if_icmpge -113 -> 207
    //   323: aload 6
    //   325: iload 10
    //   327: invokeinterface 611 2 0
    //   332: checkcast 613	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   335: astore 7
    //   337: aload 7
    //   339: ifnonnull +34 -> 373
    //   342: aload_3
    //   343: astore_2
    //   344: iload 10
    //   346: iconst_1
    //   347: iadd
    //   348: istore 10
    //   350: aload_2
    //   351: astore_3
    //   352: goto -40 -> 312
    //   355: astore_1
    //   356: aload_1
    //   357: invokevirtual 1686	java/lang/Exception:printStackTrace	()V
    //   360: return
    //   361: aload 6
    //   363: invokeinterface 665 1 0
    //   368: istore 9
    //   370: goto +538 -> 908
    //   373: aload_3
    //   374: astore_2
    //   375: aload 7
    //   377: getfield 614	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   380: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   383: ifne -39 -> 344
    //   386: aload_3
    //   387: astore_2
    //   388: aload 7
    //   390: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   393: invokevirtual 630	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   396: ifeq -52 -> 344
    //   399: aload 7
    //   401: getfield 627	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   404: invokevirtual 633	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   407: checkcast 629	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   410: astore_3
    //   411: aload_3
    //   412: astore_2
    //   413: aload_3
    //   414: ifnull -70 -> 344
    //   417: aload_3
    //   418: getfield 690	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   421: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   424: ifeq +15 -> 439
    //   427: aload_1
    //   428: aload_3
    //   429: getfield 690	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   432: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   435: i2l
    //   436: putfield 693	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   439: aload_3
    //   440: getfield 5553	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   443: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   446: ifeq +17 -> 463
    //   449: aload_1
    //   450: aload_3
    //   451: getfield 5553	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   454: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   457: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   460: putfield 5556	com/tencent/mobileqq/data/TroopInfo:mGroupClassExtText	Ljava/lang/String;
    //   463: aload_3
    //   464: getfield 4598	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   467: invokevirtual 593	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   470: ifeq +17 -> 487
    //   473: aload_1
    //   474: aload_3
    //   475: getfield 4598	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   478: invokevirtual 455	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   481: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   484: putfield 755	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   487: aload_3
    //   488: getfield 4601	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_face	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   491: invokevirtual 536	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   494: ifeq +15 -> 509
    //   497: aload_1
    //   498: aload_3
    //   499: getfield 4601	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_face	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   502: invokevirtual 420	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   505: i2s
    //   506: putfield 761	com/tencent/mobileqq/data/TroopInfo:troopface	S
    //   509: aload_3
    //   510: getfield 5559	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_subscription_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   513: invokevirtual 543	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   516: ifeq +14 -> 530
    //   519: aload_1
    //   520: aload_3
    //   521: getfield 5559	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_subscription_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   524: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   527: putfield 2086	com/tencent/mobileqq/data/TroopInfo:associatePubAccount	J
    //   530: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq +44 -> 577
    //   536: ldc_w 5561
    //   539: iconst_2
    //   540: new 422	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 5550
    //   550: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: lload 12
    //   555: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   558: ldc_w 887
    //   561: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_1
    //   565: getfield 2086	com/tencent/mobileqq/data/TroopInfo:associatePubAccount	J
    //   568: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: iload 15
    //   579: ifeq +191 -> 770
    //   582: aload_1
    //   583: getfield 693	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   586: ldc2_w 5562
    //   589: lcmp
    //   590: ifne +131 -> 721
    //   593: aload_0
    //   594: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   597: new 422	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   604: lload 12
    //   606: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   609: ldc_w 706
    //   612: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokestatic 5567	com/tencent/mobileqq/troop/utils/HWTroopUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   621: aload_0
    //   622: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   625: invokevirtual 1140	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   628: new 422	java/lang/StringBuilder
    //   631: dup
    //   632: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   635: lload 12
    //   637: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   640: ldc_w 706
    //   643: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokevirtual 5568	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;)Z
    //   652: pop
    //   653: aload_3
    //   654: astore_2
    //   655: aload 4
    //   657: ifnull -313 -> 344
    //   660: aload_3
    //   661: astore_2
    //   662: aload_1
    //   663: ifnull -319 -> 344
    //   666: aload 4
    //   668: aload_1
    //   669: invokevirtual 5570	com/tencent/mobileqq/app/TroopManager:d	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   672: aload_3
    //   673: astore_2
    //   674: goto -330 -> 344
    //   677: astore_2
    //   678: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   681: ifeq +33 -> 714
    //   684: ldc_w 3967
    //   687: iconst_2
    //   688: new 422	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   695: ldc_w 5550
    //   698: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload_2
    //   702: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   705: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   714: aload_2
    //   715: invokevirtual 1686	java/lang/Exception:printStackTrace	()V
    //   718: goto -511 -> 207
    //   721: aload_0
    //   722: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   725: bipush 31
    //   727: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   730: checkcast 5572	com/tencent/mobileqq/troop/data/TroopCreateLogic
    //   733: astore_2
    //   734: aload_2
    //   735: ifnull -114 -> 621
    //   738: aload_2
    //   739: aload_0
    //   740: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   743: new 422	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   750: lload 12
    //   752: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   755: ldc_w 706
    //   758: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokevirtual 5574	com/tencent/mobileqq/troop/data/TroopCreateLogic:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   767: goto -146 -> 621
    //   770: aload_3
    //   771: astore_2
    //   772: aload_1
    //   773: getfield 693	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   776: ldc2_w 5562
    //   779: lcmp
    //   780: ifne -436 -> 344
    //   783: aload_0
    //   784: getfield 639	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   787: new 422	java/lang/StringBuilder
    //   790: dup
    //   791: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   794: lload 12
    //   796: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   799: ldc_w 706
    //   802: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 5575	com/tencent/mobileqq/troop/utils/HWTroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   811: aload_3
    //   812: astore_2
    //   813: goto -469 -> 344
    //   816: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   819: ifeq +68 -> 887
    //   822: ldc_w 3967
    //   825: iconst_2
    //   826: new 422	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   833: ldc_w 5550
    //   836: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: lload 12
    //   841: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   844: ldc_w 887
    //   847: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload_1
    //   851: getfield 693	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   854: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   857: ldc_w 887
    //   860: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload_1
    //   864: getfield 5556	com/tencent/mobileqq/data/TroopInfo:mGroupClassExtText	Ljava/lang/String;
    //   867: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: ldc_w 887
    //   873: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: iload 11
    //   878: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   881: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   887: aload 4
    //   889: ifnull -803 -> 86
    //   892: aload_1
    //   893: ifnull -807 -> 86
    //   896: aload 4
    //   898: aload_1
    //   899: invokevirtual 662	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   902: return
    //   903: aconst_null
    //   904: astore_1
    //   905: goto -772 -> 133
    //   908: iconst_0
    //   909: istore 10
    //   911: goto -599 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	914	0	this	TroopHandler
    //   0	914	1	paramToServiceMsg	ToServiceMsg
    //   0	914	2	paramFromServiceMsg	FromServiceMsg
    //   0	914	3	paramObject	Object
    //   99	798	4	localTroopManager	TroopManager
    //   141	42	5	localRespBatchProcess	RespBatchProcess
    //   299	63	6	localList	List
    //   335	65	7	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    //   173	39	8	i1	int
    //   307	62	9	i2	int
    //   316	594	10	i3	int
    //   170	707	11	i4	int
    //   9	831	12	l1	long
    //   15	67	14	bool1	boolean
    //   27	551	15	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   232	244	355	java/lang/Exception
    //   276	290	677	java/lang/Exception
    //   292	301	677	java/lang/Exception
    //   323	337	677	java/lang/Exception
    //   361	370	677	java/lang/Exception
    //   375	386	677	java/lang/Exception
    //   388	411	677	java/lang/Exception
    //   417	439	677	java/lang/Exception
    //   439	463	677	java/lang/Exception
    //   463	487	677	java/lang/Exception
    //   487	509	677	java/lang/Exception
    //   509	530	677	java/lang/Exception
    //   530	577	677	java/lang/Exception
    //   582	621	677	java/lang/Exception
    //   621	653	677	java/lang/Exception
    //   666	672	677	java/lang/Exception
    //   721	734	677	java/lang/Exception
    //   738	767	677	java/lang/Exception
    //   772	811	677	java/lang/Exception
  }
  
  protected void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
      a(72, false, new Object[] { null });
    }
    int i1;
    boolean bool;
    do
    {
      for (;;)
      {
        return;
        i1 = paramToServiceMsg.extraData.getInt("readType");
        bool = paramToServiceMsg.extraData.getBoolean("appListChangedFromWebOperate");
        if ((i1 == 2) || (i1 == 1))
        {
          paramToServiceMsg = new cmd0xca02.RspBody();
          try
          {
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            if (paramToServiceMsg.uint32_res.get() != 0) {
              break label761;
            }
            paramFromServiceMsg = (TroopAppMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
            if (paramFromServiceMsg != null) {
              break label175;
            }
            a(72, false, new Object[] { null });
            if (QLog.isColorLevel())
            {
              QLog.d("TroopHandler.troop.troop_app", 2, "handleGetTroopAppList==>troopAppMgr == null");
              return;
            }
          }
          catch (Exception paramToServiceMsg)
          {
            a(72, false, new Object[] { null });
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler.troop.troop_app", 2, "Exception, handleGetTroopAppList");
    return;
    label175:
    if (bool) {
      paramFromServiceMsg.b(false);
    }
    paramFromServiceMsg.b(paramToServiceMsg.uint32_timestamp.get());
    paramFromServiceMsg.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.troop_app", 2, "handleGetTroopAppList==>appListTimestamp:" + paramToServiceMsg.uint32_timestamp.get());
    }
    Object localObject = paramToServiceMsg.rpt_result.get();
    paramObject = new ArrayList();
    if (i1 == 1) {}
    for (paramToServiceMsg = new ArrayList();; paramToServiceMsg = null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cmd0xca02.Result localResult = (cmd0xca02.Result)((Iterator)localObject).next();
        if (localResult.uint32_id.get() > 0) {
          if (localResult.uint32_res.get() == 2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopHandler.troop.troop_app", 2, "result.uint32_res.get() == 2|appid:" + localResult.uint32_id.get() + "|appName:" + localResult.string_name.get().toStringUtf8());
            }
            paramFromServiceMsg.a(localResult.uint32_id.get());
          }
          else
          {
            TroopAIOAppInfo localTroopAIOAppInfo = new TroopAIOAppInfo();
            localTroopAIOAppInfo.appid = localResult.uint32_id.get();
            localTroopAIOAppInfo.name = localResult.string_name.get().toStringUtf8();
            localTroopAIOAppInfo.canRemove = localResult.bool_can_remove.get();
            localTroopAIOAppInfo.hashVal = localResult.string_hash_val.get().toStringUtf8();
            if (i1 == 1)
            {
              localArrayList.add(Integer.valueOf(localTroopAIOAppInfo.appid));
              if (!paramFromServiceMsg.a(localTroopAIOAppInfo.appid, localTroopAIOAppInfo.hashVal)) {
                paramToServiceMsg.add(Integer.valueOf(localTroopAIOAppInfo.appid));
              }
            }
            localTroopAIOAppInfo.redPoint = localResult.bool_red_point.get();
            localTroopAIOAppInfo.iconUrl = localResult.string_icon.get().toStringUtf8();
            localTroopAIOAppInfo.url = localResult.string_url.get().toStringUtf8();
            if (((cmd0xca02.AppInfo)localResult.msg_app_info.get()).plat_type.get() == 2) {
              localTroopAIOAppInfo.minVersion = ((cmd0xca02.AppInfo)localResult.msg_app_info.get()).str_app_version.get();
            }
            if (!TroopAIOAppInfo.checkVersion(localTroopAIOAppInfo.minVersion)) {
              localTroopAIOAppInfo.minVersion = "0";
            }
            ((ArrayList)paramObject).add(localTroopAIOAppInfo);
            if (QLog.isColorLevel()) {
              QLog.d(".troop.troop_app", 2, "troopAppInfo:" + localTroopAIOAppInfo.toString());
            }
          }
        }
      }
      if (i1 == 1)
      {
        if ((paramFromServiceMsg.a(localArrayList)) && (paramToServiceMsg.isEmpty())) {
          a(72, true, new Object[] { null });
        }
        if (paramToServiceMsg.isEmpty()) {
          break;
        }
        a(2, paramToServiceMsg, false);
        return;
      }
      paramFromServiceMsg.a((ArrayList)paramObject);
      a(72, true, new Object[] { null });
      return;
      label761:
      a(72, false, new Object[] { null });
      return;
    }
  }
  
  protected void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
      a(73, false, null);
    }
    int i1;
    label170:
    label213:
    do
    {
      cmd0xca04.RspBody localRspBody;
      do
      {
        for (;;)
        {
          return;
          paramFromServiceMsg = paramToServiceMsg.extraData.getIntegerArrayList("appidList2sort");
          localRspBody = new cmd0xca04.RspBody();
          try
          {
            localRspBody.mergeFrom((byte[])paramObject);
            i1 = localRspBody.uint32_res.get();
            if (QLog.isColorLevel()) {
              QLog.d("TroopHandler.troop.troop_app", 2, "onrecive, cmd_troop_sort_app_list, re:" + i1);
            }
            if (i1 != 0) {
              break label213;
            }
            paramObject = (TroopAppMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
            if (paramObject != null) {
              break label170;
            }
            a(73, false, null);
            if (QLog.isColorLevel())
            {
              QLog.d("TroopHandler.troop.troop_app", 2, "troopAppMgr == null");
              return;
            }
          }
          catch (Exception paramToServiceMsg)
          {
            a(73, false, null);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopHandler.troop.troop_app", 2, "Exception, handleSortTroopAppList");
      return;
      ((TroopAppMgr)paramObject).b(localRspBody.uint32_timestamp.get());
      ((TroopAppMgr)paramObject).a(paramFromServiceMsg);
      a(73, true, null);
      a(2, paramToServiceMsg.extraData.getIntegerArrayList("appidToAdd"), false);
      return;
      a(73, false, null);
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler.troop.troop_app", 2, "sort troop apps falied, rspBody.uint32_res:" + i1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\TroopHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */