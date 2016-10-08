package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import GeneralSettings.RespGetSettings;
import GeneralSettings.RespSetSettings;
import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigRes;
import KQQ.ProfSmpInfoRes;
import KQQ.ResRichSigInfo;
import KQQ.RespItem;
import KQQ.SetRichSigRes;
import QQService.BindUinResult;
import QQService.EVIPSPEC;
import QQService.SvcDevLoginInfo;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SummaryCard.RespCondSearch;
import SummaryCard.RespHead;
import SummaryCard.RespSearch;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.etrump.mixlayout.FontManager;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.device_lock_confirm_auth.DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.DeviceInfo;
import com.tencent.ims.device_lock_recommend_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.RspBody;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.FriendAnniver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import friendlist.AddFriendResp;
import friendlist.AddGroupResp;
import friendlist.DelFriendResp;
import friendlist.DelGroupResp;
import friendlist.FriendInfo;
import friendlist.GetAutoInfoResp;
import friendlist.GetFriendListResp;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.GetUserAddFriendSettingResp;
import friendlist.GroupInfo;
import friendlist.LastLoginInfo;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMemResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import friendlist.SetGroupResp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.Key;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import pxu;
import pxv;
import pxw;
import pxx;
import pxy;
import pya;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdRsp;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ReqBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.RspBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdRsp;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.ReqBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.RspBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.UdcUinData;
import tencent.im.oidb.cmd0x77c.cmd0x77c.ReqBody;
import tencent.im.oidb.cmd0x77c.cmd0x77c.RspBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetRecommendSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetRecommendSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.MsgBox;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.OneFrdData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RspBody;
import tencent.im.oidb.cmd0x7c6.cmd0x7c6.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.RspBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.ReqBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FriendListHandler
  extends BusinessHandler
{
  public static final int A = 38;
  public static final int B = 39;
  public static final int C = 41;
  public static final int D = 42;
  public static final int H = 43;
  public static final int I = 44;
  public static final int J = 45;
  public static final int K = 47;
  public static final int L = 48;
  public static final int M = 49;
  public static final int N = 50;
  public static final int O = 51;
  public static final int P = 52;
  public static final int Q = 53;
  public static final int R = 54;
  public static final int S = 55;
  public static final int U = 56;
  public static final int V = 57;
  public static final int W = 58;
  public static final int X = 59;
  public static final int Y = 60;
  public static final int Z = 61;
  public static final byte a = 0;
  public static final int a = 1;
  public static final long a = 2048L;
  public static final String a = "FriendListHandler";
  private static final short jdField_a_of_type_Short = 20002;
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int aA = 88;
  public static final int aB = 89;
  public static final int aC = 90;
  public static final int aD = 91;
  public static final int aE = 92;
  public static final int aF = 93;
  public static final int aG = 94;
  public static final int aH = 95;
  public static final int aI = 96;
  public static final int aJ = 97;
  public static final int aK = 98;
  public static final int aL = 99;
  public static final int aM = 100;
  public static final int aN = 101;
  public static final int aO = 102;
  public static final int aP = 103;
  public static final int aQ = 104;
  public static final int aR = 105;
  public static final int aS = 106;
  public static final int aT = 107;
  public static final int aU = 108;
  public static final int aV = 109;
  public static final int aW = 1;
  public static final int aX = 4;
  public static final int aY = 8;
  public static final int aZ = 11;
  public static final int aa = 62;
  public static final int ab = 63;
  public static final int ac = 64;
  public static final int ad = 65;
  public static final int ae = 66;
  public static final int af = 67;
  public static final int ag = 68;
  public static final int ah = 69;
  public static final int ai = 70;
  public static final int aj = 71;
  public static final int ak = 72;
  public static final int al = 73;
  public static final int am = 74;
  public static final int an = 75;
  public static final int ao = 76;
  public static final int ap = 77;
  public static final int aq = 78;
  public static final int ar = 79;
  public static final int as = 80;
  public static final int at = 81;
  public static final int au = 82;
  public static final int av = 83;
  public static final int aw = 84;
  public static final int ax = 85;
  public static final int ay = 86;
  public static final int az = 87;
  public static final byte b = 1;
  public static final int b = 2;
  public static final long b = 102400L;
  public static final String b = "get_troop_member";
  public static final int bA = 9208;
  public static final int bB = 4051;
  public static final int bC = 1;
  public static final int bD = 2;
  public static final int bE = 146;
  public static final int bF = 147;
  public static final int bG = 1;
  public static final int bH = 2;
  public static final int bI = 3;
  public static final int bJ = 4;
  public static final int bK = 5;
  public static final int bL = 20059;
  public static final int bM = 27025;
  public static final int bN = 27201;
  public static final int bO = 27041;
  public static final int bP = 1;
  public static final int bQ = 2;
  public static final int bR = 3;
  public static final int bS = 0;
  public static final int bT = 1;
  public static final int bU = 2;
  public static final int bV = 3;
  public static final int bW = 1;
  public static final int bX = 2;
  public static final int bY = 3;
  public static final int bZ = 4;
  public static final int ba = 32;
  public static final int bb = 16;
  public static final int bc = 101;
  public static final int bd = 102;
  public static final int be = 103;
  public static final int bf = 104;
  public static final int bg = 105;
  public static final int bh = 106;
  public static final int bi = 107;
  public static final int bj = 108;
  public static final int bk = 110;
  public static final int bl = 111;
  public static final int bm = 112;
  public static final int bn = 1001;
  public static final int bo = 200;
  public static final int bp = 202;
  public static final int bq = 204;
  public static final int br = 60000;
  public static final int bs = 0;
  public static final int bt = 9201;
  public static final int bu = 9202;
  public static final int bv = 9203;
  public static final int bw = 9204;
  public static final int bx = 9205;
  public static final int by = 9206;
  public static final int bz = 9207;
  public static final byte c = 0;
  public static final int c = 3;
  private static final long jdField_c_of_type_Long = 60000L;
  public static final String c = "uin";
  private static final short jdField_c_of_type_Short = 500;
  public static int ca = -1;
  private static final int cb = 20;
  private static final int cc = 200;
  private static final int cd = 100;
  private static final int ch = 0;
  private static final int cj = 15;
  private static int ck = 0;
  public static final byte d = 1;
  public static final int d = 4;
  private static final long jdField_d_of_type_Long = 5000L;
  public static final String d = "safety_flag";
  public static final byte e = 2;
  public static final int e = 5;
  private static final long e = 8L;
  public static final String e = "param_type";
  public static final byte f = 0;
  public static final int f = 6;
  private static final long f = 1800000L;
  public static final String f = "param_uins";
  public static final byte g = 1;
  public static final int g = 7;
  public static final String g = "param_switch_state";
  public static final byte h = 2;
  public static final int h = 8;
  public static final String h = "param_uin";
  public static final byte i = 3;
  public static final int i = 9;
  public static final String i = "param_ring_ids";
  public static final int j = 10;
  private static final long j = 86400000L;
  public static final String j = "param_is_set_switches_of_a_person";
  public static final int k = 11;
  private static final long jdField_k_of_type_Long = 28800000L;
  private static final String jdField_k_of_type_JavaLangString = "Q.qqhead.flh";
  public static final int l = 12;
  private static final long jdField_l_of_type_Long = 15000L;
  private static final String jdField_l_of_type_JavaLangString = "StatusEntry";
  public static final int m = 13;
  public static final int n = 14;
  public static final int o = 15;
  public static final int p = 16;
  public static final int q = 18;
  public static final int r = 19;
  public static final int s = 21;
  public static final int t = 22;
  public static final int u = 27;
  public static final int v = 28;
  public static final int w = 30;
  public static final int x = 33;
  public static final int y = 35;
  public static final int z = 37;
  private QQHeadDownloadHandler jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  private short jdField_b_of_type_Short = 20002;
  private boolean jdField_b_of_type_Boolean;
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private Hashtable jdField_c_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_c_of_type_Boolean;
  private int ce;
  private int cf = -1;
  private volatile int cg = -1;
  private int ci;
  private Hashtable jdField_d_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_d_of_type_Boolean;
  private long g;
  private long h;
  private long i;
  private long m = 15000L;
  private long n;
  private long o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ck = 100;
  }
  
  public FriendListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_MqqOsMqqHandler = new pxu(this, paramQQAppInterface.a().getMainLooper());
    ThreadManager.a(new pxv(this), 2, null, false);
  }
  
  private void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool = true;
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.d("FriendListHandler", 2, "handleReportMayknowExplosure failed");
      }
      if ((bool) && (paramObject != null)) {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
    }
    else
    {
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
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleReportMayknowExplosure", paramFromServiceMsg);
          }
          paramFromServiceMsg.printStackTrace();
          continue;
          bool = false;
        }
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleReportMayknowExplosure" + i1);
        }
        if (i1 == 0) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(158)).a(bool);
      return;
      bool = false;
      break;
    }
  }
  
  private void B(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend resp: " + paramFromServiceMsg + ", data: " + paramObject);
    }
    boolean bool;
    Object localObject;
    if ((??? != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label736;
      }
      ca = 0;
      localObject = new oidb_0x7df.RspBody();
      ??? = a(???, paramFromServiceMsg, paramObject);
      if (??? == null) {
        break label373;
      }
    }
    int i1;
    label373:
    label379:
    label385:
    label391:
    label397:
    label403:
    do
    {
      for (;;)
      {
        try
        {
          ((oidb_0x7df.RspBody)localObject).mergeFrom(???.bytes_bodybuffer.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend isSuccess: " + bool);
          }
          if (!bool) {
            break label736;
          }
          a(95, true, localObject);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend isOver: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_over.has()) {
              break label379;
            }
            i1 = ((oidb_0x7df.RspBody)localObject).uint32_over.get();
            ??? = ???.append(i1).append(", next: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_next_start.has()) {
              break label385;
            }
            i1 = ((oidb_0x7df.RspBody)localObject).uint32_next_start.get();
            ??? = ???.append(i1).append(", total: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_total.has()) {
              break label391;
            }
            i1 = ((oidb_0x7df.RspBody)localObject).uint32_total.get();
            ??? = ???.append(i1).append(", lowest: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_low_score.has()) {
              break label397;
            }
            i1 = ((oidb_0x7df.RspBody)localObject).uint32_low_score.get();
            QLog.d("FriendListHandler", 2, i1);
          }
          if (((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.has()) {
            break label403;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend rpt_msg_friend_score has no data.");
          }
          return;
          bool = false;
        }
        catch (Exception ???)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend RspBody mergeFrom failed.");
          }
          ???.printStackTrace();
          bool = false;
          continue;
        }
        bool = false;
        continue;
        i1 = -1;
        continue;
        i1 = -1;
        continue;
        i1 = -1;
        continue;
        i1 = -1;
      }
      paramFromServiceMsg = ((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.get();
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0)) {
        break label441;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend friendList is null or has no data.");
    return;
    label441:
    paramObject = paramFromServiceMsg.iterator();
    while (((Iterator)paramObject).hasNext())
    {
      localObject = (oidb_0x7df.FriendScore)((Iterator)paramObject).next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend uin: ");
        if (((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.has())
        {
          ??? = String.valueOf(((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.get());
          label512:
          ??? = localStringBuilder.append(???).append(", score: ");
          if (!((oidb_0x7df.FriendScore)localObject).uint32_friend_score.has()) {
            break label679;
          }
          i1 = ((oidb_0x7df.FriendScore)localObject).uint32_friend_score.get();
          label546:
          localStringBuilder = ???.append(i1).append(", relation: ");
          if (!((oidb_0x7df.FriendScore)localObject).bytes_relation_name.has()) {
            break label685;
          }
          ??? = ((oidb_0x7df.FriendScore)localObject).bytes_relation_name.get().toStringUtf8();
          label583:
          ??? = localStringBuilder.append(???).append(", rank: ");
          if (!((oidb_0x7df.FriendScore)localObject).uint32_rank.has()) {
            break label692;
          }
          i1 = ((oidb_0x7df.FriendScore)localObject).uint32_rank.get();
          label617:
          localStringBuilder = ???.append(i1).append(", nick: ");
          if (!((oidb_0x7df.FriendScore)localObject).bytes_nick.has()) {
            break label698;
          }
        }
        label679:
        label685:
        label692:
        label698:
        for (??? = ((oidb_0x7df.FriendScore)localObject).bytes_nick.get().toStringUtf8();; ??? = "")
        {
          QLog.d("FriendListHandler", 2, ???);
          break;
          ??? = "";
          break label512;
          i1 = -1;
          break label546;
          ??? = "";
          break label583;
          i1 = -1;
          break label617;
        }
      }
    }
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramFromServiceMsg);
      return;
    }
    label736:
    ca = 1;
    a(95, false, null);
  }
  
  public static int a(VipBaseInfo paramVipBaseInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(paramInt1));
      if ((paramVipBaseInfo != null) && (paramVipBaseInfo.iVipLevel != -1) && (paramVipBaseInfo.iVipType != -1)) {}
    }
    else
    {
      return paramInt2;
    }
    if (paramVipBaseInfo.bOpen) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      return (paramInt1 << 8 | (byte)paramVipBaseInfo.iVipType & 0xFF) << 16 | (short)paramVipBaseInfo.iVipLevel;
    }
  }
  
  private int a(ToServiceMsg paramToServiceMsg)
  {
    int i1 = 0;
    try
    {
      Object localObject = ByteBuffer.wrap(paramToServiceMsg.getWupBuffer());
      paramToServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
      ((ByteBuffer)localObject).get(paramToServiceMsg);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramToServiceMsg);
      int i2 = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
      i1 = i2;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "getServiceTypeFromToServiceMsg error:" + paramToServiceMsg.getMessage());
    }
    return i1;
    return 0;
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
  
  public static SpecialCareInfo a(QQAppInterface paramQQAppInterface, Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, long paramLong)
  {
    paramQQAppInterface = null;
    Object localObject1 = null;
    if (paramSnsUpateBuffer == null) {}
    while (!paramSnsUpateBuffer.rpt_msg_sns_update_item.has()) {
      return (SpecialCareInfo)localObject1;
    }
    Iterator localIterator = paramSnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
    for (;;)
    {
      localObject1 = paramQQAppInterface;
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject2 = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
      if ((localObject2 != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject2).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.has()))
      {
        localObject1 = paramQQAppInterface;
        if (paramQQAppInterface == null)
        {
          localObject1 = new SpecialCareInfo();
          ((SpecialCareInfo)localObject1).uin = String.valueOf(paramSnsUpateBuffer.uint64_uin.get());
          ((SpecialCareInfo)localObject1).dateTime = paramLong;
        }
        int i1 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).uint32_update_sns_type.get();
        localObject2 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toStringUtf8();
        a((SpecialCareInfo)localObject1, i1, (String)localObject2);
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler", 2, "decodeSC_oidb0x5d0 uin=" + ((SpecialCareInfo)localObject1).uin + ", itemtype=" + i1 + ",itemVal=" + (String)localObject2);
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
      }
    }
  }
  
  private Map a(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        GeneralSettings.Setting localSetting = (GeneralSettings.Setting)paramArrayList.get(i1);
        localHashMap.put(localSetting.Path, Integer.valueOf(Integer.parseInt(localSetting.Value)));
        i1 += 1;
      }
    }
    return localHashMap;
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() " + paramFromServiceMsg.uint32_result.get());
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.a(new pxw(this, paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean), 8, null, false);
      return;
    }
    b(paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean);
  }
  
  private void a(int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
    localMultiBusidUrlReq.srcUidType.set(0);
    localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(16));
    localMultiBusidUrlReq.dstUidType.set(0);
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramArrayList.size()) {
        break label170;
      }
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(i1);
      MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
      try
      {
        localReqUsrInfo.dstUin.set(UinUtils.b(localQQHeadDetails.jdField_a_of_type_JavaLangString));
        a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
        localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ERROR", 2, localException.getMessage());
          }
        }
      }
      i1 += 1;
    }
    label170:
    new HashMap().put("connum", String.valueOf(paramArrayList.size()));
    ToServiceMsg localToServiceMsg = a("MultibusidURLSvr.HeadUrlReq", null);
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("idType", paramInt);
    localToServiceMsg.extraData.putInt("qqHeadType", 16);
    localToServiceMsg.putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_QCall .  idType = " + paramInt);
    }
    b(localToServiceMsg);
  }
  
  private void a(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = a("AvatarInfoSvr.QQHeadUrlReq", null);
    Object localObject = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(i1);
      ((ArrayList)localObject).add(localQQHeadDetails.a());
      a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
      i1 += 1;
    }
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    paramArrayList = new QQHeadUrlReq(paramLong, (ArrayList)localObject, (byte)paramInt);
    localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding("UTF-8");
    paramArrayList.writeTo((JceOutputStream)localObject);
    localToServiceMsg.extraData.putByteArray("QQHeadUrlReq", ((JceOutputStream)localObject).toByteArray());
    a(localToServiceMsg);
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ToServiceMsg localToServiceMsg = a("friendlist.GetLastLoginInfoReq");
    localToServiceMsg.extraData.putLong("uin", l1);
    localToServiceMsg.extraData.putLong("total_req_times", paramLong1);
    localToServiceMsg.extraData.putLong("current_req_index", paramLong2);
    localToServiceMsg.extraData.putLong("current_req_uin", paramLong3);
    a(localToServiceMsg);
  }
  
  private void a(FriendsManager paramFriendsManager)
  {
    Object localObject = QvipSpecialCareManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((paramFriendsManager != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramFriendsManager.b(str))
        {
          QvipSpecialCareManager.b(str, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          if (QvipSpecialCareManager.b(str, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
            QvipSpecialCareManager.c(str, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
      }
    }
  }
  
  private void a(FriendsManager paramFriendsManager, String paramString)
  {
    paramString = paramFriendsManager.a(paramString + "");
    if (paramString != null)
    {
      paramString.bestIntimacyType = 0;
      paramString.bestIntimacyDays = 0;
      paramString.praiseHotLevel = 0;
      paramString.chatHotLevel = 0;
      paramFriendsManager.a(paramString);
    }
  }
  
  public static void a(SpecialCareInfo paramSpecialCareInfo, int paramInt, String paramString)
  {
    if (paramInt == 13568) {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramSpecialCareInfo.specialRingSwitch = 0;
          return;
        }
        if (!Pattern.compile("[0-9]*").matcher(paramString).matches()) {
          return;
        }
        paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString);
        paramSpecialCareInfo.specialRingSwitch = 1;
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramString);
        }
        paramSpecialCareInfo.specialRingSwitch = 0;
        return;
      }
    }
    if (paramInt == 13573)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label111;
        }
        paramSpecialCareInfo.globalSwitch = 0;
        return;
      }
      catch (Exception paramSpecialCareInfo)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
      return;
      label111:
      paramSpecialCareInfo.globalSwitch = 1;
      return;
    }
    if (paramInt == 13572) {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramSpecialCareInfo.qzoneSwitch = 0;
          return;
        }
      }
      catch (Exception paramSpecialCareInfo)
      {
        if (QLog.isColorLevel())
        {
          QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
          return;
          paramSpecialCareInfo.qzoneSwitch = 1;
        }
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, DelFriendResp paramDelFriendResp)
  {
    if (paramDelFriendResp.errorCode != 0)
    {
      a(15, false, null);
      return;
    }
    paramFromServiceMsg = (PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.b();
    }
    paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    paramFromServiceMsg.d(String.valueOf(paramDelFriendResp.deluin));
    a(paramFromServiceMsg, String.valueOf(paramDelFriendResp.deluin));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(paramDelFriendResp.deluin), true);
    a(15, true, Long.valueOf(paramDelFriendResp.deluin));
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetLastLoginInfoResp paramGetLastLoginInfoResp)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramGetLastLoginInfoResp != null) && (paramGetLastLoginInfoResp.errorCode == 0))
    {
      paramFromServiceMsg = paramGetLastLoginInfoResp.stPageInfo;
      ArrayList localArrayList = paramGetLastLoginInfoResp.vecLastLoginInfo;
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      a(localArrayList);
      if (paramFromServiceMsg.dwCurrentReqIndex == paramFromServiceMsg.dwTotalReqTimes)
      {
        ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramGetLastLoginInfoResp.iRefreshIntervalMin);
        a(48, true, Boolean.valueOf(true));
      }
      while (paramFromServiceMsg.dwCurrentReqIndex >= paramFromServiceMsg.dwTotalReqTimes) {
        return;
      }
      a(48, true, Boolean.valueOf(false));
      a(paramFromServiceMsg.dwTotalReqTimes, paramFromServiceMsg.dwCurrentReqIndex, paramFromServiceMsg.dwCurrentReqUin);
      return;
    }
    a(48, false, Boolean.valueOf(true));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localStringBuilder.append("handleGetQQHeadError, result=").append(paramInt).append(", uinListSize=");
    if (localArrayList != null) {}
    for (int i1 = localArrayList.size();; i1 = -1)
    {
      ((StringBuilder)localObject).append(i1);
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        break;
      }
      QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
      return;
    }
    i1 = 0;
    if (i1 < localArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)localArrayList.get(i1);
      String str = localQQHeadDetails.jdField_a_of_type_Int + "_" + localQQHeadDetails.jdField_a_of_type_JavaLangString;
      int i2;
      if (localQQHeadDetails.jdField_a_of_type_Int == 32)
      {
        i2 = paramToServiceMsg.extraData.getInt("subtype");
        localObject = "stranger_" + i2 + "_" + str;
      }
      for (;;)
      {
        b((String)localObject, true);
        a(9201, (String)localObject, localQQHeadDetails.jdField_a_of_type_Int, 2, 0, null, paramInt, 0L);
        if (localQQHeadDetails != null) {
          localStringBuilder.append("; uin=").append((String)localObject).append(", timestamp=").append(localQQHeadDetails.jdField_a_of_type_Long);
        }
        i1 += 1;
        break;
        localObject = str;
        if (localQQHeadDetails.jdField_a_of_type_Int == 16)
        {
          i2 = paramToServiceMsg.extraData.getInt("subtype");
          localObject = "qcall_" + i2 + "_" + str;
        }
      }
    }
    QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getInt("setId") == 4051) {
      b(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void a(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, QQHeadUrlResp paramQQHeadUrlResp)
  {
    int i1;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramQQHeadUrlResp == null) || (paramQQHeadUrlResp.result != 0) || (paramQQHeadUrlResp.UserHeadInfoList == null))
    {
      i1 = 65535;
      if (paramQQHeadUrlResp != null)
      {
        i1 = paramQQHeadUrlResp.result;
        a(???, i1);
      }
    }
    for (;;)
    {
      return;
      if (paramFromServiceMsg == null) {
        break;
      }
      i1 = paramFromServiceMsg.getResultCode();
      break;
      paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        ??? = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        for (;;)
        {
          if (!paramFromServiceMsg.hasNext()) {
            break label229;
          }
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramFromServiceMsg.next();
          Iterator localIterator = paramQQHeadUrlResp.UserHeadInfoList.iterator();
          if (localIterator.hasNext())
          {
            QQHeadInfo localQQHeadInfo = (QQHeadInfo)localIterator.next();
            if (((localQQHeadInfo.dstUsrType == 11) || (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(Long.toString(localQQHeadInfo.uin)))) && ((localQQHeadInfo.dstUsrType != 11) || (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(localQQHeadInfo.phoneNum)))) {
              break;
            }
            localQQHeadInfo.headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
            ???.add(localQQHeadInfo);
          }
        }
        label229:
        paramQQHeadUrlResp.UserHeadInfoList = ???;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        i1 = 0;
        if (i1 >= paramQQHeadUrlResp.UserHeadInfoList.size()) {
          continue;
        }
        ??? = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(i1);
        a(0, a(???.dstUsrType, ???.uin, ???.phoneNum), ???.dstUsrType, 2);
        paramFromServiceMsg = new FaceInfo();
        paramFromServiceMsg.jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
        this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a(paramFromServiceMsg);
        i1 += 1;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespGetSettings paramRespGetSettings)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "handleGetGeneralSettingAll cmd=" + paramFromServiceMsg.getMsfCommand() + " resp.isSucc=" + paramFromServiceMsg.isSuccess() + " resultCode=" + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      int i3 = paramToServiceMsg.extraData.getInt("Revision");
      int i2 = paramToServiceMsg.extraData.getInt("respRevision", -1);
      boolean bool = paramToServiceMsg.extraData.getBoolean("needTroopSettings");
      long l1 = paramToServiceMsg.extraData.getLong("Offset");
      paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
      if (paramRespGetSettings == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerGetGeneralSettingAll, data == null");
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(false, true);
        a(35, false, new Object[] { Boolean.valueOf(true) });
        return;
      }
      if ((paramRespGetSettings.Settings == null) || (paramRespGetSettings.Settings.size() == 0))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("handlerGetGeneralSettingAll, data.Settings=");
          if (paramRespGetSettings.Settings != null) {
            break label289;
          }
        }
        label289:
        for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
        {
          QLog.d("RoamSetting", 2, paramToServiceMsg);
          DBUtils.a().a(paramRespGetSettings.Revision, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(true, true);
          a(35, true, new Object[] { Boolean.valueOf(true) });
          return;
        }
      }
      if ((i2 != -1) && (i2 < paramRespGetSettings.Revision))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "respRevision != data.Revision, load settings again, respRev=" + i2 + " data.Rev=" + paramRespGetSettings.Revision);
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(false, false);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(bool);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      int i1 = i2;
      if (i2 == -1) {
        i1 = paramRespGetSettings.Revision;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("oldRevision=").append(i3).append(" lastRespRevision=").append(i1).append(" total=").append(paramRespGetSettings.Total).append(" offset=").append(l1).append(" data.settings.size=");
        if (paramRespGetSettings.Settings != null) {
          break label591;
        }
      }
      label591:
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
      {
        QLog.d("RoamSetting", 2, paramToServiceMsg);
        DBUtils.a().a(paramRespGetSettings.Settings, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        l1 += paramRespGetSettings.Settings.size();
        if (paramRespGetSettings.Total <= l1) {
          break;
        }
        ((RoamSettingController)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30)).a(i3, l1, i1, bool, null);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      DBUtils.a().a(paramRespGetSettings.Revision, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(true, true);
      a(35, true, new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(false, true);
    a(35, false, new Object[] { Boolean.valueOf(true) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespSetSettings paramRespSetSettings)
  {
    Object localObject1 = (ArrayList)paramToServiceMsg.extraData.getSerializable("Settings");
    int i1 = paramToServiceMsg.extraData.getInt("localRevision");
    Object localObject2;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("handlerUploadRoamSettingNewValue isSuccess = ").append(paramFromServiceMsg.isSuccess()).append(" reqLocalRevision=").append(i1).append(" data.Revision=");
      if (paramRespSetSettings == null)
      {
        paramToServiceMsg = "null";
        QLog.d("FriendListHandler", 2, paramToServiceMsg);
      }
    }
    else
    {
      paramToServiceMsg = (RoamSettingController)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30);
      if (!paramFromServiceMsg.isSuccess()) {
        break label216;
      }
      if (paramRespSetSettings == null) {
        break label1220;
      }
      if (i1 + 1 != paramRespSetSettings.Revision) {
        break label201;
      }
      DBUtils.a().a((ArrayList)localObject1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      DBUtils.a().a(paramRespSetSettings.Revision, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.h(true, false);
      bool2 = true;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerUploadRoamSettingNewValue  settings is null.");
        }
        return;
        paramToServiceMsg = Integer.valueOf(paramRespSetSettings.Revision);
        break;
        label201:
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.h(true, true);
        bool2 = true;
        continue;
        label216:
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.h(false, false);
        bool2 = false;
        continue;
      }
      paramFromServiceMsg = b((ArrayList)localObject1);
      paramRespSetSettings = ((ArrayList)localObject1).iterator();
      boolean bool1 = false;
      label247:
      if (paramRespSetSettings.hasNext())
      {
        localObject1 = (GeneralSettings.Setting)paramRespSetSettings.next();
        if (((GeneralSettings.Setting)localObject1).Path == null) {
          break label1217;
        }
        if (!((GeneralSettings.Setting)localObject1).Path.startsWith("message.group.policy.")) {
          break label494;
        }
        if ((bool1) || ((!bool2) && ((bool2) || (!paramToServiceMsg.a())))) {
          break label405;
        }
        localObject1 = paramFromServiceMsg.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          Boolean localBoolean = (Boolean)paramToServiceMsg.c.get(localObject2);
          if ((localBoolean != null) && (localBoolean.booleanValue())) {
            paramToServiceMsg.c.put(localObject2, Boolean.valueOf(false));
          }
        }
        a(38, bool2, paramFromServiceMsg);
        bool1 = true;
      }
      label405:
      label494:
      label1217:
      for (;;)
      {
        break label247;
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + " hasNotifyTroop=" + bool1 + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          continue;
          if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.ring.switch"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(43, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.vibrate.switch"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(44, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("sync.c2c_message"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(47, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.group.ring"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(41, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.group.vibrate"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(42, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.ring.care")) {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(78, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "-->handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
        }
      }
      label1220:
      bool2 = true;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRespKikOut paramSvcRespKikOut)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerKickOutDev index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRespKikOut == null)
      {
        a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i1) });
        return;
      }
      a(52, true, new Object[] { Long.valueOf(paramSvcRespKikOut.appid), Integer.valueOf(paramSvcRespKikOut.result), Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRespKikOut == null)
    {
      a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i1) });
      return;
    }
    a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i1) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspBindUin paramSvcRspBindUin)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlerBindUinStaus() success");
      }
      if (paramSvcRspBindUin != null)
      {
        paramToServiceMsg = paramSvcRspBindUin.vecResult;
        if (paramToServiceMsg != null)
        {
          int i1 = 0;
          if (i1 < paramToServiceMsg.size())
          {
            paramFromServiceMsg = (BindUinResult)paramToServiceMsg.get(i1);
            if (paramFromServiceMsg == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "result iResult = " + paramFromServiceMsg.iResult + "; lUin = " + paramFromServiceMsg.lUin + "; strResult = " + paramFromServiceMsg.strResult);
              }
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("FriendListHandler", 2, "handlerBindUinStaus res no success");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(61, false, new Object[] { null, Integer.valueOf(i1) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(61, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
        return;
      }
      a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(61, false, new Object[] { null, Integer.valueOf(i1) });
      return;
    }
    a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(50, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i1;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i1);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerMultiClientList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i1);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              a(50, true, new Object[] { paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo });
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(50, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(50, false, null);
      return;
    }
    a(50, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    bool2 = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleInfoOpenId ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label225;
      }
    }
    label225:
    for (int i1 = paramArrayOfByte.length;; i1 = -1)
    {
      QLog.d("FriendListHandler", 2, i1);
      paramToServiceMsg = paramToServiceMsg.extraData;
      bool1 = bool2;
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          break;
        }
        paramArrayOfByte = new oidb_0x5e1.RspBody();
        paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramArrayOfByte.rpt_msg_uin_data.size() <= 0) {
          break;
        }
        paramFromServiceMsg = new String(((oidb_0x5e1.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(0)).bytes_nick.get().toByteArray());
        paramToServiceMsg.putString("nick_name", paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleInfoOpenId " + paramFromServiceMsg);
        }
        bool1 = true;
      }
      catch (Throwable paramFromServiceMsg)
      {
        for (;;)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("FriendListHandler", 2, "", paramFromServiceMsg);
            bool1 = bool2;
            continue;
            bool1 = false;
          }
        }
      }
      a(74, bool1, paramToServiceMsg);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if ((paramGetFriendListResp.result == 1) || (paramGetFriendListResp.vecFriendInfo == null) || (paramGetFriendListResp.vecFriendInfo.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo failed");
      }
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
    Friends localFriends1 = new Friends();
    localFriends1.name = localFriendInfo.nick;
    if (localFriendInfo.isRemark == 1) {
      paramToServiceMsg = localFriendInfo.remark;
    }
    boolean bool;
    label174:
    label340:
    SpecialCareInfo localSpecialCareInfo;
    label579:
    Friends localFriends2;
    for (;;)
    {
      localFriends1.remark = paramToServiceMsg;
      localFriends1.uin = String.valueOf(localFriendInfo.friendUin);
      localFriends1.faceid = localFriendInfo.faceId;
      localFriends1.groupid = localFriendInfo.groupId;
      localFriends1.sqqtype = localFriendInfo.sqqtype;
      localFriends1.status = localFriendInfo.status;
      localFriends1.cSpecialFlag = localFriendInfo.cSpecialFlag;
      if (localFriendInfo.isMqqOnLine == 1)
      {
        bool = true;
        localFriends1.isMqqOnLine = bool;
        localFriends1.sqqOnLineState = localFriendInfo.sqqOnLineState;
        localFriends1.detalStatusFlag = localFriendInfo.detalStatusFlag;
        localFriends1.memberLevel = localFriendInfo.memberLevel;
        localFriends1.alias = localFriendInfo.sShowName;
        localFriends1.isRemark = localFriendInfo.isRemark;
        localFriends1.isIphoneOnline = localFriendInfo.isIphoneOnline;
        localFriends1.iTermType = localFriendInfo.iTermType;
        localFriends1.cNetwork = localFriendInfo.cNetwork;
        localFriends1.abilityBits = localFriendInfo.uAbiFlag;
        localFriends1.netTypeIconId = localFriendInfo.eIconType;
        localFriends1.strTermDesc = localFriendInfo.strTermDesc;
        if (localFriends1.eNetwork != localFriendInfo.eNetworkType)
        {
          localFriends1.eNetwork = localFriendInfo.eNetworkType;
          a(13, true, null);
        }
        localFriends1.setShieldFlag(false);
        paramToServiceMsg = localFriendsManager.c(localFriends1.uin);
        if (paramToServiceMsg != null)
        {
          if (paramToServiceMsg.gathtertype != 1) {
            break label579;
          }
          localFriends1.gathtertype = 1;
          localFriends1.age = paramToServiceMsg.age;
          localFriends1.smartRemark = paramToServiceMsg.smartRemark;
          localFriends1.gender = paramToServiceMsg.gender;
          localFriends1.recommReason = paramToServiceMsg.recommReason;
          if (((paramToServiceMsg.gathtertype == 1) || (paramToServiceMsg.gathtertype == 2)) && (QLog.isColorLevel())) {
            QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendDetailInfo  friend.gathtertype = " + localFriends1.gathtertype + " | friend.age = " + localFriends1.age + " | friend.recommReason = " + localFriends1.recommReason);
          }
        }
        paramGetFriendListResp = localFriendInfo.vecRing;
        paramToServiceMsg = new Oidb_0x5d0.SnsUpateBuffer();
      }
      try
      {
        paramToServiceMsg.mergeFrom(paramGetFriendListResp);
        a(paramToServiceMsg, localFriendInfo.friendUin);
        localSpecialCareInfo = a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, 0L);
        localFriendsManager.a(localSpecialCareInfo);
        a(paramToServiceMsg, localFriendsManager);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.rpt_uin32_idlist.has()))
        {
          paramToServiceMsg = paramToServiceMsg.rpt_uin32_idlist.get().iterator();
          for (;;)
          {
            if (paramToServiceMsg.hasNext()) {
              if (((Integer)paramToServiceMsg.next()).intValue() == 4051)
              {
                localFriends1.setShieldFlag(true);
                continue;
                paramToServiceMsg = "";
                break;
                bool = false;
                break label174;
                if (paramToServiceMsg.gathtertype != 2) {
                  break label340;
                }
                localFriends1.gathtertype = 2;
              }
            }
          }
        }
      }
      catch (Exception paramGetFriendListResp)
      {
        for (;;)
        {
          paramToServiceMsg = null;
          paramGetFriendListResp.printStackTrace();
        }
        localFriends2 = localFriendsManager.c(localFriends1.uin);
        paramToServiceMsg = localFriendInfo.oVipInfo;
        i2 = EVIPSPEC.E_SP_QQVIP.value();
        if (localFriends2 == null) {
          break label1283;
        }
      }
    }
    int i1 = localFriends2.qqVipInfo;
    localFriends1.qqVipInfo = a(paramToServiceMsg, i2, i1);
    paramToServiceMsg = localFriendInfo.oVipInfo;
    int i2 = EVIPSPEC.E_SP_SUPERQQ.value();
    if (localFriends2 != null)
    {
      i1 = localFriends2.superQqInfo;
      label680:
      localFriends1.superQqInfo = a(paramToServiceMsg, i2, i1);
      paramToServiceMsg = localFriendInfo.oVipInfo;
      i2 = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends2 == null) {
        break label1295;
      }
      i1 = localFriends2.superVipInfo;
      label718:
      localFriends1.superVipInfo = a(paramToServiceMsg, i2, i1);
      if (localFriends2 != null)
      {
        localFriends1.signature = localFriends2.signature;
        localFriends1.datetime = localFriends2.datetime;
        localFriends1.lastLoginType = localFriends2.lastLoginType;
        if (localFriends2.gathtertype == 1)
        {
          localFriends1.gender = localFriends2.gender;
          localFriends1.age = localFriends2.age;
          localFriends1.smartRemark = localFriends2.smartRemark;
          localFriends1.recommReason = localFriends2.recommReason;
        }
      }
      if (localFriends2 == null) {
        break label1307;
      }
      if (localFriends2.groupid == localFriends1.groupid) {
        break label1301;
      }
      bool = true;
    }
    for (;;)
    {
      localFriendsManager.a(localFriends1, bool);
      if (localFriendsManager != null)
      {
        paramGetFriendListResp = localFriendsManager.a(localFriends2.uin);
        paramToServiceMsg = paramGetFriendListResp;
        if (paramGetFriendListResp == null)
        {
          paramToServiceMsg = new ExtensionInfo();
          paramToServiceMsg.uin = localFriends2.uin;
        }
        paramToServiceMsg.pendantId = localFriendInfo.ulFaceAddonId;
        paramToServiceMsg.uVipFont = FontManager.a(localFriendInfo.uFounderFont);
        paramToServiceMsg.vipFontType = FontManager.a(localFriendInfo.uFounderFont);
        paramToServiceMsg.colorRingId = localFriendInfo.uColorRing;
        paramToServiceMsg.timestamp = System.currentTimeMillis();
        localFriendsManager.a(paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo, Get ExtensionInfo, uin=" + localFriends2.uin + ", id=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont + ", fontType = " + paramToServiceMsg.vipFontType);
        }
      }
      paramToServiceMsg = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      paramGetFriendListResp = paramToServiceMsg.b(localFriends2.uin);
      if ((paramGetFriendListResp.apolloStatus != localFriendInfo.cApolloFlag) || (paramGetFriendListResp.apolloServerTS != localFriendInfo.uApolloTimestamp))
      {
        paramGetFriendListResp.apolloStatus = localFriendInfo.cApolloFlag;
        paramGetFriendListResp.apolloServerTS = localFriendInfo.uApolloTimestamp;
        paramToServiceMsg.a(paramGetFriendListResp);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo, update apollo info uin=" + localFriends2.uin + "apollo status: " + localFriendInfo.cApolloFlag + ", apollo svr TS: " + localFriendInfo.uApolloTimestamp);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "$handleGetFriendDetailInfo | uin = " + localFriends1.uin + " | group = " + localFriends1.groupid);
      }
      if (this.g == 0L) {
        a(1, true, Boolean.valueOf(true));
      }
      paramToServiceMsg = new ArrayList();
      paramToServiceMsg.add(localSpecialCareInfo);
      a(99, true, new Object[] { Boolean.valueOf(true), paramToServiceMsg });
      paramToServiceMsg = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.f();
      }
      b(new String[] { localFriends1.uin });
      return;
      label1283:
      i1 = 0;
      break;
      i1 = 0;
      break label680;
      label1295:
      i1 = 0;
      break label718;
      label1301:
      bool = false;
      continue;
      label1307:
      if (localFriends1.groupid != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetUserAddFriendSettingResp paramGetUserAddFriendSettingResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    if ((paramGetUserAddFriendSettingResp != null) && (paramGetUserAddFriendSettingResp.result == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleAddFriendSetting " + paramGetUserAddFriendSettingResp.queryuinsetting + ", " + paramGetUserAddFriendSettingResp.contact_bothway_friend + ", " + paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      }
      paramToServiceMsg.putInt("friend_setting", paramGetUserAddFriendSettingResp.queryuinsetting);
      paramToServiceMsg.putStringArrayList("user_question", paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      paramToServiceMsg.putBoolean("contact_bothway", paramGetUserAddFriendSettingResp.contact_bothway_friend);
      a(12, true, paramToServiceMsg);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleAddFriendSetting ");
      if (paramGetUserAddFriendSettingResp == null) {
        break label173;
      }
    }
    label173:
    for (int i1 = paramGetUserAddFriendSettingResp.result;; i1 = 55536)
    {
      QLog.d("FriendListHandler", 2, i1);
      a(12, false, paramToServiceMsg);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, MovGroupMemResp paramMovGroupMemResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    String str = paramToServiceMsg.getString("uin");
    byte b1 = paramToServiceMsg.getByte("group_id");
    byte b2 = paramToServiceMsg.getByte("away_group_id");
    if (paramMovGroupMemResp.result == 0)
    {
      ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(str, b1);
      a(9, true, new Object[] { str, Byte.valueOf(b1), Byte.valueOf(b2) });
      return;
    }
    a(9, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, SetGroupResp paramSetGroupResp)
  {
    boolean bool;
    int i1;
    if (paramSetGroupResp.result == 0)
    {
      bool = true;
      i1 = paramToServiceMsg.extraData.getInt("set_type", -1);
      if (i1 == paramSetGroupResp.reqtype) {
        break label656;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleSetGroupResp | unmatched reqtype, local = " + i1 + ", remote = " + paramSetGroupResp.reqtype);
      }
      bool = false;
    }
    label295:
    label478:
    label656:
    for (;;)
    {
      Object localObject1 = ByteBuffer.wrap(paramSetGroupResp.vecBody);
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      Object localObject2;
      switch (i1)
      {
      default: 
        return;
        bool = false;
        break;
      case 0: 
        localObject2 = new AddGroupResp();
        if (bool)
        {
          ((AddGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject2).cGroupId = ((ByteBuffer)localObject1).get();
          ((AddGroupResp)localObject2).cSortId = ((ByteBuffer)localObject1).get();
          localObject1 = localFriendsManager.a(((AddGroupResp)localObject2).cGroupId + "");
          if (localObject1 == null) {
            break label295;
          }
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject2).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject2).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
        for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = (ToServiceMsg)localObject1)
        {
          localFriendsManager.a(paramToServiceMsg);
          a(18, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (AddGroupResp)localObject2));
          return;
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject2).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject2).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
      case 1: 
        localObject2 = new RenameGroupResp();
        if (bool)
        {
          ((RenameGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((RenameGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          i1 = ((ByteBuffer)localObject1).get();
          ((RenameGroupResp)localObject2).cLen = ((ByteBuffer)localObject1).get();
          paramToServiceMsg = new byte[((RenameGroupResp)localObject2).cLen];
          ((ByteBuffer)localObject1).get(paramToServiceMsg, 0, ((RenameGroupResp)localObject2).cLen);
          ((RenameGroupResp)localObject2).sGroupName = new String(paramToServiceMsg);
          paramToServiceMsg = localFriendsManager.a(String.valueOf(i1));
          if (paramToServiceMsg == null) {
            break label478;
          }
        }
        for (paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName;; paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName)
        {
          localFriendsManager.a(paramToServiceMsg);
          a(19, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (RenameGroupResp)localObject2));
          return;
          paramToServiceMsg = new Groups();
          paramToServiceMsg.group_id = ((int)((RenameGroupResp)localObject2).dwSequence);
        }
      case 2: 
        paramToServiceMsg = new DelGroupResp();
        if (bool)
        {
          paramToServiceMsg.dwToUin = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.dwSequence = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.cGroupid = ((ByteBuffer)localObject1).get();
        }
        a(paramToServiceMsg, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, paramToServiceMsg));
        return;
      case 3: 
        localObject2 = new ReSortGroupResp();
        if (bool)
        {
          ((ReSortGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((ReSortGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          localFriendsManager.a(paramToServiceMsg.extraData.getByteArray("group_id_list"), paramToServiceMsg.extraData.getByteArray("sort_id_list"));
        }
        a(22, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (ReSortGroupResp)localObject2));
        return;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject2 = (GetRichSigRes)paramObject;
    Object localObject1 = (CircleManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    if ((localObject2 == null) || (((GetRichSigRes)localObject2).cResult != 0) || (((GetRichSigRes)localObject2).vstSigInfo == null) || (((GetRichSigRes)localObject2).vstSigInfo.size() == 0) || (localObject1 == null)) {}
    do
    {
      return;
      paramObject = new ArrayList();
      ArrayList localArrayList = new ArrayList(((GetRichSigRes)localObject2).vstSigInfo.size());
      localObject2 = ((GetRichSigRes)localObject2).vstSigInfo.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject2).next();
        String str = Long.toString(localResRichSigInfo.lUin);
        if ((localObject1 != null) && ((localResRichSigInfo.cStatus == 0) || (localResRichSigInfo.cStatus == 1)))
        {
          CircleBuddy localCircleBuddy = ((CircleManager)localObject1).a(String.valueOf(localResRichSigInfo.lUin));
          if (localCircleBuddy != null)
          {
            localCircleBuddy.checkUpdateTime = System.currentTimeMillis();
            if (localResRichSigInfo.cStatus == 1)
            {
              localCircleBuddy.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
              localArrayList.add(localCircleBuddy);
              ((ArrayList)paramObject).add(str);
            }
          }
        }
      }
      if (localObject1 != null) {
        ((CircleManager)localObject1).a(localArrayList);
      }
    } while (((ArrayList)paramObject).size() <= 0);
    localObject1 = new String[((ArrayList)paramObject).size()];
    ((ArrayList)paramObject).toArray((Object[])localObject1);
    a(64, true, new Object[] { localObject1, paramToServiceMsg.extraData.getBundle("circleBundle") });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Oidb_0x5d1.RspBody paramRspBody)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    int i1 = paramRspBody.uint32_cmd.get();
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    String str = "";
    long l2;
    int i2;
    boolean bool1;
    label258:
    boolean bool2;
    if ((i1 == 1) && (paramRspBody.msg_set_friend_id.has()))
    {
      paramToServiceMsg = (Oidb_0x5d1.SetFriendIdRsp)paramRspBody.msg_set_friend_id.get();
      l2 = paramToServiceMsg.uint64_seq.get();
      i2 = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i1 + "result : " + i2 + " newSeq:" + l2);
      }
      if (i2 == 0)
      {
        paramRspBody = localFriendsManager.c(String.valueOf(l1));
        paramToServiceMsg = str;
        if (paramRspBody != null)
        {
          paramRspBody.setShieldFlag(true);
          localFriendsManager.a(paramRspBody);
          paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
          l2 = MessageCache.a();
          paramRspBody = MessageRecordFactory.a(63524);
          paramRspBody.init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, "你已屏蔽%s的会话", l2, 0, 0, l2);
          paramRspBody.msgtype = 63524;
          paramRspBody.isread = true;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspBody, paramToServiceMsg);
          paramToServiceMsg = str;
        }
        if (i2 != 0) {
          break label327;
        }
        bool1 = true;
        if (i2 != 0) {
          break label333;
        }
        bool2 = true;
        label266:
        a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
      }
    }
    label327:
    label333:
    label558:
    label627:
    label633:
    do
    {
      return;
      paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
      break;
      bool1 = false;
      break label258;
      bool2 = false;
      break label266;
      if ((i1 == 2) && (paramRspBody.msg_clear_friend_id.has()))
      {
        paramToServiceMsg = (Oidb_0x5d1.ClearFriendIdRsp)paramRspBody.msg_clear_friend_id.get();
        l2 = paramToServiceMsg.uint64_seq.get();
        i2 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i1 + "result : " + i2 + " newSeq:" + l2);
        }
        if (i2 == 0)
        {
          paramToServiceMsg = localFriendsManager.c(String.valueOf(l1));
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.setShieldFlag(false);
            localFriendsManager.a(paramToServiceMsg);
            paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
            l2 = MessageCache.a();
            paramRspBody = MessageRecordFactory.a(63524);
            paramRspBody.init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, "你已允许接收%s的会话", l2, 0, 0, l2);
            paramRspBody.msgtype = 63524;
            paramRspBody.isread = true;
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspBody, paramToServiceMsg);
          }
          paramToServiceMsg = "";
          if (i2 != 0) {
            break label627;
          }
          bool1 = true;
          if (i2 != 0) {
            break label633;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(false), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
          return;
          paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
          break;
          bool1 = false;
          break label558;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler", 2, "<---handleSetFriendShieldFlagResp : cmd:" + i1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    int i1 = paramToServiceMsg.extraData.getInt("bType");
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lToMID"));
    int i2 = paramToServiceMsg.extraData.getByte("bGroupId");
    if (i1 == 1) {
      i1 = 2;
    }
    for (;;)
    {
      if (i1 == 0)
      {
        paramToServiceMsg.extraData.getString("strNickName");
        a(str, i2, 10004, null, false, false, -1L);
      }
      paramToServiceMsg = str + "_answer_added_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
      ContactConfig.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), paramToServiceMsg, i1);
      a(10, true, new Object[] { str, Integer.valueOf(i1) });
      return;
    }
  }
  
  private void a(AddFriendResp paramAddFriendResp, ToServiceMsg paramToServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramToServiceMsg.extraData);
    if (paramAddFriendResp == null)
    {
      a(11, false, localBundle);
      return;
    }
    localBundle.putInt("resultCode", paramAddFriendResp.result);
    localBundle.putString("ErrorString", paramAddFriendResp.ErrorString);
    if (paramAddFriendResp.result == 0)
    {
      paramToServiceMsg = paramToServiceMsg.extraData;
      boolean bool1 = paramToServiceMsg.getBoolean("auto_send", false);
      int i2 = paramToServiceMsg.getInt("source_id");
      boolean bool2 = paramToServiceMsg.getBoolean("contact_bothway");
      int i1;
      if ((bool1) && (AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i2, bool2)))
      {
        i1 = 1;
        if ((bool1) && (i1 != 0) && (paramAddFriendResp.adduin != 0L)) {
          a(String.valueOf(paramAddFriendResp.adduin), paramAddFriendResp.myfriendgroupid, i2, paramToServiceMsg.getString("src_name"), true, false, -1L);
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("$handleAddFriend|autoSend=").append(bool1).append(",uin").append(paramAddFriendResp.adduin).append(",sourceId=").append(i2).append(",beBothWay=").append(bool2).append(",successDirectly=").append(AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i2, bool2));
          QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
        }
        localBundle.putByteArray("sig", paramAddFriendResp.sig);
        localBundle.putString("result_uin", String.valueOf(paramAddFriendResp.adduin));
        if ((!bool1) || (i1 == 0)) {
          break label316;
        }
      }
      label316:
      for (bool1 = true;; bool1 = false)
      {
        localBundle.putBoolean("addDirect", bool1);
        a(11, true, localBundle);
        return;
        i1 = 0;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "ErrorString" + paramAddFriendResp.ErrorString + "resultCode" + paramAddFriendResp.result);
    }
    a(11, true, localBundle);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getFriendGroupList " + paramBoolean1 + ", " + paramString + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramLong);
    }
    if (!paramBoolean1)
    {
      if (((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).e()) {
        a(1, true, null);
      }
    }
    else {
      a(1, true, Boolean.valueOf(false));
    }
    paramString = a("friendlist.getFriendGroupList");
    paramString.setEnableFastResend(true);
    paramString.extraData.putLong("timeStamp", paramLong);
    paramString.extraData.putStringArrayList("uinList", paramArrayList);
    paramString.extraData.putShort("friendStartIndex", (short)paramInt1);
    paramString.extraData.putShort("friendCount", (short)paramInt2);
    paramString.extraData.putByte("groupStartIndex", (byte)paramInt3);
    paramString.extraData.getByte("groupCount", (byte)paramInt4);
    paramString.extraData.putLong("startTime", System.currentTimeMillis());
    paramString.extraData.putByte("ifShowTermType", (byte)1);
    paramString.extraData.putBoolean("is_manual_pull_refresh", paramBoolean2);
    a(paramString);
  }
  
  private void a(String paramString, GetFriendListResp paramGetFriendListResp, long paramLong, ArrayList paramArrayList, boolean paramBoolean)
  {
    int i3 = paramGetFriendListResp.startIndex;
    int i4 = paramGetFriendListResp.friend_count;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + paramGetFriendListResp.result + ", " + paramGetFriendListResp.serverTime + ", " + i3 + ", " + i4 + " totalCount=" + paramGetFriendListResp.totoal_friend_count);
    }
    if (paramGetFriendListResp.result == 1)
    {
      QLog.e("FriendListHandler", 2, "handleGetFriendList fail code");
      a(1, false, Boolean.valueOf(false));
      a(99, false, null);
      return;
    }
    TraceUtils.a("handleGetFriendList");
    if (i3 == 0)
    {
      this.ci = 0;
      paramLong = System.currentTimeMillis();
    }
    b(paramGetFriendListResp.cShowPcIcon);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    ApolloManager localApolloManager = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    OlympicTorchManager localOlympicTorchManager = ((OlympicManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a();
    Object localObject2;
    Object localObject1;
    if ((paramGetFriendListResp.stSelfInfo != null) && (i3 == 0))
    {
      localObject4 = paramGetFriendListResp.stSelfInfo;
      localObject2 = localFriendsManager.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new Friends();
        ((Friends)localObject2).name = ((FriendInfo)localObject4).nick;
        if (((FriendInfo)localObject4).isRemark != 1) {
          break label672;
        }
        localObject1 = ((FriendInfo)localObject4).remark;
        ((Friends)localObject2).remark = ((String)localObject1);
        ((Friends)localObject2).uin = String.valueOf(((FriendInfo)localObject4).friendUin);
        ((Friends)localObject2).faceid = ((FriendInfo)localObject4).faceId;
        ((Friends)localObject2).sqqtype = ((FriendInfo)localObject4).sqqtype;
        ((Friends)localObject2).status = ((FriendInfo)localObject4).status;
        ((Friends)localObject2).cSpecialFlag = ((FriendInfo)localObject4).cSpecialFlag;
        if (((FriendInfo)localObject4).isMqqOnLine != 1) {
          break label680;
        }
      }
    }
    int i1;
    label672:
    label680:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((Friends)localObject2).isMqqOnLine = bool1;
      ((Friends)localObject2).sqqOnLineState = ((FriendInfo)localObject4).sqqOnLineState;
      ((Friends)localObject2).detalStatusFlag = ((FriendInfo)localObject4).detalStatusFlag;
      ((Friends)localObject2).memberLevel = ((FriendInfo)localObject4).memberLevel;
      ((Friends)localObject2).alias = ((FriendInfo)localObject4).sShowName;
      ((Friends)localObject2).isRemark = ((FriendInfo)localObject4).isRemark;
      ((Friends)localObject2).isIphoneOnline = ((FriendInfo)localObject4).isIphoneOnline;
      localObject1 = localObject2;
      ((Friends)localObject1).cNetwork = ((FriendInfo)localObject4).cNetwork;
      ((Friends)localObject1).abilityBits = ((FriendInfo)localObject4).uAbiFlag;
      ((Friends)localObject1).eNetwork = ((FriendInfo)localObject4).eNetworkType;
      ((Friends)localObject1).groupid = -1;
      ((Friends)localObject1).qqVipInfo = a(((FriendInfo)localObject4).oVipInfo, EVIPSPEC.E_SP_QQVIP.value(), ((Friends)localObject1).qqVipInfo);
      ((Friends)localObject1).superQqInfo = a(((FriendInfo)localObject4).oVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), ((Friends)localObject1).superQqInfo);
      ((Friends)localObject1).superVipInfo = a(((FriendInfo)localObject4).oVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), ((Friends)localObject1).superVipInfo);
      localFriendsManager.a((Friends)localObject1);
      i2 = paramGetFriendListResp.vecGroupInfo.size();
      localObject1 = new Groups[i2];
      i1 = 0;
      while (i1 < i2)
      {
        localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(i1);
        localObject4 = new Groups();
        ((Groups)localObject4).group_id = ((GroupInfo)localObject2).groupId;
        ((Groups)localObject4).group_name = ((GroupInfo)localObject2).groupname;
        ((Groups)localObject4).group_online_friend_count = ((GroupInfo)localObject2).online_friend_count;
        ((Groups)localObject4).group_friend_count = ((GroupInfo)localObject2).friend_count;
        ((Groups)localObject4).sqqOnLine_count = ((GroupInfo)localObject2).sqqOnLine_count;
        ((Groups)localObject4).seqid = ((GroupInfo)localObject2).seqid;
        ((Groups)localObject4).datetime = paramLong;
        localObject1[i1] = localObject4;
        i1 += 1;
      }
      localObject1 = "";
      break;
    }
    if ((i2 > 0) && (QLog.isColorLevel()))
    {
      localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(0);
      QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + Utils.a(((GroupInfo)localObject2).groupname) + ", " + ((GroupInfo)localObject2).friend_count + ", " + ((GroupInfo)localObject2).sqqOnLine_count + ", " + ((GroupInfo)localObject2).seqid);
    }
    localFriendsManager.a((Groups[])localObject1);
    int i5 = paramGetFriendListResp.vecFriendInfo.size();
    this.ci += i5;
    Friends[] arrayOfFriends = new Friends[i5];
    ArrayList localArrayList1 = new ArrayList(i5);
    ArrayList localArrayList2 = new ArrayList(i5);
    if (i3 + i4 >= paramGetFriendListResp.totoal_friend_count) {
      bool1 = true;
    }
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    HashMap localHashMap;
    ArrayList localArrayList5;
    ArrayList localArrayList6;
    ArrayList localArrayList7;
    FriendInfo localFriendInfo;
    Friends localFriends;
    label981:
    label1074:
    label1365:
    label1371:
    Object localObject3;
    for (;;)
    {
      Set localSet = QvipSpecialCareManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      localArrayList3 = new ArrayList();
      localArrayList4 = new ArrayList();
      localHashMap = new HashMap();
      localArrayList5 = new ArrayList();
      localArrayList6 = new ArrayList();
      localArrayList7 = new ArrayList(i5);
      i1 = 0;
      if (i1 >= i5) {
        break label2148;
      }
      localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(i1);
      localFriends = new Friends();
      localFriends.name = localFriendInfo.nick;
      boolean bool2;
      if (localFriendInfo.isRemark == 1)
      {
        localObject1 = localFriendInfo.remark;
        localFriends.remark = ((String)localObject1);
        localFriends.uin = String.valueOf(localFriendInfo.friendUin);
        paramArrayList.add(localFriends.uin);
        localFriends.faceid = localFriendInfo.faceId;
        localFriends.groupid = localFriendInfo.groupId;
        localFriends.sqqtype = localFriendInfo.sqqtype;
        localFriends.status = localFriendInfo.status;
        localFriends.cSpecialFlag = localFriendInfo.cSpecialFlag;
        if (localFriendInfo.isMqqOnLine != 1) {
          break label1365;
        }
        bool2 = true;
        localFriends.isMqqOnLine = bool2;
        localFriends.sqqOnLineState = localFriendInfo.sqqOnLineState;
        localFriends.detalStatusFlag = localFriendInfo.detalStatusFlag;
        localFriends.memberLevel = localFriendInfo.memberLevel;
        localFriends.datetime = paramLong;
        localFriends.alias = localFriendInfo.sShowName;
        localFriends.isRemark = localFriendInfo.isRemark;
        localFriends.cNetwork = localFriendInfo.cNetwork;
        localFriends.abilityBits = localFriendInfo.uAbiFlag;
        localFriends.eNetwork = localFriendInfo.eNetworkType;
        localFriends.netTypeIconId = localFriendInfo.eIconType;
        localFriends.strTermDesc = localFriendInfo.strTermDesc;
        localFriends.setShieldFlag(false);
        if (localFriendInfo.cOlympicTorch != 1) {
          break label1371;
        }
        bool2 = true;
        localFriends.setOlympicTorchFlag(bool2);
        localArrayList7.add(new Pair(localFriends.uin, Boolean.valueOf(bool2)));
        localObject2 = localFriendInfo.vecRing;
        localObject1 = new Oidb_0x5d0.SnsUpateBuffer();
      }
      try
      {
        ((Oidb_0x5d0.SnsUpateBuffer)localObject1).mergeFrom((byte[])localObject2);
        a((Oidb_0x5d0.SnsUpateBuffer)localObject1, localFriendInfo.friendUin, localSet, localArrayList3, localArrayList4, localHashMap, localArrayList5);
        if ((localObject1 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_uin32_idlist.has()))
        {
          localObject2 = ((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_uin32_idlist.get().iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext()) {
              if (((Integer)((Iterator)localObject2).next()).intValue() == 4051)
              {
                localFriends.setShieldFlag(true);
                continue;
                bool1 = false;
                break;
                localObject1 = "";
                break label981;
                bool2 = false;
                break label1074;
                bool2 = false;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = null;
          localException.printStackTrace();
        }
        a((Oidb_0x5d0.SnsUpateBuffer)localObject1, localFriendsManager);
        localFriends.isIphoneOnline = localFriendInfo.isIphoneOnline;
        localObject3 = localFriendsManager.c(localFriends.uin);
        localFriends.iTermType = localFriendInfo.iTermType;
        localObject4 = localFriendInfo.oVipInfo;
        i6 = EVIPSPEC.E_SP_QQVIP.value();
        if (localObject3 == null) {
          break label1941;
        }
      }
    }
    int i2 = ((Friends)localObject3).qqVipInfo;
    label1457:
    localFriends.qqVipInfo = a((VipBaseInfo)localObject4, i6, i2);
    Object localObject4 = localFriendInfo.oVipInfo;
    int i6 = EVIPSPEC.E_SP_SUPERQQ.value();
    if (localObject3 != null)
    {
      i2 = ((Friends)localObject3).superQqInfo;
      label1498:
      localFriends.superQqInfo = a((VipBaseInfo)localObject4, i6, i2);
      localObject4 = localFriendInfo.oVipInfo;
      i6 = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localObject3 == null) {
        break label1953;
      }
      i2 = ((Friends)localObject3).superVipInfo;
      label1539:
      localFriends.superVipInfo = a((VipBaseInfo)localObject4, i6, i2);
      if (localObject3 != null)
      {
        localFriends.showLoginClient = ((Friends)localObject3).showLoginClient;
        localFriends.lastLoginType = ((Friends)localObject3).lastLoginType;
      }
      if (localObject3 != null)
      {
        if (((Friends)localObject3).gathtertype != 1) {
          break label1959;
        }
        localFriends.gathtertype = 1;
        label1598:
        localFriends.age = ((Friends)localObject3).age;
        localFriends.smartRemark = ((Friends)localObject3).smartRemark;
        localFriends.gender = ((Friends)localObject3).gender;
        localFriends.recommReason = ((Friends)localObject3).recommReason;
      }
      arrayOfFriends[i1] = localFriends;
      localObject4 = localFriendsManager.a(String.valueOf(localFriends.uin));
      if (localObject4 != null) {
        break label1977;
      }
      localObject3 = new ExtensionInfo();
      ((ExtensionInfo)localObject3).uin = String.valueOf(localFriends.uin);
      ((ExtensionInfo)localObject3).pendantId = localFriendInfo.ulFaceAddonId;
      ((ExtensionInfo)localObject3).uVipFont = FontManager.a(localFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject3).vipFontType = FontManager.a(localFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject3).colorRingId = localFriendInfo.uColorRing;
      ((ExtensionInfo)localObject3).timestamp = paramLong;
      localArrayList1.add(localObject3);
      label1747:
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendList, Get Extension, uin=" + ((ExtensionInfo)localObject3).uin + ", id=" + ((ExtensionInfo)localObject3).pendantId + ",font=" + ((ExtensionInfo)localObject3).uVipFont + ", fontType = " + ((ExtensionInfo)localObject3).vipFontType);
      }
      localObject1 = a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (Oidb_0x5d0.SnsUpateBuffer)localObject1, paramLong);
      if ((localObject1 != null) && (((SpecialCareInfo)localObject1).globalSwitch != 0)) {
        localArrayList6.add(localObject1);
      }
      localObject1 = localApolloManager.b(localFriends.uin);
      if (localObject1 == null) {
        break label2109;
      }
      if ((((ApolloBaseInfo)localObject1).apolloStatus != localFriendInfo.cApolloFlag) || (((ApolloBaseInfo)localObject1).apolloServerTS != localFriendInfo.uApolloTimestamp))
      {
        ((ApolloBaseInfo)localObject1).apolloStatus = localFriendInfo.cApolloFlag;
        ((ApolloBaseInfo)localObject1).apolloServerTS = localFriendInfo.uApolloTimestamp;
        localArrayList2.add(localObject1);
      }
    }
    for (;;)
    {
      i1 += 1;
      break;
      label1941:
      i2 = 0;
      break label1457;
      i2 = 0;
      break label1498;
      label1953:
      i2 = 0;
      break label1539;
      label1959:
      if (((Friends)localObject3).gathtertype != 2) {
        break label1598;
      }
      localFriends.gathtertype = 2;
      break label1598;
      label1977:
      if ((((ExtensionInfo)localObject4).pendantId == localFriendInfo.ulFaceAddonId) && (((ExtensionInfo)localObject4).uVipFont == FontManager.a(localFriendInfo.uFounderFont)) && (((ExtensionInfo)localObject4).vipFontType == FontManager.a(localFriendInfo.uFounderFont)))
      {
        localObject3 = localObject4;
        if (((ExtensionInfo)localObject4).colorRingId == localFriendInfo.uColorRing) {
          break label1747;
        }
      }
      ((ExtensionInfo)localObject4).pendantId = localFriendInfo.ulFaceAddonId;
      ((ExtensionInfo)localObject4).uVipFont = FontManager.a(localFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject4).vipFontType = FontManager.a(localFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject4).colorRingId = localFriendInfo.uColorRing;
      ((ExtensionInfo)localObject4).timestamp = paramLong;
      localArrayList1.add(localObject4);
      localObject3 = localObject4;
      break label1747;
      label2109:
      if (QLog.isColorLevel()) {
        QLog.e("FriendListHandler", 2, "apolloBaseInfo return null uin: " + localFriends.uin);
      }
    }
    label2148:
    if ((i5 > 0) && (QLog.isColorLevel()))
    {
      localObject1 = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
      QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendList uin=" + ((FriendInfo)localObject1).friendUin + " | eNetwork=" + ((FriendInfo)localObject1).eNetworkType + " | iTermType=" + ((FriendInfo)localObject1).iTermType + " | abilityBits=" + ((FriendInfo)localObject1).uAbiFlag + " | name=" + Utils.a(((FriendInfo)localObject1).nick) + " | netTypeIconId=" + ((FriendInfo)localObject1).eIconType + " | detalStatusFlag=" + ((FriendInfo)localObject1).detalStatusFlag + " | isMqqOnLine=" + ((FriendInfo)localObject1).isMqqOnLine + " | netTypeIconIdIphoneOrWphoneNoWifi=" + ((FriendInfo)localObject1).eIconType + " | hasTorch=" + ((FriendInfo)localObject1).cOlympicTorch);
    }
    localFriendsManager.a(arrayOfFriends, paramLong, bool1);
    localFriendsManager.b(localArrayList1);
    localFriendsManager.a(localArrayList6, paramLong, bool1);
    localApolloManager.c(localArrayList2);
    localOlympicTorchManager.a(localArrayList7, bool1, 1000);
    QvipSpecialCareManager.a(localArrayList3, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    QvipSpecialCareManager.b(localArrayList4, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    QvipSpecialCareManager.a(localHashMap, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    QvipSpecialCareManager.c(localArrayList5, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    TraceUtils.a();
    if (!bool1)
    {
      a(paramString, i3 + i4, 200, 0, 0, paramLong, paramArrayList, true, paramBoolean);
      a(1, true, Boolean.valueOf(false));
      a(99, true, new Object[] { Boolean.valueOf(false), null });
      return;
    }
    this.g = 0L;
    this.ci = 0;
    paramString = new StringBuilder().append("actual friend count is ");
    if (this.ci == paramGetFriendListResp.totoal_friend_count)
    {
      bool1 = true;
      QLog.d("FriendListHandler", 2, bool1);
      paramString = (PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (paramString != null)
      {
        paramString.f();
        if (!paramBoolean) {
          paramString.b();
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.z();
      a(1, true, Boolean.valueOf(true));
      a(99, true, new Object[] { Boolean.valueOf(true), null });
      if (!paramArrayList.isEmpty())
      {
        paramString = new String[paramArrayList.size()];
        paramArrayList.toArray(paramString);
        paramArrayList.clear();
        if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.c()) {
          break label2737;
        }
        a(paramString);
      }
    }
    for (;;)
    {
      a(localFriendsManager);
      paramLong = paramGetFriendListResp.serverTime;
      this.h = paramLong;
      i1 = 1;
      while (i1 < 16)
      {
        if (i1 != 13) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp" + i1, paramLong).commit();
        }
        i1 += 1;
      }
      bool1 = false;
      break;
      label2737:
      this.jdField_a_of_type_ArrayOfJavaLangString = paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler in handleGetFriendList() to getGatheredContactsList()");
    }
    f(0);
  }
  
  private void a(List paramList)
  {
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("saveLastLoginInfos begin ");
      if (paramList != null)
      {
        i1 = paramList.size();
        QLog.d("FriendListHandler", 2, i1);
      }
    }
    else
    {
      localObject1 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localObject2 = ((FriendsManager)localObject1).c();
      if ((paramList == null) || (localObject2 == null)) {
        break label338;
      }
      localArrayList = new ArrayList(((ArrayList)localObject2).size());
      if (paramList.size() != 0) {
        break label192;
      }
      paramList = ((ArrayList)localObject2).iterator();
      label103:
      while (paramList.hasNext())
      {
        localObject2 = (Friends)paramList.next();
        if (localObject2 != null)
        {
          if (((Friends)localObject2).lastLoginType == 0L) {
            break label360;
          }
          ((Friends)localObject2).lastLoginType = 0L;
        }
      }
    }
    label192:
    label338:
    label354:
    label360:
    for (int i1 = 1;; i1 = 0)
    {
      if (((Friends)localObject2).showLoginClient != 0L)
      {
        ((Friends)localObject2).showLoginClient = 0L;
        i1 = 1;
      }
      if (i1 == 0) {
        break label103;
      }
      localArrayList.add(localObject2);
      break label103;
      i1 = -1;
      break;
      paramList = paramList.iterator();
      Friends localFriends;
      while (paramList.hasNext())
      {
        localObject2 = (LastLoginInfo)paramList.next();
        localFriends = ((FriendsManager)localObject1).c(String.valueOf(((LastLoginInfo)localObject2).dwFriendUin));
        if (localFriends != null)
        {
          if (localFriends.showLoginClient == ((LastLoginInfo)localObject2).dwClient) {
            break label354;
          }
          localFriends.showLoginClient = ((LastLoginInfo)localObject2).dwClient;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (localFriends.lastLoginType != ((LastLoginInfo)localObject2).dwLastLoginType)
        {
          localFriends.lastLoginType = ((LastLoginInfo)localObject2).dwLastLoginType;
          i1 = 1;
        }
        if (i1 == 0) {
          break;
        }
        localArrayList.add(localFriends);
        break;
        ((FriendsManager)localObject1).a((Friends[])localArrayList.toArray(new Friends[localArrayList.size()]), localArrayList.size());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "saveLastLoginInfos ends ");
        }
        return;
      }
    }
  }
  
  private void a(Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, long paramLong)
  {
    if (paramSnsUpateBuffer == null) {}
    do
    {
      for (;;)
      {
        return;
        if (!paramSnsUpateBuffer.rpt_msg_sns_update_item.has()) {
          break;
        }
        Iterator localIterator = paramSnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
        while (localIterator.hasNext())
        {
          Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
          if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has()) && (localSnsUpdateItem.uint32_update_sns_type.get() == 13568)) {
            QvipSpecialCareManager.a(String.valueOf(paramSnsUpateBuffer.uint64_uin.get()), localSnsUpdateItem.bytes_value.get().toStringUtf8(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
      }
      paramSnsUpateBuffer = String.valueOf(paramLong);
      if (QvipSpecialCareManager.a(paramSnsUpateBuffer, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        QvipSpecialCareManager.b(paramSnsUpateBuffer, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    } while (!QvipSpecialCareManager.b(paramSnsUpateBuffer, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
    QvipSpecialCareManager.c(paramSnsUpateBuffer, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, long paramLong, Set paramSet, List paramList1, List paramList2, Map paramMap, List paramList3)
  {
    if (paramSnsUpateBuffer == null) {}
    do
    {
      for (;;)
      {
        return;
        if (!paramSnsUpateBuffer.rpt_msg_sns_update_item.has()) {
          break;
        }
        Iterator localIterator = paramSnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
          if ((localObject != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.get() == 13568))
          {
            String str = String.valueOf(paramSnsUpateBuffer.uint64_uin.get());
            localObject = ((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.get().toStringUtf8();
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              if ((paramSet != null) && (paramSet.contains(str))) {
                paramList2.add(str);
              }
              if (QvipSpecialCareManager.b(str, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
                paramList3.add(str);
              }
            }
            else
            {
              try
              {
                int i1 = Integer.parseInt((String)localObject);
                paramList1.add(str);
                paramMap.put(str, Integer.valueOf(i1));
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel()) {
                QLog.i("FriendListHandler", 2, "dealWithRespSound|exception = " + localException.toString());
              }
            }
          }
        }
      }
      paramSnsUpateBuffer = String.valueOf(paramLong);
      if ((paramSet != null) && (paramSet.contains(paramSnsUpateBuffer))) {
        paramList2.add(paramSnsUpateBuffer);
      }
    } while (!QvipSpecialCareManager.b(paramSnsUpateBuffer, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
    paramList3.add(paramSnsUpateBuffer);
  }
  
  private void a(Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, FriendsManager paramFriendsManager)
  {
    Object localObject;
    String str;
    byte[] arrayOfByte;
    int i7;
    if ((paramSnsUpateBuffer != null) && (paramSnsUpateBuffer.rpt_msg_sns_update_item.has()))
    {
      Iterator localIterator = paramSnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
        if ((localObject != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.get() == 13575))
        {
          str = String.valueOf(paramSnsUpateBuffer.uint64_uin.get());
          arrayOfByte = ((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.get().toByteArray();
          i7 = arrayOfByte.length;
          localObject = paramFriendsManager.a(str);
          if (localObject != null) {
            break label437;
          }
          localObject = new ExtensionInfo();
          ((ExtensionInfo)localObject).uin = str;
        }
      }
    }
    label437:
    for (;;)
    {
      int i2 = 0;
      int i1 = 0;
      if (i7 >= 3)
      {
        i2 = arrayOfByte[0] & 0xFF;
        i1 = (arrayOfByte[1] << 8 & 0xFF00) + (arrayOfByte[2] & 0xFF);
        ((ExtensionInfo)localObject).praiseHotLevel = i2;
        ((ExtensionInfo)localObject).praiseDays = i1;
      }
      int i4 = 0;
      int i3 = 0;
      if (i7 >= 6)
      {
        i4 = arrayOfByte[3] & 0xFF;
        i3 = (arrayOfByte[4] << 8 & 0xFF00) + (arrayOfByte[5] & 0xFF);
        ((ExtensionInfo)localObject).chatHotLevel = i4;
        ((ExtensionInfo)localObject).chatDays = i3;
      }
      int i6 = 0;
      int i5 = 0;
      if (i7 >= 9)
      {
        i6 = arrayOfByte[6] & 0xFF;
        i5 = (arrayOfByte[7] << 8 & 0xFF00) + (arrayOfByte[8] & 0xFF);
        ((ExtensionInfo)localObject).bestIntimacyType = i6;
        ((ExtensionInfo)localObject).bestIntimacyDays = i5;
      }
      paramFriendsManager.a((ExtensionInfo)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" === hotFriend uin: ").append(str).append(",dataLen=").append(i7).append(", praiseData=").append(i2).append("|").append(i1).append(",chatData=").append(i4).append("|").append(i3).append(",closeData=").append(i6).append("|").append(i5);
      QLog.i("HotFriend_FriendListHandler", 2, ((StringBuilder)localObject).toString());
      break;
      return;
    }
  }
  
  private void a(String[] paramArrayOfString, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramInt1 >= paramArrayOfString.length) {
      return;
    }
    int i1 = Math.min(50, paramArrayOfString.length - paramInt1);
    String[] arrayOfString = new String[i1];
    System.arraycopy(paramArrayOfString, paramInt1, arrayOfString, 0, i1);
    ToServiceMsg localToServiceMsg = a("ProfileService.GetRichSig");
    localToServiceMsg.extraData.putStringArray("totalArray", paramArrayOfString);
    localToServiceMsg.extraData.putInt("nextStartPos", i1 + paramInt1);
    localToServiceMsg.extraData.putStringArray("sendArray", arrayOfString);
    localToServiceMsg.extraData.putInt("reqType", paramInt2);
    localToServiceMsg.extraData.putBoolean("showDateNickname", paramBoolean);
    localToServiceMsg.extraData.putBundle("circleBundle", paramBundle);
    a(localToServiceMsg);
  }
  
  private String b(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = paramLong + 4294967296L;
    }
    return String.valueOf(l1);
  }
  
  private Map b(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i1 = 0;
      if (i1 < paramArrayList.size())
      {
        GeneralSettings.Setting localSetting = (GeneralSettings.Setting)paramArrayList.get(i1);
        Object localObject = localSetting.Path;
        if ((localObject == null) || (((String)localObject).length() == 0)) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((String)localObject).split("\\.");
          if ((localObject != null) && (localObject.length != 0)) {
            localHashMap.put(localObject[(localObject.length - 1)], Integer.valueOf(Integer.parseInt(localSetting.Value)));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void b(byte paramByte)
  {
    byte b1 = 1;
    boolean bool;
    if ((paramByte == 0) || (paramByte == 1))
    {
      if (paramByte != 1) {
        break label59;
      }
      bool = true;
      if (bool != d()) {
        if (!bool) {
          break label64;
        }
      }
    }
    label59:
    label64:
    for (paramByte = b1;; paramByte = 0)
    {
      this.cg = paramByte;
      ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool);
      return;
      bool = false;
      break;
    }
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if (paramInt1 == 1) {}
    Object localObject2;
    boolean bool;
    label228:
    label289:
    try
    {
      paramBoolean = Friends.isValidUin(paramString);
      if (!paramBoolean) {}
      do
      {
        do
        {
          return;
        } while ((paramString == null) || (paramString.equals("")));
        localObject1 = paramInt1 + "_" + paramString;
        if (paramInt1 == 32) {
          localObject1 = "stranger_" + Integer.toString(paramInt2) + "_" + paramString;
        }
        if (paramInt1 == 16)
        {
          localObject2 = "qcall_" + Integer.toString(paramInt2) + "_" + paramString;
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL  keyStr = " + (String)localObject2);
            localObject1 = localObject2;
          }
        }
      } while (!d((String)localObject1));
      b((String)localObject1, false);
      if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a == null) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.a() == 1)) {
        break label511;
      }
      bool = true;
      if (!QLog.isColorLevel()) {
        break label538;
      }
      QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead end keyStr = " + (String)localObject1 + ",isImmediatelyGet=" + this.jdField_d_of_type_Boolean + ",InActionLoginB=" + bool);
    }
    finally {}
    this.ce += 1;
    int i1;
    Object localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i1));
    if (localObject1 == null)
    {
      localObject1 = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(i1), localObject1);
      if (!QLog.isColorLevel()) {
        break label550;
      }
      QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL destQQHeadInfoTable.put(keyType, destQQHeadInfoList); keyType = " + i1 + "destQQHeadInfoTable.size = " + this.jdField_a_of_type_JavaUtilHashtable.size());
    }
    for (;;)
    {
      paramBoolean = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString, paramInt2);
      for (;;)
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramBoolean)
        {
          localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString, paramInt2);
          l1 = l2;
          if (localObject2 != null)
          {
            l1 = l2;
            if (((Pair)localObject2).second != null) {
              l1 = ((com.tencent.mobileqq.data.Setting)((Pair)localObject2).second).headImgTimestamp;
            }
          }
        }
        ((ArrayList)localObject1).add(new FriendListHandler.QQHeadDetails(paramInt1, paramString, l1, paramByte1));
        if ((!this.jdField_d_of_type_Boolean) && (bool)) {
          break;
        }
        f();
        break;
        label511:
        bool = false;
        break label228;
        paramBoolean = true;
        continue;
        paramBoolean = false;
      }
      break label550;
      label538:
      do
      {
        i1 = paramInt1;
        break;
      } while (paramInt1 != 32);
      i1 = paramInt2;
      break label289;
      label550:
      switch (paramByte2)
      {
      }
    }
  }
  
  private void b(int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i1;
    switch (paramInt)
    {
    case 203: 
    default: 
      i1 = 0;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq;
    for (;;)
    {
      localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
      localMultiBusidUrlReq.srcUidType.set(0);
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(1));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(32));
      localMultiBusidUrlReq.dstUidType.set(i1);
      int i2 = 0;
      label111:
      if (i2 < paramArrayList.size())
      {
        FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(i2);
        MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
        if (i1 == 0) {}
        try
        {
          localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          for (;;)
          {
            a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
            localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
            if (QLog.isColorLevel()) {
              QLog.i("multiBusidUrlReq.dstUsrInfos", 2, " multiBusidUrlReq.dstUsrInfos reqUsrInfo.dstUin = " + localReqUsrInfo.dstUin + " ,reqUsrInfo.dstTid = " + localReqUsrInfo.dstTid + " ,reqUsrInfo.dstOpenid = " + localReqUsrInfo.dstOpenid);
            }
            i2 += 1;
            break label111;
            i1 = 2;
            break;
            i1 = 1;
            break;
            if (i1 != 1) {
              break label320;
            }
            localReqUsrInfo.dstTid.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.i("ERROR", 2, localException.getMessage());
              continue;
              label320:
              if (i1 == 2) {
                localReqUsrInfo.dstOpenid.set(localException.jdField_a_of_type_JavaLangString);
              }
            }
          }
        }
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("connum", String.valueOf(paramArrayList.size()));
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actNearbyHeadConNum", true, 0L, 0L, (HashMap)localObject, "");
    localObject = a("MultibusidURLSvr.HeadUrlReq", null);
    ((ToServiceMsg)localObject).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putLong("startTime", System.currentTimeMillis());
    ((ToServiceMsg)localObject).extraData.putInt("idType", paramInt);
    ((ToServiceMsg)localObject).putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_Stranger .  idType = " + paramInt);
    }
    b((ToServiceMsg)localObject);
  }
  
  private void b(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i1 = paramInt;
    if (paramInt == 4) {
      i1 = 8;
    }
    ToServiceMsg localToServiceMsg = a("IncreaseURLSvr.QQHeadUrlReq", null);
    QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
    localQQHeadUrlReq.srcUsrType.set(1);
    localQQHeadUrlReq.srcUin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localQQHeadUrlReq.dstUsrType.set(i1);
    paramInt = 0;
    while (paramInt < paramArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(paramInt);
      QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
      try
      {
        localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
        a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
        localReqUsrInfo.timestamp.set((int)localQQHeadDetails.jdField_a_of_type_Long);
        localQQHeadUrlReq.dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      paramInt += 1;
    }
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.putWupBuffer(localQQHeadUrlReq.toByteArray());
    b(localToServiceMsg);
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof GetSimpleOnlineFriendInfoResp))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)paramObject;
      if (paramFromServiceMsg == null) {
        a(13, false, null);
      }
    }
    else
    {
      return;
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 1))
    {
      a(13, false, null);
      return;
    }
    if (paramFromServiceMsg.shClickInterval > 30)
    {
      i1 = paramFromServiceMsg.shClickInterval * 1000;
      QQAppInterface.eq = i1;
      if (paramFromServiceMsg.intervalTimeMin <= 3) {
        break label179;
      }
    }
    label179:
    for (int i1 = paramFromServiceMsg.intervalTimeMin * 60 * 1000;; i1 = 180000)
    {
      QQAppInterface.ep = i1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "Next Get Online Friend Delay " + QQAppInterface.ep);
      }
      b(paramFromServiceMsg.cShowPcIcon);
      if (paramFromServiceMsg.vecFriendInfo.size() <= 0) {
        break label186;
      }
      ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramFromServiceMsg.vecFriendInfo);
      a(13, true, null);
      return;
      i1 = 30000;
      break;
    }
    label186:
    a(13, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isSet");
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagError : uin : " + l1 + " isSet:" + bool);
    }
    a(56, false, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(false), Boolean.valueOf(false), "" });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(62, false, new Object[] { null, Integer.valueOf(i1) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(62, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
        return;
      }
      a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(62, false, new Object[] { null, Integer.valueOf(i1) });
      return;
    }
    a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(58, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i1;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i1);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i1);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              a(58, true, paramSvcRspGetDevLoginInfo);
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(58, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(58, false, null);
      return;
    }
    a(58, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject = (GetRichSigRes)paramObject;
    paramObject = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((localObject == null) || (((GetRichSigRes)localObject).cResult != 0) || (((GetRichSigRes)localObject).vstSigInfo == null) || (((GetRichSigRes)localObject).vstSigInfo.size() == 0))
    {
      a(65, false, new Object[] { paramObject, null });
      c(paramToServiceMsg);
      return;
    }
    HashMap localHashMap = new HashMap(paramObject.length);
    localObject = ((GetRichSigRes)localObject).vstSigInfo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject).next();
      localHashMap.put(Long.toString(localResRichSigInfo.lUin), RichStatus.parseStatus(localResRichSigInfo.vbSigInfo));
    }
    a(65, true, new Object[] { paramObject, localHashMap });
    c(paramToServiceMsg);
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriend" + paramString1 + ";friendSetting " + paramInt1 + ";groupId " + paramByte1 + ";msg " + paramString3 + ";sourceID " + paramInt2 + ";subSourceId " + paramInt3 + ";autoSend " + paramBoolean1 + ";extraUin " + paramString2 + ";isContactBothWay " + paramBoolean2 + ";remark " + paramString4 + ";srcName " + paramString5);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.addFriend");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("uin", paramString1);
    localBundle.putInt("friend_setting", paramInt1);
    localBundle.putByte("group_id", paramByte1);
    localBundle.putString("msg", paramString3);
    localBundle.putInt("source_id", paramInt2);
    localBundle.putByte("show_my_card", paramByte2);
    localBundle.putInt("sub_source_id", paramInt3);
    localBundle.putString("extra", paramString2);
    localBundle.putBoolean("auto_send", paramBoolean1);
    localBundle.putByteArray("sig", paramArrayOfByte);
    localBundle.putBoolean("contact_bothway", paramBoolean2);
    localBundle.putString("remark", paramString4);
    localBundle.putString("src_name", paramString5);
    a(localToServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg.extraData.getStringArray("totalArray"), paramToServiceMsg.extraData.getInt("nextStartPos"), paramToServiceMsg.extraData.getInt("reqType"), paramToServiceMsg.extraData.getBundle("circleBundle"), paramToServiceMsg.extraData.getBoolean("showDateNickname"));
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(51, false, new Object[] { null, Integer.valueOf(i1) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(51, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
        return;
      }
      a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(51, false, new Object[] { null, Integer.valueOf(i1) });
      return;
    }
    a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(59, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size() > 0))
        {
          int i2 = 0;
          int i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.get(i1);
            int i3;
            if (paramToServiceMsg == null) {
              i3 = i2;
            }
            for (;;)
            {
              i1 += 1;
              i2 = i3;
              break;
              if (paramToServiceMsg.vecGuid != null) {
                break label153;
              }
              i3 = i2;
              if (QLog.isColorLevel())
              {
                QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                i3 = i2;
              }
            }
            label153:
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            for (;;)
            {
              i3 = i2;
              if (System.currentTimeMillis() / 1000L - paramToServiceMsg.iLoginTime >= 2592000L) {
                break;
              }
              i3 = i2;
              if (i2 != 0) {
                break;
              }
              i3 = i2;
              if (paramToServiceMsg.iTerType != 3L) {
                break;
              }
              i3 = 1;
              a(102, true, null);
              break;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
        a(59, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(59, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(59, false, null);
      return;
    }
    a(59, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    paramObject = (GetAutoInfoResp)paramObject;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && (((GetAutoInfoResp)paramObject).errorCode == 0))
    {
      paramToServiceMsg.putInt("group_id", ((GetAutoInfoResp)paramObject).cGroupID);
      paramToServiceMsg.putString("nick_name", ((GetAutoInfoResp)paramObject).strRemark);
      a(33, true, paramToServiceMsg);
      return;
    }
    a(33, false, paramToServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    paramObject = (GetRichSigRes)paramObject;
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if ((paramObject == null) || (((GetRichSigRes)paramObject).cResult != 0) || (((GetRichSigRes)paramObject).vstSigInfo == null) || (((GetRichSigRes)paramObject).vstSigInfo.size() == 0) || (localFriendsManager == null))
    {
      if (paramToServiceMsg.extraData.getInt("reqType") == 3) {
        this.jdField_c_of_type_Boolean = false;
      }
      c(paramToServiceMsg);
      return;
    }
    ArrayList localArrayList1 = new ArrayList(((GetRichSigRes)paramObject).vstSigInfo.size());
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((GetRichSigRes)paramObject).vstSigInfo.iterator();
    while (localIterator.hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)localIterator.next();
      String str = Long.toString(localResRichSigInfo.lUin);
      if (localResRichSigInfo.cStatus == 1)
      {
        ExtensionInfo localExtensionInfo = localFriendsManager.a(str);
        paramObject = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          paramObject = new ExtensionInfo();
          ((ExtensionInfo)paramObject).uin = str;
        }
        if (((ExtensionInfo)paramObject).richTime != localResRichSigInfo.dwTime)
        {
          ((ExtensionInfo)paramObject).setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
          localArrayList1.add(paramObject);
          localArrayList2.add(str);
        }
      }
    }
    if (localArrayList2.size() > 0)
    {
      paramObject = new String[localArrayList2.size()];
      localArrayList2.toArray((Object[])paramObject);
      a(2, true, paramObject);
      localFriendsManager.b(localArrayList1);
    }
    if ((paramToServiceMsg.extraData.getInt("reqType") == 3) && (this.jdField_c_of_type_Boolean) && (paramToServiceMsg.extraData.getStringArray("totalArray").length == paramToServiceMsg.extraData.getInt("nextStartPos")))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp13", this.h).commit();
      this.jdField_c_of_type_Boolean = false;
    }
    c(paramToServiceMsg);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(60, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size() > 0))
        {
          int i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.get(i1);
            if (paramToServiceMsg == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                }
              }
              else if (NetConnInfoCenter.GUID == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID is null");
                }
              }
              else {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                  }
                }
                catch (Exception paramToServiceMsg)
                {
                  paramToServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
        a(60, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(60, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(60, false, null);
      return;
    }
    a(60, false, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch success=" + bool);
      }
      if (!bool) {
        break label793;
      }
    }
    label793:
    label799:
    label809:
    label815:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null)
        {
          return;
          bool = false;
          break;
        }
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label809;
        }
        bool = true;
        i2 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch result=" + bool);
        }
        if ((bool) && (paramToServiceMsg.bytes_bodybuffer != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          i1 = paramToServiceMsg.get();
          int i3 = paramToServiceMsg.getInt();
          i2 = paramToServiceMsg.getShort();
          paramFromServiceMsg = new HashMap(i2);
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch cNickCut=" + i1 + " dwNextUin=" + i3 + " wSimpleInfoNum=" + i2);
          }
          if (i3 == -1)
          {
            paramObject = new StringBuffer();
            i1 = 0;
            if (i1 < i2)
            {
              String str = String.valueOf(Utils.a(paramToServiceMsg.getInt()));
              i3 = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                ((StringBuffer)paramObject).append(" wFieldNum=");
                ((StringBuffer)paramObject).append(i3);
              }
              if (i3 != 1) {
                break label799;
              }
              i3 = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                ((StringBuffer)paramObject).append(" wFieldID=");
                ((StringBuffer)paramObject).append(i3);
              }
              if (i3 != this.jdField_b_of_type_Short) {
                break label799;
              }
              Object localObject = new byte[paramToServiceMsg.getShort()];
              paramToServiceMsg.get((byte[])localObject);
              localObject = new String((byte[])localObject);
              if (QLog.isColorLevel())
              {
                ((StringBuffer)paramObject).append(" uin=");
                ((StringBuffer)paramObject).append(str.substring(0, 4));
                ((StringBuffer)paramObject).append(" nick=");
                ((StringBuffer)paramObject).append(Utils.a((String)localObject));
              }
              paramFromServiceMsg.put(str, localObject);
              break label799;
            }
            if (!QLog.isColorLevel()) {
              break label815;
            }
            QLog.d("FriendListHandler", 2, ((StringBuffer)paramObject).toString());
            break label815;
            a(75, bool, paramFromServiceMsg);
            return;
          }
          bool = false;
          continue;
        }
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
          i1 = i2;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i2 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch e", paramToServiceMsg);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i1 = i2;
        continue;
      }
      catch (Exception paramToServiceMsg)
      {
        i2 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch ex", paramToServiceMsg);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i1 = i2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
      }
      a(75, false, Integer.valueOf(i1));
      return;
      int i2 = 0;
      continue;
      int i1 = (short)(i1 + 1);
      continue;
      bool = false;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switch", 2, "FriendListHandler.handleSetSpecialCareSwitchResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    int i3 = paramToServiceMsg.extraData.getInt("param_type");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    int i4;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int i1;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switch", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (i4 != 0)
            {
              paramToServiceMsg.e(paramFromServiceMsg);
              paramObject = new SpecialCareInfo();
              ((SpecialCareInfo)paramObject).globalSwitch = 1;
              ((SpecialCareInfo)paramObject).specialRingSwitch = 1;
              ((SpecialCareInfo)paramObject).friendRingId = 1;
              ((SpecialCareInfo)paramObject).qzoneSwitch = 1;
              ((SpecialCareInfo)paramObject).uin = paramFromServiceMsg;
              paramToServiceMsg.a((SpecialCareInfo)paramObject);
              QvipSpecialCareManager.a(paramFromServiceMsg, "1", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            else
            {
              paramToServiceMsg.e(paramFromServiceMsg);
            }
          }
          paramObject = paramToServiceMsg.a(paramFromServiceMsg);
          if (paramObject != null) {
            if (i4 == 0) {
              break label395;
            }
          }
          for (i2 = 1;; i2 = 0)
          {
            ((SpecialCareInfo)paramObject).specialRingSwitch = i2;
            paramToServiceMsg.a((SpecialCareInfo)paramObject);
            if (i4 == 0) {
              break;
            }
            QvipSpecialCareManager.a(paramFromServiceMsg, "1", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        } while (paramFromServiceMsg == null);
        if (i4 == 0) {
          break label433;
        }
        for (i2 = 1;; i2 = 0)
        {
          paramFromServiceMsg.qzoneSwitch = i2;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        i4 = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switch", 2, "ssoPkg.uint32_result=" + i1);
        }
        if (i1 == 0)
        {
          paramToServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          i1 = 0;
          while (i1 < arrayOfString.length)
          {
            paramFromServiceMsg = arrayOfString[i1];
            i4 = arrayOfBoolean[i1];
            switch (i3)
            {
            default: 
              i1 += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      int i2;
      label395:
      label433:
      paramToServiceMsg = new Object[3];
      paramToServiceMsg[0] = Integer.valueOf(i3);
      paramToServiceMsg[1] = arrayOfString;
      paramToServiceMsg[2] = arrayOfBoolean;
      switch (i3)
      {
      default: 
        return;
      case 1: 
        a(96, i4, paramToServiceMsg);
        return;
      case 2: 
        a(97, i4, paramToServiceMsg);
        return;
      }
      a(98, i4, paramToServiceMsg);
      return;
      int i5 = 0;
    }
  }
  
  private boolean e(String paramString)
  {
    boolean bool1 = paramString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    boolean bool2 = bool1;
    long l1;
    if (bool1)
    {
      l1 = ContactConfig.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), paramString) + 28800000L;
      long l2 = System.currentTimeMillis() + 28800000L;
      if ((l1 / 86400000L == l2 / 86400000L) || ((l2 - l1 <= 28800000L) && (l1 - l2 <= 28800000L))) {
        break label175;
      }
    }
    label175:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, "$shouldReqXMan | lastReqTime = " + l1 + " day = " + l1 / 86400000L + " | currentTime = " + System.currentTimeMillis() + " day = " + System.currentTimeMillis() / 86400000L);
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  private void f()
  {
    for (;;)
    {
      long l1;
      int i1;
      ArrayList localArrayList;
      try
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead start !!! ");
        }
        Object localObject1;
        if (this.ce > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead destQQHeadInfoCount = " + this.ce);
          }
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localObject1 == null) {
            break label367;
          }
        }
        try
        {
          l1 = Long.valueOf((String)localObject1).longValue();
          if (l1 == -1L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead|myUin error: myUin=" + (String)localObject1);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          l1 = -1L;
          continue;
          localObject1 = this.jdField_a_of_type_JavaUtilHashtable.keys();
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break label352;
          }
        }
        i1 = ((Integer)((Enumeration)localObject1).nextElement()).intValue();
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i1));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "em.hasMoreElements() QQHeadDetails head_or_id = " + i1);
        }
        if (i1 == 11)
        {
          a(l1, i1, localArrayList);
          continue;
        }
        if (i1 < 200) {
          break label293;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.flh", 2, "realGetQQHead_Stranger = " + i1);
      }
      b(i1, localArrayList);
      continue;
      label293:
      if (i1 == 16)
      {
        a(i1, localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL = " + i1);
        }
      }
      else
      {
        b(l1, i1, localArrayList);
        continue;
        label352:
        this.ce = 0;
        this.jdField_a_of_type_JavaUtilHashtable.clear();
        continue;
        label367:
        l1 = -1L;
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switches_of_a_person", 2, "FriendListHandler.handleSetSpecialCareSwitchesOfAPersonResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    String str = paramToServiceMsg.extraData.getString("param_uin");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_type");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_ring_ids");
    int i1;
    int i4;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int i2;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switches_of_a_person", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (i4 != 0)
            {
              paramToServiceMsg.e(str);
              paramFromServiceMsg = new SpecialCareInfo();
              paramFromServiceMsg.globalSwitch = 1;
              paramFromServiceMsg.uin = str;
              paramToServiceMsg.a(paramFromServiceMsg);
              QvipSpecialCareManager.a(str, "1", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            else
            {
              paramToServiceMsg.e(str);
            }
          }
          paramObject = paramToServiceMsg.a(str);
          if (paramObject != null) {
            if (i4 == 0) {
              break label436;
            }
          }
          for (i3 = 1;; i3 = 0)
          {
            ((SpecialCareInfo)paramObject).specialRingSwitch = i3;
            paramToServiceMsg.a((SpecialCareInfo)paramObject);
            if (i4 == 0) {
              break;
            }
            QvipSpecialCareManager.a(str, paramFromServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(str);
        } while (paramFromServiceMsg == null);
        if (i4 == 0) {
          break label475;
        }
        for (int i3 = 1;; i3 = 0)
        {
          paramFromServiceMsg.qzoneSwitch = i3;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        i4 = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switches_of_a_person", 2, "ssoPkg.uint32_result=" + i1);
        }
        if (i1 == 0)
        {
          paramToServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          if ((arrayOfBoolean != null) && (arrayOfInt != null) && (arrayOfString != null) && (arrayOfBoolean.length >= arrayOfInt.length) && (arrayOfString.length >= arrayOfInt.length))
          {
            i2 = 0;
            while (i2 < arrayOfInt.length)
            {
              i3 = arrayOfInt[i2];
              i4 = arrayOfBoolean[i2];
              paramFromServiceMsg = arrayOfString[i2];
              switch (i3)
              {
              default: 
                i2 += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label436:
      label475:
      a(100, i4, new Object[] { Integer.valueOf(i1), str, arrayOfInt, arrayOfBoolean, arrayOfString });
      return;
      int i5 = 0;
      continue;
      i5 = 0;
      i1 = -1;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      a(66, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label113;
        }
        i1 = 1;
        if (i1 != 0) {
          break label119;
        }
        a(66, false, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(66, false, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.stranger_info", 2, paramToServiceMsg.getMessage());
      return;
      label113:
      i1 = 0;
    }
    label119:
    if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (localByteBuffer.getInt() == -1)
      {
        int i5 = localByteBuffer.getShort();
        paramFromServiceMsg = new ArrayList(i5);
        paramObject = new HashSet(i5);
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        int i3 = 0;
        while (i3 < i5)
        {
          long l1 = Utils.a(localByteBuffer.getInt());
          paramToServiceMsg = localFriendsManager.a(String.valueOf(l1));
          if (paramToServiceMsg != null) {
            break label771;
          }
          paramToServiceMsg = new ExtensionInfo();
          paramToServiceMsg.uin = String.valueOf(l1);
          i1 = 1;
          label259:
          int i6 = localByteBuffer.getShort();
          int i2;
          if (i6 > 0)
          {
            int i4 = 0;
            i2 = i1;
            if (i4 < i6)
            {
              int i7 = localByteBuffer.getShort();
              long l2;
              if (i7 == 27025)
              {
                if (localByteBuffer.getShort() != 8) {
                  break label768;
                }
                l2 = localByteBuffer.getLong();
                if (paramToServiceMsg.pendantId == l2) {
                  break label768;
                }
                paramToServiceMsg.pendantId = l2;
                i1 = 1;
                label336:
                i2 = i1;
              }
              for (;;)
              {
                i4 += 1;
                i1 = i2;
                break;
                if (i7 == 27201)
                {
                  i2 = i1;
                  if (localByteBuffer.getShort() == 4)
                  {
                    l2 = localByteBuffer.getInt();
                    if (paramToServiceMsg.uVipFont == FontManager.a(l2))
                    {
                      i2 = i1;
                      if (paramToServiceMsg.vipFontType == FontManager.a(l2)) {}
                    }
                    else
                    {
                      paramToServiceMsg.uVipFont = FontManager.a(l2);
                      paramToServiceMsg.vipFontType = FontManager.a(l2);
                      i2 = 1;
                    }
                  }
                }
                else if (i7 == 27041)
                {
                  i2 = i1;
                  if (localByteBuffer.getShort() == 4)
                  {
                    i7 = localByteBuffer.getInt();
                    i2 = i1;
                    if (paramToServiceMsg.colorRingId != i7)
                    {
                      paramToServiceMsg.colorRingId = i7;
                      i2 = 1;
                    }
                  }
                }
                else
                {
                  i2 = i1;
                  if (i7 == 20059)
                  {
                    i2 = i1;
                    if (localByteBuffer.getShort() == 4)
                    {
                      i7 = localByteBuffer.getInt();
                      i2 = i1;
                      if (i7 >= 0)
                      {
                        i2 = i1;
                        if (String.valueOf(l1).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))
                        {
                          ((BubbleManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(i7, true);
                          ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(i7);
                          i2 = i1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          else
          {
            i2 = i1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetStrangerInfo, uin=" + l1 + ", pendant=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont + ", fontType = " + paramToServiceMsg.vipFontType);
          }
          if (i2 != 0)
          {
            paramToServiceMsg.timestamp = System.currentTimeMillis();
            paramFromServiceMsg.add(paramToServiceMsg);
            ((Set)paramObject).add(paramToServiceMsg.uin);
          }
          i3 += 1;
        }
        localFriendsManager.b(paramFromServiceMsg);
        paramToServiceMsg = (ToServiceMsg)paramObject;
      }
    }
    for (;;)
    {
      a(66, true, paramToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.stranger_info", 2, "handleGetStrangerInfo. addonId size : " + paramFromServiceMsg.size());
      return;
      label768:
      break label336;
      label771:
      i1 = 0;
      break label259;
      paramToServiceMsg = null;
      paramFromServiceMsg = null;
    }
  }
  
  private void h(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_QCall ....");
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject2;
    }
    int i1;
    List localList;
    int i3;
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
          ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramObject = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + localException.getMessage());
        }
        localException.printStackTrace();
        continue;
        if (paramFromServiceMsg != null) {
          i1 = paramFromServiceMsg.getResultCode();
        }
      }
      localList = ((MultiHeadUrl.MultiBusidUrlRsp)paramObject).dstUsrHeadInfos.get();
      localArrayList = new ArrayList();
      paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
      localObject2 = new ArrayList();
      ((MultiHeadUrl.MultiBusidUrlRsp)paramObject).dstUidType.get();
      i3 = ???.extraData.getInt("idType");
      paramObject = paramFromServiceMsg.iterator();
    }
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (((MultiHeadUrl.MultiBusidUrlRsp)paramObject).result.get() != 0))
    {
      i1 = 65535;
      if (paramObject != null)
      {
        i1 = ((MultiHeadUrl.MultiBusidUrlRsp)paramObject).result.get();
        a(???, i1);
        return;
      }
    }
    ArrayList localArrayList;
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    label282:
    String str;
    if (((Iterator)paramObject).hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)((Iterator)paramObject).next();
      Iterator localIterator1 = localList.iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          ??? = (MultiHeadUrl.RspUsrHeadInfo)localIterator1.next();
          str = UinUtils.a(???.dstUin.get());
          if (localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(str))
          {
            paramFromServiceMsg = ???.dstHeadInfos.get();
            ??? = null;
            Iterator localIterator2 = paramFromServiceMsg.iterator();
            label346:
            if (localIterator2.hasNext())
            {
              paramFromServiceMsg = (MultiHeadUrl.RspHeadInfo)localIterator2.next();
              paramFromServiceMsg.usrType.get();
              if (paramFromServiceMsg.faceType.get() == 0) {
                break label1104;
              }
              ??? = paramFromServiceMsg;
            }
          }
        }
      }
    }
    for (;;)
    {
      break label346;
      if (??? != null)
      {
        label394:
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(16, str, i3);
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(16, str, i3)) {
          break label671;
        }
        int i2 = 1;
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL file not exist.id=" + str + ",idType=" + i3);
          i1 = i2;
        }
        label480:
        if (i1 == 0) {
          break label784;
        }
        paramFromServiceMsg = new QQHeadInfo();
        paramFromServiceMsg.headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
        paramFromServiceMsg.idType = i3;
        paramFromServiceMsg.phoneNum = str;
        paramFromServiceMsg.dwTimestamp = ???.timestamp.get();
        paramFromServiceMsg.cHeadType = ((byte)???.faceType.get());
        paramFromServiceMsg.dstUsrType = 16;
        paramFromServiceMsg.dwFaceFlgas = ((byte)???.faceFlag.get());
        paramFromServiceMsg.downLoadUrl = ???.url.get();
        paramFromServiceMsg.systemHeadID = ((short)???.sysid.get());
        paramFromServiceMsg.originUsrType = ???.usrType.get();
        if (!???.headVerify.has()) {
          break label786;
        }
      }
      label671:
      label784:
      label786:
      for (??? = ???.headVerify.get();; ??? = "")
      {
        paramFromServiceMsg.headVerify = ???;
        ((List)localObject2).add(paramFromServiceMsg);
        break label282;
        if (0 != 0)
        {
          ??? = null;
          break label394;
        }
        if (!QLog.isColorLevel()) {
          break label282;
        }
        QLog.d("headqcall", 2, "there is no headinfo uin=" + str);
        break label282;
        break;
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.second;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL setting=" + paramFromServiceMsg + "targetInfo.timestamp=" + ???.timestamp.get());
          }
          if (paramFromServiceMsg == null)
          {
            i1 = 1;
            break label480;
          }
          if (paramFromServiceMsg.headImgTimestamp != ???.timestamp.get())
          {
            i1 = 1;
            break label480;
          }
          localArrayList.add(localQQHeadDetails);
          i1 = 0;
          break label480;
        }
        i1 = 1;
        break label480;
        break label282;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        i1 = 0;
        if (i1 < ((List)localObject2).size())
        {
          ??? = (QQHeadInfo)((List)localObject2).get(i1);
          a(0, a(???.uin, ???.phoneNum), ???.dstUsrType, 2);
          paramFromServiceMsg = new FaceInfo();
          paramFromServiceMsg.jdField_a_of_type_JavaLangString = ???.phoneNum;
          paramFromServiceMsg.jdField_b_of_type_Int = ???.idType;
          paramFromServiceMsg.jdField_a_of_type_Int = ???.dstUsrType;
          paramFromServiceMsg.jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
          this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a(paramFromServiceMsg);
          i1 += 1;
        }
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      ??? = paramFromServiceMsg.a();
      ???.a();
      i1 = 0;
      try
      {
        while (i1 < localArrayList.size())
        {
          paramObject = (FriendListHandler.QQHeadDetails)localArrayList.get(i1);
          paramObject = "qcall_" + String.valueOf(i3) + "_" + ((FriendListHandler.QQHeadDetails)paramObject).jdField_a_of_type_JavaLangString;
          localObject2 = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.a(com.tencent.mobileqq.data.Setting.class, (String)paramObject);
          if (localObject2 != null)
          {
            ((com.tencent.mobileqq.data.Setting)localObject2).updateTimestamp = System.currentTimeMillis();
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((com.tencent.mobileqq.data.Setting)localObject2);
            paramFromServiceMsg.a((Entity)localObject2);
          }
          b((String)paramObject, true);
          i1 += 1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        ???.c();
        ???.b();
        return;
      }
    }
  }
  
  private void i(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger ....");
    }
    ArrayList localArrayList1 = null;
    Object localObject1 = localArrayList1;
    if (paramFromServiceMsg != null) {
      localObject1 = localArrayList1;
    }
    int i1;
    List localList;
    ArrayList localArrayList2;
    int i3;
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localArrayList1;
        if (paramObject != null)
        {
          localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
          ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramObject = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + localException.getMessage());
        }
        localException.printStackTrace();
        continue;
        if (paramFromServiceMsg != null) {
          i1 = paramFromServiceMsg.getResultCode();
        }
      }
      localList = ((MultiHeadUrl.MultiBusidUrlRsp)paramObject).dstUsrHeadInfos.get();
      localArrayList1 = new ArrayList();
      paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
      localArrayList2 = new ArrayList();
      i3 = ((MultiHeadUrl.MultiBusidUrlRsp)paramObject).dstUidType.get();
      i2 = ???.extraData.getInt("idType");
      localIterator1 = paramFromServiceMsg.iterator();
    }
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (((MultiHeadUrl.MultiBusidUrlRsp)paramObject).result.get() != 0))
    {
      i1 = 65535;
      if (paramObject != null)
      {
        i1 = ((MultiHeadUrl.MultiBusidUrlRsp)paramObject).result.get();
        a(???, i1);
        return;
      }
    }
    int i2;
    Iterator localIterator1;
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    label286:
    label323:
    Object localObject2;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = localList.iterator();
      if (localIterator2.hasNext())
      {
        ??? = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        if (i3 == 0)
        {
          paramObject = String.valueOf(???.dstUin.get());
          if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(paramObject)) {
            break label430;
          }
          localObject2 = ???.dstHeadInfos.get();
          paramFromServiceMsg = null;
          ??? = null;
          Iterator localIterator3 = ((List)localObject2).iterator();
          label357:
          if (!localIterator3.hasNext()) {
            break label456;
          }
          localObject2 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
          i1 = ((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get();
          if (i1 != 1) {
            break label432;
          }
          paramFromServiceMsg = (FromServiceMsg)localObject2;
        }
      }
    }
    for (;;)
    {
      break label357;
      if (i3 == 1)
      {
        paramObject = String.valueOf(???.dstTid.get());
        break label323;
      }
      paramObject = ???.dstOpenid.get();
      break label323;
      label430:
      break label286;
      label432:
      if ((i1 == 32) && (((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get() != 0))
      {
        ??? = (ToServiceMsg)localObject2;
        continue;
        label456:
        if (??? != null)
        {
          label460:
          paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(32, (String)paramObject, i2);
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(32, (String)paramObject, i2)) {
            break label680;
          }
          i1 = 1;
          label491:
          if (i1 == 0) {
            break label744;
          }
          paramFromServiceMsg = new QQHeadInfo();
          paramFromServiceMsg.headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
          paramFromServiceMsg.idType = i2;
          paramFromServiceMsg.phoneNum = ((String)paramObject);
          paramFromServiceMsg.dwTimestamp = ???.timestamp.get();
          paramFromServiceMsg.cHeadType = ((byte)???.faceType.get());
          paramFromServiceMsg.dstUsrType = 32;
          paramFromServiceMsg.dwFaceFlgas = ((byte)???.faceFlag.get());
          paramFromServiceMsg.downLoadUrl = ???.url.get();
          paramFromServiceMsg.systemHeadID = ((short)???.sysid.get());
          paramFromServiceMsg.originUsrType = ???.usrType.get();
          if (!???.headVerify.has()) {
            break label746;
          }
        }
        label680:
        label744:
        label746:
        for (??? = ???.headVerify.get();; ??? = "")
        {
          paramFromServiceMsg.headVerify = ???;
          localArrayList2.add(paramFromServiceMsg);
          break label286;
          if (paramFromServiceMsg != null)
          {
            ??? = paramFromServiceMsg;
            break label460;
          }
          if (!QLog.isColorLevel()) {
            break label286;
          }
          QLog.d("headstranger", 2, "there is no headinfo uin=" + (String)paramObject);
          break label286;
          break;
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.second;
            if (paramFromServiceMsg == null)
            {
              i1 = 1;
              break label491;
            }
            if (paramFromServiceMsg.headImgTimestamp != ???.timestamp.get())
            {
              i1 = 1;
              break label491;
            }
            localArrayList1.add(localQQHeadDetails);
            i1 = 0;
            break label491;
          }
          i1 = 1;
          break label491;
          break label286;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          i1 = 0;
          if (i1 < localArrayList2.size())
          {
            ??? = (QQHeadInfo)localArrayList2.get(i1);
            a(0, a(???.uin, ???.phoneNum), ???.dstUsrType, 2);
            paramFromServiceMsg = new FaceInfo();
            paramFromServiceMsg.jdField_a_of_type_JavaLangString = ???.phoneNum;
            paramFromServiceMsg.jdField_b_of_type_Int = ???.idType;
            paramFromServiceMsg.jdField_a_of_type_Int = ???.dstUsrType;
            paramFromServiceMsg.jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
            this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a(paramFromServiceMsg);
            i1 += 1;
          }
        }
        if (localArrayList1.size() <= 0) {
          break;
        }
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        ??? = paramFromServiceMsg.a();
        ???.a();
        i1 = 0;
        try
        {
          while (i1 < localArrayList1.size())
          {
            paramObject = (FriendListHandler.QQHeadDetails)localArrayList1.get(i1);
            paramObject = "stranger_" + String.valueOf(i2) + "_" + ((FriendListHandler.QQHeadDetails)paramObject).jdField_a_of_type_JavaLangString;
            localObject2 = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.a(com.tencent.mobileqq.data.Setting.class, (String)paramObject);
            if (localObject2 != null)
            {
              ((com.tencent.mobileqq.data.Setting)localObject2).updateTimestamp = System.currentTimeMillis();
              this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((com.tencent.mobileqq.data.Setting)localObject2);
              paramFromServiceMsg.a((Entity)localObject2);
            }
            b((String)paramObject, true);
            i1 += 1;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          ???.c();
          ???.b();
          return;
        }
      }
    }
  }
  
  private void j(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = new QQHeadUrl.QQHeadUrlRsp();
          ((QQHeadUrl.QQHeadUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        paramObject = null;
        continue;
        if (paramFromServiceMsg != null) {
          i1 = paramFromServiceMsg.getResultCode();
        }
      }
      i1 = ((QQHeadUrl.QQHeadUrlRsp)paramObject).dstUsrType.get();
      if (i1 != 8) {
        break label845;
      }
    }
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (((QQHeadUrl.QQHeadUrlRsp)paramObject).result.get() != 0))
    {
      i1 = 65535;
      if (paramObject != null)
      {
        i1 = ((QQHeadUrl.QQHeadUrlRsp)paramObject).result.get();
        a(???, i1);
        return;
      }
    }
    int i1 = 4;
    label213:
    label243:
    label280:
    label330:
    label427:
    label476:
    label478:
    label494:
    label839:
    label843:
    label845:
    for (;;)
    {
      int i3 = (byte)((QQHeadUrl.QQHeadUrlRsp)paramObject).dstEncryptType.get();
      localObject1 = new ArrayList();
      paramFromServiceMsg = new ArrayList();
      ??? = ???.extraData.getParcelableArrayList("uinList");
      if ((??? != null) && (???.size() > 0))
      {
        paramObject = ((QQHeadUrl.QQHeadUrlRsp)paramObject).dstHeadInfos.get();
        localObject2 = ???.iterator();
      }
      for (;;)
      {
        FriendListHandler.QQHeadDetails localQQHeadDetails;
        Object localObject3;
        QQHeadUrl.RspHeadInfo localRspHeadInfo;
        int i2;
        if (((Iterator)localObject2).hasNext())
        {
          localQQHeadDetails = (FriendListHandler.QQHeadDetails)((Iterator)localObject2).next();
          localObject3 = ((List)paramObject).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label839;
          }
          localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((Iterator)localObject3).next();
          if (i3 == 1)
          {
            ??? = localRspHeadInfo.dstUid.get();
            if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(???)) {
              break label476;
            }
            localObject3 = new QQHeadInfo();
            ((QQHeadInfo)localObject3).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
            if (i3 != 1) {
              break label478;
            }
            ((QQHeadInfo)localObject3).phoneNum = localRspHeadInfo.dstUid.get();
            ((QQHeadInfo)localObject3).dwTimestamp = localRspHeadInfo.timestamp.get();
            ((QQHeadInfo)localObject3).cHeadType = ((byte)localRspHeadInfo.faceType.get());
            ((QQHeadInfo)localObject3).dstUsrType = ((byte)i1);
            ((QQHeadInfo)localObject3).dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
            ((QQHeadInfo)localObject3).downLoadUrl = localRspHeadInfo.url.get();
            ((QQHeadInfo)localObject3).systemHeadID = ((short)localRspHeadInfo.sysid.get());
            if (!localRspHeadInfo.headVerify.has()) {
              break label494;
            }
            ??? = localRspHeadInfo.headVerify.get();
            ((QQHeadInfo)localObject3).headVerify = ???;
            ((List)localObject1).add(localObject3);
            i2 = 1;
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label843;
          }
          paramFromServiceMsg.add(localQQHeadDetails);
          break label213;
          ??? = String.valueOf(localRspHeadInfo.dstUin.get());
          break label280;
          break label243;
          ((QQHeadInfo)localObject3).uin = localRspHeadInfo.dstUin.get();
          break label330;
          ??? = "";
          break label427;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
          synchronized (this.jdField_b_of_type_JavaLangObject)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
            }
            i2 = 0;
            if (i2 < ((List)localObject1).size())
            {
              ??? = (QQHeadInfo)((List)localObject1).get(i2);
              a(0, a(???.uin, ???.phoneNum), ???.dstUsrType, 2);
              paramObject = new FaceInfo();
              ((FaceInfo)paramObject).jdField_a_of_type_JavaLangString = ???.phoneNum;
              ((FaceInfo)paramObject).jdField_b_of_type_Int = ???.idType;
              ((FaceInfo)paramObject).jdField_a_of_type_Int = ???.dstUsrType;
              ((FaceInfo)paramObject).jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
              this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a((FaceInfo)paramObject);
              i2 += 1;
            }
          }
          if (paramFromServiceMsg.size() <= 0) {
            break;
          }
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          paramObject = ((EntityManager)localObject1).a();
          ((EntityTransaction)paramObject).a();
          i2 = 0;
          try
          {
            if (i2 < paramFromServiceMsg.size())
            {
              localObject2 = (FriendListHandler.QQHeadDetails)paramFromServiceMsg.get(i2);
              if (i1 == 4) {}
              for (??? = "troop_" + ((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString;; ??? = ((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString)
              {
                ??? = (com.tencent.mobileqq.data.Setting)((EntityManager)localObject1).a(com.tencent.mobileqq.data.Setting.class, ???);
                if (??? != null)
                {
                  ???.updateTimestamp = System.currentTimeMillis();
                  this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(???);
                  ((EntityManager)localObject1).a(???);
                }
                b(i1 + "_" + ((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString, true);
                i2 += 1;
                break;
              }
            }
            i2 = 0;
          }
          catch (Exception ???)
          {
            ((EntityTransaction)paramObject).c();
            ((EntityTransaction)paramObject).b();
            return;
          }
        }
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = paramToServiceMsg.extraData.getInt("search_version");
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (i1 != 2) {
        break label170;
      }
      bool1 &= paramObject instanceof RespSearch;
      i1 = 87;
    }
    for (;;)
    {
      label45:
      Object localObject = null;
      int i2;
      label90:
      boolean bool2;
      if (bool1)
      {
        paramFromServiceMsg = (RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
        if (paramFromServiceMsg != null)
        {
          i2 = paramFromServiceMsg.iResult;
          paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
          bool2 = paramToServiceMsg.extraData.getBoolean("search_decode");
        }
      }
      for (;;)
      {
        a(49, bool1, new Object[] { Integer.valueOf(i1), paramObject, Integer.valueOf(i2), paramFromServiceMsg, Boolean.valueOf(bool2), Long.valueOf(paramToServiceMsg.extraData.getLong("session_id")) });
        return;
        bool1 = false;
        break;
        label170:
        if (i1 != 3) {
          break label215;
        }
        bool1 &= paramObject instanceof ArrayList;
        i1 = 88;
        break label45;
        paramFromServiceMsg = null;
        bool1 = false;
        i2 = 0;
        break label90;
        bool2 = false;
        i2 = 0;
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      label215:
      i1 = -1;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int i1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && ((paramObject instanceof RespCondSearch)))
    {
      bool = true;
      if (!bool) {
        break label135;
      }
      paramFromServiceMsg = (RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
      if (paramFromServiceMsg == null) {
        break label126;
      }
      i1 = paramFromServiceMsg.iResult;
      paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
    }
    for (;;)
    {
      a(73, bool, new Object[] { Long.valueOf(paramToServiceMsg.extraData.getLong("search_seq")), paramObject, Integer.valueOf(i1), Integer.valueOf(paramToServiceMsg.extraData.getInt("param_search_from")) });
      return;
      bool = false;
      break;
      label126:
      i1 = 0;
      bool = false;
      continue;
      label135:
      i1 = 0;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("dwReqType", 1L);
    if (l1 == 0L)
    {
      paramToServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("dwUin"));
      if (paramObject != null) {
        break label76;
      }
      a(68, false, new Object[] { Long.valueOf(l1), paramToServiceMsg });
    }
    label76:
    while (!(paramObject instanceof GetOnlineInfoResp))
    {
      return;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("strMobile");
      break;
    }
    paramFromServiceMsg = (GetOnlineInfoResp)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleOnlineInfo, uin = " + StringUtil.f(paramToServiceMsg) + ", result = " + paramFromServiceMsg.result + ", itermType = " + paramFromServiceMsg.iTermType + ", netType = " + paramFromServiceMsg.eNetworkType + ", abi = " + paramFromServiceMsg.uAbiFlag);
    }
    if ((l1 == 0L) && (paramFromServiceMsg.result == 0)) {
      ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramToServiceMsg, paramFromServiceMsg);
    }
    for (;;)
    {
      paramFromServiceMsg.dwInterval *= 1000L;
      if (paramFromServiceMsg.dwInterval < 15000L) {
        paramFromServiceMsg.dwInterval = 15000L;
      }
      this.m = paramFromServiceMsg.dwInterval;
      a(68, true, new Object[] { Long.valueOf(l1), paramToServiceMsg, paramFromServiceMsg });
      return;
      if ((l1 == 1L) && (paramFromServiceMsg.result == 0)) {
        ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("uin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("com_value");
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = str;
    arrayOfObject[1] = paramToServiceMsg;
    if (1000 == paramFromServiceMsg.getResultCode())
    {
      paramFromServiceMsg = (ChangeFriendNameRes)paramObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.cResult == 0))
      {
        a(str, paramToServiceMsg, true);
        arrayOfObject[2] = Byte.valueOf(paramFromServiceMsg.cResult);
        a(27, true, arrayOfObject);
        return;
      }
      if (paramFromServiceMsg != null) {
        arrayOfObject[2] = Byte.valueOf(paramFromServiceMsg.cResult);
      }
      for (;;)
      {
        a(27, false, arrayOfObject);
        return;
        arrayOfObject[2] = Byte.valueOf(-1);
      }
    }
    arrayOfObject[2] = Byte.valueOf(-1);
    a(27, false, arrayOfObject);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (SetRichSigRes)paramObject;
      if (((SetRichSigRes)paramObject).cResult == 0)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if (localFriendsManager != null)
        {
          byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("sig_value");
          if (((SetRichSigRes)paramObject).dwTime == 0L) {
            ((SetRichSigRes)paramObject).dwTime = 1L;
          }
          paramFromServiceMsg = localFriendsManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
          }
          if (paramToServiceMsg.timestamp != ((SetRichSigRes)paramObject).dwTime)
          {
            paramToServiceMsg.setRichBuffer(arrayOfByte, ((SetRichSigRes)paramObject).dwTime);
            localFriendsManager.a(paramToServiceMsg);
          }
        }
        a(28, true, null);
        return;
      }
      a(28, false, Integer.valueOf(((SetRichSigRes)paramObject).cResult));
      return;
    }
    a(28, false, null);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0x5d1.RspBody localRspBody = new Oidb_0x5d1.RspBody();
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    for (paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();; paramFromServiceMsg = localRspBody)
    {
      label174:
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          i1 = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0|oidb_sso.OIDBSSOPkg.result = " + i1);
          }
        }
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      try
      {
        localRspBody.mergeFrom((byte[])paramFromServiceMsg);
        paramFromServiceMsg = localRspBody;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        break label174;
      }
      if (paramFromServiceMsg == null) {
        break;
      }
      int i1 = paramFromServiceMsg.uint32_id.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : setId:" + i1 + "hex:" + "");
      }
      if (i1 != 4051) {
        break;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0| oidb_sso parseFrom byte " + paramToServiceMsg.toString());
      return;
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = a(paramToServiceMsg);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramToServiceMsg.extraData.getLong("uin"));
    if (i1 == 147) {}
    for (i1 = 72;; i1 = 71)
    {
      if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
      {
        a(i1, false, localBundle);
        return;
      }
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l1 = paramToServiceMsg.getInt();
          paramToServiceMsg.getShort();
          paramFromServiceMsg = new byte[4];
          paramToServiceMsg.get(paramFromServiceMsg);
          l1 = Utils.a(paramFromServiceMsg, 0);
          int i2 = paramToServiceMsg.get();
          localBundle.putLong("uin", l1);
          localBundle.putInt("safety_flag", i2 & 0x1F);
          a(i1, true, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handle_oidb_0x476 error:" + paramToServiceMsg.getMessage());
        }
        a(i1, false, localBundle);
        return;
      }
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_show_to_friends", true);
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "set network switch isSuccess = " + bool1 + "; isShowedToFriends = " + bool2);
      }
      if (!bool1) {
        break label192;
      }
    }
    label192:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleSetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
        a(76, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l1 = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleGetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool3 = false;
        bool1 = bool2;
        bool2 = bool3;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "get network switch isSuccess = " + bool2 + "; isShowedToFriends = " + bool1);
      }
      if (!bool2) {
        bool1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
      }
      a(77, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "handleGetRecommGatheredContactsList()");
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(80, false, Boolean.valueOf(false));
      this.o = 0L;
      return;
    }
    int i1 = paramToServiceMsg.extraData.getInt("startIndex");
    paramToServiceMsg.extraData.getBoolean("beforeShowTip");
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;) {}
      int i2 = paramToServiceMsg.uint32_result.get();
      if (!QLog.isColorLevel()) {
        break label163;
      }
      QLog.i("FriendListHandler", 2, "handleGetRecommGatheredContactsList result " + i2);
      label163:
      if (i2 != 0) {
        break label768;
      }
      paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      Object localObject = new cmd0x7c4.RspBody();
      int i3;
      ArrayList localArrayList;
      for (;;)
      {
        try
        {
          ((cmd0x7c4.RspBody)localObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramObject = (cmd0x7c4.GetRecommendSNFrdListRsp)((cmd0x7c4.RspBody)localObject).msg_get_recommend_sn_frd_list_rsp.get();
          ((cmd0x7c4.GetRecommendSNFrdListRsp)paramObject).uint64_uin.get();
          i2 = ((cmd0x7c4.GetRecommendSNFrdListRsp)paramObject).uint32_sequence.get();
          i3 = ((cmd0x7c4.GetRecommendSNFrdListRsp)paramObject).uint32_over.get();
          if (((cmd0x7c4.RspBody)localObject).rpt_msg_recommend_reason.has())
          {
            paramToServiceMsg = ((cmd0x7c4.RspBody)localObject).rpt_msg_recommend_reason.get();
            ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).f(paramToServiceMsg);
          }
          paramToServiceMsg = ((cmd0x7c4.GetRecommendSNFrdListRsp)paramObject).rpt_msg_one_frd_data.get();
          if (paramToServiceMsg == null) {
            break label660;
          }
          localObject = paramFromServiceMsg.edit();
          if (paramToServiceMsg.size() > 0)
          {
            bool = true;
            ((SharedPreferences.Editor)localObject).putBoolean("hasPulledRecomGathered", bool).commit();
            localObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
            localArrayList = new ArrayList();
            Iterator localIterator = paramToServiceMsg.iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            cmd0x7c4.OneFrdData localOneFrdData = (cmd0x7c4.OneFrdData)localIterator.next();
            Friends localFriends = new Friends();
            localFriends.uin = String.valueOf(localOneFrdData.uint64_frd_id.get());
            localFriends.age = localOneFrdData.uint32_ages.get();
            if (!localOneFrdData.bytes_smart_remark.has()) {
              break label646;
            }
            paramToServiceMsg = localOneFrdData.bytes_smart_remark.get().toStringUtf8();
            localFriends.smartRemark = paramToServiceMsg;
            localFriends.gender = ((byte)localOneFrdData.uint32_gender.get());
            int i4 = localOneFrdData.uint32_reason_id.get();
            localFriends.recommReason = ((FriendsManager)localObject).a(i4);
            localArrayList.add(localFriends);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("FriendListHandler", 2, "handleGetRecommGatheredContactsList Recom List : " + localFriends.uin + " ; resonId = " + i4 + " ; f.recommReason =  " + localFriends.recommReason + " ; f.age = " + localFriends.age + " ; f.smartRemark = " + localFriends.smartRemark + " ; f.gender = " + localFriends.gender);
            continue;
          }
          boolean bool = false;
        }
        catch (Exception paramToServiceMsg)
        {
          a(80, false, Boolean.valueOf(false));
          paramFromServiceMsg.edit().putBoolean("hasPulledRecomGathered", false).commit();
          return;
        }
        continue;
        label646:
        paramToServiceMsg = null;
      }
      ((FriendsManager)localObject).b(localArrayList, i1);
      label660:
      if (i3 != 0) {
        break label719;
      }
      i1 = ((cmd0x7c4.GetRecommendSNFrdListRsp)paramObject).uint32_next_start_idx.get();
      if (!QLog.isColorLevel()) {
        break label707;
      }
      QLog.i("FriendListHandler", 2, "FriendListHandler handleGetRecommGatheredContactsList. not Completed. continue to get. startIndex = " + i1);
      label707:
      a(80, true, Boolean.valueOf(false));
      return;
      label719:
      if (!QLog.isColorLevel()) {
        break label734;
      }
      QLog.i("FriendListHandler", 2, "FriendListHandler handleGetRecommGatheredContactsList. Completed.");
      label734:
      paramFromServiceMsg.edit().putInt("GetRecomFrdListReq_seq", i2).commit();
      a(80, true, Boolean.valueOf(true));
      return;
      label768:
      if (i2 != 1) {
        break label791;
      }
      this.o = 0L;
      a(80, true, Boolean.valueOf(true));
      return;
      label791:
      this.o = 0L;
      a(80, false, Boolean.valueOf(true));
    }
    if (!paramToServiceMsg.uint32_result.has())
    {
      a(80, false, Boolean.valueOf(false));
      this.o = 0L;
      return;
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
      return;
    }
    int i1 = paramToServiceMsg.extraData.getInt("startIndex");
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;) {}
      int i2 = paramToServiceMsg.uint32_result.get();
      if (!QLog.isColorLevel()) {
        break label155;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList result " + i2);
      if (i2 != 0) {
        break label966;
      }
      paramFromServiceMsg = new cmd0x7c4.RspBody();
      int i3;
      FriendsManager localFriendsManager;
      ArrayList localArrayList;
      for (;;)
      {
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramObject = (cmd0x7c4.GetSNFrdListRsp)paramFromServiceMsg.msg_get_sn_frd_list_rsp.get();
          ((cmd0x7c4.GetSNFrdListRsp)paramObject).uint64_uin.get();
          i2 = ((cmd0x7c4.GetSNFrdListRsp)paramObject).uint32_sequence.get();
          i3 = ((cmd0x7c4.GetSNFrdListRsp)paramObject).uint32_over.get();
          if (paramFromServiceMsg.rpt_msg_recommend_reason.has())
          {
            paramToServiceMsg = paramFromServiceMsg.rpt_msg_recommend_reason.get();
            ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).f(paramToServiceMsg);
          }
          paramToServiceMsg = ((cmd0x7c4.GetSNFrdListRsp)paramObject).rpt_msg_one_frd_data.get();
          localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          if (paramToServiceMsg == null) {
            break label577;
          }
          localArrayList = new ArrayList();
          Iterator localIterator = paramToServiceMsg.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          cmd0x7c4.OneFrdData localOneFrdData = (cmd0x7c4.OneFrdData)localIterator.next();
          Friends localFriends = new Friends();
          localFriends.uin = String.valueOf(localOneFrdData.uint64_frd_id.get());
          localFriends.age = localOneFrdData.uint32_ages.get();
          if (localOneFrdData.bytes_smart_remark.has())
          {
            paramToServiceMsg = localOneFrdData.bytes_smart_remark.get().toStringUtf8();
            localFriends.smartRemark = paramToServiceMsg;
            localFriends.gender = ((byte)localOneFrdData.uint32_gender.get());
            int i4 = localOneFrdData.uint32_reason_id.get();
            localFriends.recommReason = localFriendsManager.a(i4);
            localArrayList.add(localFriends);
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList Gather List : " + localFriends.uin + " ; resonId = " + i4 + " ; f.recommReason =  " + localFriends.recommReason + " ; f.age = " + localFriends.age + " ; f.smartRemark = " + localFriends.smartRemark + " ; f.gender = " + localFriends.gender);
            }
          }
          else
          {
            paramToServiceMsg = null;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
          return;
        }
      }
      localFriendsManager.a(localArrayList, i1);
      if (!((cmd0x7c4.GetSNFrdListRsp)paramObject).uint32_recommend_frd_count.has()) {
        break label832;
      }
      i1 = ((cmd0x7c4.GetSNFrdListRsp)paramObject).uint32_recommend_frd_count.get();
      if (!QLog.isColorLevel()) {
        break label629;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  推荐人数 : " + i1);
      localFriendsManager.b(i1);
      boolean bool = paramFromServiceMsg.msg_box.has();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (!bool) {
        break label868;
      }
      if (!QLog.isColorLevel()) {
        break label676;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. ");
      paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      bool = paramToServiceMsg.getBoolean("hasPulledRecomGathered", false);
      paramToServiceMsg.edit().putBoolean("hasMsgBox", true).commit();
      this.o = 0L;
      if (!bool) {
        break label850;
      }
      if (!QLog.isColorLevel()) {
        break label753;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. hasPulled. ");
      for (;;)
      {
        if (i3 != 0) {
          break label886;
        }
        i1 = ((cmd0x7c4.GetSNFrdListRsp)paramObject).uint32_next_start_idx.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "FriendListHandler handleGetGatheredContactsList. not Completed. continue to get. startIndex = " + i1);
        }
        f(i1);
        a(79, true, new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  no recommended field. ");
        break;
        if (QLog.isColorLevel())
        {
          QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. hasPulled. go to get.");
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList no has MsgBox. ");
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label901;
      }
      QLog.i("FriendListHandler", 2, "FriendListHandler handleGetGatheredContactsList. Completed.");
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putInt("GetFrdListReq_seq", i2).commit();
      a(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
      return;
      if (i2 != 1) {
        break label998;
      }
      a(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
      return;
      a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
    }
    if (!paramToServiceMsg.uint32_result.has())
    {
      a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
      return;
    }
    label155:
    label577:
    label629:
    label676:
    label753:
    label832:
    label850:
    label868:
    label886:
    label901:
    label966:
    label998:
    return;
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = paramToServiceMsg.extraData.getInt("key_permission_opcode");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("key_dongtai_permission", false);
    boolean bool1;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject) == null)
    {
      if (!QLog.isColorLevel()) {
        break label167;
      }
      QLog.d("FriendListHandler", 2, "handleSetDongtaiPermission: ssoPkg parse failed");
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1) {
        if (i1 == 1) {
          bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
        }
      }
      label73:
      label167:
      label257:
      for (;;)
      {
        if (i1 == 1) {
          a(81, bool1, Boolean.valueOf(bool2));
        }
        do
        {
          return;
          if (i1 == 1) {}
          try
          {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(bool2, false);
          }
          catch (Exception paramToServiceMsg)
          {
            if (!QLog.isColorLevel()) {
              break label167;
            }
            QLog.d("FriendListHandler", 2, "handleSetDongtaiPermission " + paramToServiceMsg.getMessage());
          }
          if (i1 == 2)
          {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f(bool2, false);
            break label260;
            bool1 = false;
            break;
          }
          if (i1 != 3) {
            break label260;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(bool2, false);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f(bool2, false);
          break label260;
          if (i1 != 2) {
            break label257;
          }
          bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
          break label73;
          if (i1 == 2)
          {
            a(83, bool1, Boolean.valueOf(bool2));
            return;
          }
        } while (i1 != 3);
        a(85, bool1, null);
        return;
      }
      label260:
      bool1 = true;
    }
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1;
    int i1;
    Object localObject;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      i1 = paramToServiceMsg.extraData.getInt("key_permission_opcode");
      paramFromServiceMsg = null;
      localObject = null;
      if (!bool1) {
        break label702;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          bool2 = true;
          if (!bool2) {
            continue;
          }
          paramObject = new cmd0x7c7.RspBody();
          ((cmd0x7c7.RspBody)paramObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (i1 != 1) {
            continue;
          }
          i2 = ((cmd0x7c7.RspBody)paramObject).uint32_not_see_qzone.get();
          if (i2 != 1) {
            continue;
          }
          bool1 = true;
          bool3 = bool1;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          if (((cmd0x7c7.RspBody)paramObject).uint32_not_see_qzone.get() == 1)
          {
            bool1 = true;
            paramToServiceMsg.add(Boolean.valueOf(bool1));
            if (((cmd0x7c7.RspBody)paramObject).uint32_prevent_dynamic.get() == 1)
            {
              bool1 = true;
              paramToServiceMsg.add(Boolean.valueOf(bool1));
              paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              if (((cmd0x7c7.RspBody)paramObject).uint32_not_see_qzone.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.e(bool1, false);
              paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              if (((cmd0x7c7.RspBody)paramObject).uint32_prevent_dynamic.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.f(bool1, false);
              bool1 = true;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          if (paramToServiceMsg == null) {
            continue;
          }
          int i2 = paramToServiceMsg.uint32_result.get();
          paramToServiceMsg = (ToServiceMsg)localObject;
          bool1 = bool4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FriendListHandler", 2, "handleGetDongtaiPermission  fail resultCode : " + i2);
          paramToServiceMsg = (ToServiceMsg)localObject;
          bool1 = bool4;
        }
        catch (Exception paramObject)
        {
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = (ToServiceMsg)paramObject;
          bool1 = bool3;
          continue;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool1 = bool3;
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetDongtaiPermission Exception " + paramToServiceMsg.getMessage());
        }
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = false;
        continue;
        paramToServiceMsg = (ToServiceMsg)localObject;
        bool1 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "ssoPkg is null");
        paramToServiceMsg = (ToServiceMsg)localObject;
        bool1 = bool4;
        continue;
        if (i1 == 2)
        {
          bool3 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
          paramFromServiceMsg = paramToServiceMsg;
          continue;
        }
        paramFromServiceMsg = paramToServiceMsg;
        bool3 = bool1;
        if (i1 != 3) {
          continue;
        }
        paramFromServiceMsg = new ArrayList();
        paramFromServiceMsg.add(Boolean.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(false)));
        paramFromServiceMsg.add(Boolean.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(false)));
        bool3 = bool1;
        continue;
        if (i1 == 2)
        {
          a(84, bool2, Boolean.valueOf(bool3));
          return;
        }
        if (i1 != 3) {
          continue;
        }
        a(86, bool2, paramFromServiceMsg);
        return;
      }
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(bool1, false);
        paramToServiceMsg = null;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool3;
        continue;
        paramToServiceMsg = null;
        bool1 = true;
        continue;
      }
      paramFromServiceMsg = paramToServiceMsg;
      bool3 = bool1;
      if (!bool2)
      {
        if (i1 == 1)
        {
          bool3 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
      else
      {
        if (i1 != 1) {
          continue;
        }
        a(82, bool2, Boolean.valueOf(bool3));
        return;
        bool1 = false;
        break;
        bool2 = false;
        continue;
        bool1 = false;
        continue;
        if (i1 == 2)
        {
          i2 = ((cmd0x7c7.RspBody)paramObject).uint32_prevent_dynamic.get();
          if (i2 == 1)
          {
            bool1 = true;
            bool3 = bool1;
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f(bool1, false);
            paramToServiceMsg = null;
            continue;
          }
          bool1 = false;
          continue;
        }
        if (i1 != 3) {
          break label694;
        }
        paramToServiceMsg = new ArrayList();
      }
      label694:
      label702:
      bool3 = true;
      boolean bool2 = bool1;
      paramToServiceMsg = null;
      bool1 = bool3;
    }
  }
  
  /* Error */
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_2
    //   4: ifnull +138 -> 142
    //   7: aload_2
    //   8: invokevirtual 428	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   11: ifeq +131 -> 142
    //   14: aload_3
    //   15: ifnull +127 -> 142
    //   18: iconst_1
    //   19: istore 7
    //   21: aload_1
    //   22: getfield 873	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   25: ldc_w 3326
    //   28: iconst_1
    //   29: invokevirtual 2114	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   32: istore 9
    //   34: aconst_null
    //   35: astore_2
    //   36: aconst_null
    //   37: astore 4
    //   39: aconst_null
    //   40: astore 5
    //   42: iload 7
    //   44: ifeq +316 -> 360
    //   47: new 440	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   50: dup
    //   51: invokespecial 441	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   54: astore 5
    //   56: aload 5
    //   58: aload_3
    //   59: checkcast 443	[B
    //   62: checkcast 443	[B
    //   65: invokevirtual 447	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload 5
    //   71: ifnull +77 -> 148
    //   74: aload 5
    //   76: getfield 451	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   79: invokevirtual 460	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   82: ifne +66 -> 148
    //   85: iconst_1
    //   86: istore 7
    //   88: iload 7
    //   90: ifeq +125 -> 215
    //   93: aload_1
    //   94: getfield 873	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   97: ldc_w 3328
    //   100: invokevirtual 3331	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   103: astore_1
    //   104: aload_0
    //   105: getfield 811	com/tencent/mobileqq/app/FriendListHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   108: bipush 50
    //   110: invokevirtual 1049	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   113: checkcast 971	com/tencent/mobileqq/app/FriendsManager
    //   116: astore_2
    //   117: iload 9
    //   119: ifeq +35 -> 154
    //   122: aload_2
    //   123: aload_1
    //   124: invokevirtual 3333	com/tencent/mobileqq/app/FriendsManager:e	(Ljava/util/List;)V
    //   127: iload 9
    //   129: ifeq +211 -> 340
    //   132: aload_0
    //   133: bipush 90
    //   135: iload 7
    //   137: aload_1
    //   138: invokevirtual 535	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   141: return
    //   142: iconst_0
    //   143: istore 7
    //   145: goto -124 -> 21
    //   148: iconst_0
    //   149: istore 7
    //   151: goto -63 -> 88
    //   154: aload_2
    //   155: aload_1
    //   156: invokevirtual 3335	com/tencent/mobileqq/app/FriendsManager:d	(Ljava/util/List;)V
    //   159: goto -32 -> 127
    //   162: astore_3
    //   163: aload_1
    //   164: astore_2
    //   165: iload 8
    //   167: istore 7
    //   169: aload_2
    //   170: astore_1
    //   171: invokestatic 433	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -47 -> 127
    //   177: ldc 56
    //   179: iconst_2
    //   180: new 462	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 463	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 3337
    //   190: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_3
    //   194: invokevirtual 2847	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iload 8
    //   208: istore 7
    //   210: aload_2
    //   211: astore_1
    //   212: goto -85 -> 127
    //   215: aload 5
    //   217: ifnull +49 -> 266
    //   220: aload 5
    //   222: getfield 451	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   225: invokevirtual 460	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   228: istore 6
    //   230: invokestatic 433	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +133 -> 366
    //   236: ldc 56
    //   238: iconst_2
    //   239: new 462	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 463	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 3339
    //   249: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload 6
    //   254: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto +103 -> 366
    //   266: invokestatic 433	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +12 -> 281
    //   272: ldc 56
    //   274: iconst_2
    //   275: ldc_w 3341
    //   278: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aconst_null
    //   282: astore_1
    //   283: goto -156 -> 127
    //   286: astore_3
    //   287: aload 4
    //   289: astore_2
    //   290: iload 8
    //   292: istore 7
    //   294: aload_2
    //   295: astore_1
    //   296: invokestatic 433	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq -172 -> 127
    //   302: ldc 56
    //   304: iconst_2
    //   305: new 462	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 463	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 3337
    //   315: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_3
    //   319: invokevirtual 696	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: iload 8
    //   333: istore 7
    //   335: aload_2
    //   336: astore_1
    //   337: goto -210 -> 127
    //   340: aload_0
    //   341: bipush 91
    //   343: iload 7
    //   345: aload_1
    //   346: invokevirtual 535	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   349: return
    //   350: astore_3
    //   351: aload_1
    //   352: astore_2
    //   353: goto -63 -> 290
    //   356: astore_3
    //   357: goto -192 -> 165
    //   360: aload 5
    //   362: astore_1
    //   363: goto -236 -> 127
    //   366: aconst_null
    //   367: astore_1
    //   368: goto -241 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	FriendListHandler
    //   0	371	1	paramToServiceMsg	ToServiceMsg
    //   0	371	2	paramFromServiceMsg	FromServiceMsg
    //   0	371	3	paramObject	Object
    //   37	251	4	localObject	Object
    //   40	321	5	localOIDBSSOPkg	oidb_sso.OIDBSSOPkg
    //   228	25	6	i1	int
    //   19	325	7	bool1	boolean
    //   1	331	8	bool2	boolean
    //   32	96	9	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   104	117	162	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	127	162	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   154	159	162	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   47	69	286	java/lang/Exception
    //   74	85	286	java/lang/Exception
    //   93	104	286	java/lang/Exception
    //   220	263	286	java/lang/Exception
    //   266	281	286	java/lang/Exception
    //   104	117	350	java/lang/Exception
    //   122	127	350	java/lang/Exception
    //   154	159	350	java/lang/Exception
    //   47	69	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   74	85	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   93	104	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   220	263	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   266	281	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    }
    int i1;
    int i2;
    boolean bool2;
    long l1;
    label332:
    int i3;
    int i4;
    ArrayList localArrayList;
    label570:
    MayKnowRecommend localMayKnowRecommend;
    int i7;
    for (;;)
    {
      i1 = 0;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend success=" + bool1);
      }
      paramFromServiceMsg = new StringBuilder();
      if (!bool1) {
        break label1508;
      }
      label692:
      label790:
      label824:
      label840:
      label1033:
      label1049:
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramObject != null) && (((oidb_sso.OIDBSSOPkg)paramObject).uint32_result != null)) {}
        for (bool1 = true;; bool1 = false)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleMayKnowRecommend isSuccess=" + bool1 + " result=" + 0);
          }
          if (bool1)
          {
            i2 = ((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get();
            i1 = i2;
            if (QLog.isColorLevel())
            {
              QLog.d("FriendListHandler", 2, "handleMayKnowRecommend result=" + i2);
              i1 = i2;
            }
          }
          bool2 = paramToServiceMsg.extraData.getBoolean("FromPush", false);
          l1 = paramToServiceMsg.extraData.getLong("PushTime", 0L);
          if ((i1 & 0xFF) != 132) {
            break label332;
          }
          ((MayknowRecommendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(158)).a(new ArrayList(), bool2, l1);
          a(92, true, null);
          return;
          bool1 = false;
          break;
        }
        if ((!bool1) || (i1 != 0) || (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer == null) || (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null)) {
          break label1508;
        }
        paramToServiceMsg = ByteBuffer.wrap(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray());
        i1 = paramToServiceMsg.get();
        i2 = paramToServiceMsg.getShort();
        i3 = paramToServiceMsg.get();
        if (i3 == 1) {}
        i4 = paramToServiceMsg.getShort();
        int i5 = paramToServiceMsg.getShort();
        new HashMap(i5);
        paramObject = new StringBuffer(1024);
        if (QLog.isColorLevel())
        {
          ((StringBuffer)paramObject).append("handleMayKnowRecommend cFlag=");
          ((StringBuffer)paramObject).append(i1);
          ((StringBuffer)paramObject).append(" wTotalUinNum=");
          ((StringBuffer)paramObject).append(i2);
          ((StringBuffer)paramObject).append(" cEndFlag=");
          ((StringBuffer)paramObject).append(i3);
          ((StringBuffer)paramObject).append(" wEndPos=");
          ((StringBuffer)paramObject).append(i4);
          ((StringBuffer)paramObject).append(" wUinNum=");
          ((StringBuffer)paramObject).append(i5);
          ((StringBuffer)paramObject).append(" fromPush=");
          ((StringBuffer)paramObject).append(bool2);
          ((StringBuffer)paramObject).append(" pushTime=");
          ((StringBuffer)paramObject).append(l1);
        }
        localArrayList = new ArrayList(i5);
        if (i5 <= 0) {
          break label1427;
        }
        i1 = 0;
        if (i1 >= i5) {
          break label1411;
        }
        localMayKnowRecommend = new MayKnowRecommend();
        paramToServiceMsg.getShort();
        localObject = String.valueOf(Utils.a(paramToServiceMsg.getInt()));
        localMayKnowRecommend.uin = ((String)localObject);
        if (QLog.isColorLevel())
        {
          ((StringBuffer)paramObject).append(" \nuin=");
          ((StringBuffer)paramObject).append((String)localObject);
        }
        paramToServiceMsg.get();
        int i6 = paramToServiceMsg.get();
        i2 = 0;
        if (i2 >= i6) {
          break label1393;
        }
        i7 = paramToServiceMsg.get();
        i4 = paramToServiceMsg.get();
        if (!QLog.isColorLevel()) {
          break label1561;
        }
        paramFromServiceMsg.append(" len = ").append(i4).append("\n");
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          break label790;
        }
        QLog.w("FriendListHandler", 2, "handleMayKnowRecommend e", paramToServiceMsg);
        if (!QLog.isColorLevel()) {
          break label824;
        }
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        if (!QLog.isColorLevel()) {
          break label840;
        }
        QLog.d("FriendListHandler", 2, paramFromServiceMsg.toString());
        a(92, false, null);
        return;
        localMayKnowRecommend.recommendReason = new String((byte[])localObject);
        if (!QLog.isColorLevel()) {
          break label1644;
        }
        ((StringBuffer)paramObject).append(" reason=");
        ((StringBuffer)paramObject).append(localMayKnowRecommend.recommendReason);
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("FriendListHandler", 2, "handleMayKnowRecommend ex", paramToServiceMsg);
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, paramFromServiceMsg.toString());
          }
        }
        localMayKnowRecommend.age = Utils.a((byte[])localObject, 0);
        if (!QLog.isColorLevel()) {
          break label1644;
        }
        ((StringBuffer)paramObject).append(" age=");
        ((StringBuffer)paramObject).append(localMayKnowRecommend.age);
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label1033;
        }
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        if (!QLog.isColorLevel()) {
          break label1049;
        }
        QLog.d("FriendListHandler", 2, paramFromServiceMsg.toString());
      }
    }
    Object localObject = new byte[i3];
    paramToServiceMsg.get((byte[])localObject, 0, i3);
    if (QLog.isColorLevel())
    {
      ((StringBuffer)paramObject).append(" type=");
      ((StringBuffer)paramObject).append(i7);
      break label1581;
      localMayKnowRecommend.remark = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1644;
      }
      ((StringBuffer)paramObject).append(" remark=");
      ((StringBuffer)paramObject).append(localMayKnowRecommend.remark);
      break label1644;
      localMayKnowRecommend.gender = Utils.a((byte[])localObject, 0);
      if (!QLog.isColorLevel()) {
        break label1644;
      }
      ((StringBuffer)paramObject).append(" gender=");
      ((StringBuffer)paramObject).append(localMayKnowRecommend.gender);
      break label1644;
      localMayKnowRecommend.country = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1644;
      }
      ((StringBuffer)paramObject).append(" country=");
      ((StringBuffer)paramObject).append(localMayKnowRecommend.country);
      break label1644;
      localMayKnowRecommend.province = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1644;
      }
      ((StringBuffer)paramObject).append(" province=");
      ((StringBuffer)paramObject).append(localMayKnowRecommend.province);
      break label1644;
      localMayKnowRecommend.city = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1644;
      }
      ((StringBuffer)paramObject).append(" city=");
      ((StringBuffer)paramObject).append(localMayKnowRecommend.city);
      break label1644;
      localMayKnowRecommend.nick = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1644;
      }
      ((StringBuffer)paramObject).append(" nick=");
      ((StringBuffer)paramObject).append(localMayKnowRecommend.nick);
      break label1644;
      localMayKnowRecommend.category = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1644;
      }
      ((StringBuffer)paramObject).append(" category=");
      ((StringBuffer)paramObject).append(localMayKnowRecommend.category);
      break label1644;
      localMayKnowRecommend.algBuffer = ((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1644;
      }
      ((StringBuffer)paramObject).append(" algBuffer=");
      ((StringBuffer)paramObject).append(new String(localMayKnowRecommend.algBuffer));
      break label1644;
      localMayKnowRecommend.richSingature = ((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1644;
      }
      ((StringBuffer)paramObject).append(" richSingature=");
      break label1644;
    }
    for (;;)
    {
      localMayKnowRecommend.hasQZoneUpdate = bool1;
      if (QLog.isColorLevel())
      {
        ((StringBuffer)paramObject).append(" hasQZoneUpdate=");
        ((StringBuffer)paramObject).append(localMayKnowRecommend.hasQZoneUpdate);
        break label1644;
        label1393:
        localArrayList.add(localMayKnowRecommend);
        i1 = (short)(i1 + 1);
        break label570;
        label1411:
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, ((StringBuffer)paramObject).toString());
        }
        label1427:
        ((MayknowRecommendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(158)).a(localArrayList, bool2, l1);
        a(92, true, null);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FriendListHandler", 2, paramFromServiceMsg.toString());
        return;
        label1508:
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        }
        if (!QLog.isColorLevel()) {
          break label840;
        }
        QLog.d("FriendListHandler", 2, paramFromServiceMsg.toString());
        break label840;
        label1561:
        i3 = i4;
        if (i4 >= 0) {
          break label692;
        }
        i3 = i4 + 256;
        break label692;
      }
      switch (i7)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      default: 
        i2 = (byte)(i2 + 1);
        break;
      case 17: 
        label1581:
        label1644:
        if (localObject[0] == 0) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        break;
      }
    }
  }
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (QLog.isColorLevel())) {
        QLog.d("FriendListHandler", 2, "handleCancelMayKnowRecommend failed uin=" + paramToServiceMsg.extraData.getString("uin"));
      }
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramObject != null) {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        }
      }
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (FromServiceMsg)paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          int i1;
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleCancelMayKnowRecommend", (Throwable)paramObject);
          }
          ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
          continue;
          bool2 = false;
        }
      }
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label234;
      }
      i1 = paramFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleCancelMayKnowRecommend" + i1);
      }
      if (i1 != 0) {
        break label234;
      }
      ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(158)).a(paramToServiceMsg.extraData.getString("uin"));
      bool2 = true;
      a(93, bool2, paramToServiceMsg.extraData.getString("uin"));
      return;
    }
  }
  
  public QQHeadDownloadHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler;
    }
  }
  
  protected Class a()
  {
    return FriendListObserver.class;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a();
    }
  }
  
  public String a(int paramInt, long paramLong, String paramString)
  {
    if (paramInt == 11) {
      return paramString;
    }
    return Long.toString(paramLong);
  }
  
  public String a(long paramLong)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.app, "offlineTips");
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        try
        {
          localObject1 = ((String)localObject1).split(";");
          int i2 = localObject1.length;
          while (i1 < i2)
          {
            Object localObject2 = localObject1[i1].split(":");
            long l1 = Long.parseLong(localObject2[0]);
            localObject2 = localObject2[1];
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), localObject2);
            i1 += 1;
          }
          str = null;
        }
        catch (Exception localException) {}
      }
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    }
    return str;
  }
  
  public String a(long paramLong, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return String.valueOf(paramLong);
  }
  
  public ArrayList a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return localArrayList;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      a(this.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
  }
  
  public void a(byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "DeleteFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 2);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    a(localToServiceMsg);
  }
  
  public void a(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "AddFriendGroup :" + paramString);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 0);
    localToServiceMsg.extraData.putByte("sort_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    a(localToServiceMsg);
  }
  
  public void a(byte paramByte, ArrayList paramArrayList)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.BindUin");
    localToServiceMsg.extraData.putByte("cCmd", paramByte);
    localToServiceMsg.addAttribute("vecBindUin", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.group.ring");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 2);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getAllGeneralSettings.localRevision=" + paramInt1 + " offset=" + paramLong + " respRevision=" + paramInt2 + " isNeedGetTroopMsgFilter=" + paramBoolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localArrayList.add("message.group.policy.*");
    }
    localArrayList.add("message.group.policy_pc.*");
    localArrayList.add("sync.c2c_message");
    localArrayList.add("message.group.ring");
    localArrayList.add("message.group.vibrate");
    localArrayList.add("message.ring.switch");
    localArrayList.add("message.vibrate.switch");
    localArrayList.add("message.ring.care");
    a(localArrayList, paramInt1, paramLong, paramInt2, 100, paramBoolean);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, String paramString, long paramLong3, long paramLong4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BumpSvc.ReqComfirmContactFriend");
    Object localObject = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    if (localObject != null)
    {
      String str = ((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo;
      if ((str != null) && (str.length() > 0))
      {
        localObject = str;
        if (str.startsWith("+")) {
          localObject = str.substring(1);
        }
      }
    }
    for (long l1 = Long.parseLong((String)localObject);; l1 = 0L)
    {
      localToServiceMsg.extraData.putInt("bType", paramInt);
      localToServiceMsg.extraData.putLong("lToMID", paramLong1);
      localToServiceMsg.extraData.putLong("lFromMobile", l1);
      localToServiceMsg.extraData.putLong("lToMobile", paramLong2);
      localToServiceMsg.extraData.putByteArray("vSig", paramArrayOfByte);
      localToServiceMsg.extraData.putByte("bGroupId", paramByte);
      localToServiceMsg.extraData.putString("strNickName", paramString);
      localToServiceMsg.extraData.putLong("infotime", paramLong3);
      localToServiceMsg.extraData.putLong("dbid", paramLong4);
      a(localToServiceMsg);
      return;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramString, paramInt2, paramInt3, 0, null, 0, 0L);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, long paramLong)
  {
    boolean bool;
    long l1;
    if (paramInt1 == 0)
    {
      bool = true;
      l1 = paramLong;
      if (paramLong == 0L) {
        l1 = System.currentTimeMillis();
      }
      if (paramInt3 != 1) {
        break label654;
      }
      if (this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1)) {
        this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
      }
      paramString2 = new pya(this);
      paramString2.jdField_a_of_type_Long = l1;
      paramString2.jdField_b_of_type_Int = paramInt2;
      this.jdField_c_of_type_JavaUtilHashtable.put(paramString1, paramString2);
    }
    for (;;)
    {
      long l2;
      Object localObject;
      if (((!bool) || (paramInt3 == 4)) && (paramString2 != null))
      {
        l2 = paramString2.jdField_b_of_type_Long - paramString2.jdField_a_of_type_Long;
        l1 = 0L;
        paramLong = l1;
        if (paramString2.c > paramString2.jdField_b_of_type_Long)
        {
          paramLong = l1;
          if (paramString2.jdField_b_of_type_Long > 0L) {
            paramLong = paramString2.c - paramString2.jdField_b_of_type_Long;
          }
        }
        l1 = paramString2.d - paramString2.c;
        if ((QLog.isColorLevel()) || ((bool) && (paramInt3 == 4) && (paramString2.e > 3000L)))
        {
          localObject = new StringBuffer(200);
          ((StringBuffer)localObject).append("===QQHeadStat resultCode=").append(paramInt1);
          ((StringBuffer)localObject).append(", uin=").append(String.format("%11s", new Object[] { paramString1 }));
          ((StringBuffer)localObject).append(", totalTime=").append(String.format("%-5s", new Object[] { Long.valueOf(paramString2.e) }));
          ((StringBuffer)localObject).append(", picSize=").append(String.format("%-6s", new Object[] { Integer.valueOf(paramString2.jdField_a_of_type_Int) }));
          ((StringBuffer)localObject).append(", downInfoTime=").append(l2);
          ((StringBuffer)localObject).append(", intervalTime=").append(paramLong);
          ((StringBuffer)localObject).append(", downPicTime=").append(l1);
          ((StringBuffer)localObject).append(", reasonCode=").append(paramInt5);
          ((StringBuffer)localObject).append(", downUrl=").append(paramString2.jdField_a_of_type_JavaLangString);
          if (!QLog.isColorLevel()) {
            break label826;
          }
        }
      }
      label654:
      label826:
      for (paramInt3 = 2;; paramInt3 = 1)
      {
        QLog.d("QQHeadCostTime", paramInt3, ((StringBuffer)localObject).toString());
        if (NetworkUtil.e(BaseApplication.getContext()))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("qqhead_uin", paramString1);
          ((HashMap)localObject).put("downInfo_time", String.valueOf(l2));
          ((HashMap)localObject).put("interval_time", String.valueOf(paramLong));
          ((HashMap)localObject).put("downPic_time", String.valueOf(l1));
          ((HashMap)localObject).put("downPic_size", String.valueOf(paramString2.jdField_a_of_type_Int));
          ((HashMap)localObject).put("download_url", paramString2.jdField_a_of_type_JavaLangString);
          ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt1));
          ((HashMap)localObject).put("fail_reason", Integer.toString(paramInt5));
          ((HashMap)localObject).put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
          paramString1 = FaceDownloader.a(paramInt2);
          if (!TextUtils.isEmpty(paramString1)) {
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, bool, paramString2.e, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
          }
          paramString1 = FaceDownloader.b(paramInt2);
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, bool, paramString2.e, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
        }
        do
        {
          return;
          bool = false;
          break;
          if (!this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1)) {
            break label832;
          }
          localObject = (pya)this.jdField_c_of_type_JavaUtilHashtable.get(paramString1);
        } while (localObject == null);
        switch (paramInt3)
        {
        }
        for (;;)
        {
          paramString2 = (String)localObject;
          break;
          ((pya)localObject).jdField_b_of_type_Long = l1;
          if (!bool) {
            this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
          }
          ((pya)localObject).e = (((pya)localObject).jdField_b_of_type_Long - ((pya)localObject).jdField_a_of_type_Long);
          paramString2 = (String)localObject;
          break;
          ((pya)localObject).c = l1;
          paramString2 = (String)localObject;
          break;
          ((pya)localObject).d = l1;
          ((pya)localObject).jdField_a_of_type_Int = paramInt4;
          ((pya)localObject).jdField_a_of_type_JavaLangString = paramString2;
          ((pya)localObject).e = (((pya)localObject).d - ((pya)localObject).jdField_a_of_type_Long);
          this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
        }
      }
      label832:
      paramString2 = null;
    }
  }
  
  public void a(int paramInt, ConcurrentHashMap paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.size() == 0)) {
      return;
    }
    Object localObject = new ConcurrentHashMap();
    ((Map)localObject).putAll(paramConcurrentHashMap);
    paramConcurrentHashMap = new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramConcurrentHashMap.add(new GeneralSettings.Setting((String)localEntry.getKey(), ((Integer)localEntry.getValue()).toString()));
    }
    localObject = a("ProfileService.ReqSetSettings");
    ((ToServiceMsg)localObject).extraData.putSerializable("Settings", paramConcurrentHashMap);
    ((ToServiceMsg)localObject).extraData.putSerializable("localRevision", Integer.valueOf(paramInt));
    a((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "FriendListHandler getRecomGatheredList(). startIndex = " + paramInt);
    }
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x7c4_0");
    localToServiceMsg.extraData.putInt("startIndex", paramInt);
    localToServiceMsg.extraData.putBoolean("isGetRecomm", true);
    cmd0x7c4.ReqBody localReqBody = new cmd0x7c4.ReqBody();
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localToServiceMsg.extraData.putBoolean("beforeShowTip", paramBoolean);
    cmd0x7c4.GetRecommendSNFrdListReq localGetRecommendSNFrdListReq = new cmd0x7c4.GetRecommendSNFrdListReq();
    localGetRecommendSNFrdListReq.uint64_uin.set(Long.parseLong((String)localObject));
    int i1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getInt("GetRecomFrdListReq_seq", 0);
    localGetRecommendSNFrdListReq.uint32_sequence.set(i1);
    localGetRecommendSNFrdListReq.uint32_start_idx.set(paramInt);
    localGetRecommendSNFrdListReq.uint32_req_num.set(ck);
    localReqBody.msg_get_recommend_sn_frd_list_req.set(localGetRecommendSNFrdListReq);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1988);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    b(localToServiceMsg);
  }
  
  public void a(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    int i2 = -1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setSpecialCareSwitch(). type=").append(paramInt).append(", uin size=");
      if (paramArrayOfString != null) {
        break label112;
      }
      i1 = -1;
      localObject1 = ((StringBuilder)localObject1).append(i1).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label119;
      }
    }
    label112:
    label119:
    for (int i1 = i2;; i1 = paramArrayOfBoolean.length)
    {
      QLog.d("set_special_care_switch", 2, i1);
      if ((paramInt >= 1) && (paramInt <= 3) && (paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label126;
      }
      return;
      i1 = paramArrayOfString.length;
      break;
    }
    label126:
    Object localObject1 = new ArrayList();
    i1 = 0;
    if (i1 < paramArrayOfString.length)
    {
      localObject2 = paramArrayOfString[i1];
      int i3 = paramArrayOfBoolean[i1];
      Object localObject3 = new oidb_0x5d6.SnsUpdateItem();
      ArrayList localArrayList = new ArrayList();
      switch (paramInt)
      {
      }
      for (;;)
      {
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        i1 += 1;
        break;
        byte[] arrayOfByte;
        if (i3 != 0)
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
        }
        else
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          if (i3 != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          if (i3 != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
        }
      }
    }
    Object localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.SvcReqKikOut");
    localToServiceMsg.extraData.putLong("appid", paramLong);
    localToServiceMsg.extraData.putByte("cKeyType", paramByte);
    localToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
    localToServiceMsg.extraData.putByteArray("sKey", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("index", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2, int paramInt3, int paramInt4, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt5, int paramInt6, int paramInt7)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqCondSearch");
    localToServiceMsg.extraData.putLong("search_seq", paramLong1);
    localToServiceMsg.extraData.putInt("param_page", paramInt1);
    localToServiceMsg.extraData.putLong("param_session_id", paramLong2);
    localToServiceMsg.extraData.putString("param_keyword", paramString);
    localToServiceMsg.extraData.putInt("param_sex_index", paramInt2);
    localToServiceMsg.extraData.putInt("param_age_index1", paramInt3);
    localToServiceMsg.extraData.putInt("param_age_index2", paramInt4);
    localToServiceMsg.extraData.putStringArray("param_loc_code", paramArrayOfString1);
    localToServiceMsg.extraData.putStringArray("param_home_code", paramArrayOfString2);
    localToServiceMsg.extraData.putInt("param_job_index", paramInt5);
    localToServiceMsg.extraData.putInt("param_xingzuo_index", paramInt6);
    localToServiceMsg.extraData.putInt("param_search_from", paramInt7);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList)
  {
    device_lock_confirm_auth.ReqBody localReqBody = new device_lock_confirm_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localReqBody.uint32_subappid.set(paramInt1);
    localReqBody.uint32_seq.set(paramInt2);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    int i1 = paramArrayList.size();
    paramString = new ArrayList();
    paramInt2 = 0;
    if (paramInt2 < i1)
    {
      device_lock_confirm_auth.DeviceInfo localDeviceInfo = new device_lock_confirm_auth.DeviceInfo();
      DeviceLockItemInfo localDeviceLockItemInfo = (DeviceLockItemInfo)paramArrayList.get(paramInt2);
      if (localDeviceLockItemInfo == null) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        localDeviceInfo.bytes_appname.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_c_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_name.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_b_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_guid.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte));
        localDeviceInfo.uint32_appid.set(localDeviceLockItemInfo.jdField_a_of_type_Int);
        localDeviceInfo.uint32_auth_status.set(localDeviceLockItemInfo.jdField_c_of_type_Int);
        localDeviceInfo.uint32_subappid.set(paramInt1);
        paramString.add(localDeviceInfo);
      }
    }
    if (paramString.size() > 0) {
      localReqBody.rpt_msg_devicelist.set(paramString);
    }
    paramString = a("DevLockAuthSvc.ConfirmAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    b(paramString);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i1;
    Object localObject1;
    long l1;
    Object localObject2;
    if (paramBoolean)
    {
      i1 = 1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " setId:" + paramInt + " isSet:" + paramBoolean);
      }
      localObject1 = new Oidb_0x5d1.ReqBody();
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_cmd.set(i1);
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_id.set(paramInt);
      l1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacts.", 2, "FriendListHandler.send_oidb_0x5d1_0 " + l1);
      }
      if (!paramBoolean) {
        break label321;
      }
      localObject2 = new Oidb_0x5d1.SetFriendIdReq();
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint64_seq.set(l1);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_set_friend_id.set((MessageMicro)localObject2);
    }
    for (;;)
    {
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1489);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d1.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x5d1_0");
      ((ToServiceMsg)localObject1).extraData.putLong("friendUin", paramLong);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isSet", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putInt("setId", paramInt);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      return;
      i1 = 2;
      break;
      label321:
      localObject2 = new Oidb_0x5d1.ClearFriendIdReq();
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint64_seq.set(l1);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_clear_friend_id.set((MessageMicro)localObject2);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", 0L);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    device_lock_recommend_auth.ReqBody localReqBody = new device_lock_recommend_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localReqBody.uint32_subappid.set(paramInt);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.uint32_seq.set(1);
    paramString = a("DevLockAuthSvc.RecommendAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    b(paramString);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 1L);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    a(paramLong, 4051, paramBoolean);
  }
  
  public void a(QQHeadInfo arg1)
  {
    if (??? == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler != null) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return;
    }
  }
  
  public void a(CheckUpdateResp paramCheckUpdateResp)
  {
    Object localObject1 = null;
    Object localObject2;
    int i1;
    label70:
    CheckUpdateItemInterface localCheckUpdateItemInterface;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("FriendListHandler, handleCheckUpdate, ");
      if (paramCheckUpdateResp != null)
      {
        i1 = paramCheckUpdateResp.result;
        QLog.d("ProfileService.CheckUpdateReq", 2, i1);
      }
    }
    else
    {
      if ((paramCheckUpdateResp == null) || (paramCheckUpdateResp.result != 0)) {
        break label226;
      }
      Iterator localIterator = paramCheckUpdateResp.vecResPkg.iterator();
      paramCheckUpdateResp = null;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (RespItem)localIterator.next();
      } while (localObject2 == null);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "FriendListHandler::handleCheckUpdate item eServiceId = " + ((RespItem)localObject2).eServiceID + ",result=" + ((RespItem)localObject2).cResult);
      }
      localCheckUpdateItemInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.a(((RespItem)localObject2).eServiceID);
      if (localCheckUpdateItemInterface == null) {
        break label202;
      }
      if (((RespItem)localObject2).eServiceID != 101) {
        break label194;
      }
      localObject1 = localCheckUpdateItemInterface;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
      break label70;
      i1 = -1;
      break;
      label194:
      localCheckUpdateItemInterface.a((RespItem)localObject2);
      label202:
      localObject2 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject1;
      localObject1 = localObject2;
    }
    if ((paramCheckUpdateResp != null) && (localObject1 != null)) {
      paramCheckUpdateResp.a((RespItem)localObject1);
    }
    label226:
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess()) {
      if (QLog.isColorLevel()) {
        QLog.d("TAG", 2, "onReceive: onReceive handleRecommendDeviceList");
      }
    }
    for (paramFromServiceMsg = new device_lock_recommend_auth.RspBody();; paramFromServiceMsg = null)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint64_uin.has()) {
          paramFromServiceMsg.uint64_uin.get();
        }
        if (paramFromServiceMsg.uint32_seq.has()) {
          paramFromServiceMsg.uint32_seq.get();
        }
        if (paramFromServiceMsg.uint32_ret.has()) {
          paramFromServiceMsg.uint32_ret.get();
        }
        if (!paramFromServiceMsg.rpt_msg_devicelist.has()) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_devicelist.get();
        paramObject = new ArrayList();
        if (paramFromServiceMsg == null) {}
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        try
        {
          int i2 = paramFromServiceMsg.size();
          int i1 = 0;
          label138:
          if (i1 < i2)
          {
            device_lock_recommend_auth.DeviceInfo localDeviceInfo = (device_lock_recommend_auth.DeviceInfo)paramFromServiceMsg.get(i1);
            if (localDeviceInfo == null) {}
            for (;;)
            {
              i1 += 1;
              break label138;
              paramObject = paramObject;
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
              }
              ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
              break;
              DeviceLockItemInfo localDeviceLockItemInfo = new DeviceLockItemInfo();
              if (localDeviceInfo.bytes_appname.has())
              {
                localDeviceLockItemInfo.jdField_c_of_type_JavaLangString = new String(localDeviceInfo.bytes_appname.get().toByteArray(), "UTF-8");
                if (localDeviceInfo.bytes_guid.has())
                {
                  localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte = localDeviceInfo.bytes_guid.get().toByteArray();
                  if (localDeviceInfo.bytes_device_typeinfo.has())
                  {
                    localDeviceLockItemInfo.jdField_b_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_typeinfo.get().toByteArray(), "UTF-8");
                    new StringBuffer();
                    if (localDeviceInfo.bytes_device_name.has())
                    {
                      localDeviceLockItemInfo.jdField_a_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_name.get().toByteArray(), "UTF-8");
                      if (localDeviceInfo.uint32_auth_status.has())
                      {
                        localDeviceLockItemInfo.jdField_c_of_type_Int = localDeviceInfo.uint32_auth_status.get();
                        if (localDeviceInfo.uint32_appid.has())
                        {
                          localDeviceLockItemInfo.jdField_a_of_type_Int = localDeviceInfo.uint32_appid.get();
                          if (localDeviceInfo.uint32_subappid.has())
                          {
                            localDeviceLockItemInfo.jdField_b_of_type_Int = localDeviceInfo.uint32_subappid.get();
                            ((ArrayList)paramObject).add(localDeviceLockItemInfo);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          if (((ArrayList)paramObject).size() <= 0) {
            break label433;
          }
        }
        catch (Exception paramFromServiceMsg) {}
        a(69, true, paramObject);
        return;
      }
      label433:
      a(69, false, null);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    int i1 = 0;
    if (a(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label219:
    label429:
    label1347:
    label1353:
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (!paramFromServiceMsg.getServiceCmd().equals("friendlist.getFriendGroupList")) {
                      break label429;
                    }
                    if (!paramFromServiceMsg.isSuccess()) {
                      break label219;
                    }
                    paramObject = (GetFriendListResp)paramObject;
                    if (paramObject == null) {
                      break;
                    }
                    if (paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
                    {
                      a(paramToServiceMsg, (GetFriendListResp)paramObject);
                      return;
                    }
                    if (paramToServiceMsg.extraData.getByte("ifShowTermType", (byte)0).byteValue() == 1)
                    {
                      a(paramFromServiceMsg.getUin(), (GetFriendListResp)paramObject, paramToServiceMsg.extraData.getLong("timeStamp"), paramToServiceMsg.extraData.getStringArrayList("uinList"), paramToServiceMsg.extraData.getBoolean("is_manual_pull_refresh"));
                      return;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("FriendListHandler", 1, "handleGetFriendList unknow request!");
                  return;
                  if (!paramToServiceMsg.extraData.getBoolean("getSingleFriend")) {
                    QLog.e("FriendListHandler", 1, "friend list unserialize error");
                  }
                  this.g = 0L;
                  a(1, false, null);
                  a(99, false, null);
                  return;
                  if ((paramFromServiceMsg.getResultCode() == 2901) && (paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
                  {
                    i1 = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
                    if (QLog.isColorLevel()) {
                      QLog.d("FriendListHandler", 2, "k_resend_cnt" + i1);
                    }
                    if (i1 < 2)
                    {
                      paramToServiceMsg.extraData.putInt("k_resend_cnt", i1 + 1);
                      a(paramToServiceMsg);
                      return;
                    }
                    if (!paramToServiceMsg.extraData.getBoolean("getSingleFriend")) {
                      QLog.e("FriendListHandler", 1, "getFriendList timeout");
                    }
                    this.g = 0L;
                    a(1, false, null);
                    a(99, false, null);
                    return;
                  }
                  if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && (!paramToServiceMsg.extraData.getBoolean("getSingleFriend"))) {
                    QLog.e("FriendListHandler", 1, "getFriendList fail " + paramFromServiceMsg.getResultCode());
                  }
                  this.g = 0L;
                  a(1, false, null);
                  a(99, false, null);
                  return;
                  if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.RecommendAuth"))
                  {
                    a(paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.ConfirmAuth"))
                  {
                    c(paramFromServiceMsg.isSuccess());
                    return;
                  }
                  if (paramFromServiceMsg.getServiceCmd().equals("friendlist.GetLastLoginInfoReq"))
                  {
                    a(paramFromServiceMsg, (GetLastLoginInfoResp)paramObject);
                    return;
                  }
                  if (!paramFromServiceMsg.getServiceCmd().equals("ProfileService.GetRichSig")) {
                    break;
                  }
                } while (!paramFromServiceMsg.isSuccess());
                i1 = paramToServiceMsg.extraData.getInt("reqType", 0);
                if ((i1 == 0) || (i1 == 3))
                {
                  c(paramToServiceMsg, paramObject);
                  return;
                }
                b(paramToServiceMsg, paramObject);
                return;
                if (!"ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd())) {
                  break;
                }
                localObject = paramToServiceMsg.extraData.getStringArrayList("uinList");
              } while (!paramFromServiceMsg.isSuccess());
              paramObject = (ArrayList)paramObject;
            } while ((paramObject == null) || (localObject == null));
            a(paramToServiceMsg, (ArrayList)localObject, paramFromServiceMsg, (ArrayList)paramObject);
            return;
            if ("OidbSvc.0x4fc_30".equals(paramFromServiceMsg.getServiceCmd()))
            {
              g(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("AvatarInfoSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (QQHeadUrlResp)paramObject);
              return;
            }
            if ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              j(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramToServiceMsg.extraData.getInt("qqHeadType") == 16)
              {
                h(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              i(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("StatSvc.GetDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 1L)
              {
                b(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 2L)
              {
                c(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 4L)
              {
                d(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              a(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
              return;
            }
            if ("StatSvc.DelDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramToServiceMsg.extraData.getInt("iDelType") == 1)
              {
                b(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getInt("iDelType") == 2)
              {
                a(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
                return;
              }
              c(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
              return;
            }
            if ("StatSvc.SvcReqKikOut".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (SvcRespKikOut)paramObject);
              return;
            }
            if ("StatSvc.BindUin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (SvcRspBindUin)paramObject);
              return;
            }
            if ("ProfileService.ReqGetSettings".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (RespGetSettings)paramObject);
              return;
            }
            if ("ProfileService.ReqSetSettings".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (RespSetSettings)paramObject);
              return;
            }
            if (!"friendlist.MovGroupMemReq".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
            i1 = paramToServiceMsg.extraData.getByte("move_fri_type");
            if (i1 == 0)
            {
              if (paramObject != null)
              {
                a(paramToServiceMsg, (MovGroupMemResp)paramObject);
                return;
              }
              a(9, false, null);
              return;
            }
          } while ((i1 != 1) || (paramObject == null));
          paramToServiceMsg = (MovGroupMemResp)paramObject;
          return;
          if ("BumpSvc.ReqComfirmContactFriend".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramFromServiceMsg.isSuccess())
            {
              a(paramToServiceMsg, true);
              return;
            }
            a(10, false, null);
            return;
          }
          if ("friendlist.addFriend".equals(paramFromServiceMsg.getServiceCmd()))
          {
            a((AddFriendResp)paramObject, paramToServiceMsg);
            return;
          }
          if ("friendlist.getUserAddFriendSetting".equals(paramFromServiceMsg.getServiceCmd()))
          {
            a(paramToServiceMsg, (GetUserAddFriendSettingResp)paramObject);
            return;
          }
          if ("friendlist.GetSimpleOnlineFriendInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramObject != null)
            {
              b(paramFromServiceMsg, paramObject);
              return;
            }
            a(13, false, null);
            return;
          }
          if ("friendlist.GetOnlineInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
          {
            m(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("friendlist.delFriend".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramObject != null)
            {
              a(paramFromServiceMsg, (DelFriendResp)paramObject);
              return;
            }
            a(15, false, null);
            return;
          }
          if ("friendlist.SetGroupReq".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("onSetGroupCmd :").append(paramToServiceMsg.extraData.getInt("set_type", 64536)).append(", ").append(paramFromServiceMsg.isSuccess()).append(", ");
              if (paramObject == null) {
                break label1347;
              }
            }
            for (;;)
            {
              QLog.d("FriendListHandler", 2, bool);
              if (!paramFromServiceMsg.isSuccess()) {
                break label1353;
              }
              paramFromServiceMsg = (SetGroupResp)paramObject;
              if (paramFromServiceMsg == null) {
                break;
              }
              a(paramToServiceMsg, paramFromServiceMsg);
              return;
              bool = false;
            }
            switch (paramToServiceMsg.extraData.getInt("set_type", -1))
            {
            default: 
              return;
            case 0: 
              a(18, false, null);
              return;
            case 1: 
              a(19, false, null);
              return;
            case 2: 
              a(21, false, null);
              return;
            }
            a(22, false, null);
            return;
          }
          if ("ProfileService.ChangeFriendName".equals(paramFromServiceMsg.getServiceCmd()))
          {
            n(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("ProfileService.SetRichSig".equals(paramFromServiceMsg.getServiceCmd()))
          {
            o(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetAutoInfoReq"))
          {
            c(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (!"ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd())) {
            break;
          }
          if ((paramFromServiceMsg.getResultCode() == 1000) && (QLog.isColorLevel())) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate ok resultcode = " + paramFromServiceMsg.getResultCode());
          }
          if (((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && (QLog.isColorLevel())) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate timeout resultcode = " + paramFromServiceMsg.getResultCode());
          }
          a((CheckUpdateResp)paramObject);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        } while ((!FTSDBManager.a) || (!SQLiteFTSUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)));
        if (SQLiteFTSUtils.c()) {
          i1 = 1;
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1);
      } while (i1 != 1);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      return;
      if ("SummaryCard.ReqSearch".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d1_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x476_146".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x476_147".equals(paramFromServiceMsg.getServiceCmd())))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd()))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x491_107".equals(paramFromServiceMsg.getServiceCmd()))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x490_107".equals(paramFromServiceMsg.getServiceCmd()))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5e1_8".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
      if ("OidbSvc.0x49d_107".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7c4_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("isGetRecomm"))
        {
          t(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f4_5".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        x(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7c6_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        v(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7c7_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        w(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x847_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        y(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x53b_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        z(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6c9_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        A(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7df_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        B(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d6_7".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("param_is_set_switches_of_a_person"))
        {
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x77c".equals(paramFromServiceMsg.getServiceCmd()));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList1, FromServiceMsg paramFromServiceMsg, ArrayList paramArrayList2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    localEntityTransaction = localFriendsManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        Iterator localIterator = paramArrayList2.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localProfSmpInfoRes = (ProfSmpInfoRes)localIterator.next();
        str = String.valueOf(localProfSmpInfoRes.dwUin);
        if (!paramArrayList1.contains(str)) {
          continue;
        }
        if (str.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + str, localProfSmpInfoRes.strNick);
        }
        if (255 == localProfSmpInfoRes.cSpecialFlag) {
          localProfSmpInfoRes.cSpecialFlag = 0;
        }
        int i1 = localProfSmpInfoRes.cSpecialFlag;
        if (1 == i1) {
          try
          {
            paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, 0);
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
            {
              paramFromServiceMsg = paramFromServiceMsg.iterator();
              if (paramFromServiceMsg.hasNext())
              {
                localObject = (MessageRecord)paramFromServiceMsg.next();
                if ((((MessageRecord)localObject).msgtype != 64523) && (((MessageRecord)localObject).msgtype != 64517) && (((MessageRecord)localObject).msgtype != 64518) && (((MessageRecord)localObject).msgtype != 63517)) {
                  continue;
                }
                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, 0, ((MessageRecord)localObject).uniseq);
                continue;
              }
            }
            localFriendsManager.a(String.valueOf(localProfSmpInfoRes.dwUin), localProfSmpInfoRes.wFace, localProfSmpInfoRes.strNick, null, localProfSmpInfoRes.cSpecialFlag, (short)localProfSmpInfoRes.cSex, localProfSmpInfoRes.wAge);
          }
          catch (Exception paramFromServiceMsg)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
        paramFromServiceMsg = localFriendsManager.b(str);
        paramFromServiceMsg.nFaceID = localProfSmpInfoRes.wFace;
        paramFromServiceMsg.shGender = ((short)localProfSmpInfoRes.cSex);
        paramFromServiceMsg.age = localProfSmpInfoRes.wAge;
        paramFromServiceMsg.shAge = ((short)localProfSmpInfoRes.wAge);
        if (localProfSmpInfoRes.strNick != null) {
          paramFromServiceMsg.strNick = localProfSmpInfoRes.strNick;
        }
        if (localProfSmpInfoRes.sCountry != null) {
          paramFromServiceMsg.strCountry = localProfSmpInfoRes.sCountry;
        }
        if (localProfSmpInfoRes.sProvince != null) {
          paramFromServiceMsg.strProvince = localProfSmpInfoRes.sProvince;
        }
        if (localProfSmpInfoRes.sCity != null) {
          paramFromServiceMsg.strCity = localProfSmpInfoRes.sCity;
        }
        if ((localProfSmpInfoRes.cBusiCardFlag == 1) && (str.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())))
        {
          localObject = (BusinessCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111);
          if (localObject != null)
          {
            i1 = ((BusinessCardManager)localObject).a();
            BusinessCardServlet.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i1, 0, true);
            ((BusinessCardManager)localObject).a(1, true);
          }
        }
        if ((str.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (localProfSmpInfoRes.wLevel != 0)) {
          paramFromServiceMsg.iQQLevel = localProfSmpInfoRes.wLevel;
        }
        if ((localProfSmpInfoRes.isShowXMan == -1) || (localProfSmpInfoRes.dwLoginDay < 0L) || (localProfSmpInfoRes.dwPhoneQQXManDay <= 0L)) {
          continue;
        }
        if (!str.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          continue;
        }
        paramFromServiceMsg.lLoginDays = localProfSmpInfoRes.dwLoginDay;
        paramFromServiceMsg.lQQMasterLogindays = localProfSmpInfoRes.dwPhoneQQXManDay;
        if (localProfSmpInfoRes.isShowXMan != 1) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramArrayList1)
      {
        ProfSmpInfoRes localProfSmpInfoRes;
        String str;
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FriendListHandler", 2, "handleFriendInfo err", paramArrayList1);
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
        if (!paramToServiceMsg.extraData.getBoolean("batch_data")) {
          continue;
        }
        a(67, true, paramArrayList2);
        return;
        boolean bool = false;
        continue;
        localEntityTransaction.c();
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
      }
      paramFromServiceMsg.setXManFlag(bool);
      if (paramArrayList1.size() == 1)
      {
        if (!str.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          paramFromServiceMsg.allowPeopleSee = localProfSmpInfoRes.bOpenLoginDays;
        }
        paramFromServiceMsg.allowClick = localProfSmpInfoRes.bXManIconClick;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuffer(200);
        ((StringBuffer)localObject).append("Info.isShowXMan=");
        ((StringBuffer)localObject).append(localProfSmpInfoRes.isShowXMan);
        ((StringBuffer)localObject).append(";Info.dwLoginDay=");
        ((StringBuffer)localObject).append(localProfSmpInfoRes.dwLoginDay);
        ((StringBuffer)localObject).append(";Info.dwPhoneQQXManDay=");
        ((StringBuffer)localObject).append(localProfSmpInfoRes.dwPhoneQQXManDay);
        ((StringBuffer)localObject).append(";card.allowClick=");
        ((StringBuffer)localObject).append(paramFromServiceMsg.allowClick);
        ((StringBuffer)localObject).append(";card.allowPeopleSee= ");
        ((StringBuffer)localObject).append(paramFromServiceMsg.allowPeopleSee);
        QLog.d("FriendListHandler", 2, ((StringBuffer)localObject).toString());
      }
      localFriendsManager.a(paramFromServiceMsg);
      if (paramToServiceMsg.extraData.getBoolean("reqDateNick", false))
      {
        localObject = localProfSmpInfoRes.sDateNick;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramFromServiceMsg = localProfSmpInfoRes.strNick;
        }
        localObject = paramFromServiceMsg;
        if (TextUtils.isEmpty(paramFromServiceMsg)) {
          localObject = str;
        }
        localFriendsManager.a(str, (String)localObject, localProfSmpInfoRes.cSex);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | uin=" + str + " | datenick = " + localProfSmpInfoRes.sDateNick + " | nick=" + localProfSmpInfoRes.strNick);
        }
        a(89, true, new Object[] { str, localObject });
      }
      if (paramToServiceMsg.extraData.getBoolean("reqSelfLevel", false))
      {
        ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | iQQLevel = " + localProfSmpInfoRes.wLevel);
        }
      }
      if (paramToServiceMsg.extraData.getBoolean("reqXMan", false))
      {
        ContactConfig.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | dwLoginDay = " + localProfSmpInfoRes.dwLoginDay + " | dwPhoneQQXManDay = " + localProfSmpInfoRes.dwPhoneQQXManDay + " | isShowXMan = " + localProfSmpInfoRes.isShowXMan);
        }
      }
      a(3, true, str);
    }
  }
  
  public void a(DelGroupResp paramDelGroupResp, boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (paramBoolean) {
      localFriendsManager.a(paramDelGroupResp.cGroupid);
    }
    a(21, paramBoolean, paramGroupActionResp);
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.getFriendGroupList");
    localToServiceMsg.extraData.putBoolean("getSingleFriend", true);
    localToServiceMsg.extraData.putString("targetUin", paramString);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, byte paramByte)
  {
    a(4, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void a(String paramString, byte paramByte1, byte paramByte2)
  {
    a(1, paramString, 0, paramByte1, paramByte2, false);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c7.ReqBody();
    ((cmd0x7c7.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    if (paramInt == 1)
    {
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1991);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(0);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c7.ReqBody)localObject).toByteArray()));
      localObject = a("OidbSvc.0x7c7_0");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      if (paramInt != 1) {
        break label168;
      }
      ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
      if (paramInt == 2)
      {
        ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
        break;
      }
      if (paramInt != 3) {
        break;
      }
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
      break;
      label168:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      }
    }
  }
  
  public void a(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    a(32, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.GetAutoInfoReq");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("cType", (byte)1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getUserAddFriendSetting " + paramString1 + ", " + paramInt1 + ", " + paramString2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.getUserAddFriendSetting");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localToServiceMsg.extraData.putString("extra", paramString2);
    }
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((Friends.isValidUin(paramString)) && (b(paramString)))
    {
      b(new String[] { paramString });
      ToServiceMsg localToServiceMsg = a("ProfileService.GetSimpleInfo");
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putInt("type", paramInt);
      localToServiceMsg.extraData.putString("discussionUin", String.valueOf(paramLong));
      a(localToServiceMsg);
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "send_oidb_0x476 " + paramLong + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1142);
    localOIDBSSOPkg.uint32_service_type.set(paramInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.putShort((short)1);
    localByteBuffer.putInt((int)paramLong);
    localOIDBSSOPkg.bytes_bodybuffer.setHasFlag(true);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.extraData.putLong("uin", paramLong);
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "infoOpenId " + paramString1 + ", " + paramString2);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1505);
    localOIDBSSOPkg.uint32_service_type.set(8);
    oidb_0x5e1.ReqBody localReqBody = new oidb_0x5e1.ReqBody();
    localReqBody.rpt_bytes_openid.add(ByteStringMicro.copyFrom(paramString1.getBytes()));
    localReqBody.uint32_appid.set((int)Long.parseLong(paramString2));
    localReqBody.uint32_req_nick.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x5e1_8");
    paramString2.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString2.extraData.putString("uin", paramString1);
    b(paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5)
  {
    b(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2)
  {
    b(paramString1, paramString2, paramInt1, paramByte1, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, paramByte2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt3, long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    localToServiceMsg.extraData.putInt("search_page", paramInt2);
    localToServiceMsg.extraData.putIntArray("search_list", paramArrayOfInt);
    localToServiceMsg.extraData.putInt("search_version", paramInt1);
    localToServiceMsg.extraData.putDouble("search_longtitude", paramDouble1);
    localToServiceMsg.extraData.putDouble("search_latitude", paramDouble2);
    localToServiceMsg.extraData.putBoolean("search_decode", paramBoolean);
    localToServiceMsg.extraData.putInt("filter_type", paramInt3);
    localToServiceMsg.extraData.putLong("session_id", paramLong);
    if (QLog.isDevelopLevel()) {
      QLog.d("FriendListHandler", 4, "search friend with filter:" + paramInt3);
    }
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    localToServiceMsg.extraData.putInt("search_page", paramInt2);
    localToServiceMsg.extraData.putIntArray("search_list", paramArrayOfInt);
    localToServiceMsg.extraData.putInt("search_version", paramInt1);
    localToServiceMsg.extraData.putDouble("search_longtitude", paramDouble1);
    localToServiceMsg.extraData.putDouble("search_latitude", paramDouble2);
    localToServiceMsg.extraData.putBoolean("search_decode", paramBoolean);
    localToServiceMsg.extraData.putLong("session_id", paramLong);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      localObject = a("ProfileService.ChangeFriendName");
      ((ToServiceMsg)localObject).extraData.putString("com_value", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      a((ToServiceMsg)localObject);
    }
    do
    {
      return;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      paramString2 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      Card localCard = paramString2.b(paramString1);
      localCard.strReMark = ((String)localObject);
      paramString2.a(localCard);
      paramString2.b(paramString1, (String)localObject);
      ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString1, (String)localObject);
      paramString1 = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    } while (paramString1 == null);
    paramString1.f();
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 1);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 2);
    if (paramBoolean) {
      localToServiceMsg.extraData.putInt("iDelMe", 1);
    }
    for (;;)
    {
      localToServiceMsg.extraData.putLong("iAppId", paramLong);
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putInt("iDelMe", 0);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchInfoListManager", 2, "uin = " + paramString);
    }
    if ((Friends.isValidUin(paramString)) && (b(paramString)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      ToServiceMsg localToServiceMsg = a("ProfileService.GetSimpleInfo");
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putBoolean("reqSelfLevel", c(paramString));
      localToServiceMsg.extraData.putBoolean("reqXMan", e(paramString));
      localToServiceMsg.extraData.putBoolean("reqDateNick", paramBoolean);
      a(localToServiceMsg);
    }
  }
  
  public void a(String paramString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("uin=").append(paramString).append(", type size=");
      if (paramArrayOfInt != null) {
        break label142;
      }
      localObject1 = "";
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", switchState size=");
      if (paramArrayOfBoolean != null) {
        break label152;
      }
      localObject1 = "null";
      label64:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", ringId size=");
      if (paramArrayOfString != null) {
        break label162;
      }
    }
    label142:
    label152:
    label162:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramArrayOfString.length))
    {
      QLog.d("set_special_care_switches_of_a_person", 2, localObject1);
      if ((!StringUtil.b(paramString)) && (paramArrayOfInt != null) && (paramArrayOfBoolean != null) && (paramArrayOfString != null) && (paramArrayOfInt.length == paramArrayOfBoolean.length) && (paramArrayOfBoolean.length == paramArrayOfString.length)) {
        break label173;
      }
      return;
      localObject1 = Integer.valueOf(paramArrayOfInt.length);
      break;
      localObject1 = Integer.valueOf(paramArrayOfBoolean.length);
      break label64;
    }
    label173:
    Object localObject2 = new ArrayList();
    localObject1 = new oidb_0x5d6.SnsUpateBuffer();
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).uint64_uin.set(Long.parseLong(paramString));
    int i1 = 0;
    if (i1 < paramArrayOfInt.length)
    {
      int i2 = paramArrayOfInt[i1];
      int i3 = paramArrayOfBoolean[i1];
      Object localObject3 = paramArrayOfString[i1];
      oidb_0x5d6.SnsUpdateItem localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
      switch (i2)
      {
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (i3 != 0)
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
        }
        else
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          if (i3 != 0)
          {
            if (StringUtil.b((String)localObject3)) {
              throw new IllegalArgumentException("special ring id can not be empty!");
            }
            localObject3 = ((String)localObject3).getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          if (i3 != 0)
          {
            localObject3 = "1".getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
        }
      }
    }
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.set((List)localObject2);
    localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    localObject1 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject1).extraData.putString("param_uin", paramString);
    ((ToServiceMsg)localObject1).extraData.putIntArray("param_type", paramArrayOfInt);
    ((ToServiceMsg)localObject1).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject1).extraData.putStringArray("param_ring_ids", paramArrayOfString);
    ((ToServiceMsg)localObject1).extraData.putBoolean("param_is_set_switches_of_a_person", true);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "GeneralSettings getGeneralSettings start offset =" + paramLong1);
    }
    ToServiceMsg localToServiceMsg = a("ProfileService.ReqGetSettings");
    localToServiceMsg.extraData.putSerializable("Paths", paramArrayList);
    localToServiceMsg.extraData.putInt("Revision", paramInt1);
    localToServiceMsg.extraData.putLong("Offset", paramLong1);
    localToServiceMsg.extraData.putLong("Count", paramLong2);
    localToServiceMsg.extraData.putInt("respRevision", paramInt2);
    localToServiceMsg.extraData.putBoolean("needTroopSettings", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList1.size() != paramArrayList2.size())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList1.size())
    {
      String str = (String)paramArrayList1.get(i1);
      int i2 = ((Integer)paramArrayList2.get(i1)).intValue();
      localArrayList1.add("message.group.policy." + str);
      localArrayList2.add(String.valueOf(i2));
      i1 += 1;
    }
    a(localArrayList1, localArrayList2, 1);
  }
  
  protected void a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList1.size() != paramArrayList2.size())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList1.size())
    {
      localArrayList.add(new GeneralSettings.Setting((String)paramArrayList1.get(i1), (String)paramArrayList2.get(i1)));
      i1 += 1;
    }
    paramArrayList1 = a("ProfileService.ReqSetSettings");
    paramArrayList1.extraData.putSerializable("Settings", localArrayList);
    paramArrayList1.extraData.putInt("local_type", paramInt);
    a(paramArrayList1);
  }
  
  public void a(ConcurrentHashMap paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure " + paramConcurrentHashMap.size());
    }
    if (paramConcurrentHashMap.size() == 0) {
      return;
    }
    for (;;)
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      Object localObject;
      int i1;
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1737);
        localOIDBSSOPkg.uint32_service_type.set(0);
        localObject = paramConcurrentHashMap.entrySet().iterator();
        i1 = 10;
        if (((Iterator)localObject).hasNext())
        {
          localMayKnowExposure = (MayKnowExposure)((Map.Entry)((Iterator)localObject).next()).getValue();
          i1 += 30;
          if ((localMayKnowExposure.acBuffer == null) || (localMayKnowExposure.acBuffer.length <= 0)) {
            break label389;
          }
          i1 = localMayKnowExposure.acBuffer.length + i1;
          break label389;
        }
        localObject = ByteBuffer.allocate(i1);
        ((ByteBuffer)localObject).putLong(l1).putShort((short)paramConcurrentHashMap.size());
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        if (!paramConcurrentHashMap.hasNext()) {
          break label346;
        }
        MayKnowExposure localMayKnowExposure = (MayKnowExposure)((Map.Entry)paramConcurrentHashMap.next()).getValue();
        ((ByteBuffer)localObject).putLong(Long.parseLong(localMayKnowExposure.uin)).putInt(localMayKnowExposure.pageId).putInt(localMayKnowExposure.entranceId).putInt(localMayKnowExposure.actionId).putInt(localMayKnowExposure.exposeCnt).putInt(localMayKnowExposure.exposeTime);
        if ((localMayKnowExposure.acBuffer == null) || (localMayKnowExposure.acBuffer.length <= 0)) {
          break label337;
        }
        ((ByteBuffer)localObject).putShort((short)localMayKnowExposure.acBuffer.length).put(localMayKnowExposure.acBuffer);
        ((ByteBuffer)localObject).putShort((short)0);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramConcurrentHashMap) {}
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure", paramConcurrentHashMap);
      return;
      label337:
      ((ByteBuffer)localObject).putShort((short)0);
      continue;
      label346:
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      paramConcurrentHashMap = a("OidbSvc.0x6c9_0");
      paramConcurrentHashMap.putWupBuffer(localOIDBSSOPkg.toByteArray());
      paramConcurrentHashMap.setTimeout(30000L);
      b(paramConcurrentHashMap);
      return;
      label389:
      i1 += 2;
    }
  }
  
  public void a(short paramShort, List paramList, boolean paramBoolean)
  {
    if ((paramShort <= 0) || (paramList == null) || (paramShort != paramList.size())) {
      return;
    }
    for (;;)
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      try
      {
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1268);
        localOIDBSSOPkg.uint32_service_type.set(5);
        if (!paramBoolean) {
          break label289;
        }
        s1 = paramShort * 12 + 2;
        localObject = ByteBuffer.allocate(s1);
        ((ByteBuffer)localObject).putShort(paramShort);
        s1 = 0;
        if (s1 >= paramShort) {
          break label203;
        }
        ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong((String)paramList.get(s1))));
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putShort((short)2);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)1).putShort((short)4057).put((byte)0);
        }
        else
        {
          ((ByteBuffer)localObject).putShort((short)1);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)0);
        }
      }
      catch (Exception paramList) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendListHandler", 2, "gatherContacts  Exception " + paramList.getMessage());
      return;
      label203:
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      Object localObject = a("OidbSvc.0x4f4_5");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("isGather", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putStringArrayList("friendUinList", (ArrayList)paramList);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
      s1 += 1;
      continue;
      label289:
      short s1 = paramShort * 9 + 2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.CheckUpdateReq");
    localToServiceMsg.addAttribute("CheckUpdateType", Integer.valueOf(paramInt));
    localToServiceMsg.addAttribute("isFirstTime", Boolean.valueOf(paramBoolean));
    a(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c6.ReqBody();
    ((cmd0x7c6.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    int i1;
    if (paramInt == 1)
    {
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
      if (paramBoolean)
      {
        i1 = 1;
        paramString.set(i1);
        label48:
        paramString = new oidb_sso.OIDBSSOPkg();
        paramString.uint32_command.set(1990);
        paramString.uint32_result.set(0);
        paramString.uint32_service_type.set(0);
        paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c6.ReqBody)localObject).toByteArray()));
        localObject = a("OidbSvc.0x7c6_0");
        ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
        if (paramInt != 1) {
          break label290;
        }
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
      }
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).extraData.putBoolean("key_dongtai_permission", paramBoolean);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
      i1 = 0;
      break;
      if (paramInt == 2)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
        if (paramBoolean) {}
        for (i1 = 1;; i1 = 0)
        {
          paramString.set(i1);
          break;
        }
      }
      if (paramInt == 3)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
        if (paramBoolean)
        {
          i1 = 1;
          label216:
          paramString.set(i1);
          paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
          if (!paramBoolean) {
            break label250;
          }
        }
        label250:
        for (i1 = 1;; i1 = 0)
        {
          paramString.set(i1);
          break;
          i1 = 0;
          break label216;
        }
      }
      if (paramInt != 4) {
        break label48;
      }
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_recv_msg_box;
      if (paramBoolean == true) {}
      for (i1 = 1;; i1 = 0)
      {
        paramString.set(i1);
        break;
      }
      label290:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      } else if (paramInt == 4) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 4);
      }
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 888	java/lang/System:currentTimeMillis	()J
    //   5: lstore 4
    //   7: invokestatic 433	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +44 -> 54
    //   13: ldc_w 2153
    //   16: iconst_2
    //   17: new 462	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 463	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 2155
    //   27: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: lload 4
    //   32: invokevirtual 1155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: ldc_w 1471
    //   38: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: getfield 1777	com/tencent/mobileqq/app/FriendListHandler:g	J
    //   45: invokevirtual 1155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_0
    //   55: getfield 1777	com/tencent/mobileqq/app/FriendListHandler:g	J
    //   58: lconst_0
    //   59: lcmp
    //   60: ifle +24 -> 84
    //   63: aload_0
    //   64: getfield 1777	com/tencent/mobileqq/app/FriendListHandler:g	J
    //   67: lstore 6
    //   69: lload 4
    //   71: lload 6
    //   73: lsub
    //   74: ldc2_w 4572
    //   77: lcmp
    //   78: ifge +6 -> 84
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: aload_0
    //   85: lload 4
    //   87: putfield 1777	com/tencent/mobileqq/app/FriendListHandler:g	J
    //   90: new 386	java/util/ArrayList
    //   93: dup
    //   94: invokespecial 387	java/util/ArrayList:<init>	()V
    //   97: astore_3
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 811	com/tencent/mobileqq/app/FriendListHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: invokevirtual 813	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   106: iconst_0
    //   107: bipush 20
    //   109: iconst_0
    //   110: bipush 100
    //   112: lconst_0
    //   113: aload_3
    //   114: iload_1
    //   115: iload_2
    //   116: invokespecial 2340	com/tencent/mobileqq/app/FriendListHandler:a	(Ljava/lang/String;IIIIJLjava/util/ArrayList;ZZ)V
    //   119: goto -38 -> 81
    //   122: astore_3
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_3
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	FriendListHandler
    //   0	127	1	paramBoolean1	boolean
    //   0	127	2	paramBoolean2	boolean
    //   97	17	3	localArrayList	ArrayList
    //   122	4	3	localObject	Object
    //   5	81	4	l1	long
    //   67	5	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	54	122	finally
    //   54	69	122	finally
    //   84	119	122	finally
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 3);
    localToServiceMsg.extraData.putByteArray("group_id_list", paramArrayOfByte1);
    localToServiceMsg.extraData.putByteArray("sort_id_list", paramArrayOfByte2);
    a(localToServiceMsg);
  }
  
  public void a(long[] paramArrayOfLong, int[] paramArrayOfInt)
  {
    int i2 = 0;
    if ((paramArrayOfLong == null) || (paramArrayOfInt == null)) {
      return;
    }
    int i3 = paramArrayOfLong.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfInt.length * 2 + 4 + i3 * 4);
    localByteBuffer.putShort((short)paramArrayOfInt.length);
    int i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      localByteBuffer.putShort((short)paramArrayOfInt[i1]);
      i1 += 1;
    }
    localByteBuffer.putShort((short)i3);
    i1 = i2;
    while (i1 < i3)
    {
      localByteBuffer.putInt(Utils.a(paramArrayOfLong[i1]));
      i1 += 1;
    }
    paramArrayOfLong = new oidb_sso.OIDBSSOPkg();
    paramArrayOfLong.uint32_command.set(1276);
    paramArrayOfLong.uint32_service_type.set(30);
    paramArrayOfLong.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfInt = a("OidbSvc.0x4fc_30");
    paramArrayOfInt.putWupBuffer(paramArrayOfLong.toByteArray());
    paramArrayOfInt.setTimeout(10000L);
    b(paramArrayOfInt);
  }
  
  public void a(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 3, null, false);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(String[] paramArrayOfString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)1);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    int i1 = 0;
    if (i1 < paramArrayOfString.length)
    {
      int i2;
      label85:
      String[] arrayOfString;
      if (paramArrayOfString.length - i1 < 15)
      {
        i2 = paramArrayOfString.length - i1;
        arrayOfString = new String[i2];
        i2 = 0;
      }
      for (;;)
      {
        if ((i2 >= 15) || (i1 + i2 >= paramArrayOfString.length))
        {
          localToServiceMsg.extraData.putStringArray("uins", arrayOfString);
          a(localToServiceMsg);
          i1 += 15;
          break;
          i2 = 15;
          break label85;
        }
        arrayOfString[i2] = paramArrayOfString[(i1 + i2)];
        i2 += 1;
      }
    }
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    a(paramArrayOfString, 0, 2, null, paramBoolean);
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i2 = paramArrayOfString.length;
    long[] arrayOfLong = new long[i2];
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2) {
        try
        {
          arrayOfLong[i1] = Long.parseLong(paramArrayOfString[i1]);
          i1 += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            arrayOfLong[i1] = 0L;
          }
        }
      }
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      a(arrayOfLong, paramArrayOfInt);
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: start: " + paramInt1 + ", count: " + paramInt2 + ", uinList: " + paramArrayList + ", isSort: " + paramBoolean1 + ", reqNick: " + paramBoolean2);
    }
    if (((paramArrayList == null) || (paramArrayList.size() <= 0)) && ((paramInt1 < 0) || (paramInt2 <= 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: input invalid.");
      }
      return false;
    }
    paramArrayList = new oidb_0x7df.ReqBody();
    paramArrayList.uint32_seq.set(0);
    paramArrayList.uint32_start_index.set(paramInt1);
    paramArrayList.uint32_req_num.set(paramInt2);
    Object localObject = paramArrayList.uint32_sort;
    if (paramBoolean1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = paramArrayList.uint32_nick;
      paramInt1 = i1;
      if (paramBoolean2) {
        paramInt1 = 1;
      }
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2015);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(3);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayList.toByteArray()));
      paramArrayList = a("OidbSvc.0x7df_3");
      paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      b(paramArrayList);
      ca = 3;
      return true;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.getFriendGroupList");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.GetLastLoginInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.GetRichSig");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.GetSimpleInfo");
      this.jdField_b_of_type_JavaUtilSet.add("AvatarInfoSvr.QQHeadUrlReq");
      this.jdField_b_of_type_JavaUtilSet.add("IncreaseURLSvr.QQHeadUrlReq");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.GetDevLoginInfo");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.DelDevLoginInfo");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.SvcReqKikOut");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.BindUin");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.ReqGetSettings");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.ReqSetSettings");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.MovGroupMemReq");
      this.jdField_b_of_type_JavaUtilSet.add("BumpSvc.ReqComfirmContactFriend");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.addFriend");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.getUserAddFriendSetting");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.GetSimpleOnlineFriendInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.GetOnlineInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.delFriend");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.SetGroupReq");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.ChangeFriendName");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.SetRichSig");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.register");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.GetAutoInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.CheckUpdateReq");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.ReqSearch");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.ReqCondSearch");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5d1_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4fc_30");
      this.jdField_b_of_type_JavaUtilSet.add("DevLockAuthSvc.RecommendAuth");
      this.jdField_b_of_type_JavaUtilSet.add("DevLockAuthSvc.ConfirmAuth");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x476_146");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x476_147");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x490_107");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x491_107");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5e1_8");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x49d_107");
      this.jdField_b_of_type_JavaUtilSet.add("MultibusidURLSvr.HeadUrlReq");
      this.jdField_b_of_type_JavaUtilSet.add("MultibusidURLSvr.HeadUrlReq");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7c4_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4f4_5");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7c6_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7c7_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x847_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x53b_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x6c9_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7df_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5d6_7");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x77c");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriendToFriendList " + paramString1 + ", " + paramInt1 + ", " + paramInt2 + ", " + paramString2 + ", " + paramBoolean1);
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject = (PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).b();
    }
    paramBoolean2 = localFriendsManager.a(paramString1, paramInt1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler addFriendToFriendList flag = " + paramBoolean2);
    }
    if (paramBoolean2)
    {
      if (this.g == 0L) {
        a(1, true, Boolean.valueOf(true));
      }
      a(63, true, paramString1);
      localObject = (CircleManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      if (localObject != null) {
        ((CircleManager)localObject).a(paramString1);
      }
      a(paramString1);
      localFriendsManager.a(paramString1, false);
      ((QzoneContactsFeedManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(90)).a(Long.valueOf(paramString1).longValue());
      if ((!CrmUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) && (!CrmUtils.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)))
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label330;
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, paramLong, paramInt2, false, paramString2, paramBoolean1);
      }
    }
    for (;;)
    {
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), paramString2);
      return paramBoolean2;
      label330:
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, paramLong, paramInt2, false);
    }
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    short s1;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "getFriendNickByBatch|uinsize = " + paramArrayList.size() + " time=" + System.currentTimeMillis());
      }
      s1 = (short)paramArrayList.size();
    } while (s1 > 500);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1181);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(s1 * 4 + 7);
    ((ByteBuffer)localObject).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort(s1);
    short s2 = 0;
    for (;;)
    {
      if (s2 < s1) {
        try
        {
          ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong((String)paramArrayList.get(s2))));
          s2 = (short)(s2 + 1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "getFriendNickByBatch parseLong err uin=" + (String)paramArrayList.get(s2), localException);
            }
          }
        }
      }
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x49d_107");
    ((ToServiceMsg)localObject).extraData.putStringArrayList("batchuin", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putShort("uincount", s1);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(short paramShort, boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getMayKnowRecommend|expected = " + paramShort);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2119);
    localOIDBSSOPkg.uint32_service_type.set(3);
    Object localObject = ByteBuffer.allocate(12);
    ((ByteBuffer)localObject).put((byte)32).put((byte)1).putInt(0).putShort((short)0);
    ((ByteBuffer)localObject).putShort((short)0).putShort(paramShort);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x847_3");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).extraData.putBoolean("FromPush", paramBoolean);
    ((ToServiceMsg)localObject).extraData.putLong("PushTime", paramLong);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public void b()
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((!TextUtils.isEmpty(str)) && (e(str))) {
      b(str);
    }
  }
  
  public void b(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "RenameFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 1);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    a(localToServiceMsg);
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.group.vibrate");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 3);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 2L);
    a(localToServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("handleFriendAnniverInfo|req is ");
        if (paramToServiceMsg == null)
        {
          paramToServiceMsg = "null,";
          label51:
          localStringBuilder = localStringBuilder.append(paramToServiceMsg);
          if (paramFromServiceMsg != null) {
            break label361;
          }
          paramToServiceMsg = "resp is null";
          label67:
          paramFromServiceMsg = localStringBuilder.append(paramToServiceMsg).append(",data is ");
          if (paramObject != null) {
            break label388;
          }
          paramToServiceMsg = "null";
          label88:
          QLog.d("FriendListHandler", 2, paramToServiceMsg);
        }
      }
      else
      {
        if (i1 == 0) {
          break label458;
        }
      }
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramFromServiceMsg = new cmd0x77c.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l1 = 0L;
          paramToServiceMsg = new FriendAnniver();
          if (paramFromServiceMsg.uint64_friend_uin.has())
          {
            paramToServiceMsg.uin = Long.toString(paramFromServiceMsg.uint64_friend_uin.get());
            label205:
            if (!paramFromServiceMsg.uint32_add_year.has()) {
              break label401;
            }
            paramToServiceMsg.year = paramFromServiceMsg.uint32_add_year.get();
            label226:
            if (!paramFromServiceMsg.bytes_wording.has()) {
              break label407;
            }
            paramToServiceMsg.info = new String(paramFromServiceMsg.bytes_wording.get().toByteArray(), "UTF-8");
            label260:
            if (!paramFromServiceMsg.uint32_next_time_gap.has()) {
              break label413;
            }
            l1 = paramFromServiceMsg.uint32_next_time_gap.get() * 1000L;
            label284:
            if (!paramFromServiceMsg.bytes_url.has()) {
              break label419;
            }
            paramToServiceMsg.url = new String(paramFromServiceMsg.bytes_url.get().toByteArray());
          }
          for (;;)
          {
            if (i1 != 0)
            {
              ((FriendAnniverManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(177)).a(paramToServiceMsg, l1);
              a(109, true, paramToServiceMsg);
            }
            return;
            i1 = 0;
            break;
            paramToServiceMsg = "not null,";
            break label51;
            label361:
            paramToServiceMsg = "resp.isSuccess : " + paramFromServiceMsg.isSuccess();
            break label67;
            label388:
            paramToServiceMsg = "not null";
            break label88;
            i1 = 0;
            break label205;
            label401:
            i1 = 0;
            break label226;
            label407:
            i1 = 0;
            break label260;
            label413:
            i1 = 0;
            break label284;
            label419:
            i1 = 0;
          }
        }
        a(109, false, null);
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleFriendAnniverInfo: " + paramToServiceMsg);
        }
      }
    }
    label458:
  }
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void b(String paramString, byte paramByte)
  {
    a(11, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void b(String paramString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)0);
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "getQCallHead QQHEAD_TYPE_QCALL uin = " + paramString + " idType = " + paramInt + ", level = " + " faceFileType = " + paramByte2);
    }
    a(16, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public void b(String paramString, ArrayList paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramBoolean) {
      try
      {
        this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
        return;
      }
      finally {}
    }
    ArrayList localArrayList;
    Object localObject2;
    if (this.jdField_b_of_type_JavaUtilHashtable.size() > 30)
    {
      long l1 = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.jdField_b_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l1 - ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(str)).longValue()) > 60000L) {
          localArrayList.add(str);
        }
      }
    }
    for (;;)
    {
      int i1;
      if (i1 < localArrayList.size())
      {
        localObject2 = (String)localArrayList.get(i1);
        this.jdField_b_of_type_JavaUtilHashtable.remove(localObject2);
        a(9205, (String)localObject2, -1, 4);
        i1 += 1;
      }
      else
      {
        this.jdField_b_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(System.currentTimeMillis()));
        break;
        i1 = 0;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void b(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 0, null, false);
  }
  
  public boolean b()
  {
    long l1 = System.currentTimeMillis() - this.i;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getOnlineFriend  | intervalTime = " + l1 + " | sGetOnlineFriendDelay = " + QQAppInterface.eq);
    }
    return (this.i > 0L) && ((l1 < QQAppInterface.eq) || (l1 > QQAppInterface.ep - QQAppInterface.eq));
  }
  
  public boolean b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2;
    synchronized (this.jdField_d_of_type_JavaUtilHashtable)
    {
      if (!this.jdField_d_of_type_JavaUtilHashtable.containsKey(paramString)) {
        break label180;
      }
      paramString = (pxy)this.jdField_d_of_type_JavaUtilHashtable.get(paramString);
      l2 = Math.abs(l1 - paramString.jdField_a_of_type_Long);
      if (paramString.c > 0L)
      {
        if (l1 < paramString.c) {
          return false;
        }
        paramString.c = 0L;
        paramString.jdField_a_of_type_Long = l1;
        paramString.jdField_b_of_type_Long = 1L;
        return true;
      }
    }
    if (l2 < 5000L) {
      return false;
    }
    paramString.jdField_b_of_type_Long += 1L;
    if (l2 > 60000L)
    {
      if ((paramString.jdField_b_of_type_Long < 8L) || (l2 >= 120000L)) {
        break label161;
      }
      paramString.c = (l1 + 1800000L);
    }
    for (;;)
    {
      return true;
      label161:
      paramString.c = 0L;
      paramString.jdField_a_of_type_Long = l1;
      paramString.jdField_b_of_type_Long = 1L;
    }
    label180:
    Object localObject1;
    Object localObject2;
    if (this.jdField_d_of_type_JavaUtilHashtable.size() > 20)
    {
      localObject1 = new ArrayList();
      localObject2 = this.jdField_d_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        pxy localpxy = (pxy)this.jdField_d_of_type_JavaUtilHashtable.get(str);
        if (((localpxy.c == 0L) && (l1 - localpxy.jdField_a_of_type_Long > 60000L)) || ((localpxy.c > 0L) && (l1 > localpxy.c))) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    for (;;)
    {
      int i1;
      if (i1 < ((ArrayList)localObject1).size())
      {
        localObject2 = (String)((ArrayList)localObject1).get(i1);
        this.jdField_d_of_type_JavaUtilHashtable.remove(localObject2);
        i1 += 1;
      }
      else
      {
        localObject1 = new pxy();
        ((pxy)localObject1).jdField_a_of_type_Long = l1;
        ((pxy)localObject1).jdField_b_of_type_Long = 1L;
        this.jdField_d_of_type_JavaUtilHashtable.put(paramString, localObject1);
        break;
        i1 = 0;
      }
    }
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.b();
    }
  }
  
  public void c()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.what = 0;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void c(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.ring.switch");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 4);
  }
  
  public void c(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 4L);
    a(localToServiceMsg);
  }
  
  public void c(String paramString)
  {
    a(1, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void c(String paramString, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.delFriend");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("del_type", paramByte);
    a(localToServiceMsg);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetOnlineInfoReq");
    if (paramBoolean)
    {
      localToServiceMsg.extraData.putLong("dwReqType", 1L);
      localToServiceMsg.extraData.putString("strMobile", paramString);
    }
    for (;;)
    {
      localToServiceMsg.setTimeout(15000L);
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putLong("dwReqType", 0L);
      localToServiceMsg.extraData.putLong("dwUin", CharacterUtil.a(paramString));
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void c(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      i2 = paramArrayOfString.length;
      i1 = 0;
      if (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          i1 += 1;
          break;
          if ((Friends.isValidUin(str)) && (b(str))) {
            localArrayList.add(str);
          }
        }
      }
    } while (localArrayList.size() < 1);
    paramArrayOfString = new String[localArrayList.size()];
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      paramArrayOfString[i1] = ((String)localArrayList.get(i1));
      i1 += 1;
    }
    b(paramArrayOfString);
    paramArrayOfString = a("ProfileService.GetSimpleInfo");
    paramArrayOfString.extraData.putStringArrayList("uinList", localArrayList);
    paramArrayOfString.extraData.putBoolean("batch_data", true);
    a(paramArrayOfString);
  }
  
  public boolean c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.n;
    if ((l2 < this.m) && (l2 > -this.m)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.n = l1;
      }
      return bool;
    }
  }
  
  public boolean c(String paramString)
  {
    boolean bool1 = paramString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    boolean bool2 = bool1;
    long l1;
    if (bool1)
    {
      l1 = ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (Math.abs(System.currentTimeMillis() - l1) <= 86400000L) {
        break label116;
      }
    }
    label116:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, "$shouldReqLevel | lastReqTime = " + l1 + " | currentTime = " + System.currentTimeMillis());
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public void d()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void d(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.vibrate.switch");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 5);
  }
  
  public void d(String paramString)
  {
    a(4, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void d(String paramString, byte paramByte)
  {
    if ((paramByte != 0) && (b())) {}
    do
    {
      return;
      this.i = System.currentTimeMillis();
      paramString = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetSimpleOnlineFriendInfoReq");
      paramString.extraData.putLong("startTime", System.currentTimeMillis());
      paramString.setTimeout(120000L);
      paramString.extraData.putByte("ifShowTermType", (byte)1);
      paramString.extraData.putByte("srcType", paramByte);
      a(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("getOnlineFriend", 2, "send getOnlineFriend");
  }
  
  public void d(boolean paramBoolean)
  {
    int i1 = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i1 = 0;
    }
    ((ByteBuffer)localObject).put((byte)i1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x491_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_show_to_friends", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public boolean d()
  {
    if (this.cg == -1) {}
    for (;;)
    {
      try
      {
        if (!ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
          continue;
        }
        i1 = 1;
        this.cg = i1;
      }
      catch (Exception localException)
      {
        int i1;
        this.cg = 0;
        continue;
      }
      if (this.cg != 1) {
        break;
      }
      return true;
      i1 = 0;
    }
    return false;
  }
  
  public boolean d(String paramString)
  {
    for (;;)
    {
      boolean bool1;
      boolean bool3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramString)) {
          break label219;
        }
        long l1 = ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l1) > 60000L)
        {
          this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
          a(9205, paramString, -1, 4);
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool3 = SystemUtil.a();
            if (((bool3) && (SystemUtil.a() < 2048L)) || ((!bool3) && (SystemUtil.b() < 102400L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.flh", 2, "getQQHead|fail, storage is not enough. uinOrMobile=" + paramString + ", isExistSDCard=" + bool3);
              }
              bool2 = false;
            }
          }
          else
          {
            return bool2;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      boolean bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), true);
          return bool1;
          label219:
          bool1 = true;
        }
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getFriendAnniverInfo excuted");
    }
    Object localObject = new cmd0x77c.ReqBody();
    ((cmd0x77c.ReqBody)localObject).uint64_uin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1916);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x77c.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x77c");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void e(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("sync.c2c_message");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 6);
  }
  
  public void e(String paramString)
  {
    a(11, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void e(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if ((this.o > 0L) && (l1 - this.o < 3600000L))
    {
      a(80, true, Boolean.valueOf(true));
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "FriendListHandler getRecommGatheredContactsList. smaller than 1 hour.");
      }
      return;
    }
    this.o = l1;
    a(0, paramBoolean);
  }
  
  public boolean e()
  {
    String str;
    if (this.cf == -1)
    {
      str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.app, "StatusEntry");
      if ((str == null) || (str.length() <= 0)) {}
    }
    try
    {
      this.cf = Integer.parseInt(str);
      if (this.cf == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.mate", 2, "isStatusEntryVisible " + this.cf + ", " + localException.toString());
        }
      }
    }
    return false;
  }
  
  public void f(int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x7c4_0");
    localToServiceMsg.extraData.putInt("startIndex", paramInt);
    localToServiceMsg.extraData.putBoolean("isGetRecomm", false);
    cmd0x7c4.ReqBody localReqBody = new cmd0x7c4.ReqBody();
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    cmd0x7c4.GetSNFrdListReq localGetSNFrdListReq = new cmd0x7c4.GetSNFrdListReq();
    localGetSNFrdListReq.uint64_uin.set(Long.parseLong((String)localObject));
    int i1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
    localGetSNFrdListReq.uint32_sequence.set(i1);
    localGetSNFrdListReq.uint32_start_idx.set(paramInt);
    localGetSNFrdListReq.uint32_req_num.set(ck);
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "FriendListHandler getGatheredContactsList(). startIndex = " + paramInt + " | seq = " + i1);
    }
    localReqBody.msg_get_sn_frd_list_req.set(localGetSNFrdListReq);
    localReqBody.uint32_client_ver.set(2);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1988);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    b(localToServiceMsg);
  }
  
  public void f(String paramString)
  {
    new pxx(this, "saveSelfSig", paramString).start();
    ToServiceMsg localToServiceMsg = a("ProfileService.SetRichSig");
    localToServiceMsg.extraData.putString("sig_value", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a(localToServiceMsg);
  }
  
  public boolean f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return false;
    }
    boolean bool = ContactConfig.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (bool) {
      a(0L, 0L, 0L);
    }
    return bool;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a();
    }
    super.g();
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "cancelMayKnowRecommend|uin = " + paramString);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1339);
      localOIDBSSOPkg.uint32_service_type.set(0);
      long l1 = Long.parseLong(paramString);
      Object localObject = ByteBuffer.allocate(6);
      ((ByteBuffer)localObject).put((byte)7).putInt(Utils.a(l1)).put((byte)0);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = a("OidbSvc.0x53b_0");
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "cancelMayKnowRecommend", paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FriendListHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */