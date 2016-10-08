import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomSingleButtonDialog;

public class wcg
  extends BaseAdapter
{
  public wcg(QQCustomSingleButtonDialog paramQQCustomSingleButtonDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString != null) {
      return this.a.jdField_a_of_type_ArrayOfJavaLangString.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a.jdField_a_of_type_AndroidViewLayoutInflater == null) {
      this.a.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)this.a.getContext().getSystemService("layout_inflater"));
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903238, null);
      paramView = new wcl(this.a, null);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131297853));
      paramViewGroup.setTag(paramView);
    }
    paramView = (wcl)paramViewGroup.getTag();
    int i;
    int j;
    int k;
    int m;
    if (paramView.a != null)
    {
      paramView.a.setText(this.a.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      paramView.a.setOnClickListener(new wck(this.a, paramInt));
      i = paramView.a.getPaddingTop();
      j = paramView.a.getPaddingLeft();
      k = paramView.a.getPaddingRight();
      m = paramView.a.getPaddingBottom();
      if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 1) {
        break label207;
      }
      paramView.a.setBackgroundResource(2130838415);
    }
    for (;;)
    {
      paramView.a.setPadding(j, i, k, m);
      return paramViewGroup;
      label207:
      if (paramInt == 0) {
        paramView.a.setBackgroundResource(2130838416);
      } else if (paramInt == this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
        paramView.a.setBackgroundResource(2130838414);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */