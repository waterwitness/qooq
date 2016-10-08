package com.tencent.mobileqq.webview.swift;

import android.text.TextUtils;
import com.tencent.biz.coupon.CouponInterface;
import com.tencent.biz.eqq.EqqWebviewPlugin;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.lebasearch.LebaPlugin;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.PublicAccountWebviewPlugin;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.biz.webviewplugin.GamePartyPlugin;
import com.tencent.biz.webviewplugin.GetKeyPlugin;
import com.tencent.biz.webviewplugin.HbEventPlugin;
import com.tencent.biz.webviewplugin.HotchatPlugin;
import com.tencent.biz.webviewplugin.NearbyTroopsPlugin;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.biz.webviewplugin.OpenAppDetailPlugin;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.biz.webviewplugin.PtloginPlugin;
import com.tencent.biz.webviewplugin.PubAccountMailJsPlugin;
import com.tencent.biz.webviewplugin.QZoneTihSettingWebPlugin;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.biz.webviewplugin.ShareApiPlugin;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.biz.webviewplugin.TroopMemberLevelJSAPI;
import com.tencent.biz.webviewplugin.UrlCheckPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.device.utils.QQConnectPlugin;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.od.ODAppJSPlugin;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.QQStoryApiPlugin;
import com.tencent.mobileqq.jsp.SmsApiPlugin;
import com.tencent.mobileqq.jsp.TroopApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.mybusiness.MyBusinessWebViewPlugin;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.qcall.RecentCallPluginInfo;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.remind.RemindJavascriptInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoJsApiPlugin;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;
import com.tencent.mobileqq.troop.browser.VipTroopUpgradePlugin;
import com.tencent.mobileqq.troop.jsp.TroopAssistantFeedsJsHandler;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubPageUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.FunnyPicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividualRedPacketJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.PublicAccountPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQWIFIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQWiFiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.StarJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipComicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunCallJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunctionJsPlugin;
import com.tencent.mobileqq.video.VipVideoApiPlugin;
import com.tencent.mobileqq.vipgift.VipGiftPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import cooperation.c2b.C2BWebPlugin;
import cooperation.comic.emoticon.VipComicEmoticonJsPlugin;
import cooperation.dingdong.DingdongJsApiPlugin;
import cooperation.dingdong.webviewplugin.OfficeAppsCenterJSPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import cooperation.qzone.webviewplugin.famous.QZoneFamousUserHomeJsPlugin;
import cooperation.qzone.webviewplugin.mood.QzoneSelectMoodPictureJsPlugin;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizePlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.util.HashMap;

public class WebViewPluginFactory
{
  public static final int A = 26;
  public static final int B = 27;
  public static final int C = 28;
  public static final int D = 29;
  public static final int E = 30;
  public static final int F = 31;
  public static final int G = 32;
  public static final int H = 33;
  public static final int I = 34;
  public static final int J = 35;
  public static final int K = 36;
  public static final int L = 37;
  public static final int M = 38;
  public static final int N = 39;
  public static final int O = 40;
  public static final int P = 41;
  public static final int Q = 42;
  public static final int R = 43;
  public static final int S = 44;
  public static final int T = 45;
  public static final int U = 46;
  public static final int V = 47;
  public static final int W = 48;
  public static final int X = 49;
  public static final int Y = 50;
  public static final int Z = 51;
  public static final int a = 0;
  public static final String a = "insertPluginsArray";
  public static final HashMap a;
  public static final int aA = 78;
  public static final int aB = 79;
  public static final int aC = 80;
  public static final int aD = 81;
  public static final int aE = 82;
  public static final int aF = 83;
  public static final int aG = 84;
  public static final int aH = 85;
  public static final int aI = 86;
  public static final int aJ = 87;
  public static final int aK = 88;
  public static final int aL = 89;
  public static final int aM = 90;
  public static final int aN = 91;
  public static final int aO = 92;
  public static final int aP = 93;
  public static final int aQ = 94;
  public static final int aR = 95;
  public static final int aS = 96;
  public static final int aT = 97;
  public static final int aU = 98;
  public static final int aV = 99;
  public static final int aW = 100;
  public static final int aX = 101;
  public static final int aY = 102;
  public static final int aZ = 103;
  public static final int aa = 52;
  public static final int ab = 53;
  public static final int ac = 54;
  public static final int ad = 55;
  public static final int ae = 56;
  public static final int af = 57;
  public static final int ag = 58;
  public static final int ah = 59;
  public static final int ai = 60;
  public static final int aj = 61;
  public static final int ak = 62;
  public static final int al = 63;
  public static final int am = 64;
  public static final int an = 65;
  public static final int ao = 66;
  public static final int ap = 67;
  public static final int aq = 68;
  public static final int ar = 69;
  public static final int as = 70;
  public static final int at = 71;
  public static final int au = 72;
  public static final int av = 73;
  public static final int aw = 74;
  public static final int ax = 75;
  public static final int ay = 76;
  public static final int az = 77;
  public static final int b = 1;
  public static final String b = "deviceapp";
  public static final int ba = 104;
  public static final int bb = 105;
  public static final int bc = 106;
  public static final int bd = 107;
  public static final int be = 108;
  public static final int bf = 109;
  public static final int bg = 110;
  public static final int bh = 111;
  public static final int bi = 112;
  public static final int bj = 113;
  public static final int bk = 114;
  public static final int bl = 115;
  public static final int bm = 116;
  public static final int bn = 117;
  public static final int bo = 118;
  public static final int bp = 119;
  public static final int bq = 120;
  public static final int br = 121;
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
  public static final int y = 24;
  public static final int z = 25;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new HashMap();
    a.put("qbizApi", Integer.valueOf(3));
    a.put("coupon", Integer.valueOf(1));
    a.put("eqq", Integer.valueOf(2));
    a.put("lebaPlugin", Integer.valueOf(4));
    a.put("PublicAccountJs", Integer.valueOf(6));
    a.put("publicAccountNew", Integer.valueOf(7));
    a.put("TroopMemberApiPlugin", Integer.valueOf(8));
    a.put("gameTeam", Integer.valueOf(10));
    a.put("Cookie", Integer.valueOf(11));
    a.put("redEnvelope", Integer.valueOf(12));
    a.put("hotchat", Integer.valueOf(13));
    a.put("NearbyTroopsPlugin", Integer.valueOf(14));
    a.put("newerguide", Integer.valueOf(15));
    a.put("offline", Integer.valueOf(16));
    a.put("openToAppDetail", Integer.valueOf(17));
    a.put(PtloginPlugin.class.getSimpleName(), Integer.valueOf(20));
    a.put("mail", Integer.valueOf(21));
    a.put(QzonePlugin.a, Integer.valueOf(22));
    a.put("qztodayinhistory", Integer.valueOf(23));
    a.put("QzoneData", Integer.valueOf(24));
    a.put(ReportPlugin.a, Integer.valueOf(25));
    a.put("share", Integer.valueOf(26));
    a.put(SosoPlugin.a, Integer.valueOf(27));
    a.put("troop_member_level_JS_API", Integer.valueOf(30));
    a.put("URL_CHECK", Integer.valueOf(31));
    a.put("WebSo", Integer.valueOf(32));
    a.put("QQConnect", Integer.valueOf(33));
    a.put("GCApi", Integer.valueOf(34));
    a.put("specialRing", Integer.valueOf(35));
    a.put("InputClickEvent", Integer.valueOf(36));
    a.put("data", Integer.valueOf(38));
    a.put("device", Integer.valueOf(39));
    a.put("event", Integer.valueOf(40));
    a.put("media", Integer.valueOf(41));
    a.put("QQApi", Integer.valueOf(42));
    a.put("sms", Integer.valueOf(43));
    a.put("troopApi", Integer.valueOf(44));
    a.put("ui", Integer.valueOf(45));
    a.put("webRecord", Integer.valueOf(46));
    a.put("qqmusic", Integer.valueOf(47));
    a.put("mybusiness", Integer.valueOf(48));
    a.put("odapp", Integer.valueOf(49));
    a.put("card", Integer.valueOf(50));
    a.put("RecentCall", Integer.valueOf(51));
    a.put("redpoint", Integer.valueOf(52));
    a.put("REMIND", Integer.valueOf(53));
    a.put("calendar", Integer.valueOf(53));
    a.put("ptv", Integer.valueOf(54));
    a.put("troopAssistantFeeds", Integer.valueOf(57));
    a.put("troopNotice", Integer.valueOf(58));
    a.put("healthSport", Integer.valueOf(59));
    a.put("healthkit", Integer.valueOf(60));
    a.put("apollo", Integer.valueOf(61));
    a.put("faceAddon", Integer.valueOf(62));
    a.put("bubble", Integer.valueOf(64));
    a.put("chatBg", Integer.valueOf(66));
    a.put("font", Integer.valueOf(68));
    a.put("colorRing", Integer.valueOf(70));
    a.put("emoji", Integer.valueOf(73));
    a.put("qutu", Integer.valueOf(77));
    a.put("individualRedPacket", Integer.valueOf(79));
    a.put("individuation", Integer.valueOf(80));
    a.put("msgRoam", Integer.valueOf(82));
    a.put("SetPwdJsInterface", Integer.valueOf(83));
    a.put("EquipLockManager", Integer.valueOf(83));
    a.put("CAPTCHA", Integer.valueOf(83));
    a.put("wallet", Integer.valueOf(84));
    a.put("qqcard", Integer.valueOf(85));
    a.put("qw_qqwifi", Integer.valueOf(86));
    a.put("qqwifi", Integer.valueOf(87));
    a.put("qw_charge", Integer.valueOf(88));
    a.put("qw.pay", Integer.valueOf(89));
    a.put("starclub", Integer.valueOf(90));
    a.put("common", Integer.valueOf(92));
    a.put("theme", Integer.valueOf(93));
    a.put("qw_debug", Integer.valueOf(96));
    a.put("qw_data", Integer.valueOf(96));
    a.put("friendData", Integer.valueOf(96));
    a.put("debug", Integer.valueOf(97));
    a.put("ppreloader", Integer.valueOf(100));
    a.put("funCall", Integer.valueOf(101));
    a.put("QQVIPFunction", Integer.valueOf(102));
    a.put("video", Integer.valueOf(103));
    a.put("gift", Integer.valueOf(104));
    a.put(WebViewJumpPlugin.a, Integer.valueOf(106));
    a.put("mqqc2b", Integer.valueOf(107));
    a.put("comicFavor", Integer.valueOf(108));
    a.put("QQOfficeOpen", Integer.valueOf(109));
    a.put("officeAppsCenter", Integer.valueOf(110));
    a.put("QzMusic", Integer.valueOf(111));
    a.put("Qzone", Integer.valueOf(112));
    a.put("qzDynamicAlbum", Integer.valueOf(112));
    a.put("QZImagePicker", Integer.valueOf(112));
    a.put("qzlive", Integer.valueOf(112));
    a.put(QZoneFamousUserHomeJsPlugin.a, Integer.valueOf(113));
    a.put("QzMoodSelectPicture", Integer.valueOf(114));
    a.put("QzCover", Integer.valueOf(115));
    a.put("qzcardstorre", Integer.valueOf(116));
    a.put("QzAvatar", Integer.valueOf(116));
    a.put("QzFloat", Integer.valueOf(116));
    a.put("story", Integer.valueOf(121));
    a.put("homework", Integer.valueOf(117));
    a.put("publicAccount", Integer.valueOf(5));
    a.put("pay", Integer.valueOf(19));
    a.put(String.valueOf(2L), Integer.valueOf(72));
    a.put(String.valueOf(8L), Integer.valueOf(75));
    a.put(String.valueOf(512L), Integer.valueOf(63));
    a.put(String.valueOf(4096L), Integer.valueOf(69));
    a.put(String.valueOf(1048576L), Integer.valueOf(81));
    a.put(String.valueOf(65536L), Integer.valueOf(78));
    a.put(String.valueOf(262144L), Integer.valueOf(91));
    a.put(String.valueOf(33554432L), Integer.valueOf(67));
    a.put(String.valueOf(64L), Integer.valueOf(65));
    a.put(String.valueOf(32L), Integer.valueOf(94));
    a.put(String.valueOf(4L), Integer.valueOf(74));
    a.put(String.valueOf(4194304L), Integer.valueOf(71));
    a.put("Troop", Integer.valueOf(55));
    a.put("deviceapp", Integer.valueOf(118));
    a.put("qqreader", Integer.valueOf(119));
    a.put("sso", Integer.valueOf(29));
    a.put("nfc", Integer.valueOf(120));
  }
  
  public static WebViewPlugin a(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    case 16: 
    case 18: 
    case 20: 
    case 22: 
    case 25: 
    case 27: 
    case 28: 
    case 36: 
    case 37: 
    case 40: 
    case 76: 
    case 95: 
    case 97: 
    case 98: 
    case 99: 
    case 105: 
    case 118: 
    default: 
      return null;
    case 11: 
      return new GetKeyPlugin();
    case 61: 
      return new ApolloJsPlugin();
    case 62: 
      return new AvatarPendantJsPlugin();
    case 63: 
      return new AvatarPendantUiPlugin();
    case 64: 
      return new BubbleJsPlugin();
    case 65: 
      return new BubbleUiPlugin();
    case 107: 
      return new C2BWebPlugin();
    case 66: 
      return new ChatBackgroundJsPlugin();
    case 67: 
      return new ChatBackgroundUiPlugin();
    case 68: 
      return new ChatFontJsPlugin();
    case 69: 
      return new ChatFontUiPlugin();
    case 70: 
      return new ColorRingJsPlugin();
    case 71: 
      return new ColorRingUIPlugin();
    case 1: 
      return new CouponInterface();
    case 38: 
      return new DataApiPlugin();
    case 121: 
      return new QQStoryApiPlugin();
    case 39: 
      return new DeviceApiPlugin();
    case 109: 
      return new DingdongJsApiPlugin();
    case 72: 
      return new EmojiHomeUiPlugin();
    case 73: 
      return new EmojiJsPlugin();
    case 74: 
      return new EmojiSubHomeUiPlugin();
    case 75: 
      return new EmojiSubPageUiPlugin();
    case 2: 
      return new EqqWebviewPlugin();
    case 77: 
      return new FunnyPicJsPlugin();
    case 34: 
      return new GameCenterAPIJavaScript();
    case 10: 
      return new GamePartyPlugin();
    case 12: 
      return new HbEventPlugin();
    case 59: 
      return new HealthBusinessPlugin();
    case 60: 
      return new HealthStepCounterPlugin();
    case 78: 
      return new HealthUiPlugin();
    case 13: 
      return new HotchatPlugin();
    case 79: 
      return new IndividualRedPacketJsPlugin();
    case 80: 
      return new IndividuationPlugin();
    case 81: 
      return new IndividuationUIPlugin();
    case 4: 
      return new LebaPlugin();
    case 83: 
      return new MQPSecJsPlugin();
    case 41: 
      return new MediaApiPlugin();
    case 82: 
      return new MessageRoamJsPlugin();
    case 47: 
      return new MusicGeneWebViewPlugin();
    case 48: 
      return new MyBusinessWebViewPlugin();
    case 14: 
      return new NearbyTroopsPlugin();
    case 15: 
      return new NewerGuidePlugin();
    case 49: 
      return new ODAppJSPlugin();
    case 110: 
      return new OfficeAppsCenterJSPlugin();
    case 17: 
      return new OpenAppDetailPlugin();
    case 19: 
      return new PayJsPlugin();
    case 50: 
      return new ProfileCardWebviewPlugin();
    case 21: 
      return new PubAccountMailJsPlugin();
    case 7: 
      return new PublicAccountH5AbilityPlugin();
    case 5: 
      return new PublicAccountJavascriptInterface();
    case 84: 
      return new PublicAccountPayJsPlugin();
    case 6: 
      return new PublicAccountWebviewPlugin();
    case 42: 
      return new QQApiPlugin();
    case 85: 
      return new QQCardJsPlugin();
    case 33: 
      return new QQConnectPlugin();
    case 87: 
      return new QQWIFIPlugin();
    case 86: 
      return new QQWiFiJsPlugin();
    case 88: 
      return new QWalletCommonJsPlugin();
    case 89: 
      return new QWalletPayJsPlugin();
    case 115: 
      return new QZoneCoverStoreJsPlugin();
    case 113: 
      return new QZoneFamousUserHomeJsPlugin();
    case 116: 
      return new QZonePersonalizePlugin();
    case 23: 
      return new QZoneTihSettingWebPlugin();
    case 112: 
      return new QZoneWebViewPlugin();
    case 114: 
      return new QzoneSelectMoodPictureJsPlugin();
    case 111: 
      return new QzoneWebMusicJsPlugin();
    case 24: 
      return new QzoneWebViewOfflinePlugin();
    case 51: 
      return new RecentCallPluginInfo();
    case 52: 
      return new RedTouchWebviewHandler();
    case 53: 
      return new RemindJavascriptInterface();
    case 29: 
      return new SSOWebviewPlugin();
    case 3: 
      return new SensorAPIJavaScript();
    case 26: 
      return new ShareApiPlugin();
    case 54: 
      return new ShortVideoJsApiPlugin();
    case 43: 
      return new SmsApiPlugin();
    case 90: 
      return new StarJsPlugin();
    case 91: 
      return new SuitUIPlugin();
    case 92: 
      return new ThemeAndBubbleCommonJsPlugin();
    case 93: 
      return new ThemeJsPlugin();
    case 94: 
      return new ThemeUiPlugin();
    case 44: 
      return new TroopApiPlugin();
    case 57: 
      return new TroopAssistantFeedsJsHandler();
    case 117: 
      return new TroopHWJsPlugin();
    case 8: 
      return new TroopMemberApiPlugin();
    case 30: 
      return new TroopMemberLevelJSAPI();
    case 58: 
      return new TroopNoticeJsHandler();
    case 55: 
      return new TroopWebviewPlugin();
    case 45: 
      return new UiApiPlugin();
    case 31: 
      return new UrlCheckPlugin();
    case 96: 
      return new VasCommonJsPlugin();
    case 108: 
      return new VipComicEmoticonJsPlugin();
    case 100: 
      return new VipComicJsPlugin();
    case 101: 
      return new VipFunCallJsPlugin();
    case 102: 
      return new VipFunctionJsPlugin();
    case 104: 
      return new VipGiftPlugin();
    case 35: 
      return new VipSpecialSoundWebViewPlugin();
    case 56: 
      return new VipTroopUpgradePlugin();
    case 103: 
      return new VipVideoApiPlugin();
    case 46: 
      return new WebRecordApiPlugin();
    case 32: 
      return new WebSoPlugin();
    case 106: 
      return new WebViewJumpPlugin();
    case 119: 
      return new QQReaderJsPlugin();
    }
    return new BuscardJsPlugin();
  }
  
  public static WebViewPlugin a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a.containsKey(paramString))) {
      return a(((Integer)a.get(paramString)).intValue());
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\WebViewPluginFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */