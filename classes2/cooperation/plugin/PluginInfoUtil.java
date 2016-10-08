package cooperation.plugin;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterfaceFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import ydw;

public class PluginInfoUtil
{
  public PluginInfoUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  static PluginInfo a(File paramFile)
  {
    return (PluginInfo)PluginBaseInfoHelper.createFromFile(paramFile, PluginInfo.class);
  }
  
  public static PluginInfo a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!PluginUtils.getPluginCfgFile(paramFile, paramString).exists()) {
      return null;
    }
    return a(paramFile);
  }
  
  public static void a(PluginInfo paramPluginInfo, File paramFile)
  {
    try
    {
      paramFile = PluginUtils.getPluginCfgFile(paramFile, paramPluginInfo.mID);
      if ((paramFile.isFile()) && (paramFile.exists()))
      {
        paramFile.delete();
        paramFile.createNewFile();
      }
      a(paramFile, paramPluginInfo);
      return;
    }
    catch (Exception paramPluginInfo) {}
  }
  
  /* Error */
  public static void a(File paramFile)
  {
    // Byte code:
    //   0: new 40	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: ldc 68
    //   7: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 44	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_0
    //   19: invokevirtual 59	java/io/File:delete	()Z
    //   22: pop
    //   23: aconst_null
    //   24: astore_1
    //   25: new 73	java/io/FileOutputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore_0
    //   34: aload_0
    //   35: ldc 77
    //   37: invokevirtual 83	java/lang/String:getBytes	()[B
    //   40: invokevirtual 87	java/io/FileOutputStream:write	([B)V
    //   43: aload_0
    //   44: invokestatic 93	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   47: return
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 93	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   55: return
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: aload_2
    //   60: astore_1
    //   61: aload_0
    //   62: invokestatic 93	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: goto -7 -> 61
    //   71: astore_1
    //   72: goto -21 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramFile	File
    //   24	42	1	localObject1	Object
    //   67	1	1	localObject2	Object
    //   71	1	1	localException	Exception
    //   56	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	34	48	java/lang/Exception
    //   25	34	56	finally
    //   34	43	67	finally
    //   34	43	71	java/lang/Exception
  }
  
  public static void a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = PluginUtils.getPluginCfgFile(paramFile, paramString);
    } while ((!paramString.isFile()) || (!paramString.exists()));
    paramString.delete();
  }
  
  static boolean a(PluginBaseInfo paramPluginBaseInfo, File paramFile)
  {
    if ((!paramFile.exists()) || (!paramFile.isFile())) {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, "isValidPluginFile file not exist");
      }
    }
    do
    {
      do
      {
        return false;
        if ((paramPluginBaseInfo.mLength > 0L) && (paramFile.length() == paramPluginBaseInfo.mLength)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("plugin_tag", 2, "isValidPluginFile lenth invalid:" + paramPluginBaseInfo.mLength + ", " + paramFile.length());
      return false;
      paramFile = PluginStatic.encodeFile(paramFile.getPath());
      if ((paramPluginBaseInfo.mMD5 != null) && (paramPluginBaseInfo.mMD5.equals(paramFile))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("plugin_tag", 2, "isValidPluginFile lenth invalid:" + paramPluginBaseInfo.mMD5 + ", " + paramFile);
    return false;
    return true;
  }
  
  static boolean a(PluginInfo paramPluginInfo, Context paramContext)
  {
    Object localObject = "";
    boolean bool1;
    if (paramPluginInfo.mProcesses != null) {
      if (paramPluginInfo.mProcesses.length == 0) {
        bool1 = false;
      }
    }
    for (;;)
    {
      boolean bool2;
      label86:
      int i;
      if (AppInterfaceFactory.a((String)localObject))
      {
        bool1 = false;
        if ((!bool1) && (QIPCServerHelper.getInstance().isModuleRunning(paramPluginInfo.mID)))
        {
          return true;
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
          if (paramContext == null)
          {
            bool1 = false;
            continue;
          }
          Iterator localIterator = paramContext.iterator();
          bool2 = false;
          paramContext = (Context)localObject;
          localObject = paramContext;
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            continue;
          }
          localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          int j = paramPluginInfo.mProcesses.length;
          i = 0;
          label121:
          if (i >= j) {
            break label172;
          }
          paramContext = paramPluginInfo.mProcesses[i];
          if (!paramContext.equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)localObject).processName)) {}
        }
      }
      label172:
      for (bool1 = true;; bool1 = bool2)
      {
        bool2 = bool1;
        break label86;
        i += 1;
        break label121;
        return bool1;
        break;
      }
      bool1 = false;
    }
  }
  
  public static boolean a(File paramFile)
  {
    return !IOUtil.contentEquals(new File(paramFile, "PluginVersion.ini"), "229354");
  }
  
  /* Error */
  private static boolean a(File paramFile, PluginInfo paramPluginInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_1
    //   5: invokestatic 223	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper$PluginInfoParser:pluginToXML	(Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfo;)Ljava/lang/String;
    //   8: invokevirtual 83	java/lang/String:getBytes	()[B
    //   11: iconst_0
    //   12: invokestatic 229	com/tencent/mobileqq/utils/Base64Util:encode	([BI)[B
    //   15: astore_1
    //   16: new 73	java/io/FileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: astore_0
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 87	java/io/FileOutputStream:write	([B)V
    //   30: iconst_1
    //   31: istore 4
    //   33: iload 4
    //   35: istore_3
    //   36: aload_0
    //   37: ifnull +10 -> 47
    //   40: aload_0
    //   41: invokevirtual 232	java/io/FileOutputStream:close	()V
    //   44: iload 4
    //   46: istore_3
    //   47: iload_3
    //   48: ireturn
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: ifnull -6 -> 47
    //   56: aload_0
    //   57: invokevirtual 232	java/io/FileOutputStream:close	()V
    //   60: iconst_0
    //   61: ireturn
    //   62: astore_0
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_0
    //   66: aload_2
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 232	java/io/FileOutputStream:close	()V
    //   76: aload_0
    //   77: athrow
    //   78: astore_0
    //   79: iconst_1
    //   80: ireturn
    //   81: astore_1
    //   82: goto -6 -> 76
    //   85: astore_2
    //   86: aload_0
    //   87: astore_1
    //   88: aload_2
    //   89: astore_0
    //   90: goto -22 -> 68
    //   93: astore_1
    //   94: goto -42 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramFile	File
    //   0	97	1	paramPluginInfo	PluginInfo
    //   3	64	2	localObject1	Object
    //   85	4	2	localObject2	Object
    //   1	47	3	bool1	boolean
    //   31	14	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	25	49	java/lang/Exception
    //   56	60	62	java/io/IOException
    //   4	25	65	finally
    //   40	44	78	java/io/IOException
    //   72	76	81	java/io/IOException
    //   25	30	85	finally
    //   25	30	93	java/lang/Exception
  }
  
  public static File[] a(File paramFile)
  {
    return paramFile.listFiles(new ydw());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\PluginInfoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */