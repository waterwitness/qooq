import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.CornerListItemHolder;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lrr
  implements Runnable
{
  lrr(lrq paramlrq, String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Lrq.a.a == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        int j = this.jdField_a_of_type_Lrq.a.a.getChildCount();
        int i = 0;
        if (i < j)
        {
          localObject = this.jdField_a_of_type_Lrq.a.a.getChildAt(i);
          LebaListViewAdapter.CornerListItemHolder localCornerListItemHolder = (LebaListViewAdapter.CornerListItemHolder)((View)localObject).getTag();
          if ((localCornerListItemHolder == null) || (localCornerListItemHolder.a == null) || (localCornerListItemHolder.a.a == null) || (!this.jdField_a_of_type_JavaLangString.equals(localCornerListItemHolder.a.a.strPkgName))) {}
          for (;;)
          {
            i += 1;
            break;
            localObject = (ImageView)((View)localObject).findViewById(2131298129);
            if ((localObject != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
              ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
            }
          }
        }
      } while (this.jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Lrq.a.a.findViewWithTag(this.jdField_a_of_type_JavaLangString);
    } while ((localObject == null) || (!(localObject instanceof ImageView)) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null));
    ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */