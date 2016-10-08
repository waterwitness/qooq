package com.tencent.biz.qqstory.takevideo.publish;

import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;

public class EncodeVideoTask
  extends AsyncTask
{
  public static final int a = 0;
  protected static final String a = "Q.qqstory.publish:EncodeTask";
  public static final int b = 1;
  protected long a;
  protected final Handler a;
  protected final VideoProcessListener a;
  protected boolean a;
  protected byte[] a;
  protected final String b;
  protected byte[] b;
  protected int c;
  protected String c;
  protected String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    try
    {
      SLog.b("Q.qqstory.publish:EncodeTask", "LoadExtractedShortVideoSo :soLoadStatus=" + ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS);
      int i = VideoEnvironment.a("AVCodec", null, true);
      SLog.b("Q.qqstory.publish:EncodeTask", "LoadExtractedShortVideoSo :code=" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public EncodeVideoTask(Handler paramHandler, VideoProcessListener paramVideoProcessListener, String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (paramVideoProcessListener != null) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishVideoProcessListener = paramVideoProcessListener;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      paramVideoProcessListener = new VideoProcessListener.Empty();
    }
  }
  
  static long a(String paramString)
  {
    if (!FileUtils.b(paramString)) {}
    while (Build.VERSION.SDK_INT < 10) {
      return 0L;
    }
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      long l = Long.valueOf(localMediaMetadataRetriever.extractMetadata(9)).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 127	java/io/File
    //   5: dup
    //   6: getstatic 132	com/tencent/biz/qqstory/app/QQStoryConstant:n	Ljava/lang/String;
    //   9: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 138	java/io/File:mkdirs	()Z
    //   17: pop
    //   18: new 127	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: getfield 77	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokestatic 143	com/tencent/mobileqq/shortvideo/util/VidUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   32: astore_3
    //   33: new 30	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   40: aload_2
    //   41: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: getstatic 149	java/io/File:separator	Ljava/lang/String;
    //   47: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_3
    //   51: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc -105
    //   56: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_2
    //   63: new 153	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   66: dup
    //   67: aconst_null
    //   68: aload_0
    //   69: getfield 73	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   72: aload_0
    //   73: getfield 77	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   76: aload_2
    //   77: aconst_null
    //   78: invokespecial 156	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   81: astore_2
    //   82: aload_2
    //   83: iconst_0
    //   84: invokevirtual 159	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(Z)V
    //   87: aload_2
    //   88: iconst_0
    //   89: invokevirtual 161	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:b	(Z)V
    //   92: aload_2
    //   93: aload_0
    //   94: getfield 83	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_a_of_type_Boolean	Z
    //   97: invokevirtual 164	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:e	(Z)V
    //   100: aload_0
    //   101: getfield 79	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_b_of_type_ArrayOfByte	[B
    //   104: ifnull +15 -> 119
    //   107: aload_2
    //   108: aload_0
    //   109: getfield 79	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_b_of_type_ArrayOfByte	[B
    //   112: aload_0
    //   113: getfield 81	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_c_of_type_Int	I
    //   116: invokevirtual 167	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	([BI)V
    //   119: aload_2
    //   120: invokevirtual 170	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   123: aload_0
    //   124: aload_2
    //   125: getfield 172	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	Ljava/lang/String;
    //   128: putfield 174	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   131: aload_0
    //   132: getfield 174	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   135: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +96 -> 234
    //   141: new 127	java/io/File
    //   144: dup
    //   145: aload_0
    //   146: getfield 174	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore_3
    //   153: aload_3
    //   154: invokevirtual 183	java/io/File:exists	()Z
    //   157: ifeq +77 -> 234
    //   160: new 30	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   167: aload_3
    //   168: invokevirtual 186	java/io/File:getParent	()Ljava/lang/String;
    //   171: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: getstatic 149	java/io/File:separator	Ljava/lang/String;
    //   177: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc -68
    //   182: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 192	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   191: new 194	java/io/FileInputStream
    //   194: dup
    //   195: aload_0
    //   196: getfield 174	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   199: invokespecial 195	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   202: astore_2
    //   203: aload_0
    //   204: aload_2
    //   205: aload_3
    //   206: invokevirtual 198	java/io/File:length	()J
    //   209: invokestatic 204	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   212: putfield 206	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_a_of_type_ArrayOfByte	[B
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 206	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_a_of_type_ArrayOfByte	[B
    //   220: invokestatic 212	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   223: putfield 214	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:d	Ljava/lang/String;
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 217	java/io/FileInputStream:close	()V
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 174	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   239: invokestatic 219	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:a	(Ljava/lang/String;)J
    //   242: putfield 221	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_a_of_type_Long	J
    //   245: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +43 -> 291
    //   251: ldc -28
    //   253: iconst_2
    //   254: new 30	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   261: ldc -26
    //   263: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: getfield 174	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   270: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc -24
    //   275: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: getfield 214	com/tencent/biz/qqstory/takevideo/publish/EncodeVideoTask:d	Ljava/lang/String;
    //   282: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: iconst_0
    //   292: invokestatic 240	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: astore_2
    //   296: aload_2
    //   297: areturn
    //   298: astore_1
    //   299: aload_1
    //   300: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   303: goto -69 -> 234
    //   306: astore_2
    //   307: aload_2
    //   308: invokevirtual 242	java/io/FileNotFoundException:printStackTrace	()V
    //   311: iconst_1
    //   312: invokestatic 240	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: astore_3
    //   316: aload_3
    //   317: astore_2
    //   318: aload_1
    //   319: ifnull -23 -> 296
    //   322: aload_1
    //   323: invokevirtual 217	java/io/FileInputStream:close	()V
    //   326: aload_3
    //   327: areturn
    //   328: astore_1
    //   329: aload_1
    //   330: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   333: aload_3
    //   334: areturn
    //   335: astore_1
    //   336: aconst_null
    //   337: astore_2
    //   338: aload_2
    //   339: ifnull +7 -> 346
    //   342: aload_2
    //   343: invokevirtual 217	java/io/FileInputStream:close	()V
    //   346: aload_1
    //   347: athrow
    //   348: astore_2
    //   349: aload_2
    //   350: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   353: goto -7 -> 346
    //   356: astore_1
    //   357: goto -19 -> 338
    //   360: astore_3
    //   361: aload_1
    //   362: astore_2
    //   363: aload_3
    //   364: astore_1
    //   365: goto -27 -> 338
    //   368: astore_3
    //   369: aload_2
    //   370: astore_1
    //   371: aload_3
    //   372: astore_2
    //   373: goto -66 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	EncodeVideoTask
    //   0	376	1	paramVarArgs	Void[]
    //   12	285	2	localObject1	Object
    //   306	2	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   317	26	2	localObject2	Object
    //   348	2	2	localIOException	java.io.IOException
    //   362	11	2	localObject3	Object
    //   32	302	3	localObject4	Object
    //   360	4	3	localObject5	Object
    //   368	4	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   230	234	298	java/io/IOException
    //   191	203	306	java/io/FileNotFoundException
    //   322	326	328	java/io/IOException
    //   191	203	335	finally
    //   342	346	348	java/io/IOException
    //   203	226	356	finally
    //   307	311	360	finally
    //   203	226	368	java/io/FileNotFoundException
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.record.NewStoryTakeVideoActivity", 2, "generate video result= " + paramInteger);
    }
    VideoProcessListener localVideoProcessListener = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishVideoProcessListener;
    switch (paramInteger.intValue())
    {
    default: 
      localVideoProcessListener.a(false, null, null, null, 0L);
      return;
    }
    localVideoProcessListener.a(true, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.d, this.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\EncodeVideoTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */