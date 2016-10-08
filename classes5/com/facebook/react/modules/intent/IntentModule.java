package com.facebook.react.modules.intent;

import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class IntentModule
  extends ReactContextBaseJavaModule
{
  public IntentModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  /* Error */
  @ReactMethod
  public void canOpenURL(String paramString, com.facebook.react.bridge.Callback paramCallback)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +10 -> 14
    //   7: aload_1
    //   8: invokevirtual 20	java/lang/String:isEmpty	()Z
    //   11: ifeq +30 -> 41
    //   14: new 22	com/facebook/react/bridge/JSApplicationIllegalArgumentException
    //   17: dup
    //   18: new 24	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   25: ldc 29
    //   27: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 40	com/facebook/react/bridge/JSApplicationIllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    //   41: new 42	android/content/Intent
    //   44: dup
    //   45: ldc 44
    //   47: aload_1
    //   48: invokestatic 50	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   51: invokespecial 53	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   54: astore_3
    //   55: aload_3
    //   56: ldc 54
    //   58: invokevirtual 58	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   61: pop
    //   62: aload_3
    //   63: aload_0
    //   64: invokevirtual 62	com/facebook/react/modules/intent/IntentModule:getReactApplicationContext	()Lcom/facebook/react/bridge/ReactApplicationContext;
    //   67: invokevirtual 68	com/facebook/react/bridge/ReactApplicationContext:getPackageManager	()Landroid/content/pm/PackageManager;
    //   70: invokevirtual 72	android/content/Intent:resolveActivity	(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;
    //   73: ifnull +22 -> 95
    //   76: aload_2
    //   77: iconst_1
    //   78: anewarray 74	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: iload 4
    //   85: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   88: aastore
    //   89: invokeinterface 86 2 0
    //   94: return
    //   95: iconst_0
    //   96: istore 4
    //   98: goto -22 -> 76
    //   101: astore_2
    //   102: new 22	com/facebook/react/bridge/JSApplicationIllegalArgumentException
    //   105: dup
    //   106: new 24	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   113: ldc 88
    //   115: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 90
    //   124: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_2
    //   128: invokevirtual 93	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   131: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 40	com/facebook/react/bridge/JSApplicationIllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	IntentModule
    //   0	141	1	paramString	String
    //   0	141	2	paramCallback	com.facebook.react.bridge.Callback
    //   54	9	3	localIntent	Intent
    //   1	96	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   41	76	101	java/lang/Exception
    //   76	94	101	java/lang/Exception
  }
  
  public String getName()
  {
    return "IntentAndroid";
  }
  
  @ReactMethod
  public void openURL(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      throw new JSApplicationIllegalArgumentException("Invalid URL: " + paramString);
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      localIntent.addFlags(268435456);
      getReactApplicationContext().startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      throw new JSApplicationIllegalArgumentException("Could not open URL '" + paramString + "': " + localException.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\intent\IntentModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */