package com.tencent.mobileqq.shortvideo.hwcodec;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import uqo;

public class SVHwEncoder
{
  public static final int A = -20;
  public static final int B = -21;
  public static final int C = -22;
  public static final int D = -23;
  public static final int E = -23;
  public static final int F = -40;
  public static final int H = 99000;
  public static final int I = 16;
  private static final int J = 3;
  private static final int K = 300;
  private static final int L = 1;
  private static final int M = 30;
  private static final int N = 480000;
  private static final int O = 30;
  private static final int P = 10;
  private static final int Q = 19;
  private static final int R = 190;
  private static final int S = 21;
  private static final int T = 2130708361;
  private static final int U = 3;
  private static final int V = 3;
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "hw_video_timestamp";
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 2;
  private static final String jdField_b_of_type_JavaLangString = "hw_audio_timestamp";
  private static final boolean jdField_b_of_type_Boolean = false;
  public static final int c = 1;
  private static final String jdField_c_of_type_JavaLangString = "hw_video_writesample";
  private static final boolean jdField_c_of_type_Boolean = false;
  public static final int d = 2;
  private static final String jdField_d_of_type_JavaLangString = "hw_audio_writesample";
  private static final boolean jdField_d_of_type_Boolean = false;
  public static final int e = 64000;
  private static final String jdField_e_of_type_JavaLangString = "hw_media_muxer_seg";
  private static final boolean jdField_e_of_type_Boolean = false;
  public static final int f = 128000;
  private static final String jdField_f_of_type_JavaLangString = "hw_av_merge_segment";
  private static final boolean jdField_f_of_type_Boolean = false;
  public static final int g = 0;
  private static final String jdField_g_of_type_JavaLangString = "hw_video_write_frame";
  public static final int h = -1;
  private static final String jdField_h_of_type_JavaLangString = "hw_audio_write_frame";
  public static final int i = -2;
  private static final String jdField_i_of_type_JavaLangString = "hw_video_encode_frame";
  public static final int j = -3;
  private static final String jdField_j_of_type_JavaLangString = "hw_audio_encode_frame";
  public static final int k = -4;
  private static final String jdField_k_of_type_JavaLangString = "hw_smooth_time_stamp";
  private static boolean jdField_k_of_type_Boolean = false;
  public static final int l = -5;
  private static final String l = "hw_video_bitrate_set";
  public static final int m = -6;
  private static final String m = "hw_video_callback_msg";
  public static final int n = -7;
  private static final String n = "hw_video_time_used_msg";
  public static final int o = -8;
  private static final String o = "hw_video_segment_notify_msg";
  public static final int p = -9;
  private static final String p = "hw_intel_x86__err_msg";
  public static final int q = -10;
  private static final String q;
  public static final int r = -11;
  private static final String r = "audio/mp4a-latm";
  public static final int s = -12;
  public static final int t = -13;
  public static final int u = -14;
  public static final int v = -15;
  public static final int w = -16;
  public static final int x = -17;
  public static final int y = -18;
  public static final int z = -19;
  public int G = 21;
  private int W;
  private int X;
  private volatile int Y = 480000;
  private int Z = 8000;
  private double jdField_a_of_type_Double;
  private volatile float jdField_a_of_type_Float = 30.0F;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private uqo jdField_a_of_type_Uqo;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  private int aa = 1;
  private int ab = 64000;
  private int ac = 2;
  private int ad = -1;
  private int ae = -1;
  private int af;
  private int ag;
  private int ah;
  private double jdField_b_of_type_Double;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private boolean jdField_g_of_type_Boolean;
  private volatile boolean jdField_h_of_type_Boolean;
  private volatile boolean jdField_i_of_type_Boolean;
  private volatile boolean jdField_j_of_type_Boolean;
  private String s;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    q = SVHwEncoder.class.getSimpleName();
  }
  
  public SVHwEncoder()
  {
    this.c = new ArrayList();
  }
  
  private native boolean adjustDstresolution(int[] paramArrayOfInt);
  
  public int a(ArrayList paramArrayList)
  {
    try
    {
      int i1 = paramArrayList.size();
      return i1;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public int a(List paramList, String paramString)
  {
    if (paramList.size() <= 0) {
      return -1;
    }
    int i1 = 0;
    int i2 = -1;
    while (i1 < paramList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = SVHwCodec.a((MediaCodecInfo)paramList.get(i1), paramString);
      a("selectAudioCodec", "name=" + ((MediaCodecInfo)paramList.get(i1)).getName());
      int i3 = i2;
      if (localCodecCapabilities.profileLevels != null)
      {
        if (localCodecCapabilities.profileLevels.length <= 0) {
          i3 = i2;
        }
      }
      else
      {
        i1 += 1;
        i2 = i3;
        continue;
      }
      int i4 = 0;
      for (;;)
      {
        i3 = i2;
        if (i4 >= localCodecCapabilities.profileLevels.length) {
          break;
        }
        if (localCodecCapabilities.profileLevels[i4].profile == 2)
        {
          i3 = i1;
          break;
        }
        i4 += 1;
      }
    }
    return i2;
  }
  
  public SVHwEncoder.HwFrame a()
  {
    Object localObject2 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject4;
    if (!this.h)
    {
      localObject1 = localObject4;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject1 = this.jdField_a_of_type_JavaLangObject;
          localObject2 = localObject3;
        }
      }
    }
    do
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject2 = (SVHwEncoder.HwFrame)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        }
        if ((localObject2 == null) || (((SVHwEncoder.HwFrame)localObject2).jdField_a_of_type_ArrayOfByte == null))
        {
          localObject1 = new byte[this.W * this.X * 3 / 2];
          localObject2 = new SVHwEncoder.HwFrame();
          ((SVHwEncoder.HwFrame)localObject2).jdField_a_of_type_ArrayOfByte = ((byte[])localObject1);
          ((SVHwEncoder.HwFrame)localObject2).jdField_a_of_type_Float = -1.0F;
          ((SVHwEncoder.HwFrame)localObject2).c = -1;
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d(q, 2, "getRecycleFrame[allocate frame]");
            localObject1 = localObject2;
          }
          return (SVHwEncoder.HwFrame)localObject1;
        }
      }
      finally {}
      localObject1 = localHwFrame;
    } while (!QLog.isColorLevel());
    QLog.d(q, 2, "getRecycleFrame[cache frame]");
    return localHwFrame;
  }
  
  public SVHwEncoder.HwFrame a(ArrayList paramArrayList)
  {
    SVHwEncoder.HwFrame localHwFrame = null;
    try
    {
      if (paramArrayList.size() > 0) {
        localHwFrame = (SVHwEncoder.HwFrame)paramArrayList.get(0);
      }
      return localHwFrame;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_ArrayOfInt[0] = this.W;
    this.jdField_a_of_type_ArrayOfInt[1] = this.X;
    this.jdField_a_of_type_ArrayOfInt[2] = 0;
    this.jdField_a_of_type_ArrayOfInt[3] = 0;
    try
    {
      bool = adjustDstresolution(this.jdField_a_of_type_ArrayOfInt);
      if (!bool)
      {
        this.W -= this.W % 16;
        this.X -= this.X % 16;
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        boolean bool = false;
      }
      this.W = this.jdField_a_of_type_ArrayOfInt[2];
      this.X = this.jdField_a_of_type_ArrayOfInt[3];
    }
  }
  
  public void a(double paramDouble1, double paramDouble2, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.ag = 320;
    if (RMVideoStateMgr.jdField_a_of_type_Boolean) {
      this.ag = paramInt;
    }
    this.ah = ((int)(this.ag / paramFloat));
    if (this.ah % 2 > 0) {
      this.ah -= 1;
    }
  }
  
  public void a(float paramFloat, int paramInt)
  {
    SVHwEncoder.HwFrame localHwFrame = new SVHwEncoder.HwFrame();
    localHwFrame.jdField_a_of_type_Boolean = true;
    localHwFrame.jdField_b_of_type_Boolean = true;
    localHwFrame.jdField_a_of_type_Float = paramFloat;
    localHwFrame.c = paramInt;
    a(localHwFrame, true);
    localHwFrame = new SVHwEncoder.HwFrame();
    localHwFrame.jdField_a_of_type_Boolean = true;
    localHwFrame.jdField_b_of_type_Boolean = false;
    a(localHwFrame, false);
  }
  
  public void a(int paramInt)
  {
    this.ae = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.jdField_a_of_type_Float = paramInt1;
    }
    if (paramInt2 > 0) {
      this.Y = paramInt2;
    }
    a("hw_video_bitrate_set", "configVideoBitrate mVideoBitrate=" + this.Y);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 8000) || (paramInt1 == 16000) || (paramInt1 == 44100)) {
      this.Z = paramInt1;
    }
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.aa = paramInt2;
    }
    if ((paramInt3 == 64000) || (paramInt3 == 128000)) {
      this.ab = paramInt3;
    }
    if ((paramInt4 == 1) || (paramInt4 == 2)) {
      this.ac = paramInt4;
    }
  }
  
  /* Error */
  public void a(SVHwEncoder.HwFrame paramHwFrame, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 225	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:h	Z
    //   6: ifne +65 -> 71
    //   9: iload_2
    //   10: ifeq +64 -> 74
    //   13: aload_0
    //   14: getfield 198	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: ifnull +57 -> 74
    //   20: aload_0
    //   21: getfield 198	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   24: aload_1
    //   25: invokevirtual 346	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   28: pop
    //   29: aload_0
    //   30: ldc 70
    //   32: new 259	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 348
    //   42: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: getfield 329	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Boolean	Z
    //   49: invokevirtual 351	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 353
    //   55: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: getfield 355	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_b_of_type_Int	I
    //   62: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 275	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: aload_0
    //   75: getfield 200	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	Ljava/util/ArrayList;
    //   78: ifnull -7 -> 71
    //   81: aload_0
    //   82: getfield 200	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	Ljava/util/ArrayList;
    //   85: aload_1
    //   86: invokevirtual 346	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: aload_0
    //   91: ldc 74
    //   93: new 259	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 348
    //   103: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: getfield 329	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Boolean	Z
    //   110: invokevirtual 351	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   113: ldc_w 353
    //   116: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: getfield 355	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_b_of_type_Int	I
    //   123: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokevirtual 275	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -61 -> 71
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	SVHwEncoder
    //   0	140	1	paramHwFrame	SVHwEncoder.HwFrame
    //   0	140	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	135	finally
    //   13	71	135	finally
    //   74	132	135	finally
  }
  
  public void a(SVHwOutputNotify paramSVHwOutputNotify, SVHwDataSource paramSVHwDataSource, boolean paramBoolean)
  {
    this.jdField_a_of_type_Uqo = new uqo(this, this.s, paramSVHwOutputNotify, paramSVHwDataSource, paramBoolean, 99000);
    new Thread(this.jdField_a_of_type_Uqo, "encode_qq" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement()).start();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.s = paramString;
    this.W = paramInt1;
    this.X = paramInt2;
    a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!k) && (QLog.isColorLevel())) {
      QLog.d(q, 2, paramString1 + ":" + paramString2);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, String paramString, int paramInt)
  {
    if (paramByteBuffer == null) {
      a(paramString, "Configdata buferData=null");
    }
    do
    {
      return;
      if (paramBufferInfo.size != 0) {
        a(paramString, "Configdata size=" + paramBufferInfo.size);
      }
    } while (paramBufferInfo.size >= paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = 0;
    while (paramInt < paramBufferInfo.size)
    {
      paramByteBuffer.position(paramBufferInfo.offset + paramInt);
      localStringBuilder.append(paramByteBuffer.get()).append(',');
      paramInt += 1;
    }
    a(paramString, "Configdata =" + localStringBuilder.toString());
  }
  
  public void a(ArrayList paramArrayList)
  {
    try
    {
      if (paramArrayList.size() > 0) {
        paramArrayList.remove(0);
      }
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = true;
    this.ad = paramInt1;
    this.ae = paramInt2;
    paramInt1 = paramInt3;
    if (paramInt3 != 0)
    {
      paramInt1 = paramInt3;
      if (paramInt3 != 90)
      {
        paramInt1 = paramInt3;
        if (paramInt3 != 180)
        {
          paramInt1 = paramInt3;
          if (paramInt3 != 270) {
            paramInt1 = 0;
          }
        }
      }
    }
    this.af = paramInt1;
    if (this.ae <= 0)
    {
      this.ae = 1000;
      return false;
    }
    if (this.ad <= 0)
    {
      this.ad = 1;
      return false;
    }
    return true;
  }
  
  public boolean a(SVHwEncoder.HwFrame paramHwFrame)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 3) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < 3)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramHwFrame);
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.h = true;
  }
  
  public void b(SVHwOutputNotify paramSVHwOutputNotify, SVHwDataSource paramSVHwDataSource, boolean paramBoolean)
  {
    this.jdField_a_of_type_Uqo = new uqo(this, this.s, paramSVHwOutputNotify, paramSVHwDataSource, paramBoolean, 0);
    this.jdField_a_of_type_Uqo.run();
  }
  
  public void b(ArrayList paramArrayList)
  {
    try
    {
      paramArrayList.clear();
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public void c()
  {
    this.h = true;
    this.i = true;
  }
  
  public void d()
  {
    try
    {
      SVHwEncoder.HwFrame localHwFrame = new SVHwEncoder.HwFrame();
      localHwFrame.jdField_a_of_type_Boolean = true;
      localHwFrame.jdField_b_of_type_Boolean = true;
      localHwFrame.jdField_a_of_type_Float = 30.0F;
      localHwFrame.c = 480000;
      this.jdField_b_of_type_JavaUtilArrayList.add(localHwFrame);
      localHwFrame = new SVHwEncoder.HwFrame();
      localHwFrame.jdField_a_of_type_Boolean = true;
      localHwFrame.jdField_b_of_type_Boolean = false;
      this.c.add(localHwFrame);
      a("hw_video_write_frame", "addMediaEndFrame finish...");
      a("hw_audio_write_frame", "addMediaEndFrame finish...");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void e()
  {
    this.j = false;
    this.jdField_a_of_type_Uqo.f();
  }
  
  public void f()
  {
    this.j = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\hwcodec\SVHwEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */