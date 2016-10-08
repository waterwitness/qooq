package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import plq;
import plr;
import pls;
import plt;

public class QvipSpecialSoundManager
{
  public static final int a = 1000277;
  public static final String a = "http://i.gtimg.cn/club/moblie/special_sound/new_config.json";
  public static HashMap a;
  public static final String b = "specialcare_config";
  public static HashMap b = new HashMap();
  public static final String c = "key_special_sound_list";
  private static final String d = "QvipSpecialSoundManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ByteArrayPool jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool = new ByteArrayPool(4096);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public QvipSpecialSoundManager(Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private String a()
  {
    Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "http://i.gtimg.cn/club/moblie/special_sound/new_config.json");
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      try
      {
        DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getString("specialcare_config", ""), (File)localObject);
        localDownloadTask.a = 1;
        localDownloadTask.l = true;
        i = DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if (i != 0) {
          break label180;
        }
        if (localObject != null)
        {
          l = ((File)localObject).length();
          a(l);
          i = 1;
          if (i != 0) {
            break label130;
          }
          b("downLoad Special Sound Config failed.");
          return "";
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        i = -1;
        continue;
        long l = 0L;
        continue;
      }
      int i = 1;
      continue;
      try
      {
        label130:
        localObject = a((File)localObject);
        return (String)localObject;
      }
      catch (IOException localIOException)
      {
        b("decodeTextFile is IOException.");
        localIOException.printStackTrace();
        return "";
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          b("decodeTextFile is OutOfMemoryError.");
          localOutOfMemoryError.printStackTrace();
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          b("decodeTextFile is exception.");
          localException1.printStackTrace();
        }
      }
      label180:
      i = 0;
    }
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: new 162	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 167	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 168	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_2
    //   17: aload_0
    //   18: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   21: sipush 4096
    //   24: invokevirtual 172	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   27: astore_3
    //   28: aload_1
    //   29: aload_3
    //   30: iconst_0
    //   31: sipush 4096
    //   34: invokevirtual 178	java/io/InputStream:read	([BII)I
    //   37: istore 5
    //   39: iload 5
    //   41: iconst_m1
    //   42: if_icmpeq +56 -> 98
    //   45: aload_2
    //   46: aload_3
    //   47: iconst_0
    //   48: iload 5
    //   50: invokevirtual 182	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -25 -> 28
    //   56: astore 4
    //   58: aload 4
    //   60: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 185	java/io/InputStream:close	()V
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_0
    //   80: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   83: aload_3
    //   84: invokevirtual 190	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   87: ldc 109
    //   89: areturn
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 191	java/io/FileNotFoundException:printStackTrace	()V
    //   95: ldc 109
    //   97: areturn
    //   98: new 193	java/lang/String
    //   101: dup
    //   102: aload_2
    //   103: invokevirtual 197	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   106: ldc -57
    //   108: invokespecial 202	java/lang/String:<init>	([BLjava/lang/String;)V
    //   111: astore 4
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 185	java/io/InputStream:close	()V
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   129: aload_0
    //   130: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   133: aload_3
    //   134: invokevirtual 190	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   137: aload 4
    //   139: areturn
    //   140: astore 4
    //   142: aload 4
    //   144: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 185	java/io/InputStream:close	()V
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   163: aload_0
    //   164: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   167: aload_3
    //   168: invokevirtual 190	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   171: goto -84 -> 87
    //   174: astore 4
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 185	java/io/InputStream:close	()V
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 186	java/io/ByteArrayOutputStream:close	()V
    //   192: aload_0
    //   193: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   196: aload_3
    //   197: invokevirtual 190	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   200: aload 4
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	QvipSpecialSoundManager
    //   0	203	1	paramFile	File
    //   16	173	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   27	170	3	arrayOfByte	byte[]
    //   56	3	4	localIOException	IOException
    //   111	27	4	str	String
    //   140	3	4	localException	Exception
    //   174	27	4	localObject	Object
    //   37	12	5	i	int
    // Exception table:
    //   from	to	target	type
    //   28	39	56	java/io/IOException
    //   45	53	56	java/io/IOException
    //   98	113	56	java/io/IOException
    //   0	9	90	java/io/FileNotFoundException
    //   28	39	140	java/lang/Exception
    //   45	53	140	java/lang/Exception
    //   98	113	140	java/lang/Exception
    //   28	39	174	finally
    //   45	53	174	finally
    //   58	63	174	finally
    //   98	113	174	finally
    //   142	147	174	finally
  }
  
  private void a(QvipSpecialSoundManager.CallBack paramCallBack, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new plt(this, paramCallBack, paramBoolean));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject;
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null)) {
          return;
        }
        if (TextUtils.isEmpty(paramString2)) {
          return;
        }
        paramString2 = QvipSpecialSoundConfig.a(new JSONObject(paramString2));
        localObject = QvipSpecialSoundConfig.a(new JSONObject(paramString1));
        paramString1 = paramString2.a;
        paramString2 = ((QvipSpecialSoundConfig)localObject).a;
        if ((paramString1 == null) || (paramString2 == null) || (paramString1.isEmpty()) || (paramString2.isEmpty()) || (paramString1.size() < paramString2.size()))
        {
          b("updateSpecialSound return.");
          return;
        }
      }
      catch (Exception paramString1)
      {
        b("updateSpecialSound exception");
        paramString1.printStackTrace();
        return;
      }
      int j = paramString2.size();
      int i = 0;
      while (i < j)
      {
        localObject = (plq)paramString1.get(i);
        plq localplq = (plq)paramString2.get(i);
        if ((((plq)localObject).jdField_a_of_type_Int == localplq.jdField_a_of_type_Int) && (!((plq)localObject).jdField_b_of_type_JavaLangString.equals(localplq.jdField_b_of_type_JavaLangString))) {
          ThreadManager.a(new plr(this, (plq)localObject), 5, null, true);
        }
        i += 1;
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      b("SpecialSoundList is empty, donot need sort.");
    }
    do
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int j = paramList.size();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
      int i = 0;
      if (i < j)
      {
        plq localplq = (plq)paramList.get(i);
        if (!b.containsKey(String.valueOf(localplq.jdField_a_of_type_Int))) {
          b.put(String.valueOf(localplq.jdField_a_of_type_Int), localplq);
        }
        localEditor.putString("special_sound_url" + localplq.jdField_a_of_type_Int, localplq.jdField_c_of_type_JavaLangString);
        if (!b(localplq.d)) {
          b("is white list.");
        }
        for (;;)
        {
          i += 1;
          break;
          if (localplq.jdField_c_of_type_Int == 1) {
            if (localplq.jdField_b_of_type_Int == 1) {
              localArrayList1.add(localplq);
            } else if (localplq.jdField_b_of_type_Int == 2) {
              localArrayList2.add(localplq);
            } else {
              localArrayList3.add(localplq);
            }
          }
        }
      }
      localEditor.commit();
      paramList.clear();
      paramList.addAll(localArrayList1);
      paramList.addAll(localArrayList2);
      paramList.addAll(localArrayList3);
    } while (jdField_a_of_type_JavaUtilHashMap.containsKey("key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()));
    jdField_a_of_type_JavaUtilHashMap.put("key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), paramList);
  }
  
  private boolean b(String paramString)
  {
    str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return true;
      if (paramString.contains("|")) {
        try
        {
          String[] arrayOfString = paramString.split("\\|");
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label85;
            }
            boolean bool = arrayOfString[i].trim().equals(str);
            if (bool) {
              break;
            }
            i += 1;
          }
          return paramString.equals(str);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if (((SharedPreferences)localObject).contains("defaulut_special_sound_source1")) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("defaulut_special_sound_source1", 2131165213);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public int a(String paramString)
  {
    Object localObject = "key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    localObject = (List)jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null) {
      return -1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      plq localplq = (plq)((Iterator)localObject).next();
      if (paramString.equals(localplq.jdField_c_of_type_JavaLangString)) {
        return localplq.jdField_a_of_type_Int;
      }
    }
    return -1;
  }
  
  public String a(int paramInt)
  {
    if ((b != null) && (!b.isEmpty()))
    {
      plq localplq = (plq)b.get(String.valueOf(paramInt));
      if (localplq != null) {
        return localplq.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public String a(String paramString)
  {
    Object localObject = "key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    localObject = (List)jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      plq localplq = (plq)((Iterator)localObject).next();
      if (paramString.equals(localplq.jdField_c_of_type_JavaLangString)) {
        return localplq.jdField_a_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  public void a()
  {
    Object localObject4 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "http://i.gtimg.cn/club/moblie/special_sound/new_config.json");
    try
    {
      if (localFile.exists()) {
        String str = a(localFile);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          localObject1 = new DownloadTask(((SharedPreferences)localObject1).getString("specialcare_config", ""), localFile);
          ((DownloadTask)localObject1).a = 1;
          ((DownloadTask)localObject1).l = true;
          i = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          localObject1 = localObject4;
          if (i == 0) {}
          try
          {
            localObject1 = a(localFile);
            if (localFile == null) {
              break;
            }
            l = localFile.length();
            a(l);
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              long l;
              b("decodeTextFile is exception.");
              localException3.printStackTrace();
              Object localObject2 = localObject4;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            CharSequence localCharSequence;
            Object localObject3;
            for (;;)
            {
              b("decodeTextFile is OutOfMemoryError.");
              localOutOfMemoryError.printStackTrace();
              localObject3 = localObject4;
            }
            if ((TextUtils.isEmpty(localCharSequence)) || (!localCharSequence.equals(localObject3))) {
              break label272;
            }
            b("Config is Same");
            return;
            a(localCharSequence, (String)localObject3);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label249;
          }
          b("new Config is Empty");
          return;
          localException1 = localException1;
          b("download error:" + localException1.toString());
          localException1.printStackTrace();
          localCharSequence = null;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          b("download error:" + localException2.toString());
          localException2.printStackTrace();
          int i = -1;
          continue;
          l = 0L;
        }
      }
    }
    label249:
    label272:
    return;
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      b("reportFlowData is Empty flowSize = " + paramLong);
      return;
    }
    String[] arrayOfString;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      b("reportFlowData int wifi state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFISpecialCareDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      b("sendAppDataIncerment flowSize = " + paramLong);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), arrayOfString, paramLong);
      return;
      b("reportFlowData int 2G/3G state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGSpecialCareDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
  
  public void a(QvipSpecialSoundManager.CallBack paramCallBack)
  {
    ThreadManager.a(new pls(this, paramCallBack), 5, null, true);
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = QvipSpecialSoundConfig.a(new JSONObject(paramString));
        if (paramString != null)
        {
          a(paramString.a);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    String str = "key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    return jdField_a_of_type_JavaUtilHashMap.containsKey(str);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), paramString);
      try
      {
        paramString = new DownloadTask(MsfSdkUtils.insertMtype("lingyin", paramString), localFile);
        paramString.a = 1;
        i = DownloaderFactory.a(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if (i == 0) {
          continue;
        }
        return false;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          int i = -1;
        }
      }
    }
  }
  
  public void b()
  {
    c();
    a(a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QvipSpecialSoundManager", 2, paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\specialcare\QvipSpecialSoundManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */