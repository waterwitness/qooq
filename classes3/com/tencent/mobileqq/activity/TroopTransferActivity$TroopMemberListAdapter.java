package com.tencent.mobileqq.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import myz;
import mzb;

public class TroopTransferActivity$TroopMemberListAdapter
  extends FacePreloadBaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  protected LayoutInflater a;
  public ArrayList a;
  
  public TroopTransferActivity$TroopMemberListAdapter(TroopTransferActivity paramTroopTransferActivity, Context paramContext, ArrayList paramArrayList)
  {
    super(paramContext, paramTroopTransferActivity.app, paramTroopTransferActivity.a, 1, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i;
    ArrayList localArrayList;
    int j;
    label76:
    Object localObject;
    if (paramArrayList == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      paramContext = new ArrayList();
      j = 0;
      if (j >= i) {
        break label277;
      }
      localObject = (String)paramArrayList.get(j);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches("\\d{5,}+\\|+\\d{1,2}", (CharSequence)localObject))) {
        break label130;
      }
    }
    for (;;)
    {
      j += 1;
      break label76;
      i = paramArrayList.size();
      break;
      label130:
      int k = ((String)localObject).indexOf('|');
      String str = ((String)localObject).substring(0, k);
      k = Integer.parseInt(((String)localObject).substring(k + 1));
      if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 1))
      {
        localObject = new TroopTransferActivity.TroopMemberItem();
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_Int = 1;
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString = str;
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_b_of_type_Int = k;
        localArrayList.add(localObject);
      }
      else if ((!TextUtils.isEmpty(str)) && ((k & 0x0) == 0))
      {
        localObject = new TroopTransferActivity.TroopMemberItem();
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_Int = 1;
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString = str;
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_b_of_type_Int = k;
        paramContext.add(localObject);
      }
    }
    label277:
    if (localArrayList.size() > 0)
    {
      paramArrayList = new TroopTransferActivity.TroopMemberItem();
      paramArrayList.jdField_a_of_type_Int = 0;
      paramArrayList.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilArrayList.add(0, paramArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    }
    if (paramContext.size() > 0)
    {
      paramArrayList = new TroopTransferActivity.TroopMemberItem();
      paramArrayList.jdField_a_of_type_Int = 0;
      paramArrayList.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramContext);
    }
    ThreadManager.a(new myz(this, paramTroopTransferActivity), 8, null, false);
  }
  
  public TroopTransferActivity.TroopMemberItem a(String paramString)
  {
    Object localObject = null;
    int i = 0;
    if ((localObject == null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localTroopMemberItem == null) || (!Utils.a(localTroopMemberItem.jdField_a_of_type_JavaLangString, paramString))) {
        break label62;
      }
      localObject = localTroopMemberItem;
    }
    label62:
    for (;;)
    {
      i += 1;
      break;
      return (TroopTransferActivity.TroopMemberItem)localObject;
    }
  }
  
  protected Object a(int paramInt)
  {
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localTroopMemberItem != null) {
      localFaceInfo.jdField_a_of_type_JavaLangString = localTroopMemberItem.jdField_a_of_type_JavaLangString;
    }
    return localFaceInfo;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject1 = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_a_of_type_Int == 0)) {
      return 0;
    }
    if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_a_of_type_Int == 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    if (i == 0) {
      if (paramView == null)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903393, paramViewGroup, false);
        paramView = new mzb(null);
        paramView.d = null;
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup);
        paramViewGroup.setTag(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
        if ((localTroopMemberItem == null) || (localTroopMemberItem.jdField_b_of_type_Int != 1)) {
          break label135;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131367351);
      }
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.jdField_a_of_type_AndroidWidgetTextView != null)) {
        paramViewGroup.setContentDescription(paramView.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      return paramViewGroup;
      Object localObject = (mzb)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      break;
      label135:
      if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_b_of_type_Int == 0))
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131369425);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText("");
        continue;
        if (i == 1)
        {
          if (paramView == null)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130905079, paramViewGroup, false);
            paramView.findViewById(2131305214).setVisibility(8);
            paramView.findViewById(2131301787).setVisibility(8);
            paramViewGroup = new mzb(null);
            paramViewGroup.d = ((ImageView)paramView.findViewById(2131298136));
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297466));
            paramView.setTag(paramViewGroup);
            label256:
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
            if (localTroopMemberItem == null) {
              break label345;
            }
            localObject = localTroopMemberItem.jdField_a_of_type_JavaLangString;
            label274:
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("0"))) {
              break label351;
            }
            paramViewGroup.d.setImageDrawable(ImageUtil.b());
            label302:
            if (localTroopMemberItem == null) {
              break label377;
            }
          }
          label345:
          label351:
          label377:
          for (localObject = localTroopMemberItem.jdField_b_of_type_JavaLangString;; localObject = "")
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            localObject = paramView;
            paramView = paramViewGroup;
            paramViewGroup = (ViewGroup)localObject;
            break;
            paramViewGroup = (mzb)paramView.getTag();
            break label256;
            localObject = null;
            break label274;
            paramViewGroup.jdField_b_of_type_JavaLangString = ((String)localObject);
            paramViewGroup.d.setImageBitmap(a(1, localTroopMemberItem.jdField_a_of_type_JavaLangString));
            break label302;
          }
        }
        localObject = null;
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopTransferActivity$TroopMemberListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */