package com.tencent.qqlive.mediaplayer.sdkupdate;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class a
{
  private static a a = null;
  private static boolean f = false;
  private boolean b = false;
  private Thread c;
  private Context d = null;
  private b e = null;
  
  /* Error */
  public static a a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 23	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   6: ifnonnull +53 -> 59
    //   9: new 2	com/tencent/qqlive/mediaplayer/sdkupdate/a
    //   12: dup
    //   13: invokespecial 37	com/tencent/qqlive/mediaplayer/sdkupdate/a:<init>	()V
    //   16: putstatic 23	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   19: getstatic 23	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   22: astore_1
    //   23: aload_1
    //   24: aload_0
    //   25: putfield 33	com/tencent/qqlive/mediaplayer/sdkupdate/a:d	Landroid/content/Context;
    //   28: aload_1
    //   29: new 39	com/tencent/qqlive/mediaplayer/sdkupdate/b
    //   32: dup
    //   33: aload_1
    //   34: getfield 33	com/tencent/qqlive/mediaplayer/sdkupdate/a:d	Landroid/content/Context;
    //   37: invokespecial 42	com/tencent/qqlive/mediaplayer/sdkupdate/b:<init>	(Landroid/content/Context;)V
    //   40: putfield 35	com/tencent/qqlive/mediaplayer/sdkupdate/a:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/b;
    //   43: aload_1
    //   44: getfield 35	com/tencent/qqlive/mediaplayer/sdkupdate/a:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/b;
    //   47: invokevirtual 45	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	()Z
    //   50: ifeq +18 -> 68
    //   53: iconst_1
    //   54: istore_2
    //   55: iload_2
    //   56: putstatic 25	com/tencent/qqlive/mediaplayer/sdkupdate/a:f	Z
    //   59: getstatic 23	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: areturn
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -15 -> 55
    //   73: astore_0
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_0
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramContext	Context
    //   22	22	1	locala	a
    //   54	16	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	53	73	finally
    //   55	59	73	finally
    //   59	63	73	finally
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(TVK_SDKMgr.InstallListener paramInstallListener)
  {
    this.e.a(paramInstallListener);
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.b;
        if (bool) {
          return;
        }
        if (!f) {
          this.e.f();
        }
        if ((paramBoolean) && (!UpdateUtils.a(this.d)))
        {
          UpdateUtils.a(UpdateUtils.LogType.c, "", "MediaPlayerMgr", "start no wifi, cancel");
          this.e.f();
          continue;
        }
        this.c = new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              SDKLocalConfig localSDKLocalConfig = a.a(a.this).a(false);
              if (localSDKLocalConfig == null) {
                return;
              }
              a.a(a.this).a(localSDKLocalConfig, false);
              return;
            }
            catch (Exception localException)
            {
              UpdateUtils.a(UpdateUtils.LogType.e, "", "MediaPlayerMgr", "startWithForceAndSilent, exception: " + localException.toString());
              localException.printStackTrace();
              return;
            }
            finally
            {
              a.a(a.this).f();
              a.a(a.this, false);
            }
          }
        });
      }
      finally {}
      if (this.c != null)
      {
        this.b = true;
        this.c.setName("TencentVideoKit");
        this.c.start();
      }
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/tencent/qqlive/mediaplayer/sdkupdate/a:b	Z
    //   6: ifne +11 -> 17
    //   9: getstatic 25	com/tencent/qqlive/mediaplayer/sdkupdate/a:f	Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: new 77	java/lang/Thread
    //   24: dup
    //   25: new 8	com/tencent/qqlive/mediaplayer/sdkupdate/a$2
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 95	com/tencent/qqlive/mediaplayer/sdkupdate/a$2:<init>	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;)V
    //   33: invokespecial 83	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   36: putfield 85	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   39: aload_0
    //   40: getfield 85	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   43: ifnull -26 -> 17
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 31	com/tencent/qqlive/mediaplayer/sdkupdate/a:b	Z
    //   51: aload_0
    //   52: getfield 85	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   55: invokevirtual 94	java/lang/Thread:start	()V
    //   58: goto -41 -> 17
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	a
    //   61	4	1	localObject	Object
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	61	finally
    //   20	58	61	finally
  }
  
  public boolean c()
  {
    if (f) {
      return this.e.c();
    }
    return false;
  }
  
  public String d()
  {
    if (f) {
      return this.e.g();
    }
    return null;
  }
  
  public String e()
  {
    if (f) {
      return this.e.h();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\qqlive\mediaplayer\sdkupdate\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */