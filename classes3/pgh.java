import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectActivityViewHolder;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.GridViewAdapter;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class pgh
  extends CharDividedFacePreloadBaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public pgh(PhoneContactTabView paramPhoneContactTabView, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new pgi(this);
  }
  
  private void a(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.o();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i();
  }
  
  private void c()
  {
    int k = 1;
    int j = 0;
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.e != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.e.size() > 0))
    {
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get("@") == null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put("@", new ArrayList());
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.e.iterator();
    }
    label96:
    label139:
    label341:
    label444:
    label832:
    label833:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_JavaUtilList.iterator();
        i = 0;
        if (((Iterator)localObject3).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject3).next();
          if (!((String)localObject2).equals(localPhoneContact.mobileNo)) {
            break label832;
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get("@")).add(localPhoneContact);
          i = 1;
        }
      }
      for (;;)
      {
        break label139;
        if (i != 0) {
          break label833;
        }
        localObject3 = new PhoneContact();
        ((PhoneContact)localObject3).mobileNo = ((String)localObject2);
        ((PhoneContact)localObject3).uin = null;
        ((PhoneContact)localObject3).name = ((String)localObject2);
        ((PhoneContact)localObject3).nickName = ((String)localObject2);
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get("@")).add(localObject3);
        break label96;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (PhoneContact)((Iterator)localObject2).next();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.e == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.e.contains(((PhoneContact)localObject3).mobileNo)))
          {
            if (TextUtils.isEmpty(((PhoneContact)localObject3).pinyinFirst))
            {
              localObject1 = "#";
              i = ((String)localObject1).charAt(0);
              if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
                break label444;
              }
            }
            for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
            {
              if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null) {
                this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
              }
              ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localObject3);
              break;
              localObject1 = ((PhoneContact)localObject3).pinyinFirst.substring(0, 1);
              break label341;
            }
          }
        }
        localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
        this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        localObject3 = (List)((LinkedHashMap)localObject1).get("@");
        if (localObject3 != null)
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(PhoneContactTabView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView), localObject3);
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.jdField_a_of_type_Boolean)
          {
            localObject2 = new ArrayList();
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((List)localObject2).add(a((PhoneContact)((Iterator)localObject3).next()));
            }
            a((List)localObject2);
          }
        }
        for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
          if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), ((LinkedHashMap)localObject1).get(String.valueOf(c)));
          }
        }
        if (((LinkedHashMap)localObject1).get("#") != null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject1).get("#"));
        }
        ((LinkedHashMap)localObject1).clear();
        this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
        localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
          break;
        }
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        i = k;
        while (i < this.jdField_a_of_type_ArrayOfInt.length)
        {
          localObject2 = this.jdField_a_of_type_ArrayOfInt;
          k = localObject2[i];
          int m = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
          localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + m + 1 + k);
          i += 1;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        i = j;
        while (((Iterator)localObject1).hasNext())
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
          i += 1;
        }
        break;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2130903393;
    }
    return 0;
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
  
  public ResultRecord a(PhoneContact paramPhoneContact)
  {
    String str2 = paramPhoneContact.name;
    String str1;
    if (TextUtils.isEmpty(paramPhoneContact.uin)) {
      str1 = "pstn" + paramPhoneContact.mobileNo;
    }
    while ((str1.startsWith("pstn")) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(str1, str2, 5, "-1")))
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(str1, str2, 5, "-1", paramPhoneContact.mobileNo);
      if (paramPhoneContact.uin.equals("0")) {
        str1 = paramPhoneContact.nationCode + paramPhoneContact.mobileCode;
      } else {
        str1 = paramPhoneContact.uin;
      }
    }
    if (str1.startsWith("+")) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(str1, str2, 4, "-1", paramPhoneContact.mobileNo);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(str1, str2, 0, "-1", paramPhoneContact.mobileNo);
  }
  
  protected Object a(int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    c();
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramInt < 0) {
      paramInt = -(paramInt + 1);
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  protected boolean a(FacePreloadBaseAdapter.ViewHolder paramViewHolder)
  {
    boolean bool2 = super.a(paramViewHolder);
    boolean bool1 = bool2;
    if ((paramViewHolder instanceof SelectActivityViewHolder))
    {
      paramViewHolder = (SelectActivityViewHolder)paramViewHolder;
      if ((bool2) && (!paramViewHolder.jdField_a_of_type_Boolean)) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
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
    return (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = SelectActivityViewHolder.a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_AndroidViewLayoutInflater, 2130903224);
    }
    paramView = (SelectActivityViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramViewGroup = (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      SelectActivityViewHolder.a(this, paramView, paramViewGroup);
      paramView.c.setText(paramViewGroup.name);
      paramView.f.setText(paramViewGroup.mobileNo);
      paramView.f.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramView.b))
      {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g;
        if (((localArrayList == null) || ((!localArrayList.contains(paramViewGroup.uin)) && (!localArrayList.contains(paramViewGroup.mobileNo)) && (!localArrayList.contains(paramView.b)))) && ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.jdField_a_of_type_JavaUtilArrayList == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.jdField_a_of_type_JavaUtilArrayList.contains(paramViewGroup.mobileNo)))) {
          break label362;
        }
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        label248:
        if ((AppSetting.j) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
        {
          if (!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label373;
          }
          localView.setContentDescription(paramViewGroup.name + "已选中,双击取消");
        }
        label302:
        paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramViewGroup;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.a()) {
          break label404;
        }
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return localView;
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break;
        label362:
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label248;
        label373:
        localView.setContentDescription(paramViewGroup.name + "未选中,双击选中");
        break label302;
        label404:
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewGroup = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131370201), new Object[] { paramViewGroup.toLowerCase() }));
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */