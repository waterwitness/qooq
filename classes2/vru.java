import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr.WriteCommentCallback;

public class vru
  extends ProtoUtils.TroopProtocolObserver
{
  public vru(TroopTopicMgr paramTroopTopicMgr, TroopTopicMgr.WriteCommentCallback paramWriteCommentCallback, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void a(int paramInt, byte[] paramArrayOfByte, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +18 -> 19
    //   4: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 39
    //   12: iconst_2
    //   13: ldc 41
    //   15: invokestatic 45	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: return
    //   19: aconst_null
    //   20: astore 4
    //   22: aconst_null
    //   23: astore 5
    //   25: new 47	com/tencent/mobileqq/WebSsoBody$WebSsoResponseBody
    //   28: dup
    //   29: invokespecial 48	com/tencent/mobileqq/WebSsoBody$WebSsoResponseBody:<init>	()V
    //   32: astore_3
    //   33: aload_3
    //   34: aload_2
    //   35: invokevirtual 52	com/tencent/mobileqq/WebSsoBody$WebSsoResponseBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   38: pop
    //   39: aload_3
    //   40: getfield 56	com/tencent/mobileqq/WebSsoBody$WebSsoResponseBody:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   43: invokevirtual 62	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   46: istore_1
    //   47: iload_1
    //   48: ifne +212 -> 260
    //   51: new 64	org/json/JSONObject
    //   54: dup
    //   55: aload_3
    //   56: getfield 68	com/tencent/mobileqq/WebSsoBody$WebSsoResponseBody:data	Lcom/tencent/mobileqq/pb/PBStringField;
    //   59: invokevirtual 73	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   62: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   65: astore_2
    //   66: aload_0
    //   67: getfield 14	vru:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr$WriteCommentCallback	Lcom/tencent/mobileqq/troop/utils/TroopTopicMgr$WriteCommentCallback;
    //   70: iload_1
    //   71: aload_2
    //   72: invokeinterface 81 3 0
    //   77: return
    //   78: astore_3
    //   79: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +31 -> 113
    //   85: ldc 39
    //   87: iconst_2
    //   88: new 83	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   95: ldc 86
    //   97: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_3
    //   101: invokevirtual 93	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   104: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 45	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: getfield 100	vru:b	Ljava/lang/ref/WeakReference;
    //   117: invokevirtual 105	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   120: checkcast 107	com/tencent/mobileqq/app/QQAppInterface
    //   123: astore_3
    //   124: aload_3
    //   125: ifnull +123 -> 248
    //   128: aload_3
    //   129: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   132: aload_0
    //   133: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   136: getfield 116	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   139: aload_0
    //   140: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   143: getfield 120	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   146: aload_0
    //   147: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   150: getfield 124	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   153: invokevirtual 129	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;IJ)Z
    //   156: pop
    //   157: aload_0
    //   158: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   161: ldc -126
    //   163: putfield 133	com/tencent/mobileqq/data/MessageRecord:extraflag	I
    //   166: aload_3
    //   167: invokevirtual 136	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   170: aload_0
    //   171: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   174: invokevirtual 141	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/Object;)V
    //   177: aload_3
    //   178: invokevirtual 136	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   181: aload_0
    //   182: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   185: getfield 116	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   188: aload_0
    //   189: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   192: getfield 120	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   195: aload_0
    //   196: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   199: getfield 124	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   202: ldc -126
    //   204: sipush 1002
    //   207: invokevirtual 144	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJII)V
    //   210: aload_3
    //   211: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   214: sipush 6003
    //   217: iconst_0
    //   218: iconst_2
    //   219: anewarray 149	java/lang/String
    //   222: dup
    //   223: iconst_0
    //   224: aload_0
    //   225: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   228: getfield 116	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: aload_0
    //   235: getfield 16	vru:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   238: getfield 124	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   241: invokestatic 153	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   244: aastore
    //   245: invokevirtual 158	com/tencent/mobileqq/app/MessageHandler:a	(IZLjava/lang/Object;)V
    //   248: aload_0
    //   249: getfield 14	vru:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr$WriteCommentCallback	Lcom/tencent/mobileqq/troop/utils/TroopTopicMgr$WriteCommentCallback;
    //   252: iload_1
    //   253: aload_2
    //   254: invokeinterface 81 3 0
    //   259: return
    //   260: aconst_null
    //   261: astore_2
    //   262: goto -149 -> 113
    //   265: astore_3
    //   266: iconst_0
    //   267: istore_1
    //   268: aload 4
    //   270: astore_2
    //   271: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +31 -> 305
    //   277: ldc 39
    //   279: iconst_2
    //   280: new 83	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   287: ldc -96
    //   289: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_3
    //   293: invokevirtual 161	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   296: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 45	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: goto -192 -> 113
    //   308: astore_3
    //   309: aload 4
    //   311: astore_2
    //   312: goto -41 -> 271
    //   315: astore_3
    //   316: goto -45 -> 271
    //   319: astore_3
    //   320: iconst_0
    //   321: istore_1
    //   322: aload 5
    //   324: astore_2
    //   325: goto -246 -> 79
    //   328: astore_3
    //   329: aload 5
    //   331: astore_2
    //   332: goto -253 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	vru
    //   0	335	1	paramInt	int
    //   0	335	2	paramArrayOfByte	byte[]
    //   0	335	3	paramBundle	android.os.Bundle
    //   20	290	4	localObject1	Object
    //   23	307	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   66	77	78	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   25	47	265	org/json/JSONException
    //   51	66	308	org/json/JSONException
    //   66	77	315	org/json/JSONException
    //   25	47	319	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   51	66	328	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */