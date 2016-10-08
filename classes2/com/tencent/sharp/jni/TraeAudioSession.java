package com.tencent.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class TraeAudioSession
  extends BroadcastReceiver
{
  static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private TraeAudioSession.ITraeAudioCallback jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback;
  final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public TraeAudioSession(Context paramContext, TraeAudioSession.ITraeAudioCallback paramITraeAudioCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = Long.MIN_VALUE;
    this.jdField_b_of_type_JavaLangString = "DEVICE_NONE";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "android.intent.action.PHONE_STATE";
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "TraeAudioSession create");
    }
    Object localObject;
    if (Process.myPid() == TraeAudioManager.A)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = a();
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback = paramITraeAudioCallback;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      if ((paramContext == null) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("AudioSession | Invalid parameters: ctx = ");
        if (paramContext != null) {
          break label192;
        }
        localObject = "null";
        label113:
        localObject = localStringBuilder.append((String)localObject).append("; cb = ");
        if (paramITraeAudioCallback != null) {
          break label198;
        }
      }
    }
    label192:
    label198:
    for (paramITraeAudioCallback = "null";; paramITraeAudioCallback = "{object}")
    {
      QLog.w("TRAE", 2, paramITraeAudioCallback);
      paramITraeAudioCallback = new IntentFilter();
      paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
      paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      if ((paramContext != null) && (paramContext.registerReceiver(this, paramITraeAudioCallback) == null)) {}
      a(true);
      return;
      bool = false;
      break;
      localObject = "{object}";
      break label113;
    }
  }
  
  private int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a(paramBoolean, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentContext);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REGISTERAUDIOSESSION");
    localIntent.putExtra("REGISTERAUDIOSESSION_ISREGISTER", paramBoolean);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public static long a()
  {
    long l = Process.myPid();
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    return (l << 32) + i;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", Long.MIN_VALUE);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    paramContext.sendBroadcast(localIntent);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.c("OPERATION_STOPSERVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPSERVICE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a("OPERATION_EARACTION", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt);
    }
    if ((this.jdField_a_of_type_AndroidContentContext == null) || ((paramInt != 0) && (paramInt != 1))) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_EARACTION");
    localIntent.putExtra("EXTRA_EARACTION", paramInt);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a("OPERATION_VOICECALL_PREPROCESS", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_PREPROCESS");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a("OPERATION_STARTRING", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt1, paramInt2, paramUri, paramString, paramBoolean, 1, "normal-ring", false);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", "normal-ring");
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean, int paramInt3, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a("OPERATION_STARTRING", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt1, paramInt2, paramUri, paramString1, paramBoolean, paramInt3, paramString2, false);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a("OPERATION_STARTRING", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt1, paramInt2, paramUri, paramString1, paramBoolean1, paramInt3, paramString2, paramBoolean2);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean1);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", paramBoolean2);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a("OPERATION_STARTSERVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramString);
    }
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTSERVICE");
    localIntent.putExtra("EXTRA_DATA_DEVICECONFIG", paramString);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this);
      a(false);
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(TraeAudioSession.ITraeAudioCallback paramITraeAudioCallback)
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback = paramITraeAudioCallback;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a("OPERATION_GETDEVICELIST", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETDEVICELIST");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.b("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_AUDIOPARAM_CHANGED");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.b("OPERATION_CONNECTDEVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramString);
    }
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.b("OPERATION_GETSTREAMTYPE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETSTREAMTYPE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.d("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.e("OPERATION_ISDEVICECHANGABLED", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_ISDEVICECHANGABLED");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.f("OPERATION_GETCONNECTEDDEVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTEDDEVICE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.g("OPERATION_GETCONNECTINGDEVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTINGDEVICE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.h("OPERATION_VOICECALL_POSTROCESS", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_POSTROCESS");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int i()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.i("OPERATION_STOPRING", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPRING");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int j()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.j("OPERATION_REQUEST_RELEASE_AUDIO_FOCUS", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int k()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.k("OPERATION_RECOVER_AUDIO_FOCUS", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_RECOVER_AUDIO_FOCUS");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramIntent == null) {}
    int j;
    Object localObject;
    label212:
    label219:
    int i;
    label271:
    label750:
    label827:
    do
    {
      do
      {
        String str1;
        String str2;
        String str3;
        do
        {
          long l;
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
                        for (;;)
                        {
                          try
                          {
                            l = paramIntent.getLongExtra("PARAM_SESSIONID", Long.MIN_VALUE);
                            paramContext = paramIntent.getStringExtra("PARAM_OPERATION");
                            j = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
                            if (!"com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY".equals(paramIntent.getAction())) {
                              break label750;
                            }
                            if (!"NOTIFY_SERVICE_STATE".equals(paramContext)) {
                              break label219;
                            }
                            bool1 = paramIntent.getBooleanExtra("NOTIFY_SERVICE_STATE_DATE", false);
                            if (QLog.isColorLevel())
                            {
                              localObject = new StringBuilder().append("AudioSession|[onServiceStateUpdate]");
                              if (!bool1) {
                                break label212;
                              }
                              paramContext = "on";
                              QLog.w("TRAE", 2, paramContext);
                            }
                            if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null) {
                              break;
                            }
                            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.a(bool1);
                            return;
                          }
                          catch (Exception paramContext) {}
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.jdField_a_of_type_Long + " onReceive::intent:" + paramIntent.toString() + " intent.getAction():" + paramIntent.getAction() + " Exception:" + paramContext.getMessage());
                          return;
                          paramContext = "off";
                        }
                        if (!"NOTIFY_DEVICELISTUPDATE".equals(paramContext)) {
                          break;
                        }
                        localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
                        str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
                        str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
                        str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
                        paramContext = "\n";
                        i = 0;
                        if (i < localObject.length)
                        {
                          paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
                          if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
                            break label1694;
                          }
                          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
                            break label1697;
                          }
                          break label1694;
                        }
                        paramContext = paramContext + "\n";
                        if (QLog.isColorLevel()) {
                          QLog.w("TRAE", 2, "AudioSession|[onDeviceListUpdate]  connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
                        }
                        this.jdField_b_of_type_Boolean = bool1;
                        this.jdField_b_of_type_JavaLangString = str1;
                      } while (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null);
                      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.a((String[])localObject, str1, str2, str3);
                      return;
                      if (!"NOTIFY_DEVICECHANGABLE_UPDATE".equals(paramContext)) {
                        break;
                      }
                      bool1 = paramIntent.getBooleanExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", true);
                      if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onDeviceChangabledUpdate]" + bool1);
                      }
                    } while (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null);
                    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.b(bool1);
                    return;
                    if (!"NOTIFY_STREAMTYPE_UPDATE".equals(paramContext)) {
                      break;
                    }
                    i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
                    if (QLog.isColorLevel()) {
                      QLog.w("TRAE", 2, "AudioSession|[onStreamTypeUpdate] err:" + j + " st:" + i);
                    }
                  } while (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null);
                  this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.a(i);
                  return;
                  if (!"NOTIFY_ROUTESWITCHSTART".equals(paramContext)) {
                    break;
                  }
                  paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_FROM");
                  localObject = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_TO");
                } while ((this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null) || (paramContext == null) || (localObject == null));
                this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.a(paramContext, (String)localObject);
                return;
              } while (!"NOTIFY_ROUTESWITCHEND".equals(paramContext));
              paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHEND_DEV");
              l = paramIntent.getLongExtra("EXTRA_DATA_ROUTESWITCHEND_TIME", -1L);
            } while ((this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null) || (paramContext == null) || (l == -1L));
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.a(paramContext, l);
            return;
          } while ((!"com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction())) || (this.jdField_a_of_type_Long != l));
          if (!"OPERATION_GETDEVICELIST".equals(paramContext)) {
            break;
          }
          localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
          str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
          str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
          str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
          paramContext = "\n";
          i = 0;
          bool1 = bool3;
          if (i < localObject.length)
          {
            paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
            if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
              break label1706;
            }
            if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
              break label1709;
            }
            break label1706;
          }
          paramContext = paramContext + "\n";
          this.jdField_b_of_type_Boolean = bool1;
          this.jdField_b_of_type_JavaLangString = str1;
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "AudioSession|[onGetDeviceListRes] err:" + j + " connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
          }
        } while (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null);
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.a(j, (String[])localObject, str1, str2, str3);
        return;
        if (!"OPERATION_CONNECTDEVICE".equals(paramContext)) {
          break;
        }
        paramContext = paramIntent.getStringExtra("CONNECTDEVICE_RESULT_DEVICENAME");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + j + " dev:" + paramContext);
        }
      } while (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null);
      localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback;
      bool1 = bool2;
      if (j == 0) {
        bool1 = true;
      }
      ((TraeAudioSession.ITraeAudioCallback)localObject).a(j, paramContext, bool1);
      return;
      if (!"OPERATION_EARACTION".equals(paramContext)) {
        break;
      }
      i = paramIntent.getIntExtra("EXTRA_EARACTION", -1);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + j + " earAction:" + i);
      }
    } while (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null);
    return;
    if ("OPERATION_ISDEVICECHANGABLED".equals(paramContext))
    {
      bool1 = paramIntent.getBooleanExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("AudioSession|[onIsDeviceChangabledRes] err:").append(j).append(" Changabled:");
        if (!bool1) {
          break label1718;
        }
      }
    }
    label1694:
    label1697:
    label1706:
    label1709:
    label1718:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 2, paramContext);
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.a(j, bool1);
      return;
      if ("OPERATION_GETCONNECTEDDEVICE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTEDDEVICE_REULT_LIST");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetConnectedDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.a(j, paramContext);
        return;
      }
      if ("OPERATION_GETCONNECTINGDEVICE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTINGDEVICE_REULT_LIST");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetConnectingDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.b(j, paramContext);
        return;
      }
      if ("OPERATION_GETSTREAMTYPE".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetStreamTypeRes] err:" + j + " st:" + i);
        }
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.a(j, i);
        return;
      }
      if ("NOTIFY_RING_COMPLETION".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onRingCompletion] err:" + j + " userData:" + paramContext);
        }
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.c(j, paramContext);
        return;
      }
      if (!"OPERATION_VOICECALL_PREPROCESS".equals(paramContext)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioSession|[onVoicecallPreprocess] err:" + j);
      }
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession$ITraeAudioCallback.b(j);
      return;
      bool1 = false;
      i += 1;
      break label271;
      bool1 = false;
      i += 1;
      break label827;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\sharp\jni\TraeAudioSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */