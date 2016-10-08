package com.tencent.mobileqq.nearby.ipc;

import EncounterSvc.RespEncounterInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import appoint.define.appoint_define.FeedEvent;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.bitapp.preDownload.IRNPreDownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DateEventManager;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.RankEventManager;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.util.FaceManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

public class NearbyProcManager
  implements Manager
{
  private NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  private NearbyProcess jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcess;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private int[] jdField_a_of_type_ArrayOfInt;
  private boolean[] jdField_a_of_type_ArrayOfBoolean;
  private List jdField_b_of_type_JavaUtilList;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  public NearbyProcManager(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcess = new NearbyProcess(paramNearbyAppInterface, this);
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.c();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.b();
  }
  
  private void a(SubMsgType0x27.AppointmentNotify paramAppointmentNotify)
  {
    if (paramAppointmentNotify == null) {}
    for (;;)
    {
      return;
      long l = paramAppointmentNotify.uint32_notifytype.get();
      if ((l == 2L) || (l == 4L))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.nearby", 2, "hasOnLinePush|shield dating notify");
        return;
      }
      if (l == 5L)
      {
        localObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
        if (localObject != null)
        {
          ((DatingManager)localObject).a().a(paramAppointmentNotify);
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.dating", 2, "online push SubMsgType0x27.AppointmentNotify mng is null");
        return;
      }
      if ((l != 6L) || (!paramAppointmentNotify.bytes_feed_event_info.has())) {
        continue;
      }
      boolean bool = NearbySPUtil.c(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.nearby", 4, "fresh news event push. isSwitchOn=" + bool);
      }
      if (!bool) {
        continue;
      }
      Object localObject = new appoint_define.FeedEvent();
      try
      {
        ((appoint_define.FeedEvent)localObject).mergeFrom(paramAppointmentNotify.bytes_feed_event_info.get().toByteArray());
        if ((!((appoint_define.FeedEvent)localObject).uint64_event_id.has()) || (!((appoint_define.FeedEvent)localObject).uint32_eventtype.has())) {
          continue;
        }
        ((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211)).a((appoint_define.FeedEvent)localObject);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        l = -1L;
        if (((appoint_define.FeedEvent)localObject).uint64_cancel_event_id.has()) {
          l = ((appoint_define.FeedEvent)localObject).uint64_cancel_event_id.get();
        }
        QLog.i("Q.nearby", 4, "fresh news event push. eventId=" + ((appoint_define.FeedEvent)localObject).uint64_event_id.get() + ", type=" + ((appoint_define.FeedEvent)localObject).uint32_eventtype.get() + ", cancelId=" + l);
        return;
      }
      catch (Exception paramAppointmentNotify)
      {
        for (;;)
        {
          paramAppointmentNotify.printStackTrace();
        }
      }
    }
  }
  
  private Object[] a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcess.a(paramInt);
  }
  
  private Message b(Message paramMessage)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcess.a(paramMessage);
  }
  
  private Object[] b(int paramInt, Object... paramVarArgs)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcess.a(paramInt, paramVarArgs);
  }
  
  public Message a(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return null;
      } while (localObject == null);
      a(4120, new Object[] { ((Bundle)localObject).getStringArrayList("keys"), ((Bundle)localObject).getStringArrayList("paths") });
      return null;
      paramMessage = paramMessage.getData();
    } while (paramMessage == null);
    int i = paramMessage.getInt("headType");
    localObject = paramMessage.getString("id");
    int j = paramMessage.getInt("idType");
    ((FaceManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(215)).a(FaceInfo.a(i, (String)localObject, j, 3));
    return null;
  }
  
  public DynamicAvatar a(int paramInt, String paramString)
  {
    Object localObject = new Message();
    ((Message)localObject).what = 4146;
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("id", paramString);
    ((Message)localObject).setData(localBundle);
    paramString = b((Message)localObject);
    if (paramString == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      paramString = paramString.getData();
      paramString.setClassLoader(DynamicAvatar.class.getClassLoader());
      localObject = (DynamicAvatar)paramString.getParcelable("avatarInfo");
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.i("Q.dynamicAvatar", 2, "ipc getDynamicAvatarInfo : " + localObject);
    return (DynamicAvatar)localObject;
  }
  
  public Setting a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4135;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key", paramString);
    localMessage.setData((Bundle)localObject);
    localObject = b(localMessage);
    localMessage = null;
    paramString = localMessage;
    if (localObject != null)
    {
      localObject = ((Message)localObject).getData();
      paramString = localMessage;
      if (localObject != null)
      {
        ((Bundle)localObject).setClassLoader(Setting.class.getClassLoader());
        paramString = (Setting)((Bundle)localObject).getParcelable("setting");
      }
    }
    return paramString;
  }
  
  public RedTouchItem a(int paramInt)
  {
    Object localObject2 = null;
    Object[] arrayOfObject = b(4144, new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = localObject2;
    if (arrayOfObject != null)
    {
      localObject1 = localObject2;
      if (arrayOfObject.length == 11)
      {
        localObject1 = new RedTouchItem();
        ((RedTouchItem)localObject1).taskId = ((Integer)arrayOfObject[0]).intValue();
        ((RedTouchItem)localObject1).curSeq = ((Long)arrayOfObject[1]).longValue();
        ((RedTouchItem)localObject1).redtouchType = ((Integer)arrayOfObject[2]).intValue();
        ((RedTouchItem)localObject1).count = ((Integer)arrayOfObject[3]).intValue();
        ((RedTouchItem)localObject1).icon = ((String)arrayOfObject[4]);
        ((RedTouchItem)localObject1).tips = ((String)arrayOfObject[5]);
        ((RedTouchItem)localObject1).receiveTime = ((Long)arrayOfObject[6]).longValue();
        ((RedTouchItem)localObject1).validTimeRemained = ((Integer)arrayOfObject[7]).intValue();
        ((RedTouchItem)localObject1).unReadFlag = ((Boolean)arrayOfObject[8]).booleanValue();
        ((RedTouchItem)localObject1).passThroughLevel = ((Integer)arrayOfObject[9]).intValue();
        ((RedTouchItem)localObject1).configVersion = ((String)arrayOfObject[10]);
      }
    }
    return (RedTouchItem)localObject1;
  }
  
  /* Error */
  public BusinessInfoCheckUpdate.AppInfo a()
  {
    // Byte code:
    //   0: aload_0
    //   1: sipush 4107
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: sipush 10011
    //   13: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: getstatic 382	com/tencent/mobileqq/activity/NearbyActivity:a	[Ljava/lang/String;
    //   22: iconst_3
    //   23: aaload
    //   24: aastore
    //   25: invokespecial 323	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:b	(I[Ljava/lang/Object;)[Ljava/lang/Object;
    //   28: astore_2
    //   29: new 384	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   32: dup
    //   33: invokespecial 385	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   36: astore_1
    //   37: aload_2
    //   38: ifnull +28 -> 66
    //   41: aload_2
    //   42: arraylength
    //   43: ifle +23 -> 66
    //   46: aload_2
    //   47: iconst_0
    //   48: aaload
    //   49: ifnull +17 -> 66
    //   52: aload_1
    //   53: aload_2
    //   54: iconst_0
    //   55: aaload
    //   56: checkcast 387	[B
    //   59: checkcast 387	[B
    //   62: invokevirtual 388	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   65: pop
    //   66: aload_1
    //   67: astore_3
    //   68: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +16 -> 87
    //   74: ldc_w 390
    //   77: ldc_w 392
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokestatic 397	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_3
    //   88: areturn
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: astore_3
    //   94: invokestatic 133	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   97: ifeq -29 -> 68
    //   100: aload_2
    //   101: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   104: aload_1
    //   105: astore_3
    //   106: goto -38 -> 68
    //   109: astore_2
    //   110: goto -18 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	NearbyProcManager
    //   36	69	1	localAppInfo1	BusinessInfoCheckUpdate.AppInfo
    //   28	26	2	arrayOfObject	Object[]
    //   89	12	2	localException1	Exception
    //   109	1	2	localException2	Exception
    //   67	39	3	localAppInfo2	BusinessInfoCheckUpdate.AppInfo
    // Exception table:
    //   from	to	target	type
    //   29	37	89	java/lang/Exception
    //   41	46	109	java/lang/Exception
    //   52	66	109	java/lang/Exception
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    Object[] arrayOfObject = b(4106, new Object[] { paramString });
    do
    {
      try
      {
        paramString = new BusinessInfoCheckUpdate.AppInfo();
        String str = paramString;
      }
      catch (Exception localException1)
      {
        try
        {
          paramString.mergeFrom((byte[])arrayOfObject[0]);
          str = paramString;
          return str;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        paramString = null;
      }
    } while (!QLog.isDevelopLevel());
    localException1.printStackTrace();
    return paramString;
  }
  
  public String a()
  {
    Object localObject2 = null;
    Object localObject1 = Message.obtain();
    ((Message)localObject1).what = 4139;
    Message localMessage = b((Message)localObject1);
    localObject1 = localObject2;
    if (localMessage != null)
    {
      localObject1 = localObject2;
      if (localMessage.getData() != null) {
        localObject1 = localMessage.getData().getString("IP");
      }
    }
    return (String)localObject1;
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object[] arrayOfObject = b(4109, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    paramString = null;
    if (arrayOfObject != null) {
      paramString = (String)arrayOfObject[0];
    }
    return paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcess.a();
  }
  
  public void a(byte paramByte)
  {
    b(4110, new Object[] { Byte.valueOf(paramByte) });
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a("onCheckAndPreDownloadRnResult", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    IRNPreDownloadListener localIRNPreDownloadListener;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localIRNPreDownloadListener = (IRNPreDownloadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localIRNPreDownloadListener == null) {}
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      localIRNPreDownloadListener.a(paramLong1, paramLong2);
      return;
    case 1: 
      localIRNPreDownloadListener.a();
      return;
    }
    localIRNPreDownloadListener.a(paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    Object localObject3;
    Object localObject1;
    try
    {
      localObject3 = NearbySPUtil.a("nearby_event_file", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), 4);
      if (this.jdField_a_of_type_ArrayOfInt == null)
      {
        this.jdField_a_of_type_ArrayOfInt = new int[3];
        int i = 0;
        String str = null;
        while (i < this.jdField_a_of_type_ArrayOfInt.length) {
          switch (i)
          {
          default: 
            this.jdField_a_of_type_ArrayOfInt[i] = ((SharedPreferences)localObject3).getInt(str, 0);
            i += 1;
          }
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        localThrowable1.printStackTrace();
        localObject3 = null;
        continue;
        localObject1 = "unread_count_date";
        continue;
        localObject1 = "unread_count_rank";
        continue;
        localObject1 = "unread_count_freshnews";
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((SharedPreferences)localObject3).edit();
        switch (paramInt1)
        {
        default: 
          localObject3 = localObject1;
          if (this.jdField_a_of_type_ArrayOfInt[paramInt1] != paramInt2)
          {
            this.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
            switch (paramInt1)
            {
            default: 
              a(4102);
            }
          }
          break;
        }
      }
      catch (Throwable localThrowable3)
      {
        boolean bool;
        Object localObject2 = null;
        continue;
      }
      try
      {
        bool = ((SharedPreferences.Editor)localObject3).commit();
        if (QLog.isColorLevel()) {
          NearbyUtils.a("notifyNewMessage", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfObject[0], paramArrayOfObject[1] });
        }
        return;
      }
      catch (Throwable paramArrayOfObject)
      {
        paramArrayOfObject.printStackTrace();
        return;
      }
      try
      {
        ((SharedPreferences.Editor)localObject1).putLong("dating_read_event_id", ((Long)paramArrayOfObject[0]).longValue());
        ((SharedPreferences.Editor)localObject1).putLong("dating_last_event_id", ((Long)paramArrayOfObject[1]).longValue());
      }
      catch (Throwable localThrowable2) {}
      localObject3 = localObject1;
      if (QLog.isColorLevel())
      {
        localThrowable2.printStackTrace();
        NearbyUtils.a("notifyNewMessage", new Object[] { "save event id", Integer.valueOf(paramInt1), localThrowable2.toString() });
        localObject3 = localObject1;
        continue;
        ((SharedPreferences.Editor)localObject1).putLong("rank_read_event_seq", ((Long)paramArrayOfObject[0]).longValue());
        ((SharedPreferences.Editor)localObject1).putLong("rank_last_event_seq", ((Long)paramArrayOfObject[1]).longValue());
        continue;
        ((SharedPreferences.Editor)localObject1).putLong("freshfeed_red_event_seq", ((Long)paramArrayOfObject[0]).longValue());
        ((SharedPreferences.Editor)localObject1).putLong("freshfeed_last_event_seq", ((Long)paramArrayOfObject[1]).longValue());
        continue;
        try
        {
          ((SharedPreferences.Editor)localObject3).putInt("unread_count_date", paramInt2);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          localException.printStackTrace();
          NearbyUtils.a("notifyNewMessage", new Object[] { "save unreadcount", Integer.valueOf(paramInt1), localException.toString() });
          continue;
          ((SharedPreferences.Editor)localObject3).putInt("unread_count_rank", paramInt2);
          continue;
          ((SharedPreferences.Editor)localObject3).putInt("unread_count_freshnews", paramInt2);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    b(4138, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4, paramString5 });
  }
  
  /* Error */
  public void a(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: getfield 33	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   7: astore_3
    //   8: aload_3
    //   9: monitorenter
    //   10: iconst_0
    //   11: istore 5
    //   13: iload 5
    //   15: aload_0
    //   16: getfield 33	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   19: invokeinterface 505 1 0
    //   24: if_icmpge +48 -> 72
    //   27: aload_0
    //   28: getfield 33	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   31: iload 5
    //   33: invokeinterface 508 2 0
    //   38: checkcast 510	com/tencent/mobileqq/nearby/ipc/NearbyProcObserver
    //   41: astore 4
    //   43: aload_0
    //   44: getfield 52	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   47: new 512	tke
    //   50: dup
    //   51: aload_0
    //   52: aload 4
    //   54: iload_1
    //   55: aload_2
    //   56: invokespecial 515	tke:<init>	(Lcom/tencent/mobileqq/nearby/ipc/NearbyProcManager;Lcom/tencent/mobileqq/nearby/ipc/NearbyProcObserver;I[Ljava/lang/Object;)V
    //   59: invokevirtual 521	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   62: pop
    //   63: iload 5
    //   65: iconst_1
    //   66: iadd
    //   67: istore 5
    //   69: goto -56 -> 13
    //   72: aload_3
    //   73: monitorexit
    //   74: aload_0
    //   75: getfield 31	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   78: astore_3
    //   79: aload_3
    //   80: monitorenter
    //   81: iload 6
    //   83: istore 5
    //   85: iload 5
    //   87: aload_0
    //   88: getfield 31	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   91: invokeinterface 505 1 0
    //   96: if_icmpge +53 -> 149
    //   99: aload_0
    //   100: getfield 31	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   103: iload 5
    //   105: invokeinterface 508 2 0
    //   110: checkcast 510	com/tencent/mobileqq/nearby/ipc/NearbyProcObserver
    //   113: astore 4
    //   115: aload_0
    //   116: getfield 56	com/tencent/mobileqq/nearby/ipc/NearbyProcManager:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   119: new 523	tkf
    //   122: dup
    //   123: aload_0
    //   124: aload 4
    //   126: iload_1
    //   127: aload_2
    //   128: invokespecial 524	tkf:<init>	(Lcom/tencent/mobileqq/nearby/ipc/NearbyProcManager;Lcom/tencent/mobileqq/nearby/ipc/NearbyProcObserver;I[Ljava/lang/Object;)V
    //   131: invokevirtual 521	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   134: pop
    //   135: iload 5
    //   137: iconst_1
    //   138: iadd
    //   139: istore 5
    //   141: goto -56 -> 85
    //   144: astore_2
    //   145: aload_3
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: aload_3
    //   150: monitorexit
    //   151: return
    //   152: astore_2
    //   153: aload_3
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	NearbyProcManager
    //   0	157	1	paramInt	int
    //   0	157	2	paramVarArgs	Object[]
    //   7	147	3	localList	List
    //   41	84	4	localNearbyProcObserver	NearbyProcObserver
    //   11	129	5	i	int
    //   1	81	6	j	int
    // Exception table:
    //   from	to	target	type
    //   13	63	144	finally
    //   72	74	144	finally
    //   145	147	144	finally
    //   85	135	152	finally
    //   149	151	152	finally
    //   153	155	152	finally
  }
  
  public void a(long paramLong, int paramInt)
  {
    b(4112, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  public void a(RespEncounterInfo paramRespEncounterInfo)
  {
    Object localObject2 = null;
    try
    {
      Object localObject1 = new JceOutputStream();
      paramRespEncounterInfo.writeTo((JceOutputStream)localObject1);
      localObject1 = ((JceOutputStream)localObject1).toByteArray();
      if (localObject1 != null) {
        b(4111, new Object[] { localObject1 });
      }
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        NearbyUtils.a("Q.nearby", "updateSelfCard", new Object[] { paramRespEncounterInfo, localObject1 });
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Integer localInteger = null;
        continue;
        localInteger = Integer.valueOf(localInteger.length);
      }
    }
  }
  
  public void a(Setting paramSetting)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4136;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("setting", paramSetting);
    localMessage.setData(localBundle);
    b(localMessage);
  }
  
  public void a(NearbyProcObserver paramNearbyProcObserver)
  {
    a(paramNearbyProcObserver, false);
  }
  
  public void a(NearbyProcObserver paramNearbyProcObserver, boolean paramBoolean)
  {
    if (paramNearbyProcObserver == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (!this.jdField_a_of_type_JavaUtilList.contains(paramNearbyProcObserver)) {
          this.jdField_a_of_type_JavaUtilList.add(paramNearbyProcObserver);
        }
        return;
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramNearbyProcObserver)) {
        this.jdField_b_of_type_JavaUtilList.add(paramNearbyProcObserver);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    b(4105, new Object[] { paramString });
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    b(4123, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(4122, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public void a(String paramString, Oidb_0x686.NearbyRankConfig paramNearbyRankConfig, Oidb_0x686.NearbyFeedConfig paramNearbyFeedConfig, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    Object localObject = null;
    if (paramNearbyRankConfig != null) {
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212)).a(paramNearbyRankConfig);
    }
    paramNearbyRankConfig = (FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211);
    if (paramNearbyFeedConfig != null) {
      paramNearbyRankConfig.a(paramNearbyFeedConfig);
    }
    int i;
    if (paramCharmEvent != null) {
      i = paramCharmEvent.uint32_new_charm_level.get();
    }
    for (;;)
    {
      QLog.i("updateCharmConfig", 1, "Charm=" + i);
      paramNearbyRankConfig.a(i);
      if (paramCharmEvent == null)
      {
        paramNearbyRankConfig = null;
        label103:
        if (paramNearbyCharmNotify != null) {
          break label163;
        }
      }
      label163:
      for (paramNearbyFeedConfig = (Oidb_0x686.NearbyFeedConfig)localObject;; paramNearbyFeedConfig = paramNearbyCharmNotify.toByteArray())
      {
        b(4124, new Object[] { paramString, paramNearbyRankConfig, paramNearbyFeedConfig });
        return;
        if (paramNearbyCharmNotify == null) {
          break label172;
        }
        i = paramNearbyCharmNotify.uint32_new_charm_level.get();
        break;
        paramNearbyRankConfig = paramCharmEvent.toByteArray();
        break label103;
      }
      label172:
      i = 0;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4120;
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key", paramArrayList);
    localMessage.setData(localBundle);
    paramArrayList = b(localMessage);
    if (paramArrayList != null) {}
    for (paramArrayList = paramArrayList.getData();; paramArrayList = null)
    {
      if (paramArrayList != null) {
        a(4120, new Object[] { paramArrayList.getStringArrayList("key"), paramArrayList.getStringArrayList("path") });
      }
      return;
    }
  }
  
  public void a(ArrayList paramArrayList, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4137;
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("faceKeyList", paramArrayList);
    localBundle.putLong("faceTimestamp", paramLong);
    b(localMessage);
  }
  
  public void a(cmd0x9c7.RspBody paramRspBody)
  {
    if (paramRspBody == null) {}
    for (paramRspBody = null;; paramRspBody = paramRspBody.toByteArray())
    {
      b(4125, new Object[] { paramRspBody });
      return;
    }
  }
  
  public void a(boolean paramBoolean, IRNPreDownloadListener paramIRNPreDownloadListener)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a("checkAndPreDownloadRN", new Object[] { Boolean.valueOf(paramBoolean), paramIRNPreDownloadListener });
    }
    if (paramIRNPreDownloadListener != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIRNPreDownloadListener);
    }
    b(4143, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (paramBoolean) {}
    for (int i = 4099;; i = 4098)
    {
      b(i, new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString6, paramString7, paramString8, paramString9 });
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    b(4145, new Object[] { paramArrayOfByte });
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "saveDynamicAvarInfo2db send ipcMsg.");
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfBoolean == null)
    {
      String str = null;
      SharedPreferences localSharedPreferences = NearbySPUtil.a("nearby_event_file", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), 4);
      this.jdField_a_of_type_ArrayOfBoolean = new boolean[2];
      int i = 0;
      if (i < this.jdField_a_of_type_ArrayOfBoolean.length)
      {
        switch (i)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_ArrayOfBoolean[i] = localSharedPreferences.getBoolean(str, false);
          i += 1;
          break;
          str = "config_show_date";
          continue;
          str = "config_show_rank";
        }
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("isMyTabConfigShow", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_a_of_type_ArrayOfBoolean[paramInt]) });
    }
    return this.jdField_a_of_type_ArrayOfBoolean[paramInt];
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = false;
    Object localObject = null;
    SharedPreferences localSharedPreferences = NearbySPUtil.a("nearby_event_file", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), 4);
    if (this.jdField_a_of_type_ArrayOfBoolean == null)
    {
      this.jdField_a_of_type_ArrayOfBoolean = new boolean[2];
      int i = 0;
      if (i < this.jdField_a_of_type_ArrayOfBoolean.length)
      {
        switch (i)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_ArrayOfBoolean[i] = localSharedPreferences.getBoolean((String)localObject, false);
          i += 1;
          break;
          localObject = "config_show_date";
          continue;
          localObject = "config_show_rank";
        }
      }
    }
    localObject = localSharedPreferences.edit();
    if (this.jdField_a_of_type_ArrayOfBoolean[paramInt] != paramBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = paramBoolean;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      bool1 = true;
      for (;;)
      {
        try
        {
          boolean bool2 = ((SharedPreferences.Editor)localObject).commit();
          if (QLog.isColorLevel()) {
            NearbyUtils.a("onGetMyTabConfig", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
          }
          return bool1;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        try
        {
          ((SharedPreferences.Editor)localObject).putBoolean("config_show_date", paramBoolean);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            localException.printStackTrace();
            NearbyUtils.a("onGetMyTabConfig", new Object[] { "save config", Integer.valueOf(paramInt), localException.toString() });
          }
          bool1 = true;
        }
      }
      ((SharedPreferences.Editor)localObject).putBoolean("config_show_rank", paramBoolean);
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = b(4114, new Object[] { paramString });
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length >= 1) {
        bool1 = ((Boolean)paramString[0]).booleanValue();
      }
    }
    return bool1;
  }
  
  public Object[] a(int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
    case 4127: 
    case 4108: 
    case 4100: 
    case 4101: 
    case 4115: 
    case 4116: 
    case 4117: 
    case 4118: 
    case 4119: 
    case 4124: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return null;
                        ((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211)).d();
                        return null;
                      } while ((paramVarArgs == null) || (paramVarArgs.length != 3));
                      ((DatingHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(2)).a((String)paramVarArgs[0], ((Integer)paramVarArgs[1]).intValue(), (String)paramVarArgs[2]);
                      return null;
                    } while ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof Integer)));
                    paramInt = ((Integer)paramVarArgs[0]).intValue();
                    if (QLog.isColorLevel()) {
                      NearbyUtils.a("MSG_NOTIFY_HAS_UNREAD_MSG", new Object[] { Integer.valueOf(paramInt) });
                    }
                    paramVarArgs = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
                    if (paramVarArgs != null)
                    {
                      if ((paramInt & 0x1) != 0) {
                        paramVarArgs.a().a((short)1);
                      }
                      if ((paramInt & 0x2) != 0) {
                        paramVarArgs.a().a((short)1);
                      }
                    }
                  } while (((paramInt & 0x4) == 0) || (!NearbySPUtil.c(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount())));
                  ((FreshNewsHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(1)).a(((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_event_file", 4, "freshfeed_last_event_seq", Long.valueOf(0L))).longValue(), ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_event_file", 4, "freshfeed_red_event_seq", Long.valueOf(0L))).longValue(), 100, false);
                  return null;
                } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
                paramVarArgs = (byte[])paramVarArgs[0];
                try
                {
                  localObject = new SubMsgType0x27.AppointmentNotify();
                  ((SubMsgType0x27.AppointmentNotify)localObject).mergeFrom(paramVarArgs);
                  a((SubMsgType0x27.AppointmentNotify)localObject);
                  return null;
                }
                catch (Exception paramVarArgs)
                {
                  paramVarArgs.printStackTrace();
                  return null;
                }
              } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
              a(4115, new Object[] { paramVarArgs[0], paramVarArgs[1] });
              return null;
            } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
            a(4116, new Object[] { paramVarArgs[0], paramVarArgs[1] });
            return null;
          } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
          a(4117, paramVarArgs);
          return null;
        } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
        a(4118, paramVarArgs);
        return null;
        NearbyMineHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 0, true);
        return null;
      } while ((paramVarArgs == null) || (paramVarArgs.length < 3));
    }
    for (;;)
    {
      try
      {
        paramInt = ((Integer)paramVarArgs[0]).intValue();
        QLog.i("updateCharmConfigIPC", 1, "Charm=" + paramInt);
        if (paramVarArgs[1] == null) {
          break label963;
        }
        localObject = new Oidb_0x686.NearbyRankConfig();
        ((Oidb_0x686.NearbyRankConfig)localObject).mergeFrom((byte[])paramVarArgs[1]);
        if (paramVarArgs[2] == null) {
          break label958;
        }
        Oidb_0x686.NearbyFeedConfig localNearbyFeedConfig = new Oidb_0x686.NearbyFeedConfig();
        localNearbyFeedConfig.mergeFrom((byte[])paramVarArgs[2]);
        paramVarArgs = localNearbyFeedConfig;
        if (localObject != null) {
          ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212)).a((Oidb_0x686.NearbyRankConfig)localObject);
        }
        localObject = (FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211);
        if (paramVarArgs != null) {
          ((FreshNewsManager)localObject).a(paramVarArgs);
        }
        ((FreshNewsManager)localObject).a(paramInt);
        return null;
      }
      catch (Exception paramVarArgs) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NearbyProcManager", 2, "MSG_GET_CHARM_EVENT catch exception:", paramVarArgs);
      return null;
      ((NearbyDataManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(209)).d();
      return null;
      if ((paramVarArgs == null) || (paramVarArgs.length != 2)) {
        break;
      }
      a(4133, new Object[] { Integer.valueOf(((Integer)paramVarArgs[0]).intValue()), Boolean.valueOf(((Boolean)paramVarArgs[1]).booleanValue()) });
      return null;
      PicIPManager.a();
      return null;
      if ((paramVarArgs == null) || (paramVarArgs.length != 4)) {
        break;
      }
      try
      {
        a(((Integer)paramVarArgs[0]).intValue(), ((Integer)paramVarArgs[1]).intValue(), ((Long)paramVarArgs[2]).longValue(), ((Long)paramVarArgs[3]).longValue());
        return null;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return null;
      }
      if ((paramVarArgs == null) || (paramVarArgs.length != 4)) {
        break;
      }
      try
      {
        long l = ((Long)paramVarArgs[0]).longValue();
        paramInt = ((Integer)paramVarArgs[1]).intValue();
        int i = ((Integer)paramVarArgs[2]).intValue();
        int j = ((Integer)paramVarArgs[3]).intValue();
        ((NearbyReportManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(218)).a(l, paramInt, i, j);
        return null;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return null;
      }
      label958:
      paramVarArgs = null;
      continue;
      label963:
      localObject = null;
    }
  }
  
  public String[] a(String paramString)
  {
    paramString = b(4131, new Object[] { paramString });
    if (paramString != null) {
      return (String[])paramString[0];
    }
    return null;
  }
  
  public String b()
  {
    Object localObject2 = null;
    Object localObject1 = Message.obtain();
    ((Message)localObject1).what = 4140;
    Message localMessage = b((Message)localObject1);
    localObject1 = localObject2;
    if (localMessage != null)
    {
      localObject1 = localObject2;
      if (localMessage.getData() != null) {
        localObject1 = localMessage.getData().getString("IP");
      }
    }
    return (String)localObject1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcess.b();
  }
  
  public void b(NearbyProcObserver paramNearbyProcObserver)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      if (this.jdField_b_of_type_JavaUtilList.contains(paramNearbyProcObserver)) {
        this.jdField_b_of_type_JavaUtilList.remove(paramNearbyProcObserver);
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramNearbyProcObserver)) {
        this.jdField_a_of_type_JavaUtilList.remove(paramNearbyProcObserver);
      }
      return;
      paramNearbyProcObserver = finally;
      throw paramNearbyProcObserver;
    }
  }
  
  public void b(String paramString)
  {
    b(4113, new Object[] { paramString });
  }
  
  public boolean b(int paramInt)
  {
    Object[] arrayOfObject = b(4104, new Object[] { Integer.valueOf(paramInt) });
    try
    {
      boolean bool = ((Boolean)arrayOfObject[0]).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    paramString = b(4121, new Object[] { paramString });
    if (paramString != null) {
      bool = ((Boolean)paramString[0]).booleanValue();
    }
    return bool;
  }
  
  public void c()
  {
    a(4129);
  }
  
  public void d()
  {
    a(4130);
  }
  
  public void e()
  {
    a(4132);
  }
  
  public void f()
  {
    a(4134);
  }
  
  public void onDestroy()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcess = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\ipc\NearbyProcManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */