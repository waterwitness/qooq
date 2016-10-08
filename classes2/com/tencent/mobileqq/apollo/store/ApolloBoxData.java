package com.tencent.mobileqq.apollo.store;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApolloBoxData
{
  public static final long a = -501027L;
  public static final long b = -501028L;
  public static final long c = -501029L;
  public static final long d = -501030L;
  public static final long e = -501031L;
  public static final long f = -501040L;
  public static final long g = 0L;
  public int a;
  public String a;
  public List a;
  public boolean a;
  public String b;
  public List b;
  public String c;
  public long h;
  public long i;
  public long j;
  
  public ApolloBoxData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = 0;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = (ApolloBoxData.ApolloBoxDataItem)localIterator.next();
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(String.valueOf(localApolloBoxDataItem.a))))
        {
          this.jdField_a_of_type_Int += 1;
          if (this.b == null) {
            this.b = new ArrayList();
          }
          this.b.add(localApolloBoxDataItem);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloBoxData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */