package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicHolder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.BitSet;
import java.util.Calendar;
import java.util.List;
import kww;
import kwx;
import kxa;
import kxc;
import kxf;
import kxg;
import kxh;
import kxi;
import kxj;
import kxk;
import kxm;
import kxo;
import kxq;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatHistoryForC2C
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  public static final int A = 26;
  public static final int B = 27;
  public static final int C = 30;
  public static final int D = 31;
  public static final int E = 32;
  public static final int F = 33;
  public static final int G = 200;
  static final int H = 1;
  public static final int I = 65537;
  public static final int J = 65538;
  public static final int K = 65539;
  public static final int L = 65540;
  private static final int M = 28;
  private static final int N = 29;
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "ChatHistoryForC2C";
  public static final int b = 1;
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
  private final int O;
  private int P;
  private int Q;
  long jdField_a_of_type_Long;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public BroadcastReceiver a;
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener;
  IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  private Handler jdField_a_of_type_AndroidOsHandler;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  AutoFitScrollView jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView;
  TimeLineView jdField_a_of_type_ComTencentMobileqqActivityTimeLineView;
  private ChatHistoryAdapterForC2C jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C;
  MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public SessionInfo a;
  private C2CMessageSearchDialog jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog;
  private MessageRoamManager jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  public QQProgressDialog a;
  private TipsBar jdField_a_of_type_ComTencentMobileqqWidgetTipsBar;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private List jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_b_of_type_JavaLangString;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private Calendar jdField_c_of_type_JavaUtilCalendar;
  private boolean jdField_c_of_type_Boolean;
  private View d;
  
  public ChatHistoryForC2C()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.O = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler$Callback = new kww(this);
    this.jdField_a_of_type_AndroidOsHandler = new kxf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new kxa(this);
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new kxc(this);
  }
  
  private void a(Message paramMessage)
  {
    int i1 = 1;
    switch (paramMessage.what)
    {
    default: 
      if (i1 != 0) {
        f();
      }
      break;
    }
    label432:
    int i2;
    do
    {
      return;
      paramMessage = (MessageRoamManager)this.app.getManager(91);
      if (((paramMessage.c()) && (paramMessage.a() == 3)) || ((paramMessage.b()) && (paramMessage.a() == 2)) || ((paramMessage.b()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
      {
        a(2130838454, super.getString(2131368117));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        i1 = 1;
      }
      for (;;)
      {
        o();
        break;
        if (paramMessage.a() == 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.notifyDataSetChanged();
          i1 = 1;
        }
        else if (this.jdField_c_of_type_Boolean)
        {
          paramMessage.f();
          i1 = 1;
        }
        else
        {
          localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(31);
          ((Message)localObject).obj = paramMessage.a();
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
          i1 = 0;
        }
      }
      Object localObject = (List)paramMessage.obj;
      paramMessage = (MessageRoamManager)this.app.getManager(91);
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        if (((paramMessage.c()) && (paramMessage.a() == 3)) || ((paramMessage.b()) && (paramMessage.a() == 2)) || ((paramMessage.b()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
        {
          a(2130838454, super.getString(2131368117));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          break;
        }
        if (paramMessage.a() == 4) {
          break label432;
        }
        if (this.jdField_c_of_type_Boolean)
        {
          paramMessage.f();
          break;
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(31);
        ((Message)localObject).obj = paramMessage.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        i1 = 0;
        break;
      }
      if (paramMessage.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        b(paramMessage.a());
      }
      if (paramMessage.a() == 4) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_c_of_type_Boolean = false;
      o();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C == null) || (localObject == null) || (((List)localObject).size() <= 0)) {
        break label549;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.a((List)localObject, paramMessage.a(), paramMessage.a(), paramMessage.jdField_a_of_type_JavaUtilCalendar, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r(), paramMessage.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    } while (paramMessage.a() == 4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int);
    }
    for (;;)
    {
      label549:
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131368121));
      }
      paramMessage.g();
      break;
      if (i2 >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(i2);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramString1);
      localJSONObject.put("wording", paramString2);
      localJSONObject.put("image_res_id", paramInt);
      localJSONObject.put("btn_text", paramString3);
      localJSONObject.put("jump_text", paramString4);
      localJSONObject.put("jump_url", paramString5);
      super.getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, this.jdField_a_of_type_AndroidContentIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      paramString1 = new Intent();
      paramString1.setFlags(268435456);
      paramString1.setAction("android.intent.action.VIEW");
      paramString1.putExtra("devlock_guide_config", localJSONObject.toString());
      paramString1.putExtra("devlock_open_source", "RoamMsg");
      paramString1.putExtra("open_devlock_verify_passwd", paramBoolean);
      paramString1.putExtra("open_devlock_from_roam", true);
      paramString1.putExtra("devlock_show_auth_dev_list", false);
      paramString1.setData(Uri.parse("mqqdevlock://devlock/open?"));
      startActivity(paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c() != null)
    {
      a(true, true, paramBoolean);
      return;
    }
    long l1 = System.currentTimeMillis();
    n();
    EquipmentLockImpl.a().a(this.app, this.app.a(), new kxk(this, l1, paramBoolean));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.f();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c();
      localObject2 = new StringBuilder().append("mode: ").append(i2).append(", isSetPasswd: ").append(bool).append(", refreshTimeLine: ").append(paramBoolean3).append(", devSetup: ").append(paramBoolean1).append(", allowSet: ").append(paramBoolean2).append(", da2 length: ");
      if (localObject1 != null) {
        break label212;
      }
    }
    label212:
    for (int i1 = 0;; i1 = localObject1.length)
    {
      QLog.d("ChatHistoryForC2C", 2, i1);
      if (i2 != 0) {
        break label286;
      }
      if ((paramBoolean1) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h())) {
        break;
      }
      a(super.getString(2131365142), super.getString(2131365145), 2130840668, super.getString(2131365146), super.getString(2131365149), "", true);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(true);
      VipUtils.a(this.app, "chat_history", "LockSet", "Visit_lockTuiguang", 1, 0, new String[0]);
      return;
    }
    if ((paramBoolean1) && (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(true);
      super.startActivityForResult(new Intent(this, AuthDevForRoamMsgActivity.class), 30);
      overridePendingTransition(2130968585, 2130968583);
      return;
    }
    if (!bool)
    {
      b();
      return;
    }
    b(paramBoolean3);
    return;
    label286:
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c() != null)
      {
        b(paramBoolean3);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryForC2C", 2, "devlock is open but no da2 ticket， refresh da2...");
      }
      localObject1 = (AccountManager)this.app.getManager(0);
      if (localObject1 != null)
      {
        n();
        ((AccountManager)localObject1).refreshDA2(this.app.a(), new kxm(this, paramBoolean3));
        return;
      }
      r();
      return;
    }
    if (paramBoolean2) {
      localObject1 = super.getString(2131365147);
    }
    for (Object localObject2 = super.getString(2131365148);; localObject2 = super.getString(2131365144))
    {
      a(super.getString(2131365142), (String)localObject1, 2130840668, (String)localObject2, "", "", false);
      VipUtils.a(this.app, "chat_history", "LockSet", "Visit_lockReadReopen", 1, 0, new String[0]);
      return;
      localObject1 = super.getString(2131365143);
    }
  }
  
  private void b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 23: 
      b(false);
      return;
    }
    paramMessage = this.app.a().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit();
    paramMessage.putLong("vip_message_roam_last_request_timestamp" + this.app.a(), System.currentTimeMillis());
    paramMessage.commit();
    ((MessageRoamManager)this.app.getManager(91)).a(1, null, false);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(true);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(paramBoolean);
  }
  
  private void c(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 13: 
      o();
      paramMessage = (Bundle)paramMessage.obj;
      String str = paramMessage.getString("showText");
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText(str);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTag(paramMessage);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
      VipUtils.a(this.app, "vip", "0X8004F9B", "0X8004F9B", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  private void d(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = true;
        f();
        paramMessage = (MessageRoamManager)this.app.getManager(91);
      } while (paramMessage.d() != true);
      paramMessage.a(1, null, false);
      return;
      a(null);
      return;
    } while (paramMessage.obj == null);
    a((Calendar)paramMessage.obj);
  }
  
  private void e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject2;
    label202:
    do
    {
      do
      {
        return;
        b(this.jdField_a_of_type_JavaUtilCalendar);
        return;
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return;
        paramMessage = a(paramMessage.arg1);
      } while (paramMessage == null);
      localObject1 = new StringBuilder();
      i1 = paramMessage.get(1);
      i2 = paramMessage.get(2) + 1;
      i3 = paramMessage.get(5);
      localObject2 = ((StringBuilder)localObject1).append(i1).append("-");
      if (i2 > 9)
      {
        paramMessage = Integer.valueOf(i2);
        localObject2 = ((StringBuilder)localObject2).append(paramMessage).append("-");
        if (i3 <= 9) {
          break label202;
        }
      }
      for (paramMessage = Integer.valueOf(i3);; paramMessage = "0" + i3)
      {
        ((StringBuilder)localObject2).append(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
        paramMessage = "0" + i2;
        break;
      }
      localObject2 = a(paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    } while (localObject2 == null);
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i1 = ((Calendar)localObject2).get(1);
    int i2 = ((Calendar)localObject2).get(2) + 1;
    int i3 = ((Calendar)localObject2).get(5);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i1).append("-");
    if (i2 > 9)
    {
      localObject1 = Integer.valueOf(i2);
      label308:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append("-");
      if (i3 <= 9) {
        break label476;
      }
    }
    label476:
    for (Object localObject1 = Integer.valueOf(i3);; localObject1 = "0" + i3)
    {
      localStringBuilder2.append(localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
      if (((localObject1 == null) || (!((Calendar)localObject2).equals(localObject1))) && (!((Calendar)localObject2).equals(this.jdField_a_of_type_JavaUtilCalendar))) {
        break label501;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "getForwardRoamHistoryByDate same day: " + localStringBuilder1.toString());
      }
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131368121));
      return;
      localObject1 = "0" + i2;
      break label308;
    }
    label501:
    localObject1 = this.app;
    if (paramMessage.arg2 > 0) {}
    for (paramMessage = "Slip_timelineleft";; paramMessage = "Slip_timelineright")
    {
      VipUtils.a((AppInterface)localObject1, "chat_history", "ChatHistory", paramMessage, 0, 0, new String[] { "0", "0" });
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(5, (Calendar)localObject2, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatHistoryForC2C", 2, "getForwardRoamHistoryByDate someday=" + localStringBuilder1.toString());
      return;
    }
  }
  
  private void f(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 15: 
      if (paramMessage.arg1 == -1) {
        a(null);
      }
      for (;;)
      {
        r();
        return;
        a(2130838454, super.getString(2131368114));
      }
    case 16: 
      r();
      return;
    case 17: 
      paramMessage = (MessageRoamManager)this.app.getManager(91);
      paramMessage.a(0, null, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.app, paramMessage.b(), paramMessage.c(), false);
      b(paramMessage.a());
      return;
    case 18: 
      paramMessage = (MessageRoamManager)this.app.getManager(91);
      if (paramMessage.a())
      {
        paramMessage.a(1, null, false);
        paramMessage.a();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.app, paramMessage.b(), paramMessage.c(), true);
        b(paramMessage.a());
        return;
        paramMessage.a(0, null, false);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.g()) {
      a(2130838454, super.getString(2131368117));
    }
    o();
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a();
    paramMessage = Calendar.getInstance();
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i1 = paramMessage.get(1);
    int i2 = paramMessage.get(2) + 1;
    int i3 = paramMessage.get(5);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i1).append("-");
    if (i2 > 9)
    {
      paramMessage = Integer.valueOf(i2);
      localStringBuilder2 = localStringBuilder2.append(paramMessage).append("-");
      if (i3 <= 9) {
        break label398;
      }
    }
    label398:
    for (paramMessage = Integer.valueOf(i3);; paramMessage = "0" + i3)
    {
      localStringBuilder2.append(paramMessage);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
      this.jdField_b_of_type_AndroidViewView.invalidate();
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
      return;
      paramMessage = "0" + i2;
      break;
    }
  }
  
  private void g(Message paramMessage)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
    Calendar localCalendar;
    long l1;
    if (paramMessage.obj != null)
    {
      localCalendar = Calendar.getInstance();
      l1 = ((Long)paramMessage.obj).longValue();
      if (paramMessage.arg1 != 1) {
        break label133;
      }
    }
    label133:
    for (int i1 = 1;; i1 = 0)
    {
      localCalendar.setTimeInMillis(Long.valueOf(l1).longValue() * 1000L);
      if (i1 == 0) {
        localMessageRoamManager.c(localCalendar);
      }
      switch (paramMessage.what)
      {
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      }
    }
    localMessageRoamManager.e();
    return;
    if (paramMessage.arg1 == -1) {}
    for (;;)
    {
      localMessageRoamManager.e();
      return;
      paramMessage = localMessageRoamManager.a();
      if (paramMessage != null) {
        a(2130838454, super.getString(2131368115, new Object[] { Integer.valueOf(paramMessage.get(2) + 1), Integer.valueOf(paramMessage.get(5)) }));
      }
    }
    localMessageRoamManager.e();
    return;
    o();
    a();
    return;
    o();
    return;
    j();
    a(2130838442, super.getString(2131368678));
    setResult(-1);
    finish();
    return;
    j();
    ((MessageRoamManager)this.app.getManager(91)).j();
    setResult(-1);
    finish();
  }
  
  private void m()
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(this, 2130904558, null));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131298593));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(this.jdField_c_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  private void n()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {}
    do
    {
      return;
      if (this.jdField_b_of_type_AndroidAppDialog == null)
      {
        this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
        this.jdField_b_of_type_AndroidAppDialog.setContentView(2130904920);
        ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296852)).setText(super.getString(2131368109));
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener == null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new kxq(this);
        }
        this.jdField_b_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      }
    } while (isFinishing());
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void o()
  {
    try
    {
      if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_b_of_type_AndroidAppDialog.dismiss();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "tipsDialog dismiss " + localIllegalArgumentException.getMessage());
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "tipsDialog dismiss " + localException.getMessage());
      }
      return;
    }
    finally
    {
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903163, null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297431));
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131297430);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297432));
    this.jdField_a_of_type_Boolean = true;
    f();
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)super.findViewById(2131297634));
    View localView = LayoutInflater.from(this).inflate(2130903206, null);
    localView.setPadding(0, 0, 0, 30);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    e();
    p();
    m();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollFooter(null);
    }
    this.jdField_c_of_type_AndroidViewView = getLayoutInflater().inflate(2130904528, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131297005));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_c_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131299863));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131298931).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C = new ChatHistoryAdapterForC2C(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
  }
  
  private void r()
  {
    n();
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
    localMessageRoamManager.b(false);
    localMessageRoamManager.k();
  }
  
  private void s()
  {
    String str = super.getString(2131367904);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(AppConstants.aq)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = super.getString(2131369140);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(AppConstants.aq))) {
          break label236;
        }
        str = super.getString(2131369140);
      }
    }
    label236:
    for (;;)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      ((TextView)super.findViewById(2131297139)).setText(str);
      this.leftView = ((TextView)super.findViewById(2131297083));
      super.findViewById(2131297646).setOnClickListener(this);
      super.findViewById(2131297392).setOnClickListener(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryForC2C", 2, "uin type illegal: " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      this.jdField_a_of_type_AndroidWidgetToast = null;
    }
  }
  
  Calendar a(int paramInt)
  {
    Calendar localCalendar = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
    if (paramInt > 0) {
      localCalendar.add(5, paramInt / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a());
    }
    return localCalendar;
  }
  
  Calendar a(int paramInt1, int paramInt2, Object paramObject)
  {
    Calendar localCalendar = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
    int i1;
    int i2;
    StringBuilder localStringBuilder;
    if (paramInt1 > 0)
    {
      i1 = paramInt1 / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (((BitSet)paramObject).get(i1))
      {
        localCalendar.add(5, i1);
        return localCalendar;
      }
      if (paramInt2 <= 0) {
        break label247;
      }
      i1 += 1;
      i2 = i1;
      if (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.jdField_a_of_type_Int)
      {
        if (!((BitSet)paramObject).get(i1)) {
          break label238;
        }
        i2 = i1;
      }
      i1 = i2 * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("orientation=");
        if (paramInt2 <= 0) {
          break label284;
        }
      }
    }
    label238:
    label247:
    label284:
    for (paramObject = "left";; paramObject = "right")
    {
      QLog.d("ChatHistoryForC2C", 2, (String)paramObject + ",idnex=" + i2 + ",old crollX=" + paramInt1 + ",expect crollX=" + i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(i1, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localCalendar.add(5, i2);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      return localCalendar;
      i1 += 1;
      break;
      i1 -= 1;
      for (;;)
      {
        i2 = i1;
        if (i1 < 0) {
          break;
        }
        i2 = i1;
        if (((BitSet)paramObject).get(i1)) {
          break;
        }
        i1 -= 1;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "gotoCheckPasswordUrl ! ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(1);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "get_roam_msg"));
    startActivityForResult(localIntent, 28);
  }
  
  void a(int paramInt)
  {
    QQToast.a(this.app.a(), paramInt, 0).b(super.getResources().getDimensionPixelSize(2131492908));
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this.app.a(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      if (paramMessageRecord == null) {
        break label107;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(super.getString(2131364614));
      localActionSheet.a(2131367892, 3);
      localActionSheet.d(2131367262);
      localActionSheet.a(new kxo(this, paramMessageRecord, localActionSheet));
      localActionSheet.show();
      return;
      label107:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      AbstractGifImage.resumeAll();
    }
    int i1;
    int i2;
    do
    {
      do
      {
        return;
        AbstractGifImage.pauseAll();
      } while ((paramAbsListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C == null));
      paramInt = paramAbsListView.t();
      i1 = paramAbsListView.d_();
      i2 = paramAbsListView.s();
    } while ((paramInt != i1 - 1) || (i1 == 0) || (i2 == 0) || (this.jdField_c_of_type_Boolean));
    QLog.d("ChatHistoryForC2C", 2, "onScrollStateChanged .... querying querying : ");
    paramAbsListView = (MessageRoamManager)this.app.getManager(91);
    Calendar localCalendar1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_JavaUtilCalendar;
    if (localCalendar1 != null)
    {
      Calendar localCalendar2 = paramAbsListView.c();
      if ((localCalendar2 != null) && (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5)))
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      if (!paramAbsListView.d()) {
        break label277;
      }
      paramAbsListView.a(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Boolean = true;
      VipUtils.a(this.app, "chat_history", "ChatHistory", "Slip_up", 0, 0, new String[] { "0", "0" });
      paramAbsListView.a(3, null, false);
      return;
      label277:
      paramAbsListView.b(localCalendar1);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAbsListView == null) {}
    label64:
    label219:
    label344:
    label376:
    label389:
    for (;;)
    {
      return;
      if ((paramInt2 == paramInt3) && (paramInt3 != 0) && (paramInt1 == 0) && (paramAbsListView.getChildCount() > 0) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0))
      {
        localObject1 = paramAbsListView.getChildAt(paramAbsListView.t() - 1);
        if (localObject1 != null) {
          break label344;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          this.jdField_c_of_type_JavaUtilCalendar.setTimeInMillis(((ChatMessage)localObject1).time * 1000L);
          localObject1 = (MessageRoamManager)this.app.getManager(91);
          localObject2 = ((MessageRoamManager)localObject1).c();
          if ((localObject2 != null) && (this.jdField_c_of_type_JavaUtilCalendar.get(1) <= ((Calendar)localObject2).get(1)) && (this.jdField_c_of_type_JavaUtilCalendar.get(2) <= ((Calendar)localObject2).get(2)) && (this.jdField_c_of_type_JavaUtilCalendar.get(5) < ((Calendar)localObject2).get(5)))
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          }
          if (((MessageRoamManager)localObject1).c())
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
        }
      }
      Object localObject1 = paramAbsListView.getChildAt(0);
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          paramAbsListView = paramAbsListView.getChildAt(3);
          if (paramAbsListView != null) {
            break label376;
          }
        }
      }
      for (Object localObject2 = null;; localObject2 = (ChatMessage)paramAbsListView.getTag(2131296315))
      {
        if (localObject2 == null) {
          break label389;
        }
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(((ChatMessage)localObject2).time * 1000L);
        this.jdField_a_of_type_JavaUtilCalendar.set(11, 0);
        this.jdField_a_of_type_JavaUtilCalendar.set(12, 0);
        this.jdField_a_of_type_JavaUtilCalendar.set(13, 0);
        this.jdField_a_of_type_JavaUtilCalendar.set(14, 0);
        if (this.jdField_a_of_type_JavaUtilCalendar.equals(this.jdField_b_of_type_JavaUtilCalendar)) {
          break;
        }
        this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(this.jdField_a_of_type_JavaUtilCalendar.getTimeInMillis());
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65537, 100L);
        return;
        localObject1 = (ChatMessage)((View)localObject1).getTag(2131296315);
        break label64;
        localObject1 = (ChatMessage)((View)localObject1).getTag(2131296315);
        break label219;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast == null) {
      this.jdField_a_of_type_AndroidWidgetToast = Toast.makeText(this, paramString, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetToast.show();
      return;
      this.jdField_a_of_type_AndroidWidgetToast.setText(paramString);
    }
  }
  
  public void a(Calendar paramCalendar)
  {
    this.d.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramCalendar == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131368121));
      this.jdField_a_of_type_Boolean = false;
    }
    Object localObject;
    do
    {
      return;
      localObject = (MessageRoamManager)this.app.getManager(91);
      Calendar localCalendar = ((MessageRoamManager)localObject).b();
      localObject = ((MessageRoamManager)localObject).c();
      if ((localCalendar != null) && (paramCalendar.compareTo(localCalendar) < 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131368118));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) <= 0))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131368119, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131368120, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
        return;
      }
    } while ((localObject == null) || (paramCalendar.compareTo((Calendar)localObject) <= 0));
    f();
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_c_of_type_Boolean = true;
    paramView = (MessageRoamManager)this.app.getManager(91);
    paramListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_b_of_type_JavaUtilCalendar;
    if (paramListView != null)
    {
      Calendar localCalendar = paramView.b();
      if ((localCalendar != null) && (paramListView.get(1) == localCalendar.get(1)) && (paramListView.get(2) == localCalendar.get(2)) && (paramListView.get(5) == localCalendar.get(5))) {
        a(2130838454, super.getString(2131368118));
      }
    }
    else
    {
      return false;
    }
    if (paramView.d()) {
      paramView.a(paramListView.get(1), paramListView.get(2), paramListView.get(5));
    }
    for (;;)
    {
      VipUtils.a(this.app, "chat_history", "ChatHistory", "Slip_down", 0, 0, new String[] { "0", "0" });
      paramView.a(2, null, false);
      return false;
      paramView.b(paramListView);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "gotoCreatePasswordUrl ! ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(0);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://mapp.3g.qq.com/touch/psw/create.jsp?_wv=5123");
    startActivityForResult(localIntent, 28);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  void b(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "scrollToRecentDay rencent is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a().getTimeInMillis();
      l2 = paramCalendar.getTimeInMillis();
      if (l2 >= l1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryForC2C", 2, "scrollToRecentDay rencent < begin, begin=" + l1 + ",recent=" + l2);
    return;
    int i1;
    int i2;
    StringBuilder localStringBuilder1;
    int i3;
    StringBuilder localStringBuilder2;
    if (l2 == l1)
    {
      i1 = 0;
      i2 = i1;
      if (i1 > this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int) {
        i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "scrollToRecentDay scrollx: " + i2 + ", maxWidth: " + this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(i2, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localStringBuilder1 = new StringBuilder();
      i1 = paramCalendar.get(1);
      i2 = paramCalendar.get(2) + 1;
      i3 = paramCalendar.get(5);
      localStringBuilder2 = localStringBuilder1.append(i1).append("-");
      if (i2 <= 9) {
        break label352;
      }
      paramCalendar = Integer.valueOf(i2);
      label249:
      localStringBuilder2 = localStringBuilder2.append(paramCalendar).append("-");
      if (i3 <= 9) {
        break label377;
      }
    }
    label352:
    label377:
    for (paramCalendar = Integer.valueOf(i3);; paramCalendar = "0" + i3)
    {
      localStringBuilder2.append(paramCalendar);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
      this.jdField_b_of_type_AndroidViewView.invalidate();
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
      return;
      i1 = (int)((l2 - l1) / 86400000L) * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      break;
      paramCalendar = "0" + i2;
      break label249;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "gotoRoamMessageSettingUrl ! ");
    }
    this.Q = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.a(), -1);
    VipUtils.a(this.app, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 1, 0, new String[] { "0", "0", "msgHistory" });
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://imgcache.qq.com/club/client/msgRoam/rel/html/index_v2.html?_wv=5123&ADTAG=msgHistory");
    startActivityForResult(localIntent, 29);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  void d()
  {
    View localView1 = super.findViewById(2131297082);
    View localView2 = super.findViewById(2131296895);
    int i1 = localView1.getHeight();
    Object localObject = (MessageRoamManager)this.app.getManager(91);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog = new C2CMessageSearchDialog(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MessageRoamManager)localObject).j());
    localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject).setDuration(200L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation.setDuration(200L);
    ((TranslateAnimation)localObject).setAnimationListener(new kxh(this, localView2, localView1));
    localTranslateAnimation.setAnimationListener(new kxi(this, localView2, i1));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.setOnDismissListener(new kxj(this, localView2, i1, localView1, localTranslateAnimation));
    localView2.startAnimation((Animation)localObject);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != 3000);
        r();
        return;
        paramInt1 = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.a(), -1);
      } while (paramInt1 == this.Q);
      if (paramInt1 > this.Q) {
        a(true);
      }
      for (;;)
      {
        this.Q = paramInt1;
        return;
        if (paramInt1 < this.Q) {
          a(true);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "switch auth mode result: " + paramInt2 + ", cur mode: " + this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b());
      }
      a(false);
      return;
    } while (-1 != paramInt2);
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this);
    setContentViewNoTitle(2130903196);
    paramBundle = super.findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    if (ChatBackground.a(BaseApplicationImpl.getContext(), this.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      paramBundle.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
    }
    init(getIntent());
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.app.getManager(23));
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager = ((MessageRoamManager)this.app.getManager(91));
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(hashCode());
    this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_c_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(0L);
    s();
    q();
    l();
    if (this.app.a() != null)
    {
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
      this.app.a().e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.o();
    boolean bool1 = NetworkUtil.e(BaseApplication.getContext());
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.g();
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "isOpenMessageRoam: " + bool2 + ", netState: " + bool1);
    }
    if ((!bool1) || (!bool2))
    {
      if (!bool1) {
        a(null);
      }
      r();
    }
    for (;;)
    {
      ThreadManager.b().post(new kxg(this));
      return true;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.e())
      {
        paramBundle = (MessageRoamHandler)this.app.a(59);
        label484:
        StringBuilder localStringBuilder;
        if (paramBundle != null)
        {
          paramBundle.a();
          if (!QLog.isColorLevel()) {
            break label532;
          }
          localStringBuilder = new StringBuilder().append("hasGetAuthMode false hanlder is null: ");
          if (paramBundle != null) {
            break label534;
          }
        }
        label532:
        label534:
        for (bool1 = true;; bool1 = false)
        {
          QLog.d("ChatHistoryForC2C", 2, bool1);
          break;
          r();
          break label484;
          break;
        }
      }
      a(false);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
        if (((View)localObject).getTag() != null)
        {
          localObject = (FlashPicItemBuilder.FlashPicHolder)((View)localObject).getTag();
          if (((FlashPicItemBuilder.FlashPicHolder)localObject).a != null) {
            ((URLDrawable)((FlashPicItemBuilder.FlashPicHolder)localObject).a.getDrawable()).setURLDrawableListener(null);
          }
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistoryForC2C", 2, "", localException);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (((MessageRoamManager)this.app.getManager(91)).a(hashCode())) {
        this.app.a(getClass());
      }
      t();
      j();
      if (this.app.a() != null)
      {
        this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
        this.app.a().e();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C, null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.notifyDataSetChanged();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(this, 2130904932, null));
    int i1 = (int)DisplayUtils.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, i1, 0, i1);
    ((RelativeLayout)localObject).setBackgroundResource(2130843260);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131493022));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a((View)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300876).setVisibility(8);
    localObject = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300895);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(this);
    setLayerType(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.d.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  void g()
  {
    this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(null);
    CheckBox localCheckBox;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      localCheckBox = (CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298018);
      if (!localCheckBox.isChecked()) {
        break label196;
      }
      VipUtils.a(this.app, "chat_history", "ChatHistory", "Clk_deleteCloud", 1, 0, new String[] { this.jdField_b_of_type_JavaLangString });
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "删除云端消息记录 ，T ：0X8004FAF ， userIdentity" + this.jdField_b_of_type_JavaLangString);
      }
      i();
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    for (;;)
    {
      MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
      if (localMessageRoamManager != null)
      {
        localMessageRoamManager.a().f();
        localMessageRoamManager.b();
        if (localCheckBox.isChecked()) {
          localMessageRoamManager.m();
        }
      }
      return;
      label196:
      VipUtils.a(this.app, "chat_history", "ChatHistory", "Clk_deleteLocal", 1, 0, new String[] { this.jdField_b_of_type_JavaLangString });
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "删除本地消息记录 ，T ：0X8004FAE ， userIdentity" + this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  void h()
  {
    ((MessageRoamManager)this.app.getManager(91)).b(super.getString(2131368109));
  }
  
  public void i()
  {
    if (!NetworkUtil.e(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(this.app.a(), 2131368679, 1).a();
      return;
    }
    b(super.getString(2131368680));
    ((MessageRoamManager)this.app.getManager(91)).h();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  void j()
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(super.getString(2131364614));
    localActionSheet.a("删除手机聊天记录", 3);
    localActionSheet.a("删除漫游聊天记录", 3);
    localActionSheet.d(2131367262);
    localActionSheet.a(new kwx(this, localActionSheet));
    localActionSheet.show();
  }
  
  void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView = ((AutoFitScrollView)super.findViewById(2131297648));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView = ((TimeLineView)super.findViewById(2131297649));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setPressed(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setEnabled(false);
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = super.getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setFitWidth(this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setCallback(this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297651);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297652));
  }
  
  protected boolean onBackEvent()
  {
    setResult(-1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.a(false);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "onClick event unknow id: " + paramView.getId());
      }
    case 2131297183: 
    case 2131297392: 
    case 2131297646: 
    case 2131297429: 
    case 2131298593: 
    case 2131300895: 
      long l1;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (NetworkUtil.e(BaseApplication.getContext()))
              {
                this.jdField_a_of_type_Boolean = true;
                f();
                VipUtils.a(this.app, "vip", "0X8004FAC", "0X8004FAC", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
                c();
                return;
              }
              a(null);
              return;
              k();
              VipUtils.a(this.app, "chat_history", "ChatHistory", "Clk_deleteAll", 1, 0, new String[0]);
              return;
            } while (this.jdField_a_of_type_Boolean);
            if (VersionUtils.e())
            {
              startActivity(new Intent("android.settings.SETTINGS"));
              return;
            }
            startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            return;
            paramView = (Bundle)this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.getTag();
          } while (paramView == null);
          paramView = paramView.getString("goUrl");
          if (!TextUtils.isEmpty(paramView))
          {
            localObject = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramView);
            startActivity((Intent)localObject);
            VipUtils.a(this.app, "vip", "0X8004F9C", "0X8004F9C", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ChatHistoryForC2C", 2, "onClick blue tipe goUrl is null");
        return;
        l1 = System.currentTimeMillis();
      } while (l1 - this.jdField_a_of_type_Long <= 1000L);
      this.jdField_a_of_type_Long = l1;
      d();
      ReportController.b(this.app, "CliOper", "", "", "0X8005FC1", "0X8005FC1", 0, 0, "", "", "", "");
      return;
    }
    paramView = (MessageRoamManager)this.app.getManager(91);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_JavaUtilCalendar;
    if (localObject != null)
    {
      if (paramView.d()) {
        paramView.a(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5));
      }
      for (;;)
      {
        Calendar localCalendar = paramView.c();
        if ((localCalendar == null) || (((Calendar)localObject).get(1) != localCalendar.get(1)) || (((Calendar)localObject).get(2) != localCalendar.get(2)) || (((Calendar)localObject).get(5) != localCalendar.get(5))) {
          break;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
        paramView.b((Calendar)localObject);
      }
    }
    this.jdField_c_of_type_Boolean = true;
    paramView.a(3, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatHistoryForC2C.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */