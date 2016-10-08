import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.BindGroupActivity.ViewHolder;

public class wqh
  implements Runnable
{
  public wqh(BindGroupActivity paramBindGroupActivity, String paramString, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        BindGroupActivity.ViewHolder localViewHolder = (BindGroupActivity.ViewHolder)this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity.a.getChildAt(i).getTag();
        if ((localViewHolder != null) && (this.jdField_a_of_type_JavaLangString.equals(localViewHolder.jdField_a_of_type_JavaLangString))) {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */