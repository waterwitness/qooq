package com.tencent.mobileqq.app;

import QQService.TagInfo;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.speech.tts.TextToSpeech;
import android.support.v4.util.MQLruCache;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.accessibility.AccessibilityManager;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.tencent.arrange.op.ArrangeHandler;
import com.tencent.av.app.AvAddFriendService;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.VideoC2CHandler;
import com.tencent.bitapp.BitAppManager;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgFactory;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.addContactTroopView.AddContactTroopManage;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUStatistic;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.subscript.SubscriptHandler;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PAReportManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.qqcard.QQCardManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.mobileqq.activity.recent.RecentCallHandler;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloRecentManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyContainer;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyHandler;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfoHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.bubble.BubbleDiyHandler;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.struct.NearbyBannerManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.data.TagArrayByType;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.PrivacyInfoUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransProxy;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.hotpatch.HotPatchManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.jumplightalk.CallRedDotLightalkLis;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeHandler;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.PullActiveManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.musicgene.MusicPlayerHandler;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.nearby.NearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedtouchHandler;
import com.tencent.mobileqq.olympic.OlympicHandler;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler.IPluginManagerProvider;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.profile.upload.task.VipImageUploadManager;
import com.tencent.mobileqq.ptt.PttConfigController;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.qcall.LightalkShieldHandler;
import com.tencent.mobileqq.qcall.LightalkShieldManager;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.PstnHandler;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.redtouch.NumRedMsgManager;
import com.tencent.mobileqq.redtouch.NumRedPointManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.sensewhere.SenseWhereHandler;
import com.tencent.mobileqq.sensewhere.SenseWhereManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.DAUStatistic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.org.pb.TroopOrgProtocolManager;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager;
import com.tencent.mobileqq.troop.utils.TroopAioADManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopFileUploadingManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceManager;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PlistHandler;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.IndividuationABTestManager;
import com.tencent.mobileqq.vas.IndividuationManager;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vashealth.StepServiceAsync;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securemodule.impl.SecureModuleService;
import com.tencent.securemodule.service.CloudScanListener;
import com.tencent.securemodule.service.ISecureModuleService;
import com.tencent.securemodule.service.ProductInfo;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MsgAutoMonitorUtil;
import com.weiyun.sdk.context.SdkContext;
import cooperation.comic.QQComicPreloadManager;
import cooperation.comic.emoticon.VipComicEmoticonUploadManager;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.huangye.HuangyeHandler;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginManagerV2;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlinkReliableReport;
import cooperation.qlink.QlinkServiceManager;
import cooperation.qqfav.QfavHelper;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListHandler;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;
import cooperation.qqreader.QRProcessManager;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.plugin.QZonePluginManger;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.troop.TroopPluginManager;
import cooperation.weiyun.WeiyunHelper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AccountManagerImpl;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.ProxyIpManagerImpl;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;
import mqq.manager.PushManager;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import qdw;
import qdx;
import qdy;
import qdz;
import qea;
import qeb;
import qec;
import qed;
import qee;
import qef;
import qeg;
import qeh;
import qei;
import qej;
import qek;
import qel;
import qen;
import qeo;
import qep;
import qeq;
import qer;
import qes;
import qet;

public class QQAppInterface
  extends AppInterface
  implements PluginManageHandler.IPluginManagerProvider
{
  public static final int A = 35;
  public static final int B = 36;
  public static final int C = 37;
  public static final int D = 38;
  public static final int E = 39;
  public static final int F = 40;
  public static final int G = 41;
  public static final int H = 42;
  public static final int I = 43;
  public static final int J = 44;
  public static final int K = 45;
  public static final int L = 46;
  public static final int M = 47;
  public static final int N = 48;
  public static final int O = 49;
  public static final int P = 50;
  public static final int Q = 51;
  public static final int R = 52;
  public static final int S = 53;
  public static final int T = 54;
  public static final int U = 55;
  public static final int V = 56;
  public static final int W = 57;
  public static final int X = 58;
  public static final int Y = 59;
  public static final int Z = 60;
  public static final byte a = 1;
  public static final int a = 7;
  static final long jdField_a_of_type_Long = 2000L;
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  private static TextToSpeech jdField_a_of_type_AndroidSpeechTtsTextToSpeech;
  public static final String a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final long[] a;
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
  public static final int aL = 100;
  public static final int aM = 101;
  public static final int aN = 102;
  public static final int aO = 103;
  public static final int aP = 104;
  public static final int aQ = 105;
  public static final int aR = 106;
  public static final int aS = 107;
  public static final int aT = 108;
  public static final int aU = 111;
  public static final int aV = 112;
  public static final int aW = 113;
  public static final int aX = 114;
  public static final int aY = 115;
  public static final int aZ = 116;
  public static final int aa = 61;
  public static final int ab = 62;
  public static final int ac = 63;
  public static final int ad = 64;
  public static final int ae = 65;
  public static final int af = 66;
  public static final int ag = 67;
  public static final int ah = 68;
  public static final int ai = 69;
  public static final int aj = 70;
  public static final int ak = 71;
  public static final int al = 72;
  public static final int am = 73;
  public static final int an = 74;
  public static final int ao = 75;
  public static final int ap = 76;
  public static final int aq = 77;
  public static final int ar = 78;
  public static final int as = 79;
  public static final int at = 80;
  public static final int au = 81;
  public static final int av = 82;
  public static final int aw = 83;
  public static final int ax = 84;
  public static final int ay = 85;
  public static final int az = 87;
  public static final byte b = 2;
  public static final int b = 9;
  public static final String b = "com.tencent.mobileqq.intent.logout";
  private static final long[] jdField_b_of_type_ArrayOfLong;
  public static final int bA = 144;
  public static final int bB = 145;
  public static final int bC = 146;
  public static final int bD = 147;
  public static final int bE = 148;
  public static final int bF = 149;
  public static final int bG = 150;
  public static final int bH = 151;
  public static final int bI = 152;
  public static final int bJ = 153;
  public static final int bK = 154;
  public static final int bL = 155;
  public static final int bM = 156;
  public static final int bN = 157;
  public static final int bO = 158;
  public static final int bP = 159;
  public static final int bQ = 160;
  public static final int bR = 161;
  public static final int bS = 162;
  public static final int bT = 163;
  public static final int bU = 164;
  public static final int bV = 165;
  public static final int bW = 166;
  public static final int bX = 167;
  public static final int bY = 168;
  public static final int bZ = 169;
  public static final int ba = 117;
  public static final int bb = 118;
  public static final int bc = 119;
  public static final int bd = 120;
  public static final int be = 121;
  public static final int bf = 122;
  public static final int bg = 123;
  public static final int bh = 124;
  public static final int bi = 125;
  public static final int bj = 126;
  public static final int bk = 127;
  public static final int bl = 128;
  public static final int bm = 129;
  public static final int bn = 130;
  public static final int bo = 131;
  public static final int bp = 132;
  public static final int bq = 133;
  public static final int br = 134;
  public static final int bs = 136;
  public static final int bt = 137;
  public static final int bu = 138;
  public static final int bv = 139;
  public static final int bw = 140;
  public static final int bx = 141;
  public static final int by = 142;
  public static final int bz = 143;
  public static final byte c = 3;
  public static final int c = 10;
  private static final long jdField_c_of_type_Long = 86400000L;
  public static final String c = "Q.qqhead.qaif";
  public static volatile boolean c = false;
  public static final int cA = 5;
  public static final int cB = 6;
  public static final int cC = 7;
  public static final int cD = 8;
  public static final int cE = 9;
  public static final int cF = 10;
  public static final int cG = 11;
  public static final int cH = 12;
  public static final int cI = 13;
  public static final int cJ = 14;
  public static final int cK = 15;
  public static final int cL = 16;
  public static final int cM = 17;
  public static final int cN = 18;
  public static final int cO = 19;
  public static final int cP = 20;
  public static final int cQ = 21;
  public static final int cR = 22;
  public static final int cS = 23;
  public static final int cT = 24;
  public static final int cU = 25;
  public static final int cV = 26;
  public static final int cW = 27;
  public static final int cX = 28;
  public static final int cY = 29;
  public static final int cZ = 30;
  public static final int ca = 170;
  public static final int cb = 171;
  public static final int cc = 172;
  public static final int cd = 173;
  public static final int ce = 174;
  public static final int cf = 175;
  public static final int cg = 176;
  public static final int ch = 177;
  public static final int ci = 178;
  public static final int cj = 179;
  public static final int ck = 180;
  public static final int cl = 181;
  public static final int cm = 182;
  public static final int co = 0;
  public static final int cp = 1;
  public static final int cr = 1;
  public static final int cs = 2;
  public static final int ct = 3;
  public static int cu = 0;
  public static final int cv = 0;
  public static final int cw = 1;
  public static final int cx = 2;
  public static final int cy = 3;
  public static final int cz = 4;
  public static final byte d = 3;
  public static final int d = 11;
  static final String jdField_d_of_type_JavaLangString = "clean_unread_feed_type";
  public static final int dA = 60;
  public static final int dB = 61;
  public static final int dC = 62;
  public static final int dD = 63;
  public static final int dE = 64;
  public static final int dF = 65;
  public static final int dG = 66;
  public static final int dH = 68;
  public static final int dI = 69;
  public static final int dJ = 70;
  public static final int dK = 71;
  public static final int dL = 72;
  public static final int dM = 73;
  public static final int dN = 74;
  public static final int dO = 75;
  public static final int dP = 76;
  public static final int dQ = 77;
  public static final int dR = 78;
  public static final int dS = 79;
  public static final int dT = 80;
  public static final int dU = 81;
  public static final int dV = 82;
  public static final int dW = 83;
  public static final int dX = 84;
  public static final int dY = 85;
  public static final int dZ = 86;
  public static final int da = 31;
  public static final int db = 32;
  public static final int dc = 33;
  public static final int dd = 34;
  public static final int de = 35;
  public static final int df = 37;
  public static final int dg = 39;
  public static final int dh = 40;
  public static final int di = 41;
  public static final int dj = 42;
  public static final int dk = 43;
  public static final int dl = 44;
  public static final int dm = 45;
  public static final int dn = 46;
  public static final int jdField_do = 47;
  public static final int dp = 48;
  public static final int dq = 49;
  public static final int dr = 50;
  public static final int ds = 51;
  public static final int dt = 52;
  public static final int du = 54;
  public static final int dv = 55;
  public static final int dw = 56;
  public static final int dx = 57;
  public static final int dy = 58;
  public static final int dz = 59;
  public static final byte e = 1;
  public static final int e = 12;
  private static final int eB = 99;
  private static final int eC = 0;
  public static final int ea = 87;
  public static final int eb = 88;
  public static final int ec = 89;
  public static final int ed = 90;
  public static final int ee = 91;
  public static final int ef = 92;
  public static final int eg = 93;
  public static final int eh = 94;
  public static final int ei = 95;
  public static final int ej = 96;
  public static final int ek = 97;
  public static final int el = 98;
  public static final int em = 3;
  public static int ep = 0;
  public static int eq = 0;
  public static final int er = 3;
  public static final int es = 2;
  public static final int et = 1;
  private static final int ev = -56;
  private static final int ew = -55;
  private static final int ex = 183;
  private static final int ey = 3;
  private static final byte jdField_f_of_type_Byte = 3;
  public static final int f = 13;
  public static final String f = "com.tencent.msg.newmessage";
  public static final int g = 14;
  private static final long g = 7200000L;
  public static final String g = "round";
  public static final int h = 15;
  public static final String h = "B1_QQ_Neighbor_android";
  public static final int i = 16;
  public static final String i = "NzVK_qGE";
  public static final int j = 17;
  static final String j = "security_scan";
  public static final int k = 18;
  private static final String k = "Q.qqhead.broadcast";
  public static final int l = 19;
  private static final String l = "com.tencent.qzone.cleanunreadcount";
  public static final int m = 20;
  private static final String m = "com.tencent.qqhead.getheadreq";
  public static final int n = 21;
  private static final String jdField_n_of_type_JavaLangString = "com.tencent.qqhead.getheadresp";
  public static final int o = 22;
  private static final String jdField_o_of_type_JavaLangString = "com.tencent.mobileqq:video";
  public static final int p = 23;
  private static final String p = "notification";
  public static final int q = 24;
  public static final int r = 25;
  public static final int s = 26;
  public static final int t = 27;
  public static final int u = 28;
  public static final int v = 30;
  public static final int w = 31;
  public static final int x = 32;
  public static final int y = 33;
  public static final int z = 34;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new qel(this);
  public Intent a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  private AvAddFriendService jdField_a_of_type_ComTencentAvAppAvAddFriendService;
  private AVNotifyCenter jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private CallTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener;
  private CheckPttListener jdField_a_of_type_ComTencentMobileqqAppCheckPttListener;
  private CheckPtvListener jdField_a_of_type_ComTencentMobileqqAppCheckPtvListener;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new qeq(this);
  private HotChatManager jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
  public LebaHelper a;
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener;
  private QQGAudioMsgHandler jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler;
  private CacheManager jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager;
  public Automator a;
  volatile ConversationFacade jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
  public volatile QQMessageFacade a;
  private FTSDBManager jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  public AboutConfig a;
  private Config jdField_a_of_type_ComTencentMobileqqConfigConfig;
  private QQEntityManagerFactory jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
  private SigInfo jdField_a_of_type_ComTencentMobileqqDataSigInfo;
  private FileManagerEngine jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine;
  private FileTransferHandler jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler;
  private FileManagerDataCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter;
  private FileManagerNotifyCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter;
  private FileManagerRSCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter;
  private OnlineFileSessionCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter;
  private PrivacyInfoUtil jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil;
  private CallRedDotLightalkLis jdField_a_of_type_ComTencentMobileqqJumplightalkCallRedDotLightalkLis;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private PicPreDownloader jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  volatile QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  public MobileQQService a;
  private MessageCache jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
  private ShortVideoPreDownloader jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader;
  private ReportController jdField_a_of_type_ComTencentMobileqqStatisticsReportController;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private CloudScanListener jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener;
  private ISecureModuleService jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  private QQProxyForQlink jdField_a_of_type_CooperationQlinkQQProxyForQlink;
  private QlinkServiceManager jdField_a_of_type_CooperationQlinkQlinkServiceManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_a_of_type_JavaUtilList = new Vector();
  public Set a;
  qes jdField_a_of_type_Qes = null;
  public boolean a;
  private volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[2];
  private BusinessHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler = new BusinessHandler[99];
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object['·'];
  private Manager[] jdField_a_of_type_ArrayOfMqqManagerManager = new Manager['·'];
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new qep(this);
  private Intent jdField_b_of_type_AndroidContentIntent;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ThreadLocal jdField_b_of_type_JavaLangThreadLocal = new ThreadLocal();
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_b_of_type_JavaUtilList = new Vector();
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  boolean jdField_b_of_type_Boolean = false;
  private BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new qeh(this);
  private Handler jdField_c_of_type_AndroidOsHandler = new qen(this, ThreadManager.b());
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  List jdField_c_of_type_JavaUtilList = new Vector();
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  private volatile long[] jdField_c_of_type_ArrayOfLong = new long[2];
  public int cn;
  public int cq;
  private long jdField_d_of_type_Long = 31L;
  private List jdField_d_of_type_JavaUtilList = new ArrayList();
  public boolean d;
  private long e;
  public boolean e;
  private final int eA = 991;
  public int en;
  public int eo;
  public int eu = -1;
  private final int ez = 990;
  private long jdField_f_of_type_Long;
  public boolean f;
  public boolean g;
  public boolean h = true;
  boolean i;
  public boolean j = true;
  public volatile boolean k;
  public boolean l;
  public boolean m = true;
  private boolean jdField_n_of_type_Boolean;
  private volatile boolean jdField_o_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("QQAppInterface escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.jdField_a_of_type_JavaLangString = str + "\n" + QLog.getStackTraceString(localThrowable);
        QLog.e("DexLoad", 1, "QQAppInterface escapes!");
      }
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangString = QQAppInterface.class.getSimpleName();
      jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
      jdField_b_of_type_ArrayOfLong = new long[] { 100L, 200L, 200L, 100L };
      jdField_a_of_type_ArrayOfLong = new long[] { 100L, 400L, 100L, 400L, 100L, 400L };
      cu = 1;
      jdField_a_of_type_ArrayOfInt = new int[] { 17, 18, 19, 28, 27, 25, 26, 41, 47 };
      ep = 300000;
      eq = 30000;
      return;
      BaseApplicationImpl.jdField_a_of_type_JavaLangString = "";
    }
  }
  
  public QQAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidOsHandler = new qef(this, Looper.getMainLooper());
  }
  
  private void I()
  {
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      int i1 = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.size() * 3 / 4;
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.trimToSize(i1);
    }
  }
  
  private void J()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.a().getPackageName());
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void K()
  {
    if (this.k) {
      return;
    }
    this.k = true;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.jdField_a_of_type_Boolean = false;
    if (GuardManager.a != null) {
      GuardManager.a.a(false);
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        synchronized (this.jdField_c_of_type_JavaUtilList)
        {
          this.jdField_c_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.g();
          HeavyTaskExecutor.a(new qdx(this));
        }
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      BusinessHandler[] arrayOfBusinessHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler;
      int i2 = arrayOfBusinessHandler.length;
      int i1 = 0;
      while (i1 < i2)
      {
        BusinessHandler localBusinessHandler = arrayOfBusinessHandler[i1];
        if (localBusinessHandler != null) {
          localBusinessHandler.g();
        }
        i1 += 1;
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localObject3 = finally;
        throw ((Throwable)localObject3);
        localObject4 = finally;
        throw ((Throwable)localObject4);
      }
      if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener != null) {
        a().unregisterCloudScanListener(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getBaseContext(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
      }
      VideoBroadcastReceiver.a();
      if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
        this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
      }
      FaceDecodeTask.b();
      this.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.f();
      }
      WeiyunHelper.a();
      ThemeSwitchManager.c();
      SosoInterface.a();
      EquipLockWebImpl.a();
      PluginManageHandler.getInstance().setPluginManagerProvider(null, false);
      SessionInfo.clearOldSession();
      StepServiceAsync.c();
      PublicAccountUtil.b();
      PublicAccountConfigUtil.a();
      return;
    }
  }
  
  private void L()
  {
    Object localObject = (SubAccountManager)getManager(60);
    if (localObject != null) {}
    for (localObject = ((SubAccountManager)localObject).a();; localObject = null)
    {
      if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
        return;
      }
      SubAccountControll.a(this, (byte)0, (ArrayList)localObject);
      return;
    }
  }
  
  private void M()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig = new AboutConfig(this);
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a();
    }
  }
  
  private void N()
  {
    boolean bool = true;
    if (this.eu != -1) {}
    do
    {
      return;
      localObject2 = SettingCloneUtil.readValue(getApplication(), a(), null, "qqsetting_calltab_show_key", "0111100");
      if ((localObject2 != null) && (((String)localObject2).length() <= "0111100".length())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "isCallTabShow fullVal is null");
    return;
    Object localObject1 = localObject2;
    if (((String)localObject2).length() < "0111100".length()) {
      localObject1 = (String)localObject2 + "0111100".substring(((String)localObject2).length());
    }
    Object localObject2 = ((String)localObject1).toCharArray();
    localObject1 = new StringBuilder((String)localObject1);
    char c1 = localObject2[5];
    char c3 = localObject2[6];
    char c4;
    if (c1 != c3)
    {
      ((StringBuilder)localObject1).setCharAt(6, c1);
      c3 = '\001';
      c4 = c1;
    }
    for (;;)
    {
      if (c4 == '0')
      {
        this.eu = 0;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "uin:" + a() + ",isCallTabShow mIsCallTabShow=" + this.eu);
        }
        if (this.eu == 0) {
          bool = false;
        }
        this.m = bool;
        if (c3 == 0) {
          break;
        }
        ThreadManager.a(new qej(this, (StringBuilder)localObject1), 8, null, false);
        return;
      }
      if (localObject2[0] == '1')
      {
        c5 = localObject2[3];
        c1 = localObject2[4];
        if (c1 == '0')
        {
          c4 = '\000';
          label289:
          this.eu = c4;
          if (c5 == c1) {
            break label407;
          }
          ((StringBuilder)localObject1).setCharAt(3, c1);
          c3 = '\001';
        }
      }
      label407:
      for (;;)
      {
        break;
        c4 = '\001';
        break label289;
        c1 = localObject2[1];
        c5 = localObject2[2];
        char c2 = localObject2[3];
        char c6 = localObject2[4];
        if (c1 == '0') {
          c4 = '\000';
        }
        for (;;)
        {
          this.eu = c4;
          if (c2 != c6)
          {
            ((StringBuilder)localObject1).setCharAt(4, c2);
            c3 = '\001';
          }
          if (c1 == c5) {
            break;
          }
          ((StringBuilder)localObject1).setCharAt(2, c1);
          c3 = '\001';
          break;
          if (c2 == '0') {
            c4 = '\000';
          } else {
            c4 = '\001';
          }
        }
      }
      char c5 = '\000';
      c4 = c3;
      c3 = c5;
    }
  }
  
  private Intent a(Context paramContext, QQMessageFacade.Message paramMessage, int paramInt)
  {
    paramMessage = paramMessage.frienduin;
    int i1 = paramInt;
    if (paramInt == 1026) {
      i1 = 1;
    }
    Object localObject1;
    if (String.valueOf(AppConstants.ar).equals(paramMessage))
    {
      localObject1 = paramContext.getString(2131371875);
      paramContext = new Intent(paramContext, MsgBoxListActivity.class);
      paramContext.putExtra("uin", paramMessage);
      paramContext.putExtra("uintype", 1001);
      paramMessage = (QQMessageFacade.Message)localObject1;
    }
    for (;;)
    {
      paramContext.putExtra("uinname", paramMessage);
      return paramContext;
      if ((String.valueOf(AppConstants.av).equals(paramMessage)) || (AppConstants.aX.equals(paramMessage)) || (AppConstants.bd.equals(paramMessage)))
      {
        paramMessage = paramContext.getString(2131367582);
        paramContext = new Intent(paramContext, NewFriendActivity.class);
        paramContext.putExtra("EntranceId", 1);
      }
      else if (String.valueOf(AppConstants.aw).equals(paramMessage))
      {
        paramMessage = paramContext.getString(2131369140);
        paramContext = new Intent(paramContext, TroopActivity.class);
        paramContext.putExtra("_key_mode", 0);
        paramContext.putExtra("key_tab_mode", 2);
      }
      else if (String.valueOf(AppConstants.as).equals(paramMessage))
      {
        paramMessage = new Intent(paramContext, QQBroadcastActivity.class);
        localObject1 = paramContext.getString(2131369138);
        paramContext = paramMessage;
        paramMessage = (QQMessageFacade.Message)localObject1;
      }
      else if (String.valueOf(AppConstants.ao).equals(paramMessage))
      {
        paramMessage = paramContext.getString(2131369140);
        paramContext = new Intent(paramContext, VisitorsActivity.class);
        paramContext.putExtra("votersOnly", true);
        paramContext.putExtra("toUin", Long.valueOf(a()));
      }
      else if (String.valueOf(AppConstants.aj).equals(paramMessage))
      {
        paramMessage = new Intent(paramContext, LiteActivity.class);
        paramMessage.putExtra("targetUin", AppConstants.aj);
        localObject1 = paramContext.getString(2131362118);
        paramContext = paramMessage;
        paramMessage = (QQMessageFacade.Message)localObject1;
      }
      else if (String.valueOf(AppConstants.ak).equals(paramMessage))
      {
        paramMessage = new Intent(paramContext, LiteActivity.class);
        paramMessage.putExtra("targetUin", AppConstants.ak);
        localObject1 = paramContext.getString(2131362119);
        paramContext = paramMessage;
        paramMessage = (QQMessageFacade.Message)localObject1;
      }
      else
      {
        if (!String.valueOf(9973L).equals(paramMessage)) {
          break;
        }
        paramMessage = new Intent(paramContext, ActivateFriendActivity.class);
        localObject1 = paramContext.getString(2131371386);
        paramMessage.setFlags(67108864);
        paramMessage.putExtra("af_key_from", 4);
        paramContext = paramMessage;
        paramMessage = (QQMessageFacade.Message)localObject1;
      }
    }
    Object localObject2;
    if (i1 == 7000)
    {
      localObject1 = paramContext.getString(2131370492);
      localObject2 = new Intent(paramContext, SubAccountMessageActivity.class);
      ((Intent)localObject2).putExtra("subAccount", paramMessage);
      paramContext = (SubAccountManager)getManager(60);
      if (paramContext == null) {
        break label1142;
      }
    }
    label885:
    label938:
    label1142:
    for (paramContext = paramContext.c(paramMessage);; paramContext = paramMessage)
    {
      ((Intent)localObject2).putExtra("subAccountLatestNick", paramContext);
      ((Intent)localObject2).putExtra("finishAIO", true);
      ((Intent)localObject2).putExtra("uin", paramMessage);
      ((Intent)localObject2).putExtra("uintype", i1);
      paramContext = (Context)localObject2;
      paramMessage = (QQMessageFacade.Message)localObject1;
      break;
      if ((i1 == 1001) || (i1 == 1010))
      {
        paramMessage = paramContext.getString(2131371875);
        paramContext = new Intent(paramContext, MsgBoxListActivity.class);
        paramContext.putExtra("uin", AppConstants.ar);
        paramContext.putExtra("uintype", i1);
        break;
      }
      if (i1 == 7220)
      {
        paramMessage = PublicAccountConfigUtil.c(this, paramContext);
        localObject1 = new Intent(paramContext, ReadInJoyFeedsActivity.class);
        if (ReadInJoyHelper.a(this))
        {
          ((Intent)localObject1).putExtra("readinjoy_show_tab", 0);
          ((Intent)localObject1).putExtra("tab_tab_index", 0);
          ((Intent)localObject1).putExtra("launch_from", 5);
          ((Intent)localObject1).putExtra("uin", AppConstants.ba);
          ((Intent)localObject1).putExtra("uintype", i1);
          paramContext = (Context)localObject1;
          break;
        }
        localObject2 = new ArrayList();
        paramContext = ((KandianMergeManager)getManager(161)).b();
        if ((paramContext != null) && ((paramContext instanceof MessageForStructing)) && (paramContext.extInt == 1))
        {
          paramContext = (MessageForStructing)paramContext;
          if (paramContext.structingMsg == null) {
            paramContext.parse();
          }
          if ((paramContext.structingMsg != null) && (!TextUtils.isEmpty(paramContext.structingMsg.mArticleIds)))
          {
            paramContext = paramContext.structingMsg.mArticleIds.split("\\|");
            int i2 = paramContext.length;
            paramInt = 0;
            for (;;)
            {
              if (paramInt < i2)
              {
                String str = paramContext[paramInt];
                try
                {
                  ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(str)));
                  paramInt += 1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localException.printStackTrace();
                  }
                }
              }
            }
          }
        }
        if (((ArrayList)localObject2).isEmpty())
        {
          paramContext = null;
          ((Intent)localObject1).putExtra("subscription_all_article_id", paramContext);
          if (!((ArrayList)localObject2).isEmpty()) {
            break label938;
          }
        }
        for (long l1 = -1L;; l1 = ((Long)((ArrayList)localObject2).get(0)).longValue())
        {
          ((Intent)localObject1).putExtra("subscription_click_article_id", l1);
          ((Intent)localObject1).putExtra("launch_from", 5);
          break;
          paramContext = (Context)localObject2;
          break label885;
        }
      }
      localObject1 = new Intent(paramContext, SplashActivity.class);
      if (i1 == 1009) {
        paramContext = paramContext.getString(2131368299);
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("uin", paramMessage);
        ((Intent)localObject1).putExtra("uintype", i1);
        localObject1 = AIOUtils.a((Intent)localObject1, new int[] { 2 });
        ((Intent)localObject1).setAction("com.tencent.mobileqq.action.MAINACTIVITY");
        paramMessage = paramContext;
        paramContext = (Context)localObject1;
        break;
        if (String.valueOf(1787740092L).equals(paramMessage))
        {
          paramContext = paramContext.getString(2131370470);
        }
        else if (i1 == 1024)
        {
          ((Intent)localObject1).putExtra("chat_subType", 1);
          paramContext = ContactUtils.b(this, paramMessage, i1);
        }
        else if (i1 == 9501)
        {
          paramContext = ((SmartDeviceProxyMgr)a(51)).a(Long.parseLong(paramMessage));
          if (paramContext != null) {
            paramContext = SmartDeviceUtil.a(paramContext);
          } else {
            paramContext = paramMessage;
          }
        }
        else
        {
          paramContext = ContactUtils.b(this, paramMessage, i1);
        }
      }
    }
  }
  
  private Intent a(Context paramContext, String paramString, int paramInt)
  {
    if (String.valueOf(AppConstants.ar).equals(paramString))
    {
      localObject = paramContext.getString(2131368291);
      paramContext = new Intent(paramContext, MsgBoxListActivity.class);
      paramContext.putExtra("uin", paramString);
      paramContext.putExtra("uintype", 1001);
      paramString = (String)localObject;
    }
    for (;;)
    {
      paramContext.putExtra("uinname", paramString);
      return paramContext;
      if (String.valueOf(AppConstants.av).equals(paramString))
      {
        paramString = paramContext.getString(2131369140);
        paramContext = new Intent(paramContext, NewFriendActivity.class);
        paramContext.putExtra("EntranceId", 1);
      }
      else if (String.valueOf(AppConstants.aw).equals(paramString))
      {
        paramString = paramContext.getString(2131369140);
        paramContext = new Intent(paramContext, TroopActivity.class);
        paramContext.putExtra("_key_mode", 0);
        paramContext.putExtra("key_tab_mode", 2);
      }
      else if (String.valueOf(AppConstants.as).equals(paramString))
      {
        paramString = new Intent(paramContext, QQBroadcastActivity.class);
        localObject = paramContext.getString(2131369138);
        paramContext = paramString;
        paramString = (String)localObject;
      }
      else if (String.valueOf(AppConstants.ao).equals(paramString))
      {
        paramString = paramContext.getString(2131369140);
        paramContext = new Intent(paramContext, VisitorsActivity.class);
        paramContext.putExtra("votersOnly", true);
        paramContext.putExtra("toUin", Long.valueOf(a()));
      }
      else if (String.valueOf(AppConstants.aj).equals(paramString))
      {
        paramString = new Intent(paramContext, LiteActivity.class);
        paramString.putExtra("targetUin", AppConstants.aj);
        localObject = paramContext.getString(2131362118);
        paramContext = paramString;
        paramString = (String)localObject;
      }
      else
      {
        if (!String.valueOf(AppConstants.ak).equals(paramString)) {
          break;
        }
        paramString = new Intent(paramContext, LiteActivity.class);
        paramString.putExtra("targetUin", AppConstants.ak);
        localObject = paramContext.getString(2131362119);
        paramContext = paramString;
        paramString = (String)localObject;
      }
    }
    Object localObject = new Intent(a(), SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.a);
    ((Intent)localObject).putExtra("conversation_index", 1);
    ((Intent)localObject).setFlags(335544320);
    String str;
    if (paramInt == 7000)
    {
      str = paramContext.getString(2131370492);
      ((Intent)localObject).setClass(paramContext, SubAccountMessageActivity.class);
      ((Intent)localObject).putExtra("subAccount", paramString);
      paramContext = (SubAccountManager)getManager(60);
      if (paramContext == null) {
        break label709;
      }
    }
    label709:
    for (paramContext = paramContext.c(paramString);; paramContext = paramString)
    {
      ((Intent)localObject).putExtra("subAccountLatestNick", paramContext);
      ((Intent)localObject).putExtra("finishAIO", true);
      paramContext = (Context)localObject;
      localObject = str;
      for (;;)
      {
        paramContext.putExtra("uin", paramString);
        paramContext.putExtra("uintype", paramInt);
        paramString = (String)localObject;
        break;
        if (paramInt == 1009)
        {
          str = paramContext.getString(2131368299);
          paramContext = (Context)localObject;
          localObject = str;
        }
        else if (String.valueOf(1787740092L).equals(paramString))
        {
          str = paramContext.getString(2131370470);
          paramContext = (Context)localObject;
          localObject = str;
        }
        else if (paramInt == 1024)
        {
          ((Intent)localObject).setClass(paramContext, SplashActivity.class);
          paramContext = AIOUtils.a((Intent)localObject, null);
          paramContext.putExtra("chat_subType", 1);
          localObject = ContactUtils.b(this, paramString, paramInt);
        }
        else if ((paramInt == 1001) || (paramInt == 1010))
        {
          localObject = paramContext.getString(2131371875);
          paramContext = new Intent(paramContext, MsgBoxListActivity.class);
          paramString = AppConstants.ar;
          paramContext.putExtra("uin", paramString);
          paramContext.putExtra("uintype", paramInt);
        }
        else
        {
          str = ContactUtils.b(this, paramString, paramInt);
          paramContext = (Context)localObject;
          localObject = str;
        }
      }
    }
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a());
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private Drawable a(String paramString, boolean paramBoolean, byte paramByte)
  {
    Object localObject = a(1, paramString, paramByte, true, 0);
    if ((localObject != null) && (paramBoolean)) {
      localObject = ImageUtil.a((Bitmap)localObject);
    }
    for (;;)
    {
      paramString = null;
      if (localObject != null) {
        paramString = new BitmapDrawable((Bitmap)localObject);
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = ImageUtil.b();
      }
      return (Drawable)localObject;
    }
  }
  
  private SQLiteOpenHelper a()
  {
    if (!a().equals("0")) {
      return a().build(a());
    }
    return null;
  }
  
  private SQLiteOpenHelper a(String paramString)
  {
    return a(paramString).build(paramString);
  }
  
  private String a(QQMessageFacade.Message paramMessage)
  {
    switch (paramMessage.bizType)
    {
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return "";
    case 9: 
      if (paramMessage.msgtype == 63511)
      {
        if (MessageForQQWalletMsg.isRedPacketMsg(a().b(paramMessage.frienduin, 1, paramMessage.uniseq))) {
          return a().getString(2131372047);
        }
        return a().getString(2131367403);
      }
      return a().getString(2131367403);
    case 14: 
      return a().getString(2131364624);
    case 7: 
      return a().getString(2131364625);
    case 3: 
      return a().getString(2131365129);
    case 13: 
      return a().getString(2131364637);
    }
    return a().getString(2131364638);
  }
  
  private String a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    Object localObject2;
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020))
    {
      localObject1 = ContactUtils.d(this, paramMessage.frienduin, paramMessage.senderuin);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(paramMessage.frienduin)) {}
      }
      else
      {
        localObject2 = ((FriendsManager)getManager(50)).c(paramMessage.frienduin);
        if (localObject2 != null) {
          if (TextUtils.isEmpty(((Friends)localObject2).remark)) {
            break label262;
          }
        }
      }
    }
    label262:
    for (Object localObject1 = ((Friends)localObject2).remark;; localObject1 = ((Friends)localObject2).name)
    {
      localObject2 = localObject1;
      if (paramBoolean) {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!((String)localObject1).equals(paramMessage.frienduin)) {}
        }
        else
        {
          localObject2 = localObject1;
          if (!this.jdField_a_of_type_JavaUtilSet.contains(paramMessage.frienduin))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramMessage.frienduin);
            localObject2 = (FriendListHandler)a(1);
            a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString + "_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject2).b(paramMessage.frienduin);
            localObject2 = localObject1;
          }
        }
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!"".equals(localObject2)) {}
      }
      else
      {
        localObject1 = paramMessage.frienduin;
      }
      return (String)localObject1;
      localObject1 = ContactUtils.c(this, paramMessage.senderuin, paramMessage.frienduin);
      break;
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (SystemUtil.a()) {
      localStringBuilder.append(AppConstants.bG);
    }
    for (;;)
    {
      String str = MD5.toMD5(paramString);
      str = MD5.toMD5(str + paramString);
      localStringBuilder.append(MD5.toMD5(str + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
  }
  
  private String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if ((paramInt == 1000) || (paramInt == 1020))
    {
      paramString2 = ContactUtils.d(this, paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = paramString2;
        if (!paramString2.equals(paramString1)) {}
      }
      else
      {
        localObject = ((FriendsManager)getManager(50)).c(paramString1);
        if (localObject != null) {
          if (TextUtils.isEmpty(((Friends)localObject).remark)) {
            break label219;
          }
        }
      }
    }
    label219:
    for (paramString2 = ((Friends)localObject).remark;; paramString2 = ((Friends)localObject).name)
    {
      localObject = paramString2;
      if (paramBoolean) {
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject = paramString2;
          if (!paramString2.equals(paramString1)) {}
        }
        else
        {
          localObject = paramString2;
          if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString1))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramString1);
            localObject = (FriendListHandler)a(1);
            a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString + "_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject).b(paramString1);
            localObject = paramString2;
          }
        }
      }
      if ((localObject != null) && (!"".equals(localObject))) {
        break label228;
      }
      return paramString1;
      paramString2 = ContactUtils.c(this, paramString2, paramString1);
      break;
    }
    label228:
    return (String)localObject;
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {}
    label167:
    label206:
    label212:
    do
    {
      return;
      int i3 = paramIntent.getExtras().getInt("faceType", 1);
      Object localObject2 = paramIntent.getExtras().getStringArrayList("uinList");
      paramContext = new ArrayList();
      ??? = new ArrayList();
      paramIntent = new ArrayList();
      if (QLog.isColorLevel()) {
        QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, receive uinList: ", (ArrayList)localObject2);
      }
      int i1;
      String str;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        i1 = 0;
        if (i1 < ((ArrayList)localObject2).size())
        {
          str = (String)((ArrayList)localObject2).get(i1);
          int i2;
          if ((str != null) && (str.length() > 0))
          {
            Object localObject3 = new File(a(i3, str, 0));
            if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
              break label206;
            }
            i2 = 1;
            if (i2 == 0) {
              break label212;
            }
            localObject3 = a(i3, str, 0);
            paramContext.add(str);
            ((ArrayList)???).add(localObject3);
          }
          for (;;)
          {
            i1 += 1;
            break;
            i2 = 0;
            break label167;
            paramIntent.add(str);
          }
        }
      }
      if (paramContext.size() > 0)
      {
        localObject2 = new Intent("com.tencent.qqhead.getheadresp");
        ((Intent)localObject2).putExtra("faceType", i3);
        ((Intent)localObject2).putStringArrayListExtra("uinList", paramContext);
        ((Intent)localObject2).putStringArrayListExtra("headPathList", (ArrayList)???);
        a().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
      }
      if (paramIntent.size() > 0)
      {
        long l1 = System.currentTimeMillis();
        localObject2 = (FriendListHandler)a(1);
        i1 = 0;
        while (i1 < paramIntent.size())
        {
          str = (String)paramIntent.get(i1);
          if (i3 == 1) {
            ((FriendListHandler)localObject2).a(str, (byte)0, (byte)2);
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashtable)
          {
            do
            {
              this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
              i1 += 1;
              break;
            } while (i3 != 4);
            ((FriendListHandler)localObject2).d(str);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, response uinList: ", paramContext);
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead uinList: ", paramIntent);
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showNotification. cmd=" + paramString4 + ", ticker=" + Utils.a(paramString1) + ",msgShow:" + Utils.a(paramString3) + ", bitmap=" + paramBitmap);
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = BitmapManager.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), 2130838592);
    }
    if (localBitmap != null)
    {
      paramBitmap = new ToServiceMsg("mobileqq.service", a(), paramString4);
      paramBitmap.extraData.putStringArray("cmds", new String[] { paramString1, paramString2, paramString3 });
      paramBitmap.extraData.putParcelable("intent", paramIntent);
      paramBitmap.extraData.putParcelable("bitmap", localBitmap);
      a(paramBitmap);
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    boolean bool = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.i + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessage);
    }
    if ((this.i) || (!bool)) {
      return;
    }
    Object localObject4 = "";
    Object localObject6 = "";
    Object localObject10 = null;
    Object localObject5 = null;
    Object localObject1;
    if (ActionMsgUtil.d(paramMessage.msgtype)) {
      localObject1 = EmosmUtils.a(a(), paramMessage);
    }
    for (;;)
    {
      label128:
      if (paramMessage.msgtype == 63485)
      {
        localObject4 = TroopBusinessUtil.a(paramMessage);
        if (localObject4 != null) {
          paramMessage.nickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject4).c;
        }
      }
      Object localObject7 = a(a(), paramMessage, true);
      ((Intent)localObject7).putExtra("entrance", 6);
      ((Intent)localObject7).putExtra("key_notification_click_action", true);
      Object localObject8 = ((Intent)localObject7).getStringExtra("uinname");
      if ((localObject8 == null) || ("".equals(localObject8))) {
        localObject8 = ((Intent)localObject7).getStringExtra("uin");
      }
      for (;;)
      {
        switch (paramMessage.istroop)
        {
        default: 
          localObject6 = localObject5;
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() == 1)
          {
            if ((AppConstants.av.equals(paramMessage.frienduin)) || (AppConstants.aX.equals(paramMessage.frienduin)) || (AppConstants.bd.equals(paramMessage.frienduin))) {
              localObject6 = a(paramMessage.senderuin, true);
            }
          }
          else
          {
            label377:
            localObject5 = (String)localObject8 + ": ";
            localObject4 = localObject1;
          }
          break;
        }
        for (;;)
        {
          label403:
          label474:
          Object localObject9;
          if (ActionMsgUtil.a(paramMessage.msgtype)) {
            if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue)))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "isShareAppActionMsg+ actionDetailMsg=" + paramMessage.actMsgContentValue);
              }
              localObject1 = paramMessage.actMsgContentValue;
              localObject9 = localObject1;
              localObject4 = localObject1;
              label480:
              if (paramMessage.istroop != 1008) {
                break label2829;
              }
              localObject1 = (String)localObject5 + (String)localObject4;
              label511:
              if (paramMessage.msgtype != 63520) {
                break label3457;
              }
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(getApplication(), paramMessage, true);
              localObject4 = localObject5;
              label540:
              if (paramMessage.counter <= 1) {
                break label3451;
              }
              if (paramMessage.counter <= 100) {
                break label2866;
              }
              localObject1 = (String)localObject8 + " (" + a().getString(2131370058) + ")";
              label598:
              if (paramBoolean) {
                break label3448;
              }
              localObject5 = null;
              label605:
              if (paramMessage.istroop != 1008) {
                break label2963;
              }
              if ((paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 0) && (!paramMessage.extStr.contains("lockDisplay"))) || (paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 1) && (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")))) {
                break;
              }
              ((Intent)localObject7).putExtra("need_report", true);
              ((Intent)localObject7).putExtra("incoming_msguid", paramMessage.msgUid);
              ((Intent)localObject7).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
              localObject8 = ((Intent)localObject7).getStringExtra("uin");
              if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject8))) {
                break label3442;
              }
              localObject5 = ((String)localObject1).replace((CharSequence)localObject8, "");
              label749:
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                break label2917;
              }
              label757:
              if (!AppConstants.ae.equals(localObject8)) {
                break label2948;
              }
              localObject6 = a(paramMessage.frienduin, true);
              localObject5 = localObject1;
              label782:
              localObject1 = localObject4;
              localObject8 = localObject7;
              localObject7 = localObject4;
              localObject4 = localObject8;
              label797:
              if ((paramBoolean) && (paramMessage.istroop != 6000) && (paramMessage.istroop != 1009) && (!paramMessage.frienduin.equals(AppConstants.an))) {
                break label3346;
              }
              label834:
              a((Intent)localObject4, (String)localObject7, (String)localObject5, (String)localObject1, (Bitmap)localObject6, "CMD_SHOW_NOTIFIYCATION");
              return;
              if (paramMessage.msgtype == 63527)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(getApplication(), paramMessage, true);
                break label128;
              }
              if (paramMessage.msgtype == 63496)
              {
                localObject1 = new MessageForApproval();
                ((MessageForApproval)localObject1).msgData = paramMessage.msgData;
                localObject1 = ((MessageForApproval)localObject1).getFullTitle();
                break label128;
              }
              if (paramMessage.msgtype == 63495)
              {
                localObject1 = a().getString(2131372433);
                localObject4 = a().getString(2131372434);
                localObject1 = (String)localObject1 + " " + (String)localObject4;
                break label128;
              }
              Object localObject2;
              if (paramMessage.msgtype == 63525)
              {
                try
                {
                  localObject1 = StructMsgFactory.a(paramMessage.msgData);
                  if (localObject1 == null)
                  {
                    localObject1 = localObject4;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
                      localObject1 = localObject4;
                    }
                  }
                  else
                  {
                    localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
                  }
                }
                catch (Exception localException1)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg error:" + localException1.getMessage(), localException1);
                  }
                  localObject2 = "";
                }
                break label128;
              }
              if (paramMessage.msgtype == 60527)
              {
                try
                {
                  localObject2 = BitAppMsgFactory.a(paramMessage.msgData);
                  if (localObject2 == null)
                  {
                    localObject2 = localObject4;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("StructMsg", 2, "showInComingMsg,getBitAppMsg is null");
                      localObject2 = localObject4;
                    }
                  }
                  else
                  {
                    localObject2 = ((BitAppMsg)localObject2).mMsgBrief;
                  }
                }
                catch (Exception localException2)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, "showInComingMsg,getBitAppMsg error:" + localException2.getMessage(), localException2);
                  }
                  localObject3 = "";
                }
                break label128;
              }
              if (FlashPicHelper.a(paramMessage))
              {
                localObject3 = a().getString(2131369797);
                break label128;
              }
              if (paramMessage.msgtype == 63484)
              {
                localObject3 = new MessageForQQStoryComment();
                ((MessageForQQStoryComment)localObject3).msgData = paramMessage.msgData;
                ((MessageForQQStoryComment)localObject3).parse();
                localObject3 = ((MessageForQQStoryComment)localObject3).getSummaryMsg();
                break label128;
              }
              localObject4 = paramMessage.getMessageText();
              localObject3 = localObject4;
              if (localObject4 == null) {
                localObject3 = "";
              }
              if ((localObject3 instanceof QQText))
              {
                localObject3 = ((QQText)localObject3).a();
                break label128;
              }
              localObject3 = new QQText(((CharSequence)localObject3).toString(), 3).a();
              break label128;
              localObject4 = a(paramMessage);
              if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
              {
                localObject5 = (String)localObject4 + paramMessage.nickName + "(" + (String)localObject8 + ")" + ":";
                localObject4 = (String)localObject4 + paramMessage.nickName + ": " + (String)localObject3;
                label1398:
                if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() != 1) {
                  break label3499;
                }
                localObject6 = (DiscussionHandler)a(6);
                if (localObject6 == null) {
                  break label3493;
                }
              }
            }
          }
          label1716:
          label1795:
          label1958:
          label1986:
          label2829:
          label2866:
          label2917:
          label2948:
          label2963:
          label3346:
          label3440:
          label3442:
          label3448:
          label3451:
          label3457:
          label3479:
          label3493:
          for (localObject6 = ((DiscussionHandler)localObject6).a(paramMessage.frienduin, true);; localObject6 = null)
          {
            localObject9 = localObject4;
            localObject4 = localObject3;
            localObject3 = localObject9;
            break label403;
            localObject6 = ContactUtils.a(this, paramMessage.senderuin, 0);
            localObject5 = (String)localObject4 + (String)localObject6 + "(" + (String)localObject8 + ")" + ":";
            localObject4 = (String)localObject4 + (String)localObject6 + ": " + (String)localObject3;
            break label1398;
            if ((paramMessage.msgtype == 64523) || (paramMessage.msgtype == 63506) || (paramMessage.msgtype == 64489))
            {
              localObject5 = (String)localObject8 + ":";
              localObject4 = localObject3;
              localObject6 = localObject10;
              break label403;
            }
            localObject4 = "";
            String str;
            if (AnonymousChatHelper.a(paramMessage))
            {
              localObject5 = AnonymousChatHelper.a(paramMessage).b;
              new StringBuilder().append(a().getString(2131364731)).append((String)localObject5).append("(").append((String)localObject8).append(")").append(":").toString();
              new StringBuilder().append(a().getString(2131364731)).append((String)localObject5).append(": ").append((String)localObject3).toString();
              if (paramMessage.msgtype != 63501)
              {
                localObject5 = localObject3;
                if (paramMessage.msgtype != 63498) {}
              }
              else
              {
                localObject5 = MessageForGrayTips.getOrginMsg((String)localObject3);
              }
              localObject3 = localObject5;
              if (paramMessage.msgtype == 62530)
              {
                localObject3 = MessageForPubAccount.getMsgSummary(this, paramMessage, false);
                localObject4 = PublicAccountConfigUtil.a(this, getApplication().getApplicationContext());
              }
              if (!MsgProxyUtils.j(paramMessage.msgtype)) {
                break label1958;
              }
              localObject4 = a(paramMessage);
              str = (String)localObject4 + "(" + (String)localObject8 + ")" + ":";
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                break label1986;
              }
            }
            for (localObject4 = (String)localObject4 + ": " + (String)localObject3;; localObject4 = localObject3)
            {
              localObject6 = localObject4;
              localObject9 = localObject3;
              localObject5 = str;
              if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() != 1) {
                break label3479;
              }
              localObject6 = a(paramMessage.frienduin, (byte)3, false, false);
              localObject5 = localObject4;
              localObject4 = localObject3;
              localObject3 = localObject5;
              localObject5 = str;
              break;
              if (!TextUtils.isEmpty(paramMessage.nickName))
              {
                localObject4 = paramMessage.nickName;
                break label1716;
              }
              localObject4 = ContactUtils.f(this, paramMessage.frienduin, paramMessage.senderuin);
              break label1716;
              localObject4 = a(paramMessage) + (String)localObject4;
              break label1795;
            }
            localObject5 = ((Intent)localObject7).getStringExtra("subAccountLatestNick");
            if (localObject5 != null)
            {
              localObject4 = localObject5;
              if (((String)localObject5).length() != 0) {}
            }
            else
            {
              localObject4 = paramMessage.senderuin;
            }
            localObject6 = (String)localObject8 + "-" + (String)localObject4 + ":" + (String)localObject3;
            localObject5 = (String)localObject4 + ":" + (String)localObject3;
            localObject9 = null;
            localObject4 = localObject3;
            localObject3 = localObject5;
            localObject5 = localObject6;
            localObject6 = localObject9;
            break label403;
            localObject5 = (String)localObject8 + ": ";
            localObject4 = localObject3;
            localObject6 = localObject10;
            break label403;
            if (String.valueOf(AppConstants.ar).equals(paramMessage.frienduin))
            {
              localObject5 = ContactUtils.o(this, paramMessage.senderuin);
              localObject4 = localObject5;
              if (TextUtils.isEmpty((CharSequence)localObject5)) {
                localObject4 = paramMessage.senderuin;
              }
            }
            for (;;)
            {
              str = (String)localObject4 + "(" + (String)localObject8 + ")" + ":";
              localObject4 = a(paramMessage) + (String)localObject4 + ": " + (String)localObject3;
              localObject6 = localObject4;
              localObject9 = localObject3;
              localObject5 = str;
              if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() != 1) {
                break label3479;
              }
              localObject6 = a(paramMessage.frienduin, 200);
              localObject5 = localObject4;
              localObject4 = localObject3;
              localObject3 = localObject5;
              localObject5 = str;
              break;
              localObject5 = ContactUtils.o(this, paramMessage.frienduin);
              localObject4 = localObject5;
              if (TextUtils.isEmpty((CharSequence)localObject5)) {
                localObject4 = paramMessage.frienduin;
              }
            }
            localObject9 = SkinUtils.a(a().getResources().getDrawable(2130838602));
            localObject5 = XMLMessageUtils.a(paramMessage);
            if ((localObject5 != null) && (!((PAMessage)localObject5).items.isEmpty()))
            {
              localObject4 = ((PAMessage.Item)((PAMessage)localObject5).items.get(0)).title;
              if ((((PAMessage.Item)((PAMessage)localObject5).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject5).items.get(0)).digestList != null))
              {
                localObject5 = (String)((PAMessage.Item)((PAMessage)localObject5).items.get(0)).digestList.get(0);
                localObject8 = localObject4;
                localObject4 = localObject5;
              }
            }
            for (;;)
            {
              localObject5 = localObject4;
              localObject4 = localObject3;
              localObject3 = localObject5;
              localObject5 = localObject6;
              localObject6 = localObject9;
              break label403;
              continue;
              localObject6 = SkinUtils.a(a().getResources().getDrawable(2130840519));
              localObject5 = (String)localObject8 + ": ";
              localObject4 = localObject3;
              break label403;
              if (("device_groupchat".equals(paramMessage.extStr)) && ((paramMessage.msgtype == 61035) || (paramMessage.msgtype == 61028)))
              {
                localObject5 = ContactUtils.b(this, paramMessage.senderuin, true);
                localObject4 = localObject5;
                if (!TextUtils.isEmpty(paramMessage.senderuin))
                {
                  localObject4 = localObject5;
                  if (paramMessage.senderuin.equals(paramMessage.frienduin)) {
                    localObject4 = SmartDeviceUtil.a(((SmartDeviceProxyMgr)a(51)).a(Long.parseLong(paramMessage.senderuin)));
                  }
                }
                localObject5 = localObject4;
                if (localObject4 == null) {
                  localObject5 = "";
                }
                localObject5 = (String)localObject5 + ": " + (String)localObject3;
                localObject4 = localObject3;
                localObject3 = localObject5;
                localObject5 = localObject6;
                localObject6 = localObject10;
                break label403;
              }
              localObject4 = localObject3;
              localObject5 = localObject6;
              localObject6 = localObject10;
              break label403;
              localObject6 = a(paramMessage.frienduin, true);
              break label377;
              localObject3 = a().a(AppShareIDUtil.a(paramMessage.shareAppID));
              if ((localObject3 == null) || (((AppShareID)localObject3).messagetail == null) || ("".equals(((AppShareID)localObject3).messagetail)))
              {
                localObject3 = a().getString(2131370150);
                break label474;
              }
              localObject3 = a().getString(2131370148) + ((AppShareID)localObject3).messagetail + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131370149);
              break label474;
              localObject3 = localObject5;
              if (paramMessage.istroop == 7000) {
                break label511;
              }
              localObject3 = (String)localObject5 + (String)localObject9;
              break label511;
              localObject3 = (String)localObject8 + " (" + paramMessage.counter + a().getString(2131368856) + ")";
              break label598;
              localObject4 = (String)localObject5 + " : " + (String)localObject4;
              break label757;
              localObject5 = a().getString(2131369705);
              break label782;
              if (paramMessage.istroop == 7220)
              {
                if (!ReadInJoyUtils.a(paramMessage)) {
                  break;
                }
                localObject6 = ImageUtil.e();
                localObject8 = PublicAccountConfigUtil.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
                localObject3 = localObject4;
                localObject4 = localObject7;
                localObject7 = localObject5;
                localObject5 = localObject8;
                break label797;
              }
              if ((paramMessage.istroop == 1001) && (paramMessage.msgtype == 62535))
              {
                if (OpenAppClient.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramMessage.action, paramMessage.frienduin, paramMessage.istroop) == null) {
                  break;
                }
                localObject8 = localObject4;
                localObject4 = localObject7;
                localObject7 = localObject5;
                localObject5 = localObject3;
                localObject3 = localObject8;
                break label797;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() > 1)
              {
                int i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
                localObject3 = new StringBuffer();
                ((StringBuffer)localObject3).append(String.format(a().getString(2131370063), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d()) }));
                if (i1 == 0) {
                  break;
                }
                if (i1 > 1000) {
                  ((StringBuffer)localObject3).append(a().getString(2131370057));
                }
                for (;;)
                {
                  localObject4 = new Intent(a(), SplashActivity.class);
                  ((Intent)localObject4).addFlags(335544320);
                  ((Intent)localObject4).putExtra("tab_index", MainFragment.a);
                  localObject8 = a().getString(2131370056);
                  localObject3 = ((StringBuffer)localObject3).toString();
                  localObject6 = null;
                  localObject7 = localObject5;
                  localObject5 = localObject8;
                  break;
                  ((StringBuffer)localObject3).append(i1).append(a().getString(2131368856));
                }
              }
              if (paramMessage.istroop == 0)
              {
                ((Intent)localObject7).putExtra("need_report", true);
                ((Intent)localObject7).putExtra("incoming_msguid", paramMessage.msgUid);
                ((Intent)localObject7).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
                ((Intent)localObject7).putExtra("KEY_FROM", "notifcation");
              }
              localObject8 = localObject4;
              localObject4 = localObject7;
              localObject7 = localObject5;
              localObject5 = localObject3;
              localObject3 = localObject8;
              break label797;
              if (!QQUtils.a(a())) {
                break label834;
              }
              localObject8 = (QQLSRecentManager)getManager(71);
              if (NotifyPushSettingActivity.a()) {}
              for (paramBoolean = false;; paramBoolean = SettingCloneUtil.readValue(a(), a(), a().getString(2131369618), "qqsetting_lock_screen_whenexit_key", true))
              {
                if (!paramBoolean) {
                  break label3440;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  showInComingMsg");
                }
                ((QQLSRecentManager)localObject8).a(this, paramMessage.frienduin, paramMessage.istroop, false);
                break;
              }
              break label834;
              localObject5 = localObject3;
              break label749;
              break label605;
              localObject3 = localObject8;
              break label598;
              localObject5 = localObject3;
              break label540;
              localObject9 = localObject4;
              localObject4 = localObject3;
              break label480;
              localObject4 = localObject3;
            }
            localObject4 = localObject9;
            localObject3 = localObject6;
            localObject6 = localObject10;
            break label403;
          }
          label3499:
          localObject6 = localObject4;
          localObject4 = localObject3;
          Object localObject3 = localObject6;
          localObject6 = localObject10;
        }
      }
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showMsgNotification: entryA message.frienduin=" + paramMessage.frienduin + ", " + "message.senderuin=" + paramMessage.senderuin + ", needSoundVibrationsTip " + paramBoolean1 + " , " + "isOnline " + paramBoolean2);
    }
    int i2;
    if (f())
    {
      a(paramMessage, true);
      i2 = 0;
      i1 = i2;
      if (this.cq == 0)
      {
        i1 = i2;
        if (paramBoolean1) {
          i1 = 1;
        }
      }
      i2 = i1;
      if (paramMessage.istroop == 1001)
      {
        i2 = i1;
        if (paramMessage.msgtype == 62535) {
          i2 = 1;
        }
      }
      i1 = i2;
      if (paramMessage.istroop == 1008) {
        if ((paramMessage.extStr == null) || ((paramMessage.extLong & 0x1) != 0) || (!paramMessage.extStr.contains("lockDisplay")))
        {
          i1 = i2;
          if (paramMessage.extStr != null)
          {
            i1 = i2;
            if ((paramMessage.extLong & 0x1) == 1)
            {
              i1 = i2;
              if (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
            }
          }
        }
        else
        {
          i1 = i2;
          if (paramBoolean1) {
            i1 = 1;
          }
        }
      }
      i2 = i1;
      if (paramMessage.istroop == 1008)
      {
        i2 = i1;
        if (AppConstants.ae.equals(paramMessage.senderuin)) {
          i2 = 1;
        }
      }
      if (paramMessage.istroop != 9002) {
        break label320;
      }
    }
    label320:
    for (int i1 = i3;; i1 = i2)
    {
      if (i1 != 0) {
        d(paramMessage, paramBoolean2);
      }
      return;
      f(true);
      break;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (f()) {
      b(paramMessageRecord, true);
    }
    for (;;)
    {
      int i2 = 0;
      int i1 = i2;
      if (this.cq == 0)
      {
        i1 = i2;
        if (paramBoolean1) {
          i1 = 1;
        }
      }
      i2 = i1;
      if (paramMessageRecord.istroop == 1001)
      {
        i2 = i1;
        if (paramMessageRecord.msgtype == 62535) {
          i2 = 1;
        }
      }
      i1 = i2;
      if (paramMessageRecord.istroop == 1008) {
        if ((paramMessageRecord.extStr == null) || ((paramMessageRecord.extLong & 0x1) != 0) || (!paramMessageRecord.extStr.contains("lockDisplay")))
        {
          i1 = i2;
          if (paramMessageRecord.extStr != null)
          {
            i1 = i2;
            if ((paramMessageRecord.extLong & 0x1) == 1)
            {
              i1 = i2;
              if (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
            }
          }
        }
        else
        {
          i1 = i2;
          if (paramBoolean1) {
            i1 = 1;
          }
        }
      }
      i2 = i1;
      if (paramMessageRecord.istroop == 1008)
      {
        i2 = i1;
        if (AppConstants.ae.equals(paramMessageRecord.senderuin)) {
          i2 = 1;
        }
      }
      if (i2 != 0) {
        d(paramMessageRecord, paramBoolean2);
      }
      return;
      c(paramMessageRecord, true);
    }
  }
  
  private void a(InputStream paramInputStream)
  {
    try
    {
      Object localObject1 = SAXParserFactory.newInstance().newSAXParser();
      Object localObject2 = new PlistHandler();
      ((SAXParser)localObject1).parse(paramInputStream, (DefaultHandler)localObject2);
      if ((((PlistHandler)localObject2).a() instanceof ArrayList))
      {
        paramInputStream = (ArrayList)((PlistHandler)localObject2).a();
        int i3 = paramInputStream.size();
        if (i3 >= 1)
        {
          this.cn = Integer.parseInt((String)paramInputStream.get(0));
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          int i1 = 1;
          while (i1 < i3)
          {
            ArrayList localArrayList1 = (ArrayList)paramInputStream.get(i1);
            localObject1 = (String)localArrayList1.get(0);
            localObject2 = (String)localArrayList1.get(1);
            localArrayList1 = (ArrayList)localArrayList1.get(2);
            ArrayList localArrayList2 = new ArrayList();
            int i2 = 0;
            while (i2 < localArrayList1.size())
            {
              TagInfo localTagInfo = new TagInfo();
              localTagInfo.bType = Byte.parseByte((String)((HashMap)localArrayList1.get(i2)).get("itemTagType"));
              localTagInfo.iTagId = new BigDecimal((String)((HashMap)localArrayList1.get(i2)).get("itemTagID")).longValue();
              localTagInfo.strContent = ((String)((HashMap)localArrayList1.get(i2)).get("itemTagString"));
              localArrayList2.add(localTagInfo);
              i2 += 1;
            }
            localObject1 = new TagArrayByType((String)localObject1, (String)localObject2, localArrayList2);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            i1 += 1;
          }
        }
      }
      return;
    }
    catch (ParserConfigurationException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return;
    }
    catch (SAXException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (!paramQQAppInterface.g)
    {
      String str = paramQQAppInterface.getAccount();
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.a());
      if (localSharedPreferences.contains(str + "_" + "long_text_msg_config_version")) {
        paramQQAppInterface.h = localSharedPreferences.getBoolean(str + "_msfpull_filter_switch", true);
      }
    }
    paramQQAppInterface.g = true;
    return paramQQAppInterface.h;
  }
  
  private Object[] a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    int i1 = paramInt1;
    String str = paramString;
    Setting localSetting;
    if (paramInt1 != 101)
    {
      i1 = paramInt1;
      str = paramString;
      if (paramInt1 != 1001)
      {
        i1 = paramInt1;
        str = paramString;
        if (paramString != null)
        {
          if (!paramBoolean) {
            break label114;
          }
          localSetting = c(b(paramInt1, paramString, paramInt2));
          i1 = paramInt1;
          str = paramString;
          if (localSetting != null)
          {
            i1 = paramInt1;
            str = paramString;
            if (localSetting.bHeadType == 0)
            {
              str = String.valueOf(localSetting.systemHeadID);
              if (paramInt1 != 4) {
                break label132;
              }
              i1 = -56;
            }
          }
        }
      }
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(i1), str };
      label114:
      localSetting = (Setting)a(paramInt1, paramString, paramInt2).second;
      break;
      label132:
      if (paramInt1 == 16) {
        i1 = 16;
      } else {
        i1 = -55;
      }
    }
  }
  
  private Intent b(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("uin", paramMessage.frienduin);
    paramContext.putExtra("troop_uin", paramMessage.senderuin);
    paramContext.putExtra("uintype", paramMessage.istroop);
    paramContext.putExtra("uinname", a(paramMessage, paramBoolean));
    paramContext = AIOUtils.a(paramContext, new int[] { 2 });
    paramContext.setAction("com.tencent.mobileqq.action.CHAT");
    return paramContext;
  }
  
  private BusinessHandler b(int paramInt)
  {
    Object localObject2 = null;
    long l1 = System.currentTimeMillis();
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        QLog.d("Conversation", 2, "createHandler,cost time:" + (l2 - l1));
      }
      return (BusinessHandler)localObject1;
      localObject1 = new MessageHandler(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = ((MessageHandler)localObject1);
      continue;
      localObject1 = new FriendListHandler(this);
      continue;
      localObject1 = new CardHandler(this);
      continue;
      localObject1 = new MusicPlayerHandler(this);
      continue;
      localObject1 = new LBSHandler(this);
      continue;
      localObject1 = new ConfigHandler(this);
      continue;
      localObject1 = new ReportHandler(this);
      continue;
      localObject1 = new DiscussionHandler(this);
      continue;
      localObject1 = new QZoneNotifyHandler(this);
      continue;
      localObject1 = new DataLineHandler_210(this);
      continue;
      localObject1 = new HuangyeHandler(this);
      continue;
      localObject1 = new RegisterProxySvcPackHandler(this);
      continue;
      localObject1 = new PublicAccountHandler(this);
      continue;
      localObject1 = new EmoticonHandler(this);
      continue;
      localObject1 = new SVIPHandler(this);
      continue;
      localObject1 = new ThemeHandler(this);
      continue;
      localObject1 = new QvipSpecialCareHandler(this);
      continue;
      localObject1 = new ClubContentUpdateHandler(this);
      continue;
      localObject1 = new SubAccountBindHandler(this);
      continue;
      localObject1 = new ShieldListHandler(this);
      continue;
      localObject1 = new TroopHandler(this);
      continue;
      localObject1 = new EnterpriseQQHandler(this);
      continue;
      localObject1 = new BizTroopHandler(this);
      continue;
      localObject1 = new StartAppCheckHandler(this);
      continue;
      localObject1 = new SafeCenterPushHandler(this);
      continue;
      localObject1 = new QPSafeCheckHandler(this);
      continue;
      localObject1 = new StrangerHandler(this);
      continue;
      localObject1 = new VipInfoHandler(this);
      continue;
      localObject1 = new TroopQZoneUploadAlbumHandler(this);
      continue;
      localObject1 = new CardPayHandler(this);
      continue;
      localObject1 = new QWalletOpenHandler(this);
      continue;
      localObject1 = new RedTouchHandler(this);
      continue;
      localObject1 = new NearFieldDiscussHandler(this);
      continue;
      localObject1 = new SecSvcHandler(this);
      continue;
      localObject1 = new HotChatHandler(this);
      continue;
      localObject1 = new BmqqBusinessHandler(this);
      continue;
      localObject1 = new VideoC2CHandler(this);
      continue;
      localObject1 = new SecMsgHandler(this);
      continue;
      localObject1 = new SignatureHandler(this);
      continue;
      localObject1 = new QWalletAuthHandler(this);
      continue;
      localObject1 = new TroopRedTouchHandler(this);
      continue;
      localObject1 = new UniPayHandler(this);
      continue;
      localObject1 = new RecentCallHandler(this);
      continue;
      localObject1 = new VipSetFunCallHandler(this);
      continue;
      localObject1 = new QPayHandler(this);
      continue;
      localObject1 = new RouterHandler(this);
      continue;
      localObject1 = new DeviceMsgHandle(this);
      continue;
      localObject1 = new DeviceFileHandler(this);
      continue;
      localObject1 = new SmartDeviceProxyMgr(this);
      continue;
      localObject1 = new LightalkSwitchHanlder(this);
      continue;
      localObject1 = new ChatBackgroundAuthHandler(this);
      continue;
      localObject1 = new RedpointHandler(this);
      continue;
      localObject1 = new NumRedPointHandler(this);
      continue;
      localObject1 = new NumRedMsgHandler(this);
      continue;
      localObject1 = new NearFieldTroopHandler(this);
      continue;
      localObject1 = new PPCLoginAuthHandler(this);
      continue;
      localObject1 = new MessageRoamHandler(this);
      continue;
      localObject1 = new NearbyCardHandler(this);
      continue;
      localObject1 = new ArrangeHandler(this);
      continue;
      localObject1 = new ReadInJoyHandler(this);
      continue;
      localObject1 = new MSFNetTransportProvider(this);
      continue;
      localObject1 = new SubscriptHandler(this);
      continue;
      localObject1 = new EcShopHandler(this);
      continue;
      localObject1 = new QQCardHandler(this);
      continue;
      localObject1 = new NearbyRelevantHandler(this);
      continue;
      localObject1 = new BubbleDiyHandler(this);
      continue;
      localObject1 = new DingdongPluginBizHandler(this);
      continue;
      localObject1 = new FavEmoRoamingHandler(this);
      continue;
      localObject1 = new VIPRecommendPayHandler(this);
      continue;
      localObject1 = new PrinterStatusHandler(this);
      continue;
      localObject1 = new SenseWhereHandler(this);
      continue;
      localObject1 = new QWalletHandler(this);
      continue;
      localObject1 = new VasExtensionHandler(this);
      continue;
      localObject1 = new LightalkShieldHandler(this);
      continue;
      localObject1 = new QCallCardHandler(this);
      continue;
      localObject1 = new VipComicMqqHandler(this);
      continue;
      localObject1 = new GlobalSearchHandler(this);
      continue;
      localObject1 = new PstnHandler(this);
      continue;
      localObject1 = new QQHotSpotListHandler(this);
      continue;
      localObject1 = new LoginWelcomeHandler(this);
      continue;
      localObject1 = new QidianHandler(this);
      continue;
      localObject1 = new VIPAioSendHandler(this);
      continue;
      localObject1 = new EcshopReportHandler(this);
      continue;
      localObject1 = new NearbyHandler(this);
      continue;
      localObject1 = new VideoPlayRecommendHandler(this);
      continue;
      localObject1 = new RedtouchHandler(this);
      continue;
      localObject1 = new ArkAppHandler(this);
      continue;
      localObject1 = new PublicAccountArticleHandler(this);
      continue;
      localObject1 = new OlympicHandler(this);
      continue;
      localObject1 = new VoiceChangeHandler(this);
      continue;
      localObject1 = new DynamicAvatarInfoHandler(this);
      continue;
      localObject1 = new QQStoryHandler(this);
    }
  }
  
  public static String b(int paramInt1, String paramString, int paramInt2)
  {
    String str;
    if (paramInt1 == 4) {
      str = "troop_" + paramString;
    }
    do
    {
      return str;
      if (paramInt1 == 32) {
        return "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
      }
      str = paramString;
    } while (paramInt1 != 16);
    return "qcall_" + String.valueOf(paramInt2) + "_" + paramString;
  }
  
  private void c(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((this.i) || (!NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this))) {}
    Object localObject;
    int i1;
    Intent localIntent;
    StringBuffer localStringBuffer;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QCallFacade)getManager(37);
        } while (localObject == null);
        i1 = ((QCallFacade)localObject).c();
      } while (i1 == 0);
      if (i1 != 1) {
        break label374;
      }
      if (((paramMessageRecord.msgtype != 63520) && (paramMessageRecord.msgtype != 61528)) || (paramMessageRecord.istroop != 3000)) {
        break;
      }
      localIntent = a(a(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(a().getString(2131370062));
      i1 = ((QCallFacade)localObject).b();
    } while (i1 == 0);
    if (i1 > 1000)
    {
      localStringBuffer.append(a().getString(2131370059));
      label173:
      localObject = null;
      if (paramBoolean) {
        localObject = localStringBuffer.toString();
      }
      if (paramMessageRecord.msgtype != 63520) {
        break label444;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "AVNotify:MSG_TYPE_MULTI_VIDEO");
      }
      if (paramMessageRecord.istroop == 3000)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "AVNotify:UIN_TYPE_DISCUSSION");
        }
        localIntent.putExtra("qav_notify_flag", true);
      }
    }
    for (;;)
    {
      a(localIntent, (String)localObject, a().getResources().getString(2131370056), localStringBuffer.toString(), null, "CMD_SHOW_NOTIFIYCATION");
      return;
      if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
      {
        localIntent = new Intent(a(), SplashActivity.class);
        localIntent.putExtra("tab_index", MainFragment.a);
        localIntent.putExtra("conversation_index", 1);
        localIntent.setFlags(335544320);
        break;
      }
      localIntent = a(a(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
      break;
      label374:
      localIntent = new Intent(a(), SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.a);
      localIntent.putExtra("conversation_index", 1);
      localIntent.setFlags(335544320);
      break;
      localStringBuffer.append(i1).append(a().getString(2131370061));
      break label173;
      label444:
      if (paramMessageRecord.msgtype == 63527)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO");
        }
        localIntent.putExtra("qav_notify_flag", true);
      }
    }
  }
  
  private boolean c(String paramString)
  {
    return (String.valueOf(AppConstants.aq).equals(paramString)) || (String.valueOf(AppConstants.as).equals(paramString)) || (String.valueOf(AppConstants.ar).equals(paramString));
  }
  
  private void d(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    label123:
    boolean bool1;
    boolean bool4;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      localObject1 = null;
      if (paramMessageRecord != null)
      {
        if (paramMessageRecord.msgtype == 63516) {
          localObject1 = paramMessageRecord.getBaseInfoString();
        }
      }
      else {
        QLog.d("notification", 2, "message is:" + (String)localObject1 + ",isOnline is:" + paramBoolean);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "previous vibrate time is:" + this.jdField_e_of_type_Long + ",curr time is:" + System.currentTimeMillis());
      }
      if (this.jdField_e_of_type_Long != -1L) {
        break label381;
      }
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      bool1 = h();
      bool4 = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool4);
      }
      if ((paramMessageRecord == null) || (paramMessageRecord.istroop != 1008) || (!AppConstants.ae.equals(paramMessageRecord.senderuin))) {
        break label585;
      }
      bool2 = false;
      bool3 = false;
      paramMessageRecord = RingtoneManager.getActualDefaultRingtoneUri(a(), 2);
      localObject1 = (Vibrator)a().getSystemService("vibrator");
      if ((!k()) || (!bool4)) {
        break label509;
      }
      paramBoolean = true;
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canVibrator: " + paramBoolean + " canPlaySound: " + bool1 + " uri: " + paramMessageRecord);
      }
      if ((paramBoolean) && (localObject1 != null)) {
        ((Vibrator)localObject1).vibrate(jdField_b_of_type_ArrayOfLong, -1);
      }
      if ((bool1) && (paramMessageRecord != null)) {
        AudioUtil.a(paramMessageRecord, false, false);
      }
    }
    label381:
    label509:
    label585:
    while ((bool1) || (!bool4)) {
      for (;;)
      {
        return;
        localObject1 = "not shake msg,uinSeq is:" + paramMessageRecord.uniseq;
        break;
        if (Math.abs(System.currentTimeMillis() - this.jdField_e_of_type_Long) > 2000L) {
          break label123;
        }
        if (paramMessageRecord == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SpecialCare", 2, "message = null");
          }
        }
        else if (paramMessageRecord.msgtype != 63516)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SpecialCare", 2, "message.msgtype != MessageRecord.MSG_TYPE_SHAKE_WINDOW");
          }
        }
        else
        {
          if ((paramBoolean) && (a() == 11L)) {
            break label123;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("SpecialCare", 2, "isOnline = " + paramBoolean + " getOnlineStatus = " + a());
            return;
            if ((i()) && (j()) && (bool4))
            {
              bool1 = true;
              paramBoolean = true;
            }
            else
            {
              paramBoolean = bool3;
              bool1 = bool2;
              if (i())
              {
                paramBoolean = bool3;
                bool1 = bool2;
                if (!j())
                {
                  paramBoolean = bool3;
                  bool1 = bool2;
                  if (bool4)
                  {
                    bool1 = true;
                    paramBoolean = bool3;
                  }
                }
              }
            }
          }
        }
      }
    }
    SharedPreferences localSharedPreferences = a().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    Object localObject4 = (Vibrator)a().getSystemService("vibrator");
    boolean bool3 = d();
    Object localObject3 = "";
    Object localObject1 = "";
    int i1;
    label730:
    int i2;
    if (paramMessageRecord != null)
    {
      if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1004))
      {
        localObject1 = paramMessageRecord.frienduin;
        localObject3 = "special_sound_type" + a() + (String)localObject1;
      }
    }
    else
    {
      bool1 = y();
      bool2 = x();
      i1 = RoamSettingController.a(this);
      if (i1 != 0) {
        break label981;
      }
      if (d() != 1) {
        break label975;
      }
      i1 = 1;
      i2 = i1;
      if ((paramMessageRecord == null) || (paramMessageRecord.istroop != 1)) {
        break label1597;
      }
      if ((!bool1) || (!w())) {
        break label1003;
      }
      bool1 = true;
      label761:
      if ((!bool2) || (!v())) {
        break label1009;
      }
      bool2 = true;
    }
    label776:
    label975:
    label981:
    label1003:
    label1009:
    label1218:
    label1411:
    label1529:
    label1539:
    label1590:
    label1597:
    for (;;)
    {
      bool4 = m();
      boolean bool5 = u();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool2 + ",isVideoing is:" + bool3 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool2) && (bool4) && (!bool3) && (bool5))
      {
        if ((paramMessageRecord != null) && (paramBoolean) && (paramMessageRecord.msgtype == 63516) && (a() == 11L))
        {
          ((Vibrator)localObject4).vibrate(jdField_a_of_type_ArrayOfLong, -1);
          i1 = 2;
        }
        for (;;)
        {
          int i4 = this.jdField_d_of_type_JavaUtilList.size();
          int i3 = 0;
          while (i3 < i4)
          {
            ((VibrateListener)this.jdField_d_of_type_JavaUtilList.get(i3)).l(i1);
            i3 += 1;
          }
          localObject1 = paramMessageRecord.senderuin;
          break;
          i1 = 0;
          break label730;
          if (i1 == 1) {}
          for (i1 = 1;; i1 = 0)
          {
            i2 = i1;
            break;
          }
          bool1 = false;
          break label761;
          bool2 = false;
          break label776;
          if (localSharedPreferences.contains((String)localObject3))
          {
            ((Vibrator)localObject4).vibrate(1000L);
            i1 = 3;
          }
          else
          {
            ((Vibrator)localObject4).vibrate(jdField_b_of_type_ArrayOfLong, -1);
            i1 = 1;
          }
        }
      }
      if ((i2 != 0) && (!bool3) && (!k()) && (!l()) && (bool4) && (bool5))
      {
        i1 = SettingCloneUtil.readValueForInt(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, a(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.f);
        if (localSharedPreferences.contains((String)localObject3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "-->SpecialSound");
          }
          localObject4 = (FriendsManager)getManager(50);
          if ((localObject4 != null) && (((FriendsManager)localObject4).b((String)localObject1)))
          {
            i1 = localSharedPreferences.getInt((String)localObject3, i1);
            if (i1 != 1) {
              break label1411;
            }
            try
            {
              ThreadManager.a(new qea(this), 8, null, true);
              return;
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("notification", 2, localException.getMessage());
              }
            }
          }
        }
      }
      Object localObject2;
      if ((bool1) && (!bool3) && (!k()) && (!l()) && (bool4) && (bool5))
      {
        i2 = SettingCloneUtil.readValueForInt(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, a(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.f);
        if (QLog.isColorLevel())
        {
          localObject2 = (AudioManager)a().getSystemService("audio");
          localObject3 = new StringBuilder().append("StreamVolume=");
          if (localObject2 != null) {
            break label1529;
          }
        }
      }
      for (i1 = 0;; i1 = ((AudioManager)localObject2).getStreamVolume(2))
      {
        QLog.d("notification", 2, i1 + ",SoundRid=" + i2);
        if (i2 != SoundAndVibrateActivity.f) {
          break label1590;
        }
        localObject2 = ThemeUtil.getThemeVoiceRootPath();
        if (localObject2 == null) {
          break label1539;
        }
        localObject2 = new File((String)localObject2 + File.separatorChar + "message.mp3");
        if (!((File)localObject2).exists()) {
          break label1539;
        }
        AudioUtil.a(Uri.fromFile((File)localObject2), false, true);
        return;
        localObject2 = localSharedPreferences.getString("special_sound_url" + i1, "");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1218;
        }
        localObject3 = new File(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir(), (String)localObject2);
        if (((File)localObject3).exists())
        {
          AudioUtil.a(((File)localObject3).getAbsolutePath(), false);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
        }
        a(new qeb(this, (String)localObject2, (File)localObject3));
        break label1218;
        break;
      }
      for (i1 = 2131165190;; i1 = i2)
      {
        i2 = i1;
        if (paramMessageRecord != null)
        {
          i2 = i1;
          if (c(paramMessageRecord.frienduin)) {
            i2 = 2131165214;
          }
        }
        ThreadManager.a(new qec(this, i2), 8, null, true);
        return;
      }
    }
  }
  
  public static void f(String paramString)
  {
    TextToSpeech localTextToSpeech = jdField_a_of_type_AndroidSpeechTtsTextToSpeech;
    if ((localTextToSpeech != null) && (!TextUtils.isEmpty(paramString))) {
      localTextToSpeech.speak(paramString, 1, null);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if ((this.i) || (!NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this))) {}
    Intent localIntent;
    StringBuffer localStringBuffer;
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() != 1) {
        break;
      }
      localIntent = a(a(), (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0), false);
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(a().getString(2131370062));
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
    } while (i1 == 0);
    if (i1 > 1000)
    {
      localStringBuffer.append(a().getString(2131370057));
      label141:
      if (!paramBoolean) {
        break label241;
      }
    }
    label241:
    for (String str = localStringBuffer.toString();; str = null)
    {
      a(localIntent, str, a().getResources().getString(2131370056), localStringBuffer.toString(), null, "CMD_SHOW_NOTIFIYCATION");
      return;
      localIntent = new Intent(a(), SplashActivity.class);
      localIntent.addFlags(335544320);
      localIntent.putExtra("tab_index", MainFragment.a);
      break;
      localStringBuffer.append(i1).append(a().getString(2131368856));
      break label141;
    }
  }
  
  private String g()
  {
    try
    {
      int i1 = Process.myPid();
      Object localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i1)
        {
          localObject = localRunningAppProcessInfo.processName;
          return (String)localObject;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "failed to get current process name");
    }
    return null;
  }
  
  /* Error */
  private String h()
  {
    // Byte code:
    //   0: ldc_w 2705
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 859	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   8: invokevirtual 2709	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   11: astore_2
    //   12: aload_3
    //   13: astore_1
    //   14: aload_2
    //   15: aload_0
    //   16: getfield 859	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: invokevirtual 856	com/tencent/common/app/BaseApplicationImpl:getPackageName	()Ljava/lang/String;
    //   22: iconst_0
    //   23: invokevirtual 2715	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   26: astore 4
    //   28: aload_3
    //   29: astore_2
    //   30: aload 4
    //   32: ifnull +90 -> 122
    //   35: aload_3
    //   36: astore_1
    //   37: aload_3
    //   38: astore_2
    //   39: aload 4
    //   41: getfield 2720	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   44: ifnull +78 -> 122
    //   47: aload_3
    //   48: astore_1
    //   49: aload 4
    //   51: getfield 2720	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: ifnull +64 -> 122
    //   61: aload_3
    //   62: astore_1
    //   63: aload_3
    //   64: ldc_w 2722
    //   67: invokevirtual 1226	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore 4
    //   72: iconst_3
    //   73: istore 5
    //   75: aload_3
    //   76: astore_1
    //   77: aload_3
    //   78: astore_2
    //   79: iload 5
    //   81: aload 4
    //   83: arraylength
    //   84: if_icmple +38 -> 122
    //   87: aload_3
    //   88: astore_1
    //   89: new 603	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 606	java/lang/StringBuilder:<init>	()V
    //   96: aload_3
    //   97: invokevirtual 612	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 2724
    //   103: invokevirtual 612	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 616	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_3
    //   110: iload 5
    //   112: iconst_1
    //   113: isub
    //   114: istore 5
    //   116: goto -41 -> 75
    //   119: astore_2
    //   120: aload_1
    //   121: astore_2
    //   122: aload_2
    //   123: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	QQAppInterface
    //   13	108	1	str1	String
    //   11	68	2	localObject1	Object
    //   119	1	2	localException	Exception
    //   121	2	2	localObject2	Object
    //   3	107	3	str2	String
    //   26	56	4	localObject3	Object
    //   73	42	5	i1	int
    // Exception table:
    //   from	to	target	type
    //   14	28	119	java/lang/Exception
    //   39	47	119	java/lang/Exception
    //   49	55	119	java/lang/Exception
    //   63	72	119	java/lang/Exception
    //   79	87	119	java/lang/Exception
    //   89	110	119	java/lang/Exception
  }
  
  private boolean u()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.f());
  }
  
  private boolean v()
  {
    return c() != 0;
  }
  
  private boolean w()
  {
    return b() != 0;
  }
  
  private boolean x()
  {
    return e() != 0;
  }
  
  private boolean y()
  {
    return d() != 0;
  }
  
  public void A()
  {
    long l2 = 0L;
    long l1;
    if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) && (this.l))
    {
      l1 = l2;
      if (this.jdField_b_of_type_Long != 0L)
      {
        l1 = ep - (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
        if (l1 >= 0L) {
          break label117;
        }
        l1 = l2;
      }
    }
    label117:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResume send msg " + l1);
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, new WeakReference(this));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1);
      return;
    }
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.j();
    }
    Object localObject = (SubAccountManager)getManager(60);
    if (localObject != null) {
      ((SubAccountManager)localObject).c();
    }
    localObject = (ActivateFriendsManager)getManager(84);
    if (localObject != null) {
      ((ActivateFriendsManager)localObject).d();
    }
  }
  
  public void C()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    try
    {
      a(getApplication().getAssets().open("qqtags.xml"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshAppBadge");
    }
    if ((this.isBackground_Stop) && (BadgeUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext()))) {
      ThreadManager.a(new qei(this), 5, null, false);
    }
  }
  
  public void E()
  {
    try
    {
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("accessibility");
      bool1 = localAccessibilityManager.isEnabled();
      boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label100;
      }
      bool1 = true;
      AppSetting.j = bool1;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "set talkback enable: " + AppSetting.j);
      }
    }
    catch (Throwable localThrowable)
    {
      boolean bool1;
      label100:
      for (;;) {}
    }
    if (AppSetting.j) {
      if (jdField_a_of_type_AndroidSpeechTtsTextToSpeech == null) {
        jdField_a_of_type_AndroidSpeechTtsTextToSpeech = new TextToSpeech(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, null);
      }
    }
    while (jdField_a_of_type_AndroidSpeechTtsTextToSpeech == null)
    {
      return;
      bool1 = false;
      break;
    }
    jdField_a_of_type_AndroidSpeechTtsTextToSpeech.stop();
    jdField_a_of_type_AndroidSpeechTtsTextToSpeech = null;
  }
  
  public void F()
  {
    int i1 = 2131370319;
    if ((this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) && (isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Mobile ");
      }
      localObject1 = a();
      bool1 = ((TransFileController)localObject1).c();
      bool2 = ((TransFileController)localObject1).a();
      bool3 = ((TransFileController)localObject1).b();
      localObject2 = BaseActivity.sTopActivity;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      }
      if ((bool1) || (bool2) || (bool3))
      {
        localObject2 = new Intent((Context)localObject1, DialogActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).addFlags(131072);
        if (!bool2) {
          break label296;
        }
        if (!bool3) {
          break label284;
        }
      }
    }
    label284:
    label296:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      Object localObject2;
      i1 = 2131370318;
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onX2Mobile==============pauseAllRawSendC2C:" + bool1);
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onX2Mobile==============pauseAllShortVideoSend:" + bool2);
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onX2Mobile==============pauseAllShortVideoReceive:" + bool3);
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onX2Mobile==============dialog message:" + ((Context)localObject1).getResources().getString(i1));
        }
        ((Intent)localObject2).putExtra("key_dialog_msg_id", i1);
        ((Context)localObject1).startActivity((Intent)localObject2);
        return;
        if (!bool1)
        {
          i1 = 2131370315;
          continue;
          if (bool3)
          {
            if (!bool1) {
              i1 = 2131370316;
            }
          }
          else {
            i1 = 2131370317;
          }
        }
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onX2Mobile app = null,maybe not QQ process");
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Wifi ");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onX2Wifi app = null,maybe not QQ process");
  }
  
  public void H()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + a(), 0);
    if (localSharedPreferences != null) {
      cu = localSharedPreferences.getInt("browser_font_size_index", 1);
    }
  }
  
  public int a()
  {
    return AppSetting.a;
  }
  
  public int a(int paramInt)
  {
    int i2 = -1;
    int i1;
    if ((this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl == null) || (paramInt < 0) || (paramInt >= 7))
    {
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "readCallTabStateVal wrong index," + paramInt);
        i1 = i2;
      }
    }
    do
    {
      String str;
      do
      {
        return i1;
        str = SettingCloneUtil.readValue(getApplication(), a(), null, "qqsetting_calltab_show_key", "0111100");
        if ((str != null) && (str.length() == 7)) {
          break;
        }
        i1 = i2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "readCallTabStateVal val is null");
      return -1;
      i2 = str.charAt(paramInt) - '0';
      i1 = i2;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "uin:" + a() + ",readCallTabStateVal index=" + paramInt + ", resut=" + i2);
    return i2;
  }
  
  public int a(String paramString)
  {
    int i3 = 0;
    try
    {
      Class[] arrayOfClass = Class.forName("com.android.internal.R").getDeclaredClasses();
      int i4 = arrayOfClass.length;
      int i1 = 0;
      for (;;)
      {
        int i2 = i3;
        if (i1 < i4)
        {
          Class localClass = arrayOfClass[i1];
          if ("id".equals(localClass.getSimpleName())) {
            i2 = localClass.getDeclaredField(paramString).getInt(null);
          }
        }
        else
        {
          return i2;
        }
        i1 += 1;
      }
      return 0;
    }
    catch (Exception paramString) {}
  }
  
  public long a()
  {
    if ((getAccount() != null) && (isLogin()))
    {
      if (this.jdField_d_of_type_Long == 31L)
      {
        this.jdField_d_of_type_Long = a().getSharedPreferences("acc_info" + getAccount(), 0).getLong("getProfileStatusNew", 11L);
        if (this.jdField_d_of_type_Long == 31L)
        {
          this.jdField_d_of_type_Long = 11L;
          a(11L, false);
        }
      }
      return this.jdField_d_of_type_Long;
    }
    return -1L;
  }
  
  public Intent a()
  {
    return this.jdField_b_of_type_AndroidContentIntent;
  }
  
  public Intent a(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020) || (paramMessage.istroop == 1004))
    {
      if (RecentUtil.a(this, paramMessage.frienduin)) {
        return a(a(), paramMessage, 0);
      }
      return b(paramContext, paramMessage, paramBoolean);
    }
    return a(a(), paramMessage, paramMessage.istroop);
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte1, boolean paramBoolean, byte paramByte2, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramString != null) && ((paramString.equals(AppConstants.as)) || (paramString.equals(AppConstants.ar)) || (paramString.equals(AppConstants.ao)) || (paramString.equals(AppConstants.aq)))) {
      return ImageUtil.h();
    }
    if ((paramInt1 == 11) && (!StringUtil.e(paramString))) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      paramByte1 = 1;
    }
    String str1 = a(paramInt1, paramString, paramByte1, paramInt2);
    Object localObject1 = a(str1);
    boolean bool;
    String str2;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult;
    int i1;
    label329:
    Object localObject2;
    if (localObject1 == null) {
      if (paramBoolean)
      {
        localObject1 = a(paramInt1, paramString, paramInt2);
        if (localObject1 != null)
        {
          bool = ((Boolean)((Pair)localObject1).first).booleanValue();
          str2 = a(paramInt1, paramString, paramInt2);
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inPreferredConfig = jdField_a_of_type_AndroidGraphicsBitmap$Config;
          localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
          i1 = 0;
          do
          {
            BitmapManager.a(str2, (BitmapFactory.Options)localObject1, localBitmapDecodeResult);
            if (localBitmapDecodeResult.e == 1) {
              I();
            }
            i1 += 1;
          } while ((i1 < 2) && (localBitmapDecodeResult.e == 1));
          if (localBitmapDecodeResult.e != 0) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decodeFile fail, faceType=" + paramInt1 + ", uin=" + paramString + ", result=" + localBitmapDecodeResult.e + ", facePath=" + str2);
          }
          if ((!bool) && (localBitmapDecodeResult.e == 1)) {
            return null;
          }
          if (localBitmapDecodeResult.e != 2)
          {
            i1 = 1;
            localObject1 = localBitmapDecodeResult.a;
            if ((localObject1 == null) && (localBitmapDecodeResult.e != 1) && (i1 != 0))
            {
              if (paramInt1 != 4) {
                break label868;
              }
              localObject2 = "troop_" + paramString;
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
        int i2;
        if (localInteger == null)
        {
          i2 = 0;
          QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject2 + ", nDecodeFailCount = " + i2);
          if (i2 < 3)
          {
            i2 += 1;
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(i2));
            FileUtils.d(str2);
            QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject2 + ", del the damaged file" + ",nDecodeFailCount=" + i2);
          }
          if (localObject1 == null) {
            break label865;
          }
        }
        switch (paramByte1)
        {
        case 2: 
        default: 
          localObject1 = a((Bitmap)localObject1);
          if (localObject1 == null) {
            break label739;
          }
          a(str1, (Bitmap)localObject1, paramByte2);
          if (((localObject1 == null) && (paramBoolean) && (i1 == 0)) || (bool))
          {
            if (i1 == 0) {
              break label803;
            }
            paramByte1 = 1;
            localObject2 = (FriendListHandler)a(1);
          }
          switch (paramInt1)
          {
          default: 
            return (Bitmap)localObject1;
            i1 = 0;
            break label329;
            i2 = localInteger.intValue();
          }
          break;
        }
      }
      continue;
      localObject1 = a((Bitmap)localObject1, 50, 50);
      continue;
      label739:
      if ((QLog.isColorLevel()) && (localBitmapDecodeResult.e == 0)) {
        QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decode shape fail, faceType=" + paramInt1 + ", uin=" + paramString + ", shape=" + paramByte1);
      }
      continue;
      label803:
      paramByte1 = 2;
      continue;
      ((FriendListHandler)localObject2).b(paramString, paramByte1);
      continue;
      ((FriendListHandler)localObject2).a(paramString, paramByte1);
      continue;
      ((FriendListHandler)localObject2).a(paramString, (byte)0, paramByte1);
      continue;
      ((FriendListHandler)localObject2).a(paramString, paramInt2, (byte)1, paramByte1);
      continue;
      ((FriendListHandler)localObject2).b(paramString, paramInt2, (byte)1, paramByte1);
      continue;
      label865:
      continue;
      label868:
      localObject2 = paramString;
      continue;
      bool = false;
      break;
      bool = false;
      i1 = 0;
    }
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte, paramBoolean, (byte)1, paramInt2);
  }
  
  public Bitmap a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, (byte)3, paramBoolean, paramInt2);
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    return ImageUtil.b(paramBitmap, 50, 50);
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    float f1 = f2;
    if (i1 > 0)
    {
      f1 = f2;
      if (i1 < paramInt1 * f2) {
        f1 = i1 / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          localBitmap1 = localBitmap2;
          if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
          {
            long l1 = ((Long)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
            localBitmap1 = localBitmap2;
            if (System.currentTimeMillis() - l1 > 86400000L)
            {
              this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
              this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
              localBitmap1 = null;
            }
          }
        }
      }
      return localBitmap1;
    }
    return null;
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean)
  {
    return a(1, paramString, paramByte, paramBoolean, 0);
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(4, paramString, paramByte, true, 0);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = ImageUtil.f();
    }
    localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramBoolean1) {
        localObject = ImageUtil.a(paramString);
      }
    }
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (paramBoolean2) {
        paramString = b((Bitmap)localObject);
      }
    }
    return paramString;
  }
  
  public Bitmap a(String paramString, int paramInt)
  {
    return a(32, paramString, true, paramInt);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(1, paramString, (byte)3, paramBoolean, 0);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public Drawable a(Bitmap paramBitmap)
  {
    return new BitmapDrawable(a(paramBitmap));
  }
  
  public Drawable a(String paramString)
  {
    return a(paramString, (byte)3, false, false);
  }
  
  @Deprecated
  public Drawable a(String paramString, byte paramByte)
  {
    Bitmap localBitmap = a(11, paramString, paramByte, true, 0);
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = ImageUtil.a();
    }
    return new BitmapDrawable(paramString);
  }
  
  public Drawable a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramString, paramByte, paramBoolean1, paramBoolean2);
    paramString = null;
    if (localObject != null) {
      paramString = new BitmapDrawable((Bitmap)localObject);
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = ImageUtil.c();
    }
    return (Drawable)localObject;
  }
  
  public Pair a(int paramInt1, String paramString, int paramInt2)
  {
    Setting localSetting1 = null;
    String str = b(paramInt1, paramString, paramInt2);
    if (!TextUtils.isEmpty(str)) {
      localSetting1 = (Setting)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
    Setting localSetting2 = localSetting1;
    if (localSetting1 == null)
    {
      localSetting2 = localSetting1;
      if (!this.n)
      {
        localSetting2 = localSetting1;
        if (!TextUtils.isEmpty(str))
        {
          localSetting2 = localSetting1;
          if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
          {
            localSetting2 = localSetting1;
            if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
            {
              localSetting1 = (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, str);
              localSetting2 = localSetting1;
              if (localSetting1 != null)
              {
                this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localSetting1);
                localSetting2 = localSetting1;
              }
            }
          }
        }
      }
    }
    if (localSetting2 == null) {
      return new Pair(Boolean.valueOf(true), localSetting2);
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (bool)) {
        QLog.i("Q.qqhead.qaif", 2, "getQQHeadSetting. | uin=" + paramString + ", isNeedCheckQQHead=" + bool + ", accountStartTime=" + this.jdField_f_of_type_Long + ", updateTimestamp=" + localSetting2.updateTimestamp);
      }
      return new Pair(Boolean.valueOf(bool), localSetting2);
      if ((localSetting2 == null) || (System.currentTimeMillis() - localSetting2.updateTimestamp > 86400000L)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public Pair a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    paramString = a(1, paramString, (byte)3, true, 0);
    if (paramString == null) {
      paramString = ImageUtil.a();
    }
    for (;;)
    {
      return Pair.create(Boolean.valueOf(bool), paramString);
      bool = true;
    }
  }
  
  public AvAddFriendService a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppAvAddFriendService == null) {
      this.jdField_a_of_type_ComTencentAvAppAvAddFriendService = new AvAddFriendService(this);
    }
    return this.jdField_a_of_type_ComTencentAvAppAvAddFriendService;
  }
  
  public AVNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter = new AVNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter;
  }
  
  public NowLiveManager a()
  {
    return (NowLiveManager)getManager(170);
  }
  
  public BusinessHandler a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
    if (localObject1 != null) {
      return (BusinessHandler)localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      BusinessHandler localBusinessHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
      localObject1 = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        localBusinessHandler = b(paramInt);
        localObject1 = localBusinessHandler;
        if (localBusinessHandler != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt] = localBusinessHandler;
          localObject1 = localBusinessHandler;
        }
      }
      return (BusinessHandler)localObject1;
    }
  }
  
  public CheckPttListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener;
  }
  
  public CheckPtvListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppCheckPtvListener;
  }
  
  public HotChatManager a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager == null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = ((HotChatManager)getManager(59));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
  }
  
  public LebaHelper a()
  {
    o();
    return this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper;
  }
  
  public MessageHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = ((MessageHandler)a(0));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  }
  
  public QQGAudioMsgHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler = new QQGAudioMsgHandler(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler;
  }
  
  public SQLiteDatabase a()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.a();
    }
    return null;
  }
  
  public SQLiteDatabase a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
  
  public CacheManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager = ((CacheManager)getManager(18));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager;
  }
  
  public ConversationFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = ((ConversationFacade)getManager(28));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
  }
  
  public MsgProxy a(int paramInt)
  {
    if (a() != null) {
      return a().a().a(paramInt);
    }
    return null;
  }
  
  public MultiMsgProxy a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
    }
    return null;
  }
  
  public QQMessageFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)getManager(19));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
  }
  
  public DataLineMsgProxy a(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public FTSDBManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager = ((FTSDBManager)getManager(129));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager;
  }
  
  public ProxyManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)getManager(17));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  }
  
  public AboutConfig a()
  {
    M();
    return this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig;
  }
  
  public Config a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqConfigConfig == null) {
        this.jdField_a_of_type_ComTencentMobileqqConfigConfig = new Config(this, paramString);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqConfigConfig;
      return paramString;
    }
    finally {}
  }
  
  public Setting a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.n) {
      return null;
    }
    return (Setting)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public FileManagerEngine a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine = new FileManagerEngine(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine;
  }
  
  public FileTransferHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler = new FileTransferHandler(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler;
  }
  
  public FileManagerDataCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter = new FileManagerDataCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter;
  }
  
  public FileManagerNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter = new FileManagerNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter;
  }
  
  public FileManagerRSCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter = new FileManagerRSCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter;
  }
  
  public OnlineFileSessionCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter = new OnlineFileSessionCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter;
  }
  
  public FileManagerProxy a()
  {
    ProxyManager localProxyManager = a();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public PrivacyInfoUtil a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil = new PrivacyInfoUtil();
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil;
  }
  
  public UniformDownloadBPTransProxy a()
  {
    ProxyManager localProxyManager = a();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public NearbyProxy a()
  {
    return (NearbyProxy)getManager(115);
  }
  
  public EntityManagerFactory a()
  {
    String str = getAccount();
    if (str == null) {
      throw new IllegalStateException("WTF");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory = new QQEntityManagerFactory(str);
        ThreadManager.b().postDelayed(new qeo(this), 3000L);
      }
      return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    }
    finally {}
  }
  
  @Deprecated
  public EntityManagerFactory a(String paramString)
  {
    if (!paramString.equals(getAccount())) {
      throw new IllegalStateException(paramString + "!=" + getAccount());
    }
    return a();
  }
  
  public PicPreDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader = ((PicPreDownloader)getManager(38));
    }
    return this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  }
  
  public QCallFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)getManager(37));
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  }
  
  public QzoneContactsFeedManager a()
  {
    return (QzoneContactsFeedManager)getManager(90);
  }
  
  public MessageCache a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache == null) {}
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache == null) {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache = new MessageCache(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
    }
  }
  
  public ShortVideoPreDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader = ((ShortVideoPreDownloader)getManager(94));
    }
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader;
  }
  
  public ReportController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController == null) {
        this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController = ReportControllerImpl.a(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController;
    }
    finally {}
  }
  
  public INetEngine a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)getManager(20));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public TransFileController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = new TransFileController(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public ISecureModuleService a()
  {
    if (this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService == null) {
      this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService = SecureModuleService.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    }
    return this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  }
  
  public QQProxyForQlink a()
  {
    if (this.jdField_a_of_type_CooperationQlinkQQProxyForQlink == null) {
      this.jdField_a_of_type_CooperationQlinkQQProxyForQlink = new QQProxyForQlink(this);
    }
    return this.jdField_a_of_type_CooperationQlinkQQProxyForQlink;
  }
  
  public QlinkServiceManager a()
  {
    if (this.jdField_a_of_type_CooperationQlinkQlinkServiceManager == null) {
      this.jdField_a_of_type_CooperationQlinkQlinkServiceManager = new QlinkServiceManager(this);
    }
    return this.jdField_a_of_type_CooperationQlinkQlinkServiceManager;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    localObject = MD5.toMD5((String)localObject + paramString);
    paramString = MD5.toMD5((String)localObject + paramString);
    localObject = new StringBuilder(256);
    if (paramInt == 4) {
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.bH);
      }
    }
    for (;;)
    {
      if (paramInt == 101) {
        ((StringBuilder)localObject).append("discussion_");
      }
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".png");
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_thd/");
      continue;
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.bG);
      } else {
        ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      }
    }
  }
  
  public String a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte, paramInt2, false);
  }
  
  public String a(int paramInt1, String paramString, byte paramByte, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    Object[] arrayOfObject = a(paramInt1, paramString, paramInt2, paramBoolean);
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      if (paramByte > 0) {
        localStringBuilder.append("_").append(paramByte);
      }
      return localStringBuilder.toString();
      localStringBuilder.append("troop_sys_b_");
      paramString = (String)arrayOfObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)arrayOfObject[1];
      continue;
      localStringBuilder.append("dis_e_");
      continue;
      localStringBuilder.append("dis_pstn_e_");
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("sub_");
      localStringBuilder.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      localStringBuilder.append("qcall_").append(Integer.toString(paramInt2)).append("_");
    }
  }
  
  public String a(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    Object localObject;
    if (paramInt1 == 32) {
      if (SystemUtil.a())
      {
        localStringBuilder.append(AppConstants.bK);
        localObject = a(paramInt1, paramString, paramInt2, false);
        switch (((Integer)localObject[0]).intValue())
        {
        }
      }
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      localStringBuilder.append(MD5.toMD5((String)localObject + paramString));
      localStringBuilder.append(".jpg_");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
      break;
      if (SystemUtil.a())
      {
        localStringBuilder.append(AppConstants.bG);
        break;
      }
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      break;
      localStringBuilder.append("troop_sys_b_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("dis_e_");
      paramString = a() + paramString;
      continue;
      localStringBuilder.append("dis_pstn_e_");
      paramString = a() + paramString;
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      localStringBuilder.append("qcall_").append(Integer.toString(paramInt2)).append("_");
    }
  }
  
  public String a(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("getServerConfigValue type=").append(paramConfigType).append(", key=").append(paramString).append(", value=");
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      if ((this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramConfigType)) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramConfigType)) && (l1 - ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramConfigType)).longValue() < 7200000L))
      {
        paramConfigType = (HashMap)this.jdField_b_of_type_JavaUtilHashtable.get(paramConfigType);
        if (paramConfigType.containsKey(paramString))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder.append((String)paramConfigType.get(paramString));
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          return (String)paramConfigType.get(paramString);
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder.append("null");
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        return null;
      }
      if (getAccount() == null) {}
      for (Object localObject = "0";; localObject = getAccount())
      {
        localObject = ((ServerConfigManager)getManager(4)).getServerConfig((String)localObject, paramConfigType);
        if ((localObject != null) && (((String)localObject).length() != 0)) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder.append("null, configText is null");
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        return null;
      }
      try
      {
        localObject = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<ServerConfig>" + (String)localObject + "</ServerConfig>";
        XMLReader localXMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        qet localqet = new qet(this);
        localXMLReader.setContentHandler(localqet);
        localXMLReader.parse(new InputSource(new ByteArrayInputStream(((String)localObject).getBytes("UTF-8"))));
        localObject = localqet.a();
        this.jdField_b_of_type_JavaUtilHashtable.put(paramConfigType, localObject);
        this.jdField_b_of_type_JavaUtilHashMap.put(paramConfigType, Long.valueOf(l1));
        l1 = System.currentTimeMillis() - l1;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append((String)((HashMap)localObject).get(paramString));
          localStringBuilder.append(",cost:").append(l1);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        if (l1 > 2000L) {
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(a(), "getConfigLongCost", true, l1, 0L, null, null);
        }
        paramConfigType = (String)((HashMap)localObject).get(paramString);
        return paramConfigType;
      }
      catch (Exception paramConfigType)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString(), paramConfigType);
        }
        return null;
      }
      localStringBuilder = null;
    }
  }
  
  public String a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return a(4, paramString, 0);
    }
    return a(1, paramString, 0);
  }
  
  /* Error */
  public HashMap a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: new 816	java/util/HashMap
    //   8: dup
    //   9: invokespecial 817	java/util/HashMap:<init>	()V
    //   12: astore 6
    //   14: aload_0
    //   15: getfield 859	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: invokevirtual 3436	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   21: new 603	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 606	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 3438
    //   31: invokevirtual 612	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: invokevirtual 999	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   38: invokevirtual 612	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 616	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 3441	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   47: iconst_1
    //   48: anewarray 597	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: ldc_w 3443
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 3449	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore_2
    //   64: aload_2
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull +129 -> 196
    //   70: aload_3
    //   71: invokeinterface 3454 1 0
    //   76: ifle +120 -> 196
    //   79: aload_3
    //   80: ldc_w 3443
    //   83: invokeinterface 3457 2 0
    //   88: istore 9
    //   90: new 722	java/util/ArrayList
    //   93: dup
    //   94: invokespecial 723	java/util/ArrayList:<init>	()V
    //   97: astore 4
    //   99: aload 4
    //   101: astore_2
    //   102: aload_3
    //   103: invokeinterface 3460 1 0
    //   108: ifeq +90 -> 198
    //   111: aload_3
    //   112: iload 9
    //   114: invokeinterface 3461 2 0
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull -22 -> 99
    //   124: aload 4
    //   126: aload_2
    //   127: invokevirtual 1236	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   130: pop
    //   131: goto -32 -> 99
    //   134: astore_2
    //   135: aload 4
    //   137: astore_2
    //   138: aload_2
    //   139: astore 4
    //   141: aload_3
    //   142: ifnull +448 -> 590
    //   145: aload_3
    //   146: invokeinterface 3464 1 0
    //   151: iload_1
    //   152: bipush -2
    //   154: if_icmpne +73 -> 227
    //   157: aload_2
    //   158: ifnull +35 -> 193
    //   161: aload_2
    //   162: invokevirtual 982	java/util/ArrayList:size	()I
    //   165: ifle +28 -> 193
    //   168: aload 6
    //   170: bipush -2
    //   172: invokestatic 1937	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aload_2
    //   176: aload_2
    //   177: invokevirtual 982	java/util/ArrayList:size	()I
    //   180: anewarray 597	java/lang/String
    //   183: invokevirtual 3468	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   186: checkcast 3470	[Ljava/lang/String;
    //   189: invokevirtual 2984	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   192: pop
    //   193: aload 6
    //   195: areturn
    //   196: aconst_null
    //   197: astore_2
    //   198: aload_2
    //   199: astore 4
    //   201: aload_3
    //   202: ifnull +388 -> 590
    //   205: aload_3
    //   206: invokeinterface 3464 1 0
    //   211: goto -60 -> 151
    //   214: astore_2
    //   215: aload_3
    //   216: ifnull +9 -> 225
    //   219: aload_3
    //   220: invokeinterface 3464 1 0
    //   225: aload_2
    //   226: athrow
    //   227: aload_2
    //   228: ifnull +351 -> 579
    //   231: aload_0
    //   232: aload_2
    //   233: invokevirtual 3473	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/util/List;)Ljava/util/Map;
    //   236: astore 7
    //   238: aload 7
    //   240: ifnull +312 -> 552
    //   243: new 722	java/util/ArrayList
    //   246: dup
    //   247: invokespecial 723	java/util/ArrayList:<init>	()V
    //   250: astore 5
    //   252: new 722	java/util/ArrayList
    //   255: dup
    //   256: invokespecial 723	java/util/ArrayList:<init>	()V
    //   259: astore_3
    //   260: new 722	java/util/ArrayList
    //   263: dup
    //   264: invokespecial 723	java/util/ArrayList:<init>	()V
    //   267: astore 4
    //   269: iconst_0
    //   270: istore 9
    //   272: iload 9
    //   274: aload_2
    //   275: invokevirtual 982	java/util/ArrayList:size	()I
    //   278: if_icmpge +129 -> 407
    //   281: aload_2
    //   282: iload 9
    //   284: invokevirtual 1252	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   287: checkcast 597	java/lang/String
    //   290: astore 8
    //   292: aload 7
    //   294: aload 8
    //   296: invokeinterface 3476 2 0
    //   301: checkcast 1934	java/lang/Integer
    //   304: invokevirtual 2999	java/lang/Integer:intValue	()I
    //   307: tableswitch	default:+29->336, 1:+38->345, 2:+59->366, 3:+29->336, 4:+79->386
    //   336: iload 9
    //   338: iconst_1
    //   339: iadd
    //   340: istore 9
    //   342: goto -70 -> 272
    //   345: iload_1
    //   346: iconst_m1
    //   347: if_icmpeq +8 -> 355
    //   350: iload_1
    //   351: iconst_1
    //   352: if_icmpne -16 -> 336
    //   355: aload 5
    //   357: aload 8
    //   359: invokevirtual 1236	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   362: pop
    //   363: goto -27 -> 336
    //   366: iload_1
    //   367: iconst_m1
    //   368: if_icmpeq +8 -> 376
    //   371: iload_1
    //   372: iconst_2
    //   373: if_icmpne -37 -> 336
    //   376: aload_3
    //   377: aload 8
    //   379: invokevirtual 1236	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   382: pop
    //   383: goto -47 -> 336
    //   386: iload_1
    //   387: iconst_m1
    //   388: if_icmpeq +8 -> 396
    //   391: iload_1
    //   392: iconst_4
    //   393: if_icmpne -57 -> 336
    //   396: aload 4
    //   398: aload 8
    //   400: invokevirtual 1236	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   403: pop
    //   404: goto -68 -> 336
    //   407: aload 5
    //   409: astore_2
    //   410: aload_2
    //   411: ifnull +44 -> 455
    //   414: aload_2
    //   415: invokevirtual 982	java/util/ArrayList:size	()I
    //   418: ifle +37 -> 455
    //   421: iload_1
    //   422: iconst_m1
    //   423: if_icmpeq +8 -> 431
    //   426: iload_1
    //   427: iconst_1
    //   428: if_icmpne +27 -> 455
    //   431: aload 6
    //   433: iconst_1
    //   434: invokestatic 1937	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   437: aload_2
    //   438: aload_2
    //   439: invokevirtual 982	java/util/ArrayList:size	()I
    //   442: anewarray 597	java/lang/String
    //   445: invokevirtual 3468	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   448: checkcast 3470	[Ljava/lang/String;
    //   451: invokevirtual 2984	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   454: pop
    //   455: aload_3
    //   456: ifnull +44 -> 500
    //   459: aload_3
    //   460: invokevirtual 982	java/util/ArrayList:size	()I
    //   463: ifle +37 -> 500
    //   466: iload_1
    //   467: iconst_m1
    //   468: if_icmpeq +8 -> 476
    //   471: iload_1
    //   472: iconst_2
    //   473: if_icmpne +27 -> 500
    //   476: aload 6
    //   478: iconst_2
    //   479: invokestatic 1937	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: aload_3
    //   483: aload_3
    //   484: invokevirtual 982	java/util/ArrayList:size	()I
    //   487: anewarray 597	java/lang/String
    //   490: invokevirtual 3468	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   493: checkcast 3470	[Ljava/lang/String;
    //   496: invokevirtual 2984	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: aload 4
    //   502: ifnull +47 -> 549
    //   505: aload 4
    //   507: invokevirtual 982	java/util/ArrayList:size	()I
    //   510: ifle +39 -> 549
    //   513: iload_1
    //   514: iconst_m1
    //   515: if_icmpeq +8 -> 523
    //   518: iload_1
    //   519: iconst_4
    //   520: if_icmpne +29 -> 549
    //   523: aload 6
    //   525: iconst_4
    //   526: invokestatic 1937	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   529: aload 4
    //   531: aload 4
    //   533: invokevirtual 982	java/util/ArrayList:size	()I
    //   536: anewarray 597	java/lang/String
    //   539: invokevirtual 3468	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   542: checkcast 3470	[Ljava/lang/String;
    //   545: invokevirtual 2984	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   548: pop
    //   549: aload 6
    //   551: areturn
    //   552: aconst_null
    //   553: astore_3
    //   554: aload 5
    //   556: astore 4
    //   558: goto -148 -> 410
    //   561: astore_2
    //   562: goto -347 -> 215
    //   565: astore_2
    //   566: aconst_null
    //   567: astore_3
    //   568: aconst_null
    //   569: astore_2
    //   570: goto -432 -> 138
    //   573: astore_2
    //   574: aconst_null
    //   575: astore_2
    //   576: goto -438 -> 138
    //   579: aconst_null
    //   580: astore_3
    //   581: aconst_null
    //   582: astore_2
    //   583: aload 5
    //   585: astore 4
    //   587: goto -177 -> 410
    //   590: aload 4
    //   592: astore_2
    //   593: goto -442 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	QQAppInterface
    //   0	596	1	paramInt	int
    //   63	64	2	localObject1	Object
    //   134	1	2	localException1	Exception
    //   137	62	2	localObject2	Object
    //   214	68	2	localList	List
    //   409	30	2	localArrayList1	ArrayList
    //   561	1	2	localObject3	Object
    //   565	1	2	localException2	Exception
    //   569	1	2	localObject4	Object
    //   573	1	2	localException3	Exception
    //   575	18	2	localObject5	Object
    //   4	577	3	localObject6	Object
    //   97	494	4	localObject7	Object
    //   1	583	5	localArrayList2	ArrayList
    //   12	538	6	localHashMap	HashMap
    //   236	57	7	localMap	Map
    //   290	109	8	str	String
    //   88	253	9	i1	int
    // Exception table:
    //   from	to	target	type
    //   102	120	134	java/lang/Exception
    //   124	131	134	java/lang/Exception
    //   14	64	214	finally
    //   70	99	561	finally
    //   102	120	561	finally
    //   124	131	561	finally
    //   14	64	565	java/lang/Exception
    //   70	99	573	java/lang/Exception
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a();
    }
    return null;
  }
  
  public List a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (paramInt == 2) {
      return this.jdField_b_of_type_JavaUtilList;
    }
    if (paramInt == 0) {
      return this.jdField_c_of_type_JavaUtilList;
    }
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public Map a(List paramList)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.a(paramList, 1);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_Boolean = true;
    }
    while ((!isLogin()) || (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "Wifi, tryReuploadQfavItems");
    }
    QfavHelper.a(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ((ConfigHandler)a(4)).a(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    int i1 = 0;
    paramString = a(paramInt1, paramString, (byte)0, paramInt2);
    paramInt1 = i1;
    while (paramInt1 <= 3)
    {
      String str = paramString + "_" + paramInt1;
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(str);
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt1, String arg2, int paramInt2, String arg4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "sendQQHeadBroadcast.type=" + paramInt1 + ",uin=" + ??? + ",idType=" + paramInt2 + ",path=" + ???);
    }
    if (!this.jdField_a_of_type_JavaUtilHashtable.containsKey(???)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashtable)
    {
      this.jdField_a_of_type_JavaUtilHashtable.remove(???);
      if (paramInt1 != 1) {}
    }
    Object localObject;
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(???);
        ??? = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
        ???.what = 990;
        this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
        if (this.jdField_a_of_type_JavaUtilHashtable.size() <= 50) {
          break;
        }
        synchronized (this.jdField_a_of_type_JavaUtilHashtable)
        {
          long l1 = System.currentTimeMillis();
          ??? = new ArrayList();
          localObject = this.jdField_a_of_type_JavaUtilHashtable.keys();
          if (!((Enumeration)localObject).hasMoreElements()) {
            break label334;
          }
          String str = (String)((Enumeration)localObject).nextElement();
          if (Math.abs(l1 - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(str)).longValue()) <= 180000L) {
            continue;
          }
          ???.add(str);
        }
        ??? = finally;
        throw ???;
      }
      if (paramInt1 == 4) {
        synchronized (this.jdField_c_of_type_JavaUtilArrayList)
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(???);
          ??? = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
          ???.what = 991;
          this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
        }
      }
    }
    label334:
    paramInt1 = 0;
    while (paramInt1 < ???.size())
    {
      localObject = (String)???.get(paramInt1);
      this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if (paramInt == 0) {}
    Object localObject;
    QQMessageFacade.Message localMessage;
    label176:
    boolean bool;
    label485:
    ActivateFriendsManager localActivateFriendsManager;
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
                        localObject = a();
                      } while (localObject == null);
                      localMessage = ((QQMessageFacade)localObject).a();
                    } while (localMessage == null);
                    if ((1000 != localMessage.istroop) && (1020 != localMessage.istroop)) {
                      break;
                    }
                    if ((localMessage.frienduin == null) || (!localMessage.frienduin.equalsIgnoreCase(a()))) {
                      break label176;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("notification", 2, "receivedMsgNotification , stranger  self message");
                  return;
                  if ((localMessage.senderuin == null) || (!localMessage.senderuin.equalsIgnoreCase(a()))) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("notification", 2, "receivedMsgNotification ,self message");
                return;
                if ((!a(localMessage)) || (localMessage.needNotification())) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("notification", 2, "receivedMsgNotification , isTroopMark");
              return;
            } while (((1008 == localMessage.istroop) && (localMessage.senderuin != null) && (TroopBarAssistantManager.a().a(this, localMessage.senderuin, localMessage.istroop))) || (7100 == localMessage.istroop) || ((localMessage.istroop == 1008) && ((localMessage.extStr == null) || (((localMessage.extLong & 0x1) == 0) && (!localMessage.extStr.contains("lockDisplay"))) || (localMessage.extStr == null) || (((localMessage.extLong & 0x1) == 1) && (!localMessage.getExtInfoFromExtStr("lockDisplay").equals("true"))))));
            if ((!AppConstants.aZ.equals(localMessage.frienduin)) || (1008 != localMessage.istroop)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("notification", 2, "receivedMsgNotification, not show newKandian");
          return;
          if ((!AppConstants.ba.equals(localMessage.frienduin)) || (7220 != localMessage.istroop) || (ReadInJoyUtils.a(localMessage))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("notification", 2, "receivedMsgNotification, not show mergeKandian");
        return;
        if (!UserguideActivity.a(a(), a())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("notification", 2, "receivedMsgNotification , showUserGuide");
      return;
      if (QLog.isColorLevel())
      {
        if ((!this.isBackground_Pause) && (!this.isBackground_Stop)) {
          break;
        }
        bool = true;
        QLog.d("notification", 2, new Object[] { "receivedMsgNotification , isRunBackground :", Boolean.valueOf(bool), ",userActiveStatus:", Integer.valueOf(this.cq), ",needSoundVibrationsTip:", Boolean.valueOf(paramBoolean1), ",baseInfo:", localMessage.getBaseInfoString() });
      }
      if (GuardManager.a != null) {
        GuardManager.a.b(0, null);
      }
      bool = ((KeyguardManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      if (((!this.isBackground_Pause) && (!this.isBackground_Stop) && (!bool)) || ((localMessage.istroop != 6000) && (this.cq != 0) && ((localMessage.istroop != 1001) || (localMessage.msgtype != 62535)) && (localMessage.istroop != 1008) && (localMessage.istroop != 9002))) {
        break label866;
      }
      if (localMessage.istroop != 9002) {
        break label831;
      }
      localActivateFriendsManager = (ActivateFriendsManager)getManager(84);
    } while (!localActivateFriendsManager.a(localMessage.msgData));
    if (localActivateFriendsManager.b(localMessage.msgData)) {
      localMessage.counter += paramInt;
    }
    label732:
    OpenApiManager.a().a(localMessage);
    ((QQMessageFacade)localObject).c(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , frienduin " + localMessage.frienduin + ",type " + localMessage.istroop + ",counter:" + localMessage.counter);
    }
    a(localMessage, paramBoolean1, paramBoolean2);
    label831:
    label866:
    label1118:
    label1183:
    for (;;)
    {
      D();
      return;
      bool = false;
      break label485;
      if (localMessage.istroop == 7220)
      {
        localMessage.counter = 1;
        break label732;
      }
      localMessage.counter += paramInt;
      break label732;
      if ((localMessage.msgtype == 64523) || (localMessage.msgtype == 63506) || (localMessage.msgtype == 64489) || (localMessage.msgtype == 64517) || (localMessage.msgtype == 64518)) {
        break;
      }
      if ((localMessage.istroop == 1008) && (AppConstants.ae.equals(localMessage.senderuin)))
      {
        d(localMessage, paramBoolean2);
        return;
      }
      if ((paramBoolean1) && ((localMessage.istroop == 6000) || (this.cq == 0) || ((localMessage.istroop == 1001) && (localMessage.msgtype == 62535)) || (localMessage.istroop == 1008) || (localMessage.istroop == 9002)))
      {
        if (this.o) {
          break label1118;
        }
        d(localMessage, paramBoolean2);
      }
      for (;;)
      {
        if ((!paramBoolean1) || ((localMessage.istroop != 6000) && (this.cq != 0) && ((localMessage.istroop != 1001) || (localMessage.msgtype != 62535))) || (localMessage.istroop != 1001) || (localMessage.msgtype != 62535)) {
          break label1183;
        }
        OpenAppClient.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), localMessage.action);
        break;
        if ((this.jdField_c_of_type_ArrayOfLong[0] == localMessage.uniseq) && (this.jdField_c_of_type_ArrayOfLong[1] == 1L))
        {
          d(localMessage, paramBoolean2);
        }
        else
        {
          this.jdField_a_of_type_ArrayOfByte[0] = 1;
          localObject = this.jdField_a_of_type_ArrayOfByte;
          paramInt = i1;
          if (paramBoolean2) {
            paramInt = 1;
          }
          localObject[1] = ((byte)paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord)
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if (paramInt == 0) {}
    label50:
    label169:
    do
    {
      do
      {
        do
        {
          do
          {
            break label50;
            break label50;
            break label50;
            break label50;
            do
            {
              return;
            } while (paramMessageRecord == null);
            if ((1000 != paramMessageRecord.istroop) && (1020 != paramMessageRecord.istroop)) {
              break;
            }
            if ((paramMessageRecord.frienduin == null) || (!paramMessageRecord.frienduin.equalsIgnoreCase(a()))) {
              break label169;
            }
          } while (!QLog.isColorLevel());
          QLog.d("notification", 2, "receivedMsgNotification , stranger  self message");
          return;
          if ((paramMessageRecord.senderuin == null) || (!paramMessageRecord.senderuin.equalsIgnoreCase(a())) || (paramMessageRecord.msgtype == 61528)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("notification", 2, "receivedMsgNotification ,self message");
        return;
      } while (((paramMessageRecord.senderuin != null) && (1008 == paramMessageRecord.istroop) && (TroopBarAssistantManager.a().a(this, paramMessageRecord.senderuin, paramMessageRecord.istroop))) || (7100 == paramMessageRecord.istroop) || ((paramMessageRecord.istroop == 1008) && ((paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 0) && (!paramMessageRecord.extStr.contains("lockDisplay"))) || (paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 1) && (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true"))))) || ((String.valueOf(AppConstants.aZ).equals(paramMessageRecord.frienduin)) && (1008 == paramMessageRecord.istroop)) || ((String.valueOf(AppConstants.ba).equals(paramMessageRecord.frienduin)) && (7220 == paramMessageRecord.istroop) && (!ReadInJoyUtils.a(paramMessageRecord))));
      if (!UserguideActivity.a(a(), a())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("notification", 2, "receivedMsgNotification , showUserGuide");
    return;
    if (GuardManager.a != null) {
      GuardManager.a.b(0, null);
    }
    boolean bool = ((KeyguardManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    Object localObject = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "locking activity:" + ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName());
      }
      localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName();
      if ((((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) || (((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) || (((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        paramInt = 1;
      }
    }
    for (;;)
    {
      int i1 = i2;
      if (paramMessageRecord.msgtype == 63520)
      {
        i1 = i2;
        if (paramMessageRecord.istroop == 3000) {
          i1 = 1;
        }
      }
      if ((paramInt != 0) && (i1 != 0)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("notification", 2, "isBackground_Pause:" + this.isBackground_Pause);
        QLog.d("notification", 2, "isBackground_Stop:" + this.isBackground_Stop);
        QLog.d("notification", 2, "isScreenLocked:" + bool);
      }
      if (((!this.isBackground_Pause) && (!this.isBackground_Stop) && (!bool)) || ((paramMessageRecord.istroop != 6000) && (this.cq != 0) && ((paramMessageRecord.istroop != 1001) || (paramMessageRecord.msgtype != 62535)) && (paramMessageRecord.istroop != 1008))) {
        break;
      }
      a(paramMessageRecord, paramBoolean1, paramBoolean2);
      return;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong >= 0L) {
      this.jdField_b_of_type_Long = paramLong;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (e())
    {
      a().getSharedPreferences("acc_info" + getAccount(), 0).edit().putLong("getProfileStatusNew", paramLong).commit();
      this.jdField_d_of_type_Long = paramLong;
      if (paramBoolean) {
        m();
      }
    }
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public void a(Context paramContext, Class paramClass)
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
      } while (paramContext == null);
      if (paramClass != null) {
        break label238;
      }
      if (!(paramContext instanceof Activity)) {
        break;
      }
      paramClass = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramContext.getClass());
      paramContext = ((Activity)paramContext).getIntent().getExtras();
      if (paramContext != null)
      {
        paramContext.remove("single");
        paramContext.remove("selfuin");
        paramClass.putExtras(paramContext);
      }
      paramClass.putExtra("fromNotification", true);
      paramClass.addFlags(536870912).addFlags(67108864);
    } while (!e());
    Object localObject1 = a();
    Object localObject2 = null;
    Friends localFriends = ((FriendsManager)getManager(50)).c((String)localObject1);
    if (localFriends != null)
    {
      localObject2 = a(1, localFriends.uin, (byte)3, true, 0);
      paramContext = (Context)localObject2;
      if (localObject2 == null) {
        paramContext = ImageUtil.a();
      }
      if ((localFriends.name != null) && (localFriends.name.length() > 0))
      {
        localObject2 = localFriends.name;
        localObject1 = paramContext;
        paramContext = (Context)localObject2;
      }
    }
    for (;;)
    {
      a(paramClass, "", paramContext, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131367253), (Bitmap)localObject1, "CMD_IDLE_NOTIFIYCATION");
      return;
      paramClass = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), SplashActivity.class);
      break;
      label238:
      paramClass = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramClass);
      break;
      localObject2 = paramContext;
      paramContext = (Context)localObject1;
      localObject1 = localObject2;
      continue;
      paramContext = (Context)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_b_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    a(paramBusinessObserver, false);
  }
  
  public void a(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(paramBusinessObserver)) {
          this.jdField_b_of_type_JavaUtilList.add(paramBusinessObserver);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public void a(CallTabUnreadListener paramCallTabUnreadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener = paramCallTabUnreadListener;
  }
  
  public void a(CheckPttListener paramCheckPttListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener = paramCheckPttListener;
  }
  
  public void a(CheckPtvListener paramCheckPtvListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCheckPtvListener = paramCheckPtvListener;
  }
  
  public void a(MsgTabUnreadListener paramMsgTabUnreadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = paramMsgTabUnreadListener;
  }
  
  public void a(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {}
    while (this.jdField_d_of_type_JavaUtilList.indexOf(paramVibrateListener) >= 0) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.add(paramVibrateListener);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showReadedMsgNotification msgFacade.getMessages().size()" + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().size() + ",msgFacade.getCounter():" + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b());
    }
    if ((paramMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b() == 0))
    {
      j();
      return;
    }
    if (f())
    {
      a(paramMessage, false);
      return;
    }
    f(false);
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    o();
    this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a(paramResourcePluginListener);
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject3;
    Bitmap localBitmap;
    QQMessageFacade.Message localMessage;
    Intent localIntent;
    if ((1010 == paramMessageRecord.istroop) || (1001 == paramMessageRecord.istroop))
    {
      boolean bool = ((KeyguardManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      localObject1 = "";
      localObject2 = "";
      localObject3 = "";
      localBitmap = null;
      localMessage = new QQMessageFacade.Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
      if ((!this.isBackground_Pause) && (!this.isBackground_Stop) && (!bool)) {
        break label641;
      }
      localIntent = new Intent(a(), MsgBoxListActivity.class);
      localIntent.addFlags(335544320);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "OneWayMessageNotifyVibert mr.frienduin" + paramMessageRecord.frienduin + ", mr.istroop" + paramMessageRecord.istroop);
      }
      if (1010 != paramMessageRecord.istroop) {
        break label459;
      }
      localIntent.putExtra("uin", AppConstants.aH);
      localIntent.putExtra("uintype", paramMessageRecord.istroop);
      localIntent.setAction("com.tencent.mobileqq.action.CHAT");
      localIntent.putExtra("uinname", "");
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      if (paramMessageRecord.istroop != 1010) {
        break label497;
      }
      localBitmap = SkinUtils.a(a().getResources().getDrawable(2130840894));
      paramMessageRecord = BaseApplicationImpl.a().getString(2131372126);
      localObject2 = BaseApplicationImpl.a().getString(2131372127);
      localIntent.putExtra("key_notifycation_oneway_message", true);
      localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
      if (((String)localObject1).length() <= 0) {
        break label666;
      }
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length < 6) {
        break label666;
      }
      paramMessageRecord = localObject1[4];
      localObject2 = localObject1[5];
    }
    label356:
    label445:
    label459:
    label497:
    label608:
    label641:
    label660:
    label666:
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      localObject3 = localObject2;
      localObject2 = paramMessageRecord;
      for (;;)
      {
        a(localIntent, (String)localObject1, (String)localObject2, (String)localObject3, localBitmap, "CMD_SHOW_NOTIFIYCATION");
        if (QQUtils.a(a()))
        {
          paramMessageRecord = (QQLSRecentManager)getManager(71);
          if (SettingCloneUtil.readValue(a(), a(), a().getString(2131369618), "qqsetting_lock_screen_whenexit_key", true))
          {
            if (1001 != localMessage.istroop) {
              break label608;
            }
            paramMessageRecord.a(this, AppConstants.aM, localMessage.istroop, false);
          }
        }
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          d(localMessage, paramBoolean);
          return;
          if (1001 != paramMessageRecord.istroop) {
            break;
          }
          localIntent.putExtra("uin", AppConstants.ar);
          localIntent.putExtra("uintype", paramMessageRecord.istroop);
          break;
          if (paramMessageRecord.istroop != 1001) {
            break label356;
          }
          localBitmap = SkinUtils.a(a().getResources().getDrawable(2130838600));
          localObject2 = BaseApplicationImpl.a().getString(2131372128);
          localObject3 = BaseApplicationImpl.a().getString(2131372129);
          localIntent.putExtra("key_notifycation_oneway_message", true);
          paramMessageRecord = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
          if (paramMessageRecord.length() <= 0) {
            break label660;
          }
          paramMessageRecord = paramMessageRecord.split("\\|");
          if (paramMessageRecord.length < 6) {
            break label660;
          }
          localObject2 = paramMessageRecord[4];
          localObject3 = paramMessageRecord[5];
          localObject1 = localObject3;
          break label356;
          if (1010 != localMessage.istroop) {
            break label445;
          }
          paramMessageRecord.a(this, AppConstants.aN, localMessage.istroop, false);
          break label445;
        }
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          d(localMessage, paramBoolean);
          return;
        }
        localObject1 = localObject3;
      }
    }
  }
  
  public void a(Setting paramSetting)
  {
    if (paramSetting != null)
    {
      paramSetting = paramSetting.clone();
      if (paramSetting != null)
      {
        paramSetting.url = null;
        if (!TextUtils.isEmpty(paramSetting.uin)) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramSetting.uin, paramSetting);
        }
      }
    }
  }
  
  public void a(CallRedDotLightalkLis paramCallRedDotLightalkLis)
  {
    this.jdField_a_of_type_ComTencentMobileqqJumplightalkCallRedDotLightalkLis = paramCallRedDotLightalkLis;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.a(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.d(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.", 2, "deleteStrangerFace.id=" + paramString + ",idType=" + paramInt);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      a(32, paramString, paramInt);
      IPCFaceHelper localIPCFaceHelper = a().a(false);
      if (localIPCFaceHelper != null) {
        localIPCFaceHelper.a(32, paramString, paramInt);
      }
      paramString = new File(a(32, paramString, paramInt));
    } while ((paramString == null) || (!paramString.exists()));
    paramString.delete();
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l1;
    do
    {
      do
      {
        do
        {
          break label13;
          do
          {
            return;
          } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
          localObject = a(32, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l1 = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l1 == paramLong);
      Object localObject = (FriendListHandler)a(1);
      if (localObject != null) {
        ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshStrangerFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l1);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.", 2, "refreshStrangerFace.id=" + paramString + ",idType=" + paramInt + ",delLocalCache=" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      if (paramBoolean)
      {
        a(32, paramString, paramInt);
        localObject = new File(a(32, paramString, paramInt));
        if ((localObject != null) && (((File)localObject).exists())) {
          ((File)localObject).delete();
        }
      }
      localObject = (FriendListHandler)a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap);
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap, paramByte);
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null)
    {
      String str = RoamSettingController.a(paramString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "setTroopMsgFilterToServer, path=" + str + " value=" + paramInteger);
      }
      localRoamSettingController.a(str, paramInteger);
      TroopAssistantManager.a().c(this, paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.b(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    boolean bool1 = h();
    boolean bool2 = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool2);
    }
    if ((!bool1) && (bool2))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a());
      Vibrator localVibrator = (Vibrator)a().getSystemService("vibrator");
      bool1 = d();
      bool2 = y();
      boolean bool3 = x();
      boolean bool4 = m();
      boolean bool5 = u();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool3 + ",isVideoing is:" + bool1 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        localVibrator.vibrate(jdField_a_of_type_ArrayOfLong, -1);
      }
      if ((paramBoolean) && (bool2) && (!bool1) && (!k()) && (!l()) && (m()) && (u()))
      {
        int i1 = localSharedPreferences.getInt("sound_type" + a(), 2131165190);
        if (c(paramString)) {
          i1 = 2131165214;
        }
        AudioUtil.b(i1, false);
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    C();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    int i1 = 0;
    label15:
    TagInfo localTagInfo1;
    TagArrayByType localTagArrayByType;
    int i2;
    if (i1 < paramArrayList.size())
    {
      localTagInfo1 = (TagInfo)paramArrayList.get(i1);
      if ((localTagInfo1 != null) && ((localTagInfo1.strContent == null) || ("".equals(localTagInfo1.strContent.trim()))))
      {
        localTagArrayByType = null;
        i2 = 0;
        label66:
        if (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label262;
        }
        localTagArrayByType = (TagArrayByType)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        if (localTagInfo1.bType != ((TagInfo)localTagArrayByType.mTags.get(0)).bType) {
          break label232;
        }
      }
    }
    label119:
    label232:
    label262:
    for (;;)
    {
      int i3;
      if (localTagArrayByType == null)
      {
        i2 = 0;
        i3 = 0;
      }
      for (;;)
      {
        if (i3 < i2)
        {
          TagInfo localTagInfo2 = (TagInfo)localTagArrayByType.mTags.get(i3);
          if ((localTagInfo2 != null) && (localTagInfo2.iTagId == localTagInfo1.iTagId)) {
            localTagInfo1.strContent = localTagInfo2.strContent;
          }
        }
        else
        {
          if ((localTagInfo1 != null) && (QLog.isColorLevel())) {
            QLog.d("ProfileService.SetUserInfoReq", 2, "id = " + localTagInfo1.iTagId + ", strContent = " + localTagInfo1.strContent);
          }
          i1 += 1;
          break label15;
          break;
          i2 += 1;
          break label66;
          i2 = localTagArrayByType.mTags.size();
          break label119;
        }
        i3 += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 0;
    if (paramBoolean)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int i3 = arrayOfInt.length;
      i1 = i2;
      while (i1 < i3)
      {
        getManager(arrayOfInt[i1]);
        i1 += 1;
      }
    }
    while (i1 < 183)
    {
      if ((i1 != 23) && (i1 != 125)) {
        getManager(i1);
      }
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener.a(paramBoolean, paramInt);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((CardHandler)a(2)).a(paramBoolean1);
      return;
    }
    a().edit().putBoolean(a().getString(2131367842) + a(), paramBoolean1).commit();
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo = new SigInfo();
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey, 0, paramArrayOfByte1.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature = new byte[paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte2, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature, 0, paramArrayOfByte2.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.wSignatureLen = ((short)this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature.length);
    }
  }
  
  public void a(Integer[] paramArrayOfInteger)
  {
    a(paramArrayOfInteger, true);
  }
  
  public void a(Integer[] paramArrayOfInteger, boolean paramBoolean)
  {
    Object localObject2 = SettingCloneUtil.readValue(getApplication(), a(), null, "qqsetting_calltab_show_key", "0111100");
    if ((localObject2 == null) || (((String)localObject2).length() > "0111100".length()) || (paramArrayOfInteger == null) || (paramArrayOfInteger.length != 7))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "writeCallTabStateVal valid val," + (String)localObject2 + "," + paramArrayOfInteger);
      }
      return;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).length() < "0111100".length()) {
      localObject1 = (String)localObject2 + "0111100".substring(((String)localObject2).length());
    }
    localObject1 = new StringBuilder((String)localObject1);
    int i1 = 0;
    label154:
    if (i1 < paramArrayOfInteger.length)
    {
      localObject2 = paramArrayOfInteger[i1];
      if (localObject2 == null) {}
      for (;;)
      {
        i1 += 1;
        break label154;
        if ((((Integer)localObject2).intValue() < 0) || (((Integer)localObject2).intValue() > 9))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "writeCallTabStateVal wrong index,," + localObject2);
          return;
        }
        ((StringBuilder)localObject1).setCharAt(i1, (char)(((Integer)localObject2).intValue() + 48));
      }
    }
    if (paramArrayOfInteger[0] != null)
    {
      if (((StringBuilder)localObject1).charAt(4) != '0') {
        break label553;
      }
      i1 = 0;
      label271:
      this.eu = i1;
      if (this.eu != 0) {
        break label559;
      }
    }
    label553:
    label559:
    for (boolean bool = false;; bool = true)
    {
      this.m = bool;
      if ((this.m) && ((a().a == '2') || (a().a == '3')))
      {
        localObject2 = new Integer[5];
        localObject2[0] = Integer.valueOf(1);
        localObject2[3] = Integer.valueOf(0);
        a().a((Integer[])localObject2, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "uin:" + a() + ",writeCallTabStateVal vals=" + paramArrayOfInteger + ",mIsCallTabShow=" + this.eu + ",isCallTabShow=" + this.m);
      }
      SettingCloneUtil.writeValue(getApplication(), a(), null, "qqsetting_calltab_show_key", ((StringBuilder)localObject1).toString());
      localObject1 = a().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + a(), "00000");
      i1 = ((String)localObject1).charAt(2);
      if ((!paramBoolean) || (((String)localObject1).charAt(0) != '0') || (paramArrayOfInteger[0] == null) || ((i1 != 50) && (i1 != 51))) {
        break;
      }
      paramArrayOfInteger = new Integer[5];
      paramArrayOfInteger[0] = Integer.valueOf(1);
      a().a(paramArrayOfInteger, false);
      return;
      i1 = 1;
      break label271;
    }
  }
  
  public boolean a()
  {
    return isLogin();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] != null;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    byte b1 = 3;
    if (paramInt1 == 101) {
      b1 = 1;
    }
    String str = a(paramInt1, paramString, b1, paramInt2);
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str) != null) {}
    do
    {
      return true;
      paramString = new File(a(paramInt1, paramString, paramInt2));
    } while ((paramString.exists()) && (paramString.isFile()));
    return false;
  }
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    return a(paramMessage.frienduin, paramMessage.istroop);
  }
  
  @Deprecated
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences(a(), 0).getLong(a() + paramString, 1L) == 1L) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = b(paramString);
      if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getAllGeneralSettings , needTroopSettings=" + paramBoolean);
      }
      localRoamSettingController.a(paramBoolean, null);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAllGeneralSettings roamSettingController is null ");
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1)
    {
      i1 = this.en;
      this.en = (i1 + 1);
      if (i1 < 3) {}
    }
    do
    {
      return false;
      i1 = this.eo;
      this.eo = (i1 + 1);
    } while (i1 >= 3);
    ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public byte[] a()
  {
    if ((getAccount() != null) && (isLogin()) && (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey;
    }
    return null;
  }
  
  public String[] a()
  {
    Object localObject = a(-1);
    String[] arrayOfString1 = (String[])((HashMap)localObject).get(Integer.valueOf(1));
    String[] arrayOfString2 = (String[])((HashMap)localObject).get(Integer.valueOf(4));
    localObject = (String[])((HashMap)localObject).get(Integer.valueOf(2));
    if (arrayOfString1 != null) {}
    for (int i2 = arrayOfString1.length + 0;; i2 = 0)
    {
      int i1 = i2;
      if (arrayOfString2 != null) {
        i1 = i2 + arrayOfString2.length;
      }
      i2 = i1;
      if (localObject != null) {
        i2 = i1 + localObject.length;
      }
      String[] arrayOfString3;
      if (i2 > 0)
      {
        arrayOfString3 = new String[i2];
        if (arrayOfString1 == null) {
          break label150;
        }
        System.arraycopy(arrayOfString1, 0, arrayOfString3, 0, arrayOfString1.length);
      }
      label150:
      for (i1 = arrayOfString1.length;; i1 = 0)
      {
        if (arrayOfString2 != null)
        {
          System.arraycopy(arrayOfString2, 0, arrayOfString3, 0, arrayOfString2.length);
          i1 = arrayOfString2.length;
        }
        if (localObject != null) {
          System.arraycopy(localObject, 0, arrayOfString3, i1, localObject.length);
        }
        return arrayOfString3;
        return null;
      }
    }
  }
  
  public String[] a(int paramInt)
  {
    return (String[])a(paramInt).get(Integer.valueOf(paramInt));
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] != null) {
      return;
    }
    this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] = paramManager;
  }
  
  public int b()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.group.ring", 0);
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    localObject = a((List)localObject);
    if (localObject != null)
    {
      paramString = (Integer)((Map)localObject).get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return 1;
  }
  
  public Bitmap b(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), 2130843345);
      if (localBitmap != null) {
        new Canvas(paramBitmap).drawBitmap(localBitmap, paramBitmap.getWidth() - localBitmap.getWidth() - 1, paramBitmap.getHeight() - localBitmap.getHeight() - 1, new Paint());
      }
      return paramBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        Object localObject1 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public Bitmap b(String paramString, int paramInt)
  {
    return a(16, paramString, true, paramInt);
  }
  
  public Drawable b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  @Deprecated
  public Drawable b(String paramString)
  {
    return a(paramString, false, (byte)3);
  }
  
  public SQLiteDatabase b()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.b();
    }
    return null;
  }
  
  public SQLiteDatabase b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.b();
    }
    return null;
  }
  
  public Config b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigConfig == null) {
      a(paramString);
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigConfig;
  }
  
  public Setting b(String paramString)
  {
    return (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, paramString);
  }
  
  public String b()
  {
    return ContactUtils.k(this, a());
  }
  
  public String b(String paramString)
  {
    String str = getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString);
    if ((str == null) || (str.length() == 0)) {
      return paramString;
    }
    return str;
  }
  
  public void b()
  {
    int i1 = 0;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, new Setting().getTableName(), false, null, null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      while (i1 < ((List)localObject).size())
      {
        Setting localSetting = (Setting)((List)localObject).get(i1);
        if (localSetting != null)
        {
          localSetting.url = null;
          if (!TextUtils.isEmpty(localSetting.uin)) {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localSetting.uin, localSetting);
          }
        }
        i1 += 1;
      }
    }
    this.n = true;
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.qqhead.getheadreq");
    a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void b(int paramInt)
  {
    a(new qed(this, paramInt));
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramBusinessObserver);
      }
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramBusinessObserver);
      return;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
    }
  }
  
  public void b(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.remove(paramVibrateListener);
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    M();
    this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a(paramResourcePluginListener);
  }
  
  public void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.i + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessageRecord);
    }
    if ((this.i) || (!bool)) {}
    QCallFacade localQCallFacade;
    do
    {
      return;
      localQCallFacade = (QCallFacade)getManager(37);
    } while (localQCallFacade == null);
    Object localObject4 = paramMessageRecord.senderuin;
    if ((paramMessageRecord.msgtype == 63520) || (paramMessageRecord.msgtype == 61528)) {
      localObject4 = localQCallFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop).senderUin;
    }
    for (;;)
    {
      int i1 = localQCallFacade.c();
      if (i1 == 0) {
        break;
      }
      Intent localIntent;
      if (i1 == 1) {
        if (((paramMessageRecord.msgtype == 63520) || (paramMessageRecord.msgtype == 61528)) && (paramMessageRecord.istroop == 3000))
        {
          localIntent = a(a(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
          localObject1 = (DiscussionHandler)a(6);
          if (localObject1 == null) {
            break label1722;
          }
        }
      }
      label429:
      label460:
      label540:
      label577:
      label649:
      label820:
      label1464:
      label1501:
      label1550:
      label1656:
      label1710:
      label1722:
      for (Object localObject1 = ((DiscussionHandler)localObject1).a(paramMessageRecord.frienduin, true);; localObject1 = null)
      {
        Object localObject3 = ContactUtils.a(this, (String)localObject4, 0);
        bool = true;
        Object localObject5;
        Object localObject2;
        Object localObject6;
        int i2;
        for (;;)
        {
          localIntent.putExtra("key_notification_click_action", true);
          localObject5 = localIntent.getStringExtra("uinname");
          if (localObject5 != null)
          {
            localObject2 = localObject5;
            if (!"".equals(localObject5)) {}
          }
          else
          {
            localObject2 = localIntent.getStringExtra("uin");
          }
          if (localObject3 != null)
          {
            localObject5 = localObject3;
            if (!"".equals(localObject3)) {}
          }
          else
          {
            localObject5 = localObject4;
          }
          localObject5 = localQCallFacade.a((String)localObject5, bool);
          switch (paramMessageRecord.istroop)
          {
          default: 
            localObject6 = (String)localObject2 + ": ";
            localObject3 = localObject5;
            localObject4 = localObject1;
            localObject1 = localObject6;
            if (paramMessageRecord.istroop != 1008) {
              break label1464;
            }
            localObject6 = (String)localObject1 + (String)localObject3;
            if (!paramBoolean) {
              localObject6 = null;
            }
            i2 = localQCallFacade.b();
            localObject1 = localObject2;
            if (i2 > 1)
            {
              localObject1 = localObject2;
              if (i1 == 1)
              {
                if (i2 <= 100) {
                  break label1501;
                }
                localObject1 = (String)localObject2 + " (" + a().getString(2131370060) + ")";
              }
            }
            if ((paramBoolean) && (paramMessageRecord.istroop != 6000) && (paramMessageRecord.istroop != 1009) && (!paramMessageRecord.frienduin.equals(AppConstants.an))) {
              break label1550;
            }
            if ((paramMessageRecord.msgtype != 63520) && (paramMessageRecord.msgtype != 61528)) {
              break label1656;
            }
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "AVNotify:MSG_TYPE_MULTI_VIDEO");
            }
            if (paramMessageRecord.istroop == 3000)
            {
              if (QLog.isColorLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 2, "AVNotify:UIN_TYPE_DISCUSSION");
              }
              localIntent.putExtra("qav_notify_flag", true);
            }
            a(localIntent, (String)localObject6, (String)localObject1, (String)localObject3, (Bitmap)localObject4, "CMD_SHOW_NOTIFIYCATION");
            return;
            if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
            {
              localIntent = new Intent(a(), SplashActivity.class);
              localIntent.putExtra("tab_index", MainFragment.a);
              localIntent.putExtra("conversation_index", 1);
              localIntent.setFlags(335544320);
              localIntent.putExtra("uinname", a(paramMessageRecord.frienduin, (String)localObject4, paramMessageRecord.istroop, true));
            }
            for (;;)
            {
              if (!AppConstants.av.equals(paramMessageRecord.frienduin)) {
                break label820;
              }
              localObject1 = a((String)localObject4, true);
              bool = false;
              localObject3 = "";
              break;
              localIntent = a(a(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
            }
            if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 1010))
            {
              localObject1 = a(paramMessageRecord.frienduin, 200);
              bool = false;
              localObject3 = "";
            }
            else
            {
              localObject1 = a(paramMessageRecord.frienduin, true);
              bool = false;
              localObject3 = "";
            }
            break;
          }
        }
        if (((paramMessageRecord.msgtype == 63520) || (paramMessageRecord.msgtype == 61528)) && (paramMessageRecord.istroop == 3000)) {}
        for (bool = true;; bool = false)
        {
          localIntent = new Intent(a(), SplashActivity.class);
          localIntent.putExtra("tab_index", MainFragment.a);
          localIntent.putExtra("conversation_index", 1);
          localIntent.setFlags(335544320);
          localIntent.putExtra("uinname", a().getString(2131370056));
          localObject1 = null;
          localObject3 = "";
          break;
          localObject3 = ContactUtils.a(this, (String)localObject4, 0);
          localObject6 = (String)localObject3 + "(" + (String)localObject2 + ")" + ":";
          localObject3 = localObject5;
          localObject4 = localObject1;
          localObject1 = localObject6;
          break label429;
          localObject3 = localIntent.getStringExtra("subAccountLatestNick");
          localObject1 = localObject4;
          if (localObject3 != null) {
            if (((String)localObject3).length() != 0) {
              break label1710;
            }
          }
          for (localObject1 = localObject4;; localObject1 = localObject3)
          {
            localObject4 = (String)localObject2 + "-" + (String)localObject1 + ":" + (String)localObject5;
            localObject3 = (String)localObject1 + ":" + (String)localObject5;
            localObject1 = localObject4;
            localObject4 = null;
            break;
            localObject6 = (String)localObject2 + ": ";
            localObject3 = localObject5;
            localObject4 = localObject1;
            localObject1 = localObject6;
            break;
            if (i1 > 1)
            {
              localObject6 = (String)localObject2 + ": ";
              localObject3 = localObject5;
              localObject4 = localObject1;
              localObject1 = localObject6;
              break;
            }
            localObject3 = ContactUtils.o(this, paramMessageRecord.frienduin);
            localObject6 = (String)localObject3 + "(" + (String)localObject2 + ")" + ":";
            localObject3 = (String)localObject3 + ": " + (String)localObject5;
            localObject4 = localObject1;
            localObject1 = localObject6;
            break;
            localObject3 = SkinUtils.a(a().getResources().getDrawable(2130838602));
            localObject4 = XMLMessageUtils.a(paramMessageRecord);
            if ((localObject4 != null) && (!((PAMessage)localObject4).items.isEmpty()))
            {
              localObject1 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
              if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList != null))
              {
                localObject4 = (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
                localObject2 = localObject1;
                localObject1 = localObject4;
              }
              for (;;)
              {
                localObject4 = localObject3;
                localObject3 = localObject1;
                localObject1 = "";
                break;
              }
              localObject6 = localObject1;
              if (paramMessageRecord.istroop == 7000) {
                break label460;
              }
              localObject6 = (String)localObject1 + (String)localObject5;
              break label460;
              localObject1 = (String)localObject2 + " (" + i2 + a().getString(2131368857) + ")";
              break label540;
              if (!QQUtils.a(a())) {
                break label577;
              }
              localObject2 = (QQLSRecentManager)getManager(71);
              if (!SettingCloneUtil.readValue(a(), a(), a().getString(2131369618), "qqsetting_lock_screen_whenexit_key", true)) {
                break label577;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  showInComingMsgForQAV");
              }
              if (bool)
              {
                ((QQLSRecentManager)localObject2).a(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, true);
                break label577;
              }
              ((QQLSRecentManager)localObject2).a(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, false);
              break label577;
              if (paramMessageRecord.msgtype != 63527) {
                break label649;
              }
              if (QLog.isColorLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO");
              }
              localIntent.putExtra("qav_notify_flag", true);
              break label649;
            }
            localObject1 = "";
            localObject4 = localObject3;
            localObject3 = localObject5;
            break;
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIfNeedSignonNet onNetNeedSignon() called url:" + paramString);
    }
    MqqHandler localMqqHandler = a(Conversation.class);
    if (localMqqHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramString;
      localMessage.arg1 = 2;
      localMessage.what = 1134024;
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.qaif", 2, "deleteQCallFace id=" + paramString + ", idtype =" + paramInt);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      a(16, paramString, paramInt);
      paramString = new File(a(16, paramString, paramInt));
    } while ((paramString == null) || (!paramString.exists()));
    paramString.delete();
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l1;
    do
    {
      do
      {
        do
        {
          break label13;
          do
          {
            return;
          } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
          localObject = a(16, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l1 = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l1 == paramLong);
      Object localObject = (FriendListHandler)a(1);
      if (localObject != null) {
        ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshQCallFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l1);
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.qaif", 2, "refreshQCallFace id=" + paramString + ", idtype =" + paramInt + ", delLocalCache =" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      if (paramBoolean)
      {
        a(16, paramString, paramInt);
        localObject = new File(a(16, paramString, paramInt));
        if ((localObject != null) && (((File)localObject).exists())) {
          ((File)localObject).delete();
        }
      }
      localObject = (FriendListHandler)a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).b(paramString, paramInt, (byte)1, (byte)0);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.a(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("exit", 2, a() + " qq start to exit ");
    }
    L();
    StatisticHitRateCollector.a().d(a());
    PreloadProcHitMgr.a();
    K();
    if (isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "kickPC get value in exit........... kickpc = false");
      }
      if (this.jdField_a_of_type_Boolean)
      {
        sendOnlineStatus(AppRuntime.Status.receiveofflinemsg, false, 0L);
        ((PushManager)getManager(5)).unregistProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video");
      }
    }
    else
    {
      if (GuardManager.a != null) {
        GuardManager.a.a();
      }
      if (!paramBoolean) {
        break label223;
      }
      localMobileQQ = getApplication();
      if (isLogin()) {
        break label218;
      }
    }
    label218:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localMobileQQ.QQProcessExit(paramBoolean);
      i();
      SharedPreferencesProxyManager.getInstance().trySave();
      HeavyTaskExecutor.a();
      return;
      if (paramBoolean)
      {
        sendOnlineStatus(AppRuntime.Status.offline, false, 0L);
        break;
      }
      sendOnlineStatus(AppRuntime.Status.offline, true, 0L);
      break;
    }
    label223:
    MobileQQ localMobileQQ = getApplication();
    if (!this.jdField_a_of_type_Boolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localMobileQQ.QQProcessExit(paramBoolean);
      break;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a().edit().putBoolean(a().getString(2131367840) + a(), paramBoolean1).commit();
      return;
    }
    ((LBSHandler)a(3)).b(paramBoolean1);
  }
  
  public boolean b()
  {
    boolean bool = false;
    try
    {
      String str = a().getString(2131370224);
      if (str != null) {
        bool = SettingCloneUtil.readValue(a(), null, str, "qqsetting_notify_icon_key", false);
      }
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = a().k(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean b(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((CardHandler)a(2)).b();
    }
    return a().getBoolean(a().getString(2131367842) + a(), true);
  }
  
  public int c()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.group.vibrate", 0);
    }
    return 0;
  }
  
  public Setting c(String paramString)
  {
    return (Setting)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String c()
  {
    Object localObject3 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    for (Object localObject2 = ((SharedPreferences)localObject1).getString("serverlist_wifi", null);; localObject2 = ((SharedPreferences)localObject1).getString("serverlist_2g3g", null))
    {
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((String)localObject2).split(",");
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = localObject2[((int)(Math.random() * localObject2.length))];
        }
      }
      return (String)localObject1;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMessageConnect...");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator == null) || (!e())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b();
    }
    d();
    a().a();
    a().a();
    for (;;)
    {
      Object localObject3;
      HashMap localHashMap;
      try
      {
        Object localObject1 = g();
        Object localObject2 = BaseApplication.getContext().getSharedPreferences("pull_msf" + (String)localObject1, 0);
        String str = ((SharedPreferences)localObject2).getString("uin", " ");
        localObject3 = ((SharedPreferences)localObject2).getString("time", "0");
        if ((!str.equals(" ")) && (!((String)localObject3).equals("0")))
        {
          if ((BaseApplicationImpl.jdField_a_of_type_Long < 0L) && (BaseApplicationImpl.jdField_b_of_type_Long < 0L)) {
            RegisterProxy.k |= 0x4;
          }
          localHashMap = new HashMap();
          localHashMap.put("uin", str);
          localHashMap.put("time", localObject3);
          localHashMap.put("process", ((SharedPreferences)localObject2).getString("process", ""));
          localHashMap.put("availMem", ((SharedPreferences)localObject2).getString("availMem", ""));
          localHashMap.put("lowMem", ((SharedPreferences)localObject2).getString("lowMem", ""));
          localHashMap.put("state", ((SharedPreferences)localObject2).getString("state", ""));
          localHashMap.put("version", "150806");
          if (Build.VERSION.SDK_INT >= 21)
          {
            StatisticCollector.a(BaseApplicationImpl.getContext()).a(a(), "pullMsfReport_V3", false, 0L, 0L, localHashMap, "");
            localObject2 = ((SharedPreferences)localObject2).edit();
            ((SharedPreferences.Editor)localObject2).clear();
            ((SharedPreferences.Editor)localObject2).commit();
          }
        }
        else
        {
          localObject1 = BaseApplication.getContext().getSharedPreferences("pull_msf_succ" + (String)localObject1, 0);
          localObject2 = ((SharedPreferences)localObject1).getString("uin", " ");
          str = ((SharedPreferences)localObject1).getString("time", "0");
          if ((((String)localObject2).equals(" ")) || (str.equals("0"))) {
            break;
          }
          if ((a(this)) && (BaseApplicationImpl.jdField_a_of_type_Long < 0L) && (BaseApplicationImpl.jdField_b_of_type_Long < 0L)) {
            RegisterProxy.k |= 0x2;
          }
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("uin", localObject2);
          ((HashMap)localObject3).put("time", str);
          ((HashMap)localObject3).put("process", ((SharedPreferences)localObject1).getString("process", ""));
          ((HashMap)localObject3).put("availMem", ((SharedPreferences)localObject1).getString("availMem", ""));
          ((HashMap)localObject3).put("lowMem", ((SharedPreferences)localObject1).getString("lowMem", ""));
          ((HashMap)localObject3).put("state", ((SharedPreferences)localObject1).getString("state", ""));
          ((HashMap)localObject3).put("version", "150806");
          if (Build.VERSION.SDK_INT < 21) {
            break label670;
          }
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(a(), "pullMsfReport_succ_V2", false, 0L, 0L, (HashMap)localObject3, "");
          localObject1 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject1).clear();
          ((SharedPreferences.Editor)localObject1).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "Failed to report pull Msf Event");
        return;
      }
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(a(), "pullMsfReportOther_V3", false, 0L, 0L, localHashMap, "");
      continue;
      label670:
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(a(), "pullMsfReport_succOther_V2", false, 0L, 0L, (HashMap)localObject3, "");
    }
  }
  
  public void c(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.group.ring", Integer.valueOf(paramInt));
    }
  }
  
  public void c(BusinessObserver paramBusinessObserver)
  {
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      if (!this.jdField_c_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_c_of_type_JavaUtilList.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public void c(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.b(paramResourcePluginListener);
    }
  }
  
  public void c(String paramString)
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.d(paramString);
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).d(paramBoolean1);
      return;
    }
    a().edit().putBoolean(a().getString(2131371513) + a(), paramBoolean1).commit();
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(a(), a(), "login_accounts", "qqsetting_bothonline_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "kickPC get value........... kickpc = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public final boolean c(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).d();
    }
    return a().getBoolean(a().getString(2131371513) + a(), true);
  }
  
  protected boolean canAutoLogin(String paramString)
  {
    return SharedPreUtils.a(getApplication().getApplicationContext(), paramString);
  }
  
  public int d()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.ring.switch", 1);
    }
    return 1;
  }
  
  @Deprecated
  public String d()
  {
    return null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnOpenAndStartGetMsg");
    }
    LoadingStateManager.a().a(1);
    MqqHandler localMqqHandler = a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void d(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.group.vibrate", Integer.valueOf(paramInt));
    }
  }
  
  public void d(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig != null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.b(paramResourcePluginListener);
    }
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    FriendListHandler localFriendListHandler;
    do
    {
      return;
      localFriendListHandler = (FriendListHandler)a(1);
    } while (localFriendListHandler == null);
    if (paramString.startsWith("+"))
    {
      localFriendListHandler.e(paramString);
      return;
    }
    localFriendListHandler.c(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.en = 1;
    }
    for (;;)
    {
      ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
      return;
      this.eo = 1;
    }
  }
  
  public boolean d()
  {
    if (a().a().b != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoProcessAlive mPstnStatus != PstnUtils.PSTN_C2C_NONE");
      }
      return true;
    }
    a();
    if (AVNotifyCenter.c()) {
      return true;
    }
    if ((!a().d()) && (a().b() == 0)) {
      return false;
    }
    if (QQServiceForAV.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoProcessAlive");
      }
      return true;
    }
    Object localObject = ((ActivityManager)a().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video"))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoProcessAlive VIDEO_PROCESS_NAME");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean d(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).a(a(), 1);
    }
    return a().getBoolean(a().getString(2131371899) + a(), false);
  }
  
  public int e()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.vibrate.switch", 1);
    }
    return 1;
  }
  
  public String e()
  {
    String str = d();
    if (str != null) {
      try
      {
        str = HexUtil.a(str.getBytes("utf-8"));
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return null;
  }
  
  public void e()
  {
    BaseApplicationImpl.jdField_a_of_type_MqqOsMqqHandler.post(new qek(this));
  }
  
  public void e(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.ring.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putBoolean(BaseApplication.getContext().getString(2131367791) + a(), paramBoolean);
    localEditor.commit();
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).a(paramBoolean1, a(), 1);
      return;
    }
    a().edit().putBoolean(a().getString(2131371899) + a(), paramBoolean1).commit();
  }
  
  public boolean e()
  {
    return (getAccount() != null) && (isLogin());
  }
  
  public boolean e(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).a(a(), 2);
    }
    return a().getBoolean(a().getString(2131371900) + a(), false);
  }
  
  public int f()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("sync.c2c_message", 1);
    }
    return 1;
  }
  
  public String f()
  {
    String str = "";
    if (!"0".equals(a())) {
      str = a();
    }
    return str;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnClose");
    }
    this.jdField_e_of_type_Boolean = false;
    LoadingStateManager.a().a(1);
    MqqHandler localMqqHandler = a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void f(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.vibrate.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).a(paramBoolean1, a(), 2);
      return;
    }
    a().edit().putBoolean(a().getString(2131371900) + a(), paramBoolean1).commit();
  }
  
  public boolean f()
  {
    return SettingCloneUtil.readValue(a(), a(), a().getString(2131368465), "qqsetting_notify_showcontent_key", true);
  }
  
  public boolean f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() isFromPush=" + paramBoolean);
    }
    Object localObject1 = null;
    Object localObject2 = (SubAccountManager)getManager(60);
    if (localObject2 != null) {
      localObject1 = ((SubAccountManager)localObject2).a();
    }
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((String)localObject2).length() > 4))
        {
          bool1 = true;
          SubAccountControll.a(this, (String)localObject2, paramBoolean);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() continue, subUin=" + (String)localObject2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() listSubUin==null");
    }
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() result=" + bool2 + " forground=" + BaseActivity.mAppForground);
    }
    localObject1 = (SubAccountControll)getManager(61);
    if (localObject1 != null)
    {
      if (!bool2) {
        break label248;
      }
      if (BaseActivity.mAppForground) {
        ((SubAccountControll)localObject1).b(this);
      }
    }
    return bool2;
    label248:
    ((SubAccountControll)localObject1).c(this);
    return bool2;
  }
  
  protected void finalize()
  {
    super.finalize();
    QQEntityManagerFactory localQQEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    if (localQQEntityManagerFactory != null) {
      localQQEntityManagerFactory.close();
    }
  }
  
  public int g()
  {
    int i1 = 0;
    int i2 = 0;
    QQMessageFacade localQQMessageFacade = a();
    if (localQQMessageFacade != null)
    {
      QCallFacade localQCallFacade = a();
      i1 = i2;
      if (localQCallFacade != null)
      {
        i1 = i2;
        if (!a().j())
        {
          i2 = localQCallFacade.a();
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "callUnread: " + i2);
            i1 = i2;
          }
        }
      }
      i2 = localQQMessageFacade.e();
      i1 = ((NewFriendManager)getManager(33)).b() + (i2 + i1);
    }
    return i1;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvFistResp");
    }
    this.jdField_e_of_type_Boolean = true;
    MqqHandler localMqqHandler = a(Conversation.class);
    if (!LoadingStateManager.a().d())
    {
      LoadingStateManager.a().a(2);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(1134012, null).sendToTarget();
      }
    }
    for (;;)
    {
      if (localMqqHandler != null)
      {
        Message localMessage = Message.obtain();
        localMessage.arg1 = 0;
        localMessage.what = 1134024;
        localMqqHandler.sendMessage(localMessage);
      }
      return;
      if ((LoadingStateManager.a().b()) && (localMqqHandler != null)) {
        localMqqHandler.obtainMessage(1134015, null).sendToTarget();
      }
    }
  }
  
  public void g(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("sync.c2c_message", Integer.valueOf(paramInt));
    }
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean g()
  {
    if (y())
    {
      Object localObject = ThemeUtil.getUserCurrentThemeId(this);
      if ((localObject != null) && (!((String)localObject).equals("1000")))
      {
        localObject = ThemeUtil.getThemeInfo(getApplication(), (String)localObject);
        if ((localObject != null) && (((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Manager getManager(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
    ??? = ???;
    if (??? == null)
    {
      if (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] == null) {}
      synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
      {
        if (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] == null)
        {
          int i1 = 0;
          while (i1 < this.jdField_a_of_type_ArrayOfJavaLangObject.length)
          {
            this.jdField_a_of_type_ArrayOfJavaLangObject[i1] = new Object();
            i1 += 1;
          }
        }
        if (!AppSetting.g) {}
      }
    }
    for (;;)
    {
      Manager[] arrayOfManager;
      synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt])
      {
        Manager localManager = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
        if ((localManager != null) || ((getAccount() == null) && (paramInt > 7) && (paramInt != 26)))
        {
          ??? = localManager;
          return (Manager)???;
          localObject5 = finally;
          throw ((Throwable)localObject5);
          arrayOfManager = this.jdField_a_of_type_ArrayOfMqqManagerManager;
          continue;
        }
        ??? = localManager;
        switch (paramInt)
        {
        default: 
          ??? = localManager;
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 24: 
        case 25: 
        case 29: 
        case 49: 
        case 74: 
        case 86: 
        case 96: 
        case 98: 
        case 99: 
        case 109: 
        case 110: 
        case 121: 
        case 135: 
        case 156: 
          if (??? != null) {
            addManager(paramInt, (Manager)???);
          }
          return (Manager)???;
        case 0: 
          ??? = new AccountManagerImpl(this);
        }
      }
      Object localObject3 = new WtloginManagerImpl(this);
      continue;
      localObject3 = new TicketManagerImpl(this);
      continue;
      localObject3 = new ProxyIpManagerImpl(this);
      continue;
      localObject3 = new QZoneManagerImp(this);
      continue;
      localObject3 = new PhoneContactManagerImp(this);
      continue;
      localObject3 = new GameCenterManagerImp(this);
      continue;
      localObject3 = new WebProcessManager(this);
      continue;
      localObject3 = new EmoticonManager(this);
      continue;
      localObject3 = StatusManager.a(this);
      continue;
      localObject3 = new ShieldMsgManger(this);
      continue;
      localObject3 = new SttManager(this);
      continue;
      localObject3 = new ProxyManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)localObject3);
      continue;
      localObject3 = new CacheManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager = ((CacheManager)localObject3);
      continue;
      localObject3 = new QQMessageFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)localObject3);
      continue;
      localObject3 = new NetEngineFactory();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)localObject3);
      continue;
      localObject3 = new RecommendTroopManagerImp(this);
      continue;
      localObject3 = new FileTransferManager(this);
      continue;
      localObject3 = new MediaPlayerManager(this);
      continue;
      localObject3 = IPluginManager.a(this);
      continue;
      localObject3 = new SubAccountProtocManager(this);
      continue;
      localObject3 = new ConversationFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = ((ConversationFacade)localObject3);
      continue;
      localObject3 = new RoamSettingController(this);
      continue;
      localObject3 = new TroopCreateLogic(this);
      continue;
      localObject3 = new RecentManagerFor3rdPart(this);
      continue;
      localObject3 = new NewFriendManager(this);
      continue;
      localObject3 = new CircleManager(this);
      continue;
      localObject3 = new RedTouchManager(this);
      continue;
      localObject3 = new TroopInfoManager(this);
      continue;
      localObject3 = new QCallFacade(this);
      continue;
      localObject3 = new PicPreDownloader(this);
      continue;
      localObject3 = new RoamSettingManager(this);
      continue;
      localObject3 = new ContactSyncManager(this);
      continue;
      localObject3 = new FontManager(this);
      continue;
      localObject3 = new EmojiManager(this);
      continue;
      localObject3 = new BubbleManager(this);
      continue;
      localObject3 = new ColorRingManager(this);
      continue;
      localObject3 = new AvatarPendantManager(this);
      continue;
      localObject3 = new DownloaderFactory(this);
      continue;
      localObject3 = new TroopGagMgr(this);
      continue;
      localObject3 = new MyBusinessManager(this);
      continue;
      localObject3 = new FriendsManager(this);
      continue;
      localObject3 = new TroopManager(this);
      continue;
      localObject3 = new DiscussionManager(this);
      continue;
      localObject3 = new ContactFacade(this);
      continue;
      localObject3 = new SearchHistoryManager(this);
      continue;
      localObject3 = new PublicAccountDataManager(this);
      continue;
      localObject3 = new AccountDetailDynamicDataManager(this);
      continue;
      localObject3 = new SecMsgManager(this);
      continue;
      localObject3 = new SignatureManager(this);
      continue;
      localObject3 = new ConditionSearchManager(this);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = new HotChatManager(this);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
      continue;
      localObject3 = new SubAccountManager(this);
      continue;
      localObject3 = new SubAccountControll(this);
      continue;
      localObject3 = new ChatBackgroundManager(this);
      continue;
      localObject3 = new NumRedPointManager(this);
      continue;
      localObject3 = new NumRedMsgManager(this);
      continue;
      localObject3 = new LbsInfoMgr(this);
      continue;
      localObject3 = new ShortVideoTransManager(this);
      continue;
      localObject3 = new DeviceProfileManager.AccountDpcManager(this);
      continue;
      localObject3 = new EqqDetailDataManager(this);
      continue;
      localObject3 = new TroopRedTouchManager(this);
      continue;
      localObject3 = new DatingProxyManager(this);
      continue;
      localObject3 = new QQLSRecentManager(this);
      continue;
      localObject3 = new PicStatisticsManager(this);
      continue;
      localObject3 = new NearbyBannerManager(this);
      continue;
      localObject3 = new VipGiftManager(this);
      continue;
      localObject3 = new EarlyDownloadManager(this);
      continue;
      localObject3 = new QQWiFiMainManager(this);
      continue;
      localObject3 = new PortalManager(this);
      continue;
      localObject3 = new OlympicManager(this);
      continue;
      localObject3 = new ArResourceManager(this);
      continue;
      localObject3 = new AddContactTroopManage(this);
      continue;
      localObject3 = new TroopTipsMsgMgr(this);
      continue;
      localObject3 = new WordMatchManager(this);
      continue;
      localObject3 = new PngFrameManager(this);
      continue;
      localObject3 = new VipFunCallManager(this);
      continue;
      localObject3 = new ActivateFriendsManager(this);
      continue;
      localObject3 = new LightalkSwitchManager(this);
      continue;
      localObject3 = new EcShopAssistantManager(this);
      continue;
      localObject3 = new PttConfigController(this);
      continue;
      localObject3 = new VipImageUploadManager(this);
      continue;
      localObject3 = new QzoneContactsFeedManager(this);
      continue;
      localObject3 = new MessageRoamManager(this);
      continue;
      localObject3 = new NearbyGrayTipsManager(this);
      continue;
      localObject3 = new SecSpyFileManager(this);
      continue;
      localObject3 = new ShortVideoPreDownloaderWithSdkSupport(this);
      continue;
      localObject3 = new ReadInJoyManager(this);
      continue;
      localObject3 = new TroopTopicMgr(this);
      continue;
      localObject3 = new PAReportManager(this);
      continue;
      localObject3 = new PhoneUnityManager(this);
      continue;
      localObject3 = new FavroamingManager(this);
      continue;
      localObject3 = new FullMessageSearchManager(this);
      continue;
      localObject3 = new QzoneAlbumRedTouchManager(this);
      continue;
      localObject3 = new TroopAppMgr(this);
      continue;
      localObject3 = new TroopAioADManager(this);
      continue;
      localObject3 = new IndividuationManager(this);
      continue;
      localObject3 = new CommonUsedSystemEmojiManager(this);
      continue;
      localObject3 = new NearbyCardManager(this);
      continue;
      localObject3 = new ODProxy(this);
      continue;
      localObject3 = new TroopGiftManager(this);
      continue;
      localObject3 = new DingdongPluginManager(this);
      continue;
      localObject3 = new WeatherManager(this);
      continue;
      localObject3 = new QQCardManager(this);
      continue;
      localObject3 = new QQHotSpotRemoteManager(this);
      continue;
      localObject3 = new NearbyProxy(this);
      continue;
      localObject3 = new HotPatchManager(this);
      continue;
      localObject3 = new TroopPluginManager(this);
      continue;
      localObject3 = new PttPreSendManager(this);
      continue;
      localObject3 = new PTTPreDownloader(this);
      continue;
      localObject3 = new ArkAppCenter(this);
      continue;
      localObject3 = new SenseWhereManager(this);
      continue;
      localObject3 = new PasswdRedBagManager(this);
      continue;
      localObject3 = new HotchatSCMng(this);
      continue;
      localObject3 = new BusinessCardManager(this);
      continue;
      localObject3 = new FTSDBManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager = ((FTSDBManager)localObject3);
      continue;
      localObject3 = new QRProcessManager(this);
      continue;
      localObject3 = new NearbyFlowerManager(this);
      continue;
      localObject3 = new TroopOrgProtocolManager(this);
      continue;
      localObject3 = new IndividualRedPacketManager(this);
      continue;
      localObject3 = new TroopBindPublicAccountMgr(this);
      continue;
      localObject3 = new BlessManager(this);
      continue;
      localObject3 = new DAUStatistic(this);
      continue;
      localObject3 = new PublicQuickPayManager(this);
      continue;
      localObject3 = new ApolloManager(this);
      continue;
      localObject3 = new ApolloRecentManager(this);
      continue;
      localObject3 = new ApolloDaoManager(this);
      continue;
      localObject3 = new LightalkShieldManager(this);
      continue;
      localObject3 = new QCallCardManager(this);
      continue;
      localObject3 = new VipComicMqqManager(this);
      continue;
      localObject3 = new QQComicPreloadManager(this);
      continue;
      localObject3 = new TroopRewardMgr(this);
      continue;
      localObject3 = new FavroamingDBManager(this);
      continue;
      localObject3 = new BitAppManager(this);
      continue;
      localObject3 = new PstnManager(this);
      continue;
      localObject3 = new PullActiveManager(this);
      continue;
      localObject3 = new LoginWelcomeManager(this);
      continue;
      localObject3 = new NearByGeneralManager(this);
      continue;
      localObject3 = new VipComicEmoticonUploadManager(this);
      continue;
      localObject3 = new URLInterceptManager(this);
      continue;
      localObject3 = new VACDReportMgr();
      continue;
      localObject3 = new PreloadManager(this);
      continue;
      localObject3 = new GamePartyManager(this);
      continue;
      localObject3 = new ReadInJoyDAUStatistic(this);
      continue;
      localObject3 = new MayknowRecommendManager(this);
      continue;
      localObject3 = new FriendAnniverManager(this);
      continue;
      localObject3 = new LocalRedTouchManager(this);
      continue;
      localObject3 = new KandianMergeManager(this);
      continue;
      localObject3 = new ReadInJoyLogicManager(this);
      continue;
      localObject3 = new TroopVideoManager(this);
      continue;
      localObject3 = new LongTextMsgManager(this);
      continue;
      localObject3 = new QidianManager(this);
      continue;
      localObject3 = new NowLiveManager(this);
      continue;
      localObject3 = new PhotoPlusManager(this);
      continue;
      localObject3 = new FaceManager(this);
      continue;
      localObject3 = new MixedMsgManager(this);
      continue;
      localObject3 = new QZonePluginManger(this);
      continue;
      localObject3 = new VoiceChangeManager(this);
      continue;
      localObject3 = new IndividuationABTestManager(this);
      continue;
      localObject3 = new DynamicAvatarManager(this);
      continue;
      localObject3 = new QQStoryManager(this);
      continue;
      localObject3 = new NowProxy(this);
      continue;
      localObject3 = new ChangeMachineManager(this);
      continue;
      localObject3 = new PrecoverManager(this);
    }
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush", "MessageSvc.PushGroupMsg", "MessageSvc.PushForceOffline", "MessageSvc.PushNotify", "MessageSvc.PushForceOffline", "MessageSvc.RequestPushStatus", "RegPrxySvc.PullDisGroupSeq", "MessageSvc.RequestBatchPushFStatus", "MessageSvc.PushFStatus", "AccostSvc.SvrMsg", "ADMsgSvc.PushMsg", "StreamSvr.PushStreamMsg", "friendlist.getOnlineFriend", "MessageSvc.WNSQzone", "RegPrxySvc.PbGetMsg", "RegPrxySvc.getOffMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.NoticeEnd", "RegPrxySvc.PbSyncMsg", "account.ResponseNotifyForRecommendUpdate", "MessageSvc.PushReaded", "RegPrxySvc.infoLogin", "baseSdk.Msf.NotifyResp", "RegPrxySvc.PushParam", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "cmd_connAllFailed", "cmd_recvFirstResp", "MultiVideo.s2c", "MultiVideo.c2sack", "NearFieldTranFileSvr.NotifyList", "ProfileService.CheckUpdateReq", "NearFieldDiscussSvr.NotifyList", "RegPrxySvc.QueryIpwdStat", "StatSvc.SvcReqMSFLoginNotify", "SharpSvr.s2cpstncallback", "ConfigPushSvc.PushDomain" };
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { TempServlet.class, CliNotifyPush.class, ContactBindServlet.class };
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnAllFailed");
    }
    LoadingStateManager.a().a(4);
    MqqHandler localMqqHandler = a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134013, null).sendToTarget();
    }
  }
  
  public void h(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.b(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean h()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    if (localAudioManager != null) {}
    for (;;)
    {
      try
      {
        i1 = localAudioManager.getRingerMode();
        if (i1 == 0) {
          return true;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        i1 = 2;
        continue;
      }
      return false;
      int i1 = 2;
    }
  }
  
  public void i()
  {
    ThreadManager.b().post(new qer(this));
    try
    {
      a(new ToServiceMsg("mobileqq.service", a(), "CMD_STOP_NOTIFIYCATION"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean i()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2);
  }
  
  public void j()
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("notification");
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(119);
      a(a());
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean j()
  {
    String str = Build.MANUFACTURER + Build.MODEL;
    if ((!TextUtils.isEmpty(str)) && (str.toLowerCase().contains("xiaomi"))) {
      if (Settings.System.getInt(a().getContentResolver(), "vibrate_in_normal", -1) != 1) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (Build.VERSION.SDK_INT >= 11) {
            break;
          }
        } while (Settings.System.getInt(a().getContentResolver(), "vibrate_on", -1) > 4);
        return false;
        if (Build.VERSION.SDK_INT >= 16) {
          break;
        }
      } while (Settings.System.getInt(a().getContentResolver(), "vibrate_on", -1) == 5);
      return false;
    } while (Settings.System.getInt(a().getContentResolver(), "vibrate_when_ringing", -1) == 1);
    return false;
  }
  
  public boolean k()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 1);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentAvAppAvAddFriendService != null)
    {
      this.jdField_a_of_type_ComTencentAvAppAvAddFriendService.a();
      this.jdField_a_of_type_ComTencentAvAppAvAddFriendService = null;
    }
  }
  
  public boolean l()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public void logout(boolean paramBoolean)
  {
    if (paramBoolean) {
      L();
    }
    ((PushManager)getManager(5)).unregistProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video");
    LoadingStateManager.a().a();
    K();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "kickPC in app  do logout");
    }
    String str = a();
    if (str != null) {}
    try
    {
      SdkContext.cleanCokiee(a(), Long.parseLong(str));
      super.logout(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void m()
  {
    AppRuntime.Status localStatus;
    if (isLogin()) {
      switch ((int)a())
      {
      default: 
        localStatus = AppRuntime.Status.offline;
      }
    }
    for (;;)
    {
      ((PushManager)getManager(5)).registProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video", "com.tencent.av.ui.VChatActivity", new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c" });
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "kickPC get value in sendRegisterPush........... kickpc = " + c());
      }
      sendOnlineStatus(localStatus, c(), a().getSharedPreferences(getAccount(), 0).getInt("GetFrdListReq_seq", 0));
      return;
      localStatus = AppRuntime.Status.online;
      continue;
      localStatus = AppRuntime.Status.away;
      continue;
      localStatus = AppRuntime.Status.invisiable;
    }
  }
  
  public boolean m()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)a().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, VideoConfigServlet.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public boolean n()
  {
    return a().getBoolean(a().getString(2131367840) + a(), false);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper = new LebaHelper(this);
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a();
    }
  }
  
  public boolean o()
  {
    Object localObject = a();
    localObject = ((FriendsManager)getManager(50)).a((String)localObject);
    if (localObject == null) {
      return false;
    }
    if (((Card)localObject).isShowZan()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startServlet(new NewIntent(getApplication(), PushServlet.class));
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService = new MobileQQService(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = new Automator(this);
    if (e())
    {
      QCallFacade.a(this, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a().createEntityManager();
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      if (StartService.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(StepFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, "{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}"));
      }
      if (StartService.jdField_a_of_type_Boolean) {
        ThemeUtil.initTheme(this);
      }
      N();
    }
    try
    {
      MagnifierSDK.a(Long.parseLong(getAccount()));
      ThreadManager.b().post(new qdw(this));
      if (StartService.jdField_a_of_type_Boolean) {
        ProfileCardUtil.a();
      }
      if (GuardManager.a != null) {
        GuardManager.a.a(this);
      }
      this.jdField_d_of_type_Boolean = true;
      a().a();
      a().d();
      UniformDownloadMgr.a().a(this);
      PluginManageHandler.getInstance().setPluginManagerProvider(this, false);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 4, paramBundle.toString());
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    BaseApplicationImpl.jdField_b_of_type_Long = 0L;
    BaseApplicationImpl.jdField_a_of_type_Long = 0L;
    BaseApplicationImpl.c = 0L;
    FMTSrvAddrProvider.b();
    K();
    ThemeUiPlugin.destroy(this);
    ChatBackgroundManager.a();
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Qes);
    ThreadManager.a(new qeg(this), 8, null, false);
    i();
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Unregist Cloud Scan Listener");
    }
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
      try
      {
        this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        UniformDownloadMgr.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
          a().a();
        }
        Config.b();
        OpenApiManager.a().c(this);
        AppLaucherHelper.a();
        TroopFileUploadingManager.a(this);
        QWalletHelper.b(this);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter.e();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine != null) {
          this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine.closeEngine();
        }
        if (!TextUtils.isEmpty(a())) {
          QQOperateManager.b();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter != null) {
          a().e();
        }
        if (this.jdField_a_of_type_CooperationQlinkQQProxyForQlink != null) {
          a().e();
        }
        PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b();
        }
        if (InnerDns.a != null) {
          InnerDns.a().a();
        }
        if (getLongAccountUin() > 10000L) {
          LeakInspector.a(this, String.format("%d", new Object[] { Long.valueOf(getLongAccountUin()) }));
        }
        if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
          this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        }
        return;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public RemotePluginManager.Stub onGetPluginManager()
  {
    return (PluginManagerV2)getManager(26);
  }
  
  public void onProxyIpChanged()
  {
    ThreadManager.a(new qdy(this), 8, null, false);
  }
  
  public void onRunningBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRunningBackground");
    }
    super.onRunningBackground();
    D();
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.e();
    }
    ReportController.a(this);
    a().b();
    Object localObject = (QzoneAlbumRedTouchManager)getManager(103);
    if (localObject != null) {
      ((QzoneAlbumRedTouchManager)localObject).c();
    }
    localObject = (MediaPlayerManager)this.jdField_a_of_type_ArrayOfMqqManagerManager[23];
    if ((localObject != null) && (((MediaPlayerManager)localObject).b())) {
      ((MediaPlayerManager)localObject).a(false);
    }
    a(-1L);
  }
  
  public void onRunningForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRunningForeground");
    }
    super.onRunningForeground();
    ReportController.b(this, "CliOper", "", "", "0X8004014", "0X8004014", 0, 0, "", "", "", "");
    Object localObject = a();
    if ((localObject != null) && (((QQMessageFacade)localObject).e() > 1)) {
      ReportController.b(this, "CliOper", "", "", "0X8004015", "0X8004015", 0, 0, "", "", "", "");
    }
    ReportController.a(this, false);
    QlinkReliableReport.a();
    localObject = new Intent("com.tencent.intent.QZONE_PRE_DOWNLOAD_CANCEL");
    BaseApplication.getContext().sendBroadcast((Intent)localObject);
    localObject = (PhoneContactManagerImp)getManager(10);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).c();
    }
    localObject = (GameCenterManagerImp)getManager(11);
    if (localObject != null)
    {
      ((GameCenterManagerImp)localObject).c();
      ((NumRedPointManager)getManager(63)).a();
      localObject = BaseApplication.getContext().getSharedPreferences(getAccount(), 0);
      int i1 = ((SharedPreferences)localObject).getInt("NumRedTimeInterval", 600);
      int i2 = ((SharedPreferences)localObject).getInt("NumRedLastTime", 0);
      if ((int)(System.currentTimeMillis() / 1000L) - i2 > i1) {
        ((NumRedPointHandler)a(55)).a();
      }
      ((RedpointHandler)a(87)).a(false);
    }
    localObject = (ArkAppCenter)getManager(120);
    if (localObject != null) {
      ((ArkAppCenter)localObject).a();
    }
    localObject = (QZoneManager)getManager(9);
    if (localObject != null)
    {
      if (((QZoneManager)localObject).a() > 0) {
        ((QZoneManager)localObject).b(((QZoneManager)localObject).a());
      }
      ((QZoneManager)localObject).b(2);
    }
    f(false);
    QWalletPushManager.a(this, false);
    if (!QQUtils.a(a().getBaseContext()))
    {
      localObject = (DingdongPluginManager)getManager(114);
      if (localObject != null) {
        ((DingdongPluginManager)localObject).a(this);
      }
    }
    localObject = (ActivateFriendsManager)getManager(84);
    if (localObject != null) {
      ((ActivateFriendsManager)localObject).a();
    }
    StatisticCollector.a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this);
    A();
    QQToast.a(true);
    QWalletHelper.c(this);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.c();
    }
  }
  
  public boolean p()
  {
    return a().getBoolean(a().getString(2131367841) + a(), false);
  }
  
  public void q()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "trySoundAndVibrate is called,needSoundAndVibrations is:" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    }
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = ((QQMessageFacade)localObject).a();
      } while (localObject == null);
      this.jdField_c_of_type_ArrayOfLong[0] = ((QQMessageFacade.Message)localObject).uniseq;
      this.jdField_c_of_type_ArrayOfLong[1] = 1L;
    } while (this.jdField_a_of_type_ArrayOfByte[0] != 1);
    if (this.jdField_a_of_type_ArrayOfByte[1] == 1) {}
    for (;;)
    {
      d((MessageRecord)localObject, bool);
      this.jdField_a_of_type_ArrayOfByte[0] = 0;
      return;
      bool = false;
    }
  }
  
  public boolean q()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener != null) && (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.f());
  }
  
  public void r()
  {
    d(null, false);
  }
  
  public boolean r()
  {
    boolean bool2 = false;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    boolean bool3 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, null, "security_scan_key", "qqsetting_security_scan_key", false);
    boolean bool4 = ((SharedPreferences)localObject).getBoolean("security_scan_last_result", false);
    long l1 = ((SharedPreferences)localObject).getLong("security_scan_last_time", 0L);
    localObject = new Date(l1);
    Date localDate = new Date();
    ((Date)localObject).setHours(0);
    ((Date)localObject).setMinutes(0);
    ((Date)localObject).setSeconds(0);
    boolean bool1 = bool2;
    if (bool3) {
      if ((l1 != 0L) && (localDate.getTime() - ((Date)localObject).getTime() <= 604800000L))
      {
        bool1 = bool2;
        if (!bool4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void s()
  {
    ((LBSHandler)a(3)).a();
  }
  
  public boolean s()
  {
    String str1 = a();
    String str2 = ContactUtils.i(this, str1);
    Object localObject;
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2)))
    {
      localObject = (FriendsManager)getManager(50);
      if (localObject == null)
      {
        localObject = null;
        if ((localObject != null) && (((Friends)localObject).name != null)) {
          break label136;
        }
        localObject = (FriendListHandler)a(1);
        if (localObject == null) {
          break label136;
        }
        ((FriendListHandler)localObject).b(str1);
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "checkAndGetSelfNickName, [" + str2 + "," + bool + "]");
      }
      return bool;
      localObject = ((FriendsManager)localObject).c(str1);
      break;
    }
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    String str = "";
    if (!a().equals("0")) {
      str = a();
    }
    SharedPreUtils.a(getApplication().getApplicationContext(), str, paramBoolean);
  }
  
  public void start(boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseApplicationImpl.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null)) {
      return;
    }
    this.jdField_a_of_type_Qes = new qes(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Qes);
    super.start(paramBoolean);
  }
  
  public void t()
  {
    ((CardHandler)a(2)).a();
  }
  
  public boolean t()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(BaseApplication.getContext().getString(2131367791) + a(), true);
  }
  
  public void u()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.aw, 0);
      a().a().e();
      return;
    }
  }
  
  protected void userLogoutReleaseData()
  {
    L();
    HeavyTaskExecutor.a(new qdz(this));
    UpgradeController.a().a(true);
    FriendSystemMsgController.a().a();
    GroupSystemMsgController.a().a();
    MsgAutoMonitorUtil.a().a();
    ChatActivityUtils.c();
    BadgeUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, 0);
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.b();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a();
    }
    OpenApiManager.a().b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.g();
    ((NowProxy)getManager(181)).onDestroy();
  }
  
  public void v()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.aw, 0);
      return;
    }
  }
  
  public void w()
  {
    ISecureModuleService localISecureModuleService = a();
    if (localISecureModuleService.register(new ProductInfo(6, h(), Integer.parseInt("2880"), 201, null, getAccount())) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("security_scan", 2, "Start Security Scan");
      }
      if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener == null) {
        this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener = new qee(this);
      }
      localISecureModuleService.registerCloudScanListener(a(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
      localISecureModuleService.cloudScan();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("security_scan", 2, "regist security service error");
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener.a();
    }
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqJumplightalkCallRedDotLightalkLis != null) {
      this.jdField_a_of_type_ComTencentMobileqqJumplightalkCallRedDotLightalkLis.a();
    }
  }
  
  public void z()
  {
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\QQAppInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */