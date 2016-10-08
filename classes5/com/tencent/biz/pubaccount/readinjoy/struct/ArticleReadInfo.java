package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class ArticleReadInfo
  extends Entity
  implements Cloneable
{
  public static final String TABLE_NAME = ArticleReadInfo.class.getSimpleName();
  public long mArticleID = -1L;
  public boolean mIsRead;
  public long mLastReadTime;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArticleReadInfo clone()
  {
    try
    {
      ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)super.clone();
      return localArticleReadInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\struct\ArticleReadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */