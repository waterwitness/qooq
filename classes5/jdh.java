import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.apiproxy.QQMusicService;
import com.tencent.biz.pubaccount.util.PAH5Manager;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.data.DingdongOfficeOpenService;
import cooperation.troop.TroopPluginManager;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class jdh
  extends Handler
{
  public jdh(TroopMemberApiService paramTroopMemberApiService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject4 = TroopMemberApiService.c(this.a);
    if ((localObject4 instanceof QQAppInterface))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)((QQAppInterface)localObject4).a(22));
      this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)((QQAppInterface)localObject4).a(3));
      this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)((QQAppInterface)localObject4).a(20));
    }
    if ((paramMessage == null) || (localObject4 == null) || (!(localObject4 instanceof QQAppInterface))) {}
    Object localObject3;
    do
    {
      return;
      localObject3 = paramMessage.getData();
    } while (localObject3 == null);
    Object localObject1;
    boolean bool;
    Object localObject5;
    long l1;
    long l2;
    int i;
    int j;
    Object localObject6;
    Object localObject7;
    switch (paramMessage.what)
    {
    case 3: 
    case 10: 
    case 14: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 32: 
    case 39: 
    case 42: 
    case 49: 
    case 56: 
    default: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 33: 
    case 40: 
    case 37: 
    case 34: 
    case 35: 
    case 36: 
    case 9: 
    case 11: 
    case 12: 
    case 38: 
    case 13: 
    case 28: 
    case 60: 
    case 29: 
    case 30: 
    case 15: 
    case 16: 
    case 18: 
    case 17: 
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        this.a.b = paramMessage.replyTo;
        if (paramMessage.obj != null)
        {
          localObject1 = ((Bundle)paramMessage.obj).getString("processName");
          if (localObject1 != null)
          {
            this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, paramMessage.replyTo);
            continue;
            this.a.b = null;
            if (paramMessage.obj != null)
            {
              localObject1 = ((Bundle)paramMessage.obj).getString("processName");
              if (localObject1 != null)
              {
                this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
                continue;
                localObject1 = new Bundle();
                ((Bundle)localObject1).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
                localObject3 = ((Bundle)localObject3).getString("video_url");
                if ((localObject4 instanceof QQAppInterface))
                {
                  localObject4 = (TroopInfoManager)((QQAppInterface)localObject4).getManager(36);
                  if (localObject4 == null)
                  {
                    ((Bundle)localObject1).putBoolean("ret", false);
                    this.a.a(4, (Bundle)localObject1);
                  }
                  else if (((TroopInfoManager)localObject4).a())
                  {
                    new jdi(this, (TroopInfoManager)localObject4, (Bundle)localObject1, (String)localObject3).execute(new Void[0]);
                  }
                  else
                  {
                    if ((((TroopInfoManager)localObject4).b((String)localObject3)) && (((TroopInfoManager)localObject4).b())) {}
                    for (bool = true;; bool = false)
                    {
                      ((Bundle)localObject1).putBoolean("ret", bool);
                      this.a.a(4, (Bundle)localObject1);
                      break;
                    }
                  }
                }
                else
                {
                  ((Bundle)localObject1).putBoolean("ret", false);
                  this.a.a(4, (Bundle)localObject1);
                  continue;
                  if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler != null)
                  {
                    this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.b(((Bundle)localObject3).getString("video_url"));
                    continue;
                    this.a.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(((AppRuntime)localObject4).getAccount());
                    continue;
                    localObject1 = ((Bundle)localObject3).getString("gcode");
                    localObject3 = ((Bundle)localObject3).getString("anId");
                    localObject5 = AnonymousChatHelper.a().a((String)localObject1, (String)localObject3);
                    if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
                    {
                      this.a.a((String)localObject1, (String)localObject3, ((AppRuntime)localObject4).getAccount(), (String)localObject5);
                      if (QLog.isDevelopLevel())
                      {
                        QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
                        continue;
                        this.a.a().a((AppRuntime)localObject4, (Bundle)localObject3);
                        continue;
                        localObject1 = ((Bundle)localObject3).getString("troopUin");
                        if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
                        {
                          this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b((String)localObject1);
                          continue;
                          localObject1 = ((Bundle)localObject3).getString("troopUin");
                          localObject3 = ((Bundle)localObject3).getString("troopCode");
                          if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {
                            this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(true, (String)localObject1, (String)localObject3, 0);
                          }
                          if (QLog.isColorLevel())
                          {
                            QLog.d(TroopMemberApiService.a(), 2, "MSG_ON_GET_TROOP_MEM_LIST troopuin: " + (String)localObject3);
                            continue;
                            l1 = ((Bundle)localObject3).getLong("dwGroupCode");
                            l2 = ((Bundle)localObject3).getLong("cGroupOption");
                            long l3 = ((Bundle)localObject3).getLong("dwGroupClass");
                            localObject1 = ((Bundle)localObject3).getString("strGroupName");
                            i = ((Bundle)localObject3).getInt("wGroupFace");
                            localObject4 = ((Bundle)localObject3).getString("strGroupMemo");
                            localObject5 = ((Bundle)localObject3).getString("strFingerMemo");
                            j = ((Bundle)localObject3).getInt("nFlag");
                            if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
                            {
                              this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, l2, l3, (String)localObject1, i, (String)localObject4, (String)localObject5, j);
                              continue;
                              localObject1 = ((Bundle)localObject3).getString("troopUin");
                              if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
                              {
                                this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.l((String)localObject1);
                                continue;
                                localObject1 = ((Bundle)localObject3).getString("troopUin");
                                bool = ((Bundle)localObject3).getBoolean("isChecked");
                                if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler != null)
                                {
                                  this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.a((String)localObject1, bool);
                                  continue;
                                  localObject1 = ((Bundle)localObject3).getString("troopUin");
                                  byte b = ((Bundle)localObject3).getByte("cIsGetGroupAlbum");
                                  l1 = ((Bundle)localObject3).getLong("dwTimeStamp");
                                  i = ((Bundle)localObject3).getInt("cStatOption");
                                  if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
                                  {
                                    this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a((String)localObject1, Byte.valueOf(b).byteValue(), l1, i);
                                    continue;
                                    if (this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null)
                                    {
                                      localObject1 = ((Bundle)localObject3).getString("methord_name");
                                      int k;
                                      int m;
                                      if ("getGroupInArea".equals(localObject1))
                                      {
                                        localObject1 = ((Bundle)localObject3).getString("areaName");
                                        i = ((Bundle)localObject3).getInt("lat");
                                        j = ((Bundle)localObject3).getInt("lon");
                                        k = ((Bundle)localObject3).getInt("startIndex");
                                        m = ((Bundle)localObject3).getInt("count");
                                        int n = ((Bundle)localObject3).getInt("iFilterId");
                                        this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a((String)localObject1, i, j, k, m, n);
                                      }
                                      else if ("getNearbyTroops".equals(localObject1))
                                      {
                                        bool = ((Bundle)localObject3).getBoolean("isFirst");
                                        i = ((Bundle)localObject3).getInt("lat");
                                        j = ((Bundle)localObject3).getInt("lon");
                                        k = ((Bundle)localObject3).getInt("sortType");
                                        localObject1 = ((Bundle)localObject3).getString("strGroupArea");
                                        m = ((Bundle)localObject3).getInt("iFilterId");
                                        this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(bool, i, j, k, (String)localObject1, m);
                                      }
                                      else if ("getAreaList".equals(localObject1))
                                      {
                                        i = ((Bundle)localObject3).getInt("lat");
                                        j = ((Bundle)localObject3).getInt("lon");
                                        k = ((Bundle)localObject3).getInt("radius");
                                        bool = ((Bundle)localObject3).getBoolean("isClickable");
                                        this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(i, j, k, bool);
                                        continue;
                                        localObject1 = new Bundle();
                                        ((Bundle)localObject1).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
                                        localObject3 = ((Bundle)localObject3).getStringArray("paths");
                                        if (((localObject4 instanceof QQAppInterface)) && (localObject3 != null) && (localObject3.length > 0))
                                        {
                                          localObject4 = (RedTouchManager)((AppRuntime)localObject4).getManager(35);
                                          if (localObject4 != null)
                                          {
                                            localObject5 = new int[localObject3.length];
                                            localObject6 = new int[localObject3.length];
                                            i = 0;
                                            if (i < localObject6.length)
                                            {
                                              localObject7 = ((RedTouchManager)localObject4).a(localObject3[i]);
                                              if (localObject7 != null)
                                              {
                                                localObject5[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject7).iNewFlag.get();
                                                localObject6[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject7).type.get();
                                              }
                                              for (;;)
                                              {
                                                i += 1;
                                                break;
                                                localObject5[i] = 0;
                                                localObject6[i] = -1;
                                              }
                                            }
                                            ((Bundle)localObject1).putIntArray("iNewFlags", (int[])localObject5);
                                            ((Bundle)localObject1).putIntArray("types", (int[])localObject6);
                                          }
                                        }
                                        this.a.a(11, (Bundle)localObject1);
                                        continue;
                                        new Bundle().putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
                                        localObject1 = ((Bundle)localObject3).getString("path");
                                        if ((localObject4 instanceof QQAppInterface))
                                        {
                                          localObject3 = (RedTouchManager)((AppRuntime)localObject4).getManager(35);
                                          if (localObject3 != null)
                                          {
                                            ((RedTouchManager)localObject3).b((String)localObject1);
                                            continue;
                                            localObject1 = ((Bundle)localObject3).getString("troopUin");
                                            localObject3 = ((Bundle)localObject3).getString("processName");
                                            localObject4 = (TroopHandler)((QQAppInterface)localObject4).a(20);
                                            if (localObject4 != null)
                                            {
                                              ((TroopHandler)localObject4).b((String)localObject1, (String)localObject3);
                                              continue;
                                              localObject1 = new Bundle();
                                              ((Bundle)localObject1).putString("method", "changeAnonymousNick");
                                              ((Bundle)localObject1).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
                                              localObject4 = ((Bundle)localObject3).getString("troopUin");
                                              l1 = ((Bundle)localObject3).getLong("bubbleId");
                                              i = ((Bundle)localObject3).getInt("headId");
                                              localObject5 = ((Bundle)localObject3).getString("nickName");
                                              j = ((Bundle)localObject3).getInt("expireTime");
                                              if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                                              {
                                                AnonymousChatHelper.a().a((String)localObject4, l1, i, (String)localObject5, j, "");
                                                ((Bundle)localObject1).putBoolean("result", true);
                                              }
                                              for (;;)
                                              {
                                                this.a.a(13, (Bundle)localObject1);
                                                break;
                                                ((Bundle)localObject1).putBoolean("result", false);
                                              }
                                              localObject1 = (TroopHandler)((QQAppInterface)localObject4).a(20);
                                              i = ((Bundle)localObject3).getInt("appid");
                                              localObject4 = ((Bundle)localObject3).getString("token");
                                              ((TroopHandler)localObject1).a(i, ((Bundle)localObject3).getString("openGroupId"), (String)localObject4, ((Bundle)localObject3).getString("url"), ((Bundle)localObject3).getInt("seq"));
                                              continue;
                                              localObject1 = (TroopHandler)((QQAppInterface)localObject4).a(20);
                                              i = ((Bundle)localObject3).getInt("appid");
                                              localObject4 = ((Bundle)localObject3).getString("token");
                                              ((TroopHandler)localObject1).a(i, ((Bundle)localObject3).getString("openId"), (String)localObject4, ((Bundle)localObject3).getInt("seq"));
                                              continue;
                                              bool = ((Bundle)localObject3).getBoolean("isTroopAppListChanged");
                                              localObject1 = (TroopAppMgr)((AppRuntime)localObject4).getManager(108);
                                              if (localObject1 != null)
                                              {
                                                ((TroopAppMgr)localObject1).b(bool);
                                                continue;
                                                localObject5 = ((Bundle)localObject3).getString("troopUin");
                                                localObject1 = ((Bundle)localObject3).getString("opn");
                                                if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5))) {
                                                  if (((String)localObject1).equals("g_homework"))
                                                  {
                                                    l1 = Long.parseLong((String)localObject5);
                                                    localObject1 = "";
                                                    if (TroopFileUtils.a((QQAppInterface)localObject4, l1)) {
                                                      localObject1 = "role=teacher&";
                                                    }
                                                    localObject3 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
                                                    ((Intent)localObject3).putExtra("url", "http://qun.qq.com/homework/features/index.html?_wv=1027&_bid=2146#" + (String)localObject1 + "gid=" + (String)localObject5 + "&src=0");
                                                    ((Intent)localObject3).setFlags(268435456);
                                                    this.a.startActivity((Intent)localObject3);
                                                  }
                                                  else if (((String)localObject1).equals("g_troop_reward"))
                                                  {
                                                    TroopRewardMgr.a((QQAppInterface)localObject4, this.a, (String)localObject5, true);
                                                    continue;
                                                    this.a.a((Bundle)localObject3);
                                                    continue;
                                                    if (!TroopMemberApiService.a((AppRuntime)localObject4, new jdj(this, (Bundle)localObject3)))
                                                    {
                                                      this.a.a(16, (Bundle)localObject3);
                                                      continue;
                                                      l1 = ((Bundle)localObject3).getLong("uiResId");
                                                      localObject1 = LebaShowListManager.a().a(l1);
                                                      if ((localObject1 != null) && (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null))
                                                      {
                                                        ((Bundle)localObject3).putString("packageName", ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
                                                        ((Bundle)localObject3).putString("imageUrl", ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL);
                                                        ((Bundle)localObject3).putString("name", ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
                                                        if (((LebaViewItem)localObject1).jdField_a_of_type_Byte == 0)
                                                        {
                                                          bool = true;
                                                          ((Bundle)localObject3).putBoolean("isOpen", bool);
                                                          ((Bundle)localObject3).putInt("type", ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.lebaSearchResultType);
                                                          ((Bundle)localObject3).putBoolean("has", true);
                                                        }
                                                      }
                                                      for (;;)
                                                      {
                                                        this.a.a(18, (Bundle)localObject3);
                                                        break;
                                                        bool = false;
                                                        break label2381;
                                                        ((Bundle)localObject3).putBoolean("has", false);
                                                      }
                                                      LebaShowListManager.d |= 0x1;
                                                      bool = ((Bundle)localObject3).getBoolean("isChecked");
                                                      l1 = ((Bundle)localObject3).getLong("uiResId");
                                                      ((Bundle)localObject3).putBoolean("result", TroopMemberApiService.a(this.a, l1, bool));
                                                      this.a.a(17, (Bundle)localObject3);
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    case 19: 
      label2381:
      localObject5 = ((Bundle)localObject3).getString("troopUin");
      localObject7 = ((Bundle)localObject3).getString("troopName");
      i = ((Bundle)localObject3).getInt("troopTypeId");
      localObject6 = (TroopManager)((AppRuntime)localObject4).getManager(51);
      if (localObject6 != null)
      {
        localObject1 = ((TroopManager)localObject6).a((String)localObject5);
        if (localObject1 == null)
        {
          localObject1 = new TroopInfo();
          ((TroopInfo)localObject1).troopuin = ((String)localObject5);
          ((TroopInfo)localObject1).troopname = ((String)localObject7);
          ((TroopInfo)localObject1).Administrator = ((QQAppInterface)localObject4).a();
          ((TroopInfo)localObject1).dwAdditionalFlag = 1L;
          ((TroopManager)localObject6).b((TroopInfo)localObject1);
        }
      }
      break;
    }
    for (;;)
    {
      localObject7 = (TroopHandler)((QQAppInterface)localObject4).a(20);
      if (localObject7 != null) {
        ((TroopHandler)localObject7).a((String)localObject5, (byte)0, 0L, -1);
      }
      if (i == 32L) {
        HWTroopUtils.b((QQAppInterface)localObject4, (String)localObject5);
      }
      for (;;)
      {
        if ((localObject6 != null) && (localObject1 != null)) {
          ((TroopManager)localObject6).d((TroopInfo)localObject1);
        }
        if (!(localObject4 instanceof QQAppInterface)) {
          break;
        }
        this.a.a(19, (Bundle)localObject3);
        break;
        localObject7 = (TroopCreateLogic)((AppRuntime)localObject4).getManager(31);
        if (localObject7 != null) {
          ((TroopCreateLogic)localObject7).a((QQAppInterface)localObject4, (String)localObject5);
        }
      }
      if ((!(localObject4 instanceof QQAppInterface)) || (localObject3 == null)) {
        break;
      }
      l1 = ((Bundle)localObject3).getLong("troopCode");
      localObject1 = ((Bundle)localObject3).getString("filePath");
      localObject5 = ((Bundle)localObject3).getString("fileName");
      l2 = ((Bundle)localObject3).getLong("fileSize");
      i = ((Bundle)localObject3).getInt("busid");
      localObject1 = TroopFileUtils.a((QQAppInterface)localObject4, l1, null, (String)localObject1, (String)localObject5, l2, i);
      localObject5 = new Bundle();
      ((Bundle)localObject5).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
      if (!TextUtils.isEmpty(((Bundle)localObject3).getString("callback"))) {
        ((Bundle)localObject5).putString("callback", ((Bundle)localObject3).getString("callback"));
      }
      ((Bundle)localObject5).putString("method", "getFileInfo");
      TroopMemberApiService.a(this.a, (QQAppInterface)localObject4, l1, HWTroopFileStatusInfo.parse((TroopFileStatusInfo)localObject1), (Bundle)localObject5);
      break;
      if ((!(localObject4 instanceof QQAppInterface)) || (localObject3 == null)) {
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager == null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager = new PAH5Manager(this.a, (QQAppInterface)localObject4);
      }
      if (((Bundle)localObject3).getBoolean("is_pic_or_voice"))
      {
        this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.a((Bundle)localObject3);
        break;
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.c((Bundle)localObject3);
      break;
      if ((!(localObject4 instanceof QQAppInterface)) || (localObject3 == null)) {
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager == null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager = new PAH5Manager(this.a, (QQAppInterface)localObject4);
      }
      if (((Bundle)localObject3).getBoolean("is_pic_or_voice"))
      {
        this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.b((Bundle)localObject3);
        break;
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.d((Bundle)localObject3);
      break;
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.a();
      break;
      this.a.an = ((Bundle)localObject3).getInt("appId");
      this.a.ap = ((Bundle)localObject3).getInt("seq");
      if (this.a.an == 0) {
        break;
      }
      localObject1 = (TroopAppMgr)((AppRuntime)localObject4).getManager(108);
      if (localObject1 == null) {
        break;
      }
      localObject3 = new ArrayList();
      if ((((TroopAppMgr)localObject1).a()) && (!((TroopAppMgr)localObject1).b()))
      {
        localObject4 = ((TroopAppMgr)localObject1).a(false);
        if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
        {
          localObject4 = ((List)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (TroopAIOAppInfo)((Iterator)localObject4).next();
            ((ArrayList)localObject3).add(Integer.valueOf(((TroopAIOAppInfo)localObject5).appid));
            if (((TroopAIOAppInfo)localObject5).appid == this.a.an)
            {
              QQToast.a(BaseApplication.getContext(), 2, 2131367459, 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
              return;
            }
          }
        }
        ((ArrayList)localObject3).add(Integer.valueOf(this.a.an));
        localObject4 = new ArrayList();
        ((ArrayList)localObject4).add(Integer.valueOf(this.a.an));
        ((TroopAppMgr)localObject1).a((ArrayList)localObject3, (ArrayList)localObject4);
        break;
      }
      this.a.jdField_a_of_type_Boolean = true;
      ((TroopAppMgr)localObject1).a(true);
      break;
      l1 = ((Bundle)localObject3).getLong("roomid", 0L);
      localObject1 = ((Bundle)localObject3).getString("roomname");
      localObject5 = ((Bundle)localObject3).getString("userdata");
      localObject6 = ((Bundle)localObject3).getString("vasname");
      i = ((Bundle)localObject3).getInt("fromid", 0);
      ((ODProxy)((QQAppInterface)localObject4).getManager(107)).a(this.a, l1, (String)localObject1, (String)localObject6, (String)localObject5, i);
      break;
      try
      {
        l1 = ((Bundle)localObject3).getLong("troopPubAccountUin");
        localObject1 = ((Bundle)localObject3).getLongArray("troopUinList");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break;
        }
        localObject3 = (TroopManager)((AppRuntime)localObject4).getManager(51);
        i = 0;
        while (i < localObject1.length)
        {
          localObject4 = ((TroopManager)localObject3).a(localObject1[i] + "");
          if (localObject4 != null) {
            ((TroopInfo)localObject4).associatePubAccount = l1;
          }
          ((TroopManager)localObject3).b((TroopInfo)localObject4);
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception localException) {}
      QLog.e("AccountDetailActivity.bindTroop", 2, "updateTroopBindedPubAccount:" + localException.toString());
      break;
      Object localObject2 = ((Bundle)localObject3).getString("troopUin");
      localObject3 = (TroopManager)((AppRuntime)localObject4).getManager(51);
      if (localObject3 == null) {
        break;
      }
      localObject2 = ((TroopManager)localObject3).a((String)localObject2);
      if (localObject2 == null) {
        break;
      }
      ((TroopInfo)localObject2).troopPrivilegeFlag |= 0x800;
      ((TroopManager)localObject3).b((TroopInfo)localObject2);
      break;
      localObject2 = ((Bundle)localObject3).getString("troopUin");
      localObject4 = (TroopManager)((AppRuntime)localObject4).getManager(51);
      if (localObject4 != null)
      {
        localObject2 = ((TroopManager)localObject4).a((String)localObject2);
        if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
          bool = true;
        }
      }
      for (;;)
      {
        ((Bundle)localObject3).putBoolean("hasOrgs", bool);
        this.a.a(45, (Bundle)localObject3);
        break;
        bool = false;
        continue;
        localObject2 = ((Bundle)localObject3).getString("localFilePath");
        localObject3 = ((Bundle)localObject3).getString("fileDisPlayName");
        HWTroopUtils.a(this.a, (String)localObject2, (String)localObject3);
        break;
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        i = ((Bundle)localObject3).getInt("rewardMoney");
        localObject5 = ((Bundle)localObject3).getString("rewardContent");
        localObject6 = ((Bundle)localObject3).getString("mediaPath");
        j = ((Bundle)localObject3).getInt("rewardType");
        TroopRewardMgr.c = ((Bundle)localObject3).getInt("imageMaxWidthPixels", 1080);
        TroopRewardMgr.d = ((Bundle)localObject3).getInt("imageMaxHeightPixels", 1920);
        ((TroopRewardMgr)((AppRuntime)localObject4).getManager(151)).a((String)localObject2, i, (String)localObject5, (String)localObject6, j);
        break;
        this.a.a((QQAppInterface)localObject4).a((Bundle)localObject3);
        break;
        if (this.a.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService == null) {
          break;
        }
        this.a.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService.a();
        this.a.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService = null;
        break;
        l1 = ((Bundle)localObject3).getLong("troopUin");
        i = ((Bundle)localObject3).getInt("flag");
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, i);
        break;
        localObject2 = (QQAppInterface)localObject4;
        ((Bundle)localObject3).putInt("fontSize", QQAppInterface.cu);
        this.a.a(51, (Bundle)localObject3);
        break;
        localObject2 = (QQAppInterface)localObject4;
        QQAppInterface.cu = ((Bundle)localObject3).getInt("fontSize", 1);
        break;
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        localObject5 = ((Bundle)localObject3).getString("rewardId");
        localObject4 = ((TroopRewardMgr)((AppRuntime)localObject4).getManager(151)).a((String)localObject2, (String)localObject5);
        localObject2 = "";
        if (localObject4 != null) {
          localObject2 = ((MessageForTroopReward)localObject4).mediaPath;
        }
        ((Bundle)localObject3).putString("videoPath", (String)localObject2);
        this.a.a(54, (Bundle)localObject3);
        break;
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        localObject5 = ((Bundle)localObject3).getString("largeImageFile");
        localObject6 = ((Bundle)localObject3).getString("fileName");
        l1 = ((Bundle)localObject3).getLong("progressTotal");
        i = ((Bundle)localObject3).getInt("busId");
        TroopFileTransferManager.a((QQAppInterface)localObject4, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, l1, i);
        break;
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        localObject5 = ((Bundle)localObject3).getString("filePath");
        localObject6 = ((Bundle)localObject3).getString("fileName");
        i = ((Bundle)localObject3).getInt("busId");
        TroopFileTransferManager.a((QQAppInterface)localObject4, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, i, 128);
        break;
        localObject2 = (TroopPluginManager)((AppRuntime)localObject4).getManager(118);
        localObject4 = ((Bundle)localObject3).getString("troopUin");
        i = ((Bundle)localObject3).getInt("seq");
        localObject3 = ((Bundle)localObject3).getString("processName");
        if (localObject2 == null) {
          break;
        }
        ((TroopPluginManager)localObject2).a("troop_manage_plugin.apk", new jdk(this, (String)localObject4, i, (String)localObject3));
        break;
        localObject5 = (TroopTopicMgr)((AppRuntime)localObject4).getManager(97);
        i = ((Bundle)localObject3).getInt("seq");
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        l1 = ((Bundle)localObject3).getLong("msgseq");
        j = ((Bundle)localObject3).getInt("reqType");
        String str1 = ((Bundle)localObject3).getString("comment");
        if (!(localObject4 instanceof QQAppInterface)) {
          break;
        }
        localObject4 = (QQAppInterface)localObject4;
        localObject3 = ReplyTextItemBuilder.a((QQAppInterface)localObject4, (String)localObject2, 1, l1);
        if (localObject3 != null)
        {
          if (j == 0)
          {
            if (AnonymousChatHelper.a().a((String)localObject2)) {
              break;
            }
            ((TroopTopicMgr)localObject5).a((ChatMessage)localObject3, 2, new jdl(this, j, i));
            break;
          }
          if ((localObject3 == null) || (!(localObject3 instanceof MessageForStructing))) {
            break;
          }
          MessageForStructing localMessageForStructing = (MessageForStructing)localObject3;
          localObject6 = new ChatActivityFacade.SendMsgParams();
          ((ChatActivityFacade.SendMsgParams)localObject6).a = new MessageForReplyText.SourceMsgInfo();
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgSenderUin = Long.parseLong(localMessageForStructing.senderuin);
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgSeq = localMessageForStructing.shmsgseq;
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgTime = ((int)localMessageForStructing.time);
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceSummaryFlag = 1;
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mType = 1;
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText = localMessageForStructing.structingMsg.mMsgBrief;
          if ((!TextUtils.isEmpty(((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText)) && (((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText.length() > BaseChatPie.y))
          {
            ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText = ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText.substring(0, BaseChatPie.y);
            ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceSummaryFlag = 0;
          }
          String str3 = ContactUtils.e((QQAppInterface)localObject4, ((MessageRecord)localObject3).frienduin, localMessageForStructing.senderuin);
          String str2 = TroopTopicMgr.a((MessageRecord)localObject3);
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mRichMsg = str2;
          localObject7 = new ArrayList();
          MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
          localAtTroopMemberInfo.startPos = 0;
          localAtTroopMemberInfo.textLen = ((short)(str3.length() + 1));
          localAtTroopMemberInfo.uin = Long.parseLong(localMessageForStructing.senderuin);
          ((ArrayList)localObject7).add(localAtTroopMemberInfo);
          str1 = "@" + str3 + " " + str1;
          if (!AnonymousChatHelper.a().a((String)localObject2)) {
            ((TroopTopicMgr)localObject5).a(TroopTopicMgr.a((QQAppInterface)localObject4, (String)localObject2, (ChatActivityFacade.SendMsgParams)localObject6, str1, 3), localMessageForStructing.shmsgseq, str1, str2, (ArrayList)localObject7, Long.parseLong(((MessageRecord)localObject3).frienduin) + 10000000000L, "0", null, 2, new jdm(this, j, i));
          }
          while (QLog.isColorLevel())
          {
            QLog.d("com.tencent.biz.troop.TroopMemberApiService", 2, "commend: 评论ok, send uniseq = " + ((MessageRecord)localObject3).shmsgseq + ", msg = " + str1);
            break;
            ((ChatActivityFacade.SendMsgParams)localObject6).a.mType = 0;
            localObject5 = new SessionInfo();
            ((SessionInfo)localObject5).jdField_a_of_type_Int = 1;
            ((SessionInfo)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((SessionInfo)localObject5).b = ((String)localObject2);
            ((SessionInfo)localObject5).c = 0;
            ChatActivityFacade.a((QQAppInterface)localObject4, BaseApplication.getContext(), (SessionInfo)localObject5, str1, (ArrayList)localObject7, (ChatActivityFacade.SendMsgParams)localObject6);
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("reqType", j);
            ((Bundle)localObject2).putInt("seq", i);
            ((Bundle)localObject2).putInt("errorCode", 0);
            this.a.a(59, (Bundle)localObject2);
          }
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("reqType", j);
        ((Bundle)localObject2).putInt("seq", i);
        ((Bundle)localObject2).putInt("errorCode", -1);
        this.a.a(59, (Bundle)localObject2);
        break;
        localObject2 = ((Bundle)localObject3).getString("uin");
        localObject3 = (PublicAccountDataManager)((AppRuntime)localObject4).getManager(55);
        if (localObject3 == null) {
          break;
        }
        ((PublicAccountDataManager)localObject3).a((String)localObject2, NetConnInfoCenter.getServerTimeMillis());
        break;
        localObject2 = ((Bundle)localObject3).getString("appid");
        localObject3 = ((Bundle)localObject3).getString("pkgname");
        this.a.a((String)localObject3, (String)localObject2);
        break;
        bool = false;
      }
      continue;
      localObject2 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */