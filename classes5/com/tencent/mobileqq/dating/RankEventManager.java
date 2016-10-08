package com.tencent.mobileqq.dating;

import android.os.Handler.Callback;
import android.os.Message;
import appoint.define.appoint_define.NearbyEvent;
import appoint.define.appoint_define.RankEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RankEventMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.CustomHandler;
import java.util.List;
import mqq.os.MqqHandler;
import rgh;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

public class RankEventManager
  implements Handler.Callback
{
  public static final int a = 20;
  public static final int b = 5000;
  private static final int d = 1;
  private static final int e = 3;
  public long a;
  RankEventMsg jdField_a_of_type_ComTencentMobileqqDataRankEventMsg;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  Object jdField_a_of_type_JavaLangObject;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  long b;
  int c;
  
  public RankEventManager(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount()).createEntityManager();
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.a(), this);
    this.c = 0;
  }
  
  private void a(RankEventMsg paramRankEventMsg)
  {
    if (paramRankEventMsg == null) {}
    label187:
    do
    {
      return;
      if (paramRankEventMsg.bReaded == 0) {}
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg = paramRankEventMsg;
          this.c = 1;
          switch (paramRankEventMsg.notifytype)
          {
          default: 
            if (paramRankEventMsg.notifytype == 1) {
              NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "self_god_flag", Boolean.valueOf(true));
            }
            if (paramRankEventMsg.getStatus() != 1000) {
              break label187;
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramRankEventMsg);
            return;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "0X8005299");
        continue;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "0X800529A");
        continue;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "0X800529B");
        continue;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "0X800529C");
        continue;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "0X800529D");
      }
    } while (paramRankEventMsg.getStatus() == 1003);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramRankEventMsg);
  }
  
  /* Error */
  private void a(RankEventMsg paramRankEventMsg, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc -128
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc -126
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: lload_2
    //   16: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   19: aastore
    //   20: invokestatic 140	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_1
    //   24: astore 4
    //   26: aload_1
    //   27: ifnonnull +12 -> 39
    //   30: new 72	com/tencent/mobileqq/data/RankEventMsg
    //   33: dup
    //   34: invokespecial 141	com/tencent/mobileqq/data/RankEventMsg:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: invokevirtual 144	com/tencent/mobileqq/data/RankEventMsg:getTableName	()Ljava/lang/String;
    //   44: astore_1
    //   45: new 146	android/content/ContentValues
    //   48: dup
    //   49: invokespecial 147	android/content/ContentValues:<init>	()V
    //   52: astore 4
    //   54: aload 4
    //   56: ldc -108
    //   58: iconst_1
    //   59: invokestatic 153	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   62: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Byte;)V
    //   65: aload_0
    //   66: getfield 54	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: aload_1
    //   70: aload 4
    //   72: ldc -97
    //   74: iconst_2
    //   75: anewarray 161	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: lload_2
    //   81: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: iconst_0
    //   88: invokestatic 167	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   91: aastore
    //   92: invokevirtual 170	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z
    //   95: pop
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: astore_1
    //   100: ldc -128
    //   102: iconst_2
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: ldc -126
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload_1
    //   114: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 140	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: goto -25 -> 96
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	RankEventManager
    //   0	129	1	paramRankEventMsg	RankEventMsg
    //   0	129	2	paramLong	long
    //   24	47	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	96	99	java/lang/Exception
    //   2	23	124	finally
    //   30	39	124	finally
    //   39	96	124	finally
    //   100	121	124	finally
  }
  
  private void a(boolean paramBoolean, RankEventMsg paramRankEventMsg)
  {
    DatingUtil.a("notifyNewMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.c), paramRankEventMsg });
    ((DatingHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(2)).a(1, this.c);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(1, this.c, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b) });
  }
  
  private boolean a()
  {
    DatingHandler localDatingHandler = (DatingHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(2);
    if (localDatingHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 30000L);
      localDatingHandler.a(this.b, this.jdField_a_of_type_Long, 1);
    }
    for (boolean bool = true;; bool = false)
    {
      DatingUtil.a("startFetchUnreadEvent", new Object[] { Boolean.valueOf(bool) });
      return bool;
      DatingUtil.b("startFetchUnreadEvent", new Object[] { "dh is null" });
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 224	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 224	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_Boolean	Z
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 37	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   18: invokevirtual 43	com/tencent/mobileqq/nearby/NearbyAppInterface:getAccount	()Ljava/lang/String;
    //   21: ldc -30
    //   23: iconst_4
    //   24: ldc -28
    //   26: lconst_0
    //   27: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   30: invokestatic 231	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 132	java/lang/Long
    //   36: invokevirtual 235	java/lang/Long:longValue	()J
    //   39: putfield 199	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_Long	J
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 37	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   47: invokevirtual 43	com/tencent/mobileqq/nearby/NearbyAppInterface:getAccount	()Ljava/lang/String;
    //   50: ldc -30
    //   52: iconst_4
    //   53: ldc -19
    //   55: lconst_0
    //   56: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: invokestatic 231	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 132	java/lang/Long
    //   65: invokevirtual 235	java/lang/Long:longValue	()J
    //   68: putfield 201	com/tencent/mobileqq/dating/RankEventManager:b	J
    //   71: aload_0
    //   72: invokespecial 240	com/tencent/mobileqq/dating/RankEventManager:c	()Lcom/tencent/mobileqq/data/RankEventMsg;
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +13 -> 90
    //   80: aload_0
    //   81: aload_1
    //   82: putfield 78	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_ComTencentMobileqqDataRankEventMsg	Lcom/tencent/mobileqq/data/RankEventMsg;
    //   85: aload_0
    //   86: iconst_1
    //   87: putfield 68	com/tencent/mobileqq/dating/RankEventManager:c	I
    //   90: ldc -14
    //   92: iconst_3
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_0
    //   99: getfield 68	com/tencent/mobileqq/dating/RankEventManager:c	I
    //   102: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload_0
    //   109: getfield 199	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_Long	J
    //   112: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   115: aastore
    //   116: dup
    //   117: iconst_2
    //   118: aload_0
    //   119: getfield 201	com/tencent/mobileqq/dating/RankEventManager:b	J
    //   122: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   125: aastore
    //   126: invokestatic 140	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_0
    //   130: iconst_0
    //   131: aconst_null
    //   132: invokespecial 244	com/tencent/mobileqq/dating/RankEventManager:a	(ZLcom/tencent/mobileqq/data/RankEventMsg;)V
    //   135: new 72	com/tencent/mobileqq/data/RankEventMsg
    //   138: dup
    //   139: invokespecial 141	com/tencent/mobileqq/data/RankEventMsg:<init>	()V
    //   142: invokevirtual 144	com/tencent/mobileqq/data/RankEventMsg:getTableName	()Ljava/lang/String;
    //   145: astore 4
    //   147: aload_0
    //   148: getfield 54	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   151: iconst_0
    //   152: aload 4
    //   154: iconst_1
    //   155: anewarray 161	java/lang/String
    //   158: dup
    //   159: iconst_0
    //   160: ldc -10
    //   162: aastore
    //   163: aconst_null
    //   164: aconst_null
    //   165: aconst_null
    //   166: aconst_null
    //   167: aconst_null
    //   168: aconst_null
    //   169: invokevirtual 249	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull +220 -> 394
    //   177: aload_2
    //   178: astore_1
    //   179: aload_2
    //   180: invokeinterface 254 1 0
    //   185: ifeq +209 -> 394
    //   188: aload_2
    //   189: astore_1
    //   190: aload_2
    //   191: iconst_0
    //   192: invokeinterface 258 2 0
    //   197: lstore 6
    //   199: lload 6
    //   201: l2i
    //   202: istore 5
    //   204: aload_2
    //   205: ifnull +186 -> 391
    //   208: aload_2
    //   209: invokeinterface 261 1 0
    //   214: iload 5
    //   216: sipush 5000
    //   219: if_icmple -212 -> 7
    //   222: new 263	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 266
    //   232: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 4
    //   237: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc_w 272
    //   243: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 54	com/tencent/mobileqq/dating/RankEventManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   254: aload_1
    //   255: invokevirtual 278	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   258: istore 8
    //   260: ldc_w 280
    //   263: iconst_4
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: iload 8
    //   271: invokestatic 91	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   274: aastore
    //   275: dup
    //   276: iconst_1
    //   277: iload 5
    //   279: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aastore
    //   283: dup
    //   284: iconst_2
    //   285: sipush 5000
    //   288: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   291: aastore
    //   292: dup
    //   293: iconst_3
    //   294: aload_1
    //   295: aastore
    //   296: invokestatic 186	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: return
    //   300: astore_3
    //   301: aconst_null
    //   302: astore_2
    //   303: aload_2
    //   304: astore_1
    //   305: ldc_w 282
    //   308: iconst_1
    //   309: anewarray 4	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: aload_3
    //   315: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   318: aastore
    //   319: invokestatic 140	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aload_2
    //   323: ifnull +62 -> 385
    //   326: aload_2
    //   327: invokeinterface 261 1 0
    //   332: iconst_0
    //   333: istore 5
    //   335: goto -121 -> 214
    //   338: astore_2
    //   339: aconst_null
    //   340: astore_1
    //   341: aload_1
    //   342: ifnull +9 -> 351
    //   345: aload_1
    //   346: invokeinterface 261 1 0
    //   351: aload_2
    //   352: athrow
    //   353: astore_2
    //   354: ldc_w 280
    //   357: iconst_1
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload_2
    //   364: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   367: aastore
    //   368: invokestatic 140	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: iconst_0
    //   372: istore 8
    //   374: goto -114 -> 260
    //   377: astore_2
    //   378: goto -37 -> 341
    //   381: astore_3
    //   382: goto -79 -> 303
    //   385: iconst_0
    //   386: istore 5
    //   388: goto -174 -> 214
    //   391: goto -177 -> 214
    //   394: iconst_0
    //   395: istore 5
    //   397: goto -193 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	RankEventManager
    //   75	271	1	localObject1	Object
    //   172	155	2	localCursor	android.database.Cursor
    //   338	14	2	localObject2	Object
    //   353	11	2	localException1	Exception
    //   377	1	2	localObject3	Object
    //   300	15	3	localException2	Exception
    //   381	1	3	localException3	Exception
    //   145	91	4	str	String
    //   202	194	5	i	int
    //   197	3	6	l	long
    //   258	115	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   147	173	300	java/lang/Exception
    //   147	173	338	finally
    //   250	260	353	java/lang/Exception
    //   179	188	377	finally
    //   190	199	377	finally
    //   305	322	377	finally
    //   179	188	381	java/lang/Exception
    //   190	199	381	java/lang/Exception
  }
  
  private RankEventMsg c()
  {
    for (;;)
    {
      try
      {
        long l = this.jdField_a_of_type_Long;
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RankEventMsg.class, false, "seq > ? and bDeleted = ? and bReaded = ?", new String[] { String.valueOf(l), String.valueOf(0), String.valueOf(0) }, null, null, "seq desc", String.valueOf(5));
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (RankEventMsg)((List)localObject1).get(0);
          return (RankEventMsg)localObject1;
        }
      }
      catch (Exception localException)
      {
        DatingUtil.b("RankEventManager", new Object[] { "getUnreadEventFromDB", localException.getMessage() });
        Object localObject2 = null;
        continue;
      }
      finally {}
      Object localObject4 = null;
    }
  }
  
  public int a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      b();
    }
    return this.c;
  }
  
  public RankEventMsg a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      RankEventMsg localRankEventMsg = this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg;
      return localRankEventMsg;
    }
  }
  
  public void a()
  {
    boolean bool = this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(3);
    DatingUtil.a("RankEventManager.onDestroy", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.c) });
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg = null;
    if (bool) {
      ThreadManager.a().post(new rgh(this, bool));
    }
  }
  
  public void a(SubMsgType0x27.AppointmentNotify paramAppointmentNotify)
  {
    Object localObject = null;
    DatingUtil.a("onLinePushMsg", new Object[] { Integer.valueOf(this.c), paramAppointmentNotify });
    if (paramAppointmentNotify == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    if (paramAppointmentNotify.bytes_nearby_event_info.has()) {}
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramAppointmentNotify.bytes_nearby_event_info.get().toByteArray();
        if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
          break label321;
        }
        localNearbyEvent = new appoint_define.NearbyEvent();
      }
      catch (Exception localException1)
      {
        try
        {
          localNearbyEvent.mergeFrom(arrayOfByte);
          if (localNearbyEvent != null) {
            break label144;
          }
          DatingUtil.a("onLinePushMsg", new Object[] { "validate msg ", Integer.valueOf(paramAppointmentNotify.uint32_notifytype.get()) });
          return;
        }
        catch (Exception localException2)
        {
          int i;
          long l;
          for (;;) {}
        }
        localException1 = localException1;
        localNearbyEvent = null;
      }
      tmp131_128[0] = localException1.toString();
      DatingUtil.b("onLinePushMsg.exception", tmp131_128);
      continue;
      label144:
      i = localNearbyEvent.uint32_eventtype.get();
      if (i == 1)
      {
        l = localNearbyEvent.msg_rankevent.uint32_seq.get();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg != null) && (l == this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg.seq))
        {
          DatingUtil.b("onLinePushMsg", new Object[] { Long.valueOf(l), "same msg" });
          paramAppointmentNotify = (SubMsgType0x27.AppointmentNotify)localObject;
          if ((paramAppointmentNotify != null) && (paramAppointmentNotify.seq > this.b)) {
            this.b = paramAppointmentNotify.seq;
          }
          a(true, paramAppointmentNotify);
        }
      }
      for (;;)
      {
        DatingUtil.a("onLinePushMsg", new Object[] { Integer.valueOf(i) });
        return;
        paramAppointmentNotify = RankEventMsg.convertFrom((appoint_define.RankEvent)localNearbyEvent.msg_rankevent.get());
        a(paramAppointmentNotify);
        break;
        DatingUtil.b("onLinePushMsg", new Object[] { "unknown msg", Integer.valueOf(i) });
      }
      label321:
      appoint_define.NearbyEvent localNearbyEvent = null;
    }
  }
  
  public void a(short paramShort)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    DatingUtil.a("onGetUnreadFlag", new Object[] { Short.valueOf(paramShort), Integer.valueOf(this.c) });
    if (paramShort == 1) {}
    for (boolean bool = a();; bool = false)
    {
      if (!bool) {
        a(false, null);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, List paramList, long paramLong1, long paramLong2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    DatingUtil.a("onGetUnreadMsgList", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    if (paramBoolean)
    {
      appoint_define.NearbyEvent localNearbyEvent;
      int i;
      if ((paramList != null) && (paramList.size() > 0))
      {
        localNearbyEvent = (appoint_define.NearbyEvent)paramList.get(0);
        if (localNearbyEvent == null)
        {
          DatingUtil.a("onGetUnreadMsgList", new Object[] { "NearbyEvent is null", Integer.valueOf(paramList.size()) });
          return;
        }
        i = localNearbyEvent.uint32_eventtype.get();
        if (i != 1) {
          break label241;
        }
        paramLong1 = localNearbyEvent.msg_rankevent.uint32_seq.get();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg == null) || (paramLong1 != this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg.seq)) {
          break label218;
        }
        DatingUtil.b("onLinePushMsg", new Object[] { Long.valueOf(paramLong1), "same msg" });
        paramList = null;
        if ((paramList != null) && (paramList.seq > this.b)) {
          this.b = paramList.seq;
        }
      }
      for (;;)
      {
        a(false, null);
        return;
        label218:
        paramList = RankEventMsg.convertFrom((appoint_define.RankEvent)localNearbyEvent.msg_rankevent.get());
        a(paramList);
        break;
        label241:
        DatingUtil.b("onGetUnreadMsgList", new Object[] { "unknown msg", Integer.valueOf(i) });
      }
    }
    DatingUtil.a("onGetUnreadMsgList", new Object[] { "fail" });
    a(false, null);
  }
  
  public RankEventMsg b()
  {
    DatingUtil.a("getUnreadEventMsg", new Object[] { Integer.valueOf(this.c) });
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      RankEventMsg localRankEventMsg = c();
      this.jdField_a_of_type_Long = this.b;
      this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg = null;
      this.c = 0;
      if (localRankEventMsg != null)
      {
        ??? = Message.obtain();
        ((Message)???).what = 3;
        ((Message)???).obj = localRankEventMsg;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)???);
        a();
        a(false, null);
      }
      return localRankEventMsg;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return false;
    case 1: 
      a(false, null);
      return false;
    }
    a((RankEventMsg)paramMessage.obj, this.jdField_a_of_type_Long);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\RankEventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */