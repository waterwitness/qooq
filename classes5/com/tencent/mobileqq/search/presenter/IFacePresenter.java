package com.tencent.mobileqq.search.presenter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.view.IFaceView;

public abstract interface IFacePresenter
  extends IPresenter
{
  public abstract void a(IFaceModel paramIFaceModel, IFaceView paramIFaceView);
  
  public abstract void a(IFaceModel paramIFaceModel, IFaceView paramIFaceView, Bitmap paramBitmap);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\presenter\IFacePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */