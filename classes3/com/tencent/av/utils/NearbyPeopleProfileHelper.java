package com.tencent.av.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import hbc;
import java.util.ArrayList;
import java.util.List;

public class NearbyPeopleProfileHelper
{
  private static volatile NearbyPeopleProfileHelper jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper;
  public static final String a = "NearbyPeopleProfileHelper";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Context jdField_a_of_type_AndroidContentContext;
  public VideoController a;
  public VideoAppInterface a;
  public NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack a;
  public List a;
  public String b;
  
  private NearbyPeopleProfileHelper(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new hbc(this);
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.getNearByProfile");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public static NearbyPeopleProfileHelper a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper == null) {
        jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = new NearbyPeopleProfileHelper(paramVideoAppInterface);
      }
      return jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack = null;
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = null;
  }
  
  /* Error */
  public void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 96	com/tencent/av/SessionMgr:a	()Lcom/tencent/av/SessionMgr;
    //   5: aload_0
    //   6: getfield 42	com/tencent/av/utils/NearbyPeopleProfileHelper:b	Ljava/lang/String;
    //   9: invokevirtual 99	com/tencent/av/SessionMgr:a	(Ljava/lang/String;)Lcom/tencent/av/app/SessionInfo;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 40	com/tencent/av/utils/NearbyPeopleProfileHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   24: aload_2
    //   25: invokeinterface 103 2 0
    //   30: ifne -13 -> 17
    //   33: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +28 -> 64
    //   39: ldc 9
    //   41: iconst_2
    //   42: new 111	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   49: ldc 114
    //   51: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_1
    //   65: aload_2
    //   66: invokevirtual 130	com/tencent/av/app/VideoAppInterface:c	(Ljava/lang/String;)Z
    //   69: ifeq -52 -> 17
    //   72: aload_0
    //   73: getfield 40	com/tencent/av/utils/NearbyPeopleProfileHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   76: aload_2
    //   77: invokeinterface 133 2 0
    //   82: pop
    //   83: goto -66 -> 17
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	NearbyPeopleProfileHelper
    //   0	91	1	paramVideoAppInterface	VideoAppInterface
    //   0	91	2	paramString	String
    //   12	2	3	localSessionInfo	com.tencent.av.app.SessionInfo
    // Exception table:
    //   from	to	target	type
    //   2	13	86	finally
    //   20	64	86	finally
    //   64	83	86	finally
  }
  
  public void a(NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack paramINearbyPeopleProfileCallBack)
  {
    this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack = paramINearbyPeopleProfileCallBack;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\NearbyPeopleProfileHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */