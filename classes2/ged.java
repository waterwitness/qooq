import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.arrange.ui.EditMemberActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class ged
  extends CharDividedFacePreloadBaseAdapter
{
  public int a;
  public String a;
  public LinkedHashMap a;
  public int[] a;
  public String[] a;
  public int b;
  
  public ged(EditMemberActivity paramEditMemberActivity)
  {
    super(paramEditMemberActivity, paramEditMemberActivity.app, paramEditMemberActivity.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.getString(2131367383);
  }
  
  public int a()
  {
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
  
  public void a()
  {
    Object[] arrayOfObject = a(this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.jdField_a_of_type_JavaUtilList);
    if (arrayOfObject.length >= 3)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)arrayOfObject[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])arrayOfObject[2]);
      this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.runOnUiThread(new gee(this));
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramInt < 0) {
      paramInt = -(paramInt + 1) - 1;
    }
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      if ((localList != null) && (localList.size() > 1))
      {
        ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.getString(2131367385, new Object[] { Integer.valueOf(localList.size()) }));
        return;
      }
      ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public Object[] a(List paramList)
  {
    Object localObject4 = new LinkedHashMap();
    Object localObject5;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    ArrayList localArrayList3;
    TroopMemberListActivity.ATroopMember localATroopMember;
    try
    {
      localObject5 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      localArrayList3 = new ArrayList();
      this.b = 0;
      this.jdField_a_of_type_Int = 0;
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label381;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator.next();
        if (localATroopMember.jdField_a_of_type_Boolean) {
          ((List)localObject5).add(localATroopMember);
        }
        if (localATroopMember.b) {
          localArrayList3.add(localATroopMember);
        }
        if ((this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.c) && (!localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.app.a())) && (localATroopMember.d == 1L)) {
          localArrayList2.add(localATroopMember);
        }
        if (((this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.jdField_a_of_type_JavaLangString.equals(localATroopMember.jdField_a_of_type_JavaLangString))) && ((this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.b == null) || (!this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.b.contains(localATroopMember.jdField_a_of_type_JavaLangString)))) {
          break;
        }
        localArrayList1.add(localATroopMember);
      }
      if (localATroopMember.c == null) {
        break label1045;
      }
    }
    finally {}
    if (localATroopMember.c.length() == 0) {
      break label1045;
    }
    int i;
    for (;;)
    {
      localObject3 = localObject1;
      if (((String)localObject1).length() == 1)
      {
        i = ((String)localObject1).charAt(0);
        if ((65 > i) || (i > 90)) {
          break label1051;
        }
        label305:
        localObject3 = ((String)localObject1).toUpperCase();
      }
      label311:
      if (((LinkedHashMap)localObject4).get(localObject3) == null) {
        ((LinkedHashMap)localObject4).put(localObject3, new ArrayList());
      }
      this.b += 1;
      ((List)((LinkedHashMap)localObject4).get(localObject3)).add(localATroopMember);
      break;
      localObject2 = localATroopMember.c.substring(0, 1);
    }
    label381:
    Object localObject3 = new gef(this, 0, true);
    Object localObject2 = new LinkedHashMap();
    if (((List)localObject5).size() > 0)
    {
      Collections.sort((List)localObject5, (Comparator)localObject3);
      ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.getString(2131369584), localObject5);
    }
    if (localArrayList3.size() > 0)
    {
      Collections.sort(localArrayList3, (Comparator)localObject3);
      ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.getString(2131369595), localArrayList3);
    }
    if (localArrayList2.size() > 0)
    {
      Collections.sort(localArrayList2, (Comparator)localObject3);
      ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.getString(2131367392), localArrayList2);
    }
    int k = localArrayList1.size();
    label524:
    label596:
    int j;
    if (k > 0)
    {
      Collections.sort(localArrayList1, (Comparator)localObject3);
      i = 0;
      if (i < k)
      {
        localObject5 = (TroopMemberListActivity.ATroopMember)localArrayList1.get(i);
        if ((this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.jdField_a_of_type_JavaLangString.equals(((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_JavaLangString))) {
          break label1093;
        }
        localArrayList1.remove(i);
        localArrayList1.add(0, localObject5);
        break label1075;
        if (j < k)
        {
          localObject5 = (TroopMemberListActivity.ATroopMember)localArrayList1.get(j);
          if (this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.b.contains(((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_JavaLangString))
          {
            localArrayList1.remove(j);
            localArrayList1.add(i, localObject5);
            i += 1;
            break label1084;
          }
        }
        else
        {
          localObject5 = this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.getIntent();
          if (localObject5 != null)
          {
            if (((Intent)localObject5).getIntExtra("jump_from", 0) == 2) {
              this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.getString(2131364000);
            }
          }
          else
          {
            label704:
            ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_JavaLangString, localArrayList1);
            break label1102;
          }
        }
      }
    }
    for (;;)
    {
      if (c <= 'Z')
      {
        if (((LinkedHashMap)localObject4).get(String.valueOf(c)) == null) {
          break label1108;
        }
        this.jdField_a_of_type_Int += 1;
        Collections.sort((List)((LinkedHashMap)localObject4).get(String.valueOf(c)), (Comparator)localObject3);
        ((LinkedHashMap)localObject2).put(String.valueOf(c), ((LinkedHashMap)localObject4).get(String.valueOf(c)));
        break label1108;
        if (((Intent)localObject5).getIntExtra("jump_from", 0) != 1) {
          break label704;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.getString(2131364001);
        break label704;
      }
      if (((LinkedHashMap)localObject4).get("#") != null)
      {
        this.jdField_a_of_type_Int += 1;
        Collections.sort((List)((LinkedHashMap)localObject4).get("#"), (Comparator)localObject3);
        ((LinkedHashMap)localObject2).put("#", ((LinkedHashMap)localObject4).get("#"));
      }
      ((LinkedHashMap)localObject4).clear();
      paramList = new int[((LinkedHashMap)localObject2).keySet().size()];
      localObject3 = new String[paramList.length];
      localObject4 = ((LinkedHashMap)localObject2).keySet().iterator();
      if (paramList.length == 0) {
        return new Object[0];
      }
      paramList[0] = 0;
      i = 1;
      while (i < paramList.length)
      {
        j = paramList[i];
        k = paramList[(i - 1)];
        paramList[i] = (((List)((LinkedHashMap)localObject2).get(((Iterator)localObject4).next())).size() + k + 1 + j);
        i += 1;
      }
      localObject4 = ((LinkedHashMap)localObject2).keySet().iterator();
      i = 0;
      while (((Iterator)localObject4).hasNext())
      {
        localObject3[i] = ((String)((Iterator)localObject4).next());
        i += 1;
      }
      return new Object[] { localObject2, paramList, localObject3 };
      break label1084;
      label1045:
      localObject2 = "#";
      break;
      label1051:
      if ((97 <= i) && (i <= 122)) {
        break label305;
      }
      localObject3 = "#";
      break label311;
      label1075:
      i = 1;
      j = 1;
      break label596;
      label1084:
      j += 1;
      break label596;
      label1093:
      i += 1;
      break label524;
      label1102:
      char c = 'A';
      continue;
      label1108:
      c = (char)(c + '\001');
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130905078, paramViewGroup, false);
      paramViewGroup = new TroopMemberListActivity.TmViewHolder(paramView);
      paramView.setTag(paramViewGroup);
    }
    while (i < 0)
    {
      i = -(i + 1) - 1;
      localObject = (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramViewGroup.h.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.a(paramViewGroup, (TroopMemberListActivity.ATroopMember)localObject, a(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString), false);
      return paramView;
      paramViewGroup = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(8);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewGroup.h.setTag("");
    paramViewGroup.jdField_b_of_type_AndroidViewView.setTag("");
    paramViewGroup.jdField_a_of_type_AndroidViewView.setTag("");
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(-1));
    Object localObject = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
    if ((localObject != null) && (((List)localObject).size() > 1)) {
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]) + this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.getString(2131367385, new Object[] { Integer.valueOf(((List)localObject).size()) }));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setContentDescription("");
      return paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */