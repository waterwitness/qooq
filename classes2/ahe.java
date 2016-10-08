import com.hiar.sdk.camera.CameraPreviewHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ahe
  implements Runnable
{
  public ahe(CameraPreviewHandler paramCameraPreviewHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 12	ahe:a	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   6: invokestatic 30	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   9: ifnull +67 -> 76
    //   12: aload_0
    //   13: getfield 12	ahe:a	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   16: invokestatic 30	com/hiar/sdk/camera/CameraPreviewHandler:a	(Lcom/hiar/sdk/camera/CameraPreviewHandler;)Lcom/hiar/sdk/core/HiarqOptions;
    //   19: getfield 35	com/hiar/sdk/core/HiarqOptions:viewFinderEnable	Z
    //   22: istore 5
    //   24: iload 5
    //   26: ifeq +50 -> 76
    //   29: iload_3
    //   30: iconst_1
    //   31: iadd
    //   32: istore 4
    //   34: iload 4
    //   36: bipush 20
    //   38: if_icmpge +38 -> 76
    //   41: ldc2_w 36
    //   44: invokestatic 43	java/lang/Thread:sleep	(J)V
    //   47: iload 4
    //   49: istore_3
    //   50: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq -51 -> 2
    //   56: ldc 51
    //   58: iconst_2
    //   59: ldc 53
    //   61: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: iload 4
    //   66: istore_3
    //   67: goto -65 -> 2
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   75: return
    //   76: aload_0
    //   77: getfield 12	ahe:a	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   80: getfield 63	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_Long	J
    //   83: ldc2_w 64
    //   86: lcmp
    //   87: ifeq -12 -> 75
    //   90: aload_0
    //   91: getfield 12	ahe:a	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   94: getfield 68	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   97: astore_1
    //   98: aload_1
    //   99: monitorenter
    //   100: aload_0
    //   101: getfield 12	ahe:a	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   104: getfield 71	com/hiar/sdk/camera/CameraPreviewHandler:b	J
    //   107: invokestatic 77	com/hiar/sdk/core/NativeInterface:hiarqUnrealizeGallery	(J)I
    //   110: pop
    //   111: aload_0
    //   112: getfield 12	ahe:a	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   115: getfield 71	com/hiar/sdk/camera/CameraPreviewHandler:b	J
    //   118: invokestatic 80	com/hiar/sdk/core/NativeInterface:hiarqRemoveAllMarkers	(J)I
    //   121: pop
    //   122: aload_0
    //   123: getfield 12	ahe:a	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   126: getfield 63	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_Long	J
    //   129: invokestatic 83	com/hiar/sdk/core/NativeInterface:hiarqDestroy	(J)I
    //   132: pop
    //   133: aload_1
    //   134: monitorexit
    //   135: aload_0
    //   136: getfield 12	ahe:a	Lcom/hiar/sdk/camera/CameraPreviewHandler;
    //   139: ldc2_w 64
    //   142: putfield 63	com/hiar/sdk/camera/CameraPreviewHandler:jdField_a_of_type_Long	J
    //   145: return
    //   146: astore_2
    //   147: aload_1
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    //   151: astore_1
    //   152: goto -105 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	ahe
    //   70	2	1	localException1	Exception
    //   151	1	1	localException2	Exception
    //   146	4	2	localObject2	Object
    //   1	66	3	i	int
    //   32	33	4	j	int
    //   22	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	70	java/lang/Exception
    //   50	64	70	java/lang/Exception
    //   76	100	70	java/lang/Exception
    //   135	145	70	java/lang/Exception
    //   149	151	70	java/lang/Exception
    //   100	135	146	finally
    //   147	149	146	finally
    //   41	47	151	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ahe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */