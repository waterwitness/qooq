package com.tencent.mobileqq.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.processor.PttAgcAndNsProcessor;
import com.tencent.mobileqq.ptt.processor.PttCompositeProcessor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;
import wcy;

public class QQRecorder
{
  static final int jdField_a_of_type_Int = 1;
  public static final String a = "QQRecorder";
  private static int[] jdField_a_of_type_ArrayOfInt = { 13, 14, 16, 18, 20, 21, 27, 32 };
  static final int b = 2;
  public static final String b = "http://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14";
  static final int jdField_c_of_type_Int = 3;
  private static String jdField_c_of_type_JavaLangString;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  public static final int h = 800;
  public static final int i = 500;
  public static final int j = 250;
  public static int k = 0;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 0;
  public static final int o = 1;
  public static final int p = 2;
  private static final int q = 2;
  private static final int r = 2;
  private static final int s = 20480;
  private static final int w = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  public AudioManager a;
  private AudioRecord jdField_a_of_type_AndroidMediaAudioRecord;
  private PttCompositeProcessor jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor;
  private QQRecorder.OnQQRecorderListener jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener;
  public QQRecorder.RecorderParam a;
  public wcy a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  private boolean jdField_c_of_type_Boolean = true;
  private int t = 20480;
  private int u = 800;
  private int v;
  private int x = -1;
  private int y = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    k = 60000;
  }
  
  public QQRecorder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new QQRecorder.RecorderParam(RecordParams.f, 0, 0);
    paramContext = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qq_audio_record.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "Init | dpc config = " + paramContext);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = paramContext.split("\\|");
        this.x = Integer.parseInt(paramContext[0]);
        this.y = Integer.parseInt(paramContext[1]);
        if (paramContext.length > 4) {
          a(Integer.parseInt(paramContext[2]), Integer.parseInt(paramContext[3]), Integer.parseInt(paramContext[4]));
        }
        if ((!VersionUtils.e()) && ((this.x == 3) || (this.y == 7))) {
          throw new RuntimeException("Illegal dpc config");
        }
      }
      catch (Exception paramContext)
      {
        this.x = -1;
        this.y = -1;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecord init error.", paramContext);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "mMode = " + this.x + " | mAudioSource = " + this.y + " | recorderBufSize = " + this.t + " | readLength = " + this.u);
    }
  }
  
  public static double a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (paramLong <= 0L) {
      return 0.0D;
    }
    return paramLong / b(paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(byte paramByte, InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[2];
    paramByte = 0;
    while (paramInputStream.read(arrayOfByte) > 0)
    {
      int i1 = RecordParams.a(arrayOfByte);
      byte b1 = paramByte + 20;
      paramByte = b1;
      if (i1 > 0)
      {
        paramInputStream.skip(i1);
        paramByte = b1;
      }
    }
    return paramByte;
  }
  
  public static int a(double paramDouble)
  {
    return b(paramDouble / 1000.0D);
  }
  
  public static int a(int paramInt)
  {
    int i1 = paramInt;
    if ((Build.MANUFACTURER + "-" + Build.MODEL).equalsIgnoreCase("Xiaomi-MI NOTE Pro")) {
      i1 = paramInt + 100;
    }
    return i1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 2;
    switch (paramInt2)
    {
    default: 
      throw new RuntimeException("channel Illegal");
    }
    for (paramInt2 = 1;; paramInt2 = 2) {
      switch (paramInt3)
      {
      default: 
        throw new RuntimeException("format Illegal");
      }
    }
    i1 = 1;
    return i1 * paramInt1 * paramInt2;
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    String str = null;
    if ((paramMessageRecord instanceof MessageForPtt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "voiceLength getFilePlayTime " + ((MessageForPtt)paramMessageRecord).voiceLength);
      }
      if (((MessageForPtt)paramMessageRecord).voiceLength > 1) {
        return ((MessageForPtt)paramMessageRecord).voiceLength;
      }
      str = ((MessageForPtt)paramMessageRecord).getLocalFilePath();
    }
    while (str != null)
    {
      return a(str);
      if ((paramMessageRecord instanceof QQMessageFacade.Message)) {
        str = ((QQMessageFacade.Message)paramMessageRecord).pttUrl;
      }
    }
    return 0;
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: new 271	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: new 274	java/io/DataInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 277	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore 4
    //   27: aload_0
    //   28: invokevirtual 281	java/io/FileInputStream:available	()I
    //   31: istore 7
    //   33: bipush 10
    //   35: newarray <illegal type>
    //   37: astore 5
    //   39: aload 4
    //   41: aload 5
    //   43: invokevirtual 282	java/io/DataInputStream:read	([B)I
    //   46: aload 5
    //   48: arraylength
    //   49: if_icmpne +223 -> 272
    //   52: aload 5
    //   54: invokestatic 285	com/tencent/mobileqq/utils/RecordParams:a	([B)Z
    //   57: ifeq +54 -> 111
    //   60: aload 5
    //   62: iconst_0
    //   63: baload
    //   64: aload 4
    //   66: invokestatic 287	com/tencent/mobileqq/utils/QQRecorder:a	(BLjava/io/InputStream;)I
    //   69: i2d
    //   70: ldc2_w 223
    //   73: ddiv
    //   74: dstore_1
    //   75: aload 4
    //   77: invokevirtual 290	java/io/DataInputStream:close	()V
    //   80: aload_0
    //   81: invokevirtual 291	java/io/FileInputStream:close	()V
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 291	java/io/FileInputStream:close	()V
    //   94: aload_3
    //   95: ifnull +7 -> 102
    //   98: aload_3
    //   99: invokevirtual 290	java/io/DataInputStream:close	()V
    //   102: dload_1
    //   103: invokestatic 226	com/tencent/mobileqq/utils/QQRecorder:b	(D)I
    //   106: istore 6
    //   108: iload 6
    //   110: ireturn
    //   111: aload 5
    //   113: bipush 6
    //   115: baload
    //   116: iconst_3
    //   117: ishr
    //   118: i2b
    //   119: bipush 7
    //   121: iand
    //   122: i2b
    //   123: istore 8
    //   125: iload 7
    //   127: i2d
    //   128: dstore_1
    //   129: getstatic 69	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ArrayOfInt	[I
    //   132: iload 8
    //   134: iaload
    //   135: istore 7
    //   137: dload_1
    //   138: ldc2_w 292
    //   141: dsub
    //   142: iload 7
    //   144: i2d
    //   145: ddiv
    //   146: ldc2_w 294
    //   149: ddiv
    //   150: dstore_1
    //   151: goto -76 -> 75
    //   154: astore 5
    //   156: aconst_null
    //   157: astore_0
    //   158: aload 4
    //   160: astore_3
    //   161: aload 5
    //   163: invokevirtual 298	java/lang/Exception:printStackTrace	()V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 291	java/io/FileInputStream:close	()V
    //   174: aload_0
    //   175: ifnull -67 -> 108
    //   178: aload_0
    //   179: invokevirtual 290	java/io/DataInputStream:close	()V
    //   182: iconst_0
    //   183: ireturn
    //   184: astore_0
    //   185: iconst_0
    //   186: ireturn
    //   187: astore_3
    //   188: aconst_null
    //   189: astore 4
    //   191: aconst_null
    //   192: astore_0
    //   193: aload_0
    //   194: ifnull +7 -> 201
    //   197: aload_0
    //   198: invokevirtual 291	java/io/FileInputStream:close	()V
    //   201: aload 4
    //   203: ifnull +8 -> 211
    //   206: aload 4
    //   208: invokevirtual 290	java/io/DataInputStream:close	()V
    //   211: aload_3
    //   212: athrow
    //   213: astore_0
    //   214: goto -3 -> 211
    //   217: astore_3
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -28 -> 193
    //   224: astore_3
    //   225: goto -32 -> 193
    //   228: astore 4
    //   230: aload_3
    //   231: astore 5
    //   233: aload 4
    //   235: astore_3
    //   236: aload_0
    //   237: astore 4
    //   239: aload 5
    //   241: astore_0
    //   242: goto -49 -> 193
    //   245: astore 5
    //   247: aconst_null
    //   248: astore 4
    //   250: aload_0
    //   251: astore_3
    //   252: aload 4
    //   254: astore_0
    //   255: goto -94 -> 161
    //   258: astore 5
    //   260: aload_0
    //   261: astore_3
    //   262: aload 4
    //   264: astore_0
    //   265: goto -104 -> 161
    //   268: astore_0
    //   269: goto -167 -> 102
    //   272: aload 4
    //   274: astore_3
    //   275: dconst_0
    //   276: dstore_1
    //   277: goto -191 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramString	String
    //   74	203	1	d1	double
    //   7	164	3	localDataInputStream1	java.io.DataInputStream
    //   187	25	3	localObject1	Object
    //   217	1	3	localObject2	Object
    //   224	7	3	localObject3	Object
    //   235	40	3	localObject4	Object
    //   4	216	4	localDataInputStream2	java.io.DataInputStream
    //   228	6	4	localObject5	Object
    //   237	36	4	str	String
    //   37	75	5	arrayOfByte	byte[]
    //   154	8	5	localException1	Exception
    //   231	9	5	localObject6	Object
    //   245	1	5	localException2	Exception
    //   258	1	5	localException3	Exception
    //   1	108	6	i1	int
    //   31	112	7	i2	int
    //   123	10	8	i3	int
    // Exception table:
    //   from	to	target	type
    //   8	17	154	java/lang/Exception
    //   170	174	184	java/lang/Exception
    //   178	182	184	java/lang/Exception
    //   8	17	187	finally
    //   197	201	213	java/lang/Exception
    //   206	211	213	java/lang/Exception
    //   17	27	217	finally
    //   80	84	217	finally
    //   27	75	224	finally
    //   75	80	224	finally
    //   129	137	224	finally
    //   161	166	228	finally
    //   17	27	245	java/lang/Exception
    //   80	84	245	java/lang/Exception
    //   27	75	258	java/lang/Exception
    //   75	80	258	java/lang/Exception
    //   129	137	258	java/lang/Exception
    //   90	94	268	java/lang/Exception
    //   98	102	268	java/lang/Exception
  }
  
  public static String a()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      paramInt2 = AudioRecord.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a, 2, 2);
      if ((paramInt2 != -2) && (paramInt2 != -1)) {
        this.t = (paramInt2 * paramInt1);
      }
    }
    for (;;)
    {
      if (paramInt3 != -1) {
        this.u = paramInt3;
      }
      return;
      if (paramInt2 != -1) {
        this.t = paramInt2;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 0) {
      if (!AmrInputStreamWrapper.a()) {}
    }
    while ((SilkCodecWrapper.a()) || (FileUtils.a() > 1310720.0F))
    {
      do
      {
        return true;
      } while (FileUtils.a() > 327680.0F);
      return false;
    }
    return false;
  }
  
  private static double b(long paramLong, int paramInt)
  {
    return a(paramInt, 2, 2, paramLong);
  }
  
  public static int b(double paramDouble)
  {
    double d1 = paramDouble;
    if (paramDouble <= 0.5D)
    {
      d1 = paramDouble;
      if (paramDouble > 0.0D) {
        d1 = paramDouble + 0.5D;
      }
    }
    return (int)(d1 + 0.5D);
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3) / 1000;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
    for (int i1 = this.jdField_a_of_type_AndroidMediaAudioManager.getMode();; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "startRecording | audio mode = " + i1);
      }
      if ((this.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.x != -1)) {
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.x);
      }
      if ((this.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 0) || (this.jdField_a_of_type_Boolean)) {
        if (this.y != -1) {
          break label203;
        }
      }
      label203:
      for (i1 = 0;; i1 = this.y)
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(i1, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a, 2, 2, this.t);
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 1) {
          break;
        }
        i1 = this.jdField_a_of_type_AndroidMediaAudioRecord.getState();
        if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
          this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        }
        this.jdField_a_of_type_AndroidMediaAudioRecord = null;
        throw new QQRecorder.RecordInitException("mRecorder.getState is not STATE_INITIALIZED, state = " + i1);
      }
      this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener.a();
      }
      return;
    }
  }
  
  private static void b(String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    if (new Random().nextInt(1000) == 521)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "real do report");
      }
      StatisticCollector.a(BaseApplication.getContext()).a("", paramString, paramBoolean, 0L, 0L, paramHashMap, "");
    }
  }
  
  private static int c(int paramInt)
  {
    return a(paramInt, 2, 2);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor = new PttCompositeProcessor();
    this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new PttAgcAndNsProcessor(this.jdField_a_of_type_AndroidContentContext));
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c != 0) {
        break label211;
      }
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.b, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mAudioType=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c + ", mSampleRate=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a + " ,mBitRate=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.b + " ,Codec=" + this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor).append(" ,processor = ").append(" ,time is :").append(System.currentTimeMillis());
        QLog.d("QQRecorder", 2, localStringBuilder.toString());
      }
      return;
      label211:
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new SilkCodecWrapper(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a();
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor = null;
    }
  }
  
  public static boolean d()
  {
    return new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Wcy == null) {
      return 0;
    }
    return this.v;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Wcy != null) && (this.jdField_a_of_type_Wcy.a())) {}
    synchronized (this.jdField_a_of_type_Wcy)
    {
      this.jdField_a_of_type_Wcy.b = false;
    }
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener = paramOnQQRecorderListener;
  }
  
  public void a(QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a != paramRecorderParam.a) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    int i1 = AudioRecord.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a, 2, 2);
    if (this.t < i1) {
      this.t = i1;
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_Wcy + ",time is:" + System.currentTimeMillis());
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    jdField_c_of_type_JavaLangString = paramString;
    if ((this.jdField_a_of_type_Wcy == null) || (!this.jdField_a_of_type_Wcy.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder.start, new RecordThread ");
      }
      this.jdField_a_of_type_Wcy = new wcy(this);
      this.jdField_a_of_type_Wcy.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Wcy.start();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "start, RecordThread exist , notify ");
    }
    synchronized (this.jdField_a_of_type_Wcy)
    {
      this.jdField_a_of_type_Wcy.b = true;
      this.jdField_a_of_type_Wcy.jdField_a_of_type_JavaLangString = paramString;
      try
      {
        notifyAll();
        return;
      }
      finally {}
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    int i1 = 7;
    try
    {
      String str = paramThrowable.toString();
      if ((paramThrowable instanceof RuntimeException)) {
        if (str.contains("STATE_INITIALIZED")) {
          i1 = 2;
        }
      }
      for (;;)
      {
        paramThrowable = new HashMap();
        paramThrowable.put("exceptionType", i1 + "");
        paramThrowable.put("osVersion", Build.VERSION.SDK_INT + "");
        paramThrowable.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        paramThrowable.put("exceptionMsg", str);
        b("actPttRecordException", false, paramThrowable);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQRecorder", 2, "report exception(catch exception) | exceptionType = " + i1 + " | exceptionMessage = " + str);
        return;
        if ((paramThrowable instanceof UnsatisfiedLinkError)) {
          if (str.contains("Native method not found"))
          {
            i1 = 4;
          }
          else
          {
            boolean bool = str.contains("Library not found");
            if (bool) {
              i1 = 5;
            } else {
              i1 = 6;
            }
          }
        }
      }
      return;
    }
    catch (Exception paramThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "Report exception error.", paramThrowable);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Wcy != null) && (this.jdField_a_of_type_Wcy.jdField_a_of_type_Boolean);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Wcy == null) || (!this.jdField_a_of_type_Wcy.jdField_a_of_type_Boolean);
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_Wcy + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_Wcy != null)
    {
      boolean bool = this.jdField_a_of_type_Wcy.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Wcy.jdField_a_of_type_Boolean = false;
      return bool;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\QQRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */