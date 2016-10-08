package com.hiar.sdk.core;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NativeInterface
{
  private static boolean loadSoSuccess;
  private static boolean soLoaded;
  
  public NativeInterface()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static native int hiarqAddMarker(long paramLong, String paramString1, String paramString2);
  
  public static native int hiarqCreate();
  
  public static native int hiarqDestroy(long paramLong);
  
  public static native int hiarqGetAlgorithmVersion(HiarqVersion[] paramArrayOfHiarqVersion);
  
  public static native int hiarqGetGLPose(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public static native int hiarqGetGLProjectMatrix(HiarqCameraCalib paramHiarqCameraCalib, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat);
  
  public static native int hiarqGetGallery(long paramLong);
  
  public static native int hiarqGetKeyVersion(String paramString, HiarqVersion[] paramArrayOfHiarqVersion);
  
  public static native int hiarqGetMarkerCount(int paramInt);
  
  public static native int hiarqGetMarkerInfo(long paramLong, int paramInt, HiarqMarkerInfo[] paramArrayOfHiarqMarkerInfo);
  
  public static native int hiarqGetPreferredCameraInfo(HiarqImageSize[] paramArrayOfHiarqImageSize, Integer paramInteger, HiarqCameraCalib paramHiarqCameraCalib);
  
  public static native int hiarqIsGalleryRealized(int paramInt1, int paramInt2);
  
  public static native int hiarqRealizeGallery(long paramLong);
  
  public static native int hiarqRecognize(long paramLong, byte[] paramArrayOfByte, HiarqTargetInfo[] paramArrayOfHiarqTargetInfo);
  
  public static native int hiarqRegisterLogCallback(HiarqLog paramHiarqLog);
  
  public static native int hiarqRemoveAllMarkers(long paramLong);
  
  public static native int hiarqRemoveMarker(long paramLong, int paramInt);
  
  public static native int hiarqSetCameraInfo(long paramLong, HiarqImageSize paramHiarqImageSize, HiarqCameraCalib paramHiarqCameraCalib);
  
  public static native int hiarqSetOptions(long paramLong, HiarqOptions paramHiarqOptions);
  
  public static native int hiarqTrack(long paramLong, byte[] paramArrayOfByte, HiarqTargetInfo[] paramArrayOfHiarqTargetInfo);
  
  public static native int hiarqUnrealizeGallery(long paramLong);
  
  /* Error */
  public static boolean loadNativeLibrary()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 2
    //   8: monitorenter
    //   9: ldc 60
    //   11: invokestatic 66	com/tencent/mobileqq/ar/ArNativeSoLoader:a	(Ljava/lang/String;)Z
    //   14: ifeq +11 -> 25
    //   17: ldc 68
    //   19: invokestatic 66	com/tencent/mobileqq/ar/ArNativeSoLoader:a	(Ljava/lang/String;)Z
    //   22: ifne +28 -> 50
    //   25: iload 4
    //   27: istore_3
    //   28: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +14 -> 45
    //   34: ldc 75
    //   36: iconst_2
    //   37: ldc 77
    //   39: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iload 4
    //   44: istore_3
    //   45: ldc 2
    //   47: monitorexit
    //   48: iload_3
    //   49: ireturn
    //   50: getstatic 83	com/hiar/sdk/core/NativeInterface:soLoaded	Z
    //   53: ifeq +10 -> 63
    //   56: getstatic 85	com/hiar/sdk/core/NativeInterface:loadSoSuccess	Z
    //   59: istore_3
    //   60: goto -15 -> 45
    //   63: iconst_1
    //   64: putstatic 83	com/hiar/sdk/core/NativeInterface:soLoaded	Z
    //   67: ldc 60
    //   69: invokestatic 88	com/tencent/mobileqq/ar/ArNativeSoLoader:a	(Ljava/lang/String;)B
    //   72: istore_1
    //   73: ldc 68
    //   75: invokestatic 88	com/tencent/mobileqq/ar/ArNativeSoLoader:a	(Ljava/lang/String;)B
    //   78: istore_2
    //   79: iload 5
    //   81: istore_3
    //   82: iload_1
    //   83: ifne +12 -> 95
    //   86: iload 5
    //   88: istore_3
    //   89: iload_2
    //   90: ifne +5 -> 95
    //   93: iconst_1
    //   94: istore_3
    //   95: iload_3
    //   96: putstatic 85	com/hiar/sdk/core/NativeInterface:loadSoSuccess	Z
    //   99: getstatic 85	com/hiar/sdk/core/NativeInterface:loadSoSuccess	Z
    //   102: istore_3
    //   103: goto -58 -> 45
    //   106: astore_0
    //   107: iconst_0
    //   108: putstatic 85	com/hiar/sdk/core/NativeInterface:loadSoSuccess	Z
    //   111: goto -12 -> 99
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   106	1	0	localThrowable	Throwable
    //   114	5	0	localObject	Object
    //   72	11	1	i	int
    //   78	12	2	j	int
    //   27	76	3	bool1	boolean
    //   4	39	4	bool2	boolean
    //   1	86	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   67	79	106	java/lang/Throwable
    //   95	99	106	java/lang/Throwable
    //   9	25	114	finally
    //   28	42	114	finally
    //   50	60	114	finally
    //   63	67	114	finally
    //   67	79	114	finally
    //   95	99	114	finally
    //   99	103	114	finally
    //   107	111	114	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\core\NativeInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */