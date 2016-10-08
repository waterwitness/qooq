package com.tencent.mobileqq.search.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import uln;

public class ContactSearchModelGlobalTroop
  extends IContactSearchModel
{
  private static final int jdField_b_of_type_Int = 10;
  private static final int jdField_c_of_type_Int = 66;
  private static final int d = 88;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public String a;
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  private long jdField_c_of_type_Long;
  private List jdField_c_of_type_JavaUtilList;
  
  public ContactSearchModelGlobalTroop(QQAppInterface paramQQAppInterface, int paramInt, String paramString, List paramList)
  {
    super(paramQQAppInterface, paramInt, 0L);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Long = IContactSearchable.P;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramQQAppInterface.a().a().a(paramString)) {
      this.jdField_c_of_type_Long = IContactSearchable.Q;
    }
  }
  
  private long a(List paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int[] arrayOfInt = new int[paramList.size()];
    HashMap localHashMap3 = new HashMap();
    int i = 0;
    long l1;
    int j;
    Object localObject;
    long l2;
    while (i < paramList.size())
    {
      l1 = Long.MIN_VALUE;
      j = 0;
      while (j < ((List)paramList.get(i)).size())
      {
        localObject = ((uln)((List)paramList.get(i)).get(j)).jdField_a_of_type_ComTencentMobileqqSearchModelContactSearchModelGlobalTroop$TroopSearchMemberInfo;
        if (!localHashMap3.containsKey(localObject))
        {
          localHashMap3.put(localObject, Integer.valueOf(-1));
          localHashMap1.put(localObject, Long.valueOf(0L));
        }
        l2 = l1;
        if (((uln)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long > l1) {
          l2 = ((uln)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long;
        }
        j += 1;
        l1 = l2;
      }
      arrayOfLong[i] = l1;
      i += 1;
    }
    i = 0;
    HashSet localHashSet;
    Iterator localIterator;
    label330:
    label383:
    ContactSearchModelGlobalTroop.TroopSearchMemberInfo localTroopSearchMemberInfo;
    if (i < paramList.size())
    {
      localObject = new boolean[paramList.size()];
      Arrays.fill((boolean[])localObject, false);
      localHashSet = new HashSet();
      localIterator = localHashMap1.keySet().iterator();
      while (localIterator.hasNext())
      {
        localHashMap2.put((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localIterator.next(), Long.valueOf(Long.MAX_VALUE));
        continue;
        localHashSet.clear();
        Arrays.fill((boolean[])localObject, false);
      }
      if (!a(i, paramList, arrayOfLong, localHashMap1, arrayOfInt, localHashMap3, (boolean[])localObject, localHashSet, localHashMap2))
      {
        localIterator = localHashMap2.keySet().iterator();
        l1 = Long.MAX_VALUE;
        while (localIterator.hasNext())
        {
          localTroopSearchMemberInfo = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localIterator.next();
          if (!localHashSet.contains(localTroopSearchMemberInfo))
          {
            l2 = ((Long)localHashMap2.get(localTroopSearchMemberInfo)).longValue();
            if (l2 >= l1) {
              break label791;
            }
            l1 = l2;
          }
        }
      }
    }
    label791:
    for (;;)
    {
      break label383;
      if ((l1 == Long.MAX_VALUE) || (l1 == 0L))
      {
        l2 = Long.MIN_VALUE;
        return l2;
      }
      j = 0;
      if (j <= i)
      {
        if (localObject[j] == 0) {}
        for (;;)
        {
          j += 1;
          break;
          arrayOfLong[j] -= l1;
        }
      }
      localIterator = localHashMap1.keySet().iterator();
      while (localIterator.hasNext())
      {
        localTroopSearchMemberInfo = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localIterator.next();
        if (!localHashSet.contains(localTroopSearchMemberInfo)) {
          localHashMap2.put(localTroopSearchMemberInfo, Long.valueOf(((Long)localHashMap2.get(localTroopSearchMemberInfo)).longValue() - l1));
        } else {
          localHashMap1.put(localTroopSearchMemberInfo, Long.valueOf(((Long)localHashMap1.get(localTroopSearchMemberInfo)).longValue() + l1));
        }
      }
      break label330;
      i += 1;
      break;
      l1 = Long.MIN_VALUE;
      i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= paramList.size()) {
          break;
        }
        long l3 = ((uln)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Long;
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        this.jdField_a_of_type_JavaUtilSet.add(((uln)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_ComTencentMobileqqSearchModelContactSearchModelGlobalTroop$TroopSearchMemberInfo);
        this.jdField_b_of_type_JavaUtilList.add(((uln)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_JavaLangString);
        i += 1;
        l1 = l2;
      }
    }
  }
  
  private void a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localSpannableStringBuilder.append("包含: ");
      int j = this.jdField_b_of_type_JavaUtilList.size() - 1;
      int i = 0;
      if (j >= 0)
      {
        k = 1;
        label45:
        if (i >= 10) {
          break label127;
        }
      }
      label127:
      for (int m = 1;; m = 0)
      {
        if ((m & k) == 0) {
          break label133;
        }
        localSpannableStringBuilder.append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.jdField_c_of_type_JavaUtilList.get(j), 6, false));
        i += 1;
        localSpannableStringBuilder.append("、");
        j -= 1;
        break;
        k = 0;
        break label45;
      }
      label133:
      int k = 0;
      j = i;
      i = k;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        k = 1;
        label158:
        if (j >= 10) {
          break label285;
        }
        m = 1;
        label168:
        if ((m & k) == 0) {
          break label319;
        }
        localObject = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        k = j;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
        {
          if (this.jdField_c_of_type_JavaUtilList.size() != 1) {
            break label291;
          }
          m = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Int;
          label226:
          if (m != 66) {
            break label300;
          }
        }
      }
      for (Object localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).c;; localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_JavaLangString)
      {
        k = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          k = j + 1;
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.append("、");
        }
        label285:
        label291:
        label300:
        do
        {
          i += 1;
          j = k;
          break;
          k = 0;
          break label158;
          m = 0;
          break label168;
          m = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_Int;
          break label226;
          k = j;
        } while (m != 88);
      }
    }
    label319:
    if ((localSpannableStringBuilder.length() > 0) && (localSpannableStringBuilder.charAt(localSpannableStringBuilder.length() - 1) == '、'))
    {
      this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1);
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder;
  }
  
  static boolean a(int paramInt, List paramList, long[] paramArrayOfLong, Map paramMap1, int[] paramArrayOfInt, Map paramMap2, boolean[] paramArrayOfBoolean, Set paramSet, Map paramMap3)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    if (i < ((List)paramList.get(paramInt)).size())
    {
      ContactSearchModelGlobalTroop.TroopSearchMemberInfo localTroopSearchMemberInfo = ((uln)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_ComTencentMobileqqSearchModelContactSearchModelGlobalTroop$TroopSearchMemberInfo;
      if (paramSet.contains(localTroopSearchMemberInfo)) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localTroopSearchMemberInfo)).longValue() - ((uln)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Long;
        if (l == 0L)
        {
          paramSet.add(localTroopSearchMemberInfo);
          int j = ((Integer)paramMap2.get(localTroopSearchMemberInfo)).intValue();
          if ((j == -1) || (a(j, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap2, paramArrayOfBoolean, paramSet, paramMap3)))
          {
            paramMap2.put(localTroopSearchMemberInfo, Integer.valueOf(paramInt));
            paramArrayOfInt[paramInt] = i;
            return true;
          }
        }
        else if (l < ((Long)paramMap3.get(localTroopSearchMemberInfo)).longValue())
        {
          paramMap3.put(localTroopSearchMemberInfo, Long.valueOf(l));
        }
      }
    }
    return false;
  }
  
  private Object[] a(ContactSearchModelGlobalTroop.TroopSearchMemberInfo paramTroopSearchMemberInfo, String paramString)
  {
    String str = null;
    long l1 = Long.MIN_VALUE;
    long l2 = SearchUtils.a(paramString, paramTroopSearchMemberInfo.c, IContactSearchable.o, false, false, true);
    if (l2 > Long.MIN_VALUE)
    {
      str = paramTroopSearchMemberInfo.c;
      paramTroopSearchMemberInfo.jdField_a_of_type_Int = 66;
      l1 = l2;
    }
    long l3 = SearchUtils.a(paramString, paramTroopSearchMemberInfo.jdField_b_of_type_JavaLangString, IContactSearchable.j, false, false, true);
    l2 = l1;
    if (l3 > l1)
    {
      str = paramTroopSearchMemberInfo.jdField_b_of_type_JavaLangString;
      paramTroopSearchMemberInfo.jdField_a_of_type_Int = 88;
      l2 = l3;
    }
    return new Object[] { Long.valueOf(l2), str };
  }
  
  private long c(String paramString)
  {
    paramString = paramString.split("\\s+");
    if ((paramString != null) && (paramString.length >= 2))
    {
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      while (i < paramString.length)
      {
        this.jdField_c_of_type_JavaUtilList.add(paramString[i]);
        ArrayList localArrayList2 = new ArrayList();
        localArrayList1.add(localArrayList2);
        int j = 0;
        while (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          Object[] arrayOfObject = a((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject, paramString[i]);
          long l = ((Long)arrayOfObject[0]).longValue();
          if ((((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Long == Long.MIN_VALUE) || (l > ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Long))
          {
            ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Long = l;
            ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_Int = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Int;
          }
          if (l != Long.MIN_VALUE)
          {
            localObject = new uln();
            ((uln)localObject).jdField_a_of_type_Long = l;
            ((uln)localObject).jdField_a_of_type_JavaLangString = ((String)arrayOfObject[1]);
            ((uln)localObject).jdField_a_of_type_ComTencentMobileqqSearchModelContactSearchModelGlobalTroop$TroopSearchMemberInfo = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j));
            localArrayList2.add(localObject);
          }
          j += 1;
        }
        if (localArrayList2.isEmpty()) {
          return Long.MIN_VALUE;
        }
        i += 1;
      }
      return a(localArrayList1);
    }
    return Long.MIN_VALUE;
  }
  
  public int a()
  {
    return 4;
  }
  
  public long a()
  {
    return super.a();
  }
  
  protected long a(String paramString)
  {
    Object localObject1 = null;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = Long.MIN_VALUE;
    int i = 0;
    long l1 = Long.MIN_VALUE;
    Object localObject2 = null;
    Object localObject3;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject3 = a((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramString);
      long l2 = ((Long)localObject3[0]).longValue();
      if (l2 <= l1) {
        break label276;
      }
      localObject2 = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      localObject1 = (String)localObject3[1];
      l1 = l2;
    }
    for (;;)
    {
      i += 1;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaUtilSet.add(localObject1);
        this.jdField_b_of_type_JavaUtilList.add(localObject2);
        this.jdField_c_of_type_JavaUtilList.add(paramString);
      }
      if (l1 > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l1;
      }
      if (this.jdField_b_of_type_Long == Long.MIN_VALUE)
      {
        l1 = c(paramString);
        if (l1 > this.jdField_b_of_type_Long) {
          this.jdField_b_of_type_Long = l1;
        }
      }
      if (this.jdField_b_of_type_Long != Long.MIN_VALUE)
      {
        this.jdField_b_of_type_Long += this.jdField_c_of_type_Long;
        a();
      }
      return this.jdField_b_of_type_Long;
      label276:
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    if (SearchUtils.a(this.jdField_a_of_type_Int))
    {
      String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
      RecentUtil.a = true;
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 1, str, false);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_JavaLangString, "", 1);
      SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, 2, paramView);
      SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, paramView, false);
      SearchUtils.a(this, paramView);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String c()
  {
    return ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\ContactSearchModelGlobalTroop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */