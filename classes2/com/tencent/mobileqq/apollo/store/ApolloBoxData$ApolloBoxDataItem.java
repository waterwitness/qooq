package com.tencent.mobileqq.apollo.store;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ApolloBoxData$ApolloBoxDataItem
  implements Comparable
{
  public int a;
  public long a;
  public String a;
  public short a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public short b;
  public boolean b;
  public long c;
  public String c;
  public String d;
  
  public ApolloBoxData$ApolloBoxDataItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(ApolloBoxDataItem paramApolloBoxDataItem)
  {
    if (paramApolloBoxDataItem == null) {}
    do
    {
      return -1;
      if (this.jdField_a_of_type_Boolean == paramApolloBoxDataItem.jdField_a_of_type_Boolean) {
        return -(int)(this.c - paramApolloBoxDataItem.c);
      }
    } while (this.jdField_a_of_type_Boolean);
    return 0;
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_Long == this.b) || ((!TextUtils.isEmpty(paramString)) && (paramString.equals(String.valueOf(this.jdField_a_of_type_Long))));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloBoxData$ApolloBoxDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */