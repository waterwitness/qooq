package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeParam;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ac.ArticleComment.ArticleLikeRequest;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import hxy;
import hxz;
import hya;
import hyb;
import hyc;
import hyd;
import hye;
import hyf;
import hyg;
import hyh;
import hyi;
import hyj;
import hyk;
import hyl;
import hyn;
import hyo;
import hyp;
import hyq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeParam;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.ReqBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.RspBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.UserDisLike;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.InnerMsg;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqChannelPara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SubscribeMsg;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ArticleInfo;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqBody;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqPara;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.RspArticle;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.RspBody;

public class ArticleInfoModule
  extends ReadInJoyEngineModule
  implements Observer
{
  public static final String a;
  public int a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  public List a;
  private Map jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map b = new HashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ArticleInfoModule.class.getSimpleName();
  }
  
  public ArticleInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  public ArticleInfoModule(EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(null, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private int a()
  {
    switch (NetworkUtil.a(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  private ToServiceMsg a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    Object localObject1 = null;
    if (paramRequest0x68bParams == null) {}
    Object localObject2;
    label231:
    label246:
    label539:
    label550:
    label561:
    label720:
    do
    {
      do
      {
        return (ToServiceMsg)localObject1;
      } while (paramRequest0x68bParams.jdField_b_of_type_Int == -1);
      localObject1 = new oidb_cmd0x68b.ReqBody();
      long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
      ((oidb_cmd0x68b.ReqBody)localObject1).uint64_uin.set(l);
      ((oidb_cmd0x68b.ReqBody)localObject1).uint32_network_type.set(a());
      localObject2 = new oidb_cmd0x68b.ReqChannelPara();
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint64_channel_id.set(paramRequest0x68bParams.jdField_b_of_type_Int);
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_channel_list.set(1);
      if (paramRequest0x68bParams.jdField_a_of_type_Long != -1L) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint64_begin_recommend_seq.set(paramRequest0x68bParams.jdField_a_of_type_Long);
      }
      if (paramRequest0x68bParams.jdField_b_of_type_Long != -1L) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint64_end_recommend_seq.set(paramRequest0x68bParams.jdField_b_of_type_Long);
      }
      if (paramRequest0x68bParams.jdField_a_of_type_Boolean) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_article_list.set(1);
      }
      if (paramRequest0x68bParams.jdField_b_of_type_Boolean) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_deleted_article_list.set(1);
      }
      if (paramRequest0x68bParams.jdField_a_of_type_JavaUtilList != null) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).rpt_curr_article_list.set(paramRequest0x68bParams.jdField_a_of_type_JavaUtilList);
      }
      if (paramRequest0x68bParams.jdField_b_of_type_JavaUtilList != null) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).rpt_subscription_article_list.set(paramRequest0x68bParams.jdField_b_of_type_JavaUtilList);
      }
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_recommend_flag.set(1);
      ArrayList localArrayList;
      Object localObject3;
      if (paramRequest0x68bParams.jdField_d_of_type_Boolean)
      {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_video_list.set(1);
        if (!paramRequest0x68bParams.jdField_e_of_type_Boolean) {
          break label539;
        }
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_picture_list.set(1);
        if (!paramRequest0x68bParams.f) {
          break label550;
        }
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_need_force_set_top.set(1);
        if (paramRequest0x68bParams.jdField_a_of_type_ArrayOfByte != null) {
          ((oidb_cmd0x68b.ReqChannelPara)localObject2).bytes_set_top_cookie.set(ByteStringMicro.copyFrom(paramRequest0x68bParams.jdField_a_of_type_ArrayOfByte));
        }
        if (paramRequest0x68bParams.jdField_b_of_type_ArrayOfByte != null) {
          ((oidb_cmd0x68b.ReqChannelPara)localObject2).bytes_device_id.set(ByteStringMicro.copyFrom(paramRequest0x68bParams.jdField_b_of_type_ArrayOfByte));
        }
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_update_times.set(paramRequest0x68bParams.jdField_c_of_type_Int);
        if (!ReadInJoyHelper.a(paramRequest0x68bParams.jdField_d_of_type_Int)) {
          ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_is_support_video_with_small_picture.set(1);
        }
        localArrayList = new ArrayList();
        if (TextUtils.isEmpty(paramRequest0x68bParams.jdField_a_of_type_JavaLangString)) {
          break label561;
        }
        localObject3 = new oidb_cmd0x68b.InnerMsg();
        ((oidb_cmd0x68b.InnerMsg)localObject3).uint32_jump_src_type.set(3);
        ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_a_of_type_JavaLangString));
        if (!TextUtils.isEmpty(paramRequest0x68bParams.jdField_b_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_b_of_type_JavaLangString));
        }
        localArrayList.add(localObject3);
      }
      for (;;)
      {
        if ((paramRequest0x68bParams.jdField_b_of_type_JavaUtilList == null) || (paramRequest0x68bParams.jdField_b_of_type_JavaUtilList.size() <= 0)) {
          break label720;
        }
        localObject3 = paramRequest0x68bParams.jdField_b_of_type_JavaUtilList.iterator();
        Object localObject4;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Long)((Iterator)localObject3).next();
          oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
          localInnerMsg.uint32_jump_src_type.set(1);
          localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localObject4)));
          localInnerMsg.uint64_algorithm_id.set(paramRequest0x68bParams.jdField_d_of_type_Long);
          localInnerMsg.uint32_strategy_id.set((int)paramRequest0x68bParams.jdField_e_of_type_Long);
          localArrayList.add(localInnerMsg);
        }
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_video_list.set(0);
        break;
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_picture_list.set(0);
        break label231;
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_need_force_set_top.set(0);
        break label246;
        if (paramRequest0x68bParams.jdField_c_of_type_Long != -1L)
        {
          localObject3 = new ArrayList();
          localObject4 = new oidb_cmd0x68b.SubscribeMsg();
          ((oidb_cmd0x68b.SubscribeMsg)localObject4).uint64_source_article_id.set(paramRequest0x68bParams.jdField_c_of_type_Long);
          if (!TextUtils.isEmpty(paramRequest0x68bParams.jdField_b_of_type_JavaLangString)) {
            ((oidb_cmd0x68b.SubscribeMsg)localObject4).bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_b_of_type_JavaLangString));
          }
          ((List)localObject3).add(localObject4);
          ((oidb_cmd0x68b.ReqChannelPara)localObject2).rpt_subscribe_msg_list.set((List)localObject3);
          localObject3 = new oidb_cmd0x68b.InnerMsg();
          ((oidb_cmd0x68b.InnerMsg)localObject3).uint32_jump_src_type.set(2);
          ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramRequest0x68bParams.jdField_c_of_type_Long)));
          if (!TextUtils.isEmpty(paramRequest0x68bParams.jdField_b_of_type_JavaLangString)) {
            ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_b_of_type_JavaLangString));
          }
          localArrayList.add(localObject3);
        }
      }
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).rpt_inner_msg_list.set(localArrayList);
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_is_disp_timestamp.set(1);
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_is_support_gallery.set(1);
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_picture_number.set(1);
      ((oidb_cmd0x68b.ReqBody)localObject1).reqChannelPara.set((MessageMicro)localObject2);
      ((oidb_cmd0x68b.ReqBody)localObject1).reqChannelPara.setHasFlag(true);
      ((oidb_cmd0x68b.ReqBody)localObject1).uint32_req_dislike_type.set(paramRequest0x68bParams.jdField_e_of_type_Int);
      localObject2 = ReadInJoyOidbHelper.a("OidbSvc.0x68b", 1675, 0, ((oidb_cmd0x68b.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).getAttributes().put(c, Integer.valueOf(paramRequest0x68bParams.jdField_a_of_type_Int));
      ((ToServiceMsg)localObject2).getAttributes().put(d, Long.valueOf(paramRequest0x68bParams.jdField_a_of_type_Long));
      ((ToServiceMsg)localObject2).getAttributes().put(e, Long.valueOf(paramRequest0x68bParams.jdField_b_of_type_Long));
      ((ToServiceMsg)localObject2).getAttributes().put(g, Integer.valueOf(1));
      localObject1 = localObject2;
    } while (paramRequest0x68bParams.jdField_b_of_type_JavaUtilList == null);
    ((ToServiceMsg)localObject2).getAttributes().put(f, paramRequest0x68bParams.jdField_b_of_type_JavaUtilList);
    return (ToServiceMsg)localObject2;
  }
  
  private List a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject1 = "mChannelID = ? and mRecommendSeq < ?";; localObject1 = "mChannelID = ? and mRecommendSeq > ?")
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "loadChannelArticleSeqList with selection=" + (String)localObject1 + "channelId=" + paramInt1 + "recommendSeq=" + paramLong + "count=" + paramInt2);
      }
      localObject2 = new ArrayList();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleInfo.class, true, (String)localObject1, new String[] { String.valueOf(paramInt1), String.valueOf(paramLong) }, null, null, "mRecommendSeq desc", String.valueOf(paramInt2));
      if (localObject1 != null)
      {
        ReadInJoyMSFHandlerUtils.a((List)localObject1);
        ((ArrayList)localObject2).addAll((Collection)localObject1);
      }
      if (!((ArrayList)localObject2).isEmpty()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "loadChannelArticleSeqList mEntityManager.query return empty");
      }
      return null;
    }
    a(Integer.valueOf(paramInt1), (List)localObject2, false);
    localObject1 = new ArrayList(((ArrayList)localObject2).size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    Object localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject2).next();
      if (!localHashSet1.add(Long.valueOf(localArticleInfo.mArticleID))) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadChannelArticleSeqList articleID duplicated, channelID = " + paramInt1 + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
      } else if (!localHashSet2.add(Long.valueOf(localArticleInfo.mRecommendSeq))) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadChannelArticleSeqList articleRecommendSeq duplicated, channelID = " + paramInt1 + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
      } else {
        ((ArrayList)localObject1).add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
    }
    return (List)localObject1;
  }
  
  private List a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Long.valueOf(((ArticleInfo)paramList.next()).mRecommendSeq));
    }
    return localArrayList;
  }
  
  private oidb_cmd0x46f.DislikeParam a(DislikeParam paramDislikeParam)
  {
    oidb_cmd0x46f.DislikeParam localDislikeParam = new oidb_cmd0x46f.DislikeParam();
    localDislikeParam.uint64_articleid.set(paramDislikeParam.jdField_a_of_type_Long);
    localDislikeParam.uint32_reasonid.set(paramDislikeParam.jdField_a_of_type_Int);
    Object localObject1;
    Object localObject2;
    if ((paramDislikeParam.jdField_a_of_type_JavaUtilList != null) && (paramDislikeParam.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject1 = paramDislikeParam.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localDislikeParam.rpt_uint64_tagid.add(localObject2);
      }
    }
    if ((paramDislikeParam.jdField_a_of_type_JavaUtilArrayList != null) && (paramDislikeParam.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramDislikeParam = paramDislikeParam.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDislikeParam.hasNext())
      {
        localObject1 = (DislikeInfo)paramDislikeParam.next();
        localObject2 = new oidb_cmd0x46f.UserDisLike();
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_account_id.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).c));
        ((oidb_cmd0x46f.UserDisLike)localObject2).type.set(((DislikeInfo)localObject1).jdField_a_of_type_Int);
        ((oidb_cmd0x46f.UserDisLike)localObject2).uint64_dislike_tagid.set(((DislikeInfo)localObject1).jdField_a_of_type_Long);
        localDislikeParam.rpt_user_dislike_list.add((MessageMicro)localObject2);
      }
    }
    return localDislikeParam;
  }
  
  private void a(int paramInt)
  {
    this.b.remove(Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyk(this, paramInt));
  }
  
  private void a(Integer paramInteger, ArticleInfo paramArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.b.get(paramInteger);
    if ((paramInteger != null) && (paramInteger.contains(paramArticleInfo))) {
      paramInteger.remove(paramArticleInfo);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hyi(this, paramBoolean, paramInt, paramList));
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List paramList, long paramLong1, long paramLong2)
  {
    paramBoolean2 = false;
    if (!paramBoolean1)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(false, paramInt, null, false);
      return;
    }
    if (paramList == null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(true, paramInt, null, true);
      return;
    }
    a(Integer.valueOf(paramInt), paramList, true);
    paramBoolean1 = paramBoolean2;
    if (paramList.isEmpty()) {
      paramBoolean1 = true;
    }
    paramList = a(Integer.valueOf(paramInt));
    ReadInJoyLogicEngineEventDispatcher.a().a(true, paramInt, paramList, paramBoolean1);
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List paramList1, long paramLong1, long paramLong2, List paramList2)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        break label136;
      }
      a(Integer.valueOf(paramInt), paramList1, true);
      a(paramInt, paramList2);
    }
    for (;;)
    {
      paramList1 = a(Integer.valueOf(paramInt));
      ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean1, paramInt, paramList1);
      if ((paramInt == 0) && (paramList1 != null) && (!paramList1.isEmpty()))
      {
        paramLong1 = NetConnInfoCenter.getServerTime();
        paramList1 = a(Integer.valueOf(paramInt), (Long)paramList1.get(0));
        if ((paramList1 != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
          PublicAccountUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramList1.mTitle, String.valueOf(paramLong1), paramBoolean1);
        }
      }
      return;
      label136:
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleRefreshChannel clearChannelArticleInfo channelId=" + paramInt);
      }
      a(paramInt);
      a(Integer.valueOf(paramInt), paramList1, true);
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List paramList1, long paramLong1, long paramLong2, List paramList2, List paramList3, byte[] paramArrayOfByte, boolean paramBoolean3)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hxy(this, paramLong1, paramInt, paramArrayOfByte, paramBoolean1, paramList1, paramBoolean2, paramLong2, paramList2));
  }
  
  private boolean a(Integer paramInteger, ArticleInfo paramArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (paramArticleInfo == null) {
      return false;
    }
    Object localObject2 = (LinkedHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new LinkedHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramInteger, localObject1);
    }
    localObject2 = paramArticleInfo.clone();
    int i = j;
    if (((LinkedHashMap)localObject1).get(Long.valueOf(((ArticleInfo)localObject2).mRecommendSeq)) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "saveArticleInfo, article duplicated, article been channelID=" + paramInteger + "articleID=" + ((ArticleInfo)localObject2).mArticleID + "toDb=" + paramBoolean1);
      }
      a(paramInteger, (ArticleInfo)localObject2);
      i = j;
      if (((ArticleInfo)localObject2).mAbandonRepeatFlag == 0) {
        i = 1;
      }
    }
    if ((i == 0) || (paramBoolean2)) {
      ((LinkedHashMap)localObject1).put(Long.valueOf(paramArticleInfo.mRecommendSeq), localObject2);
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyq(this, (ArticleInfo)localObject2));
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hyg(this, paramInt));
  }
  
  private void b(int paramInt, List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hyj(this, paramInt, paramList));
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject3 = new oidb_cmd0x68b.RspBody();
    boolean bool3 = false;
    Object localObject1 = (Integer)paramToServiceMsg.getAttributes().get("channelID");
    boolean bool2 = false;
    byte[] arrayOfByte = null;
    Object localObject2 = null;
    List localList = null;
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject3);
    paramFromServiceMsg = ReadInJoyUtils.a();
    boolean bool1;
    if (j == 0)
    {
      bool1 = true;
      ReadInJoyUtils.a(paramFromServiceMsg, bool1, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), j);
      bool1 = bool3;
      if (j != 0) {
        break label726;
      }
      bool3 = true;
      if (((oidb_cmd0x68b.RspBody)localObject3).uint64_uin.has()) {
        ((oidb_cmd0x68b.RspBody)localObject3).uint64_uin.get();
      }
      bool1 = bool3;
      if (!((oidb_cmd0x68b.RspBody)localObject3).rspChannelArticle.has()) {
        break label726;
      }
      bool1 = bool3;
      if (((oidb_cmd0x68b.RspBody)localObject3).rspChannelArticle.get() == null) {
        break label726;
      }
      localObject3 = (oidb_cmd0x68b.RspChannelArticle)((oidb_cmd0x68b.RspBody)localObject3).rspChannelArticle.get();
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      if (((oidb_cmd0x68b.RspChannelArticle)localObject3).uint64_channel_id.has()) {
        paramFromServiceMsg = Integer.valueOf((int)((oidb_cmd0x68b.RspChannelArticle)localObject3).uint64_channel_id.get());
      }
      bool1 = bool2;
      if (((oidb_cmd0x68b.RspChannelArticle)localObject3).uint32_is_no_more_data.has())
      {
        if (((oidb_cmd0x68b.RspChannelArticle)localObject3).uint32_is_no_more_data.get() != 1) {
          break label399;
        }
        bool1 = true;
      }
      paramObject = localObject2;
      if (((oidb_cmd0x68b.RspChannelArticle)localObject3).rpt_article_list.has())
      {
        paramObject = localObject2;
        if (((oidb_cmd0x68b.RspChannelArticle)localObject3).rpt_article_list.get() != null) {
          paramObject = ReadInJoyMSFHandlerUtils.a(((oidb_cmd0x68b.RspChannelArticle)localObject3).rpt_article_list.get(), paramFromServiceMsg.intValue());
        }
      }
      localObject1 = localList;
      if (((oidb_cmd0x68b.RspChannelArticle)localObject3).rpt_deleted_article_list.has())
      {
        localObject1 = localList;
        if (((oidb_cmd0x68b.RspChannelArticle)localObject3).rpt_deleted_article_list.get() != null) {
          localObject1 = ReadInJoyMSFHandlerUtils.a(((oidb_cmd0x68b.RspChannelArticle)localObject3).rpt_deleted_article_list.get(), paramFromServiceMsg.intValue());
        }
      }
      if ((!((oidb_cmd0x68b.RspChannelArticle)localObject3).bytes_set_top_cookie.has()) || (((oidb_cmd0x68b.RspChannelArticle)localObject3).bytes_set_top_cookie.get() == null)) {
        break label712;
      }
      arrayOfByte = ((oidb_cmd0x68b.RspChannelArticle)localObject3).bytes_set_top_cookie.get().toByteArray();
      bool3 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
    for (;;)
    {
      switch (((Integer)paramToServiceMsg.getAttribute(c)).intValue())
      {
      default: 
        return;
        bool1 = false;
        break;
        bool1 = false;
        break;
      case 5: 
        long l1 = ((Long)paramToServiceMsg.getAttribute(d)).longValue();
        long l2 = ((Long)paramToServiceMsg.getAttribute(e)).longValue();
        bool3 = ((Boolean)paramToServiceMsg.getAttribute("isSingleHighLight")).booleanValue();
        int k = ((Integer)paramToServiceMsg.getAttribute(g)).intValue();
        localList = (List)paramToServiceMsg.getAttribute(f);
        if (QLog.isColorLevel()) {
          if (paramObject != null) {
            break label662;
          }
        }
        for (int i = 0;; i = ((List)paramObject).size())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handle0x68bGetSubscribeArticalList result=" + j + " channelID=" + paramFromServiceMsg + " beginSeq=" + l1 + " endSeq=" + l2 + " articlecount=" + i);
          if ((j != 154) || (k != 1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handle0x68bGetSubscribeArticalList re-request" + j + " channelID=" + paramFromServiceMsg + " beginSeq=" + l1 + " endSeq=" + l2);
          }
          paramToServiceMsg.getAttributes().put(g, Integer.valueOf(2));
          a(paramToServiceMsg);
          return;
        }
        a(bool1, paramFromServiceMsg.intValue(), bool2, (List)paramObject, l1, l2, (List)localObject1, localList, arrayOfByte, bool3);
        return;
      case 12: 
        label399:
        label662:
        a(bool1, paramFromServiceMsg.intValue(), (List)localObject1);
        return;
        label712:
        bool3 = true;
        bool2 = bool1;
        bool1 = bool3;
        continue;
        label726:
        localList = null;
        paramObject = null;
        bool2 = false;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        localObject1 = localList;
      }
    }
  }
  
  private List c(Integer paramInteger)
  {
    paramInteger = (LinkedHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if ((paramInteger == null) || (paramInteger.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInteger.size());
    Iterator localIterator = paramInteger.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((ArticleInfo)paramInteger.get((Long)localIterator.next()));
    }
    Collections.sort(localArrayList, new hya(this));
    return localArrayList;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x46f.RspBody();
    int j = 0;
    int i = 0;
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      if (paramToServiceMsg.uint32_fail_count.has()) {
        i = paramToServiceMsg.uint32_fail_count.get();
      }
      j = i;
      if (!paramToServiceMsg.rpt_result_list.has()) {}
    }
    for (paramToServiceMsg = ReadInJoyMSFHandlerUtils.c(paramToServiceMsg.rpt_result_list.get());; paramToServiceMsg = null)
    {
      b(i, paramToServiceMsg);
      return;
      i = j;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x75e.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {
      if ((paramToServiceMsg.msg_rsp_article.has()) && (paramToServiceMsg.msg_rsp_article.get() != null))
      {
        paramToServiceMsg = (oidb_cmd0x75e.RspArticle)paramToServiceMsg.msg_rsp_article.get();
        if ((paramToServiceMsg.rpt_article_info.has()) && (paramToServiceMsg.rpt_article_info.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.rpt_article_info.get();
          if ((paramToServiceMsg.size() > 0) && (((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.has()) && (((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.get() != null))
          {
            paramToServiceMsg = ((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.get().toStringUtf8();
            ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(161)).a(paramToServiceMsg);
          }
        }
      }
    }
    for (;;)
    {
      ReadInJoyHelper.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      return;
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "handle0x75eIndividualArticleList error = " + i);
      }
    }
  }
  
  public int a(Integer paramInteger)
  {
    paramInteger = (List)this.b.get(paramInteger);
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.size();
  }
  
  public long a(Integer paramInteger)
  {
    long l1 = -1L;
    paramInteger = (LinkedHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    long l2;
    if (paramInteger == null) {
      l2 = l1;
    }
    do
    {
      return l2;
      paramInteger = paramInteger.keySet().iterator();
      l2 = l1;
    } while (!paramInteger.hasNext());
    Long localLong = (Long)paramInteger.next();
    if (localLong.longValue() > l1) {
      l1 = localLong.longValue();
    }
    for (;;)
    {
      break;
    }
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    paramInteger = (List)this.b.get(paramInteger);
    if ((paramInteger != null) && (!paramInteger.isEmpty())) {
      return (ArticleInfo)paramInteger.get(paramInteger.size() - 1);
    }
    return null;
  }
  
  public ArticleInfo a(Integer paramInteger, Long paramLong)
  {
    paramInteger = (LinkedHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return (ArticleInfo)paramInteger.get(paramLong);
  }
  
  public List a(Integer paramInteger)
  {
    Object localObject = c(paramInteger);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      if (!localHashSet1.add(Long.valueOf(localArticleInfo.mArticleID)))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getChannelArticleSeqList 有重复文章， channelID = " + paramInteger + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
        a(paramInteger, localArticleInfo);
      }
      else if (!localHashSet2.add(Long.valueOf(localArticleInfo.mRecommendSeq)))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getChannelArticleSeqList articleRecommendSeq duplicated, channelID = " + paramInteger + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
      }
      else
      {
        localArrayList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
    }
    Collections.sort(localArrayList, new hyp(this));
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.b.clear();
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    List localList = a(Integer.valueOf(paramInt1));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyl(this, localList, paramInt1, paramInt2, paramLong, paramBoolean));
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "deleteChannelArticle channelId=" + paramInt + "recommendSeq=" + paramLong);
    }
    if ((paramLong == -2L) || (paramLong == -3L)) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "deleteChannelArticle recommendSeq is TOPIC/SUBSCRIBE recommendSeq");
      }
    }
    LinkedHashMap localLinkedHashMap;
    ArticleInfo localArticleInfo;
    do
    {
      do
      {
        return;
        localLinkedHashMap = (LinkedHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
      } while (localLinkedHashMap == null);
      localArticleInfo = (ArticleInfo)localLinkedHashMap.get(Long.valueOf(paramLong));
      if (localArticleInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "deleteChannelArticle connot find channelId=" + paramInt + "ArticleInfo with recommendSeq=" + paramLong);
    return;
    a(Integer.valueOf(paramInt), localArticleInfo);
    localLinkedHashMap.remove(Long.valueOf(paramLong));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyc(this, localArticleInfo));
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    Object localObject1;
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "deleteChannelArticleList channelID=" + paramInt + "articleList");
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ArticleInfo)((Iterator)localObject1).next();
          QLog.e(jdField_a_of_type_JavaLangString, 2, "articleInfo.mArticleID=" + ((ArticleInfo)localObject2).mArticleID);
        }
      }
      localObject1 = (LinkedHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    } while (localObject1 == null);
    Object localObject2 = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    label150:
    ArticleInfo localArticleInfo;
    Map.Entry localEntry;
    if (localIterator.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator.next();
      paramList = ((LinkedHashMap)localObject1).entrySet().iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)paramList.next();
      } while (((ArticleInfo)localEntry.getValue()).mArticleID != localArticleInfo.mArticleID);
    }
    for (paramList = (ArticleInfo)localEntry.getValue();; paramList = null)
    {
      if (paramList == null)
      {
        if (!QLog.isColorLevel()) {
          break label150;
        }
        ((StringBuilder)localObject2).append("deleteChannelArticleList connot find channelId=" + paramInt + "ArticleInfo with recommendSeq=" + localArticleInfo.mRecommendSeq + '\n');
        break label150;
      }
      a(Integer.valueOf(paramInt), paramList);
      ((LinkedHashMap)localObject1).remove(Long.valueOf(paramList.mRecommendSeq));
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyb(this, paramList));
      break label150;
      if (((StringBuilder)localObject2).length() <= 0) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject2).toString());
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    oidb_cmd0x75e.ReqBody localReqBody = new oidb_cmd0x75e.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.uint32_network_type.set(a());
    oidb_cmd0x75e.ReqPara localReqPara = new oidb_cmd0x75e.ReqPara();
    localReqPara.enum_op_type.set(paramInt);
    localReqBody.msg_req_para.set(localReqPara);
    a(ReadInJoyOidbHelper.a("OidbSvc.0x75e", 1886, 0, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong, List paramList)
  {
    oidb_cmd0x46f.ReqBody localReqBody = new oidb_cmd0x46f.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeParam localDislikeParam = a((DislikeParam)paramList.next());
      localReqBody.rpt_param_list.add(localDislikeParam);
    }
    a(ReadInJoyOidbHelper.a("OidbSvc.0x46f", 1135, 0, localReqBody.toByteArray()));
  }
  
  public void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    Object localObject = new ReadInJoyRequestParams.Request0x68bParams();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_Int = 5;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Int = paramRequest0x68bParams.jdField_b_of_type_Int;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_Long = paramRequest0x68bParams.jdField_a_of_type_Long;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Long = paramRequest0x68bParams.jdField_b_of_type_Long;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Boolean = paramRequest0x68bParams.jdField_b_of_type_Boolean;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_JavaUtilList = paramRequest0x68bParams.jdField_a_of_type_JavaUtilList;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_c_of_type_Boolean = paramRequest0x68bParams.jdField_c_of_type_Boolean;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_JavaUtilList = paramRequest0x68bParams.jdField_b_of_type_JavaUtilList;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_d_of_type_Boolean = paramRequest0x68bParams.jdField_d_of_type_Boolean;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_e_of_type_Boolean = paramRequest0x68bParams.jdField_e_of_type_Boolean;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).f = paramRequest0x68bParams.f;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_ArrayOfByte = paramRequest0x68bParams.jdField_a_of_type_ArrayOfByte;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_ArrayOfByte = paramRequest0x68bParams.jdField_b_of_type_ArrayOfByte;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_c_of_type_Int = paramRequest0x68bParams.jdField_c_of_type_Int;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_JavaLangString = paramRequest0x68bParams.jdField_a_of_type_JavaLangString;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_c_of_type_Long = paramRequest0x68bParams.jdField_c_of_type_Long;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_JavaLangString = paramRequest0x68bParams.jdField_b_of_type_JavaLangString;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_d_of_type_Int = paramRequest0x68bParams.jdField_d_of_type_Int;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_d_of_type_Long = paramRequest0x68bParams.jdField_d_of_type_Long;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_e_of_type_Long = paramRequest0x68bParams.jdField_e_of_type_Long;
    localObject = a((ReadInJoyRequestParams.Request0x68bParams)localObject);
    if (localObject != null)
    {
      ((ToServiceMsg)localObject).getAttributes().put("channelID", new Integer(paramRequest0x68bParams.jdField_b_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put("isSingleHighLight", Boolean.valueOf(paramRequest0x68bParams.g));
    }
    a((ToServiceMsg)localObject);
  }
  
  public void a(ChannelTopCookie paramChannelTopCookie)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramChannelTopCookie.mChannelID), paramChannelTopCookie);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x46f"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while ((paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.ArticleLike")) || (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x75e")));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(Integer paramInteger)
  {
    this.b.remove(paramInteger);
  }
  
  public void a(Integer paramInteger, byte[] paramArrayOfByte)
  {
    ChannelTopCookie localChannelTopCookie = (ChannelTopCookie)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (localChannelTopCookie == null)
    {
      localChannelTopCookie = new ChannelTopCookie();
      localChannelTopCookie.mChannelID = paramInteger.intValue();
      localChannelTopCookie.mSetTopCookie = paramArrayOfByte;
    }
    for (paramInteger = localChannelTopCookie;; paramInteger = localChannelTopCookie)
    {
      a(paramInteger);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyf(this, paramInteger));
      return;
      localChannelTopCookie.mSetTopCookie = paramArrayOfByte;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ArticleComment.ArticleLikeRequest localArticleLikeRequest = new ArticleComment.ArticleLikeRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localArticleLikeRequest.article_id.set(paramString);
    localArticleLikeRequest.uin.set(Long.valueOf(ReadInJoyUtils.a()).longValue());
    if (paramBoolean) {
      localArticleLikeRequest.like.set(1);
    }
    for (;;)
    {
      paramString = new ToServiceMsg("mobileqq.service", ReadInJoyUtils.a(), "PubAccountArticleCenter.ArticleLike");
      paramString.putWupBuffer(localArticleLikeRequest.toByteArray());
      paramString.setTimeout(30000L);
      a(paramString);
      return;
      localArticleLikeRequest.like.set(0);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hye(this, paramList));
  }
  
  public void a(List paramList, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hyo(this, paramList, paramInt2, paramInt1, paramInt3, paramBoolean, paramLong));
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "setSubscriptionArticles articleIds is null ");
      }
    }
    for (;;)
    {
      return;
      if (paramList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "setSubscriptionArticles articleIds is empty ");
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        if (paramBoolean)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramList.get(0), new AtomicBoolean(true));
          return;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Long localLong = (Long)paramList.next();
          this.jdField_a_of_type_JavaUtilHashMap.put(localLong, new AtomicBoolean(true));
        }
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    ReadInJoyHelper.a(paramAppRuntime, paramString, paramBoolean);
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    if (paramBoolean) {}
    for (String str = "mChannelID = ? and mRecommendSeq < ?";; str = "mChannelID = ? and mRecommendSeq > ?")
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "loadMoreChannelArticleList with selection=" + str + "channelId=" + paramInt1 + "recommendSeq=" + paramLong + "count=" + paramInt2);
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyn(this, str, paramInt1, paramLong, paramInt2, paramBoolean, paramInt3));
      return true;
    }
  }
  
  public boolean a(Integer paramInteger, List paramList, boolean paramBoolean)
  {
    if ((paramInteger.intValue() == -1) || (paramList == null) || (paramList.size() == 0))
    {
      this.b.remove(paramInteger);
      return false;
    }
    Object localObject = new CopyOnWriteArrayList(paramList);
    this.b.put(paramInteger, localObject);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ArticleInfo)paramList.next();
      a(paramInteger, (ArticleInfo)localObject, paramBoolean, a(Long.valueOf(((ArticleInfo)localObject).mArticleID)));
    }
    return true;
  }
  
  public boolean a(Long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public byte[] a()
  {
    String str2 = DeviceInfoUtil.a();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1.getBytes();
  }
  
  public byte[] a(Integer paramInteger)
  {
    paramInteger = (ChannelTopCookie)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return paramInteger.mSetTopCookie;
  }
  
  public long b(Integer paramInteger)
  {
    long l1 = Long.MAX_VALUE;
    paramInteger = (LinkedHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    long l2;
    if (paramInteger == null) {
      l2 = -1L;
    }
    do
    {
      return l2;
      paramInteger = paramInteger.keySet().iterator();
      l2 = l1;
    } while (!paramInteger.hasNext());
    Long localLong = (Long)paramInteger.next();
    if (localLong.longValue() < l1) {
      l1 = localLong.longValue();
    }
    for (;;)
    {
      break;
    }
  }
  
  public List b(Integer paramInteger)
  {
    Object localObject = c(paramInteger);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      if ((localHashSet.contains(Long.valueOf(localArticleInfo.mArticleID))) || (localArticleInfo.mRecommendSeq == -2L) || (localArticleInfo.mRecommendSeq == -3L))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getChannelArticleSeqList 有重复文章， channelID = " + paramInteger + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
        a(paramInteger, localArticleInfo);
      }
      else
      {
        localHashSet.add(Long.valueOf(localArticleInfo.mArticleID));
      }
    }
    localArrayList.addAll(localHashSet);
    Collections.sort(localArrayList, new hxz(this));
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp isn't instanceof QQAppInterface init model failed!");
    return;
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().addObserver(this);
  }
  
  public boolean b(Long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramLong) != null) {
          bool1 = ((AtomicBoolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong)).get();
        }
      }
    }
    return bool1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().deleteObserver(this);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyd(this));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    b(((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(161)).a(0));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while (((paramObject instanceof QQMessageFacade.Message)) || (!(paramObject instanceof MessageRecord)));
      paramObservable = (MessageRecord)paramObject;
    } while (paramObservable.isSendFromLocal());
    ((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(161)).a(paramObservable, 0);
    this.jdField_a_of_type_AndroidOsHandler.post(new hyh(this, paramObservable));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\model\ArticleInfoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */