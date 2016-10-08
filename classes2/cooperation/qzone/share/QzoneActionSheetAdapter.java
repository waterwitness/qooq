package cooperation.qzone.share;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QzoneActionSheetAdapter
  extends BaseAdapter
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 0;
  public static final int j = 6;
  Context jdField_a_of_type_AndroidContentContext;
  final List jdField_a_of_type_JavaUtilList;
  
  public QzoneActionSheetAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static ActionSheet a(Context paramContext, QzoneActionSheetAdapter paramQzoneActionSheetAdapter, AdapterView.OnItemClickListener paramOnItemClickListener, ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    if (paramContext != null)
    {
      if (paramQzoneActionSheetAdapter == null) {
        return null;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2130904711, null);
      paramContext.setBackgroundResource(2130837530);
      paramContext.setAdapter(paramQzoneActionSheetAdapter);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localActionSheet.a(paramContext);
      localActionSheet.d(2131367262);
      localActionSheet.a(paramOnButtonClickListener);
      return localActionSheet;
    }
    return null;
  }
  
  public static QzoneActionSheetAdapter.ItemInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 6) {
        localObject1 = new QzoneActionSheetAdapter.ItemInfo();
      }
    }
    switch (paramInt)
    {
    default: 
      return (QzoneActionSheetAdapter.ItemInfo)localObject1;
    case 0: 
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).a = 0;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).b = 2131367175;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).c = 2130842126;
      return (QzoneActionSheetAdapter.ItemInfo)localObject1;
    case 1: 
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).a = 1;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).b = 2131367216;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).c = 2130842278;
      return (QzoneActionSheetAdapter.ItemInfo)localObject1;
    case 2: 
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).a = 2;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).b = 2131367179;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).c = 2130838116;
      return (QzoneActionSheetAdapter.ItemInfo)localObject1;
    case 3: 
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).a = 3;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).b = 2131367177;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).c = 2130838112;
      return (QzoneActionSheetAdapter.ItemInfo)localObject1;
    case 4: 
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).a = 4;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).b = 2131367199;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).c = 2130842705;
      return (QzoneActionSheetAdapter.ItemInfo)localObject1;
    case 5: 
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).a = 5;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).b = 2131367200;
      ((QzoneActionSheetAdapter.ItemInfo)localObject1).c = 2130842707;
      return (QzoneActionSheetAdapter.ItemInfo)localObject1;
    }
    ((QzoneActionSheetAdapter.ItemInfo)localObject1).a = 6;
    ((QzoneActionSheetAdapter.ItemInfo)localObject1).b = 2131367084;
    ((QzoneActionSheetAdapter.ItemInfo)localObject1).c = 2130842127;
    return (QzoneActionSheetAdapter.ItemInfo)localObject1;
  }
  
  public static QzoneActionSheetAdapter a(Context paramContext, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = paramArrayOfInt.length;
    int k = 0;
    while (k < m)
    {
      localArrayList.add(a(paramArrayOfInt[k]));
      k += 1;
    }
    paramContext = new QzoneActionSheetAdapter(paramContext);
    paramContext.a(localArrayList);
    return paramContext;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QzoneActionSheetAdapter.ItemInfo localItemInfo = (QzoneActionSheetAdapter.ItemInfo)paramList.next();
        if (localItemInfo != null) {
          this.jdField_a_of_type_JavaUtilList.add(localItemInfo);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    QzoneActionSheetAdapter.ItemInfo localItemInfo = (QzoneActionSheetAdapter.ItemInfo)getItem(paramInt);
    if (localItemInfo != null) {
      return localItemInfo.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QzoneActionSheetAdapter.ItemInfo localItemInfo = (QzoneActionSheetAdapter.ItemInfo)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904867, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131303845);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131303846);
    if (localItemInfo != null)
    {
      paramView.setImageResource(localItemInfo.c);
      localTextView.setText(localItemInfo.b);
      return paramViewGroup;
    }
    paramView.setImageResource(2130842277);
    localTextView.setText("");
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\share\QzoneActionSheetAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */