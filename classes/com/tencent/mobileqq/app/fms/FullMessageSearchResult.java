package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class FullMessageSearchResult
{
  public int a;
  public List a;
  
  public FullMessageSearchResult()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FullMessageSearchResult:");
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      localStringBuilder.append("null");
      return localStringBuilder.toString();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      FullMessageSearchResult.SearchResultItem localSearchResultItem = (FullMessageSearchResult.SearchResultItem)localIterator.next();
      localStringBuilder.append("(");
      localStringBuilder.append(localSearchResultItem.user.uin);
      localStringBuilder.append(",");
      if (localSearchResultItem.secondPageList == null)
      {
        i = 0;
        label94:
        localStringBuilder.append(i);
        localStringBuilder.append(",");
        if (localSearchResultItem.secondPageMessageUniseq != null) {
          break label149;
        }
      }
      label149:
      for (int i = 0;; i = localSearchResultItem.secondPageMessageUniseq.size())
      {
        localStringBuilder.append(i);
        localStringBuilder.append(")");
        break;
        i = localSearchResultItem.secondPageList.size();
        break label94;
      }
    }
    localStringBuilder.append(" searchFinFlag=" + this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\fms\FullMessageSearchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */