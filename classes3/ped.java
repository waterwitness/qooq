import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ped
  implements Runnable
{
  public ped(VideoFramesFetcher paramVideoFramesFetcher)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 31	com/tencent/maxvideo/trim/TrimNative:isGetThumbnailReady	()Z
    //   3: ifne +50 -> 53
    //   6: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +11 -> 20
    //   12: ldc 38
    //   14: iconst_2
    //   15: ldc 40
    //   17: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: aload_2
    //   22: getfield 49	pee:jdField_a_of_type_Int	I
    //   25: i2l
    //   26: aload_2
    //   27: getfield 52	pee:b	I
    //   30: i2l
    //   31: invokestatic 57	com/tencent/mobileqq/activity/richmedia/trimvideo/video/utils/ThumbnailUtils:b	(JJ)Landroid/graphics/Bitmap;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnonnull +71 -> 107
    //   39: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +11 -> 53
    //   45: ldc 38
    //   47: iconst_2
    //   48: ldc 59
    //   50: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 12	ped:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   57: invokestatic 64	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
    //   60: ifne +136 -> 196
    //   63: aload_0
    //   64: getfield 12	ped:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   67: invokestatic 67	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
    //   70: ifnull +126 -> 196
    //   73: aload_0
    //   74: getfield 12	ped:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   77: invokestatic 67	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
    //   80: invokeinterface 73 1 0
    //   85: checkcast 46	pee
    //   88: astore_2
    //   89: aload_0
    //   90: getfield 12	ped:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   93: invokestatic 64	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
    //   96: istore 4
    //   98: iload 4
    //   100: ifeq -79 -> 21
    //   103: invokestatic 76	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   106: return
    //   107: new 78	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame
    //   110: dup
    //   111: invokespecial 79	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:<init>	()V
    //   114: astore_3
    //   115: aload_3
    //   116: aload_1
    //   117: getstatic 85	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   120: iconst_1
    //   121: invokevirtual 91	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   124: putfield 94	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   127: aload_3
    //   128: aload_2
    //   129: getfield 49	pee:jdField_a_of_type_Int	I
    //   132: aload_0
    //   133: getfield 12	ped:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   136: invokestatic 97	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:b	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)I
    //   139: idiv
    //   140: putfield 98	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:jdField_a_of_type_Int	I
    //   143: aload_1
    //   144: invokevirtual 101	android/graphics/Bitmap:recycle	()V
    //   147: aload_0
    //   148: getfield 12	ped:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   151: invokestatic 104	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FrameAdapter;
    //   154: aload_3
    //   155: invokevirtual 109	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FrameAdapter:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame;)V
    //   158: aload_0
    //   159: getfield 12	ped:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   162: invokestatic 112	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/ConcurrentHashMap;
    //   165: aload_2
    //   166: getfield 49	pee:jdField_a_of_type_Int	I
    //   169: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: goto -123 -> 53
    //   179: astore_1
    //   180: ldc 38
    //   182: iconst_2
    //   183: ldc 126
    //   185: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload_1
    //   189: invokevirtual 132	java/lang/InterruptedException:printStackTrace	()V
    //   192: invokestatic 76	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   195: return
    //   196: invokestatic 76	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   199: return
    //   200: astore_1
    //   201: invokestatic 76	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	ped
    //   34	110	1	localBitmap	android.graphics.Bitmap
    //   179	10	1	localInterruptedException	InterruptedException
    //   200	5	1	localObject	Object
    //   21	145	2	localpee	pee
    //   114	41	3	localFrame	com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor.Frame
    //   96	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   21	35	179	java/lang/InterruptedException
    //   39	53	179	java/lang/InterruptedException
    //   53	98	179	java/lang/InterruptedException
    //   107	176	179	java/lang/InterruptedException
    //   21	35	200	finally
    //   39	53	200	finally
    //   53	98	200	finally
    //   107	176	200	finally
    //   180	192	200	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */