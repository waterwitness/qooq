package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.hotchat.HCSeatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class HotChatInfo
  extends Entity
  implements Serializable, Cloneable
{
  public static final int RU_STATE_DELETED = 1;
  public static final int RU_STATE_NORMAL = 0;
  public static final int STATE_HOT_CHAT_IS_DISBANDED = 7;
  public static final int STATE_JOINED = 0;
  public static final int STATE_KICK_OUT = 6;
  public static final int STATE_LEFT_NORMAL = 4;
  public static final int STATE_LEFT__LONG_TIME_NOT_SAY = 1;
  public static final int STATE_LEFT__LONG_WAY_TO_GO = 3;
  public static final int STATE_SHELL = 5;
  public static final int SUB_TYPE_PTT = 1;
  private static final long serialVersionUID = 4511795799007124151L;
  public int adminLevel;
  @notColumn
  public List adminUins;
  public String detail;
  public String extra1;
  public int faceId;
  public boolean hasJoined;
  public int hotChatType;
  public int hotThemeGroupFlag;
  public String iconUrl;
  public boolean isFavorite;
  public boolean isWifiHotChat;
  public String joinUrl;
  public long lLastMsgSeq;
  public long leftTime;
  public int mFissionRoomNum;
  @notColumn
  private List mSeatsList;
  public int memberCount;
  public String memo;
  public boolean memoShowed;
  public String memoUrl;
  public String name;
  public String ownerUin;
  public int pkFlag;
  public long praiseCount;
  public int ruState;
  public String signature;
  public int state;
  public String strAdminUins;
  public int subType;
  public boolean supportDemo;
  public boolean supportFlashPic;
  public String troopCode;
  @unique
  public String troopUin;
  public int userCreate;
  public String uuid;
  
  public HotChatInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.state = 4;
    this.ruState = 0;
    this.adminUins = new ArrayList();
  }
  
  public static HotChatInfo createHotChat(JSONObject paramJSONObject)
  {
    HotChatInfo localHotChatInfo = new HotChatInfo();
    localHotChatInfo.faceId = paramJSONObject.getInt("face_id");
    localHotChatInfo.memberCount = paramJSONObject.getInt("visitor_num");
    localHotChatInfo.troopUin = paramJSONObject.getString("group_code");
    localHotChatInfo.troopCode = paramJSONObject.getString("group_uin");
    if (paramJSONObject.getInt("wifi_poi_type") == 1)
    {
      bool = true;
      localHotChatInfo.isWifiHotChat = bool;
      localHotChatInfo.name = paramJSONObject.getString("name");
      localHotChatInfo.signature = paramJSONObject.getString("sig");
      if (paramJSONObject.getInt("is_member") <= 0) {
        break label201;
      }
    }
    label201:
    for (boolean bool = true;; bool = false)
    {
      localHotChatInfo.hasJoined = bool;
      localHotChatInfo.uuid = paramJSONObject.getString("uid");
      localHotChatInfo.iconUrl = paramJSONObject.getString("face_url");
      localHotChatInfo.hotThemeGroupFlag = paramJSONObject.getInt("hot_theme_group_flag");
      localHotChatInfo.supportFlashPic = false;
      localHotChatInfo.supportDemo = false;
      localHotChatInfo.ownerUin = "";
      localHotChatInfo.pkFlag = 0;
      localHotChatInfo.subType = 0;
      localHotChatInfo.lLastMsgSeq = 0L;
      localHotChatInfo.extra1 = "";
      localHotChatInfo.mSeatsList = null;
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "createHotChat_JSONObject", new Object[] { localHotChatInfo });
      }
      return localHotChatInfo;
      bool = false;
      break;
    }
  }
  
  public static HotChatInfo createHotChat(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean)
  {
    return createHotChat(paramWifiPOIInfo, paramBoolean, 0);
  }
  
  public static HotChatInfo createHotChat(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt)
  {
    long l = 0L;
    HotChatInfo localHotChatInfo = new HotChatInfo();
    localHotChatInfo.faceId = paramWifiPOIInfo.uint32_face_id.get();
    localHotChatInfo.memberCount = paramWifiPOIInfo.uint32_visitor_num.get();
    localHotChatInfo.troopUin = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_code.get()));
    localHotChatInfo.troopCode = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_uin.get()));
    localHotChatInfo.isWifiHotChat = paramBoolean;
    localHotChatInfo.name = paramWifiPOIInfo.bytes_name.get().toStringUtf8();
    localHotChatInfo.signature = paramWifiPOIInfo.bytes_sig.get().toStringUtf8();
    if (paramWifiPOIInfo.uint32_is_member.get() > 0)
    {
      paramBoolean = true;
      localHotChatInfo.hasJoined = paramBoolean;
      localHotChatInfo.uuid = paramWifiPOIInfo.bytes_uid.get().toStringUtf8();
      localHotChatInfo.iconUrl = paramWifiPOIInfo.face_url.get();
      localHotChatInfo.hotThemeGroupFlag = paramWifiPOIInfo.hot_theme_group_flag.get();
      if ((paramWifiPOIInfo.uint32_special_flag.get() & 0x1) == 0) {
        break label393;
      }
      paramBoolean = true;
      label167:
      localHotChatInfo.supportFlashPic = paramBoolean;
      if ((paramInt & 0x2) == 0) {
        break label398;
      }
      paramBoolean = true;
      label180:
      localHotChatInfo.supportDemo = paramBoolean;
      localHotChatInfo.adminLevel = paramWifiPOIInfo.uint32_is_admin.get();
      localHotChatInfo.joinUrl = paramWifiPOIInfo.string_join_group_url.get();
      localHotChatInfo.hotChatType = paramWifiPOIInfo.uint32_group_type_flag.get();
      localHotChatInfo.userCreate = paramWifiPOIInfo.uint32_is_user_create.get();
      localHotChatInfo.ownerUin = String.valueOf(paramWifiPOIInfo.uint64_owner_uin.get());
      localHotChatInfo.pkFlag = paramWifiPOIInfo.uint32_tv_pk_flag.get();
      if (paramWifiPOIInfo.uint64_favorites_time.get() <= 0L) {
        break label403;
      }
    }
    label393:
    label398:
    label403:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localHotChatInfo.isFavorite = paramBoolean;
      localHotChatInfo.subType = paramWifiPOIInfo.uint32_sub_type.get();
      localHotChatInfo.lLastMsgSeq = paramWifiPOIInfo.uint64_last_msg_seq.get();
      localHotChatInfo.mFissionRoomNum = paramWifiPOIInfo.uint32_group_id.get();
      if (paramWifiPOIInfo.uint64_praise_nums.has()) {
        l = paramWifiPOIInfo.uint64_praise_nums.get();
      }
      localHotChatInfo.praiseCount = l;
      if (localHotChatInfo.subType == 1)
      {
        localHotChatInfo.mSeatsList = HCSeatInfo.convert(paramWifiPOIInfo.rpt_msg_seats_info.get());
        localHotChatInfo.extra1 = HCSeatInfo.encodeSeatsInfo(localHotChatInfo.mSeatsList);
      }
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "createHotChat_WifiPOIInfo", new Object[] { localHotChatInfo });
      }
      return localHotChatInfo;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label167;
      paramBoolean = false;
      break label180;
    }
  }
  
  public static RecentUser createRecentUser(HotChatInfo paramHotChatInfo, boolean paramBoolean)
  {
    RecentUser localRecentUser = new RecentUser();
    localRecentUser.displayName = paramHotChatInfo.name;
    localRecentUser.lastmsgtime = NetConnInfoCenter.getServerTime();
    if (paramBoolean) {
      localRecentUser.type = 1;
    }
    for (localRecentUser.uin = AppConstants.aD;; localRecentUser.uin = paramHotChatInfo.troopUin)
    {
      localRecentUser.troopUin = paramHotChatInfo.troopUin;
      localRecentUser.lFlag = 1L;
      return localRecentUser;
      localRecentUser.type = 1;
    }
  }
  
  public static Common.WifiPOIInfo createWifiPOIInfo(HotChatInfo paramHotChatInfo)
  {
    Common.WifiPOIInfo localWifiPOIInfo = new Common.WifiPOIInfo();
    for (;;)
    {
      try
      {
        if (paramHotChatInfo.name != null) {
          localWifiPOIInfo.bytes_name.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.name));
        }
        if (paramHotChatInfo.signature != null) {
          localWifiPOIInfo.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.signature));
        }
        localWifiPOIInfo.uint32_face_id.set(paramHotChatInfo.faceId);
        localWifiPOIInfo.uint32_group_code.set(Utils.a(Long.parseLong(paramHotChatInfo.troopUin)));
        localWifiPOIInfo.uint32_group_uin.set(Utils.a(Long.parseLong(paramHotChatInfo.troopCode)));
        localWifiPOIInfo.uint32_visitor_num.set(paramHotChatInfo.memberCount);
        Object localObject = localWifiPOIInfo.uint32_is_member;
        if (!paramHotChatInfo.hasJoined) {
          continue;
        }
        i = 1;
        ((PBUInt32Field)localObject).set(i);
        if (paramHotChatInfo.uuid != null) {
          localWifiPOIInfo.bytes_uid.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.uuid));
        }
        localObject = localWifiPOIInfo.uint32_wifi_poi_type;
        if (!paramHotChatInfo.isWifiHotChat) {
          continue;
        }
        i = 1;
        ((PBUInt32Field)localObject).set(i);
        if (!TextUtils.isEmpty(paramHotChatInfo.iconUrl)) {
          localWifiPOIInfo.face_url.set(paramHotChatInfo.iconUrl);
        }
        localWifiPOIInfo.hot_theme_group_flag.set(paramHotChatInfo.hotThemeGroupFlag);
        localObject = localWifiPOIInfo.uint32_special_flag;
        if (!paramHotChatInfo.supportFlashPic) {
          continue;
        }
        i = 1;
        ((PBUInt32Field)localObject).set(i);
        localWifiPOIInfo.uint32_is_admin.set(paramHotChatInfo.adminLevel);
        localWifiPOIInfo.string_join_group_url.set(paramHotChatInfo.joinUrl);
        localWifiPOIInfo.uint32_group_type_flag.set(paramHotChatInfo.hotChatType);
        localWifiPOIInfo.uint32_is_user_create.set(paramHotChatInfo.userCreate);
        localWifiPOIInfo.uint64_owner_uin.set(BizTroopHandler.a(paramHotChatInfo.ownerUin));
        localWifiPOIInfo.uint32_tv_pk_flag.set(paramHotChatInfo.pkFlag);
        localObject = localWifiPOIInfo.uint64_favorites_time;
        if (!paramHotChatInfo.isFavorite) {
          continue;
        }
        l = 100L;
        ((PBUInt64Field)localObject).set(l);
        localWifiPOIInfo.uint32_sub_type.set(paramHotChatInfo.subType);
        localWifiPOIInfo.uint64_last_msg_seq.set(paramHotChatInfo.lLastMsgSeq);
        localWifiPOIInfo.uint64_praise_nums.set(paramHotChatInfo.praiseCount);
        localWifiPOIInfo.uint32_group_id.set(paramHotChatInfo.mFissionRoomNum);
        if (paramHotChatInfo.subType == 1)
        {
          localObject = HCSeatInfo.convert2(paramHotChatInfo.getHCSeatInfoList());
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localWifiPOIInfo.rpt_msg_seats_info.set((List)localObject);
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        long l;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        NearbyUtils.a("PttShow", "createWifiPOIInfo", new Object[] { localException.toString() });
        continue;
      }
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "createWifiPOIInfo", new Object[] { paramHotChatInfo });
      }
      return localWifiPOIInfo;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 0;
      continue;
      l = 0L;
    }
  }
  
  public static String pack(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put((String)paramList.next());
    }
    return localJSONArray.toString();
  }
  
  public static List unPack(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        String str = (String)paramString.get(i);
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public HotChatInfo clone()
  {
    try
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)super.clone();
      return localHotChatInfo;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public List getHCSeatInfoList()
  {
    List localList = null;
    if (isPttShowRoom())
    {
      if (this.mSeatsList == null) {
        this.mSeatsList = HCSeatInfo.decodeSeatsInfo(this.extra1);
      }
      localList = this.mSeatsList;
    }
    return localList;
  }
  
  public int getUserType(long paramLong)
  {
    int j = 0;
    int i = j;
    Object localObject;
    if (this.subType == 1)
    {
      localObject = Long.toString(paramLong);
      if ((this.ownerUin != null) && (this.ownerUin.equals(localObject))) {
        i = 1;
      }
    }
    else
    {
      return i;
    }
    if (this.mSeatsList != null)
    {
      localObject = this.mSeatsList.iterator();
      HCSeatInfo localHCSeatInfo;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localHCSeatInfo = (HCSeatInfo)((Iterator)localObject).next();
      } while ((localHCSeatInfo == null) || (localHCSeatInfo.guestUin != paramLong));
    }
    for (i = 2;; i = 0)
    {
      return i;
      i = j;
      if (this.extra1 == null) {
        break;
      }
      i = j;
      if (!this.extra1.contains((CharSequence)localObject)) {
        break;
      }
      return 2;
    }
  }
  
  public boolean isOwnerOrAdmin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals(this.ownerUin)) && ((this.adminUins == null) || (!this.adminUins.contains(paramString)))) {
      return false;
    }
    return true;
  }
  
  public boolean isPKHotChat()
  {
    return this.pkFlag > 0;
  }
  
  public boolean isPttRomGuest(String paramString)
  {
    Object localObject = getHCSeatInfoList();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HCSeatInfo localHCSeatInfo = (HCSeatInfo)((Iterator)localObject).next();
      if ((localHCSeatInfo != null) && (String.valueOf(localHCSeatInfo.guestUin).equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isPttShowRoom()
  {
    return this.subType == 1;
  }
  
  public void onExit(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("Q.hotchat", new Object[] { "onExit", Integer.valueOf(paramInt) });
    }
    this.state = paramInt;
    this.leftTime = System.currentTimeMillis();
    if (isPttShowRoom())
    {
      if (this.mSeatsList == null) {
        this.mSeatsList = HCSeatInfo.decodeSeatsInfo(this.extra1);
      }
      Iterator localIterator = this.mSeatsList.iterator();
      while (localIterator.hasNext())
      {
        HCSeatInfo localHCSeatInfo = (HCSeatInfo)localIterator.next();
        if (localHCSeatInfo != null)
        {
          localHCSeatInfo.guestUin = 0L;
          localHCSeatInfo.seatFlag = 1;
          localHCSeatInfo.seatSeq = 0;
        }
      }
      this.extra1 = HCSeatInfo.encodeSeatsInfo(this.mSeatsList);
      return;
    }
    this.mSeatsList = null;
    this.extra1 = "";
  }
  
  protected void postRead()
  {
    super.postRead();
    if (!TextUtils.isEmpty(this.strAdminUins)) {
      this.adminUins = unPack(this.strAdminUins);
    }
  }
  
  protected void prewrite()
  {
    super.prewrite();
    if ((this.adminUins != null) && (this.adminUins.size() > 0)) {
      this.strAdminUins = pack(this.adminUins);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    localStringBuilder.append("HotChatInfo [name=").append(this.name).append(", troopCode=").append(this.troopCode).append(", signature=").append(this.signature).append(", troopUin=").append(this.troopUin).append(", faceId=").append(this.faceId).append(", memberCount=").append(this.memberCount).append(", hasJoined=").append(this.hasJoined).append(", isWifiHotChat=").append(this.isWifiHotChat).append(", uuid=").append(this.uuid).append(", detail=").append(this.detail).append(", state=").append(this.state).append(", leftTime=").append(this.leftTime).append(",face_url=").append(this.iconUrl).append(", hot_theme_group_flag=").append(this.hotThemeGroupFlag).append(", supportFlashPic=").append(this.supportFlashPic).append(", supportDemo=").append(this.supportDemo).append(",adminLevel=").append(this.adminLevel).append(",joinUrl=").append(this.joinUrl).append(",hotChatType=").append(this.hotChatType).append(",memo=").append(this.memo).append(",memoUrl=").append(this.memoUrl).append(",userCreate=").append(this.userCreate).append(",strAdminUins=").append(this.strAdminUins).append(",ownerUin=").append(this.ownerUin).append(",pkFlag=").append(this.pkFlag).append(", subType=").append(this.subType).append(", lLastMsgSeq=").append(this.lLastMsgSeq).append(", extral=").append(this.extra1).append(", mFissionRoomNum=").append(this.mFissionRoomNum).append(", praiseCount=").append(this.praiseCount).append("]");
    return localStringBuilder.toString();
  }
  
  public void updateHCSeatInfoList(List paramList)
  {
    if ((paramList == null) || (paramList == this.mSeatsList)) {
      return;
    }
    if (this.mSeatsList == null) {
      this.mSeatsList = HCSeatInfo.decodeSeatsInfo(this.extra1);
    }
    if (QLog.isDevelopLevel())
    {
      NearbyUtils.a("PttShow", "updateHCSeatInfoList, --server: ", new Object[] { HCSeatInfo.encodeSeatsInfo(paramList) });
      NearbyUtils.a("PttShow", "updateHCSeatInfoList, --local: ", new Object[] { HCSeatInfo.encodeSeatsInfo(this.mSeatsList) });
    }
    Iterator localIterator1 = paramList.iterator();
    label85:
    label285:
    for (;;)
    {
      HCSeatInfo localHCSeatInfo1;
      int i;
      if (localIterator1.hasNext())
      {
        localHCSeatInfo1 = (HCSeatInfo)localIterator1.next();
        if ((localHCSeatInfo1 != null) && (localHCSeatInfo1.seatID > 0))
        {
          Iterator localIterator2 = this.mSeatsList.iterator();
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              HCSeatInfo localHCSeatInfo2 = (HCSeatInfo)localIterator2.next();
              if ((localHCSeatInfo2 != null) && (localHCSeatInfo2.seatID == localHCSeatInfo1.seatID)) {
                if (localHCSeatInfo2.seatSeq <= localHCSeatInfo1.seatSeq)
                {
                  localHCSeatInfo2.guestUin = localHCSeatInfo1.guestUin;
                  localHCSeatInfo2.seatFlag = localHCSeatInfo1.seatFlag;
                  localHCSeatInfo2.seatSeq = localHCSeatInfo1.seatSeq;
                  i = 1;
                }
              }
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i != 0) {
            break label285;
          }
          this.mSeatsList.add(localHCSeatInfo1);
          break label85;
          this.extra1 = HCSeatInfo.encodeSeatsInfo(this.mSeatsList);
          if (!QLog.isDevelopLevel()) {
            break;
          }
          NearbyUtils.a("PttShow", "updateHCSeatInfoList", new Object[] { Integer.valueOf(paramList.size()), this.extra1 });
          return;
          i = 1;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public void updateHotChatInfo(HotChatInfo paramHotChatInfo)
  {
    if ((paramHotChatInfo == null) || (paramHotChatInfo == this)) {
      return;
    }
    this.troopCode = paramHotChatInfo.troopCode;
    this.state = 0;
    this.faceId = paramHotChatInfo.faceId;
    this.isWifiHotChat = paramHotChatInfo.isWifiHotChat;
    this.memberCount = paramHotChatInfo.memberCount;
    this.signature = paramHotChatInfo.signature;
    this.uuid = paramHotChatInfo.uuid;
    this.name = paramHotChatInfo.name;
    this.iconUrl = paramHotChatInfo.iconUrl;
    this.supportFlashPic = paramHotChatInfo.supportFlashPic;
    this.adminLevel = paramHotChatInfo.adminLevel;
    this.hotChatType = paramHotChatInfo.hotChatType;
    this.userCreate = paramHotChatInfo.userCreate;
    this.hotThemeGroupFlag = paramHotChatInfo.hotThemeGroupFlag;
    this.joinUrl = paramHotChatInfo.joinUrl;
    this.supportDemo = paramHotChatInfo.supportDemo;
    this.ownerUin = paramHotChatInfo.ownerUin;
    this.pkFlag = paramHotChatInfo.pkFlag;
    this.subType = paramHotChatInfo.subType;
    this.lLastMsgSeq = paramHotChatInfo.lLastMsgSeq;
    this.mFissionRoomNum = paramHotChatInfo.mFissionRoomNum;
    this.praiseCount = paramHotChatInfo.praiseCount;
    if (this.subType == 1)
    {
      if (this.mSeatsList != null) {
        break label277;
      }
      this.mSeatsList = new ArrayList(5);
    }
    for (;;)
    {
      if ((paramHotChatInfo.mSeatsList != null) && (paramHotChatInfo.mSeatsList.size() > 0)) {
        this.mSeatsList.addAll(paramHotChatInfo.mSeatsList);
      }
      this.extra1 = paramHotChatInfo.extra1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      NearbyUtils.a("PttShow", new Object[] { "updateHotChatInfo", paramHotChatInfo });
      return;
      label277:
      this.mSeatsList.clear();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\HotChatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */