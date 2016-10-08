package com.tencent.av;

import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SessionMgr
{
  static volatile SessionMgr jdField_a_of_type_ComTencentAvSessionMgr;
  public static String a;
  SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = new SessionInfo();
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "AvSessionMgr";
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1011: 
    default: 
      return 3;
    case 3000: 
      return 2;
    }
    return 1;
  }
  
  public static SessionMgr a()
  {
    if (jdField_a_of_type_ComTencentAvSessionMgr == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvSessionMgr == null) {
        jdField_a_of_type_ComTencentAvSessionMgr = new SessionMgr();
      }
      return jdField_a_of_type_ComTencentAvSessionMgr;
    }
    finally {}
  }
  
  public static String a(int paramInt, String paramString, int... paramVarArgs)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("+")) {
        str = paramString.substring(1);
      }
    }
    str = String.valueOf(paramInt) + "-" + str;
    paramString = str;
    if (paramInt == 1)
    {
      paramString = str;
      if (paramVarArgs != null)
      {
        paramString = str;
        if (paramVarArgs.length == 1) {
          paramString = str + "-" + paramVarArgs[0];
        }
      }
    }
    return paramString;
  }
  
  private SessionInfo b()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 1)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (String)((Iterator)localObject).next();
        return (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      }
    }
    return null;
  }
  
  public int a()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!((SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(str)).a())
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "getAliveSession sessionId : " + str);
            }
            i += 1;
          }
        }
        else
        {
          return i;
        }
      }
      finally {}
    }
  }
  
  public SessionInfo a()
  {
    try
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      return localSessionInfo;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public SessionInfo a(String paramString)
  {
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (QLog.isColorLevel())) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getSession not exist sessionId : " + paramString);
      }
      paramString = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public SessionInfo a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      SessionInfo localSessionInfo;
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "createSession with null sessionId ");
          }
          localSessionInfo = null;
          return localSessionInfo;
        }
        if (this.jdField_a_of_type_JavaUtilMap.get(paramString) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "createSession already exist sessionId : " + paramString);
          }
          localSessionInfo = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "createSession sessionId : " + paramString);
        }
        if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
        {
          localSessionInfo = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localSessionInfo);
          localSessionInfo.b = paramString;
          if ((this.jdField_a_of_type_JavaUtilMap.size() != 1) && (!paramBoolean)) {
            break label257;
          }
          a(paramString, 2);
          continue;
        }
        if (b() == null) {
          break label229;
        }
      }
      finally {}
      if (b().e == 3)
      {
        a(b().b, paramString);
        localSessionInfo = a(paramString);
      }
      else
      {
        label229:
        localSessionInfo = new SessionInfo();
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localSessionInfo);
        localSessionInfo.b = paramString;
        continue;
        label257:
        a(paramString, 1);
      }
    }
  }
  
  public ArrayList a()
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (String)localIterator.next();
          localObject2 = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
          if (((SessionInfo)localObject2).e == 1) {
            localArrayList1.add(localObject2);
          }
        }
      }
      i = ((ArrayList)localObject1).size();
    }
    finally {}
    int i;
    ArrayList localArrayList2;
    if (i == 0) {
      localArrayList2 = null;
    }
    for (;;)
    {
      return localArrayList2;
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +38 -> 43
    //   8: getstatic 21	com/tencent/av/SessionMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 61	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   19: ldc -85
    //   21: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc -83
    //   30: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   47: aload_1
    //   48: invokeinterface 128 2 0
    //   53: ifne +47 -> 100
    //   56: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +38 -> 97
    //   62: getstatic 21	com/tencent/av/SessionMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: iconst_2
    //   66: new 61	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   73: ldc -81
    //   75: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc -79
    //   84: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload_2
    //   88: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: aload_0
    //   101: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   104: aload_1
    //   105: invokeinterface 110 2 0
    //   110: checkcast 27	com/tencent/av/app/SessionInfo
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull -18 -> 97
    //   118: aload_1
    //   119: getfield 156	com/tencent/av/app/SessionInfo:e	I
    //   122: iload_2
    //   123: if_icmpeq -26 -> 97
    //   126: iload_2
    //   127: iconst_2
    //   128: if_icmpne +8 -> 136
    //   131: aload_0
    //   132: aload_1
    //   133: putfield 30	com/tencent/av/SessionMgr:jdField_a_of_type_ComTencentAvAppSessionInfo	Lcom/tencent/av/app/SessionInfo;
    //   136: aload_1
    //   137: iload_2
    //   138: putfield 156	com/tencent/av/app/SessionInfo:e	I
    //   141: goto -44 -> 97
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	SessionMgr
    //   0	149	1	paramString	String
    //   0	149	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	43	144	finally
    //   43	97	144	finally
    //   100	114	144	finally
    //   118	126	144	finally
    //   131	136	144	finally
    //   136	141	144	finally
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 179	com/tencent/av/SessionMgr:a	()I
    //   8: istore_2
    //   9: iload_2
    //   10: iconst_1
    //   11: if_icmple +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_3
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_3
    //   20: goto -6 -> 14
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SessionMgr
    //   23	4	1	localObject	Object
    //   8	4	2	i	int
    //   1	19	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: invokeinterface 90 1 0
    //   11: invokeinterface 96 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 102 1 0
    //   23: ifeq +79 -> 102
    //   26: aload_2
    //   27: invokeinterface 106 1 0
    //   32: checkcast 51	java/lang/String
    //   35: astore_3
    //   36: aload_0
    //   37: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   40: aload_3
    //   41: invokeinterface 110 2 0
    //   46: checkcast 27	com/tencent/av/app/SessionInfo
    //   49: getfield 156	com/tencent/av/app/SessionInfo:e	I
    //   52: iload_1
    //   53: if_icmpne -36 -> 17
    //   56: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +29 -> 88
    //   62: getstatic 21	com/tencent/av/SessionMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: iconst_2
    //   66: new 61	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   73: ldc -74
    //   75: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_3
    //   79: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: aload_3
    //   90: invokevirtual 185	com/tencent/av/SessionMgr:c	(Ljava/lang/String;)Z
    //   93: pop
    //   94: iconst_1
    //   95: istore 4
    //   97: aload_0
    //   98: monitorexit
    //   99: iload 4
    //   101: ireturn
    //   102: iconst_0
    //   103: istore 4
    //   105: goto -8 -> 97
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	SessionMgr
    //   0	113	1	paramInt	int
    //   16	11	2	localIterator	Iterator
    //   108	4	2	localObject	Object
    //   35	55	3	str	String
    //   95	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	108	finally
    //   17	88	108	finally
    //   88	94	108	finally
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +38 -> 43
    //   8: getstatic 21	com/tencent/av/SessionMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 61	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   19: ldc -69
    //   21: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc -67
    //   30: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   47: aload_1
    //   48: invokeinterface 128 2 0
    //   53: ifne +26 -> 79
    //   56: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +12 -> 71
    //   62: getstatic 21	com/tencent/av/SessionMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: iconst_2
    //   66: ldc -65
    //   68: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iconst_0
    //   72: istore 4
    //   74: aload_0
    //   75: monitorexit
    //   76: iload 4
    //   78: ireturn
    //   79: aload_0
    //   80: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   83: aload_1
    //   84: invokeinterface 110 2 0
    //   89: checkcast 27	com/tencent/av/app/SessionInfo
    //   92: astore_3
    //   93: aload_3
    //   94: aload_2
    //   95: putfield 148	com/tencent/av/app/SessionInfo:b	Ljava/lang/String;
    //   98: aload_0
    //   99: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   102: aload_1
    //   103: invokeinterface 194 2 0
    //   108: pop
    //   109: aload_0
    //   110: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   113: aload_2
    //   114: aload_3
    //   115: invokeinterface 146 3 0
    //   120: pop
    //   121: iconst_1
    //   122: istore 4
    //   124: goto -50 -> 74
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	SessionMgr
    //   0	132	1	paramString1	String
    //   0	132	2	paramString2	String
    //   92	23	3	localSessionInfo	SessionInfo
    //   72	51	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	43	127	finally
    //   43	71	127	finally
    //   79	121	127	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: invokeinterface 90 1 0
    //   11: invokeinterface 96 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 102 1 0
    //   23: ifeq +40 -> 63
    //   26: aload_1
    //   27: invokeinterface 106 1 0
    //   32: checkcast 51	java/lang/String
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   40: aload_2
    //   41: invokeinterface 110 2 0
    //   46: checkcast 27	com/tencent/av/app/SessionInfo
    //   49: invokevirtual 112	com/tencent/av/app/SessionInfo:a	()Z
    //   52: istore_3
    //   53: iload_3
    //   54: ifne -37 -> 17
    //   57: iconst_0
    //   58: istore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: iconst_1
    //   64: istore_3
    //   65: goto -6 -> 59
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	SessionMgr
    //   16	11	1	localIterator	Iterator
    //   68	4	1	localObject	Object
    //   35	6	2	str	String
    //   52	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	68	finally
    //   17	53	68	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 128 2 0
    //   12: ifeq +15 -> 27
    //   15: aload_0
    //   16: aload_1
    //   17: iconst_2
    //   18: invokevirtual 151	com/tencent/av/SessionMgr:a	(Ljava/lang/String;I)V
    //   21: iconst_1
    //   22: istore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_2
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_2
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	SessionMgr
    //   0	37	1	paramString	String
    //   22	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	21	32	finally
  }
  
  public boolean c(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "removeSession sessionId : " + paramString);
        }
        if (this.jdField_a_of_type_JavaUtilMap.size() == 1)
        {
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "removeSession not exist sessionId : " + paramString);
            }
            bool = false;
            return bool;
          }
          ((SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString)).b();
          ((SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString)).e();
          ((SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString)).e = 3;
          a(paramString, "none");
          bool = false;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "removeSession session size : " + this.jdField_a_of_type_JavaUtilMap.size());
        }
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
        {
          this.jdField_a_of_type_JavaUtilMap.remove(paramString);
          if (this.jdField_a_of_type_JavaUtilMap.size() != 1) {
            break label288;
          }
          paramString = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
          if (!paramString.hasNext()) {
            break label288;
          }
          b((String)paramString.next());
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label288:
      boolean bool = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\SessionMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */