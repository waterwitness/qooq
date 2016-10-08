package com.tencent.securemodule.impl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import com.qq.jce.wup.UniAttribute;
import com.tencent.securemodule.service.ICallback;
import com.tencent.securemodule.service.IControlService;
import com.tencent.securemodule.ui.SecureEventReceiver;
import java.io.File;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sm.aa;
import sm.ab;
import sm.ac;
import sm.ae;
import sm.ah;
import sm.as;
import sm.at;
import sm.az;
import sm.c;
import sm.e;
import sm.o;
import sm.w;
import sm.x;
import sm.z;

public class SecureService
  extends Service
{
  private Context a;
  private int b = 0;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private a f = new a();
  
  private int a(String paramString)
  {
    this.b += 1;
    int i = -2;
    if (paramString == null) {
      return -6;
    }
    Object localObject1 = new UniAttribute();
    ((UniAttribute)localObject1).setEncodeName("UTF-8");
    ((UniAttribute)localObject1).decode(az.b(paramString));
    paramString = (e)((UniAttribute)localObject1).getByClass("data", new e());
    if ((paramString == null) || (paramString.c() == null)) {
      return -6;
    }
    Object localObject2 = paramString.c();
    localObject1 = x.a(this.a.getApplicationContext());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      int j = ((x)localObject1).a(paramString, (c)((Iterator)localObject2).next());
      i = j;
      if (j != 0) {
        i = j;
      }
    }
    this.b -= 1;
    return i;
  }
  
  private void a()
  {
    this.b += 1;
    new w(this.a).a(new ab(this));
    this.b -= 1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SecureService.class);
    localIntent.setAction(paramString);
    paramContext.startService(localIntent);
  }
  
  private void a(String paramString, Parcelable paramParcelable)
  {
    if (this.e)
    {
      paramString = new Intent(paramString);
      if (paramParcelable != null) {
        paramString.putExtra("data", paramParcelable);
      }
      sendBroadcast(paramString);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, SecureEventReceiver.class);
    localIntent.setAction(paramString);
    if (paramParcelable != null) {
      localIntent.putExtra("data", paramParcelable);
    }
    sendBroadcast(localIntent);
  }
  
  private void a(String paramString, Serializable paramSerializable)
  {
    if (!at.a(this.a, 10002, true)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, SecureEventReceiver.class);
    localIntent.setAction(paramString);
    if (paramSerializable != null) {
      localIntent.putExtra("data", paramSerializable);
    }
    sendBroadcast(localIntent);
  }
  
  private void a(ArrayList<o> paramArrayList, int paramInt)
  {
    o localo = new o();
    localo.a = paramInt;
    localo.c = "1";
    localo.b = ((int)(System.currentTimeMillis() / 1000L));
    paramArrayList.add(localo);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 64).signatures;
      Object localObject = MessageDigest.getInstance("MD5");
      if ((paramContext != null) && (paramContext.length > 0)) {
        ((MessageDigest)localObject).update(paramContext[0].toByteArray());
      }
      paramContext = ((MessageDigest)localObject).digest();
      localObject = new char[16];
      Object tmp54_53 = localObject;
      tmp54_53[0] = 48;
      Object tmp59_54 = tmp54_53;
      tmp59_54[1] = 49;
      Object tmp64_59 = tmp59_54;
      tmp64_59[2] = 50;
      Object tmp69_64 = tmp64_59;
      tmp69_64[3] = 51;
      Object tmp74_69 = tmp69_64;
      tmp74_69[4] = 52;
      Object tmp79_74 = tmp74_69;
      tmp79_74[5] = 53;
      Object tmp84_79 = tmp79_74;
      tmp84_79[6] = 54;
      Object tmp90_84 = tmp84_79;
      tmp90_84[7] = 55;
      Object tmp96_90 = tmp90_84;
      tmp96_90[8] = 56;
      Object tmp102_96 = tmp96_90;
      tmp102_96[9] = 57;
      Object tmp108_102 = tmp102_96;
      tmp108_102[10] = 65;
      Object tmp114_108 = tmp108_102;
      tmp114_108[11] = 66;
      Object tmp120_114 = tmp114_108;
      tmp120_114[12] = 67;
      Object tmp126_120 = tmp120_114;
      tmp126_120[13] = 68;
      Object tmp132_126 = tmp126_120;
      tmp132_126[14] = 69;
      Object tmp138_132 = tmp132_126;
      tmp138_132[15] = 70;
      tmp138_132;
      StringBuilder localStringBuilder = new StringBuilder(paramContext.length * 2);
      int i = 0;
      while (i < paramContext.length)
      {
        localStringBuilder.append(localObject[((paramContext[i] & 0xF0) >>> 4)]);
        localStringBuilder.append(localObject[(paramContext[i] & 0xF)]);
        i += 1;
      }
      if (!"00B1208638DE0FCD3E920886D658DAF6".equalsIgnoreCase(localStringBuilder.toString()))
      {
        boolean bool2 = "7CC749CFC0FB5677E6ABA342EDBDBA5A".equalsIgnoreCase(localStringBuilder.toString());
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private void b()
  {
    this.b += 1;
    x localx = x.a(this.a);
    localx.b();
    this.d = localx.a();
    this.b -= 1;
  }
  
  private void b(String paramString)
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b += 1;
    a("1000024", null);
    Object localObject = new ae(this.a);
    ((ae)localObject).a(new aa(this));
    ((ae)localObject).a(1);
    int i;
    do
    {
      i = ((ae)localObject).a(paramString, false);
    } while (i == -7);
    if (i == 0)
    {
      paramString = ((ae)localObject).b();
      localObject = new Bundle();
      ((Bundle)localObject).putString("key_path", paramString);
      a("1000027", (Parcelable)localObject);
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
      this.a.startActivity((Intent)localObject);
    }
    this.b -= 1;
    this.c = false;
    this.e = false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if ("com.tencent.qqpimsecure".equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    try
    {
      Thread.sleep(500L);
      Process.killProcess(Process.myPid());
      System.exit(0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public static void c(Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.qqpimsecure", "com.tencent.qqpimsecure.service.TMSLiteService");
      paramContext.startService(localIntent);
    }
  }
  
  private void d()
  {
    ah.a(this.a).a(as.b(this.a));
  }
  
  private void e()
  {
    boolean bool1 = a(this.a);
    boolean bool2 = b(this.a);
    ArrayList localArrayList = new ArrayList();
    if (bool1)
    {
      if (!bool2) {
        break label108;
      }
      a(localArrayList, 235002);
    }
    for (;;)
    {
      if ((x.a(this.a).c()) && (bool1) && (!bool2)) {
        c(this.a);
      }
      try
      {
        Thread.sleep(15000L);
        if (b(this.a))
        {
          a(localArrayList, 235006);
          ah.a(this.a).a(localArrayList);
          return;
          label108:
          a(localArrayList, 235003);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          continue;
          a(localArrayList, 235007);
        }
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.f;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = getApplicationContext();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if ((paramIntent == null) || ("1000012".equals(paramIntent.getAction()))) {
      return;
    }
    if (!az.a(getApplicationContext(), "sm_mq"))
    {
      stopSelf();
      c();
      return;
    }
    try
    {
      new Thread(new z(this, paramIntent)).start();
      return;
    }
    finally {}
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.b == 0)
    {
      stopSelf();
      c();
    }
    return super.onUnbind(paramIntent);
  }
  
  public class a
    extends Binder
    implements IControlService
  {
    public a() {}
    
    public void doRemoteTask(String paramString, ICallback paramICallback)
    {
      if (!az.a(SecureService.this.getApplicationContext(), "sm_mq")) {
        return;
      }
      try
      {
        new Thread(new ac(this, paramString, paramICallback)).start();
        return;
      }
      finally {}
    }
    
    public void setIsShowingTips(boolean paramBoolean1, boolean paramBoolean2)
    {
      SecureService.a(SecureService.this, paramBoolean1);
      if (paramBoolean2)
      {
        SecureService.this.stopSelf();
        SecureService.a(SecureService.this);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\securemodule\impl\SecureService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */