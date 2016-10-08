package com.tencent.biz.lebasearch;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class SearchProtocol$WordItem
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String contentDescription;
  public String id;
  public String jumpUrl;
  public int textColor;
  public int type;
  public String word;
  
  public SearchProtocol$WordItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = 1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\lebasearch\SearchProtocol$WordItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */