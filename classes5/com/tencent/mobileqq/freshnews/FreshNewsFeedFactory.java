package com.tencent.mobileqq.freshnews;

import com.tencent.mobileqq.freshnews.data.FNADHotTopicItemData;
import com.tencent.mobileqq.freshnews.data.FNADNowItemData;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.data.FNHotChatItemData;
import com.tencent.mobileqq.freshnews.data.FNTopicItemData;
import com.tencent.mobileqq.freshnews.feed.FNADHotTopicItemBuilder;
import com.tencent.mobileqq.freshnews.feed.FNADNowItemBuilder;
import com.tencent.mobileqq.freshnews.feed.FNBaseItemBuilder;
import com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder;
import com.tencent.mobileqq.freshnews.feed.FNEmptyItemBuilder;
import com.tencent.mobileqq.freshnews.feed.FNHotChatItemBuilder;
import com.tencent.mobileqq.freshnews.feed.FNTopicItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class FreshNewsFeedFactory
{
  public static final int a = 0;
  protected static final int[] a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  public static final int k = 7;
  public static final int l = 8;
  public static final int m = 9;
  public FNBaseItemBuilder[] a;
  protected int[] b;
  private int n = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
  }
  
  public FreshNewsFeedFactory(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder = new FNBaseItemBuilder[9];
    this.n = paramInt;
    this.b = jdField_a_of_type_ArrayOfInt;
  }
  
  public int a(Object paramObject)
  {
    int i1 = 3;
    if ((paramObject != null) && ((paramObject instanceof FNBaseItemData)))
    {
      paramObject = (FNBaseItemData)paramObject;
      if ((paramObject instanceof FNTopicItemData)) {
        i1 = 5;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "getItemViewType|type:" + i1);
      }
      return i1;
      if ((paramObject instanceof FNHotChatItemData))
      {
        i1 = 6;
      }
      else if ((paramObject instanceof FNDefaultItemData))
      {
        paramObject = (FNDefaultItemData)paramObject;
        if (((FNDefaultItemData)paramObject).f == 1) {
          i1 = 2;
        } else if (((FNDefaultItemData)paramObject).f != 2) {
          if (((FNDefaultItemData)paramObject).f >= 3) {
            i1 = 4;
          } else {
            i1 = 1;
          }
        }
      }
      else if ((paramObject instanceof FNADNowItemData))
      {
        i1 = 8;
      }
      else if ((paramObject instanceof FNADHotTopicItemData))
      {
        i1 = 7;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public FNBaseItemBuilder a(Object paramObject)
  {
    int i1 = a(paramObject);
    paramObject = null;
    if (i1 == 0)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[0] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[0] = new FNEmptyItemBuilder();
      }
      paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[0];
    }
    do
    {
      return (FNBaseItemBuilder)paramObject;
      if (i1 == 1)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[1] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[1] = new FNDefaultItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[1];
      }
      if (i1 == 2)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[2] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[2] = new FNDefaultItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[2];
      }
      if (i1 == 3)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[3] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[3] = new FNDefaultItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[3];
      }
      if (i1 == 4)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[4] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[4] = new FNDefaultItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[4];
      }
      if (i1 == 6)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[6] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[6] = new FNHotChatItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[6];
      }
      if (i1 == 5)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[5] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[5] = new FNTopicItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[5];
      }
      if (i1 == 8)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[8] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[8] = new FNADNowItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[8];
      }
      if (i1 == 7)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[7] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[7] = new FNADHotTopicItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqFreshnewsFeedFNBaseItemBuilder[7];
      }
    } while (0 != 0);
    return new FNEmptyItemBuilder();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsFeedFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */