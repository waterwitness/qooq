package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.av.VideoConstants;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import hby;
import java.io.File;
import java.util.Calendar;
import mqq.util.WeakReference;

public class TraeHelper
{
  static TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper;
  static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 1500L, 1500L, 1500L, 1500L };
  public int a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public MediaPlayer.OnCompletionListener a;
  public Button a;
  public VideoController a;
  public TraeAudioSession a;
  hby jdField_a_of_type_Hby = null;
  public String a;
  public WeakReference a;
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 1;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  final int jdField_c_of_type_Int = 2;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  final int jdField_d_of_type_Int = 3;
  Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable = null;
  int jdField_e_of_type_Int = -1;
  Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable = null;
  Drawable f = null;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TraeHelper(Context paramContext, VideoController paramVideoController, Button paramButton)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
    this.jdField_a_of_type_JavaLangString = "TraeSessionHelper";
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidWidgetButton = paramButton;
    this.jdField_a_of_type_Hby = new hby(this);
    paramVideoController = paramContext.getResources();
    paramButton = paramVideoController.getDrawable(2130839054);
    Drawable localDrawable1 = paramVideoController.getDrawable(2130839055);
    Drawable localDrawable2 = paramVideoController.getDrawable(2130839053);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(paramVideoController, 2130839054, 2131428157);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, paramButton.getMinimumWidth(), paramButton.getMinimumHeight());
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(paramVideoController, 2130839055, 2131428157);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, localDrawable1.getMinimumWidth(), localDrawable1.getMinimumHeight());
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(paramVideoController, 2130839053, 2131428157);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, localDrawable2.getMinimumWidth(), localDrawable2.getMinimumHeight());
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(paramVideoController, 2130839054, 2131428165);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, paramButton.getMinimumWidth(), paramButton.getMinimumHeight());
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(paramVideoController, 2130839055, 2131428165);
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, localDrawable1.getMinimumWidth(), localDrawable1.getMinimumHeight());
    this.f = TintStateDrawable.a(paramVideoController, 2130839053, 2131428165);
    this.f.setBounds(0, 0, localDrawable2.getMinimumWidth(), localDrawable2.getMinimumHeight());
    c();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) || ((this.jdField_a_of_type_ComTencentAvVideoController.a().z) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f == 4) && (NetworkUtil.a(paramContext))) || (this.jdField_a_of_type_ComTencentAvVideoController.o()) || (this.jdField_a_of_type_ComTencentAvVideoController.n()) || (this.jdField_b_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().H, false, bool);
      return;
    }
  }
  
  public static TraeHelper a()
  {
    try
    {
      TraeHelper localTraeHelper = jdField_a_of_type_ComTencentAvUtilsTraeHelper;
      return localTraeHelper;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static TraeHelper a(Context paramContext, VideoController paramVideoController)
  {
    if (jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {
        jdField_a_of_type_ComTencentAvUtilsTraeHelper = new TraeHelper(paramContext, paramVideoController, null);
      }
      return jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    }
    finally {}
  }
  
  public static String a(Context paramContext)
  {
    if (VcSystemInfo.f() > 2) {}
    for (String str = "/txlib/libtraeimp-armeabi-v7a.so";; str = "/txlib/libtraeimp-armeabi.so")
    {
      paramContext = paramContext.getFilesDir().getParent() + str;
      try
      {
        System.load(paramContext);
        return paramContext;
      }
      catch (UnsatisfiedLinkError paramContext) {}
    }
    return null;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.a() == null)) {}
    do
    {
      do
      {
        return;
      } while ((!a(paramVideoAppInterface)) || (!a(paramVideoAppInterface.a().getApplicationContext())));
      paramVideoAppInterface = (Vibrator)paramVideoAppInterface.a().getSystemService("vibrator");
    } while (paramVideoAppInterface == null);
    if (paramBoolean)
    {
      paramVideoAppInterface.vibrate(200L);
      return;
    }
    paramVideoAppInterface.vibrate(jdField_a_of_type_ArrayOfLong, 1);
  }
  
  private static boolean a(Context paramContext)
  {
    if ((SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false)) && ((VideoConstants.jdField_b_of_type_Boolean) || (!ReflectionUtil.a(BaseApplicationImpl.a))))
    {
      int i = Calendar.getInstance().get(11);
      if ((i >= 23) || (i < 8)) {
        return false;
      }
    }
    return true;
  }
  
  static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool2;
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.a() == null)) {
      bool2 = false;
    }
    do
    {
      boolean bool1;
      do
      {
        do
        {
          return bool2;
          SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.a());
          bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.a().getString(2131367789), true);
          String str = paramVideoAppInterface.a();
          if (str != null) {
            bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.a().getString(2131367789) + str, true);
          }
          bool2 = bool1;
        } while (AudioUtil.a() == 0);
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (PhoneStatusTools.e(paramVideoAppInterface.a()));
    return true;
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.a() == null)) {}
    do
    {
      return;
      paramVideoAppInterface = (Vibrator)paramVideoAppInterface.a().getSystemService("vibrator");
    } while (paramVideoAppInterface == null);
    paramVideoAppInterface.cancel();
  }
  
  private static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramVideoAppInterface == null) {
      bool2 = bool1;
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
              return bool2;
              SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.a());
              bool1 = bool2;
              if (paramVideoAppInterface.a() != null)
              {
                String str = paramVideoAppInterface.a();
                bool1 = bool2;
                if (str != null) {
                  bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.a().getString(2131367787) + str, true);
                }
              }
              bool2 = bool1;
            } while (AudioUtil.a() == 0);
            bool2 = bool1;
          } while (!bool1);
          bool2 = bool1;
        } while (PhoneStatusTools.b(paramVideoAppInterface.a()));
        bool2 = bool1;
      } while (PhoneStatusTools.d(paramVideoAppInterface.a()));
      bool2 = bool1;
    } while (PhoneStatusTools.e(paramVideoAppInterface.a()));
    return true;
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "connectHighestPriorityDevice");
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Hby);
    }
    return this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
  }
  
  public int a(String paramString)
  {
    return a(paramString, null);
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startService ： " + paramString1 + ",connectDeviceNameWhenServiceOn : " + paramString2);
    }
    this.jdField_c_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Hby);
    }
    int i;
    if (this.jdField_c_of_type_Boolean) {
      if (paramString1.equals(this.jdField_b_of_type_JavaLangString)) {
        i = 0;
      }
    }
    int j;
    do
    {
      return i;
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
      j = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramString1);
      i = j;
    } while (j != 0);
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Boolean = true;
    return j;
  }
  
  public void a()
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setHFBtnStatus deviceName = " + this.jdField_a_of_type_ComTencentAvVideoController.a().r);
    }
    Context localContext = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    if ("DEVICE_SPEAKERPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().r))
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) || ((this.jdField_a_of_type_ComTencentAvVideoController.a().z) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f == 4) && ((localContext == null) || (NetworkUtil.a(localContext)))) || (this.jdField_a_of_type_ComTencentAvVideoController.o()) || (this.jdField_a_of_type_ComTencentAvVideoController.n()) || (this.jdField_b_of_type_Boolean)) {}
      for (bool1 = true;; bool1 = false)
      {
        a(true, false, bool1);
        this.jdField_a_of_type_ComTencentAvVideoController.a().H = true;
        if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
          UITools.a(this.jdField_a_of_type_AndroidWidgetButton, ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131363364));
        }
        return;
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().H = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f != 2) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().z) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f == 4))
      {
        bool1 = bool2;
        if (localContext != null)
        {
          bool1 = bool2;
          if (NetworkUtil.a(localContext)) {}
        }
      }
      else
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.o())
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.n()) {
            if (!this.jdField_b_of_type_Boolean) {
              break label385;
            }
          }
        }
      }
    }
    label385:
    for (bool1 = bool2;; bool1 = false)
    {
      a(false, false, bool1);
      if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
        break;
      }
      UITools.a(this.jdField_a_of_type_AndroidWidgetButton, ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131363365));
      return;
    }
  }
  
  public void a(Button paramButton)
  {
    this.jdField_a_of_type_AndroidWidgetButton = paramButton;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.i();
      return;
    }
    AudioUtil.a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchButton_handFree enter");
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while ((localObject1 == null) || (this.jdField_a_of_type_AndroidWidgetButton == null));
    int i;
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
      }
    }
    else
    {
      localObject1 = (AudioManager)((Context)localObject1).getSystemService("audio");
      i = ((AudioManager)localObject1).getStreamVolume(this.jdField_a_of_type_Int);
      j = ((AudioManager)localObject1).getStreamMaxVolume(this.jdField_a_of_type_Int);
      if (j <= 0) {
        break label467;
      }
    }
    label132:
    label184:
    label461:
    label467:
    for (int j = (int)(i / j * 100.0F);; j = 0)
    {
      if (j < 30) {
        i = 1;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchButton_handFree: level = " + i);
        }
        if (j < 30) {
          if (paramBoolean3) {
            localObject1 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
          }
        }
        for (;;)
        {
          this.jdField_e_of_type_Int = i;
          for (;;)
          {
            try
            {
              if (this.jdField_a_of_type_AndroidWidgetButton != null)
              {
                this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject1, null, null);
                if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
                {
                  if (!paramBoolean3) {
                    continue;
                  }
                  localObject1 = ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getColorStateList(2131428166);
                  if (localObject1 != null) {
                    this.jdField_a_of_type_AndroidWidgetButton.setTextColor((ColorStateList)localObject1);
                  }
                }
              }
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchButton_handFree exception!!");
              continue;
              Object localObject2 = null;
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a().H = paramBoolean1;
            return;
            this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
            break;
            if ((j >= 30) && (j <= 70))
            {
              i = 2;
              break label132;
            }
            if (j <= 70) {
              break label461;
            }
            i = 3;
            break label132;
            localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            break label184;
            if ((j >= 30) && (j <= 70))
            {
              if (paramBoolean3)
              {
                localObject1 = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
                break label184;
              }
              localObject1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
              break label184;
            }
            if (j <= 70) {
              continue;
            }
            if (paramBoolean3)
            {
              localObject1 = this.f;
              break label184;
            }
            localObject1 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
            break label184;
            localObject1 = ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getColorStateList(2131428158);
            if (localObject1 != null) {
              this.jdField_a_of_type_AndroidWidgetButton.setTextColor((ColorStateList)localObject1);
            }
          }
        }
        i = 0;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.a().getApplicationContext())))
    {
      TraeAudioSession localTraeAudioSession;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
        if (paramInt1 != SoundAndVibrateActivity.jdField_e_of_type_Int)
        {
          localTraeAudioSession = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
          if (paramInt2 < 0)
          {
            bool = true;
            if (paramInt2 > 0) {
              break label91;
            }
            paramInt2 = 1;
            label59:
            if (paramOnCompletionListener == null) {
              break label94;
            }
            paramVideoAppInterface = "comp-ring";
            label68:
            localTraeAudioSession.a(0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
          }
        }
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        label91:
        break label59;
        label94:
        paramVideoAppInterface = "normal-ring";
        break label68;
        localTraeAudioSession = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
        Uri localUri = Settings.System.DEFAULT_NOTIFICATION_URI;
        if (paramInt2 < 0)
        {
          bool = true;
          label119:
          if (paramInt2 > 0) {
            break label159;
          }
          paramInt1 = 1;
          label125:
          if (paramOnCompletionListener == null) {
            break label164;
          }
        }
        label159:
        label164:
        for (paramVideoAppInterface = "comp-ring";; paramVideoAppInterface = "normal-ring")
        {
          localTraeAudioSession.a(1, -1, localUri, null, bool, paramInt1, paramVideoAppInterface, true);
          break;
          bool = false;
          break label119;
          paramInt1 = paramInt2;
          break label125;
        }
        AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
      }
    }
    return false;
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.a().getApplicationContext())))
        {
          if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
          {
            this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
            Object localObject;
            if (paramInt1 == 0)
            {
              localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
              if (paramInt2 >= 0) {
                continue;
              }
              bool = true;
              continue;
              ((TraeAudioSession)localObject).a(2, paramInt1, null, paramString, bool, paramInt2, paramVideoAppInterface, true);
              continue;
            }
            else
            {
              if (paramInt1 != SoundAndVibrateActivity.jdField_e_of_type_Int)
              {
                paramString = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
                if (paramInt2 >= 0) {
                  break label225;
                }
                bool = true;
                continue;
                paramString.a(0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface);
                continue;
              }
              paramString = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
              localObject = Settings.System.DEFAULT_NOTIFICATION_URI;
              if (paramInt2 >= 0) {
                break label260;
              }
              bool = true;
              break label241;
              paramString.a(1, -1, (Uri)localObject, null, bool, paramInt1, paramVideoAppInterface);
              continue;
            }
          }
          else
          {
            AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
            continue;
          }
        }
        else {
          return false;
        }
        if (paramInt2 <= 0)
        {
          paramInt2 = 1;
          if (paramOnCompletionListener != null)
          {
            paramVideoAppInterface = "comp-ring";
            continue;
            return true;
            bool = false;
            continue;
          }
        }
        else
        {
          continue;
        }
        paramVideoAppInterface = "normal-ring";
        continue;
        if (paramInt2 > 0) {
          break label231;
        }
        paramInt2 = 1;
        if (paramOnCompletionListener == null) {
          break label234;
        }
        paramVideoAppInterface = "comp-ring";
        continue;
        bool = false;
      }
      catch (Exception paramVideoAppInterface)
      {
        return false;
      }
      label225:
      continue;
      label231:
      continue;
      label234:
      paramVideoAppInterface = "normal-ring";
      continue;
      label241:
      if (paramInt2 <= 0) {}
      for (paramInt1 = 1;; paramInt1 = paramInt2)
      {
        if (paramOnCompletionListener == null) {
          break label272;
        }
        paramVideoAppInterface = "comp-ring";
        break;
        label260:
        bool = false;
        break label241;
      }
      label272:
      paramVideoAppInterface = "normal-ring";
    }
  }
  
  public int b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "connectDevice: " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Hby);
    }
    return this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(paramString);
  }
  
  public void b()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stopSerivce");
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Hby);
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      AudioManager localAudioManager = (AudioManager)((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).getSystemService("audio");
      if (localAudioManager != null)
      {
        int i = localAudioManager.getStreamVolume(this.jdField_a_of_type_Int);
        int j = localAudioManager.getStreamMaxVolume(this.jdField_a_of_type_Int);
        if ((int)(i / j * 100.0F) < 30) {
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().r))
      {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(this.jdField_a_of_type_ComTencentAvVideoController.a().r);
        return;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initTRAE");
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Hby);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().r)) {
        break label158;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(this.jdField_a_of_type_ComTencentAvVideoController.a().r);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.c();
      this.jdField_a_of_type_Boolean = true;
      return;
      label158:
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
    }
  }
  
  public void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "releaseTRAE");
      }
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        b();
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_AndroidWidgetButton = null;
      this.jdField_a_of_type_Hby = null;
      return;
    }
    finally {}
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pressHandFreeBtn: mVideoController = " + this.jdField_a_of_type_ComTencentAvVideoController + ", mAudioSession = " + this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null)) {
      return;
    }
    String[] arrayOfString = this.jdField_a_of_type_ComTencentAvVideoController.a().a;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().H) && (arrayOfString != null))
    {
      int j = 0;
      int k = 0;
      label98:
      int i = j;
      if (k < arrayOfString.length)
      {
        i = j;
        if (j == 0)
        {
          if (!"DEVICE_WIREDHEADSET".equals(arrayOfString[k])) {
            break label234;
          }
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_WIREDHEADSET");
          i = 1;
        }
      }
      k = 0;
      label142:
      j = i;
      if (k < arrayOfString.length)
      {
        j = i;
        if (i == 0)
        {
          if (!"DEVICE_BLUETOOTHHEADSET".equals(arrayOfString[k])) {
            break label243;
          }
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_BLUETOOTHHEADSET");
          j = 1;
        }
      }
      k = 0;
      for (;;)
      {
        i = j;
        if (k < arrayOfString.length)
        {
          i = j;
          if (j == 0)
          {
            if (!"DEVICE_EARPHONE".equals(arrayOfString[k])) {
              break label252;
            }
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_EARPHONE");
            i = 1;
          }
        }
        j = i;
        if (i == 0) {
          break;
        }
        return;
        label234:
        k += 1;
        break label98;
        label243:
        k += 1;
        break label142;
        label252:
        k += 1;
      }
    }
    if (arrayOfString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pressHandFreeBtn: devicesList is null");
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b();
      return;
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_SPEAKERPHONE");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\TraeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */