import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.ranking.ShowLoveEditorActivity;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class tqu
  extends AsyncTask
{
  private int jdField_a_of_type_Int;
  
  private tqu(ShowLoveEditorActivity paramShowLoveEditorActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      return 1;
    }
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int i = 1;
    if ((j > paramInt2) || (k > paramInt1))
    {
      int n = Math.round(j / paramInt2);
      int i1 = Math.round(k / paramInt1);
      if (n > i1) {}
      for (int m = n;; m = i1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_bank", 4, "heightRatio:" + n + ",widthRatio:" + i1 + ",ratio:" + m);
        }
        if (m < 2) {
          break label166;
        }
        k /= 2;
        j /= 2;
        i *= 2;
        break;
      }
    }
    label166:
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_bank", 4, "inSampleSize:" + i);
    }
    return i;
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = new BitmapFactory.Options();
      paramVarArgs.inPreferredConfig = Bitmap.Config.RGB_565;
      paramVarArgs.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.e, paramVarArgs);
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.getResources().getDisplayMetrics().widthPixels;
      int i = this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.getResources().getDisplayMetrics().heightPixels;
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.b = (this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.jdField_a_of_type_Float * (paramVarArgs.outHeight / paramVarArgs.outWidth));
      DatingUtil.c("showloveedit", new Object[] { "decode pic h/w = " + paramVarArgs.outHeight / paramVarArgs.outWidth + " width = " + this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.jdField_a_of_type_Float });
      int j = this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.getResources().getDisplayMetrics().densityDpi / 160;
      i -= AIOUtils.a(175.0F, this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.getResources());
      if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.b > i) {
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.b = i;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("showloveedit", 4, "imagew:" + this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.jdField_a_of_type_Float + ",imageh:" + this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.b + "max " + i);
      }
      paramVarArgs.inSampleSize = a(paramVarArgs, (int)this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.jdField_a_of_type_Float, (int)this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.b);
      paramVarArgs.inJustDecodeBounds = false;
      paramVarArgs = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.e, paramVarArgs);
      paramVarArgs = new ExifBitmapCreator(this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.e).a(paramVarArgs);
      return paramVarArgs;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      this.jdField_a_of_type_Int = 1;
      return null;
    }
    catch (Exception paramVarArgs)
    {
      this.jdField_a_of_type_Int = 2;
      DatingUtil.c("showloveedit", new Object[] { "decode get exception" + paramVarArgs.getStackTrace() + "  /n " + paramVarArgs.getMessage() });
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    float f2 = 1.0F;
    Object localObject;
    float f3;
    float f1;
    if ((paramBitmap != null) && (paramBitmap.getHeight() > 0) && (paramBitmap.getWidth() > 0))
    {
      localObject = new Matrix();
      f3 = this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.jdField_a_of_type_Float / paramBitmap.getWidth();
      f1 = this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.b / paramBitmap.getHeight();
      float f4 = Math.min(f3, f1);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.nearby_bank", 4, "wRadio:" + f3 + ",hRadio:" + f1 + ",defaultScale:" + f4);
      }
      f1 = f4;
      if (f4 >= 1.0F) {
        f1 = 1.0F;
      }
      if (f3 < 1.0F) {
        break label285;
      }
    }
    for (;;)
    {
      ((Matrix)localObject).setScale(f2, f1);
      ((Matrix)localObject).postTranslate(this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.jdField_a_of_type_Float / 2.0F, this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.b / 2.0F);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, false);
      paramBitmap.recycle();
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      return;
      if (this.jdField_a_of_type_Int == 1) {
        QQToast.a(BaseApplication.getContext(), "内存不足，加载失败", 0).a();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleRankingShowLoveEditorActivity.finish();
        return;
        if (this.jdField_a_of_type_Int == 2) {
          QQToast.a(BaseApplication.getContext(), "图片加载失败", 0).a();
        } else {
          QQToast.a(BaseApplication.getContext(), "图片加载失败，图片可能已损坏", 0).a();
        }
      }
      label285:
      f2 = f3;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */