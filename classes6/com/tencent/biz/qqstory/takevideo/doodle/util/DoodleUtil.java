package com.tencent.biz.qqstory.takevideo.doodle.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item.ItemParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DoodleUtil
{
  public static final String a = "DoodleUtil";
  
  public DoodleUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static FaceLayer.LayerParams a(LocationFacePackage.Item paramItem, int paramInt1, int paramInt2)
  {
    if (!a(paramItem)) {
      return null;
    }
    SLog.b("DoodleUtil", "item:" + paramItem.toString());
    int j = 0;
    int i = 0;
    float f4;
    float f3;
    float f1;
    float f2;
    float f5;
    Object localObject;
    int k;
    if (paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      j = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      i = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
      f4 = paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.j;
      f3 = paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.k;
      f1 = paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.l;
      f2 = paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.m;
      f1 = paramInt1 / f1;
      f2 = paramInt2 / f2;
      f5 = f4 * f1 / j;
      localObject = paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams;
      k = ((LocationFacePackage.Item.ItemParams)localObject).h;
      if ((!a(k, 64)) && (!a(k, 48))) {
        break label438;
      }
      SLog.b("DoodleUtil", "align--> CENTER");
      f2 = paramInt1 / 2;
      f1 = paramInt2 / 2;
    }
    for (;;)
    {
      localObject = new FaceLayer.LayerParams();
      ((FaceLayer.LayerParams)localObject).jdField_a_of_type_AndroidGraphicsPointF.x = f2;
      ((FaceLayer.LayerParams)localObject).jdField_a_of_type_AndroidGraphicsPointF.y = f1;
      ((FaceLayer.LayerParams)localObject).jdField_a_of_type_Float = f5;
      ((FaceLayer.LayerParams)localObject).jdField_a_of_type_JavaLangString = paramItem.b;
      ((FaceLayer.LayerParams)localObject).jdField_b_of_type_AndroidGraphicsPointF.x = (paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.b[0] / f4 * j);
      ((FaceLayer.LayerParams)localObject).jdField_b_of_type_AndroidGraphicsPointF.y = (paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.b[1] / f3 * i);
      PointF localPointF = ((FaceLayer.LayerParams)localObject).c;
      f1 = paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.c[0] / f4;
      localPointF.x = (j * f1);
      ((FaceLayer.LayerParams)localObject).c.y = (paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.c[1] / f3 * i);
      ((FaceLayer.LayerParams)localObject).jdField_a_of_type_Int = Color.parseColor(paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_JavaLangString);
      f1 = paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.i / f3;
      ((FaceLayer.LayerParams)localObject).jdField_b_of_type_Int = ((int)(i * f1));
      ((FaceLayer.LayerParams)localObject).jdField_a_of_type_Boolean = true;
      SLog.b("DoodleUtil", "LayerParams:" + ((FaceLayer.LayerParams)localObject).toString());
      return (FaceLayer.LayerParams)localObject;
      if (paramItem.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break;
      }
      j = paramItem.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      i = paramItem.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      break;
      label438:
      if ((a(k, 18)) || (a(k, 16)))
      {
        SLog.b("DoodleUtil", "align--> CENTER_HORIZONTAL | TOP");
        paramInt2 = localObject.jdField_a_of_type_ArrayOfInt[1];
        f2 = paramInt1 / 2;
        f1 = f1 * paramInt2 + i / 2 * f5;
      }
      else if (a(k, 24))
      {
        SLog.b("DoodleUtil", "align--> CENTER_HORIZONTAL | BOTTOM");
        k = localObject.jdField_a_of_type_ArrayOfInt[3];
        f2 = paramInt1 / 2;
        f1 = paramInt2 - (f1 * k + i / 2 * f5);
      }
      else if ((a(k, 33)) || (a(k, 32)))
      {
        SLog.b("DoodleUtil", "align--> CENTER_VERTICAL | LEFT");
        f2 = localObject.jdField_a_of_type_ArrayOfInt[0];
        f2 = j / 2 * f5 + f1 * f2;
        f1 = paramInt2 / 2;
      }
      else if (a(k, 36))
      {
        SLog.b("DoodleUtil", "align--> CENTER_VERTICAL | RIGHT");
        k = localObject.jdField_a_of_type_ArrayOfInt[2];
        f2 = paramInt1 - (f1 * k + j / 2 * f5);
        f1 = paramInt2 / 2;
      }
      else if ((a(k, 3)) || (a(k, 1)) || (a(k, 2)) || (k == 0))
      {
        SLog.b("DoodleUtil", "align--> LEFT | TOP");
        paramInt1 = localObject.jdField_a_of_type_ArrayOfInt[0];
        paramInt2 = localObject.jdField_a_of_type_ArrayOfInt[1];
        f2 = paramInt1 * f1 + j / 2 * f5;
        f1 = f1 * paramInt2 + i / 2 * f5;
      }
      else if ((a(k, 6)) || (a(k, 4)))
      {
        SLog.b("DoodleUtil", "align--> RIGHT | TOP");
        paramInt2 = localObject.jdField_a_of_type_ArrayOfInt[2];
        k = localObject.jdField_a_of_type_ArrayOfInt[1];
        f2 = paramInt1 - (paramInt2 * f1 + j / 2 * f5);
        f1 = f1 * k + i / 2 * f5;
      }
      else if ((a(k, 9)) || (a(k, 8)))
      {
        SLog.b("DoodleUtil", "align--> LEFT | BOTTOM");
        paramInt1 = localObject.jdField_a_of_type_ArrayOfInt[0];
        k = localObject.jdField_a_of_type_ArrayOfInt[3];
        f2 = paramInt1 * f1 + j / 2 * f5;
        f1 = paramInt2 - (f1 * k + i / 2 * f5);
      }
      else
      {
        if (!a(k, 12)) {
          break label983;
        }
        SLog.b("DoodleUtil", "align--> RIGHT | BOTTOM");
        k = localObject.jdField_a_of_type_ArrayOfInt[2];
        int m = localObject.jdField_a_of_type_ArrayOfInt[3];
        f2 = paramInt1 - (k * f1 + j / 2 * f5);
        f1 = paramInt2 - (f1 * m + i / 2 * f5);
      }
    }
    label983:
    SLog.e("DoodleUtil", "align attribute is error,align:" + k);
    return null;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 & paramInt2) == paramInt2) && (((paramInt2 ^ 0xFFFFFFFF) & paramInt1) == 0);
  }
  
  public static boolean a(LocationFacePackage.Item paramItem)
  {
    if (paramItem == null)
    {
      SLog.e("DoodleUtil", "item is null.");
      return false;
    }
    if ((paramItem.jdField_a_of_type_AndroidGraphicsBitmap == null) && (paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      SLog.e("DoodleUtil", "item bitmap and drawable all null,can't draw.");
      return false;
    }
    if (TextUtils.isEmpty(paramItem.e))
    {
      SLog.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    if (!paramItem.a())
    {
      SLog.e("DoodleUtil", "parseJson error:" + paramItem.e);
      return false;
    }
    if (paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.i < 0)
    {
      SLog.e("DoodleUtil", "item textSize < 0. textSize:" + paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.i);
      return false;
    }
    if ((paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.j <= 0) || (paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.k <= 0))
    {
      SLog.e("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.j + ",pictureHeight:" + paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.k);
      return false;
    }
    if ((paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.l <= 0) || (paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.m <= 0))
    {
      SLog.e("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.l + ",standardHeight:" + paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.m);
      return false;
    }
    try
    {
      Color.parseColor(paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (Exception localException)
    {
      SLog.e("DoodleUtil", "item color is illegal:" + paramItem.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_JavaLangString);
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\util\DoodleUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */