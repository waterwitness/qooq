package com.tencent.mobileqq.config;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.BaseConf;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import protocol.KQQConfig.GetResourceRespInfoV2;
import raf;
import rag;
import rah;

public class ConfigManager
  implements CommandListener, IHttpCommunicatorListener
{
  public static final byte a = 1;
  public static final int a = 1;
  public static final String a = "CONFIG_MSG";
  public static final byte[] a;
  public static final byte b = 2;
  private static final int b = 30;
  public static final String b = "CONFIG_TITLE";
  private static int c = 1;
  public static final String c = "http://activeqq.3g.qq.com/activeQQ/upgrade.jsp";
  public static final String d = "http://kiss.3g.qq.com/activeQQ/mq/5?g_t=2&";
  public static final String e = "http://kiss.3g.qq.com/activeQQ/mq/4?";
  public static final String f = "qq_config.dat";
  private static final String h = "http://conf.3g.qq.com/newConf/n";
  private static final String i = "POST";
  public Command a;
  private File jdField_a_of_type_JavaIoFile;
  private Timer jdField_a_of_type_JavaUtilTimer;
  public rag a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  public Command b;
  String g;
  private String j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfByte = new byte[] { -16, 68, 31, 95, -12, 45, -91, -113, -36, -9, -108, -102, -70, 98, -44, 17 };
  }
  
  public ConfigManager(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Rag = new rag(this);
    String str = paramContext.getFilesDir().getAbsolutePath() + "/" + paramString;
    File localFile = new File(str);
    if (localFile != null) {}
    try
    {
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.g = (paramContext.getFilesDir().getAbsolutePath() + "/" + paramString + "/" + "qq_config.dat");
    if (QLog.isDevelopLevel()) {
      QLog.i("SPLASH_ConfigServlet", 4, "savePointFilePath == " + this.g);
    }
    this.jdField_a_of_type_JavaIoFile = new File(str, "qq_config.dat");
    try
    {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {
        this.jdField_a_of_type_JavaIoFile.createNewFile();
      }
      this.jdField_a_of_type_JavaUtilTimer = ThreadManager.a();
      this.j = paramString;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static final int a()
  {
    int k = c;
    c = k + 1;
    return k;
  }
  
  public static ResourcePluginInfo a(EntityManager paramEntityManager, boolean paramBoolean, GetResourceRespInfoV2 paramGetResourceRespInfoV2)
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = paramGetResourceRespInfoV2.strPkgName;
    localResourcePluginInfo.strResName = paramGetResourceRespInfoV2.strResName;
    Object localObject;
    String str;
    if (paramBoolean)
    {
      localObject = paramGetResourceRespInfoV2.strResURL_big;
      localResourcePluginInfo.strResURL = ((String)localObject);
      localResourcePluginInfo.uiCurVer = paramGetResourceRespInfoV2.uiNewVer;
      localResourcePluginInfo.sLanType = paramGetResourceRespInfoV2.sLanType;
      localResourcePluginInfo.sResSubType = paramGetResourceRespInfoV2.sResSubType;
      localObject = ConfigParser.a(paramGetResourceRespInfoV2.strResConf);
      if (localObject == null) {
        break label303;
      }
      localResourcePluginInfo.strGotoUrl = ((String)((HashMap)localObject).get("pluginEntranceUrl"));
      str = (String)((HashMap)localObject).get("newswitch");
      if (str == null) {}
    }
    for (;;)
    {
      try
      {
        if ((byte)Integer.parseInt(str) == 0)
        {
          localResourcePluginInfo.isNew = 1;
          str = (String)((HashMap)localObject).get("pluginType");
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localResourcePluginInfo.lebaSearchResultType = Integer.parseInt(str);
          localResourcePluginInfo.pluginSetTips = ((String)((HashMap)localObject).get("pluginSetTips"));
          localResourcePluginInfo.pluginBg = ((String)((HashMap)localObject).get("bgcolor"));
          localResourcePluginInfo.strNewPluginDesc = paramGetResourceRespInfoV2.strNewPluginDesc;
          localResourcePluginInfo.strNewPluginURL = paramGetResourceRespInfoV2.strNewPluginURL;
          localResourcePluginInfo.sPriority = paramGetResourceRespInfoV2.sPriority;
          localResourcePluginInfo.strResDesc = paramGetResourceRespInfoV2.strResDesc;
          localResourcePluginInfo.cCanChangeState = paramGetResourceRespInfoV2.cCanChangeState;
          localResourcePluginInfo.cDefaultState = paramGetResourceRespInfoV2.cDefaultState;
          localResourcePluginInfo.uiResId = paramGetResourceRespInfoV2.uiResId;
          if (localResourcePluginInfo.cDefaultState != 0) {
            break label340;
          }
          localResourcePluginInfo.cLocalState = 1;
          localResourcePluginInfo.iPluginType = paramGetResourceRespInfoV2.iPluginType;
          ResourcePluginInfo.persistOrReplace(paramEntityManager, localResourcePluginInfo);
          return localResourcePluginInfo;
          localObject = paramGetResourceRespInfoV2.strResURL_small;
          break;
          localResourcePluginInfo.isNew = 0;
          continue;
          localException1 = localException1;
        }
        catch (Exception localException2)
        {
          localResourcePluginInfo.lebaSearchResultType = -1;
          continue;
        }
      }
      label303:
      localResourcePluginInfo.strGotoUrl = "";
      localResourcePluginInfo.isNew = 0;
      localResourcePluginInfo.lebaSearchResultType = -1;
      localResourcePluginInfo.pluginSetTips = "";
      localResourcePluginInfo.pluginBg = null;
      continue;
      label340:
      if (localResourcePluginInfo.cDefaultState == 1) {
        localResourcePluginInfo.cLocalState = 0;
      }
    }
  }
  
  static String a(String paramString, int paramInt)
  {
    if ((paramInt <= 0) || (paramString.indexOf("g_q=") != -1)) {
      return paramString;
    }
    if (paramString.indexOf('?') > 0)
    {
      if (paramString.endsWith("g_q=")) {
        return paramString + paramInt;
      }
      return paramString + "&g_q=" + paramInt;
    }
    return paramString + "?g_q=" + paramInt;
  }
  
  private void a(BaseConf paramBaseConf, DataInputStream paramDataInputStream)
  {
    paramBaseConf.a(paramDataInputStream);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iconst_0
    //   7: istore 7
    //   9: aload_0
    //   10: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   13: ifnull +372 -> 385
    //   16: aload_0
    //   17: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   20: invokevirtual 122	java/io/File:exists	()Z
    //   23: ifeq +362 -> 385
    //   26: aload_0
    //   27: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   30: invokevirtual 316	java/io/File:canRead	()Z
    //   33: ifeq +352 -> 385
    //   36: aload_0
    //   37: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   40: invokevirtual 320	java/io/File:length	()J
    //   43: lconst_0
    //   44: lcmp
    //   45: ifle +340 -> 385
    //   48: new 322	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   56: invokespecial 325	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore_1
    //   60: new 327	java/io/BufferedInputStream
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 330	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: astore_3
    //   69: aload_1
    //   70: astore_2
    //   71: aload_3
    //   72: astore_1
    //   73: aload 4
    //   75: astore_3
    //   76: aload_1
    //   77: ifnull +99 -> 176
    //   80: aload 4
    //   82: astore_3
    //   83: aload_1
    //   84: invokevirtual 333	java/io/BufferedInputStream:available	()I
    //   87: ifle +89 -> 176
    //   90: new 335	java/io/DataInputStream
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 336	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   98: astore 4
    //   100: iconst_0
    //   101: istore 6
    //   103: iload 6
    //   105: getstatic 341	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   108: arraylength
    //   109: if_icmpge +64 -> 173
    //   112: getstatic 341	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   115: iload 6
    //   117: aaload
    //   118: astore_3
    //   119: aload_0
    //   120: aload_3
    //   121: aload 4
    //   123: invokespecial 343	com/tencent/mobileqq/config/ConfigManager:a	(Lcom/tencent/mobileqq/config/struct/BaseConf;Ljava/io/DataInputStream;)V
    //   126: aload_3
    //   127: getfield 346	com/tencent/mobileqq/config/struct/BaseConf:a_	B
    //   130: iconst_1
    //   131: if_icmpeq +10 -> 141
    //   134: aload_3
    //   135: getfield 346	com/tencent/mobileqq/config/struct/BaseConf:a_	B
    //   138: ifne +14 -> 152
    //   141: aload_3
    //   142: invokevirtual 348	com/tencent/mobileqq/config/struct/BaseConf:a	()Z
    //   145: ifeq +7 -> 152
    //   148: aload_3
    //   149: invokevirtual 350	com/tencent/mobileqq/config/struct/BaseConf:a	()V
    //   152: iload 6
    //   154: iconst_1
    //   155: iadd
    //   156: istore 6
    //   158: goto -55 -> 103
    //   161: astore_1
    //   162: aconst_null
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_3
    //   166: aload_1
    //   167: astore_2
    //   168: aload_3
    //   169: astore_1
    //   170: goto -97 -> 73
    //   173: aload 4
    //   175: astore_3
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 353	java/io/FileInputStream:close	()V
    //   184: aload_1
    //   185: ifnull +7 -> 192
    //   188: aload_1
    //   189: invokevirtual 354	java/io/BufferedInputStream:close	()V
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: aload_3
    //   197: invokevirtual 355	java/io/DataInputStream:close	()V
    //   200: iconst_0
    //   201: istore 6
    //   203: iload 6
    //   205: ifeq +148 -> 353
    //   208: iload 7
    //   210: istore 6
    //   212: iload 6
    //   214: getstatic 341	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   217: arraylength
    //   218: if_icmpge +135 -> 353
    //   221: getstatic 341	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   224: iload 6
    //   226: aaload
    //   227: invokevirtual 350	com/tencent/mobileqq/config/struct/BaseConf:a	()V
    //   230: iload 6
    //   232: iconst_1
    //   233: iadd
    //   234: istore 6
    //   236: goto -24 -> 212
    //   239: astore_1
    //   240: iconst_0
    //   241: istore 6
    //   243: goto -40 -> 203
    //   246: astore 4
    //   248: aload 5
    //   250: astore_3
    //   251: aload 4
    //   253: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   256: aload_2
    //   257: ifnull +7 -> 264
    //   260: aload_2
    //   261: invokevirtual 353	java/io/FileInputStream:close	()V
    //   264: aload_1
    //   265: ifnull +7 -> 272
    //   268: aload_1
    //   269: invokevirtual 354	java/io/BufferedInputStream:close	()V
    //   272: aload_3
    //   273: ifnull +7 -> 280
    //   276: aload_3
    //   277: invokevirtual 355	java/io/DataInputStream:close	()V
    //   280: iconst_1
    //   281: istore 6
    //   283: goto -80 -> 203
    //   286: astore_1
    //   287: iconst_1
    //   288: istore 6
    //   290: goto -87 -> 203
    //   293: astore_3
    //   294: aconst_null
    //   295: astore 4
    //   297: aload_2
    //   298: ifnull +7 -> 305
    //   301: aload_2
    //   302: invokevirtual 353	java/io/FileInputStream:close	()V
    //   305: aload_1
    //   306: ifnull +7 -> 313
    //   309: aload_1
    //   310: invokevirtual 354	java/io/BufferedInputStream:close	()V
    //   313: aload 4
    //   315: ifnull +8 -> 323
    //   318: aload 4
    //   320: invokevirtual 355	java/io/DataInputStream:close	()V
    //   323: aload_3
    //   324: athrow
    //   325: astore_2
    //   326: goto -142 -> 184
    //   329: astore_1
    //   330: goto -138 -> 192
    //   333: astore_2
    //   334: goto -70 -> 264
    //   337: astore_1
    //   338: goto -66 -> 272
    //   341: astore_2
    //   342: goto -37 -> 305
    //   345: astore_1
    //   346: goto -33 -> 313
    //   349: astore_1
    //   350: goto -27 -> 323
    //   353: return
    //   354: astore_3
    //   355: goto -58 -> 297
    //   358: astore 5
    //   360: aload_3
    //   361: astore 4
    //   363: aload 5
    //   365: astore_3
    //   366: goto -69 -> 297
    //   369: astore 5
    //   371: aload 4
    //   373: astore_3
    //   374: aload 5
    //   376: astore 4
    //   378: goto -127 -> 251
    //   381: astore_2
    //   382: goto -218 -> 164
    //   385: aconst_null
    //   386: astore_1
    //   387: aconst_null
    //   388: astore_2
    //   389: goto -316 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	ConfigManager
    //   59	36	1	localObject1	Object
    //   161	1	1	localException1	Exception
    //   163	26	1	localObject2	Object
    //   239	30	1	localException2	Exception
    //   286	24	1	localException3	Exception
    //   329	1	1	localException4	Exception
    //   337	1	1	localException5	Exception
    //   345	1	1	localException6	Exception
    //   349	1	1	localException7	Exception
    //   386	1	1	localObject3	Object
    //   70	232	2	localObject4	Object
    //   325	1	2	localException8	Exception
    //   333	1	2	localException9	Exception
    //   341	1	2	localException10	Exception
    //   381	1	2	localException11	Exception
    //   388	1	2	localObject5	Object
    //   68	209	3	localObject6	Object
    //   293	31	3	localObject7	Object
    //   354	7	3	localObject8	Object
    //   365	9	3	localObject9	Object
    //   4	170	4	localDataInputStream	DataInputStream
    //   246	6	4	localException12	Exception
    //   295	82	4	localObject10	Object
    //   1	248	5	localObject11	Object
    //   358	6	5	localObject12	Object
    //   369	6	5	localException13	Exception
    //   101	188	6	k	int
    //   7	202	7	m	int
    // Exception table:
    //   from	to	target	type
    //   48	60	161	java/lang/Exception
    //   196	200	239	java/lang/Exception
    //   83	100	246	java/lang/Exception
    //   276	280	286	java/lang/Exception
    //   83	100	293	finally
    //   180	184	325	java/lang/Exception
    //   188	192	329	java/lang/Exception
    //   260	264	333	java/lang/Exception
    //   268	272	337	java/lang/Exception
    //   301	305	341	java/lang/Exception
    //   309	313	345	java/lang/Exception
    //   318	323	349	java/lang/Exception
    //   103	141	354	finally
    //   141	152	354	finally
    //   251	256	358	finally
    //   103	141	369	java/lang/Exception
    //   141	152	369	java/lang/Exception
    //   60	69	381	java/lang/Exception
  }
  
  public void a(Command paramCommand, ConfigDialog paramConfigDialog) {}
  
  public void a(BaseConf paramBaseConf, DataOutputStream paramDataOutputStream)
  {
    paramBaseConf.a(paramDataOutputStream);
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg arg1, HttpMsg paramHttpMsg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode------------");
    }
    paramHttpMsg2 = paramHttpMsg2.a();
    try
    {
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        ConfigParser.a(paramHttpMsg2, new rah(), this.j);
        b();
        d();
        return;
      }
      return;
    }
    catch (RuntimeException ???) {}
  }
  
  public void a(String paramString) {}
  
  public void a(BaseConf[] paramArrayOfBaseConf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashLogo", 2, "fight..confighParse..getConfig");
    }
    this.jdField_a_of_type_Boolean = false;
    paramArrayOfBaseConf = new HttpMsg("http://conf.3g.qq.com/newConf/n", ConfigParser.a(paramArrayOfBaseConf), this, true);
    paramArrayOfBaseConf.c("POST");
    paramArrayOfBaseConf.b(5);
    HttpCommunicator localHttpCommunicator = Config.a();
    if (localHttpCommunicator != null) {
      localHttpCommunicator.a(paramArrayOfBaseConf);
    }
    this.jdField_a_of_type_JavaUtilTimer.schedule(new raf(this), 1000L);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()))
      {
        this.jdField_a_of_type_JavaIoFile.delete();
        this.jdField_a_of_type_JavaIoFile = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    d();
  }
  
  public boolean b()
  {
    boolean bool = true;
    switch (this.jdField_a_of_type_Rag.a)
    {
    default: 
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: new 102	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 127	com/tencent/mobileqq/config/ConfigManager:g	Ljava/lang/String;
    //   13: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: putfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   19: aload_0
    //   20: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   23: invokevirtual 122	java/io/File:exists	()Z
    //   26: ifne +11 -> 37
    //   29: aload_0
    //   30: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   33: invokevirtual 147	java/io/File:createNewFile	()Z
    //   36: pop
    //   37: aload_0
    //   38: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   41: ifnull +97 -> 138
    //   44: aload_0
    //   45: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   48: invokevirtual 122	java/io/File:exists	()Z
    //   51: ifeq +87 -> 138
    //   54: new 433	java/io/BufferedOutputStream
    //   57: dup
    //   58: new 435	java/io/FileOutputStream
    //   61: dup
    //   62: aload_0
    //   63: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   66: invokespecial 436	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: invokespecial 439	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   72: astore_1
    //   73: new 441	java/io/DataOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 442	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   81: astore_2
    //   82: iconst_0
    //   83: istore 5
    //   85: iload 5
    //   87: getstatic 341	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   90: arraylength
    //   91: if_icmpge +31 -> 122
    //   94: aload_0
    //   95: getstatic 341	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   98: iload 5
    //   100: aaload
    //   101: aload_2
    //   102: invokevirtual 444	com/tencent/mobileqq/config/ConfigManager:a	(Lcom/tencent/mobileqq/config/struct/BaseConf;Ljava/io/DataOutputStream;)V
    //   105: iload 5
    //   107: iconst_1
    //   108: iadd
    //   109: istore 5
    //   111: goto -26 -> 85
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   119: goto -82 -> 37
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 445	java/io/BufferedOutputStream:close	()V
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 446	java/io/DataOutputStream:close	()V
    //   138: return
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 445	java/io/BufferedOutputStream:close	()V
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 446	java/io/DataOutputStream:close	()V
    //   158: aload_0
    //   159: getfield 144	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   162: invokevirtual 429	java/io/File:delete	()Z
    //   165: pop
    //   166: return
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 445	java/io/BufferedOutputStream:close	()V
    //   178: aload_3
    //   179: ifnull +7 -> 186
    //   182: aload_3
    //   183: invokevirtual 446	java/io/DataOutputStream:close	()V
    //   186: aload_2
    //   187: athrow
    //   188: astore_1
    //   189: goto -59 -> 130
    //   192: astore_1
    //   193: return
    //   194: astore_2
    //   195: goto -45 -> 150
    //   198: astore_1
    //   199: goto -41 -> 158
    //   202: astore_1
    //   203: goto -25 -> 178
    //   206: astore_1
    //   207: goto -21 -> 186
    //   210: astore_2
    //   211: goto -41 -> 170
    //   214: astore 4
    //   216: aload_2
    //   217: astore_3
    //   218: aload 4
    //   220: astore_2
    //   221: goto -51 -> 170
    //   224: astore_2
    //   225: aconst_null
    //   226: astore_3
    //   227: aload_1
    //   228: astore_2
    //   229: aload_3
    //   230: astore_1
    //   231: goto -89 -> 142
    //   234: astore_3
    //   235: aload_1
    //   236: astore_3
    //   237: aload_2
    //   238: astore_1
    //   239: aload_3
    //   240: astore_2
    //   241: goto -99 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	ConfigManager
    //   72	6	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   114	13	1	localException1	Exception
    //   139	1	1	localException2	Exception
    //   141	34	1	localObject1	Object
    //   188	1	1	localException3	Exception
    //   192	1	1	localException4	Exception
    //   198	1	1	localException5	Exception
    //   202	1	1	localException6	Exception
    //   206	22	1	localException7	Exception
    //   230	9	1	localObject2	Object
    //   3	144	2	localDataOutputStream	DataOutputStream
    //   167	20	2	localObject3	Object
    //   194	1	2	localException8	Exception
    //   210	7	2	localObject4	Object
    //   220	1	2	localObject5	Object
    //   224	1	2	localException9	Exception
    //   228	13	2	localObject6	Object
    //   1	229	3	localObject7	Object
    //   234	1	3	localException10	Exception
    //   236	4	3	localObject8	Object
    //   214	5	4	localObject9	Object
    //   83	27	5	k	int
    // Exception table:
    //   from	to	target	type
    //   19	37	114	java/lang/Exception
    //   54	73	139	java/lang/Exception
    //   54	73	167	finally
    //   126	130	188	java/lang/Exception
    //   134	138	192	java/lang/Exception
    //   146	150	194	java/lang/Exception
    //   154	158	198	java/lang/Exception
    //   174	178	202	java/lang/Exception
    //   182	186	206	java/lang/Exception
    //   73	82	210	finally
    //   85	105	214	finally
    //   73	82	224	java/lang/Exception
    //   85	105	234	java/lang/Exception
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject = Config.a();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ConfigListener)((Iterator)localObject).next()).a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\config\ConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */