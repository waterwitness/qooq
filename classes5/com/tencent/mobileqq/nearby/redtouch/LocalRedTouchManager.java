package com.tencent.mobileqq.nearby.redtouch;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x6cd.PullRedpointReq;
import tencent.im.oidb.cmd0x6cd.RedpointInfo;
import tencent.im.oidb.cmd0x6ce.ReadRedpointReq;
import tencent.im.oidb.cmd0x6f5.RspBody;
import tencent.im.oidb.cmd0x6f5.TaskInfo;

public class LocalRedTouchManager
  implements Handler.Callback, Manager
{
  public static final int a = 203;
  public static final String a;
  public static Map a;
  public static final int[] a;
  public static final int b = 10001;
  public static final String b = "local_redtouchs_v1.0";
  public static final int c = 0;
  public static final String c = "red_point_config_version";
  public static final int d = 1;
  private static final String d = "red_point_configs_";
  public static final int e = 2;
  private static final String e = "red_point_info_";
  public static final int f = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RedPointNode jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
  Boolean jdField_a_of_type_JavaLangBoolean = null;
  List jdField_a_of_type_JavaUtilList;
  private Vector jdField_a_of_type_JavaUtilVector = new Vector();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.a(), this);
  List jdField_b_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap c = new ConcurrentHashMap();
  private String f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = LocalRedTouchManager.class.getSimpleName();
    jdField_a_of_type_JavaUtilMap = new HashMap(1);
    jdField_a_of_type_ArrayOfInt = new int[] { 10001 };
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10001), Integer.valueOf(100460));
  }
  
  public LocalRedTouchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    e();
  }
  
  private int a(int paramInt)
  {
    return 1;
  }
  
  private List a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "findPassThroughParents, redPointId=" + paramInt1 + ", passThroughLevel=" + paramInt2);
    }
    ArrayList localArrayList = new ArrayList();
    if (paramInt2 > 0)
    {
      int j = 0;
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt1 < paramInt2)
      {
        RedPointNode localRedPointNode = (RedPointNode)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
        if ((localRedPointNode == null) || (localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode == null)) {
          break;
        }
        localArrayList.add(Integer.valueOf(localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int));
        i = localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int;
        paramInt1 += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(RedTouchItem paramRedTouchItem, int paramInt)
  {
    RedTouchItem localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    if (localRedTouchItem == null)
    {
      localRedTouchItem = new RedTouchItem();
      RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
      this.c.put(Integer.valueOf(paramInt), localRedTouchItem);
    }
    int i;
    int j;
    do
    {
      return;
      if (!localRedTouchItem.unReadFlag) {
        break;
      }
      i = RedTouchUtil.a(localRedTouchItem.redtouchType);
      j = RedTouchUtil.a(paramRedTouchItem.redtouchType);
      if (j > i)
      {
        localRedTouchItem = new RedTouchItem();
        RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
        this.c.put(Integer.valueOf(paramInt), localRedTouchItem);
        return;
      }
    } while ((j != i) || (paramRedTouchItem.redtouchType != 2));
    localRedTouchItem.count += paramRedTouchItem.count;
    return;
    localRedTouchItem = new RedTouchItem();
    RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
    this.c.put(Integer.valueOf(paramInt), localRedTouchItem);
  }
  
  private void a(RedTouchItem paramRedTouchItem, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "handleRedPoint, taskId=" + paramRedTouchItem.taskId + ", saveToFile=" + paramBoolean);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramRedTouchItem.taskId)))
    {
      RedPointConfig localRedPointConfig = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramRedTouchItem.taskId));
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localRedPointConfig.redPointId)))
      {
        paramRedTouchItem.passThroughLevel = localRedPointConfig.passThroughLevel;
        RedTouchItem localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(localRedPointConfig.redPointId));
        if ((localRedTouchItem != null) && (localRedTouchItem.unReadFlag) && (localRedTouchItem.redtouchType == 2) && (paramRedTouchItem.redtouchType == 2))
        {
          int i = paramRedTouchItem.count;
          localRedTouchItem.count += i;
        }
        this.c.put(Integer.valueOf(localRedPointConfig.redPointId), paramRedTouchItem);
        if (paramRedTouchItem.passThroughLevel > 0) {
          a(localRedPointConfig.redPointId);
        }
        if (paramBoolean) {
          g();
        }
      }
    }
  }
  
  private void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "updateData, items:" + paramList.size());
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        RedTouchItem localRedTouchItem = b(((RedTouchItem)paramList.get(i)).taskId);
        if (localRedTouchItem != null) {
          this.jdField_a_of_type_JavaUtilList.remove(localRedTouchItem);
        }
        this.jdField_a_of_type_JavaUtilList.add(paramList.get(i));
        i += 1;
      }
      f(200);
      return;
    }
    finally {}
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList != null;
  }
  
  private RedTouchItem b(int paramInt)
  {
    if (!a()) {
      f();
    }
    ArrayList localArrayList = new ArrayList(jdField_a_of_type_JavaUtilMap.size());
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    int i = 0;
    while (i < localArrayList.size())
    {
      RedTouchItem localRedTouchItem = (RedTouchItem)localArrayList.get(i);
      if (localRedTouchItem.taskId == paramInt) {
        return localRedTouchItem;
      }
      i += 1;
    }
    return null;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = new RedPointNode();
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int = 100510;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode);
    RedPointNode localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = 10011;
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localRedPointNode1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_JavaUtilList = localArrayList;
    localArrayList = new ArrayList();
    RedPointNode localRedPointNode2 = new RedPointNode();
    localRedPointNode2.jdField_a_of_type_Int = 100523;
    localRedPointNode2.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localRedPointNode2.jdField_a_of_type_Int), localRedPointNode2);
    localArrayList.add(localRedPointNode2);
    localRedPointNode2 = new RedPointNode();
    localRedPointNode2.jdField_a_of_type_Int = 100517;
    localRedPointNode2.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localRedPointNode2.jdField_a_of_type_Int), localRedPointNode2);
    localArrayList.add(localRedPointNode2);
    localRedPointNode1.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  private void f()
  {
    Object localObject1 = new ArrayList(jdField_a_of_type_JavaUtilMap.size());
    Object localObject3 = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "local_redtouchs_v1.0");
    if ((localObject3 != null) && ((localObject3 instanceof List))) {
      localObject1 = (List)localObject3;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(jdField_a_of_type_JavaUtilMap.size());
      localObject3 = this.jdField_a_of_type_JavaUtilList;
      if (localObject1 != null) {}
      try
      {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "init:" + ((List)localObject1).size());
        }
        if (this.jdField_a_of_type_JavaLangBoolean == null)
        {
          this.jdField_a_of_type_JavaLangBoolean = ((Boolean)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "pull_redtouch_when_reconnect", Boolean.valueOf(false)));
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "init mPullRedtouchWhenReconnect: " + this.jdField_a_of_type_JavaLangBoolean);
          }
        }
        a();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)FileUtils.a("red_point_configs_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        this.c = ((ConcurrentHashMap)FileUtils.a("red_point_info_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        if (this.c == null) {
          this.c = new ConcurrentHashMap();
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
        return;
      }
      finally {}
    }
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(0, 200L);
  }
  
  private void g()
  {
    FileUtils.a("red_point_info_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.c);
  }
  
  private void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "updateUnreadFlag," + paramInt);
    }
    RedTouchItem localRedTouchItem = b(paramInt);
    if (localRedTouchItem != null) {
      localRedTouchItem.unReadFlag = false;
    }
    f(200);
  }
  
  public RedTouchItem a(int paramInt)
  {
    if (this.c != null) {
      return (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public String a()
  {
    if (this.f == null) {
      this.f = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "red_point_config_version", ""));
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getRedPointConfigVersion, version = " + this.f);
    }
    return this.f;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (localIterator.hasNext()) {
        a((RedTouchItem)localIterator.next(), false);
      }
      g();
      this.jdField_a_of_type_JavaUtilVector.clear();
      RedpointHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "updateRedPointTree, redPointId=" + paramInt);
    }
    RedTouchItem localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    if ((localRedTouchItem != null) && (localRedTouchItem.passThroughLevel > 0))
    {
      Iterator localIterator = a(paramInt, localRedTouchItem.passThroughLevel).iterator();
      while (localIterator.hasNext()) {
        a(localRedTouchItem, ((Integer)localIterator.next()).intValue());
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setRedPointConfigVersion, version = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.f = paramString;
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "red_point_config_version", paramString);
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onGetRedPointInfo, list size=");
      if (paramList == null)
      {
        localObject = "null";
        QLog.i(str, 2, localObject + ", hasMore=" + paramBoolean);
      }
    }
    else
    {
      if ((paramList != null) && (paramList.size() != 0)) {
        break label86;
      }
    }
    label86:
    do
    {
      return;
      localObject = Integer.valueOf(paramList.size());
      break;
      this.jdField_a_of_type_JavaUtilVector.addAll(paramList);
    } while (paramBoolean);
    int i = this.jdField_a_of_type_JavaUtilVector.size() - 1;
    while (i >= 0)
    {
      if (((RedTouchItem)this.jdField_a_of_type_JavaUtilVector.get(i)).taskId == 10001) {
        this.jdField_a_of_type_JavaUtilVector.remove(i);
      }
      i -= 1;
    }
    if (((RedTouchItem)paramList.get(0)).configVersion.equals(this.f))
    {
      a();
      return;
    }
    ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).a();
  }
  
  public void a(cmd0x6f5.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "saveRedPointConfigs");
    }
    if ((paramRspBody != null) && (paramRspBody.rpt_task_info != null) && (paramRspBody.rpt_task_info.has()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      paramRspBody = paramRspBody.rpt_task_info.get();
      Iterator localIterator = paramRspBody.iterator();
      while (localIterator.hasNext())
      {
        cmd0x6f5.TaskInfo localTaskInfo = (cmd0x6f5.TaskInfo)localIterator.next();
        RedPointConfig localRedPointConfig = new RedPointConfig();
        localRedPointConfig.taskId = localTaskInfo.uint32_task_id.get();
        localRedPointConfig.redPointId = localTaskInfo.uint32_appid.get();
        localRedPointConfig.passThroughLevel = localTaskInfo.uint32_passthrough_level.get();
        localRedPointConfig.bindLevel = localTaskInfo.uint32_show_level.get();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localRedPointConfig.taskId), localRedPointConfig);
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "saveRedPointConfigs, config size = " + paramRspBody.size());
      }
      FileUtils.a("red_point_configs_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
    }
  }
  
  public void a(short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGetUnreadRedTouchFlag: " + paramShort);
    }
    if (paramShort > 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_JavaLangBoolean == null) || (this.jdField_a_of_type_JavaLangBoolean.booleanValue() != bool))
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "pull_redtouch_when_reconnect", this.jdField_a_of_type_JavaLangBoolean);
      }
      if (paramShort > 0) {
        c();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onProfileRedTouchClick, isFromFriendElseNearby:" + paramBoolean);
    }
    c(10001);
    b(100510);
    RedpointHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onLinePush");
    }
    if (!a()) {
      f();
    }
    Object localObject = new cmd0x6cd.RedpointInfo();
    try
    {
      ((cmd0x6cd.RedpointInfo)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = RedTouchItem.getRedTouchItem((cmd0x6cd.RedpointInfo)localObject);
      if (paramArrayOfByte == null) {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      if (paramArrayOfByte.taskId == 10001)
      {
        localObject = new ArrayList(1);
        ((List)localObject).add(paramArrayOfByte);
        b((List)localObject, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onLinePush, taskId=" + paramArrayOfByte.taskId);
      }
      if (((cmd0x6cd.RedpointInfo)localObject).str_config_version.get().equals(this.f))
      {
        a(paramArrayOfByte, true);
        RedpointHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      this.jdField_a_of_type_JavaUtilVector.add(paramArrayOfByte);
      ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).a();
    }
  }
  
  public void b()
  {
    if (!a()) {
      f();
    }
    ArrayList localArrayList = new ArrayList();
    ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).a(localArrayList, true);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onRedPointClick, redPointId=" + paramInt);
    }
    Object localObject = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((RedTouchItem)localObject).unReadFlag))
    {
      ((RedTouchItem)localObject).unReadFlag = false;
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(3)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
      localObject = new cmd0x6ce.ReadRedpointReq();
      ((cmd0x6ce.ReadRedpointReq)localObject).uint32_appid.set(paramInt);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).a(localArrayList);
    }
  }
  
  public void b(List paramList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGetNewRedTouch, list:" + paramList + " hasMore:" + paramBoolean);
    }
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList(jdField_a_of_type_JavaUtilMap.size());
    }
    if (paramList != null) {
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    }
    if (!paramBoolean)
    {
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        if (((RedTouchItem)this.jdField_b_of_type_JavaUtilList.get(i)).taskId == 10001) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("CliOper", "0X8006725");
        }
        i += 1;
      }
      a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList.clear();
      d();
      RedpointHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void c()
  {
    if (!a()) {
      f();
    }
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "pull redtouch return. no need pull");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList(jdField_a_of_type_JavaUtilMap.size());
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      RedTouchItem localRedTouchItem = b(localInteger.intValue());
      cmd0x6cd.PullRedpointReq localPullRedpointReq = new cmd0x6cd.PullRedpointReq();
      localPullRedpointReq.uint32_taskid.set(localInteger.intValue());
      if (localRedTouchItem != null) {
        localPullRedpointReq.uint64_last_pull_seq.set(localRedTouchItem.curSeq);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "pullRedTouchs. addPull:" + localInteger);
        }
        localArrayList.add(localPullRedpointReq);
        break;
        localPullRedpointReq.uint64_last_pull_seq.set(0L);
      }
    }
    ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).a(localArrayList, false);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onRedTouchItemClick, taskId:" + paramInt);
    }
    Object localObject1 = b(paramInt);
    if (localObject1 == null) {
      return;
    }
    g(paramInt);
    Object localObject2 = (Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localObject2 != null) {
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).c(localObject2 + "");
    }
    localObject2 = new cmd0x6ce.ReadRedpointReq();
    ((cmd0x6ce.ReadRedpointReq)localObject2).uint32_taskid.set(paramInt);
    ((cmd0x6ce.ReadRedpointReq)localObject2).uint64_read_seq.set(((RedTouchItem)localObject1).curSeq);
    localObject1 = new ArrayList(1);
    ((List)localObject1).add(localObject2);
    ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).a((List)localObject1);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "buildAppinfos");
    }
    if (!a()) {
      f();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    ArrayList localArrayList = new ArrayList(jdField_a_of_type_JavaUtilMap.size());
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    int i = 0;
    RedTouchItem localRedTouchItem;
    Integer localInteger;
    for (;;)
    {
      if (i < localArrayList.size())
      {
        localRedTouchItem = (RedTouchItem)localArrayList.get(i);
        localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localRedTouchItem.taskId));
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "buildAppinfos, id:" + localRedTouchItem.taskId + " path:" + localInteger);
        }
        if (localInteger == null)
        {
          i += 1;
        }
        else
        {
          if (localRedTouchItem.unReadFlag) {
            break label504;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "buildAppinfos, id:" + localRedTouchItem.taskId + "has readed");
          }
        }
      }
    }
    label291:
    label504:
    for (boolean bool2 = false;; bool2 = true)
    {
      int j = RedTouchUtil.a(localRedTouchItem.redtouchType);
      Object localObject1 = "";
      Object localObject2 = localObject1;
      boolean bool1;
      if (bool2) {
        switch (j)
        {
        case 1: 
        case 2: 
        case 3: 
        default: 
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "buildAppinfos, id:" + localRedTouchItem.taskId + " type:" + j + " content:" + (String)localObject1);
          }
          localObject2 = localObject1;
          if (bool1) {
            bool1 = false;
          }
          break;
        }
      }
      for (;;)
      {
        RedTouchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, localInteger.intValue(), String.valueOf(localInteger), (String)localObject1, true, "", a(localRedTouchItem.taskId), bool1);
        break;
        if (localRedTouchItem.count <= 0) {}
        for (boolean bool3 = true;; bool3 = false)
        {
          bool1 = bool3;
          if (bool3) {
            break;
          }
          localObject1 = localRedTouchItem.count + "";
          bool1 = bool3;
          break;
        }
        bool3 = TextUtils.isEmpty(localRedTouchItem.tips);
        bool1 = bool3;
        if (bool3) {
          break label291;
        }
        localObject1 = localRedTouchItem.tips;
        bool1 = bool3;
        break label291;
        bool1 = false;
        break label291;
        return;
        bool1 = bool2;
        localObject1 = localObject2;
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onResumeOrPause:" + paramInt);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1, paramInt, 0).sendToTarget();
  }
  
  public void e(int paramInt)
  {
    if (paramInt != 1) {}
    RedTouchManager localRedTouchManager;
    do
    {
      return;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onResume:" + paramInt);
      }
      localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
      if (!a()) {
        f();
      }
    } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    long l = System.currentTimeMillis();
    paramInt = 0;
    label94:
    int i;
    RedTouchItem localRedTouchItem;
    if (paramInt < arrayOfInt.length)
    {
      i = arrayOfInt[paramInt];
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "resume, id:" + i);
      }
      localRedTouchItem = b(i);
      if ((localRedTouchItem != null) && (localRedTouchItem.validTimeRemained >= 0) && (jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i)) != null) && (localRedTouchItem.unReadFlag)) {
        break label207;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "resume, continue");
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label94;
      break;
      label207:
      int j = (int)((l - localRedTouchItem.receiveTime) / 1000L);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "resume,remain:" + localRedTouchItem.validTimeRemained + " consume:" + j);
      }
      if (j >= localRedTouchItem.validTimeRemained)
      {
        j = ((Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i))).intValue();
        g(i);
        localRedTouchManager.c(j + "");
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "resume, dismiss:" + i);
        }
      }
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    if (??? == null) {}
    for (;;)
    {
      return false;
      switch (???.what)
      {
      default: 
        return false;
      case 0: 
        String str;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
          if (TextUtils.isEmpty(str)) {}
        }
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          FileUtils.a(str + "local_redtouchs_v1.0", this.jdField_a_of_type_JavaUtilList);
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "saveData");
            return false;
          }
        }
      }
    }
    e(???.arg1);
    return false;
    d();
    return false;
    g();
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\redtouch\LocalRedTouchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */