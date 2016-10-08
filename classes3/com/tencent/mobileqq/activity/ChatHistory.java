package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgFactory;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.ImageCache;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kup;
import kur;
import kus;
import kut;
import kuu;
import kuv;
import kuw;
import kux;
import kuz;
import kvb;
import kvc;
import kvd;
import kve;
import kvf;
import kvg;
import kvj;
import kvk;
import kvl;
import kvm;
import kvn;
import kvp;
import kvq;
import kvr;
import kvs;
import kvt;
import kvu;
import kvv;
import kwh;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ChatHistory
  extends IphoneTitleBarActivity
  implements SensorEventListener
{
  private static final int B = 604800;
  private static Toast jdField_a_of_type_AndroidWidgetToast;
  public static final String b = "from_RecentSaidActivity";
  public static final String c = "target_shmsgseq";
  static final int jdField_d_of_type_Int = 8;
  static final String jdField_g_of_type_JavaLangString = "http://m.qzone.com";
  static final String jdField_h_of_type_JavaLangString = "http://mobile.qzone.qq.com";
  static final int k = 0;
  static final int l = 1;
  static final int m = 2;
  static final int n = 3;
  static final int o = 4;
  static final int p = 5;
  public static final int q = 6;
  static final int r = 7;
  static final int s = 8;
  static final int t = 9;
  static final int u = 10;
  static final int v = 11;
  static final int w = 12;
  static final int x = 13;
  public static final int y = 200;
  static final int z = 1;
  public int A;
  private int C;
  private int D;
  float jdField_a_of_type_Float;
  public int a;
  public long a;
  public Dialog a;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public View a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  public ImageView a;
  public TextView a;
  public ChatHistory.ChatHistoryAdapter a;
  public ChatHistory.PlayingPttHistoryInfo a;
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public MessageSearchDialog a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ImageWorker jdField_a_of_type_ComTencentMobileqqUtilImageWorker;
  public QQProgressDialog a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Object jdField_a_of_type_JavaLangObject;
  final String jdField_a_of_type_JavaLangString;
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  kwh jdField_a_of_type_Kwh;
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  public int b;
  private long jdField_b_of_type_Long;
  public Dialog b;
  AnimationDrawable jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable;
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  public Dialog c;
  private AnimationDrawable jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable;
  View jdField_c_of_type_AndroidViewView;
  public TextView c;
  private boolean jdField_c_of_type_Boolean;
  public String d;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  public String e;
  int f;
  public String f;
  int jdField_g_of_type_Int;
  int jdField_h_of_type_Int;
  int i;
  final int j;
  
  public ChatHistory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "ChatHistory";
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.jdField_c_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.j = 60;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_a_of_type_Long = 0L;
    this.D = 999;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidOsHandler$Callback = new kup(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new kvd(this);
    this.jdField_a_of_type_Kwh = new kwh(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new kvj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new kvk(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = new kvl(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new kvm(this);
  }
  
  private MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != 64533) && (paramInt2 != 64504) && (paramInt2 != 64505) && (paramInt2 != 201)) || ((paramInt1 == 1001) || (ActionMsgUtil.a(paramInt2)) || (paramInt2 == 62535) || (paramInt2 == 35534) || (paramInt2 == 35533))) {
      return ActionMsgUtil.a(paramString);
    }
    if (paramInt2 == 63527)
    {
      localMsgBody = new MsgBody();
      boolean bool = MsgUtils.b(paramInt3);
      localMsgBody.msg = MsgUtils.a(TransfileUtile.a(paramString), this, bool, false);
      localMsgBody.action = null;
      return localMsgBody;
    }
    if (paramInt2 == 63520)
    {
      localMsgBody = new MsgBody();
      localMsgBody.msg = MsgUtils.a(this.app, TransfileUtile.a(paramString), this, this.jdField_d_of_type_JavaLangString, null, this.jdField_a_of_type_Int);
      localMsgBody.action = null;
      return localMsgBody;
    }
    MsgBody localMsgBody = new MsgBody();
    localMsgBody.msg = paramString;
    localMsgBody.action = null;
    return localMsgBody;
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.a().createMessageRecordEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof XListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  private String a()
  {
    return this.app.a();
  }
  
  private String a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
    localSimpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
    return localSimpleDateFormat.format(Long.valueOf(paramLong));
  }
  
  private String a(BitAppMsg paramBitAppMsg)
  {
    if (paramBitAppMsg == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(paramBitAppMsg.mMsgBrief)) {
      localStringBuffer.append(paramBitAppMsg.mMsgBrief);
    }
    return localStringBuffer.toString();
  }
  
  private String a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!AbsShareMsg.class.isInstance(paramAbsStructMsg))) {
      return null;
    }
    paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramAbsStructMsg.mMsgServiceID == 80)
    {
      localStringBuffer.append("[");
      localStringBuffer.append(paramAbsStructMsg.mSourceName);
      localStringBuffer.append("]");
      localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
      return localStringBuffer.toString();
    }
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgBrief)) {
      localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (!TextUtils.isEmpty(paramAbsStructMsg.mSourceName))
      {
        localStringBuffer.append(paramAbsStructMsg.mSourceName);
        localStringBuffer.append(" " + getString(2131370594) + " ");
        if (!TextUtils.isEmpty(paramAbsStructMsg.mContentTitle)) {
          localStringBuffer.append(paramAbsStructMsg.mContentTitle);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.setBounds(0, 0, this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumWidth(), this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumHeight());
      paramImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable);
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
    }
  }
  
  private void a(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.a()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.a("fromAIO", true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        PicEmoticonInfo.b((URLDrawable)localDrawable);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297634));
    b();
    l();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter = new ChatHistory.ChatHistoryAdapter(this, this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollFooter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(paramString, paramInt, this.jdField_e_of_type_Int);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.trim().equals("")) || (paramString.contains("\n"))) {
      bool = false;
    }
    while (!Pattern.compile("^[*+,./\\\"=_-]+").matcher(paramString.substring(0, 1)).matches()) {
      return bool;
    }
    return false;
  }
  
  private String b()
  {
    String str = ContactUtils.i(this.app, this.app.a());
    if ((str != null) && (!str.trim().equals(""))) {
      return str;
    }
    return this.app.a();
  }
  
  private void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130841713));
    }
  }
  
  private void b(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.a()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.a("fromAIO", true);
      if ((paramPicEmoticonInfo instanceof URLDrawable)) {
        PicEmoticonInfo.a((URLDrawable)paramPicEmoticonInfo);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    Object localObject2 = "";
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1;
    Cursor localCursor;
    label149:
    int i2;
    label221:
    int i1;
    String str;
    if ((paramInt == 1) || (paramInt == 3000))
    {
      localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), this.app.b());
      if (localObject1 == null) {
        break label1209;
      }
      localCursor = this.app.b().a(((StringBuilder)localObject1).toString(), null);
      if (paramInt == 1)
      {
        paramString = ContactUtils.a(this.app, paramString, 1);
        localStringBuffer.append(getString(2131368682) + ":");
        localStringBuffer.append(paramString);
        localStringBuffer.append("\r\n===========================================\r\n");
      }
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        localObject1 = localObject2;
        i2 = localCursor.getInt(localCursor.getColumnIndex("time"));
        paramString = localCursor.getString(localCursor.getColumnIndex("senderuin"));
        if (1 != paramInt) {
          break label585;
        }
        paramString = String.format("%s(%s)", new Object[] { ContactUtils.f(this.app, this.jdField_d_of_type_JavaLangString, paramString), paramString });
        i1 = localCursor.getInt(localCursor.getColumnIndex("issend"));
        if (!MsgUtils.a(i1)) {
          break label630;
        }
        str = b();
        label254:
        if ((localCursor.getColumnIndex("versionCode") >= 0) && (localCursor.getInt(localCursor.getColumnIndex("versionCode")) > 0)) {
          break label636;
        }
        paramString = localCursor.getString(localCursor.getColumnIndex("msg"));
      }
    }
    label305:
    label379:
    label402:
    label529:
    label585:
    label630:
    label636:
    int i3;
    for (;;)
    {
      localObject1 = null;
      if (paramString != null) {
        localObject1 = new QQText(paramString, 3).a();
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0)
        {
          localObject2 = localObject1;
          if (b((String)localObject1))
          {
            localObject2 = localObject1.split("\026")[1].split("\\|");
            if (localObject2.length >= 2) {
              break label1148;
            }
            i1 = 1;
            if ((i1 != 1) && (i1 != 65538)) {
              break label1163;
            }
            localObject2 = getString(2131368433);
          }
        }
      }
      localObject1 = a(i2 * 1000L) + "  " + str + "\r\n" + (String)localObject2;
      localStringBuffer.append((String)localObject1 + "\r\n\r\n");
      do
      {
        localObject1 = paramString;
        if (localCursor.moveToNext()) {
          break label149;
        }
        if (localCursor != null) {
          localCursor.close();
        }
        runOnUiThread(new kvf(this, FileUtils.a(AppConstants.bk, this.jdField_a_of_type_JavaLangStringBuffer.toString(), localStringBuffer.toString())));
        return;
        localObject1 = "( isValid=1 and msgtype " + MsgProxyUtils.b() + " ) ORDER BY time asc , longMsgIndex asc";
        localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), this.app.b(), (String)localObject1, null);
        break;
        if (3000 == paramInt)
        {
          paramString = String.format("%s(%s)", new Object[] { ContactUtils.a(this.app, paramString, 0), paramString });
          break label221;
        }
        paramString = this.jdField_e_of_type_JavaLangString;
        break label221;
        str = paramString;
        break label254;
        i3 = localCursor.getInt(localCursor.getColumnIndex("msgtype"));
        if (i3 == 63529)
        {
          paramString = getString(2131370467);
          break label305;
        }
        if (i3 == 63497)
        {
          paramString = localCursor.getBlob(localCursor.getColumnIndex("msgData"));
          localObject1 = new MessageForApollo();
          ((MessageForApollo)localObject1).msgData = paramString;
          ((MessageForApollo)localObject1).parse();
          paramString = ApolloUtil.a((MessageForApollo)localObject1);
          break label305;
        }
        if (i3 == 63525)
        {
          paramString = a(StructMsgFactory.a(localCursor.getBlob(localCursor.getColumnIndex("msgData"))));
          break label305;
        }
        if (i3 == 60527)
        {
          paramString = a(BitAppMsgFactory.a(localCursor.getBlob(localCursor.getColumnIndex("msgData"))));
          break label305;
        }
        if (i3 == 63516)
        {
          if (MsgUtils.a(i1))
          {
            paramString = this.app.a().getString(2131367606, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
            break label305;
          }
          paramString = this.app.a().getString(2131367605);
          break label305;
        }
        paramString = (String)localObject1;
      } while (i3 == 63530);
      if (i3 == 63536)
      {
        paramString = "[图片]";
      }
      else if (i3 == 63534)
      {
        paramString = "[语音]";
      }
      else
      {
        if (i3 != 63514) {
          break label916;
        }
        paramString = "[视频]";
      }
    }
    label916:
    if (i3 == 64501) {
      paramString = new StringBuilder();
    }
    for (;;)
    {
      try
      {
        localObject2 = localCursor.getBlob(localCursor.getColumnIndex("msgData"));
        localObject1 = new MixedMsg.Msg();
        try
        {
          ((MixedMsg.Msg)localObject1).mergeFrom((byte[])localObject2);
          if (((MixedMsg.Msg)localObject1).elems.get().size() <= 0) {
            break label529;
          }
          i3 = ((MixedMsg.Msg)localObject1).elems.get().size();
          i1 = 0;
          if (i1 < i3)
          {
            localObject2 = (MixedMsg.Elem)((MixedMsg.Msg)localObject1).elems.get().get(i1);
            if (!((MixedMsg.Elem)localObject2).textMsg.has()) {
              break label1085;
            }
            paramString.append(((MixedMsg.Elem)localObject2).textMsg.get());
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          continue;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatHistory", 2, "Parse mix message error");
        }
        paramString = paramString.toString();
      }
      label1085:
      if (localInvalidProtocolBufferMicroException.picMsg.has())
      {
        paramString.append("[图片]");
        break label1215;
        try
        {
          paramString = new String(localCursor.getBlob(localCursor.getColumnIndex("msgData")), "UTF-8");
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramString = localException;
        }
        break label305;
        label1148:
        i1 = Integer.valueOf(localInvalidProtocolBufferMicroException[2]).intValue();
        break label379;
        label1163:
        Object localObject3 = localException;
        if (i1 != 2) {
          break label402;
        }
        localObject3 = "[" + getString(2131368092) + "]";
        break label402;
        label1209:
        localCursor = null;
        break;
      }
      label1215:
      i1 += 1;
    }
  }
  
  private void c(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private boolean c(String paramString)
  {
    r();
    MediaPlayerManager.a(this.app).a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "playSource|bRet = " + bool);
    }
    if ((bool) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
    return bool;
  }
  
  private void l()
  {
    this.jdField_b_of_type_AndroidViewView = View.inflate(getActivity(), 2130903163, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new kvp(this));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297431));
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131297430);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297639));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297643));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131371293));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131371294));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new kvv(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new kur(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842877);
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838647);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297642));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297640));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new kus(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297644));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new kut(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131297645));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new kuu(this));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_Int == 1010) || (this.jdField_a_of_type_Int == 1023) || (this.jdField_a_of_type_Int == 1024)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new kuv(this));
      return;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
        if ((localFriendsManager == null) || (!localFriendsManager.b(String.valueOf(this.jdField_d_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatHistory", 2, "--mSyncHistory button: fm is null or the uin is not my friend: fm:" + localFriendsManager);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
  }
  
  private void n()
  {
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_e_of_type_Int = ((this.jdField_c_of_type_Int - 1) * 8);
  }
  
  private void o()
  {
    if (!NetworkUtil.e(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131368679, 1).a();
      return;
    }
    c(getApplication().getResources().getString(2131368680));
    this.app.a().c(this.jdField_d_of_type_JavaLangString);
  }
  
  private void p()
  {
    String str = getResources().getString(2131367904);
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_d_of_type_JavaLangString.equals(String.valueOf(AppConstants.aq)))
      {
        this.jdField_e_of_type_JavaLangString = getResources().getString(2131369140);
        if (!this.jdField_d_of_type_JavaLangString.equals(String.valueOf(AppConstants.aq))) {
          break label346;
        }
        str = getResources().getString(2131369140);
      }
    }
    label346:
    for (;;)
    {
      if ((this.jdField_e_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString.trim().equals(""))) {
        this.jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      }
      setTitle(str);
      this.f = b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      this.leftView = ((TextView)findViewById(2131297083));
      return;
      this.jdField_e_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_e_of_type_JavaLangString = ((TroopManager)this.app.getManager(51)).a(this.jdField_d_of_type_JavaLangString);
      }
      else if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 1004))
      {
        this.jdField_e_of_type_JavaLangString = ContactUtils.j(this.app, this.jdField_d_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 3000)
      {
        this.jdField_e_of_type_JavaLangString = ContactUtils.d(this.app, this.jdField_d_of_type_JavaLangString);
      }
      else if (this.jdField_a_of_type_Int == 1024)
      {
        PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.app.getManager(55)).b(this.jdField_d_of_type_JavaLangString);
        if (localPublicAccountInfo != null) {
          this.jdField_e_of_type_JavaLangString = localPublicAccountInfo.name;
        }
      }
    }
  }
  
  private void q()
  {
    if (jdField_a_of_type_AndroidWidgetToast != null)
    {
      jdField_a_of_type_AndroidWidgetToast.cancel();
      jdField_a_of_type_AndroidWidgetToast = null;
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    setVolumeControlStream(3);
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.app.getApplication().getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    if (this.jdField_a_of_type_AndroidHardwareSensor != null)
    {
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidHardwareSensor.getMaximumRange();
      if (this.jdField_b_of_type_Float <= 10.0F) {
        break label72;
      }
    }
    label72:
    for (float f1 = 10.0F;; f1 = this.jdField_b_of_type_Float)
    {
      this.jdField_b_of_type_Float = f1;
      return;
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "AIO_chatlog arg:" + this.D);
      }
      ReportController.b(this.app, "CliOper", "", "", "AIO", "AIO_chatlog", this.D, 0, String.valueOf(this.D), "", "", "");
      return;
      this.D = 0;
      continue;
      this.D = 3;
      continue;
      this.D = 2;
    }
  }
  
  public int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.app == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = this.app.b();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Int == 0)
    {
      localStringBuilder = new StringBuilder(" msgtype ");
      localStringBuilder.append(MsgProxyUtils.b());
      localStringBuilder.append(" and isValid=1 ");
    }
    for (paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", localStringBuilder.toString(), ""); paramString == null; paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString()))
    {
      return 0;
      localStringBuilder = new StringBuilder(" where msgtype ");
      localStringBuilder.append(MsgProxyUtils.b());
      localStringBuilder.append(" and isValid=1 ");
    }
    paramString = localSQLiteDatabase.a(paramString.toString(), null);
    if (paramString == null) {
      return 0;
    }
    long l1;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (this.jdField_a_of_type_Int != 3000) {
        break label245;
      }
      l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label245:
      if (this.jdField_a_of_type_Int == 0) {
        l1 = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (this.jdField_a_of_type_Int == 1) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
    }
  }
  
  public Cursor a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.b();
    if (localSQLiteDatabase == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistory", 2, "MessageProvide getDB null!");
      }
    }
    do
    {
      return null;
      if (paramString1.indexOf("mr_troop_") == -1) {
        break;
      }
      paramString3 = " where " + paramString3;
      paramString2 = MessageDBUtils.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
    } while (paramString2 == null);
    paramString2.append(" t left join TroopMemberInfo m on t.senderuin=m.memberuin and t.frienduin=m.troopuin");
    for (;;)
    {
      try
      {
        paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
        paramString1 = paramString2;
      }
      catch (SQLException paramString2)
      {
        paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
        continue;
      }
      return paramString1;
      if (paramString1.indexOf("mr_grp_") != -1)
      {
        paramString2 = new StringBuilder("select * from ");
        paramString2.append(paramString1);
        paramString2.append(" t left join GrpMemberInfo m on t.senderuin=m.mId and t.frienduin=m.grpID left join friends l on m.mId =l.uin ");
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          paramString2.append(" where ");
          paramString2.append(paramString3);
        }
        try
        {
          paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
          paramString1 = paramString2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("gene", 2, "cursor: " + paramString2);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          for (;;)
          {
            paramString2 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
          }
        }
      }
      else
      {
        if (paramString1.indexOf("mr_discusssion_") != -1)
        {
          paramString3 = " where " + paramString3;
          paramString2 = MessageDBUtils.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
          if (paramString2 == null) {
            break;
          }
          paramString2.append(" t left join DiscussionMemberInfo m on t.senderuin=m.memberUin and t.frienduin=m.discussionUin");
          try
          {
            paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
          }
          continue;
        }
        paramString2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
        if (paramString2 != null) {
          try
          {
            paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
          }
        } else {
          paramString1 = null;
        }
      }
    }
  }
  
  public void a()
  {
    View localView1 = findViewById(2131297633);
    View localView2 = findViewById(2131296895);
    int i1 = localView1.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog = new MessageSearchDialog(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new kvq(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new kvr(this, localView2, i1));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.setOnDismissListener(new kvs(this, localView2, i1, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.jdField_a_of_type_Int == 0) && (((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131298018)).isChecked()))
    {
      o();
      this.app.a().a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.b().post(new kvu(this, paramBoolean, paramInt));
  }
  
  public void a(Message paramMessage)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, 0L);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      if (paramMessageRecord == null) {
        break label110;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(getResources().getString(2131364614));
      localActionSheet.a(2131368306, 3);
      localActionSheet.d(2131367262);
      localActionSheet.a(new kvn(this, paramMessageRecord, localActionSheet));
      localActionSheet.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2130903296, null);
    if (1 == this.jdField_a_of_type_Int)
    {
      ((TextView)localView.findViewById(2131297586)).setText(2131367978);
      localView.findViewById(2131298018).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131367928)).setPositiveButton(getString(2131368306), new kux(this, paramString)).setNegativeButton(getString(2131367976), new kuw(this)).addView(localView);
      if (!isFinishing()) {
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      return;
      if (3000 == this.jdField_a_of_type_Int)
      {
        ((TextView)localView.findViewById(2131297586)).setText(2131367979);
        localView.findViewById(2131298018).setVisibility(8);
      }
      else if ((1001 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int))
      {
        localView.findViewById(2131298018).setVisibility(8);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.jdField_b_of_type_Int * 8)) {
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    int i1 = (paramInt - 1) / 8;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_Int = ((paramInt - 1) % 8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(i1 + 1));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    return true;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView = ((RelativeLayout)View.inflate(this, 2130904932, null));
    int i1 = (int)DisplayUtils.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, i1, 0, i1);
    ((RelativeLayout)localObject).setBackgroundResource(2130843260);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131493022));
    ((RelativeLayout)localObject).addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.a((View)localObject);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131300876).setVisibility(8);
    localObject = (EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131300895);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(new kvt(this));
    setLayerType(this.jdField_c_of_type_AndroidViewView);
  }
  
  public void b(int paramInt)
  {
    this.C = paramInt;
    if (this.C < 8)
    {
      this.jdField_b_of_type_Int = 1;
      return;
    }
    if (this.C % 8 == 0) {}
    for (paramInt = this.C / 8;; paramInt = this.C / 8 + 1)
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (jdField_a_of_type_AndroidWidgetToast == null) {
      jdField_a_of_type_AndroidWidgetToast = Toast.makeText(this, paramString, 0);
    }
    for (;;)
    {
      jdField_a_of_type_AndroidWidgetToast.show();
      return;
      jdField_a_of_type_AndroidWidgetToast.setText(paramString);
    }
  }
  
  boolean b(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  public void c()
  {
    n();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  public void c(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getResources().getDimensionPixelSize(2131492908));
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_Int > this.jdField_b_of_type_Int)
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_e_of_type_Int = ((this.jdField_c_of_type_Int - 1) * 8);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor().requery();
      return;
    } while (-1 != paramInt2);
    a(paramIntent.getExtras());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130968816));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130968817));
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130968769));
    paramBundle = getIntent().getExtras();
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2130903195);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLinearLayout.setFitsSystemWindows(true);
      localLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    boolean bool = paramBundle.getBoolean("from_RecentSaidActivity", false);
    this.jdField_a_of_type_Boolean = bool;
    if (bool) {
      this.jdField_b_of_type_Long = paramBundle.getLong("target_shmsgseq");
    }
    init(getIntent());
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    a(9, false);
    p();
    a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Int);
    s();
    if (this.app.a() != null) {
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().e();
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a((int)(150.0F * this.jdField_a_of_type_Float), (int)(100.0F * this.jdField_a_of_type_Float));
    t();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a();
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "ChatHistory : close entityManager.");
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
    }
    q();
    j();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onDestroy() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.b();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
    this.app.a(getClass());
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.app.a() != null) {
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().e();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a().a();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onPause() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.b();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new kvg(this), 300L);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4, getResources().getString(2131368109)).sendToTarget();
    this.app.a().a((short)1, (byte)1);
  }
  
  public void f()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
    if (localMessageRoamManager != null)
    {
      long l1 = NetConnInfoCenter.getServerTime();
      this.app.a().a(this.jdField_d_of_type_JavaLangString, l1 - 604800L, 0L, l1, (short)0, 0L, 1, null, localMessageRoamManager.b(), false, 0, false);
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    this.jdField_a_of_type_JavaLangStringBuffer.setLength(0);
    String str;
    if (this.jdField_e_of_type_JavaLangString.compareTo(this.jdField_d_of_type_JavaLangString) == 0)
    {
      str = this.jdField_e_of_type_JavaLangString;
      if (!a(str)) {
        break label197;
      }
      str = str.replaceAll("[\\\\/:*?\"<>|]", "");
      this.jdField_a_of_type_JavaLangStringBuffer.append(str + ".txt");
    }
    for (;;)
    {
      boolean bool = FileUtils.a(AppConstants.bk, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
      this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131367982), getString(2131367982) + AppConstants.bk + this.jdField_a_of_type_JavaLangStringBuffer.toString(), new kuz(this), new kvb(this));
      if (!bool) {
        break label231;
      }
      this.jdField_c_of_type_AndroidAppDialog.show();
      return;
      str = String.format("%s(%s)", new Object[] { this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString });
      break;
      label197:
      this.jdField_a_of_type_JavaLangStringBuffer.append(this.jdField_d_of_type_JavaLangString + ".txt");
    }
    label231:
    b(getString(2131367984));
  }
  
  public void h()
  {
    this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131368111), getString(2131368112), new kvc(this), new kve(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  public void i()
  {
    AudioUtil.b(2131165191, false);
  }
  
  public void j()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void k()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    ReportController.b(this.app, "CliOper", "", "", "0X8005690", "0X8005690", this.D, 0, "", "", "", "");
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected boolean onBackEvent()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      }
      setResult(-1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.show();
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.a(false);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return super.onBackEvent();
  }
  
  protected View onCreateRightView()
  {
    super.onCreateRightView();
    TextView localTextView = this.rightViewText;
    if ((3000 == this.jdField_a_of_type_Int) || (1 == this.jdField_a_of_type_Int)) {
      this.rightViewText.setVisibility(8);
    }
    for (;;)
    {
      localTextView.setText(2131368113);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      return localTextView;
      this.rightViewText.setVisibility(0);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = true;
    if (AIOUtils.b()) {}
    boolean bool1;
    label26:
    label61:
    do
    {
      return;
      if (paramSensorEvent.values[0] >= this.jdField_b_of_type_Float) {
        break;
      }
      bool1 = true;
      if (this.jdField_d_of_type_Boolean == bool1) {
        break label93;
      }
      this.jdField_d_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        paramSensorEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
        if (this.jdField_d_of_type_Boolean) {
          break label95;
        }
        bool1 = bool2;
        paramSensorEvent.a(bool1);
      }
    } while (AppSetting.j);
    if (this.jdField_d_of_type_Boolean) {}
    for (int i1 = 2131368154;; i1 = 2131368155)
    {
      c(i1);
      return;
      bool1 = false;
      break label26;
      label93:
      break;
      label95:
      bool1 = false;
      break label61;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */