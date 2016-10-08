package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RecentItemBuilderFactory
{
  protected static final int A = 2;
  protected static final int B = 3;
  protected static final int C = 1;
  protected static final int D = 2;
  protected static final int E = 3;
  protected static final int F = 1;
  protected static final int G = 2;
  protected static final int H = 1;
  protected static final int I = 2;
  protected static final int J = 3;
  protected static final int K = 4;
  protected static final int L = 5;
  protected static final int M = 6;
  protected static final int N = 7;
  protected static final int O = 8;
  protected static final int P = 9;
  protected static final int Q = 10;
  public static final int a = 0;
  public static final Long a;
  protected static final int[] a;
  public static final int b = 1;
  public static final Long b;
  protected static final int[] b;
  public static final int c = 3;
  public static final Long c;
  protected static final int[] c;
  public static final int d = 4;
  public static final Long d;
  protected static final int[] d;
  public static final int e = 5;
  public static final Long e;
  protected static final int[] e;
  public static final int f = 6;
  public static final Long f;
  protected static final int[] f;
  public static final int g = 7;
  public static final Long g;
  protected static final int[] g;
  public static final int h = 8;
  protected static final int[] h = { 0, 1, 2 };
  public static final int i = 9;
  protected static final int[] i = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 12;
  public static final int m = 0;
  public static final int n = 1;
  public static final int o = 4;
  public static final int p = 5;
  public static final int q = 6;
  public static final int r = 7;
  public static final int s = 9;
  protected static final int t = 0;
  protected static final int u = 1;
  protected static final int v = 2;
  protected static final int w = 1;
  protected static final int x = 2;
  protected static final int y = 1;
  protected static final int z = 1;
  protected int R;
  protected RecentAdapter a;
  protected RecentItemBaseBuilder[] a;
  protected int[] j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    jdField_b_of_type_JavaLangLong = Long.valueOf(1L);
    jdField_c_of_type_JavaLangLong = Long.valueOf(2L);
    jdField_d_of_type_JavaLangLong = Long.valueOf(3L);
    jdField_e_of_type_JavaLangLong = Long.valueOf(4L);
    jdField_f_of_type_JavaLangLong = Long.valueOf(5L);
    jdField_g_of_type_JavaLangLong = Long.valueOf(6L);
    jdField_a_of_type_ArrayOfInt = new int[] { 0 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 1, 2 };
    jdField_c_of_type_ArrayOfInt = new int[] { 0, 1, 2 };
    jdField_d_of_type_ArrayOfInt = new int[] { 0, 1 };
    jdField_e_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
    jdField_f_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
    jdField_g_of_type_ArrayOfInt = new int[] { 0, 1, 2 };
  }
  
  public RecentItemBuilderFactory(int paramInt)
  {
    this.R = paramInt;
    if (this.R == 0) {
      this.j = jdField_b_of_type_ArrayOfInt;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder = new RecentItemBaseBuilder[this.j.length];
      return;
      if (this.R == 1) {
        this.j = jdField_e_of_type_ArrayOfInt;
      } else if (this.R == 4) {
        this.j = i;
      } else if (this.R == 5) {
        this.j = h;
      } else if (this.R == 6) {
        this.j = jdField_c_of_type_ArrayOfInt;
      } else if (this.R == 7) {
        this.j = jdField_d_of_type_ArrayOfInt;
      } else if (this.R == 9) {
        this.j = jdField_g_of_type_ArrayOfInt;
      } else {
        this.j = jdField_a_of_type_ArrayOfInt;
      }
    }
  }
  
  public int a()
  {
    return this.R;
  }
  
  public int a(Object paramObject)
  {
    int i1 = this.j[0];
    switch (this.R)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return i1;
                          if (!(paramObject instanceof Integer)) {
                            break;
                          }
                        } while (((Integer)paramObject).intValue() != 0);
                        return this.j[1];
                        if ((paramObject instanceof RecentUserBaseData)) {
                          return this.j[2];
                        }
                      } while (!(paramObject instanceof String));
                      return this.j[0];
                      if (!(paramObject instanceof Integer)) {
                        break;
                      }
                      paramObject = (Integer)paramObject;
                      if (((Integer)paramObject).intValue() == 3) {
                        return this.j[3];
                      }
                      if (((Integer)paramObject).intValue() == 4) {
                        return this.j[1];
                      }
                    } while (((Integer)paramObject).intValue() != 5);
                    return this.j[1];
                  } while (!(paramObject instanceof RecentBaseData));
                  return this.j[2];
                  if (!(paramObject instanceof Integer)) {
                    break;
                  }
                  paramObject = (Integer)paramObject;
                  if (((Integer)paramObject).intValue() == 11) {
                    return this.j[1];
                  }
                } while (((Integer)paramObject).intValue() != 12);
                return this.j[1];
              } while (!(paramObject instanceof RecentBaseData));
              return this.j[2];
              if (!(paramObject instanceof Long)) {
                break;
              }
              paramObject = (Long)paramObject;
              if (jdField_a_of_type_JavaLangLong == paramObject) {
                return this.j[1];
              }
              if (jdField_b_of_type_JavaLangLong == paramObject) {
                return this.j[6];
              }
              if (jdField_d_of_type_JavaLangLong == paramObject) {
                return this.j[5];
              }
              if (jdField_e_of_type_JavaLangLong == paramObject) {
                return this.j[7];
              }
              if (jdField_c_of_type_JavaLangLong == paramObject) {
                return this.j[8];
              }
              if (jdField_f_of_type_JavaLangLong == paramObject) {
                return this.j[9];
              }
            } while (jdField_g_of_type_JavaLangLong != paramObject);
            return this.j[10];
            if ((paramObject instanceof Integer)) {
              return this.j[2];
            }
            if ((paramObject instanceof RecentBaseData))
            {
              i1 = ((RecentBaseData)paramObject).a();
              int i2 = ((RecentBaseData)paramObject).I;
              if ((i1 == 8) || ((i1 == 26) && (i2 != 2))) {
                return this.j[4];
              }
              return this.j[3];
            }
          } while (!(paramObject instanceof String));
          return this.j[0];
          if ((paramObject instanceof Integer)) {
            return this.j[1];
          }
        } while (!(paramObject instanceof RecentBaseData));
        return this.j[2];
        if ((paramObject instanceof String)) {
          return this.j[0];
        }
        if ((paramObject instanceof RecentSayHelloBoxItem)) {
          return this.j[2];
        }
      } while (!(paramObject instanceof RecentMsgBoxItem));
      return this.j[1];
      if ((paramObject instanceof String)) {
        return this.j[0];
      }
    } while (!(paramObject instanceof RecentSayHelloListItem));
    return this.j[1];
  }
  
  public RecentItemBaseBuilder a(Object paramObject)
  {
    Object localObject = null;
    int i1 = a(paramObject);
    if (this.R == 0) {
      if (i1 == 1)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentEmptyItemBuilder();
        }
        paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
      }
    }
    for (;;)
    {
      localObject = paramObject;
      if (paramObject == null)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[0] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[0] = new RecentBlankItemBuilder();
        }
        localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[0];
      }
      ((RecentItemBaseBuilder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      return (RecentItemBaseBuilder)localObject;
      paramObject = localObject;
      if (i1 == 2)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentEfficientItemBuilder();
        }
        paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
        continue;
        if (this.R == 1)
        {
          if (i1 == 1)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
          }
          else if (i1 == 2)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
          }
          else
          {
            paramObject = localObject;
            if (i1 == 3)
            {
              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] == null) {
                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] = new TroopAssistantEducationBuilder();
              }
              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
            }
          }
        }
        else if (this.R == 9)
        {
          if (i1 == 1)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
          }
          else
          {
            paramObject = localObject;
            if (i1 == 2)
            {
              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
              }
              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
            }
          }
        }
        else if (this.R == 4)
        {
          if (i1 == 6)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] = new RecentCallContactItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6];
          }
          else if (i1 == 5)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[5] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[5] = new RecentCallHuangyeItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[5];
          }
          else if (i1 == 7)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[7] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[7] = new RecentCallLightalkItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[7];
          }
          else if (i1 == 8)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[8] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[8] = new RecentCallHoldItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[8];
          }
          else if (i1 == 1)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentCallMoreItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
          }
          else if (i1 == 2)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentEmptyItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
          }
          else if (i1 == 3)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] = new RecentCallItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
          }
          else if (i1 == 4)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4] = new RecentCallItemBuilder(1);
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4];
          }
          else if (i1 == 9)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[9] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[9] = new RecentCallLightalkVipItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[9];
          }
          else
          {
            paramObject = localObject;
            if (i1 == 10)
            {
              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[10] == null) {
                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[10] = new RecentCallHoldItemBuilder();
              }
              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[10];
            }
          }
        }
        else if (this.R == 5)
        {
          if (i1 == 1)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentBlankItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
          }
          else
          {
            paramObject = localObject;
            if (i1 == 2)
            {
              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
              }
              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
            }
          }
        }
        else if (this.R == 6)
        {
          if (i1 == 2)
          {
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new SayHelloBoxItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
          }
          else
          {
            paramObject = localObject;
            if (i1 == 1)
            {
              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentDefaultItemBuilder();
              }
              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
            }
          }
        }
        else
        {
          paramObject = localObject;
          if (this.R == 7)
          {
            paramObject = localObject;
            if (i1 == 1)
            {
              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new SayHelloListItemBuilder();
              }
              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
            }
          }
        }
      }
    }
  }
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = paramRecentAdapter;
  }
  
  public int b()
  {
    return this.j.length;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentItemBuilderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */