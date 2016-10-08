package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VoiceChangeHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.ptt.PttVoiceChangePreSender;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.voicechange.IVoiceChangeListener;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeData.IconData;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import mqq.os.MqqHandler;
import nga;
import ngb;
import ngc;
import ngd;

public class ListenChangeVoicePanel
  extends RelativeLayout
  implements DialogInterface.OnClickListener, View.OnClickListener, AudioPanelCallback, IVoiceChangeListener
{
  public static final int a = 0;
  public static volatile PttVoiceChangePreSender a;
  static final String jdField_a_of_type_JavaLangString = "ListenChangeVoicePanel";
  public static int[] a;
  public static String[] a;
  public static final int b = 6;
  static final String jdField_b_of_type_JavaLangString = "funcType";
  public static boolean b = false;
  public static int[] b;
  public static String[] b;
  public static final int c = -1;
  static final String jdField_c_of_type_JavaLangString = "url";
  static final int jdField_d_of_type_Int = 101;
  static final String jdField_d_of_type_JavaLangString = "fcID";
  static final int e = 102;
  static final int jdField_f_of_type_Int = 103;
  static final int g = 104;
  static final int h = 105;
  static final int i = 106;
  static final int j = 107;
  static final int k = 1;
  static final int l = 2;
  static final int m = 4;
  private double jdField_a_of_type_Double;
  Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new nga(this, Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public BaseChatPie a;
  public ChangeVoiceListAdapter a;
  public ChangeVoiceView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new ngc(this);
  private VoiceChangeBasicParams jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public ArrayList b;
  boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt = new int[jdField_a_of_type_ArrayOfInt.length];
  protected String e = "android:mvip.gxh.android.changevoice_";
  private String jdField_f_of_type_JavaLangString;
  private volatile int n = -1;
  private int o = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "原声", "萝莉", "大叔", "惊悚", "搞怪", "空灵", "幼稚园", "重机械", "擎天柱", "疯狂动物城闪电", "口吃", "网红", "困兽", "感冒", "土掉渣/歪果仁/方言", "金属机器人", "死肥仔" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "原声音效", "萝莉音效", "大叔音效", "惊悚音效", "搞怪音效", "空灵音效", "幼稚园", "重机械", "擎天柱", "疯狂动物城闪电", "口吃", "网红", "困兽", "感冒", "土掉渣/歪果仁/方言", "金属机器人", "死肥仔" };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837696, 2130837695, 2130837698, 2130837697, 2130837694, 2130837693, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  }
  
  public ListenChangeVoicePanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ListenChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private int a()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_c_of_type_ArrayOfInt.length; i2 = i3)
    {
      i3 = i2;
      if (this.jdField_c_of_type_ArrayOfInt[i1] == 1)
      {
        i3 = i2 + 1;
        this.jdField_c_of_type_ArrayOfInt[i1] = 0;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void a()
  {
    if (this.n == -1) {
      ThreadManager.b().post(new ngd(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = AudioPanel.a(paramInt1) / 1250;
    Bundle localBundle = new Bundle();
    localBundle.putInt("progress", paramInt2);
    localBundle.putInt("playTime", paramInt3);
    localBundle.putInt("level", paramInt1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 103, localBundle));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_c_of_type_Boolean) {
        break label340;
      }
      i2 = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int != 0) {
        break label346;
      }
      i1 = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005474", "0X8005474", i2, 0, paramInt3 + "", i1 + "", "", "6.5.5");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005851", "0X8005851", 0, 0, "", "", "", "");
      }
      paramInt3 = Calendar.getInstance().get(11);
      Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      StatisticCollector localStatisticCollector = StatisticCollector.a(super.getContext());
      HashMap localHashMap = new HashMap();
      localHashMap.put("gender", String.valueOf(localCard.shGender));
      localHashMap.put("age", String.valueOf(localCard.age));
      localHashMap.put("time", String.valueOf(paramInt3));
      localHashMap.put("extra", String.valueOf(paramInt4));
      paramInt3 = paramInt1;
      if (paramInt2 == paramInt1) {
        paramInt3 = paramInt1 + 10;
      }
      localHashMap.put("param_FailCode", String.valueOf(paramInt3));
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localStatisticCollector.a("", "VCPttSendEvent", false, 0L, 0L, localHashMap, "");
      return;
      label340:
      i2 = 2;
      break;
      label346:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int == 3000) {
        i1 = 2;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int == 1) {
        i1 = 3;
      } else {
        i1 = 4;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 2, "VoiceChangeObserver type=" + paramInt1 + ", ret=" + paramInt2 + ", fromUiThread-f:" + paramBoolean);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 107, paramInt1, paramInt2, paramObject));
      return;
    }
    a(false, 0);
    paramObject = (Bundle)paramObject;
    if (paramObject == null)
    {
      QLog.e("ListenChangeVoicePanel", 1, "VoiceChangeObserver bundle=null");
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    int i1 = ((Bundle)paramObject).getInt("callId", 0);
    Object localObject1 = ((Bundle)paramObject).getString("message");
    String str = ((Bundle)paramObject).getString("svr_url");
    paramObject = ((Bundle)paramObject).getString("svr_actStr");
    if (QLog.isColorLevel()) {
      QLog.d("ListenChangeVoicePanel", 2, "VoiceChangeObserver type=" + paramInt1 + ", ret=" + paramInt2 + ", fromUiThread:" + paramBoolean);
    }
    switch (paramInt2)
    {
    default: 
      label288:
      paramInt1 = 4;
    }
    while (paramInt2 != 0)
    {
      QLog.d("ListenChangeVoicePanel", 1, "VoiceChangeObserver fail, ret=" + paramInt2 + ", msg=" + (String)localObject1);
      Object localObject2 = paramObject;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = paramObject;
        if (TextUtils.isEmpty((CharSequence)paramObject)) {
          localObject2 = "了解详情";
        }
      }
      a(paramInt1, i1, null, (String)localObject1, null, (String)localObject2, str);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F45", 0, 0, "" + this.n, "", "", "");
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
      return;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为会员专享，开通即可使用此变声效果";
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty((CharSequence)paramObject)) {
        localObject1 = "立即开通";
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 1;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为超级会员专享，开通即可使用此变声效果";
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty((CharSequence)paramObject)) {
        localObject1 = "立即开通";
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 2;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为需要参加活动才能使用";
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为需要开通星影会员才能使用";
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为需要开通专区会员才能使用";
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label288;
      }
      localObject1 = "你选择的变声效果已下架，不能使用";
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label288;
      }
      localObject1 = "你选择的变声效果任选资格鉴权失败";
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label288;
      }
      localObject1 = "你选择的变声效果未付费";
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label288;
      }
      localObject1 = "你选择的变声效果已过试用期";
      paramInt1 = 4;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299557));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299558));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (AppSetting.j)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131362093));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131362093));
    }
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)super.findViewById(2131301262));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter = new ChangeVoiceListAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.a = this;
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter);
    int i1 = 0;
    if (i1 < jdField_a_of_type_ArrayOfInt.length)
    {
      paramQQAppInterface = this.jdField_a_of_type_JavaUtilArrayList;
      int i3 = jdField_a_of_type_ArrayOfInt[i1];
      paramBaseChatPie = jdField_a_of_type_ArrayOfJavaLangString[i1];
      paramViewGroup = jdField_b_of_type_ArrayOfJavaLangString[i1];
      if (i1 >= 6) {}
      for (int i2 = 0;; i2 = 2)
      {
        paramQQAppInterface.add(new VoiceChangeData(i3, paramBaseChatPie, paramViewGroup, 0, i2, 1, new VoiceChangeData.IconData(jdField_b_of_type_ArrayOfInt[i1], null, null, null)));
        i1 += 1;
        break;
      }
    }
    ThreadManager.a(new ngb(this), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = ((VoiceChangeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(175)).a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas startDownload json.isLoaded=" + paramBoolean + ", isChecked=" + bool);
    }
    if (!bool)
    {
      if (!paramBoolean) {
        break label158;
      }
      QLog.e("ListenChangeVoicePanel", 1, "initVoiceDatas jsonDownloadError");
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      Object localObject2;
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        for (;;)
        {
          if (i1 < 0) {
            break label277;
          }
          localObject2 = (VoiceChangeData)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (((VoiceChangeData)localObject2).b != 0)
          {
            if (6 <= i1) {
              break;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(0, localObject2);
          }
          i1 -= 1;
        }
        label158:
        if (QLog.isColorLevel()) {
          QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas startDownload json.");
        }
        ??? = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getFilesDir(), ClubContentJsonTask.o.b);
        ??? = new DownloadTask(ClubContentJsonTask.o.c, (File)???);
        ((DownloadTask)???).l = true;
        ((DownloadTask)???).jdField_b_of_type_Boolean = true;
        localObject2 = new Bundle();
        ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a((DownloadTask)???, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
    }
    label277:
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 101, null));
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), AIOUtils.a(50.0F, super.getResources()));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public boolean a()
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.f);
    }
    setVisibility(8);
    PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301269);
    localPressToChangeVoicePanel.g();
    localPressToChangeVoicePanel.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.f, null);
    VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_c_of_type_Boolean) {
      i1 = 1;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005475", "0X8005475", i1, 0, "", "", "", "6.5.5");
    if (jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender != null) {
      jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1);
    }
    PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
    return false;
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putInt("funcType", paramInt1);
    this.jdField_a_of_type_AndroidOsBundle.putString("url", paramString5);
    this.jdField_a_of_type_AndroidOsBundle.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "温馨提示";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = "发送失败，网速不给力哦，请重试";
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = "取消";
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = "确定";
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ListenChangeVoicePanel", 1, "showTips content=" + paramString2 + ", title=" + paramString1);
            }
            paramString1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 0, paramString1, paramString2, paramString3, paramString4, this, this);
            if (paramString1 != null)
            {
              paramString1.show();
              return true;
            }
            return false;
          }
        }
      }
    }
  }
  
  public void b()
  {
    VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
    }
  }
  
  public void c()
  {
    int i1 = 1;
    if (this.f == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.f);
      }
      i();
      VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.f, null);
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l())
    {
      localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int, false);
      if ((localObject == null) || (((NoC2CExtensionInfo)localObject).pttChangeVoiceType == this.n)) {
        break label229;
      }
      ((NoC2CExtensionInfo)localObject).pttChangeVoiceType = this.n;
      i1 = 1;
    }
    for (;;)
    {
      if ((i1 != 0) && (localObject != null)) {
        ThreadManager.a().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      jdField_b_of_type_Boolean = false;
      return;
      localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, false);
      if ((localObject != null) && (((ExtensionInfo)localObject).pttChangeVoiceType != this.n))
      {
        ((ExtensionInfo)localObject).pttChangeVoiceType = this.n;
      }
      else
      {
        i1 = 0;
        continue;
        label229:
        i1 = 0;
      }
    }
  }
  
  public void d()
  {
    this.o = this.n;
    if (this.n == -1) {
      this.n = 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f = this.n;
    VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams, PressToChangeVoicePanel.b, this);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 104, null));
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 105, null));
    VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 102, null));
  }
  
  public void i()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301269);
      localPressToChangeVoicePanel.g();
      localPressToChangeVoicePanel.setVisibility(0);
    }
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_ArrayOfInt.length)
    {
      this.jdField_c_of_type_ArrayOfInt[i1] = 0;
      i1 += 1;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    label423:
    label427:
    for (;;)
    {
      return;
      int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("funcType", 4);
      paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("url");
      int i2 = this.jdField_a_of_type_AndroidOsBundle.getInt("fcID", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 1, "DialogInterface funcType=" + i1 + ", url:" + paramDialogInterface);
      }
      if ((1 == i1) || (2 == i1))
      {
        if (paramInt != 1) {
          break label423;
        }
        if (1 == i1)
        {
          VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.e + i2, 3, "1450000515", "LTMCLUB", super.getResources().getString(2131370893), "voiceVip");
          i1 = 0;
        }
      }
      for (;;)
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label427;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + paramInt, "", "", "");
        if (paramInt != 1) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + i1, "", "", "");
        return;
        VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.e + i2, 3, "1450000516", "CJCLUBT", super.getResources().getString(2131371097), "voiceSvip");
        i1 = 0;
        continue;
        if ((paramInt == 1) && (!TextUtils.isEmpty(paramDialogInterface)))
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
          localIntent.putExtra("url", paramDialogInterface);
          localIntent.putExtra("isShowAd", false);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(localIntent);
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131299557)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.f, null);
      i();
      VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_c_of_type_Boolean)
      {
        i1 = 1;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005475", "0X8005475", i1, 0, "", "", "", "6.5.5");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005852", "0X8005852", 0, 0, "", "", "", "");
        }
        PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
        if (jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender != null) {
          jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1);
        }
        i1 = 1;
      }
    }
    for (;;)
    {
      label178:
      Object localObject;
      String str;
      if (i1 >= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = "" + i1;
        if (i1 != 0) {
          break label850;
        }
      }
      label464:
      label495:
      label556:
      label634:
      label639:
      label850:
      for (paramView = "" + this.n;; paramView = "")
      {
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "changevoice", "0X8006F50", 0, 0, str, paramView, "", "");
        do
        {
          return;
          i1 = 2;
          break;
          if (i1 == 2131299558)
          {
            if (this.n >= 6)
            {
              a(true, 2131372154);
              ((VoiceChangeHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(96)).a(1, this.n, this);
              i1 = 2;
              break label178;
            }
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
            i1 = 2;
            break label178;
          }
          this.jdField_a_of_type_Boolean = true;
          if (!(paramView instanceof ChangeVoiceView)) {
            break label857;
          }
          localObject = (ChangeVoiceView)paramView;
        } while ((localObject == null) || (((ChangeVoiceView)localObject).a == null));
        if (2 == ((ChangeVoiceView)localObject).a.b)
        {
          i1 = ((ChangeVoiceView)localObject).d;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.b = i1;
          if (i1 != this.n) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null)
            {
              if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0) && ((this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0) instanceof ViewGroup)))
              {
                paramView = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
                if ((paramView == null) || (paramView.getChildCount() <= 0) || (!(paramView.getChildAt(0) instanceof ChangeVoiceView))) {
                  break label634;
                }
                paramView = (ChangeVoiceView)paramView.getChildAt(0);
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = paramView;
              }
            }
            else
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) && (localObject != this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView)) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(0);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = ((ChangeVoiceView)localObject);
              ((ChangeVoiceView)localObject).a(2);
              this.n = i1;
              e();
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_c_of_type_Boolean) {
                break label639;
              }
              i1 = 1;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005473", "0X8005473", i1, 0, this.n + "", "", "", "6.5.5");
              this.jdField_c_of_type_ArrayOfInt[this.n] = 1;
            }
          }
          for (;;)
          {
            i1 = 0;
            break;
            paramView = null;
            break label464;
            paramView = null;
            break label495;
            i1 = 2;
            break label556;
            if (((ChangeVoiceView)localObject).a() == 2)
            {
              ((ChangeVoiceView)localObject).a(1);
              VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
            }
            else
            {
              if (((ChangeVoiceView)localObject).a() == 1)
              {
                e();
                ((ChangeVoiceView)localObject).a(2);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_c_of_type_Boolean) {}
                for (i1 = 1;; i1 = 2)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005473", "0X8005473", i1, 0, this.n + "", "", "", "6.5.5");
                  break;
                }
              }
              if (QLog.isColorLevel()) {
                QLog.e("changevoice", 2, "CLICK EXCEPTION， curtype = " + this.n + " newtype is " + i1 + " state is " + ((ChangeVoiceView)localObject).a());
              }
            }
          }
        }
        a(4, ((ChangeVoiceView)localObject).d, null, "该道具已下架", null, null, null);
        i1 = 0;
        break label178;
      }
      label857:
      i1 = -1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.f = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = new VoiceChangeBasicParams(this.f, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.b, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c, this.n);
    if (AppSetting.j) {
      AccessibilityUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      super.setVisibility(paramInt);
      if (jdField_b_of_type_Boolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4F", 0, 0, "", "", "", "");
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\audiopanel\ListenChangeVoicePanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */