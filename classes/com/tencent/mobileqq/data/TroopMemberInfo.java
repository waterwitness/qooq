package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="troopuin,memberuin")
public class TroopMemberInfo
  extends Entity
  implements Serializable
{
  public static final long VALUE_DISTANCE_TO_SELF_EXPIRED = -1000L;
  public static final long VALUE_DISTANCE_TO_SELF_UNKOWN = -100L;
  public static final long VALUE_MEMBER_CLOSE_SHARE_LBS = -1001L;
  public long active_point;
  public byte age;
  public String alias;
  public String autoremark;
  public long credit_level;
  public long datetime;
  @notColumn
  public String displayedNamePinyinFirst;
  public int distance;
  public double distanceToSelf;
  public long distanceToSelfUpdateTimeStamp;
  public short faceid;
  public String friendnick;
  public long gagTimeStamp;
  public boolean isTroopFollowed;
  public long join_time;
  public long last_active_time;
  public int level;
  public int mGlamourLevel;
  public boolean mIsShielded;
  public String mUniqueTitle;
  public int mUniqueTitleExpire;
  public String memberuin;
  public long msgseq;
  public String pyAll_autoremark;
  public String pyAll_friendnick;
  public String pyAll_troopnick;
  public String pyFirst_autoremark;
  public String pyFirst_friendnick;
  public String pyFirst_troopnick;
  public int qqVipInfo;
  public byte sex;
  public byte status;
  public int superQqInfo;
  public int superVipInfo;
  public int tribeLevel;
  public int tribePoint;
  public String troopnick;
  public String troopremark;
  public String troopuin;
  
  public TroopMemberInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msgseq = -100L;
    this.distanceToSelf = -100.0D;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    boolean bool2 = false;
    this.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
    this.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
    this.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
    this.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
    this.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
    this.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
    this.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
    this.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
    this.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
    this.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
    this.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
    this.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
    this.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
    this.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
    this.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
    this.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
    this.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
    this.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
    this.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
    this.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
    this.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
    this.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
    this.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
    this.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
    this.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
    this.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("isTroopFollowed")) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.isTroopFollowed = bool1;
      this.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
      this.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
      this.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
      this.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
      this.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
      bool1 = bool2;
      if (paramCursor.getInt(paramCursor.getColumnIndex("mIsShielded")) != 0) {
        bool1 = true;
      }
      this.mIsShielded = bool1;
      this.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
      this.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
      this.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
      this.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
      this.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
      return true;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TroopMemberInfo{");
    localStringBuilder.append("datetime=").append(this.datetime);
    localStringBuilder.append(", troopuin='").append(this.troopuin).append('\'');
    localStringBuilder.append(", memberuin='").append(this.memberuin).append('\'');
    localStringBuilder.append(", displayedNamePinyinFirst='").append(this.displayedNamePinyinFirst).append('\'');
    localStringBuilder.append(", friendnick='").append(this.friendnick).append('\'');
    localStringBuilder.append(", pyAll_friendnick='").append(this.pyAll_friendnick).append('\'');
    localStringBuilder.append(", pyFirst_friendnick='").append(this.pyFirst_friendnick).append('\'');
    localStringBuilder.append(", troopnick='").append(this.troopnick).append('\'');
    localStringBuilder.append(", pyAll_troopnick='").append(this.pyAll_troopnick).append('\'');
    localStringBuilder.append(", pyFirst_troopnick='").append(this.pyFirst_troopnick).append('\'');
    localStringBuilder.append(", autoremark='").append(this.autoremark).append('\'');
    localStringBuilder.append(", pyAll_autoremark='").append(this.pyAll_autoremark).append('\'');
    localStringBuilder.append(", pyFirst_autoremark='").append(this.pyFirst_autoremark).append('\'');
    localStringBuilder.append(", troopremark='").append(this.troopremark).append('\'');
    localStringBuilder.append(", alias='").append(this.alias).append('\'');
    localStringBuilder.append(", faceid=").append(this.faceid);
    localStringBuilder.append(", age=").append(this.age);
    localStringBuilder.append(", sex=").append(this.sex);
    localStringBuilder.append(", status=").append(this.status);
    localStringBuilder.append(", qqVipInfo=").append(this.qqVipInfo);
    localStringBuilder.append(", superQqInfo=").append(this.superQqInfo);
    localStringBuilder.append(", superVipInfo=").append(this.superVipInfo);
    localStringBuilder.append(", level=").append(this.level);
    localStringBuilder.append(", join_time=").append(this.join_time);
    localStringBuilder.append(", last_active_time=").append(this.last_active_time);
    localStringBuilder.append(", active_point=").append(this.active_point);
    localStringBuilder.append(", credit_level=").append(this.credit_level);
    localStringBuilder.append(", isTroopFollowed=").append(this.isTroopFollowed);
    localStringBuilder.append(", distance=").append(this.distance);
    localStringBuilder.append(", msgseq=").append(this.msgseq);
    localStringBuilder.append(", gagTimeStamp=").append(this.gagTimeStamp);
    localStringBuilder.append(", distanceToSelf=").append(this.distanceToSelf);
    localStringBuilder.append(", distanceToSelfUpdateTimeStamp=").append(this.distanceToSelfUpdateTimeStamp);
    localStringBuilder.append(", mIsShielded=").append(this.mIsShielded);
    localStringBuilder.append(", mUniqueTitle='").append(this.mUniqueTitle).append('\'');
    localStringBuilder.append(", mUniqueTitleExpire=").append(this.mUniqueTitleExpire);
    localStringBuilder.append(", tribeLevel=").append(this.tribeLevel);
    localStringBuilder.append(", tribePoint=").append(this.tribePoint);
    localStringBuilder.append(", mGlamourLevel=").append(this.mGlamourLevel);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\data\TroopMemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */