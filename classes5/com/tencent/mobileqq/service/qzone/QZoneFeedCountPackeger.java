package com.tencent.mobileqq.service.qzone;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.mobile_get_config_req;
import QMF_PROTOCAL.mobile_get_config_rsp;
import android.content.Context;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.config.provider.ExtraConfig;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.WNSStream;
import cooperation.qzone.util.QZoneLogTags;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import upi;

public class QZoneFeedCountPackeger
{
  public static String a;
  private static AtomicInteger a;
  private static final String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = QZoneLogTags.b + QZoneFeedCountPackeger.class.getSimpleName();
    jdField_a_of_type_JavaLangString = "hostuin";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
  }
  
  public static JceStruct a(int paramInt)
  {
    String str = QZConfigProviderUtil.a();
    if (QLog.isDevelopLevel()) {
      QLog.d("GetUndealCountTag", 4, "config Scene=" + paramInt);
    }
    if (str != null) {}
    for (;;)
    {
      return new mobile_get_config_req(1000027, paramInt, str);
      str = "";
    }
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new WNSStream();
    try
    {
      localObject1 = ((WNSStream)localObject1).a(WupUtil.b(paramArrayOfByte));
      paramArrayOfByte = new UniAttribute();
      if ((localObject1 != null) && (((QmfDownstream)localObject1).WnsCode == 0))
      {
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject1).Extra);
        Object localObject2 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
        {
          localObject2 = WNSStream.b(((QmfDownstream)localObject1).BusiBuff);
          if (localObject2 == null) {
            break label176;
          }
          ((QmfDownstream)localObject1).BusiBuff = ((byte[])localObject2);
        }
        localObject2 = new UniAttribute();
        ((UniAttribute)localObject2).setEncodeName("utf-8");
        ((UniAttribute)localObject2).decode(((QmfDownstream)localObject1).BusiBuff);
        paramString = (JceStruct)((UniAttribute)localObject2).get(paramString);
        ThreadManager.a(new upi(paramArrayOfByte, paramQQAppInterface), 8, null, true);
        return paramString;
      }
      if (localObject1 != null)
      {
        int i = ((QmfDownstream)localObject1).WnsCode;
        if (i != 0) {
          return null;
        }
      }
      if (localObject1 == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
    label176:
    return null;
  }
  
  private static void a(Context paramContext, mobile_get_config_rsp parammobile_get_config_rsp)
  {
    if ((parammobile_get_config_rsp != null) && (parammobile_get_config_rsp.config != null) && (!parammobile_get_config_rsp.config.isEmpty())) {}
    try
    {
      ExtraConfig.a(parammobile_get_config_rsp.config, true);
      String str = BaseApplication.getContext().getPackageName();
      paramContext = str;
      if (TextUtils.isEmpty(str)) {
        paramContext = "unknow";
      }
      if (QLog.isColorLevel()) {
        QLog.i("ConfigProvider", 2, "qq config update:" + paramContext);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d(b, 4, b + " saveConfigToProvider");
      }
      QZConfigProviderUtil.a(parammobile_get_config_rsp.config, parammobile_get_config_rsp.cookies, paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public static byte[] a(JceStruct paramJceStruct, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: new 115	com/qq/jce/wup/UniAttribute
    //   3: dup
    //   4: invokespecial 116	com/qq/jce/wup/UniAttribute:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc -32
    //   13: invokevirtual 128	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   16: aload 7
    //   18: getstatic 43	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: lload_2
    //   22: invokestatic 230	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokevirtual 234	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   28: aload_0
    //   29: ifnull +21 -> 50
    //   32: aload_1
    //   33: ifnull +17 -> 50
    //   36: aload_1
    //   37: invokevirtual 239	java/lang/String:length	()I
    //   40: ifle +10 -> 50
    //   43: aload 7
    //   45: aload_1
    //   46: aload_0
    //   47: invokevirtual 234	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   50: aload 7
    //   52: invokevirtual 243	com/qq/jce/wup/UniAttribute:encode	()[B
    //   55: astore 9
    //   57: new 18	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   64: ldc -11
    //   66: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload 4
    //   71: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc -9
    //   76: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc -7
    //   81: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload 5
    //   86: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 8
    //   94: new 18	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   101: ldc -9
    //   103: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokestatic 254	cooperation/qzone/PlatformInfor:a	()Lcooperation/qzone/PlatformInfor;
    //   109: invokevirtual 257	cooperation/qzone/PlatformInfor:e	()Ljava/lang/String;
    //   112: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_0
    //   119: aload 8
    //   121: astore 7
    //   123: aload_0
    //   124: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +24 -> 151
    //   130: new 18	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   137: aload 8
    //   139: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_0
    //   143: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: astore 7
    //   151: new 104	cooperation/qzone/WNSStream
    //   154: dup
    //   155: ldc 94
    //   157: invokestatic 260	cooperation/qzone/QZoneHelper:a	()Ljava/lang/String;
    //   160: lload_2
    //   161: iconst_0
    //   162: newarray <illegal type>
    //   164: aload 7
    //   166: invokespecial 263	cooperation/qzone/WNSStream:<init>	(ILjava/lang/String;J[BLjava/lang/String;)V
    //   169: astore 7
    //   171: aload 9
    //   173: ifnull +58 -> 231
    //   176: iload 6
    //   178: invokestatic 265	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:a	(I)Lcom/qq/taf/jce/JceStruct;
    //   181: astore_0
    //   182: aload 7
    //   184: getstatic 67	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   187: invokevirtual 268	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   190: new 18	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   197: ldc_w 270
    //   200: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_1
    //   204: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: aload 9
    //   212: iconst_0
    //   213: aload_0
    //   214: invokevirtual 273	cooperation/qzone/WNSStream:a	(ILjava/lang/String;[BZLcom/qq/taf/jce/JceStruct;)[B
    //   217: invokestatic 275	com/tencent/mobileqq/utils/WupUtil:a	([B)[B
    //   220: areturn
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 278	java/lang/Error:printStackTrace	()V
    //   226: aconst_null
    //   227: astore_0
    //   228: goto -46 -> 182
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: aconst_null
    //   235: areturn
    //   236: astore_0
    //   237: ldc 99
    //   239: astore_0
    //   240: goto -121 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramJceStruct	JceStruct
    //   0	243	1	paramString	String
    //   0	243	2	paramLong	long
    //   0	243	4	paramInt1	int
    //   0	243	5	paramInt2	int
    //   0	243	6	paramInt3	int
    //   7	176	7	localObject	Object
    //   92	46	8	str	String
    //   55	156	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   176	182	221	java/lang/Error
    //   0	28	233	java/lang/Throwable
    //   36	50	233	java/lang/Throwable
    //   50	94	233	java/lang/Throwable
    //   94	119	233	java/lang/Throwable
    //   123	151	233	java/lang/Throwable
    //   151	171	233	java/lang/Throwable
    //   176	182	233	java/lang/Throwable
    //   182	221	233	java/lang/Throwable
    //   222	226	233	java/lang/Throwable
    //   94	119	236	java/lang/Exception
  }
  
  private static void b(UniAttribute paramUniAttribute, QQAppInterface paramQQAppInterface)
  {
    if (paramUniAttribute != null) {
      try
      {
        Object localObject = paramUniAttribute.get("conf_info_rsp_len");
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "processConfig pack get conf_info_rsp_len is null ");
          }
        }
        else
        {
          int i = ((Integer)localObject).intValue();
          localObject = (byte[])paramUniAttribute.get("conf_info_rsp");
          paramUniAttribute = (UniAttribute)localObject;
          if (localObject != null)
          {
            paramUniAttribute = (UniAttribute)localObject;
            if (i != 0) {
              paramUniAttribute = WNSStream.b((byte[])localObject);
            }
          }
          if (paramUniAttribute != null)
          {
            paramUniAttribute = WNSStream.a(mobile_get_config_rsp.class, paramUniAttribute);
            if ((paramQQAppInterface != null) && (paramQQAppInterface.a() != null) && (paramUniAttribute != null))
            {
              a(paramQQAppInterface.a(), (mobile_get_config_rsp)paramUniAttribute);
              return;
            }
          }
        }
      }
      catch (Error paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
        return;
      }
      catch (Exception paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\qzone\QZoneFeedCountPackeger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */