import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QzoneGiftFullScreenActionManager;

public class yle
  implements Runnable
{
  public yle(QzoneGiftFullScreenActionManager paramQzoneGiftFullScreenActionManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   4: getfield 30	cooperation/qzone/QzoneGiftFullScreenActionManager:c	Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +18 -> 27
    //   12: aload_0
    //   13: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   16: aload_0
    //   17: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   20: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   23: invokestatic 37	cooperation/qzone/QzoneGiftFullScreenActionManager:b	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   26: return
    //   27: aload_0
    //   28: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   31: invokestatic 39	cooperation/qzone/QzoneGiftFullScreenActionManager:a	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;)V
    //   34: aload_0
    //   35: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   38: getfield 42	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader	Lcom/tencent/mobileqq/magicface/model/MagicfaceResLoader;
    //   41: ldc 44
    //   43: invokevirtual 49	com/tencent/mobileqq/magicface/model/MagicfaceResLoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +141 -> 189
    //   51: aload_0
    //   52: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   55: aload_0
    //   56: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   59: getfield 52	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder	Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder;
    //   62: aload_1
    //   63: invokevirtual 57	com/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   66: putfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   69: aload_0
    //   70: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   73: aload_0
    //   74: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   77: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   80: invokestatic 59	cooperation/qzone/QzoneGiftFullScreenActionManager:a	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   83: aload_0
    //   84: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   87: aload_0
    //   88: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   91: getfield 52	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder	Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder;
    //   94: aload_1
    //   95: invokevirtual 62	com/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder:a	(Ljava/lang/String;)Ljava/util/List;
    //   98: putfield 65	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   101: aload_0
    //   102: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   105: invokestatic 67	cooperation/qzone/QzoneGiftFullScreenActionManager:b	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;)V
    //   108: aload_0
    //   109: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   112: getfield 65	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   115: invokeinterface 73 1 0
    //   120: astore_1
    //   121: aload_1
    //   122: invokeinterface 79 1 0
    //   127: ifeq +62 -> 189
    //   130: aload_1
    //   131: invokeinterface 83 1 0
    //   136: checkcast 85	com/tencent/mobileqq/magicface/magicfaceaction/Action
    //   139: astore_2
    //   140: aload_0
    //   141: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   144: aload_2
    //   145: putfield 88	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction	Lcom/tencent/mobileqq/magicface/magicfaceaction/Action;
    //   148: aload_2
    //   149: aload_0
    //   150: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   153: getfield 91	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager	Lcom/tencent/mobileqq/magicface/service/MagicfacePlayManager;
    //   156: putfield 92	com/tencent/mobileqq/magicface/magicfaceaction/Action:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager	Lcom/tencent/mobileqq/magicface/service/MagicfacePlayManager;
    //   159: aload_2
    //   160: aload_0
    //   161: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   164: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   167: putfield 93	com/tencent/mobileqq/magicface/magicfaceaction/Action:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   170: aload_2
    //   171: invokevirtual 95	com/tencent/mobileqq/magicface/magicfaceaction/Action:a	()Z
    //   174: istore_3
    //   175: aload_0
    //   176: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   179: getfield 97	cooperation/qzone/QzoneGiftFullScreenActionManager:b	Z
    //   182: istore 4
    //   184: iload 4
    //   186: ifeq +18 -> 204
    //   189: aload_0
    //   190: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   193: aload_0
    //   194: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   197: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   200: invokestatic 37	cooperation/qzone/QzoneGiftFullScreenActionManager:b	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   203: return
    //   204: iload_3
    //   205: ifeq -16 -> 189
    //   208: aload_0
    //   209: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   212: getfield 97	cooperation/qzone/QzoneGiftFullScreenActionManager:b	Z
    //   215: istore_3
    //   216: iload_3
    //   217: ifeq -96 -> 121
    //   220: goto -31 -> 189
    //   223: astore_1
    //   224: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +32 -> 259
    //   230: getstatic 105	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   233: iconst_2
    //   234: new 107	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   241: ldc 110
    //   243: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 118	java/lang/Exception:toString	()Ljava/lang/String;
    //   250: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_0
    //   260: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   263: aload_0
    //   264: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   267: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   270: invokestatic 37	cooperation/qzone/QzoneGiftFullScreenActionManager:b	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   273: return
    //   274: astore_1
    //   275: aload_0
    //   276: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   279: aload_0
    //   280: getfield 12	yle:a	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   283: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   286: invokestatic 37	cooperation/qzone/QzoneGiftFullScreenActionManager:b	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   289: aload_1
    //   290: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	yle
    //   46	85	1	localObject1	Object
    //   223	24	1	localException	Exception
    //   274	16	1	localObject2	Object
    //   139	32	2	localAction	com.tencent.mobileqq.magicface.magicfaceaction.Action
    //   7	210	3	bool1	boolean
    //   182	3	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   0	8	223	java/lang/Exception
    //   27	47	223	java/lang/Exception
    //   51	121	223	java/lang/Exception
    //   121	184	223	java/lang/Exception
    //   208	216	223	java/lang/Exception
    //   0	8	274	finally
    //   27	47	274	finally
    //   51	121	274	finally
    //   121	184	274	finally
    //   208	216	274	finally
    //   224	259	274	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */