package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.List;

public class FullMessageSearchResult$SearchResultItem
  implements Serializable
{
  public QQMessageFacade.Message lastMessage;
  public List secondPageList;
  public List secondPageMessageUniseq;
  public RecentUser user;
  
  public FullMessageSearchResult$SearchResultItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\fms\FullMessageSearchResult$SearchResultItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */