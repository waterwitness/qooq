import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class nbh
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
{
  private static final int jdField_b_of_type_Int = 0;
  public int a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  
  public nbh(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.d = AIOUtils.a(17.0F, paramVisitorsActivity.getResources());
    this.e = AIOUtils.a(15.0F, paramVisitorsActivity.getResources());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.c = paramInt;
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903408, null);
    nbf localnbf = new nbf();
    localnbf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298457));
    localnbf.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131297005));
    localnbf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298469));
    localView.setTag(localnbf);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903390, paramViewGroup, false);
    nbe localnbe = new nbe();
    localnbe.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131298397));
    localnbe.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296790));
    localnbe.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298398));
    localnbe.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297741));
    localnbe.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298400));
    localnbe.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298399));
    localnbe.d = ((TextView)paramViewGroup.findViewById(2131298402));
    localnbe.e = ((TextView)paramViewGroup.findViewById(2131298395));
    localnbe.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298401));
    paramViewGroup.setTag(localnbe);
    return paramViewGroup;
  }
  
  private void a(Object paramObject, nbe paramnbe)
  {
    if (paramObject == null) {
      return;
    }
    CardProfile localCardProfile = (CardProfile)paramObject;
    String str1 = String.valueOf(localCardProfile.lEctID);
    paramnbe.jdField_a_of_type_JavaLangObject = localCardProfile;
    paramObject = StringUtil.e(String.valueOf(localCardProfile.strNick));
    paramnbe.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramObject);
    int i;
    if (localCardProfile.bAage > 0)
    {
      paramnbe.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localCardProfile.bAage));
      paramObject = paramnbe.jdField_b_of_type_AndroidWidgetTextView;
      if (localCardProfile.bSex != 1) {
        break label370;
      }
      i = 2130838634;
      label81:
      ((TextView)paramObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (localCardProfile.bSex != 1) {
        break label378;
      }
      paramnbe.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840962);
      label107:
      if ((localCardProfile.bConstellation != 0) && (localCardProfile.bConstellation <= 12)) {
        break label391;
      }
      paramnbe.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label132:
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.h;
      if (localCardProfile.type != 2) {
        break label426;
      }
      paramObject = "你";
      label152:
      paramObject = String.format(str2, new Object[] { paramObject, Short.valueOf(localCardProfile.bVoteCnt) });
      paramnbe.jdField_c_of_type_AndroidWidgetImageView.setTag(localCardProfile);
      paramnbe.e.setText((CharSequence)paramObject);
      if (localCardProfile.type != 2) {
        break label540;
      }
      if (localCardProfile.bAvailableCnt <= 0L) {
        break label433;
      }
      i = 0;
      label212:
      if ((i != 0) && (i != 2)) {
        break label494;
      }
      paramnbe.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (localCardProfile.bTodayVotedCnt <= 0L) {
        break label481;
      }
      paramnbe.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841110);
      label249:
      paramnbe.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
      label260:
      a(paramnbe, localCardProfile);
      VisitorsActivity.a(localCardProfile.stVipInfo, paramnbe.jdField_b_of_type_AndroidWidgetImageView, paramnbe.jdField_a_of_type_AndroidWidgetTextView);
      paramObject = (RelativeLayout.LayoutParams)paramnbe.d.getLayoutParams();
      if (paramnbe.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label595;
      }
      ((RelativeLayout.LayoutParams)paramObject).addRule(3, paramnbe.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramnbe.d.setLayoutParams((ViewGroup.LayoutParams)paramObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a.put(str1, paramnbe.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str1, localCardProfile.wFace, paramnbe.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramnbe.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label370:
      i = 2130838639;
      break label81;
      label378:
      paramnbe.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840973);
      break label107;
      label391:
      paramnbe.jdField_c_of_type_AndroidWidgetTextView.setText(ProfileCardUtil.a(localCardProfile.bConstellation));
      paramnbe.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130840975);
      paramnbe.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label132;
      label426:
      paramObject = "他";
      break label152;
      label433:
      if (localCardProfile.bTodayVotedCnt > 0L)
      {
        if (localCardProfile.bCloseNeighborVote == 1)
        {
          i = 1;
          break label212;
        }
        i = 2;
        break label212;
      }
      if (localCardProfile.bCloseNeighborVote == 0)
      {
        i = 3;
        break label212;
      }
      i = 4;
      break label212;
      label481:
      paramnbe.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841109);
      break label249;
      label494:
      if (QLog.isColorLevel()) {
        QLog.i("VisitorsActivity", 2, "getChildView not show vote :" + i);
      }
      paramnbe.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label260;
      label540:
      if ((localCardProfile.bCloseNeighborVote > 0) && (QLog.isColorLevel())) {
        QLog.i("VisitorsActivity", 2, "getChildView, closeVote:" + localCardProfile.lEctID);
      }
      paramnbe.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label260;
      label595:
      if (paramnbe.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)paramObject).addRule(3, paramnbe.jdField_c_of_type_AndroidWidgetTextView.getId());
      } else {
        ((RelativeLayout.LayoutParams)paramObject).addRule(3, paramnbe.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
      }
    }
  }
  
  private void a(nbe paramnbe, CardProfile paramCardProfile)
  {
    TextView localTextView = paramnbe.d;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramnbe.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      localLayoutParams.addRule(3, paramnbe.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams(localLayoutParams);
      paramCardProfile = paramCardProfile.getRichStatus();
      if ((paramCardProfile == null) || (paramCardProfile.isEmpty())) {
        break label157;
      }
      if (TextUtils.isEmpty(paramCardProfile.actionText)) {
        break label146;
      }
      VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity, localTextView, paramCardProfile.actionId);
    }
    for (;;)
    {
      paramnbe.jdField_a_of_type_Int = paramCardProfile.actionId;
      localTextView.setText(paramCardProfile.toSpannableString(null));
      localTextView.setVisibility(0);
      return;
      if (paramnbe.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        localLayoutParams.addRule(3, paramnbe.jdField_c_of_type_AndroidWidgetTextView.getId());
        break;
      }
      localLayoutParams.addRule(3, paramnbe.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
      label146:
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    label157:
    paramnbe.jdField_a_of_type_Int = 0;
    localTextView.setVisibility(8);
  }
  
  private void a(nbf paramnbf)
  {
    int j = 8;
    Object localObject = paramnbf.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131370686;
      ((TextView)localObject).setText(i);
      localObject = paramnbf.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label72;
      }
      i = 0;
      label39:
      ((ProgressBar)localObject).setVisibility(i);
      paramnbf = paramnbf.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label78;
      }
    }
    label72:
    label78:
    for (int i = j;; i = 0)
    {
      paramnbf.setVisibility(i);
      return;
      i = 2131368205;
      break;
      i = 8;
      break label39;
    }
  }
  
  public int a()
  {
    return 2130904261;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = (nbg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
    localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((nbg)localObject).jdField_a_of_type_Int);
    if ((localObject != null) || (((List)localObject).size() > 0)) {}
    for (paramInt1 = ((List)localObject).size();; paramInt1 = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 > paramInt1 - 1))
      {
        if (this.b) {
          i = 1;
        }
      }
      else {
        return i;
      }
      return 2;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    nbi localnbi2 = (nbi)paramView.getTag();
    nbi localnbi1 = localnbi2;
    if (localnbi2 == null)
    {
      localnbi1 = new nbi(this, null);
      localnbi1.a = ((SingleLineTextView)paramView.findViewById(2131302089));
      int i = paramView.getResources().getColor(2131428199);
      ((ImageView)paramView.findViewById(2131302090)).setBackgroundColor(i);
    }
    localnbi1.a.setText(((nbg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet profiles empty:" + paramList);
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    int i = 0;
    label65:
    if (i < paramList.size())
    {
      localObject1 = (CardProfile)paramList.get(i);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a((CardProfile)localObject1);
      if (localObject2 == null) {
        break label443;
      }
      localObject3 = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((nbg)localObject2).jdField_a_of_type_Int);
      if (localObject3 != null) {
        break label291;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      localObject3 = new ArrayList();
      ((List)localObject3).add(localObject1);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(((nbg)localObject2).jdField_a_of_type_Int, localObject3);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("add new group, groupId:").append(((nbg)localObject2).jdField_a_of_type_Int).append(", groupName:").append(((nbg)localObject2).jdField_a_of_type_JavaLangString).append(", profile:");
        if (localObject1 != null) {
          break label238;
        }
        localObject1 = null;
        QLog.d("VisitorsActivity", 2, (String)localObject1);
      }
    }
    label238:
    label291:
    label443:
    while (!QLog.isColorLevel())
    {
      do
      {
        Object localObject3;
        for (;;)
        {
          i += 1;
          break label65;
          break;
          localObject1 = ",uin:" + ((CardProfile)localObject1).lEctID + ", ltime:" + ((CardProfile)localObject1).lTime + ",sTime:" + ((CardProfile)localObject1).strTime;
        }
        ((List)localObject3).add(localObject1);
        this.jdField_a_of_type_AndroidUtilSparseArray.setValueAt(this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(((nbg)localObject2).jdField_a_of_type_Int), localObject3);
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("update group, groupId:").append(((nbg)localObject2).jdField_a_of_type_Int).append(", groupName:").append(((nbg)localObject2).jdField_a_of_type_JavaLangString).append(", profile:");
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ",uin:" + ((CardProfile)localObject1).lEctID + ", ltime:" + ((CardProfile)localObject1).lTime + ",sTime:" + ((CardProfile)localObject1).strTime)
      {
        QLog.d("VisitorsActivity", 2, (String)localObject1);
        break;
      }
    }
    Object localObject2 = new StringBuilder().append("group null, profile:");
    if (localObject1 == null) {}
    for (Object localObject1 = null;; localObject1 = ",uin:" + ((CardProfile)localObject1).lEctID + ", ltime:" + ((CardProfile)localObject1).lTime + ",sTime:" + ((CardProfile)localObject1).strTime)
    {
      QLog.d("VisitorsActivity", 2, (String)localObject1);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = (nbg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
    localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((nbg)localObject).jdField_a_of_type_Int);
    if ((localObject != null) && (paramInt2 < ((List)localObject).size())) {
      return ((List)localObject).get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    if (localObject == null) {
      return 0L;
    }
    if ((localObject instanceof CardProfile)) {
      return ((CardProfile)localObject).lEctID;
    }
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    switch (a(paramInt1, paramInt2))
    {
    default: 
      return paramView;
    case 0: 
      if (paramInt2 > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = paramInt2;
      }
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof nbe)) {}
      }
      else
      {
        localView = a(paramViewGroup);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramView = (nbe)localView.getTag();
      a(getChild(paramInt1, paramInt2), paramView);
      return localView;
    case 1: 
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if ((paramView.getTag() instanceof nbf)) {}
      }
      else
      {
        paramViewGroup = a();
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      a((nbf)paramViewGroup.getTag());
      return paramViewGroup;
    }
    if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
      this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
    }
    paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904266, null);
    ((TextView)paramView.findViewById(2131302100)).setText(this.jdField_a_of_type_JavaLangString);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    Object localObject = (nbg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((nbg)localObject).jdField_a_of_type_Int);
    if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
    {
      if (localObject == null) {
        return 0;
      }
      return ((List)localObject).size() + 1;
    }
    if (localObject == null) {}
    for (paramInt = i;; paramInt = ((List)localObject).size()) {
      return paramInt;
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return ((nbg)getGroup(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = new nbi(this, null);
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity).inflate(2130904261, paramViewGroup, false);
      paramView.a = ((SingleLineTextView)localView.findViewById(2131302089));
      localView.setTag(paramView);
    }
    ((nbi)localView.getTag()).a.setText(((nbg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */