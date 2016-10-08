package com.tencent.biz.pubaccount.readinjoy.model;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SpecialChannelFilter
{
  private static SpecialChannelFilter jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSpecialChannelFilter;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean;
  
  public SpecialChannelFilter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static SpecialChannelFilter a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSpecialChannelFilter == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSpecialChannelFilter == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSpecialChannelFilter = new SpecialChannelFilter();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSpecialChannelFilter;
    }
    finally {}
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return (ChannelInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, String paramString, List paramList1, List paramList2, ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(paramInt) >= 0) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramList1.contains(Integer.valueOf(paramInt))) {}
    label122:
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      if (paramChannelInfo != null) {}
      for (;;)
      {
        if (paramChannelInfo == null) {
          break label122;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramChannelInfo.mChannelID, paramChannelInfo);
        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramChannelInfo.mChannelID));
        break;
        paramChannelInfo = new ChannelInfo();
        paramChannelInfo.mChannelID = paramInt;
        paramList1 = paramString;
        if (paramString == null) {
          paramList1 = " ";
        }
        paramChannelInfo.mChannelName = paramList1;
        paramChannelInfo.mShow = true;
        paramChannelInfo.mSortOrder = 0;
      }
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((Integer)paramList.next()).intValue();
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(i));
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    label19:
    int k;
    if (i < j)
    {
      k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      if (!paramList.contains(Integer.valueOf(k))) {
        break label56;
      }
    }
    for (;;)
    {
      i += 1;
      break label19;
      break;
      label56:
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(k))) {
        if (ReadInJoyUtils.c(k))
        {
          if (paramBoolean) {
            paramList.add(0, Integer.valueOf(k));
          }
        }
        else {
          paramList.add(Integer.valueOf(k));
        }
      }
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        if ((!ReadInJoyUtils.c(k)) && (!paramList.contains(Integer.valueOf(k)))) {
          localArrayList.add(Integer.valueOf(k));
        }
        i += 1;
      }
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        i = ((Integer)paramList.next()).intValue();
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
        this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(i));
      }
    }
  }
  
  public void b(List paramList, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    label19:
    int k;
    if (i < j)
    {
      k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      if (!paramList.contains(Integer.valueOf(k))) {
        break label56;
      }
    }
    for (;;)
    {
      i += 1;
      break label19;
      break;
      label56:
      if (ReadInJoyUtils.c(k))
      {
        if (paramBoolean) {
          paramList.add(0, Integer.valueOf(k));
        }
      }
      else {
        paramList.add(Integer.valueOf(k));
      }
    }
  }
  
  public void c(List paramList)
  {
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    if (i < j)
    {
      int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      if (paramList.contains(Integer.valueOf(k))) {
        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(k));
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(k));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\model\SpecialChannelFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */