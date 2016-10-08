package com.tencent.mobileqq.service.friendlist;

import com.tencent.mobileqq.service.friendlist.remote.FriendGroupListInfo;
import com.tencent.mobileqq.service.friendlist.remote.FriendListInfo;

public abstract interface FriendListManagerListener
{
  public abstract void a(String paramString, FriendListInfo paramFriendListInfo, FriendGroupListInfo paramFriendGroupListInfo);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\friendlist\FriendListManagerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */