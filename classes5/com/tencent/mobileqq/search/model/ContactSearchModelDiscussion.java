package com.tencent.mobileqq.search.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
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
import ulm;

public class ContactSearchModelDiscussion
  extends IContactSearchModel
{
  private static final int jdField_b_of_type_Int = 10;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private DiscussionInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet;
  boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private List jdField_c_of_type_JavaUtilList;
  
  public ContactSearchModelDiscussion(QQAppInterface paramQQAppInterface, int paramInt1, DiscussionInfo paramDiscussionInfo, List paramList, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramInt2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Long = IContactSearchable.H;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    if (!paramDiscussionInfo.hasRenamed()) {}
    for (bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
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
        localObject = ((ulm)((List)paramList.get(i)).get(j)).jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
        if (!localHashMap3.containsKey(localObject))
        {
          localHashMap3.put(localObject, Integer.valueOf(-1));
          localHashMap1.put(localObject, Long.valueOf(0L));
        }
        l2 = l1;
        if (((ulm)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long > l1) {
          l2 = ((ulm)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long;
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
    DiscussionMemberInfo localDiscussionMemberInfo;
    if (i < paramList.size())
    {
      localObject = new boolean[paramList.size()];
      Arrays.fill((boolean[])localObject, false);
      localHashSet = new HashSet();
      localIterator = localHashMap1.keySet().iterator();
      while (localIterator.hasNext())
      {
        localHashMap2.put((DiscussionMemberInfo)localIterator.next(), Long.valueOf(Long.MAX_VALUE));
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
          localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
          if (!localHashSet.contains(localDiscussionMemberInfo))
          {
            l2 = ((Long)localHashMap2.get(localDiscussionMemberInfo)).longValue();
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
        localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
        if (!localHashSet.contains(localDiscussionMemberInfo)) {
          localHashMap2.put(localDiscussionMemberInfo, Long.valueOf(((Long)localHashMap2.get(localDiscussionMemberInfo)).longValue() - l1));
        } else {
          localHashMap1.put(localDiscussionMemberInfo, Long.valueOf(((Long)localHashMap1.get(localDiscussionMemberInfo)).longValue() + l1));
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
        long l3 = ((ulm)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Long;
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        this.jdField_a_of_type_JavaUtilSet.add(((ulm)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo);
        this.jdField_b_of_type_JavaUtilList.add(((ulm)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_JavaLangString);
        i += 1;
        l1 = l2;
      }
    }
  }
  
  private void a()
  {
    int i = 0;
    int n = 0;
    if ((SearchUtils.a(this.jdField_a_of_type_Int)) || (this.jdField_a_of_type_Int == 5))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localSpannableStringBuilder.append("包含: ");
        int j = this.jdField_b_of_type_JavaUtilList.size() - 1;
        i = 0;
        if (j >= 0)
        {
          k = 1;
          label68:
          if (i >= 10) {
            break label162;
          }
        }
        label162:
        for (int m = 1;; m = 0)
        {
          if ((m & k) == 0) {
            break label168;
          }
          localSpannableStringBuilder.append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.jdField_c_of_type_JavaUtilList.get(j), 6));
          i += 1;
          if (i < this.jdField_a_of_type_JavaUtilList.size()) {
            localSpannableStringBuilder.append("、");
          }
          j -= 1;
          break;
          k = 0;
          break label68;
        }
        label168:
        int k = 0;
        j = i;
        i = k;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          k = 1;
          label193:
          if (j >= 10) {
            break label323;
          }
          m = 1;
          label203:
          if ((m & k) == 0) {
            break label337;
          }
          localObject = (DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          k = j;
          if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject)) {
            if (((DiscussionMemberInfo)localObject).inteRemark == null) {
              break label329;
            }
          }
        }
        label323:
        label329:
        for (localObject = ((DiscussionMemberInfo)localObject).inteRemark;; localObject = ((DiscussionMemberInfo)localObject).memberName)
        {
          k = j;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            j += 1;
            localSpannableStringBuilder.append((CharSequence)localObject);
            k = j;
            if (j < this.jdField_a_of_type_JavaUtilList.size())
            {
              localSpannableStringBuilder.append("、");
              k = j;
            }
          }
          i += 1;
          j = k;
          break;
          k = 0;
          break label193;
          m = 0;
          break label203;
        }
      }
      label337:
      this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder;
      localObject = new StringBuilder().append("(");
      i = n;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
      this.jdField_b_of_type_JavaLangCharSequence = (i + ")");
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = "多人聊天";
    Object localObject = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject).append("(");
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = this.jdField_a_of_type_JavaUtilList.size();
    }
    ((SpannableStringBuilder)localObject).append(String.valueOf(i));
    ((SpannableStringBuilder)localObject).append(")");
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      ((SpannableStringBuilder)localObject).append("(");
      i = this.jdField_b_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        ((SpannableStringBuilder)localObject).append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(i), (String)this.jdField_c_of_type_JavaUtilList.get(i), 6));
        if (i > 0) {
          ((SpannableStringBuilder)localObject).append("、");
        }
        i -= 1;
      }
      ((SpannableStringBuilder)localObject).append(")");
    }
    this.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject);
  }
  
  static boolean a(int paramInt, List paramList, long[] paramArrayOfLong, Map paramMap1, int[] paramArrayOfInt, Map paramMap2, boolean[] paramArrayOfBoolean, Set paramSet, Map paramMap3)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    if (i < ((List)paramList.get(paramInt)).size())
    {
      DiscussionMemberInfo localDiscussionMemberInfo = ((ulm)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
      if (paramSet.contains(localDiscussionMemberInfo)) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localDiscussionMemberInfo)).longValue() - ((ulm)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Long;
        if (l == 0L)
        {
          paramSet.add(localDiscussionMemberInfo);
          int j = ((Integer)paramMap2.get(localDiscussionMemberInfo)).intValue();
          if ((j == -1) || (a(j, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap2, paramArrayOfBoolean, paramSet, paramMap3)))
          {
            paramMap2.put(localDiscussionMemberInfo, Integer.valueOf(paramInt));
            paramArrayOfInt[paramInt] = i;
            return true;
          }
        }
        else if (l < ((Long)paramMap3.get(localDiscussionMemberInfo)).longValue())
        {
          paramMap3.put(localDiscussionMemberInfo, Long.valueOf(l));
        }
      }
    }
    return false;
  }
  
  private Object[] a(DiscussionMemberInfo paramDiscussionMemberInfo, String paramString)
  {
    long l2 = SearchUtils.a(paramString, paramDiscussionMemberInfo.inteRemark, IContactSearchable.i);
    if (l2 > Long.MIN_VALUE) {}
    for (String str = paramDiscussionMemberInfo.inteRemark;; str = null)
    {
      long l3 = SearchUtils.a(paramString, paramDiscussionMemberInfo.memberName, IContactSearchable.j);
      long l1 = l2;
      if (l3 > l2)
      {
        str = paramDiscussionMemberInfo.memberName;
        l1 = l3;
      }
      Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramDiscussionMemberInfo.memberUin);
      l3 = l1;
      paramDiscussionMemberInfo = str;
      if (localFriends != null)
      {
        l3 = l1;
        paramDiscussionMemberInfo = str;
        if (localFriends.isFriend())
        {
          l3 = SearchUtils.a(paramString, localFriends.remark, IContactSearchable.h);
          l2 = l1;
          paramDiscussionMemberInfo = str;
          if (l3 > l1)
          {
            paramDiscussionMemberInfo = localFriends.remark;
            l2 = l3;
          }
          l1 = SearchUtils.a(paramString, localFriends.name, IContactSearchable.j);
          l3 = l2;
          if (l1 > l2)
          {
            paramDiscussionMemberInfo = localFriends.name;
            l3 = l1;
          }
        }
      }
      return new Object[] { Long.valueOf(l3), paramDiscussionMemberInfo };
      l2 = Long.MIN_VALUE;
    }
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
          Object[] arrayOfObject = a((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j), paramString[i]);
          long l = ((Long)arrayOfObject[0]).longValue();
          if (l != Long.MIN_VALUE)
          {
            ulm localulm = new ulm();
            localulm.jdField_a_of_type_Long = l;
            localulm.jdField_a_of_type_JavaLangString = ((String)arrayOfObject[1]);
            localulm.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo = ((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j));
            localArrayList2.add(localulm);
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
    return 101;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = Long.MIN_VALUE;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName, IContactSearchable.e);
      if (l1 > this.jdField_b_of_type_Long)
      {
        this.jdField_b_of_type_Long = l1;
        this.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject2 = null;
    Object localObject1 = null;
    long l1 = Long.MIN_VALUE;
    int i = 0;
    Object localObject3;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject3 = a((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramString);
      long l2 = ((Long)localObject3[0]).longValue();
      if (l2 <= l1) {
        break label541;
      }
      localObject1 = (DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      localObject2 = (String)localObject3[1];
      l1 = l2;
    }
    for (;;)
    {
      i += 1;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaUtilSet.add(localObject2);
        this.jdField_b_of_type_JavaUtilList.add(localObject1);
        this.jdField_c_of_type_JavaUtilList.add(paramString);
      }
      if (l1 > this.jdField_b_of_type_Long)
      {
        this.jdField_b_of_type_Long = l1;
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_b_of_type_Long == Long.MIN_VALUE)
      {
        l1 = c(paramString);
        if (l1 > this.jdField_b_of_type_Long)
        {
          this.jdField_b_of_type_Long = l1;
          this.jdField_a_of_type_Boolean = false;
        }
      }
      if (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_a_of_type_JavaUtilList.size())
      {
        i = 1;
        this.jdField_c_of_type_Long = IContactSearchable.y;
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (i != 0)
        {
          this.jdField_c_of_type_Long = IContactSearchable.w;
          label356:
          if (this.jdField_b_of_type_Long != Long.MIN_VALUE)
          {
            this.jdField_b_of_type_Long += this.jdField_c_of_type_Long;
            a();
          }
          return this.jdField_b_of_type_Long;
        }
      }
      else
      {
        if (this.jdField_a_of_type_JavaUtilSet.size() != this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break label529;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
        } while ((paramString == null) || (!paramString.equals(((DiscussionMemberInfo)localObject2).memberUin)));
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          i = 1;
          break;
          if (paramString.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin))
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_c_of_type_Long = IContactSearchable.y;
              break label356;
            }
            this.jdField_c_of_type_Long = IContactSearchable.G;
            break label356;
          }
          this.jdField_c_of_type_Long = IContactSearchable.H;
          break label356;
        }
        label529:
        i = 0;
        break;
      }
      label541:
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public CharSequence a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return c();
    }
    return super.a();
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
  }
  
  public void a(View paramView)
  {
    if (SearchUtils.a(this.jdField_a_of_type_Int))
    {
      RecentUtil.jdField_a_of_type_Boolean = true;
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, 3000, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName, false);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, "", 3000);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 3, paramView);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 30, paramView, false);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString);
      SearchUtils.a(this, paramView);
      return;
    }
    SearchUtils.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 3000;
  }
  
  public CharSequence b()
  {
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public CharSequence c()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String c()
  {
    return ContactUtils.a(BaseApplicationImpl.a, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangCharSequence.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\ContactSearchModelDiscussion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */