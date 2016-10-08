package com.tencent.mobileqq.utils;

import QQWalletPay.ReqCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.biz.TenpayActivity;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.huangye.util.QQYPDirectOpenApi;
import com.tencent.biz.huangye.util.QQYPQRCodeUtil;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.VidUrl;
import com.tencent.biz.pubaccount.util.ProfileParams.Builder;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.msg.activities.DeviceQRAgentActivity;
import com.tencent.device.msg.activities.DeviceShareAgentActivity;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.FreshNewsEditActivity;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.intervideo.now.NowProxy.ListNameData;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.rn.BaseBusi;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateEnterActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vashealth.StepCounterServlert;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.ToastUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import cooperation.comic.VipComicJumpActivity;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import wao;
import wap;
import waq;
import was;
import wat;
import wau;
import wav;
import waw;
import wax;
import way;
import waz;
import wba;
import wbb;

public class JumpAction
{
  public static final String A = "qqreader";
  public static final String B = "healthcenter";
  public static final String C = "usersummary";
  public static final String D = "tribe";
  public static final String E = "qlink";
  public static final String F = "qqconnect";
  public static final String G = "publicdevice";
  public static final String H = "openLightApp";
  public static final String I = "crmivr";
  public static final String J = "qqwifi";
  public static final String K = "massbless";
  public static final String L = "asyncmsg";
  public static final String M = "schedule";
  public static final String N = "pa_relationship";
  public static final String O = "qstory";
  public static final String P = "now";
  public static final String Q = "audiochat";
  public static final String R = "imchat";
  public static final String S = "web";
  public static final String T = "url";
  public static final String U = "bid";
  public static final String V = "sourceUrl";
  public static final String W = "wpa";
  public static final String X = "openid_to_uin";
  public static final String Y = "puzzle_verify_code";
  public static final String Z = "PUZZLEVERIFYCODE";
  public static final int a = 3;
  public static final String a = "im";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq" };
  public static final String aA = "list";
  public static final String aB = "freshnews_entry";
  public static final String aC = "feed";
  public static final String aD = "detail";
  public static final String aE = "topic";
  public static final String aF = "public";
  public static final String aG = "publish";
  public static final String aH = "editsummary";
  public static final String aI = "leba_plugin";
  public static final String aJ = "set";
  public static final String aK = "bind_group";
  public static final String aL = "show_nearby_fri";
  public static final String aM = "show_location";
  public static final String aN = "select_location";
  public static final String aO = "open";
  public static final String aP = "modify_pass";
  public static final String aQ = "to_publish_queue";
  public static final String aR = "to_friend_feeds";
  public static final String aS = "qzone_schema";
  public static final String aT = "show_pslcard";
  public static final String aU = "show_groupcard";
  public static final String aV = "photo";
  public static final String aW = "url";
  public static final String aX = "to_fri";
  public static final String aY = "to_qqfav";
  public static final String aZ = "to_qzone";
  public static final String aa = "VERIFYCODE";
  public static final String ab = "DEVLOCK_CODE";
  public static final String ac = "devlock";
  public static final String ad = "open";
  public static final String ae = "chat";
  public static final String af = "pay";
  public static final String ag = "openqqdataline";
  public static final String ah = "dating";
  public static final String ai = "dating_id";
  public static final String aj = "detail";
  public static final String ak = "publish";
  public static final String al = "feed";
  public static final String am = "nearby_entry";
  public static final String an = "nearby_feed";
  public static final String ao = "nearby_profile";
  public static final String ap = "hotchat_list";
  public static final String aq = "hotchat_room";
  public static final String ar = "vip_map_roam";
  public static final String as = "visitor_list";
  public static final String at = "find_school_mate_guide";
  public static final String au = "rn_busi";
  public static final String av = "hotchat";
  public static final String aw = "newyear_scene";
  public static final String ax = "interesttag";
  public static final String ay = "interesttag_selector";
  public static final String az = "rankinglist";
  public static int b = 0;
  public static final String b = "lbs";
  public static final String bA = "request";
  public static final String bB = "to_qqdataline";
  public static final String bC = "openqlink";
  public static final String bD = "outweb_start";
  public static final String bE = "open_async_detail";
  public static final String bF = "showDetail";
  public static final String bG = "mainpage";
  public static final String bH = "open";
  public static final String bI = "openVideo";
  public static final String bJ = "opentopic";
  public static final String bK = "opencontent";
  public static final String bL = "opendiscovery";
  public static final String bM = "openNow";
  public static final String bN = "version";
  public static final String bO = "channel_id";
  public static final String bP = "src_type";
  public static final String bQ = "callback_type";
  public static final String bR = "callback_name";
  public static final String bS = "app_info";
  public static final String bT = "viewtype";
  public static final String bU = "view";
  public static final String bV = "entry";
  public static final String bW = "plugin_start_time";
  public static final String bX = "click_start_time";
  public static final String bY = "is_from_leba";
  public static final String bZ = "has_red_dot";
  public static final String ba = "publish";
  public static final String bb = "to_troopbar";
  public static final String bc = "add_friend";
  public static final String bd = "writemood";
  public static final String be = "open_homepage";
  public static final String bf = "qr";
  public static final String bg = "ft";
  public static final String bh = "nearby";
  public static final String bi = "create";
  public static final String bj = "emoji";
  public static final String bk = "groupvideo";
  public static final String bl = "openOrg";
  public static final String bm = "emoji_detail";
  public static final String bn = "emoji_author";
  public static final String bo = "bubble";
  public static final String bp = "theme";
  public static final String bq = "font";
  public static final String br = "pendant";
  public static final String bs = "individuation";
  public static final String bt = "apollo_store";
  public static final String bu = "open";
  public static final String bv = "qlogin";
  public static final String bw = "groupalbum";
  public static final String bx = "request";
  public static final String by = "request";
  public static final String bz = "request";
  private static final int jdField_c_of_type_Int = 0;
  public static final String c = "card";
  public static final String cA = "contentType";
  public static final String cB = "sharefromtype";
  public static final String cC = "chat_type";
  public static final String cD = "uin";
  public static final String cE = "attach_content";
  public static final String cF = "group_info";
  public static final String cG = "discuss_info";
  public static final String cH = "open_type";
  public static final String cI = "account_flag";
  public static final String cJ = "panel";
  public static final String cK = "sigt";
  public static final String cL = "sig";
  public static final String cM = "kfnick";
  public static final String cN = "wpaType";
  public static final String cO = "assignId";
  public static final String cP = "QidianSigT";
  public static final String cQ = "QidianKfUin";
  public static final String cR = "params";
  public static final String cS = "url";
  public static final String cT = "picture";
  public static final String cU = "title";
  public static final String cV = "summary";
  public static final String cW = "gid";
  public static final String cX = "brief";
  public static final String cY = "source";
  public static final String cZ = "puin";
  public static final String ca = "openroom";
  public static final String cb = "roomid";
  public static final String cc = "fromid";
  public static final String cd = "coverurl";
  public static final String ce = "extras";
  public static final String cf = "first";
  public static final String cg = "bid";
  public static final String ch = "topic";
  public static final String ci = "story_ext";
  public static final String cj = "list_name";
  public static final String ck = "videoId";
  public static final String cl = "videoOwnerUin";
  public static final String cm = "fromId";
  public static final String cn = "topicid";
  public static final String co = "topicname";
  public static final String cp = "topiccover";
  public static final String cq = "topiclogo";
  public static final String cr = "topiccolor";
  public static final String cs = "from";
  public static final String ct = "qrcode";
  public static final String cu = "userid";
  public static final String cv = "usertype";
  public static final String cw = "unionid";
  public static final String cx = "storyid";
  public static final String cy = "storysharefrom";
  public static final String cz = "showinfocard";
  private static final int jdField_d_of_type_Int = 1;
  public static final String d = "upload";
  public static final String dA = "description";
  public static final String dB = "previewimagedata";
  public static final String dC = "url";
  public static final String dD = "share_id";
  public static final String dE = "image_url";
  public static final String dF = "app_name";
  public static final String dG = "open_id";
  public static final String dH = "share_uin";
  public static final String dI = "jfrom";
  public static final String dJ = "audioUrl";
  public static final String dK = "req_type";
  public static final String dL = "game_union_id";
  public static final String dM = "game_zone_id";
  public static final String dN = "signature";
  public static final String dO = "share_qq_ext_str";
  public static final String dP = "back_title";
  public static final String dQ = "card_type";
  public static final String dR = "public_account";
  public static final String dS = "crm";
  public static final String dT = "wSourceSubID";
  public static final String dU = "qd_account";
  public static final String dV = "troopmember";
  public static final String dW = "troopuin";
  public static final String dX = "troopcode";
  public static final String dY = "nick";
  public static final String dZ = "sex";
  public static final String da = "price";
  public static final String db = "prunit";
  public static final String dc = "layout";
  public static final String dd = "icon";
  public static final String de = "srcaction";
  public static final String df = "a_actionData";
  public static final String dg = "i_actionData";
  public static final String dh = "action";
  public static final String di = "appid";
  public static final String dj = "thirdAppDisplayName";
  public static final String dk = "paramencrypted_type";
  public static final String dl = "lon";
  public static final String dm = "lat";
  public static final String dn = "title";
  public static final String jdField_do = "summary";
  public static final String dp = "bus_type";
  public static final String dq = "url_prefix";
  public static final String dr = "style";
  public static final String ds = "plg_auth";
  public static final String dt = "plg_nld";
  public static final String du = "plg_dev";
  public static final String dv = "plg_usr";
  public static final String dw = "plg_vkey";
  public static final String dx = "file_type";
  public static final String dy = "file_data";
  public static final String dz = "title";
  public static final String e = "forward";
  public static final String eA = "fromH5";
  public static final String eB = "od";
  public static final String eC = "openroom";
  public static final String eD = "roomid";
  public static final String eE = "fromid";
  public static final String eF = "vasname";
  public static final String eG = "userdata";
  public static final String eH = "odAddFriend";
  public static final String eI = "addFriend";
  public static final String eJ = "aioorprofile";
  public static final String eK = "qqcomic";
  public static final String eL = "jump";
  public static final String eM = "req_type";
  public static final String eN = "videoPath";
  public static final String eO = "description";
  public static final String eP = "videoDuration";
  public static final String eQ = "videoSize";
  public static final String eR = "qqc2b";
  public static final String eS = "callc2bphone";
  public static final String eT = "callc2bphonedirect";
  public static final String eU = "readinjoy";
  public static final String eV = "open";
  public static final String eW = "channelid";
  public static final String eX = "channelname";
  public static final String eY = "type";
  public static final String eZ = "from";
  public static final String ea = "troopnick";
  public static final String eb = "job";
  public static final String ec = "tel";
  public static final String ed = "email";
  public static final String ee = "openid";
  public static final String ef = "appid";
  public static final String eg = "source";
  public static final String eh = "authKey";
  public static final String ei = "wpa";
  public static final String ej = "url_app_info";
  public static final String ek = "hb_id";
  public static final String el = "send_uin";
  public static final String em = "hb_type";
  public static final String en = "hb_summary";
  public static final String eo = "k_requestcode";
  public static final String ep = "fromSencondhandCommunity";
  public static final String eq = "from3rdApp";
  public static final String er = "showFirstStructMsg";
  public static final String es = "pakage_from_h5";
  public static final String et = "creategroup";
  public static final String eu = "initgrouptype";
  public static final String ev = "DEFAULT";
  public static final String ew = "0";
  public static final String ex = "1";
  public static final String ey = "2";
  public static final String ez = "troopType";
  public static final String f = "share";
  public static final String fA = "wpaCount";
  public static final String fB = "webview";
  public static final String fC = "from_leba";
  public static final String fD = "from_leba_mgr";
  public static final String fE = "from_nearby_pb";
  public static final String fF = "config_res_plugin_item_name";
  public static final String fG = "source_scheme";
  public static final String fH = "redtouch_click_timestamp";
  public static final String fI = "http://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true";
  private static final String fJ = "cflag";
  private static final String fK = "open_id";
  private static final String fL = "fopen_id";
  private static final String fM = "app_id";
  private static final String fN = "friend_label";
  private static final String fO = "add_msg";
  private static final String fP = "app_name";
  private static final String fQ = "troopbar_id";
  private static final String fR = "troopbar_name";
  private static final String fS = "packageName";
  private static final String fT = "signareMode";
  private static final String fU = "appid";
  private static final String fV = "timeStamp";
  private static final String fW = "resetWordMode";
  private static final String fX = "offerid";
  private static final String fY = "uin";
  private static final String fZ = "txt";
  public static final String fa = "target";
  public static final String fb = "qzone";
  public static final String fc = "1";
  public static final String fd = "2";
  public static final String fe = "1";
  public static final String ff = "articleid";
  public static final String fg = "report";
  public static final String fh = "reportrealtime";
  public static final String fi = "apenalbum";
  public static final String fj = "multivideo";
  public static final String fk = "cmshow";
  public static final String fl = "apollo_action";
  public static final String fm = "openid";
  public static final String fn = "nickname";
  public static final String fo = "favorites";
  public static final String fp = "forward_favorites";
  public static final String fq = "assistant_setting";
  public static final String fr = "ASSISTANT_SETTING";
  public static final String g = "qzone";
  private static final String ga = "friendUin";
  private static final String gb = "addMsg";
  private static final String gc = "hongbao_share";
  private static final String gd = "hongbao_brush";
  private static final String ge = "olympic_entry";
  private static final String gf = "actpage";
  private static final String gi = "4eY#X@~g.+U)2%$<";
  private static final String gj = "Hf7K(s*js12LiskW";
  private static final String gm = "JumpAction";
  private static final String gn = "cooperation.qqreader.QRBridgeActivity";
  public static final String h = "mqq";
  public static final String i = "app";
  public static final String j = "qm";
  public static final String k = "gamesdk";
  public static final String l = "qqdataline";
  public static final String m = "qapp";
  public static final String n = "wallet";
  public static final String o = "gav";
  public static final String p = "videochat";
  public static final String q = "randomavchat";
  public static final String r = "guildavchat";
  public static final String s = "conference";
  public static final String t = "tenpay";
  public static final String u = "sendHongBao";
  public static final String v = "dc";
  public static final String w = "group";
  public static final String x = "shop";
  public static final String y = "ptlogin";
  public static final String z = "readingcenter";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public final Context a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ChatActivityUtils.StartVideoListener a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QWalletAuthObserver jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public QidianBusinessObserver a;
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new waq(this);
  private wba jdField_a_of_type_Wba = new wba(this, this);
  private wbb jdField_a_of_type_Wbb;
  public boolean a;
  private boolean b;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  public String fs;
  public String ft;
  public String fu;
  public String fv;
  public String fw;
  public String fx;
  public String fy;
  public String fz;
  private String gg;
  private String gh;
  private String gk;
  private String gl;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = 1;
  }
  
  public JumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new wav(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new waz(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean C()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.a);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("from", (String)this.jdField_a_of_type_JavaUtilHashMap.get("from"));
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800633E", "0X800633E", 0, 0, "", "", "", "");
    return true;
  }
  
  private boolean D()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("interest_type")) {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = null");
      }
    }
    do
    {
      for (;;)
      {
        return false;
        Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("interest_type");
        String str;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from"))
        {
          str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = " + (String)localObject);
          }
        }
        try
        {
          i1 = Integer.valueOf((String)localObject).intValue();
          if ("interesttag_selector".equals(this.fu))
          {
            try
            {
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ChooseInterestTagActivity.class);
              ((Intent)localObject).putExtra("is_from_judge", true);
              ((Intent)localObject).putExtra("interest_tag_type", i1);
              ((Intent)localObject).putExtra("from_where", "web_to_choose_tag");
              if ("10002".equals(str)) {
                ((Intent)localObject).addFlags(268435456);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return true;
            }
            catch (Exception localException1) {}
            str = "";
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i1 = 0;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpAction", 2, "", localException1);
    return false;
  }
  
  private boolean E()
  {
    int i6 = 0;
    if (QLog.isColorLevel()) {
      NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
    localIntent.putExtra("TAB", 0);
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    }
    for (;;)
    {
      String str3;
      label108:
      String str4;
      label135:
      String str5;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("web_url"))
      {
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("web_url");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
          break label720;
        }
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
          break label727;
        }
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
        label163:
        localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
        localIntent.putExtra("fromWhere", str1);
        localIntent.putExtra("webUrl", str3);
        localIntent.putExtra("fromType", str5);
        localIntent.putExtra("FROM_WHERE", 1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("neighbor_list_source")) {}
      }
      try
      {
        i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("neighbor_list_source"));
        localIntent.putExtra("neighbor_list_source", i1);
        if ("10002".equals(str4))
        {
          localIntent.putExtra("abp_flag", true);
          localIntent.addFlags(268435456);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter"))
        {
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter");
          if ("1".equals(str1))
          {
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
              break label753;
            }
            str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
              break label760;
            }
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
              break label767;
            }
            str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
              break label775;
            }
            str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_interest")) {
              break label783;
            }
            str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_interest");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
              break label791;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
              break label799;
            }
            str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");
          }
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i1 = Integer.valueOf(str3).intValue();
        }
        catch (Exception localException5)
        {
          try
          {
            i2 = Integer.valueOf(str4).intValue();
          }
          catch (Exception localException5)
          {
            try
            {
              i3 = Integer.valueOf(str5).intValue();
            }
            catch (Exception localException5)
            {
              try
              {
                i4 = Integer.valueOf(str6).intValue();
              }
              catch (Exception localException5)
              {
                try
                {
                  for (;;)
                  {
                    i5 = Integer.valueOf(str8).intValue();
                    try
                    {
                      int i7 = Integer.valueOf(str7).intValue();
                      i6 = i7;
                    }
                    catch (Exception localException7)
                    {
                      String str2;
                      for (;;) {}
                    }
                    localIntent.putExtra("filter", str1);
                    localIntent.putExtra("filterGender", i1);
                    localIntent.putExtra("filter_time", i2);
                    localIntent.putExtra("filter_age", i3);
                    localIntent.putExtra("filter_xingzuo", i4);
                    localIntent.putExtra("filter_interest", i6);
                    localIntent.putExtra("filter_career", i5);
                    localIntent.putExtra("filter_location", str9);
                    localIntent.addFlags(67108864);
                    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                      localIntent.addFlags(268435456);
                    }
                    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
                    return true;
                    str1 = "";
                    break;
                    str3 = "";
                    break label108;
                    label720:
                    str4 = "";
                    break label135;
                    label727:
                    str5 = "";
                    break label163;
                    localException1 = localException1;
                    localException1.printStackTrace();
                    int i1 = 0;
                    continue;
                    str2 = "";
                    continue;
                    label753:
                    str3 = "";
                    continue;
                    label760:
                    str4 = "";
                    continue;
                    label767:
                    str5 = "";
                    continue;
                    label775:
                    String str6 = "";
                    continue;
                    label783:
                    String str7 = "";
                    continue;
                    label791:
                    String str8 = "";
                    continue;
                    label799:
                    String str9 = "";
                    continue;
                    localException2 = localException2;
                    i1 = 0;
                    continue;
                    localException3 = localException3;
                    int i2 = 3;
                    continue;
                    localException4 = localException4;
                    int i3 = 0;
                    continue;
                    localException5 = localException5;
                    int i4 = 0;
                  }
                }
                catch (Exception localException6)
                {
                  for (;;)
                  {
                    int i5 = 0;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean F()
  {
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, false);
    return true;
  }
  
  private boolean G()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hotnamecode")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hotnamecode"); TextUtils.isEmpty(str); str = "")
    {
      QQToast.a(BaseApplicationImpl.getContext(), "该热聊不存在，换个热聊试试吧。", 1).a();
      return false;
    }
    NearbyTransitActivity.a(this.jdField_a_of_type_AndroidContentContext, str, 1, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  /* Error */
  private boolean H()
  {
    // Byte code:
    //   0: invokestatic 1178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +19 -> 22
    //   6: ldc_w 973
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 1342
    //   18: aastore
    //   19: invokestatic 1254	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   26: ldc_w 1344
    //   29: invokevirtual 1173	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +225 -> 257
    //   35: aload_0
    //   36: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   39: ldc_w 1344
    //   42: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 1067	java/lang/String
    //   48: invokestatic 1350	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   51: istore 4
    //   53: aload_0
    //   54: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   57: ldc_w 514
    //   60: invokevirtual 1173	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   63: ifeq +189 -> 252
    //   66: aload_0
    //   67: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   70: ldc_w 514
    //   73: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: checkcast 1067	java/lang/String
    //   79: invokestatic 1281	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   82: istore_3
    //   83: new 1117	android/content/Intent
    //   86: dup
    //   87: aload_0
    //   88: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   91: ldc_w 1120
    //   94: invokespecial 1216	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   97: astore_1
    //   98: aload_1
    //   99: ldc_w 1141
    //   102: iconst_1
    //   103: invokevirtual 1139	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   106: pop
    //   107: aload_1
    //   108: ldc_w 1131
    //   111: getstatic 1135	com/tencent/mobileqq/activity/MainFragment:a	I
    //   114: invokevirtual 1139	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   117: pop
    //   118: aload_1
    //   119: ldc_w 1125
    //   122: invokevirtual 1129	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   125: pop
    //   126: aload_0
    //   127: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   130: ldc_w 514
    //   133: invokevirtual 1173	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   136: ifeq +12 -> 148
    //   139: aload_1
    //   140: ldc_w 514
    //   143: iload_3
    //   144: invokevirtual 1139	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   147: pop
    //   148: aload_0
    //   149: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   152: ldc_w 1344
    //   155: invokevirtual 1173	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   158: ifeq +13 -> 171
    //   161: aload_1
    //   162: ldc_w 1344
    //   165: iload 4
    //   167: invokevirtual 1221	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   170: pop
    //   171: aload_0
    //   172: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   175: instanceof 1120
    //   178: ifeq +40 -> 218
    //   181: aload_0
    //   182: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   185: checkcast 1120	com/tencent/mobileqq/activity/SplashActivity
    //   188: astore_2
    //   189: aload_1
    //   190: ldc_w 1352
    //   193: iconst_1
    //   194: invokevirtual 1221	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   197: pop
    //   198: aload_2
    //   199: aload_1
    //   200: invokevirtual 1354	com/tencent/mobileqq/activity/SplashActivity:b	(Landroid/content/Intent;)V
    //   203: iconst_1
    //   204: ireturn
    //   205: astore_1
    //   206: iconst_0
    //   207: istore 4
    //   209: aload_1
    //   210: invokevirtual 1306	java/lang/Exception:printStackTrace	()V
    //   213: iconst_0
    //   214: istore_3
    //   215: goto -132 -> 83
    //   218: aload_0
    //   219: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   222: aload_1
    //   223: invokevirtual 1154	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   226: aload_0
    //   227: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   230: instanceof 1303
    //   233: ifeq -30 -> 203
    //   236: aload_0
    //   237: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   240: checkcast 1303	android/app/Activity
    //   243: invokevirtual 1357	android/app/Activity:finish	()V
    //   246: iconst_1
    //   247: ireturn
    //   248: astore_1
    //   249: goto -40 -> 209
    //   252: iconst_0
    //   253: istore_3
    //   254: goto -171 -> 83
    //   257: iconst_0
    //   258: istore 4
    //   260: goto -207 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	JumpAction
    //   97	103	1	localIntent	Intent
    //   205	18	1	localException1	Exception
    //   248	1	1	localException2	Exception
    //   188	11	2	localSplashActivity	SplashActivity
    //   82	172	3	i1	int
    //   51	208	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   22	53	205	java/lang/Exception
    //   53	83	248	java/lang/Exception
  }
  
  private boolean I()
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    }
    for (;;)
    {
      String str3;
      label54:
      label81:
      Intent localIntent;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type"))
      {
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("version")) {
          break label554;
        }
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
          break label557;
        }
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, VipMapRoamActivity.class);
        if ("web".equals(str1)) {
          localIntent.putExtra("is_from_web", true);
        }
        if ("10002".equals(str3))
        {
          localIntent.putExtra("abp_flag", true);
          localIntent.addFlags(268435456);
        }
        if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("lat")) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("lon"))) {}
      }
      try
      {
        int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("lat"));
        int i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("lon"));
        localIntent.putExtra("lat", i1);
        localIntent.putExtra("lon", i2);
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter"))
        {
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter");
          if ("1".equals(str1))
          {
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
              break label592;
            }
            str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
              break label599;
            }
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
              break label606;
            }
            str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
              break label614;
            }
            str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
              break label622;
            }
            str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
              break label630;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");
            localIntent.putExtra("filter", str1);
            localIntent.putExtra("filterGender", str3);
            localIntent.putExtra("filter_time", str4);
            localIntent.putExtra("filter_age", str5);
            localIntent.putExtra("filter_xingzuo", str6);
            localIntent.putExtra("filter_career", str7);
            localIntent.putExtra("filter_location", str8);
          }
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          return true;
          str1 = "";
          continue;
          break label54;
          label554:
          break label81;
          label557:
          str3 = "";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str4;
          String str5;
          String str6;
          String str7;
          String str8;
          if (QLog.isColorLevel())
          {
            QLog.i("JumpAction", 2, localException.toString());
            continue;
            String str2 = "";
            continue;
            label592:
            str3 = "";
            continue;
            label599:
            str4 = "";
            continue;
            label606:
            str5 = "";
            continue;
            label614:
            str6 = "";
            continue;
            label622:
            str7 = "";
            continue;
            label630:
            str8 = "";
          }
        }
      }
    }
  }
  
  private boolean J()
  {
    return true;
  }
  
  private boolean K()
  {
    return true;
  }
  
  private boolean L()
  {
    return true;
  }
  
  private boolean M()
  {
    String str1;
    String str2;
    label54:
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
        break label133;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("tiny_id")) {
        break label140;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tiny_id");
      label81:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("list_type")) {
        break label147;
      }
    }
    label133:
    label140:
    label147:
    for (String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("list_type");; str4 = "")
    {
      if ((TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4))) {
        break label155;
      }
      return false;
      str1 = "";
      break;
      str2 = "";
      break label54;
      str3 = "";
      break label81;
    }
    label155:
    int i2 = 1001;
    int i1;
    if (("internal".equals(str1)) && ("3".equals(str2))) {
      i1 = 1002;
    }
    try
    {
      l1 = Long.valueOf(str3).longValue();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          long l1;
          i2 = Integer.valueOf(str4).intValue();
          DatingTopListActivity.a(this.jdField_a_of_type_AndroidContentContext, l1, i2, i1, false, true);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005274", "0X8005274", 0, 0, "", "", "", "");
          return true;
          i1 = i2;
          if ("internal".equals(str1))
          {
            i1 = i2;
            if ("2".equals(str2))
            {
              i1 = 1003;
              continue;
              localException1 = localException1;
              l1 = 0L;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          i2 = -1;
        }
      }
    }
  }
  
  private boolean N()
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("seq")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("seq");
    }
    for (;;)
    {
      String str2;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      }
      try
      {
        for (;;)
        {
          i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("type"));
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, CreateArrageActivity.class);
          localIntent.putExtra("forward_seq", str1);
          localIntent.putExtra("forward_type", "details_mode");
          localIntent.putExtra("uin", str2);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          if (i1 != 3) {
            break label186;
          }
          ReportController.b(null, "CliOper", "", "", "0X800667E", "0X800667E", 0, 0, "", "", "", "");
          return true;
          str1 = "0";
          break;
          str2 = "0";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1 = 0;
          continue;
          label186:
          if (i1 == 2) {
            ReportController.b(null, "CliOper", "", "", "0X8006417", "0X8006417", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  private boolean O()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");; str = "")
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
      localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
      localIntent.putExtra("TAB", 1);
      localIntent.putExtra("FROM_WHERE", 1);
      localIntent.addFlags(603979776);
      if ("10002".equals(str))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
  }
  
  private boolean P()
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("feedid"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("feedid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label70;
      }
    }
    label70:
    for (String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");; str2 = "")
    {
      if (!TextUtils.isEmpty(str1)) {
        break label77;
      }
      return true;
      str1 = "";
      break;
    }
    label77:
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FreshNewsDetailActivity.class);
    localIntent.putExtra("feedId", str1);
    localIntent.putExtra("from", 3);
    if ("10002".equals(str2))
    {
      localIntent.putExtra("abp_flag", true);
      localIntent.addFlags(335544320);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean Q()
  {
    Object localObject1;
    String str;
    label54:
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topicid"))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label95;
      }
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("topic")) {
        break label102;
      }
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topic");
      label79:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label109;
      }
    }
    label95:
    label102:
    label109:
    do
    {
      return true;
      localObject1 = "";
      break;
      str = "";
      break label54;
      localObject2 = "";
      break label79;
      try
      {
        long l1 = Long.valueOf((String)localObject1).longValue();
        localObject1 = new TopicInfo();
        ((TopicInfo)localObject1).jdField_a_of_type_Long = l1;
        ((TopicInfo)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyTopicFeedActivity.class);
        ((Intent)localObject2).putExtra("topic_info", (Parcelable)localObject1);
        if ("10002".equals(str))
        {
          ((Intent)localObject2).putExtra("abp_flag", true);
          ((Intent)localObject2).addFlags(335544320);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        return true;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("JumpAction", 2, "gotoFreshNewsTopic: " + localException.getMessage());
    return true;
  }
  
  private boolean R()
  {
    Object localObject2;
    String str2;
    label55:
    Object localObject1;
    label82:
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("publish_type"))
    {
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("publish_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("topicid")) {
        break label245;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label253;
      }
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("topicstr")) {
        break label260;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicstr");
    }
    for (;;)
    {
      try
      {
        l1 = Long.valueOf(str2).longValue();
      }
      catch (Exception localException1)
      {
        label245:
        label253:
        label260:
        long l1 = 0L;
      }
      try
      {
        i1 = Integer.valueOf((String)localObject2).intValue();
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, FreshNewsEditActivity.class);
        ((Intent)localObject2).putExtra("from", 1);
        if ("10002".equals(localObject1))
        {
          ((Intent)localObject2).putExtra("abp_flag", true);
          ((Intent)localObject2).addFlags(335544320);
        }
        if ((i1 == 7) && (l1 > 0L) && (!TextUtils.isEmpty(str1)))
        {
          localObject1 = new TopicInfo();
          ((TopicInfo)localObject1).jdField_a_of_type_Long = l1;
          ((TopicInfo)localObject1).jdField_a_of_type_JavaLangString = str1;
          ((Intent)localObject2).putExtra("param_topic_info", (Parcelable)localObject1);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        return true;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localObject2 = "";
      break;
      str2 = "";
      break label55;
      localObject1 = "";
      break label82;
      str1 = "";
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoFreshNewsPublish: " + localException1.getMessage());
      }
      int i1 = -1;
    }
  }
  
  private boolean S()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"); !str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()); str = "")
    {
      b();
      return false;
    }
    c();
    return false;
  }
  
  private boolean T()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", "消息");
    ((Bundle)localObject).putBoolean("isBack2Root", true);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.putExtras((Bundle)localObject);
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("txt");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localIntent.putExtra("JumpAction.Text", c((String)localObject));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean U()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    QWalletHelper.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private boolean V()
  {
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
      int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
      if (str == null) {
        return false;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent.setFlags(335544320);
      localIntent.putExtra("tab_index", MainFragment.a);
      localIntent.putExtra("openid", str);
      localIntent.putExtra("appid", i1);
      localIntent.putExtra("source", this.fs);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "Receive error appid number format");
      }
    }
    return false;
  }
  
  private boolean W()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    Object localObject6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("panel");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    if ((str3 != null) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, str3 + "");
    }
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject7 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    int i1;
    if ("c2c".equals(localObject4))
    {
      if ((str1 == null) || (str1.length() < 5)) {
        return false;
      }
      if (((FriendsManager)localObject1).b(str1))
      {
        localObject4 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
        if ("chat".equals(str4))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
          ((Intent)localObject1).putExtra("uin", str1);
          ((Intent)localObject1).putExtra("uintype", 0);
          if (localObject4 != null) {
            ((Intent)localObject1).putExtra("uinname", (String)localObject4);
          }
          ((Intent)localObject1).addFlags(67108864);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else if ("discuss".equals(localObject4))
    {
      if ((str1 == null) || (str1.length() < 6)) {
        return false;
      }
      localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discuss_info");
      i1 = 3000;
      localObject3 = null;
      localObject1 = null;
    }
    for (;;)
    {
      localObject6 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
      ((Intent)localObject6).putExtra("uin", str1);
      ((Intent)localObject6).putExtra("uintype", i1);
      if (localObject4 != null) {
        ((Intent)localObject6).putExtra("uinname", (String)localObject4);
      }
      if (str2 != null) {
        ((Intent)localObject6).putExtra("input_text", str2);
      }
      if ((localObject1 != null) && (localObject1.length > 0)) {
        ((Intent)localObject6).putExtra((String)localObject3, (byte[])localObject1);
      }
      if ((str3 != null) && (!"".equals(str3))) {
        if ((str1 == null) || ("".equals(str1)))
        {
          return false;
          if ("group".equals(localObject4))
          {
            if ((str1 == null) || (str1.length() < 6)) {
              return false;
            }
            localObject1 = ((TroopManager)localObject7).a(str1);
            if (localObject1 != null)
            {
              localObject4 = ((TroopInfo)localObject1).troopname;
              i1 = 1;
              localObject3 = null;
              localObject1 = null;
              continue;
            }
            return false;
          }
          if ("robot".equals(localObject4))
          {
            if ((str1 == null) || ("".equals(str1))) {
              return false;
            }
            localObject4 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
            i1 = 1001;
            localObject3 = null;
            localObject1 = null;
            continue;
          }
          if ("wpa".equals(localObject4))
          {
            if (((FriendsManager)localObject1).b(str1)) {
              i1 = 0;
            }
            for (localObject1 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);; localObject1 = null)
            {
              e(str1);
              localObject4 = localObject1;
              localObject3 = null;
              localObject1 = null;
              break;
              i1 = 1005;
            }
          }
          if ("crm".equals(localObject4))
          {
            localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpaType");
            localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assignId");
            str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("QidianSigT");
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("QidianKfUin");
            if ((localObject4 != null) && (localObject5 != null) && (str3 != null) && (str4 != null) && (((String)localObject4).equals("1"))) {
              try
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
                ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str4, (String)localObject4, str3, (String)localObject5);
                return true;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", 2, localException.getMessage());
                  }
                }
              }
            }
            if (QLog.isColorLevel())
            {
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("wpaType:").append((String)localObject4).append("assignId:").append((String)localObject5).append("qidianSigt").append(str3).append("qidianUin").append(str4);
              QLog.d("JumpAction", 2, ((StringBuilder)localObject7).toString());
            }
            localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
            ((Intent)localObject4).addFlags(67108864);
            if (localException.b(str1))
            {
              localObject2 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
              i1 = 0;
            }
            for (;;)
            {
              if (BmqqSegmentUtil.b(this.jdField_a_of_type_AndroidContentContext, str1))
              {
                ((Intent)localObject4).putExtra("isBack2Root", true);
                if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("kfnick")) && (!TextUtils.isEmpty(str1))) {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfnick"));
                }
                localObject5 = new HashMap();
                ((HashMap)localObject5).put("a_actionData", this.jdField_a_of_type_JavaUtilHashMap.toString());
                ((HashMap)localObject5).put("uin", str1);
                ((HashMap)localObject5).put("uin_type", String.valueOf(i1));
                StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSwitchToCrmExt", true, -1L, -1L, (HashMap)localObject5, "", true);
              }
              ((Intent)localObject4).putExtra("from_wpa_for_crm", true);
              ((Intent)localObject4).putExtra("uin", str1);
              ((Intent)localObject4).putExtra("uintype", i1);
              if (localObject2 != null) {
                ((Intent)localObject4).putExtra("uinname", (String)localObject2);
              }
              if (str2 != null) {
                ((Intent)localObject4).putExtra("input_text", str2);
              }
              if ((localObject6 != null) && (str1 != null))
              {
                localObject2 = HexUtil.a((String)localObject6);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, (byte[])localObject2);
              }
              if (localObject3 != null) {
                ((Intent)localObject4).putExtra("sigt", HexUtil.a((String)localObject3));
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str1, "", "");
              return true;
              if (CrmUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1))
              {
                ((Intent)localObject4).putExtra("chat_subType", 1);
                localObject2 = null;
                i1 = 1024;
              }
              else
              {
                localObject2 = null;
                i1 = 1025;
              }
            }
          }
          if (("lbs".equals(localObject4)) || ("date".equals(localObject4)))
          {
            if ((str1 == null) || (str1.length() < 5) || (str1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
              return false;
            }
            if (((FriendsManager)localObject2).b(str1))
            {
              i1 = 0;
              localObject4 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
              localObject3 = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject3 != null) && (localObject6 != null))
        {
          localObject2 = HexUtil.a((String)localObject6);
          break;
          if ("lbs".equals(localObject4))
          {
            i1 = 1001;
            localObject4 = ContactUtils.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
            localObject3 = "rich_accost_sig";
          }
          else
          {
            i1 = 1010;
            localObject4 = ContactUtils.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
            localObject3 = "rich_date_sig";
            continue;
            if ("public_account".equals(localObject4))
            {
              if ((str1 == null) || (str1.length() < 6)) {
                return false;
              }
              localObject2 = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str1, "0X800589E", "0X800589E", 0, 0, str1, "", "", "");
              localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
              ((Intent)localObject3).putExtra("uin", str1);
              ((Intent)localObject3).putExtra("uintype", 1008);
              if (localObject2 != null) {
                ((Intent)localObject3).putExtra("uinname", (String)localObject2);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
              return true;
            }
            if ("qd_account".equals(localObject4))
            {
              if ((str1 == null) || (str1.length() < 6)) {
                return false;
              }
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
              ((Intent)localObject2).addFlags(67108864);
              ((Intent)localObject2).putExtra("uin", str1);
              ((Intent)localObject2).putExtra("uintype", 1008);
              localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("key");
              localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfuin");
              str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_type");
              str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_key");
              localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ext");
              if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
                return false;
              }
              ((Intent)localObject2).putExtra("qd_wpa_key", (String)localObject3);
              ((Intent)localObject2).putExtra("qd_kfuin", (String)localObject4);
              if (!TextUtils.isEmpty(str1)) {
                ((Intent)localObject2).putExtra("assign_type", str1);
              }
              if (!TextUtils.isEmpty(str2)) {
                ((Intent)localObject2).putExtra("assign_key", str2);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                ((Intent)localObject2).putExtra("assign_ext", (String)localObject5);
              }
              if (0 != 0) {
                ((Intent)localObject2).putExtra("uinname", null);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
              return true;
            }
            return false;
            localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type");
            localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("thirdAppDisplayName"));
            localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
            if ((localObject2 != null) && (!"".equals(localObject2))) {
              ((Intent)localObject6).putExtra("callback_type", (String)localObject2);
            }
            if ((localObject3 != null) && (!"".equals(localObject3))) {
              ((Intent)localObject6).putExtra("thirdAppDisplayName", (String)localObject3);
            }
            if ((localObject4 != null) && (!"".equals(localObject4))) {
              ((Intent)localObject6).putExtra("appid", (String)localObject4);
            }
            a((Intent)localObject6, str3);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
            if ("webview".equals(this.gg))
            {
              ((Intent)localObject6).putExtra("from", this.gg);
              if (jdField_b_of_type_Int > 3)
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, "对话框打开数已达到上限", 1).a();
                return true;
              }
              jdField_b_of_type_Int += 1;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              if (localObject5 != null) {
                ((Intent)localObject6).putExtra("panel", (String)localObject5);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject6);
              return true;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
            }
          }
        }
      }
      Object localObject2 = null;
      continue;
      localObject2 = null;
      i1 = 0;
      localObject3 = null;
    }
  }
  
  private boolean X()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || (str.length() < 6)) {
      return false;
    }
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject == null) {
      return false;
    }
    localObject = ((TroopManager)localObject).a(str);
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).troopname;
      Intent localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent = AIOUtils.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 1);
      if (localObject != null) {
        localIntent.putExtra("uinname", (String)localObject);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return am();
  }
  
  private boolean Y()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    if ((str != null) && (localObject != null)) {}
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(str.trim());
        i1 = Integer.parseInt(((String)localObject).trim());
        str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
        ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
        ((Intent)localObject).putExtra("lat", i1);
        ((Intent)localObject).putExtra("lon", i2);
        ((Intent)localObject).putExtra("filter", 0);
        if (str != null) {
          ((Intent)localObject).putExtra("title", str);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return true;
      }
      catch (Exception localException)
      {
        return false;
      }
      int i1 = 0;
      int i2 = 0;
    }
  }
  
  private boolean Z()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("selectedIndex");
    if ((localObject != null) && (str1 != null)) {}
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(((String)localObject).trim());
        int i4;
        i3 = i2;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          i2 = Integer.parseInt(str1.trim());
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            i3 = 0;
            i2 = i1;
            i1 = i3;
          }
        }
        try
        {
          i4 = Integer.parseInt(str2.trim());
          i3 = i1;
          i1 = i4;
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyTroopsActivity.class);
          ((Intent)localObject).putExtra("lat", i2);
          ((Intent)localObject).putExtra("lon", i3);
          ((Intent)localObject).putExtra("selectedIndex", i1);
          ((Intent)localObject).putExtra("from", 4);
          ((Intent)localObject).putExtra("mode", 0);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          return true;
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          i3 = i1;
          i1 = i2;
          i2 = i3;
          break label165;
        }
        localNumberFormatException1 = localNumberFormatException1;
        i1 = 0;
        i2 = 0;
      }
      label165:
      int i2 = i1;
      int i1 = 0;
      continue;
      i1 = 0;
      i2 = 0;
      int i3 = 0;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return paramString1;
    }
    try
    {
      String str = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    if (paramString1.contains(paramString2)) {
      return paramString1.replace(paramString2, paramString3);
    }
    return paramString1.replace(paramString2.toUpperCase(), paramString3);
  }
  
  private String a(byte[] paramArrayOfByte, Cryptor paramCryptor)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("plg_nld=1");
    localStringBuffer.append("&");
    localStringBuffer.append("DEVICEINFO=");
    paramArrayOfByte = "2|" + HexUtil.a(paramArrayOfByte);
    localStringBuffer.append(HexUtil.a(paramCryptor.encrypt((paramArrayOfByte + "|" + b()).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
    return localStringBuffer.toString();
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse("midas://open_modify_status?status=" + paramInt));
    if (this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(this.gl)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
      }
      return;
    }
    paramIntent.putExtra("redTouch", this.gl);
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "wpaParamsParse---Start");
    }
    int i1;
    if (this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type") == null)
    {
      i1 = 0;
      paramIntent.putExtra("from3rdApp", true);
      if (i1 != 1) {
        break label244;
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "params must be decrypted");
        }
        paramString = Base64Util.decode(new Cryptor().decrypt(HexUtil.a(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
        if (paramString == null) {
          break label298;
        }
        paramString = new JSONObject(new String(paramString));
        boolean bool1 = bool2;
        if (paramString.has("layout"))
        {
          bool1 = bool2;
          if (paramString.getString("layout") != null) {
            bool1 = true;
          }
        }
        paramIntent.putExtra("showFirstStructMsg", bool1);
        if (paramString != null)
        {
          paramString = ChatActivityUtils.a(paramString);
          paramIntent.putExtra("stuctmsg_bytes", paramString);
          if ((paramString != null) && (i1 == 1)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
          }
        }
        return;
      }
      catch (JSONException paramIntent)
      {
        label244:
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.e("JumpAction", 4, "wpaParamsParse---JSONException");
        return;
      }
      i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type"));
      break;
      paramIntent.putExtra("fromSencondhandCommunity", true);
      paramString = new JSONObject(paramString);
      paramIntent.putExtra("gid", paramString.getString("gid"));
      continue;
      label298:
      paramString = null;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    paramIntent.putExtra("url", paramString1);
    paramIntent.setClassName(paramString2, paramString3);
    paramIntent.addCategory("android.intent.category.LAUNCHER");
    paramIntent.addFlags(268435456);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramIntent);
  }
  
  /* Error */
  private boolean a(Intent paramIntent, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_1
    //   4: ldc_w 308
    //   7: invokevirtual 1848	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   10: ifne +14 -> 24
    //   13: aload_1
    //   14: ldc_w 308
    //   17: invokestatic 1244	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 1267	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   23: pop
    //   24: ldc_w 835
    //   27: aload_0
    //   28: getfield 1659	com/tencent/mobileqq/utils/JumpAction:gg	Ljava/lang/String;
    //   31: invokevirtual 1211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +463 -> 497
    //   37: iconst_1
    //   38: istore 9
    //   40: aload_1
    //   41: ldc_w 1850
    //   44: iload 9
    //   46: invokevirtual 1221	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   54: ifnull +346 -> 400
    //   57: aload_0
    //   58: getfield 1854	com/tencent/mobileqq/utils/JumpAction:d	Z
    //   61: ifeq +339 -> 400
    //   64: aload_0
    //   65: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   68: getfield 1860	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 1864	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: sipush 769
    //   77: if_icmpne +323 -> 400
    //   80: aload_0
    //   81: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   84: getfield 1867	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 1864	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   90: istore 7
    //   92: aload_0
    //   93: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   96: ldc_w 853
    //   99: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 1067	java/lang/String
    //   105: invokestatic 1281	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore 5
    //   110: aload_0
    //   111: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: invokevirtual 1869	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   117: ldc_w 1871
    //   120: iconst_0
    //   121: invokevirtual 1877	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   124: astore 4
    //   126: aload 4
    //   128: new 1185	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 1186	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 1879
    //   138: invokevirtual 1192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: invokevirtual 1442	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   148: invokevirtual 1192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 1196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: invokeinterface 1885 3 0
    //   160: istore 8
    //   162: aload 4
    //   164: invokeinterface 1889 1 0
    //   169: new 1185	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 1186	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1879
    //   179: invokevirtual 1192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: invokevirtual 1442	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   189: invokevirtual 1192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 1196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: iconst_0
    //   196: invokeinterface 1895 3 0
    //   201: invokeinterface 1898 1 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   211: getfield 1902	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   214: invokevirtual 1906	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   217: ifeq +306 -> 523
    //   220: new 1811	org/json/JSONObject
    //   223: dup
    //   224: aload_0
    //   225: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   228: getfield 1902	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: invokevirtual 1908	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   234: invokespecial 1816	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: astore 4
    //   239: aload_0
    //   240: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   243: getfield 1912	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   246: invokevirtual 1915	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   249: ifeq +274 -> 523
    //   252: aload_0
    //   253: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   256: getfield 1912	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   259: invokevirtual 1917	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   262: ifne +261 -> 523
    //   265: ldc_w 817
    //   268: aload 4
    //   270: ldc_w 1919
    //   273: invokevirtual 1923	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   276: aload_0
    //   277: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   280: getfield 1912	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   283: iconst_0
    //   284: invokevirtual 1926	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   287: checkcast 1067	java/lang/String
    //   290: invokevirtual 1923	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   293: ldc_w 1928
    //   296: invokevirtual 1822	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 1211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: istore 9
    //   304: iload 9
    //   306: ifeq +217 -> 523
    //   309: aload_1
    //   310: ldc_w 1930
    //   313: iload 6
    //   315: invokevirtual 1139	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   318: pop
    //   319: aload_1
    //   320: ldc_w 1932
    //   323: iload 7
    //   325: invokevirtual 1139	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   328: pop
    //   329: aload_1
    //   330: ldc_w 1934
    //   333: iload 8
    //   335: invokevirtual 1139	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_1
    //   340: ldc_w 1936
    //   343: iload 5
    //   345: invokevirtual 1139	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   348: pop
    //   349: aload_0
    //   350: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   353: getfield 1912	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   356: invokevirtual 1915	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   359: ifeq +41 -> 400
    //   362: aload_0
    //   363: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   366: getfield 1912	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   369: invokevirtual 1917	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   372: ifne +28 -> 400
    //   375: aload_1
    //   376: ldc_w 1938
    //   379: new 1940	java/util/ArrayList
    //   382: dup
    //   383: aload_0
    //   384: getfield 1852	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   387: getfield 1912	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   390: invokevirtual 1943	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   393: invokespecial 1946	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   396: invokevirtual 1950	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   399: pop
    //   400: aload_1
    //   401: ldc_w 1952
    //   404: aload_0
    //   405: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 1442	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   411: invokevirtual 1148	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload_1
    //   416: ldc_w 1954
    //   419: iconst_1
    //   420: invokevirtual 1221	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   423: pop
    //   424: aload_1
    //   425: ldc_w 1956
    //   428: iconst_1
    //   429: invokevirtual 1221	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   432: pop
    //   433: aload_1
    //   434: ldc_w 1958
    //   437: aload_0
    //   438: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: invokevirtual 1442	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   444: invokevirtual 1148	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload_1
    //   449: ldc_w 1960
    //   452: ldc_w 1962
    //   455: invokevirtual 1148	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: aload_1
    //   461: invokespecial 1964	com/tencent/mobileqq/utils/JumpAction:a	(Landroid/content/Intent;)V
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   469: aload_2
    //   470: invokevirtual 1967	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   478: aload_1
    //   479: invokevirtual 1154	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   482: ldc_w 1969
    //   485: aload_3
    //   486: invokevirtual 1211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   489: ifne +6 -> 495
    //   492: invokestatic 1971	cooperation/qwallet/plugin/QWalletHelper:a	()V
    //   495: iconst_1
    //   496: ireturn
    //   497: iconst_0
    //   498: istore 9
    //   500: goto -460 -> 40
    //   503: astore 4
    //   505: aload 4
    //   507: invokevirtual 1306	java/lang/Exception:printStackTrace	()V
    //   510: iconst_0
    //   511: istore 5
    //   513: goto -403 -> 110
    //   516: astore 4
    //   518: aload 4
    //   520: invokevirtual 1306	java/lang/Exception:printStackTrace	()V
    //   523: iconst_1
    //   524: istore 6
    //   526: goto -217 -> 309
    //   529: astore_1
    //   530: iconst_1
    //   531: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	JumpAction
    //   0	532	1	paramIntent	Intent
    //   0	532	2	paramString1	String
    //   0	532	3	paramString2	String
    //   124	145	4	localObject	Object
    //   503	3	4	localException1	Exception
    //   516	3	4	localException2	Exception
    //   108	404	5	i1	int
    //   1	524	6	i2	int
    //   90	234	7	i3	int
    //   160	174	8	i4	int
    //   38	461	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   92	110	503	java/lang/Exception
    //   220	304	516	java/lang/Exception
    //   474	495	529	java/lang/Exception
  }
  
  private boolean a(String paramString)
  {
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i2 = 0;
    long l1;
    int i3;
    try
    {
      l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
      if (l1 <= 0L) {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = 0L;
      }
      i3 = 1;
    }
    try
    {
      i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      try
      {
        for (;;)
        {
          i2 = Integer.valueOf((String)localObject2).intValue();
          if (localObject1 != null) {
            break label818;
          }
          localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
          localObject2 = new ArrayList();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject1 = ((String)localObject1).split(";");
          i3 = 0;
          while (i3 < localObject1.length)
          {
            ((ArrayList)localObject2).add(URLDecoder.decode(localObject1[i3]));
            i3 += 1;
          }
          localNumberFormatException2 = localNumberFormatException2;
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("QzoneShare", 2, "NumberFormatException extFlags = 0");
            i1 = i2;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        label818:
        for (;;)
        {
          int i1;
          i2 = i3;
          if (QLog.isColorLevel())
          {
            QLog.d("QzoneShare", 2, "NumberFormatException req_type = 1");
            i2 = i3;
            continue;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("title", str2);
            ((Bundle)localObject1).putString("desc", str3);
            ((Bundle)localObject1).putString("app_name", str5);
            ((Bundle)localObject1).putLong("req_share_id", l1);
            ((Bundle)localObject1).putString("detail_url", str4);
            ((Bundle)localObject1).putStringArrayList("image_url", localNumberFormatException1);
            ((Bundle)localObject1).putString("pkg_name", this.gh);
            ((Bundle)localObject1).putString("open_id", str1);
            ((Bundle)localObject1).putString("share_uin", str7);
            ((Bundle)localObject1).putString("jfrom", str8);
            ((Bundle)localObject1).putString("share_qq_ext_str", str9);
            ((Bundle)localObject1).putInt("cflag", i1);
            ((Bundle)localObject1).putString("share_action", paramString);
            ((Bundle)localObject1).putInt("iUrlInfoFrm", 4);
            ((Bundle)localObject1).putBoolean("thirdPartShare", true);
            if (i2 == 2) {
              ((Bundle)localObject1).putString("audio_url", str6);
            }
            ((Bundle)localObject1).putInt("req_type", i2);
            com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
            paramString = new way(this);
            QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, paramString);
            if (i2 == 1) {
              paramString = "1";
            }
            try
            {
              for (;;)
              {
                ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str1, String.valueOf(l1), "11", "12", "0", paramString, "0", "0", false);
                paramString = new QZoneClickReport.ReportInfo();
                paramString.c = "1";
                paramString.d = "0";
                paramString.jdField_b_of_type_Int = 4;
                paramString.k = "5";
                paramString.l = "thirdApp";
                paramString.m = "activefeed";
                QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString);
                paramString = new HashMap();
                paramString.put("source_type", "5");
                paramString.put("source_from", "thirdApp");
                paramString.put("source_to", "activefeed");
                StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramString, null);
                return true;
                if (i2 == 2) {
                  paramString = "3";
                } else if (i2 == 5) {
                  paramString = "2";
                } else {
                  paramString = "4";
                }
              }
            }
            catch (Exception paramString)
            {
              for (;;) {}
            }
          }
        }
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    QWalletHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle, null, 0L);
    return true;
  }
  
  private boolean aA()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localUserInfo.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
      QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, -1);
      return true;
    }
    return false;
  }
  
  private boolean aB()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    localObject = new Intent("com.tencent.sc.intent.tabactivity");
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    return true;
  }
  
  private boolean aC()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, JoinDiscussionActivity.class);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    localIntent.putExtra("sig", str);
    if (TextUtils.isEmpty(str)) {
      localIntent.putExtra("innerSig", (String)this.jdField_a_of_type_JavaUtilHashMap.get("k"));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aD()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AgentActivity.class);
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
    }
    localIntent.putExtra("key_params", localBundle);
    localIntent.putExtra("key_action", "action_ptlogin_login");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoMultiVoiceChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("relation_id");
    if ((str1 != null) && (str1.equals("web")) && (str2 != null) && (str2.equals("1")) && (localObject != null) && (str3 != null))
    {
      if (str3.equals("discussgroup")) {
        if (((String)localObject).equals("0"))
        {
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectMemberActivity.class);
          ((Intent)localObject).putExtra("param_type", 3000);
          ((Intent)localObject).putExtra("param_subtype", 0);
          ((Intent)localObject).putExtra("param_from", 1003);
          ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131370425));
          ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131369290));
          ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131370215));
          ((Intent)localObject).putExtra("param_entrance", 10);
          ((Intent)localObject).putExtra("param_max", 99);
          ((Intent)localObject).setFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 1);
        }
      }
      do
      {
        return true;
        return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, null);
        if (str3.equals("single"))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("forward_type", 13);
          ((Intent)localObject).putExtra("fromWebXman", true);
          ForwardBaseOption.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 2);
          return true;
        }
        if (!str3.equals("group")) {
          break;
        }
      } while (((String)localObject).equals("0"));
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from");
      if ((!"gvideo".equals(str1)) && (!"gvideo_h5".equals(str1))) {
        break label438;
      }
    }
    label438:
    for (boolean bool = false;; bool = true)
    {
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, true, bool, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_a_of_type_JavaUtilHashMap);
      return false;
    }
  }
  
  /* Error */
  private boolean aF()
  {
    // Byte code:
    //   0: invokestatic 1178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 973
    //   9: iconst_2
    //   10: ldc_w 2207
    //   13: invokestatic 1183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: getstatic 2209	com/tencent/biz/eqq/CrmUtils:jdField_a_of_type_Boolean	Z
    //   19: ifne +21 -> 40
    //   22: invokestatic 1491	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   25: ifeq +13 -> 38
    //   28: ldc_w 973
    //   31: iconst_4
    //   32: ldc_w 2211
    //   35: invokestatic 1183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: iconst_0
    //   39: ireturn
    //   40: aload_0
    //   41: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   44: ldc_w 284
    //   47: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 1067	java/lang/String
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   58: ldc_w 2213
    //   61: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 1067	java/lang/String
    //   67: astore_2
    //   68: aload_0
    //   69: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   72: ldc_w 278
    //   75: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: checkcast 1067	java/lang/String
    //   81: astore_3
    //   82: aload_0
    //   83: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   86: ldc_w 397
    //   89: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 1067	java/lang/String
    //   95: astore 4
    //   97: aload_0
    //   98: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   101: ldc_w 2215
    //   104: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 1067	java/lang/String
    //   110: astore 5
    //   112: aload_0
    //   113: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   116: ldc_w 514
    //   119: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 1067	java/lang/String
    //   125: astore 6
    //   127: invokestatic 1178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +48 -> 178
    //   133: ldc_w 973
    //   136: iconst_2
    //   137: ldc_w 2217
    //   140: bipush 6
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload_2
    //   152: aastore
    //   153: dup
    //   154: iconst_2
    //   155: aload_3
    //   156: aastore
    //   157: dup
    //   158: iconst_3
    //   159: aload 4
    //   161: aastore
    //   162: dup
    //   163: iconst_4
    //   164: aload 5
    //   166: aastore
    //   167: dup
    //   168: iconst_5
    //   169: aload 6
    //   171: aastore
    //   172: invokestatic 2221	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   175: invokestatic 1183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload_1
    //   179: ifnull +224 -> 403
    //   182: aload_1
    //   183: ldc 62
    //   185: invokevirtual 1211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: ifeq +215 -> 403
    //   191: aload_3
    //   192: ifnull +211 -> 403
    //   195: aload_3
    //   196: ldc_w 820
    //   199: invokevirtual 1211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq +201 -> 403
    //   205: sipush 1024
    //   208: invokestatic 2224	com/tencent/mobileqq/utils/ContactUtils:b	(I)I
    //   211: istore 7
    //   213: iload 7
    //   215: iconst_m1
    //   216: if_icmpne +113 -> 329
    //   219: aload_0
    //   220: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   223: aload 4
    //   225: sipush 1024
    //   228: invokestatic 2227	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   231: astore_1
    //   232: aload_1
    //   233: invokestatic 1319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   236: ifne +14 -> 250
    //   239: aload_1
    //   240: astore_2
    //   241: aload 4
    //   243: aload_1
    //   244: invokevirtual 1211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +14 -> 261
    //   250: aload_0
    //   251: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   254: aload 4
    //   256: iconst_1
    //   257: invokestatic 2230	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   260: astore_2
    //   261: aload_2
    //   262: invokestatic 1319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifeq +144 -> 409
    //   268: aload 4
    //   270: astore_1
    //   271: aload_0
    //   272: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: aload_0
    //   276: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   279: checkcast 1438	com/tencent/mobileqq/app/BaseActivity
    //   282: aload_1
    //   283: aload 4
    //   285: ldc_w 2232
    //   288: invokestatic 2235	com/tencent/biz/eqq/CrmUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload_0
    //   292: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   295: ldc_w 1156
    //   298: ldc_w 1158
    //   301: ldc_w 1158
    //   304: ldc_w 2237
    //   307: ldc_w 2237
    //   310: iconst_0
    //   311: iconst_0
    //   312: ldc_w 1158
    //   315: ldc_w 1158
    //   318: ldc_w 1158
    //   321: ldc_w 1158
    //   324: invokestatic 1165	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   327: iconst_1
    //   328: ireturn
    //   329: aload_0
    //   330: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   333: aload 4
    //   335: ldc_w 1158
    //   338: iload 7
    //   340: iconst_0
    //   341: invokestatic 2240	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   344: astore_1
    //   345: goto -113 -> 232
    //   348: astore_3
    //   349: ldc_w 1158
    //   352: astore_1
    //   353: aload_3
    //   354: invokevirtual 1306	java/lang/Exception:printStackTrace	()V
    //   357: aload_1
    //   358: astore_2
    //   359: invokestatic 1178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -101 -> 261
    //   365: ldc_w 973
    //   368: iconst_2
    //   369: ldc_w 2242
    //   372: aload_3
    //   373: invokestatic 2244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   376: aload_1
    //   377: astore_2
    //   378: goto -117 -> 261
    //   381: astore_1
    //   382: aload_1
    //   383: invokevirtual 1306	java/lang/Exception:printStackTrace	()V
    //   386: invokestatic 1178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq +14 -> 403
    //   392: ldc_w 973
    //   395: iconst_2
    //   396: ldc_w 2246
    //   399: aload_1
    //   400: invokestatic 2244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   403: iconst_0
    //   404: ireturn
    //   405: astore_3
    //   406: goto -53 -> 353
    //   409: aload_2
    //   410: astore_1
    //   411: goto -140 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	JumpAction
    //   53	324	1	localObject1	Object
    //   381	19	1	localException1	Exception
    //   410	1	1	localObject2	Object
    //   67	343	2	localObject3	Object
    //   81	115	3	str1	String
    //   348	25	3	localException2	Exception
    //   405	1	3	localException3	Exception
    //   95	239	4	str2	String
    //   110	55	5	str3	String
    //   125	45	6	str4	String
    //   211	128	7	i1	int
    // Exception table:
    //   from	to	target	type
    //   219	232	348	java/lang/Exception
    //   329	345	348	java/lang/Exception
    //   271	327	381	java/lang/Exception
    //   232	239	405	java/lang/Exception
    //   241	250	405	java/lang/Exception
    //   250	261	405	java/lang/Exception
  }
  
  private boolean aG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoIVRIMChat");
    }
    if (!CrmUtils.jdField_a_of_type_Boolean) {
      if (QLog.isDevelopLevel()) {
        QLog.d("JumpAction", 4, "Don't support sharp");
      }
    }
    Object localObject1;
    Object localObject2;
    String str1;
    do
    {
      return false;
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, String.format("gotoIVRVideoChat input params, requestType = %s, version = %s, uin = %s, from = %s", new Object[] { localObject1, localObject2, str1, str2 }));
      }
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    } while (localObject1 == null);
    int i1;
    if (((FriendsManager)localObject1).b(str1))
    {
      localObject1 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      i1 = 0;
      if ((!SplashActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext)) && (!ChatActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext))) {
        break label232;
      }
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, (String)localObject1);
    }
    for (;;)
    {
      return true;
      i1 = 1024;
      localObject1 = CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      break;
      label232:
      localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
      ((Intent)localObject2).putExtra("chat_subType", 1);
      ((Intent)localObject2).putExtra("uin", str1);
      ((Intent)localObject2).putExtra("uintype", i1);
      if (localObject1 != null) {
        ((Intent)localObject2).putExtra("uinname", (String)localObject1);
      }
      ((Intent)localObject2).putExtra("crm_ivr_aio_video_action_sheet", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str1, "", "");
    }
  }
  
  private boolean aH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoVideoChat");
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    if ((localObject2 != null) && ("forward_to_tab".equals(localObject2)))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", MainFragment.a);
      ((Intent)localObject1).putExtra("conversation_index", 1);
      ((Intent)localObject1).setFlags(335544320);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uinType");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("phone");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extraUin");
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(str3);
        if ((localObject3 == null) || (!((String)localObject3).equals("web")) || (i1 <= 0)) {}
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i1;
        int i2;
        try
        {
          i1 = Integer.valueOf(str2).intValue();
          i1 = VideoController.a(i1, false, 1);
          if ((localObject2 == null) || (!((String)localObject2).equals("audio"))) {
            break label587;
          }
          bool1 = true;
          if (i1 == 1006)
          {
            localObject2 = localObject5;
            if (!((String)localObject5).startsWith("+")) {
              localObject2 = "+" + (String)localObject5;
            }
            localObject3 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c((String)localObject2);
            if (localObject3 != null)
            {
              localObject3 = ((PhoneContact)localObject3).name;
              localObject5 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject5 = localObject2;
              }
              bool2 = true;
              localObject1 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject5;
              return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, (String)localObject1, (String)localObject3, bool1, str1, bool2, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
              localNumberFormatException = localNumberFormatException;
              i1 = 0;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoVideoChat", localException);
          }
          i1 = 0;
          continue;
          localObject4 = localObject2;
          continue;
          if (i1 == 1011)
          {
            localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickName");
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              localObject2 = localObject4;
              if (!((String)localObject1).equals(localObject4)) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363728);
            }
            bool2 = false;
            localObject4 = localObject2;
            bool1 = true;
            localObject2 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            continue;
          }
          i2 = ContactUtils.b(i1);
          if (i2 != -1) {
            continue;
          }
        }
        localObject4 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i1);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localObject4)) {}
        }
        else
        {
          localObject2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label572;
        }
        bool2 = true;
        localObject2 = localObject1;
        localObject4 = localObject5;
        continue;
        localObject4 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, str1, i2, 0);
        continue;
      }
      return false;
      label572:
      boolean bool2 = true;
      Object localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      continue;
      label587:
      boolean bool1 = false;
    }
  }
  
  private boolean aI()
  {
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoRandomVideoChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("session_name"));
    this.jdField_a_of_type_JavaUtilHashMap.put("session_name", str4);
    boolean bool1;
    if ((str2 != null) && (str2.equals("audio"))) {
      bool1 = true;
    }
    try
    {
      for (;;)
      {
        i1 = Integer.parseInt(str3);
        boolean bool2 = bool3;
        if (str1 != null)
        {
          bool2 = bool3;
          if (str1.equals("web"))
          {
            bool2 = bool3;
            if (i1 > 0) {
              bool2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1011, null, null, null, bool1, null, false, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
            }
          }
        }
        return bool2;
        bool1 = false;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i1 = 0;
      }
    }
  }
  
  private boolean aJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoGameGuildChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    boolean bool;
    if ((str2 != null) && (str2.equals("audio"))) {
      bool = true;
    }
    try
    {
      i1 = Integer.parseInt(str3);
      str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("room_title"));
      this.jdField_a_of_type_JavaUtilHashMap.put("room_title", str2);
      if ((str1 == null) || (!str1.equals("web")) || (i1 < 1)) {
        break label250;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("is_quit");
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        for (;;)
        {
          l1 = Long.parseLong((String)this.jdField_a_of_type_JavaUtilHashMap.get("group_id"));
          if ((str1 == null) || (!str1.equals("1")) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() == l1)) {
            break;
          }
          return true;
          bool = false;
        }
        localNumberFormatException1 = localNumberFormatException1;
        int i1 = 0;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          long l1 = -1L;
        }
      }
    }
    return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1011, null, null, null, bool, null, false, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
    label250:
    return false;
  }
  
  private boolean aK()
  {
    if (this.fu.equals("jump"))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("options");
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, VipComicJumpActivity.class);
      localIntent.putExtra("options", str);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  private boolean aL()
  {
    Intent localIntent2;
    Object localObject3;
    Object localObject7;
    int i1;
    Object localObject4;
    Object localObject8;
    label872:
    label982:
    label1019:
    boolean bool1;
    for (;;)
    {
      try
      {
        localIntent2 = new Intent("android.intent.action.MAIN");
        a(localIntent2);
        localObject3 = null;
        Object localObject1 = null;
        localObject7 = this.jdField_a_of_type_JavaUtilHashMap.entrySet();
        i1 = 0;
        localObject4 = "";
        if (!TextUtils.isEmpty(a("from_leba")))
        {
          localIntent2.putExtra("plugin_start_time", System.nanoTime());
          localIntent2.putExtra("click_start_time", System.currentTimeMillis());
          localIntent2.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent2.putExtra("is_from_leba", true);
          localIntent2.putExtra("has_red_dot", this.d);
        }
        Iterator localIterator = ((Set)localObject7).iterator();
        if (localIterator.hasNext())
        {
          localObject7 = (Map.Entry)localIterator.next();
          localObject8 = (String)((Map.Entry)localObject7).getKey();
          localObject7 = (String)((Map.Entry)localObject7).getValue();
          if ((localObject8 == null) || (localObject7 == null)) {
            continue;
          }
          if ("pkg".equals(localObject8))
          {
            localObject3 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject7;
            break label2267;
          }
          if ("cmp".equals(localObject8))
          {
            localObject8 = localObject3;
            localObject1 = localObject4;
            localObject3 = localObject7;
            localObject4 = localObject8;
            break label2267;
          }
          if ("plg_account".equals(localObject8))
          {
            if (!"1".equals(localObject7)) {
              break label2280;
            }
            localIntent2.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            localObject7 = localObject1;
            localObject8 = localObject3;
            localObject1 = localObject4;
            localObject3 = localObject7;
            localObject4 = localObject8;
            break label2267;
          }
          if ("plg_nickname".equals(localObject8))
          {
            if (!"1".equals(localObject7)) {
              break label2280;
            }
            localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
            localObject7 = localObject8;
            if (StringUtil.b((String)localObject8)) {
              localObject7 = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            }
            localIntent2.putExtra("nickname", (String)localObject7);
            localObject7 = localObject1;
            localObject8 = localObject3;
            localObject1 = localObject4;
            localObject3 = localObject7;
            localObject4 = localObject8;
            break label2267;
          }
          if ("plg_vkey".equals(localObject8))
          {
            if (!"1".equals(localObject7)) {
              break label2280;
            }
            localIntent2.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
            localObject7 = localObject1;
            localObject8 = localObject3;
            localObject1 = localObject4;
            localObject3 = localObject7;
            localObject4 = localObject8;
            break label2267;
          }
          if ("plg_launchtime".equals(localObject8))
          {
            if (!"1".equals(localObject7)) {
              break label2280;
            }
            localIntent2.putExtra("launch_time", System.currentTimeMillis());
            localObject7 = localObject1;
            localObject8 = localObject3;
            localObject1 = localObject4;
            localObject3 = localObject7;
            localObject4 = localObject8;
            break label2267;
          }
          if ("plg_newflag".equals(localObject8))
          {
            if (!"1".equals(localObject7)) {
              break label2280;
            }
            localIntent2.putExtra("newflag", this.c);
            if (!QLog.isColorLevel()) {
              break label2280;
            }
            QLog.d("Jumpaction", 2, "handleAppForward.newflag=" + this.c);
            localObject7 = localObject1;
            localObject8 = localObject3;
            localObject1 = localObject4;
            localObject3 = localObject7;
            localObject4 = localObject8;
            break label2267;
          }
          if ("plg_type".equals(localObject8))
          {
            if (!"1".equals(localObject7)) {
              break label2280;
            }
            i1 = 1;
            localObject7 = localObject3;
            localObject3 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject7;
            break label2267;
          }
          if ("apk".equals(localObject8))
          {
            localObject4 = localObject1;
            localObject8 = localObject3;
            localObject1 = localObject7;
            localObject3 = localObject4;
            localObject4 = localObject8;
            break label2267;
          }
          localIntent2.putExtra((String)localObject8, (String)localObject7);
          break label2280;
        }
        if ((localObject3 == null) || (localObject1 == null) || ("".equals(localObject3)) || ("".equals(localObject1))) {
          break label2297;
        }
        if ((this.jdField_a_of_type_Boolean) && (JumpFilterHelper.a().a(this.jdField_a_of_type_AndroidContentContext, (String)localObject3, (String)localObject1))) {
          return false;
        }
        int i4 = 0;
        int i3 = i4;
        int i2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject7 = jdField_a_of_type_ArrayOfJavaLangString;
          int i5 = localObject7.length;
          i2 = 0;
          i3 = i4;
          if (i2 < i5)
          {
            if (!((String)localObject3).equals(localObject7[i2])) {
              continue;
            }
            i3 = 1;
          }
        }
        if (i3 == 0)
        {
          localIntent2.putExtra("vkey", (String)null);
          localIntent2.putExtra("sid", (String)null);
          localIntent2.putExtra("nickname", (String)null);
          localIntent2.putExtra("account", (String)null);
        }
        if (((String)localObject1).startsWith("com.qzone")) {
          localIntent2.putExtra("refer", "mqqActiveTab");
        }
        if (i1 != 0) {
          break label2234;
        }
        if (((String)localObject1).startsWith("com.qzone"))
        {
          QzonePluginProxyActivity.a(localIntent2, (String)localObject1);
          localIntent2.addFlags(536870912);
          try
          {
            QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localIntent2, -1);
            return true;
            i2 += 1;
          }
          catch (Exception localException1)
          {
            Intent localIntent1 = new Intent(this.jdField_a_of_type_AndroidContentContext, TranslucentActivity.class);
            localIntent1.addFlags(268435456);
            localIntent1.putExtras(localIntent2);
            this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
            continue;
          }
        }
        if (!localActivityNotFoundException.endsWith("NearbyTroopsActivity")) {
          break label1019;
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        localActivityNotFoundException.printStackTrace();
        return false;
      }
      String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tab_index");
      NearbyTroopsActivity.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 15, 0);
      if (!this.d) {
        break label2299;
      }
      str1 = "0";
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp", 0, 0, "", "", "", str1);
      continue;
      bool1 = str1.endsWith("PoiMapActivity");
      if (!bool1) {
        break;
      }
      try
      {
        localObject3 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if ((localObject3 != null) && (((ChatFragment)localObject3).a() != null))
        {
          ((ChatFragment)localObject3).a().as();
          localIntent2.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localObject7 = localIntent2.getStringExtra("lat");
          localObject4 = localIntent2.getStringExtra("lon");
          localObject3 = localIntent2.getStringExtra("loc");
          if ((localObject7 != null) && (localObject4 != null))
          {
            localObject7 = Double.valueOf((String)localObject7);
            localObject4 = Double.valueOf((String)localObject4);
            localIntent2.putExtra("url", "http://maps.google.com/maps?q=" + localObject7 + "," + localObject4 + "&iwloc=A&hl=zh-CN (" + (String)localObject3 + ")");
          }
          localIntent2.setClassName(this.jdField_a_of_type_AndroidContentContext.getPackageName(), str1);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent2, 18);
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    if ((!TextUtils.isEmpty(localException2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (localException2.equalsIgnoreCase("com.tencent.biz.coupon.CouponActivity")) && (((String)localObject3).equalsIgnoreCase("com.tencent.mobileqq")))
    {
      localObject8 = new StringBuffer();
      if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.type.get() > 0) && (this.c))
      {
        ((StringBuffer)localObject8).append("isRedLight=1");
        if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.type.has()) {
          ((StringBuffer)localObject8).append("&redType=" + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.type.get());
        }
        bool1 = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.buffer.has();
        if (!bool1) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = URLEncoder.encode(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.buffer.get(), "UTF-8");
        ((StringBuffer)localObject8).append("&couponBuffer=" + (String)localObject4);
        localObject7 = a("url");
        localObject4 = localObject7;
        if (!TextUtils.isEmpty((CharSequence)localObject7))
        {
          localObject4 = localObject7;
          if (QRUtils.f((String)localObject7)) {
            localObject4 = HtmlOffline.a((String)localObject7, ((StringBuffer)localObject8).toString());
          }
        }
        a((String)localObject4, (String)localObject3, localException2, localIntent2);
        f(localException2);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (!QLog.isColorLevel()) {
          break label2306;
        }
      }
      QLog.d("JumpAction", 2, localUnsupportedEncodingException.getMessage());
      break label2306;
      ((StringBuffer)localObject8).append("isRedLight=0");
      continue;
      Object localObject5;
      if ((!TextUtils.isEmpty(localException2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (localException2.equalsIgnoreCase("com.tencent.gamecenter.activities.GameCenterActivity")) && (((String)localObject3).equalsIgnoreCase("com.tencent.mobileqq")))
      {
        String str2 = a("url");
        if (TextUtils.isEmpty(str2)) {
          str2 = "http://gamecenter.qq.com/front/release/index/index.html";
        }
        for (;;)
        {
          localObject8 = "st=" + System.currentTimeMillis();
          localObject7 = localObject8;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            localObject7 = (String)localObject8 + "&uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          }
          localObject8 = localObject7;
          if (!TextUtils.isEmpty(this.gl)) {
            localObject8 = (String)localObject7 + "&" + this.gl;
          }
          localObject7 = localObject8;
          if (str2.indexOf("?") < 0) {
            localObject7 = (String)localObject8 + "&plat=qq&_wv=5127";
          }
          str2 = HtmlOffline.a(str2, (String)localObject7);
          if ((localException2.equalsIgnoreCase("com.tencent.gamecenter.activities.GameCenterActivity")) && (WebAccelerateHelper.getInstance().isEnableWebAio())) {}
          a(str2, (String)localObject3, localException2, localIntent2);
          f(localException2);
          if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, "enter gameCenter");
          }
          ThreadManager.a(new wap(this), 5, null, true);
          break;
          try
          {
            str2 = URLDecoder.decode(str2);
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            localObject5 = "http://gamecenter.qq.com/front/release/index/index.html";
          }
        }
      }
      if (localException2.endsWith("cooperation.readinjoy.ReadInJoyProxyActivity"))
      {
        if (!TextUtils.isEmpty(a("from")))
        {
          localIntent2.putExtra("readinjoy_launch_source", 4);
          localIntent2.putExtra("readinjoy_launch_style", localIntent2.getIntExtra("readinjoy_launch_style", 1) | 0x4);
          ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localIntent2);
          break label872;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800625F", "0X800625F", 0, 0, "", "", "", "");
        localIntent2.putExtra("readinjoy_launch_source", 1);
        localIntent2.putExtra("readinjoy_launch_start_time", System.currentTimeMillis());
        ((ReadInJoyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(localIntent2);
        ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localIntent2);
        break label872;
      }
      if (localException2.endsWith("NearbyTroopsActivity")) {
        localIntent2.putExtra("from", 15);
      }
      if (localException2.endsWith("JoinGroupTransitActivity")) {
        localIntent2.putExtra("source_scheme", this.fs);
      }
      if (localObject3 == null) {
        break label872;
      }
      bool1 = ((String)localObject3).equals(BaseApplicationImpl.getContext().getPackageName());
      if (bool1) {
        bool1 = false;
      }
      try
      {
        boolean bool2 = PluginProxyActivity.class.isAssignableFrom(BaseApplicationImpl.getContext().getClassLoader().loadClass(localException2));
        bool1 = bool2;
      }
      catch (Exception localException4)
      {
        for (;;) {}
      }
      if (bool1) {
        return false;
      }
      if (localException2.equalsIgnoreCase("com.tencent.biz.eqq.EnterpriseDetailActivity"))
      {
        localObject2 = "com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity";
        label2070:
        if (!"com.tencent.biz.pubaccount.AccountDetailActivity".equals(localObject2)) {
          break label2175;
        }
        localObject7 = localIntent2.getStringExtra("account_type");
        localObject5 = localObject2;
        if (localObject7 != null)
        {
          localObject5 = localObject2;
          if (Integer.parseInt((String)localObject7) == 2) {
            localObject5 = "com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity";
          }
        }
        localIntent2.putExtra("source", 2);
        localIntent2.addFlags(67108864);
        localObject2 = localObject5;
      }
      for (;;)
      {
        localIntent2.setClassName((String)localObject3, (String)localObject2);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
        f((String)localObject2);
        break;
        if (!((String)localObject2).equalsIgnoreCase("com.tencent.biz.troopbar.TroopBarDetailActivity")) {
          break label2264;
        }
        localObject2 = "com.tencent.biz.pubaccount.AccountDetailActivity";
        break label2070;
        label2175:
        localIntent2.addCategory("android.intent.category.LAUNCHER");
        localIntent2.addFlags(268435456);
      }
      localIntent2.setClassName((String)localObject3, (String)localObject2);
      localIntent2.addCategory("android.intent.category.LAUNCHER");
      localIntent2.addFlags(268435456);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
      break label872;
      label2234:
      if ((i1 != 1) || (TextUtils.isEmpty((CharSequence)localObject5))) {
        break label872;
      }
      bool1 = a(localIntent2, (String)localObject2, (String)localObject5);
      return bool1;
      for (;;)
      {
        label2264:
        label2267:
        localObject7 = localException4;
        localObject6 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject7;
        break;
        label2280:
        localObject7 = localObject2;
        localObject8 = localObject3;
        localObject2 = localObject6;
        localObject3 = localObject7;
        localObject6 = localObject8;
      }
      label2297:
      return false;
      label2299:
      Object localObject2 = "1";
      break label982;
      label2306:
      Object localObject6 = null;
    }
  }
  
  private boolean aM()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i2 = 0;
    try
    {
      i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      l2 = 0L;
    }
    catch (Exception localException2)
    {
      try
      {
        l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
        localBundle = new Bundle();
        localBundle.putString("title", (String)localObject2);
        localBundle.putString("desc", (String)localObject4);
        localBundle.putString("image_url", str1);
        localBundle.putString("detail_url", str2);
        localBundle.putLong("req_share_id", l1);
        localBundle.putString("pkg_name", this.gh);
        localBundle.putString("image_url_remote", str3);
        localBundle.putString("app_name", (String)localObject1);
        localBundle.putString("open_id", str4);
        localBundle.putString("share_uin", str5);
        localBundle.putString("jfrom", str6);
        localBundle.putString("share_qq_ext_str", str7);
        localBundle.putInt("cflag", i1);
        localBundle.putInt("forward_type", 11);
        i2 = 1;
      }
      catch (Exception localException2)
      {
        try
        {
          long l2;
          do
          {
            for (;;)
            {
              Bundle localBundle;
              i1 = Integer.valueOf((String)localObject6).intValue();
              localBundle.putInt("req_type", i1);
              if (2 != i1) {
                break label830;
              }
              localBundle.putString("audio_url", (String)localObject5);
              if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject4)))
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break;
                }
                localBundle.putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131366005), new Object[] { localObject1 }));
              }
              com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
              localBundle.putBoolean("MigSdkShareNotDone", true);
              ((Intent)localObject1).putExtras(localBundle);
              ((Intent)localObject1).addFlags(268435456);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              return true;
              localException1 = localException1;
              i1 = i2;
              if (QLog.isColorLevel())
              {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                i1 = i2;
              }
            }
            localException2 = localException2;
            l1 = l2;
          } while (!QLog.isColorLevel());
          QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
          long l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int i1;
          label830:
          label898:
          label1165:
          label1173:
          do
          {
            for (;;)
            {
              i1 = i2;
              if (QLog.isColorLevel())
              {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + (String)localObject6);
                i1 = i2;
                continue;
                localException2.putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131366006));
                continue;
                if (6 == i1)
                {
                  localObject1 = "";
                  if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                    localObject1 = localObject2;
                  }
                  localObject2 = localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                      break label898;
                    }
                  }
                  for (localObject2 = localObject4;; localObject2 = (String)localObject1 + "\n" + (String)localObject4)
                  {
                    localException2.putString("forward_text", (String)localObject2);
                    localException2.putBoolean("isFromShare", true);
                    localException2.putBoolean("key_sdk_share_pure_text", true);
                    break;
                  }
                }
                if (5 != i1) {
                  break;
                }
                localObject2 = null;
                localObject1 = null;
                localObject6 = new ArrayList();
                Object localObject3;
                if (!TextUtils.isEmpty(str1))
                {
                  String[] arrayOfString = str1.split(";");
                  i1 = 0;
                  localObject4 = null;
                  for (;;)
                  {
                    localObject5 = localObject4;
                    localObject2 = localObject1;
                    if (i1 >= arrayOfString.length) {
                      break label1173;
                    }
                    localObject5 = "";
                    try
                    {
                      localObject2 = URLDecoder.decode(arrayOfString[i1], "UTF-8");
                      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                        if ((((String)localObject2).startsWith("/")) && (new File((String)localObject2).exists()))
                        {
                          ((ArrayList)localObject6).add(localObject2);
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                            break label1165;
                          }
                          i1 += 1;
                          localObject1 = localObject2;
                        }
                      }
                    }
                    catch (UnsupportedEncodingException localUnsupportedEncodingException)
                    {
                      for (;;)
                      {
                        localObject3 = localObject5;
                        if (QLog.isColorLevel())
                        {
                          QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + arrayOfString[i1]);
                          localObject3 = localObject5;
                          continue;
                          if (((String)localObject3).startsWith("http"))
                          {
                            ((ArrayList)localObject6).add(localObject3);
                            if (TextUtils.isEmpty((CharSequence)localObject4))
                            {
                              localObject4 = localObject3;
                              localObject3 = localObject1;
                              continue;
                              if (QLog.isColorLevel()) {
                                QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + (String)localObject3);
                              }
                            }
                          }
                          localObject3 = localObject1;
                        }
                      }
                    }
                  }
                }
                localObject5 = null;
                localException2.putString("image_url", (String)localObject3);
                localException2.putString("image_url_remote", (String)localObject5);
                localException2.putString("title", null);
                localException2.putString("desc", null);
                if (1 == ((ArrayList)localObject6).size())
                {
                  localObject1 = localObject3;
                  if (TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    localObject1 = localObject3;
                    if (!TextUtils.isEmpty((CharSequence)localObject5))
                    {
                      localException2.putString("image_url", (String)localObject5);
                      localObject1 = localObject5;
                    }
                  }
                  if (FileManagerUtil.a((String)localObject1) == 0)
                  {
                    localException2.putInt("req_type", 5);
                  }
                  else
                  {
                    localException2.putString("forward_text", "已选择" + FileManagerUtil.a((String)localObject1) + "。");
                    localException2.putBoolean("qdshare_file", true);
                    localException2.putBoolean("isFromShare", true);
                    localException2.putBoolean("key_sdk_share_pure_text", true);
                    localException2.putInt("req_type", 6);
                  }
                }
                else if (FileManagerUtil.a((String)localObject3) == 0)
                {
                  localException2.putString("title", ((ArrayList)localObject6).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131365962));
                  localException2.putString("qqfav_extra_multi_pic_path_list", str1);
                  localException2.putBoolean("qqfav_extra_multi_pic", true);
                  localException2.putInt("req_type", 1);
                }
                else
                {
                  localException2.putString("forward_text", "已选择" + FileManagerUtil.a((String)localObject3) + "等" + ((ArrayList)localObject6).size() + "个文件。");
                  localException2.putString("qqfav_extra_multi_pic_path_list", str1);
                  localException2.putBoolean("qdshare_file", true);
                  localException2.putBoolean("isFromShare", true);
                  localException2.putBoolean("key_sdk_share_pure_text", true);
                  localException2.putInt("req_type", 6);
                }
              }
            }
          } while (1 == i1);
        }
      }
    }
    return false;
  }
  
  private boolean aN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, " source:" + this.fs + "  serverName:" + this.ft + "  hostName:" + this.fu);
    }
    Object localObject1;
    if (this.fu.equals("index"))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
      ((Intent)localObject1).addFlags(268435456);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (!this.fu.equals("detail")) {
              break;
            }
          } while (TextUtils.isEmpty(this.fs));
          localObject1 = Common.i() + File.separator + "qapp_center_detail.htm";
          if (new File((String)localObject1).exists()) {}
          for (localObject1 = "file:///" + (String)localObject1;; localObject1 = Common.p() + File.separator + "qapp_center_detail.htm")
          {
            localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppWebViewActivity.class);
            ((Intent)localObject2).addFlags(268435456);
            localObject3 = new Bundle();
            localObject4 = Uri.parse(this.fs).getQueryParameter("param");
            ((Bundle)localObject3).putString("APP_URL", (String)localObject1);
            ((Bundle)localObject3).putString("APP_PARAMS", "&" + (String)localObject4);
            ((Intent)localObject2).putExtras((Bundle)localObject3);
            ((Intent)localObject2).putExtra("adapter_action", "action_app_detail");
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            return true;
          }
          if (!this.fu.equals("webview")) {
            break;
          }
        } while (TextUtils.isEmpty(this.fs));
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppWebViewActivity.class);
        ((Intent)localObject1).addFlags(268435456);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("APP_URL", Uri.parse(this.fs).getQueryParameter("url"));
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return true;
      } while ((!this.fu.equals("local")) || (TextUtils.isEmpty(this.fs)));
      localObject2 = Uri.parse(this.fs);
      localObject1 = ((Uri)localObject2).getQueryParameter("title");
      localObject3 = Common.a(((Uri)localObject2).getQueryParameter("url"));
    } while (localObject3.length <= 1);
    Object localObject2 = localObject3[0];
    Object localObject3 = localObject3[1];
    Object localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppWebViewActivity.class);
    ((Intent)localObject4).addFlags(268435456);
    Bundle localBundle = new Bundle();
    localBundle.putString("APP_URL", (String)localObject2);
    localObject2 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((ArrayList)localObject2).add(localObject1);
    }
    localBundle.putStringArrayList("titleName", (ArrayList)localObject2);
    if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
      localBundle.putString("APP_PARAMS", (String)localObject3);
    }
    ((Intent)localObject4).putExtras(localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
    return true;
  }
  
  private boolean aO()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_AndroidContentContext, 9, null);
    return true;
  }
  
  private boolean aP()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("feedsid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fsc");
    int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("fst"));
    Intent localIntent = new Intent();
    localIntent.putExtra("_feed_id_", str1);
    localIntent.putExtra("_src_code_", str2);
    localIntent.putExtra("_src_type_", i1);
    localIntent.putExtra("_from_", 1);
    DingdongPluginHelper.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, "com.dingdong.business.base.activity.DingdongDetailActivity", localIntent, -1);
    return true;
  }
  
  private boolean aQ()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("schedule_id");
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.putExtra("schedule_feed_id", str);
    localIntent.putExtra("from_url", true);
    DingdongPluginHelper.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, "com.dingdong.business.Schedule.Activity.ScheduleListActivity", localIntent, -1);
    return true;
  }
  
  private boolean aR()
  {
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1, "UTF-8");
      str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopbar_id"));
    }
    catch (Exception localException3)
    {
      try
      {
        l1 = Long.parseLong((String)localObject2);
        localObject2 = new JSONObject();
      }
      catch (Exception localException3)
      {
        try
        {
          for (;;)
          {
            String str5;
            ((JSONObject)localObject2).put("share_from_app", true);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("share_img_list", localObject1);
            localJSONObject.put("share_title", str2);
            localJSONObject.put("share_content", str3);
            localJSONObject.put("share_app_name", str4);
            localJSONObject.put("share_app_id", l1);
            ((JSONObject)localObject2).put("share_info", localJSONObject);
            ((JSONObject)localObject2).put("bid", str5);
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopBarPublishActivity.class);
            ((Intent)localObject1).addFlags(268435456);
            ((Intent)localObject1).putExtra("options", ((JSONObject)localObject2).toString());
            ((Intent)localObject1).putExtra("pkg_name", this.gh);
            com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            return true;
            localException1 = localException1;
            String str1 = "";
          }
          localException3 = localException3;
          long l1 = 0L;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "gotoTroopBarShareMsg Exception:" + localException2.toString());
            }
          }
        }
      }
    }
  }
  
  private boolean aS()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DeviceQRAgentActivity.class);
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.fs;
    }
    localIntent.putExtra("qrurl", str1);
    localIntent.putExtra("entrance", 2);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aT()
  {
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.fs;
    }
    for (;;)
    {
      try
      {
        localObject1 = URLUtil.a((String)localObject1);
        if (((Map)localObject1).get("public_device") != null)
        {
          i1 = 1;
          localObject2 = URLUtil.b((String)((Map)localObject1).get("args"));
          localObject1 = (String)((Map)localObject2).get("sn");
          localObject2 = (String)((Map)localObject2).get("pid");
          if ((i1 != 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))))
          {
            ToastUtil.a().a(this.jdField_a_of_type_AndroidContentContext.getString(2131362443));
            return true;
          }
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DeviceShareAgentActivity.class);
          localIntent.putExtra("DevicePID", (String)localObject2);
          localIntent.putExtra("DeviceSN", (String)localObject1);
          localIntent.putExtra("DeviceToken", "");
          localIntent.putExtra("public_device", i1);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          return true;
        }
      }
      catch (Exception localException)
      {
        return false;
      }
      int i1 = 0;
    }
  }
  
  private boolean aU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.send_hong_bao", 2, "JumpAction.gotoSendHongBao(). hong_bao_id=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id") + ", send_uin=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin") + ", hong_bao_type=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type") + ", hong_bao_summary=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("hb_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id"));
    localIntent.putExtra("send_uin", (String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin"));
    localIntent.putExtra("hb_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type"));
    localIntent.putExtra("forward_text", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
    localIntent.putExtra("forward_type", 17);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, localIntent);
    return true;
  }
  
  private boolean aV()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friendUin"));
    localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, "", 3001, 0, "", "", null, "", "");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean aa()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {}
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a((Activity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  private boolean ab()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopCreateEnterActivity.class);
    localIntent.putExtra("from", 4);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("initgrouptype");
    if (("1".equals(str)) || ("0".equals(str)) || ("2".equals(str))) {
      localIntent.putExtra("troopType", str);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ac()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupuin");
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localFragmentActivity.getChatFragment().a() instanceof TroopChatPie))
      {
        TroopChatPie localTroopChatPie = (TroopChatPie)localFragmentActivity.getChatFragment().a();
        if ((localTroopChatPie != null) && (localTroopChatPie.a != null) && (((String)localObject).equals(localTroopChatPie.a.jdField_a_of_type_JavaLangString)))
        {
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
          ((Intent)localObject).putExtra("video_play_url", str);
          ((TroopChatPie)localFragmentActivity.getChatFragment().a()).l((Intent)localObject);
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean ad()
  {
    EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7);
    return true;
  }
  
  private boolean ae()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    localIntent.putExtra("nickname", (String)localObject);
    localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if ((!str.equals("version")) && (!str.equals("src_type"))) {
        localIntent.putExtra(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
    }
    return a(localIntent, "cooperation.qqreader.QRBridgeActivity", "qqreaderplugin.apk");
  }
  
  /* Error */
  private boolean af()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 651
    //   7: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 1067	java/lang/String
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 654
    //   22: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 1067	java/lang/String
    //   28: astore 6
    //   30: aload 5
    //   32: ifnull +140 -> 172
    //   35: aload 6
    //   37: ifnull +135 -> 172
    //   40: aload 5
    //   42: invokevirtual 1670	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 1281	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 2857
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 6
    //   56: invokevirtual 1670	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 1281	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 7
    //   64: iload 7
    //   66: i2d
    //   67: ldc2_w 2857
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   77: ldc_w 446
    //   80: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: checkcast 1067	java/lang/String
    //   86: invokespecial 1477	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   89: pop
    //   90: new 1185	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 1186	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 2472
    //   100: invokevirtual 1192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: dload_3
    //   104: invokevirtual 2861	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   107: ldc_w 2477
    //   110: invokevirtual 1192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: dload_1
    //   114: invokevirtual 2861	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   117: ldc_w 2863
    //   120: invokevirtual 1192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 1196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 5
    //   128: new 1117	android/content/Intent
    //   131: dup
    //   132: ldc_w 1747
    //   135: aload 5
    //   137: invokestatic 1767	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   140: invokespecial 2866	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   143: astore 6
    //   145: aload 6
    //   147: ldc_w 2868
    //   150: ldc_w 2870
    //   153: invokevirtual 1842	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   156: pop
    //   157: aload_0
    //   158: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   161: aload 6
    //   163: invokevirtual 1154	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore 5
    //   170: iconst_0
    //   171: ireturn
    //   172: iconst_0
    //   173: ireturn
    //   174: astore 6
    //   176: aload_0
    //   177: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   180: new 1117	android/content/Intent
    //   183: dup
    //   184: ldc_w 1747
    //   187: aload 5
    //   189: invokestatic 1767	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   192: invokespecial 2866	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   195: invokevirtual 1154	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   198: goto -32 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	JumpAction
    //   53	61	1	d1	double
    //   71	33	3	d2	double
    //   13	123	5	str	String
    //   168	20	5	localException	Exception
    //   28	134	6	localObject	Object
    //   174	1	6	localActivityNotFoundException	ActivityNotFoundException
    //   62	3	7	i1	int
    // Exception table:
    //   from	to	target	type
    //   40	64	168	java/lang/Exception
    //   157	166	174	android/content/ActivityNotFoundException
  }
  
  private boolean ag()
  {
    if ("webview".equals(this.gg))
    {
      c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", this.fx).putExtra("callback_type", this.fy).putExtra("callback_name", this.fz));
    }
    return true;
  }
  
  private boolean ah()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("card_type");
    if ((str != null) && ("group".equals(str))) {
      return am();
    }
    if ((str != null) && ("public_account".equals(str))) {
      return aj();
    }
    if ((str != null) && ("troopmember".equals(str))) {
      return an();
    }
    if ((str != null) && ("crm".equals(str))) {
      return ak();
    }
    return al();
  }
  
  private boolean ai()
  {
    String str1;
    String str3;
    label54:
    Object localObject3;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("mode"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label124;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("source_id")) {
        break label131;
      }
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source_id");
      if (TextUtils.isEmpty(str1)) {
        break label778;
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.valueOf(str1).intValue();
        if ((i1 != 1) && (i1 != 2) && (i1 != 3))
        {
          return false;
          str1 = "";
          break;
          label124:
          str3 = "";
          break label54;
          label131:
          localObject3 = "";
        }
      }
      catch (Exception localException1)
      {
        i1 = -1;
        continue;
        switch (i1)
        {
        }
      }
      label172:
      return true;
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      }
      for (;;)
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
        label243:
        label324:
        label332:
        label362:
        boolean bool;
        if (Utils.a(localObject3, "1001"))
        {
          String str4;
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uid"))
          {
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uid");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("PUSH_CONTENT")) {
              break label324;
            }
          }
          for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PUSH_CONTENT");; str5 = "")
          {
            if (Utils.a(str4, localObject1)) {
              break label332;
            }
            if (QLog.isColorLevel()) {
              QLog.i("JumpAction", 2, "gotoNearybyProfile,return caused by different uid");
            }
            return true;
            if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
              break label771;
            }
            localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
            break;
            str4 = "";
            break label243;
          }
          localIntent.putExtra("PUSH_CONTENT", str5);
          localIntent.putExtra("frome_where", -1);
          localIntent.addFlags(67108864);
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 0);
          localIntent.putExtra("param_mode", i1);
          localIntent.putExtra("AllInOne", (Parcelable)localObject1);
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).equals("1000"))) {
            break label530;
          }
          bool = true;
          label413:
          localIntent.putExtra("param_from_interest_test", bool);
          if ("10002".endsWith(str3))
          {
            localIntent.putExtra("abp_flag", true);
            localIntent.addFlags(268435456);
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tinnyid")) {
            localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tinnyid");
          }
        }
        long l1;
        for (;;)
        {
          try
          {
            bool = TextUtils.isEmpty((CharSequence)localObject1);
            if (!bool) {
              continue;
            }
            l1 = 0L;
          }
          catch (Exception localException2)
          {
            label530:
            l1 = 0L;
            continue;
          }
          localIntent.putExtra("param_tiny_id", l1);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          break;
          localIntent.putExtra("is_from_web", true);
          break label362;
          bool = false;
          break label413;
          l1 = Long.valueOf((String)localObject1).longValue();
        }
        Object localObject2;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tinnyid"))
        {
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tinnyid");
          label582:
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {
            break label745;
          }
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
        }
        for (;;)
        {
          try
          {
            bool = TextUtils.isEmpty((CharSequence)localObject2);
            if (!bool) {
              continue;
            }
            l1 = 0L;
          }
          catch (Exception localException3)
          {
            label745:
            l1 = 0L;
            continue;
          }
          if ((l1 == 0L) && (TextUtils.isEmpty((CharSequence)localObject3))) {
            break;
          }
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 41);
          localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
          ((Intent)localObject3).putExtra("AllInOne", (Parcelable)localObject2);
          ((Intent)localObject3).putExtra("param_mode", 3);
          ((Intent)localObject3).putExtra("param_tiny_id", l1);
          if ("10002".endsWith(str3))
          {
            ((Intent)localObject3).putExtra("abp_flag", true);
            ((Intent)localObject3).addFlags(268435456);
          }
          ((Intent)localObject3).putExtra("is_from_web", true);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
          break label172;
          localObject2 = "";
          break label582;
          localObject3 = "";
          continue;
          l1 = Long.valueOf((String)localObject2).longValue();
        }
        label771:
        String str2 = "";
      }
      label778:
      int i1 = -1;
    }
  }
  
  private boolean aj()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag");
    int i1 = -1;
    try
    {
      int i2 = Integer.parseInt(str);
      i1 = i2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoShowPublicAccountCard uin: " + (String)localObject + " | accountFlag: " + i1 + " | current uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    if ((localObject == null) || ("".equals(localObject)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject))) {
      return false;
    }
    if (((String)localObject).length() < 5) {
      return false;
    }
    if (f())
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = new ProfileParams.Builder();
        ((ProfileParams.Builder)localObject).a(new ProfileParams.CurLoginUsr((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"), (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"))).d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")).c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).a(i1).b((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
        PublicAccountUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ProfileParams.Builder)localObject).a());
        return false;
      }
    }
    else
    {
      PublicAccountUtil.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject, i1);
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
    }
    return true;
  }
  
  private boolean ak()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoShowCrmCard uin: " + str + " | current uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    if ((str == null) || ("".equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(str))) {
      return false;
    }
    if (str.length() < 5) {
      return false;
    }
    PublicAccountUtil.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str, -7);
    return true;
  }
  
  private boolean al()
  {
    boolean bool = false;
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpa");
    if ((localObject == null) || ("".equals(localObject)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject))) {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    }
    for (;;)
    {
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
      bool = true;
      do
      {
        return bool;
      } while (((String)localObject).length() < 5);
      Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c((String)localObject);
      if ((localFriends != null) && (localFriends.isFriend()))
      {
        localObject = new ProfileActivity.AllInOne((String)localObject, 1);
        ((ProfileActivity.AllInOne)localObject).h = localFriends.name;
        ((ProfileActivity.AllInOne)localObject).i = localFriends.remark;
      }
      else
      {
        if (this.jdField_b_of_type_Boolean)
        {
          localObject = new ProfileActivity.AllInOne((String)localObject, 3);
          if ("1".equals(str)) {}
          for (int i1 = 1;; i1 = 0)
          {
            ((ProfileActivity.AllInOne)localObject).d = i1;
            break;
          }
        }
        localObject = new ProfileActivity.AllInOne((String)localObject, 78);
      }
    }
  }
  
  private boolean am()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wSourceSubID");
    if ((str2 == null) || ("".equals(str2)) || (str2.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ("QRJumpActivity".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
      localObject1 = TroopInfoActivity.a(str2, 14);
    }
    for (;;)
    {
      if ("d2g".equals(this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
      {
        localObject1 = TroopInfoActivity.a(str2, 16);
        ((Bundle)localObject1).putInt("D2GType", 2);
      }
      Object localObject3 = localObject1;
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search"))) {}
      try
      {
        localObject1 = TroopInfoActivity.a(str2, Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search")));
        if ("h5".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
          localObject1 = TroopInfoActivity.a(str2, 22);
        }
        try
        {
          i1 = Integer.parseInt(str1);
          ((Bundle)localObject1).putInt("troop_info_from_ex", i1);
          if (i1 != 33) {
            break label278;
          }
          ((Bundle)localObject1).putInt("troop_info_from", 24);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int i1;
            Object localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("JumpAction", 2, "cast source sub id from web error, sourceSubId = " + str1);
              continue;
              if (i1 == 37) {
                ((Bundle)localObject2).putInt("troop_info_from", 30);
              }
            }
          }
        }
        ((Bundle)localObject1).putString("authKey", (String)this.jdField_a_of_type_JavaUtilHashMap.get("authKey"));
        ChatSettingForTroop.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
        return true;
        localObject1 = TroopInfoActivity.a(str2, 5);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject2 = localObject3;
          continue;
          label278:
          if (i1 != 36) {
            break;
          }
          ((Bundle)localObject2).putInt("troop_info_from", 27);
        }
      }
    }
  }
  
  /* Error */
  private boolean an()
  {
    // Byte code:
    //   0: ldc_w 1158
    //   3: astore 14
    //   5: ldc_w 1158
    //   8: astore 19
    //   10: ldc_w 1158
    //   13: astore 17
    //   15: ldc_w 1158
    //   18: astore 10
    //   20: ldc_w 1158
    //   23: astore 18
    //   25: aload_0
    //   26: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   29: ldc_w 284
    //   32: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 1067	java/lang/String
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   43: ldc_w 609
    //   46: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 1067	java/lang/String
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   57: ldc_w 397
    //   60: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 1067	java/lang/String
    //   66: astore_2
    //   67: aload_0
    //   68: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   71: ldc_w 606
    //   74: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: checkcast 1067	java/lang/String
    //   80: astore 4
    //   82: aload 18
    //   84: astore 12
    //   86: aload 10
    //   88: astore 7
    //   90: aload 17
    //   92: astore 5
    //   94: aload 19
    //   96: astore 15
    //   98: aload 14
    //   100: astore 11
    //   102: aload 18
    //   104: astore 13
    //   106: aload 10
    //   108: astore 8
    //   110: aload 17
    //   112: astore 6
    //   114: aload 19
    //   116: astore 16
    //   118: aload_0
    //   119: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   122: ldc_w 612
    //   125: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: checkcast 1067	java/lang/String
    //   131: ldc_w 3035
    //   134: invokestatic 2630	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 9
    //   139: aload 18
    //   141: astore 12
    //   143: aload 10
    //   145: astore 7
    //   147: aload 17
    //   149: astore 5
    //   151: aload 19
    //   153: astore 15
    //   155: aload 9
    //   157: astore 11
    //   159: aload 18
    //   161: astore 13
    //   163: aload 10
    //   165: astore 8
    //   167: aload 17
    //   169: astore 6
    //   171: aload 19
    //   173: astore 16
    //   175: aload 9
    //   177: astore 14
    //   179: aload_0
    //   180: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   183: ldc_w 615
    //   186: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: checkcast 1067	java/lang/String
    //   192: ldc_w 3035
    //   195: invokestatic 2630	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   198: astore 19
    //   200: aload 18
    //   202: astore 12
    //   204: aload 10
    //   206: astore 7
    //   208: aload 17
    //   210: astore 5
    //   212: aload 19
    //   214: astore 15
    //   216: aload 9
    //   218: astore 11
    //   220: aload 18
    //   222: astore 13
    //   224: aload 10
    //   226: astore 8
    //   228: aload 17
    //   230: astore 6
    //   232: aload 19
    //   234: astore 16
    //   236: aload 9
    //   238: astore 14
    //   240: aload_0
    //   241: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   244: ldc_w 757
    //   247: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   250: checkcast 1067	java/lang/String
    //   253: ldc_w 3035
    //   256: invokestatic 2630	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 17
    //   261: aload 18
    //   263: astore 12
    //   265: aload 10
    //   267: astore 7
    //   269: aload 17
    //   271: astore 5
    //   273: aload 19
    //   275: astore 15
    //   277: aload 9
    //   279: astore 11
    //   281: aload 18
    //   283: astore 13
    //   285: aload 10
    //   287: astore 8
    //   289: aload 17
    //   291: astore 6
    //   293: aload 19
    //   295: astore 16
    //   297: aload 9
    //   299: astore 14
    //   301: aload_0
    //   302: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   305: ldc_w 760
    //   308: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: checkcast 1067	java/lang/String
    //   314: ldc_w 3035
    //   317: invokestatic 2630	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   320: astore 10
    //   322: aload 18
    //   324: astore 12
    //   326: aload 10
    //   328: astore 7
    //   330: aload 17
    //   332: astore 5
    //   334: aload 19
    //   336: astore 15
    //   338: aload 9
    //   340: astore 11
    //   342: aload 18
    //   344: astore 13
    //   346: aload 10
    //   348: astore 8
    //   350: aload 17
    //   352: astore 6
    //   354: aload 19
    //   356: astore 16
    //   358: aload 9
    //   360: astore 14
    //   362: aload_0
    //   363: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   366: ldc_w 763
    //   369: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   372: checkcast 1067	java/lang/String
    //   375: ldc_w 3035
    //   378: invokestatic 2630	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   381: astore 18
    //   383: aload 18
    //   385: astore 12
    //   387: aload 10
    //   389: astore 7
    //   391: aload 17
    //   393: astore 5
    //   395: aload 19
    //   397: astore 15
    //   399: aload 9
    //   401: astore 11
    //   403: aload 18
    //   405: astore 13
    //   407: aload 10
    //   409: astore 8
    //   411: aload 17
    //   413: astore 6
    //   415: aload 19
    //   417: astore 16
    //   419: aload 9
    //   421: astore 14
    //   423: aload_0
    //   424: getfield 1114	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   427: ldc_w 766
    //   430: invokevirtual 1145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   433: checkcast 1067	java/lang/String
    //   436: ldc_w 3035
    //   439: invokestatic 2630	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   442: astore 20
    //   444: aload_1
    //   445: astore 7
    //   447: aload 20
    //   449: astore_1
    //   450: aload 17
    //   452: astore 8
    //   454: aload_2
    //   455: astore 6
    //   457: aload 18
    //   459: astore_2
    //   460: aload 10
    //   462: astore 5
    //   464: aload 9
    //   466: astore 11
    //   468: aload 19
    //   470: astore 9
    //   472: aload_3
    //   473: astore 10
    //   475: aload 6
    //   477: invokestatic 1319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   480: ifne +11 -> 491
    //   483: aload 7
    //   485: invokestatic 1319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   488: ifeq +149 -> 637
    //   491: iconst_0
    //   492: ireturn
    //   493: astore 9
    //   495: ldc_w 1158
    //   498: astore 10
    //   500: ldc_w 1158
    //   503: astore_1
    //   504: ldc_w 1158
    //   507: astore_3
    //   508: ldc_w 1158
    //   511: astore 6
    //   513: ldc_w 1158
    //   516: astore 5
    //   518: ldc_w 1158
    //   521: astore 4
    //   523: ldc_w 1158
    //   526: astore 8
    //   528: ldc_w 1158
    //   531: astore 7
    //   533: ldc_w 1158
    //   536: astore_2
    //   537: aload 9
    //   539: invokevirtual 1705	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   542: aload 8
    //   544: astore 9
    //   546: aload 5
    //   548: astore 8
    //   550: aload_2
    //   551: astore 5
    //   553: aload_1
    //   554: astore_2
    //   555: ldc_w 1158
    //   558: astore_1
    //   559: aload_3
    //   560: astore 11
    //   562: goto -87 -> 475
    //   565: astore 9
    //   567: ldc_w 1158
    //   570: astore 10
    //   572: ldc_w 1158
    //   575: astore_1
    //   576: ldc_w 1158
    //   579: astore_3
    //   580: ldc_w 1158
    //   583: astore 6
    //   585: ldc_w 1158
    //   588: astore 5
    //   590: ldc_w 1158
    //   593: astore 4
    //   595: ldc_w 1158
    //   598: astore 8
    //   600: ldc_w 1158
    //   603: astore 7
    //   605: ldc_w 1158
    //   608: astore_2
    //   609: aload 9
    //   611: invokevirtual 3036	java/lang/NullPointerException:printStackTrace	()V
    //   614: aload 8
    //   616: astore 9
    //   618: aload 5
    //   620: astore 8
    //   622: aload_2
    //   623: astore 5
    //   625: aload_1
    //   626: astore_2
    //   627: ldc_w 1158
    //   630: astore_1
    //   631: aload_3
    //   632: astore 11
    //   634: goto -159 -> 475
    //   637: aload_0
    //   638: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   641: ifnull +171 -> 812
    //   644: new 1117	android/content/Intent
    //   647: dup
    //   648: aload_0
    //   649: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   652: ldc_w 3038
    //   655: invokespecial 1216	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   658: astore_3
    //   659: aload_3
    //   660: ldc_w 3040
    //   663: aload 7
    //   665: invokevirtual 1148	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   668: pop
    //   669: aload_3
    //   670: ldc_w 3042
    //   673: new 1185	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 1186	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 1158
    //   683: invokevirtual 1192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload 6
    //   688: invokevirtual 1192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 1196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokevirtual 1148	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   697: pop
    //   698: ldc 62
    //   700: aload 10
    //   702: invokevirtual 1211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   705: ifeq +145 -> 850
    //   708: aload_3
    //   709: ldc_w 3044
    //   712: iconst_0
    //   713: invokevirtual 1139	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   716: pop
    //   717: new 1450	android/os/Bundle
    //   720: dup
    //   721: invokespecial 1451	android/os/Bundle:<init>	()V
    //   724: astore 6
    //   726: aload 6
    //   728: ldc_w 609
    //   731: aload 4
    //   733: invokevirtual 1459	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   736: aload 6
    //   738: ldc_w 612
    //   741: aload 11
    //   743: invokevirtual 1459	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   746: aload 6
    //   748: ldc_w 615
    //   751: aload 9
    //   753: invokevirtual 1459	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: aload 6
    //   758: ldc_w 757
    //   761: aload 8
    //   763: invokevirtual 1459	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   766: aload 6
    //   768: ldc_w 760
    //   771: aload 5
    //   773: invokevirtual 1459	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   776: aload 6
    //   778: ldc_w 763
    //   781: aload_2
    //   782: invokevirtual 1459	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload 6
    //   787: ldc_w 766
    //   790: aload_1
    //   791: invokevirtual 1459	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload_3
    //   795: ldc_w 439
    //   798: aload 6
    //   800: invokevirtual 2150	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   803: pop
    //   804: aload_0
    //   805: getfield 1107	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   808: aload_3
    //   809: invokevirtual 1154	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   812: aload_0
    //   813: getfield 1109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   816: ldc_w 1156
    //   819: ldc_w 1158
    //   822: ldc_w 1158
    //   825: ldc_w 3046
    //   828: ldc_w 3046
    //   831: iconst_0
    //   832: iconst_0
    //   833: ldc_w 1158
    //   836: ldc_w 1158
    //   839: ldc_w 1158
    //   842: ldc_w 1158
    //   845: invokestatic 1165	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   848: iconst_1
    //   849: ireturn
    //   850: aload_3
    //   851: ldc_w 3044
    //   854: bipush 6
    //   856: invokevirtual 1139	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   859: pop
    //   860: goto -143 -> 717
    //   863: astore 9
    //   865: ldc_w 1158
    //   868: astore_1
    //   869: ldc_w 1158
    //   872: astore 4
    //   874: ldc_w 1158
    //   877: astore 6
    //   879: ldc_w 1158
    //   882: astore 5
    //   884: ldc_w 1158
    //   887: astore 11
    //   889: ldc_w 1158
    //   892: astore 8
    //   894: ldc_w 1158
    //   897: astore 7
    //   899: ldc_w 1158
    //   902: astore_2
    //   903: aload_3
    //   904: astore 10
    //   906: aload 4
    //   908: astore_3
    //   909: aload 11
    //   911: astore 4
    //   913: goto -304 -> 609
    //   916: astore 9
    //   918: ldc_w 1158
    //   921: astore_2
    //   922: ldc_w 1158
    //   925: astore 4
    //   927: ldc_w 1158
    //   930: astore 8
    //   932: aload_1
    //   933: astore 7
    //   935: ldc_w 1158
    //   938: astore_1
    //   939: ldc_w 1158
    //   942: astore 11
    //   944: ldc_w 1158
    //   947: astore 5
    //   949: ldc_w 1158
    //   952: astore 6
    //   954: aload_3
    //   955: astore 10
    //   957: aload 11
    //   959: astore_3
    //   960: goto -351 -> 609
    //   963: astore 9
    //   965: ldc_w 1158
    //   968: astore 5
    //   970: aload_2
    //   971: astore 6
    //   973: ldc_w 1158
    //   976: astore_2
    //   977: ldc_w 1158
    //   980: astore 4
    //   982: ldc_w 1158
    //   985: astore 8
    //   987: aload_1
    //   988: astore 7
    //   990: ldc_w 1158
    //   993: astore_1
    //   994: ldc_w 1158
    //   997: astore 11
    //   999: aload_3
    //   1000: astore 10
    //   1002: aload 11
    //   1004: astore_3
    //   1005: goto -396 -> 609
    //   1008: astore 10
    //   1010: aload 15
    //   1012: astore 8
    //   1014: aload_1
    //   1015: astore 9
    //   1017: aload 12
    //   1019: astore_1
    //   1020: aload 11
    //   1022: astore 6
    //   1024: aload 10
    //   1026: astore 11
    //   1028: aload_2
    //   1029: astore 12
    //   1031: aload 7
    //   1033: astore_2
    //   1034: aload_3
    //   1035: astore 10
    //   1037: aload 6
    //   1039: astore_3
    //   1040: aload 12
    //   1042: astore 6
    //   1044: aload 9
    //   1046: astore 7
    //   1048: aload 11
    //   1050: astore 9
    //   1052: goto -443 -> 609
    //   1055: astore 9
    //   1057: ldc_w 1158
    //   1060: astore_1
    //   1061: ldc_w 1158
    //   1064: astore 4
    //   1066: ldc_w 1158
    //   1069: astore 6
    //   1071: ldc_w 1158
    //   1074: astore 5
    //   1076: ldc_w 1158
    //   1079: astore 11
    //   1081: ldc_w 1158
    //   1084: astore 8
    //   1086: ldc_w 1158
    //   1089: astore 7
    //   1091: ldc_w 1158
    //   1094: astore_2
    //   1095: aload_3
    //   1096: astore 10
    //   1098: aload 4
    //   1100: astore_3
    //   1101: aload 11
    //   1103: astore 4
    //   1105: goto -568 -> 537
    //   1108: astore 9
    //   1110: ldc_w 1158
    //   1113: astore_2
    //   1114: ldc_w 1158
    //   1117: astore 4
    //   1119: ldc_w 1158
    //   1122: astore 8
    //   1124: aload_1
    //   1125: astore 7
    //   1127: ldc_w 1158
    //   1130: astore_1
    //   1131: ldc_w 1158
    //   1134: astore 11
    //   1136: ldc_w 1158
    //   1139: astore 5
    //   1141: ldc_w 1158
    //   1144: astore 6
    //   1146: aload_3
    //   1147: astore 10
    //   1149: aload 11
    //   1151: astore_3
    //   1152: goto -615 -> 537
    //   1155: astore 9
    //   1157: ldc_w 1158
    //   1160: astore 5
    //   1162: aload_2
    //   1163: astore 6
    //   1165: ldc_w 1158
    //   1168: astore_2
    //   1169: ldc_w 1158
    //   1172: astore 4
    //   1174: ldc_w 1158
    //   1177: astore 8
    //   1179: aload_1
    //   1180: astore 7
    //   1182: ldc_w 1158
    //   1185: astore_1
    //   1186: ldc_w 1158
    //   1189: astore 11
    //   1191: aload_3
    //   1192: astore 10
    //   1194: aload 11
    //   1196: astore_3
    //   1197: goto -660 -> 537
    //   1200: astore 9
    //   1202: aload_1
    //   1203: astore 7
    //   1205: aload 13
    //   1207: astore_1
    //   1208: aload_2
    //   1209: astore 11
    //   1211: aload 8
    //   1213: astore_2
    //   1214: aload 6
    //   1216: astore 5
    //   1218: aload_3
    //   1219: astore 10
    //   1221: aload 16
    //   1223: astore 8
    //   1225: aload 14
    //   1227: astore_3
    //   1228: aload 11
    //   1230: astore 6
    //   1232: goto -695 -> 537
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1235	0	this	JumpAction
    //   52	1156	1	localObject1	Object
    //   66	1148	2	localObject2	Object
    //   38	1190	3	localObject3	Object
    //   80	1093	4	localObject4	Object
    //   92	1125	5	localObject5	Object
    //   112	1119	6	localObject6	Object
    //   88	1116	7	localObject7	Object
    //   108	1116	8	localObject8	Object
    //   137	334	9	str1	String
    //   493	45	9	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   544	1	9	localObject9	Object
    //   565	45	9	localNullPointerException1	NullPointerException
    //   616	136	9	localObject10	Object
    //   863	1	9	localNullPointerException2	NullPointerException
    //   916	1	9	localNullPointerException3	NullPointerException
    //   963	1	9	localNullPointerException4	NullPointerException
    //   1015	36	9	localObject11	Object
    //   1055	1	9	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   1108	1	9	localUnsupportedEncodingException3	UnsupportedEncodingException
    //   1155	1	9	localUnsupportedEncodingException4	UnsupportedEncodingException
    //   1200	1	9	localUnsupportedEncodingException5	UnsupportedEncodingException
    //   18	983	10	localObject12	Object
    //   1008	17	10	localNullPointerException5	NullPointerException
    //   1035	185	10	localObject13	Object
    //   100	1129	11	localObject14	Object
    //   84	957	12	localObject15	Object
    //   104	1102	13	str2	String
    //   3	1223	14	localObject16	Object
    //   96	915	15	str3	String
    //   116	1106	16	str4	String
    //   13	438	17	str5	String
    //   23	435	18	str6	String
    //   8	461	19	str7	String
    //   442	6	20	str8	String
    // Exception table:
    //   from	to	target	type
    //   25	39	493	java/io/UnsupportedEncodingException
    //   25	39	565	java/lang/NullPointerException
    //   39	53	863	java/lang/NullPointerException
    //   53	67	916	java/lang/NullPointerException
    //   67	82	963	java/lang/NullPointerException
    //   118	139	1008	java/lang/NullPointerException
    //   179	200	1008	java/lang/NullPointerException
    //   240	261	1008	java/lang/NullPointerException
    //   301	322	1008	java/lang/NullPointerException
    //   362	383	1008	java/lang/NullPointerException
    //   423	444	1008	java/lang/NullPointerException
    //   39	53	1055	java/io/UnsupportedEncodingException
    //   53	67	1108	java/io/UnsupportedEncodingException
    //   67	82	1155	java/io/UnsupportedEncodingException
    //   118	139	1200	java/io/UnsupportedEncodingException
    //   179	200	1200	java/io/UnsupportedEncodingException
    //   240	261	1200	java/io/UnsupportedEncodingException
    //   301	322	1200	java/io/UnsupportedEncodingException
    //   362	383	1200	java/io/UnsupportedEncodingException
    //   423	444	1200	java/io/UnsupportedEncodingException
  }
  
  private boolean ao()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QRJumpActivity.class);
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.fs;
    }
    localIntent.putExtra("url", str1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ap()
  {
    i1 = -1;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, TenpayActivity.class);
    localIntent.putExtra("src_type", this.fx).putExtra("token_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("token_id")).putExtra("app_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id")).putExtra("version", this.fv).putExtra("app_info", (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_info")).putExtra("callback_type", this.fy).putExtra("callback_name", this.fz).putExtra("app_info", (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_info")).putExtra("url_app_info", (String)this.jdField_a_of_type_JavaUtilHashMap.get("url_app_info")).putExtra("params", (String)this.jdField_a_of_type_JavaUtilHashMap.get("params"));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {}
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("k_requestcode");
      if ((str == null) || (str.length() <= 0)) {
        break label248;
      }
      int i2 = Integer.parseInt(str, 10);
      i1 = i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        continue;
        i1 = -1;
      }
    }
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, i1);
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private boolean aq()
  {
    if ("webview".equals(this.gg))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", this.fx).putExtra("callback_type", this.fy).putExtra("callback_name", this.fz));
    }
    return true;
  }
  
  private boolean ar()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BindGroupActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("skey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label164:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label164;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localIntent.putExtra("key_params", localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean as()
  {
    boolean bool = true;
    System.currentTimeMillis();
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject2 == null) || ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://"))) || ((!Util.c((String)localObject2).equalsIgnoreCase("qq.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("myun.tenpay.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("tenpay.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("wanggou.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("tencent.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("jd.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("qcloud.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("webank.com"))))
    {
      bool = false;
      return bool;
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("style");
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_auth");
    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_nld");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_dev");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_usr");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_vkey");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((String)localObject2);
    if (localStringBuffer.indexOf("?") < 0)
    {
      localStringBuffer.append("?");
      label301:
      localObject2 = new Cryptor();
      if (!"1".equals(str2)) {
        break label1422;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
    }
    label1293:
    label1300:
    label1422:
    for (int i1 = 1;; i1 = 0)
    {
      if ("1".equals(str3))
      {
        localStringBuffer.append("plg_dev=1");
        localStringBuffer.append("&");
        localStringBuffer.append("MOBINFO=");
        localStringBuffer.append(HexUtil.a(((Cryptor)localObject2).encrypt(b().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(HexUtil.a(((Cryptor)localObject2).encrypt("黑".getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      int i2 = i1;
      if ("1".equals(str5))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d();
        i2 = i1;
        if (localObject2 != null)
        {
          localStringBuffer.append("plg_vkey=1").append("&mqqvkey=").append((String)localObject2).append("&");
          i2 = 1;
        }
      }
      if ((this.gk != null) && (this.gk.length() > 0)) {
        localStringBuffer.append(this.gk + "&");
      }
      if ("1".equals(localObject1))
      {
        localStringBuffer.append("plg_nld=1");
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", localStringBuffer.toString());
        if ((str1 != null) && (!str1.equals(""))) {
          ((Intent)localObject1).putExtra("title", str1);
        }
        ((Intent)localObject1).putExtra("reportNldFormPlugin", true);
        ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return true;
        if (localStringBuffer.indexOf("?") >= localStringBuffer.length() - 1) {
          break label301;
        }
        if (localStringBuffer.indexOf("&") < 0)
        {
          localStringBuffer.append("&");
          break label301;
        }
        if (localStringBuffer.lastIndexOf("&") >= localStringBuffer.length() - 1) {
          break label301;
        }
        localStringBuffer.append("&");
        break label301;
      }
      if (i2 != 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.lastIndexOf("&"));
      }
      if (localStringBuffer.toString().startsWith("http://story.now.qq.com/mobile/transfer_q.html"))
      {
        localObject1 = URLUtil.b(localStringBuffer.toString());
        if ((!TextUtils.isEmpty((String)((Map)localObject1).get("storysharefrom"))) && (a((Map)localObject1, true))) {
          break;
        }
      }
      if ((this.gh == null) || (!this.gh.trim().equalsIgnoreCase("com.tx.android.txnews.new")))
      {
        if ((this.gh != null) && (this.gh.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=6.5.5.2880");
          localStringBuffer.append("&appid=" + AppSetting.a);
          localStringBuffer.append("&QUA=" + QUA.a());
          localStringBuffer.append("&adtag=2880");
          localObject1 = Build.MODEL;
          if (localObject1 == null) {
            break label1293;
          }
          localObject1 = ((String)localObject1).replaceAll(" ", "_");
          i1 = StatisticCollector.a();
          localObject2 = localObject1;
          if (i1 > 0) {
            localObject2 = (String)localObject1 + "_qzpatch" + i1;
          }
          localObject1 = Build.MANUFACTURER;
          if (localObject1 == null) {
            break label1300;
          }
        }
        for (localObject1 = ((String)localObject1).replaceAll(" ", "_");; localObject1 = "")
        {
          localStringBuffer.append("&model=").append((String)localObject2).append("&manufacture=").append((String)localObject1).append("&cpunum=").append(DeviceInfoUtil.b()).append("&cpurate=").append(DeviceInfoUtil.a()).append("&mem=").append(DeviceInfoUtil.c() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.f()).append("&h=").append(DeviceInfoUtil.g());
          localObject2 = localStringBuffer.toString();
          localObject1 = localObject2;
          if (((String)localObject2).endsWith("&")) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          }
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", (String)localObject1);
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((str1 != null) && (!str1.equals(""))) {
            ((Intent)localObject1).putExtra("title", str1);
          }
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          ((Intent)localObject1).putExtra("plugin_start_time", System.nanoTime());
          ((Intent)localObject1).putExtra("click_start_time", System.currentTimeMillis());
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject1).putExtra("has_red_dot", this.d);
          ((Intent)localObject1).putExtra("is_from_leba", true);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          return true;
          localObject1 = "";
          break;
        }
      }
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class).putExtra("url", localStringBuffer.toString());
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((str1 != null) && (!str1.equals(""))) {
        ((Intent)localObject1).putExtra("title", str1);
      }
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject1).putExtra("param_force_internal_browser", false);
      ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject1).putExtra("injectrecommend", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
  }
  
  private boolean at()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str12 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i1;
    long l1;
    Intent localIntent;
    try
    {
      i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      if (i1 == 1)
      {
        a("shareToQQ");
        return true;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        i1 = 0;
      }
      try
      {
        l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
        Bundle localBundle = new Bundle();
        localIntent = new Intent();
        if (l1 <= 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "gotoShareMsg appid = " + l1);
          }
          return false;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          l1 = 0L;
        }
        if ("news".equals(localObject)) {
          break label412;
        }
      }
      if (!"audio".equals(localObject)) {
        break label759;
      }
    }
    label412:
    localException2.putString("title", str8);
    localException2.putString("desc", str9);
    localException2.putString("image_url", str7);
    localException2.putString("detail_url", str10);
    localException2.putInt("forward_type", 11);
    localException2.putLong("req_share_id", l1);
    localException2.putString("pkg_name", this.gh);
    localException2.putString("image_url_remote", str11);
    localException2.putString("app_name", str1);
    localException2.putString("open_id", str12);
    if (str8 == null)
    {
      localObject = "";
      if (!TextUtils.isEmpty(str1)) {
        localObject = str1;
      }
      localException2.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131364569, new Object[] { localObject }));
    }
    for (;;)
    {
      localException2.putString("share_uin", str4);
      localException2.putString("jfrom", str5);
      localException2.putString("share_qq_ext_str", str6);
      localException2.putInt("cflag", i1);
      localException2.putInt("emoInputType", 2);
      int i3 = 1;
      try
      {
        i2 = Integer.valueOf(str3).intValue();
        if (i2 == 2) {
          localException2.putString("audio_url", str2);
        }
        localException2.putInt("req_type", i2);
        localException2.putBoolean("k_dataline", false);
        localException2.putBoolean("k_favorites", true);
        localException2.putBoolean("k_cancel_button", true);
        if (((i1 & 0x2) == 0) && (!"com.qzone".equals(this.gh)))
        {
          bool = true;
          localException2.putBoolean("k_qzone", bool);
          if ((!bool) || ((i1 & 0x1) == 0)) {
            break label825;
          }
          bool = true;
          localException2.putBoolean("k_send", bool);
          localException2.putInt("iUrlInfoFrm", 4);
          localIntent.putExtras(localException2);
          com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
          ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, localIntent);
          label759:
          return true;
          localException2.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131364569, new Object[] { str8 }));
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          boolean bool;
          int i2 = i3;
          if (QLog.isColorLevel())
          {
            QLog.d("QQShare", 2, "NumberFormatException req_type = 1");
            i2 = i3;
            continue;
            bool = false;
            continue;
            label825:
            bool = false;
          }
        }
      }
    }
  }
  
  private boolean au()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("fopen_id"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friend_label"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("add_msg"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    try
    {
      l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id")).longValue();
      if (l1 <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoMakeFriend appid = " + l1);
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        l1 = 0L;
      }
      AddFriendLogicActivity.b = (String)localObject;
      localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, str1, "" + l1, 3016, 0, str2, str3, null, "", str4);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    return true;
  }
  
  private boolean av()
  {
    Object localObject;
    String str2;
    QZoneHelper.UserInfo localUserInfo;
    String str1;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)))
    {
      localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page_id");
      if (str2 != null)
      {
        localUserInfo = QZoneHelper.UserInfo.a();
        localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localUserInfo.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((FragmentActivity)localObject).getChatFragment().a().a();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString))) {
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).e(localSessionInfo.jdField_a_of_type_JavaLangString, true);
        }
        if (!str2.equalsIgnoreCase("11")) {
          break label165;
        }
        QZoneHelper.c((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, str1, "mqqChat.QzoneCard", -1);
      }
    }
    for (;;)
    {
      return false;
      label165:
      if (str2.equalsIgnoreCase("12"))
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a().a();
        str2 = b(str1);
        QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
      }
    }
  }
  
  private boolean aw()
  {
    if (this.fs != null)
    {
      String str = "mqzone" + this.fs.substring("mqqzone".length());
      Intent localIntent = new Intent();
      localIntent.putExtra("cmd", "Schema");
      localIntent.putExtra("schema", str);
      QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.a(), localIntent);
      return true;
    }
    return false;
  }
  
  private boolean ax()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    Object localObject11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    Object localObject7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    for (;;)
    {
      Object localObject3;
      try
      {
        i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      }
      catch (Exception localException2)
      {
        try
        {
          l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
          localObject9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          i2 = (int)l1;
          if (TextUtils.isEmpty((CharSequence)localObject7))
          {
            localObject1 = "";
            if (!TextUtils.isEmpty(this.gh)) {
              continue;
            }
            localObject4 = "";
            QfavReport.a((AppRuntime)localObject9, "User_SdkShare", i2, 0, 0, 0, (String)localObject1, (String)localObject4);
            localObject9 = new Bundle();
            ((Bundle)localObject9).putString("title", (String)localObject6);
            ((Bundle)localObject9).putString("desc", (String)localObject8);
            ((Bundle)localObject9).putString("image_url", (String)localObject10);
            ((Bundle)localObject9).putString("detail_url", (String)localObject11);
            ((Bundle)localObject9).putLong("req_share_id", l1);
            ((Bundle)localObject9).putString("pkg_name", this.gh);
            ((Bundle)localObject9).putString("image_url_remote", str3);
            ((Bundle)localObject9).putString("app_name", (String)localObject7);
            ((Bundle)localObject9).putString("open_id", str4);
            ((Bundle)localObject9).putString("share_uin", str5);
            ((Bundle)localObject9).putString("jfrom", str6);
            ((Bundle)localObject9).putString("share_qq_ext_str", str7);
            ((Bundle)localObject9).putInt("cflag", i1);
            ((Bundle)localObject9).putInt("forward_type", 11);
            i3 = 1;
          }
        }
        catch (Exception localException2)
        {
          try
          {
            int i1;
            long l1;
            i2 = Integer.valueOf(str2).intValue();
            ((Bundle)localObject9).putInt("req_type", i2);
            if (2 == i2)
            {
              ((Bundle)localObject9).putString("audio_url", str1);
              if ((TextUtils.isEmpty((CharSequence)localObject6)) && (TextUtils.isEmpty((CharSequence)localObject8)))
              {
                if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                  ((Bundle)localObject9).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131366005), new Object[] { localObject7 }));
                }
              }
              else
              {
                com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
                ((Intent)localObject1).putExtra("toUin", AppConstants.au);
                ((Intent)localObject1).putExtra("uinType", 0);
                if (1 != i1) {
                  break label1659;
                }
                ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
                ((Intent)localObject1).putExtras((Bundle)localObject9);
                ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, DirectForwardActivity.class);
                return true;
                localException1 = localException1;
                if (QLog.isColorLevel()) {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                }
                i1 = 0;
                continue;
                localException2 = localException2;
                if (QLog.isColorLevel()) {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
                }
                l1 = 0L;
                continue;
                Object localObject2 = localObject7;
                continue;
                localObject4 = this.gh;
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Object localObject9;
            Object localObject4;
            int i3;
            int i2 = i3;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + str2);
            i2 = i3;
            continue;
            ((Bundle)localObject9).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131366006));
            continue;
            if (6 == i2)
            {
              ((Bundle)localObject9).putBoolean("key_sdk_share_pure_text", true);
              localObject3 = "";
              if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                localObject3 = localObject6;
              }
              localObject4 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject8))
              {
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  localObject4 = localObject8;
                }
              }
              else
              {
                ((Bundle)localObject9).putString("forward_text", (String)localObject4);
                ((Bundle)localObject9).putString("qqfav_extra_richmedia_title", (String)localObject6);
                ((Bundle)localObject9).putString("qqfav_extra_mixed_msg", (String)localObject8);
                continue;
              }
              localObject4 = (String)localObject3 + "\n" + (String)localObject8;
              continue;
            }
            if (5 == i2)
            {
              ((Bundle)localObject9).putBoolean("qqfav_extra_pic_share", true);
              ((Bundle)localObject9).putBoolean("qqfav_extra_only_pic", TextUtils.isEmpty((CharSequence)localObject8));
              ((Bundle)localObject9).putString("qqfav_extra_richmedia_title", (String)localObject6);
              ((Bundle)localObject9).putString("qqfav_extra_mixed_msg", (String)localObject8);
              ((Bundle)localObject9).putString("desc", "");
              localObject7 = localObject6;
              if (TextUtils.isEmpty((CharSequence)localObject6))
              {
                localObject7 = localObject6;
                if (!TextUtils.isEmpty((CharSequence)localObject8))
                {
                  localObject7 = ((String)localObject8).replace("\024", "");
                  ((Bundle)localObject9).putString("title", (String)localObject7);
                }
              }
              localObject4 = null;
              localObject3 = null;
              localObject11 = new ArrayList();
              Object localObject5;
              if (!TextUtils.isEmpty((CharSequence)localObject10))
              {
                localObject10 = ((String)localObject10).split(";");
                i2 = 0;
                localObject6 = null;
                localObject8 = localObject6;
                localObject4 = localObject3;
                if (i2 < localObject10.length)
                {
                  localObject8 = "";
                  try
                  {
                    localObject4 = URLDecoder.decode(localObject10[i2], "UTF-8");
                    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                      if ((((String)localObject4).startsWith("/")) && (new File((String)localObject4).exists()))
                      {
                        ((ArrayList)localObject11).add(localObject4);
                        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                          continue;
                        }
                        i2 += 1;
                        localObject3 = localObject4;
                      }
                    }
                  }
                  catch (UnsupportedEncodingException localUnsupportedEncodingException)
                  {
                    localObject5 = localObject8;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + localObject10[i2]);
                    localObject5 = localObject8;
                    continue;
                    if (((String)localObject5).startsWith("http"))
                    {
                      ((ArrayList)localObject11).add(localObject5);
                      if (TextUtils.isEmpty((CharSequence)localObject6))
                      {
                        localObject6 = localObject5;
                        localObject5 = localObject3;
                        continue;
                        if (QLog.isColorLevel()) {
                          QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + (String)localObject5);
                        }
                      }
                    }
                    localObject5 = localObject3;
                    continue;
                  }
                }
              }
              else
              {
                localObject8 = null;
              }
              if (((ArrayList)localObject11).isEmpty())
              {
                QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131365999, 1);
                if (QLog.isColorLevel()) {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.no image path");
                }
                return false;
              }
              ((Bundle)localObject9).putString("image_url", (String)localObject5);
              ((Bundle)localObject9).putString("image_url_remote", (String)localObject8);
              ((Bundle)localObject9).putStringArrayList("qqfav_extra_multi_pic_path_list", (ArrayList)localObject11);
              if (1 == ((ArrayList)localObject11).size())
              {
                if (TextUtils.isEmpty((CharSequence)localObject7))
                {
                  ((Bundle)localObject9).putInt("req_type", 5);
                  if ((!TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject8))) {
                    continue;
                  }
                  ((Bundle)localObject9).putString("image_url", (String)localObject8);
                  continue;
                }
                ((Bundle)localObject9).putInt("req_type", 1);
                continue;
              }
              if (TextUtils.isEmpty((CharSequence)localObject7)) {
                ((Bundle)localObject9).putString("title", ((ArrayList)localObject11).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131365962));
              }
              ((Bundle)localObject9).putBoolean("qqfav_extra_multi_pic", true);
              ((Bundle)localObject9).putInt("req_type", 1);
              continue;
            }
            if (1 == i2)
            {
              if ((TextUtils.isEmpty((CharSequence)localObject6)) && (TextUtils.isEmpty((CharSequence)localObject8)))
              {
                if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                  ((Bundle)localObject9).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131366005), new Object[] { localObject7 }));
                }
              }
              else
              {
                if ((!TextUtils.isEmpty((CharSequence)localObject11)) || (!QLog.isColorLevel())) {
                  continue;
                }
                QLog.i("qqfav", 2, "gotoQfavShareMsg|link type. no detail url");
                continue;
              }
              ((Bundle)localObject9).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131366006));
              continue;
            }
            QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131365999, 1);
            if (QLog.isColorLevel()) {
              QLog.e("qqfav", 2, "gotoQfavShareMsg|unknown reqType. reqType=" + i2);
            }
            return false;
          }
        }
      }
      label1659:
      ((Intent)localObject3).putExtra("qqfav_extra_from_sdk_share", true);
    }
  }
  
  private boolean ay()
  {
    Object localObject1 = new Bundle();
    long l1;
    int i2;
    try
    {
      l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
      if (l1 <= 0L) {
        return false;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        l1 = 0L;
      }
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      ((Bundle)localObject1).putString("open_id", str);
      ((Bundle)localObject1).putString("share_uin", (String)localObject2);
      i2 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
      str = "";
      if (i2 != 3) {
        break label556;
      }
    }
    String str = "7";
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    Object localObject4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    Object localObject3 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject4 = ((String)localObject4).split(";");
      int i1 = 0;
      while (i1 < localObject4.length)
      {
        ((ArrayList)localObject3).add(URLDecoder.decode(localObject4[i1]));
        i1 += 1;
      }
    }
    ((Bundle)localObject1).putStringArrayList("images", (ArrayList)localObject3);
    ((Bundle)localObject1).putString("summary", (String)localObject2);
    for (;;)
    {
      ((Bundle)localObject1).putString("app_name", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")));
      ((Bundle)localObject1).putString("hulian_appid", String.valueOf(l1));
      ((Bundle)localObject1).putInt("req_type", i2);
      ((Bundle)localObject1).putLong("req_share_id", l1);
      ((Bundle)localObject1).putString("pkg_name", this.gh);
      ((Bundle)localObject1).putBoolean("key_need_save_draft", false);
      com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
      localObject2 = new wax(this);
      QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, (DialogInterface.OnDismissListener)localObject2);
      localObject2 = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject2).c = "1";
      ((QZoneClickReport.ReportInfo)localObject2).d = "0";
      ((QZoneClickReport.ReportInfo)localObject2).jdField_b_of_type_Int = 4;
      ((QZoneClickReport.ReportInfo)localObject2).k = "5";
      ((QZoneClickReport.ReportInfo)localObject2).l = "thirdApp";
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("source_type", "5");
      ((HashMap)localObject3).put("source_from", "thirdApp");
      localObject1 = ((Bundle)localObject1).getStringArrayList("images");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 9))
      {
        ((QZoneClickReport.ReportInfo)localObject2).m = "QZoneUploadPhotosActivity";
        ((HashMap)localObject3).put("source_to", "QZoneUploadPhotosActivity");
        QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject2);
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject3, null);
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", l1 + "", "11", "12", "0", str, "", "4", false);
        return true;
        label556:
        if (i2 != 4) {
          continue;
        }
        str = "8";
        localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoPath"));
      }
      try
      {
        ((Bundle)localObject1).putLong("file_send_duration", Long.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoDuration"))).longValue());
        try
        {
          ((Bundle)localObject1).putLong("PhotoConst.VIDEO_SIZE", Long.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoSize"))).longValue());
          localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
          ((Bundle)localObject1).putBoolean("PhotoConst.IS_VIDEO_SELECTED", true);
          ((Bundle)localObject1).putInt("PhotoConst.VIDEO_TYPE", 1);
          ((Bundle)localObject1).putString("file_send_path", (String)localObject2);
          ((Bundle)localObject1).putBoolean("need_process", false);
          ((Bundle)localObject1).putString("defaultText", (String)localObject3);
          continue;
          ((QZoneClickReport.ReportInfo)localObject2).m = "QZonePublishMoodActivity";
          ((HashMap)localObject3).put("source_to", "QZonePublishMoodActivity");
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
    }
  }
  
  private boolean az()
  {
    return true;
  }
  
  private String b()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    Object localObject1 = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
    String str3 = ((TelephonyManager)localObject1).getDeviceId();
    localObject1 = ((TelephonyManager)localObject1).getSubscriberId();
    Object localObject2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject2).getHeight();
    int i2 = ((Display)localObject2).getWidth();
    localObject2 = i2 + "*" + i1;
    i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    return str1 + "|" + str2 + "|" + str3 + "|" + (String)localObject2 + "|" + (String)localObject1 + "|" + i1 + "|";
  }
  
  private String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("i="))) {
      return null;
    }
    int i3 = paramString.indexOf("i=");
    int i2 = paramString.substring(i3).indexOf('&');
    int i1 = i2;
    if (i2 <= 0) {
      i1 = paramString.length() - i3;
    }
    return paramString.substring("i=".length() + i3, i1 + i3);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131371889, this.jdField_a_of_type_AndroidContentContext.getString(2131371888), 2131371890, 2131371891, new wat(this), new wau(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private String c()
  {
    return "mqqapi://" + this.ft + "/" + this.fu + "?src_type=" + this.fx;
  }
  
  private String c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(Base64Util.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void c()
  {
    Object localObject;
    String str1;
    label54:
    String str2;
    label81:
    String str3;
    label109:
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName"))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
        break label331;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        break label338;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
        break label345;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
        break label353;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
      label137:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
        break label361;
      }
    }
    label331:
    label338:
    label345:
    label353:
    label361:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((QWalletAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(42)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Wbb = new wbb(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_Wbb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
      return;
      localObject = "";
      break;
      str1 = "";
      break label54;
      str2 = "";
      break label81;
      str3 = "";
      break label109;
      str4 = "";
      break label137;
    }
  }
  
  private void d()
  {
    com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localJSONObject.put("viewTag", "pswManage");
      if (!PayBridgeActivity.tenpay((Activity)this.jdField_a_of_type_AndroidContentContext, localJSONObject.toString(), 5, "")) {}
      for (int i1 = 1;; i1 = 0)
      {
        a(i1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(1);
    }
  }
  
  private void e()
  {
    try
    {
      if ("head".equals(this.fu))
      {
        if (this.jdField_a_of_type_Wba == null) {
          this.jdField_a_of_type_Wba = new wba(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Wba);
        long l1 = System.currentTimeMillis();
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).split(",");
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          String str = arrayOfString[i1];
          localFriendListHandler.c(str);
          this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("JumpAction", 2, "handleMQQService error " + localException.toString());
      }
    }
  }
  
  private void e(String paramString)
  {
    if ("app".equals(this.fx)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(this.fx))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(this.fx));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private void f(String paramString)
  {
    if ((paramString.equals(GameCenterActivity.class.getName())) || (paramString.equals(PublicAccountBrowser.class.getName())) || (paramString.equals(IndividuationSetActivity.class.getName())) || (paramString.equals(CouponActivity.class.getName()))) {
      QWalletHelper.a();
    }
  }
  
  public boolean A()
  {
    String str1;
    Activity localActivity;
    if ("qrcode".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("from")))
    {
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoStoryTopic, topicId:" + str1 + ", topicName:" + str2);
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
        try
        {
          StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localActivity, Long.parseLong(str1), str2);
          return true;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoStoryTopic, topicId:" + str1);
          }
        }
      }
    }
    for (;;)
    {
      return false;
      String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
      int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("topiccolor"));
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoStoryTopic, topicId:" + str1 + ", topicName:" + str3);
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
        try
        {
          String str4 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("topiccover"), "utf-8");
          String str5 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("topiclogo"), "utf-8");
          StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localActivity, Long.parseLong(str1), str3, str4, str5, i1);
          return true;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("JumpAction", 2, "gotoStoryTopic, topicId:" + str1);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoStoryTopic:" + QLog.getStackTraceString(localUnsupportedEncodingException));
        }
      }
    }
  }
  
  public boolean B()
  {
    String str1;
    Object localObject1;
    label54:
    String str3;
    label81:
    Object localObject3;
    Object localObject4;
    Object localObject2;
    String str4;
    Bundle localBundle;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("roomid"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("fromid"))
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("list_name"))
        {
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("list_name");
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("coverurl");
          localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extras");
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
          str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first");
          localBundle = new Bundle();
          localBundle.putString("coverurl", (String)localObject3);
          localBundle.putString("extras_from_js", (String)localObject4);
          localBundle.putBoolean("can_use_h5_first", true);
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topic")) {
            localBundle.putString("topic", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topic"));
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("story_ext")) {
            localBundle.putString("story_ext", (String)this.jdField_a_of_type_JavaUtilHashMap.get("story_ext"));
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject3 = (NowProxy)((QQAppInterface)localObject3).getManager(181);
        if (!TextUtils.isEmpty(str4))
        {
          i1 = Integer.parseInt(str4);
          if (i1 != 0) {}
        }
        else
        {
          try
          {
            i1 = Integer.parseInt((String)localObject2);
            i1 = SharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1);
            localObject2 = new NowFromData();
            ((NowFromData)localObject2).b = "actiondata";
            ((NowFromData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(str3);
            return ((NowProxy)localObject3).a(new NowProxy.ListNameData((ArrayList)localObject1, 0), Long.parseLong(str1), (NowFromData)localObject2, i1, localBundle);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (!QLog.isColorLevel()) {
              break label449;
            }
          }
          QLog.e("JumpAction", 2, localNumberFormatException.toString());
          break label449;
        }
        i1 = Integer.parseInt(str4);
        continue;
        str3 = "";
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("JumpAction", 2, localException.toString());
        }
        return false;
      }
      break label81;
      localObject1 = "";
      break label54;
      String str2 = "0";
      break;
      label449:
      int i1 = 0;
    }
  }
  
  public String a()
  {
    return this.ft;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
  }
  
  public void a(String paramString)
  {
    this.gg = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, "setNewFlag.newflag=" + this.c);
    }
  }
  
  public boolean a()
  {
    new wao(this).start();
    return b();
  }
  
  public boolean a(Map paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    paramMap = (String)paramMap.get("sharefromtype");
    for (;;)
    {
      int i1;
      try
      {
        i1 = Integer.parseInt(paramMap);
        if ((str5 == null) || (!str5.equals("0"))) {
          break label289;
        }
        paramBoolean = false;
        if (TextUtils.isEmpty(str4)) {
          if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
            return false;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("JumpAction", 2, "gotoStoryContentPage, NumberFormatException, shareFromStr:" + paramMap);
        }
        i1 = -1;
        continue;
        try
        {
          if (Integer.parseInt(str2) == 1)
          {
            if (TextUtils.isEmpty(str1)) {
              continue;
            }
            StoryPlayVideoActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, Long.parseLong(str1), str3, paramBoolean);
          }
          else
          {
            QQStoryContentActivity.a(this.jdField_a_of_type_AndroidContentContext, Integer.parseInt(str2), str3, paramBoolean, i1);
          }
        }
        catch (NumberFormatException paramMap) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, userId:" + str1 + ", userType:" + str2);
        return false;
      }
      QQStoryContentActivity.a(this.jdField_a_of_type_AndroidContentContext, str4, i1);
      return true;
      label289:
      paramBoolean = true;
    }
    return true;
  }
  
  public void b(String paramString)
  {
    this.gh = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean b()
  {
    int i1;
    if ("com.qqfav".equals(this.ft)) {
      i1 = -1;
    }
    try
    {
      int i2 = Integer.parseInt(this.fu);
      i1 = i2;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      Object localObject1;
      Object localObject3;
      Object localObject4;
      for (;;) {}
    }
    switch (i1)
    {
    default: 
      return true;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("selfSet_leftViewText", BaseApplicationImpl.a().getApplicationContext().getString(2131367975));
    return QfavHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, -1, false);
    this.fv = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("version"));
    this.fw = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("channel_id"));
    this.fx = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
    this.fy = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type"));
    this.fz = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
    localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("viewtype");
    localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("entry")) {}
    for (localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("entry"); ("wallet".equals(this.ft)) && ("open".equals(this.fu)) && ("0".equals(localObject3)) && (!TextUtils.isEmpty(this.fx)) && ((localObject4 == null) || ("0".equals(localObject4))); localObject1 = null) {
      return U();
    }
    if (("wallet".equals(this.ft)) && ("open".equals(this.fu)) && ("0".equals(localObject3)) && (!TextUtils.isEmpty(this.fx)) && (("1".equals(localObject4)) || ("2".equals(localObject4)) || ("3".equals(localObject4)) || ("4".equals(localObject4)) || ("5".equals(localObject4)) || ("6".equals(localObject4)) || ("7".equals(localObject4)) || ("8".equals(localObject4)) || ("9".equals(localObject4)))) {
      return a((String)localObject4, (String)localObject1);
    }
    if ((this.ft.equals("wpa")) && (this.fu.equals("openid_to_uin"))) {
      return V();
    }
    if ((this.ft.equals("im")) && (this.fu.equals("chat"))) {
      return W();
    }
    if ((this.ft.equals("asyncmsg")) && (this.fu.equals("open_async_detail"))) {
      return aP();
    }
    if ((this.ft.equals("im")) && (this.fu.equals("aioorprofile"))) {
      return X();
    }
    if (this.ft.equals("qapp")) {
      return aN();
    }
    if ((this.ft.equals("lbs")) && (this.fu.equals("show_nearby_fri"))) {
      return Y();
    }
    if ((this.ft.equals("lbs")) && (this.fu.equals("show_location"))) {
      return af();
    }
    if ((this.ft.equals("lbs")) && (this.fu.equals("select_location"))) {
      return ag();
    }
    if ((this.ft.equals("card")) && (this.fu.equals("show_pslcard"))) {
      return ah();
    }
    if ((this.ft.equals("upload")) && (this.fu.equals("photo"))) {
      return aq();
    }
    if ((this.ft.equals("forward")) && (this.fu.equals("url"))) {
      return as();
    }
    if ((this.ft.equals("gamesdk")) && (this.fu.equals("bind_group"))) {
      return ar();
    }
    if ((this.ft.equals("share")) && (this.fu.equals("to_fri"))) {
      return at();
    }
    if ((this.ft.equals("share")) && (this.fu.equals("to_qqdataline"))) {
      return aM();
    }
    if ((this.ft.equals("gamesdk")) && (this.fu.equals("add_friend"))) {
      return au();
    }
    if ((this.ft.equals("share")) && (this.fu.equals("to_qqfav"))) {
      return ax();
    }
    if ((this.ft.equals("share")) && (this.fu.equals("to_qzone"))) {
      return a("shareToQzone");
    }
    if ((this.ft.equals("qzone")) && (this.fu.equals("publish"))) {
      return ay();
    }
    if ((this.ft.equals("qzone")) && (this.fu.equals("writemood"))) {
      return az();
    }
    if ((this.ft.equals("qzone")) && (this.fu.equals("to_publish_queue"))) {
      return aA();
    }
    if ((this.ft.equals("qzone")) && (this.fu.equals("open_homepage"))) {
      return aB();
    }
    if ((this.ft.equals("qzone")) && (this.fu.equals("groupalbum"))) {
      return av();
    }
    if ((this.ft.equals("qzone")) && (this.fu.equals("to_friend_feeds"))) {
      return h();
    }
    if ((this.ft.equals("qzone")) && (this.fu.equals("qzone_schema"))) {
      return aw();
    }
    if ((this.ft.equals("usersummary")) && (this.fu.equals("editsummary"))) {
      return g();
    }
    if (this.ft.equals("mqq"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleMQQService");
      }
      e();
    }
    for (;;)
    {
      Object localObject2;
      if ((this.ft.equals("schedule")) && (this.fu.equals("showDetail")))
      {
        return aQ();
        if (this.ft.endsWith("app"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "handleAppForward");
          }
          return aL();
        }
        if ((this.ft.equals("qm")) && (this.fu.equals("qr"))) {
          return ao();
        }
        if ((this.ft.equals("tenpay")) && (this.fu.equals("pay"))) {
          return ap();
        }
        if ((this.ft.equals("dc")) && (this.fu.equals("ft"))) {
          return aC();
        }
        if ((this.ft.equals("group")) && (this.fu.equals("nearby"))) {
          return Z();
        }
        if ((this.ft.equals("group")) && (this.fu.equals("create"))) {
          return aa();
        }
        if ((this.ft.equals("group")) && (this.fu.equals("creategroup"))) {
          return ab();
        }
        if ((this.ft.equals("group")) && (this.fu.equals("groupvideo"))) {
          return ac();
        }
        if ((this.ft.equals("group")) && (this.fu.equals("openOrg"))) {
          return v();
        }
        if ((this.ft.equals("shop")) && (this.fu.equals("emoji")))
        {
          EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7);
          return true;
        }
        if ((this.ft.equals("shop")) && (this.fu.equals("emoji_detail")))
        {
          EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4, a("detailid"));
          return true;
        }
        if ((this.ft.equals("shop")) && (this.fu.equals("emoji_author")))
        {
          EmojiHomeUiPlugin.openEmojiAuthorPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 5, a("authorid"));
          return true;
        }
        if ((this.ft.equals("shop")) && (this.fu.equals("bubble")))
        {
          VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, null, false, -1);
          return true;
        }
        if ((this.ft.equals("shop")) && (this.fu.equals("theme")))
        {
          if ((!BaseApplicationImpl.jdField_a_of_type_Boolean) || (!Utils.b())) {
            continue;
          }
          VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, null, false, -1);
          return true;
        }
        if ((this.ft.equals("shop")) && (this.fu.equals("font")))
        {
          if ((!((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a()) || (!Utils.b())) {
            continue;
          }
          VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, null, false, -1);
          return true;
        }
        if ((this.ft.equals("shop")) && (this.fu.equals("pendant")))
        {
          if (Utils.b()) {
            AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
          }
          return true;
        }
        if ((this.ft.equals("shop")) && (this.fu.equals("individuation")))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, IndividuationSetActivity.class);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          return true;
        }
        if ((this.ft.equals("shop")) && (this.fu.equals("apollo_store")))
        {
          localObject1 = new Intent();
          localObject3 = this.fs.split("\\?");
          if (localObject3.length >= 2) {
            ((Intent)localObject1).putExtra("extra_key_url_append", localObject3[1]);
          }
          ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localObject1 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", ((ApolloManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()), 0, new String[] { "0" });
          }
          return true;
        }
        if (((this.ft.equals("readingcenter")) || (this.ft.equals("qqreader"))) && (this.fu.equals("open"))) {
          return ae();
        }
        if ((this.ft.equals("healthcenter")) && (this.fu.equals("open")))
        {
          if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, "enter jiankang");
          }
          ThreadManager.a(new was(this), 5, null, true);
          if ((Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor")).getDefaultSensor(19) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
          {
            localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), StepCounterServlert.class);
            ((NewIntent)localObject1).putExtra("msf_cmd_type", "cmd_refresh_steps");
            ((NewIntent)localObject1).setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
          }
          localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
          if ((localObject3 == null) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://"))) || ((!Util.c((String)localObject3).equalsIgnoreCase("qq.com")) && (!Util.c((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) && (!Util.c((String)localObject3).equalsIgnoreCase("tenpay.com")) && (!Util.c((String)localObject3).equalsIgnoreCase("wanggou.com")))) {
            return false;
          }
          localObject1 = localObject3;
          if (((String)localObject3).indexOf("?") <= 0) {
            localObject1 = (String)localObject3 + "?";
          }
          localObject3 = new StringBuilder((String)localObject1);
          localObject4 = ((StringBuilder)localObject3).append("&client=androidQQ").append("&uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).append("&version=").append("6.5.5.2880").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=").append(ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())).append("&platformId=2").append("&_lv=0").append("&hasRedDot=");
          if (this.d) {}
          for (localObject1 = "1";; localObject1 = "0")
          {
            ((StringBuilder)localObject4).append((String)localObject1).append("&adtag=mvip.gongneng.anroid.health.nativet");
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
            ((StringBuilder)localObject3).append("&lati=").append(((SharedPreferences)localObject1).getFloat("search_lbs_latitude", 0.0F));
            ((StringBuilder)localObject3).append("&logi=").append(((SharedPreferences)localObject1).getFloat("search_lbs_logitude", 0.0F));
            i1 = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
            ((StringBuilder)localObject3).append("&netType=" + i1);
            localObject1 = DeviceInfoUtil.d();
            ((StringBuilder)localObject3).append("&model=" + (String)localObject1);
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
            ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            return true;
          }
        }
        if ((this.ft.equals("ptlogin")) && (this.fu.equals("qlogin"))) {
          return aD();
        }
        if ((this.ft.equals("gav")) && (this.fu.equals("request"))) {
          return aE();
        }
        if (("videochat".equals(this.ft)) && ("request".equals(this.fu))) {
          return aH();
        }
        if (("randomavchat".equals(this.ft)) && ("request".equals(this.fu))) {
          return aI();
        }
        if (("guildavchat".equals(this.ft)) && ("request".equals(this.fu))) {
          return aJ();
        }
        if (this.ft.equals("tribe"))
        {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceUrl");
          if (this.fu.equals("web")) {
            localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
          }
          try
          {
            localObject4 = URLDecoder.decode((String)localObject4);
            localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class).putExtra("url", (String)localObject4);
            ((Intent)localObject4).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            ((Intent)localObject4).putExtra("hide_operation_bar", true);
            ((Intent)localObject4).putExtra("hideRightButton", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
            if ((localObject1 != null) && (localObject3 != null)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, (String)localObject1, Util.b((String)localObject3, new String[0]), "", "");
            }
            return true;
          }
          catch (Exception localException)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "URLDecoder.decode error");
            }
            return false;
          }
        }
        if ((this.ft.equals("crmivr")) && (this.fu.equals("audiochat"))) {
          return aF();
        }
        if ((this.ft.equals("crmivr")) && (this.fu.equals("imchat"))) {
          return aG();
        }
        if ((this.ft.equals("qqdataline")) && (this.fu.equals("openqqdataline"))) {
          return T();
        }
        if ((this.ft.equals("wallet")) && (this.fu.equals("modify_pass"))) {
          return S();
        }
        if (this.ft.equals("dating"))
        {
          if (this.fu.equals("detail")) {
            return L();
          }
          if (this.fu.equals("publish")) {
            return K();
          }
          if (!this.fu.equals("feed")) {
            continue;
          }
          return J();
        }
        if (this.ft.equals("nearby_entry"))
        {
          if (this.fu.equals("nearby_feed")) {
            return E();
          }
          if (this.fu.equals("nearby_profile")) {
            return ai();
          }
          if (this.fu.equals("hotchat_list")) {
            return F();
          }
          if (this.fu.equals("hotchat_room")) {
            return G();
          }
          if (this.fu.equals("vip_map_roam")) {
            return I();
          }
          if (this.fu.equals("visitor_list")) {
            return w();
          }
          if (this.fu.equals("find_school_mate_guide")) {
            return e();
          }
          if (!this.fu.equals("rn_busi")) {
            continue;
          }
          return d();
        }
        if (this.ft.equals("hotchat"))
        {
          if (!this.fu.equals("newyear_scene")) {
            continue;
          }
          return H();
        }
        if (this.ft.equals("freshnews_entry"))
        {
          if (this.fu.equals("feed"))
          {
            O();
            continue;
          }
          if (this.fu.equals("detail"))
          {
            P();
            continue;
          }
          if (this.fu.equals("topic"))
          {
            Q();
            continue;
          }
          if (!this.fu.equals("public")) {
            continue;
          }
          R();
          continue;
        }
        if ((this.ft.equals("qlink")) && (this.fu.equals("openqlink"))) {
          return aO();
        }
        if ((this.ft.equals("share")) && (this.fu.equals("to_troopbar"))) {
          return aR();
        }
        if ((this.ft.equals("qqconnect")) && (this.fu.equals("url"))) {
          return aS();
        }
        if ((this.ft.equals("publicdevice")) && (this.fu.equals("url"))) {
          return aT();
        }
        if ((this.ft.equals("openLightApp")) && (this.fu.equals("url"))) {
          return j();
        }
        if (("tenpay".equals(this.ft)) && ("sendHongBao".equals(this.fu))) {
          return aU();
        }
        if (("qqwifi".endsWith(this.ft)) && ("outweb_start".equals(this.fu))) {
          return k();
        }
        if (("massbless".endsWith(this.ft)) && ("mainpage".equals(this.fu))) {
          return l();
        }
        if (this.ft.equals("rankinglist")) {
          return M();
        }
        if (this.ft.equals("interesttag")) {
          return D();
        }
        if (this.ft.equals("qqcomic")) {
          return aK();
        }
        if (("leba_plugin".equals(this.ft)) && ("set".equals(this.fu))) {
          return m();
        }
        if (this.ft.equals("conference")) {
          return N();
        }
        if (this.ft.equals("pa_relationship")) {
          return n();
        }
        if (this.ft.equals("od")) {
          return o();
        }
        if (this.ft.equals("odAddFriend")) {
          return aV();
        }
        if (this.ft.equals("qqc2b"))
        {
          if (this.fu.equals("callc2bphone")) {
            return QQYPQRCodeUtil.a(this.jdField_a_of_type_AndroidContentContext, this.fs, false);
          }
          if (!this.fu.equals("callc2bphonedirect")) {
            continue;
          }
          return QQYPDirectOpenApi.a(this.jdField_a_of_type_AndroidContentContext, this.fs, false);
        }
        if (this.ft.equals("readinjoy"))
        {
          if (this.fu.equals("open")) {
            return p();
          }
          if (this.fu.equals("report")) {
            return q();
          }
          if (this.fu.equals("reportrealtime")) {
            return r();
          }
          if (this.fu.equals("apenalbum"))
          {
            localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("articleid");
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, ImageCollectionActivity.class);
            ((Intent)localObject3).putExtra("articleid", (String)localObject2);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
            continue;
          }
          if (!this.fu.equals("multivideo")) {
            continue;
          }
          return s();
        }
        if ((this.ft.equals("cmshow")) && (this.fu.equals("apollo_action")))
        {
          if (!ApolloManager.a(this.jdField_a_of_type_AndroidContentContext)) {
            continue;
          }
          return u();
        }
        if ("favorites".equals(this.ft))
        {
          if (!"forward_favorites".equals(this.fu)) {
            continue;
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("selfSet_leftViewText", BaseApplicationImpl.a().getApplicationContext().getString(2131367975));
          return QfavHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject2, -1, false);
        }
        if ("hongbao_share".equals(this.ft))
        {
          if (!"hongbao_brush".equals(this.fu)) {
            continue;
          }
          return C();
        }
        if ("assistant_setting".equals(this.ft))
        {
          if (!"ASSISTANT_SETTING".equals(this.fu)) {
            continue;
          }
          return t();
        }
        if (this.ft.equals("conf"))
        {
          if (!this.fu.equals("ft")) {
            continue;
          }
          return x();
        }
        if ("olympic_entry".equals(this.ft)) {
          continue;
        }
        if ("qstory".equals(this.ft))
        {
          if ("open".equals(this.fu)) {
            return y();
          }
          if ("openVideo".equals(this.fu)) {
            return z();
          }
          if ("opencontent".equals(this.fu)) {
            return a(this.jdField_a_of_type_JavaUtilHashMap, false);
          }
          if ("opendiscovery".equals(this.fu))
          {
            if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
              continue;
            }
            localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("key_from");
            localObject2 = (Activity)this.jdField_a_of_type_AndroidContentContext;
            localObject3 = new Intent((Context)localObject2, QQStoryDiscoverActivity.class);
            if (TextUtils.isEmpty((CharSequence)localObject4)) {}
          }
        }
      }
      try
      {
        ((Intent)localObject3).putExtra("key_from", Integer.parseInt((String)localObject4));
        ((Activity)localObject2).startActivity((Intent)localObject3);
        continue;
        if ("openNow".equals(this.fu)) {
          return B();
        }
        if (!"opentopic".equals(this.fu)) {
          continue;
        }
        return A();
        if ((!"now".equals(this.ft)) || (!"openroom".equals(this.fu))) {
          continue;
        }
        return B();
        return false;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;) {}
      }
    }
  }
  
  public void c(String paramString)
  {
    this.gk = paramString;
  }
  
  public boolean c()
  {
    if ((this.ft.equals("im")) && (this.fu.equals("aioorprofile"))) {}
    while ((this.ft.equals("group")) && (this.fu.equals("creategroup"))) {
      return true;
    }
    return false;
  }
  
  public void d(String paramString)
  {
    this.gl = paramString;
  }
  
  boolean d()
  {
    i1 = 0;
    try
    {
      i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_id"));
      i1 = i2;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("busi_version")) {
        break label620;
      }
      i1 = i2;
      i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_version"));
      i1 = i3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
        int i3 = 1;
        int i2 = i1;
        i1 = i3;
        continue;
        String str1;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busi_from")) {
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_from");
        }
        for (;;)
        {
          String str2;
          String str3;
          Object localObject1;
          int i6;
          int i4;
          int i5;
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busi_title"))
          {
            str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_title");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("busi_extra")) {
              break label577;
            }
            str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_extra");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("busi_url")) {
              break label583;
            }
            localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_url");
            i6 = 0;
            i4 = -460552;
            i5 = -15550475;
            i3 = i6;
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("busi_load")) {}
          }
          try
          {
            i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_load"));
            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busi_bgclr")) {
              i4 = BaseBusi.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_bgclr"), -460552) | 0xFF000000;
            }
            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busi_headerclr")) {
              i5 = BaseBusi.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_headerclr"), -15550475) | 0xFF000000;
            }
            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busi_tipclr"))
            {
              i6 = BaseBusi.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("busi_tipclr"), 7829367);
              Object localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                if (NearbyUtils.b()) {
                  NearbyUtils.a("JumpAction", new Object[] { "gotoRNBusi", "original", localObject1 });
                }
              }
              try
              {
                localObject2 = new String(Base64.a((String)localObject1));
                localObject1 = localObject2;
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  localException3.printStackTrace();
                }
              }
              localObject2 = localObject1;
              if (NearbyUtils.b())
              {
                NearbyUtils.a("JumpAction", new Object[] { "gotoRNBusi", "transfer", localObject1 });
                localObject2 = localObject1;
              }
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("busi_id", i2);
              ((Bundle)localObject1).putInt("busi_version", i1);
              ((Bundle)localObject1).putString("busi_from", str1);
              ((Bundle)localObject1).putString("busi_title", str2);
              ((Bundle)localObject1).putString("busi_extra", str3);
              ((Bundle)localObject1).putString("busi_url", (String)localObject2);
              ((Bundle)localObject1).putInt("busi_load", i3);
              ((Bundle)localObject1).putInt("busi_bgclr", i4);
              ((Bundle)localObject1).putInt("busi_headerclr", i5);
              ((Bundle)localObject1).putInt("busi_tipclr", i6);
              return BaseBusi.a(this.jdField_a_of_type_AndroidContentContext, false, 0, (Bundle)localObject1);
              str1 = null;
              continue;
              str2 = null;
              break label151;
              str3 = null;
              break label179;
              localObject1 = null;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
              i3 = i6;
              continue;
              i6 = 7829367;
            }
          }
        }
        i1 = 1;
      }
    }
    if ((i2 < 24) || (i1 <= 0)) {
      return false;
    }
  }
  
  boolean e()
  {
    Object localObject = a("src_type");
    String str1 = "nearby";
    int i1;
    if (((String)localObject).equals("public_account"))
    {
      str1 = "public";
      i1 = 1;
    }
    for (;;)
    {
      String str2 = a("sourceid");
      int i2 = i1;
      if (str2 != null)
      {
        if (!str2.equals("1")) {
          break label206;
        }
        str1 = "public";
      }
      try
      {
        for (;;)
        {
          i2 = Integer.parseInt(str2);
          ThreadManager.a(new waw(this, i2), 5, null, false);
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoNearbyFindSchoolMateGuide ,srcType = " + (String)localObject + ",entrance =" + i2 + ",sourceid = " + str2);
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("busi_id", 24);
          ((Bundle)localObject).putInt("busi_version", 1);
          ((Bundle)localObject).putString("busi_from", str1);
          ((Bundle)localObject).putInt("busi_load", 8);
          return BaseBusi.a(this.jdField_a_of_type_AndroidContentContext, false, 0, (Bundle)localObject);
          if (!((String)localObject).equals("internal")) {
            break label222;
          }
          str1 = "nearby";
          i1 = 2;
          break;
          label206:
          str1 = "nearby";
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          i2 = i1;
        }
        label222:
        i1 = 0;
      }
    }
  }
  
  public boolean f()
  {
    return (this.ft.equals("card")) && (this.fu.equals("show_pslcard")) && ("public_account".equals(this.jdField_a_of_type_JavaUtilHashMap.get("card_type"))) && ("app".equals(this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")));
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DetailProfileActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
    if ((localObject != null) && ((((QZoneManagerImp)localObject).a(2) > 0) || (((QZoneManagerImp)localObject).a(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("newflag", bool);
      ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject).addFlags(805306368);
      QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (Intent)localObject, -1);
      return true;
    }
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    String str = a(a(a(a(a(a(QzoneConfig.a().a("H5Url", "PersonalQzoneVisitor", "http://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), "{clicktime}", String.valueOf(System.currentTimeMillis())), "{from}", "androidQQ"), "{qua}", QUA.a()), "{uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), "{UIN}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("articalChannelId", 5);
    if (WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131367184));
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    localIntent.putExtra("needSkey", "true");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean j()
  {
    SmartDeviceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"), null);
    return true;
  }
  
  public boolean k()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bssid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ssid");
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "bssid=" + str1 + " ssid=" + str2);
    }
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQWiFiPluginInstallActivity.class);
    localIntent.putExtra("key_is_qqwifi", true);
    localIntent.putExtra("fromoutweb", true);
    localIntent.putExtra("bssid", str1);
    localIntent.putExtra("ssid", str2);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "gotoSendBless");
    }
    Intent localIntent;
    if (((BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137)).a())
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BlessActivity.class);
      localIntent.putExtra("fromoutweb", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    do
    {
      return true;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.a);
      localIntent.setFlags(67108864);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))
      {
        SplashActivity localSplashActivity = (SplashActivity)this.jdField_a_of_type_AndroidContentContext;
        localIntent.putExtra("switch_anim", true);
        localSplashActivity.b(localIntent);
        return true;
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
    ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
    return true;
  }
  
  public boolean m()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("id");
    if (str == null) {
      return false;
    }
    try
    {
      l1 = Long.parseLong(str);
      if (l1 == -1L) {
        return false;
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        l1 = -1L;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LebaSearchPluginManagerActivity.class);
      localIntent.putExtra("id", l1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    return true;
  }
  
  public boolean n()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_type");
    if ((localObject != null) && ("public_account".equals(localObject)))
    {
      int i1 = PublicAccountUtil.a(Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag")));
      if ((i1 == -3) || (i1 == -4)) {
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 0L, 1);
      }
    }
    do
    {
      do
      {
        return true;
      } while ((localObject == null) || (!"crm".equals(localObject)));
      localObject = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    } while (localObject == null);
    ((EnterpriseQQHandler)localObject).a(SystemClock.uptimeMillis());
    return true;
  }
  
  public boolean o()
  {
    try
    {
      String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
      String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
      String str1 = "";
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"))) {
        str1 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
      }
      String str2 = "";
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("userdata"))) {
        str2 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
      }
      QQAppInterface localQQAppInterface1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      QQAppInterface localQQAppInterface2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ((ODProxy)localQQAppInterface1.getManager(107)).a(this.jdField_a_of_type_AndroidContentContext, Long.parseLong(str3), "", str1, str2, Integer.parseInt(str4));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return true;
  }
  
  public boolean p()
  {
    boolean bool2 = false;
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("channelid");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("channelname");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("target");
    if ("1".equals(str2))
    {
      if ("qzone".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("from"))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "");
      }
      if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 2, 0);
      }
    }
    for (;;)
    {
      boolean bool1 = true;
      label159:
      int i1;
      label300:
      do
      {
        do
        {
          return bool1;
          ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, 2);
          break;
          if (!"2".equals(str2)) {
            break label300;
          }
          bool1 = bool2;
        } while (str1 == null);
        try
        {
          i1 = Integer.parseInt(str1);
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              i2 = Integer.parseInt((String)localObject2);
              bool1 = bool2;
              if (i1 == -1) {
                break label159;
              }
              localObject2 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131366416);
              }
              ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, i2, 4);
              break;
              localException3 = localException3;
              if (QLog.isDevelopLevel()) {
                QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
              }
              i1 = -1;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              if (QLog.isDevelopLevel()) {
                QLog.e("JumpAction", 4, "gotoReadInJoy channelType error");
              }
              int i2 = 0;
            }
          }
        }
        bool1 = bool2;
      } while (localException3 == null);
      try
      {
        i1 = Integer.parseInt(localException3);
        bool1 = bool2;
        if (i1 == -1) {
          break label159;
        }
        Object localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131366416);
        }
        localObject1 = new Intent("android.intent.action.MAIN");
        ((Intent)localObject1).putExtra("channel_id", i1);
        ((Intent)localObject1).putExtra("channel_name", (String)localObject3);
        ((Intent)localObject1).putExtra("readinjoy_launch_source", 7);
        ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
          }
          i1 = -1;
        }
      }
    }
  }
  
  public boolean q()
  {
    int i3 = 0;
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("sub_action"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sub_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("action_name")) {
        break label129;
      }
    }
    label129:
    for (String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("action_name");; str2 = "")
    {
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break label136;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "subAction[" + str1 + "] or actionName[" + str2 + "] null");
      }
      return true;
      str1 = "";
      break;
    }
    label136:
    String str3;
    label163:
    String str4;
    label191:
    String str5;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tag"))
    {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("main_action")) {
        break label577;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("main_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("to_uin")) {
        break label585;
      }
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_uin");
      label219:
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")))) {
        break label642;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "webReportT get from_type: " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"));
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"));
        i2 = i3;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("result"))
        {
          i2 = i3;
          if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("result"))) {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "webReportT get result: " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("result"));
            }
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("result"));
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("r2"))
          {
            String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r2");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("r3")) {
              continue;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r3");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("r4")) {
              continue;
            }
            str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r4");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("r5")) {
              continue;
            }
            str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r5");
            ReportController.b(null, str3, str4, str5, str1, str2, i1, i2, str6, str8, str9, str10);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("JumpAction", 2, "webReportT ");
            return true;
            str3 = "";
            break label163;
            label577:
            str4 = "";
            break label191;
            label585:
            str5 = "";
            break label219;
            localException1 = localException1;
            i1 = 0;
            continue;
          }
          String str7 = "";
          continue;
          String str8 = "";
          continue;
          String str9 = "";
          continue;
          String str10 = "";
          continue;
        }
        catch (Exception localException2)
        {
          int i2 = i3;
          continue;
        }
      }
      label642:
      int i1 = 0;
    }
  }
  
  public boolean r()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("source")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("source"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("source_article_id")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("source_article_id"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("operation")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("operation"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("op_source")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("op_source")))) {}
    try
    {
      int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("source"));
      long l1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("source_article_id"));
      int i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("operation"));
      int i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("op_source"));
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "webReportArticleRealTime get source[ " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("source") + "] source_article_id[" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("source_article_id") + "] operation[" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("operation") + "] op_source[" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("op_source") + "]");
      }
      ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, i2, i3);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return true;
  }
  
  public boolean s()
  {
    Bundle localBundle;
    boolean bool;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("share_url")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("share_url"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("title")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("title"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("video_create_time")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("video_create_time"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("video_duration")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("video_duration"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("video_width")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("video_width"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("video_height")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("video_height"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("video_vid")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("video_vid"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("video_cover")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("video_cover"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("innerUniqueID")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("innerUniqueID"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busitype")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("busitype"))))
    {
      localBundle = new Bundle();
      localBundle.putString("VIDEO_TITLE", (String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      localBundle.putString("VIDEO_TIME", (String)this.jdField_a_of_type_JavaUtilHashMap.get("video_duration"));
      localBundle.putString("VIDEO_WIDTH", (String)this.jdField_a_of_type_JavaUtilHashMap.get("video_width"));
      localBundle.putString("VIDEO_HEIGHT", (String)this.jdField_a_of_type_JavaUtilHashMap.get("video_height"));
      localBundle.putString("VIDEO_VID", (String)this.jdField_a_of_type_JavaUtilHashMap.get("video_vid"));
      localBundle.putString("VIDEO_ARTICLE_ID", (String)this.jdField_a_of_type_JavaUtilHashMap.get("innerUniqueID"));
      localBundle.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", false);
      if (this.jdField_a_of_type_JavaUtilHashMap.get("busitype") != "1") {
        break label1181;
      }
      bool = true;
      localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    }
    for (;;)
    {
      try
      {
        localBundle.putString("VIDEO_H5_URL", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_url")));
        localBundle.putString("VIDEO_COVER", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_cover")));
      }
      catch (Exception localException1)
      {
        int i1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("JumpAction", 2, "share_url or video_cover |decode exp. share_url=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_url") + " | video_cover = " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_url"));
        return true;
      }
      try
      {
        i1 = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("busitype")).intValue();
        localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", i1);
        localBundle.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_create_time")).longValue(), true));
        if (i1 != 1) {
          break label1257;
        }
        if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("account_name")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("account_name"))) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("account_uin")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("account_uin")))) {
          continue;
        }
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_uin"));
        localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_name"));
      }
      catch (Exception localException2)
      {
        try
        {
          localException1.putString("VIDEO_THIRD_ICON", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("third_icon_url")));
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("third_jump_url")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("third_jump_url")))) {
            localException1.putString("VIDEO_THIRD_ACTION", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("third_jump_url")));
          }
          localObject = ThirdVidoeManager.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_vid"));
          if (localObject == null) {
            continue;
          }
          localException1.putString("VIDEO_THIRD_VID_URL", ((VidUrl)localObject).b);
          localException1.putLong("VIDEO_THIRD_VID_URL_TIME", ((VidUrl)localObject).jdField_a_of_type_Long);
        }
        catch (Exception localException3) {}
        localException2 = localException2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("JumpAction", 2, "busitype or video_create_time |trans long erroe. busitype=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("busitype") + " | video_create_time = " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("video_create_time"));
        return true;
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("VINFO", (String)this.jdField_a_of_type_JavaUtilHashMap.get("video_vid"));
    ((Bundle)localObject).putString("TINFO", (String)this.jdField_a_of_type_JavaUtilHashMap.get("video_vid"));
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_TIME", Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_duration")).intValue());
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_WIDTH", Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_width")).intValue());
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_HEIGHT", Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_height")).intValue());
    ((Bundle)localObject).putInt("FULL_VIDEO_TIME", Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_duration")).intValue());
    if (Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("busitype")).intValue() == 1)
    {
      ((Bundle)localObject).putString("ACCOUNT_UIN", (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_uin"));
      ((Bundle)localObject).putString("ACCOUNT_NAME", (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_name"));
      ((Bundle)localObject).putString("source_puin", (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_uin"));
    }
    for (;;)
    {
      ((Bundle)localObject).putInt("TYPE", Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("busitype")).intValue());
      ((Bundle)localObject).putString("ARTICLE_ID", (String)this.jdField_a_of_type_JavaUtilHashMap.get("innerUniqueID"));
      ((Bundle)localObject).putInt("layout_item", 5);
      ((Bundle)localObject).putBoolean("video_url_load", false);
      ((Bundle)localObject).putString("image_url_remote", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_cover")));
      ((Bundle)localObject).putString("detail_url", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_url")));
      ((Bundle)localObject).putString("video_url", (String)this.jdField_a_of_type_JavaUtilHashMap.get("video_vid"));
      ((Bundle)localObject).putString("title", (String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      ((Bundle)localObject).putString("req_create_time", ReadInJoyTimeUtils.d(Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_create_time")).longValue()));
      ((Bundle)localObject).putString("brief_key", (String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      localBundle.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a((Bundle)localObject)).getBytes());
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiVideoPlayActivity.class);
      ((Intent)localObject).putExtras(localBundle);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      label1181:
      label1257:
      do
      {
        do
        {
          return true;
          bool = false;
          break;
        } while ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("third_icon_url")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("third_icon_url"))) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("third_name")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("third_name"))));
        localException1.putString("VIDEO_THIRD_NAME", (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_name"));
      } while (!QLog.isColorLevel());
      QLog.e("JumpAction", 2, "third_icon_url or third_jump_url |decode exp. third_icon_url=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_icon_url") + " | third_jump_url = " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_jump_url"));
      return true;
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("third_account_uin")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("third_account_uin")))) {
        ((Bundle)localObject).putString("ACCOUNT_UIN", (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_account_uin"));
      }
      ((Bundle)localObject).putString("ACCOUNT_NAME", (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_name"));
    }
  }
  
  public boolean t()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, AssistantSettingActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean u()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    Intent localIntent = new Intent((Activity)this.jdField_a_of_type_AndroidContentContext, ApolloGuestsStateActivity.class);
    localIntent.putExtra("extra_guest_nick", str1);
    localIntent.putExtra("extra_guest_uin", str2);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
    return true;
  }
  
  public boolean v()
  {
    return false;
  }
  
  public boolean w()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, NearbyVisitorListActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("isJumpAction", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean x()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ConferenceFlyTicketActivity.class);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("confid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subject");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ticket");
    localIntent.putExtra("confid", str1);
    localIntent.putExtra("subject", str2);
    localIntent.putExtra("ticket", str3);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean y()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 8855);
    return true;
  }
  
  public boolean z()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoOwnerUin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
    str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoId");
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      try
      {
        StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localActivity, str2, Long.parseLong(str1));
        return true;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, videoOwnerUin:" + str1);
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\JumpAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */