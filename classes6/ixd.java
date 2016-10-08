import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.State;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ixd
  implements TextLayer.State
{
  protected TextPaint a;
  protected TextInfo a;
  
  public ixd(TextLayer paramTextLayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo = new TextInfo();
  }
  
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint;
  }
  
  public TextInfo a()
  {
    TextInfo localTextInfo = new TextInfo();
    localTextInfo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo);
    return localTextInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.c = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a = "";
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.c);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.o);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.o = i;
        return;
      } while (j <= 5);
      TextLayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer, 3);
      return;
      if (j < 5)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.b();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.j != 3);
    TextLayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */