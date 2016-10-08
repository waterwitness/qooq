package com.tencent.mobileqq.app;

import IPwdPxyMQQ.RespondQueryIPwdStat;
import RegisterProxySvcPack.OnlineInfos;
import RegisterProxySvcPack.SvcRespParam;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class RegisterProxySvcPackHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "RegisterProxySvcPack";
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  RegisterProxySvcPackHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 1;
    this.f = 1;
    this.h = 1;
  }
  
  public int a()
  {
    try
    {
      int i = this.jdField_b_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long a()
  {
    try
    {
      long l = this.jdField_a_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected Class a()
  {
    return RegisterProxySvcPackObserver.class;
  }
  
  public void a()
  {
    a(a("RegPrxySvc.infoAndroid"));
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      QLog.d("RegisterProxySvcPack", 2, "setSelfPcSuppViewPcVersion:" + paramLong);
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.infoAndroid"))
    {
      QLog.d("RegisterProxySvcPack", 2, "resp of RegPrxySvc.infoAndroid");
      return;
    }
    int i;
    if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.PushParam")) {
      if (paramObject != null)
      {
        paramToServiceMsg = (SvcRespParam)paramObject;
        i = paramToServiceMsg.PCstat;
        if (paramToServiceMsg.iIsSupportDataLine != 2) {
          break label370;
        }
        i = 0;
      }
    }
    label118:
    label370:
    for (;;)
    {
      a(i);
      d(paramToServiceMsg.iIsSupportDataLine);
      f(paramToServiceMsg.iIsSupportPrintable);
      g(paramToServiceMsg.iIsSupportViewPCFile);
      a(paramToServiceMsg.iPcVersion);
      b(paramToServiceMsg.uRoamFlag);
      paramFromServiceMsg = paramToServiceMsg.onlineinfos;
      if (paramFromServiceMsg != null)
      {
        j = 0;
        if (j < paramFromServiceMsg.size())
        {
          paramObject = (OnlineInfos)paramFromServiceMsg.get(j);
          if (((OnlineInfos)paramObject).clienType != 9) {}
        }
      }
      for (int j = ((OnlineInfos)paramObject).onlineStatus;; j = 0)
      {
        b(j);
        QLog.d("RegisterProxySvcPack", 2, "online status of pc: state:" + paramToServiceMsg.PCstat + "- ram:" + paramToServiceMsg.iIsSupportC2CRoamMsg + "- supportdataline:" + paramToServiceMsg.iIsSupportDataLine + "- PcVersion:" + paramToServiceMsg.iPcVersion + "- uRoamFlag:" + paramToServiceMsg.uRoamFlag);
        a(1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.iIsSupportDataLine) });
        return;
        j += 1;
        break label118;
        QLog.d("RegisterProxySvcPack", 2, "RegPrxySvc.PushParam is null");
        return;
        if (!paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.QueryIpwdStat")) {
          break;
        }
        if (paramObject != null)
        {
          paramToServiceMsg = (RespondQueryIPwdStat)paramObject;
          if (paramToServiceMsg == null) {
            break;
          }
          c(paramToServiceMsg.uIsSetPwd);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("RegisterProxySvcPack", 2, "QueryIPwdStat:" + paramToServiceMsg.uIsSetPwd);
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RegisterProxySvcPack", 2, "IPwdPxyMQQ.RespondQueryIPwdStat is null");
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void b(long paramLong)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: lload_1
    //   6: lconst_1
    //   7: land
    //   8: lconst_1
    //   9: lcmp
    //   10: ifeq +15 -> 25
    //   13: lload_1
    //   14: ldc2_w 200
    //   17: land
    //   18: ldc2_w 200
    //   21: lcmp
    //   22: ifne +78 -> 100
    //   25: iconst_4
    //   26: istore 4
    //   28: aload_0
    //   29: getfield 204	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: ifnull +104 -> 136
    //   35: iload 4
    //   37: iconst_m1
    //   38: if_icmpeq +98 -> 136
    //   41: aload_0
    //   42: getfield 204	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   48: ldc -44
    //   50: iconst_0
    //   51: invokevirtual 218	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   54: invokeinterface 224 1 0
    //   59: new 57	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   66: ldc -30
    //   68: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: getfield 204	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   75: invokevirtual 228	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   78: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: iload 4
    //   86: invokeinterface 234 3 0
    //   91: invokeinterface 237 1 0
    //   96: pop
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: lload_1
    //   101: ldc2_w 238
    //   104: land
    //   105: ldc2_w 238
    //   108: lcmp
    //   109: ifne +9 -> 118
    //   112: iconst_3
    //   113: istore 4
    //   115: goto -87 -> 28
    //   118: lload_1
    //   119: ldc2_w 240
    //   122: land
    //   123: ldc2_w 240
    //   126: lcmp
    //   127: ifeq -99 -> 28
    //   130: iconst_1
    //   131: istore 4
    //   133: goto -105 -> 28
    //   136: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq -42 -> 97
    //   142: ldc 10
    //   144: iconst_2
    //   145: new 57	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   152: ldc -13
    //   154: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: iload 4
    //   159: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: goto -71 -> 97
    //   171: astore_3
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_3
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	RegisterProxySvcPackHandler
    //   0	176	1	paramLong	long
    //   171	4	3	localObject	Object
    //   1	157	4	i	int
    // Exception table:
    //   from	to	target	type
    //   28	35	171	finally
    //   41	97	171	finally
    //   136	168	171	finally
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void c(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label165;
        }
        QLog.d("RegisterProxySvcPack", 2, "uIsSetPwd = " + paramLong);
      }
      finally {}
      if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (i != -1))
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_is_set_password" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), i).commit();
        return;
        if (paramLong != 2L) {
          i = -1;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("RegisterProxySvcPack", 2, "RegisterProxySvcPackHandler.app is null or isSetPassword is error ,isSetPassword = " + i);
        continue;
        label165:
        if (paramLong != 1L) {
          break;
        }
        i = 1;
      }
    }
  }
  
  public void d(int paramInt)
  {
    try
    {
      this.e = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int e()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void e(int paramInt)
  {
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int f()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void f(int paramInt)
  {
    try
    {
      this.g = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int g()
  {
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void g(int paramInt)
  {
    try
    {
      this.h = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int h()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int i()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int j()
  {
    try
    {
      int i = this.h;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\RegisterProxySvcPackHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */