package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.StatFs;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.AITranslator;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.devicelib.DeviceLib;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.OnChatMessageCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.panel.AIOFakePanel;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconCallback;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.tips.ComicTipsBar;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar;
import com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips;
import com.tencent.mobileqq.activity.photo.PhotoMagicStickUtils;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.MX3FlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.MX3FlowNewCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.VibrateListener;
import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.QQMessageFacade.MessageNotifyParam;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.OnBottomOverScrollListener;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager.TorchUpdateListener;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.ptt.PttSSCMPool;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgVideoController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.ShortVideoUploadABTest;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.text.ReplyClickMovementMethod;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.mqq.shared_file_accessor.LogUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollButtomListener;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.SizeChangedCallback;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.OnChangeMultiScreenListener;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.comic.VipComicReportUtils;
import cooperation.huangye.C2BUtils;
import cooperation.peak.PeakUtils;
import cooperation.photoplus.PhotoPlusBridgeActivity;
import cooperation.plugin.IPluginManager;
import cooperation.qlink.QQProxyForQlink;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kma;
import kmb;
import kmc;
import kmd;
import kme;
import kmf;
import kmg;
import kmh;
import kmi;
import kmj;
import kmk;
import kml;
import kmm;
import kmn;
import kmo;
import kmp;
import kmq;
import kmr;
import kms;
import kmt;
import kmu;
import kmv;
import kmw;
import kmy;
import kmz;
import kna;
import knb;
import knc;
import knd;
import kne;
import knf;
import kng;
import knh;
import kni;
import knj;
import knk;
import knl;
import knm;
import knn;
import kno;
import knp;
import knq;
import knr;
import kns;
import knt;
import knu;
import knv;
import knw;
import knx;
import kny;
import knz;
import koa;
import kob;
import koc;
import kod;
import koe;
import kog;
import koj;
import kok;
import kol;
import kom;
import kor;
import kos;
import kow;
import kox;
import koy;
import koz;
import kpa;
import kpb;
import kpc;
import kpg;
import kph;
import kpi;
import kpj;
import kpk;
import kpl;
import kpm;
import kpn;
import kpo;
import kpp;
import kpq;
import kpw;
import kpx;
import kpy;
import kpz;
import kqa;
import kqc;
import kqe;
import kqf;
import kqg;
import kqj;
import kqk;
import kql;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class BaseChatPie
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnTouchListener, ChatActivityConstants, BaseChatItemLayout.OnChatMessageCheckedChangeListener, MediaPlayerManager.Listener, PanelIconLinearLayout.PanelIconCallback, CheckPttListener, CheckPtvListener, VibrateListener, ChatXListView.OnBottomOverScrollListener, EmoticonCallback, INetInfoHandler, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, OverScrollViewListener, XPanelContainer.OnChangeMultiScreenListener, XPanelContainer.PanelCallback, Observer
{
  private static boolean R = false;
  public static final String a = "Q.aio.BaseChatPie";
  private static final String am = "//findcrash";
  public static final int b = 1;
  public static final String b = "is_from_manage_stranger";
  public static final int c = 2;
  public static final int d = 3;
  private static final int dW = 1;
  private static final int dX = 2;
  private static int ee = 0;
  public static final int j = 200;
  public static final int n = 0;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int t = 0;
  public static final int u = 1;
  public static final int v = 2;
  public static int y;
  public static boolean z;
  public boolean A;
  public boolean B;
  public boolean C = true;
  public boolean D;
  protected boolean E = true;
  protected boolean F;
  protected boolean G;
  private boolean J;
  private boolean K = true;
  private boolean L = true;
  private boolean M;
  private boolean N;
  private boolean O;
  private boolean P = false;
  private boolean Q;
  private boolean S = true;
  private volatile boolean T;
  private boolean U;
  private boolean V = true;
  private boolean W;
  private boolean X;
  private boolean Y = true;
  private boolean Z;
  public float a;
  protected final int a;
  protected long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new knc(this);
  public Context a;
  protected MessageQueue.IdleHandler a;
  public FragmentActivity a;
  private MovementMethod jdField_a_of_type_AndroidTextMethodMovementMethod;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public View.OnClickListener a;
  protected View a;
  protected ViewGroup a;
  protected ImageView a;
  protected LinearLayout a;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public RelativeLayout a;
  public TextView a;
  private AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog;
  public AIOTipsController a;
  public ChatAdapter1 a;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  protected PlusPanel a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  protected MoveToBottomScroller a;
  public AudioPanel a;
  final StructingMsgItemBuilder.ViewCache jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache = new StructingMsgItemBuilder.ViewCache();
  protected AIOFakePanel a;
  public PanelIconLinearLayout a;
  public PhotoListPanel a;
  public FraudTipsBar a;
  protected LightalkBlueTipsBar a;
  public QQOperateTips a;
  public TipsManager a;
  public VideoStatusTipsBar a;
  protected VipFunCallTipsBar a;
  public PasswdRedBagManager a;
  public ApolloSurfaceView a;
  public BarrageView a;
  public ApolloInfo a;
  public ApolloPanel a;
  protected ChatApolloViewListener a;
  protected InputGlobalLayoutListener a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new kol(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new kok(this);
  private EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new kor(this);
  protected FriendListHandler a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new kog(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new koj(this);
  public QQAppInterface a;
  public QQMapActivityProxy a;
  public QQMessageFacade.RefreshMessageContext a;
  public ChatXListView a;
  protected ChatMessage a;
  private ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  public MessageForReplyText.SourceMsgInfo a;
  private NoC2CExtensionInfo jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
  private SogouEmoji jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji;
  protected EmoticonMainPanel a;
  private EmotionPreviewLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout;
  public FastImagePreviewLayout a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  private MagicfaceViewController jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  public OlympicTorchManager.TorchUpdateListener a;
  protected PortalManager a;
  public TroopAioTips a;
  protected QQRecorder a;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new kom(this);
  public QQProgressDialog a;
  protected ScrollerRunnable a;
  public ToastStyleDialog a;
  protected PatchedButton a;
  XEditTextEx.SizeChangedCallback jdField_a_of_type_ComTencentWidgetXEditTextEx$SizeChangedCallback = new kml(this);
  public XEditTextEx a;
  public XPanelContainer a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  protected CharSequence a;
  public Runnable a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("");
  protected List a;
  protected kqf a;
  public final MqqHandler a;
  protected boolean a;
  public View[] a;
  ViewGroup[] jdField_a_of_type_ArrayOfAndroidViewViewGroup;
  AnimationSet[] jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet;
  public FrameLayout[] a;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private String al;
  protected long b;
  public Dialog b;
  public View b;
  protected ViewGroup b;
  protected ImageView b;
  protected LinearLayout b;
  RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public RelativeLayout b;
  public TextView b;
  protected PhotoListPanel b;
  protected ChatMessage b;
  public QQProgressDialog b;
  private ToastStyleDialog jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog;
  private Boolean jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private List jdField_b_of_type_JavaUtilList;
  protected boolean b;
  public long c;
  public Dialog c;
  protected View c;
  protected ViewGroup c;
  protected ImageView c;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  protected RelativeLayout c;
  protected TextView c;
  public QQProgressDialog c;
  private Runnable jdField_c_of_type_JavaLangRunnable = new kma(this);
  protected String c;
  public boolean c;
  protected long d;
  public Dialog d;
  protected View d;
  public ViewGroup d;
  protected ImageView d;
  protected RelativeLayout d;
  protected TextView d;
  public String d;
  protected boolean d;
  private final int dP = 600;
  private int dQ;
  private int dR;
  private int dS = 1;
  private int dT;
  private int dU = 0;
  private int dV = 1;
  private int dY;
  private int dZ;
  public int e;
  protected long e;
  public Dialog e;
  public View e;
  public ViewGroup e;
  protected ImageView e;
  public TextView e;
  protected String e;
  protected boolean e;
  private int ea;
  private int eb = 10;
  private int ec;
  private int ed;
  private int ef = -1;
  private int eg;
  private int eh = 0;
  private int ei;
  private int ej;
  public int f;
  long jdField_f_of_type_Long;
  public Dialog f;
  public View f;
  protected ImageView f;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  protected String f;
  public final boolean f;
  protected int g;
  protected View g;
  protected ImageView g;
  private TextView g;
  public boolean g;
  protected int h;
  private long jdField_h_of_type_Long = -1L;
  private View jdField_h_of_type_AndroidViewView;
  protected ImageView h;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  public boolean h;
  protected int i;
  private View jdField_i_of_type_AndroidViewView;
  protected ImageView i;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  public boolean i;
  private View jdField_j_of_type_AndroidViewView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  public boolean j;
  protected int k;
  private View jdField_k_of_type_AndroidViewView;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  public boolean k;
  int jdField_l_of_type_Int = 0;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  public boolean l;
  public int m;
  public boolean m;
  public boolean n;
  boolean o = false;
  public volatile boolean p;
  protected boolean q;
  protected int r;
  protected boolean r;
  public int s;
  boolean s;
  boolean t = false;
  protected boolean u;
  protected boolean v;
  protected int w;
  protected boolean w;
  protected int x;
  public boolean x;
  protected boolean y;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_y_of_type_Int = 30;
  }
  
  public BaseChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 300;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_j_of_type_Boolean = true;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 131074;
    this.jdField_h_of_type_Int = 2130837539;
    this.jdField_i_of_type_Int = 2130837538;
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_s_of_type_Boolean = true;
    this.jdField_m_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_r_of_type_Int = -1;
    this.jdField_s_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener = new ChatApolloViewListener(this);
    this.jdField_a_of_type_JavaLangRunnable = new knn(this);
    this.jdField_w_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new kpz(this);
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager$TorchUpdateListener = new kqa(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_d_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  private String a(String paramString)
  {
    return paramString;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.a(new kmh(this, paramInt2, paramInt1, paramString), 2, null, false);
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "updateSession_forwardType intent type" + paramIntent.getIntExtra("uintype", -1) + "needToBottom=" + paramBoolean);
    }
    if ((paramIntent.getExtras() != null) && (paramIntent.getExtras().containsKey("forward_type")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("forward", 2, "updateSession_forwardType from forward");
      }
      if ((paramIntent.getIntExtra("uintype", -1) == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(paramIntent.getStringExtra("uin"), true).jdField_a_of_type_Boolean)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131364717, 0).b(a());
      }
    }
    else
    {
      return;
    }
    int i1 = paramIntent.getIntExtra("forward_type", Integer.MAX_VALUE);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (i1 == 0) {
      this.jdField_h_of_type_Boolean = true;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.aio.BaseChatPie", 1, "updateSession_forwardType, postDelayed!");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new kox(this, paramBoolean, paramIntent, paramIntent), 500L);
      a(false, null, false);
      return;
      if ((i1 == 1001) || (i1 == -4)) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      }
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle(paramBundle));
    a(localIntent, false);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Map)paramMessage.obj;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)paramMessage.get("chatMessage"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i1);
    }
    if (i1 < 0) {}
    for (;;)
    {
      return;
      int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
      int i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t();
      int i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
      if ((i1 >= i2 - i3) && (i1 <= i4 - i5))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s());
        if ((localObject != null) && ((localObject instanceof LinearLayout)))
        {
          paramMessage = (RichStatus.SigZanInfo)paramMessage.get("sigZanInfo");
          if ((AIOUtils.a((View)localObject) instanceof RichStatItemBuilder.Holder))
          {
            localObject = (RichStatItemBuilder.Holder)AIOUtils.a((View)localObject);
            if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (paramMessage.jdField_a_of_type_JavaLangString.equals(((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_JavaLangString)))
            {
              ((RichStatItemBuilder.Holder)localObject).e = paramMessage.jdField_b_of_type_Int;
              ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_Int = paramMessage.jdField_c_of_type_Int;
              ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramMessage.jdField_b_of_type_Int));
              SignatureManager localSignatureManager = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
              if (paramMessage.jdField_c_of_type_Int == 0) {}
              for (paramMessage = localSignatureManager.a(((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_Int, 7, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 19.0F)); paramMessage != null; paramMessage = localSignatureManager.a(((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_Int, 8, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 19.0F)))
              {
                ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramMessage, null, null, null);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(FriendsManager paramFriendsManager)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    if ((localExtensionInfo == null) && (!paramFriendsManager.f())) {
      ThreadManager.b().post(new kpk(this, paramFriendsManager));
    }
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(localExtensionInfo.audioPanelType, false);
    }
  }
  
  private void a(FriendsManager paramFriendsManager, int paramInt1, int paramInt2)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    paramFriendsManager = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "saveC2CChatInputType | mExtensionInfo != null");
        }
        paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
    }
    else
    {
      if (paramFriendsManager.chatInputType != paramInt1)
      {
        paramFriendsManager.chatInputType = paramInt1;
        paramFriendsManager.isDataChanged = true;
      }
      if (paramFriendsManager.showC2CPanel != paramInt2)
      {
        paramFriendsManager.showC2CPanel = paramInt2;
        paramFriendsManager.isDataChanged = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
    }
  }
  
  private void a(FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    paramFriendsManager = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) {
        paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeedForC2C extInfo.chatInputType = " + paramFriendsManager.chatInputType + " extInfo.showC2CPanel = " + paramFriendsManager.showC2CPanel);
      }
      if (paramFriendsManager.chatInputType == 2) {
        break label107;
      }
    }
    label107:
    while (paramFriendsManager.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeed | ExtensionInfo = null");
      return;
    }
    e(paramBoolean1, paramBoolean2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i1 = 8;
    if (paramInt == 8) {}
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004603", "0X8004603", 0, 0, i1 + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report cancle send ptt, cancel source = " + paramInt);
      }
      return;
      if (paramInt == 1) {
        i1 = 1;
      } else if (paramInt == 2) {
        i1 = 2;
      } else {
        i1 = 3;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramInt1 = 1;
      if (paramInt2 != 8) {
        break label160;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006189", "0X8006189", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report send ptt, send source = " + paramInt2 + ", sessionType = " + paramInt1 + ", seconds = " + paramInt3);
      }
      return;
      if (paramInt1 == 3000)
      {
        paramInt1 = 2;
        break;
      }
      if (paramInt1 == 1)
      {
        paramInt1 = 3;
        break;
      }
      paramInt1 = 4;
      break;
      label160:
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt2 == 1) {}
        for (int i1 = 1;; i1 = 2)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004600", "0X8004600", 0, 0, i1 + "", paramInt1 + "", paramInt3 + "", "");
          break;
        }
      }
      if (paramInt2 == 4) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1E", "0X8005C1E", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
      } else {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004601", "0X8004601", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
      }
    }
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this.jdField_a_of_type_AndroidContentContext);
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131364595);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramAbsShareMsg = new kmi(this, paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "cancelSendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
    }
    a(2, paramString, paramLong);
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      StreamDataManager.a(paramString, true);
      StreamDataManager.a(paramString);
      StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong, true, 0, paramRecorderParam.jdField_c_of_type_Int);
      return;
    }
    PttBuffer.a(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean, EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.a(new kql(paramString, paramBoolean, paramEmoticonMainPanel, paramQQAppInterface), 2, null, false);
  }
  
  private boolean a(FriendsManager paramFriendsManager)
  {
    ExtensionInfo localExtensionInfo2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null) {
      if (paramFriendsManager.f()) {}
    }
    label26:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "chooseC2CChatInputType get ExtensionInfo = null");
      }
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localExtensionInfo1.timestamp = System.currentTimeMillis();
      if (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
      for (localExtensionInfo1.chatInputType = 0;; localExtensionInfo1.chatInputType = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = localExtensionInfo1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "doChooseC2CInputType extInfo.chatInputType = " + localExtensionInfo1.chatInputType);
        }
        if (AIOInputTypeHelper.jdField_b_of_type_Boolean) {
          break;
        }
        switch (localExtensionInfo1.chatInputType)
        {
        case 1: 
        default: 
          return false;
        case 0: 
          localExtensionInfo1.chatInputType = 1;
          if (!QLog.isColorLevel()) {
            break label26;
          }
          QLog.d("Q.aio.BaseChatPie", 2, "doChooseC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser");
          return false;
        }
      }
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("enter_ext_panel", 0) != 0);
    this.dU = 2;
    return false;
  }
  
  private void aC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "showAddFriendAndShield() ==== called.");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject2;
      if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null)
      {
        koe localkoe = new koe(this);
        this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setId(2131296401);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131493102));
        localLayoutParams.addRule(10);
        this.jdField_k_of_type_AndroidWidgetTextView = new DrawableCenterTextView(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837642);
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837541);
          this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131371069));
          this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString.equals("")))) {
            break label906;
          }
          this.jdField_k_of_type_AndroidWidgetTextView.setEnabled(false);
          this.jdField_k_of_type_AndroidWidgetTextView.setClickable(false);
          label287:
          this.jdField_k_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131428300));
          this.jdField_k_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131492883));
          this.jdField_k_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837641));
          this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
          this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()));
          this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(localkoe);
          localObject2 = new LinearLayout.LayoutParams(0, -1);
          ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
          this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(this.jdField_k_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
          localObject2 = new View(this.jdField_a_of_type_AndroidContentContext);
          ((View)localObject2).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428215));
          LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(1, -1);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, localLayoutParams1);
          this.jdField_l_of_type_AndroidWidgetTextView = new DrawableCenterTextView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_l_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131367653));
          this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428300));
          this.jdField_l_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492883));
          this.jdField_l_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837641));
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837537);
          this.jdField_l_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
          this.jdField_l_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          this.jdField_l_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_l_of_type_AndroidWidgetTextView.getText());
          this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(localkoe);
          this.jdField_l_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(3));
          localObject2 = new LinearLayout.LayoutParams(0, -1);
          ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
          this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(this.jdField_l_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131296401);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, 0, localLayoutParams);
        }
      }
      else
      {
        if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
          break label925;
        }
        this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131371069));
        this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localObject1 = this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297418);
        if (localObject1 != null)
        {
          localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131493102));
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        return;
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_JavaLangString))
        {
          this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131367655));
          this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
          break;
        }
        this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131367654));
        this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
        break;
        label906:
        this.jdField_k_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_k_of_type_AndroidWidgetTextView.setClickable(true);
        break label287;
        label925:
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_JavaLangString))
        {
          this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367655));
          this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
        }
        else
        {
          this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367654));
          this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
        }
      }
    }
  }
  
  private void aD()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManager.a(new kqc(this), 8, null, true);
  }
  
  private void aE()
  {
    ThreadManager.a(new kmb(this), 8, null, false);
  }
  
  private void aF()
  {
    long l1;
    Object localObject;
    int i1;
    int i2;
    if (this.V)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "do jumpToSpecifiedMsg");
      }
      l1 = System.currentTimeMillis();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      if (((List)localObject).size() > 0)
      {
        i1 = 0;
        if (i1 >= ((List)localObject).size()) {
          break label308;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
          break label156;
        }
        if (((ChatMessage)((List)localObject).get(i1)).shmsgseq != this.jdField_e_of_type_Long) {
          break label180;
        }
        i2 = i1;
      }
    }
    for (;;)
    {
      if (i2 >= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new kmu(this, i2));
        StatisticCollector.a(BaseApplication.getContext()).a(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l1, 0L, null, null);
        this.V = false;
        return;
        label156:
        i2 = i1;
        if (((ChatMessage)((List)localObject).get(i1)).time == this.jdField_e_of_type_Long) {
          continue;
        }
        label180:
        i1 += 1;
        break;
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_e_of_type_Long);
      if (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {}
      for (localObject = ChatActivityUtils.b(localList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);; localObject = ChatActivityUtils.a(localList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        a(localList, ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject));
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new kmv(this));
        break;
      }
      label308:
      i2 = -1;
    }
  }
  
  private void aG()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!this.T)
      {
        if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
          QLog.d("Q.aio.BaseChatPie", 1, "setReaded() call");
        }
        this.T = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
      {
        Object localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
        if ((localObject != null) && (((ChatMessage)localObject).msgtype == 63497))
        {
          localObject = (MessageForApollo)localObject;
          if ((!((MessageForApollo)localObject).hasPlayed) && (((MessageForApollo)localObject).isSend())) {
            ApolloUtil.a((MessageForApollo)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
        }
      }
    }
  }
  
  private void aH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  private void aI()
  {
    if ((!o()) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout == null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout = ((EmotionPreviewLayout)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903075, null));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(2, 2131297409);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = ((int)(10.5D * this.jdField_a_of_type_Float + 0.5D));
      localLayoutParams.bottomMargin = ((int)(4.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
      EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.aio.BaseChatPie", 2, "EmotionPreviewLayout InflateException = " + localException);
      }
    }
  }
  
  private void aJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onShow_videoStatus: mEnterExtPanel = " + this.dU + ", mExtPanelOnResumeTimes = " + this.dV);
    }
    if (this.dU != 0)
    {
      int i1 = this.dV - 1;
      this.dV = i1;
      if (i1 == 0)
      {
        if (this.dU != 1) {
          break label101;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new knv(this));
      }
    }
    for (;;)
    {
      this.dU = 0;
      return;
      label101:
      if (this.dU == 2) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new knw(this));
      }
    }
  }
  
  private void aK()
  {
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = PicItemBuilder.jdField_h_of_type_Int;
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    AbstractVideoImage.resumeAll();
    StructMsgVideoController.a().a();
    NowVideoController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).b();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onShow_updateUI: listView.setVisibility(View.VISIBLE)");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1000, new Object[0]);
    aR();
    if ((this.X) && (!this.jdField_r_of_type_Boolean))
    {
      if (this.K) {
        break label395;
      }
      e(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(0, true);
      this.K = true;
    }
    for (;;)
    {
      this.X = false;
      this.jdField_k_of_type_Boolean = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_AndroidContentContext.getString(2131367880), "qqsetting_enter_sendmsg_key", false);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setImeOptions(4);
        if (this.jdField_a_of_type_Kqf == null) {
          this.jdField_a_of_type_Kqf = new kqf(this, null);
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(this.jdField_a_of_type_Kqf);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyListener(this.jdField_a_of_type_Kqf);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(this);
      }
      try
      {
        bool = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().getBoolean("refuse_show_share_result_dialog", false);
        Object localObject1;
        if ((this.jdField_l_of_type_Boolean) && (!bool) && (this.jdField_s_of_type_Boolean))
        {
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
          String str = ((Bundle)localObject1).getString("app_name");
          localObject1 = StructMsgFactory.a((Bundle)localObject1);
          if ((localObject1 != null) && ((localObject1 instanceof AbsShareMsg)))
          {
            localObject1 = (AbsShareMsg)localObject1;
            a((AbsShareMsg)localObject1, str);
            this.jdField_s_of_type_Boolean = false;
          }
        }
        else
        {
          aQ();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          if (((SharedPreferences)localObject1).getBoolean("sdcard_related_download_failed", false))
          {
            if (!Environment.getExternalStorageState().equals("mounted"))
            {
              QQToast.a(BaseApplication.getContext(), 2131367686, 0).b(a());
              localObject1 = ((SharedPreferences)localObject1).edit();
              ((SharedPreferences.Editor)localObject1).putBoolean("sdcard_related_download_failed", false);
              ((SharedPreferences.Editor)localObject1).commit();
            }
          }
          else
          {
            return;
            label395:
            c(true, false);
            continue;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setImeOptions(0);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool = false;
          continue;
          if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1)
          {
            QQToast.a(BaseApplication.getContext(), 2131367687, 0).b(a());
            continue;
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  private void aL()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c() == 1) {}
    for (;;)
    {
      this.P = bool;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "mIsMsgSignalOpen: " + this.P);
      }
      return;
      bool = false;
    }
  }
  
  private void aM()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
    }
  }
  
  private void aN()
  {
    if ((QQLSRecentManager.jdField_e_of_type_Boolean) && (QQUtils.a(BaseApplication.getContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setReaded return : QQLSActivity is alive");
      }
      return;
    }
    ThreadManager.a(new koa(this), 8, null, false);
  }
  
  private void aO()
  {
    this.jdField_b_of_type_JavaLangRunnable = new kob(this);
  }
  
  private void aP()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "cancelMultiDelAnim() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(17);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(52);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.K();
    }
    int i1;
    if (this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout != null)
    {
      i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout.length)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1] != null) {
          this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1].setVisibility(8);
        }
        i1 += 1;
      }
    }
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[i1] != null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
        }
        i1 += 1;
      }
    }
    if (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup != null)
    {
      i1 = i2;
      while (i1 < this.jdField_a_of_type_ArrayOfAndroidViewViewGroup.length)
      {
        if ((this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1] != null) && (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1].getParent() != null)) {
          ((ViewGroup)this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1].getParent()).removeView(this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1]);
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView = null;
    this.jdField_a_of_type_ArrayOfAndroidViewViewGroup = null;
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = null;
    this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet = null;
    this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout = null;
  }
  
  private void aQ()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID")))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 4);
      if (localSharedPreferences.getBoolean("FORWARD_EMOPGK_ID", false))
      {
        String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().getInt("FORWARD_EMOPGK_ID") + "";
        localSharedPreferences.edit().remove("FORWARD_EMOPGK_ID").commit();
        b(str);
      }
    }
  }
  
  private void aR()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().containsKey("apollo_forward_key")))
    {
      this.dU = 21;
      ao();
    }
  }
  
  private void aS()
  {
    long l1 = System.currentTimeMillis();
    FriendsManager localFriendsManager;
    int i1;
    int i2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.jdField_d_of_type_Boolean))
    {
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) {
        break label151;
      }
      i1 = 2;
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() != 0)) {
        break label156;
      }
      i2 = 1;
      label81:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
        break label161;
      }
      b(localFriendsManager, i1, i2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("save_inptut", 2, "saveChatInputType cost :" + (System.currentTimeMillis() - l1));
      }
      return;
      label151:
      i1 = 1;
      break;
      label156:
      i2 = 0;
      break label81;
      label161:
      if (v()) {
        a(localFriendsManager, i1, i2);
      }
    }
  }
  
  private void aT()
  {
    ThreadManager.a(new kpq(this), 8, null, true);
  }
  
  private void aU()
  {
    boolean bool2 = true;
    int i1 = 120;
    int i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    QQRecorder.RecorderParam localRecorderParam;
    Object localObject;
    if ((i2 & 0x4) != 0)
    {
      i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt");
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).getInt("Channels") != 1)
      {
        localRecorderParam = a();
        localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true);
        if (this.jdField_d_of_type_Boolean) {
          break label232;
        }
        bool1 = true;
        label76:
        ((Bundle)localObject).putBoolean("DoesSupportDirectlyAudio", bool1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("Channels", 1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("SampleRate", localRecorderParam.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("TimeLength", i1);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("sougouptt params : support = ");
          if (this.jdField_d_of_type_Boolean) {
            break label238;
          }
        }
      }
    }
    label232:
    label238:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("Q.aio.BaseChatPie", 2, bool1 + "sample = " + localRecorderParam.jdField_a_of_type_Int + " max = " + i1);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.jdField_a_of_type_JavaLangObject = localRecorderParam;
      return;
      if ((i2 & 0x2) == 0) {
        break;
      }
      i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt");
      break;
      bool1 = false;
      break label76;
    }
  }
  
  private void aV()
  {
    List localList = SystemAndEmojiEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localList != null) && (localList.size() > 0))
    {
      int i1 = 0;
      while ((i1 < 84) && (i1 < localList.size()))
      {
        Object localObject = (EmotionPanelData)localList.get(i1);
        if ((localObject instanceof SystemAndEmojiEmoticonInfo))
        {
          localObject = (SystemAndEmojiEmoticonInfo)localObject;
          if ((localObject != null) && (((SystemAndEmojiEmoticonInfo)localObject).jdField_c_of_type_Int != 3) && (((SystemAndEmojiEmoticonInfo)localObject).j != -1))
          {
            localObject = (URLDrawable)((SystemAndEmojiEmoticonInfo)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
            if ((localObject != null) && (((URLDrawable)localObject).getStatus() != 1)) {
              ((URLDrawable)localObject).startDownload();
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if (!AppSetting.jdField_j_of_type_Boolean)
    {
      if (!paramBoolean3) {
        break label37;
      }
      i1 = 2131368156;
    }
    for (;;)
    {
      QQToast.a(paramContext, i1, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      return;
      label37:
      if (paramBoolean2) {
        i1 = 2131368157;
      } else if (paramBoolean1) {
        i1 = 2131368155;
      } else {
        i1 = 2131368154;
      }
    }
  }
  
  private void b(FriendsManager paramFriendsManager)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    if ((localNoC2CExtensionInfo == null) && (!paramFriendsManager.f())) {
      ThreadManager.b().post(new kpm(this, paramFriendsManager));
    }
    if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.audioPanelType != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(localNoC2CExtensionInfo.audioPanelType, false);
    }
  }
  
  private void b(FriendsManager paramFriendsManager, int paramInt1, int paramInt2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "saveNoC2CChatInputType | mNoC2CExtensionInfo != null");
        }
        localNoC2CExtensionInfo1 = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
      }
    }
    else
    {
      if (localNoC2CExtensionInfo1.chatInputType != paramInt1)
      {
        localNoC2CExtensionInfo1.chatInputType = paramInt1;
        localNoC2CExtensionInfo1.isDataChanged = true;
      }
      if (localNoC2CExtensionInfo1.showC2CPanel != paramInt2)
      {
        localNoC2CExtensionInfo1.showC2CPanel = paramInt2;
        localNoC2CExtensionInfo1.isDataChanged = true;
      }
      paramFriendsManager.a(localNoC2CExtensionInfo1, false);
      this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo = null;
    }
  }
  
  private void b(FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    paramFriendsManager = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo != null) {
        paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeedForNoC2C noC2CExtInfo.chatInputType = " + paramFriendsManager.chatInputType + " noC2CExtInfo.showC2CPanel = " + paramFriendsManager.showC2CPanel);
      }
      if (paramFriendsManager.chatInputType == 2) {
        break label114;
      }
    }
    label114:
    while (paramFriendsManager.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeed | NoC2CExtensionInfo = null");
      return;
    }
    e(paramBoolean1, paramBoolean2);
  }
  
  private boolean b(FriendsManager paramFriendsManager)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null)
    {
      if (!paramFriendsManager.f()) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "chooseC2CChatInputType get NoC2CExtensionInfo = null");
      }
      localNoC2CExtensionInfo1 = new NoC2CExtensionInfo();
      localNoC2CExtensionInfo1.type = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      localNoC2CExtensionInfo1.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localNoC2CExtensionInfo1.chatInputType = 0;
      this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo = localNoC2CExtensionInfo1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    for (int i1 = 1;; i1 = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "doChooseNoC2CInputType noC2CExtInfo.chatInputType = " + localNoC2CExtensionInfo1.chatInputType + " noC2CType = " + i1);
      }
      switch (localNoC2CExtensionInfo1.chatInputType)
      {
      case 1: 
      case 2: 
      default: 
        return false;
      }
      localNoC2CExtensionInfo1.chatInputType = 1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.aio.BaseChatPie", 2, "doChooseNoC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser ");
      return false;
    }
  }
  
  private void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!AIOUtils.b())) {
      if (this.jdField_c_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130903086, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297009);
        this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297011));
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label150;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c())) {
          ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131297409);
        }
      }
    }
    label149:
    label150:
    while (this.jdField_c_of_type_AndroidViewView == null)
    {
      break label149;
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (paramBoolean2) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(2131367625);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidViewView.setSelected(paramBoolean2);
        return;
        if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
          break;
        }
        ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131297409);
        break;
        this.jdField_i_of_type_AndroidWidgetTextView.setText(2131367626);
      }
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, "");
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if ((paramBoolean2) && (w()))
      {
        g(false);
        this.X = false;
      }
      if (DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_input.name())) {
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) || (this.X)) && (w()))
        {
          g(false);
          this.X = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "initAudioPanelFlag needShowAudioWhenResume  = " + this.X);
      }
      return;
      this.X = true;
      continue;
      if ((this.X) && (w()))
      {
        g(true);
        this.X = false;
      }
    }
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt1, paramInt2);
  }
  
  private void g(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2, paramBoolean);
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if ((NetConnInfoCenter.getServerTimeMillis() - paramChatMessage.time * 1000L < 120000L) || (paramChatMessage.msgtype == 63531))
    {
      this.jdField_b_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131368037));
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(true);
      localQQMessageFacade.b(this.jdField_b_of_type_ComTencentMobileqqDataChatMessage);
      int i1 = 20000;
      if (paramChatMessage.msgtype == 63531) {
        i1 = 30000;
      }
      paramChatMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramChatMessage, i1);
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131368036)).setPositiveButton(17039370, new kpi(this)).show();
  }
  
  private void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "hidePanelExceptAudio hideAudio = " + paramBoolean + " root.getCurrentPanel() = " + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      if (((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
    do
    {
      View localView;
      do
      {
        return;
        localView = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      } while ((localView == null) || (localView.getVisibility() != 0));
      if (localView != this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel) {
        break;
      }
    } while (!paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  private void i(boolean paramBoolean)
  {
    this.U = paramBoolean;
  }
  
  private void k(Intent paramIntent)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1026)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int = paramIntent.getIntExtra("entrance", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = new QQMessageFacade.RefreshMessageContext();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject = new ChatContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int = paramIntent.getIntExtra("add_friend_source_id", 10004);
    this.dU = paramIntent.getIntExtra("enter_ext_panel", 0);
    this.dV = paramIntent.getIntExtra("ext_panel_onresume", 1);
    this.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("isBack2Root", false);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("open_chat_from_voice_changer_guide", false);
    if (!this.jdField_c_of_type_Boolean)
    {
      bool1 = true;
      this.K = bool1;
      if (paramIntent.getLongExtra("res_share_id", -1L) != -1L) {
        this.jdField_l_of_type_Boolean = paramIntent.getExtras().containsKey("res_share_id");
      }
      if (!this.jdField_l_of_type_Boolean) {
        this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("is_share_flag", false);
      }
      if ("qzoneShareTopic".equals(paramIntent.getStringExtra("share_qq_ext_str"))) {
        this.jdField_l_of_type_Boolean = false;
      }
      this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("is_from_manage_stranger", false);
      if (paramIntent.getIntExtra("aio_msg_source", 999) != 1) {
        break label395;
      }
      bool1 = true;
      label336:
      this.jdField_w_of_type_Boolean = bool1;
      if (this.jdField_w_of_type_Boolean)
      {
        this.jdField_e_of_type_Long = paramIntent.getLongExtra("searched_timeorseq", -1L);
        if (this.jdField_e_of_type_Long <= -1L) {
          break label400;
        }
      }
    }
    label395:
    label400:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_x_of_type_Boolean = bool1;
      AIOUtils.jdField_l_of_type_Boolean = false;
      this.jdField_y_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label336;
    }
  }
  
  private void l(Intent paramIntent)
  {
    boolean bool2 = true;
    j(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    Object localObject = paramIntent.getStringExtra("input_text");
    paramIntent.removeExtra("input_text");
    int i1;
    int i2;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
      i1 = 120;
      i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      if ((i2 & 0x4) == 0) {
        break label289;
      }
      i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt");
      label105:
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).getInt("Channels") != 1)
      {
        paramIntent = a();
        localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true);
        if (this.jdField_d_of_type_Boolean) {
          break label310;
        }
        bool1 = true;
        label147:
        ((Bundle)localObject).putBoolean("DoesSupportDirectlyAudio", bool1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("Channels", 1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("SampleRate", paramIntent.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("TimeLength", i1);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("sougouptt params : support = ");
          if (this.jdField_d_of_type_Boolean) {
            break label316;
          }
        }
      }
    }
    label289:
    label310:
    label316:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("Q.aio.BaseChatPie", 2, bool1 + "sample = " + paramIntent.jdField_a_of_type_Int + " max = " + i1);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.jdField_a_of_type_JavaLangObject = paramIntent;
      return;
      aD();
      break;
      if ((i2 & 0x2) == 0) {
        break label105;
      }
      i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt");
      break label105;
      bool1 = false;
      break label147;
    }
  }
  
  private void m(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(null);
    }
    long l1 = paramIntent.getLongExtra("res_share_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "updateSession_otherThings appShareId=" + l1);
    }
    if (l1 > 0L) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new kpl(this, paramIntent), 20L);
    }
  }
  
  private void n(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "doOnNewIntent_updateUI: listView.setVisibility(View.INVISIBLE)");
    }
    if (BaseChatItemLayout.jdField_b_of_type_Boolean) {
      a(false, null, false);
    }
    Bundle localBundle = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367566);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
    }
    for (;;)
    {
      this.dU = paramIntent.getIntExtra("enter_ext_panel", 0);
      this.dV = paramIntent.getIntExtra("ext_panel_onresume", 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "mEnterExtPanel = " + this.dU + ", mExtPanelOnResumeTimes = " + this.dV);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
      }
      AioAnimationDetector.a().a();
      return;
      if (localBundle != null)
      {
        this.jdField_h_of_type_Boolean = localBundle.getBoolean("isBack2Root");
        if (this.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367566);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
        }
      }
    }
  }
  
  private void o(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (this.o))
    {
      int i1 = paramIntent.getInt("aio_msg_source", 999);
      if (QLog.isDevelopLevel()) {
        QLog.d("reportEvent", 4, " AIO_MSG_SOURCE : " + i1);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), String.valueOf(i1), "", "");
    }
  }
  
  private void p(Intent paramIntent)
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().containsKey("apollo_forward_key"))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_r_of_type_Boolean);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      e(false, false);
    } while (this.X);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(0, true);
    this.K = true;
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)))
    {
      paramIntent = paramIntent.getStringExtra("input_text_redpacket");
      if (!android.text.TextUtils.isEmpty(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "chooseChatInputType redPacketExtra");
        }
        j(0);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramIntent);
        return;
      }
    }
    boolean bool2;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.jdField_d_of_type_Boolean))
    {
      paramIntent = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        bool2 = b(paramIntent);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.aio.BaseChatPie", 2, "chooseChatInputType doChooseNoC2CInputType needGuide = " + bool2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      c(false, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.aio.BaseChatPie", 2, "chooseC2CChatInputType cost :" + (System.currentTimeMillis() - l1));
      return;
      if (v())
      {
        bool2 = a(paramIntent);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.aio.BaseChatPie", 2, "chooseChatInputType doChooseC2CInputType needGuide = " + bool2);
        bool1 = bool2;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_d_of_type_Boolean) && (QLog.isColorLevel())) {
          QLog.d("Q.aio.BaseChatPie", 2, "chooseC2CChatInputType isSimpleBar = " + this.jdField_d_of_type_Boolean);
        }
      }
      bool1 = false;
    }
  }
  
  private void q(Intent paramIntent)
  {
    Object localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PreUploadVideoConfig.name(), "0|0|1.0|5|480000");
    LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig of PreUploadVideoConfig :" + (String)localObject1);
    int i6 = 0;
    int i4 = 0;
    int i8 = 0;
    int i5 = 0;
    int i7 = 0;
    int i9 = 0;
    float f3 = 0.0F;
    float f2 = 0.0F;
    long l2 = 0L;
    long l1 = l2;
    float f1 = f2;
    int i2 = i9;
    int i3 = i5;
    int i1 = i4;
    if (localObject1 != null)
    {
      l1 = l2;
      f1 = f2;
      i2 = i9;
      i3 = i5;
      i1 = i4;
      if (((String)localObject1).length() > 0)
      {
        localObject1 = ((String)localObject1).split("\\|");
        l1 = l2;
        f1 = f2;
        i2 = i9;
        i3 = i5;
        i1 = i4;
        if (localObject1 != null)
        {
          l1 = l2;
          f1 = f2;
          i2 = i9;
          i3 = i5;
          i1 = i4;
          if (localObject1.length >= 5)
          {
            f2 = f3;
            i4 = i7;
            i5 = i8;
          }
        }
      }
    }
    try
    {
      i1 = Integer.valueOf(localObject1[0]).intValue();
      f2 = f3;
      i4 = i7;
      i5 = i8;
      i6 = i1;
      i3 = Integer.valueOf(localObject1[1]).intValue();
      f2 = f3;
      i4 = i7;
      i5 = i3;
      i6 = i1;
      f1 = Float.valueOf(localObject1[2]).floatValue();
      f2 = f1;
      i4 = i7;
      i5 = i3;
      i6 = i1;
      i2 = Integer.valueOf(localObject1[3]).intValue();
      f2 = f1;
      i4 = i2;
      i5 = i3;
      i6 = i1;
      l1 = Long.valueOf(localObject1[4]).longValue();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool2;
        l1 = l2;
        f1 = f2;
        i2 = i4;
        i3 = i5;
        i1 = i6;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.aio.BaseChatPie", 2, "<BDH_LOG>get DpcConfig Erro", localNumberFormatException);
          l1 = l2;
          f1 = f2;
          i2 = i4;
          i3 = i5;
          i1 = i6;
          continue;
          bool2 = false;
          continue;
          bool1 = false;
        }
      }
      localObject2 = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label1098;
      }
    }
    LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig PreUpEnable:" + i1 + " HardEncodeEnable:" + i3 + " Limits:" + i2 + " dpcDuration:" + f1 + " dpcTimeout:" + l1);
    boolean bool3 = VideoUpConfigInfo.isPreUpload();
    boolean bool1 = VideoUpConfigInfo.sIsHardCodeEnable;
    if ((i3 == 1) && (bool1))
    {
      bool2 = true;
      LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> HardCodeEnable: " + bool2 + " DPC:" + i3 + " BDH:" + bool1);
      if (!VideoUpConfigInfo.getIsUpdated())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "<BDH_LOG>VideoUpConfigInfo is not updated");
        }
        HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        VideoUpConfigInfo.setIsUpdated();
      }
      if (!NetworkUtil.i(BaseApplication.getContext())) {
        break label809;
      }
      if ((i1 != 1) || (!bool3)) {
        break label803;
      }
      bool1 = true;
      LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> Enable: " + bool1 + " DPC:" + i1 + " BDH:" + bool3 + " isWifi");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)) {
        bool1 = false;
      }
      bool3 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)
      {
        bool3 = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)
        {
          bool3 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
          {
            bool3 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) {
              bool3 = false;
            }
          }
        }
      }
      if ((!bool3) || (!ShortVideoUploadABTest.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label1110;
      }
      paramIntent.putExtra("key_video_presend_enable", true);
      label709:
      paramIntent.putExtra("key_video_hard_encode_enable", bool2);
      paramIntent.putExtra("key_video_presend_slice_duration", f1);
      com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_b_of_type_Boolean = bool2;
      com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_c_of_type_Boolean = bool3;
    }
    label803:
    label809:
    i3 = 4;
    label825:
    Object localObject2 = ((BaseApplication)localObject2).getSharedPreferences("presend_config_sp", i3);
    l1 = ((SharedPreferences)localObject2).getLong("key_video_rollback_time", 0L);
    l2 = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "<BDH_LOG> currentTime: " + l2 + " recordTime: " + l1);
    }
    if (((l1 > 0L) && (l2 - l1 > 86400L)) || (l2 - l1 < 0L))
    {
      ((SharedPreferences)localObject2).edit().putInt("key_video_rollback_counts", 0).commit();
      ((SharedPreferences)localObject2).edit().putLong("key_video_rollback_time", 0L).commit();
    }
    i4 = ((SharedPreferences)localObject2).getInt("key_video_rollback_counts", 0);
    if (i4 >= i2) {}
    for (i3 = 0;; i3 = 1)
    {
      if ((i1 == 1) && (bool3) && (i3 != 0)) {}
      for (bool1 = true;; bool1 = false)
      {
        LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> Enable: " + bool1 + " DPC:" + i1 + " BDH:" + bool3 + " limits:" + i2 + " recordCounts:" + i4 + " not Wifi");
        break;
        label1098:
        i3 = 0;
        break label825;
      }
      label1110:
      paramIntent.putExtra("key_video_presend_enable", false);
      break label709;
    }
  }
  
  private void r(int paramInt)
  {
    boolean bool2 = true;
    int i2 = 0;
    boolean bool1;
    int i1;
    if (paramInt > 0)
    {
      bool1 = true;
      this.N = bool1;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label110;
      }
      i1 = 1;
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sendback", 2, "onPreSetReadConfirm_AIOEggs hasUnreadCount=" + paramInt + "isC2C=" + bool1);
      }
      if ((i1 == 0) && (!bool1))
      {
        return;
        bool1 = false;
        break;
        label110:
        if (!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          break label434;
        }
        i1 = 0;
        bool1 = bool2;
        continue;
      }
      Object localObject;
      int i3;
      ChatMessage localChatMessage;
      long l2;
      if (this.N)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        i3 = ((List)localObject).size();
        if (i2 >= i3) {
          break label426;
        }
        localChatMessage = (ChatMessage)((List)localObject).get(i2);
        if (!localChatMessage.isread) {
          if (i1 != 0) {
            l2 = localChatMessage.shmsgseq;
          }
        }
      }
      for (;;)
      {
        label210:
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.aio.BaseChatPie", 2, "onPreSetReadConfirm_AIOEggs hasUnreadCount=" + paramInt + "totalList count=" + i3);
          l1 = l2;
        }
        for (;;)
        {
          label261:
          if (QLog.isColorLevel()) {
            QLog.d(AioAnimationDetector.jdField_a_of_type_JavaLangString, 2, "onPreSetReadConfirm_AIOEggs: hasUnread=" + this.N + ", lastMsgTimeOrSeq=" + l1);
          }
          localObject = AioAnimationDetector.a();
          ((AioAnimationDetector)localObject).jdField_a_of_type_Boolean = this.N;
          ((AioAnimationDetector)localObject).jdField_a_of_type_Long = l1;
          if (this.N) {}
          for (;;)
          {
            ChatActivityFacade.jdField_a_of_type_Long = l1;
            return;
            l2 = localChatMessage.time;
            break label210;
            i2 += 1;
            break;
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (localObject == null) {
              break label418;
            }
            if (i1 != 0)
            {
              l1 = ((QQMessageFacade.Message)localObject).shmsgseq;
              break label261;
            }
            l1 = ((QQMessageFacade.Message)localObject).time;
            break label261;
            l1 += 1L;
          }
          label418:
          l1 = -1L;
        }
        label426:
        l2 = -1L;
      }
      label434:
      bool1 = false;
      i1 = 0;
    }
  }
  
  private void s(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_j_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_j_of_type_AndroidWidgetTextView.setText(Integer.toString(paramInt));
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (paramInt <= 0)
    {
      if ((this.jdField_j_of_type_AndroidWidgetTextView != null) && (BaseChatItemLayout.jdField_b_of_type_Boolean)) {
        this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_j_of_type_AndroidWidgetTextView == null)
    {
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setId(2131296339);
      ((TextView)localObject1).setBackgroundResource(2130837687);
      ((TextView)localObject1).setGravity(1);
      ((TextView)localObject1).setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 16.0F);
      ((TextView)localObject1).setOnClickListener(this);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131297409);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      localObject1 = this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297418);
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront((View)localObject1);
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131296339);
      }
    }
    Object localObject2 = this.jdField_j_of_type_AndroidWidgetTextView;
    if (paramInt > 99) {}
    for (Object localObject1 = "99";; localObject1 = Integer.toString(paramInt))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
    }
  }
  
  private void t(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
  }
  
  private void u(int paramInt)
  {
    r(paramInt);
  }
  
  private boolean v()
  {
    boolean bool = false;
    int i1 = 0;
    for (;;)
    {
      if ((i1 >= MsgProxyUtils.q.length) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == MsgProxyUtils.q[i1]))
      {
        if (i1 < MsgProxyUtils.q.length) {
          bool = true;
        }
        return bool;
      }
      i1 += 1;
    }
  }
  
  private boolean w()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (!this.jdField_w_of_type_Boolean);
  }
  
  public void A()
  {
    this.jdField_r_of_type_Int = 5;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnStop", hashCode(), this.jdField_r_of_type_Int);
    this.o = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)) {
      ac();
    }
    ap();
    aE();
    QQLiveImage.pauseAll();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow() != null)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().setSoftInputMode(32);
    }
  }
  
  public void B()
  {
    this.jdField_r_of_type_Int = 4;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnPause", hashCode(), this.jdField_r_of_type_Int);
    ArkContainerWrapper.a(0);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (!o()) {
      AbstractVideoImage.pauseAll();
    }
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      a(true);
    }
    ThreadManager.a(new kmr(this), 5, null, false);
    if (this.M) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.c();
    }
    this.o = false;
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).c();
    if (this.O)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.O = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
  }
  
  public void C()
  {
    boolean bool = true;
    StartupTracker.a(null, "AIO_doOnResume_updateUI");
    ArkContainerWrapper.a(1);
    ThreadManager.a(new kms(this), null, true);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.postDelayed(new kmt(this), 2000L);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getVisibility() == 0)) {
      this.jdField_s_of_type_Int = 0;
    }
    PatchedButton localPatchedButton;
    if ((this.jdField_a_of_type_ComTencentWidgetPatchedButton != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null))
    {
      localPatchedButton = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
        break label178;
      }
    }
    for (;;)
    {
      localPatchedButton.setEnabled(bool);
      StartupTracker.a("AIO_doOnResume_updateUI", null);
      return;
      label178:
      bool = false;
    }
  }
  
  public void D()
  {
    this.jdField_r_of_type_Int = 3;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnResume", hashCode(), this.jdField_r_of_type_Int);
    C();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.u)
    {
      AIOUtils.a(true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        PAStartupTracker.a(null, "pubAcc_structMsg_display", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      K();
      i(true);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 800L);
    }
    for (;;)
    {
      this.u = false;
      if (DeviceProfileManager.jdField_b_of_type_Boolean) {
        aL();
      }
      this.O = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this);
      StructMsgVideoController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      NowVideoController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      QQLSRecentManager.jdField_f_of_type_Boolean = true;
      ThreadRegulator.a().a(1, 1500L);
      return;
      a(131072);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onShow right now");
      }
      W();
    }
  }
  
  public void E()
  {
    PerformanceReportUtils.a();
    AIOUtils.a(false);
    this.U = false;
    this.T = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = false;
    this.L = true;
    this.jdField_f_of_type_Int = 0;
    this.jdField_l_of_type_Boolean = false;
    this.M = false;
    this.N = false;
    this.jdField_m_of_type_Boolean = false;
    this.n = false;
    this.o = false;
    this.p = false;
    this.jdField_r_of_type_Boolean = false;
    this.q = false;
    this.jdField_s_of_type_Boolean = true;
    this.t = false;
    this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.D = false;
    this.E = true;
    this.X = false;
    this.Y = true;
    this.F = false;
    this.S = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.J = false;
    this.jdField_d_of_type_Boolean = false;
    this.v = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_e_of_type_AndroidWidgetTextView = null;
      this.jdField_i_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_c_of_type_AndroidWidgetLinearLayout);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_k_of_type_AndroidWidgetTextView = null;
      this.jdField_l_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
    }
    this.jdField_e_of_type_Long = 0L;
    this.jdField_x_of_type_Boolean = false;
    this.V = true;
  }
  
  public void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "return MainFragment");
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
      localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      localFragmentTransaction.setCustomAnimations(2130968630, 2130968627);
      SplashActivity.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("isFromAioFragment", true);
      if (localFragment != null)
      {
        localFragmentTransaction.show(localFragment);
        localFragmentTransaction.hide((Fragment)localObject);
        if ((localObject != null) && (((ChatFragment)localObject).a != null)) {
          ((ChatFragment)localObject).a.a(false, 450);
        }
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
    while (!QLog.isDevelopLevel()) {
      for (;;)
      {
        Object localObject;
        FragmentTransaction localFragmentTransaction;
        Fragment localFragment;
        return;
        localFragmentTransaction.add(16908290, MainFragment.a(), MainFragment.class.getName());
      }
    }
    QLog.d("Q.aio.BaseChatPie", 4, "returnMainFragment() mActivity instanceof ChatActivity ");
  }
  
  public void G()
  {
    AudioUtil.b(2131165191, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
  }
  
  public void H()
  {
    try
    {
      if (this.eg == 0)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
        localIntentFilter.addAction("android.intent.action.PHONE_STATE");
        localIntentFilter.addAction("vivo_smart_shot_enter");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.eg = 1;
      }
      for (;;)
      {
        AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "AIOTime doOnRegReceivers");
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "registerReceiver but done");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "registerReceiver " + localException);
        }
      }
    }
  }
  
  public void I()
  {
    try
    {
      if (this.eg == 1)
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.eg = 0;
      }
      for (;;)
      {
        AppNetConnInfo.unregisterNetInfoHandler(this);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "AIOTime doOnUnRegReceivers");
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "unRegisterReceiver but cannot");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "unregisterReceiver:" + localException);
        }
      }
    }
  }
  
  public void J()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_b_of_type_Int = 0;
    this.L = true;
  }
  
  public void K()
  {
    if (this.U) {}
    label7:
    do
    {
      do
      {
        return;
        ag();
        aP();
      } while ((this.jdField_g_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null));
      this.T = false;
    } while (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "refreshListAdapter: listView.setVisibility(View.VISIBLE)");
    }
    List localList1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    int i11 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
    int i7 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s() - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0).getTop();
    }
    int i9 = this.jdField_g_of_type_Int;
    Object localObject1;
    int i4;
    int i10;
    int i2;
    int i3;
    long l1;
    switch (this.jdField_g_of_type_Int & 0xFFFF0000)
    {
    default: 
    case 65536: 
      for (localObject1 = localList1;; localObject1 = localList1)
      {
        i4 = this.dQ;
        i10 = localList1.size();
        i2 = ((List)localObject1).size();
        i3 = 0xFFFF & this.jdField_g_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("update1", 2, "refreshlistadapter dirtyFlag=" + i3);
        }
        if ((!this.jdField_x_of_type_Boolean) || (!this.V)) {
          break label1350;
        }
        i3 = 7;
        if (QLog.isColorLevel()) {
          QLog.d("update1", 2, "refreshlistadapter after set dirtyFlag=" + i3);
        }
        switch (i3)
        {
        case 4: 
        default: 
          if (localList1 == localObject1) {
            break label2483;
          }
          if ((i10 <= 0) || (i2 <= 0)) {
            break label2490;
          }
          l1 = ((ChatMessage)localList1.get(i10 - 1)).uniseq;
          i1 = i2 - 1;
          if (i1 < 0) {
            break label2490;
          }
          if ((i1 != i2 - 1) || (!UniteGrayTipUtil.a((MessageRecord)((List)localObject1).get(i1)))) {
            break label2121;
          }
          i1 = -1;
          label437:
          if (i1 < 0) {
            break label2153;
          }
          i1 = i2 - (i10 - this.dQ + i2 - 1 - i1);
          label462:
          if (i3 != 5) {
            break label2184;
          }
          i1 = this.dQ;
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m(), -1, null);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, this.jdField_a_of_type_AndroidContentContext.getString(2131364630), 3000).b(a());
          i1 = i2 - (i10 - i1);
          label532:
          this.jdField_g_of_type_Int = 0;
          this.jdField_h_of_type_Long = SystemClock.uptimeMillis();
          this.dQ = i1;
          switch (i9 & 0xFFFF0000)
          {
          default: 
            label584:
            if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
            {
              localObject1 = (MessageForShakeWindow)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1);
              if (!((MessageForShakeWindow)localObject1).isSendFromLocal()) {
                break label2322;
              }
              this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new knk(this, (MessageForShakeWindow)localObject1), 20L);
              label654:
              this.jdField_b_of_type_JavaUtilList.clear();
            }
            if (i1 != i2) {
              break label7;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
          }
          break;
        }
      }
    }
    List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b(localList2);
    }
    Object localObject4;
    Object localObject3;
    if ((this.N) && (localList2.size() > 0))
    {
      localObject4 = (ChatMessage)localList2.get(localList2.size() - 1);
      if (!((ChatMessage)localObject4).isSend()) {
        ((ChatMessage)localObject4).mAnimFlag = true;
      }
      ((ChatMessage)localObject4).mPendantAnimatable = true;
      if ((localObject4 instanceof MessageForMarketFace))
      {
        localObject3 = ((MessageForMarketFace)localObject4).mMarkFaceMessage;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          ((ChatMessage)localObject4).parse();
          localObject1 = ((MessageForMarketFace)localObject4).mMarkFaceMessage;
        }
        if (((((MarkFaceMessage)localObject1).mobileparam != null) && (((MarkFaceMessage)localObject1).mobileparam.length > 0)) || ((((MarkFaceMessage)localObject1).mediaType == 3) && (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))) {
          ((MessageForMarketFace)localObject4).needToPlay = true;
        }
      }
    }
    if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      localObject3 = ChatActivityUtils.b(localList2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      label923:
      if (this.jdField_a_of_type_Boolean)
      {
        if ((1000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (localObject3 != null) || (localList2.size() != 0)) {
          break label1281;
        }
        localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString);
        label976:
        if (localObject1 == null) {
          break label1342;
        }
        b(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        if (I) {
          this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject4 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject3);
      if (1000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
        localObject3 = localObject4;
        if (1004 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {}
      }
      else
      {
        localObject1 = localObject4;
        if (localList2.size() >= 15)
        {
          localObject1 = localObject4;
          if (!((ChatMessage)localList2.get(0)).mNeedGrayTips) {
            localObject1 = null;
          }
        }
        localObject3 = localObject1;
        if (!localList2.isEmpty())
        {
          localObject3 = localObject1;
          if (((ChatMessage)localList2.get(0)).mMessageSource == null)
          {
            localObject3 = localObject1;
            if (((ChatMessage)localList2.get(0)).mNeedGrayTips)
            {
              localObject3 = localObject1;
              if (localObject1 == null)
              {
                ((ChatMessage)localList2.get(0)).mNeedGrayTips = false;
                localObject3 = localObject1;
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        localObject1 = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
        if (((TroopBindPublicAccountMgr)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ((TroopBindPublicAccountMgr)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localList2);
        }
      }
      a(localList2, (CharSequence)localObject3);
      s();
      ChatFragment.a(true);
      this.jdField_d_of_type_AndroidViewViewGroup.invalidate();
      localObject1 = localList2;
      break;
      localObject3 = ChatActivityUtils.a(localList2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label923;
      label1281:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025))
      {
        localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        break label976;
      }
      localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label976;
      label1342:
      b(false);
    }
    label1350:
    int i5;
    int i6;
    if (i3 == 0)
    {
      i5 = 0;
      i1 = 0;
      i6 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t() >= 0)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1);
        if (localObject3 != null) {
          i1 = ((View)localObject3).getBottom();
        }
        int i8 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
        i5 = i1;
        i6 = i8;
        if (QLog.isColorLevel())
        {
          QLog.d("update1", 2, "refreshlistadapter=====lastbuttom=" + i1 + " listHeight=" + i8);
          i6 = i8;
          i5 = i1;
        }
      }
      if ((i5 > i6) || (i3 != 0)) {
        break label2506;
      }
    }
    label1758:
    label1840:
    label1932:
    label2121:
    label2153:
    label2184:
    label2209:
    label2322:
    label2483:
    label2490:
    label2496:
    label2506:
    for (int i1 = 1;; i1 = i3)
    {
      i3 = i1;
      break;
      if (s()) {
        break;
      }
      i3 = 0;
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new kng(this), 300L);
      }
      for (;;)
      {
        i1 = i2;
        break;
        this.ed += 1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "[refreshListAdapter]: refreshBottomCount=" + this.ed + ",refreshDelayForNextPie=" + R);
        }
        if (R)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new knh(this));
          R = false;
        }
        else if (this.ed == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.d_() - 1, 0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new knj(this));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.a();
      i1 = i2;
      break label462;
      if ((i10 > 0) && (i7 >= 0))
      {
        i5 = -1;
        i4 = i5;
        if (i2 <= 0) {
          break label2496;
        }
        i6 = i7;
        if (i7 >= localList1.size()) {
          i6 = localList1.size() - 1;
        }
        l1 = ((ChatMessage)localList1.get(i6)).uniseq;
        i4 = 0;
        i1 = i5;
        if (i4 < i2)
        {
          if (((ChatMessage)((List)localObject1).get(i4)).uniseq == l1) {
            i1 = i4;
          }
        }
        else
        {
          i4 = i1;
          if (i1 >= 0) {
            break label2496;
          }
          i4 = i1;
          if (localList1.size() <= i6 + 1) {
            break label2496;
          }
          l1 = ((ChatMessage)localList1.get(i6 + 1)).uniseq;
          i5 = 0;
          i4 = i1;
          if (i5 >= i2) {
            break label2496;
          }
          if (((ChatMessage)((List)localObject1).get(i5)).uniseq != l1) {
            break label1932;
          }
        }
      }
      for (i4 = 1;; i4 = 0)
      {
        if (i5 >= 0)
        {
          i6 = this.dQ + i5;
          i1 = i6;
          if (i4 != 0) {
            i1 = i6 - 1;
          }
          if ((i11 < 0) && (i5 == 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.H();
            break label462;
            i4 += 1;
            break label1758;
            i5 += 1;
            break label1840;
          }
          if (i11 < 0)
          {
            i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
            try
            {
              i6 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m()).getBottom();
              i4 -= i6;
            }
            catch (NullPointerException localNullPointerException1)
            {
              for (;;)
              {
                i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.J();
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(i5 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m(), i4 + i11);
            break label462;
          }
          i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
          try
          {
            i6 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m()).getBottom();
            i4 -= i6;
          }
          catch (NullPointerException localNullPointerException2)
          {
            for (;;)
            {
              i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(i5 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m(), i4);
          break label462;
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.J();
        i1 = i2;
        break label462;
        aF();
        i1 = i4;
        break label462;
        if (((ChatMessage)localNullPointerException2.get(i1)).uniseq == l1) {
          break label437;
        }
        i1 -= 1;
        break;
        if ((i2 > 0) && (!UniteGrayTipUtil.a((MessageRecord)localNullPointerException2.get(i2 - 1))))
        {
          i1 = i2;
          break label462;
          if (i3 == 6)
          {
            i4 = this.dQ;
            i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
            i1 = 0;
            Object localObject2;
            if (i1 < i3)
            {
              localObject2 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1);
              if ((localObject2 == null) || (((ChatMessage)localObject2).msgtype != 61527)) {}
            }
            for (;;)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
              if (i1 == 0) {}
              for (i3 = 0;; i3 = -1)
              {
                ((ScrollerRunnable)localObject2).a(i1, i3, null);
                i1 = i2 - (i10 - i4);
                break;
                i1 += 1;
                break label2209;
              }
              if (!this.p) {
                break label584;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1001, new Object[0]);
              this.p = false;
              break label584;
              l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.shakemsg", 2, "time is:" + System.currentTimeMillis() + ",shmsgseq is:" + ((MessageForShakeWindow)localObject2).shmsgseq + ",msgUid is:" + ((MessageForShakeWindow)localObject2).msgUid + ",uniseq is:" + ((MessageForShakeWindow)localObject2).uniseq + ",onlineStatus is:" + l1 + ",userActiveStatus is:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.cq);
              }
              if ((l1 != 11L) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.cq != 0)) {
                break label654;
              }
              this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new knl(this, (MessageForShakeWindow)localObject2), 20L);
              break label654;
              i1 = 0;
            }
          }
          break label532;
        }
        i1 = i4;
        break label462;
        i1 = -1;
        break label437;
        i5 = i4;
      }
    }
  }
  
  public void L()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a().getCount() - 1);
    }
  }
  
  protected void M()
  {
    ArkContainerWrapper.a(2);
    ThreadPriorityManager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b();
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a();
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void N()
  {
    if (this.A) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "leftBackEvent() disableBackForPTV true");
      }
    }
    while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      a(1);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  void O()
  {
    SVIPHandler localSVIPHandler = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
    if (localSVIPHandler.a()) {
      localSVIPHandler.b();
    }
  }
  
  public void P()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_Boolean = false;
      if (ChatBackground.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  public void Q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public void R()
  {
    d(true, this.jdField_j_of_type_Boolean);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(128);
  }
  
  public void S()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setVolumeControlStream(3);
    d(false, false);
    u();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(128);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void T()
  {
    int i2 = 0;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && ((this.jdField_a_of_type_AndroidContentContext == null) || (((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i1;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i1 = 2131367640;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getString(i1));
        if (i2 == 0) {
          break label247;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427492), this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427493)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, "权限提示", (CharSequence)localObject, 0, 2131369401, null, null, new knp(this)).show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.aio.BaseChatPie", 2, "show showAbnormalRecordDlg error : " + localException.getMessage());
      return;
      if (localException.equalsIgnoreCase("xiaomi"))
      {
        i1 = 2131367641;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i1 = 2131367642;
      }
      else
      {
        i1 = 2131367639;
        i2 = 1;
      }
    }
    label247:
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, "权限提示", localException.toString(), "我知道了", "", null, new knq(this)).show();
  }
  
  public void U()
  {
    if (this.Y)
    {
      h();
      this.Y = false;
    }
  }
  
  public void V()
  {
    int i2 = 1;
    for (;;)
    {
      try
      {
        localObject = BaseApplicationImpl.a().getSharedPreferences("CrashControl_com.tencent.mobileqq:peak", 4);
        i1 = i2;
        if (localObject != null)
        {
          i1 = i2;
          if (!((SharedPreferences)localObject).getBoolean("allowpreload", true))
          {
            long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
            i1 = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
            long l2 = System.currentTimeMillis();
            if ((l1 <= 0L) || (i1 <= 0) || (l2 <= l1) || (l2 - l1 <= i1 * 1000)) {
              continue;
            }
            ((SharedPreferences)localObject).edit().putBoolean("allowpreload", true).commit();
            i1 = i2;
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject;
          boolean bool;
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actNoPreloadPeak", true, 0L, 0L, null, "");
          i1 = 0;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i1 = 0;
          }
        }
        localException1 = localException1;
        i1 = 1;
      }
      if (i1 != 0)
      {
        if (PeakUtils.a == null)
        {
          PeakUtils.a = new PreloadProcHitSession("peak_preload", "com.tencent.mobileqq:peak");
          PeakUtils.a.a();
        }
        ThreadManager.b().post(new knx(this));
      }
      bool = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onShow_otherThings, isPhotoPlusEditSend = " + bool);
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().removeExtra("PhotoConst.SEND_FLAG");
        AIOPanelUtiles.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      }
      ThreadManager.b().post(new kny(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(31, 800L);
      aM();
      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      BubbleDiyFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
      a(BaseApplication.getContext(), "com.vivo.smartshot");
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "isvivo has shot" + ee);
      }
      if (!DeviceProfileManager.jdField_b_of_type_Boolean) {
        aL();
      }
      AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, null);
      a((int)(5.0F * this.jdField_a_of_type_Float + 0.5F), (int)(5.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null)
      {
        localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("panel");
        if ((localObject != null) && (((String)localObject).equals("ptv")))
        {
          av();
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().removeExtra("panel");
        }
      }
      return;
      QLog.d("Q.aio.BaseChatPie", 1, "preloadPeakProcess is not allowed as crash frequently.");
      localException1.printStackTrace();
    }
  }
  
  public void W()
  {
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_end", null, false, null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "AIOTime onShow start");
    }
    StartupTracker.a(null, "AIO_onShow");
    StartupTracker.a(null, "AIO_onShow_emotion");
    aI();
    StartupTracker.a("AIO_onShow_emotion", null);
    U();
    StartupTracker.a(null, "AIO_onShow_updateUI");
    aK();
    StartupTracker.a("AIO_onShow_updateUI", "AIO_onShow_videoStatus");
    aJ();
    StartupTracker.a("AIO_onShow_videoStatus", "AIO_onShow_report");
    o(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_onShow_report", "AIO_onShow_otherThings");
    V();
    StartupTracker.a("AIO_onShow_otherThings", "AIO_onShow_setReaded");
    aN();
    StartupTracker.a("AIO_onShow_setReaded", null);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().b();
      ApolloActionManager.a().c();
    }
    ThreadPriorityManager.a(false);
    StartupTracker.a("AIO_onShow", null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "AIOTime onShow end");
    }
  }
  
  protected void X()
  {
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "initAndQueryFastImage start! ");
    }
    if (!this.jdField_g_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "initAndQueryFastImage return!,  mAllowFastImage = " + this.jdField_g_of_type_Boolean);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout = ((FastImagePreviewLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130903077, null));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(2, 2131297409);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(7, 2131297409);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.rightMargin = ((int)(10.5D * this.jdField_a_of_type_Float + 0.5D));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = ((int)(4.0F * this.jdField_a_of_type_Float + 0.5F));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setId(2131296467);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setHandler(this.jdField_a_of_type_MqqOsMqqHandler);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.b();
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "initAndQueryFastImage end! ");
  }
  
  public void Y()
  {
    AioAnimationDetector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
  
  protected void Z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == null) {}
    TroopGagMgr.SelfGagInfo localSelfGagInfo;
    do
    {
      return;
      localSelfGagInfo = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
    if (this.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131296439);
      localTextView.setBackgroundResource(2130843013);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setTextColor(-7829368);
      localTextView.setEnabled(false);
      localTextView.setGravity(17);
      int i1 = ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).indexOfChild(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.weight = 1.0F;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localTextView, i1, localLayoutParams);
      this.jdField_d_of_type_AndroidWidgetTextView = localTextView;
    }
    if (localSelfGagInfo != null)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(localSelfGagInfo.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
    if (VersionUtils.e())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 0.6F);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
    }
    this.jdField_k_of_type_Int = 2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908);
  }
  
  protected Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 230: 
      this.jdField_c_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131558973);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2130903241);
      localTextView1 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131297840);
      localObject = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131296852);
      TextView localTextView2 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131297843);
      TextView localTextView3 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131297844);
      localTextView1.setText(2131369320);
      ((TextView)localObject).setText(2131369323);
      localTextView3.setText(2131369322);
      localTextView3.setOnClickListener(new kmz(this));
      localTextView2.setText(2131367262);
      localTextView2.setOnClickListener(new kna(this));
      return this.jdField_c_of_type_AndroidAppDialog;
    case 231: 
      this.jdField_d_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131558973);
      this.jdField_d_of_type_AndroidAppDialog.setContentView(2130903052);
      ((TextView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131296852)).setText(2131369316);
      return this.jdField_d_of_type_AndroidAppDialog;
    case 232: 
      this.jdField_e_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131558973);
      this.jdField_e_of_type_AndroidAppDialog.setContentView(2130905040);
      localTextView1 = (TextView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131298715);
      localObject = (ImageView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131296844);
      localTextView1.setText(2131367716);
      ((ImageView)localObject).setImageResource(2130838452);
      return this.jdField_e_of_type_AndroidAppDialog;
    }
    this.jdField_f_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131558973);
    this.jdField_f_of_type_AndroidAppDialog.setContentView(2130905040);
    TextView localTextView1 = (TextView)this.jdField_f_of_type_AndroidAppDialog.findViewById(2131298715);
    Object localObject = (ImageView)this.jdField_f_of_type_AndroidAppDialog.findViewById(2131296844);
    localTextView1.setText(2131367715);
    ((ImageView)localObject).setImageResource(2130838442);
    return this.jdField_f_of_type_AndroidAppDialog;
  }
  
  public View a(int paramInt)
  {
    long l1;
    if (paramInt == 8)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903082, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
    }
    if (paramInt == 3)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903333, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, a(), this.jdField_f_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    if (paramInt == 2)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = ((AudioPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130904069, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (InputLinearLayout)this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
      n(-1);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenAudioPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    }
    if (paramInt == 4)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, false);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    }
    if (paramInt == 14)
    {
      if (!q()) {
        return null;
      }
      l1 = System.currentTimeMillis();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, true);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenFlashPicPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    }
    if (paramInt == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel = new AIOFakePanel(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel;
    }
    if (paramInt == 21)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel = ((ApolloPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903074, null));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      StartupTracker.a("apollo_panel_open", null);
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel;
    }
    return null;
  }
  
  public ViewGroup a()
  {
    return this.jdField_d_of_type_AndroidViewViewGroup;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public StructingMsgItemBuilder.ViewCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache;
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  public BaseActivity a(FragmentActivity paramFragmentActivity)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public EmoticonMainPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public MagicfaceViewController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = new MagicfaceViewController(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  }
  
  public QQRecorder.RecorderParam a()
  {
    return new QQRecorder.RecorderParam(RecordParams.jdField_f_of_type_Int, 0, 0);
  }
  
  @Deprecated
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    this.jdField_r_of_type_Int = 1;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnCreate", hashCode(), this.jdField_r_of_type_Int);
    this.F = false;
    this.T = false;
    this.U = false;
    this.u = true;
    this.G = false;
    this.B = false;
    this.D = false;
    this.v = false;
    AIOUtils.a(false);
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_begin", null, false, null);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    StartupTracker.a(null, "AIO_doOnCreate_initUI");
    e();
    StartupTracker.a("AIO_doOnCreate_initUI", "AIO_doOnCreate_initData");
    g();
    StartupTracker.a("AIO_doOnCreate_initData", "AIO_updateSession");
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
    if ((paramInt1 == 2) && (paramInt2 != 2)) {
      z = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) {
      return;
    }
    ((View)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).post(new kpy(this, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "[doOnActivityResult], requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
    }
    boolean bool2 = false;
    j();
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getExtras() != null) {
        bool1 = paramIntent.getExtras().getBoolean("progress2View");
      }
    }
    if (paramInt1 == 2) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setCanLock(false);
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
      {
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          localObject1 = paramIntent.getExtras();
          localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
          ((Intent)localObject2).putExtras(new Bundle((Bundle)localObject1));
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject2);
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(4, paramIntent);
      }
      if ((paramInt1 == 21) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
        a(false, null, false);
      }
      return;
      if (paramInt1 == 4001)
      {
        EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramIntent);
      }
      else if ((paramInt1 == 103) && (!bool1))
      {
        a(false, true);
      }
      else if ((paramInt1 == 101) && (paramInt2 != -1))
      {
        a(false, false);
      }
      else if ((paramInt1 == 4779) && (paramInt2 == 8213))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(17);
      }
      else if ((paramInt1 == 4813) && (paramInt2 == 8213))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(18);
      }
      else if (paramInt1 == 9999)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "isActionBack");
          }
          ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 128, "apolloPanel");
        }
      }
      else
      {
        int i1;
        if (paramInt1 == 11000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("faceGuide", 2, "onActivityResult = =" + paramInt1 + "resultCode" + paramInt2);
          }
          if (BaseApplicationImpl.a().getSharedPreferences("faceu_reddot_click_sp", 4).getBoolean("faceu_reddot_click_sp", false))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(6, false);
            PanelIconLinearLayout.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
          }
          this.A = false;
          this.W = false;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(5, true);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(6, true);
          if (1000 == paramInt2)
          {
            i1 = paramIntent.getIntExtra("click_item", 1);
            if ((i1 == 9) || (i1 == 10) || (i1 == 14)) {
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
            }
            if (QLog.isColorLevel()) {
              QLog.d("XPanel", 2, "onActivityResult = setPanel=" + i1);
            }
            a(Integer.valueOf(i1));
          }
          else if (1001 == paramInt2)
          {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
        }
        else if (paramInt1 == 13002)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "onActivityResulte() REQUEST_OPEN_SHORT_VIDEO_PLAYER...");
          }
          a(false, false);
        }
        else if (paramInt1 == 13005)
        {
          long l1 = 0L;
          if (paramIntent != null) {
            l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", 0L);
          }
          if (StructMsgVideoController.a().a())
          {
            StructMsgVideoController.a().jdField_c_of_type_Int = ((int)l1);
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "onActivityResult() REQUEST_OPEN_PUBLIC_ACCOUNT_VIDEO_PLAY_ACTIVITY...,playPosition=" + l1);
            }
          }
        }
        else if (paramInt1 == 13006)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "onActivityResult() REQUEST_OPEN_REACTIVE_SETTING");
          }
          aB();
        }
        else if (paramInt2 == -1)
        {
          switch (paramInt1)
          {
          default: 
            break;
          case 0: 
            a(false, false);
            break;
          case 18: 
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy.a();
              this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = null;
            }
            if (paramIntent != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("LBS", 2, "onActivityResult ChatActivityConstants.LBS_REQUEST");
              }
              Object localObject3 = paramIntent.getExtras();
              if (localObject3 != null)
              {
                localObject1 = ((Bundle)localObject3).getString("latitude");
                localObject2 = ((Bundle)localObject3).getString("longitude");
                String str1 = ((Bundle)localObject3).getString("description");
                String str2 = ((Bundle)localObject3).getString("title");
                String str3 = ((Bundle)localObject3).getString("summary");
                localObject3 = ((Bundle)localObject3).getString("dianping_id");
                ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject2, str1, str2, str3, (String)localObject3);
              }
            }
            break;
          case 1: 
            localObject1 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).getString("camera_photo_path", "");
            if ("".equals(localObject1))
            {
              QLog.d("Q.aio.BaseChatPie", 1, "camera result null");
              return;
            }
            if ((paramIntent != null) && (paramIntent.getBooleanExtra("is_custom_camera", false)))
            {
              bool1 = true;
              localObject2 = ((IPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(26)).a("Photoplus.apk");
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.BaseChatPie", 2, "on camera result plugin state " + ((PluginBaseInfo)localObject2).mState);
              }
              if ((localObject2 == null) || (((PluginBaseInfo)localObject2).mState != 4)) {
                break label1283;
              }
              if (!bool1) {
                break label1277;
              }
            }
            for (i1 = 101;; i1 = 1)
            {
              PhotoMagicStickUtils.a((String)localObject1, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, false, i1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(), "", true);
              break;
              bool1 = false;
              break label1159;
            }
            if ((localObject2 != null) && ((((PluginBaseInfo)localObject2).mState == 3) || (((PluginBaseInfo)localObject2).mState == 2)))
            {
              localObject2 = new Intent(BaseApplicationImpl.a, PhotoPlusBridgeActivity.class);
              ((Intent)localObject2).putExtra("photo_path", (String)localObject1);
              ((Intent)localObject2).putExtra("iswaitforsult", true);
              ((Intent)localObject2).putExtra("type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              ((Intent)localObject2).putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
              ((Intent)localObject2).putExtra("headDir", "");
              ((Intent)localObject2).putExtra("is_custom_camera", bool1);
              this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject2, 100011);
            }
            else
            {
              ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, paramIntent, 1);
            }
            break;
          case 10: 
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt1, paramIntent, 10);
            break;
          case 3: 
            j(paramIntent);
            break;
          case 20: 
            a(true, false);
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(1024);
            break;
          case 21: 
            paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131367566));
            a(paramIntent.getExtras());
            break;
          case 2000: 
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "onActivityResult() ENTER_CHATOPTION_REQUEST");
            }
            aB();
            bool2 = false;
            bool1 = bool2;
            if (paramIntent != null)
            {
              bool1 = bool2;
              if (paramIntent.getExtras() != null) {
                bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
              }
            }
            if (bool1) {
              a(1);
            } else {
              a(false, false);
            }
            break;
          case 5: 
            switch (paramInt2)
            {
            }
          case 4: 
            while ((paramIntent != null) && ("AioVIP".equals(paramIntent.getStringExtra("callbackSn"))))
            {
              break;
              L();
            }
          case 100011: 
            if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.BaseChatPie", 2, "onActivityResult, REQUEST_CODE_PHOTO_EDIT_FROM_CAMERA, activity: " + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getClass().getName() + ", intent extras:" + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() + ", SplashActivity.currentFragment: " + SplashActivity.jdField_c_of_type_Int);
              }
              if ((SplashActivity.jdField_c_of_type_Int == 2) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("open_chatfragment", false))) {
                AIOUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), null);
              }
            }
            if ((paramIntent != null) && (paramIntent.getBooleanExtra("is_custom_camera", false)))
            {
              i1 = 1;
              if (i1 == 0) {
                break label1888;
              }
            }
            for (i1 = 101;; i1 = 1)
            {
              localObject1 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).getString("camera_photo_path", "");
              this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
              PhotoMagicStickUtils.a((String)localObject1, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, false, i1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(), "", true);
              this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(2130968620, 2130968621);
              break;
              i1 = 0;
              break label1794;
            }
          case 100003: 
          case 100004: 
          case 100005: 
          case 100006: 
          case 100008: 
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramInt1, paramIntent);
            }
            break;
          case 110: 
            if (paramIntent != null)
            {
              localObject1 = paramIntent.getStringExtra("roomId");
              if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
              {
                localObject2 = paramIntent.getStringArrayListExtra("qqPhoneUserList");
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject1, true, true, true, null, (ArrayList)localObject2, 1, 0);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 3, 0, "", "", "", "");
              }
            }
            break;
          case 9009: 
            if (paramIntent != null)
            {
              localObject1 = paramIntent.getStringExtra("nearby_profile_nickname");
              if ((localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString)))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ((String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.aio.BaseChatPie", 2, "onActivityResult new nick is " + (String)localObject1);
                }
                this.jdField_a_of_type_MqqOsMqqHandler.post(new kmy(this));
              }
            }
            break;
          case 85: 
            label1159:
            label1277:
            label1283:
            label1794:
            label1888:
            if (paramIntent != null) {
              ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), false);
            }
            break;
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new knb(this), 1000L);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(int paramInt, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    if ((this.U) && (this.jdField_g_of_type_Int == paramInt)) {
      return;
    }
    int i1 = paramInt & 0xFFFF0000;
    if ((paramInt & 0xFFFF) > (this.jdField_g_of_type_Int & 0xFFFF)) {
      paramInt &= 0xFFFF;
    }
    Message localMessage;
    long l1;
    for (;;)
    {
      this.jdField_g_of_type_Int = (paramInt | i1);
      if ((!o()) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 6) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 5)) {
        break;
      }
      localMessage = new Message();
      localMessage.what = 12;
      if (paramMsgSendCostParams != null) {
        localMessage.obj = paramMsgSendCostParams;
      }
      if (i1 < 196608) {
        break label188;
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(12)) {
        break;
      }
      l1 = SystemClock.uptimeMillis();
      if (l1 - this.jdField_h_of_type_Long <= 1000L) {
        break label167;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
      paramInt = this.jdField_g_of_type_Int & 0xFFFF;
    }
    label167:
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L - (l1 - this.jdField_h_of_type_Long));
    return;
    label188:
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new knf(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(12);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
    }
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
    case 0: 
      do
      {
        return;
      } while ((paramString == null) || (paramLong == 0L));
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "disPlayAudioRecord updatePttRecordMessage: " + paramString);
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, -3, paramLong);
      a(true, true);
      return;
    }
    if (paramString != null)
    {
      paramString = StreamDataManager.a(paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
    }
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711688)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711688, 1000L);
    }
    if (paramLong != 0L)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      paramInt = i1;
      if (i1 == 1)
      {
        paramInt = i1;
        if (HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, true))
        {
          paramInt = 1026;
          if (QLog.isColorLevel()) {
            QLog.i("PttShow", 2, "checkOrUpdatePttRecord UIN_TYPE_HOTCHAT_TOPIC INVALID ptt");
          }
          a(paramLong);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong);
    }
    a(true, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean1) {
      break label7;
    }
    label7:
    label132:
    label217:
    label222:
    label223:
    for (;;)
    {
      return;
      if (!paramBoolean2)
      {
        Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
        {
          localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
          if (localObject != null) {
            break label222;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
        }
        for (;;)
        {
          if (localObject == null) {
            break label223;
          }
          if (paramInt == 2)
          {
            ((NoC2CExtensionInfo)localObject).isDataChanged = true;
            return;
          }
          if (!((NoC2CExtensionInfo)localObject).isDataChanged) {
            if (((NoC2CExtensionInfo)localObject).audioPanelType == paramInt) {
              break label132;
            }
          }
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            ((NoC2CExtensionInfo)localObject).isDataChanged = paramBoolean1;
            ((NoC2CExtensionInfo)localObject).audioPanelType = paramInt;
            return;
          }
          ExtensionInfo localExtensionInfo = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
          localObject = localExtensionInfo;
          if (localExtensionInfo == null) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
          }
          if (localObject == null) {
            break;
          }
          if (paramInt == 2)
          {
            ((ExtensionInfo)localObject).isDataChanged = true;
            return;
          }
          if (!((ExtensionInfo)localObject).isDataChanged) {
            if (((ExtensionInfo)localObject).audioPanelType == paramInt) {
              break label217;
            }
          }
          for (paramBoolean1 = bool;; paramBoolean1 = false)
          {
            ((ExtensionInfo)localObject).isDataChanged = paramBoolean1;
            ((ExtensionInfo)localObject).audioPanelType = paramInt;
            return;
          }
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    QLog.d("PttShow", 1, "BaseChatPie deletePttInShowRoom uniseq=" + paramLong);
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vivo", 2, "isPackageExist isVivoShot=" + ee);
    }
    if (ee != 0) {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    for (;;)
    {
      return;
      String str = Build.MANUFACTURER.toUpperCase();
      if ((!str.endsWith("BBK")) && (!str.endsWith("VIVO")))
      {
        ee = 2;
        return;
      }
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext.getApplicationInfo(paramString, 8192);
        ee = 1;
        this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vivo", 2, " isPackageExist isScrollToButtom=" + this.jdField_b_of_type_JavaLangBoolean);
        return;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          ee = 2;
        }
      }
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    b(paramContext, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    a(true, false);
    b(paramIntent);
    b(false);
    l();
    this.jdField_d_of_type_Boolean = d();
    this.jdField_e_of_type_Boolean = c();
    l(paramIntent);
    e(paramIntent);
    r();
    n();
    this.dS = 1;
    this.L = true;
    this.jdField_f_of_type_Int = 0;
    d(false);
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    int i1 = paramIntent.getIntExtra(AlbumConstants.i, -1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "handleRequest requestCode " + i1);
    }
    if ((i1 == 2) || (i1 == 1)) {
      j(paramIntent);
    }
    if (paramInt == 1) {
      FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    while ((paramInt != 2) || (this.E)) {
      return;
    }
    FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.BaseChatPie", 2, "onConfigurationChanged");
    }
    ac();
    if (paramConfiguration.orientation == 2) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7B", "0X8005C7B", 0, 0, "", "", "", "");
    }
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    Object localObject;
    if (ApolloActionManager.a().jdField_b_of_type_Boolean)
    {
      localObject = ApolloActionManager.a().jdField_a_of_type_AndroidContentSharedPreferences;
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        ((SharedPreferences)localObject).edit().putBoolean("is_apollo_hide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
        ApolloActionManager.a().jdField_b_of_type_Boolean = false;
      }
      ApolloActionManager.a().a(false, true, f());
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label160;
      }
    }
    label160:
    for (int i1 = 0;; i1 = 1)
    {
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { Integer.toString(i1), "2" });
      paramApolloInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessage)) || (MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))) {
      return;
    }
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_AndroidContentContext, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    paramMessage = new knm(this, paramMessage, localIntent);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(paramMessage);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "start del anim,uniseq is:" + paramChatMessage.uniseq + ",id is:" + paramChatMessage.getId() + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
      ag();
    }
    long l1 = System.currentTimeMillis();
    ThreadManager.a(new kos(this, paramChatMessage), 8, null, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "removeMsgByMessageRecord cost time is:" + (l2 - l1));
    }
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = new MessageForReplyText.SourceMsgInfo();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq = paramChatMessage.shmsgseq;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin = Long.parseLong(paramChatMessage.senderuin);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTime = ((int)paramChatMessage.time);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = paramInt;
    Object localObject = AnonymousChatHelper.a(paramChatMessage);
    if (!android.text.TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName = ((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = paramChatMessage.getSummaryMsg();
      paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
      int i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
      int i2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight();
      localObject = ReplyedMessageSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, paramInt - i1 - i2, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (localObject == null) {
        break label328;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, ((ReplyedMessageSpan)localObject).getDrawable(), null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131296537, localObject);
      this.jdField_a_of_type_AndroidTextMethodMovementMethod = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMovementMethod();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(ReplyClickMovementMethod.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().length());
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new kpx(this), 200L);
      MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "clk_replyMsg", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin != 50000000L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin != 1000000L)) {
        break;
      }
      localObject = TroopBusinessUtil.a(paramChatMessage);
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_c_of_type_JavaLangString;
      break;
      label328:
      if (this.jdField_a_of_type_AndroidTextMethodMovementMethod != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(this.jdField_a_of_type_AndroidTextMethodMovementMethod);
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_f_of_type_AndroidWidgetImageView != null) && (!this.jdField_f_of_type_AndroidWidgetImageView.isEnabled()) && (this.jdField_g_of_type_AndroidWidgetImageView != null) && (!this.jdField_g_of_type_AndroidWidgetImageView.isEnabled()) && (this.jdField_h_of_type_AndroidWidgetImageView != null) && (!this.jdField_h_of_type_AndroidWidgetImageView.isEnabled())) {
      return;
    }
    int i1;
    label66:
    int i2;
    label76:
    int i3;
    label86:
    boolean bool2;
    boolean bool1;
    boolean bool4;
    boolean bool6;
    label116:
    boolean bool9;
    boolean bool8;
    boolean bool7;
    boolean bool5;
    Object localObject;
    boolean bool10;
    if (AIOUtils.a(1) == 0)
    {
      i1 = 1;
      if (AIOUtils.a(2) != 0) {
        break label484;
      }
      i2 = 1;
      if (AIOUtils.a(3) != 0) {
        break label490;
      }
      i3 = 1;
      paramChatMessage = MultiMsgManager.a().jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      bool2 = true;
      bool3 = true;
      bool1 = true;
      bool4 = false;
      bool6 = false;
      bool9 = bool4;
      bool8 = bool1;
      bool7 = bool2;
      bool5 = bool3;
      if (paramChatMessage.hasNext())
      {
        localObject = (Map.Entry)paramChatMessage.next();
        bool5 = bool6;
        bool7 = bool4;
        bool8 = bool1;
        bool10 = bool2;
        bool9 = bool3;
        if (!((Boolean)((Map.Entry)localObject).getValue()).booleanValue()) {
          break label645;
        }
        int i4 = bool6 + true;
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        bool6 = bool4 | FlashPicHelper.a((MessageRecord)localObject);
        bool4 = bool3;
        if (i1 != 0)
        {
          bool4 = bool3;
          if (bool3) {
            if (MultiMsgProxy.b((ChatMessage)localObject))
            {
              bool4 = bool3;
              if (i4 <= 1) {}
            }
            else
            {
              bool4 = false;
            }
          }
        }
        bool3 = bool2;
        if (i2 != 0)
        {
          bool3 = bool2;
          if (bool2)
          {
            if (MultiMsgProxy.c((ChatMessage)localObject)) {
              break label496;
            }
            bool3 = false;
          }
        }
        label277:
        bool2 = bool1;
        if (i3 != 0)
        {
          bool2 = bool1;
          if (bool1)
          {
            if (MultiMsgProxy.d((ChatMessage)localObject)) {
              break label535;
            }
            bool2 = false;
          }
        }
        label305:
        bool5 = i4;
        bool7 = bool6;
        bool8 = bool2;
        bool10 = bool3;
        bool9 = bool4;
        if (bool4) {
          break label645;
        }
        bool5 = i4;
        bool7 = bool6;
        bool8 = bool2;
        bool10 = bool3;
        bool9 = bool4;
        if (bool3) {
          break label645;
        }
        bool5 = i4;
        bool7 = bool6;
        bool8 = bool2;
        bool10 = bool3;
        bool9 = bool4;
        if (bool2) {
          break label645;
        }
        bool5 = bool4;
        bool7 = bool3;
        bool8 = bool2;
        bool9 = bool6;
      }
      if (bool9) {
        break label668;
      }
      bool1 = true;
      label404:
      if (bool9) {
        break label674;
      }
      bool2 = true;
      label412:
      if (bool9) {
        break label680;
      }
    }
    label484:
    label490:
    label496:
    label535:
    label645:
    label668:
    label674:
    label680:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.jdField_f_of_type_AndroidWidgetImageView != null) {
        this.jdField_f_of_type_AndroidWidgetImageView.setEnabled(bool5 & bool1);
      }
      if (this.jdField_g_of_type_AndroidWidgetImageView != null) {
        this.jdField_g_of_type_AndroidWidgetImageView.setEnabled(bool7 & bool2);
      }
      if (this.jdField_h_of_type_AndroidWidgetImageView == null) {
        break;
      }
      this.jdField_h_of_type_AndroidWidgetImageView.setEnabled(bool3 & bool8);
      return;
      i1 = 0;
      break label66;
      i2 = 0;
      break label76;
      i3 = 0;
      break label86;
      bool3 = bool2;
      if (!(localObject instanceof MessageForTroopFile)) {
        break label277;
      }
      MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)localObject;
      bool3 = bool2;
      if (TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile) != null) {
        break label277;
      }
      bool3 = false;
      break label277;
      bool2 = bool1;
      if (!(localObject instanceof MessageForTroopFile)) {
        break label305;
      }
      localObject = (MessageForTroopFile)localObject;
      localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject);
      if (localObject != null)
      {
        bool2 = bool1;
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 8) {
          break label305;
        }
        bool2 = bool1;
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 9) {
          break label305;
        }
        bool2 = bool1;
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 6) {
          break label305;
        }
        bool2 = bool1;
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 7) {
          break label305;
        }
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 11)
        {
          bool2 = bool1;
          if (FileUtil.a(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString)) {
            break label305;
          }
        }
      }
      bool2 = false;
      break label305;
      bool2 = bool10;
      bool3 = bool9;
      bool1 = bool8;
      bool4 = bool7;
      bool6 = bool5;
      break label116;
      bool1 = false;
      break label404;
      bool2 = false;
      break label412;
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramEmoticon);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b() != 1)) {}
    ActionGlobalData localActionGlobalData;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) && (paramInt == 1) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0));
      localActionGlobalData = MagicfaceActionManager.a(paramEmoticon, 1);
    } while ((!paramBoolean) && (localActionGlobalData != null) && (paramInt == 1) && (!localActionGlobalData.jdField_c_of_type_Boolean));
    a().a(paramEmoticon, paramInt, paramString);
  }
  
  public void a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if (paramMessageForShakeWindow == null) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramMessageForShakeWindow);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable)
  {
    if ((paramEmoticonInfo2.jdField_c_of_type_Int == 6) && ((paramEmoticonInfo2 instanceof PicEmoticonInfo)) && (((PicEmoticonInfo)paramEmoticonInfo2).a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711688))
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
        a(0, null, -1L);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
    }
    c(false);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "startRecord() is called");
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramRecorderParam);
    String str = BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, 2, null, false);
    paramRecorderParam = MessageForPtt.getLocalFilePath(paramRecorderParam.jdField_c_of_type_Int, str);
    if ((str != null) && (!str.equals(paramRecorderParam))) {
      new File(str).deleteOnExit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "path: " + paramRecorderParam);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramOnQQRecorderListener);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramRecorderParam, paramBoolean);
      if (this.jdField_s_of_type_Int >= 0) {
        this.jdField_s_of_type_Int += 1;
      }
      return;
      paramRecorderParam = str;
    }
  }
  
  public void a(AbsListView.RecyclerListener paramRecyclerListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(paramRecyclerListener);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_m_of_type_Int = paramInt;
    StructMsgVideoController.a().a(paramAbsListView, paramInt);
    NowVideoController.a().a(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.resumeAll();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b();
      ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).b();
      if ((this.t) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
      {
        this.t = false;
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711697);
        paramAbsListView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711697);
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramAbsListView, BubbleManager.jdField_a_of_type_Long);
      }
      BubbleDiyFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      DropFrameMonitor.a().a("list_aio_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
      return;
    }
    URLDrawable.pause();
    if (!PicItemBuilder.jdField_g_of_type_Boolean)
    {
      AbstractGifImage.pauseAll();
      ApngImage.pauseAll();
    }
    AbstractVideoImage.pauseAll();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b();
    if (paramInt == 1) {
      e(false);
    }
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a();
    DropFrameMonitor.a().a("list_aio_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.n();
    int i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
    int i3 = paramInt3 - i4 - i2;
    int i1 = i3 - paramInt1 - paramInt2;
    if (this.jdField_x_of_type_Int == 0) {
      this.jdField_x_of_type_Int = paramInt1;
    }
    if ((!android.text.TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_x_of_type_Int - paramInt1 > 5)) {
      ai();
    }
    Message localMessage;
    if (this.dQ < i3)
    {
      paramInt2 = paramInt1 + paramInt2 - i2;
      paramInt1 = paramInt2;
      if (paramInt2 >= paramInt3 - i4 - i2) {
        paramInt1 = i3 - 1;
      }
      if (paramInt1 >= this.dQ) {
        this.dQ = (paramInt1 + i2);
      }
      if (i1 == 0) {
        this.dQ = i3;
      }
      paramInt1 = i3 - this.dQ;
      if (paramInt1 != this.dR)
      {
        if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(13)) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
        }
        paramAbsListView = this.jdField_a_of_type_MqqOsMqqHandler;
        localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(13, paramInt1, i1);
        if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
          break label233;
        }
      }
    }
    label233:
    for (long l1 = 1500L;; l1 = 0L)
    {
      paramAbsListView.sendMessageDelayed(localMessage, l1);
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      this.dR = paramInt1;
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131296537) == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
    }
    if (((paramCharSequence != null) && (paramCharSequence.length() > 0)) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localDraftTextInfo.type = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
      {
        localDraftTextInfo.sourceMsgSeq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq;
        localDraftTextInfo.sourceSenderUin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin;
        localDraftTextInfo.sourceMsgText = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText;
        localDraftTextInfo.mSourceMsgTime = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTime;
        localDraftTextInfo.mSourceSummaryFlag = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag;
        localDraftTextInfo.mSourceType = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType;
        localDraftTextInfo.mSourceRichMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mRichMsg;
      }
      if (paramCharSequence != null)
      {
        localDraftTextInfo.text = paramCharSequence.toString();
        this.al = localDraftTextInfo.text;
      }
      localDraftTextInfo.time = NetConnInfoCenter.getServerTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDraftTextInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(Object paramObject)
  {
    i2 = 0;
    AIOUtils.jdField_l_of_type_Boolean = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {}
    do
    {
      return;
      i1 = ((Integer)paramObject).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("XPanel", 2, "onPanelIconClick panelID=" + i1 + "currentID=" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "onPanelIconClick  removeFastImage");
        }
        a(true);
      }
      if (i1 == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        return;
      }
      switch (i1)
      {
      case 7: 
      case 11: 
      case 12: 
      case 13: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 20: 
      default: 
        return;
      case 2: 
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAC", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return;
      }
    } while (this.jdField_k_of_type_Int == 1);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
    }
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAD", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return;
    X();
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
    j(0);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004078", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return;
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      new PlusPanelUtils().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1);
      return;
    }
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, 1);
    return;
    av();
    return;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
    i1 = i2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {}
    try
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      i1 = i2;
      if (paramObject != null) {
        i1 = ((DeviceInfo)paramObject).productId;
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407A", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(14);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005977", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return;
    paramObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if (paramObject != null) {}
    for (paramObject = ((HotChatManager)paramObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString); paramObject != null; paramObject = null)
    {
      ChatSettingForHotChat.a((HotChatInfo)paramObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0);
      return;
    }
    if (6 == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(21, false);
    paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (paramObject != null) {
      ((SharedPreferences)paramObject).edit().putBoolean("sp_aio_panel_poke_clicked", true).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800676E", "0X800676E", 1, 0, "", "", "", "");
  }
  
  public void a(String paramString)
  {
    a(2, paramString, this.jdField_c_of_type_Long);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new kns(this));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    ThreadManager.a(new knu(this), null, false);
    a(paramString, this.jdField_c_of_type_Long, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean);
  }
  
  public void a(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long, paramInt, paramRecorderParam.jdField_c_of_type_Int);
      }
      return;
    }
  }
  
  public void a(String paramString1, int paramInt, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    MessageRecord localMessageRecord = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
    if (localMessageRecord != null)
    {
      ((MessageForPtt)localMessageRecord).c2cViaOffline = true;
      long l1 = localMessageRecord.uniseq;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString1, l1, false, paramInt, paramRecorderParam.jdField_c_of_type_Int, true, 0, 4, false);
      a(0, paramString1, l1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B16", "0X8005B16", 0, 0, "", "", paramString2, "6.5.5");
      paramString1 = StatisticCollector.a(BaseApplication.getContext());
      paramRecorderParam = new HashMap();
      paramRecorderParam.put("param_FailCode", String.valueOf(0));
      paramRecorderParam.put("inputname", paramString2);
      paramRecorderParam.put(BaseConstants.RDM_NoChangeFailCode, "");
      paramString1.a("", "sendPttEventFromIME", false, 0L, 0L, paramRecorderParam, "");
    }
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      i2 = 1;
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label186;
      }
    }
    long l1;
    String str;
    int i1;
    Object localObject;
    label186:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l1 = SystemClock.uptimeMillis();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      i1 = i3;
      if (i3 == 1)
      {
        i1 = i3;
        if (HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true))
        {
          i3 = 1026;
          i1 = i3;
          if (QLog.isColorLevel())
          {
            QLog.i("PttShow", 2, "sendPttInner UIN_TYPE_HOTCHAT_TOPIC");
            i1 = i3;
          }
        }
      }
      if (i2 != 0) {
        break label208;
      }
      localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
      if (localObject != null) {
        break label192;
      }
      return;
      i2 = 0;
      break;
    }
    label192:
    ((MessageForPtt)localObject).c2cViaOffline = bool;
    paramLong = ((MessageRecord)localObject).uniseq;
    label208:
    PttInfoCollector.a.put(paramString, Long.valueOf(l1));
    if (!bool)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + paramLong);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!z) {
        break label383;
      }
    }
    label383:
    for (int i2 = 1;; i2 = 2)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i2, 0, "", "", "", "6.5.5");
      z = true;
      i2 = a(paramInt1);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, str, paramString, paramLong, false, paramInt2, paramRecorderParam.jdField_c_of_type_Int, bool, paramInt3, i2, paramBoolean);
      f(paramInt1, paramInt2);
      a(0, paramString, paramLong);
      return;
      PttBuffer.b(paramString);
      break;
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    h(0);
    if (paramRecorderParam != null) {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label28;
      }
    }
    label28:
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      StreamDataManager.a(paramString, false);
      return;
    }
    PttBuffer.b(paramString);
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new kmg(this, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_x_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
    this.jdField_h_of_type_AndroidViewView.setVisibility(0);
    this.jdField_h_of_type_AndroidViewView.bringToFront();
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
    this.jdField_f_of_type_AndroidWidgetTextView.setText(a(paramString2));
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString3);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new kpb(this, paramString1, paramString2));
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    byte[] arrayOfByte = RecordParams.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
    int i1;
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
    {
      i1 = 1;
      if (i1 != 0) {
        break label127;
      }
      StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.jdField_c_of_type_Int, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      StreamDataManager.a(paramString, arrayOfByte, arrayOfByte.length, (short)0);
      label94:
      if (paramString != null)
      {
        if (paramBoolean) {
          break label145;
        }
        this.jdField_c_of_type_Long = 0L;
        g(2131165202);
      }
    }
    for (;;)
    {
      a(true, false);
      label127:
      label145:
      do
      {
        return;
        i1 = 0;
        break;
        PttBuffer.a(paramString);
        PttBuffer.a(paramString, arrayOfByte, arrayOfByte.length);
        break label94;
        paramString = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
      } while (paramString == null);
      if (i1 == 0) {
        paramString.setPttStreamFlag(10001);
      }
      this.jdField_c_of_type_Long = paramString.uniseq;
      g(2131165193);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, QQRecorder.RecorderParam paramRecorderParam)
  {
    a(paramString, this.jdField_c_of_type_Long, paramBoolean2, paramRecorderParam);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new kno(this, paramBoolean1));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (paramInt2 = 1; paramInt2 == 0; paramInt2 = 0)
    {
      StreamDataManager.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public void a(List paramList)
  {
    int i1 = paramList.size();
    int i2 = -1;
    int[] arrayOfInt = new int[i1];
    boolean[] arrayOfBoolean = new boolean[i1];
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup != null) {
      aP();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList, false);
    i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
    Object localObject1 = paramList.iterator();
    int i4 = 0;
    Object localObject2;
    int i3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ChatMessage)((Iterator)localObject1).next();
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject2);
      i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.delmsg", 2, "pos is:" + i3);
      }
      if (i3 >= 0)
      {
        i3 -= i1;
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i3) != null)
        {
          arrayOfInt[i4] = i3;
          if (((ChatMessage)localObject2).isSend()) {
            arrayOfBoolean[i4] = true;
          }
          i4 += 1;
          localArrayList.add(localObject2);
          ((Iterator)localObject1).remove();
        }
      }
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[i4];
    this.jdField_a_of_type_ArrayOfAndroidViewViewGroup = new ViewGroup[i4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[i4];
    this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet = new AnimationSet[i4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout = new FrameLayout[i4];
    i1 = 0;
    while (i1 < i4)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1] = new View(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1] = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i1] = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i1] = new AnimationSet(true);
      this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1] = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      i1 += 1;
    }
    int i5 = 0;
    i1 = i2;
    while (i5 < i4)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[i5] = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(arrayOfInt[i5]);
      localObject1 = null;
      label610:
      LinearInterpolator localLinearInterpolator;
      try
      {
        localObject2 = Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getWidth(), this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getHeight(), Bitmap.Config.ARGB_8888);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          localObject3 = new Canvas((Bitmap)localObject2);
          localObject1 = localObject2;
          this.jdField_a_of_type_ArrayOfAndroidViewView[i5].draw((Canvas)localObject3);
        }
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          int i6;
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "multi delete animation draw canvas oom", localOutOfMemoryError);
          }
          continue;
          i3 += 1;
        }
        Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131297417);
        ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131297417);
        ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131297417);
        ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131297417);
        localOutOfMemoryError.addView(this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i5], i2 + 1, (ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i5].setOnTouchListener(new kow(this));
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i5].setImageBitmap((Bitmap)localObject1);
        this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i5] = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject1 = new FrameLayout.LayoutParams(this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getWidth(), this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getHeight());
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i5].addView(this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i5], (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i5].setVisibility(4);
        this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i5].addView(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i5], new FrameLayout.LayoutParams(-1, -1));
        ((FrameLayout.LayoutParams)localObject1).leftMargin = this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getLeft();
        ((FrameLayout.LayoutParams)localObject1).topMargin = this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getTop();
        ((FrameLayout.LayoutParams)localObject1).rightMargin = 0;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
        localLinearInterpolator = new LinearInterpolator();
        this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i5] = new AnimationSet(true);
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(600L);
        ((AlphaAnimation)localObject1).setInterpolator(localLinearInterpolator);
        this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i5].addAnimation((Animation)localObject1);
        if (arrayOfBoolean[i5] == 0) {
          break label980;
        }
      }
      i3 = i1;
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297407);
        i6 = ((ViewGroup)localObject2).getChildCount();
        i2 = i1;
        if (i1 == -1)
        {
          i3 = 0;
          i2 = i1;
          if (i3 < i6)
          {
            if (((ViewGroup)localObject2).getChildAt(i3) != this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView) {
              break label610;
            }
            i2 = i3;
          }
        }
        if (i2 == -1)
        {
          i3 = i2;
          if (!QLog.isColorLevel()) {
            break label973;
          }
          QLog.d("Q.msg.delmsg", 2, "listViewIndex is:" + i2 + ",can not find listView");
          i1 = i2;
          i5 += 1;
        }
      }
      label973:
      label980:
      for (localObject1 = new TranslateAnimation(0.0F, this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getRight(), 0.0F, 0.0F);; localObject1 = new TranslateAnimation(0.0F, -this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getRight(), 0.0F, 0.0F))
      {
        ((TranslateAnimation)localObject1).setDuration(600L);
        ((TranslateAnimation)localObject1).setInterpolator(localLinearInterpolator);
        this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i5].addAnimation((Animation)localObject1);
        i3 = i2;
        i1 = i3;
        break;
      }
    }
    i1 = 0;
    while (i1 < i4)
    {
      if ((this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i1] != null) && (this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i1] != null)) {
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i1].startAnimation(this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i1]);
      }
      i1 += 1;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new koy(this), 600L);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new koz(this, localArrayList), 400L);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new kpa(this, paramList), 800L);
  }
  
  public void a(List paramList, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramList, paramCharSequence);
  }
  
  public void a(List paramList, ArrayList paramArrayList)
  {
    MultiMsgManager.a().b(paramList);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg", 4, "checklist.size = " + paramList.size());
    }
    if (paramList.size() == 0) {
      return;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367669);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!paramArrayList.contains(localChatMessage.senderuin)) {
        paramArrayList.add(localChatMessage.senderuin);
      }
    }
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.clear();
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramArrayList, null);
    }
    for (;;)
    {
      paramList = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(24);
      paramList.arg1 = paramArrayList.size();
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramList, 30000L);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramArrayList);
      }
    }
  }
  
  public void a(Map paramMap, ArrayList paramArrayList)
  {
    String str = " ";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
    for (str = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString) {
      do
      {
        paramMap = ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, str, paramArrayList, paramMap);
        if (paramMap != null) {
          break;
        }
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000));
    }
    paramMap.mMsg_A_ActionData = null;
    paramArrayList = new Intent();
    paramArrayList.putExtra("forward_type", -3);
    paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
    paramArrayList.putExtra("is_need_show_sources", false);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramArrayList, 21);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(33);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (BaseChatItemLayout.jdField_b_of_type_Boolean == paramBoolean1) {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.aio.BaseChatPie", 4, "setLeftCheckBoxVisible visible is not change so no need change");
      }
    }
    label83:
    label223:
    label511:
    label532:
    label544:
    label724:
    for (;;)
    {
      return;
      if (paramBoolean1)
      {
        BaseChatItemLayout.a = this;
        BaseChatItemLayout.jdField_b_of_type_Boolean = paramBoolean1;
        MultiMsgManager.a().a(paramChatMessage, paramBoolean1);
        a(paramChatMessage, paramBoolean1);
        if (paramBoolean1) {
          break label544;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843454);
        if (!android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          break label511;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367566);
        MultiMsgManager.a().a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramBoolean1 = C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if ((!ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (!paramBoolean1)) {
          break label532;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_i_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (!(this instanceof PublicAccountChatPie))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.jdField_b_of_type_Int);
          }
          if (this.jdField_e_of_type_AndroidViewView != null) {
            this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          }
          if (this.jdField_f_of_type_AndroidViewView != null) {
            this.jdField_f_of_type_AndroidViewView.setVisibility(0);
          }
          this.jdField_i_of_type_Boolean = false;
        }
        this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297084).setVisibility(0);
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
        {
          paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
          paramChatMessage.setMargins(paramChatMessage.leftMargin, paramChatMessage.rightMargin, paramChatMessage.rightMargin, this.jdField_l_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(paramChatMessage);
        }
        if ((this.jdField_j_of_type_AndroidWidgetTextView != null) && (!android.text.TextUtils.isEmpty(this.jdField_j_of_type_AndroidWidgetTextView.getText().toString())) && (!"0".equals(this.jdField_j_of_type_AndroidWidgetTextView.getText().toString()))) {
          this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if ((ApolloActionManager.a().jdField_a_of_type_AndroidContentSharedPreferences != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!ApolloActionManager.a().jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("is_apollo_hide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false)) && (1 == ApolloActionManager.a().e)) {
          ApolloActionManager.a().a(false, true, f());
        }
      }
      for (;;)
      {
        if (paramBoolean2) {
          break label724;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
        return;
        BaseChatItemLayout.a = null;
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
        this.jdField_c_of_type_JavaLangString = "";
        break label83;
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        break label223;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        ah();
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
          }
          if (this.jdField_e_of_type_AndroidViewView != null) {
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          }
          if (this.jdField_f_of_type_AndroidViewView != null) {
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          }
          this.jdField_i_of_type_Boolean = true;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
        {
          paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
          if (this.jdField_l_of_type_Int == 0) {
            this.jdField_l_of_type_Int = paramChatMessage.bottomMargin;
          }
          paramChatMessage.setMargins(paramChatMessage.leftMargin, paramChatMessage.rightMargin, paramChatMessage.rightMargin, this.jdField_l_of_type_Int + AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(paramChatMessage);
        }
        if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
          this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1) {
      if (paramBoolean2) {
        i1 = 1;
      }
    }
    for (;;)
    {
      a(i1 | 0x20000);
      return;
      i1 = 2;
      continue;
      i1 = 0;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramBoolean1);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) {
        return;
      }
    }
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean3, paramBoolean1, paramBoolean4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) {
      if ((paramBoolean1) || (paramBoolean4)) {
        break label120;
      }
    }
    label120:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      d(paramBoolean2, paramBoolean3);
      this.jdField_j_of_type_Boolean = paramBoolean3;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramBoolean1);
      return;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "[ifApolloFunAvailThenInit], mIsInit:" + ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ",mApolloSurfaceView:" + this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
    }
    ApolloActionManager.a().a(a()).jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener = this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener;
    ApolloActionManager.a().jdField_f_of_type_Int = hashCode();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "errInfo->NOT friend or troop or discussion, return.");
      }
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (ApolloManager.c("discuss") == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, " discussion switch is close, return.");
      }
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (ApolloActionManager.a().b()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "issurfaceReady:" + ApolloActionManager.a().b());
      }
      return false;
    }
    if (!ApolloManager.a(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "Not in white list.");
      }
      return false;
    }
    ApolloMsgPlayController.a().a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_MqqOsMqqHandler);
    if (ApolloActionManager.a().jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "Apollo func is double-hidden.");
      }
      return false;
    }
    ApolloActionManager.a().b();
    if (!ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "Destoryed, return.");
      }
      return false;
    }
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "cmshow NOT support hot chat right now.");
      }
      return false;
    }
    ThreadManager.a(new knt(this), 5, null, true);
    return true;
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "finish () " + paramInt);
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(59)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(59);
    }
    ai();
    this.M = false;
    if (BaseChatItemLayout.jdField_b_of_type_Boolean) {
      a(false, null, false);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if ((i1 != 0) && (paramInt == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "basechatpie_finish 1,type:" + paramInt);
        }
        return true;
      }
      int i2 = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null)
      {
        i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b()) {
          i2 = 1;
        }
      }
      if ((i2 != 0) && (paramInt == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "basechatpie_finish 2,type:" + paramInt);
        }
        return true;
      }
      if (paramInt == 1)
      {
        aS();
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) || (paramInt != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a())) {
            break label655;
          }
        }
      }
      label332:
      label344:
      label655:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0)
        {
          if (paramInt != 1) {
            break label332;
          }
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(false);
        }
        for (;;)
        {
          i2 = 1;
          if ((i2 == 0) || (paramInt != 0)) {
            break label344;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "basechatpie_finish 3,type:" + paramInt);
          }
          return true;
          if ((paramInt != 0) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            break;
          }
          aS();
          break;
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
        }
        M();
        aG();
        if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.moveTaskToBack(true);
        }
        Object localObject = (PendingIntent)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
        if ((localObject != null) && ((localObject instanceof PendingIntent)) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("share_from_aio", false))) {}
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "-->finish--send callback using PendingIntent");
          }
          ((PendingIntent)localObject).send();
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.moveTaskToBack(true);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("Q.aio.BaseChatPie", 2, localException1.getMessage());
              continue;
              if (paramInt == 1) {
                if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)) {
                  this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
                } else {
                  F();
                }
              }
            }
          }
        }
        y();
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        if (paramInt == 0)
        {
          F();
          try
          {
            localObject = this.jdField_a_of_type_AndroidWidgetTextView.getTag();
            String[] arrayOfString = (String[])localObject;
            if ((localObject != null) && ("comic".equals(arrayOfString[0]))) {
              VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", arrayOfString[1], new String[] { "3" });
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
          if ((this.jdField_w_of_type_Boolean) && (!this.jdField_y_of_type_Boolean) && (AIOUtils.jdField_l_of_type_Boolean))
          {
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
            this.jdField_y_of_type_Boolean = true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
          }
          return false;
        }
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "listView onViewCompleteVisableAndReleased");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0))
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 21, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      return true;
    }
    d(false);
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
      while (i1 >= 0)
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
        if ((paramMotionEvent != null) && ((AIOUtils.a(paramMotionEvent) instanceof ArkAppItemBuilder.Holder)))
        {
          paramMotionEvent = paramMotionEvent.findViewById(2131297443);
          Rect localRect = new Rect();
          paramMotionEvent.getGlobalVisibleRect(localRect);
          if (localRect.contains((int)f1, (int)f2)) {
            return false;
          }
        }
        i1 -= 1;
      }
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.c(paramMessageRecord.istroop))));
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
    a();
    c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_updateSession", "AIO_doOnCreate_otherCost");
    ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    StartupTracker.a("AIO_doOnCreate_otherCost", "AIO_doOnCreate_handleRequest");
    if (paramBoolean) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), 1);
    }
    for (;;)
    {
      StartupTracker.a("AIO_doOnCreate_handleRequest", null);
      return true;
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), 2);
    }
  }
  
  public Object[] a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if ((!android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (paramString.equals(this.jdField_e_of_type_JavaLangString))) {}
        for (arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_d_of_type_JavaLangString); (arrayOfObject != null) && (((Integer)arrayOfObject[0]).intValue() == 1); arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString))
        {
          this.jdField_d_of_type_JavaLangString = "";
          this.jdField_e_of_type_JavaLangString = "";
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(12);
          if (!QLog.isColorLevel()) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString.charAt(0));
          localStringBuilder.append("|");
          localStringBuilder.append(paramString.length());
          QLog.d(PasswdRedBagManager.jdField_a_of_type_JavaLangString, 2, "passwdredbags result[0]=" + arrayOfObject[0] + ",result[1]=" + arrayOfObject[1] + ",send str=" + localStringBuilder.toString());
          return arrayOfObject;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(PasswdRedBagManager.jdField_a_of_type_JavaLangString, 2, "current is in Anonymous, dont search passwdredbags");
    return null;
    return arrayOfObject;
  }
  
  protected void aA()
  {
    if (!OlympicTorchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
    OlympicManager localOlympicManager;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("OlympicTorchManager", 2, "updateOlympicFlag");
      }
      localOlympicManager = (OlympicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166);
    } while (!localOlympicManager.b("C2CAIO"));
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView.getTag(2131296648);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.a(new kqe(this, localOlympicManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, bool), null, true);
      return;
    }
  }
  
  public void aB() {}
  
  protected void aa()
  {
    if (this.jdField_k_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
      if (VersionUtils.e()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_k_of_type_Int != 2) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
      } while (!VersionUtils.e());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
    } while (!VersionUtils.e());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
  }
  
  protected void ab()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (i1 == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      return;
    }
    if (i1 == 21)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(i1);
  }
  
  public void ac()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "hideSoftInput");
        }
      }
    }
  }
  
  public void ad()
  {
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131368695);
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, str, 2131370281, 2131370282, new koc(this), new kod(this)).show();
  }
  
  public void ae()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener);
  }
  
  public void af()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().equals(this.jdField_e_of_type_JavaLangString)) {
      ai();
    }
    long l1 = System.currentTimeMillis();
    boolean bool;
    label103:
    int i1;
    if (this.jdField_k_of_type_Int == 0)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (paramEditable.length() <= 0) {
          break label347;
        }
        bool = true;
        ((PatchedButton)localObject).setEnabled(bool);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
      }
      Object localObject = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() <= 0) {
        break label353;
      }
      bool = true;
      ((PatchedButton)localObject).setEnabled(bool);
      if ((paramEditable.length() > 0) && (paramEditable.length() > 1) && (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(paramEditable.toString());
        if ((localObject != null) && (((List)localObject).size() >= 2)) {
          break label359;
        }
        i1 = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(paramEditable.toString());
        label186:
        if (((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (localObject != null) && (((List)localObject).size() > 0)) || (i1 > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setEmoticonKeywordList((List)localObject, i1);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(0);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("afterTextChanged", 2, " afterTextChanged cost: " + (System.currentTimeMillis() - l1));
    }
    if (this.P)
    {
      if ((this.Q) || (paramEditable.length() <= 0)) {
        break label364;
      }
      this.ec = NetworkUtil.a(BaseApplication.getContext());
      if ((this.ec == 2) || (this.ec == 3))
      {
        this.Q = true;
        this.dY = 1;
        if (this.jdField_b_of_type_JavaLangRunnable == null) {
          aO();
        }
        ThreadManager.b().post(this.jdField_b_of_type_JavaLangRunnable);
      }
    }
    label347:
    label353:
    label359:
    label364:
    while (paramEditable.length() != 0)
    {
      return;
      bool = false;
      break;
      bool = false;
      break label103;
      i1 = 0;
      break label186;
    }
    ThreadManager.b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.Q = false;
    this.dY = 40;
    this.ea = 0;
    this.dZ = 0;
    this.ec = 0;
  }
  
  protected void ag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "cancelDelAnim() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(15);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.K();
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getParent() != null)) {
      ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_c_of_type_AndroidViewViewGroup);
    }
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidViewViewGroup = null;
  }
  
  public void ah()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void ai()
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText("");
    this.jdField_g_of_type_AndroidWidgetTextView.setText("");
    this.jdField_h_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void aj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "startShakeAnim() is called,time is:" + System.currentTimeMillis());
    }
    ak();
    kpc localkpc = new kpc(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(localkpc, 60L);
        return;
      }
      localkpc.run();
      return;
    }
  }
  
  public void ak()
  {
    ((ViewGroup)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView()).getChildAt(0).clearAnimation();
    if ((this.jdField_j_of_type_AndroidViewView != null) && (this.jdField_j_of_type_AndroidViewView.getParent() != null)) {
      ((ViewGroup)this.jdField_j_of_type_AndroidViewView.getParent()).removeView(this.jdField_j_of_type_AndroidViewView);
    }
    this.jdField_j_of_type_AndroidViewView = null;
  }
  
  public void al() {}
  
  public void am()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) {
        if ((!"".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_b_of_type_JavaLangString)) && (!"null".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_b_of_type_JavaLangString))) {
          break label360;
        }
      }
    }
    label213:
    label305:
    label360:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "#handleNightMask# : inNightMode, isDefaultBg=" + bool + ",mMask=" + this.jdField_g_of_type_AndroidViewView + ", sessionInfo.chatBg.path=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_b_of_type_JavaLangString);
      }
      if ((this.jdField_g_of_type_AndroidViewView != null) && (QLog.isColorLevel()))
      {
        if (this.jdField_g_of_type_AndroidViewView.getVisibility() == 0) {
          QLog.d("Q.aio.BaseChatPie", 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
        }
      }
      else
      {
        if (bool) {
          break label305;
        }
        if ((this.jdField_g_of_type_AndroidViewView == null) || (this.jdField_g_of_type_AndroidViewView.getVisibility() != 0)) {
          break label213;
        }
      }
      do
      {
        do
        {
          return;
          if (this.jdField_g_of_type_AndroidViewView.getVisibility() == 4)
          {
            QLog.d("Q.aio.BaseChatPie", 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
            break;
          }
          QLog.d("Q.aio.BaseChatPie", 2, "#handleNightMask# : mMask getVisibility = GONE");
          break;
          if (this.jdField_g_of_type_AndroidViewView == null)
          {
            this.jdField_g_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
            this.jdField_g_of_type_AndroidViewView.setBackgroundColor(1996488704);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
            localLayoutParams.addRule(6, 2131297417);
            localLayoutParams.addRule(2, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
            this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_g_of_type_AndroidViewView);
            return;
          }
          this.jdField_g_of_type_AndroidViewView.setVisibility(0);
          return;
        } while (this.jdField_g_of_type_AndroidViewView == null);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_g_of_type_AndroidViewView);
        this.jdField_g_of_type_AndroidViewView = null;
        return;
      } while ((this.jdField_g_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_g_of_type_AndroidViewView);
      this.jdField_g_of_type_AndroidViewView = null;
      return;
    }
  }
  
  public void an()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    }
  }
  
  public void ao()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(21);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        if ((localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) == 0) || (localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) == 2)) {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "panel_close_show", localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()), 0, new String[] { "" + ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) });
        }
      }
    }
  }
  
  public void ap()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_d_of_type_Boolean)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
            break;
          }
          localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
        } while ((localObject == null) || (!((NoC2CExtensionInfo)localObject).isDataChanged));
        ThreadManager.a().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        return;
      } while (!v());
      localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    } while ((localObject == null) || (!((ExtensionInfo)localObject).isDataChanged));
    ThreadManager.a().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public void aq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onOverScrollTargetValue isScrollToButtom=" + this.D);
    }
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t() == this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.n()) && (this.D))
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004454", "0X8004454", 0, 0, "", "", "", "");
    }
  }
  
  public void ar()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onEventComplite");
    }
    this.S = true;
  }
  
  public void as()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
  }
  
  public void at() {}
  
  public void au() {}
  
  public void av()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131367263, new DialogUtil.DialogOnClickAdapter()).show();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131363475, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131492908));
    }
    for (;;)
    {
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005E91", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
      if (VideoEnvironment.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        aw();
      }
    }
  }
  
  public void aw()
  {
    boolean bool1 = p();
    if ((!bool1) && (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131367234, 0).a();
      return;
    }
    this.A = true;
    this.W = true;
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new kpw(this), 3000L);
    boolean bool2 = PtvFilterSoLoad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    Object localObject;
    if ((bool1) && ((bool2) || (PtvFilterSoLoad.a(this.jdField_a_of_type_AndroidContentContext) == 0)))
    {
      localObject = NewFlowCameraActivity.class;
      if (CameraCompatibleList.d(CameraCompatibleList.jdField_c_of_type_JavaLangString)) {
        localObject = MX3FlowNewCameraActivity.class;
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
      ((Intent)localObject).putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((Intent)localObject).putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.NewShortVideoConfig.name(), null));
      ((Intent)localObject).putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
      q((Intent)localObject);
      ((Intent)localObject).putExtra("flow_camera_video_mode", true);
      ((Intent)localObject).putExtra("flow_camera_use_filter_function", bool2);
      if (QLog.isColorLevel()) {
        QLog.d("faceGuide", 2, "showptv isPtvShowRed =" + PanelIconLinearLayout.jdField_a_of_type_JavaLangBoolean);
      }
      ((Intent)localObject).putExtra("flow_camera_show_redDot", PanelIconLinearLayout.jdField_a_of_type_JavaLangBoolean);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject, 11000);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006A11", "0X8006A11", 0, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
      if (PeakUtils.a == null) {
        break;
      }
      PeakUtils.a.b();
      return;
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, NewPreFlowCamera.class);
      ((Intent)localObject).putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject, 11000);
    }
  }
  
  public void ax() {}
  
  protected void ay()
  {
    if (this.jdField_f_of_type_AndroidViewView == null)
    {
      this.jdField_f_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, (int)(10.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(2, 2131297409);
      this.jdField_f_of_type_AndroidViewView.setId(2131296469);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_f_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_j_of_type_Boolean) {
      AccessibilityUtil.a(this.jdField_f_of_type_AndroidViewView, false);
    }
  }
  
  protected void az()
  {
    if (this.jdField_e_of_type_AndroidViewView == null)
    {
      this.jdField_e_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, (int)(15.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(3, 2131297409);
      this.jdField_e_of_type_AndroidViewView.setId(2131296468);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_j_of_type_Boolean) {
      AccessibilityUtil.a(this.jdField_e_of_type_AndroidViewView, false);
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
  }
  
  @Deprecated
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setVolumeControlStream(3);
    d(false, false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    aa();
    ab();
    if (QLog.isColorLevel()) {
      QLog.d("inputx", 2, "doPanelChanged newPanel=" + paramInt2);
    }
    if ((ApolloActionManager.a().e == 1) && (!ApolloActionManager.a().jdField_b_of_type_Boolean) && (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null))
    {
      if (paramInt1 != 21) {
        break label418;
      }
      ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.d();
    }
    label105:
    label126:
    label417:
    label418:
    label447:
    label458:
    label476:
    do
    {
      break label417;
      if (this.jdField_e_of_type_AndroidViewView != null)
      {
        if (paramInt2 >= 1) {
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else
      {
        if (this.jdField_f_of_type_AndroidViewView != null)
        {
          if (paramInt2 < 1) {
            break label447;
          }
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        }
        if (!this.jdField_d_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
          }
          if (paramInt2 != 2) {
            break label458;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(false);
          }
        }
      }
      for (;;)
      {
        if ((paramInt1 == 4) && (paramInt2 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(1019);
        }
        if ((paramInt2 == 4) && (paramInt1 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
        }
        if ((paramInt2 == 14) && (paramInt1 != 14) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
        }
        if ((paramInt1 == 2) && (paramInt2 != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
        }
        if ((paramInt1 != 2) && (paramInt2 == 2)) {
          this.jdField_s_of_type_Int = 0;
        }
        paramInt1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
        if (paramInt1 == 0) {
          break label476;
        }
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        if ((paramInt1 == 5) || (paramInt1 == 6)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        }
        return;
        if (paramInt2 != 21) {
          break;
        }
        ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.e();
        break;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        break label105;
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        break label126;
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() != 0) {}
      }
    } while ((paramInt2 == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips == null));
    QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)this.jdField_a_of_type_JavaUtilList.get(paramInt2 - 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips.a(localQQOperationViopTipTask);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void b(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_updateTitle");
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.BaseChatPie", 2, "updateSession_updateTitle nick == null");
      }
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "updateSession_updateTitle curFriendNick" + Utils.a(paramIntent));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      if (AppSetting.jdField_j_of_type_Boolean)
      {
        paramIntent = this.jdField_b_of_type_AndroidWidgetTextView.getText() + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131362081);
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        a().setTitle(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_updateSession_updateTitle", null);
      return;
      QLog.e("Q.aio.BaseChatPie", 1, "updateSession_updateTitle sessionInfo.curFriendNick == null");
    }
  }
  
  /* Error */
  public void b(ChatMessage paramChatMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 623	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   4: aload_1
    //   5: invokevirtual 636	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)I
    //   8: istore 8
    //   10: invokestatic 484	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +31 -> 44
    //   16: ldc_w 638
    //   19: iconst_2
    //   20: new 410	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 487	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 640
    //   30: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload 8
    //   35: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 513	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: iload 8
    //   46: ifge +4 -> 50
    //   49: return
    //   50: aload_0
    //   51: getfield 642	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   54: invokevirtual 646	com/tencent/mobileqq/bubble/ChatXListView:s	()I
    //   57: istore 9
    //   59: iload 8
    //   61: iload 9
    //   63: isub
    //   64: istore 10
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 642	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   71: iload 10
    //   73: invokevirtual 654	com/tencent/mobileqq/bubble/ChatXListView:getChildAt	(I)Landroid/view/View;
    //   76: putfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   79: aload_0
    //   80: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   83: ifnonnull +67 -> 150
    //   86: invokestatic 484	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +53 -> 142
    //   92: ldc_w 638
    //   95: iconst_2
    //   96: new 410	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 487	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 5092
    //   106: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: iload 10
    //   111: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc_w 5094
    //   117: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload 9
    //   122: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc_w 5096
    //   128: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: iload 8
    //   133: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 513	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_0
    //   143: ldc_w 5097
    //   146: invokevirtual 2400	com/tencent/mobileqq/activity/BaseChatPie:a	(I)V
    //   149: return
    //   150: aload_0
    //   151: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   154: invokevirtual 5100	android/view/View:isDrawingCacheEnabled	()Z
    //   157: istore 11
    //   159: aload_0
    //   160: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   163: invokevirtual 5103	android/view/View:willNotCacheDrawing	()Z
    //   166: istore 12
    //   168: aload_0
    //   169: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   172: iconst_1
    //   173: invokevirtual 5106	android/view/View:setDrawingCacheEnabled	(Z)V
    //   176: aload_0
    //   177: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   180: iconst_0
    //   181: invokevirtual 5109	android/view/View:setWillNotCacheDrawing	(Z)V
    //   184: aload_0
    //   185: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   188: invokevirtual 5113	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   191: astore_2
    //   192: aload_0
    //   193: new 1516	android/widget/FrameLayout
    //   196: dup
    //   197: aload_0
    //   198: getfield 433	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   201: invokespecial 4250	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   204: putfield 3692	com/tencent/mobileqq/activity/BaseChatPie:jdField_c_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   207: aconst_null
    //   208: astore 4
    //   210: aload 4
    //   212: astore_3
    //   213: aload_2
    //   214: ifnull +8 -> 222
    //   217: aload_2
    //   218: invokestatic 5116	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   221: astore_3
    //   222: invokestatic 484	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +30 -> 255
    //   228: ldc_w 638
    //   231: iconst_2
    //   232: new 410	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 487	java/lang/StringBuilder:<init>	()V
    //   239: ldc_w 5118
    //   242: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_3
    //   246: invokevirtual 1287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 513	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_3
    //   256: ifnull +447 -> 703
    //   259: aload_0
    //   260: getfield 429	com/tencent/mobileqq/activity/BaseChatPie:jdField_d_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   263: ldc_w 4277
    //   266: invokevirtual 1085	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   269: checkcast 1082	android/view/ViewGroup
    //   272: astore_2
    //   273: aload_2
    //   274: invokevirtual 4278	android/view/ViewGroup:getChildCount	()I
    //   277: istore 9
    //   279: iconst_0
    //   280: istore 8
    //   282: iload 8
    //   284: iload 9
    //   286: if_icmpge +526 -> 812
    //   289: aload_2
    //   290: iload 8
    //   292: invokevirtual 4279	android/view/ViewGroup:getChildAt	(I)Landroid/view/View;
    //   295: aload_0
    //   296: getfield 642	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   299: if_acmpne +69 -> 368
    //   302: iload 8
    //   304: iconst_m1
    //   305: if_icmpne +72 -> 377
    //   308: invokestatic 484	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +37 -> 348
    //   314: ldc_w 638
    //   317: iconst_2
    //   318: new 410	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 487	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 4281
    //   328: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: iload 8
    //   333: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: ldc_w 4283
    //   339: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 513	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aload_0
    //   349: ldc_w 5097
    //   352: invokevirtual 2400	com/tencent/mobileqq/activity/BaseChatPie:a	(I)V
    //   355: return
    //   356: astore_2
    //   357: aconst_null
    //   358: astore_2
    //   359: goto -167 -> 192
    //   362: astore_2
    //   363: aconst_null
    //   364: astore_2
    //   365: goto -173 -> 192
    //   368: iload 8
    //   370: iconst_1
    //   371: iadd
    //   372: istore 8
    //   374: goto -92 -> 282
    //   377: new 950	android/widget/RelativeLayout$LayoutParams
    //   380: dup
    //   381: iconst_m1
    //   382: iconst_m1
    //   383: invokespecial 963	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   386: astore 4
    //   388: aload 4
    //   390: bipush 6
    //   392: ldc_w 4288
    //   395: invokevirtual 1072	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   398: aload 4
    //   400: bipush 8
    //   402: ldc_w 4288
    //   405: invokevirtual 1072	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   408: aload 4
    //   410: iconst_5
    //   411: ldc_w 4288
    //   414: invokevirtual 1072	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   417: aload 4
    //   419: bipush 7
    //   421: ldc_w 4288
    //   424: invokevirtual 1072	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   427: aload_2
    //   428: aload_0
    //   429: getfield 3692	com/tencent/mobileqq/activity/BaseChatPie:jdField_c_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   432: iload 8
    //   434: iconst_1
    //   435: iadd
    //   436: aload 4
    //   438: invokevirtual 4289	android/view/ViewGroup:addView	(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    //   441: aload_0
    //   442: getfield 3692	com/tencent/mobileqq/activity/BaseChatPie:jdField_c_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   445: new 5120	kou
    //   448: dup
    //   449: aload_0
    //   450: invokespecial 5121	kou:<init>	(Lcom/tencent/mobileqq/activity/BaseChatPie;)V
    //   453: invokevirtual 4293	android/view/ViewGroup:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   456: new 3144	android/widget/ImageView
    //   459: dup
    //   460: aload_0
    //   461: getfield 433	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   464: invokespecial 4251	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   467: astore 4
    //   469: aload 4
    //   471: aload_3
    //   472: invokevirtual 4296	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   475: new 1516	android/widget/FrameLayout
    //   478: dup
    //   479: aload_0
    //   480: getfield 433	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   483: invokespecial 4250	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   486: astore 5
    //   488: new 4298	android/widget/FrameLayout$LayoutParams
    //   491: dup
    //   492: aload_0
    //   493: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   496: invokevirtual 4254	android/view/View:getWidth	()I
    //   499: aload_0
    //   500: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   503: invokevirtual 4255	android/view/View:getHeight	()I
    //   506: invokespecial 4299	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   509: astore_2
    //   510: aload_2
    //   511: bipush 51
    //   513: putfield 4302	android/widget/FrameLayout$LayoutParams:gravity	I
    //   516: aload_0
    //   517: getfield 3692	com/tencent/mobileqq/activity/BaseChatPie:jdField_c_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   520: aload 5
    //   522: aload_2
    //   523: invokevirtual 4303	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   526: aload_0
    //   527: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   530: iconst_4
    //   531: invokevirtual 1520	android/view/View:setVisibility	(I)V
    //   534: aload 5
    //   536: aload 4
    //   538: new 4298	android/widget/FrameLayout$LayoutParams
    //   541: dup
    //   542: iconst_m1
    //   543: iconst_m1
    //   544: invokespecial 4299	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   547: invokevirtual 4304	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   550: aload_2
    //   551: aload_0
    //   552: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   555: invokevirtual 4307	android/view/View:getLeft	()I
    //   558: putfield 4310	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   561: aload_2
    //   562: aload_0
    //   563: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   566: invokevirtual 2573	android/view/View:getTop	()I
    //   569: putfield 4311	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   572: aload_2
    //   573: iconst_0
    //   574: putfield 4312	android/widget/FrameLayout$LayoutParams:rightMargin	I
    //   577: aload_2
    //   578: iconst_0
    //   579: putfield 4313	android/widget/FrameLayout$LayoutParams:bottomMargin	I
    //   582: new 4315	android/view/animation/LinearInterpolator
    //   585: dup
    //   586: invokespecial 4316	android/view/animation/LinearInterpolator:<init>	()V
    //   589: astore 6
    //   591: new 4249	android/view/animation/AnimationSet
    //   594: dup
    //   595: iconst_1
    //   596: invokespecial 4253	android/view/animation/AnimationSet:<init>	(Z)V
    //   599: astore 7
    //   601: new 4318	android/view/animation/AlphaAnimation
    //   604: dup
    //   605: fconst_1
    //   606: fconst_0
    //   607: invokespecial 4321	android/view/animation/AlphaAnimation:<init>	(FF)V
    //   610: astore_2
    //   611: aload_2
    //   612: ldc2_w 4356
    //   615: invokevirtual 4326	android/view/animation/AlphaAnimation:setDuration	(J)V
    //   618: aload_2
    //   619: aload 6
    //   621: invokevirtual 4330	android/view/animation/AlphaAnimation:setInterpolator	(Landroid/view/animation/Interpolator;)V
    //   624: aload 7
    //   626: aload_2
    //   627: invokevirtual 4334	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   630: aload_1
    //   631: invokevirtual 2629	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   634: ifeq +119 -> 753
    //   637: new 4336	android/view/animation/TranslateAnimation
    //   640: dup
    //   641: fconst_0
    //   642: aload_0
    //   643: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   646: invokevirtual 4339	android/view/View:getRight	()I
    //   649: i2f
    //   650: fconst_0
    //   651: fconst_0
    //   652: invokespecial 4342	android/view/animation/TranslateAnimation:<init>	(FFFF)V
    //   655: astore_2
    //   656: aload_2
    //   657: ldc2_w 4356
    //   660: invokevirtual 4343	android/view/animation/TranslateAnimation:setDuration	(J)V
    //   663: aload_2
    //   664: aload 6
    //   666: invokevirtual 4344	android/view/animation/TranslateAnimation:setInterpolator	(Landroid/view/animation/Interpolator;)V
    //   669: aload 7
    //   671: aload_2
    //   672: invokevirtual 4334	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   675: aload 4
    //   677: aload 7
    //   679: invokevirtual 4347	android/widget/ImageView:startAnimation	(Landroid/view/animation/Animation;)V
    //   682: aload_0
    //   683: getfield 245	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   686: new 5123	kov
    //   689: dup
    //   690: aload_0
    //   691: aload 5
    //   693: invokespecial 5126	kov:<init>	(Lcom/tencent/mobileqq/activity/BaseChatPie;Landroid/widget/FrameLayout;)V
    //   696: ldc2_w 4356
    //   699: invokevirtual 587	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   702: pop
    //   703: aload_0
    //   704: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   707: iload 11
    //   709: invokevirtual 5106	android/view/View:setDrawingCacheEnabled	(Z)V
    //   712: aload_0
    //   713: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   716: iload 12
    //   718: invokevirtual 5109	android/view/View:setWillNotCacheDrawing	(Z)V
    //   721: aload_3
    //   722: ifnull +54 -> 776
    //   725: aload_0
    //   726: getfield 245	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   729: bipush 15
    //   731: invokevirtual 3973	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   734: astore_2
    //   735: aload_2
    //   736: aload_1
    //   737: putfield 619	android/os/Message:obj	Ljava/lang/Object;
    //   740: aload_0
    //   741: getfield 245	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   744: aload_2
    //   745: ldc2_w 3789
    //   748: invokevirtual 1811	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   751: pop
    //   752: return
    //   753: new 4336	android/view/animation/TranslateAnimation
    //   756: dup
    //   757: fconst_0
    //   758: aload_0
    //   759: getfield 4832	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   762: invokevirtual 4339	android/view/View:getRight	()I
    //   765: ineg
    //   766: i2f
    //   767: fconst_0
    //   768: fconst_0
    //   769: invokespecial 4342	android/view/animation/TranslateAnimation:<init>	(FFFF)V
    //   772: astore_2
    //   773: goto -117 -> 656
    //   776: aload_0
    //   777: getfield 623	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   780: aload_1
    //   781: invokevirtual 5128	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   784: aload_0
    //   785: getfield 245	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   788: bipush 16
    //   790: ldc2_w 2708
    //   793: invokevirtual 2832	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   796: pop
    //   797: return
    //   798: astore_2
    //   799: aload 4
    //   801: astore_3
    //   802: goto -580 -> 222
    //   805: astore_2
    //   806: aload 4
    //   808: astore_3
    //   809: goto -587 -> 222
    //   812: iconst_m1
    //   813: istore 8
    //   815: goto -513 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	this	BaseChatPie
    //   0	818	1	paramChatMessage	ChatMessage
    //   191	99	2	localObject1	Object
    //   356	1	2	localException1	Exception
    //   358	1	2	localObject2	Object
    //   362	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   364	409	2	localObject3	Object
    //   798	1	2	localException2	Exception
    //   805	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   212	597	3	localObject4	Object
    //   208	599	4	localObject5	Object
    //   486	206	5	localFrameLayout	FrameLayout
    //   589	76	6	localLinearInterpolator	LinearInterpolator
    //   599	79	7	localAnimationSet	AnimationSet
    //   8	806	8	i1	int
    //   57	230	9	i2	int
    //   64	46	10	i3	int
    //   157	551	11	bool1	boolean
    //   166	551	12	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   184	192	356	java/lang/Exception
    //   184	192	362	java/lang/OutOfMemoryError
    //   217	222	798	java/lang/Exception
    //   217	222	805	java/lang/OutOfMemoryError
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void b(CharSequence paramCharSequence)
  {
    j(0);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().append(paramCharSequence);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
  }
  
  public void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
    }
    for (;;)
    {
      this.jdField_f_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l1));
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
      {
        this.jdField_f_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
        }
      }
      else if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
      }
    }
  }
  
  public void b(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 2) {
      if (paramInt != 1) {
        break label39;
      }
    }
    label39:
    for (bool1 = bool2;; bool1 = false)
    {
      a(paramString, this.jdField_c_of_type_Long, bool1, paramRecorderParam);
      t(paramInt);
      return;
    }
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i1 = 1;
    c(true);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(128);
    h(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "recorderEnd() is called");
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (paramRecorderParam != null) {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label73;
      }
    }
    while (i1 == 0)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      return;
      label73:
      i1 = 0;
    }
    PttBuffer.b(paramString);
  }
  
  protected void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
    }
    while ((paramBoolean) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 19.0F);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (o())
    {
      if (!paramBoolean1) {
        break label41;
      }
      t();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean2, false, false);
      d(true, paramBoolean2);
      this.jdField_j_of_type_Boolean = paramBoolean2;
      return;
      label41:
      u();
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public int c()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "initHaveUnRead count " + i1);
    }
    return i1;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send start: currenttime:" + System.currentTimeMillis());
    }
    Object localObject2;
    Object localObject3;
    int i1;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131296537) == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo == null) {
        break label1544;
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq, 0L);
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        i1 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i1 < ((List)localObject3).size())
        {
          localObject1 = (MessageRecord)((List)localObject3).get(i1);
          if ((!MsgProxyUtils.a((MessageRecord)localObject1)) && (!(localObject1 instanceof MessageForSafeGrayTips)))
          {
            if (((localObject1 instanceof MessageForTroopTopic)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 100)) {
              QQToast.a(a(), 2131365203, 0).b(a().getTitleBarHeight());
            }
          }
          else
          {
            i1 += 1;
            continue;
          }
          if ((localObject1 instanceof MessageForReplyText)) {
            if ((((MessageForReplyText)localObject1).mGroupPostElemInfo != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 100))
            {
              QQToast.a(a(), 2131365203, 0).b(a().getTitleBarHeight());
              return;
            }
          }
        }
      }
    }
    for (;;)
    {
      PicPreDownloadUtils.a((String)localObject2);
      if ((localObject2 != null) && (((String)localObject2).length() > 3478))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131367627, 1);
        return;
        if (((localObject1 instanceof MessageForStructing)) && (StructingMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 100)) {
          QQToast.a(a(), 2131365203, 0).b(a().getTitleBarHeight());
        }
      }
      else
      {
        localObject3 = a((String)localObject2);
        ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
        localSendMsgParams.jdField_b_of_type_Int = this.ea;
        localSendMsgParams.jdField_a_of_type_Int = this.dY;
        localSendMsgParams.jdField_c_of_type_Boolean = this.P;
        localSendMsgParams.jdField_c_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
        localSendMsgParams.jdField_a_of_type_Long = System.currentTimeMillis();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText.length() > jdField_y_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText.substring(0, jdField_y_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = 0;
        }
        localSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
        if ((localObject3 != null) && (localObject3.length == 3))
        {
          localSendMsgParams.jdField_d_of_type_Int = ((Integer)localObject3[0]).intValue();
          localSendMsgParams.jdField_b_of_type_Long = ((Long)localObject3[1]).longValue();
          if ((localObject3[2] != null) && (PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            localSendMsgParams.jdField_a_of_type_JavaLangString = ((String)localObject3[2]);
            localSendMsgParams.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localSendMsgParams.jdField_a_of_type_JavaLangString).booleanValue();
          }
          if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(localSendMsgParams.jdField_b_of_type_Long), Integer.valueOf(localSendMsgParams.jdField_d_of_type_Int), Boolean.valueOf(localSendMsgParams.jdField_d_of_type_Boolean), localSendMsgParams.jdField_a_of_type_JavaLangString }));
          }
        }
        boolean bool;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName)))
          {
            if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
              break label1334;
            }
            bool = true;
            label803:
            localObject3 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "");
            localObject3 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "", (String)localObject3, bool, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
            if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject3);
            }
            List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            i1 = localList.size() - 1;
            label960:
            if (i1 < 0) {
              break label1531;
            }
            localObject3 = (ChatMessage)localList.get(i1);
            if (((ChatMessage)localObject3).shmsgseq != this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq) {
              break label1340;
            }
          }
        }
        for (;;)
        {
          MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "suc_replyMsg", "reply_suc", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (ChatMessage)localObject3);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (localObject1 != null) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (MessageRecord)localObject1, localSendMsgParams)))
          {
            if (!QLog.isColorLevel()) {
              break label1526;
            }
            QLog.d("zivonchen", 2, "TroopTopic commend end-----------------");
            localObject1 = localObject2;
          }
          for (;;)
          {
            a((String)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131296537, null);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
            }
            e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, -1);
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
            }
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1002, new Object[] { localObject1 });
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation != 2) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
            return;
            label1334:
            bool = false;
            break label803;
            label1340:
            i1 -= 1;
            break label960;
            if (localSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) {
              localSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
            }
            localObject2 = new ArrayList();
            localObject1 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject2);
            ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (ArrayList)localObject2, localSendMsgParams);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
            }
            localObject1 = new ArrayList();
            localObject2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
            ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2, null, localSendMsgParams);
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
              localObject1 = localObject2;
              continue;
              label1526:
              localObject1 = localObject2;
            }
          }
          label1531:
          localObject3 = null;
        }
      }
      continue;
      localObject1 = null;
      break;
      label1544:
      localObject1 = null;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setVolumeControlStream(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView.getTag(paramInt2);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      if (!OlympicTorchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        bool2 = false;
      }
      localObject = (OlympicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!((OlympicManager)localObject).b("C2CAIO")) {
          bool1 = false;
        }
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      bool2 = bool1;
      if (bool1) {
        bool2 = ((OlympicManager)localObject).a().a(str);
      }
      if (QLog.isColorLevel()) {
        QLog.i("OlympicTorchManager", 2, "updateSession_updateOlympic, showing:" + bool3 + " show:" + bool2);
      }
      if (bool2) {
        OlympicUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006891", 0, str);
      }
      if (bool2 == bool3) {
        return;
      }
      if (bool2)
      {
        d(paramInt1, paramInt2);
        this.jdField_b_of_type_AndroidWidgetTextView.setTag(2131296642, Boolean.valueOf(false));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, this.jdField_b_of_type_AndroidWidgetTextView.getPaddingTop(), 0, this.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramInt2, Boolean.valueOf(false));
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "updateSession");
    }
    this.X = true;
    StartupTracker.a(null, "AIO_updateSession_initIntentData");
    k(paramIntent);
    StartupTracker.a("AIO_updateSession_initIntentData", "AIO_updateSession_updateUI");
    d(paramIntent);
    a(paramIntent);
    StartupTracker.a("AIO_updateSession_updateUI", "AIO_updateSession_forwardType");
    a(paramIntent, true);
    StartupTracker.a("AIO_updateSession_forwardType", "AIO_updateSession_otherThings");
    m(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    StartupTracker.a("AIO_updateSession_otherThings", null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "AIOTime updateSession end");
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (localObject == null) {}
    for (boolean bool = false; (bool) && (paramChatMessage.msgtype != 63531); bool = ((SharedPreferences)localObject).getBoolean("first_time_revoke_msg", true))
    {
      ((SharedPreferences)localObject).edit().putBoolean("first_time_revoke_msg", false).commit();
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131368034);
      if (paramChatMessage.msgtype == 63531) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131368035);
      }
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage((CharSequence)localObject).setPositiveButton(17039370, new kph(this, paramChatMessage)).show();
      return;
    }
    d(paramChatMessage);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null)
    {
      this.jdField_b_of_type_AndroidAppDialog = LBSHandler.a(this.jdField_a_of_type_AndroidContentContext, paramString, new kpo(this), null);
      if (this.jdField_b_of_type_AndroidAppDialog != null) {
        ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297844)).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131367263));
      }
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296852)).setText(paramString);
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 1;
    if (!paramBoolean)
    {
      this.ei = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getRequestedOrientation();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.b()) {
        if (i3 == 1)
        {
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
          i1 = i2;
          if (VersionUtils.c()) {
            i1 = 7;
          }
          ((FragmentActivity)localObject).setRequestedOrientation(i1);
        }
      }
      label76:
      do
      {
        do
        {
          do
          {
            break label76;
            do
            {
              return;
            } while (i3 != 2);
            localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
            if (VersionUtils.c()) {}
            for (i1 = 6;; i1 = 0)
            {
              ((FragmentActivity)localObject).setRequestedOrientation(i1);
              return;
            }
            if (VersionUtils.f())
            {
              localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindowManager().getDefaultDisplay();
              i2 = ((Display)localObject).getRotation();
              Point localPoint = new Point();
              ((Display)localObject).getSize(localPoint);
              if ((i2 == 0) || (i2 == 2)) {
                if (localPoint.jdField_x_of_type_Int > localPoint.jdField_y_of_type_Int) {
                  if (i2 != 0) {}
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(i1);
                return;
                i1 = 8;
                continue;
                if (i2 == 0)
                {
                  i1 = 1;
                }
                else
                {
                  i1 = 9;
                  continue;
                  if (localPoint.jdField_x_of_type_Int > localPoint.jdField_y_of_type_Int)
                  {
                    if (i2 != 1) {
                      i1 = 8;
                    }
                  }
                  else if (i2 == 1) {
                    i1 = 9;
                  } else {
                    i1 = 1;
                  }
                }
              }
            }
            i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindowManager().getDefaultDisplay().getRotation();
            if ((i1 != 0) && (i1 != 1)) {
              break;
            }
            if (i3 == 1)
            {
              this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(1);
              return;
            }
          } while (i3 != 2);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(0);
          return;
        } while ((i1 != 2) && (i1 != 3));
        if (i3 == 1)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(9);
          return;
        }
      } while (i3 != 2);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(8);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(this.ei);
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (BaseChatItemLayout.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.dU == 0) && (!this.jdField_x_of_type_Boolean) && (r()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("inputx", 2, "showAudioPanelIfNeed return mEnterExtPanel=" + this.dU);
        }
      }
      else if (!this.jdField_d_of_type_Boolean)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if (!localFriendsManager.f())
        {
          ThreadManager.b(new kpn(this));
          return;
        }
        long l1 = System.currentTimeMillis();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
          b(localFriendsManager, paramBoolean1, paramBoolean2);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeed cost :" + (System.currentTimeMillis() - l1) + " isCallFromOnShow = " + paramBoolean1 + " guide = " + paramBoolean2);
          return;
          a(localFriendsManager, paramBoolean1, paramBoolean2);
        }
      }
    }
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public int d()
  {
    return this.jdField_w_of_type_Int;
  }
  
  public void d()
  {
    k(6);
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(25);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131367644));
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      }
    }
    while ((paramInt != 1) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    int i1 = AIOUtils.a(8.0F, a().getResources());
    int i2 = AIOUtils.a(7.0F, a().getResources()) / 2;
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i1);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, paramInt1, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramInt2, Boolean.valueOf(true));
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i2 + i1, this.jdField_b_of_type_AndroidWidgetTextView.getPaddingTop(), 0, this.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
  }
  
  public void d(Intent paramIntent) {}
  
  public void d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != 63531)
    {
      h(paramChatMessage);
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a("撤回后双方文件消息将被删除");
    localActionSheet.b("(若对方非最新版本，则消息撤回可能失败。)");
    localActionSheet.a("撤回", 3);
    localActionSheet.d("取消");
    localActionSheet.a(new kpj(this, paramChatMessage, localActionSheet));
    localActionSheet.show();
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c() == null)
      {
        if (this.jdField_d_of_type_AndroidViewView == null) {
          this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903206, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_d_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c() == null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840536));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
  }
  
  protected boolean d()
  {
    return false;
  }
  
  public int e()
  {
    int i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000;
    int i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((i2 & 0x4) != 0) {
      i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      i1 -= 200;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711687, i1);
      return i1 + 200;
      if ((i2 & 0x2) != 0) {
        i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt") * 1000;
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131296895));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnChangeMultiScreenListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297402));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297407));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297420));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297419));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297082));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297138));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297392));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297405));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297404));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843455);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363354));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369485));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297123));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297403));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297417));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setActTAG("actFPSAIO");
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new kqk(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131296989));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    StartupTracker.a(null, "AIO_apolloFooterview");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
    if (((this.jdField_k_of_type_AndroidViewView == null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (1 == ApolloManager.c("discuss")) && (ApolloManager.jdField_c_of_type_Boolean) && (ApolloActionManager.jdField_a_of_type_Boolean) && (1 == ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f())) && (!ApolloActionManager.a().jdField_b_of_type_Boolean)))
    {
      this.jdField_k_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_k_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(46.0F, this.jdField_k_of_type_AndroidViewView.getResources())));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_k_of_type_AndroidViewView, null, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "add apollo footerview on init UI");
      }
    }
    StartupTracker.a("AIO_apolloFooterview", null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller = new MoveToBottomScroller(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297408));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297412));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.jdField_a_of_type_ComTencentWidgetXEditTextEx$SizeChangedCallback = this.jdField_a_of_type_ComTencentWidgetXEditTextEx$SizeChangedCallback;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(QQTextBuilder.a);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnPrivateIMECommandListener(new kmw(this));
      String str = Build.MODEL;
      DeviceLib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297413));
      if (AppSetting.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription("发送");
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnLongClickListener(new kni(this));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297409));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297416));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297415));
      float f1 = this.jdField_f_of_type_AndroidWidgetTextView.getPaint().measureText("测");
      this.jdField_f_of_type_AndroidWidgetTextView.setMaxWidth((int)(f1 * 9.0F + 0.5F));
      this.jdField_h_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297414);
      az();
      ay();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.aio.BaseChatPie", 1, "input set error", localException);
      }
    }
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_w_of_type_Int = paramInt;
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
    }
  }
  
  public void e(Intent paramIntent)
  {
    String str = null;
    Object localObject = paramIntent.getExtras();
    boolean bool;
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367566);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
      bool = paramIntent.getBooleanExtra("key_jump_from_qzone_feed", false);
      if (!paramIntent.getBooleanExtra("isFromDiscussionFlyTicket", false)) {
        break label335;
      }
      this.J = true;
      if (!this.J) {
        break label456;
      }
      long l1 = System.currentTimeMillis();
      q();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "AIOTime doOnCreate_initUI updateUnreadNumOnTitleBar cost: " + (System.currentTimeMillis() - l1));
      }
    }
    for (;;)
    {
      str = paramIntent.getStringExtra("backName");
      if (!android.text.TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        str = paramIntent.getStringExtra("comicId");
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        paramIntent = str;
        if (str == null) {
          paramIntent = "";
        }
        ((TextView)localObject).setTag(new String[] { "comic", paramIntent });
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回QQ动漫");
      }
      if (ChatActivityConstants.I)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("聊天设置");
        if (!this.J)
        {
          str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
          paramIntent = str;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131366637).equals(str)) {
            paramIntent = "返回" + str + "界面";
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        }
      }
      return;
      if (localObject == null) {
        break;
      }
      this.jdField_h_of_type_Boolean = ((Bundle)localObject).getBoolean("isBack2Root");
      if (!this.jdField_h_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367566);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
      break;
      label335:
      if (bool)
      {
        str = paramIntent.getStringExtra("key_jump_from_qzone_feed_left_title");
        if (str == null) {}
        for (str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131367975);; str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131370484, new Object[] { str }))
        {
          this.J = false;
          break;
        }
      }
      str = paramIntent.getStringExtra("leftViewText");
      if ((this.jdField_h_of_type_Boolean) || ((str != null) && (str.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131367566))))) {}
      for (bool = true;; bool = false)
      {
        this.J = bool;
        break;
      }
      label456:
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      localObject = str;
      if (str == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131367975);
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  public void e(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367976);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    int i10 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels;
    int i9 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131492908) - 5;
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject1 = (RelativeLayout)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297407);
    Object localObject2;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout.LayoutParams(-1, i9);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
      this.jdField_a_of_type_AndroidViewView.setContentDescription("");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      }
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidViewView);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "createMulti");
    }
    int i1;
    int i2;
    label317:
    int i3;
    label327:
    int i4;
    label343:
    int i5;
    label351:
    int i6;
    label359:
    int i7;
    label367:
    int i8;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      localObject2 = new RelativeLayout.LayoutParams(-1, i9);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      int i11 = i10 / 37;
      ((RelativeLayout.LayoutParams)localObject2).setMargins(i11, 0, i11, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (AIOUtils.a(1) != 0) {
        break label1503;
      }
      i1 = 1;
      if (AIOUtils.a(2) != 0) {
        break label1509;
      }
      i2 = 1;
      if (AIOUtils.a(3) != 0) {
        break label1515;
      }
      i3 = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label1521;
      }
      i4 = 1;
      if (i1 == 0) {
        break label1527;
      }
      i5 = 1;
      if (i2 == 0) {
        break label1533;
      }
      i6 = 1;
      if (i3 == 0) {
        break label1539;
      }
      i7 = 1;
      if (i4 == 0) {
        break label1545;
      }
      i8 = 1;
      label375:
      i5 = i8 + (i5 + 1 + i6 + i7);
      i5 = (i10 - i11 * 2 - i9 * i5) / (i5 - 1);
      i6 = i9 * 3 / 20;
      this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_e_of_type_AndroidWidgetImageView.setId(2131296346);
      localObject1 = new LinearLayout.LayoutParams(i9, i9);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_e_of_type_AndroidWidgetImageView.setPadding(i6, i6, i6, i6);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (AppSetting.jdField_j_of_type_Boolean) {
        this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription("删除");
      }
      localObject1 = new StateListDrawable();
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838264);
      ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838265);
      ((StateListDrawable)localObject1).addState(new int[] { 16842910 }, (Drawable)localObject2);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_e_of_type_AndroidWidgetImageView);
      if (i1 != 0)
      {
        this.jdField_f_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_f_of_type_AndroidWidgetImageView.setId(2131296347);
        localObject1 = new LinearLayout.LayoutParams(i9, i9);
        ((LinearLayout.LayoutParams)localObject1).setMargins(i5, 0, 0, 0);
        this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_f_of_type_AndroidWidgetImageView.setPadding(i6, i6, i6, i6);
        this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
        if (AppSetting.jdField_j_of_type_Boolean) {
          this.jdField_f_of_type_AndroidWidgetImageView.setContentDescription("添加到表情");
        }
        localObject1 = new StateListDrawable();
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838288);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838289);
        ((StateListDrawable)localObject1).addState(new int[] { 16842910 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838288);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidWidgetImageView);
      }
      if (i2 != 0)
      {
        this.jdField_g_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_g_of_type_AndroidWidgetImageView.setId(2131296348);
        localObject1 = new LinearLayout.LayoutParams(i9, i9);
        ((LinearLayout.LayoutParams)localObject1).setMargins(i5, 0, 0, 0);
        this.jdField_g_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_g_of_type_AndroidWidgetImageView.setPadding(i6, i6, i6, i6);
        this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this);
        if (AppSetting.jdField_j_of_type_Boolean) {
          this.jdField_g_of_type_AndroidWidgetImageView.setContentDescription("发送到电脑");
        }
        localObject1 = new StateListDrawable();
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838257);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838258);
        ((StateListDrawable)localObject1).addState(new int[] { 16842910 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838257);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_g_of_type_AndroidWidgetImageView);
      }
      if (i3 != 0)
      {
        this.jdField_h_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_h_of_type_AndroidWidgetImageView.setId(2131296349);
        localObject1 = new LinearLayout.LayoutParams(i9, i9);
        ((LinearLayout.LayoutParams)localObject1).setMargins(i5, 0, 0, 0);
        this.jdField_h_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_h_of_type_AndroidWidgetImageView.setPadding(i6, i6, i6, i6);
        this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
        if (AppSetting.jdField_j_of_type_Boolean) {
          this.jdField_h_of_type_AndroidWidgetImageView.setContentDescription("保存到微云");
        }
        localObject1 = new StateListDrawable();
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838369);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838370);
        ((StateListDrawable)localObject1).addState(new int[] { 16842910 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838369);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_h_of_type_AndroidWidgetImageView);
      }
      if (i4 != 0)
      {
        this.jdField_i_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_i_of_type_AndroidWidgetImageView.setId(2131296345);
        if (AppSetting.jdField_j_of_type_Boolean) {
          this.jdField_i_of_type_AndroidWidgetImageView.setContentDescription("转发");
        }
        localObject1 = new LinearLayout.LayoutParams(i9, i9);
        ((LinearLayout.LayoutParams)localObject1).setMargins(i5, 0, 0, 0);
        this.jdField_i_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_i_of_type_AndroidWidgetImageView.setPadding(i6, i6, i6, i6);
        this.jdField_i_of_type_AndroidWidgetImageView.setOnClickListener(this);
        localObject1 = new StateListDrawable();
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838297);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838298);
        ((StateListDrawable)localObject1).addState(new int[] { 16842910 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838297);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.jdField_i_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_i_of_type_AndroidWidgetImageView);
      }
    }
    if (bool) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427638));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297084).setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      }
      a(true, paramChatMessage, false);
      return;
      label1503:
      i1 = 0;
      break;
      label1509:
      i2 = 0;
      break label317;
      label1515:
      i3 = 0;
      break label327;
      label1521:
      i4 = 0;
      break label343;
      label1527:
      i5 = 0;
      break label351;
      label1533:
      i6 = 0;
      break label359;
      label1539:
      i7 = 0;
      break label367;
      label1545:
      i8 = 0;
      break label375;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427368));
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public boolean e()
  {
    if (this.A)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onBackEvent() disableBackForPTV true");
      }
      return false;
    }
    return a(0);
  }
  
  public int f()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "[initApolloSurfaceView], mIsInit:" + ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener);
    ApolloActionManager.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label413;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addOnLayoutChangeListener(this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
    }
    int i1;
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131297417);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131297409);
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(this.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)((float)DeviceInfoUtil.i() * 0.171F));
      localLayoutParams.addRule(2, 2131297409);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, (ViewGroup.LayoutParams)localObject);
      if ((!ApolloActionManager.a().jdField_b_of_type_Boolean) && (this.jdField_k_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
      {
        this.jdField_k_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        i1 = AIOUtils.a(46.0F, this.jdField_k_of_type_AndroidViewView.getResources());
        this.jdField_k_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, i1));
        if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t() != this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.n()) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_k_of_type_AndroidViewView, null, false);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
          a(196608);
        }
      }
      localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if (localObject != null) {
        ((ApolloManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext);
      }
      return;
      label413:
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-AIOUtils.a(5.0F, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
      if (localObject == null) {
        i1 = 0;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_k_of_type_AndroidViewView, null, false);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(i2, i1);
      a(196612);
      break;
      i1 = ((View)localObject).getTop();
      continue;
      i1 = 0;
    }
  }
  
  public void f(int paramInt)
  {
    this.jdField_w_of_type_Int = paramInt;
  }
  
  public void f(Intent paramIntent)
  {
    if (ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramIntent, this.jdField_a_of_type_MqqOsMqqHandler)) {
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isBack2Root", false);
    }
  }
  
  public void f(ChatMessage paramChatMessage)
  {
    MessageRecord localMessageRecord1 = MessageRecordFactory.a(paramChatMessage);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramChatMessage.uniseq);
    Object localObject1 = ((ArrayList)localObject2).iterator();
    MessageRecord localMessageRecord2;
    while (((Iterator)localObject1).hasNext())
    {
      localMessageRecord2 = (MessageRecord)((Iterator)localObject1).next();
      if ((localMessageRecord2 instanceof ChatMessage)) {
        localArrayList.add((ChatMessage)localMessageRecord2);
      }
    }
    localObject1 = new HashMap();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localMessageRecord2 = (MessageRecord)((Iterator)localObject2).next();
      if (!((HashMap)localObject1).containsKey(localMessageRecord2.senderuin))
      {
        String str = MultiMsgManager.a().a(localMessageRecord2.senderuin, localMessageRecord2.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((HashMap)localObject1).put(localMessageRecord2.senderuin, str);
      }
    }
    MultiMsgManager.a().a((HashMap)localObject1, localMessageRecord1.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localMessageRecord1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localArrayList, (HashMap)localObject1, localMessageRecord1, null);
  }
  
  public void f(boolean paramBoolean)
  {
    Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBoolean) {
      if ((localFragment != null) && (((ChatFragment)localFragment).a != null)) {
        ((ChatFragment)localFragment).a.a(false, 0);
      }
    }
    while ((localFragment == null) || (((ChatFragment)localFragment).a == null)) {
      return;
    }
    ((ChatFragment)localFragment).a.a(true, 0);
  }
  
  public boolean f()
  {
    return i();
  }
  
  public int g()
  {
    return this.jdField_r_of_type_Int;
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = new AIOTipsController(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new kqj(this, null);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioAVObserver == null) {
      this.jdField_a_of_type_ComTencentAvGaudioAVObserver = new kqg(this, null);
    }
    this.jdField_j_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.o = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124));
  }
  
  public void g(int paramInt)
  {
    AudioUtil.b(paramInt, false);
  }
  
  public void g(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "doOnNewIntent");
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    n(paramIntent);
    h(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "AIOTime doOnNewIntent end");
    }
  }
  
  public void g(ChatMessage paramChatMessage)
  {
    a(paramChatMessage, 0);
  }
  
  public boolean g()
  {
    return this.W;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips = new QQOperateTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    ReaderTipsBar localReaderTipsBar = new ReaderTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar = new FraudTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_MqqOsMqqHandler);
    SougouInputGrayTips localSougouInputGrayTips = new SougouInputGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    HongbaoKeywordGrayTips localHongbaoKeywordGrayTips = new HongbaoKeywordGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    VipSpecialCareGrayTips localVipSpecialCareGrayTips = new VipSpecialCareGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ComicTipsBar localComicTipsBar = new ComicTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localReaderTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localComicTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localSougouInputGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localHongbaoKeywordGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localVipSpecialCareGrayTips);
  }
  
  public void h(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new knr(this, paramInt));
  }
  
  public void h(Intent paramIntent)
  {
    this.jdField_j_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNewIntent sessionInfo.curFriendUin is null and sessionInfo.curType " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + " troopUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString + " sessionInfo.entrance " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    }
    i(paramIntent);
    this.o = true;
    a(paramIntent, 2);
  }
  
  public boolean h()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    label1091:
    int i1;
    label1933:
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
    case 16711689: 
    case 16711681: 
    case 16711683: 
    case 16711685: 
    case 16711687: 
    case 16711686: 
    case 16711688: 
    case 10: 
    case 41: 
    case 12: 
    case 13: 
    case 14: 
    case 54: 
    case 60: 
    case 15: 
    case 16: 
    case 52: 
    case 17: 
    case 18: 
    case 21: 
    case 44: 
    case 66: 
    case 45: 
    case 48: 
    case 47: 
    case 61: 
    case 62: 
    case 65: 
    case 49: 
    case 51: 
    case 22: 
    case 23: 
    case 16711696: 
    case 24: 
    case 16711697: 
      for (;;)
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "read confirm send readconfirm");
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711689, 300000L);
        ThreadManager.a(new kmc(this), 8, null, false);
        continue;
        paramMessage = (String)paramMessage.obj;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessage))
        {
          a(1);
          continue;
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131368007, 1).b(a());
          continue;
          aH();
          continue;
          e(2);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
          if (this.jdField_c_of_type_Long == 0L)
          {
            g(2131165201);
            continue;
            a(0, null, -1L);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e();
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.f();
                continue;
                if ((paramMessage.obj != null) && ((paramMessage.obj instanceof MessageHandler.MsgSendCostParams)))
                {
                  paramMessage = (MessageHandler.MsgSendCostParams)paramMessage.obj;
                  paramMessage.jdField_e_of_type_Long = (System.currentTimeMillis() - paramMessage.d);
                  MessageHandler.a(paramMessage);
                }
                K();
                if (this.jdField_m_of_type_Int == 0)
                {
                  BubbleDiyFetcher.a().a(a(), 1500);
                  continue;
                  s(paramMessage.arg1);
                  continue;
                  b(paramMessage.arg1, paramMessage.arg2);
                  continue;
                  if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (paramMessage.arg1 > 50))
                  {
                    localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
                    if ((localObject1 != null) && (((RelativeLayout.LayoutParams)localObject1).bottomMargin != paramMessage.arg1))
                    {
                      ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ((RelativeLayout.LayoutParams)localObject1).topMargin, ((RelativeLayout.LayoutParams)localObject1).rightMargin, paramMessage.arg1);
                      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                      continue;
                      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) {
                        paramMessage = "1";
                      }
                      while (paramMessage != null)
                      {
                        if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!ChatBackground.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)))) {
                          break label1091;
                        }
                        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                        QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error. bErrMsg=" + paramMessage + ", show Again img=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                        break;
                        if (paramMessage.obj == null)
                        {
                          paramMessage = "2";
                        }
                        else if (!(paramMessage.obj instanceof Drawable))
                        {
                          paramMessage = "3, msg.obj=" + paramMessage.obj;
                        }
                        else
                        {
                          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable((Drawable)paramMessage.obj);
                          am();
                          paramMessage = null;
                        }
                      }
                      QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error.. bErrMsg=" + paramMessage + ", root=" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer + ", sessionInfo=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.delmsg", 2, "delay MSG_START_VER_ANIM msg is handled,time is:" + System.currentTimeMillis());
                      }
                      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)paramMessage.obj);
                      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16, 300L);
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.delmsg", 2, "ver anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
                      }
                      if (this.jdField_b_of_type_AndroidViewView != null) {
                        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
                      }
                      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getParent() != null)) {
                        ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_c_of_type_AndroidViewViewGroup);
                      }
                      this.jdField_b_of_type_AndroidViewView = null;
                      this.jdField_c_of_type_AndroidViewViewGroup = null;
                      a(196612);
                      continue;
                      a(196612);
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.delmsg", 2, "ver anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
                      }
                      if (this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout != null)
                      {
                        i1 = 0;
                        while (i1 < this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout.length)
                        {
                          if (this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1] != null) {
                            this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1].setVisibility(8);
                          }
                          i1 += 1;
                        }
                      }
                      if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
                      {
                        i1 = 0;
                        while (i1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
                        {
                          if (this.jdField_a_of_type_ArrayOfAndroidViewView[i1] != null) {
                            this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
                          }
                          i1 += 1;
                        }
                      }
                      if (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup != null)
                      {
                        i1 = 0;
                        while (i1 < this.jdField_a_of_type_ArrayOfAndroidViewViewGroup.length)
                        {
                          if ((this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1] != null) && (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1].getParent() != null)) {
                            ((ViewGroup)this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1].getParent()).removeView(this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1]);
                          }
                          i1 += 1;
                        }
                      }
                      this.jdField_a_of_type_ArrayOfAndroidViewView = null;
                      this.jdField_a_of_type_ArrayOfAndroidViewViewGroup = null;
                      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = null;
                      this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet = null;
                      this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout = null;
                      a(65540);
                      continue;
                      a(false, false);
                      continue;
                      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d();
                        continue;
                        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
                        {
                          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.g();
                          continue;
                          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
                          {
                            localObject1 = (ApolloInfo)paramMessage.obj;
                            if (paramMessage.arg1 == 1)
                            {
                              this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.h();
                            }
                            else
                            {
                              this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a((ApolloInfo)localObject1);
                              continue;
                              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
                              {
                                paramMessage = (HashMap)paramMessage.obj;
                                if (paramMessage != null)
                                {
                                  paramMessage.put("offset", "" + a());
                                  this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(paramMessage);
                                  continue;
                                  if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
                                  {
                                    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
                                    continue;
                                    if (this.jdField_k_of_type_AndroidViewView != null)
                                    {
                                      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
                                      localObject1 = (AbsListView.LayoutParams)this.jdField_k_of_type_AndroidViewView.getLayoutParams();
                                      i1 = Math.max(AIOUtils.a(46.0F, this.jdField_k_of_type_AndroidViewView.getResources()), paramMessage.arg1);
                                      if (i1 != this.jdField_k_of_type_AndroidViewView.getHeight())
                                      {
                                        paramMessage = new kmd(this, (AbsListView.LayoutParams)localObject1);
                                        paramMessage = new ValueAnimation(Integer.valueOf(this.jdField_k_of_type_AndroidViewView.getHeight()), Integer.valueOf(i1), paramMessage);
                                        paramMessage.setDuration(300L);
                                        this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(paramMessage);
                                        if (QLog.isColorLevel()) {
                                          QLog.d("Q.aio.BaseChatPie", 2, "apollo footerview change size, listFooter.getHeight():" + this.jdField_k_of_type_AndroidViewView.getHeight() + ", height: " + i1);
                                        }
                                      }
                                    }
                                    else
                                    {
                                      if (1 != ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()))
                                      {
                                        i1 = 1;
                                        if ((i1 == 0) || (ApolloActionManager.a().jdField_b_of_type_Boolean)) {
                                          break label2164;
                                        }
                                      }
                                      label2164:
                                      for (i1 = 1; i1 == 0; i1 = 0)
                                      {
                                        if (QLog.isColorLevel())
                                        {
                                          bool = false;
                                          if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a() instanceof HeaderViewListAdapter)) {
                                            bool = true;
                                          }
                                          QLog.d("Q.aio.BaseChatPie", 2, "apollo footerview MSG_APOLLO_ADD_FOOTER hasAdd: " + bool);
                                        }
                                        if ((this.jdField_k_of_type_AndroidViewView != null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
                                          break;
                                        }
                                        this.jdField_k_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
                                        i1 = Math.max(AIOUtils.a(46.0F, this.jdField_k_of_type_AndroidViewView.getResources()), paramMessage.arg1);
                                        this.jdField_k_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, i1));
                                        if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t() != this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.n())) {
                                          break label2170;
                                        }
                                        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
                                        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_k_of_type_AndroidViewView, null, false);
                                        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
                                        a(196608);
                                        break;
                                        i1 = 0;
                                        break label1933;
                                      }
                                      label2170:
                                      int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
                                      i1 = 0;
                                      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() > 0)
                                      {
                                        paramMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
                                        if (paramMessage != null) {
                                          break label2261;
                                        }
                                      }
                                      label2261:
                                      for (i1 = 0;; i1 = paramMessage.getTop())
                                      {
                                        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
                                        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_k_of_type_AndroidViewView, null, false);
                                        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
                                        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(i2, i1);
                                        a(196612);
                                        break;
                                      }
                                      if (QLog.isColorLevel()) {
                                        QLog.d("Q.aio.BaseChatPie", 2, "apollo footerview MSG_APOLLO_REMOVE_FOOTER");
                                      }
                                      if ((this.jdField_k_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
                                        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_k_of_type_AndroidViewView);
                                      }
                                      this.jdField_k_of_type_AndroidViewView = null;
                                      a(196608);
                                      continue;
                                      f();
                                      continue;
                                      ao();
                                      continue;
                                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
                                      {
                                        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.b();
                                        continue;
                                        b((String)paramMessage.obj);
                                        continue;
                                        j(0);
                                        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
                                        continue;
                                        a(1);
                                        continue;
                                        if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
                                        {
                                          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
                                          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367672, 0).b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131492908));
                                        }
                                        localObject1 = new HashMap();
                                        ((HashMap)localObject1).put("nickCount", paramMessage.arg1 + "");
                                        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "multiMsgNickTimeOut", false, 30000L, 0L, (HashMap)localObject1, "");
                                        continue;
                                        long l1 = System.currentTimeMillis();
                                        if (l1 - this.jdField_f_of_type_Long < 1000L)
                                        {
                                          if (QLog.isColorLevel()) {
                                            QLog.d("Q.aio.BaseChatPie", 2, "MSG_BUBBLE_CACHE_UPDATE, frequency limit, abort");
                                          }
                                        }
                                        else
                                        {
                                          this.jdField_f_of_type_Long = l1;
                                          if (this.jdField_m_of_type_Int == 0) {
                                            break;
                                          }
                                          this.t = true;
                                          if (QLog.isColorLevel()) {
                                            QLog.d("Q.aio.BaseChatPie", 2, "MSG_BUBBLE_CACHE_UPDATE, scrolling, abort");
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
    }
    for (paramMessage = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);; paramMessage = null)
    {
      label2629:
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (paramMessage != null))
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
        if (i1 >= 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
          if ((localObject1 != null) && ((localObject1 instanceof BaseChatItemLayout)))
          {
            localObject2 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject1);
            localObject1 = AIOUtils.a((View)localObject1);
            if ((localObject1 != null) && (((ChatMessage)localObject1).needVipBubble()) && (localObject2 != null) && (((BaseBubbleBuilder.ViewHolder)localObject2).a != null) && (((BaseBubbleBuilder.ViewHolder)localObject2).a.jdField_c_of_type_Int == BubbleUtils.a.jdField_c_of_type_Int) && (paramMessage.a(SVIPHandler.a(((ChatMessage)localObject1).vipBubbleID)))) {
              bool = true;
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "MSG_BUBBLE_CACHE_UPDATE, needRefresh=" + bool);
        }
        if (!bool) {
          break;
        }
        a(196608);
        break;
        if ((localObject2 instanceof TextItemBuilder.Holder))
        {
          localObject2 = (TextItemBuilder.Holder)localObject2;
          FontManager localFontManager = (FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41);
          if ((((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidWidgetTextView instanceof ETTextView))
          {
            if (((ETTextView)((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidWidgetTextView).a == null)
            {
              bool = true;
              continue;
            }
            localObject1 = localFontManager.a((ChatMessage)localObject1);
            if ((localObject1 != null) && (((ETTextView)((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidWidgetTextView).a.mFontId != ((FontInfo)localObject1).jdField_a_of_type_Int))
            {
              bool = true;
              continue;
            }
          }
        }
        i1 -= 1;
        break label2629;
        a(paramMessage);
        break;
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar, new Object[0])) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "BaseChatPie:handleMessage() : TYPE_ON_SHOW =====>");
        }
        ThreadManager.b().post(new kme(this));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "1", "", "", "");
        break;
        if (paramMessage.getData().getBoolean("showRedDot"))
        {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B00", "0X8005B00", 0, 0, "", "", "", "");
          break;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar = new VipFunCallTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new kmf(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar, new Object[0]);
        break;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        break;
        ChatActivityFacade.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        break;
        bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_notice_key", false);
        if ((SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", false)) || (!bool)) {
          break;
        }
        SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", true);
        paramMessage = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
        paramMessage.addFlags(268435456);
        paramMessage.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        BaseApplicationImpl.a().startActivity(paramMessage);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "MSG_SHOW_FASTIMAGE,  mAllowFastImage = " + this.jdField_g_of_type_Boolean);
        }
        if (!this.jdField_g_of_type_Boolean) {
          return true;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
          a(false);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D91", "0X8004D91", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a();
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(this);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33), 5000L);
        break;
        a(true);
        break;
        this.q = false;
        paramMessage = (String)paramMessage.obj;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessage);
        break;
        n(paramMessage.arg1);
        break;
        if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(false);
        break;
        if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(false);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131368033, 0).b(a());
        if (paramMessage.arg1 != 1) {
          break;
        }
        UncommonMessageProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, UncommonMessageProcessor.jdField_h_of_type_Int, UncommonMessageProcessor.jdField_r_of_type_Int);
        break;
        a((String)paramMessage.obj, true, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
        e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 3);
        break;
        ad();
        break;
        a(true, true);
        break;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        break;
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(166)) || (!((OlympicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).b("GroupAIO"))) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
        break;
        aB();
        break;
        bool = false;
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_d_of_type_AndroidViewViewGroup != null)
    {
      View localView = this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131297418);
      if (localView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.topMargin = 0;
        localView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void i(int paramInt)
  {
    if (this.v)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onShowFirst return|" + paramInt);
      }
      return;
    }
    StartupTracker.a("AIO_SysMsgCost", "AIO_onShow_first");
    this.v = true;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "AIOTime onShowFirst|" + paramInt);
    }
    AIOUtils.a(false);
    i(false);
    a(131072);
    if ((u()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(166)) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(63))) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(63, 30000L);
    }
    j();
    k();
    m();
    p(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    d(true);
    knz localknz = new knz(this);
    if (AppSetting.jdField_m_of_type_Boolean) {
      ThreadManager.a(localknz, true);
    }
    for (;;)
    {
      W();
      aV();
      StartupTracker.a(null, "AIO_apolloSurface");
      if ((!a()) && (this.jdField_k_of_type_AndroidViewView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_k_of_type_AndroidViewView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "remove footerview for initApolloSurfaceView failed");
        }
      }
      StartupTracker.a("AIO_apolloSurface", null);
      StartupTracker.a("AIO_onShow_first", null);
      return;
      localknz.run();
    }
  }
  
  public void i(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    paramIntent.getStringExtra("uin");
    paramIntent.getIntExtra("uintype", -1);
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    this.E = false;
    if ((!this.E) || (localBundle.containsKey("forward_type"))) {
      c(paramIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "updateSession_otherThings appShareId=" + localBundle.getLong("res_share_id", 0L));
      }
      return;
      if ((this.jdField_g_of_type_Int != 0) || (bool)) {
        a(true, false);
      } else if (localBundle.getLong("res_share_id", 0L) > 0L) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      }
    }
  }
  
  public boolean i()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public void j()
  {
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView true");
      }
      aC();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView false");
    }
    i();
  }
  
  public void j(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, " setInputStat start stat = " + paramInt + " mInputStat= " + this.jdField_k_of_type_Int + " currenttime:" + System.currentTimeMillis());
    }
    if (paramInt != this.jdField_k_of_type_Int)
    {
      if (paramInt != 1) {
        break label344;
      }
      if (this.jdField_h_of_type_AndroidWidgetTextView == null)
      {
        Button localButton = new Button(this.jdField_a_of_type_AndroidContentContext);
        localButton.setId(2131296340);
        localButton.setBackgroundResource(2130843069);
        localButton.setTextSize(2, 14.0F);
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428255));
        localButton.setText(2131368046);
        localButton.setOnTouchListener(this);
        int i1 = ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).indexOfChild(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localButton, i1, localLayoutParams);
        this.jdField_h_of_type_AndroidWidgetTextView = localButton;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      if (VersionUtils.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 1.0F);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    for (;;)
    {
      this.jdField_k_of_type_Int = paramInt;
      aa();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, " setInputStat end currenttime:" + System.currentTimeMillis());
      }
      return;
      label344:
      if (paramInt != 2) {
        break;
      }
      Z();
    }
    if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    if ((this.dV <= 0) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)) {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      if (!VersionUtils.e()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 1.0F);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
      break;
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
    }
  }
  
  protected void j(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      int i1;
      do
      {
        do
        {
          Bundle localBundle;
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "uploadPreviewPhoto");
            }
            ImageUtil.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.uploadPreviewPhoto:request=" + paramIntent.getIntExtra(AlbumConstants.i, -1));
            localBundle = null;
            if (paramIntent != null) {
              localBundle = paramIntent.getExtras();
            }
          } while (localBundle == null);
          if (localBundle.getBoolean("deleteImage", false))
          {
            a(true, false);
            return;
          }
          i1 = paramIntent.getIntExtra(AlbumConstants.i, -1);
        } while ((i1 != 2) && (i1 != 1));
        paramIntent = paramIntent.getParcelableArrayListExtra("imageInfos");
      } while ((paramIntent == null) || (paramIntent.isEmpty()));
      if (paramIntent.size() == 1)
      {
        if (i1 == 1)
        {
          e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 1);
          return;
        }
        e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 2);
        return;
      }
    } while (paramIntent.size() <= 1);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 4, "" + paramIntent.size());
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0;
  }
  
  protected void k()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      View localView = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297410);
      localView.setBackgroundResource(2130838127);
      localView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(false, false);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297410).setVisibility(8);
  }
  
  public void k(int paramInt)
  {
    EmojiHomeUiPlugin.openEmojiHomePage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramInt);
    if (6 == paramInt) {
      ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
    }
    while (9 != paramInt) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbGiftClick", 0, 0, "", "", "", "");
  }
  
  public boolean k()
  {
    return b() == 1008;
  }
  
  protected void l() {}
  
  public void l(int paramInt)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "beforeVibrate() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_MqqOsMqqHandler.post(new kpg(this));
    }
  }
  
  public boolean l()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      bool = false;
    }
    return bool;
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
    }
  }
  
  public void m(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(paramInt);
    }
  }
  
  public boolean m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "shouldRecordPositionY ");
    }
    this.eh = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.eh == 1)
    {
      if (!((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))
      {
        this.S = false;
        return true;
      }
    }
    else if ((this.eh == 0) || ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() != 0)))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
        this.S = false;
      }
      return true;
    }
    return false;
  }
  
  public void n()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void n(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) {}
    FriendsManager localFriendsManager;
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_Boolean);
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(paramInt, false);
        return;
      }
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        b(localFriendsManager);
        return;
      }
    } while (!v());
    a(localFriendsManager);
  }
  
  public final boolean n()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a() == 0);
  }
  
  public void o()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void o(int paramInt)
  {
    if (ee == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "setVivoSetting isButtom=" + paramInt);
      }
      ThreadManager.b().post(new kpp(this, paramInt));
    }
  }
  
  public boolean o()
  {
    boolean bool = false;
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume())) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 6) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 5)) {
      bool = true;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131297083) {
      AIOUtils.jdField_l_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0) && (i1 != 2131296467) && (i1 != 2131298675))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
      }
      a(true);
    }
    Object localObject1;
    Object localObject2;
    boolean bool1;
    Object localObject3;
    int i2;
    switch (i1)
    {
    default: 
    case 2131297083: 
    case 2131297392: 
    case 2131296339: 
    case 2131297413: 
    case 2131296336: 
    case 2131297009: 
    case 2131296346: 
      do
      {
        long l1;
        long l2;
        do
        {
          do
          {
            return;
            if (BaseChatItemLayout.jdField_b_of_type_Boolean)
            {
              a(false, null, false);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
              {
                paramView = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F8", "0X80064F8", 0, 0, paramView, "", "", "");
              }
            }
            for (;;)
            {
              try
              {
                paramView = this.jdField_a_of_type_AndroidWidgetTextView.getTag();
                localObject1 = (String[])paramView;
                if ((paramView == null) || (!"comic".equals(localObject1[0]))) {
                  break;
                }
                VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", localObject1[1], new String[] { "1" });
                return;
              }
              catch (Exception paramView)
              {
                paramView.printStackTrace();
                return;
              }
              N();
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
              this.O = true;
            }
            o();
            if (QLog.isDevelopLevel()) {
              QLog.d("reportEvent", 4, " curType : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + ", mEntryFriendCard: " + this.O);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", "", "");
            return;
            ApolloManager.b.clear();
            this.dQ = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
            if (this.dQ > 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.b();
              this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.d_() - 1, 0);
            }
            paramView.setVisibility(8);
            return;
            l1 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, " onClick fun_btn start mInputStat = " + this.jdField_k_of_type_Int + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + " currentPanel:" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() + " currenttime:" + System.currentTimeMillis());
            }
            c();
          } while (!QLog.isColorLevel());
          l2 = System.currentTimeMillis();
        } while (!QLog.isColorLevel());
        QLog.d("Q.aio.BaseChatPie", 2, " onClick fun_btn end mInputStat = " + this.jdField_k_of_type_Int + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
        return;
        localObject1 = (Intent)paramView.getTag();
        if (((Intent)localObject1).getIntExtra("uintype", -1) == 0)
        {
          localObject2 = ((Intent)localObject1).getStringExtra("uin");
          if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2))
          {
            ((Intent)localObject1).removeExtra("uintype");
            ((Intent)localObject1).putExtra("uintype", 1003);
          }
        }
        ((Intent)localObject1).putExtra("message_box_click", true);
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        paramView.setVisibility(8);
        if (this.jdField_i_of_type_AndroidViewView != null) {
          this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        }
        i1 = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Intent)localObject1);
        if (i1 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "openAIO by start SplashAct");
          }
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
        }
        while (i1 != 2)
        {
          if ((((Intent)localObject1).getBooleanExtra("finishAIO", false)) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.aio.BaseChatPie", 2, " onClick R.id.msgbox ");
          return;
        }
        QLog.e("Q.aio.BaseChatPie", 1, "openAIO rediectToAIOWithMt 2");
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!this.jdField_j_of_type_Boolean) {}
        for (bool1 = true;; bool1 = false)
        {
          paramView.e(bool1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b();
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B6", "0X80059B6", 0, 0, "", "", "", "");
        paramView = MultiMsgManager.a().a();
        if (paramView.size() != 0) {
          break;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367670, 0).b(a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "0", "", "", "");
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008);
      paramView = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, paramView, "1", "", "");
      return;
      MultiMsgManager.a().b(paramView);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "checklist.size = " + paramView.size());
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "" + paramView.size(), "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
      {
        localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, (String)localObject1, "0", "", "");
      }
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      return;
    case 2131296347: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F6", "0X80067F6", 0, 0, "", "", "", "");
      if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367256, 0).b(a());
        return;
      }
      localObject2 = MultiMsgManager.a().a();
      if (((List)localObject2).size() == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367670, 0).b(a());
        return;
      }
      localObject1 = null;
      i1 = 0;
      for (;;)
      {
        paramView = (View)localObject1;
        if (i1 < ((List)localObject2).size())
        {
          paramView = (ChatMessage)((List)localObject2).get(i1);
          if ((!(paramView instanceof MessageForMarketFace)) && (!(paramView instanceof MessageForPic))) {}
        }
        else
        {
          if (paramView != null) {
            break;
          }
          QLog.e("Q.aio.BaseChatPie", 1, "add to custom face, no market face message or pic message selected");
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367670, 0).b(a());
          return;
        }
        i1 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 1, "add to custom face, selected message=" + paramView);
      }
      if ((paramView instanceof MessageForPic))
      {
        paramView = (MessageForPic)paramView;
        localObject1 = URLDrawableHelper.a(URLDrawableHelper.a(paramView, 1), -1, -1, null, null, false);
        ((URLDrawable)localObject1).setTag(paramView);
        AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject1, paramView.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908), null);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
      }
      for (;;)
      {
        a(false, null, false);
        return;
        if ((paramView instanceof MessageForMarketFace))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
          localObject2 = (MessageForMarketFace)paramView;
          paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131370290));
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          }
          localObject1 = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MessageForMarketFace)localObject2).mMarkFaceMessage);
          localObject3 = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((PicEmoticonInfo)localObject1).a.epId);
          MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = (ChatMessage)localObject2;
          MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = (PicEmoticonInfo)localObject1;
          if ((localObject3 != null) && (((EmoticonPackage)localObject3).name != null) && ((((EmoticonPackage)localObject3).mobileFeetype != 0) || (((EmoticonPackage)localObject3).downloadCount != 0)))
          {
            i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
            i2 = (int)(System.currentTimeMillis() / 1000L);
            if ((i2 - i1 > 86400) || (i2 < i1))
            {
              localObject2 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
              ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject2).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (PicEmoticonInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
              EmojiListenerManager.a().a((EmotionJsonDownloadListener)localObject2);
              ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(((PicEmoticonInfo)localObject1).a.epId, EmojiManager.e);
            }
            else
            {
              MarketFaceItemBuilder.a(6, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PicEmoticonInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
            }
          }
          else
          {
            localObject2 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
            ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject2).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (PicEmoticonInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
            EmojiListenerManager.a().a((EmotionJsonDownloadListener)localObject2);
            ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(((PicEmoticonInfo)localObject1).a.epId, EmojiManager.e);
          }
        }
      }
    case 2131296348: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
      if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367256, 0).b(a());
        return;
      }
      localObject1 = MultiMsgManager.a().a();
      if (((List)localObject1).size() == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367670, 0).b(a());
        return;
      }
      localObject2 = new ArrayList();
      paramView = new ArrayList();
      i1 = 0;
      if (i1 < ((List)localObject1).size())
      {
        localObject3 = (ChatMessage)((List)localObject1).get(i1);
        if ((localObject3 instanceof MessageForTroopFile)) {
          ((ArrayList)localObject2).add((MessageForTroopFile)localObject3);
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((localObject3 instanceof MessageForFile)) {
            paramView.add((MessageForFile)localObject3);
          }
        }
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageForTroopFile)((Iterator)localObject1).next();
          TroopFileUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject2);
        }
      }
      if (paramView.size() > 0)
      {
        localObject1 = new ArrayList();
        paramView = paramView.iterator();
        while (paramView.hasNext())
        {
          localObject2 = (MessageForFile)paramView.next();
          localObject3 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject2);
          if ((((FileManagerEntity)localObject3).cloudType != 0) && (((FileManagerEntity)localObject3).cloudType != 2)) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        if (((ArrayList)localObject1).size() == 0)
        {
          FMToastUtil.a(2131362945);
          return;
        }
        paramView = ((ArrayList)localObject1).iterator();
        while (paramView.hasNext())
        {
          localObject1 = (MessageForFile)paramView.next();
          FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1, BaseActivity.sTopActivity);
        }
      }
      a(false, null, false);
      return;
    case 2131296349: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F8", "0X80067F8", 0, 0, "", "", "", "");
      if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367256, 0).b(a());
        return;
      }
      localObject2 = MultiMsgManager.a().a();
      if (((List)localObject2).size() == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367670, 0).b(a());
        return;
      }
      if (((List)localObject2).size() == 1)
      {
        paramView = (ChatMessage)((List)localObject2).get(0);
        if ((paramView instanceof MessageForTroopFile)) {
          TroopFileUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        }
        for (;;)
        {
          label2541:
          a(false, null, false);
          return;
          if ((paramView instanceof MessageForFile))
          {
            if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramView).cloudType == 0)
            {
              FMToastUtil.a(2131362946);
              return;
            }
            FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, BaseActivity.sTopActivity);
          }
        }
      }
      paramView = null;
      localObject1 = new ArrayList();
      i1 = 0;
      if (i1 < ((List)localObject2).size())
      {
        paramView = (ChatMessage)((List)localObject2).get(i1);
        if (!(paramView instanceof MessageForTroopFile)) {
          break;
        }
      }
      break;
    }
    for (i1 = 63519;; i1 = 64537)
    {
      if (i1 == 63519)
      {
        if (TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramView.frienduin)) == null) {
          break;
        }
        paramView = (MessageForTroopFile)paramView;
        paramView = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        if ((paramView == null) || (paramView.jdField_e_of_type_JavaLangString == null)) {
          break;
        }
        FMToastUtil.b(this.jdField_a_of_type_AndroidContentContext.getString(2131362815, new Object[] { FileManagerUtil.d(paramView.g), Integer.valueOf(((List)localObject2).size()) }));
        TroopFileUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject2);
      }
      if (((ArrayList)localObject1).size() <= 0) {
        break label2541;
      }
      paramView = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageForFile)((Iterator)localObject1).next();
          if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject2).cloudType != 0)
          {
            paramView.add(localObject2);
            continue;
            if ((paramView instanceof MessageForFile)) {
              ((ArrayList)localObject1).add((MessageForFile)paramView);
            }
            i1 += 1;
            break;
          }
        }
      }
      if (paramView.size() == 0)
      {
        FMToastUtil.a(2131362946);
        return;
      }
      paramView = paramView.iterator();
      while (paramView.hasNext())
      {
        localObject1 = (MessageForFile)paramView.next();
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1, BaseActivity.sTopActivity);
      }
      if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367256, 0).b(a());
        return;
      }
      paramView = new ArrayList();
      localObject1 = MultiMsgManager.a().a();
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      if (((List)localObject1).size() == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367670, 0).b(a());
        return;
      }
      i2 = 0;
      Iterator localIterator = ((List)localObject1).iterator();
      i1 = 0;
      for (;;)
      {
        label2993:
        Object localObject4;
        int i3;
        MessageForPic localMessageForPic;
        boolean bool2;
        if (localIterator.hasNext())
        {
          localObject4 = (ChatMessage)localIterator.next();
          i3 = i2;
          if ((localObject4 instanceof MessageForShortVideo))
          {
            i3 = i2;
            if (((MessageForShortVideo)localObject4).busiType != 2)
            {
              ((List)localObject2).add(localObject4);
              i3 = i2 + 1;
            }
          }
          if ((localObject4 instanceof MessageForTroopFile))
          {
            ((List)localObject3).add(localObject4);
            i2 = i3;
            continue;
          }
          if (!MultiMsgProxy.a((ChatMessage)localObject4))
          {
            localIterator.remove();
            if (!(localObject4 instanceof MessageForPtt)) {
              break label3977;
            }
            PttInfoCollector.a(8);
            i1 = 1;
            i2 = i3;
            continue;
          }
          i2 = i3;
          if (!(localObject4 instanceof MessageForPic)) {
            continue;
          }
          localMessageForPic = (MessageForPic)localObject4;
          bool2 = URLDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic, 65537);
          if (FlashPicHelper.a((MessageRecord)localObject4))
          {
            bool1 = false;
            label3165:
            if (bool1) {
              break label3974;
            }
            i1 = 1;
            localIterator.remove();
          }
        }
        label3974:
        for (;;)
        {
          i2 = i3;
          break label2993;
          bool1 = bool2;
          if (!localMessageForPic.isSendFromLocal()) {
            break label3165;
          }
          bool1 = bool2;
          if (localMessageForPic.size > 0L) {
            break label3165;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
          bool1 = bool2;
          if (!(localObject4 instanceof BaseTransProcessor)) {
            break label3165;
          }
          localObject4 = (BaseTransProcessor)localObject4;
          if ((((BaseTransProcessor)localObject4).c() != 1003L) && (((BaseTransProcessor)localObject4).d() != 1003L)) {}
          for (bool1 = false;; bool1 = bool2) {
            break;
          }
          if (i2 > 1)
          {
            i1 = 1;
            ((List)localObject1).removeAll((Collection)localObject2);
          }
          if (((List)localObject3).size() > 0)
          {
            i1 = 1;
            ((List)localObject1).removeAll((Collection)localObject3);
          }
          if (((List)localObject1).size() == 0)
          {
            DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131368040)).setPositiveButton(17039370, new kmk(this)).setNegativeButton(17039360, new kmj(this)).show();
            return;
          }
          if (((List)localObject1).size() == 1)
          {
            if (i2 == 1) {
              i1 = 0;
            }
            if (i1 != 0)
            {
              DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131368040)).setPositiveButton(17039370, new kmn(this, (List)localObject1)).setNegativeButton(17039360, new kmm(this)).show();
              return;
            }
            paramView = (ChatMessage)((List)localObject1).get(0);
            if ((paramView instanceof MessageForShortVideo))
            {
              localObject1 = (MessageForShortVideo)paramView;
              if (!((MessageForShortVideo)localObject1).checkForward())
              {
                if ((!((MessageForShortVideo)localObject1).isSend()) && ((((MessageForShortVideo)localObject1).videoFileStatus == 2002) || (((MessageForShortVideo)localObject1).videoFileStatus == 2001) || (((MessageForShortVideo)localObject1).videoFileStatus == 2004)))
                {
                  QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131371545), 0).a();
                  return;
                }
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131371544), 0).a();
                return;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).a(2131297425, this.jdField_a_of_type_AndroidContentContext, paramView);
            return;
          }
          if (i2 == 1)
          {
            ((List)localObject1).removeAll((Collection)localObject2);
            i1 = 1;
          }
          if (i1 != 0)
          {
            DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131368040)).setPositiveButton(17039370, new kmp(this, (List)localObject1, paramView)).setNegativeButton(17039360, new kmo(this)).show();
            return;
          }
          a((List)localObject1, paramView);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("fastimage", 2, "BaseCHatPie onClick call enterPhotoPreivew. path = " + PlusPanelUtils.jdField_b_of_type_JavaLangString);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D92", "0X8004D92", 0, 0, "", "", "", "");
          PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit().putString("camera_photo_path", PlusPanelUtils.jdField_b_of_type_JavaLangString).commit();
          localObject1 = null;
          paramView = (View)localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
          {
            paramView = (View)localObject1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
            {
              paramView = (View)localObject1;
              if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
              {
                paramView = new Intent();
                paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
              }
            }
          }
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, paramView, 8);
          if (QLog.isColorLevel()) {
            QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
          }
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(33);
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.aio.BaseChatPie", 2, "onClick case R.id.input");
          return;
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
          return;
        }
        label3977:
        i1 = 1;
        i2 = i3;
      }
    }
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNetMobile2Wifi readconfirm network change");
    }
    if (this.M)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNetNone2Mobile readconfirm network change");
    }
    if (this.M)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNetNone2Wifi readconfirm network change");
    }
    if (this.M)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNetWifi2Mobile readconfirm network change");
    }
    if (this.M)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  public void onNetWifi2None() {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      a(true);
    }
    switch (paramView.getId())
    {
    case 2131297412: 
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramMotionEvent);
    }
    if (i1 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return false;
      if ((i1 == 1) || (i1 == 3)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(true);
      }
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
    if ((4 == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_f_of_type_AndroidViewView != null) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void p(int paramInt)
  {
    Object localObject = FlowCameraActivity2.class;
    if (CameraCompatibleList.d(CameraCompatibleList.jdField_c_of_type_JavaLangString)) {
      localObject = MX3FlowCameraActivity.class;
    }
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
    ((Intent)localObject).putExtra("flow_camera_height", XPanelContainer.jdField_c_of_type_Int);
    ((Intent)localObject).putExtra("selected_item", 5);
    ((Intent)localObject).putExtra("selected_data", this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a());
    ((Intent)localObject).putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((Intent)localObject).putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.NewShortVideoConfig.name(), null));
    ((Intent)localObject).putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
    q((Intent)localObject);
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)) {
      ((Intent)localObject).putExtra("flow_camera_capture_mode", true);
    }
    if (paramInt == 1) {
      ((Intent)localObject).putExtra("flow_camera_capture_mode", true);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("flow_camera_use_filter_function", PtvFilterSoLoad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject, 11000);
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005E7D", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
      if (PeakUtils.a != null) {
        PeakUtils.a.b();
      }
      return;
      if (paramInt == 2) {
        ((Intent)localObject).putExtra("flow_camera_video_mode", true);
      }
    }
  }
  
  public boolean p()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  void q()
  {
    Object localObject;
    int i1;
    if (this.J)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localObject != null) && (!BaseChatItemLayout.jdField_b_of_type_Boolean))
      {
        i1 = ((QQMessageFacade)localObject).e();
        if (i1 <= 0) {
          break label155;
        }
        localObject = "" + i1;
        if (i1 > 99) {
          localObject = "99+";
        }
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131367566) + "(" + (String)localObject + ")";
      }
    }
    for (String str = "返回" + this.jdField_a_of_type_AndroidContentContext.getString(2131367566) + "界面，" + i1 + "条未读";; str = "返回" + this.jdField_a_of_type_AndroidContentContext.getString(2131367566) + "界面")
    {
      a((String)localObject, str);
      return;
      label155:
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131367566);
    }
  }
  
  public void q(int paramInt)
  {
    if (paramInt < 0)
    {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(true);
      o(1);
      this.D = true;
    }
  }
  
  public boolean q()
  {
    return false;
  }
  
  protected void r()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843170);
  }
  
  public boolean r()
  {
    if (!this.C) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((Intent)localObject1).getStringExtra("panel");
      if ((localObject2 != null) && (((String)localObject2).equals("ptv"))) {
        return false;
      }
      if (((Intent)localObject1).getBooleanExtra("PhotoConst.SEND_FLAG", false)) {
        return false;
      }
    }
    long l2 = 80L;
    long l1 = l2;
    if (localObject1 != null)
    {
      l1 = l2;
      if (((Intent)localObject1).getExtras() != null)
      {
        l1 = l2;
        if (((Intent)localObject1).getExtras().containsKey("forward_type")) {
          l1 = 800L;
        }
      }
    }
    if (this.jdField_w_of_type_Boolean) {
      l1 = 300L;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("inputx", 2, "autoShowInput delayTime=" + l1);
      }
      int i2 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("aio_autoinput_time", 900);
      if (QLog.isColorLevel()) {
        QLog.i("inputx", 2, "autoShowInput auto_time=" + i2);
      }
      if (i2 <= 0) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("inputx", 2, "autoShowInput return currentPanle=" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
        }
        return true;
      }
      if (this.B)
      {
        if (QLog.isColorLevel()) {
          QLog.d("inputx", 2, "autoShowInput return hasAutoInput");
        }
        return true;
      }
      l2 = -1L;
      long l3 = NetConnInfoCenter.getServerTime();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      int i1 = ((List)localObject2).size() - 1;
      if (i1 >= 0)
      {
        localObject1 = (ChatMessage)((List)localObject2).get(i1);
        if ((localObject1 instanceof MessageForGrayTips)) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if ((!((ChatMessage)localObject1).isSend()) || (((ChatMessage)localObject1).msgtype == 63534))
          {
            return false;
            i1 -= 1;
            break;
          }
          l2 = ((ChatMessage)localObject1).time;
        }
        if (QLog.isColorLevel()) {
          QLog.d("inputx", 2, "lastMsgTimeOrSeq=" + l2 + "currentTime=" + l3 + "diff=" + (l3 - l2));
        }
        if ((l2 != -1L) && (l3 - l2 < i2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("inputx", 2, "SOFT_INPUT_PANEL!!!!!!!!!!!");
          }
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(59), l1);
          this.B = true;
          return true;
        }
        return false;
        localObject1 = null;
      }
    }
  }
  
  public void s()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = str;
  }
  
  protected boolean s()
  {
    return true;
  }
  
  public void setting()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, EmosmActivity.class);
    localIntent.putExtra("extra_launch_source", 1);
    localIntent.putExtra("extra_launch_mode", 2);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131559024);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setBackgroundResource(2130837571);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public boolean t()
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView.getTag(2131296642);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "isTitleInteractiveIconShowing isShowing=" + bool);
      }
      return bool;
    }
  }
  
  public void u()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public boolean u()
  {
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))) {
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {}
    }
    label532:
    label1391:
    label1444:
    for (;;)
    {
      return;
      paramObservable = ((SplashActivity)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((paramObservable == null) || (paramObservable.isVisible())) {
        if (paramObject != null)
        {
          if ((paramObject instanceof MessageRecord)) {
            if ((paramObject instanceof ChatMessage))
            {
              paramObservable = (MessageRecord)paramObject;
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.BaseChatPie", 2, "update mr.msgseq" + paramObservable.msgseq + ",time is:" + System.currentTimeMillis() + " status:" + paramObservable.extraflag);
              }
              if (o()) {
                AioAnimationDetector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
              }
              if (!paramObservable.isSendFromLocal())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("sendback", 2, "update mr.isBlessMsg" + paramObservable.isBlessMsg);
                }
                if ((paramObservable.msgtype == 64532) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin))) {
                  continue;
                }
                if (a(paramObservable)) {
                  if (o())
                  {
                    if ((!paramObservable.isread) && ((paramObservable instanceof MessageForShakeWindow)))
                    {
                      MessageForShakeWindow localMessageForShakeWindow = (MessageForShakeWindow)paramObservable;
                      localMessageForShakeWindow.parse();
                      if ((localMessageForShakeWindow.mShakeWindowMsg != null) && (localMessageForShakeWindow.mShakeWindowMsg.onlineFlag == 1))
                      {
                        if (this.jdField_b_of_type_JavaUtilList == null) {
                          this.jdField_b_of_type_JavaUtilList = new ArrayList();
                        }
                        this.jdField_b_of_type_JavaUtilList.add(localMessageForShakeWindow);
                      }
                    }
                    if ((!paramObservable.isread) && ((paramObservable instanceof MessageForPoke)) && (!paramObservable.isSend())) {
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramObservable.uniseq), (MessageForPoke)paramObservable);
                    }
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                      HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    }
                    this.M = true;
                    this.N = true;
                    if ((!paramObservable.isSend()) && (paramObservable.msgtype == 63497) && (!ApolloManager.b.contains(Long.valueOf(paramObservable.uniseq)))) {
                      ApolloManager.b.add(Long.valueOf(paramObservable.uniseq));
                    }
                    if (((this instanceof PublicAccountChatPie)) && (((PublicAccountChatPie)this).R) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t() == this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1)) {
                      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new knd(this), 800L);
                    }
                  }
                  else
                  {
                    this.p = true;
                  }
                }
                for (;;)
                {
                  q();
                  if ((paramObject == null) || ((!(paramObject instanceof MessageForStructing)) && (!(paramObject instanceof MessageForText)))) {
                    break;
                  }
                  AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, (ChatMessage)paramObject);
                  return;
                  a(196608);
                  break label532;
                  if ((paramObservable.istroop == 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.senderuin)) && (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
                  {
                    if ((String.valueOf(AppConstants.aq).equalsIgnoreCase(paramObservable.frienduin)) && (!paramObservable.isread))
                    {
                      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
                    }
                    else
                    {
                      if (o())
                      {
                        this.N = true;
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
                        a(196608);
                      }
                      this.p = true;
                    }
                  }
                  else if ((o()) && (!paramObservable.isread) && ((paramObservable.msgtype != 63530) || (!(paramObject instanceof MessageForFoldMsg)))) {
                    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
                  }
                }
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              }
              this.M = true;
              this.p = true;
              if (paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                a(true, true);
              }
              if (((paramObservable instanceof MessageForStructing)) && ((paramObservable.istroop == 1) || (paramObservable.istroop == 3000) || (paramObservable.istroop == 0)))
              {
                if (!"viewMultiMsg".equals(((MessageForStructing)paramObservable).structingMsg.mMsgAction)) {
                  continue;
                }
                MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.frienduin, paramObservable.istroop, paramObservable.uniseq, true);
                return;
              }
              if ((!(paramObservable instanceof MessageForText)) || (paramObservable.istroop != 3000) || (paramObservable.extraflag != 0)) {
                continue;
              }
              paramObservable = (MessageForText)paramObservable;
              if ((paramObservable.atInfoList == null) || (paramObservable.atInfoList.size() <= 0)) {
                continue;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006211", "0X8006211", 0, 0, "", "", "", "");
              if ((paramObservable.atInfoList != null) && (paramObservable.atInfoList.size() == 1))
              {
                if (((MessageForText.AtTroopMemberInfo)paramObservable.atInfoList.get(0)).isIncludingAll()) {
                  continue;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006212", "0X8006212", 0, 0, "", "", "", "");
                return;
              }
              if ((paramObservable.atInfoList == null) || (paramObservable.atInfoList.size() <= 1)) {
                continue;
              }
              paramObservable = paramObservable.atInfoList.iterator();
              do
              {
                if (!paramObservable.hasNext()) {
                  break;
                }
              } while (!((MessageForText.AtTroopMemberInfo)paramObservable.next()).isIncludingAll());
            }
          }
          for (int i1 = 1;; i1 = 0)
          {
            if (i1 != 0) {
              break label1444;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006213", "0X8006213", 0, 0, "", "", "", "");
            return;
            paramObservable = (MessageRecord)paramObject;
            if (((paramObject instanceof DataLineMsgRecord)) && (!paramObservable.isread) && (!paramObservable.isSendFromLocal())) {
              a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
            }
            q();
            return;
            if ((paramObject instanceof QQMessageFacade.RefreshMessageContext))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = ((QQMessageFacade.RefreshMessageContext)paramObject);
              paramObservable = (ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.a())) || (this.jdField_b_of_type_Long != paramObservable.a()) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_d_of_type_Boolean)) {
                break;
              }
              paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaUtilList;
              if ((paramObservable != null) && (paramObservable.size() > 0)) {
                this.jdField_f_of_type_Int += 1;
              }
              boolean bool;
              long l1;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Boolean)
              {
                bool = true;
                this.L = bool;
                l1 = this.jdField_b_of_type_Long + 300L - SystemClock.uptimeMillis();
                if (l1 <= 0L) {
                  break label1391;
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new kne(this), l1);
                return;
                bool = false;
                break;
                l1 = 0L;
              }
            }
            if (!(paramObject instanceof QQMessageFacade.MessageNotifyParam)) {
              break;
            }
            paramObservable = (QQMessageFacade.MessageNotifyParam)paramObject;
            if ((!paramObservable.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramObservable.jdField_b_of_type_Int != 0)) {
              break;
            }
            a(false, true);
            return;
          }
        }
      }
    }
  }
  
  public void v() {}
  
  public void w()
  {
    if (this.F)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "doOnDestroy return");
      }
      return;
    }
    this.F = true;
    this.jdField_r_of_type_Int = 6;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnDestroy", hashCode(), this.jdField_r_of_type_Int);
    ArkContainerWrapper.a(2);
    this.ed = 0;
    this.dQ = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c());
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_k_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
    }
    this.jdField_k_of_type_AndroidViewView = null;
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeOnLayoutChangeListener(this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
    }
    i();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.b();
    }
    af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.i();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
    }
    ApolloMsgPlayController.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "hashcode:" + hashCode() + ",cur:" + ApolloActionManager.a().jdField_f_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = null;
    }
    ApolloActionManager.a().g();
    if (ApolloActionManager.a().jdField_d_of_type_Int > 0) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "play_times", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(ApolloActionManager.a().jdField_d_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
    }
    a(false, null, false);
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
    }
    ChatActivityUtils.b();
    ChatActivityFacade.a();
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_e_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_k_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_k_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_l_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_l_of_type_AndroidWidgetTextView.getBackground());
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 62526);
      MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 61516);
    }
    if (AITranslator.a()) {
      AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext, true);
    }
    MultiMsgManager.a().a();
    this.Q = false;
    this.dY = 60;
    this.ea = 0;
    this.ec = 0;
    ThreadManager.b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    AioAnimationDetector.a().a();
    ThridAppShareHelper.a().a();
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    Object localObject = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
    }
    R = true;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(false) != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(false).clear();
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131296537, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji = null;
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null) {
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    PerformanceReportUtils.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    PttSSCMPool.a();
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.jdField_a_of_type_Long = 0L;
    if (ee == 1) {
      o(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.d();
    }
    ChatActivityUtils.a();
    ThreadPriorityManager.a(false);
    localObject = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null) {
      ((FileTransferManager)localObject).b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.jdField_a_of_type_ComTencentWidgetXEditTextEx$SizeChangedCallback = null;
    }
    ApolloManager.jdField_a_of_type_JavaUtilArrayList.clear();
    QQLiveImage.releaseAll();
    StructMsgVideoController.a().c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache.a();
    NowVideoController.a().c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilHashMap.clear();
    localObject = new kmq(this);
    if (AppSetting.jdField_m_of_type_Boolean)
    {
      ThreadManager.a((Runnable)localObject, true);
      return;
    }
    ((Runnable)localObject).run();
  }
  
  public void x()
  {
    a(1);
  }
  
  public void y()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str = localIntent.getStringExtra("key_nearby_qzone_to_aio");
    if ((str != null) && (str.equals("nearby_qzone_to_aio")))
    {
      str = localIntent.getStringExtra("uin");
      localIntent.putExtra("key_has_talk", LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
    }
  }
  
  protected void z()
  {
    this.jdField_r_of_type_Int = 2;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnStart", hashCode(), this.jdField_r_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\BaseChatPie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */