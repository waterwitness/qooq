package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.audio.AudioSettingManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotchat.PttMsgAdapter;
import com.tencent.mobileqq.hotchat.ui.PttTimeLineItemInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.XBaseAdapter;
import com.tencent.widget.XListView;
import mqq.manager.Manager;
import ndi;
import ndj;
import ndk;
import ndl;
import ndm;
import ndn;
import ndo;

public class MediaPlayerManager
  extends BroadcastReceiver
  implements SensorEventListener, AudioPlayer.AudioPlayerListener, Runnable, Manager
{
  public static int a = 0;
  private static final String jdField_a_of_type_JavaLangString;
  private static final int jdField_b_of_type_Int = 1000;
  private static final float jdField_d_of_type_Float = 0.6F;
  private static final float jdField_e_of_type_Float = 0.02F;
  private static final float jdField_f_of_type_Float = -999.0F;
  public float a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new ndk(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private MediaPlayerManager.Callback jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback;
  private MediaPlayerManager.Listener jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener;
  private MediaPlayerManager.PttShowCallback jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$PttShowCallback;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private PttMsgAdapter jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private XBaseAdapter jdField_a_of_type_ComTencentWidgetXBaseAdapter;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new ndn(this);
  private ndo jdField_a_of_type_Ndo;
  public boolean a;
  public float b;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  boolean jdField_b_of_type_Boolean = true;
  public float c;
  boolean c;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private float jdField_g_of_type_Float;
  private boolean jdField_g_of_type_Boolean;
  private float jdField_h_of_type_Float = 0.6F;
  private boolean jdField_h_of_type_Boolean;
  private float jdField_i_of_type_Float = 0.02F;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = MediaPlayerManager.class.getSimpleName();
    jdField_a_of_type_Int = 1000;
  }
  
  public MediaPlayerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    BaseApplication localBaseApplication = paramQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(localBaseApplication, this);
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)localBaseApplication.getSystemService("sensor"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    if (Build.VERSION.SDK_INT >= 11)
    {
      localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
      localIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    }
    localBaseApplication.registerReceiver(this, localIntentFilter);
    a(paramQQAppInterface);
  }
  
  private float a(Sensor paramSensor)
  {
    String str = Build.MODEL;
    float f1;
    if ((str.equals("ZTE U880s")) || (str.equals("ZTE U807"))) {
      f1 = 97.0F;
    }
    do
    {
      return f1;
      if ((str.equals("Coolpad 5890")) || (str.equals("Coolpad 5891")) || (str.equals("Coolpad 8720L")) || (str.equals("Coolpad 5879")) || (str.equals("Coolpad 5891Q"))) {
        return 5.0F;
      }
      if ((str.equals("HUAWEI Y320-T00")) || (str.equals("Lenovo A658t")) || (str.equals("Lenovo A788t"))) {
        return 10.0F;
      }
      if (str.equals("ME860")) {
        return 99.0F;
      }
      if ((str.equals("ZTE U930HD")) || (str.equals("ZTE-T U960s"))) {
        return 100.0F;
      }
      f1 = 0.0F;
    } while (paramSensor == null);
    return paramSensor.getMaximumRange();
  }
  
  private int a(ChatMessage paramChatMessage, PttMsgAdapter paramPttMsgAdapter)
  {
    if (paramPttMsgAdapter != null)
    {
      int m = 0;
      if (m < paramPttMsgAdapter.getCount())
      {
        Object localObject = paramPttMsgAdapter.getItem(m);
        if ((localObject == null) || (!(localObject instanceof PttTimeLineItemInfo))) {}
        do
        {
          do
          {
            m += 1;
            break;
            localObject = ((PttTimeLineItemInfo)localObject).a;
          } while (localObject == null);
          localObject = (MessageForPtt)localObject;
        } while ((localObject.getClass() != paramChatMessage.getClass()) || (((MessageForPtt)localObject).uniseq != paramChatMessage.uniseq));
        return m;
      }
    }
    return -1;
  }
  
  public static int a(ChatMessage paramChatMessage, XBaseAdapter paramXBaseAdapter)
  {
    if (paramXBaseAdapter != null)
    {
      int m = 0;
      while (m < paramXBaseAdapter.getCount())
      {
        Object localObject = paramXBaseAdapter.getItem(m);
        if (localObject != null) {
          if ((localObject instanceof ChatMessage))
          {
            if (((ChatMessage)localObject).uniseq != paramChatMessage.uniseq) {}
          }
          else {
            do
            {
              return m;
              if (!(localObject instanceof RecentBaseData)) {
                break;
              }
              localObject = (RecentBaseData)localObject;
            } while ((paramChatMessage.frienduin.equals(((RecentBaseData)localObject).a())) && (paramChatMessage.istroop == ((RecentBaseData)localObject).a()));
          }
        }
        m += 1;
      }
    }
    return -1;
  }
  
  private int a(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_Boolean) {}
    for (int m = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter);; m = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentWidgetXBaseAdapter))
    {
      if (m >= 0)
      {
        if (!this.jdField_g_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$PttShowCallback.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, m, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramBoolean);
      }
      return m;
    }
    View localView = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.m() + m);
    a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, m, localView, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    return m;
  }
  
  private MediaPlayerManager.Callback a(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXBaseAdapter instanceof ChatAdapter1)) {
      return (MediaPlayerManager.Callback)((ChatAdapter1)this.jdField_a_of_type_ComTencentWidgetXBaseAdapter).a.a(paramChatMessage, this.jdField_a_of_type_ComTencentWidgetXBaseAdapter);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback;
  }
  
  public static MediaPlayerManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (MediaPlayerManager)paramQQAppInterface.getManager(23);
      return paramQQAppInterface;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private ChatMessage a(int paramInt)
  {
    if (this.jdField_g_of_type_Boolean) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.getItem(paramInt); (localObject != null) && ((localObject instanceof ChatMessage)); localObject = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter.getItem(paramInt)) {
      return (ChatMessage)localObject;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "$bindApp, app = " + paramQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static boolean a()
  {
    return Build.MODEL.equals("ZTE U930");
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        if (!this.jdField_g_of_type_Boolean) {
          break label47;
        }
      }
      label47:
      for (localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter;; localObject = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter)
      {
        if (localObject != null) {
          a(paramBoolean);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
        return true;
      }
    }
    if (this.jdField_g_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter;
      label67:
      if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)) {
        break label133;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break label135;
      }
    }
    label133:
    label135:
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$PttShowCallback.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);; bool = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      if (!bool) {
        break label156;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
      break;
      localObject = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter;
      break label67;
      break;
    }
    label156:
    return false;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      Object localObject1;
      int m;
      label44:
      int n;
      if (this.jdField_g_of_type_Boolean)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter;
        if (localObject1 == null) {
          break label372;
        }
        if (!this.jdField_g_of_type_Boolean) {
          break label117;
        }
        m = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter);
        if (!this.jdField_g_of_type_Boolean) {
          break label133;
        }
        n = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.getCount();
      }
      for (;;)
      {
        if (m <= n)
        {
          if (this.jdField_g_of_type_Boolean)
          {
            if (m >= 0) {
              this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$PttShowCallback.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, m, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
            }
            this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
            return false;
            localObject1 = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter;
            break;
            label117:
            m = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentWidgetXBaseAdapter);
            break label44;
            label133:
            n = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter.getCount();
            continue;
          }
          Object localObject2 = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.m() + m);
          if (m >= 0) {
            a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, m, (View)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          }
          if (this.d) {
            while (m < n - 1)
            {
              int i2 = m + 1;
              ChatMessage localChatMessage = a(i2);
              localObject1 = localObject2;
              if ((localChatMessage instanceof MediaPlayerManager.Media))
              {
                if ((this.k) && (localObject2 != null)) {
                  m = 1;
                }
                for (;;)
                {
                  localObject2 = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, i2);
                  try
                  {
                    localObject1 = a(localChatMessage);
                    if ((((MediaPlayerManager.Callback)localObject1).a(this.jdField_a_of_type_ComTencentWidgetXListView, i2, (View)localObject2, localChatMessage)) && (((MediaPlayerManager.Callback)localObject1).a(this.jdField_a_of_type_ComTencentWidgetXListView, i2, (View)localObject2, localChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer))) {}
                    for (int i1 = 1;; i1 = 0)
                    {
                      localObject1 = localObject2;
                      if (i1 == 0) {
                        break label363;
                      }
                      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = localChatMessage;
                      if (m != 0) {
                        this.jdField_a_of_type_ComTencentWidgetXListView.e(i2);
                      }
                      return true;
                      m = 0;
                      break;
                    }
                    m = i2;
                  }
                  catch (Exception localException)
                  {
                    localObject1 = localObject2;
                    if (QLog.isColorLevel())
                    {
                      QLog.e(jdField_a_of_type_JavaLangString, 2, "playNext", localException);
                      localObject1 = localObject2;
                    }
                  }
                }
              }
              label363:
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    label372:
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    return false;
  }
  
  private void e()
  {
    int i1 = 0;
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qq_audio_play.name(), null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "MediaPlayerManager.initSensors | dpcConfig = " + (String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {}
    for (;;)
    {
      float f2;
      try
      {
        localObject = ((String)localObject).split("\\|");
        bool = "1".equals(localObject[0]);
        if (!bool) {
          n = 1;
        }
      }
      catch (Exception localException1)
      {
        boolean bool;
        label261:
        label288:
        label343:
        n = 1;
        f2 = 0.0F;
        label361:
        f1 = f2;
        m = n;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parse dpc error", localException1);
        f1 = f2;
        m = n;
        continue;
      }
      try
      {
        f2 = Float.parseFloat(localObject[1]);
        f1 = f2;
        m = n;
      }
      catch (Exception localException4)
      {
        label396:
        label428:
        f2 = 0.0F;
        continue;
      }
      for (;;)
      {
        try
        {
          if (localObject.length >= 5)
          {
            this.jdField_h_of_type_Float = Float.parseFloat(localObject[2]);
            this.jdField_i_of_type_Float = Float.parseFloat(localObject[3]);
            jdField_a_of_type_Int = Integer.parseInt(localObject[4]);
            m = n;
            f1 = f2;
          }
          if (jdField_a_of_type_Int < 0) {
            jdField_a_of_type_Int = 1000;
          }
          if (this.jdField_h_of_type_Float <= 0.0F) {
            m = 0;
          }
          localObject = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.qq_audio_play_fix.name(), null);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "DPC config to UIN | dpcConfig = " + (String)localObject);
          }
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).length() <= 1)) {
            continue;
          }
        }
        catch (Exception localException5)
        {
          break label361;
          break label261;
          n = m;
          break label288;
        }
        try
        {
          localObject = ((String)localObject).split("\\|");
          if ("-1".equals(localObject[4])) {
            continue;
          }
          f2 = Float.parseFloat(localObject[4]);
          f1 = f2;
        }
        catch (Exception localException2)
        {
          f2 = f1;
          f1 = f2;
          n = m;
          if (!QLog.isColorLevel()) {
            break label288;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "DPC config to UIN error.", localException2);
          f1 = f2;
          n = m;
          break label288;
          if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
            break label343;
          }
          this.jdField_g_of_type_Float = a(this.jdField_a_of_type_AndroidHardwareSensor);
          break label343;
        }
      }
      try
      {
        bool = "1".equals(localObject[5]);
        m = i1;
        if (!bool) {
          m = 1;
        }
        n = m;
        if (n != 0)
        {
          this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
          this.jdField_a_of_type_Ndo = new ndo(this);
        }
        this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
        if (f1 <= 0.5F) {
          break label428;
        }
        this.jdField_g_of_type_Float = f1;
        this.j = true;
        return;
      }
      catch (Exception localException3)
      {
        f2 = f1;
        break label396;
      }
      int n = 0;
      continue;
      float f1 = 0.0F;
      int m = 1;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Float = -999.0F;
    this.jdField_b_of_type_Float = -999.0F;
    this.jdField_c_of_type_Float = -999.0F;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public AudioPlayer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  }
  
  public ChatMessage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public void a()
  {
    try
    {
      a(true);
      a(this.jdField_a_of_type_ComTencentWidgetXListView);
      a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "$unBindApp");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "", localException);
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    ThreadManager.a(new ndj(this), null, false);
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        a(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.b(paramInt);
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ndl(this, paramAudioPlayer, paramInt));
  }
  
  public void a(HorizontalListView paramHorizontalListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "unBindPttShowUI");
    }
    this.jdField_g_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView == paramHorizontalListView))
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = null;
      this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$PttShowCallback = null;
      this.e = false;
      this.f = false;
    }
  }
  
  public void a(HorizontalListView paramHorizontalListView, PttMsgAdapter paramPttMsgAdapter, MediaPlayerManager.PttShowCallback paramPttShowCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "bindPttShowUI, mPttShowListView = " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView + " ,hlistView = " + paramHorizontalListView + " ,pttAdapter = " + paramPttMsgAdapter);
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter = paramPttMsgAdapter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$PttShowCallback = paramPttShowCallback;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
  }
  
  public void a(XListView paramXListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "unBindUI");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView == paramXListView))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_ComTencentWidgetXBaseAdapter = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback = null;
      this.d = false;
      this.k = false;
    }
  }
  
  public void a(XListView paramXListView, XBaseAdapter paramXBaseAdapter, MediaPlayerManager.Listener paramListener)
  {
    a(paramXListView, paramXBaseAdapter, paramListener, null, true, true);
  }
  
  public void a(XListView paramXListView, XBaseAdapter paramXBaseAdapter, MediaPlayerManager.Listener paramListener, MediaPlayerManager.Callback paramCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "bindUI, mListView = " + this.jdField_a_of_type_ComTencentWidgetXListView + " ,listView = " + paramXListView + " ,adapter = " + paramXBaseAdapter + ", listener = " + paramListener);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXBaseAdapter = paramXBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = paramListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Callback = paramCallback;
    this.d = paramBoolean1;
    this.k = paramBoolean2;
  }
  
  public void a(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (a(paramBoolean)) {
        c();
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ndi(this, paramBoolean));
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return a(paramChatMessage, false);
  }
  
  public boolean a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (!this.j) {
      e();
    }
    f();
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    Object localObject;
    label65:
    boolean bool2;
    boolean bool3;
    int m;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter;
      if ((localObject == null) || (paramChatMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
        break label349;
      }
      if (!a(false)) {
        break label330;
      }
      if (!AIOUtils.b()) {
        break label240;
      }
      this.jdField_h_of_type_Boolean = true;
      bool2 = AudioSettingManager.a(BaseApplicationImpl.getContext());
      bool3 = AudioHelper.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_h_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool3);
      if (!paramBoolean) {
        break label254;
      }
      m = a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter);
      label126:
      if (!paramBoolean) {
        break label267;
      }
    }
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$PttShowCallback.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, m, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer);; bool1 = a(paramChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, m, (View)localObject, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer))
    {
      if (!bool1) {
        break label312;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_g_of_type_Boolean = paramBoolean;
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.R();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(bool2, bool3, this.jdField_h_of_type_Boolean, false);
      }
      this.jdField_i_of_type_Boolean = false;
      ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.a(this, 8, null, false);
      return true;
      localObject = this.jdField_a_of_type_ComTencentWidgetXBaseAdapter;
      break;
      label240:
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
      break label65;
      label254:
      m = a(paramChatMessage, this.jdField_a_of_type_ComTencentWidgetXBaseAdapter);
      break label126;
      label267:
      localObject = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.m() + m);
    }
    label312:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "builder play failed.");
    }
    for (;;)
    {
      return false;
      label330:
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doStop failed.");
        continue;
        label349:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "request play failed, mAdapter = " + this.jdField_a_of_type_ComTencentWidgetXBaseAdapter + ", msg = " + paramChatMessage + ", app = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramBoolean)
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$PttShowCallback.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, paramInt, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer);
      paramBoolean = bool;
      if (bool)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.R();
        }
        ThreadManager.a(this, 8, null, false);
      }
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      }
      return paramBoolean;
    }
  }
  
  public void b()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
    if ((bool != this.jdField_h_of_type_Boolean) && (b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(AudioSettingManager.a(BaseApplicationImpl.getContext()), AudioHelper.a(BaseApplicationImpl.getContext()), bool, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "$updateSpeakPhone| speakerOn=" + bool);
      }
    }
    this.jdField_h_of_type_Boolean = bool;
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.c(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (b())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.k = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "$onStop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.S();
    }
    ThreadManager.a(this);
    ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ndm(this, paramInt));
  }
  
  public void d()
  {
    if (!AudioPlayer.jdField_a_of_type_Boolean) {}
    AudioManager localAudioManager;
    do
    {
      return;
      localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    } while ((!AudioPlayer.jdField_b_of_type_Boolean) || (localAudioManager == null) || (!localAudioManager.isBluetoothScoOn()));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "stop sco");
    }
    localAudioManager.stopBluetoothSco();
    localAudioManager.setBluetoothScoOn(false);
    AudioPlayer.jdField_b_of_type_Boolean = false;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onDestroy()
  {
    d();
    a();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    String str = paramIntent.getAction();
    if ((str != null) && (str.equals("android.intent.action.HEADSET_PLUG"))) {
      if (paramIntent.hasExtra("state"))
      {
        if (paramIntent.getIntExtra("state", 0) != 1) {
          break label95;
        }
        bool1 = true;
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(bool1, AudioHelper.a(BaseApplicationImpl.getContext()), this.jdField_h_of_type_Boolean, true);
        }
      }
    }
    label95:
    label296:
    int m;
    label437:
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
              bool1 = false;
              break;
              if ((str != null) && (str.equals("tencent.av.v2q.StartVideoChat")))
              {
                bool1 = paramIntent.getBooleanExtra("updateTime", false);
                bool2 = paramIntent.getBooleanExtra("showTime", false);
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "receive action_recv_video_request. update:" + bool1 + ", show:" + bool2);
                }
                if ((bool1) && (bool2)) {
                  ChatActivityUtils.a();
                }
                a(true);
                return;
              }
              if (!"android.media.RINGER_MODE_CHANGED".equals(str)) {
                break label296;
              }
            } while (((AudioManager)paramContext.getSystemService("audio")).getRingerMode() == 2);
            this.jdField_h_of_type_Boolean = false;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(this.jdField_h_of_type_Boolean);
            }
          } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_h_of_type_Boolean)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.b(this.jdField_i_of_type_Boolean, this.jdField_h_of_type_Boolean);
          return;
          if ("android.intent.action.SCREEN_OFF".equals(str))
          {
            a(false);
            ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentWidgetXListView);
            return;
          }
          if (!"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(str)) {
            break label437;
          }
          m = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        } while ((m != 2) && (m != 0));
        paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
        if (m == 2) {}
        for (;;)
        {
          paramContext.d(bool1);
          if (b())
          {
            bool1 = AudioHelper.a(BaseApplicationImpl.getContext());
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool1);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(AudioSettingManager.a(BaseApplicationImpl.getContext()), bool1, this.jdField_h_of_type_Boolean, false);
            }
          }
          if (m != 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.d();
          return;
          bool1 = false;
        }
      } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(str));
      m = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
    } while ((m != 2) && (m != 0));
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
    if (m == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramContext.c(bool1);
      if (b())
      {
        bool1 = AudioHelper.a(BaseApplicationImpl.getContext());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool1);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(AudioSettingManager.a(BaseApplicationImpl.getContext()), bool1, this.jdField_h_of_type_Boolean, false);
        }
      }
      if (m != 2) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.d();
      return;
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((AudioSettingManager.a(BaseApplicationImpl.getContext())) || (AIOUtils.b())) {}
    label234:
    label236:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (paramSensorEvent.values[0] < this.jdField_g_of_type_Float) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              if (((!AudioHelper.a()) && (bool1) && (!this.jdField_a_of_type_Boolean)) || (this.jdField_i_of_type_Boolean == bool1) || (!b())) {
                break label234;
              }
              boolean bool2 = AudioSettingManager.a(BaseApplicationImpl.getContext());
              boolean bool3 = AudioHelper.a(BaseApplicationImpl.getContext());
              this.jdField_i_of_type_Boolean = bool1;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "ProximityEventListener$onSensorChanged | currentSpeaker = " + this.jdField_h_of_type_Boolean + " | mNearToEar = " + this.jdField_i_of_type_Boolean + " | wiredHeadsetConnected = " + bool2 + " | btHeadsetConnect = " + bool3);
              }
              if ((bool2) || (bool3)) {
                break;
              }
              if ((!this.jdField_i_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) {
                break label236;
              }
              this.jdField_h_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_h_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - jdField_a_of_type_Int);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.b(this.jdField_i_of_type_Boolean, this.jdField_h_of_type_Boolean);
              return;
            }
          }
          if (!this.jdField_i_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_h_of_type_Boolean, true, 0);
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.b(this.jdField_i_of_type_Boolean, this.jdField_h_of_type_Boolean);
        return;
      } while ((this.jdField_i_of_type_Boolean) || (this.jdField_h_of_type_Boolean));
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_h_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - jdField_a_of_type_Int);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.b(this.jdField_i_of_type_Boolean, this.jdField_h_of_type_Boolean);
  }
  
  public void run()
  {
    if ((this.jdField_b_of_type_AndroidHardwareSensor != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Ndo, this.jdField_b_of_type_AndroidHardwareSensor, 3);
    }
    if (this.jdField_a_of_type_AndroidHardwareSensor != null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 3);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "$requestPlay| mAccelerationSensro=" + this.jdField_b_of_type_AndroidHardwareSensor + " | mProximitySensor = " + this.jdField_a_of_type_AndroidHardwareSensor);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\MediaPlayerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */