package com.tencent.biz.qqstory.pgc.model;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.UserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;

public class UserInfo
  implements Serializable
{
  public static final int TYPE_PGC_ALBUM = 2;
  public static final int TYPE_PGC_ERROR = -1;
  public static final int TYPE_PGC_MEDIA = 0;
  public static final int TYPE_PGC_URL = 3;
  public static final int TYPE_PGC_V = 1;
  public static final int TYPE_UGC_NOW = 4;
  public static final long serialVersionUID = 1L;
  public String authTypeIcon;
  public String authTypeName;
  public String desc;
  public long fansGroupUin;
  public String headUrl;
  public boolean isSubscribe;
  public String logoURL;
  public String nick;
  public String remark;
  public long subscribeCount;
  public int themeColor;
  public long tribeId;
  public int type;
  public long uid;
  public String unionId;
  public long viewCount;
  
  public UserInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static UserInfo convertFrom(qqstory_pgc.UserInfo paramUserInfo)
  {
    long l2 = 0L;
    Object localObject2 = null;
    if ((paramUserInfo == null) || (!paramUserInfo.has())) {
      return null;
    }
    UserInfo localUserInfo = new UserInfo();
    int i;
    long l1;
    label70:
    label97:
    label123:
    label149:
    boolean bool;
    if (paramUserInfo.type.has())
    {
      i = paramUserInfo.type.get();
      localUserInfo.type = i;
      if (!paramUserInfo.uid.has()) {
        break label459;
      }
      l1 = paramUserInfo.uid.get();
      localUserInfo.uid = l1;
      if (!paramUserInfo.nick.has()) {
        break label465;
      }
      localObject1 = paramUserInfo.nick.get().toStringUtf8();
      localUserInfo.nick = ((String)localObject1);
      if (!paramUserInfo.head_url.has()) {
        break label470;
      }
      localObject1 = paramUserInfo.head_url.get().toStringUtf8();
      localUserInfo.headUrl = ((String)localObject1);
      if (!paramUserInfo.remark.has()) {
        break label475;
      }
      localObject1 = paramUserInfo.remark.get().toStringUtf8();
      localUserInfo.remark = ((String)localObject1);
      if (!paramUserInfo.is_subscribe.has()) {
        break label480;
      }
      bool = paramUserInfo.is_subscribe.get();
      label173:
      localUserInfo.isSubscribe = bool;
      if (!paramUserInfo.desc.has()) {
        break label486;
      }
      localObject1 = paramUserInfo.desc.get().toStringUtf8();
      label200:
      localUserInfo.desc = ((String)localObject1);
      if (!paramUserInfo.logo_url.has()) {
        break label491;
      }
      localObject1 = paramUserInfo.logo_url.get().toStringUtf8();
      label226:
      localUserInfo.logoURL = ((String)localObject1);
      if (!paramUserInfo.view_count.has()) {
        break label496;
      }
      l1 = paramUserInfo.view_count.get();
      label250:
      localUserInfo.viewCount = l1;
      if (!paramUserInfo.fans_group_uin.has()) {
        break label502;
      }
      l1 = paramUserInfo.fans_group_uin.get();
      label275:
      localUserInfo.fansGroupUin = l1;
      if (!paramUserInfo.tribe_id.has()) {
        break label508;
      }
      l1 = paramUserInfo.tribe_id.get();
      label300:
      localUserInfo.tribeId = l1;
      if (!paramUserInfo.theme_color.has()) {
        break label514;
      }
      i = paramUserInfo.theme_color.get();
      label325:
      localUserInfo.themeColor = i;
      localUserInfo.themeColor |= 0xFF000000;
      l1 = l2;
      if (paramUserInfo.subscribe_count.has()) {
        l1 = paramUserInfo.subscribe_count.get();
      }
      localUserInfo.subscribeCount = l1;
      if (!paramUserInfo.union_id.has()) {
        break label524;
      }
      localObject1 = paramUserInfo.union_id.get().toStringUtf8();
      label392:
      localUserInfo.unionId = ((String)localObject1);
      if (!paramUserInfo.auth_type_name.has()) {
        break label529;
      }
    }
    label459:
    label465:
    label470:
    label475:
    label480:
    label486:
    label491:
    label496:
    label502:
    label508:
    label514:
    label524:
    label529:
    for (Object localObject1 = paramUserInfo.auth_type_name.get().toStringUtf8();; localObject1 = null)
    {
      localUserInfo.authTypeName = ((String)localObject1);
      localObject1 = localObject2;
      if (paramUserInfo.auth_type_icon.has()) {
        localObject1 = paramUserInfo.auth_type_icon.get().toStringUtf8();
      }
      localUserInfo.authTypeIcon = ((String)localObject1);
      return localUserInfo;
      i = -1;
      break;
      l1 = 0L;
      break label70;
      localObject1 = null;
      break label97;
      localObject1 = null;
      break label123;
      localObject1 = null;
      break label149;
      bool = false;
      break label173;
      localObject1 = null;
      break label200;
      localObject1 = null;
      break label226;
      l1 = 0L;
      break label250;
      l1 = 0L;
      break label275;
      l1 = 0L;
      break label300;
      i = Color.parseColor("#f8a900");
      break label325;
      localObject1 = null;
      break label392;
    }
  }
  
  public boolean checkData()
  {
    if (TextUtils.isEmpty(this.headUrl)) {}
    while ((!isNoNickUser()) && (TextUtils.isEmpty(this.nick))) {
      return false;
    }
    switch (this.type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof UserInfo))
    {
      paramObject = (UserInfo)paramObject;
      if (this.type != ((UserInfo)paramObject).type) {}
      while (((this.unionId != null) && (!this.unionId.equals(((UserInfo)paramObject).unionId))) || ((this.unionId == null) && (((UserInfo)paramObject).unionId != null))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isNoNickUser()
  {
    switch (this.type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "UserInfo{type=" + this.type + ", nick='" + this.nick + '\'' + ", headUrl='" + this.headUrl + '\'' + ", remark='" + this.remark + '\'' + ", isSubscribe=" + this.isSubscribe + ", desc='" + this.desc + '\'' + ", logoURL='" + this.logoURL + '\'' + ", viewCount=" + this.viewCount + ", fansGroupUin=" + this.fansGroupUin + ", tribeId=" + this.tribeId + ", themeColor=" + this.themeColor + ", subscribeCount=" + this.subscribeCount + ", unionId='" + this.unionId + '\'' + ", authTypeName='" + this.authTypeName + '\'' + ", authTypeIcon='" + this.authTypeIcon + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */