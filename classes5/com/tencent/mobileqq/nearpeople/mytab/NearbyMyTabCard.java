package com.tencent.mobileqq.nearpeople.mytab;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NearbyMyTabCard
  implements Serializable
{
  public int age;
  public int carrier;
  public int charmLevel;
  public int charmValue;
  public List configList;
  public int currentCharm;
  public int gender;
  public int giftNum;
  public int godFlag;
  public int likeTotalNum;
  public int newLikeNum;
  public int nextCharm;
  public String nickName;
  public Long uin;
  public List visitors;
  
  public NearbyMyTabCard()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.nickName = "";
    this.configList = new ArrayList();
    this.visitors = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(120);
    localStringBuilder.append("[").append("uin = ").append(this.uin).append(", nickName = ").append(this.nickName).append(", newLikeNum = ").append(this.newLikeNum).append(", charmValue = ").append(this.charmValue).append(", charmLevel = ").append(this.charmLevel).append(", currentCharm = ").append(this.currentCharm).append(", nextCharm = ").append(this.nextCharm).append(", giftNum = ").append(this.giftNum).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearpeople\mytab\NearbyMyTabCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */