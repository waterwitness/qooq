package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class ChannelTopCookie
  extends Entity
  implements Cloneable
{
  public static final String TABLE_NAME = ArticleInfo.class.getSimpleName();
  public int mChannelID = -1;
  public byte[] mSetTopCookie;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ChannelTopCookie clone()
  {
    try
    {
      ChannelTopCookie localChannelTopCookie = (ChannelTopCookie)super.clone();
      return localChannelTopCookie;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\struct\ChannelTopCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */