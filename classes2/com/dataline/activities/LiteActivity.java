package com.dataline.activities;

import aa;
import al;
import am;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aq;
import ar;
import as;
import at;
import au;
import av;
import aw;
import ax;
import ay;
import az;
import ba;
import bb;
import bc;
import bd;
import bf;
import bg;
import bh;
import bi;
import bj;
import bk;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.ItemHolder;
import com.dataline.util.ItemHolder.FileItemHolder;
import com.dataline.util.ItemHolder.ImageItemHolder;
import com.dataline.util.ItemHolder.MutiImageItemHolder;
import com.dataline.util.ItemHolder.TextItemHolder;
import com.dataline.util.file.FileUtil;
import com.dataline.util.file.SendInfo;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconCallback;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.BottomBtnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import cooperation.qqdataline.MpFileConstant;
import cooperation.qqdataline.QQProxyForDataline;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import s;
import t;
import u;
import v;
import w;
import x;
import y;
import z;

public class LiteActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, PanelIconLinearLayout.PanelIconCallback, PhotoListPanel.BottomBtnClickListener, XPanelContainer.PanelCallback, Observer
{
  static final int jdField_a_of_type_Int = 14;
  public static final long a = 100000002432L;
  public static String a;
  static final int jdField_b_of_type_Int = 15;
  public static final String b = "dataline_text_cache_pc";
  public static final int c = 0;
  public static final String c = "dataline_text_cache_ipad";
  public static final int d = 1;
  public static final String d = "key_text";
  public static final int e = 2;
  public static final String e = "dataline_share_finish";
  public static final int f = 3;
  static final String f = "LASTFROM";
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 9;
  public static final int m = 101;
  public static final int n = 102;
  public static final int o = 103;
  public static final int r = 55;
  public static final int s = 56;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  public View.OnTouchListener a;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  LiteActivity.LiteJumpAction jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction;
  public DatalineSessionAdapter a;
  public ShareAioResultDialog a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  PanelIconLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new aa(this);
  DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = null;
  FastImagePreviewLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new aw(this);
  ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
  public ScrollerRunnable a;
  public BubblePopupWindow a;
  public XEditTextEx a;
  public XListView a;
  public XPanelContainer a;
  public Runnable a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long;
  public View.OnClickListener b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  public boolean b;
  TextView c;
  protected boolean c;
  protected boolean d;
  boolean e = false;
  public boolean f = true;
  public String g = AppConstants.aj;
  public int p = -1;
  int q;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "dataline.LiteActivity";
  }
  
  public LiteActivity()
  {
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = null;
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new v(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new w(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new as(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new at(this);
    this.jdField_a_of_type_JavaLangRunnable = new ay(this);
  }
  
  static Drawable a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = Shader.TileMode.REPEAT;
        Drawable localDrawable = paramContext.getResources().getDrawable(2130838119);
        if ((localDrawable instanceof BitmapDrawable))
        {
          localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
          paramString = ((BitmapDrawable)localDrawable).getTileModeX();
          i1 = ((BitmapDrawable)localDrawable).getGravity();
          if ((localBitmap == null) || (paramString == Shader.TileMode.REPEAT) || (i1 != 48)) {
            return paramContext.getResources().getDrawable(2130838119);
          }
        }
        else
        {
          if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
            break label188;
          }
          localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
          paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
          i1 = ((SkinnableBitmapDrawable)localDrawable).getGravity();
          continue;
        }
        paramString = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
        paramString.setGravity(i1);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 1", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130843104);
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 2", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130843104);
      }
      label188:
      int i1 = 119;
      Bitmap localBitmap = null;
    }
  }
  
  public static void a(Context paramContext)
  {
    t localt = new t();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131368978), paramContext.getString(2131362202), 2131362120, 2131362120, localt, null).show();
  }
  
  static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    View localView = paramIphoneTitleBarActivity.findViewById(2131297920);
    if (ThemeUtil.isInNightMode(paramIphoneTitleBarActivity.app)) {
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    while (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
  
  public static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup)
  {
    int i1 = 0;
    SharedPreferences localSharedPreferences = paramIphoneTitleBarActivity.getSharedPreferences("chat_background_path_" + paramIphoneTitleBarActivity.app.a(), 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.aj;
    arrayOfString[1] = "chat_uniform_bg";
    if ((localSharedPreferences.getString(arrayOfString[0], null) == null) && (localSharedPreferences.getString(arrayOfString[1], null) == null))
    {
      a(paramIphoneTitleBarActivity, paramViewGroup, "null");
      return;
    }
    int i2 = arrayOfString.length;
    for (;;)
    {
      if (i1 >= i2) {
        break label203;
      }
      String str = localSharedPreferences.getString(arrayOfString[i1], null);
      if (str != null)
      {
        if (("".equals(str)) || ("null".equals(str)) || ("none".equals(str)))
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, str);
          return;
        }
        if (!new File(str).exists())
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, "null");
          return;
        }
        if (a(paramIphoneTitleBarActivity, paramViewGroup, str)) {
          break;
        }
      }
      i1 += 1;
    }
    label203:
    a(paramIphoneTitleBarActivity, paramViewGroup, "null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    paramContext = FileUtil.b(paramContext, paramString);
    ((DataLineHandler)paramQQAppInterface.a(8)).a(paramString, paramContext, 1, 0L, 0, 0, 0, false);
  }
  
  public static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.postDelayed(new al(paramXListView, paramScrollerRunnable), 200L);
    }
  }
  
  public static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView, int paramInt)
  {
    if (paramXListView != null) {}
    try
    {
      paramScrollerRunnable.a(paramInt, -1, null);
      paramXListView.setTranscriptMode(1);
      return;
    }
    catch (SecurityException paramScrollerRunnable)
    {
      for (;;)
      {
        paramXListView.setSelection(paramInt);
      }
    }
    catch (IllegalArgumentException paramScrollerRunnable)
    {
      for (;;)
      {
        paramXListView.setSelection(paramInt);
      }
    }
  }
  
  public static void a(XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.setSelection(paramXListView.d_());
    }
  }
  
  static boolean a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup, String paramString)
  {
    Object localObject = (String)paramViewGroup.getTag(2131296449);
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      if (!"null".equals(localObject))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131296449, "null");
      }
    }
    for (;;)
    {
      return true;
      if ("none".equals(paramString))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131296449, "null");
      }
      else if (!paramString.equals(localObject))
      {
        localObject = BitmapManager.a(paramString);
        if (localObject == null) {
          break;
        }
        localObject = new ChatBackgroundDrawable(paramIphoneTitleBarActivity.getResources(), (Bitmap)localObject);
        paramViewGroup.setBackgroundDrawable((Drawable)localObject);
        paramViewGroup.setTag(2131296449, paramString);
        paramViewGroup.setTag(2131296450, localObject);
        a(paramIphoneTitleBarActivity);
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      do
      {
        return true;
        paramQQAppInterface = paramQQAppInterface.a().a(paramLong);
      } while (paramQQAppInterface == null);
      if ((paramQQAppInterface.getCloudType() != 2) && (paramQQAppInterface.status == 1)) {
        return false;
      }
      if (paramQQAppInterface.nOpType != 6) {
        return false;
      }
    } while (paramQQAppInterface.status != 1);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    return a(paramQQAppInterface, paramDataLineMsgRecord.nWeiyunSessionId);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.p == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131362168);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838423);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  private void s()
  {
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    }
    while (i1 == 0) {
      if (!this.e)
      {
        b(true);
        return;
        i1 = 0;
      }
      else
      {
        b(false);
        return;
      }
    }
    b(false);
  }
  
  public View a(int paramInt)
  {
    Object localObject = null;
    long l1;
    Intent localIntent;
    String str1;
    if (paramInt == 4)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = ((PhotoListPanel)View.inflate(this, 2130904078, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setCustomOnClickListener(this);
      localIntent = new Intent();
      str1 = this.app.getAccount();
      localObject = ((FriendsManager)this.app.getManager(50)).c(str1);
      if (localObject == null) {
        break label261;
      }
    }
    label261:
    for (localObject = ((Friends)localObject).name;; localObject = null)
    {
      String str2 = this.app.a(1, str1, 0);
      localIntent.putExtra("key_my_uin", str1);
      localIntent.putExtra("key_my_nick", (String)localObject);
      localIntent.putExtra("key_my_head_dir", str2);
      localIntent.putExtra("key_disable_presend", true);
      localIntent.putExtra("key_disable_quality_cb", true);
      localIntent.putExtra("key_allow_mix_select", true);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 50);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 100000002432L);
      localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005F28");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - l1));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
      return (View)localObject;
    }
  }
  
  DataLineMsgRecord a(DataLineHandler paramDataLineHandler, SendInfo paramSendInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSendInfo == null) {
      return null;
    }
    paramDataLineHandler = new DataLineMsgRecord();
    String str1 = paramSendInfo.a();
    String str2 = paramSendInfo.b();
    paramDataLineHandler.sessionid = paramSendInfo.a();
    paramDataLineHandler.path = str1;
    paramDataLineHandler.thumbPath = str2;
    paramDataLineHandler.msgtype = DataLineHandler.c(paramInt1);
    paramDataLineHandler.groupId = paramInt2;
    paramDataLineHandler.groupSize = paramInt3;
    paramDataLineHandler.groupIndex = paramInt4;
    return paramDataLineHandler;
  }
  
  DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().a(paramForwardFileInfo.b());
    if (localFileManagerEntity == null) {}
    int i3;
    do
    {
      return null;
      i3 = DataLineHandler.a(localFileManagerEntity);
    } while (!DataLineHandler.c(i3));
    int i2 = DataLineHandler.a(paramForwardFileInfo.d(), paramBoolean);
    int i1 = i2;
    if (!paramBoolean)
    {
      i1 = i2;
      if (i2 == 1) {
        i1 = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = DataLineHandler.c(i1);
    localDataLineMsgRecord.sessionid = ((DataLineHandler)this.app.a(8)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.d();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.d();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.b();
    localDataLineMsgRecord.fileFrom = i3;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.f();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = HexUtil.a(localFileManagerEntity.strFileMd5);
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
    }
    if (TextUtils.isEmpty(paramForwardFileInfo.a())) {}
    for (localDataLineMsgRecord.path = paramForwardFileInfo.d();; localDataLineMsgRecord.path = paramForwardFileInfo.a()) {
      return localDataLineMsgRecord;
    }
  }
  
  String a()
  {
    String str;
    if (this.p == 1) {
      str = AppConstants.ak;
    }
    for (int i1 = 6003;; i1 = 6000)
    {
      return DraftTextManager.a(this.app).a(this.app, str, i1);
      str = AppConstants.aj;
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297878));
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130840536));
    View localView = LayoutInflater.from(this).inflate(2130903206, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.getCount());
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ar(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new bb(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
  }
  
  void a(long paramLong, String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(getString(2131368655));
    String str2 = getString(2131364595);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new bg(this, paramLong, this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))) {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a(paramIntent);
    }
  }
  
  public void a(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.e(getActivity()))
    {
      FMToastUtil.a(2131368805);
      return;
    }
    Object localObject2 = "";
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    Object localObject1;
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 3145728L)) {
      localObject1 = getString(2131362851);
    }
    label79:
    int i1;
    for (;;)
    {
      if (((String)localObject1).equals(""))
      {
        localObject1 = getString(2131362129);
        localObject2 = (ActionSheet)ActionSheetHelper.a(this, null);
        ((ActionSheet)localObject2).a((CharSequence)localObject1);
        ((ActionSheet)localObject2).a(getResources().getString(2131362802), 1);
        ((ActionSheet)localObject2).d(2131367262);
        ((ActionSheet)localObject2).a(new x(this, localDataLineMsgSet, paramItemHolder, (ActionSheet)localObject2));
        ((ActionSheet)localObject2).show();
        return;
        if (localDataLineMsgSet.getGroupType() == 64536)
        {
          localObject1 = getString(2131362130);
        }
        else
        {
          localObject1 = localObject2;
          if (localDataLineMsgSet.getGroupType() == 63536)
          {
            localObject1 = localObject2;
            if (!localDataLineMsgSet.isSingle())
            {
              localObject1 = localDataLineMsgSet.values().iterator();
              i1 = 0;
              label193:
              if (((Iterator)localObject1).hasNext())
              {
                if (!DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject1).next())) {
                  break label255;
                }
                i1 += 1;
              }
            }
          }
        }
      }
    }
    label255:
    for (;;)
    {
      break label193;
      localObject1 = String.format(getString(2131362229), new Object[] { Integer.valueOf(i1) });
      break;
      break label79;
    }
  }
  
  public void a(PhotoListPanel paramPhotoListPanel)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAlbumBtnClicked");
    }
    if (!paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {}
    for (ArrayList localArrayList = new ArrayList(paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList);; localArrayList = null)
    {
      a(localArrayList);
      paramPhotoListPanel.g();
      ReportController.b(null, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
      return;
    }
  }
  
  void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.app.a(paramMessage))) {
      return;
    }
    Intent localIntent = this.app.a(this, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    runOnUiThread(new ax(this, paramMessage, localIntent));
  }
  
  public void a(Object paramObject)
  {
    AIOUtils.l = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {}
    do
    {
      return;
      int i1 = ((Integer)paramObject).intValue();
      if (i1 == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        return;
      }
      switch (i1)
      {
      default: 
        return;
      case 4: 
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
        ReportController.b(this.app, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
        return;
      case 5: 
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_cktkphoto");
        g();
        ReportController.b(this.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
        return;
      case 16: 
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_ckfile");
        paramObject = new Intent(getApplicationContext(), FMActivity.class);
        ((Intent)paramObject).putExtra("category", 6);
        ((Intent)paramObject).putExtra("selectMode", true);
        ((Intent)paramObject).putExtra("targetUin", AppConstants.aj);
        ((Intent)paramObject).putExtra("tab_tab_type", 5);
        ((Intent)paramObject).putExtra("max_select_count", 50);
        startActivityForResult((Intent)paramObject, 2);
        overridePendingTransition(2130968585, 2130968586);
        ReportController.b(this.app, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
        return;
      }
      if (a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    d();
    ReportController.b(null, "CliOper", "", "", MpFileConstant.u, MpFileConstant.u, 0, 0, "", "", "", "");
    paramObject = new Bundle();
    ((Bundle)paramObject).putBoolean("string_from", false);
    ((Bundle)paramObject).putBoolean("string_uin", false);
    ((Bundle)paramObject).putLong("device_din", 0L);
    ((Bundle)paramObject).putInt("sTitleID", 0);
    QQProxyForDataline.a(this, (Bundle)paramObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
  }
  
  void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.length() > 3478)
    {
      QQToast.a(this, "字数超出限制", 1).b(getTitleBarHeight());
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((DataLineHandler)this.app.a(8)).a(paramString, this.p);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (!b()) {
      b(null);
    }
    int i1;
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return;
      i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
      localDataLineMsgRecord = this.app.a().a(i1).b(paramLong);
    } while (localDataLineMsgRecord == null);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
    localDataLineMsgRecord.bIsResendOrRecvFile = true;
    switch (paramInt)
    {
    default: 
      this.app.a().a(i1).a(paramLong);
      a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 1, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 2, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      if (localDataLineMsgRecord.nOpType == 31)
      {
        if (!NetworkUtil.e(this))
        {
          FMToastUtil.a(2131362941);
          return;
        }
        TroopFileTransferManager.a(this.app, localDataLineMsgRecord.uOwnerUin).a(2, localDataLineMsgRecord.uOwnerUin, localDataLineMsgRecord.busId, Long.valueOf(localDataLineMsgRecord.selfuin).longValue(), localDataLineMsgRecord.istroop, localDataLineMsgRecord.filename, localDataLineMsgRecord.thumbPath, localDataLineMsgRecord.filesize, localDataLineMsgRecord.fileUuid, true, localDataLineMsgRecord.sessionid, FileManagerUtil.a(this.app, i1));
      }
      else if (localDataLineMsgRecord.nOpType == 29)
      {
        this.app.a().a(3, localDataLineMsgRecord.trans2Entity(), i1);
      }
      else
      {
        localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 0, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    Intent localIntent = new Intent(this, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    localIntent.putExtra(AlbumConstants.i, 55);
    localIntent.putExtra("uin", AppConstants.aj);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("LASTFROM", this.leftView.getText().toString());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = getBaseContext().getSharedPreferences("album_file", 0);
    String str = ((SharedPreferences)localObject).getString("album_key_name", null);
    localObject = ((SharedPreferences)localObject).getString("album_key_id", null);
    localIntent.putExtra("ALBUM_NAME", str);
    localIntent.putExtra("ALBUM_ID", (String)localObject);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    }
    startActivity(localIntent);
    AlbumUtil.a(this, false, true);
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMultipleFile paths is null !!!!!!");
      }
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
        }
        i1 += 1;
      }
    }
    bh localbh = new bh(this, paramArrayList);
    paramArrayList = paramArrayList.iterator();
    long l1 = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l1 += new File(str).length();
      }
    }
    if (l1 == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.h(this)) && (!NetworkUtil.i(this)) && (l1 > 3145728L))
    {
      FMDialogUtil.a(this, 2131362855, 2131362851, new bi(this, localbh, paramInt));
      return;
    }
    localbh.execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  void a(List paramList)
  {
    if (paramList == null) {}
    ArrayList localArrayList1;
    do
    {
      return;
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        int i1 = FileManagerUtil.a(str);
        if (2 == i1) {
          localArrayList1.add(str);
        } else if (i1 == 0) {
          localArrayList2.add(str);
        }
      }
      if (!localArrayList2.isEmpty())
      {
        paramList = new Bundle();
        paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList2);
        new bj(this).execute(new Bundle[] { paramList });
      }
    } while (localArrayList1.isEmpty());
    paramList = new Bundle();
    paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList1);
    new bk(this).execute(new Bundle[] { paramList });
  }
  
  public void a(Observable paramObservable, Object paramObject)
  {
    h();
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      int i1 = DataLineMsgRecord.getDevTypeBySeId(paramObservable.sessionid);
      DataLineMsgSet localDataLineMsgSet = this.app.a(i1).a(paramObservable.sessionid);
      if (QLog.isDevelopLevel()) {
        QLog.d("AutoTest_Xandy", 4, "SessionID:" + paramObservable.sessionid + ", Show:" + System.currentTimeMillis());
      }
      if ((DataLineMsgSet.isSingle(paramObservable)) || (localDataLineMsgSet == null) || (localDataLineMsgSet.getComeCount() <= 1)) {
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    label145:
    label264:
    do
    {
      break label145;
      for (;;)
      {
        if ((paramObject instanceof ChatMessage))
        {
          paramObservable = (MessageRecord)paramObject;
          if ((!paramObservable.isSendFromLocal()) && (paramObservable.msgtype != 64532)) {
            break label264;
          }
        }
        return;
        if (!this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(paramObservable.sessionid, this.jdField_a_of_type_ComTencentWidgetXListView))
        {
          this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
          continue;
          if ((paramObject instanceof QQMessageFacade.Message))
          {
            paramObservable = (QQMessageFacade.Message)paramObject;
            if (paramObservable.frienduin == null) {
              break;
            }
            if (!paramObservable.frienduin.endsWith(String.valueOf(AppConstants.aj))) {
              continue;
            }
            this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
            continue;
          }
          if ((paramObject instanceof RecentUser))
          {
            paramObservable = (RecentUser)paramObject;
            if (paramObservable.uin == null) {
              break;
            }
            if (paramObservable.uin.endsWith(String.valueOf(AppConstants.aj))) {
              this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
            }
          }
        }
      }
      paramObject = (HotChatManager)this.app.getManager(59);
    } while ((paramObservable.isread) || (((HotChatManager)paramObject).b(paramObservable.frienduin)));
    a(this.app.a().a());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    this.app.a().a(this.p).e();
    if (!paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
      a(this.jdField_a_of_type_ComTencentWidgetXListView);
    }
  }
  
  protected boolean a()
  {
    return this.f;
  }
  
  public boolean a(long paramLong)
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      l();
      return false;
    }
    if (Build.VERSION.SDK_INT >= 18) {}
    for (long l1 = new StatFs(AppConstants.bh).getAvailableBytes(); l1 < paramLong; l1 = new StatFs(AppConstants.bh).getAvailableBlocks() * new StatFs(AppConstants.bh).getBlockSize())
    {
      k();
      return false;
    }
    return true;
  }
  
  boolean a(Intent paramIntent, int paramInt)
  {
    paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (paramIntent == null) {}
    boolean bool;
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return false;
        localFileManagerEntity = this.app.a().a(paramIntent.b());
      } while (localFileManagerEntity == null);
      int i1 = DataLineHandler.a(localFileManagerEntity);
      switch (i1)
      {
      case 0: 
      default: 
        QLog.w(jdField_a_of_type_JavaLangString, 1, "forwardFile fileFrom " + i1 + " is not handled");
        return false;
      case 3: 
        if (paramInt != 101) {
          break label156;
        }
        bool = true;
        paramIntent = a(paramIntent, bool, this.p);
      }
    } while (paramIntent == null);
    ((DataLineHandler)this.app.a(8)).a(paramIntent, false);
    for (;;)
    {
      return true;
      label156:
      bool = false;
      break;
      this.app.a().a(3, paramIntent.b(), this.p);
      continue;
      if (this.p == 0) {
        this.app.a().a(paramIntent.b(), paramIntent.e(), paramIntent.a(), Long.parseLong(this.app.a()), 7, paramIntent.a());
      } else {
        this.app.a().a(paramIntent.b(), paramIntent.e(), paramIntent.a(), Long.parseLong(this.app.a()), 6003, paramIntent.a());
      }
    }
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g())) {
      return true;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ItemHolder localItemHolder = (ItemHolder)paramView.getTag();
    DataLineMsgSet localDataLineMsgSet = localItemHolder.a();
    String str1 = "";
    DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
    int i1 = localDataLineMsgSet.getGroupType();
    Object localObject;
    String str2;
    if (localDataLineMsgSet.isSingle())
    {
      RelativeLayout localRelativeLayout;
      switch (localDataLineMsgSet.getGroupType())
      {
      default: 
        localRelativeLayout = null;
      }
      while (localRelativeLayout == null)
      {
        return false;
        localRelativeLayout = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localQQCustomMenu.a(2131305415, paramView.getContext().getString(2131369291));
        localQQCustomMenu.a(2131297425, paramView.getContext().getString(2131369281));
        localQQCustomMenu.a(2131299841, paramView.getContext().getString(2131365886));
        continue;
        localRelativeLayout = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        str1 = localDataLineMsgRecord.path;
        continue;
        if (localDataLineMsgRecord.bIsMoloImage) {}
        for (localRelativeLayout = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;; localRelativeLayout = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout)
        {
          str1 = localDataLineMsgRecord.path;
          break;
        }
      }
      Context localContext = localRelativeLayout.getContext();
      if (localDataLineMsgRecord.canForward()) {
        localQQCustomMenu.a(2131297425, localContext.getString(2131362158));
      }
      localObject = localRelativeLayout;
      str2 = str1;
      if (FileUtils.b(str1))
      {
        localObject = localRelativeLayout;
        str2 = str1;
        if (localDataLineMsgRecord.strMoloKey == null)
        {
          if (localDataLineMsgSet.getGroupType() == 63536) {
            localQQCustomMenu.a(2131299841, paramView.getContext().getString(2131365886));
          }
          localObject = localRelativeLayout;
          str2 = str1;
          if (a(this.app, localDataLineMsgRecord))
          {
            localQQCustomMenu.a(2131305416, localContext.getString(2131362157));
            str2 = str1;
            localObject = localRelativeLayout;
          }
        }
      }
      paramView = ((RelativeLayout)localObject).getContext();
      localQQCustomMenu.a(2131305406, paramView.getString(2131362156));
      if ((localDataLineMsgSet.getGroupType() != 63536) && ((localDataLineMsgSet.getGroupType() != 63201) || (!localDataLineMsgRecord.bIsMoloImage))) {
        break label606;
      }
    }
    label606:
    for (boolean bool = true;; bool = false)
    {
      paramView = new am(this, localDataLineMsgRecord, localDataLineMsgSet, paramView, i1, str2, bool);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, (int)this.jdField_a_of_type_AndroidGraphicsPointF.y, localQQCustomMenu, paramView);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new aq(this));
      return true;
      switch (localDataLineMsgSet.getGroupType())
      {
      default: 
        paramView = null;
      }
      for (;;)
      {
        localObject = paramView;
        str2 = str1;
        if (paramView != null) {
          break;
        }
        return false;
        paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        continue;
        if (localDataLineMsgRecord.bIsMoloImage) {
          paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        } else {
          paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
      }
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131297412));
    if (this.jdField_a_of_type_AndroidTextTextWatcher != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(QQTextBuilder.a);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        DeviceLib.a(this, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        f();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new bd(this));
        return;
        this.jdField_a_of_type_AndroidTextTextWatcher = new bc(this);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "input set error", localException);
      }
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    q();
    if (paramInt2 == 0) {
      this.e = false;
    }
    for (;;)
    {
      s();
      return;
      if (1 == paramInt2) {
        this.e = true;
      }
    }
  }
  
  protected void b(Intent paramIntent)
  {
    int i1 = this.p;
    String str = this.g;
    this.g = paramIntent.getStringExtra("targetUin");
    if ((this.g != null) && (this.g.length() != 0)) {
      if (this.g.equals(AppConstants.ak))
      {
        setTitle(2131362119);
        this.p = 1;
      }
    }
    for (;;)
    {
      paramIntent = (DataLineHandler)this.app.a(8);
      paramIntent.b = this.g;
      paramIntent.ad = this.p;
      return;
      setTitle(2131362118);
      this.p = 0;
      continue;
      if (this.p == -1)
      {
        this.p = paramIntent.getIntExtra("device_type", -1);
        if (this.p == 1)
        {
          setTitle(2131362119);
          this.g = AppConstants.ak;
        }
        else
        {
          setTitle(2131362118);
          this.g = AppConstants.aj;
          this.p = 0;
        }
      }
      else
      {
        this.p = i1;
        this.g = str;
      }
    }
  }
  
  public void b(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.e(getActivity()))
    {
      FMToastUtil.a(2131368805);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 3145728L)) {}
    for (paramItemHolder = getString(2131362852);; paramItemHolder = "")
    {
      ArrayList localArrayList = new ArrayList();
      long l1 = 0L;
      Object localObject = localDataLineMsgSet.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
        {
          localDataLineMsgRecord.bIsResendOrRecvFile = true;
          localDataLineMsgRecord.fileMsgStatus = 0L;
          localDataLineMsgRecord.progress = 0.0F;
          l1 += localDataLineMsgRecord.filesize;
          localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
        }
      }
      if ((localArrayList.size() == 0) && (!localDataLineMsgSet.isSingle()))
      {
        int i1 = localDataLineMsgSet.getTotalCount() - localDataLineMsgSet.getComeCount();
        if ((localDataLineMsgSet.getGroupType() == 63536) || ((localDataLineMsgSet.getGroupType() == 63201) && (localDataLineMsgSet.getFirstItem().bIsMoloImage))) {}
        for (paramItemHolder = String.format(getString(2131362231), new Object[] { Integer.valueOf(i1) });; paramItemHolder = String.format(getString(2131362230), new Object[] { Integer.valueOf(i1) }))
        {
          localObject = new y(this);
          DialogUtil.a(this, 230, getString(2131362133), paramItemHolder, 2131367263, 2131367263, null, (DialogInterface.OnClickListener)localObject).show();
          return;
        }
      }
      localObject = paramItemHolder;
      if (paramItemHolder.equals(""))
      {
        localObject = paramItemHolder;
        if (localDataLineMsgSet.getGroupType() == 63536)
        {
          localObject = paramItemHolder;
          if (!localDataLineMsgSet.isSingle()) {
            localObject = String.format(getString(2131362228), new Object[] { Integer.valueOf(localArrayList.size()) });
          }
        }
      }
      paramItemHolder = (ItemHolder)localObject;
      if (((String)localObject).equals("")) {
        paramItemHolder = getString(2131362132);
      }
      localObject = (ActionSheet)ActionSheetHelper.a(this, null);
      ((ActionSheet)localObject).a(paramItemHolder);
      ((ActionSheet)localObject).a(getResources().getString(2131362800), 1);
      ((ActionSheet)localObject).d(2131367262);
      ((ActionSheet)localObject).a(new z(this, l1, localDataLineMsgSet, localArrayList, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
  }
  
  public void b(PhotoListPanel paramPhotoListPanel)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.iterator();
    long l1 = 0L;
    if (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      int i1 = paramPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(str);
      if (1 == i1) {
        localArrayList.add(str);
      }
      for (;;)
      {
        l1 += new File(str).length();
        break;
        if (i1 == 0) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    if (l1 == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.h(this)) && (!NetworkUtil.i(this)) && (l1 > 3145728L)) {
      FMDialogUtil.a(this, 2131362855, 2131362851, new ba(this, (ArrayList)localObject1, localArrayList));
    }
    for (;;)
    {
      paramPhotoListPanel.g();
      ReportController.b(null, "CliOper", "", "", "0X8005A2F", "0X8005A2F", 0, 0, paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() + "", "", "", "");
      return;
      if (!((ArrayList)localObject1).isEmpty())
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
        new bj(this).execute(new Bundle[] { localObject2 });
      }
      if (!localArrayList.isEmpty())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
        new bk(this).execute(new Bundle[] { localObject1 });
      }
    }
  }
  
  void b(String paramString)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.msgtype = 63202;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    localDataLineMsgRecord.issend = 255;
    localDataLineMsgRecord.msg = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.appendToList(localDataLineMsgRecord);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  void b(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    DataLineHandler localDataLineHandler;
    int i2;
    int i1;
    Object localObject;
    for (;;)
    {
      return;
      localDataLineHandler = (DataLineHandler)this.app.a(8);
      i2 = paramArrayList.size();
      if (i2 > 3) {
        break;
      }
      i1 = 0;
      while (i1 < i2)
      {
        localObject = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramInt, 0, 0, 0);
        if (localObject != null) {
          localDataLineHandler.a((DataLineMsgRecord)localObject, false);
        }
        i1 += 1;
      }
    }
    label112:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((i2 > 3) && (i2 < 50))
    {
      localObject = new ArrayList();
      int i3 = localDataLineHandler.a();
      i1 = 0;
      if (i1 < i2)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramInt, i3, i2, i1);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, i3)) {
          break label394;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label251:
    label391:
    label394:
    for (;;)
    {
      i1 += 1;
      break label112;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localDataLineHandler.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      i2 = localDataLineHandler.a();
      i1 = 0;
      if (i1 < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramInt, i2, 50, i1);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, i2)) {
          break label391;
        }
        localDataLineMsgRecord.groupId = 0;
        localDataLineMsgRecord.groupIndex = 0;
        localDataLineMsgRecord.groupSize = 0;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      for (;;)
      {
        i1 += 1;
        break label251;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        i1 = 0;
        while (i1 < 50)
        {
          paramArrayList.remove(0);
          i1 += 1;
        }
        break;
      }
    }
  }
  
  boolean b()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.a(10);
    return (localRegisterProxySvcPackHandler.a() == 0) || (localRegisterProxySvcPackHandler.g() != 0);
  }
  
  void c()
  {
    if (this.p == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.ak;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 6003;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.aj;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 6000;
  }
  
  void c(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent.getIntExtra("aio_msg_source", 999) == 1) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      if (this.jdField_c_of_type_Boolean)
      {
        AIOUtils.l = false;
        this.d = false;
      }
      return;
      bool = false;
    }
  }
  
  void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.path = paramString;
    localDataLineMsgRecord.msgtype = 63527;
    localDataLineHandler.a(localDataLineMsgRecord, false);
  }
  
  protected void d()
  {
    this.f = false;
    new Handler().postDelayed(new bf(this), 1500L);
  }
  
  void d(Intent paramIntent)
  {
    paramIntent = null;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("camera_photo_path", "");
    if (!((String)localObject).equalsIgnoreCase(""))
    {
      com.tencent.mobileqq.activity.aio.PlusPanelUtils.jdField_a_of_type_JavaLangString = (String)localObject;
      paramIntent = Uri.fromFile(new File((String)localObject));
    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = ImageUtil.c(this, paramIntent);
    if (paramIntent != null)
    {
      ImageUtil.a(this, paramIntent);
      if (!FileUtils.e(paramIntent))
      {
        QQToast.a(this, getString(2131368697), 0).b(getTitleBarHeight());
        return;
      }
      if (!new File(paramIntent).exists()) {
        QQToast.a(this, getString(2131368698), 0).b(getTitleBarHeight());
      }
    }
    else
    {
      QQToast.a(this, getString(2131368698), 0).b(getTitleBarHeight());
      return;
    }
    localObject = new Intent();
    ArrayList localArrayList = new ArrayList();
    ((Intent)localObject).setClass(this, CameraPreviewActivity.class);
    localArrayList.add(paramIntent);
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    ((Intent)localObject).putExtra(AlbumConstants.i, 55);
    ((Intent)localObject).putExtra("uin", AppConstants.aj);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    ((Intent)localObject).putExtra("LASTFROM", this.leftView.getText().toString());
    startActivity((Intent)localObject);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (!b()) {
      b(null);
    }
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
                        do
                        {
                          return;
                          switch (paramInt1)
                          {
                          case 4: 
                          default: 
                            return;
                          }
                        } while ((paramInt2 != -1) || (paramIntent == null));
                        paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
                      } while ((paramIntent == null) || (paramIntent.size() <= 0));
                      b(paramIntent, 1);
                      paramIntent.clear();
                      a(false);
                      return;
                    } while (paramInt2 != -1);
                    d(paramIntent);
                    return;
                  } while ((paramInt2 != -1) || (paramIntent == null));
                  paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
                } while ((paramIntent == null) || (paramIntent.size() <= 0));
                b(paramIntent, 2);
                paramIntent.clear();
                a(false);
                return;
              } while (paramInt2 != -1);
              a(false);
              return;
            } while ((paramInt2 != -1) || (paramIntent == null));
            paramIntent = paramIntent.getExtras().getString("textMsg");
          } while (paramIntent.length() <= 0);
          a(paramIntent);
          return;
        } while (paramInt2 != -1);
        a(false);
        return;
        s();
      } while ((paramInt2 != -1) || (paramIntent == null));
      return;
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
    } while (paramInt2 != -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramInt1, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427369);
    setContentView(2130903251);
    setTitle(2131362118);
    getWindow().setBackgroundDrawable(null);
    b(getIntent());
    c(getIntent());
    i();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297876));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297967));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297966));
    if (this.p == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8005D19", "0X8005D19", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "=== dataline report event into ipad 0X8005D19 ");
      }
    }
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction = new LiteActivity.LiteJumpAction(this, this);
    this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    Object localObject1 = this.app.a();
    if (localObject1 != null) {
      ((QQMessageFacade)localObject1).addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = this.app.a(this.p).a(true);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = new DatalineSessionAdapter(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList, this, this.app);
    a();
    b();
    localObject1 = (DataLineHandler)this.app.a(8);
    ((DataLineHandler)localObject1).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297420));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131296895));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)findViewById(2131297408));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297875));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    o();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    n();
    this.app.a().a(this.p).e();
    if (paramBundle == null) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new s(this), 200L);
    }
    a(getIntent());
    paramBundle = (RegisterProxySvcPackHandler)this.app.a(10);
    if ((paramBundle.a() == 0) && (!paramBundle.a()))
    {
      paramBundle.a();
      paramBundle.a(true);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.isEmpty())
    {
      paramBundle = getSharedPreferences("first_enter_dataline", 0);
      int i1 = paramBundle.getInt("year", -1);
      int i2 = paramBundle.getInt("month", -1);
      int i3 = paramBundle.getInt("day", -1);
      Object localObject2 = Calendar.getInstance();
      int i4 = ((Calendar)localObject2).get(1);
      int i5 = ((Calendar)localObject2).get(2);
      int i6 = ((Calendar)localObject2).get(5);
      if ((i4 != i1) || (i5 != i2) || (i6 != i3))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() - 1);
        if (localObject2 != null)
        {
          localObject2 = ((DataLineMsgSet)localObject2).getFirstItem();
          if ((localObject2 != null) && (((DataLineMsgRecord)localObject2).msgtype != 60536) && (((DataLineMsgRecord)localObject2).msgtype != 64536))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              DataLineMsgSet localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject2).next();
              if (localDataLineMsgSet != null)
              {
                DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
                if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.msgtype == 60536)) {
                  try
                  {
                    ((Iterator)localObject2).remove();
                    this.app.a(this.p).a(localDataLineMsgSet);
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                  }
                }
              }
            }
            localObject1 = ((DataLineHandler)localObject1).a(0, this.p);
            localObject2 = new DataLineMsgRecord();
            ((DataLineMsgRecord)localObject2).msgId = ((Long)localObject1).longValue();
            ((DataLineMsgRecord)localObject2).sessionid = ((Long)localObject1).longValue();
            ((DataLineMsgRecord)localObject2).msgtype = 60536;
            ((DataLineMsgRecord)localObject2).time = MessageCache.a();
            ((DataLineMsgRecord)localObject2).isread = true;
            this.app.a(this.p).a((DataLineMsgRecord)localObject2);
            paramBundle = paramBundle.edit();
            paramBundle.putInt("year", i4);
            paramBundle.putInt("month", i5);
            paramBundle.putInt("day", i6);
            paramBundle.commit();
          }
        }
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    if (this.app.a() != null)
    {
      this.app.a().a(this.p).e();
      this.app.a().a(this.p).d();
      this.app.a().deleteObserver(this);
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
    this.p = -1;
    if (this.app.a() != null) {
      this.app.a().e();
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    FileManagerUtil.b(this);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    i(paramIntent);
    e();
    h(paramIntent);
    e(paramIntent);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ((DataLineHandler)this.app.a(8)).d();
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if ((this.jdField_b_of_type_Boolean) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "finishing LiteActivity (ask ippan)");
      }
      finish();
      com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  void e()
  {
    String str;
    int i1;
    Object localObject1;
    if (this.p == 1)
    {
      str = AppConstants.ak;
      i1 = 6003;
      localObject1 = null;
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
      }
      localObject2 = a();
      if ((!StringUtil.b((String)localObject2)) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (!StringUtil.b(String.valueOf(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText())))) {
        break label82;
      }
    }
    label82:
    while ((!StringUtil.b((String)localObject2)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (((String)localObject2).equals(String.valueOf(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))))
    {
      return;
      str = AppConstants.aj;
      i1 = 6000;
      break;
    }
    Object localObject2 = DraftTextManager.a(this.app);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = str;
      localDraftTextInfo.type = i1;
      localDraftTextInfo.text = ((CharSequence)localObject1).toString();
      localDraftTextInfo.time = NetConnInfoCenter.getServerTimeMillis();
      ((DraftTextManager)localObject2).a(this.app, localDraftTextInfo);
    }
    for (;;)
    {
      localObject1 = this.app.a();
      localObject2 = ((DraftTextManager)localObject2).a(this.app, str, i1);
      if (localObject2 == null) {
        break;
      }
      ((QQMessageFacade)localObject1).a(str, i1, "", ((DraftSummaryInfo)localObject2).getSummary(), ((DraftSummaryInfo)localObject2).getTime());
      return;
      ((DraftTextManager)localObject2).a(this.app, str, i1);
    }
    ((QQMessageFacade)localObject1).a(str, i1, "", "", 0L);
  }
  
  public void e(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(paramIntent, this.app, this);
      paramIntent = new Bundle();
      paramIntent.putString("uin", String.valueOf(AppConstants.aj));
      paramIntent.putInt("uintype", -1);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.f.intValue(), paramIntent);
    }
    int i1;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(a());
      i1 = paramIntent.getIntExtra(AlbumConstants.i, -1);
      if (55 != i1) {
        break label264;
      }
      if (!paramIntent.getExtras().containsKey("PhotoConst.PHOTO_PATHS")) {
        break;
      }
      ArrayList localArrayList = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      if (localArrayList.size() <= 0) {
        break;
      }
      a(localArrayList);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
    return;
    if (paramIntent.getExtras().containsKey("file_send_path"))
    {
      c(paramIntent.getExtras().getString("file_send_path"));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
      }
    }
    for (;;)
    {
      if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
      {
        getIntent().removeExtra("PhotoConst.SEND_FLAG");
        a(paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS"));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
      }
      if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
        getIntent().putExtra("isMigSdkShare", true);
      }
      g(paramIntent);
      f(paramIntent);
      return;
      label264:
      if (56 == i1)
      {
        c(paramIntent.getExtras().getString("file_send_path"));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
        }
      }
    }
  }
  
  void f()
  {
    int i2 = 8;
    int i3 = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.q = ChatTextSizeSettingActivity.a(this);
    int i1 = i2;
    switch (i3)
    {
    default: 
      i1 = i2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(i1);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.q);
      return;
      i1 = 6;
      continue;
      i1 = 6;
    }
  }
  
  void f(Intent paramIntent)
  {
    if (paramIntent.hasExtra("JumpAction.Text"))
    {
      paramIntent = paramIntent.getStringExtra("JumpAction.Text");
      if ((paramIntent != null) && (paramIntent.length() > 0))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramIntent);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramIntent.length());
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 0);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    e();
    ((DataLineHandler)this.app.a(8)).jdField_a_of_type_Boolean = false;
    j();
    if ((this.jdField_c_of_type_Boolean) && (AIOUtils.l) && (!this.d))
    {
      super.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      this.d = true;
    }
  }
  
  void g()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    Object localObject1 = new File(AppConstants.bj + "photo/");
    if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdirs()))
    {
      QQToast.a(this, 2131368967, 0).a();
      return;
    }
    Object localObject2 = AppConstants.bj + "photo/" + System.currentTimeMillis() + ".jpg";
    localObject1 = Uri.fromFile(new File((String)localObject2));
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", (String)localObject2).commit();
    localObject2 = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject2).putExtra("output", (Parcelable)localObject1);
    ((Intent)localObject2).putExtra("android.intent.extra.videoQuality", 100);
    startActivityForResult((Intent)localObject2, 5);
  }
  
  void g(Intent paramIntent)
  {
    int i2 = paramIntent.getIntExtra("dataline_forward_type", -1);
    int i1 = 0;
    if (i2 == -1) {
      return;
    }
    paramIntent.getIntExtra("dataline_forward_type", -1);
    long l1 = paramIntent.getLongExtra("req_share_id", 0L);
    if (paramIntent.getBooleanExtra("sendMultiple", false)) {
      if (i2 != 100) {
        break label1387;
      }
    }
    label249:
    label354:
    label1379:
    label1382:
    label1387:
    for (int i3 = 0;; i3 = 1)
    {
      Object localObject1 = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
      Object localObject6;
      Object localObject5;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject6 = paramIntent.getExtras();
        localObject5 = null;
        localObject1 = localObject5;
        if (localObject6 != null)
        {
          localObject6 = ((Bundle)localObject6).getParcelableArrayList("fileinfo_array");
          localObject1 = localObject5;
          if (localObject6 == null) {}
        }
        try
        {
          localObject1 = (ArrayList)localObject6;
          if (localObject1 == null)
          {
            m();
            return;
          }
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            localObject2 = null;
          }
          localObject5 = new ArrayList();
          localObject6 = (DataLineHandler)this.app.a(8);
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = a((ForwardFileInfo)((Iterator)localObject2).next(), false, this.p);
            if (localDataLineMsgRecord != null) {
              if (DataLineMsgSet.isSingle(localDataLineMsgRecord))
              {
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(localDataLineMsgRecord);
                ((DataLineHandler)localObject6).a(localArrayList, false);
                i1 = 1;
              }
            }
            for (;;)
            {
              break;
              ((ArrayList)localObject5).add(localDataLineMsgRecord);
            }
          }
          if (((ArrayList)localObject5).size() <= 0) {
            break label354;
          }
        }
        ((DataLineHandler)localObject6).a((ArrayList)localObject5, false);
        if (!this.jdField_b_of_type_Boolean) {
          this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        boolean bool = paramIntent.getExtras().getBoolean("refuse_show_share_result_dialog", false);
        if ((!this.jdField_b_of_type_Boolean) || (bool)) {
          break;
        }
        paramIntent = paramIntent.getExtras();
        localObject2 = paramIntent.getString("app_name");
        if (l1 != 0L) {
          break label1379;
        }
        paramIntent = StructMsgFactory.a(paramIntent);
        if ((paramIntent == null) || (!(paramIntent instanceof AbsShareMsg))) {
          break label1382;
        }
      }
      for (paramIntent = (AbsShareMsg)paramIntent;; paramIntent = null)
      {
        if (paramIntent != null) {
          l1 = paramIntent.mSourceAppid;
        }
        for (;;)
        {
          a(l1, (String)localObject2);
          return;
          if (i1 != 0) {
            break label249;
          }
          m();
          break label249;
          localObject5 = ((ArrayList)localObject2).iterator();
          for (i1 = 0; ((Iterator)localObject5).hasNext(); i1 = i2)
          {
            localObject6 = (String)((Iterator)localObject5).next();
            if (localObject6 != null)
            {
              i2 = i1;
              if (!((String)localObject6).equals("/")) {}
            }
            else
            {
              i2 = i1;
              if (i1 == 0)
              {
                i2 = 1;
                m();
              }
              ((Iterator)localObject5).remove();
            }
          }
          if (!((ArrayList)localObject2).isEmpty())
          {
            a((ArrayList)localObject2, i3);
            break label249;
          }
          if (i1 != 0) {
            break label249;
          }
          m();
          break label249;
          localObject5 = new ArrayList();
          if (a(paramIntent, i2)) {
            break;
          }
          Object localObject3;
          Object localObject4;
          switch (i2)
          {
          default: 
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_other");
            break;
          case 101: 
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_image");
            localObject2 = paramIntent.getStringExtra("dataline_forward_path");
            if (localObject2 == null)
            {
              QLog.e(jdField_a_of_type_JavaLangString, 1, "handleForwardRequest forward image, extras: " + paramIntent.getExtras().toString());
              break label249;
            }
            localObject6 = ((String)localObject2).split(";");
            ((ArrayList)localObject5).clear();
            i1 = 0;
            if (i1 < localObject6.length) {
              try
              {
                localObject2 = URLDecoder.decode(localObject6[i1], "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                  if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
                  {
                    a((String)localObject2);
                    ReportController.b(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                    if (QLog.isColorLevel()) {
                      QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                    }
                    i1 += 1;
                  }
                }
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[i1]);
                return;
              }
              catch (IllegalArgumentException localIllegalArgumentException1)
              {
                for (;;)
                {
                  localObject3 = localObject6[i1];
                  continue;
                  ((ArrayList)localObject5).add(localObject3);
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "gotoQfavShareMsg|file path invalid. path=" + (String)localObject3);
                  }
                }
              }
            }
            if (((ArrayList)localObject5).isEmpty()) {
              break label249;
            }
            a((ArrayList)localObject5, 1);
            if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
              break label249;
            }
            if (((ArrayList)localObject5).size() > 1)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
              if (!QLog.isColorLevel()) {
                break label249;
              }
              QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
              break label249;
            }
            if (((ArrayList)localObject5).size() != 1) {
              break label249;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break label249;
            }
            QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
            break;
          case 100: 
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_file");
            localObject3 = paramIntent.getStringExtra("dataline_forward_path");
            if ((localObject3 == null) || (((String)localObject3).equals("")))
            {
              m();
              return;
            }
            localObject6 = ((String)localObject3).split(";");
            ((ArrayList)localObject5).clear();
            i1 = 0;
            if (i1 < localObject6.length) {
              try
              {
                localObject3 = URLDecoder.decode(localObject6[i1], "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
                  {
                    a((String)localObject3);
                    i1 += 1;
                  }
                }
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[i1]);
                return;
              }
              catch (IllegalArgumentException localIllegalArgumentException2)
              {
                for (;;)
                {
                  localObject4 = localObject6[i1];
                  continue;
                  ((ArrayList)localObject5).add(localObject4);
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "shareFromMigSdk|file path invalid. path=" + (String)localObject4);
                  }
                }
              }
            }
            if (((ArrayList)localObject5).isEmpty()) {
              break label249;
            }
            a((ArrayList)localObject5, 0);
            if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
              break label249;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break label249;
            }
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
            break;
          case 102: 
            localObject4 = paramIntent.getStringExtra("dataline_forward_text");
            if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
              break label249;
            }
            if (Patterns.c.matcher((CharSequence)localObject4).find()) {
              StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_link");
            }
            for (;;)
            {
              a((String)localObject4);
              break;
              StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_text");
            }
          }
        }
      }
    }
  }
  
  void h()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((localObject == null) || (((String)localObject).startsWith(getString(2131367566)))) {
        break label39;
      }
    }
    label39:
    do
    {
      return;
      localObject = this.app.a();
    } while (localObject == null);
    int i1 = ((QQMessageFacade)localObject).e();
    if (i1 > 0)
    {
      if (i1 > 99)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131367566) + "(99+)");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131367566) + "(" + i1 + ")");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131367566));
  }
  
  protected void h(Intent paramIntent)
  {
    c(paramIntent);
    int i1 = this.p;
    b(paramIntent);
    if (i1 != this.p)
    {
      paramIntent = this.app.a(this.p);
      if (paramIntent != null) {
        break label85;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
      label85:
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramIntent.a(true);
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b(paramMessage.arg1, paramMessage.arg2);
      continue;
      s();
    }
  }
  
  void i()
  {
    ImageView localImageView = this.rightViewImg;
    localImageView.setContentDescription(getResources().getText(2131362135));
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130843170);
    localImageView.setOnClickListener(new u(this));
    if (ChatActivityConstants.I) {
      this.rightViewImg.setContentDescription("进入我的电脑高级设置界面");
    }
    i(getIntent());
  }
  
  void i(Intent paramIntent)
  {
    setLeftViewName(paramIntent);
    String str = this.leftView.getText().toString();
    if (str.contains(getString(2131367566)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_op4recent");
      h();
    }
    for (;;)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("isBack2Root");
        paramIntent.getExtras().putBoolean("isBack2Root", false);
      }
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("LASTFROM");
        if (str != null)
        {
          this.leftView.setText(str);
          this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
        }
      }
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
      {
        this.jdField_a_of_type_Boolean = true;
        this.leftView.setText(getString(2131367566));
        this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
        h();
      }
      if ((paramIntent != null) && (paramIntent.getIntExtra("dataline_forward_type", -1) != -1))
      {
        if (!this.jdField_b_of_type_Boolean) {
          this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.leftView.setText(getString(2131367566));
          this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
          h();
        }
      }
      if (ChatActivityConstants.I)
      {
        str = this.leftView.getText().toString();
        paramIntent = str;
        if (!getString(2131366637).equals(str)) {
          paramIntent = "返回" + str + "界面";
        }
        this.leftView.setContentDescription(paramIntent);
      }
      return;
      if (str.contains(getString(2131367540))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_op4buddylist");
      } else if (str.contains(getString(2131362716))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_op4dongtai");
      }
    }
  }
  
  void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.app.a().a(this.p).b(localLong.longValue());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgFailedWhenQuesting: session = " + localLong.longValue());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  void k()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838420);
    localQQToast.c(2000);
    localQQToast.b(2131362150);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void l()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838420);
    localQQToast.c(2000);
    localQQToast.b(2131362151);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void m()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838420);
    localQQToast.c(2000);
    localQQToast.b(2131362182);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void n()
  {
    Object localObject = new ArrayList();
    au localau = new au(this, (List)localObject);
    av localav = new av(this);
    Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int i4 = 0;
    int i3 = 0;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      int i1 = 0;
      int i2 = i3;
      int i5 = i4;
      i4 = i5;
      i3 = i2;
      if (localIterator2.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
        if ((!DataLineMsgSet.isFileType(localDataLineMsgRecord)) || (localDataLineMsgRecord.isread) || (localDataLineMsgRecord.fileMsgStatus != 1L)) {
          break label266;
        }
        i3 = i2;
        i4 = i1;
        if (i1 == 0)
        {
          i3 = i2 + 1;
          i4 = 1;
        }
        ((List)localObject).add(localDataLineMsgRecord);
        i5 += 1;
        i1 = i4;
        i2 = i3;
      }
    }
    label266:
    for (;;)
    {
      break;
      if (i3 >= 3)
      {
        localObject = String.format(getString(2131362218), new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        ((DataLineHandler)this.app.a(8)).a(115);
        DialogUtil.a(this, 230, getString(2131362133), (String)localObject, 2131367262, 2131362219, localau, localav).show();
      }
      return;
    }
  }
  
  public void o()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public boolean onBackEvent()
  {
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if (this.jdField_b_of_type_Boolean)
    {
      if (bool)
      {
        l1 = getIntent().getLongExtra("req_share_id", 0L);
        if (l1 > 0L) {
          ForwardSdkShareOption.a(this, true, "sendToMyComputer", l1);
        }
        return super.onBackEvent();
      }
      long l1 = getIntent().getLongExtra("res_share_id", 0L);
      if (l1 > 0L) {
        ForwardSdkShareOption.a(this, true, "shareToQQ", AppShareIDUtil.b(l1));
      }
      return super.onBackEvent();
    }
    if ((this.jdField_a_of_type_Boolean) || (bool))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.l = true;
    int i1 = paramView.getId();
    ReportController.b(this.app, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
    switch (i1)
    {
    default: 
    case 2131297875: 
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      } while ((paramView == null) || (paramView.length() <= 0));
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_cktxt");
      a(new QQText(paramView, 13, 32, 6000).toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      return;
    }
    Intent localIntent = (Intent)paramView.getTag();
    if (localIntent.getExtras().getInt("uintype") == 0)
    {
      String str = localIntent.getExtras().getString("uin");
      if (!ChatActivityUtils.a(this.app, str))
      {
        localIntent.removeExtra("uintype");
        localIntent.putExtra("uintype", 1003);
      }
    }
    localIntent.putExtra("message_box_click", true);
    MediaPlayerManager.a(this.app).a(false);
    startActivity(localIntent);
    paramView.setVisibility(8);
    finish();
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
  }
  
  protected void q()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (i1 == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(i1);
  }
  
  public void r()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(15, 0, 0).sendToTarget();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramObservable, paramObject);
      return;
    }
    new Handler(localLooper).post(new az(this, paramObservable, paramObject));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\LiteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */