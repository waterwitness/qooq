import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.download.HYDownloadAsyncTask;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class grh
  extends HYDownloadAsyncTask
{
  public grh(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
  }
  
  /* Error */
  public void a(cooperation.huangye.download.DownloadParams paramDownloadParams)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 43	cooperation/huangye/download/DownloadParams:a	Lcooperation/huangye/download/DownloadResult;
    //   4: getfield 47	cooperation/huangye/download/DownloadResult:jdField_a_of_type_Boolean	Z
    //   7: ifeq +489 -> 496
    //   10: new 49	java/lang/String
    //   13: dup
    //   14: aload_1
    //   15: getfield 43	cooperation/huangye/download/DownloadParams:a	Lcooperation/huangye/download/DownloadResult;
    //   18: getfield 52	cooperation/huangye/download/DownloadResult:jdField_a_of_type_ArrayOfByte	[B
    //   21: ldc 54
    //   23: invokespecial 57	java/lang/String:<init>	([BLjava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +468 -> 496
    //   31: new 59	org/json/JSONObject
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 62	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: ldc 64
    //   43: invokevirtual 68	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   46: istore 6
    //   48: aload_1
    //   49: ldc 70
    //   51: invokevirtual 74	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   54: ifeq +434 -> 488
    //   57: aload_1
    //   58: ldc 70
    //   60: invokevirtual 78	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   63: astore_3
    //   64: aload_3
    //   65: ldc 80
    //   67: invokevirtual 74	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   70: ifeq +413 -> 483
    //   73: aload_3
    //   74: ldc 80
    //   76: invokevirtual 84	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_1
    //   80: aload_3
    //   81: ldc 86
    //   83: invokevirtual 74	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   86: ifeq +391 -> 477
    //   89: aload_3
    //   90: ldc 86
    //   92: invokevirtual 68	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   95: istore 4
    //   97: iload 4
    //   99: istore 5
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: ldc 88
    //   106: invokevirtual 74	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   109: ifeq +22 -> 131
    //   112: aload_0
    //   113: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   116: aload_3
    //   117: ldc 88
    //   119: invokevirtual 84	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: putfield 94	com/tencent/av/ui/ConferenceFlyTicketActivity:d	Ljava/lang/String;
    //   125: aload_1
    //   126: astore_2
    //   127: iload 4
    //   129: istore 5
    //   131: iload 6
    //   133: istore 4
    //   135: aload_2
    //   136: astore_3
    //   137: iload 5
    //   139: istore 6
    //   141: iload 4
    //   143: istore 5
    //   145: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +63 -> 211
    //   151: ldc 102
    //   153: iconst_2
    //   154: new 104	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   161: ldc 107
    //   163: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_3
    //   167: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 113
    //   172: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 6
    //   177: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc 118
    //   182: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   189: getfield 94	com/tencent/av/ui/ConferenceFlyTicketActivity:d	Ljava/lang/String;
    //   192: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc 120
    //   197: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload 5
    //   202: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: iload 5
    //   213: ifne +243 -> 456
    //   216: iload 6
    //   218: tableswitch	default:+26->244, -1:+200->418, 0:+134->352, 1:+228->446
    //   244: return
    //   245: astore_1
    //   246: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +31 -> 280
    //   252: ldc 102
    //   254: iconst_2
    //   255: new 104	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   262: ldc -127
    //   264: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_1
    //   268: invokevirtual 130	java/lang/Exception:toString	()Ljava/lang/String;
    //   271: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aconst_null
    //   281: astore_1
    //   282: goto -255 -> 27
    //   285: astore_2
    //   286: aconst_null
    //   287: astore_1
    //   288: iconst_2
    //   289: istore 4
    //   291: bipush -2
    //   293: istore 7
    //   295: iload 7
    //   297: istore 5
    //   299: iload 4
    //   301: istore 6
    //   303: aload_1
    //   304: astore_3
    //   305: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq -163 -> 145
    //   311: ldc 102
    //   313: iconst_2
    //   314: new 104	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   321: ldc -124
    //   323: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_2
    //   327: invokevirtual 133	org/json/JSONException:toString	()Ljava/lang/String;
    //   330: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: iload 7
    //   341: istore 5
    //   343: iload 4
    //   345: istore 6
    //   347: aload_1
    //   348: astore_3
    //   349: goto -204 -> 145
    //   352: aload_0
    //   353: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   356: getfield 94	com/tencent/av/ui/ConferenceFlyTicketActivity:d	Ljava/lang/String;
    //   359: ifnull +49 -> 408
    //   362: aload_0
    //   363: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   366: getfield 94	com/tencent/av/ui/ConferenceFlyTicketActivity:d	Ljava/lang/String;
    //   369: invokevirtual 137	java/lang/String:length	()I
    //   372: ifle +36 -> 408
    //   375: aload_0
    //   376: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   379: new 104	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   386: ldc -117
    //   388: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_0
    //   392: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   395: getfield 94	com/tencent/av/ui/ConferenceFlyTicketActivity:d	Ljava/lang/String;
    //   398: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokevirtual 141	com/tencent/av/ui/ConferenceFlyTicketActivity:a	(Ljava/lang/String;)V
    //   407: return
    //   408: aload_0
    //   409: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   412: iconst_1
    //   413: iconst_0
    //   414: invokevirtual 144	com/tencent/av/ui/ConferenceFlyTicketActivity:a	(II)V
    //   417: return
    //   418: new 146	java/util/ArrayList
    //   421: dup
    //   422: invokespecial 147	java/util/ArrayList:<init>	()V
    //   425: astore_1
    //   426: aload_0
    //   427: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   430: getfield 150	com/tencent/av/ui/ConferenceFlyTicketActivity:a	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   433: aload_0
    //   434: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   437: getfield 153	com/tencent/av/ui/ConferenceFlyTicketActivity:c	Ljava/lang/String;
    //   440: aload_1
    //   441: iconst_0
    //   442: invokevirtual 158	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;Ljava/util/ArrayList;I)V
    //   445: return
    //   446: aload_0
    //   447: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   450: iconst_1
    //   451: iconst_0
    //   452: invokevirtual 144	com/tencent/av/ui/ConferenceFlyTicketActivity:a	(II)V
    //   455: return
    //   456: aload_0
    //   457: getfield 10	grh:a	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   460: iconst_1
    //   461: iconst_0
    //   462: invokevirtual 144	com/tencent/av/ui/ConferenceFlyTicketActivity:a	(II)V
    //   465: return
    //   466: astore_2
    //   467: iconst_2
    //   468: istore 4
    //   470: goto -179 -> 291
    //   473: astore_2
    //   474: goto -183 -> 291
    //   477: iconst_2
    //   478: istore 4
    //   480: goto -383 -> 97
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -405 -> 80
    //   488: aconst_null
    //   489: astore_2
    //   490: iconst_2
    //   491: istore 5
    //   493: goto -362 -> 131
    //   496: aconst_null
    //   497: astore_3
    //   498: iconst_m1
    //   499: istore 5
    //   501: iconst_2
    //   502: istore 6
    //   504: goto -359 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	grh
    //   0	507	1	paramDownloadParams	cooperation.huangye.download.DownloadParams
    //   102	34	2	localDownloadParams	cooperation.huangye.download.DownloadParams
    //   285	42	2	localJSONException1	org.json.JSONException
    //   466	1	2	localJSONException2	org.json.JSONException
    //   473	1	2	localJSONException3	org.json.JSONException
    //   489	1	2	localObject1	Object
    //   63	435	3	localObject2	Object
    //   95	384	4	i	int
    //   99	401	5	j	int
    //   46	457	6	k	int
    //   293	47	7	m	int
    // Exception table:
    //   from	to	target	type
    //   10	27	245	java/lang/Exception
    //   31	80	285	org/json/JSONException
    //   80	97	466	org/json/JSONException
    //   103	125	473	org/json/JSONException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */