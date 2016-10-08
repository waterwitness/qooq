import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;

public class upt
  implements Runnable
{
  public upt(PtvTemplateManager paramPtvTemplateManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	upt:a	Lcom/tencent/mobileqq/shortvideo/PtvTemplateManager;
    //   4: getfield 32	com/tencent/mobileqq/shortvideo/PtvTemplateManager:a	Ljava/util/ArrayList;
    //   7: invokevirtual 38	java/util/ArrayList:isEmpty	()Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: ldc 40
    //   16: astore 4
    //   18: aconst_null
    //   19: astore_2
    //   20: aconst_null
    //   21: astore_1
    //   22: invokestatic 46	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: invokevirtual 50	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   28: ldc 52
    //   30: invokevirtual 58	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   33: astore_3
    //   34: aload_3
    //   35: astore_1
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: invokestatic 63	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   42: astore 5
    //   44: aload 5
    //   46: astore_1
    //   47: aload_1
    //   48: astore_2
    //   49: aload_3
    //   50: ifnull +9 -> 59
    //   53: aload_3
    //   54: invokevirtual 68	java/io/InputStream:close	()V
    //   57: aload_1
    //   58: astore_2
    //   59: aload_0
    //   60: getfield 12	upt:a	Lcom/tencent/mobileqq/shortvideo/PtvTemplateManager;
    //   63: aload_2
    //   64: invokestatic 71	com/tencent/mobileqq/shortvideo/PtvTemplateManager:a	(Lcom/tencent/mobileqq/shortvideo/PtvTemplateManager;Ljava/lang/String;)Ljava/util/List;
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull -56 -> 13
    //   72: aload_1
    //   73: invokeinterface 74 1 0
    //   78: ifne -65 -> 13
    //   81: aload_0
    //   82: getfield 12	upt:a	Lcom/tencent/mobileqq/shortvideo/PtvTemplateManager;
    //   85: getfield 78	com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   88: astore_2
    //   89: aload_2
    //   90: monitorenter
    //   91: aload_0
    //   92: getfield 12	upt:a	Lcom/tencent/mobileqq/shortvideo/PtvTemplateManager;
    //   95: getfield 32	com/tencent/mobileqq/shortvideo/PtvTemplateManager:a	Ljava/util/ArrayList;
    //   98: invokevirtual 38	java/util/ArrayList:isEmpty	()Z
    //   101: ifeq +15 -> 116
    //   104: aload_0
    //   105: getfield 12	upt:a	Lcom/tencent/mobileqq/shortvideo/PtvTemplateManager;
    //   108: getfield 32	com/tencent/mobileqq/shortvideo/PtvTemplateManager:a	Ljava/util/ArrayList;
    //   111: aload_1
    //   112: invokevirtual 82	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   115: pop
    //   116: aload_2
    //   117: monitorexit
    //   118: aload_0
    //   119: getfield 12	upt:a	Lcom/tencent/mobileqq/shortvideo/PtvTemplateManager;
    //   122: getfield 84	com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   125: astore_2
    //   126: aload_2
    //   127: monitorenter
    //   128: aload_0
    //   129: getfield 12	upt:a	Lcom/tencent/mobileqq/shortvideo/PtvTemplateManager;
    //   132: getfield 84	com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   135: invokevirtual 38	java/util/ArrayList:isEmpty	()Z
    //   138: ifeq +15 -> 153
    //   141: aload_0
    //   142: getfield 12	upt:a	Lcom/tencent/mobileqq/shortvideo/PtvTemplateManager;
    //   145: getfield 84	com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   148: aload_1
    //   149: invokevirtual 82	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   152: pop
    //   153: aload_2
    //   154: monitorexit
    //   155: return
    //   156: astore_1
    //   157: aload_2
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    //   161: astore_3
    //   162: aload_1
    //   163: astore_2
    //   164: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq -108 -> 59
    //   170: aload_3
    //   171: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   174: aload_1
    //   175: astore_2
    //   176: goto -117 -> 59
    //   179: astore_3
    //   180: aload_1
    //   181: astore_2
    //   182: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +9 -> 194
    //   188: aload_1
    //   189: astore_2
    //   190: aload_3
    //   191: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   194: aload 4
    //   196: astore_2
    //   197: aload_1
    //   198: ifnull -139 -> 59
    //   201: aload_1
    //   202: invokevirtual 68	java/io/InputStream:close	()V
    //   205: aload 4
    //   207: astore_2
    //   208: goto -149 -> 59
    //   211: astore_1
    //   212: aload 4
    //   214: astore_2
    //   215: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -159 -> 59
    //   221: aload_1
    //   222: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   225: aload 4
    //   227: astore_2
    //   228: goto -169 -> 59
    //   231: astore_1
    //   232: aload_2
    //   233: ifnull +7 -> 240
    //   236: aload_2
    //   237: invokevirtual 68	java/io/InputStream:close	()V
    //   240: aload_1
    //   241: athrow
    //   242: astore_2
    //   243: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -6 -> 240
    //   249: aload_2
    //   250: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   253: goto -13 -> 240
    //   256: astore_1
    //   257: aload_2
    //   258: monitorexit
    //   259: aload_1
    //   260: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	upt
    //   21	128	1	localObject1	Object
    //   156	46	1	localObject2	Object
    //   211	11	1	localException1	Exception
    //   231	10	1	localObject3	Object
    //   256	4	1	localObject4	Object
    //   242	16	2	localException2	Exception
    //   33	21	3	localInputStream	java.io.InputStream
    //   161	10	3	localException3	Exception
    //   179	12	3	localIOException	java.io.IOException
    //   16	210	4	str1	String
    //   42	3	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   128	153	156	finally
    //   153	155	156	finally
    //   157	159	156	finally
    //   53	57	161	java/lang/Exception
    //   22	34	179	java/io/IOException
    //   38	44	179	java/io/IOException
    //   201	205	211	java/lang/Exception
    //   22	34	231	finally
    //   38	44	231	finally
    //   182	188	231	finally
    //   190	194	231	finally
    //   236	240	242	java/lang/Exception
    //   91	116	256	finally
    //   116	118	256	finally
    //   257	259	256	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */