package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TroopMemberCard
  implements Serializable
{
  public static final long MEMBER_DISTANCE_DEFAULT = -1L;
  public static final long MEMBER_DISTANCE_UNKOWN = -1000L;
  private static final long serialVersionUID = 1L;
  public int age;
  public String card;
  public int credit;
  public List customEntryList;
  public long distance;
  public int gbarCount;
  public String gbarLinkUrl;
  public List gbarList;
  public String gbarTitle;
  public boolean isAllowModCard;
  public boolean isConcerned;
  public boolean isFriend;
  public boolean isSuperQQ;
  public boolean isSuperVip;
  public boolean isVip;
  public boolean isYearVip;
  public long joinTime;
  public long lastSpeak;
  public String levelName;
  public String location;
  public ArrayList mCurrAccountOrgIds;
  public int mGroupType;
  public boolean mIsShield;
  public ArrayList mOrgIds;
  public String mPosition;
  public String mQzoneFeed;
  public String mRecentSaied;
  public RichStatus mRichSignStatus;
  public String mUniqueTitle;
  public int mUniqueTitleExpire;
  public int memberRole;
  public long memberUin;
  public String nick;
  public String phoneNumber;
  public String remark;
  public int result;
  public int sex;
  public int vipLevel;
  
  public TroopMemberCard()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.vipLevel = 26;
    this.distance = -1L;
    this.mOrgIds = new ArrayList();
    this.mCurrAccountOrgIds = new ArrayList();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\TroopMemberCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */