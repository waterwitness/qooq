package common.config.service;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import xxz;

public class QzoneConfig
{
  public static final String A = "QZonePerformance";
  public static final String B = "SafeModeSetting";
  public static final String C = "NavigationBar";
  public static final String D = "HomepageBar";
  public static final String E = "MiniVideo";
  public static final String F = "TrimVideo";
  public static final String G = "PhotoAlbum";
  public static final String H = "QZVideo";
  public static final String I = "TravelingBottomPhoto";
  public static final String J = "ShowRecommendPageEntry";
  public static final String K = "qzoneReport";
  public static final String L = "upload_switch";
  public static final String M = "qzonelivevideo_livehost";
  public static final String N = "module_jump_native";
  public static final String O = "AlbumBtnTitle";
  public static final String P = "QzoneFacade";
  public static final String Q = "QZoneGetUserTimeLogo";
  public static final String R = "GetUserTimeLogoInterval";
  public static final String S = "QZFacade_visible";
  public static final String T = "BizFeeds";
  public static final String U = "PhotoEditor";
  public static final String V = "ShowMagicStick";
  public static final String W = "PasterStandardCpuCore";
  public static final String X = "PasterStandardCpuFrequency";
  public static final String Y = "PasterStandardRamSize";
  public static final String Z = "PasterEnablePerformanceTest";
  public static final int a = 0;
  public static QzoneConfig a;
  public static final String a = "LiveSetting";
  public static final String aA = "EndTime";
  public static final String aB = "ShowSigninBanner";
  public static final String aC = "ExtraConfig";
  public static final String aD = "WifiCarrierType";
  public static final String aE = "MinBytes";
  public static final String aF = "MaxNum";
  public static final String aG = "LowSpeed";
  public static final String aH = "HighSpeed";
  public static final String aI = "KeepAlive";
  public static final String aJ = "KeepAliveProxy";
  public static final String aK = "EnableColor";
  public static final String aL = "AutoWiFi";
  public static final String aM = "Auto3G";
  public static final String aN = "Auto2G";
  public static final String aO = "QualityLow";
  public static final String aP = "QualityMid";
  public static final String aQ = "QualityHigh";
  public static final String aR = "ResolutionLow";
  public static final String aS = "ResolutionHigh";
  public static final String aT = "WebPQualityLow";
  public static final String aU = "WebPQualityHigh";
  public static final String aV = "Description";
  public static final String aW = "UploadQuality";
  public static final String aX = "FileSizeLimitForShowOrigVideo";
  public static final String aY = "UseLocalQuality";
  public static final String aZ = "RemindUploadSizeIsLargeThreshold";
  public static final String aa = "PasterBlackList";
  public static final String ab = "PasterWhiteList";
  public static final String ac = "Danmuku";
  public static final String ad = "RequestBullets";
  public static final String ae = "QzoneTTTReportSetting";
  public static final String af = "LeaveWifiCheckSize";
  public static final String ag = "QzoneHomepage";
  public static final String ah = "DropFrame_Interval";
  public static final String ai = "DropFrame_DropCount";
  public static final String aj = "DropFrame_Stack_Threshold";
  public static final String ak = "FeedActionReportSessionSize";
  public static final String al = "ADFeedExposeTime";
  public static final String am = "famousWhiteList";
  public static final String an = "sharewhitelist";
  public static final String ao = "TTTRealTimeReportList";
  public static final String ap = "UpdateCountIntervalWhenActiveApp";
  public static final String aq = "UpdateCountIntervalWhenClickFeedTab";
  public static final String ar = "videodefinitionwifi";
  public static final String as = "localVideoPlayDataCountLimit";
  public static final String at = "videodefinitionmobileconn";
  public static final String au = "videoplayfirstsegment";
  public static final String av = "URL";
  public static final String aw = "QZONE_FLASH_URL";
  public static final String ax = "QZONE_FLASH_BEGINTIME";
  public static final String ay = "QZONE_FLASH_ENDTIME";
  public static final String az = "BeginTime";
  public static final int b = 1;
  public static final String b = "TtpicSoZipUrl";
  public static final String bA = "VideoPartConcurrentCount";
  public static final String bB = "AlbumMaxPhotoCount";
  public static final String bC = "FileSizeLimitForNonVip";
  public static final String bD = "FileSizeLimit";
  public static final String bE = "VideoDurationThreshold";
  public static final String bF = "VideoCanUploadDurationThreshold";
  public static final String bG = "RecommendVideoTip";
  public static final String bH = "setDynamicAlbumSelectLimit";
  public static final String bI = "closedynamicAlbum";
  public static final String bJ = "dynamicAlbumUrl";
  public static final String bK = "http://h5s.qzone.qq.com/dynamic/album/tpl?source=1&_ws=5&preview=1&_wv=2098179";
  public static final String bL = "EnableWatermarkCamera";
  public static final String bM = "ReportLogSample";
  public static final String bN = "MoodPreloadNetConfig";
  public static final String bO = "PreloadCountWifi";
  public static final String bP = "PreloadCount3G";
  public static final String bQ = "PreloadCount2G";
  public static final String bR = "IPList";
  public static final String bS = "OptimumIP1";
  public static final String bT = "OptimumIP2";
  public static final String bU = "PhotoURL1";
  public static final String bV = "PhotoURL2";
  public static final String bW = "PhotoURL3";
  public static final String bX = "BackupIP1";
  public static final String bY = "BackupIP2";
  public static final String bZ = "OptimumIP_MobileLog";
  public static final String ba = "MaxNum";
  public static final String bb = "MoodWebPictureAddMore";
  public static final String bc = "MoodPhotoMaxNum";
  public static final String bd = "RedDotAutoDisappearedTime";
  public static final String be = "RedDotAppearFrequency";
  public static final String bf = "Tier1CPU";
  public static final String bg = "Tier2CPU";
  public static final String bh = "Tier3CPU";
  public static final String bi = "Tier1RAM";
  public static final String bj = "Tier2RAM";
  public static final String bk = "Tier3RAM";
  public static final String bl = "Tier1MaxNum";
  public static final String bm = "Tier2MaxNum";
  public static final String bn = "Tier3MaxNum";
  public static final String bo = "3GQuality";
  public static final String bp = "WIFIQuality";
  public static final String bq = "UploadPort";
  public static final String br = "ConnectTimeout";
  public static final String bs = "DataTimeout";
  public static final String bt = "TimeoutRetryCount";
  public static final String bu = "MaxConcurrentNum";
  public static final String bv = "VideoPartRetryCount";
  public static final String bw = "VideoFileRetryCount";
  public static final String bx = "VideoPartSize";
  public static final String by = "VideoPartSizeFor2G";
  public static final String bz = "VideoPartSizeFor3G";
  public static final int c = 2;
  public static final String c = "http://qzonestyle.gtimg.cn/qzone/photo/v7/js/common/images/lib_ttpic_so.zip";
  public static final String cA = "VisitorReportCount";
  public static final String cB = "VisitorReportInteval";
  public static final String cC = "OnlineReportFrequency";
  public static final String cD = "OnlineReportInterval";
  public static final String cE = "OnlineLocalSaveFrequency";
  public static final String cF = "OnlineReportFailureTimes";
  public static final String cG = "DisableVipInfoOnFriendFeed";
  public static final String cH = "TouchQzoneBlog";
  public static final String cI = "TouchQzoneMsgb";
  public static final String cJ = "TouchQzoneMood";
  public static final String cK = "TouchQzoneGift";
  public static final String cL = "TouchQzonePhoto";
  public static final String cM = "TouchQzoneShare";
  public static final String cN = "TouchQzoneOther";
  public static final String cO = "TouchQzoneProfile";
  public static final String cP = "ReConnCount";
  public static final String cQ = "RetryTime";
  public static final String cR = "RetryInterval";
  public static final String cS = "AccReportCount";
  public static final String cT = "AccReportSamples";
  public static final String cU = "AccReportInterval";
  public static final String cV = "CoordinateCacheTime";
  public static final String cW = "POICacheDistance";
  public static final String cX = "POICacheTime";
  public static final String cY = "WeatherCacheTime";
  public static final String cZ = "LBSPreload";
  public static final String ca = "BackupIP_MobileLog";
  public static final String cb = "PhotoURL4";
  public static final String cc = "AllowVoiceMood";
  public static final String cd = "AllowVoiceOP";
  public static final String ce = "AllowVoiceForward";
  public static final String cf = "MaxReceiverCount";
  public static final String cg = "ShowOPDelay";
  public static final String ch = "DelayShowLoading";
  public static final String ci = "RestrictBeginTime";
  public static final String cj = "RestrictEndTime";
  public static final String ck = "RestrictFlag";
  public static final String cl = "PreloadQuanCount";
  public static final String cm = "LevelFlag";
  public static final String cn = "FeedsLevelFlag";
  public static final String co = "DetailLevelFlag";
  public static final String cp = "RestrictFlag";
  public static final String cq = "MergeMessage";
  public static final String cr = "BlackListVersion";
  public static final String cs = "TraceReportURL";
  public static final String ct = "TcSDKReportURL";
  public static final String cu = "MonitorH5ReportURL";
  public static final String cv = "TraceReportInterval";
  public static final String cw = "TraceReportCount";
  public static final String cx = "TraceReportSamples";
  public static final String cy = "MonitorH5ReportSamples";
  public static final String cz = "VisitorReportStopSeconds";
  public static final int d = 0;
  public static final String d = "PituLimited";
  public static final String dA = "video_masterIplist";
  public static final String dB = "video_backupIplist";
  public static final String dC = "optimumip_qzvv";
  public static final String dD = "qzpb.qq.com";
  public static final String dE = "VideoSrvList";
  public static final String dF = "WaitVkeyTimeout";
  public static final String dG = "quoteMaxNum";
  public static final String dH = "video_host_qzvv";
  public static final String dI = "video_host_qzpb";
  public static final String dJ = "OpenOriginalUpload";
  public static final String dK = "CoverBannerSwitch";
  public static final String dL = "FeedTextMaxLine";
  public static final String dM = "UploadQuality";
  public static final String dN = "UploadResolution";
  public static final String dO = "ip_no_pmtu_disc";
  public static final String dP = "CompressToWebp";
  public static final String dQ = "TextToBitmap";
  public static final String dR = "BitmapMemoryThreshold";
  public static final String dS = "MoodRecentPhotoTime";
  public static final String dT = "MoodRecentPhotoCount";
  public static final String dU = "StartDuration";
  public static final String dV = "CrashMax";
  public static final String dW = "CrashClearItems";
  public static final String dX = "FriendMaxSelectCount";
  public static final String dY = "FriendMaxSelectCountComment";
  public static final String dZ = "GroupTimeMin";
  public static final String da = "GPSPrelocateMaxTimeout";
  public static final String db = "GPSLocateMaxTimeout";
  public static final String dc = "AvatarURL";
  public static final String dd = "EmotionURL";
  public static final String de = "FlowerVineURL";
  public static final String df = "PhotoABSvrList";
  public static final String dg = "DownloadBackupIP";
  public static final String dh = "DownloadDirectIP";
  public static final String di = "SwitchTimes";
  public static final String dj = "RetryTimes";
  public static final String dk = "photo_masterIplist";
  public static final String dl = "photo_backupIplist";
  public static final String dm = "DownloadAccessPortList";
  public static final String dn = "DownloadIPValidTime";
  public static final String jdField_do = "DownloadCustomDnsEnable";
  public static final String dp = "DownloadDirectIP_a";
  public static final String dq = "DownloadDirectIP_b";
  public static final String dr = "DownloadBackupIP_a";
  public static final String ds = "DownloadBackupIP_b";
  public static final String dt = "photo_masterIplist_a";
  public static final String du = "photo_backupIplist_a";
  public static final String dv = "photo_masterIplist_b";
  public static final String dw = "photo_backupIplist_b";
  public static final String dx = "KpDomainList";
  public static final String dy = "DownloadDirectIPVideo";
  public static final String dz = "DownloadBackupIPVideo";
  public static final int e = 1000;
  public static final String e = "ModualWhiteList";
  public static final String eA = "PhotoGuideEventEnable";
  public static final String eB = "secondary_album_photo_show_start_hour";
  public static final String eC = "secondary_album_photo_show_end_hour";
  public static final String eD = "secondary_album_photo_enbale";
  public static final String eE = "secondary_album_photo_min_photo_cnt_per_group";
  public static final String eF = "secondary_album_photo_check_max_days";
  public static final String eG = "secondary_album_photo_group_interval_hour";
  public static final String eH = "secondary_album_photo_group_valid_distance";
  public static final String eI = "secondary_album_photo_group_city_time_limit";
  public static final String eJ = "PluginErrorHandleCount";
  public static final String eK = "PluginPermissionErrorHandle";
  public static final String eL = "PreLoadActiveFeeds";
  public static final String eM = "PreLoadGroupFeeds";
  public static final String eN = "ExifEnable";
  public static final String eO = "BlobCacheEnable";
  public static final String eP = "PreloadQzoneProcessEnable";
  public static final String eQ = "PreloadQzoneProcessRamThreshold";
  public static final String eR = "ShowFeedOpLayer";
  public static final String eS = "DbOptiSync";
  public static final String eT = "EnableFeedPreload";
  public static final String eU = "MusicPlayDetailUrl";
  public static final String eV = "BgMusicManagerUrl";
  public static final String eW = "JsBridgeAllowHostsList";
  public static final String eX = "QunAioRememberUpload";
  public static final String eY = "QunAioCheckBoxState";
  public static final String eZ = "QunAiOthresholdNum";
  public static final String ea = "GroupTimeMax";
  public static final String eb = "GroupDistanceMax";
  public static final String ec = "GroupMergeCount";
  public static final String ed = "RecentPhotoTipsCount";
  public static final String ee = "GroupOldDate";
  public static final String ef = "FeedBannerDuration";
  public static final String eg = "FeedBannerActiveMaxCount";
  public static final String eh = "ExposePhotoTimeRange";
  public static final String ei = "ExposePhotoMinCount";
  public static final String ej = "ExposePhotoGuideTimes";
  public static final String ek = "GuideShowOpen";
  public static final String el = "GuideSelectPhoto";
  public static final String em = "GuideSelectPhotoSendRedJumpToQzone";
  public static final String en = "PhotoUploadGuideScanTimeInterval";
  public static final String eo = "PhotoUploadRedPointTimeInterval";
  public static final String ep = "PhotoUploadPhotoMinSize";
  public static final String eq = "PhotoUploadPhotoMaxSize";
  public static final String er = "PhotoUploadPhotoChangeStrategy";
  public static final String es = "PhotoGuideEventUploadCheckIntervalTime";
  public static final String et = "PhotoGuideEventUnexposureMinPhotos";
  public static final String eu = "PhotoGuideEventNonWifiMaxPhotos";
  public static final String ev = "PhotoGuideEventNonWifiMaxDays";
  public static final String ew = "PhotoGuideEventWiffMaxDay";
  public static final String ex = "PhotoGuideEventStartHour";
  public static final String ey = "PhotoGuideEventWifiFirstEventDays";
  public static final String ez = "PhotoGuideEventShowScenePoint";
  public static final int f = 1;
  public static final String f = "LoadingPhoto";
  public static final String fA = "ItemOrder";
  public static final String fB = "maxUgcTextCount";
  public static final String fC = "shareMaxSelectCount";
  public static final String fD = "whoCanCommentMyQzone";
  public static final String fE = "NewestFeedsMinTimeCell";
  public static final String fF = "NewestFeedsUinNum";
  public static final String fG = "NewestFeedsRetryNum";
  public static final String fH = "NewestFeedsMinRefreshTimeCell";
  public static final String fI = "QunAlbumSelect";
  public static final String fJ = "QunAlbumPhotoList";
  public static final String fK = "QunAlbumDetail";
  public static final String fL = "QunAlbum";
  public static final String fM = "QunFeed";
  public static final String fN = "QunPassiveFeed";
  public static final String fO = "FeedTextMaxLine";
  public static final String fP = "FeedSummaryExpandDirect";
  public static final String fQ = "FeedSummaryMaxMaxLine";
  public static final String fR = "FeedSummaryMinMaxLine";
  public static final String fS = "FeedSummaryShowNumUnExpand";
  public static final String fT = "ShowMoodSyncWeiboButton";
  public static final String fU = "Schema";
  public static final String fV = "DownloadSongInQQMusic";
  public static final String fW = "DownloadQQMusicClient";
  public static final String fX = "QzUrlCache";
  public static final String fY = "OfflineCacheWhiteList";
  public static final String fZ = "OfflineCacheExt2MimeType";
  public static final String fa = "PermitPreDownload";
  public static final String fb = "ShowNavigatorGameTab";
  public static final String fc = "bar_iconurl";
  public static final String fd = "bar_name";
  public static final String fe = "bar_schema";
  public static final String ff = "bar_visiable";
  public static final String fg = "bar_personalize_iconurl";
  public static final String fh = "bar_personalize_name";
  public static final String fi = "bar_personalize_schema";
  public static final String fj = "bar_personalize_visiable";
  public static final String fk = "bar_personalize_countid";
  public static final String fl = "bar_vip_jumpurl";
  public static final String fm = "bar_vip_visible";
  public static final String fn = "bar_vip_name";
  public static final String fo = "bar_vip_iconurl";
  public static final String fp = "bar_music_visiable";
  public static final String fq = "bar_loversspace_iconurl";
  public static final String fr = "bar_loversspace_name";
  public static final String fs = "bar_loversspace_visible";
  public static final String ft = "FriendSetting";
  public static final String fu = "bar_famouszone_schema";
  public static final String fv = "bar_famouszone_visible";
  public static final String fw = "bar_campuszone_schema";
  public static final String fx = "ItemCount";
  public static final String fy = "ItemAttribute";
  public static final String fz = "ItemDownURLPrefix";
  public static final int g = 1;
  public static final String g = "EasterEgg";
  public static final String gA = "FamousHomePage";
  public static final String gB = "SignIn";
  public static final String gC = "GameBar";
  public static final String gD = "SeeMyVisitorPersimmonSetting";
  public static final String gE = "SeeMyCommentPermissionSetting";
  public static final String gF = "SeeMyQzonePermissionSetting";
  public static final String gG = "HideSeeHis";
  public static final String gH = "HideHisRecord";
  public static final String gI = "GiftDetail";
  public static final String gJ = "ReturnGiftList";
  public static final String gK = "FeedVisitor";
  public static final String gL = "PersonalQzoneVisitor";
  public static final String gM = "NickNameFlash";
  public static final String gN = "QzoneVisitor";
  public static final String gO = "CardStore";
  public static final String gP = "CardPreview";
  public static final String gQ = "CardList";
  public static final String gR = "AvatarSetting";
  public static final String gS = "AvatarPreview";
  public static final String gT = "VipPay";
  public static final String gU = "WeiXinDownload";
  public static final String gV = "MemorySeal";
  public static final String gW = "DisableForbidComment";
  public static final String gX = "CoverStore";
  public static final String gY = "CoverPreview";
  public static final String gZ = "CoverList";
  public static final String ga = "VideoEdit";
  public static final String gb = "VideoBgMusicSelectUrl";
  public static final String gc = "UploadMaxSizeTipWithNoWifi";
  public static final String gd = "VipQualityLimitSize";
  public static final String ge = "SupportMixMusicMaxSize";
  public static final String gf = "SupportClipMaxTime";
  public static final String gg = "SupportEditVideo";
  public static final String gh = "VideoLoadErrorReturnCode";
  public static final String gi = "H5Url";
  public static final String gj = "FloatingViewForFontPay";
  public static final String gk = "FontStore";
  public static final String gl = "BuyFeedUrl";
  public static final String gm = "PhotoRecycle";
  public static final String gn = "VipProfile";
  public static final String go = "VipPK";
  public static final String gp = "MoodEdit";
  public static final String gq = "NameplateMainPageAddr";
  public static final String gr = "bar_loversspace_schema";
  public static final String gs = "LoversSpace";
  public static final String gt = "Report";
  public static final String gu = "FeedSkinUrl";
  public static final String gv = "EasterEgg";
  public static final String gw = "WhisperEgg";
  public static final String gx = "EggPhotoLayerType";
  public static final String gy = "LikeListPage";
  public static final String gz = "ShowMoreDelicacyPicture";
  public static final int h = 0;
  public static final String h = "PublishMood";
  public static final String hA = "CustomVipPreview";
  public static final String hB = "RetryMaxNum";
  public static final String hC = "QzCustomFont";
  public static final String hD = "DownloadFontAnyway";
  public static final String hE = "PerformanceMonitor";
  public static final String hF = "Rate";
  public static final String hG = "Duration";
  public static final String hH = "Interval";
  public static final String hI = "SupportMiniVideo";
  public static final String hJ = "SupportTrimVideo";
  public static final String hK = "SupportTrimVideoHW";
  public static final String hL = "IgnoreLocalJudge";
  public static final String hM = "NeedLocalBlackList";
  public static final String hN = "SupportedCpuFamily";
  public static final String hO = "RequiredCpuFeatures";
  public static final String hP = "MinCpu";
  public static final String hQ = "MinRam";
  public static final String hR = "MinAvailableRam";
  public static final String hS = "MinSdkVersion";
  public static final String hT = "MinRuntimeRam";
  public static final String hU = "ClientCompress";
  public static final String hV = "VideoMaxBitrate";
  public static final String hW = "VideoLongestEdge";
  public static final String hX = "FrameRate";
  public static final String hY = "AudioMaxSample";
  public static final String hZ = "AudioMaxBitrate";
  public static final String ha = "PhotoWallUrl";
  public static final String hb = "FacadeStore";
  public static final String hc = "LiveList";
  public static final String hd = "QZoneUgcPermissionUsersUrl";
  public static final String he = "QZoneAlbumVisitors";
  public static final String hf = "QZoneAlbumComments";
  public static final String hg = "WriteBlog";
  public static final String hh = "PreviewAlbumFacadeCate";
  public static final String hi = "DownloadQzoneClient";
  public static final String hj = "SwitchReact";
  public static final String hk = "RNMessageMaxCrashTimes";
  public static final String hl = "ReactBundleServerUrl";
  public static final String hm = "UgcPermitSetting";
  public static final String hn = "VideoIdleScrollYMinDistance";
  public static final String ho = "VideoRecommendAutoRotationEnable";
  public static final String hp = "AutoScrollToNextVideoDelayTime";
  public static final String hq = "VisitNotifySetting";
  public static final String hr = "SendBirthdayGift";
  public static final String hs = "AlbumVisitorList";
  public static final String ht = "AlbumLikeList";
  public static final String hu = "SpecialFriendManage";
  public static final String hv = "ExcludePermisionPage";
  public static final String hw = "QzoneSettingMainPage";
  public static final String hx = "QzonePictureSettingPage";
  public static final String hy = "PersonalizeMainPage";
  public static final String hz = "CustomVipMall";
  public static final int i = 0;
  public static final String i = "PhotoDownload";
  public static final String iA = "useQQPluginManager";
  public static final String iB = "videoTaskRetryForDisconnect";
  public static final String iC = "videoTaskRetryForConnectFailed";
  public static final String iD = "videoTaskRetryForBuildFailed";
  public static final String iE = "videoRetryDownHigh";
  public static final String iF = "videoRetryDownMedium";
  public static final String iG = "videoRetryDownLow";
  public static final String iH = "videoTimeNoTrimThreshold";
  public static final String iI = "videoPublishOnErrorSize";
  public static final String iJ = "videoTrimEnableHw";
  public static final String iK = "videoCacheProvider";
  public static final String iL = "videoTrimMinAvailRam";
  public static final String iM = "videoTrimUltrafastAvailRam";
  public static final String iN = "videoTrimSuperfastAvailRam";
  public static final String iO = "videoTrimMediumAvailRam";
  public static final String iP = "videoSupportWindowPlay";
  public static final String iQ = "videoSVInteractMaxRecordTime";
  public static final String iR = "videoWindowPlayCloseAreaPercent";
  public static final String iS = "FloatingViewForPay";
  public static final String iT = "GiftDetailPage";
  public static final String iU = "PhoneLabelSetting";
  public static final String iV = "DescriptionSetting";
  public static final String iW = "BlogListJumpUrl";
  public static final String iX = "CallMusicWNS";
  public static final String iY = "CallMusicWNSCoreAndMem";
  public static final String iZ = "CallQZoneWNS";
  public static final String ia = "VideoPreset";
  public static final String ib = "VideoTune";
  public static final String ic = "VideoProfile";
  public static final String id = "VideoLevel";
  public static final String ie = "VideoNativeLog";
  public static final String jdField_if = "preLoadDuration";
  public static final String ig = "maxPreLoadSize";
  public static final String ih = "maxCacheSize";
  public static final String ii = "videoFloatControllerTimeout";
  public static final String ij = "videoEnableProxy";
  public static final String ik = "videoEnableCache";
  public static final String il = "IllegalVideoCheckDataCacheDuration";
  public static final String im = "videoLowSpeedSeconds";
  public static final String in = "videoLowSpeedRates";
  public static final String io = "videoContentType";
  public static final String ip = "videoTcPathType";
  public static final String iq = "videoNormalPathType";
  public static final String ir = "videoSafeUrlTimeOut";
  public static final String is = "ResumePlayReportMinTime";
  public static final String it = "liveUgcPermissionPage";
  public static final String iu = "liveCanPreload";
  public static final String iv = "requestSafeUrlFeeds";
  public static final String iw = "checkVideoFeeds";
  public static final String ix = "requestSafeUrlRecommend";
  public static final String iy = "checkVideoRecommend";
  public static final String iz = "videoVkeyTimeOut";
  public static final int j = 1;
  public static final String j = "PhotoUpload";
  public static final String jA = "activeMoodBtnEnterPhotoUpload";
  public static final String jB = "FeedsShowPhotoBubble";
  public static final String jC = "ExposePhotoBubbleTimeRange";
  public static final String jD = "ExposePhotoBubbleShowTime";
  public static final String jE = "ExposePhotoBubbleScrollShowTime";
  public static final String jF = "StarVipMainPageUrl";
  public static final String jG = "StarVipUrl";
  public static final String jH = "VipProfile";
  public static final String jI = "isShowSafeMode";
  public static final String jJ = "NativeHook";
  public static final String jK = "NativeHookSDK";
  public static final String jL = "DetailMaxPicShowNum";
  public static final String jM = "QzoneVisitDownload";
  public static final String jN = "Avatalistpage";
  public static final String jO = "FloatStandardCpuCore";
  public static final String jP = "FloatStandardCpuFequency";
  public static final String jQ = "FloatStandardCpuRamSize";
  public static final String jR = "FloatStandard4CoreCpuRamSize";
  public static final String jS = "FloatModelBlacklist";
  public static final String jT = "N5117,R8007,Coolpad 8720L,R7007,GN9000L,G620-L75,R2017,R6007,R831S,HM 1SC,Coolpad 8705,HUAWEI B199,Coolpad 9190L,HM 1SW,Coolpad 8730L";
  public static final String jU = "SuperCoverStandardCpuCore";
  public static final String jV = "SuperCoverStandardCpuFequency";
  public static final String jW = "SuperCoverStandardCpuRamSize";
  public static final String jX = "SuperCoverStandard4CoreCpuRamSize";
  public static final String jY = "FakeFeedInvalidTime";
  public static final String jZ = "FakeFeedRetryTime";
  public static final String ja = "CallQZoneWNSFromPush";
  public static final String jb = "CallQZoneWNSFromPushVersion";
  public static final String jc = "CallQZoneWNSFromLivePushVersion";
  public static final String jd = "CallQZoneWNSFromPushFailCnt";
  public static final String je = "CallQZoneWNSFromPushTimeoutCnt";
  public static final String jf = "CallQZoneWNSFromPushTimeout";
  public static final String jg = "CallQZoneWNSFromPushReport";
  public static final String jh = "CallQZoneWNSFromPushCtrlFlag";
  public static final String ji = "CallQZoneWNSFromPushCtrlFlag2";
  public static final String jj = "PushDeduplication";
  public static final String jk = "JumpQZoneEnable";
  public static final String jl = "JumpQZoneSchemeEnable";
  public static final String jm = "DownloadQZoneAppUrl";
  public static final String jn = "LatestWebappTimeStampCount";
  public static final String jo = "LatestWebappIPCount";
  public static final String jp = "MedalJumpUrl";
  public static final String jq = "LatestWebappIPRecordSeconds";
  public static final String jr = "MsgListUrl";
  public static final String js = "WidgetDetail";
  public static final String jt = "FeedNickNameSplashCount";
  public static final String ju = "ForbidShowDeleteVisitor";
  public static final String jv = "FeedsShowMoodEntry";
  public static final String jw = "detailDialogShowTime";
  public static final String jx = "Patch";
  public static final String jy = "PatchPreloadInterval";
  public static final String jz = "FeedsSinglePictureBigPictureModeCoefficent";
  public static final int k = 2;
  public static final String k = "PhotoDomainIP";
  public static final String kA = "ResForbiddenList";
  public static final String kB = "QZVideo";
  public static final String kC = "VideoLayerShowAdvTipsDuration";
  public static final String kD = "SpecialPushHide";
  public static final String kE = "FriendFeedRefreshInternal";
  public static final String kF = "FriendFeedClickToTopShowLimit";
  public static final String kG = "FriendFeedClickToTopLimit";
  public static final String kH = "frivideobnrtimeinterval";
  public static final String kI = "FacadeStore";
  private static final String kJ = "QzoneConfig";
  private static final String kK = "CMD_PRINT_WNS_CONFIG";
  public static final String ka = "enableQzoneShowIconAtHomePage";
  public static final String kb = "HtmlStandardCpuCore";
  public static final String kc = "HtmlStandardCpuFequency";
  public static final String kd = "HtmlStandardRAMSize";
  public static final String ke = "HtmlForceClose";
  public static final String kf = "h5.qzone.qq.com/bgstore/dynamiccover";
  public static final String kg = "dynamicCoverPreviewUrl";
  public static final String kh = "tplId=";
  public static final String ki = "dynamicCoverPreviewKeyword";
  public static final String kj = "LiveVideoPreLoadEnterRoomIpAction";
  public static final String kk = "LiveVideoFloatLayerEntry";
  public static final String kl = "LiveVideoDuliDownload";
  public static final String km = "LiveVideoPlusEntry";
  public static final String kn = "QzUrlCache";
  public static final String ko = "HttpProxyHost2Command";
  public static final String kp = "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"} }";
  public static final String kq = "isPatchEnable";
  public static final String kr = "use_new_command";
  public static final String ks = "max_pending_report_task_num";
  public static final String kt = "max_report_task_pengding_day";
  public static final String ku = "can_report_task_run_at_front";
  public static final String kv = "avatar_timeout";
  public static final String kw = "videoRecommendFloat";
  public static final String kx = "videoWindowManagerEnable";
  public static final String ky = "VideoAutoPlayTips";
  public static final String kz = "RedPocketPayList";
  public static final int l = 0;
  public static final String l = "VoiceMood";
  public static final int m = 1;
  public static final String m = "PhotoSvrList";
  public static final int n = 2;
  public static final String n = "VideoSvrList";
  public static final int o = 3;
  public static final String o = "Gift";
  public static final String p = "PhotoView";
  public static final String q = "FeedsPre";
  public static final String r = "Push";
  public static final String s = "ReportSetting";
  public static final String t = "JumpQzone";
  public static final String u = "OutBox";
  public static final String v = "WNSSettting";
  public static final String w = "QZoneSetting";
  public static final String x = "TraceLog";
  public static final String y = "QunAlbumSetting";
  public static final String z = "QzoneCover";
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile int p;
  
  private QzoneConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.p = 0;
    g();
  }
  
  private Handler a()
  {
    HandlerThread localHandlerThread = new HandlerThread("config_content");
    localHandlerThread.start();
    return new Handler(localHandlerThread.getLooper());
  }
  
  public static QzoneConfig a()
  {
    if (jdField_a_of_type_CommonConfigServiceQzoneConfig == null) {}
    try
    {
      if (jdField_a_of_type_CommonConfigServiceQzoneConfig == null) {
        jdField_a_of_type_CommonConfigServiceQzoneConfig = new QzoneConfig();
      }
      return jdField_a_of_type_CommonConfigServiceQzoneConfig;
    }
    finally {}
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver == null) {
      this.jdField_a_of_type_AndroidDatabaseContentObserver = new xxz(this, a());
    }
  }
  
  private void e()
  {
    if ((BaseApplication.getContext() != null) && (BaseApplication.getContext().getContentResolver() != null)) {}
    try
    {
      d();
      BaseApplication.getContext().getContentResolver().registerContentObserver(QZoneConfigProvider.c, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QzoneConfig", 2, "registObserver 异常", localException);
    }
  }
  
  private void f()
  {
    a().a();
  }
  
  private void g()
  {
    e();
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 == null) {
      return paramInt;
    }
    try
    {
      int i1 = Integer.valueOf(paramString1).intValue();
      return i1;
    }
    catch (Exception paramString1) {}
    return paramInt;
  }
  
  public long a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 == null) {
      return paramLong;
    }
    try
    {
      long l1 = Long.valueOf(paramString1).longValue();
      return l1;
    }
    catch (Exception paramString1) {}
    return paramLong;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str2;
    String str3;
    if ((paramString1 != null) && (paramString2 != null))
    {
      str2 = paramString1.toLowerCase();
      str3 = paramString2.toLowerCase();
      paramString1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
      if (paramString1 != null) {
        break label114;
      }
      paramString1 = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, paramString1);
    }
    label114:
    for (;;)
    {
      if (paramString1 != null)
      {
        String str1 = (String)paramString1.get(str3);
        paramString2 = str1;
        if (str1 == null)
        {
          paramString2 = str1;
          if (2 != this.p)
          {
            str1 = QZConfigProviderUtil.a(str2, str3);
            paramString2 = str1;
            if (str1 != null)
            {
              paramString1.put(str3, str1);
              paramString2 = str1;
            }
          }
        }
        return paramString2;
      }
      return null;
    }
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString3;
    }
    return paramString1;
  }
  
  public void a()
  {
    int i2;
    int i1;
    try
    {
      WeakReference[] arrayOfWeakReference = new WeakReference[this.jdField_a_of_type_JavaUtilArrayList.size()];
      arrayOfWeakReference = (WeakReference[])this.jdField_a_of_type_JavaUtilArrayList.toArray(arrayOfWeakReference);
      i2 = arrayOfWeakReference.length;
      i1 = 0;
    }
    catch (Throwable localThrowable)
    {
      if (!QLog.isColorLevel()) {
        break label71;
      }
      QLog.e("QzoneConfig", 1, "notifyConfigChange error", localThrowable);
    }
    QzoneConfig.QzoneConfigChangeListener localQzoneConfigChangeListener = (QzoneConfig.QzoneConfigChangeListener)localQzoneConfigChangeListener.get();
    if (localQzoneConfigChangeListener != null) {
      localQzoneConfigChangeListener.a();
    }
    label71:
    label91:
    for (;;)
    {
      return;
      for (;;)
      {
        if (i1 >= i2) {
          break label91;
        }
        localQzoneConfigChangeListener = localThrowable[i1];
        if (localQzoneConfigChangeListener != null) {
          break;
        }
        i1 += 1;
      }
    }
  }
  
  public void a(QzoneConfig.QzoneConfigChangeListener paramQzoneConfigChangeListener)
  {
    if (paramQzoneConfigChangeListener == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        Object localObject;
        do
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label77;
            }
            localObject = (WeakReference)localIterator.next();
            if (localObject != null)
            {
              localObject = (QzoneConfig.QzoneConfigChangeListener)((WeakReference)localObject).get();
              if (localObject != null) {
                break;
              }
              localIterator.remove();
            }
          }
        } while (!paramQzoneConfigChangeListener.equals(localObject));
      }
      finally {}
      continue;
      label77:
      this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramQzoneConfigChangeListener));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      c();
      Object localObject;
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.i("CMD_PRINT_WNS_CONFIG", 1, "打印全部配置");
        paramString1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          QLog.i("CMD_PRINT_WNS_CONFIG", 1, "mainKey = " + paramString2);
          paramString2 = (Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
          localObject = paramString2.keySet();
          QLog.i("CMD_PRINT_WNS_CONFIG", 1, "当前的的rawSet个数:" + ((Set)localObject).size());
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            QLog.i("CMD_PRINT_WNS_CONFIG", 1, str + " = " + (String)paramString2.get(str));
          }
        }
      }
      QLog.i("CMD_PRINT_WNS_CONFIG", 1, "打印对应mainkey:" + paramString1 + "的配置");
      paramString1 = (Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      paramString2 = paramString1.keySet();
      QLog.i("CMD_PRINT_WNS_CONFIG", 1, "当前的的rawSet个数:" + paramString2.size());
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        localObject = (String)paramString2.next();
        QLog.i("CMD_PRINT_WNS_CONFIG", 1, (String)localObject + " = " + (String)paramString1.get(localObject));
      }
    }
    QLog.i("CMD_PRINT_WNS_CONFIG", 1, "打印对应mainkey:" + paramString1 + ",对应secondKey:" + paramString2 + "的配置");
    paramString1 = a(paramString1, paramString2);
    QLog.i("CMD_PRINT_WNS_CONFIG", 1, paramString2 + " = " + paramString1);
    QLog.i("CMD_PRINT_WNS_CONFIG", 1, "结束打印WNS配置");
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    String str2;
    do
    {
      return;
      String str1 = paramString1.toLowerCase();
      str2 = paramString2.toLowerCase();
      paramString2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new ConcurrentHashMap();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, paramString1);
      }
    } while (paramString1 == null);
    paramString1.put(str2, paramString3);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  /* Error */
  public void b(QzoneConfig.QzoneConfigChangeListener paramQzoneConfigChangeListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 1837	common/config/service/QzoneConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: invokevirtual 1999	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 2004 1 0
    //   23: ifeq -17 -> 6
    //   26: aload_2
    //   27: invokeinterface 2007 1 0
    //   32: checkcast 1980	java/lang/ref/WeakReference
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull -20 -> 17
    //   40: aload_3
    //   41: invokevirtual 1989	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   44: checkcast 1991	common/config/service/QzoneConfig$QzoneConfigChangeListener
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +11 -> 60
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 2014	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: ifeq -40 -> 17
    //   60: aload_2
    //   61: invokeinterface 2010 1 0
    //   66: goto -49 -> 17
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	QzoneConfig
    //   0	74	1	paramQzoneConfigChangeListener	QzoneConfig.QzoneConfigChangeListener
    //   16	45	2	localIterator	Iterator
    //   35	19	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	17	69	finally
    //   17	36	69	finally
    //   40	48	69	finally
    //   52	60	69	finally
    //   60	66	69	finally
  }
  
  public void c()
  {
    if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
      throw new IllegalStateException("不要在UI线程中调用此方法");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneConfig", 2, "loadAllConfigs :" + this.p);
    }
    if (1 != this.p)
    {
      this.p = 1;
      try
      {
        if (QZConfigProviderUtil.a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap))
        {
          this.p = 2;
          return;
        }
        this.p = 3;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QzoneConfig", 2, "loadAllConfigs 异常", localException);
        }
        this.p = 3;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\common\config\service\QzoneConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */