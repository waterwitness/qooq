package com.tencent.biz.troop;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.data.DingdongOfficeOpenClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import jda;
import jdb;

public class TroopMemberApiClient
{
  static int jdField_a_of_type_Int = 0;
  protected static TroopMemberApiClient a;
  static final String jdField_a_of_type_JavaLangString = "com.tencent.biz.troop.TroopMemberApiClient";
  static final String jdField_b_of_type_JavaLangString = "req_seq";
  public static final String c = "isTroopAppListChanged";
  protected ServiceConnection a;
  public final Messenger a;
  public SparseArray a;
  QQMusicClient jdField_a_of_type_ComTencentBizApiproxyQQMusicClient;
  public BizTroopObserver a;
  DingdongOfficeOpenClient jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenClient;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public List a;
  public Map a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public Messenger b;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  public List b;
  AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  
  private TroopMemberApiClient()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(new jdb(this));
    this.jdField_b_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidContentServiceConnection = new jda(this);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static TroopMemberApiClient a()
  {
    if (jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {
        jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = new TroopMemberApiClient();
      }
      return jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    }
    finally {}
  }
  
  public static String a()
  {
    int i = Process.myPid();
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public int a(TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    return i;
  }
  
  public QQMusicClient a()
  {
    if (this.jdField_a_of_type_ComTencentBizApiproxyQQMusicClient == null) {
      this.jdField_a_of_type_ComTencentBizApiproxyQQMusicClient = new QQMusicClient(this);
    }
    return this.jdField_a_of_type_ComTencentBizApiproxyQQMusicClient;
  }
  
  public TroopMemberApiClient.Callback a(int paramInt)
  {
    return (TroopMemberApiClient.Callback)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
  }
  
  public DingdongOfficeOpenClient a()
  {
    if (this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenClient == null) {
      this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenClient = new DingdongOfficeOpenClient(this);
    }
    return this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenClient;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(1) == 0)
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      localBaseApplication.bindService(new Intent(localBaseApplication, TroopMemberApiService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.troop.TroopMemberApiClient", 2, "Binding...");
      }
    }
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fontSize", paramInt);
    a(52, localBundle);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("lat", paramInt1);
    localBundle.putInt("lon", paramInt2);
    localBundle.putInt("radius", paramInt3);
    localBundle.putBoolean("isClickable", paramBoolean);
    localBundle.putString("methord_name", "getAreaList");
    a(9, localBundle);
  }
  
  public void a(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomid", paramLong);
    localBundle.putInt("roomType", paramInt1);
    localBundle.putString("vasname", paramString1);
    localBundle.putString("userdata", paramString2);
    localBundle.putInt("fromid", paramInt2);
    a(31, localBundle);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    localMessage.replyTo = this.jdField_a_of_type_AndroidOsMessenger;
    localMessage.setData(paramBundle);
    if (this.jdField_b_of_type_AndroidOsMessenger == null) {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(localMessage);
        return;
      }
      finally {}
    }
    try
    {
      this.jdField_b_of_type_AndroidOsMessenger.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, BusinessObserver paramBusinessObserver)
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    localSparseArray.append(i, paramBusinessObserver);
    paramBundle.putInt("req_seq", jdField_a_of_type_Int);
    a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("appId", paramInt);
    localBundle.putInt("seq", a(paramCallback));
    a(43, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString4);
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putInt("appid", paramInt);
    localBundle.putString("openGroupId", paramString1);
    localBundle.putString("token", paramString2);
    localBundle.putString("url", paramString3);
    a(28, localBundle);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("dwGroupCode", paramLong1);
    localBundle.putLong("cGroupOption", paramLong2);
    localBundle.putLong("dwGroupClass", paramLong3);
    localBundle.putString("strGroupName", paramString1);
    localBundle.putInt("wGroupFace", paramInt1);
    localBundle.putString("strGroupMemo", paramString2);
    localBundle.putString("strFingerMemo", paramString3);
    localBundle.putInt("nFlag", paramInt2);
    a(37, localBundle);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopCode", paramLong1);
    localBundle.putString("filePath", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("fileSize", paramLong2);
    localBundle.putInt("busid", paramInt);
    localBundle.putInt("seq", a(paramCallback));
    a(20, localBundle);
  }
  
  public void a(long paramLong, long[] paramArrayOfLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLongArray("troopUinList", paramArrayOfLong);
    localBundle.putLong("troopPubAccountUin", paramLong);
    a(44, localBundle);
  }
  
  public void a(TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    a(51, localBundle);
  }
  
  public void a(BizTroopObserver paramBizTroopObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = paramBizTroopObserver;
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "RegisterObserver key:" + paramBusinessObserver.hashCode());
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver));
    this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
  }
  
  public void a(Integer paramInteger, String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putInt("appid", paramInteger.intValue());
    localBundle.putString("openId", paramString1);
    localBundle.putString("token", paramString2);
    a(60, localBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("video_url", paramString);
    a(5, localBundle);
  }
  
  public void a(String paramString, byte paramByte, long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putByte("cIsGetGroupAlbum", paramByte);
    localBundle.putLong("dwTimeStamp", paramLong);
    localBundle.putInt("cStatOption", paramInt);
    a(36, localBundle);
  }
  
  public void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", Long.parseLong(paramString));
    localBundle.putInt("flag", paramInt);
    a(50, localBundle);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("areaName", paramString);
    localBundle.putInt("lat", paramInt1);
    localBundle.putInt("lon", paramInt2);
    localBundle.putInt("startIndex", paramInt3);
    localBundle.putInt("count", paramInt4);
    localBundle.putInt("iFilterId", paramInt5);
    localBundle.putString("methord_name", "getGroupInArea");
    a(9, localBundle);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putInt("rewardMoney", paramInt1);
    localBundle.putString("rewardContent", paramString2);
    localBundle.putString("mediaPath", paramString3);
    localBundle.putInt("rewardType", paramInt2);
    localBundle.putInt("imageMaxWidthPixels", paramInt3);
    localBundle.putInt("imageMaxHeightPixels", paramInt4);
    a(53, localBundle);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, TroopMemberApiClient.Callback paramCallback1, TroopMemberApiClient.Callback paramCallback2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_local_path", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putInt("seq1", a(paramCallback2));
    localBundle.putInt("seq", a(paramCallback1));
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    a(21, localBundle);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putLong("bubbleId", paramLong);
    localBundle.putInt("headId", paramInt1);
    localBundle.putString("nickName", paramString2);
    localBundle.putInt("expireTime", paramInt2);
    localBundle.putInt("seq", a(paramCallback));
    a(13, localBundle);
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putString("troopUin", paramString1);
    localBundle.putLong("msgseq", paramLong);
    localBundle.putInt("reqType", paramInt);
    localBundle.putString("comment", paramString2);
    a(59, localBundle);
  }
  
  public void a(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("video_url", paramString);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    a(4, localBundle);
  }
  
  public void a(String paramString, AIOImageData paramAIOImageData, TroopMemberApiClient.Callback paramCallback)
  {
    if (paramString == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("largeImageFile", paramAIOImageData.b);
    localBundle.putString("fileName", paramAIOImageData.f);
    localBundle.putLong("progressTotal", paramAIOImageData.e);
    localBundle.putInt("busId", paramAIOImageData.i);
    int i = a(paramCallback);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramAIOImageData.f, Integer.valueOf(i));
    a(55, localBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("opn", paramString2);
    a(30, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString3);
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopName", paramString2);
    localBundle.putInt("troopTypeId", paramInt);
    a(19, localBundle);
  }
  
  public void a(String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("rewardId", paramString2);
    localBundle.putInt("seq", a(paramCallback));
    a(54, localBundle);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    a(35, localBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isTroopAppListChanged", paramBoolean);
    a(29, localBundle);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("isFirst", paramBoolean);
    ((Bundle)localObject).putInt("lat", paramInt1);
    ((Bundle)localObject).putInt("lon", paramInt2);
    ((Bundle)localObject).putInt("sortType", paramInt3);
    ((Bundle)localObject).putString("strGroupArea", paramString);
    ((Bundle)localObject).putString("methord_name", "getNearbyTroops");
    ((Bundle)localObject).putInt("iFilterId", paramInt4);
    a(9, (Bundle)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("getNearbyTroops,params=");
      ((StringBuilder)localObject).append("isFirst:").append(paramBoolean).append("|lat:").append(paramInt1).append("|lon:").append(paramInt2).append("|sortType:").append(paramInt3).append("|strGroupArea:").append(paramString).append("|iFilterId:").append(paramInt4);
      QLog.d("com.tencent.biz.troop.TroopMemberApiClient", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String[] paramArrayOfString, TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("paths", paramArrayOfString);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    a(11, localBundle);
  }
  
  public void b()
  {
    BaseApplication localBaseApplication;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1) == 0)
    {
      localBaseApplication = BaseApplicationImpl.getContext();
      if (this.jdField_b_of_type_AndroidOsMessenger == null) {}
    }
    try
    {
      Message localMessage = Message.obtain(null, 2);
      localMessage.replyTo = this.jdField_a_of_type_AndroidOsMessenger;
      Bundle localBundle = new Bundle();
      localBundle.putString("processName", a());
      localMessage.obj = localBundle;
      this.jdField_b_of_type_AndroidOsMessenger.send(localMessage);
      localBaseApplication.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.jdField_b_of_type_AndroidOsMessenger = null;
      try
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilMap.clear();
        if (QLog.isColorLevel()) {
          QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Unbinding...");
        }
        return;
      }
      finally {}
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "unRegisterObserver key:" + paramBusinessObserver.hashCode());
      }
    } while (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver));
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void b(String paramString)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    localBundle.putInt("seq", i);
    a(12, localBundle);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, boolean paramBoolean, TroopMemberApiClient.Callback paramCallback1, TroopMemberApiClient.Callback paramCallback2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_server_id", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    localBundle.putInt("seq1", a(paramCallback2));
    localBundle.putInt("seq", a(paramCallback1));
    a(22, localBundle);
  }
  
  public void b(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramCallback));
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", a());
    a(58, localBundle);
  }
  
  public void b(String paramString, AIOImageData paramAIOImageData, TroopMemberApiClient.Callback paramCallback)
  {
    if (paramString == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("filePath", paramAIOImageData.g);
    localBundle.putString("fileName", paramAIOImageData.f);
    localBundle.putInt("busId", paramAIOImageData.i);
    int i = a(paramCallback);
    localBundle.putInt("seq", i);
    this.jdField_b_of_type_JavaUtilHashMap.put(paramAIOImageData.f, Integer.valueOf(i));
    a(57, localBundle);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("gcode", paramString1);
    localBundle.putString("anId", paramString2);
    a(7, localBundle);
  }
  
  public void b(String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pkgname", paramString1);
    localBundle.putString("appid", paramString2);
    a(paramCallback);
    a(62, localBundle);
  }
  
  public void c()
  {
    a(6, null);
  }
  
  public void c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", a());
    a(38, localBundle);
  }
  
  public void c(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    if (paramCallback == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("callback", paramString);
    }
    localBundle.putInt("seq", a(paramCallback));
    a(15, localBundle);
  }
  
  public void c(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopCode", paramString2);
    a(40, localBundle);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
  }
  
  public void d(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    a(33, localBundle);
  }
  
  public void d(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putInt("seq", a(paramCallback));
    a(45, localBundle);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("localFilePath", paramString1);
    localBundle.putString("fileDisPlayName", paramString2);
    a(46, localBundle);
  }
  
  public void e()
  {
    a(16, new Bundle());
  }
  
  public void e(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    a(34, localBundle);
  }
  
  public void f()
  {
    a(27, new Bundle());
  }
  
  public void f(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    a(61, localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troop\TroopMemberApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */