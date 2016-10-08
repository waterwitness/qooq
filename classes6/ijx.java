import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantDownloadEvent;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantItem;
import com.tencent.biz.qqstory.model.pendant.PendantManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class ijx
  extends SimpleJob
  implements DownloadProgressListener
{
  private final Downloader jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader;
  private final NewStoryPendantItem jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem;
  
  public ijx(NewStoryPendantItem paramNewStoryPendantItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramNewStoryPendantItem == null) {
      throw new IllegalArgumentException("newStoryPendantItem should not be null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader = new DownloaderImp();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem = paramNewStoryPendantItem;
  }
  
  protected NewStoryPendantItem a(JobContext paramJobContext, Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.d, PendantManager.c(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem), 0L);
    return this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem;
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +296 -> 297
    //   4: aload_0
    //   5: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   8: invokestatic 53	com/tencent/biz/qqstory/model/pendant/PendantManager:c	(Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   16: invokestatic 62	com/tencent/biz/qqstory/model/pendant/PendantManager:b	(Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;)Ljava/lang/String;
    //   19: astore_3
    //   20: ldc 64
    //   22: ldc 66
    //   24: aload_1
    //   25: invokestatic 71	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   28: ldc 64
    //   30: ldc 73
    //   32: aload_3
    //   33: invokestatic 71	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   36: aload_1
    //   37: aload_3
    //   38: invokestatic 78	com/tencent/biz/common/util/ZipUtils:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: istore_2
    //   42: iload_2
    //   43: ifne +192 -> 235
    //   46: ldc 64
    //   48: ldc 80
    //   50: invokestatic 83	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: new 85	java/io/File
    //   56: dup
    //   57: aload_3
    //   58: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: invokestatic 89	com/tencent/biz/qqstory/model/pendant/PendantManager:a	(Ljava/io/File;)Z
    //   64: ifeq +68 -> 132
    //   67: aload_0
    //   68: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   71: aload_3
    //   72: invokevirtual 91	com/tencent/biz/qqstory/model/pendant/NewStoryPendantItem:a	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   79: iconst_0
    //   80: iconst_0
    //   81: invokevirtual 94	com/tencent/biz/qqstory/model/pendant/NewStoryPendantItem:a	(ZI)V
    //   84: invokestatic 100	com/tribe/async/dispatch/Dispatchers:get	()Lcom/tribe/async/dispatch/Dispatcher;
    //   87: new 102	com/tencent/biz/qqstory/model/pendant/NewStoryPendantDownloadEvent
    //   90: dup
    //   91: aload_0
    //   92: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   95: iconst_0
    //   96: ldc 104
    //   98: invokespecial 107	com/tencent/biz/qqstory/model/pendant/NewStoryPendantDownloadEvent:<init>	(Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;ILjava/lang/String;)V
    //   101: invokeinterface 113 2 0
    //   106: ldc 115
    //   108: ldc 117
    //   110: iconst_0
    //   111: iconst_0
    //   112: iconst_0
    //   113: anewarray 119	java/lang/String
    //   116: invokestatic 124	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   119: new 85	java/io/File
    //   122: dup
    //   123: aload_1
    //   124: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   127: invokevirtual 128	java/io/File:delete	()Z
    //   130: pop
    //   131: return
    //   132: ldc 64
    //   134: ldc -126
    //   136: invokestatic 132	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: ldc 64
    //   141: ldc -122
    //   143: invokestatic 136	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_3
    //   147: invokestatic 141	com/tencent/biz/qqstory/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   150: pop
    //   151: aload_0
    //   152: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   155: aconst_null
    //   156: invokevirtual 91	com/tencent/biz/qqstory/model/pendant/NewStoryPendantItem:a	(Ljava/lang/String;)V
    //   159: aload_0
    //   160: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   163: iconst_0
    //   164: iconst_m1
    //   165: invokevirtual 94	com/tencent/biz/qqstory/model/pendant/NewStoryPendantItem:a	(ZI)V
    //   168: invokestatic 100	com/tribe/async/dispatch/Dispatchers:get	()Lcom/tribe/async/dispatch/Dispatcher;
    //   171: new 102	com/tencent/biz/qqstory/model/pendant/NewStoryPendantDownloadEvent
    //   174: dup
    //   175: aload_0
    //   176: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   179: iconst_m1
    //   180: ldc -113
    //   182: invokespecial 107	com/tencent/biz/qqstory/model/pendant/NewStoryPendantDownloadEvent:<init>	(Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;ILjava/lang/String;)V
    //   185: invokeinterface 113 2 0
    //   190: ldc 115
    //   192: ldc 117
    //   194: iconst_0
    //   195: sipush 64535
    //   198: iconst_0
    //   199: anewarray 119	java/lang/String
    //   202: invokestatic 124	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   205: goto -86 -> 119
    //   208: astore_3
    //   209: new 85	java/io/File
    //   212: dup
    //   213: aload_1
    //   214: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   217: invokevirtual 128	java/io/File:delete	()Z
    //   220: pop
    //   221: aload_3
    //   222: athrow
    //   223: astore_3
    //   224: ldc 64
    //   226: ldc -111
    //   228: aload_3
    //   229: invokestatic 148	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: goto -81 -> 151
    //   235: ldc 64
    //   237: ldc -106
    //   239: invokestatic 132	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload_0
    //   243: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   246: aconst_null
    //   247: invokevirtual 91	com/tencent/biz/qqstory/model/pendant/NewStoryPendantItem:a	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   254: iconst_0
    //   255: iload_2
    //   256: invokevirtual 94	com/tencent/biz/qqstory/model/pendant/NewStoryPendantItem:a	(ZI)V
    //   259: invokestatic 100	com/tribe/async/dispatch/Dispatchers:get	()Lcom/tribe/async/dispatch/Dispatcher;
    //   262: new 102	com/tencent/biz/qqstory/model/pendant/NewStoryPendantDownloadEvent
    //   265: dup
    //   266: aload_0
    //   267: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   270: iload_2
    //   271: ldc -104
    //   273: invokespecial 107	com/tencent/biz/qqstory/model/pendant/NewStoryPendantDownloadEvent:<init>	(Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;ILjava/lang/String;)V
    //   276: invokeinterface 113 2 0
    //   281: ldc 115
    //   283: ldc 117
    //   285: iconst_0
    //   286: iload_2
    //   287: iconst_0
    //   288: anewarray 119	java/lang/String
    //   291: invokestatic 124	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   294: goto -175 -> 119
    //   297: ldc 64
    //   299: ldc -102
    //   301: iconst_2
    //   302: anewarray 156	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: iload_2
    //   308: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   311: aastore
    //   312: dup
    //   313: iconst_1
    //   314: aload_1
    //   315: aastore
    //   316: invokestatic 166	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   319: aload_0
    //   320: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   323: aconst_null
    //   324: invokevirtual 91	com/tencent/biz/qqstory/model/pendant/NewStoryPendantItem:a	(Ljava/lang/String;)V
    //   327: aload_0
    //   328: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   331: iconst_0
    //   332: iload_2
    //   333: invokevirtual 94	com/tencent/biz/qqstory/model/pendant/NewStoryPendantItem:a	(ZI)V
    //   336: invokestatic 100	com/tribe/async/dispatch/Dispatchers:get	()Lcom/tribe/async/dispatch/Dispatcher;
    //   339: new 102	com/tencent/biz/qqstory/model/pendant/NewStoryPendantDownloadEvent
    //   342: dup
    //   343: aload_0
    //   344: getfield 39	ijx:jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem	Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;
    //   347: iload_2
    //   348: ldc -88
    //   350: invokespecial 107	com/tencent/biz/qqstory/model/pendant/NewStoryPendantDownloadEvent:<init>	(Lcom/tencent/biz/qqstory/model/pendant/NewStoryPendantItem;ILjava/lang/String;)V
    //   353: invokeinterface 113 2 0
    //   358: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	ijx
    //   0	359	1	paramString	String
    //   0	359	2	paramInt	int
    //   19	128	3	str	String
    //   208	14	3	localObject	Object
    //   223	6	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   36	42	208	finally
    //   46	119	208	finally
    //   132	139	208	finally
    //   139	151	208	finally
    //   151	205	208	finally
    //   224	232	208	finally
    //   235	294	208	finally
    //   139	151	223	java/lang/Exception
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    float f = (float)paramLong1 * 1.0F / (float)paramLong2;
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a(f);
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a(true, 0);
    Dispatchers.get().dispatch(new NewStoryPendantDownloadEvent(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem, f));
  }
  
  public void a(String paramString1, String paramString2)
  {
    SLog.a("PendantManager", "onDownloadStart : url = %s, path = %s", paramString1, paramString2);
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a(0.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a(true, 0);
    Dispatchers.get().dispatch(new NewStoryPendantDownloadEvent(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem, 0.0F));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */