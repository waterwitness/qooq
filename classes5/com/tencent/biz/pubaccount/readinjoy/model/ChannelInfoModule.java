package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyChannelRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x69fParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import hyv;
import hyw;
import hyx;
import hyy;
import hyz;
import hza;
import hzb;
import hzc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x69e.oidb_cmd0x69e.ReqBody;
import tencent.im.oidb.cmd0x69e.oidb_cmd0x69e.RspBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;

public class ChannelInfoModule
  extends ReadInJoyEngineModule
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = ChannelInfoModule.class.getSimpleName();
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  private static final String h = "req_channellist_source";
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private boolean jdField_a_of_type_Boolean;
  private LinkedHashMap jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private boolean jdField_b_of_type_Boolean;
  private int u;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ChannelInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (ReadInJoyChannelRecommendManager.a().a()) {
      a(0);
    }
  }
  
  public ChannelInfoModule(EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(null, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private ToServiceMsg a(ReadInJoyRequestParams.Request0x69fParams paramRequest0x69fParams)
  {
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
    ((oidb_cmd0x69f.ReqBody)localObject).uint64_uin.set(l);
    if (paramRequest0x69fParams.jdField_a_of_type_Boolean) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_all_channel_list.set(1);
    }
    if (paramRequest0x69fParams.jdField_b_of_type_Boolean) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_my_channel_id_list.set(1);
    }
    if (paramRequest0x69fParams.j) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_video_channel.set(1);
    }
    if (paramRequest0x69fParams.k) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_local_channel_id.set(1);
    }
    if (ReadInJoyUtils.a()) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_channel.set(1);
    }
    for (;;)
    {
      if (paramRequest0x69fParams.i) {
        ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_recomm_channel.set(1);
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_important.set(paramRequest0x69fParams.jdField_b_of_type_Int);
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).getAttributes().put(c, Integer.valueOf(paramRequest0x69fParams.jdField_a_of_type_Int));
      return (ToServiceMsg)localObject;
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_channel.set(0);
    }
  }
  
  private void a(Integer paramInteger)
  {
    ChannelInfo localChannelInfo = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if (localChannelInfo != null)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramInteger);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyz(this, localChannelInfo));
    }
  }
  
  private void a(boolean paramBoolean, List paramList1, List paramList2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hyy(this, paramBoolean, paramList1, paramList2));
  }
  
  private boolean b(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (paramChannelInfo == null) {
      return false;
    }
    ChannelInfo localChannelInfo = paramChannelInfo.clone();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelInfo.mChannelID), localChannelInfo);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hza(this, localChannelInfo));
    }
    return true;
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ChannelInfo.class, true, null, null, null, null, null, null);
    if (localObject == null)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      b((ChannelInfo)((Iterator)localObject).next(), false);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    oidb_cmd0x69f.RspBody localRspBody = new oidb_cmd0x69f.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (j == 0) {
      if (i == 2)
      {
        if (!localRspBody.rpt_recomm_channel_list.has()) {
          break label315;
        }
        ReadInJoyMSFHandlerUtils.a(ReadInJoyChannelRecommendManager.a().a(), localRspBody.rpt_recomm_channel_list.get());
        paramFromServiceMsg = null;
        bool = true;
        paramObject = localObject1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetChannelAndSubscribeList, result=" + j);
      }
      if ((bool) && (i == 2))
      {
        ReadInJoyChannelRecommendManager.a().a(localRspBody);
        ReadInJoyChannelRecommendManager.a().c();
        ReadInJoyLogicEngineEventDispatcher.a().b(true);
        return;
        if (localRspBody.uint64_uin.has()) {
          localRspBody.uint64_uin.get();
        }
        if (!localRspBody.rpt_channel_list.has()) {
          break label310;
        }
      }
      label310:
      for (paramFromServiceMsg = ReadInJoyMSFHandlerUtils.a(localRspBody.rpt_channel_list.get());; paramFromServiceMsg = null)
      {
        paramObject = localObject2;
        if (localRspBody.rpt_uint32_my_channel_id_list.has())
        {
          paramObject = localObject2;
          if (localRspBody.rpt_uint32_my_channel_id_list.get() != null)
          {
            paramObject = new ArrayList(localRspBody.rpt_uint32_my_channel_id_list.size());
            ((List)paramObject).addAll(localRspBody.rpt_uint32_my_channel_id_list.get());
          }
        }
        bool = true;
        break;
        switch (((Integer)paramToServiceMsg.getAttributes().get(c)).intValue())
        {
        default: 
          return;
        }
        a(bool, paramFromServiceMsg, (List)paramObject);
        return;
      }
      label315:
      paramFromServiceMsg = null;
      bool = true;
      paramObject = localObject1;
      continue;
      paramFromServiceMsg = null;
      bool = false;
      paramObject = localObject1;
    }
  }
  
  public int a()
  {
    List localList = b();
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new hyw(this, localList));
      return 0;
    }
    b();
    return 1;
  }
  
  public ChannelInfo a(Integer paramInteger)
  {
    return (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
  }
  
  public ChannelInfo a(Integer paramInteger, String paramString)
  {
    ChannelInfo localChannelInfo = new ChannelInfo();
    localChannelInfo.mChannelID = paramInteger.intValue();
    localChannelInfo.mChannelName = paramString;
    localChannelInfo.mChannelType = 1;
    localChannelInfo.mShow = true;
    localChannelInfo.mSortOrder = 1;
    return localChannelInfo;
  }
  
  public List a()
  {
    c();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      localObject3 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject3);
      if (((ChannelInfo)localObject3).mShow) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    Collections.sort((List)localObject1, new hyv(this));
    localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add((ChannelInfo)((Iterator)localObject1).next());
    }
    return (List)localObject2;
  }
  
  public List a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(((ChannelInfo)paramList.next()).mChannelID));
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.u = 0;
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    Object localObject = new ReadInJoyRequestParams.Request0x69fParams();
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_a_of_type_Int = 4;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_a_of_type_Boolean = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_b_of_type_Boolean = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).c = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).d = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).j = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).k = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).e = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).f = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).g = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).h = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).i = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_b_of_type_Int = paramInt;
    localObject = a((ReadInJoyRequestParams.Request0x69fParams)localObject);
    ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(2));
    a((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ChannelInfo localChannelInfo = (ChannelInfo)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt2));
    a(Integer.valueOf(paramInt1));
    b(localChannelInfo, true);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x69f")) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x69e")) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(List paramList)
  {
    Object localObject = new oidb_cmd0x69e.ReqBody();
    ((oidb_cmd0x69e.ReqBody)localObject).rpt_uint32_channel_ids.set(paramList);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x69e", 1694, 0, ((oidb_cmd0x69e.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put("channelIDList", paramList);
    a((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hyx(this, paramBoolean, paramList));
  }
  
  public boolean a(int paramInt)
  {
    ChannelInfo localChannelInfo = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if (localChannelInfo == null) {
      return false;
    }
    return localChannelInfo.mIsFirstReq;
  }
  
  public boolean a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (paramChannelInfo == null) {
      return false;
    }
    ChannelInfo localChannelInfo = paramChannelInfo.clone();
    this.jdField_b_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelInfo.mChannelID), localChannelInfo);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hzc(this, localChannelInfo));
    }
    return true;
  }
  
  public boolean a(List paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    Object localObject1 = new HashMap(paramList.size());
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ChannelInfo)((Iterator)localObject2).next();
      ((HashMap)localObject1).put(Integer.valueOf(((ChannelInfo)localObject3).mChannelID), localObject3);
    }
    localObject2 = new ArrayList();
    Object localObject3 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject3).next();
      if (((HashMap)localObject1).get(localInteger) == null)
      {
        ((List)localObject2).add(localInteger);
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "saveAllChannelInfoList, channel deleted, channelID=" + localInteger + "channelName=" + ((ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localInteger)).mChannelName);
        }
      }
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      a((Integer)((Iterator)localObject1).next());
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (ChannelInfo)paramList.next();
      localObject2 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(((ChannelInfo)localObject1).mChannelID));
      if (localObject2 == null)
      {
        b((ChannelInfo)localObject1, paramBoolean);
      }
      else if ((!((ChannelInfo)localObject2).mChannelName.equals(((ChannelInfo)localObject1).mChannelName)) || (((ChannelInfo)localObject2).mFontColor != ((ChannelInfo)localObject1).mFontColor) || (((ChannelInfo)localObject2).mFrameColor != ((ChannelInfo)localObject1).mFrameColor))
      {
        ((ChannelInfo)localObject2).mChannelName = ((ChannelInfo)localObject1).mChannelName;
        ((ChannelInfo)localObject2).mFontColor = ((ChannelInfo)localObject1).mFontColor;
        ((ChannelInfo)localObject2).mFrameColor = ((ChannelInfo)localObject1).mFrameColor;
        b((ChannelInfo)localObject2, paramBoolean);
      }
    }
    return true;
  }
  
  public int b()
  {
    return this.u;
  }
  
  public List b()
  {
    c();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localArrayList.add((ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localInteger));
    }
    return localArrayList;
  }
  
  public void b()
  {
    Object localObject = new ReadInJoyRequestParams.Request0x69fParams();
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_a_of_type_Int = 4;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_a_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_b_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).c = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).d = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).j = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).k = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).e = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).f = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).g = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).h = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_b_of_type_Int = 1;
    localObject = a((ReadInJoyRequestParams.Request0x69fParams)localObject);
    ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(1));
    a((ToServiceMsg)localObject);
  }
  
  public void b(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x69e.RspBody()) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, (List)paramToServiceMsg.getAttributes().get("channelIDList"));
      return;
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    paramList = new ArrayList(paramList);
    paramList.remove(Integer.valueOf(9999));
    c(paramList);
    a(paramList);
    ReadInJoyLogicEngineEventDispatcher.a().a(true, null);
  }
  
  public List c()
  {
    c();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      localObject3 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject3);
      if (((ChannelInfo)localObject3).mShow) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    Collections.sort((List)localObject1, new hzb(this));
    localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add(Integer.valueOf(((ChannelInfo)((Iterator)localObject1).next()).mChannelID));
    }
    return (List)localObject2;
  }
  
  public void c(int paramInt)
  {
    ChannelInfo localChannelInfo = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if (localChannelInfo != null) {
      localChannelInfo.mIsFirstReq = false;
    }
  }
  
  public void c(List paramList)
  {
    int i = 0;
    if (paramList == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Integer)((Iterator)localObject1).next();
        localObject2 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2);
        if (localObject2 != null)
        {
          ((ChannelInfo)localObject2).mShow = false;
          ((ChannelInfo)localObject2).mSortOrder = 0;
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int j = ((Integer)paramList.next()).intValue();
        localObject1 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(j));
        if (localObject1 != null)
        {
          ((ChannelInfo)localObject1).mShow = true;
          ((ChannelInfo)localObject1).mSortOrder = i;
          i += 1;
        }
      }
      paramList = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (paramList.hasNext())
      {
        localObject1 = (Integer)paramList.next();
        localObject1 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1);
        if (localObject1 != null) {
          b((ChannelInfo)localObject1, true);
        }
      }
    }
  }
  
  public List d()
  {
    c();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Integer)localIterator.next());
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\model\ChannelInfoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */