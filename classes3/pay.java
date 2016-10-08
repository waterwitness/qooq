import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.util.VideoAnimation;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.util.VersionUtils;
import com.tencent.widget.HorizontalListView;

class pay
  implements Runnable
{
  pay(pax parampax)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.C) {}
    for (;;)
    {
      return;
      NewFlowCameraActivity.b(this.a.a).setVisibility(8);
      if (!this.a.a.d)
      {
        this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.a.a.b.setVisibility(0);
        VideoAnimation.a(this.a.a.b, 0.1F, 1.2F, 0.1F, 1.2F, 400, null);
        if (VersionUtils.e()) {
          this.a.a.w();
        }
      }
      else
      {
        this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        Object localObject = this.a.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(1);
        if ((localObject instanceof PtvTemplateItemView))
        {
          localObject = (PtvTemplateManager.PtvTemplateInfo)((PtvTemplateItemView)localObject).getTag();
          if (TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject).iconurl)) {
            break label310;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          int i = AIOUtils.a(50.0F, this.a.a.getResources());
          GradientDrawable localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(this.a.a.getResources().getColor(2131427623));
          localGradientDrawable.setShape(1);
          localGradientDrawable.setSize(i, i);
          localURLDrawableOptions.mRequestWidth = i;
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mFailedDrawable = localGradientDrawable;
          localURLDrawableOptions.mLoadingDrawable = localGradientDrawable;
          localObject = URLDrawable.getDrawable(((PtvTemplateManager.PtvTemplateInfo)localObject).iconurl, localURLDrawableOptions);
          ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(i, i));
          ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
          this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        while (VersionUtils.e())
        {
          this.a.a.w();
          return;
          label310:
          if (((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals("0"))
          {
            this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843537);
            this.a.a.b.setVisibility(0);
            VideoAnimation.a(this.a.a.b, 0.1F, 1.2F, 0.1F, 1.2F, 400, null);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */