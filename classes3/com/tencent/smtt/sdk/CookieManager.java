package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.ReflectionUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CookieManager
{
  private static CookieManager mInstance;
  
  public static CookieManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new CookieManager();
      }
      CookieManager localCookieManager = mInstance;
      return localCookieManager;
    }
    finally {}
  }
  
  public boolean acceptCookie()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().cookieManager_acceptCookie();
    }
    return android.webkit.CookieManager.getInstance().acceptCookie();
  }
  
  /* Error */
  public boolean acceptThirdPartyCookies(WebView paramWebView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 23	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +70 -> 77
    //   10: aload_2
    //   11: invokevirtual 26	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   14: ifeq +63 -> 77
    //   17: aload_2
    //   18: invokevirtual 30	com/tencent/smtt/sdk/X5CoreEngine:wizard	()Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   21: invokevirtual 48	com/tencent/smtt/sdk/X5CoreWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_2
    //   25: aload_1
    //   26: invokevirtual 54	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   29: astore_1
    //   30: aload_2
    //   31: ldc 56
    //   33: ldc 58
    //   35: iconst_1
    //   36: anewarray 60	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 4
    //   43: aastore
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: invokevirtual 66	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +15 -> 72
    //   60: aload_1
    //   61: checkcast 68	java/lang/Boolean
    //   64: invokevirtual 71	java/lang/Boolean:booleanValue	()Z
    //   67: istore_3
    //   68: aload_0
    //   69: monitorexit
    //   70: iload_3
    //   71: ireturn
    //   72: iconst_1
    //   73: istore_3
    //   74: goto -6 -> 68
    //   77: getstatic 77	android/os/Build$VERSION:SDK_INT	I
    //   80: bipush 21
    //   82: if_icmpge +8 -> 90
    //   85: iconst_1
    //   86: istore_3
    //   87: goto -19 -> 68
    //   90: invokestatic 40	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   93: astore_2
    //   94: aload_1
    //   95: invokevirtual 54	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_2
    //   100: ldc 78
    //   102: iconst_1
    //   103: anewarray 60	java/lang/Class
    //   106: dup
    //   107: iconst_0
    //   108: ldc 80
    //   110: aastore
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_1
    //   118: aastore
    //   119: invokestatic 86	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +14 -> 138
    //   127: aload_1
    //   128: checkcast 68	java/lang/Boolean
    //   131: invokevirtual 71	java/lang/Boolean:booleanValue	()Z
    //   134: istore_3
    //   135: goto -67 -> 68
    //   138: iconst_0
    //   139: istore_3
    //   140: goto -72 -> 68
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	CookieManager
    //   0	148	1	paramWebView	WebView
    //   5	95	2	localObject	Object
    //   67	73	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	6	143	finally
    //   10	56	143	finally
    //   60	68	143	finally
    //   77	85	143	finally
    //   90	123	143	finally
    //   127	135	143	finally
  }
  
  public void flush()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
  }
  
  public String getCookie(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().getCookie(paramString);
    }
    return android.webkit.CookieManager.getInstance().getCookie(paramString);
  }
  
  public boolean hasCookies()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().cookieManager_hasCookies();
    }
    return android.webkit.CookieManager.getInstance().hasCookies();
  }
  
  public void removeAllCookie()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().cookieManager_removeAllCookie();
      return;
    }
    android.webkit.CookieManager.getInstance().removeAllCookie();
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void removeExpiredCookie()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeExpiredCookie();
  }
  
  public void removeSessionCookie()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeSessionCookie();
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  /* Error */
  public void setAcceptCookie(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 23	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +49 -> 56
    //   10: aload_2
    //   11: invokevirtual 26	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   14: ifeq +42 -> 56
    //   17: aload_2
    //   18: invokevirtual 30	com/tencent/smtt/sdk/X5CoreEngine:wizard	()Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   21: invokevirtual 48	com/tencent/smtt/sdk/X5CoreWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: ldc 56
    //   26: ldc -122
    //   28: iconst_1
    //   29: anewarray 60	java/lang/Class
    //   32: dup
    //   33: iconst_0
    //   34: getstatic 138	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   37: aastore
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: iload_1
    //   45: invokestatic 142	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokevirtual 66	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: invokestatic 40	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   59: iload_1
    //   60: invokevirtual 144	android/webkit/CookieManager:setAcceptCookie	(Z)V
    //   63: goto -10 -> 53
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	CookieManager
    //   0	71	1	paramBoolean	boolean
    //   5	13	2	localX5CoreEngine	X5CoreEngine
    //   66	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	66	finally
    //   10	53	66	finally
    //   56	63	66	finally
  }
  
  /* Error */
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 23	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +69 -> 76
    //   10: aload_3
    //   11: invokevirtual 26	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   14: ifeq +62 -> 76
    //   17: aload_3
    //   18: invokevirtual 30	com/tencent/smtt/sdk/X5CoreEngine:wizard	()Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   21: invokevirtual 48	com/tencent/smtt/sdk/X5CoreWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_3
    //   25: getstatic 138	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   28: astore 4
    //   30: aload_1
    //   31: invokevirtual 54	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   34: astore_1
    //   35: aload_3
    //   36: ldc 56
    //   38: ldc -108
    //   40: iconst_2
    //   41: anewarray 60	java/lang/Class
    //   44: dup
    //   45: iconst_0
    //   46: ldc 4
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload 4
    //   53: aastore
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_1
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: iload_2
    //   65: invokestatic 142	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   68: aastore
    //   69: invokevirtual 66	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: getstatic 77	android/os/Build$VERSION:SDK_INT	I
    //   79: bipush 21
    //   81: if_icmplt -8 -> 73
    //   84: invokestatic 40	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   87: astore_3
    //   88: getstatic 138	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   91: astore 4
    //   93: aload_1
    //   94: invokevirtual 54	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   97: astore_1
    //   98: aload_3
    //   99: ldc -107
    //   101: iconst_2
    //   102: anewarray 60	java/lang/Class
    //   105: dup
    //   106: iconst_0
    //   107: ldc 80
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload 4
    //   114: aastore
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_1
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: iload_2
    //   126: invokestatic 142	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   129: aastore
    //   130: invokestatic 86	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   133: pop
    //   134: goto -61 -> 73
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	CookieManager
    //   0	142	1	paramWebView	WebView
    //   0	142	2	paramBoolean	boolean
    //   5	94	3	localObject	Object
    //   28	85	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   2	6	137	finally
    //   10	73	137	finally
    //   76	134	137	finally
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
      return;
    }
    android.webkit.CookieManager.getInstance().setCookie(paramString1, paramString2);
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(android.webkit.CookieManager.getInstance(), "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
  }
  
  public void setCookies(Map<String, String[]> paramMap)
  {
    Object localObject = X5CoreEngine.getInstance();
    if ((localObject != null) && (((X5CoreEngine)localObject).isX5Core())) {}
    for (boolean bool = ((X5CoreEngine)localObject).wizard().cookieManager_setCookies(paramMap);; bool = false)
    {
      if (!bool)
      {
        localObject = paramMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          String[] arrayOfString = (String[])paramMap.get(str);
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            setCookie(str, arrayOfString[i]);
            i += 1;
          }
        }
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\CookieManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */