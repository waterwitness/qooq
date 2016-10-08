package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mwa;
import mwb;
import mwc;

public class TroopMemberListActivity$ListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public int a;
  public String a;
  public LinkedHashMap a;
  public List a;
  public int[] a;
  public String[] a;
  public int b;
  
  public TroopMemberListActivity$ListAdapter(TroopMemberListActivity paramTroopMemberListActivity)
  {
    super(paramTroopMemberListActivity, paramTroopMemberListActivity.app, paramTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 11)) {
      paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131368006);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramTroopMemberListActivity;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 5) {
        paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131364878);
      } else {
        paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131367383);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 9) {
      return 0;
    }
    return 2130903393;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  protected Object a(int paramInt)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)getItem(paramInt);
    CharDividedFacePreloadBaseAdapter.FaceInfo localFaceInfo = new CharDividedFacePreloadBaseAdapter.FaceInfo(this);
    if (localATroopMember != null) {
      localFaceInfo.jdField_a_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
    }
    return localFaceInfo;
  }
  
  public String a(String[] paramArrayOfString, double paramDouble)
  {
    if (paramDouble == -100.0D) {
      return paramArrayOfString[8];
    }
    if (paramDouble <= 5000.0D) {
      return paramArrayOfString[0];
    }
    if (paramDouble <= 10000.0D) {
      return paramArrayOfString[1];
    }
    if (paramDouble <= 50000.0D) {
      return paramArrayOfString[2];
    }
    if (paramDouble <= 500000.0D) {
      return paramArrayOfString[3];
    }
    if (paramDouble <= 1000000.0D) {
      return paramArrayOfString[4];
    }
    if (paramDouble <= 2000000.0D) {
      return paramArrayOfString[5];
    }
    if (paramDouble <= 1.0E7D) {
      return paramArrayOfString[6];
    }
    return paramArrayOfString[7];
  }
  
  public String a(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    if (paramLong == 0L) {
      return paramArrayOfString[7];
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
    if (i <= 0) {
      return paramArrayOfString[0];
    }
    if (i <= 7) {
      return paramArrayOfString[1];
    }
    if (i <= 30) {
      return paramArrayOfString[2];
    }
    if (i <= 90) {
      return paramArrayOfString[3];
    }
    if (i <= 180) {
      return paramArrayOfString[4];
    }
    if (i <= 365) {
      return paramArrayOfString[5];
    }
    return paramArrayOfString[6];
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "mAdapter.notifyDataSetChanged2()");
    }
    Object[] arrayOfObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList);
    if (arrayOfObject.length >= 3)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)arrayOfObject[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])arrayOfObject[2]);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.runOnUiThread(new mwc(this));
    }
    while ((arrayOfObject.length != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J != 13)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 9)
    {
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      return;
    }
    paramInt = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramInt < 0) {
      paramInt = -(paramInt + 1) - 1;
    }
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      if ((localList != null) && (localList.size() > 1))
      {
        ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131367385, new Object[] { Integer.valueOf(localList.size()) }));
        return;
      }
      ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 9) {}
    while (Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) < 0) {
      return false;
    }
    return true;
  }
  
  public Object[] a(List paramList)
  {
    long l1 = System.currentTimeMillis();
    Object localObject4 = new LinkedHashMap();
    Object localObject6;
    Object localObject7;
    Object localObject5;
    ArrayList localArrayList1;
    TroopMemberListActivity.ATroopMember localATroopMember;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.W != 0) {
          break label1078;
        }
        localObject6 = new ArrayList();
        localObject7 = new ArrayList();
        localObject5 = new ArrayList();
        localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        this.b = 0;
        this.jdField_a_of_type_Int = 0;
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break label583;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator.next();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 12)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.E != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.E.contains(localATroopMember.jdField_a_of_type_JavaLangString))) {
            localArrayList2.add(localATroopMember);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.D != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.D.contains(localATroopMember.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilList.contains(localATroopMember))) {
            this.jdField_a_of_type_JavaUtilList.add(localATroopMember);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J != 13)
        {
          if ((localATroopMember.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d.contains(localATroopMember.jdField_a_of_type_JavaLangString))) {
            ((List)localObject6).add(localATroopMember);
          }
          if (localATroopMember.jdField_b_of_type_Boolean) {
            localArrayList1.add(localATroopMember);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Boolean) && (!localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.a())) && (localATroopMember.d == 1L)) {
            ((List)localObject7).add(localATroopMember);
          }
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n.equals(localATroopMember.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.o != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.o.contains(localATroopMember.jdField_a_of_type_JavaLangString))))
        {
          ((List)localObject5).add(localATroopMember);
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J != 5) {
          break;
        }
      }
      finally {}
      if (TextUtils.isEmpty(localATroopMember.u)) {
        break;
      }
      ((List)localObject5).add(localATroopMember);
    }
    Object localObject3;
    int i;
    label505:
    label512:
    Object localObject2;
    label583:
    int k;
    label744:
    label816:
    int j;
    label900:
    char c;
    if (localATroopMember.jdField_c_of_type_JavaLangString != null)
    {
      if (localATroopMember.jdField_c_of_type_JavaLangString.length() == 0) {
        break label3265;
      }
      for (;;)
      {
        localObject3 = localObject1;
        if (((String)localObject1).length() == 1)
        {
          i = ((String)localObject1).charAt(0);
          if ((65 > i) || (i > 90)) {
            break label3273;
          }
          localObject3 = ((String)localObject1).toUpperCase();
        }
        if (((LinkedHashMap)localObject4).get(localObject3) == null) {
          ((LinkedHashMap)localObject4).put(localObject3, new ArrayList());
        }
        this.b += 1;
        ((List)((LinkedHashMap)localObject4).get(localObject3)).add(localATroopMember);
        break;
        localObject2 = localATroopMember.jdField_c_of_type_JavaLangString.substring(0, 1);
      }
      localObject3 = new TroopMemberListActivity.MyComparator(0, true);
      localObject2 = new LinkedHashMap();
      if ((((List)localObject6).size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J != 12))
      {
        Collections.sort((List)localObject6, (Comparator)localObject3);
        ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131369584), localObject6);
      }
      if (localArrayList1.size() > 0)
      {
        Collections.sort(localArrayList1, (Comparator)localObject3);
        ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131369595), localArrayList1);
      }
      if (((List)localObject7).size() > 0)
      {
        Collections.sort((List)localObject7, (Comparator)localObject3);
        ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131367392), localObject7);
      }
      k = ((List)localObject5).size();
      if (k <= 0) {
        break label3325;
      }
      Collections.sort((List)localObject5, (Comparator)localObject3);
      i = 0;
      if (i >= k) {
        break label3298;
      }
      localObject6 = (TroopMemberListActivity.ATroopMember)((List)localObject5).get(i);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n.equals(((TroopMemberListActivity.ATroopMember)localObject6).jdField_a_of_type_JavaLangString))) {
        break label3316;
      }
      ((List)localObject5).remove(i);
      ((List)localObject5).add(0, localObject6);
      break label3298;
      if (j < k)
      {
        localObject6 = (TroopMemberListActivity.ATroopMember)((List)localObject5).get(j);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.o.contains(((TroopMemberListActivity.ATroopMember)localObject6).jdField_a_of_type_JavaLangString))
        {
          ((List)localObject5).remove(j);
          ((List)localObject5).add(i, localObject6);
          i += 1;
          break label3307;
        }
      }
      else
      {
        ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_JavaLangString, localObject5);
        break label3325;
        if (c <= 'Z')
        {
          if (((LinkedHashMap)localObject4).get(String.valueOf(c)) == null) {
            break label3332;
          }
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)((LinkedHashMap)localObject4).get(String.valueOf(c)), (Comparator)localObject3);
          ((LinkedHashMap)localObject2).put(String.valueOf(c), ((LinkedHashMap)localObject4).get(String.valueOf(c)));
          break label3332;
        }
        if (((LinkedHashMap)localObject4).get("#") != null)
        {
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)((LinkedHashMap)localObject4).get("#"), (Comparator)localObject3);
          ((LinkedHashMap)localObject2).put("#", ((LinkedHashMap)localObject4).get("#"));
        }
        ((LinkedHashMap)localObject4).clear();
        for (;;)
        {
          label1031:
          localObject3 = new int[((LinkedHashMap)localObject2).keySet().size()];
          localObject4 = new String[localObject3.length];
          localObject5 = ((LinkedHashMap)localObject2).keySet().iterator();
          if (localObject3.length != 0) {
            break label3037;
          }
          return new Object[0];
          label1078:
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.W == 1)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2131230751);
            localObject2 = Calendar.getInstance();
            ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
            localObject5 = paramList.iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject5).next();
              if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).r)) {
                ((TroopMemberListActivity.ATroopMember)localObject6).r = a((String[])localObject3, ((TroopMemberListActivity.ATroopMember)localObject6).jdField_b_of_type_Long, (Calendar)localObject2);
              }
              if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).r) == null) {
                ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject6).r, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).r)).add(localObject6);
            }
            localObject2 = new LinkedHashMap();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.m)
            {
              i = 0;
              label1257:
              if (i < localObject3.length)
              {
                if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
                  break label3342;
                }
                Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(1, true));
                ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
                break label3342;
              }
            }
            else
            {
              i = localObject3.length - 1;
              label1334:
              if (i >= 0)
              {
                if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
                  break label3351;
                }
                Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(1, false));
                ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
                break label3351;
              }
            }
            ((LinkedHashMap)localObject4).clear();
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.W == 4)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2131230773);
            localObject2 = Calendar.getInstance();
            ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
            localObject5 = paramList.iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject5).next();
              if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).q)) {
                ((TroopMemberListActivity.ATroopMember)localObject6).q = b((String[])localObject3, ((TroopMemberListActivity.ATroopMember)localObject6).jdField_a_of_type_Long, (Calendar)localObject2);
              }
              if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).q) == null) {
                ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject6).q, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).q)).add(localObject6);
            }
            localObject2 = new LinkedHashMap();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.m)
            {
              i = 0;
              label1588:
              if (i < localObject3.length)
              {
                if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
                  break label3360;
                }
                Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(4, true));
                ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
                break label3360;
              }
            }
            else
            {
              i = localObject3.length - 1;
              label1665:
              if (i >= 0)
              {
                if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
                  break label3369;
                }
                Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(4, false));
                ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
                break label3369;
              }
            }
            ((LinkedHashMap)localObject4).clear();
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.W == 2)
          {
            localObject2 = null;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap();
            }
            if ((localObject2 != null) && (((HashMap)localObject2).size() != 0)) {
              break label3259;
            }
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2131230777);
            localObject2 = new HashMap();
            i = 0;
            while (i < localObject3.length)
            {
              ((HashMap)localObject2).put(Integer.valueOf(i + 1), localObject3[i]);
              i += 1;
            }
            if (!QLog.isColorLevel()) {
              break label3378;
            }
            QLog.d("TroopMemberListActivityget_troop_member", 2, "constructHashStruct, SORT_BY_LEVEL, mTroopInfo.getTroopLevelMap is empty, use default");
            break label3378;
            label1869:
            localObject3 = new ArrayList(((HashMap)localObject2).entrySet());
            Collections.sort((List)localObject3, new mwb(this));
            localObject5 = paramList.iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject5).next();
              if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).s)) {
                ((TroopMemberListActivity.ATroopMember)localObject6).s = ((String)((HashMap)localObject2).get(Integer.valueOf(((TroopMemberListActivity.ATroopMember)localObject6).jdField_a_of_type_Int)));
              }
              if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).s) == null) {
                ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject6).s, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).s)).add(localObject6);
            }
            localObject2 = new LinkedHashMap();
            j = ((List)localObject3).size();
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.m) {
              break label3390;
            }
            i = j - 1;
            label2047:
            if (i >= 0)
            {
              localObject5 = (String)((Map.Entry)((List)localObject3).get(i)).getValue();
              if ((localObject5 == null) || (((LinkedHashMap)localObject4).get(localObject5) == null)) {
                break label3381;
              }
              Collections.sort((List)((LinkedHashMap)localObject4).get(localObject5), new TroopMemberListActivity.MyComparator(2, false));
              ((LinkedHashMap)localObject2).put(localObject5, ((LinkedHashMap)localObject4).get(localObject5));
              break label3381;
              label2129:
              if (i < j)
              {
                localObject5 = (String)((Map.Entry)((List)localObject3).get(i)).getValue();
                if ((localObject5 == null) || (((LinkedHashMap)localObject4).get(localObject5) == null)) {
                  break label3396;
                }
                Collections.sort((List)((LinkedHashMap)localObject4).get(localObject5), new TroopMemberListActivity.MyComparator(2, true));
                ((LinkedHashMap)localObject2).put(localObject5, ((LinkedHashMap)localObject4).get(localObject5));
                break label3396;
              }
            }
            ((LinkedHashMap)localObject4).clear();
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.W != 3) {
              break;
            }
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2131230778);
            localObject2 = paramList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject5 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject2).next();
              if (((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_Double == -100.0D)
              {
                double d = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k, ((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_JavaLangString);
                ((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_Double = d;
                if (d == -1000.0D) {
                  ((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_Double = -100.0D;
                }
                if (((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.a())) {
                  ((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_Double = 0.0D;
                }
              }
              if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject5).t)) {
                ((TroopMemberListActivity.ATroopMember)localObject5).t = a((String[])localObject3, ((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_Double);
              }
              if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject5).t) == null) {
                ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject5).t, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject5).t)).add(localObject5);
            }
            localObject2 = new LinkedHashMap();
            i = 0;
            label2463:
            if (i < localObject3.length)
            {
              if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
                break label3405;
              }
              Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(3, true));
              ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
              break label3405;
            }
            ((LinkedHashMap)localObject4).clear();
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.W == 5)
        {
          localObject5 = new ArrayList();
          localObject3 = new ArrayList();
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject2).next();
            if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).v) == null) {
              ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject6).v, new ArrayList());
            }
            localObject7 = ChnToSpell.a(((TroopMemberListActivity.ATroopMember)localObject6).v, 2);
            ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).v)).add(localObject6);
            if ((!((List)localObject5).contains(((TroopMemberListActivity.ATroopMember)localObject6).v)) && (localObject7 != null) && (((String)localObject7).length() != 0) && (!TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).v))) {
              ((List)localObject5).add(((TroopMemberListActivity.ATroopMember)localObject6).v);
            } else if ((!((List)localObject3).contains(((TroopMemberListActivity.ATroopMember)localObject6).v)) && ((localObject7 == null) || (((String)localObject7).length() == 0)) && (!TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).v))) {
              ((List)localObject3).add(((TroopMemberListActivity.ATroopMember)localObject6).v);
            }
          }
          localObject2 = new LinkedHashMap();
          Collections.sort((List)localObject5, new TroopMemberListActivity.JobComparator());
          Collections.sort((List)localObject3, new TroopMemberListActivity.JobComparator());
          i = 0;
          label2809:
          if (i >= ((List)localObject5).size()) {
            break label3423;
          }
          localObject6 = (String)((List)localObject5).get(i);
          if ((localObject6 == null) || (((LinkedHashMap)localObject4).get(localObject6) == null)) {
            break label3414;
          }
          Collections.sort((List)((LinkedHashMap)localObject4).get(localObject6), new TroopMemberListActivity.MyComparator(5, false));
          ((LinkedHashMap)localObject2).put(localObject6, ((LinkedHashMap)localObject4).get(localObject6));
          break label3414;
        }
      }
    }
    for (;;)
    {
      if (i < ((List)localObject3).size())
      {
        localObject5 = (String)((List)localObject3).get(i);
        if ((localObject5 != null) && (((LinkedHashMap)localObject4).get(localObject5) != null))
        {
          Collections.sort((List)((LinkedHashMap)localObject4).get(localObject5), new TroopMemberListActivity.MyComparator(5, false));
          ((LinkedHashMap)localObject2).put(localObject5, ((LinkedHashMap)localObject4).get(localObject5));
        }
      }
      else
      {
        if (((LinkedHashMap)localObject4).get("") != null)
        {
          Collections.sort((List)((LinkedHashMap)localObject4).get(""), new TroopMemberListActivity.MyComparator(5, false));
          ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131367397), ((LinkedHashMap)localObject4).get(""));
        }
        ((LinkedHashMap)localObject4).clear();
        break label1031;
        label3037:
        localObject3[0] = 0;
        i = 1;
        while (i < localObject3.length)
        {
          j = localObject3[i];
          k = localObject3[(i - 1)];
          localObject3[i] = (((List)((LinkedHashMap)localObject2).get(((Iterator)localObject5).next())).size() + k + 1 + j);
          i += 1;
        }
        localObject5 = ((LinkedHashMap)localObject2).keySet().iterator();
        i = 0;
        while (((Iterator)localObject5).hasNext())
        {
          localObject4[i] = ((String)((Iterator)localObject5).next());
          i += 1;
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "constructHashStruct, time:" + (l2 - l1) + ", sortType:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.W + ", listSize:" + paramList.size());
        }
        return new Object[] { localObject2, localObject3, localObject4 };
        localObject2 = localObject4;
        break label1031;
        label3259:
        break label1869;
        break label3307;
        label3265:
        localObject2 = "#";
        break;
        label3273:
        if ((97 <= i) && (i <= 122)) {
          break label505;
        }
        localObject3 = "#";
        break label512;
        label3298:
        i = 1;
        j = 1;
        break label816;
        label3307:
        j += 1;
        break label816;
        label3316:
        i += 1;
        break label744;
        label3325:
        c = 'A';
        break label900;
        label3332:
        c = (char)(c + '\001');
        break label900;
        label3342:
        i += 1;
        break label1257;
        label3351:
        i -= 1;
        break label1334;
        label3360:
        i += 1;
        break label1588;
        label3369:
        i -= 1;
        break label1665;
        label3378:
        break label1869;
        label3381:
        i -= 1;
        break label2047;
        label3390:
        i = 0;
        break label2129;
        label3396:
        i += 1;
        break label2129;
        label3405:
        i += 1;
        break label2463;
        label3414:
        i += 1;
        break label2809;
        label3423:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public String b(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramLong > 0L) {
      localCalendar.setTimeInMillis(1000L * paramLong);
    }
    int i;
    for (;;)
    {
      i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
      if (i > 0) {
        break;
      }
      return paramArrayOfString[0];
      localCalendar.set(1, 2012);
      localCalendar.set(2, 5);
      localCalendar.set(5, 1);
    }
    if (i <= 7) {
      return paramArrayOfString[1];
    }
    if (i <= 30) {
      return paramArrayOfString[2];
    }
    if (i <= 90) {
      return paramArrayOfString[3];
    }
    if (i <= 180) {
      return paramArrayOfString[4];
    }
    if (i <= 365) {
      return paramArrayOfString[5];
    }
    if (i <= 730) {
      return paramArrayOfString[6];
    }
    if (i <= 1095) {
      return paramArrayOfString[7];
    }
    if (i <= 1825) {
      return paramArrayOfString[8];
    }
    if (i <= 2555) {
      return paramArrayOfString[9];
    }
    if (i <= 3650) {
      return paramArrayOfString[10];
    }
    return paramArrayOfString[11];
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 9) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList != null) {}
    }
    do
    {
      do
      {
        return 0;
        return this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 6) {
          break;
        }
      } while (this.jdField_a_of_type_ArrayOfInt.length == 0);
      i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
      return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
    } while (this.jdField_a_of_type_ArrayOfInt.length == 0);
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1 + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 6) && (getCount() - 1 == paramInt)) {}
    do
    {
      do
      {
        return null;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J != 9) {
          break;
        }
      } while ((paramInt < 0) || (paramInt > this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size() - 1));
      return this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    } while (i >= 0);
    int i = -(i + 1) - 1;
    return (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130905078, paramViewGroup, false);
      paramViewGroup = new TroopMemberListActivity.TmViewHolder(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_JavaLangString = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J != 6) || (getCount() - 1 != paramInt)) {
        break label251;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(8);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.h.setTag("");
      paramViewGroup.jdField_b_of_type_AndroidViewView.setTag("");
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag("");
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag("");
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(-1));
      localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131367399));
      mwa localmwa = new mwa(this);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(2131427352), 10, 13, 33);
      ((SpannableString)localObject).setSpan(localmwa, 10, 13, 33);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    label251:
    int i;
    for (;;)
    {
      return paramView;
      paramViewGroup = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 9)
      {
        localObject = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewGroup.h.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(((TroopMemberListActivity.ATroopMember)localObject).e);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(paramViewGroup, (TroopMemberListActivity.ATroopMember)localObject, a(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString), false);
        return paramView;
      }
      i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      if (i >= 0) {
        break label597;
      }
      i = -(i + 1) - 1;
      localObject = (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramViewGroup.h.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(((TroopMemberListActivity.ATroopMember)localObject).e);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
      if (((TroopMemberListActivity.ATroopMember)localObject).jdField_c_of_type_Boolean)
      {
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(((TroopMemberListActivity.ATroopMember)localObject).jdField_b_of_type_JavaLangString);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838437);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 12)
      {
        if (!this.jdField_a_of_type_JavaUtilList.contains(localObject)) {
          break label586;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(paramViewGroup, (TroopMemberListActivity.ATroopMember)localObject, a(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString), false);
      }
    }
    label586:
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
    label597:
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
    paramViewGroup.h.setTag("");
    paramViewGroup.jdField_b_of_type_AndroidViewView.setTag("");
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag("");
    paramViewGroup.jdField_a_of_type_AndroidViewView.setTag("");
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(-1));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 9) {
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setContentDescription("");
      return paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]) + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131367385, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      } else {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopMemberListActivity$ListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */