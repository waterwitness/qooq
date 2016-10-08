import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.PokeItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nnf
  implements Runnable
{
  public static int b;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  public static int g = 5;
  public static int h = 6;
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  public boolean a;
  Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = null;
  private int i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public nnf(ImageView paramImageView, Drawable[] paramArrayOfDrawable, Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramArrayOfDrawable;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void run()
  {
    if ((this.i >= 0) && (this.i < 15)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[this.i]);
    }
    if ((this.jdField_a_of_type_Int == b) && (this.i == 0))
    {
      this.jdField_a_of_type_Int = c;
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 350L);
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Int == c) && (this.i != 15))
        {
          this.i += 1;
          this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 20L);
          return;
        }
        if ((this.jdField_a_of_type_Int == c) && (this.i == 15))
        {
          this.jdField_a_of_type_Int = d;
          this.i = 13;
          this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 20L);
          return;
        }
        if ((this.jdField_a_of_type_Int == d) && (this.i != 7))
        {
          this.i -= 1;
          this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 20L);
          return;
        }
        if ((this.jdField_a_of_type_Int == d) && (this.i == 7))
        {
          this.jdField_a_of_type_Int = e;
          this.i = 7;
          this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 20L);
          return;
        }
        if ((this.jdField_a_of_type_Int == e) && (this.i != 15))
        {
          this.i += 1;
          this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 20L);
          return;
        }
        if ((this.jdField_a_of_type_Int == e) && (this.i == 15))
        {
          this.i = 13;
          this.jdField_a_of_type_Int = f;
          this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 20L);
          return;
        }
        if ((this.jdField_a_of_type_Int == f) && (this.i != 0))
        {
          this.i -= 1;
          this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 20L);
          return;
        }
        if ((this.jdField_a_of_type_Int == f) && (this.i == 0))
        {
          this.jdField_a_of_type_Int = g;
          this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(this, 20L);
          return;
        }
        if (this.jdField_a_of_type_Int == g)
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_Int = c;
            this.i = 1;
            this.jdField_a_of_type_AndroidWidgetImageView.post(this);
            return;
          }
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Int = h;
          this.jdField_a_of_type_AndroidWidgetImageView.post(this);
          return;
        }
      } while (this.jdField_a_of_type_Int != h);
      this.jdField_a_of_type_Int = b;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    } while (this.jdField_a_of_type_JavaLangRunnable == null);
    PokeItemBuilder.a().post(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */