package cooperation.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.startup.step.UpdatePluginVersion;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import ydx;

public class PluginInstaller
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public PluginInstaller(Context paramContext, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_CooperationPluginBuiltinPluginManager = BuiltinPluginManager.a(this.jdField_a_of_type_AndroidContentContext);
    a();
  }
  
  static File a(Context paramContext)
  {
    return PluginUtils.getPluginInstallDir(paramContext);
  }
  
  private void a(PluginInfo paramPluginInfo)
  {
    PluginInfoUtil.a(paramPluginInfo, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void a(String paramString)
  {
    PluginInfoUtil.a(paramString, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "verifyDownloadPath." + this.jdField_a_of_type_JavaLangString + ", " + bool);
      }
      return bool;
      if (new File(this.jdField_a_of_type_JavaLangString).exists()) {
        bool = true;
      }
    }
  }
  
  private boolean a(PluginInfo paramPluginInfo)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (paramPluginInfo != null)
    {
      bool2 = bool1;
      if (paramPluginInfo.mInstalledPath != null)
      {
        File localFile = new File(paramPluginInfo.mInstalledPath);
        bool1 = bool3;
        if (localFile != null)
        {
          bool1 = bool3;
          if (localFile.exists())
          {
            bool1 = bool3;
            if (localFile.isFile())
            {
              if (!PluginInfoUtil.a(paramPluginInfo, localFile)) {
                break label136;
              }
              bool1 = true;
              paramPluginInfo.mState = 4;
              paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
            }
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "verifyInstalledPlugin :" + paramPluginInfo.mID + "," + bool1);
        bool2 = bool1;
      }
      return bool2;
      label136:
      d(paramPluginInfo.mID);
      paramPluginInfo.mState = 0;
      bool1 = bool3;
    }
  }
  
  private void b(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    String str = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doSetupPlugin." + str);
    }
    if (PluginInfoUtil.a(paramPluginInfo, this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str);
      }
      return;
    }
    if (!c(str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      a(str, paramOnPluginSetupListener);
      return;
    }
    a(paramPluginInfo, paramOnPluginSetupListener);
  }
  
  private boolean c(String paramString)
  {
    if (!a()) {}
    do
    {
      return false;
      paramString = new File(this.jdField_a_of_type_JavaLangString).list(new ydx(this, paramString));
    } while ((paramString == null) || (paramString.length <= 0));
    return true;
  }
  
  private boolean d(String paramString)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localPluginInfo != null) && (PluginInfoUtil.a(localPluginInfo, this.jdField_a_of_type_AndroidContentContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    a(paramString);
    if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
    {
      paramString = new File(localPluginInfo.mInstalledPath);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
    return true;
  }
  
  public PluginInfo a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    return (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    File localFile1 = a(this.jdField_a_of_type_AndroidContentContext);
    boolean bool = PluginInfoUtil.a(localFile1);
    File[] arrayOfFile = PluginInfoUtil.a(localFile1);
    int i;
    File localFile2;
    Object localObject;
    if (arrayOfFile != null)
    {
      int k = arrayOfFile.length;
      i = 0;
      if (i < k)
      {
        localFile2 = arrayOfFile[i];
        if (localFile2.isFile())
        {
          if (!bool) {
            break label144;
          }
          localObject = UpdatePluginVersion.a;
          int m = localObject.length;
          j = 0;
          label67:
          if (j >= m) {
            break label242;
          }
          String str = localObject[j];
          if (!localFile2.getName().equals(str + ".cfg")) {
            break label135;
          }
          d(str);
        }
      }
    }
    label135:
    label144:
    label242:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {}
      for (;;)
      {
        i += 1;
        break;
        j += 1;
        break label67;
        localObject = PluginInfoUtil.a(localFile2);
        if (localObject != null)
        {
          if (a((PluginInfo)localObject)) {
            this.jdField_a_of_type_JavaUtilHashMap.put(((PluginInfo)localObject).mID, localObject);
          }
        }
        else {
          localFile2.delete();
        }
      }
      if (bool) {
        PluginInfoUtil.a(localFile1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "load installed plugin info. size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(66816, paramPluginInfo).sendToTarget();
  }
  
  public boolean a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    if (paramPluginInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installDownLoadPlugin. info null.");
      }
      throw new NullPointerException("specified PluginInfo is null");
    }
    String str1 = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installDownLoadPlugin." + str1);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str1);
      }
      return false;
    }
    File localFile = new File(PluginUtils.getPluginInstallDir(this.jdField_a_of_type_AndroidContentContext), str1);
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
    int i;
    if ((localObject != null) && (!paramPluginInfo.mMD5.equals(((PluginInfo)localObject).mMD5)))
    {
      i = 1;
      label139:
      if (!localFile.exists()) {
        break label503;
      }
    }
    label503:
    for (boolean bool = a((PluginInfo)localObject);; bool = false)
    {
      if ((bool) && (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "plugin installed.");
        }
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
        i = 0;
        break label139;
      }
      if (!a())
      {
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      localObject = new File(new File(this.jdField_a_of_type_JavaLangString), str1);
      if (!PluginInfoUtil.a(paramPluginInfo, (File)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. download file invalid.");
        }
        ((File)localObject).delete();
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str1);
      }
      paramPluginInfo.mState = 3;
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
      FileUtils.a((File)localObject, localFile);
      if (!PluginInfoUtil.a(paramPluginInfo, localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. copy file invalid.");
        }
        localFile.delete();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, str1);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
        return false;
      }
      try
      {
        String str2 = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, str1).getCanonicalPath();
        PluginUtils.extractLibs(localFile.getCanonicalPath(), str2);
        paramPluginInfo.mState = 4;
        paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
        a(paramPluginInfo);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install finish.");
        }
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(true, str1);
        }
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localFile.delete();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, str1);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
        return false;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localPluginInfo != null) && (localPluginInfo.mState == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "isPluginInstalled installed = " + bool);
      }
      return bool;
      b(paramString);
    }
  }
  
  /* Error */
  public boolean a(String paramString, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    // Byte code:
    //   0: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 87
    //   8: iconst_2
    //   9: new 89	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 309
    //   19: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 193	cooperation/plugin/PluginInstaller:jdField_a_of_type_Boolean	Z
    //   36: ifne +16 -> 52
    //   39: aload_2
    //   40: ifnull +10 -> 50
    //   43: aload_2
    //   44: aload_1
    //   45: invokeinterface 158 2 0
    //   50: iconst_0
    //   51: ireturn
    //   52: aload_0
    //   53: getfield 52	cooperation/plugin/PluginInstaller:jdField_a_of_type_CooperationPluginBuiltinPluginManager	Lcooperation/plugin/BuiltinPluginManager;
    //   56: aload_1
    //   57: invokevirtual 311	cooperation/plugin/BuiltinPluginManager:a	(Ljava/lang/String;)Z
    //   60: ifne +31 -> 91
    //   63: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +12 -> 78
    //   69: ldc 87
    //   71: iconst_2
    //   72: ldc_w 313
    //   75: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_2
    //   79: ifnull -29 -> 50
    //   82: aload_2
    //   83: aload_1
    //   84: invokeinterface 158 2 0
    //   89: iconst_0
    //   90: ireturn
    //   91: new 111	java/io/File
    //   94: dup
    //   95: aload_0
    //   96: getfield 25	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   99: invokestatic 61	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginInstallDir	(Landroid/content/Context;)Ljava/io/File;
    //   102: aload_1
    //   103: invokespecial 265	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   106: astore 4
    //   108: aload_0
    //   109: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   112: aload_1
    //   113: invokevirtual 182	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 119	cooperation/plugin/PluginInfo
    //   119: astore 7
    //   121: aload_0
    //   122: getfield 52	cooperation/plugin/PluginInstaller:jdField_a_of_type_CooperationPluginBuiltinPluginManager	Lcooperation/plugin/BuiltinPluginManager;
    //   125: aload_1
    //   126: invokevirtual 315	cooperation/plugin/BuiltinPluginManager:a	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   129: astore 5
    //   131: aload 5
    //   133: ifnonnull +26 -> 159
    //   136: ldc 87
    //   138: iconst_1
    //   139: ldc_w 317
    //   142: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_2
    //   146: ifnull -96 -> 50
    //   149: aload_2
    //   150: iconst_0
    //   151: aload_1
    //   152: invokeinterface 285 3 0
    //   157: iconst_0
    //   158: ireturn
    //   159: aload 5
    //   161: ifnull +82 -> 243
    //   164: aload 7
    //   166: ifnull +77 -> 243
    //   169: aload 5
    //   171: getfield 268	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   174: aload 7
    //   176: getfield 268	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   179: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifne +61 -> 243
    //   185: iconst_1
    //   186: istore 10
    //   188: aload 4
    //   190: invokevirtual 116	java/io/File:exists	()Z
    //   193: ifeq +487 -> 680
    //   196: aload_0
    //   197: aload 7
    //   199: invokespecial 220	cooperation/plugin/PluginInstaller:a	(Lcooperation/plugin/PluginInfo;)Z
    //   202: istore 11
    //   204: iload 11
    //   206: ifeq +43 -> 249
    //   209: iload 10
    //   211: ifne +38 -> 249
    //   214: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +12 -> 229
    //   220: ldc 87
    //   222: iconst_2
    //   223: ldc_w 319
    //   226: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_2
    //   230: ifnull +11 -> 241
    //   233: aload_2
    //   234: iconst_1
    //   235: aload_1
    //   236: invokeinterface 285 3 0
    //   241: iconst_1
    //   242: ireturn
    //   243: iconst_0
    //   244: istore 10
    //   246: goto -58 -> 188
    //   249: aload_2
    //   250: ifnull +10 -> 260
    //   253: aload_2
    //   254: aload_1
    //   255: invokeinterface 275 2 0
    //   260: aload 5
    //   262: invokevirtual 322	cooperation/plugin/PluginInfo:a	()Lcooperation/plugin/PluginInfo;
    //   265: astore 8
    //   267: aload 8
    //   269: iconst_3
    //   270: putfield 132	cooperation/plugin/PluginInfo:mState	I
    //   273: aload_0
    //   274: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   277: aload_1
    //   278: aload 8
    //   280: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: ldc_w 324
    //   287: astore 6
    //   289: aload_1
    //   290: iconst_0
    //   291: aload_1
    //   292: ldc_w 326
    //   295: invokevirtual 330	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   298: invokevirtual 334	java/lang/String:substring	(II)Ljava/lang/String;
    //   301: astore 9
    //   303: aload_0
    //   304: getfield 25	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   307: aload 9
    //   309: invokestatic 340	com/tencent/commonsdk/soload/SoLoadCore:getReleasedSoFilePath	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   312: astore 5
    //   314: aload 5
    //   316: ifnonnull +361 -> 677
    //   319: aload_0
    //   320: getfield 25	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   323: aload 9
    //   325: invokestatic 343	com/tencent/commonsdk/soload/SoLoadCore:releaseSo	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   328: astore 5
    //   330: aload 5
    //   332: ifnull +334 -> 666
    //   335: new 111	java/io/File
    //   338: dup
    //   339: aload 5
    //   341: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   344: astore 5
    //   346: aload 8
    //   348: getfield 268	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   351: astore 4
    //   353: aload 8
    //   355: getfield 268	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   358: astore 6
    //   360: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +41 -> 404
    //   366: ldc 87
    //   368: iconst_2
    //   369: new 89	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 345
    //   379: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 6
    //   384: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 347
    //   390: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload 4
    //   395: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: aload 4
    //   406: aload 6
    //   408: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   411: istore 11
    //   413: iconst_0
    //   414: ifne +222 -> 636
    //   417: iload 11
    //   419: ifeq +217 -> 636
    //   422: aload_0
    //   423: getfield 25	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   426: aload_1
    //   427: invokestatic 289	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   430: invokevirtual 292	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   433: astore 6
    //   435: aload 5
    //   437: invokevirtual 292	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   440: aload 6
    //   442: invokestatic 296	com/tencent/mobileqq/pluginsdk/PluginUtils:extractLibs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   445: pop
    //   446: aload 8
    //   448: aload 5
    //   450: invokevirtual 351	java/io/File:length	()J
    //   453: putfield 355	cooperation/plugin/PluginInfo:mLength	J
    //   456: aload 8
    //   458: iconst_4
    //   459: putfield 132	cooperation/plugin/PluginInfo:mState	I
    //   462: aload 8
    //   464: aload 5
    //   466: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   469: putfield 122	cooperation/plugin/PluginInfo:mInstalledPath	Ljava/lang/String;
    //   472: aload 8
    //   474: aload 4
    //   476: putfield 268	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   479: aload_0
    //   480: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   483: aload_1
    //   484: aload 8
    //   486: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   489: pop
    //   490: aload_0
    //   491: aload 8
    //   493: invokespecial 298	cooperation/plugin/PluginInstaller:a	(Lcooperation/plugin/PluginInfo;)V
    //   496: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +12 -> 511
    //   502: ldc 87
    //   504: iconst_2
    //   505: ldc_w 357
    //   508: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: aload_2
    //   512: ifnull +11 -> 523
    //   515: aload_2
    //   516: iconst_1
    //   517: aload_1
    //   518: invokeinterface 285 3 0
    //   523: iconst_1
    //   524: ireturn
    //   525: astore 5
    //   527: aload 4
    //   529: astore 5
    //   531: aload_0
    //   532: getfield 25	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   535: aload_1
    //   536: aload 5
    //   538: invokestatic 361	com/tencent/mobileqq/pluginsdk/PluginUtils:extractPluginAndGetMd5Code	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Ljava/lang/String;
    //   541: astore 4
    //   543: goto -190 -> 353
    //   546: astore 4
    //   548: invokestatic 364	com/tencent/mobileqq/utils/FileUtils:a	()F
    //   551: fstore_3
    //   552: ldc 87
    //   554: iconst_1
    //   555: new 89	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 366
    //   565: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload 5
    //   570: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   573: ldc_w 371
    //   576: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: fload_3
    //   580: invokevirtual 374	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   583: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: aload 4
    //   588: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   591: aload 6
    //   593: astore 4
    //   595: goto -242 -> 353
    //   598: astore 4
    //   600: aload 4
    //   602: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   605: aload 5
    //   607: invokevirtual 190	java/io/File:delete	()Z
    //   610: pop
    //   611: aload_2
    //   612: ifnull +11 -> 623
    //   615: aload_2
    //   616: iconst_0
    //   617: aload_1
    //   618: invokeinterface 285 3 0
    //   623: aload_0
    //   624: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   627: aload_1
    //   628: aload 7
    //   630: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   633: pop
    //   634: iconst_0
    //   635: ireturn
    //   636: aload_2
    //   637: ifnull +11 -> 648
    //   640: aload_2
    //   641: iconst_0
    //   642: aload_1
    //   643: invokeinterface 285 3 0
    //   648: aload_0
    //   649: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   652: aload_1
    //   653: aload 7
    //   655: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   658: pop
    //   659: iconst_0
    //   660: ireturn
    //   661: astore 4
    //   663: goto -132 -> 531
    //   666: aload 4
    //   668: astore 5
    //   670: aload 6
    //   672: astore 4
    //   674: goto -321 -> 353
    //   677: goto -347 -> 330
    //   680: iconst_0
    //   681: istore 11
    //   683: goto -479 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	this	PluginInstaller
    //   0	686	1	paramString	String
    //   0	686	2	paramOnPluginSetupListener	PluginInstaller.OnPluginSetupListener
    //   551	29	3	f	float
    //   106	436	4	localObject1	Object
    //   546	41	4	localException1	Exception
    //   593	1	4	localObject2	Object
    //   598	3	4	localException2	Exception
    //   661	6	4	localException3	Exception
    //   672	1	4	localObject3	Object
    //   129	336	5	localObject4	Object
    //   525	1	5	localException4	Exception
    //   529	140	5	localObject5	Object
    //   287	384	6	str1	String
    //   119	535	7	localPluginInfo1	PluginInfo
    //   265	227	8	localPluginInfo2	PluginInfo
    //   301	23	9	str2	String
    //   186	59	10	i	int
    //   202	480	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   289	314	525	java/lang/Exception
    //   319	330	525	java/lang/Exception
    //   335	346	525	java/lang/Exception
    //   531	543	546	java/lang/Exception
    //   422	446	598	java/lang/Exception
    //   346	353	661	java/lang/Exception
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "uninstallPlugin." + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return d(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    paramMessage = (Pair)paramMessage.obj;
    b((PluginInfo)paramMessage.first, (PluginInstaller.OnPluginSetupListener)paramMessage.second);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\PluginInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */