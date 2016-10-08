package com.tencent.mobileqq.businessCard.activity;

import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class BusinessCardListActivity$MyComparator
  implements Comparator
{
  int a;
  
  public BusinessCardListActivity$MyComparator(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = -1;
    this.a = paramInt;
  }
  
  public int a(BusinessCard paramBusinessCard1, BusinessCard paramBusinessCard2)
  {
    int j = 0;
    int i;
    if (this.a == 1)
    {
      Object localObject2 = paramBusinessCard1.firstPinyin;
      String str = paramBusinessCard2.firstPinyin;
      Object localObject1 = localObject2;
      if (((String)localObject2).endsWith("#")) {
        localObject1 = "Za";
      }
      localObject2 = str;
      if (str.endsWith("#")) {
        localObject2 = "Za";
      }
      j = ((String)localObject1).compareTo((String)localObject2);
      i = j;
      if (j == 0) {
        i = paramBusinessCard2.allPinyin.compareTo(paramBusinessCard1.allPinyin);
      }
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.a != 0);
      i = j;
    } while (paramBusinessCard1.lastUpdateTime == paramBusinessCard2.lastUpdateTime);
    if (paramBusinessCard1.lastUpdateTime > paramBusinessCard2.lastUpdateTime) {
      return 1;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\activity\BusinessCardListActivity$MyComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */