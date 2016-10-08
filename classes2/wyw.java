import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.BubblePopupWindow;

public class wyw
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public BubblePopupWindow a;
  public String a;
  
  public wyw(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new wyx(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramView.getTag());
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(i, "复制");
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new wyy(this));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */