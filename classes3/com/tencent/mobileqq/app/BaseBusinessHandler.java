package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import puh;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public abstract class BaseBusinessHandler
{
  public static final int E = 0;
  public static final int G = 2;
  private static int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString;
  private static MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private static int jdField_b_of_type_Int = -1;
  private static MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public static final int x_ = 1;
  private long jdField_a_of_type_Long;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  protected Set b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BaseBusinessHandler.class.getName();
    jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
    jdField_b_of_type_MqqOsMqqHandler = ThreadManager.b();
  }
  
  /* Error */
  public static int a(FromServiceMsg paramFromServiceMsg, Object paramObject, com.tencent.mobileqq.pb.MessageMicro paramMessageMicro)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 77	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   7: istore 5
    //   9: invokestatic 83	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   12: ifeq +225 -> 237
    //   15: new 85	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   22: astore_3
    //   23: iload 5
    //   25: sipush 1000
    //   28: if_icmpne +183 -> 211
    //   31: aload_1
    //   32: ifnull +142 -> 174
    //   35: new 88	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   38: dup
    //   39: invokespecial 89	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   42: astore_0
    //   43: aload_0
    //   44: aload_1
    //   45: checkcast 91	[B
    //   48: checkcast 91	[B
    //   51: invokevirtual 95	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   54: checkcast 88	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: aload_0
    //   61: ifnull +173 -> 234
    //   64: aload_0
    //   65: getfield 99	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   68: invokevirtual 104	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   71: istore 5
    //   73: aload_0
    //   74: ifnull +42 -> 116
    //   77: aload_0
    //   78: getfield 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   81: invokevirtual 113	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   84: ifeq +32 -> 116
    //   87: aload_0
    //   88: getfield 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   91: invokevirtual 116	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   94: ifnull +22 -> 116
    //   97: aload_2
    //   98: ifnull +18 -> 116
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   106: invokevirtual 116	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   109: invokevirtual 122	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   112: invokevirtual 125	com/tencent/mobileqq/pb/MessageMicro:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: pop
    //   116: aload_3
    //   117: ifnull +26 -> 143
    //   120: aload_3
    //   121: invokevirtual 128	java/lang/StringBuilder:length	()I
    //   124: ifle +19 -> 143
    //   127: invokestatic 83	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   130: ifeq +13 -> 143
    //   133: ldc -126
    //   135: iconst_4
    //   136: aload_3
    //   137: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: iload 5
    //   145: ireturn
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_3
    //   150: ifnull +17 -> 167
    //   153: aload_3
    //   154: ldc -117
    //   156: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 144	java/lang/Exception:toString	()Ljava/lang/String;
    //   163: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_1
    //   168: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   171: goto -111 -> 60
    //   174: aload 4
    //   176: astore_0
    //   177: aload_3
    //   178: ifnull -118 -> 60
    //   181: aload_3
    //   182: ldc -107
    //   184: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 4
    //   190: astore_0
    //   191: goto -131 -> 60
    //   194: astore_0
    //   195: aload_3
    //   196: ifnull -80 -> 116
    //   199: aload_3
    //   200: aload_0
    //   201: invokevirtual 144	java/lang/Exception:toString	()Ljava/lang/String;
    //   204: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: goto -92 -> 116
    //   211: aload_3
    //   212: ifnull +15 -> 227
    //   215: aload_3
    //   216: ldc -105
    //   218: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 5
    //   223: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: goto -111 -> 116
    //   230: astore_1
    //   231: goto -82 -> 149
    //   234: goto -161 -> 73
    //   237: aconst_null
    //   238: astore_3
    //   239: goto -216 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramFromServiceMsg	FromServiceMsg
    //   0	242	1	paramObject	Object
    //   0	242	2	paramMessageMicro	com.tencent.mobileqq.pb.MessageMicro
    //   22	217	3	localStringBuilder	StringBuilder
    //   1	188	4	localObject	Object
    //   7	215	5	i	int
    // Exception table:
    //   from	to	target	type
    //   35	43	146	java/lang/Exception
    //   101	116	194	java/lang/Exception
    //   43	58	230	java/lang/Exception
  }
  
  private void a(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2, BusinessObserver paramBusinessObserver, MqqHandler paramMqqHandler)
  {
    paramObject = new puh(this, paramBusinessObserver, paramInt, paramMqqHandler, paramBoolean1, paramObject);
    if (paramBoolean2)
    {
      paramMqqHandler.postAtFrontOfQueue((Runnable)paramObject);
      return;
    }
    paramMqqHandler.post((Runnable)paramObject);
  }
  
  public ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", b(), paramString);
  }
  
  public ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return a(paramString, paramInt1, paramInt2, paramArrayOfByte, 30000L);
  }
  
  public ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong)
  {
    return a(paramString, paramInt1, paramInt2, paramArrayOfByte, paramLong, null, false);
  }
  
  public ToServiceMsg a(String arg1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(paramInt1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt2);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.d());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = a(???);
    paramArrayOfByte.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramArrayOfByte.setTimeout(paramLong);
    if ((paramBusinessObserver == null) || (paramBoolean)) {}
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      ???.put(Long.valueOf(this.jdField_a_of_type_Long), paramBusinessObserver);
      paramBusinessObserver = paramArrayOfByte.extraData;
      localObject = jdField_a_of_type_JavaLangString;
      paramLong = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = (1L + paramLong);
      paramBusinessObserver.putLong((String)localObject, paramLong);
      return paramArrayOfByte;
      ??? = this.jdField_a_of_type_JavaUtilMap;
    }
  }
  
  public ToServiceMsg a(String paramString, BusinessObserver paramBusinessObserver)
  {
    return a(paramString, paramBusinessObserver, false);
  }
  
  ToServiceMsg a(String arg1, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = a(???);
    if ((paramBusinessObserver == null) || (paramBoolean)) {}
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      ???.put(Long.valueOf(this.jdField_a_of_type_Long), paramBusinessObserver);
      paramBusinessObserver = localToServiceMsg.extraData;
      String str = jdField_a_of_type_JavaLangString;
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = (1L + l);
      paramBusinessObserver.putLong(str, l);
      return localToServiceMsg;
      ??? = this.jdField_a_of_type_JavaUtilMap;
    }
  }
  
  protected abstract Class a();
  
  public final Object a(byte[] paramArrayOfByte, String paramString, Object paramObject)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramObject);
    }
    catch (Exception paramArrayOfByte) {}
    return (Object)null;
  }
  
  public abstract List a(int paramInt);
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject, false);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    List localList = a(0);
    Iterator localIterator;
    Object localObject;
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (BusinessObserver)localIterator.next();
          if ((a() != null) && (a().isAssignableFrom(localObject.getClass())))
          {
            long l = System.currentTimeMillis();
            ((BusinessObserver)localObject).a(paramInt, paramBoolean1, paramObject);
            l = System.currentTimeMillis() - l;
            if ((l > 100L) && (QLog.isColorLevel()))
            {
              localObject = new Exception("run too long!");
              QLog.d("BaseBusinessHandler.notifyUI", 2, "defaultObserver onUpdate cost:" + l, (Throwable)localObject);
            }
          }
        }
      }
      finally {}
    }
    localList = a(1);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (BusinessObserver)localIterator.next();
          if ((a() != null) && (a().isAssignableFrom(localObject.getClass()))) {
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, (BusinessObserver)localObject, jdField_a_of_type_MqqOsMqqHandler);
          }
        }
      }
      finally {}
    }
    localList = a(2);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (BusinessObserver)localIterator.next();
          if ((a() != null) && (a().isAssignableFrom(localObject.getClass()))) {
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, (BusinessObserver)localObject, jdField_b_of_type_MqqOsMqqHandler);
          }
        }
      }
      finally {}
    }
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg);
  
  public final void a(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    long l;
    MqqHandler localMqqHandler;
    if (paramToServiceMsg.extraData.containsKey(jdField_a_of_type_JavaLangString))
    {
      l = paramToServiceMsg.extraData.getLong(jdField_a_of_type_JavaLangString);
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        paramToServiceMsg = (BusinessObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l));
        localMqqHandler = jdField_a_of_type_MqqOsMqqHandler;
        if (paramToServiceMsg != null) {}
      }
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilMap)
      {
        paramToServiceMsg = (BusinessObserver)this.jdField_b_of_type_JavaUtilMap.remove(Long.valueOf(l));
        localMqqHandler = jdField_b_of_type_MqqOsMqqHandler;
        if (paramToServiceMsg != null)
        {
          a(paramInt, paramBoolean, paramObject, false, paramToServiceMsg, localMqqHandler);
          return;
          paramToServiceMsg = finally;
          throw paramToServiceMsg;
        }
      }
      a(paramInt, paramBoolean, paramObject);
      return;
    }
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public abstract String b();
  
  public abstract void b(ToServiceMsg paramToServiceMsg);
  
  public void g() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\BaseBusinessHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */