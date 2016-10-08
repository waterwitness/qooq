import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class lpg
  implements Runnable
{
  public lpg(IndividuationSetActivity paramIndividuationSetActivity, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.getResources(), 2130838205);
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), localBitmap1.getConfig());
      Canvas localCanvas = new Canvas(localBitmap2);
      Paint localPaint = new Paint();
      float[] arrayOfFloat = new float[20];
      float[] tmp55_53 = arrayOfFloat;
      tmp55_53[0] = 1.0F;
      float[] tmp59_55 = tmp55_53;
      tmp59_55[1] = 0.0F;
      float[] tmp63_59 = tmp59_55;
      tmp63_59[2] = 0.0F;
      float[] tmp67_63 = tmp63_59;
      tmp67_63[3] = 0.0F;
      float[] tmp71_67 = tmp67_63;
      tmp71_67[4] = 255.0F;
      float[] tmp76_71 = tmp71_67;
      tmp76_71[5] = 0.0F;
      float[] tmp80_76 = tmp76_71;
      tmp80_76[6] = 1.0F;
      float[] tmp85_80 = tmp80_76;
      tmp85_80[7] = 0.0F;
      float[] tmp90_85 = tmp85_80;
      tmp90_85[8] = 0.0F;
      float[] tmp95_90 = tmp90_85;
      tmp95_90[9] = 255.0F;
      float[] tmp101_95 = tmp95_90;
      tmp101_95[10] = 0.0F;
      float[] tmp106_101 = tmp101_95;
      tmp106_101[11] = 0.0F;
      float[] tmp111_106 = tmp106_101;
      tmp111_106[12] = 1.0F;
      float[] tmp116_111 = tmp111_106;
      tmp116_111[13] = 0.0F;
      float[] tmp121_116 = tmp116_111;
      tmp121_116[14] = 255.0F;
      float[] tmp127_121 = tmp121_116;
      tmp127_121[15] = 0.0F;
      float[] tmp132_127 = tmp127_121;
      tmp132_127[16] = 0.0F;
      float[] tmp137_132 = tmp132_127;
      tmp137_132[17] = 0.0F;
      float[] tmp142_137 = tmp137_132;
      tmp142_137[18] = 1.0F;
      float[] tmp147_142 = tmp142_137;
      tmp147_142[19] = 0.0F;
      tmp147_142;
      new ColorMatrix().set(arrayOfFloat);
      localPaint.setColorFilter(new ColorMatrixColorFilter(arrayOfFloat));
      localCanvas.drawBitmap(localBitmap1, new Matrix(), localPaint);
      new Handler(Looper.getMainLooper()).post(new lph(this, localBitmap2));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("qqBaseActivity", 1, "setNetworkErrorView OutOfMemoryError");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */