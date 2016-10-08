package com.tencent.biz.qqstory.utils.ffmpeg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import izb;
import izd;
import izf;
import izg;
import izh;
import izi;
import izl;
import izn;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FFmpeg
{
  protected static final int a = -9999;
  protected static final long a = 10000L;
  public static volatile FFmpeg a;
  public static final String a;
  protected static final int b = 1;
  public static final String b = "copy_success";
  protected static final int c = 0;
  public static final String c = "copy_fail";
  public static final String d = "TS file exists";
  public static final String e = "input path is null";
  public static final String f = "FFmepg";
  public BroadcastReceiver a;
  public final Context a;
  public FFmpegCommandUnit a;
  public izi a;
  public ArrayList a;
  public boolean a;
  protected long b;
  public ArrayList b;
  public int d = 55537;
  public String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = FFmpeg.class.getSimpleName();
  }
  
  private FFmpeg(Context paramContext)
  {
    this.jdField_b_of_type_Long = Long.MAX_VALUE;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new izh(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramContext);
    izn.a(new File(izl.a(this.jdField_a_of_type_AndroidContentContext)));
  }
  
  public static FFmpeg a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {
        jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg = new FFmpeg(paramContext);
      }
      return jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    return String.format("%02d:%02d:%02d.%03d", new Object[] { Integer.valueOf((int)Math.floor(paramInt / 3600000)), Integer.valueOf((int)Math.floor(paramInt % 3600000) / 60000), Integer.valueOf((int)Math.floor(paramInt % 60000 / 1000)), Integer.valueOf((int)Math.floor(paramInt % 1000)) });
  }
  
  public izb a(String paramString1, String paramString2, izb paramizb, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-i");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    localArrayList.add("-strict");
    localArrayList.add("-2");
    localArrayList.add("-vcodec");
    if (paramizb.jdField_a_of_type_JavaLangString != null)
    {
      localArrayList.add(paramizb.jdField_a_of_type_JavaLangString);
      localArrayList.add("-acodec");
      if (paramizb.d == null) {
        break label393;
      }
      localArrayList.add(paramizb.d);
    }
    for (;;)
    {
      FFmpegUtils.a(paramString2);
      localArrayList.add("-bsf:a");
      localArrayList.add("aac_adtstoasc");
      if (paramizb.c != -1)
      {
        localArrayList.add("-b:v");
        localArrayList.add(paramizb.c + "k");
      }
      if (paramizb.jdField_b_of_type_JavaLangString != null)
      {
        localArrayList.add("-r");
        localArrayList.add(paramizb.jdField_b_of_type_JavaLangString);
      }
      if (paramizb.e != -1)
      {
        localArrayList.add("-b:a");
        localArrayList.add(paramizb.e + "k");
      }
      if (paramizb.jdField_a_of_type_Int > 0)
      {
        localArrayList.add("-s");
        localArrayList.add(paramizb.jdField_a_of_type_Int + "x" + paramizb.jdField_b_of_type_Int);
      }
      if (paramizb.h != null)
      {
        localArrayList.add("-f");
        localArrayList.add(paramizb.h);
      }
      localArrayList.add(new File(paramizb.g).getCanonicalPath());
      a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
      return paramizb;
      localArrayList.add("copy");
      break;
      label393:
      localArrayList.add("aac");
    }
  }
  
  public izb a(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    return a(paramString1, paramString2, new izb(paramString3), paramFFmpegExecuteResponseCallback);
  }
  
  public String a()
  {
    return this.g;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public void a(String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    a(paramString.split(" "), paramFFmpegExecuteResponseCallback);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    String str1 = a(paramInt1);
    String str2 = a(paramInt2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-ss");
    localArrayList.add(str1);
    localArrayList.add("-t");
    localArrayList.add(str2);
    localArrayList.add("-acodec");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void a(String paramString1, String paramString2, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add(new File(paramString2).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramExecuteBinResponseCallback);
  }
  
  public void a(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    this.jdField_b_of_type_JavaUtilArrayList.add(paramString2);
    if (FileUtils.c(paramString2))
    {
      paramFFmpegExecuteResponseCallback.a("TS file exists");
      paramFFmpegExecuteResponseCallback.a(true);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-c");
    localArrayList.add("copy");
    localArrayList.add("-bsf:v");
    localArrayList.add("h264_mp4toannexb");
    localArrayList.add("-f");
    localArrayList.add("mpegts");
    localArrayList.add(paramString2);
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    if ((paramString2 == null) || (paramString3 == null))
    {
      paramFFmpegExecuteResponseCallback.b("input path is null");
      return;
    }
    if (paramString1 == null)
    {
      boolean bool = FileUtils.a(this.jdField_a_of_type_AndroidContentContext, paramString2, paramString3);
      if (bool) {
        paramFFmpegExecuteResponseCallback.a("copy_success");
      }
      for (;;)
      {
        paramFFmpegExecuteResponseCallback.a(bool);
        return;
        paramFFmpegExecuteResponseCallback.b("copy_fail");
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    localArrayList.add("-vf");
    localArrayList.add("movie=" + paramString1 + " [watermark]; [watermark]scale=" + paramInt1 + ":" + paramInt2 + " [watermark]; [in][watermark] overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2 [out]");
    localArrayList.add(new File(paramString3).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-filter_complex");
    localArrayList.add("\"overlay=0:0\"");
    localArrayList.add(new File(paramString3).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      return;
    }
    paramArrayList = (FFmpegCommandUnit)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    ArrayList localArrayList = paramArrayList.jdField_a_of_type_JavaUtilArrayList;
    String[] arrayOfString = paramArrayList.jdField_a_of_type_ArrayOfJavaLangString;
    izg localizg = new izg(this, paramArrayList.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback, arrayOfString, this.jdField_a_of_type_JavaUtilArrayList);
    if (arrayOfString != null)
    {
      a(arrayOfString, localizg);
      return;
    }
    switch (paramArrayList.i)
    {
    default: 
      return;
    case 1: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), ((Integer)localArrayList.get(3)).intValue(), ((Integer)localArrayList.get(4)).intValue(), localizg);
      return;
    case 3: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), ((Integer)localArrayList.get(2)).intValue(), ((Integer)localArrayList.get(3)).intValue(), localizg);
      return;
    case 4: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), localizg);
      return;
    case 2: 
      a((List)localArrayList.get(0), (String)localArrayList.get(1), localizg, ((Boolean)localArrayList.get(2)).booleanValue());
      return;
    case 7: 
      b((List)localArrayList.get(0), (String)localArrayList.get(1), localizg);
      return;
    case 8: 
      a((List)localArrayList.get(0), (String)localArrayList.get(1), localizg);
      return;
    case 5: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), localizg);
      return;
    }
    c((List)localArrayList.get(0), (String)localArrayList.get(1), localizg);
  }
  
  public void a(List paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add("-i");
      localArrayList.add(new File((String)paramList.get(i)).getCanonicalPath());
      localStringBuilder.append("[" + i + ":0]");
      localStringBuilder.append(" ");
      localStringBuilder.append("[" + i + ":1]");
      localStringBuilder.append(" ");
      i += 1;
    }
    localStringBuilder.append("concat=n=" + paramList.size() + ":v=1:a=1 [v] [a]");
    localArrayList.add("-filter_complex");
    localArrayList.add(localStringBuilder.toString());
    localArrayList.add("-map");
    localArrayList.add("[v]");
    localArrayList.add("-map");
    localArrayList.add("[a]");
    localArrayList.add(new File(paramString).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  /* Error */
  public void a(List paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 101	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: pop
    //   9: new 101	java/io/File
    //   12: dup
    //   13: new 181	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   20: getstatic 376	com/tencent/biz/qqstory/app/QQStoryConstant:s	Ljava/lang/String;
    //   23: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 378
    //   29: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 7
    //   40: aload 7
    //   42: invokevirtual 381	java/io/File:exists	()Z
    //   45: ifeq +9 -> 54
    //   48: aload 7
    //   50: invokevirtual 384	java/io/File:delete	()Z
    //   53: pop
    //   54: aload 7
    //   56: invokevirtual 387	java/io/File:createNewFile	()Z
    //   59: pop
    //   60: new 389	java/io/BufferedWriter
    //   63: dup
    //   64: new 391	java/io/FileWriter
    //   67: dup
    //   68: aload 7
    //   70: iconst_1
    //   71: invokespecial 394	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   74: invokespecial 397	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   77: astore 6
    //   79: iconst_0
    //   80: istore 8
    //   82: aload 6
    //   84: astore 5
    //   86: iload 8
    //   88: aload_1
    //   89: invokeinterface 352 1 0
    //   94: if_icmpge +76 -> 170
    //   97: aload 6
    //   99: astore 5
    //   101: aload 6
    //   103: new 181	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 399
    //   113: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: new 101	java/io/File
    //   119: dup
    //   120: aload_1
    //   121: iload 8
    //   123: invokeinterface 353 2 0
    //   128: checkcast 137	java/lang/String
    //   131: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 153	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   137: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 401
    //   143: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokevirtual 404	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   152: aload 6
    //   154: astore 5
    //   156: aload 6
    //   158: invokevirtual 407	java/io/BufferedWriter:newLine	()V
    //   161: iload 8
    //   163: iconst_1
    //   164: iadd
    //   165: istore 8
    //   167: goto -85 -> 82
    //   170: aload 6
    //   172: astore 5
    //   174: aload 6
    //   176: invokevirtual 410	java/io/BufferedWriter:flush	()V
    //   179: aload 6
    //   181: ifnull +8 -> 189
    //   184: aload 6
    //   186: invokevirtual 413	java/io/BufferedWriter:close	()V
    //   189: new 62	java/util/ArrayList
    //   192: dup
    //   193: invokespecial 63	java/util/ArrayList:<init>	()V
    //   196: astore_1
    //   197: aload_1
    //   198: ldc -112
    //   200: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   203: pop
    //   204: aload_1
    //   205: ldc -41
    //   207: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   210: pop
    //   211: aload_1
    //   212: ldc_w 415
    //   215: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   218: pop
    //   219: aload_1
    //   220: ldc -106
    //   222: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   225: pop
    //   226: aload_1
    //   227: aload 7
    //   229: invokevirtual 153	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   232: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   235: pop
    //   236: iload 4
    //   238: ifeq +101 -> 339
    //   241: aload_1
    //   242: ldc_w 417
    //   245: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   248: pop
    //   249: aload_1
    //   250: ldc_w 419
    //   253: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   256: pop
    //   257: aload_1
    //   258: ldc -83
    //   260: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload_1
    //   265: ldc -81
    //   267: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   270: pop
    //   271: aload_1
    //   272: new 101	java/io/File
    //   275: dup
    //   276: aload_2
    //   277: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   280: invokevirtual 153	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   283: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   286: pop
    //   287: aload_0
    //   288: aload_1
    //   289: iconst_0
    //   290: anewarray 137	java/lang/String
    //   293: invokevirtual 221	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   296: checkcast 223	[Ljava/lang/String;
    //   299: new 421	ize
    //   302: dup
    //   303: aload_0
    //   304: aload_3
    //   305: aload 7
    //   307: invokespecial 424	ize:<init>	(Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpeg;Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpegExecuteResponseCallback;Ljava/io/File;)V
    //   310: invokevirtual 226	com/tencent/biz/qqstory/utils/ffmpeg/FFmpeg:a	([Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpegExecuteResponseCallback;)V
    //   313: return
    //   314: astore_1
    //   315: aload_1
    //   316: athrow
    //   317: astore_1
    //   318: aconst_null
    //   319: astore 5
    //   321: aload_1
    //   322: athrow
    //   323: astore_1
    //   324: aload 5
    //   326: ifnull +8 -> 334
    //   329: aload 5
    //   331: invokevirtual 413	java/io/BufferedWriter:close	()V
    //   334: aload_1
    //   335: athrow
    //   336: astore_1
    //   337: aload_1
    //   338: athrow
    //   339: aload_1
    //   340: ldc_w 269
    //   343: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   346: pop
    //   347: aload_1
    //   348: ldc -28
    //   350: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   353: pop
    //   354: goto -83 -> 271
    //   357: astore_1
    //   358: aconst_null
    //   359: astore 5
    //   361: goto -37 -> 324
    //   364: astore_1
    //   365: aload 6
    //   367: astore 5
    //   369: goto -48 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	FFmpeg
    //   0	372	1	paramList	List
    //   0	372	2	paramString	String
    //   0	372	3	paramFFmpegExecuteResponseCallback	FFmpegExecuteResponseCallback
    //   0	372	4	paramBoolean	boolean
    //   84	284	5	localBufferedWriter1	java.io.BufferedWriter
    //   77	289	6	localBufferedWriter2	java.io.BufferedWriter
    //   38	268	7	localFile	File
    //   80	86	8	i	int
    // Exception table:
    //   from	to	target	type
    //   184	189	314	java/io/IOException
    //   60	79	317	java/io/IOException
    //   86	97	323	finally
    //   101	152	323	finally
    //   156	161	323	finally
    //   174	179	323	finally
    //   321	323	323	finally
    //   329	334	336	java/io/IOException
    //   60	79	357	finally
    //   86	97	364	java/io/IOException
    //   101	152	364	java/io/IOException
    //   156	161	364	java/io/IOException
    //   174	179	364	java/io/IOException
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Izi != null) && (!this.jdField_a_of_type_Izi.a()))
    {
      izn.a(this.jdField_a_of_type_Izi);
      this.jdField_a_of_type_Izi = null;
      this.d = 55537;
      if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit != null)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_JavaLangString != null)
        {
          File localFile = new File(this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.b("FFmpeg任务被强制Kill掉");
          this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(false);
        }
      }
    }
  }
  
  public void a(String[] paramArrayOfString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    if ((this.jdField_a_of_type_Izi != null) && (!this.jdField_a_of_type_Izi.a())) {
      throw new FFmpegCommandAlreadyRunningException("FFmpeg command is already running, you are only allowed to run single command at a time");
    }
    if (paramArrayOfString.length != 0)
    {
      Object localObject = paramArrayOfString[(paramArrayOfString.length - 1)];
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit = new FFmpegCommandUnit(paramArrayOfString, (String)localObject, paramFFmpegExecuteResponseCallback);
      int i = ((String)localObject).lastIndexOf("/");
      if ((i > -1) && (i < ((String)localObject).length() - 1))
      {
        localObject = new File(((String)localObject).substring(0, i + 1));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
      }
      paramFFmpegExecuteResponseCallback = new izd(this, paramFFmpegExecuteResponseCallback);
      paramArrayOfString = (String[])izn.a((String[])izn.a(new String[] { izl.a(this.jdField_a_of_type_AndroidContentContext) }, paramArrayOfString), new String[] { izl.b(this.jdField_a_of_type_AndroidContentContext) });
      this.jdField_a_of_type_Izi = new izi(this.jdField_a_of_type_AndroidContentContext, paramArrayOfString, this.jdField_b_of_type_Long, paramFFmpegExecuteResponseCallback);
      this.jdField_a_of_type_Izi.execute(new Void[0]);
      return;
    }
    throw new IllegalArgumentException("shell command cannot be empty");
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Izi == null) && (QLog.isColorLevel())) {
      QLog.e("FFmepg", 2, " AsyncTask is null !!!!");
    }
    return (this.jdField_a_of_type_Izi != null) && (!this.jdField_a_of_type_Izi.a());
  }
  
  public boolean a(String paramString)
  {
    return (this.g != null) && (paramString != null) && (paramString.equals(this.g));
  }
  
  public void b(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-filter_complex");
    localArrayList.add("overlay=0:0");
    localArrayList.add("-c:v");
    localArrayList.add("libx264");
    localArrayList.add("-preset");
    localArrayList.add("ultrafast");
    localArrayList.add("-crf");
    localArrayList.add("25");
    localArrayList.add("-c:a");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString3).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void b(ArrayList paramArrayList)
  {
    a(false);
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit);
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(0, paramArrayList);
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void b(List paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject1 = (String)paramList.get(i);
      Object localObject2 = new File((String)localObject1).getName().split("\\.");
      localObject2 = QQStoryConstant.s + localObject2[0] + ".ts";
      FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
      localFFmpegCommandUnit.i = 5;
      localFFmpegCommandUnit.jdField_a_of_type_JavaUtilArrayList = new FFmpeg.3(this, (String)localObject1, (String)localObject2);
      localFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new izf(this, paramFFmpegExecuteResponseCallback);
      localArrayList.add(localFFmpegCommandUnit);
      i += 1;
    }
    paramList = new FFmpegCommandUnit();
    Object localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
    paramList.i = 2;
    paramList.jdField_a_of_type_JavaUtilArrayList = new FFmpeg.5(this, (ArrayList)localObject1, paramString);
    paramList.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(paramList);
    a(localArrayList);
  }
  
  public void c(List paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\"concat:");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i));
      if (i != paramList.size() - 1) {
        localStringBuffer.append("|");
      }
      i += 1;
    }
    localStringBuffer.append("\"");
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    paramList = new ArrayList();
    paramList.add("-y");
    paramList.add("-i");
    paramList.add(new String(localStringBuffer));
    paramList.add("-c");
    paramList.add("copy");
    paramList.add("-bsf:a");
    paramList.add("aac_adtstoasc");
    paramList.add(paramString);
    a((String[])paramList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\ffmpeg\FFmpeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */