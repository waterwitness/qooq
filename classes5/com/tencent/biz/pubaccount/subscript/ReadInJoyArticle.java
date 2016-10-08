package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class ReadInJoyArticle
  implements Serializable
{
  public static final String TAG = ReadInJoyArticle.class.getSimpleName();
  public long mArticleID = -1L;
  public String mArticleUrl = "";
  public long mChannelID = -1L;
  public String mFirstPagePicUrl = "";
  public String mSummary = "";
  public String mTitle = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\ReadInJoyArticle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */