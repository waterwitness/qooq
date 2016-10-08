package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ixb;

public class FaceLayer$FaceAndTextItem
  extends ixb
{
  final int jdField_a_of_type_Int;
  PointF jdField_a_of_type_AndroidGraphicsPointF;
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  PointF jdField_b_of_type_AndroidGraphicsPointF;
  String jdField_b_of_type_JavaLangString;
  int c;
  
  public FaceLayer$FaceAndTextItem(FaceLayer paramFaceLayer, Bitmap paramBitmap)
  {
    super(paramFaceLayer, paramBitmap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 12;
  }
  
  public FaceLayer$FaceAndTextItem(FaceLayer paramFaceLayer, Drawable paramDrawable)
  {
    super(paramFaceLayer, paramDrawable);
    this.jdField_a_of_type_Int = 12;
  }
  
  public FaceLayer$FaceAndTextItem(FaceLayer paramFaceLayer, FaceAndTextItem paramFaceAndTextItem, float paramFloat)
  {
    super(paramFaceLayer, paramFaceAndTextItem, paramFloat);
    this.jdField_a_of_type_Int = 12;
    this.jdField_a_of_type_JavaLangString = paramFaceAndTextItem.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramFaceAndTextItem.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_Int = paramFaceAndTextItem.jdField_b_of_type_Int;
    this.c = paramFaceAndTextItem.c;
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramFaceAndTextItem.jdField_a_of_type_AndroidGraphicsPointF.x, paramFaceAndTextItem.jdField_a_of_type_AndroidGraphicsPointF.y);
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF(paramFaceAndTextItem.jdField_b_of_type_AndroidGraphicsPointF.x, paramFaceAndTextItem.jdField_b_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_b_of_type_JavaLangString, paramFaceLayer.jdField_a_of_type_AndroidTextTextPaint, (int)(this.jdField_b_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsPointF.x), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(Canvas paramCanvas)
  {
    super.a(paramCanvas);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setColor(this.c);
    paramCanvas.save();
    paramCanvas.translate(-this.e / 2.0F, -this.f / 2.0F);
    paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y + (this.jdField_b_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidTextStaticLayout.getHeight()) / 2.0F);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e(FaceLayer.jdField_a_of_type_JavaLangString, "text is empty.");
      str = "";
    }
    SLog.b(FaceLayer.jdField_a_of_type_JavaLangString, "text:" + str);
    this.jdField_b_of_type_JavaLangString = str;
    this.jdField_a_of_type_JavaLangString = str;
    int j = (int)(this.jdField_b_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsPointF.x);
    int i = (int)(this.jdField_b_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsPointF.y);
    if ((j <= 0) || (i <= 0))
    {
      SLog.e(FaceLayer.jdField_a_of_type_JavaLangString, "textWidth or textHeight is illegal.");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    i = this.jdField_b_of_type_JavaLangString.length() - 1;
    if (this.jdField_b_of_type_JavaLangString.length() > 12)
    {
      this.jdField_b_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString.substring(0, 12) + "...");
      SLog.b(FaceLayer.jdField_a_of_type_JavaLangString, "text length > 12,substring:" + this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      i = 11;
    }
    while ((i > 0) && (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 1))
    {
      this.jdField_b_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString.substring(0, i) + "...");
      SLog.b(FaceLayer.jdField_a_of_type_JavaLangString, "line count:" + this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() + " > 1,delete the last char :" + this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      i -= 1;
    }
    SLog.b(FaceLayer.jdField_a_of_type_JavaLangString, "after set text , text:" + this.jdField_a_of_type_JavaLangString + ",drawText:" + this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.e();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\FaceLayer$FaceAndTextItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */