import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomSingleChoiceDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class wcn
  implements AdapterView.OnItemClickListener
{
  public wcn(QQCustomSingleChoiceDialog paramQQCustomSingleChoiceDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_Int = paramInt;
    QQCustomSingleChoiceDialog.a(this.a).notifyDataSetChanged();
    this.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.a, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */