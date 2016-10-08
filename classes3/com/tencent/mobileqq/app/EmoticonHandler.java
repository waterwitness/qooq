package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager.SyncFetchEmoticonKeyObserver;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.emosm.EmosmPb.ReqBody;
import com.tencent.pb.emosm.EmosmPb.RspBody;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x10MoveOrderReq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x1ReqDelTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x1RspDelTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2ReqFetchTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab.TabInfo;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x3ReqFetchBq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x3RspFetchBq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5ReqBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x6Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x6Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x7Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x7Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x8ReqAddTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocReq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class EmoticonHandler
  extends BusinessHandler
{
  public static final String a = "EmoticonHandler";
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private SparseArray b;
  private SparseArray c;
  
  public EmoticonHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.c = new SparseArray();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected Class a()
  {
    return EmoticonObserver.class;
  }
  
  public void a()
  {
    int i = -1;
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(5);
    localReqBody.str_app_version.set("6.5.5");
    Object localObject = new EmosmPb.SubCmd0x5ReqBQRecommend();
    int j = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendEmotion_sp_lastversion", -1);
    if (!new File(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "recommemd_emotion_file_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).exists()) {}
    for (;;)
    {
      ((EmosmPb.SubCmd0x5ReqBQRecommend)localObject).int32_last_recommend_version.set(i);
      localReqBody.msg_subcmd0x5_req.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
      ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 5);
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      super.b((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "handle request to recommendEmotionInfo");
      }
      return;
      i = j;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new EmosmPb.SubCmd0x1ReqDelTab();
    ((EmosmPb.SubCmd0x1ReqDelTab)localObject).uint32_tab_id.set(paramInt);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.msg_subcmd0x1_req_deltab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", paramInt);
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 1);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "func fetchEmoticonsPackages, timestamp:" + paramInt1 + ",dividemask:" + paramInt2);
    }
    Object localObject = new EmosmPb.SubCmd0x2ReqFetchTab();
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject).fixed32_timestamp.set(paramInt1);
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject).int32_segment_flag.set(paramInt2);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(2);
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.msg_subcmd0x2_req_fetchtab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localReqBody.str_app_version.set("6.5.5");
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 2);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.str_app_version.set("6.5.5");
    Object localObject;
    if (6 == paramInt1)
    {
      localReqBody.uint32_sub_cmd.set(paramInt1);
      localObject = new EmosmPb.SubCmd0x6Req();
      ((EmosmPb.SubCmd0x6Req)localObject).u32_tab_id.set(paramInt2);
      ((EmosmPb.SubCmd0x6Req)localObject).str_item_id.set(paramString);
      localReqBody.msg_subcmd0x6_req.set((MessageMicro)localObject);
    }
    for (;;)
    {
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
      ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", paramInt2);
      ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", paramInt1);
      ((ToServiceMsg)localObject).extraData.putString("EmoticonId", paramString);
      ((ToServiceMsg)localObject).extraData.putBoolean("EmosmSubCmdFllow", false);
      if (107 == paramInt1)
      {
        ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 7);
        ((ToServiceMsg)localObject).extraData.putBoolean("EmosmSubCmdFllow", true);
      }
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      super.b((ToServiceMsg)localObject);
      return;
      if ((7 == paramInt1) || (107 == paramInt1))
      {
        localReqBody.uint32_sub_cmd.set(7);
        localObject = new EmosmPb.SubCmd0x7Req();
        ((EmosmPb.SubCmd0x7Req)localObject).u32_tab_id.set(paramInt2);
        ((EmosmPb.SubCmd0x7Req)localObject).str_item_id.set(paramString);
        localReqBody.msg_subcmd0x7_req.set((MessageMicro)localObject);
      }
    }
  }
  
  public void a(int paramInt, ArrayList paramArrayList, String paramString)
  {
    if (paramArrayList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "emosm...fetch key count  = " + paramArrayList.size() + " epid = " + ((Emoticon)paramArrayList.get(0)).epId + "  eid.0 = " + ((Emoticon)paramArrayList.get(0)).eId);
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Emoticon)((Iterator)localObject2).next();
      try
      {
        localObject3 = ByteStringMicro.copyFrom(EmoticonUtils.a(((Emoticon)localObject3).eId));
        ((List)localObject1).add(localObject3);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    localObject2 = new EmosmPb.SubCmd0x3ReqFetchBq();
    ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).uint32_tab_id.set(paramInt);
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).rpt_bytes_bqid.get().add(((List)localObject1).get(i));
      i += 1;
    }
    localObject1 = new EmosmPb.ReqBody();
    ((EmosmPb.ReqBody)localObject1).uint32_sub_cmd.set(3);
    ((EmosmPb.ReqBody)localObject1).uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    ((EmosmPb.ReqBody)localObject1).msg_subcmd0x3_req_fetchbq.set((MessageMicro)localObject2);
    ((EmosmPb.ReqBody)localObject1).int32_plat_id.set(109);
    localObject2 = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmPackageId", paramInt);
    ((ToServiceMsg)localObject2).extraData.putSerializable("EmosmEmos", paramArrayList);
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmSubCmd", 3);
    ((ToServiceMsg)localObject2).addAttribute("_tag_LOGSTR", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "getKeySeq reqlocalseq:" + paramString);
    }
    ((ToServiceMsg)localObject2).putWupBuffer(((EmosmPb.ReqBody)localObject1).toByteArray());
    super.b((ToServiceMsg)localObject2);
  }
  
  public void a(EmojiManager.SyncFetchEmoticonKeyObserver paramSyncFetchEmoticonKeyObserver)
  {
    if ((paramSyncFetchEmoticonKeyObserver != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramSyncFetchEmoticonKeyObserver))) {
      this.jdField_a_of_type_JavaUtilList.add(paramSyncFetchEmoticonKeyObserver);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int j;
    int i;
    Object localObject1;
    Object localObject2;
    EmoticonResp localEmoticonResp;
    int k;
    label279:
    boolean bool2;
    label283:
    label314:
    label324:
    label448:
    Object localObject3;
    int m;
    if (paramFromServiceMsg.getServiceCmd().equals("BQMallSvc.TabOpReq"))
    {
      bool1 = paramFromServiceMsg.isSuccess();
      j = paramToServiceMsg.extraData.getInt("EmosmPackageId");
      i = paramToServiceMsg.extraData.getInt("EmosmSubCmd");
      localObject1 = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
      localObject2 = (ArrayList)paramToServiceMsg.extraData.getSerializable("EmosmEmos");
      localEmoticonResp = new EmoticonResp();
      localEmoticonResp.resultcode = paramFromServiceMsg.getResultCode();
      localEmoticonResp.data = ((List)localObject2);
      localEmoticonResp.epId = j;
      localEmoticonResp.keySeq = ((String)localObject1);
      localEmoticonResp.timeoutReason = MessageHandler.a(paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "key_seq=" + (String)localObject1 + " isSuccess=" + bool1 + " resultCode=" + paramFromServiceMsg.getResultCode() + " timeout:" + localEmoticonResp.timeoutReason);
      }
      if (bool1)
      {
        paramFromServiceMsg = new EmosmPb.RspBody();
        for (;;)
        {
          try
          {
            paramFromServiceMsg = (EmosmPb.RspBody)paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if (paramFromServiceMsg == null) {
              break;
            }
            k = paramFromServiceMsg.int32_result.get();
            localEmoticonResp.resultcode = k;
            if (k != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("EmoticonHandler", 2, "emosm...fetch key 回包 sso 成功 ，server 失败，result = " + k);
              }
              bool1 = false;
              j = i;
              bool2 = bool1;
              paramToServiceMsg = (EmoticonManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
              if (j != 2) {
                break label2887;
              }
              bool1 = paramToServiceMsg.a(bool2, j, localEmoticonResp);
              a(j, bool1, localEmoticonResp);
              return;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            localEmoticonResp.resultcode = -1;
            paramFromServiceMsg = null;
            continue;
            paramObject = (EmoticonManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
            switch (i)
            {
            }
          }
          do
          {
            break;
            localEmoticonResp.data = null;
            localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x1RspDelTab)paramFromServiceMsg.msg_subcmd0x1_rsp_deltab.get()).uint32_tab_id.get();
            paramToServiceMsg = String.valueOf(localEmoticonResp.delEpId);
            ((EmoticonManager)paramObject).b(paramToServiceMsg);
            paramToServiceMsg = ((EmoticonManager)paramObject).a(paramToServiceMsg);
            EmojiListenerManager.a().b(paramToServiceMsg);
            break;
            paramToServiceMsg = paramToServiceMsg.extraData.getIntegerArrayList("EmosmPackageIds");
          } while (paramToServiceMsg == null);
          if (paramToServiceMsg.size() != 0)
          {
            localEmoticonResp.ids = paramToServiceMsg;
            paramToServiceMsg = paramToServiceMsg.iterator();
            while (paramToServiceMsg.hasNext())
            {
              paramFromServiceMsg = String.valueOf((Integer)paramToServiceMsg.next());
              ((EmoticonManager)paramObject).b(paramFromServiceMsg);
              paramFromServiceMsg = ((EmoticonManager)paramObject).a(paramFromServiceMsg);
              EmojiListenerManager.a().b(paramFromServiceMsg);
            }
          }
        }
        localObject2 = (EmosmPb.SubCmd0x2RspFetchTab)paramFromServiceMsg.msg_subcmd0x2_rsp_fetchtab.get();
        k = ((EmosmPb.SubCmd0x2RspFetchTab)localObject2).int32_segment_flag.get();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonHandler", 2, "cur segement:" + k);
        }
        paramToServiceMsg = ((EmosmPb.SubCmd0x2RspFetchTab)localObject2).rpt_msg_tabinfo.get();
        localObject1 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject2).rpt_magic_tabinfo.get();
        paramObject = ((EmosmPb.SubCmd0x2RspFetchTab)localObject2).rpt_smallbq_tabinfo.get();
        if (((EmosmPb.SubCmd0x2RspFetchTab)localObject2).uint32_tab_id.has())
        {
          localObject2 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject2).uint32_tab_id.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Integer)((Iterator)localObject2).next();
            this.jdField_a_of_type_JavaUtilArrayList.add(String.valueOf(localObject3));
          }
        }
        m = ((EmosmPb.SubCmd0x2RspFetchTab)paramFromServiceMsg.msg_subcmd0x2_rsp_fetchtab.get()).fixed32_timestamp.get();
        if ((k == 0) || (k == -1))
        {
          localEmoticonResp.timestamp = m;
          paramFromServiceMsg = new ArrayList();
          if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) == null) {
            break label3499;
          }
          ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).addAll(paramToServiceMsg);
          paramToServiceMsg = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(j);
        }
      }
    }
    label1184:
    label1346:
    label1848:
    label1916:
    label1930:
    label2887:
    label3116:
    label3330:
    label3336:
    label3499:
    for (;;)
    {
      paramToServiceMsg = paramToServiceMsg.iterator();
      if (paramToServiceMsg.hasNext())
      {
        localObject2 = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramToServiceMsg.next();
        localObject3 = new EmoticonPackage();
        ((EmoticonPackage)localObject3).epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_tab_id.get());
        ((EmoticonPackage)localObject3).expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).fixed32_expire_time.get();
        if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_flags.get() == 1) {}
        for (bool2 = true;; bool2 = false)
        {
          ((EmoticonPackage)localObject3).valid = bool2;
          ((EmoticonPackage)localObject3).wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_wording_id.get();
          ((EmoticonPackage)localObject3).name = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).str_tab_name.get();
          paramFromServiceMsg.add(localObject3);
          if (!((EmoticonPackage)localObject3).valid) {
            QLog.e("EmoticonHandler", 1, "TYPE_EMOSM_PS_FETCH: normal emotion ep not valid ; ep = " + localObject3);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EmoticonHandler", 2, "TYPE_EMOSM_PS_FETCH: normal emotion ep = " + localObject3);
          break;
        }
      }
      localEmoticonResp.data = paramFromServiceMsg;
      paramFromServiceMsg = new ArrayList();
      if (this.jdField_b_of_type_AndroidUtilSparseArray.get(j) != null)
      {
        ((List)this.jdField_b_of_type_AndroidUtilSparseArray.get(j)).addAll((Collection)localObject1);
        paramToServiceMsg = (List)this.jdField_b_of_type_AndroidUtilSparseArray.get(j);
        this.jdField_b_of_type_AndroidUtilSparseArray.remove(j);
      }
      for (;;)
      {
        paramToServiceMsg = paramToServiceMsg.iterator();
        if (paramToServiceMsg.hasNext())
        {
          localObject1 = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramToServiceMsg.next();
          localObject2 = new EmoticonPackage();
          ((EmoticonPackage)localObject2).epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).uint32_tab_id.get());
          ((EmoticonPackage)localObject2).expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).fixed32_expire_time.get();
          if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).uint32_flags.get() == 1)
          {
            bool2 = true;
            ((EmoticonPackage)localObject2).valid = bool2;
            ((EmoticonPackage)localObject2).wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).int32_wording_id.get();
            ((EmoticonPackage)localObject2).name = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).str_tab_name.get();
            if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).int32_tab_type.has())
            {
              ((EmoticonPackage)localObject2).type = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).int32_tab_type.get();
              if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).int32_tab_type.get() != 1) {
                break label1346;
              }
              ((EmoticonPackage)localObject2).jobType = 3;
            }
          }
          for (;;)
          {
            if (!((EmoticonPackage)localObject2).valid) {
              QLog.e("EmoticonHandler", 1, "TYPE_EMOSM_PS_FETCH: magic emotion ep not valid ; ep = " + localObject2);
            }
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonHandler", 2, "TYPE_EMOSM_PS_FETCH: magic emotion ep = " + localObject2);
            }
            paramFromServiceMsg.add(localObject2);
            break;
            bool2 = false;
            break label1184;
            if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).int32_tab_type.get() == 4) {
              ((EmoticonPackage)localObject2).jobType = 5;
            }
          }
        }
        localEmoticonResp.magicData = paramFromServiceMsg;
        paramFromServiceMsg = new ArrayList();
        if (this.c.get(j) != null)
        {
          ((List)this.c.get(j)).addAll((Collection)paramObject);
          paramToServiceMsg = (List)this.c.get(j);
          this.c.remove(j);
        }
        for (;;)
        {
          paramToServiceMsg = paramToServiceMsg.iterator();
          if (paramToServiceMsg.hasNext())
          {
            paramObject = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramToServiceMsg.next();
            localObject1 = new EmoticonPackage();
            ((EmoticonPackage)localObject1).epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramObject).uint32_tab_id.get());
            ((EmoticonPackage)localObject1).expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramObject).fixed32_expire_time.get();
            if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramObject).uint32_flags.get() == 1) {}
            for (bool2 = true;; bool2 = false)
            {
              ((EmoticonPackage)localObject1).valid = bool2;
              ((EmoticonPackage)localObject1).wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramObject).int32_wording_id.get();
              ((EmoticonPackage)localObject1).name = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramObject).str_tab_name.get();
              ((EmoticonPackage)localObject1).jobType = 4;
              paramFromServiceMsg.add(localObject1);
              if (!((EmoticonPackage)localObject1).valid) {
                QLog.e("EmoticonHandler", 1, "TYPE_EMOSM_PS_FETCH: small emotion ep not valid ; ep = " + localObject1);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("EmoticonHandler", 2, "TYPE_EMOSM_PS_FETCH: small emotion ep = " + localObject1);
              break;
            }
          }
          localEmoticonResp.smallEmoticonData = paramFromServiceMsg;
          localEmoticonResp.tabOrderList = new ArrayList();
          j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          while (j >= 0)
          {
            localEmoticonResp.tabOrderList.add(this.jdField_a_of_type_JavaUtilArrayList.get(j));
            j -= 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "svr big emoticon list=" + localEmoticonResp.data + "svr magic emoticon list=" + localEmoticonResp.magicData + "svr small emoticon list=" + localEmoticonResp.smallEmoticonData + "svr emoticon tab order list=" + this.jdField_a_of_type_JavaUtilArrayList);
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          break;
          if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) != null)
          {
            ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).addAll(paramToServiceMsg);
            if (this.jdField_b_of_type_AndroidUtilSparseArray.get(j) == null) {
              break label1916;
            }
            ((List)this.jdField_b_of_type_AndroidUtilSparseArray.get(j)).addAll((Collection)localObject1);
            if (this.c.get(j) == null) {
              break label1930;
            }
            ((List)this.c.get(j)).addAll((Collection)paramObject);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonHandler", 2, "--------secend fetch--------:");
            }
            a(m, k);
            return;
            this.jdField_a_of_type_AndroidUtilSparseArray.put(j, paramToServiceMsg);
            break;
            this.jdField_b_of_type_AndroidUtilSparseArray.put(j, localObject1);
            break label1848;
            this.c.put(j, paramObject);
          }
          paramToServiceMsg = (ArrayList)localEmoticonResp.data;
          localEmoticonResp.epId = j;
          paramFromServiceMsg = ((EmosmPb.SubCmd0x3RspFetchBq)paramFromServiceMsg.msg_subcmd0x3_rsp_fetchbq.get()).rpt_bytes_key.get();
          j = 0;
          while (j < paramFromServiceMsg.size())
          {
            paramObject = (ByteStringMicro)paramFromServiceMsg.get(j);
            ((Emoticon)paramToServiceMsg.get(j)).encryptKey = ((ByteStringMicro)paramObject).toStringUtf8();
            j += 1;
          }
          localEmoticonResp.data = paramToServiceMsg;
          if (!QLog.isColorLevel()) {
            break label448;
          }
          QLog.d("EmoticonHandler", 2, "emosm...fetch key 回包 sso 成功 ，server 成功");
          break;
          localEmoticonResp.emoticonId = paramToServiceMsg.extraData.getString("EmoticonId");
          localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x6Rsp)paramFromServiceMsg.msg_subcmd0x6_collect_auth.get()).int32_auth_detail.get();
          localEmoticonResp.keySeq = ((EmosmPb.SubCmd0x6Rsp)paramFromServiceMsg.msg_subcmd0x6_collect_auth.get()).str_auth_msg.get();
          break;
          localEmoticonResp.emoticonId = paramToServiceMsg.extraData.getString("EmoticonId");
          localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x7Rsp)paramFromServiceMsg.msg_subcmd0x7_rsp.get()).int32_auth_detail.get();
          localEmoticonResp.keySeq = ((EmosmPb.SubCmd0x7Rsp)paramFromServiceMsg.msg_subcmd0x7_rsp.get()).str_auth_msg.get();
          if (!paramToServiceMsg.extraData.getBoolean("EmosmSubCmdFllow")) {
            break label448;
          }
          i = 107;
          break;
          localEmoticonResp.data = ((EmosmPb.SubCmd0x9BqAssocRsp)paramFromServiceMsg.msg_subcmd0x9_rsp.get()).rpt_assoc_bqs.get();
          break;
          paramToServiceMsg = (EmosmPb.SubCmd0x5RspBQRecommend)paramFromServiceMsg.msg_subcmd0x5_recommend.get();
          bool2 = paramToServiceMsg.bool_update_flag.get();
          if (bool2)
          {
            j = paramToServiceMsg.int32_last_recommend_version.get();
            paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit();
            paramFromServiceMsg.putInt("recommendEmotion_sp_lastversion", j);
            paramFromServiceMsg.putBoolean("isClickRecommendRedpoint", false);
            paramFromServiceMsg.putLong("recommendRedpointStartTime", System.currentTimeMillis());
            paramFromServiceMsg.putInt("recommendSeqinterval", paramToServiceMsg.int32_req_frequency.get());
            paramFromServiceMsg.commit();
            boolean bool3 = paramToServiceMsg.bool_update_flag.get();
            BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0).edit().putBoolean("force_to_recommend_panel_sp", bool3).commit();
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonHandler", 2, "recommend info : lastVersion = " + j + ";seqFrequncy = " + paramToServiceMsg.int32_req_frequency.get() + ";isForceToRecommend = " + bool3);
            }
            ((EmoticonManager)paramObject).a(paramToServiceMsg);
          }
          if (!QLog.isColorLevel()) {
            break label448;
          }
          QLog.d("EmoticonHandler", 2, "recommend update flag = " + bool2);
          break;
          paramToServiceMsg = ((EmosmPb.SubCmd0x13Rsp)paramFromServiceMsg.msg_subcmd0x13_rsp.get()).itemlist.get();
          if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 1))
          {
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              j = 0;
              while (j < paramToServiceMsg.size())
              {
                paramObject = (EmosmPb.SmallYellowItem)paramToServiceMsg.get(j);
                if ((QLog.isColorLevel()) && (paramObject != null)) {
                  paramFromServiceMsg.append("type = " + ((EmosmPb.SmallYellowItem)paramObject).type.get() + ";id = " + ((EmosmPb.SmallYellowItem)paramObject).id.get() + ";ts =" + ((EmosmPb.SmallYellowItem)paramObject).ts.get());
                }
                j += 1;
              }
              QLog.d("EmoticonHandler", 2, "commonused systememoji item : " + paramFromServiceMsg.toString());
            }
            QLog.d("EmoticonHandler", 1, "commonused back");
            ((CommonUsedSystemEmojiManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(171)).a(paramToServiceMsg);
            break;
          }
          QLog.e("EmoticonHandler", 1, "handleCommonUseInfo ItemInfo = null");
          break label448;
          bool2 = false;
          localEmoticonResp.resultcode = -1;
          bool1 = bool2;
          j = i;
          if (!QLog.isColorLevel()) {
            break label279;
          }
          QLog.d("EmoticonHandler", 2, "emosm...fetch key 回包 异常 subcmd = " + i);
          bool1 = bool2;
          j = i;
          break label279;
          k = paramToServiceMsg.extraData.getInt("EmoticonRetry");
          QLog.e("EmoticonHandler", 1, "error can not send cmd: " + i);
          j = i;
          bool2 = bool1;
          if (paramFromServiceMsg.getResultCode() == 1000) {
            break label283;
          }
          j = i;
          bool2 = bool1;
          if (k >= 2) {
            break label283;
          }
          j = i;
          bool2 = bool1;
          if (i != 2) {
            break label283;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "try index: " + k);
          }
          paramToServiceMsg.extraData.putInt("EmoticonRetry", k + 1);
          super.b(paramToServiceMsg);
          return;
          bool1 = bool2;
          if (j != 3) {
            break label314;
          }
          paramFromServiceMsg = (ArrayList)localEmoticonResp.data;
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0) && (bool2)) {
            paramFromServiceMsg = paramFromServiceMsg.iterator();
          }
          while (paramFromServiceMsg.hasNext())
          {
            paramObject = (Emoticon)paramFromServiceMsg.next();
            paramToServiceMsg.a((Emoticon)paramObject);
            if (QLog.isColorLevel())
            {
              QLog.d("EmoticonHandler", 2, "epId:" + ((Emoticon)paramObject).epId + ",eId:" + ((Emoticon)paramObject).eId + ",key:" + ((Emoticon)paramObject).encryptKey);
              continue;
              QLog.i("EmoticonHandler", 1, "fetch key error:" + localEmoticonResp.resultcode);
            }
          }
          paramToServiceMsg = this.jdField_a_of_type_JavaUtilList.iterator();
          for (;;)
          {
            bool1 = bool2;
            if (!paramToServiceMsg.hasNext()) {
              break;
            }
            ((EmojiManager.SyncFetchEmoticonKeyObserver)paramToServiceMsg.next()).a(bool2, j, localEmoticonResp);
          }
          if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x490_92"))
          {
            if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
            {
              i = 1;
              bool1 = true;
              if (i == 0) {}
            }
            else
            {
              for (;;)
              {
                try
                {
                  paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
                  paramToServiceMsg.mergeFrom((byte[])paramObject);
                  if (paramToServiceMsg.uint32_result.get() != 0) {
                    break label3330;
                  }
                  i = 1;
                  if (i != 0)
                  {
                    paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
                    long l = paramToServiceMsg.getInt();
                    if (paramToServiceMsg.get() != 1) {
                      break label3336;
                    }
                    bool1 = true;
                    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emosm_has_download_emosmpackage_tag_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), bool1).commit();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB, needToFetchEmosmList = " + bool1);
                  }
                  if (!bool1) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB, initEmoticon");
                  }
                  a(0, 0);
                  return;
                }
                catch (Exception paramToServiceMsg)
                {
                  QLog.e("EmoticonHandler", 1, paramToServiceMsg.getMessage());
                  return;
                }
                i = 0;
                break label3116;
                i = 0;
                continue;
                bool1 = false;
              }
            }
            i = paramToServiceMsg.extraData.getInt("EmoticonRetry");
            QLog.e("EmoticonHandler", 1, "CMD_EMOSM_CHECK_OIDB, error:" + paramFromServiceMsg.getResultCode());
            if ((paramFromServiceMsg.getResultCode() != 1002) || (i >= 2)) {
              break label324;
            }
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonHandler", 2, "try index: " + i);
            }
            paramToServiceMsg.extraData.putInt("EmoticonRetry", i + 1);
            super.b(paramToServiceMsg);
            return;
          }
          if (!QLog.isColorLevel()) {
            break label324;
          }
          QLog.d("EmoticonHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
          return;
          paramToServiceMsg = (ToServiceMsg)paramObject;
        }
        paramToServiceMsg = (ToServiceMsg)localObject1;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "ReportAddEmoticonPkg, pkgId=" + paramString);
    }
    Object localObject = new EmosmPb.SubCmd0x8ReqAddTab();
    ((EmosmPb.SubCmd0x8ReqAddTab)localObject).uint32_tab_id.set(Integer.parseInt(paramString));
    paramString = new EmosmPb.ReqBody();
    paramString.uint32_sub_cmd.set(8);
    paramString.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    paramString.int32_plat_id.set(109);
    paramString.str_app_version.set("6.5.5");
    paramString.msg_subcmd0x8_req_addtab.set((MessageMicro)localObject);
    paramString.setHasFlag(true);
    localObject = a("BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 8);
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    super.b((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(9);
    EmosmPb.SubCmd0x9BqAssocReq localSubCmd0x9BqAssocReq = new EmosmPb.SubCmd0x9BqAssocReq();
    localSubCmd0x9BqAssocReq.str_key_word.set(paramString);
    localSubCmd0x9BqAssocReq.rpt_str_bq_item_id.set(paramArrayList);
    localReqBody.msg_subcmd0x9_req.set(localSubCmd0x9BqAssocReq);
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
    paramString.extraData.putInt("EmosmSubCmd", 9);
    paramString.putWupBuffer(localReqBody.toByteArray());
    super.b(paramString);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    Object localObject = new EmosmPb.SubCmd0x1ReqDelTab();
    ((EmosmPb.SubCmd0x1ReqDelTab)localObject).rpt_tab_id.addAll(paramArrayList);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.msg_subcmd0x1_req_deltab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", -1);
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 17);
    ((ToServiceMsg)localObject).extraData.putIntegerArrayList("EmosmPackageIds", paramArrayList);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.b((ToServiceMsg)localObject);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "reportEmoticonOrder, localList=" + paramList + ", shouldReverse=" + paramBoolean);
    }
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "reportEmoticonOrder, localList null, abort");
      }
      return;
    }
    Object localObject = new EmosmPb.SubCmd0x10MoveOrderReq();
    ArrayList localArrayList = new ArrayList(paramList.size());
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        i = paramList.size() - 1;
        if (i < 0) {
          continue;
        }
        str = (String)paramList.get(i);
        if (TextUtils.isEmpty(str)) {
          break label352;
        }
        localArrayList.add(Integer.valueOf(Integer.parseInt(str)));
      }
      catch (Exception paramList)
      {
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EmoticonHandler", 2, "reportEmoticonOrder, error=" + MsfSdkUtils.getStackTraceString(paramList));
        ((EmosmPb.SubCmd0x10MoveOrderReq)localObject).uint32_tab_id.set(localArrayList);
        paramList = new EmosmPb.ReqBody();
        paramList.uint32_sub_cmd.set(16);
        paramList.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
        paramList.int32_plat_id.set(109);
        paramList.str_app_version.set("6.5.5");
        paramList.msg_subcmd0x10_req.set((MessageMicro)localObject);
        paramList.setHasFlag(true);
        localObject = a("BQMallSvc.TabOpReq");
        ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 16);
        ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
        super.b((ToServiceMsg)localObject);
        return;
      }
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        str = (String)paramList.next();
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(Integer.valueOf(Integer.parseInt(str)));
        }
      }
      else
      {
        label352:
        i -= 1;
      }
    }
  }
  
  public void b()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(92);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_92");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    super.b((ToServiceMsg)localObject);
  }
  
  public void b(EmojiManager.SyncFetchEmoticonKeyObserver paramSyncFetchEmoticonKeyObserver)
  {
    if ((paramSyncFetchEmoticonKeyObserver != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramSyncFetchEmoticonKeyObserver))) {
      this.jdField_a_of_type_JavaUtilList.remove(paramSyncFetchEmoticonKeyObserver);
    }
  }
  
  public void c()
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(19);
    localReqBody.str_app_version.set("6.5.5");
    Object localObject1 = ((CommonUsedSystemEmojiManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(171)).b();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest list is null");
      }
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        if ((localObject1 == null) || (((List)localObject1).size() <= 1)) {
          break label372;
        }
        localObject2 = new StringBuilder();
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject1).get(i);
          if (localSmallYellowItem != null) {
            ((StringBuilder)localObject2).append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
          }
          i += 1;
        }
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest item " + ((StringBuilder)localObject2).toString());
      }
      for (;;)
      {
        localObject2 = new EmosmPb.SubCmd0x13Req();
        ((EmosmPb.SubCmd0x13Req)localObject2).itemlist.set((List)localObject1);
        localReqBody.msg_subcmd0x13_req.set((MessageMicro)localObject2);
        localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
        ((ToServiceMsg)localObject1).extraData.putInt("EmosmSubCmd", 20);
        ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
        super.b((ToServiceMsg)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest called.");
        }
        return;
        label372:
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest infos = null");
      }
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\EmoticonHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */