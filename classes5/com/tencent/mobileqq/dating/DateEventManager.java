package com.tencent.mobileqq.dating;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import appoint.define.appoint_define.DateEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DateEventMsg;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import rcv;

public class DateEventManager
  implements Handler.Callback
{
  public static final int a = 4097;
  public static final String a = "dating_notification_tag";
  public static final int b = 20;
  private static final int c = 100;
  private static final int d = 5000;
  private static final int e = 5;
  private static final int h = 1;
  private static final int i = 3;
  private long jdField_a_of_type_Long;
  private DatingManager jdField_a_of_type_ComTencentMobileqqDatingDatingManager;
  private List jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  private int f;
  private int g;
  
  public DateEventManager(DatingManager paramDatingManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager = paramDatingManager;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.a(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    this.f = 0;
    this.g = 0;
  }
  
  private DateEventMsg a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator.hasNext())
          {
            DateEventMsg localDateEventMsg = (DateEventMsg)localIterator.next();
            if ((localDateEventMsg == null) || (localDateEventMsg.event_id != paramLong)) {
              continue;
            }
            ??? = localDateEventMsg;
            if (localDateEventMsg == null)
            {
              ??? = localDateEventMsg;
              if (paramLong >= this.jdField_a_of_type_Long) {
                ??? = (DateEventMsg)this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DateEventMsg.class, String.valueOf(paramLong));
              }
            }
            return (DateEventMsg)???;
          }
        }
      }
      Object localObject2 = null;
    }
  }
  
  private void a(DateEventMsg paramDateEventMsg)
  {
    if (paramDateEventMsg == null) {
      return;
    }
    if (paramDateEventMsg.bReaded == 0) {}
    for (;;)
    {
      DatingInfo localDatingInfo;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int k = this.jdField_a_of_type_JavaUtilList.size();
        j = 0;
        if (j >= k) {
          break label451;
        }
        if (paramDateEventMsg.compareTo((DateEventMsg)this.jdField_a_of_type_JavaUtilList.get(j)) >= 0)
        {
          if (j < 0) {
            break label347;
          }
          this.jdField_a_of_type_JavaUtilList.add(j, paramDateEventMsg);
          if (this.jdField_a_of_type_JavaUtilList.size() > 100) {
            this.jdField_a_of_type_JavaUtilList.remove(100);
          }
          this.g += 1;
          if ((paramDateEventMsg.type == 4) || (paramDateEventMsg.type == 5))
          {
            ??? = DatingUtil.a(paramDateEventMsg.date_info);
            localDatingInfo = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a().a((String)???, true, false, true);
            if (localDatingInfo != null)
            {
              if ((paramDateEventMsg.type != 4) || (localDatingInfo.datingSelFlag == 1)) {
                break label366;
              }
              localDatingInfo.datingSelFlag = 1;
              bool = true;
              if (bool)
              {
                if (localDatingInfo.getStatus() != 1000) {
                  break label392;
                }
                this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDatingInfo);
              }
              DatingUtil.a("saveDateEventMsg", new Object[] { Integer.valueOf(paramDateEventMsg.type), Boolean.valueOf(bool), ???, Integer.valueOf(localDatingInfo.datingSelFlag), Integer.valueOf(localDatingInfo.datingStatus) });
            }
          }
          if (paramDateEventMsg.getStatus() != 1000) {
            break label422;
          }
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramDateEventMsg);
          if (paramDateEventMsg.getStatus() != 1000) {
            break;
          }
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.remove(paramDateEventMsg)) {
          this.g -= 1;
        }
        DatingUtil.a("saveDateEventMsg", new Object[] { "persistOrReplace failed." });
        return;
        j += 1;
        continue;
        label347:
        this.jdField_a_of_type_JavaUtilList.add(paramDateEventMsg);
        continue;
        paramDateEventMsg = finally;
        throw paramDateEventMsg;
        label366:
        if ((paramDateEventMsg.type != 5) || (localDatingInfo.datingStatus != 0)) {
          break label445;
        }
        localDatingInfo.datingStatus = 2;
        bool = true;
        continue;
        label392:
        if (localDatingInfo.getStatus() == 1003) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localDatingInfo);
      }
      label422:
      if (paramDateEventMsg.getStatus() == 1003) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramDateEventMsg);
      return;
      label445:
      boolean bool = false;
      continue;
      label451:
      int j = -1;
    }
  }
  
  /* Error */
  private void a(DateEventMsg paramDateEventMsg, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc -59
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc -57
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: lload_2
    //   16: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   19: aastore
    //   20: invokestatic 206	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_1
    //   24: astore 4
    //   26: aload_1
    //   27: ifnonnull +12 -> 39
    //   30: new 93	com/tencent/mobileqq/data/DateEventMsg
    //   33: dup
    //   34: invokespecial 207	com/tencent/mobileqq/data/DateEventMsg:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: invokevirtual 211	com/tencent/mobileqq/data/DateEventMsg:getTableName	()Ljava/lang/String;
    //   44: astore_1
    //   45: new 213	android/content/ContentValues
    //   48: dup
    //   49: invokespecial 214	android/content/ContentValues:<init>	()V
    //   52: astore 4
    //   54: aload 4
    //   56: ldc -41
    //   58: iconst_1
    //   59: invokestatic 220	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   62: invokevirtual 224	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Byte;)V
    //   65: aload_0
    //   66: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   69: getfield 101	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   72: aload_1
    //   73: aload 4
    //   75: ldc -30
    //   77: iconst_2
    //   78: anewarray 103	java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: lload_2
    //   84: invokestatic 107	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: iconst_0
    //   91: invokestatic 229	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   94: aastore
    //   95: invokevirtual 232	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z
    //   98: pop
    //   99: aload_0
    //   100: monitorexit
    //   101: return
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 235	java/lang/Exception:printStackTrace	()V
    //   107: ldc -59
    //   109: iconst_2
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: ldc -57
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_1
    //   121: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: aastore
    //   125: invokestatic 206	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: goto -29 -> 99
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	DateEventManager
    //   0	136	1	paramDateEventMsg	DateEventMsg
    //   0	136	2	paramLong	long
    //   24	50	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	99	102	java/lang/Exception
    //   2	23	131	finally
    //   30	39	131	finally
    //   39	99	131	finally
    //   103	128	131	finally
  }
  
  private void a(boolean paramBoolean, DateEventMsg paramDateEventMsg)
  {
    if (QLog.isDevelopLevel()) {
      DatingUtil.a("notifyNewMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.g), paramDateEventMsg });
    }
    int j = this.g;
    Object localObject = paramDateEventMsg;
    if (paramDateEventMsg == null) {
      localObject = a();
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication == null) {}
    do
    {
      for (;;)
      {
        ((DatingHandler)this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(2)).a(0, this.g);
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(0, this.g, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b) });
        return;
        if (j != 0) {
          break;
        }
        paramDateEventMsg = (NotificationManager)localBaseApplication.getSystemService("notification");
        if (paramDateEventMsg != null) {
          paramDateEventMsg.cancel("dating_notification_tag", 4097);
        }
      }
    } while ((localObject == null) || (!paramBoolean) || ((!this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.isBackground_Pause) && (!this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.isBackground_Stop)));
    localObject = ((DateEventMsg)localObject).getDescStr(localBaseApplication, true);
    if (j == 1)
    {
      paramDateEventMsg = localBaseApplication.getString(2131371679);
      label218:
      Bitmap localBitmap = BitmapManager.a(localBaseApplication.getResources(), 2130840649);
      paramDateEventMsg = new NotificationCompat.Builder(localBaseApplication).setContentTitle(paramDateEventMsg).setContentText((CharSequence)localObject).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker((CharSequence)localObject).setWhen(System.currentTimeMillis());
      if (localBitmap == null) {
        break label420;
      }
      paramDateEventMsg.setLargeIcon(localBitmap);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramDateEventMsg.setSmallIcon(2130840649);
      }
      paramDateEventMsg.setContentIntent(PendingIntent.getActivity(localBaseApplication, 0, null, 134217728));
      paramDateEventMsg = paramDateEventMsg.build();
      paramDateEventMsg.flags |= 0x10;
      paramDateEventMsg.defaults |= 0x1;
      paramDateEventMsg.defaults |= 0x4;
      paramDateEventMsg.icon = 2130840649;
      localObject = (NotificationManager)localBaseApplication.getSystemService("notification");
      if (localObject == null) {
        break;
      }
      ((NotificationManager)localObject).cancel("dating_notification_tag", 4097);
      ((NotificationManager)localObject).notify("dating_notification_tag", 4097, paramDateEventMsg);
      break;
      paramDateEventMsg = String.format(localBaseApplication.getString(2131371773), new Object[] { Integer.valueOf(j) });
      break label218;
      label420:
      localObject = BitmapManager.a(localBaseApplication.getResources(), 2130840649);
      if (localObject != null) {
        paramDateEventMsg.setLargeIcon((Bitmap)localObject);
      }
    }
  }
  
  private boolean a()
  {
    DatingHandler localDatingHandler = (DatingHandler)this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(2);
    if (localDatingHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 30000L);
      localDatingHandler.b(this.b, this.jdField_a_of_type_Long, 100);
    }
    for (boolean bool = true;; bool = false)
    {
      DatingUtil.a("startFetchUnreadEvents", new Object[] { Boolean.valueOf(bool) });
      return bool;
      DatingUtil.b("MSG_GET_MORE_EVENT", new Object[] { "dh is null", Long.valueOf(this.b) });
    }
  }
  
  private List b()
  {
    try
    {
      long l = this.jdField_a_of_type_Long;
      List localList = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DateEventMsg.class, false, "event_id > ? and bDeleted = ? and bReaded = ? ", new String[] { String.valueOf(l), String.valueOf(0), String.valueOf(0) }, null, null, "event_id desc", String.valueOf(300));
      return localList;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        DatingUtil.b("DateEventManager", new Object[] { "getUnreadEventListFromDB", localException.getMessage() });
        Object localObject1 = null;
      }
    }
    finally {}
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 428	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 428	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Boolean	Z
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   18: getfield 261	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   21: invokevirtual 431	com/tencent/mobileqq/nearby/NearbyAppInterface:getAccount	()Ljava/lang/String;
    //   24: ldc_w 433
    //   27: iconst_4
    //   28: ldc_w 435
    //   31: lconst_0
    //   32: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   35: invokestatic 440	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 201	java/lang/Long
    //   41: invokevirtual 443	java/lang/Long:longValue	()J
    //   44: putfield 70	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Long	J
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   52: getfield 261	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   55: invokevirtual 431	com/tencent/mobileqq/nearby/NearbyAppInterface:getAccount	()Ljava/lang/String;
    //   58: ldc_w 433
    //   61: iconst_4
    //   62: ldc_w 445
    //   65: lconst_0
    //   66: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: invokestatic 440	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 201	java/lang/Long
    //   75: invokevirtual 443	java/lang/Long:longValue	()J
    //   78: putfield 276	com/tencent/mobileqq/dating/DateEventManager:b	J
    //   81: aload_0
    //   82: invokespecial 447	com/tencent/mobileqq/dating/DateEventManager:b	()Ljava/util/List;
    //   85: astore_1
    //   86: aload_1
    //   87: ifnonnull +80 -> 167
    //   90: iconst_0
    //   91: istore 5
    //   93: iconst_0
    //   94: istore 6
    //   96: iload 6
    //   98: iload 5
    //   100: if_icmpge +78 -> 178
    //   103: aload_1
    //   104: iload 6
    //   106: invokeinterface 121 2 0
    //   111: checkcast 93	com/tencent/mobileqq/data/DateEventMsg
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +42 -> 158
    //   119: aload_0
    //   120: getfield 62	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   123: invokeinterface 77 1 0
    //   128: bipush 100
    //   130: if_icmpge +18 -> 148
    //   133: aload_2
    //   134: invokevirtual 450	com/tencent/mobileqq/data/DateEventMsg:init	()V
    //   137: aload_0
    //   138: getfield 62	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   141: aload_2
    //   142: invokeinterface 189 2 0
    //   147: pop
    //   148: aload_0
    //   149: aload_0
    //   150: getfield 66	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   153: iconst_1
    //   154: iadd
    //   155: putfield 66	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   158: iload 6
    //   160: iconst_1
    //   161: iadd
    //   162: istore 6
    //   164: goto -68 -> 96
    //   167: aload_1
    //   168: invokeinterface 77 1 0
    //   173: istore 5
    //   175: goto -82 -> 93
    //   178: ldc_w 451
    //   181: iconst_3
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield 66	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   191: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload_0
    //   198: getfield 70	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Long	J
    //   201: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   204: aastore
    //   205: dup
    //   206: iconst_2
    //   207: aload_0
    //   208: getfield 276	com/tencent/mobileqq/dating/DateEventManager:b	J
    //   211: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   214: aastore
    //   215: invokestatic 206	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_0
    //   219: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   222: getfield 261	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   225: iconst_2
    //   226: invokevirtual 266	com/tencent/mobileqq/nearby/NearbyAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   229: checkcast 268	com/tencent/mobileqq/dating/DatingHandler
    //   232: iconst_0
    //   233: aload_0
    //   234: getfield 66	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   237: invokevirtual 271	com/tencent/mobileqq/dating/DatingHandler:a	(II)V
    //   240: aload_0
    //   241: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   244: getfield 261	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   247: invokevirtual 274	com/tencent/mobileqq/nearby/NearbyAppInterface:a	()Lcom/tencent/mobileqq/nearby/ipc/NearbyProcManager;
    //   250: iconst_0
    //   251: aload_0
    //   252: getfield 66	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   255: iconst_2
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: aload_0
    //   262: getfield 70	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Long	J
    //   265: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   268: aastore
    //   269: dup
    //   270: iconst_1
    //   271: aload_0
    //   272: getfield 276	com/tencent/mobileqq/dating/DateEventManager:b	J
    //   275: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   278: aastore
    //   279: invokevirtual 281	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:a	(II[Ljava/lang/Object;)V
    //   282: new 93	com/tencent/mobileqq/data/DateEventMsg
    //   285: dup
    //   286: invokespecial 207	com/tencent/mobileqq/data/DateEventMsg:<init>	()V
    //   289: invokevirtual 211	com/tencent/mobileqq/data/DateEventMsg:getTableName	()Ljava/lang/String;
    //   292: astore 4
    //   294: aload_0
    //   295: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   298: getfield 101	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   301: iconst_0
    //   302: aload 4
    //   304: iconst_1
    //   305: anewarray 103	java/lang/String
    //   308: dup
    //   309: iconst_0
    //   310: ldc_w 453
    //   313: aastore
    //   314: aconst_null
    //   315: aconst_null
    //   316: aconst_null
    //   317: aconst_null
    //   318: aconst_null
    //   319: aconst_null
    //   320: invokevirtual 456	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   323: astore_2
    //   324: aload_2
    //   325: ifnull +223 -> 548
    //   328: aload_2
    //   329: astore_1
    //   330: aload_2
    //   331: invokeinterface 461 1 0
    //   336: ifeq +212 -> 548
    //   339: aload_2
    //   340: astore_1
    //   341: aload_2
    //   342: iconst_0
    //   343: invokeinterface 465 2 0
    //   348: lstore 7
    //   350: lload 7
    //   352: l2i
    //   353: istore 5
    //   355: aload_2
    //   356: ifnull +189 -> 545
    //   359: aload_2
    //   360: invokeinterface 468 1 0
    //   365: iload 5
    //   367: sipush 5000
    //   370: if_icmple -363 -> 7
    //   373: new 470	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 473
    //   383: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 4
    //   388: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: ldc_w 479
    //   394: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 482	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: astore_1
    //   401: aload_0
    //   402: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   405: getfield 101	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   408: aload_1
    //   409: invokevirtual 485	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   412: istore 9
    //   414: ldc_w 487
    //   417: iconst_4
    //   418: anewarray 4	java/lang/Object
    //   421: dup
    //   422: iconst_0
    //   423: iload 9
    //   425: invokestatic 175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   428: aastore
    //   429: dup
    //   430: iconst_1
    //   431: iload 5
    //   433: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   436: aastore
    //   437: dup
    //   438: iconst_2
    //   439: sipush 5000
    //   442: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   445: aastore
    //   446: dup
    //   447: iconst_3
    //   448: aload_1
    //   449: aastore
    //   450: invokestatic 181	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   453: return
    //   454: astore_3
    //   455: aconst_null
    //   456: astore_2
    //   457: aload_2
    //   458: astore_1
    //   459: ldc_w 489
    //   462: iconst_1
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: aload_3
    //   469: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   472: aastore
    //   473: invokestatic 206	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   476: aload_2
    //   477: ifnull +62 -> 539
    //   480: aload_2
    //   481: invokeinterface 468 1 0
    //   486: iconst_0
    //   487: istore 5
    //   489: goto -124 -> 365
    //   492: astore_2
    //   493: aconst_null
    //   494: astore_1
    //   495: aload_1
    //   496: ifnull +9 -> 505
    //   499: aload_1
    //   500: invokeinterface 468 1 0
    //   505: aload_2
    //   506: athrow
    //   507: astore_2
    //   508: ldc_w 487
    //   511: iconst_1
    //   512: anewarray 4	java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: aload_2
    //   518: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   521: aastore
    //   522: invokestatic 206	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   525: iconst_0
    //   526: istore 9
    //   528: goto -114 -> 414
    //   531: astore_2
    //   532: goto -37 -> 495
    //   535: astore_3
    //   536: goto -79 -> 457
    //   539: iconst_0
    //   540: istore 5
    //   542: goto -177 -> 365
    //   545: goto -180 -> 365
    //   548: iconst_0
    //   549: istore 5
    //   551: goto -196 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	DateEventManager
    //   85	415	1	localObject1	Object
    //   114	367	2	localObject2	Object
    //   492	14	2	localObject3	Object
    //   507	11	2	localException1	Exception
    //   531	1	2	localObject4	Object
    //   454	15	3	localException2	Exception
    //   535	1	3	localException3	Exception
    //   292	95	4	str	String
    //   91	459	5	j	int
    //   94	69	6	k	int
    //   348	3	7	l	long
    //   412	115	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   294	324	454	java/lang/Exception
    //   294	324	492	finally
    //   401	414	507	java/lang/Exception
    //   330	339	531	finally
    //   341	350	531	finally
    //   459	476	531	finally
    //   330	339	535	java/lang/Exception
    //   341	350	535	java/lang/Exception
  }
  
  public int a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      b();
    }
    return this.g;
  }
  
  public DateEventMsg a()
  {
    DateEventMsg localDateEventMsg = null;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        localDateEventMsg = (DateEventMsg)this.jdField_a_of_type_JavaUtilList.get(0);
      }
      return localDateEventMsg;
    }
  }
  
  public List a()
  {
    DatingUtil.a("getUnreadEventMsg", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    int j;
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      j = this.jdField_a_of_type_JavaUtilList.size();
      if (j < this.g)
      {
        List localList1 = b();
        if ((localList1 != null) && (localList1.size() > 0))
        {
          localObject2 = localList1.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            DateEventMsg localDateEventMsg = (DateEventMsg)((Iterator)localObject2).next();
            if (localDateEventMsg != null) {
              localDateEventMsg.init();
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (j > 0) {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((List)localObject1).size() != 0) {}
        }
        else
        {
          localObject2 = new ArrayList(20);
          ((List)localObject2).addAll(this.jdField_a_of_type_JavaUtilList);
        }
      }
      this.jdField_a_of_type_Long = this.b;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.g = 0;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = ((List)localObject2).get(0);
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
        a();
        a(false, null);
      }
      return (List)localObject2;
      Message localMessage = null;
    }
  }
  
  public void a()
  {
    boolean bool = this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(3);
    DatingUtil.a("DateEventManager.onDestory", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.g), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    NotificationManager localNotificationManager = (NotificationManager)BaseApplicationImpl.getContext().getSystemService("notification");
    if (localNotificationManager != null) {
      localNotificationManager.cancel("dating_notification_tag", 4097);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (bool) {
      ThreadManager.a().post(new rcv(this, bool));
    }
  }
  
  /* Error */
  public void a(tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify paramAppointmentNotify)
  {
    // Byte code:
    //   0: ldc_w 550
    //   3: iconst_2
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: aload_0
    //   10: getfield 66	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   13: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_1
    //   20: aastore
    //   21: invokestatic 181	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_1
    //   25: ifnonnull +4 -> 29
    //   28: return
    //   29: aload_0
    //   30: getfield 428	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Boolean	Z
    //   33: ifne +7 -> 40
    //   36: aload_0
    //   37: invokespecial 492	com/tencent/mobileqq/dating/DateEventManager:b	()V
    //   40: aconst_null
    //   41: astore_3
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_1
    //   45: getfield 556	tencent/im/s2c/msgtype0x210/submsgtype0x27/SubMsgType0x27$AppointmentNotify:bytes_event_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   48: invokevirtual 561	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   51: ifeq +41 -> 92
    //   54: aload_1
    //   55: getfield 556	tencent/im/s2c/msgtype0x210/submsgtype0x27/SubMsgType0x27$AppointmentNotify:bytes_event_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: invokevirtual 564	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   61: invokevirtual 570	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +512 -> 580
    //   71: aload 4
    //   73: arraylength
    //   74: ifle +506 -> 580
    //   77: new 572	appoint/define/appoint_define$DateEvent
    //   80: dup
    //   81: invokespecial 573	appoint/define/appoint_define$DateEvent:<init>	()V
    //   84: astore_2
    //   85: aload_2
    //   86: aload 4
    //   88: invokevirtual 577	appoint/define/appoint_define$DateEvent:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: pop
    //   92: aload_2
    //   93: ifnonnull +47 -> 140
    //   96: ldc_w 550
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: ldc_w 579
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload_1
    //   112: getfield 583	tencent/im/s2c/msgtype0x210/submsgtype0x27/SubMsgType0x27$AppointmentNotify:uint32_notifytype	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 587	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   118: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: invokestatic 206	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: return
    //   126: astore 4
    //   128: aload_3
    //   129: astore_2
    //   130: aload 4
    //   132: astore_3
    //   133: aload_3
    //   134: invokevirtual 235	java/lang/Exception:printStackTrace	()V
    //   137: goto -45 -> 92
    //   140: aload_2
    //   141: getfield 590	appoint/define/appoint_define$DateEvent:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   144: invokevirtual 587	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   147: istore 5
    //   149: aload_2
    //   150: getfield 594	appoint/define/appoint_define$DateEvent:uint64_event_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   153: invokevirtual 598	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   156: lstore 8
    //   158: iload 5
    //   160: bipush 6
    //   162: if_icmpeq +8 -> 170
    //   165: iload 5
    //   167: ifne +151 -> 318
    //   170: iload 5
    //   172: bipush 6
    //   174: if_icmpne +112 -> 286
    //   177: aload_2
    //   178: getfield 601	appoint/define/appoint_define$DateEvent:uint64_cancel_event_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   181: invokevirtual 598	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   184: lstore 6
    //   186: aload_0
    //   187: lload 6
    //   189: invokespecial 603	com/tencent/mobileqq/dating/DateEventManager:a	(J)Lcom/tencent/mobileqq/data/DateEventMsg;
    //   192: astore_1
    //   193: aload_1
    //   194: ifnull +29 -> 223
    //   197: aload_1
    //   198: iconst_1
    //   199: putfield 606	com/tencent/mobileqq/data/DateEventMsg:bDeleted	B
    //   202: aload_1
    //   203: invokevirtual 182	com/tencent/mobileqq/data/DateEventMsg:getStatus	()I
    //   206: sipush 1000
    //   209: if_icmpne +84 -> 293
    //   212: aload_0
    //   213: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   216: getfield 101	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   219: aload_1
    //   220: invokevirtual 163	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   223: ldc_w 550
    //   226: iconst_3
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: ldc_w 608
    //   235: aastore
    //   236: dup
    //   237: iconst_1
    //   238: lload 6
    //   240: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   243: aastore
    //   244: dup
    //   245: iconst_2
    //   246: aload_1
    //   247: aastore
    //   248: invokestatic 181	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: ldc_w 550
    //   254: iconst_3
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: iload 5
    //   262: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: lload 8
    //   270: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   273: aastore
    //   274: dup
    //   275: iconst_2
    //   276: lload 6
    //   278: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   281: aastore
    //   282: invokestatic 181	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: return
    //   286: lload 8
    //   288: lstore 6
    //   290: goto -104 -> 186
    //   293: aload_1
    //   294: invokevirtual 182	com/tencent/mobileqq/data/DateEventMsg:getStatus	()I
    //   297: sipush 1003
    //   300: if_icmpeq -77 -> 223
    //   303: aload_0
    //   304: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   307: getfield 101	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   310: aload_1
    //   311: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   314: pop
    //   315: goto -92 -> 223
    //   318: iload 5
    //   320: iconst_1
    //   321: if_icmplt +214 -> 535
    //   324: iload 5
    //   326: iconst_5
    //   327: if_icmpgt +208 -> 535
    //   330: aload_0
    //   331: lload 8
    //   333: invokespecial 603	com/tencent/mobileqq/dating/DateEventManager:a	(J)Lcom/tencent/mobileqq/data/DateEventMsg;
    //   336: astore_1
    //   337: aload_1
    //   338: ifnonnull +170 -> 508
    //   341: aload_2
    //   342: invokestatic 612	com/tencent/mobileqq/data/DateEventMsg:convertFrom	(Lappoint/define/appoint_define$DateEvent;)Lcom/tencent/mobileqq/data/DateEventMsg;
    //   345: astore_1
    //   346: aload_0
    //   347: aload_1
    //   348: invokespecial 614	com/tencent/mobileqq/dating/DateEventManager:a	(Lcom/tencent/mobileqq/data/DateEventMsg;)V
    //   351: aload_1
    //   352: ifnull +225 -> 577
    //   355: aload_1
    //   356: getfield 139	com/tencent/mobileqq/data/DateEventMsg:date_info	Lappoint/define/appoint_define$AppointInfo;
    //   359: ifnull +218 -> 577
    //   362: aload_1
    //   363: getfield 139	com/tencent/mobileqq/data/DateEventMsg:date_info	Lappoint/define/appoint_define$AppointInfo;
    //   366: getfield 620	appoint/define/appoint_define$AppointInfo:msg_appoint_id	Lappoint/define/appoint_define$AppointID;
    //   369: invokevirtual 623	appoint/define/appoint_define$AppointID:has	()Z
    //   372: ifeq +205 -> 577
    //   375: aload_1
    //   376: getfield 139	com/tencent/mobileqq/data/DateEventMsg:date_info	Lappoint/define/appoint_define$AppointInfo;
    //   379: getfield 620	appoint/define/appoint_define$AppointInfo:msg_appoint_id	Lappoint/define/appoint_define$AppointID;
    //   382: invokevirtual 626	appoint/define/appoint_define$AppointID:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   385: checkcast 622	appoint/define/appoint_define$AppointID
    //   388: invokestatic 629	com/tencent/mobileqq/dating/DatingUtil:a	(Lappoint/define/appoint_define$AppointID;)Ljava/lang/String;
    //   391: astore_2
    //   392: ldc_w 550
    //   395: iconst_2
    //   396: anewarray 4	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: iload 5
    //   403: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: aastore
    //   407: dup
    //   408: iconst_1
    //   409: aload_2
    //   410: aastore
    //   411: invokestatic 206	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: aload_0
    //   415: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   418: aload_2
    //   419: iconst_0
    //   420: invokevirtual 632	com/tencent/mobileqq/dating/DatingManager:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/DatingInfo;
    //   423: astore_3
    //   424: aload_3
    //   425: ifnull +8 -> 433
    //   428: aload_3
    //   429: lconst_0
    //   430: putfield 635	com/tencent/mobileqq/data/DatingInfo:lastUpdateTime	J
    //   433: iload 5
    //   435: iconst_5
    //   436: if_icmpne +34 -> 470
    //   439: aload_2
    //   440: invokestatic 641	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   443: ifne +27 -> 470
    //   446: aload_2
    //   447: aload_0
    //   448: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   451: invokevirtual 643	com/tencent/mobileqq/dating/DatingManager:c	()Ljava/lang/String;
    //   454: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   457: ifeq +13 -> 470
    //   460: aload_0
    //   461: getfield 43	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   464: ldc_w 648
    //   467: invokevirtual 651	com/tencent/mobileqq/dating/DatingManager:b	(Ljava/lang/String;)V
    //   470: aload_1
    //   471: ifnull +25 -> 496
    //   474: aload_1
    //   475: getfield 96	com/tencent/mobileqq/data/DateEventMsg:event_id	J
    //   478: aload_0
    //   479: getfield 276	com/tencent/mobileqq/dating/DateEventManager:b	J
    //   482: lconst_1
    //   483: ladd
    //   484: lcmp
    //   485: ifne +11 -> 496
    //   488: aload_0
    //   489: aload_1
    //   490: getfield 96	com/tencent/mobileqq/data/DateEventMsg:event_id	J
    //   493: putfield 276	com/tencent/mobileqq/dating/DateEventManager:b	J
    //   496: aload_0
    //   497: iconst_1
    //   498: aload_1
    //   499: invokespecial 522	com/tencent/mobileqq/dating/DateEventManager:a	(ZLcom/tencent/mobileqq/data/DateEventMsg;)V
    //   502: lconst_0
    //   503: lstore 6
    //   505: goto -254 -> 251
    //   508: ldc_w 550
    //   511: iconst_2
    //   512: anewarray 4	java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: lload 8
    //   519: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   522: aastore
    //   523: dup
    //   524: iconst_1
    //   525: ldc_w 653
    //   528: aastore
    //   529: invokestatic 206	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   532: goto -62 -> 470
    //   535: ldc_w 550
    //   538: iconst_3
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: ldc_w 655
    //   547: aastore
    //   548: dup
    //   549: iconst_1
    //   550: lload 8
    //   552: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   555: aastore
    //   556: dup
    //   557: iconst_2
    //   558: iload 5
    //   560: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: aastore
    //   564: invokestatic 206	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   567: lconst_0
    //   568: lstore 6
    //   570: goto -319 -> 251
    //   573: astore_3
    //   574: goto -441 -> 133
    //   577: goto -107 -> 470
    //   580: aconst_null
    //   581: astore_2
    //   582: goto -490 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	DateEventManager
    //   0	585	1	paramAppointmentNotify	tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify
    //   43	539	2	localObject1	Object
    //   41	388	3	localObject2	Object
    //   573	1	3	localException1	Exception
    //   64	23	4	arrayOfByte	byte[]
    //   126	5	4	localException2	Exception
    //   147	412	5	j	int
    //   184	385	6	l1	long
    //   156	395	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   54	66	126	java/lang/Exception
    //   71	85	126	java/lang/Exception
    //   85	92	573	java/lang/Exception
  }
  
  public void a(short paramShort)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    DatingUtil.a("onGetUnreadFlag", new Object[] { Short.valueOf(paramShort), Integer.valueOf(this.g), Integer.valueOf(this.f) });
    if (paramShort == 1) {
      this.f = 0;
    }
    for (boolean bool = a();; bool = false)
    {
      if (!bool) {
        a(false, null);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, List paramList, long paramLong1, long paramLong2, long paramLong3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    DatingUtil.a("onGetUnreadMsgList", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        paramList = paramList.iterator();
      }
      while (paramList.hasNext())
      {
        ??? = (appoint_define.DateEvent)paramList.next();
        if (??? != null)
        {
          j = ((appoint_define.DateEvent)???).uint32_type.get();
          paramLong2 = ((appoint_define.DateEvent)???).uint64_event_id.get();
          label156:
          DateEventMsg localDateEventMsg;
          if ((j == 0) || (j == 6)) {
            if (j == 6)
            {
              paramLong1 = ((appoint_define.DateEvent)???).uint64_cancel_event_id.get();
              localDateEventMsg = a(paramLong1);
              if (localDateEventMsg != null)
              {
                localDateEventMsg.bDeleted = 1;
                if (localDateEventMsg.getStatus() != 1000) {
                  break label282;
                }
                this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDateEventMsg);
              }
            }
          }
          for (;;)
          {
            synchronized (this.jdField_a_of_type_JavaUtilList)
            {
              this.jdField_a_of_type_JavaUtilList.remove(localDateEventMsg);
              if (paramLong2 > this.b) {
                this.b = paramLong2;
              }
              DatingUtil.a("onGetUnreadMsgList", new Object[] { Integer.valueOf(j), Long.valueOf(paramLong2), Long.valueOf(this.b) });
              break;
              paramLong1 = paramLong2;
              break label156;
              label282:
              if (localDateEventMsg.getStatus() == 1003) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localDateEventMsg);
            }
            if ((j >= 1) && (j <= 5)) {
              if (a(paramLong2) == null) {
                a(DateEventMsg.convertFrom((appoint_define.DateEvent)???));
              } else {
                DatingUtil.a("onGetUnreadMsgList", new Object[] { Long.valueOf(paramLong2), "same msg" });
              }
            }
          }
          this.b = paramLong3;
        }
      }
      if (this.b < paramLong3) {}
      for (int j = 1;; j = 0)
      {
        boolean bool = false;
        paramBoolean = bool;
        if (j != 0)
        {
          paramBoolean = bool;
          if (this.f < 5)
          {
            this.f += 1;
            paramBoolean = a();
          }
        }
        if (!paramBoolean)
        {
          this.b = paramLong3;
          DatingUtil.a("onGetUnreadMsgList", new Object[] { Integer.valueOf(this.f) });
          a(false, null);
        }
        return;
      }
    }
    DatingUtil.a("onGetUnreadMsgList", new Object[] { Integer.valueOf(this.f) });
    a(false, null);
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
    a((DateEventMsg)paramMessage.obj, this.jdField_a_of_type_Long);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DateEventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */